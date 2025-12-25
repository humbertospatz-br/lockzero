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

	'=== HEADER ===
	Private pnlHeader As Panel
	Private lblTitle As Label
	Private btnMenu As Button

	'=== MENU LATERAL ===
	Private pnlMenu As Panel
	Private svMenu As ScrollView
	Private MenuVisible As Boolean = False

	'=== CONTEUDO PRINCIPAL ===
	Private pnlMain As Panel

	'=== HOME - Categorias ===
	Private pnlPasswords As Panel
	Private pnlCards As Panel
	Private pnlDocuments As Panel
	Private pnlNotes As Panel
	Private lblPasswords As Label
	Private lblCards As Label
	Private lblDocuments As Label
	Private lblNotes As Label

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

	CreateHeader
	CreateMainPanel
	CreateSideMenu
	ShowHome
	ApplyTheme
End Sub

Private Sub B4XPage_Appear
	'Atualiza textos (caso idioma tenha mudado)
	UpdateHomeLabels
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
'  HEADER
' ============================================

Private Sub CreateHeader
	Dim width As Int = Root.Width

	pnlHeader.Initialize("")
	pnlHeader.Color = ModTheme.HeaderBackground
	Root.AddView(pnlHeader, 0, 0, width, 56dip)

	'Titulo
	lblTitle.Initialize("")
	lblTitle.Text = Starter.APP_NAME
	lblTitle.TextSize = Starter.FONT_SUBTITLE
	lblTitle.TextColor = ModTheme.HeaderText
	lblTitle.Gravity = Gravity.CENTER_VERTICAL
	pnlHeader.AddView(lblTitle, 16dip, 0, width - 70dip, 56dip)

	'Botao Menu (hamburger - 3 tracos usando underscore)
	btnMenu.Initialize("btnMenu")
	btnMenu.Text = "___" & Chr(10) & "___" & Chr(10) & "___"
	btnMenu.TextSize = 10
	btnMenu.Color = Colors.Transparent
	btnMenu.TextColor = ModTheme.HeaderText
	btnMenu.Gravity = Gravity.CENTER
	pnlHeader.AddView(btnMenu, width - 56dip, 4dip, 48dip, 48dip)
End Sub

' ============================================
'  MENU LATERAL
' ============================================

Private Sub CreateSideMenu
	Dim width As Int = Root.Width
	Dim height As Int = Root.Height
	Dim menuW As Int = width * 0.65 '65% da largura

	pnlMenu.Initialize("pnlMenu")
	pnlMenu.Color = ModTheme.Surface
	Root.AddView(pnlMenu, -menuW, 56dip, menuW, height - 56dip)

	svMenu.Initialize(0)
	svMenu.Color = ModTheme.Surface
	pnlMenu.AddView(svMenu, 0, 0, menuW, height - 56dip)

	RebuildMenuItems
End Sub

Public Sub RebuildMenuItems
	svMenu.Panel.RemoveAllViews
	svMenu.Panel.Color = ModTheme.Surface

	Dim top As Int = 16dip
	Dim btnW As Int = pnlMenu.Width - 32dip
	Dim btnH As Int = 44dip
	Dim gap As Int = 8dip

	'Menu items
	AddMenuButton(ModLang.T("passwords"), "mnuPasswords", top, btnW, btnH)
	top = top + btnH + gap

	AddMenuButton(ModLang.T("cards"), "mnuCards", top, btnW, btnH)
	top = top + btnH + gap

	AddMenuButton(ModLang.T("documents"), "mnuDocuments", top, btnW, btnH)
	top = top + btnH + gap

	AddMenuButton(ModLang.T("notes"), "mnuNotes", top, btnW, btnH)
	top = top + btnH + gap * 2

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
	Dim newLeft As Int
	If pnlMenu.Left < 0 Then
		newLeft = 0
		MenuVisible = True
	Else
		newLeft = -pnlMenu.Width
		MenuVisible = False
	End If
	pnlMenu.SetLayoutAnimated(200, newLeft, pnlMenu.Top, pnlMenu.Width, pnlMenu.Height)
End Sub

Private Sub HideMenu
	If MenuVisible Then
		pnlMenu.SetLayoutAnimated(200, -pnlMenu.Width, pnlMenu.Top, pnlMenu.Width, pnlMenu.Height)
		MenuVisible = False
	End If
End Sub

' ============================================
'  PAINEL PRINCIPAL
' ============================================

Private Sub CreateMainPanel
	Dim width As Int = Root.Width
	Dim height As Int = Root.Height

	pnlMain.Initialize("pnlMain")
	pnlMain.Color = ModTheme.Background
	Root.AddView(pnlMain, 0, 56dip, width, height - 56dip)
End Sub

Private Sub pnlMain_Click
	If MenuVisible Then HideMenu
End Sub

' ============================================
'  HOME - CATEGORIAS
' ============================================

Private Sub ShowHome
	pnlMain.RemoveAllViews
	pnlMain.Color = ModTheme.Background

	Dim width As Int = Root.Width
	Dim height As Int = Root.Height - 56dip

	'Layout em grid 2x3
	Dim iconSize As Int = 100dip
	Dim spacing As Int = 20dip
	Dim totalW As Int = 2 * iconSize + spacing
	Dim startX As Int = (width - totalW) / 2
	Dim startY As Int = 40dip

	'Row 1: Senhas, Cartoes
	pnlPasswords = CreateCategoryPanel("pnlPasswords", ModTheme.CategoryPassword)
	pnlMain.AddView(pnlPasswords, startX, startY, iconSize, iconSize + 30dip)
	lblPasswords = CreateCategoryLabel(ModLang.T("passwords"))
	pnlPasswords.AddView(lblPasswords, 0, iconSize, iconSize, 30dip)
	AddCategoryIcon(pnlPasswords, Chr(0x1F512), iconSize) 'Cadeado

	pnlCards = CreateCategoryPanel("pnlCards", ModTheme.CategoryCard)
	pnlMain.AddView(pnlCards, startX + iconSize + spacing, startY, iconSize, iconSize + 30dip)
	lblCards = CreateCategoryLabel(ModLang.T("cards"))
	pnlCards.AddView(lblCards, 0, iconSize, iconSize, 30dip)
	AddCategoryIcon(pnlCards, Chr(0x1F4B3), iconSize) 'Cartao

	'Row 2: Documentos, Notas
	Dim row2Y As Int = startY + iconSize + 50dip

	pnlDocuments = CreateCategoryPanel("pnlDocuments", ModTheme.CategoryDocument)
	pnlMain.AddView(pnlDocuments, startX, row2Y, iconSize, iconSize + 30dip)
	lblDocuments = CreateCategoryLabel(ModLang.T("documents"))
	pnlDocuments.AddView(lblDocuments, 0, iconSize, iconSize, 30dip)
	AddCategoryIcon(pnlDocuments, Chr(0x1F4C4), iconSize) 'Documento

	pnlNotes = CreateCategoryPanel("pnlNotes", ModTheme.CategoryNote)
	pnlMain.AddView(pnlNotes, startX + iconSize + spacing, row2Y, iconSize, iconSize + 30dip)
	lblNotes = CreateCategoryLabel(ModLang.T("notes"))
	pnlNotes.AddView(lblNotes, 0, iconSize, iconSize, 30dip)
	AddCategoryIcon(pnlNotes, Chr(0x1F4DD), iconSize) 'Nota

	'Slogan
	Dim lblSlogan As Label
	lblSlogan.Initialize("")
	lblSlogan.Text = ModLang.T("app_tagline")
	lblSlogan.TextSize = 14
	lblSlogan.TextColor = ModTheme.TextSecondary
	lblSlogan.Gravity = Gravity.CENTER
	pnlMain.AddView(lblSlogan, 0, height - 80dip, width, 30dip)

	'Timer de sessao
	lblSessionTimer.Initialize("")
	lblSessionTimer.Text = ""
	lblSessionTimer.TextSize = Starter.FONT_CAPTION
	lblSessionTimer.TextColor = ModTheme.TextMuted
	lblSessionTimer.Gravity = Gravity.CENTER
	pnlMain.AddView(lblSessionTimer, 0, height - 50dip, width, 25dip)

	'Versao
	Dim lblVersion As Label
	lblVersion.Initialize("")
	lblVersion.Text = "v" & Starter.APP_VERSION
	lblVersion.TextSize = Starter.FONT_CAPTION
	lblVersion.TextColor = ModTheme.TextMuted
	lblVersion.Gravity = Gravity.CENTER
	pnlMain.AddView(lblVersion, 0, height - 30dip, width, 20dip)
End Sub

Private Sub CreateCategoryPanel(eventName As String, bgColor As Int) As Panel
	Dim pnl As Panel
	pnl.Initialize(eventName)
	pnl.Color = bgColor

	Dim xv As B4XView = pnl
	xv.SetColorAndBorder(bgColor, 0, bgColor, 16dip)

	Return pnl
End Sub

Private Sub CreateCategoryLabel(txt As String) As Label
	Dim lbl As Label
	lbl.Initialize("")
	lbl.Text = txt
	lbl.TextSize = Starter.FONT_LABEL
	lbl.TextColor = ModTheme.TextPrimary
	lbl.Gravity = Gravity.CENTER
	Return lbl
End Sub

Private Sub AddCategoryIcon(pnl As Panel, icon As String, size As Int)
	Dim lbl As Label
	lbl.Initialize("")
	lbl.Text = icon
	lbl.TextSize = 40
	lbl.TextColor = Colors.White
	lbl.Gravity = Gravity.CENTER
	pnl.AddView(lbl, 0, 20dip, size, size - 40dip)
End Sub

Private Sub UpdateHomeLabels
	If lblPasswords.IsInitialized Then lblPasswords.Text = ModLang.T("passwords")
	If lblCards.IsInitialized Then lblCards.Text = ModLang.T("cards")
	If lblDocuments.IsInitialized Then lblDocuments.Text = ModLang.T("documents")
	If lblNotes.IsInitialized Then lblNotes.Text = ModLang.T("notes")
	If lblTitle.IsInitialized Then lblTitle.Text = Starter.APP_NAME
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

	If pnlHeader.IsInitialized Then pnlHeader.Color = ModTheme.HeaderBackground
	If lblTitle.IsInitialized Then lblTitle.TextColor = ModTheme.HeaderText
	If btnMenu.IsInitialized Then btnMenu.TextColor = ModTheme.HeaderText

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
