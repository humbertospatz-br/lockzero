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
'Aplica transformacao interna e adiciona salt
'Ex: "Minha avó nasceu" → resultado transformado
Public Sub NormalizePassphrase(phrase As String) As String
	If phrase.Length = 0 Then Return ""

	'Remove espacos, converte para minusculas, remove acentos
	Dim cleaned As String = RemoveAccents(phrase.Replace(" ", "").ToLowerCase)

	'Pega os 10 primeiros caracteres unicos
	Dim unique As String = GetUniqueChars(cleaned, 10)

	'Aplica transformacao de case (posicoes 1, 5, 8 viram maiusculas se forem letras)
	Dim transformed As String = ApplyInternalTransform(unique)

	'Adiciona salt interno
	Return transformed & GetInternalSalt
End Sub

'Transforma posicoes especificas para maiusculas (se forem letras)
'Posicoes 1, 5, 8 (0-indexed) - ex: "minhavonsc" → "mInhavOnSc"
Private Sub ApplyInternalTransform(text As String) As String
	If text.Length < 10 Then Return text

	Dim result As StringBuilder
	result.Initialize

	For i = 0 To text.Length - 1
		Dim c As String = text.CharAt(i)

		'Posicoes 1, 5, 8 viram maiusculas (se for letra a-z)
		If i = 1 Or i = 5 Or i = 8 Then
			Dim code As Int = Asc(c)
			'Se for letra minuscula (a-z = 97-122), converte para maiuscula
			If code >= 97 And code <= 122 Then
				result.Append(Chr(code - 32))  'a→A, b→B, etc
			Else
				result.Append(c)  'Numero ou outro - mantem
			End If
		Else
			result.Append(c)
		End If
	Next

	Return result.ToString
End Sub

'Monta salt interno a partir de componentes distribuidos
Private Sub GetInternalSalt As String
	'Componentes vem de diferentes modulos (valores FIXOS, nunca mudam)
	Dim p1 As String = Chr(Starter.UI_ALIGN_BASE)        'L (76)
	Dim p2 As String = Chr(ModTheme.GetVariantCode)      'Z (90)
	Dim p3 As String = Chr(ModLang.GetHashBase)          '# (35)
	Dim p4 As String = ModSession.GetCacheLimit          '10
	Return p1 & p2 & p3 & p4  'LZ#10
End Sub

'Valida se frase tem pelo menos 10 caracteres unicos (case-insensitive, sem espacos)
'Tambem valida que nao seja majoritariamente numeros (max 4 numeros nos 10 unicos)
Public Sub ValidatePassphraseStrength(phrase As String) As Boolean
	Dim cleaned As String = RemoveAccents(phrase.Replace(" ", "").ToLowerCase)
	Dim unique As String = GetUniqueChars(cleaned, 10)

	If unique.Length < 10 Then Return False

	'Conta numeros nos 10 caracteres unicos - maximo 4 permitido
	Dim digitCount As Int = CountDigits(unique)
	If digitCount > 4 Then Return False

	Return True
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

	'Valida quantidade de numeros - max 4 nos 10 unicos (min 6 letras)
	Dim digitCount As Int = CountDigits(unique)
	If digitCount > 4 Then
		Return ModLang.T("passphrase_too_weak")
	End If

	Return "" 'OK
End Sub

'Conta quantos digitos (0-9) existem na string
Private Sub CountDigits(text As String) As Int
	Dim count As Int = 0
	For i = 0 To text.Length - 1
		Dim code As Int = Asc(text.CharAt(i))
		If code >= 48 And code <= 57 Then  '0-9
			count = count + 1
		End If
	Next
	Return count
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

	Dim keyBytes() As Byte
	Dim ivBytes() As Byte
	Dim dataBytes() As Byte
	Dim result As String = ""

	Try
		Dim md As MessageDigest
		keyBytes = md.GetMessageDigest(normalizedPhrase.GetBytes("UTF8"), "SHA-256")
		ivBytes = md.GetMessageDigest(StrReverse(normalizedPhrase).GetBytes("UTF8"), "MD5")

		Dim c As Cipher
		Dim kg As KeyGenerator
		kg.Initialize("AES")
		kg.KeyFromBytes(keyBytes)

		c.Initialize("AES/CBC/PKCS5Padding")
		c.InitialisationVector = ivBytes

		dataBytes = plainText.GetBytes("UTF8")
		Dim encrypted() As Byte = c.Encrypt(dataBytes, kg.Key, True)

		Dim su As StringUtils
		result = "AES:" & su.EncodeBase64(encrypted)

	Catch
		Log("ModSecurity.Encrypt erro: " & LastException)
	End Try

	'Limpar dados sensiveis
	ZeroBytes(keyBytes)
	ZeroBytes(ivBytes)
	ZeroBytes(dataBytes)

	Return result
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

	Dim keyBytes() As Byte
	Dim ivBytes() As Byte
	Dim encrypted() As Byte
	Dim decrypted() As Byte
	Dim result As String = ""

	Try
		'Verifica prefixo AES
		If encText.StartsWith("AES:") = False Then Return ""

		Dim encData As String = encText.SubString(4)

		Dim md As MessageDigest
		keyBytes = md.GetMessageDigest(normalizedPhrase.GetBytes("UTF8"), "SHA-256")
		ivBytes = md.GetMessageDigest(StrReverse(normalizedPhrase).GetBytes("UTF8"), "MD5")

		Dim su As StringUtils
		encrypted = su.DecodeBase64(encData)

		Dim c As Cipher
		Dim kg As KeyGenerator
		kg.Initialize("AES")
		kg.KeyFromBytes(keyBytes)

		c.Initialize("AES/CBC/PKCS5Padding")
		c.InitialisationVector = ivBytes

		decrypted = c.Decrypt(encrypted, kg.Key, True)
		result = BytesToString(decrypted, 0, decrypted.Length, "UTF8")

	Catch
		Log("ModSecurity.Decrypt erro: " & LastException)
	End Try

	'Limpar dados sensiveis
	ZeroBytes(keyBytes)
	ZeroBytes(ivBytes)
	ZeroBytes(encrypted)
	ZeroBytes(decrypted)

	Return result
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
	Dim passChars() As Char
	Dim saltBytes() As Byte
	Dim keySpec As JavaObject

	Try
		'Converter senha para char array usando JavaObject (mais seguro)
		Dim joPass As JavaObject = passPhrase
		passChars = joPass.RunMethod("toCharArray", Null)

		'Converter salt para bytes
		saltBytes = salt.GetBytes("UTF8")

		'Criar PBEKeySpec com senha, salt, iteracoes e tamanho da chave
		keySpec.InitializeNewInstance("javax.crypto.spec.PBEKeySpec", _
			Array(passChars, saltBytes, PBKDF2_ITERATIONS, PBKDF2_KEY_LENGTH))

		'Obter SecretKeyFactory para PBKDF2WithHmacSHA256
		Dim factory As JavaObject
		factory = factory.InitializeStatic("javax.crypto.SecretKeyFactory").RunMethod("getInstance", _
			Array("PBKDF2WithHmacSHA256"))

		'Gerar a chave
		Dim secretKey As JavaObject = factory.RunMethod("generateSecret", Array(keySpec))
		Dim keyBytes() As Byte = secretKey.RunMethod("getEncoded", Null)

		'Limpar dados sensiveis
		keySpec.RunMethod("clearPassword", Null)
		ZeroChars(passChars)
		ZeroBytes(saltBytes)

		Return keyBytes
	Catch
		'Limpar dados sensiveis mesmo em caso de erro
		If keySpec.IsInitialized Then keySpec.RunMethod("clearPassword", Null)
		ZeroChars(passChars)
		ZeroBytes(saltBytes)
		Log("DeriveKeyPBKDF2 erro: " & LastException)
		Return Null
	End Try
End Sub

'Criptografa com salt aleatorio do grupo (PBKDF2 + AES-256-CBC + IV aleatorio + HMAC)
'passPhrase: frase ou PIN do grupo
'salt: salt aleatorio do grupo (hex string)
'plainText: texto a criptografar
'
'FORMATO DE SAIDA: AES:iv_hex:base64_ciphertext:hmac_hex
'- iv_hex: 32 caracteres hex (16 bytes aleatorios)
'- base64_ciphertext: ciphertext em Base64
'- hmac_hex: 64 caracteres hex (HMAC-SHA256 de iv + ciphertext)
'
'SEGURANCA: Encrypt-then-MAC - HMAC calculado sobre dados criptografados
'
Public Sub EncryptWithSalt(passPhrase As String, salt As String, plainText As String) As String
	If passPhrase.Length < 1 Or plainText.Length < 1 Or salt.Length < 1 Then Return ""

	Dim keyBytes() As Byte
	Dim ivBytes() As Byte
	Dim dataBytes() As Byte
	Dim encrypted() As Byte
	Dim hmacData() As Byte
	Dim hmacBytes() As Byte
	Dim result As String = ""

	Try
		'Deriva chave com PBKDF2 (100.000 iteracoes)
		keyBytes = DeriveKeyPBKDF2(passPhrase, salt)
		If keyBytes = Null Then Return ""

		'Gera IV aleatorio de 16 bytes (SecureRandom)
		ivBytes = GenerateRandomIV

		Dim c As Cipher
		Dim kg As KeyGenerator
		kg.Initialize("AES")
		kg.KeyFromBytes(keyBytes)

		c.Initialize("AES/CBC/PKCS5Padding")
		c.InitialisationVector = ivBytes

		dataBytes = plainText.GetBytes("UTF8")
		encrypted = c.Encrypt(dataBytes, kg.Key, True)

		'Calcula HMAC-SHA256 sobre IV + ciphertext (Encrypt-then-MAC)
		hmacData = ConcatBytes(ivBytes, encrypted)
		hmacBytes = CalculateHMAC(keyBytes, hmacData)

		'Formato: AES:iv_hex:base64_ciphertext:hmac_hex
		Dim su As StringUtils
		Dim ivHex As String = BytesToHex(ivBytes)
		Dim hmacHex As String = BytesToHex(hmacBytes)
		result = "AES:" & ivHex & ":" & su.EncodeBase64(encrypted) & ":" & hmacHex

	Catch
		Log("ModSecurity.EncryptWithSalt erro: " & LastException)
	End Try

	'Limpar dados sensiveis da memoria
	ZeroBytes(keyBytes)
	ZeroBytes(ivBytes)
	ZeroBytes(dataBytes)
	ZeroBytes(hmacData)
	ZeroBytes(hmacBytes)
	'encrypted nao e zerado pois foi codificado no resultado

	Return result
End Sub

'Descriptografa com salt do grupo (PBKDF2 + AES-256-CBC)
'Suporta tres formatos:
'- v3 (HMAC): AES:iv_hex:base64_ciphertext:hmac_hex (IV aleatorio + HMAC)
'- v2 (IV): AES:iv_hex:base64_ciphertext (IV aleatorio, sem HMAC)
'- v1 (LEGADO): AES:base64_ciphertext (IV = MD5(salt))
'
Public Sub DecryptWithSalt(passPhrase As String, salt As String, encText As String) As String
	If passPhrase.Length < 1 Or encText.Length < 1 Or salt.Length < 1 Then Return ""

	Dim keyBytes() As Byte
	Dim ivBytes() As Byte
	Dim encrypted() As Byte
	Dim hmacData() As Byte
	Dim expectedHmac() As Byte
	Dim decrypted() As Byte
	Dim result As String = ""

	Try
		If encText.StartsWith("AES:") = False Then Return ""

		'Deriva chave com PBKDF2 (100.000 iteracoes)
		keyBytes = DeriveKeyPBKDF2(passPhrase, salt)
		If keyBytes = Null Then Return ""

		'Detecta formato contando ":"
		Dim afterPrefix As String = encText.SubString(4)
		Dim parts() As String = Regex.Split(":", afterPrefix)

		Dim su As StringUtils

		If parts.Length = 3 And parts(0).Length = 32 And parts(2).Length = 64 Then
			'FORMATO v3 (HMAC): AES:iv_hex:base64_ciphertext:hmac_hex
			Dim ivHex As String = parts(0)
			Dim encData As String = parts(1)
			Dim hmacHex As String = parts(2)

			ivBytes = HexToBytes(ivHex)
			encrypted = su.DecodeBase64(encData)

			'Verifica HMAC antes de descriptografar (Encrypt-then-MAC)
			hmacData = ConcatBytes(ivBytes, encrypted)
			expectedHmac = CalculateHMAC(keyBytes, hmacData)
			Dim expectedHmacHex As String = BytesToHex(expectedHmac)

			If SecureCompare(hmacHex, expectedHmacHex) = False Then
				Log("DecryptWithSalt: HMAC invalido - dados podem ter sido alterados!")
				'Limpar e retornar
				ZeroBytes(keyBytes)
				ZeroBytes(ivBytes)
				ZeroBytes(encrypted)
				ZeroBytes(hmacData)
				ZeroBytes(expectedHmac)
				Return ""
			End If
			'Log("DecryptWithSalt: HMAC verificado OK")

		Else If parts.Length = 2 And parts(0).Length = 32 Then
			'FORMATO v2 (IV): AES:iv_hex:base64_ciphertext
			Dim ivHex As String = parts(0)
			Dim encData As String = parts(1)

			ivBytes = HexToBytes(ivHex)
			encrypted = su.DecodeBase64(encData)
			'Log("DecryptWithSalt: formato v2 (sem HMAC)")

		Else
			'FORMATO v1 (LEGADO): AES:base64_ciphertext (IV = MD5(salt))
			Dim md As MessageDigest
			ivBytes = md.GetMessageDigest(salt.GetBytes("UTF8"), "MD5")
			encrypted = su.DecodeBase64(afterPrefix)
			'Log("DecryptWithSalt: formato v1 legado")
		End If

		Dim c As Cipher
		Dim kg As KeyGenerator
		kg.Initialize("AES")
		kg.KeyFromBytes(keyBytes)

		c.Initialize("AES/CBC/PKCS5Padding")
		c.InitialisationVector = ivBytes

		decrypted = c.Decrypt(encrypted, kg.Key, True)
		result = BytesToString(decrypted, 0, decrypted.Length, "UTF8")

	Catch
		Log("ModSecurity.DecryptWithSalt erro: " & LastException)
	End Try

	'Limpar dados sensiveis da memoria
	ZeroBytes(keyBytes)
	ZeroBytes(ivBytes)
	ZeroBytes(encrypted)
	ZeroBytes(hmacData)
	ZeroBytes(expectedHmac)
	ZeroBytes(decrypted)

	Return result
End Sub

'Calcula HMAC-SHA256
Private Sub CalculateHMAC(keyBytes() As Byte, data() As Byte) As Byte()
	'Criar SecretKeySpec para HMAC
	Dim keySpec As JavaObject
	keySpec.InitializeNewInstance("javax.crypto.spec.SecretKeySpec", Array(keyBytes, "HmacSHA256"))

	'Obter instancia do Mac
	Dim mac As JavaObject
	mac = mac.InitializeStatic("javax.crypto.Mac").RunMethod("getInstance", Array("HmacSHA256"))

	'Inicializar e calcular
	mac.RunMethod("init", Array(keySpec))
	Dim result() As Byte = mac.RunMethod("doFinal", Array(data))

	Return result
End Sub

'Concatena dois arrays de bytes
Private Sub ConcatBytes(a() As Byte, b() As Byte) As Byte()
	Dim result(a.Length + b.Length) As Byte

	For i = 0 To a.Length - 1
		result(i) = a(i)
	Next

	For i = 0 To b.Length - 1
		result(a.Length + i) = b(i)
	Next

	Return result
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
'  ENTRADA SEGURA DE FRASE-SENHA
' ============================================
'
' *** DOCUMENTACAO OBRIGATORIA - LEIA ANTES DE CRIAR CAMPOS DE SENHA ***
'
' REGRA DE OURO: Todo EditText que recebe frase-senha ou senha DEVE usar
' as funcoes abaixo. NUNCA criar campo de senha sem essas funcoes.
'
' ONDE USAR (OBRIGATORIO):
' - Campos de frase-senha (desbloqueio, criacao de grupo, backup)
' - Campos de confirmacao de frase
' - Campos de senha de entrada (PagePasswordEdit)
' - Campos de PIN
'
' COMO USAR:
' 1. Apos Initialize do EditText, chamar:
'    edtPassphrase.InputType = ModSecurity.GetSecurePassphraseInputType
'
' 2. Para toggle ver/ocultar senha:
'    If visivel Then
'        edt.InputType = ModSecurity.GetSecureVisibleInputType
'    Else
'        edt.InputType = ModSecurity.GetSecurePassphraseInputType
'    End If
'
' 3. Para configuracao completa (recomendado):
'    ModSecurity.ConfigureSecureField(edtPassphrase)
'
' EFEITOS:
' - Desabilita sugestoes do teclado
' - Desabilita aprendizado de palavras
' - Desabilita autocomplete
' - Mostra pontos ao digitar (modo oculto)
'
' InputType flags usadas:
' - TYPE_CLASS_TEXT = 1
' - TYPE_TEXT_VARIATION_PASSWORD = 128
' - TYPE_TEXT_FLAG_NO_SUGGESTIONS = 524288 (0x80000)
' - TYPE_TEXT_VARIATION_VISIBLE_PASSWORD = 144 (para modo visivel)
'
' ============================================

'Constante para InputType seguro de frase-senha (modo oculto)
Public Sub GetSecurePassphraseInputType As Int
	'TEXT + PASSWORD + NO_SUGGESTIONS
	Return Bit.Or(Bit.Or(1, 128), 524288)
End Sub

'Constante para InputType seguro visivel (quando mostrar senha)
Public Sub GetSecureVisibleInputType As Int
	'TEXT + VISIBLE_PASSWORD + NO_SUGGESTIONS
	'VISIBLE_PASSWORD (144) = impede sugestoes mesmo visivel
	Return Bit.Or(Bit.Or(1, 144), 524288)
End Sub

'Configura EditText para entrada segura de senha/frase
'Usar esta funcao apos Initialize para garantir todas as protecoes
Public Sub ConfigureSecureField(edt As EditText)
	edt.SingleLine = True

	'Desabilita flags extras via JavaObject para mais seguranca
	Try
		Dim jo As JavaObject = edt
		'Desabilita autocomplete (Android 8+)
		jo.RunMethod("setImportantForAutofill", Array(2)) '2 = IMPORTANT_FOR_AUTOFILL_NO
	Catch
		'Ignora se Android antigo nao suportar
		Log("ConfigureSecureField: flags extras nao suportadas")
	End Try

	'IMPORTANTE: InputType deve ser definido POR ULTIMO
	'para nao ser sobrescrito pelos metodos acima
	edt.InputType = GetSecurePassphraseInputType
End Sub

'Configura EditText para entrada segura VISIVEL
Public Sub ConfigureSecureFieldVisible(edt As EditText)
	edt.InputType = GetSecureVisibleInputType
End Sub

'Limpa o clipboard do sistema
Public Sub ClearClipboard
	Try
		Dim jo As JavaObject
		jo = jo.InitializeContext
		Dim cm As JavaObject = jo.RunMethod("getSystemService", Array("clipboard"))
		Dim clipData As JavaObject
		clipData.InitializeNewInstance("android.content.ClipData", _
			Array("", Array As String("text/plain"), _
			clipData.InitializeNewInstance("android.content.ClipData.Item", Array(""))))
		cm.RunMethod("setPrimaryClip", Array(clipData))
	Catch
		Log("ClearClipboard error: " & LastException)
	End Try
End Sub

'Limpa campo EditText de forma segura (previne cache do teclado)
Public Sub ClearSecureField(edt As EditText)
	edt.Text = ""
	'Limpa clipboard caso usuario tenha colado algo
	ClearClipboard
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
'  FRASE GLOBAL (quando frase unica esta ativa)
' ============================================
'Quando UseSinglePassphrase = True, Salt e TestValue sao armazenados
'globalmente e usados para todos os grupos seguros (Notas + Senhas)

'Verifica se frase global ja foi configurada
Public Sub HasGlobalPassphrase As Boolean
	Dim salt As String = GetSetting("globalSalt", "")
	Dim test As String = GetSetting("globalTestValue", "")
	Return salt <> "" And test <> ""
End Sub

'Configura frase global (cria Salt + TestValue)
Public Sub SetupGlobalPassphrase(phrase As String)
	If phrase.Length = 0 Then Return

	'Gera salt aleatorio
	Dim salt As String = GenerateRandomSalt

	'Cria test value usando PBKDF2 (igual ao PIN)
	Dim normalizedPhrase As String = NormalizePassphrase(phrase)
	Dim hashBytes() As Byte = DeriveKeyPBKDF2(normalizedPhrase, salt)
	If hashBytes = Null Then Return

	Dim testValue As String = BytesToHex(hashBytes)
	ZeroBytes(hashBytes)

	SetSetting("globalSalt", salt)
	SetSetting("globalTestValue", testValue)
End Sub

'Valida frase global
Public Sub ValidateGlobalPassphrase(phrase As String) As Boolean
	Dim salt As String = GetSetting("globalSalt", "")
	Dim testValue As String = GetSetting("globalTestValue", "")

	If salt = "" Or testValue = "" Then Return False

	Dim normalizedPhrase As String = NormalizePassphrase(phrase)
	Dim hashBytes() As Byte = DeriveKeyPBKDF2(normalizedPhrase, salt)
	If hashBytes = Null Then Return False

	Dim check As String = BytesToHex(hashBytes)
	ZeroBytes(hashBytes)

	Return SecureCompare(check, testValue)
End Sub

'Retorna salt global (para criptografia)
Public Sub GetGlobalSalt As String
	Return GetSetting("globalSalt", "")
End Sub

'Retorna test value global (para validacao)
Public Sub GetGlobalTestValue As String
	Return GetSetting("globalTestValue", "")
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

	Dim hashBytes() As Byte

	Try
		'Gera salt aleatorio
		Dim salt As String = GenerateRandomSalt

		'Deriva hash usando PBKDF2 (100.000 iteracoes)
		hashBytes = DeriveKeyPBKDF2(pin, salt)
		If hashBytes = Null Then Return

		Dim hashHex As String = BytesToHex(hashBytes)

		'Salva no formato salt:hash
		Dim data As String = salt & ":" & hashHex
		File.WriteString(File.DirInternal, PIN_FILE, data)
		Log("ModSecurity: PIN salvo com PBKDF2")
	Catch
		Log("SavePIN erro: " & LastException)
	End Try

	'Limpar dados sensiveis
	ZeroBytes(hashBytes)
End Sub

'Valida PIN informado usando PBKDF2
Public Sub ValidatePIN(inputPin As String) As Boolean
	If HasPIN = False Then Return False

	Dim inputHashBytes() As Byte
	Dim result As Boolean = False

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
		inputHashBytes = DeriveKeyPBKDF2(inputPin, salt)
		If inputHashBytes = Null Then Return False

		Dim inputHash As String = BytesToHex(inputHashBytes)

		'Comparacao segura (tempo constante)
		result = SecureCompare(inputHash, savedHash)

	Catch
		Log("ValidatePIN erro: " & LastException)
	End Try

	'Limpar dados sensiveis
	ZeroBytes(inputHashBytes)

	Return result
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
'  LIMPEZA DE MEMORIA SENSIVEL
' ============================================

'Zera array de bytes para remover dados sensiveis da memoria
'IMPORTANTE: Chamar apos uso de chaves, IVs, dados descriptografados
Private Sub ZeroBytes(bytes() As Byte)
	If bytes = Null Then Return
	For i = 0 To bytes.Length - 1
		bytes(i) = 0
	Next
End Sub

'Zera array de caracteres (para senhas)
Private Sub ZeroChars(chars() As Char)
	If chars = Null Then Return
	For i = 0 To chars.Length - 1
		chars(i) = Chr(0)
	Next
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

' ============================================
'  INDICADOR DE FORCA DE SENHA
' ============================================
'
' Calcula forca da senha baseado em:
' - Tamanho (8-11=fraca, 12-15=media, 16+=forte)
' - Tipos de caracteres (minusculas, maiusculas, numeros, especiais)
'
' Retorna: 0=Fraca, 1=Media, 2=Forte, 3=MuitoForte
'
Public Sub CalculatePasswordStrength(password As String) As Int
	If password.Length = 0 Then Return 0

	'Conta tipos de caracteres
	Dim hasLower As Boolean = False
	Dim hasUpper As Boolean = False
	Dim hasDigit As Boolean = False
	Dim hasSpecial As Boolean = False

	For i = 0 To password.Length - 1
		Dim code As Int = Asc(password.CharAt(i))

		If code >= 97 And code <= 122 Then       'a-z
			hasLower = True
		Else If code >= 65 And code <= 90 Then   'A-Z
			hasUpper = True
		Else If code >= 48 And code <= 57 Then   '0-9
			hasDigit = True
		Else
			hasSpecial = True                     'Qualquer outro caractere
		End If
	Next

	'Conta quantos tipos diferentes
	Dim typeCount As Int = 0
	If hasLower Then typeCount = typeCount + 1
	If hasUpper Then typeCount = typeCount + 1
	If hasDigit Then typeCount = typeCount + 1
	If hasSpecial Then typeCount = typeCount + 1

	'Calcula forca
	Dim length As Int = password.Length

	'Muito Forte: 16+ chars E 4 tipos OU 20+ chars E 3+ tipos
	If (length >= 16 And typeCount >= 4) Or (length >= 20 And typeCount >= 3) Then
		Return 3  'Muito Forte
	End If

	'Forte: 12-15 chars E 3+ tipos OU 16+ chars E 2+ tipos
	If (length >= 12 And typeCount >= 3) Or (length >= 16 And typeCount >= 2) Then
		Return 2  'Forte
	End If

	'Media: 8-11 chars E 2+ tipos OU 12+ chars
	If (length >= 8 And typeCount >= 2) Or length >= 12 Then
		Return 1  'Media
	End If

	'Fraca: menos de 8 chars OU apenas 1 tipo de caractere
	Return 0  'Fraca
End Sub

'Retorna cor para o nivel de forca
Public Sub GetStrengthColor(strength As Int) As Int
	Select strength
		Case 0: Return Colors.RGB(231, 76, 60)    'Vermelho - Fraca
		Case 1: Return Colors.RGB(243, 156, 18)   'Laranja - Media
		Case 2: Return Colors.RGB(39, 174, 96)    'Verde - Forte
		Case 3: Return Colors.RGB(46, 204, 113)   'Verde brilhante - Muito Forte
		Case Else: Return Colors.Gray
	End Select
End Sub

'Retorna texto traduzido para o nivel de forca
Public Sub GetStrengthText(strength As Int) As String
	Select strength
		Case 0: Return ModLang.T("weak")
		Case 1: Return ModLang.T("medium")
		Case 2: Return ModLang.T("strong")
		Case 3: Return ModLang.T("very_strong")
		Case Else: Return ""
	End Select
End Sub
