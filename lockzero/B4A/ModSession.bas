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
	'Frase-senha em memoria (NUNCA salva em disco)
	Private Passphrase As String

	'Controle de tempo
	Private SessionStartTime As Long
	Private LastActivityTime As Long

	'Estado
	Private IsUnlocked As Boolean = False
End Sub

' ============================================
'  CONTROLE DE SESSAO
' ============================================

'Inicia sessao com frase-senha
Public Sub StartSession(phrase As String)
	Passphrase = phrase
	SessionStartTime = DateTime.Now
	LastActivityTime = DateTime.Now
	IsUnlocked = True
	Log("ModSession: Sessao iniciada")
End Sub

'Verifica se sessao esta ativa
Public Sub IsSessionActive As Boolean
	If IsUnlocked = False Then Return False
	If Passphrase = "" Then Return False

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

'Retorna frase-senha (se sessao ativa)
Public Sub GetPassphrase As String
	If IsSessionActive Then
		Return Passphrase
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
	Passphrase = ""
	SessionStartTime = 0
	LastActivityTime = 0
	IsUnlocked = False
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

' ============================================
'  CRIPTOGRAFIA COM SESSAO
' ============================================

'Criptografa usando frase da sessao
Public Sub Encrypt(plainText As String) As String
	If IsSessionActive = False Then Return ""
	Return ModSecurity.Encrypt(Passphrase, plainText)
End Sub

'Descriptografa usando frase da sessao
Public Sub Decrypt(encText As String) As String
	If IsSessionActive = False Then Return ""
	Return ModSecurity.Decrypt(Passphrase, encText)
End Sub

'Verifica se frase esta correta (descriptografando um valor de teste)
Public Sub ValidatePassphrase(phrase As String, testEncrypted As String, testExpected As String) As Boolean
	If testEncrypted = "" Or testExpected = "" Then Return True 'Sem teste, assume valido

	Dim decrypted As String = ModSecurity.Decrypt(phrase, testEncrypted)
	Return decrypted = testExpected
End Sub
