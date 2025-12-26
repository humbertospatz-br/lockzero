# LOCKZERO - Especificacao Tecnica

> **Versao:** 0.1.0
> **Data:** Dezembro 2025
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
- Senhas de sites e aplicativos
- Cartoes de credito/debito (futuro)
- Documentos pessoais (futuro)
- Notas seguras
- Credenciais Wi-Fi (futuro)

### Principios Fundamentais

| Principio | Descricao |
|-----------|-----------|
| **Zero Internet** | Nenhum dado trafega pela rede |
| **Zero Conhecimento** | Nem nos sabemos sua frase |
| **Zero Recuperacao** | Perdeu a frase, perdeu acesso |
| **Zero Assinatura** | Freemium ou pagamento unico |

### Diferenciais

- 100% Offline - dados nunca saem do dispositivo
- Frase-senha pessoal para criptografia
- Protecao contra brute force progressiva
- Backup criptografado .lockzero
- Multi-idioma (PT/EN)

---

## Arquitetura

### Stack Tecnologico

```
+--------------------------------------------------+
|                    B4A / B4xPages                 |
|         (Basic4Android - Cross-platform)         |
+--------------------------------------------------+
|                    CRIPTOGRAFIA                   |
|  - AES-256 para dados                            |
|  - SHA-256 para derivacao de chave               |
|  - Salt unico por grupo                          |
|  - XOR para ofuscacao em memoria                 |
+--------------------------------------------------+
|                    STORAGE LOCAL                  |
|  - JSON files (File.DirInternal)                 |
|  - passwords.json, notes.json, settings.dat      |
+--------------------------------------------------+
|                    SISTEMA                        |
|  - Android 5.0+ (API 21+)                        |
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
+-- # PAGINAS
+-- PagePasswords.bas     # Lista de grupos
+-- PagePasswordList.bas  # Senhas do grupo
+-- PagePasswordEdit.bas  # Criar/editar senha
+-- PageNotesList.bas     # Lista de notas
+-- PageNoteEdit.bas      # Criar/editar nota
+-- PageBackup.bas        # Export/Import .lockzero
+-- PageOnboarding.bas    # Primeiro uso
|
+-- # MODULOS
+-- ModSecurity.bas       # AES-256, brute force, settings
+-- ModSession.bas        # Gerenciador de sessao
+-- ModPasswords.bas      # CRUD senhas e grupos
+-- ModNotes.bas          # CRUD notas
+-- ModBackup.bas         # Backup .lockzero
+-- ModTheme.bas          # Cores e tema
+-- ModLang.bas           # Multi-idioma PT/EN
|
+-- # CLASSES
+-- clsPasswordGroup.bas  # Modelo de grupo
+-- clsPasswordEntry.bas  # Modelo de senha
+-- clsNoteEntry.bas      # Modelo de nota
|
+-- Files/                # Assets
    +-- ic_*.png          # Icones (futuro)
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
Public Sub EndSession()
Public Sub IsSessionActive() As Boolean
Public Sub GetPassphrase() As String  'Retorna frase desofuscada
Public Sub Touch()  'Renova timeout

'Configuracao:
Private SESSION_TIMEOUT As Int = 300000  '5 minutos em ms

'Seguranca:
' - Frase armazenada com XOR usando salt aleatorio
' - Timeout automatico por inatividade
' - Limpeza de memoria ao encerrar
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

Internacionalizacao PT/EN.

```basic
Public Sub T(key) As String  'Retorna texto traduzido
Public Sub SetLanguage(lang)  '"pt" ou "en"
Public Sub GetLanguage() As String

'Chaves principais:
passwords, cards, documents, notes, backup
save, cancel, delete, edit, confirm
session_expired, wrong_passphrase, success, error
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
Public TitleEnc As String      'Criptografado
Public ContentEnc As String    'Criptografado
Public IsFavorite As Boolean
Public CreatedAt As Long
Public UpdatedAt As Long

'Metodos:
Public Sub Initialize()
Public Sub EncryptTitle(passphrase, title)
Public Sub EncryptContent(passphrase, content)
Public Sub GetDecryptedTitle(passphrase) As String
Public Sub GetDecryptedContent(passphrase) As String
```

---

## Paginas B4xPages

### B4XMainPage.bas - Home

- Lista vertical de categorias (Senhas, Cartoes, Documentos, Notas)
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

- Titulo breadcrumb: "Senhas > NomeGrupo"
- Header com titulo "SENHAS" e botao +
- Lista de senhas com favorito, nome, username
- Botao copiar senha (limpa clipboard em 30s)
- Click: detalhes / Long click: opcoes

### PagePasswordEdit.bas - Formulario

- Campos: Nome, URL, Username, Senha, Notas
- Botao mostrar/esconder senha
- Botao gerar senha aleatoria
- Checkbox favorito
- Scroll automatico quando teclado abre

### PageNotesList.bas / PageNoteEdit.bas

- Mesma estrutura das senhas
- Campos: Titulo, Conteudo, Favorito

### PageBackup.bas

- Info do ultimo backup
- Botao "Criar Backup" (pede frase)
- Botao "Restaurar Backup" (pede frase)
- Botao "Testar Backup" (valida sem importar)
- Dica: usar oracao, musica ou frase conhecida

### PageOnboarding.bas

- 3 telas simples:
  1. Welcome - apresentacao
  2. Warning - aviso zero recuperacao
  3. Complete - pronto para usar
- Checkbox obrigatorio "Entendi os riscos"

---

## Seguranca

### Criptografia

| Dado | Algoritmo | Chave |
|------|-----------|-------|
| Senhas | AES-256 | SHA256(frase + salt) |
| Usernames | AES-256 | SHA256(frase + salt) |
| Notas | AES-256 | SHA256(frase + salt) |
| TestValue | AES-256 | SHA256(frase + salt) |
| Backup | AES-256 | SHA256(frase backup) |

### Validacao de Frase

1. Grupo tem `TestValue` = "LOCKZERO" criptografado com a frase
2. Ao abrir grupo, usuario digita frase
3. Sistema tenta descriptografar TestValue
4. Se resultado = "LOCKZERO", frase correta
5. Se nao, incrementa contador de falhas

### Protecao Brute Force

| Tentativas | Delay |
|------------|-------|
| 1-5 | 0 |
| 6-8 | 60 segundos |
| 9-10 | 300 segundos (5 min) |
| 11+ | +300s cada |

### Sessao em Memoria

- Frase armazenada com XOR (ofuscada)
- Salt aleatorio gerado por sessao
- Timeout de 5 minutos de inatividade
- Touch() renova timeout a cada interacao
- Limpeza completa ao encerrar

### Clipboard

- Senha copiada limpa automaticamente em 30s
- Timer visivel para usuario

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
| Cartoes | 3 |
| Notas | 5 |
| Documentos | 2 |
| Wi-Fi | 3 |
| Backup .lockzero | Sim |
| Gerador senhas | Basico |
| OCR Scanner | Nao |
| Import/Export CSV | Nao |

### PREMIUM (futuro)

- Itens ilimitados em todas categorias
- OCR Scanner (cartoes, documentos)
- Import/Export CSV
- Gerador avancado (memoravel, passphrase)

---

## Roadmap

### v0.1.0 - MVP (atual)

- [x] Cofre de senhas com grupos
- [x] Notas seguras
- [x] Criptografia AES-256
- [x] Sessao com timeout
- [x] Brute force protection
- [x] Backup .lockzero
- [x] Multi-idioma PT/EN
- [x] Tema dark

### v0.2.0 - Cartoes

- [ ] clsCardEntry + ModCards
- [ ] PageCards, PageCardEdit
- [ ] Deteccao de bandeira (Visa, Master, etc)
- [ ] Mascara de exibicao (**** 1234)

### v0.3.0 - Documentos

- [ ] clsDocumentEntry + ModDocuments
- [ ] PageDocuments, PageDocumentEdit
- [ ] Galeria criptografada
- [ ] Camera para captura

### v0.4.0 - Wi-Fi + Gerador

- [ ] clsWifiEntry + ModWifi
- [ ] PageWifi, PageWifiEdit
- [ ] Gerador de senhas completo
- [ ] Medidor de forca

### v0.5.0 - Scanner OCR

- [ ] ML Kit offline
- [ ] Scanner de cartoes
- [ ] Scanner de documentos
- [ ] QR Code Wi-Fi

### v0.6.0 - Import/Export

- [ ] Export CSV (Chrome, Edge, Firefox)
- [ ] Import CSV
- [ ] Export JSON

### v0.7.0 - Configuracoes

- [ ] PageSettings completo
- [ ] PIN de acesso
- [ ] Biometria
- [ ] FLAG_SECURE

### v1.0.0 - Publicacao

- [ ] Testes de seguranca
- [ ] Google Play Store
- [ ] Documentacao usuario

---

## Referencias

- **Dominio:** lockzero.pro
- **Familia:** Lockseed Products
- **Base de codigo:** LockSeed (modulo senhas)

---

**Ultima atualizacao:** 2025-12-26
