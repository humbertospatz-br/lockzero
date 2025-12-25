B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=13.4
@EndOfDesignText@
'ActPasswordGroups.bas - Lista de Grupos de Senhas
'LockSeed - Gerenciador de senhas estilo Google Password

#Region  Activity Attributes
	#FullScreen: False
	#IncludeTitle: False
#End Region

Sub Process_Globals
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

	' Lista de grupos
	Private svGroups As ScrollView

	' Dialog novo grupo
	Private pnlGroupDialog As Panel
	Private edtGroupName As EditText
	Private btnGroupSave As Button
	Private btnGroupCancel As Button

	' Dialog configuracao
	Private pnlConfigDialog As Panel
	Private spnSessionTime As Spinner
	Private btnConfigSave As Button
	Private btnConfigCancel As Button

	' Estado
	Private EditingGroupId As String = ""
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.Color = ModTheme.GetBackgroundColor

	' Inicializa ModPasswords se necessario
	ModPasswords.Init

	CreateHeader
	CreateSessionPanel
	CreateGroupList
	CreateGroupDialog
	CreateConfigDialog

	' Timer para atualizar sessao
	tmrSession.Initialize("tmrSession", 1000)
	tmrSession.Enabled = True

	LoadGroups
	UpdateSessionDisplay
End Sub

Sub Activity_Resume
	tmrSession.Enabled = True  ' Reativa o timer
	LoadGroups
	UpdateSessionDisplay
End Sub

Sub Activity_Pause(UserClosed As Boolean)
	tmrSession.Enabled = False
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
	lblTitle.Text = ModLang.GetText("menu_passwords")
	lblTitle.TextSize = 20
	lblTitle.TextColor = ModTheme.GetTitleTextColor
	lblTitle.Gravity = Gravity.CENTER_VERTICAL
	pnlHeader.AddView(lblTitle, 55dip, 15dip, 100%x - 160dip, 30dip)

	' Botao Configuracao (engrenagem)
	Dim lblConfig As Label
	lblConfig.Initialize("btnConfig")
	lblConfig.Text = Chr(0x2699) ' Engrenagem
	lblConfig.TextSize = 22
	lblConfig.Gravity = Gravity.CENTER
	lblConfig.Color = Colors.Transparent
	lblConfig.TextColor = ModTheme.GetTitleTextColor
	pnlHeader.AddView(lblConfig, 100%x - 95dip, 10dip, 40dip, 40dip)

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
	End If
End Sub

Sub tmrSession_Tick
	UpdateSessionDisplay
End Sub

' ============================================
'  LISTA DE GRUPOS
' ============================================
Private Sub CreateGroupList
	svGroups.Initialize(0)
	Activity.AddView(svGroups, 0, 100dip, 100%x, 100%y - 100dip)
End Sub

Private Sub LoadGroups
	svGroups.Panel.RemoveAllViews

	Dim groups As List = ModPasswords.GetAllGroups

	If groups.Size = 0 Then
		ShowEmptyMessage
		Return
	End If

	Dim top As Int = 10dip
	Dim margin As Int = 10dip
	Dim itemH As Int = 70dip

	For i = 0 To groups.Size - 1
		Dim g As clsPasswordGroup = groups.Get(i)
		Dim entryCount As Int = ModPasswords.GetEntryCountByGroup(g.Id)

		Dim pnlItem As Panel
		pnlItem.Initialize("pnlGroup")
		pnlItem.Tag = g.Id
		pnlItem.Color = ModTheme.GetPanelColor
		svGroups.Panel.AddView(pnlItem, margin, top, 100%x - 2 * margin, itemH)

		Dim xvItem As B4XView = pnlItem
		xvItem.SetColorAndBorder(ModTheme.GetPanelColor, 1dip, ModTheme.GetBorderColor, 8dip)

		' Nome do grupo
		Dim lblName As Label
		lblName.Initialize("")
		lblName.Text = g.Name
		lblName.TextSize = 16
		lblName.TextColor = ModTheme.GetTextColor
		lblName.Typeface = Typeface.DEFAULT_BOLD
		pnlItem.AddView(lblName, 15dip, 12dip, pnlItem.Width - 80dip, 25dip)

		' Contagem de senhas
		Dim lblCount As Label
		lblCount.Initialize("")
		lblCount.Text = entryCount & " " & ModLang.GetText("menu_passwords").ToLowerCase
		lblCount.TextSize = 13
		lblCount.TextColor = ModTheme.GetSecondaryTextColor
		pnlItem.AddView(lblCount, 15dip, 38dip, pnlItem.Width - 80dip, 20dip)

		' Seta
		Dim lblArrow As Label
		lblArrow.Initialize("")
		lblArrow.Text = Chr(0x203A)
		lblArrow.TextSize = 28
		lblArrow.TextColor = Colors.Gray
		lblArrow.Gravity = Gravity.CENTER
		pnlItem.AddView(lblArrow, pnlItem.Width - 50dip, 15dip, 40dip, 40dip)

		top = top + itemH + 10dip
	Next

	svGroups.Panel.Height = top + 20dip
End Sub

Private Sub ShowEmptyMessage
	Dim lblEmpty As Label
	lblEmpty.Initialize("")
	lblEmpty.Text = ModLang.GetText("no_passwords_yet") & CRLF & CRLF & ModLang.GetText("tap_plus_to_add")
	lblEmpty.TextSize = 14
	lblEmpty.TextColor = ModTheme.GetSecondaryTextColor
	lblEmpty.Gravity = Gravity.CENTER_HORIZONTAL
	svGroups.Panel.AddView(lblEmpty, 20dip, 50dip, 100%x - 40dip, 100dip)
	svGroups.Panel.Height = 200dip
End Sub

' ============================================
'  DIALOG NOVO/EDITAR GRUPO
' ============================================
Private Sub CreateGroupDialog
	pnlGroupDialog.Initialize("")
	pnlGroupDialog.Color = Colors.ARGB(180, 0, 0, 0)
	Activity.AddView(pnlGroupDialog, 0, 0, 100%x, 100%y)
	pnlGroupDialog.Visible = False

	Dim boxW As Int = 100%x - 40dip
	Dim boxH As Int = 180dip
	Dim boxL As Int = 20dip
	Dim boxT As Int = 100dip

	Dim pnlBox As Panel
	pnlBox.Initialize("")
	pnlBox.Color = ModTheme.GetPanelColor
	pnlGroupDialog.AddView(pnlBox, boxL, boxT, boxW, boxH)

	Dim xvBox As B4XView = pnlBox
	xvBox.SetColorAndBorder(ModTheme.GetPanelColor, 1dip, ModTheme.GetBorderColor, 10dip)

	' Titulo
	Dim lblDialogTitle As Label
	lblDialogTitle.Initialize("")
	lblDialogTitle.Text = ModLang.GetText("pwd_new_group")
	lblDialogTitle.TextSize = 16
	lblDialogTitle.TextColor = ModTheme.GetTextColor
	lblDialogTitle.Gravity = Gravity.CENTER_HORIZONTAL
	pnlBox.AddView(lblDialogTitle, 10dip, 15dip, boxW - 20dip, 25dip)

	' Campo nome
	Dim lblName As Label
	lblName.Initialize("")
	lblName.Text = ModLang.GetText("pwd_group_name")
	lblName.TextSize = Main.FONT_LABEL
	lblName.TextColor = ModTheme.GetTextColor
	pnlBox.AddView(lblName, 15dip, 50dip, boxW - 30dip, 20dip)

	edtGroupName.Initialize("edtGroupName")
	edtGroupName.Hint = ModLang.GetText("hint_group_name")
	edtGroupName.TextSize = Main.FONT_EDIT
	edtGroupName.TextColor = ModTheme.GetInputTextColor
	pnlBox.AddView(edtGroupName, 15dip, 72dip, boxW - 30dip, 40dip)
	edtGroupName.Background = ModTheme.GetEditDrawableWhite

	' Botoes
	Dim btnW As Int = (boxW - 50dip) / 2

	btnGroupCancel.Initialize("btnGroupCancel")
	btnGroupCancel.Text = ModLang.GetText("btn_back")
	btnGroupCancel.TextSize = Main.FONT_BUTTON
	btnGroupCancel.Color = Colors.Gray
	btnGroupCancel.TextColor = Colors.White
	pnlBox.AddView(btnGroupCancel, 15dip, 125dip, btnW, 38dip)

	btnGroupSave.Initialize("btnGroupSave")
	btnGroupSave.Text = ModLang.GetText("btn_save")
	btnGroupSave.TextSize = Main.FONT_BUTTON
	btnGroupSave.Color = ModTheme.GetPrimaryColor
	btnGroupSave.TextColor = Colors.White
	pnlBox.AddView(btnGroupSave, boxW - btnW - 15dip, 125dip, btnW, 38dip)
End Sub

Private Sub ShowGroupDialog(title As String)
	pnlGroupDialog.Visible = True
	pnlGroupDialog.BringToFront
	edtGroupName.RequestFocus
End Sub

Private Sub HideGroupDialog
	pnlGroupDialog.Visible = False
	edtGroupName.Text = ""
	EditingGroupId = ""
End Sub

' ============================================
'  EVENTOS
' ============================================
Sub btnBack_Click
	Activity.Finish
End Sub

Sub btnAdd_Click
	EditingGroupId = ""
	edtGroupName.Text = ""
	ShowGroupDialog(ModLang.GetText("pwd_new_group"))
End Sub

Sub pnlGroup_Click
	Dim pnl As Panel = Sender
	Dim groupId As String = pnl.Tag

	' Abre lista de senhas do grupo
	ActPasswordList.GroupId = groupId
	Dim g As clsPasswordGroup = ModPasswords.GetGroupById(groupId)
	ActPasswordList.GroupName = g.Name
	StartActivity(ActPasswordList)
End Sub

Sub pnlGroup_LongClick
	Dim pnl As Panel = Sender
	Dim groupId As String = pnl.Tag

	' Confirma exclusao
	Msgbox2Async(ModLang.GetText("msg_confirm_delete_group"), _
		ModLang.GetText("title_warning"), _
		ModLang.GetText("btn_yes"), "", ModLang.GetText("btn_no"), Null, True)
	Wait For Msgbox_Result(res As Int)

	If res = DialogResponse.POSITIVE Then
		ModPasswords.DeleteGroup(groupId)
		ToastMessageShow(ModLang.GetText("msg_group_deleted"), False)
		LoadGroups
	End If
End Sub

Sub btnGroupCancel_Click
	HideGroupDialog
End Sub

Sub btnGroupSave_Click
	Dim name As String = edtGroupName.Text.Trim

	If name = "" Then
		ToastMessageShow(ModLang.GetText("err_pwd_label_empty"), False)
		Return
	End If

	Dim g As clsPasswordGroup
	g.Initialize

	If EditingGroupId <> "" Then
		g = ModPasswords.GetGroupById(EditingGroupId)
	End If

	g.Name = name
	ModPasswords.SaveGroup(g)

	ToastMessageShow(ModLang.GetText("msg_group_saved"), False)
	HideGroupDialog
	LoadGroups
End Sub

' ============================================
'  DIALOG CONFIGURACAO
' ============================================
Private Sub CreateConfigDialog
	pnlConfigDialog.Initialize("")
	pnlConfigDialog.Color = Colors.ARGB(180, 0, 0, 0)
	Activity.AddView(pnlConfigDialog, 0, 0, 100%x, 100%y)
	pnlConfigDialog.Visible = False

	Dim boxW As Int = 100%x - 40dip
	Dim boxH As Int = 200dip
	Dim boxL As Int = 20dip
	Dim boxT As Int = 100dip

	Dim pnlBox As Panel
	pnlBox.Initialize("")
	pnlBox.Color = ModTheme.GetPanelColor
	pnlConfigDialog.AddView(pnlBox, boxL, boxT, boxW, boxH)

	Dim xvBox As B4XView = pnlBox
	xvBox.SetColorAndBorder(ModTheme.GetPanelColor, 1dip, ModTheme.GetBorderColor, 10dip)

	' Titulo
	Dim lblDialogTitle As Label
	lblDialogTitle.Initialize("")
	lblDialogTitle.Text = ModLang.GetText("pwd_config_title")
	lblDialogTitle.TextSize = 16
	lblDialogTitle.TextColor = ModTheme.GetTextColor
	lblDialogTitle.Gravity = Gravity.CENTER_HORIZONTAL
	pnlBox.AddView(lblDialogTitle, 10dip, 15dip, boxW - 20dip, 25dip)

	' Label tempo sessao
	Dim lblSessionTime As Label
	lblSessionTime.Initialize("")
	lblSessionTime.Text = ModLang.GetText("pwd_session_time")
	lblSessionTime.TextSize = Main.FONT_LABEL
	lblSessionTime.TextColor = ModTheme.GetTextColor
	pnlBox.AddView(lblSessionTime, 15dip, 55dip, boxW - 30dip, 20dip)

	' Spinner tempo (1-5 minutos)
	spnSessionTime.Initialize("spnSessionTime")
	Dim timeOptions As List
	timeOptions.Initialize
	timeOptions.Add("1 " & ModLang.GetText("pwd_minute"))
	timeOptions.Add("2 " & ModLang.GetText("pwd_minutes"))
	timeOptions.Add("3 " & ModLang.GetText("pwd_minutes"))
	timeOptions.Add("4 " & ModLang.GetText("pwd_minutes"))
	timeOptions.Add("5 " & ModLang.GetText("pwd_minutes"))
	spnSessionTime.AddAll(timeOptions)
	spnSessionTime.TextSize = Main.FONT_EDIT
	spnSessionTime.TextColor = ModTheme.GetInputTextColor
	pnlBox.AddView(spnSessionTime, 15dip, 80dip, boxW - 30dip, 45dip)

	' Seleciona valor atual
	Dim currentMin As Int = ModPasswords.GetSessionDuration
	spnSessionTime.SelectedIndex = currentMin - 1

	' Botoes
	Dim btnW As Int = (boxW - 50dip) / 2

	btnConfigCancel.Initialize("btnConfigCancel")
	btnConfigCancel.Text = ModLang.GetText("btn_back")
	btnConfigCancel.TextSize = Main.FONT_BUTTON
	btnConfigCancel.Color = Colors.Gray
	btnConfigCancel.TextColor = Colors.White
	pnlBox.AddView(btnConfigCancel, 15dip, 145dip, btnW, 38dip)

	btnConfigSave.Initialize("btnConfigSave")
	btnConfigSave.Text = ModLang.GetText("btn_save")
	btnConfigSave.TextSize = Main.FONT_BUTTON
	btnConfigSave.Color = ModTheme.GetPrimaryColor
	btnConfigSave.TextColor = Colors.White
	pnlBox.AddView(btnConfigSave, boxW - btnW - 15dip, 145dip, btnW, 38dip)
End Sub

Sub btnConfig_Click
	' Atualiza spinner com valor atual
	Dim currentMin As Int = ModPasswords.GetSessionDuration
	spnSessionTime.SelectedIndex = currentMin - 1
	pnlConfigDialog.Visible = True
	pnlConfigDialog.BringToFront
End Sub

Sub btnConfigCancel_Click
	pnlConfigDialog.Visible = False
End Sub

Sub btnConfigSave_Click
	Dim selectedMin As Int = spnSessionTime.SelectedIndex + 1
	ModPasswords.SetSessionDuration(selectedMin)
	ToastMessageShow(ModLang.GetText("pwd_config_saved"), False)
	pnlConfigDialog.Visible = False
End Sub

