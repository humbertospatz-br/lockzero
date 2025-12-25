B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=9.85
@EndOfDesignText@
'ModLang.bas - Modulo de Idiomas
'LockZero - Lock and ZERO worries
'Suporte multi-lingua: Portugues (pt) e Ingles (en)

Sub Process_Globals
	Private CurrentLang As String = "pt"
	Private Texts As Map
End Sub

Public Sub Init
	CurrentLang = ModSecurity.GetLanguage
	If CurrentLang = "" Then CurrentLang = "pt"
	LoadTexts
End Sub

Public Sub SetLanguage(langCode As String)
	CurrentLang = langCode.ToLowerCase
	ModSecurity.SaveLanguage(CurrentLang)
	LoadTexts
End Sub

Public Sub GetCurrentLanguage As String
	Return CurrentLang
End Sub

Public Sub GetLanguageName As String
	Select CurrentLang
		Case "pt": Return "Portugues"
		Case "en": Return "English"
		Case Else: Return "Portugues"
	End Select
End Sub

'Retorna texto traduzido
Public Sub T(key As String) As String
	If Texts.IsInitialized = False Then LoadTexts
	If Texts.ContainsKey(key) Then
		Return Texts.Get(key)
	End If
	Return key 'Retorna a chave se nao encontrar
End Sub

'Alias para T()
Public Sub GetText(key As String) As String
	Return T(key)
End Sub

Private Sub LoadTexts
	Texts.Initialize

	Select CurrentLang
		Case "en": LoadEnglish
		Case Else: LoadPortuguese
	End Select
End Sub

Private Sub LoadPortuguese
	'=== APP ===
	Texts.Put("app_name", "LockZero")
	Texts.Put("app_tagline", "Lock and ZERO worries")
	Texts.Put("app_slogan", "Guarde suas informacoes e ZERO preocupacao")

	'=== GERAL ===
	Texts.Put("ok", "OK")
	Texts.Put("cancel", "Cancelar")
	Texts.Put("save", "Salvar")
	Texts.Put("delete", "Excluir")
	Texts.Put("edit", "Editar")
	Texts.Put("add", "Adicionar")
	Texts.Put("close", "Fechar")
	Texts.Put("back", "Voltar")
	Texts.Put("next", "Proximo")
	Texts.Put("done", "Concluido")
	Texts.Put("search", "Buscar")
	Texts.Put("copy", "Copiar")
	Texts.Put("copied", "Copiado!")
	Texts.Put("show", "Mostrar")
	Texts.Put("hide", "Ocultar")
	Texts.Put("yes", "Sim")
	Texts.Put("no", "Nao")
	Texts.Put("loading", "Carregando...")
	Texts.Put("empty", "Nenhum item")
	Texts.Put("error", "Erro")
	Texts.Put("success", "Sucesso")
	Texts.Put("warning", "Aviso")

	'=== AUTENTICACAO ===
	Texts.Put("enter_passphrase", "Digite sua frase secreta")
	Texts.Put("passphrase_hint", "Sua frase pessoal...")
	Texts.Put("unlock", "Desbloquear")
	Texts.Put("use_biometric", "Usar biometria")
	Texts.Put("wrong_passphrase", "Frase incorreta")
	Texts.Put("session_expired", "Sessao expirada")
	Texts.Put("session_remaining", "Sessao expira em")

	'=== CATEGORIAS ===
	Texts.Put("passwords", "Senhas")
	Texts.Put("cards", "Cartoes")
	Texts.Put("documents", "Documentos")
	Texts.Put("notes", "Notas")
	Texts.Put("wifi", "Wi-Fi")

	'=== SENHAS ===
	Texts.Put("password", "Senha")
	Texts.Put("username", "Usuario")
	Texts.Put("url", "URL/Site")
	Texts.Put("site_name", "Nome do site")
	Texts.Put("add_password", "Adicionar senha")
	Texts.Put("edit_password", "Editar senha")
	Texts.Put("password_copied", "Senha copiada!")
	Texts.Put("clipboard_clear", "Clipboard limpo em")
	Texts.Put("seconds", "segundos")
	Texts.Put("generate_password", "Gerar senha")
	Texts.Put("password_strength", "Forca da senha")
	Texts.Put("weak", "Fraca")
	Texts.Put("medium", "Media")
	Texts.Put("strong", "Forte")
	Texts.Put("very_strong", "Muito forte")

	'=== CARTOES ===
	Texts.Put("card", "Cartao")
	Texts.Put("card_number", "Numero do cartao")
	Texts.Put("card_holder", "Nome no cartao")
	Texts.Put("expiry_date", "Validade")
	Texts.Put("cvv", "CVV")
	Texts.Put("card_nickname", "Apelido do cartao")
	Texts.Put("add_card", "Adicionar cartao")
	Texts.Put("edit_card", "Editar cartao")

	'=== DOCUMENTOS ===
	Texts.Put("document", "Documento")
	Texts.Put("document_type", "Tipo de documento")
	Texts.Put("add_document", "Adicionar documento")
	Texts.Put("take_photo", "Tirar foto")
	Texts.Put("choose_photo", "Escolher da galeria")
	Texts.Put("doc_cpf", "CPF")
	Texts.Put("doc_rg", "RG")
	Texts.Put("doc_cnh", "CNH")
	Texts.Put("doc_passport", "Passaporte")
	Texts.Put("doc_other", "Outro")

	'=== NOTAS ===
	Texts.Put("note", "Nota")
	Texts.Put("note_title", "Titulo")
	Texts.Put("note_content", "Conteudo")
	Texts.Put("add_note", "Adicionar nota")
	Texts.Put("edit_note", "Editar nota")

	'=== WIFI ===
	Texts.Put("wifi_name", "Nome da rede (SSID)")
	Texts.Put("wifi_password", "Senha da rede")
	Texts.Put("wifi_security", "Tipo de seguranca")
	Texts.Put("add_wifi", "Adicionar rede")

	'=== GERADOR ===
	Texts.Put("generator", "Gerador")
	Texts.Put("length", "Tamanho")
	Texts.Put("uppercase", "Maiusculas (A-Z)")
	Texts.Put("lowercase", "Minusculas (a-z)")
	Texts.Put("numbers", "Numeros (0-9)")
	Texts.Put("symbols", "Simbolos (!@#$)")
	Texts.Put("generate", "Gerar")
	Texts.Put("use_password", "Usar esta senha")

	'=== CONFIGURACOES ===
	Texts.Put("settings", "Configuracoes")
	Texts.Put("language", "Idioma")
	Texts.Put("theme", "Tema")
	Texts.Put("theme_light", "Claro")
	Texts.Put("theme_dark", "Escuro")
	Texts.Put("session_timeout", "Tempo de sessao")
	Texts.Put("clipboard_timeout", "Limpar clipboard")
	Texts.Put("biometric", "Biometria")
	Texts.Put("pin_access", "PIN de acesso")
	Texts.Put("change_pin", "Alterar PIN")
	Texts.Put("remove_pin", "Remover PIN")
	Texts.Put("about", "Sobre")
	Texts.Put("version", "Versao")
	Texts.Put("export_data", "Exportar dados")
	Texts.Put("import_data", "Importar dados")
	Texts.Put("backup", "Backup")

	'=== CONFIRMACOES ===
	Texts.Put("confirm_delete", "Confirmar exclusao")
	Texts.Put("confirm_delete_msg", "Deseja realmente excluir este item?")
	Texts.Put("confirm_exit", "Deseja sair?")

	'=== ERROS ===
	Texts.Put("error_empty_field", "Preencha todos os campos")
	Texts.Put("error_invalid_data", "Dados invalidos")
	Texts.Put("error_save", "Erro ao salvar")
	Texts.Put("error_load", "Erro ao carregar")
End Sub

Private Sub LoadEnglish
	'=== APP ===
	Texts.Put("app_name", "LockZero")
	Texts.Put("app_tagline", "Lock and ZERO worries")
	Texts.Put("app_slogan", "Store your information with ZERO worries")

	'=== GENERAL ===
	Texts.Put("ok", "OK")
	Texts.Put("cancel", "Cancel")
	Texts.Put("save", "Save")
	Texts.Put("delete", "Delete")
	Texts.Put("edit", "Edit")
	Texts.Put("add", "Add")
	Texts.Put("close", "Close")
	Texts.Put("back", "Back")
	Texts.Put("next", "Next")
	Texts.Put("done", "Done")
	Texts.Put("search", "Search")
	Texts.Put("copy", "Copy")
	Texts.Put("copied", "Copied!")
	Texts.Put("show", "Show")
	Texts.Put("hide", "Hide")
	Texts.Put("yes", "Yes")
	Texts.Put("no", "No")
	Texts.Put("loading", "Loading...")
	Texts.Put("empty", "No items")
	Texts.Put("error", "Error")
	Texts.Put("success", "Success")
	Texts.Put("warning", "Warning")

	'=== AUTHENTICATION ===
	Texts.Put("enter_passphrase", "Enter your secret phrase")
	Texts.Put("passphrase_hint", "Your personal phrase...")
	Texts.Put("unlock", "Unlock")
	Texts.Put("use_biometric", "Use biometric")
	Texts.Put("wrong_passphrase", "Wrong phrase")
	Texts.Put("session_expired", "Session expired")
	Texts.Put("session_remaining", "Session expires in")

	'=== CATEGORIES ===
	Texts.Put("passwords", "Passwords")
	Texts.Put("cards", "Cards")
	Texts.Put("documents", "Documents")
	Texts.Put("notes", "Notes")
	Texts.Put("wifi", "Wi-Fi")

	'=== PASSWORDS ===
	Texts.Put("password", "Password")
	Texts.Put("username", "Username")
	Texts.Put("url", "URL/Website")
	Texts.Put("site_name", "Site name")
	Texts.Put("add_password", "Add password")
	Texts.Put("edit_password", "Edit password")
	Texts.Put("password_copied", "Password copied!")
	Texts.Put("clipboard_clear", "Clipboard clears in")
	Texts.Put("seconds", "seconds")
	Texts.Put("generate_password", "Generate password")
	Texts.Put("password_strength", "Password strength")
	Texts.Put("weak", "Weak")
	Texts.Put("medium", "Medium")
	Texts.Put("strong", "Strong")
	Texts.Put("very_strong", "Very strong")

	'=== CARDS ===
	Texts.Put("card", "Card")
	Texts.Put("card_number", "Card number")
	Texts.Put("card_holder", "Cardholder name")
	Texts.Put("expiry_date", "Expiry date")
	Texts.Put("cvv", "CVV")
	Texts.Put("card_nickname", "Card nickname")
	Texts.Put("add_card", "Add card")
	Texts.Put("edit_card", "Edit card")

	'=== DOCUMENTS ===
	Texts.Put("document", "Document")
	Texts.Put("document_type", "Document type")
	Texts.Put("add_document", "Add document")
	Texts.Put("take_photo", "Take photo")
	Texts.Put("choose_photo", "Choose from gallery")
	Texts.Put("doc_cpf", "CPF")
	Texts.Put("doc_rg", "RG")
	Texts.Put("doc_cnh", "Driver License")
	Texts.Put("doc_passport", "Passport")
	Texts.Put("doc_other", "Other")

	'=== NOTES ===
	Texts.Put("note", "Note")
	Texts.Put("note_title", "Title")
	Texts.Put("note_content", "Content")
	Texts.Put("add_note", "Add note")
	Texts.Put("edit_note", "Edit note")

	'=== WIFI ===
	Texts.Put("wifi_name", "Network name (SSID)")
	Texts.Put("wifi_password", "Network password")
	Texts.Put("wifi_security", "Security type")
	Texts.Put("add_wifi", "Add network")

	'=== GENERATOR ===
	Texts.Put("generator", "Generator")
	Texts.Put("length", "Length")
	Texts.Put("uppercase", "Uppercase (A-Z)")
	Texts.Put("lowercase", "Lowercase (a-z)")
	Texts.Put("numbers", "Numbers (0-9)")
	Texts.Put("symbols", "Symbols (!@#$)")
	Texts.Put("generate", "Generate")
	Texts.Put("use_password", "Use this password")

	'=== SETTINGS ===
	Texts.Put("settings", "Settings")
	Texts.Put("language", "Language")
	Texts.Put("theme", "Theme")
	Texts.Put("theme_light", "Light")
	Texts.Put("theme_dark", "Dark")
	Texts.Put("session_timeout", "Session timeout")
	Texts.Put("clipboard_timeout", "Clear clipboard")
	Texts.Put("biometric", "Biometric")
	Texts.Put("pin_access", "PIN access")
	Texts.Put("change_pin", "Change PIN")
	Texts.Put("remove_pin", "Remove PIN")
	Texts.Put("about", "About")
	Texts.Put("version", "Version")
	Texts.Put("export_data", "Export data")
	Texts.Put("import_data", "Import data")
	Texts.Put("backup", "Backup")

	'=== CONFIRMATIONS ===
	Texts.Put("confirm_delete", "Confirm delete")
	Texts.Put("confirm_delete_msg", "Do you really want to delete this item?")
	Texts.Put("confirm_exit", "Do you want to exit?")

	'=== ERRORS ===
	Texts.Put("error_empty_field", "Please fill all fields")
	Texts.Put("error_invalid_data", "Invalid data")
	Texts.Put("error_save", "Error saving")
	Texts.Put("error_load", "Error loading")
End Sub
