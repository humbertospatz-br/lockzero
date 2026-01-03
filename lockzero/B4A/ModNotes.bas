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
	EnsureSystemGroups
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
'  GRUPOS DE SISTEMA
' ============================================

'ID fixo do grupo Cartoes (sistema)
Public Sub GetCardsGroupId As String
	Return "system_cards"
End Sub

'Garante que grupos de sistema existem
'Chamado no Init - cria grupo Cartoes se nao existir
Public Sub EnsureSystemGroups
	'Verifica se grupo Cartoes existe
	Dim cardsGroup As clsNoteGroup = GetNoteGroupById(GetCardsGroupId)

	If cardsGroup = Null Then
		'Cria grupo Cartoes
		Dim grp As clsNoteGroup
		grp.Initialize
		grp.Id = GetCardsGroupId
		grp.Name = ModLang.T("cards")
		grp.Icon = Chr(0xD83D) & Chr(0xDCB3)  '💳 cartao de credito
		grp.IsSecure = True     'Sempre seguro
		grp.IsSystem = True     'Grupo de sistema
		grp.TemplateType = "card"

		'Herda Salt/TestValue de outro grupo de notas se existir
		CopySecurityFromExistingGroup(grp)

		NoteGroups.Add(grp)
		SaveData
		Log("ModNotes: Grupo Cartoes criado (sistema)")
	Else
		'Grupo ja existe - verifica se precisa herdar seguranca
		If cardsGroup.Salt = "" Or cardsGroup.TestValue = "" Then
			CopySecurityFromExistingGroup(cardsGroup)
			SaveNoteGroup(cardsGroup)
		End If
	End If
End Sub

'Copia Salt/TestValue de outro grupo de notas existente para o grupo alvo
'Usado para grupos de sistema herdarem a frase unica
Private Sub CopySecurityFromExistingGroup(targetGroup As clsNoteGroup)
	For i = 0 To NoteGroups.Size - 1
		Dim grp As clsNoteGroup = NoteGroups.Get(i)
		'Pula o proprio grupo e grupos sem seguranca configurada
		If grp.Id = targetGroup.Id Then Continue
		If grp.Salt = "" Or grp.TestValue = "" Then Continue

		'Encontrou grupo com frase configurada - copia
		targetGroup.Salt = grp.Salt
		targetGroup.TestValue = grp.TestValue
		Log("ModNotes: Seguranca copiada de " & grp.Name & " para " & targetGroup.Name)
		Return
	Next
	Log("ModNotes: Nenhum grupo com frase encontrado para copiar")
End Sub

'Limpa todas as notas de um grupo de sistema (sem deletar o grupo)
Public Sub ClearSystemGroup(groupId As String)
	EnsureInit

	'Verifica se e grupo de sistema
	Dim grp As clsNoteGroup = GetNoteGroupById(groupId)
	If grp = Null Or grp.IsSystem = False Then Return

	'Remove todas as notas do grupo
	For i = Notes.Size - 1 To 0 Step -1
		Dim note As clsNoteEntry = Notes.Get(i)
		If note.GroupId = groupId Then
			Notes.RemoveAt(i)
		End If
	Next

	SaveData
	Log("ModNotes: Grupo " & groupId & " limpo (" & grp.Name & ")")
End Sub

'Retorna template de cartao como lista de Maps [{text, checked}, ...]
'Usado ao criar nova nota no grupo Cartoes
Public Sub GetCardTemplate As List
	Dim items As List
	items.Initialize

	'Campos do cartao (9 campos)
	items.Add(CreateItem(ModLang.T("card_name") & ": "))
	items.Add(CreateItem(ModLang.T("card_brand") & ": "))
	items.Add(CreateItem(ModLang.T("card_number") & ": "))
	items.Add(CreateItem(ModLang.T("card_expiry") & ": "))
	items.Add(CreateItem(ModLang.T("card_cvv") & ": "))
	items.Add(CreateItem(ModLang.T("card_password") & ": "))
	items.Add(CreateItem(ModLang.T("card_holder") & ": "))
	items.Add(CreateItem(ModLang.T("card_limit") & ": "))
	items.Add(CreateItem(ModLang.T("notes") & ": "))

	Return items
End Sub

'Cria item de lista {text, checked}
Private Sub CreateItem(text As String) As Map
	Dim item As Map
	item.Initialize
	item.Put("text", text)
	item.Put("checked", False)
	Return item
End Sub

'Verifica se grupo e de sistema
Public Sub IsSystemGroup(groupId As String) As Boolean
	Dim grp As clsNoteGroup = GetNoteGroupById(groupId)
	If grp = Null Then Return False
	Return grp.IsSystem
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

'Busca global em notas
'query: texto a buscar
'passphrase: frase-senha para descriptografar grupos seguros (opcional, "" = so grupos abertos)
'Retorna lista de clsNoteEntry
Public Sub SearchAll(query As String, passphrase As String) As List
	EnsureInit
	Dim result As List
	result.Initialize
	Dim q As String = query.ToLowerCase.Trim

	If q.Length < 2 Then Return result

	For i = 0 To Notes.Size - 1
		Dim note As clsNoteEntry = Notes.Get(i)
		Dim found As Boolean = False

		'Obtem grupo da nota
		Dim group As clsNoteGroup = GetNoteGroupById(note.GroupId)

		If group = Null Or group.IsSecure = False Then
			'Grupo aberto - titulo e conteudo em texto claro
			If note.Title.ToLowerCase.Contains(q) Then
				found = True
			Else If note.Content.ToLowerCase.Contains(q) Then
				found = True
			End If
		Else
			'Grupo seguro - tenta descriptografar se frase fornecida
			If passphrase.Length > 0 Then
				Try
					Dim title As String = note.GetDecryptedTitle(passphrase).ToLowerCase
					If title.Contains(q) Then
						found = True
					Else
						Dim content As String = note.GetDecryptedContent(passphrase).ToLowerCase
						If content.Contains(q) Then
							found = True
						End If
					End If
				Catch
					'Ignora erro de descriptografia (frase errada para este grupo)
					Log("SearchAllGroups decrypt error: " & LastException.Message)
				End Try
			End If
		End If

		If found Then result.Add(note)
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
'  PERSISTENCIA (COM FALLBACK)
' ============================================

Private Sub LoadData
	NoteGroups.Initialize
	Notes.Initialize

	'Tenta carregar com fallback para .bak se corrompido
	Dim json As String = LoadFileWithFallback(File.DirInternal, NOTES_FILE)

	If json.Length = 0 Then
		Log("ModNotes.LoadData: nenhum arquivo disponivel, iniciando vazio")
		Return
	End If

	Try
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
		Log("ModNotes.LoadData erro ao parsear: " & LastException)
		NoteGroups.Initialize
		Notes.Initialize
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

	'SAVE ATOMICO - evita corrupcao se app crashar
	If SaveFileAtomic(File.DirInternal, NOTES_FILE, jsonData) Then
		Log("ModNotes.SaveData: Salvo " & NoteGroups.Size & " grupos, " & Notes.Size & " notas (" & jsonData.Length & " bytes)")
	Else
		Log("ModNotes.SaveData: ERRO ao salvar!")
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
