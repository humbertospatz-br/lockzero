# LOCKZERO — HOME & UI DEFINITIONS
Version: 1.1.0  
Date: 2025-12-27  
Platform: Android (B4A)  
Design Mode: Single Theme (Dark / Blue)

---

## 1) PALETA OFICIAL DE CORES

### 1.1 Home Background
Cor principal da Home (ligeiramente mais clara que o navy original):

- HOME_BG  
  RGB(28, 58, 106)  
  HEX: **#1C3A6A**

Critério:
- Mais clara que o antigo #152B52
- Ainda mais escura que o fundo dos ícones
- Mantém clima “cofre / segurança”

---

### 1.2 Header (Top Bar)

Header sempre um pouco mais escuro que a Home:

- HEADER_BG  
  RGB(21, 47, 88)  
  HEX: **#152F58**

- HEADER_TEXT  
  HEX: **#FFFFFF**

---

### 1.3 Cards (fundos dos blocos 2×2)

Os cards devem ficar entre a Home e os ícones em luminosidade:

- CARD_BG  
  RGB(44, 79, 128)  
  HEX: **#2C4F80**

Cantos arredondados:
- 12–16dip

---

### 1.4 Ícones (hexágonos)

Cor de fundo dos ícones (já definida e corrigida):

- ICON_BG  
  RGB(69, 90, 117)  
  HEX: **#455A75**

Ícones internos:
- Alumínio fosco
- Sem sombra
- Sem brilho externo
- Sem glow

---

### 1.5 Textos

- CARD_LABEL_TEXT  
  #FFFFFF com alpha 85–95%

- FOOTER_TEXT  
  #FFFFFF com alpha 55–65%

---

## 2) DECISÃO DE TEMA (IMPORTANTE)

### Tema único (RECOMENDADO)

✔ **Somente tema escuro / azul**  
✔ Não haverá light theme  
✔ Páginas internas usam o MESMO background da Home

Justificativa:
- Produto de segurança
- Evita distração
- Reduz bugs visuais
- Mantém identidade forte
- Não há ganho real em tema claro

---

## 3) ESTRUTURA DA HOME

### 3.1 Layout Geral

- Sem scroll
- Header fixo
- Grid 2×2 central
- Rodapé fixo

---

## 4) HEADER

### Conteúdo
- Esquerda: símbolo LockZero (24–28dip)
- Texto: “LockZero”
- Direita: menu ☰

### Medidas
- HEADER_HEIGHT: 56dip
- Padding horizontal: 16dip
- Padding vertical: 8dip

---

## 5) GRID DE CARDS (2×2)

### Margens externas
- Esquerda / direita: 18–20dip
- Topo: 18dip
- Base: 18dip (antes do rodapé)

### Espaçamento entre cards
- GRID_GAP: 14–16dip

---

## 6) CARD (CADA ITEM)

### Estrutura
- Card quadrado ou levemente retangular
- Fundo: CARD_BG
- Raio: 12–16dip

### Conteúdo
- Ícone (imagem)
- Label (texto – i18n)

---

## 7) POSICIONAMENTO DO ÍCONE (CRÍTICO)

O ícone **não fica centralizado geometricamente**.

### Regra:
- Centro vertical do ícone = **~42% da altura do card**
- Nunca 50%

Isso garante:
- Espaço inferior para label
- Melhor equilíbrio visual
- Conforto de toque

### Tamanho do ícone
- 52–60% da largura do card

---

## 8) LABEL DO CARD

### Regras
- Texto fora da imagem
- Sempre traduzido via i18n
- Alinhamento central

### Medidas
- Fonte: 14–16sp
- Espaço entre ícone e label: 10–12dip

---

## 9) RODAPÉ

### Conteúdo
- Linha 1: “Lock and Zero Worries”
- Linha 2: “Free Version” ou “Premium Version”
- Linha 3: versão (ex: v0.1.0)

### Estilo
- Texto discreto
- Centralizado
- Não clicável

---

## 10) PÁGINAS INTERNAS (SENHAS / CARTÕES / DOCS / NOTAS)

### Background
- Usar o MESMO HOME_BG (#1C3A6A)

### Header interno
- Mesmo HEADER_BG
- Breadcrumb simples (ex: Passwords > Work)

### Listas
- Fundo transparente ou ligeiramente mais escuro (#152F58)
- Nenhum branco
- Nenhum tema claro

---

## 11) ESTADOS VISUAIS

### Card vazio
- Ícone normal (sem efeito)

### Card com dados
- Mesmo ícone
- Destaque aplicado via UI (não no asset):
  - leve overlay
  - leve “ice” interno
  - background do card levemente alterado

Nunca:
- números
- badges
- texto extra

---

## 12) REGRA FINAL

> LockZero não muda aparência para parecer seguro.  
> LockZero muda comportamento para SER seguro.

---

END OF DOCUMENT
