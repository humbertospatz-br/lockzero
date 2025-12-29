# LOCKZERO — UX DEFINITIONS
**Version:** 1.0.0  
**Date:** 2025-12-27  
**Product:** LockZero  
**Slogan:** Lock and Zero Worries  

---

## 1. UX PRINCIPLES

The LockZero UX is designed around **behavioral security**, not visual theatrics.

Core principles:
- No cloud assumptions
- No user accounts
- No recovery illusions
- No unnecessary explanations
- Security is felt through behavior, not shown through icons

> **Rule:**  
> LockZero never *looks* secure.  
> LockZero *behaves* secure.

---

## 2. HOME SCREEN (ENTRY POINT)

### 2.1 Purpose

The Home screen exists only to:
- Allow access to secure categories
- Act as a neutral entry gate
- Never expose content, quantity, or metadata

The Home is a **door**, not a room.

---

### 2.2 Header

Layout:

[ LOGO ] LockZero ☰


- Left: LockZero symbol (icon)
- Center-left: “LockZero” text
- Right: Menu icon (☰)

No profile icon.  
No login indicator.  
No animations.

---

### 2.3 Home Grid

Structure:
- 2 × 2 grid
- No scroll
- One screen only

Cards:
- Passwords
- Cards
- Documents
- Notes

Each card contains:
- Category icon
- Category label

Nothing else.

---

### 2.4 Footer

Footer displays only:

Free Version
vX.Y.Z

orPremium Version
vX.Y.Z


- Muted color
- Centered
- Not clickable

Purpose: transparency, not marketing.

---

## 3. HOME STATES

### 3.1 Normal State

Conditions:
- App opened
- Session active or inactive

Behavior:
- Home looks identical in all cases
- No visual lock indicators

---

### 3.2 Session Expired

Condition:
- Session timeout reached

Behavior:
- Home remains visually unchanged
- Any card tap triggers passphrase dialog

---

### 3.3 Temporarily Locked (Brute Force Delay)

Condition:
- Too many incorrect passphrase attempts

Behavior:
- Home visible
- Card tap shows message:

Temporarily locked
Try again later


No timers.  
No counters.

---

## 4. CARD TAP FLOW (REFERENCE: PASSWORDS)

This flow is the **pattern** for all categories.

---

### 4.1 Home → Tap Category

System decision (invisible to user):

IF session is active
→ Open category page
ELSE
→ Request passphrase


User does not choose.

---

### 4.2 Passphrase Dialog

Characteristics:
- Modal
- Centered
- Background dimmed
- No swipe to dismiss

Content:

Unlock Passwords

[ *************** ]
Passphrase

[ Unlock ]


- Keyboard opens immediately
- Unlock button disabled until input

---

### 4.3 Incorrect Passphrase

Message:

Wrong passphrase


- No explanation
- No warnings
- Delay logic runs silently

---

## 5. PASSWORD GROUP PAGE

### 5.1 Header

Passwords +


- “+” exists only here
- No creation from Home

---

### 5.2 Group Page States

#### Empty State

No password groups yet

[ + Create Group ]


Single action.  
No illustration.  
No explanation.

---

#### Populated State

Example:

Personal • 5
Work • 12
Crypto • 3


- Group name
- Entry count
- Chevron indicator

---

## 6. PASSWORD LIST PAGE

### 6.1 Header (Breadcrumb)

Passwords > Work +


---

### 6.2 List States

#### Empty

No passwords yet

[ + Add Password ]


---

#### Populated

Each item shows:
- Entry name
- Username
- Favorite indicator (optional)
- Copy icon (if allowed)

Passwords are never visible by default.

---

## 7. PASSWORD ITEM STATES

### 7.1 Hidden (Default)

Password: ••••••••
[ Show ]


---

### 7.2 Temporarily Visible

Condition:
- User taps “Show”

Behavior:
- Password revealed for limited time
- Automatically hidden again
- Memory cleared

---

## 8. SESSION MANAGEMENT

### 8.1 Session Expiration

Condition:
- Inactivity timeout

Behavior:
- Current page closes
- User returned to Home
- Toast message:

Session expired


No confirmation dialogs.

---

## 9. ERROR STATES (GLOBAL RULES)

- No emojis
- No explanations
- No technical language
- No blame

Messages are short, factual, and silent.

---

## 10. CATEGORY CONSISTENCY

The same UX rules apply to:
- Cards
- Documents
- Notes

Only content fields differ.  
All flows remain identical.

---

## 11. UX GOLDEN RULE

> **LockZero never changes its appearance to appear secure.  
> It changes behavior to be secure.**

---

## END OF DOCUMENT



#OnBoarding

##Tela 1
Welcome to LockZero
(Texto curto)

LockZero stores your information
entirely offline.

Nothing is sent.
Nothing is synced.
Nothing is shared.

(Texto centralizado
Tipografia simples
Muito espaço em branco)

Botão
Continue

##Tela2

Important

LockZero has no recovery.

If you forget your passphrase,
your data is permanently inaccessible.

No reset.
No backup recovery.
No support access.
(Sem negrito excessivo.
Sem ícones de alerta.)

Checkbox obrigatório
[ ] I understand and accept the risk

( ⚠️ Regra:
Botão desabilitado até marcar
Estado persistido (settings.onboarding_accepted = true))

Botão
Continue

##Tela3

You're in control

Your data stays with you.
Always.

Botão
Start using LockZero

Ao tocar:

Onboarding finalizado
Vai direto para Home

--------------------------
UX Rule (documentar)

The onboarding of LockZero exists to protect the product,
not to retain the user.

