package com.lockzero;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class pagebackup extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.lockzero.pagebackup");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.lockzero.pagebackup.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnback = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblheadertitle = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _svcontent = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _pnlcontent = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbllastbackup = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnexport = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnimport = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnimporttext = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btntestrestore = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnloverlay = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlphrasedialog = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtphrase = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnphraseok = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnphrasecancel = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnphraseshow = null;
public boolean _phrasevisible = false;
public String _currentdialogmode = "";
public String _currentbackupfolder = "";
public String _currentbackupfilename = "";
public anywheresoftware.b4a.objects.PanelWrapper _pnlimporttextdialog = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtimporttext = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnimporttextok = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnimporttextcancel = null;
public b4a.example.dateutils _dateutils = null;
public com.lockzero.main _main = null;
public com.lockzero.starter _starter = null;
public com.lockzero.modbackup _modbackup = null;
public com.lockzero.modlang _modlang = null;
public com.lockzero.modnotes _modnotes = null;
public com.lockzero.modpasswords _modpasswords = null;
public com.lockzero.modsecurity _modsecurity = null;
public com.lockzero.modsession _modsession = null;
public com.lockzero.modtheme _modtheme = null;
public com.lockzero.b4xpages _b4xpages = null;
public com.lockzero.b4xcollections _b4xcollections = null;
public com.lockzero.xuiviewsutils _xuiviewsutils = null;
public String  _applytheme() throws Exception{
 //BA.debugLineNum = 579;BA.debugLine="Private Sub ApplyTheme";
 //BA.debugLineNum = 580;BA.debugLine="Root.Color = ModTheme.HomeBg";
_root.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 581;BA.debugLine="svContent.Color = ModTheme.HomeBg";
_svcontent.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 582;BA.debugLine="pnlContent.Color = ModTheme.HomeBg";
_pnlcontent.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 584;BA.debugLine="btnExport.Color = ModTheme.HomeIconBg";
_btnexport.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 585;BA.debugLine="btnExport.TextColor = Colors.White";
_btnexport.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 587;BA.debugLine="btnImport.Color = ModTheme.HomeIconBg";
_btnimport.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 588;BA.debugLine="btnImport.TextColor = Colors.White";
_btnimport.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 590;BA.debugLine="btnImportText.Color = ModTheme.HomeHeaderBg";
_btnimporttext.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 591;BA.debugLine="btnImportText.TextColor = Colors.White";
_btnimporttext.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 593;BA.debugLine="btnTestRestore.Color = ModTheme.HomeHeaderBg";
_btntestrestore.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 594;BA.debugLine="btnTestRestore.TextColor = Colors.White";
_btntestrestore.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 595;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_appear() throws Exception{
 //BA.debugLineNum = 53;BA.debugLine="Private Sub B4XPage_Appear";
 //BA.debugLineNum = 55;BA.debugLine="CallSub2(Main, \"SetPageTitle\", ModLang.T(\"backup\"";
__c.CallSubNew2(ba,(Object)(_main.getObject()),"SetPageTitle",(Object)(_modlang._t /*String*/ (ba,"backup")));
 //BA.debugLineNum = 57;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 58;BA.debugLine="UpdateLastBackupInfo";
_updatelastbackupinfo();
 //BA.debugLineNum = 61;BA.debugLine="If Main.PendingBackupFile <> \"\" Then";
if ((_main._pendingbackupfile /*String*/ ).equals("") == false) { 
 //BA.debugLineNum = 62;BA.debugLine="Log(\"PageBackup: Arquivo pendente para importar:";
__c.LogImpl("551118089","PageBackup: Arquivo pendente para importar: "+_main._pendingbackupfile /*String*/ ,0);
 //BA.debugLineNum = 63;BA.debugLine="CurrentBackupFolder = Starter.Provider.SharedFol";
_currentbackupfolder = _starter._provider /*com.lockzero.fileprovider*/ ._sharedfolder /*String*/ ;
 //BA.debugLineNum = 64;BA.debugLine="CurrentBackupFileName = Main.PendingBackupFile";
_currentbackupfilename = _main._pendingbackupfile /*String*/ ;
 //BA.debugLineNum = 65;BA.debugLine="Main.PendingBackupFile = \"\" 'Limpa para nao proc";
_main._pendingbackupfile /*String*/  = "";
 //BA.debugLineNum = 68;BA.debugLine="ShowPhraseDialog(\"import\", CurrentBackupFileName";
_showphrasedialog("import",_currentbackupfilename+__c.CRLF+_modlang._t /*String*/ (ba,"backup_enter_phrase"));
 };
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
 //BA.debugLineNum = 45;BA.debugLine="Private Sub B4XPage_Created(Root1 As B4XView)";
 //BA.debugLineNum = 46;BA.debugLine="Log(\"PageBackup: B4XPage_Created inicio\")";
__c.LogImpl("551052545","PageBackup: B4XPage_Created inicio",0);
 //BA.debugLineNum = 47;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 48;BA.debugLine="CreateUI";
_createui();
 //BA.debugLineNum = 49;BA.debugLine="ApplyTheme";
_applytheme();
 //BA.debugLineNum = 50;BA.debugLine="Log(\"PageBackup: B4XPage_Created fim\")";
__c.LogImpl("551052549","PageBackup: B4XPage_Created fim",0);
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return "";
}
public String  _btnback_click() throws Exception{
 //BA.debugLineNum = 416;BA.debugLine="Private Sub btnBack_Click";
 //BA.debugLineNum = 417;BA.debugLine="B4XPages.ClosePage(Me)";
_b4xpages._closepage /*String*/ (ba,this);
 //BA.debugLineNum = 418;BA.debugLine="End Sub";
return "";
}
public String  _btnexport_click() throws Exception{
 //BA.debugLineNum = 420;BA.debugLine="Private Sub btnExport_Click";
 //BA.debugLineNum = 421;BA.debugLine="Log(\"=== btnExport_Click ===\")";
__c.LogImpl("551773441","=== btnExport_Click ===",0);
 //BA.debugLineNum = 422;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 423;BA.debugLine="ShowExportDialog";
_showexportdialog();
 //BA.debugLineNum = 424;BA.debugLine="End Sub";
return "";
}
public String  _btnimport_click() throws Exception{
 //BA.debugLineNum = 426;BA.debugLine="Private Sub btnImport_Click";
 //BA.debugLineNum = 427;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 428;BA.debugLine="ShowImportDialog";
_showimportdialog();
 //BA.debugLineNum = 429;BA.debugLine="End Sub";
return "";
}
public String  _btnimporttext_click() throws Exception{
 //BA.debugLineNum = 659;BA.debugLine="Private Sub btnImportText_Click";
 //BA.debugLineNum = 660;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 661;BA.debugLine="ShowImportTextDialog";
_showimporttextdialog();
 //BA.debugLineNum = 662;BA.debugLine="End Sub";
return "";
}
public String  _btnimporttextcancel_click() throws Exception{
 //BA.debugLineNum = 678;BA.debugLine="Private Sub btnImportTextCancel_Click";
 //BA.debugLineNum = 679;BA.debugLine="HideImportTextDialog";
_hideimporttextdialog();
 //BA.debugLineNum = 680;BA.debugLine="End Sub";
return "";
}
public String  _btnimporttextok_click() throws Exception{
String _backuptext = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _backupmap = null;
 //BA.debugLineNum = 682;BA.debugLine="Private Sub btnImportTextOk_Click";
 //BA.debugLineNum = 683;BA.debugLine="Dim backupText As String = edtImportText.Text.Tri";
_backuptext = _edtimporttext.getText().trim();
 //BA.debugLineNum = 685;BA.debugLine="If backupText = \"\" Then";
if ((_backuptext).equals("")) { 
 //BA.debugLineNum = 686;BA.debugLine="ToastMessageShow(ModLang.T(\"backup_paste_empty\")";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup_paste_empty")),__c.True);
 //BA.debugLineNum = 687;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 691;BA.debugLine="Try";
try { //BA.debugLineNum = 692;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 693;BA.debugLine="parser.Initialize(backupText)";
_parser.Initialize(_backuptext);
 //BA.debugLineNum = 694;BA.debugLine="Dim backupMap As Map = parser.NextObject";
_backupmap = new anywheresoftware.b4a.objects.collections.Map();
_backupmap = _parser.NextObject();
 //BA.debugLineNum = 695;BA.debugLine="If backupMap.ContainsKey(\"version\") = False Or b";
if (_backupmap.ContainsKey((Object)("version"))==__c.False || _backupmap.ContainsKey((Object)("data"))==__c.False) { 
 //BA.debugLineNum = 696;BA.debugLine="ToastMessageShow(ModLang.T(\"backup_invalid\"), T";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup_invalid")),__c.True);
 //BA.debugLineNum = 697;BA.debugLine="Return";
if (true) return "";
 };
 } 
       catch (Exception e15) {
			ba.setLastException(e15); //BA.debugLineNum = 700;BA.debugLine="ToastMessageShow(ModLang.T(\"backup_invalid\"), Tr";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup_invalid")),__c.True);
 //BA.debugLineNum = 701;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 704;BA.debugLine="HideImportTextDialog";
_hideimporttextdialog();
 //BA.debugLineNum = 707;BA.debugLine="CurrentBackupFolder = Starter.Provider.SharedFold";
_currentbackupfolder = _starter._provider /*com.lockzero.fileprovider*/ ._sharedfolder /*String*/ ;
 //BA.debugLineNum = 708;BA.debugLine="CurrentBackupFileName = \"pasted_backup_\" & DateTi";
_currentbackupfilename = "pasted_backup_"+BA.NumberToString(__c.DateTime.getNow())+".lockzero";
 //BA.debugLineNum = 709;BA.debugLine="File.WriteString(CurrentBackupFolder, CurrentBack";
__c.File.WriteString(_currentbackupfolder,_currentbackupfilename,_backuptext);
 //BA.debugLineNum = 711;BA.debugLine="ShowPhraseDialog(\"import\", ModLang.T(\"backup_ente";
_showphrasedialog("import",_modlang._t /*String*/ (ba,"backup_enter_phrase"));
 //BA.debugLineNum = 712;BA.debugLine="End Sub";
return "";
}
public String  _btnphrasecancel_click() throws Exception{
 //BA.debugLineNum = 361;BA.debugLine="Private Sub btnPhraseCancel_Click";
 //BA.debugLineNum = 362;BA.debugLine="HidePhraseDialog";
_hidephrasedialog();
 //BA.debugLineNum = 363;BA.debugLine="End Sub";
return "";
}
public String  _btnphraseok_click() throws Exception{
String _phrase = "";
 //BA.debugLineNum = 378;BA.debugLine="Private Sub btnPhraseOk_Click";
 //BA.debugLineNum = 379;BA.debugLine="Dim phrase As String = edtPhrase.Text.Trim";
_phrase = _edtphrase.getText().trim();
 //BA.debugLineNum = 381;BA.debugLine="If phrase.Length < 6 Then";
if (_phrase.length()<6) { 
 //BA.debugLineNum = 382;BA.debugLine="ToastMessageShow(ModLang.T(\"backup_phrase_min\"),";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup_phrase_min")),__c.True);
 //BA.debugLineNum = 383;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 386;BA.debugLine="HidePhraseDialog";
_hidephrasedialog();
 //BA.debugLineNum = 388;BA.debugLine="Select CurrentDialogMode";
switch (BA.switchObjectToInt(_currentdialogmode,"export","import","test")) {
case 0: {
 //BA.debugLineNum = 390;BA.debugLine="DoExport(phrase)";
_doexport(_phrase);
 break; }
case 1: {
 //BA.debugLineNum = 392;BA.debugLine="DoImportWithPhrase(phrase)";
_doimportwithphrase(_phrase);
 break; }
case 2: {
 //BA.debugLineNum = 394;BA.debugLine="DoTestWithPhrase(phrase)";
_dotestwithphrase(_phrase);
 break; }
}
;
 //BA.debugLineNum = 396;BA.debugLine="End Sub";
return "";
}
public String  _btnphraseshow_click() throws Exception{
 //BA.debugLineNum = 365;BA.debugLine="Private Sub btnPhraseShow_Click";
 //BA.debugLineNum = 366;BA.debugLine="PhraseVisible = Not(PhraseVisible)";
_phrasevisible = __c.Not(_phrasevisible);
 //BA.debugLineNum = 367;BA.debugLine="If PhraseVisible Then";
if (_phrasevisible) { 
 //BA.debugLineNum = 368;BA.debugLine="edtPhrase.InputType = 1 'TEXT";
_edtphrase.setInputType((int) (1));
 //BA.debugLineNum = 369;BA.debugLine="btnPhraseShow.Text = ModLang.T(\"hide\")";
_btnphraseshow.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"hide")));
 }else {
 //BA.debugLineNum = 371;BA.debugLine="edtPhrase.InputType = Bit.Or(1, 128) 'PASSWORD";
_edtphrase.setInputType(__c.Bit.Or((int) (1),(int) (128)));
 //BA.debugLineNum = 372;BA.debugLine="btnPhraseShow.Text = ModLang.T(\"show\")";
_btnphraseshow.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"show")));
 };
 //BA.debugLineNum = 375;BA.debugLine="edtPhrase.SelectionStart = edtPhrase.Text.Length";
_edtphrase.setSelectionStart(_edtphrase.getText().length());
 //BA.debugLineNum = 376;BA.debugLine="End Sub";
return "";
}
public String  _btntestrestore_click() throws Exception{
 //BA.debugLineNum = 431;BA.debugLine="Private Sub btnTestRestore_Click";
 //BA.debugLineNum = 432;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 433;BA.debugLine="ShowTestDialog";
_showtestdialog();
 //BA.debugLineNum = 434;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 4;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Private Root As B4XView";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 6;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 9;BA.debugLine="Private btnBack As Button";
_btnback = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 10;BA.debugLine="Private lblHeaderTitle As Label";
_lblheadertitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Private svContent As ScrollView";
_svcontent = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Private pnlContent As B4XView";
_pnlcontent = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private lblLastBackup As Label";
_lbllastbackup = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private btnExport As Button";
_btnexport = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private btnImport As Button";
_btnimport = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private btnImportText As Button";
_btnimporttext = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private btnTestRestore As Button";
_btntestrestore = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private pnlOverlay As Panel";
_pnloverlay = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private pnlPhraseDialog As Panel";
_pnlphrasedialog = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private edtPhrase As EditText";
_edtphrase = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private btnPhraseOk As Button";
_btnphraseok = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private btnPhraseCancel As Button";
_btnphrasecancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private btnPhraseShow As Button";
_btnphraseshow = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private PhraseVisible As Boolean = False";
_phrasevisible = __c.False;
 //BA.debugLineNum = 30;BA.debugLine="Private CurrentDialogMode As String 'export, impo";
_currentdialogmode = "";
 //BA.debugLineNum = 31;BA.debugLine="Private CurrentBackupFolder As String";
_currentbackupfolder = "";
 //BA.debugLineNum = 32;BA.debugLine="Private CurrentBackupFileName As String";
_currentbackupfilename = "";
 //BA.debugLineNum = 35;BA.debugLine="Private pnlImportTextDialog As Panel";
_pnlimporttextdialog = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private edtImportText As EditText";
_edtimporttext = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private btnImportTextOk As Button";
_btnimporttextok = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private btnImportTextCancel As Button";
_btnimporttextcancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 39;BA.debugLine="End Sub";
return "";
}
public String  _createimporttextdialog() throws Exception{
int _boxw = 0;
int _boxh = 0;
int _boxl = 0;
int _boxt = 0;
anywheresoftware.b4a.objects.PanelWrapper _pnlbox = null;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
int _btnw = 0;
 //BA.debugLineNum = 601;BA.debugLine="Private Sub CreateImportTextDialog";
 //BA.debugLineNum = 602;BA.debugLine="pnlImportTextDialog.Initialize(\"\")";
_pnlimporttextdialog.Initialize(ba,"");
 //BA.debugLineNum = 603;BA.debugLine="pnlImportTextDialog.Color = Colors.ARGB(180, 0, 0";
_pnlimporttextdialog.setColor(__c.Colors.ARGB((int) (180),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 604;BA.debugLine="Root.AddView(pnlImportTextDialog, 0, 0, Root.Widt";
_root.AddView((android.view.View)(_pnlimporttextdialog.getObject()),(int) (0),(int) (0),_root.getWidth(),_root.getHeight());
 //BA.debugLineNum = 605;BA.debugLine="pnlImportTextDialog.Visible = False";
_pnlimporttextdialog.setVisible(__c.False);
 //BA.debugLineNum = 607;BA.debugLine="Dim boxW As Int = Root.Width - 40dip";
_boxw = (int) (_root.getWidth()-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 608;BA.debugLine="Dim boxH As Int = 350dip";
_boxh = __c.DipToCurrent((int) (350));
 //BA.debugLineNum = 609;BA.debugLine="Dim boxL As Int = 20dip";
_boxl = __c.DipToCurrent((int) (20));
 //BA.debugLineNum = 610;BA.debugLine="Dim boxT As Int = (Root.Height - boxH) / 2";
_boxt = (int) ((_root.getHeight()-_boxh)/(double)2);
 //BA.debugLineNum = 612;BA.debugLine="Dim pnlBox As Panel";
_pnlbox = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 613;BA.debugLine="pnlBox.Initialize(\"\")";
_pnlbox.Initialize(ba,"");
 //BA.debugLineNum = 614;BA.debugLine="pnlBox.Color = ModTheme.HomeHeaderBg";
_pnlbox.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 615;BA.debugLine="pnlImportTextDialog.AddView(pnlBox, boxL, boxT, b";
_pnlimporttextdialog.AddView((android.view.View)(_pnlbox.getObject()),_boxl,_boxt,_boxw,_boxh);
 //BA.debugLineNum = 618;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 619;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 620;BA.debugLine="lblTitle.Text = ModLang.T(\"backup_paste_instructi";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup_paste_instructions")));
 //BA.debugLineNum = 621;BA.debugLine="lblTitle.TextSize = Starter.FONT_BODY";
_lbltitle.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 622;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 623;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 624;BA.debugLine="pnlBox.AddView(lblTitle, 15dip, 15dip, boxW - 30d";
_pnlbox.AddView((android.view.View)(_lbltitle.getObject()),__c.DipToCurrent((int) (15)),__c.DipToCurrent((int) (15)),(int) (_boxw-__c.DipToCurrent((int) (30))),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 627;BA.debugLine="edtImportText.Initialize(\"edtImportText\")";
_edtimporttext.Initialize(ba,"edtImportText");
 //BA.debugLineNum = 628;BA.debugLine="edtImportText.Hint = ModLang.T(\"backup_paste_hint";
_edtimporttext.setHint(_modlang._t /*String*/ (ba,"backup_paste_hint"));
 //BA.debugLineNum = 629;BA.debugLine="edtImportText.SingleLine = False";
_edtimporttext.setSingleLine(__c.False);
 //BA.debugLineNum = 630;BA.debugLine="edtImportText.Gravity = Gravity.TOP";
_edtimporttext.setGravity(__c.Gravity.TOP);
 //BA.debugLineNum = 631;BA.debugLine="edtImportText.TextSize = Starter.FONT_CAPTION";
_edtimporttext.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 632;BA.debugLine="edtImportText.TextColor = Colors.White";
_edtimporttext.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 633;BA.debugLine="edtImportText.HintColor = Colors.ARGB(120, 255, 2";
_edtimporttext.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 635;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 636;BA.debugLine="cd.Initialize2(ModTheme.HomeBg, 8dip, 1dip, Color";
_cd.Initialize2(_modtheme._homebg /*int*/ (ba),__c.DipToCurrent((int) (8)),__c.DipToCurrent((int) (1)),__c.Colors.ARGB((int) (80),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 637;BA.debugLine="edtImportText.Background = cd";
_edtimporttext.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 //BA.debugLineNum = 639;BA.debugLine="pnlBox.AddView(edtImportText, 15dip, 70dip, boxW";
_pnlbox.AddView((android.view.View)(_edtimporttext.getObject()),__c.DipToCurrent((int) (15)),__c.DipToCurrent((int) (70)),(int) (_boxw-__c.DipToCurrent((int) (30))),__c.DipToCurrent((int) (200)));
 //BA.debugLineNum = 642;BA.debugLine="Dim btnW As Int = 100dip";
_btnw = __c.DipToCurrent((int) (100));
 //BA.debugLineNum = 644;BA.debugLine="btnImportTextCancel.Initialize(\"btnImportTextCanc";
_btnimporttextcancel.Initialize(ba,"btnImportTextCancel");
 //BA.debugLineNum = 645;BA.debugLine="btnImportTextCancel.Text = ModLang.T(\"cancel\")";
_btnimporttextcancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 646;BA.debugLine="btnImportTextCancel.TextSize = Starter.FONT_BUTTO";
_btnimporttextcancel.setTextSize(_starter._font_button /*float*/ );
 //BA.debugLineNum = 647;BA.debugLine="btnImportTextCancel.Color = Colors.Gray";
_btnimporttextcancel.setColor(__c.Colors.Gray);
 //BA.debugLineNum = 648;BA.debugLine="btnImportTextCancel.TextColor = Colors.White";
_btnimporttextcancel.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 649;BA.debugLine="pnlBox.AddView(btnImportTextCancel, 15dip, boxH -";
_pnlbox.AddView((android.view.View)(_btnimporttextcancel.getObject()),__c.DipToCurrent((int) (15)),(int) (_boxh-__c.DipToCurrent((int) (60))),_btnw,__c.DipToCurrent((int) (45)));
 //BA.debugLineNum = 651;BA.debugLine="btnImportTextOk.Initialize(\"btnImportTextOk\")";
_btnimporttextok.Initialize(ba,"btnImportTextOk");
 //BA.debugLineNum = 652;BA.debugLine="btnImportTextOk.Text = ModLang.T(\"backup_restore\"";
_btnimporttextok.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup_restore")));
 //BA.debugLineNum = 653;BA.debugLine="btnImportTextOk.TextSize = Starter.FONT_BUTTON";
_btnimporttextok.setTextSize(_starter._font_button /*float*/ );
 //BA.debugLineNum = 654;BA.debugLine="btnImportTextOk.Color = ModTheme.HomeIconBg";
_btnimporttextok.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 655;BA.debugLine="btnImportTextOk.TextColor = Colors.White";
_btnimporttextok.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 656;BA.debugLine="pnlBox.AddView(btnImportTextOk, boxW - btnW - 15d";
_pnlbox.AddView((android.view.View)(_btnimporttextok.getObject()),(int) (_boxw-_btnw-__c.DipToCurrent((int) (15))),(int) (_boxh-__c.DipToCurrent((int) (60))),_btnw,__c.DipToCurrent((int) (45)));
 //BA.debugLineNum = 657;BA.debugLine="End Sub";
return "";
}
public String  _createphrasedialog() throws Exception{
int _dialogw = 0;
int _dialogh = 0;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
int _btnshoww = 0;
int _edtw = 0;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
 //BA.debugLineNum = 247;BA.debugLine="Private Sub CreatePhraseDialog";
 //BA.debugLineNum = 248;BA.debugLine="Log(\"CreatePhraseDialog: inicio\")";
__c.LogImpl("551249153","CreatePhraseDialog: inicio",0);
 //BA.debugLineNum = 250;BA.debugLine="pnlOverlay.Initialize(\"pnlOverlay\")";
_pnloverlay.Initialize(ba,"pnlOverlay");
 //BA.debugLineNum = 251;BA.debugLine="pnlOverlay.Color = Colors.ARGB(180, 0, 0, 0)";
_pnloverlay.setColor(__c.Colors.ARGB((int) (180),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 252;BA.debugLine="Root.AddView(pnlOverlay, 0, 0, Root.Width, Root.H";
_root.AddView((android.view.View)(_pnloverlay.getObject()),(int) (0),(int) (0),_root.getWidth(),_root.getHeight());
 //BA.debugLineNum = 253;BA.debugLine="pnlOverlay.Visible = False";
_pnloverlay.setVisible(__c.False);
 //BA.debugLineNum = 254;BA.debugLine="Log(\"CreatePhraseDialog: overlay criado\")";
__c.LogImpl("551249159","CreatePhraseDialog: overlay criado",0);
 //BA.debugLineNum = 257;BA.debugLine="Dim dialogW As Int = Root.Width - 40dip";
_dialogw = (int) (_root.getWidth()-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 258;BA.debugLine="Dim dialogH As Int = 210dip";
_dialogh = __c.DipToCurrent((int) (210));
 //BA.debugLineNum = 260;BA.debugLine="pnlPhraseDialog.Initialize(\"\")";
_pnlphrasedialog.Initialize(ba,"");
 //BA.debugLineNum = 261;BA.debugLine="pnlPhraseDialog.Color = ModTheme.HomeHeaderBg";
_pnlphrasedialog.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 262;BA.debugLine="pnlOverlay.AddView(pnlPhraseDialog, 20dip, 100dip";
_pnloverlay.AddView((android.view.View)(_pnlphrasedialog.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (100)),_dialogw,_dialogh);
 //BA.debugLineNum = 265;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 266;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 267;BA.debugLine="lblTitle.Text = ModLang.T(\"backup_phrase_hint\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup_phrase_hint")));
 //BA.debugLineNum = 268;BA.debugLine="lblTitle.TextSize = Starter.FONT_BODY";
_lbltitle.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 269;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 270;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 271;BA.debugLine="lblTitle.Tag = \"lblPhraseTitle\"";
_lbltitle.setTag((Object)("lblPhraseTitle"));
 //BA.debugLineNum = 272;BA.debugLine="pnlPhraseDialog.AddView(lblTitle, 10dip, 10dip, d";
_pnlphrasedialog.AddView((android.view.View)(_lbltitle.getObject()),__c.DipToCurrent((int) (10)),__c.DipToCurrent((int) (10)),(int) (_dialogw-__c.DipToCurrent((int) (20))),__c.DipToCurrent((int) (60)));
 //BA.debugLineNum = 275;BA.debugLine="Dim btnShowW As Int = 65dip";
_btnshoww = __c.DipToCurrent((int) (65));
 //BA.debugLineNum = 276;BA.debugLine="Dim edtW As Int = dialogW - 40dip - btnShowW - 5d";
_edtw = (int) (_dialogw-__c.DipToCurrent((int) (40))-_btnshoww-__c.DipToCurrent((int) (5)));
 //BA.debugLineNum = 277;BA.debugLine="edtPhrase.Initialize(\"edtPhrase\")";
_edtphrase.Initialize(ba,"edtPhrase");
 //BA.debugLineNum = 278;BA.debugLine="edtPhrase.Hint = ModLang.T(\"backup_phrase_hint\")";
_edtphrase.setHint(_modlang._t /*String*/ (ba,"backup_phrase_hint"));
 //BA.debugLineNum = 279;BA.debugLine="edtPhrase.SingleLine = True";
_edtphrase.setSingleLine(__c.True);
 //BA.debugLineNum = 280;BA.debugLine="edtPhrase.InputType = Bit.Or(1, 128) 'Password";
_edtphrase.setInputType(__c.Bit.Or((int) (1),(int) (128)));
 //BA.debugLineNum = 281;BA.debugLine="edtPhrase.TextColor = Colors.White";
_edtphrase.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 282;BA.debugLine="edtPhrase.HintColor = Colors.ARGB(120, 255, 255,";
_edtphrase.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 284;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 285;BA.debugLine="cd.Initialize2(ModTheme.HomeBg, 8dip, 1dip, Color";
_cd.Initialize2(_modtheme._homebg /*int*/ (ba),__c.DipToCurrent((int) (8)),__c.DipToCurrent((int) (1)),__c.Colors.ARGB((int) (80),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 286;BA.debugLine="edtPhrase.Background = cd";
_edtphrase.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 //BA.debugLineNum = 288;BA.debugLine="pnlPhraseDialog.AddView(edtPhrase, 15dip, 80dip,";
_pnlphrasedialog.AddView((android.view.View)(_edtphrase.getObject()),__c.DipToCurrent((int) (15)),__c.DipToCurrent((int) (80)),_edtw,__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 291;BA.debugLine="btnPhraseShow.Initialize(\"btnPhraseShow\")";
_btnphraseshow.Initialize(ba,"btnPhraseShow");
 //BA.debugLineNum = 292;BA.debugLine="btnPhraseShow.Text = ModLang.T(\"show\")";
_btnphraseshow.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"show")));
 //BA.debugLineNum = 293;BA.debugLine="btnPhraseShow.TextSize = Starter.FONT_CAPTION";
_btnphraseshow.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 294;BA.debugLine="btnPhraseShow.Color = ModTheme.HomeIconBg";
_btnphraseshow.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 295;BA.debugLine="btnPhraseShow.TextColor = Colors.White";
_btnphraseshow.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 296;BA.debugLine="pnlPhraseDialog.AddView(btnPhraseShow, dialogW -";
_pnlphrasedialog.AddView((android.view.View)(_btnphraseshow.getObject()),(int) (_dialogw-_btnshoww-__c.DipToCurrent((int) (15))),__c.DipToCurrent((int) (80)),_btnshoww,__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 299;BA.debugLine="btnPhraseCancel.Initialize(\"btnPhraseCancel\")";
_btnphrasecancel.Initialize(ba,"btnPhraseCancel");
 //BA.debugLineNum = 300;BA.debugLine="btnPhraseCancel.Text = ModLang.T(\"cancel\")";
_btnphrasecancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 301;BA.debugLine="btnPhraseCancel.TextSize = Starter.FONT_BUTTON";
_btnphrasecancel.setTextSize(_starter._font_button /*float*/ );
 //BA.debugLineNum = 302;BA.debugLine="btnPhraseCancel.Color = Colors.Gray";
_btnphrasecancel.setColor(__c.Colors.Gray);
 //BA.debugLineNum = 303;BA.debugLine="btnPhraseCancel.TextColor = Colors.White";
_btnphrasecancel.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 304;BA.debugLine="pnlPhraseDialog.AddView(btnPhraseCancel, 20dip, 1";
_pnlphrasedialog.AddView((android.view.View)(_btnphrasecancel.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (145)),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (45)));
 //BA.debugLineNum = 306;BA.debugLine="btnPhraseOk.Initialize(\"btnPhraseOk\")";
_btnphraseok.Initialize(ba,"btnPhraseOk");
 //BA.debugLineNum = 307;BA.debugLine="btnPhraseOk.Text = ModLang.T(\"confirm\")";
_btnphraseok.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"confirm")));
 //BA.debugLineNum = 308;BA.debugLine="btnPhraseOk.TextSize = Starter.FONT_BUTTON";
_btnphraseok.setTextSize(_starter._font_button /*float*/ );
 //BA.debugLineNum = 309;BA.debugLine="btnPhraseOk.Color = ModTheme.HomeIconBg";
_btnphraseok.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 310;BA.debugLine="btnPhraseOk.TextColor = Colors.White";
_btnphraseok.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 311;BA.debugLine="pnlPhraseDialog.AddView(btnPhraseOk, dialogW - 12";
_pnlphrasedialog.AddView((android.view.View)(_btnphraseok.getObject()),(int) (_dialogw-__c.DipToCurrent((int) (120))),__c.DipToCurrent((int) (145)),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (45)));
 //BA.debugLineNum = 312;BA.debugLine="Log(\"CreatePhraseDialog: fim - dialog completo\")";
__c.LogImpl("551249217","CreatePhraseDialog: fim - dialog completo",0);
 //BA.debugLineNum = 313;BA.debugLine="End Sub";
return "";
}
public String  _createui() throws Exception{
int _width = 0;
int _height = 0;
int _headerh = 0;
anywheresoftware.b4a.objects.PanelWrapper _pnlheader = null;
int _y = 0;
int _btnwidth = 0;
int _btnheight = 0;
anywheresoftware.b4a.objects.LabelWrapper _lblinfo = null;
anywheresoftware.b4a.objects.PanelWrapper _sep1 = null;
anywheresoftware.b4a.objects.LabelWrapper _lblexport = null;
anywheresoftware.b4a.objects.LabelWrapper _lblexportinfo = null;
anywheresoftware.b4a.objects.PanelWrapper _sep2 = null;
anywheresoftware.b4a.objects.LabelWrapper _lblimport = null;
anywheresoftware.b4a.objects.LabelWrapper _lblimportinfo = null;
anywheresoftware.b4a.objects.PanelWrapper _sep3 = null;
anywheresoftware.b4a.objects.LabelWrapper _lbltest = null;
anywheresoftware.b4a.objects.LabelWrapper _lbltestinfo = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlwarning = null;
anywheresoftware.b4a.objects.LabelWrapper _lblwarning = null;
 //BA.debugLineNum = 76;BA.debugLine="Private Sub CreateUI";
 //BA.debugLineNum = 77;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 78;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 79;BA.debugLine="Dim headerH As Int = 56dip";
_headerh = __c.DipToCurrent((int) (56));
 //BA.debugLineNum = 82;BA.debugLine="Dim pnlHeader As Panel";
_pnlheader = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 83;BA.debugLine="pnlHeader.Initialize(\"\")";
_pnlheader.Initialize(ba,"");
 //BA.debugLineNum = 84;BA.debugLine="pnlHeader.Color = ModTheme.HomeHeaderBg";
_pnlheader.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 85;BA.debugLine="Root.AddView(pnlHeader, 0, 0, width, headerH)";
_root.AddView((android.view.View)(_pnlheader.getObject()),(int) (0),(int) (0),_width,_headerh);
 //BA.debugLineNum = 88;BA.debugLine="btnBack.Initialize(\"btnBack\")";
_btnback.Initialize(ba,"btnBack");
 //BA.debugLineNum = 89;BA.debugLine="btnBack.Text = \"<\"";
_btnback.setText(BA.ObjectToCharSequence("<"));
 //BA.debugLineNum = 90;BA.debugLine="btnBack.TextSize = 20";
_btnback.setTextSize((float) (20));
 //BA.debugLineNum = 91;BA.debugLine="btnBack.Color = Colors.Transparent";
_btnback.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 92;BA.debugLine="btnBack.TextColor = Colors.White";
_btnback.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 93;BA.debugLine="btnBack.Gravity = Gravity.CENTER";
_btnback.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 94;BA.debugLine="pnlHeader.AddView(btnBack, 0, 0, 50dip, headerH)";
_pnlheader.AddView((android.view.View)(_btnback.getObject()),(int) (0),(int) (0),__c.DipToCurrent((int) (50)),_headerh);
 //BA.debugLineNum = 97;BA.debugLine="lblHeaderTitle.Initialize(\"\")";
_lblheadertitle.Initialize(ba,"");
 //BA.debugLineNum = 98;BA.debugLine="lblHeaderTitle.Text = ModLang.T(\"backup\")";
_lblheadertitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup")));
 //BA.debugLineNum = 99;BA.debugLine="lblHeaderTitle.TextSize = 16";
_lblheadertitle.setTextSize((float) (16));
 //BA.debugLineNum = 100;BA.debugLine="lblHeaderTitle.TextColor = Colors.White";
_lblheadertitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 101;BA.debugLine="lblHeaderTitle.Typeface = Typeface.DEFAULT_BOLD";
_lblheadertitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 102;BA.debugLine="lblHeaderTitle.Gravity = Gravity.CENTER_VERTICAL";
_lblheadertitle.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 103;BA.debugLine="pnlHeader.AddView(lblHeaderTitle, 50dip, 0, width";
_pnlheader.AddView((android.view.View)(_lblheadertitle.getObject()),__c.DipToCurrent((int) (50)),(int) (0),(int) (_width-__c.DipToCurrent((int) (60))),_headerh);
 //BA.debugLineNum = 106;BA.debugLine="svContent.Initialize(0)";
_svcontent.Initialize(ba,(int) (0));
 //BA.debugLineNum = 107;BA.debugLine="svContent.Color = ModTheme.HomeBg";
_svcontent.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 108;BA.debugLine="Root.AddView(svContent, 0, headerH, width, height";
_root.AddView((android.view.View)(_svcontent.getObject()),(int) (0),_headerh,_width,(int) (_height-_headerh));
 //BA.debugLineNum = 110;BA.debugLine="pnlContent = svContent.Panel";
_pnlcontent = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_svcontent.getPanel().getObject()));
 //BA.debugLineNum = 111;BA.debugLine="pnlContent.Color = ModTheme.HomeBg";
_pnlcontent.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 113;BA.debugLine="Dim y As Int = 20dip";
_y = __c.DipToCurrent((int) (20));
 //BA.debugLineNum = 114;BA.debugLine="Dim btnWidth As Int = width - 40dip";
_btnwidth = (int) (_width-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 115;BA.debugLine="Dim btnHeight As Int = 48dip  'Starter.HEIGHT_BUT";
_btnheight = __c.DipToCurrent((int) (48));
 //BA.debugLineNum = 118;BA.debugLine="Dim lblInfo As Label";
_lblinfo = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 119;BA.debugLine="lblInfo.Initialize(\"\")";
_lblinfo.Initialize(ba,"");
 //BA.debugLineNum = 120;BA.debugLine="lblInfo.Text = ModLang.T(\"backup_last\")";
_lblinfo.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup_last")));
 //BA.debugLineNum = 121;BA.debugLine="lblInfo.TextSize = Starter.FONT_BUTTON";
_lblinfo.setTextSize(_starter._font_button /*float*/ );
 //BA.debugLineNum = 122;BA.debugLine="lblInfo.TextColor = Colors.ARGB(180, 255, 255, 25";
_lblinfo.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 123;BA.debugLine="pnlContent.AddView(lblInfo, 20dip, y, btnWidth, 2";
_pnlcontent.AddView((android.view.View)(_lblinfo.getObject()),__c.DipToCurrent((int) (20)),_y,_btnwidth,__c.DipToCurrent((int) (25)));
 //BA.debugLineNum = 124;BA.debugLine="y = y + 25dip";
_y = (int) (_y+__c.DipToCurrent((int) (25)));
 //BA.debugLineNum = 126;BA.debugLine="lblLastBackup.Initialize(\"\")";
_lbllastbackup.Initialize(ba,"");
 //BA.debugLineNum = 127;BA.debugLine="lblLastBackup.Text = ModLang.T(\"backup_never\")";
_lbllastbackup.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup_never")));
 //BA.debugLineNum = 128;BA.debugLine="lblLastBackup.TextSize = Starter.FONT_BODY";
_lbllastbackup.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 129;BA.debugLine="lblLastBackup.TextColor = Colors.White";
_lbllastbackup.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 130;BA.debugLine="pnlContent.AddView(lblLastBackup, 20dip, y, btnWi";
_pnlcontent.AddView((android.view.View)(_lbllastbackup.getObject()),__c.DipToCurrent((int) (20)),_y,_btnwidth,__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 131;BA.debugLine="y = y + 50dip";
_y = (int) (_y+__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 134;BA.debugLine="Dim sep1 As Panel";
_sep1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 135;BA.debugLine="sep1.Initialize(\"\")";
_sep1.Initialize(ba,"");
 //BA.debugLineNum = 136;BA.debugLine="sep1.Color = Colors.ARGB(60, 255, 255, 255)";
_sep1.setColor(__c.Colors.ARGB((int) (60),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 137;BA.debugLine="pnlContent.AddView(sep1, 20dip, y, btnWidth, 1dip";
_pnlcontent.AddView((android.view.View)(_sep1.getObject()),__c.DipToCurrent((int) (20)),_y,_btnwidth,__c.DipToCurrent((int) (1)));
 //BA.debugLineNum = 138;BA.debugLine="y = y + 20dip";
_y = (int) (_y+__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 141;BA.debugLine="Dim lblExport As Label";
_lblexport = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 142;BA.debugLine="lblExport.Initialize(\"\")";
_lblexport.Initialize(ba,"");
 //BA.debugLineNum = 143;BA.debugLine="lblExport.Text = ModLang.T(\"backup_export\")";
_lblexport.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup_export")));
 //BA.debugLineNum = 144;BA.debugLine="lblExport.TextSize = Starter.FONT_CAPTION";
_lblexport.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 145;BA.debugLine="lblExport.TextColor = Colors.ARGB(150, 255, 255,";
_lblexport.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 146;BA.debugLine="pnlContent.AddView(lblExport, 20dip, y, btnWidth,";
_pnlcontent.AddView((android.view.View)(_lblexport.getObject()),__c.DipToCurrent((int) (20)),_y,_btnwidth,__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 147;BA.debugLine="y = y + 25dip";
_y = (int) (_y+__c.DipToCurrent((int) (25)));
 //BA.debugLineNum = 149;BA.debugLine="btnExport.Initialize(\"btnExport\")";
_btnexport.Initialize(ba,"btnExport");
 //BA.debugLineNum = 150;BA.debugLine="btnExport.Text = ModLang.T(\"backup_create\")";
_btnexport.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup_create")));
 //BA.debugLineNum = 151;BA.debugLine="pnlContent.AddView(btnExport, 20dip, y, btnWidth,";
_pnlcontent.AddView((android.view.View)(_btnexport.getObject()),__c.DipToCurrent((int) (20)),_y,_btnwidth,_btnheight);
 //BA.debugLineNum = 152;BA.debugLine="y = y + btnHeight + 10dip";
_y = (int) (_y+_btnheight+__c.DipToCurrent((int) (10)));
 //BA.debugLineNum = 154;BA.debugLine="Dim lblExportInfo As Label";
_lblexportinfo = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 155;BA.debugLine="lblExportInfo.Initialize(\"\")";
_lblexportinfo.Initialize(ba,"");
 //BA.debugLineNum = 156;BA.debugLine="lblExportInfo.Text = ModLang.T(\"backup_create_inf";
_lblexportinfo.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup_create_info")));
 //BA.debugLineNum = 157;BA.debugLine="lblExportInfo.TextSize = Starter.FONT_CAPTION";
_lblexportinfo.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 158;BA.debugLine="lblExportInfo.TextColor = Colors.ARGB(150, 255, 2";
_lblexportinfo.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 159;BA.debugLine="pnlContent.AddView(lblExportInfo, 20dip, y, btnWi";
_pnlcontent.AddView((android.view.View)(_lblexportinfo.getObject()),__c.DipToCurrent((int) (20)),_y,_btnwidth,__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 160;BA.debugLine="y = y + 50dip";
_y = (int) (_y+__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 163;BA.debugLine="Dim sep2 As Panel";
_sep2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 164;BA.debugLine="sep2.Initialize(\"\")";
_sep2.Initialize(ba,"");
 //BA.debugLineNum = 165;BA.debugLine="sep2.Color = Colors.ARGB(60, 255, 255, 255)";
_sep2.setColor(__c.Colors.ARGB((int) (60),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 166;BA.debugLine="pnlContent.AddView(sep2, 20dip, y, btnWidth, 1dip";
_pnlcontent.AddView((android.view.View)(_sep2.getObject()),__c.DipToCurrent((int) (20)),_y,_btnwidth,__c.DipToCurrent((int) (1)));
 //BA.debugLineNum = 167;BA.debugLine="y = y + 20dip";
_y = (int) (_y+__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 170;BA.debugLine="Dim lblImport As Label";
_lblimport = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 171;BA.debugLine="lblImport.Initialize(\"\")";
_lblimport.Initialize(ba,"");
 //BA.debugLineNum = 172;BA.debugLine="lblImport.Text = ModLang.T(\"backup_import\")";
_lblimport.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup_import")));
 //BA.debugLineNum = 173;BA.debugLine="lblImport.TextSize = Starter.FONT_CAPTION";
_lblimport.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 174;BA.debugLine="lblImport.TextColor = Colors.ARGB(150, 255, 255,";
_lblimport.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 175;BA.debugLine="pnlContent.AddView(lblImport, 20dip, y, btnWidth,";
_pnlcontent.AddView((android.view.View)(_lblimport.getObject()),__c.DipToCurrent((int) (20)),_y,_btnwidth,__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 176;BA.debugLine="y = y + 25dip";
_y = (int) (_y+__c.DipToCurrent((int) (25)));
 //BA.debugLineNum = 178;BA.debugLine="btnImport.Initialize(\"btnImport\")";
_btnimport.Initialize(ba,"btnImport");
 //BA.debugLineNum = 179;BA.debugLine="btnImport.Text = ModLang.T(\"backup_restore\")";
_btnimport.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup_restore")));
 //BA.debugLineNum = 180;BA.debugLine="pnlContent.AddView(btnImport, 20dip, y, btnWidth,";
_pnlcontent.AddView((android.view.View)(_btnimport.getObject()),__c.DipToCurrent((int) (20)),_y,_btnwidth,_btnheight);
 //BA.debugLineNum = 181;BA.debugLine="y = y + btnHeight + 10dip";
_y = (int) (_y+_btnheight+__c.DipToCurrent((int) (10)));
 //BA.debugLineNum = 183;BA.debugLine="btnImportText.Initialize(\"btnImportText\")";
_btnimporttext.Initialize(ba,"btnImportText");
 //BA.debugLineNum = 184;BA.debugLine="btnImportText.Text = ModLang.T(\"backup_paste\")";
_btnimporttext.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup_paste")));
 //BA.debugLineNum = 185;BA.debugLine="pnlContent.AddView(btnImportText, 20dip, y, btnWi";
_pnlcontent.AddView((android.view.View)(_btnimporttext.getObject()),__c.DipToCurrent((int) (20)),_y,_btnwidth,_btnheight);
 //BA.debugLineNum = 186;BA.debugLine="y = y + btnHeight + 10dip";
_y = (int) (_y+_btnheight+__c.DipToCurrent((int) (10)));
 //BA.debugLineNum = 188;BA.debugLine="Dim lblImportInfo As Label";
_lblimportinfo = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 189;BA.debugLine="lblImportInfo.Initialize(\"\")";
_lblimportinfo.Initialize(ba,"");
 //BA.debugLineNum = 190;BA.debugLine="lblImportInfo.Text = ModLang.T(\"backup_restore_in";
_lblimportinfo.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup_restore_info")));
 //BA.debugLineNum = 191;BA.debugLine="lblImportInfo.TextSize = Starter.FONT_CAPTION";
_lblimportinfo.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 192;BA.debugLine="lblImportInfo.TextColor = Colors.ARGB(150, 255, 2";
_lblimportinfo.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 193;BA.debugLine="pnlContent.AddView(lblImportInfo, 20dip, y, btnWi";
_pnlcontent.AddView((android.view.View)(_lblimportinfo.getObject()),__c.DipToCurrent((int) (20)),_y,_btnwidth,__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 194;BA.debugLine="y = y + 60dip";
_y = (int) (_y+__c.DipToCurrent((int) (60)));
 //BA.debugLineNum = 197;BA.debugLine="Dim sep3 As Panel";
_sep3 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 198;BA.debugLine="sep3.Initialize(\"\")";
_sep3.Initialize(ba,"");
 //BA.debugLineNum = 199;BA.debugLine="sep3.Color = Colors.ARGB(60, 255, 255, 255)";
_sep3.setColor(__c.Colors.ARGB((int) (60),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 200;BA.debugLine="pnlContent.AddView(sep3, 20dip, y, btnWidth, 1dip";
_pnlcontent.AddView((android.view.View)(_sep3.getObject()),__c.DipToCurrent((int) (20)),_y,_btnwidth,__c.DipToCurrent((int) (1)));
 //BA.debugLineNum = 201;BA.debugLine="y = y + 20dip";
_y = (int) (_y+__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 204;BA.debugLine="Dim lblTest As Label";
_lbltest = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 205;BA.debugLine="lblTest.Initialize(\"\")";
_lbltest.Initialize(ba,"");
 //BA.debugLineNum = 206;BA.debugLine="lblTest.Text = ModLang.T(\"backup_verify\")";
_lbltest.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup_verify")));
 //BA.debugLineNum = 207;BA.debugLine="lblTest.TextSize = Starter.FONT_CAPTION";
_lbltest.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 208;BA.debugLine="lblTest.TextColor = Colors.ARGB(150, 255, 255, 25";
_lbltest.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 209;BA.debugLine="pnlContent.AddView(lblTest, 20dip, y, btnWidth, 2";
_pnlcontent.AddView((android.view.View)(_lbltest.getObject()),__c.DipToCurrent((int) (20)),_y,_btnwidth,__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 210;BA.debugLine="y = y + 25dip";
_y = (int) (_y+__c.DipToCurrent((int) (25)));
 //BA.debugLineNum = 212;BA.debugLine="btnTestRestore.Initialize(\"btnTestRestore\")";
_btntestrestore.Initialize(ba,"btnTestRestore");
 //BA.debugLineNum = 213;BA.debugLine="btnTestRestore.Text = ModLang.T(\"backup_test\")";
_btntestrestore.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup_test")));
 //BA.debugLineNum = 214;BA.debugLine="pnlContent.AddView(btnTestRestore, 20dip, y, btnW";
_pnlcontent.AddView((android.view.View)(_btntestrestore.getObject()),__c.DipToCurrent((int) (20)),_y,_btnwidth,_btnheight);
 //BA.debugLineNum = 215;BA.debugLine="y = y + btnHeight + 10dip";
_y = (int) (_y+_btnheight+__c.DipToCurrent((int) (10)));
 //BA.debugLineNum = 217;BA.debugLine="Dim lblTestInfo As Label";
_lbltestinfo = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 218;BA.debugLine="lblTestInfo.Initialize(\"\")";
_lbltestinfo.Initialize(ba,"");
 //BA.debugLineNum = 219;BA.debugLine="lblTestInfo.Text = ModLang.T(\"backup_test_info\")";
_lbltestinfo.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup_test_info")));
 //BA.debugLineNum = 220;BA.debugLine="lblTestInfo.TextSize = Starter.FONT_CAPTION";
_lbltestinfo.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 221;BA.debugLine="lblTestInfo.TextColor = Colors.ARGB(150, 255, 255";
_lbltestinfo.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 222;BA.debugLine="pnlContent.AddView(lblTestInfo, 20dip, y, btnWidt";
_pnlcontent.AddView((android.view.View)(_lbltestinfo.getObject()),__c.DipToCurrent((int) (20)),_y,_btnwidth,__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 223;BA.debugLine="y = y + 60dip";
_y = (int) (_y+__c.DipToCurrent((int) (60)));
 //BA.debugLineNum = 226;BA.debugLine="Dim pnlWarning As Panel";
_pnlwarning = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 227;BA.debugLine="pnlWarning.Initialize(\"\")";
_pnlwarning.Initialize(ba,"");
 //BA.debugLineNum = 228;BA.debugLine="pnlWarning.Color = ModTheme.HomeHeaderBg";
_pnlwarning.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 229;BA.debugLine="pnlContent.AddView(pnlWarning, 20dip, y, btnWidth";
_pnlcontent.AddView((android.view.View)(_pnlwarning.getObject()),__c.DipToCurrent((int) (20)),_y,_btnwidth,__c.DipToCurrent((int) (80)));
 //BA.debugLineNum = 231;BA.debugLine="Dim lblWarning As Label";
_lblwarning = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 232;BA.debugLine="lblWarning.Initialize(\"\")";
_lblwarning.Initialize(ba,"");
 //BA.debugLineNum = 233;BA.debugLine="lblWarning.Text = ModLang.T(\"backup_tip\")";
_lblwarning.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup_tip")));
 //BA.debugLineNum = 234;BA.debugLine="lblWarning.TextSize = Starter.FONT_LABEL";
_lblwarning.setTextSize(_starter._font_label /*float*/ );
 //BA.debugLineNum = 235;BA.debugLine="lblWarning.TextColor = Colors.White";
_lblwarning.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 236;BA.debugLine="lblWarning.Gravity = Gravity.CENTER";
_lblwarning.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 237;BA.debugLine="lblWarning.Typeface = Typeface.DEFAULT_BOLD";
_lblwarning.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 238;BA.debugLine="pnlWarning.AddView(lblWarning, 10dip, 10dip, btnW";
_pnlwarning.AddView((android.view.View)(_lblwarning.getObject()),__c.DipToCurrent((int) (10)),__c.DipToCurrent((int) (10)),(int) (_btnwidth-__c.DipToCurrent((int) (20))),__c.DipToCurrent((int) (60)));
 //BA.debugLineNum = 239;BA.debugLine="y = y + 100dip";
_y = (int) (_y+__c.DipToCurrent((int) (100)));
 //BA.debugLineNum = 241;BA.debugLine="pnlContent.Height = y + 20dip";
_pnlcontent.setHeight((int) (_y+__c.DipToCurrent((int) (20))));
 //BA.debugLineNum = 244;BA.debugLine="CreatePhraseDialog";
_createphrasedialog();
 //BA.debugLineNum = 245;BA.debugLine="End Sub";
return "";
}
public void  _doexport(String _phrase) throws Exception{
ResumableSub_DoExport rsub = new ResumableSub_DoExport(this,_phrase);
rsub.resume(ba, null);
}
public static class ResumableSub_DoExport extends BA.ResumableSub {
public ResumableSub_DoExport(com.lockzero.pagebackup parent,String _phrase) {
this.parent = parent;
this._phrase = _phrase;
}
com.lockzero.pagebackup parent;
String _phrase;
String _folder = "";
String _fullpath = "";
String _filename = "";
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 448;BA.debugLine="Dim folder As String = Starter.Provider.SharedFol";
_folder = parent._starter._provider /*com.lockzero.fileprovider*/ ._sharedfolder /*String*/ ;
 //BA.debugLineNum = 449;BA.debugLine="Dim fullPath As String = ModBackup.ExportBackup(p";
_fullpath = parent._modbackup._exportbackup /*String*/ (ba,_phrase,_folder);
 //BA.debugLineNum = 451;BA.debugLine="If fullPath <> \"\" Then";
if (true) break;

case 1:
//if
this.state = 10;
if ((_fullpath).equals("") == false) { 
this.state = 3;
}else {
this.state = 9;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 453;BA.debugLine="Dim fileName As String = fullPath.SubString(full";
_filename = _fullpath.substring((int) (_fullpath.lastIndexOf("/")+1));
 //BA.debugLineNum = 454;BA.debugLine="Log(\"DoExport: arquivo = \" & fileName)";
parent.__c.LogImpl("552035592","DoExport: arquivo = "+_filename,0);
 //BA.debugLineNum = 456;BA.debugLine="UpdateLastBackupInfo";
parent._updatelastbackupinfo();
 //BA.debugLineNum = 459;BA.debugLine="Wait For (xui.Msgbox2Async(ModLang.T(\"backup_suc";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"backup_success")+parent.__c.CRLF+parent.__c.CRLF+parent._modlang._t /*String*/ (ba,"backup_share_question")),BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"success")),parent._modlang._t /*String*/ (ba,"share"),"",parent._modlang._t /*String*/ (ba,"no"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 11;
return;
case 11:
//C
this.state = 4;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 461;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
if (true) break;

case 4:
//if
this.state = 7;
if (_result==parent._xui.DialogResponse_Positive) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 462;BA.debugLine="ShareBackupAsFile(fileName)";
parent._sharebackupasfile(_filename);
 if (true) break;

case 7:
//C
this.state = 10;
;
 if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 465;BA.debugLine="xui.MsgboxAsync(ModLang.T(\"backup_error\"), ModLa";
parent._xui.MsgboxAsync(ba,BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"backup_error")),BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"error")));
 if (true) break;

case 10:
//C
this.state = -1;
;
 //BA.debugLineNum = 467;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _msgbox_result(int _result) throws Exception{
}
public void  _doimport(String _phrase,String _folder,String _filename) throws Exception{
ResumableSub_DoImport rsub = new ResumableSub_DoImport(this,_phrase,_folder,_filename);
rsub.resume(ba, null);
}
public static class ResumableSub_DoImport extends BA.ResumableSub {
public ResumableSub_DoImport(com.lockzero.pagebackup parent,String _phrase,String _folder,String _filename) {
this.parent = parent;
this._phrase = _phrase;
this._folder = _folder;
this._filename = _filename;
}
com.lockzero.pagebackup parent;
String _phrase;
String _folder;
String _filename;
int _dialogresult = 0;
anywheresoftware.b4a.objects.collections.Map _importresult = null;
anywheresoftware.b4a.objects.collections.Map _stats = null;
String _msg = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 512;BA.debugLine="Wait For (xui.Msgbox2Async(ModLang.T(\"backup_conf";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"backup_confirm_restore")+parent.__c.CRLF+parent.__c.CRLF+parent._modlang._t /*String*/ (ba,"backup_continue")),BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"confirm")),parent._modlang._t /*String*/ (ba,"yes"),"",parent._modlang._t /*String*/ (ba,"cancel"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 13;
return;
case 13:
//C
this.state = 1;
_dialogresult = (Integer) result[0];
;
 //BA.debugLineNum = 514;BA.debugLine="If DialogResult <> xui.DialogResponse_Positive Th";
if (true) break;

case 1:
//if
this.state = 6;
if (_dialogresult!=parent._xui.DialogResponse_Positive) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
if (true) return ;
if (true) break;

case 6:
//C
this.state = 7;
;
 //BA.debugLineNum = 516;BA.debugLine="Dim importResult As Map = ModBackup.ImportBackup(";
_importresult = new anywheresoftware.b4a.objects.collections.Map();
_importresult = parent._modbackup._importbackup /*anywheresoftware.b4a.objects.collections.Map*/ (ba,_phrase,_folder,_filename);
 //BA.debugLineNum = 518;BA.debugLine="If importResult.Get(\"success\") = True Then";
if (true) break;

case 7:
//if
this.state = 12;
if ((_importresult.Get((Object)("success"))).equals((Object)(parent.__c.True))) { 
this.state = 9;
}else {
this.state = 11;
}if (true) break;

case 9:
//C
this.state = 12;
 //BA.debugLineNum = 519;BA.debugLine="Dim stats As Map = importResult.Get(\"stats\")";
_stats = new anywheresoftware.b4a.objects.collections.Map();
_stats = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_importresult.Get((Object)("stats"))));
 //BA.debugLineNum = 520;BA.debugLine="Dim msg As String = ModLang.T(\"backup_restored\")";
_msg = parent._modlang._t /*String*/ (ba,"backup_restored")+parent.__c.CRLF+parent.__c.CRLF;
 //BA.debugLineNum = 521;BA.debugLine="msg = msg & ModLang.T(\"backup_groups\") & \" \" & s";
_msg = _msg+parent._modlang._t /*String*/ (ba,"backup_groups")+" "+BA.ObjectToString(_stats.Get((Object)("groupsImported")))+parent.__c.CRLF;
 //BA.debugLineNum = 522;BA.debugLine="msg = msg & ModLang.T(\"backup_entries\") & \" \" &";
_msg = _msg+parent._modlang._t /*String*/ (ba,"backup_entries")+" "+BA.ObjectToString(_stats.Get((Object)("entriesImported")))+parent.__c.CRLF;
 //BA.debugLineNum = 523;BA.debugLine="msg = msg & ModLang.T(\"backup_notes\") & \" \" & st";
_msg = _msg+parent._modlang._t /*String*/ (ba,"backup_notes")+" "+BA.ObjectToString(_stats.GetDefault((Object)("notesImported"),(Object)(0)));
 //BA.debugLineNum = 524;BA.debugLine="xui.MsgboxAsync(msg, ModLang.T(\"success\"))";
parent._xui.MsgboxAsync(ba,BA.ObjectToCharSequence(_msg),BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"success")));
 if (true) break;

case 11:
//C
this.state = 12;
 //BA.debugLineNum = 526;BA.debugLine="xui.MsgboxAsync(importResult.Get(\"message\"), Mod";
parent._xui.MsgboxAsync(ba,BA.ObjectToCharSequence(_importresult.Get((Object)("message"))),BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"error")));
 if (true) break;

case 12:
//C
this.state = -1;
;
 //BA.debugLineNum = 528;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _doimportwithphrase(String _phrase) throws Exception{
 //BA.debugLineNum = 506;BA.debugLine="Private Sub DoImportWithPhrase(phrase As String)";
 //BA.debugLineNum = 507;BA.debugLine="DoImport(phrase, CurrentBackupFolder, CurrentBack";
_doimport(_phrase,_currentbackupfolder,_currentbackupfilename);
 //BA.debugLineNum = 508;BA.debugLine="End Sub";
return "";
}
public String  _dotest(String _phrase,String _folder,String _filename) throws Exception{
anywheresoftware.b4a.objects.collections.Map _result = null;
anywheresoftware.b4a.objects.collections.Map _stats = null;
long _createdat = 0L;
String _datestr = "";
String _msg = "";
 //BA.debugLineNum = 551;BA.debugLine="Private Sub DoTest(phrase As String, folder As Str";
 //BA.debugLineNum = 552;BA.debugLine="Dim result As Map = ModBackup.ValidateBackup(phra";
_result = new anywheresoftware.b4a.objects.collections.Map();
_result = _modbackup._validatebackup /*anywheresoftware.b4a.objects.collections.Map*/ (ba,_phrase,_folder,_filename);
 //BA.debugLineNum = 554;BA.debugLine="If result.Get(\"valid\") = True Then";
if ((_result.Get((Object)("valid"))).equals((Object)(__c.True))) { 
 //BA.debugLineNum = 555;BA.debugLine="Dim stats As Map = result.Get(\"stats\")";
_stats = new anywheresoftware.b4a.objects.collections.Map();
_stats = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_result.Get((Object)("stats"))));
 //BA.debugLineNum = 556;BA.debugLine="Dim createdAt As Long = result.Get(\"createdAt\")";
_createdat = BA.ObjectToLongNumber(_result.Get((Object)("createdAt")));
 //BA.debugLineNum = 558;BA.debugLine="DateTime.DateFormat = \"dd/MM/yyyy HH:mm\"";
__c.DateTime.setDateFormat("dd/MM/yyyy HH:mm");
 //BA.debugLineNum = 559;BA.debugLine="Dim dateStr As String = DateTime.Date(createdAt)";
_datestr = __c.DateTime.Date(_createdat);
 //BA.debugLineNum = 561;BA.debugLine="Dim msg As String = ModLang.T(\"backup_valid\") &";
_msg = _modlang._t /*String*/ (ba,"backup_valid")+__c.CRLF+__c.CRLF;
 //BA.debugLineNum = 562;BA.debugLine="msg = msg & ModLang.T(\"backup_created_at\") & \" \"";
_msg = _msg+_modlang._t /*String*/ (ba,"backup_created_at")+" "+_datestr+__c.CRLF;
 //BA.debugLineNum = 563;BA.debugLine="If stats <> Null Then";
if (_stats!= null) { 
 //BA.debugLineNum = 564;BA.debugLine="msg = msg & ModLang.T(\"backup_groups\") & \" \" &";
_msg = _msg+_modlang._t /*String*/ (ba,"backup_groups")+" "+BA.ObjectToString(_stats.GetDefault((Object)("totalGroups"),(Object)(0)))+__c.CRLF;
 //BA.debugLineNum = 565;BA.debugLine="msg = msg & ModLang.T(\"backup_entries\") & \" \" &";
_msg = _msg+_modlang._t /*String*/ (ba,"backup_entries")+" "+BA.ObjectToString(_stats.GetDefault((Object)("totalEntries"),(Object)(0)))+__c.CRLF;
 //BA.debugLineNum = 566;BA.debugLine="msg = msg & ModLang.T(\"backup_notes\") & \" \" & s";
_msg = _msg+_modlang._t /*String*/ (ba,"backup_notes")+" "+BA.ObjectToString(_stats.GetDefault((Object)("totalNotes"),(Object)(0)));
 };
 //BA.debugLineNum = 569;BA.debugLine="xui.MsgboxAsync(msg, ModLang.T(\"backup_test_ok\")";
_xui.MsgboxAsync(ba,BA.ObjectToCharSequence(_msg),BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup_test_ok")));
 }else {
 //BA.debugLineNum = 571;BA.debugLine="xui.MsgboxAsync(ModLang.T(\"backup_test_failed\"),";
_xui.MsgboxAsync(ba,BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup_test_failed")),BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error")));
 };
 //BA.debugLineNum = 573;BA.debugLine="End Sub";
return "";
}
public String  _dotestwithphrase(String _phrase) throws Exception{
 //BA.debugLineNum = 547;BA.debugLine="Private Sub DoTestWithPhrase(phrase As String)";
 //BA.debugLineNum = 548;BA.debugLine="DoTest(phrase, CurrentBackupFolder, CurrentBackup";
_dotest(_phrase,_currentbackupfolder,_currentbackupfilename);
 //BA.debugLineNum = 549;BA.debugLine="End Sub";
return "";
}
public String  _hideimporttextdialog() throws Exception{
 //BA.debugLineNum = 673;BA.debugLine="Private Sub HideImportTextDialog";
 //BA.debugLineNum = 674;BA.debugLine="pnlImportTextDialog.Visible = False";
_pnlimporttextdialog.setVisible(__c.False);
 //BA.debugLineNum = 675;BA.debugLine="edtImportText.Text = \"\"";
_edtimporttext.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 676;BA.debugLine="End Sub";
return "";
}
public String  _hidephrasedialog() throws Exception{
anywheresoftware.b4a.objects.IME _ime = null;
 //BA.debugLineNum = 350;BA.debugLine="Private Sub HidePhraseDialog";
 //BA.debugLineNum = 351;BA.debugLine="pnlOverlay.Visible = False";
_pnloverlay.setVisible(__c.False);
 //BA.debugLineNum = 352;BA.debugLine="Dim ime As IME";
_ime = new anywheresoftware.b4a.objects.IME();
 //BA.debugLineNum = 353;BA.debugLine="ime.Initialize(\"\")";
_ime.Initialize("");
 //BA.debugLineNum = 354;BA.debugLine="ime.HideKeyboard";
_ime.HideKeyboard(ba);
 //BA.debugLineNum = 355;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 41;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return "";
}
public String  _pnloverlay_click() throws Exception{
 //BA.debugLineNum = 357;BA.debugLine="Private Sub pnlOverlay_Click";
 //BA.debugLineNum = 358;BA.debugLine="HidePhraseDialog";
_hidephrasedialog();
 //BA.debugLineNum = 359;BA.debugLine="End Sub";
return "";
}
public String  _sharebackupasfile(String _filename) throws Exception{
Object _uri = null;
anywheresoftware.b4a.objects.IntentWrapper _shareintent = null;
 //BA.debugLineNum = 469;BA.debugLine="Private Sub ShareBackupAsFile(fileName As String)";
 //BA.debugLineNum = 470;BA.debugLine="Try";
try { //BA.debugLineNum = 471;BA.debugLine="Log(\"ShareBackupAsFile: \" & fileName)";
__c.LogImpl("564028674","ShareBackupAsFile: "+_filename,0);
 //BA.debugLineNum = 472;BA.debugLine="Dim uri As Object = Starter.Provider.GetFileUri(";
_uri = _starter._provider /*com.lockzero.fileprovider*/ ._getfileuri /*Object*/ (_filename);
 //BA.debugLineNum = 473;BA.debugLine="Log(\"ShareBackupAsFile URI: \" & uri)";
__c.LogImpl("564028676","ShareBackupAsFile URI: "+BA.ObjectToString(_uri),0);
 //BA.debugLineNum = 475;BA.debugLine="Dim shareIntent As Intent";
_shareintent = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 476;BA.debugLine="shareIntent.Initialize(shareIntent.ACTION_SEND,";
_shareintent.Initialize(_shareintent.ACTION_SEND,"");
 //BA.debugLineNum = 477;BA.debugLine="shareIntent.SetType(\"application/vnd.lockzero\")";
_shareintent.SetType("application/vnd.lockzero");
 //BA.debugLineNum = 478;BA.debugLine="shareIntent.PutExtra(\"android.intent.extra.SUBJE";
_shareintent.PutExtra("android.intent.extra.SUBJECT",(Object)("LockZero Backup"));
 //BA.debugLineNum = 479;BA.debugLine="shareIntent.PutExtra(\"android.intent.extra.STREA";
_shareintent.PutExtra("android.intent.extra.STREAM",_uri);
 //BA.debugLineNum = 480;BA.debugLine="shareIntent.Flags = 1 'FLAG_GRANT_READ_URI_PERMI";
_shareintent.setFlags((int) (1));
 //BA.debugLineNum = 481;BA.debugLine="StartActivity(shareIntent)";
__c.StartActivity(ba,(Object)(_shareintent.getObject()));
 } 
       catch (Exception e13) {
			ba.setLastException(e13); //BA.debugLineNum = 483;BA.debugLine="Log(\"ShareBackupAsFile erro: \" & LastException)";
__c.LogImpl("564028686","ShareBackupAsFile erro: "+BA.ObjectToString(__c.LastException(ba)),0);
 //BA.debugLineNum = 484;BA.debugLine="ToastMessageShow(ModLang.T(\"share_error\"), True)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"share_error")),__c.True);
 };
 //BA.debugLineNum = 486;BA.debugLine="End Sub";
return "";
}
public String  _showexportdialog() throws Exception{
 //BA.debugLineNum = 440;BA.debugLine="Private Sub ShowExportDialog";
 //BA.debugLineNum = 441;BA.debugLine="Log(\"ShowExportDialog: inicio\")";
__c.LogImpl("551970049","ShowExportDialog: inicio",0);
 //BA.debugLineNum = 442;BA.debugLine="ShowPhraseDialog(\"export\", ModLang.T(\"backup_phra";
_showphrasedialog("export",_modlang._t /*String*/ (ba,"backup_phrase_hint"));
 //BA.debugLineNum = 443;BA.debugLine="Log(\"ShowExportDialog: fim\")";
__c.LogImpl("551970051","ShowExportDialog: fim",0);
 //BA.debugLineNum = 444;BA.debugLine="End Sub";
return "";
}
public String  _showimportdialog() throws Exception{
anywheresoftware.b4a.objects.collections.List _backups = null;
anywheresoftware.b4a.objects.collections.Map _latest = null;
 //BA.debugLineNum = 488;BA.debugLine="Private Sub ShowImportDialog";
 //BA.debugLineNum = 490;BA.debugLine="CurrentBackupFolder = Starter.Provider.SharedFold";
_currentbackupfolder = _starter._provider /*com.lockzero.fileprovider*/ ._sharedfolder /*String*/ ;
 //BA.debugLineNum = 492;BA.debugLine="Dim backups As List = ModBackup.ListBackups(Curre";
_backups = new anywheresoftware.b4a.objects.collections.List();
_backups = _modbackup._listbackups /*anywheresoftware.b4a.objects.collections.List*/ (ba,_currentbackupfolder);
 //BA.debugLineNum = 494;BA.debugLine="If backups.Size = 0 Then";
if (_backups.getSize()==0) { 
 //BA.debugLineNum = 495;BA.debugLine="xui.MsgboxAsync(ModLang.T(\"backup_none_found\") &";
_xui.MsgboxAsync(ba,BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup_none_found")+":"+__c.CRLF+_currentbackupfolder),BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup")));
 //BA.debugLineNum = 496;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 500;BA.debugLine="Dim latest As Map = backups.Get(backups.Size - 1)";
_latest = new anywheresoftware.b4a.objects.collections.Map();
_latest = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_backups.Get((int) (_backups.getSize()-1))));
 //BA.debugLineNum = 501;BA.debugLine="CurrentBackupFileName = latest.Get(\"fileName\")";
_currentbackupfilename = BA.ObjectToString(_latest.Get((Object)("fileName")));
 //BA.debugLineNum = 503;BA.debugLine="ShowPhraseDialog(\"import\", CurrentBackupFileName";
_showphrasedialog("import",_currentbackupfilename+__c.CRLF+_modlang._t /*String*/ (ba,"backup_enter_phrase"));
 //BA.debugLineNum = 504;BA.debugLine="End Sub";
return "";
}
public String  _showimporttextdialog() throws Exception{
 //BA.debugLineNum = 664;BA.debugLine="Private Sub ShowImportTextDialog";
 //BA.debugLineNum = 665;BA.debugLine="If pnlImportTextDialog.IsInitialized = False Then";
if (_pnlimporttextdialog.IsInitialized()==__c.False) { 
 //BA.debugLineNum = 666;BA.debugLine="CreateImportTextDialog";
_createimporttextdialog();
 };
 //BA.debugLineNum = 668;BA.debugLine="edtImportText.Text = \"\"";
_edtimporttext.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 669;BA.debugLine="pnlImportTextDialog.Visible = True";
_pnlimporttextdialog.setVisible(__c.True);
 //BA.debugLineNum = 670;BA.debugLine="pnlImportTextDialog.BringToFront";
_pnlimporttextdialog.BringToFront();
 //BA.debugLineNum = 671;BA.debugLine="End Sub";
return "";
}
public String  _showphrasedialog(String _mode,String _title) throws Exception{
int _i = 0;
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
 //BA.debugLineNum = 315;BA.debugLine="Private Sub ShowPhraseDialog(mode As String, title";
 //BA.debugLineNum = 316;BA.debugLine="Log(\"ShowPhraseDialog: mode=\" & mode)";
__c.LogImpl("551314689","ShowPhraseDialog: mode="+_mode,0);
 //BA.debugLineNum = 317;BA.debugLine="Log(\"ShowPhraseDialog: pnlOverlay.IsInitialized=\"";
__c.LogImpl("551314690","ShowPhraseDialog: pnlOverlay.IsInitialized="+BA.ObjectToString(_pnloverlay.IsInitialized()),0);
 //BA.debugLineNum = 318;BA.debugLine="Log(\"ShowPhraseDialog: pnlPhraseDialog.IsInitiali";
__c.LogImpl("551314691","ShowPhraseDialog: pnlPhraseDialog.IsInitialized="+BA.ObjectToString(_pnlphrasedialog.IsInitialized()),0);
 //BA.debugLineNum = 320;BA.debugLine="If pnlOverlay.IsInitialized = False Then";
if (_pnloverlay.IsInitialized()==__c.False) { 
 //BA.debugLineNum = 321;BA.debugLine="Log(\"ShowPhraseDialog: criando dialog pois nao e";
__c.LogImpl("551314694","ShowPhraseDialog: criando dialog pois nao existe",0);
 //BA.debugLineNum = 322;BA.debugLine="CreatePhraseDialog";
_createphrasedialog();
 };
 //BA.debugLineNum = 325;BA.debugLine="CurrentDialogMode = mode";
_currentdialogmode = _mode;
 //BA.debugLineNum = 326;BA.debugLine="edtPhrase.Text = \"\"";
_edtphrase.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 327;BA.debugLine="PhraseVisible = False";
_phrasevisible = __c.False;
 //BA.debugLineNum = 328;BA.debugLine="edtPhrase.InputType = Bit.Or(1, 128) 'PASSWORD";
_edtphrase.setInputType(__c.Bit.Or((int) (1),(int) (128)));
 //BA.debugLineNum = 329;BA.debugLine="btnPhraseShow.Text = ModLang.T(\"show\")";
_btnphraseshow.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"show")));
 //BA.debugLineNum = 331;BA.debugLine="Log(\"ShowPhraseDialog: atualizando titulo\")";
__c.LogImpl("551314704","ShowPhraseDialog: atualizando titulo",0);
 //BA.debugLineNum = 333;BA.debugLine="For i = 0 To pnlPhraseDialog.NumberOfViews - 1";
{
final int step14 = 1;
final int limit14 = (int) (_pnlphrasedialog.getNumberOfViews()-1);
_i = (int) (0) ;
for (;_i <= limit14 ;_i = _i + step14 ) {
 //BA.debugLineNum = 334;BA.debugLine="Dim v As View = pnlPhraseDialog.GetView(i)";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
_v = _pnlphrasedialog.GetView(_i);
 //BA.debugLineNum = 335;BA.debugLine="If v.Tag <> Null Then";
if (_v.getTag()!= null) { 
 //BA.debugLineNum = 336;BA.debugLine="If v.Tag = \"lblPhraseTitle\" Then";
if ((_v.getTag()).equals((Object)("lblPhraseTitle"))) { 
 //BA.debugLineNum = 337;BA.debugLine="Dim lbl As Label = v";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
_lbl = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_v.getObject()));
 //BA.debugLineNum = 338;BA.debugLine="lbl.Text = title";
_lbl.setText(BA.ObjectToCharSequence(_title));
 };
 };
 }
};
 //BA.debugLineNum = 343;BA.debugLine="Log(\"ShowPhraseDialog: mostrando overlay\")";
__c.LogImpl("551314716","ShowPhraseDialog: mostrando overlay",0);
 //BA.debugLineNum = 344;BA.debugLine="pnlOverlay.Visible = True";
_pnloverlay.setVisible(__c.True);
 //BA.debugLineNum = 345;BA.debugLine="pnlOverlay.BringToFront";
_pnloverlay.BringToFront();
 //BA.debugLineNum = 346;BA.debugLine="edtPhrase.RequestFocus";
_edtphrase.RequestFocus();
 //BA.debugLineNum = 347;BA.debugLine="Log(\"ShowPhraseDialog: fim\")";
__c.LogImpl("551314720","ShowPhraseDialog: fim",0);
 //BA.debugLineNum = 348;BA.debugLine="End Sub";
return "";
}
public String  _showtestdialog() throws Exception{
anywheresoftware.b4a.objects.collections.List _backups = null;
anywheresoftware.b4a.objects.collections.Map _latest = null;
 //BA.debugLineNum = 530;BA.debugLine="Private Sub ShowTestDialog";
 //BA.debugLineNum = 532;BA.debugLine="CurrentBackupFolder = Starter.Provider.SharedFold";
_currentbackupfolder = _starter._provider /*com.lockzero.fileprovider*/ ._sharedfolder /*String*/ ;
 //BA.debugLineNum = 534;BA.debugLine="Dim backups As List = ModBackup.ListBackups(Curre";
_backups = new anywheresoftware.b4a.objects.collections.List();
_backups = _modbackup._listbackups /*anywheresoftware.b4a.objects.collections.List*/ (ba,_currentbackupfolder);
 //BA.debugLineNum = 536;BA.debugLine="If backups.Size = 0 Then";
if (_backups.getSize()==0) { 
 //BA.debugLineNum = 537;BA.debugLine="xui.MsgboxAsync(ModLang.T(\"backup_none_found\"),";
_xui.MsgboxAsync(ba,BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup_none_found")),BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup")));
 //BA.debugLineNum = 538;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 541;BA.debugLine="Dim latest As Map = backups.Get(backups.Size - 1)";
_latest = new anywheresoftware.b4a.objects.collections.Map();
_latest = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_backups.Get((int) (_backups.getSize()-1))));
 //BA.debugLineNum = 542;BA.debugLine="CurrentBackupFileName = latest.Get(\"fileName\")";
_currentbackupfilename = BA.ObjectToString(_latest.Get((Object)("fileName")));
 //BA.debugLineNum = 544;BA.debugLine="ShowPhraseDialog(\"test\", CurrentBackupFileName &";
_showphrasedialog("test",_currentbackupfilename+__c.CRLF+_modlang._t /*String*/ (ba,"backup_enter_phrase"));
 //BA.debugLineNum = 545;BA.debugLine="End Sub";
return "";
}
public String  _updatelastbackupinfo() throws Exception{
 //BA.debugLineNum = 402;BA.debugLine="Private Sub UpdateLastBackupInfo";
 //BA.debugLineNum = 403;BA.debugLine="If ModBackup.HasBackup Then";
if (_modbackup._hasbackup /*boolean*/ (ba)) { 
 //BA.debugLineNum = 404;BA.debugLine="lblLastBackup.Text = ModBackup.GetLastBackupTime";
_lbllastbackup.setText(BA.ObjectToCharSequence(_modbackup._getlastbackuptimeformatted /*String*/ (ba)));
 //BA.debugLineNum = 405;BA.debugLine="lblLastBackup.TextColor = ModTheme.Success";
_lbllastbackup.setTextColor(_modtheme._success /*int*/ (ba));
 }else {
 //BA.debugLineNum = 407;BA.debugLine="lblLastBackup.Text = ModLang.T(\"backup_never\")";
_lbllastbackup.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"backup_never")));
 //BA.debugLineNum = 408;BA.debugLine="lblLastBackup.TextColor = ModTheme.Danger";
_lbllastbackup.setTextColor(_modtheme._danger /*int*/ (ba));
 };
 //BA.debugLineNum = 410;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
