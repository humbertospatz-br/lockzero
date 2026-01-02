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
public anywheresoftware.b4a.objects.LabelWrapper _lblsearch = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlsearchbar = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtsearch = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblclearsearch = null;
public boolean _issearchvisible = false;
public anywheresoftware.b4a.objects.collections.List _allgroups = null;
public anywheresoftware.b4a.objects.collections.List _filteredgroups = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnloverlay = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnldialog = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtgroupname = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtpassphrase = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtpassphraseconfirm = null;
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
 //BA.debugLineNum = 1078;BA.debugLine="Private Sub ApplyTheme";
 //BA.debugLineNum = 1079;BA.debugLine="Root.Color = ModTheme.HomeBg";
_root.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 1080;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_appear() throws Exception{
 //BA.debugLineNum = 52;BA.debugLine="Private Sub B4XPage_Appear";
 //BA.debugLineNum = 54;BA.debugLine="CallSub2(Main, \"SetPageTitle\", ModLang.T(\"passwor";
__c.CallSubNew2(ba,(Object)(_main.getObject()),"SetPageTitle",(Object)(_modlang._t /*String*/ (ba,"passwords")));
 //BA.debugLineNum = 56;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 57;BA.debugLine="LoadGroups";
_loadgroups();
 //BA.debugLineNum = 60;BA.debugLine="UpdateSessionTimer";
_updatesessiontimer();
 //BA.debugLineNum = 61;BA.debugLine="tmrSession.Enabled = True";
_tmrsession.setEnabled(__c.True);
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
 //BA.debugLineNum = 46;BA.debugLine="Private Sub B4XPage_Created(Root1 As B4XView)";
 //BA.debugLineNum = 47;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 48;BA.debugLine="CreateUI";
_createui();
 //BA.debugLineNum = 49;BA.debugLine="ApplyTheme";
_applytheme();
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_disappear() throws Exception{
 //BA.debugLineNum = 64;BA.debugLine="Private Sub B4XPage_Disappear";
 //BA.debugLineNum = 65;BA.debugLine="tmrSession.Enabled = False";
_tmrsession.setEnabled(__c.False);
 //BA.debugLineNum = 66;BA.debugLine="End Sub";
return "";
}
public String  _btnadd_click() throws Exception{
 //BA.debugLineNum = 402;BA.debugLine="Private Sub btnAdd_Click";
 //BA.debugLineNum = 403;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 404;BA.debugLine="ShowAddGroupDialog";
_showaddgroupdialog();
 //BA.debugLineNum = 405;BA.debugLine="End Sub";
return "";
}
public String  _btnback_click() throws Exception{
 //BA.debugLineNum = 371;BA.debugLine="Private Sub btnBack_Click";
 //BA.debugLineNum = 372;BA.debugLine="B4XPages.ClosePage(Me)";
_b4xpages._closepage /*String*/ (ba,this);
 //BA.debugLineNum = 373;BA.debugLine="End Sub";
return "";
}
public String  _btndialogcancel_click() throws Exception{
 //BA.debugLineNum = 946;BA.debugLine="Private Sub btnDialogCancel_Click";
 //BA.debugLineNum = 947;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 948;BA.debugLine="End Sub";
return "";
}
public String  _btndialogok_click() throws Exception{
 //BA.debugLineNum = 950;BA.debugLine="Private Sub btnDialogOk_Click";
 //BA.debugLineNum = 951;BA.debugLine="Select CurrentDialogMode";
switch (BA.switchObjectToInt(_currentdialogmode,"add_group","unlock_group","edit_group","delete_group")) {
case 0: {
 //BA.debugLineNum = 953;BA.debugLine="ProcessAddGroup";
_processaddgroup();
 break; }
case 1: {
 //BA.debugLineNum = 955;BA.debugLine="ProcessUnlockGroup";
_processunlockgroup();
 break; }
case 2: {
 //BA.debugLineNum = 957;BA.debugLine="ProcessEditGroup";
_processeditgroup();
 break; }
case 3: {
 //BA.debugLineNum = 959;BA.debugLine="ProcessDeleteGroup";
_processdeletegroup();
 break; }
}
;
 //BA.debugLineNum = 961;BA.debugLine="End Sub";
return "";
}
public String  _btnshowpass_click() throws Exception{
 //BA.debugLineNum = 931;BA.debugLine="Private Sub btnShowPass_Click";
 //BA.debugLineNum = 932;BA.debugLine="IsPassVisible = Not(IsPassVisible)";
_ispassvisible = __c.Not(_ispassvisible);
 //BA.debugLineNum = 933;BA.debugLine="If IsPassVisible Then";
if (_ispassvisible) { 
 //BA.debugLineNum = 934;BA.debugLine="edtPassphrase.InputType = ModSecurity.GetSecureV";
_edtpassphrase.setInputType(_modsecurity._getsecurevisibleinputtype /*int*/ (ba));
 //BA.debugLineNum = 935;BA.debugLine="btnShowPass.Text = ModLang.T(\"hide\")";
_btnshowpass.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"hide")));
 //BA.debugLineNum = 936;BA.debugLine="btnShowPass.TextColor = Colors.White";
_btnshowpass.setTextColor(__c.Colors.White);
 }else {
 //BA.debugLineNum = 938;BA.debugLine="edtPassphrase.InputType = ModSecurity.GetSecureP";
_edtpassphrase.setInputType(_modsecurity._getsecurepassphraseinputtype /*int*/ (ba));
 //BA.debugLineNum = 939;BA.debugLine="btnShowPass.Text = ModLang.T(\"view\")";
_btnshowpass.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"view")));
 //BA.debugLineNum = 940;BA.debugLine="btnShowPass.TextColor = Colors.ARGB(200, 255, 25";
_btnshowpass.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 };
 //BA.debugLineNum = 943;BA.debugLine="edtPassphrase.SelectionStart = edtPassphrase.Text";
_edtpassphrase.setSelectionStart(_edtpassphrase.getText().length());
 //BA.debugLineNum = 944;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 12;BA.debugLine="Private svGroups As ScrollView";
_svgroups = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Private pnlGroups As B4XView";
_pnlgroups = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private lblSearch As Label         'Icone de lupa";
_lblsearch = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private pnlSearchBar As Panel      'Barra de busc";
_pnlsearchbar = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private edtSearch As EditText      'Campo de busc";
_edtsearch = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private lblClearSearch As Label    'Botao X para";
_lblclearsearch = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private IsSearchVisible As Boolean = False";
_issearchvisible = __c.False;
 //BA.debugLineNum = 21;BA.debugLine="Private AllGroups As List          'Lista complet";
_allgroups = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 22;BA.debugLine="Private FilteredGroups As List     'Lista filtrad";
_filteredgroups = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 25;BA.debugLine="Private pnlOverlay As Panel";
_pnloverlay = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private pnlDialog As Panel";
_pnldialog = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private edtGroupName As EditText";
_edtgroupname = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private edtPassphrase As EditText";
_edtpassphrase = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private edtPassphraseConfirm As EditText";
_edtpassphraseconfirm = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private btnShowPass As Button";
_btnshowpass = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private IsPassVisible As Boolean = False";
_ispassvisible = __c.False;
 //BA.debugLineNum = 32;BA.debugLine="Private CurrentDialogMode As String = \"\" 'add_gro";
_currentdialogmode = "";
 //BA.debugLineNum = 33;BA.debugLine="Private CurrentGroupId As String = \"\"";
_currentgroupid = "";
 //BA.debugLineNum = 36;BA.debugLine="Private lblSessionTimer As Label";
_lblsessiontimer = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private tmrSession As Timer";
_tmrsession = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 807;BA.debugLine="Dim g As clsPasswordGroup = ModPasswords.GetGroup";
_g = parent._modpasswords._getgroupbyid /*com.lockzero.clspasswordgroup*/ (ba,_groupid);
 //BA.debugLineNum = 808;BA.debugLine="If g.IsInitialized = False Then Return";
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
 //BA.debugLineNum = 810;BA.debugLine="Dim count As Int = ModPasswords.GetEntryCountByGr";
_count = parent._modpasswords._getentrycountbygroup /*int*/ (ba,_groupid);
 //BA.debugLineNum = 811;BA.debugLine="Dim msg As String = ModLang.T(\"confirm_delete_msg";
_msg = parent._modlang._t /*String*/ (ba,"confirm_delete_msg");
 //BA.debugLineNum = 812;BA.debugLine="If count > 0 Then";
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
 //BA.debugLineNum = 813;BA.debugLine="msg = msg & CRLF & CRLF & count & \" \" & ModLang.";
_msg = _msg+parent.__c.CRLF+parent.__c.CRLF+BA.NumberToString(_count)+" "+parent._modlang._t /*String*/ (ba,"passwords")+" serao excluidas!";
 if (true) break;

case 10:
//C
this.state = 11;
;
 //BA.debugLineNum = 816;BA.debugLine="Wait For (xui.Msgbox2Async(msg, ModLang.T(\"confir";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(_msg),BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"confirm_delete")),parent._modlang._t /*String*/ (ba,"delete"),"",parent._modlang._t /*String*/ (ba,"cancel"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 15;
return;
case 15:
//C
this.state = 11;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 818;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
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
 //BA.debugLineNum = 820;BA.debugLine="ShowDeleteGroupDialog(groupId)";
parent._showdeletegroupdialog(_groupid);
 if (true) break;

case 14:
//C
this.state = -1;
;
 //BA.debugLineNum = 822;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 185;BA.debugLine="Private Sub CreateDialogOverlay";
 //BA.debugLineNum = 186;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 187;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 190;BA.debugLine="pnlOverlay.Initialize(\"pnlOverlay\")";
_pnloverlay.Initialize(ba,"pnlOverlay");
 //BA.debugLineNum = 191;BA.debugLine="pnlOverlay.Color = Colors.ARGB(180, 0, 0, 0)";
_pnloverlay.setColor(__c.Colors.ARGB((int) (180),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 192;BA.debugLine="pnlOverlay.Visible = False";
_pnloverlay.setVisible(__c.False);
 //BA.debugLineNum = 193;BA.debugLine="Root.AddView(pnlOverlay, 0, 0, width, height)";
_root.AddView((android.view.View)(_pnloverlay.getObject()),(int) (0),(int) (0),_width,_height);
 //BA.debugLineNum = 196;BA.debugLine="Dim dialogW As Int = width - 40dip";
_dialogw = (int) (_width-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 197;BA.debugLine="Dim dialogH As Int = 220dip";
_dialogh = __c.DipToCurrent((int) (220));
 //BA.debugLineNum = 198;BA.debugLine="Dim dialogX As Int = 20dip";
_dialogx = __c.DipToCurrent((int) (20));
 //BA.debugLineNum = 199;BA.debugLine="Dim dialogY As Int = 80dip 'Posicao alta para nao";
_dialogy = __c.DipToCurrent((int) (80));
 //BA.debugLineNum = 201;BA.debugLine="pnlDialog.Initialize(\"\")";
_pnldialog.Initialize(ba,"");
 //BA.debugLineNum = 202;BA.debugLine="pnlDialog.Color = ModTheme.HomeHeaderBg";
_pnldialog.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 203;BA.debugLine="pnlOverlay.AddView(pnlDialog, dialogX, dialogY, d";
_pnloverlay.AddView((android.view.View)(_pnldialog.getObject()),_dialogx,_dialogy,_dialogw,_dialogh);
 //BA.debugLineNum = 206;BA.debugLine="Dim xvDialog As B4XView = pnlDialog";
_xvdialog = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvdialog = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnldialog.getObject()));
 //BA.debugLineNum = 207;BA.debugLine="xvDialog.SetColorAndBorder(ModTheme.HomeHeaderBg,";
_xvdialog.SetColorAndBorder(_modtheme._homeheaderbg /*int*/ (ba),(int) (0),_modtheme._homeheaderbg /*int*/ (ba),__c.DipToCurrent((int) (12)));
 //BA.debugLineNum = 208;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _createlabel(String _text,float _size,boolean _bold) throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
 //BA.debugLineNum = 210;BA.debugLine="Private Sub CreateLabel(text As String, size As Fl";
 //BA.debugLineNum = 211;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 212;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(ba,"");
 //BA.debugLineNum = 213;BA.debugLine="lbl.Text = text";
_lbl.setText(BA.ObjectToCharSequence(_text));
 //BA.debugLineNum = 214;BA.debugLine="lbl.TextSize = size";
_lbl.setTextSize(_size);
 //BA.debugLineNum = 215;BA.debugLine="lbl.Gravity = Gravity.CENTER";
_lbl.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 216;BA.debugLine="If bold Then";
if (_bold) { 
 //BA.debugLineNum = 217;BA.debugLine="lbl.Typeface = Typeface.CreateNew(Typeface.DEFAU";
_lbl.setTypeface(__c.Typeface.CreateNew(__c.Typeface.DEFAULT,__c.Typeface.STYLE_BOLD));
 };
 //BA.debugLineNum = 219;BA.debugLine="Return lbl";
if (true) return (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 220;BA.debugLine="End Sub";
return null;
}
public String  _createui() throws Exception{
int _width = 0;
int _height = 0;
int _headerh = 0;
int _searchh = 0;
anywheresoftware.b4a.objects.PanelWrapper _pnlheader = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xvsearch = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xvtimer = null;
anywheresoftware.b4a.objects.LabelWrapper _lbladd = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xvadd = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlsearchinput = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xvsearchinput = null;
 //BA.debugLineNum = 72;BA.debugLine="Private Sub CreateUI";
 //BA.debugLineNum = 73;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 74;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 75;BA.debugLine="Dim headerH As Int = 56dip";
_headerh = __c.DipToCurrent((int) (56));
 //BA.debugLineNum = 76;BA.debugLine="Dim searchH As Int = 54dip";
_searchh = __c.DipToCurrent((int) (54));
 //BA.debugLineNum = 79;BA.debugLine="Dim pnlHeader As Panel";
_pnlheader = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 80;BA.debugLine="pnlHeader.Initialize(\"\")";
_pnlheader.Initialize(ba,"");
 //BA.debugLineNum = 81;BA.debugLine="pnlHeader.Color = ModTheme.HomeHeaderBg";
_pnlheader.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 82;BA.debugLine="Root.AddView(pnlHeader, 0, 0, width, headerH)";
_root.AddView((android.view.View)(_pnlheader.getObject()),(int) (0),(int) (0),_width,_headerh);
 //BA.debugLineNum = 85;BA.debugLine="btnBack.Initialize(\"btnBack\")";
_btnback.Initialize(ba,"btnBack");
 //BA.debugLineNum = 86;BA.debugLine="btnBack.Text = \"<\"";
_btnback.setText(BA.ObjectToCharSequence("<"));
 //BA.debugLineNum = 87;BA.debugLine="btnBack.TextSize = 20";
_btnback.setTextSize((float) (20));
 //BA.debugLineNum = 88;BA.debugLine="btnBack.Color = Colors.Transparent";
_btnback.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 89;BA.debugLine="btnBack.TextColor = Colors.White";
_btnback.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 90;BA.debugLine="btnBack.Gravity = Gravity.CENTER";
_btnback.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 91;BA.debugLine="pnlHeader.AddView(btnBack, 0, 0, 50dip, headerH)";
_pnlheader.AddView((android.view.View)(_btnback.getObject()),(int) (0),(int) (0),__c.DipToCurrent((int) (50)),_headerh);
 //BA.debugLineNum = 94;BA.debugLine="lblHeaderTitle.Initialize(\"\")";
_lblheadertitle.Initialize(ba,"");
 //BA.debugLineNum = 95;BA.debugLine="lblHeaderTitle.Text = ModLang.T(\"passwords\")";
_lblheadertitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"passwords")));
 //BA.debugLineNum = 96;BA.debugLine="lblHeaderTitle.TextSize = 16";
_lblheadertitle.setTextSize((float) (16));
 //BA.debugLineNum = 97;BA.debugLine="lblHeaderTitle.TextColor = Colors.White";
_lblheadertitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 98;BA.debugLine="lblHeaderTitle.Typeface = Typeface.DEFAULT_BOLD";
_lblheadertitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 99;BA.debugLine="lblHeaderTitle.Gravity = Gravity.CENTER_VERTICAL";
_lblheadertitle.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 100;BA.debugLine="pnlHeader.AddView(lblHeaderTitle, 50dip, 0, width";
_pnlheader.AddView((android.view.View)(_lblheadertitle.getObject()),__c.DipToCurrent((int) (50)),(int) (0),(int) (_width-__c.DipToCurrent((int) (200))),_headerh);
 //BA.debugLineNum = 103;BA.debugLine="lblSearch.Initialize(\"lblSearch\")";
_lblsearch.Initialize(ba,"lblSearch");
 //BA.debugLineNum = 104;BA.debugLine="lblSearch.Text = Chr(0xD83D) & Chr(0xDD0D)  '🔍 (";
_lblsearch.setText(BA.ObjectToCharSequence(BA.ObjectToString(__c.Chr(((int)0xd83d)))+BA.ObjectToString(__c.Chr(((int)0xdd0d)))));
 //BA.debugLineNum = 105;BA.debugLine="lblSearch.TextSize = 18";
_lblsearch.setTextSize((float) (18));
 //BA.debugLineNum = 106;BA.debugLine="lblSearch.TextColor = Colors.White";
_lblsearch.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 107;BA.debugLine="lblSearch.Gravity = Gravity.CENTER";
_lblsearch.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 108;BA.debugLine="pnlHeader.AddView(lblSearch, width - 130dip, 8dip";
_pnlheader.AddView((android.view.View)(_lblsearch.getObject()),(int) (_width-__c.DipToCurrent((int) (130))),__c.DipToCurrent((int) (8)),__c.DipToCurrent((int) (40)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 111;BA.debugLine="Dim xvSearch As B4XView = lblSearch";
_xvsearch = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvsearch = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lblsearch.getObject()));
 //BA.debugLineNum = 112;BA.debugLine="xvSearch.SetColorAndBorder(Colors.ARGB(60, 255, 2";
_xvsearch.SetColorAndBorder(__c.Colors.ARGB((int) (60),(int) (255),(int) (255),(int) (255)),(int) (0),__c.Colors.Transparent,__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 115;BA.debugLine="lblSessionTimer.Initialize(\"lblSessionTimer\")";
_lblsessiontimer.Initialize(ba,"lblSessionTimer");
 //BA.debugLineNum = 116;BA.debugLine="lblSessionTimer.Text = \"00:00\"";
_lblsessiontimer.setText(BA.ObjectToCharSequence("00:00"));
 //BA.debugLineNum = 117;BA.debugLine="lblSessionTimer.TextSize = 12";
_lblsessiontimer.setTextSize((float) (12));
 //BA.debugLineNum = 118;BA.debugLine="lblSessionTimer.TextColor = Colors.ARGB(200, 255,";
_lblsessiontimer.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 119;BA.debugLine="lblSessionTimer.Gravity = Gravity.CENTER";
_lblsessiontimer.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 120;BA.debugLine="pnlHeader.AddView(lblSessionTimer, width - 90dip,";
_pnlheader.AddView((android.view.View)(_lblsessiontimer.getObject()),(int) (_width-__c.DipToCurrent((int) (90))),__c.DipToCurrent((int) (12)),__c.DipToCurrent((int) (40)),__c.DipToCurrent((int) (32)));
 //BA.debugLineNum = 123;BA.debugLine="Dim xvTimer As B4XView = lblSessionTimer";
_xvtimer = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvtimer = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lblsessiontimer.getObject()));
 //BA.debugLineNum = 124;BA.debugLine="xvTimer.SetColorAndBorder(Colors.ARGB(60, 255, 25";
_xvtimer.SetColorAndBorder(__c.Colors.ARGB((int) (60),(int) (255),(int) (255),(int) (255)),(int) (0),__c.Colors.Transparent,__c.DipToCurrent((int) (8)));
 //BA.debugLineNum = 127;BA.debugLine="Dim lblAdd As Label";
_lbladd = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 128;BA.debugLine="lblAdd.Initialize(\"btnAdd\")";
_lbladd.Initialize(ba,"btnAdd");
 //BA.debugLineNum = 129;BA.debugLine="lblAdd.Text = \"+\"";
_lbladd.setText(BA.ObjectToCharSequence("+"));
 //BA.debugLineNum = 130;BA.debugLine="lblAdd.TextSize = 26";
_lbladd.setTextSize((float) (26));
 //BA.debugLineNum = 131;BA.debugLine="lblAdd.Typeface = Typeface.DEFAULT_BOLD";
_lbladd.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 132;BA.debugLine="lblAdd.Gravity = Gravity.CENTER";
_lbladd.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 133;BA.debugLine="lblAdd.TextColor = Colors.White";
_lbladd.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 134;BA.debugLine="pnlHeader.AddView(lblAdd, width - 50dip, 8dip, 40";
_pnlheader.AddView((android.view.View)(_lbladd.getObject()),(int) (_width-__c.DipToCurrent((int) (50))),__c.DipToCurrent((int) (8)),__c.DipToCurrent((int) (40)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 137;BA.debugLine="Dim xvAdd As B4XView = lblAdd";
_xvadd = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvadd = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbladd.getObject()));
 //BA.debugLineNum = 138;BA.debugLine="xvAdd.SetColorAndBorder(ModTheme.HomeIconBg, 0, M";
_xvadd.SetColorAndBorder(_modtheme._homeiconbg /*int*/ (ba),(int) (0),_modtheme._homeiconbg /*int*/ (ba),__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 141;BA.debugLine="pnlSearchBar.Initialize(\"\")";
_pnlsearchbar.Initialize(ba,"");
 //BA.debugLineNum = 142;BA.debugLine="pnlSearchBar.Color = ModTheme.HomeBg";
_pnlsearchbar.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 143;BA.debugLine="pnlSearchBar.Visible = False";
_pnlsearchbar.setVisible(__c.False);
 //BA.debugLineNum = 144;BA.debugLine="Root.AddView(pnlSearchBar, 0, headerH, width, sea";
_root.AddView((android.view.View)(_pnlsearchbar.getObject()),(int) (0),_headerh,_width,_searchh);
 //BA.debugLineNum = 147;BA.debugLine="Dim pnlSearchInput As Panel";
_pnlsearchinput = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 148;BA.debugLine="pnlSearchInput.Initialize(\"\")";
_pnlsearchinput.Initialize(ba,"");
 //BA.debugLineNum = 149;BA.debugLine="pnlSearchInput.Color = ModTheme.HomeIconBg";
_pnlsearchinput.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 150;BA.debugLine="pnlSearchBar.AddView(pnlSearchInput, 16dip, 5dip,";
_pnlsearchbar.AddView((android.view.View)(_pnlsearchinput.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (5)),(int) (_width-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 152;BA.debugLine="Dim xvSearchInput As B4XView = pnlSearchInput";
_xvsearchinput = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvsearchinput = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnlsearchinput.getObject()));
 //BA.debugLineNum = 153;BA.debugLine="xvSearchInput.SetColorAndBorder(ModTheme.HomeIcon";
_xvsearchinput.SetColorAndBorder(_modtheme._homeiconbg /*int*/ (ba),(int) (0),_modtheme._homeiconbg /*int*/ (ba),__c.DipToCurrent((int) (8)));
 //BA.debugLineNum = 155;BA.debugLine="edtSearch.Initialize(\"edtSearch\")";
_edtsearch.Initialize(ba,"edtSearch");
 //BA.debugLineNum = 156;BA.debugLine="edtSearch.Hint = ModLang.T(\"search\") & \"...\"";
_edtsearch.setHint(_modlang._t /*String*/ (ba,"search")+"...");
 //BA.debugLineNum = 157;BA.debugLine="edtSearch.SingleLine = True";
_edtsearch.setSingleLine(__c.True);
 //BA.debugLineNum = 158;BA.debugLine="edtSearch.Text = \"\"";
_edtsearch.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 159;BA.debugLine="edtSearch.TextSize = Starter.FONT_BODY";
_edtsearch.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 160;BA.debugLine="edtSearch.TextColor = Colors.White";
_edtsearch.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 161;BA.debugLine="edtSearch.HintColor = Colors.ARGB(120, 255, 255,";
_edtsearch.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 162;BA.debugLine="pnlSearchInput.AddView(edtSearch, 12dip, 0, width";
_pnlsearchinput.AddView((android.view.View)(_edtsearch.getObject()),__c.DipToCurrent((int) (12)),(int) (0),(int) (_width-__c.DipToCurrent((int) (100))),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 165;BA.debugLine="lblClearSearch.Initialize(\"lblClearSearch\")";
_lblclearsearch.Initialize(ba,"lblClearSearch");
 //BA.debugLineNum = 166;BA.debugLine="lblClearSearch.Text = \"X\"";
_lblclearsearch.setText(BA.ObjectToCharSequence("X"));
 //BA.debugLineNum = 167;BA.debugLine="lblClearSearch.TextSize = 16";
_lblclearsearch.setTextSize((float) (16));
 //BA.debugLineNum = 168;BA.debugLine="lblClearSearch.TextColor = Colors.ARGB(180, 255,";
_lblclearsearch.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 169;BA.debugLine="lblClearSearch.Gravity = Gravity.CENTER";
_lblclearsearch.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 170;BA.debugLine="lblClearSearch.Visible = False";
_lblclearsearch.setVisible(__c.False);
 //BA.debugLineNum = 171;BA.debugLine="pnlSearchInput.AddView(lblClearSearch, width - 80";
_pnlsearchinput.AddView((android.view.View)(_lblclearsearch.getObject()),(int) (_width-__c.DipToCurrent((int) (80))),__c.DipToCurrent((int) (2)),__c.DipToCurrent((int) (40)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 174;BA.debugLine="svGroups.Initialize(0)";
_svgroups.Initialize(ba,(int) (0));
 //BA.debugLineNum = 175;BA.debugLine="svGroups.Color = ModTheme.HomeBg";
_svgroups.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 176;BA.debugLine="Root.AddView(svGroups, 0, headerH, width, height";
_root.AddView((android.view.View)(_svgroups.getObject()),(int) (0),_headerh,_width,(int) (_height-_headerh));
 //BA.debugLineNum = 178;BA.debugLine="pnlGroups = svGroups.Panel";
_pnlgroups = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_svgroups.getPanel().getObject()));
 //BA.debugLineNum = 179;BA.debugLine="pnlGroups.Color = ModTheme.HomeBg";
_pnlgroups.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 182;BA.debugLine="CreateDialogOverlay";
_createdialogoverlay();
 //BA.debugLineNum = 183;BA.debugLine="End Sub";
return "";
}
public String  _displaygroups() throws Exception{
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
 //BA.debugLineNum = 285;BA.debugLine="Private Sub DisplayGroups";
 //BA.debugLineNum = 286;BA.debugLine="pnlGroups.RemoveAllViews";
_pnlgroups.RemoveAllViews();
 //BA.debugLineNum = 288;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 289;BA.debugLine="Dim itemHeight As Int = 70dip";
_itemheight = __c.DipToCurrent((int) (70));
 //BA.debugLineNum = 290;BA.debugLine="Dim y As Int = 16dip";
_y = __c.DipToCurrent((int) (16));
 //BA.debugLineNum = 292;BA.debugLine="If FilteredGroups.Size = 0 Then";
if (_filteredgroups.getSize()==0) { 
 //BA.debugLineNum = 294;BA.debugLine="Dim lblEmpty As B4XView = CreateLabel(ModLang.T(";
_lblempty = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lblempty = _createlabel(_modlang._t /*String*/ (ba,"empty"),(float) (14),__c.False);
 //BA.debugLineNum = 295;BA.debugLine="lblEmpty.TextColor = Colors.ARGB(150, 255, 255,";
_lblempty.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 296;BA.debugLine="pnlGroups.AddView(lblEmpty, 0, 100dip, width, 40";
_pnlgroups.AddView((android.view.View)(_lblempty.getObject()),(int) (0),__c.DipToCurrent((int) (100)),_width,__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 297;BA.debugLine="pnlGroups.Height = 200dip";
_pnlgroups.setHeight(__c.DipToCurrent((int) (200)));
 //BA.debugLineNum = 298;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 301;BA.debugLine="For Each g As clsPasswordGroup In FilteredGroups";
{
final anywheresoftware.b4a.BA.IterableList group12 = _filteredgroups;
final int groupLen12 = group12.getSize()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_g = (com.lockzero.clspasswordgroup)(group12.Get(index12));
 //BA.debugLineNum = 302;BA.debugLine="Dim pnlItem As Panel";
_pnlitem = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 303;BA.debugLine="pnlItem.Initialize(\"pnlGroup\")";
_pnlitem.Initialize(ba,"pnlGroup");
 //BA.debugLineNum = 304;BA.debugLine="pnlItem.Tag = g.Id";
_pnlitem.setTag((Object)(_g._id /*String*/ ));
 //BA.debugLineNum = 307;BA.debugLine="Dim xvItem As B4XView = pnlItem";
_xvitem = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvitem = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnlitem.getObject()));
 //BA.debugLineNum = 308;BA.debugLine="xvItem.SetColorAndBorder(ModTheme.HomeIconBg, 0,";
_xvitem.SetColorAndBorder(_modtheme._homeiconbg /*int*/ (ba),(int) (0),_modtheme._homeiconbg /*int*/ (ba),__c.DipToCurrent((int) (12)));
 //BA.debugLineNum = 309;BA.debugLine="pnlGroups.AddView(pnlItem, 16dip, y, width - 32d";
_pnlgroups.AddView((android.view.View)(_pnlitem.getObject()),__c.DipToCurrent((int) (16)),_y,(int) (_width-__c.DipToCurrent((int) (32))),_itemheight);
 //BA.debugLineNum = 312;BA.debugLine="Dim lblName As Label";
_lblname = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 313;BA.debugLine="lblName.Initialize(\"\")";
_lblname.Initialize(ba,"");
 //BA.debugLineNum = 314;BA.debugLine="lblName.Text = g.Name";
_lblname.setText(BA.ObjectToCharSequence(_g._name /*String*/ ));
 //BA.debugLineNum = 315;BA.debugLine="lblName.TextSize = 16";
_lblname.setTextSize((float) (16));
 //BA.debugLineNum = 316;BA.debugLine="lblName.TextColor = Colors.White";
_lblname.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 317;BA.debugLine="lblName.Typeface = Typeface.DEFAULT_BOLD";
_lblname.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 318;BA.debugLine="lblName.Gravity = Gravity.CENTER_VERTICAL";
_lblname.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 319;BA.debugLine="pnlItem.AddView(lblName, 16dip, 0, width - 140di";
_pnlitem.AddView((android.view.View)(_lblname.getObject()),__c.DipToCurrent((int) (16)),(int) (0),(int) (_width-__c.DipToCurrent((int) (140))),_itemheight);
 //BA.debugLineNum = 322;BA.debugLine="Dim count As Int = ModPasswords.GetEntryCountByG";
_count = _modpasswords._getentrycountbygroup /*int*/ (ba,_g._id /*String*/ );
 //BA.debugLineNum = 323;BA.debugLine="Dim lblCount As Label";
_lblcount = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 324;BA.debugLine="lblCount.Initialize(\"\")";
_lblcount.Initialize(ba,"");
 //BA.debugLineNum = 325;BA.debugLine="lblCount.Text = count";
_lblcount.setText(BA.ObjectToCharSequence(_count));
 //BA.debugLineNum = 326;BA.debugLine="lblCount.TextSize = 14";
_lblcount.setTextSize((float) (14));
 //BA.debugLineNum = 327;BA.debugLine="lblCount.TextColor = Colors.ARGB(180, 255, 255,";
_lblcount.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 328;BA.debugLine="lblCount.Gravity = Gravity.CENTER";
_lblcount.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 329;BA.debugLine="pnlItem.AddView(lblCount, width - 110dip, 0, 40d";
_pnlitem.AddView((android.view.View)(_lblcount.getObject()),(int) (_width-__c.DipToCurrent((int) (110))),(int) (0),__c.DipToCurrent((int) (40)),_itemheight);
 //BA.debugLineNum = 332;BA.debugLine="Dim lblArrow As Label";
_lblarrow = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 333;BA.debugLine="lblArrow.Initialize(\"\")";
_lblarrow.Initialize(ba,"");
 //BA.debugLineNum = 334;BA.debugLine="lblArrow.Text = \">\"";
_lblarrow.setText(BA.ObjectToCharSequence(">"));
 //BA.debugLineNum = 335;BA.debugLine="lblArrow.TextSize = 18";
_lblarrow.setTextSize((float) (18));
 //BA.debugLineNum = 336;BA.debugLine="lblArrow.TextColor = Colors.ARGB(150, 255, 255,";
_lblarrow.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 337;BA.debugLine="lblArrow.Gravity = Gravity.CENTER";
_lblarrow.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 338;BA.debugLine="pnlItem.AddView(lblArrow, width - 70dip, 0, 30di";
_pnlitem.AddView((android.view.View)(_lblarrow.getObject()),(int) (_width-__c.DipToCurrent((int) (70))),(int) (0),__c.DipToCurrent((int) (30)),_itemheight);
 //BA.debugLineNum = 340;BA.debugLine="y = y + itemHeight + 12dip";
_y = (int) (_y+_itemheight+__c.DipToCurrent((int) (12)));
 }
};
 //BA.debugLineNum = 343;BA.debugLine="pnlGroups.Height = y + 20dip";
_pnlgroups.setHeight((int) (_y+__c.DipToCurrent((int) (20))));
 //BA.debugLineNum = 344;BA.debugLine="End Sub";
return "";
}
public String  _edtsearch_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 388;BA.debugLine="Private Sub edtSearch_TextChanged(Old As String, N";
 //BA.debugLineNum = 389;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 390;BA.debugLine="FilterGroups(New)";
_filtergroups(_new);
 //BA.debugLineNum = 392;BA.debugLine="lblClearSearch.Visible = (New.Length > 0)";
_lblclearsearch.setVisible((_new.length()>0));
 //BA.debugLineNum = 393;BA.debugLine="End Sub";
return "";
}
public String  _filtergroups(String _query) throws Exception{
String _q = "";
com.lockzero.clspasswordgroup _g = null;
boolean _found = false;
anywheresoftware.b4a.objects.collections.List _entries = null;
com.lockzero.clspasswordentry _e = null;
 //BA.debugLineNum = 247;BA.debugLine="Private Sub FilterGroups(query As String)";
 //BA.debugLineNum = 248;BA.debugLine="FilteredGroups.Initialize";
_filteredgroups.Initialize();
 //BA.debugLineNum = 249;BA.debugLine="Dim q As String = query.ToLowerCase.Trim";
_q = _query.toLowerCase().trim();
 //BA.debugLineNum = 251;BA.debugLine="If q.Length = 0 Then";
if (_q.length()==0) { 
 //BA.debugLineNum = 253;BA.debugLine="For Each g As clsPasswordGroup In AllGroups";
{
final anywheresoftware.b4a.BA.IterableList group4 = _allgroups;
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_g = (com.lockzero.clspasswordgroup)(group4.Get(index4));
 //BA.debugLineNum = 254;BA.debugLine="FilteredGroups.Add(g)";
_filteredgroups.Add((Object)(_g));
 }
};
 }else {
 //BA.debugLineNum = 258;BA.debugLine="For Each g As clsPasswordGroup In AllGroups";
{
final anywheresoftware.b4a.BA.IterableList group8 = _allgroups;
final int groupLen8 = group8.getSize()
;int index8 = 0;
;
for (; index8 < groupLen8;index8++){
_g = (com.lockzero.clspasswordgroup)(group8.Get(index8));
 //BA.debugLineNum = 259;BA.debugLine="Dim found As Boolean = False";
_found = __c.False;
 //BA.debugLineNum = 262;BA.debugLine="If g.Name.ToLowerCase.Contains(q) Then";
if (_g._name /*String*/ .toLowerCase().contains(_q)) { 
 //BA.debugLineNum = 263;BA.debugLine="found = True";
_found = __c.True;
 };
 //BA.debugLineNum = 267;BA.debugLine="If found = False Then";
if (_found==__c.False) { 
 //BA.debugLineNum = 268;BA.debugLine="Dim entries As List = ModPasswords.GetEntriesB";
_entries = new anywheresoftware.b4a.objects.collections.List();
_entries = _modpasswords._getentriesbygroup /*anywheresoftware.b4a.objects.collections.List*/ (ba,_g._id /*String*/ );
 //BA.debugLineNum = 269;BA.debugLine="For Each e As clsPasswordEntry In entries";
{
final anywheresoftware.b4a.BA.IterableList group15 = _entries;
final int groupLen15 = group15.getSize()
;int index15 = 0;
;
for (; index15 < groupLen15;index15++){
_e = (com.lockzero.clspasswordentry)(group15.Get(index15));
 //BA.debugLineNum = 270;BA.debugLine="If e.Name.ToLowerCase.Contains(q) Or e.Url.To";
if (_e._name /*String*/ .toLowerCase().contains(_q) || _e._url /*String*/ .toLowerCase().contains(_q)) { 
 //BA.debugLineNum = 271;BA.debugLine="found = True";
_found = __c.True;
 //BA.debugLineNum = 272;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 };
 //BA.debugLineNum = 277;BA.debugLine="If found Then FilteredGroups.Add(g)";
if (_found) { 
_filteredgroups.Add((Object)(_g));};
 }
};
 };
 //BA.debugLineNum = 281;BA.debugLine="DisplayGroups";
_displaygroups();
 //BA.debugLineNum = 282;BA.debugLine="End Sub";
return "";
}
public String  _hidedialog() throws Exception{
anywheresoftware.b4a.objects.IME _ime = null;
 //BA.debugLineNum = 963;BA.debugLine="Private Sub HideDialog";
 //BA.debugLineNum = 964;BA.debugLine="pnlOverlay.Visible = False";
_pnloverlay.setVisible(__c.False);
 //BA.debugLineNum = 965;BA.debugLine="CurrentDialogMode = \"\"";
_currentdialogmode = "";
 //BA.debugLineNum = 967;BA.debugLine="Dim ime As IME";
_ime = new anywheresoftware.b4a.objects.IME();
 //BA.debugLineNum = 968;BA.debugLine="ime.Initialize(\"\")";
_ime.Initialize("");
 //BA.debugLineNum = 969;BA.debugLine="ime.HideKeyboard";
_ime.HideKeyboard(ba);
 //BA.debugLineNum = 970;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 40;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 41;BA.debugLine="tmrSession.Initialize(\"tmrSession\", 1000)";
_tmrsession.Initialize(ba,"tmrSession",(long) (1000));
 //BA.debugLineNum = 42;BA.debugLine="AllGroups.Initialize";
_allgroups.Initialize();
 //BA.debugLineNum = 43;BA.debugLine="FilteredGroups.Initialize";
_filteredgroups.Initialize();
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return "";
}
public String  _lblclearsearch_click() throws Exception{
 //BA.debugLineNum = 396;BA.debugLine="Private Sub lblClearSearch_Click";
 //BA.debugLineNum = 397;BA.debugLine="edtSearch.Text = \"\"";
_edtsearch.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 398;BA.debugLine="lblClearSearch.Visible = False";
_lblclearsearch.setVisible(__c.False);
 //BA.debugLineNum = 399;BA.debugLine="FilterGroups(\"\")";
_filtergroups("");
 //BA.debugLineNum = 400;BA.debugLine="End Sub";
return "";
}
public String  _lblsearch_click() throws Exception{
 //BA.debugLineNum = 376;BA.debugLine="Private Sub lblSearch_Click";
 //BA.debugLineNum = 377;BA.debugLine="IsSearchVisible = Not(IsSearchVisible)";
_issearchvisible = __c.Not(_issearchvisible);
 //BA.debugLineNum = 378;BA.debugLine="UpdateSearchVisibility";
_updatesearchvisibility();
 //BA.debugLineNum = 380;BA.debugLine="If IsSearchVisible = False Then";
if (_issearchvisible==__c.False) { 
 //BA.debugLineNum = 382;BA.debugLine="edtSearch.Text = \"\"";
_edtsearch.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 383;BA.debugLine="FilterGroups(\"\")";
_filtergroups("");
 };
 //BA.debugLineNum = 385;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 1110;BA.debugLine="Wait For (xui.Msgbox2Async(ModLang.T(\"lock_confir";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"lock_confirm_msg")),BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"lock")),parent._modlang._t /*String*/ (ba,"yes"),"",parent._modlang._t /*String*/ (ba,"cancel"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 1112;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
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
 //BA.debugLineNum = 1113;BA.debugLine="tmrSession.Enabled = False";
parent._tmrsession.setEnabled(parent.__c.False);
 //BA.debugLineNum = 1114;BA.debugLine="ModSession.EndSession";
parent._modsession._endsession /*String*/ (ba);
 //BA.debugLineNum = 1115;BA.debugLine="B4XPages.ClosePage(Me)";
parent._b4xpages._closepage /*String*/ (ba,parent);
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 1117;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _loadgroups() throws Exception{
com.lockzero.clspasswordgroup _g = null;
 //BA.debugLineNum = 226;BA.debugLine="Private Sub LoadGroups";
 //BA.debugLineNum = 227;BA.debugLine="ModPasswords.Init";
_modpasswords._init /*String*/ (ba);
 //BA.debugLineNum = 230;BA.debugLine="AllGroups = ModPasswords.GetAllGroups";
_allgroups = _modpasswords._getallgroups /*anywheresoftware.b4a.objects.collections.List*/ (ba);
 //BA.debugLineNum = 233;BA.debugLine="edtSearch.Text = \"\"";
_edtsearch.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 234;BA.debugLine="FilteredGroups.Initialize";
_filteredgroups.Initialize();
 //BA.debugLineNum = 235;BA.debugLine="For Each g As clsPasswordGroup In AllGroups";
{
final anywheresoftware.b4a.BA.IterableList group5 = _allgroups;
final int groupLen5 = group5.getSize()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_g = (com.lockzero.clspasswordgroup)(group5.Get(index5));
 //BA.debugLineNum = 236;BA.debugLine="FilteredGroups.Add(g)";
_filteredgroups.Add((Object)(_g));
 }
};
 //BA.debugLineNum = 240;BA.debugLine="IsSearchVisible = False";
_issearchvisible = __c.False;
 //BA.debugLineNum = 241;BA.debugLine="UpdateSearchVisibility";
_updatesearchvisibility();
 //BA.debugLineNum = 243;BA.debugLine="DisplayGroups";
_displaygroups();
 //BA.debugLineNum = 244;BA.debugLine="End Sub";
return "";
}
public String  _navigatetogroup(String _groupid) throws Exception{
anywheresoftware.b4a.objects.collections.Map _params = null;
com.lockzero.pagepasswordlist _pg = null;
 //BA.debugLineNum = 547;BA.debugLine="Private Sub NavigateToGroup(groupId As String)";
 //BA.debugLineNum = 548;BA.debugLine="Dim params As Map";
_params = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 549;BA.debugLine="params.Initialize";
_params.Initialize();
 //BA.debugLineNum = 550;BA.debugLine="params.Put(\"groupId\", groupId)";
_params.Put((Object)("groupId"),(Object)(_groupid));
 //BA.debugLineNum = 552;BA.debugLine="If edtSearch.Text.Trim.Length > 0 Then";
if (_edtsearch.getText().trim().length()>0) { 
 //BA.debugLineNum = 553;BA.debugLine="params.Put(\"searchQuery\", edtSearch.Text.Trim)";
_params.Put((Object)("searchQuery"),(Object)(_edtsearch.getText().trim()));
 };
 //BA.debugLineNum = 556;BA.debugLine="Dim pg As PagePasswordList = B4XPages.GetPage(\"Pa";
_pg = (com.lockzero.pagepasswordlist)(_b4xpages._getpage /*Object*/ (ba,"PagePasswordList"));
 //BA.debugLineNum = 557;BA.debugLine="pg.SetParams(params)";
_pg._setparams /*String*/ (_params);
 //BA.debugLineNum = 558;BA.debugLine="ModTransition.SlideToLeft(Root, pg.Root)";
_modtransition._slidetoleft /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (ba,_root,_pg._root /*anywheresoftware.b4a.objects.B4XViewWrapper*/ );
 //BA.debugLineNum = 559;BA.debugLine="B4XPages.ShowPage(\"PagePasswordList\")";
_b4xpages._showpage /*String*/ (ba,"PagePasswordList");
 //BA.debugLineNum = 560;BA.debugLine="End Sub";
return "";
}
public String  _pnlgroup_click() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
String _groupid = "";
com.lockzero.clspasswordgroup _g = null;
 //BA.debugLineNum = 412;BA.debugLine="Private Sub pnlGroup_Click";
 //BA.debugLineNum = 413;BA.debugLine="Dim pnl As Panel = Sender";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
_pnl = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(__c.Sender(ba)));
 //BA.debugLineNum = 414;BA.debugLine="Dim groupId As String = pnl.Tag";
_groupid = BA.ObjectToString(_pnl.getTag());
 //BA.debugLineNum = 416;BA.debugLine="Log(\"=== pnlGroup_Click ===\")";
__c.LogImpl("839256068","=== pnlGroup_Click ===",0);
 //BA.debugLineNum = 417;BA.debugLine="Log(\"GroupId: \" & groupId)";
__c.LogImpl("839256069","GroupId: "+_groupid,0);
 //BA.debugLineNum = 419;BA.debugLine="Dim g As clsPasswordGroup = ModPasswords.GetGroup";
_g = _modpasswords._getgroupbyid /*com.lockzero.clspasswordgroup*/ (ba,_groupid);
 //BA.debugLineNum = 420;BA.debugLine="If g.IsInitialized = False Then";
if (_g._isinitialized /*boolean*/ ()==__c.False) { 
 //BA.debugLineNum = 421;BA.debugLine="Log(\"ERRO: Grupo nao inicializado!\")";
__c.LogImpl("839256073","ERRO: Grupo nao inicializado!",0);
 //BA.debugLineNum = 422;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 425;BA.debugLine="Log(\"Grupo: \" & g.Name)";
__c.LogImpl("839256077","Grupo: "+_g._name /*String*/ ,0);
 //BA.debugLineNum = 426;BA.debugLine="Log(\"Salt: \" & g.Salt)";
__c.LogImpl("839256078","Salt: "+_g._salt /*String*/ ,0);
 //BA.debugLineNum = 427;BA.debugLine="Log(\"TestValue: \" & g.TestValue)";
__c.LogImpl("839256079","TestValue: "+_g._testvalue /*String*/ ,0);
 //BA.debugLineNum = 428;BA.debugLine="Log(\"Sessao ativa: \" & ModSession.IsSessionActive";
__c.LogImpl("839256080","Sessao ativa: "+BA.ObjectToString(_modsession._issessionactive /*boolean*/ (ba)),0);
 //BA.debugLineNum = 431;BA.debugLine="If ModSession.IsSessionActive Then";
if (_modsession._issessionactive /*boolean*/ (ba)) { 
 //BA.debugLineNum = 432;BA.debugLine="Log(\"Sessao ativa - navegando direto\")";
__c.LogImpl("839256084","Sessao ativa - navegando direto",0);
 //BA.debugLineNum = 433;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 434;BA.debugLine="NavigateToGroup(groupId)";
_navigatetogroup(_groupid);
 //BA.debugLineNum = 435;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 439;BA.debugLine="Log(\"Sessao inativa - mostrando dialog\")";
__c.LogImpl("839256091","Sessao inativa - mostrando dialog",0);
 //BA.debugLineNum = 440;BA.debugLine="ShowUnlockGroupDialog(groupId)";
_showunlockgroupdialog(_groupid);
 //BA.debugLineNum = 441;BA.debugLine="End Sub";
return "";
}
public String  _pnlgroup_longclick() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
String _groupid = "";
 //BA.debugLineNum = 562;BA.debugLine="Private Sub pnlGroup_LongClick";
 //BA.debugLineNum = 563;BA.debugLine="Dim pnl As Panel = Sender";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
_pnl = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(__c.Sender(ba)));
 //BA.debugLineNum = 564;BA.debugLine="Dim groupId As String = pnl.Tag";
_groupid = BA.ObjectToString(_pnl.getTag());
 //BA.debugLineNum = 566;BA.debugLine="ShowGroupOptions(groupId)";
_showgroupoptions(_groupid);
 //BA.debugLineNum = 567;BA.debugLine="End Sub";
return "";
}
public String  _pnloverlay_click() throws Exception{
 //BA.debugLineNum = 407;BA.debugLine="Private Sub pnlOverlay_Click";
 //BA.debugLineNum = 409;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 410;BA.debugLine="End Sub";
return "";
}
public String  _processaddgroup() throws Exception{
String _groupname = "";
String _phrase = "";
String _phraseerror = "";
String _phraseconfirm = "";
com.lockzero.clspasswordgroup _g = null;
 //BA.debugLineNum = 972;BA.debugLine="Private Sub ProcessAddGroup";
 //BA.debugLineNum = 973;BA.debugLine="Dim groupName As String = edtGroupName.Text.Trim";
_groupname = _edtgroupname.getText().trim();
 //BA.debugLineNum = 976;BA.debugLine="If groupName.Length = 0 Then";
if (_groupname.length()==0) { 
 //BA.debugLineNum = 977;BA.debugLine="ToastMessageShow(ModLang.T(\"error_empty_field\"),";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error_empty_field")),__c.True);
 //BA.debugLineNum = 978;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 982;BA.debugLine="Dim phrase As String = \"\"";
_phrase = "";
 //BA.debugLineNum = 983;BA.debugLine="If ModSession.IsSessionActive Then";
if (_modsession._issessionactive /*boolean*/ (ba)) { 
 //BA.debugLineNum = 984;BA.debugLine="phrase = ModSession.GetPassphrase";
_phrase = _modsession._getpassphrase /*String*/ (ba);
 }else {
 //BA.debugLineNum = 986;BA.debugLine="phrase = edtPassphrase.Text.Trim";
_phrase = _edtpassphrase.getText().trim();
 //BA.debugLineNum = 988;BA.debugLine="Dim phraseError As String = ModSecurity.GetPassp";
_phraseerror = _modsecurity._getpassphraseerror /*String*/ (ba,_phrase);
 //BA.debugLineNum = 989;BA.debugLine="If phraseError.Length > 0 Then";
if (_phraseerror.length()>0) { 
 //BA.debugLineNum = 990;BA.debugLine="ToastMessageShow(phraseError, True)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_phraseerror),__c.True);
 //BA.debugLineNum = 991;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 995;BA.debugLine="Dim phraseConfirm As String = edtPassphraseConfi";
_phraseconfirm = _edtpassphraseconfirm.getText().trim();
 //BA.debugLineNum = 996;BA.debugLine="If phrase <> phraseConfirm Then";
if ((_phrase).equals(_phraseconfirm) == false) { 
 //BA.debugLineNum = 997;BA.debugLine="ToastMessageShow(ModLang.T(\"passphrase_mismatch";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"passphrase_mismatch")),__c.True);
 //BA.debugLineNum = 998;BA.debugLine="Return";
if (true) return "";
 };
 };
 //BA.debugLineNum = 1003;BA.debugLine="Dim g As clsPasswordGroup";
_g = new com.lockzero.clspasswordgroup();
 //BA.debugLineNum = 1004;BA.debugLine="g.Initialize";
_g._initialize /*String*/ (ba);
 //BA.debugLineNum = 1005;BA.debugLine="g.Name = groupName";
_g._name /*String*/  = _groupname;
 //BA.debugLineNum = 1006;BA.debugLine="g.GenerateSalt";
_g._generatesalt /*String*/ ();
 //BA.debugLineNum = 1007;BA.debugLine="g.CreateTestValue(phrase)";
_g._createtestvalue /*String*/ (_phrase);
 //BA.debugLineNum = 1008;BA.debugLine="ModPasswords.SaveGroup(g)";
_modpasswords._savegroup /*String*/ (ba,_g);
 //BA.debugLineNum = 1011;BA.debugLine="ModSession.StartSessionWithCategory(phrase, \"pass";
_modsession._startsessionwithcategory /*String*/ (ba,_phrase,"passwords");
 //BA.debugLineNum = 1014;BA.debugLine="ModSecurity.ClearSecureField(edtPassphrase)";
_modsecurity._clearsecurefield /*String*/ (ba,_edtpassphrase);
 //BA.debugLineNum = 1015;BA.debugLine="If edtPassphraseConfirm.IsInitialized Then ModSec";
if (_edtpassphraseconfirm.IsInitialized()) { 
_modsecurity._clearsecurefield /*String*/ (ba,_edtpassphraseconfirm);};
 //BA.debugLineNum = 1017;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 1018;BA.debugLine="LoadGroups";
_loadgroups();
 //BA.debugLineNum = 1019;BA.debugLine="ToastMessageShow(ModLang.T(\"success\"), False)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"success")),__c.False);
 //BA.debugLineNum = 1020;BA.debugLine="End Sub";
return "";
}
public String  _processdeletegroup() throws Exception{
String _phrase = "";
com.lockzero.clspasswordgroup _g = null;
 //BA.debugLineNum = 904;BA.debugLine="Private Sub ProcessDeleteGroup";
 //BA.debugLineNum = 905;BA.debugLine="Dim phrase As String = edtPassphrase.Text.Trim";
_phrase = _edtpassphrase.getText().trim();
 //BA.debugLineNum = 906;BA.debugLine="Dim g As clsPasswordGroup = ModPasswords.GetGroup";
_g = _modpasswords._getgroupbyid /*com.lockzero.clspasswordgroup*/ (ba,_currentgroupid);
 //BA.debugLineNum = 908;BA.debugLine="If g.IsInitialized = False Then";
if (_g._isinitialized /*boolean*/ ()==__c.False) { 
 //BA.debugLineNum = 909;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 910;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 914;BA.debugLine="If g.ValidatePhrase(phrase) Then";
if (_g._validatephrase /*boolean*/ (_phrase)) { 
 //BA.debugLineNum = 916;BA.debugLine="ModPasswords.DeleteGroup(CurrentGroupId)";
_modpasswords._deletegroup /*String*/ (ba,_currentgroupid);
 //BA.debugLineNum = 917;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 918;BA.debugLine="LoadGroups";
_loadgroups();
 //BA.debugLineNum = 919;BA.debugLine="ToastMessageShow(ModLang.T(\"success\"), False)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"success")),__c.False);
 }else {
 //BA.debugLineNum = 922;BA.debugLine="ToastMessageShow(ModLang.T(\"wrong_passphrase\"),";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"wrong_passphrase")),__c.True);
 //BA.debugLineNum = 923;BA.debugLine="edtPassphrase.Text = \"\"";
_edtpassphrase.setText(BA.ObjectToCharSequence(""));
 };
 //BA.debugLineNum = 925;BA.debugLine="End Sub";
return "";
}
public String  _processeditgroup() throws Exception{
String _groupname = "";
com.lockzero.clspasswordgroup _g = null;
 //BA.debugLineNum = 1054;BA.debugLine="Private Sub ProcessEditGroup";
 //BA.debugLineNum = 1055;BA.debugLine="Dim groupName As String = edtGroupName.Text.Trim";
_groupname = _edtgroupname.getText().trim();
 //BA.debugLineNum = 1056;BA.debugLine="Dim g As clsPasswordGroup = ModPasswords.GetGroup";
_g = _modpasswords._getgroupbyid /*com.lockzero.clspasswordgroup*/ (ba,_currentgroupid);
 //BA.debugLineNum = 1058;BA.debugLine="If g.IsInitialized = False Then";
if (_g._isinitialized /*boolean*/ ()==__c.False) { 
 //BA.debugLineNum = 1059;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 1060;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 1063;BA.debugLine="If groupName.Length > 0 Then";
if (_groupname.length()>0) { 
 //BA.debugLineNum = 1064;BA.debugLine="g.Name = groupName";
_g._name /*String*/  = _groupname;
 //BA.debugLineNum = 1065;BA.debugLine="ModPasswords.SaveGroup(g)";
_modpasswords._savegroup /*String*/ (ba,_g);
 //BA.debugLineNum = 1066;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 1067;BA.debugLine="LoadGroups";
_loadgroups();
 //BA.debugLineNum = 1068;BA.debugLine="ToastMessageShow(ModLang.T(\"success\"), False)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"success")),__c.False);
 }else {
 //BA.debugLineNum = 1070;BA.debugLine="ToastMessageShow(ModLang.T(\"error_empty_field\"),";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error_empty_field")),__c.True);
 };
 //BA.debugLineNum = 1072;BA.debugLine="End Sub";
return "";
}
public String  _processunlockgroup() throws Exception{
String _phrase = "";
com.lockzero.clspasswordgroup _g = null;
int _delay = 0;
String _timestr = "";
 //BA.debugLineNum = 1022;BA.debugLine="Private Sub ProcessUnlockGroup";
 //BA.debugLineNum = 1023;BA.debugLine="Dim phrase As String = edtPassphrase.Text.Trim";
_phrase = _edtpassphrase.getText().trim();
 //BA.debugLineNum = 1024;BA.debugLine="Dim g As clsPasswordGroup = ModPasswords.GetGroup";
_g = _modpasswords._getgroupbyid /*com.lockzero.clspasswordgroup*/ (ba,_currentgroupid);
 //BA.debugLineNum = 1026;BA.debugLine="If g.IsInitialized = False Then";
if (_g._isinitialized /*boolean*/ ()==__c.False) { 
 //BA.debugLineNum = 1027;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 1028;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 1032;BA.debugLine="If g.ValidatePhrase(phrase) Then";
if (_g._validatephrase /*boolean*/ (_phrase)) { 
 //BA.debugLineNum = 1034;BA.debugLine="ModSecurity.ResetFailedAttempts(CurrentGroupId)";
_modsecurity._resetfailedattempts /*String*/ (ba,_currentgroupid);
 //BA.debugLineNum = 1035;BA.debugLine="ModSession.StartSessionWithCategory(phrase, \"pas";
_modsession._startsessionwithcategory /*String*/ (ba,_phrase,"passwords");
 //BA.debugLineNum = 1037;BA.debugLine="ModSecurity.ClearSecureField(edtPassphrase)";
_modsecurity._clearsecurefield /*String*/ (ba,_edtpassphrase);
 //BA.debugLineNum = 1038;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 1039;BA.debugLine="NavigateToGroup(CurrentGroupId)";
_navigatetogroup(_currentgroupid);
 }else {
 //BA.debugLineNum = 1042;BA.debugLine="Dim delay As Int = ModSecurity.RegisterFailedAtt";
_delay = _modsecurity._registerfailedattempt /*int*/ (ba,_currentgroupid);
 //BA.debugLineNum = 1043;BA.debugLine="If delay > 0 Then";
if (_delay>0) { 
 //BA.debugLineNum = 1044;BA.debugLine="Dim timeStr As String = ModSecurity.FormatDelay";
_timestr = _modsecurity._formatdelay /*String*/ (ba,_delay);
 //BA.debugLineNum = 1045;BA.debugLine="ToastMessageShow(ModLang.T(\"wrong_passphrase\")";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"wrong_passphrase")+" - "+_modlang._t /*String*/ (ba,"wait_timeout")+" "+_timestr),__c.True);
 //BA.debugLineNum = 1046;BA.debugLine="HideDialog";
_hidedialog();
 }else {
 //BA.debugLineNum = 1048;BA.debugLine="ToastMessageShow(ModLang.T(\"wrong_passphrase\"),";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"wrong_passphrase")),__c.True);
 };
 //BA.debugLineNum = 1050;BA.debugLine="ModSecurity.ClearSecureField(edtPassphrase)";
_modsecurity._clearsecurefield /*String*/ (ba,_edtpassphrase);
 };
 //BA.debugLineNum = 1052;BA.debugLine="End Sub";
return "";
}
public String  _showaddgroupdialog() throws Exception{
int _dialogw = 0;
boolean _sessionactive = false;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
anywheresoftware.b4a.objects.LabelWrapper _lblname = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlname = null;
int _buttony = 0;
int _dialogh = 0;
anywheresoftware.b4a.objects.LabelWrapper _lblphrase = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlinput = null;
anywheresoftware.b4a.objects.LabelWrapper _lblconfirm = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlconfirm = null;
anywheresoftware.b4a.objects.LabelWrapper _lblwarning = null;
anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
anywheresoftware.b4a.objects.ButtonWrapper _btnok = null;
 //BA.debugLineNum = 573;BA.debugLine="Private Sub ShowAddGroupDialog";
 //BA.debugLineNum = 574;BA.debugLine="CurrentDialogMode = \"add_group\"";
_currentdialogmode = "add_group";
 //BA.debugLineNum = 575;BA.debugLine="CurrentGroupId = \"\"";
_currentgroupid = "";
 //BA.debugLineNum = 576;BA.debugLine="IsPassVisible = False";
_ispassvisible = __c.False;
 //BA.debugLineNum = 579;BA.debugLine="Dim dialogW As Int = Root.Width - 40dip";
_dialogw = (int) (_root.getWidth()-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 580;BA.debugLine="pnlDialog.RemoveAllViews";
_pnldialog.RemoveAllViews();
 //BA.debugLineNum = 583;BA.debugLine="Dim sessionActive As Boolean = ModSession.IsSessi";
_sessionactive = _modsession._issessionactive /*boolean*/ (ba);
 //BA.debugLineNum = 586;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 587;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 588;BA.debugLine="lblTitle.Text = ModLang.T(\"new_group\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"new_group")));
 //BA.debugLineNum = 589;BA.debugLine="lblTitle.TextSize = 16";
_lbltitle.setTextSize((float) (16));
 //BA.debugLineNum = 590;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 591;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 592;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 593;BA.debugLine="pnlDialog.AddView(lblTitle, 0, 12dip, dialogW, 24";
_pnldialog.AddView((android.view.View)(_lbltitle.getObject()),(int) (0),__c.DipToCurrent((int) (12)),_dialogw,__c.DipToCurrent((int) (24)));
 //BA.debugLineNum = 596;BA.debugLine="Dim lblName As Label";
_lblname = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 597;BA.debugLine="lblName.Initialize(\"\")";
_lblname.Initialize(ba,"");
 //BA.debugLineNum = 598;BA.debugLine="lblName.Text = ModLang.T(\"group_name_hint\")";
_lblname.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"group_name_hint")));
 //BA.debugLineNum = 599;BA.debugLine="lblName.TextSize = 12";
_lblname.setTextSize((float) (12));
 //BA.debugLineNum = 600;BA.debugLine="lblName.TextColor = Colors.ARGB(180, 255, 255, 25";
_lblname.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 601;BA.debugLine="pnlDialog.AddView(lblName, 16dip, 45dip, dialogW";
_pnldialog.AddView((android.view.View)(_lblname.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (45)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (18)));
 //BA.debugLineNum = 604;BA.debugLine="edtGroupName.Initialize(\"edtGroupName\")";
_edtgroupname.Initialize(ba,"edtGroupName");
 //BA.debugLineNum = 605;BA.debugLine="edtGroupName.Hint = ModLang.T(\"group_name_hint\")";
_edtgroupname.setHint(_modlang._t /*String*/ (ba,"group_name_hint"));
 //BA.debugLineNum = 606;BA.debugLine="edtGroupName.SingleLine = True";
_edtgroupname.setSingleLine(__c.True);
 //BA.debugLineNum = 607;BA.debugLine="edtGroupName.InputType = Bit.Or(1, 8192) 'TEXT +";
_edtgroupname.setInputType(__c.Bit.Or((int) (1),(int) (8192)));
 //BA.debugLineNum = 608;BA.debugLine="edtGroupName.Text = \"\"";
_edtgroupname.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 609;BA.debugLine="edtGroupName.TextColor = Colors.White";
_edtgroupname.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 610;BA.debugLine="edtGroupName.HintColor = Colors.ARGB(120, 255, 25";
_edtgroupname.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 612;BA.debugLine="Dim pnlName As Panel";
_pnlname = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 613;BA.debugLine="pnlName.Initialize(\"\")";
_pnlname.Initialize(ba,"");
 //BA.debugLineNum = 614;BA.debugLine="pnlName.Color = ModTheme.HomeBg";
_pnlname.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 615;BA.debugLine="pnlDialog.AddView(pnlName, 16dip, 65dip, dialogW";
_pnldialog.AddView((android.view.View)(_pnlname.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (65)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (46)));
 //BA.debugLineNum = 616;BA.debugLine="pnlName.AddView(edtGroupName, 8dip, 0, dialogW -";
_pnlname.AddView((android.view.View)(_edtgroupname.getObject()),__c.DipToCurrent((int) (8)),(int) (0),(int) (_dialogw-__c.DipToCurrent((int) (32))-__c.DipToCurrent((int) (16))),__c.DipToCurrent((int) (46)));
 //BA.debugLineNum = 618;BA.debugLine="Dim buttonY As Int = 125dip";
_buttony = __c.DipToCurrent((int) (125));
 //BA.debugLineNum = 619;BA.debugLine="Dim dialogH As Int = 175dip";
_dialogh = __c.DipToCurrent((int) (175));
 //BA.debugLineNum = 622;BA.debugLine="If sessionActive = False Then";
if (_sessionactive==__c.False) { 
 //BA.debugLineNum = 624;BA.debugLine="Dim lblPhrase As Label";
_lblphrase = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 625;BA.debugLine="lblPhrase.Initialize(\"\")";
_lblphrase.Initialize(ba,"");
 //BA.debugLineNum = 626;BA.debugLine="lblPhrase.Text = ModLang.T(\"passphrase_hint\")";
_lblphrase.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"passphrase_hint")));
 //BA.debugLineNum = 627;BA.debugLine="lblPhrase.TextSize = 12";
_lblphrase.setTextSize((float) (12));
 //BA.debugLineNum = 628;BA.debugLine="lblPhrase.TextColor = Colors.ARGB(180, 255, 255,";
_lblphrase.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 629;BA.debugLine="pnlDialog.AddView(lblPhrase, 16dip, 120dip, dial";
_pnldialog.AddView((android.view.View)(_lblphrase.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (120)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (18)));
 //BA.debugLineNum = 632;BA.debugLine="Dim pnlInput As Panel";
_pnlinput = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 633;BA.debugLine="pnlInput.Initialize(\"\")";
_pnlinput.Initialize(ba,"");
 //BA.debugLineNum = 634;BA.debugLine="pnlInput.Color = ModTheme.HomeBg";
_pnlinput.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 635;BA.debugLine="pnlDialog.AddView(pnlInput, 16dip, 140dip, dialo";
_pnldialog.AddView((android.view.View)(_pnlinput.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (140)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (46)));
 //BA.debugLineNum = 637;BA.debugLine="edtPassphrase.Initialize(\"edtPassphrase\")";
_edtpassphrase.Initialize(ba,"edtPassphrase");
 //BA.debugLineNum = 638;BA.debugLine="edtPassphrase.Hint = ModLang.T(\"passphrase_hint\"";
_edtpassphrase.setHint(_modlang._t /*String*/ (ba,"passphrase_hint"));
 //BA.debugLineNum = 639;BA.debugLine="edtPassphrase.SingleLine = True";
_edtpassphrase.setSingleLine(__c.True);
 //BA.debugLineNum = 640;BA.debugLine="edtPassphrase.InputType = ModSecurity.GetSecureP";
_edtpassphrase.setInputType(_modsecurity._getsecurepassphraseinputtype /*int*/ (ba));
 //BA.debugLineNum = 641;BA.debugLine="edtPassphrase.Text = \"\"";
_edtpassphrase.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 642;BA.debugLine="edtPassphrase.TextColor = Colors.White";
_edtpassphrase.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 643;BA.debugLine="edtPassphrase.HintColor = Colors.ARGB(120, 255,";
_edtpassphrase.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 644;BA.debugLine="pnlInput.AddView(edtPassphrase, 8dip, 0, dialogW";
_pnlinput.AddView((android.view.View)(_edtpassphrase.getObject()),__c.DipToCurrent((int) (8)),(int) (0),(int) (_dialogw-__c.DipToCurrent((int) (32))-__c.DipToCurrent((int) (56))),__c.DipToCurrent((int) (46)));
 //BA.debugLineNum = 647;BA.debugLine="btnShowPass.Initialize(\"btnShowPass\")";
_btnshowpass.Initialize(ba,"btnShowPass");
 //BA.debugLineNum = 648;BA.debugLine="btnShowPass.Text = ModLang.T(\"view\")";
_btnshowpass.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"view")));
 //BA.debugLineNum = 649;BA.debugLine="btnShowPass.TextSize = Starter.FONT_CAPTION";
_btnshowpass.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 650;BA.debugLine="btnShowPass.Color = Colors.Transparent";
_btnshowpass.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 651;BA.debugLine="btnShowPass.TextColor = Colors.ARGB(200, 255, 25";
_btnshowpass.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 652;BA.debugLine="btnShowPass.Gravity = Gravity.CENTER";
_btnshowpass.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 653;BA.debugLine="pnlInput.AddView(btnShowPass, dialogW - 32dip -";
_pnlinput.AddView((android.view.View)(_btnshowpass.getObject()),(int) (_dialogw-__c.DipToCurrent((int) (32))-__c.DipToCurrent((int) (65))),__c.DipToCurrent((int) (3)),__c.DipToCurrent((int) (60)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 656;BA.debugLine="Dim lblConfirm As Label";
_lblconfirm = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 657;BA.debugLine="lblConfirm.Initialize(\"\")";
_lblconfirm.Initialize(ba,"");
 //BA.debugLineNum = 658;BA.debugLine="lblConfirm.Text = ModLang.T(\"passphrase_confirm_";
_lblconfirm.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"passphrase_confirm_new")));
 //BA.debugLineNum = 659;BA.debugLine="lblConfirm.TextSize = 12";
_lblconfirm.setTextSize((float) (12));
 //BA.debugLineNum = 660;BA.debugLine="lblConfirm.TextColor = Colors.ARGB(180, 255, 255";
_lblconfirm.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 661;BA.debugLine="pnlDialog.AddView(lblConfirm, 16dip, 195dip, dia";
_pnldialog.AddView((android.view.View)(_lblconfirm.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (195)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (18)));
 //BA.debugLineNum = 664;BA.debugLine="Dim pnlConfirm As Panel";
_pnlconfirm = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 665;BA.debugLine="pnlConfirm.Initialize(\"\")";
_pnlconfirm.Initialize(ba,"");
 //BA.debugLineNum = 666;BA.debugLine="pnlConfirm.Color = ModTheme.HomeBg";
_pnlconfirm.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 667;BA.debugLine="pnlDialog.AddView(pnlConfirm, 16dip, 215dip, dia";
_pnldialog.AddView((android.view.View)(_pnlconfirm.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (215)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (46)));
 //BA.debugLineNum = 669;BA.debugLine="edtPassphraseConfirm.Initialize(\"edtPassphraseCo";
_edtpassphraseconfirm.Initialize(ba,"edtPassphraseConfirm");
 //BA.debugLineNum = 670;BA.debugLine="edtPassphraseConfirm.Hint = ModLang.T(\"passphras";
_edtpassphraseconfirm.setHint(_modlang._t /*String*/ (ba,"passphrase_confirm_new"));
 //BA.debugLineNum = 671;BA.debugLine="edtPassphraseConfirm.SingleLine = True";
_edtpassphraseconfirm.setSingleLine(__c.True);
 //BA.debugLineNum = 672;BA.debugLine="edtPassphraseConfirm.InputType = ModSecurity.Get";
_edtpassphraseconfirm.setInputType(_modsecurity._getsecurepassphraseinputtype /*int*/ (ba));
 //BA.debugLineNum = 673;BA.debugLine="edtPassphraseConfirm.Text = \"\"";
_edtpassphraseconfirm.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 674;BA.debugLine="edtPassphraseConfirm.TextColor = Colors.White";
_edtpassphraseconfirm.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 675;BA.debugLine="edtPassphraseConfirm.HintColor = Colors.ARGB(120";
_edtpassphraseconfirm.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 676;BA.debugLine="pnlConfirm.AddView(edtPassphraseConfirm, 8dip, 0";
_pnlconfirm.AddView((android.view.View)(_edtpassphraseconfirm.getObject()),__c.DipToCurrent((int) (8)),(int) (0),(int) (_dialogw-__c.DipToCurrent((int) (32))-__c.DipToCurrent((int) (16))),__c.DipToCurrent((int) (46)));
 //BA.debugLineNum = 678;BA.debugLine="buttonY = 275dip";
_buttony = __c.DipToCurrent((int) (275));
 //BA.debugLineNum = 679;BA.debugLine="dialogH = 325dip";
_dialogh = __c.DipToCurrent((int) (325));
 //BA.debugLineNum = 682;BA.debugLine="If ModSecurity.GetUseSinglePassphrase Then";
if (_modsecurity._getusesinglepassphrase /*boolean*/ (ba)) { 
 //BA.debugLineNum = 683;BA.debugLine="Dim lblWarning As Label";
_lblwarning = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 684;BA.debugLine="lblWarning.Initialize(\"\")";
_lblwarning.Initialize(ba,"");
 //BA.debugLineNum = 685;BA.debugLine="lblWarning.Text = \"⚠ \" & ModLang.T(\"single_pass";
_lblwarning.setText(BA.ObjectToCharSequence("⚠ "+_modlang._t /*String*/ (ba,"single_passphrase_warning")));
 //BA.debugLineNum = 686;BA.debugLine="lblWarning.TextSize = 10";
_lblwarning.setTextSize((float) (10));
 //BA.debugLineNum = 687;BA.debugLine="lblWarning.TextColor = ModTheme.Warning";
_lblwarning.setTextColor(_modtheme._warning /*int*/ (ba));
 //BA.debugLineNum = 688;BA.debugLine="pnlDialog.AddView(lblWarning, 16dip, 265dip, di";
_pnldialog.AddView((android.view.View)(_lblwarning.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (265)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (35)));
 //BA.debugLineNum = 689;BA.debugLine="buttonY = 305dip";
_buttony = __c.DipToCurrent((int) (305));
 //BA.debugLineNum = 690;BA.debugLine="dialogH = 355dip";
_dialogh = __c.DipToCurrent((int) (355));
 };
 };
 //BA.debugLineNum = 695;BA.debugLine="Dim btnCancel As Button";
_btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 696;BA.debugLine="btnCancel.Initialize(\"btnDialogCancel\")";
_btncancel.Initialize(ba,"btnDialogCancel");
 //BA.debugLineNum = 697;BA.debugLine="btnCancel.Text = ModLang.T(\"cancel\")";
_btncancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 698;BA.debugLine="btnCancel.TextSize = 13";
_btncancel.setTextSize((float) (13));
 //BA.debugLineNum = 699;BA.debugLine="btnCancel.Color = Colors.Transparent";
_btncancel.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 700;BA.debugLine="btnCancel.TextColor = Colors.ARGB(200, 255, 255,";
_btncancel.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 701;BA.debugLine="pnlDialog.AddView(btnCancel, 16dip, buttonY, 100d";
_pnldialog.AddView((android.view.View)(_btncancel.getObject()),__c.DipToCurrent((int) (16)),_buttony,__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 703;BA.debugLine="Dim btnOk As Button";
_btnok = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 704;BA.debugLine="btnOk.Initialize(\"btnDialogOk\")";
_btnok.Initialize(ba,"btnDialogOk");
 //BA.debugLineNum = 705;BA.debugLine="btnOk.Text = ModLang.T(\"save\")";
_btnok.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"save")));
 //BA.debugLineNum = 706;BA.debugLine="btnOk.TextSize = 13";
_btnok.setTextSize((float) (13));
 //BA.debugLineNum = 707;BA.debugLine="btnOk.Color = ModTheme.HomeIconBg";
_btnok.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 708;BA.debugLine="btnOk.TextColor = Colors.White";
_btnok.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 709;BA.debugLine="pnlDialog.AddView(btnOk, dialogW - 116dip, button";
_pnldialog.AddView((android.view.View)(_btnok.getObject()),(int) (_dialogw-__c.DipToCurrent((int) (116))),_buttony,__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 712;BA.debugLine="pnlDialog.SetLayoutAnimated(0, 20dip, 60dip, dial";
_pnldialog.SetLayoutAnimated((int) (0),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (60)),_dialogw,_dialogh);
 //BA.debugLineNum = 715;BA.debugLine="pnlOverlay.Visible = True";
_pnloverlay.setVisible(__c.True);
 //BA.debugLineNum = 716;BA.debugLine="pnlOverlay.BringToFront";
_pnloverlay.BringToFront();
 //BA.debugLineNum = 717;BA.debugLine="edtGroupName.RequestFocus";
_edtgroupname.RequestFocus();
 //BA.debugLineNum = 718;BA.debugLine="End Sub";
return "";
}
public String  _showdeletegroupdialog(String _groupid) throws Exception{
com.lockzero.clspasswordgroup _g = null;
int _dialogw = 0;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
anywheresoftware.b4a.objects.LabelWrapper _lblsub = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlinput = null;
anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
anywheresoftware.b4a.objects.ButtonWrapper _btnok = null;
 //BA.debugLineNum = 825;BA.debugLine="Private Sub ShowDeleteGroupDialog(groupId As Strin";
 //BA.debugLineNum = 826;BA.debugLine="Dim g As clsPasswordGroup = ModPasswords.GetGroup";
_g = _modpasswords._getgroupbyid /*com.lockzero.clspasswordgroup*/ (ba,_groupid);
 //BA.debugLineNum = 827;BA.debugLine="If g.IsInitialized = False Then Return";
if (_g._isinitialized /*boolean*/ ()==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 829;BA.debugLine="CurrentDialogMode = \"delete_group\"";
_currentdialogmode = "delete_group";
 //BA.debugLineNum = 830;BA.debugLine="CurrentGroupId = groupId";
_currentgroupid = _groupid;
 //BA.debugLineNum = 831;BA.debugLine="IsPassVisible = False";
_ispassvisible = __c.False;
 //BA.debugLineNum = 833;BA.debugLine="Dim dialogW As Int = Root.Width - 40dip";
_dialogw = (int) (_root.getWidth()-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 834;BA.debugLine="pnlDialog.RemoveAllViews";
_pnldialog.RemoveAllViews();
 //BA.debugLineNum = 837;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 838;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 839;BA.debugLine="lblTitle.Text = ModLang.T(\"confirm_delete\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"confirm_delete")));
 //BA.debugLineNum = 840;BA.debugLine="lblTitle.TextSize = 16";
_lbltitle.setTextSize((float) (16));
 //BA.debugLineNum = 841;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 842;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 843;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 844;BA.debugLine="pnlDialog.AddView(lblTitle, 0, 12dip, dialogW, 24";
_pnldialog.AddView((android.view.View)(_lbltitle.getObject()),(int) (0),__c.DipToCurrent((int) (12)),_dialogw,__c.DipToCurrent((int) (24)));
 //BA.debugLineNum = 847;BA.debugLine="Dim lblSub As Label";
_lblsub = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 848;BA.debugLine="lblSub.Initialize(\"\")";
_lblsub.Initialize(ba,"");
 //BA.debugLineNum = 849;BA.debugLine="lblSub.Text = g.Name & CRLF & ModLang.T(\"enter_pa";
_lblsub.setText(BA.ObjectToCharSequence(_g._name /*String*/ +__c.CRLF+_modlang._t /*String*/ (ba,"enter_passphrase")));
 //BA.debugLineNum = 850;BA.debugLine="lblSub.TextSize = 12";
_lblsub.setTextSize((float) (12));
 //BA.debugLineNum = 851;BA.debugLine="lblSub.TextColor = Colors.ARGB(180, 255, 255, 255";
_lblsub.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 852;BA.debugLine="lblSub.Gravity = Gravity.CENTER_HORIZONTAL";
_lblsub.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 853;BA.debugLine="pnlDialog.AddView(lblSub, 0, 36dip, dialogW, 40di";
_pnldialog.AddView((android.view.View)(_lblsub.getObject()),(int) (0),__c.DipToCurrent((int) (36)),_dialogw,__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 856;BA.debugLine="Dim pnlInput As Panel";
_pnlinput = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 857;BA.debugLine="pnlInput.Initialize(\"\")";
_pnlinput.Initialize(ba,"");
 //BA.debugLineNum = 858;BA.debugLine="pnlInput.Color = ModTheme.HomeBg";
_pnlinput.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 859;BA.debugLine="pnlDialog.AddView(pnlInput, 16dip, 85dip, dialogW";
_pnldialog.AddView((android.view.View)(_pnlinput.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (85)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 861;BA.debugLine="edtPassphrase.Initialize(\"edtPassphrase\")";
_edtpassphrase.Initialize(ba,"edtPassphrase");
 //BA.debugLineNum = 862;BA.debugLine="edtPassphrase.Hint = ModLang.T(\"passphrase_hint\")";
_edtpassphrase.setHint(_modlang._t /*String*/ (ba,"passphrase_hint"));
 //BA.debugLineNum = 863;BA.debugLine="edtPassphrase.SingleLine = True";
_edtpassphrase.setSingleLine(__c.True);
 //BA.debugLineNum = 864;BA.debugLine="edtPassphrase.InputType = ModSecurity.GetSecurePa";
_edtpassphrase.setInputType(_modsecurity._getsecurepassphraseinputtype /*int*/ (ba));
 //BA.debugLineNum = 865;BA.debugLine="edtPassphrase.Text = \"\"";
_edtpassphrase.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 866;BA.debugLine="edtPassphrase.TextColor = Colors.White";
_edtpassphrase.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 867;BA.debugLine="edtPassphrase.HintColor = Colors.ARGB(120, 255, 2";
_edtpassphrase.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 868;BA.debugLine="pnlInput.AddView(edtPassphrase, 8dip, 0, dialogW";
_pnlinput.AddView((android.view.View)(_edtpassphrase.getObject()),__c.DipToCurrent((int) (8)),(int) (0),(int) (_dialogw-__c.DipToCurrent((int) (32))-__c.DipToCurrent((int) (56))),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 871;BA.debugLine="btnShowPass.Initialize(\"btnShowPass\")";
_btnshowpass.Initialize(ba,"btnShowPass");
 //BA.debugLineNum = 872;BA.debugLine="btnShowPass.Text = ModLang.T(\"view\")";
_btnshowpass.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"view")));
 //BA.debugLineNum = 873;BA.debugLine="btnShowPass.TextSize = Starter.FONT_CAPTION";
_btnshowpass.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 874;BA.debugLine="btnShowPass.Color = Colors.Transparent";
_btnshowpass.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 875;BA.debugLine="btnShowPass.TextColor = Colors.ARGB(200, 255, 255";
_btnshowpass.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 876;BA.debugLine="btnShowPass.Gravity = Gravity.CENTER";
_btnshowpass.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 877;BA.debugLine="pnlInput.AddView(btnShowPass, dialogW - 32dip - 6";
_pnlinput.AddView((android.view.View)(_btnshowpass.getObject()),(int) (_dialogw-__c.DipToCurrent((int) (32))-__c.DipToCurrent((int) (65))),__c.DipToCurrent((int) (5)),__c.DipToCurrent((int) (60)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 880;BA.debugLine="Dim btnCancel As Button";
_btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 881;BA.debugLine="btnCancel.Initialize(\"btnDialogCancel\")";
_btncancel.Initialize(ba,"btnDialogCancel");
 //BA.debugLineNum = 882;BA.debugLine="btnCancel.Text = ModLang.T(\"cancel\")";
_btncancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 883;BA.debugLine="btnCancel.TextSize = 13";
_btncancel.setTextSize((float) (13));
 //BA.debugLineNum = 884;BA.debugLine="btnCancel.Color = Colors.Transparent";
_btncancel.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 885;BA.debugLine="btnCancel.TextColor = Colors.ARGB(200, 255, 255,";
_btncancel.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 886;BA.debugLine="pnlDialog.AddView(btnCancel, 16dip, 150dip, 100di";
_pnldialog.AddView((android.view.View)(_btncancel.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (150)),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 888;BA.debugLine="Dim btnOk As Button";
_btnok = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 889;BA.debugLine="btnOk.Initialize(\"btnDialogOk\")";
_btnok.Initialize(ba,"btnDialogOk");
 //BA.debugLineNum = 890;BA.debugLine="btnOk.Text = ModLang.T(\"delete\")";
_btnok.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"delete")));
 //BA.debugLineNum = 891;BA.debugLine="btnOk.TextSize = 12";
_btnok.setTextSize((float) (12));
 //BA.debugLineNum = 892;BA.debugLine="btnOk.Color = ModTheme.Danger";
_btnok.setColor(_modtheme._danger /*int*/ (ba));
 //BA.debugLineNum = 893;BA.debugLine="btnOk.TextColor = Colors.White";
_btnok.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 894;BA.debugLine="pnlDialog.AddView(btnOk, dialogW - 130dip, 150dip";
_pnldialog.AddView((android.view.View)(_btnok.getObject()),(int) (_dialogw-__c.DipToCurrent((int) (130))),__c.DipToCurrent((int) (150)),__c.DipToCurrent((int) (114)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 896;BA.debugLine="pnlDialog.SetLayoutAnimated(0, 20dip, 80dip, dial";
_pnldialog.SetLayoutAnimated((int) (0),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (80)),_dialogw,__c.DipToCurrent((int) (200)));
 //BA.debugLineNum = 898;BA.debugLine="pnlOverlay.Visible = True";
_pnloverlay.setVisible(__c.True);
 //BA.debugLineNum = 899;BA.debugLine="pnlOverlay.BringToFront";
_pnloverlay.BringToFront();
 //BA.debugLineNum = 900;BA.debugLine="edtPassphrase.RequestFocus";
_edtpassphrase.RequestFocus();
 //BA.debugLineNum = 901;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 737;BA.debugLine="Private Sub ShowEditGroupDialog(groupId As String)";
 //BA.debugLineNum = 738;BA.debugLine="Dim g As clsPasswordGroup = ModPasswords.GetGroup";
_g = _modpasswords._getgroupbyid /*com.lockzero.clspasswordgroup*/ (ba,_groupid);
 //BA.debugLineNum = 739;BA.debugLine="If g.IsInitialized = False Then Return";
if (_g._isinitialized /*boolean*/ ()==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 741;BA.debugLine="CurrentDialogMode = \"edit_group\"";
_currentdialogmode = "edit_group";
 //BA.debugLineNum = 742;BA.debugLine="CurrentGroupId = groupId";
_currentgroupid = _groupid;
 //BA.debugLineNum = 745;BA.debugLine="Dim dialogW As Int = Root.Width - 40dip";
_dialogw = (int) (_root.getWidth()-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 746;BA.debugLine="pnlDialog.RemoveAllViews";
_pnldialog.RemoveAllViews();
 //BA.debugLineNum = 749;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 750;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 751;BA.debugLine="lblTitle.Text = ModLang.T(\"edit_group\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"edit_group")));
 //BA.debugLineNum = 752;BA.debugLine="lblTitle.TextSize = 16";
_lbltitle.setTextSize((float) (16));
 //BA.debugLineNum = 753;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 754;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 755;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 756;BA.debugLine="pnlDialog.AddView(lblTitle, 0, 12dip, dialogW, 24";
_pnldialog.AddView((android.view.View)(_lbltitle.getObject()),(int) (0),__c.DipToCurrent((int) (12)),_dialogw,__c.DipToCurrent((int) (24)));
 //BA.debugLineNum = 759;BA.debugLine="Dim lblName As Label";
_lblname = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 760;BA.debugLine="lblName.Initialize(\"\")";
_lblname.Initialize(ba,"");
 //BA.debugLineNum = 761;BA.debugLine="lblName.Text = ModLang.T(\"group_name_hint\")";
_lblname.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"group_name_hint")));
 //BA.debugLineNum = 762;BA.debugLine="lblName.TextSize = 12";
_lblname.setTextSize((float) (12));
 //BA.debugLineNum = 763;BA.debugLine="lblName.TextColor = Colors.ARGB(180, 255, 255, 25";
_lblname.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 764;BA.debugLine="pnlDialog.AddView(lblName, 16dip, 45dip, dialogW";
_pnldialog.AddView((android.view.View)(_lblname.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (45)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (18)));
 //BA.debugLineNum = 767;BA.debugLine="Dim pnlName As Panel";
_pnlname = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 768;BA.debugLine="pnlName.Initialize(\"\")";
_pnlname.Initialize(ba,"");
 //BA.debugLineNum = 769;BA.debugLine="pnlName.Color = ModTheme.HomeBg";
_pnlname.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 770;BA.debugLine="pnlDialog.AddView(pnlName, 16dip, 65dip, dialogW";
_pnldialog.AddView((android.view.View)(_pnlname.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (65)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (46)));
 //BA.debugLineNum = 772;BA.debugLine="edtGroupName.Initialize(\"edtGroupName\")";
_edtgroupname.Initialize(ba,"edtGroupName");
 //BA.debugLineNum = 773;BA.debugLine="edtGroupName.Text = g.Name";
_edtgroupname.setText(BA.ObjectToCharSequence(_g._name /*String*/ ));
 //BA.debugLineNum = 774;BA.debugLine="edtGroupName.SingleLine = True";
_edtgroupname.setSingleLine(__c.True);
 //BA.debugLineNum = 775;BA.debugLine="edtGroupName.InputType = Bit.Or(1, 8192)";
_edtgroupname.setInputType(__c.Bit.Or((int) (1),(int) (8192)));
 //BA.debugLineNum = 776;BA.debugLine="edtGroupName.TextColor = Colors.White";
_edtgroupname.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 777;BA.debugLine="edtGroupName.HintColor = Colors.ARGB(120, 255, 25";
_edtgroupname.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 778;BA.debugLine="pnlName.AddView(edtGroupName, 8dip, 0, dialogW -";
_pnlname.AddView((android.view.View)(_edtgroupname.getObject()),__c.DipToCurrent((int) (8)),(int) (0),(int) (_dialogw-__c.DipToCurrent((int) (32))-__c.DipToCurrent((int) (16))),__c.DipToCurrent((int) (46)));
 //BA.debugLineNum = 781;BA.debugLine="Dim btnCancel As Button";
_btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 782;BA.debugLine="btnCancel.Initialize(\"btnDialogCancel\")";
_btncancel.Initialize(ba,"btnDialogCancel");
 //BA.debugLineNum = 783;BA.debugLine="btnCancel.Text = ModLang.T(\"cancel\")";
_btncancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 784;BA.debugLine="btnCancel.TextSize = 13";
_btncancel.setTextSize((float) (13));
 //BA.debugLineNum = 785;BA.debugLine="btnCancel.Color = Colors.Transparent";
_btncancel.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 786;BA.debugLine="btnCancel.TextColor = Colors.ARGB(200, 255, 255,";
_btncancel.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 787;BA.debugLine="pnlDialog.AddView(btnCancel, 16dip, 125dip, 100di";
_pnldialog.AddView((android.view.View)(_btncancel.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (125)),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 789;BA.debugLine="Dim btnOk As Button";
_btnok = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 790;BA.debugLine="btnOk.Initialize(\"btnDialogOk\")";
_btnok.Initialize(ba,"btnDialogOk");
 //BA.debugLineNum = 791;BA.debugLine="btnOk.Text = ModLang.T(\"save\")";
_btnok.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"save")));
 //BA.debugLineNum = 792;BA.debugLine="btnOk.TextSize = 13";
_btnok.setTextSize((float) (13));
 //BA.debugLineNum = 793;BA.debugLine="btnOk.Color = ModTheme.HomeIconBg";
_btnok.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 794;BA.debugLine="btnOk.TextColor = Colors.White";
_btnok.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 795;BA.debugLine="pnlDialog.AddView(btnOk, dialogW - 116dip, 125dip";
_pnldialog.AddView((android.view.View)(_btnok.getObject()),(int) (_dialogw-__c.DipToCurrent((int) (116))),__c.DipToCurrent((int) (125)),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 798;BA.debugLine="pnlDialog.SetLayoutAnimated(0, 20dip, 100dip, dia";
_pnldialog.SetLayoutAnimated((int) (0),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (100)),_dialogw,__c.DipToCurrent((int) (175)));
 //BA.debugLineNum = 801;BA.debugLine="pnlOverlay.Visible = True";
_pnloverlay.setVisible(__c.True);
 //BA.debugLineNum = 802;BA.debugLine="pnlOverlay.BringToFront";
_pnloverlay.BringToFront();
 //BA.debugLineNum = 803;BA.debugLine="edtGroupName.RequestFocus";
_edtgroupname.RequestFocus();
 //BA.debugLineNum = 804;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 721;BA.debugLine="Dim g As clsPasswordGroup = ModPasswords.GetGroup";
_g = parent._modpasswords._getgroupbyid /*com.lockzero.clspasswordgroup*/ (ba,_groupid);
 //BA.debugLineNum = 722;BA.debugLine="If g.IsInitialized = False Then Return";
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
 //BA.debugLineNum = 726;BA.debugLine="Wait For (xui.Msgbox2Async(g.Name, \"\", ModLang.T(";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(_g._name /*String*/ ),BA.ObjectToCharSequence(""),parent._modlang._t /*String*/ (ba,"edit"),parent._modlang._t /*String*/ (ba,"cancel"),parent._modlang._t /*String*/ (ba,"delete"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 13;
return;
case 13:
//C
this.state = 7;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 728;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
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
 //BA.debugLineNum = 730;BA.debugLine="ShowEditGroupDialog(groupId)";
parent._showeditgroupdialog(_groupid);
 if (true) break;

case 11:
//C
this.state = 12;
 //BA.debugLineNum = 733;BA.debugLine="ConfirmDeleteGroup(groupId)";
parent._confirmdeletegroup(_groupid);
 if (true) break;

case 12:
//C
this.state = -1;
;
 //BA.debugLineNum = 735;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 443;BA.debugLine="Private Sub ShowUnlockGroupDialog(groupId As Strin";
 //BA.debugLineNum = 444;BA.debugLine="Dim g As clsPasswordGroup = ModPasswords.GetGroup";
_g = _modpasswords._getgroupbyid /*com.lockzero.clspasswordgroup*/ (ba,_groupid);
 //BA.debugLineNum = 445;BA.debugLine="If g.IsInitialized = False Then Return";
if (_g._isinitialized /*boolean*/ ()==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 448;BA.debugLine="Dim remainingDelay As Int = ModSecurity.GetRemain";
_remainingdelay = _modsecurity._getremainingdelay /*int*/ (ba,_groupid);
 //BA.debugLineNum = 449;BA.debugLine="If remainingDelay > 0 Then";
if (_remainingdelay>0) { 
 //BA.debugLineNum = 450;BA.debugLine="Dim attempts As Int = ModSecurity.GetFailedAttem";
_attempts = _modsecurity._getfailedattempts /*int*/ (ba,_groupid);
 //BA.debugLineNum = 451;BA.debugLine="Dim timeStr As String = ModSecurity.FormatDelay(";
_timestr = _modsecurity._formatdelay /*String*/ (ba,_remainingdelay);
 //BA.debugLineNum = 452;BA.debugLine="ToastMessageShow(ModLang.T(\"wait_timeout\") & \" \"";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"wait_timeout")+" "+_timestr+" ("+BA.NumberToString(_attempts)+" "+_modlang._t /*String*/ (ba,"attempts")+")"),__c.True);
 //BA.debugLineNum = 453;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 456;BA.debugLine="CurrentDialogMode = \"unlock_group\"";
_currentdialogmode = "unlock_group";
 //BA.debugLineNum = 457;BA.debugLine="CurrentGroupId = groupId";
_currentgroupid = _groupid;
 //BA.debugLineNum = 458;BA.debugLine="IsPassVisible = False";
_ispassvisible = __c.False;
 //BA.debugLineNum = 461;BA.debugLine="Dim dialogW As Int = Root.Width - 40dip";
_dialogw = (int) (_root.getWidth()-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 462;BA.debugLine="pnlDialog.RemoveAllViews";
_pnldialog.RemoveAllViews();
 //BA.debugLineNum = 465;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 466;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 467;BA.debugLine="lblTitle.Text = g.Name";
_lbltitle.setText(BA.ObjectToCharSequence(_g._name /*String*/ ));
 //BA.debugLineNum = 468;BA.debugLine="lblTitle.TextSize = 16";
_lbltitle.setTextSize((float) (16));
 //BA.debugLineNum = 469;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 470;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 471;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 472;BA.debugLine="pnlDialog.AddView(lblTitle, 0, 12dip, dialogW, 24";
_pnldialog.AddView((android.view.View)(_lbltitle.getObject()),(int) (0),__c.DipToCurrent((int) (12)),_dialogw,__c.DipToCurrent((int) (24)));
 //BA.debugLineNum = 475;BA.debugLine="Dim lblSub As Label";
_lblsub = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 476;BA.debugLine="lblSub.Initialize(\"\")";
_lblsub.Initialize(ba,"");
 //BA.debugLineNum = 477;BA.debugLine="lblSub.Text = ModLang.T(\"enter_passphrase\")";
_lblsub.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"enter_passphrase")));
 //BA.debugLineNum = 478;BA.debugLine="lblSub.TextSize = 12";
_lblsub.setTextSize((float) (12));
 //BA.debugLineNum = 479;BA.debugLine="lblSub.TextColor = Colors.ARGB(180, 255, 255, 255";
_lblsub.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 480;BA.debugLine="lblSub.Gravity = Gravity.CENTER_HORIZONTAL";
_lblsub.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 481;BA.debugLine="pnlDialog.AddView(lblSub, 0, 36dip, dialogW, 20di";
_pnldialog.AddView((android.view.View)(_lblsub.getObject()),(int) (0),__c.DipToCurrent((int) (36)),_dialogw,__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 484;BA.debugLine="Dim pnlInput As Panel";
_pnlinput = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 485;BA.debugLine="pnlInput.Initialize(\"\")";
_pnlinput.Initialize(ba,"");
 //BA.debugLineNum = 486;BA.debugLine="pnlInput.Color = ModTheme.HomeBg";
_pnlinput.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 487;BA.debugLine="pnlDialog.AddView(pnlInput, 16dip, 65dip, dialogW";
_pnldialog.AddView((android.view.View)(_pnlinput.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (65)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 489;BA.debugLine="edtPassphrase.Initialize(\"edtPassphrase\")";
_edtpassphrase.Initialize(ba,"edtPassphrase");
 //BA.debugLineNum = 490;BA.debugLine="edtPassphrase.Hint = ModLang.T(\"passphrase_hint\")";
_edtpassphrase.setHint(_modlang._t /*String*/ (ba,"passphrase_hint"));
 //BA.debugLineNum = 491;BA.debugLine="edtPassphrase.SingleLine = True";
_edtpassphrase.setSingleLine(__c.True);
 //BA.debugLineNum = 492;BA.debugLine="edtPassphrase.InputType = ModSecurity.GetSecurePa";
_edtpassphrase.setInputType(_modsecurity._getsecurepassphraseinputtype /*int*/ (ba));
 //BA.debugLineNum = 493;BA.debugLine="edtPassphrase.Text = \"\"";
_edtpassphrase.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 494;BA.debugLine="edtPassphrase.TextColor = Colors.White";
_edtpassphrase.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 495;BA.debugLine="edtPassphrase.HintColor = Colors.ARGB(120, 255, 2";
_edtpassphrase.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 496;BA.debugLine="pnlInput.AddView(edtPassphrase, 8dip, 0, dialogW";
_pnlinput.AddView((android.view.View)(_edtpassphrase.getObject()),__c.DipToCurrent((int) (8)),(int) (0),(int) (_dialogw-__c.DipToCurrent((int) (32))-__c.DipToCurrent((int) (56))),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 499;BA.debugLine="btnShowPass.Initialize(\"btnShowPass\")";
_btnshowpass.Initialize(ba,"btnShowPass");
 //BA.debugLineNum = 500;BA.debugLine="btnShowPass.Text = ModLang.T(\"view\")";
_btnshowpass.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"view")));
 //BA.debugLineNum = 501;BA.debugLine="btnShowPass.TextSize = Starter.FONT_CAPTION";
_btnshowpass.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 502;BA.debugLine="btnShowPass.Color = Colors.Transparent";
_btnshowpass.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 503;BA.debugLine="btnShowPass.TextColor = Colors.ARGB(200, 255, 255";
_btnshowpass.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 504;BA.debugLine="btnShowPass.Gravity = Gravity.CENTER";
_btnshowpass.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 505;BA.debugLine="pnlInput.AddView(btnShowPass, dialogW - 32dip - 6";
_pnlinput.AddView((android.view.View)(_btnshowpass.getObject()),(int) (_dialogw-__c.DipToCurrent((int) (32))-__c.DipToCurrent((int) (65))),__c.DipToCurrent((int) (5)),__c.DipToCurrent((int) (60)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 508;BA.debugLine="Dim attempts As Int = ModSecurity.GetFailedAttemp";
_attempts = _modsecurity._getfailedattempts /*int*/ (ba,_groupid);
 //BA.debugLineNum = 509;BA.debugLine="If attempts > 0 Then";
if (_attempts>0) { 
 //BA.debugLineNum = 510;BA.debugLine="Dim lblWarn As Label";
_lblwarn = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 511;BA.debugLine="lblWarn.Initialize(\"\")";
_lblwarn.Initialize(ba,"");
 //BA.debugLineNum = 512;BA.debugLine="lblWarn.Text = attempts & \" \" & ModLang.T(\"faile";
_lblwarn.setText(BA.ObjectToCharSequence(BA.NumberToString(_attempts)+" "+_modlang._t /*String*/ (ba,"failed_attempts")));
 //BA.debugLineNum = 513;BA.debugLine="lblWarn.TextSize = 11";
_lblwarn.setTextSize((float) (11));
 //BA.debugLineNum = 514;BA.debugLine="lblWarn.TextColor = ModTheme.Warning";
_lblwarn.setTextColor(_modtheme._warning /*int*/ (ba));
 //BA.debugLineNum = 515;BA.debugLine="lblWarn.Gravity = Gravity.CENTER_HORIZONTAL";
_lblwarn.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 516;BA.debugLine="pnlDialog.AddView(lblWarn, 0, 120dip, dialogW, 1";
_pnldialog.AddView((android.view.View)(_lblwarn.getObject()),(int) (0),__c.DipToCurrent((int) (120)),_dialogw,__c.DipToCurrent((int) (18)));
 };
 //BA.debugLineNum = 520;BA.debugLine="Dim btnCancel As Button";
_btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 521;BA.debugLine="btnCancel.Initialize(\"btnDialogCancel\")";
_btncancel.Initialize(ba,"btnDialogCancel");
 //BA.debugLineNum = 522;BA.debugLine="btnCancel.Text = ModLang.T(\"cancel\")";
_btncancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 523;BA.debugLine="btnCancel.TextSize = 13";
_btncancel.setTextSize((float) (13));
 //BA.debugLineNum = 524;BA.debugLine="btnCancel.Color = Colors.Transparent";
_btncancel.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 525;BA.debugLine="btnCancel.TextColor = Colors.ARGB(200, 255, 255,";
_btncancel.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 526;BA.debugLine="pnlDialog.AddView(btnCancel, 16dip, 145dip, 100di";
_pnldialog.AddView((android.view.View)(_btncancel.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (145)),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 528;BA.debugLine="Dim btnOk As Button";
_btnok = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 529;BA.debugLine="btnOk.Initialize(\"btnDialogOk\")";
_btnok.Initialize(ba,"btnDialogOk");
 //BA.debugLineNum = 530;BA.debugLine="btnOk.Text = ModLang.T(\"unlock\")";
_btnok.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"unlock")));
 //BA.debugLineNum = 531;BA.debugLine="btnOk.TextSize = 12";
_btnok.setTextSize((float) (12));
 //BA.debugLineNum = 532;BA.debugLine="btnOk.Color = ModTheme.HomeIconBg";
_btnok.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 533;BA.debugLine="btnOk.TextColor = Colors.White";
_btnok.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 534;BA.debugLine="pnlDialog.AddView(btnOk, dialogW - 130dip, 145dip";
_pnldialog.AddView((android.view.View)(_btnok.getObject()),(int) (_dialogw-__c.DipToCurrent((int) (130))),__c.DipToCurrent((int) (145)),__c.DipToCurrent((int) (114)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 537;BA.debugLine="Dim dialogH As Int = 195dip";
_dialogh = __c.DipToCurrent((int) (195));
 //BA.debugLineNum = 538;BA.debugLine="If attempts > 0 Then dialogH = 195dip";
if (_attempts>0) { 
_dialogh = __c.DipToCurrent((int) (195));};
 //BA.debugLineNum = 539;BA.debugLine="pnlDialog.SetLayoutAnimated(0, 20dip, 80dip, dial";
_pnldialog.SetLayoutAnimated((int) (0),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (80)),_dialogw,_dialogh);
 //BA.debugLineNum = 542;BA.debugLine="pnlOverlay.Visible = True";
_pnloverlay.setVisible(__c.True);
 //BA.debugLineNum = 543;BA.debugLine="pnlOverlay.BringToFront";
_pnloverlay.BringToFront();
 //BA.debugLineNum = 544;BA.debugLine="edtPassphrase.RequestFocus";
_edtpassphrase.RequestFocus();
 //BA.debugLineNum = 545;BA.debugLine="End Sub";
return "";
}
public String  _tmrsession_tick() throws Exception{
 //BA.debugLineNum = 1086;BA.debugLine="Private Sub tmrSession_Tick";
 //BA.debugLineNum = 1089;BA.debugLine="UpdateSessionTimer";
_updatesessiontimer();
 //BA.debugLineNum = 1090;BA.debugLine="End Sub";
return "";
}
public String  _updatesearchvisibility() throws Exception{
int _headerh = 0;
int _searchh = 0;
anywheresoftware.b4a.objects.IME _ime = null;
 //BA.debugLineNum = 347;BA.debugLine="Private Sub UpdateSearchVisibility";
 //BA.debugLineNum = 348;BA.debugLine="Dim headerH As Int = 56dip";
_headerh = __c.DipToCurrent((int) (56));
 //BA.debugLineNum = 349;BA.debugLine="Dim searchH As Int = 54dip";
_searchh = __c.DipToCurrent((int) (54));
 //BA.debugLineNum = 351;BA.debugLine="pnlSearchBar.Visible = IsSearchVisible";
_pnlsearchbar.setVisible(_issearchvisible);
 //BA.debugLineNum = 353;BA.debugLine="If IsSearchVisible Then";
if (_issearchvisible) { 
 //BA.debugLineNum = 354;BA.debugLine="svGroups.Top = headerH + searchH";
_svgroups.setTop((int) (_headerh+_searchh));
 //BA.debugLineNum = 355;BA.debugLine="svGroups.Height = Root.Height - headerH - search";
_svgroups.setHeight((int) (_root.getHeight()-_headerh-_searchh));
 //BA.debugLineNum = 356;BA.debugLine="edtSearch.RequestFocus";
_edtsearch.RequestFocus();
 }else {
 //BA.debugLineNum = 358;BA.debugLine="svGroups.Top = headerH";
_svgroups.setTop(_headerh);
 //BA.debugLineNum = 359;BA.debugLine="svGroups.Height = Root.Height - headerH";
_svgroups.setHeight((int) (_root.getHeight()-_headerh));
 //BA.debugLineNum = 361;BA.debugLine="Dim ime As IME";
_ime = new anywheresoftware.b4a.objects.IME();
 //BA.debugLineNum = 362;BA.debugLine="ime.Initialize(\"\")";
_ime.Initialize("");
 //BA.debugLineNum = 363;BA.debugLine="ime.HideKeyboard";
_ime.HideKeyboard(ba);
 };
 //BA.debugLineNum = 365;BA.debugLine="End Sub";
return "";
}
public String  _updatesessiontimer() throws Exception{
int _remaining = 0;
 //BA.debugLineNum = 1092;BA.debugLine="Private Sub UpdateSessionTimer";
 //BA.debugLineNum = 1093;BA.debugLine="If ModSession.IsSessionActive Then";
if (_modsession._issessionactive /*boolean*/ (ba)) { 
 //BA.debugLineNum = 1094;BA.debugLine="lblSessionTimer.Text = ModSession.GetRemainingFo";
_lblsessiontimer.setText(BA.ObjectToCharSequence(_modsession._getremainingformatted /*String*/ (ba)));
 //BA.debugLineNum = 1097;BA.debugLine="Dim remaining As Int = ModSession.GetRemainingSe";
_remaining = _modsession._getremainingseconds /*int*/ (ba);
 //BA.debugLineNum = 1098;BA.debugLine="If remaining < 60 Then";
if (_remaining<60) { 
 //BA.debugLineNum = 1099;BA.debugLine="lblSessionTimer.TextColor = Colors.RGB(0, 220,";
_lblsessiontimer.setTextColor(__c.Colors.RGB((int) (0),(int) (220),(int) (255)));
 }else {
 //BA.debugLineNum = 1101;BA.debugLine="lblSessionTimer.TextColor = Colors.ARGB(200, 25";
_lblsessiontimer.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 };
 }else {
 //BA.debugLineNum = 1104;BA.debugLine="lblSessionTimer.Text = \"00:00\"";
_lblsessiontimer.setText(BA.ObjectToCharSequence("00:00"));
 //BA.debugLineNum = 1105;BA.debugLine="lblSessionTimer.TextColor = ModTheme.Danger";
_lblsessiontimer.setTextColor(_modtheme._danger /*int*/ (ba));
 };
 //BA.debugLineNum = 1107;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
