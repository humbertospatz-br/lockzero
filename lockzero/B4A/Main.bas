B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=9.85
@EndOfDesignText@
'Main.bas - Activity Principal
'LockZero - Inicializa B4XPages

#Region  Activity Attributes
	#FullScreen: False
	#IncludeTitle: False
#End Region

#BridgeLogger: True 'Enable logs in Release mode

Sub Process_Globals
	Private xui As XUI
End Sub

Sub Globals

End Sub

Sub Activity_Create(FirstTime As Boolean)
	If FirstTime Then
		'Registra todas as paginas B4XPages
		B4XPages.Initialize
		B4XPages.AddPage("B4XMainPage", B4XMainPage)
		B4XPages.AddPage("PagePasswords", PagePasswords)
		B4XPages.AddPage("PagePasswordList", PagePasswordList)
		B4XPages.AddPage("PagePasswordEdit", PagePasswordEdit)
		B4XPages.AddPage("PageBackup", PageBackup)
		B4XPages.AddPage("PageOnboarding", PageOnboarding)
		B4XPages.AddPage("PageNotesList", PageNotesList)
		B4XPages.AddPage("PageNoteEdit", PageNoteEdit)

		'Inicializa modulos
		ModPasswords.Init
		ModNotes.Init

		'Verifica se e primeiro uso (onboarding nao completo)
		CheckFirstRun
	End If

	'Inicia com a pagina principal
	B4XPages.GetManager.LogEvents = True
	Activity.LoadLayout("Main")
End Sub

Private Sub CheckFirstRun
	Dim onboardingComplete As String = ModSecurity.GetSetting("onboarding_complete", "false")
	If onboardingComplete <> "true" Then
		'Primeiro uso - mostra onboarding
		B4XPages.ShowPageAndRemovePreviousPages("PageOnboarding")
	End If
End Sub

Sub Activity_Resume
	B4XPages.Delegate.Activity_Resume
End Sub

Sub Activity_Pause (UserClosed As Boolean)
	B4XPages.Delegate.Activity_Pause
End Sub

Sub Activity_KeyPress(KeyCode As Int) As Boolean
	Return B4XPages.Delegate.Activity_KeyPress(KeyCode)
End Sub
