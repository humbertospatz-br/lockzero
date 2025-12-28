B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=9.85
@EndOfDesignText@
'ModSession.bas - Gerenciador de Sessao
'LockZero - Lock and ZERO worries
'Controle de sessao com frase-senha e timeout

Sub Process_Globals
	'Frase ofuscada em memoria (XOR com salt aleatorio)
	'Nunca em texto claro - outros apps nao conseguem ler
	Private PhraseObfuscated As String
	Private SessionSalt As String

	'Controle de tempo
	Private SessionStartTime As Long
	Private LastActivityTime As Long

	'Estado
	Private IsUnlocked As Boolean = False

	'Categoria da sessao (passwords, cards, documents, notes, wifi)
	'Usado quando configuracao "frase por categoria" esta ativa
	Private SessionCategory As String = ""
End Sub

' ============================================
'  CONTROLE DE SESSAO
' ============================================

'Inicia sessao com frase
'A frase fica ofuscada em memoria (XOR) - outros apps nao conseguem ler
Public Sub StartSession(phrase As String)
	StartSessionWithCategory(phrase, "")
End Sub

'Inicia sessao com frase e categoria especifica
'category: "passwords", "cards", "documents", "notes", "wifi" ou "" para global
Public Sub StartSessionWithCategory(phrase As String, category As String)
	'Gera salt aleatorio para esta sessao
	SessionSalt = ModSecurity.GenerateRandomSalt

	'Ofusca a frase (XOR com salt)
	PhraseObfuscated = Obfuscate(phrase, SessionSalt)

	SessionStartTime = DateTime.Now
	LastActivityTime = DateTime.Now
	IsUnlocked = True
	SessionCategory = category

	If category <> "" Then
		Log("ModSession: Sessao iniciada para categoria: " & category)
	Else
		Log("ModSession: Sessao iniciada (global)")
	End If
End Sub

'Ofusca/desofusca string com XOR (mesma funcao para ambos)
Private Sub Obfuscate(text As String, salt As String) As String
	If text = "" Or salt = "" Then Return ""
	Dim result As StringBuilder
	result.Initialize
	For i = 0 To text.Length - 1
		Dim t As Int = Asc(text.CharAt(i))
		Dim s As Int = Asc(salt.CharAt(i Mod salt.Length))
		Dim x As Int = Bit.Xor(t, s)
		result.Append(Chr(x))
	Next
	Return result.ToString
End Sub

'Verifica se sessao esta ativa
Public Sub IsSessionActive As Boolean
	If IsUnlocked = False Then Return False
	If PhraseObfuscated = "" Then Return False

	'Verifica timeout
	Dim timeoutSeconds As Int = ModSecurity.GetSessionTimeout
	Dim elapsed As Long = (DateTime.Now - LastActivityTime) / 1000

	If elapsed > timeoutSeconds Then
		Log("ModSession: Timeout (" & elapsed & "s > " & timeoutSeconds & "s)")
		EndSession
		Return False
	End If

	Return True
End Sub

'Retorna frase (desofuscada, se sessao ativa)
Public Sub GetPassphrase As String
	If IsSessionActive Then
		Return Obfuscate(PhraseObfuscated, SessionSalt) 'XOR novamente = original
	End If
	Return ""
End Sub

'Registra atividade (reseta timer de inatividade)
Public Sub Touch
	If IsUnlocked Then
		LastActivityTime = DateTime.Now
	End If
End Sub

'Encerra sessao (limpa frase da memoria)
Public Sub EndSession
	PhraseObfuscated = ""
	SessionSalt = ""
	SessionStartTime = 0
	LastActivityTime = 0
	IsUnlocked = False
	SessionCategory = ""
	Log("ModSession: Sessao encerrada")
End Sub

'Bloqueia app (encerra sessao)
Public Sub Lock
	EndSession
End Sub

' ============================================
'  INFORMACOES DA SESSAO
' ============================================

'Tempo restante em segundos
Public Sub GetRemainingSeconds As Int
	If IsSessionActive = False Then Return 0

	Dim timeoutSeconds As Int = ModSecurity.GetSessionTimeout
	Dim elapsed As Long = (DateTime.Now - LastActivityTime) / 1000
	Dim remaining As Int = timeoutSeconds - elapsed

	If remaining < 0 Then Return 0
	Return remaining
End Sub

'Tempo restante formatado (MM:SS)
Public Sub GetRemainingFormatted As String
	Dim secs As Int = GetRemainingSeconds
	Dim mins As Int = secs / 60
	Dim secsRest As Int = secs Mod 60
	Return NumberFormat(mins, 1, 0) & ":" & NumberFormat(secsRest, 2, 0)
End Sub

'Tempo desde inicio da sessao em segundos
Public Sub GetSessionDuration As Int
	If IsUnlocked = False Then Return 0
	Return (DateTime.Now - SessionStartTime) / 1000
End Sub

'Tempo desde ultima atividade em segundos
Public Sub GetInactiveTime As Int
	If IsUnlocked = False Then Return 0
	Return (DateTime.Now - LastActivityTime) / 1000
End Sub

'Verifica se esta desbloqueado (alias)
Public Sub IsLocked As Boolean
	Return Not(IsSessionActive)
End Sub

'Retorna categoria da sessao atual
Public Sub GetSessionCategory As String
	If IsSessionActive = False Then Return ""
	Return SessionCategory
End Sub

'Retorna nome amigavel da categoria (para exibir na UI)
Public Sub GetSessionCategoryName As String
	If IsSessionActive = False Then Return ""
	If SessionCategory = "" Then Return ""

	Select SessionCategory
		Case "passwords": Return ModLang.T("passwords")
		Case "cards": Return ModLang.T("cards")
		Case "documents": Return ModLang.T("documents")
		Case "notes": Return ModLang.T("notes")
		Case "wifi": Return ModLang.T("wifi")
		Case Else: Return SessionCategory
	End Select
End Sub

'Verifica se sessao e valida para uma categoria especifica
'Se "frase unica" estiver ativo, qualquer sessao ativa e valida
'Se "frase por categoria", verifica se categoria confere
Public Sub IsSessionValidForCategory(category As String) As Boolean
	If IsSessionActive = False Then Return False

	'Se usa frase unica, qualquer sessao serve
	If ModSecurity.GetUseSinglePassphrase Then Return True

	'Se usa frase por categoria, verifica se confere
	Return SessionCategory = category Or SessionCategory = ""
End Sub

'Verifica se deve pedir frase ao entrar em uma categoria
'Retorna True se precisa pedir frase
Public Sub NeedsPassphraseForCategory(category As String) As Boolean
	'Se nao tem sessao ativa, precisa
	If IsSessionActive = False Then Return True

	'Se usa frase unica, nao precisa (ja tem sessao)
	If ModSecurity.GetUseSinglePassphrase Then Return False

	'Se usa frase por categoria, verifica se e a mesma categoria
	If SessionCategory = category Then Return False

	'Categoria diferente: encerra sessao atual e precisa nova frase
	EndSession
	Return True
End Sub

' ============================================
'  CRIPTOGRAFIA COM SESSAO
' ============================================

'Criptografa usando frase da sessao
Public Sub Encrypt(plainText As String) As String
	If IsSessionActive = False Then Return ""
	Return ModSecurity.Encrypt(GetPassphrase, plainText)
End Sub

'Descriptografa usando frase da sessao
Public Sub Decrypt(encText As String) As String
	If IsSessionActive = False Then Return ""
	Return ModSecurity.Decrypt(GetPassphrase, encText)
End Sub

'Verifica se frase esta correta (descriptografando um valor de teste)
Public Sub ValidatePassphrase(phrase As String, testEncrypted As String, testExpected As String) As Boolean
	If testEncrypted = "" Or testExpected = "" Then Return True 'Sem teste, assume valido

	Dim decrypted As String = ModSecurity.Decrypt(phrase, testEncrypted)
	Return decrypted = testExpected
End Sub
