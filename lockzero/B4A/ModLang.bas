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
	Texts.Put("app_slogan", "Guarde suas informações e ZERO preocupação")

	'=== GERAL ===
	Texts.Put("ok", "OK")
	Texts.Put("cancel", "Cancelar")
	Texts.Put("save", "Salvar")
	Texts.Put("delete", "Excluir")
	Texts.Put("edit", "Editar")
	Texts.Put("add", "Adicionar")
	Texts.Put("close", "Fechar")
	Texts.Put("back", "Voltar")
	Texts.Put("next", "Próximo")
	Texts.Put("continue", "Continuar")
	Texts.Put("done", "Concluído")
	Texts.Put("search", "Buscar")
	Texts.Put("copy", "Copiar")
	Texts.Put("copied", "Copiado!")
	Texts.Put("show", "Mostrar")
	Texts.Put("hide", "Ocultar")
	Texts.Put("view", "Ver")
	Texts.Put("yes", "Sim")
	Texts.Put("no", "Não")
	Texts.Put("loading", "Carregando...")
	Texts.Put("empty", "Nenhum item")
	Texts.Put("error", "Erro")
	Texts.Put("success", "Sucesso")
	Texts.Put("warning", "Aviso")

	'=== AUTENTICACAO ===
	Texts.Put("enter_passphrase", "Digite sua frase secreta")
	Texts.Put("passphrase_hint", "Sua frase pessoal...")
	Texts.Put("passphrase_min_8", "Frase deve ter no mínimo 8 caracteres")
	Texts.Put("confirm", "Confirmar")
	Texts.Put("unlock", "Desbloquear")
	Texts.Put("use_biometric", "Usar biometria")
	Texts.Put("wrong_passphrase", "Frase incorreta")
	Texts.Put("session_expired", "Sessão expirada")
	Texts.Put("session_remaining", "Sessão expira em")
	Texts.Put("wait_timeout", "Aguarde")
	Texts.Put("attempts", "tentativas")
	Texts.Put("failed_attempts", "tentativas incorretas")

	'=== CATEGORIAS ===
	Texts.Put("passwords", "Senhas")
	Texts.Put("cards", "Cartões")
	Texts.Put("documents", "Documentos")
	Texts.Put("notes", "Notas")
	Texts.Put("wifi", "Wi-Fi")

	'=== ONBOARDING ===
	Texts.Put("onb_welcome_title", "Bem-vindo ao LockZero")
	Texts.Put("onb_welcome_text", "Lock and ZERO worries" & Chr(10) & Chr(10) & "O LockZero é seu cofre digital pessoal." & Chr(10) & Chr(10) & "• ZERO Internet - Seus dados nunca saem do dispositivo" & Chr(10) & "• ZERO Conhecimento - Nem nós sabemos sua frase" & Chr(10) & "• ZERO Recuperação - Você é o único responsável" & Chr(10) & "• ZERO Assinatura - Pagamento único ou grátis")
	Texts.Put("onb_warning_title", "⚠️ AVISO IMPORTANTE")
	Texts.Put("onb_warning_text", "LEIA COM ATENÇÃO:" & Chr(10) & Chr(10) & "1. Sua frase-senha NÃO é armazenada em nenhum lugar." & Chr(10) & Chr(10) & "2. Se você ESQUECER sua frase-senha, PERDERÁ TODOS OS SEUS DADOS." & Chr(10) & Chr(10) & "3. NÃO existe 'Esqueci minha senha'. NÃO existe recuperação." & Chr(10) & Chr(10) & "4. NINGUÉM pode ajudar você. Nem nós, nem a Google, nem ninguém." & Chr(10) & Chr(10) & "5. A ÚNICA proteção é fazer BACKUPS regulares." & Chr(10) & Chr(10) & "💡 DICA: Use uma oração, trecho de música ou frase pessoal como 'Eu amo minhas filhas Clara e Gabriela'")
	Texts.Put("onb_understand", "Eu entendo que NÃO há recuperação e sou o único responsável")
	Texts.Put("onb_accept", "Aceitar e Continuar")
	Texts.Put("onb_setup_title", "Crie sua Frase-Senha")
	Texts.Put("onb_setup_info", "Esta frase será usada para criptografar todos os seus dados. Escolha algo que você possa lembrar, mas que seja difícil de adivinhar." & Chr(10) & Chr(10) & "Mínimo: 8 caracteres")
	Texts.Put("onb_passphrase_hint", "Digite sua frase-senha")
	Texts.Put("onb_passphrase_confirm", "Confirme sua frase-senha")
	Texts.Put("onb_create_continue", "Criar e Continuar")
	Texts.Put("onb_backup_title", "Backup Opcional")
	Texts.Put("onb_backup_text", "Você pode criar um backup agora ou depois nas configurações." & Chr(10) & Chr(10) & "Este backup será protegido pela sua frase-senha." & Chr(10) & Chr(10) & "Guarde o arquivo .lockzero em local seguro (pendrive, computador, nuvem pessoal).")
	Texts.Put("onb_create_backup", "Criar Backup Agora")
	Texts.Put("onb_skip_backup", "Pular por Agora")
	Texts.Put("onb_complete_title", "Tudo Pronto!")
	Texts.Put("onb_complete_text", "Seu LockZero está configurado e protegido." & Chr(10) & Chr(10) & "Lembre-se:" & Chr(10) & "• Sua frase-senha: NUNCA esqueça" & Chr(10) & "• Backups: Faça regularmente" & Chr(10) & "• Segurança: 100% em suas mãos" & Chr(10) & Chr(10) & "Lock and ZERO worries!")
	Texts.Put("onb_start", "Começar a Usar")
	Texts.Put("onb_min_chars", "Frase-senha deve ter no mínimo 8 caracteres")
	Texts.Put("onb_not_match", "As frases-senha não conferem")
	Texts.Put("onb_must_accept", "Você precisa aceitar os termos")
	Texts.Put("onb_complete_setup", "Complete a configuração inicial")

	'=== GRUPOS ===
	Texts.Put("new_group", "Novo Grupo")
	Texts.Put("edit_group", "Editar Grupo")
	Texts.Put("group_name_hint", "Nome do grupo")

	'=== SENHAS ===
	Texts.Put("password", "Senha")
	Texts.Put("username", "Usuário")
	Texts.Put("url", "URL/Site")
	Texts.Put("site_name", "Nome do site")
	Texts.Put("new_password", "Nova Senha")
	Texts.Put("add_password", "Adicionar senha")
	Texts.Put("edit_password", "Editar senha")
	Texts.Put("password_copied", "Senha copiada!")
	Texts.Put("clipboard_clear", "Clipboard limpo")
	Texts.Put("seconds", "segundos")
	Texts.Put("generate_password", "Gerar senha")
	Texts.Put("password_strength", "Força da senha")
	Texts.Put("weak", "Fraca")
	Texts.Put("medium", "Média")
	Texts.Put("strong", "Forte")
	Texts.Put("very_strong", "Muito forte")

	'=== CARTOES ===
	Texts.Put("card", "Cartão")
	Texts.Put("card_number", "Número do cartão")
	Texts.Put("card_holder", "Nome no cartão")
	Texts.Put("expiry_date", "Validade")
	Texts.Put("cvv", "CVV")
	Texts.Put("card_nickname", "Apelido do cartão")
	Texts.Put("add_card", "Adicionar cartão")
	Texts.Put("edit_card", "Editar cartão")

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
	Texts.Put("note_title", "Título")
	Texts.Put("note_content", "Conteúdo")
	Texts.Put("new_note", "Nova Nota")
	Texts.Put("add_note", "Adicionar nota")
	Texts.Put("edit_note", "Editar nota")

	'=== WIFI ===
	Texts.Put("wifi_name", "Nome da rede (SSID)")
	Texts.Put("wifi_password", "Senha da rede")
	Texts.Put("wifi_security", "Tipo de segurança")
	Texts.Put("add_wifi", "Adicionar rede")

	'=== GERADOR ===
	Texts.Put("generator", "Gerador")
	Texts.Put("length", "Tamanho")
	Texts.Put("uppercase", "Maiúsculas (A-Z)")
	Texts.Put("lowercase", "Minúsculas (a-z)")
	Texts.Put("numbers", "Números (0-9)")
	Texts.Put("symbols", "Símbolos (!@#$)")
	Texts.Put("generate", "Gerar")
	Texts.Put("use_password", "Usar esta senha")

	'=== CONFIGURACOES ===
	Texts.Put("settings", "Configurações")
	Texts.Put("language", "Idioma")
	Texts.Put("theme", "Tema")
	Texts.Put("theme_light", "Claro")
	Texts.Put("theme_dark", "Escuro")
	Texts.Put("session_timeout", "Tempo de sessão")
	Texts.Put("clipboard_timeout", "Limpar clipboard")
	Texts.Put("biometric", "Biometria")
	Texts.Put("pin_access", "PIN de acesso")
	Texts.Put("change_pin", "Alterar PIN")
	Texts.Put("remove_pin", "Remover PIN")
	Texts.Put("about", "Sobre")
	Texts.Put("version", "Versão")
	Texts.Put("export_data", "Exportar dados")
	Texts.Put("import_data", "Importar dados")
	Texts.Put("backup", "Backup")

	'=== CONFIRMACOES ===
	Texts.Put("confirm_delete", "Confirmar exclusão")
	Texts.Put("confirm_delete_msg", "Deseja realmente excluir este item?")
	Texts.Put("confirm_exit", "Deseja sair?")

	'=== ERROS ===
	Texts.Put("error_empty_field", "Preencha todos os campos")
	Texts.Put("error_invalid_data", "Dados inválidos")
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
	Texts.Put("view", "View")
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
	Texts.Put("passphrase_min_8", "Phrase must have at least 8 characters")
	Texts.Put("confirm", "Confirm")
	Texts.Put("unlock", "Unlock")
	Texts.Put("use_biometric", "Use biometric")
	Texts.Put("wrong_passphrase", "Wrong phrase")
	Texts.Put("session_expired", "Session expired")
	Texts.Put("session_remaining", "Session expires in")
	Texts.Put("wait_timeout", "Wait")
	Texts.Put("attempts", "attempts")
	Texts.Put("failed_attempts", "failed attempts")

	'=== CATEGORIES ===
	Texts.Put("passwords", "Passwords")
	Texts.Put("cards", "Cards")
	Texts.Put("documents", "Documents")
	Texts.Put("notes", "Notes")
	Texts.Put("wifi", "Wi-Fi")

	'=== GROUPS ===
	Texts.Put("new_group", "New Group")
	Texts.Put("edit_group", "Edit Group")
	Texts.Put("group_name_hint", "Group name")

	'=== PASSWORDS ===
	Texts.Put("password", "Password")
	Texts.Put("username", "Username")
	Texts.Put("url", "URL/Website")
	Texts.Put("site_name", "Site name")
	Texts.Put("new_password", "New Password")
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
	Texts.Put("new_note", "New Note")
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

	'=== ONBOARDING ===
	Texts.Put("onb_welcome_title", "Welcome to LockZero")
	Texts.Put("onb_welcome_text", "Lock and ZERO worries" & Chr(10) & Chr(10) & "LockZero is your personal digital vault." & Chr(10) & Chr(10) & "• ZERO Internet - Your data never leaves the device" & Chr(10) & "• ZERO Knowledge - Not even we know your phrase" & Chr(10) & "• ZERO Recovery - You are solely responsible" & Chr(10) & "• ZERO Subscription - One-time payment or free")
	Texts.Put("onb_warning_title", "⚠️ IMPORTANT WARNING")
	Texts.Put("onb_warning_text", "READ CAREFULLY:" & Chr(10) & Chr(10) & "1. Your passphrase is NOT stored anywhere." & Chr(10) & Chr(10) & "2. If you FORGET your passphrase, you WILL LOSE ALL YOUR DATA." & Chr(10) & Chr(10) & "3. There is NO 'Forgot password'. There is NO recovery." & Chr(10) & Chr(10) & "4. NOBODY can help you. Not us, not Google, nobody." & Chr(10) & Chr(10) & "5. The ONLY protection is to make regular BACKUPS." & Chr(10) & Chr(10) & "💡 TIP: Use a prayer, song lyric, or personal phrase like 'I love my daughters Clara and Gabriela'")
	Texts.Put("onb_understand", "I understand there is NO recovery and I am solely responsible")
	Texts.Put("onb_accept", "Accept and Continue")
	Texts.Put("onb_setup_title", "Create your Passphrase")
	Texts.Put("onb_setup_info", "This phrase will be used to encrypt all your data. Choose something you can remember, but that is hard to guess." & Chr(10) & Chr(10) & "Minimum: 8 characters")
	Texts.Put("onb_passphrase_hint", "Enter your passphrase")
	Texts.Put("onb_passphrase_confirm", "Confirm your passphrase")
	Texts.Put("onb_create_continue", "Create and Continue")
	Texts.Put("onb_backup_title", "Optional Backup")
	Texts.Put("onb_backup_text", "You can create a backup now or later in settings." & Chr(10) & Chr(10) & "This backup will be protected by your passphrase." & Chr(10) & Chr(10) & "Store the .lockzero file in a safe place (USB drive, computer, personal cloud).")
	Texts.Put("onb_create_backup", "Create Backup Now")
	Texts.Put("onb_skip_backup", "Skip for Now")
	Texts.Put("onb_complete_title", "All Set!")
	Texts.Put("onb_complete_text", "Your LockZero is configured and protected." & Chr(10) & Chr(10) & "Remember:" & Chr(10) & "• Your passphrase: NEVER forget" & Chr(10) & "• Backups: Do them regularly" & Chr(10) & "• Security: 100% in your hands" & Chr(10) & Chr(10) & "Lock and ZERO worries!")
	Texts.Put("onb_start", "Start Using")
	Texts.Put("onb_min_chars", "Passphrase must have at least 8 characters")
	Texts.Put("onb_not_match", "Passphrases do not match")
	Texts.Put("onb_must_accept", "You need to accept the terms")
	Texts.Put("onb_complete_setup", "Complete the initial setup")

	'=== ERRORS ===
	Texts.Put("error_empty_field", "Please fill all fields")
	Texts.Put("error_invalid_data", "Invalid data")
	Texts.Put("error_save", "Error saving")
	Texts.Put("error_load", "Error loading")
End Sub
