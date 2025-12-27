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

	'UI
	Private svContent As ScrollView
	Private pnlContent As B4XView

	Private lblLastBackup As Label
	Private btnExport As Button
	Private btnImport As Button
	Private btnTestRestore As Button

	'Dialogs
	Private edtPhrase As EditText
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
	CallSub2(Main, "SetPageTitle", ModLang.T("backup"))

	ModSession.Touch
	UpdateLastBackupInfo
End Sub

' ============================================
'  CRIAR UI
' ============================================

Private Sub CreateUI
	Dim width As Int = Root.Width
	Dim height As Int = Root.Height

	'Conteudo (tela inteira)
	svContent.Initialize(0)
	Root.AddView(svContent, 0, 0, width, height)

	pnlContent = svContent.Panel
	pnlContent.Color = Colors.Transparent

	Dim y As Int = 20dip
	Dim btnWidth As Int = width - 40dip
	Dim btnHeight As Int = 50dip

	'Info do ultimo backup
	Dim lblInfo As Label
	lblInfo.Initialize("")
	lblInfo.Text = "Ultimo backup:"
	lblInfo.TextSize = 14
	lblInfo.TextColor = Colors.ARGB(180, 255, 255, 255)
	pnlContent.AddView(lblInfo, 20dip, y, btnWidth, 25dip)
	y = y + 25dip

	lblLastBackup.Initialize("")
	lblLastBackup.Text = "Nunca"
	lblLastBackup.TextSize = 16
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
	lblExport.Text = "EXPORTAR"
	lblExport.TextSize = 12
	lblExport.TextColor = Colors.ARGB(150, 255, 255, 255)
	pnlContent.AddView(lblExport, 20dip, y, btnWidth, 20dip)
	y = y + 25dip

	btnExport.Initialize("btnExport")
	btnExport.Text = "Criar Backup Agora"
	pnlContent.AddView(btnExport, 20dip, y, btnWidth, btnHeight)
	y = y + btnHeight + 10dip

	Dim lblExportInfo As Label
	lblExportInfo.Initialize("")
	lblExportInfo.Text = "Cria um arquivo .lockzero criptografado com todos os seus dados."
	lblExportInfo.TextSize = 12
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
	lblImport.Text = "IMPORTAR"
	lblImport.TextSize = 12
	lblImport.TextColor = Colors.ARGB(150, 255, 255, 255)
	pnlContent.AddView(lblImport, 20dip, y, btnWidth, 20dip)
	y = y + 25dip

	btnImport.Initialize("btnImport")
	btnImport.Text = "Restaurar Backup"
	pnlContent.AddView(btnImport, 20dip, y, btnWidth, btnHeight)
	y = y + btnHeight + 10dip

	Dim lblImportInfo As Label
	lblImportInfo.Initialize("")
	lblImportInfo.Text = "Restaura dados de um arquivo .lockzero. Voce precisara da frase usada ao criar o backup."
	lblImportInfo.TextSize = 12
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
	lblTest.Text = "VERIFICAR"
	lblTest.TextSize = 12
	lblTest.TextColor = Colors.ARGB(150, 255, 255, 255)
	pnlContent.AddView(lblTest, 20dip, y, btnWidth, 20dip)
	y = y + 25dip

	btnTestRestore.Initialize("btnTestRestore")
	btnTestRestore.Text = "Testar Backup"
	pnlContent.AddView(btnTestRestore, 20dip, y, btnWidth, btnHeight)
	y = y + btnHeight + 10dip

	Dim lblTestInfo As Label
	lblTestInfo.Initialize("")
	lblTestInfo.Text = "Verifica se o backup pode ser aberto. Nao altera seus dados atuais."
	lblTestInfo.TextSize = 12
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
	lblWarning.Text = "DICA: Use uma oracao, trecho de musica ou frase que voce ja conhece de cor. Assim nao precisa anotar!"
	lblWarning.TextSize = 13
	lblWarning.TextColor = Colors.White
	lblWarning.Gravity = Gravity.CENTER
	lblWarning.Typeface = Typeface.DEFAULT_BOLD
	pnlWarning.AddView(lblWarning, 10dip, 10dip, btnWidth - 20dip, 60dip)
	y = y + 100dip

	pnlContent.Height = y + 20dip
End Sub

' ============================================
'  ATUALIZAR INFO
' ============================================

Private Sub UpdateLastBackupInfo
	If ModBackup.HasBackup Then
		lblLastBackup.Text = ModBackup.GetLastBackupTimeFormatted
		lblLastBackup.TextColor = ModTheme.Success
	Else
		lblLastBackup.Text = "Nenhum backup realizado"
		lblLastBackup.TextColor = ModTheme.Danger
	End If
End Sub

' ============================================
'  EVENTOS
' ============================================

Private Sub btnExport_Click
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
	edtPhrase.Initialize("")
	edtPhrase.Hint = "Frase para proteger o backup"
	edtPhrase.SingleLine = True
	edtPhrase.InputType = Bit.Or(edtPhrase.INPUT_TYPE_TEXT, 128)

	Dim pnl As B4XView = xui.CreatePanel("")
	pnl.SetLayoutAnimated(0, 0, 0, 280dip, 50dip)
	pnl.AddView(edtPhrase, 0, 0, 280dip, 50dip)

	Wait For (xui.Msgbox2Async("Digite uma frase para proteger o backup:", "Criar Backup", ModLang.T("save"), "", ModLang.T("cancel"), pnl)) Msgbox_Result(Result As Int)

	If Result = xui.DialogResponse_Positive Then
		Dim phrase As String = edtPhrase.Text.Trim

		If phrase.Length < 6 Then
			ToastMessageShow("Frase deve ter no minimo 6 caracteres", True)
			Return
		End If

		DoExport(phrase)
	End If
End Sub

Private Sub DoExport(phrase As String)
	'Usa pasta de downloads ou externa
	Dim folder As String = File.DirRootExternal
	If File.ExternalWritable = False Then
		folder = File.DirInternal
	End If

	Dim path As String = ModBackup.ExportBackup(phrase, folder)

	If path <> "" Then
		UpdateLastBackupInfo
		xui.MsgboxAsync("Backup criado com sucesso!" & CRLF & CRLF & "Salvo em:" & CRLF & path, "Sucesso")
	Else
		xui.MsgboxAsync("Erro ao criar backup", "Erro")
	End If
End Sub

Private Sub ShowImportDialog
	'Lista backups disponiveis
	Dim folder As String = File.DirRootExternal
	If File.ExternalWritable = False Then
		folder = File.DirInternal
	End If

	Dim backups As List = ModBackup.ListBackups(folder)

	If backups.Size = 0 Then
		xui.MsgboxAsync("Nenhum arquivo .lockzero encontrado em:" & CRLF & folder, "Nenhum backup")
		Return
	End If

	'Por simplicidade, usa o mais recente
	'TODO: permitir escolher
	Dim latest As Map = backups.Get(backups.Size - 1)
	Dim fileName As String = latest.Get("fileName")

	'Pede a frase
	edtPhrase.Initialize("")
	edtPhrase.Hint = "Frase do backup"
	edtPhrase.SingleLine = True
	edtPhrase.InputType = Bit.Or(edtPhrase.INPUT_TYPE_TEXT, 128)

	Dim pnl As B4XView = xui.CreatePanel("")
	pnl.SetLayoutAnimated(0, 0, 0, 280dip, 50dip)
	pnl.AddView(edtPhrase, 0, 0, 280dip, 50dip)

	Wait For (xui.Msgbox2Async("Arquivo: " & fileName & CRLF & CRLF & "Digite a frase usada ao criar o backup:", "Restaurar Backup", "Restaurar", "", ModLang.T("cancel"), pnl)) Msgbox_Result(Result As Int)

	If Result = xui.DialogResponse_Positive Then
		Dim phrase As String = edtPhrase.Text.Trim

		If phrase.Length < 1 Then
			ToastMessageShow("Digite a frase", True)
			Return
		End If

		DoImport(phrase, folder, fileName)
	End If
End Sub

Private Sub DoImport(phrase As String, folder As String, fileName As String)
	'Confirma antes de importar
	Wait For (xui.Msgbox2Async("ATENCAO: Isso ira adicionar os dados do backup aos seus dados atuais." & CRLF & CRLF & "Deseja continuar?", "Confirmar", "Sim, restaurar", "", ModLang.T("cancel"), Null)) Msgbox_Result(DialogResult As Int)

	If DialogResult <> xui.DialogResponse_Positive Then Return

	Dim importResult As Map = ModBackup.ImportBackup(phrase, folder, fileName)

	If importResult.Get("success") = True Then
		Dim stats As Map = importResult.Get("stats")
		Dim msg As String = "Backup restaurado!" & CRLF & CRLF
		msg = msg & "Grupos: " & stats.Get("groupsImported") & CRLF
		msg = msg & "Senhas: " & stats.Get("entriesImported") & CRLF
		msg = msg & "Notas: " & stats.GetDefault("notesImported", 0)
		xui.MsgboxAsync(msg, "Sucesso")
	Else
		xui.MsgboxAsync(importResult.Get("message"), "Erro")
	End If
End Sub

Private Sub ShowTestDialog
	Dim folder As String = File.DirRootExternal
	If File.ExternalWritable = False Then
		folder = File.DirInternal
	End If

	Dim backups As List = ModBackup.ListBackups(folder)

	If backups.Size = 0 Then
		xui.MsgboxAsync("Nenhum arquivo .lockzero encontrado", "Nenhum backup")
		Return
	End If

	Dim latest As Map = backups.Get(backups.Size - 1)
	Dim fileName As String = latest.Get("fileName")

	edtPhrase.Initialize("")
	edtPhrase.Hint = "Frase do backup"
	edtPhrase.SingleLine = True
	edtPhrase.InputType = Bit.Or(edtPhrase.INPUT_TYPE_TEXT, 128)

	Dim pnl As B4XView = xui.CreatePanel("")
	pnl.SetLayoutAnimated(0, 0, 0, 280dip, 50dip)
	pnl.AddView(edtPhrase, 0, 0, 280dip, 50dip)

	Wait For (xui.Msgbox2Async("Arquivo: " & fileName & CRLF & CRLF & "Digite a frase para testar:", "Testar Backup", "Testar", "", ModLang.T("cancel"), pnl)) Msgbox_Result(Result As Int)

	If Result = xui.DialogResponse_Positive Then
		Dim phrase As String = edtPhrase.Text.Trim
		DoTest(phrase, folder, fileName)
	End If
End Sub

Private Sub DoTest(phrase As String, folder As String, fileName As String)
	Dim result As Map = ModBackup.ValidateBackup(phrase, folder, fileName)

	If result.Get("valid") = True Then
		Dim stats As Map = result.Get("stats")
		Dim createdAt As Long = result.Get("createdAt")

		DateTime.DateFormat = "dd/MM/yyyy HH:mm"
		Dim dateStr As String = DateTime.Date(createdAt)

		Dim msg As String = "Backup VALIDO!" & CRLF & CRLF
		msg = msg & "Criado em: " & dateStr & CRLF
		If stats <> Null Then
			msg = msg & "Grupos: " & stats.GetDefault("totalGroups", 0) & CRLF
			msg = msg & "Senhas: " & stats.GetDefault("totalEntries", 0) & CRLF
			msg = msg & "Notas: " & stats.GetDefault("totalNotes", 0)
		End If

		xui.MsgboxAsync(msg, "Teste OK")
	Else
		xui.MsgboxAsync("Frase incorreta ou arquivo corrompido", "Teste FALHOU")
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

	btnTestRestore.Color = ModTheme.HomeHeaderBg
	btnTestRestore.TextColor = Colors.White
End Sub
