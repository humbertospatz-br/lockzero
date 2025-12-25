B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
'PagePasswordEdit.bas - Adicionar/Editar Senha
'LockZero - Formulario para criar ou editar entrada de senha

Sub Class_Globals
	Private Root As B4XView
	Private xui As XUI

	'Parametros
	Private CurrentGroupId As String
	Private CurrentEntryId As String
	Private IsEditMode As Boolean

	'UI
	Private pnlHeader As B4XView
	Private lblTitle As B4XView
	Private btnBack As Button
	Private btnSave As Button

	Private svForm As ScrollView
	Private pnlForm As B4XView

	'Campos
	Private edtName As EditText
	Private edtUrl As EditText
	Private edtUsername As EditText
	Private edtPassword As EditText
	Private edtNotes As EditText
	Private chkFavorite As CheckBox
	Private btnShowPassword As Button
	Private btnGenerate As Button

	Private IsPasswordVisible As Boolean = False
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

	IsEditMode = (CurrentEntryId <> "")

	If IsEditMode Then
		lblTitle.Text = ModLang.T("edit_password")
		LoadEntry
	Else
		lblTitle.Text = ModLang.T("add_password")
		ClearForm
	End If
End Sub

'Recebe parametros da pagina anterior
Public Sub SetParams(params As Map)
	If params = Null Then Return
	CurrentGroupId = params.GetDefault("groupId", "")
	CurrentEntryId = params.GetDefault("entryId", "")
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

	lblTitle = CreateLabel("", 18, True)
	lblTitle.SetTextAlignment("CENTER", "LEFT")
	pnlHeader.AddView(lblTitle, 56dip, 0, width - 112dip, 56dip)

	btnSave.Initialize("btnSave")
	btnSave.Text = ModLang.T("save")
	pnlHeader.AddView(btnSave, width - 80dip, 8dip, 70dip, 40dip)

	'Formulario
	svForm.Initialize(0)
	Root.AddView(svForm, 0, 56dip, width, height - 56dip)

	pnlForm = svForm.Panel
	pnlForm.Color = Colors.Transparent

	Dim y As Int = 20dip
	Dim fieldWidth As Int = width - 40dip
	Dim fieldHeight As Int = 50dip
	Dim gap As Int = 20dip

	'Nome
	Dim lblName As Label = CreateFieldLabel(ModLang.T("site_name"))
	pnlForm.AddView(lblName, 20dip, y, fieldWidth, 20dip)
	y = y + 22dip

	edtName.Initialize("edtName")
	edtName.Hint = "Ex: Google, Facebook..."
	edtName.SingleLine = True
	pnlForm.AddView(edtName, 20dip, y, fieldWidth, fieldHeight)
	y = y + fieldHeight + gap

	'URL
	Dim lblUrl As Label = CreateFieldLabel(ModLang.T("url"))
	pnlForm.AddView(lblUrl, 20dip, y, fieldWidth, 20dip)
	y = y + 22dip

	edtUrl.Initialize("edtUrl")
	edtUrl.Hint = "https://..."
	edtUrl.SingleLine = True
	edtUrl.InputType = Bit.Or(edtUrl.INPUT_TYPE_TEXT, 16) 'URL
	pnlForm.AddView(edtUrl, 20dip, y, fieldWidth, fieldHeight)
	y = y + fieldHeight + gap

	'Username
	Dim lblUser As Label = CreateFieldLabel(ModLang.T("username"))
	pnlForm.AddView(lblUser, 20dip, y, fieldWidth, 20dip)
	y = y + 22dip

	edtUsername.Initialize("edtUsername")
	edtUsername.Hint = "Email ou usuario"
	edtUsername.SingleLine = True
	pnlForm.AddView(edtUsername, 20dip, y, fieldWidth, fieldHeight)
	y = y + fieldHeight + gap

	'Senha
	Dim lblPass As Label = CreateFieldLabel(ModLang.T("password"))
	pnlForm.AddView(lblPass, 20dip, y, fieldWidth, 20dip)
	y = y + 22dip

	edtPassword.Initialize("edtPassword")
	edtPassword.Hint = "Senha"
	edtPassword.SingleLine = True
	edtPassword.InputType = Bit.Or(edtPassword.INPUT_TYPE_TEXT, 128) 'Password
	pnlForm.AddView(edtPassword, 20dip, y, fieldWidth - 100dip, fieldHeight)

	btnShowPassword.Initialize("btnShowPassword")
	btnShowPassword.Text = Starter.ICON_EYE_OPEN 'Olho aberto = senha oculta
	btnShowPassword.TextSize = 18
	pnlForm.AddView(btnShowPassword, width - 115dip, y, 45dip, fieldHeight)

	btnGenerate.Initialize("btnGenerate")
	btnGenerate.Text = "G"
	pnlForm.AddView(btnGenerate, width - 65dip, y, 45dip, fieldHeight)
	y = y + fieldHeight + gap

	'Notas
	Dim lblNotes As Label = CreateFieldLabel(ModLang.T("note"))
	pnlForm.AddView(lblNotes, 20dip, y, fieldWidth, 20dip)
	y = y + 22dip

	edtNotes.Initialize("edtNotes")
	edtNotes.Hint = "Observacoes (opcional)"
	edtNotes.SingleLine = False
	pnlForm.AddView(edtNotes, 20dip, y, fieldWidth, 100dip)
	y = y + 100dip + gap

	'Favorito
	chkFavorite.Initialize("chkFavorite")
	chkFavorite.Text = "Favorito"
	chkFavorite.TextColor = ModTheme.TextPrimary
	pnlForm.AddView(chkFavorite, 20dip, y, fieldWidth, 40dip)
	y = y + 60dip

	pnlForm.Height = y + 50dip
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

Private Sub CreateFieldLabel(text As String) As Label
	Dim lbl As Label
	lbl.Initialize("")
	lbl.Text = text
	lbl.TextSize = 13
	lbl.TextColor = ModTheme.TextSecondary
	Return lbl
End Sub

' ============================================
'  CARREGAR/LIMPAR
' ============================================

Private Sub LoadEntry
	Dim e As clsPasswordEntry = ModPasswords.GetEntryById(CurrentEntryId)
	If e.IsInitialized = False Then Return

	edtName.Text = e.Name
	edtUrl.Text = e.Url
	edtUsername.Text = ModPasswords.DecryptValue(e.Username)
	edtPassword.Text = ModPasswords.DecryptValue(e.PasswordEnc)
	edtNotes.Text = ModPasswords.DecryptValue(e.Notes)
	chkFavorite.Checked = e.IsFavorite
End Sub

Private Sub ClearForm
	edtName.Text = ""
	edtUrl.Text = ""
	edtUsername.Text = ""
	edtPassword.Text = ""
	edtNotes.Text = ""
	chkFavorite.Checked = False
End Sub

' ============================================
'  EVENTOS
' ============================================

Private Sub btnBack_Click
	B4XPages.ClosePage(Me)
End Sub

Private Sub btnSave_Click
	ModSession.Touch
	SaveEntry
End Sub

Private Sub btnShowPassword_Click
	IsPasswordVisible = Not(IsPasswordVisible)
	If IsPasswordVisible Then
		edtPassword.InputType = edtPassword.INPUT_TYPE_TEXT
		btnShowPassword.Text = Starter.ICON_EYE_CLOSED 'Pontos = senha visivel
	Else
		edtPassword.InputType = Bit.Or(edtPassword.INPUT_TYPE_TEXT, 128)
		btnShowPassword.Text = Starter.ICON_EYE_OPEN 'Olho = senha oculta
	End If
End Sub

Private Sub btnGenerate_Click
	'Gera senha aleatoria
	Dim password As String = GeneratePassword(16)
	edtPassword.Text = password

	'Mostra a senha gerada
	If IsPasswordVisible = False Then
		btnShowPassword_Click
	End If
End Sub

' ============================================
'  SALVAR
' ============================================

Private Sub SaveEntry
	If ModSession.IsSessionActive = False Then
		ToastMessageShow(ModLang.T("session_expired"), True)
		Return
	End If

	'Validacao
	Dim name As String = edtName.Text.Trim
	Dim password As String = edtPassword.Text.Trim

	If name = "" And edtUrl.Text.Trim = "" Then
		ToastMessageShow(ModLang.T("error_empty_field"), True)
		Return
	End If

	If password = "" Then
		ToastMessageShow(ModLang.T("error_empty_field") & " (senha)", True)
		Return
	End If

	'Carrega ou cria entrada
	Dim e As clsPasswordEntry
	If IsEditMode Then
		e = ModPasswords.GetEntryById(CurrentEntryId)
	Else
		e.Initialize
		e.GroupId = CurrentGroupId
	End If

	'Preenche dados
	e.Name = name
	e.Url = edtUrl.Text.Trim
	e.Username = ModPasswords.EncryptValue(edtUsername.Text.Trim)
	e.PasswordEnc = ModPasswords.EncryptValue(password)
	e.Notes = ModPasswords.EncryptValue(edtNotes.Text.Trim)
	e.IsFavorite = chkFavorite.Checked

	'Salva
	ModPasswords.SaveEntry(e)

	ToastMessageShow(ModLang.T("success"), False)
	B4XPages.ClosePage(Me)
End Sub

' ============================================
'  GERADOR DE SENHA
' ============================================

Private Sub GeneratePassword(length As Int) As String
	Dim chars As String = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&*"
	Dim sb As StringBuilder
	sb.Initialize

	For i = 1 To length
		Dim idx As Int = Rnd(0, chars.Length)
		sb.Append(chars.CharAt(idx))
	Next

	Return sb.ToString
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

	btnSave.Color = ModTheme.Primary
	btnSave.TextColor = Colors.White

	'Campos
	Dim inputDrawable As ColorDrawable = ModTheme.GetInputDrawable
	edtName.Background = inputDrawable
	edtName.TextColor = ModTheme.InputText
	edtName.HintColor = ModTheme.InputHint

	edtUrl.Background = inputDrawable
	edtUrl.TextColor = ModTheme.InputText
	edtUrl.HintColor = ModTheme.InputHint

	edtUsername.Background = inputDrawable
	edtUsername.TextColor = ModTheme.InputText
	edtUsername.HintColor = ModTheme.InputHint

	edtPassword.Background = inputDrawable
	edtPassword.TextColor = ModTheme.InputText
	edtPassword.HintColor = ModTheme.InputHint

	edtNotes.Background = inputDrawable
	edtNotes.TextColor = ModTheme.InputText
	edtNotes.HintColor = ModTheme.InputHint

	btnShowPassword.Color = ModTheme.ButtonSecondary
	btnShowPassword.TextColor = ModTheme.TextPrimary

	btnGenerate.Color = ModTheme.Success
	btnGenerate.TextColor = Colors.White
End Sub
