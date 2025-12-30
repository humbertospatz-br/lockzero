B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
'PageNotesList.bas - Lista de Notas de um Grupo
'LockZero - Lock and ZERO worries

Sub Class_Globals
	Private Root As B4XView
	Private xui As XUI

	'UI
	Private lblAdd As Label
	Private btnBack As Button

	Private svNotes As ScrollView
	Private pnlNotes As B4XView

	Private lblEmpty As Label
	Private lblTitle As Label

	'Estado
	Private CurrentGroupId As String = ""
	Private IsNoteGroup As Boolean = False  'True = NoteGroup, False = PasswordGroup (legado)
	Private CurrentGroup As clsNoteGroup    'Referencia ao grupo atual
	Private GroupPassphrase As String = ""  'Passphrase para grupos seguros
	Private IsNavigating As Boolean = False  'Flag para evitar navegacao dupla
End Sub

Public Sub Initialize

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
		lblTitle.Text = ModLang.T("notes") & " → " & CurrentGroup.Name
		CallSub2(Main, "SetPageTitle", CurrentGroup.Name)
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
	pnlHeader.AddView(lblTitle, 48dip, 0, width - 110dip, headerH)

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
	'Limpa lista
	pnlNotes.RemoveAllViews

	Dim notes As List = ModNotes.GetNotesByGroup(CurrentGroupId)

	If notes.Size = 0 Then
		lblEmpty.Visible = True
		pnlNotes.Height = 0
		Return
	End If

	lblEmpty.Visible = False

	Dim width As Int = Root.Width
	Dim y As Int = 10dip
	Dim cardHeight As Int = 80dip
	Dim margin As Int = 16dip

	For i = 0 To notes.Size - 1
		Dim note As clsNoteEntry = notes.Get(i)
		Dim pnlCard As Panel = CreateNoteCard(note, width - (margin * 2))
		pnlCard.Tag = note.Id
		pnlNotes.AddView(pnlCard, margin, y, width - (margin * 2), cardHeight)
		y = y + cardHeight + 10dip
	Next

	pnlNotes.Height = y + 20dip
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

	'Icone do tipo de nota (text/list)
	Dim lblTypeIcon As Label
	lblTypeIcon.Initialize("")
	If note.IsListNote Then
		lblTypeIcon.Text = Chr(0x2611)  'Checkbox marcado ☑
	Else
		lblTypeIcon.Text = Chr(0xD83D) & Chr(0xDCDD)  'Nota 📝 (surrogate pair)
	End If
	lblTypeIcon.TextSize = 20
	lblTypeIcon.Gravity = Gravity.CENTER
	pnl.AddView(lblTypeIcon, 8dip, 25dip, 30dip, 30dip)

	'Titulo
	Dim title As String
	If needsDecrypt Then
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

	'Preview baseado no tipo de nota
	Dim preview As String
	If note.IsListNote Then
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

	Dim pg As PageNoteEdit = B4XPages.GetPage("PageNoteEdit")
	pg.SetParams(params)
	B4XPages.ShowPage("PageNoteEdit")
End Sub

' ============================================
'  EVENTOS
' ============================================

Private Sub btnBack_Click
	B4XPages.ClosePage(Me)
End Sub

Private Sub lblAdd_Click
	Log("lblAdd_Click - IsNavigating=" & IsNavigating)
	'Evita navegacao dupla
	If IsNavigating Then Return

	'Touch na sessao se grupo seguro
	If IsNoteGroup And CurrentGroup <> Null And CurrentGroup.IsSecure Then
		ModSession.Touch
	End If

	'Dialog para escolher tipo de nota
	Wait For (xui.Msgbox2Async(ModLang.T("note_type_choose"), ModLang.T("new_note"), ModLang.T("note_type_text"), ModLang.T("cancel"), ModLang.T("note_type_list"), Null)) Msgbox_Result(Result As Int)

	Dim noteType As String = ""
	If Result = xui.DialogResponse_Positive Then
		noteType = "text"
	Else If Result = xui.DialogResponse_Negative Then
		noteType = "list"
	Else
		Return  'Cancelou
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
