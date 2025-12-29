# HISTORICO DE DESENVOLVIMENTO - LOCKZERO

**Arquivo:** HISTORICO.md
**Regras:**
- Entradas em ordem cronologica DECRESCENTE (mais recente primeiro)
- Formato: [DATA HORA] - Titulo
- Incluir arquivos alterados e observacoes

---

## 2025-12-29

### [2025-12-29 16:00] - PIN e Biometria - Fase 1 e 3

**Descricao:** Implementacao de autenticacao por PIN e Biometria ao iniciar o app

**ModSecurity.bas - Funcoes de PIN:**
- HasPIN() - Verifica se PIN esta configurado
- SavePIN(pin) - Salva PIN (4-8 digitos) com Base64
- ValidatePIN(inputPin) - Valida PIN digitado
- RemovePIN() - Remove PIN configurado
- GetUseBiometric/SetUseBiometric - Config biometria

**ModLang.bas - Textos PT/EN:**
- pin_title, pin_enter, pin_create, pin_confirm
- pin_wrong, pin_saved, pin_removed, pin_mismatch, pin_too_short
- biometric_title, biometric_prompt, biometric_or_pin, biometric_failed

**B4XMainPage.bas - Fluxo de Autenticacao:**
- pnlLock overlay escuro com campo PIN
- Biometria acionada automaticamente se habilitada
- Callback Biometric_Complete para sucesso/falha
- Fallback para PIN se biometria falhar
- IsAuthenticated flag controla acesso

**lockzero.b4a:**
- BiometricManager registrado como Module22 (NumberOfModules=22)

**Arquivos modificados:**
- ModSecurity.bas - Funcoes PIN e biometria
- ModLang.bas - Textos PT/EN
- B4XMainPage.bas - Lock screen e fluxo autenticacao
- lockzero.b4a - Registro BiometricManager
- docs/TODO_LIST.md - Atualizado
- docs/HISTORICO.md - Este arquivo

**Pendente (Fase 2 e 4):**
- PageSettings - Fluxo criar/remover PIN
- Biometria em operacoes sensiveis (delete)

---

### [2025-12-29 14:00] - Importacao CSV + Performance + Bug Fixes

**Descricao:** Implementacao de importacao CSV do Chrome/Edge/Safari + otimizacoes de performance

**Importacao CSV:**
- PageImportCSV.bas - Tela completa para importar senhas de navegadores
- Intent-filter para arquivos .csv (compartilhar do WhatsApp, email, etc)
- Parser CSV automatico (detecta colunas name, url, username, password, note)
- Selecao de grupo destino (existente ou criar novo)
- Preview de todas entradas antes de importar
- Validacao de frase-senha
- Log de linhas ignoradas (dados vazios)

**Performance:**
- Cache de frase normalizada em ModSession
  - NormalizedPhraseCache armazena frase ja processada
  - EncryptWithNormalized e DecryptWithNormalized em ModSecurity
  - Evita recalcular NormalizePassphrase a cada encrypt/decrypt
  - Resultado: Lista com 100 senhas agora chama Normalize 1x em vez de 100x

**Bug Fixes:**
- Intent duplicado corrigido (Activity_Resume reprocessava mesmo arquivo)
  - LastProcessedIntentUri guarda URI do ultimo intent processado

**Arquivos modificados:**
- ModSession.bas - Cache de frase normalizada
- ModSecurity.bas - EncryptWithNormalized, DecryptWithNormalized
- lockzero.b4a - LastProcessedIntentUri para evitar intent duplicado
- PageImportCSV.bas - Pequenos ajustes
- docs/TODO_LIST.md - Atualizado com CSV implementado
- docs/HISTORICO.md - Este arquivo

---

## 2025-12-25

### [2025-12-25 13:20] - Criacao do Projeto LockPass

**Descricao:** Projeto criado a partir do modulo de senhas extraido do LockSeed

**Origem:**
- Modulo de senhas foi desenvolvido para LockSeed
- Extraido em 2025-12-09 para focar LockSeed em wallets/cripto
- Arquivos salvos em `lockseed_VSC/modulo_senhas/`

**Arquivos copiados:**
- ActPasswordGroups.bas - Tela de grupos
- ActPasswordList.bas - Tela de senhas
- clsPasswordGroup.bas - Classe grupo
- clsPasswordEntry.bas - Classe entrada
- ModPasswords.bas - CRUD + sessao
- ModSecurity.bas - Criptografia AES-256
- ModTheme.bas - Tema visual

**Documentacao criada:**
- docs/CLAUDE.md - Documento de sessao
- docs/TODO_LIST.md - Tarefas pendentes
- docs/HISTORICO.md - Este arquivo

**Estrutura:**
```
lockpass_VSC/
├── docs/
│   ├── CLAUDE.md
│   ├── TODO_LIST.md
│   ├── HISTORICO.md
│   └── cli_logs/
├── lockpass/
│   ├── *.bas (arquivos copiados)
│   └── Files/
└── old/
```

**Proximos passos:**
1. Criar projeto lockpass.b4a no B4A
2. Criar Starter.bas e Main.bas
3. Adaptar arquivos removendo referencias ao LockSeed
4. Criar ModLang.bas para multi-lingua

**Observacoes:**
- Codigo base ja testado e funcional (vem do LockSeed)
- Precisa adaptacao para funcionar standalone

---

## PRE-HISTORIA (no LockSeed)

### [2025-12-09] - Extracao do Modulo de Senhas

**Descricao:** Modulo de senhas removido do LockSeed

**Motivo:** Decisao de produto - focar LockSeed exclusivamente em wallets e cripto

**Funcionalidades do modulo:**
- Grupos/pastas de senhas
- Criptografia AES-256 com frase-senha
- Sessao com timeout configuravel (1-5 minutos)
- Auto-lock apos expiracao
- Copiar senha para clipboard
- Mostrar/esconder senha

**Arquivos salvos em:** `lockseed_VSC/modulo_senhas/`

---

### [2025-12-08] - Desenvolvimento Inicial

**Descricao:** Modulo de senhas desenvolvido como parte do LockSeed

**Implementado:**
- CRUD de grupos de senhas
- CRUD de entradas de senha
- Criptografia baseada em frase-senha
- Sistema de sessao temporaria
- Interface basica

---

**Fim do historico**
