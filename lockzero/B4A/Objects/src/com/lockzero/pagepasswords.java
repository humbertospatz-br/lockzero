package com.lockzero;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class pagepasswords extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.lockzero.pagepasswords");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.lockzero.pagepasswords.class).invoke(this, new Object[] {null});
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
public anywheresoftware.b4a.objects.ButtonWrapper _btnshowpass = null;
public boolean _ispassvisible = false;
public String _currentdialogmode = "";
public String _currentgroupid = "";
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
 //BA.debugLineNum = 738;BA.debugLine="Private Sub ApplyTheme";
 //BA.debugLineNum = 739;BA.debugLine="Root.Color = ModTheme.HomeBg";
_root.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 740;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_appear() throws Exception{
 //BA.debugLineNum = 40;BA.debugLine="Private Sub B4XPage_Appear";
 //BA.debugLineNum = 42;BA.debugLine="CallSub2(Main, \"SetPageTitle\", ModLang.T(\"passwor";
__c.CallSubNew2(ba,(Object)(_main.getObject()),"SetPageTitle",(Object)(_modlang._t /*String*/ (ba,"passwords")));
 //BA.debugLineNum = 44;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 45;BA.debugLine="LoadGroups";
_loadgroups();
 //BA.debugLineNum = 48;BA.debugLine="UpdateSessionTimer";
_updatesessiontimer();
 //BA.debugLineNum = 49;BA.debugLine="tmrSession.Enabled = True";
_tmrsession.setEnabled(__c.True);
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
 //BA.debugLineNum = 34;BA.debugLine="Private Sub B4XPage_Created(Root1 As B4XView)";
 //BA.debugLineNum = 35;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 36;BA.debugLine="CreateUI";
_createui();
 //BA.debugLineNum = 37;BA.debugLine="ApplyTheme";
_applytheme();
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_disappear() throws Exception{
 //BA.debugLineNum = 52;BA.debugLine="Private Sub B4XPage_Disappear";
 //BA.debugLineNum = 53;BA.debugLine="tmrSession.Enabled = False";
_tmrsession.setEnabled(__c.False);
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return "";
}
public String  _btnadd_click() throws Exception{
 //BA.debugLineNum = 240;BA.debugLine="Private Sub btnAdd_Click";
 //BA.debugLineNum = 241;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 242;BA.debugLine="ShowAddGroupDialog";
_showaddgroupdialog();
 //BA.debugLineNum = 243;BA.debugLine="End Sub";
return "";
}
public String  _btnback_click() throws Exception{
 //BA.debugLineNum = 236;BA.debugLine="Private Sub btnBack_Click";
 //BA.debugLineNum = 237;BA.debugLine="B4XPages.ClosePage(Me)";
_b4xpages._closepage /*String*/ (ba,this);
 //BA.debugLineNum = 238;BA.debugLine="End Sub";
return "";
}
public String  _btndialogcancel_click() throws Exception{
 //BA.debugLineNum = 627;BA.debugLine="Private Sub btnDialogCancel_Click";
 //BA.debugLineNum = 628;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 629;BA.debugLine="End Sub";
return "";
}
public String  _btndialogok_click() throws Exception{
 //BA.debugLineNum = 631;BA.debugLine="Private Sub btnDialogOk_Click";
 //BA.debugLineNum = 632;BA.debugLine="Select CurrentDialogMode";
switch (BA.switchObjectToInt(_currentdialogmode,"add_group","unlock_group","edit_group")) {
case 0: {
 //BA.debugLineNum = 634;BA.debugLine="ProcessAddGroup";
_processaddgroup();
 break; }
case 1: {
 //BA.debugLineNum = 636;BA.debugLine="ProcessUnlockGroup";
_processunlockgroup();
 break; }
case 2: {
 //BA.debugLineNum = 638;BA.debugLine="ProcessEditGroup";
_processeditgroup();
 break; }
}
;
 //BA.debugLineNum = 640;BA.debugLine="End Sub";
return "";
}
public String  _btnshowpass_click() throws Exception{
 //BA.debugLineNum = 612;BA.debugLine="Private Sub btnShowPass_Click";
 //BA.debugLineNum = 613;BA.debugLine="IsPassVisible = Not(IsPassVisible)";
_ispassvisible = __c.Not(_ispassvisible);
 //BA.debugLineNum = 614;BA.debugLine="If IsPassVisible Then";
if (_ispassvisible) { 
 //BA.debugLineNum = 615;BA.debugLine="edtPassphrase.InputType = 1 'TEXT visivel";
_edtpassphrase.setInputType((int) (1));
 //BA.debugLineNum = 616;BA.debugLine="btnShowPass.Text = ModLang.T(\"hide\")";
_btnshowpass.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"hide")));
 //BA.debugLineNum = 617;BA.debugLine="btnShowPass.TextColor = Colors.White";
_btnshowpass.setTextColor(__c.Colors.White);
 }else {
 //BA.debugLineNum = 619;BA.debugLine="edtPassphrase.InputType = Bit.Or(1, 128) 'TEXT +";
_edtpassphrase.setInputType(__c.Bit.Or((int) (1),(int) (128)));
 //BA.debugLineNum = 620;BA.debugLine="btnShowPass.Text = ModLang.T(\"view\")";
_btnshowpass.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"view")));
 //BA.debugLineNum = 621;BA.debugLine="btnShowPass.TextColor = Colors.ARGB(200, 255, 25";
_btnshowpass.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 };
 //BA.debugLineNum = 624;BA.debugLine="edtPassphrase.SelectionStart = edtPassphrase.Text";
_edtpassphrase.setSelectionStart(_edtpassphrase.getText().length());
 //BA.debugLineNum = 625;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 12;BA.debugLine="Private svGroups As ScrollView";
_svgroups = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Private pnlGroups As B4XView";
_pnlgroups = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private pnlOverlay As Panel";
_pnloverlay = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private pnlDialog As Panel";
_pnldialog = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private edtGroupName As EditText";
_edtgroupname = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private edtPassphrase As EditText";
_edtpassphrase = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private btnShowPass As Button";
_btnshowpass = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private IsPassVisible As Boolean = False";
_ispassvisible = __c.False;
 //BA.debugLineNum = 22;BA.debugLine="Private CurrentDialogMode As String = \"\" 'add_gro";
_currentdialogmode = "";
 //BA.debugLineNum = 23;BA.debugLine="Private CurrentGroupId As String = \"\"";
_currentgroupid = "";
 //BA.debugLineNum = 26;BA.debugLine="Private lblSessionTimer As Label";
_lblsessiontimer = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private tmrSession As Timer";
_tmrsession = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return "";
}
public void  _confirmdeletegroup(String _groupid) throws Exception{
ResumableSub_ConfirmDeleteGroup rsub = new ResumableSub_ConfirmDeleteGroup(this,_groupid);
rsub.resume(ba, null);
}
public static class ResumableSub_ConfirmDeleteGroup extends BA.ResumableSub {
public ResumableSub_ConfirmDeleteGroup(com.lockzero.pagepasswords parent,String _groupid) {
this.parent = parent;
this._groupid = _groupid;
}
com.lockzero.pagepasswords parent;
String _groupid;
com.lockzero.clspasswordgroup _g = null;
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
 //BA.debugLineNum = 591;BA.debugLine="Dim g As clsPasswordGroup = ModPasswords.GetGroup";
_g = parent._modpasswords._getgroupbyid /*com.lockzero.clspasswordgroup*/ (ba,_groupid);
 //BA.debugLineNum = 592;BA.debugLine="If g.IsInitialized = False Then Return";
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
 //BA.debugLineNum = 594;BA.debugLine="Dim count As Int = ModPasswords.GetEntryCountByGr";
_count = parent._modpasswords._getentrycountbygroup /*int*/ (ba,_groupid);
 //BA.debugLineNum = 595;BA.debugLine="Dim msg As String = ModLang.T(\"confirm_delete_msg";
_msg = parent._modlang._t /*String*/ (ba,"confirm_delete_msg");
 //BA.debugLineNum = 596;BA.debugLine="If count > 0 Then";
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
 //BA.debugLineNum = 597;BA.debugLine="msg = msg & CRLF & CRLF & count & \" \" & ModLang.";
_msg = _msg+parent.__c.CRLF+parent.__c.CRLF+BA.NumberToString(_count)+" "+parent._modlang._t /*String*/ (ba,"passwords")+" serao excluidas!";
 if (true) break;

case 10:
//C
this.state = 11;
;
 //BA.debugLineNum = 600;BA.debugLine="Wait For (xui.Msgbox2Async(msg, ModLang.T(\"confir";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(_msg),BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"confirm_delete")),parent._modlang._t /*String*/ (ba,"delete"),"",parent._modlang._t /*String*/ (ba,"cancel"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 15;
return;
case 15:
//C
this.state = 11;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 602;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
if (true) break;

case 11:
//if
this.state = 14;
if (_result==parent._xui.DialogResponse_Positive) { 
this.state = 13;
}if (true) break;

case 13:
//C
this.state = 14;
 //BA.debugLineNum = 603;BA.debugLine="ModPasswords.DeleteGroup(groupId)";
parent._modpasswords._deletegroup /*String*/ (ba,_groupid);
 //BA.debugLineNum = 604;BA.debugLine="LoadGroups";
parent._loadgroups();
 if (true) break;

case 14:
//C
this.state = -1;
;
 //BA.debugLineNum = 606;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 127;BA.debugLine="Private Sub CreateDialogOverlay";
 //BA.debugLineNum = 128;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 129;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 132;BA.debugLine="pnlOverlay.Initialize(\"pnlOverlay\")";
_pnloverlay.Initialize(ba,"pnlOverlay");
 //BA.debugLineNum = 133;BA.debugLine="pnlOverlay.Color = Colors.ARGB(180, 0, 0, 0)";
_pnloverlay.setColor(__c.Colors.ARGB((int) (180),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 134;BA.debugLine="pnlOverlay.Visible = False";
_pnloverlay.setVisible(__c.False);
 //BA.debugLineNum = 135;BA.debugLine="Root.AddView(pnlOverlay, 0, 0, width, height)";
_root.AddView((android.view.View)(_pnloverlay.getObject()),(int) (0),(int) (0),_width,_height);
 //BA.debugLineNum = 138;BA.debugLine="Dim dialogW As Int = width - 40dip";
_dialogw = (int) (_width-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 139;BA.debugLine="Dim dialogH As Int = 220dip";
_dialogh = __c.DipToCurrent((int) (220));
 //BA.debugLineNum = 140;BA.debugLine="Dim dialogX As Int = 20dip";
_dialogx = __c.DipToCurrent((int) (20));
 //BA.debugLineNum = 141;BA.debugLine="Dim dialogY As Int = 80dip 'Posicao alta para nao";
_dialogy = __c.DipToCurrent((int) (80));
 //BA.debugLineNum = 143;BA.debugLine="pnlDialog.Initialize(\"\")";
_pnldialog.Initialize(ba,"");
 //BA.debugLineNum = 144;BA.debugLine="pnlDialog.Color = ModTheme.HomeHeaderBg";
_pnldialog.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 145;BA.debugLine="pnlOverlay.AddView(pnlDialog, dialogX, dialogY, d";
_pnloverlay.AddView((android.view.View)(_pnldialog.getObject()),_dialogx,_dialogy,_dialogw,_dialogh);
 //BA.debugLineNum = 148;BA.debugLine="Dim xvDialog As B4XView = pnlDialog";
_xvdialog = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvdialog = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnldialog.getObject()));
 //BA.debugLineNum = 149;BA.debugLine="xvDialog.SetColorAndBorder(ModTheme.HomeHeaderBg,";
_xvdialog.SetColorAndBorder(_modtheme._homeheaderbg /*int*/ (ba),(int) (0),_modtheme._homeheaderbg /*int*/ (ba),__c.DipToCurrent((int) (12)));
 //BA.debugLineNum = 150;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _createlabel(String _text,float _size,boolean _bold) throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
 //BA.debugLineNum = 152;BA.debugLine="Private Sub CreateLabel(text As String, size As Fl";
 //BA.debugLineNum = 153;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 154;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(ba,"");
 //BA.debugLineNum = 155;BA.debugLine="lbl.Text = text";
_lbl.setText(BA.ObjectToCharSequence(_text));
 //BA.debugLineNum = 156;BA.debugLine="lbl.TextSize = size";
_lbl.setTextSize(_size);
 //BA.debugLineNum = 157;BA.debugLine="lbl.Gravity = Gravity.CENTER";
_lbl.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 158;BA.debugLine="If bold Then";
if (_bold) { 
 //BA.debugLineNum = 159;BA.debugLine="lbl.Typeface = Typeface.CreateNew(Typeface.DEFAU";
_lbl.setTypeface(__c.Typeface.CreateNew(__c.Typeface.DEFAULT,__c.Typeface.STYLE_BOLD));
 };
 //BA.debugLineNum = 161;BA.debugLine="Return lbl";
if (true) return (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 162;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 60;BA.debugLine="Private Sub CreateUI";
 //BA.debugLineNum = 61;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 62;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 63;BA.debugLine="Dim headerH As Int = 56dip";
_headerh = __c.DipToCurrent((int) (56));
 //BA.debugLineNum = 66;BA.debugLine="Dim pnlHeader As Panel";
_pnlheader = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 67;BA.debugLine="pnlHeader.Initialize(\"\")";
_pnlheader.Initialize(ba,"");
 //BA.debugLineNum = 68;BA.debugLine="pnlHeader.Color = ModTheme.HomeHeaderBg";
_pnlheader.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 69;BA.debugLine="Root.AddView(pnlHeader, 0, 0, width, headerH)";
_root.AddView((android.view.View)(_pnlheader.getObject()),(int) (0),(int) (0),_width,_headerh);
 //BA.debugLineNum = 72;BA.debugLine="btnBack.Initialize(\"btnBack\")";
_btnback.Initialize(ba,"btnBack");
 //BA.debugLineNum = 73;BA.debugLine="btnBack.Text = \"<\"";
_btnback.setText(BA.ObjectToCharSequence("<"));
 //BA.debugLineNum = 74;BA.debugLine="btnBack.TextSize = 20";
_btnback.setTextSize((float) (20));
 //BA.debugLineNum = 75;BA.debugLine="btnBack.Color = Colors.Transparent";
_btnback.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 76;BA.debugLine="btnBack.TextColor = Colors.White";
_btnback.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 77;BA.debugLine="btnBack.Gravity = Gravity.CENTER";
_btnback.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 78;BA.debugLine="pnlHeader.AddView(btnBack, 0, 0, 50dip, headerH)";
_pnlheader.AddView((android.view.View)(_btnback.getObject()),(int) (0),(int) (0),__c.DipToCurrent((int) (50)),_headerh);
 //BA.debugLineNum = 81;BA.debugLine="lblHeaderTitle.Initialize(\"\")";
_lblheadertitle.Initialize(ba,"");
 //BA.debugLineNum = 82;BA.debugLine="lblHeaderTitle.Text = ModLang.T(\"passwords\")";
_lblheadertitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"passwords")));
 //BA.debugLineNum = 83;BA.debugLine="lblHeaderTitle.TextSize = 16";
_lblheadertitle.setTextSize((float) (16));
 //BA.debugLineNum = 84;BA.debugLine="lblHeaderTitle.TextColor = Colors.White";
_lblheadertitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 85;BA.debugLine="lblHeaderTitle.Typeface = Typeface.DEFAULT_BOLD";
_lblheadertitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 86;BA.debugLine="lblHeaderTitle.Gravity = Gravity.CENTER_VERTICAL";
_lblheadertitle.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 87;BA.debugLine="pnlHeader.AddView(lblHeaderTitle, 50dip, 0, width";
_pnlheader.AddView((android.view.View)(_lblheadertitle.getObject()),__c.DipToCurrent((int) (50)),(int) (0),(int) (_width-__c.DipToCurrent((int) (160))),_headerh);
 //BA.debugLineNum = 90;BA.debugLine="lblSessionTimer.Initialize(\"lblSessionTimer\")";
_lblsessiontimer.Initialize(ba,"lblSessionTimer");
 //BA.debugLineNum = 91;BA.debugLine="lblSessionTimer.Text = \"00:00\"";
_lblsessiontimer.setText(BA.ObjectToCharSequence("00:00"));
 //BA.debugLineNum = 92;BA.debugLine="lblSessionTimer.TextSize = 12";
_lblsessiontimer.setTextSize((float) (12));
 //BA.debugLineNum = 93;BA.debugLine="lblSessionTimer.TextColor = Colors.ARGB(200, 255,";
_lblsessiontimer.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 94;BA.debugLine="lblSessionTimer.Gravity = Gravity.CENTER";
_lblsessiontimer.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 95;BA.debugLine="pnlHeader.AddView(lblSessionTimer, width - 110dip";
_pnlheader.AddView((android.view.View)(_lblsessiontimer.getObject()),(int) (_width-__c.DipToCurrent((int) (110))),__c.DipToCurrent((int) (12)),__c.DipToCurrent((int) (55)),__c.DipToCurrent((int) (32)));
 //BA.debugLineNum = 98;BA.debugLine="Dim xvTimer As B4XView = lblSessionTimer";
_xvtimer = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvtimer = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lblsessiontimer.getObject()));
 //BA.debugLineNum = 99;BA.debugLine="xvTimer.SetColorAndBorder(Colors.ARGB(60, 255, 25";
_xvtimer.SetColorAndBorder(__c.Colors.ARGB((int) (60),(int) (255),(int) (255),(int) (255)),(int) (0),__c.Colors.Transparent,__c.DipToCurrent((int) (8)));
 //BA.debugLineNum = 102;BA.debugLine="Dim lblAdd As Label";
_lbladd = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 103;BA.debugLine="lblAdd.Initialize(\"btnAdd\")";
_lbladd.Initialize(ba,"btnAdd");
 //BA.debugLineNum = 104;BA.debugLine="lblAdd.Text = \"+\"";
_lbladd.setText(BA.ObjectToCharSequence("+"));
 //BA.debugLineNum = 105;BA.debugLine="lblAdd.TextSize = 26";
_lbladd.setTextSize((float) (26));
 //BA.debugLineNum = 106;BA.debugLine="lblAdd.Typeface = Typeface.DEFAULT_BOLD";
_lbladd.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 107;BA.debugLine="lblAdd.Gravity = Gravity.CENTER";
_lbladd.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 108;BA.debugLine="lblAdd.TextColor = Colors.White";
_lbladd.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 109;BA.debugLine="pnlHeader.AddView(lblAdd, width - 50dip, 8dip, 40";
_pnlheader.AddView((android.view.View)(_lbladd.getObject()),(int) (_width-__c.DipToCurrent((int) (50))),__c.DipToCurrent((int) (8)),__c.DipToCurrent((int) (40)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 112;BA.debugLine="Dim xvAdd As B4XView = lblAdd";
_xvadd = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvadd = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbladd.getObject()));
 //BA.debugLineNum = 113;BA.debugLine="xvAdd.SetColorAndBorder(ModTheme.HomeIconBg, 0, M";
_xvadd.SetColorAndBorder(_modtheme._homeiconbg /*int*/ (ba),(int) (0),_modtheme._homeiconbg /*int*/ (ba),__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 116;BA.debugLine="svGroups.Initialize(0)";
_svgroups.Initialize(ba,(int) (0));
 //BA.debugLineNum = 117;BA.debugLine="svGroups.Color = ModTheme.HomeBg";
_svgroups.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 118;BA.debugLine="Root.AddView(svGroups, 0, headerH, width, height";
_root.AddView((android.view.View)(_svgroups.getObject()),(int) (0),_headerh,_width,(int) (_height-_headerh));
 //BA.debugLineNum = 120;BA.debugLine="pnlGroups = svGroups.Panel";
_pnlgroups = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_svgroups.getPanel().getObject()));
 //BA.debugLineNum = 121;BA.debugLine="pnlGroups.Color = ModTheme.HomeBg";
_pnlgroups.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 124;BA.debugLine="CreateDialogOverlay";
_createdialogoverlay();
 //BA.debugLineNum = 125;BA.debugLine="End Sub";
return "";
}
public String  _hidedialog() throws Exception{
anywheresoftware.b4a.objects.IME _ime = null;
 //BA.debugLineNum = 642;BA.debugLine="Private Sub HideDialog";
 //BA.debugLineNum = 643;BA.debugLine="pnlOverlay.Visible = False";
_pnloverlay.setVisible(__c.False);
 //BA.debugLineNum = 644;BA.debugLine="CurrentDialogMode = \"\"";
_currentdialogmode = "";
 //BA.debugLineNum = 646;BA.debugLine="Dim ime As IME";
_ime = new anywheresoftware.b4a.objects.IME();
 //BA.debugLineNum = 647;BA.debugLine="ime.Initialize(\"\")";
_ime.Initialize("");
 //BA.debugLineNum = 648;BA.debugLine="ime.HideKeyboard";
_ime.HideKeyboard(ba);
 //BA.debugLineNum = 649;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 30;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 31;BA.debugLine="tmrSession.Initialize(\"tmrSession\", 1000)";
_tmrsession.Initialize(ba,"tmrSession",(long) (1000));
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
public void  _lblsessiontimer_click() throws Exception{
ResumableSub_lblSessionTimer_Click rsub = new ResumableSub_lblSessionTimer_Click(this);
rsub.resume(ba, null);
}
public static class ResumableSub_lblSessionTimer_Click extends BA.ResumableSub {
public ResumableSub_lblSessionTimer_Click(com.lockzero.pagepasswords parent) {
this.parent = parent;
}
com.lockzero.pagepasswords parent;
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
 //BA.debugLineNum = 775;BA.debugLine="Wait For (xui.Msgbox2Async(ModLang.T(\"lock_confir";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"lock_confirm_msg")),BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"lock")),parent._modlang._t /*String*/ (ba,"yes"),"",parent._modlang._t /*String*/ (ba,"cancel"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 777;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
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
 //BA.debugLineNum = 778;BA.debugLine="tmrSession.Enabled = False";
parent._tmrsession.setEnabled(parent.__c.False);
 //BA.debugLineNum = 779;BA.debugLine="ModSession.EndSession";
parent._modsession._endsession /*String*/ (ba);
 //BA.debugLineNum = 780;BA.debugLine="B4XPages.ClosePage(Me)";
parent._b4xpages._closepage /*String*/ (ba,parent);
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 782;BA.debugLine="End Sub";
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
anywheresoftware.b4a.objects.B4XViewWrapper _lblempty = null;
com.lockzero.clspasswordgroup _g = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlitem = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xvitem = null;
anywheresoftware.b4a.objects.LabelWrapper _lblname = null;
int _count = 0;
anywheresoftware.b4a.objects.LabelWrapper _lblcount = null;
anywheresoftware.b4a.objects.LabelWrapper _lblarrow = null;
 //BA.debugLineNum = 168;BA.debugLine="Private Sub LoadGroups";
 //BA.debugLineNum = 169;BA.debugLine="ModPasswords.Init";
_modpasswords._init /*String*/ (ba);
 //BA.debugLineNum = 171;BA.debugLine="pnlGroups.RemoveAllViews";
_pnlgroups.RemoveAllViews();
 //BA.debugLineNum = 173;BA.debugLine="Dim groups As List = ModPasswords.GetAllGroups";
_groups = new anywheresoftware.b4a.objects.collections.List();
_groups = _modpasswords._getallgroups /*anywheresoftware.b4a.objects.collections.List*/ (ba);
 //BA.debugLineNum = 174;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 175;BA.debugLine="Dim itemHeight As Int = 70dip";
_itemheight = __c.DipToCurrent((int) (70));
 //BA.debugLineNum = 176;BA.debugLine="Dim y As Int = 16dip";
_y = __c.DipToCurrent((int) (16));
 //BA.debugLineNum = 178;BA.debugLine="If groups.Size = 0 Then";
if (_groups.getSize()==0) { 
 //BA.debugLineNum = 180;BA.debugLine="Dim lblEmpty As B4XView = CreateLabel(ModLang.T(";
_lblempty = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lblempty = _createlabel(_modlang._t /*String*/ (ba,"empty"),(float) (14),__c.False);
 //BA.debugLineNum = 181;BA.debugLine="lblEmpty.TextColor = Colors.ARGB(150, 255, 255,";
_lblempty.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 182;BA.debugLine="pnlGroups.AddView(lblEmpty, 0, 100dip, width, 40";
_pnlgroups.AddView((android.view.View)(_lblempty.getObject()),(int) (0),__c.DipToCurrent((int) (100)),_width,__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 183;BA.debugLine="pnlGroups.Height = 200dip";
_pnlgroups.setHeight(__c.DipToCurrent((int) (200)));
 //BA.debugLineNum = 184;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 187;BA.debugLine="For Each g As clsPasswordGroup In groups";
{
final anywheresoftware.b4a.BA.IterableList group14 = _groups;
final int groupLen14 = group14.getSize()
;int index14 = 0;
;
for (; index14 < groupLen14;index14++){
_g = (com.lockzero.clspasswordgroup)(group14.Get(index14));
 //BA.debugLineNum = 188;BA.debugLine="Dim pnlItem As Panel";
_pnlitem = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 189;BA.debugLine="pnlItem.Initialize(\"pnlGroup\")";
_pnlitem.Initialize(ba,"pnlGroup");
 //BA.debugLineNum = 190;BA.debugLine="pnlItem.Tag = g.Id";
_pnlitem.setTag((Object)(_g._id /*String*/ ));
 //BA.debugLineNum = 193;BA.debugLine="Dim xvItem As B4XView = pnlItem";
_xvitem = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvitem = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnlitem.getObject()));
 //BA.debugLineNum = 194;BA.debugLine="xvItem.SetColorAndBorder(ModTheme.HomeIconBg, 0,";
_xvitem.SetColorAndBorder(_modtheme._homeiconbg /*int*/ (ba),(int) (0),_modtheme._homeiconbg /*int*/ (ba),__c.DipToCurrent((int) (12)));
 //BA.debugLineNum = 195;BA.debugLine="pnlGroups.AddView(pnlItem, 16dip, y, width - 32d";
_pnlgroups.AddView((android.view.View)(_pnlitem.getObject()),__c.DipToCurrent((int) (16)),_y,(int) (_width-__c.DipToCurrent((int) (32))),_itemheight);
 //BA.debugLineNum = 198;BA.debugLine="Dim lblName As Label";
_lblname = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 199;BA.debugLine="lblName.Initialize(\"\")";
_lblname.Initialize(ba,"");
 //BA.debugLineNum = 200;BA.debugLine="lblName.Text = g.Name";
_lblname.setText(BA.ObjectToCharSequence(_g._name /*String*/ ));
 //BA.debugLineNum = 201;BA.debugLine="lblName.TextSize = 16";
_lblname.setTextSize((float) (16));
 //BA.debugLineNum = 202;BA.debugLine="lblName.TextColor = Colors.White";
_lblname.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 203;BA.debugLine="lblName.Typeface = Typeface.DEFAULT_BOLD";
_lblname.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 204;BA.debugLine="lblName.Gravity = Gravity.CENTER_VERTICAL";
_lblname.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 205;BA.debugLine="pnlItem.AddView(lblName, 16dip, 0, width - 140di";
_pnlitem.AddView((android.view.View)(_lblname.getObject()),__c.DipToCurrent((int) (16)),(int) (0),(int) (_width-__c.DipToCurrent((int) (140))),_itemheight);
 //BA.debugLineNum = 208;BA.debugLine="Dim count As Int = ModPasswords.GetEntryCountByG";
_count = _modpasswords._getentrycountbygroup /*int*/ (ba,_g._id /*String*/ );
 //BA.debugLineNum = 209;BA.debugLine="Dim lblCount As Label";
_lblcount = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 210;BA.debugLine="lblCount.Initialize(\"\")";
_lblcount.Initialize(ba,"");
 //BA.debugLineNum = 211;BA.debugLine="lblCount.Text = count";
_lblcount.setText(BA.ObjectToCharSequence(_count));
 //BA.debugLineNum = 212;BA.debugLine="lblCount.TextSize = 14";
_lblcount.setTextSize((float) (14));
 //BA.debugLineNum = 213;BA.debugLine="lblCount.TextColor = Colors.ARGB(180, 255, 255,";
_lblcount.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 214;BA.debugLine="lblCount.Gravity = Gravity.CENTER";
_lblcount.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 215;BA.debugLine="pnlItem.AddView(lblCount, width - 110dip, 0, 40d";
_pnlitem.AddView((android.view.View)(_lblcount.getObject()),(int) (_width-__c.DipToCurrent((int) (110))),(int) (0),__c.DipToCurrent((int) (40)),_itemheight);
 //BA.debugLineNum = 218;BA.debugLine="Dim lblArrow As Label";
_lblarrow = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 219;BA.debugLine="lblArrow.Initialize(\"\")";
_lblarrow.Initialize(ba,"");
 //BA.debugLineNum = 220;BA.debugLine="lblArrow.Text = \">\"";
_lblarrow.setText(BA.ObjectToCharSequence(">"));
 //BA.debugLineNum = 221;BA.debugLine="lblArrow.TextSize = 18";
_lblarrow.setTextSize((float) (18));
 //BA.debugLineNum = 222;BA.debugLine="lblArrow.TextColor = Colors.ARGB(150, 255, 255,";
_lblarrow.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 223;BA.debugLine="lblArrow.Gravity = Gravity.CENTER";
_lblarrow.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 224;BA.debugLine="pnlItem.AddView(lblArrow, width - 70dip, 0, 30di";
_pnlitem.AddView((android.view.View)(_lblarrow.getObject()),(int) (_width-__c.DipToCurrent((int) (70))),(int) (0),__c.DipToCurrent((int) (30)),_itemheight);
 //BA.debugLineNum = 226;BA.debugLine="y = y + itemHeight + 12dip";
_y = (int) (_y+_itemheight+__c.DipToCurrent((int) (12)));
 }
};
 //BA.debugLineNum = 229;BA.debugLine="pnlGroups.Height = y + 20dip";
_pnlgroups.setHeight((int) (_y+__c.DipToCurrent((int) (20))));
 //BA.debugLineNum = 230;BA.debugLine="End Sub";
return "";
}
public String  _navigatetogroup(String _groupid) throws Exception{
anywheresoftware.b4a.objects.collections.Map _params = null;
com.lockzero.pagepasswordlist _pg = null;
 //BA.debugLineNum = 385;BA.debugLine="Private Sub NavigateToGroup(groupId As String)";
 //BA.debugLineNum = 386;BA.debugLine="Dim params As Map";
_params = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 387;BA.debugLine="params.Initialize";
_params.Initialize();
 //BA.debugLineNum = 388;BA.debugLine="params.Put(\"groupId\", groupId)";
_params.Put((Object)("groupId"),(Object)(_groupid));
 //BA.debugLineNum = 390;BA.debugLine="Dim pg As PagePasswordList = B4XPages.GetPage(\"Pa";
_pg = (com.lockzero.pagepasswordlist)(_b4xpages._getpage /*Object*/ (ba,"PagePasswordList"));
 //BA.debugLineNum = 391;BA.debugLine="pg.SetParams(params)";
_pg._setparams /*String*/ (_params);
 //BA.debugLineNum = 392;BA.debugLine="B4XPages.ShowPage(\"PagePasswordList\")";
_b4xpages._showpage /*String*/ (ba,"PagePasswordList");
 //BA.debugLineNum = 393;BA.debugLine="End Sub";
return "";
}
public String  _pnlgroup_click() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
String _groupid = "";
com.lockzero.clspasswordgroup _g = null;
 //BA.debugLineNum = 250;BA.debugLine="Private Sub pnlGroup_Click";
 //BA.debugLineNum = 251;BA.debugLine="Dim pnl As Panel = Sender";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
_pnl = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(__c.Sender(ba)));
 //BA.debugLineNum = 252;BA.debugLine="Dim groupId As String = pnl.Tag";
_groupid = BA.ObjectToString(_pnl.getTag());
 //BA.debugLineNum = 254;BA.debugLine="Log(\"=== pnlGroup_Click ===\")";
__c.LogImpl("559768836","=== pnlGroup_Click ===",0);
 //BA.debugLineNum = 255;BA.debugLine="Log(\"GroupId: \" & groupId)";
__c.LogImpl("559768837","GroupId: "+_groupid,0);
 //BA.debugLineNum = 257;BA.debugLine="Dim g As clsPasswordGroup = ModPasswords.GetGroup";
_g = _modpasswords._getgroupbyid /*com.lockzero.clspasswordgroup*/ (ba,_groupid);
 //BA.debugLineNum = 258;BA.debugLine="If g.IsInitialized = False Then";
if (_g._isinitialized /*boolean*/ ()==__c.False) { 
 //BA.debugLineNum = 259;BA.debugLine="Log(\"ERRO: Grupo nao inicializado!\")";
__c.LogImpl("559768841","ERRO: Grupo nao inicializado!",0);
 //BA.debugLineNum = 260;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 263;BA.debugLine="Log(\"Grupo: \" & g.Name)";
__c.LogImpl("559768845","Grupo: "+_g._name /*String*/ ,0);
 //BA.debugLineNum = 264;BA.debugLine="Log(\"Salt: \" & g.Salt)";
__c.LogImpl("559768846","Salt: "+_g._salt /*String*/ ,0);
 //BA.debugLineNum = 265;BA.debugLine="Log(\"TestValue: \" & g.TestValue)";
__c.LogImpl("559768847","TestValue: "+_g._testvalue /*String*/ ,0);
 //BA.debugLineNum = 266;BA.debugLine="Log(\"Sessao ativa: \" & ModSession.IsSessionActive";
__c.LogImpl("559768848","Sessao ativa: "+BA.ObjectToString(_modsession._issessionactive /*boolean*/ (ba)),0);
 //BA.debugLineNum = 269;BA.debugLine="If ModSession.IsSessionActive Then";
if (_modsession._issessionactive /*boolean*/ (ba)) { 
 //BA.debugLineNum = 270;BA.debugLine="Log(\"Sessao ativa - navegando direto\")";
__c.LogImpl("559768852","Sessao ativa - navegando direto",0);
 //BA.debugLineNum = 271;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 272;BA.debugLine="NavigateToGroup(groupId)";
_navigatetogroup(_groupid);
 //BA.debugLineNum = 273;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 277;BA.debugLine="Log(\"Sessao inativa - mostrando dialog\")";
__c.LogImpl("559768859","Sessao inativa - mostrando dialog",0);
 //BA.debugLineNum = 278;BA.debugLine="ShowUnlockGroupDialog(groupId)";
_showunlockgroupdialog(_groupid);
 //BA.debugLineNum = 279;BA.debugLine="End Sub";
return "";
}
public String  _pnlgroup_longclick() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
String _groupid = "";
 //BA.debugLineNum = 395;BA.debugLine="Private Sub pnlGroup_LongClick";
 //BA.debugLineNum = 396;BA.debugLine="Dim pnl As Panel = Sender";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
_pnl = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(__c.Sender(ba)));
 //BA.debugLineNum = 397;BA.debugLine="Dim groupId As String = pnl.Tag";
_groupid = BA.ObjectToString(_pnl.getTag());
 //BA.debugLineNum = 399;BA.debugLine="ShowGroupOptions(groupId)";
_showgroupoptions(_groupid);
 //BA.debugLineNum = 400;BA.debugLine="End Sub";
return "";
}
public String  _pnloverlay_click() throws Exception{
 //BA.debugLineNum = 245;BA.debugLine="Private Sub pnlOverlay_Click";
 //BA.debugLineNum = 247;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 248;BA.debugLine="End Sub";
return "";
}
public String  _processaddgroup() throws Exception{
String _groupname = "";
String _phrase = "";
String _phraseerror = "";
com.lockzero.clspasswordgroup _g = null;
 //BA.debugLineNum = 651;BA.debugLine="Private Sub ProcessAddGroup";
 //BA.debugLineNum = 652;BA.debugLine="Dim groupName As String = edtGroupName.Text.Trim";
_groupname = _edtgroupname.getText().trim();
 //BA.debugLineNum = 653;BA.debugLine="Dim phrase As String = edtPassphrase.Text.Trim";
_phrase = _edtpassphrase.getText().trim();
 //BA.debugLineNum = 656;BA.debugLine="If groupName.Length = 0 Then";
if (_groupname.length()==0) { 
 //BA.debugLineNum = 657;BA.debugLine="ToastMessageShow(ModLang.T(\"error_empty_field\"),";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error_empty_field")),__c.True);
 //BA.debugLineNum = 658;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 662;BA.debugLine="Dim phraseError As String = ModSecurity.GetPassph";
_phraseerror = _modsecurity._getpassphraseerror /*String*/ (ba,_phrase);
 //BA.debugLineNum = 663;BA.debugLine="If phraseError.Length > 0 Then";
if (_phraseerror.length()>0) { 
 //BA.debugLineNum = 664;BA.debugLine="ToastMessageShow(phraseError, True)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_phraseerror),__c.True);
 //BA.debugLineNum = 665;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 669;BA.debugLine="Dim g As clsPasswordGroup";
_g = new com.lockzero.clspasswordgroup();
 //BA.debugLineNum = 670;BA.debugLine="g.Initialize";
_g._initialize /*String*/ (ba);
 //BA.debugLineNum = 671;BA.debugLine="g.Name = groupName";
_g._name /*String*/  = _groupname;
 //BA.debugLineNum = 672;BA.debugLine="g.GenerateSalt";
_g._generatesalt /*String*/ ();
 //BA.debugLineNum = 673;BA.debugLine="g.CreateTestValue(phrase)";
_g._createtestvalue /*String*/ (_phrase);
 //BA.debugLineNum = 674;BA.debugLine="ModPasswords.SaveGroup(g)";
_modpasswords._savegroup /*String*/ (ba,_g);
 //BA.debugLineNum = 677;BA.debugLine="ModSession.StartSessionWithCategory(phrase, \"pass";
_modsession._startsessionwithcategory /*String*/ (ba,_phrase,"passwords");
 //BA.debugLineNum = 679;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 680;BA.debugLine="LoadGroups";
_loadgroups();
 //BA.debugLineNum = 681;BA.debugLine="ToastMessageShow(ModLang.T(\"success\"), False)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"success")),__c.False);
 //BA.debugLineNum = 682;BA.debugLine="End Sub";
return "";
}
public String  _processeditgroup() throws Exception{
String _groupname = "";
com.lockzero.clspasswordgroup _g = null;
 //BA.debugLineNum = 714;BA.debugLine="Private Sub ProcessEditGroup";
 //BA.debugLineNum = 715;BA.debugLine="Dim groupName As String = edtGroupName.Text.Trim";
_groupname = _edtgroupname.getText().trim();
 //BA.debugLineNum = 716;BA.debugLine="Dim g As clsPasswordGroup = ModPasswords.GetGroup";
_g = _modpasswords._getgroupbyid /*com.lockzero.clspasswordgroup*/ (ba,_currentgroupid);
 //BA.debugLineNum = 718;BA.debugLine="If g.IsInitialized = False Then";
if (_g._isinitialized /*boolean*/ ()==__c.False) { 
 //BA.debugLineNum = 719;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 720;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 723;BA.debugLine="If groupName.Length > 0 Then";
if (_groupname.length()>0) { 
 //BA.debugLineNum = 724;BA.debugLine="g.Name = groupName";
_g._name /*String*/  = _groupname;
 //BA.debugLineNum = 725;BA.debugLine="ModPasswords.SaveGroup(g)";
_modpasswords._savegroup /*String*/ (ba,_g);
 //BA.debugLineNum = 726;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 727;BA.debugLine="LoadGroups";
_loadgroups();
 //BA.debugLineNum = 728;BA.debugLine="ToastMessageShow(ModLang.T(\"success\"), False)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"success")),__c.False);
 }else {
 //BA.debugLineNum = 730;BA.debugLine="ToastMessageShow(ModLang.T(\"error_empty_field\"),";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error_empty_field")),__c.True);
 };
 //BA.debugLineNum = 732;BA.debugLine="End Sub";
return "";
}
public String  _processunlockgroup() throws Exception{
String _phrase = "";
com.lockzero.clspasswordgroup _g = null;
int _delay = 0;
String _timestr = "";
 //BA.debugLineNum = 684;BA.debugLine="Private Sub ProcessUnlockGroup";
 //BA.debugLineNum = 685;BA.debugLine="Dim phrase As String = edtPassphrase.Text.Trim";
_phrase = _edtpassphrase.getText().trim();
 //BA.debugLineNum = 686;BA.debugLine="Dim g As clsPasswordGroup = ModPasswords.GetGroup";
_g = _modpasswords._getgroupbyid /*com.lockzero.clspasswordgroup*/ (ba,_currentgroupid);
 //BA.debugLineNum = 688;BA.debugLine="If g.IsInitialized = False Then";
if (_g._isinitialized /*boolean*/ ()==__c.False) { 
 //BA.debugLineNum = 689;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 690;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 694;BA.debugLine="If g.ValidatePhrase(phrase) Then";
if (_g._validatephrase /*boolean*/ (_phrase)) { 
 //BA.debugLineNum = 696;BA.debugLine="ModSecurity.ResetFailedAttempts(CurrentGroupId)";
_modsecurity._resetfailedattempts /*String*/ (ba,_currentgroupid);
 //BA.debugLineNum = 697;BA.debugLine="ModSession.StartSessionWithCategory(phrase, \"pas";
_modsession._startsessionwithcategory /*String*/ (ba,_phrase,"passwords");
 //BA.debugLineNum = 698;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 699;BA.debugLine="NavigateToGroup(CurrentGroupId)";
_navigatetogroup(_currentgroupid);
 }else {
 //BA.debugLineNum = 702;BA.debugLine="Dim delay As Int = ModSecurity.RegisterFailedAtt";
_delay = _modsecurity._registerfailedattempt /*int*/ (ba,_currentgroupid);
 //BA.debugLineNum = 703;BA.debugLine="If delay > 0 Then";
if (_delay>0) { 
 //BA.debugLineNum = 704;BA.debugLine="Dim timeStr As String = ModSecurity.FormatDelay";
_timestr = _modsecurity._formatdelay /*String*/ (ba,_delay);
 //BA.debugLineNum = 705;BA.debugLine="ToastMessageShow(ModLang.T(\"wrong_passphrase\")";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"wrong_passphrase")+" - "+_modlang._t /*String*/ (ba,"wait_timeout")+" "+_timestr),__c.True);
 //BA.debugLineNum = 706;BA.debugLine="HideDialog";
_hidedialog();
 }else {
 //BA.debugLineNum = 708;BA.debugLine="ToastMessageShow(ModLang.T(\"wrong_passphrase\"),";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"wrong_passphrase")),__c.True);
 };
 //BA.debugLineNum = 710;BA.debugLine="edtPassphrase.Text = \"\"";
_edtpassphrase.setText(BA.ObjectToCharSequence(""));
 };
 //BA.debugLineNum = 712;BA.debugLine="End Sub";
return "";
}
public String  _showaddgroupdialog() throws Exception{
int _dialogw = 0;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
anywheresoftware.b4a.objects.LabelWrapper _lblname = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlname = null;
anywheresoftware.b4a.objects.LabelWrapper _lblphrase = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlinput = null;
anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
anywheresoftware.b4a.objects.ButtonWrapper _btnok = null;
 //BA.debugLineNum = 406;BA.debugLine="Private Sub ShowAddGroupDialog";
 //BA.debugLineNum = 407;BA.debugLine="CurrentDialogMode = \"add_group\"";
_currentdialogmode = "add_group";
 //BA.debugLineNum = 408;BA.debugLine="CurrentGroupId = \"\"";
_currentgroupid = "";
 //BA.debugLineNum = 409;BA.debugLine="IsPassVisible = False";
_ispassvisible = __c.False;
 //BA.debugLineNum = 412;BA.debugLine="Dim dialogW As Int = Root.Width - 40dip";
_dialogw = (int) (_root.getWidth()-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 413;BA.debugLine="pnlDialog.RemoveAllViews";
_pnldialog.RemoveAllViews();
 //BA.debugLineNum = 416;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 417;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 418;BA.debugLine="lblTitle.Text = ModLang.T(\"new_group\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"new_group")));
 //BA.debugLineNum = 419;BA.debugLine="lblTitle.TextSize = 16";
_lbltitle.setTextSize((float) (16));
 //BA.debugLineNum = 420;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 421;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 422;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 423;BA.debugLine="pnlDialog.AddView(lblTitle, 0, 12dip, dialogW, 24";
_pnldialog.AddView((android.view.View)(_lbltitle.getObject()),(int) (0),__c.DipToCurrent((int) (12)),_dialogw,__c.DipToCurrent((int) (24)));
 //BA.debugLineNum = 426;BA.debugLine="Dim lblName As Label";
_lblname = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 427;BA.debugLine="lblName.Initialize(\"\")";
_lblname.Initialize(ba,"");
 //BA.debugLineNum = 428;BA.debugLine="lblName.Text = ModLang.T(\"group_name_hint\")";
_lblname.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"group_name_hint")));
 //BA.debugLineNum = 429;BA.debugLine="lblName.TextSize = 12";
_lblname.setTextSize((float) (12));
 //BA.debugLineNum = 430;BA.debugLine="lblName.TextColor = Colors.ARGB(180, 255, 255, 25";
_lblname.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 431;BA.debugLine="pnlDialog.AddView(lblName, 16dip, 45dip, dialogW";
_pnldialog.AddView((android.view.View)(_lblname.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (45)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (18)));
 //BA.debugLineNum = 434;BA.debugLine="edtGroupName.Initialize(\"edtGroupName\")";
_edtgroupname.Initialize(ba,"edtGroupName");
 //BA.debugLineNum = 435;BA.debugLine="edtGroupName.Hint = ModLang.T(\"group_name_hint\")";
_edtgroupname.setHint(_modlang._t /*String*/ (ba,"group_name_hint"));
 //BA.debugLineNum = 436;BA.debugLine="edtGroupName.SingleLine = True";
_edtgroupname.setSingleLine(__c.True);
 //BA.debugLineNum = 437;BA.debugLine="edtGroupName.InputType = Bit.Or(1, 8192) 'TEXT +";
_edtgroupname.setInputType(__c.Bit.Or((int) (1),(int) (8192)));
 //BA.debugLineNum = 438;BA.debugLine="edtGroupName.Text = \"\"";
_edtgroupname.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 439;BA.debugLine="edtGroupName.TextColor = Colors.White";
_edtgroupname.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 440;BA.debugLine="edtGroupName.HintColor = Colors.ARGB(120, 255, 25";
_edtgroupname.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 442;BA.debugLine="Dim pnlName As Panel";
_pnlname = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 443;BA.debugLine="pnlName.Initialize(\"\")";
_pnlname.Initialize(ba,"");
 //BA.debugLineNum = 444;BA.debugLine="pnlName.Color = ModTheme.HomeBg";
_pnlname.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 445;BA.debugLine="pnlDialog.AddView(pnlName, 16dip, 65dip, dialogW";
_pnldialog.AddView((android.view.View)(_pnlname.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (65)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (46)));
 //BA.debugLineNum = 446;BA.debugLine="pnlName.AddView(edtGroupName, 8dip, 0, dialogW -";
_pnlname.AddView((android.view.View)(_edtgroupname.getObject()),__c.DipToCurrent((int) (8)),(int) (0),(int) (_dialogw-__c.DipToCurrent((int) (32))-__c.DipToCurrent((int) (16))),__c.DipToCurrent((int) (46)));
 //BA.debugLineNum = 449;BA.debugLine="Dim lblPhrase As Label";
_lblphrase = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 450;BA.debugLine="lblPhrase.Initialize(\"\")";
_lblphrase.Initialize(ba,"");
 //BA.debugLineNum = 451;BA.debugLine="lblPhrase.Text = ModLang.T(\"passphrase_hint\")";
_lblphrase.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"passphrase_hint")));
 //BA.debugLineNum = 452;BA.debugLine="lblPhrase.TextSize = 12";
_lblphrase.setTextSize((float) (12));
 //BA.debugLineNum = 453;BA.debugLine="lblPhrase.TextColor = Colors.ARGB(180, 255, 255,";
_lblphrase.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 454;BA.debugLine="pnlDialog.AddView(lblPhrase, 16dip, 120dip, dialo";
_pnldialog.AddView((android.view.View)(_lblphrase.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (120)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (18)));
 //BA.debugLineNum = 457;BA.debugLine="Dim pnlInput As Panel";
_pnlinput = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 458;BA.debugLine="pnlInput.Initialize(\"\")";
_pnlinput.Initialize(ba,"");
 //BA.debugLineNum = 459;BA.debugLine="pnlInput.Color = ModTheme.HomeBg";
_pnlinput.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 460;BA.debugLine="pnlDialog.AddView(pnlInput, 16dip, 140dip, dialog";
_pnldialog.AddView((android.view.View)(_pnlinput.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (140)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (46)));
 //BA.debugLineNum = 462;BA.debugLine="edtPassphrase.Initialize(\"edtPassphrase\")";
_edtpassphrase.Initialize(ba,"edtPassphrase");
 //BA.debugLineNum = 463;BA.debugLine="edtPassphrase.Hint = ModLang.T(\"passphrase_hint\")";
_edtpassphrase.setHint(_modlang._t /*String*/ (ba,"passphrase_hint"));
 //BA.debugLineNum = 464;BA.debugLine="edtPassphrase.SingleLine = True";
_edtpassphrase.setSingleLine(__c.True);
 //BA.debugLineNum = 465;BA.debugLine="edtPassphrase.InputType = Bit.Or(1, 128) 'TEXT +";
_edtpassphrase.setInputType(__c.Bit.Or((int) (1),(int) (128)));
 //BA.debugLineNum = 466;BA.debugLine="edtPassphrase.Text = \"\"";
_edtpassphrase.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 467;BA.debugLine="edtPassphrase.TextColor = Colors.White";
_edtpassphrase.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 468;BA.debugLine="edtPassphrase.HintColor = Colors.ARGB(120, 255, 2";
_edtpassphrase.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 469;BA.debugLine="pnlInput.AddView(edtPassphrase, 8dip, 0, dialogW";
_pnlinput.AddView((android.view.View)(_edtpassphrase.getObject()),__c.DipToCurrent((int) (8)),(int) (0),(int) (_dialogw-__c.DipToCurrent((int) (32))-__c.DipToCurrent((int) (56))),__c.DipToCurrent((int) (46)));
 //BA.debugLineNum = 472;BA.debugLine="btnShowPass.Initialize(\"btnShowPass\")";
_btnshowpass.Initialize(ba,"btnShowPass");
 //BA.debugLineNum = 473;BA.debugLine="btnShowPass.Text = ModLang.T(\"view\")";
_btnshowpass.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"view")));
 //BA.debugLineNum = 474;BA.debugLine="btnShowPass.TextSize = Starter.FONT_CAPTION";
_btnshowpass.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 475;BA.debugLine="btnShowPass.Color = Colors.Transparent";
_btnshowpass.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 476;BA.debugLine="btnShowPass.TextColor = Colors.ARGB(200, 255, 255";
_btnshowpass.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 477;BA.debugLine="btnShowPass.Gravity = Gravity.CENTER";
_btnshowpass.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 478;BA.debugLine="pnlInput.AddView(btnShowPass, dialogW - 32dip - 6";
_pnlinput.AddView((android.view.View)(_btnshowpass.getObject()),(int) (_dialogw-__c.DipToCurrent((int) (32))-__c.DipToCurrent((int) (65))),__c.DipToCurrent((int) (3)),__c.DipToCurrent((int) (60)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 481;BA.debugLine="Dim btnCancel As Button";
_btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 482;BA.debugLine="btnCancel.Initialize(\"btnDialogCancel\")";
_btncancel.Initialize(ba,"btnDialogCancel");
 //BA.debugLineNum = 483;BA.debugLine="btnCancel.Text = ModLang.T(\"cancel\")";
_btncancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 484;BA.debugLine="btnCancel.TextSize = 13";
_btncancel.setTextSize((float) (13));
 //BA.debugLineNum = 485;BA.debugLine="btnCancel.Color = Colors.Transparent";
_btncancel.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 486;BA.debugLine="btnCancel.TextColor = Colors.ARGB(200, 255, 255,";
_btncancel.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 487;BA.debugLine="pnlDialog.AddView(btnCancel, 16dip, 200dip, 100di";
_pnldialog.AddView((android.view.View)(_btncancel.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (200)),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 489;BA.debugLine="Dim btnOk As Button";
_btnok = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 490;BA.debugLine="btnOk.Initialize(\"btnDialogOk\")";
_btnok.Initialize(ba,"btnDialogOk");
 //BA.debugLineNum = 491;BA.debugLine="btnOk.Text = ModLang.T(\"save\")";
_btnok.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"save")));
 //BA.debugLineNum = 492;BA.debugLine="btnOk.TextSize = 13";
_btnok.setTextSize((float) (13));
 //BA.debugLineNum = 493;BA.debugLine="btnOk.Color = ModTheme.HomeIconBg";
_btnok.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 494;BA.debugLine="btnOk.TextColor = Colors.White";
_btnok.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 495;BA.debugLine="pnlDialog.AddView(btnOk, dialogW - 116dip, 200dip";
_pnldialog.AddView((android.view.View)(_btnok.getObject()),(int) (_dialogw-__c.DipToCurrent((int) (116))),__c.DipToCurrent((int) (200)),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 498;BA.debugLine="pnlDialog.SetLayoutAnimated(0, 20dip, 60dip, dial";
_pnldialog.SetLayoutAnimated((int) (0),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (60)),_dialogw,__c.DipToCurrent((int) (250)));
 //BA.debugLineNum = 501;BA.debugLine="pnlOverlay.Visible = True";
_pnloverlay.setVisible(__c.True);
 //BA.debugLineNum = 502;BA.debugLine="pnlOverlay.BringToFront";
_pnloverlay.BringToFront();
 //BA.debugLineNum = 503;BA.debugLine="edtGroupName.RequestFocus";
_edtgroupname.RequestFocus();
 //BA.debugLineNum = 504;BA.debugLine="End Sub";
return "";
}
public String  _showeditgroupdialog(String _groupid) throws Exception{
com.lockzero.clspasswordgroup _g = null;
int _dialogw = 0;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
anywheresoftware.b4a.objects.LabelWrapper _lblname = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlname = null;
anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
anywheresoftware.b4a.objects.ButtonWrapper _btnok = null;
 //BA.debugLineNum = 521;BA.debugLine="Private Sub ShowEditGroupDialog(groupId As String)";
 //BA.debugLineNum = 522;BA.debugLine="Dim g As clsPasswordGroup = ModPasswords.GetGroup";
_g = _modpasswords._getgroupbyid /*com.lockzero.clspasswordgroup*/ (ba,_groupid);
 //BA.debugLineNum = 523;BA.debugLine="If g.IsInitialized = False Then Return";
if (_g._isinitialized /*boolean*/ ()==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 525;BA.debugLine="CurrentDialogMode = \"edit_group\"";
_currentdialogmode = "edit_group";
 //BA.debugLineNum = 526;BA.debugLine="CurrentGroupId = groupId";
_currentgroupid = _groupid;
 //BA.debugLineNum = 529;BA.debugLine="Dim dialogW As Int = Root.Width - 40dip";
_dialogw = (int) (_root.getWidth()-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 530;BA.debugLine="pnlDialog.RemoveAllViews";
_pnldialog.RemoveAllViews();
 //BA.debugLineNum = 533;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 534;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 535;BA.debugLine="lblTitle.Text = ModLang.T(\"edit_group\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"edit_group")));
 //BA.debugLineNum = 536;BA.debugLine="lblTitle.TextSize = 16";
_lbltitle.setTextSize((float) (16));
 //BA.debugLineNum = 537;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 538;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 539;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 540;BA.debugLine="pnlDialog.AddView(lblTitle, 0, 12dip, dialogW, 24";
_pnldialog.AddView((android.view.View)(_lbltitle.getObject()),(int) (0),__c.DipToCurrent((int) (12)),_dialogw,__c.DipToCurrent((int) (24)));
 //BA.debugLineNum = 543;BA.debugLine="Dim lblName As Label";
_lblname = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 544;BA.debugLine="lblName.Initialize(\"\")";
_lblname.Initialize(ba,"");
 //BA.debugLineNum = 545;BA.debugLine="lblName.Text = ModLang.T(\"group_name_hint\")";
_lblname.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"group_name_hint")));
 //BA.debugLineNum = 546;BA.debugLine="lblName.TextSize = 12";
_lblname.setTextSize((float) (12));
 //BA.debugLineNum = 547;BA.debugLine="lblName.TextColor = Colors.ARGB(180, 255, 255, 25";
_lblname.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 548;BA.debugLine="pnlDialog.AddView(lblName, 16dip, 45dip, dialogW";
_pnldialog.AddView((android.view.View)(_lblname.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (45)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (18)));
 //BA.debugLineNum = 551;BA.debugLine="Dim pnlName As Panel";
_pnlname = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 552;BA.debugLine="pnlName.Initialize(\"\")";
_pnlname.Initialize(ba,"");
 //BA.debugLineNum = 553;BA.debugLine="pnlName.Color = ModTheme.HomeBg";
_pnlname.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 554;BA.debugLine="pnlDialog.AddView(pnlName, 16dip, 65dip, dialogW";
_pnldialog.AddView((android.view.View)(_pnlname.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (65)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (46)));
 //BA.debugLineNum = 556;BA.debugLine="edtGroupName.Initialize(\"edtGroupName\")";
_edtgroupname.Initialize(ba,"edtGroupName");
 //BA.debugLineNum = 557;BA.debugLine="edtGroupName.Text = g.Name";
_edtgroupname.setText(BA.ObjectToCharSequence(_g._name /*String*/ ));
 //BA.debugLineNum = 558;BA.debugLine="edtGroupName.SingleLine = True";
_edtgroupname.setSingleLine(__c.True);
 //BA.debugLineNum = 559;BA.debugLine="edtGroupName.InputType = Bit.Or(1, 8192)";
_edtgroupname.setInputType(__c.Bit.Or((int) (1),(int) (8192)));
 //BA.debugLineNum = 560;BA.debugLine="edtGroupName.TextColor = Colors.White";
_edtgroupname.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 561;BA.debugLine="edtGroupName.HintColor = Colors.ARGB(120, 255, 25";
_edtgroupname.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 562;BA.debugLine="pnlName.AddView(edtGroupName, 8dip, 0, dialogW -";
_pnlname.AddView((android.view.View)(_edtgroupname.getObject()),__c.DipToCurrent((int) (8)),(int) (0),(int) (_dialogw-__c.DipToCurrent((int) (32))-__c.DipToCurrent((int) (16))),__c.DipToCurrent((int) (46)));
 //BA.debugLineNum = 565;BA.debugLine="Dim btnCancel As Button";
_btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 566;BA.debugLine="btnCancel.Initialize(\"btnDialogCancel\")";
_btncancel.Initialize(ba,"btnDialogCancel");
 //BA.debugLineNum = 567;BA.debugLine="btnCancel.Text = ModLang.T(\"cancel\")";
_btncancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 568;BA.debugLine="btnCancel.TextSize = 13";
_btncancel.setTextSize((float) (13));
 //BA.debugLineNum = 569;BA.debugLine="btnCancel.Color = Colors.Transparent";
_btncancel.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 570;BA.debugLine="btnCancel.TextColor = Colors.ARGB(200, 255, 255,";
_btncancel.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 571;BA.debugLine="pnlDialog.AddView(btnCancel, 16dip, 125dip, 100di";
_pnldialog.AddView((android.view.View)(_btncancel.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (125)),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 573;BA.debugLine="Dim btnOk As Button";
_btnok = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 574;BA.debugLine="btnOk.Initialize(\"btnDialogOk\")";
_btnok.Initialize(ba,"btnDialogOk");
 //BA.debugLineNum = 575;BA.debugLine="btnOk.Text = ModLang.T(\"save\")";
_btnok.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"save")));
 //BA.debugLineNum = 576;BA.debugLine="btnOk.TextSize = 13";
_btnok.setTextSize((float) (13));
 //BA.debugLineNum = 577;BA.debugLine="btnOk.Color = ModTheme.HomeIconBg";
_btnok.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 578;BA.debugLine="btnOk.TextColor = Colors.White";
_btnok.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 579;BA.debugLine="pnlDialog.AddView(btnOk, dialogW - 116dip, 125dip";
_pnldialog.AddView((android.view.View)(_btnok.getObject()),(int) (_dialogw-__c.DipToCurrent((int) (116))),__c.DipToCurrent((int) (125)),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 582;BA.debugLine="pnlDialog.SetLayoutAnimated(0, 20dip, 100dip, dia";
_pnldialog.SetLayoutAnimated((int) (0),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (100)),_dialogw,__c.DipToCurrent((int) (175)));
 //BA.debugLineNum = 585;BA.debugLine="pnlOverlay.Visible = True";
_pnloverlay.setVisible(__c.True);
 //BA.debugLineNum = 586;BA.debugLine="pnlOverlay.BringToFront";
_pnloverlay.BringToFront();
 //BA.debugLineNum = 587;BA.debugLine="edtGroupName.RequestFocus";
_edtgroupname.RequestFocus();
 //BA.debugLineNum = 588;BA.debugLine="End Sub";
return "";
}
public void  _showgroupoptions(String _groupid) throws Exception{
ResumableSub_ShowGroupOptions rsub = new ResumableSub_ShowGroupOptions(this,_groupid);
rsub.resume(ba, null);
}
public static class ResumableSub_ShowGroupOptions extends BA.ResumableSub {
public ResumableSub_ShowGroupOptions(com.lockzero.pagepasswords parent,String _groupid) {
this.parent = parent;
this._groupid = _groupid;
}
com.lockzero.pagepasswords parent;
String _groupid;
com.lockzero.clspasswordgroup _g = null;
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
 //BA.debugLineNum = 507;BA.debugLine="Dim g As clsPasswordGroup = ModPasswords.GetGroup";
_g = parent._modpasswords._getgroupbyid /*com.lockzero.clspasswordgroup*/ (ba,_groupid);
 //BA.debugLineNum = 508;BA.debugLine="If g.IsInitialized = False Then Return";
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
 //BA.debugLineNum = 510;BA.debugLine="Wait For (xui.Msgbox2Async(g.Name, \"\", ModLang.T(";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(_g._name /*String*/ ),BA.ObjectToCharSequence(""),parent._modlang._t /*String*/ (ba,"edit"),parent._modlang._t /*String*/ (ba,"delete"),parent._modlang._t /*String*/ (ba,"cancel"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 13;
return;
case 13:
//C
this.state = 7;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 512;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
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
 //BA.debugLineNum = 514;BA.debugLine="ShowEditGroupDialog(groupId)";
parent._showeditgroupdialog(_groupid);
 if (true) break;

case 11:
//C
this.state = 12;
 //BA.debugLineNum = 517;BA.debugLine="ConfirmDeleteGroup(groupId)";
parent._confirmdeletegroup(_groupid);
 if (true) break;

case 12:
//C
this.state = -1;
;
 //BA.debugLineNum = 519;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _showunlockgroupdialog(String _groupid) throws Exception{
com.lockzero.clspasswordgroup _g = null;
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
int _dialogh = 0;
 //BA.debugLineNum = 281;BA.debugLine="Private Sub ShowUnlockGroupDialog(groupId As Strin";
 //BA.debugLineNum = 282;BA.debugLine="Dim g As clsPasswordGroup = ModPasswords.GetGroup";
_g = _modpasswords._getgroupbyid /*com.lockzero.clspasswordgroup*/ (ba,_groupid);
 //BA.debugLineNum = 283;BA.debugLine="If g.IsInitialized = False Then Return";
if (_g._isinitialized /*boolean*/ ()==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 286;BA.debugLine="Dim remainingDelay As Int = ModSecurity.GetRemain";
_remainingdelay = _modsecurity._getremainingdelay /*int*/ (ba,_groupid);
 //BA.debugLineNum = 287;BA.debugLine="If remainingDelay > 0 Then";
if (_remainingdelay>0) { 
 //BA.debugLineNum = 288;BA.debugLine="Dim attempts As Int = ModSecurity.GetFailedAttem";
_attempts = _modsecurity._getfailedattempts /*int*/ (ba,_groupid);
 //BA.debugLineNum = 289;BA.debugLine="Dim timeStr As String = ModSecurity.FormatDelay(";
_timestr = _modsecurity._formatdelay /*String*/ (ba,_remainingdelay);
 //BA.debugLineNum = 290;BA.debugLine="ToastMessageShow(ModLang.T(\"wait_timeout\") & \" \"";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"wait_timeout")+" "+_timestr+" ("+BA.NumberToString(_attempts)+" "+_modlang._t /*String*/ (ba,"attempts")+")"),__c.True);
 //BA.debugLineNum = 291;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 294;BA.debugLine="CurrentDialogMode = \"unlock_group\"";
_currentdialogmode = "unlock_group";
 //BA.debugLineNum = 295;BA.debugLine="CurrentGroupId = groupId";
_currentgroupid = _groupid;
 //BA.debugLineNum = 296;BA.debugLine="IsPassVisible = False";
_ispassvisible = __c.False;
 //BA.debugLineNum = 299;BA.debugLine="Dim dialogW As Int = Root.Width - 40dip";
_dialogw = (int) (_root.getWidth()-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 300;BA.debugLine="pnlDialog.RemoveAllViews";
_pnldialog.RemoveAllViews();
 //BA.debugLineNum = 303;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 304;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 305;BA.debugLine="lblTitle.Text = g.Name";
_lbltitle.setText(BA.ObjectToCharSequence(_g._name /*String*/ ));
 //BA.debugLineNum = 306;BA.debugLine="lblTitle.TextSize = 16";
_lbltitle.setTextSize((float) (16));
 //BA.debugLineNum = 307;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 308;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 309;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 310;BA.debugLine="pnlDialog.AddView(lblTitle, 0, 12dip, dialogW, 24";
_pnldialog.AddView((android.view.View)(_lbltitle.getObject()),(int) (0),__c.DipToCurrent((int) (12)),_dialogw,__c.DipToCurrent((int) (24)));
 //BA.debugLineNum = 313;BA.debugLine="Dim lblSub As Label";
_lblsub = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 314;BA.debugLine="lblSub.Initialize(\"\")";
_lblsub.Initialize(ba,"");
 //BA.debugLineNum = 315;BA.debugLine="lblSub.Text = ModLang.T(\"enter_passphrase\")";
_lblsub.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"enter_passphrase")));
 //BA.debugLineNum = 316;BA.debugLine="lblSub.TextSize = 12";
_lblsub.setTextSize((float) (12));
 //BA.debugLineNum = 317;BA.debugLine="lblSub.TextColor = Colors.ARGB(180, 255, 255, 255";
_lblsub.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 318;BA.debugLine="lblSub.Gravity = Gravity.CENTER_HORIZONTAL";
_lblsub.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 319;BA.debugLine="pnlDialog.AddView(lblSub, 0, 36dip, dialogW, 20di";
_pnldialog.AddView((android.view.View)(_lblsub.getObject()),(int) (0),__c.DipToCurrent((int) (36)),_dialogw,__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 322;BA.debugLine="Dim pnlInput As Panel";
_pnlinput = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 323;BA.debugLine="pnlInput.Initialize(\"\")";
_pnlinput.Initialize(ba,"");
 //BA.debugLineNum = 324;BA.debugLine="pnlInput.Color = ModTheme.HomeBg";
_pnlinput.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 325;BA.debugLine="pnlDialog.AddView(pnlInput, 16dip, 65dip, dialogW";
_pnldialog.AddView((android.view.View)(_pnlinput.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (65)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 327;BA.debugLine="edtPassphrase.Initialize(\"edtPassphrase\")";
_edtpassphrase.Initialize(ba,"edtPassphrase");
 //BA.debugLineNum = 328;BA.debugLine="edtPassphrase.Hint = ModLang.T(\"passphrase_hint\")";
_edtpassphrase.setHint(_modlang._t /*String*/ (ba,"passphrase_hint"));
 //BA.debugLineNum = 329;BA.debugLine="edtPassphrase.SingleLine = True";
_edtpassphrase.setSingleLine(__c.True);
 //BA.debugLineNum = 330;BA.debugLine="edtPassphrase.InputType = Bit.Or(1, 128) 'TEXT +";
_edtpassphrase.setInputType(__c.Bit.Or((int) (1),(int) (128)));
 //BA.debugLineNum = 331;BA.debugLine="edtPassphrase.Text = \"\"";
_edtpassphrase.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 332;BA.debugLine="edtPassphrase.TextColor = Colors.White";
_edtpassphrase.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 333;BA.debugLine="edtPassphrase.HintColor = Colors.ARGB(120, 255, 2";
_edtpassphrase.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 334;BA.debugLine="pnlInput.AddView(edtPassphrase, 8dip, 0, dialogW";
_pnlinput.AddView((android.view.View)(_edtpassphrase.getObject()),__c.DipToCurrent((int) (8)),(int) (0),(int) (_dialogw-__c.DipToCurrent((int) (32))-__c.DipToCurrent((int) (56))),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 337;BA.debugLine="btnShowPass.Initialize(\"btnShowPass\")";
_btnshowpass.Initialize(ba,"btnShowPass");
 //BA.debugLineNum = 338;BA.debugLine="btnShowPass.Text = ModLang.T(\"view\")";
_btnshowpass.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"view")));
 //BA.debugLineNum = 339;BA.debugLine="btnShowPass.TextSize = Starter.FONT_CAPTION";
_btnshowpass.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 340;BA.debugLine="btnShowPass.Color = Colors.Transparent";
_btnshowpass.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 341;BA.debugLine="btnShowPass.TextColor = Colors.ARGB(200, 255, 255";
_btnshowpass.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 342;BA.debugLine="btnShowPass.Gravity = Gravity.CENTER";
_btnshowpass.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 343;BA.debugLine="pnlInput.AddView(btnShowPass, dialogW - 32dip - 6";
_pnlinput.AddView((android.view.View)(_btnshowpass.getObject()),(int) (_dialogw-__c.DipToCurrent((int) (32))-__c.DipToCurrent((int) (65))),__c.DipToCurrent((int) (5)),__c.DipToCurrent((int) (60)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 346;BA.debugLine="Dim attempts As Int = ModSecurity.GetFailedAttemp";
_attempts = _modsecurity._getfailedattempts /*int*/ (ba,_groupid);
 //BA.debugLineNum = 347;BA.debugLine="If attempts > 0 Then";
if (_attempts>0) { 
 //BA.debugLineNum = 348;BA.debugLine="Dim lblWarn As Label";
_lblwarn = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 349;BA.debugLine="lblWarn.Initialize(\"\")";
_lblwarn.Initialize(ba,"");
 //BA.debugLineNum = 350;BA.debugLine="lblWarn.Text = attempts & \" \" & ModLang.T(\"faile";
_lblwarn.setText(BA.ObjectToCharSequence(BA.NumberToString(_attempts)+" "+_modlang._t /*String*/ (ba,"failed_attempts")));
 //BA.debugLineNum = 351;BA.debugLine="lblWarn.TextSize = 11";
_lblwarn.setTextSize((float) (11));
 //BA.debugLineNum = 352;BA.debugLine="lblWarn.TextColor = ModTheme.Warning";
_lblwarn.setTextColor(_modtheme._warning /*int*/ (ba));
 //BA.debugLineNum = 353;BA.debugLine="lblWarn.Gravity = Gravity.CENTER_HORIZONTAL";
_lblwarn.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 354;BA.debugLine="pnlDialog.AddView(lblWarn, 0, 120dip, dialogW, 1";
_pnldialog.AddView((android.view.View)(_lblwarn.getObject()),(int) (0),__c.DipToCurrent((int) (120)),_dialogw,__c.DipToCurrent((int) (18)));
 };
 //BA.debugLineNum = 358;BA.debugLine="Dim btnCancel As Button";
_btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 359;BA.debugLine="btnCancel.Initialize(\"btnDialogCancel\")";
_btncancel.Initialize(ba,"btnDialogCancel");
 //BA.debugLineNum = 360;BA.debugLine="btnCancel.Text = ModLang.T(\"cancel\")";
_btncancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 361;BA.debugLine="btnCancel.TextSize = 13";
_btncancel.setTextSize((float) (13));
 //BA.debugLineNum = 362;BA.debugLine="btnCancel.Color = Colors.Transparent";
_btncancel.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 363;BA.debugLine="btnCancel.TextColor = Colors.ARGB(200, 255, 255,";
_btncancel.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 364;BA.debugLine="pnlDialog.AddView(btnCancel, 16dip, 145dip, 100di";
_pnldialog.AddView((android.view.View)(_btncancel.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (145)),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 366;BA.debugLine="Dim btnOk As Button";
_btnok = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 367;BA.debugLine="btnOk.Initialize(\"btnDialogOk\")";
_btnok.Initialize(ba,"btnDialogOk");
 //BA.debugLineNum = 368;BA.debugLine="btnOk.Text = ModLang.T(\"unlock\")";
_btnok.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"unlock")));
 //BA.debugLineNum = 369;BA.debugLine="btnOk.TextSize = 12";
_btnok.setTextSize((float) (12));
 //BA.debugLineNum = 370;BA.debugLine="btnOk.Color = ModTheme.HomeIconBg";
_btnok.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 371;BA.debugLine="btnOk.TextColor = Colors.White";
_btnok.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 372;BA.debugLine="pnlDialog.AddView(btnOk, dialogW - 130dip, 145dip";
_pnldialog.AddView((android.view.View)(_btnok.getObject()),(int) (_dialogw-__c.DipToCurrent((int) (130))),__c.DipToCurrent((int) (145)),__c.DipToCurrent((int) (114)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 375;BA.debugLine="Dim dialogH As Int = 195dip";
_dialogh = __c.DipToCurrent((int) (195));
 //BA.debugLineNum = 376;BA.debugLine="If attempts > 0 Then dialogH = 195dip";
if (_attempts>0) { 
_dialogh = __c.DipToCurrent((int) (195));};
 //BA.debugLineNum = 377;BA.debugLine="pnlDialog.SetLayoutAnimated(0, 20dip, 80dip, dial";
_pnldialog.SetLayoutAnimated((int) (0),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (80)),_dialogw,_dialogh);
 //BA.debugLineNum = 380;BA.debugLine="pnlOverlay.Visible = True";
_pnloverlay.setVisible(__c.True);
 //BA.debugLineNum = 381;BA.debugLine="pnlOverlay.BringToFront";
_pnloverlay.BringToFront();
 //BA.debugLineNum = 382;BA.debugLine="edtPassphrase.RequestFocus";
_edtpassphrase.RequestFocus();
 //BA.debugLineNum = 383;BA.debugLine="End Sub";
return "";
}
public String  _tmrsession_tick() throws Exception{
 //BA.debugLineNum = 746;BA.debugLine="Private Sub tmrSession_Tick";
 //BA.debugLineNum = 747;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 748;BA.debugLine="UpdateSessionTimer";
_updatesessiontimer();
 //BA.debugLineNum = 751;BA.debugLine="If ModSession.IsSessionActive = False Then";
if (_modsession._issessionactive /*boolean*/ (ba)==__c.False) { 
 //BA.debugLineNum = 752;BA.debugLine="tmrSession.Enabled = False";
_tmrsession.setEnabled(__c.False);
 //BA.debugLineNum = 753;BA.debugLine="B4XPages.ClosePage(Me)";
_b4xpages._closepage /*String*/ (ba,this);
 };
 //BA.debugLineNum = 755;BA.debugLine="End Sub";
return "";
}
public String  _updatesessiontimer() throws Exception{
int _remaining = 0;
 //BA.debugLineNum = 757;BA.debugLine="Private Sub UpdateSessionTimer";
 //BA.debugLineNum = 758;BA.debugLine="If ModSession.IsSessionActive Then";
if (_modsession._issessionactive /*boolean*/ (ba)) { 
 //BA.debugLineNum = 759;BA.debugLine="lblSessionTimer.Text = ModSession.GetRemainingFo";
_lblsessiontimer.setText(BA.ObjectToCharSequence(_modsession._getremainingformatted /*String*/ (ba)));
 //BA.debugLineNum = 762;BA.debugLine="Dim remaining As Int = ModSession.GetRemainingSe";
_remaining = _modsession._getremainingseconds /*int*/ (ba);
 //BA.debugLineNum = 763;BA.debugLine="If remaining < 60 Then";
if (_remaining<60) { 
 //BA.debugLineNum = 764;BA.debugLine="lblSessionTimer.TextColor = ModTheme.Warning";
_lblsessiontimer.setTextColor(_modtheme._warning /*int*/ (ba));
 }else {
 //BA.debugLineNum = 766;BA.debugLine="lblSessionTimer.TextColor = Colors.ARGB(200, 25";
_lblsessiontimer.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 };
 }else {
 //BA.debugLineNum = 769;BA.debugLine="lblSessionTimer.Text = \"00:00\"";
_lblsessiontimer.setText(BA.ObjectToCharSequence("00:00"));
 //BA.debugLineNum = 770;BA.debugLine="lblSessionTimer.TextColor = ModTheme.Danger";
_lblsessiontimer.setTextColor(_modtheme._danger /*int*/ (ba));
 };
 //BA.debugLineNum = 772;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
