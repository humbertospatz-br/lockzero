# LOCKZERO - Especificacao Tecnica

> **Versao:** 2.0
> **Data:** Janeiro 2026
> **Stack:** B4A / B4xPages (Android)
> **Conceito:** "Lock and ZERO worries - Guarde suas informacoes e ZERO preocupacao"

---

## Indice

1. [Visao Geral](#visao-geral)
2. [Arquitetura](#arquitetura)
3. [Estrutura de Arquivos](#estrutura-de-arquivos)
4. [Modulos Implementados](#modulos-implementados)
5. [Classes de Dados](#classes-de-dados)
6. [Paginas B4xPages](#paginas-b4xpages)
7. [Seguranca](#seguranca)
8. [Interface UI/UX](#interface-uiux)
9. [Funcionalidades por Versao](#funcionalidades-por-versao)
10. [Roadmap](#roadmap)

---

## Visao Geral

### O que e o LockZero?

Cofre digital **100% offline** para armazenamento seguro de:
- **Senhas** de sites e aplicativos (com importacao CSV)
- **Notas seguras** (texto livre, listas com checkbox, anexos de arquivos)

> **Filosofia simplificada:** O LockZero foca em fazer duas coisas muito bem - Senhas e Notas.
> Cartoes de credito podem ser armazenados como notas de lista com template pre-definido.

### Principios Fundamentais

| Principio | Descricao |
|-----------|-----------|
| **Zero Internet** | Nenhum dado trafega pela rede |
| **Zero Conhecimento** | Nem nos sabemos sua frase |
| **Zero Recuperacao** | Perdeu a frase, perdeu acesso |
| **Zero Assinatura** | Freemium ou pagamento unico |

### Diferenciais

- 100% Offline - dados nunca saem do dispositivo
- Frase-senha pessoal para criptografia (AES-256)
- PIN + Biometria para acesso ao app
- Protecao contra brute force progressiva
- Backup criptografado .lockzero (inclui anexos)
- Multi-idioma (PT/EN/ES/HE - 4 idiomas)
- Anexos de arquivos em notas (imagens, videos, documentos)
- Anexos criptografados e compactados em area interna do app

---

## Arquitetura

### Stack Tecnologico

```
+--------------------------------------------------+
|                    B4A / B4xPages                 |
|         (Basic4Android - Cross-platform)         |
+--------------------------------------------------+
|                    CRIPTOGRAFIA                   |
|  - AES-256-CBC para dados                        |
|  - PBKDF2-SHA256 para derivacao de chave         |
|    (100.000 iteracoes - ~100ms por tentativa)    |
|  - Salt unico por grupo (32 bytes hex)           |
|  - XOR para ofuscacao em memoria                 |
+--------------------------------------------------+
|                    STORAGE LOCAL                  |
|  - JSON files (File.DirInternal)                 |
|  - passwords.json, notes.json, settings.dat      |
+--------------------------------------------------+
|                    SISTEMA                        |
|  - Android 5.0+ (API 21+)                        |
|  - Auto-lock em background (Activity_Pause)      |
|  - FLAG_SECURE (anti-screenshot) - futuro        |
+--------------------------------------------------+
```

### Bibliotecas B4A

```
Library1=b4xpages
Library2=core
Library3=encryption
Library4=json
Library5=reflection
Library6=stringutils
Library7=xui views
```

---

## Estrutura de Arquivos

```
lockzero/B4A/
|
+-- lockzero.b4a          # Projeto principal
+-- Starter.bas           # Service de inicializacao
+-- Main.bas              # Activity B4xPages
+-- B4XMainPage.bas       # Home + Dashboard
|
+-- # PAGINAS PRINCIPAIS
+-- PageOnboarding.bas    # Primeiro uso (4 idiomas)
+-- PageSettings.bas      # Configuracoes (PIN, biometria, idioma)
+-- PageGenerator.bas     # Gerador de senhas
|
+-- # SENHAS
+-- PagePasswords.bas     # Lista de grupos de senhas
+-- PagePasswordList.bas  # Senhas do grupo
+-- PagePasswordEdit.bas  # Criar/editar senha (com indicador de forca)
+-- PageImportCSV.bas     # Importar senhas de CSV
|
+-- # NOTAS
+-- PageNotesGroups.bas   # Lista de grupos de notas
+-- PageNotesList.bas     # Notas do grupo
+-- PageNoteEdit.bas      # Criar/editar nota (texto/lista/anexos)
|
+-- # BACKUP
+-- PageBackupExport.bas  # Exportar backup
+-- PageBackupImport.bas  # Importar backup
|
+-- # MODULOS
+-- ModSecurity.bas       # AES-256, PIN, biometria, brute force
+-- ModSession.bas        # Gerenciador de sessao
+-- ModPasswords.bas      # CRUD senhas e grupos
+-- ModNotes.bas          # CRUD notas e grupos
+-- ModAttachments.bas    # Gestao de anexos (copia, criptografa, compacta)
+-- ModBackup.bas         # Backup .lockzero (inclui anexos)
+-- ModTheme.bas          # Cores e tema
+-- ModLang.bas           # Multi-idioma PT/EN/ES/HE
+-- ModGenerator.bas      # Gerador de senhas
+-- ModTransition.bas     # Transicoes de tela
|
+-- # CLASSES
+-- clsPasswordGroup.bas  # Modelo de grupo de senhas
+-- clsPasswordEntry.bas  # Modelo de senha
+-- clsNoteGroup.bas      # Modelo de grupo de notas
+-- clsNoteEntry.bas      # Modelo de nota (texto/lista/anexos)
|
+-- Files/                # Assets (icones, fontes)
+-- Attachments/          # Pasta interna para anexos criptografados
```

---

## Modulos Implementados

### ModSecurity.bas

Responsavel por toda criptografia e configuracoes de seguranca.

```basic
'Funcoes principais:
Public Sub EncryptAES(text, passphrase, salt) As String
Public Sub DecryptAES(encrypted, passphrase, salt) As String
Public Sub GenerateSalt() As String
Public Sub HashSHA256(text) As String

'Brute Force Protection:
Public Sub RegisterFailedAttempt(groupId) As Int  'Retorna delay em segundos
Public Sub GetRemainingDelay(groupId) As Int
Public Sub ResetFailedAttempts(groupId)

'Delays progressivos:
' 5 tentativas -> 60s
' +3 tentativas -> 300s (5min)
' +2 tentativas -> +300s (acumulativo)

'Settings:
Public Sub GetSetting(key, defaultValue) As String
Public Sub SetSetting(key, value)
Public Sub GetTheme() As Int  '0=light, 1=dark
```

### ModSession.bas

Gerencia sessao em memoria com frase ofuscada.

```basic
'Funcoes principais:
Public Sub StartSession(passphrase As String)
Public Sub StartSessionWithCategory(passphrase, category As String)
Public Sub EndSession()
Public Sub IsSessionActive() As Boolean
Public Sub GetPassphrase() As String  'Retorna frase desofuscada
Public Sub Touch()  'Renova timeout
Public Sub Lock()  'Bloqueia sessao

'Funcoes de categoria:
Public Sub GetSessionCategory() As String
Public Sub GetSessionCategoryName() As String  'Nome traduzido
Public Sub IsSessionValidForCategory(category) As Boolean
Public Sub NeedsPassphraseForCategory(category) As Boolean

'Funcoes de tempo:
Public Sub GetRemainingSeconds() As Int
Public Sub GetRemainingFormatted() As String  'MM:SS

'Seguranca:
' - Frase armazenada com XOR usando salt aleatorio
' - Timeout automatico por inatividade
' - Limpeza de memoria ao encerrar
' - Suporte a frase unica ou por categoria
```

### ModPasswords.bas

CRUD completo para senhas e grupos.

```basic
'Grupos:
Public Sub GetAllGroups() As List
Public Sub GetGroupById(id) As clsPasswordGroup
Public Sub SaveGroup(g As clsPasswordGroup)
Public Sub DeleteGroup(id)

'Senhas:
Public Sub GetEntriesByGroup(groupId) As List
Public Sub GetEntryById(id) As clsPasswordEntry
Public Sub SaveEntry(e As clsPasswordEntry)
Public Sub DeleteEntry(id)
Public Sub GetEntryCountByGroup(groupId) As Int

'Criptografia:
Public Sub EncryptValue(value) As String  'Usa frase da sessao
Public Sub DecryptValue(encrypted) As String
```

### ModNotes.bas

CRUD para notas seguras.

```basic
Public Sub GetNotesByGroup(groupId) As List
Public Sub GetNoteById(id) As clsNoteEntry
Public Sub SaveNote(n As clsNoteEntry)
Public Sub DeleteNote(id)
```

### ModBackup.bas

Export/Import de backups criptografados.

```basic
Public Sub ExportBackup(phrase, folder) As String  'Retorna path
Public Sub ImportBackup(phrase, folder, fileName) As Map
Public Sub ValidateBackup(phrase, folder, fileName) As Map
Public Sub ListBackups(folder) As List
Public Sub HasBackup() As Boolean
Public Sub GetLastBackupTimeFormatted() As String
```

### ModTheme.bas

Paleta de cores profissional para app de seguranca.

```basic
'Cores principais (Dark Theme):
Primary:       RGB(10, 37, 64)    '#0A2540 Navy
Background:    RGB(12, 14, 18)    '#0C0E12 Preto azulado
Surface:       RGB(22, 27, 34)    '#161B22 Cards
TextPrimary:   RGB(230, 235, 240) '#E6EBF0
TextSecondary: RGB(140, 155, 170) '#8C9BAA
TextMuted:     RGB(95, 110, 125)  '#5F6E7D

'Status (sem verde vibrante):
Success:       RGB(45, 90, 140)   '#2D5A8C Azul
Warning:       RGB(160, 110, 45)  '#A06E2D Amber
Danger:        RGB(140, 45, 50)   '#8C2D32 Vermelho

'Categorias (monocromaticas):
CategoryPassword:  RGB(10, 37, 64)   Navy
CategoryCard:      RGB(50, 60, 75)   Cinza azulado
CategoryDocument:  RGB(38, 48, 60)   Cinza slate
CategoryNote:      RGB(45, 55, 70)   Cinza ardosia
```

### ModLang.bas

Internacionalizacao em 4 idiomas: PT, EN, ES, HE (Hebraico).

```basic
Public Sub T(key) As String  'Retorna texto traduzido
Public Sub SetLanguage(lang)  '"pt", "en", "es" ou "he"
Public Sub GetLanguage() As String
Public Sub GetLanguageName() As String  '"Português", "English", "Español", "עברית"

'Funcoes de carregamento:
Private Sub LoadPortuguese()
Private Sub LoadEnglish()
Private Sub LoadSpanish()
Private Sub LoadHebrew()

'~200 strings por idioma incluindo:
passwords, cards, documents, notes, backup
save, cancel, delete, edit, confirm
session_expired, wrong_passphrase, success, error
attachments, add_attachment, open_file, delete_attachment
```

---

## Classes de Dados

### clsPasswordGroup.bas

```basic
Public Id As String           'UUID
Public Name As String         'Nome do grupo
Public Salt As String         'Salt unico para criptografia
Public TestValue As String    '"LOCKZERO" criptografado
Public CreatedAt As Long
Public UpdatedAt As Long

'Metodos:
Public Sub Initialize()
Public Sub GenerateSalt()
Public Sub CreateTestValue(passphrase)
Public Sub ValidatePhrase(passphrase) As Boolean
Public Sub ToMap() As Map
Public Sub FromMap(m As Map)
```

### clsPasswordEntry.bas

```basic
Public Id As String
Public GroupId As String
Public Name As String          'Nome do site/app
Public Url As String
Public Username As String      'Criptografado
Public PasswordEnc As String   'Criptografado
Public Notes As String         'Criptografado
Public IsFavorite As Boolean
Public CreatedAt As Long
Public UpdatedAt As Long
Public LastUsedAt As Long

'Metodos:
Public Sub Initialize()
Public Sub GetDisplayName() As String
Public Sub MarkAsUsed()
Public Sub ToMap() As Map
Public Sub FromMap(m As Map)
```

### clsNoteEntry.bas

```basic
Public Id As String
Public GroupId As String
Public Title As String         'Titulo (criptografado se grupo seguro)
Public Content As String       'Conteudo texto livre (criptografado se grupo seguro)
Public NoteType As String      '"text" ou "list"
Public Items As String         'JSON array de itens para lista: [{text, checked}, ...]
Public Attachments As String   'JSON array de anexos: [{dir, name}, ...]
Public SortOrder As Int        'Ordem manual
Public IsFavorite As Boolean
Public CreatedAt As Long
Public UpdatedAt As Long

'Metodos de criptografia:
Public Sub EncryptTitle(passphrase, title)
Public Sub EncryptContent(passphrase, content)
Public Sub EncryptItems(passphrase, plainItems)
Public Sub EncryptAttachments(passphrase, plainAttachments)
Public Sub GetDecryptedTitle(passphrase) As String
Public Sub GetDecryptedContent(passphrase) As String
Public Sub GetDecryptedItems(passphrase) As String
Public Sub GetDecryptedAttachments(passphrase) As String

'Metodos de lista (checkbox):
Public Sub GetItemsList() As List
Public Sub SetItemsList(itemsList As List)
Public Sub AddItem(text As String)
Public Sub ToggleItem(index As Int)
Public Sub RemoveItem(index As Int)
Public Sub GetItemsCount() As Int
Public Sub GetCheckedCount() As Int

'Metodos de anexos:
Public Sub GetAttachmentsList() As List
Public Sub SetAttachmentsList(attachList As List)
Public Sub AddAttachment(filePath As String)
Public Sub RemoveAttachment(index As Int)
Public Sub GetAttachmentsCount() As Int
```

---

## Sistema de Anexos (Attachments)

> **Objetivo:** Permitir anexar imagens, videos e documentos a notas de forma segura.

### Fluxo de Armazenamento

```
USUARIO SELECIONA ARQUIVO:
1. ContentChooser abre seletor de arquivos do sistema
2. Usuario seleciona imagem, video ou documento
3. LockZero valida tamanho (max 25MB por arquivo)
4. Arquivo e COPIADO para pasta interna do app

PROCESSAMENTO:
5. Arquivo original e lido em bytes
6. Bytes sao criptografados com AES-256 (frase-senha do grupo)
7. Resultado e compactado (ZIP) para economizar espaco
8. Arquivo .lza (LockZero Attachment) e salvo em File.DirInternal/Attachments/

ESTRUTURA DO ARQUIVO .lza:
{
  "version": 1,
  "noteId": "uuid-da-nota",
  "originalName": "foto.jpg",
  "originalSize": 1234567,
  "mimeType": "image/jpeg",
  "encryptedData": "base64...",
  "checksum": "sha256..."
}
```

### Limites de Tamanho

| Tipo | Limite por Arquivo | Justificativa |
|------|-------------------|---------------|
| Imagem | 25 MB | Fotos de alta resolucao (RAW, HEIC) |
| Video | 25 MB | Clips curtos (1-2 min em 720p) |
| Documento | 25 MB | PDFs grandes, apresentacoes |
| **Total por Nota** | 100 MB | Evitar notas muito pesadas |
| **Total no App** | 500 MB | Espaco razoavel para dispositivo |

> **Nota:** Limites podem ser configurados em versao PREMIUM futura.

### Estrutura de Armazenamento

```
File.DirInternal/
├── lockzero_passwords.json      # Senhas (criptografadas)
├── lockzero_notes.json          # Notas (criptografadas)
├── lockzero_settings.dat        # Configuracoes
├── Attachments/                 # Pasta de anexos
│   ├── {noteId}/               # Subpasta por nota
│   │   ├── {uuid1}.lza         # Anexo criptografado
│   │   ├── {uuid2}.lza         # Anexo criptografado
│   │   └── ...
│   └── ...
└── Temp/                        # Arquivos temporarios (limpos ao sair)
```

### Backup de Anexos

**Anexos sao incluidos no backup .lockzero:**

```
ESTRUTURA DO BACKUP v2.0:
{
  "version": 2,
  "appVersion": "0.2.0",
  "createdAt": 1704000000000,
  "checksum": "sha256...",
  "data": {
    "passwords": [...],
    "notes": [...],
    "attachments": {
      "note-uuid-1": [
        {
          "id": "attach-uuid",
          "originalName": "foto.jpg",
          "mimeType": "image/jpeg",
          "size": 1234567,
          "data": "base64_criptografado..."
        }
      ]
    }
  }
}
```

**Observacoes:**
- Backup fica maior com anexos (considerar isso no compartilhamento)
- Anexos ja estao criptografados, nao precisam criptografar de novo
- Restaurar backup recria pasta Attachments/
- Se espaco insuficiente, backup falha com mensagem clara

### ModAttachments.bas (a implementar)

```basic
'Constantes:
Public Const MAX_FILE_SIZE As Long = 26214400      '25 MB
Public Const MAX_TOTAL_NOTE As Long = 104857600    '100 MB
Public Const MAX_TOTAL_APP As Long = 524288000     '500 MB
Public Const ATTACHMENTS_FOLDER As String = "Attachments"

'Funcoes principais:
Public Sub AddAttachment(noteId, filePath, passphrase) As Map  'Retorna info do anexo
Public Sub GetAttachment(noteId, attachId, passphrase) As Byte()  'Retorna bytes originais
Public Sub DeleteAttachment(noteId, attachId)
Public Sub DeleteAllAttachments(noteId)  'Ao deletar nota
Public Sub GetAttachmentInfo(noteId, attachId) As Map
Public Sub ListAttachments(noteId) As List

'Funcoes de validacao:
Public Sub ValidateFileSize(filePath) As Boolean
Public Sub GetTotalNoteSize(noteId) As Long
Public Sub GetTotalAppSize() As Long
Public Sub CanAddAttachment(noteId, fileSize) As Boolean

'Funcoes de backup:
Public Sub ExportAttachmentsForBackup(noteId) As List  'Lista de Maps
Public Sub ImportAttachmentsFromBackup(noteId, attachmentsList, passphrase)

'Funcoes auxiliares:
Public Sub GetMimeType(fileName) As String
Public Sub GetTempFilePath(attachId) As String
Public Sub CleanupTempFiles()
```

### Tipos de Arquivo Suportados

| Categoria | Extensoes | MIME Types |
|-----------|-----------|------------|
| Imagens | jpg, jpeg, png, gif, webp, heic | image/* |
| Videos | mp4, mov, avi, mkv, webm | video/* |
| Documentos | pdf, doc, docx, xls, xlsx, ppt, pptx | application/* |
| Texto | txt, csv, json, xml | text/* |

> **Arquivos nao suportados:** Executaveis (.exe, .apk), scripts (.sh, .bat)

### Interface de Usuario

**PageNoteEdit.bas - Secao de Anexos:**
```
┌─────────────────────────────────────┐
│ Anexos (3)                    [+ ]  │
├─────────────────────────────────────┤
│ 📷 foto_documento.jpg    1.2 MB  🗑 │
│ 📄 contrato.pdf          450 KB  🗑 │
│ 🎬 video_curto.mp4       15 MB   🗑 │
├─────────────────────────────────────┤
│ Espaco usado: 16.6 MB / 100 MB      │
└─────────────────────────────────────┘
```

**Acoes:**
- Toque no anexo: Abre com app externo (descriptografa para Temp/)
- Toque na lixeira: Confirma e remove anexo
- Toque no +: Abre ContentChooser para selecionar arquivo

---

## Paginas B4xPages

### B4XMainPage.bas - Home

- Lista vertical de categorias (Senhas, Notas)
- Cada item com avatar, titulo, subtitulo e chevron
- Menu lateral com opcoes adicionais
- Rodape com versao FREE/Premium
- Timer de sessao visivel

### PagePasswords.bas - Grupos

- Header com titulo "GRUPOS" e botao +
- Lista de grupos com contador de senhas
- Click: abre dialog de frase para validar
- Long click: editar/deletar grupo

### PagePasswordList.bas - Senhas

- Titulo breadcrumb: "Senhas → NomeGrupo"
- Header com titulo, timer de sessao e botao +
- **Timer de sessao no header:**
  - Exibe tempo restante (MM:SS)
  - Cor amarela quando < 60s
  - Toque no timer: dialog para bloquear sessao manualmente
  - Sessao expirada: volta automaticamente para tela anterior
- Lista de senhas com favorito, nome, username
- Botao copiar senha (limpa clipboard em 30s)
- Click: detalhes / Long click: opcoes

### PagePasswordEdit.bas - Formulario

- Campos: Nome, URL, Username, Senha, Notas
- Botao mostrar/esconder senha
- Botao gerar senha aleatoria
- Checkbox favorito
- Scroll automatico quando teclado abre

### PageNotesGroups.bas / PageNotesList.bas / PageNoteEdit.bas

**PageNotesGroups.bas:**
- Lista de grupos de notas (seguros e nao-seguros)
- Click: abre lista de notas do grupo
- Long click: editar/deletar grupo

**PageNotesList.bas:**
- Lista de notas do grupo
- Icone indica tipo (texto ou lista)
- Preview do conteudo ou "X de Y itens"
- Busca com icone lupa no header

**PageNoteEdit.bas:**
- Selecao de tipo: texto ou lista
- Nota de texto: Titulo + Conteudo livre
- Nota de lista: Titulo + Items com checkbox
- Secao de anexos (arquivos)
- ContentChooser para selecionar arquivos
- Abrir anexo com app externo

### PageBackup.bas

- Info do ultimo backup
- Botao "Criar Backup" (pede frase)
- Botao "Restaurar Backup" (pede frase)
- Botao "Testar Backup" (valida sem importar)
- Dica: usar oracao, musica ou frase conhecida

### PageOnboarding.bas

- 4 telas simples:
  0. Language - selecao de idioma (PT/EN/ES/HE)
  1. Welcome - apresentacao
  2. Warning - aviso zero recuperacao
  3. Complete - pronto para usar
- RadioButtons para selecao de idioma
- Checkbox obrigatorio "Entendi os riscos"
- Textos traduzidos conforme idioma selecionado

---

## Seguranca

### Criptografia de Dados

| Dado | Algoritmo | Derivacao de Chave |
|------|-----------|-------------------|
| Senhas | AES-256-CBC | PBKDF2(frase, salt, 100k iter) |
| Usernames | AES-256-CBC | PBKDF2(frase, salt, 100k iter) |
| Notas | AES-256-CBC | PBKDF2(frase, salt, 100k iter) |
| TestValue | AES-256-CBC | PBKDF2(frase, salt, 100k iter) |
| Backup | AES-256-CBC | PBKDF2(frase backup, salt fixo, 100k iter) |

**Por que PBKDF2?**
- SHA-256 simples: ~1.000.000 tentativas/segundo (vulneravel)
- PBKDF2 100k iter: ~10 tentativas/segundo (seguro)
- Atacante precisa 100.000x mais tempo para cada tentativa

### PIN de Acesso (v0.1.1)

O PIN de acesso ao app usa armazenamento seguro:

| Aspecto | Implementacao |
|---------|---------------|
| Algoritmo | PBKDF2WithHmacSHA256 |
| Iteracoes | 100.000 |
| Salt | 32 caracteres hex aleatorios por PIN |
| Formato arquivo | `salt:hash` |
| Comparacao | Tempo constante (evita timing attacks) |
| Migracao | Automatica do formato Base64 legado |

```basic
'Fluxo de salvamento:
SavePIN(pin):
  salt = GenerateRandomSalt()          '32 hex chars
  hash = PBKDF2(pin, salt, 100000)     '256 bits
  File.Write(salt & ":" & BytesToHex(hash))

'Fluxo de validacao:
ValidatePIN(inputPin):
  data = File.Read()
  salt, savedHash = Split(data, ":")
  inputHash = PBKDF2(inputPin, salt, 100000)
  Return SecureCompare(inputHash, savedHash)  'Tempo constante
```

### Integridade de Arquivos (v0.1.1)

Protecao contra corrupcao de dados:

```
SAVE ATOMICO:
1. Escreve em arquivo.tmp
2. Verifica se escreveu corretamente (re-leitura)
3. Copia original para arquivo.bak
4. Substitui original pelo tmp (operacao atomica)
5. Remove tmp

FALLBACK:
- Se arquivo principal invalido, tenta carregar .bak
- Se .bak valido, restaura automaticamente
- Log de recuperacao para debugging
```

| Cenario de Crash | Estado | Recuperacao |
|------------------|--------|-------------|
| Durante escrita tmp | tmp parcial | Usa original |
| Durante verificacao | tmp OK, original OK | Usa original |
| Durante backup | tmp OK, bak OK, original OK | Usa original |
| Durante substituicao | Impossivel (atomico) | - |
| Apos substituicao | tmp sobrando | Usa novo |

### Normalizacao de Frase-Senha

> **DOCUMENTACAO INTERNA - NAO DIVULGAR AO USUARIO**

A frase-senha do usuario passa por normalizacao antes de ser usada na criptografia.
Isso segue a mesma logica do LockSeed.

**Regras de Normalizacao:**

| Etapa | Regra | Exemplo |
|-------|-------|---------|
| 1 | Remove espacos | "Minha avo" → "Minhaavo" |
| 2 | Converte para minusculas | "Minhaavo" → "minhaavo" |
| 3 | Remove acentos (ASCII) | "minhaavo" → "minhaavo" (a→a, c→c) |
| 4 | Extrai 10 chars unicos | "minhaavo" → "minhavo" (7 unicos) |

**Exemplos Completos:**

| Frase Original | Resultado | Status |
|----------------|-----------|--------|
| "Minha avo nasceu em 1950" | "minhavonsce" (11 unicos) | OK |
| "AAAaaa123" | "a123" (4 unicos) | REJEITADO |
| "Hello World 123" | "helowrd123" (10 unicos) | OK |
| "12345678" | "12345678" (8 unicos) | REJEITADO |

**Validacao:**
- Frase deve ter minimo 8 caracteres (antes de normalizar)
- Apos normalizar, deve resultar em pelo menos 10 chars unicos
- Se nao atingir, mostra mensagem generica: **"Frase muito curta"**

**Seguranca:**
- Mensagem de erro SEMPRE generica
- Usuario NUNCA sabe que precisa de 10 chars diferentes
- Logica interna nao e revelada

### Validacao de Frase (TestValue Dinamico)

**Problema do TestValue fixo:**
Se TestValue sempre descriptografa para "LOCKZERO", atacante tem known-plaintext.

**Solucao - TestValue dinamico:**
```
Ao criar grupo:
  salt = GenerateRandomSalt()
  expectedValue = SHA256(salt)  // Valor esperado unico por grupo
  TestValue = Encrypt(frase, expectedValue)

Ao validar frase:
  expectedValue = SHA256(salt)
  decrypted = Decrypt(frase_digitada, TestValue)
  if decrypted == expectedValue -> frase correta
```

Cada grupo tem TestValue diferente, impossibilitando known-plaintext attack.

### Protecao Brute Force

| Tentativas | Delay |
|------------|-------|
| 1-5 | 0 |
| 6-8 | 60 segundos |
| 9-10 | 300 segundos (5 min) |
| 11+ | +300s cada |

Combinado com PBKDF2: ataque de forca bruta se torna impraticavel.

### Sessao em Memoria

- Frase armazenada com XOR (ofuscada)
- Salt aleatorio gerado por sessao
- Timeout de 2-5 minutos de inatividade (configuravel)
- Touch() renova timeout a cada interacao
- Limpeza completa ao encerrar
- **Bloqueio manual:** usuario pode encerrar sessao tocando no timer

**Sessao unica global:**
- Apenas UMA frase ativa por vez
- Ao trocar de grupo com frase diferente, sessao anterior encerra
- Comportamento intencional de seguranca (nao e bug)

**Timer de sessao visivel:**
- Exibido no header da lista de senhas E no footer da Home
- Formato MM:SS decrescente
- Cor azul gelo (RGB 0, 220, 255) quando < 60 segundos para melhor visibilidade
- Clicavel para bloqueio imediato (com confirmacao)

**Criacao de grupos com sessao ativa:**
- Quando sessao esta ativa, nao solicita frase-senha ao criar novo grupo
- Reutiliza a frase da sessao atual automaticamente
- Mostra indicador "Sessao ativa" no dialog de criacao
- Apenas checkbox seguro/nao-seguro visivel
- Aplica-se a Senhas (PagePasswords) e Notas (PageNotesGroups)

**Modo de frase-senha (configuravel):**
- **Frase unica:** Mesma frase para todas as categorias (padrao)
  - Sessao continua ao navegar entre categorias
  - Mais conveniente para uso diario
- **Frase por categoria:** Cada categoria pode ter sua propria frase
  - Ao trocar de categoria, sessao anterior encerra
  - Exibe nome da categoria no timer (ex: "Senhas • 2:30")
  - Maior seguranca (compartimentalizacao)

### Auto-lock em Background

Quando app vai para segundo plano (Activity_Pause):
- Sessao e encerrada imediatamente
- Usuario precisa re-digitar frase ao voltar
- Protege contra acesso fisico ao dispositivo desbloqueado

### Bloqueio de Screenshot (FLAG_SECURE)

> **STATUS:** Planejado para implementacao
> **TESTES:** Manter DESABILITADO durante desenvolvimento

**Funcionalidade:**
- Impede capturas de tela (screenshot) dentro do app
- Impede gravacao de tela em video
- Tela aparece preta em screenshots/gravacoes
- Tela aparece preta no app switcher (recentes)

**Implementacao Android:**
```basic
'Em Activity_Create ou Activity_Resume:
Dim jo As JavaObject = GetActivity
Dim window As JavaObject = jo.RunMethod("getWindow", Null)

'FLAG_SECURE = 8192 (0x2000)
window.RunMethod("addFlags", Array(8192))
```

**Onde aplicar:**
| Tela | FLAG_SECURE | Motivo |
|------|-------------|--------|
| Main.bas | Sim | Activity principal |
| Dialogs de frase | Sim | Usuario digita frase |
| Lista de senhas | Sim | Dados sensiveis visiveis |
| Detalhes de senha | Sim | Senha pode estar visivel |

**Configuracao de desenvolvimento:**
```basic
'Starter.bas - Constante global
Public ENABLE_SCREENSHOT_BLOCK As Boolean = False  'Testes: False, Producao: True

'Main.bas - Aplicar condicionalmente
If Starter.ENABLE_SCREENSHOT_BLOCK Then
    Dim jo As JavaObject = GetActivity
    jo.RunMethod("getWindow", Null).RunMethod("addFlags", Array(8192))
End If
```

**Notas importantes:**
- FLAG_SECURE deve ser definida ANTES de setContentView
- Melhor aplicar em Activity_Create
- Nao impede que usuario memorize ou anote manualmente
- Protege contra captura automatica/malware

### Confirmacao de Exclusao

Operacoes destrutivas (deletar grupo/senha) exigem:
- Re-digitacao da frase do grupo
- Previne exclusao acidental
- Protege contra acesso nao autorizado temporario

### Clipboard

- Senha copiada limpa automaticamente em 30s
- Timer visivel para usuario
- Complementa limpeza automatica do Android 13+ (1h)

---

## Interface UI/UX

### Regras de Design

1. **Cores sobrias** - app de seguranca, nao de entretenimento
2. **Sem verde vibrante** - usar azul para sucesso
3. **Sem marrom** - usar cinzas e navy
4. **Sem emojis** - usar simbolos Unicode basicos
5. **Headers consistentes** - ActionBar do sistema + sub-header interno

### Tipografia

```
Titulo:    20sp, Bold, White
Subtitulo: 16sp, Bold, TextPrimary
Body:      14-15sp, Regular, TextPrimary
Caption:   12sp, Regular, TextMuted
Button:    14sp, Bold, White
```

### Espacamentos

```
Margin padrao:    16dip
Padding card:     12-16dip
Gap entre itens:  8dip
Border radius:    8-12dip
```

### Componentes

**Card de item:**
- Altura: 72dip
- Avatar circular: 48dip
- Titulo + Subtitulo
- Chevron a direita

**Botao + (header):**
- Tamanho: 36x36dip
- Cor: Primary
- Texto: "+"
- Gravity: CENTER

---

## Funcionalidades por Versao

### FREE

| Recurso | Limite |
|---------|--------|
| Senhas | 15 |
| Notas | 10 |
| Anexos por nota | 3 |
| Tamanho total anexos | 100 MB |
| Backup .lockzero | Sim |
| Gerador senhas | Basico |
| Import CSV | Sim (Chrome, Edge, Firefox) |

### PREMIUM (futuro)

| Recurso | Descricao |
|---------|-----------|
| Senhas ilimitadas | Sem limite de senhas |
| Notas ilimitadas | Sem limite de notas |
| Anexos ilimitados | Sem limite por nota |
| Tamanho total anexos | 2 GB |
| Export CSV | Exportar para outros gerenciadores |
| Gerador avancado | Memoravel, passphrase, PIN |
| Detector senhas fracas | Lista senhas com forca baixa |
| Detector duplicadas | Avisa senhas repetidas |
| Historico senhas | Ultimas 3-5 versoes |
| Alerta expiracao | Senhas antigas >6 meses |

### Modelo de Monetizacao

**Opcao 1 - Freemium (recomendado):**
- FREE: Limites generosos para uso pessoal
- PREMIUM: Pagamento unico (sem assinatura)
- Preco sugerido: R$ 19,90 - R$ 29,90

**Opcao 2 - Totalmente gratis:**
- Todas funcionalidades liberadas
- Monetizacao via doacoes (Buy me a coffee)
- Codigo aberto (GitHub)

**Filosofia:** Zero Assinatura - usuario paga uma vez, usa para sempre

---

## Roadmap

### v0.1.0 - MVP (concluido)

- [x] Cofre de senhas com grupos
- [x] Notas seguras
- [x] Criptografia AES-256
- [x] Sessao com timeout
- [x] Brute force protection
- [x] Backup .lockzero
- [x] Multi-idioma PT/EN
- [x] Tema dark

### v0.1.1 - Hardening de Seguranca (atual)

**Criptografia e Derivacao de Chave:**
- [x] PBKDF2 para derivacao de chave (100k iteracoes)
- [x] TestValue dinamico (hash do salt)
- [x] PIN com PBKDF2 + salt aleatorio (era Base64)
- [x] Comparacao de hash em tempo constante (evita timing attacks)
- [x] Migracao automatica de PINs legados

**Integridade de Dados:**
- [x] Save atomico (tmp → verificar → bak → substituir)
- [x] Fallback automatico para .bak se arquivo corrompido
- [x] Validacao de JSON antes de carregar

**Interface:**
- [x] Timer de sessao visivel no header e Home com bloqueio manual
- [x] Modo frase unica/por categoria (configuravel)
- [ ] Tela de configuracoes (PageSettings)
- [x] Auto-lock em background (Activity_Pause)
- [ ] Confirmacao de exclusao com re-digitacao de frase
- [ ] Contador de itens nos cards da Home

### v0.1.2 - Hardening de Criptografia (atual)

**IV Aleatorio por Operacao:**
- [x] Gerar IV aleatorio de 16 bytes para cada criptografia
- [x] Formato: `AES:iv_hex:ciphertext_base64`
- [x] Compatibilidade com dados antigos (IV deterministico)

**HMAC para Integridade:**
- [x] Adicionar HMAC-SHA256 apos criptografia (Encrypt-then-MAC)
- [x] Formato: `AES:iv_hex:base64_ciphertext:hmac_hex`
- [x] Rejeitar dados com HMAC invalido (SecureCompare tempo constante)

**Limpeza de Memoria:**
- [x] Zerar arrays de bytes sensiveis apos uso (ZeroBytes helper)
- [x] Zerar arrays de chars sensiveis (ZeroChars helper)
- [x] Chamar `keySpec.clearPassword()` sempre
- [x] Cleanup em todas funcoes de criptografia
- [x] Cleanup em funcoes de PIN (SavePIN, ValidatePIN)

**Especificacao Tecnica do Novo Formato:**
```
FORMATO ATUAL:  AES:base64(ciphertext)
                IV = MD5(reverse(passphrase))  ← DETERMINISTICO (vulneravel)

FORMATO NOVO:   AES:hex(iv):base64(ciphertext):hex(hmac)
                IV = SecureRandom(16 bytes)     ← ALEATORIO (seguro)
                HMAC = HMAC-SHA256(key, iv || ciphertext)

MIGRACAO:
- Ao descriptografar: detectar formato pelo numero de ":"
- Formato antigo (1 ":"): usar IV deterministico
- Formato novo (3 ":"): usar IV do campo, validar HMAC
- Ao criptografar: sempre usar formato novo
```

### v0.1.3 - Busca e Indicador de Forca (atual)

**Indicador de Forca de Senha:**
- [x] `ModSecurity.CalculatePasswordStrength()` - Calcula forca (0-3)
- [x] `ModSecurity.GetStrengthColor()` - Cor por nivel
- [x] `ModSecurity.GetStrengthText()` - Texto traduzido
- [x] UI em `PagePasswordEdit.bas` - Barra visual + texto
- [x] Atualiza em tempo real ao digitar

**Busca por Categoria:**
- [x] `ModPasswords.SearchAll()` - Busca senhas (nome, URL, username)
- [x] `ModNotes.SearchAll()` - Busca notas (titulo, conteudo, itens de checklist)
- [x] `PagePasswords.bas` - Icone lupa 🔍 no header + busca em grupos/senhas
- [x] `PagePasswordList.bas` - Campo de busca sempre visivel (ja existia)
- [x] `PageNotesList.bas` - Icone lupa 🔍 no header + campo expansivel
- [x] Busca usa frase-senha ja autenticada do grupo
- [x] Busca em tempo real conforme digita (FilterNotes/FilterEntries)
- [x] Suporte a notas de texto E notas de lista (checklist)
- [x] Termo de busca passa entre paginas (grupos → lista interna)

**Importar CSV:**
- [x] Item "Importar CSV" no menu lateral (B4XMainPage)
- [x] Dialog com instrucoes de como exportar do Chrome
- [x] Formato do CSV: name, url, username, password
- [x] Seletor de arquivo (ContentChooser)
- [x] PageImportCSV.bas - processa e importa senhas

**Criterios de Forca:**
| Nivel | Texto | Cor | Criterio |
|-------|-------|-----|----------|
| 0 | Fraca | Vermelho | <8 chars OU so 1 tipo |
| 1 | Media | Laranja | 8-11 chars + 2 tipos OU 12+ chars |
| 2 | Forte | Verde | 12-15 chars + 3 tipos OU 16+ chars + 2 tipos |
| 3 | Muito forte | Verde brilhante | 16+ chars + 4 tipos OU 20+ chars + 3 tipos |

### v0.2.0 - Sistema de Anexos

- [ ] ModAttachments.bas - gestao de anexos
- [ ] Copia arquivo para area interna
- [ ] Criptografia AES-256 do arquivo
- [ ] Compactacao ZIP
- [ ] Limites de tamanho (25MB/arquivo, 100MB/nota, 500MB/app)
- [ ] Interface de anexos em PageNoteEdit
- [ ] Inclusao de anexos no backup .lockzero

### v0.3.0 - Polimento e Configuracoes

- [ ] PageSettings completo
- [ ] FLAG_SECURE (anti-screenshot)
- [ ] Limpeza automatica de clipboard
- [ ] Animacoes de transicao entre telas

### v1.0.0 - Publicacao

- [ ] Testes de seguranca
- [ ] Google Play Store
- [ ] Documentacao usuario
- [ ] Termos de uso e privacidade

### Funcionalidades Futuras (pos-v1.0)

**Integracao Android:**
- [ ] **Autofill Service** - Preencher senhas automaticamente em outros apps
  - API: AutofillService (Android 8+)
  - Usuario seleciona LockZero como provedor de senhas
  - Requer permissao especial do sistema

- [ ] **Atalhos de App** - Long press no icone mostra favoritos
  - API: ShortcutManager (Android 7.1+)
  - Acesso rapido as 3-4 senhas mais usadas

- [ ] **Widget Home** - Mostrar contagem de itens e acesso rapido
  - Widget 2x1 ou 4x1
  - Nao mostra dados sensiveis

**Seguranca Avancada:**
- [ ] **Verificacao de Vazamentos** - Comparar com base HIBP offline
  - Have I Been Pwned oferece base de dados k-anonymity
  - Comparacao 100% local (sem internet)
  - Alertar senhas potencialmente comprometidas

- [ ] **Passkeys (WebAuthn/FIDO2)** - Autenticacao sem senha
  - Padrao emergente (Google, Apple, Microsoft)
  - Implementar quando API Android estiver madura
  - Substituira senhas tradicionais gradualmente

**Protecao Especial:**
- [ ] **PIN de Panico** - Abre cofre vazio sob coacao
  - PIN diferente do normal
  - Mostra dados falsos ou cofre vazio
  - Protecao contra coacao fisica

- [ ] **Modo Disfarce** - Icone de calculadora/relogio
  - App aparenta ser calculadora ou relogio
  - Sequencia especial revela cofre real
  - Protecao contra acesso fisico ao dispositivo

**Compartilhamento:**
- [ ] **QR Code Temporario** - Compartilhar senha via QR
  - QR expira apos X segundos
  - Criptografado com chave temporaria
  - Util para compartilhar Wi-Fi com visitas

---

## Referencias

- **Dominio:** lockzero.pro
- **Familia:** Lockseed Products
- **Base de codigo:** LockSeed (modulo senhas)

---

**Ultima atualizacao:** 2026-01-03

---

## Status de Implementacao

| Categoria | Status | Observacao |
|-----------|--------|------------|
| Senhas | ✅ 100% | CRUD completo, busca, favoritos, import CSV |
| Notas | ✅ 100% | Texto, lista (checkbox) |
| Anexos em Notas | ⏳ 0% | Copia, criptografa e compacta arquivos |
| Backup | ✅ 100% | Export/Import .lockzero criptografado |
| Backup c/ Anexos | ⏳ 0% | Inclui anexos no backup |
| Import CSV | ✅ 100% | Chrome, Edge, Firefox, Safari |
| Multi-idioma | ✅ 100% | PT, EN, ES, HE (4 idiomas) |
| PIN/Biometria | ✅ 100% | Funcional em PageSettings |
| Indicador Forca | ✅ 100% | Em PagePasswordEdit |
| Busca | ✅ 100% | Por categoria (senhas, notas) |
| Onboarding | ✅ 100% | 4 idiomas, avisos de seguranca |
