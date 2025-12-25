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
	Private Notes As List
	Private Initialized As Boolean = False
End Sub

' ============================================
'  INICIALIZACAO
' ============================================

Public Sub Init
	If Initialized Then Return
	Notes.Initialize
	LoadNotes
	Initialized = True
End Sub

Private Sub EnsureInit
	If Not(Initialized) Then Init
End Sub

' ============================================
'  CRUD - NOTAS
' ============================================

'Retorna todas as notas de um grupo
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

	Return result
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

	SaveNotes
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

	SaveNotes
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

	SaveNotes
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

Private Sub LoadNotes
	Notes.Initialize

	If File.Exists(File.DirInternal, NOTES_FILE) = False Then Return

	Try
		Dim json As String = File.ReadString(File.DirInternal, NOTES_FILE)
		Dim parser As JSONParser
		parser.Initialize(json)
		Dim data As List = parser.NextArray

		For i = 0 To data.Size - 1
			Dim m As Map = data.Get(i)
			Dim note As clsNoteEntry
			note.Initialize
			note.FromMap(m)
			Notes.Add(note)
		Next
	Catch
		Log("ModNotes.LoadNotes erro: " & LastException)
	End Try
End Sub

Private Sub SaveNotes
	Try
		Dim list As List
		list.Initialize

		For i = 0 To Notes.Size - 1
			Dim note As clsNoteEntry = Notes.Get(i)
			list.Add(note.ToMap)
		Next

		Dim gen As JSONGenerator
		gen.Initialize2(list)
		File.WriteString(File.DirInternal, NOTES_FILE, gen.ToString)
	Catch
		Log("ModNotes.SaveNotes erro: " & LastException)
	End Try
End Sub

' ============================================
'  EXPORT/IMPORT (para backup)
' ============================================

'Exporta todas as notas como lista de Maps
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

'Importa notas de lista de Maps
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

	SaveNotes
End Sub
