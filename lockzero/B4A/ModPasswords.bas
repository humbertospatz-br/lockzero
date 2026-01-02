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
	ForceReload
End Sub

Public Sub ForceReload
	Groups.Initialize
	Entries.Initialize
	LoadFromDisk
	IsLoaded = True

	Log("ModPasswords: " & Groups.Size & " grupos, " & Entries.Size & " senhas")
End Sub

' ============================================
'  CARREGAR DO DISCO (COM FALLBACK)
' ============================================

Private Sub LoadFromDisk
	'Tenta carregar com fallback para .bak se corrompido
	Dim json As String = LoadFileWithFallback(File.DirInternal, FILE_NAME)

	If json.Length = 0 Then
		Log("ModPasswords: nenhum arquivo disponivel, iniciando vazio")
		Return
	End If

	Try
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
		Log("ModPasswords.LoadFromDisk erro ao parsear: " & LastException)
	End Try
End Sub

'Carrega arquivo com fallback para .bak se principal corrompido
Private Sub LoadFileWithFallback(folder As String, fileName As String) As String
	Dim backupFile As String = fileName & ".bak"

	'1. Tenta carregar arquivo principal
	If File.Exists(folder, fileName) Then
		Try
			Dim content As String = File.ReadString(folder, fileName)
			'Valida JSON basico (deve comecar com { ou [)
			If content.Length > 0 And (content.StartsWith("{") Or content.StartsWith("[")) Then
				Log("LoadFileWithFallback: arquivo principal OK")
				Return content
			Else
				Log("LoadFileWithFallback: arquivo principal invalido")
			End If
		Catch
			Log("LoadFileWithFallback: erro ao ler principal - " & LastException.Message)
		End Try
	End If

	'2. Fallback para backup
	If File.Exists(folder, backupFile) Then
		Try
			Dim backup As String = File.ReadString(folder, backupFile)
			If backup.Length > 0 And (backup.StartsWith("{") Or backup.StartsWith("[")) Then
				Log("LoadFileWithFallback: USANDO BACKUP! Arquivo principal estava corrompido.")
				'Restaura backup como principal
				File.Copy(folder, backupFile, folder, fileName)
				Return backup
			End If
		Catch
			Log("LoadFileWithFallback: backup tambem corrompido!")
		End Try
	End If

	'3. Nenhum arquivo disponivel
	Log("LoadFileWithFallback: nenhum arquivo valido encontrado")
	Return ""
End Sub

' ============================================
'  SALVAR NO DISCO (ATOMICO)
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

	'SAVE ATOMICO - evita corrupcao se app crashar
	If SaveFileAtomic(File.DirInternal, FILE_NAME, gen.ToString) Then
		Log("ModPasswords: salvo " & Groups.Size & " grupos, " & Entries.Size & " senhas")
	Else
		Log("ModPasswords: ERRO ao salvar!")
	End If
End Sub

' ============================================
'  SAVE ATOMICO - Evita corrupcao de arquivo
' ============================================

'Salva conteudo em arquivo de forma atomica (segura)
'Retorna True se sucesso, False se falha
Private Sub SaveFileAtomic(folder As String, fileName As String, content As String) As Boolean
	Dim tempFile As String = fileName & ".tmp"
	Dim backupFile As String = fileName & ".bak"

	Try
		'1. Escreve no arquivo temporario
		File.WriteString(folder, tempFile, content)

		'2. Verifica se escreveu corretamente
		Dim verify As String = File.ReadString(folder, tempFile)
		If verify <> content Then
			Log("SaveFileAtomic: verificacao falhou")
			File.Delete(folder, tempFile)
			Return False
		End If

		'3. Se arquivo original existe, faz backup
		If File.Exists(folder, fileName) Then
			'Remove backup antigo se existir
			If File.Exists(folder, backupFile) Then
				File.Delete(folder, backupFile)
			End If
			'Copia original para .bak
			File.Copy(folder, fileName, folder, backupFile)
		End If

		'4. Substitui original pelo temporario (ATOMICO!)
		File.Delete(folder, fileName)
		File.Copy(folder, tempFile, folder, fileName)
		File.Delete(folder, tempFile)

		Return True

	Catch
		Log("SaveFileAtomic ERRO: " & LastException.Message)
		'Em caso de erro, tenta limpar temp
		If File.Exists(folder, tempFile) Then
			File.Delete(folder, tempFile)
		End If
		Return False
	End Try
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

'Busca global com suporte a campos criptografados
'query: texto a buscar
'passphrase: frase-senha para descriptografar (opcional, "" = so campos publicos)
'Retorna lista de clsPasswordEntry
Public Sub SearchAll(query As String, passphrase As String) As List
	Init
	Dim lst As List
	lst.Initialize
	Dim q As String = query.ToLowerCase.Trim

	If q.Length < 2 Then Return lst

	'Prepara frase normalizada se fornecida
	Dim normalizedPhrase As String = ""
	If passphrase.Length > 0 Then
		normalizedPhrase = ModSecurity.NormalizePassphrase(passphrase)
	End If

	For Each k As String In Entries.Keys
		Dim e As clsPasswordEntry = Entries.Get(k)
		Dim found As Boolean = False

		'Busca em campos publicos (sempre)
		If e.Name.ToLowerCase.Contains(q) Or e.Url.ToLowerCase.Contains(q) Then
			found = True
		End If

		'Busca em Username (se frase fornecida)
		If found = False And normalizedPhrase.Length >= 10 Then
			Try
				'Obtem salt do grupo
				Dim group As clsPasswordGroup = GetGroupById(e.GroupId)
				If group.IsInitialized And group.Salt.Length > 0 Then
					Dim decUsername As String = ModSecurity.DecryptWithSalt(passphrase, group.Salt, e.Username)
					If decUsername.ToLowerCase.Contains(q) Then
						found = True
					End If
				End If
			Catch
				'Ignora erro de descriptografia (frase errada para este grupo)
				Log("SearchAllGroups decrypt error: " & LastException.Message)
			End Try
		End If

		If found Then lst.Add(e)
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
