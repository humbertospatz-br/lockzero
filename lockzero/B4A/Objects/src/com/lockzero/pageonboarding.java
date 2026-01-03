package com.lockzero;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class pageonboarding extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.lockzero.pageonboarding");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.lockzero.pageonboarding.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _pnllanguage = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _pnlwelcome = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _pnlwarning = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _pnlcomplete = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _optlangpt = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _optlangen = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _optlanges = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _optlanghe = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnlangnext = null;
public String _selectedlang = "";
public anywheresoftware.b4a.objects.LabelWrapper _lblwelcometitle = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblwelcometext = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnwelcomenext = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblwarningtitle = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblwarningtext = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chkunderstand = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnwarningnext = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblcompletetitle = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblcompletetext = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnstart = null;
public int _currentstep = 0;
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
 //BA.debugLineNum = 324;BA.debugLine="Private Sub ApplyTheme";
 //BA.debugLineNum = 325;BA.debugLine="Root.Color = ModTheme.HomeBg";
_root.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 328;BA.debugLine="pnlLanguage.Color = ModTheme.HomeBg";
_pnllanguage.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 329;BA.debugLine="optLangPT.TextColor = Colors.White";
_optlangpt.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 330;BA.debugLine="optLangEN.TextColor = Colors.White";
_optlangen.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 331;BA.debugLine="optLangES.TextColor = Colors.White";
_optlanges.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 332;BA.debugLine="optLangHE.TextColor = Colors.White";
_optlanghe.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 333;BA.debugLine="btnLangNext.Color = ModTheme.HomeIconBg";
_btnlangnext.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 334;BA.debugLine="btnLangNext.TextColor = Colors.White";
_btnlangnext.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 337;BA.debugLine="pnlWelcome.Color = ModTheme.HomeBg";
_pnlwelcome.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 338;BA.debugLine="lblWelcomeTitle.TextColor = Colors.White";
_lblwelcometitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 339;BA.debugLine="lblWelcomeText.TextColor = Colors.ARGB(200, 255,";
_lblwelcometext.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 340;BA.debugLine="btnWelcomeNext.Color = ModTheme.HomeIconBg";
_btnwelcomenext.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 341;BA.debugLine="btnWelcomeNext.TextColor = Colors.White";
_btnwelcomenext.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 344;BA.debugLine="pnlWarning.Color = ModTheme.HomeBg";
_pnlwarning.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 345;BA.debugLine="lblWarningTitle.TextColor = Colors.RGB(255, 200,";
_lblwarningtitle.setTextColor(__c.Colors.RGB((int) (255),(int) (200),(int) (100)));
 //BA.debugLineNum = 346;BA.debugLine="lblWarningText.TextColor = Colors.ARGB(200, 255,";
_lblwarningtext.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 347;BA.debugLine="chkUnderstand.TextColor = Colors.White";
_chkunderstand.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 348;BA.debugLine="btnWarningNext.Color = ModTheme.HomeHeaderBg";
_btnwarningnext.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 349;BA.debugLine="btnWarningNext.TextColor = Colors.White";
_btnwarningnext.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 352;BA.debugLine="pnlComplete.Color = ModTheme.HomeBg";
_pnlcomplete.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 353;BA.debugLine="lblCompleteTitle.TextColor = Colors.RGB(100, 200,";
_lblcompletetitle.setTextColor(__c.Colors.RGB((int) (100),(int) (200),(int) (150)));
 //BA.debugLineNum = 354;BA.debugLine="lblCompleteText.TextColor = Colors.ARGB(200, 255,";
_lblcompletetext.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 355;BA.debugLine="btnStart.Color = ModTheme.HomeIconBg";
_btnstart.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 356;BA.debugLine="btnStart.TextColor = Colors.White";
_btnstart.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 357;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_appear() throws Exception{
 //BA.debugLineNum = 60;BA.debugLine="Private Sub B4XPage_Appear";
 //BA.debugLineNum = 62;BA.debugLine="ModTransition.FadeIn(Root)";
_modtransition._fadein /*String*/ (ba,_root);
 //BA.debugLineNum = 65;BA.debugLine="CallSub2(Main, \"SetPageTitle\", \"LockZero\")";
__c.CallSubNew2(ba,(Object)(_main.getObject()),"SetPageTitle",(Object)("LockZero"));
 //BA.debugLineNum = 66;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _b4xpage_closerequest() throws Exception{
ResumableSub_B4XPage_CloseRequest rsub = new ResumableSub_B4XPage_CloseRequest(this);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_B4XPage_CloseRequest extends BA.ResumableSub {
public ResumableSub_B4XPage_CloseRequest(com.lockzero.pageonboarding parent) {
this.parent = parent;
}
com.lockzero.pageonboarding parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
 //BA.debugLineNum = 365;BA.debugLine="If CurrentStep < 3 Then";
if (true) break;

case 1:
//if
this.state = 4;
if (parent._currentstep<3) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 366;BA.debugLine="ToastMessageShow(ModLang.T(\"onb_complete_setup\")";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"onb_complete_setup")),parent.__c.True);
 //BA.debugLineNum = 367;BA.debugLine="Return False";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.False));return;};
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 369;BA.debugLine="Return True";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.True));return;};
 //BA.debugLineNum = 370;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
 //BA.debugLineNum = 47;BA.debugLine="Private Sub B4XPage_Created(Root1 As B4XView)";
 //BA.debugLineNum = 48;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 49;BA.debugLine="CreateUI";
_createui();
 //BA.debugLineNum = 50;BA.debugLine="ApplyTheme";
_applytheme();
 //BA.debugLineNum = 53;BA.debugLine="If ModSecurity.IsLanguageChosen Then";
if (_modsecurity._islanguagechosen /*boolean*/ (ba)) { 
 //BA.debugLineNum = 54;BA.debugLine="ShowStep(1)";
_showstep((int) (1));
 }else {
 //BA.debugLineNum = 56;BA.debugLine="ShowStep(0)";
_showstep((int) (0));
 };
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public String  _btnlangnext_click() throws Exception{
 //BA.debugLineNum = 218;BA.debugLine="Private Sub btnLangNext_Click";
 //BA.debugLineNum = 220;BA.debugLine="ModLang.SetLanguage(SelectedLang)";
_modlang._setlanguage /*String*/ (ba,_selectedlang);
 //BA.debugLineNum = 221;BA.debugLine="ModSecurity.SaveLanguage(SelectedLang)";
_modsecurity._savelanguage /*String*/ (ba,_selectedlang);
 //BA.debugLineNum = 224;BA.debugLine="ModSecurity.SetLanguageChosen";
_modsecurity._setlanguagechosen /*String*/ (ba);
 //BA.debugLineNum = 227;BA.debugLine="RefreshWelcomeTexts";
_refreshwelcometexts();
 //BA.debugLineNum = 230;BA.debugLine="ShowStep(1)";
_showstep((int) (1));
 //BA.debugLineNum = 231;BA.debugLine="End Sub";
return "";
}
public String  _btnstart_click() throws Exception{
 //BA.debugLineNum = 311;BA.debugLine="Private Sub btnStart_Click";
 //BA.debugLineNum = 313;BA.debugLine="ModSecurity.SetSetting(\"onboarding_complete\", \"tr";
_modsecurity._setsetting /*String*/ (ba,"onboarding_complete",(Object)("true"));
 //BA.debugLineNum = 317;BA.debugLine="B4XPages.ShowPageAndRemovePreviousPages(\"mainpage";
_b4xpages._showpageandremovepreviouspages /*String*/ (ba,"mainpage");
 //BA.debugLineNum = 318;BA.debugLine="End Sub";
return "";
}
public String  _btnwarningnext_click() throws Exception{
 //BA.debugLineNum = 297;BA.debugLine="Private Sub btnWarningNext_Click";
 //BA.debugLineNum = 298;BA.debugLine="If chkUnderstand.Checked = False Then";
if (_chkunderstand.getChecked()==__c.False) { 
 //BA.debugLineNum = 299;BA.debugLine="ToastMessageShow(ModLang.T(\"onb_must_accept\"), T";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"onb_must_accept")),__c.True);
 //BA.debugLineNum = 300;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 304;BA.debugLine="ShowStep(3)";
_showstep((int) (3));
 //BA.debugLineNum = 305;BA.debugLine="End Sub";
return "";
}
public String  _btnwelcomenext_click() throws Exception{
 //BA.debugLineNum = 284;BA.debugLine="Private Sub btnWelcomeNext_Click";
 //BA.debugLineNum = 285;BA.debugLine="ShowStep(2)";
_showstep((int) (2));
 //BA.debugLineNum = 286;BA.debugLine="End Sub";
return "";
}
public String  _chkunderstand_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 288;BA.debugLine="Private Sub chkUnderstand_CheckedChange(Checked As";
 //BA.debugLineNum = 289;BA.debugLine="btnWarningNext.Enabled = Checked";
_btnwarningnext.setEnabled(_checked);
 //BA.debugLineNum = 290;BA.debugLine="If Checked Then";
if (_checked) { 
 //BA.debugLineNum = 291;BA.debugLine="btnWarningNext.Color = ModTheme.HomeIconBg";
_btnwarningnext.setColor(_modtheme._homeiconbg /*int*/ (ba));
 }else {
 //BA.debugLineNum = 293;BA.debugLine="btnWarningNext.Color = ModTheme.HomeHeaderBg";
_btnwarningnext.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 };
 //BA.debugLineNum = 295;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 5;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Private Root As B4XView";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 7;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 10;BA.debugLine="Private pnlLanguage As B4XView  'Step 0: Selecao";
_pnllanguage = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 11;BA.debugLine="Private pnlWelcome As B4XView   'Step 1: Welcome";
_pnlwelcome = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 12;BA.debugLine="Private pnlWarning As B4XView   'Step 2: Warning";
_pnlwarning = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Private pnlComplete As B4XView  'Step 3: Complete";
_pnlcomplete = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private optLangPT As RadioButton";
_optlangpt = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private optLangEN As RadioButton";
_optlangen = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private optLangES As RadioButton";
_optlanges = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private optLangHE As RadioButton";
_optlanghe = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private btnLangNext As Button";
_btnlangnext = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private SelectedLang As String = \"pt\"";
_selectedlang = "pt";
 //BA.debugLineNum = 24;BA.debugLine="Private lblWelcomeTitle As Label";
_lblwelcometitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private lblWelcomeText As Label";
_lblwelcometext = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private btnWelcomeNext As Button";
_btnwelcomenext = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private lblWarningTitle As Label";
_lblwarningtitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private lblWarningText As Label";
_lblwarningtext = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private chkUnderstand As CheckBox";
_chkunderstand = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Private btnWarningNext As Button";
_btnwarningnext = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private lblCompleteTitle As Label";
_lblcompletetitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private lblCompleteText As Label";
_lblcompletetext = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private btnStart As Button";
_btnstart = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private CurrentStep As Int = 0";
_currentstep = (int) (0);
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return "";
}
public String  _createui() throws Exception{
int _width = 0;
int _height = 0;
int _margin = 0;
int _contentwidth = 0;
anywheresoftware.b4a.objects.LabelWrapper _lbllangtitle = null;
int _rbtop = 0;
int _rbh = 0;
 //BA.debugLineNum = 72;BA.debugLine="Private Sub CreateUI";
 //BA.debugLineNum = 73;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 74;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 75;BA.debugLine="Dim margin As Int = 24dip";
_margin = __c.DipToCurrent((int) (24));
 //BA.debugLineNum = 76;BA.debugLine="Dim contentWidth As Int = width - (margin * 2)";
_contentwidth = (int) (_width-(_margin*2));
 //BA.debugLineNum = 79;BA.debugLine="pnlLanguage = xui.CreatePanel(\"\")";
_pnllanguage = _xui.CreatePanel(ba,"");
 //BA.debugLineNum = 80;BA.debugLine="Root.AddView(pnlLanguage, 0, 0, width, height)";
_root.AddView((android.view.View)(_pnllanguage.getObject()),(int) (0),(int) (0),_width,_height);
 //BA.debugLineNum = 83;BA.debugLine="Dim lblLangTitle As Label";
_lbllangtitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 84;BA.debugLine="lblLangTitle.Initialize(\"\")";
_lbllangtitle.Initialize(ba,"");
 //BA.debugLineNum = 85;BA.debugLine="lblLangTitle.Text = \"Select Language\" & CRLF & \"S";
_lbllangtitle.setText(BA.ObjectToCharSequence("Select Language"+__c.CRLF+"Selecione o Idioma"));
 //BA.debugLineNum = 86;BA.debugLine="lblLangTitle.TextSize = Starter.FONT_TITLE";
_lbllangtitle.setTextSize(_starter._font_title /*float*/ );
 //BA.debugLineNum = 87;BA.debugLine="lblLangTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbllangtitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 88;BA.debugLine="lblLangTitle.Typeface = Typeface.CreateNew(Typefa";
_lbllangtitle.setTypeface(__c.Typeface.CreateNew(__c.Typeface.DEFAULT,__c.Typeface.STYLE_BOLD));
 //BA.debugLineNum = 89;BA.debugLine="pnlLanguage.AddView(lblLangTitle, margin, 100dip,";
_pnllanguage.AddView((android.view.View)(_lbllangtitle.getObject()),_margin,__c.DipToCurrent((int) (100)),_contentwidth,__c.DipToCurrent((int) (70)));
 //BA.debugLineNum = 92;BA.debugLine="Dim rbTop As Int = 180dip";
_rbtop = __c.DipToCurrent((int) (180));
 //BA.debugLineNum = 93;BA.debugLine="Dim rbH As Int = 48dip";
_rbh = __c.DipToCurrent((int) (48));
 //BA.debugLineNum = 95;BA.debugLine="optLangPT.Initialize(\"optLangPT\")";
_optlangpt.Initialize(ba,"optLangPT");
 //BA.debugLineNum = 96;BA.debugLine="optLangPT.Text = \"Português\"";
_optlangpt.setText(BA.ObjectToCharSequence("Português"));
 //BA.debugLineNum = 97;BA.debugLine="optLangPT.TextSize = Starter.FONT_BODY";
_optlangpt.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 98;BA.debugLine="optLangPT.Checked = True";
_optlangpt.setChecked(__c.True);
 //BA.debugLineNum = 99;BA.debugLine="SelectedLang = \"pt\"";
_selectedlang = "pt";
 //BA.debugLineNum = 100;BA.debugLine="pnlLanguage.AddView(optLangPT, margin + 20dip, rb";
_pnllanguage.AddView((android.view.View)(_optlangpt.getObject()),(int) (_margin+__c.DipToCurrent((int) (20))),_rbtop,(int) (_contentwidth-__c.DipToCurrent((int) (40))),_rbh);
 //BA.debugLineNum = 101;BA.debugLine="rbTop = rbTop + rbH";
_rbtop = (int) (_rbtop+_rbh);
 //BA.debugLineNum = 103;BA.debugLine="optLangEN.Initialize(\"optLangEN\")";
_optlangen.Initialize(ba,"optLangEN");
 //BA.debugLineNum = 104;BA.debugLine="optLangEN.Text = \"English\"";
_optlangen.setText(BA.ObjectToCharSequence("English"));
 //BA.debugLineNum = 105;BA.debugLine="optLangEN.TextSize = Starter.FONT_BODY";
_optlangen.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 106;BA.debugLine="pnlLanguage.AddView(optLangEN, margin + 20dip, rb";
_pnllanguage.AddView((android.view.View)(_optlangen.getObject()),(int) (_margin+__c.DipToCurrent((int) (20))),_rbtop,(int) (_contentwidth-__c.DipToCurrent((int) (40))),_rbh);
 //BA.debugLineNum = 107;BA.debugLine="rbTop = rbTop + rbH";
_rbtop = (int) (_rbtop+_rbh);
 //BA.debugLineNum = 109;BA.debugLine="optLangES.Initialize(\"optLangES\")";
_optlanges.Initialize(ba,"optLangES");
 //BA.debugLineNum = 110;BA.debugLine="optLangES.Text = \"Español\"";
_optlanges.setText(BA.ObjectToCharSequence("Español"));
 //BA.debugLineNum = 111;BA.debugLine="optLangES.TextSize = Starter.FONT_BODY";
_optlanges.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 112;BA.debugLine="pnlLanguage.AddView(optLangES, margin + 20dip, rb";
_pnllanguage.AddView((android.view.View)(_optlanges.getObject()),(int) (_margin+__c.DipToCurrent((int) (20))),_rbtop,(int) (_contentwidth-__c.DipToCurrent((int) (40))),_rbh);
 //BA.debugLineNum = 113;BA.debugLine="rbTop = rbTop + rbH";
_rbtop = (int) (_rbtop+_rbh);
 //BA.debugLineNum = 115;BA.debugLine="optLangHE.Initialize(\"optLangHE\")";
_optlanghe.Initialize(ba,"optLangHE");
 //BA.debugLineNum = 116;BA.debugLine="optLangHE.Text = \"עברית\"";
_optlanghe.setText(BA.ObjectToCharSequence("עברית"));
 //BA.debugLineNum = 117;BA.debugLine="optLangHE.TextSize = Starter.FONT_BODY";
_optlanghe.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 118;BA.debugLine="pnlLanguage.AddView(optLangHE, margin + 20dip, rb";
_pnllanguage.AddView((android.view.View)(_optlanghe.getObject()),(int) (_margin+__c.DipToCurrent((int) (20))),_rbtop,(int) (_contentwidth-__c.DipToCurrent((int) (40))),_rbh);
 //BA.debugLineNum = 121;BA.debugLine="btnLangNext.Initialize(\"btnLangNext\")";
_btnlangnext.Initialize(ba,"btnLangNext");
 //BA.debugLineNum = 122;BA.debugLine="btnLangNext.Text = \"OK\"";
_btnlangnext.setText(BA.ObjectToCharSequence("OK"));
 //BA.debugLineNum = 123;BA.debugLine="btnLangNext.TextSize = Starter.FONT_BUTTON";
_btnlangnext.setTextSize(_starter._font_button /*float*/ );
 //BA.debugLineNum = 124;BA.debugLine="pnlLanguage.AddView(btnLangNext, margin, height -";
_pnllanguage.AddView((android.view.View)(_btnlangnext.getObject()),_margin,(int) (_height-__c.DipToCurrent((int) (100))),_contentwidth,__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 127;BA.debugLine="pnlWelcome = xui.CreatePanel(\"\")";
_pnlwelcome = _xui.CreatePanel(ba,"");
 //BA.debugLineNum = 128;BA.debugLine="pnlWelcome.Visible = False";
_pnlwelcome.setVisible(__c.False);
 //BA.debugLineNum = 129;BA.debugLine="Root.AddView(pnlWelcome, 0, 0, width, height)";
_root.AddView((android.view.View)(_pnlwelcome.getObject()),(int) (0),(int) (0),_width,_height);
 //BA.debugLineNum = 131;BA.debugLine="lblWelcomeTitle.Initialize(\"\")";
_lblwelcometitle.Initialize(ba,"");
 //BA.debugLineNum = 132;BA.debugLine="lblWelcomeTitle.Text = ModLang.T(\"onb_welcome_tit";
_lblwelcometitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"onb_welcome_title")));
 //BA.debugLineNum = 133;BA.debugLine="lblWelcomeTitle.TextSize = Starter.FONT_TITLE";
_lblwelcometitle.setTextSize(_starter._font_title /*float*/ );
 //BA.debugLineNum = 134;BA.debugLine="lblWelcomeTitle.Gravity = Gravity.CENTER_HORIZONT";
_lblwelcometitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 135;BA.debugLine="lblWelcomeTitle.Typeface = Typeface.CreateNew(Typ";
_lblwelcometitle.setTypeface(__c.Typeface.CreateNew(__c.Typeface.DEFAULT,__c.Typeface.STYLE_BOLD));
 //BA.debugLineNum = 136;BA.debugLine="pnlWelcome.AddView(lblWelcomeTitle, margin, 80dip";
_pnlwelcome.AddView((android.view.View)(_lblwelcometitle.getObject()),_margin,__c.DipToCurrent((int) (80)),_contentwidth,__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 138;BA.debugLine="lblWelcomeText.Initialize(\"\")";
_lblwelcometext.Initialize(ba,"");
 //BA.debugLineNum = 139;BA.debugLine="lblWelcomeText.Text = ModLang.T(\"onb_welcome_text";
_lblwelcometext.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"onb_welcome_text")));
 //BA.debugLineNum = 140;BA.debugLine="lblWelcomeText.TextSize = Starter.FONT_BODY";
_lblwelcometext.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 141;BA.debugLine="lblWelcomeText.Gravity = Gravity.CENTER_HORIZONTA";
_lblwelcometext.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 142;BA.debugLine="pnlWelcome.AddView(lblWelcomeText, margin, 150dip";
_pnlwelcome.AddView((android.view.View)(_lblwelcometext.getObject()),_margin,__c.DipToCurrent((int) (150)),_contentwidth,(int) (_height-__c.DipToCurrent((int) (320))));
 //BA.debugLineNum = 144;BA.debugLine="btnWelcomeNext.Initialize(\"btnWelcomeNext\")";
_btnwelcomenext.Initialize(ba,"btnWelcomeNext");
 //BA.debugLineNum = 145;BA.debugLine="btnWelcomeNext.Text = ModLang.T(\"continue\")";
_btnwelcomenext.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"continue")));
 //BA.debugLineNum = 146;BA.debugLine="btnWelcomeNext.TextSize = Starter.FONT_BUTTON";
_btnwelcomenext.setTextSize(_starter._font_button /*float*/ );
 //BA.debugLineNum = 147;BA.debugLine="pnlWelcome.AddView(btnWelcomeNext, margin, height";
_pnlwelcome.AddView((android.view.View)(_btnwelcomenext.getObject()),_margin,(int) (_height-__c.DipToCurrent((int) (100))),_contentwidth,__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 150;BA.debugLine="pnlWarning = xui.CreatePanel(\"\")";
_pnlwarning = _xui.CreatePanel(ba,"");
 //BA.debugLineNum = 151;BA.debugLine="pnlWarning.Visible = False";
_pnlwarning.setVisible(__c.False);
 //BA.debugLineNum = 152;BA.debugLine="Root.AddView(pnlWarning, 0, 0, width, height)";
_root.AddView((android.view.View)(_pnlwarning.getObject()),(int) (0),(int) (0),_width,_height);
 //BA.debugLineNum = 154;BA.debugLine="lblWarningTitle.Initialize(\"\")";
_lblwarningtitle.Initialize(ba,"");
 //BA.debugLineNum = 155;BA.debugLine="lblWarningTitle.Text = ModLang.T(\"onb_warning_tit";
_lblwarningtitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"onb_warning_title")));
 //BA.debugLineNum = 156;BA.debugLine="lblWarningTitle.TextSize = Starter.FONT_TITLE";
_lblwarningtitle.setTextSize(_starter._font_title /*float*/ );
 //BA.debugLineNum = 157;BA.debugLine="lblWarningTitle.Gravity = Gravity.CENTER_HORIZONT";
_lblwarningtitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 158;BA.debugLine="lblWarningTitle.Typeface = Typeface.CreateNew(Typ";
_lblwarningtitle.setTypeface(__c.Typeface.CreateNew(__c.Typeface.DEFAULT,__c.Typeface.STYLE_BOLD));
 //BA.debugLineNum = 159;BA.debugLine="pnlWarning.AddView(lblWarningTitle, margin, 60dip";
_pnlwarning.AddView((android.view.View)(_lblwarningtitle.getObject()),_margin,__c.DipToCurrent((int) (60)),_contentwidth,__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 161;BA.debugLine="lblWarningText.Initialize(\"\")";
_lblwarningtext.Initialize(ba,"");
 //BA.debugLineNum = 162;BA.debugLine="lblWarningText.Text = ModLang.T(\"onb_warning_text";
_lblwarningtext.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"onb_warning_text")));
 //BA.debugLineNum = 163;BA.debugLine="lblWarningText.TextSize = Starter.FONT_BODY";
_lblwarningtext.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 164;BA.debugLine="lblWarningText.Gravity = Gravity.LEFT";
_lblwarningtext.setGravity(__c.Gravity.LEFT);
 //BA.debugLineNum = 166;BA.debugLine="pnlWarning.AddView(lblWarningText, margin, 120dip";
_pnlwarning.AddView((android.view.View)(_lblwarningtext.getObject()),_margin,__c.DipToCurrent((int) (120)),_contentwidth,(int) (_height-__c.DipToCurrent((int) (280))));
 //BA.debugLineNum = 168;BA.debugLine="chkUnderstand.Initialize(\"chkUnderstand\")";
_chkunderstand.Initialize(ba,"chkUnderstand");
 //BA.debugLineNum = 169;BA.debugLine="chkUnderstand.Text = ModLang.T(\"onb_understand\")";
_chkunderstand.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"onb_understand")));
 //BA.debugLineNum = 170;BA.debugLine="chkUnderstand.TextSize = Starter.FONT_LABEL";
_chkunderstand.setTextSize(_starter._font_label /*float*/ );
 //BA.debugLineNum = 171;BA.debugLine="chkUnderstand.Checked = False";
_chkunderstand.setChecked(__c.False);
 //BA.debugLineNum = 172;BA.debugLine="pnlWarning.AddView(chkUnderstand, margin, height";
_pnlwarning.AddView((android.view.View)(_chkunderstand.getObject()),_margin,(int) (_height-__c.DipToCurrent((int) (150))),_contentwidth,__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 174;BA.debugLine="btnWarningNext.Initialize(\"btnWarningNext\")";
_btnwarningnext.Initialize(ba,"btnWarningNext");
 //BA.debugLineNum = 175;BA.debugLine="btnWarningNext.Text = ModLang.T(\"onb_accept\")";
_btnwarningnext.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"onb_accept")));
 //BA.debugLineNum = 176;BA.debugLine="btnWarningNext.TextSize = Starter.FONT_BUTTON";
_btnwarningnext.setTextSize(_starter._font_button /*float*/ );
 //BA.debugLineNum = 177;BA.debugLine="btnWarningNext.Enabled = False";
_btnwarningnext.setEnabled(__c.False);
 //BA.debugLineNum = 178;BA.debugLine="pnlWarning.AddView(btnWarningNext, margin, height";
_pnlwarning.AddView((android.view.View)(_btnwarningnext.getObject()),_margin,(int) (_height-__c.DipToCurrent((int) (90))),_contentwidth,__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 181;BA.debugLine="pnlComplete = xui.CreatePanel(\"\")";
_pnlcomplete = _xui.CreatePanel(ba,"");
 //BA.debugLineNum = 182;BA.debugLine="pnlComplete.Visible = False";
_pnlcomplete.setVisible(__c.False);
 //BA.debugLineNum = 183;BA.debugLine="Root.AddView(pnlComplete, 0, 0, width, height)";
_root.AddView((android.view.View)(_pnlcomplete.getObject()),(int) (0),(int) (0),_width,_height);
 //BA.debugLineNum = 185;BA.debugLine="lblCompleteTitle.Initialize(\"\")";
_lblcompletetitle.Initialize(ba,"");
 //BA.debugLineNum = 186;BA.debugLine="lblCompleteTitle.Text = ModLang.T(\"onb_complete_t";
_lblcompletetitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"onb_complete_title")));
 //BA.debugLineNum = 187;BA.debugLine="lblCompleteTitle.TextSize = 28";
_lblcompletetitle.setTextSize((float) (28));
 //BA.debugLineNum = 188;BA.debugLine="lblCompleteTitle.Gravity = Gravity.CENTER_HORIZON";
_lblcompletetitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 189;BA.debugLine="lblCompleteTitle.Typeface = Typeface.CreateNew(Ty";
_lblcompletetitle.setTypeface(__c.Typeface.CreateNew(__c.Typeface.DEFAULT,__c.Typeface.STYLE_BOLD));
 //BA.debugLineNum = 190;BA.debugLine="pnlComplete.AddView(lblCompleteTitle, margin, 100";
_pnlcomplete.AddView((android.view.View)(_lblcompletetitle.getObject()),_margin,__c.DipToCurrent((int) (100)),_contentwidth,__c.DipToCurrent((int) (60)));
 //BA.debugLineNum = 192;BA.debugLine="lblCompleteText.Initialize(\"\")";
_lblcompletetext.Initialize(ba,"");
 //BA.debugLineNum = 193;BA.debugLine="lblCompleteText.Text = ModLang.T(\"onb_complete_te";
_lblcompletetext.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"onb_complete_text")));
 //BA.debugLineNum = 194;BA.debugLine="lblCompleteText.TextSize = Starter.FONT_BODY";
_lblcompletetext.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 195;BA.debugLine="lblCompleteText.Gravity = Gravity.CENTER_HORIZONT";
_lblcompletetext.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 196;BA.debugLine="pnlComplete.AddView(lblCompleteText, margin, 180d";
_pnlcomplete.AddView((android.view.View)(_lblcompletetext.getObject()),_margin,__c.DipToCurrent((int) (180)),_contentwidth,(int) (_height-__c.DipToCurrent((int) (350))));
 //BA.debugLineNum = 198;BA.debugLine="btnStart.Initialize(\"btnStart\")";
_btnstart.Initialize(ba,"btnStart");
 //BA.debugLineNum = 199;BA.debugLine="btnStart.Text = ModLang.T(\"onb_start\")";
_btnstart.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"onb_start")));
 //BA.debugLineNum = 200;BA.debugLine="btnStart.TextSize = Starter.FONT_BUTTON";
_btnstart.setTextSize(_starter._font_button /*float*/ );
 //BA.debugLineNum = 201;BA.debugLine="pnlComplete.AddView(btnStart, margin, height - 10";
_pnlcomplete.AddView((android.view.View)(_btnstart.getObject()),_margin,(int) (_height-__c.DipToCurrent((int) (100))),_contentwidth,__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 202;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 43;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return "";
}
public String  _optlangen_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 243;BA.debugLine="Private Sub optLangEN_CheckedChange(Checked As Boo";
 //BA.debugLineNum = 244;BA.debugLine="If Checked Then";
if (_checked) { 
 //BA.debugLineNum = 245;BA.debugLine="SelectedLang = \"en\"";
_selectedlang = "en";
 //BA.debugLineNum = 246;BA.debugLine="optLangPT.Checked = False";
_optlangpt.setChecked(__c.False);
 //BA.debugLineNum = 247;BA.debugLine="optLangES.Checked = False";
_optlanges.setChecked(__c.False);
 //BA.debugLineNum = 248;BA.debugLine="optLangHE.Checked = False";
_optlanghe.setChecked(__c.False);
 };
 //BA.debugLineNum = 250;BA.debugLine="End Sub";
return "";
}
public String  _optlanges_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 252;BA.debugLine="Private Sub optLangES_CheckedChange(Checked As Boo";
 //BA.debugLineNum = 253;BA.debugLine="If Checked Then";
if (_checked) { 
 //BA.debugLineNum = 254;BA.debugLine="SelectedLang = \"es\"";
_selectedlang = "es";
 //BA.debugLineNum = 255;BA.debugLine="optLangPT.Checked = False";
_optlangpt.setChecked(__c.False);
 //BA.debugLineNum = 256;BA.debugLine="optLangEN.Checked = False";
_optlangen.setChecked(__c.False);
 //BA.debugLineNum = 257;BA.debugLine="optLangHE.Checked = False";
_optlanghe.setChecked(__c.False);
 };
 //BA.debugLineNum = 259;BA.debugLine="End Sub";
return "";
}
public String  _optlanghe_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 261;BA.debugLine="Private Sub optLangHE_CheckedChange(Checked As Boo";
 //BA.debugLineNum = 262;BA.debugLine="If Checked Then";
if (_checked) { 
 //BA.debugLineNum = 263;BA.debugLine="SelectedLang = \"he\"";
_selectedlang = "he";
 //BA.debugLineNum = 264;BA.debugLine="optLangPT.Checked = False";
_optlangpt.setChecked(__c.False);
 //BA.debugLineNum = 265;BA.debugLine="optLangEN.Checked = False";
_optlangen.setChecked(__c.False);
 //BA.debugLineNum = 266;BA.debugLine="optLangES.Checked = False";
_optlanges.setChecked(__c.False);
 };
 //BA.debugLineNum = 268;BA.debugLine="End Sub";
return "";
}
public String  _optlangpt_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 234;BA.debugLine="Private Sub optLangPT_CheckedChange(Checked As Boo";
 //BA.debugLineNum = 235;BA.debugLine="If Checked Then";
if (_checked) { 
 //BA.debugLineNum = 236;BA.debugLine="SelectedLang = \"pt\"";
_selectedlang = "pt";
 //BA.debugLineNum = 237;BA.debugLine="optLangEN.Checked = False";
_optlangen.setChecked(__c.False);
 //BA.debugLineNum = 238;BA.debugLine="optLangES.Checked = False";
_optlanges.setChecked(__c.False);
 //BA.debugLineNum = 239;BA.debugLine="optLangHE.Checked = False";
_optlanghe.setChecked(__c.False);
 };
 //BA.debugLineNum = 241;BA.debugLine="End Sub";
return "";
}
public String  _refreshwelcometexts() throws Exception{
 //BA.debugLineNum = 271;BA.debugLine="Private Sub RefreshWelcomeTexts";
 //BA.debugLineNum = 272;BA.debugLine="lblWelcomeTitle.Text = ModLang.T(\"onb_welcome_tit";
_lblwelcometitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"onb_welcome_title")));
 //BA.debugLineNum = 273;BA.debugLine="lblWelcomeText.Text = ModLang.T(\"onb_welcome_text";
_lblwelcometext.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"onb_welcome_text")));
 //BA.debugLineNum = 274;BA.debugLine="btnWelcomeNext.Text = ModLang.T(\"continue\")";
_btnwelcomenext.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"continue")));
 //BA.debugLineNum = 275;BA.debugLine="lblWarningTitle.Text = ModLang.T(\"onb_warning_tit";
_lblwarningtitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"onb_warning_title")));
 //BA.debugLineNum = 276;BA.debugLine="lblWarningText.Text = ModLang.T(\"onb_warning_text";
_lblwarningtext.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"onb_warning_text")));
 //BA.debugLineNum = 277;BA.debugLine="chkUnderstand.Text = ModLang.T(\"onb_understand\")";
_chkunderstand.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"onb_understand")));
 //BA.debugLineNum = 278;BA.debugLine="btnWarningNext.Text = ModLang.T(\"onb_accept\")";
_btnwarningnext.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"onb_accept")));
 //BA.debugLineNum = 279;BA.debugLine="lblCompleteTitle.Text = ModLang.T(\"onb_complete_t";
_lblcompletetitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"onb_complete_title")));
 //BA.debugLineNum = 280;BA.debugLine="lblCompleteText.Text = ModLang.T(\"onb_complete_te";
_lblcompletetext.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"onb_complete_text")));
 //BA.debugLineNum = 281;BA.debugLine="btnStart.Text = ModLang.T(\"onb_start\")";
_btnstart.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"onb_start")));
 //BA.debugLineNum = 282;BA.debugLine="End Sub";
return "";
}
public String  _showstep(int _stepnum) throws Exception{
 //BA.debugLineNum = 208;BA.debugLine="Private Sub ShowStep(stepNum As Int)";
 //BA.debugLineNum = 209;BA.debugLine="CurrentStep = stepNum";
_currentstep = _stepnum;
 //BA.debugLineNum = 211;BA.debugLine="pnlLanguage.Visible = (stepNum = 0)";
_pnllanguage.setVisible((_stepnum==0));
 //BA.debugLineNum = 212;BA.debugLine="pnlWelcome.Visible = (stepNum = 1)";
_pnlwelcome.setVisible((_stepnum==1));
 //BA.debugLineNum = 213;BA.debugLine="pnlWarning.Visible = (stepNum = 2)";
_pnlwarning.setVisible((_stepnum==2));
 //BA.debugLineNum = 214;BA.debugLine="pnlComplete.Visible = (stepNum = 3)";
_pnlcomplete.setVisible((_stepnum==3));
 //BA.debugLineNum = 215;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
