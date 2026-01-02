B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
'PageImportCSV.bas - Importar senhas de CSV do Chrome
'LockZero - Permite selecionar e importar senhas de arquivo CSV

Sub Class_Globals
	Public Root As B4XView  'Public para transicoes
	Private xui As XUI

	'Header
	Private btnBack As Button
	Private lblHeaderTitle As Label

	'UI - Info
	Private lblInfo As Label
	Private lblSelected As Label
	Private btnToggleAll As Button

	'UI - Lista
	Private svEntries As ScrollView
	Private pnlEntries As B4XView

	'UI - Bottom bar
	Private pnlBottom As Panel
	Private btnSelectGroup As Button
	Private btnImport As Button

	'Dados
	Private CSVEntries As List 'Lista de Maps com dados do CSV
	Private FilteredEntries As List 'Lista filtrada pela busca
	Private SelectedIndexes As List 'Indices selecionados
	Private SelectedGroupId As String
	Private SelectedGroupName As String

	'Busca/Filtro
	Private edtSearch As EditText
	Private lblClearSearch As Label
	Private CurrentFilter As String = ""

	'Arquivo CSV
	Private CSVFolder As String
	Private CSVFileName As String
	Private LastParsedFile As String 'Para detectar se arquivo mudou

	'Dialog Overlay
	Private pnlOverlay As Panel
	Private pnlDialog As Panel
	Private CurrentDialogMode As String 'select_group, new_group, passphrase

	'Dialog campos
	Private edtGroupName As EditText
	Private edtPassphrase As EditText
	Private btnShowPass As Button
	Private IsPassVisible As Boolean = False
End Sub

Public Sub Initialize
	CSVEntries.Initialize
	FilteredEntries.Initialize
	SelectedIndexes.Initialize
	SelectedGroupId = ""
	SelectedGroupName = ""
	LastParsedFile = ""
	CurrentFilter = ""
End Sub

'Recebe o caminho do arquivo CSV
Public Sub SetCSVFile(folder As String, fileName As String)
	CSVFolder = folder
	CSVFileName = fileName
End Sub

Private Sub B4XPage_Created(Root1 As B4XView)
	Root = Root1
	CreateUI
	ApplyTheme
End Sub

Private Sub B4XPage_Appear
	CallSub2(Main, "SetPageTitle", ModLang.T("import_csv"))

	'Carrega CSV se ainda nao carregou OU se arquivo mudou
	If CSVFileName <> "" Then
		Dim fullPath As String = CSVFolder & "/" & CSVFileName
		If CSVEntries.Size = 0 Or fullPath <> LastParsedFile Then
			Log("Parseando CSV: " & CSVFileName)
			'Limpa estado anterior
			CSVEntries.Initialize
			SelectedIndexes.Initialize
			SelectedGroupId = ""
			SelectedGroupName = ""
			CurrentFilter = ""
			If edtSearch.IsInitialized Then edtSearch.Text = ""
			'Parseia novo arquivo
			ParseCSV
			LastParsedFile = fullPath
			ApplyFilter 'Inicializa filtro e carrega entradas
		End If
	End If

	UpdateInfo
End Sub

Private Sub B4XPage_Disappear
	'Limpa apenas os pendentes do Main para permitir novas importacoes
	'NAO limpa CSVEntries/SelectedIndexes aqui pois o app pode ir para background temporariamente
	Main.PendingCSVFile = ""
	Main.PendingCSVFolder = ""
End Sub

' ============================================
'  CRIAR UI
' ============================================

Private Sub CreateUI
	Dim width As Int = Root.Width
	Dim height As Int = Root.Height
	Dim headerH As Int = 56dip
	Dim bottomH As Int = 70dip
	Dim infoH As Int = 80dip
	Dim searchH As Int = 50dip

	'===========================================
	' HEADER
	'===========================================
	Dim pnlHeader As Panel
	pnlHeader.Initialize("")
	pnlHeader.Color = ModTheme.HomeHeaderBg
	Root.AddView(pnlHeader, 0, 0, width, headerH)

	'Botao Voltar
	btnBack.Initialize("btnBack")
	btnBack.Text = "<"
	btnBack.TextSize = 20
	btnBack.Color = Colors.Transparent
	btnBack.TextColor = Colors.White
	btnBack.Gravity = Gravity.CENTER
	pnlHeader.AddView(btnBack, 0, 0, 50dip, headerH)

	'Titulo
	lblHeaderTitle.Initialize("")
	lblHeaderTitle.Text = ModLang.T("import_csv")
	lblHeaderTitle.TextSize = 16
	lblHeaderTitle.TextColor = Colors.White
	lblHeaderTitle.Typeface = Typeface.DEFAULT_BOLD
	lblHeaderTitle.Gravity = Gravity.CENTER_VERTICAL
	pnlHeader.AddView(lblHeaderTitle, 50dip, 0, width - 60dip, headerH)

	'===========================================
	' INFO BAR
	'===========================================
	Dim pnlInfo As Panel
	pnlInfo.Initialize("")
	pnlInfo.Color = ModTheme.HomeBg
	Root.AddView(pnlInfo, 0, headerH, width, infoH)

	'Info de entradas encontradas
	lblInfo.Initialize("")
	lblInfo.Text = "0 " & ModLang.T("csv_entries_found")
	lblInfo.TextSize = Starter.FONT_BODY
	lblInfo.TextColor = Colors.White
	lblInfo.Gravity = Gravity.CENTER_VERTICAL
	pnlInfo.AddView(lblInfo, 16dip, 5dip, width - 32dip, 30dip)

	'Selecionadas
	lblSelected.Initialize("")
	lblSelected.Text = ModLang.T("csv_selected") & ": 0"
	lblSelected.TextSize = Starter.FONT_CAPTION
	lblSelected.TextColor = Colors.ARGB(180, 255, 255, 255)
	pnlInfo.AddView(lblSelected, 16dip, 35dip, width - 150dip, 25dip)

	'Botao Selecionar/Desmarcar Todos
	btnToggleAll.Initialize("btnToggleAll")
	btnToggleAll.Text = ModLang.T("csv_select_all")
	btnToggleAll.TextSize = Starter.FONT_CAPTION
	btnToggleAll.Color = ModTheme.HomeIconBg
	btnToggleAll.TextColor = Colors.White
	pnlInfo.AddView(btnToggleAll, width - 140dip, 30dip, 125dip, 35dip)

	'===========================================
	' BARRA DE BUSCA
	'===========================================
	Dim pnlSearch As Panel
	pnlSearch.Initialize("")
	pnlSearch.Color = ModTheme.HomeBg
	Root.AddView(pnlSearch, 0, headerH + infoH, width, searchH)

	'Campo de busca
	edtSearch.Initialize("edtSearch")
	edtSearch.Hint = ModLang.T("search_hint")
	edtSearch.SingleLine = True
	edtSearch.InputType = 1 'text
	edtSearch.Text = ""
	edtSearch.TextColor = Colors.White
	edtSearch.HintColor = Colors.ARGB(120, 255, 255, 255)

	Dim pnlSearchField As Panel
	pnlSearchField.Initialize("")
	pnlSearchField.Color = ModTheme.HomeIconBg
	Dim xvSearchField As B4XView = pnlSearchField
	xvSearchField.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModTheme.HomeIconBg, 8dip)
	pnlSearch.AddView(pnlSearchField, 12dip, 6dip, width - 60dip, 42dip)
	pnlSearchField.AddView(edtSearch, 10dip, 2dip, width - 90dip, 40dip)

	'Botao limpar busca (X)
	lblClearSearch.Initialize("lblClearSearch")
	lblClearSearch.Text = "X"
	lblClearSearch.TextSize = 14
	lblClearSearch.TextColor = Colors.White
	lblClearSearch.Gravity = Gravity.CENTER
	lblClearSearch.Visible = False 'So aparece quando ha texto
	pnlSearch.AddView(lblClearSearch, width - 45dip, 6dip, 35dip, 42dip)

	'===========================================
	' LISTA DE ENTRADAS
	'===========================================
	svEntries.Initialize(0)
	svEntries.Color = ModTheme.HomeBg
	Root.AddView(svEntries, 0, headerH + infoH + searchH, width, height - headerH - infoH - searchH - bottomH)

	pnlEntries = svEntries.Panel
	pnlEntries.Color = ModTheme.HomeBg

	'===========================================
	' BOTTOM BAR
	'===========================================
	pnlBottom.Initialize("")
	pnlBottom.Color = ModTheme.HomeHeaderBg
	Root.AddView(pnlBottom, 0, height - bottomH, width, bottomH)

	'Botao selecionar grupo
	btnSelectGroup.Initialize("btnSelectGroup")
	btnSelectGroup.Text = ModLang.T("csv_select_group")
	btnSelectGroup.TextSize = Starter.FONT_BUTTON
	btnSelectGroup.Color = ModTheme.HomeBg
	btnSelectGroup.TextColor = Colors.White
	pnlBottom.AddView(btnSelectGroup, 10dip, 12dip, (width / 2) - 15dip, 46dip)

	'Botao importar
	btnImport.Initialize("btnImport")
	btnImport.Text = ModLang.T("csv_import_btn") & " (0)"
	btnImport.TextSize = Starter.FONT_BUTTON
	btnImport.Color = ModTheme.HomeIconBg
	btnImport.TextColor = Colors.White
	pnlBottom.AddView(btnImport, (width / 2) + 5dip, 12dip, (width / 2) - 15dip, 46dip)

	'===========================================
	' OVERLAY PARA DIALOGS
	'===========================================
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
	Dim dialogH As Int = 280dip

	pnlDialog.Initialize("")
	pnlDialog.Color = ModTheme.HomeHeaderBg
	pnlOverlay.AddView(pnlDialog, 20dip, 80dip, dialogW, dialogH)

	Dim xvDialog As B4XView = pnlDialog
	xvDialog.SetColorAndBorder(ModTheme.HomeHeaderBg, 0, ModTheme.HomeHeaderBg, 12dip)
End Sub

' ============================================
'  PARSE CSV
' ============================================

Private Sub ParseCSV
	CSVEntries.Initialize
	SelectedIndexes.Initialize

	If CSVFileName = "" Then Return

	Try
		Dim content As String = File.ReadString(CSVFolder, CSVFileName)
		Dim lines() As String = Regex.Split(CRLF, content)

		'Se nao tem CRLF, tenta LF
		If lines.Length <= 1 Then
			lines = Regex.Split(Chr(10), content)
		End If

		'Primeira linha e o header
		If lines.Length < 2 Then Return

		'Identifica indices das colunas
		Dim cols() As String = ParseCSVLine(lines(0))
		Dim idxName As Int = -1
		Dim idxUrl As Int = -1
		Dim idxUsername As Int = -1
		Dim idxPassword As Int = -1
		Dim idxNote As Int = -1

		For i = 0 To cols.Length - 1
			Dim col As String = cols(i).ToLowerCase.Trim
			If col = "name" Then idxName = i
			If col = "url" Then idxUrl = i
			If col = "username" Then idxUsername = i
			If col = "password" Then idxPassword = i
			If col = "note" Or col = "notes" Then idxNote = i
		Next

		Log("CSV Columns: name=" & idxName & " url=" & idxUrl & " user=" & idxUsername & " pass=" & idxPassword & " note=" & idxNote)

		'Processa linhas de dados
		For i = 1 To lines.Length - 1
			Dim line As String = lines(i).Trim
			If line = "" Then Continue

			Dim values() As String = ParseCSVLine(line)

			Dim entry As Map
			entry.Initialize

			If idxName >= 0 And idxName < values.Length Then entry.Put("name", values(idxName).Trim)
			If idxUrl >= 0 And idxUrl < values.Length Then entry.Put("url", values(idxUrl).Trim)
			If idxUsername >= 0 And idxUsername < values.Length Then entry.Put("username", values(idxUsername).Trim)
			If idxPassword >= 0 And idxPassword < values.Length Then entry.Put("password", values(idxPassword).Trim)
			If idxNote >= 0 And idxNote < values.Length Then entry.Put("note", values(idxNote).Trim)

			'Preenche valores faltantes
			If entry.ContainsKey("name") = False Then entry.Put("name", "")
			If entry.ContainsKey("url") = False Then entry.Put("url", "")
			If entry.ContainsKey("username") = False Then entry.Put("username", "")
			If entry.ContainsKey("password") = False Then entry.Put("password", "")
			If entry.ContainsKey("note") = False Then entry.Put("note", "")

			'Ignora linhas sem username ou password
			If entry.Get("username") = "" Or entry.Get("password") = "" Then
				Log("CSV: Ignorando linha " & i & " (username ou password vazio)")
				Continue
			End If

			CSVEntries.Add(entry)
			'NAO seleciona por padrao - usuario deve escolher
		Next

		Log("CSV: " & CSVEntries.Size & " entradas validas")

	Catch
		Log("ParseCSV erro: " & LastException)
		ToastMessageShow(ModLang.T("csv_error_parse"), True)
	End Try
End Sub

'Parse de uma linha CSV respeitando aspas
Private Sub ParseCSVLine(line As String) As String()
	Dim result As List
	result.Initialize

	Dim current As StringBuilder
	current.Initialize
	Dim inQuotes As Boolean = False

	For i = 0 To line.Length - 1
		Dim c As Char = line.CharAt(i)

		If c = Chr(34) Then 'Aspas duplas
			inQuotes = Not(inQuotes)
		Else If c = "," And inQuotes = False Then
			result.Add(current.ToString)
			current.Initialize
		Else
			current.Append(c)
		End If
	Next

	result.Add(current.ToString)

	Dim arr(result.Size) As String
	For i = 0 To result.Size - 1
		arr(i) = result.Get(i)
	Next
	Return arr
End Sub

' ============================================
'  CARREGAR LISTA
' ============================================

Private Sub LoadEntries
	pnlEntries.RemoveAllViews

	Dim width As Int = Root.Width
	Dim itemHeight As Int = 72dip
	Dim y As Int = 10dip

	If FilteredEntries.Size = 0 Then
		Dim lblEmpty As Label
		lblEmpty.Initialize("")
		If CSVEntries.Size = 0 Then
			lblEmpty.Text = ModLang.T("csv_no_entries")
		Else
			lblEmpty.Text = ModLang.T("search_no_results")
		End If
		lblEmpty.TextSize = Starter.FONT_BODY
		lblEmpty.TextColor = Colors.ARGB(150, 255, 255, 255)
		lblEmpty.Gravity = Gravity.CENTER
		pnlEntries.AddView(lblEmpty, 0, 50dip, width, 40dip)
		pnlEntries.Height = 150dip
		Return
	End If

	For i = 0 To FilteredEntries.Size - 1
		Dim filteredEntry As Map = FilteredEntries.Get(i)
		Dim originalIndex As Int = filteredEntry.Get("index")
		Dim entry As Map = filteredEntry.Get("data")

		Dim pnlItem As Panel
		pnlItem.Initialize("pnlEntry")
		pnlItem.Tag = originalIndex 'Usa indice original para selecao

		'Card
		Dim xvItem As B4XView = pnlItem
		xvItem.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModTheme.HomeIconBg, 8dip)
		pnlEntries.AddView(pnlItem, 12dip, y, width - 24dip, itemHeight)

		'Checkbox (simulado com Label) - melhor contraste
		Dim isSelected As Boolean = SelectedIndexes.IndexOf(originalIndex) >= 0
		Dim lblCheck As Label
		lblCheck.Initialize("lblCheck")
		lblCheck.Tag = originalIndex
		If isSelected Then
			lblCheck.Text = Chr(9745) 'Checked
			lblCheck.TextColor = Colors.RGB(100, 255, 100) 'Verde claro
		Else
			lblCheck.Text = Chr(9744) 'Unchecked
			lblCheck.TextColor = Colors.White 'Branco para melhor contraste
		End If
		lblCheck.TextSize = 26
		lblCheck.Gravity = Gravity.CENTER
		pnlItem.AddView(lblCheck, 5dip, 0, 40dip, itemHeight)

		'Nome
		Dim name As String = entry.Get("name")
		If name = "" Then name = entry.Get("url")
		Dim lblName As Label
		lblName.Initialize("")
		lblName.Text = name
		lblName.TextSize = Starter.FONT_BODY
		lblName.TextColor = Colors.White
		lblName.Typeface = Typeface.DEFAULT_BOLD
		lblName.Gravity = Gravity.CENTER_VERTICAL
		lblName.SingleLine = True
		pnlItem.AddView(lblName, 50dip, 5dip, width - 90dip, 28dip)

		'URL
		Dim lblUrl As Label
		lblUrl.Initialize("")
		lblUrl.Text = entry.Get("url")
		lblUrl.TextSize = Starter.FONT_CAPTION
		lblUrl.TextColor = Colors.ARGB(150, 255, 255, 255)
		lblUrl.SingleLine = True
		pnlItem.AddView(lblUrl, 50dip, 30dip, width - 90dip, 20dip)

		'Username
		Dim lblUser As Label
		lblUser.Initialize("")
		lblUser.Text = entry.Get("username")
		lblUser.TextSize = Starter.FONT_CAPTION
		lblUser.TextColor = Colors.ARGB(180, 255, 255, 255)
		lblUser.SingleLine = True
		pnlItem.AddView(lblUser, 50dip, 48dip, width - 90dip, 20dip)

		y = y + itemHeight + 8dip
	Next

	pnlEntries.Height = y + 20dip
End Sub

Private Sub UpdateInfo
	'Mostra total e filtrado
	If CurrentFilter <> "" Then
		lblInfo.Text = FilteredEntries.Size & "/" & CSVEntries.Size & " " & ModLang.T("csv_entries_found")
	Else
		lblInfo.Text = CSVEntries.Size & " " & ModLang.T("csv_entries_found")
	End If

	lblSelected.Text = ModLang.T("csv_selected") & ": " & SelectedIndexes.Size
	btnImport.Text = ModLang.T("csv_import_btn") & " (" & SelectedIndexes.Size & ")"

	'Conta quantos filtrados estao selecionados para o botao toggle
	Dim filteredSelected As Int = 0
	For Each fe As Map In FilteredEntries
		Dim idx As Int = fe.Get("index")
		If SelectedIndexes.IndexOf(idx) >= 0 Then
			filteredSelected = filteredSelected + 1
		End If
	Next

	'Alterna texto do botao toggle baseado nos filtrados
	If filteredSelected = FilteredEntries.Size And FilteredEntries.Size > 0 Then
		btnToggleAll.Text = ModLang.T("csv_deselect_all")
	Else
		btnToggleAll.Text = ModLang.T("csv_select_all")
	End If

	If SelectedGroupName <> "" Then
		btnSelectGroup.Text = SelectedGroupName
	Else
		btnSelectGroup.Text = ModLang.T("csv_select_group")
	End If
End Sub

' ============================================
'  EVENTOS
' ============================================

Private Sub btnBack_Click
	B4XPages.ClosePage(Me)
End Sub

Private Sub pnlEntry_Click
	Dim pnl As Panel = Sender
	Dim idx As Int = pnl.Tag
	ToggleSelection(idx)
End Sub

Private Sub lblCheck_Click
	Dim lbl As Label = Sender
	Dim idx As Int = lbl.Tag
	ToggleSelection(idx)
End Sub

Private Sub ToggleSelection(idx As Int)
	Dim pos As Int = SelectedIndexes.IndexOf(idx)
	If pos >= 0 Then
		SelectedIndexes.RemoveAt(pos)
	Else
		SelectedIndexes.Add(idx)
	End If
	LoadEntries
	UpdateInfo
End Sub

Private Sub btnToggleAll_Click
	'Conta quantos filtrados estao selecionados
	Dim filteredSelected As Int = 0
	For Each fe As Map In FilteredEntries
		Dim idx As Int = fe.Get("index")
		If SelectedIndexes.IndexOf(idx) >= 0 Then
			filteredSelected = filteredSelected + 1
		End If
	Next

	If filteredSelected = FilteredEntries.Size And FilteredEntries.Size > 0 Then
		'Desmarcar todos os filtrados
		For Each fe As Map In FilteredEntries
			Dim idx As Int = fe.Get("index")
			Dim pos As Int = SelectedIndexes.IndexOf(idx)
			If pos >= 0 Then
				SelectedIndexes.RemoveAt(pos)
			End If
		Next
	Else
		'Selecionar todos os filtrados
		For Each fe As Map In FilteredEntries
			Dim idx As Int = fe.Get("index")
			If SelectedIndexes.IndexOf(idx) < 0 Then
				SelectedIndexes.Add(idx)
			End If
		Next
	End If
	LoadEntries
	UpdateInfo
End Sub

' ============================================
'  BUSCA/FILTRO
' ============================================

Private Sub edtSearch_TextChanged(Old As String, New As String)
	CurrentFilter = New.Trim.ToLowerCase
	lblClearSearch.Visible = (CurrentFilter.Length > 0)
	ApplyFilter
End Sub

Private Sub lblClearSearch_Click
	edtSearch.Text = ""
	CurrentFilter = ""
	lblClearSearch.Visible = False
	ApplyFilter
End Sub

Private Sub ApplyFilter
	FilteredEntries.Initialize

	If CurrentFilter = "" Then
		'Sem filtro - mostra todos
		For i = 0 To CSVEntries.Size - 1
			Dim entry As Map
			entry.Initialize
			entry.Put("index", i)
			entry.Put("data", CSVEntries.Get(i))
			FilteredEntries.Add(entry)
		Next
	Else
		'Filtra por nome ou URL
		For i = 0 To CSVEntries.Size - 1
			Dim csvEntry As Map = CSVEntries.Get(i)
			Dim name As String = csvEntry.Get("name")
			Dim url As String = csvEntry.Get("url")
			Dim username As String = csvEntry.Get("username")

			If name.ToLowerCase.Contains(CurrentFilter) Or _
				url.ToLowerCase.Contains(CurrentFilter) Or _
				username.ToLowerCase.Contains(CurrentFilter) Then

				Dim entry As Map
				entry.Initialize
				entry.Put("index", i)
				entry.Put("data", csvEntry)
				FilteredEntries.Add(entry)
			End If
		Next
	End If

	LoadEntries
End Sub

Private Sub btnSelectGroup_Click
	ShowSelectGroupDialog
End Sub

Private Sub btnImport_Click
	If SelectedIndexes.Size = 0 Then
		ToastMessageShow(ModLang.T("csv_select_at_least_one"), True)
		Return
	End If

	If SelectedGroupId = "" Then
		ToastMessageShow(ModLang.T("csv_select_group_first"), True)
		Return
	End If

	'Se sessao ja esta ativa, importa direto sem pedir frase
	If ModSession.IsSessionActive Then
		Log("Sessao ativa - importando direto")
		DoImport
	Else
		'Pede a frase-senha
		ShowPassphraseDialog
	End If
End Sub

Private Sub pnlOverlay_Click
	HideDialog
End Sub

' ============================================
'  DIALOG: SELECIONAR GRUPO
' ============================================

Private Sub ShowSelectGroupDialog
	CurrentDialogMode = "select_group"

	Dim dialogW As Int = Root.Width - 40dip
	pnlDialog.RemoveAllViews

	'Titulo
	Dim lblTitle As Label
	lblTitle.Initialize("")
	lblTitle.Text = ModLang.T("csv_select_group")
	lblTitle.TextSize = 16
	lblTitle.TextColor = Colors.White
	lblTitle.Typeface = Typeface.DEFAULT_BOLD
	lblTitle.Gravity = Gravity.CENTER_HORIZONTAL
	pnlDialog.AddView(lblTitle, 0, 12dip, dialogW, 30dip)

	'Lista de grupos existentes
	Dim groups As List = ModPasswords.GetAllGroups
	Dim y As Int = 50dip

	If groups.Size > 0 Then
		For i = 0 To groups.Size - 1
			Dim g As clsPasswordGroup = groups.Get(i)

			Dim btnGroup As Button
			btnGroup.Initialize("btnGroupItem")
			btnGroup.Text = g.Name
			btnGroup.Tag = g.Id & "|" & g.Name
			btnGroup.TextSize = Starter.FONT_BODY
			btnGroup.Color = ModTheme.HomeBg
			btnGroup.TextColor = Colors.White
			pnlDialog.AddView(btnGroup, 16dip, y, dialogW - 32dip, 44dip)

			y = y + 50dip
		Next
	Else
		Dim lblNoGroups As Label
		lblNoGroups.Initialize("")
		lblNoGroups.Text = ModLang.T("csv_no_groups")
		lblNoGroups.TextSize = Starter.FONT_BODY
		lblNoGroups.TextColor = Colors.ARGB(150, 255, 255, 255)
		lblNoGroups.Gravity = Gravity.CENTER
		pnlDialog.AddView(lblNoGroups, 0, y, dialogW, 40dip)
		y = y + 50dip
	End If

	'Botao criar novo grupo
	Dim btnNew As Button
	btnNew.Initialize("btnNewGroup")
	btnNew.Text = "+ " & ModLang.T("csv_new_group")
	btnNew.TextSize = Starter.FONT_BODY
	btnNew.Color = ModTheme.HomeIconBg
	btnNew.TextColor = Colors.White
	pnlDialog.AddView(btnNew, 16dip, y, dialogW - 32dip, 44dip)
	y = y + 55dip

	'Botao cancelar
	Dim btnCancel As Button
	btnCancel.Initialize("btnDialogCancel")
	btnCancel.Text = ModLang.T("cancel")
	btnCancel.TextSize = Starter.FONT_BUTTON
	btnCancel.Color = Colors.Gray
	btnCancel.TextColor = Colors.White
	pnlDialog.AddView(btnCancel, 16dip, y, 100dip, 40dip)

	'Ajusta altura do dialog
	Dim dialogH As Int = y + 55dip
	If dialogH > Root.Height - 160dip Then dialogH = Root.Height - 160dip
	pnlDialog.SetLayoutAnimated(0, 20dip, 80dip, dialogW, dialogH)

	pnlOverlay.Visible = True
	pnlOverlay.BringToFront
End Sub

Private Sub btnGroupItem_Click
	Dim btn As Button = Sender
	Dim tag As String = btn.Tag

	Log("=== btnGroupItem_Click ===")
	Log("Tag: " & tag)

	'Usa IndexOf em vez de Regex.Split (mais confiavel)
	Dim pipePos As Int = tag.IndexOf("|")
	If pipePos > 0 Then
		SelectedGroupId = tag.SubString2(0, pipePos)
		SelectedGroupName = tag.SubString(pipePos + 1)
		Log("SelectedGroupId: " & SelectedGroupId)
		Log("SelectedGroupName: " & SelectedGroupName)
	Else
		Log("ERRO: Tag invalida - pipe nao encontrado: " & tag)
	End If

	HideDialog
	UpdateInfo
End Sub

Private Sub btnNewGroup_Click
	ShowNewGroupDialog
End Sub

' ============================================
'  DIALOG: NOVO GRUPO
' ============================================

Private Sub ShowNewGroupDialog
	CurrentDialogMode = "new_group"
	IsPassVisible = False

	Dim dialogW As Int = Root.Width - 40dip
	pnlDialog.RemoveAllViews

	'Titulo
	Dim lblTitle As Label
	lblTitle.Initialize("")
	lblTitle.Text = ModLang.T("csv_new_group")
	lblTitle.TextSize = 16
	lblTitle.TextColor = Colors.White
	lblTitle.Typeface = Typeface.DEFAULT_BOLD
	lblTitle.Gravity = Gravity.CENTER_HORIZONTAL
	pnlDialog.AddView(lblTitle, 0, 12dip, dialogW, 30dip)

	'Label nome
	Dim lblName As Label
	lblName.Initialize("")
	lblName.Text = ModLang.T("group_name_hint")
	lblName.TextSize = Starter.FONT_CAPTION
	lblName.TextColor = Colors.ARGB(180, 255, 255, 255)
	pnlDialog.AddView(lblName, 16dip, 45dip, dialogW - 32dip, 20dip)

	'Campo nome
	edtGroupName.Initialize("edtGroupName")
	edtGroupName.Hint = ModLang.T("group_name_hint")
	edtGroupName.SingleLine = True
	edtGroupName.InputType = Bit.Or(1, 8192)
	edtGroupName.Text = "Chrome Import"
	edtGroupName.TextColor = Colors.White
	edtGroupName.HintColor = Colors.ARGB(120, 255, 255, 255)

	Dim pnlName As Panel
	pnlName.Initialize("")
	pnlName.Color = ModTheme.HomeBg
	pnlDialog.AddView(pnlName, 16dip, 65dip, dialogW - 32dip, 46dip)
	pnlName.AddView(edtGroupName, 8dip, 0, dialogW - 48dip, 46dip)

	'Label frase
	Dim lblPhrase As Label
	lblPhrase.Initialize("")
	lblPhrase.Text = ModLang.T("passphrase_hint")
	lblPhrase.TextSize = Starter.FONT_CAPTION
	lblPhrase.TextColor = Colors.ARGB(180, 255, 255, 255)
	pnlDialog.AddView(lblPhrase, 16dip, 120dip, dialogW - 32dip, 20dip)

	'Campo frase
	edtPassphrase.Initialize("edtPassphrase")
	edtPassphrase.Hint = ModLang.T("passphrase_hint")
	edtPassphrase.SingleLine = True
	edtPassphrase.InputType = ModSecurity.GetSecurePassphraseInputType 'TEXT + PASSWORD + NO_SUGGESTIONS
	edtPassphrase.Text = ""
	edtPassphrase.TextColor = Colors.White
	edtPassphrase.HintColor = Colors.ARGB(120, 255, 255, 255)

	Dim pnlPass As Panel
	pnlPass.Initialize("")
	pnlPass.Color = ModTheme.HomeBg
	pnlDialog.AddView(pnlPass, 16dip, 140dip, dialogW - 32dip, 46dip)
	pnlPass.AddView(edtPassphrase, 8dip, 0, dialogW - 110dip, 46dip)

	'Botao ver/ocultar
	btnShowPass.Initialize("btnShowPass")
	btnShowPass.Text = ModLang.T("view")
	btnShowPass.TextSize = Starter.FONT_CAPTION
	btnShowPass.Color = ModTheme.HomeIconBg
	btnShowPass.TextColor = Colors.White
	pnlPass.AddView(btnShowPass, dialogW - 95dip, 3dip, 55dip, 40dip)

	'Botoes
	Dim btnCancel As Button
	btnCancel.Initialize("btnDialogCancel")
	btnCancel.Text = ModLang.T("cancel")
	btnCancel.TextSize = Starter.FONT_BUTTON
	btnCancel.Color = Colors.Gray
	btnCancel.TextColor = Colors.White
	pnlDialog.AddView(btnCancel, 16dip, 200dip, 100dip, 44dip)

	Dim btnCreate As Button
	btnCreate.Initialize("btnCreateGroup")
	btnCreate.Text = ModLang.T("save")
	btnCreate.TextSize = Starter.FONT_BUTTON
	btnCreate.Color = ModTheme.HomeIconBg
	btnCreate.TextColor = Colors.White
	pnlDialog.AddView(btnCreate, dialogW - 116dip, 200dip, 100dip, 44dip)

	'Ajusta altura
	pnlDialog.SetLayoutAnimated(0, 20dip, 80dip, dialogW, 260dip)

	edtGroupName.RequestFocus
End Sub

Private Sub btnCreateGroup_Click
	Dim groupName As String = edtGroupName.Text.Trim
	Dim phrase As String = edtPassphrase.Text.Trim

	If groupName = "" Then
		ToastMessageShow(ModLang.T("error_empty_field"), True)
		Return
	End If

	'Valida forca da frase
	Dim phraseError As String = ModSecurity.GetPassphraseError(phrase)
	If phraseError.Length > 0 Then
		ToastMessageShow(phraseError, True)
		Return
	End If

	'Cria grupo
	Dim g As clsPasswordGroup
	g.Initialize
	g.Name = groupName
	g.GenerateSalt
	g.CreateTestValue(phrase)
	ModPasswords.SaveGroup(g)

	SelectedGroupId = g.Id
	SelectedGroupName = g.Name

	'Inicia sessao
	ModSession.StartSessionWithCategory(phrase, "passwords")

	'Limpa campo e clipboard por seguranca
	ModSecurity.ClearSecureField(edtPassphrase)

	HideDialog
	UpdateInfo

	'Ja faz a importacao automaticamente
	DoImport
End Sub

' ============================================
'  DIALOG: FRASE-SENHA (grupo existente)
' ============================================

Private Sub ShowPassphraseDialog
	CurrentDialogMode = "passphrase"
	IsPassVisible = False

	Dim dialogW As Int = Root.Width - 40dip
	pnlDialog.RemoveAllViews

	'Titulo
	Dim lblTitle As Label
	lblTitle.Initialize("")
	lblTitle.Text = SelectedGroupName
	lblTitle.TextSize = 16
	lblTitle.TextColor = Colors.White
	lblTitle.Typeface = Typeface.DEFAULT_BOLD
	lblTitle.Gravity = Gravity.CENTER_HORIZONTAL
	pnlDialog.AddView(lblTitle, 0, 12dip, dialogW, 30dip)

	'Subtitulo
	Dim lblSub As Label
	lblSub.Initialize("")
	lblSub.Text = ModLang.T("enter_passphrase")
	lblSub.TextSize = Starter.FONT_CAPTION
	lblSub.TextColor = Colors.ARGB(180, 255, 255, 255)
	lblSub.Gravity = Gravity.CENTER_HORIZONTAL
	pnlDialog.AddView(lblSub, 0, 40dip, dialogW, 20dip)

	'Campo frase
	edtPassphrase.Initialize("edtPassphrase")
	edtPassphrase.Hint = ModLang.T("passphrase_hint")
	edtPassphrase.SingleLine = True
	edtPassphrase.InputType = ModSecurity.GetSecurePassphraseInputType 'TEXT + PASSWORD + NO_SUGGESTIONS
	edtPassphrase.Text = ""
	edtPassphrase.TextColor = Colors.White
	edtPassphrase.HintColor = Colors.ARGB(120, 255, 255, 255)

	Dim pnlPass As Panel
	pnlPass.Initialize("")
	pnlPass.Color = ModTheme.HomeBg
	pnlDialog.AddView(pnlPass, 16dip, 70dip, dialogW - 32dip, 50dip)
	pnlPass.AddView(edtPassphrase, 8dip, 0, dialogW - 110dip, 50dip)

	'Botao ver/ocultar
	btnShowPass.Initialize("btnShowPass")
	btnShowPass.Text = ModLang.T("view")
	btnShowPass.TextSize = Starter.FONT_CAPTION
	btnShowPass.Color = ModTheme.HomeIconBg
	btnShowPass.TextColor = Colors.White
	pnlPass.AddView(btnShowPass, dialogW - 95dip, 5dip, 55dip, 40dip)

	'Botoes
	Dim btnCancel As Button
	btnCancel.Initialize("btnDialogCancel")
	btnCancel.Text = ModLang.T("cancel")
	btnCancel.TextSize = Starter.FONT_BUTTON
	btnCancel.Color = Colors.Gray
	btnCancel.TextColor = Colors.White
	pnlDialog.AddView(btnCancel, 16dip, 140dip, 100dip, 44dip)

	Dim btnOk As Button
	btnOk.Initialize("btnUnlockGroup")
	btnOk.Text = ModLang.T("unlock")
	btnOk.TextSize = Starter.FONT_BUTTON
	btnOk.Color = ModTheme.HomeIconBg
	btnOk.TextColor = Colors.White
	pnlDialog.AddView(btnOk, dialogW - 116dip, 140dip, 100dip, 44dip)

	'Ajusta altura
	pnlDialog.SetLayoutAnimated(0, 20dip, 100dip, dialogW, 200dip)

	pnlOverlay.Visible = True
	pnlOverlay.BringToFront
	edtPassphrase.RequestFocus
End Sub

Private Sub btnUnlockGroup_Click
	Dim phrase As String = edtPassphrase.Text.Trim

	If phrase = "" Then
		ToastMessageShow(ModLang.T("error_empty_field"), True)
		Return
	End If

	Log("=== btnUnlockGroup_Click ===")
	Log("SelectedGroupId: " & SelectedGroupId)
	Log("SelectedGroupName: " & SelectedGroupName)

	'Valida frase com o grupo
	Dim g As clsPasswordGroup = ModPasswords.GetGroupById(SelectedGroupId)
	If g.IsInitialized = False Then
		Log("ERRO: Grupo nao encontrado com ID: " & SelectedGroupId)
		ToastMessageShow(ModLang.T("error") & " - Grupo não encontrado", True)
		HideDialog
		Return
	End If

	Log("Grupo encontrado: " & g.Name)

	If g.ValidatePhrase(phrase) = False Then
		ToastMessageShow(ModLang.T("wrong_passphrase"), True)
		ModSecurity.ClearSecureField(edtPassphrase)
		Return
	End If

	'Inicia sessao
	ModSession.StartSessionWithCategory(phrase, "passwords")

	'Limpa campo e clipboard por seguranca
	ModSecurity.ClearSecureField(edtPassphrase)

	HideDialog
	DoImport
End Sub

Private Sub btnShowPass_Click
	IsPassVisible = Not(IsPassVisible)
	If IsPassVisible Then
		edtPassphrase.InputType = ModSecurity.GetSecureVisibleInputType 'TEXT + NO_SUGGESTIONS (visivel)
		btnShowPass.Text = ModLang.T("hide")
	Else
		edtPassphrase.InputType = ModSecurity.GetSecurePassphraseInputType 'TEXT + PASSWORD + NO_SUGGESTIONS
		btnShowPass.Text = ModLang.T("view")
	End If
	edtPassphrase.SelectionStart = edtPassphrase.Text.Length
End Sub

Private Sub btnDialogCancel_Click
	HideDialog
End Sub

Private Sub HideDialog
	pnlOverlay.Visible = False
	CurrentDialogMode = ""
	Dim ime As IME
	ime.Initialize("")
	ime.HideKeyboard
End Sub

' ============================================
'  IMPORTACAO
' ============================================

Private Sub DoImport
	Dim imported As Int = 0
	Dim updated As Int = 0

	For Each idx As Int In SelectedIndexes
		Dim csvEntry As Map = CSVEntries.Get(idx)

		Dim name As String = csvEntry.Get("name")
		Dim url As String = csvEntry.Get("url")
		Dim username As String = csvEntry.Get("username")
		Dim password As String = csvEntry.Get("password")
		Dim note As String = csvEntry.Get("note")

		If name = "" Then name = url

		Log("=== Importando: " & name & " ===")
		Log("Username plain: " & username)
		Log("Password plain: " & password.SubString2(0, Min(3, password.Length)) & "***")
		Log("Session active: " & ModSession.IsSessionActive)

		'Criptografa os campos
		Dim encUsername As String = ModSession.Encrypt(username)
		Dim encPassword As String = ModSession.Encrypt(password)
		Dim encNote As String = ""
		If note <> "" Then encNote = ModSession.Encrypt(note)

		Log("Username enc: " & encUsername.SubString2(0, Min(20, encUsername.Length)) & "...")
		Log("Password enc: " & encPassword.SubString2(0, Min(20, encPassword.Length)) & "...")

		'Verifica se criptografia funcionou
		If encUsername = "" Or encPassword = "" Then
			Log("ERRO: Criptografia falhou!")
			Continue
		End If

		'Verifica duplicata (mesmo URL + username no grupo)
		Dim existingId As String = FindExistingEntry(url, username)

		If existingId <> "" Then
			'Atualiza existente
			Dim existing As clsPasswordEntry = ModPasswords.GetEntryById(existingId)
			existing.PasswordEnc = encPassword
			If encNote <> "" Then existing.Notes = encNote
			existing.UpdatedAt = DateTime.Now
			ModPasswords.SaveEntry(existing)
			updated = updated + 1
		Else
			'Cria nova
			Dim e As clsPasswordEntry
			e.Initialize
			e.GroupId = SelectedGroupId
			e.Name = name
			e.Url = url
			e.Username = encUsername
			e.PasswordEnc = encPassword
			If encNote <> "" Then e.Notes = encNote
			ModPasswords.SaveEntry(e)
			imported = imported + 1
		End If
	Next

	'Mostra resultado via Toast
	Dim msg As String = imported & " " & ModLang.T("csv_imported")
	If updated > 0 Then
		msg = msg & ", " & updated & " " & ModLang.T("csv_updated")
	End If
	ToastMessageShow(msg, True)

	'Se tinha filtro ativo, permanece na pagina para mais importacoes
	Dim hasFilter As Boolean = edtSearch.IsInitialized And edtSearch.Text.Trim.Length > 0
	Log("DoImport - hasFilter: " & hasFilter & ", edtSearch.Text: " & edtSearch.Text)

	If hasFilter Then
		'Remove as entradas importadas da lista (em ordem reversa para nao baguncar indices)
		Dim toRemove As List
		toRemove.Initialize
		toRemove.AddAll(SelectedIndexes)
		'Ordena em ordem crescente e depois remove do fim para o inicio
		toRemove.Sort(True)
		'Remove do maior indice para o menor
		For i = toRemove.Size - 1 To 0 Step -1
			Dim idx As Int = toRemove.Get(i)
			If idx < CSVEntries.Size Then
				CSVEntries.RemoveAt(idx)
			End If
		Next
		'Limpa filtro e selecao para proxima importacao
		edtSearch.Text = ""
		CurrentFilter = ""
		lblClearSearch.Visible = False
		SelectedIndexes.Initialize
		ApplyFilter
		UpdateInfo
		Return
	End If

	'Sem filtro: limpa tudo e fecha a pagina
	Main.PendingCSVFile = ""
	Main.PendingCSVFolder = ""
	CSVEntries.Initialize
	SelectedIndexes.Initialize
	CSVFileName = ""
	CSVFolder = ""
	LastParsedFile = ""
	SelectedGroupId = ""
	SelectedGroupName = ""

	'Fecha a pagina
	B4XPages.ClosePage(Me)
End Sub

'Busca entrada existente pelo URL + username
Private Sub FindExistingEntry(url As String, username As String) As String
	Dim entries As List = ModPasswords.GetEntriesByGroup(SelectedGroupId)

	For Each e As clsPasswordEntry In entries
		If e.Url.ToLowerCase = url.ToLowerCase Then
			'Decripta username para comparar
			Dim decryptedUser As String = ModSession.Decrypt(e.Username)
			If decryptedUser.ToLowerCase = username.ToLowerCase Then
				Return e.Id
			End If
		End If
	Next

	Return ""
End Sub

' ============================================
'  TEMA
' ============================================

Private Sub ApplyTheme
	Root.Color = ModTheme.HomeBg
End Sub
