package com.lockzero;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class pagepasswordlist extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.lockzero.pagepasswordlist");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.lockzero.pagepasswordlist.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public String _currentgroupid = "";
public String _currentgroupname = "";
public anywheresoftware.b4a.objects.ButtonWrapper _btnback = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblheadertitle = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _sventries = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _pnlentries = null;
public anywheresoftware.b4a.objects.Timer _tmrclipboard = null;
public int _clipboardcountdown = 0;
public anywheresoftware.b4a.objects.PanelWrapper _pnloverlay = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnldialog = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtpassphrase = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnshowpass = null;
public boolean _ispassvisible = false;
public anywheresoftware.b4a.objects.LabelWrapper _lblsessiontimer = null;
public anywheresoftware.b4a.objects.Timer _tmrsession = null;
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
 //BA.debugLineNum = 622;BA.debugLine="Private Sub ApplyTheme";
 //BA.debugLineNum = 623;BA.debugLine="Root.Color = ModTheme.HomeBg";
_root.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 624;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_appear() throws Exception{
com.lockzero.clspasswordgroup _g = null;
 //BA.debugLineNum = 46;BA.debugLine="Private Sub B4XPage_Appear";
 //BA.debugLineNum = 48;BA.debugLine="If ModSession.IsSessionActive = False Then";
if (_modsession._issessionactive /*boolean*/ (ba)==__c.False) { 
 //BA.debugLineNum = 49;BA.debugLine="Log(\"PagePasswordList: Sessao inativa - redireci";
__c.LogImpl("757016323","PagePasswordList: Sessao inativa - redirecionando",0);
 //BA.debugLineNum = 50;BA.debugLine="B4XPages.ClosePage(Me)";
_b4xpages._closepage /*String*/ (ba,this);
 //BA.debugLineNum = 51;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 55;BA.debugLine="Dim g As clsPasswordGroup = ModPasswords.GetGroup";
_g = _modpasswords._getgroupbyid /*com.lockzero.clspasswordgroup*/ (ba,_currentgroupid);
 //BA.debugLineNum = 56;BA.debugLine="If g.IsInitialized Then";
if (_g._isinitialized /*boolean*/ ()) { 
 //BA.debugLineNum = 57;BA.debugLine="CurrentGroupName = g.Name";
_currentgroupname = _g._name /*String*/ ;
 //BA.debugLineNum = 58;BA.debugLine="lblHeaderTitle.Text = ModLang.T(\"passwords\") & \"";
_lblheadertitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"passwords")+" → "+_currentgroupname));
 }else {
 //BA.debugLineNum = 60;BA.debugLine="lblHeaderTitle.Text = ModLang.T(\"passwords\")";
_lblheadertitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"passwords")));
 };
 //BA.debugLineNum = 63;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 66;BA.debugLine="svEntries.ScrollPosition = 0";
_sventries.setScrollPosition((int) (0));
 //BA.debugLineNum = 68;BA.debugLine="LoadEntries";
_loadentries();
 //BA.debugLineNum = 71;BA.debugLine="UpdateSessionTimer";
_updatesessiontimer();
 //BA.debugLineNum = 72;BA.debugLine="tmrSession.Enabled = True";
_tmrsession.setEnabled(__c.True);
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
 //BA.debugLineNum = 40;BA.debugLine="Private Sub B4XPage_Created(Root1 As B4XView)";
 //BA.debugLineNum = 41;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 42;BA.debugLine="CreateUI";
_createui();
 //BA.debugLineNum = 43;BA.debugLine="ApplyTheme";
_applytheme();
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_disappear() throws Exception{
 //BA.debugLineNum = 108;BA.debugLine="Private Sub B4XPage_Disappear";
 //BA.debugLineNum = 109;BA.debugLine="tmrClipboard.Enabled = False";
_tmrclipboard.setEnabled(__c.False);
 //BA.debugLineNum = 110;BA.debugLine="tmrSession.Enabled = False";
_tmrsession.setEnabled(__c.False);
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
return "";
}
public String  _btnadd_click() throws Exception{
 //BA.debugLineNum = 305;BA.debugLine="Private Sub btnAdd_Click";
 //BA.debugLineNum = 306;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 308;BA.debugLine="If ModSession.IsSessionActive = False Then";
if (_modsession._issessionactive /*boolean*/ (ba)==__c.False) { 
 //BA.debugLineNum = 309;BA.debugLine="ShowPassphraseDialog";
_showpassphrasedialog();
 }else {
 //BA.debugLineNum = 311;BA.debugLine="NavigateToAddPassword";
_navigatetoaddpassword();
 };
 //BA.debugLineNum = 313;BA.debugLine="End Sub";
return "";
}
public String  _btnback_click() throws Exception{
 //BA.debugLineNum = 301;BA.debugLine="Private Sub btnBack_Click";
 //BA.debugLineNum = 302;BA.debugLine="B4XPages.ClosePage(Me)";
_b4xpages._closepage /*String*/ (ba,this);
 //BA.debugLineNum = 303;BA.debugLine="End Sub";
return "";
}
public String  _btncopy_click() throws Exception{
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
String _entryid = "";
 //BA.debugLineNum = 448;BA.debugLine="Private Sub btnCopy_Click";
 //BA.debugLineNum = 449;BA.debugLine="Dim btn As Button = Sender";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
_btn = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(__c.Sender(ba)));
 //BA.debugLineNum = 450;BA.debugLine="Dim entryId As String = btn.Tag";
_entryid = BA.ObjectToString(_btn.getTag());
 //BA.debugLineNum = 452;BA.debugLine="CopyPassword(entryId)";
_copypassword(_entryid);
 //BA.debugLineNum = 453;BA.debugLine="End Sub";
return "";
}
public String  _btndialogcancel_click() throws Exception{
 //BA.debugLineNum = 411;BA.debugLine="Private Sub btnDialogCancel_Click";
 //BA.debugLineNum = 412;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 413;BA.debugLine="End Sub";
return "";
}
public String  _btndialogok_click() throws Exception{
String _phrase = "";
 //BA.debugLineNum = 415;BA.debugLine="Private Sub btnDialogOk_Click";
 //BA.debugLineNum = 416;BA.debugLine="Dim phrase As String = edtPassphrase.Text.Trim";
_phrase = _edtpassphrase.getText().trim();
 //BA.debugLineNum = 417;BA.debugLine="If phrase.Length >= 8 Then";
if (_phrase.length()>=8) { 
 //BA.debugLineNum = 418;BA.debugLine="ModSession.StartSessionWithCategory(phrase, \"pas";
_modsession._startsessionwithcategory /*String*/ (ba,_phrase,"passwords");
 //BA.debugLineNum = 419;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 420;BA.debugLine="NavigateToAddPassword";
_navigatetoaddpassword();
 }else {
 //BA.debugLineNum = 422;BA.debugLine="ToastMessageShow(ModLang.T(\"passphrase_min_8\"),";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"passphrase_min_8")),__c.True);
 };
 //BA.debugLineNum = 424;BA.debugLine="End Sub";
return "";
}
public String  _btnshowpass_click() throws Exception{
 //BA.debugLineNum = 397;BA.debugLine="Private Sub btnShowPass_Click";
 //BA.debugLineNum = 398;BA.debugLine="IsPassVisible = Not(IsPassVisible)";
_ispassvisible = __c.Not(_ispassvisible);
 //BA.debugLineNum = 399;BA.debugLine="If IsPassVisible Then";
if (_ispassvisible) { 
 //BA.debugLineNum = 400;BA.debugLine="edtPassphrase.InputType = 1";
_edtpassphrase.setInputType((int) (1));
 //BA.debugLineNum = 401;BA.debugLine="btnShowPass.Text = ModLang.T(\"hide\")";
_btnshowpass.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"hide")));
 //BA.debugLineNum = 402;BA.debugLine="btnShowPass.TextColor = Colors.White";
_btnshowpass.setTextColor(__c.Colors.White);
 }else {
 //BA.debugLineNum = 404;BA.debugLine="edtPassphrase.InputType = Bit.Or(1, 128)";
_edtpassphrase.setInputType(__c.Bit.Or((int) (1),(int) (128)));
 //BA.debugLineNum = 405;BA.debugLine="btnShowPass.Text = ModLang.T(\"view\")";
_btnshowpass.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"view")));
 //BA.debugLineNum = 406;BA.debugLine="btnShowPass.TextColor = Colors.ARGB(200, 255, 25";
_btnshowpass.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 };
 //BA.debugLineNum = 408;BA.debugLine="edtPassphrase.SelectionStart = edtPassphrase.Text";
_edtpassphrase.setSelectionStart(_edtpassphrase.getText().length());
 //BA.debugLineNum = 409;BA.debugLine="End Sub";
return "";
}
public String  _capitalize(String _text) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _result = null;
boolean _capitalizenext = false;
String _lower = "";
int _i = 0;
String _c = "";
 //BA.debugLineNum = 82;BA.debugLine="Private Sub Capitalize(text As String) As String";
 //BA.debugLineNum = 83;BA.debugLine="If text.Length = 0 Then Return text";
if (_text.length()==0) { 
if (true) return _text;};
 //BA.debugLineNum = 85;BA.debugLine="Dim result As StringBuilder";
_result = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 86;BA.debugLine="result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 87;BA.debugLine="Dim capitalizeNext As Boolean = True";
_capitalizenext = __c.True;
 //BA.debugLineNum = 88;BA.debugLine="Dim lower As String = text.ToLowerCase";
_lower = _text.toLowerCase();
 //BA.debugLineNum = 90;BA.debugLine="For i = 0 To lower.Length - 1";
{
final int step6 = 1;
final int limit6 = (int) (_lower.length()-1);
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
 //BA.debugLineNum = 91;BA.debugLine="Dim c As String = lower.SubString2(i, i + 1)";
_c = _lower.substring(_i,(int) (_i+1));
 //BA.debugLineNum = 92;BA.debugLine="If c = \" \" Then";
if ((_c).equals(" ")) { 
 //BA.debugLineNum = 93;BA.debugLine="result.Append(c)";
_result.Append(_c);
 //BA.debugLineNum = 94;BA.debugLine="capitalizeNext = True";
_capitalizenext = __c.True;
 }else {
 //BA.debugLineNum = 96;BA.debugLine="If capitalizeNext Then";
if (_capitalizenext) { 
 //BA.debugLineNum = 97;BA.debugLine="result.Append(c.ToUpperCase)";
_result.Append(_c.toUpperCase());
 //BA.debugLineNum = 98;BA.debugLine="capitalizeNext = False";
_capitalizenext = __c.False;
 }else {
 //BA.debugLineNum = 100;BA.debugLine="result.Append(c)";
_result.Append(_c);
 };
 };
 }
};
 //BA.debugLineNum = 105;BA.debugLine="Return result.ToString";
if (true) return _result.ToString();
 //BA.debugLineNum = 106;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 4;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Private Root As B4XView";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 6;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 9;BA.debugLine="Private CurrentGroupId As String";
_currentgroupid = "";
 //BA.debugLineNum = 10;BA.debugLine="Private CurrentGroupName As String";
_currentgroupname = "";
 //BA.debugLineNum = 13;BA.debugLine="Private btnBack As Button";
_btnback = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Private lblHeaderTitle As Label";
_lblheadertitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private svEntries As ScrollView";
_sventries = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private pnlEntries As B4XView";
_pnlentries = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private tmrClipboard As Timer";
_tmrclipboard = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 21;BA.debugLine="Private ClipboardCountdown As Int";
_clipboardcountdown = 0;
 //BA.debugLineNum = 24;BA.debugLine="Private pnlOverlay As Panel";
_pnloverlay = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private pnlDialog As Panel";
_pnldialog = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private edtPassphrase As EditText";
_edtpassphrase = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private btnShowPass As Button";
_btnshowpass = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private IsPassVisible As Boolean = False";
_ispassvisible = __c.False;
 //BA.debugLineNum = 31;BA.debugLine="Private lblSessionTimer As Label";
_lblsessiontimer = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Private tmrSession As Timer";
_tmrsession = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return "";
}
public void  _confirmdeleteentry(String _entryid) throws Exception{
ResumableSub_ConfirmDeleteEntry rsub = new ResumableSub_ConfirmDeleteEntry(this,_entryid);
rsub.resume(ba, null);
}
public static class ResumableSub_ConfirmDeleteEntry extends BA.ResumableSub {
public ResumableSub_ConfirmDeleteEntry(com.lockzero.pagepasswordlist parent,String _entryid) {
this.parent = parent;
this._entryid = _entryid;
}
com.lockzero.pagepasswordlist parent;
String _entryid;
com.lockzero.clspasswordentry _e = null;
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
 //BA.debugLineNum = 607;BA.debugLine="Dim e As clsPasswordEntry = ModPasswords.GetEntry";
_e = parent._modpasswords._getentrybyid /*com.lockzero.clspasswordentry*/ (ba,_entryid);
 //BA.debugLineNum = 608;BA.debugLine="If e.IsInitialized = False Then Return";
if (true) break;

case 1:
//if
this.state = 6;
if (_e._isinitialized /*boolean*/ ()==parent.__c.False) { 
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
 //BA.debugLineNum = 610;BA.debugLine="Wait For (xui.Msgbox2Async(ModLang.T(\"confirm_del";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"confirm_delete_msg")),BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"confirm_delete")),parent._modlang._t /*String*/ (ba,"delete"),"",parent._modlang._t /*String*/ (ba,"cancel"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 11;
return;
case 11:
//C
this.state = 7;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 612;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
if (true) break;

case 7:
//if
this.state = 10;
if (_result==parent._xui.DialogResponse_Positive) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 613;BA.debugLine="ModPasswords.DeleteEntry(entryId)";
parent._modpasswords._deleteentry /*String*/ (ba,_entryid);
 //BA.debugLineNum = 614;BA.debugLine="LoadEntries";
parent._loadentries();
 if (true) break;

case 10:
//C
this.state = -1;
;
 //BA.debugLineNum = 616;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _msgbox_result(int _result) throws Exception{
}
public String  _copypassword(String _entryid) throws Exception{
com.lockzero.clspasswordentry _e = null;
String _password = "";
 //BA.debugLineNum = 459;BA.debugLine="Private Sub CopyPassword(entryId As String)";
 //BA.debugLineNum = 460;BA.debugLine="If ModSession.IsSessionActive = False Then";
if (_modsession._issessionactive /*boolean*/ (ba)==__c.False) { 
 //BA.debugLineNum = 461;BA.debugLine="ToastMessageShow(ModLang.T(\"session_expired\"), T";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"session_expired")),__c.True);
 //BA.debugLineNum = 462;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 465;BA.debugLine="Dim e As clsPasswordEntry = ModPasswords.GetEntry";
_e = _modpasswords._getentrybyid /*com.lockzero.clspasswordentry*/ (ba,_entryid);
 //BA.debugLineNum = 466;BA.debugLine="If e.IsInitialized = False Then Return";
if (_e._isinitialized /*boolean*/ ()==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 469;BA.debugLine="Dim password As String = ModPasswords.DecryptValu";
_password = _modpasswords._decryptvalue /*String*/ (ba,_e._passwordenc /*String*/ );
 //BA.debugLineNum = 471;BA.debugLine="If password = \"\" Then";
if ((_password).equals("")) { 
 //BA.debugLineNum = 472;BA.debugLine="ToastMessageShow(ModLang.T(\"error\"), True)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error")),__c.True);
 //BA.debugLineNum = 473;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 477;BA.debugLine="SetClipboardText(password)";
_setclipboardtext(_password);
 //BA.debugLineNum = 480;BA.debugLine="e.MarkAsUsed";
_e._markasused /*String*/ ();
 //BA.debugLineNum = 481;BA.debugLine="ModPasswords.SaveEntry(e)";
_modpasswords._saveentry /*String*/ (ba,_e);
 //BA.debugLineNum = 484;BA.debugLine="ClipboardCountdown = ModSecurity.GetClipboardTime";
_clipboardcountdown = _modsecurity._getclipboardtimeout /*int*/ (ba);
 //BA.debugLineNum = 485;BA.debugLine="tmrClipboard.Enabled = True";
_tmrclipboard.setEnabled(__c.True);
 //BA.debugLineNum = 487;BA.debugLine="ToastMessageShow(ModLang.T(\"password_copied\") & \"";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"password_copied")+" ("+BA.NumberToString(_clipboardcountdown)+"s)"),__c.False);
 //BA.debugLineNum = 488;BA.debugLine="End Sub";
return "";
}
public String  _createdialogoverlay() throws Exception{
int _width = 0;
int _height = 0;
int _dialogw = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _xvdialog = null;
 //BA.debugLineNum = 184;BA.debugLine="Private Sub CreateDialogOverlay";
 //BA.debugLineNum = 185;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 186;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 188;BA.debugLine="pnlOverlay.Initialize(\"pnlOverlay\")";
_pnloverlay.Initialize(ba,"pnlOverlay");
 //BA.debugLineNum = 189;BA.debugLine="pnlOverlay.Color = Colors.ARGB(180, 0, 0, 0)";
_pnloverlay.setColor(__c.Colors.ARGB((int) (180),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 190;BA.debugLine="pnlOverlay.Visible = False";
_pnloverlay.setVisible(__c.False);
 //BA.debugLineNum = 191;BA.debugLine="Root.AddView(pnlOverlay, 0, 0, width, height)";
_root.AddView((android.view.View)(_pnloverlay.getObject()),(int) (0),(int) (0),_width,_height);
 //BA.debugLineNum = 193;BA.debugLine="Dim dialogW As Int = width - 40dip";
_dialogw = (int) (_width-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 194;BA.debugLine="pnlDialog.Initialize(\"\")";
_pnldialog.Initialize(ba,"");
 //BA.debugLineNum = 195;BA.debugLine="pnlDialog.Color = ModTheme.HomeHeaderBg";
_pnldialog.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 196;BA.debugLine="pnlOverlay.AddView(pnlDialog, 20dip, 80dip, dialo";
_pnloverlay.AddView((android.view.View)(_pnldialog.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (80)),_dialogw,__c.DipToCurrent((int) (195)));
 //BA.debugLineNum = 198;BA.debugLine="Dim xvDialog As B4XView = pnlDialog";
_xvdialog = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvdialog = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnldialog.getObject()));
 //BA.debugLineNum = 199;BA.debugLine="xvDialog.SetColorAndBorder(ModTheme.HomeHeaderBg,";
_xvdialog.SetColorAndBorder(_modtheme._homeheaderbg /*int*/ (ba),(int) (0),_modtheme._homeheaderbg /*int*/ (ba),__c.DipToCurrent((int) (12)));
 //BA.debugLineNum = 200;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _createlabel(String _text,float _size,boolean _bold) throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
 //BA.debugLineNum = 202;BA.debugLine="Private Sub CreateLabel(text As String, size As Fl";
 //BA.debugLineNum = 203;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 204;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(ba,"");
 //BA.debugLineNum = 205;BA.debugLine="lbl.Text = text";
_lbl.setText(BA.ObjectToCharSequence(_text));
 //BA.debugLineNum = 206;BA.debugLine="lbl.TextSize = size";
_lbl.setTextSize(_size);
 //BA.debugLineNum = 207;BA.debugLine="lbl.Gravity = Gravity.CENTER";
_lbl.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 208;BA.debugLine="If bold Then";
if (_bold) { 
 //BA.debugLineNum = 209;BA.debugLine="lbl.Typeface = Typeface.CreateNew(Typeface.DEFAU";
_lbl.setTypeface(__c.Typeface.CreateNew(__c.Typeface.DEFAULT,__c.Typeface.STYLE_BOLD));
 };
 //BA.debugLineNum = 211;BA.debugLine="Return lbl";
if (true) return (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 212;BA.debugLine="End Sub";
return null;
}
public String  _createui() throws Exception{
int _width = 0;
int _height = 0;
int _headerh = 0;
anywheresoftware.b4a.objects.PanelWrapper _pnlheader = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xvtimer = null;
anywheresoftware.b4a.objects.LabelWrapper _lbladd = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xvadd = null;
 //BA.debugLineNum = 117;BA.debugLine="Private Sub CreateUI";
 //BA.debugLineNum = 118;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 119;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 120;BA.debugLine="Dim headerH As Int = 56dip";
_headerh = __c.DipToCurrent((int) (56));
 //BA.debugLineNum = 123;BA.debugLine="Dim pnlHeader As Panel";
_pnlheader = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 124;BA.debugLine="pnlHeader.Initialize(\"\")";
_pnlheader.Initialize(ba,"");
 //BA.debugLineNum = 125;BA.debugLine="pnlHeader.Color = ModTheme.HomeHeaderBg";
_pnlheader.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 126;BA.debugLine="Root.AddView(pnlHeader, 0, 0, width, headerH)";
_root.AddView((android.view.View)(_pnlheader.getObject()),(int) (0),(int) (0),_width,_headerh);
 //BA.debugLineNum = 129;BA.debugLine="btnBack.Initialize(\"btnBack\")";
_btnback.Initialize(ba,"btnBack");
 //BA.debugLineNum = 130;BA.debugLine="btnBack.Text = \"<\"";
_btnback.setText(BA.ObjectToCharSequence("<"));
 //BA.debugLineNum = 131;BA.debugLine="btnBack.TextSize = 20";
_btnback.setTextSize((float) (20));
 //BA.debugLineNum = 132;BA.debugLine="btnBack.Color = Colors.Transparent";
_btnback.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 133;BA.debugLine="btnBack.TextColor = Colors.White";
_btnback.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 134;BA.debugLine="btnBack.Gravity = Gravity.CENTER";
_btnback.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 135;BA.debugLine="pnlHeader.AddView(btnBack, 0, 0, 50dip, headerH)";
_pnlheader.AddView((android.view.View)(_btnback.getObject()),(int) (0),(int) (0),__c.DipToCurrent((int) (50)),_headerh);
 //BA.debugLineNum = 138;BA.debugLine="lblHeaderTitle.Initialize(\"\")";
_lblheadertitle.Initialize(ba,"");
 //BA.debugLineNum = 139;BA.debugLine="lblHeaderTitle.Text = ModLang.T(\"passwords\")";
_lblheadertitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"passwords")));
 //BA.debugLineNum = 140;BA.debugLine="lblHeaderTitle.TextSize = 16";
_lblheadertitle.setTextSize((float) (16));
 //BA.debugLineNum = 141;BA.debugLine="lblHeaderTitle.TextColor = Colors.White";
_lblheadertitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 142;BA.debugLine="lblHeaderTitle.Typeface = Typeface.DEFAULT_BOLD";
_lblheadertitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 143;BA.debugLine="lblHeaderTitle.Gravity = Gravity.CENTER_VERTICAL";
_lblheadertitle.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 144;BA.debugLine="pnlHeader.AddView(lblHeaderTitle, 50dip, 0, width";
_pnlheader.AddView((android.view.View)(_lblheadertitle.getObject()),__c.DipToCurrent((int) (50)),(int) (0),(int) (_width-__c.DipToCurrent((int) (170))),_headerh);
 //BA.debugLineNum = 147;BA.debugLine="lblSessionTimer.Initialize(\"lblSessionTimer\")";
_lblsessiontimer.Initialize(ba,"lblSessionTimer");
 //BA.debugLineNum = 148;BA.debugLine="lblSessionTimer.Text = \"00:00\"";
_lblsessiontimer.setText(BA.ObjectToCharSequence("00:00"));
 //BA.debugLineNum = 149;BA.debugLine="lblSessionTimer.TextSize = 12";
_lblsessiontimer.setTextSize((float) (12));
 //BA.debugLineNum = 150;BA.debugLine="lblSessionTimer.TextColor = Colors.ARGB(200, 255,";
_lblsessiontimer.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 151;BA.debugLine="lblSessionTimer.Gravity = Gravity.CENTER";
_lblsessiontimer.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 152;BA.debugLine="pnlHeader.AddView(lblSessionTimer, width - 110dip";
_pnlheader.AddView((android.view.View)(_lblsessiontimer.getObject()),(int) (_width-__c.DipToCurrent((int) (110))),__c.DipToCurrent((int) (12)),__c.DipToCurrent((int) (55)),__c.DipToCurrent((int) (32)));
 //BA.debugLineNum = 155;BA.debugLine="Dim xvTimer As B4XView = lblSessionTimer";
_xvtimer = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvtimer = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lblsessiontimer.getObject()));
 //BA.debugLineNum = 156;BA.debugLine="xvTimer.SetColorAndBorder(Colors.ARGB(60, 255, 25";
_xvtimer.SetColorAndBorder(__c.Colors.ARGB((int) (60),(int) (255),(int) (255),(int) (255)),(int) (0),__c.Colors.Transparent,__c.DipToCurrent((int) (8)));
 //BA.debugLineNum = 159;BA.debugLine="Dim lblAdd As Label";
_lbladd = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 160;BA.debugLine="lblAdd.Initialize(\"btnAdd\")";
_lbladd.Initialize(ba,"btnAdd");
 //BA.debugLineNum = 161;BA.debugLine="lblAdd.Text = \"+\"";
_lbladd.setText(BA.ObjectToCharSequence("+"));
 //BA.debugLineNum = 162;BA.debugLine="lblAdd.TextSize = 26";
_lbladd.setTextSize((float) (26));
 //BA.debugLineNum = 163;BA.debugLine="lblAdd.Typeface = Typeface.DEFAULT_BOLD";
_lbladd.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 164;BA.debugLine="lblAdd.Gravity = Gravity.CENTER";
_lbladd.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 165;BA.debugLine="lblAdd.TextColor = Colors.White";
_lbladd.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 166;BA.debugLine="pnlHeader.AddView(lblAdd, width - 50dip, 8dip, 40";
_pnlheader.AddView((android.view.View)(_lbladd.getObject()),(int) (_width-__c.DipToCurrent((int) (50))),__c.DipToCurrent((int) (8)),__c.DipToCurrent((int) (40)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 169;BA.debugLine="Dim xvAdd As B4XView = lblAdd";
_xvadd = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvadd = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbladd.getObject()));
 //BA.debugLineNum = 170;BA.debugLine="xvAdd.SetColorAndBorder(ModTheme.HomeIconBg, 0, M";
_xvadd.SetColorAndBorder(_modtheme._homeiconbg /*int*/ (ba),(int) (0),_modtheme._homeiconbg /*int*/ (ba),__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 173;BA.debugLine="svEntries.Initialize(0)";
_sventries.Initialize(ba,(int) (0));
 //BA.debugLineNum = 174;BA.debugLine="svEntries.Color = ModTheme.HomeBg";
_sventries.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 175;BA.debugLine="Root.AddView(svEntries, 0, headerH, width, height";
_root.AddView((android.view.View)(_sventries.getObject()),(int) (0),_headerh,_width,(int) (_height-_headerh));
 //BA.debugLineNum = 177;BA.debugLine="pnlEntries = svEntries.Panel";
_pnlentries = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_sventries.getPanel().getObject()));
 //BA.debugLineNum = 178;BA.debugLine="pnlEntries.Color = ModTheme.HomeBg";
_pnlentries.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 181;BA.debugLine="CreateDialogOverlay";
_createdialogoverlay();
 //BA.debugLineNum = 182;BA.debugLine="End Sub";
return "";
}
public String  _editentry(String _entryid) throws Exception{
anywheresoftware.b4a.objects.collections.Map _params = null;
com.lockzero.pagepasswordedit _pg = null;
 //BA.debugLineNum = 595;BA.debugLine="Private Sub EditEntry(entryId As String)";
 //BA.debugLineNum = 596;BA.debugLine="Dim params As Map";
_params = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 597;BA.debugLine="params.Initialize";
_params.Initialize();
 //BA.debugLineNum = 598;BA.debugLine="params.Put(\"groupId\", CurrentGroupId)";
_params.Put((Object)("groupId"),(Object)(_currentgroupid));
 //BA.debugLineNum = 599;BA.debugLine="params.Put(\"entryId\", entryId)";
_params.Put((Object)("entryId"),(Object)(_entryid));
 //BA.debugLineNum = 601;BA.debugLine="Dim pg As PagePasswordEdit = B4XPages.GetPage(\"Pa";
_pg = (com.lockzero.pagepasswordedit)(_b4xpages._getpage /*Object*/ (ba,"PagePasswordEdit"));
 //BA.debugLineNum = 602;BA.debugLine="pg.SetParams(params)";
_pg._setparams /*String*/ (_params);
 //BA.debugLineNum = 603;BA.debugLine="B4XPages.ShowPage(\"PagePasswordEdit\")";
_b4xpages._showpage /*String*/ (ba,"PagePasswordEdit");
 //BA.debugLineNum = 604;BA.debugLine="End Sub";
return "";
}
public String  _hidedialog() throws Exception{
anywheresoftware.b4a.objects.IME _ime = null;
 //BA.debugLineNum = 426;BA.debugLine="Private Sub HideDialog";
 //BA.debugLineNum = 427;BA.debugLine="pnlOverlay.Visible = False";
_pnloverlay.setVisible(__c.False);
 //BA.debugLineNum = 428;BA.debugLine="Dim ime As IME";
_ime = new anywheresoftware.b4a.objects.IME();
 //BA.debugLineNum = 429;BA.debugLine="ime.Initialize(\"\")";
_ime.Initialize("");
 //BA.debugLineNum = 430;BA.debugLine="ime.HideKeyboard";
_ime.HideKeyboard(ba);
 //BA.debugLineNum = 431;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 35;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 36;BA.debugLine="tmrClipboard.Initialize(\"tmrClipboard\", 1000)";
_tmrclipboard.Initialize(ba,"tmrClipboard",(long) (1000));
 //BA.debugLineNum = 37;BA.debugLine="tmrSession.Initialize(\"tmrSession\", 1000)";
_tmrsession.Initialize(ba,"tmrSession",(long) (1000));
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public void  _lblsessiontimer_click() throws Exception{
ResumableSub_lblSessionTimer_Click rsub = new ResumableSub_lblSessionTimer_Click(this);
rsub.resume(ba, null);
}
public static class ResumableSub_lblSessionTimer_Click extends BA.ResumableSub {
public ResumableSub_lblSessionTimer_Click(com.lockzero.pagepasswordlist parent) {
this.parent = parent;
}
com.lockzero.pagepasswordlist parent;
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
 //BA.debugLineNum = 535;BA.debugLine="Wait For (xui.Msgbox2Async(ModLang.T(\"lock_confir";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"lock_confirm_msg")),BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"lock")),parent._modlang._t /*String*/ (ba,"yes"),"",parent._modlang._t /*String*/ (ba,"cancel"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 537;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_result==parent._xui.DialogResponse_Positive) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 538;BA.debugLine="ModSession.Lock";
parent._modsession._lock /*String*/ (ba);
 //BA.debugLineNum = 539;BA.debugLine="tmrSession.Enabled = False";
parent._tmrsession.setEnabled(parent.__c.False);
 //BA.debugLineNum = 540;BA.debugLine="ToastMessageShow(ModLang.T(\"locked\"), False)";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"locked")),parent.__c.False);
 //BA.debugLineNum = 541;BA.debugLine="B4XPages.ShowPageAndRemovePreviousPages(\"mainpag";
parent._b4xpages._showpageandremovepreviouspages /*String*/ (ba,"mainpage");
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 543;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _loadentries() throws Exception{
anywheresoftware.b4a.objects.collections.List _entries = null;
int _width = 0;
int _itemheight = 0;
int _y = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _lblempty = null;
com.lockzero.clspasswordentry _e = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlitem = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xvitem = null;
anywheresoftware.b4a.objects.LabelWrapper _lblfav = null;
int _leftoffset = 0;
anywheresoftware.b4a.objects.LabelWrapper _lblname = null;
String _username = "";
anywheresoftware.b4a.objects.LabelWrapper _lbluser = null;
anywheresoftware.b4a.objects.ButtonWrapper _btncopy = null;
 //BA.debugLineNum = 218;BA.debugLine="Private Sub LoadEntries";
 //BA.debugLineNum = 219;BA.debugLine="pnlEntries.RemoveAllViews";
_pnlentries.RemoveAllViews();
 //BA.debugLineNum = 221;BA.debugLine="Dim entries As List = ModPasswords.GetEntriesByGr";
_entries = new anywheresoftware.b4a.objects.collections.List();
_entries = _modpasswords._getentriesbygroup /*anywheresoftware.b4a.objects.collections.List*/ (ba,_currentgroupid);
 //BA.debugLineNum = 222;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 223;BA.debugLine="Dim itemHeight As Int = 80dip";
_itemheight = __c.DipToCurrent((int) (80));
 //BA.debugLineNum = 224;BA.debugLine="Dim y As Int = 16dip";
_y = __c.DipToCurrent((int) (16));
 //BA.debugLineNum = 226;BA.debugLine="If entries.Size = 0 Then";
if (_entries.getSize()==0) { 
 //BA.debugLineNum = 227;BA.debugLine="Dim lblEmpty As B4XView = CreateLabel(ModLang.T(";
_lblempty = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lblempty = _createlabel(_modlang._t /*String*/ (ba,"empty"),(float) (14),__c.False);
 //BA.debugLineNum = 228;BA.debugLine="lblEmpty.TextColor = Colors.ARGB(150, 255, 255,";
_lblempty.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 229;BA.debugLine="pnlEntries.AddView(lblEmpty, 0, 100dip, width, 4";
_pnlentries.AddView((android.view.View)(_lblempty.getObject()),(int) (0),__c.DipToCurrent((int) (100)),_width,__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 230;BA.debugLine="pnlEntries.Height = 200dip";
_pnlentries.setHeight(__c.DipToCurrent((int) (200)));
 //BA.debugLineNum = 231;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 234;BA.debugLine="For Each e As clsPasswordEntry In entries";
{
final anywheresoftware.b4a.BA.IterableList group13 = _entries;
final int groupLen13 = group13.getSize()
;int index13 = 0;
;
for (; index13 < groupLen13;index13++){
_e = (com.lockzero.clspasswordentry)(group13.Get(index13));
 //BA.debugLineNum = 235;BA.debugLine="Dim pnlItem As Panel";
_pnlitem = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 236;BA.debugLine="pnlItem.Initialize(\"pnlEntry\")";
_pnlitem.Initialize(ba,"pnlEntry");
 //BA.debugLineNum = 237;BA.debugLine="pnlItem.Tag = e.Id";
_pnlitem.setTag((Object)(_e._id /*String*/ ));
 //BA.debugLineNum = 240;BA.debugLine="Dim xvItem As B4XView = pnlItem";
_xvitem = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvitem = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnlitem.getObject()));
 //BA.debugLineNum = 241;BA.debugLine="xvItem.SetColorAndBorder(ModTheme.HomeIconBg, 0,";
_xvitem.SetColorAndBorder(_modtheme._homeiconbg /*int*/ (ba),(int) (0),_modtheme._homeiconbg /*int*/ (ba),__c.DipToCurrent((int) (12)));
 //BA.debugLineNum = 242;BA.debugLine="pnlEntries.AddView(pnlItem, 16dip, y, width - 32";
_pnlentries.AddView((android.view.View)(_pnlitem.getObject()),__c.DipToCurrent((int) (16)),_y,(int) (_width-__c.DipToCurrent((int) (32))),_itemheight);
 //BA.debugLineNum = 245;BA.debugLine="If e.IsFavorite Then";
if (_e._isfavorite /*boolean*/ ) { 
 //BA.debugLineNum = 246;BA.debugLine="Dim lblFav As Label";
_lblfav = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 247;BA.debugLine="lblFav.Initialize(\"\")";
_lblfav.Initialize(ba,"");
 //BA.debugLineNum = 248;BA.debugLine="lblFav.Text = \"*\"";
_lblfav.setText(BA.ObjectToCharSequence("*"));
 //BA.debugLineNum = 249;BA.debugLine="lblFav.TextSize = 16";
_lblfav.setTextSize((float) (16));
 //BA.debugLineNum = 250;BA.debugLine="lblFav.TextColor = Colors.RGB(255, 200, 100) 'A";
_lblfav.setTextColor(__c.Colors.RGB((int) (255),(int) (200),(int) (100)));
 //BA.debugLineNum = 251;BA.debugLine="lblFav.Gravity = Gravity.CENTER";
_lblfav.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 252;BA.debugLine="pnlItem.AddView(lblFav, 8dip, 0, 20dip, itemHei";
_pnlitem.AddView((android.view.View)(_lblfav.getObject()),__c.DipToCurrent((int) (8)),(int) (0),__c.DipToCurrent((int) (20)),_itemheight);
 };
 //BA.debugLineNum = 255;BA.debugLine="Dim leftOffset As Int = 16dip";
_leftoffset = __c.DipToCurrent((int) (16));
 //BA.debugLineNum = 256;BA.debugLine="If e.IsFavorite Then leftOffset = 30dip";
if (_e._isfavorite /*boolean*/ ) { 
_leftoffset = __c.DipToCurrent((int) (30));};
 //BA.debugLineNum = 259;BA.debugLine="Dim lblName As Label";
_lblname = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 260;BA.debugLine="lblName.Initialize(\"\")";
_lblname.Initialize(ba,"");
 //BA.debugLineNum = 261;BA.debugLine="lblName.Text = e.GetDisplayName";
_lblname.setText(BA.ObjectToCharSequence(_e._getdisplayname /*String*/ ()));
 //BA.debugLineNum = 262;BA.debugLine="lblName.TextSize = 16";
_lblname.setTextSize((float) (16));
 //BA.debugLineNum = 263;BA.debugLine="lblName.TextColor = Colors.White";
_lblname.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 264;BA.debugLine="lblName.Typeface = Typeface.DEFAULT_BOLD";
_lblname.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 265;BA.debugLine="pnlItem.AddView(lblName, leftOffset, 15dip, widt";
_pnlitem.AddView((android.view.View)(_lblname.getObject()),_leftoffset,__c.DipToCurrent((int) (15)),(int) (_width-__c.DipToCurrent((int) (150))),__c.DipToCurrent((int) (25)));
 //BA.debugLineNum = 268;BA.debugLine="Dim username As String = \"\"";
_username = "";
 //BA.debugLineNum = 269;BA.debugLine="If ModSession.IsSessionActive Then";
if (_modsession._issessionactive /*boolean*/ (ba)) { 
 //BA.debugLineNum = 270;BA.debugLine="username = ModPasswords.DecryptValue(e.Username";
_username = _modpasswords._decryptvalue /*String*/ (ba,_e._username /*String*/ );
 }else {
 //BA.debugLineNum = 272;BA.debugLine="username = \"***\"";
_username = "***";
 };
 //BA.debugLineNum = 274;BA.debugLine="Dim lblUser As Label";
_lbluser = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 275;BA.debugLine="lblUser.Initialize(\"\")";
_lbluser.Initialize(ba,"");
 //BA.debugLineNum = 276;BA.debugLine="lblUser.Text = username";
_lbluser.setText(BA.ObjectToCharSequence(_username));
 //BA.debugLineNum = 277;BA.debugLine="lblUser.TextSize = 13";
_lbluser.setTextSize((float) (13));
 //BA.debugLineNum = 278;BA.debugLine="lblUser.TextColor = Colors.ARGB(180, 255, 255, 2";
_lbluser.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 279;BA.debugLine="pnlItem.AddView(lblUser, leftOffset, 42dip, widt";
_pnlitem.AddView((android.view.View)(_lbluser.getObject()),_leftoffset,__c.DipToCurrent((int) (42)),(int) (_width-__c.DipToCurrent((int) (150))),__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 282;BA.debugLine="Dim btnCopy As Button";
_btncopy = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 283;BA.debugLine="btnCopy.Initialize(\"btnCopy\")";
_btncopy.Initialize(ba,"btnCopy");
 //BA.debugLineNum = 284;BA.debugLine="btnCopy.Text = ModLang.T(\"copy\")";
_btncopy.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"copy")));
 //BA.debugLineNum = 285;BA.debugLine="btnCopy.Tag = e.Id";
_btncopy.setTag((Object)(_e._id /*String*/ ));
 //BA.debugLineNum = 286;BA.debugLine="btnCopy.TextSize = 12";
_btncopy.setTextSize((float) (12));
 //BA.debugLineNum = 287;BA.debugLine="btnCopy.Color = ModTheme.HomeBg";
_btncopy.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 288;BA.debugLine="btnCopy.TextColor = Colors.White";
_btncopy.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 289;BA.debugLine="pnlItem.AddView(btnCopy, width - 120dip, 20dip,";
_pnlitem.AddView((android.view.View)(_btncopy.getObject()),(int) (_width-__c.DipToCurrent((int) (120))),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (70)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 291;BA.debugLine="y = y + itemHeight + 12dip";
_y = (int) (_y+_itemheight+__c.DipToCurrent((int) (12)));
 }
};
 //BA.debugLineNum = 294;BA.debugLine="pnlEntries.Height = y + 20dip";
_pnlentries.setHeight((int) (_y+__c.DipToCurrent((int) (20))));
 //BA.debugLineNum = 295;BA.debugLine="End Sub";
return "";
}
public String  _navigatetoaddpassword() throws Exception{
anywheresoftware.b4a.objects.collections.Map _params = null;
com.lockzero.pagepasswordedit _pg = null;
 //BA.debugLineNum = 319;BA.debugLine="Private Sub NavigateToAddPassword";
 //BA.debugLineNum = 320;BA.debugLine="Dim params As Map";
_params = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 321;BA.debugLine="params.Initialize";
_params.Initialize();
 //BA.debugLineNum = 322;BA.debugLine="params.Put(\"groupId\", CurrentGroupId)";
_params.Put((Object)("groupId"),(Object)(_currentgroupid));
 //BA.debugLineNum = 323;BA.debugLine="params.Put(\"entryId\", \"\") 'Novo";
_params.Put((Object)("entryId"),(Object)(""));
 //BA.debugLineNum = 325;BA.debugLine="Dim pg As PagePasswordEdit = B4XPages.GetPage(\"Pa";
_pg = (com.lockzero.pagepasswordedit)(_b4xpages._getpage /*Object*/ (ba,"PagePasswordEdit"));
 //BA.debugLineNum = 326;BA.debugLine="pg.SetParams(params)";
_pg._setparams /*String*/ (_params);
 //BA.debugLineNum = 327;BA.debugLine="B4XPages.ShowPage(\"PagePasswordEdit\")";
_b4xpages._showpage /*String*/ (ba,"PagePasswordEdit");
 //BA.debugLineNum = 328;BA.debugLine="End Sub";
return "";
}
public String  _pnlentry_click() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
String _entryid = "";
 //BA.debugLineNum = 433;BA.debugLine="Private Sub pnlEntry_Click";
 //BA.debugLineNum = 434;BA.debugLine="Dim pnl As Panel = Sender";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
_pnl = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(__c.Sender(ba)));
 //BA.debugLineNum = 435;BA.debugLine="Dim entryId As String = pnl.Tag";
_entryid = BA.ObjectToString(_pnl.getTag());
 //BA.debugLineNum = 437;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 438;BA.debugLine="ShowEntryDetails(entryId)";
_showentrydetails(_entryid);
 //BA.debugLineNum = 439;BA.debugLine="End Sub";
return "";
}
public String  _pnlentry_longclick() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
String _entryid = "";
 //BA.debugLineNum = 441;BA.debugLine="Private Sub pnlEntry_LongClick";
 //BA.debugLineNum = 442;BA.debugLine="Dim pnl As Panel = Sender";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
_pnl = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(__c.Sender(ba)));
 //BA.debugLineNum = 443;BA.debugLine="Dim entryId As String = pnl.Tag";
_entryid = BA.ObjectToString(_pnl.getTag());
 //BA.debugLineNum = 445;BA.debugLine="ShowEntryOptions(entryId)";
_showentryoptions(_entryid);
 //BA.debugLineNum = 446;BA.debugLine="End Sub";
return "";
}
public String  _pnloverlay_click() throws Exception{
 //BA.debugLineNum = 315;BA.debugLine="Private Sub pnlOverlay_Click";
 //BA.debugLineNum = 316;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 317;BA.debugLine="End Sub";
return "";
}
public String  _setclipboardtext(String _text) throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4j.object.JavaObject _cm = null;
anywheresoftware.b4j.object.JavaObject _cd = null;
anywheresoftware.b4j.object.JavaObject _clip = null;
 //BA.debugLineNum = 630;BA.debugLine="Private Sub SetClipboardText(text As String)";
 //BA.debugLineNum = 631;BA.debugLine="Try";
try { //BA.debugLineNum = 632;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 633;BA.debugLine="jo.InitializeContext";
_jo.InitializeContext(ba);
 //BA.debugLineNum = 634;BA.debugLine="Dim cm As JavaObject = jo.RunMethod(\"getSystemSe";
_cm = new anywheresoftware.b4j.object.JavaObject();
_cm = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_jo.RunMethod("getSystemService",new Object[]{(Object)("clipboard")})));
 //BA.debugLineNum = 635;BA.debugLine="Dim cd As JavaObject";
_cd = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 636;BA.debugLine="cd.InitializeStatic(\"android.content.ClipData\")";
_cd.InitializeStatic("android.content.ClipData");
 //BA.debugLineNum = 637;BA.debugLine="Dim clip As JavaObject = cd.RunMethod(\"newPlainT";
_clip = new anywheresoftware.b4j.object.JavaObject();
_clip = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_cd.RunMethod("newPlainText",new Object[]{(Object)("LockZero"),(Object)(_text)})));
 //BA.debugLineNum = 638;BA.debugLine="cm.RunMethod(\"setPrimaryClip\", Array(clip))";
_cm.RunMethod("setPrimaryClip",new Object[]{(Object)(_clip.getObject())});
 } 
       catch (Exception e10) {
			ba.setLastException(e10); //BA.debugLineNum = 640;BA.debugLine="Log(\"SetClipboardText error: \" & LastException)";
__c.LogImpl("758982410","SetClipboardText error: "+BA.ObjectToString(__c.LastException(ba)),0);
 };
 //BA.debugLineNum = 642;BA.debugLine="End Sub";
return "";
}
public String  _setparams(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
 //BA.debugLineNum = 76;BA.debugLine="Public Sub SetParams(params As Map)";
 //BA.debugLineNum = 77;BA.debugLine="If params = Null Then Return";
if (_params== null) { 
if (true) return "";};
 //BA.debugLineNum = 78;BA.debugLine="CurrentGroupId = params.GetDefault(\"groupId\", \"\")";
_currentgroupid = BA.ObjectToString(_params.GetDefault((Object)("groupId"),(Object)("")));
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
return "";
}
public void  _showentrydetails(String _entryid) throws Exception{
ResumableSub_ShowEntryDetails rsub = new ResumableSub_ShowEntryDetails(this,_entryid);
rsub.resume(ba, null);
}
public static class ResumableSub_ShowEntryDetails extends BA.ResumableSub {
public ResumableSub_ShowEntryDetails(com.lockzero.pagepasswordlist parent,String _entryid) {
this.parent = parent;
this._entryid = _entryid;
}
com.lockzero.pagepasswordlist parent;
String _entryid;
com.lockzero.clspasswordentry _e = null;
String _username = "";
String _password = "";
String _notes = "";
String _details = "";
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
 //BA.debugLineNum = 550;BA.debugLine="If ModSession.IsSessionActive = False Then";
if (true) break;

case 1:
//if
this.state = 4;
if (parent._modsession._issessionactive /*boolean*/ (ba)==parent.__c.False) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 551;BA.debugLine="ToastMessageShow(ModLang.T(\"session_expired\"), T";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"session_expired")),parent.__c.True);
 //BA.debugLineNum = 552;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 4:
//C
this.state = 5;
;
 //BA.debugLineNum = 555;BA.debugLine="Dim e As clsPasswordEntry = ModPasswords.GetEntry";
_e = parent._modpasswords._getentrybyid /*com.lockzero.clspasswordentry*/ (ba,_entryid);
 //BA.debugLineNum = 556;BA.debugLine="If e.IsInitialized = False Then Return";
if (true) break;

case 5:
//if
this.state = 10;
if (_e._isinitialized /*boolean*/ ()==parent.__c.False) { 
this.state = 7;
;}if (true) break;

case 7:
//C
this.state = 10;
if (true) return ;
if (true) break;

case 10:
//C
this.state = 11;
;
 //BA.debugLineNum = 558;BA.debugLine="Dim username As String = ModPasswords.DecryptValu";
_username = parent._modpasswords._decryptvalue /*String*/ (ba,_e._username /*String*/ );
 //BA.debugLineNum = 559;BA.debugLine="Dim password As String = ModPasswords.DecryptValu";
_password = parent._modpasswords._decryptvalue /*String*/ (ba,_e._passwordenc /*String*/ );
 //BA.debugLineNum = 560;BA.debugLine="Dim notes As String = ModPasswords.DecryptValue(e";
_notes = parent._modpasswords._decryptvalue /*String*/ (ba,_e._notes /*String*/ );
 //BA.debugLineNum = 562;BA.debugLine="Dim details As String = e.GetDisplayName & CRLF &";
_details = _e._getdisplayname /*String*/ ()+parent.__c.CRLF+parent.__c.CRLF;
 //BA.debugLineNum = 563;BA.debugLine="If e.Url <> \"\" Then";
if (true) break;

case 11:
//if
this.state = 14;
if ((_e._url /*String*/ ).equals("") == false) { 
this.state = 13;
}if (true) break;

case 13:
//C
this.state = 14;
 //BA.debugLineNum = 564;BA.debugLine="details = details & ModLang.T(\"url\") & \": \" & e.";
_details = _details+parent._modlang._t /*String*/ (ba,"url")+": "+_e._url /*String*/ +parent.__c.CRLF;
 if (true) break;

case 14:
//C
this.state = 15;
;
 //BA.debugLineNum = 566;BA.debugLine="details = details & ModLang.T(\"username\") & \": \"";
_details = _details+parent._modlang._t /*String*/ (ba,"username")+": "+_username+parent.__c.CRLF;
 //BA.debugLineNum = 567;BA.debugLine="details = details & ModLang.T(\"password\") & \": \"";
_details = _details+parent._modlang._t /*String*/ (ba,"password")+": "+_password+parent.__c.CRLF;
 //BA.debugLineNum = 569;BA.debugLine="If notes <> \"\" Then";
if (true) break;

case 15:
//if
this.state = 18;
if ((_notes).equals("") == false) { 
this.state = 17;
}if (true) break;

case 17:
//C
this.state = 18;
 //BA.debugLineNum = 570;BA.debugLine="details = details & CRLF & ModLang.T(\"note\") & \"";
_details = _details+parent.__c.CRLF+parent._modlang._t /*String*/ (ba,"note")+": "+_notes;
 if (true) break;

case 18:
//C
this.state = 19;
;
 //BA.debugLineNum = 573;BA.debugLine="Wait For (xui.Msgbox2Async(details, e.GetDisplayN";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(_details),BA.ObjectToCharSequence(_e._getdisplayname /*String*/ ()),parent._modlang._t /*String*/ (ba,"copy"),parent._modlang._t /*String*/ (ba,"close"),parent._modlang._t /*String*/ (ba,"edit"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 25;
return;
case 25:
//C
this.state = 19;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 575;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
if (true) break;

case 19:
//if
this.state = 24;
if (_result==parent._xui.DialogResponse_Positive) { 
this.state = 21;
}else if(_result==parent._xui.DialogResponse_Negative) { 
this.state = 23;
}if (true) break;

case 21:
//C
this.state = 24;
 //BA.debugLineNum = 576;BA.debugLine="CopyPassword(entryId)";
parent._copypassword(_entryid);
 if (true) break;

case 23:
//C
this.state = 24;
 //BA.debugLineNum = 578;BA.debugLine="EditEntry(entryId)";
parent._editentry(_entryid);
 if (true) break;

case 24:
//C
this.state = -1;
;
 //BA.debugLineNum = 580;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _showentryoptions(String _entryid) throws Exception{
ResumableSub_ShowEntryOptions rsub = new ResumableSub_ShowEntryOptions(this,_entryid);
rsub.resume(ba, null);
}
public static class ResumableSub_ShowEntryOptions extends BA.ResumableSub {
public ResumableSub_ShowEntryOptions(com.lockzero.pagepasswordlist parent,String _entryid) {
this.parent = parent;
this._entryid = _entryid;
}
com.lockzero.pagepasswordlist parent;
String _entryid;
com.lockzero.clspasswordentry _e = null;
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
 //BA.debugLineNum = 583;BA.debugLine="Dim e As clsPasswordEntry = ModPasswords.GetEntry";
_e = parent._modpasswords._getentrybyid /*com.lockzero.clspasswordentry*/ (ba,_entryid);
 //BA.debugLineNum = 584;BA.debugLine="If e.IsInitialized = False Then Return";
if (true) break;

case 1:
//if
this.state = 6;
if (_e._isinitialized /*boolean*/ ()==parent.__c.False) { 
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
 //BA.debugLineNum = 586;BA.debugLine="Wait For (xui.Msgbox2Async(e.GetDisplayName, \"\",";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(_e._getdisplayname /*String*/ ()),BA.ObjectToCharSequence(""),parent._modlang._t /*String*/ (ba,"edit"),parent._modlang._t /*String*/ (ba,"delete"),parent._modlang._t /*String*/ (ba,"cancel"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 13;
return;
case 13:
//C
this.state = 7;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 588;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
if (true) break;

case 7:
//if
this.state = 12;
if (_result==parent._xui.DialogResponse_Positive) { 
this.state = 9;
}else if(_result==parent._xui.DialogResponse_Negative) { 
this.state = 11;
}if (true) break;

case 9:
//C
this.state = 12;
 //BA.debugLineNum = 589;BA.debugLine="EditEntry(entryId)";
parent._editentry(_entryid);
 if (true) break;

case 11:
//C
this.state = 12;
 //BA.debugLineNum = 591;BA.debugLine="ConfirmDeleteEntry(entryId)";
parent._confirmdeleteentry(_entryid);
 if (true) break;

case 12:
//C
this.state = -1;
;
 //BA.debugLineNum = 593;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _showpassphrasedialog() throws Exception{
int _dialogw = 0;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlinput = null;
anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
anywheresoftware.b4a.objects.ButtonWrapper _btnok = null;
 //BA.debugLineNum = 334;BA.debugLine="Private Sub ShowPassphraseDialog";
 //BA.debugLineNum = 335;BA.debugLine="IsPassVisible = False";
_ispassvisible = __c.False;
 //BA.debugLineNum = 337;BA.debugLine="Dim dialogW As Int = Root.Width - 40dip";
_dialogw = (int) (_root.getWidth()-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 338;BA.debugLine="pnlDialog.RemoveAllViews";
_pnldialog.RemoveAllViews();
 //BA.debugLineNum = 341;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 342;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 343;BA.debugLine="lblTitle.Text = ModLang.T(\"enter_passphrase\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"enter_passphrase")));
 //BA.debugLineNum = 344;BA.debugLine="lblTitle.TextSize = 16";
_lbltitle.setTextSize((float) (16));
 //BA.debugLineNum = 345;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 346;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 347;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 348;BA.debugLine="pnlDialog.AddView(lblTitle, 0, 12dip, dialogW, 24";
_pnldialog.AddView((android.view.View)(_lbltitle.getObject()),(int) (0),__c.DipToCurrent((int) (12)),_dialogw,__c.DipToCurrent((int) (24)));
 //BA.debugLineNum = 351;BA.debugLine="Dim pnlInput As Panel";
_pnlinput = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 352;BA.debugLine="pnlInput.Initialize(\"\")";
_pnlinput.Initialize(ba,"");
 //BA.debugLineNum = 353;BA.debugLine="pnlInput.Color = ModTheme.HomeBg";
_pnlinput.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 354;BA.debugLine="pnlDialog.AddView(pnlInput, 16dip, 50dip, dialogW";
_pnldialog.AddView((android.view.View)(_pnlinput.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (50)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 356;BA.debugLine="edtPassphrase.Initialize(\"edtPassphrase\")";
_edtpassphrase.Initialize(ba,"edtPassphrase");
 //BA.debugLineNum = 357;BA.debugLine="edtPassphrase.Hint = ModLang.T(\"passphrase_hint\")";
_edtpassphrase.setHint(_modlang._t /*String*/ (ba,"passphrase_hint"));
 //BA.debugLineNum = 358;BA.debugLine="edtPassphrase.SingleLine = True";
_edtpassphrase.setSingleLine(__c.True);
 //BA.debugLineNum = 359;BA.debugLine="edtPassphrase.InputType = Bit.Or(1, 128)";
_edtpassphrase.setInputType(__c.Bit.Or((int) (1),(int) (128)));
 //BA.debugLineNum = 360;BA.debugLine="edtPassphrase.Text = \"\"";
_edtpassphrase.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 361;BA.debugLine="edtPassphrase.TextColor = Colors.White";
_edtpassphrase.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 362;BA.debugLine="edtPassphrase.HintColor = Colors.ARGB(120, 255, 2";
_edtpassphrase.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 363;BA.debugLine="pnlInput.AddView(edtPassphrase, 8dip, 0, dialogW";
_pnlinput.AddView((android.view.View)(_edtpassphrase.getObject()),__c.DipToCurrent((int) (8)),(int) (0),(int) (_dialogw-__c.DipToCurrent((int) (32))-__c.DipToCurrent((int) (56))),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 365;BA.debugLine="btnShowPass.Initialize(\"btnShowPass\")";
_btnshowpass.Initialize(ba,"btnShowPass");
 //BA.debugLineNum = 366;BA.debugLine="btnShowPass.Text = ModLang.T(\"view\")";
_btnshowpass.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"view")));
 //BA.debugLineNum = 367;BA.debugLine="btnShowPass.TextSize = Starter.FONT_CAPTION";
_btnshowpass.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 368;BA.debugLine="btnShowPass.Color = Colors.Transparent";
_btnshowpass.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 369;BA.debugLine="btnShowPass.TextColor = Colors.ARGB(200, 255, 255";
_btnshowpass.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 370;BA.debugLine="btnShowPass.Gravity = Gravity.CENTER";
_btnshowpass.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 371;BA.debugLine="pnlInput.AddView(btnShowPass, dialogW - 32dip - 6";
_pnlinput.AddView((android.view.View)(_btnshowpass.getObject()),(int) (_dialogw-__c.DipToCurrent((int) (32))-__c.DipToCurrent((int) (65))),__c.DipToCurrent((int) (5)),__c.DipToCurrent((int) (60)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 374;BA.debugLine="Dim btnCancel As Button";
_btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 375;BA.debugLine="btnCancel.Initialize(\"btnDialogCancel\")";
_btncancel.Initialize(ba,"btnDialogCancel");
 //BA.debugLineNum = 376;BA.debugLine="btnCancel.Text = ModLang.T(\"cancel\")";
_btncancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 377;BA.debugLine="btnCancel.TextSize = 13";
_btncancel.setTextSize((float) (13));
 //BA.debugLineNum = 378;BA.debugLine="btnCancel.Color = Colors.Transparent";
_btncancel.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 379;BA.debugLine="btnCancel.TextColor = Colors.ARGB(200, 255, 255,";
_btncancel.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 380;BA.debugLine="pnlDialog.AddView(btnCancel, 16dip, 115dip, 100di";
_pnldialog.AddView((android.view.View)(_btncancel.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (115)),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 382;BA.debugLine="Dim btnOk As Button";
_btnok = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 383;BA.debugLine="btnOk.Initialize(\"btnDialogOk\")";
_btnok.Initialize(ba,"btnDialogOk");
 //BA.debugLineNum = 384;BA.debugLine="btnOk.Text = ModLang.T(\"confirm\")";
_btnok.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"confirm")));
 //BA.debugLineNum = 385;BA.debugLine="btnOk.TextSize = 13";
_btnok.setTextSize((float) (13));
 //BA.debugLineNum = 386;BA.debugLine="btnOk.Color = ModTheme.HomeIconBg";
_btnok.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 387;BA.debugLine="btnOk.TextColor = Colors.White";
_btnok.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 388;BA.debugLine="pnlDialog.AddView(btnOk, dialogW - 116dip, 115dip";
_pnldialog.AddView((android.view.View)(_btnok.getObject()),(int) (_dialogw-__c.DipToCurrent((int) (116))),__c.DipToCurrent((int) (115)),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 390;BA.debugLine="pnlDialog.SetLayoutAnimated(0, 20dip, 80dip, dial";
_pnldialog.SetLayoutAnimated((int) (0),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (80)),_dialogw,__c.DipToCurrent((int) (165)));
 //BA.debugLineNum = 392;BA.debugLine="pnlOverlay.Visible = True";
_pnloverlay.setVisible(__c.True);
 //BA.debugLineNum = 393;BA.debugLine="pnlOverlay.BringToFront";
_pnloverlay.BringToFront();
 //BA.debugLineNum = 394;BA.debugLine="edtPassphrase.RequestFocus";
_edtpassphrase.RequestFocus();
 //BA.debugLineNum = 395;BA.debugLine="End Sub";
return "";
}
public String  _tmrclipboard_tick() throws Exception{
 //BA.debugLineNum = 490;BA.debugLine="Private Sub tmrClipboard_Tick";
 //BA.debugLineNum = 491;BA.debugLine="ClipboardCountdown = ClipboardCountdown - 1";
_clipboardcountdown = (int) (_clipboardcountdown-1);
 //BA.debugLineNum = 493;BA.debugLine="If ClipboardCountdown <= 0 Then";
if (_clipboardcountdown<=0) { 
 //BA.debugLineNum = 494;BA.debugLine="tmrClipboard.Enabled = False";
_tmrclipboard.setEnabled(__c.False);
 //BA.debugLineNum = 496;BA.debugLine="SetClipboardText(\"\")";
_setclipboardtext("");
 //BA.debugLineNum = 497;BA.debugLine="ToastMessageShow(ModLang.T(\"clipboard_clear\") &";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"clipboard_clear")+"!"),__c.False);
 };
 //BA.debugLineNum = 499;BA.debugLine="End Sub";
return "";
}
public String  _tmrsession_tick() throws Exception{
 //BA.debugLineNum = 505;BA.debugLine="Private Sub tmrSession_Tick";
 //BA.debugLineNum = 506;BA.debugLine="UpdateSessionTimer";
_updatesessiontimer();
 //BA.debugLineNum = 509;BA.debugLine="If ModSession.IsSessionActive = False Then";
if (_modsession._issessionactive /*boolean*/ (ba)==__c.False) { 
 //BA.debugLineNum = 510;BA.debugLine="tmrSession.Enabled = False";
_tmrsession.setEnabled(__c.False);
 //BA.debugLineNum = 511;BA.debugLine="ToastMessageShow(ModLang.T(\"session_expired\"), T";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"session_expired")),__c.True);
 //BA.debugLineNum = 512;BA.debugLine="B4XPages.ClosePage(Me)";
_b4xpages._closepage /*String*/ (ba,this);
 };
 //BA.debugLineNum = 514;BA.debugLine="End Sub";
return "";
}
public String  _updatesessiontimer() throws Exception{
int _remaining = 0;
 //BA.debugLineNum = 516;BA.debugLine="Private Sub UpdateSessionTimer";
 //BA.debugLineNum = 517;BA.debugLine="If ModSession.IsSessionActive Then";
if (_modsession._issessionactive /*boolean*/ (ba)) { 
 //BA.debugLineNum = 518;BA.debugLine="lblSessionTimer.Text = ModSession.GetRemainingFo";
_lblsessiontimer.setText(BA.ObjectToCharSequence(_modsession._getremainingformatted /*String*/ (ba)));
 //BA.debugLineNum = 521;BA.debugLine="Dim remaining As Int = ModSession.GetRemainingSe";
_remaining = _modsession._getremainingseconds /*int*/ (ba);
 //BA.debugLineNum = 522;BA.debugLine="If remaining < 60 Then";
if (_remaining<60) { 
 //BA.debugLineNum = 523;BA.debugLine="lblSessionTimer.TextColor = ModTheme.Warning";
_lblsessiontimer.setTextColor(_modtheme._warning /*int*/ (ba));
 }else {
 //BA.debugLineNum = 525;BA.debugLine="lblSessionTimer.TextColor = Colors.ARGB(200, 25";
_lblsessiontimer.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 };
 }else {
 //BA.debugLineNum = 528;BA.debugLine="lblSessionTimer.Text = \"00:00\"";
_lblsessiontimer.setText(BA.ObjectToCharSequence("00:00"));
 //BA.debugLineNum = 529;BA.debugLine="lblSessionTimer.TextColor = ModTheme.Danger";
_lblsessiontimer.setTextColor(_modtheme._danger /*int*/ (ba));
 };
 //BA.debugLineNum = 531;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
