# DICAS B4A - LockZero

Dicas e truques descobertos durante o desenvolvimento.
(Originalmente criado para LockSeed, atualizado para LockZero)

---

## 1. Borda em EditText

Para adicionar borda arredondada em EditText:

```vb
Dim cd As ColorDrawable
' Parametros: cor fundo, raio borda, largura borda, cor borda
cd.Initialize2(Colors.White, 5dip, 1dip, Colors.Black)
edt.Background = cd
```

Exemplo com cor cinza clara:
```vb
cd.Initialize2(Colors.RGB(243, 243, 243), 5dip, 1dip, Colors.Black)
```

---

## 2. Label como Botao (evita tema do sistema)

Usar Label em vez de Button para manter aparencia consistente:

```vb
Dim lblAdd As Label
lblAdd.Initialize("btnAdd")
lblAdd.Text = "+"
lblAdd.TextSize = 28
lblAdd.Typeface = Typeface.DEFAULT_BOLD
lblAdd.Gravity = Gravity.CENTER
lblAdd.Color = ModTheme.GetPrimaryColor
lblAdd.TextColor = Colors.White
pnlHeader.AddView(lblAdd, 100%x - 52dip, 10dip, 40dip, 40dip)

' Arredonda o label
Dim xvAdd As B4XView = lblAdd
xvAdd.SetColorAndBorder(ModTheme.GetPrimaryColor, 0, ModTheme.GetPrimaryColor, 20dip)
```

---

## 3. Panel com borda arredondada

```vb
Dim xvItem As B4XView = pnlItem
xvItem.SetColorAndBorder(ModTheme.GetPanelColor, 1dip, ModTheme.GetBorderColor, 8dip)
```

---

## 4. Mostrar/Ocultar senha em EditText

```vb
' Mostrar
edtPassword.InputType = edtPassword.INPUT_TYPE_TEXT

' Ocultar (mascara)
edtPassword.InputType = Bit.Or(edtPassword.INPUT_TYPE_TEXT, 128)

' Manter cursor no final
edtPassword.SelectionStart = edtPassword.Text.Length
```

---

## 5. Subir tela quando teclado aparece

**ATENCAO:** `Activity.Top` causa `ClassCastException` em alguns dispositivos!

### Solucao correta - Mover pnlHeader e svMain:

```vb
Sub edtCampo_FocusChanged(HasFocus As Boolean)
    If HasFocus Then
        ' Move o header e ScrollView para cima
        pnlHeader.Top = -200dip
        svMain.Top = 60dip - 200dip
    Else
        ' Restaura posicao original
        RestoreScreenPosition
    End If
End Sub

Private Sub RestoreScreenPosition
    If pnlHeader.Top <> 0 Then
        pnlHeader.Top = 0
        svMain.Top = 60dip
    End If
End Sub

' Restaura quando usuario faz scroll
Sub svMain_ScrollChanged(Position As Int)
    If pnlHeader.Top < 0 Then
        RestoreScreenPosition
    End If
End Sub
```

### NAO usar (causa erro em alguns dispositivos):

```vb
' ERRADO - ClassCastException em FrameLayout
Activity.Top = -offset
```

**Nota:** Mover paineis individuais (pnlHeader, svMain) e seguro. Mover Activity.Top pode causar ClassCastException.

---

## 6. Compilacao Condicional

### O que e?

Permite incluir/excluir blocos de codigo baseado em simbolos definidos no Build Configuration.

### Sintaxe basica:

```vb
#If SIMBOLO
    ' codigo incluido apenas quando SIMBOLO esta definido
#End If
```

### Onde pode usar:

| Local | Funciona? | Exemplo |
|-------|-----------|---------|
| Codigo (.bas) | Sim | Variaveis, constantes, funcoes |
| #ApplicationLabel | Sim | Nome do app por versao |
| #VersionCode | Sim | Versao por build |
| Qualquer #Region | Sim | Project Attributes, Activity Attributes |

### Exemplo - ApplicationLabel condicional:

```vb
#If F
    #ApplicationLabel: LockSeed Free
#End If

#If G
    #ApplicationLabel: LockSeed Gold
#End If

#If P
    #ApplicationLabel: LockSeed Premium
#End If
```

### Exemplo - Constantes condicionais:

```vb
#If F
    Public Const APP_VERSION As String = "FREE"
#End If

#If G
    Public Const APP_VERSION As String = "GOLD"
#End If

#If P
    Public Const APP_VERSION As String = "PREMIUM"
#End If
```

### Vantagem:

- **Antes:** Editar manualmente varios arquivos antes de cada build
- **Depois:** Apenas selecionar no dropdown e compilar!

---

## 7. Build Configurations

### Como criar:

1. Menu `Project > Build Configurations`
2. Clique em `Create New`
3. Preencha:
   - **Configuration Name:** nome (ex: free, gold, premium)
   - **Package:** package name (ex: com.lockseed.f)
   - **Conditional Symbols:** simbolo (ex: F, G, P)
4. Clique OK

### Como usar:

1. Na barra de ferramentas do B4A IDE
2. Dropdown ao lado de "Release (obfuscated)"
3. Selecione a configuracao desejada
4. Compile normalmente (F5)

```
Dropdown na IDE:
┌─────────────┐
│ free        │  ← Simbolo F, Package com.lockseed.f
│ gold        │  ← Simbolo G, Package com.lockseed.g
│ premium     │  ← Simbolo P, Package com.lockseed.p
└─────────────┘
```

---

## 8. Intent de Compartilhamento

### Forma correta no B4A:

```vb
Dim intent As Intent
intent.Initialize(intent.ACTION_SEND, "")
intent.SetType("text/plain")
intent.PutExtra("android.intent.extra.TEXT", "Texto para compartilhar")
intent.PutExtra("android.intent.extra.SUBJECT", "Assunto")
StartActivity(intent)
```

### ERRADO - CreateChooser nao existe no B4A:

```vb
' NAO FUNCIONA:
Dim chooser As Intent = intent.CreateChooser(intent, "Titulo")
```

O Android ja mostra automaticamente o menu de compartilhamento quando usa `ACTION_SEND`.

---

## 9. Msgbox Deprecated

### Aviso:

```
Msgbox and other modal dialogs are deprecated. Use the async methods instead.
```

### Solucao - Usar Msgbox2Async:

```vb
' Antes (deprecated):
Msgbox("Mensagem", "Titulo")

' Depois (async):
Wait For (Msgbox2Async("Mensagem", "Titulo", "OK", "", "", Null, False)) Msgbox_Result(Result As Int)
```

### Para confirmacao:

```vb
Wait For (Msgbox2Async("Deseja excluir?", "Confirmar", "Sim", "", "Nao", Null, False)) Msgbox_Result(Result As Int)
If Result = DialogResponse.POSITIVE Then
    ' Usuario clicou Sim
End If
```

---

## 10. Modulos e Activities

### Adicionar modulo existente ao projeto:

1. Copie o arquivo .bas para a pasta do projeto
2. No B4A: `Project > Add New Module > Activity/Class/Code Module`
3. Selecione "Add Existing Module"
4. Escolha o arquivo .bas

### Ou edite manualmente o .b4a:

```
Module23=NomeDoModulo
NumberOfModules=23
```

**Nota:** O B4A IDE pode reorganizar os modulos ao salvar.

---

## 11. Empty Catch Block Warning

### Aviso:

```
Empty Catch block. You should at least add Log(LastException.Message).
```

### Solucao:

```vb
Try
    ' codigo que pode falhar
Catch
    Log("Erro: " & LastException.Message)
End Try
```

---

## 12. Unused Variable Warning

### Aviso:

```
Unused variable 'NomeDaVariavel'. (warning #9)
```

### Solucoes:

1. Remover a variavel se nao for usar
2. Usar a variavel em algum lugar
3. Prefixar com underscore para indicar intencional: `_NomeDaVariavel`

---

## 13. StringUtils - Funcoes Uteis

### Base64:

```vb
Dim su As StringUtils

' Encode
Dim encoded As String = su.EncodeBase64(dados)

' Decode
Dim decoded() As Byte = su.DecodeBase64(encoded)
```

### Medir texto multilinha:

```vb
Dim altura As Int = su.MeasureMultilineTextHeight(label, texto)
```

---

## 14. Gravar/Ler Arquivos Simples

### Texto:

```vb
' Gravar
File.WriteString(File.DirInternal, "arquivo.txt", conteudo)

' Ler
Dim conteudo As String = File.ReadString(File.DirInternal, "arquivo.txt")

' Verificar se existe
If File.Exists(File.DirInternal, "arquivo.txt") Then
    ' existe
End If
```

### JSON:

```vb
' Gravar
Dim gen As JSONGenerator
gen.Initialize(mapa)
File.WriteString(File.DirInternal, "dados.json", gen.ToString)

' Ler
Dim parser As JSONParser
parser.Initialize(File.ReadString(File.DirInternal, "dados.json"))
Dim mapa As Map = parser.NextObject
```

---

## 15. Cores e Temas

### Cores basicas:

```vb
Colors.White
Colors.Black
Colors.Transparent
Colors.RGB(255, 0, 0)  ' Vermelho
Colors.ARGB(128, 0, 0, 0)  ' Preto 50% transparente
```

### Aplicar cor de fundo:

```vb
Activity.Color = Colors.White
Panel1.Color = Colors.RGB(240, 240, 240)
```

---

## 16. Detectar Teclado com IME

### Biblioteca necessaria:
- IME (Input Method Editor)

### Manifest (Activity Attributes):
```vb
SetActivityAttribute(ActWalletForm, android:windowSoftInputMode, adjustResize|stateHidden)
```

### Inicializacao:
```vb
' Globals
Private IME1 As IME

' Activity_Create
IME1.Initialize("IME1")
IME1.AddHeightChangedEvent  ' Ativa deteccao de teclado
```

### Evento - Detectar abertura/fechamento:
```vb
Sub IME1_HeightChanged(NewHeight As Int, OldHeight As Int)
    If NewHeight > OldHeight Then
        ' Teclado foi ESCONDIDO (area visivel AUMENTOU)
        Log("Teclado fechado")
    Else If NewHeight < OldHeight Then
        ' Teclado foi ABERTO (area visivel DIMINUIU)
        Log("Teclado aberto")
    End If
End Sub
```

### Logica dos valores:
- `NewHeight > OldHeight` = Teclado ESCONDIDO (area visivel aumentou, teclado saiu)
- `NewHeight < OldHeight` = Teclado ABERTO (area visivel diminuiu, teclado entrou)

### Exemplo completo - Subir tela quando teclado abre:
```vb
Sub edtCampo_FocusChanged(HasFocus As Boolean)
    If HasFocus Then
        ' Move paineis para cima
        pnlHeader.Top = -100dip
        svMain.Top = 60dip - 100dip
    End If
End Sub

Sub IME1_HeightChanged(NewHeight As Int, OldHeight As Int)
    If NewHeight > OldHeight And pnlHeader.Top < 0 Then
        ' Teclado fechado (area aumentou) - restaura posicao
        pnlHeader.Top = 0
        svMain.Top = 60dip
    End If
End Sub
```

---

## 17. ScrollView - Campo visível com Teclado (Solução Completa)

### Problema:
Quando um EditText no final de um ScrollView recebe foco, o teclado cobre o campo.

### Solução Completa (3 partes):

#### Parte 1 - Padding extra no ScrollView:
```vb
' Ao final da criação do conteúdo:
svMain.Panel.Height = top + 300dip  ' espaço extra para scroll
```

#### Parte 2 - Globals e Activity_Create:
```vb
' Globals
Private IME1 As IME
Private SavedScrollPosition As Int = 0

' Activity_Create
IME1.Initialize("IME1")
IME1.AddHeightChangedEvent
```

#### Parte 3 - Eventos de Foco e IME:
```vb
' Guarda posição do campo
edtPIN.Tag = top
svMain.Panel.AddView(edtPIN, margin, top, fieldW, 40dip)

' Quando campo recebe foco - salva posição e rola
Sub edtPIN_FocusChanged(HasFocus As Boolean)
    If HasFocus Then
        SavedScrollPosition = svMain.ScrollPosition
        Dim pinTop As Int = edtPIN.Tag
        svMain.ScrollPosition = Max(0, pinTop - 250dip)
    End If
End Sub

' Quando teclado fecha - restaura posição
Sub IME1_HeightChanged(NewHeight As Int, OldHeight As Int)
    If NewHeight > OldHeight Then
        ' Teclado fechou (área visível aumentou)
        svMain.ScrollPosition = SavedScrollPosition
    End If
End Sub
```

### Valores de referência:
- `Panel.Height = top + 300dip` - espaço extra para scroll
- `pinTop - 250dip` - margem superior (ajustar conforme posição do campo)
- Campos mais no topo: margem menor (100-150dip)
- Campos mais embaixo: margem maior (200-300dip)

---

## 18. Google Play - Orientacao Obrigatoria

### Requisito:
O Google Play exige que aplicativos funcionem em **qualquer orientacao** (portrait e landscape).

### Solucao:
Criar UI que se adapta ao tamanho da tela:

```vb
Private Sub CreateUI
    Dim width As Int = Root.Width
    Dim height As Int = Root.Height

    ' Usar porcentagens em vez de valores fixos
    pnlContent.AddView(edtField, 40dip, height * 0.3, width - 80dip, 50dip)
End Sub
```

### Manifest:
NAO usar `android:screenOrientation="portrait"` a menos que seja essencial.

---

## 19. Botao Escondido pelo Teclado - Solucao com Height

### Problema:
Quando teclado aparece, botoes na parte inferior ficam escondidos.

### Solucao - Aumentar Height do Painel:
Em vez de usar ScrollView, aumentar a altura do painel para "subir" o conteudo:

```vb
Private Sub CreateUI
    Dim width As Int = Root.Width
    Dim height As Int = Root.Height

    ' Aumentar altura do painel para subir elementos
    Dim extraHeight As Int = 200dip  ' Ajustar conforme necessario

    pnlUnlock = xui.CreatePanel("")
    pnlUnlock.SetLayoutAnimated(0, 0, 0, width, height + extraHeight)
    Root.AddView(pnlUnlock, 0, 0, width, height)

    ' Posicionar elementos mais acima
    Dim startY As Int = 50dip  ' Comecar mais no topo

    lblLogo.AddView(pnlUnlock, 0, startY, width, 60dip)
    edtPassphrase.AddView(pnlUnlock, 40dip, startY + 100dip, width - 80dip, 50dip)
    btnUnlock.AddView(pnlUnlock, 40dip, startY + 170dip, width - 80dip, 50dip)
End Sub
```

### Alternativa - Posicionar elementos mais acima:
```vb
' Em vez de height * 0.45, usar valor fixo menor
edtPassphrase.Top = 150dip  ' Mais perto do topo
btnUnlock.Top = 220dip
```

---

## 20. B4XPages - Registrar Paginas Corretamente

### Problema:
`Error: page id not found: PagePasswords`
`Ids: (ArrayList) [mainpage]`

### Solucao - Declarar em Process_Globals:
```vb
Sub Process_Globals
    Private xui As XUI
    'Paginas B4XPages
    Public pgPasswords As PagePasswords
    Public pgPasswordList As PagePasswordList
    Public pgBackup As PageBackup
End Sub

Sub Activity_Create(FirstTime As Boolean)
    Activity.LoadLayout("Main")

    If FirstTime Then
        'Inicializar paginas
        pgPasswords.Initialize
        pgPasswordList.Initialize
        pgBackup.Initialize

        'Registrar paginas
        B4XPages.AddPage("PagePasswords", pgPasswords)
        B4XPages.AddPage("PagePasswordList", pgPasswordList)
        B4XPages.AddPage("PageBackup", pgBackup)
    End If
End Sub
```

### ERRADO - Usar classe diretamente:
```vb
' NAO funciona - classe nao instanciada
B4XPages.AddPage("PagePasswords", PagePasswords)
B4XPages.AddPageAndCreate("PagePasswords", PagePasswords)
```

### CORRETO - Usar instancia:
```vb
' Declarar variavel da pagina
Public pgPasswords As PagePasswords

' Inicializar
pgPasswords.Initialize

' Registrar com instancia
B4XPages.AddPage("PagePasswords", pgPasswords)
```

### IMPORTANTE - Globals vs Process_Globals:
```vb
' ERRADO - Causa erro "Cannot access activity object from sub Process_Globals"
Sub Process_Globals
    Public pgPasswords As PagePasswords  ' ERRO!
End Sub

' CORRETO - Paginas B4XPages devem ficar em Globals
Sub Globals
    Private pgPasswords As PagePasswords  ' OK!
End Sub
```

**Regra:** Classes que referenciam Activity (como paginas B4XPages) NAO podem ser declaradas em Process_Globals.

---

## 21. Globals vs Process_Globals - Quando Usar Cada

### Process_Globals:
- Variaveis que persistem entre Activities
- Tipos primitivos (Int, String, Boolean, etc.)
- Objetos que NAO referenciam Activity
- Modulos de codigo (Code Modules)

```vb
Sub Process_Globals
    Private xui As XUI           ' OK - XUI e seguro
    Private IsInitialized As Boolean  ' OK - tipo primitivo
    Private MyList As List       ' OK - lista generica
End Sub
```

### Globals:
- Variaveis especificas da Activity
- Views (Button, Label, Panel, etc.)
- Classes que referenciam Activity
- Paginas B4XPages

```vb
Sub Globals
    Private btnSave As Button    ' OK - View de Activity
    Private pgPasswords As PagePasswords  ' OK - Pagina B4XPages
    Private pnlMain As Panel     ' OK - Panel de Activity
End Sub
```

### ERROS COMUNS:
```vb
' ERRADO - Views em Process_Globals
Sub Process_Globals
    Private btnSave As Button    ' ERRO! View nao pode ficar aqui
End Sub

' ERRADO - Paginas B4XPages em Process_Globals
Sub Process_Globals
    Private pgPasswords As PagePasswords  ' ERRO!
End Sub
```

---

## 22. B4XPages - Arquivo .b4a e a Main Activity

### Estrutura B4XPages:
Em projetos B4XPages, o arquivo `.b4a` (ex: `lockzero.b4a`) E a Main Activity, NAO um arquivo Main.bas separado.

### Onde registrar paginas:
```vb
' No arquivo .b4a (lockzero.b4a)

Sub Globals
    'Paginas devem ficar em Globals, NAO Process_Globals
    Private pgPasswords As PagePasswords
    Private pgBackup As PageBackup
End Sub

Sub Activity_Create(FirstTime As Boolean)
    Dim pm As B4XPagesManager
    pm.Initialize(Activity)

    If FirstTime Then
        'Inicializar e registrar paginas APOS pm.Initialize
        pgPasswords.Initialize
        pgBackup.Initialize

        B4XPages.AddPage("PagePasswords", pgPasswords)
        B4XPages.AddPage("PageBackup", pgBackup)
    End If
End Sub
```

### NAO criar Main.bas separado:
Em B4XPages, todo o codigo de inicializacao vai no arquivo `.b4a`.
Arquivos Main.bas adicionais podem causar confusao.

---

## 23. Palavras Reservadas do B4A

### Lista de palavras que NAO podem ser usadas como nomes de variaveis:

| Palavra | Alternativa |
|---------|-------------|
| `step` | `stepNum`, `currentStep` |
| `Initialized` | `mInitialized`, `isInit` |
| `Result` | `dialogResult`, `retVal` |
| `Error` | `errorMsg`, `lastError` |
| `Type` | `itemType`, `entryType` |

### Exemplo - Renomear variavel reservada:
```vb
' ERRADO
Private step As Int = 0
Private Initialized As Boolean = False

' CORRETO
Private stepNum As Int = 0
Private mInitialized As Boolean = False
```

---

## 24. Constantes Publicas - Somente em Class_Globals

### ERRADO - Constantes fora de Class_Globals:
```vb
' Isso causa erro de compilacao
Public Const MY_VALUE As String = "teste"

Sub Class_Globals
    ' ...
End Sub
```

### CORRETO - Constantes dentro de Class_Globals:
```vb
Sub Class_Globals
    Public Const MY_VALUE As String = "teste"  ' OK!
End Sub
```

### Alternativa - Usar variaveis ou strings literais:
```vb
' Em vez de constante, usar string literal diretamente
If ProtectionType = "PHRASE" Then  ' String literal

' Ou usar variavel privada
Private ProtectionPhrase As String = "PHRASE"
```

---

## 25. Padrao de UI - Tamanhos e Fontes (OBRIGATORIO)

### Por que padronizar?

- Consistencia visual em todas as telas
- Facilita manutencao (alterar em um lugar, reflete em todo app)
- Evita tamanhos "magicos" espalhados pelo codigo

### Constantes Definidas em Starter.bas:

```vb
'=== PADRAO DE UI - TAMANHOS DE FONTE ===
Public Const FONT_TITLE As Float = 22       'Titulos de pagina
Public Const FONT_SUBTITLE As Float = 18    'Subtitulos, headers de secao
Public Const FONT_BODY As Float = 15        'Texto principal
Public Const FONT_LABEL As Float = 13       'Labels de campo
Public Const FONT_CAPTION As Float = 12     'Textos pequenos, hints
Public Const FONT_BUTTON As Float = 14      'Texto de botoes
Public Const FONT_INPUT As Float = 15       'Texto em campos de entrada

'=== PADRAO DE UI - ALTURAS ===
Public Const HEIGHT_HEADER As Int = 56      'Altura do header (dip)
Public Const HEIGHT_BUTTON As Int = 48      'Altura padrao de botao (dip)
Public Const HEIGHT_INPUT As Int = 48       'Altura de EditText (dip)
Public Const HEIGHT_ITEM As Int = 72        'Altura de item de lista (dip)
Public Const HEIGHT_ITEM_LARGE As Int = 88  'Item com mais info (dip)

'=== PADRAO DE UI - ESPACAMENTOS ===
Public Const MARGIN_PAGE As Int = 16        'Margem lateral da pagina (dip)
Public Const MARGIN_ITEM As Int = 12        'Espaco entre itens (dip)
Public Const PADDING_CARD As Int = 16       'Padding interno de cards (dip)

'=== ICONES UNICODE ===
Public Const ICON_EYE_OPEN As String = Chr(0x1F441)   'Olho aberto
Public Const ICON_EYE_CLOSED As String = Chr(0x2022) & Chr(0x2022) & Chr(0x2022) 'Pontos
Public Const ICON_BACK As String = Chr(0x2190)        'Seta esquerda
Public Const ICON_LOCK As String = Chr(0x1F512)       'Cadeado fechado
Public Const ICON_STAR As String = Chr(0x2605)        'Estrela favorito
Public Const ICON_SETTINGS As String = Chr(0x2699)    'Engrenagem
```

### Como Usar:

```vb
' ERRADO - Valores magicos
lblTitle.TextSize = 22
btnSave.TextSize = 14
edtName.TextSize = 15
pnlHeader.Height = 56dip

' CORRETO - Usar constantes
lblTitle.TextSize = Starter.FONT_TITLE
btnSave.TextSize = Starter.FONT_BUTTON
edtName.TextSize = Starter.FONT_INPUT
pnlHeader.Height = Starter.HEIGHT_HEADER & "dip"
```

### Exemplo Completo - Criar Header:

```vb
Private Sub CreateHeader
    pnlHeader.Initialize("")
    pnlHeader.Color = ModTheme.HeaderBackground
    Root.AddView(pnlHeader, 0, 0, Root.Width, Starter.HEIGHT_HEADER & "dip")

    lblTitle.Initialize("")
    lblTitle.Text = ModLang.T("page_title")
    lblTitle.TextSize = Starter.FONT_SUBTITLE
    lblTitle.TextColor = ModTheme.HeaderText
    pnlHeader.AddView(lblTitle, Starter.MARGIN_PAGE & "dip", 0, Root.Width - 100dip, Starter.HEIGHT_HEADER & "dip")

    btnBack.Initialize("btnBack")
    btnBack.Text = Starter.ICON_BACK
    btnBack.TextSize = 20
    pnlHeader.AddView(btnBack, 8dip, 8dip, 40dip, 40dip)
End Sub
```

### Exemplo - Criar Campo de Entrada:

```vb
Private Sub CreateInputField(parent As B4XView, y As Int, hint As String) As EditText
    Dim edt As EditText
    edt.Initialize("")
    edt.Hint = hint
    edt.TextSize = Starter.FONT_INPUT
    edt.TextColor = ModTheme.InputText
    edt.HintColor = ModTheme.InputHint
    parent.AddView(edt, Starter.MARGIN_PAGE & "dip", y, parent.Width - (Starter.MARGIN_PAGE * 2) & "dip", Starter.HEIGHT_INPUT & "dip")
    Return edt
End Sub
```

### Exemplo - Item de Lista:

```vb
Private Sub CreateListItem(parent As B4XView, y As Int, title As String, subtitle As String) As Panel
    Dim pnl As Panel
    pnl.Initialize("pnlItem")
    pnl.Color = ModTheme.CardBackground
    parent.AddView(pnl, Starter.MARGIN_PAGE & "dip", y, parent.Width - (Starter.MARGIN_PAGE * 2) & "dip", Starter.HEIGHT_ITEM & "dip")

    Dim lblTitle As Label
    lblTitle.Initialize("")
    lblTitle.Text = title
    lblTitle.TextSize = Starter.FONT_BODY
    lblTitle.TextColor = ModTheme.TextPrimary
    pnl.AddView(lblTitle, Starter.PADDING_CARD & "dip", 12dip, pnl.Width - 60dip, 24dip)

    Dim lblSub As Label
    lblSub.Initialize("")
    lblSub.Text = subtitle
    lblSub.TextSize = Starter.FONT_LABEL
    lblSub.TextColor = ModTheme.TextSecondary
    pnl.AddView(lblSub, Starter.PADDING_CARD & "dip", 36dip, pnl.Width - 60dip, 20dip)

    Return pnl
End Sub
```

### Icones de Visibilidade (Olho):

```vb
' Botao de mostrar/ocultar senha
btnShowPass.Initialize("btnShowPass")
btnShowPass.Text = Starter.ICON_EYE_OPEN  ' Olho aberto = senha oculta
btnShowPass.TextSize = 18

Private Sub btnShowPass_Click
    PassVisible = Not(PassVisible)
    If PassVisible Then
        edtPassword.InputType = edtPassword.INPUT_TYPE_TEXT
        btnShowPass.Text = Starter.ICON_EYE_CLOSED  ' Pontos = senha visivel
    Else
        edtPassword.InputType = Bit.Or(edtPassword.INPUT_TYPE_TEXT, 128)
        btnShowPass.Text = Starter.ICON_EYE_OPEN    ' Olho = senha oculta
    End If
End Sub
```

### REGRA DE OURO:

> **NUNCA use numeros magicos para tamanhos de fonte ou altura de elementos.**
> **SEMPRE use as constantes de Starter.FONT_* e Starter.HEIGHT_*.**

---

## 26. AdjustResize no Manifest - Scroll Automatico com Teclado

### Problema:
Em varias telas com formularios, quando o teclado aparece ele cobre os campos de entrada.

### Solucao Simples - Manifest:

Adicionar no ManifestCode do arquivo `.b4a`:

```vb
SetActivityAttribute(Main, android:windowSoftInputMode, "adjustResize|stateHidden")
```

### O que faz:
- `adjustResize` - Redimensiona a Activity quando o teclado aparece, fazendo o ScrollView funcionar automaticamente
- `stateHidden` - O teclado comeca oculto (nao aparece sozinho ao abrir tela)

### Onde adicionar:
No arquivo `.b4a` (ex: `lockzero.b4a`), na linha ManifestCode:

```
ManifestCode='...~\n~'Keyboard scroll fix - adjustResize~\n~SetActivityAttribute(Main, android:windowSoftInputMode, "adjustResize|stateHidden")~\n~'End of default text.~\n~
```

### Vantagens:
- Solucao global - funciona em TODAS as paginas automaticamente
- Nao precisa de codigo extra nas paginas
- Nao precisa da biblioteca IME
- Nao precisa de eventos FocusChanged

### Quando usar solucao manual (dicas #16 e #17):
- Se precisar de controle fino sobre o comportamento
- Se quiser detectar quando o teclado abre/fecha
- Se o adjustResize nao resolver casos especificos

### IMPORTANTE:
Apos adicionar no manifest, as paginas com ScrollView devem funcionar automaticamente.
O Android vai redimensionar a tela e o ScrollView vai permitir rolar ate o campo focado.

---

## 27. ImageView - Gravity.FILL para Imagens (OBRIGATORIO)

### Problema:
Quando se usa `Gravity.CENTER` em ImageView, a imagem pode nao preencher o espaco corretamente, aparecendo cortada ou distorcida.

### Solucao - SEMPRE usar Gravity.FILL:

```vb
Dim iv As ImageView
iv.Initialize("")
iv.Gravity = Gravity.FILL  ' OBRIGATORIO para imagens
pnl.AddView(iv, x, y, width, height)
iv.Bitmap = LoadBitmap(File.DirAssets, "imagem.png")
```

### ERRADO - Gravity.CENTER:
```vb
' NAO USAR para imagens
iv.Gravity = Gravity.CENTER  ' Imagem pode ficar cortada/distorcida
```

### CORRETO - Gravity.FILL:
```vb
' SEMPRE usar para imagens
iv.Gravity = Gravity.FILL  ' Imagem preenche o espaco corretamente
```

### Quando usar cada Gravity:

| Gravity | Uso |
|---------|-----|
| `Gravity.FILL` | ImageView com imagens (PNG, JPG, etc.) |
| `Gravity.CENTER` | Labels, Buttons, texto em geral |

### Exemplo completo - Carregar icone:

```vb
Private Sub CreateIconView(parent As Panel, iconFile As String, x As Int, y As Int, size As Int)
    Dim iv As ImageView
    iv.Initialize("")
    iv.Gravity = Gravity.FILL  ' IMPORTANTE!
    parent.AddView(iv, x, y, size, size)

    Try
        iv.Bitmap = LoadBitmap(File.DirAssets, iconFile)
    Catch
        Log("Erro ao carregar " & iconFile & ": " & LastException.Message)
    End Try
End Sub
```

### REGRA DE OURO:

> **SEMPRE use Gravity.FILL para ImageView.**
> **Gravity.CENTER e para texto (Label, Button).**

---

## 28. xui.Msgbox2Async - Parametros Corretos

### ATENCAO - ClassCastException!

O ultimo parametro de `xui.Msgbox2Async` e para **BITMAP (icone)**, NAO para panel customizado!

### ERRO - Passa panel como ultimo parametro:
```vb
' ERRADO - Causa ClassCastException
Dim pnl As B4XView = xui.CreatePanel("")
' ... adiciona campos ao pnl ...
Wait For (xui.Msgbox2Async("", "Titulo", "OK", "", "Cancelar", pnl, False)) Msgbox_Result(Result As Int)

' Erro: java.lang.ClassCastException: anywheresoftware.b4a.BALayout cannot be cast to android.graphics.Bitmap
```

### CORRETO - Usar Null se nao precisa de icone:
```vb
' CORRETO - Null para sem icone
Wait For (xui.Msgbox2Async("Mensagem", "Titulo", "OK", "", "Cancelar", Null, False)) Msgbox_Result(Result As Int)
```

### Assinatura do Msgbox2Async:
```
Msgbox2Async(Message, Title, Positive, Cancel, Negative, Icon As Bitmap, Cancelable)
```

| Parametro | Tipo | Descricao |
|-----------|------|-----------|
| Message | String | Texto da mensagem |
| Title | String | Titulo do dialog |
| Positive | String | Texto botao positivo ("OK", "Sim") |
| Cancel | String | Texto botao cancel (ou "") |
| Negative | String | Texto botao negativo ("Nao", "Cancelar") |
| Icon | **Bitmap** | Icone do dialog (ou **Null**) |
| Cancelable | Boolean | Se pode fechar tocando fora |

### Se precisar de campos de entrada:
Use dialog customizado com overlay (ver dica #29).

---

## 29. Dialog Customizado com Campo de Entrada

### Quando usar:
- Dialog que precisa de EditText para input
- Dialog com multiplos campos
- Controle total sobre aparencia

### Padrao - Overlay + Dialog Panel:

```vb
' Globals
Private pnlOverlay As Panel
Private pnlDialog As Panel
Private edtInput As EditText
Private btnDialogOk As Button
Private btnDialogCancel As Button

' Criar o dialog (chamar no B4XPage_Created)
Private Sub CreateCustomDialog
    'Overlay escuro
    pnlOverlay.Initialize("pnlOverlay")
    pnlOverlay.Color = Colors.ARGB(180, 0, 0, 0)  ' Preto semi-transparente
    Root.AddView(pnlOverlay, 0, 0, Root.Width, Root.Height)
    pnlOverlay.Visible = False

    'Dialog box centralizado
    Dim dialogW As Int = Root.Width - 40dip
    Dim dialogH As Int = 200dip
    Dim dialogX As Int = 20dip
    Dim dialogY As Int = (Root.Height - dialogH) / 2

    pnlDialog.Initialize("")
    pnlDialog.Color = Colors.White
    pnlOverlay.AddView(pnlDialog, dialogX, dialogY, dialogW, dialogH)

    'Titulo
    Dim lblTitle As Label
    lblTitle.Initialize("")
    lblTitle.Text = "Digite sua frase"
    lblTitle.TextSize = Starter.FONT_SUBTITLE
    lblTitle.TextColor = Colors.Black
    lblTitle.Gravity = Gravity.CENTER_HORIZONTAL
    pnlDialog.AddView(lblTitle, 16dip, 16dip, dialogW - 32dip, 30dip)

    'Campo de entrada
    edtInput.Initialize("")
    edtInput.Hint = "Sua frase aqui"
    edtInput.TextSize = Starter.FONT_INPUT
    edtInput.InputType = Bit.Or(edtInput.INPUT_TYPE_TEXT, 128) 'Password
    pnlDialog.AddView(edtInput, 16dip, 56dip, dialogW - 32dip, Starter.HEIGHT_INPUT)

    'Botao Cancelar
    btnDialogCancel.Initialize("btnDialogCancel")
    btnDialogCancel.Text = ModLang.T("cancel")
    btnDialogCancel.TextSize = Starter.FONT_BUTTON
    pnlDialog.AddView(btnDialogCancel, 16dip, dialogH - 60dip, (dialogW - 48dip) / 2, Starter.HEIGHT_BUTTON)

    'Botao OK
    btnDialogOk.Initialize("btnDialogOk")
    btnDialogOk.Text = ModLang.T("ok")
    btnDialogOk.TextSize = Starter.FONT_BUTTON
    pnlDialog.AddView(btnDialogOk, dialogW / 2 + 8dip, dialogH - 60dip, (dialogW - 48dip) / 2, Starter.HEIGHT_BUTTON)
End Sub

' Mostrar dialog
Private Sub ShowDialog
    edtInput.Text = ""
    pnlOverlay.Visible = True
    pnlOverlay.BringToFront
End Sub

' Esconder dialog
Private Sub HideDialog
    pnlOverlay.Visible = False
End Sub

' Eventos dos botoes
Private Sub btnDialogOk_Click
    Dim inputValue As String = edtInput.Text.Trim
    If inputValue.Length > 0 Then
        HideDialog
        ProcessInput(inputValue)
    End If
End Sub

Private Sub btnDialogCancel_Click
    HideDialog
End Sub

' Fechar ao tocar no overlay (opcional)
Private Sub pnlOverlay_Click
    HideDialog
End Sub
```

### Vantagens:
- Controle total sobre layout e estilo
- Pode adicionar multiplos campos
- Funciona sem problemas de cast
- Consistente com o tema do app

### Dica - Modos de dialog:
Se o mesmo dialog e usado para varias acoes, use uma variavel de modo:

```vb
Private CurrentMode As String ' "export", "import", "verify"

Private Sub ShowDialogForExport
    CurrentMode = "export"
    lblTitle.Text = "Exportar Backup"
    ShowDialog
End Sub

Private Sub ShowDialogForImport
    CurrentMode = "import"
    lblTitle.Text = "Importar Backup"
    ShowDialog
End Sub

Private Sub btnDialogOk_Click
    Select CurrentMode
        Case "export"
            DoExport(edtInput.Text)
        Case "import"
            DoImport(edtInput.Text)
    End Select
    HideDialog
End Sub
```

---

## 30. FileProvider - Complicacoes e Alternativas

### Problema:
Compartilhar arquivos do armazenamento interno (File.DirInternal) requer FileProvider no Android moderno.

### Configuracao do FileProvider:
Requer:
1. Biblioteca `contentresolver`
2. Configuracao no Manifest
3. Classe FileProvider no codigo

### Manifest necessario:
```vb
AddApplicationText(
  <provider
  android:name="androidx.core.content.FileProvider"
  android:authorities="$PACKAGE$.provider"
  android:exported="false"
  android:grantUriPermissions="true">
  <meta-data
  android:name="android.support.FILE_PROVIDER_PATHS"
  android:resource="@xml/provider_paths"/>
  </provider>
)

CreateResource(xml, provider_paths,
   <files-path name="name" path="shared" />
)
```

### Codigo para compartilhar arquivo:
```vb
Public Sub GetFileUri(FileName As String) As Object
    Dim jFile As JavaObject
    jFile.InitializeNewInstance("java.io.File", Array(SharedFolder, FileName))

    Dim fp As JavaObject
    Dim ctx As JavaObject
    ctx.InitializeContext
    fp.InitializeStatic("androidx.core.content.FileProvider")
    Return fp.RunMethod("getUriForFile", Array(ctx, Application.PackageName & ".provider", jFile))
End Sub

Sub ShareFile(FileName As String)
    Dim shareIntent As Intent
    shareIntent.Initialize(shareIntent.ACTION_SEND, "")
    shareIntent.SetType("text/plain")
    shareIntent.PutExtra("android.intent.extra.STREAM", GetFileUri(FileName))
    shareIntent.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION
    StartActivity(shareIntent)
End Sub
```

### PROBLEMA COMUM - App crasha ao inicializar:
Se o FileProvider nao estiver configurado corretamente, o app **NAO ABRE** e nao mostra log util.

### ALTERNATIVA RECOMENDADA - Compartilhar como texto:
Para backups JSON ou dados textuais, e mais simples compartilhar como texto:

```vb
Sub ShareBackupAsText(backupContent As String)
    Dim shareIntent As Intent
    shareIntent.Initialize(shareIntent.ACTION_SEND, "")
    shareIntent.SetType("text/plain")
    shareIntent.PutExtra("android.intent.extra.SUBJECT", "LockZero Backup")
    shareIntent.PutExtra("android.intent.extra.TEXT", backupContent)
    StartActivity(shareIntent)
End Sub
```

### Quando usar cada abordagem:

| Situacao | Abordagem |
|----------|-----------|
| Backup JSON pequeno/medio | Compartilhar como TEXTO |
| Arquivos binarios (imagens) | FileProvider necessario |
| PDFs ou documentos | FileProvider necessario |
| Texto grande (pode funcionar) | Tentar texto primeiro |

### RECOMENDACAO:
> **Comece com compartilhamento de texto. So use FileProvider se realmente necessario.**
> **FileProvider adiciona complexidade e pontos de falha.**

---

## 31. Conflitos de Nomes de Variaveis

### Problema:
Alguns nomes de variaveis conflitam com classes/objetos do B4A, causando erros de compilacao.

### Exemplos de conflitos:

| Nome Conflitante | Conflita com | Usar em vez |
|------------------|--------------|-------------|
| `file` | Objeto `File` | `jFile`, `dataFile` |
| `root` | `Root` em B4XPage | `rootMap`, `backupMap` |
| `context` | Classe Context | `ctx`, `appContext` |
| `type` | Palavra reservada | `itemType`, `entryType` |
| `result` | Palavra reservada | `dialogResult`, `retVal` |

### ERRADO:
```vb
' Erro - 'file' conflita com File
Dim file As JavaObject
file.InitializeNewInstance("java.io.File", ...)

' Erro - 'root' conflita com Root do B4XPage
Dim root As Map
root.Initialize
```

### CORRETO:
```vb
' OK - nome diferente
Dim jFile As JavaObject
jFile.InitializeNewInstance("java.io.File", ...)

' OK - nome diferente
Dim backupMap As Map
backupMap.Initialize
```

### Regra:
> **Se der erro de compilacao estranho, verifique se o nome da variavel conflita com algo do B4A.**

---

## 32. Botao Flutuante '+' (FAB)

### Criando botao '+' arredondado:

```vb
Private Sub CreateAddButton
    Dim lblAdd As Label
    lblAdd.Initialize("btnAdd")
    lblAdd.Text = "+"
    lblAdd.TextSize = 28
    lblAdd.Typeface = Typeface.DEFAULT_BOLD
    lblAdd.Gravity = Gravity.CENTER
    lblAdd.Color = ModTheme.GetPrimaryColor
    lblAdd.TextColor = Colors.White

    ' Posicao no canto inferior direito
    Dim btnSize As Int = 56dip
    Dim margin As Int = 16dip
    Root.AddView(lblAdd, Root.Width - btnSize - margin, Root.Height - btnSize - margin, btnSize, btnSize)

    ' Arredondar para ficar circular
    Dim xvAdd As B4XView = lblAdd
    xvAdd.SetColorAndBorder(ModTheme.GetPrimaryColor, 0, ModTheme.GetPrimaryColor, btnSize / 2)
End Sub

Private Sub btnAdd_Click
    ' Acao ao clicar no +
    ShowAddDialog
End Sub
```

### Por que usar Label em vez de Button:
- Button herda estilo do sistema (pode ficar diferente em cada dispositivo)
- Label permite controle total da aparencia
- Facil de fazer circular com `SetColorAndBorder`

### Posicionamento FAB padrao:
```vb
' Canto inferior direito
x = Root.Width - btnSize - 16dip
y = Root.Height - btnSize - 16dip

' Canto inferior esquerdo
x = 16dip
y = Root.Height - btnSize - 16dip

' Centro inferior
x = (Root.Width - btnSize) / 2
y = Root.Height - btnSize - 16dip
```

---

## 33. Inicializacao de Idioma

### Problema:
O idioma precisa ser configurado ANTES de qualquer tela ser mostrada.

### Solucao - Inicializar no Starter.bas:

```vb
' Starter.bas - Service_Create
Sub Service_Create
    ' Carregar idioma salvo ou detectar do sistema
    Dim savedLang As String = GetSetting("language", "")

    If savedLang = "" Then
        ' Detectar idioma do sistema
        Dim loc As JavaObject
        loc.InitializeStatic("java.util.Locale")
        Dim defaultLoc As JavaObject = loc.RunMethod("getDefault", Null)
        Dim lang As String = defaultLoc.RunMethod("getLanguage", Null)

        If lang = "pt" Then
            savedLang = "pt"
        Else
            savedLang = "en"
        End If
        SaveSetting("language", savedLang)
    End If

    ' Inicializar ModLang com o idioma
    ModLang.Init(savedLang)
End Sub
```

### ModLang.Init:
```vb
' ModLang.bas
Private CurrentLanguage As String = "pt"
Private Texts As Map

Public Sub Init(lang As String)
    CurrentLanguage = lang
    Texts.Initialize

    Select CurrentLanguage
        Case "pt"
            LoadPortuguese
        Case "en"
            LoadEnglish
        Case Else
            LoadEnglish
    End Select
End Sub

Public Sub T(key As String) As String
    If Texts.ContainsKey(key) Then
        Return Texts.Get(key)
    End If
    Return key ' Retorna a chave se nao encontrar
End Sub
```

### Ordem de inicializacao:
1. **Starter.Service_Create** - Carrega idioma salvo
2. **ModLang.Init** - Carrega textos do idioma
3. **Activity_Create** - Pode usar ModLang.T() normalmente

### Trocar idioma em runtime:
```vb
Sub ChangeLanguage(newLang As String)
    ModLang.Init(newLang)
    SaveSetting("language", newLang)

    ' Recarregar pagina atual ou toda a UI
    RefreshUI
End Sub
```

---

## 34. Biometria / Leitura Digital

### Biblioteca necessaria:
- `Fingerprint2` (B4A)

### Verificar se dispositivo suporta:
```vb
Private fp As Fingerprint2

Sub CheckBiometricSupport As Boolean
    fp.Initialize("fp")

    If fp.IsHardwareDetected = False Then
        Log("Hardware biometrico nao detectado")
        Return False
    End If

    If fp.HasEnrolledFingerprints = False Then
        Log("Nenhuma digital cadastrada")
        Return False
    End If

    Return True
End Sub
```

### Solicitar autenticacao:
```vb
Sub RequestBiometric
    If CheckBiometricSupport = False Then
        ' Fallback para senha/frase
        ShowPassphraseDialog
        Return
    End If

    fp.StartListening("fp")
    ToastMessageShow("Toque no sensor", False)
End Sub

Sub fp_Success
    ' Autenticacao bem sucedida
    Log("Biometria OK!")
    UnlockApp
End Sub

Sub fp_Failed(ErrorCode As Int, Help As String)
    Log("Biometria falhou: " & Help)

    Select ErrorCode
        Case fp.ERROR_LOCKOUT
            ToastMessageShow("Muitas tentativas. Tente mais tarde.", True)
        Case Else
            ToastMessageShow("Tente novamente", False)
    End Select
End Sub

Sub fp_NonRecoverableError(ErrorCode As Int, Help As String)
    Log("Erro nao recuperavel: " & Help)
    ' Fallback para senha
    ShowPassphraseDialog
End Sub
```

### Manifest (opcional - garantir API):
```vb
AddManifestText(<uses-permission android:name="android.permission.USE_BIOMETRIC"/>)
AddManifestText(<uses-permission android:name="android.permission.USE_FINGERPRINT"/>)
```

### Fluxo recomendado:
1. Verificar se biometria esta disponivel
2. Se sim, mostrar opcao "Usar digital"
3. Se falhar, fazer fallback para frase-senha
4. Sempre ter opcao manual disponivel

---

## 35. Salvar e Carregar Configuracoes (Settings)

### Pattern usado no LockZero:

```vb
' ModSecurity.bas ou Starter.bas

Public Sub SaveSetting(key As String, value As String)
    File.WriteString(File.DirInternal, "settings_" & key & ".txt", value)
End Sub

Public Sub GetSetting(key As String, defaultValue As String) As String
    Dim fileName As String = "settings_" & key & ".txt"
    If File.Exists(File.DirInternal, fileName) Then
        Return File.ReadString(File.DirInternal, fileName)
    End If
    Return defaultValue
End Sub
```

### Uso:
```vb
' Salvar
ModSecurity.SaveSetting("language", "pt")
ModSecurity.SaveSetting("theme", "dark")
ModSecurity.SaveSetting("timeout", "3")

' Carregar
Dim lang As String = ModSecurity.GetSetting("language", "pt")
Dim theme As String = ModSecurity.GetSetting("theme", "light")
Dim timeout As Int = ModSecurity.GetSetting("timeout", "5")
```

### Alternativa - Um arquivo JSON:
```vb
Private SettingsMap As Map

Public Sub LoadSettings
    SettingsMap.Initialize
    If File.Exists(File.DirInternal, "settings.json") Then
        Dim parser As JSONParser
        parser.Initialize(File.ReadString(File.DirInternal, "settings.json"))
        SettingsMap = parser.NextObject
    End If
End Sub

Public Sub SaveSettings
    Dim gen As JSONGenerator
    gen.Initialize(SettingsMap)
    File.WriteString(File.DirInternal, "settings.json", gen.ToString)
End Sub

Public Sub GetSetting(key As String, defaultValue As String) As String
    If SettingsMap.ContainsKey(key) Then
        Return SettingsMap.Get(key)
    End If
    Return defaultValue
End Sub

Public Sub SaveSetting(key As String, value As String)
    SettingsMap.Put(key, value)
    SaveSettings
End Sub
```

---

**Ultima atualizacao:** 2025-12-28
**Projeto:** LockZero (e familia Lockseed Products)
