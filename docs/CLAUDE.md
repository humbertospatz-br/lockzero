# CLAUDE - DOCUMENTO DE SESSAO - LOCKPASS

**Versao:** 1.0
**Criado:** 2025-12-25
**Projeto:** LockPass - Gerenciador de Senhas Seguro

---

## CONFIGURACAO DO PROJETO

```
NOME_PROJETO: LockPass
STACK: B4A/B4X (Basic4Android) + JSON
VERSAO_ATUAL: v0.1.0 (desenvolvimento)
DATA_INICIO: 2025-12-25
PLATAFORMA: Android (futuro: iOS)
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

### O que e o LockPass

O LockPass e um aplicativo mobile (B4A/B4X) para Android que:

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
lockpass_VSC/
├── docs/
│   ├── CLAUDE.md              # Este arquivo
│   ├── TODO_LIST.md           # Tarefas pendentes
│   ├── HISTORICO.md           # Historico de trabalho
│   └── cli_logs/              # Logs de sessoes CLI
├── lockpass/
│   ├── lockpass.b4a           # Projeto principal B4A (a criar)
│   │
│   ├── # ACTIVITIES
│   ├── Main.bas               # Tela inicial (a criar)
│   ├── ActPasswordGroups.bas  # Lista de grupos
│   ├── ActPasswordList.bas    # Senhas por grupo
│   ├── ActSettings.bas        # Configuracoes (a criar)
│   │
│   ├── # CLASSES
│   ├── clsPasswordGroup.bas   # Modelo de grupo
│   ├── clsPasswordEntry.bas   # Modelo de senha
│   │
│   ├── # MODULOS
│   ├── ModPasswords.bas       # CRUD de senhas + sessao
│   ├── ModSecurity.bas        # Criptografia AES-256
│   ├── ModTheme.bas           # Tema claro/escuro
│   ├── ModLang.bas            # Multi-lingua (a criar)
│   │
│   └── Files/                 # Assets do app
│
└── old/                       # Codigo obsoleto
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
2. Verificar TODO_LIST.md para tarefas pendentes
3. Verificar HISTORICO.md para contexto recente
4. **OBRIGATORIO - Exibir mensagem:**
   ```
   "Shalom Humberto, arquivos lidos e pronto para o trabalho!"
   ```
5. Perguntar: "Em que posso ajudar hoje?"

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
| Frase-senha | Texto pessoal usado como chave de criptografia |
| Grupo | Pasta que organiza senhas (ex: "Bancos") |
| Entrada | Uma senha especifica (site + usuario + senha) |
| Sessao | Periodo em que a frase-senha fica em memoria |
| Timeout | Tempo ate a sessao expirar automaticamente |

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

> **"Suas senhas, sua responsabilidade. LockPass apenas protege."**

- Seguranca > Conveniencia
- Offline > Online
- Simples > Complexo
- Testado > Confiado

---

**Versao do Documento:** 1.0
**Baseado em:** LockSeed CLAUDE.md + Modulo de Senhas
**Criado por:** Claude + Humberto
