B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
'PagePasswordList.bas - Lista de Senhas de um Grupo
'LockZero - Exibe senhas, permite copiar, editar, deletar

Sub Class_Globals
	Private Root As B4XView
	Private xui As XUI

	'Parametros
	Private CurrentGroupId As String
	Private CurrentGroupName As String

	'UI
	Private btnBack As Button
	Private lblHeaderTitle As Label

	Private svEntries As ScrollView
	Private pnlEntries As B4XView

	'Busca
	Private edtSearch As EditText
	Private lblClearSearch As Label
	Private AllEntries As List 'Lista completa de entradas
	Private FilteredEntries As List 'Lista filtrada pela busca

	'Timer para limpar clipboard
	Private tmrClipboard As Timer
	Private ClipboardCountdown As Int

	'Dialog Overlay
	Private pnlOverlay As Panel
	Private pnlDialog As Panel
	Private edtPassphrase As EditText
	Private btnShowPass As Button
	Private IsPassVisible As Boolean = False

	'Timer de sessao no header
	Private lblSessionTimer As Label
	Private tmrSession As Timer
End Sub

Public Sub Initialize
	tmrClipboard.Initialize("tmrClipboard", 1000)
	tmrSession.Initialize("tmrSession", 1000)
	AllEntries.Initialize
	FilteredEntries.Initialize
End Sub

Private Sub B4XPage_Created(Root1 As B4XView)
	Root = Root1
	CreateUI
	ApplyTheme
End Sub

Private Sub B4XPage_Appear
	'SEGURANCA: Verifica se sessao esta ativa antes de mostrar senhas
	If ModSession.IsSessionActive = False Then
		Log("PagePasswordList: Sessao inativa - redirecionando")
		B4XPages.ClosePage(Me)
		Return
	End If

	'Atualiza titulo do header com breadcrumb (Senhas → NomeGrupo)
	Dim g As clsPasswordGroup = ModPasswords.GetGroupById(CurrentGroupId)
	If g.IsInitialized Then
		CurrentGroupName = g.Name
		lblHeaderTitle.Text = ModLang.T("passwords") & " → " & CurrentGroupName
	Else
		lblHeaderTitle.Text = ModLang.T("passwords")
	End If

	ModSession.Touch

	'Reseta scroll para o topo
	svEntries.ScrollPosition = 0

	LoadEntries

	'Inicia timer de sessao
	UpdateSessionTimer
	tmrSession.Enabled = True
End Sub

'Recebe parametros da pagina anterior
Public Sub SetParams(params As Map)
	If params = Null Then Return
	CurrentGroupId = params.GetDefault("groupId", "")
End Sub

'Capitalize - primeira letra de cada palavra em maiuscula
Private Sub Capitalize(text As String) As String
	If text.Length = 0 Then Return text

	Dim result As StringBuilder
	result.Initialize
	Dim capitalizeNext As Boolean = True
	Dim lower As String = text.ToLowerCase

	For i = 0 To lower.Length - 1
		Dim c As String = lower.SubString2(i, i + 1)
		If c = " " Then
			result.Append(c)
			capitalizeNext = True
		Else
			If capitalizeNext Then
				result.Append(c.ToUpperCase)
				capitalizeNext = False
			Else
				result.Append(c)
			End If
		End If
	Next

	Return result.ToString
End Sub

Private Sub B4XPage_Disappear
	tmrClipboard.Enabled = False
	tmrSession.Enabled = False
End Sub

' ============================================
'  CRIAR UI
' ============================================

Private Sub CreateUI
	Dim width As Int = Root.Width
	Dim height As Int = Root.Height
	Dim headerH As Int = 56dip
	Dim searchH As Int = 54dip

	'Header com seta voltar, titulo e botao +
	Dim pnlHeader As Panel
	pnlHeader.Initialize("")
	pnlHeader.Color = ModTheme.HomeHeaderBg
	Root.AddView(pnlHeader, 0, 0, width, headerH)

	'Seta voltar
	btnBack.Initialize("btnBack")
	btnBack.Text = "<"
	btnBack.TextSize = 20
	btnBack.Color = Colors.Transparent
	btnBack.TextColor = Colors.White
	btnBack.Gravity = Gravity.CENTER
	pnlHeader.AddView(btnBack, 0, 0, 50dip, headerH)

	'Titulo com breadcrumb: Senhas → NomeGrupo
	lblHeaderTitle.Initialize("")
	lblHeaderTitle.Text = ModLang.T("passwords")
	lblHeaderTitle.TextSize = 16
	lblHeaderTitle.TextColor = Colors.White
	lblHeaderTitle.Typeface = Typeface.DEFAULT_BOLD
	lblHeaderTitle.Gravity = Gravity.CENTER_VERTICAL
	pnlHeader.AddView(lblHeaderTitle, 50dip, 0, width - 170dip, headerH)

	'Timer de sessao (toque para bloquear)
	lblSessionTimer.Initialize("lblSessionTimer")
	lblSessionTimer.Text = "00:00"
	lblSessionTimer.TextSize = 12
	lblSessionTimer.TextColor = Colors.ARGB(200, 255, 255, 255)
	lblSessionTimer.Gravity = Gravity.CENTER
	pnlHeader.AddView(lblSessionTimer, width - 110dip, 12dip, 55dip, 32dip)

	'Fundo arredondado para o timer (indica que e clicavel)
	Dim xvTimer As B4XView = lblSessionTimer
	xvTimer.SetColorAndBorder(Colors.ARGB(60, 255, 255, 255), 0, Colors.Transparent, 8dip)

	'Botao adicionar no header - usando Label para evitar tema do sistema
	Dim lblAdd As Label
	lblAdd.Initialize("btnAdd")
	lblAdd.Text = "+"
	lblAdd.TextSize = 26
	lblAdd.Typeface = Typeface.DEFAULT_BOLD
	lblAdd.Gravity = Gravity.CENTER
	lblAdd.TextColor = Colors.White
	pnlHeader.AddView(lblAdd, width - 50dip, 8dip, 40dip, 40dip)

	'Arredondar o label
	Dim xvAdd As B4XView = lblAdd
	xvAdd.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModTheme.HomeIconBg, 20dip)

	'Barra de busca
	Dim pnlSearch As Panel
	pnlSearch.Initialize("")
	pnlSearch.Color = ModTheme.HomeBg
	Root.AddView(pnlSearch, 0, headerH, width, searchH)

	edtSearch.Initialize("edtSearch")
	edtSearch.Hint = ModLang.T("search_hint")
	edtSearch.SingleLine = True
	edtSearch.Text = ""
	edtSearch.TextSize = Starter.FONT_BODY
	edtSearch.TextColor = Colors.White
	edtSearch.HintColor = Colors.ARGB(120, 255, 255, 255)

	Dim pnlSearchInput As Panel
	pnlSearchInput.Initialize("")
	pnlSearchInput.Color = ModTheme.HomeIconBg
	pnlSearch.AddView(pnlSearchInput, 16dip, 5dip, width - 32dip, 44dip)

	'Arredondar cantos do input
	Dim xvSearchInput As B4XView = pnlSearchInput
	xvSearchInput.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModTheme.HomeIconBg, 8dip)

	pnlSearchInput.AddView(edtSearch, 12dip, 0, width - 100dip, 44dip)

	'Botao X para limpar busca
	lblClearSearch.Initialize("lblClearSearch")
	lblClearSearch.Text = "X"
	lblClearSearch.TextSize = 16
	lblClearSearch.TextColor = Colors.ARGB(180, 255, 255, 255)
	lblClearSearch.Gravity = Gravity.CENTER
	lblClearSearch.Visible = False
	pnlSearchInput.AddView(lblClearSearch, width - 80dip, 2dip, 40dip, 40dip)

	'Lista de senhas
	svEntries.Initialize(0)
	svEntries.Color = ModTheme.HomeBg
	Root.AddView(svEntries, 0, headerH + searchH, width, height - headerH - searchH)

	pnlEntries = svEntries.Panel
	pnlEntries.Color = ModTheme.HomeBg

	'Overlay para dialogs
	CreateDialogOverlay
End Sub

Private Sub CreateDialogOverlay
	Dim width As Int = Root.Width
	Dim height As Int = Root.Height

	pnlOverlay.Initialize("pnlOverlay")
	pnlOverlay.Color = Colors.ARGB(180, 0, 0, 0)
	pnlOverlay.Visible = False
	Root.AddView(pnlOverlay, 0, 0, width, height)

	Dim dialogW As Int = width - 40dip
	pnlDialog.Initialize("")
	pnlDialog.Color = ModTheme.HomeHeaderBg
	pnlOverlay.AddView(pnlDialog, 20dip, 80dip, dialogW, 195dip)

	Dim xvDialog As B4XView = pnlDialog
	xvDialog.SetColorAndBorder(ModTheme.HomeHeaderBg, 0, ModTheme.HomeHeaderBg, 12dip)
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
'  CARREGAR SENHAS
' ============================================

Private Sub LoadEntries
	'Carrega todas as entradas do grupo
	AllEntries = ModPasswords.GetEntriesByGroup(CurrentGroupId)

	'Limpa busca e exibe todas
	edtSearch.Text = ""
	FilteredEntries.Initialize
	For Each e As clsPasswordEntry In AllEntries
		FilteredEntries.Add(e)
	Next

	DisplayEntries
End Sub

'Filtra entradas com base no texto de busca
Private Sub FilterEntries(query As String)
	FilteredEntries.Initialize
	Dim q As String = query.ToLowerCase.Trim

	If q.Length = 0 Then
		'Sem filtro - mostra todas
		For Each e As clsPasswordEntry In AllEntries
			FilteredEntries.Add(e)
		Next
	Else
		'Filtra por nome ou URL
		For Each e As clsPasswordEntry In AllEntries
			Dim name As String = e.GetDisplayName.ToLowerCase
			Dim url As String = e.Url.ToLowerCase
			If name.Contains(q) Or url.Contains(q) Then
				FilteredEntries.Add(e)
			End If
		Next
	End If

	DisplayEntries
End Sub

'Exibe as entradas filtradas na lista
Private Sub DisplayEntries
	pnlEntries.RemoveAllViews

	Dim width As Int = Root.Width
	Dim itemHeight As Int = 80dip
	Dim y As Int = 16dip

	If FilteredEntries.Size = 0 Then
		Dim lblEmpty As B4XView = CreateLabel(ModLang.T("empty"), 14, False)
		lblEmpty.TextColor = Colors.ARGB(150, 255, 255, 255)
		pnlEntries.AddView(lblEmpty, 0, 100dip, width, 40dip)
		pnlEntries.Height = 200dip
		Return
	End If

	For Each e As clsPasswordEntry In FilteredEntries
		Dim pnlItem As Panel
		pnlItem.Initialize("pnlEntry")
		pnlItem.Tag = e.Id

		'Card com cor da Home e cantos arredondados
		Dim xvItem As B4XView = pnlItem
		xvItem.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModTheme.HomeIconBg, 12dip)
		pnlEntries.AddView(pnlItem, 16dip, y, width - 32dip, itemHeight)

		'Favorito
		If e.IsFavorite Then
			Dim lblFav As Label
			lblFav.Initialize("")
			lblFav.Text = "*"
			lblFav.TextSize = 16
			lblFav.TextColor = Colors.RGB(255, 200, 100) 'Amarelo suave
			lblFav.Gravity = Gravity.CENTER
			pnlItem.AddView(lblFav, 8dip, 0, 20dip, itemHeight)
		End If

		Dim leftOffset As Int = 16dip
		If e.IsFavorite Then leftOffset = 30dip

		'Nome
		Dim lblName As Label
		lblName.Initialize("")
		lblName.Text = e.GetDisplayName
		lblName.TextSize = 16
		lblName.TextColor = Colors.White
		lblName.Typeface = Typeface.DEFAULT_BOLD
		pnlItem.AddView(lblName, leftOffset, 15dip, width - 150dip, 25dip)

		'Username (descriptografado se sessao ativa)
		Dim username As String = ""
		If ModSession.IsSessionActive Then
			username = ModPasswords.DecryptValue(e.Username)
		Else
			username = "***"
		End If
		Dim lblUser As Label
		lblUser.Initialize("")
		lblUser.Text = username
		lblUser.TextSize = 13
		lblUser.TextColor = Colors.ARGB(180, 255, 255, 255)
		pnlItem.AddView(lblUser, leftOffset, 42dip, width - 150dip, 20dip)

		'Botao copiar senha
		Dim btnCopy As Button
		btnCopy.Initialize("btnCopy")
		btnCopy.Text = ModLang.T("copy")
		btnCopy.Tag = e.Id
		btnCopy.TextSize = 12
		btnCopy.Color = ModTheme.HomeBg
		btnCopy.TextColor = Colors.White
		pnlItem.AddView(btnCopy, width - 120dip, 20dip, 70dip, 40dip)

		y = y + itemHeight + 12dip
	Next

	pnlEntries.Height = y + 20dip
End Sub

' ============================================
'  EVENTOS
' ============================================

Private Sub btnBack_Click
	B4XPages.ClosePage(Me)
End Sub

Private Sub btnAdd_Click
	ModSession.Touch
	'Verifica se sessao esta ativa (frase em memoria)
	If ModSession.IsSessionActive = False Then
		ShowPassphraseDialog
	Else
		NavigateToAddPassword
	End If
End Sub

'Evento de busca - filtra conforme digita
Private Sub edtSearch_TextChanged(Old As String, New As String)
	ModSession.Touch
	FilterEntries(New)
	'Mostra/esconde botao X
	lblClearSearch.Visible = (New.Length > 0)
End Sub

'Limpa o campo de busca
Private Sub lblClearSearch_Click
	edtSearch.Text = ""
	lblClearSearch.Visible = False
	FilterEntries("")
End Sub

Private Sub pnlOverlay_Click
	HideDialog
End Sub

Private Sub NavigateToAddPassword
	Dim params As Map
	params.Initialize
	params.Put("groupId", CurrentGroupId)
	params.Put("entryId", "") 'Novo

	Dim pg As PagePasswordEdit = B4XPages.GetPage("PagePasswordEdit")
	pg.SetParams(params)
	B4XPages.ShowPage("PagePasswordEdit")
End Sub

' ============================================
'  DIALOGO DE FRASE-SENHA
' ============================================

Private Sub ShowPassphraseDialog
	IsPassVisible = False

	Dim dialogW As Int = Root.Width - 40dip
	pnlDialog.RemoveAllViews

	'Titulo
	Dim lblTitle As Label
	lblTitle.Initialize("")
	lblTitle.Text = ModLang.T("enter_passphrase")
	lblTitle.TextSize = 16
	lblTitle.TextColor = Colors.White
	lblTitle.Typeface = Typeface.DEFAULT_BOLD
	lblTitle.Gravity = Gravity.CENTER_HORIZONTAL
	pnlDialog.AddView(lblTitle, 0, 12dip, dialogW, 24dip)

	'Campo de frase com botao olho
	Dim pnlInput As Panel
	pnlInput.Initialize("")
	pnlInput.Color = ModTheme.HomeBg
	pnlDialog.AddView(pnlInput, 16dip, 50dip, dialogW - 32dip, 50dip)

	edtPassphrase.Initialize("edtPassphrase")
	edtPassphrase.Hint = ModLang.T("passphrase_hint")
	edtPassphrase.SingleLine = True
	edtPassphrase.InputType = Bit.Or(1, 128)
	edtPassphrase.Text = ""
	edtPassphrase.TextColor = Colors.White
	edtPassphrase.HintColor = Colors.ARGB(120, 255, 255, 255)
	pnlInput.AddView(edtPassphrase, 8dip, 0, dialogW - 32dip - 56dip, 50dip)

	btnShowPass.Initialize("btnShowPass")
	btnShowPass.Text = ModLang.T("view")
	btnShowPass.TextSize = Starter.FONT_CAPTION
	btnShowPass.Color = Colors.Transparent
	btnShowPass.TextColor = Colors.ARGB(200, 255, 255, 255)
	btnShowPass.Gravity = Gravity.CENTER
	pnlInput.AddView(btnShowPass, dialogW - 32dip - 65dip, 5dip, 60dip, 40dip)

	'Botoes
	Dim btnCancel As Button
	btnCancel.Initialize("btnDialogCancel")
	btnCancel.Text = ModLang.T("cancel")
	btnCancel.TextSize = 13
	btnCancel.Color = Colors.Transparent
	btnCancel.TextColor = Colors.ARGB(200, 255, 255, 255)
	pnlDialog.AddView(btnCancel, 16dip, 115dip, 100dip, 40dip)

	Dim btnOk As Button
	btnOk.Initialize("btnDialogOk")
	btnOk.Text = ModLang.T("confirm")
	btnOk.TextSize = 13
	btnOk.Color = ModTheme.HomeIconBg
	btnOk.TextColor = Colors.White
	pnlDialog.AddView(btnOk, dialogW - 116dip, 115dip, 100dip, 40dip)

	pnlDialog.SetLayoutAnimated(0, 20dip, 80dip, dialogW, 165dip)

	pnlOverlay.Visible = True
	pnlOverlay.BringToFront
	edtPassphrase.RequestFocus
End Sub

Private Sub btnShowPass_Click
	IsPassVisible = Not(IsPassVisible)
	If IsPassVisible Then
		edtPassphrase.InputType = 1
		btnShowPass.Text = ModLang.T("hide")
		btnShowPass.TextColor = Colors.White
	Else
		edtPassphrase.InputType = Bit.Or(1, 128)
		btnShowPass.Text = ModLang.T("view")
		btnShowPass.TextColor = Colors.ARGB(200, 255, 255, 255)
	End If
	edtPassphrase.SelectionStart = edtPassphrase.Text.Length
End Sub

Private Sub btnDialogCancel_Click
	HideDialog
End Sub

Private Sub btnDialogOk_Click
	Dim phrase As String = edtPassphrase.Text.Trim
	If phrase.Length >= 8 Then
		ModSession.StartSessionWithCategory(phrase, "passwords")
		HideDialog
		NavigateToAddPassword
	Else
		ToastMessageShow(ModLang.T("passphrase_min_8"), True)
	End If
End Sub

Private Sub HideDialog
	pnlOverlay.Visible = False
	Dim ime As IME
	ime.Initialize("")
	ime.HideKeyboard
End Sub

Private Sub pnlEntry_Click
	Dim pnl As Panel = Sender
	Dim entryId As String = pnl.Tag

	ModSession.Touch
	ShowEntryDetails(entryId)
End Sub

Private Sub pnlEntry_LongClick
	Dim pnl As Panel = Sender
	Dim entryId As String = pnl.Tag

	ShowEntryOptions(entryId)
End Sub

Private Sub btnCopy_Click
	Dim btn As Button = Sender
	Dim entryId As String = btn.Tag

	CopyPassword(entryId)
End Sub

' ============================================
'  COPIAR SENHA
' ============================================

Private Sub CopyPassword(entryId As String)
	If ModSession.IsSessionActive = False Then
		ToastMessageShow(ModLang.T("session_expired"), True)
		Return
	End If

	Dim e As clsPasswordEntry = ModPasswords.GetEntryById(entryId)
	If e.IsInitialized = False Then Return

	'Descriptografa senha
	Dim password As String = ModPasswords.DecryptValue(e.PasswordEnc)

	If password = "" Then
		ToastMessageShow(ModLang.T("error"), True)
		Return
	End If

	'Copia para clipboard
	SetClipboardText(password)

	'Marca como usado
	e.MarkAsUsed
	ModPasswords.SaveEntry(e)

	'Inicia timer para limpar clipboard
	ClipboardCountdown = ModSecurity.GetClipboardTimeout
	tmrClipboard.Enabled = True

	ToastMessageShow(ModLang.T("password_copied") & " (" & ClipboardCountdown & "s)", False)
End Sub

Private Sub tmrClipboard_Tick
	ClipboardCountdown = ClipboardCountdown - 1

	If ClipboardCountdown <= 0 Then
		tmrClipboard.Enabled = False
		'Limpa clipboard
		SetClipboardText("")
		ToastMessageShow(ModLang.T("clipboard_clear") & "!", False)
	End If
End Sub

' ============================================
'  TIMER DE SESSAO
' ============================================

Private Sub tmrSession_Tick
	UpdateSessionTimer

	'Verifica se sessao expirou
	If ModSession.IsSessionActive = False Then
		tmrSession.Enabled = False
		ToastMessageShow(ModLang.T("session_expired"), True)
		B4XPages.ClosePage(Me)
	End If
End Sub

Private Sub UpdateSessionTimer
	If ModSession.IsSessionActive Then
		lblSessionTimer.Text = ModSession.GetRemainingFormatted

		'Muda cor quando tempo baixo (< 60s)
		Dim remaining As Int = ModSession.GetRemainingSeconds
		If remaining < 60 Then
			lblSessionTimer.TextColor = ModTheme.Warning
		Else
			lblSessionTimer.TextColor = Colors.ARGB(200, 255, 255, 255)
		End If
	Else
		lblSessionTimer.Text = "00:00"
		lblSessionTimer.TextColor = ModTheme.Danger
	End If
End Sub

'Toque no timer bloqueia a sessao e volta para HOME
Private Sub lblSessionTimer_Click
	Wait For (xui.Msgbox2Async(ModLang.T("lock_confirm_msg"), ModLang.T("lock"), ModLang.T("yes"), "", ModLang.T("cancel"), Null)) Msgbox_Result(Result As Int)

	If Result = xui.DialogResponse_Positive Then
		ModSession.Lock
		tmrSession.Enabled = False
		ToastMessageShow(ModLang.T("locked"), False)
		B4XPages.ShowPageAndRemovePreviousPages("mainpage")
	End If
End Sub

' ============================================
'  DIALOGS
' ============================================

Private Sub ShowEntryDetails(entryId As String)
	If ModSession.IsSessionActive = False Then
		ToastMessageShow(ModLang.T("session_expired"), True)
		Return
	End If

	Dim e As clsPasswordEntry = ModPasswords.GetEntryById(entryId)
	If e.IsInitialized = False Then Return

	Dim username As String = ModPasswords.DecryptValue(e.Username)
	Dim password As String = ModPasswords.DecryptValue(e.PasswordEnc)
	Dim notes As String = ModPasswords.DecryptValue(e.Notes)

	Dim details As String = ""
	If e.Url <> "" Then
		details = e.Url & CRLF & CRLF
	End If
	details = details & ModLang.T("username") & ": " & username & CRLF & CRLF
	details = details & ModLang.T("password") & ": " & password
	If notes <> "" Then
		details = details & CRLF & CRLF & ModLang.T("note") & ": " & notes
	End If

	Wait For (xui.Msgbox2Async(details, e.GetDisplayName, ModLang.T("copy"), ModLang.T("close"), ModLang.T("edit"), Null)) Msgbox_Result(Result As Int)

	If Result = xui.DialogResponse_Positive Then
		CopyPassword(entryId)
	Else If Result = xui.DialogResponse_Negative Then
		EditEntry(entryId)
	End If
End Sub

Private Sub ShowEntryOptions(entryId As String)
	Dim e As clsPasswordEntry = ModPasswords.GetEntryById(entryId)
	If e.IsInitialized = False Then Return

	'Msgbox2Async params: Message, Title, Positive, Cancel, Negative, Icon
	'Positive=Edit, Cancel=Cancel, Negative=Delete
	Wait For (xui.Msgbox2Async(e.GetDisplayName, "", ModLang.T("edit"), ModLang.T("cancel"), ModLang.T("delete"), Null)) Msgbox_Result(Result As Int)

	If Result = xui.DialogResponse_Positive Then
		EditEntry(entryId)
	Else If Result = xui.DialogResponse_Negative Then
		ConfirmDeleteEntry(entryId)
	End If
End Sub

Private Sub EditEntry(entryId As String)
	Dim params As Map
	params.Initialize
	params.Put("groupId", CurrentGroupId)
	params.Put("entryId", entryId)

	Dim pg As PagePasswordEdit = B4XPages.GetPage("PagePasswordEdit")
	pg.SetParams(params)
	B4XPages.ShowPage("PagePasswordEdit")
End Sub

Private Sub ConfirmDeleteEntry(entryId As String)
	'SEGURANCA: Verifica se sessao esta ativa antes de permitir exclusao
	If ModSession.IsSessionActive = False Then
		ToastMessageShow(ModLang.T("session_expired"), True)
		Return
	End If

	Dim e As clsPasswordEntry = ModPasswords.GetEntryById(entryId)
	If e.IsInitialized = False Then Return

	Wait For (xui.Msgbox2Async(ModLang.T("confirm_delete_msg"), ModLang.T("confirm_delete"), ModLang.T("delete"), "", ModLang.T("cancel"), Null)) Msgbox_Result(Result As Int)

	If Result = xui.DialogResponse_Positive Then
		ModSession.Touch 'Renova sessao
		ModPasswords.DeleteEntry(entryId)
		LoadEntries
		ToastMessageShow(ModLang.T("success"), False)
	End If
End Sub

' ============================================
'  TEMA
' ============================================

Private Sub ApplyTheme
	Root.Color = ModTheme.HomeBg
End Sub

' ============================================
'  CLIPBOARD HELPER
' ============================================

Private Sub SetClipboardText(text As String)
	Try
		Dim jo As JavaObject
		jo.InitializeContext
		Dim cm As JavaObject = jo.RunMethod("getSystemService", Array("clipboard"))
		Dim cd As JavaObject
		cd.InitializeStatic("android.content.ClipData")
		Dim clip As JavaObject = cd.RunMethod("newPlainText", Array("LockZero", text))
		cm.RunMethod("setPrimaryClip", Array(clip))
	Catch
		Log("SetClipboardText error: " & LastException)
	End Try
End Sub
