B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=9.85
@EndOfDesignText@
'ModTheme.bas - Modulo de Temas
'LockZero - Lock and ZERO worries
'REDESIGN UX 2025-12-26: Paleta sobria para app de seguranca

Sub Process_Globals
	Public IsDarkTheme As Boolean = True 'Padrao: escuro (app de seguranca)
End Sub

Public Sub Init
	IsDarkTheme = (ModSecurity.GetTheme = 1)
End Sub

Public Sub SetDarkTheme(dark As Boolean)
	IsDarkTheme = dark
	ModSecurity.SaveTheme(IIf(dark, 1, 0))
End Sub

Public Sub ToggleTheme
	SetDarkTheme(Not(IsDarkTheme))
End Sub

' ============================================
'  CORES PRIMARIAS (Navy profundo)
' ============================================

Public Sub Primary As Int
	Return Colors.RGB(10, 37, 64) '#0A2540 Navy profundo
End Sub

Public Sub PrimaryDark As Int
	Return Colors.RGB(5, 25, 45) '#05192D Navy escurecido
End Sub

Public Sub PrimaryLight As Int
	Return Colors.RGB(20, 55, 90) '#14375A Navy claro
End Sub

Public Sub Accent As Int
	Return Colors.RGB(45, 90, 140) '#2D5A8C Azul acinzentado
End Sub

' ============================================
'  CORES DE STATUS (sem verde)
' ============================================

Public Sub Success As Int
	Return Colors.RGB(45, 90, 140) '#2D5A8C Azul (sem verde)
End Sub

Public Sub Warning As Int
	Return Colors.RGB(160, 110, 45) '#A06E2D Amber escuro
End Sub

Public Sub Danger As Int
	Return Colors.RGB(140, 45, 50) '#8C2D32 Vermelho escuro
End Sub

Public Sub Info As Int
	Return Colors.RGB(45, 90, 140) '#2D5A8C Azul acinzentado
End Sub

' ============================================
'  CORES DE CATEGORIA (SOBRIAS - tons de cinza)
' ============================================

Public Sub CategoryPassword As Int
	Return Colors.RGB(10, 37, 64) '#0A2540 Navy (primary)
End Sub

Public Sub CategoryCard As Int
	Return Colors.RGB(50, 60, 75) '#323C4B Cinza azulado
End Sub

Public Sub CategoryDocument As Int
	Return Colors.RGB(38, 48, 60) '#26303C Cinza slate
End Sub

Public Sub CategoryNote As Int
	Return Colors.RGB(45, 55, 70) '#2D3746 Cinza ardosia
End Sub

Public Sub CategoryWifi As Int
	Return Colors.RGB(55, 65, 80) '#374150 Cinza medio
End Sub

' ============================================
'  CORES DE FUNDO
' ============================================

Public Sub Background As Int
	If IsDarkTheme Then
		Return Colors.RGB(12, 14, 18) '#0C0E12 Preto azulado profundo
	Else
		Return Colors.RGB(245, 247, 250) '#F5F7FA Cinza muito claro
	End If
End Sub

Public Sub Surface As Int
	If IsDarkTheme Then
		Return Colors.RGB(22, 27, 34) '#161B22 Superficie elevada
	Else
		Return Colors.White
	End If
End Sub

Public Sub SurfaceLight As Int
	If IsDarkTheme Then
		Return Colors.RGB(33, 40, 50) '#212832 Superficie hover
	Else
		Return Colors.RGB(240, 242, 245) '#F0F2F5
	End If
End Sub

Public Sub Elevated As Int
	If IsDarkTheme Then
		Return Colors.RGB(40, 48, 60) '#28303C Cards destacados
	Else
		Return Colors.White
	End If
End Sub

' ============================================
'  CORES DE TEXTO
' ============================================

Public Sub TextPrimary As Int
	If IsDarkTheme Then
		Return Colors.RGB(230, 235, 240) '#E6EBF0
	Else
		Return Colors.RGB(20, 25, 30) '#14191E
	End If
End Sub

Public Sub TextSecondary As Int
	If IsDarkTheme Then
		Return Colors.RGB(140, 155, 170) '#8C9BAA
	Else
		Return Colors.RGB(80, 95, 110) '#505F6E
	End If
End Sub

Public Sub TextMuted As Int
	If IsDarkTheme Then
		Return Colors.RGB(95, 110, 125) '#5F6E7D
	Else
		Return Colors.RGB(140, 155, 170) '#8C9BAA
	End If
End Sub

' ============================================
'  CORES DE INPUT
' ============================================

Public Sub InputBackground As Int
	If IsDarkTheme Then
		Return Colors.RGB(33, 40, 50) '#212832
	Else
		Return Colors.White
	End If
End Sub

Public Sub InputBorder As Int
	If IsDarkTheme Then
		Return Colors.RGB(55, 65, 80) '#374150
	Else
		Return Colors.RGB(200, 205, 215) '#C8CDD7
	End If
End Sub

Public Sub InputText As Int
	Return TextPrimary
End Sub

Public Sub InputHint As Int
	Return TextMuted
End Sub

' ============================================
'  CORES DE BOTAO
' ============================================

Public Sub ButtonPrimary As Int
	Return Primary
End Sub

Public Sub ButtonSecondary As Int
	If IsDarkTheme Then
		Return Colors.RGB(55, 65, 80) '#374150
	Else
		Return Colors.RGB(220, 225, 230) '#DCE1E6
	End If
End Sub

Public Sub ButtonDanger As Int
	Return Danger
End Sub

Public Sub ButtonDisabled As Int
	If IsDarkTheme Then
		Return Colors.RGB(40, 48, 60) '#28303C
	Else
		Return Colors.RGB(220, 225, 230) '#DCE1E6
	End If
End Sub

Public Sub ButtonTextPrimary As Int
	Return Colors.White
End Sub

Public Sub ButtonTextSecondary As Int
	Return TextPrimary
End Sub

' ============================================
'  CORES DE CARD/ITEM
' ============================================

Public Sub CardBackground As Int
	Return Surface
End Sub

Public Sub CardBorder As Int
	If IsDarkTheme Then
		Return Colors.RGB(33, 40, 50) '#212832
	Else
		Return Colors.RGB(220, 225, 230) '#DCE1E6
	End If
End Sub

Public Sub ItemPressed As Int
	Return SurfaceLight
End Sub

' ============================================
'  CORES DE HEADER/NAV
' ============================================

Public Sub HeaderBackground As Int
	Return Primary '#0A2540 Navy
End Sub

Public Sub HeaderText As Int
	Return Colors.White
End Sub

Public Sub NavBackground As Int
	If IsDarkTheme Then
		Return Colors.RGB(22, 27, 34) '#161B22
	Else
		Return Colors.White
	End If
End Sub

Public Sub NavActive As Int
	Return Primary
End Sub

Public Sub NavInactive As Int
	Return TextMuted
End Sub

' ============================================
'  DRAWABLES
' ============================================

Public Sub GetInputDrawable As ColorDrawable
	Dim cd As ColorDrawable
	cd.Initialize2(InputBackground, 8dip, 1dip, InputBorder)
	Return cd
End Sub

Public Sub GetCardDrawable As ColorDrawable
	Dim cd As ColorDrawable
	cd.Initialize2(CardBackground, 12dip, 1dip, CardBorder)
	Return cd
End Sub

Public Sub GetButtonPrimaryDrawable As ColorDrawable
	Dim cd As ColorDrawable
	cd.Initialize(Primary, 8dip)
	Return cd
End Sub

Public Sub GetButtonSecondaryDrawable As ColorDrawable
	Dim cd As ColorDrawable
	cd.Initialize2(ButtonSecondary, 8dip, 1dip, InputBorder)
	Return cd
End Sub
