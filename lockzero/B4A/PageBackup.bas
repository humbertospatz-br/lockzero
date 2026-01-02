B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
'PageBackup.bas - Tela de Backup
'LockZero - Export/Import de backups .lockzero

Sub Class_Globals
	Private Root As B4XView
	Private xui As XUI

	'Header
	Private btnBack As Button
	Private lblHeaderTitle As Label

	'UI
	Private svContent As ScrollView
	Private pnlContent As B4XView

	Private lblLastBackup As Label
	Private btnExport As Button
	Private btnImport As Button
	Private btnImportText As Button
	Private btnTestRestore As Button

	'Dialog de frase
	Private pnlOverlay As Panel
	Private pnlPhraseDialog As Panel
	Private edtPhrase As EditText
	Private btnPhraseOk As Button
	Private btnPhraseCancel As Button
	Private btnPhraseShow As Button
	Private PhraseVisible As Boolean = False
	Private CurrentDialogMode As String 'export, import, test
	Private CurrentBackupFolder As String
	Private CurrentBackupFileName As String

	'Import Text Dialog
	Private pnlImportTextDialog As Panel
	Private edtImportText As EditText
	Private btnImportTextOk As Button
	Private btnImportTextCancel As Button
End Sub

Public Sub Initialize

End Sub

'Anima entrada da pagina - chamar DEPOIS de B4XPages.ShowPage
Public Sub AnimateIn
	ModTransition.SlideFromRight(Root)
End Sub

Private Sub B4XPage_Created(Root1 As B4XView)
	Log("PageBackup: B4XPage_Created inicio")
	Root = Root1
	Root.Alpha = 0  'Inicia invisivel
	Root.Left = 100%x  'Inicia off-screen
	CreateUI
	ApplyTheme
	Log("PageBackup: B4XPage_Created fim")
End Sub

Private Sub B4XPage_Appear
	'Define titulo na ActionBar
	CallSub2(Main, "SetPageTitle", ModLang.T("backup"))

	ModSession.Touch
	UpdateLastBackupInfo

	'Verifica se há arquivo .loc recebido externamente
	If Main.PendingBackupFile <> "" Then
		Log("PageBackup: Arquivo pendente para importar: " & Main.PendingBackupFile)
		CurrentBackupFolder = Starter.Provider.SharedFolder
		CurrentBackupFileName = Main.PendingBackupFile
		Main.PendingBackupFile = "" 'Limpa para nao processar novamente

		'Pede a frase para importar
		ShowPhraseDialog("import", CurrentBackupFileName & CRLF & ModLang.T("backup_enter_phrase"))
	End If
End Sub

' ============================================
'  CRIAR UI
' ============================================

Private Sub CreateUI
	Dim width As Int = Root.Width
	Dim height As Int = Root.Height
	Dim headerH As Int = 56dip

	'Header
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
	lblHeaderTitle.Text = ModLang.T("backup")
	lblHeaderTitle.TextSize = 16
	lblHeaderTitle.TextColor = Colors.White
	lblHeaderTitle.Typeface = Typeface.DEFAULT_BOLD
	lblHeaderTitle.Gravity = Gravity.CENTER_VERTICAL
	pnlHeader.AddView(lblHeaderTitle, 50dip, 0, width - 60dip, headerH)

	'Conteudo (abaixo do header)
	svContent.Initialize(0)
	svContent.Color = ModTheme.HomeBg
	Root.AddView(svContent, 0, headerH, width, height - headerH)

	pnlContent = svContent.Panel
	pnlContent.Color = ModTheme.HomeBg

	Dim y As Int = 20dip
	Dim btnWidth As Int = width - 40dip
	Dim btnHeight As Int = 48dip  'Starter.HEIGHT_BUTTON

	'Info do ultimo backup
	Dim lblInfo As Label
	lblInfo.Initialize("")
	lblInfo.Text = ModLang.T("backup_last")
	lblInfo.TextSize = Starter.FONT_BUTTON
	lblInfo.TextColor = Colors.ARGB(180, 255, 255, 255)
	pnlContent.AddView(lblInfo, 20dip, y, btnWidth, 25dip)
	y = y + 25dip

	lblLastBackup.Initialize("")
	lblLastBackup.Text = ModLang.T("backup_never")
	lblLastBackup.TextSize = Starter.FONT_BODY
	lblLastBackup.TextColor = Colors.White
	pnlContent.AddView(lblLastBackup, 20dip, y, btnWidth, 30dip)
	y = y + 50dip

	'Separador
	Dim sep1 As Panel
	sep1.Initialize("")
	sep1.Color = Colors.ARGB(60, 255, 255, 255)
	pnlContent.AddView(sep1, 20dip, y, btnWidth, 1dip)
	y = y + 20dip

	'Secao Exportar
	Dim lblExport As Label
	lblExport.Initialize("")
	lblExport.Text = ModLang.T("backup_export")
	lblExport.TextSize = Starter.FONT_CAPTION
	lblExport.TextColor = Colors.ARGB(150, 255, 255, 255)
	pnlContent.AddView(lblExport, 20dip, y, btnWidth, 20dip)
	y = y + 25dip

	btnExport.Initialize("btnExport")
	btnExport.Text = ModLang.T("backup_create")
	pnlContent.AddView(btnExport, 20dip, y, btnWidth, btnHeight)
	y = y + btnHeight + 10dip

	Dim lblExportInfo As Label
	lblExportInfo.Initialize("")
	lblExportInfo.Text = ModLang.T("backup_create_info")
	lblExportInfo.TextSize = Starter.FONT_CAPTION
	lblExportInfo.TextColor = Colors.ARGB(150, 255, 255, 255)
	pnlContent.AddView(lblExportInfo, 20dip, y, btnWidth, 40dip)
	y = y + 50dip

	'Separador
	Dim sep2 As Panel
	sep2.Initialize("")
	sep2.Color = Colors.ARGB(60, 255, 255, 255)
	pnlContent.AddView(sep2, 20dip, y, btnWidth, 1dip)
	y = y + 20dip

	'Secao Importar
	Dim lblImport As Label
	lblImport.Initialize("")
	lblImport.Text = ModLang.T("backup_import")
	lblImport.TextSize = Starter.FONT_CAPTION
	lblImport.TextColor = Colors.ARGB(150, 255, 255, 255)
	pnlContent.AddView(lblImport, 20dip, y, btnWidth, 20dip)
	y = y + 25dip

	btnImport.Initialize("btnImport")
	btnImport.Text = ModLang.T("backup_restore")
	pnlContent.AddView(btnImport, 20dip, y, btnWidth, btnHeight)
	y = y + btnHeight + 10dip

	btnImportText.Initialize("btnImportText")
	btnImportText.Text = ModLang.T("backup_paste")
	pnlContent.AddView(btnImportText, 20dip, y, btnWidth, btnHeight)
	y = y + btnHeight + 10dip

	Dim lblImportInfo As Label
	lblImportInfo.Initialize("")
	lblImportInfo.Text = ModLang.T("backup_restore_info")
	lblImportInfo.TextSize = Starter.FONT_CAPTION
	lblImportInfo.TextColor = Colors.ARGB(150, 255, 255, 255)
	pnlContent.AddView(lblImportInfo, 20dip, y, btnWidth, 50dip)
	y = y + 60dip

	'Separador
	Dim sep3 As Panel
	sep3.Initialize("")
	sep3.Color = Colors.ARGB(60, 255, 255, 255)
	pnlContent.AddView(sep3, 20dip, y, btnWidth, 1dip)
	y = y + 20dip

	'Testar Restore
	Dim lblTest As Label
	lblTest.Initialize("")
	lblTest.Text = ModLang.T("backup_verify")
	lblTest.TextSize = Starter.FONT_CAPTION
	lblTest.TextColor = Colors.ARGB(150, 255, 255, 255)
	pnlContent.AddView(lblTest, 20dip, y, btnWidth, 20dip)
	y = y + 25dip

	btnTestRestore.Initialize("btnTestRestore")
	btnTestRestore.Text = ModLang.T("backup_test")
	pnlContent.AddView(btnTestRestore, 20dip, y, btnWidth, btnHeight)
	y = y + btnHeight + 10dip

	Dim lblTestInfo As Label
	lblTestInfo.Initialize("")
	lblTestInfo.Text = ModLang.T("backup_test_info")
	lblTestInfo.TextSize = Starter.FONT_CAPTION
	lblTestInfo.TextColor = Colors.ARGB(150, 255, 255, 255)
	pnlContent.AddView(lblTestInfo, 20dip, y, btnWidth, 40dip)
	y = y + 60dip

	'Aviso importante - fundo escuro para consistencia
	Dim pnlWarning As Panel
	pnlWarning.Initialize("")
	pnlWarning.Color = ModTheme.HomeHeaderBg
	pnlContent.AddView(pnlWarning, 20dip, y, btnWidth, 80dip)

	Dim lblWarning As Label
	lblWarning.Initialize("")
	lblWarning.Text = ModLang.T("backup_tip")
	lblWarning.TextSize = Starter.FONT_LABEL
	lblWarning.TextColor = Colors.White
	lblWarning.Gravity = Gravity.CENTER
	lblWarning.Typeface = Typeface.DEFAULT_BOLD
	pnlWarning.AddView(lblWarning, 10dip, 10dip, btnWidth - 20dip, 60dip)
	y = y + 100dip

	pnlContent.Height = y + 20dip

	'Cria dialog overlay para frase
	CreatePhraseDialog
End Sub

Private Sub CreatePhraseDialog
	Log("CreatePhraseDialog: inicio")
	'Overlay escuro
	pnlOverlay.Initialize("pnlOverlay")
	pnlOverlay.Color = Colors.ARGB(180, 0, 0, 0)
	Root.AddView(pnlOverlay, 0, 0, Root.Width, Root.Height)
	pnlOverlay.Visible = False
	Log("CreatePhraseDialog: overlay criado")

	'Dialog box (altura aumentada para acomodar nome de arquivo longo)
	Dim dialogW As Int = Root.Width - 40dip
	Dim dialogH As Int = 210dip

	pnlPhraseDialog.Initialize("")
	pnlPhraseDialog.Color = ModTheme.HomeHeaderBg
	pnlOverlay.AddView(pnlPhraseDialog, 20dip, 100dip, dialogW, dialogH)

	'Titulo (altura aumentada para nome de arquivo + instrucao)
	Dim lblTitle As Label
	lblTitle.Initialize("")
	lblTitle.Text = ModLang.T("backup_phrase_hint")
	lblTitle.TextSize = Starter.FONT_BODY
	lblTitle.TextColor = Colors.White
	lblTitle.Gravity = Gravity.CENTER_HORIZONTAL
	lblTitle.Tag = "lblPhraseTitle"
	pnlPhraseDialog.AddView(lblTitle, 10dip, 10dip, dialogW - 20dip, 60dip)

	'Campo de frase (largura reduzida para caber botao)
	Dim btnShowW As Int = 65dip
	Dim edtW As Int = dialogW - 40dip - btnShowW - 5dip
	edtPhrase.Initialize("edtPhrase")
	edtPhrase.Hint = ModLang.T("backup_phrase_hint")
	edtPhrase.SingleLine = True
	edtPhrase.InputType = Bit.Or(1, 128) 'Password
	edtPhrase.TextColor = Colors.White
	edtPhrase.HintColor = Colors.ARGB(120, 255, 255, 255)

	Dim cd As ColorDrawable
	cd.Initialize2(ModTheme.HomeBg, 8dip, 1dip, Colors.ARGB(80, 255, 255, 255))
	edtPhrase.Background = cd

	pnlPhraseDialog.AddView(edtPhrase, 15dip, 80dip, edtW, 50dip)

	'Botao ver/ocultar
	btnPhraseShow.Initialize("btnPhraseShow")
	btnPhraseShow.Text = ModLang.T("show")
	btnPhraseShow.TextSize = Starter.FONT_CAPTION
	btnPhraseShow.Color = ModTheme.HomeIconBg
	btnPhraseShow.TextColor = Colors.White
	pnlPhraseDialog.AddView(btnPhraseShow, dialogW - btnShowW - 15dip, 80dip, btnShowW, 50dip)

	'Botoes
	btnPhraseCancel.Initialize("btnPhraseCancel")
	btnPhraseCancel.Text = ModLang.T("cancel")
	btnPhraseCancel.TextSize = Starter.FONT_BUTTON
	btnPhraseCancel.Color = Colors.Gray
	btnPhraseCancel.TextColor = Colors.White
	pnlPhraseDialog.AddView(btnPhraseCancel, 20dip, 145dip, 100dip, 45dip)

	btnPhraseOk.Initialize("btnPhraseOk")
	btnPhraseOk.Text = ModLang.T("confirm")
	btnPhraseOk.TextSize = Starter.FONT_BUTTON
	btnPhraseOk.Color = ModTheme.HomeIconBg
	btnPhraseOk.TextColor = Colors.White
	pnlPhraseDialog.AddView(btnPhraseOk, dialogW - 120dip, 145dip, 100dip, 45dip)
	Log("CreatePhraseDialog: fim - dialog completo")
End Sub

Private Sub ShowPhraseDialog(mode As String, title As String)
	Log("ShowPhraseDialog: mode=" & mode)
	Log("ShowPhraseDialog: pnlOverlay.IsInitialized=" & pnlOverlay.IsInitialized)
	Log("ShowPhraseDialog: pnlPhraseDialog.IsInitialized=" & pnlPhraseDialog.IsInitialized)

	If pnlOverlay.IsInitialized = False Then
		Log("ShowPhraseDialog: criando dialog pois nao existe")
		CreatePhraseDialog
	End If

	CurrentDialogMode = mode
	edtPhrase.Text = ""
	PhraseVisible = False
	edtPhrase.InputType = Bit.Or(1, 128) 'PASSWORD
	btnPhraseShow.Text = ModLang.T("show")

	Log("ShowPhraseDialog: atualizando titulo")
	'Atualiza titulo
	For i = 0 To pnlPhraseDialog.NumberOfViews - 1
		Dim v As View = pnlPhraseDialog.GetView(i)
		If v.Tag <> Null Then
			If v.Tag = "lblPhraseTitle" Then
				Dim lbl As Label = v
				lbl.Text = title
			End If
		End If
	Next

	Log("ShowPhraseDialog: mostrando overlay")
	pnlOverlay.Visible = True
	pnlOverlay.BringToFront
	edtPhrase.RequestFocus
	Log("ShowPhraseDialog: fim")
End Sub

Private Sub HidePhraseDialog
	pnlOverlay.Visible = False
	Dim ime As IME
	ime.Initialize("")
	ime.HideKeyboard
End Sub

Private Sub pnlOverlay_Click
	HidePhraseDialog
End Sub

Private Sub btnPhraseCancel_Click
	HidePhraseDialog
End Sub

Private Sub btnPhraseShow_Click
	PhraseVisible = Not(PhraseVisible)
	If PhraseVisible Then
		edtPhrase.InputType = 1 'TEXT
		btnPhraseShow.Text = ModLang.T("hide")
	Else
		edtPhrase.InputType = Bit.Or(1, 128) 'PASSWORD
		btnPhraseShow.Text = ModLang.T("show")
	End If
	'Manter cursor no final
	edtPhrase.SelectionStart = edtPhrase.Text.Length
End Sub

Private Sub btnPhraseOk_Click
	Dim phrase As String = edtPhrase.Text.Trim

	If phrase.Length < 6 Then
		ToastMessageShow(ModLang.T("backup_phrase_min"), True)
		Return
	End If

	HidePhraseDialog

	Select CurrentDialogMode
		Case "export"
			DoExport(phrase)
		Case "import"
			DoImportWithPhrase(phrase)
		Case "test"
			DoTestWithPhrase(phrase)
	End Select
End Sub

' ============================================
'  ATUALIZAR INFO
' ============================================

Private Sub UpdateLastBackupInfo
	If ModBackup.HasBackup Then
		lblLastBackup.Text = ModBackup.GetLastBackupTimeFormatted
		lblLastBackup.TextColor = ModTheme.Success
	Else
		lblLastBackup.Text = ModLang.T("backup_never")
		lblLastBackup.TextColor = ModTheme.Danger
	End If
End Sub

' ============================================
'  EVENTOS
' ============================================

Private Sub btnBack_Click
	B4XPages.ClosePage(Me)
End Sub

Private Sub btnExport_Click
	Log("=== btnExport_Click ===")
	ModSession.Touch
	ShowExportDialog
End Sub

Private Sub btnImport_Click
	ModSession.Touch
	ShowImportDialog
End Sub

Private Sub btnTestRestore_Click
	ModSession.Touch
	ShowTestDialog
End Sub

' ============================================
'  DIALOGS
' ============================================

Private Sub ShowExportDialog
	Log("ShowExportDialog: inicio")
	ShowPhraseDialog("export", ModLang.T("backup_phrase_hint"))
	Log("ShowExportDialog: fim")
End Sub

Private Sub DoExport(phrase As String)
	'Exporta para pasta shared do FileProvider
	Dim folder As String = Starter.Provider.SharedFolder
	Dim fullPath As String = ModBackup.ExportBackup(phrase, folder)

	If fullPath <> "" Then
		'Extrai nome do arquivo
		Dim fileName As String = fullPath.SubString(fullPath.LastIndexOf("/") + 1)
		Log("DoExport: arquivo = " & fileName)

		UpdateLastBackupInfo

		'Pergunta se quer compartilhar
		Wait For (xui.Msgbox2Async(ModLang.T("backup_success") & CRLF & CRLF & ModLang.T("backup_share_question"), ModLang.T("success"), ModLang.T("share"), "", ModLang.T("no"), Null)) Msgbox_Result(Result As Int)

		If Result = xui.DialogResponse_Positive Then
			ShareBackupAsFile(fileName)
		End If
	Else
		xui.MsgboxAsync(ModLang.T("backup_error"), ModLang.T("error"))
	End If
End Sub

Private Sub ShareBackupAsFile(fileName As String)
	Try
		Log("ShareBackupAsFile: " & fileName)
		Dim uri As Object = Starter.Provider.GetFileUri(fileName)
		Log("ShareBackupAsFile URI: " & uri)

		Dim shareIntent As Intent
		shareIntent.Initialize(shareIntent.ACTION_SEND, "")
		shareIntent.SetType("application/vnd.lockzero")  'MimeType customizado
		shareIntent.PutExtra("android.intent.extra.SUBJECT", "LockZero Backup")
		shareIntent.PutExtra("android.intent.extra.STREAM", uri)
		shareIntent.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION
		StartActivity(shareIntent)
	Catch
		Log("ShareBackupAsFile erro: " & LastException)
		ToastMessageShow(ModLang.T("share_error"), True)
	End Try
End Sub

Private Sub ShowImportDialog
	'Lista backups na pasta shared do FileProvider
	CurrentBackupFolder = Starter.Provider.SharedFolder

	Dim backups As List = ModBackup.ListBackups(CurrentBackupFolder)

	If backups.Size = 0 Then
		xui.MsgboxAsync(ModLang.T("backup_none_found") & ":" & CRLF & CurrentBackupFolder, ModLang.T("backup"))
		Return
	End If

	'Por simplicidade, usa o mais recente
	Dim latest As Map = backups.Get(backups.Size - 1)
	CurrentBackupFileName = latest.Get("fileName")

	ShowPhraseDialog("import", CurrentBackupFileName & CRLF & ModLang.T("backup_enter_phrase"))
End Sub

Private Sub DoImportWithPhrase(phrase As String)
	DoImport(phrase, CurrentBackupFolder, CurrentBackupFileName)
End Sub

Private Sub DoImport(phrase As String, folder As String, fileName As String)
	'Confirma antes de importar
	Wait For (xui.Msgbox2Async(ModLang.T("backup_confirm_restore") & CRLF & CRLF & ModLang.T("backup_continue"), ModLang.T("confirm"), ModLang.T("yes"), "", ModLang.T("cancel"), Null)) Msgbox_Result(DialogResult As Int)

	If DialogResult <> xui.DialogResponse_Positive Then Return

	Dim importResult As Map = ModBackup.ImportBackup(phrase, folder, fileName)

	If importResult.Get("success") = True Then
		Dim stats As Map = importResult.Get("stats")
		Dim msg As String = ModLang.T("backup_restored") & CRLF & CRLF
		msg = msg & ModLang.T("backup_groups") & " " & stats.Get("groupsImported") & CRLF
		msg = msg & ModLang.T("backup_entries") & " " & stats.Get("entriesImported") & CRLF
		msg = msg & ModLang.T("backup_notes") & " " & stats.GetDefault("notesImported", 0)
		xui.MsgboxAsync(msg, ModLang.T("success"))
	Else
		xui.MsgboxAsync(importResult.Get("message"), ModLang.T("error"))
	End If
End Sub

Private Sub ShowTestDialog
	'Lista backups na pasta shared do FileProvider
	CurrentBackupFolder = Starter.Provider.SharedFolder

	Dim backups As List = ModBackup.ListBackups(CurrentBackupFolder)

	If backups.Size = 0 Then
		xui.MsgboxAsync(ModLang.T("backup_none_found"), ModLang.T("backup"))
		Return
	End If

	Dim latest As Map = backups.Get(backups.Size - 1)
	CurrentBackupFileName = latest.Get("fileName")

	ShowPhraseDialog("test", CurrentBackupFileName & CRLF & ModLang.T("backup_enter_phrase"))
End Sub

Private Sub DoTestWithPhrase(phrase As String)
	DoTest(phrase, CurrentBackupFolder, CurrentBackupFileName)
End Sub

Private Sub DoTest(phrase As String, folder As String, fileName As String)
	Dim result As Map = ModBackup.ValidateBackup(phrase, folder, fileName)

	If result.Get("valid") = True Then
		Dim stats As Map = result.Get("stats")
		Dim createdAt As Long = result.Get("createdAt")

		DateTime.DateFormat = "dd/MM/yyyy HH:mm"
		Dim dateStr As String = DateTime.Date(createdAt)

		Dim msg As String = ModLang.T("backup_valid") & CRLF & CRLF
		msg = msg & ModLang.T("backup_created_at") & " " & dateStr & CRLF
		If stats <> Null Then
			msg = msg & ModLang.T("backup_groups") & " " & stats.GetDefault("totalGroups", 0) & CRLF
			msg = msg & ModLang.T("backup_entries") & " " & stats.GetDefault("totalEntries", 0) & CRLF
			msg = msg & ModLang.T("backup_notes") & " " & stats.GetDefault("totalNotes", 0)
		End If

		xui.MsgboxAsync(msg, ModLang.T("backup_test_ok"))
	Else
		xui.MsgboxAsync(ModLang.T("backup_test_failed"), ModLang.T("error"))
	End If
End Sub

' ============================================
'  TEMA
' ============================================

Private Sub ApplyTheme
	Root.Color = ModTheme.HomeBg
	svContent.Color = ModTheme.HomeBg
	pnlContent.Color = ModTheme.HomeBg

	btnExport.Color = ModTheme.HomeIconBg
	btnExport.TextColor = Colors.White

	btnImport.Color = ModTheme.HomeIconBg
	btnImport.TextColor = Colors.White

	btnImportText.Color = ModTheme.HomeHeaderBg
	btnImportText.TextColor = Colors.White

	btnTestRestore.Color = ModTheme.HomeHeaderBg
	btnTestRestore.TextColor = Colors.White
End Sub

' ============================================
'  IMPORT TEXT DIALOG
' ============================================

Private Sub CreateImportTextDialog
	pnlImportTextDialog.Initialize("")
	pnlImportTextDialog.Color = Colors.ARGB(180, 0, 0, 0)
	Root.AddView(pnlImportTextDialog, 0, 0, Root.Width, Root.Height)
	pnlImportTextDialog.Visible = False

	Dim boxW As Int = Root.Width - 40dip
	Dim boxH As Int = 350dip
	Dim boxL As Int = 20dip
	Dim boxT As Int = (Root.Height - boxH) / 2

	Dim pnlBox As Panel
	pnlBox.Initialize("")
	pnlBox.Color = ModTheme.HomeHeaderBg
	pnlImportTextDialog.AddView(pnlBox, boxL, boxT, boxW, boxH)

	'Titulo
	Dim lblTitle As Label
	lblTitle.Initialize("")
	lblTitle.Text = ModLang.T("backup_paste_instructions")
	lblTitle.TextSize = Starter.FONT_BODY
	lblTitle.TextColor = Colors.White
	lblTitle.Gravity = Gravity.CENTER_HORIZONTAL
	pnlBox.AddView(lblTitle, 15dip, 15dip, boxW - 30dip, 50dip)

	'Campo de texto para colar
	edtImportText.Initialize("edtImportText")
	edtImportText.Hint = ModLang.T("backup_paste_hint")
	edtImportText.SingleLine = False
	edtImportText.Gravity = Gravity.TOP
	edtImportText.TextSize = Starter.FONT_CAPTION
	edtImportText.TextColor = Colors.White
	edtImportText.HintColor = Colors.ARGB(120, 255, 255, 255)

	Dim cd As ColorDrawable
	cd.Initialize2(ModTheme.HomeBg, 8dip, 1dip, Colors.ARGB(80, 255, 255, 255))
	edtImportText.Background = cd

	pnlBox.AddView(edtImportText, 15dip, 70dip, boxW - 30dip, 200dip)

	'Botoes
	Dim btnW As Int = 100dip

	btnImportTextCancel.Initialize("btnImportTextCancel")
	btnImportTextCancel.Text = ModLang.T("cancel")
	btnImportTextCancel.TextSize = Starter.FONT_BUTTON
	btnImportTextCancel.Color = Colors.Gray
	btnImportTextCancel.TextColor = Colors.White
	pnlBox.AddView(btnImportTextCancel, 15dip, boxH - 60dip, btnW, 45dip)

	btnImportTextOk.Initialize("btnImportTextOk")
	btnImportTextOk.Text = ModLang.T("backup_restore")
	btnImportTextOk.TextSize = Starter.FONT_BUTTON
	btnImportTextOk.Color = ModTheme.HomeIconBg
	btnImportTextOk.TextColor = Colors.White
	pnlBox.AddView(btnImportTextOk, boxW - btnW - 15dip, boxH - 60dip, btnW, 45dip)
End Sub

Private Sub btnImportText_Click
	ModSession.Touch
	ShowImportTextDialog
End Sub

Private Sub ShowImportTextDialog
	If pnlImportTextDialog.IsInitialized = False Then
		CreateImportTextDialog
	End If
	edtImportText.Text = ""
	pnlImportTextDialog.Visible = True
	pnlImportTextDialog.BringToFront
End Sub

Private Sub HideImportTextDialog
	pnlImportTextDialog.Visible = False
	edtImportText.Text = ""
End Sub

Private Sub btnImportTextCancel_Click
	HideImportTextDialog
End Sub

Private Sub btnImportTextOk_Click
	Dim backupText As String = edtImportText.Text.Trim

	If backupText = "" Then
		ToastMessageShow(ModLang.T("backup_paste_empty"), True)
		Return
	End If

	'Valida se e JSON valido
	Try
		Dim parser As JSONParser
		parser.Initialize(backupText)
		Dim backupMap As Map = parser.NextObject
		If backupMap.ContainsKey("version") = False Or backupMap.ContainsKey("data") = False Then
			ToastMessageShow(ModLang.T("backup_invalid"), True)
			Return
		End If
	Catch
		ToastMessageShow(ModLang.T("backup_invalid"), True)
		Return
	End Try

	HideImportTextDialog

	'Salva como arquivo temporario na pasta shared do FileProvider
	CurrentBackupFolder = Starter.Provider.SharedFolder
	CurrentBackupFileName = "pasted_backup_" & DateTime.Now & ".lockzero"
	File.WriteString(CurrentBackupFolder, CurrentBackupFileName, backupText)

	ShowPhraseDialog("import", ModLang.T("backup_enter_phrase"))
End Sub
