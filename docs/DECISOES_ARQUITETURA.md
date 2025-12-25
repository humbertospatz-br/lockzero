# DECISOES DE ARQUITETURA - LOCKZERO

> Documento de decisoes tecnicas e de produto
> Baseado em: Analise "Advogado do Diabo" + Decisoes do Humberto
> Data: 2025-12-25

---

## PRINCIPIOS FUNDAMENTAIS

1. **Zero Internet** - Nenhum dado trafega pela rede
2. **Zero Conhecimento** - Nem nos sabemos sua frase
3. **Zero Recuperacao** - Perdeu a frase/PIN, perdeu acesso
4. **Zero Assinatura** - Pagamento unico ou freemium

---

## DECISOES DE SEGURANCA

### 1. Protecao por Grupo (CONFIRMADO)

Cada grupo pode ter seu proprio metodo de protecao:

| Metodo | Descricao | Uso Recomendado |
|--------|-----------|-----------------|
| **FRASE** | Texto livre, mais seguro | Bancos, dados criticos |
| **PIN** | Minimo 6 numeros | Redes sociais, dados menos criticos |
| **BIOMETRIA** | Facilitador apenas | Reabrir sessao ja validada |

**Regras:**
- Biometria NUNCA substitui frase/PIN
- Biometria apenas reabre sessao ja validada
- PIN minimo: 6 digitos
- Frase minima: definir (sugestao: 8 caracteres)

---

### 2. Salt Aleatorio por Grupo (CONFIRMADO)

**Problema identificado:** Salt derivado da frase = previsivel

**Solucao:**
- Salt aleatorio gerado na criacao do grupo
- Salt armazenado no header do grupo (nao secreto)
- Cada grupo tem chave propria derivada

**Estrutura:**
```
Grupo {
  id: UUID
  name: "Bancos"
  protectionType: "PHRASE" | "PIN"
  salt: "base64..." (aleatorio, 16 bytes)
  createdAt: timestamp
}
```

---

### 3. Protecao contra Brute Force (CONFIRMADO)

**Delay Progressivo Local:**
- 1ª tentativa errada: sem delay
- 2ª tentativa: 2 segundos
- 3ª tentativa: 5 segundos
- 4ª tentativa: 15 segundos
- 5ª tentativa: 30 segundos
- 6ª+ tentativa: 60 segundos

**Limite de Tentativas com Wipe:**
- Apos X tentativas erradas consecutivas (configuravel, padrao: 10)
- Sistema apaga APENAS o grupo em questao
- NAO apaga outros grupos
- Aviso claro: "Restam X tentativas antes de apagar este grupo"

**Implementacao:**
```
Grupo {
  ...
  failedAttempts: Int (tentativas erradas consecutivas)
  lastFailedAt: Long (timestamp da ultima falha)
  maxAttempts: Int (limite, padrao 10)
}
```

**Reset:**
- Tentativa correta zera contador
- Restaurar backup zera contador

---

### 4. Mudanca de Protecao (CONFIRMADO)

**Regra:** Para mudar o metodo de protecao de um grupo:

1. **Backup FRESCO obrigatorio** - mesmo que exista backup anterior
2. Usuario confirma que fez o backup
3. Usuario digita frase/PIN ATUAL
4. Sistema re-criptografa com novo metodo
5. Confirma sucesso

**Fluxo:**
```
[Alterar Protecao]
       ↓
"Faca um backup AGORA para sua seguranca"
       ↓
[Fazer Backup] ← nao pode pular
       ↓
"Backup salvo em: /path/file.lockzero"
       ↓
"Digite sua frase/PIN atual"
       ↓
[Validou] → Re-criptografa
       ↓
"Protecao alterada com sucesso!"
```

---

### 4. Backup Obrigatorio no Onboarding (CONFIRMADO)

**Regra:** Usuario NAO pode usar o app sem fazer primeiro backup.

**Fluxo de primeiro uso:**
```
[Instala app]
       ↓
[Onboarding: explica o app]
       ↓
[Aceite explicito: "Entendo que NAO ha recuperacao"]
       ↓
[Cria primeiro grupo + primeira senha]
       ↓
"Agora faca seu primeiro backup"
       ↓
[Fazer Backup] ← obrigatorio
       ↓
[App liberado para uso]
```

---

### 5. Avisos de Zero Recuperacao (CONFIRMADO)

**Textos obrigatorios no app:**

Onboarding:
> "Se voce esquecer sua frase/PIN, PERDERA TODOS OS DADOS. Nao existe recuperacao. Ninguem pode ajudar."

Criacao de grupo:
> "Este grupo sera protegido por [FRASE/PIN]. Anote em local seguro."

Mudanca de protecao:
> "Voce esta alterando a protecao deste grupo. Faca backup antes."

---

## DECISOES DE MVP

### MVP Inclui:
- [x] Senhas (FEITO)
- [x] Busca (FEITO)
- [x] Favoritos (FEITO)
- [x] Clipboard autoclear (FEITO)
- [x] Auto-lock por timeout (FEITO)
- [ ] Notas seguras (PENDENTE)
- [ ] Backup .lockzero (PENDENTE)
- [ ] Onboarding com aceite (PENDENTE)
- [ ] Protecao por grupo (FRASE/PIN) (PENDENTE)

### MVP NAO Inclui (Fases futuras):
- Cartoes
- Documentos/Imagens
- OCR
- Import CSV externo
- Anti-debug/anti-tamper
- Wi-Fi

---

## DECISOES DE SUPORTE

### Agente Expert (FUTURO)

Criar agente/bot para responder 95% das questoes de suporte:
- Integrado ao app ou site
- Base de conhecimento do LockZero
- Reduz custo de suporte humano

---

## ESTRUTURA DE DADOS ATUALIZADA

### clsPasswordGroup (atualizado)
```
Id: String (UUID)
Name: String
Icon: String
Color: Int
ProtectionType: String ("PHRASE" | "PIN")
Salt: String (base64, 16 bytes aleatorios)
CreatedAt: Long
UpdatedAt: Long
```

### Arquivo .lockzero (backup)
```json
{
  "version": 1,
  "createdAt": timestamp,
  "appVersion": "0.1.0",
  "groups": [...],
  "entries": [...],
  "notes": [...],
  "checksum": "sha256..."
}
```
Obs: Todo o conteudo criptografado com frase mestre do backup.

---

## PROXIMAS TAREFAS

1. Ajustar clsPasswordGroup (adicionar ProtectionType, Salt)
2. Ajustar ModSecurity (salt aleatorio, suporte PIN)
3. Criar ModBackup (export/import .lockzero)
4. Criar PageOnboarding (aceite + backup obrigatorio)
5. Adicionar Notas Seguras
6. Testes de seguranca

---

**Documento vivo - atualizar conforme novas decisoes**
