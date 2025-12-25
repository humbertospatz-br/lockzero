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

**Ultima atualizacao:** 2025-12-25
**Projeto:** LockZero (e familia Lockseed Products)
