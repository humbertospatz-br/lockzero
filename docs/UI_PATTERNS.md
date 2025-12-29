# UI PATTERNS - LockZero

**Versao:** 1.0
**Criado:** 2025-12-29
**Objetivo:** Padronizar a criacao de telas no LockZero

---

## ESTRUTURA PADRAO DE PAGINA

Toda pagina do LockZero segue esta estrutura:

```
+------------------------------------------+
|  HEADER (56dip)                          |
|  [<] [Titulo]              [Timer] [+]   |
+------------------------------------------+
|                                          |
|  CONTEUDO (ScrollView)                   |
|                                          |
|                                          |
+------------------------------------------+
```

---

## 1. CLASS_GLOBALS - Variaveis Necessarias

```vb
Sub Class_Globals
    Private Root As B4XView
    Private xui As XUI

    'UI - Header
    Private btnBack As Button
    Private lblHeaderTitle As Label

    'UI - Conteudo
    Private svContent As ScrollView
    Private pnlContent As B4XView

    'Timer de sessao no header
    Private lblSessionTimer As Label
    Private tmrSession As Timer

    'Dialog Overlay (se necessario)
    Private pnlOverlay As Panel
    Private pnlDialog As Panel
End Sub
```

---

## 2. INITIALIZE - Inicializacao do Timer

```vb
Public Sub Initialize
    tmrSession.Initialize("tmrSession", 1000)
End Sub
```

---

## 3. B4XPAGE_CREATED - Criacao da UI

```vb
Private Sub B4XPage_Created(Root1 As B4XView)
    Root = Root1
    CreateUI
    ApplyTheme
End Sub
```

---

## 4. B4XPAGE_APPEAR - Ativar Timer

```vb
Private Sub B4XPage_Appear
    'Define titulo na ActionBar
    CallSub2(Main, "SetPageTitle", ModLang.T("nome_da_pagina"))

    ModSession.Touch
    LoadData  'Carregar dados da pagina

    'Inicia timer de sessao
    UpdateSessionTimer
    tmrSession.Enabled = True
End Sub
```

---

## 5. B4XPAGE_DISAPPEAR - Desativar Timer

```vb
Private Sub B4XPage_Disappear
    tmrSession.Enabled = False
End Sub
```

---

## 6. CREATEUI - Montagem do Header

### 6.1 Estrutura Completa do Header

```vb
Private Sub CreateUI
    Dim width As Int = Root.Width
    Dim height As Int = Root.Height
    Dim headerH As Int = 56dip

    '===========================================
    ' HEADER
    '===========================================
    Dim pnlHeader As Panel
    pnlHeader.Initialize("")
    pnlHeader.Color = ModTheme.HomeHeaderBg
    Root.AddView(pnlHeader, 0, 0, width, headerH)

    '--- Botao Voltar (esquerda) ---
    btnBack.Initialize("btnBack")
    btnBack.Text = "<"
    btnBack.TextSize = 20
    btnBack.Color = Colors.Transparent
    btnBack.TextColor = Colors.White
    btnBack.Gravity = Gravity.CENTER
    pnlHeader.AddView(btnBack, 0, 0, 50dip, headerH)

    '--- Titulo (centro) ---
    lblHeaderTitle.Initialize("")
    lblHeaderTitle.Text = ModLang.T("titulo_pagina")
    lblHeaderTitle.TextSize = 16
    lblHeaderTitle.TextColor = Colors.White
    lblHeaderTitle.Typeface = Typeface.DEFAULT_BOLD
    lblHeaderTitle.Gravity = Gravity.CENTER_VERTICAL
    pnlHeader.AddView(lblHeaderTitle, 50dip, 0, width - 160dip, headerH)

    '--- Timer de Sessao (direita) ---
    lblSessionTimer.Initialize("lblSessionTimer")
    lblSessionTimer.Text = "00:00"
    lblSessionTimer.TextSize = 12
    lblSessionTimer.TextColor = Colors.ARGB(200, 255, 255, 255)
    lblSessionTimer.Gravity = Gravity.CENTER
    pnlHeader.AddView(lblSessionTimer, width - 110dip, 12dip, 55dip, 32dip)

    'Fundo arredondado para o timer (indica que e clicavel)
    Dim xvTimer As B4XView = lblSessionTimer
    xvTimer.SetColorAndBorder(Colors.ARGB(60, 255, 255, 255), 0, Colors.Transparent, 8dip)

    '--- Botao Adicionar (extrema direita) ---
    Dim lblAdd As Label
    lblAdd.Initialize("btnAdd")
    lblAdd.Text = "+"
    lblAdd.TextSize = 26
    lblAdd.Typeface = Typeface.DEFAULT_BOLD
    lblAdd.Gravity = Gravity.CENTER
    lblAdd.TextColor = Colors.White
    pnlHeader.AddView(lblAdd, width - 50dip, 8dip, 40dip, 40dip)

    'Arredondar o botao +
    Dim xvAdd As B4XView = lblAdd
    xvAdd.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModTheme.HomeIconBg, 20dip)

    '===========================================
    ' CONTEUDO (ScrollView)
    '===========================================
    svContent.Initialize(0)
    svContent.Color = ModTheme.HomeBg
    Root.AddView(svContent, 0, headerH, width, height - headerH)

    pnlContent = svContent.Panel
    pnlContent.Color = ModTheme.HomeBg

    '===========================================
    ' OVERLAY PARA DIALOGS (opcional)
    '===========================================
    CreateDialogOverlay
End Sub
```

### 6.2 Posicoes dos Elementos no Header

| Elemento | X | Y | Width | Height |
|----------|---|---|-------|--------|
| btnBack | 0 | 0 | 50dip | 56dip (headerH) |
| lblHeaderTitle | 50dip | 0 | width - 160dip | 56dip |
| lblSessionTimer | width - 110dip | 12dip | 55dip | 32dip |
| btnAdd (+) | width - 50dip | 8dip | 40dip | 40dip |

### 6.3 Header SEM Botao + (apenas timer)

Se a pagina nao tem botao de adicionar:

```vb
'--- Titulo (mais largo) ---
pnlHeader.AddView(lblHeaderTitle, 50dip, 0, width - 110dip, headerH)

'--- Timer de Sessao (extrema direita) ---
pnlHeader.AddView(lblSessionTimer, width - 60dip, 12dip, 55dip, 32dip)
```

---

## 7. FUNCOES DO TIMER

### 7.1 Timer Tick

```vb
Private Sub tmrSession_Tick
    ModSession.Touch
    UpdateSessionTimer

    'Verifica se sessao expirou
    If ModSession.IsSessionActive = False Then
        tmrSession.Enabled = False
        B4XPages.ClosePage(Me)
    End If
End Sub
```

### 7.2 Atualizar Display do Timer

```vb
Private Sub UpdateSessionTimer
    If ModSession.IsSessionActive Then
        lblSessionTimer.Text = ModSession.GetRemainingFormatted

        'Muda cor quando tempo baixo (< 60s)
        Dim remaining As Int = ModSession.GetRemainingSeconds
        If remaining < 60 Then
            lblSessionTimer.TextColor = ModTheme.Warning
        Else
            lblSessionTimer.TextColor = Colors.ARGB(200, 255, 255, 255)
        End If
    Else
        lblSessionTimer.Text = "00:00"
        lblSessionTimer.TextColor = ModTheme.Danger
    End If
End Sub
```

### 7.3 Click no Timer (Bloquear)

```vb
Private Sub lblSessionTimer_Click
    Wait For (xui.Msgbox2Async(ModLang.T("lock_confirm_msg"), ModLang.T("lock"), ModLang.T("yes"), "", ModLang.T("cancel"), Null)) Msgbox_Result(Result As Int)

    If Result = xui.DialogResponse_Positive Then
        tmrSession.Enabled = False
        ModSession.EndSession
        B4XPages.ClosePage(Me)
    End If
End Sub
```

---

## 8. EVENTOS DOS BOTOES

### 8.1 Botao Voltar

```vb
Private Sub btnBack_Click
    B4XPages.ClosePage(Me)
End Sub
```

### 8.2 Botao Adicionar

```vb
Private Sub btnAdd_Click
    ShowAddDialog
End Sub
```

---

## 9. DIALOG OVERLAY

### 9.1 Criar Overlay

```vb
Private Sub CreateDialogOverlay
    Dim width As Int = Root.Width
    Dim height As Int = Root.Height

    'Fundo escuro semi-transparente
    pnlOverlay.Initialize("pnlOverlay")
    pnlOverlay.Color = Colors.ARGB(180, 0, 0, 0)
    pnlOverlay.Visible = False
    Root.AddView(pnlOverlay, 0, 0, width, height)

    'Dialog box centralizado
    Dim dialogW As Int = width - 40dip
    Dim dialogH As Int = 200dip

    pnlDialog.Initialize("")
    pnlDialog.Color = ModTheme.HomeHeaderBg
    pnlOverlay.AddView(pnlDialog, 20dip, 100dip, dialogW, dialogH)
End Sub
```

### 9.2 Mostrar/Esconder Dialog

```vb
Private Sub ShowDialog
    pnlOverlay.Visible = True
End Sub

Private Sub HideDialog
    pnlOverlay.Visible = False
End Sub

Private Sub pnlOverlay_Click
    'Click fora do dialog fecha
    HideDialog
End Sub
```

---

## 10. TEMA

```vb
Private Sub ApplyTheme
    Root.Color = ModTheme.HomeBg
End Sub
```

---

## 11. CONSTANTES IMPORTANTES (Starter.bas)

### Fontes
| Constante | Valor | Uso |
|-----------|-------|-----|
| `Starter.FONT_TITLE` | 22 | Titulos de pagina |
| `Starter.FONT_SUBTITLE` | 18 | Subtitulos |
| `Starter.FONT_BODY` | 15 | Texto principal |
| `Starter.FONT_LABEL` | 13 | Labels |
| `Starter.FONT_CAPTION` | 12 | Textos pequenos |
| `Starter.FONT_BUTTON` | 14 | Botoes |

### Alturas
| Constante | Valor | Uso |
|-----------|-------|-----|
| `Starter.HEIGHT_HEADER` | 56dip | Header |
| `Starter.HEIGHT_BUTTON` | 48dip | Botoes |
| `Starter.HEIGHT_INPUT` | 48dip | EditText |
| `Starter.HEIGHT_ITEM` | 72dip | Item de lista |

### Espacamentos
| Constante | Valor | Uso |
|-----------|-------|-----|
| `Starter.MARGIN_PAGE` | 16dip | Margem lateral |
| `Starter.MARGIN_ITEM` | 12dip | Entre itens |
| `Starter.PADDING_CARD` | 16dip | Padding de cards |

---

## 12. CHECKLIST NOVA PAGINA

- [ ] Class_Globals com todas as variaveis
- [ ] Initialize com tmrSession
- [ ] B4XPage_Created chamando CreateUI e ApplyTheme
- [ ] B4XPage_Appear habilitando timer
- [ ] B4XPage_Disappear desabilitando timer
- [ ] Header com btnBack, lblHeaderTitle, lblSessionTimer
- [ ] Botao + se necessario
- [ ] ScrollView para conteudo
- [ ] Overlay para dialogs se necessario
- [ ] Funcoes do timer (Tick, Update, Click)
- [ ] ApplyTheme
- [ ] Textos usando ModLang.T()
- [ ] Cores usando ModTheme.*
- [ ] Fontes usando Starter.FONT_*

---

## 13. EXEMPLO COMPLETO MINIMO

Veja `PagePasswords.bas` ou `PagePasswordList.bas` como referencia completa.

---

**Documento criado por:** Claude + Humberto
**Projeto:** LockZero v0.1.0
