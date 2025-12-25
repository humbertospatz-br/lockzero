B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
'PageNoteEdit.bas - Criar/Editar Nota Segura
'LockZero - Lock and ZERO worries

Sub Class_Globals
	Private Root As B4XView
	Private xui As XUI

	'UI
	Private pnlHeader As B4XView
	Private lblTitle As B4XView
	Private btnBack As Button
	Private btnSave As Button
	Private btnDelete As Button

	Private svContent As ScrollView
	Private pnlContent As B4XView

	Private edtTitle As EditText
	Private edtContent As EditText
	Private chkFavorite As CheckBox

	'Estado
	Private CurrentNoteId As String = ""
	Private CurrentGroupId As String = ""
	Private IsNewNote As Boolean = True
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
End Sub

Public Sub SetParams(params As Map)
	If params = Null Then Return

	CurrentNoteId = params.GetDefault("noteId", "")
	CurrentGroupId = params.GetDefault("groupId", "")

	IsNewNote = (CurrentNoteId.Length = 0)

	If IsNewNote Then
		lblTitle.Text = "Nova Nota"
		btnDelete.Visible = False
		edtTitle.Text = ""
		edtContent.Text = ""
		chkFavorite.Checked = False
	Else
		lblTitle.Text = "Editar Nota"
		btnDelete.Visible = True
		LoadNote
	End If
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

	lblTitle = CreateLabel("Nova Nota", 18, True)
	lblTitle.SetTextAlignment("CENTER", "LEFT")
	pnlHeader.AddView(lblTitle, 56dip, 0, width - 160dip, 56dip)

	btnDelete.Initialize("btnDelete")
	btnDelete.Text = "X"
	btnDelete.Visible = False
	pnlHeader.AddView(btnDelete, width - 96dip, 8dip, 40dip, 40dip)

	btnSave.Initialize("btnSave")
	btnSave.Text = Chr(10003) '"✓"
	pnlHeader.AddView(btnSave, width - 48dip, 8dip, 40dip, 40dip)

	'Conteudo
	svContent.Initialize(0)
	Root.AddView(svContent, 0, 56dip, width, height - 56dip)

	pnlContent = svContent.Panel
	pnlContent.Color = Colors.Transparent

	Dim y As Int = 20dip
	Dim margin As Int = 16dip
	Dim fieldWidth As Int = width - (margin * 2)

	'Titulo
	Dim lblTitleField As Label
	lblTitleField.Initialize("")
	lblTitleField.Text = "Titulo"
	lblTitleField.TextSize = 14
	lblTitleField.TextColor = ModTheme.TextSecondary
	pnlContent.AddView(lblTitleField, margin, y, fieldWidth, 20dip)
	y = y + 22dip

	edtTitle.Initialize("edtTitle")
	edtTitle.Hint = "Digite o titulo da nota"
	edtTitle.SingleLine = True
	edtTitle.TextSize = 16
	pnlContent.AddView(edtTitle, margin, y, fieldWidth, 50dip)
	y = y + 60dip

	'Conteudo
	Dim lblContentField As Label
	lblContentField.Initialize("")
	lblContentField.Text = "Conteudo"
	lblContentField.TextSize = 14
	lblContentField.TextColor = ModTheme.TextSecondary
	pnlContent.AddView(lblContentField, margin, y, fieldWidth, 20dip)
	y = y + 22dip

	edtContent.Initialize("edtContent")
	edtContent.Hint = "Digite o conteudo da nota..."
	edtContent.SingleLine = False
	edtContent.TextSize = 15
	edtContent.Gravity = Gravity.TOP
	pnlContent.AddView(edtContent, margin, y, fieldWidth, 250dip)
	y = y + 260dip

	'Favorito
	chkFavorite.Initialize("chkFavorite")
	chkFavorite.Text = "Marcar como favorito"
	chkFavorite.TextSize = 15
	pnlContent.AddView(chkFavorite, margin, y, fieldWidth, 40dip)
	y = y + 60dip

	'Info
	Dim lblInfo As Label
	lblInfo.Initialize("")
	lblInfo.Text = "O conteudo desta nota sera criptografado com sua frase-senha."
	lblInfo.TextSize = 12
	lblInfo.TextColor = ModTheme.TextMuted
	lblInfo.Gravity = Gravity.CENTER_HORIZONTAL
	pnlContent.AddView(lblInfo, margin, y, fieldWidth, 40dip)
	y = y + 60dip

	pnlContent.Height = y + 50dip
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
'  CARREGAR NOTA
' ============================================

Private Sub LoadNote
	Dim note As clsNoteEntry = ModNotes.GetNoteById(CurrentNoteId)
	If note = Null Then
		ToastMessageShow("Nota nao encontrada", True)
		B4XPages.ClosePage(Me)
		Return
	End If

	Dim passPhrase As String = ModSession.GetPassphrase
	edtTitle.Text = note.GetDecryptedTitle(passPhrase)
	edtContent.Text = note.GetDecryptedContent(passPhrase)
	chkFavorite.Checked = note.IsFavorite
End Sub

' ============================================
'  SALVAR NOTA
' ============================================

Private Sub btnSave_Click
	ModSession.Touch

	Dim title As String = edtTitle.Text.Trim
	Dim content As String = edtContent.Text.Trim

	'Validacoes
	If title.Length < 1 Then
		ToastMessageShow("Digite um titulo", True)
		Return
	End If

	Dim passPhrase As String = ModSession.GetPassphrase

	Dim note As clsNoteEntry
	If IsNewNote Then
		note.Initialize
		note.GroupId = CurrentGroupId
	Else
		note = ModNotes.GetNoteById(CurrentNoteId)
		If note = Null Then
			ToastMessageShow("Erro ao carregar nota", True)
			Return
		End If
	End If

	'Criptografa e salva
	note.EncryptTitle(passPhrase, title)
	note.EncryptContent(passPhrase, content)
	note.IsFavorite = chkFavorite.Checked

	ModNotes.SaveNote(note)

	ToastMessageShow("Nota salva", False)
	B4XPages.ClosePage(Me)
End Sub

' ============================================
'  EXCLUIR NOTA
' ============================================

Private Sub btnDelete_Click
	ModSession.Touch

	Wait For (xui.Msgbox2Async("Deseja excluir esta nota?", "Confirmar", "Excluir", "", "Cancelar", Null)) Msgbox_Result(Result As Int)

	If Result = xui.DialogResponse_Positive Then
		ModNotes.DeleteNote(CurrentNoteId)
		ToastMessageShow("Nota excluida", False)
		B4XPages.ClosePage(Me)
	End If
End Sub

' ============================================
'  EVENTOS
' ============================================

Private Sub btnBack_Click
	B4XPages.ClosePage(Me)
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

	btnSave.Color = ModTheme.Success
	btnSave.TextColor = Colors.White

	btnDelete.Color = ModTheme.Danger
	btnDelete.TextColor = Colors.White

	edtTitle.TextColor = ModTheme.InputText
	edtTitle.HintColor = ModTheme.InputHint

	edtContent.TextColor = ModTheme.InputText
	edtContent.HintColor = ModTheme.InputHint

	chkFavorite.TextColor = ModTheme.TextPrimary
End Sub
