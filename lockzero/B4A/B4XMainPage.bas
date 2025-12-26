B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
'B4XMainPage.bas - Pagina Principal B4xPages
'LockZero - Lock and ZERO worries
'Home com menu lateral estilo LockSeed

Sub Class_Globals
	Private Root As B4XView
	Private xui As XUI

	'=== MENU LATERAL ===
	Private pnlMenuOverlay As Panel
	Private pnlMenu As Panel
	Private svMenu As ScrollView
	Private MenuVisible As Boolean = False

	'=== CONTEUDO PRINCIPAL ===
	Private svMain As ScrollView
	Private pnlMain As B4XView

	'=== TIMER SESSAO ===
	Private tmrSession As Timer
	Private lblSessionTimer As Label
End Sub

Public Sub Initialize
	tmrSession.Initialize("tmrSession", 1000)
End Sub

Private Sub B4XPage_Created(Root1 As B4XView)
	Root = Root1
	Root.Color = ModTheme.Background

	CreateMainPanel
	CreateSideMenu
	ShowHome
	ApplyTheme
End Sub

Private Sub B4XPage_Appear
	'Define titulo na ActionBar
	CallSub2(Main, "SetPageTitle", "LockZero")

	'Atualiza menu (caso idioma tenha mudado)
	RebuildMenuItems

	'Inicia timer de sessao se ativa
	If ModSession.IsSessionActive Then
		tmrSession.Enabled = True
	End If
End Sub

Private Sub B4XPage_Disappear
	tmrSession.Enabled = False
End Sub

' ============================================
'  MENU LATERAL
' ============================================

Private Sub CreateSideMenu
	Dim width As Int = Root.Width
	Dim height As Int = Root.Height
	Dim menuW As Int = width * 0.70 '70% da largura

	'Overlay escuro
	pnlMenuOverlay.Initialize("pnlMenuOverlay")
	pnlMenuOverlay.Color = Colors.ARGB(150, 0, 0, 0)
	pnlMenuOverlay.Visible = False
	Root.AddView(pnlMenuOverlay, 0, 0, width, height)

	'Menu lateral
	pnlMenu.Initialize("pnlMenu")
	pnlMenu.Color = ModTheme.Surface
	Root.AddView(pnlMenu, -menuW, 0, menuW, height)

	svMenu.Initialize(0)
	svMenu.Color = ModTheme.Surface
	pnlMenu.AddView(svMenu, 0, 0, menuW, height)

	RebuildMenuItems
End Sub

Public Sub RebuildMenuItems
	svMenu.Panel.RemoveAllViews
	svMenu.Panel.Color = ModTheme.Surface

	Dim menuW As Int = pnlMenu.Width
	Dim top As Int = 0

	'Header do menu com logo
	Dim pnlMenuHeader As Panel
	pnlMenuHeader.Initialize("")
	pnlMenuHeader.Color = ModTheme.Primary
	svMenu.Panel.AddView(pnlMenuHeader, 0, top, menuW, 80dip)

	Dim lblMenuTitle As Label
	lblMenuTitle.Initialize("")
	lblMenuTitle.Text = Starter.APP_NAME
	lblMenuTitle.TextSize = 22
	lblMenuTitle.TextColor = Colors.White
	lblMenuTitle.Gravity = Gravity.CENTER_VERTICAL
	lblMenuTitle.Typeface = Typeface.DEFAULT_BOLD
	pnlMenuHeader.AddView(lblMenuTitle, 20dip, 0, menuW - 40dip, 80dip)
	top = top + 80dip + 16dip

	Dim btnW As Int = menuW - 32dip
	Dim btnH As Int = 48dip
	Dim gap As Int = 4dip

	'Menu items
	AddMenuButton(ModLang.T("passwords"), "mnuPasswords", top, btnW, btnH)
	top = top + btnH + gap

	AddMenuButton(ModLang.T("cards"), "mnuCards", top, btnW, btnH)
	top = top + btnH + gap

	AddMenuButton(ModLang.T("documents"), "mnuDocuments", top, btnW, btnH)
	top = top + btnH + gap

	AddMenuButton(ModLang.T("notes"), "mnuNotes", top, btnW, btnH)
	top = top + btnH + 16dip

	'Separador
	Dim pnlSep As Panel
	pnlSep.Initialize("")
	pnlSep.Color = ModTheme.InputBorder
	svMenu.Panel.AddView(pnlSep, 16dip, top, btnW, 1dip)
	top = top + 16dip

	AddMenuButton(ModLang.T("settings"), "mnuSettings", top, btnW, btnH)
	top = top + btnH + gap

	AddMenuButton(ModLang.T("backup"), "mnuBackup", top, btnW, btnH)
	top = top + btnH + gap

	svMenu.Panel.Height = top + 50dip
End Sub

Private Sub AddMenuButton(txt As String, eventName As String, top As Int, w As Int, h As Int)
	Dim btn As Button
	btn.Initialize(eventName)
	btn.Text = txt
	btn.TextSize = Starter.FONT_BODY
	btn.TextColor = ModTheme.TextPrimary
	btn.Color = Colors.Transparent
	btn.Gravity = Gravity.CENTER_VERTICAL + Gravity.LEFT
	svMenu.Panel.AddView(btn, 16dip, top, w, h)
End Sub

Private Sub ToggleMenu
	If pnlMenu.Left < 0 Then
		ShowMenu
	Else
		HideMenu
	End If
End Sub

Private Sub ShowMenu
	pnlMenuOverlay.Visible = True
	pnlMenu.SetLayoutAnimated(200, 0, pnlMenu.Top, pnlMenu.Width, pnlMenu.Height)
	MenuVisible = True
End Sub

Private Sub HideMenu
	If MenuVisible Then
		pnlMenuOverlay.Visible = False
		pnlMenu.SetLayoutAnimated(200, -pnlMenu.Width, pnlMenu.Top, pnlMenu.Width, pnlMenu.Height)
		MenuVisible = False
	End If
End Sub

Private Sub pnlMenuOverlay_Click
	HideMenu
End Sub

' ============================================
'  PAINEL PRINCIPAL
' ============================================

Private Sub CreateMainPanel
	Dim width As Int = Root.Width
	Dim height As Int = Root.Height

	svMain.Initialize(0)
	svMain.Color = ModTheme.Background
	Root.AddView(svMain, 0, 0, width, height)

	pnlMain = svMain.Panel
	pnlMain.Color = ModTheme.Background
End Sub

' ============================================
'  HOME - LISTA VERTICAL PROFISSIONAL
' ============================================

Private Sub ShowHome
	pnlMain.RemoveAllViews
	pnlMain.Color = ModTheme.Background

	Dim width As Int = Root.Width
	Dim y As Int = 16dip
	Dim margin As Int = 16dip

	'Titulo da secao
	Dim lblSection As Label
	lblSection.Initialize("")
	lblSection.Text = "CATEGORIAS"
	lblSection.TextSize = 12
	lblSection.TextColor = ModTheme.TextMuted
	lblSection.Typeface = Typeface.DEFAULT_BOLD
	pnlMain.AddView(lblSection, margin, y, width - margin * 2, 20dip)
	y = y + 30dip

	'Lista de categorias - design vertical
	Dim itemH As Int = 72dip
	Dim cardWidth As Int = width - margin * 2

	'Senhas
	CreateListItem("pnlPasswords", ModLang.T("passwords"), "Gerenciar senhas e credenciais", Chr(0x25C6), ModTheme.Primary, y, cardWidth, itemH, margin)
	y = y + itemH + 8dip

	'Cartoes
	CreateListItem("pnlCards", ModLang.T("cards"), "Cartoes de credito e debito", Chr(0x25A0), ModTheme.CategoryCard, y, cardWidth, itemH, margin)
	y = y + itemH + 8dip

	'Documentos
	CreateListItem("pnlDocuments", ModLang.T("documents"), "Documentos e arquivos seguros", Chr(0x25B2), ModTheme.CategoryDocument, y, cardWidth, itemH, margin)
	y = y + itemH + 8dip

	'Notas
	CreateListItem("pnlNotes", ModLang.T("notes"), "Notas seguras criptografadas", Chr(0x25CF), ModTheme.CategoryNote, y, cardWidth, itemH, margin)
	y = y + itemH + 30dip

	'Slogan
	Dim lblSlogan As Label
	lblSlogan.Initialize("")
	lblSlogan.Text = ModLang.T("app_tagline")
	lblSlogan.TextSize = 14
	lblSlogan.TextColor = ModTheme.TextMuted
	lblSlogan.Gravity = Gravity.CENTER
	pnlMain.AddView(lblSlogan, 0, y, width, 30dip)
	y = y + 40dip

	'Timer de sessao
	lblSessionTimer.Initialize("")
	lblSessionTimer.Text = ""
	lblSessionTimer.TextSize = 12
	lblSessionTimer.TextColor = ModTheme.Primary
	lblSessionTimer.Gravity = Gravity.CENTER
	pnlMain.AddView(lblSessionTimer, 0, y, width, 25dip)
	y = y + 30dip

	'Versao FREE
	Dim lblVersion As Label
	lblVersion.Initialize("")
	lblVersion.Text = "FREE - v" & Starter.APP_VERSION
	lblVersion.TextSize = 12
	lblVersion.TextColor = ModTheme.TextMuted
	lblVersion.Gravity = Gravity.CENTER
	pnlMain.AddView(lblVersion, 0, y, width, 25dip)
	y = y + 35dip

	pnlMain.Height = y + 20dip
End Sub

Private Sub CreateListItem(eventName As String, title As String, subtitle As String, icon As String, iconColor As Int, y As Int, w As Int, h As Int, margin As Int)
	Dim pnl As Panel
	pnl.Initialize(eventName)

	Dim xv As B4XView = pnl
	xv.SetColorAndBorder(ModTheme.Surface, 1dip, ModTheme.CardBorder, 12dip)
	pnlMain.AddView(pnl, margin, y, w, h)

	'Avatar circular
	Dim pnlAvatar As Panel
	pnlAvatar.Initialize("")

	Dim xvAvatar As B4XView = pnlAvatar
	xvAvatar.SetColorAndBorder(iconColor, 0, iconColor, 24dip)
	pnl.AddView(pnlAvatar, 16dip, 12dip, 48dip, 48dip)

	Dim lblIcon As Label
	lblIcon.Initialize("")
	lblIcon.Text = icon
	lblIcon.TextSize = 22
	lblIcon.TextColor = Colors.White
	lblIcon.Gravity = Gravity.CENTER
	pnlAvatar.AddView(lblIcon, 0, 0, 48dip, 48dip)

	'Titulo
	Dim lblTitle As Label
	lblTitle.Initialize("")
	lblTitle.Text = title
	lblTitle.TextSize = 16
	lblTitle.TextColor = ModTheme.TextPrimary
	lblTitle.Typeface = Typeface.DEFAULT_BOLD
	pnl.AddView(lblTitle, 80dip, 14dip, w - 120dip, 24dip)

	'Subtitulo
	Dim lblSubtitle As Label
	lblSubtitle.Initialize("")
	lblSubtitle.Text = subtitle
	lblSubtitle.TextSize = 13
	lblSubtitle.TextColor = ModTheme.TextSecondary
	pnl.AddView(lblSubtitle, 80dip, 38dip, w - 120dip, 22dip)

	'Chevron
	Dim lblChevron As Label
	lblChevron.Initialize("")
	lblChevron.Text = Chr(0x203A) '›
	lblChevron.TextSize = 24
	lblChevron.TextColor = ModTheme.TextMuted
	lblChevron.Gravity = Gravity.CENTER
	pnl.AddView(lblChevron, w - 40dip, 0, 30dip, h)
End Sub

' ============================================
'  EVENTOS DE MENU
' ============================================

Private Sub btnMenu_Click
	ToggleMenu
End Sub

Private Sub pnlMenu_Click
	'Consome clique
End Sub

Private Sub mnuPasswords_Click
	HideMenu
	B4XPages.ShowPage("PagePasswords")
End Sub

Private Sub mnuCards_Click
	HideMenu
	ToastMessageShow(ModLang.T("cards") & " - " & ModLang.T("loading"), False)
End Sub

Private Sub mnuDocuments_Click
	HideMenu
	ToastMessageShow(ModLang.T("documents") & " - " & ModLang.T("loading"), False)
End Sub

Private Sub mnuNotes_Click
	HideMenu
	NavigateToNotes
End Sub

Private Sub mnuSettings_Click
	HideMenu
	ToastMessageShow(ModLang.T("settings") & " - " & ModLang.T("loading"), False)
End Sub

Private Sub mnuBackup_Click
	HideMenu
	B4XPages.ShowPage("PageBackup")
End Sub

' ============================================
'  EVENTOS DE CATEGORIAS (HOME)
' ============================================

Private Sub pnlPasswords_Click
	HideMenu
	B4XPages.ShowPage("PagePasswords")
End Sub

Private Sub pnlCards_Click
	HideMenu
	ToastMessageShow(ModLang.T("cards") & " - " & ModLang.T("loading"), False)
End Sub

Private Sub pnlDocuments_Click
	HideMenu
	ToastMessageShow(ModLang.T("documents") & " - " & ModLang.T("loading"), False)
End Sub

Private Sub pnlNotes_Click
	HideMenu
	NavigateToNotes
End Sub

Private Sub pnlBackup_Click
	HideMenu
	B4XPages.ShowPage("PageBackup")
End Sub

Private Sub NavigateToNotes
	'Usa o grupo "Geral" por padrao para notas
	Dim groups As List = ModPasswords.GetAllGroups
	If groups.Size > 0 Then
		Dim grp As clsPasswordGroup = groups.Get(0)
		Dim pg As PageNotesList = B4XPages.GetPage("PageNotesList")
		pg.SetParams(CreateMap("groupId": grp.Id, "groupName": grp.Name))
		B4XPages.ShowPage("PageNotesList")
	Else
		ToastMessageShow(ModLang.T("empty"), True)
	End If
End Sub

' ============================================
'  TIMER DE SESSAO
' ============================================

Private Sub tmrSession_Tick
	If ModSession.IsSessionActive Then
		Dim remaining As String = ModSession.GetRemainingFormatted
		lblSessionTimer.Text = ModLang.T("session_remaining") & ": " & remaining
		lblSessionTimer.TextColor = ModTheme.Primary
	Else
		lblSessionTimer.Text = ""
		tmrSession.Enabled = False
	End If
End Sub

' ============================================
'  TEMA
' ============================================

Private Sub ApplyTheme
	Root.Color = ModTheme.Background

	If pnlMain.IsInitialized Then pnlMain.Color = ModTheme.Background
	If pnlMenu.IsInitialized Then pnlMenu.Color = ModTheme.Surface
	If svMenu.IsInitialized Then svMenu.Panel.Color = ModTheme.Surface
End Sub

' ============================================
'  BACK BUTTON
' ============================================

Private Sub B4XPage_CloseRequest As ResumableSub
	'Se menu aberto, fecha
	If MenuVisible Then
		HideMenu
		Return False
	End If

	'Confirma saida
	Wait For (xui.Msgbox2Async(ModLang.T("confirm_exit"), Starter.APP_NAME, ModLang.T("yes"), "", ModLang.T("no"), Null)) Msgbox_Result(Result As Int)
	Return Result = xui.DialogResponse_Positive
End Sub
