B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
'PagePasswords.bas - Lista de Grupos de Senhas
'LockZero - Exibe grupos e permite navegar para senhas

Sub Class_Globals
	Public Root As B4XView  'Public para transicoes
	Private xui As XUI

	'UI
	Private btnBack As Button
	Private lblHeaderTitle As Label

	Private svGroups As ScrollView
	Private pnlGroups As B4XView

	'Busca
	Private lblSearch As Label         'Icone de lupa no header
	Private pnlSearchBar As Panel      'Barra de busca expansivel
	Private edtSearch As EditText      'Campo de busca
	Private lblClearSearch As Label    'Botao X para limpar
	Private IsSearchVisible As Boolean = False
	Private AllGroups As List          'Lista completa de grupos
	Private FilteredGroups As List     'Lista filtrada pela busca

	'Dialog Overlay
	Private pnlOverlay As Panel
	Private pnlDialog As Panel
	Private edtGroupName As EditText
	Private edtPassphrase As EditText
	Private edtPassphraseConfirm As EditText
	Private btnShowPass As Button
	Private IsPassVisible As Boolean = False
	Private CurrentDialogMode As String = "" 'add_group, unlock_group, edit_group
	Private CurrentGroupId As String = ""

	'Timer de sessao no header
	Private lblSessionTimer As Label
	Private tmrSession As Timer
End Sub

Public Sub Initialize
	tmrSession.Initialize("tmrSession", 1000)
	AllGroups.Initialize
	FilteredGroups.Initialize
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

	'Titulo com breadcrumb: Senhas
	lblHeaderTitle.Initialize("")
	lblHeaderTitle.Text = ModLang.T("passwords")
	lblHeaderTitle.TextSize = 16
	lblHeaderTitle.TextColor = Colors.White
	lblHeaderTitle.Typeface = Typeface.DEFAULT_BOLD
	lblHeaderTitle.Gravity = Gravity.CENTER_VERTICAL
	pnlHeader.AddView(lblHeaderTitle, 50dip, 0, width - 200dip, headerH)

	'Icone de busca (lupa) no header
	lblSearch.Initialize("lblSearch")
	lblSearch.Text = Chr(0xD83D) & Chr(0xDD0D)  '🔍 (surrogate pair)
	lblSearch.TextSize = 18
	lblSearch.TextColor = Colors.White
	lblSearch.Gravity = Gravity.CENTER
	pnlHeader.AddView(lblSearch, width - 130dip, 8dip, 40dip, 40dip)

	'Fundo arredondado para a lupa
	Dim xvSearch As B4XView = lblSearch
	xvSearch.SetColorAndBorder(Colors.ARGB(60, 255, 255, 255), 0, Colors.Transparent, 20dip)

	'Timer de sessao no header
	lblSessionTimer.Initialize("lblSessionTimer")
	lblSessionTimer.Text = "00:00"
	lblSessionTimer.TextSize = 12
	lblSessionTimer.TextColor = Colors.ARGB(200, 255, 255, 255)
	lblSessionTimer.Gravity = Gravity.CENTER
	pnlHeader.AddView(lblSessionTimer, width - 90dip, 12dip, 40dip, 32dip)

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

	'Barra de busca (inicialmente oculta)
	pnlSearchBar.Initialize("")
	pnlSearchBar.Color = ModTheme.HomeBg
	pnlSearchBar.Visible = False
	Root.AddView(pnlSearchBar, 0, headerH, width, searchH)

	'Input de busca com fundo arredondado
	Dim pnlSearchInput As Panel
	pnlSearchInput.Initialize("")
	pnlSearchInput.Color = ModTheme.HomeIconBg
	pnlSearchBar.AddView(pnlSearchInput, 16dip, 5dip, width - 32dip, 44dip)

	Dim xvSearchInput As B4XView = pnlSearchInput
	xvSearchInput.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModTheme.HomeIconBg, 8dip)

	edtSearch.Initialize("edtSearch")
	edtSearch.Hint = ModLang.T("search") & "..."
	edtSearch.SingleLine = True
	edtSearch.Text = ""
	edtSearch.TextSize = Starter.FONT_BODY
	edtSearch.TextColor = Colors.White
	edtSearch.HintColor = Colors.ARGB(120, 255, 255, 255)
	pnlSearchInput.AddView(edtSearch, 12dip, 0, width - 100dip, 44dip)

	'Botao X para limpar busca
	lblClearSearch.Initialize("lblClearSearch")
	lblClearSearch.Text = "X"
	lblClearSearch.TextSize = 16
	lblClearSearch.TextColor = Colors.ARGB(180, 255, 255, 255)
	lblClearSearch.Gravity = Gravity.CENTER
	lblClearSearch.Visible = False
	pnlSearchInput.AddView(lblClearSearch, width - 80dip, 2dip, 40dip, 40dip)

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
	Dim dialogH As Int = 220dip
	Dim dialogX As Int = 20dip
	Dim dialogY As Int = 80dip 'Posicao alta para nao cobrir com teclado

	pnlDialog.Initialize("")
	pnlDialog.Color = ModTheme.HomeHeaderBg
	pnlOverlay.AddView(pnlDialog, dialogX, dialogY, dialogW, dialogH)

	'Arredondar cantos do dialog
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
'  CARREGAR GRUPOS
' ============================================

Private Sub LoadGroups
	ModPasswords.Init

	'Carrega todos os grupos
	AllGroups = ModPasswords.GetAllGroups

	'Reseta busca e exibe todos
	edtSearch.Text = ""
	FilteredGroups.Initialize
	For Each g As clsPasswordGroup In AllGroups
		FilteredGroups.Add(g)
	Next

	'Esconde barra de busca ao carregar
	IsSearchVisible = False
	UpdateSearchVisibility

	DisplayGroups
End Sub

'Filtra grupos com base no texto de busca (busca em senhas dentro dos grupos)
Private Sub FilterGroups(query As String)
	FilteredGroups.Initialize
	Dim q As String = query.ToLowerCase.Trim

	If q.Length = 0 Then
		'Sem filtro - mostra todos
		For Each g As clsPasswordGroup In AllGroups
			FilteredGroups.Add(g)
		Next
	Else
		'Filtra grupos que contem senhas correspondentes
		For Each g As clsPasswordGroup In AllGroups
			Dim found As Boolean = False

			'Busca no nome do grupo
			If g.Name.ToLowerCase.Contains(q) Then
				found = True
			End If

			'Busca nas senhas do grupo (nome e URL - campos publicos)
			If found = False Then
				Dim entries As List = ModPasswords.GetEntriesByGroup(g.Id)
				For Each e As clsPasswordEntry In entries
					If e.Name.ToLowerCase.Contains(q) Or e.Url.ToLowerCase.Contains(q) Then
						found = True
						Exit
					End If
				Next
			End If

			If found Then FilteredGroups.Add(g)
		Next
	End If

	DisplayGroups
End Sub

'Exibe os grupos filtrados na lista
Private Sub DisplayGroups
	pnlGroups.RemoveAllViews

	Dim width As Int = Root.Width
	Dim itemHeight As Int = 70dip
	Dim y As Int = 16dip

	If FilteredGroups.Size = 0 Then
		'Mensagem vazia
		Dim lblEmpty As B4XView = CreateLabel(ModLang.T("empty"), 14, False)
		lblEmpty.TextColor = Colors.ARGB(150, 255, 255, 255)
		pnlGroups.AddView(lblEmpty, 0, 100dip, width, 40dip)
		pnlGroups.Height = 200dip
		Return
	End If

	For Each g As clsPasswordGroup In FilteredGroups
		Dim pnlItem As Panel
		pnlItem.Initialize("pnlGroup")
		pnlItem.Tag = g.Id

		'Card com cor da Home e cantos arredondados
		Dim xvItem As B4XView = pnlItem
		xvItem.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModTheme.HomeIconBg, 12dip)
		pnlGroups.AddView(pnlItem, 16dip, y, width - 32dip, itemHeight)

		'Nome do grupo
		Dim lblName As Label
		lblName.Initialize("")
		lblName.Text = g.Name
		lblName.TextSize = 16
		lblName.TextColor = Colors.White
		lblName.Typeface = Typeface.DEFAULT_BOLD
		lblName.Gravity = Gravity.CENTER_VERTICAL
		pnlItem.AddView(lblName, 16dip, 0, width - 140dip, itemHeight)

		'Contador de senhas
		Dim count As Int = ModPasswords.GetEntryCountByGroup(g.Id)
		Dim lblCount As Label
		lblCount.Initialize("")
		lblCount.Text = count
		lblCount.TextSize = 14
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

'Atualiza visibilidade da barra de busca e ajusta posicao da lista
Private Sub UpdateSearchVisibility
	Dim headerH As Int = 56dip
	Dim searchH As Int = 54dip

	pnlSearchBar.Visible = IsSearchVisible

	If IsSearchVisible Then
		svGroups.Top = headerH + searchH
		svGroups.Height = Root.Height - headerH - searchH
		edtSearch.RequestFocus
	Else
		svGroups.Top = headerH
		svGroups.Height = Root.Height - headerH
		'Esconde teclado
		Dim ime As IME
		ime.Initialize("")
		ime.HideKeyboard
	End If
End Sub

' ============================================
'  EVENTOS
' ============================================

Private Sub btnBack_Click
	B4XPages.ClosePage(Me)
End Sub

'Toggle da barra de busca ao clicar na lupa
Private Sub lblSearch_Click
	IsSearchVisible = Not(IsSearchVisible)
	UpdateSearchVisibility

	If IsSearchVisible = False Then
		'Limpa busca ao fechar
		edtSearch.Text = ""
		FilterGroups("")
	End If
End Sub

'Evento de busca - filtra conforme digita
Private Sub edtSearch_TextChanged(Old As String, New As String)
	ModSession.Touch
	FilterGroups(New)
	'Mostra/esconde botao X
	lblClearSearch.Visible = (New.Length > 0)
End Sub

'Limpa o campo de busca
Private Sub lblClearSearch_Click
	edtSearch.Text = ""
	lblClearSearch.Visible = False
	FilterGroups("")
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

	Log("=== pnlGroup_Click ===")
	Log("GroupId: " & groupId)

	Dim g As clsPasswordGroup = ModPasswords.GetGroupById(groupId)
	If g.IsInitialized = False Then
		Log("ERRO: Grupo nao inicializado!")
		Return
	End If

	Log("Grupo: " & g.Name)
	Log("Salt: " & g.Salt)
	Log("TestValue: " & g.TestValue)
	Log("Sessao ativa: " & ModSession.IsSessionActive)

	'Se sessao ativa, navega direto
	If ModSession.IsSessionActive Then
		Log("Sessao ativa - navegando direto")
		ModSession.Touch
		NavigateToGroup(groupId)
		Return
	End If

	'Sessao inativa - verifica se frase foi configurada
	'Se frase unica ativa: verifica frase GLOBAL
	'Se frase multipla: verifica frase do GRUPO
	Dim hasPassphrase As Boolean
	If ModSecurity.GetUseSinglePassphrase Then
		hasPassphrase = ModSecurity.HasGlobalPassphrase
	Else
		hasPassphrase = (g.Salt <> "" And g.TestValue <> "")
	End If

	If hasPassphrase = False Then
		'Frase NAO configurada - mostra dialog para CRIAR (adicionar grupo)
		Log("Frase nao configurada - mostrando dialog de criar")
		ShowAddGroupDialog
		Return
	End If

	'Frase configurada - pede para desbloquear
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

	CurrentDialogMode = "unlock_group"
	CurrentGroupId = groupId
	IsPassVisible = False

	'Configura dialog
	Dim dialogW As Int = Root.Width - 40dip
	pnlDialog.RemoveAllViews

	'Titulo
	Dim lblTitle As Label
	lblTitle.Initialize("")
	lblTitle.Text = g.Name
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

	'Campo de frase com botao olho
	Dim pnlInput As Panel
	pnlInput.Initialize("")
	pnlInput.Color = ModTheme.HomeBg
	pnlDialog.AddView(pnlInput, 16dip, 65dip, dialogW - 32dip, 50dip)

	edtPassphrase.Initialize("edtPassphrase")
	edtPassphrase.Hint = ModLang.T("passphrase_hint")
	ModSecurity.ConfigureSecureField(edtPassphrase) 'Configura todas as protecoes
	edtPassphrase.Text = ""
	edtPassphrase.TextColor = Colors.White
	edtPassphrase.HintColor = Colors.ARGB(120, 255, 255, 255)
	pnlInput.AddView(edtPassphrase, 8dip, 0, dialogW - 32dip - 56dip, 50dip)

	'Botao Ver/Ocultar
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

	'Ajusta altura do dialog
	Dim dialogH As Int = 195dip
	If attempts > 0 Then dialogH = 195dip
	pnlDialog.SetLayoutAnimated(0, 20dip, 80dip, dialogW, dialogH)

	'Mostra overlay
	pnlOverlay.Visible = True
	pnlOverlay.BringToFront
	edtPassphrase.RequestFocus
End Sub

Private Sub NavigateToGroup(groupId As String)
	Dim params As Map
	params.Initialize
	params.Put("groupId", groupId)
	'Passa termo de busca para filtrar automaticamente
	If edtSearch.Text.Trim.Length > 0 Then
		params.Put("searchQuery", edtSearch.Text.Trim)
	End If

	Dim pg As PagePasswordList = B4XPages.GetPage("PagePasswordList")
	pg.SetParams(params)
	ModTransition.SlideToLeft(Root, pg.Root)
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
	CurrentDialogMode = "add_group"
	CurrentGroupId = ""
	IsPassVisible = False

	'Configura dialog
	Dim dialogW As Int = Root.Width - 40dip
	pnlDialog.RemoveAllViews

	'Se sessao ativa, usa frase da sessao (dialog simplificado)
	Dim sessionActive As Boolean = ModSession.IsSessionActive

	'Titulo
	Dim lblTitle As Label
	lblTitle.Initialize("")
	lblTitle.Text = ModLang.T("new_group")
	lblTitle.TextSize = 16
	lblTitle.TextColor = Colors.White
	lblTitle.Typeface = Typeface.DEFAULT_BOLD
	lblTitle.Gravity = Gravity.CENTER_HORIZONTAL
	pnlDialog.AddView(lblTitle, 0, 12dip, dialogW, 24dip)

	'Label nome do grupo
	Dim lblName As Label
	lblName.Initialize("")
	lblName.Text = ModLang.T("group_name_hint")
	lblName.TextSize = 12
	lblName.TextColor = Colors.ARGB(180, 255, 255, 255)
	pnlDialog.AddView(lblName, 16dip, 45dip, dialogW - 32dip, 18dip)

	'Campo nome do grupo
	edtGroupName.Initialize("edtGroupName")
	edtGroupName.Hint = ModLang.T("group_name_hint")
	edtGroupName.SingleLine = True
	edtGroupName.InputType = Bit.Or(1, 8192) 'TEXT + CAP_WORDS
	edtGroupName.Text = ""
	edtGroupName.TextColor = Colors.White
	edtGroupName.HintColor = Colors.ARGB(120, 255, 255, 255)

	Dim pnlName As Panel
	pnlName.Initialize("")
	pnlName.Color = ModTheme.HomeBg
	pnlDialog.AddView(pnlName, 16dip, 65dip, dialogW - 32dip, 46dip)
	pnlName.AddView(edtGroupName, 8dip, 0, dialogW - 32dip - 16dip, 46dip)

	Dim buttonY As Int = 125dip
	Dim dialogH As Int = 175dip

	'Apenas mostra campo de frase se sessao NAO esta ativa
	If sessionActive = False Then
		'Label frase
		Dim lblPhrase As Label
		lblPhrase.Initialize("")
		lblPhrase.Text = ModLang.T("passphrase_hint")
		lblPhrase.TextSize = 12
		lblPhrase.TextColor = Colors.ARGB(180, 255, 255, 255)
		pnlDialog.AddView(lblPhrase, 16dip, 120dip, dialogW - 32dip, 18dip)

		'Campo frase com botao olho
		Dim pnlInput As Panel
		pnlInput.Initialize("")
		pnlInput.Color = ModTheme.HomeBg
		pnlDialog.AddView(pnlInput, 16dip, 140dip, dialogW - 32dip, 46dip)

		edtPassphrase.Initialize("edtPassphrase")
		edtPassphrase.Hint = ModLang.T("passphrase_hint")
		ModSecurity.ConfigureSecureField(edtPassphrase) 'Configura todas as protecoes
		edtPassphrase.Text = ""
		edtPassphrase.TextColor = Colors.White
		edtPassphrase.HintColor = Colors.ARGB(120, 255, 255, 255)
		pnlInput.AddView(edtPassphrase, 8dip, 0, dialogW - 32dip - 56dip, 46dip)

		'Botao Ver/Ocultar
		btnShowPass.Initialize("btnShowPass")
		btnShowPass.Text = ModLang.T("view")
		btnShowPass.TextSize = Starter.FONT_CAPTION
		btnShowPass.Color = Colors.Transparent
		btnShowPass.TextColor = Colors.ARGB(200, 255, 255, 255)
		btnShowPass.Gravity = Gravity.CENTER
		pnlInput.AddView(btnShowPass, dialogW - 32dip - 65dip, 3dip, 60dip, 40dip)

		'Label confirmacao
		Dim lblConfirm As Label
		lblConfirm.Initialize("")
		lblConfirm.Text = ModLang.T("passphrase_confirm_new")
		lblConfirm.TextSize = 12
		lblConfirm.TextColor = Colors.ARGB(180, 255, 255, 255)
		pnlDialog.AddView(lblConfirm, 16dip, 195dip, dialogW - 32dip, 18dip)

		'Campo confirmacao
		Dim pnlConfirm As Panel
		pnlConfirm.Initialize("")
		pnlConfirm.Color = ModTheme.HomeBg
		pnlDialog.AddView(pnlConfirm, 16dip, 215dip, dialogW - 32dip, 46dip)

		edtPassphraseConfirm.Initialize("edtPassphraseConfirm")
		edtPassphraseConfirm.Hint = ModLang.T("passphrase_confirm_new")
		ModSecurity.ConfigureSecureField(edtPassphraseConfirm) 'Configura todas as protecoes
		edtPassphraseConfirm.Text = ""
		edtPassphraseConfirm.TextColor = Colors.White
		edtPassphraseConfirm.HintColor = Colors.ARGB(120, 255, 255, 255)
		pnlConfirm.AddView(edtPassphraseConfirm, 8dip, 0, dialogW - 32dip - 16dip, 46dip)

		buttonY = 275dip
		dialogH = 325dip

		'Aviso se modo frase unica esta ativo
		If ModSecurity.GetUseSinglePassphrase Then
			Dim lblWarning As Label
			lblWarning.Initialize("")
			lblWarning.Text = "⚠ " & ModLang.T("single_passphrase_warning")
			lblWarning.TextSize = 10
			lblWarning.TextColor = ModTheme.Warning
			pnlDialog.AddView(lblWarning, 16dip, 265dip, dialogW - 32dip, 35dip)
			buttonY = 305dip
			dialogH = 355dip
		End If
	End If

	'Botoes
	Dim btnCancel As Button
	btnCancel.Initialize("btnDialogCancel")
	btnCancel.Text = ModLang.T("cancel")
	btnCancel.TextSize = 13
	btnCancel.Color = Colors.Transparent
	btnCancel.TextColor = Colors.ARGB(200, 255, 255, 255)
	pnlDialog.AddView(btnCancel, 16dip, buttonY, 100dip, 40dip)

	Dim btnOk As Button
	btnOk.Initialize("btnDialogOk")
	btnOk.Text = ModLang.T("save")
	btnOk.TextSize = 13
	btnOk.Color = ModTheme.HomeIconBg
	btnOk.TextColor = Colors.White
	pnlDialog.AddView(btnOk, dialogW - 116dip, buttonY, 100dip, 40dip)

	'Ajusta altura do dialog
	pnlDialog.SetLayoutAnimated(0, 20dip, 60dip, dialogW, dialogH)

	'Mostra overlay
	pnlOverlay.Visible = True
	pnlOverlay.BringToFront
	edtGroupName.RequestFocus
End Sub

Private Sub ShowGroupOptions(groupId As String)
	Dim g As clsPasswordGroup = ModPasswords.GetGroupById(groupId)
	If g.IsInitialized = False Then Return

	'Msgbox2Async params: Message, Title, Positive, Cancel, Negative, Icon
	'Positive=Edit, Cancel=Cancel, Negative=Delete
	Wait For (xui.Msgbox2Async(g.Name, "", ModLang.T("edit"), ModLang.T("cancel"), ModLang.T("delete"), Null)) Msgbox_Result(Result As Int)

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

	CurrentDialogMode = "edit_group"
	CurrentGroupId = groupId

	'Configura dialog
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

	'Label nome
	Dim lblName As Label
	lblName.Initialize("")
	lblName.Text = ModLang.T("group_name_hint")
	lblName.TextSize = 12
	lblName.TextColor = Colors.ARGB(180, 255, 255, 255)
	pnlDialog.AddView(lblName, 16dip, 45dip, dialogW - 32dip, 18dip)

	'Campo nome
	Dim pnlName As Panel
	pnlName.Initialize("")
	pnlName.Color = ModTheme.HomeBg
	pnlDialog.AddView(pnlName, 16dip, 65dip, dialogW - 32dip, 46dip)

	edtGroupName.Initialize("edtGroupName")
	edtGroupName.Text = g.Name
	edtGroupName.SingleLine = True
	edtGroupName.InputType = Bit.Or(1, 8192)
	edtGroupName.TextColor = Colors.White
	edtGroupName.HintColor = Colors.ARGB(120, 255, 255, 255)
	pnlName.AddView(edtGroupName, 8dip, 0, dialogW - 32dip - 16dip, 46dip)

	'Botoes
	Dim btnCancel As Button
	btnCancel.Initialize("btnDialogCancel")
	btnCancel.Text = ModLang.T("cancel")
	btnCancel.TextSize = 13
	btnCancel.Color = Colors.Transparent
	btnCancel.TextColor = Colors.ARGB(200, 255, 255, 255)
	pnlDialog.AddView(btnCancel, 16dip, 125dip, 100dip, 40dip)

	Dim btnOk As Button
	btnOk.Initialize("btnDialogOk")
	btnOk.Text = ModLang.T("save")
	btnOk.TextSize = 13
	btnOk.Color = ModTheme.HomeIconBg
	btnOk.TextColor = Colors.White
	pnlDialog.AddView(btnOk, dialogW - 116dip, 125dip, 100dip, 40dip)

	'Ajusta altura do dialog
	pnlDialog.SetLayoutAnimated(0, 20dip, 100dip, dialogW, 175dip)

	'Mostra overlay
	pnlOverlay.Visible = True
	pnlOverlay.BringToFront
	edtGroupName.RequestFocus
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
		'Pede a frase-senha para confirmar exclusao
		ShowDeleteGroupDialog(groupId)
	End If
End Sub

'Dialog para pedir frase antes de apagar grupo
Private Sub ShowDeleteGroupDialog(groupId As String)
	Dim g As clsPasswordGroup = ModPasswords.GetGroupById(groupId)
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

	'Campo de frase com botao olho
	Dim pnlInput As Panel
	pnlInput.Initialize("")
	pnlInput.Color = ModTheme.HomeBg
	pnlDialog.AddView(pnlInput, 16dip, 85dip, dialogW - 32dip, 50dip)

	edtPassphrase.Initialize("edtPassphrase")
	edtPassphrase.Hint = ModLang.T("passphrase_hint")
	ModSecurity.ConfigureSecureField(edtPassphrase) 'Configura todas as protecoes
	edtPassphrase.Text = ""
	edtPassphrase.TextColor = Colors.White
	edtPassphrase.HintColor = Colors.ARGB(120, 255, 255, 255)
	pnlInput.AddView(edtPassphrase, 8dip, 0, dialogW - 32dip - 56dip, 50dip)

	'Botao Ver/Ocultar
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

'Processa exclusao de grupo apos validar frase
Private Sub ProcessDeleteGroup
	Dim phrase As String = edtPassphrase.Text.Trim
	Dim g As clsPasswordGroup = ModPasswords.GetGroupById(CurrentGroupId)

	If g.IsInitialized = False Then
		HideDialog
		Return
	End If

	'Valida frase (global ou por grupo)
	Dim isValid As Boolean
	If ModSecurity.GetUseSinglePassphrase Then
		isValid = ModSecurity.ValidateGlobalPassphrase(phrase)
	Else
		isValid = g.ValidatePhrase(phrase)
	End If

	If isValid Then
		'Frase correta - apaga grupo
		ModPasswords.DeleteGroup(CurrentGroupId)
		HideDialog
		LoadGroups
		ToastMessageShow(ModLang.T("success"), False)
	Else
		'Frase incorreta
		ToastMessageShow(ModLang.T("wrong_passphrase"), True)
		edtPassphrase.Text = ""
	End If
End Sub

' ============================================
'  EVENTOS DO DIALOG
' ============================================

Private Sub btnShowPass_Click
	IsPassVisible = Not(IsPassVisible)
	If IsPassVisible Then
		edtPassphrase.InputType = ModSecurity.GetSecureVisibleInputType 'TEXT + NO_SUGGESTIONS (visivel)
		btnShowPass.Text = ModLang.T("hide")
		btnShowPass.TextColor = Colors.White
	Else
		edtPassphrase.InputType = ModSecurity.GetSecurePassphraseInputType 'TEXT + PASSWORD + NO_SUGGESTIONS
		btnShowPass.Text = ModLang.T("view")
		btnShowPass.TextColor = Colors.ARGB(200, 255, 255, 255)
	End If
	'Mantem cursor no final
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
	'Esconde teclado
	Dim ime As IME
	ime.Initialize("")
	ime.HideKeyboard
End Sub

Private Sub ProcessAddGroup
	Dim groupName As String = edtGroupName.Text.Trim

	'Valida nome
	If groupName.Length = 0 Then
		ToastMessageShow(ModLang.T("error_empty_field"), True)
		Return
	End If

	'Determina a frase: da sessao ativa ou do campo
	Dim phrase As String = ""
	If ModSession.IsSessionActive Then
		phrase = ModSession.GetPassphrase
	Else
		phrase = edtPassphrase.Text.Trim
		'Valida forca da frase (10 chars unicos sem espacos)
		Dim phraseError As String = ModSecurity.GetPassphraseError(phrase)
		If phraseError.Length > 0 Then
			ToastMessageShow(phraseError, True)
			Return
		End If

		'Valida confirmacao de frase
		Dim phraseConfirm As String = edtPassphraseConfirm.Text.Trim
		If phrase <> phraseConfirm Then
			ToastMessageShow(ModLang.T("passphrase_mismatch"), True)
			Return
		End If
	End If

	'Se frase unica ativa, salva como frase GLOBAL
	If ModSecurity.GetUseSinglePassphrase Then
		If ModSecurity.HasGlobalPassphrase = False Then
			ModSecurity.SetupGlobalPassphrase(phrase)
		End If
	End If

	'Cria grupo com TestValue
	Dim g As clsPasswordGroup
	g.Initialize
	g.Name = groupName
	g.GenerateSalt
	g.CreateTestValue(phrase)
	ModPasswords.SaveGroup(g)

	'Inicia/renova sessao com a frase (categoria: passwords)
	ModSession.StartSessionWithCategory(phrase, "passwords")

	'Limpa campo e clipboard por seguranca
	ModSecurity.ClearSecureField(edtPassphrase)
	If edtPassphraseConfirm.IsInitialized Then ModSecurity.ClearSecureField(edtPassphraseConfirm)

	HideDialog
	LoadGroups
	ToastMessageShow(ModLang.T("success"), False)
End Sub

Private Sub ProcessUnlockGroup
	Dim phrase As String = edtPassphrase.Text.Trim
	Dim g As clsPasswordGroup = ModPasswords.GetGroupById(CurrentGroupId)

	If g.IsInitialized = False Then
		HideDialog
		Return
	End If

	'Valida frase (global ou por grupo)
	Dim isValid As Boolean
	If ModSecurity.GetUseSinglePassphrase Then
		isValid = ModSecurity.ValidateGlobalPassphrase(phrase)
	Else
		isValid = g.ValidatePhrase(phrase)
	End If

	If isValid Then
		'Frase correta - reseta tentativas e inicia sessao (categoria: passwords)
		ModSecurity.ResetFailedAttempts(CurrentGroupId)
		ModSession.StartSessionWithCategory(phrase, "passwords")
		'Limpa campo e clipboard por seguranca
		ModSecurity.ClearSecureField(edtPassphrase)
		HideDialog
		NavigateToGroup(CurrentGroupId)
	Else
		'Frase incorreta - registra tentativa
		Dim delay As Int = ModSecurity.RegisterFailedAttempt(CurrentGroupId)
		If delay > 0 Then
			Dim timeStr As String = ModSecurity.FormatDelay(delay)
			ToastMessageShow(ModLang.T("wrong_passphrase") & " - " & ModLang.T("wait_timeout") & " " & timeStr, True)
			HideDialog
		Else
			ToastMessageShow(ModLang.T("wrong_passphrase"), True)
		End If
		ModSecurity.ClearSecureField(edtPassphrase)
	End If
End Sub

Private Sub ProcessEditGroup
	Dim groupName As String = edtGroupName.Text.Trim
	Dim g As clsPasswordGroup = ModPasswords.GetGroupById(CurrentGroupId)

	If g.IsInitialized = False Then
		HideDialog
		Return
	End If

	If groupName.Length > 0 Then
		g.Name = groupName
		ModPasswords.SaveGroup(g)
		HideDialog
		LoadGroups
		ToastMessageShow(ModLang.T("success"), False)
	Else
		ToastMessageShow(ModLang.T("error_empty_field"), True)
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
	'Apenas atualiza o display do timer
	'NAO chama Touch aqui - isso resetaria o timer!
	UpdateSessionTimer
End Sub

Private Sub UpdateSessionTimer
	If ModSession.IsSessionActive Then
		lblSessionTimer.Text = ModSession.GetRemainingFormatted

		'Muda cor quando tempo baixo (< 60s) - azul gelo para visibilidade
		Dim remaining As Int = ModSession.GetRemainingSeconds
		If remaining < 60 Then
			lblSessionTimer.TextColor = Colors.RGB(0, 220, 255)  'Azul gelo
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

