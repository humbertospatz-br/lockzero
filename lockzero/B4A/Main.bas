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
	Activity.LoadLayout("Main")

	If FirstTime Then
		'Inicializa modulos
		ModPasswords.Init
		ModNotes.Init

		'Registra todas as paginas secundarias (B4XMainPage ja e registrado automaticamente)
		B4XPages.AddPageAndCreate("PagePasswords", PagePasswords)
		B4XPages.AddPageAndCreate("PagePasswordList", PagePasswordList)
		B4XPages.AddPageAndCreate("PagePasswordEdit", PagePasswordEdit)
		B4XPages.AddPageAndCreate("PageBackup", PageBackup)
		B4XPages.AddPageAndCreate("PageOnboarding", PageOnboarding)
		B4XPages.AddPageAndCreate("PageNotesList", PageNotesList)
		B4XPages.AddPageAndCreate("PageNoteEdit", PageNoteEdit)

		B4XPages.GetManager.LogEvents = True

		'Verifica se e primeiro uso (onboarding nao completo)
		CheckFirstRun
	End If
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
