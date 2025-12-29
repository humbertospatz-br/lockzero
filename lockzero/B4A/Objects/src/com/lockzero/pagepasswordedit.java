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
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
 //BA.debugLineNum = 322;BA.debugLine="Private Sub ApplyTheme";
 //BA.debugLineNum = 323;BA.debugLine="Root.Color = ModTheme.HomeBg";
_root.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 324;BA.debugLine="svForm.Color = ModTheme.HomeBg";
_svform.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 325;BA.debugLine="pnlForm.Color = ModTheme.HomeBg";
_pnlform.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 327;BA.debugLine="btnSave.Color = ModTheme.HomeIconBg";
_btnsave.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 328;BA.debugLine="btnSave.TextColor = Colors.White";
_btnsave.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 331;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 332;BA.debugLine="cd.Initialize2(ModTheme.HomeHeaderBg, 8dip, 1dip,";
_cd.Initialize2(_modtheme._homeheaderbg /*int*/ (ba),__c.DipToCurrent((int) (8)),__c.DipToCurrent((int) (1)),__c.Colors.ARGB((int) (80),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 334;BA.debugLine="edtName.Background = cd";
_edtname.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 //BA.debugLineNum = 335;BA.debugLine="edtName.TextColor = Colors.White";
_edtname.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 336;BA.debugLine="edtName.HintColor = Colors.ARGB(120, 255, 255, 25";
_edtname.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 338;BA.debugLine="edtUrl.Background = cd";
_edturl.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 //BA.debugLineNum = 339;BA.debugLine="edtUrl.TextColor = Colors.White";
_edturl.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 340;BA.debugLine="edtUrl.HintColor = Colors.ARGB(120, 255, 255, 255";
_edturl.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 342;BA.debugLine="edtUsername.Background = cd";
_edtusername.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 //BA.debugLineNum = 343;BA.debugLine="edtUsername.TextColor = Colors.White";
_edtusername.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 344;BA.debugLine="edtUsername.HintColor = Colors.ARGB(120, 255, 255";
_edtusername.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 346;BA.debugLine="edtPassword.Background = cd";
_edtpassword.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 //BA.debugLineNum = 347;BA.debugLine="edtPassword.TextColor = Colors.White";
_edtpassword.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 348;BA.debugLine="edtPassword.HintColor = Colors.ARGB(120, 255, 255";
_edtpassword.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 350;BA.debugLine="edtNotes.Background = cd";
_edtnotes.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 //BA.debugLineNum = 351;BA.debugLine="edtNotes.TextColor = Colors.White";
_edtnotes.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 352;BA.debugLine="edtNotes.HintColor = Colors.ARGB(120, 255, 255, 2";
_edtnotes.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 354;BA.debugLine="btnShowPassword.Color = ModTheme.HomeIconBg";
_btnshowpassword.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 355;BA.debugLine="btnShowPassword.TextColor = Colors.White";
_btnshowpassword.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 357;BA.debugLine="btnCancel.Color = ModTheme.HomeHeaderBg";
_btncancel.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 358;BA.debugLine="btnCancel.TextColor = Colors.White";
_btncancel.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 360;BA.debugLine="chkFavorite.TextColor = Colors.White";
_chkfavorite.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 361;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_appear() throws Exception{
 //BA.debugLineNum = 42;BA.debugLine="Private Sub B4XPage_Appear";
 //BA.debugLineNum = 43;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 46;BA.debugLine="svForm.ScrollPosition = 0";
_svform.setScrollPosition((int) (0));
 //BA.debugLineNum = 48;BA.debugLine="IsEditMode = (CurrentEntryId <> \"\")";
_iseditmode = ((_currententryid).equals("") == false);
 //BA.debugLineNum = 51;BA.debugLine="If IsEditMode Then";
if (_iseditmode) { 
 //BA.debugLineNum = 52;BA.debugLine="CallSub2(Main, \"SetPageTitle\", ModLang.T(\"edit\")";
__c.CallSubNew2(ba,(Object)(_main.getObject()),"SetPageTitle",(Object)(_modlang._t /*String*/ (ba,"edit")));
 //BA.debugLineNum = 53;BA.debugLine="LoadEntry";
_loadentry();
 }else {
 //BA.debugLineNum = 55;BA.debugLine="CallSub2(Main, \"SetPageTitle\", ModLang.T(\"new_pa";
__c.CallSubNew2(ba,(Object)(_main.getObject()),"SetPageTitle",(Object)(_modlang._t /*String*/ (ba,"new_password")));
 //BA.debugLineNum = 56;BA.debugLine="ClearForm";
_clearform();
 };
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
 //BA.debugLineNum = 36;BA.debugLine="Private Sub B4XPage_Created(Root1 As B4XView)";
 //BA.debugLineNum = 37;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 38;BA.debugLine="CreateUI";
_createui();
 //BA.debugLineNum = 39;BA.debugLine="ApplyTheme";
_applytheme();
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return "";
}
public String  _btncancel_click() throws Exception{
 //BA.debugLineNum = 220;BA.debugLine="Private Sub btnCancel_Click";
 //BA.debugLineNum = 221;BA.debugLine="B4XPages.ClosePage(Me)";
_b4xpages._closepage /*String*/ (ba,this);
 //BA.debugLineNum = 222;BA.debugLine="End Sub";
return "";
}
public String  _btnsave_click() throws Exception{
 //BA.debugLineNum = 215;BA.debugLine="Private Sub btnSave_Click";
 //BA.debugLineNum = 216;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 217;BA.debugLine="SaveEntry";
_saveentry();
 //BA.debugLineNum = 218;BA.debugLine="End Sub";
return "";
}
public String  _btnshowpassword_click() throws Exception{
 //BA.debugLineNum = 257;BA.debugLine="Private Sub btnShowPassword_Click";
 //BA.debugLineNum = 258;BA.debugLine="IsPasswordVisible = Not(IsPasswordVisible)";
_ispasswordvisible = __c.Not(_ispasswordvisible);
 //BA.debugLineNum = 259;BA.debugLine="If IsPasswordVisible Then";
if (_ispasswordvisible) { 
 //BA.debugLineNum = 260;BA.debugLine="edtPassword.InputType = edtPassword.INPUT_TYPE_T";
_edtpassword.setInputType(_edtpassword.INPUT_TYPE_TEXT);
 //BA.debugLineNum = 261;BA.debugLine="btnShowPassword.Text = ModLang.T(\"hide\")";
_btnshowpassword.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"hide")));
 //BA.debugLineNum = 262;BA.debugLine="btnShowPassword.TextColor = Colors.White";
_btnshowpassword.setTextColor(__c.Colors.White);
 }else {
 //BA.debugLineNum = 264;BA.debugLine="edtPassword.InputType = Bit.Or(edtPassword.INPUT";
_edtpassword.setInputType(__c.Bit.Or(_edtpassword.INPUT_TYPE_TEXT,(int) (128)));
 //BA.debugLineNum = 265;BA.debugLine="btnShowPassword.Text = ModLang.T(\"view\")";
_btnshowpassword.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"view")));
 //BA.debugLineNum = 266;BA.debugLine="btnShowPassword.TextColor = Colors.ARGB(200, 255";
_btnshowpassword.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 };
 //BA.debugLineNum = 268;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return "";
}
public String  _clearform() throws Exception{
 //BA.debugLineNum = 202;BA.debugLine="Private Sub ClearForm";
 //BA.debugLineNum = 203;BA.debugLine="edtName.Text = \"\"";
_edtname.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 204;BA.debugLine="edtUrl.Text = \"\"";
_edturl.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 205;BA.debugLine="edtUsername.Text = \"\"";
_edtusername.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 206;BA.debugLine="edtPassword.Text = \"\"";
_edtpassword.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 207;BA.debugLine="edtNotes.Text = \"\"";
_edtnotes.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 208;BA.debugLine="chkFavorite.Checked = False";
_chkfavorite.setChecked(__c.False);
 //BA.debugLineNum = 209;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.LabelWrapper  _createfieldlabel(String _text) throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
 //BA.debugLineNum = 177;BA.debugLine="Private Sub CreateFieldLabel(text As String) As La";
 //BA.debugLineNum = 178;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 179;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(ba,"");
 //BA.debugLineNum = 180;BA.debugLine="lbl.Text = text";
_lbl.setText(BA.ObjectToCharSequence(_text));
 //BA.debugLineNum = 181;BA.debugLine="lbl.TextSize = Starter.FONT_LABEL";
_lbl.setTextSize(_starter._font_label /*float*/ );
 //BA.debugLineNum = 182;BA.debugLine="lbl.TextColor = Colors.ARGB(180, 255, 255, 255)";
_lbl.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 183;BA.debugLine="Return lbl";
if (true) return _lbl;
 //BA.debugLineNum = 184;BA.debugLine="End Sub";
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
anywheresoftware.b4a.objects.LabelWrapper _lblnotes = null;
 //BA.debugLineNum = 71;BA.debugLine="Private Sub CreateUI";
 //BA.debugLineNum = 72;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 73;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 76;BA.debugLine="btnCancel.Initialize(\"btnCancel\")";
_btncancel.Initialize(ba,"btnCancel");
 //BA.debugLineNum = 77;BA.debugLine="btnCancel.Text = ModLang.T(\"cancel\")";
_btncancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 78;BA.debugLine="btnCancel.TextSize = Starter.FONT_BUTTON";
_btncancel.setTextSize(_starter._font_button /*float*/ );
 //BA.debugLineNum = 79;BA.debugLine="Root.AddView(btnCancel, 10dip, height - 70dip, 90";
_root.AddView((android.view.View)(_btncancel.getObject()),__c.DipToCurrent((int) (10)),(int) (_height-__c.DipToCurrent((int) (70))),__c.DipToCurrent((int) (90)),__c.DipToCurrent((int) (48)));
 //BA.debugLineNum = 82;BA.debugLine="btnSave.Initialize(\"btnSave\")";
_btnsave.Initialize(ba,"btnSave");
 //BA.debugLineNum = 83;BA.debugLine="btnSave.Text = ModLang.T(\"save\")";
_btnsave.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"save")));
 //BA.debugLineNum = 84;BA.debugLine="btnSave.TextSize = Starter.FONT_BUTTON";
_btnsave.setTextSize(_starter._font_button /*float*/ );
 //BA.debugLineNum = 85;BA.debugLine="Root.AddView(btnSave, width - 100dip, height - 70";
_root.AddView((android.view.View)(_btnsave.getObject()),(int) (_width-__c.DipToCurrent((int) (100))),(int) (_height-__c.DipToCurrent((int) (70))),__c.DipToCurrent((int) (90)),__c.DipToCurrent((int) (48)));
 //BA.debugLineNum = 88;BA.debugLine="svForm.Initialize(0)";
_svform.Initialize(ba,(int) (0));
 //BA.debugLineNum = 89;BA.debugLine="Root.AddView(svForm, 0, 0, width, height - 80dip)";
_root.AddView((android.view.View)(_svform.getObject()),(int) (0),(int) (0),_width,(int) (_height-__c.DipToCurrent((int) (80))));
 //BA.debugLineNum = 91;BA.debugLine="pnlForm = svForm.Panel";
_pnlform = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_svform.getPanel().getObject()));
 //BA.debugLineNum = 92;BA.debugLine="pnlForm.Color = Colors.Transparent";
_pnlform.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 95;BA.debugLine="btnCancel.BringToFront";
_btncancel.BringToFront();
 //BA.debugLineNum = 96;BA.debugLine="btnSave.BringToFront";
_btnsave.BringToFront();
 //BA.debugLineNum = 98;BA.debugLine="Dim y As Int = 20dip";
_y = __c.DipToCurrent((int) (20));
 //BA.debugLineNum = 99;BA.debugLine="Dim fieldWidth As Int = width - 40dip";
_fieldwidth = (int) (_width-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 100;BA.debugLine="Dim fieldHeight As Int = 48dip  'Starter.HEIGHT_I";
_fieldheight = __c.DipToCurrent((int) (48));
 //BA.debugLineNum = 101;BA.debugLine="Dim gap As Int = 20dip";
_gap = __c.DipToCurrent((int) (20));
 //BA.debugLineNum = 104;BA.debugLine="Dim lblName As Label = CreateFieldLabel(ModLang.T";
_lblname = new anywheresoftware.b4a.objects.LabelWrapper();
_lblname = _createfieldlabel(_modlang._t /*String*/ (ba,"site_name"));
 //BA.debugLineNum = 105;BA.debugLine="pnlForm.AddView(lblName, 20dip, y, fieldWidth, 20";
_pnlform.AddView((android.view.View)(_lblname.getObject()),__c.DipToCurrent((int) (20)),_y,_fieldwidth,__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 106;BA.debugLine="y = y + 22dip";
_y = (int) (_y+__c.DipToCurrent((int) (22)));
 //BA.debugLineNum = 108;BA.debugLine="edtName.Initialize(\"edtName\")";
_edtname.Initialize(ba,"edtName");
 //BA.debugLineNum = 109;BA.debugLine="edtName.Hint = ModLang.T(\"site_name_hint\")";
_edtname.setHint(_modlang._t /*String*/ (ba,"site_name_hint"));
 //BA.debugLineNum = 110;BA.debugLine="edtName.SingleLine = True";
_edtname.setSingleLine(__c.True);
 //BA.debugLineNum = 111;BA.debugLine="edtName.InputType = Bit.Or(1, 8192) 'TEXT + CAP_W";
_edtname.setInputType(__c.Bit.Or((int) (1),(int) (8192)));
 //BA.debugLineNum = 112;BA.debugLine="pnlForm.AddView(edtName, 20dip, y, fieldWidth, fi";
_pnlform.AddView((android.view.View)(_edtname.getObject()),__c.DipToCurrent((int) (20)),_y,_fieldwidth,_fieldheight);
 //BA.debugLineNum = 113;BA.debugLine="y = y + fieldHeight + gap";
_y = (int) (_y+_fieldheight+_gap);
 //BA.debugLineNum = 116;BA.debugLine="Dim lblUrl As Label = CreateFieldLabel(ModLang.T(";
_lblurl = new anywheresoftware.b4a.objects.LabelWrapper();
_lblurl = _createfieldlabel(_modlang._t /*String*/ (ba,"url"));
 //BA.debugLineNum = 117;BA.debugLine="pnlForm.AddView(lblUrl, 20dip, y, fieldWidth, 20d";
_pnlform.AddView((android.view.View)(_lblurl.getObject()),__c.DipToCurrent((int) (20)),_y,_fieldwidth,__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 118;BA.debugLine="y = y + 22dip";
_y = (int) (_y+__c.DipToCurrent((int) (22)));
 //BA.debugLineNum = 120;BA.debugLine="edtUrl.Initialize(\"edtUrl\")";
_edturl.Initialize(ba,"edtUrl");
 //BA.debugLineNum = 121;BA.debugLine="edtUrl.Hint = \"https://...\"";
_edturl.setHint("https://...");
 //BA.debugLineNum = 122;BA.debugLine="edtUrl.SingleLine = True";
_edturl.setSingleLine(__c.True);
 //BA.debugLineNum = 123;BA.debugLine="edtUrl.InputType = Bit.Or(edtUrl.INPUT_TYPE_TEXT,";
_edturl.setInputType(__c.Bit.Or(_edturl.INPUT_TYPE_TEXT,(int) (16)));
 //BA.debugLineNum = 124;BA.debugLine="pnlForm.AddView(edtUrl, 20dip, y, fieldWidth, fie";
_pnlform.AddView((android.view.View)(_edturl.getObject()),__c.DipToCurrent((int) (20)),_y,_fieldwidth,_fieldheight);
 //BA.debugLineNum = 125;BA.debugLine="y = y + fieldHeight + gap";
_y = (int) (_y+_fieldheight+_gap);
 //BA.debugLineNum = 128;BA.debugLine="Dim lblUser As Label = CreateFieldLabel(ModLang.T";
_lbluser = new anywheresoftware.b4a.objects.LabelWrapper();
_lbluser = _createfieldlabel(_modlang._t /*String*/ (ba,"username"));
 //BA.debugLineNum = 129;BA.debugLine="pnlForm.AddView(lblUser, 20dip, y, fieldWidth, 20";
_pnlform.AddView((android.view.View)(_lbluser.getObject()),__c.DipToCurrent((int) (20)),_y,_fieldwidth,__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 130;BA.debugLine="y = y + 22dip";
_y = (int) (_y+__c.DipToCurrent((int) (22)));
 //BA.debugLineNum = 132;BA.debugLine="edtUsername.Initialize(\"edtUsername\")";
_edtusername.Initialize(ba,"edtUsername");
 //BA.debugLineNum = 133;BA.debugLine="edtUsername.Hint = ModLang.T(\"username_hint\")";
_edtusername.setHint(_modlang._t /*String*/ (ba,"username_hint"));
 //BA.debugLineNum = 134;BA.debugLine="edtUsername.SingleLine = True";
_edtusername.setSingleLine(__c.True);
 //BA.debugLineNum = 135;BA.debugLine="pnlForm.AddView(edtUsername, 20dip, y, fieldWidth";
_pnlform.AddView((android.view.View)(_edtusername.getObject()),__c.DipToCurrent((int) (20)),_y,_fieldwidth,_fieldheight);
 //BA.debugLineNum = 136;BA.debugLine="y = y + fieldHeight + gap";
_y = (int) (_y+_fieldheight+_gap);
 //BA.debugLineNum = 139;BA.debugLine="Dim lblPass As Label = CreateFieldLabel(ModLang.T";
_lblpass = new anywheresoftware.b4a.objects.LabelWrapper();
_lblpass = _createfieldlabel(_modlang._t /*String*/ (ba,"password"));
 //BA.debugLineNum = 140;BA.debugLine="pnlForm.AddView(lblPass, 20dip, y, fieldWidth, 20";
_pnlform.AddView((android.view.View)(_lblpass.getObject()),__c.DipToCurrent((int) (20)),_y,_fieldwidth,__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 141;BA.debugLine="y = y + 22dip";
_y = (int) (_y+__c.DipToCurrent((int) (22)));
 //BA.debugLineNum = 143;BA.debugLine="edtPassword.Initialize(\"edtPassword\")";
_edtpassword.Initialize(ba,"edtPassword");
 //BA.debugLineNum = 144;BA.debugLine="edtPassword.Hint = ModLang.T(\"password_hint\")";
_edtpassword.setHint(_modlang._t /*String*/ (ba,"password_hint"));
 //BA.debugLineNum = 145;BA.debugLine="edtPassword.SingleLine = True";
_edtpassword.setSingleLine(__c.True);
 //BA.debugLineNum = 146;BA.debugLine="edtPassword.InputType = Bit.Or(edtPassword.INPUT_";
_edtpassword.setInputType(__c.Bit.Or(_edtpassword.INPUT_TYPE_TEXT,(int) (128)));
 //BA.debugLineNum = 147;BA.debugLine="pnlForm.AddView(edtPassword, 20dip, y, fieldWidth";
_pnlform.AddView((android.view.View)(_edtpassword.getObject()),__c.DipToCurrent((int) (20)),_y,(int) (_fieldwidth-__c.DipToCurrent((int) (75))),_fieldheight);
 //BA.debugLineNum = 149;BA.debugLine="btnShowPassword.Initialize(\"btnShowPassword\")";
_btnshowpassword.Initialize(ba,"btnShowPassword");
 //BA.debugLineNum = 150;BA.debugLine="btnShowPassword.Text = ModLang.T(\"view\")";
_btnshowpassword.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"view")));
 //BA.debugLineNum = 151;BA.debugLine="btnShowPassword.TextSize = Starter.FONT_CAPTION";
_btnshowpassword.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 152;BA.debugLine="pnlForm.AddView(btnShowPassword, width - 85dip, y";
_pnlform.AddView((android.view.View)(_btnshowpassword.getObject()),(int) (_width-__c.DipToCurrent((int) (85))),_y,__c.DipToCurrent((int) (65)),_fieldheight);
 //BA.debugLineNum = 153;BA.debugLine="y = y + fieldHeight + gap";
_y = (int) (_y+_fieldheight+_gap);
 //BA.debugLineNum = 156;BA.debugLine="Dim lblNotes As Label = CreateFieldLabel(ModLang.";
_lblnotes = new anywheresoftware.b4a.objects.LabelWrapper();
_lblnotes = _createfieldlabel(_modlang._t /*String*/ (ba,"note"));
 //BA.debugLineNum = 157;BA.debugLine="pnlForm.AddView(lblNotes, 20dip, y, fieldWidth, 2";
_pnlform.AddView((android.view.View)(_lblnotes.getObject()),__c.DipToCurrent((int) (20)),_y,_fieldwidth,__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 158;BA.debugLine="y = y + 22dip";
_y = (int) (_y+__c.DipToCurrent((int) (22)));
 //BA.debugLineNum = 160;BA.debugLine="edtNotes.Initialize(\"edtNotes\")";
_edtnotes.Initialize(ba,"edtNotes");
 //BA.debugLineNum = 161;BA.debugLine="edtNotes.Hint = ModLang.T(\"notes_hint\")";
_edtnotes.setHint(_modlang._t /*String*/ (ba,"notes_hint"));
 //BA.debugLineNum = 162;BA.debugLine="edtNotes.SingleLine = False";
_edtnotes.setSingleLine(__c.False);
 //BA.debugLineNum = 163;BA.debugLine="pnlForm.AddView(edtNotes, 20dip, y, fieldWidth, 1";
_pnlform.AddView((android.view.View)(_edtnotes.getObject()),__c.DipToCurrent((int) (20)),_y,_fieldwidth,__c.DipToCurrent((int) (100)));
 //BA.debugLineNum = 164;BA.debugLine="y = y + 100dip + gap";
_y = (int) (_y+__c.DipToCurrent((int) (100))+_gap);
 //BA.debugLineNum = 167;BA.debugLine="chkFavorite.Initialize(\"chkFavorite\")";
_chkfavorite.Initialize(ba,"chkFavorite");
 //BA.debugLineNum = 168;BA.debugLine="chkFavorite.Text = ModLang.T(\"favorite\")";
_chkfavorite.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"favorite")));
 //BA.debugLineNum = 169;BA.debugLine="chkFavorite.TextColor = ModTheme.TextPrimary";
_chkfavorite.setTextColor(_modtheme._textprimary /*int*/ (ba));
 //BA.debugLineNum = 170;BA.debugLine="pnlForm.AddView(chkFavorite, 20dip, y, fieldWidth";
_pnlform.AddView((android.view.View)(_chkfavorite.getObject()),__c.DipToCurrent((int) (20)),_y,_fieldwidth,__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 171;BA.debugLine="y = y + 60dip";
_y = (int) (_y+__c.DipToCurrent((int) (60)));
 //BA.debugLineNum = 174;BA.debugLine="pnlForm.Height = y + 300dip";
_pnlform.setHeight((int) (_y+__c.DipToCurrent((int) (300))));
 //BA.debugLineNum = 175;BA.debugLine="End Sub";
return "";
}
public String  _edtname_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 228;BA.debugLine="Private Sub edtName_FocusChanged(HasFocus As Boole";
 //BA.debugLineNum = 229;BA.debugLine="If HasFocus Then ScrollToView(edtName)";
if (_hasfocus) { 
_scrolltoview((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_edtname.getObject())));};
 //BA.debugLineNum = 230;BA.debugLine="End Sub";
return "";
}
public String  _edtnotes_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 244;BA.debugLine="Private Sub edtNotes_FocusChanged(HasFocus As Bool";
 //BA.debugLineNum = 245;BA.debugLine="If HasFocus Then ScrollToView(edtNotes)";
if (_hasfocus) { 
_scrolltoview((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_edtnotes.getObject())));};
 //BA.debugLineNum = 246;BA.debugLine="End Sub";
return "";
}
public String  _edtpassword_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 240;BA.debugLine="Private Sub edtPassword_FocusChanged(HasFocus As B";
 //BA.debugLineNum = 241;BA.debugLine="If HasFocus Then ScrollToView(edtPassword)";
if (_hasfocus) { 
_scrolltoview((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_edtpassword.getObject())));};
 //BA.debugLineNum = 242;BA.debugLine="End Sub";
return "";
}
public String  _edturl_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 232;BA.debugLine="Private Sub edtUrl_FocusChanged(HasFocus As Boolea";
 //BA.debugLineNum = 233;BA.debugLine="If HasFocus Then ScrollToView(edtUrl)";
if (_hasfocus) { 
_scrolltoview((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_edturl.getObject())));};
 //BA.debugLineNum = 234;BA.debugLine="End Sub";
return "";
}
public String  _edtusername_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 236;BA.debugLine="Private Sub edtUsername_FocusChanged(HasFocus As B";
 //BA.debugLineNum = 237;BA.debugLine="If HasFocus Then ScrollToView(edtUsername)";
if (_hasfocus) { 
_scrolltoview((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_edtusername.getObject())));};
 //BA.debugLineNum = 238;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 32;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return "";
}
public String  _loadentry() throws Exception{
com.lockzero.clspasswordentry _e = null;
 //BA.debugLineNum = 190;BA.debugLine="Private Sub LoadEntry";
 //BA.debugLineNum = 191;BA.debugLine="Dim e As clsPasswordEntry = ModPasswords.GetEntry";
_e = _modpasswords._getentrybyid /*com.lockzero.clspasswordentry*/ (ba,_currententryid);
 //BA.debugLineNum = 192;BA.debugLine="If e.IsInitialized = False Then Return";
if (_e._isinitialized /*boolean*/ ()==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 194;BA.debugLine="edtName.Text = e.Name";
_edtname.setText(BA.ObjectToCharSequence(_e._name /*String*/ ));
 //BA.debugLineNum = 195;BA.debugLine="edtUrl.Text = e.Url";
_edturl.setText(BA.ObjectToCharSequence(_e._url /*String*/ ));
 //BA.debugLineNum = 196;BA.debugLine="edtUsername.Text = ModPasswords.DecryptValue(e.Us";
_edtusername.setText(BA.ObjectToCharSequence(_modpasswords._decryptvalue /*String*/ (ba,_e._username /*String*/ )));
 //BA.debugLineNum = 197;BA.debugLine="edtPassword.Text = ModPasswords.DecryptValue(e.Pa";
_edtpassword.setText(BA.ObjectToCharSequence(_modpasswords._decryptvalue /*String*/ (ba,_e._passwordenc /*String*/ )));
 //BA.debugLineNum = 198;BA.debugLine="edtNotes.Text = ModPasswords.DecryptValue(e.Notes";
_edtnotes.setText(BA.ObjectToCharSequence(_modpasswords._decryptvalue /*String*/ (ba,_e._notes /*String*/ )));
 //BA.debugLineNum = 199;BA.debugLine="chkFavorite.Checked = e.IsFavorite";
_chkfavorite.setChecked(_e._isfavorite /*boolean*/ );
 //BA.debugLineNum = 200;BA.debugLine="End Sub";
return "";
}
public String  _saveentry() throws Exception{
String _name = "";
String _password = "";
com.lockzero.clspasswordentry _e = null;
 //BA.debugLineNum = 274;BA.debugLine="Private Sub SaveEntry";
 //BA.debugLineNum = 275;BA.debugLine="If ModSession.IsSessionActive = False Then";
if (_modsession._issessionactive /*boolean*/ (ba)==__c.False) { 
 //BA.debugLineNum = 276;BA.debugLine="ToastMessageShow(ModLang.T(\"session_expired\"), T";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"session_expired")),__c.True);
 //BA.debugLineNum = 277;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 281;BA.debugLine="Dim name As String = edtName.Text.Trim";
_name = _edtname.getText().trim();
 //BA.debugLineNum = 282;BA.debugLine="Dim password As String = edtPassword.Text.Trim";
_password = _edtpassword.getText().trim();
 //BA.debugLineNum = 284;BA.debugLine="If name = \"\" And edtUrl.Text.Trim = \"\" Then";
if ((_name).equals("") && (_edturl.getText().trim()).equals("")) { 
 //BA.debugLineNum = 285;BA.debugLine="ToastMessageShow(ModLang.T(\"error_empty_field\"),";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error_empty_field")),__c.True);
 //BA.debugLineNum = 286;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 289;BA.debugLine="If password = \"\" Then";
if ((_password).equals("")) { 
 //BA.debugLineNum = 290;BA.debugLine="ToastMessageShow(ModLang.T(\"error_empty_field\")";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error_empty_field")+" (senha)"),__c.True);
 //BA.debugLineNum = 291;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 295;BA.debugLine="Dim e As clsPasswordEntry";
_e = new com.lockzero.clspasswordentry();
 //BA.debugLineNum = 296;BA.debugLine="If IsEditMode Then";
if (_iseditmode) { 
 //BA.debugLineNum = 297;BA.debugLine="e = ModPasswords.GetEntryById(CurrentEntryId)";
_e = _modpasswords._getentrybyid /*com.lockzero.clspasswordentry*/ (ba,_currententryid);
 }else {
 //BA.debugLineNum = 299;BA.debugLine="e.Initialize";
_e._initialize /*String*/ (ba);
 //BA.debugLineNum = 300;BA.debugLine="e.GroupId = CurrentGroupId";
_e._groupid /*String*/  = _currentgroupid;
 };
 //BA.debugLineNum = 304;BA.debugLine="e.Name = name";
_e._name /*String*/  = _name;
 //BA.debugLineNum = 305;BA.debugLine="e.Url = edtUrl.Text.Trim";
_e._url /*String*/  = _edturl.getText().trim();
 //BA.debugLineNum = 306;BA.debugLine="e.Username = ModPasswords.EncryptValue(edtUsernam";
_e._username /*String*/  = _modpasswords._encryptvalue /*String*/ (ba,_edtusername.getText().trim());
 //BA.debugLineNum = 307;BA.debugLine="e.PasswordEnc = ModPasswords.EncryptValue(passwor";
_e._passwordenc /*String*/  = _modpasswords._encryptvalue /*String*/ (ba,_password);
 //BA.debugLineNum = 308;BA.debugLine="e.Notes = ModPasswords.EncryptValue(edtNotes.Text";
_e._notes /*String*/  = _modpasswords._encryptvalue /*String*/ (ba,_edtnotes.getText().trim());
 //BA.debugLineNum = 309;BA.debugLine="e.IsFavorite = chkFavorite.Checked";
_e._isfavorite /*boolean*/  = _chkfavorite.getChecked();
 //BA.debugLineNum = 312;BA.debugLine="ModPasswords.SaveEntry(e)";
_modpasswords._saveentry /*String*/ (ba,_e);
 //BA.debugLineNum = 314;BA.debugLine="ToastMessageShow(ModLang.T(\"success\"), False)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"success")),__c.False);
 //BA.debugLineNum = 315;BA.debugLine="B4XPages.ClosePage(Me)";
_b4xpages._closepage /*String*/ (ba,this);
 //BA.debugLineNum = 316;BA.debugLine="End Sub";
return "";
}
public String  _scrolltoview(anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
int _targety = 0;
 //BA.debugLineNum = 248;BA.debugLine="Private Sub ScrollToView(v As View)";
 //BA.debugLineNum = 250;BA.debugLine="Dim targetY As Int = v.Top - 50dip 'Um pouco acim";
_targety = (int) (_v.getTop()-__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 251;BA.debugLine="If targetY < 0 Then targetY = 0";
if (_targety<0) { 
_targety = (int) (0);};
 //BA.debugLineNum = 254;BA.debugLine="svForm.ScrollPosition = targetY";
_svform.setScrollPosition(_targety);
 //BA.debugLineNum = 255;BA.debugLine="End Sub";
return "";
}
public String  _setparams(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
 //BA.debugLineNum = 61;BA.debugLine="Public Sub SetParams(params As Map)";
 //BA.debugLineNum = 62;BA.debugLine="If params = Null Then Return";
if (_params== null) { 
if (true) return "";};
 //BA.debugLineNum = 63;BA.debugLine="CurrentGroupId = params.GetDefault(\"groupId\", \"\")";
_currentgroupid = BA.ObjectToString(_params.GetDefault((Object)("groupId"),(Object)("")));
 //BA.debugLineNum = 64;BA.debugLine="CurrentEntryId = params.GetDefault(\"entryId\", \"\")";
_currententryid = BA.ObjectToString(_params.GetDefault((Object)("entryId"),(Object)("")));
 //BA.debugLineNum = 65;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
