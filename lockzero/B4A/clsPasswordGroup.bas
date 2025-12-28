B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
'clsPasswordGroup.bas - Classe Grupo de Senhas
'LockZero - Pasta/categoria para organizar senhas

Sub Class_Globals
	Public Id As String
	Public Name As String              'Ex: "Bancos", "Redes Sociais", "Email"
	Public Icon As String              'Emoji ou icone (Ex: "bank", "social", "email")
	Public Color As Int                'Cor do grupo (opcional)
	Public ProtectionType As String    '"PHRASE" ou "PIN"
	Public Salt As String              'Salt aleatorio (hex, 32 chars)
	Public TestValue As String         '"LOCKZERO" criptografado - para validar frase
	Public CreatedAt As Long
	Public UpdatedAt As Long
End Sub

Public Sub Initialize
	Id = ""
	Name = ""
	Icon = "key"  'Padrao
	Color = 0
	ProtectionType = "PHRASE"  'Padrao: frase
	Salt = ""  'Gerado na criacao
	TestValue = ""  'Gerado na criacao com a frase
	CreatedAt = DateTime.Now
	UpdatedAt = DateTime.Now
End Sub

'Gera salt aleatorio (chamar ao criar grupo)
Public Sub GenerateSalt
	Salt = ModSecurity.GenerateRandomSalt
End Sub

'Cria TestValue criptografando "LOCKZERO" com a frase normalizada
'Chamar ao criar grupo, depois de GenerateSalt
Public Sub CreateTestValue(phrase As String)
	Dim normalizedPhrase As String = ModSecurity.NormalizePassphrase(phrase)
	TestValue = ModSecurity.EncryptWithSalt(normalizedPhrase, Salt, "LOCKZERO")
End Sub

'Valida se a frase esta correta (normaliza antes de validar)
'Retorna True se descriptografar TestValue = "LOCKZERO"
Public Sub ValidatePhrase(phrase As String) As Boolean
	If TestValue = "" Or Salt = "" Then Return False
	Dim normalizedPhrase As String = ModSecurity.NormalizePassphrase(phrase)
	Dim decrypted As String = ModSecurity.DecryptWithSalt(normalizedPhrase, Salt, TestValue)
	Return decrypted = "LOCKZERO"
End Sub

Public Sub IsInitialized As Boolean
	Return Id <> ""
End Sub

'Cria copia do objeto
Public Sub Clone As clsPasswordGroup
	Dim g As clsPasswordGroup
	g.Initialize
	g.Id = Id
	g.Name = Name
	g.Icon = Icon
	g.Color = Color
	g.CreatedAt = CreatedAt
	g.UpdatedAt = UpdatedAt
	Return g
End Sub

'Converte para Map (para JSON)
Public Sub ToMap As Map
	Dim m As Map
	m.Initialize
	m.Put("id", Id)
	m.Put("name", Name)
	m.Put("icon", Icon)
	m.Put("color", Color)
	m.Put("protectionType", ProtectionType)
	m.Put("salt", Salt)
	m.Put("testValue", TestValue)
	m.Put("createdAt", CreatedAt)
	m.Put("updatedAt", UpdatedAt)
	Return m
End Sub

'Carrega de Map (de JSON)
Public Sub FromMap(m As Map)
	Id = m.GetDefault("id", "")
	Name = m.GetDefault("name", "")
	Icon = m.GetDefault("icon", "key")
	Color = m.GetDefault("color", 0)
	ProtectionType = m.GetDefault("protectionType", "PHRASE")
	Salt = m.GetDefault("salt", "")
	TestValue = m.GetDefault("testValue", "")
	CreatedAt = m.GetDefault("createdAt", DateTime.Now)
	UpdatedAt = m.GetDefault("updatedAt", DateTime.Now)
End Sub

'Retorna se usa frase
Public Sub UsesPhrase As Boolean
	Return ProtectionType = "PHRASE"
End Sub

'Retorna se usa PIN
Public Sub UsesPin As Boolean
	Return ProtectionType = "PIN"
End Sub

'Retorna texto do tipo de protecao
Public Sub GetProtectionText As String
	If ProtectionType = "PIN" Then
		Return "PIN"
	Else
		Return "Frase"
	End If
End Sub
