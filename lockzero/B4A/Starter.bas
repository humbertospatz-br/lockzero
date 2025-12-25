B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=9.85
@EndOfDesignText@
'Starter.bas - Servico de Inicializacao
'LockZero - Lock and ZERO worries

#Region  Service Attributes
	#StartAtBoot: False
	#ExcludeFromLibrary: True
#End Region

Sub Process_Globals
	'=== VERSAO DO APP ===
	Public Const APP_NAME As String = "LockZero"
	Public Const APP_VERSION As String = "0.1.0"
	Public Const APP_TAGLINE As String = "Lock and ZERO worries"

	'=== FLAGS ===
	Private IsInitialized As Boolean = False
End Sub

Sub Service_Create
	'Ponto de entrada do app
	'Inicializa todos os modulos na ordem correta
	InitializeApp
End Sub

Sub Service_Start (StartingIntent As Intent)
	Service.StopAutomaticForeground
End Sub

Sub Service_TaskRemoved
	'App removido da lista de recentes
	ModSession.EndSession
End Sub

Sub Application_Error (Error As Exception, StackTrace As String) As Boolean
	Log("=== ERRO CRITICO ===")
	Log("Erro: " & Error.Message)
	Log("Stack: " & StackTrace)
	Return True
End Sub

Sub Service_Destroy
	'Limpa sessao ao destruir servico
	ModSession.EndSession
End Sub

' ============================================
'  INICIALIZACAO
' ============================================

Private Sub InitializeApp
	If IsInitialized Then Return

	Log("=== LockZero " & APP_VERSION & " ===")
	Log("Inicializando...")

	'1. Modulo de idiomas (primeiro para ter textos disponiveis)
	ModLang.Init
	Log("ModLang OK - Idioma: " & ModLang.GetCurrentLanguage)

	'2. Modulo de temas
	ModTheme.Init
	Log("ModTheme OK - Dark: " & ModTheme.IsDarkTheme)

	'3. Sessao limpa (usuario precisa desbloquear)
	ModSession.EndSession
	Log("ModSession OK - Bloqueado")

	IsInitialized = True
	Log("=== Inicializacao completa ===")
End Sub

' ============================================
'  UTILITARIOS GLOBAIS
' ============================================

'Retorna versao formatada
Public Sub GetVersionString As String
	Return APP_NAME & " v" & APP_VERSION
End Sub
