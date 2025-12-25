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
	Private pnlHeader As B4XView
	Private lblTitle As B4XView
	Private btnBack As Button
	Private btnAdd As Button

	Private svNotes As ScrollView
	Private pnlNotes As B4XView

	Private lblEmpty As Label

	'Estado
	Private CurrentGroupId As String = ""
	Private CurrentGroupName As String = ""
End Sub

Public Sub Initialize

End Sub

Private Sub B4XPage_Created(Root1 As B4XView)
	Root = Root1
	CreateUI
	ApplyTheme
End Sub

Private Sub B4XPage_Appear
	ModSession.Touch
	LoadNotes
End Sub

'Recebe parametros da pagina anterior
Public Sub SetParams(params As Map)
	If params = Null Then Return
	CurrentGroupId = params.GetDefault("groupId", "")
	CurrentGroupName = params.GetDefault("groupName", "Notas")
End Sub

' ============================================
'  CRIAR UI
' ============================================

Private Sub CreateUI
	Dim width As Int = Root.Width
	Dim height As Int = Root.Height

	'Header
	pnlHeader = xui.CreatePanel("")
	Root.AddView(pnlHeader, 0, 0, width, 56dip)

	btnBack.Initialize("btnBack")
	btnBack.Text = "<"
	pnlHeader.AddView(btnBack, 8dip, 8dip, 40dip, 40dip)

	lblTitle = CreateLabel("Notas", 18, True)
	lblTitle.SetTextAlignment("CENTER", "LEFT")
	pnlHeader.AddView(lblTitle, 56dip, 0, width - 112dip, 56dip)

	btnAdd.Initialize("btnAdd")
	btnAdd.Text = "+"
	pnlHeader.AddView(btnAdd, width - 48dip, 8dip, 40dip, 40dip)

	'Lista de notas
	svNotes.Initialize(0)
	Root.AddView(svNotes, 0, 56dip, width, height - 56dip)

	pnlNotes = svNotes.Panel
	pnlNotes.Color = Colors.Transparent

	'Label vazio
	lblEmpty.Initialize("")
	lblEmpty.Text = "Nenhuma nota neste grupo"
	lblEmpty.TextSize = 16
	lblEmpty.Gravity = Gravity.CENTER
	lblEmpty.Visible = False
	Root.AddView(lblEmpty, 0, height / 2 - 20dip, width, 40dip)
End Sub

Private Sub CreateLabel(text As String, size As Float, bold As Boolean) As B4XView
	Dim lbl As Label
	lbl.Initialize("")
	lbl.Text = text
	lbl.TextSize = size
	lbl.Gravity = Gravity.CENTER
	If bold Then
		lbl.Typeface = Typeface.CreateNew(Typeface.DEFAULT, Typeface.STYLE_BOLD)
	End If
	Return lbl
End Sub

' ============================================
'  CARREGAR NOTAS
' ============================================

Private Sub LoadNotes
	lblTitle.Text = CurrentGroupName

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
		Dim pnlCard As Panel = CreateNoteCard(note, width - (margin * 2), cardHeight)
		pnlCard.Tag = note.Id
		pnlNotes.AddView(pnlCard, margin, y, width - (margin * 2), cardHeight)
		y = y + cardHeight + 10dip
	Next

	pnlNotes.Height = y + 20dip
End Sub

Private Sub CreateNoteCard(note As clsNoteEntry, cardWidth As Int, cardHeight As Int) As Panel
	Dim pnl As Panel
	pnl.Initialize("pnlNote")

	Dim xv As B4XView = pnl
	xv.SetColorAndBorder(ModTheme.CardBackground, 1dip, ModTheme.CardBorder, 8dip)

	'Titulo
	Dim title As String = note.GetDecryptedTitle(ModSession.GetPassphrase)
	If title.Length > 30 Then title = title.SubString2(0, 30) & "..."

	Dim lblNoteTitle As Label
	lblNoteTitle.Initialize("")
	lblNoteTitle.Text = title
	lblNoteTitle.TextSize = 16
	lblNoteTitle.TextColor = ModTheme.TextPrimary
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
	lblPreview.TextColor = ModTheme.TextSecondary
	pnl.AddView(lblPreview, 12dip, 38dip, cardWidth - 60dip, 30dip)

	'Favorito
	If note.IsFavorite Then
		Dim lblStar As Label
		lblStar.Initialize("")
		lblStar.Text = Chr(9733) '"★"
		lblStar.TextSize = 20
		lblStar.TextColor = ModTheme.Warning
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

Private Sub btnBack_Click
	B4XPages.ClosePage(Me)
End Sub

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
	Root.Color = ModTheme.Background

	pnlHeader.Color = ModTheme.Surface
	lblTitle.TextColor = ModTheme.TextPrimary

	btnBack.Color = ModTheme.ButtonSecondary
	btnBack.TextColor = ModTheme.TextPrimary

	btnAdd.Color = ModTheme.Primary
	btnAdd.TextColor = Colors.White

	lblEmpty.TextColor = ModTheme.TextMuted
End Sub
