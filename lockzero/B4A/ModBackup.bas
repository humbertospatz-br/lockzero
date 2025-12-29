B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=9.85
@EndOfDesignText@
'ModBackup.bas - Modulo de Backup
'LockZero - Export/Import de arquivos .loc
'Backup criptografado com frase mestre

Sub Process_Globals
	Public Const BACKUP_VERSION As Int = 1
	Public Const BACKUP_EXTENSION As String = ".lockzero"

	'Ultimo backup
	Private LastBackupPath As String
	Private LastBackupTime As Long

	'Pasta compartilhada (para FileProvider)
	Private SharedFolder As String
End Sub

'Inicializa pasta shared (chamar antes de usar)
Public Sub InitSharedFolder
	SharedFolder = File.DirInternal & "/shared"
	If File.Exists(SharedFolder, "") = False Then
		File.MakeDir(SharedFolder, "")
	End If
End Sub

'Retorna pasta shared
Public Sub GetSharedFolder As String
	If SharedFolder = "" Then InitSharedFolder
	Return SharedFolder
End Sub

' ============================================
'  EXPORTAR BACKUP
' ============================================

'Exporta todos os dados para arquivo .lockzero
'backupPhrase: frase para criptografar o backup (pode ser diferente das frases dos grupos)
'destFolder: pasta destino (ex: File.DirRootExternal)
'Returns: caminho completo do arquivo ou "" se falhou
Public Sub ExportBackup(backupPhrase As String, destFolder As String) As String
	If backupPhrase.Length < 6 Then
		Log("ModBackup: frase muito curta")
		Return ""
	End If

	Try
		'Monta estrutura do backup
		Dim backup As Map
		backup.Initialize

		'Metadados
		backup.Put("version", BACKUP_VERSION)
		backup.Put("appVersion", Starter.APP_VERSION)
		backup.Put("createdAt", DateTime.Now)
		backup.Put("deviceModel", GetDeviceInfo)

		'Dados dos grupos
		Dim groups As List = ModPasswords.GetAllGroups
		Dim groupsList As List
		groupsList.Initialize
		For Each g As clsPasswordGroup In groups
			groupsList.Add(g.ToMap)
		Next
		backup.Put("groups", groupsList)

		'Dados das senhas
		Dim entries As List = ModPasswords.GetAllEntries
		Dim entriesList As List
		entriesList.Initialize
		For Each e As clsPasswordEntry In entries
			entriesList.Add(e.ToMap)
		Next
		backup.Put("entries", entriesList)

		'Dados das notas
		Dim notes As List = ModNotes.ExportAll
		backup.Put("notes", notes)

		'Estatisticas
		Dim stats As Map
		stats.Initialize
		stats.Put("totalGroups", groups.Size)
		stats.Put("totalEntries", entries.Size)
		stats.Put("totalNotes", notes.Size)
		backup.Put("stats", stats)

		'Converte para JSON
		Dim gen As JSONGenerator
		gen.Initialize(backup)
		Dim jsonData As String = gen.ToString

		'Calcula checksum antes de criptografar
		Dim checksum As String = CalculateChecksum(jsonData)

		'Estrutura final com checksum
		Dim finalData As Map
		finalData.Initialize
		finalData.Put("checksum", checksum)
		finalData.Put("data", jsonData)

		Dim genFinal As JSONGenerator
		genFinal.Initialize(finalData)
		Dim plainText As String = genFinal.ToString

		'Criptografa com frase do backup
		Dim encrypted As String = ModSecurity.Encrypt(backupPhrase, plainText)

		If encrypted = "" Then
			Log("ModBackup: erro ao criptografar")
			Return ""
		End If

		'Gera nome do arquivo
		Dim fileName As String = GenerateBackupFileName

		'Salva arquivo
		File.WriteString(destFolder, fileName, encrypted)

		Dim fullPath As String = File.Combine(destFolder, fileName)

		'Registra ultimo backup
		LastBackupPath = fullPath
		LastBackupTime = DateTime.Now
		SaveBackupInfo

		Log("ModBackup: backup criado em " & fullPath)
		Return fullPath

	Catch
		Log("ModBackup.ExportBackup erro: " & LastException)
		Return ""
	End Try
End Sub

' ============================================
'  IMPORTAR BACKUP
' ============================================

'Importa dados de arquivo .lockzero
'backupPhrase: frase usada para criptografar o backup
'filePath: caminho completo do arquivo
'Returns: Map com resultado (success, message, stats)
Public Sub ImportBackup(backupPhrase As String, sourceFolder As String, fileName As String) As Map
	Dim result As Map
	result.Initialize
	result.Put("success", False)
	result.Put("message", "")
	result.Put("stats", Null)

	Try
		'Verifica se arquivo existe
		If File.Exists(sourceFolder, fileName) = False Then
			result.Put("message", "Arquivo nao encontrado")
			Return result
		End If

		'Le arquivo
		Dim encrypted As String = File.ReadString(sourceFolder, fileName)

		If encrypted.Length < 10 Then
			result.Put("message", "Arquivo vazio ou corrompido")
			Return result
		End If

		'Descriptografa
		Dim plainText As String = ModSecurity.Decrypt(backupPhrase, encrypted)

		If plainText = "" Then
			result.Put("message", ModLang.T("backup_wrong_phrase"))
			Return result
		End If

		'Parse do JSON externo (checksum + data)
		Dim parser As JSONParser
		parser.Initialize(plainText)
		Dim finalData As Map = parser.NextObject

		Dim savedChecksum As String = finalData.Get("checksum")
		Dim jsonData As String = finalData.Get("data")

		'Verifica checksum
		Dim calculatedChecksum As String = CalculateChecksum(jsonData)
		If savedChecksum <> calculatedChecksum Then
			result.Put("message", "Checksum invalido - arquivo corrompido")
			Return result
		End If

		'Parse dos dados
		Dim parser2 As JSONParser
		parser2.Initialize(jsonData)
		Dim backup As Map = parser2.NextObject

		'Verifica versao
		Dim version As Int = backup.Get("version")
		If version > BACKUP_VERSION Then
			result.Put("message", "Versao do backup mais nova que o app")
			Return result
		End If

		'Importa grupos
		Dim groupsImported As Int = 0
		If backup.ContainsKey("groups") Then
			Dim groupsList As List = backup.Get("groups")
			For Each m As Map In groupsList
				Dim g As clsPasswordGroup
				g.Initialize
				g.FromMap(m)
				ModPasswords.SaveGroup(g)
				groupsImported = groupsImported + 1
			Next
		End If

		'Importa senhas
		Dim entriesImported As Int = 0
		If backup.ContainsKey("entries") Then
			Dim entriesList As List = backup.Get("entries")
			For Each m As Map In entriesList
				Dim e As clsPasswordEntry
				e.Initialize
				e.FromMap(m)
				ModPasswords.SaveEntry(e)
				entriesImported = entriesImported + 1
			Next
		End If

		'Importa notas
		Dim notesImported As Int = 0
		If backup.ContainsKey("notes") Then
			Dim notesList As List = backup.Get("notes")
			ModNotes.ImportAll(notesList)
			notesImported = notesList.Size
		End If

		'Estatisticas
		Dim stats As Map
		stats.Initialize
		stats.Put("groupsImported", groupsImported)
		stats.Put("entriesImported", entriesImported)
		stats.Put("notesImported", notesImported)

		result.Put("success", True)
		result.Put("message", "Backup restaurado com sucesso")
		result.Put("stats", stats)

		Log("ModBackup: importado " & groupsImported & " grupos, " & entriesImported & " senhas, " & notesImported & " notas")
		Return result

	Catch
		Log("ModBackup.ImportBackup erro: " & LastException)
		result.Put("message", "Erro ao importar: " & LastException.Message)
		Return result
	End Try
End Sub

' ============================================
'  VALIDAR BACKUP (sem importar)
' ============================================

'Valida se backup pode ser aberto com a frase
'Returns: Map com (valid, version, stats)
Public Sub ValidateBackup(backupPhrase As String, sourceFolder As String, fileName As String) As Map
	Dim result As Map
	result.Initialize
	result.Put("valid", False)
	result.Put("version", 0)
	result.Put("stats", Null)
	result.Put("createdAt", 0)

	Try
		If File.Exists(sourceFolder, fileName) = False Then
			Return result
		End If

		Dim encrypted As String = File.ReadString(sourceFolder, fileName)
		Dim plainText As String = ModSecurity.Decrypt(backupPhrase, encrypted)

		If plainText = "" Then Return result

		'Parse
		Dim parser As JSONParser
		parser.Initialize(plainText)
		Dim finalData As Map = parser.NextObject

		Dim jsonData As String = finalData.Get("data")

		Dim parser2 As JSONParser
		parser2.Initialize(jsonData)
		Dim backup As Map = parser2.NextObject

		result.Put("valid", True)
		result.Put("version", backup.GetDefault("version", 0))
		result.Put("createdAt", backup.GetDefault("createdAt", 0))
		result.Put("stats", backup.GetDefault("stats", Null))

		Return result

	Catch
		Return result
	End Try
End Sub

' ============================================
'  INFORMACOES DO ULTIMO BACKUP
' ============================================

Public Sub GetLastBackupPath As String
	LoadBackupInfo
	Return LastBackupPath
End Sub

Public Sub GetLastBackupTime As Long
	LoadBackupInfo
	Return LastBackupTime
End Sub

Public Sub GetLastBackupTimeFormatted As String
	LoadBackupInfo
	If LastBackupTime = 0 Then Return "Nunca"
	DateTime.DateFormat = "dd/MM/yyyy HH:mm"
	Return DateTime.Date(LastBackupTime)
End Sub

Public Sub HasBackup As Boolean
	LoadBackupInfo
	Return LastBackupTime > 0
End Sub

Private Sub SaveBackupInfo
	Dim settings As Map = ModSecurity.LoadSettings
	settings.Put("lastBackupPath", LastBackupPath)
	settings.Put("lastBackupTime", LastBackupTime)
	ModSecurity.SaveSettings(settings)
End Sub

Private Sub LoadBackupInfo
	Dim settings As Map = ModSecurity.LoadSettings
	LastBackupPath = settings.GetDefault("lastBackupPath", "")
	LastBackupTime = settings.GetDefault("lastBackupTime", 0)
End Sub

' ============================================
'  UTILITARIOS
' ============================================

Private Sub GenerateBackupFileName As String
	DateTime.DateFormat = "yyyyMMdd_HHmmss"
	Dim timestamp As String = DateTime.Date(DateTime.Now)
	Return "lockzero_backup_" & timestamp & BACKUP_EXTENSION
End Sub

Private Sub CalculateChecksum(data As String) As String
	Dim md As MessageDigest
	Dim bytes() As Byte = md.GetMessageDigest(data.GetBytes("UTF8"), "SHA-256")
	Return BytesToHex(bytes)
End Sub

Private Sub BytesToHex(bytes() As Byte) As String
	Dim sb As StringBuilder
	sb.Initialize
	For Each b As Byte In bytes
		Dim hex As String = Bit.ToHexString(Bit.And(b, 0xFF))
		If hex.Length = 1 Then sb.Append("0")
		sb.Append(hex)
	Next
	Return sb.ToString.ToLowerCase
End Sub

Private Sub GetDeviceInfo As String
	Try
		Dim jo As JavaObject
		jo.InitializeStatic("android.os.Build")
		Return jo.GetField("MODEL")
	Catch
		Log("ModBackup.GetDeviceInfo erro: " & LastException)
		Return "Unknown"
	End Try
End Sub

' ============================================
'  LIMPAR DADOS (para restore completo)
' ============================================

'Limpa todos os dados antes de restaurar backup
'CUIDADO: operacao destrutiva!
Public Sub ClearAllData
	'Deleta arquivo de senhas
	If File.Exists(File.DirInternal, "lockzero_passwords.json") Then
		File.Delete(File.DirInternal, "lockzero_passwords.json")
	End If

	'Re-inicializa modulos
	'ModPasswords vai recarregar vazio
	Log("ModBackup: todos os dados foram limpos")
End Sub

' ============================================
'  LISTAR BACKUPS DISPONIVEIS
' ============================================

'Lista arquivos .lockzero em uma pasta
Public Sub ListBackups(folder As String) As List
	Dim backups As List
	backups.Initialize

	Try
		Dim files As List = File.ListFiles(folder)
		For Each f As String In files
			If f.EndsWith(BACKUP_EXTENSION) Then
				Dim info As Map
				info.Initialize
				info.Put("fileName", f)
				info.Put("fullPath", File.Combine(folder, f))
				info.Put("size", File.Size(folder, f))
				info.Put("lastModified", File.LastModified(folder, f))
				backups.Add(info)
			End If
		Next
	Catch
		Log("ModBackup.ListBackups erro: " & LastException)
	End Try

	Return backups
End Sub

' ============================================
'  COMPARTILHAR ARQUIVO (FileProvider)
' ============================================

'Obtem URI do arquivo para compartilhamento via FileProvider
Public Sub GetFileUri(fileName As String) As Object
	Dim folder As String = GetSharedFolder
	Dim f As JavaObject
	f.InitializeNewInstance("java.io.File", Array(folder, fileName))
	Dim fp As JavaObject
	Dim context As JavaObject
	context.InitializeContext
	'Usa androidx (versao moderna)
	fp.InitializeStatic("androidx.core.content.FileProvider")
	Return fp.RunMethod("getUriForFile", Array(context, Application.PackageName & ".provider", f))
End Sub

'Compartilha arquivo de backup
Public Sub ShareBackupFile(fileName As String)
	Log("ShareBackupFile: " & fileName)
	Try
		Dim uri As Object = GetFileUri(fileName)
		Log("ShareBackupFile: URI obtido = " & uri)

		Dim shareIntent As Intent
		shareIntent.Initialize(shareIntent.ACTION_SEND, "")
		shareIntent.SetType("application/octet-stream")
		shareIntent.PutExtra("android.intent.extra.SUBJECT", "LockZero Backup")
		shareIntent.PutExtra("android.intent.extra.STREAM", uri)
		shareIntent.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION
		Log("ShareBackupFile: iniciando share...")
		StartActivity(shareIntent)
	Catch
		Log("ShareBackupFile ERRO: " & LastException)
	End Try
End Sub

'Exporta backup para pasta shared e retorna nome do arquivo
Public Sub ExportToShared(backupPhrase As String) As String
	InitSharedFolder
	Dim fullPath As String = ExportBackup(backupPhrase, SharedFolder)
	If fullPath <> "" Then
		'Extrai nome do arquivo do caminho
		Dim fileName As String = fullPath.SubString(fullPath.LastIndexOf("/") + 1)
		Return fileName
	End If
	Return ""
End Sub
