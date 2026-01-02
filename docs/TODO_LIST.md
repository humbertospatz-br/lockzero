# TODO LIST - LOCKZERO

> **"Lock and ZERO worries - Guarde suas informacoes e ZERO preocupacao"**

**Arquivo:** TODO_LIST.md
**Plataforma:** B4xPages (Android primeiro, iOS futuro)
**Regras:**
- Tarefas urgentes/criticas no TOPO
- Ao concluir -> mover para HISTORICO.md
- Sempre incluir data de insercao

---

## CONCLUIDO - Modulo de Notas Fase 1 (2025-12-30)

> **Origem:** SPEC_NOTAS.md - Grupos de notas com tipos (texto/lista)
> **Status:** CONCLUIDO

### Implementado

**Classes:**
- [x] [2025-12-30] `clsNoteGroup.bas` - Grupos seguros (criptografados) ou abertos
- [x] [2025-12-30] `clsNoteEntry.bas` - NoteType (text/list), Items[], SortOrder

**Modulos:**
- [x] [2025-12-30] `ModNotes.bas` - CRUD grupos + notas com ordenacao

**Paginas:**
- [x] [2025-12-30] `PageNotesGroups.bas` - Lista grupos com cadeado, criar/editar/excluir
- [x] [2025-12-30] `PageNotesList.bas` - Lista notas com icone tipo, preview por tipo
- [x] [2025-12-30] `PageNoteEdit.bas` - Modo texto E modo lista (checkboxes)

**Textos:**
- [x] [2025-12-30] `ModLang.bas` - Todos textos PT/EN para notas

### Funcionalidades

- Grupos SEGUROS (com cadeado) - notas criptografadas AES-256
- Grupos ABERTOS (sem cadeado) - notas em texto claro
- Notas tipo TEXTO - titulo + conteudo multilinhas
- Notas tipo LISTA - checkboxes com adicionar/editar/remover itens
- Preview na lista: texto mostra conteudo, lista mostra "X de Y itens"
- Dialog para escolher tipo ao criar nova nota

### Pendente Fase 2 (Futuro)

- [ ] Drag & drop para reordenacao manual
- [ ] Exportacao/Share de notas

---

## CORRECOES - Modulo de Notas (2025-12-30)

> **Origem:** Feedback de testes do usuario
> **Status:** EM ANDAMENTO

### UI/UX Corrigidos

- [x] [2025-12-30] **InputType CAP_WORDS** - Capitaliza automaticamente nomes/titulos
  - `edtGroupName.InputType = Bit.Or(1, 8192)` em PageNotesGroups
  - `edtItemText.InputType = Bit.Or(1, 8192)` em PageNoteEdit
  - `edtTitle.InputType = Bit.Or(1, 8192)` em PageNoteEdit
  - **Regra anotada em CLAUDE.md secao 6**

- [x] [2025-12-30] **Botao + circular** - Padrao Label com SetColorAndBorder
  - PageNotesList: lblAdd (40x40dip, raio 20dip)
  - PageNoteEdit: lblAddItem (44x44dip, raio 22dip)
  - **Regra anotada em CLAUDE.md secao 7**

- [x] [2025-12-30] **Emojis surrogate pairs** - Para Android
  - 📝 = `Chr(0xD83D) & Chr(0xDCDD)`
  - 🔒 = `Chr(0xD83D) & Chr(0xDD12)`
  - Corrigido em clsNoteGroup, PageNotesGroups, PageNotesList
  - **Regra anotada em CLAUDE.md secao 8**

- [x] [2025-12-30] **Emoji automatico por tipo** - Sem campo editavel
  - Grupo Seguro: 🔒 cadeado
  - Grupo Aberto: 📝 nota
  - Removido edtGroupIcon do dialog

- [x] [2025-12-30] **Navegar apos criar grupo** - Abre automaticamente
  - ProcessAddGroup chama NavigateToGroup(g.Id) apos salvar

- [x] [2025-12-30] **Mostrar/esconder campo frase** - Ao alternar checkbox
  - chkSecure_CheckedChange mostra/esconde lblPhraseLabel e pnlPhraseArea
  - Limpa edtPassphrase se desmarcar seguro

- [x] [2025-12-30] **Breadcrumb no header** - Padrao "Categoria → Nome"
  - PageNotesList: "Notas → NomeGrupo"
  - **Regra anotada em CLAUDE.md secao 5**

### Erros Corrigidos

- [x] [2025-12-30] **FromMap items** - Trata String ou List
  - clsNoteEntry.FromMap converte List para JSON string se necessario

### Pendente

- [x] [2025-12-30] **Arquivo corrompido** - lockzero_notes.json com erro "Simple value expected"
  - Usuario limpou dados do app

---

## AUDITORIA DE SEGURANCA - Analise Profunda (2026-01-02)

> **Origem:** Analise completa do codigo por Claude
> **Status:** PENDENTE
> **Prioridade:** CRITICA - Resolver antes de lancar

---

### CRITICO - Risco de Perda de Dados

- [ ] [2026-01-02] **Salvar com transacao atomica** - Evitar corrupcao de arquivo
  - **Problema:** `File.WriteString` sobrescreve arquivo diretamente
  - Se app crashar durante save: arquivo corrompido/truncado
  - **Solucao:** Escrever em arquivo temporario, depois renomear (atomico)
  ```
  1. Salvar em "lockzero_passwords.json.tmp"
  2. Se sucesso: File.Rename para "lockzero_passwords.json"
  3. Se falha: arquivo original intacto
  ```
  - Aplicar em: ModPasswords.SaveToDisk, ModNotes.SaveData

- [ ] [2026-01-02] **Backup automatico antes de salvar** - Segunda linha de defesa
  - Antes de sobrescrever, copiar para ".bak"
  - Manter ultimos 3 backups automaticos
  - Se corrupcao detectada: tentar restaurar do .bak

- [ ] [2026-01-02] **Validar JSON antes de carregar** - Evitar dados vazios
  - **Problema:** Se JSON invalido, LoadFromDisk retorna vazio silenciosamente
  - **Solucao:** Verificar estrutura minima antes de aceitar
  - Se invalido: tentar .bak, avisar usuario

---

### CRITICO - Vulnerabilidades de Seguranca

- [ ] [2026-01-02] **PIN criptografado em vez de Base64** - URGENTE
  - **Problema:** PIN armazenado em Base64 (decodificavel trivialmente)
  - `Base64.Decode("MTIzNDU2") = "123456"` (qualquer um consegue)
  - **Solucao:** Usar PBKDF2 + salt (igual aos grupos)
  ```
  SavePIN(pin):
    salt = GenerateRandomSalt()
    hashedPIN = PBKDF2(pin, salt, 100000)
    Salvar: {salt, hashedPIN}

  ValidatePIN(inputPin):
    hashedInput = PBKDF2(inputPin, savedSalt, 100000)
    Return hashedInput == savedHashedPIN
  ```

- [ ] [2026-01-02] **IV aleatorio por operacao** - Corrigir criptografia
  - **Problema:** IV derivado de MD5(reverse(frase)) - sempre igual
  - Mesmo plaintext + mesma frase = mesmo ciphertext (detectavel)
  - **Solucao:** Gerar IV aleatorio, salvar junto com ciphertext
  ```
  Encrypt():
    iv = RandomBytes(16)
    ciphertext = AES-CBC(plaintext, key, iv)
    Return Base64(iv + ciphertext)  'IV concatenado
  ```

- [ ] [2026-01-02] **Adicionar HMAC para integridade** - Detectar alteracao
  - **Problema:** Ciphertext pode ser modificado sem deteccao
  - **Solucao:** Encrypt-then-MAC
  ```
  Encrypt():
    ciphertext = AES(plaintext)
    mac = HMAC-SHA256(key, ciphertext)
    Return ciphertext + mac

  Decrypt():
    Verificar MAC antes de descriptografar
    Se MAC invalido: rejeitar
  ```

---

### ALTO - Protecao de Sessao

- [ ] [2026-01-02] **Auto-lock quando app vai para background**
  - **Problema:** Sessao permanece ativa mesmo com app minimizado
  - **Solucao:** Em Activity_Pause, encerrar ou pausar sessao
  - Opcao: Configuracao "Bloquear ao minimizar" (on/off)

- [ ] [2026-01-02] **Limpar clipboard automaticamente**
  - **Problema:** Senha copiada permanece no clipboard indefinidamente
  - **Solucao:** Timer para limpar apos X segundos (configuravel)
  - Padrao: 30 segundos

- [ ] [2026-01-02] **FLAG_SECURE para prevenir screenshots**
  - **Problema:** Usuario pode tirar screenshot com senhas visiveis
  - **Solucao:** `Activity.Window.addFlags(FLAG_SECURE)`
  - Impede screenshots e gravacao de tela

---

### MEDIO - Integridade de Backup

- [ ] [2026-01-02] **Checksum externo ao backup**
  - **Problema:** Checksum SHA-256 esta DENTRO do arquivo criptografado
  - Se backup corrompido em disco, checksum tambem corrompido
  - **Solucao:** Salvar checksum em arquivo separado ou no nome
  ```
  lockzero_backup_20260102_143000.lockzero
  lockzero_backup_20260102_143000.sha256  (checksum separado)
  ```

- [ ] [2026-01-02] **Verificar integridade periodica dos dados**
  - Ao abrir app: verificar se arquivos JSON sao validos
  - Se corrupcao detectada: avisar usuario, oferecer restaurar backup

---

### MEDIO - Campos Faltantes nas Classes

- [ ] [2026-01-02] **clsPasswordEntry - Adicionar campos uteis**
  - `ExpiresAt` - Para senhas temporarias/tokens
  - `PasswordHistory` - Ultimas 3-5 senhas anteriores
  - `StrengthScore` - Cache da analise de forca
  - `Tags` - Para busca/organizacao

- [ ] [2026-01-02] **clsPasswordGroup - Adicionar campos**
  - `SortOrder` - Ordenacao manual de grupos
  - `IsArchived` - Grupos antigos/inativos

---

### BAIXO - Melhorias de Seguranca

- [ ] [2026-01-02] **Criptografar arquivo de tentativas**
  - `lockzero_attempts.json` revela quantas tentativas por grupo
  - Nao e critico, mas viola principio de defesa em profundidade

- [ ] [2026-01-02] **Ofuscar settings sensiveis**
  - `lockzero_settings.dat` em texto claro
  - Opcoes sensiveis (useBiometric, sessionTimeout) visiveis

- [ ] [2026-01-02] **Detectar root/jailbreak**
  - Avisar usuario se dispositivo comprometido
  - Nao bloquear, apenas informar risco

---

### DOCUMENTACAO - Responsabilidade Legal

- [ ] [2026-01-02] **Termos de Uso claros**
  - "Voce e responsavel por manter sua frase-senha segura"
  - "Sem a frase, dados NAO podem ser recuperados"
  - "LockZero nao armazena sua frase em nenhum servidor"

- [ ] [2026-01-02] **Aviso no Onboarding**
  - Explicar claramente: "Se perder a frase, perde os dados"
  - Forcar usuario a confirmar que entendeu
  - Checkbox: "Entendo que sou responsavel pela minha frase"

- [ ] [2026-01-02] **Lembrete periodico de backup**
  - A cada X dias sem backup: notificar usuario
  - "Ultimo backup: 15 dias atras. Fazer backup agora?"

---

## NOVOS REQUISITOS - Backup e Animacoes (2026-01-02)

> **Origem:** Solicitacao do usuario
> **Status:** PENDENTE

### Backup - Melhorias

- [ ] [2026-01-02] **Data de alteracao em cada item** - Cada entrada (senha, nota, etc) deve ter updatedAt no backup
  - Verificar se clsPasswordEntry, clsNoteEntry ja tem updatedAt
  - Garantir que updatedAt e atualizado ao editar

- [ ] [2026-01-02] **Importacao inteligente** - Perguntar ao usuario antes de importar
  - Opcao 1: "Importar apenas itens mais novos" (comparar updatedAt)
  - Opcao 2: "Substituir todos" (comportamento atual)
  - Dialog com escolha antes de processar

- [ ] [2026-01-02] **Validacao de integridade do backup** - Detectar alteracao por terceiros
  - Adicionar hash/checksum do conteudo no arquivo .lockzero
  - Ao importar, recalcular hash e comparar
  - Se diferente: "Backup pode ter sido alterado. Importar mesmo assim?"

### Animacoes de Transicao

- [ ] [2026-01-02] **4 animacoes aleatorias entre telas**
  - Slide left/right
  - Fade in/out
  - Zoom in/out
  - Slide up/down
  - Escolher aleatoriamente a cada navegacao
  - Pesquisar: B4XPages transitions, Activity animations

---

## PARA AMANHA - Refinamentos UI (2025-12-31)

> **Origem:** Feedback de testes do usuario
> **Status:** PENDENTE

### Tarefas

- [ ] [2025-12-30] **Icones menores e mais nitidos** - Lixeira e Compartilhar
  - Icones atuais (ic_menu_delete, ic_menu_share) parecem borrados
  - Reduzir tamanho dos ImageViews (de 44dip para ~32dip)
  - Pesquisar drawables Android mais nitidos ou usar PNG customizados
  - Alternativa: usar icones de biblioteca Material Design

- [ ] [2025-12-30] **Animacoes de transicao entre telas**
  - Transicoes atuais muito rapidas, causam "susto"
  - B4A suporta animacoes via B4XPages ou Activity transitions
  - Pesquisar: `B4XPages.ShowPageAndRemovePreviousPages` com animacao
  - Opcoes: slide left/right, fade in/out, zoom
  - Referencia: https://www.b4x.com/android/forum/threads/b4x-b4xpages-cross-platform-pages-framework.115993/

---

## EM ANDAMENTO - Correcoes PageNoteEdit (2025-12-30)

> **Origem:** Feedback de testes do usuario
> **Status:** PARCIALMENTE CONCLUIDO

### Tarefas

- [ ] [2025-12-30] **Checkbox borda visivel** - Todos checkboxes precisam borda de outra cor
  - chkFavorite em PageNoteEdit
  - chkSecure em PageNotesGroups
  - chkItem em itens de lista
  - **Problema:** Dificil de visualizar sem contraste

- [ ] [2025-12-30] **Breadcrumb completo** - "Nota → NomeGrupo → Novo Texto" ou "Nova Lista"
  - Novo: "Nota → Aberto → Novo Texto" / "Nova Lista"
  - Editar: "Nota → Aberto → Editar"
  - Atualizar PageNoteEdit.B4XPage_Appear e lblHeaderTitle

- [ ] [2025-12-30] **Botao Cancelar** - Adicionar ao lado do Salvar no header
  - Padrao: Cancelar (transparente) + Salvar (HomeIconBg)

- [ ] [2025-12-30] **Botao + com texto** - "(Incluir Item)" ao lado
  - Manter botao circular + adicionar label explicativo

- [ ] [2025-12-30] **Checkbox Favorito** - Reposicionar abaixo do conteudo
  - Modo texto: abaixo do campo de conteudo (nao no meio)
  - Modo lista: abaixo da lista de itens

- [ ] [2025-12-30] **Campo conteudo maior** - Aumentar altura do edtContent
  - Altura atual: 200dip
  - Aumentar para 300dip ou mais

- [ ] [2025-12-30] **Titulo correto** - "Novo Texto" em vez de "Nova Nota"
  - Adicionar textos em ModLang: new_text, new_list, edit_note

---

## EM ANDAMENTO - PIN e Biometria (2025-12-29)

> **Origem:** Seguranca adicional para operacoes sensiveis
> **Status:** EM IMPLEMENTACAO
> **Referencia:** LockSeed (BiometricManager.bas, ModSecurity.bas)

### DEFINICOES

- **Biometria tem PREFERENCIA sobre PIN** (PIN e fallback)
- **PIN obrigatorio se configurado** (senao, nao pede nada)
- **PIN:** 4 a 8 digitos
- **BiometricManager.bas:** JA EXISTE no projeto

### FLUXO DE AUTENTICACAO

```
INICIAR APP:
├─ Tem PIN configurado?
│  ├─ NAO → Entrar direto (sem PIN)
│  └─ SIM → Autenticar:
│           ├─ Biometria habilitada + disponivel? → Pedir biometria
│           │   └─ Falhou? → Fallback para PIN
│           └─ Sem biometria → Pedir PIN
│               └─ PIN correto? → Entrar no app

OPERACAO SENSIVEL (deletar grupo/senha):
├─ Sessao ativa?
│  ├─ SIM + Biometria habilitada → Pedir biometria (ou PIN fallback)
│  ├─ SIM + Sem biometria → Confirmar com dialog simples
│  └─ NAO → Pedir frase-senha completa
```

### TAREFAS - FASE 1: Estrutura Base

- [x] [2025-12-29] `BiometricManager.bas` - JA EXISTE no projeto
- [x] [2025-12-29] Registrar BiometricManager em lockzero.b4a (Module22)
- [x] [2025-12-29] Adicionar em ModSecurity.bas:
  - `PIN_FILE = "lockzero_pin.dat"`
  - `HasPIN() As Boolean`
  - `SavePIN(pin As String)`
  - `ValidatePIN(inputPin As String) As Boolean`
  - `RemovePIN()`
  - `GetUseBiometric() As Boolean`
  - `SetUseBiometric(use As Boolean)`
- [x] [2025-12-29] Adicionar textos em ModLang.bas:
  - `pin_title`, `pin_enter`, `pin_create`, `pin_confirm`
  - `pin_wrong`, `pin_removed`, `pin_saved`
  - `biometric_title`, `biometric_prompt`, `biometric_or_pin`

### TAREFAS - FASE 2: Tela de Configuracoes

- [ ] [2025-12-29] PageSettings - Implementar fluxo criar PIN (digitar 2x, 4-8 digitos)
- [ ] [2025-12-29] PageSettings - Implementar fluxo remover PIN (pedir PIN atual)
- [ ] [2025-12-29] PageSettings - Toggle biometria (so aparece se PIN configurado)

### TAREFAS - FASE 3: Inicializacao do App

- [x] [2025-12-29] B4XMainPage - Verificar PIN ao iniciar (se configurado)
- [x] [2025-12-29] Dialog de autenticacao: biometria primeiro, PIN fallback
- [x] [2025-12-29] Bloquear app ate autenticar (pnlLock overlay)
- [x] [2025-12-29] **FIX BIOMETRIA**: Mover `Biometric.Initialize` de `Initialize` para `B4XPage_Created`
  - **Problema:** BiometricManager precisa do contexto da Activity que so existe apos B4XPage_Created
  - **Solucao:** Inicializar biometria em B4XPage_Created, nao em Initialize
  - **STATUS: TESTAR NA PROXIMA SESSAO** - Log adicionado para debug

### TAREFAS - FASE 4: Operacoes Sensiveis

- [ ] [2025-12-29] PagePasswords - Ao deletar grupo:
  - Se sessao ATIVA + biometria → pedir biometria
  - Se sessao INATIVA → pedir frase
- [ ] [2025-12-29] PagePasswordList - Ao deletar senha:
  - Se sessao ATIVA + biometria → pedir biometria
  - Se sessao INATIVA → pedir frase

---

## FUTURO - Troca de Frase-Senha (2025-12-29)

> **Origem:** Seguranca - permitir trocar frase comprometida
> **Status:** PLANEJAMENTO INICIAL
> **Prioridade:** MEDIA (apos PIN/Biometria)

### COMPLEXIDADE

A troca de frase envolve:
1. Verificar modo atual (frase unica vs por categoria)
2. Descriptografar TODOS os dados com frase antiga
3. Recriptografar TODOS os dados com frase nova
4. Atualizar TestValue de todos os grupos
5. Invalidar backups antigos (avisar usuario)
6. Forcar novo backup

### FLUXO PROPOSTO

```
TROCAR FRASE:
1. Pedir frase ATUAL (validar)
2. Pedir frase NOVA (2x para confirmar)
3. Validar forca da nova frase
4. AVISO: "Backups antigos serao invalidados. Deseja continuar?"
5. Processo de migracao:
   - Descriptografar todos os dados
   - Recriptografar com nova frase
   - Atualizar TestValue dos grupos
6. Forcar criacao de novo backup
7. Sucesso: "Frase alterada. Faca backup agora!"
```

### TAREFAS (a detalhar depois)

- [ ] PageSettings - Botao "Trocar frase-senha"
- [ ] ModPasswords - Funcao MigratePassphrase(oldPhrase, newPhrase)
- [ ] ModNotes - Funcao MigratePassphrase(oldPhrase, newPhrase)
- [ ] Fluxo completo com dialogs
- [ ] Teste extensivo (dados nao podem ser perdidos!)

---

## CONCLUIDO - Importacao CSV e Performance (2025-12-29)

> **Origem:** Importacao de senhas do Chrome/Edge/Safari + otimizacoes
> **Status:** CONCLUIDO

### Importacao CSV (Chrome, Edge, Safari, Firefox)
- [x] [2025-12-29] **PageImportCSV.bas** - Tela completa de importacao CSV
- [x] [2025-12-29] **Intent-filter para CSV** - App recebe arquivos .csv via compartilhamento
- [x] [2025-12-29] **Parser CSV** - Detecta colunas automaticamente (name, url, username, password, note)
- [x] [2025-12-29] **Selecao de grupo destino** - Escolher grupo existente ou criar novo
- [x] [2025-12-29] **Preview de entradas** - Lista todas entradas antes de importar
- [x] [2025-12-29] **Validacao de frase** - Pede frase-senha antes de importar
- [x] [2025-12-29] **Importacao em lote** - Importa todas entradas de uma vez
- [x] [2025-12-29] **Log de linhas ignoradas** - Mostra quais linhas tinham dados vazios

### Performance
- [x] [2025-12-29] **Cache de frase normalizada** - NormalizePassphrase chamada 1x por sessao
  - ModSession: NormalizedPhraseCache armazena frase normalizada
  - ModSecurity: EncryptWithNormalized e DecryptWithNormalized evitam recalculo
  - Resultado: Lista com 100 senhas chama Normalize 1x em vez de 100x

### Correcoes
- [x] [2025-12-29] **Intent duplicado** - Evita reprocessar mesmo arquivo no Activity_Resume
  - LastProcessedIntentUri guarda URI do ultimo intent processado

---

## CONCLUIDO - Backup e Import via Intent (2025-12-29)

> **Origem:** Implementacao completa do sistema de backup .lockzero
> **Status:** CONCLUIDO

### Implementado
- [x] [2025-12-29] **Extensao .lockzero** - Arquivos de backup com extensao propria
- [x] [2025-12-29] **Intent-filter** - App registrado para abrir arquivos .lockzero
- [x] [2025-12-29] **FileProvider** - Compartilhamento seguro de arquivos
- [x] [2025-12-29] **Import via WhatsApp** - Receber backup via mensageiros
- [x] [2025-12-29] **singleTask launchMode** - App abre em task separada
- [x] [2025-12-29] **ContentResolver** - Leitura de arquivos de outros apps
- [x] [2025-12-29] **Dialog de frase aumentado** - Mais espaco para nome do arquivo
- [x] [2025-12-29] **Textos traduzidos** - ModLang.T() em todas as mensagens
- [x] [2025-12-29] **Timer de sessao em PagePasswords** - Contador regressivo no header

### Documentacao
- [x] [2025-12-29] **UI_PATTERNS.md** - Guia de padronizacao de telas

---

## SESSAO E CONFIGURACOES v0.1.1 (2025-12-28)

> **Origem:** Melhorias de UX e Configuracoes
> **Status:** IMPLEMENTADO

### Implementado
- [x] [2025-12-28] **Timer de sessao no header** - Mostra contador regressivo MM:SS
  - Cor muda para amarelo quando < 60s
  - Clicavel para bloquear sessao manualmente
  - Implementado em PagePasswordList.bas e B4XMainPage.bas

- [x] [2025-12-28] **Modo de frase-senha** - Unica ou por categoria
  - ModSecurity: GetUseSinglePassphrase / SetUseSinglePassphrase
  - ModSession: StartSessionWithCategory, GetSessionCategoryName, NeedsPassphraseForCategory
  - Na Home mostra nome da categoria quando em modo multi-frase

- [x] [2025-12-28] **PageSettings.bas** - Tela completa de configuracoes
  - Idioma (PT/EN) com dialog de selecao
  - Timer (1, 2, 3 minutos)
  - Modo frase-senha (unica/por categoria)
  - PIN de acesso (checkbox + criar/remover)
  - Biometria (checkbox on/off)
  - Secao Sobre com versao

- [x] [2025-12-28] **Navegacao para Settings** - Menu lateral abre PageSettings

---

## SEGURANCA - MELHORIAS v0.1.1 (2025-12-28)

> **Origem:** Revisao de seguranca pre-lancamento
> **Prioridade:** ALTA - Implementar antes de ter usuarios

### ALTA PRIORIDADE (Seguranca Critica)

- [x] [2025-12-28] **PBKDF2** - Trocar SHA-256 simples por PBKDF2 (100.000 iteracoes)
  - Arquivo: `ModSecurity.bas`
  - Funcoes: `EncryptWithSalt`, `DecryptWithSalt`
  - Motivo: SHA-256 simples permite ~1M tentativas/segundo. PBKDF2 reduz para ~10/segundo
  - **IMPLEMENTADO** - DeriveKeyPBKDF2 com 100.000 iteracoes HMAC-SHA256

- [ ] [2025-12-28] **TestValue dinamico** - Usar hash do salt ao inves de "LOCKZERO" fixo
  - Arquivo: `clsPasswordGroup.bas`
  - Motivo: Known-plaintext attack - atacante sabe que descriptografado = "LOCKZERO"
  - Solucao: TestValue = Encrypt(frase, SHA256(salt)) → validar descriptografado = SHA256(salt)

- [ ] [2025-12-28] **Auto-lock em background** - Encerrar sessao quando app vai para segundo plano
  - Arquivo: `Main.bas` ou `Starter.bas`
  - Evento: `Activity_Pause` deve chamar `ModSession.EndSession` ou pausar timer
  - Motivo: Se usuario minimiza app, sessao deve expirar por seguranca

- [ ] [2025-12-28] **Confirmacao de exclusao** - Re-digitar frase para deletar grupo/senha
  - Arquivos: `PagePasswords.bas`, `PagePasswordList.bas`
  - Motivo: Operacoes destrutivas devem exigir confirmacao forte

### MEDIA PRIORIDADE (UX/Funcionalidade)

- [ ] [2025-12-28] **Contador de itens nos cards** - Mostrar quantidade em cada categoria da Home
  - Arquivo: `B4XMainPage.bas`
  - Exemplo: "Senhas (12)" ou badge com numero
  - Motivo: Usuario sabe rapidamente quantos itens tem

### DOCUMENTACAO (Ja implementado, precisa documentar)

- [x] [2025-12-28] **Sessao unica global** - Comportamento correto (uma frase por vez)
  - Ao trocar de grupo com frase diferente, sessao anterior encerra
  - Isso e seguranca, nao bug - documentar em SPEC

- [x] [2025-12-28] **Backup com versao** - Ja implementado em ModBackup.bas
  - `BACKUP_VERSION = 1` e `appVersion` ja existem no JSON
  - Verificacao na importacao ja existe

---

## CORRECOES UI - SESSAO 2025-12-28

> **Origem:** Feedback visual do usuario
> **Prioridade:** ALTA - Polimento antes de lancamento

### PageBackup - Localização
- [x] [2025-12-28] Usar ModLang.T() em todos os textos (sem hardcode)
  - Chaves adicionadas em ModLang.bas (backup_*)
  - PageBackup.bas atualizado

### PagePasswordEdit - Problemas
- [x] [2025-12-28] Botao Ver/Ocultar cortado - aumentado para 65dip
- [ ] [2025-12-28] Campo Nota fica abaixo do teclado - padding aumentado para 300dip
- [ ] [2025-12-28] Botao Cancelar sem contraste - mudar cor
- [ ] [2025-12-28] **NORMALIZAR** - TextSize usar Starter.FONT_*
- [ ] [2025-12-28] **NORMALIZAR** - Textos usar ModLang.T() (hints hardcoded)

### PageOnboarding - Textos
- [ ] [2025-12-28] Trocar "ZERO Assinatura" por "Sem mensalidades"
- [ ] [2025-12-28] Remover/mudar "Esqueceu sua senha..." (sem frase backup nao adianta)

### Home - Ajustes
- [ ] [2025-12-28] Slogan - adicionar traducao entre parenteses em outras linguas
- [ ] [2025-12-28] Botao "+" quadrado em vez de redondo

### NORMALIZACAO GLOBAL (novo)
- [x] [2025-12-28] PagePasswordEdit.bas - normalizar TextSize e textos
- [x] [2025-12-28] PageBackup.bas - normalizar TextSize
- [ ] [2025-12-28] PagePasswords.bas - verificar normalizacao
- [ ] [2025-12-28] PagePasswordList.bas - verificar normalizacao
- [ ] [2025-12-28] B4XMainPage.bas - verificar normalizacao

### IDIOMAS FUTUROS
- [ ] [2025-12-28] Adicionar suporte Espanhol (ES) em ModLang.bas
- [ ] [2025-12-28] Adicionar suporte Hebraico (HE) em ModLang.bas
- [ ] [2025-12-28] Slogan traduzido em parenteses para ES e HE

---

## PAGINAS INTERNAS - SESSAO 2025-12-27

> **Baseado em:** docs/LOCKZERO — UX DEFINITIONS.MD
> **Objetivo:** Aplicar cores da Home em todas as paginas internas

### Cores a Aplicar (mesmo da Home)
```
HOME_BG:    #1C3A6A  RGB(28, 58, 106)   - Fundo principal de TODAS as paginas
HEADER_BG:  #152F58  RGB(21, 47, 88)    - Headers internos
CARD_BG:    #47526E  RGB(71, 82, 110)   - Items de lista/cards
```

### Regras UX (do documento)
- Home sempre igual visualmente (sem indicadores de lock)
- Tap card → verifica sessao → abre pagina OU pede frase
- Brute force: "Temporarily locked" (sem timers visiveis)
- Senhas sempre ocultas por padrao
- Sem emojis, sem explicacoes longas
- Breadcrumb no header (Passwords > Work)

### Tarefas - Cores das Paginas
- [x] [2025-12-27] PagePasswords.bas - Fundo HomeBg, header HomeHeaderBg, items HomeCardBg
- [x] [2025-12-27] PagePasswordList.bas - Fundo HomeBg, header HomeHeaderBg, items HomeCardBg
- [x] [2025-12-27] PagePasswordEdit.bas - Fundo HomeBg, campos com bordas sutis
- [x] [2025-12-27] PageNotesList.bas - Fundo HomeBg, header HomeHeaderBg, items HomeCardBg
- [x] [2025-12-27] PageNoteEdit.bas - Fundo HomeBg, campos com bordas sutis
- [x] [2025-12-27] PageBackup.bas - Fundo HomeBg
- [x] [2025-12-27] PageOnboarding.bas - Fundo HomeBg

### Tarefas - Dialogs e Headers (2025-12-27)
- [x] [2025-12-27] Dialog Novo Grupo - Redesenhado com overlay customizado (nao usa B4XDialog)
- [x] [2025-12-27] Dialog Frase - Cor azul bebe removida, usa HomeHeaderBg
- [x] [2025-12-27] Dialog Frase - Botao olho para visualizar texto
- [x] [2025-12-27] Dialog Frase - Botao desbloquear menor (100dip)
- [x] [2025-12-27] Headers internos - Seta voltar + breadcrumb (Tipo > Grupo)
- [x] [2025-12-27] Botao + adicionar - Corrigido tamanho (40dip)
- [x] [2025-12-27] Menu lateral - Cores ajustadas (HomeBg, HomeHeaderBg)

### Tarefas - UX Refinamentos (2025-12-27 noite)
- [x] [2025-12-27] Botao olho "Ver/Ocultar" - trocado de unicode para texto multilingua
- [x] [2025-12-27] Botao "Desbloquear" truncado - aumentado para 114dip, fonte 12
- [x] [2025-12-27] PagePasswordEdit - Adicionado botao Cancelar
- [x] [2025-12-27] PagePasswordEdit - Removido botao gerar senha (desnecessario)
- [x] [2025-12-27] PageNoteEdit - Adicionado botao Cancelar + scroll melhorado
- [x] [2025-12-27] Botao "+" - Trocado de Button para Label (evita tema do sistema)
- [x] [2025-12-27] Home - Adicionada animacao pulse nos cards (efeito visual ao clicar)
- [x] [2025-12-27] Labels da Home - Microajuste alpha 90% para 85%, removido bold
- [ ] [2025-12-28] Botao "Ver" cortado no dialog de frase-senha - VERIFICAR

### Tarefas - Navegacao/UX (pendentes)
- [ ] [2025-12-27] Revisar fluxo: Home → Card tap → Sessao check → Pagina/Dialog
- [ ] [2025-12-27] Remover emojis de mensagens (se houver)
- [ ] [2025-12-27] Padronizar mensagens curtas e factuais

---

## NOVA HOME - SESSAO 2025-12-27 (CONCLUIDA)

> **Baseado em:** docs/LOCKZERO_HOME_DEFINITIONS.md

### Paleta de Cores da Home
```
HOME_BG:    #1C3A6A  RGB(28, 58, 106)   - Fundo principal
HEADER_BG:  #152F58  RGB(21, 47, 88)    - Header (mais escuro)
CARD_BG:    #2C4F80  RGB(44, 79, 128)   - Cards 2x2
ICON_BG:    #455A75  RGB(69, 90, 117)   - Fundo dos icones hexagonais
```

### Tarefas
- [x] [2025-12-27] Copiar icones para pasta Files do B4A
- [x] [2025-12-27] Atualizar ModTheme.bas com cores da Home (HomeBg, HomeHeaderBg, HomeCardBg, HomeIconBg)
- [x] [2025-12-27] Remodelar B4XMainPage - Header fixo com logo + titulo + menu
- [x] [2025-12-27] Implementar Grid 2x2 com cards (Senhas, Cartoes, Docs, Notas)
- [x] [2025-12-27] Posicionar icones a 42% da altura do card
- [x] [2025-12-27] Implementar rodape fixo com slogan e versao

### Especificacoes do Layout
- Header: 56dip altura, logo esquerda, menu ☰ direita
- Grid: margens 18-20dip, gap 14-16dip
- Card: cantos 12-16dip, icone a 42% altura
- Rodape: slogan + versao + status (Free/Premium)

---

## REDESIGN UX - SESSAO 2025-12-26

> **Consultoria UX aplicada** - App de seguranca deve ser SOBRIO

### Paleta de Cores Aprovada (Navy + Cinzas)
```
Primary:     RGB(10, 37, 64)    #0A2540  Navy profundo
Background:  RGB(12, 14, 18)    #0C0E12  Preto azulado
Surface:     RGB(22, 27, 34)    #161B22  Cards
Text:        RGB(230, 235, 240) #E6EBF0  Texto principal
Text Muted:  RGB(95, 110, 125)  #5F6E7D  Hints
Warning:     RGB(160, 110, 45)  #A06E2D  Amber escuro
Danger:      RGB(140, 45, 50)   #8C2D32  Vermelho escuro
```

### Tarefas do Redesign
- [x] [2025-12-26] Aplicar nova paleta em ModTheme.bas - FEITO (Navy + cinzas)
- [x] [2025-12-26] Habilitar ActionBar do sistema (#IncludeTitle: True) - FEITO
- [x] [2025-12-26] Configurar titulos das paginas - FEITO (B4XPages.SetTitle em cada pagina)
- [x] [2025-12-26] Categorias monocromaticas - FEITO (tons de cinza/navy)
- [x] [2025-12-26] Corrigir texto backup - FEITO ("use frase que ja conhece de cor")
- [x] [2025-12-26] Remover marrom das categorias - FEITO (CategoryDocument agora e cinza slate)

### Anteriores
- [x] [2025-12-26] Header B4X removido
- [x] [2025-12-26] Emojis trocados por Unicode basico
- [x] [2025-12-26] Verde removido do app

### Navegacao
- [ ] [2025-12-26] Ao entrar em grupo, mostrar nome no ActionBar
- [ ] [2025-12-26] Teclado cobre campo "Notas" - ajustar scroll

### Anteriores (concluidos)
- [x] [2025-12-26] Texto da dica frase-senha cortado no onboarding
- [x] [2025-12-26] Tela nao ajusta quando teclado sobe (PagePasswordEdit, PageNoteEdit)
- [x] [2025-12-26] Bloquear criacao de senha/grupo sem frase cadastrada

## IMPLEMENTADO SESSAO 2025-12-26

> **Seguranca e Protecao**

- [x] [2025-12-26] Headers removidos das paginas (usar header proprio)
- [x] [2025-12-26] TestValue por grupo ("LOCKZERO" criptografado para validar frase)
- [x] [2025-12-26] Frase ofuscada em memoria (XOR com salt aleatorio)
- [x] [2025-12-26] Brute force: 5 tent→1min, +3→5min, +2→+5min progressivo
- [x] [2025-12-26] Dialog criar grupo pede nome + frase
- [x] [2025-12-26] Dialog abrir grupo valida frase com TestValue
- [x] [2025-12-26] Regra rigida de fluxo: PLANEJAR→TODO_LIST→EXECUTAR→COMMIT

---

## MODULOS LACRADOS - NAO MODIFICAR

> **Codigo reutilizado do LockSeed - ja testado e funcional**

| Arquivo | Origem | Status |
|---------|--------|--------|
| ModSecurity.bas | LockSeed | LACRADO - AES-256 + Salt + Brute Force |
| Logica frase-senha | LockSeed | LACRADO - mesmo algoritmo |

**AVISO:** O algoritmo de frase-senha e IDENTICO ao LockSeed. NAO ALTERAR.

---

## LIMITES POR VERSAO (Proposta Monetizacao)

| Recurso | FREE | PREMIUM |
|---------|------|---------|
| Senhas | 15 | Ilimitado |
| Cartoes | 3 | Ilimitado |
| Notas | 5 | Ilimitado |
| Documentos | 2 | Ilimitado |
| Wi-Fi | 3 | Ilimitado |
| OCR Scanner | Nao | Sim |
| Import/Export CSV | Nao | Sim |
| Gerador | Basico | Completo |
| Backup .lockzero | Sim | Sim |

---

## VERSOES

| Versao | Data | Status |
|--------|------|--------|
| v0.1.0 | 2025-12-25 | Em desenvolvimento |

**Proxima versao:** v0.1.0 (MVP - Cofre de Senhas)

---

## FASE 1: ESTRUTURA BASE (CONCLUIDA)

### Projeto B4xPages
- [x] [2025-12-25] Configurar projeto lockzero.b4xp para B4xPages
- [x] [2025-12-25] Criar B4XMainPage.bas (pagina principal B4xPages)
- [x] [2025-12-25] Criar Starter.bas (service de inicializacao)
- [x] [2025-12-25] Adaptar ModSecurity.bas (criptografia AES-256 + salt + brute force)
- [x] [2025-12-25] Adaptar ModTheme.bas (tema claro/escuro)
- [x] [2025-12-25] Criar ModLang.bas (multi-lingua PT/EN)
- [x] [2025-12-25] Criar ModSession.bas (gerenciador de sessao)

### Autenticacao
- [x] [2025-12-25] Sistema de frase-senha
- [x] [2025-12-25] Temporizador de sessao (30s, 1min, 5min, 15min, 30min)
- [x] [2025-12-25] Auto-lock quando inativo
- [x] [2025-12-25] Tela de desbloqueio por frase

---

## FASE 2: COFRE DE SENHAS (CONCLUIDA)

### Estrutura de Dados
- [x] [2025-12-25] Adaptar clsPasswordEntry.bas (modelo de senha)
- [x] [2025-12-25] Adaptar clsPasswordGroup.bas (modelo de grupo + ProtectionType + Salt)
- [x] [2025-12-25] Adaptar ModPasswords.bas (CRUD senhas)

### Telas B4xPages
- [x] [2025-12-25] Dashboard com categorias (B4XMainPage)
- [x] [2025-12-25] PagePasswords.bas - Lista de grupos
- [x] [2025-12-25] PagePasswordList.bas - Lista de senhas do grupo
- [x] [2025-12-25] PagePasswordEdit.bas - Adicionar/editar senha

### Funcionalidades
- [x] [2025-12-25] CRUD completo de senhas
- [x] [2025-12-25] Busca por nome/URL/usuario
- [x] [2025-12-25] Copiar senha para clipboard (limpa apos 30s)
- [x] [2025-12-25] Mostrar/esconder senha
- [x] [2025-12-25] Favoritos/fixar senhas
- [ ] [2025-12-25] Detector de senhas fracas
- [ ] [2025-12-25] Detector de senhas duplicadas
- [ ] [2025-12-25] Historico de senhas anteriores (ao editar, guarda versao antiga)
- [ ] [2025-12-25] Ordenacao: nome, data criacao, ultimo uso, manual

---

## FASE 3: COFRE DE CARTOES (PENDENTE)

### Estrutura de Dados
- [ ] [2025-12-25] Criar clsCardEntry.bas (modelo de cartao)
- [ ] [2025-12-25] Criar ModCards.bas (CRUD cartoes)

### Estrutura clsCardEntry.bas
```
id: String
nickname: String          ' Ex: "Nubank Pessoal"
cardholderName: String    ' Nome impresso no cartao
cardNumber: String        ' Numero completo (criptografado)
expiryMonth: String       ' MM
expiryYear: String        ' YY ou YYYY
cvv: String               ' CVV (criptografado)
brand: String             ' visa, mastercard, elo, etc
type: String              ' credit, debit, both
color: String             ' Cor visual do cartao
bankName: String          ' Banco/instituicao
lastFourDigits: String    ' Para exibicao segura
createdAt: Long
updatedAt: Long
expiryAlert: Boolean      ' Alertar vencimento
```

### Tabela BIN - Deteccao de Bandeira
| Prefixo | Bandeira |
|---------|----------|
| 4 | Visa |
| 51-55, 2221-2720 | Mastercard |
| 34, 37 | American Express |
| 636368, 438935, 504175, 451416, 636297 | Elo |
| 606282, 3841 | Hipercard |
| 36, 38, 39 | Diners Club |
| 6011, 644-649, 65 | Discover |
| 35 | JCB |

### Telas B4xPages
- [ ] [2025-12-25] PageCards.bas - Lista de cartoes
- [ ] [2025-12-25] PageCardDetail.bas - Detalhes do cartao
- [ ] [2025-12-25] PageAddCard.bas - Adicionar/editar cartao

### Funcionalidades
- [ ] [2025-12-25] CRUD completo de cartoes
- [ ] [2025-12-25] Deteccao automatica de bandeira (Visa, Master, etc.)
- [ ] [2025-12-25] Exibicao segura (**** **** **** 1234)
- [ ] [2025-12-25] Alerta de vencimento
- [ ] [2025-12-25] Cor do cartao (visual, escolher ao criar)
- [ ] [2025-12-25] Campo banco/instituicao

---

## FASE 4: COFRE DE DOCUMENTOS (PENDENTE)

### Estrutura de Dados
- [ ] [2025-12-25] Criar clsDocumentEntry.bas (modelo de documento)
- [ ] [2025-12-25] Criar ModDocuments.bas (CRUD documentos)

### Telas B4xPages
- [ ] [2025-12-25] PageDocuments.bas - Lista de documentos
- [ ] [2025-12-25] PageDocumentDetail.bas - Visualizar documento
- [ ] [2025-12-25] PageAddDocument.bas - Adicionar documento (camera)

### Tipos de Documentos
- [ ] [2025-12-25] CPF
- [ ] [2025-12-25] RG
- [ ] [2025-12-25] CNH
- [ ] [2025-12-25] Passaporte
- [ ] [2025-12-25] Titulo de eleitor
- [ ] [2025-12-25] Outros

---

## FASE 5: NOTAS SEGURAS + WIFI (PARCIAL)

### Notas Seguras (CONCLUIDO)
- [x] [2025-12-25] Criar clsNoteEntry.bas (modelo de nota)
- [x] [2025-12-25] Criar ModNotes.bas (CRUD notas)
- [x] [2025-12-25] PageNotesList.bas - Lista de notas
- [x] [2025-12-25] PageNoteEdit.bas - Adicionar/editar nota
- [ ] [2025-12-25] Suporte a codigos 2FA/recuperacao
- [ ] [2025-12-25] Licencas de software
- [ ] [2025-12-25] PINs e PUKs

### Credenciais Wi-Fi (PENDENTE)
- [ ] [2025-12-25] Criar clsWifiEntry.bas (modelo wifi)
- [ ] [2025-12-25] Criar ModWifi.bas (CRUD wifi)
- [ ] [2025-12-25] PageWifi.bas - Lista de redes
- [ ] [2025-12-25] PageAddWifi.bas - Adicionar rede
- [ ] [2025-12-25] Leitura de QR Code Wi-Fi

### Estrutura clsWifiEntry.bas
```
id: String
ssid: String              ' Nome da rede
password: String          ' Senha (criptografada)
security: String          ' WPA, WPA2, WPA3, WEP, Open
location: String          ' Ex: "Casa", "Escritorio"
notes: String
createdAt: Long
updatedAt: Long
```

---

## FASE 6: OCR E SCANNER (PENDENTE)

### Integracao OCR
- [ ] [2025-12-25] Integrar ML Kit (offline) ou Tesseract
- [ ] [2025-12-25] Criar ModOCR.bas (processamento OCR)

### Scanners
- [ ] [2025-12-25] Scanner de cartoes de credito
- [ ] [2025-12-25] Scanner de documentos (CNH, RG, etc.)
- [ ] [2025-12-25] Scanner de URL (tela de login)
- [ ] [2025-12-25] Scanner de QR Code (wifi, generico)
- [ ] [2025-12-25] PageScanner.bas - Scanner universal

---

## FASE 7: GERADOR DE SENHAS (PENDENTE)

### Funcionalidades Basicas
- [ ] [2025-12-25] Criar ModGenerator.bas
- [ ] [2025-12-25] PageGenerator.bas - Tela do gerador
- [ ] [2025-12-25] Configuracoes: tamanho (8-128)
- [ ] [2025-12-25] Opcoes: maiusculas, minusculas, numeros, simbolos
- [ ] [2025-12-25] Excluir caracteres ambiguos (0, O, l, 1, I)
- [ ] [2025-12-25] Medidor de forca da senha
- [ ] [2025-12-25] Tempo estimado para quebrar
- [ ] [2025-12-25] Gerar -> Copiar ou Salvar direto

### Modos Avancados
- [ ] [2025-12-25] Modo "memoravel" (palavras pronunciaveis)
- [ ] [2025-12-25] Modo "PIN" (apenas numeros, 4-8 digitos)
- [ ] [2025-12-25] Modo "passphrase" (3-5 palavras separadas)
- [ ] [2025-12-25] Historico de senhas geradas (ultimas 10)

---

## FASE 8: IMPORT/EXPORT (PARCIAL)

### Exportar
- [ ] [2025-12-25] Exportar para CSV (Chrome, Edge, Safari)
- [ ] [2025-12-25] Exportar para JSON
- [x] [2025-12-25] Backup criptografado .lockzero

### Importar
- [x] [2025-12-29] Importar de CSV (Chrome, Edge, Safari, Firefox)
- [ ] [2025-12-25] Importar de JSON
- [x] [2025-12-25] Restaurar backup .lockzero

### Telas
- [x] [2025-12-25] PageBackup.bas (export/import .lockzero)
- [x] [2025-12-29] PageImportCSV.bas (importar CSV de navegadores)
- [ ] [2025-12-25] PageExport.bas (CSV/JSON)

### Formato CSV (Compatibilidade Navegadores)

**Header obrigatorio:**
```csv
name,url,username,password
```

**Exemplo:**
```csv
name,url,username,password
Google,https://google.com,email@gmail.com,minhasenha123
Facebook,https://facebook.com,usuario,senha456
```

**Navegadores compativeis:**
- Chrome: Configuracoes > Senhas > Importar/Exportar
- Edge: Configuracoes > Senhas > Importar/Exportar
- Safari: Preferencias > Senhas > Importar/Exportar
- Firefox: Configuracoes > Senhas > Importar/Exportar
- Opera/Brave: Mesmo processo (baseados em Chromium)

---

## FASE 9: CONFIGURACOES (EM PROGRESSO)

### Tela de Configuracoes
- [x] [2025-12-28] PageSettings.bas - CRIADO com todas opcoes
- [x] [2025-12-28] Selecao de idioma (PT/EN)
- [ ] [2025-12-25] Selecao de tema (claro/escuro) - aguardando implementacao tema claro
- [x] [2025-12-28] Tempo de sessao (1, 2, 3 minutos)
- [ ] [2025-12-25] Tempo de limpeza clipboard (15s, 30s, 1min, nunca)
- [ ] [2025-12-25] Bloqueio ao minimizar app (sim/nao)
- [x] [2025-12-28] PIN de acesso (checkbox + dialogs create/remove)
- [x] [2025-12-28] Biometria (checkbox on/off)
- [x] [2025-12-28] Modo frase-senha (unica ou por categoria)

### Seguranca Adicional
- [x] [2025-12-25] Delay progressivo por tentativas falhas
- [x] [2025-12-25] Contador de tentativas por grupo
- [ ] [2025-12-25] Prevenir screenshots (FLAG_SECURE)
- [ ] [2025-12-25] Detectar root/jailbreak
- [ ] [2025-12-25] Timeout biometrico (requer frase apos X horas)

---

## FASE 10: POLIMENTO E PUBLICACAO (PARCIAL)

### UX/UI
- [x] [2025-12-25] PageOnboarding.bas (primeiro uso + backup obrigatorio)
- [ ] [2025-12-25] Animacoes e transicoes
- [ ] [2025-12-25] Icones e assets finais
- [ ] [2025-12-25] Ajustes de usabilidade

### Testes
- [ ] [2025-12-25] Testes de seguranca
- [ ] [2025-12-25] Testes de performance
- [ ] [2025-12-25] Testes em multiplos dispositivos

### Publicacao
- [ ] [2025-12-25] Google Play Store (Android)
- [ ] [2025-12-25] Apple App Store (iOS - B4i)

---

## BACKLOG - POS-MVP

> **Funcionalidades para versoes futuras (apos v1.0)**

### Alta Prioridade (impacto na conversao)
- [ ] Onboarding tutorial interativo (3-4 telas)
- [ ] Indicador visual de forca da frase-senha
- [ ] Widget home (acesso rapido, mostra qtd itens)

### Media Prioridade (melhora experiencia)
- [ ] Icones personalizados por grupo/entrada
- [ ] Limpeza automatica de clipboard configuravel
- [ ] Ordenacao manual (arrastar itens)
- [ ] Busca global (todas categorias)

### Baixa Prioridade (diferenciacao)
- [ ] PIN de panico (mostra cofre vazio sob coacao)
- [ ] Modo disfarce (icone de calculadora/relogio)
- [ ] Compartilhamento seguro via QR temporario
- [ ] Tema personalizado (cores do usuario)

### NAO RECOMENDADO (quebra filosofia)
- ~~Backup em nuvem~~ - quebra filosofia 100% offline
- ~~Sincronizacao entre dispositivos~~ - adiciona complexidade e riscos

---

## ARQUIVOS IMPLEMENTADOS

### Modulos Core:
| Arquivo | Status | Descricao |
|---------|--------|-----------|
| Starter.bas | OK | Service de inicializacao |
| Main.bas | OK | Activity principal B4XPages |
| B4XMainPage.bas | OK | Dashboard + Unlock |
| ModSecurity.bas | OK | AES-256, salt, brute force |
| ModTheme.bas | OK | Tema claro/escuro |
| ModLang.bas | OK | Multi-lingua PT/EN |
| ModSession.bas | OK | Gerenciador de sessao |
| ModBackup.bas | OK | Export/Import .lockzero |
| ModPasswords.bas | OK | CRUD senhas/grupos |
| ModNotes.bas | OK | CRUD notas |

### Classes:
| Arquivo | Status | Descricao |
|---------|--------|-----------|
| clsPasswordGroup.bas | OK | Modelo grupo (+ ProtectionType, Salt) |
| clsPasswordEntry.bas | OK | Modelo senha |
| clsNoteEntry.bas | OK | Modelo nota |

### Paginas B4XPages:
| Arquivo | Status | Descricao |
|---------|--------|-----------|
| PagePasswords.bas | OK | Lista de grupos |
| PagePasswordList.bas | OK | Senhas do grupo |
| PagePasswordEdit.bas | OK | Criar/editar senha |
| PageBackup.bas | OK | Backup .lockzero |
| PageOnboarding.bas | OK | Primeiro uso |
| PageNotesList.bas | OK | Lista de notas |
| PageNoteEdit.bas | OK | Criar/editar nota |
| PageSettings.bas | OK | Configuracoes do app |

### Documentacao:
| Arquivo | Status | Descricao |
|---------|--------|-----------|
| CLAUDE.md | OK | Documento de sessao |
| LOCKZERO_SPEC.md | OK | Especificacao tecnica |
| DECISOES_ARQUITETURA.md | OK | Decisoes de seguranca |
| DICAS_B4A.md | OK | Dicas de desenvolvimento |

---

## DIFERENCIAIS DO LOCKZERO

1. **Zero Internet** - Nenhum dado trafega pela rede
2. **Zero Conhecimento** - Nem nos sabemos sua frase
3. **Zero Recuperacao** - Perdeu a frase, perdeu acesso (seguranca maxima)
4. **Zero Assinatura** - Pagamento unico ou freemium
5. **Multiplataforma** - Android e iOS (B4xPages)

---

## MODELO DE DADOS (Resumo)

### Categorias do Cofre
| Categoria | Classe | Modulo | Status |
|-----------|--------|--------|--------|
| Senhas | clsPasswordEntry | ModPasswords | OK |
| Cartoes | clsCardEntry | ModCards | Pendente |
| Documentos | clsDocumentEntry | ModDocuments | Pendente |
| Notas | clsNoteEntry | ModNotes | OK |
| Wi-Fi | clsWifiEntry | ModWifi | Pendente |

---

## REFERENCIAS

- **Dominio:** lockzero.pro
- **Familia:** Lockseed Products
- **Base de codigo:** LockSeed (testado e funcional)

---

**Status:**
- [ ] Pendente
- [~] Em andamento
- [x] Concluido
- [-] Cancelado

**Ultima atualizacao:** 2025-12-29
