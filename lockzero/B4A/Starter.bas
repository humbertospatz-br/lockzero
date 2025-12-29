B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=9.85
@EndOfDesignText@
'Starter.bas - Servico de Inicializacao
'LockZero - Lock and ZERO worries

#Region  Service Attributes
	#StartAtBoot: False
	#ExcludeFromLibrary: True
#End Region

Sub Process_Globals
	'=== VERSAO DO APP ===
	Public Const APP_NAME As String = "LockZero"
	Public Const APP_VERSION As String = "0.1.0"
	Public Const APP_TAGLINE As String = "Lock and ZERO worries"

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

	'=== ICONES UNICODE (simbolos basicos que renderizam em Android) ===
	Public Const ICON_EYE_OPEN As String = Chr(0x25C9)    'Circulo com ponto (olho) ◉
	Public Const ICON_EYE_CLOSED As String = Chr(0x2022) & Chr(0x2022) & Chr(0x2022) 'Pontos •••
	Public Const ICON_BACK As String = Chr(0x25C0)        'Triangulo esquerda ◀
	Public Const ICON_ADD As String = "+"                 'Adicionar
	Public Const ICON_LOCK As String = Chr(0x25C6)        'Losango ◆
	Public Const ICON_UNLOCK As String = Chr(0x25C7)      'Losango vazio ◇
	Public Const ICON_STAR As String = Chr(0x2605)        'Estrela ★
	Public Const ICON_SETTINGS As String = Chr(0x2699)    'Engrenagem ⚙
	Public Const ICON_COPY As String = Chr(0x25A1)        'Quadrado vazio □
	Public Const ICON_EDIT As String = Chr(0x270E)        'Lapis ✎
	Public Const ICON_DELETE As String = Chr(0x2716)      'X grosso ✖

	'=== FLAGS ===
	Private IsInitialized As Boolean = False

	'=== FILE PROVIDER (para compartilhar arquivos) ===
	Public Provider As FileProvider
End Sub

Sub Service_Create
	'Ponto de entrada do app
	'Inicializa todos os modulos na ordem correta
	InitializeApp
End Sub

Sub Service_Start (StartingIntent As Intent)
	Service.StopAutomaticForeground
End Sub

Sub Service_TaskRemoved
	'App removido da lista de recentes
	ModSession.EndSession
End Sub

Sub Application_Error (Error As Exception, StackTrace As String) As Boolean
	Log("=== ERRO CRITICO ===")
	Log("Erro: " & Error.Message)
	Log("Stack: " & StackTrace)
	Return True
End Sub

Sub Service_Destroy
	'Limpa sessao ao destruir servico
	ModSession.EndSession
End Sub

' ============================================
'  INICIALIZACAO
' ============================================

Private Sub InitializeApp
	If IsInitialized Then Return

	Log("=== LockZero " & APP_VERSION & " ===")
	Log("Inicializando...")

	'1. Modulo de idiomas (primeiro para ter textos disponiveis)
	ModLang.Init
	Log("ModLang OK - Idioma: " & ModLang.GetCurrentLanguage)

	'2. Modulo de temas
	ModTheme.Init
	Log("ModTheme OK - Dark: " & ModTheme.IsDarkTheme)

	'3. FileProvider para compartilhar arquivos
	Provider.Initialize
	Log("FileProvider OK - SharedFolder: " & Provider.SharedFolder)

	'4. Sessao limpa (usuario precisa desbloquear)
	ModSession.EndSession
	Log("ModSession OK - Bloqueado")

	IsInitialized = True
	Log("=== Inicializacao completa ===")
End Sub

' ============================================
'  UTILITARIOS GLOBAIS
' ============================================

'Retorna versao formatada
Public Sub GetVersionString As String
	Return APP_NAME & " v" & APP_VERSION
End Sub
