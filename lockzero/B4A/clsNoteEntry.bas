B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
'clsNoteEntry.bas - Modelo de Nota Segura
'LockZero - Lock and ZERO worries
'
'NoteType:
'- "text": Nota tradicional com titulo e conteudo livre
'- "list": Lista de tarefas com itens marcaveis (checkbox)

Sub Class_Globals
	Public Id As String
	Public Title As String         'Titulo da nota (criptografado se grupo seguro)
	Public Content As String       'Conteudo texto livre (criptografado se grupo seguro)
	Public NoteType As String      '"text" ou "list"
	Public Items As String         'JSON array de itens para lista: [{text, checked}, ...]
	Public Attachments As String   'JSON array de caminhos de arquivos anexados
	Public GroupId As String       'Grupo ao qual pertence
	Public SortOrder As Int        'Ordem manual (drag & drop)
	Public IsFavorite As Boolean   'Marcado como favorito
	Public CreatedAt As Long
	Public UpdatedAt As Long
End Sub

Public Sub Initialize
	Id = ""
	Title = ""
	Content = ""
	NoteType = "text"  'Padrao: nota de texto
	Items = "[]"       'Array vazio
	Attachments = "[]" 'Array vazio de anexos
	GroupId = ""
	SortOrder = 0
	IsFavorite = False
	CreatedAt = DateTime.Now
	UpdatedAt = DateTime.Now
End Sub

'Converte para Map para salvar em JSON
Public Sub ToMap As Map
	Dim m As Map
	m.Initialize
	m.Put("id", Id)
	m.Put("title", Title)
	m.Put("content", Content)
	m.Put("noteType", NoteType)
	m.Put("items", Items)
	m.Put("attachments", Attachments)
	m.Put("groupId", GroupId)
	m.Put("sortOrder", SortOrder)
	m.Put("isFavorite", IsFavorite)
	m.Put("createdAt", CreatedAt)
	m.Put("updatedAt", UpdatedAt)
	Return m
End Sub

'Carrega de um Map
Public Sub FromMap(m As Map)
	Id = m.GetDefault("id", "")
	Title = m.GetDefault("title", "")
	Content = m.GetDefault("content", "")
	NoteType = m.GetDefault("noteType", "text")
	GroupId = m.GetDefault("groupId", "")
	SortOrder = m.GetDefault("sortOrder", 0)
	IsFavorite = m.GetDefault("isFavorite", False)
	CreatedAt = m.GetDefault("createdAt", DateTime.Now)
	UpdatedAt = m.GetDefault("updatedAt", DateTime.Now)

	'Items pode ser String JSON ou List - tratar ambos
	If m.ContainsKey("items") Then
		Dim itemsValue As Object = m.Get("items")
		If itemsValue Is String Then
			Items = itemsValue
		Else If itemsValue Is List Then
			'Converter List para JSON string
			Dim gen As JSONGenerator
			gen.Initialize(itemsValue)
			Items = gen.ToString
		Else
			Items = "[]"
		End If
	Else
		Items = "[]"
	End If

	'Attachments - mesmo tratamento que Items
	If m.ContainsKey("attachments") Then
		Dim attachValue As Object = m.Get("attachments")
		If attachValue Is String Then
			Attachments = attachValue
		Else If attachValue Is List Then
			Dim genAtt As JSONGenerator
			genAtt.Initialize2(attachValue)
			Attachments = genAtt.ToString
		Else
			Attachments = "[]"
		End If
	Else
		Attachments = "[]"
	End If
End Sub

'Retorna titulo descriptografado
Public Sub GetDecryptedTitle(passPhrase As String) As String
	If ModSecurity.IsEncrypted(Title) Then
		Return ModSecurity.Decrypt(passPhrase, Title)
	End If
	Return Title
End Sub

'Retorna conteudo descriptografado
Public Sub GetDecryptedContent(passPhrase As String) As String
	If ModSecurity.IsEncrypted(Content) Then
		Return ModSecurity.Decrypt(passPhrase, Content)
	End If
	Return Content
End Sub

'Criptografa o titulo
Public Sub EncryptTitle(passPhrase As String, plainTitle As String)
	Title = ModSecurity.Encrypt(passPhrase, plainTitle)
	UpdatedAt = DateTime.Now
End Sub

'Criptografa o conteudo
Public Sub EncryptContent(passPhrase As String, plainContent As String)
	Content = ModSecurity.Encrypt(passPhrase, plainContent)
	UpdatedAt = DateTime.Now
End Sub

'===========================================
' METODOS PARA TIPO DE NOTA
'===========================================

'Retorna se e nota de texto
Public Sub IsTextNote As Boolean
	Return NoteType = "text"
End Sub

'Retorna se e nota de lista
Public Sub IsListNote As Boolean
	Return NoteType = "list"
End Sub

'===========================================
' METODOS PARA ITENS DA LISTA
'===========================================

'Retorna lista de itens como List de Maps [{text, checked}, ...]
Public Sub GetItemsList As List
	Dim itemsList As List
	itemsList.Initialize
	Try
		If Items = "" Or Items = "[]" Then Return itemsList
		Dim parser As JSONParser
		parser.Initialize(Items)
		itemsList = parser.NextArray
	Catch
		Log("clsNoteEntry.GetItemsList error: " & LastException.Message)
	End Try
	Return itemsList
End Sub

'Define lista de itens a partir de List de Maps
Public Sub SetItemsList(itemsList As List)
	'Trata lista nula ou vazia
	If itemsList = Null Or itemsList.IsInitialized = False Then
		Items = "[]"
		UpdatedAt = DateTime.Now
		Return
	End If

	If itemsList.Size = 0 Then
		Items = "[]"
		UpdatedAt = DateTime.Now
		Return
	End If

	'Lista com itens - converte para JSON
	Dim gen As JSONGenerator
	gen.Initialize2(itemsList)  'Initialize2 para List (Initialize e para Map)
	Items = gen.ToString
	UpdatedAt = DateTime.Now
End Sub

'Retorna quantidade total de itens
Public Sub GetItemsCount As Int
	Dim itemsList As List = GetItemsList
	Return itemsList.Size
End Sub

'Retorna quantidade de itens marcados (checked)
Public Sub GetCheckedCount As Int
	Dim itemsList As List = GetItemsList
	Dim count As Int = 0
	For Each item As Map In itemsList
		If item.GetDefault("checked", False) = True Then
			count = count + 1
		End If
	Next
	Return count
End Sub

'Adiciona novo item a lista
Public Sub AddItem(text As String)
	Dim itemsList As List = GetItemsList
	Dim newItem As Map
	newItem.Initialize
	newItem.Put("text", text)
	newItem.Put("checked", False)
	itemsList.Add(newItem)
	SetItemsList(itemsList)
End Sub

'Alterna estado checked de um item pelo indice
Public Sub ToggleItem(index As Int)
	Dim itemsList As List = GetItemsList
	If index >= 0 And index < itemsList.Size Then
		Dim item As Map = itemsList.Get(index)
		Dim currentState As Boolean = item.GetDefault("checked", False)
		item.Put("checked", Not(currentState))
		SetItemsList(itemsList)
	End If
End Sub

'Remove item pelo indice
Public Sub RemoveItem(index As Int)
	Dim itemsList As List = GetItemsList
	If index >= 0 And index < itemsList.Size Then
		itemsList.RemoveAt(index)
		SetItemsList(itemsList)
	End If
End Sub

'Atualiza texto de um item
Public Sub UpdateItemText(index As Int, newText As String)
	Dim itemsList As List = GetItemsList
	If index >= 0 And index < itemsList.Size Then
		Dim item As Map = itemsList.Get(index)
		item.Put("text", newText)
		SetItemsList(itemsList)
	End If
End Sub

'===========================================
' METODOS PARA PREVIEW
'===========================================

'Retorna preview para exibicao na lista
'Texto: primeiros 50 chars do conteudo
'Lista: "X de Y itens"
Public Sub GetPreview(passPhrase As String, isSecure As Boolean) As String
	If NoteType = "list" Then
		Dim total As Int = GetItemsCount
		Dim checked As Int = GetCheckedCount
		Return checked & " de " & total & " itens"
	Else
		'Nota de texto - preview do conteudo
		Dim preview As String = ""
		If isSecure And passPhrase <> "" Then
			preview = GetDecryptedContent(passPhrase)
		Else If Not(isSecure) Then
			preview = Content
		End If
		If preview.Length > 50 Then
			preview = preview.SubString2(0, 50) & "..."
		End If
		Return preview
	End If
End Sub

'===========================================
' METODOS PARA CRIPTOGRAFIA DE ITENS
'===========================================

'Criptografa Items (para grupos seguros)
Public Sub EncryptItems(passPhrase As String, plainItems As String)
	Items = ModSecurity.Encrypt(passPhrase, plainItems)
	UpdatedAt = DateTime.Now
End Sub

'Retorna Items descriptografado
Public Sub GetDecryptedItems(passPhrase As String) As String
	If ModSecurity.IsEncrypted(Items) Then
		Return ModSecurity.Decrypt(passPhrase, Items)
	End If
	Return Items
End Sub

'===========================================
' METODOS PARA ANEXOS
'===========================================

'Retorna lista de anexos como List de Strings (caminhos)
Public Sub GetAttachmentsList As List
	Dim attachList As List
	attachList.Initialize
	Try
		If Attachments = "" Or Attachments = "[]" Then Return attachList
		Dim parser As JSONParser
		parser.Initialize(Attachments)
		attachList = parser.NextArray
	Catch
		Log("clsNoteEntry.GetAttachmentsList error: " & LastException.Message)
	End Try
	Return attachList
End Sub

'Define lista de anexos a partir de List de Strings
Public Sub SetAttachmentsList(attachList As List)
	If attachList = Null Or attachList.IsInitialized = False Or attachList.Size = 0 Then
		Attachments = "[]"
	Else
		Dim gen As JSONGenerator
		gen.Initialize2(attachList)
		Attachments = gen.ToString
	End If
	UpdatedAt = DateTime.Now
End Sub

'Adiciona um anexo
Public Sub AddAttachment(filePath As String)
	Dim attachList As List = GetAttachmentsList
	If attachList.IndexOf(filePath) = -1 Then  'Evita duplicatas
		attachList.Add(filePath)
		SetAttachmentsList(attachList)
	End If
End Sub

'Remove um anexo pelo indice
Public Sub RemoveAttachment(index As Int)
	Dim attachList As List = GetAttachmentsList
	If index >= 0 And index < attachList.Size Then
		attachList.RemoveAt(index)
		SetAttachmentsList(attachList)
	End If
End Sub

'Retorna quantidade de anexos
Public Sub GetAttachmentsCount As Int
	Dim attachList As List = GetAttachmentsList
	Return attachList.Size
End Sub

'Criptografa Attachments (para grupos seguros)
Public Sub EncryptAttachments(passPhrase As String, plainAttachments As String)
	Attachments = ModSecurity.Encrypt(passPhrase, plainAttachments)
	UpdatedAt = DateTime.Now
End Sub

'Retorna Attachments descriptografado
Public Sub GetDecryptedAttachments(passPhrase As String) As String
	If ModSecurity.IsEncrypted(Attachments) Then
		Return ModSecurity.Decrypt(passPhrase, Attachments)
	End If
	Return Attachments
End Sub
