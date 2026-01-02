B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
'PageNotesGroups.bas - Lista de Grupos de Notas
'LockZero - Exibe grupos de notas (abertos e seguros)

Sub Class_Globals
	Public Root As B4XView  'Public para transicoes
	Private xui As XUI

	'UI
	Private btnBack As Button
	Private lblHeaderTitle As Label
	Private svGroups As ScrollView
	Private pnlGroups As B4XView

	'Dialog Overlay
	Private pnlOverlay As Panel
	Private pnlDialog As Panel
	Private edtGroupName As EditText
	Private edtPassphrase As EditText
	Private chkSecure As CheckBox
	Private btnShowPass As Button
	Private IsPassVisible As Boolean = False
	Private pnlPhraseArea As Panel  'Container do campo de frase
	Private lblPhraseLabel As Label  'Label "Frase"
	Private CurrentDialogMode As String = "" 'add_group, unlock_group, edit_group
	Private CurrentGroupId As String = ""

	'Timer de sessao no header
	Private lblSessionTimer As Label
	Private tmrSession As Timer

	'Flag para evitar navegacao dupla
	Private IsNavigating As Boolean = False
End Sub

Public Sub Initialize
	tmrSession.Initialize("tmrSession", 1000)
End Sub

Private Sub B4XPage_Created(Root1 As B4XView)
	Root = Root1
	CreateUI
	ApplyTheme
End Sub

Private Sub B4XPage_Appear

	'Reset da flag de navegacao
	IsNavigating = False

	'Define titulo na ActionBar
	CallSub2(Main, "SetPageTitle", ModLang.T("note_groups"))

	ModSession.Touch
	LoadGroups

	'Inicia timer de sessao
	UpdateSessionTimer
	tmrSession.Enabled = True
End Sub

Private Sub B4XPage_Disappear
	tmrSession.Enabled = False
End Sub

' ============================================
'  CRIAR UI
' ============================================

Private Sub CreateUI
	Dim width As Int = Root.Width
	Dim height As Int = Root.Height
	Dim headerH As Int = 56dip

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

	'Titulo
	lblHeaderTitle.Initialize("")
	lblHeaderTitle.Text = ModLang.T("note_groups")
	lblHeaderTitle.TextSize = Starter.FONT_BODY
	lblHeaderTitle.TextColor = Colors.White
	lblHeaderTitle.Typeface = Typeface.DEFAULT_BOLD
	lblHeaderTitle.Gravity = Gravity.CENTER_VERTICAL
	pnlHeader.AddView(lblHeaderTitle, 50dip, 0, width - 160dip, headerH)

	'Timer de sessao no header
	lblSessionTimer.Initialize("lblSessionTimer")
	lblSessionTimer.Text = "00:00"
	lblSessionTimer.TextSize = Starter.FONT_CAPTION
	lblSessionTimer.TextColor = Colors.ARGB(200, 255, 255, 255)
	lblSessionTimer.Gravity = Gravity.CENTER
	pnlHeader.AddView(lblSessionTimer, width - 110dip, 12dip, 55dip, 32dip)

	'Fundo arredondado para o timer
	Dim xvTimer As B4XView = lblSessionTimer
	xvTimer.SetColorAndBorder(Colors.ARGB(60, 255, 255, 255), 0, Colors.Transparent, 8dip)

	'Botao adicionar no header
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

	'Lista de grupos
	svGroups.Initialize(0)
	svGroups.Color = ModTheme.HomeBg
	Root.AddView(svGroups, 0, headerH, width, height - headerH)

	pnlGroups = svGroups.Panel
	pnlGroups.Color = ModTheme.HomeBg

	'Overlay para dialogs (invisivel por padrao)
	CreateDialogOverlay
End Sub

Private Sub CreateDialogOverlay
	Dim width As Int = Root.Width
	Dim height As Int = Root.Height

	'Fundo escuro semi-transparente
	pnlOverlay.Initialize("pnlOverlay")
	pnlOverlay.Color = Colors.ARGB(180, 0, 0, 0)
	pnlOverlay.Visible = False
	Root.AddView(pnlOverlay, 0, 0, width, height)

	'Dialog centralizado
	Dim dialogW As Int = width - 40dip
	Dim dialogH As Int = 280dip
	Dim dialogX As Int = 20dip
	Dim dialogY As Int = 60dip

	pnlDialog.Initialize("")
	pnlDialog.Color = ModTheme.HomeHeaderBg
	pnlOverlay.AddView(pnlDialog, dialogX, dialogY, dialogW, dialogH)

	'Arredondar cantos do dialog
	Dim xvDialog As B4XView = pnlDialog
	xvDialog.SetColorAndBorder(ModTheme.HomeHeaderBg, 0, ModTheme.HomeHeaderBg, 12dip)
End Sub

' ============================================
'  CARREGAR GRUPOS
' ============================================

Private Sub LoadGroups
	ModNotes.Init

	pnlGroups.RemoveAllViews

	Dim groups As List = ModNotes.GetAllNoteGroups
	Dim width As Int = Root.Width
	Dim itemHeight As Int = 70dip
	Dim y As Int = 16dip

	If groups.Size = 0 Then
		'Mensagem vazia
		Dim lblEmpty As Label
		lblEmpty.Initialize("")
		lblEmpty.Text = ModLang.T("note_group_empty")
		lblEmpty.TextSize = Starter.FONT_BUTTON
		lblEmpty.TextColor = Colors.ARGB(150, 255, 255, 255)
		lblEmpty.Gravity = Gravity.CENTER
		pnlGroups.AddView(lblEmpty, 0, 100dip, width, 40dip)
		pnlGroups.Height = 200dip
		Return
	End If

	For Each g As clsNoteGroup In groups
		Dim pnlItem As Panel
		pnlItem.Initialize("pnlGroup")
		pnlItem.Tag = g.Id

		'Card com cor da Home e cantos arredondados
		Dim xvItem As B4XView = pnlItem
		xvItem.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModTheme.HomeIconBg, 12dip)
		pnlGroups.AddView(pnlItem, 16dip, y, width - 32dip, itemHeight)

		'Nome do grupo (g.Icon ja inclui cadeado se seguro)
		Dim lblName As Label
		lblName.Initialize("")
		lblName.Text = g.Icon & " " & g.Name
		lblName.TextSize = Starter.FONT_BODY
		lblName.TextColor = Colors.White
		lblName.Typeface = Typeface.DEFAULT_BOLD
		lblName.Gravity = Gravity.CENTER_VERTICAL
		pnlItem.AddView(lblName, 16dip, 0, width - 140dip, itemHeight)

		'Contador de notas
		Dim count As Int = ModNotes.CountByGroup(g.Id)
		Dim lblCount As Label
		lblCount.Initialize("")
		lblCount.Text = "(" & count & ")"
		lblCount.TextSize = Starter.FONT_BUTTON
		lblCount.TextColor = Colors.ARGB(180, 255, 255, 255)
		lblCount.Gravity = Gravity.CENTER
		pnlItem.AddView(lblCount, width - 110dip, 0, 40dip, itemHeight)

		'Seta
		Dim lblArrow As Label
		lblArrow.Initialize("")
		lblArrow.Text = ">"
		lblArrow.TextSize = 18
		lblArrow.TextColor = Colors.ARGB(150, 255, 255, 255)
		lblArrow.Gravity = Gravity.CENTER
		pnlItem.AddView(lblArrow, width - 70dip, 0, 30dip, itemHeight)

		y = y + itemHeight + 12dip
	Next

	pnlGroups.Height = y + 20dip
End Sub

' ============================================
'  EVENTOS
' ============================================

Private Sub btnBack_Click
	B4XPages.ClosePage(Me)
End Sub

Private Sub btnAdd_Click
	ModSession.Touch
	ShowAddGroupDialog
End Sub

Private Sub pnlOverlay_Click
	'Fecha dialog ao clicar fora
	HideDialog
End Sub

Private Sub pnlGroup_Click
	Dim pnl As Panel = Sender
	Dim groupId As String = pnl.Tag

	Dim g As clsNoteGroup = ModNotes.GetNoteGroupById(groupId)
	If g.IsInitialized = False Then Return

	'Grupo ABERTO - acesso direto
	If g.IsSecure = False Then
		NavigateToGroup(groupId)
		Return
	End If

	'Grupo SEGURO - verifica sessao
	If ModSession.IsSessionActive Then
		ModSession.Touch
		NavigateToGroup(groupId)
		Return
	End If

	'Sessao inativa - pede frase
	ShowUnlockGroupDialog(groupId)
End Sub

Private Sub pnlGroup_LongClick
	Dim pnl As Panel = Sender
	Dim groupId As String = pnl.Tag
	ShowGroupOptions(groupId)
End Sub

Private Sub NavigateToGroup(groupId As String)
	'Evita navegacao dupla
	If IsNavigating Then Return
	IsNavigating = True

	Dim params As Map
	params.Initialize
	params.Put("groupId", groupId)
	params.Put("isNoteGroup", True)  'Flag para indicar que e grupo de notas

	Dim pg As PageNotesList = B4XPages.GetPage("PageNotesList")
	pg.SetParams(params)
	B4XPages.ShowPage("PageNotesList")
	pg.AnimateIn
End Sub

' ============================================
'  DIALOGS
' ============================================

Private Sub ShowAddGroupDialog
	CurrentDialogMode = "add_group"
	CurrentGroupId = ""
	IsPassVisible = False

	Dim dialogW As Int = Root.Width - 40dip
	pnlDialog.RemoveAllViews

	'Titulo
	Dim lblTitle As Label
	lblTitle.Initialize("")
	lblTitle.Text = ModLang.T("note_group_new")
	lblTitle.TextSize = 16
	lblTitle.TextColor = Colors.White
	lblTitle.Typeface = Typeface.DEFAULT_BOLD
	lblTitle.Gravity = Gravity.CENTER_HORIZONTAL
	pnlDialog.AddView(lblTitle, 0, 12dip, dialogW, 24dip)

	Dim top As Int = 45dip

	'Campo nome do grupo
	Dim lblName As Label
	lblName.Initialize("")
	lblName.Text = ModLang.T("note_group_name")
	lblName.TextSize = 12
	lblName.TextColor = Colors.ARGB(180, 255, 255, 255)
	pnlDialog.AddView(lblName, 16dip, top, dialogW - 32dip, 18dip)
	top = top + 20dip

	edtGroupName.Initialize("edtGroupName")
	edtGroupName.Hint = ModLang.T("note_group_name")
	edtGroupName.SingleLine = True
	edtGroupName.InputType = Bit.Or(1, 8192)  'TEXT + CAP_WORDS
	edtGroupName.Text = ""
	edtGroupName.TextColor = Colors.White
	edtGroupName.HintColor = Colors.ARGB(120, 255, 255, 255)

	Dim pnlName As Panel
	pnlName.Initialize("")
	pnlName.Color = ModTheme.HomeBg
	pnlDialog.AddView(pnlName, 16dip, top, dialogW - 32dip, 44dip)
	pnlName.AddView(edtGroupName, 8dip, 0, dialogW - 32dip - 16dip, 44dip)
	top = top + 50dip

	'Checkbox seguro (emoji sera automatico baseado nisso)
	chkSecure.Initialize("chkSecure")
	chkSecure.Text = ModLang.T("note_group_secure")
	chkSecure.TextSize = 14
	chkSecure.TextColor = Colors.White
	chkSecure.Checked = True  'Default: seguro
	pnlDialog.AddView(chkSecure, 16dip, top, dialogW - 32dip, 40dip)
	top = top + 45dip

	'Campo frase (apenas se seguro)
	lblPhraseLabel.Initialize("")
	lblPhraseLabel.Text = ModLang.T("passphrase_hint")
	lblPhraseLabel.TextSize = 12
	lblPhraseLabel.TextColor = Colors.ARGB(180, 255, 255, 255)
	pnlDialog.AddView(lblPhraseLabel, 16dip, top, dialogW - 32dip, 18dip)
	top = top + 20dip

	pnlPhraseArea.Initialize("")
	pnlPhraseArea.Color = ModTheme.HomeBg
	pnlDialog.AddView(pnlPhraseArea, 16dip, top, dialogW - 32dip, 44dip)

	edtPassphrase.Initialize("edtPassphrase")
	edtPassphrase.Hint = ModLang.T("passphrase_hint")
	edtPassphrase.SingleLine = True
	edtPassphrase.InputType = Bit.Or(1, 128)
	edtPassphrase.Text = ""
	edtPassphrase.TextColor = Colors.White
	edtPassphrase.HintColor = Colors.ARGB(120, 255, 255, 255)
	pnlPhraseArea.AddView(edtPassphrase, 8dip, 0, dialogW - 32dip - 56dip, 44dip)

	btnShowPass.Initialize("btnShowPass")
	btnShowPass.Text = ModLang.T("view")
	btnShowPass.TextSize = Starter.FONT_CAPTION
	btnShowPass.Color = Colors.Transparent
	btnShowPass.TextColor = Colors.ARGB(200, 255, 255, 255)
	btnShowPass.Gravity = Gravity.CENTER
	pnlPhraseArea.AddView(btnShowPass, dialogW - 32dip - 65dip, 2dip, 60dip, 40dip)
	top = top + 55dip

	'Botoes
	Dim btnCancel As Button
	btnCancel.Initialize("btnDialogCancel")
	btnCancel.Text = ModLang.T("cancel")
	btnCancel.TextSize = 13
	btnCancel.Color = Colors.Transparent
	btnCancel.TextColor = Colors.ARGB(200, 255, 255, 255)
	pnlDialog.AddView(btnCancel, 16dip, top, 100dip, 40dip)

	Dim btnOk As Button
	btnOk.Initialize("btnDialogOk")
	btnOk.Text = ModLang.T("save")
	btnOk.TextSize = 13
	btnOk.Color = ModTheme.HomeIconBg
	btnOk.TextColor = Colors.White
	pnlDialog.AddView(btnOk, dialogW - 116dip, top, 100dip, 40dip)
	top = top + 50dip

	'Ajusta altura do dialog
	pnlDialog.SetLayoutAnimated(0, 20dip, 40dip, dialogW, top)

	pnlOverlay.Visible = True
	pnlOverlay.BringToFront
	edtGroupName.RequestFocus
End Sub

Private Sub chkSecure_CheckedChange(Checked As Boolean)
	'Mostra/esconde campo de frase baseado no checkbox
	If lblPhraseLabel.IsInitialized And pnlPhraseArea.IsInitialized Then
		lblPhraseLabel.Visible = Checked
		pnlPhraseArea.Visible = Checked
		If Not(Checked) Then
			edtPassphrase.Text = ""  'Limpa frase se desmarcar
		End If
	End If
End Sub

Private Sub ShowUnlockGroupDialog(groupId As String)
	Dim g As clsNoteGroup = ModNotes.GetNoteGroupById(groupId)
	If g.IsInitialized = False Then Return

	'Verifica timeout
	Dim remainingDelay As Int = ModSecurity.GetRemainingDelay(groupId)
	If remainingDelay > 0 Then
		Dim attempts As Int = ModSecurity.GetFailedAttempts(groupId)
		Dim timeStr As String = ModSecurity.FormatDelay(remainingDelay)
		ToastMessageShow(ModLang.T("wait_timeout") & " " & timeStr, True)
		Return
	End If

	CurrentDialogMode = "unlock_group"
	CurrentGroupId = groupId
	IsPassVisible = False

	Dim dialogW As Int = Root.Width - 40dip
	pnlDialog.RemoveAllViews

	'Titulo
	Dim lblTitle As Label
	lblTitle.Initialize("")
	lblTitle.Text = g.Icon & " " & g.Name
	lblTitle.TextSize = 16
	lblTitle.TextColor = Colors.White
	lblTitle.Typeface = Typeface.DEFAULT_BOLD
	lblTitle.Gravity = Gravity.CENTER_HORIZONTAL
	pnlDialog.AddView(lblTitle, 0, 12dip, dialogW, 24dip)

	'Subtitulo
	Dim lblSub As Label
	lblSub.Initialize("")
	lblSub.Text = ModLang.T("enter_passphrase")
	lblSub.TextSize = 12
	lblSub.TextColor = Colors.ARGB(180, 255, 255, 255)
	lblSub.Gravity = Gravity.CENTER_HORIZONTAL
	pnlDialog.AddView(lblSub, 0, 36dip, dialogW, 20dip)

	'Campo de frase
	Dim pnlInput As Panel
	pnlInput.Initialize("")
	pnlInput.Color = ModTheme.HomeBg
	pnlDialog.AddView(pnlInput, 16dip, 65dip, dialogW - 32dip, 50dip)

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

	'Tentativas falhas
	Dim attempts As Int = ModSecurity.GetFailedAttempts(groupId)
	If attempts > 0 Then
		Dim lblWarn As Label
		lblWarn.Initialize("")
		lblWarn.Text = attempts & " " & ModLang.T("failed_attempts")
		lblWarn.TextSize = 11
		lblWarn.TextColor = ModTheme.Warning
		lblWarn.Gravity = Gravity.CENTER_HORIZONTAL
		pnlDialog.AddView(lblWarn, 0, 120dip, dialogW, 18dip)
	End If

	'Botoes
	Dim btnCancel As Button
	btnCancel.Initialize("btnDialogCancel")
	btnCancel.Text = ModLang.T("cancel")
	btnCancel.TextSize = 13
	btnCancel.Color = Colors.Transparent
	btnCancel.TextColor = Colors.ARGB(200, 255, 255, 255)
	pnlDialog.AddView(btnCancel, 16dip, 145dip, 100dip, 40dip)

	Dim btnOk As Button
	btnOk.Initialize("btnDialogOk")
	btnOk.Text = ModLang.T("unlock")
	btnOk.TextSize = 12
	btnOk.Color = ModTheme.HomeIconBg
	btnOk.TextColor = Colors.White
	pnlDialog.AddView(btnOk, dialogW - 130dip, 145dip, 114dip, 40dip)

	pnlDialog.SetLayoutAnimated(0, 20dip, 80dip, dialogW, 195dip)

	pnlOverlay.Visible = True
	pnlOverlay.BringToFront
	edtPassphrase.RequestFocus
End Sub

Private Sub ShowGroupOptions(groupId As String)
	Dim g As clsNoteGroup = ModNotes.GetNoteGroupById(groupId)
	If g.IsInitialized = False Then Return

	Wait For (xui.Msgbox2Async(g.Name, "", ModLang.T("edit"), ModLang.T("cancel"), ModLang.T("delete"), Null)) Msgbox_Result(Result As Int)

	If Result = xui.DialogResponse_Positive Then
		ShowEditGroupDialog(groupId)
	Else If Result = xui.DialogResponse_Negative Then
		ConfirmDeleteGroup(groupId)
	End If
End Sub

Private Sub ShowEditGroupDialog(groupId As String)
	Dim g As clsNoteGroup = ModNotes.GetNoteGroupById(groupId)
	If g.IsInitialized = False Then Return

	CurrentDialogMode = "edit_group"
	CurrentGroupId = groupId

	Dim dialogW As Int = Root.Width - 40dip
	pnlDialog.RemoveAllViews

	'Titulo
	Dim lblTitle As Label
	lblTitle.Initialize("")
	lblTitle.Text = ModLang.T("edit_group")
	lblTitle.TextSize = 16
	lblTitle.TextColor = Colors.White
	lblTitle.Typeface = Typeface.DEFAULT_BOLD
	lblTitle.Gravity = Gravity.CENTER_HORIZONTAL
	pnlDialog.AddView(lblTitle, 0, 12dip, dialogW, 24dip)

	Dim top As Int = 45dip

	'Campo nome
	Dim lblName As Label
	lblName.Initialize("")
	lblName.Text = ModLang.T("note_group_name")
	lblName.TextSize = 12
	lblName.TextColor = Colors.ARGB(180, 255, 255, 255)
	pnlDialog.AddView(lblName, 16dip, top, dialogW - 32dip, 18dip)
	top = top + 20dip

	Dim pnlName As Panel
	pnlName.Initialize("")
	pnlName.Color = ModTheme.HomeBg
	pnlDialog.AddView(pnlName, 16dip, top, dialogW - 32dip, 44dip)

	edtGroupName.Initialize("edtGroupName")
	edtGroupName.Text = g.Name
	edtGroupName.SingleLine = True
	edtGroupName.InputType = Bit.Or(1, 8192)  'TEXT + CAP_WORDS
	edtGroupName.TextColor = Colors.White
	edtGroupName.HintColor = Colors.ARGB(120, 255, 255, 255)
	pnlName.AddView(edtGroupName, 8dip, 0, dialogW - 32dip - 16dip, 44dip)
	top = top + 50dip

	'Botoes (emoji e automatico, nao editavel)
	Dim btnCancel As Button
	btnCancel.Initialize("btnDialogCancel")
	btnCancel.Text = ModLang.T("cancel")
	btnCancel.TextSize = 13
	btnCancel.Color = Colors.Transparent
	btnCancel.TextColor = Colors.ARGB(200, 255, 255, 255)
	pnlDialog.AddView(btnCancel, 16dip, top, 100dip, 40dip)

	Dim btnOk As Button
	btnOk.Initialize("btnDialogOk")
	btnOk.Text = ModLang.T("save")
	btnOk.TextSize = 13
	btnOk.Color = ModTheme.HomeIconBg
	btnOk.TextColor = Colors.White
	pnlDialog.AddView(btnOk, dialogW - 116dip, top, 100dip, 40dip)
	top = top + 50dip

	pnlDialog.SetLayoutAnimated(0, 20dip, 80dip, dialogW, top)

	pnlOverlay.Visible = True
	pnlOverlay.BringToFront
	edtGroupName.RequestFocus
End Sub

Private Sub ConfirmDeleteGroup(groupId As String)
	Dim g As clsNoteGroup = ModNotes.GetNoteGroupById(groupId)
	If g.IsInitialized = False Then Return

	Dim count As Int = ModNotes.CountByGroup(groupId)
	Dim msg As String = ModLang.T("note_group_delete_confirm")
	If count > 0 Then
		msg = msg & CRLF & CRLF & count & " " & ModLang.T("notes") & "!"
	End If

	Wait For (xui.Msgbox2Async(msg, ModLang.T("note_group_delete"), ModLang.T("delete"), "", ModLang.T("cancel"), Null)) Msgbox_Result(Result As Int)

	If Result = xui.DialogResponse_Positive Then
		'Se grupo seguro, pede frase para confirmar
		If g.IsSecure Then
			ShowDeleteGroupDialog(groupId)
		Else
			'Grupo aberto - deleta direto
			ModNotes.DeleteNoteGroup(groupId)
			LoadGroups
			ToastMessageShow(ModLang.T("success"), False)
		End If
	End If
End Sub

Private Sub ShowDeleteGroupDialog(groupId As String)
	Dim g As clsNoteGroup = ModNotes.GetNoteGroupById(groupId)
	If g.IsInitialized = False Then Return

	CurrentDialogMode = "delete_group"
	CurrentGroupId = groupId
	IsPassVisible = False

	Dim dialogW As Int = Root.Width - 40dip
	pnlDialog.RemoveAllViews

	'Titulo
	Dim lblTitle As Label
	lblTitle.Initialize("")
	lblTitle.Text = ModLang.T("confirm_delete")
	lblTitle.TextSize = 16
	lblTitle.TextColor = Colors.White
	lblTitle.Typeface = Typeface.DEFAULT_BOLD
	lblTitle.Gravity = Gravity.CENTER_HORIZONTAL
	pnlDialog.AddView(lblTitle, 0, 12dip, dialogW, 24dip)

	'Subtitulo
	Dim lblSub As Label
	lblSub.Initialize("")
	lblSub.Text = g.Name & CRLF & ModLang.T("enter_passphrase")
	lblSub.TextSize = 12
	lblSub.TextColor = Colors.ARGB(180, 255, 255, 255)
	lblSub.Gravity = Gravity.CENTER_HORIZONTAL
	pnlDialog.AddView(lblSub, 0, 36dip, dialogW, 40dip)

	'Campo frase
	Dim pnlInput As Panel
	pnlInput.Initialize("")
	pnlInput.Color = ModTheme.HomeBg
	pnlDialog.AddView(pnlInput, 16dip, 85dip, dialogW - 32dip, 50dip)

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
	pnlDialog.AddView(btnCancel, 16dip, 150dip, 100dip, 40dip)

	Dim btnOk As Button
	btnOk.Initialize("btnDialogOk")
	btnOk.Text = ModLang.T("delete")
	btnOk.TextSize = 12
	btnOk.Color = ModTheme.Danger
	btnOk.TextColor = Colors.White
	pnlDialog.AddView(btnOk, dialogW - 130dip, 150dip, 114dip, 40dip)

	pnlDialog.SetLayoutAnimated(0, 20dip, 80dip, dialogW, 200dip)

	pnlOverlay.Visible = True
	pnlOverlay.BringToFront
	edtPassphrase.RequestFocus
End Sub

' ============================================
'  EVENTOS DO DIALOG
' ============================================

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
	Select CurrentDialogMode
		Case "add_group"
			ProcessAddGroup
		Case "unlock_group"
			ProcessUnlockGroup
		Case "edit_group"
			ProcessEditGroup
		Case "delete_group"
			ProcessDeleteGroup
	End Select
End Sub

Private Sub HideDialog
	pnlOverlay.Visible = False
	CurrentDialogMode = ""
	Dim ime As IME
	ime.Initialize("")
	ime.HideKeyboard
End Sub

Private Sub ProcessAddGroup
	Dim groupName As String = edtGroupName.Text.Trim
	Dim isSecure As Boolean = chkSecure.Checked
	'Icone automatico baseado no tipo
	Dim groupIcon As String
	If isSecure Then
		groupIcon = Chr(0xD83D) & Chr(0xDD12)  '🔒 cadeado
	Else
		groupIcon = Chr(0xD83D) & Chr(0xDCDD)  '📝 nota
	End If
	Dim phrase As String = edtPassphrase.Text.Trim

	'Valida nome
	If groupName.Length = 0 Then
		ToastMessageShow(ModLang.T("error_empty_field"), True)
		Return
	End If

	'Se grupo seguro, valida frase
	If isSecure Then
		Dim phraseError As String = ModSecurity.GetPassphraseError(phrase)
		If phraseError.Length > 0 Then
			ToastMessageShow(phraseError, True)
			Return
		End If
	End If

	'Cria grupo
	Dim g As clsNoteGroup
	g.Initialize
	g.Name = groupName
	g.Icon = groupIcon
	g.IsSecure = isSecure

	'Se seguro, configura seguranca
	If isSecure Then
		g.SetupSecurity(phrase)
		'Inicia sessao com a frase (categoria: notes)
		ModSession.StartSessionWithCategory(phrase, "notes")
	End If

	ModNotes.SaveNoteGroup(g)

	HideDialog
	LoadGroups

	'Navega automaticamente para o grupo criado
	NavigateToGroup(g.Id)
End Sub

Private Sub ProcessUnlockGroup
	Dim phrase As String = edtPassphrase.Text.Trim
	Dim g As clsNoteGroup = ModNotes.GetNoteGroupById(CurrentGroupId)

	If g.IsInitialized = False Then
		HideDialog
		Return
	End If

	'Valida frase
	If g.ValidatePhrase(phrase) Then
		ModSecurity.ResetFailedAttempts(CurrentGroupId)
		ModSession.StartSessionWithCategory(phrase, "notes")
		HideDialog
		NavigateToGroup(CurrentGroupId)
	Else
		Dim delay As Int = ModSecurity.RegisterFailedAttempt(CurrentGroupId)
		If delay > 0 Then
			Dim timeStr As String = ModSecurity.FormatDelay(delay)
			ToastMessageShow(ModLang.T("wrong_passphrase") & " - " & ModLang.T("wait_timeout") & " " & timeStr, True)
			HideDialog
		Else
			ToastMessageShow(ModLang.T("wrong_passphrase"), True)
		End If
		edtPassphrase.Text = ""
	End If
End Sub

Private Sub ProcessEditGroup
	Dim groupName As String = edtGroupName.Text.Trim
	Dim g As clsNoteGroup = ModNotes.GetNoteGroupById(CurrentGroupId)

	If g.IsInitialized = False Then
		HideDialog
		Return
	End If

	If groupName.Length > 0 Then
		g.Name = groupName
		'Icone mantem o existente (automatico baseado no tipo)
		ModNotes.SaveNoteGroup(g)
		HideDialog
		LoadGroups
		ToastMessageShow(ModLang.T("success"), False)
	Else
		ToastMessageShow(ModLang.T("error_empty_field"), True)
	End If
End Sub

Private Sub ProcessDeleteGroup
	Dim phrase As String = edtPassphrase.Text.Trim
	Dim g As clsNoteGroup = ModNotes.GetNoteGroupById(CurrentGroupId)

	If g.IsInitialized = False Then
		HideDialog
		Return
	End If

	'Valida frase
	If g.ValidatePhrase(phrase) Then
		ModNotes.DeleteNoteGroup(CurrentGroupId)
		HideDialog
		LoadGroups
		ToastMessageShow(ModLang.T("success"), False)
	Else
		ToastMessageShow(ModLang.T("wrong_passphrase"), True)
		edtPassphrase.Text = ""
	End If
End Sub

' ============================================
'  TEMA
' ============================================

Private Sub ApplyTheme
	Root.Color = ModTheme.HomeBg
End Sub

' ============================================
'  TIMER DE SESSAO
' ============================================

Private Sub tmrSession_Tick
	UpdateSessionTimer
End Sub

Private Sub UpdateSessionTimer
	If ModSession.IsSessionActive Then
		lblSessionTimer.Text = ModSession.GetRemainingFormatted

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

Private Sub lblSessionTimer_Click
	Wait For (xui.Msgbox2Async(ModLang.T("lock_confirm_msg"), ModLang.T("lock"), ModLang.T("yes"), "", ModLang.T("cancel"), Null)) Msgbox_Result(Result As Int)

	If Result = xui.DialogResponse_Positive Then
		tmrSession.Enabled = False
		ModSession.EndSession
		B4XPages.ClosePage(Me)
	End If
End Sub

' ============================================
'  UTILIDADES
' ============================================

