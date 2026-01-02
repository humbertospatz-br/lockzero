# ESPECIFICACAO: MODULO DE NOTAS - LOCKZERO

**Versao:** 1.0
**Data:** 2025-12-30
**Status:** Aprovado para implementacao

---

## 1. VISAO GERAL

O modulo de Notas permite ao usuario criar e gerenciar anotacoes organizadas em grupos, com opcao de protecao por frase-senha ou acesso livre.

---

## 2. GRUPOS DE NOTAS

### 2.1 Tipos de Grupo

| Tipo | Icone | Descricao |
|------|-------|-----------|
| **Seguro** | Cadeado antes do nome | Requer frase-senha para acessar. Notas criptografadas. |
| **Aberto** | Sem cadeado | Acesso livre sem autenticacao. Notas em texto claro. |

**Default ao criar:** Seguro (usuario deve desmarcar para criar aberto)

### 2.2 Campos do Grupo

```
Id          - UUID unico
Name        - Nome do grupo (ex: "Compras", "Ideias")
Icon        - Emoji escolhido pelo usuario (ex: "shopping_cart", "pill", "note")
IsSecure    - Boolean (true = seguro com cadeado, false = aberto)
Salt        - String 32 chars hex (apenas grupos seguros)
TestValue   - "LOCKZERO" criptografado (apenas grupos seguros)
CreatedAt   - Timestamp criacao
UpdatedAt   - Timestamp modificacao
```

### 2.3 Comportamento

**Grupo Seguro:**
- Exibe cadeado antes do nome na lista
- Ao clicar, verifica se sessao ativa
- Se nao, solicita frase-senha
- Notas armazenadas criptografadas (AES-256)

**Grupo Aberto:**
- Sem cadeado na lista
- Acesso direto sem autenticacao
- Notas armazenadas em texto claro
- Ideal para: lista de compras, lembretes rapidos

### 2.4 Nao Criar Grupo Padrao

Usuario cria grupos conforme necessidade. Nenhum grupo pre-criado na instalacao.

---

## 3. TIPOS DE NOTA

### 3.1 Texto

Nota tradicional com titulo e conteudo livre (multilinhas).

```
Campos:
- Title     - Titulo da nota
- Content   - Conteudo texto livre (multilinhas)
```

### 3.2 Lista (Checklist)

Nota com itens marcaveis (checkbox). Cada item pode ter multiplas linhas.

```
Campos:
- Title     - Titulo da lista
- Items[]   - Array de itens, cada um com:
  - text    - Texto do item (pode ter multiplas linhas)
  - checked - Boolean (marcado/desmarcado)
```

**Exemplo de item com multiplas linhas:**
```
[ ] Comprar no mercado:
    - Leite integral
    - Pao de forma
    - Queijo minas
```

### 3.3 Escolha ao Criar

Ao clicar em "+" para nova nota:
1. Dialog pergunta: "Qual tipo de nota?"
2. Opcoes: "Texto" | "Lista de tarefas"
3. Abre PageNoteEdit no modo escolhido

---

## 4. ORDENACAO

### 4.1 Ordenacao Manual (Drag & Drop)

- Notas ordenadas manualmente pelo usuario
- Long-press em nota ativa modo de reordenacao
- Arrastar para cima/baixo muda posicao
- Campo `SortOrder` (Int) controla ordem

### 4.2 Itens de Lista

- Itens dentro de uma lista tambem podem ser reordenados
- Mesmo mecanismo: long-press + arrastar

---

## 5. EXPORTACAO / SHARE

### 5.1 Fluxo de Exportacao

1. Usuario clica em botao Share na nota
2. **Se nota em grupo SEGURO:**
   - Dialog: "Exportar como texto aberto?"
   - Se confirmar: Pede PIN ou biometria
   - Se autenticado: Continua exportacao
3. **Se nota em grupo ABERTO:**
   - Exporta direto sem confirmacao
4. Abre Intent de compartilhamento do Android

### 5.2 Formato de Exportacao

**Nota Texto:**
```
TITULO DA NOTA
==============

Conteudo da nota aqui...
Pode ter multiplas linhas.

---
Criado em: 30/12/2025 14:30
```

**Nota Lista:**
```
LISTA DE COMPRAS
================

[x] Leite
[x] Pao
[ ] Queijo
[ ] Comprar no mercado:
    - Frutas
    - Verduras

---
Criado em: 30/12/2025 14:30
```

### 5.3 Formato dos Checkboxes

| Estado | Formato |
|--------|---------|
| Marcado | `[x]` |
| Desmarcado | `[ ]` |

---

## 6. ESTRUTURA DE ARQUIVOS

### 6.1 Arquivos a Criar

| Arquivo | Tipo | Descricao |
|---------|------|-----------|
| `clsNoteGroup.bas` | Classe | Estrutura do grupo de notas |
| `PageNotesGroups.bas` | B4XPage | Lista de grupos de notas |

### 6.2 Arquivos a Modificar

| Arquivo | Modificacao |
|---------|-------------|
| `clsNoteEntry.bas` | Adicionar NoteType, Items, SortOrder |
| `ModNotes.bas` | CRUD de grupos + ordenacao |
| `PageNotesList.bas` | Adaptar para NoteGroup, drag & drop |
| `PageNoteEdit.bas` | UI para texto vs lista, share |
| `B4XMainPage.bas` | Navegacao para PageNotesGroups |
| `ModLang.bas` | Textos PT/EN |
| `lockzero.b4a` | Registrar novos modulos |

### 6.3 Storage

```json
// lockzero_notes.json
{
  "version": 1,
  "groups": [
    {
      "id": "uuid",
      "name": "Compras",
      "icon": "shopping_cart",
      "isSecure": false,
      "salt": "",
      "testValue": "",
      "createdAt": 1234567890,
      "updatedAt": 1234567890
    }
  ],
  "notes": [
    {
      "id": "uuid",
      "groupId": "group-uuid",
      "title": "AES:... ou texto",
      "noteType": "text|list",
      "content": "AES:... ou texto",
      "items": "[{text, checked}, ...]",
      "sortOrder": 1,
      "isFavorite": false,
      "createdAt": 1234567890,
      "updatedAt": 1234567890
    }
  ]
}
```

---

## 7. INTERFACE DO USUARIO

### 7.1 PageNotesGroups (Lista de Grupos)

```
+----------------------------------+
|  NOTAS                       [+] |
+----------------------------------+
|                                  |
|  [lock] Pessoal            (5)   |
|  [lock] Trabalho           (12)  |
|  [    ] Compras            (3)   |
|  [    ] Remedios           (2)   |
|                                  |
+----------------------------------+
```

- `[lock]` = Grupo seguro (cadeado)
- `[    ]` = Grupo aberto (sem cadeado)
- `(N)` = Contador de notas

**Acoes:**
- Click: Abre lista de notas do grupo
- Long-press: Menu (Editar, Excluir)
- [+]: Criar novo grupo

### 7.2 PageNotesList (Lista de Notas)

```
+----------------------------------+
|  < COMPRAS                   [+] |
+----------------------------------+
|                                  |
|  Lista Mercado          [list]   |
|  2 de 5 itens                    |
|                                  |
|  Lembrete farmacia      [text]   |
|  Comprar remedio para...         |
|                                  |
+----------------------------------+
```

- `[list]` = Icone de lista
- `[text]` = Icone de texto
- Preview: 50 chars ou "X de Y itens"

### 7.3 PageNoteEdit - Modo Texto

```
+----------------------------------+
|  < NOVA NOTA      [share] [save] |
+----------------------------------+
|                                  |
|  Titulo: [________________]      |
|                                  |
|  +----------------------------+  |
|  |                            |  |
|  | Conteudo da nota...        |  |
|  |                            |  |
|  +----------------------------+  |
|                                  |
|  [ ] Marcar como favorito        |
|                                  |
+----------------------------------+
```

### 7.4 PageNoteEdit - Modo Lista

```
+----------------------------------+
|  < LISTA COMPRAS  [share] [save] |
+----------------------------------+
|                                  |
|  Titulo: [Lista Mercado____]     |
|                                  |
|  [x] Leite                       |
|  [x] Pao                         |
|  [ ] Queijo                      |
|  [ ] Comprar frutas:             |
|      - Banana                    |
|      - Maca                      |
|                                  |
|  + Adicionar item                |
|                                  |
|  [ ] Marcar como favorito        |
|                                  |
+----------------------------------+
```

---

## 8. FLUXO DE NAVEGACAO

```
B4XMainPage
    |
    +-- Card "Notas" ou Menu "Notas"
            |
            v
    PageNotesGroups (lista de grupos)
            |
            +-- Click em grupo SEGURO
            |       |
            |       +-- Sessao ativa? --> PageNotesList
            |       |
            |       +-- Sessao inativa? --> Dialog frase --> PageNotesList
            |
            +-- Click em grupo ABERTO --> PageNotesList (direto)
                    |
                    +-- Click em nota --> PageNoteEdit
                    |
                    +-- Click [+] --> Dialog tipo --> PageNoteEdit
```

---

## 9. TEXTOS (ModLang)

### Portugues (PT)

```
note_groups = "Grupos de Notas"
note_group_new = "Novo Grupo"
note_group_name = "Nome do grupo"
note_group_secure = "Grupo seguro (com cadeado)"
note_group_open = "Acesso livre"
note_type_text = "Texto"
note_type_list = "Lista de tarefas"
note_type_choose = "Qual tipo de nota?"
note_add_item = "Adicionar item"
note_items_count = "%1 de %2 itens"
note_share = "Compartilhar"
note_share_confirm = "Exportar como texto aberto?"
note_share_auth = "Confirme para exportar"
note_reorder = "Segure e arraste para reordenar"
```

### English (EN)

```
note_groups = "Note Groups"
note_group_new = "New Group"
note_group_name = "Group name"
note_group_secure = "Secure group (with lock)"
note_group_open = "Open access"
note_type_text = "Text"
note_type_list = "Checklist"
note_type_choose = "What type of note?"
note_add_item = "Add item"
note_items_count = "%1 of %2 items"
note_share = "Share"
note_share_confirm = "Export as plain text?"
note_share_auth = "Confirm to export"
note_reorder = "Hold and drag to reorder"
```

---

## 10. FASES DE IMPLEMENTACAO

### Fase 1: Grupos de Notas
1. Criar `clsNoteGroup.bas`
2. Atualizar `ModNotes.bas` com CRUD de grupos
3. Criar `PageNotesGroups.bas`
4. Atualizar navegacao em `B4XMainPage.bas`
5. Adaptar `PageNotesList.bas` para usar NoteGroup

### Fase 2: Tipos de Nota
1. Atualizar `clsNoteEntry.bas` (NoteType, Items, SortOrder)
2. Atualizar `PageNoteEdit.bas` (UI texto vs lista)
3. Atualizar `PageNotesList.bas` (preview por tipo)
4. Implementar drag & drop para reordenacao

### Fase 3: Exportacao
1. Adicionar botao Share em `PageNoteEdit.bas`
2. Criar funcao `FormatNoteForExport()` em `ModNotes.bas`
3. Implementar confirmacao para notas protegidas

### Fase 4 (Futura): Widget de Voz
- Biblioteca: SpeechRecognitionNoUI ou SpeechToText
- AppWidgetProvider com BroadcastReceiver
- Salva como nota em grupo aberto

---

## 11. REFERENCIAS

- [SpeechToText - B4X Forum](https://www.b4x.com/android/forum/threads/speechtotext-continuous-offline-voice-recognition.134857/)
- [SpeechRecognitionNoUI - B4X Forum](https://www.b4x.com/android/forum/threads/speechrecognitionnoui-google-speech-recognition-without-popup.117640/)
- [Android Widgets Tutorial Part I](https://www.b4x.com/android/forum/threads/android-home-screen-widgets-tutorial-part-i.10166/)
- [Android Widgets Tutorial Part II](https://www.b4x.com/android/forum/threads/android-home-screen-widgets-tutorial-part-ii.10356/)

---

**Aprovado por:** Humberto
**Data:** 2025-12-30
