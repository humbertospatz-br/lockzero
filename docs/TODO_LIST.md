# TODO LIST - LOCKPASS

**Arquivo:** TODO_LIST.md
**Regras:**
- Tarefas urgentes/criticas no TOPO
- Ao concluir -> mover para HISTORICO.md
- Sempre incluir data de insercao

---

## VERSOES

| Versao | Data | Status |
|--------|------|--------|
| v0.1.0 | 2025-12-25 | Em desenvolvimento |

**Proxima versao:** v0.1.0 (MVP)

---

## CRITICAS (resolver IMEDIATAMENTE)

(Nenhuma tarefa critica no momento)

---

## ALTA PRIORIDADE (resolver hoje)

### Estrutura Base do Projeto
- [ ] [2025-12-25] Criar projeto lockpass.b4a no B4A
- [ ] [2025-12-25] Criar Starter.bas (service de inicializacao)
- [ ] [2025-12-25] Criar Main.bas (tela inicial)
- [ ] [2025-12-25] Criar ModLang.bas (multi-lingua PT/EN)
- [ ] [2025-12-25] Adaptar ModSecurity.bas (remover codigo LockSeed)
- [ ] [2025-12-25] Adaptar ModTheme.bas (remover codigo LockSeed)

### Tela Inicial (Main)
- [ ] [2025-12-25] Header com logo e titulo
- [ ] [2025-12-25] Lista de grupos com contador de senhas
- [ ] [2025-12-25] Botao + para adicionar grupo
- [ ] [2025-12-25] Menu lateral (configuracoes, sobre)

---

## MEDIA PRIORIDADE (resolver esta semana)

### Configuracoes (ActSettings)
- [ ] [2025-12-25] Criar ActSettings.bas
- [ ] [2025-12-25] Selecao de idioma (PT/EN)
- [ ] [2025-12-25] Selecao de tema (claro/escuro)
- [ ] [2025-12-25] Tempo de sessao (1-5 minutos)
- [ ] [2025-12-25] PIN de acesso (opcional)
- [ ] [2025-12-25] Biometria (opcional)

### Seguranca
- [ ] [2025-12-25] PIN na entrada do app
- [ ] [2025-12-25] Opcao de biometria
- [ ] [2025-12-25] Limpeza automatica clipboard (30s)
- [ ] [2025-12-25] Timeout de sessao funcionando

---

## BAIXA PRIORIDADE (resolver quando possivel)

### Funcionalidades Extras
- [ ] [2025-12-25] Gerador de senhas (comprimento, simbolos, etc.)
- [ ] [2025-12-25] Busca de senhas (por nome, usuario, site)
- [ ] [2025-12-25] Favoritos/fixar senhas importantes
- [ ] [2025-12-25] Icones por grupo (banco, email, social, etc.)
- [ ] [2025-12-25] Backup/restore criptografado
- [ ] [2025-12-25] Exportar para QR Code

### Idiomas Adicionais
- [ ] [2025-12-25] Hebraico (HE)
- [ ] [2025-12-25] Espanhol (ES)

### Plataformas
- [ ] [2025-12-25] Versao iOS (B4i)

---

## ARQUIVOS EXISTENTES (do LockSeed)

### Copiados e Funcionais:
| Arquivo | Status | Observacao |
|---------|--------|------------|
| ActPasswordGroups.bas | Adaptar | Remover referencias LockSeed |
| ActPasswordList.bas | Adaptar | Remover referencias LockSeed |
| clsPasswordGroup.bas | OK | Pronto para usar |
| clsPasswordEntry.bas | OK | Pronto para usar |
| ModPasswords.bas | Adaptar | Revisar dependencias |
| ModSecurity.bas | Adaptar | Manter apenas criptografia |
| ModTheme.bas | Adaptar | Simplificar se necessario |

### A Criar:
| Arquivo | Tipo | Descricao |
|---------|------|-----------|
| lockpass.b4a | Projeto | Projeto principal |
| Starter.bas | Service | Inicializacao |
| Main.bas | Activity | Tela inicial |
| ModLang.bas | Modulo | Multi-lingua |
| ActSettings.bas | Activity | Configuracoes |

---

## MODELO DE DADOS

### clsPasswordGroup
```
Id: String (UUID)
Name: String
Icon: String (emoji)
Color: Int
CreatedAt: Long
```

### clsPasswordEntry
```
Id: String (UUID)
GroupId: String
Label: String
Username: String (criptografado)
Password: String (criptografado)
Url: String
Notes: String (criptografado)
CreatedAt: Long
UpdatedAt: Long
```

---

## DIFERENCIAIS DO LOCKPASS

1. **100% Offline** - Nenhum servidor, nenhuma nuvem
2. **Criptografia Local** - AES-256 com frase pessoal
3. **Sessao Temporaria** - Frase em memoria por tempo limitado
4. **Open Source** - Codigo aberto e auditavel (futuro)

---

## OBSERVACOES

- Codigo base vem do LockSeed (testado e funcional)
- Foco em simplicidade e seguranca
- Mesma filosofia: "Nada salvo em servidores"

---

**Status:**
- [ ] Pendente
- [~] Em andamento
- [x] Concluido -> mover para HISTORICO.md
- [-] Cancelado

**Ultima atualizacao:** 2025-12-25
