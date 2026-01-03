B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
'PagePasswordEdit.bas - Adicionar/Editar Senha
'LockZero - Formulario para criar ou editar entrada de senha

Sub Class_Globals
	Public Root As B4XView  'Public para transicoes
	Private xui As XUI

	'Parametros
	Private CurrentGroupId As String
	Private CurrentEntryId As String
	Private IsEditMode As Boolean

	'UI
	Private btnSave As Button
	Private btnCancel As Button

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

	Private IsPasswordVisible As Boolean = False

	'Indicador de forca da senha (REMOVIDO v1.0 - reimplementar em v1.x)
	'Private pnlStrength As Panel
	'Private pnlStrengthBar As Panel
	'Private lblStrengthText As Label
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

	'Reseta scroll para o topo
	svForm.ScrollPosition = 0

	IsEditMode = (CurrentEntryId <> "")

	'Define titulo na ActionBar
	If IsEditMode Then
		CallSub2(Main, "SetPageTitle", ModLang.T("edit"))
		LoadEntry
	Else
		CallSub2(Main, "SetPageTitle", ModLang.T("new_password"))
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

	'Botao cancelar (esquerda)
	btnCancel.Initialize("btnCancel")
	btnCancel.Text = ModLang.T("cancel")
	btnCancel.TextSize = Starter.FONT_BUTTON
	Root.AddView(btnCancel, 10dip, height - 70dip, 90dip, 48dip)  'Starter.HEIGHT_BUTTON

	'Botao salvar (direita)
	btnSave.Initialize("btnSave")
	btnSave.Text = ModLang.T("save")
	btnSave.TextSize = Starter.FONT_BUTTON
	Root.AddView(btnSave, width - 100dip, height - 70dip, 90dip, 48dip)  'Starter.HEIGHT_BUTTON

	'Formulario (tela inteira)
	svForm.Initialize(0)
	Root.AddView(svForm, 0, 0, width, height - 80dip)

	pnlForm = svForm.Panel
	pnlForm.Color = Colors.Transparent

	'Coloca botoes na frente
	btnCancel.BringToFront
	btnSave.BringToFront

	Dim y As Int = 20dip
	Dim fieldWidth As Int = width - 40dip
	Dim fieldHeight As Int = 48dip  'Starter.HEIGHT_INPUT
	Dim gap As Int = 20dip

	'Nome
	Dim lblName As Label = CreateFieldLabel(ModLang.T("site_name"))
	pnlForm.AddView(lblName, 20dip, y, fieldWidth, 20dip)
	y = y + 22dip

	edtName.Initialize("edtName")
	edtName.Hint = ModLang.T("site_name_hint")
	edtName.SingleLine = True
	edtName.InputType = Bit.Or(1, 8192) 'TEXT + CAP_WORDS
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
	edtUsername.Hint = ModLang.T("username_hint")
	edtUsername.SingleLine = True
	pnlForm.AddView(edtUsername, 20dip, y, fieldWidth, fieldHeight)
	y = y + fieldHeight + gap

	'Senha
	Dim lblPass As Label = CreateFieldLabel(ModLang.T("password"))
	pnlForm.AddView(lblPass, 20dip, y, fieldWidth, 20dip)
	y = y + 22dip

	edtPassword.Initialize("edtPassword")
	edtPassword.Hint = ModLang.T("password_hint")
	edtPassword.SingleLine = True
	edtPassword.InputType = Bit.Or(edtPassword.INPUT_TYPE_TEXT, 128) 'Password
	pnlForm.AddView(edtPassword, 20dip, y, fieldWidth - 75dip, fieldHeight)

	btnShowPassword.Initialize("btnShowPassword")
	btnShowPassword.Text = ModLang.T("view")
	btnShowPassword.TextSize = Starter.FONT_CAPTION
	pnlForm.AddView(btnShowPassword, width - 85dip, y, 65dip, fieldHeight)
	y = y + fieldHeight + 12dip

	'Indicador de forca da senha (REMOVIDO v1.0 - reimplementar em v1.x)
	'pnlStrength.Initialize("")
	'pnlStrength.Color = Colors.Transparent
	'pnlForm.AddView(pnlStrength, 20dip, y, fieldWidth, 24dip)
	'Dim pnlBarBg As Panel
	'pnlBarBg.Initialize("")
	'pnlBarBg.Color = Colors.ARGB(60, 255, 255, 255)
	'pnlStrength.AddView(pnlBarBg, 0, 4dip, fieldWidth - 100dip, 16dip)
	'pnlStrengthBar.Initialize("")
	'pnlStrengthBar.Color = Colors.Gray
	'pnlStrength.AddView(pnlStrengthBar, 0, 4dip, 0, 16dip)
	'lblStrengthText.Initialize("")
	'lblStrengthText.Text = ""
	'lblStrengthText.TextSize = Starter.FONT_CAPTION
	'lblStrengthText.TextColor = Colors.Gray
	'lblStrengthText.Gravity = Gravity.RIGHT
	'pnlStrength.AddView(lblStrengthText, fieldWidth - 95dip, 0, 95dip, 24dip)
	'y = y + 24dip + 12dip

	'Notas
	Dim lblNotes As Label = CreateFieldLabel(ModLang.T("note"))
	pnlForm.AddView(lblNotes, 20dip, y, fieldWidth, 20dip)
	y = y + 22dip

	edtNotes.Initialize("edtNotes")
	edtNotes.Hint = ModLang.T("notes_hint")
	edtNotes.SingleLine = False
	pnlForm.AddView(edtNotes, 20dip, y, fieldWidth, 100dip)
	y = y + 100dip + gap

	'Favorito
	chkFavorite.Initialize("chkFavorite")
	chkFavorite.Text = ModLang.T("favorite")
	chkFavorite.TextColor = ModTheme.TextPrimary
	pnlForm.AddView(chkFavorite, 20dip, y, fieldWidth, 40dip)
	y = y + 60dip

	'Padding extra para scroll com teclado aberto
	pnlForm.Height = y + 300dip
End Sub

Private Sub CreateFieldLabel(text As String) As Label
	Dim lbl As Label
	lbl.Initialize("")
	lbl.Text = text
	lbl.TextSize = Starter.FONT_LABEL
	lbl.TextColor = Colors.ARGB(180, 255, 255, 255)
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

	'Indicador de forca (REMOVIDO v1.0)
	'UpdateStrengthIndicator(edtPassword.Text)
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

Private Sub btnSave_Click
	ModSession.Touch
	SaveEntry
End Sub

Private Sub btnCancel_Click
	B4XPages.ClosePage(Me)
End Sub

' ============================================
'  AJUSTE DE TECLADO - Scroll para campo focado
' ============================================

Private Sub edtName_FocusChanged(HasFocus As Boolean)
	If HasFocus Then ScrollToView(edtName)
End Sub

Private Sub edtUrl_FocusChanged(HasFocus As Boolean)
	If HasFocus Then ScrollToView(edtUrl)
End Sub

Private Sub edtUsername_FocusChanged(HasFocus As Boolean)
	If HasFocus Then ScrollToView(edtUsername)
End Sub

Private Sub edtPassword_FocusChanged(HasFocus As Boolean)
	If HasFocus Then ScrollToView(edtPassword)
End Sub

Private Sub edtNotes_FocusChanged(HasFocus As Boolean)
	If HasFocus Then ScrollToView(edtNotes)
End Sub

Private Sub ScrollToView(v As View)
	'Calcula posicao do campo no painel
	Dim targetY As Int = v.Top - 50dip 'Um pouco acima do campo
	If targetY < 0 Then targetY = 0

	'Anima o scroll ate o campo
	svForm.ScrollPosition = targetY
End Sub

Private Sub btnShowPassword_Click
	IsPasswordVisible = Not(IsPasswordVisible)
	If IsPasswordVisible Then
		edtPassword.InputType = edtPassword.INPUT_TYPE_TEXT
		btnShowPassword.Text = ModLang.T("hide")
		btnShowPassword.TextColor = Colors.White
	Else
		edtPassword.InputType = Bit.Or(edtPassword.INPUT_TYPE_TEXT, 128)
		btnShowPassword.Text = ModLang.T("view")
		btnShowPassword.TextColor = Colors.ARGB(200, 255, 255, 255)
	End If
End Sub

'Indicador de forca (REMOVIDO v1.0 - reimplementar em v1.x)
'Private Sub edtPassword_TextChanged(Old As String, New As String)
'	UpdateStrengthIndicator(New)
'End Sub

'Private Sub UpdateStrengthIndicator(password As String)
'	If password.Length = 0 Then
'		pnlStrengthBar.Width = 0
'		lblStrengthText.Text = ""
'		Return
'	End If
'	Dim strength As Int = ModSecurity.CalculatePasswordStrength(password)
'	Dim strengthColor As Int = ModSecurity.GetStrengthColor(strength)
'	Dim strengthText As String = ModSecurity.GetStrengthText(strength)
'	Dim maxBarWidth As Int = pnlStrength.Width - 100dip
'	Dim barWidth As Int = maxBarWidth * (strength + 1) / 4
'	pnlStrengthBar.Color = strengthColor
'	pnlStrengthBar.Width = barWidth
'	lblStrengthText.Text = strengthText
'	lblStrengthText.TextColor = strengthColor
'End Sub

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

	'Verifica limite de senhas para novas entradas
	If IsEditMode = False Then
		If ModPasswords.CanAddPassword = False Then
			ToastMessageShow(ModLang.T("limit_passwords_free"), True)
			Return
		End If
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
'  TEMA
' ============================================

Private Sub ApplyTheme
	Root.Color = ModTheme.HomeBg
	svForm.Color = ModTheme.HomeBg
	pnlForm.Color = ModTheme.HomeBg

	btnSave.Color = ModTheme.HomeIconBg
	btnSave.TextColor = Colors.White

	'Campos com fundo escuro e borda sutil
	Dim cd As ColorDrawable
	cd.Initialize2(ModTheme.HomeHeaderBg, 8dip, 1dip, Colors.ARGB(80, 255, 255, 255))

	edtName.Background = cd
	edtName.TextColor = Colors.White
	edtName.HintColor = Colors.ARGB(120, 255, 255, 255)

	edtUrl.Background = cd
	edtUrl.TextColor = Colors.White
	edtUrl.HintColor = Colors.ARGB(120, 255, 255, 255)

	edtUsername.Background = cd
	edtUsername.TextColor = Colors.White
	edtUsername.HintColor = Colors.ARGB(120, 255, 255, 255)

	edtPassword.Background = cd
	edtPassword.TextColor = Colors.White
	edtPassword.HintColor = Colors.ARGB(120, 255, 255, 255)

	edtNotes.Background = cd
	edtNotes.TextColor = Colors.White
	edtNotes.HintColor = Colors.ARGB(120, 255, 255, 255)

	btnShowPassword.Color = ModTheme.HomeIconBg
	btnShowPassword.TextColor = Colors.White

	btnCancel.Color = ModTheme.HomeHeaderBg
	btnCancel.TextColor = Colors.White

	chkFavorite.TextColor = Colors.White
End Sub
