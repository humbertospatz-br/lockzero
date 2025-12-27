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
	Private btnAdd As Button

	Private svNotes As ScrollView
	Private pnlNotes As B4XView

	Private lblEmpty As Label

	'Estado
	Private CurrentGroupId As String = ""
End Sub

Public Sub Initialize

End Sub

Private Sub B4XPage_Created(Root1 As B4XView)
	Root = Root1
	CreateUI
	ApplyTheme
End Sub

Private Sub B4XPage_Appear
	'Define titulo na ActionBar
	CallSub2(Main, "SetPageTitle", ModLang.T("notes"))

	ModSession.Touch
	LoadNotes
End Sub

'Recebe parametros da pagina anterior
Public Sub SetParams(params As Map)
	If params = Null Then Return
	CurrentGroupId = params.GetDefault("groupId", "")
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

	Dim lblTitle As Label
	lblTitle.Initialize("")
	lblTitle.Text = "NOTAS"
	lblTitle.TextSize = 14
	lblTitle.TextColor = Colors.ARGB(200, 255, 255, 255)
	lblTitle.Typeface = Typeface.DEFAULT_BOLD
	lblTitle.Gravity = Gravity.CENTER_VERTICAL
	pnlHeader.AddView(lblTitle, 16dip, 0, width - 80dip, headerH)

	'Botao adicionar no header (circular)
	btnAdd.Initialize("btnAdd")
	btnAdd.Text = "+"
	btnAdd.TextSize = 22
	btnAdd.Color = ModTheme.HomeIconBg
	btnAdd.TextColor = Colors.White
	btnAdd.Gravity = Gravity.CENTER
	pnlHeader.AddView(btnAdd, width - 54dip, 10dip, 36dip, 36dip)

	'Lista de notas (sem separador, fundo continuo)
	svNotes.Initialize(0)
	svNotes.Color = ModTheme.HomeBg
	Root.AddView(svNotes, 0, headerH, width, height - headerH)

	pnlNotes = svNotes.Panel
	pnlNotes.Color = ModTheme.HomeBg

	'Label vazio
	lblEmpty.Initialize("")
	lblEmpty.Text = "Nenhuma nota neste grupo"
	lblEmpty.TextSize = 16
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

	'Titulo
	Dim title As String = note.GetDecryptedTitle(ModSession.GetPassphrase)
	If title.Length > 30 Then title = title.SubString2(0, 30) & "..."

	Dim lblNoteTitle As Label
	lblNoteTitle.Initialize("")
	lblNoteTitle.Text = title
	lblNoteTitle.TextSize = 16
	lblNoteTitle.TextColor = Colors.White
	lblNoteTitle.Typeface = Typeface.CreateNew(Typeface.DEFAULT, Typeface.STYLE_BOLD)
	pnl.AddView(lblNoteTitle, 12dip, 10dip, cardWidth - 60dip, 25dip)

	'Preview do conteudo
	Dim content As String = note.GetDecryptedContent(ModSession.GetPassphrase)
	If content.Length > 50 Then content = content.SubString2(0, 50) & "..."
	content = content.Replace(Chr(10), " ").Replace(Chr(13), " ")

	Dim lblPreview As Label
	lblPreview.Initialize("")
	lblPreview.Text = content
	lblPreview.TextSize = 13
	lblPreview.TextColor = Colors.ARGB(180, 255, 255, 255)
	pnl.AddView(lblPreview, 12dip, 38dip, cardWidth - 60dip, 30dip)

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
	Dim pnl As Panel = Sender
	Dim noteId As String = pnl.Tag
	OpenNote(noteId)
End Sub

Private Sub OpenNote(noteId As String)
	ModSession.Touch

	Dim note As clsNoteEntry = ModNotes.GetNoteById(noteId)
	If note = Null Then Return

	Dim pg As PageNoteEdit = B4XPages.GetPage("PageNoteEdit")
	pg.SetParams(CreateMap("noteId": noteId, "groupId": CurrentGroupId))
	B4XPages.ShowPage("PageNoteEdit")
End Sub

' ============================================
'  EVENTOS
' ============================================

Private Sub btnAdd_Click
	ModSession.Touch
	Dim pg As PageNoteEdit = B4XPages.GetPage("PageNoteEdit")
	pg.SetParams(CreateMap("noteId": "", "groupId": CurrentGroupId))
	B4XPages.ShowPage("PageNoteEdit")
End Sub

' ============================================
'  TEMA
' ============================================

Private Sub ApplyTheme
	Root.Color = ModTheme.HomeBg

	btnAdd.Color = ModTheme.HomeIconBg
	btnAdd.TextColor = Colors.White

	lblEmpty.TextColor = Colors.ARGB(150, 255, 255, 255)
End Sub
