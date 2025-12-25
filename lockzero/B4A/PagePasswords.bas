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
	Private pnlHeader As B4XView
	Private lblTitle As B4XView
	Private btnBack As Button
	Private btnAdd As Button

	Private svGroups As ScrollView
	Private pnlGroups As B4XView

	'Dialogs
	Private edtGroupName As EditText
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
	LoadGroups
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

	lblTitle = CreateLabel(ModLang.T("passwords"), 18, True)
	lblTitle.SetTextAlignment("CENTER", "LEFT")
	pnlHeader.AddView(lblTitle, 56dip, 0, width - 112dip, 56dip)

	btnAdd.Initialize("btnAdd")
	btnAdd.Text = "+"
	pnlHeader.AddView(btnAdd, width - 48dip, 8dip, 40dip, 40dip)

	'Lista de grupos
	svGroups.Initialize(0)
	Root.AddView(svGroups, 0, 56dip, width, height - 56dip)

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

Private Sub btnBack_Click
	B4XPages.ClosePage(Me)
End Sub

Private Sub btnAdd_Click
	ShowAddGroupDialog
End Sub

Private Sub pnlGroup_Click
	Dim pnl As Panel = Sender
	Dim groupId As String = pnl.Tag

	ModSession.Touch

	'Navega para lista de senhas do grupo
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
	'Prepara EditText
	edtGroupName.Initialize("")
	edtGroupName.Hint = ModLang.T("group_name_hint")
	edtGroupName.SingleLine = True
	edtGroupName.Text = ""

	'Cria painel customizado
	Dim pnl As B4XView = xui.CreatePanel("")
	pnl.SetLayoutAnimated(0, 0, 0, 280dip, 60dip)
	pnl.Color = ModTheme.Surface
	pnl.AddView(edtGroupName, 10dip, 5dip, 260dip, 50dip)

	'Mostra dialogo
	Dim dialog As B4XDialog
	dialog.Initialize(Root)
	dialog.Title = ModLang.T("new_group")

	Wait For (dialog.ShowCustom(pnl, ModLang.T("save"), "", ModLang.T("cancel"))) Complete (Result As Int)

	If Result = xui.DialogResponse_Positive Then
		Dim groupName As String = edtGroupName.Text.Trim
		If groupName.Length > 0 Then
			'Cria grupo
			Dim g As clsPasswordGroup
			g.Initialize
			g.Name = groupName
			g.GenerateSalt
			ModPasswords.SaveGroup(g)
			LoadGroups
			ToastMessageShow(ModLang.T("success"), False)
		Else
			ToastMessageShow(ModLang.T("error_empty_field"), True)
		End If
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

	pnlHeader.Color = ModTheme.Surface
	lblTitle.TextColor = ModTheme.TextPrimary

	btnBack.Color = ModTheme.ButtonSecondary
	btnBack.TextColor = ModTheme.TextPrimary

	btnAdd.Color = ModTheme.Primary
	btnAdd.TextColor = Colors.White
End Sub
