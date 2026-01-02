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
	Private Root As B4XView
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
End Sub

Public Sub Initialize
	ItemsList.Initialize
	ItemPanels.Initialize
End Sub

'Anima entrada da pagina - chamar DEPOIS de B4XPages.ShowPage
Public Sub AnimateIn
	ModTransition.SlideFromRight(Root)
End Sub

Private Sub B4XPage_Created(Root1 As B4XView)
	Root = Root1
	CreateUI
	ApplyTheme
End Sub

Private Sub B4XPage_Appear
	'Transicao de entrada
	ModTransition.SlideIn(Root)

	'Breadcrumb: Nota → NomeGrupo → Titulo
	Dim lastPart As String
	If IsNewNote Then
		If NoteType = "list" Then
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

	IsNewNote = (CurrentNoteId.Length = 0)
	ItemsList.Initialize
	ItemPanels.Initialize
	CurrentFilter = ""  'Limpa filtro ao abrir

	'Configura UI baseado no modo
	SetupModeUI

	If IsNewNote Then
		edtTitle.Text = ""
		If NoteType = "text" Then
			edtContent.Text = ""
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
	CreateIconBar(pnlIconBar, width, iconBarH)

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
	CreateInputDialog
End Sub

Private Sub CreateIconBar(pnlIconBar As Panel, width As Int, barH As Int)
	Dim iconSize As Int = 44dip
	Dim spacing As Int = 8dip
	Dim startX As Int = width - (iconSize * 4) - (spacing * 3) - 16dip  'Alinha a direita

	'+ Adicionar item (so para listas)
	lblIconAdd.Initialize("lblIconAdd")
	lblIconAdd.Text = "+"
	lblIconAdd.TextSize = 24
	lblIconAdd.TextColor = Colors.White
	lblIconAdd.Gravity = Gravity.CENTER
	pnlIconBar.AddView(lblIconAdd, startX, 3dip, iconSize, iconSize)
	Dim xvAdd As B4XView = lblIconAdd
	xvAdd.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModTheme.HomeIconBg, 22dip)

	'Lixeira - excluir nota (icone Android padrao)
	ivIconDelete.Initialize("ivIconDelete")
	ivIconDelete.Gravity = Gravity.CENTER
	ivIconDelete.Visible = False  'So aparece ao editar
	pnlIconBar.AddView(ivIconDelete, startX + iconSize + spacing, 3dip, iconSize, iconSize)
	SetAndroidIcon(ivIconDelete, "ic_menu_delete")

	'Compartilhar (icone Android padrao)
	ivIconShare.Initialize("ivIconShare")
	ivIconShare.Gravity = Gravity.CENTER
	pnlIconBar.AddView(ivIconShare, startX + (iconSize + spacing) * 2, 3dip, iconSize, iconSize)
	SetAndroidIcon(ivIconShare, "ic_menu_share")

	'Salvar (check verde)
	lblIconSave.Initialize("lblIconSave")
	lblIconSave.Text = Chr(0x2713)  'Check ✓
	lblIconSave.TextSize = 22
	lblIconSave.TextColor = Colors.RGB(100, 200, 100)
	lblIconSave.Gravity = Gravity.CENTER
	pnlIconBar.AddView(lblIconSave, startX + (iconSize + spacing) * 3, 3dip, iconSize, iconSize)
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

Private Sub SetupModeUI
	If NoteType = "list" Then
		pnlTextMode.Visible = False
		pnlListMode.Visible = True
		lblIconAdd.Visible = True
		ivIconShare.Visible = True
		RebuildItemsUI
	Else
		pnlTextMode.Visible = True
		pnlListMode.Visible = False
		lblIconAdd.Visible = False  'Nao tem + para texto
		ivIconShare.Visible = False  'Nao compartilha texto
		'Altura do conteudo para modo texto
		pnlContent.Height = 92dip + 350dip + 20dip
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

	For i = 0 To ItemsList.Size - 1
		Dim item As Map = ItemsList.Get(i)
		Dim itemText As String = item.GetDefault("text", "")

		'Aplica filtro
		If ItemMatchesFilter(itemText) = False Then Continue

		Dim pnlItem As Panel = CreateItemPanel(i, item, width)
		pnlItems.AddView(pnlItem, 0, y, width, itemHeight)
		ItemPanels.Add(pnlItem)
		y = y + itemHeight + 8dip
	Next

	'Ajusta altura do container de itens
	pnlItems.Height = Max(y, 50dip)

	'Reposiciona container do botao adicionar
	'pnlItems esta em Top=52dip, entao pnlAddRow fica logo abaixo
	Dim addRowTop As Int = 52dip + pnlItems.Height + 10dip
	pnlAddRow.Top = addRowTop

	'Ajusta altura do pnlListMode para conter tudo
	'52dip (filtro) + pnlItems.Height + 10dip (espaco) + 50dip (pnlAddRow) + 10dip (margem)
	pnlListMode.Height = addRowTop + 60dip

	'Ajusta pnlContent
	Dim totalHeight As Int = 70dip + pnlListMode.Height + 20dip
	pnlContent.Height = Max(totalHeight, 300dip)

	IsRebuildingUI = False  'Libera eventos de checkbox
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

	Dim title As String = edtTitle.Text.Trim

	'Validacoes
	If title.Length < 1 Then
		ToastMessageShow(ModLang.T("error_empty_field"), True)
		Return False
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
	B4XPages.ClosePage(Me)
End Sub

'Icone + adicionar item
Private Sub lblIconAdd_Click
	If IsSecure Then ModSession.Touch
	ShowInputDialog(ModLang.T("note_add_item"), "", -1)
End Sub

'Icone lixeira - excluir nota
Private Sub ivIconDelete_Click
	If IsSecure Then ModSession.Touch

	Wait For (xui.Msgbox2Async(ModLang.T("confirm_delete"), ModLang.T("delete"), ModLang.T("yes"), "", ModLang.T("cancel"), Null)) Msgbox_Result(Result As Int)

	If Result = xui.DialogResponse_Positive Then
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

	'Compartilha via intent
	Dim shareIntent As Intent
	shareIntent.Initialize(shareIntent.ACTION_SEND, "")
	shareIntent.SetType("text/plain")
	shareIntent.PutExtra("android.intent.extra.TEXT", sb.ToString)
	StartActivity(shareIntent)
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

