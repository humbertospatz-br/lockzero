B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=13.4
@EndOfDesignText@
'clsPasswordGroup.bas - Classe Grupo de Senhas
'LockSeed - Pasta/categoria para organizar senhas

Sub Class_Globals
	Public Id As String
	Public Name As String                ' Ex: "Exchanges", "Redes Sociais", "Email"
	Public UseGlobalPassphrase As Boolean ' Se True, usa frase global; Se False, tem frase propria
	Public CreatedAt As Long
	Public UpdatedAt As Long
End Sub

Public Sub Initialize
	Id = ""
	Name = ""
	UseGlobalPassphrase = True  ' Padrao: usa frase global
	CreatedAt = DateTime.Now
	UpdatedAt = DateTime.Now
End Sub

Public Sub getIsInitialized As Boolean
	Return Id <> "" Or Name <> ""
End Sub

