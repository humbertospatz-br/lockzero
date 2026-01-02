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
'NOTA: Desabilitado temporariamente - causa flash branco antes da transicao
'      B4XPages mostra a pagina ANTES do nosso codigo rodar
Public Sub SlideIn(root As B4XView)
	'Transicao desabilitada - apenas garante posicao correta
	If root = Null Then Return
	root.Left = 0
	root.Alpha = 1
End Sub

'Anima entrada da pagina (slide de baixo - para dialogs/modals)
'NOTA: Desabilitado temporariamente
Public Sub SlideUp(root As B4XView)
	If root = Null Then Return
	root.Alpha = 1
End Sub

'Anima entrada suave (fade in)
'NOTA: Desabilitado temporariamente
Public Sub FadeIn(root As B4XView)
	If root = Null Then Return
	root.Alpha = 1
End Sub

'Reseta posicao (sem animacao) - para uso antes de sair
Public Sub ResetPosition(root As B4XView)
	If root = Null Then Return
	root.Left = 0
	root.Alpha = 1
End Sub
