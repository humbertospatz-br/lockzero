B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
'clsNoteEntry.bas - Modelo de Nota Segura
'LockZero - Lock and ZERO worries

Sub Class_Globals
	Public Id As String
	Public Title As String         'Titulo da nota (criptografado)
	Public Content As String       'Conteudo da nota (criptografado)
	Public GroupId As String       'Grupo ao qual pertence
	Public IsFavorite As Boolean   'Marcado como favorito
	Public Color As Int            'Cor da nota (opcional)
	Public CreatedAt As Long
	Public UpdatedAt As Long
End Sub

Public Sub Initialize
	Id = ""
	Title = ""
	Content = ""
	GroupId = ""
	IsFavorite = False
	Color = 0
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
	m.Put("groupId", GroupId)
	m.Put("isFavorite", IsFavorite)
	m.Put("color", Color)
	m.Put("createdAt", CreatedAt)
	m.Put("updatedAt", UpdatedAt)
	Return m
End Sub

'Carrega de um Map
Public Sub FromMap(m As Map)
	Id = m.GetDefault("id", "")
	Title = m.GetDefault("title", "")
	Content = m.GetDefault("content", "")
	GroupId = m.GetDefault("groupId", "")
	IsFavorite = m.GetDefault("isFavorite", False)
	Color = m.GetDefault("color", 0)
	CreatedAt = m.GetDefault("createdAt", DateTime.Now)
	UpdatedAt = m.GetDefault("updatedAt", DateTime.Now)
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
