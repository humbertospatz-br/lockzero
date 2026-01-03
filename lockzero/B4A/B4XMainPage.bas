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
	Public Root As B4XView  'Public para transicoes
	Private xui As XUI

	'=== MENU LATERAL ===
	Private pnlMenuOverlay As Panel
	Private pnlMenu As Panel
	Private svMenu As ScrollView
	Private MenuVisible As Boolean = False

	'=== CSV IMPORT DIALOG ===
	Private pnlCSVOverlay As Panel

	'=== LAYOUT HOME (LOCKZERO_HOME_DEFINITIONS.md) ===
	Private pnlHeader As Panel
	Private pnlContent As Panel
	Private pnlFooter As Panel

	'=== CONSTANTES DE LAYOUT ===
	Private HEADER_HEIGHT As Int = 56dip
	Private FOOTER_HEIGHT As Int = 80dip
	Private GRID_MARGIN As Int = 18dip
	Private GRID_GAP As Int = 14dip
	Private CARD_CORNER As Int = 14dip

	'=== TIMER SESSAO ===
	Private tmrSession As Timer
	Private lblSessionTimer As Label

	'=== AUTENTICACAO PIN/BIOMETRIA ===
	Private Biometric As BiometricManager
	Private pnlLock As Panel			'Overlay de bloqueio
	Private edtPinInput As EditText		'Campo para digitar PIN
	Private btnPinSubmit As Button		'Botao confirmar PIN
	Private lblPinError As Label		'Mensagem de erro
	Private IsAuthenticated As Boolean = False  'Flag de autenticacao

End Sub

Public Sub Initialize
	tmrSession.Initialize("tmrSession", 1000)
	'Biometric.Initialize(Me, "Biometric")
End Sub

Private Sub B4XPage_Created(Root1 As B4XView)
	Root = Root1
	Root.Color = ModTheme.Background

	CreateMainPanel
	CreateSideMenu
	CreateLockScreen		'Overlay de PIN/Biometria

	'Inicializa biometria (precisa ser depois do context estar pronto)
	Biometric.Initialize(Me, "Biometric")
	Log("Biometric initialized, CanAuthenticate: " & Biometric.CanAuthenticate)

	ShowHome
	ApplyTheme
End Sub

Private Sub B4XPage_Appear
	'Define titulo na ActionBar
	CallSub2(Main, "SetPageTitle", "LockZero")

	'Verifica se precisa autenticar (PIN configurado e nao autenticado ainda)
	If ModSecurity.HasPIN And IsAuthenticated = False Then
		ShowLockScreen
		Return  'Nao continua ate autenticar
	End If

	'Atualiza menu, cards e footer (caso idioma tenha mudado)
	RebuildMenuItems
	ShowHome
	RefreshFooter

	'Atualiza display de sessao e inicia timer se ativa
	UpdateSessionDisplay
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

	'Menu lateral - cores da Home
	pnlMenu.Initialize("pnlMenu")
	pnlMenu.Color = ModTheme.HomeBg
	Root.AddView(pnlMenu, -menuW, 0, menuW, height)

	svMenu.Initialize(0)
	svMenu.Color = ModTheme.HomeBg
	pnlMenu.AddView(svMenu, 0, 0, menuW, height)

	RebuildMenuItems
End Sub

Public Sub RebuildMenuItems
	svMenu.Panel.RemoveAllViews
	svMenu.Panel.Color = ModTheme.HomeBg

	Dim menuW As Int = pnlMenu.Width
	Dim top As Int = 0

	'Header do menu com logo - cores da Home
	Dim pnlMenuHeader As Panel
	pnlMenuHeader.Initialize("")
	pnlMenuHeader.Color = ModTheme.HomeHeaderBg
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

	'Menu items (apenas Senhas e Notas)
	AddMenuButton(ModLang.T("passwords"), "mnuPasswords", top, btnW, btnH)
	top = top + btnH + gap

	AddMenuButton(ModLang.T("notes"), "mnuNotes", top, btnW, btnH)
	top = top + btnH + 16dip

	'Separador
	Dim pnlSep As Panel
	pnlSep.Initialize("")
	pnlSep.Color = Colors.ARGB(60, 255, 255, 255)
	svMenu.Panel.AddView(pnlSep, 16dip, top, btnW, 1dip)
	top = top + 16dip

	AddMenuButton(ModLang.T("settings"), "mnuSettings", top, btnW, btnH)
	top = top + btnH + gap

	AddMenuButton(ModLang.T("backup"), "mnuBackup", top, btnW, btnH)
	top = top + btnH + gap

	AddMenuButton(ModLang.T("import_csv"), "mnuImportCSV", top, btnW, btnH)
	top = top + btnH + gap

	svMenu.Panel.Height = top + 50dip
End Sub

Private Sub AddMenuButton(txt As String, eventName As String, top As Int, w As Int, h As Int)
	Dim btn As Button
	btn.Initialize(eventName)
	btn.Text = txt
	btn.TextSize = Starter.FONT_BODY
	btn.TextColor = Colors.White
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
'  PAINEL PRINCIPAL - LAYOUT FIXO (SEM SCROLL)
' ============================================

Private Sub CreateMainPanel
	Dim width As Int = Root.Width
	Dim height As Int = Root.Height

	'Fundo da Home
	Root.Color = ModTheme.HomeBg

	'Header fixo no topo
	pnlHeader.Initialize("pnlHeader")
	pnlHeader.Color = ModTheme.HomeHeaderBg
	Root.AddView(pnlHeader, 0, 0, width, HEADER_HEIGHT)
	CreateHeader

	'Footer fixo na base
	pnlFooter.Initialize("")
	pnlFooter.Color = ModTheme.HomeBg
	Root.AddView(pnlFooter, 0, height - FOOTER_HEIGHT, width, FOOTER_HEIGHT)
	CreateFooter

	'Conteudo central (entre header e footer)
	Dim contentHeight As Int = height - HEADER_HEIGHT - FOOTER_HEIGHT
	pnlContent.Initialize("")
	pnlContent.Color = ModTheme.HomeBg
	Root.AddView(pnlContent, 0, HEADER_HEIGHT, width, contentHeight)
End Sub

' ============================================
'  HEADER - Logo + Titulo + Menu
' ============================================

Private Sub CreateHeader
	Dim width As Int = Root.Width

	'Logo LockZero (esquerda) - Gravity.FILL para preencher corretamente
	Dim ivLogo As ImageView
	ivLogo.Initialize("")
	ivLogo.Gravity = Gravity.FILL
	pnlHeader.AddView(ivLogo, 16dip, 8dip, 40dip, 40dip)
	Try
		#If f
			ivLogo.Bitmap = LoadBitmap(File.DirAssets, "ic_lockzero.png")
		#Else If P
			ivLogo.Bitmap = LoadBitmap(File.DirAssets, "ic_lockzero_premium.png")
		#End If
	Catch
		Log("Erro ao carregar ic_lockzero.png: " & LastException.Message)
	End Try

	'Titulo "LockZero"
	Dim lblTitle As Label
	lblTitle.Initialize("")
	lblTitle.Text = "LockZero"
	lblTitle.TextSize = 20
	lblTitle.TextColor = Colors.White
	lblTitle.Typeface = Typeface.DEFAULT_BOLD
	lblTitle.Gravity = Gravity.CENTER_VERTICAL
	pnlHeader.AddView(lblTitle, 64dip, 0, width - 120dip, HEADER_HEIGHT)

	'Botao menu (direita)
	Dim btnMenu As Button
	btnMenu.Initialize("btnMenu")
	btnMenu.Text = Chr(0x2630) 'Hamburguer ☰
	btnMenu.TextSize = 24
	btnMenu.TextColor = Colors.White
	btnMenu.Color = Colors.Transparent
	pnlHeader.AddView(btnMenu, width - 56dip, 0, 56dip, HEADER_HEIGHT)
End Sub

' ============================================
'  FOOTER - Slogan + Versao
' ============================================

Private Sub CreateFooter
	Dim width As Int = Root.Width
	Dim y As Int = 8dip

	'Slogan
	Dim lblSlogan As Label
	lblSlogan.Initialize("")
	lblSlogan.Text = ModLang.T("app_tagline")
	lblSlogan.TextSize = 14
	lblSlogan.TextColor = Colors.ARGB(180, 255, 255, 255) '~70% alpha
	lblSlogan.Gravity = Gravity.CENTER_HORIZONTAL
	pnlFooter.AddView(lblSlogan, 0, y, width, 22dip)
	y = y + 22dip

	'Versao/Status
	Dim lblVersion As Label
	lblVersion.Initialize("")
	#If P
		lblVersion.Text = ModLang.T("premium_version") & " - v" & Starter.APP_VERSION
	#Else If f
		lblVersion.Text = ModLang.T("free_version") & " - v" & Starter.APP_VERSION
	#End If
	lblVersion.TextSize = 12
	lblVersion.TextColor = Colors.ARGB(140, 255, 255, 255) '~55% alpha
	lblVersion.Gravity = Gravity.CENTER_HORIZONTAL
	pnlFooter.AddView(lblVersion, 0, y, width, 20dip)
	y = y + 24dip

	'Timer de sessao (clicavel para bloquear)
	lblSessionTimer.Initialize("lblSessionTimer")
	lblSessionTimer.Text = ""
	lblSessionTimer.TextSize = 11
	lblSessionTimer.TextColor = Colors.ARGB(160, 255, 255, 255)
	lblSessionTimer.Gravity = Gravity.CENTER_HORIZONTAL
	pnlFooter.AddView(lblSessionTimer, 0, y, width, 18dip)
End Sub

Private Sub RefreshFooter
	pnlFooter.RemoveAllViews
	CreateFooter
End Sub

' ============================================
'  HOME - GRID 2x2 (LOCKZERO_HOME_DEFINITIONS.md)
' ============================================

Private Sub ShowHome
	pnlContent.RemoveAllViews

	Dim width As Int = Root.Width
	Dim contentHeight As Int = pnlContent.Height

	'Calcula tamanho dos cards
	Dim availableWidth As Int = width - (GRID_MARGIN * 2) - GRID_GAP
	Dim cardSize As Int = availableWidth / 2

	'Calcula posicao vertical para centralizar o grid (apenas 1 linha agora)
	Dim gridHeight As Int = cardSize
	Dim startY As Int = (contentHeight - gridHeight) / 2

	'Linha unica: Senhas | Notas
	CreateHomeCard("pnlPasswords", ModLang.T("passwords"), "ic_senha.png", GRID_MARGIN, startY, cardSize)
	CreateHomeCard("pnlNotes", ModLang.T("notes"), "ic_notas.png", GRID_MARGIN + cardSize + GRID_GAP, startY, cardSize)
End Sub

' ============================================
'  CARD DA HOME - Icone + Label
' ============================================

Private Sub CreateHomeCard(eventName As String, labelText As String, iconFile As String, x As Int, y As Int, size As Int)
	'Panel do card - usa ICON_BG RGB(69, 90, 117) #455A75
	Dim pnl As Panel
	pnl.Initialize(eventName)

	Dim xv As B4XView = pnl
	xv.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModTheme.HomeIconBg, CARD_CORNER)
	pnlContent.AddView(pnl, x, y, size, size)

	'Tamanho do icone: 52-60% da largura do card
	Dim iconSize As Int = size * 0.55

	'Posicao do icone: centro vertical a 42% da altura (nao 50%)
	Dim iconY As Int = (size * 0.42) - (iconSize / 2)
	Dim iconX As Int = (size - iconSize) / 2

	'ImageView do icone - Gravity.FILL para preencher corretamente
	Dim ivIcon As ImageView
	ivIcon.Initialize("")
	ivIcon.Gravity = Gravity.FILL
	pnl.AddView(ivIcon, iconX, iconY, iconSize, iconSize)

	Try
		ivIcon.Bitmap = LoadBitmap(File.DirAssets, iconFile)
	Catch
		Log("Erro ao carregar " & iconFile & ": " & LastException.Message)
		'Fallback: mostra texto
		Dim lblFallback As Label
		lblFallback.Initialize("")
		lblFallback.Text = "?"
		lblFallback.TextSize = 32
		lblFallback.TextColor = Colors.White
		lblFallback.Gravity = Gravity.CENTER
		pnl.AddView(lblFallback, iconX, iconY, iconSize, iconSize)
	End Try

	'Label abaixo do icone
	Dim lblSpace As Int = 10dip
	Dim lblY As Int = iconY + iconSize + lblSpace
	Dim lblH As Int = size - lblY - 8dip

	Dim lblLabel As Label
	lblLabel.Initialize("")
	lblLabel.Text = labelText
	lblLabel.TextSize = 15
	lblLabel.TextColor = Colors.ARGB(230, 255, 255, 255) '~90% alpha
	lblLabel.Gravity = Gravity.CENTER_HORIZONTAL
	lblLabel.Typeface = Typeface.DEFAULT_BOLD
	pnl.AddView(lblLabel, 0, lblY, size, lblH)
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
	Dim pg As PagePasswords = B4XPages.GetPage("PagePasswords")
	ModTransition.SlideToLeft(Root, pg.Root)
	B4XPages.ShowPage("PagePasswords")
End Sub

Private Sub mnuNotes_Click
	HideMenu
	NavigateToNotes
End Sub

Private Sub mnuSettings_Click
	HideMenu
	Dim pg As PageSettings = B4XPages.GetPage("PageSettings")
	ModTransition.SlideToLeft(Root, pg.Root)
	B4XPages.ShowPage("PageSettings")
End Sub

Private Sub mnuBackup_Click
	HideMenu
	Dim pg As PageBackup = B4XPages.GetPage("PageBackup")
	ModTransition.SlideToLeft(Root, pg.Root)
	B4XPages.ShowPage("PageBackup")
End Sub

Private Sub mnuImportCSV_Click
	HideMenu
	ShowImportCSVInstructions
End Sub

'Mostra dialog com instrucoes de como exportar CSV do Chrome
Private Sub ShowImportCSVInstructions
	Dim width As Int = Root.Width
	Dim height As Int = Root.Height

	'Cria overlay (usa variavel de classe)
	pnlCSVOverlay.Initialize("pnlCSVOverlay")
	pnlCSVOverlay.Color = Colors.ARGB(180, 0, 0, 0)
	Root.AddView(pnlCSVOverlay, 0, 0, width, height)

	'Dialog
	Dim dialogW As Int = width - 32dip
	Dim dialogH As Int = 480dip  'Aumentado para caber formato CSV
	Dim pnlDialog As Panel
	pnlDialog.Initialize("")
	pnlDialog.Color = ModTheme.HomeHeaderBg
	pnlCSVOverlay.AddView(pnlDialog, 16dip, 60dip, dialogW, dialogH)

	Dim xvDialog As B4XView = pnlDialog
	xvDialog.SetColorAndBorder(ModTheme.HomeHeaderBg, 0, ModTheme.HomeHeaderBg, 12dip)

	Dim y As Int = 12dip

	'Titulo
	Dim lblTitle As Label
	lblTitle.Initialize("")
	lblTitle.Text = ModLang.T("csv_how_to_title")
	lblTitle.TextSize = 16
	lblTitle.TextColor = Colors.White
	lblTitle.Typeface = Typeface.DEFAULT_BOLD
	lblTitle.Gravity = Gravity.CENTER_HORIZONTAL
	pnlDialog.AddView(lblTitle, 0, y, dialogW, 26dip)
	y = y + 35dip

	'Instrucoes
	Dim instructions As List
	instructions.Initialize
	instructions.Add(ModLang.T("csv_how_to_1"))
	instructions.Add(ModLang.T("csv_how_to_2"))
	instructions.Add(ModLang.T("csv_how_to_3"))
	instructions.Add(ModLang.T("csv_how_to_4"))
	instructions.Add(ModLang.T("csv_how_to_5"))

	For Each instruction As String In instructions
		Dim lbl As Label
		lbl.Initialize("")
		lbl.Text = instruction
		lbl.TextSize = 13
		lbl.TextColor = Colors.ARGB(220, 255, 255, 255)
		lbl.Gravity = Gravity.CENTER_VERTICAL
		pnlDialog.AddView(lbl, 16dip, y, dialogW - 32dip, 36dip)
		y = y + 36dip
	Next

	y = y + 20dip

	'Separador
	Dim pnlSep As Panel
	pnlSep.Initialize("")
	pnlSep.Color = Colors.ARGB(60, 255, 255, 255)
	pnlDialog.AddView(pnlSep, 16dip, y, dialogW - 32dip, 1dip)
	y = y + 15dip

	'Titulo formato CSV
	Dim lblFormat As Label
	lblFormat.Initialize("")
	lblFormat.Text = ModLang.T("csv_format_title")
	lblFormat.TextSize = 14
	lblFormat.TextColor = Colors.White
	lblFormat.Typeface = Typeface.DEFAULT_BOLD
	lblFormat.Gravity = Gravity.CENTER_HORIZONTAL
	pnlDialog.AddView(lblFormat, 0, y, dialogW, 22dip)
	y = y + 28dip

	'Info formato
	Dim lblFormatInfo As Label
	lblFormatInfo.Initialize("")
	lblFormatInfo.Text = ModLang.T("csv_format_info")
	lblFormatInfo.TextSize = 12
	lblFormatInfo.TextColor = Colors.ARGB(200, 255, 255, 255)
	pnlDialog.AddView(lblFormatInfo, 16dip, y, dialogW - 32dip, 36dip)
	y = y + 36dip

	'Colunas (destaque) - amarelo claro para contraste no fundo azul
	Dim lblCols As Label
	lblCols.Initialize("")
	lblCols.Text = ModLang.T("csv_format_columns")
	lblCols.TextSize = 13
	lblCols.TextColor = Colors.RGB(255, 235, 130)  'Amarelo claro
	lblCols.Typeface = Typeface.MONOSPACE
	lblCols.Gravity = Gravity.CENTER
	pnlDialog.AddView(lblCols, 16dip, y, dialogW - 32dip, 24dip)
	y = y + 28dip

	'Nota formato
	Dim lblFormatNote As Label
	lblFormatNote.Initialize("")
	lblFormatNote.Text = ModLang.T("csv_format_note")
	lblFormatNote.TextSize = 11
	lblFormatNote.TextColor = Colors.ARGB(160, 255, 255, 255)
	pnlDialog.AddView(lblFormatNote, 16dip, y, dialogW - 32dip, 36dip)
	y = y + 40dip

	'Botao Entendi
	Dim btnOk As Button
	btnOk.Initialize("btnCancelCSV")
	btnOk.Text = ModLang.T("understood")
	btnOk.TextSize = 14
	btnOk.Color = ModTheme.HomeIconBg
	btnOk.TextColor = Colors.White
	pnlDialog.AddView(btnOk, (dialogW - 120dip) / 2, y, 120dip, 44dip)

	pnlCSVOverlay.BringToFront
End Sub

Private Sub pnlCSVOverlay_Click
	'Fecha dialog ao clicar fora
	CloseCSVDialog
End Sub

Private Sub btnCancelCSV_Click
	CloseCSVDialog
End Sub

Private Sub CloseCSVDialog
	'Remove overlay usando variavel de classe
	If pnlCSVOverlay.IsInitialized Then
		pnlCSVOverlay.RemoveView
	End If
End Sub


' ============================================
'  EVENTOS DE CATEGORIAS (HOME)
' ============================================

Private Sub pnlPasswords_Click
	HideMenu
	AnimatePulseAndNavigate(Sender, "PagePasswords")
End Sub

Private Sub pnlNotes_Click
	HideMenu
	AnimatePulseAndNavigateNotes(Sender)
End Sub

Private Sub pnlBackup_Click
	HideMenu
	AnimatePulseAndNavigate(Sender, "PageBackup")
End Sub

' ============================================
'  ANIMACAO PULSE
' ============================================

'Efeito pulse: aumenta um pouco e volta
Private Sub AnimatePulse(pnl As Panel)
	Dim xv As B4XView = pnl
	Dim l As Int = xv.Left
	Dim t As Int = xv.Top
	Dim w As Int = xv.Width
	Dim h As Int = xv.Height

	Dim grow As Int = 6dip
	xv.SetLayoutAnimated(100, l - grow, t - grow, w + grow * 2, h + grow * 2)
	Sleep(100)
	xv.SetLayoutAnimated(100, l, t, w, h)
End Sub

'Pulse + navegar para pagina
Private Sub AnimatePulseAndNavigate(pnl As Panel, pageName As String)
	AnimatePulse(pnl)
	Sleep(150)
	'Transicao com snapshot
	Select pageName
		Case "PagePasswords"
			Dim pgPass As PagePasswords = B4XPages.GetPage(pageName)
			ModTransition.SlideToLeft(Root, pgPass.Root)
		Case "PageBackup"
			Dim pgBackup As PageBackup = B4XPages.GetPage(pageName)
			ModTransition.SlideToLeft(Root, pgBackup.Root)
		Case "PageSettings"
			Dim pgSettings As PageSettings = B4XPages.GetPage(pageName)
			ModTransition.SlideToLeft(Root, pgSettings.Root)
	End Select
	B4XPages.ShowPage(pageName)
End Sub

'Pulse + navegar para notas
Private Sub AnimatePulseAndNavigateNotes(pnl As Panel)
	AnimatePulse(pnl)
	Sleep(150)
	NavigateToNotes
End Sub

Private Sub NavigateToNotes
	'Navega para lista de grupos de notas
	Dim pg As PageNotesGroups = B4XPages.GetPage("PageNotesGroups")

	'Transicao com snapshot - slide para esquerda
	ModTransition.SlideToLeft(Root, pg.Root)
	B4XPages.ShowPage("PageNotesGroups")
End Sub

' ============================================
'  TIMER DE SESSAO
' ============================================

Private Sub tmrSession_Tick
	UpdateSessionDisplay
End Sub

Private Sub UpdateSessionDisplay
	If ModSession.IsSessionActive Then
		Dim remaining As String = ModSession.GetRemainingFormatted
		Dim categoryName As String = ModSession.GetSessionCategoryName

		'Se usa frase por categoria e tem categoria, mostra o nome
		If ModSecurity.GetUseSinglePassphrase = False And categoryName <> "" Then
			lblSessionTimer.Text = categoryName & " • " & remaining & " ◀"
		Else
			lblSessionTimer.Text = remaining & " ◀"
		End If

		'Cor azul gelo quando tempo baixo (< 60s) - melhor visibilidade
		Dim remainingSecs As Int = ModSession.GetRemainingSeconds
		If remainingSecs < 60 Then
			lblSessionTimer.TextColor = Colors.RGB(0, 220, 255)  'Azul gelo
		Else
			lblSessionTimer.TextColor = Colors.ARGB(200, 255, 255, 255)
		End If
	Else
		lblSessionTimer.Text = ""
		tmrSession.Enabled = False
	End If
End Sub

'Clique no timer bloqueia a sessao
Private Sub lblSessionTimer_Click
	If ModSession.IsSessionActive = False Then Return

	Wait For (xui.Msgbox2Async(ModLang.T("lock_confirm_msg"), ModLang.T("lock"), ModLang.T("yes"), "", ModLang.T("cancel"), Null)) Msgbox_Result(Result As Int)

	If Result = xui.DialogResponse_Positive Then
		ModSession.Lock
		tmrSession.Enabled = False
		lblSessionTimer.Text = ""
		ToastMessageShow(ModLang.T("locked"), False)
	End If
End Sub

' ============================================
'  AUTENTICACAO PIN/BIOMETRIA
' ============================================

'Cria overlay de bloqueio com campo PIN
Private Sub CreateLockScreen
	Dim width As Int = Root.Width
	Dim height As Int = Root.Height

	'Overlay escuro
	pnlLock.Initialize("")
	pnlLock.Color = ModTheme.HomeBg
	pnlLock.Visible = False
	Root.AddView(pnlLock, 0, 0, width, height)

	'Logo/titulo
	Dim lblLogo As Label
	lblLogo.Initialize("")
	lblLogo.Text = "LockZero"
	lblLogo.TextSize = 28
	lblLogo.TextColor = Colors.White
	lblLogo.Gravity = Gravity.CENTER_HORIZONTAL
	lblLogo.Typeface = Typeface.DEFAULT_BOLD
	pnlLock.AddView(lblLogo, 0, 120dip, width, 40dip)

	'Subtitulo
	Dim lblSubtitle As Label
	lblSubtitle.Initialize("")
	lblSubtitle.Text = ModLang.T("pin_enter")
	lblSubtitle.TextSize = 14
	lblSubtitle.TextColor = Colors.ARGB(180, 255, 255, 255)
	lblSubtitle.Gravity = Gravity.CENTER_HORIZONTAL
	pnlLock.AddView(lblSubtitle, 0, 170dip, width, 30dip)

	'Campo PIN
	edtPinInput.Initialize("edtPinInput")
	edtPinInput.Hint = "PIN"
	edtPinInput.InputType = Bit.Or(2, 8192) 'NUMBER + PASSWORD
	edtPinInput.TextSize = 24
	edtPinInput.TextColor = Colors.White
	edtPinInput.HintColor = Colors.ARGB(100, 255, 255, 255)
	edtPinInput.Gravity = Gravity.CENTER
	Dim xvPin As B4XView = edtPinInput
	xvPin.SetColorAndBorder(Colors.ARGB(40, 255, 255, 255), 1dip, Colors.ARGB(80, 255, 255, 255), 8dip)
	pnlLock.AddView(edtPinInput, width/2 - 100dip, 220dip, 200dip, 50dip)

	'Label de erro
	lblPinError.Initialize("")
	lblPinError.Text = ""
	lblPinError.TextSize = 12
	lblPinError.TextColor = ModTheme.Danger
	lblPinError.Gravity = Gravity.CENTER_HORIZONTAL
	pnlLock.AddView(lblPinError, 0, 280dip, width, 25dip)

	'Botao confirmar
	btnPinSubmit.Initialize("btnPinSubmit")
	btnPinSubmit.Text = ModLang.T("ok")
	btnPinSubmit.TextSize = 16
	btnPinSubmit.TextColor = Colors.White
	Dim xvBtn As B4XView = btnPinSubmit
	xvBtn.SetColorAndBorder(ModTheme.Primary, 0, ModTheme.Primary, 8dip)
	pnlLock.AddView(btnPinSubmit, width/2 - 80dip, 320dip, 160dip, 48dip)

	'Texto biometria
	Dim lblBioHint As Label
	lblBioHint.Initialize("")
	lblBioHint.Text = ModLang.T("biometric_or_pin")
	lblBioHint.TextSize = 12
	lblBioHint.TextColor = Colors.ARGB(120, 255, 255, 255)
	lblBioHint.Gravity = Gravity.CENTER_HORIZONTAL
	pnlLock.AddView(lblBioHint, 0, 390dip, width, 25dip)
End Sub

'Mostra tela de bloqueio e tenta biometria primeiro
Private Sub ShowLockScreen
	pnlLock.Visible = True
	pnlLock.BringToFront
	edtPinInput.Text = ""
	lblPinError.Text = ""

	'Tenta biometria se habilitada e disponivel
	If ModSecurity.GetUseBiometric Then
		Dim canAuth As String = Biometric.CanAuthenticate
		If canAuth = "SUCCESS" Then
			'Delay pequeno para UI carregar, depois mostra biometria
			Sleep(300)
			Biometric.Show(ModLang.T("biometric_prompt"))
		End If
	End If
End Sub

'Esconde tela de bloqueio apos autenticar
Private Sub HideLockScreen
	IsAuthenticated = True
	pnlLock.Visible = False

	'Continua o fluxo normal do B4XPage_Appear
	RebuildMenuItems
	ShowHome
	RefreshFooter
	UpdateSessionDisplay
	If ModSession.IsSessionActive Then
		tmrSession.Enabled = True
	End If
End Sub

'Callback da biometria
Private Sub Biometric_Complete(Success As Boolean, ErrorMessage As String)
	If Success Then
		Log("Biometria: Sucesso")
		HideLockScreen
	Else
		Log("Biometria: Falha - " & ErrorMessage)
		'Nao mostra erro, usuario pode digitar PIN
	End If
End Sub

'Botao confirmar PIN
Private Sub btnPinSubmit_Click
	Dim pin As String = edtPinInput.Text.Trim

	If pin.Length < 4 Then
		lblPinError.Text = ModLang.T("pin_too_short")
		Return
	End If

	If ModSecurity.ValidatePIN(pin) Then
		HideLockScreen
	Else
		lblPinError.Text = ModLang.T("pin_wrong")
		edtPinInput.Text = ""
	End If
End Sub

'Enter no campo PIN
Private Sub edtPinInput_EnterPressed
	btnPinSubmit_Click
End Sub

' ============================================
'  TEMA
' ============================================

Private Sub ApplyTheme
	Root.Color = ModTheme.HomeBg

	If pnlHeader.IsInitialized Then pnlHeader.Color = ModTheme.HomeHeaderBg
	If pnlContent.IsInitialized Then pnlContent.Color = ModTheme.HomeBg
	If pnlFooter.IsInitialized Then pnlFooter.Color = ModTheme.HomeBg
	If pnlMenu.IsInitialized Then pnlMenu.Color = ModTheme.HomeBg
	If svMenu.IsInitialized Then svMenu.Panel.Color = ModTheme.HomeBg
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
