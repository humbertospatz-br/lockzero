B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
'clsNoteGroup.bas - Classe Grupo de Notas
'LockZero - Pasta/categoria para organizar notas
'Grupos podem ser SEGUROS (criptografados) ou ABERTOS (sem criptografia)

Sub Class_Globals
	Public Id As String
	Public Name As String              'Ex: "Compras", "Ideias", "Trabalho"
	Public Icon As String              'Emoji escolhido pelo usuario
	Public IsSecure As Boolean         'True = seguro com cadeado, False = aberto
	Public Salt As String              'Salt aleatorio (hex, 32 chars) - apenas grupos seguros
	Public TestValue As String         '"LOCKZERO" criptografado - apenas grupos seguros
	Public CreatedAt As Long
	Public UpdatedAt As Long
End Sub

Public Sub Initialize
	Id = ""
	Name = ""
	Icon = Chr(0xD83D) & Chr(0xDCDD)  'Padrao: emoji de nota 📝 (surrogate pair)
	IsSecure = True  'Default: grupo seguro
	Salt = ""
	TestValue = ""
	CreatedAt = DateTime.Now
	UpdatedAt = DateTime.Now
End Sub

'Gera salt aleatorio (chamar ao criar grupo SEGURO)
Public Sub GenerateSalt
	If IsSecure Then
		Salt = ModSecurity.GenerateRandomSalt
	End If
End Sub

'Cria TestValue criptografando "LOCKZERO" com a frase normalizada
'Chamar ao criar grupo SEGURO, depois de GenerateSalt
Public Sub CreateTestValue(phrase As String)
	If IsSecure = False Then Return
	Dim normalizedPhrase As String = ModSecurity.NormalizePassphrase(phrase)
	TestValue = ModSecurity.EncryptWithSalt(normalizedPhrase, Salt, "LOCKZERO")
End Sub

'Configura seguranca do grupo (Salt + TestValue)
'Chamar ao criar grupo seguro
Public Sub SetupSecurity(phrase As String)
	If IsSecure = False Then
		Salt = ""
		TestValue = ""
		Return
	End If
	GenerateSalt
	CreateTestValue(phrase)
End Sub

'Valida se a frase esta correta (normaliza antes de validar)
'Retorna True se descriptografar TestValue = "LOCKZERO"
'Para grupos ABERTOS, sempre retorna True
Public Sub ValidatePhrase(phrase As String) As Boolean
	If IsSecure = False Then Return True  'Grupos abertos nao precisam validar
	If TestValue = "" Or Salt = "" Then Return False
	Dim normalizedPhrase As String = ModSecurity.NormalizePassphrase(phrase)
	Dim decrypted As String = ModSecurity.DecryptWithSalt(normalizedPhrase, Salt, TestValue)
	Return decrypted = "LOCKZERO"
End Sub

'Retorna se grupo requer autenticacao
Public Sub RequiresAuth As Boolean
	Return IsSecure
End Sub

Public Sub IsInitialized As Boolean
	Return Id <> ""
End Sub

'Cria copia do objeto
Public Sub Clone As clsNoteGroup
	Dim g As clsNoteGroup
	g.Initialize
	g.Id = Id
	g.Name = Name
	g.Icon = Icon
	g.IsSecure = IsSecure
	g.Salt = Salt
	g.TestValue = TestValue
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
	m.Put("isSecure", IsSecure)
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
	Icon = m.GetDefault("icon", Chr(0xD83D) & Chr(0xDCDD))
	'Converte valores antigos de texto para emoji
	If Icon = "note" Or Icon = "" Then Icon = Chr(0xD83D) & Chr(0xDCDD)  '📝 (surrogate pair)
	IsSecure = m.GetDefault("isSecure", True)
	Salt = m.GetDefault("salt", "")
	TestValue = m.GetDefault("testValue", "")
	CreatedAt = m.GetDefault("createdAt", DateTime.Now)
	UpdatedAt = m.GetDefault("updatedAt", DateTime.Now)
End Sub

'Retorna icone de cadeado se grupo seguro
Public Sub GetLockIcon As String
	If IsSecure Then
		Return Chr(0xD83D) & Chr(0xDD12)  'Cadeado fechado 🔒 (surrogate pair)
	Else
		Return ""  'Sem cadeado
	End If
End Sub

'Retorna texto do tipo de protecao
Public Sub GetProtectionText As String
	If IsSecure Then
		Return ModLang.T("note_group_secure")
	Else
		Return ModLang.T("note_group_open")
	End If
End Sub
