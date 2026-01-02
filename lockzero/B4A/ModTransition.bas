B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=9.85
@EndOfDesignText@
'ModTransition.bas - Transicoes entre telas
'LockZero - Animacoes suaves de navegacao

Sub Process_Globals
	'Duracao das animacoes (ms)
	Private Const DURATION_ENTER As Int = 150
	Private Const DURATION_EXIT As Int = 120

	'Distancia do slide (porcentagem da largura)
	Private Const SLIDE_OFFSET As Float = 0.25  '25% da largura
End Sub

'Anima entrada da pagina (slide da direita)
'Chamar no inicio de B4XPage_Appear
Public Sub SlideIn(root As B4XView)
	If root = Null Then Return

	Dim screenWidth As Int = 100%x
	Dim offset As Int = screenWidth * SLIDE_OFFSET

	'Garante alpha em 1 (visivel)
	root.Alpha = 1

	'Posiciona fora da tela (direita)
	root.Left = offset

	'Anima para posicao final
	root.SetLayoutAnimated(DURATION_ENTER, 0, root.Top, root.Width, root.Height)
End Sub

'Anima entrada da pagina (slide de baixo - para dialogs/modals)
Public Sub SlideUp(root As B4XView)
	If root = Null Then Return

	Dim offset As Int = 50dip

	'Garante alpha em 1 (visivel)
	root.Alpha = 1

	'Posiciona abaixo
	root.Top = root.Top + offset

	'Anima para posicao final
	root.SetLayoutAnimated(DURATION_ENTER, root.Left, root.Top - offset, root.Width, root.Height)
End Sub

'Anima entrada suave (fade in) - usa slide suave ao inves de fade
Public Sub FadeIn(root As B4XView)
	If root = Null Then Return

	'Garante alpha em 1 (visivel)
	root.Alpha = 1

	'Pequeno slide de baixo para cima
	Dim offset As Int = 30dip
	root.Top = root.Top + offset
	root.SetLayoutAnimated(DURATION_ENTER, root.Left, root.Top - offset, root.Width, root.Height)
End Sub

'Reseta posicao (sem animacao) - para uso antes de sair
Public Sub ResetPosition(root As B4XView)
	If root = Null Then Return
	root.Left = 0
	root.Alpha = 1
End Sub
