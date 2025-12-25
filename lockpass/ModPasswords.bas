B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=13.4
@EndOfDesignText@
'ModPasswords.bas - Modulo Gerenciador de Senhas
'LockSeed - CRUD de grupos e senhas (separado de wallets)

Sub Process_Globals
	Private Const FILE_NAME As String = "LockSeedPasswords.json"
	Private Groups As Map            ' Map de clsPasswordGroup por ID
	Private Entries As Map           ' Map de clsPasswordEntry por ID

	' Sessao de frase-senha (tempo configuravel)
	Private SessionPassphrase As String
	Private SessionExpireTime As Long
	Private SessionDurationMinutes As Int = 2  ' Padrao: 2 minutos (1-5 config)

	' Flag para evitar re-inicializacao
	Private IsInitialized As Boolean = False
End Sub

Public Sub Init
	' Evita resetar sessao se ja inicializado
	If IsInitialized Then Return

	Groups.Initialize
	Entries.Initialize
	SessionPassphrase = ""
	SessionExpireTime = 0
	LoadSessionConfig
	LoadFromDisk

	IsInitialized = True
End Sub

' Carrega configuracao de tempo da sessao
Private Sub LoadSessionConfig
	SessionDurationMinutes = ModSecurity.GetPasswordSessionMinutes
	If SessionDurationMinutes < 1 Then SessionDurationMinutes = 1
	If SessionDurationMinutes > 5 Then SessionDurationMinutes = 5
End Sub

' ============================================
'  SESSAO DE FRASE-SENHA (CONFIGURAVEL)
' ============================================

' Define frase-senha da sessao (inicia timer)
Public Sub SetSessionPassphrase(passphrase As String)
	SessionPassphrase = passphrase
	Dim durationMs As Long = SessionDurationMinutes * 60 * 1000
	SessionExpireTime = DateTime.Now + durationMs
End Sub

' Atualiza duracao da sessao (1-5 minutos)
Public Sub SetSessionDuration(minutes As Int)
	If minutes < 1 Then minutes = 1
	If minutes > 5 Then minutes = 5
	SessionDurationMinutes = minutes
	ModSecurity.SavePasswordSessionMinutes(minutes)
End Sub

' Retorna duracao configurada
Public Sub GetSessionDuration As Int
	Return SessionDurationMinutes
End Sub

' Verifica se sessao ainda esta valida
Public Sub IsSessionValid As Boolean
	If SessionPassphrase = "" Then Return False
	If DateTime.Now > SessionExpireTime Then
		ClearSession
		Return False
	End If
	Return True
End Sub

' Retorna frase da sessao (se valida)
Public Sub GetSessionPassphrase As String
	If IsSessionValid Then
		Return SessionPassphrase
	End If
	Return ""
End Sub

' Limpa sessao
Public Sub ClearSession
	SessionPassphrase = ""
	SessionExpireTime = 0
End Sub

' Tempo restante da sessao em segundos
Public Sub GetSessionRemainingSeconds As Int
	If IsSessionValid = False Then Return 0
	Return (SessionExpireTime - DateTime.Now) / 1000
End Sub

' ============================================
'  CARREGAR DO DISCO
' ============================================
Private Sub LoadFromDisk
	If File.Exists(File.DirInternal, FILE_NAME) = False Then
		Log("ModPasswords: arquivo nao existe, iniciando vazio")
		Return
	End If

	Try
		Dim json As String = File.ReadString(File.DirInternal, FILE_NAME)
		If json.Length = 0 Then Return

		Dim parser As JSONParser
		parser.Initialize(json)
		Dim root As Map = parser.NextObject

		' Carregar grupos
		If root.ContainsKey("groups") Then
			Dim grpList As List = root.Get("groups")
			For Each m As Map In grpList
				Dim g As clsPasswordGroup
				g.Initialize
				g.Id = m.Get("id")
				g.Name = m.Get("name")
				g.UseGlobalPassphrase = m.GetDefault("useGlobalPassphrase", True)
				g.CreatedAt = m.GetDefault("createdAt", DateTime.Now)
				g.UpdatedAt = m.GetDefault("updatedAt", DateTime.Now)
				Groups.Put(g.Id, g)
			Next
		End If

		' Carregar entradas
		If root.ContainsKey("entries") Then
			Dim entList As List = root.Get("entries")
			For Each m As Map In entList
				Dim e As clsPasswordEntry
				e.Initialize
				e.Id = m.Get("id")
				e.GroupId = m.Get("groupId")
				e.Site = m.Get("site")
				e.Username = m.GetDefault("username", "")
				e.PasswordEnc = m.GetDefault("passwordEnc", "")
				e.Notes = m.GetDefault("notes", "")
				e.CreatedAt = m.GetDefault("createdAt", DateTime.Now)
				e.UpdatedAt = m.GetDefault("updatedAt", DateTime.Now)
				Entries.Put(e.Id, e)
			Next
		End If

		Log("ModPasswords: " & Groups.Size & " grupos, " & Entries.Size & " senhas carregadas")
	Catch
		Log("ModPasswords: erro ao carregar - " & LastException)
	End Try
End Sub

' ============================================
'  SALVAR NO DISCO
' ============================================
Public Sub SaveToDisk
	' Salvar grupos
	Dim grpList As List
	grpList.Initialize
	For Each k As String In Groups.Keys
		Dim g As clsPasswordGroup = Groups.Get(k)
		Dim m As Map
		m.Initialize
		m.Put("id", g.Id)
		m.Put("name", g.Name)
		m.Put("useGlobalPassphrase", g.UseGlobalPassphrase)
		m.Put("createdAt", g.CreatedAt)
		m.Put("updatedAt", g.UpdatedAt)
		grpList.Add(m)
	Next

	' Salvar entradas
	Dim entList As List
	entList.Initialize
	For Each k As String In Entries.Keys
		Dim e As clsPasswordEntry = Entries.Get(k)
		Dim m As Map
		m.Initialize
		m.Put("id", e.Id)
		m.Put("groupId", e.GroupId)
		m.Put("site", e.Site)
		m.Put("username", e.Username)
		m.Put("passwordEnc", e.PasswordEnc)
		m.Put("notes", e.Notes)
		m.Put("createdAt", e.CreatedAt)
		m.Put("updatedAt", e.UpdatedAt)
		entList.Add(m)
	Next

	Dim root As Map
	root.Initialize
	root.Put("version", 1)
	root.Put("groups", grpList)
	root.Put("entries", entList)

	Dim gen As JSONGenerator
	gen.Initialize(root)
	File.WriteString(File.DirInternal, FILE_NAME, gen.ToString)

	Log("ModPasswords: salvo com " & Groups.Size & " grupos, " & Entries.Size & " senhas")
End Sub

' ============================================
'  CRUD DE GRUPOS
' ============================================

Public Sub GetAllGroups As List
	Dim lst As List
	lst.Initialize
	If Groups.IsInitialized = False Then Return lst
	For Each k As String In Groups.Keys
		lst.Add(Groups.Get(k))
	Next
	Return lst
End Sub

Public Sub GetGroupById(id As String) As clsPasswordGroup
	If Groups.IsInitialized And Groups.ContainsKey(id) Then
		Return Groups.Get(id)
	End If
	Dim empty As clsPasswordGroup
	Return empty
End Sub

Public Sub SaveGroup(g As clsPasswordGroup)
	If g.Id = "" Then
		g.Id = CreateUUID
		g.CreatedAt = DateTime.Now
	End If
	g.UpdatedAt = DateTime.Now
	Groups.Put(g.Id, g)
	SaveToDisk
End Sub

Public Sub DeleteGroup(id As String)
	If Groups.ContainsKey(id) Then
		Groups.Remove(id)
		' Remove todas as senhas do grupo
		Dim toRemove As List
		toRemove.Initialize
		For Each k As String In Entries.Keys
			Dim e As clsPasswordEntry = Entries.Get(k)
			If e.GroupId = id Then
				toRemove.Add(k)
			End If
		Next
		For Each k As String In toRemove
			Entries.Remove(k)
		Next
		SaveToDisk
	End If
End Sub

Public Sub GetGroupCount As Int
	If Groups.IsInitialized = False Then Return 0
	Return Groups.Size
End Sub

' ============================================
'  CRUD DE ENTRADAS (SENHAS)
' ============================================

Public Sub GetEntriesByGroup(groupId As String) As List
	Dim lst As List
	lst.Initialize
	If Entries.IsInitialized = False Then Return lst
	For Each k As String In Entries.Keys
		Dim e As clsPasswordEntry = Entries.Get(k)
		If e.GroupId = groupId Then
			lst.Add(e)
		End If
	Next
	Return lst
End Sub

Public Sub GetEntryById(id As String) As clsPasswordEntry
	If Entries.IsInitialized And Entries.ContainsKey(id) Then
		Return Entries.Get(id)
	End If
	Dim empty As clsPasswordEntry
	Return empty
End Sub

Public Sub SaveEntry(e As clsPasswordEntry)
	If e.Id = "" Then
		e.Id = CreateUUID
		e.CreatedAt = DateTime.Now
	End If
	e.UpdatedAt = DateTime.Now
	Entries.Put(e.Id, e)
	SaveToDisk
End Sub

Public Sub DeleteEntry(id As String)
	If Entries.ContainsKey(id) Then
		Entries.Remove(id)
		SaveToDisk
	End If
End Sub

Public Sub GetEntryCountByGroup(groupId As String) As Int
	Dim count As Int = 0
	For Each k As String In Entries.Keys
		Dim e As clsPasswordEntry = Entries.Get(k)
		If e.GroupId = groupId Then
			count = count + 1
		End If
	Next
	Return count
End Sub

Public Sub GetTotalEntryCount As Int
	If Entries.IsInitialized = False Then Return 0
	Return Entries.Size
End Sub

' Verifica se pode criar nova senha (respeitando limite da versao)
Public Sub CanCreateEntry As Boolean
	Return ModSecurity.CanCreatePassword(GetTotalEntryCount)
End Sub

' ============================================
'  CRIPTOGRAFIA (USA ModSecurity)
' ============================================

' Criptografa senha com frase-senha
Public Sub EncryptPassword(passphrase As String, plainPassword As String) As String
	Return ModSecurity.EncryptPassword(passphrase, plainPassword)
End Sub

' Descriptografa senha com frase-senha
Public Sub DecryptPassword(passphrase As String, encryptedPassword As String) As String
	Return ModSecurity.DecryptPassword(passphrase, encryptedPassword)
End Sub

' ============================================
'  UTILITARIO - GERAR UUID
' ============================================
Private Sub CreateUUID As String
	Dim r As Reflector
	r.Target = r.RunStaticMethod("java.util.UUID", "randomUUID", Null, Null)
	Return r.RunMethod("toString")
End Sub

