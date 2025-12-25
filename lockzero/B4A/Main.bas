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
	'Paginas B4XPages
	Public pgPasswords As PagePasswords
	Public pgPasswordList As PagePasswordList
	Public pgPasswordEdit As PagePasswordEdit
	Public pgBackup As PageBackup
	Public pgOnboarding As PageOnboarding
	Public pgNotesList As PageNotesList
	Public pgNoteEdit As PageNoteEdit
End Sub

Sub Globals

End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("Main")

	If FirstTime Then
		'Inicializa modulos
		ModPasswords.Init
		ModNotes.Init

		'Cria e registra todas as paginas secundarias
		pgPasswords.Initialize
		pgPasswordList.Initialize
		pgPasswordEdit.Initialize
		pgBackup.Initialize
		pgOnboarding.Initialize
		pgNotesList.Initialize
		pgNoteEdit.Initialize

		B4XPages.AddPage("PagePasswords", pgPasswords)
		B4XPages.AddPage("PagePasswordList", pgPasswordList)
		B4XPages.AddPage("PagePasswordEdit", pgPasswordEdit)
		B4XPages.AddPage("PageBackup", pgBackup)
		B4XPages.AddPage("PageOnboarding", pgOnboarding)
		B4XPages.AddPage("PageNotesList", pgNotesList)
		B4XPages.AddPage("PageNoteEdit", pgNoteEdit)

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
