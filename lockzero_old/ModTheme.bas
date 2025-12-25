B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=13.4
@EndOfDesignText@
'ModTheme.bas - Módulo de Temas
'LockSeed - Tema Claro e Escuro

Sub Process_Globals
	Public CurrentThemeIndex As Int = 0 ' 0=claro, 1=escuro

	' Tema nativo Android (solução Erel)
	Public THEME_LIGHT As Int = 16974393  ' Theme.Material.Light
	Public THEME_DARK As Int = 16974372   ' Theme.Material
	Private NativeThemeValue As Int
End Sub

Public Sub Init
	CurrentThemeIndex = 0
End Sub

Public Sub SetTheme(index As Int)
	CurrentThemeIndex = index
End Sub

' ============================================
'  CORES DO TEMA
' ============================================
Public Sub GetBackgroundColor As Int
	If CurrentThemeIndex = 0 Then
		Return Colors.White
	Else
		Return Colors.RGB(30, 30, 30)
	End If
End Sub

Public Sub GetHeaderColor As Int
	If CurrentThemeIndex = 0 Then
		Return Colors.RGB(224, 224, 224)
	Else
		Return Colors.RGB(50, 50, 50)
	End If
End Sub

Public Sub GetTextColor As Int
	If CurrentThemeIndex = 0 Then
		Return Colors.Black
	Else
		Return Colors.White
	End If
End Sub

Public Sub GetTitleTextColor As Int
	If CurrentThemeIndex = 0 Then
		Return Colors.Black
	Else
		Return Colors.White
	End If
End Sub

Public Sub GetPrimaryColor As Int
	Return Colors.RGB(0, 123, 255) ' Azul
End Sub

Public Sub GetSecondaryColor As Int
	Return Colors.RGB(108, 117, 125) ' Cinza
End Sub

Public Sub GetMenuBackgroundColor As Int
	If CurrentThemeIndex = 0 Then
		Return Colors.RGB(240, 240, 240) ' Menu claro para tema claro
	Else
		Return Colors.RGB(40, 40, 40)    ' Menu escuro para tema escuro
	End If
End Sub

Public Sub GetMenuButtonColor As Int
	If CurrentThemeIndex = 0 Then
		Return Colors.RGB(0, 123, 255)   ' Azul para tema claro
	Else
		Return Colors.RGB(80, 80, 80)    ' Cinza para tema escuro
	End If
End Sub

Public Sub GetMenuTextColor As Int
	If CurrentThemeIndex = 0 Then
		Return Colors.Black
	Else
		Return Colors.White
	End If
End Sub

Public Sub GetRowColor As Int
	If CurrentThemeIndex = 0 Then
		Return Colors.RGB(245, 245, 245)
	Else
		Return Colors.RGB(50, 50, 50)
	End If
End Sub

' Cor de fundo dos campos de entrada (EditText)
Public Sub GetInputBackgroundColor As Int
	If CurrentThemeIndex = 0 Then
		Return Colors.White
	Else
		Return Colors.RGB(60, 60, 60)
	End If
End Sub

' Cor do texto nos campos de entrada
Public Sub GetInputTextColor As Int
	If CurrentThemeIndex = 0 Then
		Return Colors.Black
	Else
		Return Colors.White
	End If
End Sub

' Cor de hint (placeholder)
Public Sub GetHintColor As Int
	If CurrentThemeIndex = 0 Then
		Return Colors.Gray
	Else
		Return Colors.RGB(150, 150, 150)
	End If
End Sub

' Cor de borda dos painéis
Public Sub GetBorderColor As Int
	If CurrentThemeIndex = 0 Then
		Return Colors.LightGray
	Else
		Return Colors.RGB(80, 80, 80)
	End If
End Sub

' Cor de fundo dos painéis secundários
Public Sub GetPanelColor As Int
	If CurrentThemeIndex = 0 Then
		Return Colors.RGB(248, 249, 250)
	Else
		Return Colors.RGB(45, 45, 45)
	End If
End Sub

' Cor de labels secundários
Public Sub GetSecondaryTextColor As Int
	If CurrentThemeIndex = 0 Then
		Return Colors.DarkGray
	Else
		Return Colors.RGB(180, 180, 180)
	End If
End Sub

' Cor de fundo do painel de aviso (modo edição)
Public Sub GetWarningPanelColor As Int
	If CurrentThemeIndex = 0 Then
		Return Colors.RGB(255, 250, 230)  ' Amarelo claro
	Else
		Return Colors.RGB(60, 55, 40)  ' Amarelo escuro
	End If
End Sub

' Cor de borda do painel de aviso
Public Sub GetWarningBorderColor As Int
	If CurrentThemeIndex = 0 Then
		Return Colors.RGB(255, 200, 100)
	Else
		Return Colors.RGB(150, 120, 50)
	End If
End Sub

' Cor do texto de aviso
Public Sub GetWarningTextColor As Int
	If CurrentThemeIndex = 0 Then
		Return Colors.RGB(180, 100, 0)
	Else
		Return Colors.RGB(255, 180, 80)
	End If
End Sub

' Cor de botão desabilitado (mais clara que o cinza normal)
Public Sub GetDisabledButtonColor As Int
	If CurrentThemeIndex = 0 Then
		Return Colors.RGB(200, 200, 200)  ' Cinza bem claro
	Else
		Return Colors.RGB(70, 70, 70)  ' Cinza escuro suave
	End If
End Sub

' Cor do texto do Spinner
Public Sub GetSpinnerTextColor As Int
	If CurrentThemeIndex = 0 Then
		Return Colors.Black
	Else
		Return Colors.White
	End If
End Sub

' Cor de fundo do dropdown do Spinner
Public Sub GetSpinnerDropdownColor As Int
	If CurrentThemeIndex = 0 Then
		Return Colors.White
	Else
		Return Colors.RGB(50, 50, 50)
	End If
End Sub

' ============================================
'  TEMA NATIVO ANDROID (Solução Erel)
' ============================================
Public Sub SetNativeTheme(Theme As Int)
	If Theme = 0 Then
		ToastMessageShow("Tema não disponível.", False)
		Return
	End If

	' Salva tema em arquivo
	File.WriteString(File.DirInternal, "theme.txt", Theme)
	NativeThemeValue = Theme

	' Também atualiza o índice interno
	If Theme = THEME_LIGHT Then
		CurrentThemeIndex = 0
	Else
		CurrentThemeIndex = 1
	End If

	' Reinicia o app para aplicar tema nativo
	StartActivity(Main)
End Sub

Public Sub GetNativeTheme As Int
	Return NativeThemeValue
End Sub

Public Sub LoadSavedTheme
	Try
		If File.Exists(File.DirInternal, "theme.txt") Then
			Dim savedValue As String = File.ReadString(File.DirInternal, "theme.txt")
			Log("LoadSavedTheme: savedValue=" & savedValue & " LIGHT=" & THEME_LIGHT & " DARK=" & THEME_DARK)
			' Converte explicitamente para Int para comparação correta
			NativeThemeValue = savedValue
			If NativeThemeValue = THEME_DARK Then
				CurrentThemeIndex = 1
				Log("LoadSavedTheme: Tema ESCURO (index=1)")
			Else
				CurrentThemeIndex = 0
				Log("LoadSavedTheme: Tema CLARO (index=0)")
			End If
		Else
			' Arquivo não existe - usa tema claro como padrão
			NativeThemeValue = THEME_LIGHT
			CurrentThemeIndex = 0
			Log("LoadSavedTheme: Arquivo não existe, usando CLARO")
		End If
	Catch
		NativeThemeValue = THEME_LIGHT
		CurrentThemeIndex = 0
		Log("LoadSavedTheme: ERRO - " & LastException.Message)
	End Try
	Log("LoadSavedTheme: FINAL CurrentThemeIndex=" & CurrentThemeIndex)
End Sub

' ============================================
'  COLORDRAWABLE PARA EDITTEXT (borda)
' ============================================

' Retorna ColorDrawable com fundo branco e borda - adaptado ao tema
Public Sub GetEditDrawableWhite As ColorDrawable
	Dim cd As ColorDrawable
	If CurrentThemeIndex = 0 Then
		cd.Initialize2(Colors.White, 5dip, 1dip, Colors.Black)
	Else
		cd.Initialize2(Colors.RGB(60, 60, 60), 5dip, 1dip, Colors.RGB(100, 100, 100))
	End If
	Return cd
End Sub

' Retorna ColorDrawable com fundo cinza e borda - adaptado ao tema
Public Sub GetEditDrawableGray As ColorDrawable
	Dim cd As ColorDrawable
	If CurrentThemeIndex = 0 Then
		cd.Initialize2(Colors.RGB(243, 243, 243), 5dip, 1dip, Colors.Black)
	Else
		cd.Initialize2(Colors.RGB(50, 50, 50), 5dip, 1dip, Colors.RGB(100, 100, 100))
	End If
	Return cd
End Sub
