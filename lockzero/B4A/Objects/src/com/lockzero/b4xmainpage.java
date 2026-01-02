package com.lockzero;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class b4xmainpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.lockzero.b4xmainpage");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.lockzero.b4xmainpage.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlmenuoverlay = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlmenu = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _svmenu = null;
public boolean _menuvisible = false;
public anywheresoftware.b4a.objects.PanelWrapper _pnlcsvoverlay = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlheader = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlcontent = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlfooter = null;
public int _header_height = 0;
public int _footer_height = 0;
public int _grid_margin = 0;
public int _grid_gap = 0;
public int _card_corner = 0;
public anywheresoftware.b4a.objects.Timer _tmrsession = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblsessiontimer = null;
public com.lockzero.biometricmanager _biometric = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnllock = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtpininput = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnpinsubmit = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblpinerror = null;
public boolean _isauthenticated = false;
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
public String  _addmenubutton(String _txt,String _eventname,int _top,int _w,int _h) throws Exception{
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
 //BA.debugLineNum = 177;BA.debugLine="Private Sub AddMenuButton(txt As String, eventName";
 //BA.debugLineNum = 178;BA.debugLine="Dim btn As Button";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 179;BA.debugLine="btn.Initialize(eventName)";
_btn.Initialize(ba,_eventname);
 //BA.debugLineNum = 180;BA.debugLine="btn.Text = txt";
_btn.setText(BA.ObjectToCharSequence(_txt));
 //BA.debugLineNum = 181;BA.debugLine="btn.TextSize = Starter.FONT_BODY";
_btn.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 182;BA.debugLine="btn.TextColor = Colors.White";
_btn.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 183;BA.debugLine="btn.Color = Colors.Transparent";
_btn.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 184;BA.debugLine="btn.Gravity = Gravity.CENTER_VERTICAL + Gravity.L";
_btn.setGravity((int) (__c.Gravity.CENTER_VERTICAL+__c.Gravity.LEFT));
 //BA.debugLineNum = 185;BA.debugLine="svMenu.Panel.AddView(btn, 16dip, top, w, h)";
_svmenu.getPanel().AddView((android.view.View)(_btn.getObject()),__c.DipToCurrent((int) (16)),_top,_w,_h);
 //BA.debugLineNum = 186;BA.debugLine="End Sub";
return "";
}
public void  _animatepulse(anywheresoftware.b4a.objects.PanelWrapper _pnl) throws Exception{
ResumableSub_AnimatePulse rsub = new ResumableSub_AnimatePulse(this,_pnl);
rsub.resume(ba, null);
}
public static class ResumableSub_AnimatePulse extends BA.ResumableSub {
public ResumableSub_AnimatePulse(com.lockzero.b4xmainpage parent,anywheresoftware.b4a.objects.PanelWrapper _pnl) {
this.parent = parent;
this._pnl = _pnl;
}
com.lockzero.b4xmainpage parent;
anywheresoftware.b4a.objects.PanelWrapper _pnl;
anywheresoftware.b4a.objects.B4XViewWrapper _xv = null;
int _l = 0;
int _t = 0;
int _w = 0;
int _h = 0;
int _grow = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 //BA.debugLineNum = 584;BA.debugLine="Dim xv As B4XView = pnl";
_xv = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xv = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnl.getObject()));
 //BA.debugLineNum = 585;BA.debugLine="Dim l As Int = xv.Left";
_l = _xv.getLeft();
 //BA.debugLineNum = 586;BA.debugLine="Dim t As Int = xv.Top";
_t = _xv.getTop();
 //BA.debugLineNum = 587;BA.debugLine="Dim w As Int = xv.Width";
_w = _xv.getWidth();
 //BA.debugLineNum = 588;BA.debugLine="Dim h As Int = xv.Height";
_h = _xv.getHeight();
 //BA.debugLineNum = 590;BA.debugLine="Dim grow As Int = 6dip";
_grow = parent.__c.DipToCurrent((int) (6));
 //BA.debugLineNum = 591;BA.debugLine="xv.SetLayoutAnimated(100, l - grow, t - grow, w +";
_xv.SetLayoutAnimated((int) (100),(int) (_l-_grow),(int) (_t-_grow),(int) (_w+_grow*2),(int) (_h+_grow*2));
 //BA.debugLineNum = 592;BA.debugLine="Sleep(100)";
parent.__c.Sleep(ba,this,(int) (100));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 593;BA.debugLine="xv.SetLayoutAnimated(100, l, t, w, h)";
_xv.SetLayoutAnimated((int) (100),_l,_t,_w,_h);
 //BA.debugLineNum = 594;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _animatepulseandnavigate(anywheresoftware.b4a.objects.PanelWrapper _pnl,String _pagename) throws Exception{
ResumableSub_AnimatePulseAndNavigate rsub = new ResumableSub_AnimatePulseAndNavigate(this,_pnl,_pagename);
rsub.resume(ba, null);
}
public static class ResumableSub_AnimatePulseAndNavigate extends BA.ResumableSub {
public ResumableSub_AnimatePulseAndNavigate(com.lockzero.b4xmainpage parent,anywheresoftware.b4a.objects.PanelWrapper _pnl,String _pagename) {
this.parent = parent;
this._pnl = _pnl;
this._pagename = _pagename;
}
com.lockzero.b4xmainpage parent;
anywheresoftware.b4a.objects.PanelWrapper _pnl;
String _pagename;
com.lockzero.pagepasswords _pgpass = null;
com.lockzero.pagebackup _pgbackup = null;
com.lockzero.pagesettings _pgsettings = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 598;BA.debugLine="AnimatePulse(pnl)";
parent._animatepulse(_pnl);
 //BA.debugLineNum = 599;BA.debugLine="Sleep(150)";
parent.__c.Sleep(ba,this,(int) (150));
this.state = 9;
return;
case 9:
//C
this.state = 1;
;
 //BA.debugLineNum = 601;BA.debugLine="Select pageName";
if (true) break;

case 1:
//select
this.state = 8;
switch (BA.switchObjectToInt(_pagename,"PagePasswords","PageBackup","PageSettings")) {
case 0: {
this.state = 3;
if (true) break;
}
case 1: {
this.state = 5;
if (true) break;
}
case 2: {
this.state = 7;
if (true) break;
}
}
if (true) break;

case 3:
//C
this.state = 8;
 //BA.debugLineNum = 603;BA.debugLine="Dim pgPass As PagePasswords = B4XPages.GetPage(";
_pgpass = (com.lockzero.pagepasswords)(parent._b4xpages._getpage /*Object*/ (ba,_pagename));
 //BA.debugLineNum = 604;BA.debugLine="ModTransition.SlideToLeft(Root, pgPass.Root)";
parent._modtransition._slidetoleft /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (ba,parent._root,_pgpass._root /*anywheresoftware.b4a.objects.B4XViewWrapper*/ );
 if (true) break;

case 5:
//C
this.state = 8;
 //BA.debugLineNum = 606;BA.debugLine="Dim pgBackup As PageBackup = B4XPages.GetPage(p";
_pgbackup = (com.lockzero.pagebackup)(parent._b4xpages._getpage /*Object*/ (ba,_pagename));
 //BA.debugLineNum = 607;BA.debugLine="ModTransition.SlideToLeft(Root, pgBackup.Root)";
parent._modtransition._slidetoleft /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (ba,parent._root,_pgbackup._root /*anywheresoftware.b4a.objects.B4XViewWrapper*/ );
 if (true) break;

case 7:
//C
this.state = 8;
 //BA.debugLineNum = 609;BA.debugLine="Dim pgSettings As PageSettings = B4XPages.GetPa";
_pgsettings = (com.lockzero.pagesettings)(parent._b4xpages._getpage /*Object*/ (ba,_pagename));
 //BA.debugLineNum = 610;BA.debugLine="ModTransition.SlideToLeft(Root, pgSettings.Root";
parent._modtransition._slidetoleft /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (ba,parent._root,_pgsettings._root /*anywheresoftware.b4a.objects.B4XViewWrapper*/ );
 if (true) break;

case 8:
//C
this.state = -1;
;
 //BA.debugLineNum = 612;BA.debugLine="B4XPages.ShowPage(pageName)";
parent._b4xpages._showpage /*String*/ (ba,_pagename);
 //BA.debugLineNum = 613;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _animatepulseandnavigatenotes(anywheresoftware.b4a.objects.PanelWrapper _pnl) throws Exception{
ResumableSub_AnimatePulseAndNavigateNotes rsub = new ResumableSub_AnimatePulseAndNavigateNotes(this,_pnl);
rsub.resume(ba, null);
}
public static class ResumableSub_AnimatePulseAndNavigateNotes extends BA.ResumableSub {
public ResumableSub_AnimatePulseAndNavigateNotes(com.lockzero.b4xmainpage parent,anywheresoftware.b4a.objects.PanelWrapper _pnl) {
this.parent = parent;
this._pnl = _pnl;
}
com.lockzero.b4xmainpage parent;
anywheresoftware.b4a.objects.PanelWrapper _pnl;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 //BA.debugLineNum = 617;BA.debugLine="AnimatePulse(pnl)";
parent._animatepulse(_pnl);
 //BA.debugLineNum = 618;BA.debugLine="Sleep(150)";
parent.__c.Sleep(ba,this,(int) (150));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 619;BA.debugLine="NavigateToNotes";
parent._navigatetonotes();
 //BA.debugLineNum = 620;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _applytheme() throws Exception{
 //BA.debugLineNum = 821;BA.debugLine="Private Sub ApplyTheme";
 //BA.debugLineNum = 822;BA.debugLine="Root.Color = ModTheme.HomeBg";
_root.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 824;BA.debugLine="If pnlHeader.IsInitialized Then pnlHeader.Color =";
if (_pnlheader.IsInitialized()) { 
_pnlheader.setColor(_modtheme._homeheaderbg /*int*/ (ba));};
 //BA.debugLineNum = 825;BA.debugLine="If pnlContent.IsInitialized Then pnlContent.Color";
if (_pnlcontent.IsInitialized()) { 
_pnlcontent.setColor(_modtheme._homebg /*int*/ (ba));};
 //BA.debugLineNum = 826;BA.debugLine="If pnlFooter.IsInitialized Then pnlFooter.Color =";
if (_pnlfooter.IsInitialized()) { 
_pnlfooter.setColor(_modtheme._homebg /*int*/ (ba));};
 //BA.debugLineNum = 827;BA.debugLine="If pnlMenu.IsInitialized Then pnlMenu.Color = Mod";
if (_pnlmenu.IsInitialized()) { 
_pnlmenu.setColor(_modtheme._homebg /*int*/ (ba));};
 //BA.debugLineNum = 828;BA.debugLine="If svMenu.IsInitialized Then svMenu.Panel.Color =";
if (_svmenu.IsInitialized()) { 
_svmenu.getPanel().setColor(_modtheme._homebg /*int*/ (ba));};
 //BA.debugLineNum = 829;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_appear() throws Exception{
 //BA.debugLineNum = 65;BA.debugLine="Private Sub B4XPage_Appear";
 //BA.debugLineNum = 67;BA.debugLine="CallSub2(Main, \"SetPageTitle\", \"LockZero\")";
__c.CallSubNew2(ba,(Object)(_main.getObject()),"SetPageTitle",(Object)("LockZero"));
 //BA.debugLineNum = 70;BA.debugLine="If ModSecurity.HasPIN And IsAuthenticated = False";
if (_modsecurity._haspin /*boolean*/ (ba) && _isauthenticated==__c.False) { 
 //BA.debugLineNum = 71;BA.debugLine="ShowLockScreen";
_showlockscreen();
 //BA.debugLineNum = 72;BA.debugLine="Return  'Nao continua ate autenticar";
if (true) return "";
 };
 //BA.debugLineNum = 76;BA.debugLine="RebuildMenuItems";
_rebuildmenuitems();
 //BA.debugLineNum = 77;BA.debugLine="ShowHome";
_showhome();
 //BA.debugLineNum = 78;BA.debugLine="RefreshFooter";
_refreshfooter();
 //BA.debugLineNum = 81;BA.debugLine="UpdateSessionDisplay";
_updatesessiondisplay();
 //BA.debugLineNum = 82;BA.debugLine="If ModSession.IsSessionActive Then";
if (_modsession._issessionactive /*boolean*/ (ba)) { 
 //BA.debugLineNum = 83;BA.debugLine="tmrSession.Enabled = True";
_tmrsession.setEnabled(__c.True);
 };
 //BA.debugLineNum = 85;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _b4xpage_closerequest() throws Exception{
ResumableSub_B4XPage_CloseRequest rsub = new ResumableSub_B4XPage_CloseRequest(this);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_B4XPage_CloseRequest extends BA.ResumableSub {
public ResumableSub_B4XPage_CloseRequest(com.lockzero.b4xmainpage parent) {
this.parent = parent;
}
com.lockzero.b4xmainpage parent;
int _result = 0;

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
 //BA.debugLineNum = 837;BA.debugLine="If MenuVisible Then";
if (true) break;

case 1:
//if
this.state = 4;
if (parent._menuvisible) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 838;BA.debugLine="HideMenu";
parent._hidemenu();
 //BA.debugLineNum = 839;BA.debugLine="Return False";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.False));return;};
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 843;BA.debugLine="Wait For (xui.Msgbox2Async(ModLang.T(\"confirm_exi";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"confirm_exit")),BA.ObjectToCharSequence(parent._starter._app_name /*String*/ ),parent._modlang._t /*String*/ (ba,"yes"),"",parent._modlang._t /*String*/ (ba,"no"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 5;
return;
case 5:
//C
this.state = -1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 844;BA.debugLine="Return Result = xui.DialogResponse_Positive";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_result==parent._xui.DialogResponse_Positive));return;};
 //BA.debugLineNum = 845;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _msgbox_result(int _result) throws Exception{
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
 //BA.debugLineNum = 49;BA.debugLine="Private Sub B4XPage_Created(Root1 As B4XView)";
 //BA.debugLineNum = 50;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 51;BA.debugLine="Root.Color = ModTheme.Background";
_root.setColor(_modtheme._background /*int*/ (ba));
 //BA.debugLineNum = 53;BA.debugLine="CreateMainPanel";
_createmainpanel();
 //BA.debugLineNum = 54;BA.debugLine="CreateSideMenu";
_createsidemenu();
 //BA.debugLineNum = 55;BA.debugLine="CreateLockScreen		'Overlay de PIN/Biometria";
_createlockscreen();
 //BA.debugLineNum = 58;BA.debugLine="Biometric.Initialize(Me, \"Biometric\")";
_biometric._initialize /*String*/ (ba,this,"Biometric");
 //BA.debugLineNum = 59;BA.debugLine="Log(\"Biometric initialized, CanAuthenticate: \" &";
__c.LogImpl("81441802","Biometric initialized, CanAuthenticate: "+_biometric._canauthenticate /*String*/ (),0);
 //BA.debugLineNum = 61;BA.debugLine="ShowHome";
_showhome();
 //BA.debugLineNum = 62;BA.debugLine="ApplyTheme";
_applytheme();
 //BA.debugLineNum = 63;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_disappear() throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="Private Sub B4XPage_Disappear";
 //BA.debugLineNum = 88;BA.debugLine="tmrSession.Enabled = False";
_tmrsession.setEnabled(__c.False);
 //BA.debugLineNum = 89;BA.debugLine="End Sub";
return "";
}
public String  _biometric_complete(boolean _success,String _errormessage) throws Exception{
 //BA.debugLineNum = 785;BA.debugLine="Private Sub Biometric_Complete(Success As Boolean,";
 //BA.debugLineNum = 786;BA.debugLine="If Success Then";
if (_success) { 
 //BA.debugLineNum = 787;BA.debugLine="Log(\"Biometria: Sucesso\")";
__c.LogImpl("83997698","Biometria: Sucesso",0);
 //BA.debugLineNum = 788;BA.debugLine="HideLockScreen";
_hidelockscreen();
 }else {
 //BA.debugLineNum = 790;BA.debugLine="Log(\"Biometria: Falha - \" & ErrorMessage)";
__c.LogImpl("83997701","Biometria: Falha - "+_errormessage,0);
 };
 //BA.debugLineNum = 793;BA.debugLine="End Sub";
return "";
}
public String  _btncancelcsv_click() throws Exception{
 //BA.debugLineNum = 533;BA.debugLine="Private Sub btnCancelCSV_Click";
 //BA.debugLineNum = 534;BA.debugLine="CloseCSVDialog";
_closecsvdialog();
 //BA.debugLineNum = 535;BA.debugLine="End Sub";
return "";
}
public String  _btnmenu_click() throws Exception{
 //BA.debugLineNum = 411;BA.debugLine="Private Sub btnMenu_Click";
 //BA.debugLineNum = 412;BA.debugLine="ToggleMenu";
_togglemenu();
 //BA.debugLineNum = 413;BA.debugLine="End Sub";
return "";
}
public String  _btnpinsubmit_click() throws Exception{
String _pin = "";
 //BA.debugLineNum = 796;BA.debugLine="Private Sub btnPinSubmit_Click";
 //BA.debugLineNum = 797;BA.debugLine="Dim pin As String = edtPinInput.Text.Trim";
_pin = _edtpininput.getText().trim();
 //BA.debugLineNum = 799;BA.debugLine="If pin.Length < 4 Then";
if (_pin.length()<4) { 
 //BA.debugLineNum = 800;BA.debugLine="lblPinError.Text = ModLang.T(\"pin_too_short\")";
_lblpinerror.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"pin_too_short")));
 //BA.debugLineNum = 801;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 804;BA.debugLine="If ModSecurity.ValidatePIN(pin) Then";
if (_modsecurity._validatepin /*boolean*/ (ba,_pin)) { 
 //BA.debugLineNum = 805;BA.debugLine="HideLockScreen";
_hidelockscreen();
 }else {
 //BA.debugLineNum = 807;BA.debugLine="lblPinError.Text = ModLang.T(\"pin_wrong\")";
_lblpinerror.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"pin_wrong")));
 //BA.debugLineNum = 808;BA.debugLine="edtPinInput.Text = \"\"";
_edtpininput.setText(BA.ObjectToCharSequence(""));
 };
 //BA.debugLineNum = 810;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 5;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Public Root As B4XView  'Public para transicoes";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 7;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 10;BA.debugLine="Private pnlMenuOverlay As Panel";
_pnlmenuoverlay = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 11;BA.debugLine="Private pnlMenu As Panel";
_pnlmenu = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 12;BA.debugLine="Private svMenu As ScrollView";
_svmenu = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Private MenuVisible As Boolean = False";
_menuvisible = __c.False;
 //BA.debugLineNum = 16;BA.debugLine="Private pnlCSVOverlay As Panel";
_pnlcsvoverlay = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private pnlHeader As Panel";
_pnlheader = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private pnlContent As Panel";
_pnlcontent = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private pnlFooter As Panel";
_pnlfooter = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private HEADER_HEIGHT As Int = 56dip";
_header_height = __c.DipToCurrent((int) (56));
 //BA.debugLineNum = 25;BA.debugLine="Private FOOTER_HEIGHT As Int = 80dip";
_footer_height = __c.DipToCurrent((int) (80));
 //BA.debugLineNum = 26;BA.debugLine="Private GRID_MARGIN As Int = 18dip";
_grid_margin = __c.DipToCurrent((int) (18));
 //BA.debugLineNum = 27;BA.debugLine="Private GRID_GAP As Int = 14dip";
_grid_gap = __c.DipToCurrent((int) (14));
 //BA.debugLineNum = 28;BA.debugLine="Private CARD_CORNER As Int = 14dip";
_card_corner = __c.DipToCurrent((int) (14));
 //BA.debugLineNum = 31;BA.debugLine="Private tmrSession As Timer";
_tmrsession = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 32;BA.debugLine="Private lblSessionTimer As Label";
_lblsessiontimer = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private Biometric As BiometricManager";
_biometric = new com.lockzero.biometricmanager();
 //BA.debugLineNum = 36;BA.debugLine="Private pnlLock As Panel			'Overlay de bloqueio";
_pnllock = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private edtPinInput As EditText		'Campo para digi";
_edtpininput = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private btnPinSubmit As Button		'Botao confirmar";
_btnpinsubmit = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Private lblPinError As Label		'Mensagem de erro";
_lblpinerror = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private IsAuthenticated As Boolean = False  'Flag";
_isauthenticated = __c.False;
 //BA.debugLineNum = 42;BA.debugLine="End Sub";
return "";
}
public String  _closecsvdialog() throws Exception{
 //BA.debugLineNum = 537;BA.debugLine="Private Sub CloseCSVDialog";
 //BA.debugLineNum = 539;BA.debugLine="If pnlCSVOverlay.IsInitialized Then";
if (_pnlcsvoverlay.IsInitialized()) { 
 //BA.debugLineNum = 540;BA.debugLine="pnlCSVOverlay.RemoveView";
_pnlcsvoverlay.RemoveView();
 };
 //BA.debugLineNum = 542;BA.debugLine="End Sub";
return "";
}
public String  _createfooter() throws Exception{
int _width = 0;
int _y = 0;
anywheresoftware.b4a.objects.LabelWrapper _lblslogan = null;
anywheresoftware.b4a.objects.LabelWrapper _lblversion = null;
 //BA.debugLineNum = 286;BA.debugLine="Private Sub CreateFooter";
 //BA.debugLineNum = 287;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 288;BA.debugLine="Dim y As Int = 8dip";
_y = __c.DipToCurrent((int) (8));
 //BA.debugLineNum = 291;BA.debugLine="Dim lblSlogan As Label";
_lblslogan = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 292;BA.debugLine="lblSlogan.Initialize(\"\")";
_lblslogan.Initialize(ba,"");
 //BA.debugLineNum = 293;BA.debugLine="lblSlogan.Text = ModLang.T(\"app_tagline\")";
_lblslogan.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"app_tagline")));
 //BA.debugLineNum = 294;BA.debugLine="lblSlogan.TextSize = 14";
_lblslogan.setTextSize((float) (14));
 //BA.debugLineNum = 295;BA.debugLine="lblSlogan.TextColor = Colors.ARGB(180, 255, 255,";
_lblslogan.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 296;BA.debugLine="lblSlogan.Gravity = Gravity.CENTER_HORIZONTAL";
_lblslogan.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 297;BA.debugLine="pnlFooter.AddView(lblSlogan, 0, y, width, 22dip)";
_pnlfooter.AddView((android.view.View)(_lblslogan.getObject()),(int) (0),_y,_width,__c.DipToCurrent((int) (22)));
 //BA.debugLineNum = 298;BA.debugLine="y = y + 22dip";
_y = (int) (_y+__c.DipToCurrent((int) (22)));
 //BA.debugLineNum = 301;BA.debugLine="Dim lblVersion As Label";
_lblversion = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 302;BA.debugLine="lblVersion.Initialize(\"\")";
_lblversion.Initialize(ba,"");
 //BA.debugLineNum = 303;BA.debugLine="lblVersion.Text = ModLang.T(\"free_version\") & \" -";
_lblversion.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"free_version")+" - v"+_starter._app_version /*String*/ ));
 //BA.debugLineNum = 304;BA.debugLine="lblVersion.TextSize = 12";
_lblversion.setTextSize((float) (12));
 //BA.debugLineNum = 305;BA.debugLine="lblVersion.TextColor = Colors.ARGB(140, 255, 255,";
_lblversion.setTextColor(__c.Colors.ARGB((int) (140),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 306;BA.debugLine="lblVersion.Gravity = Gravity.CENTER_HORIZONTAL";
_lblversion.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 307;BA.debugLine="pnlFooter.AddView(lblVersion, 0, y, width, 20dip)";
_pnlfooter.AddView((android.view.View)(_lblversion.getObject()),(int) (0),_y,_width,__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 308;BA.debugLine="y = y + 24dip";
_y = (int) (_y+__c.DipToCurrent((int) (24)));
 //BA.debugLineNum = 311;BA.debugLine="lblSessionTimer.Initialize(\"lblSessionTimer\")";
_lblsessiontimer.Initialize(ba,"lblSessionTimer");
 //BA.debugLineNum = 312;BA.debugLine="lblSessionTimer.Text = \"\"";
_lblsessiontimer.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 313;BA.debugLine="lblSessionTimer.TextSize = 11";
_lblsessiontimer.setTextSize((float) (11));
 //BA.debugLineNum = 314;BA.debugLine="lblSessionTimer.TextColor = Colors.ARGB(160, 255,";
_lblsessiontimer.setTextColor(__c.Colors.ARGB((int) (160),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 315;BA.debugLine="lblSessionTimer.Gravity = Gravity.CENTER_HORIZONT";
_lblsessiontimer.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 316;BA.debugLine="pnlFooter.AddView(lblSessionTimer, 0, y, width, 1";
_pnlfooter.AddView((android.view.View)(_lblsessiontimer.getObject()),(int) (0),_y,_width,__c.DipToCurrent((int) (18)));
 //BA.debugLineNum = 317;BA.debugLine="End Sub";
return "";
}
public String  _createheader() throws Exception{
int _width = 0;
anywheresoftware.b4a.objects.ImageViewWrapper _ivlogo = null;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
anywheresoftware.b4a.objects.ButtonWrapper _btnmenu = null;
 //BA.debugLineNum = 248;BA.debugLine="Private Sub CreateHeader";
 //BA.debugLineNum = 249;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 252;BA.debugLine="Dim ivLogo As ImageView";
_ivlogo = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 253;BA.debugLine="ivLogo.Initialize(\"\")";
_ivlogo.Initialize(ba,"");
 //BA.debugLineNum = 254;BA.debugLine="ivLogo.Gravity = Gravity.FILL";
_ivlogo.setGravity(__c.Gravity.FILL);
 //BA.debugLineNum = 255;BA.debugLine="pnlHeader.AddView(ivLogo, 16dip, 8dip, 40dip, 40d";
_pnlheader.AddView((android.view.View)(_ivlogo.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (8)),__c.DipToCurrent((int) (40)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 256;BA.debugLine="Try";
try { //BA.debugLineNum = 257;BA.debugLine="ivLogo.Bitmap = LoadBitmap(File.DirAssets, \"ic_l";
_ivlogo.setBitmap((android.graphics.Bitmap)(__c.LoadBitmap(__c.File.getDirAssets(),"ic_lockzero.png").getObject()));
 } 
       catch (Exception e9) {
			ba.setLastException(e9); //BA.debugLineNum = 259;BA.debugLine="Log(\"Erro ao carregar ic_lockzero.png: \" & LastE";
__c.LogImpl("82162699","Erro ao carregar ic_lockzero.png: "+__c.LastException(ba).getMessage(),0);
 };
 //BA.debugLineNum = 263;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 264;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 265;BA.debugLine="lblTitle.Text = \"LockZero\"";
_lbltitle.setText(BA.ObjectToCharSequence("LockZero"));
 //BA.debugLineNum = 266;BA.debugLine="lblTitle.TextSize = 20";
_lbltitle.setTextSize((float) (20));
 //BA.debugLineNum = 267;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 268;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 269;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_VERTICAL";
_lbltitle.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 270;BA.debugLine="pnlHeader.AddView(lblTitle, 64dip, 0, width - 120";
_pnlheader.AddView((android.view.View)(_lbltitle.getObject()),__c.DipToCurrent((int) (64)),(int) (0),(int) (_width-__c.DipToCurrent((int) (120))),_header_height);
 //BA.debugLineNum = 273;BA.debugLine="Dim btnMenu As Button";
_btnmenu = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 274;BA.debugLine="btnMenu.Initialize(\"btnMenu\")";
_btnmenu.Initialize(ba,"btnMenu");
 //BA.debugLineNum = 275;BA.debugLine="btnMenu.Text = Chr(0x2630) 'Hamburguer ☰";
_btnmenu.setText(BA.ObjectToCharSequence(__c.Chr(((int)0x2630))));
 //BA.debugLineNum = 276;BA.debugLine="btnMenu.TextSize = 24";
_btnmenu.setTextSize((float) (24));
 //BA.debugLineNum = 277;BA.debugLine="btnMenu.TextColor = Colors.White";
_btnmenu.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 278;BA.debugLine="btnMenu.Color = Colors.Transparent";
_btnmenu.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 279;BA.debugLine="pnlHeader.AddView(btnMenu, width - 56dip, 0, 56di";
_pnlheader.AddView((android.view.View)(_btnmenu.getObject()),(int) (_width-__c.DipToCurrent((int) (56))),(int) (0),__c.DipToCurrent((int) (56)),_header_height);
 //BA.debugLineNum = 280;BA.debugLine="End Sub";
return "";
}
public String  _createhomecard(String _eventname,String _labeltext,String _iconfile,int _x,int _y,int _size) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xv = null;
int _iconsize = 0;
int _icony = 0;
int _iconx = 0;
anywheresoftware.b4a.objects.ImageViewWrapper _ivicon = null;
anywheresoftware.b4a.objects.LabelWrapper _lblfallback = null;
int _lblspace = 0;
int _lbly = 0;
int _lblh = 0;
anywheresoftware.b4a.objects.LabelWrapper _lbllabel = null;
 //BA.debugLineNum = 356;BA.debugLine="Private Sub CreateHomeCard(eventName As String, la";
 //BA.debugLineNum = 358;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 359;BA.debugLine="pnl.Initialize(eventName)";
_pnl.Initialize(ba,_eventname);
 //BA.debugLineNum = 361;BA.debugLine="Dim xv As B4XView = pnl";
_xv = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xv = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnl.getObject()));
 //BA.debugLineNum = 362;BA.debugLine="xv.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModT";
_xv.SetColorAndBorder(_modtheme._homeiconbg /*int*/ (ba),(int) (0),_modtheme._homeiconbg /*int*/ (ba),_card_corner);
 //BA.debugLineNum = 363;BA.debugLine="pnlContent.AddView(pnl, x, y, size, size)";
_pnlcontent.AddView((android.view.View)(_pnl.getObject()),_x,_y,_size,_size);
 //BA.debugLineNum = 366;BA.debugLine="Dim iconSize As Int = size * 0.55";
_iconsize = (int) (_size*0.55);
 //BA.debugLineNum = 369;BA.debugLine="Dim iconY As Int = (size * 0.42) - (iconSize / 2)";
_icony = (int) ((_size*0.42)-(_iconsize/(double)2));
 //BA.debugLineNum = 370;BA.debugLine="Dim iconX As Int = (size - iconSize) / 2";
_iconx = (int) ((_size-_iconsize)/(double)2);
 //BA.debugLineNum = 373;BA.debugLine="Dim ivIcon As ImageView";
_ivicon = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 374;BA.debugLine="ivIcon.Initialize(\"\")";
_ivicon.Initialize(ba,"");
 //BA.debugLineNum = 375;BA.debugLine="ivIcon.Gravity = Gravity.FILL";
_ivicon.setGravity(__c.Gravity.FILL);
 //BA.debugLineNum = 376;BA.debugLine="pnl.AddView(ivIcon, iconX, iconY, iconSize, iconS";
_pnl.AddView((android.view.View)(_ivicon.getObject()),_iconx,_icony,_iconsize,_iconsize);
 //BA.debugLineNum = 378;BA.debugLine="Try";
try { //BA.debugLineNum = 379;BA.debugLine="ivIcon.Bitmap = LoadBitmap(File.DirAssets, iconF";
_ivicon.setBitmap((android.graphics.Bitmap)(__c.LoadBitmap(__c.File.getDirAssets(),_iconfile).getObject()));
 } 
       catch (Exception e16) {
			ba.setLastException(e16); //BA.debugLineNum = 381;BA.debugLine="Log(\"Erro ao carregar \" & iconFile & \": \" & Last";
__c.LogImpl("82424857","Erro ao carregar "+_iconfile+": "+__c.LastException(ba).getMessage(),0);
 //BA.debugLineNum = 383;BA.debugLine="Dim lblFallback As Label";
_lblfallback = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 384;BA.debugLine="lblFallback.Initialize(\"\")";
_lblfallback.Initialize(ba,"");
 //BA.debugLineNum = 385;BA.debugLine="lblFallback.Text = \"?\"";
_lblfallback.setText(BA.ObjectToCharSequence("?"));
 //BA.debugLineNum = 386;BA.debugLine="lblFallback.TextSize = 32";
_lblfallback.setTextSize((float) (32));
 //BA.debugLineNum = 387;BA.debugLine="lblFallback.TextColor = Colors.White";
_lblfallback.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 388;BA.debugLine="lblFallback.Gravity = Gravity.CENTER";
_lblfallback.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 389;BA.debugLine="pnl.AddView(lblFallback, iconX, iconY, iconSize,";
_pnl.AddView((android.view.View)(_lblfallback.getObject()),_iconx,_icony,_iconsize,_iconsize);
 };
 //BA.debugLineNum = 393;BA.debugLine="Dim lblSpace As Int = 10dip";
_lblspace = __c.DipToCurrent((int) (10));
 //BA.debugLineNum = 394;BA.debugLine="Dim lblY As Int = iconY + iconSize + lblSpace";
_lbly = (int) (_icony+_iconsize+_lblspace);
 //BA.debugLineNum = 395;BA.debugLine="Dim lblH As Int = size - lblY - 8dip";
_lblh = (int) (_size-_lbly-__c.DipToCurrent((int) (8)));
 //BA.debugLineNum = 397;BA.debugLine="Dim lblLabel As Label";
_lbllabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 398;BA.debugLine="lblLabel.Initialize(\"\")";
_lbllabel.Initialize(ba,"");
 //BA.debugLineNum = 399;BA.debugLine="lblLabel.Text = labelText";
_lbllabel.setText(BA.ObjectToCharSequence(_labeltext));
 //BA.debugLineNum = 400;BA.debugLine="lblLabel.TextSize = 15";
_lbllabel.setTextSize((float) (15));
 //BA.debugLineNum = 401;BA.debugLine="lblLabel.TextColor = Colors.ARGB(230, 255, 255, 2";
_lbllabel.setTextColor(__c.Colors.ARGB((int) (230),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 402;BA.debugLine="lblLabel.Gravity = Gravity.CENTER_HORIZONTAL";
_lbllabel.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 403;BA.debugLine="lblLabel.Typeface = Typeface.DEFAULT_BOLD";
_lbllabel.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 404;BA.debugLine="pnl.AddView(lblLabel, 0, lblY, size, lblH)";
_pnl.AddView((android.view.View)(_lbllabel.getObject()),(int) (0),_lbly,_size,_lblh);
 //BA.debugLineNum = 405;BA.debugLine="End Sub";
return "";
}
public String  _createlockscreen() throws Exception{
int _width = 0;
int _height = 0;
anywheresoftware.b4a.objects.LabelWrapper _lbllogo = null;
anywheresoftware.b4a.objects.LabelWrapper _lblsubtitle = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xvpin = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xvbtn = null;
anywheresoftware.b4a.objects.LabelWrapper _lblbiohint = null;
 //BA.debugLineNum = 683;BA.debugLine="Private Sub CreateLockScreen";
 //BA.debugLineNum = 684;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 685;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 688;BA.debugLine="pnlLock.Initialize(\"\")";
_pnllock.Initialize(ba,"");
 //BA.debugLineNum = 689;BA.debugLine="pnlLock.Color = ModTheme.HomeBg";
_pnllock.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 690;BA.debugLine="pnlLock.Visible = False";
_pnllock.setVisible(__c.False);
 //BA.debugLineNum = 691;BA.debugLine="Root.AddView(pnlLock, 0, 0, width, height)";
_root.AddView((android.view.View)(_pnllock.getObject()),(int) (0),(int) (0),_width,_height);
 //BA.debugLineNum = 694;BA.debugLine="Dim lblLogo As Label";
_lbllogo = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 695;BA.debugLine="lblLogo.Initialize(\"\")";
_lbllogo.Initialize(ba,"");
 //BA.debugLineNum = 696;BA.debugLine="lblLogo.Text = \"LockZero\"";
_lbllogo.setText(BA.ObjectToCharSequence("LockZero"));
 //BA.debugLineNum = 697;BA.debugLine="lblLogo.TextSize = 28";
_lbllogo.setTextSize((float) (28));
 //BA.debugLineNum = 698;BA.debugLine="lblLogo.TextColor = Colors.White";
_lbllogo.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 699;BA.debugLine="lblLogo.Gravity = Gravity.CENTER_HORIZONTAL";
_lbllogo.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 700;BA.debugLine="lblLogo.Typeface = Typeface.DEFAULT_BOLD";
_lbllogo.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 701;BA.debugLine="pnlLock.AddView(lblLogo, 0, 120dip, width, 40dip)";
_pnllock.AddView((android.view.View)(_lbllogo.getObject()),(int) (0),__c.DipToCurrent((int) (120)),_width,__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 704;BA.debugLine="Dim lblSubtitle As Label";
_lblsubtitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 705;BA.debugLine="lblSubtitle.Initialize(\"\")";
_lblsubtitle.Initialize(ba,"");
 //BA.debugLineNum = 706;BA.debugLine="lblSubtitle.Text = ModLang.T(\"pin_enter\")";
_lblsubtitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"pin_enter")));
 //BA.debugLineNum = 707;BA.debugLine="lblSubtitle.TextSize = 14";
_lblsubtitle.setTextSize((float) (14));
 //BA.debugLineNum = 708;BA.debugLine="lblSubtitle.TextColor = Colors.ARGB(180, 255, 255";
_lblsubtitle.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 709;BA.debugLine="lblSubtitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lblsubtitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 710;BA.debugLine="pnlLock.AddView(lblSubtitle, 0, 170dip, width, 30";
_pnllock.AddView((android.view.View)(_lblsubtitle.getObject()),(int) (0),__c.DipToCurrent((int) (170)),_width,__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 713;BA.debugLine="edtPinInput.Initialize(\"edtPinInput\")";
_edtpininput.Initialize(ba,"edtPinInput");
 //BA.debugLineNum = 714;BA.debugLine="edtPinInput.Hint = \"PIN\"";
_edtpininput.setHint("PIN");
 //BA.debugLineNum = 715;BA.debugLine="edtPinInput.InputType = Bit.Or(2, 8192) 'NUMBER +";
_edtpininput.setInputType(__c.Bit.Or((int) (2),(int) (8192)));
 //BA.debugLineNum = 716;BA.debugLine="edtPinInput.TextSize = 24";
_edtpininput.setTextSize((float) (24));
 //BA.debugLineNum = 717;BA.debugLine="edtPinInput.TextColor = Colors.White";
_edtpininput.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 718;BA.debugLine="edtPinInput.HintColor = Colors.ARGB(100, 255, 255";
_edtpininput.setHintColor(__c.Colors.ARGB((int) (100),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 719;BA.debugLine="edtPinInput.Gravity = Gravity.CENTER";
_edtpininput.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 720;BA.debugLine="Dim xvPin As B4XView = edtPinInput";
_xvpin = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvpin = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_edtpininput.getObject()));
 //BA.debugLineNum = 721;BA.debugLine="xvPin.SetColorAndBorder(Colors.ARGB(40, 255, 255,";
_xvpin.SetColorAndBorder(__c.Colors.ARGB((int) (40),(int) (255),(int) (255),(int) (255)),__c.DipToCurrent((int) (1)),__c.Colors.ARGB((int) (80),(int) (255),(int) (255),(int) (255)),__c.DipToCurrent((int) (8)));
 //BA.debugLineNum = 722;BA.debugLine="pnlLock.AddView(edtPinInput, width/2 - 100dip, 22";
_pnllock.AddView((android.view.View)(_edtpininput.getObject()),(int) (_width/(double)2-__c.DipToCurrent((int) (100))),__c.DipToCurrent((int) (220)),__c.DipToCurrent((int) (200)),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 725;BA.debugLine="lblPinError.Initialize(\"\")";
_lblpinerror.Initialize(ba,"");
 //BA.debugLineNum = 726;BA.debugLine="lblPinError.Text = \"\"";
_lblpinerror.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 727;BA.debugLine="lblPinError.TextSize = 12";
_lblpinerror.setTextSize((float) (12));
 //BA.debugLineNum = 728;BA.debugLine="lblPinError.TextColor = ModTheme.Danger";
_lblpinerror.setTextColor(_modtheme._danger /*int*/ (ba));
 //BA.debugLineNum = 729;BA.debugLine="lblPinError.Gravity = Gravity.CENTER_HORIZONTAL";
_lblpinerror.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 730;BA.debugLine="pnlLock.AddView(lblPinError, 0, 280dip, width, 25";
_pnllock.AddView((android.view.View)(_lblpinerror.getObject()),(int) (0),__c.DipToCurrent((int) (280)),_width,__c.DipToCurrent((int) (25)));
 //BA.debugLineNum = 733;BA.debugLine="btnPinSubmit.Initialize(\"btnPinSubmit\")";
_btnpinsubmit.Initialize(ba,"btnPinSubmit");
 //BA.debugLineNum = 734;BA.debugLine="btnPinSubmit.Text = ModLang.T(\"ok\")";
_btnpinsubmit.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"ok")));
 //BA.debugLineNum = 735;BA.debugLine="btnPinSubmit.TextSize = 16";
_btnpinsubmit.setTextSize((float) (16));
 //BA.debugLineNum = 736;BA.debugLine="btnPinSubmit.TextColor = Colors.White";
_btnpinsubmit.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 737;BA.debugLine="Dim xvBtn As B4XView = btnPinSubmit";
_xvbtn = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvbtn = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_btnpinsubmit.getObject()));
 //BA.debugLineNum = 738;BA.debugLine="xvBtn.SetColorAndBorder(ModTheme.Primary, 0, ModT";
_xvbtn.SetColorAndBorder(_modtheme._primary /*int*/ (ba),(int) (0),_modtheme._primary /*int*/ (ba),__c.DipToCurrent((int) (8)));
 //BA.debugLineNum = 739;BA.debugLine="pnlLock.AddView(btnPinSubmit, width/2 - 80dip, 32";
_pnllock.AddView((android.view.View)(_btnpinsubmit.getObject()),(int) (_width/(double)2-__c.DipToCurrent((int) (80))),__c.DipToCurrent((int) (320)),__c.DipToCurrent((int) (160)),__c.DipToCurrent((int) (48)));
 //BA.debugLineNum = 742;BA.debugLine="Dim lblBioHint As Label";
_lblbiohint = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 743;BA.debugLine="lblBioHint.Initialize(\"\")";
_lblbiohint.Initialize(ba,"");
 //BA.debugLineNum = 744;BA.debugLine="lblBioHint.Text = ModLang.T(\"biometric_or_pin\")";
_lblbiohint.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"biometric_or_pin")));
 //BA.debugLineNum = 745;BA.debugLine="lblBioHint.TextSize = 12";
_lblbiohint.setTextSize((float) (12));
 //BA.debugLineNum = 746;BA.debugLine="lblBioHint.TextColor = Colors.ARGB(120, 255, 255,";
_lblbiohint.setTextColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 747;BA.debugLine="lblBioHint.Gravity = Gravity.CENTER_HORIZONTAL";
_lblbiohint.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 748;BA.debugLine="pnlLock.AddView(lblBioHint, 0, 390dip, width, 25d";
_pnllock.AddView((android.view.View)(_lblbiohint.getObject()),(int) (0),__c.DipToCurrent((int) (390)),_width,__c.DipToCurrent((int) (25)));
 //BA.debugLineNum = 749;BA.debugLine="End Sub";
return "";
}
public String  _createmainpanel() throws Exception{
int _width = 0;
int _height = 0;
int _contentheight = 0;
 //BA.debugLineNum = 218;BA.debugLine="Private Sub CreateMainPanel";
 //BA.debugLineNum = 219;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 220;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 223;BA.debugLine="Root.Color = ModTheme.HomeBg";
_root.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 226;BA.debugLine="pnlHeader.Initialize(\"pnlHeader\")";
_pnlheader.Initialize(ba,"pnlHeader");
 //BA.debugLineNum = 227;BA.debugLine="pnlHeader.Color = ModTheme.HomeHeaderBg";
_pnlheader.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 228;BA.debugLine="Root.AddView(pnlHeader, 0, 0, width, HEADER_HEIGH";
_root.AddView((android.view.View)(_pnlheader.getObject()),(int) (0),(int) (0),_width,_header_height);
 //BA.debugLineNum = 229;BA.debugLine="CreateHeader";
_createheader();
 //BA.debugLineNum = 232;BA.debugLine="pnlFooter.Initialize(\"\")";
_pnlfooter.Initialize(ba,"");
 //BA.debugLineNum = 233;BA.debugLine="pnlFooter.Color = ModTheme.HomeBg";
_pnlfooter.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 234;BA.debugLine="Root.AddView(pnlFooter, 0, height - FOOTER_HEIGHT";
_root.AddView((android.view.View)(_pnlfooter.getObject()),(int) (0),(int) (_height-_footer_height),_width,_footer_height);
 //BA.debugLineNum = 235;BA.debugLine="CreateFooter";
_createfooter();
 //BA.debugLineNum = 238;BA.debugLine="Dim contentHeight As Int = height - HEADER_HEIGHT";
_contentheight = (int) (_height-_header_height-_footer_height);
 //BA.debugLineNum = 239;BA.debugLine="pnlContent.Initialize(\"\")";
_pnlcontent.Initialize(ba,"");
 //BA.debugLineNum = 240;BA.debugLine="pnlContent.Color = ModTheme.HomeBg";
_pnlcontent.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 241;BA.debugLine="Root.AddView(pnlContent, 0, HEADER_HEIGHT, width,";
_root.AddView((android.view.View)(_pnlcontent.getObject()),(int) (0),_header_height,_width,_contentheight);
 //BA.debugLineNum = 242;BA.debugLine="End Sub";
return "";
}
public String  _createsidemenu() throws Exception{
int _width = 0;
int _height = 0;
int _menuw = 0;
 //BA.debugLineNum = 95;BA.debugLine="Private Sub CreateSideMenu";
 //BA.debugLineNum = 96;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 97;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 98;BA.debugLine="Dim menuW As Int = width * 0.70 '70% da largura";
_menuw = (int) (_width*0.70);
 //BA.debugLineNum = 101;BA.debugLine="pnlMenuOverlay.Initialize(\"pnlMenuOverlay\")";
_pnlmenuoverlay.Initialize(ba,"pnlMenuOverlay");
 //BA.debugLineNum = 102;BA.debugLine="pnlMenuOverlay.Color = Colors.ARGB(150, 0, 0, 0)";
_pnlmenuoverlay.setColor(__c.Colors.ARGB((int) (150),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 103;BA.debugLine="pnlMenuOverlay.Visible = False";
_pnlmenuoverlay.setVisible(__c.False);
 //BA.debugLineNum = 104;BA.debugLine="Root.AddView(pnlMenuOverlay, 0, 0, width, height)";
_root.AddView((android.view.View)(_pnlmenuoverlay.getObject()),(int) (0),(int) (0),_width,_height);
 //BA.debugLineNum = 107;BA.debugLine="pnlMenu.Initialize(\"pnlMenu\")";
_pnlmenu.Initialize(ba,"pnlMenu");
 //BA.debugLineNum = 108;BA.debugLine="pnlMenu.Color = ModTheme.HomeBg";
_pnlmenu.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 109;BA.debugLine="Root.AddView(pnlMenu, -menuW, 0, menuW, height)";
_root.AddView((android.view.View)(_pnlmenu.getObject()),(int) (-_menuw),(int) (0),_menuw,_height);
 //BA.debugLineNum = 111;BA.debugLine="svMenu.Initialize(0)";
_svmenu.Initialize(ba,(int) (0));
 //BA.debugLineNum = 112;BA.debugLine="svMenu.Color = ModTheme.HomeBg";
_svmenu.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 113;BA.debugLine="pnlMenu.AddView(svMenu, 0, 0, menuW, height)";
_pnlmenu.AddView((android.view.View)(_svmenu.getObject()),(int) (0),(int) (0),_menuw,_height);
 //BA.debugLineNum = 115;BA.debugLine="RebuildMenuItems";
_rebuildmenuitems();
 //BA.debugLineNum = 116;BA.debugLine="End Sub";
return "";
}
public String  _edtpininput_enterpressed() throws Exception{
 //BA.debugLineNum = 813;BA.debugLine="Private Sub edtPinInput_EnterPressed";
 //BA.debugLineNum = 814;BA.debugLine="btnPinSubmit_Click";
_btnpinsubmit_click();
 //BA.debugLineNum = 815;BA.debugLine="End Sub";
return "";
}
public String  _hidelockscreen() throws Exception{
 //BA.debugLineNum = 770;BA.debugLine="Private Sub HideLockScreen";
 //BA.debugLineNum = 771;BA.debugLine="IsAuthenticated = True";
_isauthenticated = __c.True;
 //BA.debugLineNum = 772;BA.debugLine="pnlLock.Visible = False";
_pnllock.setVisible(__c.False);
 //BA.debugLineNum = 775;BA.debugLine="RebuildMenuItems";
_rebuildmenuitems();
 //BA.debugLineNum = 776;BA.debugLine="ShowHome";
_showhome();
 //BA.debugLineNum = 777;BA.debugLine="RefreshFooter";
_refreshfooter();
 //BA.debugLineNum = 778;BA.debugLine="UpdateSessionDisplay";
_updatesessiondisplay();
 //BA.debugLineNum = 779;BA.debugLine="If ModSession.IsSessionActive Then";
if (_modsession._issessionactive /*boolean*/ (ba)) { 
 //BA.debugLineNum = 780;BA.debugLine="tmrSession.Enabled = True";
_tmrsession.setEnabled(__c.True);
 };
 //BA.debugLineNum = 782;BA.debugLine="End Sub";
return "";
}
public String  _hidemenu() throws Exception{
 //BA.debugLineNum = 202;BA.debugLine="Private Sub HideMenu";
 //BA.debugLineNum = 203;BA.debugLine="If MenuVisible Then";
if (_menuvisible) { 
 //BA.debugLineNum = 204;BA.debugLine="pnlMenuOverlay.Visible = False";
_pnlmenuoverlay.setVisible(__c.False);
 //BA.debugLineNum = 205;BA.debugLine="pnlMenu.SetLayoutAnimated(200, -pnlMenu.Width, p";
_pnlmenu.SetLayoutAnimated((int) (200),(int) (-_pnlmenu.getWidth()),_pnlmenu.getTop(),_pnlmenu.getWidth(),_pnlmenu.getHeight());
 //BA.debugLineNum = 206;BA.debugLine="MenuVisible = False";
_menuvisible = __c.False;
 };
 //BA.debugLineNum = 208;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 44;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 45;BA.debugLine="tmrSession.Initialize(\"tmrSession\", 1000)";
_tmrsession.Initialize(ba,"tmrSession",(long) (1000));
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
return "";
}
public void  _lblsessiontimer_click() throws Exception{
ResumableSub_lblSessionTimer_Click rsub = new ResumableSub_lblSessionTimer_Click(this);
rsub.resume(ba, null);
}
public static class ResumableSub_lblSessionTimer_Click extends BA.ResumableSub {
public ResumableSub_lblSessionTimer_Click(com.lockzero.b4xmainpage parent) {
this.parent = parent;
}
com.lockzero.b4xmainpage parent;
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
 //BA.debugLineNum = 666;BA.debugLine="If ModSession.IsSessionActive = False Then Return";
if (true) break;

case 1:
//if
this.state = 6;
if (parent._modsession._issessionactive /*boolean*/ (ba)==parent.__c.False) { 
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
 //BA.debugLineNum = 668;BA.debugLine="Wait For (xui.Msgbox2Async(ModLang.T(\"lock_confir";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"lock_confirm_msg")),BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"lock")),parent._modlang._t /*String*/ (ba,"yes"),"",parent._modlang._t /*String*/ (ba,"cancel"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 11;
return;
case 11:
//C
this.state = 7;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 670;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
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
 //BA.debugLineNum = 671;BA.debugLine="ModSession.Lock";
parent._modsession._lock /*String*/ (ba);
 //BA.debugLineNum = 672;BA.debugLine="tmrSession.Enabled = False";
parent._tmrsession.setEnabled(parent.__c.False);
 //BA.debugLineNum = 673;BA.debugLine="lblSessionTimer.Text = \"\"";
parent._lblsessiontimer.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 674;BA.debugLine="ToastMessageShow(ModLang.T(\"locked\"), False)";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"locked")),parent.__c.False);
 if (true) break;

case 10:
//C
this.state = -1;
;
 //BA.debugLineNum = 676;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _mnubackup_click() throws Exception{
com.lockzero.pagebackup _pg = null;
 //BA.debugLineNum = 448;BA.debugLine="Private Sub mnuBackup_Click";
 //BA.debugLineNum = 449;BA.debugLine="HideMenu";
_hidemenu();
 //BA.debugLineNum = 450;BA.debugLine="Dim pg As PageBackup = B4XPages.GetPage(\"PageBack";
_pg = (com.lockzero.pagebackup)(_b4xpages._getpage /*Object*/ (ba,"PageBackup"));
 //BA.debugLineNum = 451;BA.debugLine="ModTransition.SlideToLeft(Root, pg.Root)";
_modtransition._slidetoleft /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (ba,_root,_pg._root /*anywheresoftware.b4a.objects.B4XViewWrapper*/ );
 //BA.debugLineNum = 452;BA.debugLine="B4XPages.ShowPage(\"PageBackup\")";
_b4xpages._showpage /*String*/ (ba,"PageBackup");
 //BA.debugLineNum = 453;BA.debugLine="End Sub";
return "";
}
public String  _mnucards_click() throws Exception{
 //BA.debugLineNum = 426;BA.debugLine="Private Sub mnuCards_Click";
 //BA.debugLineNum = 427;BA.debugLine="HideMenu";
_hidemenu();
 //BA.debugLineNum = 428;BA.debugLine="ToastMessageShow(ModLang.T(\"cards\") & \" - \" & Mod";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cards")+" - "+_modlang._t /*String*/ (ba,"loading")),__c.False);
 //BA.debugLineNum = 429;BA.debugLine="End Sub";
return "";
}
public String  _mnudocuments_click() throws Exception{
 //BA.debugLineNum = 431;BA.debugLine="Private Sub mnuDocuments_Click";
 //BA.debugLineNum = 432;BA.debugLine="HideMenu";
_hidemenu();
 //BA.debugLineNum = 433;BA.debugLine="ToastMessageShow(ModLang.T(\"documents\") & \" - \" &";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"documents")+" - "+_modlang._t /*String*/ (ba,"loading")),__c.False);
 //BA.debugLineNum = 434;BA.debugLine="End Sub";
return "";
}
public String  _mnuimportcsv_click() throws Exception{
 //BA.debugLineNum = 455;BA.debugLine="Private Sub mnuImportCSV_Click";
 //BA.debugLineNum = 456;BA.debugLine="HideMenu";
_hidemenu();
 //BA.debugLineNum = 457;BA.debugLine="ShowImportCSVInstructions";
_showimportcsvinstructions();
 //BA.debugLineNum = 458;BA.debugLine="End Sub";
return "";
}
public String  _mnunotes_click() throws Exception{
 //BA.debugLineNum = 436;BA.debugLine="Private Sub mnuNotes_Click";
 //BA.debugLineNum = 437;BA.debugLine="HideMenu";
_hidemenu();
 //BA.debugLineNum = 438;BA.debugLine="NavigateToNotes";
_navigatetonotes();
 //BA.debugLineNum = 439;BA.debugLine="End Sub";
return "";
}
public String  _mnupasswords_click() throws Exception{
com.lockzero.pagepasswords _pg = null;
 //BA.debugLineNum = 419;BA.debugLine="Private Sub mnuPasswords_Click";
 //BA.debugLineNum = 420;BA.debugLine="HideMenu";
_hidemenu();
 //BA.debugLineNum = 421;BA.debugLine="Dim pg As PagePasswords = B4XPages.GetPage(\"PageP";
_pg = (com.lockzero.pagepasswords)(_b4xpages._getpage /*Object*/ (ba,"PagePasswords"));
 //BA.debugLineNum = 422;BA.debugLine="ModTransition.SlideToLeft(Root, pg.Root)";
_modtransition._slidetoleft /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (ba,_root,_pg._root /*anywheresoftware.b4a.objects.B4XViewWrapper*/ );
 //BA.debugLineNum = 423;BA.debugLine="B4XPages.ShowPage(\"PagePasswords\")";
_b4xpages._showpage /*String*/ (ba,"PagePasswords");
 //BA.debugLineNum = 424;BA.debugLine="End Sub";
return "";
}
public String  _mnusettings_click() throws Exception{
com.lockzero.pagesettings _pg = null;
 //BA.debugLineNum = 441;BA.debugLine="Private Sub mnuSettings_Click";
 //BA.debugLineNum = 442;BA.debugLine="HideMenu";
_hidemenu();
 //BA.debugLineNum = 443;BA.debugLine="Dim pg As PageSettings = B4XPages.GetPage(\"PageSe";
_pg = (com.lockzero.pagesettings)(_b4xpages._getpage /*Object*/ (ba,"PageSettings"));
 //BA.debugLineNum = 444;BA.debugLine="ModTransition.SlideToLeft(Root, pg.Root)";
_modtransition._slidetoleft /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (ba,_root,_pg._root /*anywheresoftware.b4a.objects.B4XViewWrapper*/ );
 //BA.debugLineNum = 445;BA.debugLine="B4XPages.ShowPage(\"PageSettings\")";
_b4xpages._showpage /*String*/ (ba,"PageSettings");
 //BA.debugLineNum = 446;BA.debugLine="End Sub";
return "";
}
public String  _navigatetonotes() throws Exception{
com.lockzero.pagenotesgroups _pg = null;
 //BA.debugLineNum = 622;BA.debugLine="Private Sub NavigateToNotes";
 //BA.debugLineNum = 624;BA.debugLine="Dim pg As PageNotesGroups = B4XPages.GetPage(\"Pag";
_pg = (com.lockzero.pagenotesgroups)(_b4xpages._getpage /*Object*/ (ba,"PageNotesGroups"));
 //BA.debugLineNum = 627;BA.debugLine="ModTransition.SlideToLeft(Root, pg.Root)";
_modtransition._slidetoleft /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (ba,_root,_pg._root /*anywheresoftware.b4a.objects.B4XViewWrapper*/ );
 //BA.debugLineNum = 628;BA.debugLine="B4XPages.ShowPage(\"PageNotesGroups\")";
_b4xpages._showpage /*String*/ (ba,"PageNotesGroups");
 //BA.debugLineNum = 629;BA.debugLine="End Sub";
return "";
}
public String  _pnlbackup_click() throws Exception{
 //BA.debugLineNum = 573;BA.debugLine="Private Sub pnlBackup_Click";
 //BA.debugLineNum = 574;BA.debugLine="HideMenu";
_hidemenu();
 //BA.debugLineNum = 575;BA.debugLine="AnimatePulseAndNavigate(Sender, \"PageBackup\")";
_animatepulseandnavigate((anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(__c.Sender(ba))),"PageBackup");
 //BA.debugLineNum = 576;BA.debugLine="End Sub";
return "";
}
public void  _pnlcards_click() throws Exception{
ResumableSub_pnlCards_Click rsub = new ResumableSub_pnlCards_Click(this);
rsub.resume(ba, null);
}
public static class ResumableSub_pnlCards_Click extends BA.ResumableSub {
public ResumableSub_pnlCards_Click(com.lockzero.b4xmainpage parent) {
this.parent = parent;
}
com.lockzero.b4xmainpage parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 //BA.debugLineNum = 555;BA.debugLine="HideMenu";
parent._hidemenu();
 //BA.debugLineNum = 556;BA.debugLine="AnimatePulse(Sender)";
parent._animatepulse((anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(parent.__c.Sender(ba))));
 //BA.debugLineNum = 557;BA.debugLine="Sleep(250)";
parent.__c.Sleep(ba,this,(int) (250));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 558;BA.debugLine="ToastMessageShow(ModLang.T(\"cards\") & \" - \" & Mod";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"cards")+" - "+parent._modlang._t /*String*/ (ba,"loading")),parent.__c.False);
 //BA.debugLineNum = 559;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _pnlcsvoverlay_click() throws Exception{
 //BA.debugLineNum = 528;BA.debugLine="Private Sub pnlCSVOverlay_Click";
 //BA.debugLineNum = 530;BA.debugLine="CloseCSVDialog";
_closecsvdialog();
 //BA.debugLineNum = 531;BA.debugLine="End Sub";
return "";
}
public void  _pnldocuments_click() throws Exception{
ResumableSub_pnlDocuments_Click rsub = new ResumableSub_pnlDocuments_Click(this);
rsub.resume(ba, null);
}
public static class ResumableSub_pnlDocuments_Click extends BA.ResumableSub {
public ResumableSub_pnlDocuments_Click(com.lockzero.b4xmainpage parent) {
this.parent = parent;
}
com.lockzero.b4xmainpage parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 //BA.debugLineNum = 562;BA.debugLine="HideMenu";
parent._hidemenu();
 //BA.debugLineNum = 563;BA.debugLine="AnimatePulse(Sender)";
parent._animatepulse((anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(parent.__c.Sender(ba))));
 //BA.debugLineNum = 564;BA.debugLine="Sleep(250)";
parent.__c.Sleep(ba,this,(int) (250));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 565;BA.debugLine="ToastMessageShow(ModLang.T(\"documents\") & \" - \" &";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"documents")+" - "+parent._modlang._t /*String*/ (ba,"loading")),parent.__c.False);
 //BA.debugLineNum = 566;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _pnlmenu_click() throws Exception{
 //BA.debugLineNum = 415;BA.debugLine="Private Sub pnlMenu_Click";
 //BA.debugLineNum = 417;BA.debugLine="End Sub";
return "";
}
public String  _pnlmenuoverlay_click() throws Exception{
 //BA.debugLineNum = 210;BA.debugLine="Private Sub pnlMenuOverlay_Click";
 //BA.debugLineNum = 211;BA.debugLine="HideMenu";
_hidemenu();
 //BA.debugLineNum = 212;BA.debugLine="End Sub";
return "";
}
public String  _pnlnotes_click() throws Exception{
 //BA.debugLineNum = 568;BA.debugLine="Private Sub pnlNotes_Click";
 //BA.debugLineNum = 569;BA.debugLine="HideMenu";
_hidemenu();
 //BA.debugLineNum = 570;BA.debugLine="AnimatePulseAndNavigateNotes(Sender)";
_animatepulseandnavigatenotes((anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(__c.Sender(ba))));
 //BA.debugLineNum = 571;BA.debugLine="End Sub";
return "";
}
public String  _pnlpasswords_click() throws Exception{
 //BA.debugLineNum = 549;BA.debugLine="Private Sub pnlPasswords_Click";
 //BA.debugLineNum = 550;BA.debugLine="HideMenu";
_hidemenu();
 //BA.debugLineNum = 551;BA.debugLine="AnimatePulseAndNavigate(Sender, \"PagePasswords\")";
_animatepulseandnavigate((anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(__c.Sender(ba))),"PagePasswords");
 //BA.debugLineNum = 552;BA.debugLine="End Sub";
return "";
}
public String  _rebuildmenuitems() throws Exception{
int _menuw = 0;
int _top = 0;
anywheresoftware.b4a.objects.PanelWrapper _pnlmenuheader = null;
anywheresoftware.b4a.objects.LabelWrapper _lblmenutitle = null;
int _btnw = 0;
int _btnh = 0;
int _gap = 0;
anywheresoftware.b4a.objects.PanelWrapper _pnlsep = null;
 //BA.debugLineNum = 118;BA.debugLine="Public Sub RebuildMenuItems";
 //BA.debugLineNum = 119;BA.debugLine="svMenu.Panel.RemoveAllViews";
_svmenu.getPanel().RemoveAllViews();
 //BA.debugLineNum = 120;BA.debugLine="svMenu.Panel.Color = ModTheme.HomeBg";
_svmenu.getPanel().setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 122;BA.debugLine="Dim menuW As Int = pnlMenu.Width";
_menuw = _pnlmenu.getWidth();
 //BA.debugLineNum = 123;BA.debugLine="Dim top As Int = 0";
_top = (int) (0);
 //BA.debugLineNum = 126;BA.debugLine="Dim pnlMenuHeader As Panel";
_pnlmenuheader = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 127;BA.debugLine="pnlMenuHeader.Initialize(\"\")";
_pnlmenuheader.Initialize(ba,"");
 //BA.debugLineNum = 128;BA.debugLine="pnlMenuHeader.Color = ModTheme.HomeHeaderBg";
_pnlmenuheader.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 129;BA.debugLine="svMenu.Panel.AddView(pnlMenuHeader, 0, top, menuW";
_svmenu.getPanel().AddView((android.view.View)(_pnlmenuheader.getObject()),(int) (0),_top,_menuw,__c.DipToCurrent((int) (80)));
 //BA.debugLineNum = 131;BA.debugLine="Dim lblMenuTitle As Label";
_lblmenutitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 132;BA.debugLine="lblMenuTitle.Initialize(\"\")";
_lblmenutitle.Initialize(ba,"");
 //BA.debugLineNum = 133;BA.debugLine="lblMenuTitle.Text = Starter.APP_NAME";
_lblmenutitle.setText(BA.ObjectToCharSequence(_starter._app_name /*String*/ ));
 //BA.debugLineNum = 134;BA.debugLine="lblMenuTitle.TextSize = 22";
_lblmenutitle.setTextSize((float) (22));
 //BA.debugLineNum = 135;BA.debugLine="lblMenuTitle.TextColor = Colors.White";
_lblmenutitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 136;BA.debugLine="lblMenuTitle.Gravity = Gravity.CENTER_VERTICAL";
_lblmenutitle.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 137;BA.debugLine="lblMenuTitle.Typeface = Typeface.DEFAULT_BOLD";
_lblmenutitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 138;BA.debugLine="pnlMenuHeader.AddView(lblMenuTitle, 20dip, 0, men";
_pnlmenuheader.AddView((android.view.View)(_lblmenutitle.getObject()),__c.DipToCurrent((int) (20)),(int) (0),(int) (_menuw-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (80)));
 //BA.debugLineNum = 139;BA.debugLine="top = top + 80dip + 16dip";
_top = (int) (_top+__c.DipToCurrent((int) (80))+__c.DipToCurrent((int) (16)));
 //BA.debugLineNum = 141;BA.debugLine="Dim btnW As Int = menuW - 32dip";
_btnw = (int) (_menuw-__c.DipToCurrent((int) (32)));
 //BA.debugLineNum = 142;BA.debugLine="Dim btnH As Int = 48dip";
_btnh = __c.DipToCurrent((int) (48));
 //BA.debugLineNum = 143;BA.debugLine="Dim gap As Int = 4dip";
_gap = __c.DipToCurrent((int) (4));
 //BA.debugLineNum = 146;BA.debugLine="AddMenuButton(ModLang.T(\"passwords\"), \"mnuPasswor";
_addmenubutton(_modlang._t /*String*/ (ba,"passwords"),"mnuPasswords",_top,_btnw,_btnh);
 //BA.debugLineNum = 147;BA.debugLine="top = top + btnH + gap";
_top = (int) (_top+_btnh+_gap);
 //BA.debugLineNum = 149;BA.debugLine="AddMenuButton(ModLang.T(\"cards\"), \"mnuCards\", top";
_addmenubutton(_modlang._t /*String*/ (ba,"cards"),"mnuCards",_top,_btnw,_btnh);
 //BA.debugLineNum = 150;BA.debugLine="top = top + btnH + gap";
_top = (int) (_top+_btnh+_gap);
 //BA.debugLineNum = 152;BA.debugLine="AddMenuButton(ModLang.T(\"documents\"), \"mnuDocumen";
_addmenubutton(_modlang._t /*String*/ (ba,"documents"),"mnuDocuments",_top,_btnw,_btnh);
 //BA.debugLineNum = 153;BA.debugLine="top = top + btnH + gap";
_top = (int) (_top+_btnh+_gap);
 //BA.debugLineNum = 155;BA.debugLine="AddMenuButton(ModLang.T(\"notes\"), \"mnuNotes\", top";
_addmenubutton(_modlang._t /*String*/ (ba,"notes"),"mnuNotes",_top,_btnw,_btnh);
 //BA.debugLineNum = 156;BA.debugLine="top = top + btnH + 16dip";
_top = (int) (_top+_btnh+__c.DipToCurrent((int) (16)));
 //BA.debugLineNum = 159;BA.debugLine="Dim pnlSep As Panel";
_pnlsep = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 160;BA.debugLine="pnlSep.Initialize(\"\")";
_pnlsep.Initialize(ba,"");
 //BA.debugLineNum = 161;BA.debugLine="pnlSep.Color = Colors.ARGB(60, 255, 255, 255)";
_pnlsep.setColor(__c.Colors.ARGB((int) (60),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 162;BA.debugLine="svMenu.Panel.AddView(pnlSep, 16dip, top, btnW, 1d";
_svmenu.getPanel().AddView((android.view.View)(_pnlsep.getObject()),__c.DipToCurrent((int) (16)),_top,_btnw,__c.DipToCurrent((int) (1)));
 //BA.debugLineNum = 163;BA.debugLine="top = top + 16dip";
_top = (int) (_top+__c.DipToCurrent((int) (16)));
 //BA.debugLineNum = 165;BA.debugLine="AddMenuButton(ModLang.T(\"settings\"), \"mnuSettings";
_addmenubutton(_modlang._t /*String*/ (ba,"settings"),"mnuSettings",_top,_btnw,_btnh);
 //BA.debugLineNum = 166;BA.debugLine="top = top + btnH + gap";
_top = (int) (_top+_btnh+_gap);
 //BA.debugLineNum = 168;BA.debugLine="AddMenuButton(ModLang.T(\"backup\"), \"mnuBackup\", t";
_addmenubutton(_modlang._t /*String*/ (ba,"backup"),"mnuBackup",_top,_btnw,_btnh);
 //BA.debugLineNum = 169;BA.debugLine="top = top + btnH + gap";
_top = (int) (_top+_btnh+_gap);
 //BA.debugLineNum = 171;BA.debugLine="AddMenuButton(ModLang.T(\"import_csv\"), \"mnuImport";
_addmenubutton(_modlang._t /*String*/ (ba,"import_csv"),"mnuImportCSV",_top,_btnw,_btnh);
 //BA.debugLineNum = 172;BA.debugLine="top = top + btnH + gap";
_top = (int) (_top+_btnh+_gap);
 //BA.debugLineNum = 174;BA.debugLine="svMenu.Panel.Height = top + 50dip";
_svmenu.getPanel().setHeight((int) (_top+__c.DipToCurrent((int) (50))));
 //BA.debugLineNum = 175;BA.debugLine="End Sub";
return "";
}
public String  _refreshfooter() throws Exception{
 //BA.debugLineNum = 319;BA.debugLine="Private Sub RefreshFooter";
 //BA.debugLineNum = 320;BA.debugLine="pnlFooter.RemoveAllViews";
_pnlfooter.RemoveAllViews();
 //BA.debugLineNum = 321;BA.debugLine="CreateFooter";
_createfooter();
 //BA.debugLineNum = 322;BA.debugLine="End Sub";
return "";
}
public String  _showhome() throws Exception{
int _width = 0;
int _contentheight = 0;
int _availablewidth = 0;
int _cardsize = 0;
int _gridheight = 0;
int _starty = 0;
int _row2y = 0;
 //BA.debugLineNum = 328;BA.debugLine="Private Sub ShowHome";
 //BA.debugLineNum = 329;BA.debugLine="pnlContent.RemoveAllViews";
_pnlcontent.RemoveAllViews();
 //BA.debugLineNum = 331;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 332;BA.debugLine="Dim contentHeight As Int = pnlContent.Height";
_contentheight = _pnlcontent.getHeight();
 //BA.debugLineNum = 335;BA.debugLine="Dim availableWidth As Int = width - (GRID_MARGIN";
_availablewidth = (int) (_width-(_grid_margin*2)-_grid_gap);
 //BA.debugLineNum = 336;BA.debugLine="Dim cardSize As Int = availableWidth / 2";
_cardsize = (int) (_availablewidth/(double)2);
 //BA.debugLineNum = 339;BA.debugLine="Dim gridHeight As Int = (cardSize * 2) + GRID_GAP";
_gridheight = (int) ((_cardsize*2)+_grid_gap);
 //BA.debugLineNum = 340;BA.debugLine="Dim startY As Int = (contentHeight - gridHeight)";
_starty = (int) ((_contentheight-_gridheight)/(double)2);
 //BA.debugLineNum = 343;BA.debugLine="CreateHomeCard(\"pnlPasswords\", ModLang.T(\"passwor";
_createhomecard("pnlPasswords",_modlang._t /*String*/ (ba,"passwords"),"ic_senha.png",_grid_margin,_starty,_cardsize);
 //BA.debugLineNum = 344;BA.debugLine="CreateHomeCard(\"pnlCards\", ModLang.T(\"cards\"), \"i";
_createhomecard("pnlCards",_modlang._t /*String*/ (ba,"cards"),"ic_cartao.png",(int) (_grid_margin+_cardsize+_grid_gap),_starty,_cardsize);
 //BA.debugLineNum = 347;BA.debugLine="Dim row2Y As Int = startY + cardSize + GRID_GAP";
_row2y = (int) (_starty+_cardsize+_grid_gap);
 //BA.debugLineNum = 348;BA.debugLine="CreateHomeCard(\"pnlDocuments\", ModLang.T(\"documen";
_createhomecard("pnlDocuments",_modlang._t /*String*/ (ba,"documents"),"ic_doc.png",_grid_margin,_row2y,_cardsize);
 //BA.debugLineNum = 349;BA.debugLine="CreateHomeCard(\"pnlNotes\", ModLang.T(\"notes\"), \"i";
_createhomecard("pnlNotes",_modlang._t /*String*/ (ba,"notes"),"ic_notas.png",(int) (_grid_margin+_cardsize+_grid_gap),_row2y,_cardsize);
 //BA.debugLineNum = 350;BA.debugLine="End Sub";
return "";
}
public String  _showimportcsvinstructions() throws Exception{
int _width = 0;
int _height = 0;
int _dialogw = 0;
int _dialogh = 0;
anywheresoftware.b4a.objects.PanelWrapper _pnldialog = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xvdialog = null;
int _y = 0;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
anywheresoftware.b4a.objects.collections.List _instructions = null;
String _instruction = "";
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
anywheresoftware.b4a.objects.ButtonWrapper _btnok = null;
 //BA.debugLineNum = 461;BA.debugLine="Private Sub ShowImportCSVInstructions";
 //BA.debugLineNum = 462;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 463;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 466;BA.debugLine="pnlCSVOverlay.Initialize(\"pnlCSVOverlay\")";
_pnlcsvoverlay.Initialize(ba,"pnlCSVOverlay");
 //BA.debugLineNum = 467;BA.debugLine="pnlCSVOverlay.Color = Colors.ARGB(180, 0, 0, 0)";
_pnlcsvoverlay.setColor(__c.Colors.ARGB((int) (180),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 468;BA.debugLine="Root.AddView(pnlCSVOverlay, 0, 0, width, height)";
_root.AddView((android.view.View)(_pnlcsvoverlay.getObject()),(int) (0),(int) (0),_width,_height);
 //BA.debugLineNum = 471;BA.debugLine="Dim dialogW As Int = width - 32dip";
_dialogw = (int) (_width-__c.DipToCurrent((int) (32)));
 //BA.debugLineNum = 472;BA.debugLine="Dim dialogH As Int = 300dip";
_dialogh = __c.DipToCurrent((int) (300));
 //BA.debugLineNum = 473;BA.debugLine="Dim pnlDialog As Panel";
_pnldialog = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 474;BA.debugLine="pnlDialog.Initialize(\"\")";
_pnldialog.Initialize(ba,"");
 //BA.debugLineNum = 475;BA.debugLine="pnlDialog.Color = ModTheme.HomeHeaderBg";
_pnldialog.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 476;BA.debugLine="pnlCSVOverlay.AddView(pnlDialog, 16dip, 60dip, di";
_pnlcsvoverlay.AddView((android.view.View)(_pnldialog.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (60)),_dialogw,_dialogh);
 //BA.debugLineNum = 478;BA.debugLine="Dim xvDialog As B4XView = pnlDialog";
_xvdialog = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvdialog = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnldialog.getObject()));
 //BA.debugLineNum = 479;BA.debugLine="xvDialog.SetColorAndBorder(ModTheme.HomeHeaderBg,";
_xvdialog.SetColorAndBorder(_modtheme._homeheaderbg /*int*/ (ba),(int) (0),_modtheme._homeheaderbg /*int*/ (ba),__c.DipToCurrent((int) (12)));
 //BA.debugLineNum = 481;BA.debugLine="Dim y As Int = 12dip";
_y = __c.DipToCurrent((int) (12));
 //BA.debugLineNum = 484;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 485;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 486;BA.debugLine="lblTitle.Text = ModLang.T(\"csv_how_to_title\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"csv_how_to_title")));
 //BA.debugLineNum = 487;BA.debugLine="lblTitle.TextSize = 16";
_lbltitle.setTextSize((float) (16));
 //BA.debugLineNum = 488;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 489;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 490;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 491;BA.debugLine="pnlDialog.AddView(lblTitle, 0, y, dialogW, 26dip)";
_pnldialog.AddView((android.view.View)(_lbltitle.getObject()),(int) (0),_y,_dialogw,__c.DipToCurrent((int) (26)));
 //BA.debugLineNum = 492;BA.debugLine="y = y + 35dip";
_y = (int) (_y+__c.DipToCurrent((int) (35)));
 //BA.debugLineNum = 495;BA.debugLine="Dim instructions As List";
_instructions = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 496;BA.debugLine="instructions.Initialize";
_instructions.Initialize();
 //BA.debugLineNum = 497;BA.debugLine="instructions.Add(ModLang.T(\"csv_how_to_1\"))";
_instructions.Add((Object)(_modlang._t /*String*/ (ba,"csv_how_to_1")));
 //BA.debugLineNum = 498;BA.debugLine="instructions.Add(ModLang.T(\"csv_how_to_2\"))";
_instructions.Add((Object)(_modlang._t /*String*/ (ba,"csv_how_to_2")));
 //BA.debugLineNum = 499;BA.debugLine="instructions.Add(ModLang.T(\"csv_how_to_3\"))";
_instructions.Add((Object)(_modlang._t /*String*/ (ba,"csv_how_to_3")));
 //BA.debugLineNum = 500;BA.debugLine="instructions.Add(ModLang.T(\"csv_how_to_4\"))";
_instructions.Add((Object)(_modlang._t /*String*/ (ba,"csv_how_to_4")));
 //BA.debugLineNum = 501;BA.debugLine="instructions.Add(ModLang.T(\"csv_how_to_5\"))";
_instructions.Add((Object)(_modlang._t /*String*/ (ba,"csv_how_to_5")));
 //BA.debugLineNum = 503;BA.debugLine="For Each instruction As String In instructions";
{
final anywheresoftware.b4a.BA.IterableList group31 = _instructions;
final int groupLen31 = group31.getSize()
;int index31 = 0;
;
for (; index31 < groupLen31;index31++){
_instruction = BA.ObjectToString(group31.Get(index31));
 //BA.debugLineNum = 504;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 505;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(ba,"");
 //BA.debugLineNum = 506;BA.debugLine="lbl.Text = instruction";
_lbl.setText(BA.ObjectToCharSequence(_instruction));
 //BA.debugLineNum = 507;BA.debugLine="lbl.TextSize = 13";
_lbl.setTextSize((float) (13));
 //BA.debugLineNum = 508;BA.debugLine="lbl.TextColor = Colors.ARGB(220, 255, 255, 255)";
_lbl.setTextColor(__c.Colors.ARGB((int) (220),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 509;BA.debugLine="lbl.Gravity = Gravity.CENTER_VERTICAL";
_lbl.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 510;BA.debugLine="pnlDialog.AddView(lbl, 16dip, y, dialogW - 32dip";
_pnldialog.AddView((android.view.View)(_lbl.getObject()),__c.DipToCurrent((int) (16)),_y,(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (36)));
 //BA.debugLineNum = 511;BA.debugLine="y = y + 36dip";
_y = (int) (_y+__c.DipToCurrent((int) (36)));
 }
};
 //BA.debugLineNum = 514;BA.debugLine="y = y + 15dip";
_y = (int) (_y+__c.DipToCurrent((int) (15)));
 //BA.debugLineNum = 517;BA.debugLine="Dim btnOk As Button";
_btnok = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 518;BA.debugLine="btnOk.Initialize(\"btnCancelCSV\")";
_btnok.Initialize(ba,"btnCancelCSV");
 //BA.debugLineNum = 519;BA.debugLine="btnOk.Text = ModLang.T(\"understood\")";
_btnok.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"understood")));
 //BA.debugLineNum = 520;BA.debugLine="btnOk.TextSize = 14";
_btnok.setTextSize((float) (14));
 //BA.debugLineNum = 521;BA.debugLine="btnOk.Color = ModTheme.HomeIconBg";
_btnok.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 522;BA.debugLine="btnOk.TextColor = Colors.White";
_btnok.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 523;BA.debugLine="pnlDialog.AddView(btnOk, (dialogW - 120dip) / 2,";
_pnldialog.AddView((android.view.View)(_btnok.getObject()),(int) ((_dialogw-__c.DipToCurrent((int) (120)))/(double)2),_y,__c.DipToCurrent((int) (120)),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 525;BA.debugLine="pnlCSVOverlay.BringToFront";
_pnlcsvoverlay.BringToFront();
 //BA.debugLineNum = 526;BA.debugLine="End Sub";
return "";
}
public void  _showlockscreen() throws Exception{
ResumableSub_ShowLockScreen rsub = new ResumableSub_ShowLockScreen(this);
rsub.resume(ba, null);
}
public static class ResumableSub_ShowLockScreen extends BA.ResumableSub {
public ResumableSub_ShowLockScreen(com.lockzero.b4xmainpage parent) {
this.parent = parent;
}
com.lockzero.b4xmainpage parent;
String _canauth = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 753;BA.debugLine="pnlLock.Visible = True";
parent._pnllock.setVisible(parent.__c.True);
 //BA.debugLineNum = 754;BA.debugLine="pnlLock.BringToFront";
parent._pnllock.BringToFront();
 //BA.debugLineNum = 755;BA.debugLine="edtPinInput.Text = \"\"";
parent._edtpininput.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 756;BA.debugLine="lblPinError.Text = \"\"";
parent._lblpinerror.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 759;BA.debugLine="If ModSecurity.GetUseBiometric Then";
if (true) break;

case 1:
//if
this.state = 8;
if (parent._modsecurity._getusebiometric /*boolean*/ (ba)) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 760;BA.debugLine="Dim canAuth As String = Biometric.CanAuthenticat";
_canauth = parent._biometric._canauthenticate /*String*/ ();
 //BA.debugLineNum = 761;BA.debugLine="If canAuth = \"SUCCESS\" Then";
if (true) break;

case 4:
//if
this.state = 7;
if ((_canauth).equals("SUCCESS")) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 763;BA.debugLine="Sleep(300)";
parent.__c.Sleep(ba,this,(int) (300));
this.state = 9;
return;
case 9:
//C
this.state = 7;
;
 //BA.debugLineNum = 764;BA.debugLine="Biometric.Show(ModLang.T(\"biometric_prompt\"))";
parent._biometric._show /*String*/ (parent._modlang._t /*String*/ (ba,"biometric_prompt"));
 if (true) break;

case 7:
//C
this.state = 8;
;
 if (true) break;

case 8:
//C
this.state = -1;
;
 //BA.debugLineNum = 767;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _showmenu() throws Exception{
 //BA.debugLineNum = 196;BA.debugLine="Private Sub ShowMenu";
 //BA.debugLineNum = 197;BA.debugLine="pnlMenuOverlay.Visible = True";
_pnlmenuoverlay.setVisible(__c.True);
 //BA.debugLineNum = 198;BA.debugLine="pnlMenu.SetLayoutAnimated(200, 0, pnlMenu.Top, pn";
_pnlmenu.SetLayoutAnimated((int) (200),(int) (0),_pnlmenu.getTop(),_pnlmenu.getWidth(),_pnlmenu.getHeight());
 //BA.debugLineNum = 199;BA.debugLine="MenuVisible = True";
_menuvisible = __c.True;
 //BA.debugLineNum = 200;BA.debugLine="End Sub";
return "";
}
public String  _tmrsession_tick() throws Exception{
 //BA.debugLineNum = 635;BA.debugLine="Private Sub tmrSession_Tick";
 //BA.debugLineNum = 636;BA.debugLine="UpdateSessionDisplay";
_updatesessiondisplay();
 //BA.debugLineNum = 637;BA.debugLine="End Sub";
return "";
}
public String  _togglemenu() throws Exception{
 //BA.debugLineNum = 188;BA.debugLine="Private Sub ToggleMenu";
 //BA.debugLineNum = 189;BA.debugLine="If pnlMenu.Left < 0 Then";
if (_pnlmenu.getLeft()<0) { 
 //BA.debugLineNum = 190;BA.debugLine="ShowMenu";
_showmenu();
 }else {
 //BA.debugLineNum = 192;BA.debugLine="HideMenu";
_hidemenu();
 };
 //BA.debugLineNum = 194;BA.debugLine="End Sub";
return "";
}
public String  _updatesessiondisplay() throws Exception{
String _remaining = "";
String _categoryname = "";
int _remainingsecs = 0;
 //BA.debugLineNum = 639;BA.debugLine="Private Sub UpdateSessionDisplay";
 //BA.debugLineNum = 640;BA.debugLine="If ModSession.IsSessionActive Then";
if (_modsession._issessionactive /*boolean*/ (ba)) { 
 //BA.debugLineNum = 641;BA.debugLine="Dim remaining As String = ModSession.GetRemainin";
_remaining = _modsession._getremainingformatted /*String*/ (ba);
 //BA.debugLineNum = 642;BA.debugLine="Dim categoryName As String = ModSession.GetSessi";
_categoryname = _modsession._getsessioncategoryname /*String*/ (ba);
 //BA.debugLineNum = 645;BA.debugLine="If ModSecurity.GetUseSinglePassphrase = False An";
if (_modsecurity._getusesinglepassphrase /*boolean*/ (ba)==__c.False && (_categoryname).equals("") == false) { 
 //BA.debugLineNum = 646;BA.debugLine="lblSessionTimer.Text = categoryName & \" • \" & r";
_lblsessiontimer.setText(BA.ObjectToCharSequence(_categoryname+" • "+_remaining+" ◀"));
 }else {
 //BA.debugLineNum = 648;BA.debugLine="lblSessionTimer.Text = remaining & \" ◀\"";
_lblsessiontimer.setText(BA.ObjectToCharSequence(_remaining+" ◀"));
 };
 //BA.debugLineNum = 652;BA.debugLine="Dim remainingSecs As Int = ModSession.GetRemaini";
_remainingsecs = _modsession._getremainingseconds /*int*/ (ba);
 //BA.debugLineNum = 653;BA.debugLine="If remainingSecs < 60 Then";
if (_remainingsecs<60) { 
 //BA.debugLineNum = 654;BA.debugLine="lblSessionTimer.TextColor = Colors.RGB(0, 220,";
_lblsessiontimer.setTextColor(__c.Colors.RGB((int) (0),(int) (220),(int) (255)));
 }else {
 //BA.debugLineNum = 656;BA.debugLine="lblSessionTimer.TextColor = Colors.ARGB(200, 25";
_lblsessiontimer.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 };
 }else {
 //BA.debugLineNum = 659;BA.debugLine="lblSessionTimer.Text = \"\"";
_lblsessiontimer.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 660;BA.debugLine="tmrSession.Enabled = False";
_tmrsession.setEnabled(__c.False);
 };
 //BA.debugLineNum = 662;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
