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

	'PBKDF2 - Key Derivation Function
	'100.000 iteracoes = ~10 tentativas/segundo (vs ~1M com SHA-256)
	Private Const PBKDF2_ITERATIONS As Int = 100000
	Private Const PBKDF2_KEY_LENGTH As Int = 256  'bits
End Sub

' ============================================
'  NORMALIZACAO DE FRASE-SENHA
' ============================================
'
' DOCUMENTACAO INTERNA - NAO DIVULGAR AO USUARIO
' ================================================
' A frase-senha do usuario passa por normalizacao antes de ser usada
' na criptografia. Isso segue a mesma logica do LockSeed.
'
' REGRAS DE NORMALIZACAO:
' 1. Remove todos os espacos da frase
' 2. Converte tudo para minusculas (A=a, case-insensitive)
' 3. Converte caracteres acentuados para ASCII (a→a, c→c, etc)
' 4. Extrai os 10 PRIMEIROS caracteres UNICOS da frase
' 5. Esses 10 chars sao usados como chave para criptografia
'
' EXEMPLOS:
' - "Minha avo nasceu em 1950" → "minhavonsc" (tudo minusculo, sem espacos/acentos, 10 unicos)
' - "AAAaaa123" → "a123" (apenas 4 unicos - REJEITADO)
' - "Hello World 123" → "helowrd123" (10 unicos)
' - "SENHA123" e "senha123" → mesma chave "senha123"
'
' VALIDACAO:
' - Frase deve ter no minimo 8 caracteres (antes de normalizar)
' - Apos normalizar, deve resultar em pelo menos 10 chars unicos
' - Se nao atingir 10 unicos, mostra mensagem generica "Frase muito curta"
' - NUNCA revelar ao usuario que precisa de 10 chars diferentes
'
' SEGURANCA:
' - Mensagem de erro e sempre generica para nao revelar a logica
' - Usuario so ve "Frase muito curta" independente do motivo
' ================================================

'Normaliza frase: minusculas, remove acentos/espacos, pega 10 primeiros chars unicos
'Ex: "Minha avó nasceu" → "minhavonsc"
Public Sub NormalizePassphrase(phrase As String) As String
	If phrase.Length = 0 Then Return ""

	'Remove espacos, converte para minusculas, remove acentos
	Dim cleaned As String = RemoveAccents(phrase.Replace(" ", "").ToLowerCase)

	'Pega os 10 primeiros caracteres unicos
	Dim unique As String = GetUniqueChars(cleaned, 10)

	Return unique
End Sub

'Valida se frase tem pelo menos 10 caracteres unicos (case-insensitive, sem espacos)
Public Sub ValidatePassphraseStrength(phrase As String) As Boolean
	Dim cleaned As String = RemoveAccents(phrase.Replace(" ", "").ToLowerCase)
	Dim unique As String = GetUniqueChars(cleaned, 10)
	Return unique.Length >= 10
End Sub

'Retorna mensagem de erro se frase for fraca, ou "" se OK
'Nota: Mensagem generica para nao revelar logica interna
Public Sub GetPassphraseError(phrase As String) As String
	If phrase.Length < 8 Then
		Return ModLang.T("passphrase_too_short")
	End If

	Dim cleaned As String = RemoveAccents(phrase.Replace(" ", "").ToLowerCase)
	Dim unique As String = GetUniqueChars(cleaned, 10)

	If unique.Length < 10 Then
		Return ModLang.T("passphrase_too_short")
	End If

	Return "" 'OK
End Sub

'Remove acentos convertendo para ASCII
Private Sub RemoveAccents(text As String) As String
	Dim result As StringBuilder
	result.Initialize

	For i = 0 To text.Length - 1
		Dim c As Char = text.CharAt(i)
		Dim code As Int = Asc(c)

		'Converte acentuados para ASCII
		Select code
			'Maiusculas acentuadas
			Case 192, 193, 194, 195, 196, 197: result.Append("A") 'À Á Â Ã Ä Å
			Case 199: result.Append("C") 'Ç
			Case 200, 201, 202, 203: result.Append("E") 'È É Ê Ë
			Case 204, 205, 206, 207: result.Append("I") 'Ì Í Î Ï
			Case 209: result.Append("N") 'Ñ
			Case 210, 211, 212, 213, 214: result.Append("O") 'Ò Ó Ô Õ Ö
			Case 217, 218, 219, 220: result.Append("U") 'Ù Ú Û Ü
			Case 221: result.Append("Y") 'Ý
			'Minusculas acentuadas
			Case 224, 225, 226, 227, 228, 229: result.Append("a") 'à á â ã ä å
			Case 231: result.Append("c") 'ç
			Case 232, 233, 234, 235: result.Append("e") 'è é ê ë
			Case 236, 237, 238, 239: result.Append("i") 'ì í î ï
			Case 241: result.Append("n") 'ñ
			Case 242, 243, 244, 245, 246: result.Append("o") 'ò ó ô õ ö
			Case 249, 250, 251, 252: result.Append("u") 'ù ú û ü
			Case 253, 255: result.Append("y") 'ý ÿ
			Case Else
				'Mantem apenas ASCII imprimivel (32-126)
				If code >= 32 And code <= 126 Then
					result.Append(c)
				End If
		End Select
	Next

	Return result.ToString
End Sub

'Retorna os N primeiros caracteres unicos da string
Private Sub GetUniqueChars(text As String, count As Int) As String
	Dim result As StringBuilder
	result.Initialize
	Dim seen As String = ""

	For i = 0 To text.Length - 1
		If result.Length >= count Then Exit

		Dim c As String = text.CharAt(i)
		If seen.Contains(c) = False Then
			result.Append(c)
			seen = seen & c
		End If
	Next

	Return result.ToString
End Sub

' ============================================
'  CRIPTOGRAFIA AES-256
' ============================================

'Criptografa texto com frase-senha (AES-256-CBC)
'A frase é normalizada automaticamente (10 chars unicos)
Public Sub Encrypt(passPhrase As String, plainText As String) As String
	If passPhrase.Length < 1 Or plainText.Length < 1 Then Return ""

	'Normaliza a frase para 10 chars unicos
	Dim normalizedPhrase As String = NormalizePassphrase(passPhrase)
	Return EncryptWithNormalized(normalizedPhrase, plainText)
End Sub

'Criptografa texto com frase JA NORMALIZADA (10 chars)
'Usa esta versao quando a frase ja foi normalizada (ex: cache de sessao)
Public Sub EncryptWithNormalized(normalizedPhrase As String, plainText As String) As String
	If normalizedPhrase.Length < 10 Or plainText.Length < 1 Then Return ""

	Try
		Dim md As MessageDigest
		Dim keyBytes() As Byte = md.GetMessageDigest(normalizedPhrase.GetBytes("UTF8"), "SHA-256")
		Dim ivBytes() As Byte = md.GetMessageDigest(StrReverse(normalizedPhrase).GetBytes("UTF8"), "MD5")

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
'A frase é normalizada automaticamente (10 chars unicos)
Public Sub Decrypt(passPhrase As String, encText As String) As String
	If passPhrase.Length < 1 Or encText.Length < 1 Then Return ""

	'Normaliza a frase para 10 chars unicos
	Dim normalizedPhrase As String = NormalizePassphrase(passPhrase)
	Return DecryptWithNormalized(normalizedPhrase, encText)
End Sub

'Descriptografa texto com frase JA NORMALIZADA (10 chars)
'Usa esta versao quando a frase ja foi normalizada (ex: cache de sessao)
Public Sub DecryptWithNormalized(normalizedPhrase As String, encText As String) As String
	If normalizedPhrase.Length < 10 Or encText.Length < 1 Then Return ""

	Try
		'Verifica prefixo AES
		If encText.StartsWith("AES:") = False Then Return ""

		Dim encData As String = encText.SubString(4)

		Dim md As MessageDigest
		Dim keyBytes() As Byte = md.GetMessageDigest(normalizedPhrase.GetBytes("UTF8"), "SHA-256")
		Dim ivBytes() As Byte = md.GetMessageDigest(StrReverse(normalizedPhrase).GetBytes("UTF8"), "MD5")

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
'  CRIPTOGRAFIA COM SALT (POR GRUPO) - PBKDF2
' ============================================

'Deriva chave usando PBKDF2 (100.000 iteracoes)
'Retorna array de 32 bytes (256 bits) para AES-256
Private Sub DeriveKeyPBKDF2(passPhrase As String, salt As String) As Byte()
	'Converter senha para char array usando JavaObject (mais seguro)
	Dim joPass As JavaObject = passPhrase
	Dim passChars() As Char = joPass.RunMethod("toCharArray", Null)

	'Converter salt para bytes
	Dim saltBytes() As Byte = salt.GetBytes("UTF8")

	'Criar PBEKeySpec com senha, salt, iteracoes e tamanho da chave
	Dim keySpec As JavaObject
	keySpec.InitializeNewInstance("javax.crypto.spec.PBEKeySpec", _
		Array(passChars, saltBytes, PBKDF2_ITERATIONS, PBKDF2_KEY_LENGTH))

	'Obter SecretKeyFactory para PBKDF2WithHmacSHA256
	Dim factory As JavaObject
	factory = factory.InitializeStatic("javax.crypto.SecretKeyFactory").RunMethod("getInstance", _
		Array("PBKDF2WithHmacSHA256"))

	'Gerar a chave
	Dim secretKey As JavaObject = factory.RunMethod("generateSecret", Array(keySpec))
	Dim keyBytes() As Byte = secretKey.RunMethod("getEncoded", Null)

	'Limpar a spec (seguranca)
	keySpec.RunMethod("clearPassword", Null)

	Return keyBytes
End Sub

'Criptografa com salt aleatorio do grupo (PBKDF2 + AES-256-CBC + IV aleatorio)
'passPhrase: frase ou PIN do grupo
'salt: salt aleatorio do grupo (hex string)
'plainText: texto a criptografar
'
'FORMATO DE SAIDA: AES:iv_hex:base64_ciphertext
'- iv_hex: 32 caracteres hex (16 bytes aleatorios)
'- base64_ciphertext: ciphertext em Base64
'
Public Sub EncryptWithSalt(passPhrase As String, salt As String, plainText As String) As String
	If passPhrase.Length < 1 Or plainText.Length < 1 Or salt.Length < 1 Then Return ""

	Try
		'Deriva chave com PBKDF2 (100.000 iteracoes)
		Dim keyBytes() As Byte = DeriveKeyPBKDF2(passPhrase, salt)

		'Gera IV aleatorio de 16 bytes (SecureRandom)
		Dim ivBytes() As Byte = GenerateRandomIV

		Dim c As Cipher
		Dim kg As KeyGenerator
		kg.Initialize("AES")
		kg.KeyFromBytes(keyBytes)

		c.Initialize("AES/CBC/PKCS5Padding")
		c.InitialisationVector = ivBytes

		Dim dataBytes() As Byte = plainText.GetBytes("UTF8")
		Dim encrypted() As Byte = c.Encrypt(dataBytes, kg.Key, True)

		'Formato: AES:iv_hex:base64_ciphertext
		Dim su As StringUtils
		Dim ivHex As String = BytesToHex(ivBytes)
		Return "AES:" & ivHex & ":" & su.EncodeBase64(encrypted)

	Catch
		Log("ModSecurity.EncryptWithSalt erro: " & LastException)
		Return ""
	End Try
End Sub

'Descriptografa com salt do grupo (PBKDF2 + AES-256-CBC)
'Suporta dois formatos:
'- NOVO: AES:iv_hex:base64_ciphertext (IV aleatorio)
'- LEGADO: AES:base64_ciphertext (IV = MD5(salt))
'
Public Sub DecryptWithSalt(passPhrase As String, salt As String, encText As String) As String
	If passPhrase.Length < 1 Or encText.Length < 1 Or salt.Length < 1 Then Return ""

	Try
		If encText.StartsWith("AES:") = False Then Return ""

		'Deriva chave com PBKDF2 (100.000 iteracoes)
		Dim keyBytes() As Byte = DeriveKeyPBKDF2(passPhrase, salt)

		'Detecta formato pelo numero de ":"
		Dim afterPrefix As String = encText.SubString(4)
		Dim colonPos As Int = afterPrefix.IndexOf(":")

		Dim ivBytes() As Byte
		Dim encrypted() As Byte
		Dim su As StringUtils

		If colonPos > 0 And colonPos = 32 Then
			'FORMATO NOVO: AES:iv_hex:base64_ciphertext
			Dim ivHex As String = afterPrefix.SubString2(0, 32)
			Dim encData As String = afterPrefix.SubString(33)

			ivBytes = HexToBytes(ivHex)
			encrypted = su.DecodeBase64(encData)
			'Log("DecryptWithSalt: usando IV aleatorio")
		Else
			'FORMATO LEGADO: AES:base64_ciphertext (IV = MD5(salt))
			Dim md As MessageDigest
			ivBytes = md.GetMessageDigest(salt.GetBytes("UTF8"), "MD5")
			encrypted = su.DecodeBase64(afterPrefix)
			'Log("DecryptWithSalt: usando IV legado (MD5)")
		End If

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

'Gera IV aleatorio de 16 bytes usando SecureRandom
Private Sub GenerateRandomIV As Byte()
	Dim sr As JavaObject
	sr.InitializeNewInstance("java.security.SecureRandom", Null)

	Dim ivBytes(16) As Byte
	sr.RunMethod("nextBytes", Array(ivBytes))

	Return ivBytes
End Sub

'Converte string hex para array de bytes
Private Sub HexToBytes(hex As String) As Byte()
	Dim length As Int = hex.Length / 2
	Dim bytes(length) As Byte

	For i = 0 To length - 1
		Dim hexByte As String = hex.SubString2(i * 2, i * 2 + 2)
		bytes(i) = Bit.ParseInt(hexByte, 16)
	Next

	Return bytes
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

'Calcula delay baseado no numero de tentativas falhas
'Regra: 5 tent→1min, +3(8)→5min, cada +2→+5min
Private Sub CalculateDelay(count As Int) As Int
	If count < 5 Then Return 0  '1-4 tentativas: sem delay
	If count = 5 Then Return 60000  '5 tentativas: 1 minuto
	If count <= 8 Then Return 60000  '6-8 tentativas: 1 minuto

	'A partir de 9: 5 minutos base + 5 min a cada 2 tentativas
	Dim extra As Int = (count - 8) / 2
	Return 300000 + (extra * 300000)  '5 min + extras
End Sub

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

	'Retorna delay calculado
	Return CalculateDelay(count)
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

'Retorna delay restante antes de poder tentar novamente (em ms)
Public Sub GetRemainingDelay(groupId As String) As Int
	Dim attempts As Map = LoadAttempts
	If attempts.ContainsKey(groupId) = False Then Return 0

	Dim groupData As Map = attempts.Get(groupId)
	Dim count As Int = groupData.GetDefault("count", 0)
	Dim lastFailed As Long = groupData.GetDefault("lastFailed", 0)

	If count = 0 Then Return 0

	Dim requiredDelay As Int = CalculateDelay(count)
	If requiredDelay = 0 Then Return 0

	Dim elapsed As Long = DateTime.Now - lastFailed
	Dim remaining As Int = requiredDelay - elapsed

	If remaining < 0 Then Return 0
	Return remaining
End Sub

'Formata delay restante para exibicao (MM:SS)
Public Sub FormatDelay(delayMs As Int) As String
	Dim secs As Int = delayMs / 1000
	Dim mins As Int = secs / 60
	Dim secsRest As Int = secs Mod 60
	Return NumberFormat(mins, 1, 0) & ":" & NumberFormat(secsRest, 2, 0)
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
'  FRASE UNICA OU POR CATEGORIA
' ============================================

'True = mesma frase para todas categorias (sessao continua)
'False = frase diferente por categoria (encerra sessao ao trocar)
Public Sub SetUseSinglePassphrase(use As Boolean)
	SetSetting("singlePassphrase", use)
End Sub

Public Sub GetUseSinglePassphrase As Boolean
	Return GetSetting("singlePassphrase", True)  'Padrao: frase unica
End Sub

' ============================================
'  PIN DE ACESSO (4-8 digitos) - SEGURO
' ============================================
'
' SEGURANCA: PIN e armazenado usando PBKDF2 + salt aleatorio
' - Salt: 32 caracteres hex aleatorios
' - Hash: PBKDF2WithHmacSHA256 com 100.000 iteracoes
' - Formato do arquivo: salt:hash (ambos em hex)
' - Impossivel reverter o PIN a partir do hash
'
' ============================================

'Verifica se PIN esta configurado
Public Sub HasPIN As Boolean
	Return File.Exists(File.DirInternal, PIN_FILE)
End Sub

'Salva PIN com hash seguro (PBKDF2 + salt aleatorio)
Public Sub SavePIN(pin As String)
	If pin.Length < 4 Or pin.Length > 8 Then
		Log("SavePIN: PIN deve ter 4-8 digitos")
		Return
	End If

	'Gera salt aleatorio
	Dim salt As String = GenerateRandomSalt

	'Deriva hash usando PBKDF2 (100.000 iteracoes)
	Dim hashBytes() As Byte = DeriveKeyPBKDF2(pin, salt)
	Dim hashHex As String = BytesToHex(hashBytes)

	'Salva no formato salt:hash
	Dim data As String = salt & ":" & hashHex
	File.WriteString(File.DirInternal, PIN_FILE, data)
	Log("ModSecurity: PIN salvo com PBKDF2")
End Sub

'Valida PIN informado usando PBKDF2
Public Sub ValidatePIN(inputPin As String) As Boolean
	If HasPIN = False Then Return False

	Try
		Dim data As String = File.ReadString(File.DirInternal, PIN_FILE)

		'Verifica se e formato antigo (Base64) ou novo (salt:hash)
		If data.Contains(":") = False Then
			'Formato antigo - migrar para novo formato
			Log("ValidatePIN: Migrando PIN do formato antigo para PBKDF2")
			Dim oldPin As String = MigrateLegacyPIN(data)
			If oldPin.Length > 0 And inputPin = oldPin Then
				'PIN correto - atualiza para novo formato seguro
				SavePIN(inputPin)
				Return True
			End If
			Return False
		End If

		'Formato novo: salt:hash
		Dim parts() As String = Regex.Split(":", data)
		If parts.Length <> 2 Then Return False

		Dim salt As String = parts(0)
		Dim savedHash As String = parts(1)

		'Deriva hash do PIN informado
		Dim inputHashBytes() As Byte = DeriveKeyPBKDF2(inputPin, salt)
		Dim inputHash As String = BytesToHex(inputHashBytes)

		'Comparacao segura (tempo constante)
		Return SecureCompare(inputHash, savedHash)

	Catch
		Log("ValidatePIN erro: " & LastException)
		Return False
	End Try
End Sub

'Migra PIN do formato antigo (Base64) para o novo
Private Sub MigrateLegacyPIN(encoded As String) As String
	Try
		Dim su As StringUtils
		Dim data() As Byte = su.DecodeBase64(encoded)
		Return BytesToString(data, 0, data.Length, "UTF8")
	Catch
		Return ""
	End Try
End Sub

'Comparacao de strings em tempo constante (evita timing attacks)
Private Sub SecureCompare(a As String, b As String) As Boolean
	If a.Length <> b.Length Then Return False

	Dim result As Int = 0
	For i = 0 To a.Length - 1
		result = Bit.Or(result, Bit.Xor(Asc(a.CharAt(i)), Asc(b.CharAt(i))))
	Next
	Return result = 0
End Sub

'Converte array de bytes para string hexadecimal
Private Sub BytesToHex(bytes() As Byte) As String
	Dim sb As StringBuilder
	sb.Initialize
	For Each b As Byte In bytes
		Dim hex As String = Bit.ToHexString(Bit.And(b, 0xFF))
		If hex.Length = 1 Then sb.Append("0")
		sb.Append(hex.ToLowerCase)
	Next
	Return sb.ToString
End Sub

'Remove PIN
Public Sub RemovePIN
	If File.Exists(File.DirInternal, PIN_FILE) Then
		File.Delete(File.DirInternal, PIN_FILE)
		Log("ModSecurity: PIN removido")
	End If
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
