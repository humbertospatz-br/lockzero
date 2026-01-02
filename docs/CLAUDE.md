# CLAUDE - DOCUMENTO DE SESSAO - LOCKZERO

**Versao:** 1.0
**Criado:** 2025-12-25
**Projeto:** LockZero - Gerenciador de Senhas Seguro
**Mote:** "Lock and ZERO worries - Guarde suas informacoes e ZERO preocupacao"

---

## CONFIGURACAO DO PROJETO

```
NOME_PROJETO: LockZero
STACK: B4xPages (B4A/B4i) + JSON
VERSAO_ATUAL: v0.1.0 (desenvolvimento)
DATA_INICIO: 2025-12-25
PLATAFORMA: Android (B4A) - futuro: iOS (B4i)
PATH_PROJETO: C:\Basic4a\lockzero\lockzero_VSC\lockzero\B4A
PATH_OLD: C:\Basic4a\lockzero\lockzero_VSC\lockzero_old
ORIGEM: Modulo extraido do LockSeed em 2025-12-09
```

---

## PRINCIPIO FUNDAMENTAL

> **"PENSE SIMPLES. NUNCA REMENDE. PENSE."**

Antes de escrever qualquer codigo ou fazer qualquer alteracao:
1. **PENSE** - Qual a solucao mais simples?
2. **NUNCA REMENDE** - Se o codigo esta ruim, refatore. Nao coloque patch em cima de patch.
3. **PENSE DE NOVO** - Ha uma forma ainda mais simples de fazer isso?

**Lembre-se:** Codigo simples > Codigo complexo. Sempre.

---

## REGRA RIGIDA DE FLUXO DE TRABALHO

> **⚠️ OBRIGATORIO - SEM EXCECOES ⚠️**
> **⚠️ NAO EXISTE MEMORIA ENTRE SESSOES - TODO_LIST.md E O BACKUP ⚠️**

O Claude pode compactar mensagens ou travar, perdendo contexto.
Para NUNCA perder trabalho, seguir este fluxo SEMPRE:

### 1. PLANEJAR
- Discutir com o usuario o que sera feito
- Entender requisitos e escopo
- Tirar duvidas ANTES de comecar

### 2. SALVAR EM TODO_LIST.md
- **ANTES** de implementar qualquer codigo
- Anotar TODAS as tarefas planejadas
- Cada tarefa deve ser clara e especifica
- Marcar status: `[ ]` pendente, `[x]` concluido

### 3. EXECUTAR
- Implementar tarefas uma a uma
- Marcar `[x]` em TODO_LIST.md ao concluir cada uma
- Se surgir nova tarefa, adicionar ao TODO_LIST.md primeiro

### 4. AGUARDAR FEEDBACK
- Usuario compila e testa
- Usuario reporta resultado
- NAO assumir que funcionou sem feedback

### 5. SALVAR EM TODO_LIST.md
- Atualizar status das tarefas
- Adicionar novas tarefas se necessario
- Manter historico de progresso

### 6. COMMITAR E PUSH
- Ao concluir um bloco de tarefas
- Ou quando o usuario pedir (@salvar)
- NUNCA deixar trabalho sem commit por muito tempo

**Por que?** Se o Claude travar ou perder contexto, o TODO_LIST.md tera o plano completo e o progresso salvo. O proximo Claude pode continuar de onde parou.

> **REGRA DE OURO:** PLANEJAR → SALVAR TODO_LIST → EXECUTAR → FEEDBACK → SALVAR TODO_LIST

---

## LEITURA OBRIGATORIA POR TIPO DE TAREFA

> **⚠️ ANTES DE PLANEJAR OU IMPLEMENTAR - LER ARQUIVOS OBRIGATORIOS ⚠️**

Dependendo do tipo de tarefa, o Claude DEVE ler os arquivos de padrao correspondentes ANTES de comecar qualquer planejamento ou implementacao.

### Matriz de Leitura Obrigatoria

| Tipo de Tarefa | Arquivos a Ler |
|----------------|----------------|
| **Nova Pagina/Tela** | `UI_PATTERNS.md` |
| **Novo Modulo (CRUD)** | `UI_PATTERNS.md`, modulo similar existente |
| **Nova Classe (cls*)** | Classe similar existente (ex: clsPasswordEntry) |
| **Modificar UI** | `UI_PATTERNS.md` |
| **Textos/Traducao** | `ModLang.bas` (ver padrao PT/EN) |
| **Cores/Tema** | `ModTheme.bas` |
| **Criptografia** | `ModSecurity.bas` |
| **Sessao** | `ModSession.bas` |
| **Especificacao de Feature** | `LOCKZERO_SPEC.md`, specs existentes |

### Arquivos de Padrao

| Arquivo | Conteudo |
|---------|----------|
| `docs/UI_PATTERNS.md` | Header, botoes, timer, dialogs, estrutura de pagina |
| `docs/LOCKZERO_SPEC.md` | Especificacao geral do app |
| `C:\Basic4a\docs\DICAS_B4A.md` | Dicas de desenvolvimento B4A (arquivo global) |
| `docs/DECISOES_ARQUITETURA.md` | Decisoes tecnicas do projeto |

### Exemplo de Uso

```
Usuario: "Crie uma nova pagina para gerenciar Cartoes"

Claude DEVE:
1. Ler docs/UI_PATTERNS.md
2. Ler uma pagina similar (PagePasswords.bas ou PageNotesGroups.bas)
3. Seguir EXATAMENTE o padrao documentado
4. Usar constantes Starter.FONT_*, Starter.HEIGHT_*
5. Usar ModLang.T() para textos
6. Usar ModTheme.* para cores
```

### Checklist Pre-Implementacao

Antes de criar qualquer arquivo novo:
- [ ] Li UI_PATTERNS.md?
- [ ] Li um modulo similar como referencia?
- [ ] Sei quais constantes usar (FONT, HEIGHT, MARGIN)?
- [ ] Sei quais textos adicionar no ModLang?
- [ ] Entendi a estrutura padrao de header/content/dialog?

**IMPORTANTE:** Se o Claude nao ler os arquivos obrigatorios ANTES de implementar, o codigo provavelmente estara fora do padrao e precisara ser refatorado.

---

## REGRAS OBRIGATORIAS DE CODIGO

> **⚠️ ANTES DE ESCREVER QUALQUER LINHA DE CODIGO ⚠️**

### 1. Tamanhos de Fonte - SEMPRE usar constantes

```
NUNCA: lblTitle.TextSize = 14
SEMPRE: lblTitle.TextSize = Starter.FONT_BODY
```

**Constantes disponiveis em Starter.bas:**
| Constante | Valor | Uso |
|-----------|-------|-----|
| `Starter.FONT_TITLE` | 22 | Titulos de pagina |
| `Starter.FONT_SUBTITLE` | 18 | Subtitulos, headers |
| `Starter.FONT_BODY` | 15 | Texto principal |
| `Starter.FONT_LABEL` | 13 | Labels de campo |
| `Starter.FONT_CAPTION` | 12 | Textos pequenos, hints |
| `Starter.FONT_BUTTON` | 14 | Texto de botoes |
| `Starter.FONT_INPUT` | 15 | Texto em campos |

### 2. Alturas - SEMPRE usar constantes

```
NUNCA: pnlHeader.Height = 56dip
SEMPRE: pnlHeader.Height = Starter.HEIGHT_HEADER
```

**Constantes disponiveis:**
| Constante | Valor | Uso |
|-----------|-------|-----|
| `Starter.HEIGHT_HEADER` | 56dip | Altura do header |
| `Starter.HEIGHT_BUTTON` | 48dip | Altura de botao |
| `Starter.HEIGHT_INPUT` | 48dip | Altura de EditText |
| `Starter.HEIGHT_ITEM` | 72dip | Item de lista |

### 3. Textos - SEMPRE usar ModLang.T()

```
NUNCA: lblTitle.Text = "Configuracoes"
SEMPRE: lblTitle.Text = ModLang.T("settings")
```

- Adicionar chave em LoadPortuguese E LoadEnglish
- Nunca deixar texto hardcoded no codigo

### 4. Cores - SEMPRE usar ModTheme.*

```
NUNCA: pnl.Color = Colors.RGB(28, 58, 106)
SEMPRE: pnl.Color = ModTheme.HomeBg
```

### 5. Headers - SEMPRE usar breadcrumb

```
NUNCA: lblTitle.Text = "Nome do Grupo"
SEMPRE: lblTitle.Text = ModLang.T("categoria") & " → " & nomeGrupo
```

**Exemplos:**
- Senhas: `"Senhas → Bancos"`
- Notas: `"Notas → Compras"`
- Cartoes: `"Cartões → Pessoais"`

### 6. Capitalize - InputType com CAP_WORDS

Para capitalizar primeira letra de cada palavra automaticamente, usar InputType:

```vb
NUNCA: Criar funcao Capitalize() manual
SEMPRE: edtCampo.InputType = Bit.Or(1, 8192)  'TEXT + CAP_WORDS
```

**Usar em:**
- Nome do grupo: `edtGroupName.InputType = Bit.Or(1, 8192)`
- Titulo da nota: `edtTitle.InputType = Bit.Or(1, 8192)`
- Itens de lista: `edtItemText.InputType = Bit.Or(1, 8192)`

**Outros InputTypes comuns:**
| Tipo | Codigo | Uso |
|------|--------|-----|
| TEXT | 1 | Texto normal |
| TEXT + CAP_WORDS | Bit.Or(1, 8192) | Capitaliza palavras |
| TEXT + PASSWORD | Bit.Or(1, 128) | Senha oculta |
| NUMBER | 2 | Apenas numeros |

### 7. Botao + circular (padrao para adicionar)

```vb
NUNCA: btnAdd com largura total
SEMPRE: Label circular com SetColorAndBorder
```

**Padrao:**
```vb
Dim lblAdd As Label
lblAdd.Initialize("lblAdd")
lblAdd.Text = "+"
lblAdd.TextSize = 26
lblAdd.Typeface = Typeface.DEFAULT_BOLD
lblAdd.Gravity = Gravity.CENTER
lblAdd.TextColor = Colors.White
pnlParent.AddView(lblAdd, x, y, 44dip, 44dip)

'Arredondar (circular)
Dim xvAdd As B4XView = lblAdd
xvAdd.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModTheme.HomeIconBg, 22dip)
```

### 8. Emojis para Android - Surrogate Pairs

Emojis acima de U+FFFF precisam de surrogate pairs no B4A:

```vb
NUNCA: Chr(0x1F4DD)  'NAO FUNCIONA no Android
SEMPRE: Chr(0xD83D) & Chr(0xDCDD)  'Surrogate pair
```

**Emojis comuns:**
| Emoji | Codepoint | Codigo B4A |
|-------|-----------|------------|
| 📝 | U+1F4DD | `Chr(0xD83D) & Chr(0xDCDD)` |
| 🔒 | U+1F512 | `Chr(0xD83D) & Chr(0xDD12)` |
| 🔓 | U+1F513 | `Chr(0xD83D) & Chr(0xDD13)` |

**Emojis BMP (funcionam normal):**
| Emoji | Codepoint | Codigo B4A |
|-------|-----------|------------|
| ☑ | U+2611 | `Chr(0x2611)` |
| ★ | U+2605 | `Chr(0x2605)` |
| ☰ | U+2630 | `Chr(0x2630)` |

### 9. Botao Cancelar - OBRIGATORIO ao lado de Salvar

```vb
NUNCA: Apenas botao "Salvar" sozinho
SEMPRE: Botao "Cancelar" + Botao "Salvar" lado a lado
```

**Padrao:**
```vb
'Cancelar (esquerda)
Dim btnCancel As Button
btnCancel.Initialize("btnCancel")
btnCancel.Text = ModLang.T("cancel")
btnCancel.Color = Colors.Transparent
btnCancel.TextColor = Colors.ARGB(200, 255, 255, 255)
pnlParent.AddView(btnCancel, margin, y, 100dip, 44dip)

'Salvar (direita)
Dim btnSave As Button
btnSave.Initialize("btnSave")
btnSave.Text = ModLang.T("save")
btnSave.Color = ModTheme.HomeIconBg
btnSave.TextColor = Colors.White
pnlParent.AddView(btnSave, width - margin - 100dip, y, 100dip, 44dip)
```

### 10. Fluxo de trabalho OBRIGATORIO

```
1. ANALISAR - Entender o problema/requisito
2. ATUALIZAR TODO_LIST - Anotar tarefas ANTES de implementar
3. IMPLEMENTAR - Executar as tarefas
4. AGUARDAR APROVACAO - Usuario testa e aprova
5. ATUALIZAR TODO_LIST - Marcar como concluido
6. ATUALIZAR HISTORICO.md - Registrar o que foi feito
```

**NUNCA** comecar a implementar sem antes atualizar o TODO_LIST.md

### 11. Checklist antes de salvar arquivo

- [ ] TextSize usa Starter.FONT_*?
- [ ] Heights usam Starter.HEIGHT_*?
- [ ] Textos usam ModLang.T()?
- [ ] Cores usam ModTheme.*?
- [ ] Header usa breadcrumb (Categoria → Nome)?
- [ ] Nomes/titulos usam Capitalize()?
- [ ] Botao + e circular (Label com SetColorAndBorder)?
- [ ] Emojis acima U+FFFF usam surrogate pairs?
- [ ] Tarefa esta marcada em TODO_LIST.md?

### 12. NAO dizer o obvio sobre compilacao

```
NUNCA: "Compile novamente e teste"
NUNCA: "Voce precisa recompilar o projeto"
NUNCA: "Pressione F5 para compilar"
```

**REGRA:** O usuario SABE que precisa compilar. Nao e possivel testar codigo novo sem compilar no B4A. Dizer isso e perda de tempo e insulto a inteligencia do usuario.

**O QUE FAZER:** Simplesmente terminar a alteracao e aguardar o feedback do teste. O usuario vai compilar automaticamente.

---

## DIRETRIZ DO HUMBERTO - LEI SUPREMA

> **"SE ALGUEM JA FEZ, EU TAMBEM FACO."**
> **"SE ALGUEM NUNCA FEZ, EU, SE PRECISAR, FACO."**

**Significado:** NAO sugerir que algo "nao e possivel" ou "e muito complexo" antes de pesquisar.
Se existe um exemplo funcionando, a solucao existe.
O Claude deve buscar referencias, exemplos e solucoes existentes ANTES de desistir.

---

## COMO RESOLVER PROBLEMAS

### Perguntas Obrigatorias ANTES de Alterar Codigo:

1. **Ja funcionava antes?**
   - QUANDO funcionava? Qual versao/commit?
   - O QUE foi inserido depois que quebrou?
   - Use `git log` e `git show` para comparar versoes

2. **O que mudou?**
   - Qual codigo foi adicionado/alterado?
   - A logica foi modificada do que estava funcionando?

3. **Estou deixando passar algo obvio?**
   - PARE. PENSE. ANALISE.
   - Releia o codigo atual vs original

### O Que NUNCA Fazer:

1. **NUNCA usar fallback/remendo como solucao**
2. **NUNCA sair mudando codigo sem entender**
3. **NUNCA adicionar complexidade desnecessaria**

---

## DESCRICAO DO PROJETO

### O que e o LockZero

O LockZero e um aplicativo mobile (B4A/B4X) para Android que:

1. **Gerencia senhas** de sites, cartoes, aplicativos, etc.
2. **Usa frase-senha pessoal** para criptografar todos os dados (AES-256)
3. **Sessao com timeout** configuravel (1-5 minutos)
4. **Funciona 100% offline** - sem internet, sem servidores, sem nuvem
5. **Organiza por grupos** (Bancos, Redes Sociais, E-mails, etc.)

### Filosofia de Seguranca

- Dados criptografados com AES-256
- Frase-senha NUNCA armazenada (apenas usada em memoria durante sessao)
- Sessao expira automaticamente
- Sem coleta de dados pessoais
- Sem envio de informacoes para terceiros
- 100% offline

---

## ESTRUTURA DO PROJETO

```
lockzero_VSC/
├── docs/
│   ├── CLAUDE.md              # Este arquivo
│   ├── TODO_LIST.md           # Tarefas pendentes
│   ├── HISTORICO.md           # Historico de trabalho
│   └── LOCKZERO_SPEC.md       # Especificacao tecnica completa
│
├── lockzero/
│   └── B4A/                   # Projeto Android (B4xPages)
│       ├── lockzero.b4a       # Projeto principal
│       ├── Starter.bas        # Service de inicializacao
│       ├── B4XMainPage.bas    # Pagina principal B4xPages
│       │
│       ├── # PAGES (B4xPages)
│       ├── PageHome.bas       # Dashboard principal
│       ├── PagePasswords.bas  # Lista de senhas
│       ├── PageCards.bas      # Lista de cartoes
│       ├── PageDocuments.bas  # Lista de documentos
│       ├── PageNotes.bas      # Lista de notas
│       ├── PageWifi.bas       # Lista de redes wifi
│       ├── PageSettings.bas   # Configuracoes
│       ├── PageGenerator.bas  # Gerador de senhas
│       ├── PageScanner.bas    # Scanner OCR
│       │
│       ├── # CLASSES
│       ├── clsPasswordEntry.bas   # Modelo de senha
│       ├── clsPasswordGroup.bas   # Modelo de grupo
│       ├── clsCardEntry.bas       # Modelo de cartao
│       ├── clsDocumentEntry.bas   # Modelo de documento
│       ├── clsNoteEntry.bas       # Modelo de nota
│       ├── clsWifiEntry.bas       # Modelo de wifi
│       │
│       ├── # MODULOS
│       ├── ModPasswords.bas   # CRUD de senhas
│       ├── ModCards.bas       # CRUD de cartoes
│       ├── ModSecurity.bas    # Criptografia AES-256
│       ├── ModSession.bas     # Gerenciador de sessao
│       ├── ModTheme.bas       # Tema claro/escuro
│       ├── ModLang.bas        # Multi-lingua PT/EN
│       ├── ModGenerator.bas   # Gerador de senhas
│       │
│       └── Files/             # Assets do app
│
└── lockzero_old/              # Codigo legado (7 arquivos para referencia)
```

---

## FUNCIONALIDADES EXISTENTES (do LockSeed)

### Implementadas:
- [x] CRUD de grupos de senhas
- [x] CRUD de entradas de senha
- [x] Criptografia AES-256
- [x] Sessao com timeout configuravel (1-5 min)
- [x] Copiar senha para clipboard
- [x] Mostrar/esconder senha

### A Implementar:
- [ ] Tela inicial (Main)
- [ ] Configuracoes (idioma, tema, timeout)
- [ ] Multi-lingua
- [ ] Tema claro/escuro
- [ ] PIN de acesso
- [ ] Biometria
- [ ] Gerador de senhas
- [ ] Backup/restore
- [ ] Busca de senhas

---

## REGRAS DE OURO DO DESENVOLVIMENTO

### 1. ZERO HARDCODE
```
NUNCA: const text = "Texto fixo no codigo"
SEMPRE: ModLang.GetText("chave_do_texto")
```

### 2. SEGURANCA PRIMEIRO
- NUNCA logar senhas ou frases em texto claro
- Limpar variaveis sensiveis apos uso
- Criptografar TUDO antes de salvar

### 3. OFFLINE OBRIGATORIO
- NENHUM acesso a internet
- NENHUM servidor remoto
- Tudo local no dispositivo

### 4. MULTI-LINGUA
- Todos os textos via ModLang.GetText()
- Suporte minimo: Portugues e Ingles

---

## PROTOCOLO DE TRABALHO

### Ao iniciar sessao:

1. Ler este documento (CLAUDE.md)
2. Ler `docs/agentes/SOFTWARE_BEST.md` (boas praticas de arquitetura e DevOps)
3. Ler `C:\Basic4a\docs\DICAS_B4A.md` (dicas essenciais de desenvolvimento B4A - arquivo global)
4. Verificar TODO_LIST.md para tarefas pendentes
5. Verificar HISTORICO.md para contexto recente
6. **OBRIGATORIO - Exibir mensagem:**
   ```
   "Shalom Humberto, arquivos lidos e pronto para o trabalho!"
   ```
7. Perguntar: "Em que posso ajudar hoje?"

### Comando @salvar:

Quando o usuario digitar **@salvar**, o Claude deve IMEDIATAMENTE:

1. **git add** - Adicionar arquivos modificados
2. **git commit** - Criar commit com mensagem descritiva
3. **git push** - Enviar para o repositorio remoto
4. **HISTORICO.md** - Adicionar entrada com data/hora
5. **TODO_LIST.md** - Marcar tarefas concluidas como [x]
6. **Confirmar** ao usuario o que foi salvo

**Formato do commit:**
```
fix/feat/docs(escopo): descricao breve

- detalhe 1
- detalhe 2

🤖 Generated with [Claude Code](https://claude.com/claude-code)

Co-Authored-By: Claude Opus 4.5 <noreply@anthropic.com>
```

---

## SISTEMA DE SEGURANCA

### Arquitetura de Criptografia

| Dado | Criptografia | Chave |
|------|--------------|-------|
| Senhas | AES-256 | Frase-senha do usuario |
| Usernames | AES-256 | Frase-senha do usuario |
| Notas | AES-256 | Frase-senha do usuario |
| Nomes de grupos | Nao | - |

### Sessao de Frase-Senha

- Usuario digita frase-senha ao abrir grupo
- Sessao fica ativa por X minutos (configuravel)
- Ao expirar, precisa digitar novamente
- Funcoes em ModSecurity:
  - `StartSession(groupId, passphrase)`
  - `IsSessionValid(groupId)`
  - `GetSessionPassphrase(groupId)`
  - `ClearSession()`

---

## GLOSSARIO

| Termo | Significado |
|-------|-------------|
| Frase | Abreviacao de "frase-senha" (usar sempre assim) |
| Frase-senha | Texto pessoal usado como chave de criptografia |
| Grupo | Pasta que organiza senhas (ex: "Bancos") |
| Entrada | Uma senha especifica (site + usuario + senha) |
| Sessao | Periodo em que a frase fica em memoria (ofuscada) |
| Timeout | Tempo ate a sessao expirar automaticamente |
| TestValue | "LOCKZERO" criptografado - usado para validar frase |
| Salt | String aleatoria unica por grupo para criptografia |

---

## AVISOS CRITICOS

### NUNCA FAZER:
1. Logar senhas em texto claro
2. Armazenar frase-senha em disco
3. Acessar internet
4. Hardcodar textos no codigo

### SEMPRE FAZER:
1. Criptografar antes de salvar
2. Limpar variaveis sensiveis
3. Usar ModLang para textos
4. Documentar alteracoes

---

## FILOSOFIA

> **"Suas senhas, sua responsabilidade. LockZero apenas protege."**

- Seguranca > Conveniencia
- Offline > Online
- Simples > Complexo
- Testado > Confiado

---

**Versao do Documento:** 1.0
**Baseado em:** LockSeed CLAUDE.md + Modulo de Senhas (renomeado para LockZero)
**Criado por:** Claude + Humberto
