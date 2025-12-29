package com.lockzero;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class pagesettings extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.lockzero.pagesettings");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.lockzero.pagesettings.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _svcontent = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _pnlcontent = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbllanguagevalue = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbltimervalue = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblpassphrasemodevalue = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chkpin = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chkbiometric = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnloverlay = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnldialog = null;
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
public int  _addcheckboxitem(String _chkname,String _title,String _subtitle,int _y,int _w) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xv = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chk = null;
anywheresoftware.b4a.objects.LabelWrapper _lblsub = null;
 //BA.debugLineNum = 211;BA.debugLine="Private Sub AddCheckboxItem(chkName As String, tit";
 //BA.debugLineNum = 212;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 213;BA.debugLine="pnl.Initialize(\"\")";
_pnl.Initialize(ba,"");
 //BA.debugLineNum = 215;BA.debugLine="Dim xv As B4XView = pnl";
_xv = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xv = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnl.getObject()));
 //BA.debugLineNum = 216;BA.debugLine="xv.SetColorAndBorder(ModTheme.HomeHeaderBg, 0, Mo";
_xv.SetColorAndBorder(_modtheme._homeheaderbg /*int*/ (ba),(int) (0),_modtheme._homeheaderbg /*int*/ (ba),__c.DipToCurrent((int) (10)));
 //BA.debugLineNum = 217;BA.debugLine="pnlContent.AddView(pnl, 16dip, y, w, 70dip)";
_pnlcontent.AddView((android.view.View)(_pnl.getObject()),__c.DipToCurrent((int) (16)),_y,_w,__c.DipToCurrent((int) (70)));
 //BA.debugLineNum = 220;BA.debugLine="Dim chk As CheckBox";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 221;BA.debugLine="chk.Initialize(chkName)";
_chk.Initialize(ba,_chkname);
 //BA.debugLineNum = 222;BA.debugLine="chk.Text = title";
_chk.setText(BA.ObjectToCharSequence(_title));
 //BA.debugLineNum = 223;BA.debugLine="chk.TextSize = 15";
_chk.setTextSize((float) (15));
 //BA.debugLineNum = 224;BA.debugLine="chk.TextColor = Colors.White";
_chk.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 226;BA.debugLine="If chkName = \"chkPIN\" Then";
if ((_chkname).equals("chkPIN")) { 
 //BA.debugLineNum = 227;BA.debugLine="chkPIN = chk";
_chkpin = _chk;
 //BA.debugLineNum = 228;BA.debugLine="chk.Checked = ModSecurity.HasPIN";
_chk.setChecked(_modsecurity._haspin /*boolean*/ (ba));
 }else if((_chkname).equals("chkBiometric")) { 
 //BA.debugLineNum = 230;BA.debugLine="chkBiometric = chk";
_chkbiometric = _chk;
 //BA.debugLineNum = 231;BA.debugLine="chk.Checked = ModSecurity.GetUseBiometric";
_chk.setChecked(_modsecurity._getusebiometric /*boolean*/ (ba));
 };
 //BA.debugLineNum = 234;BA.debugLine="pnl.AddView(chk, 16dip, 8dip, w - 32dip, 30dip)";
_pnl.AddView((android.view.View)(_chk.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (8)),(int) (_w-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 237;BA.debugLine="Dim lblSub As Label";
_lblsub = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 238;BA.debugLine="lblSub.Initialize(\"\")";
_lblsub.Initialize(ba,"");
 //BA.debugLineNum = 239;BA.debugLine="lblSub.Text = subtitle";
_lblsub.setText(BA.ObjectToCharSequence(_subtitle));
 //BA.debugLineNum = 240;BA.debugLine="lblSub.TextSize = 12";
_lblsub.setTextSize((float) (12));
 //BA.debugLineNum = 241;BA.debugLine="lblSub.TextColor = Colors.ARGB(150, 255, 255, 255";
_lblsub.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 242;BA.debugLine="pnl.AddView(lblSub, 48dip, 38dip, w - 64dip, 25di";
_pnl.AddView((android.view.View)(_lblsub.getObject()),__c.DipToCurrent((int) (48)),__c.DipToCurrent((int) (38)),(int) (_w-__c.DipToCurrent((int) (64))),__c.DipToCurrent((int) (25)));
 //BA.debugLineNum = 244;BA.debugLine="Return y + 80dip";
if (true) return (int) (_y+__c.DipToCurrent((int) (80)));
 //BA.debugLineNum = 245;BA.debugLine="End Sub";
return 0;
}
public int  _adddangerbutton(String _btnname,String _title,String _subtitle,int _y,int _w) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xv = null;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
anywheresoftware.b4a.objects.LabelWrapper _lblsub = null;
 //BA.debugLineNum = 247;BA.debugLine="Private Sub AddDangerButton(btnName As String, tit";
 //BA.debugLineNum = 248;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 249;BA.debugLine="pnl.Initialize(btnName)";
_pnl.Initialize(ba,_btnname);
 //BA.debugLineNum = 252;BA.debugLine="Dim xv As B4XView = pnl";
_xv = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xv = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnl.getObject()));
 //BA.debugLineNum = 253;BA.debugLine="xv.SetColorAndBorder(Colors.RGB(120, 30, 30), 0,";
_xv.SetColorAndBorder(__c.Colors.RGB((int) (120),(int) (30),(int) (30)),(int) (0),__c.Colors.RGB((int) (120),(int) (30),(int) (30)),__c.DipToCurrent((int) (10)));
 //BA.debugLineNum = 254;BA.debugLine="pnlContent.AddView(pnl, 16dip, y, w, 70dip)";
_pnlcontent.AddView((android.view.View)(_pnl.getObject()),__c.DipToCurrent((int) (16)),_y,_w,__c.DipToCurrent((int) (70)));
 //BA.debugLineNum = 257;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 258;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 259;BA.debugLine="lblTitle.Text = title";
_lbltitle.setText(BA.ObjectToCharSequence(_title));
 //BA.debugLineNum = 260;BA.debugLine="lblTitle.TextSize = 15";
_lbltitle.setTextSize((float) (15));
 //BA.debugLineNum = 261;BA.debugLine="lblTitle.TextColor = Colors.RGB(255, 100, 100)";
_lbltitle.setTextColor(__c.Colors.RGB((int) (255),(int) (100),(int) (100)));
 //BA.debugLineNum = 262;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 263;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_VERTICAL";
_lbltitle.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 264;BA.debugLine="pnl.AddView(lblTitle, 16dip, 8dip, w - 32dip, 28d";
_pnl.AddView((android.view.View)(_lbltitle.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (8)),(int) (_w-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (28)));
 //BA.debugLineNum = 267;BA.debugLine="Dim lblSub As Label";
_lblsub = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 268;BA.debugLine="lblSub.Initialize(\"\")";
_lblsub.Initialize(ba,"");
 //BA.debugLineNum = 269;BA.debugLine="lblSub.Text = subtitle";
_lblsub.setText(BA.ObjectToCharSequence(_subtitle));
 //BA.debugLineNum = 270;BA.debugLine="lblSub.TextSize = 12";
_lblsub.setTextSize((float) (12));
 //BA.debugLineNum = 271;BA.debugLine="lblSub.TextColor = Colors.ARGB(180, 255, 150, 150";
_lblsub.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (150),(int) (150)));
 //BA.debugLineNum = 272;BA.debugLine="pnl.AddView(lblSub, 16dip, 38dip, w - 32dip, 25di";
_pnl.AddView((android.view.View)(_lblsub.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (38)),(int) (_w-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (25)));
 //BA.debugLineNum = 274;BA.debugLine="Return y + 80dip";
if (true) return (int) (_y+__c.DipToCurrent((int) (80)));
 //BA.debugLineNum = 275;BA.debugLine="End Sub";
return 0;
}
public int  _addsectionheader(String _title,int _y,int _w) throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
 //BA.debugLineNum = 171;BA.debugLine="Private Sub AddSectionHeader(title As String, y As";
 //BA.debugLineNum = 172;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 173;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(ba,"");
 //BA.debugLineNum = 174;BA.debugLine="lbl.Text = title.ToUpperCase";
_lbl.setText(BA.ObjectToCharSequence(_title.toUpperCase()));
 //BA.debugLineNum = 175;BA.debugLine="lbl.TextSize = 12";
_lbl.setTextSize((float) (12));
 //BA.debugLineNum = 176;BA.debugLine="lbl.TextColor = ModTheme.HomeIconBg";
_lbl.setTextColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 177;BA.debugLine="lbl.Typeface = Typeface.DEFAULT_BOLD";
_lbl.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 178;BA.debugLine="pnlContent.AddView(lbl, 16dip, y, w, 25dip)";
_pnlcontent.AddView((android.view.View)(_lbl.getObject()),__c.DipToCurrent((int) (16)),_y,_w,__c.DipToCurrent((int) (25)));
 //BA.debugLineNum = 179;BA.debugLine="Return y + 30dip";
if (true) return (int) (_y+__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 180;BA.debugLine="End Sub";
return 0;
}
public int  _addsettingitem(String _eventname,String _title,String _subtitle,int _y,int _w) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xv = null;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
anywheresoftware.b4a.objects.LabelWrapper _lblarrow = null;
 //BA.debugLineNum = 182;BA.debugLine="Private Sub AddSettingItem(eventName As String, ti";
 //BA.debugLineNum = 183;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 184;BA.debugLine="pnl.Initialize(eventName)";
_pnl.Initialize(ba,_eventname);
 //BA.debugLineNum = 186;BA.debugLine="Dim xv As B4XView = pnl";
_xv = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xv = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnl.getObject()));
 //BA.debugLineNum = 187;BA.debugLine="xv.SetColorAndBorder(ModTheme.HomeHeaderBg, 0, Mo";
_xv.SetColorAndBorder(_modtheme._homeheaderbg /*int*/ (ba),(int) (0),_modtheme._homeheaderbg /*int*/ (ba),__c.DipToCurrent((int) (10)));
 //BA.debugLineNum = 188;BA.debugLine="pnlContent.AddView(pnl, 16dip, y, w, 60dip)";
_pnlcontent.AddView((android.view.View)(_pnl.getObject()),__c.DipToCurrent((int) (16)),_y,_w,__c.DipToCurrent((int) (60)));
 //BA.debugLineNum = 191;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 192;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 193;BA.debugLine="lblTitle.Text = title";
_lbltitle.setText(BA.ObjectToCharSequence(_title));
 //BA.debugLineNum = 194;BA.debugLine="lblTitle.TextSize = 15";
_lbltitle.setTextSize((float) (15));
 //BA.debugLineNum = 195;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 196;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_VERTICAL";
_lbltitle.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 197;BA.debugLine="pnl.AddView(lblTitle, 16dip, 0, w - 150dip, 60dip";
_pnl.AddView((android.view.View)(_lbltitle.getObject()),__c.DipToCurrent((int) (16)),(int) (0),(int) (_w-__c.DipToCurrent((int) (150))),__c.DipToCurrent((int) (60)));
 //BA.debugLineNum = 200;BA.debugLine="Dim lblArrow As Label";
_lblarrow = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 201;BA.debugLine="lblArrow.Initialize(\"\")";
_lblarrow.Initialize(ba,"");
 //BA.debugLineNum = 202;BA.debugLine="lblArrow.Text = \">\"";
_lblarrow.setText(BA.ObjectToCharSequence(">"));
 //BA.debugLineNum = 203;BA.debugLine="lblArrow.TextSize = 16";
_lblarrow.setTextSize((float) (16));
 //BA.debugLineNum = 204;BA.debugLine="lblArrow.TextColor = Colors.ARGB(100, 255, 255, 2";
_lblarrow.setTextColor(__c.Colors.ARGB((int) (100),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 205;BA.debugLine="lblArrow.Gravity = Gravity.CENTER";
_lblarrow.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 206;BA.debugLine="pnl.AddView(lblArrow, w - 40dip, 0, 30dip, 60dip)";
_pnl.AddView((android.view.View)(_lblarrow.getObject()),(int) (_w-__c.DipToCurrent((int) (40))),(int) (0),__c.DipToCurrent((int) (30)),__c.DipToCurrent((int) (60)));
 //BA.debugLineNum = 208;BA.debugLine="Return y + 70dip";
if (true) return (int) (_y+__c.DipToCurrent((int) (70)));
 //BA.debugLineNum = 209;BA.debugLine="End Sub";
return 0;
}
public String  _applytheme() throws Exception{
 //BA.debugLineNum = 649;BA.debugLine="Private Sub ApplyTheme";
 //BA.debugLineNum = 650;BA.debugLine="Root.Color = ModTheme.HomeBg";
_root.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 651;BA.debugLine="svContent.Color = ModTheme.HomeBg";
_svcontent.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 652;BA.debugLine="pnlContent.Color = ModTheme.HomeBg";
_pnlcontent.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 653;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_appear() throws Exception{
 //BA.debugLineNum = 32;BA.debugLine="Private Sub B4XPage_Appear";
 //BA.debugLineNum = 34;BA.debugLine="Root.RemoveAllViews";
_root.RemoveAllViews();
 //BA.debugLineNum = 35;BA.debugLine="CreateUI";
_createui();
 //BA.debugLineNum = 36;BA.debugLine="ApplyTheme";
_applytheme();
 //BA.debugLineNum = 39;BA.debugLine="CallSub2(Main, \"SetPageTitle\", ModLang.T(\"setting";
__c.CallSubNew2(ba,(Object)(_main.getObject()),"SetPageTitle",(Object)(_modlang._t /*String*/ (ba,"settings")));
 //BA.debugLineNum = 42;BA.debugLine="UpdateDisplayValues";
_updatedisplayvalues();
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
 //BA.debugLineNum = 28;BA.debugLine="Private Sub B4XPage_Created(Root1 As B4XView)";
 //BA.debugLineNum = 29;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return "";
}
public String  _btnback_click() throws Exception{
 //BA.debugLineNum = 325;BA.debugLine="Private Sub btnBack_Click";
 //BA.debugLineNum = 326;BA.debugLine="B4XPages.ClosePage(Me)";
_b4xpages._closepage /*String*/ (ba,this);
 //BA.debugLineNum = 327;BA.debugLine="End Sub";
return "";
}
public void  _btncleardata_click() throws Exception{
ResumableSub_btnClearData_Click rsub = new ResumableSub_btnClearData_Click(this);
rsub.resume(ba, null);
}
public static class ResumableSub_btnClearData_Click extends BA.ResumableSub {
public ResumableSub_btnClearData_Click(com.lockzero.pagesettings parent) {
this.parent = parent;
}
com.lockzero.pagesettings parent;
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
 //BA.debugLineNum = 615;BA.debugLine="Wait For (xui.Msgbox2Async(ModLang.T(\"clear_data_";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"clear_data_confirm")),BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"warning")),parent._modlang._t /*String*/ (ba,"delete"),"",parent._modlang._t /*String*/ (ba,"cancel"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 617;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
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
 //BA.debugLineNum = 619;BA.debugLine="ClearAllData";
parent._clearalldata();
 //BA.debugLineNum = 620;BA.debugLine="ToastMessageShow(ModLang.T(\"data_cleared\"), True";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"data_cleared")),parent.__c.True);
 //BA.debugLineNum = 622;BA.debugLine="B4XPages.ShowPageAndRemovePreviousPages(\"mainpag";
parent._b4xpages._showpageandremovepreviouspages /*String*/ (ba,"mainpage");
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 624;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _msgbox_result(int _result) throws Exception{
}
public String  _btndialogcancel_click() throws Exception{
 //BA.debugLineNum = 608;BA.debugLine="Private Sub btnDialogCancel_Click";
 //BA.debugLineNum = 609;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 610;BA.debugLine="End Sub";
return "";
}
public String  _btnlangen_click() throws Exception{
 //BA.debugLineNum = 397;BA.debugLine="Private Sub btnLangEN_Click";
 //BA.debugLineNum = 398;BA.debugLine="ModLang.SetLanguage(\"en\")";
_modlang._setlanguage /*String*/ (ba,"en");
 //BA.debugLineNum = 399;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 400;BA.debugLine="UpdateDisplayValues";
_updatedisplayvalues();
 //BA.debugLineNum = 401;BA.debugLine="ToastMessageShow(ModLang.T(\"success\"), False)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"success")),__c.False);
 //BA.debugLineNum = 402;BA.debugLine="End Sub";
return "";
}
public String  _btnlangpt_click() throws Exception{
 //BA.debugLineNum = 390;BA.debugLine="Private Sub btnLangPT_Click";
 //BA.debugLineNum = 391;BA.debugLine="ModLang.SetLanguage(\"pt\")";
_modlang._setlanguage /*String*/ (ba,"pt");
 //BA.debugLineNum = 392;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 393;BA.debugLine="UpdateDisplayValues";
_updatedisplayvalues();
 //BA.debugLineNum = 394;BA.debugLine="ToastMessageShow(ModLang.T(\"success\"), False)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"success")),__c.False);
 //BA.debugLineNum = 395;BA.debugLine="End Sub";
return "";
}
public String  _btnmodemulti_click() throws Exception{
 //BA.debugLineNum = 553;BA.debugLine="Private Sub btnModeMulti_Click";
 //BA.debugLineNum = 554;BA.debugLine="ModSecurity.SetUseSinglePassphrase(False)";
_modsecurity._setusesinglepassphrase /*String*/ (ba,__c.False);
 //BA.debugLineNum = 555;BA.debugLine="ModSession.EndSession 'Encerra sessao atual para";
_modsession._endsession /*String*/ (ba);
 //BA.debugLineNum = 556;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 557;BA.debugLine="UpdateDisplayValues";
_updatedisplayvalues();
 //BA.debugLineNum = 558;BA.debugLine="ToastMessageShow(ModLang.T(\"success\"), False)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"success")),__c.False);
 //BA.debugLineNum = 559;BA.debugLine="End Sub";
return "";
}
public String  _btnmodesingle_click() throws Exception{
 //BA.debugLineNum = 545;BA.debugLine="Private Sub btnModeSingle_Click";
 //BA.debugLineNum = 546;BA.debugLine="ModSecurity.SetUseSinglePassphrase(True)";
_modsecurity._setusesinglepassphrase /*String*/ (ba,__c.True);
 //BA.debugLineNum = 547;BA.debugLine="ModSession.EndSession 'Encerra sessao atual para";
_modsession._endsession /*String*/ (ba);
 //BA.debugLineNum = 548;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 549;BA.debugLine="UpdateDisplayValues";
_updatedisplayvalues();
 //BA.debugLineNum = 550;BA.debugLine="ToastMessageShow(ModLang.T(\"success\"), False)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"success")),__c.False);
 //BA.debugLineNum = 551;BA.debugLine="End Sub";
return "";
}
public String  _btntimer1_click() throws Exception{
 //BA.debugLineNum = 462;BA.debugLine="Private Sub btnTimer1_Click";
 //BA.debugLineNum = 463;BA.debugLine="ModSecurity.SaveSessionTimeout(60)";
_modsecurity._savesessiontimeout /*String*/ (ba,(int) (60));
 //BA.debugLineNum = 464;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 465;BA.debugLine="UpdateDisplayValues";
_updatedisplayvalues();
 //BA.debugLineNum = 466;BA.debugLine="End Sub";
return "";
}
public String  _btntimer2_click() throws Exception{
 //BA.debugLineNum = 468;BA.debugLine="Private Sub btnTimer2_Click";
 //BA.debugLineNum = 469;BA.debugLine="ModSecurity.SaveSessionTimeout(120)";
_modsecurity._savesessiontimeout /*String*/ (ba,(int) (120));
 //BA.debugLineNum = 470;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 471;BA.debugLine="UpdateDisplayValues";
_updatedisplayvalues();
 //BA.debugLineNum = 472;BA.debugLine="End Sub";
return "";
}
public String  _btntimer3_click() throws Exception{
 //BA.debugLineNum = 474;BA.debugLine="Private Sub btnTimer3_Click";
 //BA.debugLineNum = 475;BA.debugLine="ModSecurity.SaveSessionTimeout(180)";
_modsecurity._savesessiontimeout /*String*/ (ba,(int) (180));
 //BA.debugLineNum = 476;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 477;BA.debugLine="UpdateDisplayValues";
_updatedisplayvalues();
 //BA.debugLineNum = 478;BA.debugLine="End Sub";
return "";
}
public String  _chkbiometric_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 598;BA.debugLine="Private Sub chkBiometric_CheckedChange(Checked As";
 //BA.debugLineNum = 599;BA.debugLine="ModSecurity.SetUseBiometric(Checked)";
_modsecurity._setusebiometric /*String*/ (ba,_checked);
 //BA.debugLineNum = 600;BA.debugLine="If Checked Then";
if (_checked) { 
 //BA.debugLineNum = 601;BA.debugLine="ToastMessageShow(ModLang.T(\"biometric_enabled\"),";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"biometric_enabled")),__c.False);
 }else {
 //BA.debugLineNum = 603;BA.debugLine="ToastMessageShow(ModLang.T(\"biometric_disabled\")";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"biometric_disabled")),__c.False);
 };
 //BA.debugLineNum = 605;BA.debugLine="End Sub";
return "";
}
public String  _chkpin_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 562;BA.debugLine="Private Sub chkPIN_CheckedChange(Checked As Boolea";
 //BA.debugLineNum = 563;BA.debugLine="If Checked Then";
if (_checked) { 
 //BA.debugLineNum = 565;BA.debugLine="ShowCreatePINDialog";
_showcreatepindialog();
 }else {
 //BA.debugLineNum = 568;BA.debugLine="ShowRemovePINDialog";
_showremovepindialog();
 };
 //BA.debugLineNum = 570;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 4;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Private Root As B4XView";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 6;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 9;BA.debugLine="Private svContent As ScrollView";
_svcontent = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 10;BA.debugLine="Private pnlContent As B4XView";
_pnlcontent = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Private lblLanguageValue As Label";
_lbllanguagevalue = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Private lblTimerValue As Label";
_lbltimervalue = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Private lblPassphraseModeValue As Label";
_lblpassphrasemodevalue = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private chkPIN As CheckBox";
_chkpin = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private chkBiometric As CheckBox";
_chkbiometric = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private pnlOverlay As Panel";
_pnloverlay = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private pnlDialog As Panel";
_pnldialog = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return "";
}
public String  _clearalldata() throws Exception{
 //BA.debugLineNum = 626;BA.debugLine="Private Sub ClearAllData";
 //BA.debugLineNum = 628;BA.debugLine="If File.Exists(File.DirInternal, \"lockzero_passwo";
if (__c.File.Exists(__c.File.getDirInternal(),"lockzero_passwords.json")) { 
 //BA.debugLineNum = 629;BA.debugLine="File.Delete(File.DirInternal, \"lockzero_password";
__c.File.Delete(__c.File.getDirInternal(),"lockzero_passwords.json");
 };
 //BA.debugLineNum = 631;BA.debugLine="If File.Exists(File.DirInternal, \"lockzero_notes.";
if (__c.File.Exists(__c.File.getDirInternal(),"lockzero_notes.json")) { 
 //BA.debugLineNum = 632;BA.debugLine="File.Delete(File.DirInternal, \"lockzero_notes.js";
__c.File.Delete(__c.File.getDirInternal(),"lockzero_notes.json");
 };
 //BA.debugLineNum = 636;BA.debugLine="ModPasswords.ForceReload";
_modpasswords._forcereload /*String*/ (ba);
 //BA.debugLineNum = 637;BA.debugLine="ModNotes.ForceReload";
_modnotes._forcereload /*String*/ (ba);
 //BA.debugLineNum = 640;BA.debugLine="ModSession.EndSession";
_modsession._endsession /*String*/ (ba);
 //BA.debugLineNum = 642;BA.debugLine="Log(\"=== DADOS LIMPOS ===\")";
__c.LogImpl("763111184","=== DADOS LIMPOS ===",0);
 //BA.debugLineNum = 643;BA.debugLine="End Sub";
return "";
}
public String  _createdialogoverlay() throws Exception{
int _width = 0;
int _height = 0;
int _dialogw = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _xvdialog = null;
 //BA.debugLineNum = 277;BA.debugLine="Private Sub CreateDialogOverlay";
 //BA.debugLineNum = 278;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 279;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 281;BA.debugLine="pnlOverlay.Initialize(\"pnlOverlay\")";
_pnloverlay.Initialize(ba,"pnlOverlay");
 //BA.debugLineNum = 282;BA.debugLine="pnlOverlay.Color = Colors.ARGB(180, 0, 0, 0)";
_pnloverlay.setColor(__c.Colors.ARGB((int) (180),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 283;BA.debugLine="pnlOverlay.Visible = False";
_pnloverlay.setVisible(__c.False);
 //BA.debugLineNum = 284;BA.debugLine="Root.AddView(pnlOverlay, 0, 0, width, height)";
_root.AddView((android.view.View)(_pnloverlay.getObject()),(int) (0),(int) (0),_width,_height);
 //BA.debugLineNum = 286;BA.debugLine="Dim dialogW As Int = width - 40dip";
_dialogw = (int) (_width-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 287;BA.debugLine="pnlDialog.Initialize(\"\")";
_pnldialog.Initialize(ba,"");
 //BA.debugLineNum = 288;BA.debugLine="pnlDialog.Color = ModTheme.HomeHeaderBg";
_pnldialog.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 289;BA.debugLine="pnlOverlay.AddView(pnlDialog, 20dip, 100dip, dial";
_pnloverlay.AddView((android.view.View)(_pnldialog.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (100)),_dialogw,__c.DipToCurrent((int) (250)));
 //BA.debugLineNum = 291;BA.debugLine="Dim xvDialog As B4XView = pnlDialog";
_xvdialog = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvdialog = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnldialog.getObject()));
 //BA.debugLineNum = 292;BA.debugLine="xvDialog.SetColorAndBorder(ModTheme.HomeHeaderBg,";
_xvdialog.SetColorAndBorder(_modtheme._homeheaderbg /*int*/ (ba),(int) (0),_modtheme._homeheaderbg /*int*/ (ba),__c.DipToCurrent((int) (12)));
 //BA.debugLineNum = 293;BA.debugLine="End Sub";
return "";
}
public String  _createui() throws Exception{
int _width = 0;
int _height = 0;
int _headerh = 0;
anywheresoftware.b4a.objects.PanelWrapper _pnlheader = null;
anywheresoftware.b4a.objects.ButtonWrapper _btnback = null;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
int _y = 0;
int _itemw = 0;
anywheresoftware.b4a.objects.LabelWrapper _lblversion = null;
anywheresoftware.b4a.objects.LabelWrapper _lblslogan = null;
 //BA.debugLineNum = 49;BA.debugLine="Private Sub CreateUI";
 //BA.debugLineNum = 50;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 51;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 52;BA.debugLine="Dim headerH As Int = 56dip";
_headerh = __c.DipToCurrent((int) (56));
 //BA.debugLineNum = 55;BA.debugLine="Dim pnlHeader As Panel";
_pnlheader = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 56;BA.debugLine="pnlHeader.Initialize(\"\")";
_pnlheader.Initialize(ba,"");
 //BA.debugLineNum = 57;BA.debugLine="pnlHeader.Color = ModTheme.HomeHeaderBg";
_pnlheader.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 58;BA.debugLine="Root.AddView(pnlHeader, 0, 0, width, headerH)";
_root.AddView((android.view.View)(_pnlheader.getObject()),(int) (0),(int) (0),_width,_headerh);
 //BA.debugLineNum = 61;BA.debugLine="Dim btnBack As Button";
_btnback = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 62;BA.debugLine="btnBack.Initialize(\"btnBack\")";
_btnback.Initialize(ba,"btnBack");
 //BA.debugLineNum = 63;BA.debugLine="btnBack.Text = \"<\"";
_btnback.setText(BA.ObjectToCharSequence("<"));
 //BA.debugLineNum = 64;BA.debugLine="btnBack.TextSize = 20";
_btnback.setTextSize((float) (20));
 //BA.debugLineNum = 65;BA.debugLine="btnBack.Color = Colors.Transparent";
_btnback.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 66;BA.debugLine="btnBack.TextColor = Colors.White";
_btnback.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 67;BA.debugLine="btnBack.Gravity = Gravity.CENTER";
_btnback.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 68;BA.debugLine="pnlHeader.AddView(btnBack, 0, 0, 50dip, headerH)";
_pnlheader.AddView((android.view.View)(_btnback.getObject()),(int) (0),(int) (0),__c.DipToCurrent((int) (50)),_headerh);
 //BA.debugLineNum = 71;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 72;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 73;BA.debugLine="lblTitle.Text = ModLang.T(\"settings\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"settings")));
 //BA.debugLineNum = 74;BA.debugLine="lblTitle.TextSize = 18";
_lbltitle.setTextSize((float) (18));
 //BA.debugLineNum = 75;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 76;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 77;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_VERTICAL";
_lbltitle.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 78;BA.debugLine="pnlHeader.AddView(lblTitle, 50dip, 0, width - 60d";
_pnlheader.AddView((android.view.View)(_lbltitle.getObject()),__c.DipToCurrent((int) (50)),(int) (0),(int) (_width-__c.DipToCurrent((int) (60))),_headerh);
 //BA.debugLineNum = 81;BA.debugLine="svContent.Initialize(0)";
_svcontent.Initialize(ba,(int) (0));
 //BA.debugLineNum = 82;BA.debugLine="svContent.Color = ModTheme.HomeBg";
_svcontent.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 83;BA.debugLine="Root.AddView(svContent, 0, headerH, width, height";
_root.AddView((android.view.View)(_svcontent.getObject()),(int) (0),_headerh,_width,(int) (_height-_headerh));
 //BA.debugLineNum = 85;BA.debugLine="pnlContent = svContent.Panel";
_pnlcontent = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_svcontent.getPanel().getObject()));
 //BA.debugLineNum = 86;BA.debugLine="pnlContent.Color = ModTheme.HomeBg";
_pnlcontent.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 88;BA.debugLine="Dim y As Int = 20dip";
_y = __c.DipToCurrent((int) (20));
 //BA.debugLineNum = 89;BA.debugLine="Dim itemW As Int = width - 32dip";
_itemw = (int) (_width-__c.DipToCurrent((int) (32)));
 //BA.debugLineNum = 92;BA.debugLine="y = AddSectionHeader(ModLang.T(\"settings_general\"";
_y = _addsectionheader(_modlang._t /*String*/ (ba,"settings_general"),_y,_itemw);
 //BA.debugLineNum = 95;BA.debugLine="y = AddSettingItem(\"itemLanguage\", ModLang.T(\"lan";
_y = _addsettingitem("itemLanguage",_modlang._t /*String*/ (ba,"language"),"",_y,_itemw);
 //BA.debugLineNum = 96;BA.debugLine="lblLanguageValue.Initialize(\"\")";
_lbllanguagevalue.Initialize(ba,"");
 //BA.debugLineNum = 97;BA.debugLine="lblLanguageValue.Text = ModLang.GetLanguageName";
_lbllanguagevalue.setText(BA.ObjectToCharSequence(_modlang._getlanguagename /*String*/ (ba)));
 //BA.debugLineNum = 98;BA.debugLine="lblLanguageValue.TextSize = 14";
_lbllanguagevalue.setTextSize((float) (14));
 //BA.debugLineNum = 99;BA.debugLine="lblLanguageValue.TextColor = Colors.ARGB(180, 255";
_lbllanguagevalue.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 100;BA.debugLine="lblLanguageValue.Gravity = Gravity.RIGHT + Gravit";
_lbllanguagevalue.setGravity((int) (__c.Gravity.RIGHT+__c.Gravity.CENTER_VERTICAL));
 //BA.debugLineNum = 101;BA.debugLine="pnlContent.AddView(lblLanguageValue, width - 170d";
_pnlcontent.AddView((android.view.View)(_lbllanguagevalue.getObject()),(int) (_width-__c.DipToCurrent((int) (170))),(int) (_y-__c.DipToCurrent((int) (60))),__c.DipToCurrent((int) (110)),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 104;BA.debugLine="y = AddSettingItem(\"itemTimer\", ModLang.T(\"sessio";
_y = _addsettingitem("itemTimer",_modlang._t /*String*/ (ba,"session_timeout"),"",_y,_itemw);
 //BA.debugLineNum = 105;BA.debugLine="lblTimerValue.Initialize(\"\")";
_lbltimervalue.Initialize(ba,"");
 //BA.debugLineNum = 106;BA.debugLine="lblTimerValue.Text = GetTimerDisplayValue";
_lbltimervalue.setText(BA.ObjectToCharSequence(_gettimerdisplayvalue()));
 //BA.debugLineNum = 107;BA.debugLine="lblTimerValue.TextSize = 14";
_lbltimervalue.setTextSize((float) (14));
 //BA.debugLineNum = 108;BA.debugLine="lblTimerValue.TextColor = Colors.ARGB(180, 255, 2";
_lbltimervalue.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 109;BA.debugLine="lblTimerValue.Gravity = Gravity.RIGHT + Gravity.C";
_lbltimervalue.setGravity((int) (__c.Gravity.RIGHT+__c.Gravity.CENTER_VERTICAL));
 //BA.debugLineNum = 110;BA.debugLine="pnlContent.AddView(lblTimerValue, width - 170dip,";
_pnlcontent.AddView((android.view.View)(_lbltimervalue.getObject()),(int) (_width-__c.DipToCurrent((int) (170))),(int) (_y-__c.DipToCurrent((int) (60))),__c.DipToCurrent((int) (110)),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 113;BA.debugLine="y = AddSettingItem(\"itemPassphraseMode\", ModLang.";
_y = _addsettingitem("itemPassphraseMode",_modlang._t /*String*/ (ba,"passphrase_mode"),"",_y,_itemw);
 //BA.debugLineNum = 114;BA.debugLine="lblPassphraseModeValue.Initialize(\"\")";
_lblpassphrasemodevalue.Initialize(ba,"");
 //BA.debugLineNum = 115;BA.debugLine="lblPassphraseModeValue.Text = GetPassphraseModeDi";
_lblpassphrasemodevalue.setText(BA.ObjectToCharSequence(_getpassphrasemodedisplayvalue()));
 //BA.debugLineNum = 116;BA.debugLine="lblPassphraseModeValue.TextSize = 14";
_lblpassphrasemodevalue.setTextSize((float) (14));
 //BA.debugLineNum = 117;BA.debugLine="lblPassphraseModeValue.TextColor = Colors.ARGB(18";
_lblpassphrasemodevalue.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 118;BA.debugLine="lblPassphraseModeValue.Gravity = Gravity.RIGHT +";
_lblpassphrasemodevalue.setGravity((int) (__c.Gravity.RIGHT+__c.Gravity.CENTER_VERTICAL));
 //BA.debugLineNum = 119;BA.debugLine="pnlContent.AddView(lblPassphraseModeValue, width";
_pnlcontent.AddView((android.view.View)(_lblpassphrasemodevalue.getObject()),(int) (_width-__c.DipToCurrent((int) (190))),(int) (_y-__c.DipToCurrent((int) (60))),__c.DipToCurrent((int) (130)),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 121;BA.debugLine="y = y + 10dip";
_y = (int) (_y+__c.DipToCurrent((int) (10)));
 //BA.debugLineNum = 124;BA.debugLine="y = AddSectionHeader(ModLang.T(\"settings_security";
_y = _addsectionheader(_modlang._t /*String*/ (ba,"settings_security"),_y,_itemw);
 //BA.debugLineNum = 127;BA.debugLine="y = AddCheckboxItem(\"chkPIN\", ModLang.T(\"use_pin\"";
_y = _addcheckboxitem("chkPIN",_modlang._t /*String*/ (ba,"use_pin"),_modlang._t /*String*/ (ba,"use_pin_desc"),_y,_itemw);
 //BA.debugLineNum = 130;BA.debugLine="y = AddCheckboxItem(\"chkBiometric\", ModLang.T(\"us";
_y = _addcheckboxitem("chkBiometric",_modlang._t /*String*/ (ba,"use_biometric"),_modlang._t /*String*/ (ba,"use_biometric_desc"),_y,_itemw);
 //BA.debugLineNum = 132;BA.debugLine="y = y + 20dip";
_y = (int) (_y+__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 135;BA.debugLine="y = AddSectionHeader(ModLang.T(\"data\"), y, itemW)";
_y = _addsectionheader(_modlang._t /*String*/ (ba,"data"),_y,_itemw);
 //BA.debugLineNum = 138;BA.debugLine="y = AddDangerButton(\"btnClearData\", ModLang.T(\"cl";
_y = _adddangerbutton("btnClearData",_modlang._t /*String*/ (ba,"clear_data"),_modlang._t /*String*/ (ba,"clear_data_desc"),_y,_itemw);
 //BA.debugLineNum = 140;BA.debugLine="y = y + 20dip";
_y = (int) (_y+__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 143;BA.debugLine="y = AddSectionHeader(ModLang.T(\"about\"), y, itemW";
_y = _addsectionheader(_modlang._t /*String*/ (ba,"about"),_y,_itemw);
 //BA.debugLineNum = 146;BA.debugLine="Dim lblVersion As Label";
_lblversion = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 147;BA.debugLine="lblVersion.Initialize(\"\")";
_lblversion.Initialize(ba,"");
 //BA.debugLineNum = 148;BA.debugLine="lblVersion.Text = Starter.APP_NAME & \" v\" & Start";
_lblversion.setText(BA.ObjectToCharSequence(_starter._app_name /*String*/ +" v"+_starter._app_version /*String*/ ));
 //BA.debugLineNum = 149;BA.debugLine="lblVersion.TextSize = 14";
_lblversion.setTextSize((float) (14));
 //BA.debugLineNum = 150;BA.debugLine="lblVersion.TextColor = Colors.ARGB(150, 255, 255,";
_lblversion.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 151;BA.debugLine="lblVersion.Gravity = Gravity.CENTER_HORIZONTAL";
_lblversion.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 152;BA.debugLine="pnlContent.AddView(lblVersion, 16dip, y, itemW, 3";
_pnlcontent.AddView((android.view.View)(_lblversion.getObject()),__c.DipToCurrent((int) (16)),_y,_itemw,__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 153;BA.debugLine="y = y + 35dip";
_y = (int) (_y+__c.DipToCurrent((int) (35)));
 //BA.debugLineNum = 156;BA.debugLine="Dim lblSlogan As Label";
_lblslogan = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 157;BA.debugLine="lblSlogan.Initialize(\"\")";
_lblslogan.Initialize(ba,"");
 //BA.debugLineNum = 158;BA.debugLine="lblSlogan.Text = Starter.APP_TAGLINE";
_lblslogan.setText(BA.ObjectToCharSequence(_starter._app_tagline /*String*/ ));
 //BA.debugLineNum = 159;BA.debugLine="lblSlogan.TextSize = 12";
_lblslogan.setTextSize((float) (12));
 //BA.debugLineNum = 160;BA.debugLine="lblSlogan.TextColor = Colors.ARGB(120, 255, 255,";
_lblslogan.setTextColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 161;BA.debugLine="lblSlogan.Gravity = Gravity.CENTER_HORIZONTAL";
_lblslogan.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 162;BA.debugLine="pnlContent.AddView(lblSlogan, 16dip, y, itemW, 25";
_pnlcontent.AddView((android.view.View)(_lblslogan.getObject()),__c.DipToCurrent((int) (16)),_y,_itemw,__c.DipToCurrent((int) (25)));
 //BA.debugLineNum = 163;BA.debugLine="y = y + 40dip";
_y = (int) (_y+__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 165;BA.debugLine="pnlContent.Height = y + 50dip";
_pnlcontent.setHeight((int) (_y+__c.DipToCurrent((int) (50))));
 //BA.debugLineNum = 168;BA.debugLine="CreateDialogOverlay";
_createdialogoverlay();
 //BA.debugLineNum = 169;BA.debugLine="End Sub";
return "";
}
public String  _getpassphrasemodedisplayvalue() throws Exception{
 //BA.debugLineNum = 313;BA.debugLine="Private Sub GetPassphraseModeDisplayValue As Strin";
 //BA.debugLineNum = 314;BA.debugLine="If ModSecurity.GetUseSinglePassphrase Then";
if (_modsecurity._getusesinglepassphrase /*boolean*/ (ba)) { 
 //BA.debugLineNum = 315;BA.debugLine="Return ModLang.T(\"single_passphrase\")";
if (true) return _modlang._t /*String*/ (ba,"single_passphrase");
 }else {
 //BA.debugLineNum = 317;BA.debugLine="Return ModLang.T(\"multi_passphrase\")";
if (true) return _modlang._t /*String*/ (ba,"multi_passphrase");
 };
 //BA.debugLineNum = 319;BA.debugLine="End Sub";
return "";
}
public String  _gettimerdisplayvalue() throws Exception{
int _secs = 0;
int _mins = 0;
 //BA.debugLineNum = 307;BA.debugLine="Private Sub GetTimerDisplayValue As String";
 //BA.debugLineNum = 308;BA.debugLine="Dim secs As Int = ModSecurity.GetSessionTimeout";
_secs = _modsecurity._getsessiontimeout /*int*/ (ba);
 //BA.debugLineNum = 309;BA.debugLine="Dim mins As Int = secs / 60";
_mins = (int) (_secs/(double)60);
 //BA.debugLineNum = 310;BA.debugLine="Return mins & \" min\"";
if (true) return BA.NumberToString(_mins)+" min";
 //BA.debugLineNum = 311;BA.debugLine="End Sub";
return "";
}
public String  _hidedialog() throws Exception{
anywheresoftware.b4a.objects.IME _ime = null;
 //BA.debugLineNum = 333;BA.debugLine="Private Sub HideDialog";
 //BA.debugLineNum = 334;BA.debugLine="pnlOverlay.Visible = False";
_pnloverlay.setVisible(__c.False);
 //BA.debugLineNum = 335;BA.debugLine="Dim ime As IME";
_ime = new anywheresoftware.b4a.objects.IME();
 //BA.debugLineNum = 336;BA.debugLine="ime.Initialize(\"\")";
_ime.Initialize("");
 //BA.debugLineNum = 337;BA.debugLine="ime.HideKeyboard";
_ime.HideKeyboard(ba);
 //BA.debugLineNum = 338;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 24;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return "";
}
public String  _itemlanguage_click() throws Exception{
 //BA.debugLineNum = 341;BA.debugLine="Private Sub itemLanguage_Click";
 //BA.debugLineNum = 342;BA.debugLine="ShowLanguageDialog";
_showlanguagedialog();
 //BA.debugLineNum = 343;BA.debugLine="End Sub";
return "";
}
public String  _itempassphrasemode_click() throws Exception{
 //BA.debugLineNum = 481;BA.debugLine="Private Sub itemPassphraseMode_Click";
 //BA.debugLineNum = 482;BA.debugLine="ShowPassphraseModeDialog";
_showpassphrasemodedialog();
 //BA.debugLineNum = 483;BA.debugLine="End Sub";
return "";
}
public String  _itemtimer_click() throws Exception{
 //BA.debugLineNum = 405;BA.debugLine="Private Sub itemTimer_Click";
 //BA.debugLineNum = 406;BA.debugLine="ShowTimerDialog";
_showtimerdialog();
 //BA.debugLineNum = 407;BA.debugLine="End Sub";
return "";
}
public String  _pnloverlay_click() throws Exception{
 //BA.debugLineNum = 329;BA.debugLine="Private Sub pnlOverlay_Click";
 //BA.debugLineNum = 330;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 331;BA.debugLine="End Sub";
return "";
}
public void  _showcreatepindialog() throws Exception{
ResumableSub_ShowCreatePINDialog rsub = new ResumableSub_ShowCreatePINDialog(this);
rsub.resume(ba, null);
}
public static class ResumableSub_ShowCreatePINDialog extends BA.ResumableSub {
public ResumableSub_ShowCreatePINDialog(com.lockzero.pagesettings parent) {
this.parent = parent;
}
com.lockzero.pagesettings parent;
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
 //BA.debugLineNum = 573;BA.debugLine="Wait For (xui.Msgbox2Async(ModLang.T(\"create_pin_";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"create_pin_msg")),BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"use_pin")),parent._modlang._t /*String*/ (ba,"continue"),"",parent._modlang._t /*String*/ (ba,"cancel"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 7;
return;
case 7:
//C
this.state = 1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 575;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
if (true) break;

case 1:
//if
this.state = 6;
if (_result==parent._xui.DialogResponse_Positive) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 //BA.debugLineNum = 577;BA.debugLine="ToastMessageShow(ModLang.T(\"loading\"), False)";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"loading")),parent.__c.False);
 //BA.debugLineNum = 578;BA.debugLine="chkPIN.Checked = False";
parent._chkpin.setChecked(parent.__c.False);
 if (true) break;

case 5:
//C
this.state = 6;
 //BA.debugLineNum = 580;BA.debugLine="chkPIN.Checked = False";
parent._chkpin.setChecked(parent.__c.False);
 if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 582;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _showlanguagedialog() throws Exception{
int _dialogw = 0;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
anywheresoftware.b4a.objects.ButtonWrapper _btnpt = null;
anywheresoftware.b4a.objects.ButtonWrapper _btnen = null;
anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
 //BA.debugLineNum = 345;BA.debugLine="Private Sub ShowLanguageDialog";
 //BA.debugLineNum = 346;BA.debugLine="Dim dialogW As Int = Root.Width - 40dip";
_dialogw = (int) (_root.getWidth()-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 347;BA.debugLine="pnlDialog.RemoveAllViews";
_pnldialog.RemoveAllViews();
 //BA.debugLineNum = 350;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 351;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 352;BA.debugLine="lblTitle.Text = ModLang.T(\"language\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"language")));
 //BA.debugLineNum = 353;BA.debugLine="lblTitle.TextSize = 16";
_lbltitle.setTextSize((float) (16));
 //BA.debugLineNum = 354;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 355;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 356;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 357;BA.debugLine="pnlDialog.AddView(lblTitle, 0, 16dip, dialogW, 30";
_pnldialog.AddView((android.view.View)(_lbltitle.getObject()),(int) (0),__c.DipToCurrent((int) (16)),_dialogw,__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 360;BA.debugLine="Dim btnPT As Button";
_btnpt = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 361;BA.debugLine="btnPT.Initialize(\"btnLangPT\")";
_btnpt.Initialize(ba,"btnLangPT");
 //BA.debugLineNum = 362;BA.debugLine="btnPT.Text = \"Portugues\"";
_btnpt.setText(BA.ObjectToCharSequence("Portugues"));
 //BA.debugLineNum = 363;BA.debugLine="btnPT.TextSize = 14";
_btnpt.setTextSize((float) (14));
 //BA.debugLineNum = 364;BA.debugLine="btnPT.Color = ModTheme.HomeIconBg";
_btnpt.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 365;BA.debugLine="btnPT.TextColor = Colors.White";
_btnpt.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 366;BA.debugLine="pnlDialog.AddView(btnPT, 20dip, 60dip, dialogW -";
_pnldialog.AddView((android.view.View)(_btnpt.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (60)),(int) (_dialogw-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (48)));
 //BA.debugLineNum = 368;BA.debugLine="Dim btnEN As Button";
_btnen = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 369;BA.debugLine="btnEN.Initialize(\"btnLangEN\")";
_btnen.Initialize(ba,"btnLangEN");
 //BA.debugLineNum = 370;BA.debugLine="btnEN.Text = \"English\"";
_btnen.setText(BA.ObjectToCharSequence("English"));
 //BA.debugLineNum = 371;BA.debugLine="btnEN.TextSize = 14";
_btnen.setTextSize((float) (14));
 //BA.debugLineNum = 372;BA.debugLine="btnEN.Color = ModTheme.HomeIconBg";
_btnen.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 373;BA.debugLine="btnEN.TextColor = Colors.White";
_btnen.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 374;BA.debugLine="pnlDialog.AddView(btnEN, 20dip, 118dip, dialogW -";
_pnldialog.AddView((android.view.View)(_btnen.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (118)),(int) (_dialogw-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (48)));
 //BA.debugLineNum = 377;BA.debugLine="Dim btnCancel As Button";
_btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 378;BA.debugLine="btnCancel.Initialize(\"btnDialogCancel\")";
_btncancel.Initialize(ba,"btnDialogCancel");
 //BA.debugLineNum = 379;BA.debugLine="btnCancel.Text = ModLang.T(\"cancel\")";
_btncancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 380;BA.debugLine="btnCancel.TextSize = 13";
_btncancel.setTextSize((float) (13));
 //BA.debugLineNum = 381;BA.debugLine="btnCancel.Color = Colors.Transparent";
_btncancel.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 382;BA.debugLine="btnCancel.TextColor = Colors.ARGB(180, 255, 255,";
_btncancel.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 383;BA.debugLine="pnlDialog.AddView(btnCancel, 20dip, 180dip, dialo";
_pnldialog.AddView((android.view.View)(_btncancel.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (180)),(int) (_dialogw-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 385;BA.debugLine="pnlDialog.SetLayoutAnimated(0, 20dip, 100dip, dia";
_pnldialog.SetLayoutAnimated((int) (0),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (100)),_dialogw,__c.DipToCurrent((int) (230)));
 //BA.debugLineNum = 386;BA.debugLine="pnlOverlay.Visible = True";
_pnloverlay.setVisible(__c.True);
 //BA.debugLineNum = 387;BA.debugLine="pnlOverlay.BringToFront";
_pnloverlay.BringToFront();
 //BA.debugLineNum = 388;BA.debugLine="End Sub";
return "";
}
public String  _showpassphrasemodedialog() throws Exception{
int _dialogw = 0;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
anywheresoftware.b4a.objects.ButtonWrapper _btn1 = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl1 = null;
anywheresoftware.b4a.objects.ButtonWrapper _btn2 = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl2 = null;
anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
 //BA.debugLineNum = 485;BA.debugLine="Private Sub ShowPassphraseModeDialog";
 //BA.debugLineNum = 486;BA.debugLine="Dim dialogW As Int = Root.Width - 40dip";
_dialogw = (int) (_root.getWidth()-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 487;BA.debugLine="pnlDialog.RemoveAllViews";
_pnldialog.RemoveAllViews();
 //BA.debugLineNum = 490;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 491;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 492;BA.debugLine="lblTitle.Text = ModLang.T(\"passphrase_mode\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"passphrase_mode")));
 //BA.debugLineNum = 493;BA.debugLine="lblTitle.TextSize = 16";
_lbltitle.setTextSize((float) (16));
 //BA.debugLineNum = 494;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 495;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 496;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 497;BA.debugLine="pnlDialog.AddView(lblTitle, 0, 16dip, dialogW, 30";
_pnldialog.AddView((android.view.View)(_lbltitle.getObject()),(int) (0),__c.DipToCurrent((int) (16)),_dialogw,__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 500;BA.debugLine="Dim btn1 As Button";
_btn1 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 501;BA.debugLine="btn1.Initialize(\"btnModeSingle\")";
_btn1.Initialize(ba,"btnModeSingle");
 //BA.debugLineNum = 502;BA.debugLine="btn1.Text = ModLang.T(\"single_passphrase\")";
_btn1.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"single_passphrase")));
 //BA.debugLineNum = 503;BA.debugLine="btn1.TextSize = 14";
_btn1.setTextSize((float) (14));
 //BA.debugLineNum = 504;BA.debugLine="btn1.Color = ModTheme.HomeIconBg";
_btn1.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 505;BA.debugLine="btn1.TextColor = Colors.White";
_btn1.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 506;BA.debugLine="pnlDialog.AddView(btn1, 20dip, 55dip, dialogW - 4";
_pnldialog.AddView((android.view.View)(_btn1.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (55)),(int) (_dialogw-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 508;BA.debugLine="Dim lbl1 As Label";
_lbl1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 509;BA.debugLine="lbl1.Initialize(\"\")";
_lbl1.Initialize(ba,"");
 //BA.debugLineNum = 510;BA.debugLine="lbl1.Text = ModLang.T(\"single_passphrase_desc\")";
_lbl1.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"single_passphrase_desc")));
 //BA.debugLineNum = 511;BA.debugLine="lbl1.TextSize = 11";
_lbl1.setTextSize((float) (11));
 //BA.debugLineNum = 512;BA.debugLine="lbl1.TextColor = Colors.ARGB(150, 255, 255, 255)";
_lbl1.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 513;BA.debugLine="pnlDialog.AddView(lbl1, 20dip, 100dip, dialogW -";
_pnldialog.AddView((android.view.View)(_lbl1.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (100)),(int) (_dialogw-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 516;BA.debugLine="Dim btn2 As Button";
_btn2 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 517;BA.debugLine="btn2.Initialize(\"btnModeMulti\")";
_btn2.Initialize(ba,"btnModeMulti");
 //BA.debugLineNum = 518;BA.debugLine="btn2.Text = ModLang.T(\"multi_passphrase\")";
_btn2.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"multi_passphrase")));
 //BA.debugLineNum = 519;BA.debugLine="btn2.TextSize = 14";
_btn2.setTextSize((float) (14));
 //BA.debugLineNum = 520;BA.debugLine="btn2.Color = ModTheme.HomeIconBg";
_btn2.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 521;BA.debugLine="btn2.TextColor = Colors.White";
_btn2.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 522;BA.debugLine="pnlDialog.AddView(btn2, 20dip, 130dip, dialogW -";
_pnldialog.AddView((android.view.View)(_btn2.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (130)),(int) (_dialogw-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 524;BA.debugLine="Dim lbl2 As Label";
_lbl2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 525;BA.debugLine="lbl2.Initialize(\"\")";
_lbl2.Initialize(ba,"");
 //BA.debugLineNum = 526;BA.debugLine="lbl2.Text = ModLang.T(\"multi_passphrase_desc\")";
_lbl2.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"multi_passphrase_desc")));
 //BA.debugLineNum = 527;BA.debugLine="lbl2.TextSize = 11";
_lbl2.setTextSize((float) (11));
 //BA.debugLineNum = 528;BA.debugLine="lbl2.TextColor = Colors.ARGB(150, 255, 255, 255)";
_lbl2.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 529;BA.debugLine="pnlDialog.AddView(lbl2, 20dip, 175dip, dialogW -";
_pnldialog.AddView((android.view.View)(_lbl2.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (175)),(int) (_dialogw-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 532;BA.debugLine="Dim btnCancel As Button";
_btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 533;BA.debugLine="btnCancel.Initialize(\"btnDialogCancel\")";
_btncancel.Initialize(ba,"btnDialogCancel");
 //BA.debugLineNum = 534;BA.debugLine="btnCancel.Text = ModLang.T(\"cancel\")";
_btncancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 535;BA.debugLine="btnCancel.TextSize = 13";
_btncancel.setTextSize((float) (13));
 //BA.debugLineNum = 536;BA.debugLine="btnCancel.Color = Colors.Transparent";
_btncancel.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 537;BA.debugLine="btnCancel.TextColor = Colors.ARGB(180, 255, 255,";
_btncancel.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 538;BA.debugLine="pnlDialog.AddView(btnCancel, 20dip, 205dip, dialo";
_pnldialog.AddView((android.view.View)(_btncancel.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (205)),(int) (_dialogw-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 540;BA.debugLine="pnlDialog.SetLayoutAnimated(0, 20dip, 100dip, dia";
_pnldialog.SetLayoutAnimated((int) (0),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (100)),_dialogw,__c.DipToCurrent((int) (255)));
 //BA.debugLineNum = 541;BA.debugLine="pnlOverlay.Visible = True";
_pnloverlay.setVisible(__c.True);
 //BA.debugLineNum = 542;BA.debugLine="pnlOverlay.BringToFront";
_pnloverlay.BringToFront();
 //BA.debugLineNum = 543;BA.debugLine="End Sub";
return "";
}
public void  _showremovepindialog() throws Exception{
ResumableSub_ShowRemovePINDialog rsub = new ResumableSub_ShowRemovePINDialog(this);
rsub.resume(ba, null);
}
public static class ResumableSub_ShowRemovePINDialog extends BA.ResumableSub {
public ResumableSub_ShowRemovePINDialog(com.lockzero.pagesettings parent) {
this.parent = parent;
}
com.lockzero.pagesettings parent;
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
 //BA.debugLineNum = 585;BA.debugLine="If ModSecurity.HasPIN = False Then Return";
if (true) break;

case 1:
//if
this.state = 6;
if (parent._modsecurity._haspin /*boolean*/ (ba)==parent.__c.False) { 
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
 //BA.debugLineNum = 587;BA.debugLine="Wait For (xui.Msgbox2Async(ModLang.T(\"remove_pin_";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"remove_pin_msg")),BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"use_pin")),parent._modlang._t /*String*/ (ba,"yes"),"",parent._modlang._t /*String*/ (ba,"cancel"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 13;
return;
case 13:
//C
this.state = 7;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 589;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
if (true) break;

case 7:
//if
this.state = 12;
if (_result==parent._xui.DialogResponse_Positive) { 
this.state = 9;
}else {
this.state = 11;
}if (true) break;

case 9:
//C
this.state = 12;
 //BA.debugLineNum = 590;BA.debugLine="ModSecurity.RemovePIN";
parent._modsecurity._removepin /*String*/ (ba);
 //BA.debugLineNum = 591;BA.debugLine="ToastMessageShow(ModLang.T(\"success\"), False)";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"success")),parent.__c.False);
 if (true) break;

case 11:
//C
this.state = 12;
 //BA.debugLineNum = 593;BA.debugLine="chkPIN.Checked = True";
parent._chkpin.setChecked(parent.__c.True);
 if (true) break;

case 12:
//C
this.state = -1;
;
 //BA.debugLineNum = 595;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _showtimerdialog() throws Exception{
int _dialogw = 0;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
anywheresoftware.b4a.objects.ButtonWrapper _btn1 = null;
anywheresoftware.b4a.objects.ButtonWrapper _btn2 = null;
anywheresoftware.b4a.objects.ButtonWrapper _btn3 = null;
anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
 //BA.debugLineNum = 409;BA.debugLine="Private Sub ShowTimerDialog";
 //BA.debugLineNum = 410;BA.debugLine="Dim dialogW As Int = Root.Width - 40dip";
_dialogw = (int) (_root.getWidth()-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 411;BA.debugLine="pnlDialog.RemoveAllViews";
_pnldialog.RemoveAllViews();
 //BA.debugLineNum = 414;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 415;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 416;BA.debugLine="lblTitle.Text = ModLang.T(\"session_timeout\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"session_timeout")));
 //BA.debugLineNum = 417;BA.debugLine="lblTitle.TextSize = 16";
_lbltitle.setTextSize((float) (16));
 //BA.debugLineNum = 418;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 419;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 420;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 421;BA.debugLine="pnlDialog.AddView(lblTitle, 0, 16dip, dialogW, 30";
_pnldialog.AddView((android.view.View)(_lbltitle.getObject()),(int) (0),__c.DipToCurrent((int) (16)),_dialogw,__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 424;BA.debugLine="Dim btn1 As Button";
_btn1 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 425;BA.debugLine="btn1.Initialize(\"btnTimer1\")";
_btn1.Initialize(ba,"btnTimer1");
 //BA.debugLineNum = 426;BA.debugLine="btn1.Text = \"1 \" & ModLang.T(\"minute\")";
_btn1.setText(BA.ObjectToCharSequence("1 "+_modlang._t /*String*/ (ba,"minute")));
 //BA.debugLineNum = 427;BA.debugLine="btn1.TextSize = 14";
_btn1.setTextSize((float) (14));
 //BA.debugLineNum = 428;BA.debugLine="btn1.Color = ModTheme.HomeIconBg";
_btn1.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 429;BA.debugLine="btn1.TextColor = Colors.White";
_btn1.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 430;BA.debugLine="pnlDialog.AddView(btn1, 20dip, 60dip, dialogW - 4";
_pnldialog.AddView((android.view.View)(_btn1.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (60)),(int) (_dialogw-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 432;BA.debugLine="Dim btn2 As Button";
_btn2 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 433;BA.debugLine="btn2.Initialize(\"btnTimer2\")";
_btn2.Initialize(ba,"btnTimer2");
 //BA.debugLineNum = 434;BA.debugLine="btn2.Text = \"2 \" & ModLang.T(\"minutes\")";
_btn2.setText(BA.ObjectToCharSequence("2 "+_modlang._t /*String*/ (ba,"minutes")));
 //BA.debugLineNum = 435;BA.debugLine="btn2.TextSize = 14";
_btn2.setTextSize((float) (14));
 //BA.debugLineNum = 436;BA.debugLine="btn2.Color = ModTheme.HomeIconBg";
_btn2.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 437;BA.debugLine="btn2.TextColor = Colors.White";
_btn2.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 438;BA.debugLine="pnlDialog.AddView(btn2, 20dip, 112dip, dialogW -";
_pnldialog.AddView((android.view.View)(_btn2.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (112)),(int) (_dialogw-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 440;BA.debugLine="Dim btn3 As Button";
_btn3 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 441;BA.debugLine="btn3.Initialize(\"btnTimer3\")";
_btn3.Initialize(ba,"btnTimer3");
 //BA.debugLineNum = 442;BA.debugLine="btn3.Text = \"3 \" & ModLang.T(\"minutes\")";
_btn3.setText(BA.ObjectToCharSequence("3 "+_modlang._t /*String*/ (ba,"minutes")));
 //BA.debugLineNum = 443;BA.debugLine="btn3.TextSize = 14";
_btn3.setTextSize((float) (14));
 //BA.debugLineNum = 444;BA.debugLine="btn3.Color = ModTheme.HomeIconBg";
_btn3.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 445;BA.debugLine="btn3.TextColor = Colors.White";
_btn3.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 446;BA.debugLine="pnlDialog.AddView(btn3, 20dip, 164dip, dialogW -";
_pnldialog.AddView((android.view.View)(_btn3.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (164)),(int) (_dialogw-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 449;BA.debugLine="Dim btnCancel As Button";
_btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 450;BA.debugLine="btnCancel.Initialize(\"btnDialogCancel\")";
_btncancel.Initialize(ba,"btnDialogCancel");
 //BA.debugLineNum = 451;BA.debugLine="btnCancel.Text = ModLang.T(\"cancel\")";
_btncancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 452;BA.debugLine="btnCancel.TextSize = 13";
_btncancel.setTextSize((float) (13));
 //BA.debugLineNum = 453;BA.debugLine="btnCancel.Color = Colors.Transparent";
_btncancel.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 454;BA.debugLine="btnCancel.TextColor = Colors.ARGB(180, 255, 255,";
_btncancel.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 455;BA.debugLine="pnlDialog.AddView(btnCancel, 20dip, 220dip, dialo";
_pnldialog.AddView((android.view.View)(_btncancel.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (220)),(int) (_dialogw-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 457;BA.debugLine="pnlDialog.SetLayoutAnimated(0, 20dip, 100dip, dia";
_pnldialog.SetLayoutAnimated((int) (0),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (100)),_dialogw,__c.DipToCurrent((int) (270)));
 //BA.debugLineNum = 458;BA.debugLine="pnlOverlay.Visible = True";
_pnloverlay.setVisible(__c.True);
 //BA.debugLineNum = 459;BA.debugLine="pnlOverlay.BringToFront";
_pnloverlay.BringToFront();
 //BA.debugLineNum = 460;BA.debugLine="End Sub";
return "";
}
public String  _updatedisplayvalues() throws Exception{
 //BA.debugLineNum = 299;BA.debugLine="Private Sub UpdateDisplayValues";
 //BA.debugLineNum = 300;BA.debugLine="lblLanguageValue.Text = ModLang.GetLanguageName";
_lbllanguagevalue.setText(BA.ObjectToCharSequence(_modlang._getlanguagename /*String*/ (ba)));
 //BA.debugLineNum = 301;BA.debugLine="lblTimerValue.Text = GetTimerDisplayValue";
_lbltimervalue.setText(BA.ObjectToCharSequence(_gettimerdisplayvalue()));
 //BA.debugLineNum = 302;BA.debugLine="lblPassphraseModeValue.Text = GetPassphraseModeDi";
_lblpassphrasemodevalue.setText(BA.ObjectToCharSequence(_getpassphrasemodedisplayvalue()));
 //BA.debugLineNum = 303;BA.debugLine="chkPIN.Checked = ModSecurity.HasPIN";
_chkpin.setChecked(_modsecurity._haspin /*boolean*/ (ba));
 //BA.debugLineNum = 304;BA.debugLine="chkBiometric.Checked = ModSecurity.GetUseBiometri";
_chkbiometric.setChecked(_modsecurity._getusebiometric /*boolean*/ (ba));
 //BA.debugLineNum = 305;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
