B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=13.4
@EndOfDesignText@
'clsPasswordEntry.bas - Classe Entrada de Senha
'LockSeed - Site/App, usuario, senha criptografada

Sub Class_Globals
	Public Id As String
	Public GroupId As String             ' ID do grupo ao qual pertence
	Public Site As String                ' Site ou aplicativo (Ex: "binance.com", "Nubank")
	Public Username As String            ' Usuario ou email
	Public PasswordEnc As String         ' Senha criptografada (AES-256)
	Public Notes As String               ' Anotacoes opcionais
	Public CreatedAt As Long
	Public UpdatedAt As Long
End Sub

Public Sub Initialize
	Id = ""
	GroupId = ""
	Site = ""
	Username = ""
	PasswordEnc = ""
	Notes = ""
	CreatedAt = DateTime.Now
	UpdatedAt = DateTime.Now
End Sub

Public Sub getIsInitialized As Boolean
	Return Id <> "" Or Site <> ""
End Sub

