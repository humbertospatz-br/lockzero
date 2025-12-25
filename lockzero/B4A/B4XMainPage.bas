B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
'B4XMainPage.bas - Pagina Principal B4xPages
'LockZero - Lock and ZERO worries
'Tela de desbloqueio e dashboard

Sub Class_Globals
	Private Root As B4XView
	Private xui As XUI

	'=== UI - Tela de Desbloqueio ===
	Private pnlUnlock As B4XView
	Private lblLogo As B4XView
	Private lblTagline As B4XView
	Private edtPassphrase As EditText
	Private btnUnlock As Button
	Private lblError As B4XView

	'=== UI - Dashboard ===
	Private pnlDashboard As B4XView
	Private lblHeader As B4XView
	Private lblSessionTimer As B4XView
	Private btnLock As Button
	Private btnSettings As Button

	'Botoes de categoria
	Private btnPasswords As Button
	Private btnCards As Button
	Private btnDocuments As Button
	Private btnNotes As Button
	Private btnWifi As Button

	'=== Timers ===
	Private tmrSession As Timer
End Sub

Public Sub Initialize
	tmrSession.Initialize("tmrSession", 1000)
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	CreateUI
	ApplyTheme
End Sub

Private Sub B4XPage_Appear
	'Verifica estado da sessao
	If ModSession.IsSessionActive Then
		ShowDashboard
		tmrSession.Enabled = True
	Else
		ShowUnlock
		tmrSession.Enabled = False
	End If
End Sub

Private Sub B4XPage_Disappear
	tmrSession.Enabled = False
End Sub

' ============================================
'  CRIAR UI PROGRAMATICAMENTE
' ============================================

Private Sub CreateUI
	Dim width As Int = Root.Width
	Dim height As Int = Root.Height

	'=== PAINEL DE DESBLOQUEIO ===
	pnlUnlock = xui.CreatePanel("")
	pnlUnlock.SetLayoutAnimated(0, 0, 0, width, height)
	Root.AddView(pnlUnlock, 0, 0, width, height)

	'Logo
	lblLogo = CreateLabel("LockZero", 36, True)
	pnlUnlock.AddView(lblLogo, 0, height * 0.2, width, 60dip)

	'Tagline
	lblTagline = CreateLabel("Lock and ZERO worries", 14, False)
	pnlUnlock.AddView(lblTagline, 0, height * 0.2 + 60dip, width, 30dip)

	'Campo de frase-senha
	edtPassphrase.Initialize("edtPassphrase")
	edtPassphrase.Hint = ModLang.T("passphrase_hint")
	edtPassphrase.InputType = Bit.Or(edtPassphrase.INPUT_TYPE_TEXT, 128) 'Password
	edtPassphrase.Gravity = Gravity.CENTER
	pnlUnlock.AddView(edtPassphrase, 40dip, height * 0.45, width - 80dip, 50dip)

	'Botao desbloquear
	btnUnlock.Initialize("btnUnlock")
	btnUnlock.Text = ModLang.T("unlock")
	pnlUnlock.AddView(btnUnlock, 40dip, height * 0.45 + 70dip, width - 80dip, 50dip)

	'Label de erro
	lblError = CreateLabel("", 12, False)
	lblError.Visible = False
	pnlUnlock.AddView(lblError, 0, height * 0.45 + 130dip, width, 30dip)

	'=== PAINEL DO DASHBOARD ===
	pnlDashboard = xui.CreatePanel("")
	pnlDashboard.SetLayoutAnimated(0, 0, 0, width, height)
	pnlDashboard.Visible = False
	Root.AddView(pnlDashboard, 0, 0, width, height)

	'Header
	Dim pnlHeader As B4XView = xui.CreatePanel("")
	pnlHeader.Color = ModTheme.Surface
	pnlDashboard.AddView(pnlHeader, 0, 0, width, 60dip)

	lblHeader = CreateLabel("LockZero", 20, True)
	lblHeader.SetTextAlignment("CENTER", "LEFT")
	pnlHeader.AddView(lblHeader, 16dip, 0, width * 0.5, 60dip)

	lblSessionTimer = CreateLabel("00:00", 14, False)
	lblSessionTimer.SetTextAlignment("CENTER", "CENTER")
	pnlHeader.AddView(lblSessionTimer, width - 80dip, 15dip, 60dip, 30dip)

	'Botao lock no header
	btnLock.Initialize("btnLock")
	btnLock.Text = "X"
	pnlHeader.AddView(btnLock, width - 50dip, 15dip, 40dip, 30dip)

	'=== CATEGORIAS ===
	Dim catY As Int = 80dip
	Dim catWidth As Int = (width - 60dip) / 2
	Dim catHeight As Int = 80dip
	Dim catGap As Int = 10dip

	'Senhas
	btnPasswords = CreateCategoryButton("btnPasswords", ModLang.T("passwords"), ModTheme.CategoryPassword)
	pnlDashboard.AddView(btnPasswords, 20dip, catY, catWidth, catHeight)

	'Cartoes
	btnCards = CreateCategoryButton("btnCards", ModLang.T("cards"), ModTheme.CategoryCard)
	pnlDashboard.AddView(btnCards, 20dip + catWidth + catGap, catY, catWidth, catHeight)

	'Documentos
	btnDocuments = CreateCategoryButton("btnDocuments", ModLang.T("documents"), ModTheme.CategoryDocument)
	pnlDashboard.AddView(btnDocuments, 20dip, catY + catHeight + catGap, catWidth, catHeight)

	'Notas
	btnNotes = CreateCategoryButton("btnNotes", ModLang.T("notes"), ModTheme.CategoryNote)
	pnlDashboard.AddView(btnNotes, 20dip + catWidth + catGap, catY + catHeight + catGap, catWidth, catHeight)

	'WiFi
	btnWifi = CreateCategoryButton("btnWifi", ModLang.T("wifi"), ModTheme.CategoryWifi)
	pnlDashboard.AddView(btnWifi, 20dip, catY + (catHeight + catGap) * 2, catWidth, catHeight)

	'Configuracoes
	btnSettings.Initialize("btnSettings")
	btnSettings.Text = ModLang.T("settings")
	pnlDashboard.AddView(btnSettings, 20dip + catWidth + catGap, catY + (catHeight + catGap) * 2, catWidth, catHeight)
End Sub

Private Sub CreateLabel(text As String, size As Float, bold As Boolean) As B4XView
	Dim lbl As Label
	lbl.Initialize("")
	lbl.Text = text
	lbl.TextSize = size
	lbl.Gravity = Gravity.CENTER
	If bold Then
		Dim tf As Typeface = Typeface.CreateNew(Typeface.DEFAULT, Typeface.STYLE_BOLD)
		lbl.Typeface = tf
	End If
	Return lbl
End Sub

Private Sub CreateCategoryButton(eventName As String, text As String, color As Int) As Button
	Dim btn As Button
	btn.Initialize(eventName)
	btn.Text = text
	btn.Color = color
	btn.TextColor = Colors.White
	Return btn
End Sub

' ============================================
'  TELA DE DESBLOQUEIO
' ============================================

Private Sub ShowUnlock
	pnlUnlock.Visible = True
	pnlDashboard.Visible = False

	lblLogo.Text = ModLang.T("app_name")
	lblTagline.Text = ModLang.T("app_tagline")
	btnUnlock.Text = ModLang.T("unlock")
	lblError.Text = ""
	lblError.Visible = False

	edtPassphrase.Text = ""
	edtPassphrase.RequestFocus
End Sub

Private Sub btnUnlock_Click
	Dim phrase As String = edtPassphrase.Text.Trim

	If phrase.Length < 1 Then
		ShowError(ModLang.T("error_empty_field"))
		Return
	End If

	'Inicia sessao
	ModSession.StartSession(phrase)
	edtPassphrase.Text = "" 'Limpa campo

	ShowDashboard
	tmrSession.Enabled = True
End Sub

Private Sub edtPassphrase_EnterPressed
	btnUnlock_Click
End Sub

Private Sub ShowError(msg As String)
	lblError.Text = msg
	lblError.Visible = True
	lblError.TextColor = ModTheme.Danger
End Sub

' ============================================
'  DASHBOARD
' ============================================

Private Sub ShowDashboard
	pnlUnlock.Visible = False
	pnlDashboard.Visible = True

	lblHeader.Text = ModLang.T("app_name")
	UpdateSessionTimer
End Sub

Private Sub tmrSession_Tick
	If ModSession.IsSessionActive = False Then
		tmrSession.Enabled = False
		ShowUnlock
		ToastMessageShow(ModLang.T("session_expired"), True)
		Return
	End If

	UpdateSessionTimer
End Sub

Private Sub UpdateSessionTimer
	Dim remaining As String = ModSession.GetRemainingFormatted
	lblSessionTimer.Text = remaining
End Sub

Private Sub btnLock_Click
	ModSession.Lock
	tmrSession.Enabled = False
	ShowUnlock
End Sub

Private Sub btnSettings_Click
	ModSession.Touch
	'Por enquanto vai direto para Backup (Settings completo sera criado depois)
	B4XPages.ShowPage("PageBackup", Null)
End Sub

' ============================================
'  NAVEGACAO PARA CATEGORIAS
' ============================================

Private Sub btnPasswords_Click
	ModSession.Touch
	B4XPages.ShowPage("PagePasswords", Null)
End Sub

Private Sub btnCards_Click
	ModSession.Touch
	ToastMessageShow(ModLang.T("cards") & " - Em desenvolvimento", False)
End Sub

Private Sub btnDocuments_Click
	ModSession.Touch
	ToastMessageShow(ModLang.T("documents") & " - Em desenvolvimento", False)
End Sub

Private Sub btnNotes_Click
	ModSession.Touch
	'Usa o grupo "Geral" por padrao para notas
	'TODO: criar tela de grupos de notas se necessario
	Dim groups As List = ModPasswords.GetAllGroups
	If groups.Size > 0 Then
		Dim group As clsPasswordGroup = groups.Get(0)
		B4XPages.ShowPage("PageNotesList", CreateMap("groupId": group.Id, "groupName": group.Name))
	Else
		ToastMessageShow("Crie um grupo primeiro", True)
	End If
End Sub

Private Sub btnWifi_Click
	ModSession.Touch
	ToastMessageShow(ModLang.T("wifi") & " - Em desenvolvimento", False)
End Sub

' ============================================
'  TEMA
' ============================================

Private Sub ApplyTheme
	Root.Color = ModTheme.Background

	'Unlock
	pnlUnlock.Color = ModTheme.Background
	lblLogo.TextColor = ModTheme.Primary
	lblTagline.TextColor = ModTheme.TextSecondary

	edtPassphrase.Background = ModTheme.GetInputDrawable
	edtPassphrase.TextColor = ModTheme.InputText
	edtPassphrase.HintColor = ModTheme.InputHint

	btnUnlock.Color = ModTheme.Primary
	btnUnlock.TextColor = Colors.White

	'Dashboard
	pnlDashboard.Color = ModTheme.Background
	lblHeader.TextColor = ModTheme.TextPrimary
	lblSessionTimer.TextColor = ModTheme.TextSecondary

	btnLock.Color = ModTheme.Danger
	btnLock.TextColor = Colors.White

	btnSettings.Color = ModTheme.ButtonSecondary
	btnSettings.TextColor = ModTheme.TextPrimary
End Sub

' ============================================
'  B4XPAGES EVENTOS
' ============================================

Private Sub B4XPage_CloseRequest As ResumableSub
	Dim result As Int = xui.Msgbox2Async(ModLang.T("confirm_exit"), Starter.APP_NAME, ModLang.T("yes"), "", ModLang.T("no"), Null)
	Wait For Msgbox_Result(Result As Int)
	Return Result = xui.DialogResponse_Positive
End Sub
