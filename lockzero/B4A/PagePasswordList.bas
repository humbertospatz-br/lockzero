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
	Private btnAdd As Button

	Private svEntries As ScrollView
	Private pnlEntries As B4XView

	'Timer para limpar clipboard
	Private tmrClipboard As Timer
	Private ClipboardCountdown As Int

	'Dialogs
	Private edtPassphrase As EditText
End Sub

Public Sub Initialize
	tmrClipboard.Initialize("tmrClipboard", 1000)
End Sub

Private Sub B4XPage_Created(Root1 As B4XView)
	Root = Root1
	CreateUI
	ApplyTheme
End Sub

Private Sub B4XPage_Appear
	'Define titulo na ActionBar com breadcrumb
	Dim g As clsPasswordGroup = ModPasswords.GetGroupById(CurrentGroupId)
	If g.IsInitialized Then
		CurrentGroupName = g.Name
		CallSub2(Main, "SetPageTitle", ModLang.T("passwords") & " > " & CurrentGroupName)
	Else
		CallSub2(Main, "SetPageTitle", ModLang.T("passwords"))
	End If

	ModSession.Touch
	LoadEntries
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
End Sub

' ============================================
'  CRIAR UI
' ============================================

Private Sub CreateUI
	Dim width As Int = Root.Width
	Dim height As Int = Root.Height
	Dim headerH As Int = 50dip

	'Header com titulo e botao +
	Dim pnlHeader As Panel
	pnlHeader.Initialize("")
	pnlHeader.Color = ModTheme.Surface
	Root.AddView(pnlHeader, 0, 0, width, headerH)

	Dim lblTitle As Label
	lblTitle.Initialize("")
	lblTitle.Text = "SENHAS"
	lblTitle.TextSize = 12
	lblTitle.TextColor = ModTheme.TextMuted
	lblTitle.Typeface = Typeface.DEFAULT_BOLD
	lblTitle.Gravity = Gravity.CENTER_VERTICAL
	pnlHeader.AddView(lblTitle, 16dip, 0, width - 80dip, headerH)

	'Botao adicionar no header (circular)
	btnAdd.Initialize("btnAdd")
	btnAdd.Text = "+"
	btnAdd.TextSize = 22
	btnAdd.Color = ModTheme.Primary
	btnAdd.TextColor = Colors.White
	btnAdd.Gravity = Gravity.CENTER
	pnlHeader.AddView(btnAdd, width - 54dip, 7dip, 36dip, 36dip)

	'Separador
	Dim sep As Panel
	sep.Initialize("")
	sep.Color = ModTheme.CardBorder
	Root.AddView(sep, 0, headerH, width, 1dip)

	'Lista de senhas
	svEntries.Initialize(0)
	Root.AddView(svEntries, 0, headerH + 1dip, width, height - headerH - 1dip)

	pnlEntries = svEntries.Panel
	pnlEntries.Color = Colors.Transparent
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
	pnlEntries.RemoveAllViews

	Dim entries As List = ModPasswords.GetEntriesByGroup(CurrentGroupId)
	Dim width As Int = Root.Width
	Dim itemHeight As Int = 80dip
	Dim y As Int = 10dip

	If entries.Size = 0 Then
		Dim lblEmpty As B4XView = CreateLabel(ModLang.T("empty"), 14, False)
		lblEmpty.TextColor = ModTheme.TextMuted
		pnlEntries.AddView(lblEmpty, 0, 100dip, width, 40dip)
		pnlEntries.Height = 200dip
		Return
	End If

	For Each e As clsPasswordEntry In entries
		Dim pnlItem As Panel
		pnlItem.Initialize("pnlEntry")
		pnlItem.Tag = e.Id
		pnlItem.Color = ModTheme.CardBackground
		pnlEntries.AddView(pnlItem, 16dip, y, width - 32dip, itemHeight)

		'Favorito
		If e.IsFavorite Then
			Dim lblFav As Label
			lblFav.Initialize("")
			lblFav.Text = "*"
			lblFav.TextSize = 16
			lblFav.TextColor = ModTheme.Warning
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
		lblName.TextColor = ModTheme.TextPrimary
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
		lblUser.TextColor = ModTheme.TextSecondary
		pnlItem.AddView(lblUser, leftOffset, 42dip, width - 150dip, 20dip)

		'Botao copiar senha
		Dim btnCopy As Button
		btnCopy.Initialize("btnCopy")
		btnCopy.Text = ModLang.T("copy")
		btnCopy.Tag = e.Id
		btnCopy.TextSize = 12
		pnlItem.AddView(btnCopy, width - 120dip, 20dip, 70dip, 40dip)

		y = y + itemHeight + 8dip
	Next

	pnlEntries.Height = y + 20dip
End Sub

' ============================================
'  EVENTOS
' ============================================

Private Sub btnAdd_Click
	ModSession.Touch
	'Verifica se sessao esta ativa (frase em memoria)
	If ModSession.IsSessionActive = False Then
		ShowPassphraseDialog
	Else
		NavigateToAddPassword
	End If
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
	edtPassphrase.Initialize("")
	edtPassphrase.Hint = ModLang.T("passphrase_hint")
	edtPassphrase.SingleLine = True
	edtPassphrase.InputType = Bit.Or(edtPassphrase.INPUT_TYPE_TEXT, 128) 'Password
	edtPassphrase.Text = ""

	Dim pnl As B4XView = xui.CreatePanel("")
	pnl.SetLayoutAnimated(0, 0, 0, 280dip, 60dip)
	pnl.Color = ModTheme.Surface
	pnl.AddView(edtPassphrase, 10dip, 5dip, 260dip, 50dip)

	Dim dialog As B4XDialog
	dialog.Initialize(Root)
	dialog.Title = ModLang.T("enter_passphrase")

	Wait For (dialog.ShowCustom(pnl, ModLang.T("confirm"), "", ModLang.T("cancel"))) Complete (Result As Int)

	If Result = xui.DialogResponse_Positive Then
		Dim phrase As String = edtPassphrase.Text.Trim
		If phrase.Length >= 8 Then
			'Inicia sessao com frase em memoria
			ModSession.StartSession(phrase)
			'Agora permite criar senha
			NavigateToAddPassword
		Else
			ToastMessageShow(ModLang.T("passphrase_min_8"), True)
		End If
	End If
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

	Dim details As String = e.GetDisplayName & CRLF & CRLF
	If e.Url <> "" Then
		details = details & ModLang.T("url") & ": " & e.Url & CRLF
	End If
	details = details & ModLang.T("username") & ": " & username & CRLF
	details = details & ModLang.T("password") & ": " & password & CRLF

	If notes <> "" Then
		details = details & CRLF & ModLang.T("note") & ": " & notes
	End If

	Wait For (xui.Msgbox2Async(details, e.GetDisplayName, ModLang.T("copy"), ModLang.T("edit"), ModLang.T("close"), Null)) Msgbox_Result(Result As Int)

	If Result = xui.DialogResponse_Positive Then
		CopyPassword(entryId)
	Else If Result = xui.DialogResponse_Negative Then
		EditEntry(entryId)
	End If
End Sub

Private Sub ShowEntryOptions(entryId As String)
	Dim e As clsPasswordEntry = ModPasswords.GetEntryById(entryId)
	If e.IsInitialized = False Then Return

	Wait For (xui.Msgbox2Async(e.GetDisplayName, "", ModLang.T("edit"), ModLang.T("delete"), ModLang.T("cancel"), Null)) Msgbox_Result(Result As Int)

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
	Dim e As clsPasswordEntry = ModPasswords.GetEntryById(entryId)
	If e.IsInitialized = False Then Return

	Wait For (xui.Msgbox2Async(ModLang.T("confirm_delete_msg"), ModLang.T("confirm_delete"), ModLang.T("delete"), "", ModLang.T("cancel"), Null)) Msgbox_Result(Result As Int)

	If Result = xui.DialogResponse_Positive Then
		ModPasswords.DeleteEntry(entryId)
		LoadEntries
	End If
End Sub

' ============================================
'  TEMA
' ============================================

Private Sub ApplyTheme
	Root.Color = ModTheme.Background

	btnAdd.Color = ModTheme.Primary
	btnAdd.TextColor = Colors.White
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
