B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=9.85
@EndOfDesignText@
'ModTransition.bas - Transicoes entre telas
'LockZero - Animacoes suaves usando tecnica de snapshot
'
'TECNICA: Baseada em B4X-Transition
'  1. Tira snapshot da pagina atual
'  2. Mostra pagina destino (instantaneo)
'  3. Coloca painel com snapshot na frente
'  4. Anima painel saindo
'  5. Remove painel

Sub Process_Globals
	Private xui As XUI
	Public Const DURATION As Int = 300
End Sub

'Slide para esquerda - pagina atual sai, nova entra
'Chamar ANTES de B4XPages.ShowPage
Public Sub SlideToLeft(CurrentRoot As B4XView, NewRoot As B4XView) As ResumableSub
	If CurrentRoot = Null Or NewRoot = Null Then Return True

	Dim RootWidth As Float = CurrentRoot.Width
	Dim RootHeight As Float = CurrentRoot.Height

	'Cria painel temporario na pagina destino
	Dim pnl As B4XView = xui.CreatePanel("")
	NewRoot.AddView(pnl, 0, 0, RootWidth, RootHeight)
	pnl.As(Panel).Elevation = 10dip  'Fica na frente de tudo

	'Desenha snapshot da pagina atual no painel
	Dim cnv As B4XCanvas
	cnv.Initialize(pnl)
	Dim currentBmp As B4XBitmap = CurrentRoot.Snapshot
	cnv.DrawBitmap(currentBmp, CreateRect(0, 0, RootWidth, RootHeight))
	cnv.Invalidate

	'Anima painel saindo para esquerda
	pnl.SetLayoutAnimated(DURATION, -RootWidth, 0, RootWidth, RootHeight)
	Sleep(DURATION)

	'Remove painel
	pnl.RemoveViewFromParent
	Return True
End Sub

'Slide da direita - nova pagina entra da direita
'Chamar ANTES de B4XPages.ShowPage
Public Sub SlideFromRightNew(CurrentRoot As B4XView, NewRoot As B4XView) As ResumableSub
	If CurrentRoot = Null Or NewRoot = Null Then Return True

	Dim RootWidth As Float = CurrentRoot.Width
	Dim RootHeight As Float = CurrentRoot.Height

	'Cria painel temporario na pagina destino
	Dim pnl As B4XView = xui.CreatePanel("")
	NewRoot.AddView(pnl, RootWidth, 0, RootWidth, RootHeight)  'Comeca fora da tela
	pnl.As(Panel).Elevation = 10dip

	'Desenha snapshot da nova pagina no painel
	Dim cnv As B4XCanvas
	cnv.Initialize(pnl)
	Dim newBmp As B4XBitmap = NewRoot.Snapshot
	cnv.DrawBitmap(newBmp, CreateRect(0, 0, RootWidth, RootHeight))
	cnv.Invalidate

	'Anima painel entrando da direita
	pnl.SetLayoutAnimated(DURATION, 0, 0, RootWidth, RootHeight)
	Sleep(DURATION)

	'Remove painel
	pnl.RemoveViewFromParent
	Return True
End Sub

Private Sub CreateRect(x As Float, y As Float, w As Float, h As Float) As B4XRect
	Dim r As B4XRect
	r.Initialize(x, y, x + w, y + h)
	Return r
End Sub

'===============================================
' METODOS ANTIGOS - mantidos para compatibilidade
'===============================================

Public Sub SlideFromRight(root As B4XView)
	If root = Null Then Return
	root.Alpha = 1
	root.Left = 0
End Sub

Public Sub SlideIn(root As B4XView)
	If root = Null Then Return
	root.Left = 0
	root.Alpha = 1
End Sub

Public Sub FadeIn(root As B4XView)
	If root = Null Then Return
	root.Alpha = 1
End Sub
