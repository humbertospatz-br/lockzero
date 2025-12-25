B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=13.4
@EndOfDesignText@
'ActPasswordList.bas - Lista de Senhas do Grupo
'LockSeed - Exibe senhas com checkbox Ver para mostrar/ocultar

#Region  Activity Attributes
	#FullScreen: False
	#IncludeTitle: False
#End Region

Sub Process_Globals
	' Parametros recebidos de ActPasswordGroups
	Public GroupId As String = ""
	Public GroupName As String = ""
End Sub

Sub Globals
	' Header
	Private pnlHeader As Panel
	Private lblTitle As Label
	Private btnBack As Button

	' Timer da sessao
	Private pnlSession As Panel
	Private lblSessionTimer As Label
	Private tmrSession As Timer

	' Lista de senhas
	Private svPasswords As ScrollView

	' Dialog frase-senha
	Private pnlPassphraseDialog As Panel
	Private edtPassphrase As EditText
	Private btnPassphraseOk As Button
	Private btnPassphraseCancel As Button
	Private btnPassphraseShow As Button
	Private PassphraseVisible As Boolean = False

	' Dialog nova/editar senha
	Private pnlEntryDialog As Panel
	Private edtSite As EditText
	Private edtUsername As EditText
	Private edtPassword As EditText
	Private edtNotes As EditText
	Private btnEntrySave As Button
	Private btnEntryCancel As Button
	Private btnEntryShowPwd As Button
	Private EntryPwdVisible As Boolean = False

	' Estado
	Private EditingEntryId As String = ""
	Private DecryptedPasswords As Map ' Map de ID -> senha descriptografada
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.Color = ModTheme.GetBackgroundColor

	' Inicializa ModPasswords se necessario
	ModPasswords.Init

	DecryptedPasswords.Initialize

	CreateHeader
	CreateSessionPanel
	CreatePasswordList
	CreatePassphraseDialog
	CreateEntryDialog

	' Timer para atualizar sessao
	tmrSession.Initialize("tmrSession", 1000)
	tmrSession.Enabled = True

	LoadPasswords
	UpdateSessionDisplay
End Sub

Sub Activity_Resume
	tmrSession.Enabled = True  ' Reativa o timer
	LoadPasswords
	UpdateSessionDisplay
End Sub

Sub Activity_Pause(UserClosed As Boolean)
	tmrSession.Enabled = False
	' Limpa senhas descriptografadas da memoria
	DecryptedPasswords.Clear
End Sub

' ============================================
'  HEADER
' ============================================
Private Sub CreateHeader
	pnlHeader.Initialize("")
	pnlHeader.Color = ModTheme.GetHeaderColor
	Activity.AddView(pnlHeader, 0, 0, 100%x, 60dip)

	btnBack.Initialize("btnBack")
	btnBack.Text = Chr(0x2190)
	btnBack.TextSize = 24
	btnBack.Color = Colors.Transparent
	btnBack.TextColor = ModTheme.GetTitleTextColor
	pnlHeader.AddView(btnBack, 5dip, 5dip, 50dip, 50dip)

	lblTitle.Initialize("")
	lblTitle.Text = GroupName
	lblTitle.TextSize = 18
	lblTitle.TextColor = ModTheme.GetTitleTextColor
	lblTitle.Gravity = Gravity.CENTER_VERTICAL
	pnlHeader.AddView(lblTitle, 55dip, 15dip, 100%x - 120dip, 30dip)

	' Botao Adicionar - usando Label para evitar tema do sistema (copiado de ActWalletList)
	Dim lblAdd As Label
	lblAdd.Initialize("btnAdd")
	lblAdd.Text = "+"
	lblAdd.TextSize = 28
	lblAdd.Typeface = Typeface.DEFAULT_BOLD
	lblAdd.Gravity = Gravity.CENTER
	lblAdd.Color = ModTheme.GetPrimaryColor
	lblAdd.TextColor = Colors.White
	pnlHeader.AddView(lblAdd, 100%x - 52dip, 10dip, 40dip, 40dip)

	' Arredonda o label
	Dim xvAdd As B4XView = lblAdd
	xvAdd.SetColorAndBorder(ModTheme.GetPrimaryColor, 0, ModTheme.GetPrimaryColor, 20dip)
End Sub

' ============================================
'  PAINEL DA SESSAO (TIMER)
' ============================================
Private Sub CreateSessionPanel
	pnlSession.Initialize("")
	pnlSession.Color = ModTheme.GetPanelColor
	Activity.AddView(pnlSession, 0, 60dip, 100%x, 40dip)

	Dim xvSession As B4XView = pnlSession
	xvSession.SetColorAndBorder(ModTheme.GetPanelColor, 0, ModTheme.GetBorderColor, 0)

	lblSessionTimer.Initialize("")
	lblSessionTimer.TextSize = 13
	lblSessionTimer.TextColor = ModTheme.GetSecondaryTextColor
	lblSessionTimer.Gravity = Gravity.CENTER
	pnlSession.AddView(lblSessionTimer, 10dip, 8dip, 100%x - 20dip, 25dip)
End Sub

Private Sub UpdateSessionDisplay
	If ModPasswords.IsSessionValid Then
		Dim remaining As Int = ModPasswords.GetSessionRemainingSeconds
		Dim mins As Int = remaining / 60
		Dim secs As Int = remaining Mod 60
		lblSessionTimer.Text = ModLang.GetText("pwd_session_remaining") & ": " & _
			NumberFormat(mins, 1, 0) & ":" & NumberFormat2(secs, 2, 0, 0, False)
		lblSessionTimer.TextColor = ModTheme.GetPrimaryColor
	Else
		lblSessionTimer.Text = ModLang.GetText("pwd_session_expired")
		lblSessionTimer.TextColor = Colors.Red
		' Limpa senhas descriptografadas quando sessao expira
		DecryptedPasswords.Clear
		LoadPasswords
	End If
End Sub

Sub tmrSession_Tick
	UpdateSessionDisplay
End Sub

' ============================================
'  LISTA DE SENHAS
' ============================================
Private Sub CreatePasswordList
	svPasswords.Initialize(0)
	Activity.AddView(svPasswords, 0, 100dip, 100%x, 100%y - 100dip)
End Sub

Private Sub LoadPasswords
	svPasswords.Panel.RemoveAllViews

	Dim entries As List = ModPasswords.GetEntriesByGroup(GroupId)

	If entries.Size = 0 Then
		ShowEmptyMessage
		Return
	End If

	Dim top As Int = 10dip
	Dim margin As Int = 10dip
	Dim itemH As Int = 100dip

	For i = 0 To entries.Size - 1
		Dim e As clsPasswordEntry = entries.Get(i)

		Dim pnlItem As Panel
		pnlItem.Initialize("pnlEntry")
		pnlItem.Tag = e.Id
		pnlItem.Color = ModTheme.GetPanelColor
		svPasswords.Panel.AddView(pnlItem, margin, top, 100%x - 2 * margin, itemH)

		Dim xvItem As B4XView = pnlItem
		xvItem.SetColorAndBorder(ModTheme.GetPanelColor, 1dip, ModTheme.GetBorderColor, 8dip)

		' Site/App
		Dim lblSite As Label
		lblSite.Initialize("")
		lblSite.Text = e.Site
		lblSite.TextSize = 15
		lblSite.TextColor = ModTheme.GetTextColor
		lblSite.Typeface = Typeface.DEFAULT_BOLD
		pnlItem.AddView(lblSite, 15dip, 10dip, pnlItem.Width - 60dip, 22dip)

		' Usuario
		Dim lblUser As Label
		lblUser.Initialize("")
		lblUser.Text = e.Username
		lblUser.TextSize = 13
		lblUser.TextColor = ModTheme.GetSecondaryTextColor
		pnlItem.AddView(lblUser, 15dip, 32dip, pnlItem.Width - 60dip, 20dip)

		' Senha (mascarada ou descriptografada)
		Dim lblPwd As Label
		lblPwd.Initialize("lblPwd")
		lblPwd.Tag = e.Id
		If DecryptedPasswords.ContainsKey(e.Id) Then
			lblPwd.Text = DecryptedPasswords.Get(e.Id)
		Else
			lblPwd.Text = "••••••••"
		End If
		lblPwd.TextSize = 13
		lblPwd.TextColor = ModTheme.GetPrimaryColor
		pnlItem.AddView(lblPwd, 15dip, 54dip, pnlItem.Width - 100dip, 20dip)

		' Checkbox Ver (ao lado da senha)
		Dim chkVer As CheckBox
		chkVer.Initialize("chkVer")
		chkVer.Tag = e.Id
		chkVer.Text = ModLang.GetText("pwd_show")
		chkVer.TextSize = 11
		chkVer.TextColor = ModTheme.GetSecondaryTextColor
		chkVer.Checked = DecryptedPasswords.ContainsKey(e.Id)
		pnlItem.AddView(chkVer, 15dip, 74dip, 80dip, 22dip)

		' Botao editar
		Dim btnEdit As Button
		btnEdit.Initialize("btnEdit")
		btnEdit.Tag = e.Id
		btnEdit.Text = Chr(0x270E) ' Icone editar
		btnEdit.TextSize = 18
		btnEdit.Color = Colors.Transparent
		btnEdit.TextColor = ModTheme.GetSecondaryTextColor
		pnlItem.AddView(btnEdit, pnlItem.Width - 45dip, 30dip, 40dip, 40dip)

		top = top + itemH + 10dip
	Next

	svPasswords.Panel.Height = top + 20dip
End Sub

Private Sub ShowEmptyMessage
	Dim lblEmpty As Label
	lblEmpty.Initialize("")
	lblEmpty.Text = ModLang.GetText("no_passwords_yet") & CRLF & CRLF & ModLang.GetText("tap_plus_to_add")
	lblEmpty.TextSize = 14
	lblEmpty.TextColor = ModTheme.GetSecondaryTextColor
	lblEmpty.Gravity = Gravity.CENTER_HORIZONTAL
	svPasswords.Panel.AddView(lblEmpty, 20dip, 50dip, 100%x - 40dip, 100dip)
	svPasswords.Panel.Height = 200dip
End Sub

' ============================================
'  DIALOG FRASE-SENHA
' ============================================
Private Sub CreatePassphraseDialog
	pnlPassphraseDialog.Initialize("")
	pnlPassphraseDialog.Color = Colors.ARGB(180, 0, 0, 0)
	Activity.AddView(pnlPassphraseDialog, 0, 0, 100%x, 100%y)
	pnlPassphraseDialog.Visible = False

	Dim boxW As Int = 100%x - 40dip
	Dim boxH As Int = 180dip
	Dim boxL As Int = 20dip
	Dim boxT As Int = 100dip

	Dim pnlBox As Panel
	pnlBox.Initialize("")
	pnlBox.Color = ModTheme.GetPanelColor
	pnlPassphraseDialog.AddView(pnlBox, boxL, boxT, boxW, boxH)

	Dim xvBox As B4XView = pnlBox
	xvBox.SetColorAndBorder(ModTheme.GetPanelColor, 1dip, ModTheme.GetBorderColor, 10dip)

	' Titulo
	Dim lblDialogTitle As Label
	lblDialogTitle.Initialize("")
	lblDialogTitle.Text = ModLang.GetText("pwd_enter_passphrase")
	lblDialogTitle.TextSize = 16
	lblDialogTitle.TextColor = ModTheme.GetTextColor
	lblDialogTitle.Gravity = Gravity.CENTER_HORIZONTAL
	pnlBox.AddView(lblDialogTitle, 10dip, 15dip, boxW - 20dip, 25dip)

	' Campo frase-senha
	edtPassphrase.Initialize("edtPassphrase")
	edtPassphrase.Hint = ModLang.GetText("hint_passphrase")
	edtPassphrase.TextSize = Main.FONT_EDIT
	edtPassphrase.TextColor = ModTheme.GetInputTextColor
	edtPassphrase.InputType = Bit.Or(edtPassphrase.INPUT_TYPE_TEXT, 128) ' 128 = password
	pnlBox.AddView(edtPassphrase, 15dip, 55dip, boxW - 85dip, 45dip)
	edtPassphrase.Background = ModTheme.GetEditDrawableWhite

	' Botao Ver/Ocultar frase-senha
	btnPassphraseShow.Initialize("btnPassphraseShow")
	btnPassphraseShow.Text = "Ver"
	btnPassphraseShow.TextSize = 11
	btnPassphraseShow.Color = ModTheme.GetPrimaryColor
	btnPassphraseShow.TextColor = Colors.White
	pnlBox.AddView(btnPassphraseShow, boxW - 65dip, 58dip, 55dip, 38dip)

	' Botoes
	Dim btnW As Int = (boxW - 50dip) / 2

	btnPassphraseCancel.Initialize("btnPassphraseCancel")
	btnPassphraseCancel.Text = ModLang.GetText("btn_back")
	btnPassphraseCancel.TextSize = Main.FONT_BUTTON
	btnPassphraseCancel.Color = Colors.Gray
	btnPassphraseCancel.TextColor = Colors.White
	pnlBox.AddView(btnPassphraseCancel, 15dip, 120dip, btnW, 38dip)

	btnPassphraseOk.Initialize("btnPassphraseOk")
	btnPassphraseOk.Text = ModLang.GetText("btn_confirm")
	btnPassphraseOk.TextSize = Main.FONT_BUTTON
	btnPassphraseOk.Color = ModTheme.GetPrimaryColor
	btnPassphraseOk.TextColor = Colors.White
	pnlBox.AddView(btnPassphraseOk, boxW - btnW - 15dip, 120dip, btnW, 38dip)
End Sub

Private Sub ShowPassphraseDialog
	pnlPassphraseDialog.Visible = True
	pnlPassphraseDialog.BringToFront
	edtPassphrase.Text = ""
	PassphraseVisible = False
	edtPassphrase.InputType = Bit.Or(edtPassphrase.INPUT_TYPE_TEXT, 128)
	edtPassphrase.RequestFocus
End Sub

Private Sub HidePassphraseDialog
	pnlPassphraseDialog.Visible = False
	edtPassphrase.Text = ""
End Sub

' ============================================
'  DIALOG NOVA/EDITAR SENHA
' ============================================
Private Sub CreateEntryDialog
	pnlEntryDialog.Initialize("")
	pnlEntryDialog.Color = Colors.ARGB(180, 0, 0, 0)
	Activity.AddView(pnlEntryDialog, 0, 0, 100%x, 100%y)
	pnlEntryDialog.Visible = False

	Dim boxW As Int = 100%x - 30dip
	Dim boxH As Int = 340dip
	Dim boxL As Int = 15dip
	Dim boxT As Int = 60dip

	Dim pnlBox As Panel
	pnlBox.Initialize("")
	pnlBox.Color = ModTheme.GetPanelColor
	pnlEntryDialog.AddView(pnlBox, boxL, boxT, boxW, boxH)

	Dim xvBox As B4XView = pnlBox
	xvBox.SetColorAndBorder(ModTheme.GetPanelColor, 1dip, ModTheme.GetBorderColor, 10dip)

	' Titulo
	Dim lblDialogTitle As Label
	lblDialogTitle.Initialize("")
	lblDialogTitle.Text = ModLang.GetText("pwd_new_entry")
	lblDialogTitle.TextSize = 16
	lblDialogTitle.TextColor = ModTheme.GetTextColor
	lblDialogTitle.Gravity = Gravity.CENTER_HORIZONTAL
	pnlBox.AddView(lblDialogTitle, 10dip, 10dip, boxW - 20dip, 25dip)

	Dim fieldTop As Int = 40dip
	Dim fieldH As Int = 40dip
	Dim gap As Int = 50dip

	' Site/App
	Dim lblSite As Label
	lblSite.Initialize("")
	lblSite.Text = ModLang.GetText("pwd_site")
	lblSite.TextSize = Main.FONT_LABEL
	lblSite.TextColor = ModTheme.GetTextColor
	pnlBox.AddView(lblSite, 15dip, fieldTop, boxW - 30dip, 18dip)

	edtSite.Initialize("edtSite")
	edtSite.Hint = "Ex: binance.com"
	edtSite.TextSize = Main.FONT_EDIT
	edtSite.TextColor = ModTheme.GetInputTextColor
	pnlBox.AddView(edtSite, 15dip, fieldTop + 18dip, boxW - 30dip, fieldH)
	edtSite.Background = ModTheme.GetEditDrawableWhite

	fieldTop = fieldTop + gap + 10dip

	' Usuario
	Dim lblUser As Label
	lblUser.Initialize("")
	lblUser.Text = ModLang.GetText("pwd_username")
	lblUser.TextSize = Main.FONT_LABEL
	lblUser.TextColor = ModTheme.GetTextColor
	pnlBox.AddView(lblUser, 15dip, fieldTop, boxW - 30dip, 18dip)

	edtUsername.Initialize("edtUsername")
	edtUsername.Hint = "Ex: usuario@email.com"
	edtUsername.TextSize = Main.FONT_EDIT
	edtUsername.TextColor = ModTheme.GetInputTextColor
	pnlBox.AddView(edtUsername, 15dip, fieldTop + 18dip, boxW - 30dip, fieldH)
	edtUsername.Background = ModTheme.GetEditDrawableWhite

	fieldTop = fieldTop + gap + 10dip

	' Senha
	Dim lblPwd As Label
	lblPwd.Initialize("")
	lblPwd.Text = ModLang.GetText("pwd_password")
	lblPwd.TextSize = Main.FONT_LABEL
	lblPwd.TextColor = ModTheme.GetTextColor
	pnlBox.AddView(lblPwd, 15dip, fieldTop, boxW - 30dip, 18dip)

	edtPassword.Initialize("edtPassword")
	edtPassword.Hint = ModLang.GetText("hint_password")
	edtPassword.TextSize = Main.FONT_EDIT
	edtPassword.TextColor = ModTheme.GetInputTextColor
	edtPassword.InputType = Bit.Or(edtPassword.INPUT_TYPE_TEXT, 128) ' password
	pnlBox.AddView(edtPassword, 15dip, fieldTop + 18dip, boxW - 85dip, fieldH)
	edtPassword.Background = ModTheme.GetEditDrawableWhite

	' Botao Ver/Ocultar senha
	btnEntryShowPwd.Initialize("btnEntryShowPwd")
	btnEntryShowPwd.Text = "Ver"
	btnEntryShowPwd.TextSize = 11
	btnEntryShowPwd.Color = ModTheme.GetPrimaryColor
	btnEntryShowPwd.TextColor = Colors.White
	pnlBox.AddView(btnEntryShowPwd, boxW - 65dip, fieldTop + 18dip, 55dip, fieldH)

	fieldTop = fieldTop + gap + 10dip

	' Notas
	Dim lblNotes As Label
	lblNotes.Initialize("")
	lblNotes.Text = ModLang.GetText("pwd_notes")
	lblNotes.TextSize = Main.FONT_LABEL
	lblNotes.TextColor = ModTheme.GetTextColor
	pnlBox.AddView(lblNotes, 15dip, fieldTop, boxW - 30dip, 18dip)

	edtNotes.Initialize("edtNotes")
	edtNotes.Hint = ModLang.GetText("hint_notes")
	edtNotes.TextSize = Main.FONT_EDIT
	edtNotes.TextColor = ModTheme.GetInputTextColor
	pnlBox.AddView(edtNotes, 15dip, fieldTop + 18dip, boxW - 30dip, fieldH)
	edtNotes.Background = ModTheme.GetEditDrawableWhite

	' Botoes
	Dim btnW As Int = (boxW - 50dip) / 2
	Dim btnTop As Int = boxH - 50dip

	btnEntryCancel.Initialize("btnEntryCancel")
	btnEntryCancel.Text = ModLang.GetText("btn_back")
	btnEntryCancel.TextSize = Main.FONT_BUTTON
	btnEntryCancel.Color = Colors.Gray
	btnEntryCancel.TextColor = Colors.White
	pnlBox.AddView(btnEntryCancel, 15dip, btnTop, btnW, 38dip)

	btnEntrySave.Initialize("btnEntrySave")
	btnEntrySave.Text = ModLang.GetText("btn_save")
	btnEntrySave.TextSize = Main.FONT_BUTTON
	btnEntrySave.Color = ModTheme.GetPrimaryColor
	btnEntrySave.TextColor = Colors.White
	pnlBox.AddView(btnEntrySave, boxW - btnW - 15dip, btnTop, btnW, 38dip)
End Sub

Private Sub ShowEntryDialog
	pnlEntryDialog.Visible = True
	pnlEntryDialog.BringToFront
	EntryPwdVisible = False
	edtPassword.InputType = Bit.Or(edtPassword.INPUT_TYPE_TEXT, 128)
	edtSite.RequestFocus
End Sub

Private Sub HideEntryDialog
	pnlEntryDialog.Visible = False
	edtSite.Text = ""
	edtUsername.Text = ""
	edtPassword.Text = ""
	edtNotes.Text = ""
	EditingEntryId = ""
End Sub

' ============================================
'  EVENTOS
' ============================================
Sub btnBack_Click
	Activity.Finish
End Sub

Sub btnAdd_Click
	' Verifica limite da versao
	If ModPasswords.CanCreateEntry = False Then
		ToastMessageShow(ModLang.GetText("err_limit_passwords"), True)
		Return
	End If

	' Verifica se tem sessao valida para adicionar
	If ModPasswords.IsSessionValid = False Then
		ShowPassphraseDialog
		Return
	End If

	EditingEntryId = ""
	edtSite.Text = ""
	edtUsername.Text = ""
	edtPassword.Text = ""
	edtNotes.Text = ""
	ShowEntryDialog
End Sub

' Checkbox Ver - descriptografa/oculta senha individual
Sub chkVer_CheckedChange(Checked As Boolean)
	Dim chk As CheckBox = Sender

	' Verifica se Tag existe
	If chk.Tag = Null Or chk.Tag = "" Then Return

	Dim entryId As String = chk.Tag

	If Checked Then
		' Precisa descriptografar
		If ModPasswords.IsSessionValid = False Then
			chk.Checked = False
			ShowPassphraseDialog
			Return
		End If

		Dim passphrase As String = ModPasswords.GetSessionPassphrase
		If passphrase = "" Then
			chk.Checked = False
			Return
		End If

		Dim e As clsPasswordEntry = ModPasswords.GetEntryById(entryId)
		If e.IsInitialized = False Then
			chk.Checked = False
			Return
		End If

		If e.PasswordEnc <> "" Then
			Dim decrypted As String = ModPasswords.DecryptPassword(passphrase, e.PasswordEnc)
			If decrypted <> "" Then
				DecryptedPasswords.Put(entryId, decrypted)
			Else
				DecryptedPasswords.Put(entryId, "[" & ModLang.GetText("pwd_decrypt_error") & "]")
			End If
		End If
	Else
		' Ocultar
		If DecryptedPasswords.ContainsKey(entryId) Then
			DecryptedPasswords.Remove(entryId)
		End If
	End If

	' Atualiza label da senha no mesmo painel
	UpdatePasswordLabel(entryId)
End Sub

Private Sub UpdatePasswordLabel(entryId As String)
	If entryId = "" Or entryId = Null Then Return

	For Each v As View In svPasswords.Panel
		If v Is Panel Then
			Dim pnl As Panel = v
			If pnl.Tag <> Null And pnl.Tag = entryId Then
				For i = 0 To pnl.NumberOfViews - 1
					Dim child As View = pnl.GetView(i)
					If child Is Label Then
						Dim lbl As Label = child
						If lbl.Tag <> Null And lbl.Tag = entryId Then
							If DecryptedPasswords.ContainsKey(entryId) Then
								lbl.Text = DecryptedPasswords.Get(entryId)
							Else
								lbl.Text = "••••••••"
							End If
							Return
						End If
					End If
				Next
				Return
			End If
		End If
	Next
End Sub

Sub pnlEntry_LongClick
	Dim pnl As Panel = Sender
	If pnl.Tag = Null Or pnl.Tag = "" Then Return
	Dim entryId As String = pnl.Tag

	' Confirma exclusao
	Msgbox2Async(ModLang.GetText("msg_confirm_delete_password"), _
		ModLang.GetText("title_warning"), _
		ModLang.GetText("btn_yes"), "", ModLang.GetText("btn_no"), Null, True)
	Wait For Msgbox_Result(res As Int)

	If res = DialogResponse.POSITIVE Then
		ModPasswords.DeleteEntry(entryId)
		DecryptedPasswords.Remove(entryId)
		ToastMessageShow(ModLang.GetText("msg_password_deleted"), False)
		LoadPasswords
	End If
End Sub

Sub btnEdit_Click
	Dim btn As Button = Sender
	If btn.Tag = Null Or btn.Tag = "" Then Return
	Dim entryId As String = btn.Tag

	' Verifica sessao
	If ModPasswords.IsSessionValid = False Then
		ShowPassphraseDialog
		Return
	End If

	' Carrega dados da entrada
	Dim e As clsPasswordEntry = ModPasswords.GetEntryById(entryId)
	If e.IsInitialized = False Then Return

	EditingEntryId = entryId
	edtSite.Text = e.Site
	edtUsername.Text = e.Username
	edtNotes.Text = e.Notes

	' Tenta descriptografar senha para edicao
	Dim passphrase As String = ModPasswords.GetSessionPassphrase
	If passphrase <> "" And e.PasswordEnc <> "" Then
		Dim decrypted As String = ModPasswords.DecryptPassword(passphrase, e.PasswordEnc)
		edtPassword.Text = decrypted
	Else
		edtPassword.Text = ""
	End If

	ShowEntryDialog
End Sub

' Dialog Frase-senha
Sub btnPassphraseCancel_Click
	HidePassphraseDialog
End Sub

Sub btnPassphraseShow_Click
	PassphraseVisible = Not(PassphraseVisible)
	If PassphraseVisible Then
		edtPassphrase.InputType = edtPassphrase.INPUT_TYPE_TEXT
		btnPassphraseShow.Text = "***"
	Else
		edtPassphrase.InputType = Bit.Or(edtPassphrase.INPUT_TYPE_TEXT, 128)
		btnPassphraseShow.Text = "Ver"
	End If
	' Manter cursor no final
	edtPassphrase.SelectionStart = edtPassphrase.Text.Length
End Sub

Sub btnPassphraseOk_Click
	Dim passphrase As String = edtPassphrase.Text.Trim

	If passphrase.Length < 3 Then
		ToastMessageShow(ModLang.GetText("pwd_passphrase_too_short"), False)
		Return
	End If

	' Inicia sessao com a frase
	ModPasswords.SetSessionPassphrase(passphrase)
	HidePassphraseDialog
	UpdateSessionDisplay

	ToastMessageShow(ModLang.GetText("pwd_session_started"), False)
End Sub

' Dialog Nova/Editar Entrada
Sub btnEntryCancel_Click
	HideEntryDialog
End Sub

Sub btnEntryShowPwd_Click
	EntryPwdVisible = Not(EntryPwdVisible)
	If EntryPwdVisible Then
		edtPassword.InputType = edtPassword.INPUT_TYPE_TEXT
		btnEntryShowPwd.Text = "***"
	Else
		edtPassword.InputType = Bit.Or(edtPassword.INPUT_TYPE_TEXT, 128)
		btnEntryShowPwd.Text = "Ver"
	End If
	' Manter cursor no final
	edtPassword.SelectionStart = edtPassword.Text.Length
End Sub

Sub btnEntrySave_Click
	Dim site As String = edtSite.Text.Trim
	Dim username As String = edtUsername.Text.Trim
	Dim password As String = edtPassword.Text
	Dim notes As String = edtNotes.Text.Trim

	If site = "" Then
		ToastMessageShow(ModLang.GetText("pwd_site_required"), False)
		Return
	End If

	If password = "" Then
		ToastMessageShow(ModLang.GetText("pwd_password_required"), False)
		Return
	End If

	' Verifica sessao
	If ModPasswords.IsSessionValid = False Then
		ToastMessageShow(ModLang.GetText("pwd_session_expired"), False)
		HideEntryDialog
		ShowPassphraseDialog
		Return
	End If

	Dim passphrase As String = ModPasswords.GetSessionPassphrase

	' Criptografa a senha
	Dim encPassword As String = ModPasswords.EncryptPassword(passphrase, password)
	If encPassword = "" Then
		ToastMessageShow(ModLang.GetText("pwd_encrypt_error"), False)
		Return
	End If

	' Salva entrada
	Dim e As clsPasswordEntry
	e.Initialize

	If EditingEntryId <> "" Then
		e = ModPasswords.GetEntryById(EditingEntryId)
	End If

	e.GroupId = GroupId
	e.Site = site
	e.Username = username
	e.PasswordEnc = encPassword
	e.Notes = notes

	ModPasswords.SaveEntry(e)

	ToastMessageShow(ModLang.GetText("msg_password_saved"), False)
	HideEntryDialog
	LoadPasswords
End Sub

