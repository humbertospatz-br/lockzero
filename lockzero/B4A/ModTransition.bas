B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=9.85
@EndOfDesignText@
'ModTransition.bas - Transicoes entre telas
'LockZero - Animacoes suaves de navegacao
'
'USO CORRETO (baseado em https://www.b4x.com/android/forum/threads/119447):
'  1. Chamar B4XPages.ShowPage("PageX")
'  2. IMEDIATAMENTE depois, chamar PageX.AnimateIn
'  3. O AnimateIn move off-screen e anima para posicao final
'
'NAO usar em B4XPage_Appear - causa flash branco

Sub Process_Globals
	'Duracao da animacao (ms) - curta e agradavel
	Public Const DURATION As Int = 200
End Sub

'Anima entrada da pagina (slide da direita)
'CHAMAR DEPOIS de B4XPages.ShowPage(), NAO no B4XPage_Appear
Public Sub SlideFromRight(root As B4XView)
	If root = Null Then Return

	'Garante que esta invisivel antes de posicionar
	root.Alpha = 0

	'Move para direita (off-screen) instantaneamente
	root.Left = 100%x

	'Agora torna visivel e anima
	root.Alpha = 1
	root.SetLayoutAnimated(DURATION, 0, 0, root.Width, root.Height)
End Sub

'Anima entrada da pagina (slide de baixo)
'CHAMAR DEPOIS de B4XPages.ShowPage(), NAO no B4XPage_Appear
Public Sub SlideFromBottom(root As B4XView)
	If root = Null Then Return

	'Move para baixo (off-screen) instantaneamente
	root.Top = 100%y
	root.Alpha = 1

	'Anima para posicao final
	root.SetLayoutAnimated(DURATION, 0, 0, root.Width, root.Height)
End Sub

'Anima entrada suave (pequeno slide de baixo)
'CHAMAR DEPOIS de B4XPages.ShowPage(), NAO no B4XPage_Appear
Public Sub SlideFromBottomShort(root As B4XView)
	If root = Null Then Return

	'Move um pouco para baixo instantaneamente
	root.Top = 50dip
	root.Alpha = 1

	'Anima para posicao final
	root.SetLayoutAnimated(DURATION, 0, 0, root.Width, root.Height)
End Sub

'Versoes antigas - mantidas para compatibilidade mas nao fazem nada
Public Sub SlideIn(root As B4XView)
	If root = Null Then Return
	root.Left = 0
	root.Alpha = 1
End Sub

Public Sub SlideUp(root As B4XView)
	If root = Null Then Return
	root.Alpha = 1
End Sub

Public Sub FadeIn(root As B4XView)
	If root = Null Then Return
	root.Alpha = 1
End Sub
