package com.lockzero;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class pagenotesgroups extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.lockzero.pagenotesgroups");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.lockzero.pagenotesgroups.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnback = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblheadertitle = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _svgroups = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _pnlgroups = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnloverlay = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnldialog = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtgroupname = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtpassphrase = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtpassphraseconfirm = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chksecure = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnshowpass = null;
public boolean _ispassvisible = false;
public anywheresoftware.b4a.objects.PanelWrapper _pnlphrasearea = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlphraseconfirmarea = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblphraselabel = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblphraseconfirmlabel = null;
public String _currentdialogmode = "";
public String _currentgroupid = "";
public anywheresoftware.b4a.objects.LabelWrapper _lblsessiontimer = null;
public anywheresoftware.b4a.objects.Timer _tmrsession = null;
public boolean _isnavigating = false;
public com.lockzero.biometricmanager _biometric = null;
public String _pendingdeletegroupid = "";
public b4a.example.dateutils _dateutils = null;
public com.lockzero.main _main = null;
public com.lockzero.starter _starter = null;
public com.lockzero.modbackup _modbackup = null;
public com.lockzero.modlang _modlang = null;
public com.lockzero.modpasswords _modpasswords = null;
public com.lockzero.modsecurity _modsecurity = null;
public com.lockzero.modnotes _modnotes = null;
public com.lockzero.modsession _modsession = null;
public com.lockzero.modtheme _modtheme = null;
public com.lockzero.modtransition _modtransition = null;
public com.lockzero.b4xpages _b4xpages = null;
public com.lockzero.b4xcollections _b4xcollections = null;
public com.lockzero.xuiviewsutils _xuiviewsutils = null;
public String  _applytheme() throws Exception{
 //BA.debugLineNum = 980;BA.debugLine="Private Sub ApplyTheme";
 //BA.debugLineNum = 981;BA.debugLine="Root.Color = ModTheme.HomeBg";
_root.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 982;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_appear() throws Exception{
 //BA.debugLineNum = 53;BA.debugLine="Private Sub B4XPage_Appear";
 //BA.debugLineNum = 56;BA.debugLine="IsNavigating = False";
_isnavigating = __c.False;
 //BA.debugLineNum = 59;BA.debugLine="CallSub2(Main, \"SetPageTitle\", ModLang.T(\"note_gr";
__c.CallSubNew2(ba,(Object)(_main.getObject()),"SetPageTitle",(Object)(_modlang._t /*String*/ (ba,"note_groups")));
 //BA.debugLineNum = 61;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 62;BA.debugLine="LoadGroups";
_loadgroups();
 //BA.debugLineNum = 65;BA.debugLine="UpdateSessionTimer";
_updatesessiontimer();
 //BA.debugLineNum = 66;BA.debugLine="tmrSession.Enabled = True";
_tmrsession.setEnabled(__c.True);
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
 //BA.debugLineNum = 47;BA.debugLine="Private Sub B4XPage_Created(Root1 As B4XView)";
 //BA.debugLineNum = 48;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 49;BA.debugLine="CreateUI";
_createui();
 //BA.debugLineNum = 50;BA.debugLine="ApplyTheme";
_applytheme();
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_disappear() throws Exception{
 //BA.debugLineNum = 69;BA.debugLine="Private Sub B4XPage_Disappear";
 //BA.debugLineNum = 70;BA.debugLine="tmrSession.Enabled = False";
_tmrsession.setEnabled(__c.False);
 //BA.debugLineNum = 71;BA.debugLine="End Sub";
return "";
}
public String  _biometric_complete(boolean _success,String _errormessage) throws Exception{
 //BA.debugLineNum = 962;BA.debugLine="Private Sub Biometric_Complete(Success As Boolean,";
 //BA.debugLineNum = 963;BA.debugLine="If Success And PendingDeleteGroupId <> \"\" Then";
if (_success && (_pendingdeletegroupid).equals("") == false) { 
 //BA.debugLineNum = 964;BA.debugLine="ModNotes.DeleteNoteGroup(PendingDeleteGroupId)";
_modnotes._deletenotegroup /*String*/ (ba,_pendingdeletegroupid);
 //BA.debugLineNum = 965;BA.debugLine="PendingDeleteGroupId = \"\"";
_pendingdeletegroupid = "";
 //BA.debugLineNum = 966;BA.debugLine="LoadGroups";
_loadgroups();
 //BA.debugLineNum = 967;BA.debugLine="ToastMessageShow(ModLang.T(\"success\"), False)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"success")),__c.False);
 }else {
 //BA.debugLineNum = 969;BA.debugLine="PendingDeleteGroupId = \"\"";
_pendingdeletegroupid = "";
 //BA.debugLineNum = 970;BA.debugLine="If Success = False And ErrorMessage <> \"\" Then";
if (_success==__c.False && (_errormessage).equals("") == false) { 
 //BA.debugLineNum = 971;BA.debugLine="ToastMessageShow(ModLang.T(\"biometric_failed\"),";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"biometric_failed")),__c.True);
 };
 };
 //BA.debugLineNum = 974;BA.debugLine="End Sub";
return "";
}
public String  _btnadd_click() throws Exception{
 //BA.debugLineNum = 249;BA.debugLine="Private Sub btnAdd_Click";
 //BA.debugLineNum = 250;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 251;BA.debugLine="ShowAddGroupDialog";
_showaddgroupdialog();
 //BA.debugLineNum = 252;BA.debugLine="End Sub";
return "";
}
public String  _btnback_click() throws Exception{
 //BA.debugLineNum = 245;BA.debugLine="Private Sub btnBack_Click";
 //BA.debugLineNum = 246;BA.debugLine="B4XPages.ClosePage(Me)";
_b4xpages._closepage /*String*/ (ba,this);
 //BA.debugLineNum = 247;BA.debugLine="End Sub";
return "";
}
public String  _btndialogcancel_click() throws Exception{
 //BA.debugLineNum = 792;BA.debugLine="Private Sub btnDialogCancel_Click";
 //BA.debugLineNum = 793;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 794;BA.debugLine="End Sub";
return "";
}
public String  _btndialogok_click() throws Exception{
 //BA.debugLineNum = 796;BA.debugLine="Private Sub btnDialogOk_Click";
 //BA.debugLineNum = 797;BA.debugLine="Select CurrentDialogMode";
switch (BA.switchObjectToInt(_currentdialogmode,"add_group","unlock_group","edit_group","delete_group")) {
case 0: {
 //BA.debugLineNum = 799;BA.debugLine="ProcessAddGroup";
_processaddgroup();
 break; }
case 1: {
 //BA.debugLineNum = 801;BA.debugLine="ProcessUnlockGroup";
_processunlockgroup();
 break; }
case 2: {
 //BA.debugLineNum = 803;BA.debugLine="ProcessEditGroup";
_processeditgroup();
 break; }
case 3: {
 //BA.debugLineNum = 805;BA.debugLine="ProcessDeleteGroup";
_processdeletegroup();
 break; }
}
;
 //BA.debugLineNum = 807;BA.debugLine="End Sub";
return "";
}
public String  _btnshowpass_click() throws Exception{
 //BA.debugLineNum = 778;BA.debugLine="Private Sub btnShowPass_Click";
 //BA.debugLineNum = 779;BA.debugLine="IsPassVisible = Not(IsPassVisible)";
_ispassvisible = __c.Not(_ispassvisible);
 //BA.debugLineNum = 780;BA.debugLine="If IsPassVisible Then";
if (_ispassvisible) { 
 //BA.debugLineNum = 781;BA.debugLine="edtPassphrase.InputType = ModSecurity.GetSecureV";
_edtpassphrase.setInputType(_modsecurity._getsecurevisibleinputtype /*int*/ (ba));
 //BA.debugLineNum = 782;BA.debugLine="btnShowPass.Text = ModLang.T(\"hide\")";
_btnshowpass.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"hide")));
 //BA.debugLineNum = 783;BA.debugLine="btnShowPass.TextColor = Colors.White";
_btnshowpass.setTextColor(__c.Colors.White);
 }else {
 //BA.debugLineNum = 785;BA.debugLine="edtPassphrase.InputType = ModSecurity.GetSecureP";
_edtpassphrase.setInputType(_modsecurity._getsecurepassphraseinputtype /*int*/ (ba));
 //BA.debugLineNum = 786;BA.debugLine="btnShowPass.Text = ModLang.T(\"view\")";
_btnshowpass.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"view")));
 //BA.debugLineNum = 787;BA.debugLine="btnShowPass.TextColor = Colors.ARGB(200, 255, 25";
_btnshowpass.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 };
 //BA.debugLineNum = 789;BA.debugLine="edtPassphrase.SelectionStart = edtPassphrase.Text";
_edtpassphrase.setSelectionStart(_edtpassphrase.getText().length());
 //BA.debugLineNum = 790;BA.debugLine="End Sub";
return "";
}
public String  _chksecure_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 466;BA.debugLine="Private Sub chkSecure_CheckedChange(Checked As Boo";
 //BA.debugLineNum = 468;BA.debugLine="If lblPhraseLabel.IsInitialized And pnlPhraseArea";
if (_lblphraselabel.IsInitialized() && _pnlphrasearea.IsInitialized()) { 
 //BA.debugLineNum = 469;BA.debugLine="lblPhraseLabel.Visible = Checked";
_lblphraselabel.setVisible(_checked);
 //BA.debugLineNum = 470;BA.debugLine="pnlPhraseArea.Visible = Checked";
_pnlphrasearea.setVisible(_checked);
 //BA.debugLineNum = 471;BA.debugLine="If Not(Checked) Then";
if (__c.Not(_checked)) { 
 //BA.debugLineNum = 472;BA.debugLine="edtPassphrase.Text = \"\"  'Limpa frase se desmar";
_edtpassphrase.setText(BA.ObjectToCharSequence(""));
 };
 };
 //BA.debugLineNum = 475;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 4;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Public Root As B4XView  'Public para transicoes";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 6;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 9;BA.debugLine="Private btnBack As Button";
_btnback = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 10;BA.debugLine="Private lblHeaderTitle As Label";
_lblheadertitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 11;BA.debugLine="Private svGroups As ScrollView";
_svgroups = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 12;BA.debugLine="Private pnlGroups As B4XView";
_pnlgroups = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Private pnlOverlay As Panel";
_pnloverlay = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private pnlDialog As Panel";
_pnldialog = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private edtGroupName As EditText";
_edtgroupname = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private edtPassphrase As EditText";
_edtpassphrase = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private edtPassphraseConfirm As EditText";
_edtpassphraseconfirm = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private chkSecure As CheckBox";
_chksecure = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private btnShowPass As Button";
_btnshowpass = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private IsPassVisible As Boolean = False";
_ispassvisible = __c.False;
 //BA.debugLineNum = 23;BA.debugLine="Private pnlPhraseArea As Panel  'Container do cam";
_pnlphrasearea = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private pnlPhraseConfirmArea As Panel  'Container";
_pnlphraseconfirmarea = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private lblPhraseLabel As Label  'Label \"Frase\"";
_lblphraselabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private lblPhraseConfirmLabel As Label  'Label \"C";
_lblphraseconfirmlabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private CurrentDialogMode As String = \"\" 'add_gro";
_currentdialogmode = "";
 //BA.debugLineNum = 28;BA.debugLine="Private CurrentGroupId As String = \"\"";
_currentgroupid = "";
 //BA.debugLineNum = 31;BA.debugLine="Private lblSessionTimer As Label";
_lblsessiontimer = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Private tmrSession As Timer";
_tmrsession = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 35;BA.debugLine="Private IsNavigating As Boolean = False";
_isnavigating = __c.False;
 //BA.debugLineNum = 38;BA.debugLine="Private Biometric As BiometricManager";
_biometric = new com.lockzero.biometricmanager();
 //BA.debugLineNum = 39;BA.debugLine="Private PendingDeleteGroupId As String = \"\"";
_pendingdeletegroupid = "";
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return "";
}
public void  _confirmdeletegroup(String _groupid) throws Exception{
ResumableSub_ConfirmDeleteGroup rsub = new ResumableSub_ConfirmDeleteGroup(this,_groupid);
rsub.resume(ba, null);
}
public static class ResumableSub_ConfirmDeleteGroup extends BA.ResumableSub {
public ResumableSub_ConfirmDeleteGroup(com.lockzero.pagenotesgroups parent,String _groupid) {
this.parent = parent;
this._groupid = _groupid;
}
com.lockzero.pagenotesgroups parent;
String _groupid;
com.lockzero.clsnotegroup _g = null;
int _count = 0;
String _msg = "";
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
 //BA.debugLineNum = 659;BA.debugLine="Dim g As clsNoteGroup = ModNotes.GetNoteGroupById";
_g = parent._modnotes._getnotegroupbyid /*com.lockzero.clsnotegroup*/ (ba,_groupid);
 //BA.debugLineNum = 660;BA.debugLine="If g.IsInitialized = False Then Return";
if (true) break;

case 1:
//if
this.state = 6;
if (_g._isinitialized /*boolean*/ ()==parent.__c.False) { 
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
 //BA.debugLineNum = 662;BA.debugLine="Dim count As Int = ModNotes.CountByGroup(groupId)";
_count = parent._modnotes._countbygroup /*int*/ (ba,_groupid);
 //BA.debugLineNum = 663;BA.debugLine="Dim msg As String = ModLang.T(\"note_group_delete_";
_msg = parent._modlang._t /*String*/ (ba,"note_group_delete_confirm");
 //BA.debugLineNum = 664;BA.debugLine="If count > 0 Then";
if (true) break;

case 7:
//if
this.state = 10;
if (_count>0) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 665;BA.debugLine="msg = msg & CRLF & CRLF & count & \" \" & ModLang.";
_msg = _msg+parent.__c.CRLF+parent.__c.CRLF+BA.NumberToString(_count)+" "+parent._modlang._t /*String*/ (ba,"notes")+"!";
 if (true) break;

case 10:
//C
this.state = 11;
;
 //BA.debugLineNum = 668;BA.debugLine="Wait For (xui.Msgbox2Async(msg, ModLang.T(\"note_g";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(_msg),BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"note_group_delete")),parent._modlang._t /*String*/ (ba,"delete"),"",parent._modlang._t /*String*/ (ba,"cancel"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 33;
return;
case 33:
//C
this.state = 11;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 670;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
if (true) break;

case 11:
//if
this.state = 32;
if (_result==parent._xui.DialogResponse_Positive) { 
this.state = 13;
}if (true) break;

case 13:
//C
this.state = 14;
 //BA.debugLineNum = 672;BA.debugLine="If g.IsSecure Then";
if (true) break;

case 14:
//if
this.state = 31;
if (_g._issecure /*boolean*/ ) { 
this.state = 16;
}else {
this.state = 30;
}if (true) break;

case 16:
//C
this.state = 17;
 //BA.debugLineNum = 673;BA.debugLine="If ModSession.IsSessionActive Then";
if (true) break;

case 17:
//if
this.state = 28;
if (parent._modsession._issessionactive /*boolean*/ (ba)) { 
this.state = 19;
}else {
this.state = 27;
}if (true) break;

case 19:
//C
this.state = 20;
 //BA.debugLineNum = 675;BA.debugLine="If ModSecurity.GetUseBiometric And Biometric.C";
if (true) break;

case 20:
//if
this.state = 25;
if (parent._modsecurity._getusebiometric /*boolean*/ (ba) && (parent._biometric._canauthenticate /*String*/ ()).equals("SUCCESS")) { 
this.state = 22;
}else {
this.state = 24;
}if (true) break;

case 22:
//C
this.state = 25;
 //BA.debugLineNum = 676;BA.debugLine="PendingDeleteGroupId = groupId";
parent._pendingdeletegroupid = _groupid;
 //BA.debugLineNum = 677;BA.debugLine="Biometric.Show(ModLang.T(\"biometric_prompt\"))";
parent._biometric._show /*String*/ (parent._modlang._t /*String*/ (ba,"biometric_prompt"));
 if (true) break;

case 24:
//C
this.state = 25;
 //BA.debugLineNum = 680;BA.debugLine="ModNotes.DeleteNoteGroup(groupId)";
parent._modnotes._deletenotegroup /*String*/ (ba,_groupid);
 //BA.debugLineNum = 681;BA.debugLine="LoadGroups";
parent._loadgroups();
 //BA.debugLineNum = 682;BA.debugLine="ToastMessageShow(ModLang.T(\"success\"), False)";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"success")),parent.__c.False);
 if (true) break;

case 25:
//C
this.state = 28;
;
 if (true) break;

case 27:
//C
this.state = 28;
 //BA.debugLineNum = 686;BA.debugLine="ShowDeleteGroupDialog(groupId)";
parent._showdeletegroupdialog(_groupid);
 if (true) break;

case 28:
//C
this.state = 31;
;
 if (true) break;

case 30:
//C
this.state = 31;
 //BA.debugLineNum = 690;BA.debugLine="ModNotes.DeleteNoteGroup(groupId)";
parent._modnotes._deletenotegroup /*String*/ (ba,_groupid);
 //BA.debugLineNum = 691;BA.debugLine="LoadGroups";
parent._loadgroups();
 //BA.debugLineNum = 692;BA.debugLine="ToastMessageShow(ModLang.T(\"success\"), False)";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"success")),parent.__c.False);
 if (true) break;

case 31:
//C
this.state = 32;
;
 if (true) break;

case 32:
//C
this.state = -1;
;
 //BA.debugLineNum = 695;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _msgbox_result(int _result) throws Exception{
}
public String  _createdialogoverlay() throws Exception{
int _width = 0;
int _height = 0;
int _dialogw = 0;
int _dialogh = 0;
int _dialogx = 0;
int _dialogy = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _xvdialog = null;
 //BA.debugLineNum = 144;BA.debugLine="Private Sub CreateDialogOverlay";
 //BA.debugLineNum = 145;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 146;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 149;BA.debugLine="pnlOverlay.Initialize(\"pnlOverlay\")";
_pnloverlay.Initialize(ba,"pnlOverlay");
 //BA.debugLineNum = 150;BA.debugLine="pnlOverlay.Color = Colors.ARGB(180, 0, 0, 0)";
_pnloverlay.setColor(__c.Colors.ARGB((int) (180),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 151;BA.debugLine="pnlOverlay.Visible = False";
_pnloverlay.setVisible(__c.False);
 //BA.debugLineNum = 152;BA.debugLine="Root.AddView(pnlOverlay, 0, 0, width, height)";
_root.AddView((android.view.View)(_pnloverlay.getObject()),(int) (0),(int) (0),_width,_height);
 //BA.debugLineNum = 155;BA.debugLine="Dim dialogW As Int = width - 40dip";
_dialogw = (int) (_width-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 156;BA.debugLine="Dim dialogH As Int = 280dip";
_dialogh = __c.DipToCurrent((int) (280));
 //BA.debugLineNum = 157;BA.debugLine="Dim dialogX As Int = 20dip";
_dialogx = __c.DipToCurrent((int) (20));
 //BA.debugLineNum = 158;BA.debugLine="Dim dialogY As Int = 60dip";
_dialogy = __c.DipToCurrent((int) (60));
 //BA.debugLineNum = 160;BA.debugLine="pnlDialog.Initialize(\"\")";
_pnldialog.Initialize(ba,"");
 //BA.debugLineNum = 161;BA.debugLine="pnlDialog.Color = ModTheme.HomeHeaderBg";
_pnldialog.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 162;BA.debugLine="pnlOverlay.AddView(pnlDialog, dialogX, dialogY, d";
_pnloverlay.AddView((android.view.View)(_pnldialog.getObject()),_dialogx,_dialogy,_dialogw,_dialogh);
 //BA.debugLineNum = 165;BA.debugLine="Dim xvDialog As B4XView = pnlDialog";
_xvdialog = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvdialog = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnldialog.getObject()));
 //BA.debugLineNum = 166;BA.debugLine="xvDialog.SetColorAndBorder(ModTheme.HomeHeaderBg,";
_xvdialog.SetColorAndBorder(_modtheme._homeheaderbg /*int*/ (ba),(int) (0),_modtheme._homeheaderbg /*int*/ (ba),__c.DipToCurrent((int) (12)));
 //BA.debugLineNum = 167;BA.debugLine="End Sub";
return "";
}
public String  _createui() throws Exception{
int _width = 0;
int _height = 0;
int _headerh = 0;
anywheresoftware.b4a.objects.PanelWrapper _pnlheader = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xvtimer = null;
anywheresoftware.b4a.objects.LabelWrapper _lbladd = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xvadd = null;
 //BA.debugLineNum = 77;BA.debugLine="Private Sub CreateUI";
 //BA.debugLineNum = 78;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 79;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 80;BA.debugLine="Dim headerH As Int = 56dip";
_headerh = __c.DipToCurrent((int) (56));
 //BA.debugLineNum = 83;BA.debugLine="Dim pnlHeader As Panel";
_pnlheader = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 84;BA.debugLine="pnlHeader.Initialize(\"\")";
_pnlheader.Initialize(ba,"");
 //BA.debugLineNum = 85;BA.debugLine="pnlHeader.Color = ModTheme.HomeHeaderBg";
_pnlheader.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 86;BA.debugLine="Root.AddView(pnlHeader, 0, 0, width, headerH)";
_root.AddView((android.view.View)(_pnlheader.getObject()),(int) (0),(int) (0),_width,_headerh);
 //BA.debugLineNum = 89;BA.debugLine="btnBack.Initialize(\"btnBack\")";
_btnback.Initialize(ba,"btnBack");
 //BA.debugLineNum = 90;BA.debugLine="btnBack.Text = \"<\"";
_btnback.setText(BA.ObjectToCharSequence("<"));
 //BA.debugLineNum = 91;BA.debugLine="btnBack.TextSize = 20";
_btnback.setTextSize((float) (20));
 //BA.debugLineNum = 92;BA.debugLine="btnBack.Color = Colors.Transparent";
_btnback.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 93;BA.debugLine="btnBack.TextColor = Colors.White";
_btnback.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 94;BA.debugLine="btnBack.Gravity = Gravity.CENTER";
_btnback.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 95;BA.debugLine="pnlHeader.AddView(btnBack, 0, 0, 50dip, headerH)";
_pnlheader.AddView((android.view.View)(_btnback.getObject()),(int) (0),(int) (0),__c.DipToCurrent((int) (50)),_headerh);
 //BA.debugLineNum = 98;BA.debugLine="lblHeaderTitle.Initialize(\"\")";
_lblheadertitle.Initialize(ba,"");
 //BA.debugLineNum = 99;BA.debugLine="lblHeaderTitle.Text = ModLang.T(\"note_groups\")";
_lblheadertitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"note_groups")));
 //BA.debugLineNum = 100;BA.debugLine="lblHeaderTitle.TextSize = Starter.FONT_BODY";
_lblheadertitle.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 101;BA.debugLine="lblHeaderTitle.TextColor = Colors.White";
_lblheadertitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 102;BA.debugLine="lblHeaderTitle.Typeface = Typeface.DEFAULT_BOLD";
_lblheadertitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 103;BA.debugLine="lblHeaderTitle.Gravity = Gravity.CENTER_VERTICAL";
_lblheadertitle.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 104;BA.debugLine="pnlHeader.AddView(lblHeaderTitle, 50dip, 0, width";
_pnlheader.AddView((android.view.View)(_lblheadertitle.getObject()),__c.DipToCurrent((int) (50)),(int) (0),(int) (_width-__c.DipToCurrent((int) (160))),_headerh);
 //BA.debugLineNum = 107;BA.debugLine="lblSessionTimer.Initialize(\"lblSessionTimer\")";
_lblsessiontimer.Initialize(ba,"lblSessionTimer");
 //BA.debugLineNum = 108;BA.debugLine="lblSessionTimer.Text = \"00:00\"";
_lblsessiontimer.setText(BA.ObjectToCharSequence("00:00"));
 //BA.debugLineNum = 109;BA.debugLine="lblSessionTimer.TextSize = Starter.FONT_CAPTION";
_lblsessiontimer.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 110;BA.debugLine="lblSessionTimer.TextColor = Colors.ARGB(200, 255,";
_lblsessiontimer.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 111;BA.debugLine="lblSessionTimer.Gravity = Gravity.CENTER";
_lblsessiontimer.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 112;BA.debugLine="pnlHeader.AddView(lblSessionTimer, width - 110dip";
_pnlheader.AddView((android.view.View)(_lblsessiontimer.getObject()),(int) (_width-__c.DipToCurrent((int) (110))),__c.DipToCurrent((int) (12)),__c.DipToCurrent((int) (55)),__c.DipToCurrent((int) (32)));
 //BA.debugLineNum = 115;BA.debugLine="Dim xvTimer As B4XView = lblSessionTimer";
_xvtimer = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvtimer = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lblsessiontimer.getObject()));
 //BA.debugLineNum = 116;BA.debugLine="xvTimer.SetColorAndBorder(Colors.ARGB(60, 255, 25";
_xvtimer.SetColorAndBorder(__c.Colors.ARGB((int) (60),(int) (255),(int) (255),(int) (255)),(int) (0),__c.Colors.Transparent,__c.DipToCurrent((int) (8)));
 //BA.debugLineNum = 119;BA.debugLine="Dim lblAdd As Label";
_lbladd = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 120;BA.debugLine="lblAdd.Initialize(\"btnAdd\")";
_lbladd.Initialize(ba,"btnAdd");
 //BA.debugLineNum = 121;BA.debugLine="lblAdd.Text = \"+\"";
_lbladd.setText(BA.ObjectToCharSequence("+"));
 //BA.debugLineNum = 122;BA.debugLine="lblAdd.TextSize = 26";
_lbladd.setTextSize((float) (26));
 //BA.debugLineNum = 123;BA.debugLine="lblAdd.Typeface = Typeface.DEFAULT_BOLD";
_lbladd.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 124;BA.debugLine="lblAdd.Gravity = Gravity.CENTER";
_lbladd.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 125;BA.debugLine="lblAdd.TextColor = Colors.White";
_lbladd.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 126;BA.debugLine="pnlHeader.AddView(lblAdd, width - 50dip, 8dip, 40";
_pnlheader.AddView((android.view.View)(_lbladd.getObject()),(int) (_width-__c.DipToCurrent((int) (50))),__c.DipToCurrent((int) (8)),__c.DipToCurrent((int) (40)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 129;BA.debugLine="Dim xvAdd As B4XView = lblAdd";
_xvadd = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvadd = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbladd.getObject()));
 //BA.debugLineNum = 130;BA.debugLine="xvAdd.SetColorAndBorder(ModTheme.HomeIconBg, 0, M";
_xvadd.SetColorAndBorder(_modtheme._homeiconbg /*int*/ (ba),(int) (0),_modtheme._homeiconbg /*int*/ (ba),__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 133;BA.debugLine="svGroups.Initialize(0)";
_svgroups.Initialize(ba,(int) (0));
 //BA.debugLineNum = 134;BA.debugLine="svGroups.Color = ModTheme.HomeBg";
_svgroups.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 135;BA.debugLine="Root.AddView(svGroups, 0, headerH, width, height";
_root.AddView((android.view.View)(_svgroups.getObject()),(int) (0),_headerh,_width,(int) (_height-_headerh));
 //BA.debugLineNum = 137;BA.debugLine="pnlGroups = svGroups.Panel";
_pnlgroups = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_svgroups.getPanel().getObject()));
 //BA.debugLineNum = 138;BA.debugLine="pnlGroups.Color = ModTheme.HomeBg";
_pnlgroups.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 141;BA.debugLine="CreateDialogOverlay";
_createdialogoverlay();
 //BA.debugLineNum = 142;BA.debugLine="End Sub";
return "";
}
public String  _hidedialog() throws Exception{
anywheresoftware.b4a.objects.IME _ime = null;
 //BA.debugLineNum = 809;BA.debugLine="Private Sub HideDialog";
 //BA.debugLineNum = 810;BA.debugLine="pnlOverlay.Visible = False";
_pnloverlay.setVisible(__c.False);
 //BA.debugLineNum = 811;BA.debugLine="CurrentDialogMode = \"\"";
_currentdialogmode = "";
 //BA.debugLineNum = 812;BA.debugLine="Dim ime As IME";
_ime = new anywheresoftware.b4a.objects.IME();
 //BA.debugLineNum = 813;BA.debugLine="ime.Initialize(\"\")";
_ime.Initialize("");
 //BA.debugLineNum = 814;BA.debugLine="ime.HideKeyboard";
_ime.HideKeyboard(ba);
 //BA.debugLineNum = 815;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 42;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 43;BA.debugLine="tmrSession.Initialize(\"tmrSession\", 1000)";
_tmrsession.Initialize(ba,"tmrSession",(long) (1000));
 //BA.debugLineNum = 44;BA.debugLine="Biometric.Initialize(Me, \"Biometric\")";
_biometric._initialize /*String*/ (ba,this,"Biometric");
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return "";
}
public void  _lblsessiontimer_click() throws Exception{
ResumableSub_lblSessionTimer_Click rsub = new ResumableSub_lblSessionTimer_Click(this);
rsub.resume(ba, null);
}
public static class ResumableSub_lblSessionTimer_Click extends BA.ResumableSub {
public ResumableSub_lblSessionTimer_Click(com.lockzero.pagenotesgroups parent) {
this.parent = parent;
}
com.lockzero.pagenotesgroups parent;
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
 //BA.debugLineNum = 1010;BA.debugLine="Wait For (xui.Msgbox2Async(ModLang.T(\"lock_confir";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"lock_confirm_msg")),BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"lock")),parent._modlang._t /*String*/ (ba,"yes"),"",parent._modlang._t /*String*/ (ba,"cancel"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 1012;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
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
 //BA.debugLineNum = 1013;BA.debugLine="tmrSession.Enabled = False";
parent._tmrsession.setEnabled(parent.__c.False);
 //BA.debugLineNum = 1014;BA.debugLine="ModSession.EndSession";
parent._modsession._endsession /*String*/ (ba);
 //BA.debugLineNum = 1015;BA.debugLine="B4XPages.ClosePage(Me)";
parent._b4xpages._closepage /*String*/ (ba,parent);
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 1017;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _loadgroups() throws Exception{
anywheresoftware.b4a.objects.collections.List _groups = null;
int _width = 0;
int _itemheight = 0;
int _y = 0;
anywheresoftware.b4a.objects.LabelWrapper _lblempty = null;
com.lockzero.clsnotegroup _g = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlitem = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xvitem = null;
anywheresoftware.b4a.objects.LabelWrapper _lblname = null;
int _count = 0;
anywheresoftware.b4a.objects.LabelWrapper _lblcount = null;
anywheresoftware.b4a.objects.LabelWrapper _lblarrow = null;
 //BA.debugLineNum = 173;BA.debugLine="Private Sub LoadGroups";
 //BA.debugLineNum = 174;BA.debugLine="ModNotes.Init";
_modnotes._init /*String*/ (ba);
 //BA.debugLineNum = 176;BA.debugLine="pnlGroups.RemoveAllViews";
_pnlgroups.RemoveAllViews();
 //BA.debugLineNum = 178;BA.debugLine="Dim groups As List = ModNotes.GetAllNoteGroups";
_groups = new anywheresoftware.b4a.objects.collections.List();
_groups = _modnotes._getallnotegroups /*anywheresoftware.b4a.objects.collections.List*/ (ba);
 //BA.debugLineNum = 179;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 180;BA.debugLine="Dim itemHeight As Int = 70dip";
_itemheight = __c.DipToCurrent((int) (70));
 //BA.debugLineNum = 181;BA.debugLine="Dim y As Int = 16dip";
_y = __c.DipToCurrent((int) (16));
 //BA.debugLineNum = 183;BA.debugLine="If groups.Size = 0 Then";
if (_groups.getSize()==0) { 
 //BA.debugLineNum = 185;BA.debugLine="Dim lblEmpty As Label";
_lblempty = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 186;BA.debugLine="lblEmpty.Initialize(\"\")";
_lblempty.Initialize(ba,"");
 //BA.debugLineNum = 187;BA.debugLine="lblEmpty.Text = ModLang.T(\"note_group_empty\")";
_lblempty.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"note_group_empty")));
 //BA.debugLineNum = 188;BA.debugLine="lblEmpty.TextSize = Starter.FONT_BUTTON";
_lblempty.setTextSize(_starter._font_button /*float*/ );
 //BA.debugLineNum = 189;BA.debugLine="lblEmpty.TextColor = Colors.ARGB(150, 255, 255,";
_lblempty.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 190;BA.debugLine="lblEmpty.Gravity = Gravity.CENTER";
_lblempty.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 191;BA.debugLine="pnlGroups.AddView(lblEmpty, 0, 100dip, width, 40";
_pnlgroups.AddView((android.view.View)(_lblempty.getObject()),(int) (0),__c.DipToCurrent((int) (100)),_width,__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 192;BA.debugLine="pnlGroups.Height = 200dip";
_pnlgroups.setHeight(__c.DipToCurrent((int) (200)));
 //BA.debugLineNum = 193;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 196;BA.debugLine="For Each g As clsNoteGroup In groups";
{
final anywheresoftware.b4a.BA.IterableList group18 = _groups;
final int groupLen18 = group18.getSize()
;int index18 = 0;
;
for (; index18 < groupLen18;index18++){
_g = (com.lockzero.clsnotegroup)(group18.Get(index18));
 //BA.debugLineNum = 197;BA.debugLine="Dim pnlItem As Panel";
_pnlitem = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 198;BA.debugLine="pnlItem.Initialize(\"pnlGroup\")";
_pnlitem.Initialize(ba,"pnlGroup");
 //BA.debugLineNum = 199;BA.debugLine="pnlItem.Tag = g.Id";
_pnlitem.setTag((Object)(_g._id /*String*/ ));
 //BA.debugLineNum = 202;BA.debugLine="Dim xvItem As B4XView = pnlItem";
_xvitem = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvitem = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnlitem.getObject()));
 //BA.debugLineNum = 203;BA.debugLine="xvItem.SetColorAndBorder(ModTheme.HomeIconBg, 0,";
_xvitem.SetColorAndBorder(_modtheme._homeiconbg /*int*/ (ba),(int) (0),_modtheme._homeiconbg /*int*/ (ba),__c.DipToCurrent((int) (12)));
 //BA.debugLineNum = 204;BA.debugLine="pnlGroups.AddView(pnlItem, 16dip, y, width - 32d";
_pnlgroups.AddView((android.view.View)(_pnlitem.getObject()),__c.DipToCurrent((int) (16)),_y,(int) (_width-__c.DipToCurrent((int) (32))),_itemheight);
 //BA.debugLineNum = 207;BA.debugLine="Dim lblName As Label";
_lblname = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 208;BA.debugLine="lblName.Initialize(\"\")";
_lblname.Initialize(ba,"");
 //BA.debugLineNum = 209;BA.debugLine="lblName.Text = g.Icon & \" \" & g.Name";
_lblname.setText(BA.ObjectToCharSequence(_g._icon /*String*/ +" "+_g._name /*String*/ ));
 //BA.debugLineNum = 210;BA.debugLine="lblName.TextSize = Starter.FONT_BODY";
_lblname.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 211;BA.debugLine="lblName.TextColor = Colors.White";
_lblname.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 212;BA.debugLine="lblName.Typeface = Typeface.DEFAULT_BOLD";
_lblname.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 213;BA.debugLine="lblName.Gravity = Gravity.CENTER_VERTICAL";
_lblname.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 214;BA.debugLine="pnlItem.AddView(lblName, 16dip, 0, width - 140di";
_pnlitem.AddView((android.view.View)(_lblname.getObject()),__c.DipToCurrent((int) (16)),(int) (0),(int) (_width-__c.DipToCurrent((int) (140))),_itemheight);
 //BA.debugLineNum = 217;BA.debugLine="Dim count As Int = ModNotes.CountByGroup(g.Id)";
_count = _modnotes._countbygroup /*int*/ (ba,_g._id /*String*/ );
 //BA.debugLineNum = 218;BA.debugLine="Dim lblCount As Label";
_lblcount = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 219;BA.debugLine="lblCount.Initialize(\"\")";
_lblcount.Initialize(ba,"");
 //BA.debugLineNum = 220;BA.debugLine="lblCount.Text = \"(\" & count & \")\"";
_lblcount.setText(BA.ObjectToCharSequence("("+BA.NumberToString(_count)+")"));
 //BA.debugLineNum = 221;BA.debugLine="lblCount.TextSize = Starter.FONT_BUTTON";
_lblcount.setTextSize(_starter._font_button /*float*/ );
 //BA.debugLineNum = 222;BA.debugLine="lblCount.TextColor = Colors.ARGB(180, 255, 255,";
_lblcount.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 223;BA.debugLine="lblCount.Gravity = Gravity.CENTER";
_lblcount.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 224;BA.debugLine="pnlItem.AddView(lblCount, width - 110dip, 0, 40d";
_pnlitem.AddView((android.view.View)(_lblcount.getObject()),(int) (_width-__c.DipToCurrent((int) (110))),(int) (0),__c.DipToCurrent((int) (40)),_itemheight);
 //BA.debugLineNum = 227;BA.debugLine="Dim lblArrow As Label";
_lblarrow = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 228;BA.debugLine="lblArrow.Initialize(\"\")";
_lblarrow.Initialize(ba,"");
 //BA.debugLineNum = 229;BA.debugLine="lblArrow.Text = \">\"";
_lblarrow.setText(BA.ObjectToCharSequence(">"));
 //BA.debugLineNum = 230;BA.debugLine="lblArrow.TextSize = 18";
_lblarrow.setTextSize((float) (18));
 //BA.debugLineNum = 231;BA.debugLine="lblArrow.TextColor = Colors.ARGB(150, 255, 255,";
_lblarrow.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 232;BA.debugLine="lblArrow.Gravity = Gravity.CENTER";
_lblarrow.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 233;BA.debugLine="pnlItem.AddView(lblArrow, width - 70dip, 0, 30di";
_pnlitem.AddView((android.view.View)(_lblarrow.getObject()),(int) (_width-__c.DipToCurrent((int) (70))),(int) (0),__c.DipToCurrent((int) (30)),_itemheight);
 //BA.debugLineNum = 235;BA.debugLine="y = y + itemHeight + 12dip";
_y = (int) (_y+_itemheight+__c.DipToCurrent((int) (12)));
 }
};
 //BA.debugLineNum = 238;BA.debugLine="pnlGroups.Height = y + 20dip";
_pnlgroups.setHeight((int) (_y+__c.DipToCurrent((int) (20))));
 //BA.debugLineNum = 239;BA.debugLine="End Sub";
return "";
}
public String  _navigatetogroup(String _groupid) throws Exception{
anywheresoftware.b4a.objects.collections.Map _params = null;
com.lockzero.pagenoteslist _pg = null;
 //BA.debugLineNum = 289;BA.debugLine="Private Sub NavigateToGroup(groupId As String)";
 //BA.debugLineNum = 291;BA.debugLine="If IsNavigating Then Return";
if (_isnavigating) { 
if (true) return "";};
 //BA.debugLineNum = 292;BA.debugLine="IsNavigating = True";
_isnavigating = __c.True;
 //BA.debugLineNum = 294;BA.debugLine="Dim params As Map";
_params = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 295;BA.debugLine="params.Initialize";
_params.Initialize();
 //BA.debugLineNum = 296;BA.debugLine="params.Put(\"groupId\", groupId)";
_params.Put((Object)("groupId"),(Object)(_groupid));
 //BA.debugLineNum = 297;BA.debugLine="params.Put(\"isNoteGroup\", True)  'Flag para indic";
_params.Put((Object)("isNoteGroup"),(Object)(__c.True));
 //BA.debugLineNum = 299;BA.debugLine="Dim pg As PageNotesList = B4XPages.GetPage(\"PageN";
_pg = (com.lockzero.pagenoteslist)(_b4xpages._getpage /*Object*/ (ba,"PageNotesList"));
 //BA.debugLineNum = 300;BA.debugLine="pg.SetParams(params)";
_pg._setparams /*String*/ (_params);
 //BA.debugLineNum = 301;BA.debugLine="ModTransition.SlideToLeft(Root, pg.Root)";
_modtransition._slidetoleft /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (ba,_root,_pg._root /*anywheresoftware.b4a.objects.B4XViewWrapper*/ );
 //BA.debugLineNum = 302;BA.debugLine="B4XPages.ShowPage(\"PageNotesList\")";
_b4xpages._showpage /*String*/ (ba,"PageNotesList");
 //BA.debugLineNum = 303;BA.debugLine="End Sub";
return "";
}
public String  _pnlgroup_click() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
String _groupid = "";
com.lockzero.clsnotegroup _g = null;
 //BA.debugLineNum = 259;BA.debugLine="Private Sub pnlGroup_Click";
 //BA.debugLineNum = 260;BA.debugLine="Dim pnl As Panel = Sender";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
_pnl = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(__c.Sender(ba)));
 //BA.debugLineNum = 261;BA.debugLine="Dim groupId As String = pnl.Tag";
_groupid = BA.ObjectToString(_pnl.getTag());
 //BA.debugLineNum = 263;BA.debugLine="Dim g As clsNoteGroup = ModNotes.GetNoteGroupById";
_g = _modnotes._getnotegroupbyid /*com.lockzero.clsnotegroup*/ (ba,_groupid);
 //BA.debugLineNum = 264;BA.debugLine="If g.IsInitialized = False Then Return";
if (_g._isinitialized /*boolean*/ ()==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 267;BA.debugLine="If g.IsSecure = False Then";
if (_g._issecure /*boolean*/ ==__c.False) { 
 //BA.debugLineNum = 268;BA.debugLine="NavigateToGroup(groupId)";
_navigatetogroup(_groupid);
 //BA.debugLineNum = 269;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 273;BA.debugLine="If ModSession.IsSessionActive Then";
if (_modsession._issessionactive /*boolean*/ (ba)) { 
 //BA.debugLineNum = 274;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 275;BA.debugLine="NavigateToGroup(groupId)";
_navigatetogroup(_groupid);
 //BA.debugLineNum = 276;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 280;BA.debugLine="ShowUnlockGroupDialog(groupId)";
_showunlockgroupdialog(_groupid);
 //BA.debugLineNum = 281;BA.debugLine="End Sub";
return "";
}
public String  _pnlgroup_longclick() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
String _groupid = "";
 //BA.debugLineNum = 283;BA.debugLine="Private Sub pnlGroup_LongClick";
 //BA.debugLineNum = 284;BA.debugLine="Dim pnl As Panel = Sender";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
_pnl = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(__c.Sender(ba)));
 //BA.debugLineNum = 285;BA.debugLine="Dim groupId As String = pnl.Tag";
_groupid = BA.ObjectToString(_pnl.getTag());
 //BA.debugLineNum = 286;BA.debugLine="ShowGroupOptions(groupId)";
_showgroupoptions(_groupid);
 //BA.debugLineNum = 287;BA.debugLine="End Sub";
return "";
}
public String  _pnloverlay_click() throws Exception{
 //BA.debugLineNum = 254;BA.debugLine="Private Sub pnlOverlay_Click";
 //BA.debugLineNum = 256;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 257;BA.debugLine="End Sub";
return "";
}
public String  _processaddgroup() throws Exception{
String _groupname = "";
boolean _issecure = false;
String _groupicon = "";
String _phrase = "";
String _phraseerror = "";
String _phraseconfirm = "";
com.lockzero.clsnotegroup _g = null;
 //BA.debugLineNum = 817;BA.debugLine="Private Sub ProcessAddGroup";
 //BA.debugLineNum = 818;BA.debugLine="Dim groupName As String = edtGroupName.Text.Trim";
_groupname = _edtgroupname.getText().trim();
 //BA.debugLineNum = 819;BA.debugLine="Dim isSecure As Boolean = chkSecure.Checked";
_issecure = _chksecure.getChecked();
 //BA.debugLineNum = 821;BA.debugLine="Dim groupIcon As String";
_groupicon = "";
 //BA.debugLineNum = 822;BA.debugLine="If isSecure Then";
if (_issecure) { 
 //BA.debugLineNum = 823;BA.debugLine="groupIcon = Chr(0xD83D) & Chr(0xDD12)  '🔒 cadea";
_groupicon = BA.ObjectToString(__c.Chr(((int)0xd83d)))+BA.ObjectToString(__c.Chr(((int)0xdd12)));
 }else {
 //BA.debugLineNum = 825;BA.debugLine="groupIcon = Chr(0xD83D) & Chr(0xDCDD)  '📝 nota";
_groupicon = BA.ObjectToString(__c.Chr(((int)0xd83d)))+BA.ObjectToString(__c.Chr(((int)0xdcdd)));
 };
 //BA.debugLineNum = 829;BA.debugLine="If groupName.Length = 0 Then";
if (_groupname.length()==0) { 
 //BA.debugLineNum = 830;BA.debugLine="ToastMessageShow(ModLang.T(\"error_empty_field\"),";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error_empty_field")),__c.True);
 //BA.debugLineNum = 831;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 835;BA.debugLine="Dim phrase As String = \"\"";
_phrase = "";
 //BA.debugLineNum = 836;BA.debugLine="If ModSession.IsSessionActive Then";
if (_modsession._issessionactive /*boolean*/ (ba)) { 
 //BA.debugLineNum = 838;BA.debugLine="phrase = ModSession.GetPassphrase";
_phrase = _modsession._getpassphrase /*String*/ (ba);
 }else {
 //BA.debugLineNum = 841;BA.debugLine="phrase = edtPassphrase.Text.Trim";
_phrase = _edtpassphrase.getText().trim();
 //BA.debugLineNum = 844;BA.debugLine="If isSecure Then";
if (_issecure) { 
 //BA.debugLineNum = 845;BA.debugLine="Dim phraseError As String = ModSecurity.GetPass";
_phraseerror = _modsecurity._getpassphraseerror /*String*/ (ba,_phrase);
 //BA.debugLineNum = 846;BA.debugLine="If phraseError.Length > 0 Then";
if (_phraseerror.length()>0) { 
 //BA.debugLineNum = 847;BA.debugLine="ToastMessageShow(phraseError, True)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_phraseerror),__c.True);
 //BA.debugLineNum = 848;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 852;BA.debugLine="Dim phraseConfirm As String = edtPassphraseConf";
_phraseconfirm = _edtpassphraseconfirm.getText().trim();
 //BA.debugLineNum = 853;BA.debugLine="If phrase <> phraseConfirm Then";
if ((_phrase).equals(_phraseconfirm) == false) { 
 //BA.debugLineNum = 854;BA.debugLine="ToastMessageShow(ModLang.T(\"passphrase_mismatc";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"passphrase_mismatch")),__c.True);
 //BA.debugLineNum = 855;BA.debugLine="Return";
if (true) return "";
 };
 };
 };
 //BA.debugLineNum = 861;BA.debugLine="Dim g As clsNoteGroup";
_g = new com.lockzero.clsnotegroup();
 //BA.debugLineNum = 862;BA.debugLine="g.Initialize";
_g._initialize /*String*/ (ba);
 //BA.debugLineNum = 863;BA.debugLine="g.Name = groupName";
_g._name /*String*/  = _groupname;
 //BA.debugLineNum = 864;BA.debugLine="g.Icon = groupIcon";
_g._icon /*String*/  = _groupicon;
 //BA.debugLineNum = 865;BA.debugLine="g.IsSecure = isSecure";
_g._issecure /*boolean*/  = _issecure;
 //BA.debugLineNum = 868;BA.debugLine="If isSecure Then";
if (_issecure) { 
 //BA.debugLineNum = 869;BA.debugLine="g.SetupSecurity(phrase)";
_g._setupsecurity /*String*/ (_phrase);
 //BA.debugLineNum = 871;BA.debugLine="ModSession.StartSessionWithCategory(phrase, \"not";
_modsession._startsessionwithcategory /*String*/ (ba,_phrase,"notes");
 //BA.debugLineNum = 873;BA.debugLine="ModSecurity.ClearSecureField(edtPassphrase)";
_modsecurity._clearsecurefield /*String*/ (ba,_edtpassphrase);
 //BA.debugLineNum = 874;BA.debugLine="If edtPassphraseConfirm.IsInitialized Then ModSe";
if (_edtpassphraseconfirm.IsInitialized()) { 
_modsecurity._clearsecurefield /*String*/ (ba,_edtpassphraseconfirm);};
 };
 //BA.debugLineNum = 877;BA.debugLine="ModNotes.SaveNoteGroup(g)";
_modnotes._savenotegroup /*String*/ (ba,_g);
 //BA.debugLineNum = 879;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 880;BA.debugLine="LoadGroups";
_loadgroups();
 //BA.debugLineNum = 883;BA.debugLine="NavigateToGroup(g.Id)";
_navigatetogroup(_g._id /*String*/ );
 //BA.debugLineNum = 884;BA.debugLine="End Sub";
return "";
}
public String  _processdeletegroup() throws Exception{
String _phrase = "";
com.lockzero.clsnotegroup _g = null;
 //BA.debugLineNum = 937;BA.debugLine="Private Sub ProcessDeleteGroup";
 //BA.debugLineNum = 938;BA.debugLine="Dim phrase As String = edtPassphrase.Text.Trim";
_phrase = _edtpassphrase.getText().trim();
 //BA.debugLineNum = 939;BA.debugLine="Dim g As clsNoteGroup = ModNotes.GetNoteGroupById";
_g = _modnotes._getnotegroupbyid /*com.lockzero.clsnotegroup*/ (ba,_currentgroupid);
 //BA.debugLineNum = 941;BA.debugLine="If g.IsInitialized = False Then";
if (_g._isinitialized /*boolean*/ ()==__c.False) { 
 //BA.debugLineNum = 942;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 943;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 947;BA.debugLine="If g.ValidatePhrase(phrase) Then";
if (_g._validatephrase /*boolean*/ (_phrase)) { 
 //BA.debugLineNum = 948;BA.debugLine="ModNotes.DeleteNoteGroup(CurrentGroupId)";
_modnotes._deletenotegroup /*String*/ (ba,_currentgroupid);
 //BA.debugLineNum = 949;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 950;BA.debugLine="LoadGroups";
_loadgroups();
 //BA.debugLineNum = 951;BA.debugLine="ToastMessageShow(ModLang.T(\"success\"), False)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"success")),__c.False);
 }else {
 //BA.debugLineNum = 953;BA.debugLine="ToastMessageShow(ModLang.T(\"wrong_passphrase\"),";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"wrong_passphrase")),__c.True);
 //BA.debugLineNum = 954;BA.debugLine="edtPassphrase.Text = \"\"";
_edtpassphrase.setText(BA.ObjectToCharSequence(""));
 };
 //BA.debugLineNum = 956;BA.debugLine="End Sub";
return "";
}
public String  _processeditgroup() throws Exception{
String _groupname = "";
com.lockzero.clsnotegroup _g = null;
 //BA.debugLineNum = 916;BA.debugLine="Private Sub ProcessEditGroup";
 //BA.debugLineNum = 917;BA.debugLine="Dim groupName As String = edtGroupName.Text.Trim";
_groupname = _edtgroupname.getText().trim();
 //BA.debugLineNum = 918;BA.debugLine="Dim g As clsNoteGroup = ModNotes.GetNoteGroupById";
_g = _modnotes._getnotegroupbyid /*com.lockzero.clsnotegroup*/ (ba,_currentgroupid);
 //BA.debugLineNum = 920;BA.debugLine="If g.IsInitialized = False Then";
if (_g._isinitialized /*boolean*/ ()==__c.False) { 
 //BA.debugLineNum = 921;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 922;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 925;BA.debugLine="If groupName.Length > 0 Then";
if (_groupname.length()>0) { 
 //BA.debugLineNum = 926;BA.debugLine="g.Name = groupName";
_g._name /*String*/  = _groupname;
 //BA.debugLineNum = 928;BA.debugLine="ModNotes.SaveNoteGroup(g)";
_modnotes._savenotegroup /*String*/ (ba,_g);
 //BA.debugLineNum = 929;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 930;BA.debugLine="LoadGroups";
_loadgroups();
 //BA.debugLineNum = 931;BA.debugLine="ToastMessageShow(ModLang.T(\"success\"), False)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"success")),__c.False);
 }else {
 //BA.debugLineNum = 933;BA.debugLine="ToastMessageShow(ModLang.T(\"error_empty_field\"),";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error_empty_field")),__c.True);
 };
 //BA.debugLineNum = 935;BA.debugLine="End Sub";
return "";
}
public String  _processunlockgroup() throws Exception{
String _phrase = "";
com.lockzero.clsnotegroup _g = null;
int _delay = 0;
String _timestr = "";
 //BA.debugLineNum = 886;BA.debugLine="Private Sub ProcessUnlockGroup";
 //BA.debugLineNum = 887;BA.debugLine="Dim phrase As String = edtPassphrase.Text.Trim";
_phrase = _edtpassphrase.getText().trim();
 //BA.debugLineNum = 888;BA.debugLine="Dim g As clsNoteGroup = ModNotes.GetNoteGroupById";
_g = _modnotes._getnotegroupbyid /*com.lockzero.clsnotegroup*/ (ba,_currentgroupid);
 //BA.debugLineNum = 890;BA.debugLine="If g.IsInitialized = False Then";
if (_g._isinitialized /*boolean*/ ()==__c.False) { 
 //BA.debugLineNum = 891;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 892;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 896;BA.debugLine="If g.ValidatePhrase(phrase) Then";
if (_g._validatephrase /*boolean*/ (_phrase)) { 
 //BA.debugLineNum = 897;BA.debugLine="ModSecurity.ResetFailedAttempts(CurrentGroupId)";
_modsecurity._resetfailedattempts /*String*/ (ba,_currentgroupid);
 //BA.debugLineNum = 898;BA.debugLine="ModSession.StartSessionWithCategory(phrase, \"not";
_modsession._startsessionwithcategory /*String*/ (ba,_phrase,"notes");
 //BA.debugLineNum = 900;BA.debugLine="ModSecurity.ClearSecureField(edtPassphrase)";
_modsecurity._clearsecurefield /*String*/ (ba,_edtpassphrase);
 //BA.debugLineNum = 901;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 902;BA.debugLine="NavigateToGroup(CurrentGroupId)";
_navigatetogroup(_currentgroupid);
 }else {
 //BA.debugLineNum = 904;BA.debugLine="Dim delay As Int = ModSecurity.RegisterFailedAtt";
_delay = _modsecurity._registerfailedattempt /*int*/ (ba,_currentgroupid);
 //BA.debugLineNum = 905;BA.debugLine="If delay > 0 Then";
if (_delay>0) { 
 //BA.debugLineNum = 906;BA.debugLine="Dim timeStr As String = ModSecurity.FormatDelay";
_timestr = _modsecurity._formatdelay /*String*/ (ba,_delay);
 //BA.debugLineNum = 907;BA.debugLine="ToastMessageShow(ModLang.T(\"wrong_passphrase\")";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"wrong_passphrase")+" - "+_modlang._t /*String*/ (ba,"wait_timeout")+" "+_timestr),__c.True);
 //BA.debugLineNum = 908;BA.debugLine="HideDialog";
_hidedialog();
 }else {
 //BA.debugLineNum = 910;BA.debugLine="ToastMessageShow(ModLang.T(\"wrong_passphrase\"),";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"wrong_passphrase")),__c.True);
 };
 //BA.debugLineNum = 912;BA.debugLine="ModSecurity.ClearSecureField(edtPassphrase)";
_modsecurity._clearsecurefield /*String*/ (ba,_edtpassphrase);
 };
 //BA.debugLineNum = 914;BA.debugLine="End Sub";
return "";
}
public String  _showaddgroupdialog() throws Exception{
boolean _sessionactive = false;
int _dialogw = 0;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
int _top = 0;
anywheresoftware.b4a.objects.LabelWrapper _lblname = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlname = null;
anywheresoftware.b4a.objects.LabelWrapper _lblwarning = null;
anywheresoftware.b4a.objects.LabelWrapper _lblsessioninfo = null;
anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
anywheresoftware.b4a.objects.ButtonWrapper _btnok = null;
 //BA.debugLineNum = 309;BA.debugLine="Private Sub ShowAddGroupDialog";
 //BA.debugLineNum = 310;BA.debugLine="CurrentDialogMode = \"add_group\"";
_currentdialogmode = "add_group";
 //BA.debugLineNum = 311;BA.debugLine="CurrentGroupId = \"\"";
_currentgroupid = "";
 //BA.debugLineNum = 312;BA.debugLine="IsPassVisible = False";
_ispassvisible = __c.False;
 //BA.debugLineNum = 315;BA.debugLine="Dim sessionActive As Boolean = ModSession.IsSessi";
_sessionactive = _modsession._issessionactive /*boolean*/ (ba);
 //BA.debugLineNum = 317;BA.debugLine="Dim dialogW As Int = Root.Width - 40dip";
_dialogw = (int) (_root.getWidth()-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 318;BA.debugLine="pnlDialog.RemoveAllViews";
_pnldialog.RemoveAllViews();
 //BA.debugLineNum = 321;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 322;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 323;BA.debugLine="lblTitle.Text = ModLang.T(\"note_group_new\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"note_group_new")));
 //BA.debugLineNum = 324;BA.debugLine="lblTitle.TextSize = 16";
_lbltitle.setTextSize((float) (16));
 //BA.debugLineNum = 325;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 326;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 327;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 328;BA.debugLine="pnlDialog.AddView(lblTitle, 0, 12dip, dialogW, 24";
_pnldialog.AddView((android.view.View)(_lbltitle.getObject()),(int) (0),__c.DipToCurrent((int) (12)),_dialogw,__c.DipToCurrent((int) (24)));
 //BA.debugLineNum = 330;BA.debugLine="Dim top As Int = 45dip";
_top = __c.DipToCurrent((int) (45));
 //BA.debugLineNum = 333;BA.debugLine="Dim lblName As Label";
_lblname = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 334;BA.debugLine="lblName.Initialize(\"\")";
_lblname.Initialize(ba,"");
 //BA.debugLineNum = 335;BA.debugLine="lblName.Text = ModLang.T(\"note_group_name\")";
_lblname.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"note_group_name")));
 //BA.debugLineNum = 336;BA.debugLine="lblName.TextSize = 12";
_lblname.setTextSize((float) (12));
 //BA.debugLineNum = 337;BA.debugLine="lblName.TextColor = Colors.ARGB(180, 255, 255, 25";
_lblname.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 338;BA.debugLine="pnlDialog.AddView(lblName, 16dip, top, dialogW -";
_pnldialog.AddView((android.view.View)(_lblname.getObject()),__c.DipToCurrent((int) (16)),_top,(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (18)));
 //BA.debugLineNum = 339;BA.debugLine="top = top + 20dip";
_top = (int) (_top+__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 341;BA.debugLine="edtGroupName.Initialize(\"edtGroupName\")";
_edtgroupname.Initialize(ba,"edtGroupName");
 //BA.debugLineNum = 342;BA.debugLine="edtGroupName.Hint = ModLang.T(\"note_group_name\")";
_edtgroupname.setHint(_modlang._t /*String*/ (ba,"note_group_name"));
 //BA.debugLineNum = 343;BA.debugLine="edtGroupName.SingleLine = True";
_edtgroupname.setSingleLine(__c.True);
 //BA.debugLineNum = 344;BA.debugLine="edtGroupName.InputType = Bit.Or(1, 8192)  'TEXT +";
_edtgroupname.setInputType(__c.Bit.Or((int) (1),(int) (8192)));
 //BA.debugLineNum = 345;BA.debugLine="edtGroupName.Text = \"\"";
_edtgroupname.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 346;BA.debugLine="edtGroupName.TextColor = Colors.White";
_edtgroupname.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 347;BA.debugLine="edtGroupName.HintColor = Colors.ARGB(120, 255, 25";
_edtgroupname.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 349;BA.debugLine="Dim pnlName As Panel";
_pnlname = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 350;BA.debugLine="pnlName.Initialize(\"\")";
_pnlname.Initialize(ba,"");
 //BA.debugLineNum = 351;BA.debugLine="pnlName.Color = ModTheme.HomeBg";
_pnlname.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 352;BA.debugLine="pnlDialog.AddView(pnlName, 16dip, top, dialogW -";
_pnldialog.AddView((android.view.View)(_pnlname.getObject()),__c.DipToCurrent((int) (16)),_top,(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 353;BA.debugLine="pnlName.AddView(edtGroupName, 8dip, 0, dialogW -";
_pnlname.AddView((android.view.View)(_edtgroupname.getObject()),__c.DipToCurrent((int) (8)),(int) (0),(int) (_dialogw-__c.DipToCurrent((int) (32))-__c.DipToCurrent((int) (16))),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 354;BA.debugLine="top = top + 50dip";
_top = (int) (_top+__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 357;BA.debugLine="chkSecure.Initialize(\"chkSecure\")";
_chksecure.Initialize(ba,"chkSecure");
 //BA.debugLineNum = 358;BA.debugLine="chkSecure.Text = ModLang.T(\"note_group_secure\")";
_chksecure.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"note_group_secure")));
 //BA.debugLineNum = 359;BA.debugLine="chkSecure.TextSize = 14";
_chksecure.setTextSize((float) (14));
 //BA.debugLineNum = 360;BA.debugLine="chkSecure.TextColor = Colors.White";
_chksecure.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 361;BA.debugLine="chkSecure.Checked = True  'Default: seguro";
_chksecure.setChecked(__c.True);
 //BA.debugLineNum = 362;BA.debugLine="pnlDialog.AddView(chkSecure, 16dip, top, dialogW";
_pnldialog.AddView((android.view.View)(_chksecure.getObject()),__c.DipToCurrent((int) (16)),_top,(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 363;BA.debugLine="top = top + 45dip";
_top = (int) (_top+__c.DipToCurrent((int) (45)));
 //BA.debugLineNum = 366;BA.debugLine="If sessionActive = False Then";
if (_sessionactive==__c.False) { 
 //BA.debugLineNum = 367;BA.debugLine="lblPhraseLabel.Initialize(\"\")";
_lblphraselabel.Initialize(ba,"");
 //BA.debugLineNum = 368;BA.debugLine="lblPhraseLabel.Text = ModLang.T(\"passphrase_hint";
_lblphraselabel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"passphrase_hint")));
 //BA.debugLineNum = 369;BA.debugLine="lblPhraseLabel.TextSize = 12";
_lblphraselabel.setTextSize((float) (12));
 //BA.debugLineNum = 370;BA.debugLine="lblPhraseLabel.TextColor = Colors.ARGB(180, 255,";
_lblphraselabel.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 371;BA.debugLine="pnlDialog.AddView(lblPhraseLabel, 16dip, top, di";
_pnldialog.AddView((android.view.View)(_lblphraselabel.getObject()),__c.DipToCurrent((int) (16)),_top,(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (18)));
 //BA.debugLineNum = 372;BA.debugLine="top = top + 20dip";
_top = (int) (_top+__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 374;BA.debugLine="pnlPhraseArea.Initialize(\"\")";
_pnlphrasearea.Initialize(ba,"");
 //BA.debugLineNum = 375;BA.debugLine="pnlPhraseArea.Color = ModTheme.HomeBg";
_pnlphrasearea.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 376;BA.debugLine="pnlDialog.AddView(pnlPhraseArea, 16dip, top, dia";
_pnldialog.AddView((android.view.View)(_pnlphrasearea.getObject()),__c.DipToCurrent((int) (16)),_top,(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 378;BA.debugLine="edtPassphrase.Initialize(\"edtPassphrase\")";
_edtpassphrase.Initialize(ba,"edtPassphrase");
 //BA.debugLineNum = 379;BA.debugLine="edtPassphrase.Hint = ModLang.T(\"passphrase_hint\"";
_edtpassphrase.setHint(_modlang._t /*String*/ (ba,"passphrase_hint"));
 //BA.debugLineNum = 380;BA.debugLine="edtPassphrase.SingleLine = True";
_edtpassphrase.setSingleLine(__c.True);
 //BA.debugLineNum = 381;BA.debugLine="edtPassphrase.InputType = ModSecurity.GetSecureP";
_edtpassphrase.setInputType(_modsecurity._getsecurepassphraseinputtype /*int*/ (ba));
 //BA.debugLineNum = 382;BA.debugLine="edtPassphrase.Text = \"\"";
_edtpassphrase.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 383;BA.debugLine="edtPassphrase.TextColor = Colors.White";
_edtpassphrase.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 384;BA.debugLine="edtPassphrase.HintColor = Colors.ARGB(120, 255,";
_edtpassphrase.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 385;BA.debugLine="pnlPhraseArea.AddView(edtPassphrase, 8dip, 0, di";
_pnlphrasearea.AddView((android.view.View)(_edtpassphrase.getObject()),__c.DipToCurrent((int) (8)),(int) (0),(int) (_dialogw-__c.DipToCurrent((int) (32))-__c.DipToCurrent((int) (56))),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 387;BA.debugLine="btnShowPass.Initialize(\"btnShowPass\")";
_btnshowpass.Initialize(ba,"btnShowPass");
 //BA.debugLineNum = 388;BA.debugLine="btnShowPass.Text = ModLang.T(\"view\")";
_btnshowpass.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"view")));
 //BA.debugLineNum = 389;BA.debugLine="btnShowPass.TextSize = Starter.FONT_CAPTION";
_btnshowpass.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 390;BA.debugLine="btnShowPass.Color = Colors.Transparent";
_btnshowpass.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 391;BA.debugLine="btnShowPass.TextColor = Colors.ARGB(200, 255, 25";
_btnshowpass.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 392;BA.debugLine="btnShowPass.Gravity = Gravity.CENTER";
_btnshowpass.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 393;BA.debugLine="pnlPhraseArea.AddView(btnShowPass, dialogW - 32d";
_pnlphrasearea.AddView((android.view.View)(_btnshowpass.getObject()),(int) (_dialogw-__c.DipToCurrent((int) (32))-__c.DipToCurrent((int) (65))),__c.DipToCurrent((int) (2)),__c.DipToCurrent((int) (60)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 394;BA.debugLine="top = top + 50dip";
_top = (int) (_top+__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 397;BA.debugLine="lblPhraseConfirmLabel.Initialize(\"\")";
_lblphraseconfirmlabel.Initialize(ba,"");
 //BA.debugLineNum = 398;BA.debugLine="lblPhraseConfirmLabel.Text = ModLang.T(\"passphra";
_lblphraseconfirmlabel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"passphrase_confirm_new")));
 //BA.debugLineNum = 399;BA.debugLine="lblPhraseConfirmLabel.TextSize = 12";
_lblphraseconfirmlabel.setTextSize((float) (12));
 //BA.debugLineNum = 400;BA.debugLine="lblPhraseConfirmLabel.TextColor = Colors.ARGB(18";
_lblphraseconfirmlabel.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 401;BA.debugLine="pnlDialog.AddView(lblPhraseConfirmLabel, 16dip,";
_pnldialog.AddView((android.view.View)(_lblphraseconfirmlabel.getObject()),__c.DipToCurrent((int) (16)),_top,(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (18)));
 //BA.debugLineNum = 402;BA.debugLine="top = top + 20dip";
_top = (int) (_top+__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 404;BA.debugLine="pnlPhraseConfirmArea.Initialize(\"\")";
_pnlphraseconfirmarea.Initialize(ba,"");
 //BA.debugLineNum = 405;BA.debugLine="pnlPhraseConfirmArea.Color = ModTheme.HomeBg";
_pnlphraseconfirmarea.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 406;BA.debugLine="pnlDialog.AddView(pnlPhraseConfirmArea, 16dip, t";
_pnldialog.AddView((android.view.View)(_pnlphraseconfirmarea.getObject()),__c.DipToCurrent((int) (16)),_top,(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 408;BA.debugLine="edtPassphraseConfirm.Initialize(\"edtPassphraseCo";
_edtpassphraseconfirm.Initialize(ba,"edtPassphraseConfirm");
 //BA.debugLineNum = 409;BA.debugLine="edtPassphraseConfirm.Hint = ModLang.T(\"passphras";
_edtpassphraseconfirm.setHint(_modlang._t /*String*/ (ba,"passphrase_confirm_new"));
 //BA.debugLineNum = 410;BA.debugLine="edtPassphraseConfirm.SingleLine = True";
_edtpassphraseconfirm.setSingleLine(__c.True);
 //BA.debugLineNum = 411;BA.debugLine="edtPassphraseConfirm.InputType = ModSecurity.Get";
_edtpassphraseconfirm.setInputType(_modsecurity._getsecurepassphraseinputtype /*int*/ (ba));
 //BA.debugLineNum = 412;BA.debugLine="edtPassphraseConfirm.Text = \"\"";
_edtpassphraseconfirm.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 413;BA.debugLine="edtPassphraseConfirm.TextColor = Colors.White";
_edtpassphraseconfirm.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 414;BA.debugLine="edtPassphraseConfirm.HintColor = Colors.ARGB(120";
_edtpassphraseconfirm.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 415;BA.debugLine="pnlPhraseConfirmArea.AddView(edtPassphraseConfir";
_pnlphraseconfirmarea.AddView((android.view.View)(_edtpassphraseconfirm.getObject()),__c.DipToCurrent((int) (8)),(int) (0),(int) (_dialogw-__c.DipToCurrent((int) (32))-__c.DipToCurrent((int) (16))),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 416;BA.debugLine="top = top + 55dip";
_top = (int) (_top+__c.DipToCurrent((int) (55)));
 //BA.debugLineNum = 419;BA.debugLine="If ModSecurity.GetUseSinglePassphrase Then";
if (_modsecurity._getusesinglepassphrase /*boolean*/ (ba)) { 
 //BA.debugLineNum = 420;BA.debugLine="Dim lblWarning As Label";
_lblwarning = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 421;BA.debugLine="lblWarning.Initialize(\"\")";
_lblwarning.Initialize(ba,"");
 //BA.debugLineNum = 422;BA.debugLine="lblWarning.Text = \"⚠ \" & ModLang.T(\"single_pass";
_lblwarning.setText(BA.ObjectToCharSequence("⚠ "+_modlang._t /*String*/ (ba,"single_passphrase_warning")));
 //BA.debugLineNum = 423;BA.debugLine="lblWarning.TextSize = 10";
_lblwarning.setTextSize((float) (10));
 //BA.debugLineNum = 424;BA.debugLine="lblWarning.TextColor = ModTheme.Warning";
_lblwarning.setTextColor(_modtheme._warning /*int*/ (ba));
 //BA.debugLineNum = 425;BA.debugLine="pnlDialog.AddView(lblWarning, 16dip, top, dialo";
_pnldialog.AddView((android.view.View)(_lblwarning.getObject()),__c.DipToCurrent((int) (16)),_top,(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (35)));
 //BA.debugLineNum = 426;BA.debugLine="top = top + 40dip";
_top = (int) (_top+__c.DipToCurrent((int) (40)));
 };
 }else {
 //BA.debugLineNum = 430;BA.debugLine="Dim lblSessionInfo As Label";
_lblsessioninfo = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 431;BA.debugLine="lblSessionInfo.Initialize(\"\")";
_lblsessioninfo.Initialize(ba,"");
 //BA.debugLineNum = 432;BA.debugLine="lblSessionInfo.Text = \"🔓 \" & ModLang.T(\"session";
_lblsessioninfo.setText(BA.ObjectToCharSequence("🔓 "+_modlang._t /*String*/ (ba,"session_active")));
 //BA.debugLineNum = 433;BA.debugLine="lblSessionInfo.TextSize = 12";
_lblsessioninfo.setTextSize((float) (12));
 //BA.debugLineNum = 434;BA.debugLine="lblSessionInfo.TextColor = Colors.RGB(0, 220, 25";
_lblsessioninfo.setTextColor(__c.Colors.RGB((int) (0),(int) (220),(int) (255)));
 //BA.debugLineNum = 435;BA.debugLine="lblSessionInfo.Gravity = Gravity.CENTER_HORIZONT";
_lblsessioninfo.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 436;BA.debugLine="pnlDialog.AddView(lblSessionInfo, 16dip, top, di";
_pnldialog.AddView((android.view.View)(_lblsessioninfo.getObject()),__c.DipToCurrent((int) (16)),_top,(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (24)));
 //BA.debugLineNum = 437;BA.debugLine="top = top + 30dip";
_top = (int) (_top+__c.DipToCurrent((int) (30)));
 };
 //BA.debugLineNum = 441;BA.debugLine="Dim btnCancel As Button";
_btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 442;BA.debugLine="btnCancel.Initialize(\"btnDialogCancel\")";
_btncancel.Initialize(ba,"btnDialogCancel");
 //BA.debugLineNum = 443;BA.debugLine="btnCancel.Text = ModLang.T(\"cancel\")";
_btncancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 444;BA.debugLine="btnCancel.TextSize = 13";
_btncancel.setTextSize((float) (13));
 //BA.debugLineNum = 445;BA.debugLine="btnCancel.Color = Colors.Transparent";
_btncancel.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 446;BA.debugLine="btnCancel.TextColor = Colors.ARGB(200, 255, 255,";
_btncancel.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 447;BA.debugLine="pnlDialog.AddView(btnCancel, 16dip, top, 100dip,";
_pnldialog.AddView((android.view.View)(_btncancel.getObject()),__c.DipToCurrent((int) (16)),_top,__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 449;BA.debugLine="Dim btnOk As Button";
_btnok = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 450;BA.debugLine="btnOk.Initialize(\"btnDialogOk\")";
_btnok.Initialize(ba,"btnDialogOk");
 //BA.debugLineNum = 451;BA.debugLine="btnOk.Text = ModLang.T(\"save\")";
_btnok.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"save")));
 //BA.debugLineNum = 452;BA.debugLine="btnOk.TextSize = 13";
_btnok.setTextSize((float) (13));
 //BA.debugLineNum = 453;BA.debugLine="btnOk.Color = ModTheme.HomeIconBg";
_btnok.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 454;BA.debugLine="btnOk.TextColor = Colors.White";
_btnok.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 455;BA.debugLine="pnlDialog.AddView(btnOk, dialogW - 116dip, top, 1";
_pnldialog.AddView((android.view.View)(_btnok.getObject()),(int) (_dialogw-__c.DipToCurrent((int) (116))),_top,__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 456;BA.debugLine="top = top + 50dip";
_top = (int) (_top+__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 459;BA.debugLine="pnlDialog.SetLayoutAnimated(0, 20dip, 40dip, dial";
_pnldialog.SetLayoutAnimated((int) (0),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (40)),_dialogw,_top);
 //BA.debugLineNum = 461;BA.debugLine="pnlOverlay.Visible = True";
_pnloverlay.setVisible(__c.True);
 //BA.debugLineNum = 462;BA.debugLine="pnlOverlay.BringToFront";
_pnloverlay.BringToFront();
 //BA.debugLineNum = 463;BA.debugLine="edtGroupName.RequestFocus";
_edtgroupname.RequestFocus();
 //BA.debugLineNum = 464;BA.debugLine="End Sub";
return "";
}
public String  _showdeletegroupdialog(String _groupid) throws Exception{
com.lockzero.clsnotegroup _g = null;
int _dialogw = 0;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
anywheresoftware.b4a.objects.LabelWrapper _lblsub = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlinput = null;
anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
anywheresoftware.b4a.objects.ButtonWrapper _btnok = null;
 //BA.debugLineNum = 697;BA.debugLine="Private Sub ShowDeleteGroupDialog(groupId As Strin";
 //BA.debugLineNum = 698;BA.debugLine="Dim g As clsNoteGroup = ModNotes.GetNoteGroupById";
_g = _modnotes._getnotegroupbyid /*com.lockzero.clsnotegroup*/ (ba,_groupid);
 //BA.debugLineNum = 699;BA.debugLine="If g.IsInitialized = False Then Return";
if (_g._isinitialized /*boolean*/ ()==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 701;BA.debugLine="CurrentDialogMode = \"delete_group\"";
_currentdialogmode = "delete_group";
 //BA.debugLineNum = 702;BA.debugLine="CurrentGroupId = groupId";
_currentgroupid = _groupid;
 //BA.debugLineNum = 703;BA.debugLine="IsPassVisible = False";
_ispassvisible = __c.False;
 //BA.debugLineNum = 705;BA.debugLine="Dim dialogW As Int = Root.Width - 40dip";
_dialogw = (int) (_root.getWidth()-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 706;BA.debugLine="pnlDialog.RemoveAllViews";
_pnldialog.RemoveAllViews();
 //BA.debugLineNum = 709;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 710;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 711;BA.debugLine="lblTitle.Text = ModLang.T(\"confirm_delete\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"confirm_delete")));
 //BA.debugLineNum = 712;BA.debugLine="lblTitle.TextSize = 16";
_lbltitle.setTextSize((float) (16));
 //BA.debugLineNum = 713;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 714;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 715;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 716;BA.debugLine="pnlDialog.AddView(lblTitle, 0, 12dip, dialogW, 24";
_pnldialog.AddView((android.view.View)(_lbltitle.getObject()),(int) (0),__c.DipToCurrent((int) (12)),_dialogw,__c.DipToCurrent((int) (24)));
 //BA.debugLineNum = 719;BA.debugLine="Dim lblSub As Label";
_lblsub = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 720;BA.debugLine="lblSub.Initialize(\"\")";
_lblsub.Initialize(ba,"");
 //BA.debugLineNum = 721;BA.debugLine="lblSub.Text = g.Name & CRLF & ModLang.T(\"enter_pa";
_lblsub.setText(BA.ObjectToCharSequence(_g._name /*String*/ +__c.CRLF+_modlang._t /*String*/ (ba,"enter_passphrase")));
 //BA.debugLineNum = 722;BA.debugLine="lblSub.TextSize = 12";
_lblsub.setTextSize((float) (12));
 //BA.debugLineNum = 723;BA.debugLine="lblSub.TextColor = Colors.ARGB(180, 255, 255, 255";
_lblsub.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 724;BA.debugLine="lblSub.Gravity = Gravity.CENTER_HORIZONTAL";
_lblsub.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 725;BA.debugLine="pnlDialog.AddView(lblSub, 0, 36dip, dialogW, 40di";
_pnldialog.AddView((android.view.View)(_lblsub.getObject()),(int) (0),__c.DipToCurrent((int) (36)),_dialogw,__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 728;BA.debugLine="Dim pnlInput As Panel";
_pnlinput = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 729;BA.debugLine="pnlInput.Initialize(\"\")";
_pnlinput.Initialize(ba,"");
 //BA.debugLineNum = 730;BA.debugLine="pnlInput.Color = ModTheme.HomeBg";
_pnlinput.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 731;BA.debugLine="pnlDialog.AddView(pnlInput, 16dip, 85dip, dialogW";
_pnldialog.AddView((android.view.View)(_pnlinput.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (85)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 733;BA.debugLine="edtPassphrase.Initialize(\"edtPassphrase\")";
_edtpassphrase.Initialize(ba,"edtPassphrase");
 //BA.debugLineNum = 734;BA.debugLine="edtPassphrase.Hint = ModLang.T(\"passphrase_hint\")";
_edtpassphrase.setHint(_modlang._t /*String*/ (ba,"passphrase_hint"));
 //BA.debugLineNum = 735;BA.debugLine="edtPassphrase.SingleLine = True";
_edtpassphrase.setSingleLine(__c.True);
 //BA.debugLineNum = 736;BA.debugLine="edtPassphrase.InputType = ModSecurity.GetSecurePa";
_edtpassphrase.setInputType(_modsecurity._getsecurepassphraseinputtype /*int*/ (ba));
 //BA.debugLineNum = 737;BA.debugLine="edtPassphrase.Text = \"\"";
_edtpassphrase.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 738;BA.debugLine="edtPassphrase.TextColor = Colors.White";
_edtpassphrase.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 739;BA.debugLine="edtPassphrase.HintColor = Colors.ARGB(120, 255, 2";
_edtpassphrase.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 740;BA.debugLine="pnlInput.AddView(edtPassphrase, 8dip, 0, dialogW";
_pnlinput.AddView((android.view.View)(_edtpassphrase.getObject()),__c.DipToCurrent((int) (8)),(int) (0),(int) (_dialogw-__c.DipToCurrent((int) (32))-__c.DipToCurrent((int) (56))),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 742;BA.debugLine="btnShowPass.Initialize(\"btnShowPass\")";
_btnshowpass.Initialize(ba,"btnShowPass");
 //BA.debugLineNum = 743;BA.debugLine="btnShowPass.Text = ModLang.T(\"view\")";
_btnshowpass.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"view")));
 //BA.debugLineNum = 744;BA.debugLine="btnShowPass.TextSize = Starter.FONT_CAPTION";
_btnshowpass.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 745;BA.debugLine="btnShowPass.Color = Colors.Transparent";
_btnshowpass.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 746;BA.debugLine="btnShowPass.TextColor = Colors.ARGB(200, 255, 255";
_btnshowpass.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 747;BA.debugLine="btnShowPass.Gravity = Gravity.CENTER";
_btnshowpass.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 748;BA.debugLine="pnlInput.AddView(btnShowPass, dialogW - 32dip - 6";
_pnlinput.AddView((android.view.View)(_btnshowpass.getObject()),(int) (_dialogw-__c.DipToCurrent((int) (32))-__c.DipToCurrent((int) (65))),__c.DipToCurrent((int) (5)),__c.DipToCurrent((int) (60)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 751;BA.debugLine="Dim btnCancel As Button";
_btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 752;BA.debugLine="btnCancel.Initialize(\"btnDialogCancel\")";
_btncancel.Initialize(ba,"btnDialogCancel");
 //BA.debugLineNum = 753;BA.debugLine="btnCancel.Text = ModLang.T(\"cancel\")";
_btncancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 754;BA.debugLine="btnCancel.TextSize = 13";
_btncancel.setTextSize((float) (13));
 //BA.debugLineNum = 755;BA.debugLine="btnCancel.Color = Colors.Transparent";
_btncancel.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 756;BA.debugLine="btnCancel.TextColor = Colors.ARGB(200, 255, 255,";
_btncancel.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 757;BA.debugLine="pnlDialog.AddView(btnCancel, 16dip, 150dip, 100di";
_pnldialog.AddView((android.view.View)(_btncancel.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (150)),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 759;BA.debugLine="Dim btnOk As Button";
_btnok = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 760;BA.debugLine="btnOk.Initialize(\"btnDialogOk\")";
_btnok.Initialize(ba,"btnDialogOk");
 //BA.debugLineNum = 761;BA.debugLine="btnOk.Text = ModLang.T(\"delete\")";
_btnok.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"delete")));
 //BA.debugLineNum = 762;BA.debugLine="btnOk.TextSize = 12";
_btnok.setTextSize((float) (12));
 //BA.debugLineNum = 763;BA.debugLine="btnOk.Color = ModTheme.Danger";
_btnok.setColor(_modtheme._danger /*int*/ (ba));
 //BA.debugLineNum = 764;BA.debugLine="btnOk.TextColor = Colors.White";
_btnok.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 765;BA.debugLine="pnlDialog.AddView(btnOk, dialogW - 130dip, 150dip";
_pnldialog.AddView((android.view.View)(_btnok.getObject()),(int) (_dialogw-__c.DipToCurrent((int) (130))),__c.DipToCurrent((int) (150)),__c.DipToCurrent((int) (114)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 767;BA.debugLine="pnlDialog.SetLayoutAnimated(0, 20dip, 80dip, dial";
_pnldialog.SetLayoutAnimated((int) (0),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (80)),_dialogw,__c.DipToCurrent((int) (200)));
 //BA.debugLineNum = 769;BA.debugLine="pnlOverlay.Visible = True";
_pnloverlay.setVisible(__c.True);
 //BA.debugLineNum = 770;BA.debugLine="pnlOverlay.BringToFront";
_pnloverlay.BringToFront();
 //BA.debugLineNum = 771;BA.debugLine="edtPassphrase.RequestFocus";
_edtpassphrase.RequestFocus();
 //BA.debugLineNum = 772;BA.debugLine="End Sub";
return "";
}
public String  _showeditgroupdialog(String _groupid) throws Exception{
com.lockzero.clsnotegroup _g = null;
int _dialogw = 0;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
int _top = 0;
anywheresoftware.b4a.objects.LabelWrapper _lblname = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlname = null;
anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
anywheresoftware.b4a.objects.ButtonWrapper _btnok = null;
 //BA.debugLineNum = 588;BA.debugLine="Private Sub ShowEditGroupDialog(groupId As String)";
 //BA.debugLineNum = 589;BA.debugLine="Dim g As clsNoteGroup = ModNotes.GetNoteGroupById";
_g = _modnotes._getnotegroupbyid /*com.lockzero.clsnotegroup*/ (ba,_groupid);
 //BA.debugLineNum = 590;BA.debugLine="If g.IsInitialized = False Then Return";
if (_g._isinitialized /*boolean*/ ()==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 592;BA.debugLine="CurrentDialogMode = \"edit_group\"";
_currentdialogmode = "edit_group";
 //BA.debugLineNum = 593;BA.debugLine="CurrentGroupId = groupId";
_currentgroupid = _groupid;
 //BA.debugLineNum = 595;BA.debugLine="Dim dialogW As Int = Root.Width - 40dip";
_dialogw = (int) (_root.getWidth()-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 596;BA.debugLine="pnlDialog.RemoveAllViews";
_pnldialog.RemoveAllViews();
 //BA.debugLineNum = 599;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 600;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 601;BA.debugLine="lblTitle.Text = ModLang.T(\"edit_group\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"edit_group")));
 //BA.debugLineNum = 602;BA.debugLine="lblTitle.TextSize = 16";
_lbltitle.setTextSize((float) (16));
 //BA.debugLineNum = 603;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 604;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 605;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 606;BA.debugLine="pnlDialog.AddView(lblTitle, 0, 12dip, dialogW, 24";
_pnldialog.AddView((android.view.View)(_lbltitle.getObject()),(int) (0),__c.DipToCurrent((int) (12)),_dialogw,__c.DipToCurrent((int) (24)));
 //BA.debugLineNum = 608;BA.debugLine="Dim top As Int = 45dip";
_top = __c.DipToCurrent((int) (45));
 //BA.debugLineNum = 611;BA.debugLine="Dim lblName As Label";
_lblname = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 612;BA.debugLine="lblName.Initialize(\"\")";
_lblname.Initialize(ba,"");
 //BA.debugLineNum = 613;BA.debugLine="lblName.Text = ModLang.T(\"note_group_name\")";
_lblname.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"note_group_name")));
 //BA.debugLineNum = 614;BA.debugLine="lblName.TextSize = 12";
_lblname.setTextSize((float) (12));
 //BA.debugLineNum = 615;BA.debugLine="lblName.TextColor = Colors.ARGB(180, 255, 255, 25";
_lblname.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 616;BA.debugLine="pnlDialog.AddView(lblName, 16dip, top, dialogW -";
_pnldialog.AddView((android.view.View)(_lblname.getObject()),__c.DipToCurrent((int) (16)),_top,(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (18)));
 //BA.debugLineNum = 617;BA.debugLine="top = top + 20dip";
_top = (int) (_top+__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 619;BA.debugLine="Dim pnlName As Panel";
_pnlname = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 620;BA.debugLine="pnlName.Initialize(\"\")";
_pnlname.Initialize(ba,"");
 //BA.debugLineNum = 621;BA.debugLine="pnlName.Color = ModTheme.HomeBg";
_pnlname.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 622;BA.debugLine="pnlDialog.AddView(pnlName, 16dip, top, dialogW -";
_pnldialog.AddView((android.view.View)(_pnlname.getObject()),__c.DipToCurrent((int) (16)),_top,(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 624;BA.debugLine="edtGroupName.Initialize(\"edtGroupName\")";
_edtgroupname.Initialize(ba,"edtGroupName");
 //BA.debugLineNum = 625;BA.debugLine="edtGroupName.Text = g.Name";
_edtgroupname.setText(BA.ObjectToCharSequence(_g._name /*String*/ ));
 //BA.debugLineNum = 626;BA.debugLine="edtGroupName.SingleLine = True";
_edtgroupname.setSingleLine(__c.True);
 //BA.debugLineNum = 627;BA.debugLine="edtGroupName.InputType = Bit.Or(1, 8192)  'TEXT +";
_edtgroupname.setInputType(__c.Bit.Or((int) (1),(int) (8192)));
 //BA.debugLineNum = 628;BA.debugLine="edtGroupName.TextColor = Colors.White";
_edtgroupname.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 629;BA.debugLine="edtGroupName.HintColor = Colors.ARGB(120, 255, 25";
_edtgroupname.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 630;BA.debugLine="pnlName.AddView(edtGroupName, 8dip, 0, dialogW -";
_pnlname.AddView((android.view.View)(_edtgroupname.getObject()),__c.DipToCurrent((int) (8)),(int) (0),(int) (_dialogw-__c.DipToCurrent((int) (32))-__c.DipToCurrent((int) (16))),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 631;BA.debugLine="top = top + 50dip";
_top = (int) (_top+__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 634;BA.debugLine="Dim btnCancel As Button";
_btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 635;BA.debugLine="btnCancel.Initialize(\"btnDialogCancel\")";
_btncancel.Initialize(ba,"btnDialogCancel");
 //BA.debugLineNum = 636;BA.debugLine="btnCancel.Text = ModLang.T(\"cancel\")";
_btncancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 637;BA.debugLine="btnCancel.TextSize = 13";
_btncancel.setTextSize((float) (13));
 //BA.debugLineNum = 638;BA.debugLine="btnCancel.Color = Colors.Transparent";
_btncancel.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 639;BA.debugLine="btnCancel.TextColor = Colors.ARGB(200, 255, 255,";
_btncancel.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 640;BA.debugLine="pnlDialog.AddView(btnCancel, 16dip, top, 100dip,";
_pnldialog.AddView((android.view.View)(_btncancel.getObject()),__c.DipToCurrent((int) (16)),_top,__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 642;BA.debugLine="Dim btnOk As Button";
_btnok = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 643;BA.debugLine="btnOk.Initialize(\"btnDialogOk\")";
_btnok.Initialize(ba,"btnDialogOk");
 //BA.debugLineNum = 644;BA.debugLine="btnOk.Text = ModLang.T(\"save\")";
_btnok.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"save")));
 //BA.debugLineNum = 645;BA.debugLine="btnOk.TextSize = 13";
_btnok.setTextSize((float) (13));
 //BA.debugLineNum = 646;BA.debugLine="btnOk.Color = ModTheme.HomeIconBg";
_btnok.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 647;BA.debugLine="btnOk.TextColor = Colors.White";
_btnok.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 648;BA.debugLine="pnlDialog.AddView(btnOk, dialogW - 116dip, top, 1";
_pnldialog.AddView((android.view.View)(_btnok.getObject()),(int) (_dialogw-__c.DipToCurrent((int) (116))),_top,__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 649;BA.debugLine="top = top + 50dip";
_top = (int) (_top+__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 651;BA.debugLine="pnlDialog.SetLayoutAnimated(0, 20dip, 80dip, dial";
_pnldialog.SetLayoutAnimated((int) (0),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (80)),_dialogw,_top);
 //BA.debugLineNum = 653;BA.debugLine="pnlOverlay.Visible = True";
_pnloverlay.setVisible(__c.True);
 //BA.debugLineNum = 654;BA.debugLine="pnlOverlay.BringToFront";
_pnloverlay.BringToFront();
 //BA.debugLineNum = 655;BA.debugLine="edtGroupName.RequestFocus";
_edtgroupname.RequestFocus();
 //BA.debugLineNum = 656;BA.debugLine="End Sub";
return "";
}
public void  _showgroupoptions(String _groupid) throws Exception{
ResumableSub_ShowGroupOptions rsub = new ResumableSub_ShowGroupOptions(this,_groupid);
rsub.resume(ba, null);
}
public static class ResumableSub_ShowGroupOptions extends BA.ResumableSub {
public ResumableSub_ShowGroupOptions(com.lockzero.pagenotesgroups parent,String _groupid) {
this.parent = parent;
this._groupid = _groupid;
}
com.lockzero.pagenotesgroups parent;
String _groupid;
com.lockzero.clsnotegroup _g = null;
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
 //BA.debugLineNum = 576;BA.debugLine="Dim g As clsNoteGroup = ModNotes.GetNoteGroupById";
_g = parent._modnotes._getnotegroupbyid /*com.lockzero.clsnotegroup*/ (ba,_groupid);
 //BA.debugLineNum = 577;BA.debugLine="If g.IsInitialized = False Then Return";
if (true) break;

case 1:
//if
this.state = 6;
if (_g._isinitialized /*boolean*/ ()==parent.__c.False) { 
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
 //BA.debugLineNum = 579;BA.debugLine="Wait For (xui.Msgbox2Async(g.Name, \"\", ModLang.T(";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(_g._name /*String*/ ),BA.ObjectToCharSequence(""),parent._modlang._t /*String*/ (ba,"edit"),parent._modlang._t /*String*/ (ba,"cancel"),parent._modlang._t /*String*/ (ba,"delete"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 13;
return;
case 13:
//C
this.state = 7;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 581;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
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
 //BA.debugLineNum = 582;BA.debugLine="ShowEditGroupDialog(groupId)";
parent._showeditgroupdialog(_groupid);
 if (true) break;

case 11:
//C
this.state = 12;
 //BA.debugLineNum = 584;BA.debugLine="ConfirmDeleteGroup(groupId)";
parent._confirmdeletegroup(_groupid);
 if (true) break;

case 12:
//C
this.state = -1;
;
 //BA.debugLineNum = 586;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _showunlockgroupdialog(String _groupid) throws Exception{
com.lockzero.clsnotegroup _g = null;
int _remainingdelay = 0;
int _attempts = 0;
String _timestr = "";
int _dialogw = 0;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
anywheresoftware.b4a.objects.LabelWrapper _lblsub = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlinput = null;
anywheresoftware.b4a.objects.LabelWrapper _lblwarn = null;
anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
anywheresoftware.b4a.objects.ButtonWrapper _btnok = null;
 //BA.debugLineNum = 477;BA.debugLine="Private Sub ShowUnlockGroupDialog(groupId As Strin";
 //BA.debugLineNum = 478;BA.debugLine="Dim g As clsNoteGroup = ModNotes.GetNoteGroupById";
_g = _modnotes._getnotegroupbyid /*com.lockzero.clsnotegroup*/ (ba,_groupid);
 //BA.debugLineNum = 479;BA.debugLine="If g.IsInitialized = False Then Return";
if (_g._isinitialized /*boolean*/ ()==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 482;BA.debugLine="Dim remainingDelay As Int = ModSecurity.GetRemain";
_remainingdelay = _modsecurity._getremainingdelay /*int*/ (ba,_groupid);
 //BA.debugLineNum = 483;BA.debugLine="If remainingDelay > 0 Then";
if (_remainingdelay>0) { 
 //BA.debugLineNum = 484;BA.debugLine="Dim attempts As Int = ModSecurity.GetFailedAttem";
_attempts = _modsecurity._getfailedattempts /*int*/ (ba,_groupid);
 //BA.debugLineNum = 485;BA.debugLine="Dim timeStr As String = ModSecurity.FormatDelay(";
_timestr = _modsecurity._formatdelay /*String*/ (ba,_remainingdelay);
 //BA.debugLineNum = 486;BA.debugLine="ToastMessageShow(ModLang.T(\"wait_timeout\") & \" \"";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"wait_timeout")+" "+_timestr),__c.True);
 //BA.debugLineNum = 487;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 490;BA.debugLine="CurrentDialogMode = \"unlock_group\"";
_currentdialogmode = "unlock_group";
 //BA.debugLineNum = 491;BA.debugLine="CurrentGroupId = groupId";
_currentgroupid = _groupid;
 //BA.debugLineNum = 492;BA.debugLine="IsPassVisible = False";
_ispassvisible = __c.False;
 //BA.debugLineNum = 494;BA.debugLine="Dim dialogW As Int = Root.Width - 40dip";
_dialogw = (int) (_root.getWidth()-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 495;BA.debugLine="pnlDialog.RemoveAllViews";
_pnldialog.RemoveAllViews();
 //BA.debugLineNum = 498;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 499;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 500;BA.debugLine="lblTitle.Text = g.Icon & \" \" & g.Name";
_lbltitle.setText(BA.ObjectToCharSequence(_g._icon /*String*/ +" "+_g._name /*String*/ ));
 //BA.debugLineNum = 501;BA.debugLine="lblTitle.TextSize = 16";
_lbltitle.setTextSize((float) (16));
 //BA.debugLineNum = 502;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 503;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 504;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 505;BA.debugLine="pnlDialog.AddView(lblTitle, 0, 12dip, dialogW, 24";
_pnldialog.AddView((android.view.View)(_lbltitle.getObject()),(int) (0),__c.DipToCurrent((int) (12)),_dialogw,__c.DipToCurrent((int) (24)));
 //BA.debugLineNum = 508;BA.debugLine="Dim lblSub As Label";
_lblsub = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 509;BA.debugLine="lblSub.Initialize(\"\")";
_lblsub.Initialize(ba,"");
 //BA.debugLineNum = 510;BA.debugLine="lblSub.Text = ModLang.T(\"enter_passphrase\")";
_lblsub.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"enter_passphrase")));
 //BA.debugLineNum = 511;BA.debugLine="lblSub.TextSize = 12";
_lblsub.setTextSize((float) (12));
 //BA.debugLineNum = 512;BA.debugLine="lblSub.TextColor = Colors.ARGB(180, 255, 255, 255";
_lblsub.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 513;BA.debugLine="lblSub.Gravity = Gravity.CENTER_HORIZONTAL";
_lblsub.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 514;BA.debugLine="pnlDialog.AddView(lblSub, 0, 36dip, dialogW, 20di";
_pnldialog.AddView((android.view.View)(_lblsub.getObject()),(int) (0),__c.DipToCurrent((int) (36)),_dialogw,__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 517;BA.debugLine="Dim pnlInput As Panel";
_pnlinput = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 518;BA.debugLine="pnlInput.Initialize(\"\")";
_pnlinput.Initialize(ba,"");
 //BA.debugLineNum = 519;BA.debugLine="pnlInput.Color = ModTheme.HomeBg";
_pnlinput.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 520;BA.debugLine="pnlDialog.AddView(pnlInput, 16dip, 65dip, dialogW";
_pnldialog.AddView((android.view.View)(_pnlinput.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (65)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 522;BA.debugLine="edtPassphrase.Initialize(\"edtPassphrase\")";
_edtpassphrase.Initialize(ba,"edtPassphrase");
 //BA.debugLineNum = 523;BA.debugLine="edtPassphrase.Hint = ModLang.T(\"passphrase_hint\")";
_edtpassphrase.setHint(_modlang._t /*String*/ (ba,"passphrase_hint"));
 //BA.debugLineNum = 524;BA.debugLine="edtPassphrase.SingleLine = True";
_edtpassphrase.setSingleLine(__c.True);
 //BA.debugLineNum = 525;BA.debugLine="edtPassphrase.InputType = ModSecurity.GetSecurePa";
_edtpassphrase.setInputType(_modsecurity._getsecurepassphraseinputtype /*int*/ (ba));
 //BA.debugLineNum = 526;BA.debugLine="edtPassphrase.Text = \"\"";
_edtpassphrase.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 527;BA.debugLine="edtPassphrase.TextColor = Colors.White";
_edtpassphrase.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 528;BA.debugLine="edtPassphrase.HintColor = Colors.ARGB(120, 255, 2";
_edtpassphrase.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 529;BA.debugLine="pnlInput.AddView(edtPassphrase, 8dip, 0, dialogW";
_pnlinput.AddView((android.view.View)(_edtpassphrase.getObject()),__c.DipToCurrent((int) (8)),(int) (0),(int) (_dialogw-__c.DipToCurrent((int) (32))-__c.DipToCurrent((int) (56))),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 531;BA.debugLine="btnShowPass.Initialize(\"btnShowPass\")";
_btnshowpass.Initialize(ba,"btnShowPass");
 //BA.debugLineNum = 532;BA.debugLine="btnShowPass.Text = ModLang.T(\"view\")";
_btnshowpass.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"view")));
 //BA.debugLineNum = 533;BA.debugLine="btnShowPass.TextSize = Starter.FONT_CAPTION";
_btnshowpass.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 534;BA.debugLine="btnShowPass.Color = Colors.Transparent";
_btnshowpass.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 535;BA.debugLine="btnShowPass.TextColor = Colors.ARGB(200, 255, 255";
_btnshowpass.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 536;BA.debugLine="btnShowPass.Gravity = Gravity.CENTER";
_btnshowpass.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 537;BA.debugLine="pnlInput.AddView(btnShowPass, dialogW - 32dip - 6";
_pnlinput.AddView((android.view.View)(_btnshowpass.getObject()),(int) (_dialogw-__c.DipToCurrent((int) (32))-__c.DipToCurrent((int) (65))),__c.DipToCurrent((int) (5)),__c.DipToCurrent((int) (60)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 540;BA.debugLine="Dim attempts As Int = ModSecurity.GetFailedAttemp";
_attempts = _modsecurity._getfailedattempts /*int*/ (ba,_groupid);
 //BA.debugLineNum = 541;BA.debugLine="If attempts > 0 Then";
if (_attempts>0) { 
 //BA.debugLineNum = 542;BA.debugLine="Dim lblWarn As Label";
_lblwarn = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 543;BA.debugLine="lblWarn.Initialize(\"\")";
_lblwarn.Initialize(ba,"");
 //BA.debugLineNum = 544;BA.debugLine="lblWarn.Text = attempts & \" \" & ModLang.T(\"faile";
_lblwarn.setText(BA.ObjectToCharSequence(BA.NumberToString(_attempts)+" "+_modlang._t /*String*/ (ba,"failed_attempts")));
 //BA.debugLineNum = 545;BA.debugLine="lblWarn.TextSize = 11";
_lblwarn.setTextSize((float) (11));
 //BA.debugLineNum = 546;BA.debugLine="lblWarn.TextColor = ModTheme.Warning";
_lblwarn.setTextColor(_modtheme._warning /*int*/ (ba));
 //BA.debugLineNum = 547;BA.debugLine="lblWarn.Gravity = Gravity.CENTER_HORIZONTAL";
_lblwarn.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 548;BA.debugLine="pnlDialog.AddView(lblWarn, 0, 120dip, dialogW, 1";
_pnldialog.AddView((android.view.View)(_lblwarn.getObject()),(int) (0),__c.DipToCurrent((int) (120)),_dialogw,__c.DipToCurrent((int) (18)));
 };
 //BA.debugLineNum = 552;BA.debugLine="Dim btnCancel As Button";
_btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 553;BA.debugLine="btnCancel.Initialize(\"btnDialogCancel\")";
_btncancel.Initialize(ba,"btnDialogCancel");
 //BA.debugLineNum = 554;BA.debugLine="btnCancel.Text = ModLang.T(\"cancel\")";
_btncancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 555;BA.debugLine="btnCancel.TextSize = 13";
_btncancel.setTextSize((float) (13));
 //BA.debugLineNum = 556;BA.debugLine="btnCancel.Color = Colors.Transparent";
_btncancel.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 557;BA.debugLine="btnCancel.TextColor = Colors.ARGB(200, 255, 255,";
_btncancel.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 558;BA.debugLine="pnlDialog.AddView(btnCancel, 16dip, 145dip, 100di";
_pnldialog.AddView((android.view.View)(_btncancel.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (145)),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 560;BA.debugLine="Dim btnOk As Button";
_btnok = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 561;BA.debugLine="btnOk.Initialize(\"btnDialogOk\")";
_btnok.Initialize(ba,"btnDialogOk");
 //BA.debugLineNum = 562;BA.debugLine="btnOk.Text = ModLang.T(\"unlock\")";
_btnok.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"unlock")));
 //BA.debugLineNum = 563;BA.debugLine="btnOk.TextSize = 12";
_btnok.setTextSize((float) (12));
 //BA.debugLineNum = 564;BA.debugLine="btnOk.Color = ModTheme.HomeIconBg";
_btnok.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 565;BA.debugLine="btnOk.TextColor = Colors.White";
_btnok.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 566;BA.debugLine="pnlDialog.AddView(btnOk, dialogW - 130dip, 145dip";
_pnldialog.AddView((android.view.View)(_btnok.getObject()),(int) (_dialogw-__c.DipToCurrent((int) (130))),__c.DipToCurrent((int) (145)),__c.DipToCurrent((int) (114)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 568;BA.debugLine="pnlDialog.SetLayoutAnimated(0, 20dip, 80dip, dial";
_pnldialog.SetLayoutAnimated((int) (0),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (80)),_dialogw,__c.DipToCurrent((int) (195)));
 //BA.debugLineNum = 570;BA.debugLine="pnlOverlay.Visible = True";
_pnloverlay.setVisible(__c.True);
 //BA.debugLineNum = 571;BA.debugLine="pnlOverlay.BringToFront";
_pnloverlay.BringToFront();
 //BA.debugLineNum = 572;BA.debugLine="edtPassphrase.RequestFocus";
_edtpassphrase.RequestFocus();
 //BA.debugLineNum = 573;BA.debugLine="End Sub";
return "";
}
public String  _tmrsession_tick() throws Exception{
 //BA.debugLineNum = 988;BA.debugLine="Private Sub tmrSession_Tick";
 //BA.debugLineNum = 989;BA.debugLine="UpdateSessionTimer";
_updatesessiontimer();
 //BA.debugLineNum = 990;BA.debugLine="End Sub";
return "";
}
public String  _updatesessiontimer() throws Exception{
int _remaining = 0;
 //BA.debugLineNum = 992;BA.debugLine="Private Sub UpdateSessionTimer";
 //BA.debugLineNum = 993;BA.debugLine="If ModSession.IsSessionActive Then";
if (_modsession._issessionactive /*boolean*/ (ba)) { 
 //BA.debugLineNum = 994;BA.debugLine="lblSessionTimer.Text = ModSession.GetRemainingFo";
_lblsessiontimer.setText(BA.ObjectToCharSequence(_modsession._getremainingformatted /*String*/ (ba)));
 //BA.debugLineNum = 997;BA.debugLine="Dim remaining As Int = ModSession.GetRemainingSe";
_remaining = _modsession._getremainingseconds /*int*/ (ba);
 //BA.debugLineNum = 998;BA.debugLine="If remaining < 60 Then";
if (_remaining<60) { 
 //BA.debugLineNum = 999;BA.debugLine="lblSessionTimer.TextColor = Colors.RGB(0, 220,";
_lblsessiontimer.setTextColor(__c.Colors.RGB((int) (0),(int) (220),(int) (255)));
 }else {
 //BA.debugLineNum = 1001;BA.debugLine="lblSessionTimer.TextColor = Colors.ARGB(200, 25";
_lblsessiontimer.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 };
 }else {
 //BA.debugLineNum = 1004;BA.debugLine="lblSessionTimer.Text = \"00:00\"";
_lblsessiontimer.setText(BA.ObjectToCharSequence("00:00"));
 //BA.debugLineNum = 1005;BA.debugLine="lblSessionTimer.TextColor = ModTheme.Danger";
_lblsessiontimer.setTextColor(_modtheme._danger /*int*/ (ba));
 };
 //BA.debugLineNum = 1007;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
