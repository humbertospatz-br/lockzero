B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
'clsPasswordEntry.bas - Classe Entrada de Senha
'LockZero - Site/App, usuario, senha criptografada

Sub Class_Globals
	Public Id As String
	Public GroupId As String           'ID do grupo ao qual pertence
	Public Name As String              'Nome amigavel (Ex: "Google Pessoal")
	Public Url As String               'URL do site (Ex: "https://google.com")
	Public Username As String          'Usuario ou email (CRIPTOGRAFADO)
	Public PasswordEnc As String       'Senha (CRIPTOGRAFADA)
	Public Notes As String             'Anotacoes opcionais (CRIPTOGRAFADO)
	Public IsFavorite As Boolean       'Marcado como favorito
	Public LastUsed As Long            'Ultima vez que foi usado/copiado
	Public CreatedAt As Long
	Public UpdatedAt As Long
End Sub

Public Sub Initialize
	Id = ""
	GroupId = ""
	Name = ""
	Url = ""
	Username = ""
	PasswordEnc = ""
	Notes = ""
	IsFavorite = False
	LastUsed = 0
	CreatedAt = DateTime.Now
	UpdatedAt = DateTime.Now
End Sub

Public Sub IsInitialized As Boolean
	Return Id <> ""
End Sub

'Cria copia do objeto
Public Sub Clone As clsPasswordEntry
	Dim e As clsPasswordEntry
	e.Initialize
	e.Id = Id
	e.GroupId = GroupId
	e.Name = Name
	e.Url = Url
	e.Username = Username
	e.PasswordEnc = PasswordEnc
	e.Notes = Notes
	e.IsFavorite = IsFavorite
	e.LastUsed = LastUsed
	e.CreatedAt = CreatedAt
	e.UpdatedAt = UpdatedAt
	Return e
End Sub

'Converte para Map (para JSON)
Public Sub ToMap As Map
	Dim m As Map
	m.Initialize
	m.Put("id", Id)
	m.Put("groupId", GroupId)
	m.Put("name", Name)
	m.Put("url", Url)
	m.Put("username", Username)
	m.Put("passwordEnc", PasswordEnc)
	m.Put("notes", Notes)
	m.Put("isFavorite", IsFavorite)
	m.Put("lastUsed", LastUsed)
	m.Put("createdAt", CreatedAt)
	m.Put("updatedAt", UpdatedAt)
	Return m
End Sub

'Carrega de Map (de JSON)
Public Sub FromMap(m As Map)
	Id = m.GetDefault("id", "")
	GroupId = m.GetDefault("groupId", "")
	Name = m.GetDefault("name", "")
	Url = m.GetDefault("url", "")
	Username = m.GetDefault("username", "")
	PasswordEnc = m.GetDefault("passwordEnc", "")
	Notes = m.GetDefault("notes", "")
	IsFavorite = m.GetDefault("isFavorite", False)
	LastUsed = m.GetDefault("lastUsed", 0)
	CreatedAt = m.GetDefault("createdAt", DateTime.Now)
	UpdatedAt = m.GetDefault("updatedAt", DateTime.Now)
End Sub

'Retorna nome para exibicao (Name ou URL)
Public Sub GetDisplayName As String
	If Name <> "" Then Return Name
	If Url <> "" Then Return Url
	Return "Sem nome"
End Sub

'Marca como usado agora
Public Sub MarkAsUsed
	LastUsed = DateTime.Now
	UpdatedAt = DateTime.Now
End Sub
