B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
'PageSettings.bas - Tela de Configuracoes
'LockZero - Idioma, Timer, PIN, Biometria, Modo de frase

Sub Class_Globals
	Private Root As B4XView
	Private xui As XUI

	'UI
	Private svContent As ScrollView
	Private pnlContent As B4XView

	'Controles de configuracao
	Private lblLanguageValue As Label
	Private lblTimerValue As Label
	Private lblPassphraseModeValue As Label
	Private chkPIN As CheckBox
	Private chkBiometric As CheckBox

	'Dialog
	Private pnlOverlay As Panel
	Private pnlDialog As Panel

	'PIN temporario para confirmacao
	Private TempPIN As String
End Sub

Public Sub Initialize

End Sub

'Anima entrada da pagina - chamar DEPOIS de B4XPages.ShowPage
Public Sub AnimateIn
	ModTransition.SlideFromRight(Root)
End Sub

Private Sub B4XPage_Created(Root1 As B4XView)
	Root = Root1
	Root.Left = 100%x  'Inicia off-screen para evitar flash
End Sub

Private Sub B4XPage_Appear
	'Reconstroi UI (caso idioma tenha mudado)
	Root.RemoveAllViews
	CreateUI
	ApplyTheme

	'Define titulo na ActionBar
	CallSub2(Main, "SetPageTitle", ModLang.T("settings"))

	'Atualiza valores exibidos
	UpdateDisplayValues
End Sub

' ============================================
'  CRIAR UI
' ============================================

Private Sub CreateUI
	Dim width As Int = Root.Width
	Dim height As Int = Root.Height
	Dim headerH As Int = 56dip

	'Header
	Dim pnlHeader As Panel
	pnlHeader.Initialize("")
	pnlHeader.Color = ModTheme.HomeHeaderBg
	Root.AddView(pnlHeader, 0, 0, width, headerH)

	'Seta voltar
	Dim btnBack As Button
	btnBack.Initialize("btnBack")
	btnBack.Text = "<"
	btnBack.TextSize = 20
	btnBack.Color = Colors.Transparent
	btnBack.TextColor = Colors.White
	btnBack.Gravity = Gravity.CENTER
	pnlHeader.AddView(btnBack, 0, 0, 50dip, headerH)

	'Titulo
	Dim lblTitle As Label
	lblTitle.Initialize("")
	lblTitle.Text = ModLang.T("settings")
	lblTitle.TextSize = 18
	lblTitle.TextColor = Colors.White
	lblTitle.Typeface = Typeface.DEFAULT_BOLD
	lblTitle.Gravity = Gravity.CENTER_VERTICAL
	pnlHeader.AddView(lblTitle, 50dip, 0, width - 60dip, headerH)

	'Conteudo com scroll
	svContent.Initialize(0)
	svContent.Color = ModTheme.HomeBg
	Root.AddView(svContent, 0, headerH, width, height - headerH)

	pnlContent = svContent.Panel
	pnlContent.Color = ModTheme.HomeBg

	Dim y As Int = 20dip
	Dim itemW As Int = width - 32dip

	'=== SECAO: GERAL ===
	y = AddSectionHeader(ModLang.T("settings_general"), y, itemW)

	'Idioma
	y = AddSettingItem("itemLanguage", ModLang.T("language"), "", y, itemW)
	lblLanguageValue.Initialize("")
	lblLanguageValue.Text = ModLang.GetLanguageName
	lblLanguageValue.TextSize = 14
	lblLanguageValue.TextColor = Colors.ARGB(180, 255, 255, 255)
	lblLanguageValue.Gravity = Gravity.RIGHT + Gravity.CENTER_VERTICAL
	pnlContent.AddView(lblLanguageValue, width - 170dip, y - 60dip, 110dip, 50dip)

	'Tempo do Timer
	y = AddSettingItem("itemTimer", ModLang.T("session_timeout"), "", y, itemW)
	lblTimerValue.Initialize("")
	lblTimerValue.Text = GetTimerDisplayValue
	lblTimerValue.TextSize = 14
	lblTimerValue.TextColor = Colors.ARGB(180, 255, 255, 255)
	lblTimerValue.Gravity = Gravity.RIGHT + Gravity.CENTER_VERTICAL
	pnlContent.AddView(lblTimerValue, width - 170dip, y - 60dip, 110dip, 50dip)

	'Modo de frase-senha
	y = AddSettingItem("itemPassphraseMode", ModLang.T("passphrase_mode"), "", y, itemW)
	lblPassphraseModeValue.Initialize("")
	lblPassphraseModeValue.Text = GetPassphraseModeDisplayValue
	lblPassphraseModeValue.TextSize = 14
	lblPassphraseModeValue.TextColor = Colors.ARGB(180, 255, 255, 255)
	lblPassphraseModeValue.Gravity = Gravity.RIGHT + Gravity.CENTER_VERTICAL
	pnlContent.AddView(lblPassphraseModeValue, width - 190dip, y - 60dip, 130dip, 50dip)

	y = y + 10dip

	'=== SECAO: SEGURANCA ===
	y = AddSectionHeader(ModLang.T("settings_security"), y, itemW)

	'PIN de acesso
	y = AddCheckboxItem("chkPIN", ModLang.T("use_pin"), ModLang.T("use_pin_desc"), y, itemW)

	'Biometria
	y = AddCheckboxItem("chkBiometric", ModLang.T("use_biometric"), ModLang.T("use_biometric_desc"), y, itemW)

	y = y + 20dip

	'=== SECAO: DADOS ===
	y = AddSectionHeader(ModLang.T("data"), y, itemW)

	'Limpar dados (botao vermelho de perigo)
	y = AddDangerButton("btnClearData", ModLang.T("clear_data"), ModLang.T("clear_data_desc"), y, itemW)

	y = y + 20dip

	'=== SECAO: SOBRE ===
	y = AddSectionHeader(ModLang.T("about"), y, itemW)

	'Versao
	Dim lblVersion As Label
	lblVersion.Initialize("")
	lblVersion.Text = Starter.APP_NAME & " v" & Starter.APP_VERSION
	lblVersion.TextSize = 14
	lblVersion.TextColor = Colors.ARGB(150, 255, 255, 255)
	lblVersion.Gravity = Gravity.CENTER_HORIZONTAL
	pnlContent.AddView(lblVersion, 16dip, y, itemW, 30dip)
	y = y + 35dip

	'Slogan
	Dim lblSlogan As Label
	lblSlogan.Initialize("")
	lblSlogan.Text = Starter.APP_TAGLINE
	lblSlogan.TextSize = 12
	lblSlogan.TextColor = Colors.ARGB(120, 255, 255, 255)
	lblSlogan.Gravity = Gravity.CENTER_HORIZONTAL
	pnlContent.AddView(lblSlogan, 16dip, y, itemW, 25dip)
	y = y + 40dip

	pnlContent.Height = y + 50dip

	'Overlay para dialogs
	CreateDialogOverlay
End Sub

Private Sub AddSectionHeader(title As String, y As Int, w As Int) As Int
	Dim lbl As Label
	lbl.Initialize("")
	lbl.Text = title.ToUpperCase
	lbl.TextSize = 12
	lbl.TextColor = ModTheme.HomeIconBg
	lbl.Typeface = Typeface.DEFAULT_BOLD
	pnlContent.AddView(lbl, 16dip, y, w, 25dip)
	Return y + 30dip
End Sub

Private Sub AddSettingItem(eventName As String, title As String, subtitle As String, y As Int, w As Int) As Int
	Dim pnl As Panel
	pnl.Initialize(eventName)

	Dim xv As B4XView = pnl
	xv.SetColorAndBorder(ModTheme.HomeHeaderBg, 0, ModTheme.HomeHeaderBg, 10dip)
	pnlContent.AddView(pnl, 16dip, y, w, 60dip)

	'Titulo
	Dim lblTitle As Label
	lblTitle.Initialize("")
	lblTitle.Text = title
	lblTitle.TextSize = 15
	lblTitle.TextColor = Colors.White
	lblTitle.Gravity = Gravity.CENTER_VERTICAL
	pnl.AddView(lblTitle, 16dip, 0, w - 150dip, 60dip)

	'Seta
	Dim lblArrow As Label
	lblArrow.Initialize("")
	lblArrow.Text = ">"
	lblArrow.TextSize = 16
	lblArrow.TextColor = Colors.ARGB(100, 255, 255, 255)
	lblArrow.Gravity = Gravity.CENTER
	pnl.AddView(lblArrow, w - 40dip, 0, 30dip, 60dip)

	Return y + 70dip
End Sub

Private Sub AddCheckboxItem(chkName As String, title As String, subtitle As String, y As Int, w As Int) As Int
	Dim pnl As Panel
	pnl.Initialize("")

	Dim xv As B4XView = pnl
	xv.SetColorAndBorder(ModTheme.HomeHeaderBg, 0, ModTheme.HomeHeaderBg, 10dip)
	pnlContent.AddView(pnl, 16dip, y, w, 70dip)

	'Checkbox
	Dim chk As CheckBox
	chk.Initialize(chkName)
	chk.Text = title
	chk.TextSize = 15
	chk.TextColor = Colors.White

	If chkName = "chkPIN" Then
		chkPIN = chk
		chk.Checked = ModSecurity.HasPIN
	Else If chkName = "chkBiometric" Then
		chkBiometric = chk
		chk.Checked = ModSecurity.GetUseBiometric
	End If

	pnl.AddView(chk, 16dip, 8dip, w - 32dip, 30dip)

	'Subtitulo
	Dim lblSub As Label
	lblSub.Initialize("")
	lblSub.Text = subtitle
	lblSub.TextSize = 12
	lblSub.TextColor = Colors.ARGB(150, 255, 255, 255)
	pnl.AddView(lblSub, 48dip, 38dip, w - 64dip, 25dip)

	Return y + 80dip
End Sub

Private Sub AddDangerButton(btnName As String, title As String, subtitle As String, y As Int, w As Int) As Int
	Dim pnl As Panel
	pnl.Initialize(btnName)

	'Fundo vermelho escuro para indicar perigo
	Dim xv As B4XView = pnl
	xv.SetColorAndBorder(Colors.RGB(120, 30, 30), 0, Colors.RGB(120, 30, 30), 10dip)
	pnlContent.AddView(pnl, 16dip, y, w, 70dip)

	'Titulo
	Dim lblTitle As Label
	lblTitle.Initialize("")
	lblTitle.Text = title
	lblTitle.TextSize = 15
	lblTitle.TextColor = Colors.RGB(255, 100, 100)
	lblTitle.Typeface = Typeface.DEFAULT_BOLD
	lblTitle.Gravity = Gravity.CENTER_VERTICAL
	pnl.AddView(lblTitle, 16dip, 8dip, w - 32dip, 28dip)

	'Subtitulo
	Dim lblSub As Label
	lblSub.Initialize("")
	lblSub.Text = subtitle
	lblSub.TextSize = 12
	lblSub.TextColor = Colors.ARGB(180, 255, 150, 150)
	pnl.AddView(lblSub, 16dip, 38dip, w - 32dip, 25dip)

	Return y + 80dip
End Sub

Private Sub CreateDialogOverlay
	Dim width As Int = Root.Width
	Dim height As Int = Root.Height

	pnlOverlay.Initialize("pnlOverlay")
	pnlOverlay.Color = Colors.ARGB(180, 0, 0, 0)
	pnlOverlay.Visible = False
	Root.AddView(pnlOverlay, 0, 0, width, height)

	Dim dialogW As Int = width - 40dip
	pnlDialog.Initialize("")
	pnlDialog.Color = ModTheme.HomeHeaderBg
	pnlOverlay.AddView(pnlDialog, 20dip, 100dip, dialogW, 250dip)

	Dim xvDialog As B4XView = pnlDialog
	xvDialog.SetColorAndBorder(ModTheme.HomeHeaderBg, 0, ModTheme.HomeHeaderBg, 12dip)
End Sub

' ============================================
'  VALORES DE EXIBICAO
' ============================================

Private Sub UpdateDisplayValues
	lblLanguageValue.Text = ModLang.GetLanguageName
	lblTimerValue.Text = GetTimerDisplayValue
	lblPassphraseModeValue.Text = GetPassphraseModeDisplayValue
	chkPIN.Checked = ModSecurity.HasPIN
	chkBiometric.Checked = ModSecurity.GetUseBiometric
End Sub

Private Sub GetTimerDisplayValue As String
	Dim secs As Int = ModSecurity.GetSessionTimeout
	Dim mins As Int = secs / 60
	Return mins & " min"
End Sub

Private Sub GetPassphraseModeDisplayValue As String
	If ModSecurity.GetUseSinglePassphrase Then
		Return ModLang.T("single_passphrase")
	Else
		Return ModLang.T("multi_passphrase")
	End If
End Sub

' ============================================
'  EVENTOS
' ============================================

Private Sub btnBack_Click
	B4XPages.ClosePage(Me)
End Sub

Private Sub pnlOverlay_Click
	HideDialog
End Sub

Private Sub HideDialog
	pnlOverlay.Visible = False
	Dim ime As IME
	ime.Initialize("")
	ime.HideKeyboard
End Sub

'=== IDIOMA ===
Private Sub itemLanguage_Click
	ShowLanguageDialog
End Sub

Private Sub ShowLanguageDialog
	Dim dialogW As Int = Root.Width - 40dip
	pnlDialog.RemoveAllViews

	'Titulo
	Dim lblTitle As Label
	lblTitle.Initialize("")
	lblTitle.Text = ModLang.T("language")
	lblTitle.TextSize = 16
	lblTitle.TextColor = Colors.White
	lblTitle.Typeface = Typeface.DEFAULT_BOLD
	lblTitle.Gravity = Gravity.CENTER_HORIZONTAL
	pnlDialog.AddView(lblTitle, 0, 16dip, dialogW, 30dip)

	'Opcoes
	Dim btnPT As Button
	btnPT.Initialize("btnLangPT")
	btnPT.Text = "Portugues"
	btnPT.TextSize = 14
	btnPT.Color = ModTheme.HomeIconBg
	btnPT.TextColor = Colors.White
	pnlDialog.AddView(btnPT, 20dip, 60dip, dialogW - 40dip, 48dip)

	Dim btnEN As Button
	btnEN.Initialize("btnLangEN")
	btnEN.Text = "English"
	btnEN.TextSize = 14
	btnEN.Color = ModTheme.HomeIconBg
	btnEN.TextColor = Colors.White
	pnlDialog.AddView(btnEN, 20dip, 118dip, dialogW - 40dip, 48dip)

	'Cancelar
	Dim btnCancel As Button
	btnCancel.Initialize("btnDialogCancel")
	btnCancel.Text = ModLang.T("cancel")
	btnCancel.TextSize = 13
	btnCancel.Color = Colors.Transparent
	btnCancel.TextColor = Colors.ARGB(180, 255, 255, 255)
	pnlDialog.AddView(btnCancel, 20dip, 180dip, dialogW - 40dip, 40dip)

	pnlDialog.SetLayoutAnimated(0, 20dip, 100dip, dialogW, 230dip)
	pnlOverlay.Visible = True
	pnlOverlay.BringToFront
End Sub

Private Sub btnLangPT_Click
	ModLang.SetLanguage("pt")
	ModSecurity.SaveLanguage("pt")
	HideDialog
	RefreshUI
	ToastMessageShow(ModLang.T("success"), False)
End Sub

Private Sub btnLangEN_Click
	ModLang.SetLanguage("en")
	ModSecurity.SaveLanguage("en")
	HideDialog
	RefreshUI
	ToastMessageShow(ModLang.T("success"), False)
End Sub

'Atualiza toda a UI com novo idioma
Private Sub RefreshUI
	Root.RemoveAllViews
	CreateUI
	ApplyTheme
	UpdateDisplayValues
	CallSub2(Main, "SetPageTitle", ModLang.T("settings"))
End Sub

'=== TIMER ===
Private Sub itemTimer_Click
	ShowTimerDialog
End Sub

Private Sub ShowTimerDialog
	Dim dialogW As Int = Root.Width - 40dip
	pnlDialog.RemoveAllViews

	'Titulo
	Dim lblTitle As Label
	lblTitle.Initialize("")
	lblTitle.Text = ModLang.T("session_timeout")
	lblTitle.TextSize = 16
	lblTitle.TextColor = Colors.White
	lblTitle.Typeface = Typeface.DEFAULT_BOLD
	lblTitle.Gravity = Gravity.CENTER_HORIZONTAL
	pnlDialog.AddView(lblTitle, 0, 16dip, dialogW, 30dip)

	'Opcoes: 1, 2, 3 minutos
	Dim btn1 As Button
	btn1.Initialize("btnTimer1")
	btn1.Text = "1 " & ModLang.T("minute")
	btn1.TextSize = 14
	btn1.Color = ModTheme.HomeIconBg
	btn1.TextColor = Colors.White
	pnlDialog.AddView(btn1, 20dip, 60dip, dialogW - 40dip, 44dip)

	Dim btn2 As Button
	btn2.Initialize("btnTimer2")
	btn2.Text = "2 " & ModLang.T("minutes")
	btn2.TextSize = 14
	btn2.Color = ModTheme.HomeIconBg
	btn2.TextColor = Colors.White
	pnlDialog.AddView(btn2, 20dip, 112dip, dialogW - 40dip, 44dip)

	Dim btn3 As Button
	btn3.Initialize("btnTimer3")
	btn3.Text = "3 " & ModLang.T("minutes")
	btn3.TextSize = 14
	btn3.Color = ModTheme.HomeIconBg
	btn3.TextColor = Colors.White
	pnlDialog.AddView(btn3, 20dip, 164dip, dialogW - 40dip, 44dip)

	'Cancelar
	Dim btnCancel As Button
	btnCancel.Initialize("btnDialogCancel")
	btnCancel.Text = ModLang.T("cancel")
	btnCancel.TextSize = 13
	btnCancel.Color = Colors.Transparent
	btnCancel.TextColor = Colors.ARGB(180, 255, 255, 255)
	pnlDialog.AddView(btnCancel, 20dip, 220dip, dialogW - 40dip, 40dip)

	pnlDialog.SetLayoutAnimated(0, 20dip, 100dip, dialogW, 270dip)
	pnlOverlay.Visible = True
	pnlOverlay.BringToFront
End Sub

Private Sub btnTimer1_Click
	ModSecurity.SaveSessionTimeout(60)
	HideDialog
	UpdateDisplayValues
End Sub

Private Sub btnTimer2_Click
	ModSecurity.SaveSessionTimeout(120)
	HideDialog
	UpdateDisplayValues
End Sub

Private Sub btnTimer3_Click
	ModSecurity.SaveSessionTimeout(180)
	HideDialog
	UpdateDisplayValues
End Sub

'=== MODO FRASE-SENHA ===
Private Sub itemPassphraseMode_Click
	ShowPassphraseModeDialog
End Sub

Private Sub ShowPassphraseModeDialog
	Dim dialogW As Int = Root.Width - 40dip
	pnlDialog.RemoveAllViews

	'Titulo
	Dim lblTitle As Label
	lblTitle.Initialize("")
	lblTitle.Text = ModLang.T("passphrase_mode")
	lblTitle.TextSize = 16
	lblTitle.TextColor = Colors.White
	lblTitle.Typeface = Typeface.DEFAULT_BOLD
	lblTitle.Gravity = Gravity.CENTER_HORIZONTAL
	pnlDialog.AddView(lblTitle, 0, 16dip, dialogW, 30dip)

	'Opcao 1: Frase unica
	Dim btn1 As Button
	btn1.Initialize("btnModeSingle")
	btn1.Text = ModLang.T("single_passphrase")
	btn1.TextSize = 14
	btn1.Color = ModTheme.HomeIconBg
	btn1.TextColor = Colors.White
	pnlDialog.AddView(btn1, 20dip, 55dip, dialogW - 40dip, 44dip)

	Dim lbl1 As Label
	lbl1.Initialize("")
	lbl1.Text = ModLang.T("single_passphrase_desc")
	lbl1.TextSize = 11
	lbl1.TextColor = Colors.ARGB(150, 255, 255, 255)
	pnlDialog.AddView(lbl1, 20dip, 100dip, dialogW - 40dip, 20dip)

	'Opcao 2: Frase por categoria
	Dim btn2 As Button
	btn2.Initialize("btnModeMulti")
	btn2.Text = ModLang.T("multi_passphrase")
	btn2.TextSize = 14
	btn2.Color = ModTheme.HomeIconBg
	btn2.TextColor = Colors.White
	pnlDialog.AddView(btn2, 20dip, 130dip, dialogW - 40dip, 44dip)

	Dim lbl2 As Label
	lbl2.Initialize("")
	lbl2.Text = ModLang.T("multi_passphrase_desc")
	lbl2.TextSize = 11
	lbl2.TextColor = Colors.ARGB(150, 255, 255, 255)
	pnlDialog.AddView(lbl2, 20dip, 175dip, dialogW - 40dip, 20dip)

	'Cancelar
	Dim btnCancel As Button
	btnCancel.Initialize("btnDialogCancel")
	btnCancel.Text = ModLang.T("cancel")
	btnCancel.TextSize = 13
	btnCancel.Color = Colors.Transparent
	btnCancel.TextColor = Colors.ARGB(180, 255, 255, 255)
	pnlDialog.AddView(btnCancel, 20dip, 205dip, dialogW - 40dip, 40dip)

	pnlDialog.SetLayoutAnimated(0, 20dip, 100dip, dialogW, 255dip)
	pnlOverlay.Visible = True
	pnlOverlay.BringToFront
End Sub

Private Sub btnModeSingle_Click
	ModSecurity.SetUseSinglePassphrase(True)
	ModSession.EndSession 'Encerra sessao atual para aplicar mudanca
	HideDialog
	UpdateDisplayValues
	ToastMessageShow(ModLang.T("success"), False)
End Sub

Private Sub btnModeMulti_Click
	ModSecurity.SetUseSinglePassphrase(False)
	ModSession.EndSession 'Encerra sessao atual para aplicar mudanca
	HideDialog
	UpdateDisplayValues
	ToastMessageShow(ModLang.T("success"), False)
End Sub

'=== PIN ===
Private Sub chkPIN_CheckedChange(Checked As Boolean)
	If Checked Then
		'Ativar PIN - pedir para criar
		ShowCreatePINDialog
	Else
		'Desativar PIN - confirmar
		ShowRemovePINDialog
	End If
End Sub

Private Sub ShowCreatePINDialog
	'Abre dialog customizado para criar PIN
	ShowPINInputDialog("create")
End Sub

'Dialog customizado para entrada de PIN
Private Sub ShowPINInputDialog(mode As String)
	Dim dialogW As Int = Root.Width - 40dip
	pnlDialog.RemoveAllViews
	pnlDialog.Tag = mode 'Guarda o modo: "create", "confirm", "remove"

	'Titulo
	Dim lblTitle As Label
	lblTitle.Initialize("")
	If mode = "create" Then
		lblTitle.Text = ModLang.T("pin_create")
	Else If mode = "confirm" Then
		lblTitle.Text = ModLang.T("pin_confirm")
	Else
		lblTitle.Text = ModLang.T("pin_enter")
	End If
	lblTitle.TextSize = 16
	lblTitle.TextColor = Colors.White
	lblTitle.Typeface = Typeface.DEFAULT_BOLD
	lblTitle.Gravity = Gravity.CENTER_HORIZONTAL
	pnlDialog.AddView(lblTitle, 0, 16dip, dialogW, 30dip)

	'Subtitulo
	Dim lblSub As Label
	lblSub.Initialize("")
	lblSub.Text = ModLang.T("pin_digits")
	lblSub.TextSize = 12
	lblSub.TextColor = Colors.ARGB(150, 255, 255, 255)
	lblSub.Gravity = Gravity.CENTER_HORIZONTAL
	pnlDialog.AddView(lblSub, 0, 46dip, dialogW, 20dip)

	'Campo PIN
	Dim edtPIN As EditText
	edtPIN.Initialize("edtPIN")
	edtPIN.Hint = "PIN"
	edtPIN.InputType = Bit.Or(2, 8192) 'NUMBER + PASSWORD
	edtPIN.TextSize = 24
	edtPIN.TextColor = Colors.White
	edtPIN.HintColor = Colors.ARGB(100, 255, 255, 255)
	edtPIN.Gravity = Gravity.CENTER
	Dim xvPIN As B4XView = edtPIN
	xvPIN.SetColorAndBorder(Colors.ARGB(40, 255, 255, 255), 1dip, Colors.ARGB(80, 255, 255, 255), 8dip)
	pnlDialog.AddView(edtPIN, dialogW/2 - 80dip, 75dip, 160dip, 50dip)

	'Botao OK
	Dim btnOK As Button
	btnOK.Initialize("btnPINOK")
	btnOK.Text = ModLang.T("ok")
	btnOK.TextSize = 14
	btnOK.Color = ModTheme.HomeIconBg
	btnOK.TextColor = Colors.White
	pnlDialog.AddView(btnOK, 20dip, 145dip, (dialogW - 50dip) / 2, 44dip)

	'Botao Cancelar
	Dim btnCancel As Button
	btnCancel.Initialize("btnPINCancel")
	btnCancel.Text = ModLang.T("cancel")
	btnCancel.TextSize = 14
	btnCancel.Color = Colors.Transparent
	btnCancel.TextColor = Colors.ARGB(180, 255, 255, 255)
	pnlDialog.AddView(btnCancel, dialogW/2 + 5dip, 145dip, (dialogW - 50dip) / 2, 44dip)

	pnlDialog.SetLayoutAnimated(0, 20dip, 150dip, dialogW, 210dip)
	pnlOverlay.Visible = True
	pnlOverlay.BringToFront
End Sub

Private Sub btnPINOK_Click
	'Obtem o campo PIN do dialog
	Dim edtPIN As EditText
	For i = 0 To pnlDialog.NumberOfViews - 1
		Dim v As View = pnlDialog.GetView(i)
		If v Is EditText Then
			edtPIN = v
			Exit
		End If
	Next

	Dim pin As String = edtPIN.Text.Trim
	Dim mode As String = pnlDialog.Tag

	'Valida tamanho (4-8 digitos)
	If pin.Length < 4 Or pin.Length > 8 Then
		ToastMessageShow(ModLang.T("pin_too_short"), False)
		Return
	End If

	If mode = "create" Then
		'Guarda PIN e pede confirmacao
		TempPIN = pin
		HideDialog
		Sleep(200)
		ShowPINInputDialog("confirm")

	Else If mode = "confirm" Then
		'Verifica se bate com o PIN temporario
		If pin = TempPIN Then
			ModSecurity.SavePIN(pin)
			HideDialog
			chkPIN.Checked = True
			ToastMessageShow(ModLang.T("pin_saved"), False)
		Else
			ToastMessageShow(ModLang.T("pin_mismatch"), False)
			'Volta para criar
			TempPIN = ""
			HideDialog
			Sleep(200)
			ShowPINInputDialog("create")
		End If

	Else If mode = "remove" Then
		'Verifica PIN atual para remover
		If ModSecurity.ValidatePIN(pin) Then
			ModSecurity.RemovePIN
			HideDialog
			chkPIN.Checked = False
			ToastMessageShow(ModLang.T("pin_removed"), False)
		Else
			ToastMessageShow(ModLang.T("pin_wrong"), False)
		End If
	End If
End Sub

Private Sub btnPINCancel_Click
	HideDialog
	TempPIN = ""
	'Reverte o checkbox
	chkPIN.Checked = ModSecurity.HasPIN
End Sub

Private Sub ShowRemovePINDialog
	If ModSecurity.HasPIN = False Then Return
	'Pede PIN atual para confirmar remocao
	ShowPINInputDialog("remove")
End Sub

'=== BIOMETRIA ===
Private Sub chkBiometric_CheckedChange(Checked As Boolean)
	ModSecurity.SetUseBiometric(Checked)
	If Checked Then
		ToastMessageShow(ModLang.T("biometric_enabled"), False)
	Else
		ToastMessageShow(ModLang.T("biometric_disabled"), False)
	End If
End Sub

'=== DIALOG CANCEL ===
Private Sub btnDialogCancel_Click
	HideDialog
End Sub

'=== LIMPAR DADOS ===
Private Sub btnClearData_Click
	'Confirmacao dupla para seguranca
	Wait For (xui.Msgbox2Async(ModLang.T("clear_data_confirm"), ModLang.T("warning"), ModLang.T("delete"), "", ModLang.T("cancel"), Null)) Msgbox_Result(Result As Int)

	If Result = xui.DialogResponse_Positive Then
		'Limpa todos os dados
		ClearAllData
		ToastMessageShow(ModLang.T("data_cleared"), True)
		'Volta para HOME
		B4XPages.ShowPageAndRemovePreviousPages("mainpage")
	End If
End Sub

Private Sub ClearAllData
	'Remove arquivos de dados
	If File.Exists(File.DirInternal, "lockzero_passwords.json") Then
		File.Delete(File.DirInternal, "lockzero_passwords.json")
	End If
	If File.Exists(File.DirInternal, "lockzero_notes.json") Then
		File.Delete(File.DirInternal, "lockzero_notes.json")
	End If

	'Reinicializa modulos em memoria (ForceReload recarrega do disco - agora vazio)
	ModPasswords.ForceReload
	ModNotes.ForceReload

	'Encerra sessao
	ModSession.EndSession

	Log("=== DADOS LIMPOS ===")
End Sub

' ============================================
'  TEMA
' ============================================

Private Sub ApplyTheme
	Root.Color = ModTheme.HomeBg
	svContent.Color = ModTheme.HomeBg
	pnlContent.Color = ModTheme.HomeBg
End Sub
