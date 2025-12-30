B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=9.85
@EndOfDesignText@
'ModNotes.bas - CRUD de Notas Seguras
'LockZero - Lock and ZERO worries

Sub Process_Globals
	Private Const NOTES_FILE As String = "lockzero_notes.json"
	Private Const DATA_VERSION As Int = 2  'Versao 2 = com grupos de notas
	Private NoteGroups As List  'Lista de clsNoteGroup
	Private Notes As List       'Lista de clsNoteEntry
	Private mInitialized As Boolean = False
End Sub

' ============================================
'  INICIALIZACAO
' ============================================

Public Sub Init
	If mInitialized Then Return
	ForceReload
End Sub

Public Sub ForceReload
	NoteGroups.Initialize
	Notes.Initialize
	LoadData
	mInitialized = True
End Sub

Private Sub EnsureInit
	If mInitialized = False Then Init
End Sub

' ============================================
'  CRUD - GRUPOS DE NOTAS
' ============================================

'Retorna todos os grupos de notas
Public Sub GetAllNoteGroups As List
	EnsureInit
	Return NoteGroups
End Sub

'Busca grupo por ID
Public Sub GetNoteGroupById(groupId As String) As clsNoteGroup
	EnsureInit

	For i = 0 To NoteGroups.Size - 1
		Dim grp As clsNoteGroup = NoteGroups.Get(i)
		If grp.Id = groupId Then
			Return grp
		End If
	Next

	Return Null
End Sub

'Salva grupo (novo ou atualiza)
Public Sub SaveNoteGroup(grp As clsNoteGroup)
	EnsureInit

	'Gera ID se novo
	If grp.Id.Length = 0 Then
		grp.Id = ModSecurity.GenerateUUID
		grp.CreatedAt = DateTime.Now
	End If
	grp.UpdatedAt = DateTime.Now

	'Verifica se ja existe
	Dim found As Boolean = False
	For i = 0 To NoteGroups.Size - 1
		Dim existing As clsNoteGroup = NoteGroups.Get(i)
		If existing.Id = grp.Id Then
			NoteGroups.Set(i, grp)
			found = True
			Exit
		End If
	Next

	If Not(found) Then
		NoteGroups.Add(grp)
	End If

	SaveData
End Sub

'Exclui grupo e suas notas
Public Sub DeleteNoteGroup(groupId As String)
	EnsureInit

	'Remove grupo
	For i = NoteGroups.Size - 1 To 0 Step -1
		Dim grp As clsNoteGroup = NoteGroups.Get(i)
		If grp.Id = groupId Then
			NoteGroups.RemoveAt(i)
			Exit
		End If
	Next

	'Remove notas do grupo
	For i = Notes.Size - 1 To 0 Step -1
		Dim note As clsNoteEntry = Notes.Get(i)
		If note.GroupId = groupId Then
			Notes.RemoveAt(i)
		End If
	Next

	SaveData
End Sub

'Conta grupos de notas
Public Sub CountNoteGroups As Int
	EnsureInit
	Return NoteGroups.Size
End Sub

' ============================================
'  CRUD - NOTAS
' ============================================

'Retorna todas as notas de um grupo (ordenadas por SortOrder)
Public Sub GetNotesByGroup(groupId As String) As List
	EnsureInit
	Dim result As List
	result.Initialize

	For i = 0 To Notes.Size - 1
		Dim note As clsNoteEntry = Notes.Get(i)
		If note.GroupId = groupId Then
			result.Add(note)
		End If
	Next

	'Ordena por SortOrder (bubble sort simples)
	SortNotesBySortOrder(result)

	Return result
End Sub

'Ordena lista de notas por SortOrder (bubble sort)
Private Sub SortNotesBySortOrder(noteList As List)
	If noteList.Size < 2 Then Return

	For i = 0 To noteList.Size - 2
		For j = 0 To noteList.Size - 2 - i
			Dim n1 As clsNoteEntry = noteList.Get(j)
			Dim n2 As clsNoteEntry = noteList.Get(j + 1)
			If n1.SortOrder > n2.SortOrder Then
				noteList.Set(j, n2)
				noteList.Set(j + 1, n1)
			End If
		Next
	Next
End Sub

'Atualiza SortOrder de uma nota e salva
Public Sub UpdateNoteSortOrder(noteId As String, newOrder As Int)
	EnsureInit

	For i = 0 To Notes.Size - 1
		Dim note As clsNoteEntry = Notes.Get(i)
		If note.Id = noteId Then
			note.SortOrder = newOrder
			note.UpdatedAt = DateTime.Now
			Notes.Set(i, note)
			Exit
		End If
	Next

	SaveData
End Sub

'Reordena notas de um grupo (recebe lista de IDs na nova ordem)
Public Sub ReorderNotes(groupId As String, orderedIds As List)
	EnsureInit

	For i = 0 To orderedIds.Size - 1
		Dim noteId As String = orderedIds.Get(i)
		For j = 0 To Notes.Size - 1
			Dim note As clsNoteEntry = Notes.Get(j)
			If note.Id = noteId And note.GroupId = groupId Then
				note.SortOrder = i
				note.UpdatedAt = DateTime.Now
				Notes.Set(j, note)
				Exit
			End If
		Next
	Next

	SaveData
End Sub

'Retorna todas as notas (para busca global)
Public Sub GetAllNotes As List
	EnsureInit
	Return Notes
End Sub

'Retorna notas favoritas
Public Sub GetFavorites As List
	EnsureInit
	Dim result As List
	result.Initialize

	For i = 0 To Notes.Size - 1
		Dim note As clsNoteEntry = Notes.Get(i)
		If note.IsFavorite Then
			result.Add(note)
		End If
	Next

	Return result
End Sub

'Busca notas pelo titulo (descriptografado)
Public Sub SearchNotes(query As String, passPhrase As String) As List
	EnsureInit
	Dim result As List
	result.Initialize
	Dim queryLower As String = query.ToLowerCase

	For i = 0 To Notes.Size - 1
		Dim note As clsNoteEntry = Notes.Get(i)
		Dim title As String = note.GetDecryptedTitle(passPhrase).ToLowerCase
		Dim content As String = note.GetDecryptedContent(passPhrase).ToLowerCase

		If title.Contains(queryLower) Or content.Contains(queryLower) Then
			result.Add(note)
		End If
	Next

	Return result
End Sub

'Busca nota por ID
Public Sub GetNoteById(noteId As String) As clsNoteEntry
	EnsureInit

	For i = 0 To Notes.Size - 1
		Dim note As clsNoteEntry = Notes.Get(i)
		If note.Id = noteId Then
			Return note
		End If
	Next

	Return Null
End Sub

'Salva nota (nova ou atualiza)
Public Sub SaveNote(note As clsNoteEntry)
	EnsureInit

	'Gera ID se novo
	If note.Id.Length = 0 Then
		note.Id = ModSecurity.GenerateUUID
		note.CreatedAt = DateTime.Now
	End If
	note.UpdatedAt = DateTime.Now

	'Verifica se ja existe
	Dim found As Boolean = False
	For i = 0 To Notes.Size - 1
		Dim existing As clsNoteEntry = Notes.Get(i)
		If existing.Id = note.Id Then
			Notes.Set(i, note)
			found = True
			Exit
		End If
	Next

	If Not(found) Then
		Notes.Add(note)
	End If

	SaveData
End Sub

'Exclui nota
Public Sub DeleteNote(noteId As String)
	EnsureInit

	For i = Notes.Size - 1 To 0 Step -1
		Dim note As clsNoteEntry = Notes.Get(i)
		If note.Id = noteId Then
			Notes.RemoveAt(i)
			Exit
		End If
	Next

	SaveData
End Sub

'Alterna favorito
Public Sub ToggleFavorite(noteId As String)
	EnsureInit

	For i = 0 To Notes.Size - 1
		Dim note As clsNoteEntry = Notes.Get(i)
		If note.Id = noteId Then
			note.IsFavorite = Not(note.IsFavorite)
			note.UpdatedAt = DateTime.Now
			Notes.Set(i, note)
			Exit
		End If
	Next

	SaveData
End Sub

'Conta notas por grupo
Public Sub CountByGroup(groupId As String) As Int
	EnsureInit
	Dim count As Int = 0

	For i = 0 To Notes.Size - 1
		Dim note As clsNoteEntry = Notes.Get(i)
		If note.GroupId = groupId Then
			count = count + 1
		End If
	Next

	Return count
End Sub

' ============================================
'  PERSISTENCIA
' ============================================

Private Sub LoadData
	NoteGroups.Initialize
	Notes.Initialize

	Log("ModNotes.LoadData: Verificando arquivo " & NOTES_FILE)
	Log("ModNotes.LoadData: DirInternal = " & File.DirInternal)

	If File.Exists(File.DirInternal, NOTES_FILE) = False Then
		Log("ModNotes.LoadData: Arquivo NAO existe")
		Return
	End If

	Dim fileSize As Long = File.Size(File.DirInternal, NOTES_FILE)
	Log("ModNotes.LoadData: Arquivo existe, tamanho = " & fileSize & " bytes")

	Try
		Dim json As String = File.ReadString(File.DirInternal, NOTES_FILE)
		Log("ModNotes.LoadData: Conteudo JSON (primeiros 200 chars):")
		If json.Length > 200 Then
			Log(json.SubString2(0, 200))
		Else
			Log(json)
		End If
		Dim parser As JSONParser
		parser.Initialize(json)

		'Tenta ler como novo formato (versao 2 - com grupos)
		'Primeiro caractere determina se e objeto ou array
		Dim firstChar As String = json.Trim.SubString2(0, 1)
		If firstChar = "{" Then
			'E um objeto (Map)
			Dim rootMap As Map = parser.NextObject
			'Novo formato: { version, groups, notes }
			If rootMap.ContainsKey("groups") Then
				Dim groupsList As List = rootMap.Get("groups")
				For i = 0 To groupsList.Size - 1
					Dim m As Map = groupsList.Get(i)
					Dim grp As clsNoteGroup
					grp.Initialize
					grp.FromMap(m)
					NoteGroups.Add(grp)
				Next
			End If

			If rootMap.ContainsKey("notes") Then
				Dim notesList As List = rootMap.Get("notes")
				For i = 0 To notesList.Size - 1
					Dim m As Map = notesList.Get(i)
					Dim note As clsNoteEntry
					note.Initialize
					note.FromMap(m)
					Notes.Add(note)
				Next
			End If
			Log("ModNotes.LoadData: Carregado " & NoteGroups.Size & " grupos, " & Notes.Size & " notas")
		Else If firstChar = "[" Then
			'Formato antigo (versao 1 - apenas array de notas)
			'Migrar: criar grupo padrao e associar notas
			Dim oldNotes As List = parser.NextArray
			If oldNotes.Size > 0 Then
				MigrateFromVersion1(oldNotes)
			End If
		End If
	Catch
		Log("ModNotes.LoadData erro: " & LastException)
		'Arquivo corrompido - apaga e recria vazio
		Log("Apagando arquivo corrompido...")
		Try
			File.Delete(File.DirInternal, NOTES_FILE)
		Catch
			Log("Erro ao apagar arquivo: " & LastException)
		End Try
		NoteGroups.Initialize
		Notes.Initialize
	End Try
End Sub

'Migra dados do formato antigo (versao 1) para o novo formato
Private Sub MigrateFromVersion1(oldNotes As List)
	Log("Migrando notas do formato v1 para v2...")

	'Agrupa notas por GroupId antigo (que era ID de PasswordGroup)
	Dim groupIds As Map
	groupIds.Initialize

	For i = 0 To oldNotes.Size - 1
		Dim m As Map = oldNotes.Get(i)
		Dim note As clsNoteEntry
		note.Initialize
		note.FromMap(m)

		Dim oldGroupId As String = note.GroupId
		If oldGroupId <> "" Then
			If groupIds.ContainsKey(oldGroupId) = False Then
				groupIds.Put(oldGroupId, oldGroupId)
			End If
		End If

		Notes.Add(note)
	Next

	'Cria grupos para cada GroupId encontrado
	For Each oldGroupId As String In groupIds.Keys
		Dim grp As clsNoteGroup
		grp.Initialize
		grp.Id = oldGroupId  'Mantém o mesmo ID para associação
		grp.Name = "Migrado"
		grp.Icon = "note"
		grp.IsSecure = True  'Assume seguro por compatibilidade
		'Não define Salt/TestValue - usuario precisara reconfigurar
		NoteGroups.Add(grp)
	Next

	'Salva no novo formato
	SaveData
	Log("Migracao concluida: " & Notes.Size & " notas, " & NoteGroups.Size & " grupos")
End Sub

Private Sub SaveData
	Try
		'Converte grupos para lista de Maps
		Dim groupsList As List
		groupsList.Initialize
		For i = 0 To NoteGroups.Size - 1
			Dim grp As clsNoteGroup = NoteGroups.Get(i)
			groupsList.Add(grp.ToMap)
		Next

		'Converte notas para lista de Maps
		Dim notesList As List
		notesList.Initialize
		For i = 0 To Notes.Size - 1
			Dim note As clsNoteEntry = Notes.Get(i)
			notesList.Add(note.ToMap)
		Next

		'Cria estrutura raiz
		Dim root As Map
		root.Initialize
		root.Put("version", DATA_VERSION)
		root.Put("groups", groupsList)
		root.Put("notes", notesList)

		Dim gen As JSONGenerator
		gen.Initialize(root)
		Dim jsonData As String = gen.ToPrettyString(2)
		File.WriteString(File.DirInternal, NOTES_FILE, jsonData)
		Log("ModNotes.SaveData: Salvo " & NoteGroups.Size & " grupos, " & Notes.Size & " notas (" & jsonData.Length & " bytes)")
	Catch
		Log("ModNotes.SaveData ERRO: " & LastException)
	End Try
End Sub

' ============================================
'  EXPORT/IMPORT (para backup)
' ============================================

'Exporta todos os dados (grupos + notas) como Map
Public Sub ExportAllData As Map
	EnsureInit

	Dim groupsList As List
	groupsList.Initialize
	For i = 0 To NoteGroups.Size - 1
		Dim grp As clsNoteGroup = NoteGroups.Get(i)
		groupsList.Add(grp.ToMap)
	Next

	Dim notesList As List
	notesList.Initialize
	For i = 0 To Notes.Size - 1
		Dim note As clsNoteEntry = Notes.Get(i)
		notesList.Add(note.ToMap)
	Next

	Dim result As Map
	result.Initialize
	result.Put("noteGroups", groupsList)
	result.Put("notes", notesList)
	Return result
End Sub

'Importa dados (grupos + notas) de Map
Public Sub ImportAllData(data As Map)
	EnsureInit

	'Importa grupos
	If data.ContainsKey("noteGroups") Then
		Dim groupsList As List = data.Get("noteGroups")
		For i = 0 To groupsList.Size - 1
			Dim m As Map = groupsList.Get(i)
			Dim grp As clsNoteGroup
			grp.Initialize
			grp.FromMap(m)

			'Verifica se ja existe
			Dim exists As Boolean = False
			For j = 0 To NoteGroups.Size - 1
				Dim existing As clsNoteGroup = NoteGroups.Get(j)
				If existing.Id = grp.Id Then
					exists = True
					Exit
				End If
			Next

			If Not(exists) Then
				NoteGroups.Add(grp)
			End If
		Next
	End If

	'Importa notas
	If data.ContainsKey("notes") Then
		Dim notesList As List = data.Get("notes")
		For i = 0 To notesList.Size - 1
			Dim m As Map = notesList.Get(i)
			Dim note As clsNoteEntry
			note.Initialize
			note.FromMap(m)

			'Verifica se ja existe
			Dim noteExists As Boolean = False
			For j = 0 To Notes.Size - 1
				Dim existingNote As clsNoteEntry = Notes.Get(j)
				If existingNote.Id = note.Id Then
					noteExists = True
					Exit
				End If
			Next

			If Not(noteExists) Then
				Notes.Add(note)
			End If
		Next
	End If

	SaveData
End Sub

'Compatibilidade: Exporta apenas notas como lista de Maps
Public Sub ExportAll As List
	EnsureInit
	Dim result As List
	result.Initialize

	For i = 0 To Notes.Size - 1
		Dim note As clsNoteEntry = Notes.Get(i)
		result.Add(note.ToMap)
	Next

	Return result
End Sub

'Compatibilidade: Importa notas de lista de Maps
Public Sub ImportAll(notesList As List)
	EnsureInit

	For i = 0 To notesList.Size - 1
		Dim m As Map = notesList.Get(i)
		Dim note As clsNoteEntry
		note.Initialize
		note.FromMap(m)

		'Verifica se ja existe (por ID)
		Dim exists As Boolean = False
		For j = 0 To Notes.Size - 1
			Dim existing As clsNoteEntry = Notes.Get(j)
			If existing.Id = note.Id Then
				exists = True
				Exit
			End If
		Next

		If Not(exists) Then
			Notes.Add(note)
		End If
	Next

	SaveData
End Sub
