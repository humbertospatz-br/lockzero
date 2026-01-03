B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
'PageNotesList.bas - Lista de Notas de um Grupo
'LockZero - Lock and ZERO worries

Sub Class_Globals
	Public Root As B4XView  'Public para transicoes
	Private xui As XUI

	'UI
	Private lblAdd As Label
	Private btnBack As Button

	Private svNotes As ScrollView
	Private pnlNotes As B4XView

	Private lblEmpty As Label
	Private lblTitle As Label

	'Busca
	Private lblSearch As Label         'Icone de lupa no header
	Private pnlSearchBar As Panel      'Barra de busca expansivel
	Private edtSearch As EditText      'Campo de busca
	Private lblClearSearch As Label    'Botao X para limpar
	Private IsSearchVisible As Boolean = False  'Controla visibilidade da busca
	Private AllNotes As List           'Lista completa de notas
	Private FilteredNotes As List      'Lista filtrada pela busca

	'Estado
	Private CurrentGroupId As String = ""
	Private IsNoteGroup As Boolean = False  'True = NoteGroup, False = PasswordGroup (legado)
	Private CurrentGroup As clsNoteGroup    'Referencia ao grupo atual
	Private GroupPassphrase As String = ""  'Passphrase para grupos seguros
	Private IsNavigating As Boolean = False  'Flag para evitar navegacao dupla
End Sub

Public Sub Initialize
	AllNotes.Initialize
	FilteredNotes.Initialize
End Sub

Private Sub B4XPage_Created(Root1 As B4XView)
	Root = Root1
	CreateUI
	ApplyTheme
End Sub

Private Sub B4XPage_Appear

	Log("PageNotesList.B4XPage_Appear - IsNavigating=" & IsNavigating)

	'Atualiza titulo com breadcrumb: Notas → NomeGrupo
	If IsNoteGroup And CurrentGroup <> Null Then
		Dim displayName As String = GetGroupDisplayName(CurrentGroup)
		lblTitle.Text = ModLang.T("notes") & " → " & displayName
		CallSub2(Main, "SetPageTitle", displayName)
	Else
		lblTitle.Text = ModLang.T("notes")
		CallSub2(Main, "SetPageTitle", ModLang.T("notes"))
	End If

	'Touch na sessao se grupo seguro
	If IsNoteGroup And CurrentGroup <> Null And CurrentGroup.IsSecure Then
		ModSession.Touch
	End If

	LoadNotes

	'Reset da flag de navegacao com delay para evitar cliques fantasma
	Sleep(100)
	IsNavigating = False
	Log("PageNotesList - IsNavigating resetado para False")
End Sub

'Recebe parametros da pagina anterior
Public Sub SetParams(params As Map)
	If params = Null Then Return
	CurrentGroupId = params.GetDefault("groupId", "")
	IsNoteGroup = params.GetDefault("isNoteGroup", False)
	GroupPassphrase = params.GetDefault("passphrase", "")

	'Se for NoteGroup, obtem referencia ao grupo
	If IsNoteGroup Then
		CurrentGroup = ModNotes.GetNoteGroupById(CurrentGroupId)
	Else
		CurrentGroup = Null
	End If
End Sub

' ============================================
'  CRIAR UI
' ============================================

Private Sub CreateUI
	Dim width As Int = Root.Width
	Dim height As Int = Root.Height
	Dim headerH As Int = 56dip
	Dim searchH As Int = 54dip

	'Header com titulo e botao + (cores da Home)
	Dim pnlHeader As Panel
	pnlHeader.Initialize("")
	pnlHeader.Color = ModTheme.HomeHeaderBg
	Root.AddView(pnlHeader, 0, 0, width, headerH)

	'Botao voltar
	btnBack.Initialize("btnBack")
	btnBack.Text = "<"
	btnBack.TextSize = 20
	btnBack.TextColor = Colors.White
	btnBack.Color = Colors.Transparent
	btnBack.Gravity = Gravity.CENTER
	pnlHeader.AddView(btnBack, 0, 0, 48dip, headerH)

	'Titulo (sera atualizado em B4XPage_Appear)
	lblTitle.Initialize("")
	lblTitle.Text = ModLang.T("notes")
	lblTitle.TextSize = Starter.FONT_BODY
	lblTitle.TextColor = Colors.ARGB(200, 255, 255, 255)
	lblTitle.Typeface = Typeface.DEFAULT_BOLD
	lblTitle.Gravity = Gravity.CENTER_VERTICAL
	pnlHeader.AddView(lblTitle, 48dip, 0, width - 150dip, headerH)

	'Icone de busca (lupa) no header
	lblSearch.Initialize("lblSearch")
	lblSearch.Text = Chr(0xD83D) & Chr(0xDD0D)  '🔍 (surrogate pair)
	lblSearch.TextSize = 18
	lblSearch.TextColor = Colors.White
	lblSearch.Gravity = Gravity.CENTER
	pnlHeader.AddView(lblSearch, width - 90dip, 8dip, 40dip, 40dip)

	'Fundo arredondado para a lupa (indica que e clicavel)
	Dim xvSearch As B4XView = lblSearch
	xvSearch.SetColorAndBorder(Colors.ARGB(60, 255, 255, 255), 0, Colors.Transparent, 20dip)

	'Botao adicionar no header (circular)
	lblAdd.Initialize("lblAdd")
	lblAdd.Text = "+"
	lblAdd.TextSize = 26
	lblAdd.Typeface = Typeface.DEFAULT_BOLD
	lblAdd.Gravity = Gravity.CENTER
	lblAdd.TextColor = Colors.White
	pnlHeader.AddView(lblAdd, width - 50dip, 8dip, 40dip, 40dip)

	'Arredondar (circular)
	Dim xvAdd As B4XView = lblAdd
	xvAdd.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModTheme.HomeIconBg, 20dip)

	'Barra de busca (inicialmente oculta)
	pnlSearchBar.Initialize("")
	pnlSearchBar.Color = ModTheme.HomeBg
	pnlSearchBar.Visible = False
	Root.AddView(pnlSearchBar, 0, headerH, width, searchH)

	'Input de busca com fundo arredondado
	Dim pnlSearchInput As Panel
	pnlSearchInput.Initialize("")
	pnlSearchInput.Color = ModTheme.HomeIconBg
	pnlSearchBar.AddView(pnlSearchInput, 16dip, 5dip, width - 32dip, 44dip)

	Dim xvSearchInput As B4XView = pnlSearchInput
	xvSearchInput.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModTheme.HomeIconBg, 8dip)

	edtSearch.Initialize("edtSearch")
	edtSearch.Hint = ModLang.T("search") & "..."
	edtSearch.SingleLine = True
	edtSearch.Text = ""
	edtSearch.TextSize = Starter.FONT_BODY
	edtSearch.TextColor = Colors.White
	edtSearch.HintColor = Colors.ARGB(120, 255, 255, 255)
	pnlSearchInput.AddView(edtSearch, 12dip, 0, width - 100dip, 44dip)

	'Botao X para limpar busca
	lblClearSearch.Initialize("lblClearSearch")
	lblClearSearch.Text = "X"
	lblClearSearch.TextSize = 16
	lblClearSearch.TextColor = Colors.ARGB(180, 255, 255, 255)
	lblClearSearch.Gravity = Gravity.CENTER
	lblClearSearch.Visible = False
	pnlSearchInput.AddView(lblClearSearch, width - 80dip, 2dip, 40dip, 40dip)

	'Lista de notas (sem separador, fundo continuo)
	svNotes.Initialize(0)
	svNotes.Color = ModTheme.HomeBg
	Root.AddView(svNotes, 0, headerH, width, height - headerH)

	pnlNotes = svNotes.Panel
	pnlNotes.Color = ModTheme.HomeBg

	'Label vazio
	lblEmpty.Initialize("")
	lblEmpty.Text = ModLang.T("empty")
	lblEmpty.TextSize = Starter.FONT_BODY
	lblEmpty.Gravity = Gravity.CENTER
	lblEmpty.Visible = False
	Root.AddView(lblEmpty, 0, height / 2 - 20dip, width, 40dip)
End Sub

' ============================================
'  CARREGAR NOTAS
' ============================================

Private Sub LoadNotes
	'Carrega todas as notas do grupo
	AllNotes = ModNotes.GetNotesByGroup(CurrentGroupId)

	'Reseta busca e exibe todas
	edtSearch.Text = ""
	FilteredNotes.Initialize
	For Each n As clsNoteEntry In AllNotes
		FilteredNotes.Add(n)
	Next

	'Esconde barra de busca ao carregar
	IsSearchVisible = False
	UpdateSearchVisibility

	DisplayNotes
End Sub

'Filtra notas com base no texto de busca
Private Sub FilterNotes(query As String)
	FilteredNotes.Initialize
	Dim q As String = query.ToLowerCase.Trim

	If q.Length = 0 Then
		'Sem filtro - mostra todas
		For Each n As clsNoteEntry In AllNotes
			FilteredNotes.Add(n)
		Next
	Else
		'Determina passphrase (vazia para grupos abertos)
		Dim passphrase As String = ""
		If IsNoteGroup And CurrentGroup <> Null And CurrentGroup.IsSecure Then
			passphrase = GroupPassphrase
			If passphrase = "" Then passphrase = ModSession.GetPassphrase
		End If

		'Filtra por titulo, conteudo e itens de lista
		For Each n As clsNoteEntry In AllNotes
			Dim found As Boolean = False

			Try
				'Busca no titulo
				Dim title As String = n.GetDecryptedTitle(passphrase).ToLowerCase
				If title.Contains(q) Then
					found = True
				End If

				'Busca no conteudo (notas de texto)
				If found = False Then
					Dim content As String = n.GetDecryptedContent(passphrase).ToLowerCase
					If content.Contains(q) Then found = True
				End If

				'Busca nos itens (notas de lista/checklist)
				If found = False And n.IsListNote Then
					Dim itemsJson As String = n.GetDecryptedItems(passphrase).ToLowerCase
					If itemsJson.Contains(q) Then found = True
				End If
			Catch
				'Fallback: busca em campos diretos
				If n.Title.ToLowerCase.Contains(q) Then found = True
				If found = False And n.Content.ToLowerCase.Contains(q) Then found = True
				If found = False And n.Items.ToLowerCase.Contains(q) Then found = True
			End Try

			If found Then FilteredNotes.Add(n)
		Next
	End If

	DisplayNotes
End Sub

'Exibe as notas filtradas na lista
Private Sub DisplayNotes
	pnlNotes.RemoveAllViews

	If FilteredNotes.Size = 0 Then
		lblEmpty.Visible = True
		pnlNotes.Height = 0
		Return
	End If

	lblEmpty.Visible = False

	Dim width As Int = Root.Width
	Dim y As Int = 10dip
	Dim cardHeight As Int = 80dip
	Dim margin As Int = 16dip

	For i = 0 To FilteredNotes.Size - 1
		Dim note As clsNoteEntry = FilteredNotes.Get(i)
		Dim pnlCard As Panel = CreateNoteCard(note, width - (margin * 2))
		pnlCard.Tag = note.Id
		pnlNotes.AddView(pnlCard, margin, y, width - (margin * 2), cardHeight)
		y = y + cardHeight + 10dip
	Next

	pnlNotes.Height = y + 20dip
End Sub

'Atualiza visibilidade da barra de busca e ajusta posicao da lista
Private Sub UpdateSearchVisibility
	Dim headerH As Int = 56dip
	Dim searchH As Int = 54dip

	pnlSearchBar.Visible = IsSearchVisible

	If IsSearchVisible Then
		svNotes.Top = headerH + searchH
		svNotes.Height = Root.Height - headerH - searchH
		edtSearch.RequestFocus
	Else
		svNotes.Top = headerH
		svNotes.Height = Root.Height - headerH
		'Esconde teclado
		Dim ime As IME
		ime.Initialize("")
		ime.HideKeyboard
	End If
End Sub

Private Sub CreateNoteCard(note As clsNoteEntry, cardWidth As Int) As Panel
	Dim pnl As Panel
	pnl.Initialize("pnlNote")

	'Card com cor da Home e cantos arredondados
	Dim xv As B4XView = pnl
	xv.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModTheme.HomeIconBg, 12dip)

	'Determina se precisa descriptografar
	Dim needsDecrypt As Boolean = True
	Dim passphrase As String = ""

	If IsNoteGroup And CurrentGroup <> Null Then
		If CurrentGroup.IsSecure = False Then
			'Grupo ABERTO - notas em texto claro
			needsDecrypt = False
		Else
			'Grupo SEGURO - usa passphrase da sessao ou passada por parametro
			passphrase = GroupPassphrase
			If passphrase = "" Then passphrase = ModSession.GetPassphrase
		End If
	Else
		'Legado (PasswordGroup) - sempre descriptografa
		passphrase = ModSession.GetPassphrase
	End If

	'Verifica se e grupo de cartoes
	Dim isCardGroup As Boolean = False
	If CurrentGroup <> Null And CurrentGroup.TemplateType = "card" Then
		isCardGroup = True
	End If

	'Icone do tipo de nota (text/list/card)
	Dim lblTypeIcon As Label
	lblTypeIcon.Initialize("")
	If isCardGroup Then
		lblTypeIcon.Text = Chr(0xD83D) & Chr(0xDCB3)  'Cartao 💳 (surrogate pair)
	Else If note.IsListNote Then
		lblTypeIcon.Text = Chr(0x2611)  'Checkbox marcado ☑
	Else
		lblTypeIcon.Text = Chr(0xD83D) & Chr(0xDCDD)  'Nota 📝 (surrogate pair)
	End If
	lblTypeIcon.TextSize = 20
	lblTypeIcon.Gravity = Gravity.CENTER
	pnl.AddView(lblTypeIcon, 8dip, 25dip, 30dip, 30dip)

	'Titulo
	Dim title As String
	If isCardGroup And note.IsListNote Then
		'Grupo de cartoes: usa primeiro item (Nome) como titulo
		title = GetCardNameFromNote(note, passphrase, needsDecrypt)
	Else If needsDecrypt Then
		title = note.GetDecryptedTitle(passphrase)
	Else
		title = note.Title  'Texto claro para grupos abertos
	End If
	If title.Length > 25 Then title = title.SubString2(0, 25) & "..."

	Dim lblNoteTitle As Label
	lblNoteTitle.Initialize("")
	lblNoteTitle.Text = title
	lblNoteTitle.TextSize = Starter.FONT_BODY
	lblNoteTitle.TextColor = Colors.White
	lblNoteTitle.Typeface = Typeface.CreateNew(Typeface.DEFAULT, Typeface.STYLE_BOLD)
	pnl.AddView(lblNoteTitle, 42dip, 10dip, cardWidth - 90dip, 25dip)

	'Preview baseado no tipo de nota (nao mostra para cartoes)
	Dim preview As String = ""
	If isCardGroup Then
		'Cartao: sem preview
		preview = ""
	Else If note.IsListNote Then
		'Lista: mostra "X de Y itens"
		Dim total As Int = note.GetItemsCount
		Dim checked As Int = note.GetCheckedCount
		preview = checked & " " & ModLang.T("of") & " " & total & " " & ModLang.T("items")
	Else
		'Texto: preview do conteudo
		If needsDecrypt Then
			preview = note.GetDecryptedContent(passphrase)
		Else
			preview = note.Content
		End If
		If preview.Length > 40 Then preview = preview.SubString2(0, 40) & "..."
		preview = preview.Replace(Chr(10), " ").Replace(Chr(13), " ")
	End If

	Dim lblPreview As Label
	lblPreview.Initialize("")
	lblPreview.Text = preview
	lblPreview.TextSize = Starter.FONT_LABEL
	lblPreview.TextColor = Colors.ARGB(180, 255, 255, 255)
	pnl.AddView(lblPreview, 42dip, 38dip, cardWidth - 90dip, 30dip)

	'Favorito
	If note.IsFavorite Then
		Dim lblStar As Label
		lblStar.Initialize("")
		lblStar.Text = Chr(9733) '"★"
		lblStar.TextSize = 20
		lblStar.TextColor = Colors.RGB(255, 200, 100) 'Amarelo suave
		lblStar.Gravity = Gravity.CENTER
		pnl.AddView(lblStar, cardWidth - 40dip, 25dip, 30dip, 30dip)
	End If

	Return pnl
End Sub

Private Sub pnlNote_Click
	Log("pnlNote_Click - IsNavigating=" & IsNavigating)
	Dim pnl As Panel = Sender
	Dim noteId As String = pnl.Tag
	OpenNote(noteId)
End Sub

Private Sub OpenNote(noteId As String)
	'Evita navegacao dupla
	If IsNavigating Then Return
	IsNavigating = True

	'Touch na sessao se grupo seguro
	If IsNoteGroup And CurrentGroup <> Null And CurrentGroup.IsSecure Then
		ModSession.Touch
	End If

	Dim note As clsNoteEntry = ModNotes.GetNoteById(noteId)
	If note = Null Then
		IsNavigating = False
		Return
	End If

	Dim params As Map
	params.Initialize
	params.Put("noteId", noteId)
	params.Put("groupId", CurrentGroupId)
	params.Put("isNoteGroup", IsNoteGroup)
	If IsNoteGroup And CurrentGroup <> Null Then
		params.Put("isSecure", CurrentGroup.IsSecure)
		params.Put("passphrase", GroupPassphrase)
		params.Put("groupName", CurrentGroup.Name)
	End If
	'Passa termo de busca para destacar/filtrar na nota
	If edtSearch.Text.Trim.Length > 0 Then
		params.Put("searchQuery", edtSearch.Text.Trim)
	End If

	Dim pg As PageNoteEdit = B4XPages.GetPage("PageNoteEdit")
	pg.SetParams(params)
	ModTransition.SlideToLeft(Root, pg.Root)
	B4XPages.ShowPage("PageNoteEdit")
End Sub

' ============================================
'  EVENTOS
' ============================================

Private Sub btnBack_Click
	B4XPages.ClosePage(Me)
End Sub

'Toggle da barra de busca ao clicar na lupa
Private Sub lblSearch_Click
	IsSearchVisible = Not(IsSearchVisible)
	UpdateSearchVisibility

	If IsSearchVisible = False Then
		'Limpa busca ao fechar
		edtSearch.Text = ""
		FilterNotes("")
	End If
End Sub

'Evento de busca - filtra conforme digita
Private Sub edtSearch_TextChanged(Old As String, New As String)
	'Touch na sessao se grupo seguro
	If IsNoteGroup And CurrentGroup <> Null And CurrentGroup.IsSecure Then
		ModSession.Touch
	End If
	FilterNotes(New)
	'Mostra/esconde botao X
	lblClearSearch.Visible = (New.Length > 0)
End Sub

'Limpa o campo de busca
Private Sub lblClearSearch_Click
	edtSearch.Text = ""
	lblClearSearch.Visible = False
	FilterNotes("")
End Sub

Private Sub lblAdd_Click
	Log("lblAdd_Click - IsNavigating=" & IsNavigating)
	'Evita navegacao dupla
	If IsNavigating Then Return

	'Touch na sessao se grupo seguro
	If IsNoteGroup And CurrentGroup <> Null And CurrentGroup.IsSecure Then
		ModSession.Touch
	End If

	Dim noteType As String = ""

	'Grupo de cartoes: vai direto para lista (template de cartao)
	If CurrentGroup <> Null And CurrentGroup.TemplateType = "card" Then
		noteType = "list"
	Else
		'Dialog para escolher tipo de nota
		Wait For (xui.Msgbox2Async(ModLang.T("note_type_choose"), ModLang.T("new_note"), ModLang.T("note_type_text"), ModLang.T("cancel"), ModLang.T("note_type_list"), Null)) Msgbox_Result(Result As Int)

		If Result = xui.DialogResponse_Positive Then
			noteType = "text"
		Else If Result = xui.DialogResponse_Negative Then
			noteType = "list"
		Else
			Return  'Cancelou
		End If
	End If

	IsNavigating = True

	Dim params As Map
	params.Initialize
	params.Put("noteId", "")
	params.Put("groupId", CurrentGroupId)
	params.Put("isNoteGroup", IsNoteGroup)
	params.Put("noteType", noteType)
	If IsNoteGroup And CurrentGroup <> Null Then
		params.Put("isSecure", CurrentGroup.IsSecure)
		params.Put("passphrase", GroupPassphrase)
		params.Put("groupName", CurrentGroup.Name)
	End If

	Dim pg As PageNoteEdit = B4XPages.GetPage("PageNoteEdit")
	pg.SetParams(params)
	ModTransition.SlideToLeft(Root, pg.Root)
	B4XPages.ShowPage("PageNoteEdit")
End Sub

' ============================================
'  TEMA
' ============================================

Private Sub ApplyTheme
	Root.Color = ModTheme.HomeBg


	btnBack.Color = Colors.Transparent
	btnBack.TextColor = Colors.White

	lblEmpty.TextColor = Colors.ARGB(150, 255, 255, 255)
End Sub

' ============================================
'  CARTOES - Funcoes auxiliares
' ============================================

'Extrai o nome do cartao (primeiro item) da nota
'Formato do item: "Nome: Cartao da esposa"
'Retorna apenas o valor apos ":"
Private Sub GetCardNameFromNote(note As clsNoteEntry, passphrase As String, needsDecrypt As Boolean) As String
	Try
		Dim itemsJson As String
		If needsDecrypt And passphrase <> "" Then
			itemsJson = note.GetDecryptedItems(passphrase)
		Else
			itemsJson = note.Items
		End If

		If itemsJson = "" Or itemsJson = "[]" Then Return ModLang.T("new_card")

		Dim parser As JSONParser
		parser.Initialize(itemsJson)
		Dim items As List = parser.NextArray

		If items.Size > 0 Then
			Dim firstItem As Map = items.Get(0)
			Dim text As String = firstItem.GetDefault("text", "")
			'Remove o prefixo "Nome: " se existir
			If text.Contains(":") Then
				Dim parts() As String = Regex.Split(":", text)
				If parts.Length > 1 Then
					text = parts(1).Trim
				End If
			End If
			If text.Length > 0 Then Return text
		End If
	Catch
		Log("GetCardNameFromNote error: " & LastException.Message)
	End Try

	Return ModLang.T("new_card")
End Sub

'Retorna nome de exibicao do grupo (traduzido para grupos de sistema)
Private Sub GetGroupDisplayName(g As clsNoteGroup) As String
	If g.IsSystem Then
		If g.Id = ModNotes.GetCardsGroupId Then
			Return ModLang.T("cards")
		End If
	End If
	Return g.Name
End Sub
