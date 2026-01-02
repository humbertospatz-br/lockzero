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
- [ ] Auto-lock em background (Activity_Pause)
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

**Ultima atualizacao:** 2026-01-02
