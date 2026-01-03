B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=9.85
@EndOfDesignText@
'ModAttachments.bas - Gestao de Anexos em Notas
'LockZero - Lock and ZERO worries
'
'Anexos sao:
'1. Copiados para pasta interna do app
'2. Criptografados com AES-256 (frase-senha do grupo)
'3. Compactados em formato ZIP
'4. Incluidos no backup .lockzero

Sub Process_Globals
	'Limites de tamanho
	Public Const MAX_FILE_SIZE As Long = 26214400      '25 MB por arquivo
	Public Const MAX_TOTAL_NOTE As Long = 104857600    '100 MB por nota
	'Limite total de anexos: usa Starter.MAX_ATTACHMENTS_SIZE (FREE: 25MB, PREMIUM: configuravel)

	'Pastas
	Public Const ATTACHMENTS_FOLDER As String = "Attachments"
	Public Const TEMP_FOLDER As String = "Temp"

	'Extensao de arquivo de anexo criptografado
	Private Const LZA_EXTENSION As String = ".lza"

	'Versao do formato de anexo
	Private Const ATTACHMENT_VERSION As Int = 1

	'Tipos de arquivo permitidos
	Private AllowedExtensions As List

	Private mInitialized As Boolean = False
End Sub

' ============================================
'  INICIALIZACAO
' ============================================

Public Sub Init
	If mInitialized Then Return

	'Inicializa lista de extensoes permitidas
	AllowedExtensions.Initialize

	'Imagens
	AllowedExtensions.Add("jpg")
	AllowedExtensions.Add("jpeg")
	AllowedExtensions.Add("png")
	AllowedExtensions.Add("gif")
	AllowedExtensions.Add("webp")
	AllowedExtensions.Add("heic")
	AllowedExtensions.Add("bmp")

	'Videos
	AllowedExtensions.Add("mp4")
	AllowedExtensions.Add("mov")
	AllowedExtensions.Add("avi")
	AllowedExtensions.Add("mkv")
	AllowedExtensions.Add("webm")
	AllowedExtensions.Add("3gp")

	'Documentos
	AllowedExtensions.Add("pdf")
	AllowedExtensions.Add("doc")
	AllowedExtensions.Add("docx")
	AllowedExtensions.Add("xls")
	AllowedExtensions.Add("xlsx")
	AllowedExtensions.Add("ppt")
	AllowedExtensions.Add("pptx")
	AllowedExtensions.Add("odt")
	AllowedExtensions.Add("ods")

	'Texto
	AllowedExtensions.Add("txt")
	AllowedExtensions.Add("csv")
	AllowedExtensions.Add("json")
	AllowedExtensions.Add("xml")
	AllowedExtensions.Add("html")
	AllowedExtensions.Add("htm")

	'Cria estrutura de pastas
	EnsureFolders

	mInitialized = True
	Log("ModAttachments: Inicializado")
End Sub

Private Sub EnsureInit
	If mInitialized = False Then Init
End Sub

'Garante que pastas existem
Private Sub EnsureFolders
	'Pasta de anexos
	If File.Exists(File.DirInternal, ATTACHMENTS_FOLDER) = False Then
		File.MakeDir(File.DirInternal, ATTACHMENTS_FOLDER)
		Log("ModAttachments: Pasta Attachments criada")
	End If

	'Pasta temporaria
	If File.Exists(File.DirInternal, TEMP_FOLDER) = False Then
		File.MakeDir(File.DirInternal, TEMP_FOLDER)
		Log("ModAttachments: Pasta Temp criada")
	End If
End Sub

'Garante que pasta do note existe
Private Sub EnsureNoteFolder(noteId As String)
	Dim noteFolder As String = ATTACHMENTS_FOLDER & "/" & noteId
	If File.Exists(File.DirInternal, noteFolder) = False Then
		File.MakeDir(File.DirInternal, noteFolder)
	End If
End Sub

' ============================================
'  ADICIONAR ANEXO
' ============================================

'Adiciona anexo a uma nota
'noteId: ID da nota
'sourceDir: diretorio do arquivo original
'sourceFile: nome do arquivo original
'passphrase: frase-senha para criptografia
'salt: salt do grupo para criptografia
'Retorna: Map com info do anexo ou Null se falhar
Public Sub AddAttachment(noteId As String, sourceDir As String, sourceFile As String, passphrase As String, salt As String) As Map
	EnsureInit

	'Valida parametros
	If noteId.Length = 0 Or sourceFile.Length = 0 Or passphrase.Length = 0 Then
		Log("AddAttachment: parametros invalidos")
		Return Null
	End If

	'Verifica se arquivo existe
	If File.Exists(sourceDir, sourceFile) = False Then
		Log("AddAttachment: arquivo nao existe - " & sourceFile)
		Return Null
	End If

	'Verifica extensao permitida
	Dim ext As String = GetFileExtension(sourceFile).ToLowerCase
	If IsExtensionAllowed(ext) = False Then
		Log("AddAttachment: extensao nao permitida - " & ext)
		Return Null
	End If

	'Verifica tamanho do arquivo
	Dim fileSize As Long = File.Size(sourceDir, sourceFile)
	If fileSize > MAX_FILE_SIZE Then
		Log("AddAttachment: arquivo muito grande - " & fileSize & " bytes (max " & MAX_FILE_SIZE & ")")
		Return Null
	End If

	'Verifica espaco disponivel na nota
	If CanAddAttachment(noteId, fileSize) = False Then
		Log("AddAttachment: limite de espaco excedido")
		Return Null
	End If

	Try
		'Gera ID unico para o anexo
		Dim attachId As String = ModSecurity.GenerateUUID

		'Le arquivo original
		Dim originalBytes() As Byte = File.ReadBytes(sourceDir, sourceFile)

		'Cria estrutura de metadados
		Dim metadata As Map
		metadata.Initialize
		metadata.Put("version", ATTACHMENT_VERSION)
		metadata.Put("id", attachId)
		metadata.Put("noteId", noteId)
		metadata.Put("originalName", sourceFile)
		metadata.Put("originalSize", fileSize)
		metadata.Put("mimeType", GetMimeType(sourceFile))
		metadata.Put("createdAt", DateTime.Now)

		'Converte bytes para Base64 para incluir no JSON
		Dim su As StringUtils
		Dim dataBase64 As String = su.EncodeBase64(originalBytes)

		'Criptografa os dados (Base64 -> encrypted)
		Dim encryptedData As String = ModSecurity.EncryptWithSalt(passphrase, salt, dataBase64)
		If encryptedData.Length = 0 Then
			Log("AddAttachment: erro na criptografia")
			Return Null
		End If

		metadata.Put("encryptedData", encryptedData)

		'Calcula checksum do original (para verificacao de integridade)
		Dim md As MessageDigest
		Dim checksumBytes() As Byte = md.GetMessageDigest(originalBytes, "SHA-256")
		metadata.Put("checksum", BytesToHex(checksumBytes))

		'Garante que pasta da nota existe
		EnsureNoteFolder(noteId)

		'Salva arquivo .lza
		Dim gen As JSONGenerator
		gen.Initialize(metadata)
		Dim lzaContent As String = gen.ToPrettyString(2)

		Dim lzaPath As String = ATTACHMENTS_FOLDER & "/" & noteId & "/" & attachId & LZA_EXTENSION
		File.WriteString(File.DirInternal, lzaPath, lzaContent)

		'Limpa dados sensiveis
		ZeroBytes(originalBytes)

		'Retorna info do anexo (sem dados criptografados)
		Dim result As Map
		result.Initialize
		result.Put("id", attachId)
		result.Put("originalName", sourceFile)
		result.Put("originalSize", fileSize)
		result.Put("mimeType", GetMimeType(sourceFile))
		result.Put("createdAt", DateTime.Now)

		Log("AddAttachment: anexo salvo - " & sourceFile & " (" & FormatFileSize(fileSize) & ")")
		Return result

	Catch
		Log("AddAttachment erro: " & LastException.Message)
		Return Null
	End Try
End Sub

' ============================================
'  OBTER ANEXO
' ============================================

'Obtem anexo descriptografado e salva em pasta temporaria
'noteId: ID da nota
'attachId: ID do anexo
'passphrase: frase-senha para descriptografia
'salt: salt do grupo
'Retorna: caminho completo do arquivo temporario ou "" se falhar
Public Sub GetAttachment(noteId As String, attachId As String, passphrase As String, salt As String) As String
	EnsureInit

	'Le arquivo .lza
	Dim lzaPath As String = ATTACHMENTS_FOLDER & "/" & noteId & "/" & attachId & LZA_EXTENSION
	If File.Exists(File.DirInternal, lzaPath) = False Then
		Log("GetAttachment: arquivo nao encontrado - " & lzaPath)
		Return ""
	End If

	Try
		Dim json As String = File.ReadString(File.DirInternal, lzaPath)
		Dim parser As JSONParser
		parser.Initialize(json)
		Dim metadata As Map = parser.NextObject

		'Descriptografa dados
		Dim encryptedData As String = metadata.Get("encryptedData")
		Dim dataBase64 As String = ModSecurity.DecryptWithSalt(passphrase, salt, encryptedData)

		If dataBase64.Length = 0 Then
			Log("GetAttachment: erro na descriptografia")
			Return ""
		End If

		'Converte Base64 para bytes
		Dim su As StringUtils
		Dim originalBytes() As Byte = su.DecodeBase64(dataBase64)

		'Verifica checksum (integridade)
		If metadata.ContainsKey("checksum") Then
			Dim md As MessageDigest
			Dim checksumBytes() As Byte = md.GetMessageDigest(originalBytes, "SHA-256")
			Dim calculatedChecksum As String = BytesToHex(checksumBytes)
			Dim savedChecksum As String = metadata.Get("checksum")

			If calculatedChecksum <> savedChecksum Then
				Log("GetAttachment: CHECKSUM INVALIDO - dados corrompidos!")
				Return ""
			End If
		End If

		'Salva em pasta temporaria
		Dim originalName As String = metadata.Get("originalName")
		Dim tempPath As String = TEMP_FOLDER & "/" & attachId & "_" & originalName

		'Remove arquivo temp anterior se existir
		If File.Exists(File.DirInternal, tempPath) Then
			File.Delete(File.DirInternal, tempPath)
		End If

		File.WriteBytes(File.DirInternal, tempPath, originalBytes)

		'Limpa dados sensiveis
		ZeroBytes(originalBytes)

		Log("GetAttachment: arquivo extraido para " & tempPath)
		Return File.Combine(File.DirInternal, tempPath)

	Catch
		Log("GetAttachment erro: " & LastException.Message)
		Return ""
	End Try
End Sub

'Obtem informacoes do anexo (sem descriptografar)
'Retorna Map com id, originalName, originalSize, mimeType, createdAt
Public Sub GetAttachmentInfo(noteId As String, attachId As String) As Map
	EnsureInit

	Dim lzaPath As String = ATTACHMENTS_FOLDER & "/" & noteId & "/" & attachId & LZA_EXTENSION
	If File.Exists(File.DirInternal, lzaPath) = False Then
		Return Null
	End If

	Try
		Dim json As String = File.ReadString(File.DirInternal, lzaPath)
		Dim parser As JSONParser
		parser.Initialize(json)
		Dim metadata As Map = parser.NextObject

		'Retorna apenas info (sem dados criptografados)
		Dim result As Map
		result.Initialize
		result.Put("id", metadata.Get("id"))
		result.Put("originalName", metadata.Get("originalName"))
		result.Put("originalSize", metadata.Get("originalSize"))
		result.Put("mimeType", metadata.Get("mimeType"))
		result.Put("createdAt", metadata.Get("createdAt"))

		Return result

	Catch
		Log("GetAttachmentInfo erro: " & LastException.Message)
		Return Null
	End Try
End Sub

' ============================================
'  LISTAR ANEXOS
' ============================================

'Lista todos os anexos de uma nota
'Retorna lista de Maps com info de cada anexo
Public Sub ListAttachments(noteId As String) As List
	EnsureInit

	Dim result As List
	result.Initialize

	Dim noteFolder As String = ATTACHMENTS_FOLDER & "/" & noteId
	If File.Exists(File.DirInternal, noteFolder) = False Then
		Return result
	End If

	Try
		Dim files As List = File.ListFiles(File.Combine(File.DirInternal, noteFolder))

		For i = 0 To files.Size - 1
			Dim fileName As String = files.Get(i)
			If fileName.EndsWith(LZA_EXTENSION) Then
				Dim attachId As String = fileName.Replace(LZA_EXTENSION, "")
				Dim info As Map = GetAttachmentInfo(noteId, attachId)
				If info <> Null Then
					result.Add(info)
				End If
			End If
		Next

	Catch
		Log("ListAttachments erro: " & LastException.Message)
	End Try

	Return result
End Sub

'Conta anexos de uma nota
Public Sub CountAttachments(noteId As String) As Int
	Dim attachments As List = ListAttachments(noteId)
	Return attachments.Size
End Sub

' ============================================
'  DELETAR ANEXOS
' ============================================

'Deleta um anexo especifico
Public Sub DeleteAttachment(noteId As String, attachId As String) As Boolean
	EnsureInit

	Dim lzaPath As String = ATTACHMENTS_FOLDER & "/" & noteId & "/" & attachId & LZA_EXTENSION
	If File.Exists(File.DirInternal, lzaPath) = False Then
		Return False
	End If

	Try
		File.Delete(File.DirInternal, lzaPath)
		Log("DeleteAttachment: " & attachId & " removido")

		'Remove pasta da nota se estiver vazia
		CleanEmptyNoteFolder(noteId)

		Return True

	Catch
		Log("DeleteAttachment erro: " & LastException.Message)
		Return False
	End Try
End Sub

'Deleta todos os anexos de uma nota
Public Sub DeleteAllAttachments(noteId As String) As Boolean
	EnsureInit

	Dim noteFolder As String = ATTACHMENTS_FOLDER & "/" & noteId
	If File.Exists(File.DirInternal, noteFolder) = False Then
		Return True  'Nada para deletar
	End If

	Try
		Dim files As List = File.ListFiles(File.Combine(File.DirInternal, noteFolder))

		For i = 0 To files.Size - 1
			Dim fileName As String = files.Get(i)
			File.Delete(File.DirInternal, noteFolder & "/" & fileName)
		Next

		'Remove pasta da nota
		File.Delete(File.DirInternal, noteFolder)

		Log("DeleteAllAttachments: " & files.Size & " anexos removidos da nota " & noteId)
		Return True

	Catch
		Log("DeleteAllAttachments erro: " & LastException.Message)
		Return False
	End Try
End Sub

'Remove pasta da nota se estiver vazia
Private Sub CleanEmptyNoteFolder(noteId As String)
	Dim noteFolder As String = ATTACHMENTS_FOLDER & "/" & noteId
	If File.Exists(File.DirInternal, noteFolder) = False Then Return

	Try
		Dim files As List = File.ListFiles(File.Combine(File.DirInternal, noteFolder))
		If files.Size = 0 Then
			File.Delete(File.DirInternal, noteFolder)
			Log("CleanEmptyNoteFolder: pasta " & noteId & " removida")
		End If
	Catch
		'Ignora erro
	End Try
End Sub

' ============================================
'  VALIDACAO DE TAMANHO
' ============================================

'Verifica se arquivo tem tamanho valido
Public Sub ValidateFileSize(sourceDir As String, sourceFile As String) As Boolean
	If File.Exists(sourceDir, sourceFile) = False Then Return False

	Dim size As Long = File.Size(sourceDir, sourceFile)
	Return size <= MAX_FILE_SIZE
End Sub

'Verifica se pode adicionar anexo a nota (considerando limites)
Public Sub CanAddAttachment(noteId As String, newFileSize As Long) As Boolean
	EnsureInit

	'Verifica limite por arquivo
	If newFileSize > MAX_FILE_SIZE Then Return False

	'Verifica limite por nota
	Dim noteSize As Long = GetTotalNoteSize(noteId)
	If noteSize + newFileSize > MAX_TOTAL_NOTE Then Return False

	'Verifica limite total de anexos (definido em Starter)
	Dim appSize As Long = GetTotalAppSize
	If appSize + newFileSize > Starter.MAX_ATTACHMENTS_SIZE Then Return False

	Return True
End Sub

'Calcula tamanho total de anexos de uma nota
Public Sub GetTotalNoteSize(noteId As String) As Long
	EnsureInit

	Dim total As Long = 0
	Dim noteFolder As String = ATTACHMENTS_FOLDER & "/" & noteId

	If File.Exists(File.DirInternal, noteFolder) = False Then
		Return 0
	End If

	Try
		Dim files As List = File.ListFiles(File.Combine(File.DirInternal, noteFolder))

		For i = 0 To files.Size - 1
			Dim fileName As String = files.Get(i)
			Dim filePath As String = noteFolder & "/" & fileName
			total = total + File.Size(File.DirInternal, filePath)
		Next

	Catch
		Log("GetTotalNoteSize erro: " & LastException.Message)
	End Try

	Return total
End Sub

'Calcula tamanho total de todos os anexos do app
Public Sub GetTotalAppSize As Long
	EnsureInit

	Dim total As Long = 0

	If File.Exists(File.DirInternal, ATTACHMENTS_FOLDER) = False Then
		Return 0
	End If

	Try
		'Lista todas as subpastas (uma por nota)
		Dim noteFolders As List = File.ListFiles(File.Combine(File.DirInternal, ATTACHMENTS_FOLDER))

		For i = 0 To noteFolders.Size - 1
			Dim noteFolder As String = noteFolders.Get(i)
			Dim notePath As String = ATTACHMENTS_FOLDER & "/" & noteFolder

			'Lista arquivos dentro da pasta da nota
			Dim files As List = File.ListFiles(File.Combine(File.DirInternal, notePath))

			For j = 0 To files.Size - 1
				Dim fileName As String = files.Get(j)
				Dim filePath As String = notePath & "/" & fileName
				total = total + File.Size(File.DirInternal, filePath)
			Next
		Next

	Catch
		Log("GetTotalAppSize erro: " & LastException.Message)
	End Try

	Return total
End Sub

'Retorna espaco disponivel para anexos (considerando limite definido em Starter)
Public Sub GetAvailableSpace As Long
	Dim used As Long = GetTotalAppSize
	Dim available As Long = Starter.MAX_ATTACHMENTS_SIZE - used
	If available < 0 Then available = 0
	Return available
End Sub

'Retorna limite total de anexos (FREE: 25MB, PREMIUM: configuravel)
Public Sub GetMaxAttachmentsSize As Long
	Return Starter.MAX_ATTACHMENTS_SIZE
End Sub

' ============================================
'  BACKUP E RESTORE
' ============================================

'Exporta todos os anexos de uma nota para backup
'Retorna lista de Maps com dados criptografados
Public Sub ExportAttachmentsForBackup(noteId As String) As List
	EnsureInit

	Dim result As List
	result.Initialize

	Dim noteFolder As String = ATTACHMENTS_FOLDER & "/" & noteId
	If File.Exists(File.DirInternal, noteFolder) = False Then
		Return result
	End If

	Try
		Dim files As List = File.ListFiles(File.Combine(File.DirInternal, noteFolder))

		For i = 0 To files.Size - 1
			Dim fileName As String = files.Get(i)
			If fileName.EndsWith(LZA_EXTENSION) Then
				Dim filePath As String = noteFolder & "/" & fileName
				Dim json As String = File.ReadString(File.DirInternal, filePath)

				Dim parser As JSONParser
				parser.Initialize(json)
				Dim metadata As Map = parser.NextObject

				'Inclui todos os dados (incluindo encryptedData)
				result.Add(metadata)
			End If
		Next

	Catch
		Log("ExportAttachmentsForBackup erro: " & LastException.Message)
	End Try

	Return result
End Sub

'Importa anexos de backup para uma nota
'attachmentsList: lista de Maps com dados do backup
Public Sub ImportAttachmentsFromBackup(noteId As String, attachmentsList As List) As Int
	EnsureInit

	If attachmentsList = Null Or attachmentsList.Size = 0 Then
		Return 0
	End If

	Dim imported As Int = 0

	'Garante que pasta da nota existe
	EnsureNoteFolder(noteId)

	For i = 0 To attachmentsList.Size - 1
		Try
			Dim metadata As Map = attachmentsList.Get(i)
			Dim attachId As String = metadata.Get("id")

			'Verifica se ja existe
			Dim lzaPath As String = ATTACHMENTS_FOLDER & "/" & noteId & "/" & attachId & LZA_EXTENSION
			If File.Exists(File.DirInternal, lzaPath) Then
				Log("ImportAttachmentsFromBackup: anexo " & attachId & " ja existe, pulando")
				Continue
			End If

			'Salva arquivo .lza
			Dim gen As JSONGenerator
			gen.Initialize(metadata)
			File.WriteString(File.DirInternal, lzaPath, gen.ToPrettyString(2))

			imported = imported + 1

		Catch
			Log("ImportAttachmentsFromBackup erro item " & i & ": " & LastException.Message)
		End Try
	Next

	Log("ImportAttachmentsFromBackup: " & imported & " anexos importados para nota " & noteId)
	Return imported
End Sub

' ============================================
'  LIMPEZA
' ============================================

'Limpa arquivos temporarios
Public Sub CleanupTempFiles
	EnsureInit

	If File.Exists(File.DirInternal, TEMP_FOLDER) = False Then
		Return
	End If

	Try
		Dim files As List = File.ListFiles(File.Combine(File.DirInternal, TEMP_FOLDER))
		Dim deleted As Int = 0

		For i = 0 To files.Size - 1
			Dim fileName As String = files.Get(i)
			File.Delete(File.DirInternal, TEMP_FOLDER & "/" & fileName)
			deleted = deleted + 1
		Next

		If deleted > 0 Then
			Log("CleanupTempFiles: " & deleted & " arquivos removidos")
		End If

	Catch
		Log("CleanupTempFiles erro: " & LastException.Message)
	End Try
End Sub

'Limpa anexos orfaos (de notas que nao existem mais)
Public Sub CleanupOrphanAttachments
	EnsureInit

	If File.Exists(File.DirInternal, ATTACHMENTS_FOLDER) = False Then
		Return
	End If

	Try
		Dim noteFolders As List = File.ListFiles(File.Combine(File.DirInternal, ATTACHMENTS_FOLDER))
		Dim deleted As Int = 0

		For i = 0 To noteFolders.Size - 1
			Dim noteId As String = noteFolders.Get(i)

			'Verifica se nota existe
			Dim note As Object = ModNotes.GetNoteById(noteId)
			If note = Null Then
				'Nota nao existe - deletar anexos
				DeleteAllAttachments(noteId)
				deleted = deleted + 1
			End If
		Next

		If deleted > 0 Then
			Log("CleanupOrphanAttachments: " & deleted & " pastas orfas removidas")
		End If

	Catch
		Log("CleanupOrphanAttachments erro: " & LastException.Message)
	End Try
End Sub

' ============================================
'  UTILITARIOS
' ============================================

'Verifica se extensao e permitida
Public Sub IsExtensionAllowed(ext As String) As Boolean
	EnsureInit
	Return AllowedExtensions.IndexOf(ext.ToLowerCase) >= 0
End Sub

'Retorna extensao do arquivo (sem ponto)
Private Sub GetFileExtension(fileName As String) As String
	Dim lastDot As Int = fileName.LastIndexOf(".")
	If lastDot < 0 Then Return ""
	Return fileName.SubString(lastDot + 1)
End Sub

'Retorna MIME type baseado na extensao
Public Sub GetMimeType(fileName As String) As String
	Dim ext As String = GetFileExtension(fileName).ToLowerCase

	Select ext
		'Imagens
		Case "jpg", "jpeg": Return "image/jpeg"
		Case "png": Return "image/png"
		Case "gif": Return "image/gif"
		Case "webp": Return "image/webp"
		Case "heic": Return "image/heic"
		Case "bmp": Return "image/bmp"

		'Videos
		Case "mp4": Return "video/mp4"
		Case "mov": Return "video/quicktime"
		Case "avi": Return "video/x-msvideo"
		Case "mkv": Return "video/x-matroska"
		Case "webm": Return "video/webm"
		Case "3gp": Return "video/3gpp"

		'Documentos
		Case "pdf": Return "application/pdf"
		Case "doc": Return "application/msword"
		Case "docx": Return "application/vnd.openxmlformats-officedocument.wordprocessingml.document"
		Case "xls": Return "application/vnd.ms-excel"
		Case "xlsx": Return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
		Case "ppt": Return "application/vnd.ms-powerpoint"
		Case "pptx": Return "application/vnd.openxmlformats-officedocument.presentationml.presentation"
		Case "odt": Return "application/vnd.oasis.opendocument.text"
		Case "ods": Return "application/vnd.oasis.opendocument.spreadsheet"

		'Texto
		Case "txt": Return "text/plain"
		Case "csv": Return "text/csv"
		Case "json": Return "application/json"
		Case "xml": Return "application/xml"
		Case "html", "htm": Return "text/html"

		Case Else: Return "application/octet-stream"
	End Select
End Sub

'Retorna icone emoji baseado no MIME type
Public Sub GetFileIcon(mimeType As String) As String
	If mimeType.StartsWith("image/") Then
		Return Chr(0xD83D) & Chr(0xDCF7)  'camera (foto)
	Else If mimeType.StartsWith("video/") Then
		Return Chr(0xD83C) & Chr(0xDFAC)  'claquete (video)
	Else If mimeType.StartsWith("text/") Then
		Return Chr(0xD83D) & Chr(0xDCDD)  'memo (texto)
	Else If mimeType = "application/pdf" Then
		Return Chr(0xD83D) & Chr(0xDCC4)  'documento
	Else
		Return Chr(0xD83D) & Chr(0xDCC1)  'pasta
	End If
End Sub

'Formata tamanho de arquivo para exibicao
Public Sub FormatFileSize(sizeBytes As Long) As String
	If sizeBytes < 1024 Then
		Return sizeBytes & " B"
	Else If sizeBytes < 1048576 Then
		Return NumberFormat2(sizeBytes / 1024, 1, 1, 1, False) & " KB"
	Else
		Return NumberFormat2(sizeBytes / 1048576, 1, 1, 1, False) & " MB"
	End If
End Sub

'Converte array de bytes para string hexadecimal
Private Sub BytesToHex(bytes() As Byte) As String
	Dim sb As StringBuilder
	sb.Initialize
	For Each b As Byte In bytes
		Dim hex As String = Bit.ToHexString(Bit.And(b, 0xFF))
		If hex.Length = 1 Then sb.Append("0")
		sb.Append(hex.ToLowerCase)
	Next
	Return sb.ToString
End Sub

'Zera array de bytes para remover dados sensiveis
Private Sub ZeroBytes(bytes() As Byte)
	If bytes = Null Then Return
	For i = 0 To bytes.Length - 1
		bytes(i) = 0
	Next
End Sub
