B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=9.85
@EndOfDesignText@
'ModPasswords.bas - Modulo Gerenciador de Senhas
'LockZero - CRUD de grupos e senhas

Sub Process_Globals
	Private Const FILE_NAME As String = "lockzero_passwords.json"
	Private Groups As Map            'Map de clsPasswordGroup por ID
	Private Entries As Map           'Map de clsPasswordEntry por ID
	Private IsLoaded As Boolean = False
End Sub

' ============================================
'  INICIALIZACAO
' ============================================

Public Sub Init
	If IsLoaded Then Return

	Groups.Initialize
	Entries.Initialize
	LoadFromDisk
	IsLoaded = True

	Log("ModPasswords: " & Groups.Size & " grupos, " & Entries.Size & " senhas")
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

		'Carregar grupos
		If root.ContainsKey("groups") Then
			Dim grpList As List = root.Get("groups")
			For Each m As Map In grpList
				Dim g As clsPasswordGroup
				g.Initialize
				g.FromMap(m)
				Groups.Put(g.Id, g)
			Next
		End If

		'Carregar entradas
		If root.ContainsKey("entries") Then
			Dim entList As List = root.Get("entries")
			For Each m As Map In entList
				Dim e As clsPasswordEntry
				e.Initialize
				e.FromMap(m)
				Entries.Put(e.Id, e)
			Next
		End If

	Catch
		Log("ModPasswords.LoadFromDisk erro: " & LastException)
	End Try
End Sub

' ============================================
'  SALVAR NO DISCO
' ============================================

Public Sub SaveToDisk
	'Salvar grupos
	Dim grpList As List
	grpList.Initialize
	For Each k As String In Groups.Keys
		Dim g As clsPasswordGroup = Groups.Get(k)
		grpList.Add(g.ToMap)
	Next

	'Salvar entradas
	Dim entList As List
	entList.Initialize
	For Each k As String In Entries.Keys
		Dim e As clsPasswordEntry = Entries.Get(k)
		entList.Add(e.ToMap)
	Next

	Dim root As Map
	root.Initialize
	root.Put("version", 1)
	root.Put("groups", grpList)
	root.Put("entries", entList)

	Dim gen As JSONGenerator
	gen.Initialize(root)
	File.WriteString(File.DirInternal, FILE_NAME, gen.ToString)

	Log("ModPasswords: salvo " & Groups.Size & " grupos, " & Entries.Size & " senhas")
End Sub

' ============================================
'  CRUD DE GRUPOS
' ============================================

Public Sub GetAllGroups As List
	Init
	Dim lst As List
	lst.Initialize
	For Each k As String In Groups.Keys
		lst.Add(Groups.Get(k))
	Next
	Return lst
End Sub

Public Sub GetGroupById(id As String) As clsPasswordGroup
	Init
	If Groups.ContainsKey(id) Then
		Return Groups.Get(id)
	End If
	Dim empty As clsPasswordGroup
	Return empty
End Sub

Public Sub SaveGroup(g As clsPasswordGroup)
	Init
	If g.Id = "" Then
		g.Id = ModSecurity.GenerateUUID
		g.CreatedAt = DateTime.Now
	End If
	g.UpdatedAt = DateTime.Now
	Groups.Put(g.Id, g)
	SaveToDisk
End Sub

Public Sub DeleteGroup(id As String)
	Init
	If Groups.ContainsKey(id) Then
		Groups.Remove(id)

		'Remove todas as senhas do grupo
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
	Init
	Return Groups.Size
End Sub

' ============================================
'  CRUD DE ENTRADAS (SENHAS)
' ============================================

Public Sub GetEntriesByGroup(groupId As String) As List
	Init
	Dim lst As List
	lst.Initialize
	For Each k As String In Entries.Keys
		Dim e As clsPasswordEntry = Entries.Get(k)
		If e.GroupId = groupId Then
			lst.Add(e)
		End If
	Next
	Return lst
End Sub

Public Sub GetAllEntries As List
	Init
	Dim lst As List
	lst.Initialize
	For Each k As String In Entries.Keys
		lst.Add(Entries.Get(k))
	Next
	Return lst
End Sub

Public Sub GetEntryById(id As String) As clsPasswordEntry
	Init
	If Entries.ContainsKey(id) Then
		Return Entries.Get(id)
	End If
	Dim empty As clsPasswordEntry
	Return empty
End Sub

Public Sub SaveEntry(e As clsPasswordEntry)
	Init
	If e.Id = "" Then
		e.Id = ModSecurity.GenerateUUID
		e.CreatedAt = DateTime.Now
	End If
	e.UpdatedAt = DateTime.Now
	Entries.Put(e.Id, e)
	SaveToDisk
End Sub

Public Sub DeleteEntry(id As String)
	Init
	If Entries.ContainsKey(id) Then
		Entries.Remove(id)
		SaveToDisk
	End If
End Sub

Public Sub GetEntryCountByGroup(groupId As String) As Int
	Init
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
	Init
	Return Entries.Size
End Sub

' ============================================
'  FAVORITOS
' ============================================

Public Sub GetFavorites As List
	Init
	Dim lst As List
	lst.Initialize
	For Each k As String In Entries.Keys
		Dim e As clsPasswordEntry = Entries.Get(k)
		If e.IsFavorite Then
			lst.Add(e)
		End If
	Next
	Return lst
End Sub

Public Sub ToggleFavorite(id As String)
	Init
	If Entries.ContainsKey(id) Then
		Dim e As clsPasswordEntry = Entries.Get(id)
		e.IsFavorite = Not(e.IsFavorite)
		e.UpdatedAt = DateTime.Now
		SaveToDisk
	End If
End Sub

' ============================================
'  BUSCA
' ============================================

Public Sub Search(query As String) As List
	Init
	Dim lst As List
	lst.Initialize
	Dim q As String = query.ToLowerCase.Trim

	If q.Length < 1 Then Return lst

	For Each k As String In Entries.Keys
		Dim e As clsPasswordEntry = Entries.Get(k)
		If e.Name.ToLowerCase.Contains(q) Or e.Url.ToLowerCase.Contains(q) Then
			lst.Add(e)
		End If
	Next
	Return lst
End Sub

' ============================================
'  CRIPTOGRAFIA (USA SESSAO ATIVA)
' ============================================

'Criptografa valor usando sessao ativa
Public Sub EncryptValue(plainText As String) As String
	Return ModSession.Encrypt(plainText)
End Sub

'Descriptografa valor usando sessao ativa
Public Sub DecryptValue(encText As String) As String
	Return ModSession.Decrypt(encText)
End Sub

' ============================================
'  ESTATISTICAS
' ============================================

Public Sub GetStats As Map
	Init
	Dim stats As Map
	stats.Initialize
	stats.Put("groups", Groups.Size)
	stats.Put("entries", Entries.Size)
	stats.Put("favorites", GetFavorites.Size)
	Return stats
End Sub
