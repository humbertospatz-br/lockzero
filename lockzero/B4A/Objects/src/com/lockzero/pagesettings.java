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
public String _temppin = "";
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
public int  _addcheckboxitem(String _chkname,String _title,String _subtitle,int _y,int _w) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xv = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chk = null;
anywheresoftware.b4a.objects.LabelWrapper _lblsub = null;
 //BA.debugLineNum = 214;BA.debugLine="Private Sub AddCheckboxItem(chkName As String, tit";
 //BA.debugLineNum = 215;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 216;BA.debugLine="pnl.Initialize(\"\")";
_pnl.Initialize(ba,"");
 //BA.debugLineNum = 218;BA.debugLine="Dim xv As B4XView = pnl";
_xv = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xv = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnl.getObject()));
 //BA.debugLineNum = 219;BA.debugLine="xv.SetColorAndBorder(ModTheme.HomeHeaderBg, 0, Mo";
_xv.SetColorAndBorder(_modtheme._homeheaderbg /*int*/ (ba),(int) (0),_modtheme._homeheaderbg /*int*/ (ba),__c.DipToCurrent((int) (10)));
 //BA.debugLineNum = 220;BA.debugLine="pnlContent.AddView(pnl, 16dip, y, w, 70dip)";
_pnlcontent.AddView((android.view.View)(_pnl.getObject()),__c.DipToCurrent((int) (16)),_y,_w,__c.DipToCurrent((int) (70)));
 //BA.debugLineNum = 223;BA.debugLine="Dim chk As CheckBox";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 224;BA.debugLine="chk.Initialize(chkName)";
_chk.Initialize(ba,_chkname);
 //BA.debugLineNum = 225;BA.debugLine="chk.Text = title";
_chk.setText(BA.ObjectToCharSequence(_title));
 //BA.debugLineNum = 226;BA.debugLine="chk.TextSize = 15";
_chk.setTextSize((float) (15));
 //BA.debugLineNum = 227;BA.debugLine="chk.TextColor = Colors.White";
_chk.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 229;BA.debugLine="If chkName = \"chkPIN\" Then";
if ((_chkname).equals("chkPIN")) { 
 //BA.debugLineNum = 230;BA.debugLine="chkPIN = chk";
_chkpin = _chk;
 //BA.debugLineNum = 231;BA.debugLine="chk.Checked = ModSecurity.HasPIN";
_chk.setChecked(_modsecurity._haspin /*boolean*/ (ba));
 }else if((_chkname).equals("chkBiometric")) { 
 //BA.debugLineNum = 233;BA.debugLine="chkBiometric = chk";
_chkbiometric = _chk;
 //BA.debugLineNum = 234;BA.debugLine="chk.Checked = ModSecurity.GetUseBiometric";
_chk.setChecked(_modsecurity._getusebiometric /*boolean*/ (ba));
 };
 //BA.debugLineNum = 237;BA.debugLine="pnl.AddView(chk, 16dip, 8dip, w - 32dip, 30dip)";
_pnl.AddView((android.view.View)(_chk.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (8)),(int) (_w-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 240;BA.debugLine="Dim lblSub As Label";
_lblsub = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 241;BA.debugLine="lblSub.Initialize(\"\")";
_lblsub.Initialize(ba,"");
 //BA.debugLineNum = 242;BA.debugLine="lblSub.Text = subtitle";
_lblsub.setText(BA.ObjectToCharSequence(_subtitle));
 //BA.debugLineNum = 243;BA.debugLine="lblSub.TextSize = 12";
_lblsub.setTextSize((float) (12));
 //BA.debugLineNum = 244;BA.debugLine="lblSub.TextColor = Colors.ARGB(150, 255, 255, 255";
_lblsub.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 245;BA.debugLine="pnl.AddView(lblSub, 48dip, 38dip, w - 64dip, 25di";
_pnl.AddView((android.view.View)(_lblsub.getObject()),__c.DipToCurrent((int) (48)),__c.DipToCurrent((int) (38)),(int) (_w-__c.DipToCurrent((int) (64))),__c.DipToCurrent((int) (25)));
 //BA.debugLineNum = 247;BA.debugLine="Return y + 80dip";
if (true) return (int) (_y+__c.DipToCurrent((int) (80)));
 //BA.debugLineNum = 248;BA.debugLine="End Sub";
return 0;
}
public int  _adddangerbutton(String _btnname,String _title,String _subtitle,int _y,int _w) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xv = null;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
anywheresoftware.b4a.objects.LabelWrapper _lblsub = null;
 //BA.debugLineNum = 250;BA.debugLine="Private Sub AddDangerButton(btnName As String, tit";
 //BA.debugLineNum = 251;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 252;BA.debugLine="pnl.Initialize(btnName)";
_pnl.Initialize(ba,_btnname);
 //BA.debugLineNum = 255;BA.debugLine="Dim xv As B4XView = pnl";
_xv = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xv = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnl.getObject()));
 //BA.debugLineNum = 256;BA.debugLine="xv.SetColorAndBorder(Colors.RGB(120, 30, 30), 0,";
_xv.SetColorAndBorder(__c.Colors.RGB((int) (120),(int) (30),(int) (30)),(int) (0),__c.Colors.RGB((int) (120),(int) (30),(int) (30)),__c.DipToCurrent((int) (10)));
 //BA.debugLineNum = 257;BA.debugLine="pnlContent.AddView(pnl, 16dip, y, w, 70dip)";
_pnlcontent.AddView((android.view.View)(_pnl.getObject()),__c.DipToCurrent((int) (16)),_y,_w,__c.DipToCurrent((int) (70)));
 //BA.debugLineNum = 260;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 261;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 262;BA.debugLine="lblTitle.Text = title";
_lbltitle.setText(BA.ObjectToCharSequence(_title));
 //BA.debugLineNum = 263;BA.debugLine="lblTitle.TextSize = 15";
_lbltitle.setTextSize((float) (15));
 //BA.debugLineNum = 264;BA.debugLine="lblTitle.TextColor = Colors.RGB(255, 100, 100)";
_lbltitle.setTextColor(__c.Colors.RGB((int) (255),(int) (100),(int) (100)));
 //BA.debugLineNum = 265;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 266;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_VERTICAL";
_lbltitle.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 267;BA.debugLine="pnl.AddView(lblTitle, 16dip, 8dip, w - 32dip, 28d";
_pnl.AddView((android.view.View)(_lbltitle.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (8)),(int) (_w-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (28)));
 //BA.debugLineNum = 270;BA.debugLine="Dim lblSub As Label";
_lblsub = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 271;BA.debugLine="lblSub.Initialize(\"\")";
_lblsub.Initialize(ba,"");
 //BA.debugLineNum = 272;BA.debugLine="lblSub.Text = subtitle";
_lblsub.setText(BA.ObjectToCharSequence(_subtitle));
 //BA.debugLineNum = 273;BA.debugLine="lblSub.TextSize = 12";
_lblsub.setTextSize((float) (12));
 //BA.debugLineNum = 274;BA.debugLine="lblSub.TextColor = Colors.ARGB(180, 255, 150, 150";
_lblsub.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (150),(int) (150)));
 //BA.debugLineNum = 275;BA.debugLine="pnl.AddView(lblSub, 16dip, 38dip, w - 32dip, 25di";
_pnl.AddView((android.view.View)(_lblsub.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (38)),(int) (_w-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (25)));
 //BA.debugLineNum = 277;BA.debugLine="Return y + 80dip";
if (true) return (int) (_y+__c.DipToCurrent((int) (80)));
 //BA.debugLineNum = 278;BA.debugLine="End Sub";
return 0;
}
public int  _addsectionheader(String _title,int _y,int _w) throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
 //BA.debugLineNum = 174;BA.debugLine="Private Sub AddSectionHeader(title As String, y As";
 //BA.debugLineNum = 175;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 176;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(ba,"");
 //BA.debugLineNum = 177;BA.debugLine="lbl.Text = title.ToUpperCase";
_lbl.setText(BA.ObjectToCharSequence(_title.toUpperCase()));
 //BA.debugLineNum = 178;BA.debugLine="lbl.TextSize = 12";
_lbl.setTextSize((float) (12));
 //BA.debugLineNum = 179;BA.debugLine="lbl.TextColor = ModTheme.HomeIconBg";
_lbl.setTextColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 180;BA.debugLine="lbl.Typeface = Typeface.DEFAULT_BOLD";
_lbl.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 181;BA.debugLine="pnlContent.AddView(lbl, 16dip, y, w, 25dip)";
_pnlcontent.AddView((android.view.View)(_lbl.getObject()),__c.DipToCurrent((int) (16)),_y,_w,__c.DipToCurrent((int) (25)));
 //BA.debugLineNum = 182;BA.debugLine="Return y + 30dip";
if (true) return (int) (_y+__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 183;BA.debugLine="End Sub";
return 0;
}
public int  _addsettingitem(String _eventname,String _title,String _subtitle,int _y,int _w) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xv = null;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
anywheresoftware.b4a.objects.LabelWrapper _lblarrow = null;
 //BA.debugLineNum = 185;BA.debugLine="Private Sub AddSettingItem(eventName As String, ti";
 //BA.debugLineNum = 186;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 187;BA.debugLine="pnl.Initialize(eventName)";
_pnl.Initialize(ba,_eventname);
 //BA.debugLineNum = 189;BA.debugLine="Dim xv As B4XView = pnl";
_xv = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xv = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnl.getObject()));
 //BA.debugLineNum = 190;BA.debugLine="xv.SetColorAndBorder(ModTheme.HomeHeaderBg, 0, Mo";
_xv.SetColorAndBorder(_modtheme._homeheaderbg /*int*/ (ba),(int) (0),_modtheme._homeheaderbg /*int*/ (ba),__c.DipToCurrent((int) (10)));
 //BA.debugLineNum = 191;BA.debugLine="pnlContent.AddView(pnl, 16dip, y, w, 60dip)";
_pnlcontent.AddView((android.view.View)(_pnl.getObject()),__c.DipToCurrent((int) (16)),_y,_w,__c.DipToCurrent((int) (60)));
 //BA.debugLineNum = 194;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 195;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 196;BA.debugLine="lblTitle.Text = title";
_lbltitle.setText(BA.ObjectToCharSequence(_title));
 //BA.debugLineNum = 197;BA.debugLine="lblTitle.TextSize = 15";
_lbltitle.setTextSize((float) (15));
 //BA.debugLineNum = 198;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 199;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_VERTICAL";
_lbltitle.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 200;BA.debugLine="pnl.AddView(lblTitle, 16dip, 0, w - 150dip, 60dip";
_pnl.AddView((android.view.View)(_lbltitle.getObject()),__c.DipToCurrent((int) (16)),(int) (0),(int) (_w-__c.DipToCurrent((int) (150))),__c.DipToCurrent((int) (60)));
 //BA.debugLineNum = 203;BA.debugLine="Dim lblArrow As Label";
_lblarrow = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 204;BA.debugLine="lblArrow.Initialize(\"\")";
_lblarrow.Initialize(ba,"");
 //BA.debugLineNum = 205;BA.debugLine="lblArrow.Text = \">\"";
_lblarrow.setText(BA.ObjectToCharSequence(">"));
 //BA.debugLineNum = 206;BA.debugLine="lblArrow.TextSize = 16";
_lblarrow.setTextSize((float) (16));
 //BA.debugLineNum = 207;BA.debugLine="lblArrow.TextColor = Colors.ARGB(100, 255, 255, 2";
_lblarrow.setTextColor(__c.Colors.ARGB((int) (100),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 208;BA.debugLine="lblArrow.Gravity = Gravity.CENTER";
_lblarrow.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 209;BA.debugLine="pnl.AddView(lblArrow, w - 40dip, 0, 30dip, 60dip)";
_pnl.AddView((android.view.View)(_lblarrow.getObject()),(int) (_w-__c.DipToCurrent((int) (40))),(int) (0),__c.DipToCurrent((int) (30)),__c.DipToCurrent((int) (60)));
 //BA.debugLineNum = 211;BA.debugLine="Return y + 70dip";
if (true) return (int) (_y+__c.DipToCurrent((int) (70)));
 //BA.debugLineNum = 212;BA.debugLine="End Sub";
return 0;
}
public String  _applytheme() throws Exception{
 //BA.debugLineNum = 779;BA.debugLine="Private Sub ApplyTheme";
 //BA.debugLineNum = 780;BA.debugLine="Root.Color = ModTheme.HomeBg";
_root.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 781;BA.debugLine="svContent.Color = ModTheme.HomeBg";
_svcontent.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 782;BA.debugLine="pnlContent.Color = ModTheme.HomeBg";
_pnlcontent.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 783;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_appear() throws Exception{
 //BA.debugLineNum = 35;BA.debugLine="Private Sub B4XPage_Appear";
 //BA.debugLineNum = 37;BA.debugLine="Root.RemoveAllViews";
_root.RemoveAllViews();
 //BA.debugLineNum = 38;BA.debugLine="CreateUI";
_createui();
 //BA.debugLineNum = 39;BA.debugLine="ApplyTheme";
_applytheme();
 //BA.debugLineNum = 42;BA.debugLine="CallSub2(Main, \"SetPageTitle\", ModLang.T(\"setting";
__c.CallSubNew2(ba,(Object)(_main.getObject()),"SetPageTitle",(Object)(_modlang._t /*String*/ (ba,"settings")));
 //BA.debugLineNum = 45;BA.debugLine="UpdateDisplayValues";
_updatedisplayvalues();
 //BA.debugLineNum = 46;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
 //BA.debugLineNum = 31;BA.debugLine="Private Sub B4XPage_Created(Root1 As B4XView)";
 //BA.debugLineNum = 32;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return "";
}
public String  _btnback_click() throws Exception{
 //BA.debugLineNum = 328;BA.debugLine="Private Sub btnBack_Click";
 //BA.debugLineNum = 329;BA.debugLine="B4XPages.ClosePage(Me)";
_b4xpages._closepage /*String*/ (ba,this);
 //BA.debugLineNum = 330;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 745;BA.debugLine="Wait For (xui.Msgbox2Async(ModLang.T(\"clear_data_";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"clear_data_confirm")),BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"warning")),parent._modlang._t /*String*/ (ba,"delete"),"",parent._modlang._t /*String*/ (ba,"cancel"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 747;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
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
 //BA.debugLineNum = 749;BA.debugLine="ClearAllData";
parent._clearalldata();
 //BA.debugLineNum = 750;BA.debugLine="ToastMessageShow(ModLang.T(\"data_cleared\"), True";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"data_cleared")),parent.__c.True);
 //BA.debugLineNum = 752;BA.debugLine="B4XPages.ShowPageAndRemovePreviousPages(\"mainpag";
parent._b4xpages._showpageandremovepreviouspages /*String*/ (ba,"mainpage");
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 754;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _msgbox_result(int _result) throws Exception{
}
public String  _btndialogcancel_click() throws Exception{
 //BA.debugLineNum = 738;BA.debugLine="Private Sub btnDialogCancel_Click";
 //BA.debugLineNum = 739;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 740;BA.debugLine="End Sub";
return "";
}
public String  _btnlangen_click() throws Exception{
 //BA.debugLineNum = 401;BA.debugLine="Private Sub btnLangEN_Click";
 //BA.debugLineNum = 402;BA.debugLine="ModLang.SetLanguage(\"en\")";
_modlang._setlanguage /*String*/ (ba,"en");
 //BA.debugLineNum = 403;BA.debugLine="ModSecurity.SaveLanguage(\"en\")";
_modsecurity._savelanguage /*String*/ (ba,"en");
 //BA.debugLineNum = 404;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 405;BA.debugLine="RefreshUI";
_refreshui();
 //BA.debugLineNum = 406;BA.debugLine="ToastMessageShow(ModLang.T(\"success\"), False)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"success")),__c.False);
 //BA.debugLineNum = 407;BA.debugLine="End Sub";
return "";
}
public String  _btnlangpt_click() throws Exception{
 //BA.debugLineNum = 393;BA.debugLine="Private Sub btnLangPT_Click";
 //BA.debugLineNum = 394;BA.debugLine="ModLang.SetLanguage(\"pt\")";
_modlang._setlanguage /*String*/ (ba,"pt");
 //BA.debugLineNum = 395;BA.debugLine="ModSecurity.SaveLanguage(\"pt\")";
_modsecurity._savelanguage /*String*/ (ba,"pt");
 //BA.debugLineNum = 396;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 397;BA.debugLine="RefreshUI";
_refreshui();
 //BA.debugLineNum = 398;BA.debugLine="ToastMessageShow(ModLang.T(\"success\"), False)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"success")),__c.False);
 //BA.debugLineNum = 399;BA.debugLine="End Sub";
return "";
}
public String  _btnmodemulti_click() throws Exception{
 //BA.debugLineNum = 567;BA.debugLine="Private Sub btnModeMulti_Click";
 //BA.debugLineNum = 568;BA.debugLine="ModSecurity.SetUseSinglePassphrase(False)";
_modsecurity._setusesinglepassphrase /*String*/ (ba,__c.False);
 //BA.debugLineNum = 569;BA.debugLine="ModSession.EndSession 'Encerra sessao atual para";
_modsession._endsession /*String*/ (ba);
 //BA.debugLineNum = 570;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 571;BA.debugLine="UpdateDisplayValues";
_updatedisplayvalues();
 //BA.debugLineNum = 572;BA.debugLine="ToastMessageShow(ModLang.T(\"success\"), False)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"success")),__c.False);
 //BA.debugLineNum = 573;BA.debugLine="End Sub";
return "";
}
public String  _btnmodesingle_click() throws Exception{
 //BA.debugLineNum = 559;BA.debugLine="Private Sub btnModeSingle_Click";
 //BA.debugLineNum = 560;BA.debugLine="ModSecurity.SetUseSinglePassphrase(True)";
_modsecurity._setusesinglepassphrase /*String*/ (ba,__c.True);
 //BA.debugLineNum = 561;BA.debugLine="ModSession.EndSession 'Encerra sessao atual para";
_modsession._endsession /*String*/ (ba);
 //BA.debugLineNum = 562;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 563;BA.debugLine="UpdateDisplayValues";
_updatedisplayvalues();
 //BA.debugLineNum = 564;BA.debugLine="ToastMessageShow(ModLang.T(\"success\"), False)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"success")),__c.False);
 //BA.debugLineNum = 565;BA.debugLine="End Sub";
return "";
}
public String  _btnpincancel_click() throws Exception{
 //BA.debugLineNum = 714;BA.debugLine="Private Sub btnPINCancel_Click";
 //BA.debugLineNum = 715;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 716;BA.debugLine="TempPIN = \"\"";
_temppin = "";
 //BA.debugLineNum = 718;BA.debugLine="chkPIN.Checked = ModSecurity.HasPIN";
_chkpin.setChecked(_modsecurity._haspin /*boolean*/ (ba));
 //BA.debugLineNum = 719;BA.debugLine="End Sub";
return "";
}
public void  _btnpinok_click() throws Exception{
ResumableSub_btnPINOK_Click rsub = new ResumableSub_btnPINOK_Click(this);
rsub.resume(ba, null);
}
public static class ResumableSub_btnPINOK_Click extends BA.ResumableSub {
public ResumableSub_btnPINOK_Click(com.lockzero.pagesettings parent) {
this.parent = parent;
}
com.lockzero.pagesettings parent;
anywheresoftware.b4a.objects.EditTextWrapper _edtpin = null;
int _i = 0;
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
String _pin = "";
String _mode = "";
int step2;
int limit2;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 660;BA.debugLine="Dim edtPIN As EditText";
_edtpin = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 661;BA.debugLine="For i = 0 To pnlDialog.NumberOfViews - 1";
if (true) break;

case 1:
//for
this.state = 8;
step2 = 1;
limit2 = (int) (parent._pnldialog.getNumberOfViews()-1);
_i = (int) (0) ;
this.state = 32;
if (true) break;

case 32:
//C
this.state = 8;
if ((step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2)) this.state = 3;
if (true) break;

case 33:
//C
this.state = 32;
_i = ((int)(0 + _i + step2)) ;
if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 662;BA.debugLine="Dim v As View = pnlDialog.GetView(i)";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
_v = parent._pnldialog.GetView(_i);
 //BA.debugLineNum = 663;BA.debugLine="If v Is EditText Then";
if (true) break;

case 4:
//if
this.state = 7;
if (_v.getObjectOrNull() instanceof android.widget.EditText) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 664;BA.debugLine="edtPIN = v";
_edtpin = (anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(_v.getObject()));
 //BA.debugLineNum = 665;BA.debugLine="Exit";
this.state = 8;
if (true) break;
 if (true) break;

case 7:
//C
this.state = 33;
;
 if (true) break;
if (true) break;

case 8:
//C
this.state = 9;
;
 //BA.debugLineNum = 669;BA.debugLine="Dim pin As String = edtPIN.Text.Trim";
_pin = _edtpin.getText().trim();
 //BA.debugLineNum = 670;BA.debugLine="Dim mode As String = pnlDialog.Tag";
_mode = BA.ObjectToString(parent._pnldialog.getTag());
 //BA.debugLineNum = 673;BA.debugLine="If pin.Length < 4 Or pin.Length > 8 Then";
if (true) break;

case 9:
//if
this.state = 12;
if (_pin.length()<4 || _pin.length()>8) { 
this.state = 11;
}if (true) break;

case 11:
//C
this.state = 12;
 //BA.debugLineNum = 674;BA.debugLine="ToastMessageShow(ModLang.T(\"pin_too_short\"), Fal";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"pin_too_short")),parent.__c.False);
 //BA.debugLineNum = 675;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
 //BA.debugLineNum = 678;BA.debugLine="If mode = \"create\" Then";

case 12:
//if
this.state = 31;
if ((_mode).equals("create")) { 
this.state = 14;
}else if((_mode).equals("confirm")) { 
this.state = 16;
}else if((_mode).equals("remove")) { 
this.state = 24;
}if (true) break;

case 14:
//C
this.state = 31;
 //BA.debugLineNum = 680;BA.debugLine="TempPIN = pin";
parent._temppin = _pin;
 //BA.debugLineNum = 681;BA.debugLine="HideDialog";
parent._hidedialog();
 //BA.debugLineNum = 682;BA.debugLine="Sleep(200)";
parent.__c.Sleep(ba,this,(int) (200));
this.state = 34;
return;
case 34:
//C
this.state = 31;
;
 //BA.debugLineNum = 683;BA.debugLine="ShowPINInputDialog(\"confirm\")";
parent._showpininputdialog("confirm");
 if (true) break;

case 16:
//C
this.state = 17;
 //BA.debugLineNum = 687;BA.debugLine="If pin = TempPIN Then";
if (true) break;

case 17:
//if
this.state = 22;
if ((_pin).equals(parent._temppin)) { 
this.state = 19;
}else {
this.state = 21;
}if (true) break;

case 19:
//C
this.state = 22;
 //BA.debugLineNum = 688;BA.debugLine="ModSecurity.SavePIN(pin)";
parent._modsecurity._savepin /*String*/ (ba,_pin);
 //BA.debugLineNum = 689;BA.debugLine="HideDialog";
parent._hidedialog();
 //BA.debugLineNum = 690;BA.debugLine="chkPIN.Checked = True";
parent._chkpin.setChecked(parent.__c.True);
 //BA.debugLineNum = 691;BA.debugLine="ToastMessageShow(ModLang.T(\"pin_saved\"), False)";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"pin_saved")),parent.__c.False);
 if (true) break;

case 21:
//C
this.state = 22;
 //BA.debugLineNum = 693;BA.debugLine="ToastMessageShow(ModLang.T(\"pin_mismatch\"), Fal";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"pin_mismatch")),parent.__c.False);
 //BA.debugLineNum = 695;BA.debugLine="TempPIN = \"\"";
parent._temppin = "";
 //BA.debugLineNum = 696;BA.debugLine="HideDialog";
parent._hidedialog();
 //BA.debugLineNum = 697;BA.debugLine="Sleep(200)";
parent.__c.Sleep(ba,this,(int) (200));
this.state = 35;
return;
case 35:
//C
this.state = 22;
;
 //BA.debugLineNum = 698;BA.debugLine="ShowPINInputDialog(\"create\")";
parent._showpininputdialog("create");
 if (true) break;

case 22:
//C
this.state = 31;
;
 if (true) break;

case 24:
//C
this.state = 25;
 //BA.debugLineNum = 703;BA.debugLine="If ModSecurity.ValidatePIN(pin) Then";
if (true) break;

case 25:
//if
this.state = 30;
if (parent._modsecurity._validatepin /*boolean*/ (ba,_pin)) { 
this.state = 27;
}else {
this.state = 29;
}if (true) break;

case 27:
//C
this.state = 30;
 //BA.debugLineNum = 704;BA.debugLine="ModSecurity.RemovePIN";
parent._modsecurity._removepin /*String*/ (ba);
 //BA.debugLineNum = 705;BA.debugLine="HideDialog";
parent._hidedialog();
 //BA.debugLineNum = 706;BA.debugLine="chkPIN.Checked = False";
parent._chkpin.setChecked(parent.__c.False);
 //BA.debugLineNum = 707;BA.debugLine="ToastMessageShow(ModLang.T(\"pin_removed\"), Fals";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"pin_removed")),parent.__c.False);
 if (true) break;

case 29:
//C
this.state = 30;
 //BA.debugLineNum = 709;BA.debugLine="ToastMessageShow(ModLang.T(\"pin_wrong\"), False)";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"pin_wrong")),parent.__c.False);
 if (true) break;

case 30:
//C
this.state = 31;
;
 if (true) break;

case 31:
//C
this.state = -1;
;
 //BA.debugLineNum = 712;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _btntimer1_click() throws Exception{
 //BA.debugLineNum = 476;BA.debugLine="Private Sub btnTimer1_Click";
 //BA.debugLineNum = 477;BA.debugLine="ModSecurity.SaveSessionTimeout(60)";
_modsecurity._savesessiontimeout /*String*/ (ba,(int) (60));
 //BA.debugLineNum = 478;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 479;BA.debugLine="UpdateDisplayValues";
_updatedisplayvalues();
 //BA.debugLineNum = 480;BA.debugLine="End Sub";
return "";
}
public String  _btntimer2_click() throws Exception{
 //BA.debugLineNum = 482;BA.debugLine="Private Sub btnTimer2_Click";
 //BA.debugLineNum = 483;BA.debugLine="ModSecurity.SaveSessionTimeout(120)";
_modsecurity._savesessiontimeout /*String*/ (ba,(int) (120));
 //BA.debugLineNum = 484;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 485;BA.debugLine="UpdateDisplayValues";
_updatedisplayvalues();
 //BA.debugLineNum = 486;BA.debugLine="End Sub";
return "";
}
public String  _btntimer3_click() throws Exception{
 //BA.debugLineNum = 488;BA.debugLine="Private Sub btnTimer3_Click";
 //BA.debugLineNum = 489;BA.debugLine="ModSecurity.SaveSessionTimeout(180)";
_modsecurity._savesessiontimeout /*String*/ (ba,(int) (180));
 //BA.debugLineNum = 490;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 491;BA.debugLine="UpdateDisplayValues";
_updatedisplayvalues();
 //BA.debugLineNum = 492;BA.debugLine="End Sub";
return "";
}
public String  _chkbiometric_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 728;BA.debugLine="Private Sub chkBiometric_CheckedChange(Checked As";
 //BA.debugLineNum = 729;BA.debugLine="ModSecurity.SetUseBiometric(Checked)";
_modsecurity._setusebiometric /*String*/ (ba,_checked);
 //BA.debugLineNum = 730;BA.debugLine="If Checked Then";
if (_checked) { 
 //BA.debugLineNum = 731;BA.debugLine="ToastMessageShow(ModLang.T(\"biometric_enabled\"),";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"biometric_enabled")),__c.False);
 }else {
 //BA.debugLineNum = 733;BA.debugLine="ToastMessageShow(ModLang.T(\"biometric_disabled\")";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"biometric_disabled")),__c.False);
 };
 //BA.debugLineNum = 735;BA.debugLine="End Sub";
return "";
}
public String  _chkpin_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 576;BA.debugLine="Private Sub chkPIN_CheckedChange(Checked As Boolea";
 //BA.debugLineNum = 577;BA.debugLine="If Checked Then";
if (_checked) { 
 //BA.debugLineNum = 579;BA.debugLine="ShowCreatePINDialog";
_showcreatepindialog();
 }else {
 //BA.debugLineNum = 582;BA.debugLine="ShowRemovePINDialog";
_showremovepindialog();
 };
 //BA.debugLineNum = 584;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 4;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Public Root As B4XView  'Public para transicoes";
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
 //BA.debugLineNum = 24;BA.debugLine="Private TempPIN As String";
_temppin = "";
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}
public String  _clearalldata() throws Exception{
 //BA.debugLineNum = 756;BA.debugLine="Private Sub ClearAllData";
 //BA.debugLineNum = 758;BA.debugLine="If File.Exists(File.DirInternal, \"lockzero_passwo";
if (__c.File.Exists(__c.File.getDirInternal(),"lockzero_passwords.json")) { 
 //BA.debugLineNum = 759;BA.debugLine="File.Delete(File.DirInternal, \"lockzero_password";
__c.File.Delete(__c.File.getDirInternal(),"lockzero_passwords.json");
 };
 //BA.debugLineNum = 761;BA.debugLine="If File.Exists(File.DirInternal, \"lockzero_notes.";
if (__c.File.Exists(__c.File.getDirInternal(),"lockzero_notes.json")) { 
 //BA.debugLineNum = 762;BA.debugLine="File.Delete(File.DirInternal, \"lockzero_notes.js";
__c.File.Delete(__c.File.getDirInternal(),"lockzero_notes.json");
 };
 //BA.debugLineNum = 766;BA.debugLine="ModPasswords.ForceReload";
_modpasswords._forcereload /*String*/ (ba);
 //BA.debugLineNum = 767;BA.debugLine="ModNotes.ForceReload";
_modnotes._forcereload /*String*/ (ba);
 //BA.debugLineNum = 770;BA.debugLine="ModSession.EndSession";
_modsession._endsession /*String*/ (ba);
 //BA.debugLineNum = 772;BA.debugLine="Log(\"=== DADOS LIMPOS ===\")";
__c.LogImpl("843253776","=== DADOS LIMPOS ===",0);
 //BA.debugLineNum = 773;BA.debugLine="End Sub";
return "";
}
public String  _createdialogoverlay() throws Exception{
int _width = 0;
int _height = 0;
int _dialogw = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _xvdialog = null;
 //BA.debugLineNum = 280;BA.debugLine="Private Sub CreateDialogOverlay";
 //BA.debugLineNum = 281;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 282;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 284;BA.debugLine="pnlOverlay.Initialize(\"pnlOverlay\")";
_pnloverlay.Initialize(ba,"pnlOverlay");
 //BA.debugLineNum = 285;BA.debugLine="pnlOverlay.Color = Colors.ARGB(180, 0, 0, 0)";
_pnloverlay.setColor(__c.Colors.ARGB((int) (180),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 286;BA.debugLine="pnlOverlay.Visible = False";
_pnloverlay.setVisible(__c.False);
 //BA.debugLineNum = 287;BA.debugLine="Root.AddView(pnlOverlay, 0, 0, width, height)";
_root.AddView((android.view.View)(_pnloverlay.getObject()),(int) (0),(int) (0),_width,_height);
 //BA.debugLineNum = 289;BA.debugLine="Dim dialogW As Int = width - 40dip";
_dialogw = (int) (_width-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 290;BA.debugLine="pnlDialog.Initialize(\"\")";
_pnldialog.Initialize(ba,"");
 //BA.debugLineNum = 291;BA.debugLine="pnlDialog.Color = ModTheme.HomeHeaderBg";
_pnldialog.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 292;BA.debugLine="pnlOverlay.AddView(pnlDialog, 20dip, 100dip, dial";
_pnloverlay.AddView((android.view.View)(_pnldialog.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (100)),_dialogw,__c.DipToCurrent((int) (250)));
 //BA.debugLineNum = 294;BA.debugLine="Dim xvDialog As B4XView = pnlDialog";
_xvdialog = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvdialog = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnldialog.getObject()));
 //BA.debugLineNum = 295;BA.debugLine="xvDialog.SetColorAndBorder(ModTheme.HomeHeaderBg,";
_xvdialog.SetColorAndBorder(_modtheme._homeheaderbg /*int*/ (ba),(int) (0),_modtheme._homeheaderbg /*int*/ (ba),__c.DipToCurrent((int) (12)));
 //BA.debugLineNum = 296;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 52;BA.debugLine="Private Sub CreateUI";
 //BA.debugLineNum = 53;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 54;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 55;BA.debugLine="Dim headerH As Int = 56dip";
_headerh = __c.DipToCurrent((int) (56));
 //BA.debugLineNum = 58;BA.debugLine="Dim pnlHeader As Panel";
_pnlheader = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 59;BA.debugLine="pnlHeader.Initialize(\"\")";
_pnlheader.Initialize(ba,"");
 //BA.debugLineNum = 60;BA.debugLine="pnlHeader.Color = ModTheme.HomeHeaderBg";
_pnlheader.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 61;BA.debugLine="Root.AddView(pnlHeader, 0, 0, width, headerH)";
_root.AddView((android.view.View)(_pnlheader.getObject()),(int) (0),(int) (0),_width,_headerh);
 //BA.debugLineNum = 64;BA.debugLine="Dim btnBack As Button";
_btnback = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 65;BA.debugLine="btnBack.Initialize(\"btnBack\")";
_btnback.Initialize(ba,"btnBack");
 //BA.debugLineNum = 66;BA.debugLine="btnBack.Text = \"<\"";
_btnback.setText(BA.ObjectToCharSequence("<"));
 //BA.debugLineNum = 67;BA.debugLine="btnBack.TextSize = 20";
_btnback.setTextSize((float) (20));
 //BA.debugLineNum = 68;BA.debugLine="btnBack.Color = Colors.Transparent";
_btnback.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 69;BA.debugLine="btnBack.TextColor = Colors.White";
_btnback.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 70;BA.debugLine="btnBack.Gravity = Gravity.CENTER";
_btnback.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 71;BA.debugLine="pnlHeader.AddView(btnBack, 0, 0, 50dip, headerH)";
_pnlheader.AddView((android.view.View)(_btnback.getObject()),(int) (0),(int) (0),__c.DipToCurrent((int) (50)),_headerh);
 //BA.debugLineNum = 74;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 75;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 76;BA.debugLine="lblTitle.Text = ModLang.T(\"settings\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"settings")));
 //BA.debugLineNum = 77;BA.debugLine="lblTitle.TextSize = 18";
_lbltitle.setTextSize((float) (18));
 //BA.debugLineNum = 78;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 79;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 80;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_VERTICAL";
_lbltitle.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 81;BA.debugLine="pnlHeader.AddView(lblTitle, 50dip, 0, width - 60d";
_pnlheader.AddView((android.view.View)(_lbltitle.getObject()),__c.DipToCurrent((int) (50)),(int) (0),(int) (_width-__c.DipToCurrent((int) (60))),_headerh);
 //BA.debugLineNum = 84;BA.debugLine="svContent.Initialize(0)";
_svcontent.Initialize(ba,(int) (0));
 //BA.debugLineNum = 85;BA.debugLine="svContent.Color = ModTheme.HomeBg";
_svcontent.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 86;BA.debugLine="Root.AddView(svContent, 0, headerH, width, height";
_root.AddView((android.view.View)(_svcontent.getObject()),(int) (0),_headerh,_width,(int) (_height-_headerh));
 //BA.debugLineNum = 88;BA.debugLine="pnlContent = svContent.Panel";
_pnlcontent = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_svcontent.getPanel().getObject()));
 //BA.debugLineNum = 89;BA.debugLine="pnlContent.Color = ModTheme.HomeBg";
_pnlcontent.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 91;BA.debugLine="Dim y As Int = 20dip";
_y = __c.DipToCurrent((int) (20));
 //BA.debugLineNum = 92;BA.debugLine="Dim itemW As Int = width - 32dip";
_itemw = (int) (_width-__c.DipToCurrent((int) (32)));
 //BA.debugLineNum = 95;BA.debugLine="y = AddSectionHeader(ModLang.T(\"settings_general\"";
_y = _addsectionheader(_modlang._t /*String*/ (ba,"settings_general"),_y,_itemw);
 //BA.debugLineNum = 98;BA.debugLine="y = AddSettingItem(\"itemLanguage\", ModLang.T(\"lan";
_y = _addsettingitem("itemLanguage",_modlang._t /*String*/ (ba,"language"),"",_y,_itemw);
 //BA.debugLineNum = 99;BA.debugLine="lblLanguageValue.Initialize(\"\")";
_lbllanguagevalue.Initialize(ba,"");
 //BA.debugLineNum = 100;BA.debugLine="lblLanguageValue.Text = ModLang.GetLanguageName";
_lbllanguagevalue.setText(BA.ObjectToCharSequence(_modlang._getlanguagename /*String*/ (ba)));
 //BA.debugLineNum = 101;BA.debugLine="lblLanguageValue.TextSize = 14";
_lbllanguagevalue.setTextSize((float) (14));
 //BA.debugLineNum = 102;BA.debugLine="lblLanguageValue.TextColor = Colors.ARGB(180, 255";
_lbllanguagevalue.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 103;BA.debugLine="lblLanguageValue.Gravity = Gravity.RIGHT + Gravit";
_lbllanguagevalue.setGravity((int) (__c.Gravity.RIGHT+__c.Gravity.CENTER_VERTICAL));
 //BA.debugLineNum = 104;BA.debugLine="pnlContent.AddView(lblLanguageValue, width - 170d";
_pnlcontent.AddView((android.view.View)(_lbllanguagevalue.getObject()),(int) (_width-__c.DipToCurrent((int) (170))),(int) (_y-__c.DipToCurrent((int) (60))),__c.DipToCurrent((int) (110)),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 107;BA.debugLine="y = AddSettingItem(\"itemTimer\", ModLang.T(\"sessio";
_y = _addsettingitem("itemTimer",_modlang._t /*String*/ (ba,"session_timeout"),"",_y,_itemw);
 //BA.debugLineNum = 108;BA.debugLine="lblTimerValue.Initialize(\"\")";
_lbltimervalue.Initialize(ba,"");
 //BA.debugLineNum = 109;BA.debugLine="lblTimerValue.Text = GetTimerDisplayValue";
_lbltimervalue.setText(BA.ObjectToCharSequence(_gettimerdisplayvalue()));
 //BA.debugLineNum = 110;BA.debugLine="lblTimerValue.TextSize = 14";
_lbltimervalue.setTextSize((float) (14));
 //BA.debugLineNum = 111;BA.debugLine="lblTimerValue.TextColor = Colors.ARGB(180, 255, 2";
_lbltimervalue.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 112;BA.debugLine="lblTimerValue.Gravity = Gravity.RIGHT + Gravity.C";
_lbltimervalue.setGravity((int) (__c.Gravity.RIGHT+__c.Gravity.CENTER_VERTICAL));
 //BA.debugLineNum = 113;BA.debugLine="pnlContent.AddView(lblTimerValue, width - 170dip,";
_pnlcontent.AddView((android.view.View)(_lbltimervalue.getObject()),(int) (_width-__c.DipToCurrent((int) (170))),(int) (_y-__c.DipToCurrent((int) (60))),__c.DipToCurrent((int) (110)),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 116;BA.debugLine="y = AddSettingItem(\"itemPassphraseMode\", ModLang.";
_y = _addsettingitem("itemPassphraseMode",_modlang._t /*String*/ (ba,"passphrase_mode"),"",_y,_itemw);
 //BA.debugLineNum = 117;BA.debugLine="lblPassphraseModeValue.Initialize(\"\")";
_lblpassphrasemodevalue.Initialize(ba,"");
 //BA.debugLineNum = 118;BA.debugLine="lblPassphraseModeValue.Text = GetPassphraseModeDi";
_lblpassphrasemodevalue.setText(BA.ObjectToCharSequence(_getpassphrasemodedisplayvalue()));
 //BA.debugLineNum = 119;BA.debugLine="lblPassphraseModeValue.TextSize = 14";
_lblpassphrasemodevalue.setTextSize((float) (14));
 //BA.debugLineNum = 120;BA.debugLine="lblPassphraseModeValue.TextColor = Colors.ARGB(18";
_lblpassphrasemodevalue.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 121;BA.debugLine="lblPassphraseModeValue.Gravity = Gravity.RIGHT +";
_lblpassphrasemodevalue.setGravity((int) (__c.Gravity.RIGHT+__c.Gravity.CENTER_VERTICAL));
 //BA.debugLineNum = 122;BA.debugLine="pnlContent.AddView(lblPassphraseModeValue, width";
_pnlcontent.AddView((android.view.View)(_lblpassphrasemodevalue.getObject()),(int) (_width-__c.DipToCurrent((int) (190))),(int) (_y-__c.DipToCurrent((int) (60))),__c.DipToCurrent((int) (130)),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 124;BA.debugLine="y = y + 10dip";
_y = (int) (_y+__c.DipToCurrent((int) (10)));
 //BA.debugLineNum = 127;BA.debugLine="y = AddSectionHeader(ModLang.T(\"settings_security";
_y = _addsectionheader(_modlang._t /*String*/ (ba,"settings_security"),_y,_itemw);
 //BA.debugLineNum = 130;BA.debugLine="y = AddCheckboxItem(\"chkPIN\", ModLang.T(\"use_pin\"";
_y = _addcheckboxitem("chkPIN",_modlang._t /*String*/ (ba,"use_pin"),_modlang._t /*String*/ (ba,"use_pin_desc"),_y,_itemw);
 //BA.debugLineNum = 133;BA.debugLine="y = AddCheckboxItem(\"chkBiometric\", ModLang.T(\"us";
_y = _addcheckboxitem("chkBiometric",_modlang._t /*String*/ (ba,"use_biometric"),_modlang._t /*String*/ (ba,"use_biometric_desc"),_y,_itemw);
 //BA.debugLineNum = 135;BA.debugLine="y = y + 20dip";
_y = (int) (_y+__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 138;BA.debugLine="y = AddSectionHeader(ModLang.T(\"data\"), y, itemW)";
_y = _addsectionheader(_modlang._t /*String*/ (ba,"data"),_y,_itemw);
 //BA.debugLineNum = 141;BA.debugLine="y = AddDangerButton(\"btnClearData\", ModLang.T(\"cl";
_y = _adddangerbutton("btnClearData",_modlang._t /*String*/ (ba,"clear_data"),_modlang._t /*String*/ (ba,"clear_data_desc"),_y,_itemw);
 //BA.debugLineNum = 143;BA.debugLine="y = y + 20dip";
_y = (int) (_y+__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 146;BA.debugLine="y = AddSectionHeader(ModLang.T(\"about\"), y, itemW";
_y = _addsectionheader(_modlang._t /*String*/ (ba,"about"),_y,_itemw);
 //BA.debugLineNum = 149;BA.debugLine="Dim lblVersion As Label";
_lblversion = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 150;BA.debugLine="lblVersion.Initialize(\"\")";
_lblversion.Initialize(ba,"");
 //BA.debugLineNum = 151;BA.debugLine="lblVersion.Text = Starter.APP_NAME & \" v\" & Start";
_lblversion.setText(BA.ObjectToCharSequence(_starter._app_name /*String*/ +" v"+_starter._app_version /*String*/ ));
 //BA.debugLineNum = 152;BA.debugLine="lblVersion.TextSize = 14";
_lblversion.setTextSize((float) (14));
 //BA.debugLineNum = 153;BA.debugLine="lblVersion.TextColor = Colors.ARGB(150, 255, 255,";
_lblversion.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 154;BA.debugLine="lblVersion.Gravity = Gravity.CENTER_HORIZONTAL";
_lblversion.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 155;BA.debugLine="pnlContent.AddView(lblVersion, 16dip, y, itemW, 3";
_pnlcontent.AddView((android.view.View)(_lblversion.getObject()),__c.DipToCurrent((int) (16)),_y,_itemw,__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 156;BA.debugLine="y = y + 35dip";
_y = (int) (_y+__c.DipToCurrent((int) (35)));
 //BA.debugLineNum = 159;BA.debugLine="Dim lblSlogan As Label";
_lblslogan = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 160;BA.debugLine="lblSlogan.Initialize(\"\")";
_lblslogan.Initialize(ba,"");
 //BA.debugLineNum = 161;BA.debugLine="lblSlogan.Text = Starter.APP_TAGLINE";
_lblslogan.setText(BA.ObjectToCharSequence(_starter._app_tagline /*String*/ ));
 //BA.debugLineNum = 162;BA.debugLine="lblSlogan.TextSize = 12";
_lblslogan.setTextSize((float) (12));
 //BA.debugLineNum = 163;BA.debugLine="lblSlogan.TextColor = Colors.ARGB(120, 255, 255,";
_lblslogan.setTextColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 164;BA.debugLine="lblSlogan.Gravity = Gravity.CENTER_HORIZONTAL";
_lblslogan.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 165;BA.debugLine="pnlContent.AddView(lblSlogan, 16dip, y, itemW, 25";
_pnlcontent.AddView((android.view.View)(_lblslogan.getObject()),__c.DipToCurrent((int) (16)),_y,_itemw,__c.DipToCurrent((int) (25)));
 //BA.debugLineNum = 166;BA.debugLine="y = y + 40dip";
_y = (int) (_y+__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 168;BA.debugLine="pnlContent.Height = y + 50dip";
_pnlcontent.setHeight((int) (_y+__c.DipToCurrent((int) (50))));
 //BA.debugLineNum = 171;BA.debugLine="CreateDialogOverlay";
_createdialogoverlay();
 //BA.debugLineNum = 172;BA.debugLine="End Sub";
return "";
}
public String  _getpassphrasemodedisplayvalue() throws Exception{
 //BA.debugLineNum = 316;BA.debugLine="Private Sub GetPassphraseModeDisplayValue As Strin";
 //BA.debugLineNum = 317;BA.debugLine="If ModSecurity.GetUseSinglePassphrase Then";
if (_modsecurity._getusesinglepassphrase /*boolean*/ (ba)) { 
 //BA.debugLineNum = 318;BA.debugLine="Return ModLang.T(\"single_passphrase\")";
if (true) return _modlang._t /*String*/ (ba,"single_passphrase");
 }else {
 //BA.debugLineNum = 320;BA.debugLine="Return ModLang.T(\"multi_passphrase\")";
if (true) return _modlang._t /*String*/ (ba,"multi_passphrase");
 };
 //BA.debugLineNum = 322;BA.debugLine="End Sub";
return "";
}
public String  _gettimerdisplayvalue() throws Exception{
int _secs = 0;
int _mins = 0;
 //BA.debugLineNum = 310;BA.debugLine="Private Sub GetTimerDisplayValue As String";
 //BA.debugLineNum = 311;BA.debugLine="Dim secs As Int = ModSecurity.GetSessionTimeout";
_secs = _modsecurity._getsessiontimeout /*int*/ (ba);
 //BA.debugLineNum = 312;BA.debugLine="Dim mins As Int = secs / 60";
_mins = (int) (_secs/(double)60);
 //BA.debugLineNum = 313;BA.debugLine="Return mins & \" min\"";
if (true) return BA.NumberToString(_mins)+" min";
 //BA.debugLineNum = 314;BA.debugLine="End Sub";
return "";
}
public String  _hidedialog() throws Exception{
anywheresoftware.b4a.objects.IME _ime = null;
 //BA.debugLineNum = 336;BA.debugLine="Private Sub HideDialog";
 //BA.debugLineNum = 337;BA.debugLine="pnlOverlay.Visible = False";
_pnloverlay.setVisible(__c.False);
 //BA.debugLineNum = 338;BA.debugLine="Dim ime As IME";
_ime = new anywheresoftware.b4a.objects.IME();
 //BA.debugLineNum = 339;BA.debugLine="ime.Initialize(\"\")";
_ime.Initialize("");
 //BA.debugLineNum = 340;BA.debugLine="ime.HideKeyboard";
_ime.HideKeyboard(ba);
 //BA.debugLineNum = 341;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 27;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return "";
}
public String  _itemlanguage_click() throws Exception{
 //BA.debugLineNum = 344;BA.debugLine="Private Sub itemLanguage_Click";
 //BA.debugLineNum = 345;BA.debugLine="ShowLanguageDialog";
_showlanguagedialog();
 //BA.debugLineNum = 346;BA.debugLine="End Sub";
return "";
}
public String  _itempassphrasemode_click() throws Exception{
 //BA.debugLineNum = 495;BA.debugLine="Private Sub itemPassphraseMode_Click";
 //BA.debugLineNum = 496;BA.debugLine="ShowPassphraseModeDialog";
_showpassphrasemodedialog();
 //BA.debugLineNum = 497;BA.debugLine="End Sub";
return "";
}
public String  _itemtimer_click() throws Exception{
 //BA.debugLineNum = 419;BA.debugLine="Private Sub itemTimer_Click";
 //BA.debugLineNum = 420;BA.debugLine="ShowTimerDialog";
_showtimerdialog();
 //BA.debugLineNum = 421;BA.debugLine="End Sub";
return "";
}
public String  _pnloverlay_click() throws Exception{
 //BA.debugLineNum = 332;BA.debugLine="Private Sub pnlOverlay_Click";
 //BA.debugLineNum = 333;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 334;BA.debugLine="End Sub";
return "";
}
public String  _refreshui() throws Exception{
 //BA.debugLineNum = 410;BA.debugLine="Private Sub RefreshUI";
 //BA.debugLineNum = 411;BA.debugLine="Root.RemoveAllViews";
_root.RemoveAllViews();
 //BA.debugLineNum = 412;BA.debugLine="CreateUI";
_createui();
 //BA.debugLineNum = 413;BA.debugLine="ApplyTheme";
_applytheme();
 //BA.debugLineNum = 414;BA.debugLine="UpdateDisplayValues";
_updatedisplayvalues();
 //BA.debugLineNum = 415;BA.debugLine="CallSub2(Main, \"SetPageTitle\", ModLang.T(\"setting";
__c.CallSubNew2(ba,(Object)(_main.getObject()),"SetPageTitle",(Object)(_modlang._t /*String*/ (ba,"settings")));
 //BA.debugLineNum = 416;BA.debugLine="End Sub";
return "";
}
public String  _showcreatepindialog() throws Exception{
 //BA.debugLineNum = 586;BA.debugLine="Private Sub ShowCreatePINDialog";
 //BA.debugLineNum = 588;BA.debugLine="ShowPINInputDialog(\"create\")";
_showpininputdialog("create");
 //BA.debugLineNum = 589;BA.debugLine="End Sub";
return "";
}
public String  _showlanguagedialog() throws Exception{
int _dialogw = 0;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
anywheresoftware.b4a.objects.ButtonWrapper _btnpt = null;
anywheresoftware.b4a.objects.ButtonWrapper _btnen = null;
anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
 //BA.debugLineNum = 348;BA.debugLine="Private Sub ShowLanguageDialog";
 //BA.debugLineNum = 349;BA.debugLine="Dim dialogW As Int = Root.Width - 40dip";
_dialogw = (int) (_root.getWidth()-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 350;BA.debugLine="pnlDialog.RemoveAllViews";
_pnldialog.RemoveAllViews();
 //BA.debugLineNum = 353;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 354;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 355;BA.debugLine="lblTitle.Text = ModLang.T(\"language\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"language")));
 //BA.debugLineNum = 356;BA.debugLine="lblTitle.TextSize = 16";
_lbltitle.setTextSize((float) (16));
 //BA.debugLineNum = 357;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 358;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 359;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 360;BA.debugLine="pnlDialog.AddView(lblTitle, 0, 16dip, dialogW, 30";
_pnldialog.AddView((android.view.View)(_lbltitle.getObject()),(int) (0),__c.DipToCurrent((int) (16)),_dialogw,__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 363;BA.debugLine="Dim btnPT As Button";
_btnpt = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 364;BA.debugLine="btnPT.Initialize(\"btnLangPT\")";
_btnpt.Initialize(ba,"btnLangPT");
 //BA.debugLineNum = 365;BA.debugLine="btnPT.Text = \"Portugues\"";
_btnpt.setText(BA.ObjectToCharSequence("Portugues"));
 //BA.debugLineNum = 366;BA.debugLine="btnPT.TextSize = 14";
_btnpt.setTextSize((float) (14));
 //BA.debugLineNum = 367;BA.debugLine="btnPT.Color = ModTheme.HomeIconBg";
_btnpt.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 368;BA.debugLine="btnPT.TextColor = Colors.White";
_btnpt.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 369;BA.debugLine="pnlDialog.AddView(btnPT, 20dip, 60dip, dialogW -";
_pnldialog.AddView((android.view.View)(_btnpt.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (60)),(int) (_dialogw-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (48)));
 //BA.debugLineNum = 371;BA.debugLine="Dim btnEN As Button";
_btnen = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 372;BA.debugLine="btnEN.Initialize(\"btnLangEN\")";
_btnen.Initialize(ba,"btnLangEN");
 //BA.debugLineNum = 373;BA.debugLine="btnEN.Text = \"English\"";
_btnen.setText(BA.ObjectToCharSequence("English"));
 //BA.debugLineNum = 374;BA.debugLine="btnEN.TextSize = 14";
_btnen.setTextSize((float) (14));
 //BA.debugLineNum = 375;BA.debugLine="btnEN.Color = ModTheme.HomeIconBg";
_btnen.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 376;BA.debugLine="btnEN.TextColor = Colors.White";
_btnen.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 377;BA.debugLine="pnlDialog.AddView(btnEN, 20dip, 118dip, dialogW -";
_pnldialog.AddView((android.view.View)(_btnen.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (118)),(int) (_dialogw-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (48)));
 //BA.debugLineNum = 380;BA.debugLine="Dim btnCancel As Button";
_btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 381;BA.debugLine="btnCancel.Initialize(\"btnDialogCancel\")";
_btncancel.Initialize(ba,"btnDialogCancel");
 //BA.debugLineNum = 382;BA.debugLine="btnCancel.Text = ModLang.T(\"cancel\")";
_btncancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 383;BA.debugLine="btnCancel.TextSize = 13";
_btncancel.setTextSize((float) (13));
 //BA.debugLineNum = 384;BA.debugLine="btnCancel.Color = Colors.Transparent";
_btncancel.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 385;BA.debugLine="btnCancel.TextColor = Colors.ARGB(180, 255, 255,";
_btncancel.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 386;BA.debugLine="pnlDialog.AddView(btnCancel, 20dip, 180dip, dialo";
_pnldialog.AddView((android.view.View)(_btncancel.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (180)),(int) (_dialogw-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 388;BA.debugLine="pnlDialog.SetLayoutAnimated(0, 20dip, 100dip, dia";
_pnldialog.SetLayoutAnimated((int) (0),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (100)),_dialogw,__c.DipToCurrent((int) (230)));
 //BA.debugLineNum = 389;BA.debugLine="pnlOverlay.Visible = True";
_pnloverlay.setVisible(__c.True);
 //BA.debugLineNum = 390;BA.debugLine="pnlOverlay.BringToFront";
_pnloverlay.BringToFront();
 //BA.debugLineNum = 391;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 499;BA.debugLine="Private Sub ShowPassphraseModeDialog";
 //BA.debugLineNum = 500;BA.debugLine="Dim dialogW As Int = Root.Width - 40dip";
_dialogw = (int) (_root.getWidth()-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 501;BA.debugLine="pnlDialog.RemoveAllViews";
_pnldialog.RemoveAllViews();
 //BA.debugLineNum = 504;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 505;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 506;BA.debugLine="lblTitle.Text = ModLang.T(\"passphrase_mode\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"passphrase_mode")));
 //BA.debugLineNum = 507;BA.debugLine="lblTitle.TextSize = 16";
_lbltitle.setTextSize((float) (16));
 //BA.debugLineNum = 508;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 509;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 510;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 511;BA.debugLine="pnlDialog.AddView(lblTitle, 0, 16dip, dialogW, 30";
_pnldialog.AddView((android.view.View)(_lbltitle.getObject()),(int) (0),__c.DipToCurrent((int) (16)),_dialogw,__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 514;BA.debugLine="Dim btn1 As Button";
_btn1 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 515;BA.debugLine="btn1.Initialize(\"btnModeSingle\")";
_btn1.Initialize(ba,"btnModeSingle");
 //BA.debugLineNum = 516;BA.debugLine="btn1.Text = ModLang.T(\"single_passphrase\")";
_btn1.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"single_passphrase")));
 //BA.debugLineNum = 517;BA.debugLine="btn1.TextSize = 14";
_btn1.setTextSize((float) (14));
 //BA.debugLineNum = 518;BA.debugLine="btn1.Color = ModTheme.HomeIconBg";
_btn1.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 519;BA.debugLine="btn1.TextColor = Colors.White";
_btn1.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 520;BA.debugLine="pnlDialog.AddView(btn1, 20dip, 55dip, dialogW - 4";
_pnldialog.AddView((android.view.View)(_btn1.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (55)),(int) (_dialogw-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 522;BA.debugLine="Dim lbl1 As Label";
_lbl1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 523;BA.debugLine="lbl1.Initialize(\"\")";
_lbl1.Initialize(ba,"");
 //BA.debugLineNum = 524;BA.debugLine="lbl1.Text = ModLang.T(\"single_passphrase_desc\")";
_lbl1.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"single_passphrase_desc")));
 //BA.debugLineNum = 525;BA.debugLine="lbl1.TextSize = 11";
_lbl1.setTextSize((float) (11));
 //BA.debugLineNum = 526;BA.debugLine="lbl1.TextColor = Colors.ARGB(150, 255, 255, 255)";
_lbl1.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 527;BA.debugLine="pnlDialog.AddView(lbl1, 20dip, 100dip, dialogW -";
_pnldialog.AddView((android.view.View)(_lbl1.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (100)),(int) (_dialogw-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 530;BA.debugLine="Dim btn2 As Button";
_btn2 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 531;BA.debugLine="btn2.Initialize(\"btnModeMulti\")";
_btn2.Initialize(ba,"btnModeMulti");
 //BA.debugLineNum = 532;BA.debugLine="btn2.Text = ModLang.T(\"multi_passphrase\")";
_btn2.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"multi_passphrase")));
 //BA.debugLineNum = 533;BA.debugLine="btn2.TextSize = 14";
_btn2.setTextSize((float) (14));
 //BA.debugLineNum = 534;BA.debugLine="btn2.Color = ModTheme.HomeIconBg";
_btn2.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 535;BA.debugLine="btn2.TextColor = Colors.White";
_btn2.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 536;BA.debugLine="pnlDialog.AddView(btn2, 20dip, 130dip, dialogW -";
_pnldialog.AddView((android.view.View)(_btn2.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (130)),(int) (_dialogw-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 538;BA.debugLine="Dim lbl2 As Label";
_lbl2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 539;BA.debugLine="lbl2.Initialize(\"\")";
_lbl2.Initialize(ba,"");
 //BA.debugLineNum = 540;BA.debugLine="lbl2.Text = ModLang.T(\"multi_passphrase_desc\")";
_lbl2.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"multi_passphrase_desc")));
 //BA.debugLineNum = 541;BA.debugLine="lbl2.TextSize = 11";
_lbl2.setTextSize((float) (11));
 //BA.debugLineNum = 542;BA.debugLine="lbl2.TextColor = Colors.ARGB(150, 255, 255, 255)";
_lbl2.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 543;BA.debugLine="pnlDialog.AddView(lbl2, 20dip, 175dip, dialogW -";
_pnldialog.AddView((android.view.View)(_lbl2.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (175)),(int) (_dialogw-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 546;BA.debugLine="Dim btnCancel As Button";
_btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 547;BA.debugLine="btnCancel.Initialize(\"btnDialogCancel\")";
_btncancel.Initialize(ba,"btnDialogCancel");
 //BA.debugLineNum = 548;BA.debugLine="btnCancel.Text = ModLang.T(\"cancel\")";
_btncancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 549;BA.debugLine="btnCancel.TextSize = 13";
_btncancel.setTextSize((float) (13));
 //BA.debugLineNum = 550;BA.debugLine="btnCancel.Color = Colors.Transparent";
_btncancel.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 551;BA.debugLine="btnCancel.TextColor = Colors.ARGB(180, 255, 255,";
_btncancel.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 552;BA.debugLine="pnlDialog.AddView(btnCancel, 20dip, 205dip, dialo";
_pnldialog.AddView((android.view.View)(_btncancel.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (205)),(int) (_dialogw-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 554;BA.debugLine="pnlDialog.SetLayoutAnimated(0, 20dip, 100dip, dia";
_pnldialog.SetLayoutAnimated((int) (0),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (100)),_dialogw,__c.DipToCurrent((int) (255)));
 //BA.debugLineNum = 555;BA.debugLine="pnlOverlay.Visible = True";
_pnloverlay.setVisible(__c.True);
 //BA.debugLineNum = 556;BA.debugLine="pnlOverlay.BringToFront";
_pnloverlay.BringToFront();
 //BA.debugLineNum = 557;BA.debugLine="End Sub";
return "";
}
public String  _showpininputdialog(String _mode) throws Exception{
int _dialogw = 0;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
anywheresoftware.b4a.objects.LabelWrapper _lblsub = null;
anywheresoftware.b4a.objects.EditTextWrapper _edtpin = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xvpin = null;
anywheresoftware.b4a.objects.ButtonWrapper _btnok = null;
anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
 //BA.debugLineNum = 592;BA.debugLine="Private Sub ShowPINInputDialog(mode As String)";
 //BA.debugLineNum = 593;BA.debugLine="Dim dialogW As Int = Root.Width - 40dip";
_dialogw = (int) (_root.getWidth()-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 594;BA.debugLine="pnlDialog.RemoveAllViews";
_pnldialog.RemoveAllViews();
 //BA.debugLineNum = 595;BA.debugLine="pnlDialog.Tag = mode 'Guarda o modo: \"create\", \"c";
_pnldialog.setTag((Object)(_mode));
 //BA.debugLineNum = 598;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 599;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 600;BA.debugLine="If mode = \"create\" Then";
if ((_mode).equals("create")) { 
 //BA.debugLineNum = 601;BA.debugLine="lblTitle.Text = ModLang.T(\"pin_create\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"pin_create")));
 }else if((_mode).equals("confirm")) { 
 //BA.debugLineNum = 603;BA.debugLine="lblTitle.Text = ModLang.T(\"pin_confirm\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"pin_confirm")));
 }else {
 //BA.debugLineNum = 605;BA.debugLine="lblTitle.Text = ModLang.T(\"pin_enter\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"pin_enter")));
 };
 //BA.debugLineNum = 607;BA.debugLine="lblTitle.TextSize = 16";
_lbltitle.setTextSize((float) (16));
 //BA.debugLineNum = 608;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 609;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 610;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 611;BA.debugLine="pnlDialog.AddView(lblTitle, 0, 16dip, dialogW, 30";
_pnldialog.AddView((android.view.View)(_lbltitle.getObject()),(int) (0),__c.DipToCurrent((int) (16)),_dialogw,__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 614;BA.debugLine="Dim lblSub As Label";
_lblsub = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 615;BA.debugLine="lblSub.Initialize(\"\")";
_lblsub.Initialize(ba,"");
 //BA.debugLineNum = 616;BA.debugLine="lblSub.Text = ModLang.T(\"pin_digits\")";
_lblsub.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"pin_digits")));
 //BA.debugLineNum = 617;BA.debugLine="lblSub.TextSize = 12";
_lblsub.setTextSize((float) (12));
 //BA.debugLineNum = 618;BA.debugLine="lblSub.TextColor = Colors.ARGB(150, 255, 255, 255";
_lblsub.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 619;BA.debugLine="lblSub.Gravity = Gravity.CENTER_HORIZONTAL";
_lblsub.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 620;BA.debugLine="pnlDialog.AddView(lblSub, 0, 46dip, dialogW, 20di";
_pnldialog.AddView((android.view.View)(_lblsub.getObject()),(int) (0),__c.DipToCurrent((int) (46)),_dialogw,__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 623;BA.debugLine="Dim edtPIN As EditText";
_edtpin = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 624;BA.debugLine="edtPIN.Initialize(\"edtPIN\")";
_edtpin.Initialize(ba,"edtPIN");
 //BA.debugLineNum = 625;BA.debugLine="edtPIN.Hint = \"PIN\"";
_edtpin.setHint("PIN");
 //BA.debugLineNum = 626;BA.debugLine="edtPIN.InputType = Bit.Or(2, 8192) 'NUMBER + PASS";
_edtpin.setInputType(__c.Bit.Or((int) (2),(int) (8192)));
 //BA.debugLineNum = 627;BA.debugLine="edtPIN.TextSize = 24";
_edtpin.setTextSize((float) (24));
 //BA.debugLineNum = 628;BA.debugLine="edtPIN.TextColor = Colors.White";
_edtpin.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 629;BA.debugLine="edtPIN.HintColor = Colors.ARGB(100, 255, 255, 255";
_edtpin.setHintColor(__c.Colors.ARGB((int) (100),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 630;BA.debugLine="edtPIN.Gravity = Gravity.CENTER";
_edtpin.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 631;BA.debugLine="Dim xvPIN As B4XView = edtPIN";
_xvpin = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvpin = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_edtpin.getObject()));
 //BA.debugLineNum = 632;BA.debugLine="xvPIN.SetColorAndBorder(Colors.ARGB(40, 255, 255,";
_xvpin.SetColorAndBorder(__c.Colors.ARGB((int) (40),(int) (255),(int) (255),(int) (255)),__c.DipToCurrent((int) (1)),__c.Colors.ARGB((int) (80),(int) (255),(int) (255),(int) (255)),__c.DipToCurrent((int) (8)));
 //BA.debugLineNum = 633;BA.debugLine="pnlDialog.AddView(edtPIN, dialogW/2 - 80dip, 75di";
_pnldialog.AddView((android.view.View)(_edtpin.getObject()),(int) (_dialogw/(double)2-__c.DipToCurrent((int) (80))),__c.DipToCurrent((int) (75)),__c.DipToCurrent((int) (160)),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 636;BA.debugLine="Dim btnOK As Button";
_btnok = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 637;BA.debugLine="btnOK.Initialize(\"btnPINOK\")";
_btnok.Initialize(ba,"btnPINOK");
 //BA.debugLineNum = 638;BA.debugLine="btnOK.Text = ModLang.T(\"ok\")";
_btnok.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"ok")));
 //BA.debugLineNum = 639;BA.debugLine="btnOK.TextSize = 14";
_btnok.setTextSize((float) (14));
 //BA.debugLineNum = 640;BA.debugLine="btnOK.Color = ModTheme.HomeIconBg";
_btnok.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 641;BA.debugLine="btnOK.TextColor = Colors.White";
_btnok.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 642;BA.debugLine="pnlDialog.AddView(btnOK, 20dip, 145dip, (dialogW";
_pnldialog.AddView((android.view.View)(_btnok.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (145)),(int) ((_dialogw-__c.DipToCurrent((int) (50)))/(double)2),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 645;BA.debugLine="Dim btnCancel As Button";
_btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 646;BA.debugLine="btnCancel.Initialize(\"btnPINCancel\")";
_btncancel.Initialize(ba,"btnPINCancel");
 //BA.debugLineNum = 647;BA.debugLine="btnCancel.Text = ModLang.T(\"cancel\")";
_btncancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 648;BA.debugLine="btnCancel.TextSize = 14";
_btncancel.setTextSize((float) (14));
 //BA.debugLineNum = 649;BA.debugLine="btnCancel.Color = Colors.Transparent";
_btncancel.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 650;BA.debugLine="btnCancel.TextColor = Colors.ARGB(180, 255, 255,";
_btncancel.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 651;BA.debugLine="pnlDialog.AddView(btnCancel, dialogW/2 + 5dip, 14";
_pnldialog.AddView((android.view.View)(_btncancel.getObject()),(int) (_dialogw/(double)2+__c.DipToCurrent((int) (5))),__c.DipToCurrent((int) (145)),(int) ((_dialogw-__c.DipToCurrent((int) (50)))/(double)2),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 653;BA.debugLine="pnlDialog.SetLayoutAnimated(0, 20dip, 150dip, dia";
_pnldialog.SetLayoutAnimated((int) (0),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (150)),_dialogw,__c.DipToCurrent((int) (210)));
 //BA.debugLineNum = 654;BA.debugLine="pnlOverlay.Visible = True";
_pnloverlay.setVisible(__c.True);
 //BA.debugLineNum = 655;BA.debugLine="pnlOverlay.BringToFront";
_pnloverlay.BringToFront();
 //BA.debugLineNum = 656;BA.debugLine="End Sub";
return "";
}
public String  _showremovepindialog() throws Exception{
 //BA.debugLineNum = 721;BA.debugLine="Private Sub ShowRemovePINDialog";
 //BA.debugLineNum = 722;BA.debugLine="If ModSecurity.HasPIN = False Then Return";
if (_modsecurity._haspin /*boolean*/ (ba)==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 724;BA.debugLine="ShowPINInputDialog(\"remove\")";
_showpininputdialog("remove");
 //BA.debugLineNum = 725;BA.debugLine="End Sub";
return "";
}
public String  _showtimerdialog() throws Exception{
int _dialogw = 0;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
anywheresoftware.b4a.objects.ButtonWrapper _btn1 = null;
anywheresoftware.b4a.objects.ButtonWrapper _btn2 = null;
anywheresoftware.b4a.objects.ButtonWrapper _btn3 = null;
anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
 //BA.debugLineNum = 423;BA.debugLine="Private Sub ShowTimerDialog";
 //BA.debugLineNum = 424;BA.debugLine="Dim dialogW As Int = Root.Width - 40dip";
_dialogw = (int) (_root.getWidth()-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 425;BA.debugLine="pnlDialog.RemoveAllViews";
_pnldialog.RemoveAllViews();
 //BA.debugLineNum = 428;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 429;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 430;BA.debugLine="lblTitle.Text = ModLang.T(\"session_timeout\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"session_timeout")));
 //BA.debugLineNum = 431;BA.debugLine="lblTitle.TextSize = 16";
_lbltitle.setTextSize((float) (16));
 //BA.debugLineNum = 432;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 433;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 434;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 435;BA.debugLine="pnlDialog.AddView(lblTitle, 0, 16dip, dialogW, 30";
_pnldialog.AddView((android.view.View)(_lbltitle.getObject()),(int) (0),__c.DipToCurrent((int) (16)),_dialogw,__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 438;BA.debugLine="Dim btn1 As Button";
_btn1 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 439;BA.debugLine="btn1.Initialize(\"btnTimer1\")";
_btn1.Initialize(ba,"btnTimer1");
 //BA.debugLineNum = 440;BA.debugLine="btn1.Text = \"1 \" & ModLang.T(\"minute\")";
_btn1.setText(BA.ObjectToCharSequence("1 "+_modlang._t /*String*/ (ba,"minute")));
 //BA.debugLineNum = 441;BA.debugLine="btn1.TextSize = 14";
_btn1.setTextSize((float) (14));
 //BA.debugLineNum = 442;BA.debugLine="btn1.Color = ModTheme.HomeIconBg";
_btn1.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 443;BA.debugLine="btn1.TextColor = Colors.White";
_btn1.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 444;BA.debugLine="pnlDialog.AddView(btn1, 20dip, 60dip, dialogW - 4";
_pnldialog.AddView((android.view.View)(_btn1.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (60)),(int) (_dialogw-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 446;BA.debugLine="Dim btn2 As Button";
_btn2 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 447;BA.debugLine="btn2.Initialize(\"btnTimer2\")";
_btn2.Initialize(ba,"btnTimer2");
 //BA.debugLineNum = 448;BA.debugLine="btn2.Text = \"2 \" & ModLang.T(\"minutes\")";
_btn2.setText(BA.ObjectToCharSequence("2 "+_modlang._t /*String*/ (ba,"minutes")));
 //BA.debugLineNum = 449;BA.debugLine="btn2.TextSize = 14";
_btn2.setTextSize((float) (14));
 //BA.debugLineNum = 450;BA.debugLine="btn2.Color = ModTheme.HomeIconBg";
_btn2.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 451;BA.debugLine="btn2.TextColor = Colors.White";
_btn2.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 452;BA.debugLine="pnlDialog.AddView(btn2, 20dip, 112dip, dialogW -";
_pnldialog.AddView((android.view.View)(_btn2.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (112)),(int) (_dialogw-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 454;BA.debugLine="Dim btn3 As Button";
_btn3 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 455;BA.debugLine="btn3.Initialize(\"btnTimer3\")";
_btn3.Initialize(ba,"btnTimer3");
 //BA.debugLineNum = 456;BA.debugLine="btn3.Text = \"3 \" & ModLang.T(\"minutes\")";
_btn3.setText(BA.ObjectToCharSequence("3 "+_modlang._t /*String*/ (ba,"minutes")));
 //BA.debugLineNum = 457;BA.debugLine="btn3.TextSize = 14";
_btn3.setTextSize((float) (14));
 //BA.debugLineNum = 458;BA.debugLine="btn3.Color = ModTheme.HomeIconBg";
_btn3.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 459;BA.debugLine="btn3.TextColor = Colors.White";
_btn3.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 460;BA.debugLine="pnlDialog.AddView(btn3, 20dip, 164dip, dialogW -";
_pnldialog.AddView((android.view.View)(_btn3.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (164)),(int) (_dialogw-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 463;BA.debugLine="Dim btnCancel As Button";
_btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 464;BA.debugLine="btnCancel.Initialize(\"btnDialogCancel\")";
_btncancel.Initialize(ba,"btnDialogCancel");
 //BA.debugLineNum = 465;BA.debugLine="btnCancel.Text = ModLang.T(\"cancel\")";
_btncancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 466;BA.debugLine="btnCancel.TextSize = 13";
_btncancel.setTextSize((float) (13));
 //BA.debugLineNum = 467;BA.debugLine="btnCancel.Color = Colors.Transparent";
_btncancel.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 468;BA.debugLine="btnCancel.TextColor = Colors.ARGB(180, 255, 255,";
_btncancel.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 469;BA.debugLine="pnlDialog.AddView(btnCancel, 20dip, 220dip, dialo";
_pnldialog.AddView((android.view.View)(_btncancel.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (220)),(int) (_dialogw-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 471;BA.debugLine="pnlDialog.SetLayoutAnimated(0, 20dip, 100dip, dia";
_pnldialog.SetLayoutAnimated((int) (0),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (100)),_dialogw,__c.DipToCurrent((int) (270)));
 //BA.debugLineNum = 472;BA.debugLine="pnlOverlay.Visible = True";
_pnloverlay.setVisible(__c.True);
 //BA.debugLineNum = 473;BA.debugLine="pnlOverlay.BringToFront";
_pnloverlay.BringToFront();
 //BA.debugLineNum = 474;BA.debugLine="End Sub";
return "";
}
public String  _updatedisplayvalues() throws Exception{
 //BA.debugLineNum = 302;BA.debugLine="Private Sub UpdateDisplayValues";
 //BA.debugLineNum = 303;BA.debugLine="lblLanguageValue.Text = ModLang.GetLanguageName";
_lbllanguagevalue.setText(BA.ObjectToCharSequence(_modlang._getlanguagename /*String*/ (ba)));
 //BA.debugLineNum = 304;BA.debugLine="lblTimerValue.Text = GetTimerDisplayValue";
_lbltimervalue.setText(BA.ObjectToCharSequence(_gettimerdisplayvalue()));
 //BA.debugLineNum = 305;BA.debugLine="lblPassphraseModeValue.Text = GetPassphraseModeDi";
_lblpassphrasemodevalue.setText(BA.ObjectToCharSequence(_getpassphrasemodedisplayvalue()));
 //BA.debugLineNum = 306;BA.debugLine="chkPIN.Checked = ModSecurity.HasPIN";
_chkpin.setChecked(_modsecurity._haspin /*boolean*/ (ba));
 //BA.debugLineNum = 307;BA.debugLine="chkBiometric.Checked = ModSecurity.GetUseBiometri";
_chkbiometric.setChecked(_modsecurity._getusebiometric /*boolean*/ (ba));
 //BA.debugLineNum = 308;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
