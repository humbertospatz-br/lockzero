# 🔐 LockZero — Análise Crítica (Advogado do Diabo) & Sequência de Desenvolvimento

> Documento interno de engenharia e produto  
> Autor: ChatGPT (modo **Advogado do Diabo**)  
> Data: Dezembro 2024  
> Objetivo: **reduzir riscos técnicos, de UX e de produto antes da implementação**

---

## 🎯 Propósito deste documento

Este documento **não é marketing**. Ele existe para:

- Apontar riscos reais (inclusive os desconfortáveis)
- Evitar decisões irreversíveis cedo demais
- Proteger o produto contra críticas técnicas, reviews negativos e problemas de suporte
- Garantir que o LockZero cresça de forma **sustentável, segura e auditável**

Tudo aqui deve ser lido como *proteção do projeto*, não como bloqueio de inovação.

---

## 🧨 Premissas confirmadas (importantes)

As seguintes premissas **já foram decididas** e este documento parte delas:

- O LockZero é **100% offline**
- Não existe servidor, sync ou cloud
- Exportação/importação existe **somente em formato criptografado**
- O usuário **escolhe o método de proteção por grupo**:
  - Frase
  - PIN
  - Biometria (como facilitador, não substituto)
- Grupos diferentes podem usar **criptografias diferentes**
- O modelo LockSeed (export criptografado + reimportação) é válido e reaproveitável

Essas decisões são fortes — mas **trazem consequências técnicas**.

---

## ⚠️ Riscos reais (Advogado do Diabo)

### 1️⃣ Criptografia por grupo = aumento de complexidade exponencial

Permitir que cada grupo (Senhas, Cartões, Docs, etc.) tenha **método próprio de proteção** traz vantagens, mas cria riscos:

- Mais código sensível
- Mais caminhos de erro
- Mais casos de suporte
- Mais chance de inconsistência de UX

**Risco concreto:**
Usuário esquece qual grupo usa qual método → sensação de "perdi meus dados".

**Mitigação obrigatória:**
- Metadados visíveis e claros ("Este grupo é protegido por FRASE")
- Confirmação explícita ao criar o grupo
- Tela de resumo de segurança por grupo

---

### 2️⃣ Frase + PIN + Biometria confundem usuários não técnicos

Do ponto de vista técnico é ótimo. Do ponto de vista humano:

- Usuários confundem *proteção* com *recuperação*
- Acham que biometria = backup
- Acreditam que PIN substitui frase

**Risco concreto:** reviews 1⭐ do tipo:
> "Perdi minha frase e o app não abre, absurdo"

**Mitigação obrigatória:**
- Onboarding duro, claro e repetitivo
- Frases como:
  > "Biometria **não recupera dados**"
- Aceite explícito (checkbox) ao criar frase

---

### 3️⃣ Zero recuperação é correto tecnicamente, perigoso comercialmente

"Zero recuperação" é segurança máxima — e também:

- Fonte nº1 de abandono
- Fonte nº1 de frustração
- Fonte nº1 de tickets (mesmo sem servidor)

**Mitigação inteligente (sem quebrar o princípio):**

- Backup .lockzero **obrigatório no onboarding**
- Aviso recorrente: "Você testou seu backup?"
- Opção de múltiplos backups criptografados

Sem isso, o produto vira *hardcore demais* para crescer.

---

### 4️⃣ OCR offline é bom, mas não confiável o suficiente para promessas fortes

OCR offline:

- Erra com reflexo
- Erra com fonte
- Erra com idioma
- Erra silenciosamente (pior caso)

**Risco concreto:** cartão salvo errado → prejuízo real.

**Regra de ouro:**
> OCR **nunca salva automaticamente**. Sempre revisão manual.

**Mitigação:**
- OCR como pré-preenchimento
- Confiança exibida (% de acerto)
- Confirmação explícita antes de salvar

---

### 5️⃣ Importação CSV é uma mina terrestre

CSV de navegadores:

- Campos diferentes
- Encoding quebrado
- URLs inconsistentes
- Senhas vazias

**Risco:** perda de dados + perda de confiança.

**Mitigação:**
- Importar **uma fonte por vez** (Chrome primeiro)
- Preview antes de importar
- Log detalhado de erros

---

### 6️⃣ Anti-debug / anti-tamper cedo demais gera mais bugs do que segurança

Essas proteções:

- Dão falso positivo
- Quebram em ROM customizada
- Geram bloqueios injustos

**Recomendação:**
Deixar para fase de hardening, não MVP.

---

## 🧱 Decisão técnica importante (criptografia)

### ⚠️ Alerta técnico sério

Salt determinístico baseado na frase:

- Não é padrão em password managers
- Vai gerar questionamento de auditoria
- Dificulta explicação pública

**Recomendação dura:**

Para LockZero:

- Salt aleatório por grupo
- Armazenado em header não secreto
- Argon2id padrão

A frase continua sendo a UX — a engenharia fica sólida.

---

## 🛠️ Sequência de Desenvolvimento Recomendada

### 🟢 Fase 0 — Fundação (obrigatória)

- Estrutura de grupos criptográficos
- Engine de chave por grupo
- Backup .lockzero funcional
- Importação do próprio backup

---

### 🟢 Fase 1 — MVP Publicável

**Escopo fechado:**

- Senhas
- Notas seguras
- Busca
- Favoritos
- Clipboard autoclear
- Auto-lock
- Backup criptografado

❌ Sem OCR
❌ Sem cartões

---

### 🟢 Fase 2 — Cartões & Documentos (manual primeiro)

- Cartões sem OCR automático
- Documentos com galeria criptografada
- Tags
- Pastas

OCR apenas como *assistente*.

---

### 🟡 Fase 3 — OCR Assistido

- OCR de URL
- OCR de documentos simples
- OCR de cartão **com revisão obrigatória**

---

### 🟡 Fase 4 — Importação Externa

- Import CSV Chrome
- Preview + validação
- Logs de erro

---

### 🔵 Fase 5 — Hardening

- Anti-debug
- Integridade
- Wipe progressivo
- Rate-limit local de tentativas

---

## 🧠 Princípio Final (manter sempre visível)

> **Segurança não é só criptografia.**  
> É UX, comunicação e expectativa bem alinhada.

Um produto seguro que o usuário não entende **parece inseguro**.

---

## ✅ Conclusão honesta

O LockZero é um projeto **forte, coerente e raro**.

O maior risco **não é técnico** — é humano:

- Esquecimento
- Confusão
- Expectativas erradas

Se essas armadilhas forem tratadas desde o início, o LockZero pode se tornar:

> **Um password manager offline de referência**, não apenas um app nichado.

---

---

# 🧪 Revisão como Auditor Externo (nível crítico)

> Papel assumido: **auditor de segurança e produto independente**, sem vínculo emocional com o projeto.

## ❗ Achados críticos

### A1. Criptografia por grupo é aceitável, mas precisa de isolamento real
- Cada grupo **DEVE** ter:
  - Salt próprio
  - Chave própria
  - Header próprio
- Nunca reutilizar chave derivada entre grupos

**Risco se não fizer:** vazamento lateral (compromete tudo).

---

### A2. Biometria não pode nunca desbloquear dados sem sessão válida
- Biometria **somente** reabre sessão já validada pela frase/PIN
- Nunca derivar chave direto da biometria

**Risco:** falsa sensação de recuperação.

---

### A3. Backup precisa ser testável
- Backup que nunca foi restaurado = backup inexistente

**Exigência de auditoria:**
- Botão: `Testar Backup`
- Simulação de restore local

---

### A4. OCR é superfície de risco legal
- Cartão salvo errado = prejuízo financeiro

**Exigência:**
- OCR sempre assistido
- Confirmação explícita antes de persistir

---

### A5. Logs e erros não podem vazar dados
- Nenhum log pode conter:
  - senha
  - frase
  - dados OCR crus

---

## 🧩 Checklist técnico mínimo para MVP (escopo fechado)

### 🔐 Segurança
- [ ] Argon2id com salt aleatório por grupo
- [ ] AES-256-GCM para dados
- [ ] Chave nunca persistida em plaintext
- [ ] Clipboard autoclear
- [ ] Auto-lock confiável

### 📦 Dados
- [ ] Cofre de senhas
- [ ] Notas seguras
- [ ] CRUD completo
- [ ] Busca
- [ ] Favoritos

### 💾 Backup
- [ ] Export `.lockzero`
- [ ] Import `.lockzero`
- [ ] Teste de restore

### 🧠 UX Crítica
- [ ] Onboarding com aceite explícito
- [ ] Avisos de perda de frase
- [ ] Metadados de segurança visíveis por grupo

### ❌ Fora do MVP
- OCR completo
- Cartões
- Anti-debug
- Import CSV externo

---

## 🏁 Conclusão do Auditor

> **O LockZero é viável, seguro e diferenciável** se o MVP for respeitado.

O maior risco não é criptografia, é **excesso de ambição inicial**.

---

**Documento atualizado — Auditor externo + Escopo MVP definido.**

