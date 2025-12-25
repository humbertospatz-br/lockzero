# 🔐 LOCKZERO - Especificação Técnica de Desenvolvimento

> **Versão:** 1.0.0  
> **Data:** Dezembro 2024  
> **Família:** Lockseed Products  
> **Conceito:** "Lock + Zero preocupação"

---

## 📋 Índice

1. [Visão Geral](#visão-geral)
2. [Arquitetura](#arquitetura)
3. [Funcionalidades](#funcionalidades)
4. [Estrutura de Dados](#estrutura-de-dados)
5. [Fluxos de Usuário](#fluxos-de-usuário)
6. [Componentes Técnicos](#componentes-técnicos)
7. [Segurança](#segurança)
8. [Interface (UI/UX)](#interface-uiux)
9. [Roadmap de Desenvolvimento](#roadmap-de-desenvolvimento)

---

## 🎯 Visão Geral

### O que é o Lockzero?

Lockzero é um cofre digital **100% offline** para armazenamento seguro de:
- Senhas de sites
- Cartões de crédito/débito
- Documentos pessoais (imagens)
- Notas seguras
- Credenciais Wi-Fi
- Códigos 2FA/recuperação

### Diferenciais Competitivos

| Característica | Concorrentes | Lockzero |
|----------------|--------------|----------|
| 100% Offline | ❌ | ✅ |
| Proteção por Frase | ❌ | ✅ |
| Sem assinatura mensal | ❌ | ✅ |
| OCR integrado | Parcial | ✅ Completo |
| Dados nunca saem do dispositivo | ❌ | ✅ |

### Princípios Fundamentais

1. **Zero Internet** - Nenhum dado trafega pela rede
2. **Zero Conhecimento** - Nem nós sabemos sua frase
3. **Zero Recuperação** - Perdeu a frase, perdeu acesso (segurança máxima)
4. **Zero Assinatura** - Pagamento único ou freemium

---

## 🏗️ Arquitetura

### Stack Tecnológico

```
┌─────────────────────────────────────────────────────┐
│                    FRONTEND                          │
│  React Native / Flutter / Expo                       │
│  (Cross-platform: iOS + Android)                     │
├─────────────────────────────────────────────────────┤
│                    CAMADA OCR                        │
│  - Google ML Kit (offline)                           │
│  - Tesseract.js (alternativa)                        │
├─────────────────────────────────────────────────────┤
│                    CRIPTOGRAFIA                      │
│  - Algoritmo de Frase (igual Lockseed)               │
│  - AES-256-GCM para dados                            │
│  - Argon2id para derivação de chave                  │
├─────────────────────────────────────────────────────┤
│                    STORAGE LOCAL                     │
│  - SQLite criptografado (SQLCipher)                  │
│  - Realm (alternativa)                               │
│  - AsyncStorage para configs não sensíveis           │
├─────────────────────────────────────────────────────┤
│                    SISTEMA                           │
│  - Biometria nativa (FaceID/TouchID/Fingerprint)     │
│  - Secure Enclave / Keystore                         │
│  - Camera API                                        │
└─────────────────────────────────────────────────────┘
```

### Estrutura de Pastas

```
lockzero/
├── src/
│   ├── components/
│   │   ├── common/
│   │   │   ├── Button.tsx
│   │   │   ├── Input.tsx
│   │   │   ├── Card.tsx
│   │   │   └── Modal.tsx
│   │   ├── vault/
│   │   │   ├── VaultItem.tsx
│   │   │   ├── VaultList.tsx
│   │   │   ├── CategoryTabs.tsx
│   │   │   └── SearchBar.tsx
│   │   ├── ocr/
│   │   │   ├── CameraScanner.tsx
│   │   │   ├── CardScanner.tsx
│   │   │   ├── DocumentScanner.tsx
│   │   │   └── QRScanner.tsx
│   │   └── generator/
│   │       ├── PasswordGenerator.tsx
│   │       └── PasswordOptions.tsx
│   │
│   ├── screens/
│   │   ├── auth/
│   │   │   ├── PhraseScreen.tsx        # Tela de frase
│   │   │   ├── CreatePhraseScreen.tsx  # Criar nova frase
│   │   │   └── BiometricScreen.tsx     # Desbloqueio rápido
│   │   ├── vault/
│   │   │   ├── HomeScreen.tsx          # Dashboard principal
│   │   │   ├── PasswordsScreen.tsx     # Lista de senhas
│   │   │   ├── CardsScreen.tsx         # Cartões salvos
│   │   │   ├── DocumentsScreen.tsx     # Documentos/imagens
│   │   │   ├── NotesScreen.tsx         # Notas seguras
│   │   │   └── WifiScreen.tsx          # Credenciais Wi-Fi
│   │   ├── add/
│   │   │   ├── AddPasswordScreen.tsx
│   │   │   ├── AddCardScreen.tsx
│   │   │   ├── AddDocumentScreen.tsx
│   │   │   ├── AddNoteScreen.tsx
│   │   │   └── ScannerScreen.tsx       # Scanner universal
│   │   ├── generator/
│   │   │   └── GeneratorScreen.tsx
│   │   └── settings/
│   │       ├── SettingsScreen.tsx
│   │       ├── ExportScreen.tsx
│   │       ├── ImportScreen.tsx
│   │       └── SecurityScreen.tsx
│   │
│   ├── services/
│   │   ├── crypto/
│   │   │   ├── phraseEngine.ts         # Motor de frase (Lockseed)
│   │   │   ├── encryption.ts           # AES-256-GCM
│   │   │   ├── keyDerivation.ts        # Argon2id
│   │   │   └── hash.ts                 # Hashing seguro
│   │   ├── ocr/
│   │   │   ├── cardOCR.ts              # Leitura de cartões
│   │   │   ├── documentOCR.ts          # Leitura de documentos
│   │   │   ├── urlOCR.ts               # Leitura de URLs
│   │   │   └── processor.ts            # Processamento de imagem
│   │   ├── storage/
│   │   │   ├── database.ts             # SQLCipher wrapper
│   │   │   ├── vault.ts                # CRUD do cofre
│   │   │   └── backup.ts               # Export/Import
│   │   ├── generator/
│   │   │   ├── passwordGenerator.ts
│   │   │   └── passwordStrength.ts
│   │   └── session/
│   │       ├── sessionManager.ts       # Controle de sessão
│   │       └── autoLock.ts             # Timer de bloqueio
│   │
│   ├── hooks/
│   │   ├── useAuth.ts
│   │   ├── useVault.ts
│   │   ├── useOCR.ts
│   │   ├── useGenerator.ts
│   │   └── useSession.ts
│   │
│   ├── store/
│   │   ├── authStore.ts
│   │   ├── vaultStore.ts
│   │   └── settingsStore.ts
│   │
│   ├── types/
│   │   ├── vault.types.ts
│   │   ├── auth.types.ts
│   │   └── settings.types.ts
│   │
│   ├── utils/
│   │   ├── validators.ts
│   │   ├── formatters.ts
│   │   ├── clipboard.ts
│   │   └── constants.ts
│   │
│   └── config/
│       ├── theme.ts
│       └── navigation.ts
│
├── assets/
│   ├── icons/
│   ├── images/
│   └── fonts/
│
└── __tests__/
```

---

## ⚙️ Funcionalidades

### 1. Sistema de Autenticação (JÁ DESENVOLVIDO ✅)

#### 1.1 Proteção por Frase
- Mesmo algoritmo do Lockseed
- Frase transforma em chave de criptografia
- Sem armazenamento da frase em lugar algum

#### 1.2 Temporizador de Sessão (JÁ DESENVOLVIDO ✅)
```typescript
interface SessionConfig {
  timeout: number;          // Tempo em segundos (padrão: 300 = 5min)
  lastActivity: timestamp;  // Última interação
  isLocked: boolean;        // Estado atual
  biometricEnabled: boolean; // Desbloqueio rápido
}
```

**Comportamento:**
- Após inserir frase correta → sessão aberta por X segundos
- Sem interação por X segundos → bloqueio automático
- Configurável pelo usuário (30s, 1min, 5min, 15min, 30min)
- Igual comportamento do Google Chrome com senhas

#### 1.3 Desbloqueio Biométrico (Opcional)
- FaceID / TouchID / Fingerprint
- Apenas após primeiro desbloqueio por frase
- Chave derivada armazenada no Secure Enclave

---

### 2. Cofre de Senhas

#### 2.1 Estrutura de uma Senha
```typescript
interface PasswordEntry {
  id: string;
  category: 'password';
  
  // Dados principais
  name: string;           // Ex: "Google", "Facebook"
  url: string;            // Ex: "https://google.com"
  username: string;       // Email ou usuário
  password: string;       // Senha (criptografada)
  
  // Metadados
  favicon?: string;       // Ícone do site (base64)
  notes?: string;         // Observações
  tags?: string[];        // Tags personalizadas
  
  // Controle
  createdAt: timestamp;
  updatedAt: timestamp;
  lastUsed?: timestamp;
  strength: 'weak' | 'medium' | 'strong' | 'very_strong';
}
```

#### 2.2 Funcionalidades
- [x] CRUD completo
- [ ] Busca por nome/URL/tag
- [ ] Favoritos
- [ ] Copiar com 1 toque (limpa clipboard após 30s)
- [ ] Histórico de senhas anteriores
- [ ] Detector de senhas duplicadas
- [ ] Detector de senhas fracas

---

### 3. Cofre de Cartões

#### 3.1 Estrutura de um Cartão
```typescript
interface CardEntry {
  id: string;
  category: 'card';
  
  // Dados do cartão
  cardholderName: string;  // Nome no cartão
  cardNumber: string;      // Número (criptografado)
  expiryMonth: string;     // MM
  expiryYear: string;      // YY ou YYYY
  cvv: string;             // CVV (criptografado)
  
  // Identificação
  nickname: string;        // Ex: "Nubank Pessoal"
  brand: CardBrand;        // Visa, Mastercard, etc
  type: 'credit' | 'debit' | 'both';
  color?: string;          // Cor do cartão para UI
  
  // Metadados
  bankName?: string;
  lastFourDigits: string;  // Para exibição segura
  
  // Controle
  createdAt: timestamp;
  updatedAt: timestamp;
  expiryAlert?: boolean;   // Alertar vencimento
}

type CardBrand = 
  | 'visa' 
  | 'mastercard' 
  | 'amex' 
  | 'elo' 
  | 'hipercard' 
  | 'diners'
  | 'other';
```

#### 3.2 OCR de Cartões
```typescript
interface CardOCRResult {
  cardNumber: string | null;
  cardholderName: string | null;
  expiryDate: string | null;  // MM/YY
  brand: CardBrand;
  confidence: number;         // 0-100
}

// Detecção de bandeira pelo BIN (primeiros 6 dígitos)
const detectBrand = (cardNumber: string): CardBrand => {
  const bin = cardNumber.substring(0, 6);
  
  if (/^4/.test(bin)) return 'visa';
  if (/^5[1-5]/.test(bin)) return 'mastercard';
  if (/^3[47]/.test(bin)) return 'amex';
  if (/^636368|438935|504175|451416|636297/.test(bin)) return 'elo';
  if (/^606282|3841/.test(bin)) return 'hipercard';
  if (/^36|38|39/.test(bin)) return 'diners';
  
  return 'other';
};
```

---

### 4. Cofre de Documentos

#### 4.1 Estrutura de um Documento
```typescript
interface DocumentEntry {
  id: string;
  category: 'document';
  
  // Identificação
  name: string;              // Ex: "CNH", "RG", "Passaporte"
  type: DocumentType;
  
  // Imagens (criptografadas)
  images: DocumentImage[];
  
  // Dados extraídos (OCR)
  extractedData?: {
    cpf?: string;
    rg?: string;
    name?: string;
    birthDate?: string;
    expiryDate?: string;
    [key: string]: string | undefined;
  };
  
  // Metadados
  notes?: string;
  tags?: string[];
  
  // Controle
  createdAt: timestamp;
  updatedAt: timestamp;
}

interface DocumentImage {
  id: string;
  data: string;      // Base64 criptografado
  side: 'front' | 'back' | 'other';
  thumbnail: string; // Base64 thumbnail para preview
}

type DocumentType = 
  | 'cpf'
  | 'rg'
  | 'cnh'
  | 'passport'
  | 'voter_id'      // Título de eleitor
  | 'work_card'     // Carteira de trabalho
  | 'other';
```

---

### 5. Notas Seguras

#### 5.1 Estrutura de uma Nota
```typescript
interface NoteEntry {
  id: string;
  category: 'note';
  
  title: string;
  content: string;      // Texto livre (criptografado)
  
  // Organização
  color?: string;       // Cor da nota
  tags?: string[];
  pinned?: boolean;
  
  // Controle
  createdAt: timestamp;
  updatedAt: timestamp;
}
```

#### 5.2 Tipos Comuns de Notas
- Códigos de recuperação 2FA
- Licenças de software
- PINs e PUKs
- Combinações de cofre/cadeado
- Informações médicas
- Receitas médicas

---

### 6. Credenciais Wi-Fi

#### 6.1 Estrutura
```typescript
interface WifiEntry {
  id: string;
  category: 'wifi';
  
  ssid: string;           // Nome da rede
  password: string;       // Senha (criptografada)
  security: WifiSecurity;
  
  // Metadados
  location?: string;      // Ex: "Casa", "Escritório"
  notes?: string;
  
  // Controle
  createdAt: timestamp;
  updatedAt: timestamp;
}

type WifiSecurity = 'WPA' | 'WPA2' | 'WPA3' | 'WEP' | 'Open';
```

#### 6.2 OCR de Etiquetas Wi-Fi
- Lê QR Code de configuração Wi-Fi
- Lê etiquetas de roteador (SSID + senha)

---

### 7. Gerador de Senhas

#### 7.1 Configurações
```typescript
interface PasswordGeneratorConfig {
  length: number;           // 8-128 caracteres
  
  // Caracteres incluídos
  uppercase: boolean;       // A-Z
  lowercase: boolean;       // a-z
  numbers: boolean;         // 0-9
  symbols: boolean;         // !@#$%^&*()
  
  // Opções especiais
  excludeAmbiguous: boolean;  // Excluir 0, O, l, 1, I
  excludeSimilar: boolean;    // Excluir caracteres similares
  customSymbols?: string;     // Símbolos personalizados
  
  // Modos
  mode: 'random' | 'memorable' | 'pin' | 'passphrase';
}

interface GeneratedPassword {
  password: string;
  strength: PasswordStrength;
  entropy: number;          // Bits de entropia
  crackTime: string;        // Tempo estimado para quebrar
}

interface PasswordStrength {
  score: 0 | 1 | 2 | 3 | 4;  // 0=muito fraca, 4=muito forte
  label: 'very_weak' | 'weak' | 'medium' | 'strong' | 'very_strong';
  feedback: string[];        // Dicas de melhoria
}
```

#### 7.2 Fluxo: Gerar → Salvar
```
[Usuário abre gerador]
       ↓
[Configura opções]
       ↓
[Clica "Gerar"]
       ↓
[Exibe senha + força + tempo para quebrar]
       ↓
[Opções:]
├── [Copiar] → Copia para clipboard (limpa após 30s)
├── [Gerar outra] → Nova senha com mesmas configs
└── [Salvar] → Abre modal para vincular a um site
              ↓
        [Preenche: nome, URL, usuário]
              ↓
        [Salva no cofre automaticamente]
```

---

### 8. Scanner OCR Universal

#### 8.1 Modos de Escaneamento
```typescript
type ScanMode = 
  | 'card'        // Cartão de crédito
  | 'document'    // Documento com foto
  | 'url'         // Tela com URL de site
  | 'wifi'        // QR Code ou etiqueta Wi-Fi
  | 'qrcode'      // QR Code genérico
  | 'text';       // Texto livre

interface ScanResult {
  mode: ScanMode;
  confidence: number;
  data: CardOCRResult | DocumentOCRResult | UrlOCRResult | WifiOCRResult | string;
  rawImage?: string;  // Base64 da imagem original
}
```

#### 8.2 OCR de URL (Tela de Login)
```typescript
interface UrlOCRResult {
  url: string | null;           // URL detectada na barra de endereços
  possibleFields: {
    username?: string;          // Campo de usuário detectado
    email?: string;             // Campo de email detectado
  };
  siteName?: string;            // Nome do site se detectado
  confidence: number;
}
```

**Fluxo:**
```
[Usuário aponta câmera para tela de login]
       ↓
[OCR detecta URL na barra de endereços]
       ↓
[Preenche automaticamente campo "URL"]
       ↓
[Usuário completa: usuário + senha]
       ↓
[Salva]
```

---

### 9. Import/Export

#### 9.1 Exportar para CSV (Navegadores)
```typescript
interface ExportOptions {
  format: 'csv' | 'json' | 'lockzero';
  categories: ('password' | 'card' | 'document' | 'note' | 'wifi')[];
  encrypted: boolean;  // Se true, pede senha para o arquivo
}

// Formato CSV padrão para navegadores
const CSV_HEADER = 'name,url,username,password';

// Formato CSV exemplo
const csvExample = `name,url,username,password
Google,https://google.com,email@gmail.com,minhasenha123
Facebook,https://facebook.com,usuario,senha456`;
```

#### 9.2 Importar de CSV
```typescript
interface ImportResult {
  total: number;
  imported: number;
  duplicates: number;
  errors: ImportError[];
}

interface ImportError {
  line: number;
  message: string;
  data: string;
}
```

#### 9.3 Backup Criptografado (.lockzero)
```typescript
interface LockzeroBackup {
  version: string;
  createdAt: timestamp;
  
  // Metadados (não criptografados)
  meta: {
    itemCount: number;
    categories: string[];
  };
  
  // Dados (criptografados com frase do usuário)
  encryptedData: string;
  
  // Verificação
  checksum: string;
}
```

---

## 🔒 Segurança

### Algoritmo de Proteção por Frase

```typescript
// Mesmo algoritmo do Lockseed
const deriveKeyFromPhrase = async (phrase: string): Promise<CryptoKey> => {
  // 1. Normalizar frase
  const normalizedPhrase = phrase.trim().toLowerCase();
  
  // 2. Gerar salt determinístico (baseado na frase)
  const salt = await generateDeterministicSalt(normalizedPhrase);
  
  // 3. Derivar chave usando Argon2id
  const key = await argon2id({
    password: normalizedPhrase,
    salt: salt,
    iterations: 3,
    memory: 65536,  // 64MB
    parallelism: 4,
    hashLength: 32
  });
  
  return key;
};
```

### Criptografia dos Dados

```typescript
// AES-256-GCM para todos os dados sensíveis
const encryptData = async (
  data: string, 
  key: CryptoKey
): Promise<EncryptedData> => {
  const iv = crypto.getRandomValues(new Uint8Array(12));
  const encodedData = new TextEncoder().encode(data);
  
  const encrypted = await crypto.subtle.encrypt(
    { name: 'AES-GCM', iv },
    key,
    encodedData
  );
  
  return {
    iv: arrayBufferToBase64(iv),
    data: arrayBufferToBase64(encrypted)
  };
};
```

### Proteções Adicionais

```typescript
interface SecurityFeatures {
  // Clipboard
  clipboardAutoClear: number;     // Segundos (padrão: 30)
  
  // Screenshots
  preventScreenshots: boolean;    // FLAG_SECURE no Android
  
  // Debug
  preventDebugger: boolean;       // Detectar debugging
  
  // Integridade
  integrityCheck: boolean;        // Verificar tampering
  
  // Biometria
  biometricTimeout: number;       // Requer frase após X horas
}
```

---

## 🎨 Interface (UI/UX)

### Paleta de Cores

```typescript
const theme = {
  colors: {
    // Primárias
    primary: '#6366F1',      // Indigo
    primaryDark: '#4F46E5',
    primaryLight: '#818CF8',
    
    // Secundárias
    secondary: '#10B981',    // Emerald (sucesso)
    warning: '#F59E0B',      // Amber
    danger: '#EF4444',       // Red
    
    // Neutras
    background: '#0F172A',   // Slate 900
    surface: '#1E293B',      // Slate 800
    surfaceLight: '#334155', // Slate 700
    
    // Texto
    textPrimary: '#F8FAFC',  // Slate 50
    textSecondary: '#94A3B8', // Slate 400
    textMuted: '#64748B',    // Slate 500
    
    // Categorias
    categoryPassword: '#6366F1',
    categoryCard: '#F59E0B',
    categoryDocument: '#10B981',
    categoryNote: '#EC4899',
    categoryWifi: '#06B6D4',
  },
  
  // Espaçamentos
  spacing: {
    xs: 4,
    sm: 8,
    md: 16,
    lg: 24,
    xl: 32,
  },
  
  // Bordas
  borderRadius: {
    sm: 8,
    md: 12,
    lg: 16,
    full: 9999,
  }
};
```

### Telas Principais

```
┌─────────────────────────────────────┐
│         🔐 LOCKZERO                 │
│                                     │
│    Digite sua frase secreta:        │
│  ┌─────────────────────────────┐    │
│  │ ••••••••••••••••••••••••••  │    │
│  └─────────────────────────────┘    │
│                                     │
│         [ Desbloquear ]             │
│                                     │
│     ─── ou ───                      │
│                                     │
│     [👆 Usar Biometria]             │
│                                     │
└─────────────────────────────────────┘
           Tela de Login


┌─────────────────────────────────────┐
│  ☰  Lockzero          🔍    ⚙️     │
├─────────────────────────────────────┤
│                                     │
│  ┌───┐ ┌───┐ ┌───┐ ┌───┐ ┌───┐    │
│  │🔑│ │💳│ │📄│ │📝│ │📶│    │
│  │12 │ │ 5 │ │ 3 │ │ 8 │ │ 2 │    │
│  └───┘ └───┘ └───┘ └───┘ └───┘    │
│  Senhas Cards  Docs Notas WiFi     │
│                                     │
├─────────────────────────────────────┤
│  Recentes                           │
│  ┌─────────────────────────────┐    │
│  │ 🌐 Google         ••••••   │ 📋 │
│  │    email@gmail.com          │    │
│  └─────────────────────────────┘    │
│  ┌─────────────────────────────┐    │
│  │ 💳 Nubank         **** 1234│ 👁 │
│  │    Crédito                  │    │
│  └─────────────────────────────┘    │
│  ┌─────────────────────────────┐    │
│  │ 📄 CNH            Válida   │    │
│  │    Vence: 12/2028           │    │
│  └─────────────────────────────┘    │
│                                     │
├─────────────────────────────────────┤
│                                     │
│      [ + Adicionar ]   [📷 Scan]   │
│                                     │
└─────────────────────────────────────┘
           Tela Principal


┌─────────────────────────────────────┐
│  ←  Scanner                         │
├─────────────────────────────────────┤
│                                     │
│  ┌─────────────────────────────┐    │
│  │                             │    │
│  │                             │    │
│  │      [Área da Câmera]       │    │
│  │                             │    │
│  │   ┌───────────────────┐     │    │
│  │   │  Posicione aqui   │     │    │
│  │   └───────────────────┘     │    │
│  │                             │    │
│  └─────────────────────────────┘    │
│                                     │
│  ┌───┐ ┌───┐ ┌───┐ ┌───┐ ┌───┐    │
│  │💳│ │📄│ │🌐│ │📶│ │📝│    │
│  └───┘ └───┘ └───┘ └───┘ └───┘    │
│  Card  Doc   URL  WiFi  Text       │
│                                     │
└─────────────────────────────────────┘
          Tela do Scanner
```

---

## 🚀 Roadmap de Desenvolvimento

### Fase 1: Core (JÁ DESENVOLVIDO ✅)
- [x] Sistema de autenticação por frase
- [x] Temporizador de sessão
- [x] Estrutura base do projeto

### Fase 2: Cofre Básico (PRÓXIMO 🎯)
- [ ] CRUD de senhas
- [ ] Lista e busca
- [ ] Copiar para clipboard
- [ ] Detalhes do item

### Fase 3: Cartões e Documentos
- [ ] CRUD de cartões
- [ ] CRUD de documentos
- [ ] Galeria de imagens criptografada

### Fase 4: OCR
- [ ] Integração ML Kit / Tesseract
- [ ] Scanner de cartões
- [ ] Scanner de documentos
- [ ] Scanner de URL

### Fase 5: Gerador de Senhas
- [ ] Gerador com opções
- [ ] Medidor de força
- [ ] Integração "gerar e salvar"

### Fase 6: Import/Export
- [ ] Exportar CSV (Chrome, Edge, Safari)
- [ ] Importar CSV
- [ ] Backup .lockzero

### Fase 7: Polimento
- [ ] Biometria
- [ ] Temas (dark/light)
- [ ] Onboarding
- [ ] Ajustes de UX

### Fase 8: Publicação
- [ ] Testes de segurança
- [ ] App Store
- [ ] Google Play

---

## 📝 Notas de Desenvolvimento

### Dependências Principais

```json
{
  "dependencies": {
    "react-native": "latest",
    "expo": "latest",
    
    // Criptografia
    "react-native-quick-crypto": "para AES-256",
    "argon2-browser": "para derivação de chave",
    
    // Storage
    "react-native-sqlite-storage": "SQLCipher",
    "@react-native-async-storage/async-storage": "configs",
    
    // OCR
    "@react-native-ml-kit/text-recognition": "OCR offline",
    "react-native-camera": "câmera",
    
    // Biometria
    "react-native-biometrics": "FaceID/TouchID",
    
    // UI
    "react-native-reanimated": "animações",
    "react-native-gesture-handler": "gestos"
  }
}
```

### Variáveis de Ambiente

```env
# Não há variáveis de API (100% offline!)
# Apenas configs de build

APP_NAME=Lockzero
BUNDLE_ID=com.lockseed.lockzero
VERSION=1.0.0
```

---

## 📞 Referências

- **Lockseed:** Algoritmo de frase já implementado
- **Família de produtos:** Manter consistência visual e de UX
- **Domínio:** lockzero.pro

---

> **Documento gerado para desenvolvimento interno**  
> **Última atualização:** Dezembro 2024
