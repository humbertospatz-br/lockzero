# TODO LIST - LOCKZERO

> **"Lock and ZERO worries - Guarde suas informacoes e ZERO preocupacao"**

**Arquivo:** TODO_LIST.md
**Plataforma:** B4xPages (Android primeiro, iOS futuro)
**Regras:**
- Tarefas urgentes/criticas no TOPO
- Ao concluir -> mover para HISTORICO.md
- Sempre incluir data de insercao

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
- [ ] [2025-12-25] Importar de CSV
- [ ] [2025-12-25] Importar de JSON
- [x] [2025-12-25] Restaurar backup .lockzero

### Telas
- [x] [2025-12-25] PageBackup.bas (export/import .lockzero)
- [ ] [2025-12-25] PageExport.bas (CSV/JSON)
- [ ] [2025-12-25] PageImport.bas (CSV/JSON)

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

## FASE 9: CONFIGURACOES (PENDENTE)

### Tela de Configuracoes
- [ ] [2025-12-25] PageSettings.bas
- [ ] [2025-12-25] Selecao de idioma (PT/EN)
- [ ] [2025-12-25] Selecao de tema (claro/escuro)
- [ ] [2025-12-25] Tempo de sessao (30s a 30min)
- [ ] [2025-12-25] Tempo de limpeza clipboard (15s, 30s, 1min, nunca)
- [ ] [2025-12-25] Bloqueio ao minimizar app (sim/nao)
- [ ] [2025-12-25] PIN de acesso (opcional)
- [ ] [2025-12-25] Biometria (FaceID/Fingerprint)

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

**Ultima atualizacao:** 2025-12-27
