package com.lockzero;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class pagepasswordedit extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.lockzero.pagepasswordedit");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.lockzero.pagepasswordedit.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public String _currentgroupid = "";
public String _currententryid = "";
public boolean _iseditmode = false;
public anywheresoftware.b4a.objects.ButtonWrapper _btnsave = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _svform = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _pnlform = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtname = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edturl = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtusername = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtpassword = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtnotes = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chkfavorite = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnshowpassword = null;
public boolean _ispasswordvisible = false;
public anywheresoftware.b4a.objects.PanelWrapper _pnlstrength = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlstrengthbar = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblstrengthtext = null;
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
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
 //BA.debugLineNum = 387;BA.debugLine="Private Sub ApplyTheme";
 //BA.debugLineNum = 388;BA.debugLine="Root.Color = ModTheme.HomeBg";
_root.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 389;BA.debugLine="svForm.Color = ModTheme.HomeBg";
_svform.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 390;BA.debugLine="pnlForm.Color = ModTheme.HomeBg";
_pnlform.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 392;BA.debugLine="btnSave.Color = ModTheme.HomeIconBg";
_btnsave.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 393;BA.debugLine="btnSave.TextColor = Colors.White";
_btnsave.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 396;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 397;BA.debugLine="cd.Initialize2(ModTheme.HomeHeaderBg, 8dip, 1dip,";
_cd.Initialize2(_modtheme._homeheaderbg /*int*/ (ba),__c.DipToCurrent((int) (8)),__c.DipToCurrent((int) (1)),__c.Colors.ARGB((int) (80),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 399;BA.debugLine="edtName.Background = cd";
_edtname.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 //BA.debugLineNum = 400;BA.debugLine="edtName.TextColor = Colors.White";
_edtname.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 401;BA.debugLine="edtName.HintColor = Colors.ARGB(120, 255, 255, 25";
_edtname.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 403;BA.debugLine="edtUrl.Background = cd";
_edturl.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 //BA.debugLineNum = 404;BA.debugLine="edtUrl.TextColor = Colors.White";
_edturl.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 405;BA.debugLine="edtUrl.HintColor = Colors.ARGB(120, 255, 255, 255";
_edturl.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 407;BA.debugLine="edtUsername.Background = cd";
_edtusername.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 //BA.debugLineNum = 408;BA.debugLine="edtUsername.TextColor = Colors.White";
_edtusername.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 409;BA.debugLine="edtUsername.HintColor = Colors.ARGB(120, 255, 255";
_edtusername.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 411;BA.debugLine="edtPassword.Background = cd";
_edtpassword.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 //BA.debugLineNum = 412;BA.debugLine="edtPassword.TextColor = Colors.White";
_edtpassword.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 413;BA.debugLine="edtPassword.HintColor = Colors.ARGB(120, 255, 255";
_edtpassword.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 415;BA.debugLine="edtNotes.Background = cd";
_edtnotes.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 //BA.debugLineNum = 416;BA.debugLine="edtNotes.TextColor = Colors.White";
_edtnotes.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 417;BA.debugLine="edtNotes.HintColor = Colors.ARGB(120, 255, 255, 2";
_edtnotes.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 419;BA.debugLine="btnShowPassword.Color = ModTheme.HomeIconBg";
_btnshowpassword.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 420;BA.debugLine="btnShowPassword.TextColor = Colors.White";
_btnshowpassword.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 422;BA.debugLine="btnCancel.Color = ModTheme.HomeHeaderBg";
_btncancel.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 423;BA.debugLine="btnCancel.TextColor = Colors.White";
_btncancel.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 425;BA.debugLine="chkFavorite.TextColor = Colors.White";
_chkfavorite.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 426;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_appear() throws Exception{
 //BA.debugLineNum = 47;BA.debugLine="Private Sub B4XPage_Appear";
 //BA.debugLineNum = 49;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 52;BA.debugLine="svForm.ScrollPosition = 0";
_svform.setScrollPosition((int) (0));
 //BA.debugLineNum = 54;BA.debugLine="IsEditMode = (CurrentEntryId <> \"\")";
_iseditmode = ((_currententryid).equals("") == false);
 //BA.debugLineNum = 57;BA.debugLine="If IsEditMode Then";
if (_iseditmode) { 
 //BA.debugLineNum = 58;BA.debugLine="CallSub2(Main, \"SetPageTitle\", ModLang.T(\"edit\")";
__c.CallSubNew2(ba,(Object)(_main.getObject()),"SetPageTitle",(Object)(_modlang._t /*String*/ (ba,"edit")));
 //BA.debugLineNum = 59;BA.debugLine="LoadEntry";
_loadentry();
 }else {
 //BA.debugLineNum = 61;BA.debugLine="CallSub2(Main, \"SetPageTitle\", ModLang.T(\"new_pa";
__c.CallSubNew2(ba,(Object)(_main.getObject()),"SetPageTitle",(Object)(_modlang._t /*String*/ (ba,"new_password")));
 //BA.debugLineNum = 62;BA.debugLine="ClearForm";
_clearform();
 };
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
 //BA.debugLineNum = 41;BA.debugLine="Private Sub B4XPage_Created(Root1 As B4XView)";
 //BA.debugLineNum = 42;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 43;BA.debugLine="CreateUI";
_createui();
 //BA.debugLineNum = 44;BA.debugLine="ApplyTheme";
_applytheme();
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return "";
}
public String  _btncancel_click() throws Exception{
 //BA.debugLineNum = 255;BA.debugLine="Private Sub btnCancel_Click";
 //BA.debugLineNum = 256;BA.debugLine="B4XPages.ClosePage(Me)";
_b4xpages._closepage /*String*/ (ba,this);
 //BA.debugLineNum = 257;BA.debugLine="End Sub";
return "";
}
public String  _btnsave_click() throws Exception{
 //BA.debugLineNum = 250;BA.debugLine="Private Sub btnSave_Click";
 //BA.debugLineNum = 251;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 252;BA.debugLine="SaveEntry";
_saveentry();
 //BA.debugLineNum = 253;BA.debugLine="End Sub";
return "";
}
public String  _btnshowpassword_click() throws Exception{
 //BA.debugLineNum = 292;BA.debugLine="Private Sub btnShowPassword_Click";
 //BA.debugLineNum = 293;BA.debugLine="IsPasswordVisible = Not(IsPasswordVisible)";
_ispasswordvisible = __c.Not(_ispasswordvisible);
 //BA.debugLineNum = 294;BA.debugLine="If IsPasswordVisible Then";
if (_ispasswordvisible) { 
 //BA.debugLineNum = 295;BA.debugLine="edtPassword.InputType = edtPassword.INPUT_TYPE_T";
_edtpassword.setInputType(_edtpassword.INPUT_TYPE_TEXT);
 //BA.debugLineNum = 296;BA.debugLine="btnShowPassword.Text = ModLang.T(\"hide\")";
_btnshowpassword.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"hide")));
 //BA.debugLineNum = 297;BA.debugLine="btnShowPassword.TextColor = Colors.White";
_btnshowpassword.setTextColor(__c.Colors.White);
 }else {
 //BA.debugLineNum = 299;BA.debugLine="edtPassword.InputType = Bit.Or(edtPassword.INPUT";
_edtpassword.setInputType(__c.Bit.Or(_edtpassword.INPUT_TYPE_TEXT,(int) (128)));
 //BA.debugLineNum = 300;BA.debugLine="btnShowPassword.Text = ModLang.T(\"view\")";
_btnshowpassword.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"view")));
 //BA.debugLineNum = 301;BA.debugLine="btnShowPassword.TextColor = Colors.ARGB(200, 255";
_btnshowpassword.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 };
 //BA.debugLineNum = 303;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 4;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Public Root As B4XView  'Public para transicoes";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 6;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 9;BA.debugLine="Private CurrentGroupId As String";
_currentgroupid = "";
 //BA.debugLineNum = 10;BA.debugLine="Private CurrentEntryId As String";
_currententryid = "";
 //BA.debugLineNum = 11;BA.debugLine="Private IsEditMode As Boolean";
_iseditmode = false;
 //BA.debugLineNum = 14;BA.debugLine="Private btnSave As Button";
_btnsave = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Private btnCancel As Button";
_btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private svForm As ScrollView";
_svform = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private pnlForm As B4XView";
_pnlform = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private edtName As EditText";
_edtname = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private edtUrl As EditText";
_edturl = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private edtUsername As EditText";
_edtusername = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private edtPassword As EditText";
_edtpassword = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private edtNotes As EditText";
_edtnotes = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private chkFavorite As CheckBox";
_chkfavorite = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private btnShowPassword As Button";
_btnshowpassword = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private IsPasswordVisible As Boolean = False";
_ispasswordvisible = __c.False;
 //BA.debugLineNum = 32;BA.debugLine="Private pnlStrength As Panel";
_pnlstrength = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Private pnlStrengthBar As Panel";
_pnlstrengthbar = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Private lblStrengthText As Label";
_lblstrengthtext = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 35;BA.debugLine="End Sub";
return "";
}
public String  _clearform() throws Exception{
 //BA.debugLineNum = 237;BA.debugLine="Private Sub ClearForm";
 //BA.debugLineNum = 238;BA.debugLine="edtName.Text = \"\"";
_edtname.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 239;BA.debugLine="edtUrl.Text = \"\"";
_edturl.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 240;BA.debugLine="edtUsername.Text = \"\"";
_edtusername.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 241;BA.debugLine="edtPassword.Text = \"\"";
_edtpassword.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 242;BA.debugLine="edtNotes.Text = \"\"";
_edtnotes.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 243;BA.debugLine="chkFavorite.Checked = False";
_chkfavorite.setChecked(__c.False);
 //BA.debugLineNum = 244;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.LabelWrapper  _createfieldlabel(String _text) throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
 //BA.debugLineNum = 209;BA.debugLine="Private Sub CreateFieldLabel(text As String) As La";
 //BA.debugLineNum = 210;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 211;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(ba,"");
 //BA.debugLineNum = 212;BA.debugLine="lbl.Text = text";
_lbl.setText(BA.ObjectToCharSequence(_text));
 //BA.debugLineNum = 213;BA.debugLine="lbl.TextSize = Starter.FONT_LABEL";
_lbl.setTextSize(_starter._font_label /*float*/ );
 //BA.debugLineNum = 214;BA.debugLine="lbl.TextColor = Colors.ARGB(180, 255, 255, 255)";
_lbl.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 215;BA.debugLine="Return lbl";
if (true) return _lbl;
 //BA.debugLineNum = 216;BA.debugLine="End Sub";
return null;
}
public String  _createui() throws Exception{
int _width = 0;
int _height = 0;
int _y = 0;
int _fieldwidth = 0;
int _fieldheight = 0;
int _gap = 0;
anywheresoftware.b4a.objects.LabelWrapper _lblname = null;
anywheresoftware.b4a.objects.LabelWrapper _lblurl = null;
anywheresoftware.b4a.objects.LabelWrapper _lbluser = null;
anywheresoftware.b4a.objects.LabelWrapper _lblpass = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlbarbg = null;
anywheresoftware.b4a.objects.LabelWrapper _lblnotes = null;
 //BA.debugLineNum = 77;BA.debugLine="Private Sub CreateUI";
 //BA.debugLineNum = 78;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 79;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 82;BA.debugLine="btnCancel.Initialize(\"btnCancel\")";
_btncancel.Initialize(ba,"btnCancel");
 //BA.debugLineNum = 83;BA.debugLine="btnCancel.Text = ModLang.T(\"cancel\")";
_btncancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 84;BA.debugLine="btnCancel.TextSize = Starter.FONT_BUTTON";
_btncancel.setTextSize(_starter._font_button /*float*/ );
 //BA.debugLineNum = 85;BA.debugLine="Root.AddView(btnCancel, 10dip, height - 70dip, 90";
_root.AddView((android.view.View)(_btncancel.getObject()),__c.DipToCurrent((int) (10)),(int) (_height-__c.DipToCurrent((int) (70))),__c.DipToCurrent((int) (90)),__c.DipToCurrent((int) (48)));
 //BA.debugLineNum = 88;BA.debugLine="btnSave.Initialize(\"btnSave\")";
_btnsave.Initialize(ba,"btnSave");
 //BA.debugLineNum = 89;BA.debugLine="btnSave.Text = ModLang.T(\"save\")";
_btnsave.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"save")));
 //BA.debugLineNum = 90;BA.debugLine="btnSave.TextSize = Starter.FONT_BUTTON";
_btnsave.setTextSize(_starter._font_button /*float*/ );
 //BA.debugLineNum = 91;BA.debugLine="Root.AddView(btnSave, width - 100dip, height - 70";
_root.AddView((android.view.View)(_btnsave.getObject()),(int) (_width-__c.DipToCurrent((int) (100))),(int) (_height-__c.DipToCurrent((int) (70))),__c.DipToCurrent((int) (90)),__c.DipToCurrent((int) (48)));
 //BA.debugLineNum = 94;BA.debugLine="svForm.Initialize(0)";
_svform.Initialize(ba,(int) (0));
 //BA.debugLineNum = 95;BA.debugLine="Root.AddView(svForm, 0, 0, width, height - 80dip)";
_root.AddView((android.view.View)(_svform.getObject()),(int) (0),(int) (0),_width,(int) (_height-__c.DipToCurrent((int) (80))));
 //BA.debugLineNum = 97;BA.debugLine="pnlForm = svForm.Panel";
_pnlform = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_svform.getPanel().getObject()));
 //BA.debugLineNum = 98;BA.debugLine="pnlForm.Color = Colors.Transparent";
_pnlform.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 101;BA.debugLine="btnCancel.BringToFront";
_btncancel.BringToFront();
 //BA.debugLineNum = 102;BA.debugLine="btnSave.BringToFront";
_btnsave.BringToFront();
 //BA.debugLineNum = 104;BA.debugLine="Dim y As Int = 20dip";
_y = __c.DipToCurrent((int) (20));
 //BA.debugLineNum = 105;BA.debugLine="Dim fieldWidth As Int = width - 40dip";
_fieldwidth = (int) (_width-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 106;BA.debugLine="Dim fieldHeight As Int = 48dip  'Starter.HEIGHT_I";
_fieldheight = __c.DipToCurrent((int) (48));
 //BA.debugLineNum = 107;BA.debugLine="Dim gap As Int = 20dip";
_gap = __c.DipToCurrent((int) (20));
 //BA.debugLineNum = 110;BA.debugLine="Dim lblName As Label = CreateFieldLabel(ModLang.T";
_lblname = new anywheresoftware.b4a.objects.LabelWrapper();
_lblname = _createfieldlabel(_modlang._t /*String*/ (ba,"site_name"));
 //BA.debugLineNum = 111;BA.debugLine="pnlForm.AddView(lblName, 20dip, y, fieldWidth, 20";
_pnlform.AddView((android.view.View)(_lblname.getObject()),__c.DipToCurrent((int) (20)),_y,_fieldwidth,__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 112;BA.debugLine="y = y + 22dip";
_y = (int) (_y+__c.DipToCurrent((int) (22)));
 //BA.debugLineNum = 114;BA.debugLine="edtName.Initialize(\"edtName\")";
_edtname.Initialize(ba,"edtName");
 //BA.debugLineNum = 115;BA.debugLine="edtName.Hint = ModLang.T(\"site_name_hint\")";
_edtname.setHint(_modlang._t /*String*/ (ba,"site_name_hint"));
 //BA.debugLineNum = 116;BA.debugLine="edtName.SingleLine = True";
_edtname.setSingleLine(__c.True);
 //BA.debugLineNum = 117;BA.debugLine="edtName.InputType = Bit.Or(1, 8192) 'TEXT + CAP_W";
_edtname.setInputType(__c.Bit.Or((int) (1),(int) (8192)));
 //BA.debugLineNum = 118;BA.debugLine="pnlForm.AddView(edtName, 20dip, y, fieldWidth, fi";
_pnlform.AddView((android.view.View)(_edtname.getObject()),__c.DipToCurrent((int) (20)),_y,_fieldwidth,_fieldheight);
 //BA.debugLineNum = 119;BA.debugLine="y = y + fieldHeight + gap";
_y = (int) (_y+_fieldheight+_gap);
 //BA.debugLineNum = 122;BA.debugLine="Dim lblUrl As Label = CreateFieldLabel(ModLang.T(";
_lblurl = new anywheresoftware.b4a.objects.LabelWrapper();
_lblurl = _createfieldlabel(_modlang._t /*String*/ (ba,"url"));
 //BA.debugLineNum = 123;BA.debugLine="pnlForm.AddView(lblUrl, 20dip, y, fieldWidth, 20d";
_pnlform.AddView((android.view.View)(_lblurl.getObject()),__c.DipToCurrent((int) (20)),_y,_fieldwidth,__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 124;BA.debugLine="y = y + 22dip";
_y = (int) (_y+__c.DipToCurrent((int) (22)));
 //BA.debugLineNum = 126;BA.debugLine="edtUrl.Initialize(\"edtUrl\")";
_edturl.Initialize(ba,"edtUrl");
 //BA.debugLineNum = 127;BA.debugLine="edtUrl.Hint = \"https://...\"";
_edturl.setHint("https://...");
 //BA.debugLineNum = 128;BA.debugLine="edtUrl.SingleLine = True";
_edturl.setSingleLine(__c.True);
 //BA.debugLineNum = 129;BA.debugLine="edtUrl.InputType = Bit.Or(edtUrl.INPUT_TYPE_TEXT,";
_edturl.setInputType(__c.Bit.Or(_edturl.INPUT_TYPE_TEXT,(int) (16)));
 //BA.debugLineNum = 130;BA.debugLine="pnlForm.AddView(edtUrl, 20dip, y, fieldWidth, fie";
_pnlform.AddView((android.view.View)(_edturl.getObject()),__c.DipToCurrent((int) (20)),_y,_fieldwidth,_fieldheight);
 //BA.debugLineNum = 131;BA.debugLine="y = y + fieldHeight + gap";
_y = (int) (_y+_fieldheight+_gap);
 //BA.debugLineNum = 134;BA.debugLine="Dim lblUser As Label = CreateFieldLabel(ModLang.T";
_lbluser = new anywheresoftware.b4a.objects.LabelWrapper();
_lbluser = _createfieldlabel(_modlang._t /*String*/ (ba,"username"));
 //BA.debugLineNum = 135;BA.debugLine="pnlForm.AddView(lblUser, 20dip, y, fieldWidth, 20";
_pnlform.AddView((android.view.View)(_lbluser.getObject()),__c.DipToCurrent((int) (20)),_y,_fieldwidth,__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 136;BA.debugLine="y = y + 22dip";
_y = (int) (_y+__c.DipToCurrent((int) (22)));
 //BA.debugLineNum = 138;BA.debugLine="edtUsername.Initialize(\"edtUsername\")";
_edtusername.Initialize(ba,"edtUsername");
 //BA.debugLineNum = 139;BA.debugLine="edtUsername.Hint = ModLang.T(\"username_hint\")";
_edtusername.setHint(_modlang._t /*String*/ (ba,"username_hint"));
 //BA.debugLineNum = 140;BA.debugLine="edtUsername.SingleLine = True";
_edtusername.setSingleLine(__c.True);
 //BA.debugLineNum = 141;BA.debugLine="pnlForm.AddView(edtUsername, 20dip, y, fieldWidth";
_pnlform.AddView((android.view.View)(_edtusername.getObject()),__c.DipToCurrent((int) (20)),_y,_fieldwidth,_fieldheight);
 //BA.debugLineNum = 142;BA.debugLine="y = y + fieldHeight + gap";
_y = (int) (_y+_fieldheight+_gap);
 //BA.debugLineNum = 145;BA.debugLine="Dim lblPass As Label = CreateFieldLabel(ModLang.T";
_lblpass = new anywheresoftware.b4a.objects.LabelWrapper();
_lblpass = _createfieldlabel(_modlang._t /*String*/ (ba,"password"));
 //BA.debugLineNum = 146;BA.debugLine="pnlForm.AddView(lblPass, 20dip, y, fieldWidth, 20";
_pnlform.AddView((android.view.View)(_lblpass.getObject()),__c.DipToCurrent((int) (20)),_y,_fieldwidth,__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 147;BA.debugLine="y = y + 22dip";
_y = (int) (_y+__c.DipToCurrent((int) (22)));
 //BA.debugLineNum = 149;BA.debugLine="edtPassword.Initialize(\"edtPassword\")";
_edtpassword.Initialize(ba,"edtPassword");
 //BA.debugLineNum = 150;BA.debugLine="edtPassword.Hint = ModLang.T(\"password_hint\")";
_edtpassword.setHint(_modlang._t /*String*/ (ba,"password_hint"));
 //BA.debugLineNum = 151;BA.debugLine="edtPassword.SingleLine = True";
_edtpassword.setSingleLine(__c.True);
 //BA.debugLineNum = 152;BA.debugLine="edtPassword.InputType = Bit.Or(edtPassword.INPUT_";
_edtpassword.setInputType(__c.Bit.Or(_edtpassword.INPUT_TYPE_TEXT,(int) (128)));
 //BA.debugLineNum = 153;BA.debugLine="pnlForm.AddView(edtPassword, 20dip, y, fieldWidth";
_pnlform.AddView((android.view.View)(_edtpassword.getObject()),__c.DipToCurrent((int) (20)),_y,(int) (_fieldwidth-__c.DipToCurrent((int) (75))),_fieldheight);
 //BA.debugLineNum = 155;BA.debugLine="btnShowPassword.Initialize(\"btnShowPassword\")";
_btnshowpassword.Initialize(ba,"btnShowPassword");
 //BA.debugLineNum = 156;BA.debugLine="btnShowPassword.Text = ModLang.T(\"view\")";
_btnshowpassword.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"view")));
 //BA.debugLineNum = 157;BA.debugLine="btnShowPassword.TextSize = Starter.FONT_CAPTION";
_btnshowpassword.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 158;BA.debugLine="pnlForm.AddView(btnShowPassword, width - 85dip, y";
_pnlform.AddView((android.view.View)(_btnshowpassword.getObject()),(int) (_width-__c.DipToCurrent((int) (85))),_y,__c.DipToCurrent((int) (65)),_fieldheight);
 //BA.debugLineNum = 159;BA.debugLine="y = y + fieldHeight + 8dip";
_y = (int) (_y+_fieldheight+__c.DipToCurrent((int) (8)));
 //BA.debugLineNum = 162;BA.debugLine="pnlStrength.Initialize(\"\")";
_pnlstrength.Initialize(ba,"");
 //BA.debugLineNum = 163;BA.debugLine="pnlStrength.Color = Colors.Transparent";
_pnlstrength.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 164;BA.debugLine="pnlForm.AddView(pnlStrength, 20dip, y, fieldWidth";
_pnlform.AddView((android.view.View)(_pnlstrength.getObject()),__c.DipToCurrent((int) (20)),_y,_fieldwidth,__c.DipToCurrent((int) (24)));
 //BA.debugLineNum = 167;BA.debugLine="Dim pnlBarBg As Panel";
_pnlbarbg = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 168;BA.debugLine="pnlBarBg.Initialize(\"\")";
_pnlbarbg.Initialize(ba,"");
 //BA.debugLineNum = 169;BA.debugLine="pnlBarBg.Color = Colors.ARGB(60, 255, 255, 255)";
_pnlbarbg.setColor(__c.Colors.ARGB((int) (60),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 170;BA.debugLine="pnlStrength.AddView(pnlBarBg, 0, 4dip, fieldWidth";
_pnlstrength.AddView((android.view.View)(_pnlbarbg.getObject()),(int) (0),__c.DipToCurrent((int) (4)),(int) (_fieldwidth-__c.DipToCurrent((int) (100))),__c.DipToCurrent((int) (16)));
 //BA.debugLineNum = 173;BA.debugLine="pnlStrengthBar.Initialize(\"\")";
_pnlstrengthbar.Initialize(ba,"");
 //BA.debugLineNum = 174;BA.debugLine="pnlStrengthBar.Color = Colors.Gray";
_pnlstrengthbar.setColor(__c.Colors.Gray);
 //BA.debugLineNum = 175;BA.debugLine="pnlStrength.AddView(pnlStrengthBar, 0, 4dip, 0, 1";
_pnlstrength.AddView((android.view.View)(_pnlstrengthbar.getObject()),(int) (0),__c.DipToCurrent((int) (4)),(int) (0),__c.DipToCurrent((int) (16)));
 //BA.debugLineNum = 178;BA.debugLine="lblStrengthText.Initialize(\"\")";
_lblstrengthtext.Initialize(ba,"");
 //BA.debugLineNum = 179;BA.debugLine="lblStrengthText.Text = \"\"";
_lblstrengthtext.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 180;BA.debugLine="lblStrengthText.TextSize = Starter.FONT_CAPTION";
_lblstrengthtext.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 181;BA.debugLine="lblStrengthText.TextColor = Colors.Gray";
_lblstrengthtext.setTextColor(__c.Colors.Gray);
 //BA.debugLineNum = 182;BA.debugLine="lblStrengthText.Gravity = Gravity.RIGHT";
_lblstrengthtext.setGravity(__c.Gravity.RIGHT);
 //BA.debugLineNum = 183;BA.debugLine="pnlStrength.AddView(lblStrengthText, fieldWidth -";
_pnlstrength.AddView((android.view.View)(_lblstrengthtext.getObject()),(int) (_fieldwidth-__c.DipToCurrent((int) (95))),(int) (0),__c.DipToCurrent((int) (95)),__c.DipToCurrent((int) (24)));
 //BA.debugLineNum = 185;BA.debugLine="y = y + 24dip + 12dip";
_y = (int) (_y+__c.DipToCurrent((int) (24))+__c.DipToCurrent((int) (12)));
 //BA.debugLineNum = 188;BA.debugLine="Dim lblNotes As Label = CreateFieldLabel(ModLang.";
_lblnotes = new anywheresoftware.b4a.objects.LabelWrapper();
_lblnotes = _createfieldlabel(_modlang._t /*String*/ (ba,"note"));
 //BA.debugLineNum = 189;BA.debugLine="pnlForm.AddView(lblNotes, 20dip, y, fieldWidth, 2";
_pnlform.AddView((android.view.View)(_lblnotes.getObject()),__c.DipToCurrent((int) (20)),_y,_fieldwidth,__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 190;BA.debugLine="y = y + 22dip";
_y = (int) (_y+__c.DipToCurrent((int) (22)));
 //BA.debugLineNum = 192;BA.debugLine="edtNotes.Initialize(\"edtNotes\")";
_edtnotes.Initialize(ba,"edtNotes");
 //BA.debugLineNum = 193;BA.debugLine="edtNotes.Hint = ModLang.T(\"notes_hint\")";
_edtnotes.setHint(_modlang._t /*String*/ (ba,"notes_hint"));
 //BA.debugLineNum = 194;BA.debugLine="edtNotes.SingleLine = False";
_edtnotes.setSingleLine(__c.False);
 //BA.debugLineNum = 195;BA.debugLine="pnlForm.AddView(edtNotes, 20dip, y, fieldWidth, 1";
_pnlform.AddView((android.view.View)(_edtnotes.getObject()),__c.DipToCurrent((int) (20)),_y,_fieldwidth,__c.DipToCurrent((int) (100)));
 //BA.debugLineNum = 196;BA.debugLine="y = y + 100dip + gap";
_y = (int) (_y+__c.DipToCurrent((int) (100))+_gap);
 //BA.debugLineNum = 199;BA.debugLine="chkFavorite.Initialize(\"chkFavorite\")";
_chkfavorite.Initialize(ba,"chkFavorite");
 //BA.debugLineNum = 200;BA.debugLine="chkFavorite.Text = ModLang.T(\"favorite\")";
_chkfavorite.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"favorite")));
 //BA.debugLineNum = 201;BA.debugLine="chkFavorite.TextColor = ModTheme.TextPrimary";
_chkfavorite.setTextColor(_modtheme._textprimary /*int*/ (ba));
 //BA.debugLineNum = 202;BA.debugLine="pnlForm.AddView(chkFavorite, 20dip, y, fieldWidth";
_pnlform.AddView((android.view.View)(_chkfavorite.getObject()),__c.DipToCurrent((int) (20)),_y,_fieldwidth,__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 203;BA.debugLine="y = y + 60dip";
_y = (int) (_y+__c.DipToCurrent((int) (60)));
 //BA.debugLineNum = 206;BA.debugLine="pnlForm.Height = y + 300dip";
_pnlform.setHeight((int) (_y+__c.DipToCurrent((int) (300))));
 //BA.debugLineNum = 207;BA.debugLine="End Sub";
return "";
}
public String  _edtname_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 263;BA.debugLine="Private Sub edtName_FocusChanged(HasFocus As Boole";
 //BA.debugLineNum = 264;BA.debugLine="If HasFocus Then ScrollToView(edtName)";
if (_hasfocus) { 
_scrolltoview((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_edtname.getObject())));};
 //BA.debugLineNum = 265;BA.debugLine="End Sub";
return "";
}
public String  _edtnotes_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 279;BA.debugLine="Private Sub edtNotes_FocusChanged(HasFocus As Bool";
 //BA.debugLineNum = 280;BA.debugLine="If HasFocus Then ScrollToView(edtNotes)";
if (_hasfocus) { 
_scrolltoview((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_edtnotes.getObject())));};
 //BA.debugLineNum = 281;BA.debugLine="End Sub";
return "";
}
public String  _edtpassword_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 275;BA.debugLine="Private Sub edtPassword_FocusChanged(HasFocus As B";
 //BA.debugLineNum = 276;BA.debugLine="If HasFocus Then ScrollToView(edtPassword)";
if (_hasfocus) { 
_scrolltoview((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_edtpassword.getObject())));};
 //BA.debugLineNum = 277;BA.debugLine="End Sub";
return "";
}
public String  _edtpassword_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 306;BA.debugLine="Private Sub edtPassword_TextChanged(Old As String,";
 //BA.debugLineNum = 307;BA.debugLine="UpdateStrengthIndicator(New)";
_updatestrengthindicator(_new);
 //BA.debugLineNum = 308;BA.debugLine="End Sub";
return "";
}
public String  _edturl_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 267;BA.debugLine="Private Sub edtUrl_FocusChanged(HasFocus As Boolea";
 //BA.debugLineNum = 268;BA.debugLine="If HasFocus Then ScrollToView(edtUrl)";
if (_hasfocus) { 
_scrolltoview((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_edturl.getObject())));};
 //BA.debugLineNum = 269;BA.debugLine="End Sub";
return "";
}
public String  _edtusername_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 271;BA.debugLine="Private Sub edtUsername_FocusChanged(HasFocus As B";
 //BA.debugLineNum = 272;BA.debugLine="If HasFocus Then ScrollToView(edtUsername)";
if (_hasfocus) { 
_scrolltoview((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_edtusername.getObject())));};
 //BA.debugLineNum = 273;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 37;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 39;BA.debugLine="End Sub";
return "";
}
public String  _loadentry() throws Exception{
com.lockzero.clspasswordentry _e = null;
 //BA.debugLineNum = 222;BA.debugLine="Private Sub LoadEntry";
 //BA.debugLineNum = 223;BA.debugLine="Dim e As clsPasswordEntry = ModPasswords.GetEntry";
_e = _modpasswords._getentrybyid /*com.lockzero.clspasswordentry*/ (ba,_currententryid);
 //BA.debugLineNum = 224;BA.debugLine="If e.IsInitialized = False Then Return";
if (_e._isinitialized /*boolean*/ ()==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 226;BA.debugLine="edtName.Text = e.Name";
_edtname.setText(BA.ObjectToCharSequence(_e._name /*String*/ ));
 //BA.debugLineNum = 227;BA.debugLine="edtUrl.Text = e.Url";
_edturl.setText(BA.ObjectToCharSequence(_e._url /*String*/ ));
 //BA.debugLineNum = 228;BA.debugLine="edtUsername.Text = ModPasswords.DecryptValue(e.Us";
_edtusername.setText(BA.ObjectToCharSequence(_modpasswords._decryptvalue /*String*/ (ba,_e._username /*String*/ )));
 //BA.debugLineNum = 229;BA.debugLine="edtPassword.Text = ModPasswords.DecryptValue(e.Pa";
_edtpassword.setText(BA.ObjectToCharSequence(_modpasswords._decryptvalue /*String*/ (ba,_e._passwordenc /*String*/ )));
 //BA.debugLineNum = 230;BA.debugLine="edtNotes.Text = ModPasswords.DecryptValue(e.Notes";
_edtnotes.setText(BA.ObjectToCharSequence(_modpasswords._decryptvalue /*String*/ (ba,_e._notes /*String*/ )));
 //BA.debugLineNum = 231;BA.debugLine="chkFavorite.Checked = e.IsFavorite";
_chkfavorite.setChecked(_e._isfavorite /*boolean*/ );
 //BA.debugLineNum = 234;BA.debugLine="UpdateStrengthIndicator(edtPassword.Text)";
_updatestrengthindicator(_edtpassword.getText());
 //BA.debugLineNum = 235;BA.debugLine="End Sub";
return "";
}
public String  _saveentry() throws Exception{
String _name = "";
String _password = "";
com.lockzero.clspasswordentry _e = null;
 //BA.debugLineNum = 339;BA.debugLine="Private Sub SaveEntry";
 //BA.debugLineNum = 340;BA.debugLine="If ModSession.IsSessionActive = False Then";
if (_modsession._issessionactive /*boolean*/ (ba)==__c.False) { 
 //BA.debugLineNum = 341;BA.debugLine="ToastMessageShow(ModLang.T(\"session_expired\"), T";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"session_expired")),__c.True);
 //BA.debugLineNum = 342;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 346;BA.debugLine="Dim name As String = edtName.Text.Trim";
_name = _edtname.getText().trim();
 //BA.debugLineNum = 347;BA.debugLine="Dim password As String = edtPassword.Text.Trim";
_password = _edtpassword.getText().trim();
 //BA.debugLineNum = 349;BA.debugLine="If name = \"\" And edtUrl.Text.Trim = \"\" Then";
if ((_name).equals("") && (_edturl.getText().trim()).equals("")) { 
 //BA.debugLineNum = 350;BA.debugLine="ToastMessageShow(ModLang.T(\"error_empty_field\"),";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error_empty_field")),__c.True);
 //BA.debugLineNum = 351;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 354;BA.debugLine="If password = \"\" Then";
if ((_password).equals("")) { 
 //BA.debugLineNum = 355;BA.debugLine="ToastMessageShow(ModLang.T(\"error_empty_field\")";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error_empty_field")+" (senha)"),__c.True);
 //BA.debugLineNum = 356;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 360;BA.debugLine="Dim e As clsPasswordEntry";
_e = new com.lockzero.clspasswordentry();
 //BA.debugLineNum = 361;BA.debugLine="If IsEditMode Then";
if (_iseditmode) { 
 //BA.debugLineNum = 362;BA.debugLine="e = ModPasswords.GetEntryById(CurrentEntryId)";
_e = _modpasswords._getentrybyid /*com.lockzero.clspasswordentry*/ (ba,_currententryid);
 }else {
 //BA.debugLineNum = 364;BA.debugLine="e.Initialize";
_e._initialize /*String*/ (ba);
 //BA.debugLineNum = 365;BA.debugLine="e.GroupId = CurrentGroupId";
_e._groupid /*String*/  = _currentgroupid;
 };
 //BA.debugLineNum = 369;BA.debugLine="e.Name = name";
_e._name /*String*/  = _name;
 //BA.debugLineNum = 370;BA.debugLine="e.Url = edtUrl.Text.Trim";
_e._url /*String*/  = _edturl.getText().trim();
 //BA.debugLineNum = 371;BA.debugLine="e.Username = ModPasswords.EncryptValue(edtUsernam";
_e._username /*String*/  = _modpasswords._encryptvalue /*String*/ (ba,_edtusername.getText().trim());
 //BA.debugLineNum = 372;BA.debugLine="e.PasswordEnc = ModPasswords.EncryptValue(passwor";
_e._passwordenc /*String*/  = _modpasswords._encryptvalue /*String*/ (ba,_password);
 //BA.debugLineNum = 373;BA.debugLine="e.Notes = ModPasswords.EncryptValue(edtNotes.Text";
_e._notes /*String*/  = _modpasswords._encryptvalue /*String*/ (ba,_edtnotes.getText().trim());
 //BA.debugLineNum = 374;BA.debugLine="e.IsFavorite = chkFavorite.Checked";
_e._isfavorite /*boolean*/  = _chkfavorite.getChecked();
 //BA.debugLineNum = 377;BA.debugLine="ModPasswords.SaveEntry(e)";
_modpasswords._saveentry /*String*/ (ba,_e);
 //BA.debugLineNum = 379;BA.debugLine="ToastMessageShow(ModLang.T(\"success\"), False)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"success")),__c.False);
 //BA.debugLineNum = 380;BA.debugLine="B4XPages.ClosePage(Me)";
_b4xpages._closepage /*String*/ (ba,this);
 //BA.debugLineNum = 381;BA.debugLine="End Sub";
return "";
}
public String  _scrolltoview(anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
int _targety = 0;
 //BA.debugLineNum = 283;BA.debugLine="Private Sub ScrollToView(v As View)";
 //BA.debugLineNum = 285;BA.debugLine="Dim targetY As Int = v.Top - 50dip 'Um pouco acim";
_targety = (int) (_v.getTop()-__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 286;BA.debugLine="If targetY < 0 Then targetY = 0";
if (_targety<0) { 
_targety = (int) (0);};
 //BA.debugLineNum = 289;BA.debugLine="svForm.ScrollPosition = targetY";
_svform.setScrollPosition(_targety);
 //BA.debugLineNum = 290;BA.debugLine="End Sub";
return "";
}
public String  _setparams(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
 //BA.debugLineNum = 67;BA.debugLine="Public Sub SetParams(params As Map)";
 //BA.debugLineNum = 68;BA.debugLine="If params = Null Then Return";
if (_params== null) { 
if (true) return "";};
 //BA.debugLineNum = 69;BA.debugLine="CurrentGroupId = params.GetDefault(\"groupId\", \"\")";
_currentgroupid = BA.ObjectToString(_params.GetDefault((Object)("groupId"),(Object)("")));
 //BA.debugLineNum = 70;BA.debugLine="CurrentEntryId = params.GetDefault(\"entryId\", \"\")";
_currententryid = BA.ObjectToString(_params.GetDefault((Object)("entryId"),(Object)("")));
 //BA.debugLineNum = 71;BA.debugLine="End Sub";
return "";
}
public String  _updatestrengthindicator(String _password) throws Exception{
int _strength = 0;
int _strengthcolor = 0;
String _strengthtext = "";
int _maxbarwidth = 0;
int _barwidth = 0;
 //BA.debugLineNum = 311;BA.debugLine="Private Sub UpdateStrengthIndicator(password As St";
 //BA.debugLineNum = 312;BA.debugLine="If password.Length = 0 Then";
if (_password.length()==0) { 
 //BA.debugLineNum = 314;BA.debugLine="pnlStrengthBar.Width = 0";
_pnlstrengthbar.setWidth((int) (0));
 //BA.debugLineNum = 315;BA.debugLine="lblStrengthText.Text = \"\"";
_lblstrengthtext.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 316;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 320;BA.debugLine="Dim strength As Int = ModSecurity.CalculatePasswo";
_strength = _modsecurity._calculatepasswordstrength /*int*/ (ba,_password);
 //BA.debugLineNum = 321;BA.debugLine="Dim strengthColor As Int = ModSecurity.GetStrengt";
_strengthcolor = _modsecurity._getstrengthcolor /*int*/ (ba,_strength);
 //BA.debugLineNum = 322;BA.debugLine="Dim strengthText As String = ModSecurity.GetStren";
_strengthtext = _modsecurity._getstrengthtext /*String*/ (ba,_strength);
 //BA.debugLineNum = 325;BA.debugLine="Dim maxBarWidth As Int = pnlStrength.Width - 100d";
_maxbarwidth = (int) (_pnlstrength.getWidth()-__c.DipToCurrent((int) (100)));
 //BA.debugLineNum = 326;BA.debugLine="Dim barWidth As Int = maxBarWidth * (strength + 1";
_barwidth = (int) (_maxbarwidth*(_strength+1)/(double)4);
 //BA.debugLineNum = 329;BA.debugLine="pnlStrengthBar.Color = strengthColor";
_pnlstrengthbar.setColor(_strengthcolor);
 //BA.debugLineNum = 330;BA.debugLine="pnlStrengthBar.Width = barWidth";
_pnlstrengthbar.setWidth(_barwidth);
 //BA.debugLineNum = 331;BA.debugLine="lblStrengthText.Text = strengthText";
_lblstrengthtext.setText(BA.ObjectToCharSequence(_strengthtext));
 //BA.debugLineNum = 332;BA.debugLine="lblStrengthText.TextColor = strengthColor";
_lblstrengthtext.setTextColor(_strengthcolor);
 //BA.debugLineNum = 333;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
