B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=9.85
@EndOfDesignText@
'ModSecurity.bas - Modulo de Seguranca
'LockZero - Lock and ZERO worries
'Criptografia AES-256 e funcoes de seguranca

Sub Process_Globals
	Private Const SETTINGS_FILE As String = "lockzero_settings.dat"
	Private Const PIN_FILE As String = "lockzero_pin.dat"
	Private Const ATTEMPTS_FILE As String = "lockzero_attempts.json"

	'Delays progressivos (em ms)
	Private DELAYS() As Int = Array As Int(0, 2000, 5000, 15000, 30000, 60000)
End Sub

' ============================================
'  CRIPTOGRAFIA AES-256
' ============================================

'Criptografa texto com frase-senha (AES-256-CBC)
Public Sub Encrypt(passPhrase As String, plainText As String) As String
	If passPhrase.Length < 1 Or plainText.Length < 1 Then Return ""

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

		Dim dataBytes() As Byte = plainText.GetBytes("UTF8")
		Dim encrypted() As Byte = c.Encrypt(dataBytes, kg.Key, True)

		Dim su As StringUtils
		Return "AES:" & su.EncodeBase64(encrypted)

	Catch
		Log("ModSecurity.Encrypt erro: " & LastException)
		Return ""
	End Try
End Sub

'Descriptografa texto com frase-senha (AES-256-CBC)
Public Sub Decrypt(passPhrase As String, encText As String) As String
	If passPhrase.Length < 1 Or encText.Length < 1 Then Return ""

	Try
		'Verifica prefixo AES
		If encText.StartsWith("AES:") = False Then Return ""

		Dim encData As String = encText.SubString(4)

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
		Log("ModSecurity.Decrypt erro: " & LastException)
		Return ""
	End Try
End Sub

'Verifica se texto esta criptografado
Public Sub IsEncrypted(value As String) As Boolean
	Return value.StartsWith("AES:")
End Sub

' ============================================
'  CRIPTOGRAFIA COM SALT (POR GRUPO)
' ============================================

'Criptografa com salt aleatorio do grupo
'passPhrase: frase ou PIN do grupo
'salt: salt aleatorio do grupo (hex string)
'plainText: texto a criptografar
Public Sub EncryptWithSalt(passPhrase As String, salt As String, plainText As String) As String
	If passPhrase.Length < 1 Or plainText.Length < 1 Or salt.Length < 1 Then Return ""

	Try
		'Combina frase com salt para derivar chave
		Dim combined As String = passPhrase & ":" & salt

		Dim md As MessageDigest
		Dim keyBytes() As Byte = md.GetMessageDigest(combined.GetBytes("UTF8"), "SHA-256")
		Dim ivBytes() As Byte = md.GetMessageDigest(salt.GetBytes("UTF8"), "MD5")

		Dim c As Cipher
		Dim kg As KeyGenerator
		kg.Initialize("AES")
		kg.KeyFromBytes(keyBytes)

		c.Initialize("AES/CBC/PKCS5Padding")
		c.InitialisationVector = ivBytes

		Dim dataBytes() As Byte = plainText.GetBytes("UTF8")
		Dim encrypted() As Byte = c.Encrypt(dataBytes, kg.Key, True)

		Dim su As StringUtils
		Return "AES:" & su.EncodeBase64(encrypted)

	Catch
		Log("ModSecurity.EncryptWithSalt erro: " & LastException)
		Return ""
	End Try
End Sub

'Descriptografa com salt do grupo
Public Sub DecryptWithSalt(passPhrase As String, salt As String, encText As String) As String
	If passPhrase.Length < 1 Or encText.Length < 1 Or salt.Length < 1 Then Return ""

	Try
		If encText.StartsWith("AES:") = False Then Return ""
		Dim encData As String = encText.SubString(4)

		Dim combined As String = passPhrase & ":" & salt

		Dim md As MessageDigest
		Dim keyBytes() As Byte = md.GetMessageDigest(combined.GetBytes("UTF8"), "SHA-256")
		Dim ivBytes() As Byte = md.GetMessageDigest(salt.GetBytes("UTF8"), "MD5")

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
		Log("ModSecurity.DecryptWithSalt erro: " & LastException)
		Return ""
	End Try
End Sub

'Gera salt aleatorio de 32 caracteres hex
Public Sub GenerateRandomSalt As String
	Dim uuid As String = GenerateUUID
	Return uuid.Replace("-", "").SubString2(0, 32)
End Sub

' ============================================
'  VALIDACAO DE PIN
' ============================================

'Valida se PIN tem formato correto (minimo 6 digitos)
Public Sub IsValidPIN(pin As String) As Boolean
	If pin.Length < 6 Then Return False

	'Verifica se e apenas numeros
	For i = 0 To pin.Length - 1
		Dim code As Int = Asc(pin.CharAt(i))
		If code < 48 Or code > 57 Then Return False  '48="0", 57="9"
	Next

	Return True
End Sub

'Valida se frase tem formato correto (minimo 8 caracteres)
Public Sub IsValidPhrase(phrase As String) As Boolean
	Return phrase.Length >= 8
End Sub

' ============================================
'  BRUTE FORCE PROTECTION
' ============================================

'Registra tentativa falha para um grupo
'Returns: delay em ms que deve esperar antes da proxima tentativa
Public Sub RegisterFailedAttempt(groupId As String) As Int
	Dim attempts As Map = LoadAttempts

	Dim groupData As Map
	If attempts.ContainsKey(groupId) Then
		groupData = attempts.Get(groupId)
	Else
		groupData.Initialize
		groupData.Put("count", 0)
		groupData.Put("lastFailed", 0)
	End If

	Dim count As Int = groupData.Get("count") + 1
	groupData.Put("count", count)
	groupData.Put("lastFailed", DateTime.Now)
	attempts.Put(groupId, groupData)

	SaveAttempts(attempts)

	'Retorna delay baseado no numero de tentativas
	Dim delayIndex As Int = Min(count - 1, DELAYS.Length - 1)
	If delayIndex < 0 Then delayIndex = 0
	Return DELAYS(delayIndex)
End Sub

'Reseta contador de tentativas (apos sucesso)
Public Sub ResetFailedAttempts(groupId As String)
	Dim attempts As Map = LoadAttempts
	If attempts.ContainsKey(groupId) Then
		attempts.Remove(groupId)
		SaveAttempts(attempts)
	End If
End Sub

'Retorna numero de tentativas falhas
Public Sub GetFailedAttempts(groupId As String) As Int
	Dim attempts As Map = LoadAttempts
	If attempts.ContainsKey(groupId) = False Then Return 0

	Dim groupData As Map = attempts.Get(groupId)
	Return groupData.GetDefault("count", 0)
End Sub

'Retorna delay restante antes de poder tentar novamente
Public Sub GetRemainingDelay(groupId As String) As Int
	Dim attempts As Map = LoadAttempts
	If attempts.ContainsKey(groupId) = False Then Return 0

	Dim groupData As Map = attempts.Get(groupId)
	Dim count As Int = groupData.GetDefault("count", 0)
	Dim lastFailed As Long = groupData.GetDefault("lastFailed", 0)

	If count = 0 Then Return 0

	Dim delayIndex As Int = Min(count - 1, DELAYS.Length - 1)
	If delayIndex < 0 Then Return 0

	Dim requiredDelay As Int = DELAYS(delayIndex)
	Dim elapsed As Long = DateTime.Now - lastFailed
	Dim remaining As Int = requiredDelay - elapsed

	If remaining < 0 Then Return 0
	Return remaining
End Sub

'Verifica se deve apagar grupo (limite atingido)
Public Sub ShouldWipeGroup(groupId As String, maxAttempts As Int) As Boolean
	If maxAttempts <= 0 Then Return False
	Return GetFailedAttempts(groupId) >= maxAttempts
End Sub

Private Sub LoadAttempts As Map
	Dim attempts As Map
	attempts.Initialize

	If File.Exists(File.DirInternal, ATTEMPTS_FILE) Then
		Try
			Dim json As String = File.ReadString(File.DirInternal, ATTEMPTS_FILE)
			Dim parser As JSONParser
			parser.Initialize(json)
			attempts = parser.NextObject
		Catch
			Log("ModSecurity.LoadAttempts erro: " & LastException)
		End Try
	End If

	Return attempts
End Sub

Private Sub SaveAttempts(attempts As Map)
	Try
		Dim gen As JSONGenerator
		gen.Initialize(attempts)
		File.WriteString(File.DirInternal, ATTEMPTS_FILE, gen.ToString)
	Catch
		Log("ModSecurity.SaveAttempts erro: " & LastException)
	End Try
End Sub

' ============================================
'  PIN DE ACESSO
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
'  CONFIGURACOES
' ============================================

Public Sub LoadSettings As Map
	Dim settings As Map
	settings.Initialize

	If File.Exists(File.DirInternal, SETTINGS_FILE) Then
		Try
			Dim json As String = File.ReadString(File.DirInternal, SETTINGS_FILE)
			Dim parser As JSONParser
			parser.Initialize(json)
			settings = parser.NextObject
		Catch
			Log("ModSecurity.LoadSettings erro: " & LastException)
		End Try
	End If

	Return settings
End Sub

Public Sub SaveSettings(settings As Map)
	Dim gen As JSONGenerator
	gen.Initialize(settings)
	File.WriteString(File.DirInternal, SETTINGS_FILE, gen.ToString)
End Sub

Public Sub GetSetting(key As String, defaultValue As Object) As Object
	Dim settings As Map = LoadSettings
	Return settings.GetDefault(key, defaultValue)
End Sub

Public Sub SetSetting(key As String, value As Object)
	Dim settings As Map = LoadSettings
	settings.Put(key, value)
	SaveSettings(settings)
End Sub

' ============================================
'  BIOMETRIA
' ============================================

Public Sub SetUseBiometric(use As Boolean)
	SetSetting("useBiometric", use)
End Sub

Public Sub GetUseBiometric As Boolean
	Return GetSetting("useBiometric", False)
End Sub

' ============================================
'  IDIOMA
' ============================================

Public Sub SaveLanguage(langCode As String)
	SetSetting("language", langCode)
End Sub

Public Sub GetLanguage As String
	Return GetSetting("language", "pt")
End Sub

Public Sub IsLanguageChosen As Boolean
	Return GetSetting("languageChosen", False)
End Sub

Public Sub SetLanguageChosen
	SetSetting("languageChosen", True)
End Sub

' ============================================
'  TEMA
' ============================================

Public Sub SaveTheme(themeIndex As Int)
	SetSetting("theme", themeIndex)
End Sub

Public Sub GetTheme As Int
	Return GetSetting("theme", 0)
End Sub

' ============================================
'  TEMPO DE SESSAO (30s a 30min)
' ============================================

Public Sub SaveSessionTimeout(seconds As Int)
	If seconds < 30 Then seconds = 30
	If seconds > 1800 Then seconds = 1800
	SetSetting("sessionTimeout", seconds)
End Sub

Public Sub GetSessionTimeout As Int
	Return GetSetting("sessionTimeout", 120) '2 minutos padrao
End Sub

' ============================================
'  CLIPBOARD AUTO-CLEAR
' ============================================

Public Sub SaveClipboardTimeout(seconds As Int)
	If seconds < 10 Then seconds = 10
	If seconds > 120 Then seconds = 120
	SetSetting("clipboardTimeout", seconds)
End Sub

Public Sub GetClipboardTimeout As Int
	Return GetSetting("clipboardTimeout", 30)
End Sub

' ============================================
'  UTILITARIOS
' ============================================

Private Sub StrReverse(s As String) As String
	Dim sb As StringBuilder
	sb.Initialize
	For i = s.Length - 1 To 0 Step -1
		sb.Append(s.CharAt(i))
	Next
	Return sb.ToString
End Sub

'Gera UUID
Public Sub GenerateUUID As String
	Dim r As Reflector
	r.Target = r.RunStaticMethod("java.util.UUID", "randomUUID", Null, Null)
	Return r.RunMethod("toString")
End Sub

'Limpa string sensivel
Public Sub ClearString As String
	Return ""
End Sub
