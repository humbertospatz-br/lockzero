# CLAUDE - TEMPLATE GENERICO DE SESSAO

**Versao:** 1.0
**Criado:** 2025-12-25
**Uso:** Template base para novos projetos B4A/B4X

---

## CONFIGURACAO DO PROJETO

```
NOME_PROJETO: [NOME]
STACK: B4A/B4X (Basic4Android) + JSON
VERSAO_ATUAL: v0.1.0
DATA_INICIO: [DATA]
PLATAFORMA: Android
```

---

## PRINCIPIO FUNDAMENTAL

> **"PENSE SIMPLES. NUNCA REMENDE. PENSE."**

1. **PENSE** - Qual a solucao mais simples?
2. **NUNCA REMENDE** - Se o codigo esta ruim, refatore
3. **PENSE DE NOVO** - Ha uma forma ainda mais simples?

---

## DIRETRIZ DO HUMBERTO - LEI SUPREMA

> **"SE ALGUEM JA FEZ, EU TAMBEM FACO."**
> **"SE ALGUEM NUNCA FEZ, EU, SE PRECISAR, FACO."**

NAO sugerir que algo "nao e possivel" antes de pesquisar.
Buscar referencias e exemplos existentes ANTES de desistir.

---

## COMO RESOLVER PROBLEMAS

### Perguntas Obrigatorias:

1. **Ja funcionava antes?** - Quando? O que mudou?
2. **O que foi alterado?** - Use git log/show para comparar
3. **Estou deixando passar algo obvio?** - PARE. PENSE. ANALISE.

### NUNCA Fazer:

1. Usar fallback/remendo como solucao
2. Mudar codigo sem entender
3. Adicionar complexidade desnecessaria

---

## DESCRICAO DO PROJETO

### O que e o [NOME]

[Descrever o que o app faz em 3-5 pontos]

### Filosofia

- [Principio 1]
- [Principio 2]
- [Principio 3]

---

## ESTRUTURA DO PROJETO

```
[projeto]_VSC/
├── docs/
│   ├── CLAUDE.md
│   ├── TODO_LIST.md
│   ├── HISTORICO.md
│   └── cli_logs/
├── [projeto]/
│   ├── [projeto].b4a
│   ├── Starter.bas
│   ├── Main.bas
│   ├── Mod*.bas
│   ├── cls*.bas
│   └── Files/
└── old/
```

---

## REGRAS DE OURO

### 1. ZERO HARDCODE
```
NUNCA: const text = "Texto fixo"
SEMPRE: ModLang.GetText("chave")
```

### 2. OFFLINE (se aplicavel)
- Nenhum acesso a internet
- Tudo local no dispositivo

### 3. MULTI-LINGUA
- Textos via ModLang.GetText()
- Minimo: PT e EN

### 4. DRY
- Nao duplicar codigo
- Criar funcoes reutilizaveis

---

## PROTOCOLO DE TRABALHO

### Ao iniciar sessao:

1. Ler CLAUDE.md
2. Ler TODO_LIST.md
3. Ler HISTORICO.md
4. Exibir: "Shalom Humberto, arquivos lidos e pronto!"
5. Perguntar: "Em que posso ajudar hoje?"

### Comando @salvar:

1. git add (arquivos modificados)
2. git commit (mensagem descritiva)
3. git push (origin)
4. HISTORICO.md (entrada com data/hora)
5. TODO_LIST.md (marcar [x])
6. Confirmar ao usuario

**Formato commit:**
```
fix/feat/docs(escopo): descricao

- detalhe 1
- detalhe 2

🤖 Generated with [Claude Code](https://claude.com/claude-code)

Co-Authored-By: Claude Opus 4.5 <noreply@anthropic.com>
```

---

## DIRETRIZ DE VIABILIDADE

ANTES de implementar, VERIFICAR:

1. **Politicas de Lojas** - Google Play, Apple
2. **Protecao de Dados** - LGPD, GDPR
3. **Restricoes Tecnicas** - Criptografia, APIs
4. **Procedimentos Comerciais** - Licenciamento, pagamentos

---

## AVISOS CRITICOS

### NUNCA:
- [Listar o que nunca fazer no projeto]

### SEMPRE:
- [Listar o que sempre fazer]

---

## GLOSSARIO

| Termo | Significado |
|-------|-------------|
| [termo] | [definicao] |

---

**Versao:** 1.0
**Criado por:** Claude + Humberto
