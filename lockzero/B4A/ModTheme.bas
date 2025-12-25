B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=9.85
@EndOfDesignText@
'ModTheme.bas - Modulo de Temas
'LockZero - Lock and ZERO worries
'Tema Claro e Escuro com cores modernas

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
'  CORES PRIMARIAS
' ============================================

'Cor primaria (Indigo)
Public Sub Primary As Int
	Return Colors.RGB(99, 102, 241) '#6366F1
End Sub

Public Sub PrimaryDark As Int
	Return Colors.RGB(79, 70, 229) '#4F46E5
End Sub

Public Sub PrimaryLight As Int
	Return Colors.RGB(129, 140, 248) '#818CF8
End Sub

' ============================================
'  CORES DE STATUS
' ============================================

Public Sub Success As Int
	Return Colors.RGB(16, 185, 129) '#10B981 Emerald
End Sub

Public Sub Warning As Int
	Return Colors.RGB(245, 158, 11) '#F59E0B Amber
End Sub

Public Sub Danger As Int
	Return Colors.RGB(239, 68, 68) '#EF4444 Red
End Sub

Public Sub Info As Int
	Return Colors.RGB(6, 182, 212) '#06B6D4 Cyan
End Sub

' ============================================
'  CORES DE CATEGORIA
' ============================================

Public Sub CategoryPassword As Int
	Return Colors.RGB(99, 102, 241) '#6366F1 Indigo
End Sub

Public Sub CategoryCard As Int
	Return Colors.RGB(245, 158, 11) '#F59E0B Amber
End Sub

Public Sub CategoryDocument As Int
	Return Colors.RGB(16, 185, 129) '#10B981 Emerald
End Sub

Public Sub CategoryNote As Int
	Return Colors.RGB(236, 72, 153) '#EC4899 Pink
End Sub

Public Sub CategoryWifi As Int
	Return Colors.RGB(6, 182, 212) '#06B6D4 Cyan
End Sub

' ============================================
'  CORES DE FUNDO
' ============================================

Public Sub Background As Int
	If IsDarkTheme Then
		Return Colors.RGB(15, 23, 42) '#0F172A Slate 900
	Else
		Return Colors.RGB(248, 250, 252) '#F8FAFC Slate 50
	End If
End Sub

Public Sub Surface As Int
	If IsDarkTheme Then
		Return Colors.RGB(30, 41, 59) '#1E293B Slate 800
	Else
		Return Colors.White
	End If
End Sub

Public Sub SurfaceLight As Int
	If IsDarkTheme Then
		Return Colors.RGB(51, 65, 85) '#334155 Slate 700
	Else
		Return Colors.RGB(241, 245, 249) '#F1F5F9 Slate 100
	End If
End Sub

' ============================================
'  CORES DE TEXTO
' ============================================

Public Sub TextPrimary As Int
	If IsDarkTheme Then
		Return Colors.RGB(248, 250, 252) '#F8FAFC Slate 50
	Else
		Return Colors.RGB(15, 23, 42) '#0F172A Slate 900
	End If
End Sub

Public Sub TextSecondary As Int
	If IsDarkTheme Then
		Return Colors.RGB(148, 163, 184) '#94A3B8 Slate 400
	Else
		Return Colors.RGB(71, 85, 105) '#475569 Slate 600
	End If
End Sub

Public Sub TextMuted As Int
	If IsDarkTheme Then
		Return Colors.RGB(100, 116, 139) '#64748B Slate 500
	Else
		Return Colors.RGB(148, 163, 184) '#94A3B8 Slate 400
	End If
End Sub

' ============================================
'  CORES DE INPUT
' ============================================

Public Sub InputBackground As Int
	If IsDarkTheme Then
		Return Colors.RGB(51, 65, 85) '#334155 Slate 700
	Else
		Return Colors.White
	End If
End Sub

Public Sub InputBorder As Int
	If IsDarkTheme Then
		Return Colors.RGB(71, 85, 105) '#475569 Slate 600
	Else
		Return Colors.RGB(203, 213, 225) '#CBD5E1 Slate 300
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
		Return Colors.RGB(71, 85, 105) '#475569 Slate 600
	Else
		Return Colors.RGB(226, 232, 240) '#E2E8F0 Slate 200
	End If
End Sub

Public Sub ButtonDanger As Int
	Return Danger
End Sub

Public Sub ButtonDisabled As Int
	If IsDarkTheme Then
		Return Colors.RGB(51, 65, 85) '#334155 Slate 700
	Else
		Return Colors.RGB(226, 232, 240) '#E2E8F0 Slate 200
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
		Return Colors.RGB(51, 65, 85) '#334155 Slate 700
	Else
		Return Colors.RGB(226, 232, 240) '#E2E8F0 Slate 200
	End If
End Sub

Public Sub ItemPressed As Int
	If IsDarkTheme Then
		Return Colors.RGB(51, 65, 85) '#334155 Slate 700
	Else
		Return Colors.RGB(241, 245, 249) '#F1F5F9 Slate 100
	End If
End Sub

' ============================================
'  CORES DE HEADER/NAV
' ============================================

Public Sub HeaderBackground As Int
	If IsDarkTheme Then
		Return Colors.RGB(30, 41, 59) '#1E293B Slate 800
	Else
		Return Primary
	End If
End Sub

Public Sub HeaderText As Int
	Return Colors.White
End Sub

Public Sub NavBackground As Int
	If IsDarkTheme Then
		Return Colors.RGB(30, 41, 59) '#1E293B Slate 800
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
