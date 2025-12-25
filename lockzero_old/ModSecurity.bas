B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=13.4
@EndOfDesignText@
'ModSecurity.bas - Módulo de Segurança
'LockSeed - Criptografia e configurações
'
'VERSÃO GOOGLE PLAY - Sistema de licenciamento removido
'Versão do app definida por Starter.APP_VERSION ("FREE", "PREMIUM")

Sub Process_Globals
	Private Const PIN_FILE As String = "lockseed_pin.dat"
	Private Const SETTINGS_FILE As String = "lockseed_settings.dat"

	' Constantes de versão (para compatibilidade)
	Public Const VERSION_FREE As Int = 0
	Public Const VERSION_PREMIUM As Int = 1

	' Sessão de frase-senha (para criptografia de campos)
	Private SessionPassphrase As String
	Private SessionWalletId As String
	Private SessionStartTime As Long

	' Limites FREE
	Public Const LIMIT_FREE_WALLETS As Int = 2
	Public Const LIMIT_FREE_ADDRESSES As Int = 3

	' Premium = ilimitado (usamos 99999)
	Public Const LIMIT_PREMIUM As Int = 99999
End Sub

' ============================================
'  VERSÃO DO APP (baseado em Starter.APP_VERSION)
' ============================================
Public Sub GetVersionType As Int
	Select Starter.APP_VERSION
		Case "FREE": Return VERSION_FREE
		Case "PREMIUM": Return VERSION_PREMIUM
		Case Else: Return VERSION_FREE
	End Select
End Sub

Public Sub GetVersionName As String
	Return Starter.APP_VERSION
End Sub

' ============================================
'  LIMITES POR VERSÃO
' ============================================
Public Sub GetWalletLimit As Int
	Select Starter.APP_VERSION
		Case "FREE": Return LIMIT_FREE_WALLETS
		Case "PREMIUM": Return LIMIT_PREMIUM
	End Select
	Return LIMIT_FREE_WALLETS
End Sub

Public Sub GetAddressLimit As Int
	Select Starter.APP_VERSION
		Case "FREE": Return LIMIT_FREE_ADDRESSES
		Case "PREMIUM": Return LIMIT_PREMIUM
	End Select
	Return LIMIT_FREE_ADDRESSES
End Sub

Public Sub CanCreateWallet(currentCount As Int) As Boolean
	Return currentCount < GetWalletLimit
End Sub

Public Sub CanCreateAddress(currentCount As Int) As Boolean
	Return currentCount < GetAddressLimit
End Sub

' Retorna texto formatado do limite (ex: "2" ou "Ilimitado")
Public Sub GetWalletLimitText As String
	Dim limit As Int = GetWalletLimit
	If limit >= LIMIT_PREMIUM Then Return ModLang.GetText("unlimited")
	Return limit
End Sub

Public Sub GetAddressLimitText As String
	Dim limit As Int = GetAddressLimit
	If limit >= LIMIT_PREMIUM Then Return ModLang.GetText("unlimited")
	Return limit
End Sub

' ============================================
'  FUNÇÕES DE PIN
' ============================================
Public Sub HasPIN As Boolean
	Return File.Exists(File.DirInternal, PIN_FILE)
End Sub

Public Sub SavePIN(pin As String)
	Dim su As StringUtils
	Dim data() As Byte = pin.GetBytes("UTF8")
	Dim encoded As String = su.EncodeBase64(data)
	File.WriteString(File.DirInternal, PIN_FILE, encoded)
End Sub

Public Sub ValidatePIN(inputPin As String) As Boolean
	If HasPIN = False Then Return False

	Try
		Dim encoded As String = File.ReadString(File.DirInternal, PIN_FILE)
		Dim su As StringUtils
		Dim data() As Byte = su.DecodeBase64(encoded)
		Dim savedPin As String = BytesToString(data, 0, data.Length, "UTF8")
		Return inputPin = savedPin
	Catch
		Return False
	End Try
End Sub

Public Sub RemovePIN
	If File.Exists(File.DirInternal, PIN_FILE) Then
		File.Delete(File.DirInternal, PIN_FILE)
	End If
End Sub

' ============================================
'  CONFIGURAÇÃO DE BIOMETRIA
' ============================================
Public Sub SetUseBiometric(use As Boolean)
	Dim settings As Map
	settings.Initialize
	settings = LoadSettings
	settings.Put("useBiometric", use)
	SaveSettings(settings)
End Sub

Public Sub GetUseBiometric As Boolean
	Dim settings As Map = LoadSettings
	Return settings.GetDefault("useBiometric", False)
End Sub

' ============================================
'  AUTO-COMPLETE BIP39
' ============================================
Public Sub SetAutoComplete(enabled As Boolean)
	Dim settings As Map = LoadSettings
	settings.Put("autoComplete", enabled)
	SaveSettings(settings)
End Sub

Public Sub GetAutoComplete As Boolean
	Dim settings As Map = LoadSettings
	Return settings.GetDefault("autoComplete", True)  ' Padrao: ativado
End Sub

Public Sub SetAutoConfirm(enabled As Boolean)
	Dim settings As Map = LoadSettings
	settings.Put("autoConfirm", enabled)
	SaveSettings(settings)
End Sub

Public Sub GetAutoConfirm As Boolean
	Dim settings As Map = LoadSettings
	Return settings.GetDefault("autoConfirm", True)  ' Padrao: confirmar automaticamente
End Sub

Private Sub LoadSettings As Map
	Dim settings As Map
	settings.Initialize

	If File.Exists(File.DirInternal, SETTINGS_FILE) Then
		Try
			Dim json As String = File.ReadString(File.DirInternal, SETTINGS_FILE)
			Dim parser As JSONParser
			parser.Initialize(json)
			settings = parser.NextObject
		Catch
			Log("Erro ao carregar settings: " & LastException)
		End Try
	End If

	Return settings
End Sub

Private Sub SaveSettings(settings As Map)
	Dim gen As JSONGenerator
	gen.Initialize(settings)
	File.WriteString(File.DirInternal, SETTINGS_FILE, gen.ToString)
End Sub

' ============================================
'  IDIOMA
' ============================================
Public Sub SaveLanguage(langIndex As Int)
	Dim settings As Map = LoadSettings
	settings.Put("language", langIndex)
	SaveSettings(settings)
End Sub

Public Sub GetLanguage As Int
	Dim settings As Map = LoadSettings
	Return settings.GetDefault("language", 0)  ' 0 = Português
End Sub

' Verifica se o usuário já escolheu o idioma (primeira instalação)
Public Sub IsLanguageChosen As Boolean
	Dim settings As Map = LoadSettings
	Return settings.GetDefault("languageChosen", False)
End Sub

' Marca que o usuário já escolheu o idioma
Public Sub SetLanguageChosen
	Dim settings As Map = LoadSettings
	settings.Put("languageChosen", True)
	SaveSettings(settings)
End Sub

' ============================================
'  TEMPO SESSAO SENHAS (1-5 MINUTOS)
' ============================================
Public Sub SavePasswordSessionMinutes(minutes As Int)
	If minutes < 1 Then minutes = 1
	If minutes > 5 Then minutes = 5
	Dim settings As Map = LoadSettings
	settings.Put("passwordSessionMinutes", minutes)
	SaveSettings(settings)
End Sub

Public Sub GetPasswordSessionMinutes As Int
	Dim settings As Map = LoadSettings
	Return settings.GetDefault("passwordSessionMinutes", 2)
End Sub

' ============================================
'  CRIPTOGRAFAR SENHA (AES-256)
' ============================================
Public Sub EncryptPassword(passPhrase As String, walletPass As String) As String
	If passPhrase.Length < 1 Or walletPass.Length < 1 Then Return ""

	Try
		Dim md As MessageDigest
		Dim keyBytes() As Byte = md.GetMessageDigest(passPhrase.GetBytes("UTF8"), "SHA-256")
		Dim ivBytes() As Byte = md.GetMessageDigest(StrReverse(passPhrase).GetBytes("UTF8"), "MD5")

		Dim c As Cipher
		Dim kg As KeyGenerator
		kg.Initialize("AES")
		kg.KeyFromBytes(keyBytes)

		c.Initialize("AES/CBC/PKCS5Padding")
		c.InitialisationVector = ivBytes

		Dim dataBytes() As Byte = walletPass.GetBytes("UTF8")
		Dim encrypted() As Byte = c.Encrypt(dataBytes, kg.Key, True)

		Dim su As StringUtils
		Return "AES:" & su.EncodeBase64(encrypted)

	Catch
		Log("Erro ao criptografar senha: " & LastException)
		Return ""
	End Try
End Sub

' ============================================
'  DESCRIPTOGRAFAR SENHA (AES-256)
' ============================================
Public Sub DecryptPassword(passPhrase As String, encPwd As String) As String
	If passPhrase.Length < 1 Or encPwd.Length < 1 Then Return ""

	Try
		If encPwd.StartsWith("AES:") = False Then
			Return DecryptPasswordLegacy(passPhrase, encPwd)
		End If

		Dim encData As String = encPwd.SubString(4)

		Dim md As MessageDigest
		Dim keyBytes() As Byte = md.GetMessageDigest(passPhrase.GetBytes("UTF8"), "SHA-256")
		Dim ivBytes() As Byte = md.GetMessageDigest(StrReverse(passPhrase).GetBytes("UTF8"), "MD5")

		Dim su As StringUtils
		Dim encrypted() As Byte = su.DecodeBase64(encData)

		Dim c As Cipher
		Dim kg As KeyGenerator
		kg.Initialize("AES")
		kg.KeyFromBytes(keyBytes)

		c.Initialize("AES/CBC/PKCS5Padding")
		c.InitialisationVector = ivBytes

		Dim decrypted() As Byte = c.Decrypt(encrypted, kg.Key, True)

		Return BytesToString(decrypted, 0, decrypted.Length, "UTF8")

	Catch
		Log("Erro ao descriptografar senha: " & LastException)
		Return ""
	End Try
End Sub

Private Sub DecryptPasswordLegacy(passPhrase As String, encPwd As String) As String
	Dim letters As List = ExtractSecretLetters(passPhrase)
	If letters.Size < 12 Then Return ""

	Dim key As String = ""
	For i = 0 To 11
		key = key & letters.Get(i)
	Next

	If encPwd.Length <= 12 Then Return ""

	Dim keyStart As String = encPwd.SubString2(0, 6)
	Dim keyEnd As String = encPwd.SubString(encPwd.Length - 6)

	If keyStart <> key.SubString2(0, 6) Or keyEnd <> key.SubString2(6, 12) Then
		Return ""
	End If

	Dim core As String = encPwd.SubString2(6, encPwd.Length - 6)

	Dim su As StringUtils
	Try
		Dim dataBytes() As Byte = su.DecodeBase64(core)
		Return BytesToString(dataBytes, 0, dataBytes.Length, "UTF8")
	Catch
		Return ""
	End Try
End Sub

Private Sub StrReverse(s As String) As String
	Dim sb As StringBuilder
	sb.Initialize
	For i = s.Length - 1 To 0 Step -1
		sb.Append(s.CharAt(i))
	Next
	Return sb.ToString
End Sub

' ============================================
'  LIMPAR DADOS SENSÍVEIS
' ============================================
Public Sub ClearString As String
	Return ""
End Sub

Public Sub ClearArray(arr() As String)
	For i = 0 To arr.Length - 1
		arr(i) = ""
	Next
End Sub

' ============================================
'  FUNÇÕES AUXILIARES
' ============================================
Private Sub ExtractSecretLetters(phrase As String) As List
	Dim out As List
	out.Initialize

	phrase = NormalizeASCII(phrase.ToUpperCase)

	Dim clean As String = ""
	For i = 0 To phrase.Length - 1
		Dim ch As String = phrase.CharAt(i)
		Dim code As Int = Asc(ch)
		If code >= Asc("A") And code <= Asc("Z") Then
			clean = clean & ch
		End If
	Next

	For i = 0 To clean.Length - 1
		Dim ch As String = clean.CharAt(i)
		If out.IndexOf(ch) = -1 Then
			out.Add(ch)
			If out.Size = 12 Then Exit
		End If
	Next

	Return out
End Sub

Private Sub NormalizeASCII(text As String) As String
	Dim r As String = text
	r = r.Replace("Á","A").Replace("À","A").Replace("Â","A").Replace("Ã","A").Replace("Ä","A")
	r = r.Replace("É","E").Replace("È","E").Replace("Ê","E").Replace("Ë","E")
	r = r.Replace("Í","I").Replace("Ì","I").Replace("Î","I").Replace("Ï","I")
	r = r.Replace("Ó","O").Replace("Ò","O").Replace("Ô","O").Replace("Õ","O").Replace("Ö","O")
	r = r.Replace("Ú","U").Replace("Ù","U").Replace("Û","U").Replace("Ü","U")
	r = r.Replace("Ç","C")
	Return r
End Sub

' ============================================
'  SESSÃO DE FRASE-SENHA
' ============================================

' Inicia sessão com frase-senha da carteira
Public Sub StartSession(walletId As String, passphrase As String)
	SessionWalletId = walletId
	SessionPassphrase = passphrase
	SessionStartTime = DateTime.Now
	Log("ModSecurity: Sessão iniciada para wallet " & walletId)
End Sub

' Verifica se sessão está válida para a carteira
Public Sub IsSessionValid(walletId As String) As Boolean
	If SessionWalletId <> walletId Then Return False
	If SessionPassphrase = "" Then Return False

	Dim elapsed As Long = (DateTime.Now - SessionStartTime) / 1000 / 60  ' minutos
	Dim maxMinutes As Int = GetPasswordSessionMinutes

	If elapsed > maxMinutes Then
		Log("ModSecurity: Sessão expirada (" & elapsed & " min > " & maxMinutes & " min)")
		ClearSession
		Return False
	End If

	Return True
End Sub

' Retorna frase-senha da sessão (se válida)
Public Sub GetSessionPassphrase(walletId As String) As String
	If IsSessionValid(walletId) Then
		Return SessionPassphrase
	End If
	Return ""
End Sub

' Limpa sessão
Public Sub ClearSession
	SessionWalletId = ""
	SessionPassphrase = ""
	SessionStartTime = 0
	Log("ModSecurity: Sessão limpa")
End Sub

' Renova timestamp da sessão (para manter ativa enquanto usuário usa)
Public Sub RenewSession
	If SessionPassphrase <> "" Then
		SessionStartTime = DateTime.Now
	End If
End Sub

' ============================================
'  CRIPTOGRAFIA DE CAMPOS (USERNAME, NOTES)
' ============================================

' Criptografa campo com frase-senha (usa mesmo algoritmo de EncryptPassword)
Public Sub EncryptField(passphrase As String, value As String) As String
	If passphrase.Length < 1 Or value.Length < 1 Then Return value
	Return EncryptPassword(passphrase, value)
End Sub

' Descriptografa campo com frase-senha
Public Sub DecryptField(passphrase As String, encValue As String) As String
	If passphrase.Length < 1 Or encValue.Length < 1 Then Return encValue

	' Se não está criptografado (não começa com "AES:"), retorna como está
	If encValue.StartsWith("AES:") = False Then Return encValue

	Return DecryptPassword(passphrase, encValue)
End Sub

' Verifica se valor está criptografado
Public Sub IsEncrypted(value As String) As Boolean
	Return value.StartsWith("AES:")
End Sub
