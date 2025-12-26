B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
'PagePasswords.bas - Lista de Grupos de Senhas
'LockZero - Exibe grupos e permite navegar para senhas

Sub Class_Globals
	Private Root As B4XView
	Private xui As XUI

	'UI
	Private btnAdd As Button

	Private svGroups As ScrollView
	Private pnlGroups As B4XView

	'Dialogs
	Private edtGroupName As EditText
	Private edtPassphrase As EditText
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
	CallSub2(Main, "SetPageTitle", ModLang.T("passwords"))

	ModSession.Touch
	LoadGroups
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
	lblTitle.Text = "GRUPOS"
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

	'Lista de grupos
	svGroups.Initialize(0)
	Root.AddView(svGroups, 0, headerH + 1dip, width, height - headerH - 1dip)

	pnlGroups = svGroups.Panel
	pnlGroups.Color = Colors.Transparent
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
'  CARREGAR GRUPOS
' ============================================

Private Sub LoadGroups
	ModPasswords.Init

	pnlGroups.RemoveAllViews

	Dim groups As List = ModPasswords.GetAllGroups
	Dim width As Int = Root.Width
	Dim itemHeight As Int = 70dip
	Dim y As Int = 10dip

	If groups.Size = 0 Then
		'Mensagem vazia
		Dim lblEmpty As B4XView = CreateLabel(ModLang.T("empty"), 14, False)
		lblEmpty.TextColor = ModTheme.TextMuted
		pnlGroups.AddView(lblEmpty, 0, 100dip, width, 40dip)
		pnlGroups.Height = 200dip
		Return
	End If

	For Each g As clsPasswordGroup In groups
		Dim pnlItem As Panel
		pnlItem.Initialize("pnlGroup")
		pnlItem.Tag = g.Id
		pnlItem.Color = ModTheme.CardBackground
		pnlGroups.AddView(pnlItem, 16dip, y, width - 32dip, itemHeight)

		'Nome do grupo
		Dim lblName As Label
		lblName.Initialize("")
		lblName.Text = g.Name
		lblName.TextSize = 16
		lblName.TextColor = ModTheme.TextPrimary
		lblName.Gravity = Gravity.CENTER_VERTICAL
		pnlItem.AddView(lblName, 16dip, 0, width - 120dip, itemHeight)

		'Contador de senhas
		Dim count As Int = ModPasswords.GetEntryCountByGroup(g.Id)
		Dim lblCount As Label
		lblCount.Initialize("")
		lblCount.Text = count
		lblCount.TextSize = 14
		lblCount.TextColor = ModTheme.TextSecondary
		lblCount.Gravity = Gravity.CENTER
		pnlItem.AddView(lblCount, width - 100dip, 0, 50dip, itemHeight)

		'Seta
		Dim lblArrow As Label
		lblArrow.Initialize("")
		lblArrow.Text = ">"
		lblArrow.TextSize = 18
		lblArrow.TextColor = ModTheme.TextMuted
		lblArrow.Gravity = Gravity.CENTER
		pnlItem.AddView(lblArrow, width - 60dip, 0, 30dip, itemHeight)

		y = y + itemHeight + 8dip
	Next

	pnlGroups.Height = y + 20dip
End Sub

' ============================================
'  EVENTOS
' ============================================

Private Sub btnAdd_Click
	ModSession.Touch
	ShowAddGroupDialog
End Sub

Private Sub pnlGroup_Click
	Dim pnl As Panel = Sender
	Dim groupId As String = pnl.Tag

	ModSession.Touch

	'Verifica se sessao ativa E se a frase confere com este grupo
	Dim g As clsPasswordGroup = ModPasswords.GetGroupById(groupId)
	If g.IsInitialized = False Then Return

	'Se grupo antigo sem TestValue, navega direto (compatibilidade)
	If g.TestValue = "" Then
		NavigateToGroup(groupId)
		Return
	End If

	'Precisa validar frase
	ShowUnlockGroupDialog(groupId)
End Sub

Private Sub ShowUnlockGroupDialog(groupId As String)
	Dim g As clsPasswordGroup = ModPasswords.GetGroupById(groupId)
	If g.IsInitialized = False Then Return

	'Verifica se esta em timeout
	Dim remainingDelay As Int = ModSecurity.GetRemainingDelay(groupId)
	If remainingDelay > 0 Then
		Dim attempts As Int = ModSecurity.GetFailedAttempts(groupId)
		Dim timeStr As String = ModSecurity.FormatDelay(remainingDelay)
		ToastMessageShow(ModLang.T("wait_timeout") & " " & timeStr & " (" & attempts & " " & ModLang.T("attempts") & ")", True)
		Return
	End If

	edtPassphrase.Initialize("")
	edtPassphrase.Hint = ModLang.T("passphrase_hint")
	edtPassphrase.SingleLine = True
	edtPassphrase.InputType = Bit.Or(edtPassphrase.INPUT_TYPE_TEXT, 128)
	edtPassphrase.Text = ""

	'Mostra tentativas restantes se ja houve falhas
	Dim attempts As Int = ModSecurity.GetFailedAttempts(groupId)
	Dim hintText As String = ""
	If attempts > 0 Then
		hintText = attempts & " " & ModLang.T("failed_attempts")
	End If

	Dim pnl As B4XView = xui.CreatePanel("")
	Dim pnlHeight As Int = 60dip
	If hintText <> "" Then pnlHeight = 85dip

	pnl.SetLayoutAnimated(0, 0, 0, 280dip, pnlHeight)
	pnl.Color = ModTheme.Surface
	pnl.AddView(edtPassphrase, 10dip, 5dip, 260dip, 50dip)

	If hintText <> "" Then
		Dim lblHint As Label
		lblHint.Initialize("")
		lblHint.Text = hintText
		lblHint.TextSize = 11
		lblHint.TextColor = ModTheme.Warning
		pnl.AddView(lblHint, 10dip, 58dip, 260dip, 20dip)
	End If

	Dim dialog As B4XDialog
	dialog.Initialize(Root)
	dialog.Title = g.Name & " - " & ModLang.T("enter_passphrase")

	Wait For (dialog.ShowCustom(pnl, ModLang.T("unlock"), "", ModLang.T("cancel"))) Complete (Result As Int)

	If Result = xui.DialogResponse_Positive Then
		Dim phrase As String = edtPassphrase.Text.Trim

		'Valida frase com TestValue do grupo
		If g.ValidatePhrase(phrase) Then
			'Frase correta - reseta tentativas e inicia sessao
			ModSecurity.ResetFailedAttempts(groupId)
			ModSession.StartSession(phrase)
			NavigateToGroup(groupId)
		Else
			'Frase incorreta - registra tentativa
			Dim delay As Int = ModSecurity.RegisterFailedAttempt(groupId)
			If delay > 0 Then
				Dim timeStr As String = ModSecurity.FormatDelay(delay)
				ToastMessageShow(ModLang.T("wrong_passphrase") & " - " & ModLang.T("wait_timeout") & " " & timeStr, True)
			Else
				ToastMessageShow(ModLang.T("wrong_passphrase"), True)
			End If
		End If
	End If
End Sub

Private Sub NavigateToGroup(groupId As String)
	Dim params As Map
	params.Initialize
	params.Put("groupId", groupId)

	Dim pg As PagePasswordList = B4XPages.GetPage("PagePasswordList")
	pg.SetParams(params)
	B4XPages.ShowPage("PagePasswordList")
End Sub

Private Sub pnlGroup_LongClick
	Dim pnl As Panel = Sender
	Dim groupId As String = pnl.Tag

	ShowGroupOptions(groupId)
End Sub

' ============================================
'  DIALOGS
' ============================================

Private Sub ShowAddGroupDialog
	'Prepara campos
	edtGroupName.Initialize("")
	edtGroupName.Hint = ModLang.T("group_name_hint")
	edtGroupName.SingleLine = True
	edtGroupName.InputType = Bit.Or(1, 8192) 'TEXT + CAP_WORDS
	edtGroupName.Text = ""

	edtPassphrase.Initialize("")
	edtPassphrase.Hint = ModLang.T("passphrase_hint")
	edtPassphrase.SingleLine = True
	edtPassphrase.InputType = Bit.Or(edtPassphrase.INPUT_TYPE_TEXT, 128) 'Password
	edtPassphrase.Text = ""

	'Labels
	Dim lblName As Label
	lblName.Initialize("")
	lblName.Text = ModLang.T("group_name_hint")
	lblName.TextSize = 12
	lblName.TextColor = ModTheme.TextSecondary

	Dim lblPhrase As Label
	lblPhrase.Initialize("")
	lblPhrase.Text = ModLang.T("passphrase_hint")
	lblPhrase.TextSize = 12
	lblPhrase.TextColor = ModTheme.TextSecondary

	'Cria painel com nome + frase
	Dim pnl As B4XView = xui.CreatePanel("")
	pnl.SetLayoutAnimated(0, 0, 0, 280dip, 160dip)
	pnl.Color = ModTheme.Surface
	pnl.AddView(lblName, 10dip, 5dip, 260dip, 18dip)
	pnl.AddView(edtGroupName, 10dip, 25dip, 260dip, 50dip)
	pnl.AddView(lblPhrase, 10dip, 85dip, 260dip, 18dip)
	pnl.AddView(edtPassphrase, 10dip, 105dip, 260dip, 50dip)

	'Mostra dialogo
	Dim dialog As B4XDialog
	dialog.Initialize(Root)
	dialog.Title = ModLang.T("new_group")

	Wait For (dialog.ShowCustom(pnl, ModLang.T("save"), "", ModLang.T("cancel"))) Complete (Result As Int)

	If Result = xui.DialogResponse_Positive Then
		Dim groupName As String = edtGroupName.Text.Trim
		Dim phrase As String = edtPassphrase.Text.Trim

		'Valida
		If groupName.Length = 0 Then
			ToastMessageShow(ModLang.T("error_empty_field"), True)
			Return
		End If
		If phrase.Length < 8 Then
			ToastMessageShow(ModLang.T("passphrase_min_8"), True)
			Return
		End If

		'Cria grupo com TestValue
		Dim g As clsPasswordGroup
		g.Initialize
		g.Name = groupName
		g.GenerateSalt
		g.CreateTestValue(phrase) 'Criptografa "LOCKZERO" com a frase
		ModPasswords.SaveGroup(g)

		'Inicia sessao com a frase
		ModSession.StartSession(phrase)

		LoadGroups
		ToastMessageShow(ModLang.T("success"), False)
	End If
End Sub

Private Sub ShowGroupOptions(groupId As String)
	Dim g As clsPasswordGroup = ModPasswords.GetGroupById(groupId)
	If g.IsInitialized = False Then Return

	Wait For (xui.Msgbox2Async(g.Name, "", ModLang.T("edit"), ModLang.T("delete"), ModLang.T("cancel"), Null)) Msgbox_Result(Result As Int)

	If Result = xui.DialogResponse_Positive Then
		'Editar
		ShowEditGroupDialog(groupId)
	Else If Result = xui.DialogResponse_Negative Then
		'Deletar
		ConfirmDeleteGroup(groupId)
	End If
End Sub

Private Sub ShowEditGroupDialog(groupId As String)
	Dim g As clsPasswordGroup = ModPasswords.GetGroupById(groupId)
	If g.IsInitialized = False Then Return

	'Prepara EditText com nome atual
	edtGroupName.Initialize("")
	edtGroupName.Text = g.Name
	edtGroupName.SingleLine = True
	edtGroupName.InputType = Bit.Or(1, 8192) 'TEXT + CAP_WORDS

	'Cria painel customizado
	Dim pnl As B4XView = xui.CreatePanel("")
	pnl.SetLayoutAnimated(0, 0, 0, 280dip, 60dip)
	pnl.Color = ModTheme.Surface
	pnl.AddView(edtGroupName, 10dip, 5dip, 260dip, 50dip)

	'Mostra dialogo
	Dim dialog As B4XDialog
	dialog.Initialize(Root)
	dialog.Title = ModLang.T("edit_group")

	Wait For (dialog.ShowCustom(pnl, ModLang.T("save"), "", ModLang.T("cancel"))) Complete (Result As Int)

	If Result = xui.DialogResponse_Positive Then
		Dim groupName As String = edtGroupName.Text.Trim
		If groupName.Length > 0 Then
			g.Name = groupName
			ModPasswords.SaveGroup(g)
			LoadGroups
			ToastMessageShow(ModLang.T("success"), False)
		Else
			ToastMessageShow(ModLang.T("error_empty_field"), True)
		End If
	End If
End Sub

Private Sub ConfirmDeleteGroup(groupId As String)
	Dim g As clsPasswordGroup = ModPasswords.GetGroupById(groupId)
	If g.IsInitialized = False Then Return

	Dim count As Int = ModPasswords.GetEntryCountByGroup(groupId)
	Dim msg As String = ModLang.T("confirm_delete_msg")
	If count > 0 Then
		msg = msg & CRLF & CRLF & count & " " & ModLang.T("passwords") & " serao excluidas!"
	End If

	Wait For (xui.Msgbox2Async(msg, ModLang.T("confirm_delete"), ModLang.T("delete"), "", ModLang.T("cancel"), Null)) Msgbox_Result(Result As Int)

	If Result = xui.DialogResponse_Positive Then
		ModPasswords.DeleteGroup(groupId)
		LoadGroups
	End If
End Sub

' ============================================
'  TEMA
' ============================================

Private Sub ApplyTheme
	Root.Color = ModTheme.Background
End Sub

