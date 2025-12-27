B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
'PageOnboarding.bas - Tela de Primeiro Uso (Simplificada)
'LockZero - Apenas instrucoes e avisos
'NAO obriga criar frase-senha aqui - faz depois

Sub Class_Globals
	Private Root As B4XView
	Private xui As XUI

	'UI - Telas
	Private pnlWelcome As B4XView
	Private pnlWarning As B4XView
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

	'UI - Complete
	Private lblCompleteTitle As Label
	Private lblCompleteText As Label
	Private btnStart As Button

	'Estado
	Private CurrentStep As Int = 0
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
	'Define titulo na ActionBar
	CallSub2(Main, "SetPageTitle", "LockZero")
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
	lblWelcomeTitle.Text = ModLang.T("onb_welcome_title")
	lblWelcomeTitle.TextSize = Starter.FONT_TITLE
	lblWelcomeTitle.Gravity = Gravity.CENTER_HORIZONTAL
	lblWelcomeTitle.Typeface = Typeface.CreateNew(Typeface.DEFAULT, Typeface.STYLE_BOLD)
	pnlWelcome.AddView(lblWelcomeTitle, margin, 80dip, contentWidth, 50dip)

	lblWelcomeText.Initialize("")
	lblWelcomeText.Text = ModLang.T("onb_welcome_text")
	lblWelcomeText.TextSize = Starter.FONT_BODY
	lblWelcomeText.Gravity = Gravity.CENTER_HORIZONTAL
	pnlWelcome.AddView(lblWelcomeText, margin, 150dip, contentWidth, height - 320dip)

	btnWelcomeNext.Initialize("btnWelcomeNext")
	btnWelcomeNext.Text = ModLang.T("continue")
	btnWelcomeNext.TextSize = Starter.FONT_BUTTON
	pnlWelcome.AddView(btnWelcomeNext, margin, height - 100dip, contentWidth, 50dip)

	'=== STEP 1: WARNING (ZERO RECOVERY) ===
	pnlWarning = xui.CreatePanel("")
	pnlWarning.Visible = False
	Root.AddView(pnlWarning, 0, 0, width, height)

	lblWarningTitle.Initialize("")
	lblWarningTitle.Text = ModLang.T("onb_warning_title")
	lblWarningTitle.TextSize = Starter.FONT_TITLE
	lblWarningTitle.Gravity = Gravity.CENTER_HORIZONTAL
	lblWarningTitle.Typeface = Typeface.CreateNew(Typeface.DEFAULT, Typeface.STYLE_BOLD)
	pnlWarning.AddView(lblWarningTitle, margin, 60dip, contentWidth, 50dip)

	lblWarningText.Initialize("")
	lblWarningText.Text = ModLang.T("onb_warning_text")
	lblWarningText.TextSize = Starter.FONT_BODY
	lblWarningText.Gravity = Gravity.LEFT
	'Aumentado espaco para texto nao cortar
	pnlWarning.AddView(lblWarningText, margin, 120dip, contentWidth, height - 280dip)

	chkUnderstand.Initialize("chkUnderstand")
	chkUnderstand.Text = ModLang.T("onb_understand")
	chkUnderstand.TextSize = Starter.FONT_LABEL
	chkUnderstand.Checked = False
	pnlWarning.AddView(chkUnderstand, margin, height - 150dip, contentWidth, 50dip)

	btnWarningNext.Initialize("btnWarningNext")
	btnWarningNext.Text = ModLang.T("onb_accept")
	btnWarningNext.TextSize = Starter.FONT_BUTTON
	btnWarningNext.Enabled = False
	pnlWarning.AddView(btnWarningNext, margin, height - 90dip, contentWidth, 50dip)

	'=== STEP 2: COMPLETE ===
	pnlComplete = xui.CreatePanel("")
	pnlComplete.Visible = False
	Root.AddView(pnlComplete, 0, 0, width, height)

	lblCompleteTitle.Initialize("")
	lblCompleteTitle.Text = ModLang.T("onb_complete_title")
	lblCompleteTitle.TextSize = 28
	lblCompleteTitle.Gravity = Gravity.CENTER_HORIZONTAL
	lblCompleteTitle.Typeface = Typeface.CreateNew(Typeface.DEFAULT, Typeface.STYLE_BOLD)
	pnlComplete.AddView(lblCompleteTitle, margin, 100dip, contentWidth, 60dip)

	lblCompleteText.Initialize("")
	lblCompleteText.Text = ModLang.T("onb_complete_text")
	lblCompleteText.TextSize = Starter.FONT_BODY
	lblCompleteText.Gravity = Gravity.CENTER_HORIZONTAL
	pnlComplete.AddView(lblCompleteText, margin, 180dip, contentWidth, height - 350dip)

	btnStart.Initialize("btnStart")
	btnStart.Text = ModLang.T("onb_start")
	btnStart.TextSize = Starter.FONT_BUTTON
	pnlComplete.AddView(btnStart, margin, height - 100dip, contentWidth, 50dip)
End Sub

' ============================================
'  NAVEGACAO ENTRE STEPS
' ============================================

Private Sub ShowStep(stepNum As Int)
	CurrentStep = stepNum

	pnlWelcome.Visible = (stepNum = 0)
	pnlWarning.Visible = (stepNum = 1)
	pnlComplete.Visible = (stepNum = 2)
End Sub

Private Sub btnWelcomeNext_Click
	ShowStep(1)
End Sub

Private Sub chkUnderstand_CheckedChange(Checked As Boolean)
	btnWarningNext.Enabled = Checked
	If Checked Then
		btnWarningNext.Color = ModTheme.HomeIconBg
	Else
		btnWarningNext.Color = ModTheme.HomeHeaderBg
	End If
End Sub

Private Sub btnWarningNext_Click
	If chkUnderstand.Checked = False Then
		ToastMessageShow(ModLang.T("onb_must_accept"), True)
		Return
	End If

	'Usuario cria seus proprios grupos quando quiser
	ShowStep(2)
End Sub

' ============================================
'  CONCLUSAO
' ============================================

Private Sub btnStart_Click
	'Marca onboarding como completo
	ModSecurity.SetSetting("onboarding_complete", "true")

	'Vai para a pagina principal
	'Em B4XPages, a MainPage e registrada como "mainpage" (minusculo)
	B4XPages.ShowPageAndRemovePreviousPages("mainpage")
End Sub

' ============================================
'  TEMA
' ============================================

Private Sub ApplyTheme
	Root.Color = ModTheme.HomeBg

	'Welcome
	pnlWelcome.Color = ModTheme.HomeBg
	lblWelcomeTitle.TextColor = Colors.White
	lblWelcomeText.TextColor = Colors.ARGB(200, 255, 255, 255)
	btnWelcomeNext.Color = ModTheme.HomeIconBg
	btnWelcomeNext.TextColor = Colors.White

	'Warning
	pnlWarning.Color = ModTheme.HomeBg
	lblWarningTitle.TextColor = Colors.RGB(255, 200, 100) 'Amarelo suave
	lblWarningText.TextColor = Colors.ARGB(200, 255, 255, 255)
	chkUnderstand.TextColor = Colors.White
	btnWarningNext.Color = ModTheme.HomeHeaderBg
	btnWarningNext.TextColor = Colors.White

	'Complete
	pnlComplete.Color = ModTheme.HomeBg
	lblCompleteTitle.TextColor = Colors.RGB(100, 200, 150) 'Verde suave
	lblCompleteText.TextColor = Colors.ARGB(200, 255, 255, 255)
	btnStart.Color = ModTheme.HomeIconBg
	btnStart.TextColor = Colors.White
End Sub

' ============================================
'  PREVENIR VOLTAR
' ============================================

Private Sub B4XPage_CloseRequest As ResumableSub
	'Nao permite fechar o onboarding antes de completar
	If CurrentStep < 2 Then
		ToastMessageShow(ModLang.T("onb_complete_setup"), True)
		Return False
	End If
	Return True
End Sub
