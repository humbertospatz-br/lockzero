B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
'PageOnboarding.bas - Tela de Primeiro Uso
'LockZero - Aceite obrigatorio + Backup inicial
'Usuario NAO pode usar o app sem completar onboarding

Sub Class_Globals
	Private Root As B4XView
	Private xui As XUI

	'UI - Telas
	Private pnlWelcome As B4XView
	Private pnlWarning As B4XView
	Private pnlSetup As B4XView
	Private pnlBackup As B4XView
	Private pnlComplete As B4XView

	'UI - Welcome
	Private lblWelcomeTitle As Label
	Private lblWelcomeText As Label
	Private btnWelcomeNext As Button

	'UI - Warning (Zero Recovery)
	Private lblWarningTitle As Label
	Private lblWarningText As Label
	Private chkUnderstand As CheckBox
	Private btnWarningNext As Button

	'UI - Setup (Primeiro grupo + frase)
	Private lblSetupTitle As Label
	Private edtPassphrase As EditText
	Private edtPassphraseConfirm As EditText
	Private lblPassphraseInfo As Label
	Private btnSetupNext As Button

	'UI - Backup (Obrigatorio)
	Private lblBackupTitle As Label
	Private lblBackupText As Label
	Private btnCreateBackup As Button
	Private lblBackupStatus As Label
	Private btnBackupNext As Button

	'UI - Complete
	Private lblCompleteTitle As Label
	Private lblCompleteText As Label
	Private btnStart As Button

	'Estado
	Private CurrentStep As Int = 0
	Private BackupDone As Boolean = False
	Private SetupPassphrase As String = ""
End Sub

Public Sub Initialize

End Sub

Private Sub B4XPage_Created(Root1 As B4XView)
	Root = Root1
	CreateUI
	ApplyTheme
	ShowStep(0)
End Sub

Private Sub B4XPage_Appear
	'Nao faz touch na sessao pois ainda nao existe
End Sub

' ============================================
'  CRIAR UI
' ============================================

Private Sub CreateUI
	Dim width As Int = Root.Width
	Dim height As Int = Root.Height
	Dim margin As Int = 24dip
	Dim contentWidth As Int = width - (margin * 2)

	'=== STEP 0: WELCOME ===
	pnlWelcome = xui.CreatePanel("")
	Root.AddView(pnlWelcome, 0, 0, width, height)

	lblWelcomeTitle.Initialize("")
	lblWelcomeTitle.Text = "Bem-vindo ao LockZero"
	lblWelcomeTitle.TextSize = 28
	lblWelcomeTitle.Gravity = Gravity.CENTER_HORIZONTAL
	lblWelcomeTitle.Typeface = Typeface.CreateNew(Typeface.DEFAULT, Typeface.STYLE_BOLD)
	pnlWelcome.AddView(lblWelcomeTitle, margin, height * 0.15, contentWidth, 50dip)

	Dim welcomeMsg As String
	welcomeMsg = "Lock and ZERO worries" & CRLF & CRLF
	welcomeMsg = welcomeMsg & "O LockZero e seu cofre digital pessoal." & CRLF & CRLF
	welcomeMsg = welcomeMsg & "• ZERO Internet - Seus dados nunca saem do dispositivo" & CRLF
	welcomeMsg = welcomeMsg & "• ZERO Conhecimento - Nem nos sabemos sua frase" & CRLF
	welcomeMsg = welcomeMsg & "• ZERO Recuperacao - Voce e o unico responsavel" & CRLF
	welcomeMsg = welcomeMsg & "• ZERO Assinatura - Pagamento unico ou gratis"

	lblWelcomeText.Initialize("")
	lblWelcomeText.Text = welcomeMsg
	lblWelcomeText.TextSize = 16
	lblWelcomeText.Gravity = Gravity.CENTER_HORIZONTAL
	pnlWelcome.AddView(lblWelcomeText, margin, height * 0.30, contentWidth, 250dip)

	btnWelcomeNext.Initialize("btnWelcomeNext")
	btnWelcomeNext.Text = "Continuar"
	pnlWelcome.AddView(btnWelcomeNext, margin, height - 120dip, contentWidth, 50dip)

	'=== STEP 1: WARNING (ZERO RECOVERY) ===
	pnlWarning = xui.CreatePanel("")
	pnlWarning.Visible = False
	Root.AddView(pnlWarning, 0, 0, width, height)

	lblWarningTitle.Initialize("")
	lblWarningTitle.Text = "⚠️ AVISO IMPORTANTE"
	lblWarningTitle.TextSize = 24
	lblWarningTitle.Gravity = Gravity.CENTER_HORIZONTAL
	lblWarningTitle.Typeface = Typeface.CreateNew(Typeface.DEFAULT, Typeface.STYLE_BOLD)
	pnlWarning.AddView(lblWarningTitle, margin, height * 0.10, contentWidth, 50dip)

	Dim warningMsg As String
	warningMsg = "LEIA COM ATENCAO:" & CRLF & CRLF
	warningMsg = warningMsg & "1. Sua frase-senha NAO e armazenada em nenhum lugar." & CRLF & CRLF
	warningMsg = warningMsg & "2. Se voce ESQUECER sua frase-senha, PERDERA TODOS OS SEUS DADOS." & CRLF & CRLF
	warningMsg = warningMsg & "3. NAO existe 'Esqueci minha senha'. NAO existe recuperacao." & CRLF & CRLF
	warningMsg = warningMsg & "4. NINGUEM pode ajudar voce. Nem nos, nem a Google, nem ninguem." & CRLF & CRLF
	warningMsg = warningMsg & "5. A UNICA protecao e fazer BACKUPS regulares."

	lblWarningText.Initialize("")
	lblWarningText.Text = warningMsg
	lblWarningText.TextSize = 15
	lblWarningText.Gravity = Gravity.LEFT
	pnlWarning.AddView(lblWarningText, margin, height * 0.20, contentWidth, 300dip)

	chkUnderstand.Initialize("chkUnderstand")
	chkUnderstand.Text = "Eu entendo que NAO ha recuperacao e sou o unico responsavel"
	chkUnderstand.TextSize = 14
	chkUnderstand.Checked = False
	pnlWarning.AddView(chkUnderstand, margin, height - 180dip, contentWidth, 50dip)

	btnWarningNext.Initialize("btnWarningNext")
	btnWarningNext.Text = "Aceitar e Continuar"
	btnWarningNext.Enabled = False
	pnlWarning.AddView(btnWarningNext, margin, height - 120dip, contentWidth, 50dip)

	'=== STEP 2: SETUP (FRASE-SENHA) ===
	pnlSetup = xui.CreatePanel("")
	pnlSetup.Visible = False
	Root.AddView(pnlSetup, 0, 0, width, height)

	lblSetupTitle.Initialize("")
	lblSetupTitle.Text = "Crie sua Frase-Senha"
	lblSetupTitle.TextSize = 24
	lblSetupTitle.Gravity = Gravity.CENTER_HORIZONTAL
	lblSetupTitle.Typeface = Typeface.CreateNew(Typeface.DEFAULT, Typeface.STYLE_BOLD)
	pnlSetup.AddView(lblSetupTitle, margin, height * 0.10, contentWidth, 50dip)

	lblPassphraseInfo.Initialize("")
	lblPassphraseInfo.Text = "Esta frase sera usada para criptografar todos os seus dados. Escolha algo que voce possa lembrar, mas que seja dificil de adivinhar." & CRLF & CRLF & "Minimo: 8 caracteres"
	lblPassphraseInfo.TextSize = 14
	lblPassphraseInfo.Gravity = Gravity.CENTER_HORIZONTAL
	pnlSetup.AddView(lblPassphraseInfo, margin, height * 0.18, contentWidth, 100dip)

	edtPassphrase.Initialize("edtPassphrase")
	edtPassphrase.Hint = "Digite sua frase-senha"
	edtPassphrase.InputType = Bit.Or(edtPassphrase.INPUT_TYPE_TEXT, 128)
	edtPassphrase.SingleLine = True
	pnlSetup.AddView(edtPassphrase, margin, height * 0.40, contentWidth, 50dip)

	edtPassphraseConfirm.Initialize("edtPassphraseConfirm")
	edtPassphraseConfirm.Hint = "Confirme sua frase-senha"
	edtPassphraseConfirm.InputType = Bit.Or(edtPassphraseConfirm.INPUT_TYPE_TEXT, 128)
	edtPassphraseConfirm.SingleLine = True
	pnlSetup.AddView(edtPassphraseConfirm, margin, height * 0.40 + 60dip, contentWidth, 50dip)

	btnSetupNext.Initialize("btnSetupNext")
	btnSetupNext.Text = "Criar e Continuar"
	pnlSetup.AddView(btnSetupNext, margin, height - 120dip, contentWidth, 50dip)

	'=== STEP 3: BACKUP (OBRIGATORIO) ===
	pnlBackup = xui.CreatePanel("")
	pnlBackup.Visible = False
	Root.AddView(pnlBackup, 0, 0, width, height)

	lblBackupTitle.Initialize("")
	lblBackupTitle.Text = "Backup Obrigatorio"
	lblBackupTitle.TextSize = 24
	lblBackupTitle.Gravity = Gravity.CENTER_HORIZONTAL
	lblBackupTitle.Typeface = Typeface.CreateNew(Typeface.DEFAULT, Typeface.STYLE_BOLD)
	pnlBackup.AddView(lblBackupTitle, margin, height * 0.10, contentWidth, 50dip)

	Dim backupMsg As String
	backupMsg = "Antes de comecar a usar o LockZero, voce DEVE criar um backup." & CRLF & CRLF
	backupMsg = backupMsg & "Este backup sera protegido pela sua frase-senha." & CRLF & CRLF
	backupMsg = backupMsg & "Guarde o arquivo .lockzero em local seguro (pendrive, computador, nuvem pessoal)." & CRLF & CRLF
	backupMsg = backupMsg & "Faca backups regulares para proteger seus dados!"

	lblBackupText.Initialize("")
	lblBackupText.Text = backupMsg
	lblBackupText.TextSize = 15
	lblBackupText.Gravity = Gravity.CENTER_HORIZONTAL
	pnlBackup.AddView(lblBackupText, margin, height * 0.22, contentWidth, 200dip)

	btnCreateBackup.Initialize("btnCreateBackup")
	btnCreateBackup.Text = "Criar Backup Agora"
	pnlBackup.AddView(btnCreateBackup, margin, height * 0.55, contentWidth, 50dip)

	lblBackupStatus.Initialize("")
	lblBackupStatus.Text = ""
	lblBackupStatus.TextSize = 14
	lblBackupStatus.Gravity = Gravity.CENTER_HORIZONTAL
	pnlBackup.AddView(lblBackupStatus, margin, height * 0.55 + 60dip, contentWidth, 50dip)

	btnBackupNext.Initialize("btnBackupNext")
	btnBackupNext.Text = "Continuar"
	btnBackupNext.Enabled = False
	pnlBackup.AddView(btnBackupNext, margin, height - 120dip, contentWidth, 50dip)

	'=== STEP 4: COMPLETE ===
	pnlComplete = xui.CreatePanel("")
	pnlComplete.Visible = False
	Root.AddView(pnlComplete, 0, 0, width, height)

	lblCompleteTitle.Initialize("")
	lblCompleteTitle.Text = "Tudo Pronto!"
	lblCompleteTitle.TextSize = 28
	lblCompleteTitle.Gravity = Gravity.CENTER_HORIZONTAL
	lblCompleteTitle.Typeface = Typeface.CreateNew(Typeface.DEFAULT, Typeface.STYLE_BOLD)
	pnlComplete.AddView(lblCompleteTitle, margin, height * 0.20, contentWidth, 50dip)

	Dim completeMsg As String
	completeMsg = "Seu LockZero esta configurado e protegido." & CRLF & CRLF
	completeMsg = completeMsg & "Lembre-se:" & CRLF
	completeMsg = completeMsg & "• Sua frase-senha: NUNCA esqueca" & CRLF
	completeMsg = completeMsg & "• Backups: Faca regularmente" & CRLF
	completeMsg = completeMsg & "• Seguranca: 100% em suas maos" & CRLF & CRLF
	completeMsg = completeMsg & "Lock and ZERO worries!"

	lblCompleteText.Initialize("")
	lblCompleteText.Text = completeMsg
	lblCompleteText.TextSize = 16
	lblCompleteText.Gravity = Gravity.CENTER_HORIZONTAL
	pnlComplete.AddView(lblCompleteText, margin, height * 0.35, contentWidth, 250dip)

	btnStart.Initialize("btnStart")
	btnStart.Text = "Comecar a Usar"
	pnlComplete.AddView(btnStart, margin, height - 120dip, contentWidth, 50dip)
End Sub

' ============================================
'  NAVEGACAO ENTRE STEPS
' ============================================

Private Sub ShowStep(stepNum As Int)
	CurrentStep = stepNum

	pnlWelcome.Visible = (stepNum = 0)
	pnlWarning.Visible = (stepNum = 1)
	pnlSetup.Visible = (stepNum = 2)
	pnlBackup.Visible = (stepNum = 3)
	pnlComplete.Visible = (stepNum = 4)
End Sub

Private Sub btnWelcomeNext_Click
	ShowStep(1)
End Sub

Private Sub chkUnderstand_CheckedChange(Checked As Boolean)
	btnWarningNext.Enabled = Checked
	If Checked Then
		btnWarningNext.Color = ModTheme.Primary
	Else
		btnWarningNext.Color = ModTheme.ButtonDisabled
	End If
End Sub

Private Sub btnWarningNext_Click
	If chkUnderstand.Checked = False Then
		ToastMessageShow("Voce precisa aceitar os termos", True)
		Return
	End If
	ShowStep(2)
End Sub

Private Sub btnSetupNext_Click
	Dim phrase1 As String = edtPassphrase.Text.Trim
	Dim phrase2 As String = edtPassphraseConfirm.Text.Trim

	'Validacoes
	If phrase1.Length < 8 Then
		ToastMessageShow("Frase-senha deve ter no minimo 8 caracteres", True)
		Return
	End If

	If phrase1 <> phrase2 Then
		ToastMessageShow("As frases-senha nao conferem", True)
		Return
	End If

	'Salva a frase para usar no backup
	SetupPassphrase = phrase1

	'Cria o grupo padrao
	CreateDefaultGroup

	'Inicia a sessao com a frase
	ModSession.StartSession(phrase1)

	ShowStep(3)
End Sub

Private Sub CreateDefaultGroup
	'Cria grupo "Geral" como padrao
	Dim group As clsPasswordGroup
	group.Initialize
	group.Id = ModSecurity.GenerateUUID
	group.Name = "Geral"
	group.Icon = "folder"
	group.Color = ModTheme.CategoryPassword
	group.ProtectionType = "PHRASE"
	group.GenerateSalt
	group.CreatedAt = DateTime.Now
	group.UpdatedAt = DateTime.Now

	ModPasswords.SaveGroup(group)
End Sub

Private Sub btnCreateBackup_Click
	If SetupPassphrase.Length < 1 Then
		ToastMessageShow("Erro interno: frase nao definida", True)
		Return
	End If

	'Usa pasta externa se disponivel
	Dim folder As String = File.DirRootExternal
	If File.ExternalWritable = False Then
		folder = File.DirInternal
	End If

	Dim path As String = ModBackup.ExportBackup(SetupPassphrase, folder)

	If path <> "" Then
		BackupDone = True
		lblBackupStatus.Text = "Backup criado!" & CRLF & path
		lblBackupStatus.TextColor = ModTheme.Success
		btnBackupNext.Enabled = True
		btnBackupNext.Color = ModTheme.Primary
		btnCreateBackup.Text = "Backup Criado ✓"
		btnCreateBackup.Enabled = False
	Else
		lblBackupStatus.Text = "Erro ao criar backup"
		lblBackupStatus.TextColor = ModTheme.Danger
	End If
End Sub

Private Sub btnBackupNext_Click
	If BackupDone = False Then
		ToastMessageShow("Voce precisa criar o backup primeiro", True)
		Return
	End If
	ShowStep(4)
End Sub

Private Sub btnStart_Click
	'Marca onboarding como completo
	ModSecurity.SetSetting("onboarding_complete", "true")

	'Limpa a frase da memoria do onboarding
	SetupPassphrase = ""

	'Fecha esta pagina e vai para a principal
	B4XPages.ClosePage(Me)
End Sub

' ============================================
'  TEMA
' ============================================

Private Sub ApplyTheme
	Root.Color = ModTheme.Background

	'Welcome
	pnlWelcome.Color = ModTheme.Background
	lblWelcomeTitle.TextColor = ModTheme.Primary
	lblWelcomeText.TextColor = ModTheme.TextPrimary
	btnWelcomeNext.Color = ModTheme.Primary
	btnWelcomeNext.TextColor = Colors.White

	'Warning
	pnlWarning.Color = ModTheme.Background
	lblWarningTitle.TextColor = ModTheme.Warning
	lblWarningText.TextColor = ModTheme.TextPrimary
	chkUnderstand.TextColor = ModTheme.TextPrimary
	btnWarningNext.Color = ModTheme.ButtonDisabled
	btnWarningNext.TextColor = Colors.White

	'Setup
	pnlSetup.Color = ModTheme.Background
	lblSetupTitle.TextColor = ModTheme.Primary
	lblPassphraseInfo.TextColor = ModTheme.TextSecondary
	edtPassphrase.TextColor = ModTheme.InputText
	edtPassphrase.HintColor = ModTheme.InputHint
	edtPassphraseConfirm.TextColor = ModTheme.InputText
	edtPassphraseConfirm.HintColor = ModTheme.InputHint
	btnSetupNext.Color = ModTheme.Primary
	btnSetupNext.TextColor = Colors.White

	'Backup
	pnlBackup.Color = ModTheme.Background
	lblBackupTitle.TextColor = ModTheme.Primary
	lblBackupText.TextColor = ModTheme.TextPrimary
	btnCreateBackup.Color = ModTheme.Success
	btnCreateBackup.TextColor = Colors.White
	lblBackupStatus.TextColor = ModTheme.TextSecondary
	btnBackupNext.Color = ModTheme.ButtonDisabled
	btnBackupNext.TextColor = Colors.White

	'Complete
	pnlComplete.Color = ModTheme.Background
	lblCompleteTitle.TextColor = ModTheme.Success
	lblCompleteText.TextColor = ModTheme.TextPrimary
	btnStart.Color = ModTheme.Primary
	btnStart.TextColor = Colors.White
End Sub

' ============================================
'  PREVENIR VOLTAR
' ============================================

Private Sub B4XPage_CloseRequest As ResumableSub
	'Nao permite fechar o onboarding antes de completar
	If CurrentStep < 4 Then
		ToastMessageShow("Complete a configuracao inicial", True)
		Return False
	End If
	Return True
End Sub
