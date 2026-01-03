B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
'PageNoteEdit.bas - Criar/Editar Nota (Texto ou Lista)
'LockZero - Lock and ZERO worries
'
'Modos:
'- text: Nota tradicional com titulo e conteudo
'- list: Lista de tarefas com checkboxes

Sub Class_Globals
	Public Root As B4XView  'Public para transicoes
	Private xui As XUI

	'UI - Header
	Private btnBack As Button
	Private lblHeaderTitle As Label

	'UI - Barra de icones (header 2)
	Private lblIconAdd As Label     '+ Adicionar item
	Private ivIconDelete As ImageView  'Lixeira - excluir nota (icone Android)
	Private ivIconShare As ImageView   'Compartilhar (icone Android)
	Private lblIconSave As Label    'Salvar

	'UI - Content
	Private svContent As ScrollView
	Private pnlContent As B4XView

	'UI - Comum
	Private edtTitle As EditText
	Private chkFavorite As CheckBox

	'UI - Modo Texto
	Private edtContent As EditText
	Private pnlTextMode As Panel

	'UI - Modo Lista
	Private pnlListMode As Panel
	Private pnlItems As Panel
	Private pnlAddRow As Panel  'Container do botao + adicionar item
	Private lblAddItem As Label
	Private edtFilter As EditText  'Campo de filtro
	Private lblClearFilter As Label  'Botao X para limpar filtro
	Private CurrentFilter As String = ""  'Texto atual do filtro

	'Dialog de input para itens
	Private pnlInputOverlay As Panel
	Private pnlInputDialog As Panel
	Private edtItemText As EditText
	Private EditingItemIndex As Int = -1  '-1 = novo item
	Private IsRebuildingUI As Boolean = False  'Flag para evitar loop no checkbox

	'Estado
	Private CurrentNoteId As String = ""
	Private CurrentGroupId As String = ""
	Private CurrentGroupName As String = ""  'Nome do grupo para breadcrumb
	Private CurrentNoteTitle As String = ""  'Titulo da nota (para edicao)
	Private NoteType As String = "text"
	Private IsNewNote As Boolean = True
	Private IsSecure As Boolean = True
	Private Passphrase As String = ""

	'Lista de itens (para modo lista)
	Private ItemsList As List
	Private ItemPanels As List  'Paineis dos itens na UI

	'Modo cartao - UI exclusiva sem checkboxes/filtro/add
	Private IsCardTemplate As Boolean = False

	'Anexos (integrado com ModAttachments)
	Private ivIconAttach As ImageView  'Icone de anexo no header
	Private pnlAttachments As Panel    'Container para lista de anexos
	Private AttachmentsList As List    'Lista de Maps com info dos anexos (id, originalName, etc)
	Private ContentChooser1 As ContentChooser  'Para selecionar arquivos
	Private PendingAttachDir As String  'Dir temporario do anexo sendo adicionado
	Private PendingAttachFile As String  'Nome do arquivo sendo adicionado
	Private GroupSalt As String = ""  'Salt do grupo para criptografia de anexos
End Sub

Public Sub Initialize
	ItemsList.Initialize
	ItemPanels.Initialize
	AttachmentsList.Initialize
End Sub

Private Sub B4XPage_Created(Root1 As B4XView)
	Root = Root1
	CreateUI
	ApplyTheme
End Sub

Private Sub B4XPage_Appear
	'Breadcrumb: Nota → NomeGrupo → Titulo
	Dim lastPart As String
	If IsNewNote Then
		'Verifica se e grupo de cartoes
		Dim group As clsNoteGroup = ModNotes.GetNoteGroupById(CurrentGroupId)
		If group <> Null And group.TemplateType = "card" Then
			lastPart = ModLang.T("new_card")
		Else If NoteType = "list" Then
			lastPart = ModLang.T("new_list")
		Else
			lastPart = ModLang.T("new_text")
		End If
	Else
		'Edicao: mostra nome da nota
		lastPart = CurrentNoteTitle
		If lastPart.Length > 15 Then lastPart = lastPart.SubString2(0, 15) & "..."
	End If

	'Breadcrumb completo no header
	Dim breadcrumb As String = ModLang.T("notes") & " → " & CurrentGroupName & " → " & lastPart
	lblHeaderTitle.Text = breadcrumb
	CallSub2(Main, "SetPageTitle", lastPart)

	'Touch na sessao se grupo seguro
	If IsSecure Then ModSession.Touch
End Sub

Public Sub SetParams(params As Map)
	If params = Null Then Return

	CurrentNoteId = params.GetDefault("noteId", "")
	CurrentGroupId = params.GetDefault("groupId", "")
	CurrentGroupName = params.GetDefault("groupName", "")
	NoteType = params.GetDefault("noteType", "text")
	IsSecure = params.GetDefault("isSecure", True)
	Passphrase = params.GetDefault("passphrase", "")

	'Se nao veio passphrase, tenta da sessao
	If Passphrase = "" And IsSecure Then
		Passphrase = ModSession.GetPassphrase
	End If

	'Carrega salt do grupo para criptografia de anexos
	GroupSalt = ""
	If IsSecure Then
		Dim grpNote As clsNoteGroup = ModNotes.GetNoteGroupById(CurrentGroupId)
		If grpNote <> Null Then
			GroupSalt = grpNote.Salt
		End If
	End If

	'Inicializa ModAttachments
	ModAttachments.Init

	IsNewNote = (CurrentNoteId.Length = 0)
	ItemsList.Initialize
	ItemPanels.Initialize
	AttachmentsList.Initialize
	CurrentFilter = ""  'Limpa filtro ao abrir

	'Verifica se e grupo de cartoes (UI exclusiva)
	Dim grp As clsNoteGroup = ModNotes.GetNoteGroupById(CurrentGroupId)
	IsCardTemplate = (grp <> Null And grp.TemplateType = "card")

	'Configura UI baseado no modo
	SetupModeUI

	If IsNewNote Then
		edtTitle.Text = ""
		If NoteType = "text" Then
			edtContent.Text = ""
		Else If NoteType = "list" Then
			'Verifica se grupo tem template (ex: cartoes)
			Dim group As clsNoteGroup = ModNotes.GetNoteGroupById(CurrentGroupId)
			If group <> Null And group.TemplateType = "card" Then
				'Aplica template de cartao
				ItemsList = ModNotes.GetCardTemplate
				RebuildItemsUI
			End If
		End If
		chkFavorite.Checked = False
	Else
		LoadNote
	End If
End Sub

' ============================================
'  CRIAR UI
' ============================================

Private Sub CreateUI
	Dim width As Int = Root.Width
	Dim height As Int = Root.Height
	Dim headerH As Int = 56dip
	Dim iconBarH As Int = 50dip

	'Header 1 - Titulo
	Dim pnlHeader As Panel
	pnlHeader.Initialize("")
	pnlHeader.Color = ModTheme.HomeHeaderBg
	Root.AddView(pnlHeader, 0, 0, width, headerH)

	'Botao voltar
	btnBack.Initialize("btnBack")
	btnBack.Text = "<"
	btnBack.TextSize = 20
	btnBack.Color = Colors.Transparent
	btnBack.TextColor = Colors.White
	btnBack.Gravity = Gravity.CENTER
	pnlHeader.AddView(btnBack, 0, 0, 50dip, headerH)

	'Titulo
	lblHeaderTitle.Initialize("")
	lblHeaderTitle.Text = ModLang.T("new_note")
	lblHeaderTitle.TextSize = Starter.FONT_BODY
	lblHeaderTitle.TextColor = Colors.White
	lblHeaderTitle.Typeface = Typeface.DEFAULT_BOLD
	lblHeaderTitle.Gravity = Gravity.CENTER_VERTICAL
	pnlHeader.AddView(lblHeaderTitle, 50dip, 0, width - 60dip, headerH)

	'Header 2 - Barra de icones
	Dim pnlIconBar As Panel
	pnlIconBar.Initialize("")
	pnlIconBar.Color = ModTheme.HomeBg
	Root.AddView(pnlIconBar, 0, headerH, width, iconBarH)
	CreateIconBar(pnlIconBar, width)

	'Conteudo com scroll
	Dim contentTop As Int = headerH + iconBarH
	svContent.Initialize(0)
	svContent.Color = ModTheme.HomeBg
	Root.AddView(svContent, 0, contentTop, width, height - contentTop)

	pnlContent = svContent.Panel
	pnlContent.Color = ModTheme.HomeBg

	CreateCommonFields
	CreateTextModeUI
	CreateListModeUI
	CreateAttachmentsUI
	CreateInputDialog
End Sub

Private Sub CreateIconBar(pnlIconBar As Panel, width As Int)
	Dim iconSize As Int = 44dip
	Dim spacing As Int = 8dip
	Dim startX As Int = width - (iconSize * 5) - (spacing * 4) - 16dip  'Alinha a direita (5 icones agora)

	'+ Adicionar item (so para listas)
	lblIconAdd.Initialize("lblIconAdd")
	lblIconAdd.Text = "+"
	lblIconAdd.TextSize = 24
	lblIconAdd.TextColor = Colors.White
	lblIconAdd.Gravity = Gravity.CENTER
	pnlIconBar.AddView(lblIconAdd, startX, 3dip, iconSize, iconSize)
	Dim xvAdd As B4XView = lblIconAdd
	xvAdd.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModTheme.HomeIconBg, 22dip)

	'Anexar arquivo (clips icon)
	ivIconAttach.Initialize("ivIconAttach")
	ivIconAttach.Gravity = Gravity.CENTER
	pnlIconBar.AddView(ivIconAttach, startX + iconSize + spacing, 3dip, iconSize, iconSize)
	SetAndroidIcon(ivIconAttach, "ic_menu_attachment")

	'Lixeira - excluir nota (icone Android padrao)
	ivIconDelete.Initialize("ivIconDelete")
	ivIconDelete.Gravity = Gravity.CENTER
	ivIconDelete.Visible = False  'So aparece ao editar
	pnlIconBar.AddView(ivIconDelete, startX + (iconSize + spacing) * 2, 3dip, iconSize, iconSize)
	SetAndroidIcon(ivIconDelete, "ic_menu_delete")

	'Compartilhar (icone Android padrao)
	ivIconShare.Initialize("ivIconShare")
	ivIconShare.Gravity = Gravity.CENTER
	pnlIconBar.AddView(ivIconShare, startX + (iconSize + spacing) * 3, 3dip, iconSize, iconSize)
	SetAndroidIcon(ivIconShare, "ic_menu_share")

	'Salvar (check verde)
	lblIconSave.Initialize("lblIconSave")
	lblIconSave.Text = Chr(0x2713)  'Check ✓
	lblIconSave.TextSize = 22
	lblIconSave.TextColor = Colors.RGB(100, 200, 100)
	lblIconSave.Gravity = Gravity.CENTER
	pnlIconBar.AddView(lblIconSave, startX + (iconSize + spacing) * 4, 3dip, iconSize, iconSize)
End Sub

Private Sub CreateCommonFields
	Dim width As Int = Root.Width
	Dim margin As Int = 16dip
	Dim fieldWidth As Int = width - (margin * 2)
	Dim y As Int = 10dip

	'Campo titulo (sem label, mais compacto)
	edtTitle.Initialize("edtTitle")
	edtTitle.Hint = ModLang.T("title_hint")
	edtTitle.SingleLine = True
	edtTitle.TextSize = Starter.FONT_BODY
	edtTitle.InputType = Bit.Or(1, 8192)
	pnlContent.AddView(edtTitle, margin, y, fieldWidth - 60dip, 50dip)

	'Estrela favorito ao lado do titulo (Label clicavel)
	chkFavorite.Initialize("chkFavorite")
	chkFavorite.Text = Chr(9734)  'Estrela vazia ☆
	chkFavorite.TextSize = 24
	chkFavorite.TextColor = Colors.ARGB(180, 255, 255, 255)
	pnlContent.AddView(chkFavorite, fieldWidth - 30dip, y + 10dip, 50dip, 40dip)
	y = y + 55dip
End Sub

Private Sub CreateTextModeUI
	Dim width As Int = Root.Width
	Dim margin As Int = 16dip
	Dim fieldWidth As Int = width - (margin * 2)

	pnlTextMode.Initialize("")
	pnlTextMode.Color = Colors.Transparent
	pnlContent.AddView(pnlTextMode, 0, 70dip, width, 350dip)

	'Label Conteudo
	Dim lblContentField As Label
	lblContentField.Initialize("")
	lblContentField.Text = ModLang.T("content")
	lblContentField.TextSize = Starter.FONT_LABEL
	lblContentField.TextColor = Colors.ARGB(180, 255, 255, 255)
	pnlTextMode.AddView(lblContentField, margin, 0, fieldWidth, 20dip)

	'Campo conteudo (maior para textos longos)
	edtContent.Initialize("edtContent")
	edtContent.Hint = ModLang.T("content_hint")
	edtContent.SingleLine = False
	edtContent.TextSize = Starter.FONT_BODY
	edtContent.Gravity = Gravity.TOP
	pnlTextMode.AddView(edtContent, margin, 22dip, fieldWidth, 300dip)
End Sub

Private Sub CreateListModeUI
	Dim width As Int = Root.Width
	Dim margin As Int = 16dip
	Dim fieldWidth As Int = width - (margin * 2)

	pnlListMode.Initialize("")
	pnlListMode.Color = Colors.Transparent
	pnlContent.AddView(pnlListMode, 0, 70dip, width, 450dip)

	'Campo de filtro com botao X para limpar
	Dim filterWidth As Int = fieldWidth - 44dip
	edtFilter.Initialize("edtFilter")
	edtFilter.Hint = ModLang.T("filter_items")
	edtFilter.SingleLine = True
	edtFilter.TextSize = Starter.FONT_BODY
	edtFilter.TextColor = Colors.White
	edtFilter.HintColor = Colors.ARGB(120, 255, 255, 255)
	Dim cdFilter As ColorDrawable
	cdFilter.Initialize2(ModTheme.HomeHeaderBg, 8dip, 1dip, Colors.ARGB(80, 255, 255, 255))
	edtFilter.Background = cdFilter
	pnlListMode.AddView(edtFilter, margin, 0, filterWidth, 44dip)

	'Botao X para limpar filtro
	lblClearFilter.Initialize("lblClearFilter")
	lblClearFilter.Text = "X"
	lblClearFilter.TextSize = 18
	lblClearFilter.TextColor = Colors.ARGB(180, 255, 255, 255)
	lblClearFilter.Gravity = Gravity.CENTER
	pnlListMode.AddView(lblClearFilter, margin + filterWidth + 4dip, 0, 40dip, 44dip)

	'Container para itens (abaixo do filtro)
	pnlItems.Initialize("")
	pnlItems.Color = Colors.Transparent
	pnlListMode.AddView(pnlItems, margin, 52dip, fieldWidth, 300dip)

	'Container para botao + e texto
	pnlAddRow.Initialize("")
	pnlAddRow.Color = Colors.Transparent
	pnlListMode.AddView(pnlAddRow, margin, 360dip, fieldWidth, 50dip)

	'Botao adicionar item (circular)
	lblAddItem.Initialize("lblAddItem")
	lblAddItem.Text = "+"
	lblAddItem.TextSize = 26
	lblAddItem.Typeface = Typeface.DEFAULT_BOLD
	lblAddItem.Gravity = Gravity.CENTER
	lblAddItem.TextColor = Colors.White
	pnlAddRow.AddView(lblAddItem, 0, 3dip, 44dip, 44dip)

	'Arredondar o label (circular)
	Dim xvAddItem As B4XView = lblAddItem
	xvAddItem.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModTheme.HomeIconBg, 22dip)

	'Texto ao lado do botao
	Dim lblAddItemText As Label
	lblAddItemText.Initialize("lblAddItem")  'Mesmo evento do botao
	lblAddItemText.Text = "(" & ModLang.T("add_item") & ")"
	lblAddItemText.TextSize = Starter.FONT_BODY
	lblAddItemText.TextColor = Colors.ARGB(180, 255, 255, 255)
	lblAddItemText.Gravity = Gravity.CENTER_VERTICAL
	pnlAddRow.AddView(lblAddItemText, 52dip, 0, fieldWidth - 60dip, 50dip)
End Sub

Private Sub CreateAttachmentsUI
	Dim width As Int = Root.Width
	Dim margin As Int = 16dip
	Dim fieldWidth As Int = width - (margin * 2)

	'Container para anexos (sera posicionado abaixo do conteudo/lista)
	pnlAttachments.Initialize("")
	pnlAttachments.Color = Colors.Transparent
	'Posicao inicial - sera ajustada em RebuildAttachmentsUI
	pnlContent.AddView(pnlAttachments, margin, 420dip, fieldWidth, 200dip)

	'Inicializa ContentChooser
	ContentChooser1.Initialize("ContentChooser1")
End Sub

Private Sub SetupModeUI
	If NoteType = "list" Then
		pnlTextMode.Visible = False
		pnlListMode.Visible = True

		'Cartoes: esconder + adicionar, filtro, titulo, favorito e anexos
		If IsCardTemplate Then
			lblIconAdd.Visible = False
			ivIconShare.Visible = True  'Compartilhar habilitado para cartoes
			ivIconAttach.Visible = False  'Sem anexos para cartoes
			edtFilter.Visible = False
			lblClearFilter.Visible = False
			pnlAddRow.Visible = False
			edtTitle.Visible = False
			chkFavorite.Visible = False
			pnlAttachments.Visible = False
			'Ajusta posicao do pnlListMode (sem titulo)
			pnlListMode.Top = 10dip
		Else
			lblIconAdd.Visible = True
			ivIconShare.Visible = True
			ivIconAttach.Visible = True  'Anexos habilitados para listas
			edtFilter.Visible = True
			lblClearFilter.Visible = True
			pnlAddRow.Visible = True
			edtTitle.Visible = True
			chkFavorite.Visible = True
			pnlAttachments.Visible = True
			pnlListMode.Top = 70dip
		End If
		RebuildItemsUI
		RebuildAttachmentsUI
	Else
		pnlTextMode.Visible = True
		pnlListMode.Visible = False
		lblIconAdd.Visible = False  'Nao tem + para texto
		ivIconShare.Visible = False  'Nao compartilha texto
		ivIconAttach.Visible = True  'Anexos habilitados para texto
		pnlAttachments.Visible = True
		'Altura do conteudo para modo texto
		pnlContent.Height = 92dip + 350dip + 20dip
		RebuildAttachmentsUI
	End If

	'Lixeira so aparece ao editar (nota existente)
	ivIconDelete.Visible = Not(IsNewNote)
End Sub

Private Sub CreateInputDialog
	Dim width As Int = Root.Width
	Dim height As Int = Root.Height

	'Overlay escuro
	pnlInputOverlay.Initialize("pnlInputOverlay")
	pnlInputOverlay.Color = Colors.ARGB(180, 0, 0, 0)
	pnlInputOverlay.Visible = False
	Root.AddView(pnlInputOverlay, 0, 0, width, height)

	'Dialog centralizado
	Dim dialogW As Int = width - 40dip
	Dim dialogH As Int = 180dip

	pnlInputDialog.Initialize("")
	pnlInputDialog.Color = ModTheme.HomeHeaderBg
	pnlInputOverlay.AddView(pnlInputDialog, 20dip, 80dip, dialogW, dialogH)

	'Arredondar cantos
	Dim xvDialog As B4XView = pnlInputDialog
	xvDialog.SetColorAndBorder(ModTheme.HomeHeaderBg, 0, ModTheme.HomeHeaderBg, 12dip)

	'Titulo (sera definido ao abrir)
	Dim lblTitle As Label
	lblTitle.Initialize("lblInputTitle")
	lblTitle.Text = ModLang.T("note_add_item")
	lblTitle.TextSize = Starter.FONT_BODY
	lblTitle.TextColor = Colors.White
	lblTitle.Typeface = Typeface.DEFAULT_BOLD
	lblTitle.Gravity = Gravity.CENTER_HORIZONTAL
	pnlInputDialog.AddView(lblTitle, 0, 12dip, dialogW, 24dip)

	'Campo de texto
	edtItemText.Initialize("edtItemText")
	edtItemText.Hint = ModLang.T("item_hint")  'Hint para item, nao titulo
	edtItemText.SingleLine = True
	edtItemText.InputType = Bit.Or(1, 8192)  'TEXT + CAP_WORDS
	edtItemText.TextSize = Starter.FONT_BODY
	edtItemText.TextColor = Colors.White
	edtItemText.HintColor = Colors.ARGB(120, 255, 255, 255)

	Dim pnlInput As Panel
	pnlInput.Initialize("")
	pnlInput.Color = ModTheme.HomeBg
	pnlInputDialog.AddView(pnlInput, 16dip, 45dip, dialogW - 32dip, 50dip)
	pnlInput.AddView(edtItemText, 8dip, 5dip, dialogW - 48dip, 40dip)

	'3 botoes coloridos: X vermelho (cancelar), + amarelo (salvar e add), ✓ verde (salvar e sair)
	Dim btnSize As Int = 50dip
	Dim btnSpacing As Int = 20dip
	Dim totalBtnsWidth As Int = (btnSize * 3) + (btnSpacing * 2)
	Dim startX As Int = (dialogW - totalBtnsWidth) / 2

	'X Vermelho - Cancelar
	Dim btnInputCancel As Label
	btnInputCancel.Initialize("btnInputCancel")
	btnInputCancel.Text = "X"
	btnInputCancel.TextSize = 22
	btnInputCancel.TextColor = Colors.RGB(255, 100, 100)  'Vermelho
	btnInputCancel.Gravity = Gravity.CENTER
	pnlInputDialog.AddView(btnInputCancel, startX, 115dip, btnSize, btnSize)
	Dim xvCancel As B4XView = btnInputCancel
	xvCancel.SetColorAndBorder(ModTheme.HomeBg, 1dip, Colors.RGB(255, 100, 100), 25dip)

	'+ Amarelo - Salvar e adicionar outro
	Dim btnInputAddMore As Label
	btnInputAddMore.Initialize("btnInputAddMore")
	btnInputAddMore.Text = "+"
	btnInputAddMore.TextSize = 26
	btnInputAddMore.TextColor = Colors.RGB(255, 200, 100)  'Amarelo
	btnInputAddMore.Gravity = Gravity.CENTER
	pnlInputDialog.AddView(btnInputAddMore, startX + btnSize + btnSpacing, 115dip, btnSize, btnSize)
	Dim xvAddMore As B4XView = btnInputAddMore
	xvAddMore.SetColorAndBorder(ModTheme.HomeBg, 1dip, Colors.RGB(255, 200, 100), 25dip)

	'✓ Verde - Salvar e sair
	Dim btnInputSaveExit As Label
	btnInputSaveExit.Initialize("btnInputSaveExit")
	btnInputSaveExit.Text = Chr(0x2713)  '✓
	btnInputSaveExit.TextSize = 22
	btnInputSaveExit.TextColor = Colors.RGB(100, 200, 100)  'Verde
	btnInputSaveExit.Gravity = Gravity.CENTER
	pnlInputDialog.AddView(btnInputSaveExit, startX + (btnSize + btnSpacing) * 2, 115dip, btnSize, btnSize)
	Dim xvSaveExit As B4XView = btnInputSaveExit
	xvSaveExit.SetColorAndBorder(ModTheme.HomeBg, 1dip, Colors.RGB(100, 200, 100), 25dip)
End Sub

Private Sub ShowInputDialog(title As String, defaultText As String, editIndex As Int)
	EditingItemIndex = editIndex

	'Atualiza titulo
	Dim lblTitle As Label = pnlInputDialog.GetView(0)
	lblTitle.Text = title

	'Define texto
	edtItemText.Text = defaultText

	'Mostra dialog
	pnlInputOverlay.Visible = True
	pnlInputOverlay.BringToFront
	edtItemText.RequestFocus
End Sub

Private Sub HideInputDialog
	pnlInputOverlay.Visible = False
	EditingItemIndex = -1
	Dim ime As IME
	ime.Initialize("")
	ime.HideKeyboard
End Sub

Private Sub pnlInputOverlay_Click
	HideInputDialog
End Sub

'X Vermelho - Cancelar
Private Sub btnInputCancel_Click
	HideInputDialog
End Sub

'+ Amarelo - Salvar item e adicionar outro
Private Sub btnInputAddMore_Click
	Dim text As String = edtItemText.Text.Trim
	If text.Length = 0 Then
		ToastMessageShow(ModLang.T("error_empty_field"), True)
		Return
	End If

	If EditingItemIndex = -1 Then
		'Novo item
		Dim newItem As Map
		newItem.Initialize
		newItem.Put("text", text)
		newItem.Put("checked", False)
		ItemsList.Add(newItem)
	Else
		'Editar item existente
		If EditingItemIndex >= 0 And EditingItemIndex < ItemsList.Size Then
			Dim item As Map = ItemsList.Get(EditingItemIndex)
			item.Put("text", text)
		End If
	End If

	RebuildItemsUI

	'Limpa campo e mantem dialog aberto para adicionar outro
	edtItemText.Text = ""
	EditingItemIndex = -1  'Proximo sera novo item
	edtItemText.RequestFocus
End Sub

'✓ Verde - Salvar item e sair do dialog
Private Sub btnInputSaveExit_Click
	Dim text As String = edtItemText.Text.Trim
	If text.Length = 0 Then
		ToastMessageShow(ModLang.T("error_empty_field"), True)
		Return
	End If

	If EditingItemIndex = -1 Then
		'Novo item
		Dim newItem As Map
		newItem.Initialize
		newItem.Put("text", text)
		newItem.Put("checked", False)
		ItemsList.Add(newItem)
	Else
		'Editar item existente
		If EditingItemIndex >= 0 And EditingItemIndex < ItemsList.Size Then
			Dim item As Map = ItemsList.Get(EditingItemIndex)
			item.Put("text", text)
		End If
	End If

	HideInputDialog
	RebuildItemsUI
End Sub

' ============================================
'  MODO LISTA - UI DOS ITENS
' ============================================

Private Sub RebuildItemsUI
	IsRebuildingUI = True  'Bloqueia eventos de checkbox durante reconstrucao

	pnlItems.RemoveAllViews
	ItemPanels.Initialize

	Dim width As Int = pnlItems.Width
	Dim itemHeight As Int = 50dip
	Dim y As Int = 0

	'Cartoes: reposiciona pnlItems para cima (sem filtro)
	If IsCardTemplate Then
		pnlItems.Top = 0
	Else
		pnlItems.Top = 52dip
	End If

	For i = 0 To ItemsList.Size - 1
		Dim item As Map = ItemsList.Get(i)
		Dim itemText As String = item.GetDefault("text", "")

		'Aplica filtro (nao para cartoes)
		If IsCardTemplate = False And ItemMatchesFilter(itemText) = False Then Continue

		'Cria painel diferente para cartoes
		Dim pnlItem As Panel
		If IsCardTemplate Then
			pnlItem = CreateCardItemPanel(i, item, width)
		Else
			pnlItem = CreateItemPanel(i, item, width)
		End If
		pnlItems.AddView(pnlItem, 0, y, width, itemHeight)
		ItemPanels.Add(pnlItem)
		y = y + itemHeight + 8dip
	Next

	'Ajusta altura do container de itens
	pnlItems.Height = Max(y, 50dip)

	'Reposiciona container do botao adicionar (nao usado para cartoes)
	If IsCardTemplate = False Then
		'pnlItems esta em Top=52dip, entao pnlAddRow fica logo abaixo
		Dim addRowTop As Int = 52dip + pnlItems.Height + 10dip
		pnlAddRow.Top = addRowTop
		'Ajusta altura do pnlListMode para conter tudo
		pnlListMode.Height = addRowTop + 60dip
	Else
		'Cartoes: sem filtro e sem botao add + espaco extra para scroll com teclado
		pnlListMode.Height = pnlItems.Height + 300dip  'Espaco extra para teclado
	End If

	'Ajusta pnlContent
	Dim totalHeight As Int = 70dip + pnlListMode.Height + 20dip
	pnlContent.Height = Max(totalHeight, 300dip)

	IsRebuildingUI = False  'Libera eventos de checkbox
End Sub

'Painel de item para cartao - sem checkbox, apenas label:valor
Private Sub CreateCardItemPanel(index As Int, item As Map, panelWidth As Int) As Panel
	Dim pnl As Panel
	pnl.Initialize("pnlCardItem")
	pnl.Tag = index

	Dim xv As B4XView = pnl
	xv.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModTheme.HomeIconBg, 8dip)

	Dim text As String = item.GetDefault("text", "")

	'Separa label:valor
	Dim colonPos As Int = text.IndexOf(":")
	Dim labelText As String = ""
	Dim valueText As String = ""
	If colonPos > 0 Then
		labelText = text.SubString2(0, colonPos + 1)  'Inclui o ":"
		valueText = text.SubString(colonPos + 1).Trim
	Else
		labelText = text
		valueText = ""
	End If

	'Label fixo (ex: "Nome:")
	Dim lblCardLabel As Label
	lblCardLabel.Initialize("")
	lblCardLabel.Text = labelText
	lblCardLabel.TextSize = Starter.FONT_LABEL
	lblCardLabel.TextColor = Colors.ARGB(180, 255, 255, 255)
	lblCardLabel.Gravity = Gravity.CENTER_VERTICAL
	pnl.AddView(lblCardLabel, 12dip, 0, 100dip, 50dip)

	'Campo editavel para valor
	Dim edtCardValue As EditText

	'Determina tipo de campo baseado no index
	'0=Nome, 1=Bandeira, 2=Numero, 3=Validade, 4=CVV, 5=Senha, 6=Titular, 7=Limite, 8=Notas
	Select index
		Case 2  'Numero do cartao
			edtCardValue.Initialize("edtCardNumber")
			edtCardValue.InputType = 2  'TYPE_CLASS_NUMBER
			edtCardValue.Hint = "0000 0000 0000 0000"
		Case 3  'Validade
			edtCardValue.Initialize("edtCardExpiry")
			edtCardValue.InputType = 2  'TYPE_CLASS_NUMBER
			edtCardValue.Hint = "MM/AA"
		Case 4  'CVV
			edtCardValue.Initialize("edtCardCVV")
			edtCardValue.InputType = 2  'TYPE_CLASS_NUMBER
			edtCardValue.Hint = "000"
		Case 5  'Senha - sem sugestoes
			edtCardValue.Initialize("edtCardValue")
			edtCardValue.InputType = Bit.Or(1, 524288)  'TEXT + NO_SUGGESTIONS
		Case 7  'Limite
			edtCardValue.Initialize("edtCardValue")
			edtCardValue.InputType = 2  'TYPE_CLASS_NUMBER
		Case Else
			edtCardValue.Initialize("edtCardValue")
			edtCardValue.InputType = Bit.Or(1, 8192)  'TEXT + CAP_WORDS
	End Select

	edtCardValue.Tag = index
	edtCardValue.Text = valueText
	edtCardValue.TextSize = Starter.FONT_BODY
	edtCardValue.TextColor = Colors.White
	edtCardValue.HintColor = Colors.ARGB(80, 255, 255, 255)
	edtCardValue.SingleLine = True

	'Fundo transparente para integrar com o painel
	edtCardValue.Background = Null

	pnl.AddView(edtCardValue, 115dip, 5dip, panelWidth - 130dip, 40dip)

	Return pnl
End Sub

Private Sub CreateItemPanel(index As Int, item As Map, panelWidth As Int) As Panel
	Dim pnl As Panel
	pnl.Initialize("pnlItem")
	pnl.Tag = index

	Dim xv As B4XView = pnl
	xv.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModTheme.HomeIconBg, 8dip)

	Dim text As String = item.GetDefault("text", "")
	Dim checked As Boolean = item.GetDefault("checked", False)

	'Texto do item a esquerda (clicavel para editar)
	Dim lbl As Label
	lbl.Initialize("lblItem")
	lbl.Tag = index
	lbl.Text = text
	lbl.TextSize = Starter.FONT_BODY
	lbl.Gravity = Gravity.CENTER_VERTICAL
	lbl.TextColor = Colors.White
	pnl.AddView(lbl, 12dip, 0, panelWidth - 60dip, 50dip)

	'Checkbox a direita (verde quando marcado)
	Dim chk As CheckBox
	chk.Initialize("chkItem")
	chk.Tag = index
	chk.Text = ""
	chk.Checked = checked
	pnl.AddView(chk, panelWidth - 48dip, 10dip, 40dip, 30dip)

	Return pnl
End Sub

' ============================================
'  EVENTOS - LISTA
' ============================================

'Evento para campos de cartao - atualiza valor na lista
Private Sub edtCardValue_TextChanged(Old As String, New As String)
	If IsRebuildingUI Then Return

	Dim edt As EditText = Sender
	Dim index As Int = edt.Tag

	If index >= 0 And index < ItemsList.Size Then
		Dim item As Map = ItemsList.Get(index)
		Dim text As String = item.GetDefault("text", "")

		'Reconstroi o texto com label:valor
		Dim colonPos As Int = text.IndexOf(":")
		If colonPos > 0 Then
			Dim labelPart As String = text.SubString2(0, colonPos + 1)
			item.Put("text", labelPart & " " & New.Trim)
		Else
			item.Put("text", text & ": " & New.Trim)
		End If
	End If
End Sub

'Extrai titulo do cartao a partir do primeiro item (Nome)
Private Sub GetCardTitle As String
	If ItemsList.IsInitialized = False Or ItemsList.Size = 0 Then Return ""

	Dim firstItem As Map = ItemsList.Get(0)
	Dim text As String = firstItem.GetDefault("text", "")

	'Extrai valor apos ":"
	Dim colonPos As Int = text.IndexOf(":")
	If colonPos > 0 Then
		Return text.SubString(colonPos + 1).Trim
	End If
	Return text.Trim
End Sub

'Formata numero do cartao: espaço a cada 4 digitos
Private Sub edtCardNumber_TextChanged(Old As String, New As String)
	If IsRebuildingUI Then Return

	Dim edt As EditText = Sender
	Dim index As Int = edt.Tag

	'Remove tudo que nao e digito
	Dim digits As String = ""
	For i = 0 To New.Length - 1
		Dim charCode As Int = Asc(New.CharAt(i))
		If charCode >= 48 And charCode <= 57 Then  '0-9
			digits = digits & Chr(charCode)
		End If
	Next

	'Limita a 16 digitos
	If digits.Length > 16 Then digits = digits.SubString2(0, 16)

	'Formata com espacos a cada 4 digitos
	Dim formatted As String = ""
	For i = 0 To digits.Length - 1
		If i > 0 And i Mod 4 = 0 Then formatted = formatted & " "
		formatted = formatted & digits.SubString2(i, i + 1)
	Next

	'Atualiza campo se diferente (evita loop)
	If formatted <> New Then
		edt.Text = formatted
		edt.SelectionStart = formatted.Length
	End If

	'Atualiza ItemsList
	If index >= 0 And index < ItemsList.Size Then
		Dim item As Map = ItemsList.Get(index)
		Dim text As String = item.GetDefault("text", "")
		Dim colonPos As Int = text.IndexOf(":")
		If colonPos > 0 Then
			item.Put("text", text.SubString2(0, colonPos + 1) & " " & formatted)
		End If
	End If
End Sub

'Formata validade: MM/AA
Private Sub edtCardExpiry_TextChanged(Old As String, New As String)
	If IsRebuildingUI Then Return

	Dim edt As EditText = Sender
	Dim index As Int = edt.Tag

	'Remove tudo que nao e digito
	Dim digits As String = ""
	For i = 0 To New.Length - 1
		Dim charCode As Int = Asc(New.CharAt(i))
		If charCode >= 48 And charCode <= 57 Then  '0-9
			digits = digits & Chr(charCode)
		End If
	Next

	'Limita a 4 digitos (MMAA)
	If digits.Length > 4 Then digits = digits.SubString2(0, 4)

	'Formata como MM/AA
	Dim formatted As String = ""
	If digits.Length >= 1 Then
		'Valida mes (01-12)
		Dim firstDigit As Int = Asc(digits.CharAt(0)) - 48
		If firstDigit > 1 Then
			formatted = "0" & digits.SubString2(0, 1) & "/"
			digits = digits.SubString(1)
		Else If digits.Length >= 2 Then
			Dim month As Int = (Asc(digits.CharAt(0)) - 48) * 10 + (Asc(digits.CharAt(1)) - 48)
			If month >= 1 And month <= 12 Then
				formatted = digits.SubString2(0, 2) & "/"
				digits = digits.SubString(2)
			Else If month > 12 Then
				formatted = "12/"
				digits = digits.SubString(2)
			Else
				formatted = digits.SubString2(0, 2)
				digits = ""
			End If
		Else
			formatted = digits
			digits = ""
		End If
	End If

	'Adiciona ano
	If digits.Length > 0 Then
		formatted = formatted & digits
	End If

	'Atualiza campo se diferente
	If formatted <> New Then
		edt.Text = formatted
		edt.SelectionStart = formatted.Length
	End If

	'Atualiza ItemsList
	If index >= 0 And index < ItemsList.Size Then
		Dim item As Map = ItemsList.Get(index)
		Dim text As String = item.GetDefault("text", "")
		Dim colonPos As Int = text.IndexOf(":")
		If colonPos > 0 Then
			item.Put("text", text.SubString2(0, colonPos + 1) & " " & formatted)
		End If
	End If
End Sub

'Limita CVV a 3 digitos
Private Sub edtCardCVV_TextChanged(Old As String, New As String)
	If IsRebuildingUI Then Return

	Dim edt As EditText = Sender
	Dim index As Int = edt.Tag

	'Remove tudo que nao e digito
	Dim digits As String = ""
	For i = 0 To New.Length - 1
		Dim charCode As Int = Asc(New.CharAt(i))
		If charCode >= 48 And charCode <= 57 Then  '0-9
			digits = digits & Chr(charCode)
		End If
	Next

	'Limita a 3 digitos
	If digits.Length > 3 Then digits = digits.SubString2(0, 3)

	'Atualiza campo se diferente
	If digits <> New Then
		edt.Text = digits
		edt.SelectionStart = digits.Length
	End If

	'Atualiza ItemsList
	If index >= 0 And index < ItemsList.Size Then
		Dim item As Map = ItemsList.Get(index)
		Dim text As String = item.GetDefault("text", "")
		Dim colonPos As Int = text.IndexOf(":")
		If colonPos > 0 Then
			item.Put("text", text.SubString2(0, colonPos + 1) & " " & digits)
		End If
	End If
End Sub

'Algoritmo de Luhn para validar numero do cartao
Private Sub ValidateCardNumber(number As String) As Boolean
	'Remove espacos
	Dim digits As String = number.Replace(" ", "")

	If digits.Length < 13 Or digits.Length > 19 Then Return False

	Dim sum As Int = 0
	Dim alternate As Boolean = False

	For i = digits.Length - 1 To 0 Step -1
		Dim digitValue As Int = Asc(digits.CharAt(i)) - 48
		If digitValue < 0 Or digitValue > 9 Then Return False

		If alternate Then
			digitValue = digitValue * 2
			If digitValue > 9 Then digitValue = digitValue - 9
		End If
		sum = sum + digitValue
		alternate = Not(alternate)
	Next

	Return (sum Mod 10 = 0)
End Sub

'Scroll quando campos do cartao recebem foco
Private Sub edtCardValue_FocusChanged(HasFocus As Boolean)
	If HasFocus Then ScrollToCardField(Sender)
End Sub

Private Sub edtCardNumber_FocusChanged(HasFocus As Boolean)
	If HasFocus Then ScrollToCardField(Sender)
End Sub

Private Sub edtCardExpiry_FocusChanged(HasFocus As Boolean)
	If HasFocus Then ScrollToCardField(Sender)
End Sub

Private Sub edtCardCVV_FocusChanged(HasFocus As Boolean)
	If HasFocus Then ScrollToCardField(Sender)
End Sub

'Faz scroll para mostrar o campo acima do teclado
Private Sub ScrollToCardField(field As Object)
	Dim edt As EditText = field
	Dim index As Int = edt.Tag

	'Delay para teclado aparecer primeiro
	Sleep(150)

	'Calcula posicao do campo (cada item tem 58dip)
	Dim fieldTop As Int = index * 58dip

	'Campos 5+ (Senha, Titular, Limite, Notas) precisam scroll maior
	If index >= 5 Then
		'Scroll agressivo para campos inferiores
		svContent.ScrollPosition = fieldTop - 30dip
	Else If index >= 3 Then
		'Campos do meio (Validade, CVV)
		svContent.ScrollPosition = Max(0, fieldTop - 80dip)
	End If
End Sub

Private Sub lblAddItem_Click
	If IsSecure Then ModSession.Touch
	ShowInputDialog(ModLang.T("note_add_item"), "", -1)
End Sub

'Checkbox do item - marca/desmarca
Private Sub chkItem_CheckedChange(Checked As Boolean)
	'Ignora eventos durante reconstrucao da UI
	If IsRebuildingUI Then Return

	Dim chk As CheckBox = Sender
	Dim index As Int = chk.Tag

	If index >= 0 And index < ItemsList.Size Then
		Dim item As Map = ItemsList.Get(index)
		item.Put("checked", Checked)

		'Delay e reorganiza (marcados no topo)
		Sleep(300)
		SortItemsCheckedFirst
		RebuildItemsUI
	End If
End Sub

'Clique no texto do item - editar
Private Sub lblItem_Click
	Dim lbl As Label = Sender
	Dim index As Int = lbl.Tag
	EditItem(index)
End Sub

'Filtro de itens - atualiza em tempo real
Private Sub edtFilter_TextChanged(Old As String, New As String)
	CurrentFilter = New.Trim.ToLowerCase
	RebuildItemsUI
End Sub

'Limpa o filtro
Private Sub lblClearFilter_Click
	edtFilter.Text = ""
	CurrentFilter = ""
	RebuildItemsUI
End Sub

'Remove acentos para comparacao
Private Sub RemoveAccents(text As String) As String
	Dim result As String = text.ToLowerCase
	result = result.Replace("á", "a").Replace("à", "a").Replace("ã", "a").Replace("â", "a").Replace("ä", "a")
	result = result.Replace("é", "e").Replace("è", "e").Replace("ê", "e").Replace("ë", "e")
	result = result.Replace("í", "i").Replace("ì", "i").Replace("î", "i").Replace("ï", "i")
	result = result.Replace("ó", "o").Replace("ò", "o").Replace("õ", "o").Replace("ô", "o").Replace("ö", "o")
	result = result.Replace("ú", "u").Replace("ù", "u").Replace("û", "u").Replace("ü", "u")
	result = result.Replace("ç", "c").Replace("ñ", "n")
	Return result
End Sub

'Verifica se item passa no filtro
Private Sub ItemMatchesFilter(itemText As String) As Boolean
	If CurrentFilter.Length = 0 Then Return True
	Dim normalizedItem As String = RemoveAccents(itemText)
	Dim normalizedFilter As String = RemoveAccents(CurrentFilter)
	Return normalizedItem.Contains(normalizedFilter)
End Sub

Private Sub EditItem(index As Int)
	If index < 0 Or index >= ItemsList.Size Then Return
	If IsSecure Then ModSession.Touch

	Dim item As Map = ItemsList.Get(index)
	Dim currentText As String = item.GetDefault("text", "")
	ShowInputDialog(ModLang.T("edit_item"), currentText, index)
End Sub

'Ordena itens: marcados (checked) primeiro, depois nao marcados
Private Sub SortItemsCheckedFirst
	If ItemsList.Size < 2 Then Return

	'Bubble sort simples: checked=True vai para o inicio
	For i = 0 To ItemsList.Size - 2
		For j = 0 To ItemsList.Size - 2 - i
			Dim item1 As Map = ItemsList.Get(j)
			Dim item2 As Map = ItemsList.Get(j + 1)
			Dim checked1 As Boolean = item1.GetDefault("checked", False)
			Dim checked2 As Boolean = item2.GetDefault("checked", False)

			'Se item1 NAO esta marcado e item2 ESTA marcado, troca
			If checked1 = False And checked2 = True Then
				ItemsList.Set(j, item2)
				ItemsList.Set(j + 1, item1)
			End If
		Next
	Next
End Sub

' ============================================
'  CARREGAR NOTA
' ============================================

Private Sub LoadNote
	Dim note As clsNoteEntry = ModNotes.GetNoteById(CurrentNoteId)
	If note = Null Then
		ToastMessageShow(ModLang.T("error_not_found"), True)
		B4XPages.ClosePage(Me)
		Return
	End If

	'Atualiza tipo da nota
	NoteType = note.NoteType
	SetupModeUI

	'Carrega titulo
	If IsSecure Then
		edtTitle.Text = note.GetDecryptedTitle(Passphrase)
	Else
		edtTitle.Text = note.Title
	End If
	CurrentNoteTitle = edtTitle.Text  'Guarda para breadcrumb

	chkFavorite.Checked = note.IsFavorite

	If NoteType = "list" Then
		'Carrega itens
		If IsSecure Then
			Dim decryptedItems As String = note.GetDecryptedItems(Passphrase)
			If decryptedItems <> "" And decryptedItems <> "[]" Then
				Dim parser As JSONParser
				parser.Initialize(decryptedItems)
				ItemsList = parser.NextArray
			End If
		Else
			ItemsList = note.GetItemsList
		End If
		RebuildItemsUI
	Else
		'Carrega conteudo
		If IsSecure Then
			edtContent.Text = note.GetDecryptedContent(Passphrase)
		Else
			edtContent.Text = note.Content
		End If
	End If

	'Carrega anexos do ModAttachments (criptografados)
	If IsCardTemplate = False Then
		AttachmentsList = ModAttachments.ListAttachments(CurrentNoteId)
		RebuildAttachmentsUI
	End If
End Sub

' ============================================
'  SALVAR NOTA
' ============================================

'Salva a nota atual
'closeAfter: True = fecha pagina, False = mantem aberta (para adicionar mais itens)
'Retorna True se salvou com sucesso, False se houve erro
Private Sub SaveNote(closeAfter As Boolean) As Boolean
	Log("SaveNote: NoteType=" & NoteType & ", IsSecure=" & IsSecure & ", closeAfter=" & closeAfter)

	If IsSecure Then ModSession.Touch

	Dim title As String

	'Cartoes: extrai titulo do primeiro item (Nome)
	If IsCardTemplate Then
		title = GetCardTitle
		If title.Length < 1 Then
			ToastMessageShow(ModLang.T("error_empty_field"), True)
			Return False
		End If

		'Valida numero do cartao (index 2) se preenchido
		If ItemsList.Size > 2 Then
			Dim cardNumItem As Map = ItemsList.Get(2)
			Dim cardNumText As String = cardNumItem.GetDefault("text", "")
			Dim colonPos As Int = cardNumText.IndexOf(":")
			If colonPos > 0 Then
				Dim cardNumber As String = cardNumText.SubString(colonPos + 1).Trim
				If cardNumber.Length > 0 And ValidateCardNumber(cardNumber) = False Then
					ToastMessageShow(ModLang.T("invalid_card_number"), True)
					Return False
				End If
			End If
		End If
	Else
		title = edtTitle.Text.Trim
		'Validacoes
		If title.Length < 1 Then
			ToastMessageShow(ModLang.T("error_empty_field"), True)
			Return False
		End If
	End If

	'Verifica limite para novas notas/cartoes
	If IsNewNote Then
		If IsCardTemplate Then
			'Verifica limite de cartoes
			If ModNotes.CanAddCard = False Then
				ToastMessageShow(ModLang.T("limit_cards_free"), True)
				Return False
			End If
		Else
			'Verifica limite de notas
			If ModNotes.CanAddNote = False Then
				ToastMessageShow(ModLang.T("limit_notes_free"), True)
				Return False
			End If
		End If
	End If

	'Verifica passphrase para grupos seguros
	If IsSecure And Passphrase.Length = 0 Then
		Log("ERRO: Passphrase vazia para grupo seguro!")
		ToastMessageShow(ModLang.T("error"), True)
		Return False
	End If

	Dim note As clsNoteEntry
	If IsNewNote Then
		note.Initialize
		note.GroupId = CurrentGroupId
		note.NoteType = NoteType
		'Define SortOrder para novas notas
		Dim existingNotes As List = ModNotes.GetNotesByGroup(CurrentGroupId)
		note.SortOrder = existingNotes.Size
	Else
		note = ModNotes.GetNoteById(CurrentNoteId)
		If note = Null Then
			ToastMessageShow(ModLang.T("error"), True)
			Return False
		End If
	End If

	'Garante que ItemsList esta inicializado
	If ItemsList.IsInitialized = False Then
		ItemsList.Initialize
		Log("ItemsList foi inicializado agora")
	End If
	Log("ItemsList.Size=" & ItemsList.Size)

	'Salva baseado no tipo e se e seguro
	If IsSecure Then
		Log("Modo SEGURO - criptografando...")
		'Grupo SEGURO - criptografa
		note.EncryptTitle(Passphrase, title)
		Log("Titulo criptografado OK")

		If NoteType = "list" Then
			Log("Salvando lista segura...")
			'Converte items para JSON e criptografa
			Dim gen As JSONGenerator
			gen.Initialize2(ItemsList)  'Initialize2 para List
			Dim jsonItems As String = gen.ToString
			Log("JSON gerado: " & jsonItems)
			note.EncryptItems(Passphrase, jsonItems)
			note.Content = ""
			Log("Items criptografados OK")
		Else
			note.EncryptContent(Passphrase, edtContent.Text.Trim)
			note.Items = "[]"
		End If
	Else
		Log("Modo ABERTO - texto claro...")
		'Grupo ABERTO - texto claro
		note.Title = title

		If NoteType = "list" Then
			Log("Salvando lista aberta, ItemsList.Size=" & ItemsList.Size)
			note.SetItemsList(ItemsList)
			note.Content = ""
			Log("SetItemsList OK")
		Else
			note.Content = edtContent.Text.Trim
			note.Items = "[]"
		End If
	End If

	'Anexos sao salvos automaticamente pelo ModAttachments
	'O campo note.Attachments nao e mais usado (mantido para compatibilidade)
	note.Attachments = "[]"

	note.IsFavorite = chkFavorite.Checked
	Log("Chamando ModNotes.SaveNote...")
	ModNotes.SaveNote(note)
	Log("SaveNote OK")

	'Atualiza ID para notas novas (para que proximas edicoes atualizem em vez de criar nova)
	If IsNewNote Then
		CurrentNoteId = note.Id
		IsNewNote = False
	End If

	ToastMessageShow(ModLang.T("success"), False)

	If closeAfter Then
		Log("Fechando pagina...")
		B4XPages.ClosePage(Me)
	End If

	Return True
End Sub

' ============================================
'  EVENTOS GERAIS
' ============================================

Private Sub btnBack_Click
	'Para cartoes novos, perguntar se quer descartar
	If IsCardTemplate And IsNewNote Then
		'Verifica se tem dados preenchidos
		Dim hasData As Boolean = False
		For i = 0 To ItemsList.Size - 1
			Dim item As Map = ItemsList.Get(i)
			Dim text As String = item.GetDefault("text", "")
			Dim colonPos As Int = text.IndexOf(":")
			If colonPos > 0 Then
				Dim value As String = text.SubString(colonPos + 1).Trim
				If value.Length > 0 Then
					hasData = True
					Exit
				End If
			End If
		Next

		If hasData Then
			Wait For (xui.Msgbox2Async(ModLang.T("discard_changes"), ModLang.T("confirm"), ModLang.T("discard"), "", ModLang.T("cancel"), Null)) Msgbox_Result(Result As Int)
			If Result <> xui.DialogResponse_Positive Then Return
		End If
	End If

	B4XPages.ClosePage(Me)
End Sub

'Icone + adicionar item
Private Sub lblIconAdd_Click
	If IsSecure Then ModSession.Touch
	ShowInputDialog(ModLang.T("note_add_item"), "", -1)
End Sub

'Icone lixeira - excluir nota (e todos os anexos)
Private Sub ivIconDelete_Click
	If IsSecure Then ModSession.Touch

	Wait For (xui.Msgbox2Async(ModLang.T("confirm_delete"), ModLang.T("delete"), ModLang.T("yes"), "", ModLang.T("cancel"), Null)) Msgbox_Result(Result As Int)

	If Result = xui.DialogResponse_Positive Then
		'Remove todos os anexos da nota primeiro
		ModAttachments.DeleteAllAttachments(CurrentNoteId)

		'Depois deleta a nota
		ModNotes.DeleteNote(CurrentNoteId)
		ToastMessageShow(ModLang.T("success"), False)
		B4XPages.ClosePage(Me)
	End If
End Sub

'Icone compartilhar - exportar lista
Private Sub ivIconShare_Click
	If ItemsList.Size = 0 Then
		ToastMessageShow(ModLang.T("empty"), True)
		Return
	End If

	'Cartoes: compartilha direto (nome, bandeira, numero, validade)
	If IsCardTemplate Then
		ShareCard
		Return
	End If

	'Pergunta: todos ou so marcados?
	Wait For (xui.Msgbox2Async(ModLang.T("share_which"), ModLang.T("share"), ModLang.T("share_all"), ModLang.T("cancel"), ModLang.T("share_checked"), Null)) Msgbox_Result(Result As Int)

	If Result = xui.DialogResponse_Negative Then
		'So marcados
		ShareItems(True)
	Else If Result = xui.DialogResponse_Positive Then
		'Todos
		ShareItems(False)
	End If
End Sub

'Compartilha dados do cartao (nome, bandeira, numero, validade)
Private Sub ShareCard
	If ItemsList.Size < 4 Then Return

	Dim sb As StringBuilder
	sb.Initialize

	'0=Nome, 1=Bandeira, 2=Numero, 3=Validade
	For i = 0 To 3
		Dim item As Map = ItemsList.Get(i)
		Dim text As String = item.GetDefault("text", "")
		sb.Append(text).Append(Chr(10))
	Next

	'Compartilha via intent com seletor de apps
	Dim shareIntent As Intent
	shareIntent.Initialize(shareIntent.ACTION_SEND, "")
	shareIntent.SetType("text/plain")
	shareIntent.PutExtra("android.intent.extra.TEXT", sb.ToString)

	Dim jo As JavaObject
	jo.InitializeStatic("android.content.Intent")
	StartActivity(jo.RunMethod("createChooser", Array(shareIntent, ModLang.T("share"))))
End Sub

'Compartilha itens da lista
Private Sub ShareItems(onlyChecked As Boolean)
	Dim sb As StringBuilder
	sb.Initialize
	sb.Append(edtTitle.Text.Trim).Append(Chr(10)).Append(Chr(10))

	Dim count As Int = 0
	For i = 0 To ItemsList.Size - 1
		Dim item As Map = ItemsList.Get(i)
		Dim checked As Boolean = item.GetDefault("checked", False)
		Dim text As String = item.GetDefault("text", "")

		If onlyChecked And checked = False Then Continue

		If checked Then
			sb.Append("✓ ")
		Else
			sb.Append("☐ ")
		End If
		sb.Append(text).Append(Chr(10))
		count = count + 1
	Next

	If count = 0 Then
		ToastMessageShow(ModLang.T("empty"), True)
		Return
	End If

	'Compartilha via intent com seletor de apps
	Dim shareIntent As Intent
	shareIntent.Initialize(shareIntent.ACTION_SEND, "")
	shareIntent.SetType("text/plain")
	shareIntent.PutExtra("android.intent.extra.TEXT", sb.ToString)

	Dim jo As JavaObject
	jo.InitializeStatic("android.content.Intent")
	StartActivity(jo.RunMethod("createChooser", Array(shareIntent, ModLang.T("share"))))
End Sub

' ============================================
'  ANEXOS
' ============================================

'Icone anexar - abre seletor de arquivos
Private Sub ivIconAttach_Click
	If IsSecure Then ModSession.Touch
	ContentChooser1.Show("*/*", ModLang.T("select_file"))
End Sub

'Resultado da selecao de arquivo
Private Sub ContentChooser1_Result(Success As Boolean, Dir As String, FileName As String)
	If Success = False Then Return
	If IsSecure Then ModSession.Touch

	'Nota precisa estar salva para ter ID
	If CurrentNoteId = "" Then
		'Salva nota primeiro para obter ID
		If SaveNote(False) = False Then Return
	End If

	'Verifica se e URI ou caminho de arquivo
	Dim isUri As Boolean = Dir.StartsWith("content") Or FileName.StartsWith("content")

	Try
		If isUri Then
			'Copia arquivo da URI para pasta temporaria
			Dim uri As String = IIf(Dir.StartsWith("content"), Dir, FileName)
			CopyFromUriAndAddAttachment(uri)
		Else
			'Caminho de arquivo direto
			AddAttachmentFromFile(Dir, FileName)
		End If
	Catch
		Log("ContentChooser1_Result erro: " & LastException.Message)
		ToastMessageShow(ModLang.T("attachment_error"), True)
	End Try
End Sub

'Copia arquivo de URI para pasta temp e adiciona como anexo
Private Sub CopyFromUriAndAddAttachment(uri As String)
	Try
		'Parse URI
		Dim uriParser As JavaObject
		uriParser.InitializeStatic("android.net.Uri")
		Dim parsedUri As Object = uriParser.RunMethod("parse", Array(uri))

		'Obtem ContentResolver
		Dim ctxt As JavaObject
		ctxt.InitializeContext
		Dim resolver As JavaObject = ctxt.RunMethod("getContentResolver", Null)

		'Obtem nome do arquivo
		Dim fileName As String = GetFileNameFromUri(parsedUri, resolver)
		If fileName = "" Then fileName = "arquivo_" & DateTime.Now

		'Copia para pasta Temp
		Dim tempDir As String = File.DirInternal
		Dim tempName As String = "temp_" & DateTime.Now & "_" & fileName

		'Abre InputStream da URI
		Dim inp As InputStream = resolver.RunMethod("openInputStream", Array(parsedUri))

		'Copia para arquivo temp
		Dim out As OutputStream = File.OpenOutput(tempDir, tempName, False)
		File.Copy2(inp, out)
		out.Close
		inp.Close

		'Agora adiciona o arquivo
		AddAttachmentFromFile(tempDir, tempName)

		'Remove arquivo temp
		File.Delete(tempDir, tempName)

	Catch
		Log("CopyFromUriAndAddAttachment erro: " & LastException.Message)
		ToastMessageShow(ModLang.T("attachment_error"), True)
	End Try
End Sub

'Obtem nome do arquivo a partir de URI
Private Sub GetFileNameFromUri(parsedUri As Object, resolver As JavaObject) As String
	Try
		'Tenta obter via cursor
		Dim cursor As JavaObject = resolver.RunMethod("query", Array(parsedUri, Null, Null, Null, Null))
		If cursor.IsInitialized Then
			cursor.RunMethod("moveToFirst", Null)
			Dim nameIndex As Int = cursor.RunMethod("getColumnIndex", Array("_display_name"))
			If nameIndex >= 0 Then
				Dim name As String = cursor.RunMethod("getString", Array(nameIndex))
				cursor.RunMethod("close", Null)
				Return name
			End If
			cursor.RunMethod("close", Null)
		End If
	Catch
		Log("GetFileNameFromUri erro: " & LastException.Message)
	End Try
	Return ""
End Sub

'Adiciona anexo a partir de arquivo local
Private Sub AddAttachmentFromFile(sourceDir As String, sourceFile As String)
	'Verifica limite de anexos por nota
	If AttachmentsList.Size >= Starter.MAX_ATTACHMENTS_PER_NOTE Then
		ToastMessageShow(ModLang.T("limit_attachments_per_note") & " (" & Starter.MAX_ATTACHMENTS_PER_NOTE & ")", True)
		Return
	End If

	'Valida tamanho
	If ModAttachments.ValidateFileSize(sourceDir, sourceFile) = False Then
		ToastMessageShow(ModLang.T("attachment_too_large"), True)
		Return
	End If

	'Valida extensao
	Dim ext As String = ""
	If sourceFile.Contains(".") Then
		ext = sourceFile.SubString(sourceFile.LastIndexOf(".") + 1).ToLowerCase
	End If
	If ext <> "" And ModAttachments.IsExtensionAllowed(ext) = False Then
		ToastMessageShow(ModLang.T("attachment_type_not_allowed"), True)
		Return
	End If

	'Verifica espaco disponivel (limite total de anexos)
	Dim fileSize As Long = File.Size(sourceDir, sourceFile)
	If ModAttachments.CanAddAttachment(CurrentNoteId, fileSize) = False Then
		ToastMessageShow(ModLang.T("attachment_limit_app"), True)
		Return
	End If

	'Adiciona anexo (copia, criptografa, salva)
	Dim result As Map
	If IsSecure And GroupSalt <> "" Then
		result = ModAttachments.AddAttachment(CurrentNoteId, sourceDir, sourceFile, Passphrase, GroupSalt)
	Else
		'Grupo nao seguro - usa passphrase vazia e salt fixo
		result = ModAttachments.AddAttachment(CurrentNoteId, sourceDir, sourceFile, "lockzero_open", "nosalt")
	End If

	If result <> Null Then
		'Atualiza lista e UI
		AttachmentsList.Add(result)
		RebuildAttachmentsUI
		ToastMessageShow(ModLang.T("attachment_added"), False)
	Else
		ToastMessageShow(ModLang.T("attachment_error"), True)
	End If
End Sub

'Reconstroi UI de anexos
Private Sub RebuildAttachmentsUI
	pnlAttachments.RemoveAllViews

	Dim width As Int = pnlAttachments.Width
	Dim y As Int = 0
	Dim itemHeight As Int = 50dip

	'Calcula espaco total usado
	Dim totalSize As Long = ModAttachments.GetTotalNoteSize(CurrentNoteId)
	Dim maxSize As Long = ModAttachments.MAX_TOTAL_NOTE

	'Titulo "Anexos" com contador
	Dim lblAttachTitle As Label
	lblAttachTitle.Initialize("")
	If AttachmentsList.Size > 0 Then
		lblAttachTitle.Text = ModLang.T("attachments") & " (" & AttachmentsList.Size & ")"
	Else
		lblAttachTitle.Text = ModLang.T("no_attachments")
	End If
	lblAttachTitle.TextSize = Starter.FONT_LABEL
	lblAttachTitle.TextColor = Colors.ARGB(180, 255, 255, 255)
	lblAttachTitle.Gravity = Gravity.CENTER_VERTICAL
	pnlAttachments.AddView(lblAttachTitle, 0, y, width, 24dip)
	y = y + 28dip

	'Barra de espaco usado (se houver anexos)
	If AttachmentsList.Size > 0 Then
		'Label de espaco
		Dim lblSpace As Label
		lblSpace.Initialize("")
		lblSpace.Text = ModLang.T("attachment_space_used") & ": " & ModAttachments.FormatFileSize(totalSize) & " " & ModLang.T("attachment_of") & " " & ModAttachments.FormatFileSize(maxSize)
		lblSpace.TextSize = Starter.FONT_CAPTION
		lblSpace.TextColor = Colors.ARGB(140, 255, 255, 255)
		pnlAttachments.AddView(lblSpace, 0, y, width, 18dip)
		y = y + 22dip

		'Barra de progresso visual
		Dim pnlBarBg As Panel
		pnlBarBg.Initialize("")
		pnlBarBg.Color = Colors.ARGB(60, 255, 255, 255)
		pnlAttachments.AddView(pnlBarBg, 0, y, width, 6dip)

		Dim usedPercent As Float = (totalSize * 100) / maxSize
		If usedPercent > 100 Then usedPercent = 100
		Dim barWidth As Int = (width * usedPercent) / 100

		Dim pnlBarFill As Panel
		pnlBarFill.Initialize("")
		If usedPercent > 80 Then
			pnlBarFill.Color = Colors.RGB(255, 100, 100)  'Vermelho
		Else If usedPercent > 50 Then
			pnlBarFill.Color = Colors.RGB(255, 180, 100)  'Laranja
		Else
			pnlBarFill.Color = Colors.RGB(100, 200, 100)  'Verde
		End If
		pnlAttachments.AddView(pnlBarFill, 0, y, barWidth, 6dip)
		y = y + 14dip
	End If

	'Lista de anexos
	For i = 0 To AttachmentsList.Size - 1
		Dim attachment As Map = AttachmentsList.Get(i)
		Dim pnlItem As Panel = CreateAttachmentPanel(i, attachment, width)
		pnlAttachments.AddView(pnlItem, 0, y, width, itemHeight)
		y = y + itemHeight + 6dip
	Next

	'Ajusta altura do painel
	pnlAttachments.Height = Max(y, 50dip)

	'Ajusta posicao do painel de anexos
	If NoteType = "text" Then
		pnlAttachments.Top = pnlTextMode.Top + pnlTextMode.Height + 10dip
		pnlContent.Height = pnlAttachments.Top + pnlAttachments.Height + 50dip
	Else If IsCardTemplate = False Then
		pnlAttachments.Top = pnlListMode.Top + pnlListMode.Height + 10dip
		pnlContent.Height = Max(pnlContent.Height, pnlAttachments.Top + pnlAttachments.Height + 50dip)
	End If
End Sub

'Cria painel para um anexo
Private Sub CreateAttachmentPanel(index As Int, attachment As Map, panelWidth As Int) As Panel
	Dim pnl As Panel
	pnl.Initialize("pnlAttachment")
	pnl.Tag = index

	Dim xv As B4XView = pnl
	xv.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModTheme.HomeIconBg, 8dip)

	'Dados do anexo
	Dim attachId As String = attachment.GetDefault("id", "")
	Dim originalName As String = attachment.GetDefault("originalName", "arquivo")
	Dim originalSize As Long = attachment.GetDefault("originalSize", 0)
	Dim mimeType As String = attachment.GetDefault("mimeType", "")

	'Trunca nome se muito longo
	Dim displayName As String = originalName
	If displayName.Length > 22 Then displayName = displayName.SubString2(0, 19) & "..."

	'Icone baseado no tipo
	Dim lblIcon As Label
	lblIcon.Initialize("")
	lblIcon.Text = ModAttachments.GetFileIcon(mimeType)
	lblIcon.TextSize = 18
	lblIcon.Gravity = Gravity.CENTER
	pnl.AddView(lblIcon, 8dip, 0, 30dip, 50dip)

	'Nome do arquivo (clicavel para abrir)
	Dim lblFileName As Label
	lblFileName.Initialize("lblAttachOpen")
	lblFileName.Tag = index
	lblFileName.Text = displayName
	lblFileName.TextSize = Starter.FONT_BODY
	lblFileName.TextColor = Colors.RGB(100, 180, 255)  'Azul link
	lblFileName.Gravity = Gravity.CENTER_VERTICAL
	pnl.AddView(lblFileName, 42dip, 0, panelWidth - 140dip, 50dip)

	'Tamanho do arquivo
	Dim lblSize As Label
	lblSize.Initialize("")
	lblSize.Text = ModAttachments.FormatFileSize(originalSize)
	lblSize.TextSize = Starter.FONT_CAPTION
	lblSize.TextColor = Colors.ARGB(140, 255, 255, 255)
	lblSize.Gravity = Gravity.CENTER
	pnl.AddView(lblSize, panelWidth - 100dip, 0, 50dip, 50dip)

	'Botao X para remover
	Dim lblRemove As Label
	lblRemove.Initialize("lblAttachRemove")
	lblRemove.Tag = index
	lblRemove.Text = "X"
	lblRemove.TextSize = 18
	lblRemove.TextColor = Colors.RGB(255, 100, 100)
	lblRemove.Gravity = Gravity.CENTER
	pnl.AddView(lblRemove, panelWidth - 44dip, 0, 40dip, 50dip)

	Return pnl
End Sub

'Clique no nome do arquivo - descriptografa e abre com app externo
Private Sub lblAttachOpen_Click
	Dim lbl As Label = Sender
	Dim index As Int = lbl.Tag

	If index < 0 Or index >= AttachmentsList.Size Then Return
	If IsSecure Then ModSession.Touch

	Dim attachment As Map = AttachmentsList.Get(index)
	Dim attachId As String = attachment.GetDefault("id", "")
	Dim originalName As String = attachment.GetDefault("originalName", "")
	Dim mimeType As String = attachment.GetDefault("mimeType", "")

	If attachId = "" Then
		ToastMessageShow(ModLang.T("attachment_not_found"), True)
		Return
	End If

	'Descriptografa anexo para pasta Temp
	Dim tempPath As String
	If IsSecure And GroupSalt <> "" Then
		tempPath = ModAttachments.GetAttachment(CurrentNoteId, attachId, Passphrase, GroupSalt)
	Else
		tempPath = ModAttachments.GetAttachment(CurrentNoteId, attachId, "lockzero_open", "nosalt")
	End If

	If tempPath = "" Then
		ToastMessageShow(ModLang.T("attachment_open_error"), True)
		Return
	End If

	'Abre arquivo com app externo
	OpenTempFile(tempPath, originalName, mimeType)
End Sub

'Abre arquivo temporario descriptografado
Private Sub OpenTempFile(filePath As String, displayName As String, mimeType As String)
	Try
		Log("OpenTempFile: path=" & filePath & ", name=" & displayName & ", mime=" & mimeType)

		'Se mimeType nao veio, tenta detectar
		If mimeType = "" Or mimeType = "application/octet-stream" Then
			mimeType = ModAttachments.GetMimeType(displayName)
		End If

		'Usa FileProvider para compartilhar arquivo com outros apps
		Dim ctxt As JavaObject
		ctxt.InitializeContext

		'Cria File object
		Dim fileObj As JavaObject
		fileObj.InitializeNewInstance("java.io.File", Array(filePath))

		'Obtem URI via FileProvider
		Dim authority As String = Application.PackageName & ".provider"
		Dim fileProvider As JavaObject
		fileProvider.InitializeStatic("androidx.core.content.FileProvider")
		Dim contentUri As Object = fileProvider.RunMethod("getUriForFile", Array(ctxt, authority, fileObj))

		'Cria Intent para abrir
		Dim openIntent As Intent
		openIntent.Initialize(openIntent.ACTION_VIEW, "")
		Dim intentJO As JavaObject = openIntent
		intentJO.RunMethod("setDataAndType", Array(contentUri, mimeType))
		intentJO.RunMethod("addFlags", Array(1))  'FLAG_GRANT_READ_URI_PERMISSION

		Dim jo As JavaObject
		jo.InitializeStatic("android.content.Intent")
		StartActivity(jo.RunMethod("createChooser", Array(openIntent, ModLang.T("open_with"))))

	Catch
		Log("OpenTempFile error: " & LastException.Message)
		ToastMessageShow(ModLang.T("attachment_open_error"), True)
	End Try
End Sub

'Clique no X - confirma e remove anexo
Private Sub lblAttachRemove_Click
	Dim lbl As Label = Sender
	Dim index As Int = lbl.Tag

	If index < 0 Or index >= AttachmentsList.Size Then Return

	'Confirma exclusao
	Wait For (xui.Msgbox2Async(ModLang.T("attachment_delete_confirm"), ModLang.T("delete"), ModLang.T("yes"), "", ModLang.T("cancel"), Null)) Msgbox_Result(Result As Int)

	If Result = xui.DialogResponse_Positive Then
		Dim attachment As Map = AttachmentsList.Get(index)
		Dim attachId As String = attachment.GetDefault("id", "")

		'Remove do ModAttachments
		If attachId <> "" Then
			ModAttachments.DeleteAttachment(CurrentNoteId, attachId)
		End If

		'Atualiza lista e UI
		AttachmentsList.RemoveAt(index)
		RebuildAttachmentsUI
		ToastMessageShow(ModLang.T("attachment_deleted"), False)
	End If
End Sub

'Icone salvar
Private Sub lblIconSave_Click
	SaveNote(True)
End Sub

Private Sub edtTitle_FocusChanged(HasFocus As Boolean)
	If HasFocus Then svContent.ScrollPosition = 0
End Sub

Private Sub edtContent_FocusChanged(HasFocus As Boolean)
	If HasFocus Then svContent.ScrollPosition = edtContent.Top - 30dip
End Sub

' ============================================
'  TEMA
' ============================================

Private Sub ApplyTheme
	Root.Color = ModTheme.HomeBg
	svContent.Color = ModTheme.HomeBg
	pnlContent.Color = ModTheme.HomeBg

	'Campos com fundo escuro e borda sutil
	Dim cd As ColorDrawable
	cd.Initialize2(ModTheme.HomeHeaderBg, 8dip, 1dip, Colors.ARGB(80, 255, 255, 255))

	edtTitle.Background = cd
	edtTitle.TextColor = Colors.White
	edtTitle.HintColor = Colors.ARGB(120, 255, 255, 255)

	edtContent.Background = cd
	edtContent.TextColor = Colors.White
	edtContent.HintColor = Colors.ARGB(120, 255, 255, 255)

	chkFavorite.TextColor = Colors.White
End Sub

' ============================================
'  UTILIDADES
' ============================================

'Carrega icone padrao do Android com filtro de cor
Private Sub SetAndroidIcon(iv As ImageView, iconName As String)
	Try
		Dim r As Reflector
		r.Target = r.GetContext
		Dim resources As Object = r.RunMethod("getResources")
		r.Target = resources
		Dim id As Int = r.RunMethod4("getIdentifier", Array As Object(iconName, "drawable", "android"), Array As String("java.lang.String", "java.lang.String", "java.lang.String"))
		If id > 0 Then
			Dim drawable As Object = r.RunMethod2("getDrawable", id, "java.lang.int")
			Dim ivJO As JavaObject = iv
			ivJO.RunMethod("setImageDrawable", Array(drawable))
			'Aplica filtro branco para visibilidade no tema escuro
			ivJO.RunMethodJO("setColorFilter", Array(Colors.White))
		End If
	Catch
		Log("SetAndroidIcon erro: " & LastException.Message)
	End Try
End Sub

