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
public String  _addmenubutton(String _txt,String _eventname,int _top,int _w,int _h) throws Exception{
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
 //BA.debugLineNum = 149;BA.debugLine="Private Sub AddMenuButton(txt As String, eventName";
 //BA.debugLineNum = 150;BA.debugLine="Dim btn As Button";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 151;BA.debugLine="btn.Initialize(eventName)";
_btn.Initialize(ba,_eventname);
 //BA.debugLineNum = 152;BA.debugLine="btn.Text = txt";
_btn.setText(BA.ObjectToCharSequence(_txt));
 //BA.debugLineNum = 153;BA.debugLine="btn.TextSize = Starter.FONT_BODY";
_btn.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 154;BA.debugLine="btn.TextColor = Colors.White";
_btn.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 155;BA.debugLine="btn.Color = Colors.Transparent";
_btn.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 156;BA.debugLine="btn.Gravity = Gravity.CENTER_VERTICAL + Gravity.L";
_btn.setGravity((int) (__c.Gravity.CENTER_VERTICAL+__c.Gravity.LEFT));
 //BA.debugLineNum = 157;BA.debugLine="svMenu.Panel.AddView(btn, 16dip, top, w, h)";
_svmenu.getPanel().AddView((android.view.View)(_btn.getObject()),__c.DipToCurrent((int) (16)),_top,_w,_h);
 //BA.debugLineNum = 158;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 460;BA.debugLine="Dim xv As B4XView = pnl";
_xv = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xv = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnl.getObject()));
 //BA.debugLineNum = 461;BA.debugLine="Dim l As Int = xv.Left";
_l = _xv.getLeft();
 //BA.debugLineNum = 462;BA.debugLine="Dim t As Int = xv.Top";
_t = _xv.getTop();
 //BA.debugLineNum = 463;BA.debugLine="Dim w As Int = xv.Width";
_w = _xv.getWidth();
 //BA.debugLineNum = 464;BA.debugLine="Dim h As Int = xv.Height";
_h = _xv.getHeight();
 //BA.debugLineNum = 466;BA.debugLine="Dim grow As Int = 6dip";
_grow = parent.__c.DipToCurrent((int) (6));
 //BA.debugLineNum = 467;BA.debugLine="xv.SetLayoutAnimated(100, l - grow, t - grow, w +";
_xv.SetLayoutAnimated((int) (100),(int) (_l-_grow),(int) (_t-_grow),(int) (_w+_grow*2),(int) (_h+_grow*2));
 //BA.debugLineNum = 468;BA.debugLine="Sleep(100)";
parent.__c.Sleep(ba,this,(int) (100));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 469;BA.debugLine="xv.SetLayoutAnimated(100, l, t, w, h)";
_xv.SetLayoutAnimated((int) (100),_l,_t,_w,_h);
 //BA.debugLineNum = 470;BA.debugLine="End Sub";
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

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 //BA.debugLineNum = 474;BA.debugLine="AnimatePulse(pnl)";
parent._animatepulse(_pnl);
 //BA.debugLineNum = 475;BA.debugLine="Sleep(150)";
parent.__c.Sleep(ba,this,(int) (150));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 476;BA.debugLine="B4XPages.ShowPage(pageName)";
parent._b4xpages._showpage /*String*/ (ba,_pagename);
 //BA.debugLineNum = 477;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 481;BA.debugLine="AnimatePulse(pnl)";
parent._animatepulse(_pnl);
 //BA.debugLineNum = 482;BA.debugLine="Sleep(150)";
parent.__c.Sleep(ba,this,(int) (150));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 483;BA.debugLine="NavigateToNotes";
parent._navigatetonotes();
 //BA.debugLineNum = 484;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _applytheme() throws Exception{
 //BA.debugLineNum = 550;BA.debugLine="Private Sub ApplyTheme";
 //BA.debugLineNum = 551;BA.debugLine="Root.Color = ModTheme.HomeBg";
_root.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 553;BA.debugLine="If pnlHeader.IsInitialized Then pnlHeader.Color =";
if (_pnlheader.IsInitialized()) { 
_pnlheader.setColor(_modtheme._homeheaderbg /*int*/ (ba));};
 //BA.debugLineNum = 554;BA.debugLine="If pnlContent.IsInitialized Then pnlContent.Color";
if (_pnlcontent.IsInitialized()) { 
_pnlcontent.setColor(_modtheme._homebg /*int*/ (ba));};
 //BA.debugLineNum = 555;BA.debugLine="If pnlFooter.IsInitialized Then pnlFooter.Color =";
if (_pnlfooter.IsInitialized()) { 
_pnlfooter.setColor(_modtheme._homebg /*int*/ (ba));};
 //BA.debugLineNum = 556;BA.debugLine="If pnlMenu.IsInitialized Then pnlMenu.Color = Mod";
if (_pnlmenu.IsInitialized()) { 
_pnlmenu.setColor(_modtheme._homebg /*int*/ (ba));};
 //BA.debugLineNum = 557;BA.debugLine="If svMenu.IsInitialized Then svMenu.Panel.Color =";
if (_svmenu.IsInitialized()) { 
_svmenu.getPanel().setColor(_modtheme._homebg /*int*/ (ba));};
 //BA.debugLineNum = 558;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_appear() throws Exception{
 //BA.debugLineNum = 46;BA.debugLine="Private Sub B4XPage_Appear";
 //BA.debugLineNum = 48;BA.debugLine="CallSub2(Main, \"SetPageTitle\", \"LockZero\")";
__c.CallSubNew2(ba,(Object)(_main.getObject()),"SetPageTitle",(Object)("LockZero"));
 //BA.debugLineNum = 51;BA.debugLine="RebuildMenuItems";
_rebuildmenuitems();
 //BA.debugLineNum = 52;BA.debugLine="ShowHome";
_showhome();
 //BA.debugLineNum = 53;BA.debugLine="RefreshFooter";
_refreshfooter();
 //BA.debugLineNum = 56;BA.debugLine="UpdateSessionDisplay";
_updatesessiondisplay();
 //BA.debugLineNum = 57;BA.debugLine="If ModSession.IsSessionActive Then";
if (_modsession._issessionactive /*boolean*/ (ba)) { 
 //BA.debugLineNum = 58;BA.debugLine="tmrSession.Enabled = True";
_tmrsession.setEnabled(__c.True);
 };
 //BA.debugLineNum = 60;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 566;BA.debugLine="If MenuVisible Then";
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
 //BA.debugLineNum = 567;BA.debugLine="HideMenu";
parent._hidemenu();
 //BA.debugLineNum = 568;BA.debugLine="Return False";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.False));return;};
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 572;BA.debugLine="Wait For (xui.Msgbox2Async(ModLang.T(\"confirm_exi";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"confirm_exit")),BA.ObjectToCharSequence(parent._starter._app_name /*String*/ ),parent._modlang._t /*String*/ (ba,"yes"),"",parent._modlang._t /*String*/ (ba,"no"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 5;
return;
case 5:
//C
this.state = -1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 573;BA.debugLine="Return Result = xui.DialogResponse_Positive";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_result==parent._xui.DialogResponse_Positive));return;};
 //BA.debugLineNum = 574;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _msgbox_result(int _result) throws Exception{
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
 //BA.debugLineNum = 36;BA.debugLine="Private Sub B4XPage_Created(Root1 As B4XView)";
 //BA.debugLineNum = 37;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 38;BA.debugLine="Root.Color = ModTheme.Background";
_root.setColor(_modtheme._background /*int*/ (ba));
 //BA.debugLineNum = 40;BA.debugLine="CreateMainPanel";
_createmainpanel();
 //BA.debugLineNum = 41;BA.debugLine="CreateSideMenu";
_createsidemenu();
 //BA.debugLineNum = 42;BA.debugLine="ShowHome";
_showhome();
 //BA.debugLineNum = 43;BA.debugLine="ApplyTheme";
_applytheme();
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_disappear() throws Exception{
 //BA.debugLineNum = 62;BA.debugLine="Private Sub B4XPage_Disappear";
 //BA.debugLineNum = 63;BA.debugLine="tmrSession.Enabled = False";
_tmrsession.setEnabled(__c.False);
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return "";
}
public String  _btnmenu_click() throws Exception{
 //BA.debugLineNum = 383;BA.debugLine="Private Sub btnMenu_Click";
 //BA.debugLineNum = 384;BA.debugLine="ToggleMenu";
_togglemenu();
 //BA.debugLineNum = 385;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 5;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Private Root As B4XView";
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
 //BA.debugLineNum = 16;BA.debugLine="Private pnlHeader As Panel";
_pnlheader = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private pnlContent As Panel";
_pnlcontent = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private pnlFooter As Panel";
_pnlfooter = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private HEADER_HEIGHT As Int = 56dip";
_header_height = __c.DipToCurrent((int) (56));
 //BA.debugLineNum = 22;BA.debugLine="Private FOOTER_HEIGHT As Int = 80dip";
_footer_height = __c.DipToCurrent((int) (80));
 //BA.debugLineNum = 23;BA.debugLine="Private GRID_MARGIN As Int = 18dip";
_grid_margin = __c.DipToCurrent((int) (18));
 //BA.debugLineNum = 24;BA.debugLine="Private GRID_GAP As Int = 14dip";
_grid_gap = __c.DipToCurrent((int) (14));
 //BA.debugLineNum = 25;BA.debugLine="Private CARD_CORNER As Int = 14dip";
_card_corner = __c.DipToCurrent((int) (14));
 //BA.debugLineNum = 28;BA.debugLine="Private tmrSession As Timer";
_tmrsession = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 29;BA.debugLine="Private lblSessionTimer As Label";
_lblsessiontimer = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return "";
}
public String  _createfooter() throws Exception{
int _width = 0;
int _y = 0;
anywheresoftware.b4a.objects.LabelWrapper _lblslogan = null;
anywheresoftware.b4a.objects.LabelWrapper _lblversion = null;
 //BA.debugLineNum = 258;BA.debugLine="Private Sub CreateFooter";
 //BA.debugLineNum = 259;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 260;BA.debugLine="Dim y As Int = 8dip";
_y = __c.DipToCurrent((int) (8));
 //BA.debugLineNum = 263;BA.debugLine="Dim lblSlogan As Label";
_lblslogan = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 264;BA.debugLine="lblSlogan.Initialize(\"\")";
_lblslogan.Initialize(ba,"");
 //BA.debugLineNum = 265;BA.debugLine="lblSlogan.Text = ModLang.T(\"app_tagline\")";
_lblslogan.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"app_tagline")));
 //BA.debugLineNum = 266;BA.debugLine="lblSlogan.TextSize = 14";
_lblslogan.setTextSize((float) (14));
 //BA.debugLineNum = 267;BA.debugLine="lblSlogan.TextColor = Colors.ARGB(180, 255, 255,";
_lblslogan.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 268;BA.debugLine="lblSlogan.Gravity = Gravity.CENTER_HORIZONTAL";
_lblslogan.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 269;BA.debugLine="pnlFooter.AddView(lblSlogan, 0, y, width, 22dip)";
_pnlfooter.AddView((android.view.View)(_lblslogan.getObject()),(int) (0),_y,_width,__c.DipToCurrent((int) (22)));
 //BA.debugLineNum = 270;BA.debugLine="y = y + 22dip";
_y = (int) (_y+__c.DipToCurrent((int) (22)));
 //BA.debugLineNum = 273;BA.debugLine="Dim lblVersion As Label";
_lblversion = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 274;BA.debugLine="lblVersion.Initialize(\"\")";
_lblversion.Initialize(ba,"");
 //BA.debugLineNum = 275;BA.debugLine="lblVersion.Text = ModLang.T(\"free_version\") & \" -";
_lblversion.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"free_version")+" - v"+_starter._app_version /*String*/ ));
 //BA.debugLineNum = 276;BA.debugLine="lblVersion.TextSize = 12";
_lblversion.setTextSize((float) (12));
 //BA.debugLineNum = 277;BA.debugLine="lblVersion.TextColor = Colors.ARGB(140, 255, 255,";
_lblversion.setTextColor(__c.Colors.ARGB((int) (140),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 278;BA.debugLine="lblVersion.Gravity = Gravity.CENTER_HORIZONTAL";
_lblversion.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 279;BA.debugLine="pnlFooter.AddView(lblVersion, 0, y, width, 20dip)";
_pnlfooter.AddView((android.view.View)(_lblversion.getObject()),(int) (0),_y,_width,__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 280;BA.debugLine="y = y + 24dip";
_y = (int) (_y+__c.DipToCurrent((int) (24)));
 //BA.debugLineNum = 283;BA.debugLine="lblSessionTimer.Initialize(\"lblSessionTimer\")";
_lblsessiontimer.Initialize(ba,"lblSessionTimer");
 //BA.debugLineNum = 284;BA.debugLine="lblSessionTimer.Text = \"\"";
_lblsessiontimer.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 285;BA.debugLine="lblSessionTimer.TextSize = 11";
_lblsessiontimer.setTextSize((float) (11));
 //BA.debugLineNum = 286;BA.debugLine="lblSessionTimer.TextColor = Colors.ARGB(160, 255,";
_lblsessiontimer.setTextColor(__c.Colors.ARGB((int) (160),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 287;BA.debugLine="lblSessionTimer.Gravity = Gravity.CENTER_HORIZONT";
_lblsessiontimer.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 288;BA.debugLine="pnlFooter.AddView(lblSessionTimer, 0, y, width, 1";
_pnlfooter.AddView((android.view.View)(_lblsessiontimer.getObject()),(int) (0),_y,_width,__c.DipToCurrent((int) (18)));
 //BA.debugLineNum = 289;BA.debugLine="End Sub";
return "";
}
public String  _createheader() throws Exception{
int _width = 0;
anywheresoftware.b4a.objects.ImageViewWrapper _ivlogo = null;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
anywheresoftware.b4a.objects.ButtonWrapper _btnmenu = null;
 //BA.debugLineNum = 220;BA.debugLine="Private Sub CreateHeader";
 //BA.debugLineNum = 221;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 224;BA.debugLine="Dim ivLogo As ImageView";
_ivlogo = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 225;BA.debugLine="ivLogo.Initialize(\"\")";
_ivlogo.Initialize(ba,"");
 //BA.debugLineNum = 226;BA.debugLine="ivLogo.Gravity = Gravity.FILL";
_ivlogo.setGravity(__c.Gravity.FILL);
 //BA.debugLineNum = 227;BA.debugLine="pnlHeader.AddView(ivLogo, 16dip, 8dip, 40dip, 40d";
_pnlheader.AddView((android.view.View)(_ivlogo.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (8)),__c.DipToCurrent((int) (40)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 228;BA.debugLine="Try";
try { //BA.debugLineNum = 229;BA.debugLine="ivLogo.Bitmap = LoadBitmap(File.DirAssets, \"ic_l";
_ivlogo.setBitmap((android.graphics.Bitmap)(__c.LoadBitmap(__c.File.getDirAssets(),"ic_lockzero.png").getObject()));
 } 
       catch (Exception e9) {
			ba.setLastException(e9); //BA.debugLineNum = 231;BA.debugLine="Log(\"Erro ao carregar ic_lockzero.png: \" & LastE";
__c.LogImpl("51703947","Erro ao carregar ic_lockzero.png: "+__c.LastException(ba).getMessage(),0);
 };
 //BA.debugLineNum = 235;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 236;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 237;BA.debugLine="lblTitle.Text = \"LockZero\"";
_lbltitle.setText(BA.ObjectToCharSequence("LockZero"));
 //BA.debugLineNum = 238;BA.debugLine="lblTitle.TextSize = 20";
_lbltitle.setTextSize((float) (20));
 //BA.debugLineNum = 239;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 240;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 241;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_VERTICAL";
_lbltitle.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 242;BA.debugLine="pnlHeader.AddView(lblTitle, 64dip, 0, width - 120";
_pnlheader.AddView((android.view.View)(_lbltitle.getObject()),__c.DipToCurrent((int) (64)),(int) (0),(int) (_width-__c.DipToCurrent((int) (120))),_header_height);
 //BA.debugLineNum = 245;BA.debugLine="Dim btnMenu As Button";
_btnmenu = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 246;BA.debugLine="btnMenu.Initialize(\"btnMenu\")";
_btnmenu.Initialize(ba,"btnMenu");
 //BA.debugLineNum = 247;BA.debugLine="btnMenu.Text = Chr(0x2630) 'Hamburguer ☰";
_btnmenu.setText(BA.ObjectToCharSequence(__c.Chr(((int)0x2630))));
 //BA.debugLineNum = 248;BA.debugLine="btnMenu.TextSize = 24";
_btnmenu.setTextSize((float) (24));
 //BA.debugLineNum = 249;BA.debugLine="btnMenu.TextColor = Colors.White";
_btnmenu.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 250;BA.debugLine="btnMenu.Color = Colors.Transparent";
_btnmenu.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 251;BA.debugLine="pnlHeader.AddView(btnMenu, width - 56dip, 0, 56di";
_pnlheader.AddView((android.view.View)(_btnmenu.getObject()),(int) (_width-__c.DipToCurrent((int) (56))),(int) (0),__c.DipToCurrent((int) (56)),_header_height);
 //BA.debugLineNum = 252;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 328;BA.debugLine="Private Sub CreateHomeCard(eventName As String, la";
 //BA.debugLineNum = 330;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 331;BA.debugLine="pnl.Initialize(eventName)";
_pnl.Initialize(ba,_eventname);
 //BA.debugLineNum = 333;BA.debugLine="Dim xv As B4XView = pnl";
_xv = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xv = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnl.getObject()));
 //BA.debugLineNum = 334;BA.debugLine="xv.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModT";
_xv.SetColorAndBorder(_modtheme._homeiconbg /*int*/ (ba),(int) (0),_modtheme._homeiconbg /*int*/ (ba),_card_corner);
 //BA.debugLineNum = 335;BA.debugLine="pnlContent.AddView(pnl, x, y, size, size)";
_pnlcontent.AddView((android.view.View)(_pnl.getObject()),_x,_y,_size,_size);
 //BA.debugLineNum = 338;BA.debugLine="Dim iconSize As Int = size * 0.55";
_iconsize = (int) (_size*0.55);
 //BA.debugLineNum = 341;BA.debugLine="Dim iconY As Int = (size * 0.42) - (iconSize / 2)";
_icony = (int) ((_size*0.42)-(_iconsize/(double)2));
 //BA.debugLineNum = 342;BA.debugLine="Dim iconX As Int = (size - iconSize) / 2";
_iconx = (int) ((_size-_iconsize)/(double)2);
 //BA.debugLineNum = 345;BA.debugLine="Dim ivIcon As ImageView";
_ivicon = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 346;BA.debugLine="ivIcon.Initialize(\"\")";
_ivicon.Initialize(ba,"");
 //BA.debugLineNum = 347;BA.debugLine="ivIcon.Gravity = Gravity.FILL";
_ivicon.setGravity(__c.Gravity.FILL);
 //BA.debugLineNum = 348;BA.debugLine="pnl.AddView(ivIcon, iconX, iconY, iconSize, iconS";
_pnl.AddView((android.view.View)(_ivicon.getObject()),_iconx,_icony,_iconsize,_iconsize);
 //BA.debugLineNum = 350;BA.debugLine="Try";
try { //BA.debugLineNum = 351;BA.debugLine="ivIcon.Bitmap = LoadBitmap(File.DirAssets, iconF";
_ivicon.setBitmap((android.graphics.Bitmap)(__c.LoadBitmap(__c.File.getDirAssets(),_iconfile).getObject()));
 } 
       catch (Exception e16) {
			ba.setLastException(e16); //BA.debugLineNum = 353;BA.debugLine="Log(\"Erro ao carregar \" & iconFile & \": \" & Last";
__c.LogImpl("51966105","Erro ao carregar "+_iconfile+": "+__c.LastException(ba).getMessage(),0);
 //BA.debugLineNum = 355;BA.debugLine="Dim lblFallback As Label";
_lblfallback = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 356;BA.debugLine="lblFallback.Initialize(\"\")";
_lblfallback.Initialize(ba,"");
 //BA.debugLineNum = 357;BA.debugLine="lblFallback.Text = \"?\"";
_lblfallback.setText(BA.ObjectToCharSequence("?"));
 //BA.debugLineNum = 358;BA.debugLine="lblFallback.TextSize = 32";
_lblfallback.setTextSize((float) (32));
 //BA.debugLineNum = 359;BA.debugLine="lblFallback.TextColor = Colors.White";
_lblfallback.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 360;BA.debugLine="lblFallback.Gravity = Gravity.CENTER";
_lblfallback.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 361;BA.debugLine="pnl.AddView(lblFallback, iconX, iconY, iconSize,";
_pnl.AddView((android.view.View)(_lblfallback.getObject()),_iconx,_icony,_iconsize,_iconsize);
 };
 //BA.debugLineNum = 365;BA.debugLine="Dim lblSpace As Int = 10dip";
_lblspace = __c.DipToCurrent((int) (10));
 //BA.debugLineNum = 366;BA.debugLine="Dim lblY As Int = iconY + iconSize + lblSpace";
_lbly = (int) (_icony+_iconsize+_lblspace);
 //BA.debugLineNum = 367;BA.debugLine="Dim lblH As Int = size - lblY - 8dip";
_lblh = (int) (_size-_lbly-__c.DipToCurrent((int) (8)));
 //BA.debugLineNum = 369;BA.debugLine="Dim lblLabel As Label";
_lbllabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 370;BA.debugLine="lblLabel.Initialize(\"\")";
_lbllabel.Initialize(ba,"");
 //BA.debugLineNum = 371;BA.debugLine="lblLabel.Text = labelText";
_lbllabel.setText(BA.ObjectToCharSequence(_labeltext));
 //BA.debugLineNum = 372;BA.debugLine="lblLabel.TextSize = 15";
_lbllabel.setTextSize((float) (15));
 //BA.debugLineNum = 373;BA.debugLine="lblLabel.TextColor = Colors.ARGB(230, 255, 255, 2";
_lbllabel.setTextColor(__c.Colors.ARGB((int) (230),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 374;BA.debugLine="lblLabel.Gravity = Gravity.CENTER_HORIZONTAL";
_lbllabel.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 375;BA.debugLine="lblLabel.Typeface = Typeface.DEFAULT_BOLD";
_lbllabel.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 376;BA.debugLine="pnl.AddView(lblLabel, 0, lblY, size, lblH)";
_pnl.AddView((android.view.View)(_lbllabel.getObject()),(int) (0),_lbly,_size,_lblh);
 //BA.debugLineNum = 377;BA.debugLine="End Sub";
return "";
}
public String  _createmainpanel() throws Exception{
int _width = 0;
int _height = 0;
int _contentheight = 0;
 //BA.debugLineNum = 190;BA.debugLine="Private Sub CreateMainPanel";
 //BA.debugLineNum = 191;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 192;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 195;BA.debugLine="Root.Color = ModTheme.HomeBg";
_root.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 198;BA.debugLine="pnlHeader.Initialize(\"pnlHeader\")";
_pnlheader.Initialize(ba,"pnlHeader");
 //BA.debugLineNum = 199;BA.debugLine="pnlHeader.Color = ModTheme.HomeHeaderBg";
_pnlheader.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 200;BA.debugLine="Root.AddView(pnlHeader, 0, 0, width, HEADER_HEIGH";
_root.AddView((android.view.View)(_pnlheader.getObject()),(int) (0),(int) (0),_width,_header_height);
 //BA.debugLineNum = 201;BA.debugLine="CreateHeader";
_createheader();
 //BA.debugLineNum = 204;BA.debugLine="pnlFooter.Initialize(\"\")";
_pnlfooter.Initialize(ba,"");
 //BA.debugLineNum = 205;BA.debugLine="pnlFooter.Color = ModTheme.HomeBg";
_pnlfooter.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 206;BA.debugLine="Root.AddView(pnlFooter, 0, height - FOOTER_HEIGHT";
_root.AddView((android.view.View)(_pnlfooter.getObject()),(int) (0),(int) (_height-_footer_height),_width,_footer_height);
 //BA.debugLineNum = 207;BA.debugLine="CreateFooter";
_createfooter();
 //BA.debugLineNum = 210;BA.debugLine="Dim contentHeight As Int = height - HEADER_HEIGHT";
_contentheight = (int) (_height-_header_height-_footer_height);
 //BA.debugLineNum = 211;BA.debugLine="pnlContent.Initialize(\"\")";
_pnlcontent.Initialize(ba,"");
 //BA.debugLineNum = 212;BA.debugLine="pnlContent.Color = ModTheme.HomeBg";
_pnlcontent.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 213;BA.debugLine="Root.AddView(pnlContent, 0, HEADER_HEIGHT, width,";
_root.AddView((android.view.View)(_pnlcontent.getObject()),(int) (0),_header_height,_width,_contentheight);
 //BA.debugLineNum = 214;BA.debugLine="End Sub";
return "";
}
public String  _createsidemenu() throws Exception{
int _width = 0;
int _height = 0;
int _menuw = 0;
 //BA.debugLineNum = 70;BA.debugLine="Private Sub CreateSideMenu";
 //BA.debugLineNum = 71;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 72;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 73;BA.debugLine="Dim menuW As Int = width * 0.70 '70% da largura";
_menuw = (int) (_width*0.70);
 //BA.debugLineNum = 76;BA.debugLine="pnlMenuOverlay.Initialize(\"pnlMenuOverlay\")";
_pnlmenuoverlay.Initialize(ba,"pnlMenuOverlay");
 //BA.debugLineNum = 77;BA.debugLine="pnlMenuOverlay.Color = Colors.ARGB(150, 0, 0, 0)";
_pnlmenuoverlay.setColor(__c.Colors.ARGB((int) (150),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 78;BA.debugLine="pnlMenuOverlay.Visible = False";
_pnlmenuoverlay.setVisible(__c.False);
 //BA.debugLineNum = 79;BA.debugLine="Root.AddView(pnlMenuOverlay, 0, 0, width, height)";
_root.AddView((android.view.View)(_pnlmenuoverlay.getObject()),(int) (0),(int) (0),_width,_height);
 //BA.debugLineNum = 82;BA.debugLine="pnlMenu.Initialize(\"pnlMenu\")";
_pnlmenu.Initialize(ba,"pnlMenu");
 //BA.debugLineNum = 83;BA.debugLine="pnlMenu.Color = ModTheme.HomeBg";
_pnlmenu.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 84;BA.debugLine="Root.AddView(pnlMenu, -menuW, 0, menuW, height)";
_root.AddView((android.view.View)(_pnlmenu.getObject()),(int) (-_menuw),(int) (0),_menuw,_height);
 //BA.debugLineNum = 86;BA.debugLine="svMenu.Initialize(0)";
_svmenu.Initialize(ba,(int) (0));
 //BA.debugLineNum = 87;BA.debugLine="svMenu.Color = ModTheme.HomeBg";
_svmenu.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 88;BA.debugLine="pnlMenu.AddView(svMenu, 0, 0, menuW, height)";
_pnlmenu.AddView((android.view.View)(_svmenu.getObject()),(int) (0),(int) (0),_menuw,_height);
 //BA.debugLineNum = 90;BA.debugLine="RebuildMenuItems";
_rebuildmenuitems();
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
return "";
}
public String  _hidemenu() throws Exception{
 //BA.debugLineNum = 174;BA.debugLine="Private Sub HideMenu";
 //BA.debugLineNum = 175;BA.debugLine="If MenuVisible Then";
if (_menuvisible) { 
 //BA.debugLineNum = 176;BA.debugLine="pnlMenuOverlay.Visible = False";
_pnlmenuoverlay.setVisible(__c.False);
 //BA.debugLineNum = 177;BA.debugLine="pnlMenu.SetLayoutAnimated(200, -pnlMenu.Width, p";
_pnlmenu.SetLayoutAnimated((int) (200),(int) (-_pnlmenu.getWidth()),_pnlmenu.getTop(),_pnlmenu.getWidth(),_pnlmenu.getHeight());
 //BA.debugLineNum = 178;BA.debugLine="MenuVisible = False";
_menuvisible = __c.False;
 };
 //BA.debugLineNum = 180;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 32;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 33;BA.debugLine="tmrSession.Initialize(\"tmrSession\", 1000)";
_tmrsession.Initialize(ba,"tmrSession",(long) (1000));
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 534;BA.debugLine="If ModSession.IsSessionActive = False Then Return";
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
 //BA.debugLineNum = 536;BA.debugLine="Wait For (xui.Msgbox2Async(ModLang.T(\"lock_confir";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"lock_confirm_msg")),BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"lock")),parent._modlang._t /*String*/ (ba,"yes"),"",parent._modlang._t /*String*/ (ba,"cancel"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 11;
return;
case 11:
//C
this.state = 7;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 538;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
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
 //BA.debugLineNum = 539;BA.debugLine="ModSession.Lock";
parent._modsession._lock /*String*/ (ba);
 //BA.debugLineNum = 540;BA.debugLine="tmrSession.Enabled = False";
parent._tmrsession.setEnabled(parent.__c.False);
 //BA.debugLineNum = 541;BA.debugLine="lblSessionTimer.Text = \"\"";
parent._lblsessiontimer.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 542;BA.debugLine="ToastMessageShow(ModLang.T(\"locked\"), False)";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"locked")),parent.__c.False);
 if (true) break;

case 10:
//C
this.state = -1;
;
 //BA.debugLineNum = 544;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _mnubackup_click() throws Exception{
 //BA.debugLineNum = 416;BA.debugLine="Private Sub mnuBackup_Click";
 //BA.debugLineNum = 417;BA.debugLine="HideMenu";
_hidemenu();
 //BA.debugLineNum = 418;BA.debugLine="B4XPages.ShowPage(\"PageBackup\")";
_b4xpages._showpage /*String*/ (ba,"PageBackup");
 //BA.debugLineNum = 419;BA.debugLine="End Sub";
return "";
}
public String  _mnucards_click() throws Exception{
 //BA.debugLineNum = 396;BA.debugLine="Private Sub mnuCards_Click";
 //BA.debugLineNum = 397;BA.debugLine="HideMenu";
_hidemenu();
 //BA.debugLineNum = 398;BA.debugLine="ToastMessageShow(ModLang.T(\"cards\") & \" - \" & Mod";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cards")+" - "+_modlang._t /*String*/ (ba,"loading")),__c.False);
 //BA.debugLineNum = 399;BA.debugLine="End Sub";
return "";
}
public String  _mnudocuments_click() throws Exception{
 //BA.debugLineNum = 401;BA.debugLine="Private Sub mnuDocuments_Click";
 //BA.debugLineNum = 402;BA.debugLine="HideMenu";
_hidemenu();
 //BA.debugLineNum = 403;BA.debugLine="ToastMessageShow(ModLang.T(\"documents\") & \" - \" &";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"documents")+" - "+_modlang._t /*String*/ (ba,"loading")),__c.False);
 //BA.debugLineNum = 404;BA.debugLine="End Sub";
return "";
}
public String  _mnunotes_click() throws Exception{
 //BA.debugLineNum = 406;BA.debugLine="Private Sub mnuNotes_Click";
 //BA.debugLineNum = 407;BA.debugLine="HideMenu";
_hidemenu();
 //BA.debugLineNum = 408;BA.debugLine="NavigateToNotes";
_navigatetonotes();
 //BA.debugLineNum = 409;BA.debugLine="End Sub";
return "";
}
public String  _mnupasswords_click() throws Exception{
 //BA.debugLineNum = 391;BA.debugLine="Private Sub mnuPasswords_Click";
 //BA.debugLineNum = 392;BA.debugLine="HideMenu";
_hidemenu();
 //BA.debugLineNum = 393;BA.debugLine="B4XPages.ShowPage(\"PagePasswords\")";
_b4xpages._showpage /*String*/ (ba,"PagePasswords");
 //BA.debugLineNum = 394;BA.debugLine="End Sub";
return "";
}
public String  _mnusettings_click() throws Exception{
 //BA.debugLineNum = 411;BA.debugLine="Private Sub mnuSettings_Click";
 //BA.debugLineNum = 412;BA.debugLine="HideMenu";
_hidemenu();
 //BA.debugLineNum = 413;BA.debugLine="B4XPages.ShowPage(\"PageSettings\")";
_b4xpages._showpage /*String*/ (ba,"PageSettings");
 //BA.debugLineNum = 414;BA.debugLine="End Sub";
return "";
}
public String  _navigatetonotes() throws Exception{
anywheresoftware.b4a.objects.collections.List _groups = null;
com.lockzero.clspasswordgroup _grp = null;
com.lockzero.pagenoteslist _pg = null;
 //BA.debugLineNum = 486;BA.debugLine="Private Sub NavigateToNotes";
 //BA.debugLineNum = 488;BA.debugLine="Dim groups As List = ModPasswords.GetAllGroups";
_groups = new anywheresoftware.b4a.objects.collections.List();
_groups = _modpasswords._getallgroups /*anywheresoftware.b4a.objects.collections.List*/ (ba);
 //BA.debugLineNum = 489;BA.debugLine="If groups.Size > 0 Then";
if (_groups.getSize()>0) { 
 //BA.debugLineNum = 490;BA.debugLine="Dim grp As clsPasswordGroup = groups.Get(0)";
_grp = (com.lockzero.clspasswordgroup)(_groups.Get((int) (0)));
 //BA.debugLineNum = 491;BA.debugLine="Dim pg As PageNotesList = B4XPages.GetPage(\"Page";
_pg = (com.lockzero.pagenoteslist)(_b4xpages._getpage /*Object*/ (ba,"PageNotesList"));
 //BA.debugLineNum = 492;BA.debugLine="pg.SetParams(CreateMap(\"groupId\": grp.Id, \"group";
_pg._setparams /*String*/ (__c.createMap(new Object[] {(Object)("groupId"),(Object)(_grp._id /*String*/ ),(Object)("groupName"),(Object)(_grp._name /*String*/ )}));
 //BA.debugLineNum = 493;BA.debugLine="B4XPages.ShowPage(\"PageNotesList\")";
_b4xpages._showpage /*String*/ (ba,"PageNotesList");
 }else {
 //BA.debugLineNum = 495;BA.debugLine="ToastMessageShow(ModLang.T(\"empty\"), True)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"empty")),__c.True);
 };
 //BA.debugLineNum = 497;BA.debugLine="End Sub";
return "";
}
public String  _pnlbackup_click() throws Exception{
 //BA.debugLineNum = 449;BA.debugLine="Private Sub pnlBackup_Click";
 //BA.debugLineNum = 450;BA.debugLine="HideMenu";
_hidemenu();
 //BA.debugLineNum = 451;BA.debugLine="AnimatePulseAndNavigate(Sender, \"PageBackup\")";
_animatepulseandnavigate((anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(__c.Sender(ba))),"PageBackup");
 //BA.debugLineNum = 452;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 431;BA.debugLine="HideMenu";
parent._hidemenu();
 //BA.debugLineNum = 432;BA.debugLine="AnimatePulse(Sender)";
parent._animatepulse((anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(parent.__c.Sender(ba))));
 //BA.debugLineNum = 433;BA.debugLine="Sleep(250)";
parent.__c.Sleep(ba,this,(int) (250));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 434;BA.debugLine="ToastMessageShow(ModLang.T(\"cards\") & \" - \" & Mod";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"cards")+" - "+parent._modlang._t /*String*/ (ba,"loading")),parent.__c.False);
 //BA.debugLineNum = 435;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
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
 //BA.debugLineNum = 438;BA.debugLine="HideMenu";
parent._hidemenu();
 //BA.debugLineNum = 439;BA.debugLine="AnimatePulse(Sender)";
parent._animatepulse((anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(parent.__c.Sender(ba))));
 //BA.debugLineNum = 440;BA.debugLine="Sleep(250)";
parent.__c.Sleep(ba,this,(int) (250));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 441;BA.debugLine="ToastMessageShow(ModLang.T(\"documents\") & \" - \" &";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"documents")+" - "+parent._modlang._t /*String*/ (ba,"loading")),parent.__c.False);
 //BA.debugLineNum = 442;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _pnlmenu_click() throws Exception{
 //BA.debugLineNum = 387;BA.debugLine="Private Sub pnlMenu_Click";
 //BA.debugLineNum = 389;BA.debugLine="End Sub";
return "";
}
public String  _pnlmenuoverlay_click() throws Exception{
 //BA.debugLineNum = 182;BA.debugLine="Private Sub pnlMenuOverlay_Click";
 //BA.debugLineNum = 183;BA.debugLine="HideMenu";
_hidemenu();
 //BA.debugLineNum = 184;BA.debugLine="End Sub";
return "";
}
public String  _pnlnotes_click() throws Exception{
 //BA.debugLineNum = 444;BA.debugLine="Private Sub pnlNotes_Click";
 //BA.debugLineNum = 445;BA.debugLine="HideMenu";
_hidemenu();
 //BA.debugLineNum = 446;BA.debugLine="AnimatePulseAndNavigateNotes(Sender)";
_animatepulseandnavigatenotes((anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(__c.Sender(ba))));
 //BA.debugLineNum = 447;BA.debugLine="End Sub";
return "";
}
public String  _pnlpasswords_click() throws Exception{
 //BA.debugLineNum = 425;BA.debugLine="Private Sub pnlPasswords_Click";
 //BA.debugLineNum = 426;BA.debugLine="HideMenu";
_hidemenu();
 //BA.debugLineNum = 427;BA.debugLine="AnimatePulseAndNavigate(Sender, \"PagePasswords\")";
_animatepulseandnavigate((anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(__c.Sender(ba))),"PagePasswords");
 //BA.debugLineNum = 428;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 93;BA.debugLine="Public Sub RebuildMenuItems";
 //BA.debugLineNum = 94;BA.debugLine="svMenu.Panel.RemoveAllViews";
_svmenu.getPanel().RemoveAllViews();
 //BA.debugLineNum = 95;BA.debugLine="svMenu.Panel.Color = ModTheme.HomeBg";
_svmenu.getPanel().setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 97;BA.debugLine="Dim menuW As Int = pnlMenu.Width";
_menuw = _pnlmenu.getWidth();
 //BA.debugLineNum = 98;BA.debugLine="Dim top As Int = 0";
_top = (int) (0);
 //BA.debugLineNum = 101;BA.debugLine="Dim pnlMenuHeader As Panel";
_pnlmenuheader = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 102;BA.debugLine="pnlMenuHeader.Initialize(\"\")";
_pnlmenuheader.Initialize(ba,"");
 //BA.debugLineNum = 103;BA.debugLine="pnlMenuHeader.Color = ModTheme.HomeHeaderBg";
_pnlmenuheader.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 104;BA.debugLine="svMenu.Panel.AddView(pnlMenuHeader, 0, top, menuW";
_svmenu.getPanel().AddView((android.view.View)(_pnlmenuheader.getObject()),(int) (0),_top,_menuw,__c.DipToCurrent((int) (80)));
 //BA.debugLineNum = 106;BA.debugLine="Dim lblMenuTitle As Label";
_lblmenutitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 107;BA.debugLine="lblMenuTitle.Initialize(\"\")";
_lblmenutitle.Initialize(ba,"");
 //BA.debugLineNum = 108;BA.debugLine="lblMenuTitle.Text = Starter.APP_NAME";
_lblmenutitle.setText(BA.ObjectToCharSequence(_starter._app_name /*String*/ ));
 //BA.debugLineNum = 109;BA.debugLine="lblMenuTitle.TextSize = 22";
_lblmenutitle.setTextSize((float) (22));
 //BA.debugLineNum = 110;BA.debugLine="lblMenuTitle.TextColor = Colors.White";
_lblmenutitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 111;BA.debugLine="lblMenuTitle.Gravity = Gravity.CENTER_VERTICAL";
_lblmenutitle.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 112;BA.debugLine="lblMenuTitle.Typeface = Typeface.DEFAULT_BOLD";
_lblmenutitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 113;BA.debugLine="pnlMenuHeader.AddView(lblMenuTitle, 20dip, 0, men";
_pnlmenuheader.AddView((android.view.View)(_lblmenutitle.getObject()),__c.DipToCurrent((int) (20)),(int) (0),(int) (_menuw-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (80)));
 //BA.debugLineNum = 114;BA.debugLine="top = top + 80dip + 16dip";
_top = (int) (_top+__c.DipToCurrent((int) (80))+__c.DipToCurrent((int) (16)));
 //BA.debugLineNum = 116;BA.debugLine="Dim btnW As Int = menuW - 32dip";
_btnw = (int) (_menuw-__c.DipToCurrent((int) (32)));
 //BA.debugLineNum = 117;BA.debugLine="Dim btnH As Int = 48dip";
_btnh = __c.DipToCurrent((int) (48));
 //BA.debugLineNum = 118;BA.debugLine="Dim gap As Int = 4dip";
_gap = __c.DipToCurrent((int) (4));
 //BA.debugLineNum = 121;BA.debugLine="AddMenuButton(ModLang.T(\"passwords\"), \"mnuPasswor";
_addmenubutton(_modlang._t /*String*/ (ba,"passwords"),"mnuPasswords",_top,_btnw,_btnh);
 //BA.debugLineNum = 122;BA.debugLine="top = top + btnH + gap";
_top = (int) (_top+_btnh+_gap);
 //BA.debugLineNum = 124;BA.debugLine="AddMenuButton(ModLang.T(\"cards\"), \"mnuCards\", top";
_addmenubutton(_modlang._t /*String*/ (ba,"cards"),"mnuCards",_top,_btnw,_btnh);
 //BA.debugLineNum = 125;BA.debugLine="top = top + btnH + gap";
_top = (int) (_top+_btnh+_gap);
 //BA.debugLineNum = 127;BA.debugLine="AddMenuButton(ModLang.T(\"documents\"), \"mnuDocumen";
_addmenubutton(_modlang._t /*String*/ (ba,"documents"),"mnuDocuments",_top,_btnw,_btnh);
 //BA.debugLineNum = 128;BA.debugLine="top = top + btnH + gap";
_top = (int) (_top+_btnh+_gap);
 //BA.debugLineNum = 130;BA.debugLine="AddMenuButton(ModLang.T(\"notes\"), \"mnuNotes\", top";
_addmenubutton(_modlang._t /*String*/ (ba,"notes"),"mnuNotes",_top,_btnw,_btnh);
 //BA.debugLineNum = 131;BA.debugLine="top = top + btnH + 16dip";
_top = (int) (_top+_btnh+__c.DipToCurrent((int) (16)));
 //BA.debugLineNum = 134;BA.debugLine="Dim pnlSep As Panel";
_pnlsep = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 135;BA.debugLine="pnlSep.Initialize(\"\")";
_pnlsep.Initialize(ba,"");
 //BA.debugLineNum = 136;BA.debugLine="pnlSep.Color = Colors.ARGB(60, 255, 255, 255)";
_pnlsep.setColor(__c.Colors.ARGB((int) (60),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 137;BA.debugLine="svMenu.Panel.AddView(pnlSep, 16dip, top, btnW, 1d";
_svmenu.getPanel().AddView((android.view.View)(_pnlsep.getObject()),__c.DipToCurrent((int) (16)),_top,_btnw,__c.DipToCurrent((int) (1)));
 //BA.debugLineNum = 138;BA.debugLine="top = top + 16dip";
_top = (int) (_top+__c.DipToCurrent((int) (16)));
 //BA.debugLineNum = 140;BA.debugLine="AddMenuButton(ModLang.T(\"settings\"), \"mnuSettings";
_addmenubutton(_modlang._t /*String*/ (ba,"settings"),"mnuSettings",_top,_btnw,_btnh);
 //BA.debugLineNum = 141;BA.debugLine="top = top + btnH + gap";
_top = (int) (_top+_btnh+_gap);
 //BA.debugLineNum = 143;BA.debugLine="AddMenuButton(ModLang.T(\"backup\"), \"mnuBackup\", t";
_addmenubutton(_modlang._t /*String*/ (ba,"backup"),"mnuBackup",_top,_btnw,_btnh);
 //BA.debugLineNum = 144;BA.debugLine="top = top + btnH + gap";
_top = (int) (_top+_btnh+_gap);
 //BA.debugLineNum = 146;BA.debugLine="svMenu.Panel.Height = top + 50dip";
_svmenu.getPanel().setHeight((int) (_top+__c.DipToCurrent((int) (50))));
 //BA.debugLineNum = 147;BA.debugLine="End Sub";
return "";
}
public String  _refreshfooter() throws Exception{
 //BA.debugLineNum = 291;BA.debugLine="Private Sub RefreshFooter";
 //BA.debugLineNum = 292;BA.debugLine="pnlFooter.RemoveAllViews";
_pnlfooter.RemoveAllViews();
 //BA.debugLineNum = 293;BA.debugLine="CreateFooter";
_createfooter();
 //BA.debugLineNum = 294;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 300;BA.debugLine="Private Sub ShowHome";
 //BA.debugLineNum = 301;BA.debugLine="pnlContent.RemoveAllViews";
_pnlcontent.RemoveAllViews();
 //BA.debugLineNum = 303;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 304;BA.debugLine="Dim contentHeight As Int = pnlContent.Height";
_contentheight = _pnlcontent.getHeight();
 //BA.debugLineNum = 307;BA.debugLine="Dim availableWidth As Int = width - (GRID_MARGIN";
_availablewidth = (int) (_width-(_grid_margin*2)-_grid_gap);
 //BA.debugLineNum = 308;BA.debugLine="Dim cardSize As Int = availableWidth / 2";
_cardsize = (int) (_availablewidth/(double)2);
 //BA.debugLineNum = 311;BA.debugLine="Dim gridHeight As Int = (cardSize * 2) + GRID_GAP";
_gridheight = (int) ((_cardsize*2)+_grid_gap);
 //BA.debugLineNum = 312;BA.debugLine="Dim startY As Int = (contentHeight - gridHeight)";
_starty = (int) ((_contentheight-_gridheight)/(double)2);
 //BA.debugLineNum = 315;BA.debugLine="CreateHomeCard(\"pnlPasswords\", ModLang.T(\"passwor";
_createhomecard("pnlPasswords",_modlang._t /*String*/ (ba,"passwords"),"ic_senha.png",_grid_margin,_starty,_cardsize);
 //BA.debugLineNum = 316;BA.debugLine="CreateHomeCard(\"pnlCards\", ModLang.T(\"cards\"), \"i";
_createhomecard("pnlCards",_modlang._t /*String*/ (ba,"cards"),"ic_cartao.png",(int) (_grid_margin+_cardsize+_grid_gap),_starty,_cardsize);
 //BA.debugLineNum = 319;BA.debugLine="Dim row2Y As Int = startY + cardSize + GRID_GAP";
_row2y = (int) (_starty+_cardsize+_grid_gap);
 //BA.debugLineNum = 320;BA.debugLine="CreateHomeCard(\"pnlDocuments\", ModLang.T(\"documen";
_createhomecard("pnlDocuments",_modlang._t /*String*/ (ba,"documents"),"ic_doc.png",_grid_margin,_row2y,_cardsize);
 //BA.debugLineNum = 321;BA.debugLine="CreateHomeCard(\"pnlNotes\", ModLang.T(\"notes\"), \"i";
_createhomecard("pnlNotes",_modlang._t /*String*/ (ba,"notes"),"ic_notas.png",(int) (_grid_margin+_cardsize+_grid_gap),_row2y,_cardsize);
 //BA.debugLineNum = 322;BA.debugLine="End Sub";
return "";
}
public String  _showmenu() throws Exception{
 //BA.debugLineNum = 168;BA.debugLine="Private Sub ShowMenu";
 //BA.debugLineNum = 169;BA.debugLine="pnlMenuOverlay.Visible = True";
_pnlmenuoverlay.setVisible(__c.True);
 //BA.debugLineNum = 170;BA.debugLine="pnlMenu.SetLayoutAnimated(200, 0, pnlMenu.Top, pn";
_pnlmenu.SetLayoutAnimated((int) (200),(int) (0),_pnlmenu.getTop(),_pnlmenu.getWidth(),_pnlmenu.getHeight());
 //BA.debugLineNum = 171;BA.debugLine="MenuVisible = True";
_menuvisible = __c.True;
 //BA.debugLineNum = 172;BA.debugLine="End Sub";
return "";
}
public String  _tmrsession_tick() throws Exception{
 //BA.debugLineNum = 503;BA.debugLine="Private Sub tmrSession_Tick";
 //BA.debugLineNum = 504;BA.debugLine="UpdateSessionDisplay";
_updatesessiondisplay();
 //BA.debugLineNum = 505;BA.debugLine="End Sub";
return "";
}
public String  _togglemenu() throws Exception{
 //BA.debugLineNum = 160;BA.debugLine="Private Sub ToggleMenu";
 //BA.debugLineNum = 161;BA.debugLine="If pnlMenu.Left < 0 Then";
if (_pnlmenu.getLeft()<0) { 
 //BA.debugLineNum = 162;BA.debugLine="ShowMenu";
_showmenu();
 }else {
 //BA.debugLineNum = 164;BA.debugLine="HideMenu";
_hidemenu();
 };
 //BA.debugLineNum = 166;BA.debugLine="End Sub";
return "";
}
public String  _updatesessiondisplay() throws Exception{
String _remaining = "";
String _categoryname = "";
int _remainingsecs = 0;
 //BA.debugLineNum = 507;BA.debugLine="Private Sub UpdateSessionDisplay";
 //BA.debugLineNum = 508;BA.debugLine="If ModSession.IsSessionActive Then";
if (_modsession._issessionactive /*boolean*/ (ba)) { 
 //BA.debugLineNum = 509;BA.debugLine="Dim remaining As String = ModSession.GetRemainin";
_remaining = _modsession._getremainingformatted /*String*/ (ba);
 //BA.debugLineNum = 510;BA.debugLine="Dim categoryName As String = ModSession.GetSessi";
_categoryname = _modsession._getsessioncategoryname /*String*/ (ba);
 //BA.debugLineNum = 513;BA.debugLine="If ModSecurity.GetUseSinglePassphrase = False An";
if (_modsecurity._getusesinglepassphrase /*boolean*/ (ba)==__c.False && (_categoryname).equals("") == false) { 
 //BA.debugLineNum = 514;BA.debugLine="lblSessionTimer.Text = categoryName & \" • \" & r";
_lblsessiontimer.setText(BA.ObjectToCharSequence(_categoryname+" • "+_remaining+" ◀"));
 }else {
 //BA.debugLineNum = 516;BA.debugLine="lblSessionTimer.Text = remaining & \" ◀\"";
_lblsessiontimer.setText(BA.ObjectToCharSequence(_remaining+" ◀"));
 };
 //BA.debugLineNum = 520;BA.debugLine="Dim remainingSecs As Int = ModSession.GetRemaini";
_remainingsecs = _modsession._getremainingseconds /*int*/ (ba);
 //BA.debugLineNum = 521;BA.debugLine="If remainingSecs < 60 Then";
if (_remainingsecs<60) { 
 //BA.debugLineNum = 522;BA.debugLine="lblSessionTimer.TextColor = ModTheme.Warning";
_lblsessiontimer.setTextColor(_modtheme._warning /*int*/ (ba));
 }else {
 //BA.debugLineNum = 524;BA.debugLine="lblSessionTimer.TextColor = Colors.ARGB(200, 25";
_lblsessiontimer.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 };
 }else {
 //BA.debugLineNum = 527;BA.debugLine="lblSessionTimer.Text = \"\"";
_lblsessiontimer.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 528;BA.debugLine="tmrSession.Enabled = False";
_tmrsession.setEnabled(__c.False);
 };
 //BA.debugLineNum = 530;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
