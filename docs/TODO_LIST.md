# TODO LIST - LOCKZERO

> **"Lock and ZERO worries - Guarde suas informacoes e ZERO preocupacao"**

**Arquivo:** TODO_LIST.md
**Plataforma:** B4xPages (Android primeiro, iOS futuro)
**Regras:**
- Tarefas urgentes/criticas no TOPO
- Ao concluir -> mover para HISTORICO.md
- Sempre incluir data de insercao

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

---

## FASE 3: COFRE DE CARTOES (PENDENTE)

### Estrutura de Dados
- [ ] [2025-12-25] Criar clsCardEntry.bas (modelo de cartao)
- [ ] [2025-12-25] Criar ModCards.bas (CRUD cartoes)

### Telas B4xPages
- [ ] [2025-12-25] PageCards.bas - Lista de cartoes
- [ ] [2025-12-25] PageCardDetail.bas - Detalhes do cartao
- [ ] [2025-12-25] PageAddCard.bas - Adicionar/editar cartao

### Funcionalidades
- [ ] [2025-12-25] CRUD completo de cartoes
- [ ] [2025-12-25] Deteccao automatica de bandeira (Visa, Master, etc.)
- [ ] [2025-12-25] Exibicao segura (**** **** **** 1234)
- [ ] [2025-12-25] Alerta de vencimento

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

### Funcionalidades
- [ ] [2025-12-25] Criar ModGenerator.bas
- [ ] [2025-12-25] PageGenerator.bas - Tela do gerador
- [ ] [2025-12-25] Configuracoes: tamanho (8-128)
- [ ] [2025-12-25] Opcoes: maiusculas, minusculas, numeros, simbolos
- [ ] [2025-12-25] Excluir caracteres ambiguos (0, O, l, 1, I)
- [ ] [2025-12-25] Medidor de forca da senha
- [ ] [2025-12-25] Tempo estimado para quebrar
- [ ] [2025-12-25] Gerar -> Copiar ou Salvar direto

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

---

## FASE 9: CONFIGURACOES (PENDENTE)

### Tela de Configuracoes
- [ ] [2025-12-25] PageSettings.bas
- [ ] [2025-12-25] Selecao de idioma (PT/EN)
- [ ] [2025-12-25] Selecao de tema (claro/escuro)
- [ ] [2025-12-25] Tempo de sessao (30s a 30min)
- [ ] [2025-12-25] Limpeza automatica clipboard
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

**Ultima atualizacao:** 2025-12-25
