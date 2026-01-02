package com.lockzero;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class modtransition {
private static modtransition mostCurrent = new modtransition();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static int _duration = 0;
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
public com.lockzero.b4xpages _b4xpages = null;
public com.lockzero.b4xcollections _b4xcollections = null;
public com.lockzero.xuiviewsutils _xuiviewsutils = null;
public static anywheresoftware.b4a.objects.B4XCanvas.B4XRect  _createrect(anywheresoftware.b4a.BA _ba,float _x,float _y,float _w,float _h) throws Exception{
anywheresoftware.b4a.objects.B4XCanvas.B4XRect _r = null;
 //BA.debugLineNum = 74;BA.debugLine="Private Sub CreateRect(x As Float, y As Float, w A";
 //BA.debugLineNum = 75;BA.debugLine="Dim r As B4XRect";
_r = new anywheresoftware.b4a.objects.B4XCanvas.B4XRect();
 //BA.debugLineNum = 76;BA.debugLine="r.Initialize(x, y, x + w, y + h)";
_r.Initialize(_x,_y,(float) (_x+_w),(float) (_y+_h));
 //BA.debugLineNum = 77;BA.debugLine="Return r";
if (true) return _r;
 //BA.debugLineNum = 78;BA.debugLine="End Sub";
return null;
}
public static String  _fadein(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _root) throws Exception{
 //BA.debugLineNum = 96;BA.debugLine="Public Sub FadeIn(root As B4XView)";
 //BA.debugLineNum = 97;BA.debugLine="If root = Null Then Return";
if (_root== null) { 
if (true) return "";};
 //BA.debugLineNum = 98;BA.debugLine="root.Alpha = 1";
_root.setAlpha((float) (1));
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 11;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 12;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 13;BA.debugLine="Public Const DURATION As Int = 300";
_duration = (int) (300);
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return "";
}
public static String  _slidefromright(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _root) throws Exception{
 //BA.debugLineNum = 84;BA.debugLine="Public Sub SlideFromRight(root As B4XView)";
 //BA.debugLineNum = 85;BA.debugLine="If root = Null Then Return";
if (_root== null) { 
if (true) return "";};
 //BA.debugLineNum = 86;BA.debugLine="root.Alpha = 1";
_root.setAlpha((float) (1));
 //BA.debugLineNum = 87;BA.debugLine="root.Left = 0";
_root.setLeft((int) (0));
 //BA.debugLineNum = 88;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _slidefromrightnew(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _currentroot,anywheresoftware.b4a.objects.B4XViewWrapper _newroot) throws Exception{
ResumableSub_SlideFromRightNew rsub = new ResumableSub_SlideFromRightNew(null,_ba,_currentroot,_newroot);
rsub.resume((_ba.processBA == null ? _ba : _ba.processBA), null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_SlideFromRightNew extends BA.ResumableSub {
public ResumableSub_SlideFromRightNew(com.lockzero.modtransition parent,anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _currentroot,anywheresoftware.b4a.objects.B4XViewWrapper _newroot) {
this.parent = parent;
this._ba = _ba;
this._currentroot = _currentroot;
this._newroot = _newroot;
}
com.lockzero.modtransition parent;
anywheresoftware.b4a.BA _ba;
anywheresoftware.b4a.objects.B4XViewWrapper _currentroot;
anywheresoftware.b4a.objects.B4XViewWrapper _newroot;
float _rootwidth = 0f;
float _rootheight = 0f;
anywheresoftware.b4a.objects.B4XViewWrapper _pnl = null;
anywheresoftware.b4a.objects.B4XCanvas _cnv = null;
anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _newbmp = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
{
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
 //BA.debugLineNum = 48;BA.debugLine="If CurrentRoot = Null Or NewRoot = Null Then Retu";
if (true) break;

case 1:
//if
this.state = 6;
if (_currentroot== null || _newroot== null) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
if (true) {
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,(Object)(anywheresoftware.b4a.keywords.Common.True));return;};
if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 50;BA.debugLine="Dim RootWidth As Float = CurrentRoot.Width";
_rootwidth = (float) (_currentroot.getWidth());
 //BA.debugLineNum = 51;BA.debugLine="Dim RootHeight As Float = CurrentRoot.Height";
_rootheight = (float) (_currentroot.getHeight());
 //BA.debugLineNum = 54;BA.debugLine="Dim pnl As B4XView = xui.CreatePanel(\"\")";
_pnl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_pnl = parent._xui.CreatePanel((_ba.processBA == null ? _ba : _ba.processBA),"");
 //BA.debugLineNum = 55;BA.debugLine="NewRoot.AddView(pnl, RootWidth, 0, RootWidth, Roo";
_newroot.AddView((android.view.View)(_pnl.getObject()),(int) (_rootwidth),(int) (0),(int) (_rootwidth),(int) (_rootheight));
 //BA.debugLineNum = 56;BA.debugLine="pnl.As(Panel).Elevation = 10dip";
((anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_pnl.getObject()))).setElevation((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
 //BA.debugLineNum = 59;BA.debugLine="Dim cnv As B4XCanvas";
_cnv = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 60;BA.debugLine="cnv.Initialize(pnl)";
_cnv.Initialize(_pnl);
 //BA.debugLineNum = 61;BA.debugLine="Dim newBmp As B4XBitmap = NewRoot.Snapshot";
_newbmp = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper();
_newbmp = _newroot.Snapshot();
 //BA.debugLineNum = 62;BA.debugLine="cnv.DrawBitmap(newBmp, CreateRect(0, 0, RootWidth";
_cnv.DrawBitmap((android.graphics.Bitmap)(_newbmp.getObject()),_createrect(_ba,(float) (0),(float) (0),_rootwidth,_rootheight));
 //BA.debugLineNum = 63;BA.debugLine="cnv.Invalidate";
_cnv.Invalidate();
 //BA.debugLineNum = 66;BA.debugLine="pnl.SetLayoutAnimated(DURATION, 0, 0, RootWidth,";
_pnl.SetLayoutAnimated(parent._duration,(int) (0),(int) (0),(int) (_rootwidth),(int) (_rootheight));
 //BA.debugLineNum = 67;BA.debugLine="Sleep(DURATION)";
anywheresoftware.b4a.keywords.Common.Sleep((_ba.processBA == null ? _ba : _ba.processBA),this,parent._duration);
this.state = 7;
return;
case 7:
//C
this.state = -1;
;
 //BA.debugLineNum = 70;BA.debugLine="pnl.RemoveViewFromParent";
_pnl.RemoveViewFromParent();
 //BA.debugLineNum = 71;BA.debugLine="Return True";
if (true) {
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,(Object)(anywheresoftware.b4a.keywords.Common.True));return;};
 //BA.debugLineNum = 72;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _slidein(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _root) throws Exception{
 //BA.debugLineNum = 90;BA.debugLine="Public Sub SlideIn(root As B4XView)";
 //BA.debugLineNum = 91;BA.debugLine="If root = Null Then Return";
if (_root== null) { 
if (true) return "";};
 //BA.debugLineNum = 92;BA.debugLine="root.Left = 0";
_root.setLeft((int) (0));
 //BA.debugLineNum = 93;BA.debugLine="root.Alpha = 1";
_root.setAlpha((float) (1));
 //BA.debugLineNum = 94;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _slidetoleft(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _currentroot,anywheresoftware.b4a.objects.B4XViewWrapper _newroot) throws Exception{
ResumableSub_SlideToLeft rsub = new ResumableSub_SlideToLeft(null,_ba,_currentroot,_newroot);
rsub.resume((_ba.processBA == null ? _ba : _ba.processBA), null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_SlideToLeft extends BA.ResumableSub {
public ResumableSub_SlideToLeft(com.lockzero.modtransition parent,anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _currentroot,anywheresoftware.b4a.objects.B4XViewWrapper _newroot) {
this.parent = parent;
this._ba = _ba;
this._currentroot = _currentroot;
this._newroot = _newroot;
}
com.lockzero.modtransition parent;
anywheresoftware.b4a.BA _ba;
anywheresoftware.b4a.objects.B4XViewWrapper _currentroot;
anywheresoftware.b4a.objects.B4XViewWrapper _newroot;
float _rootwidth = 0f;
float _rootheight = 0f;
anywheresoftware.b4a.objects.B4XViewWrapper _pnl = null;
anywheresoftware.b4a.objects.B4XCanvas _cnv = null;
anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _currentbmp = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
{
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
 //BA.debugLineNum = 19;BA.debugLine="If CurrentRoot = Null Or NewRoot = Null Then Retu";
if (true) break;

case 1:
//if
this.state = 6;
if (_currentroot== null || _newroot== null) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
if (true) {
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,(Object)(anywheresoftware.b4a.keywords.Common.True));return;};
if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 21;BA.debugLine="Dim RootWidth As Float = CurrentRoot.Width";
_rootwidth = (float) (_currentroot.getWidth());
 //BA.debugLineNum = 22;BA.debugLine="Dim RootHeight As Float = CurrentRoot.Height";
_rootheight = (float) (_currentroot.getHeight());
 //BA.debugLineNum = 25;BA.debugLine="Dim pnl As B4XView = xui.CreatePanel(\"\")";
_pnl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_pnl = parent._xui.CreatePanel((_ba.processBA == null ? _ba : _ba.processBA),"");
 //BA.debugLineNum = 26;BA.debugLine="NewRoot.AddView(pnl, 0, 0, RootWidth, RootHeight)";
_newroot.AddView((android.view.View)(_pnl.getObject()),(int) (0),(int) (0),(int) (_rootwidth),(int) (_rootheight));
 //BA.debugLineNum = 27;BA.debugLine="pnl.As(Panel).Elevation = 10dip  'Fica na frente";
((anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_pnl.getObject()))).setElevation((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
 //BA.debugLineNum = 30;BA.debugLine="Dim cnv As B4XCanvas";
_cnv = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 31;BA.debugLine="cnv.Initialize(pnl)";
_cnv.Initialize(_pnl);
 //BA.debugLineNum = 32;BA.debugLine="Dim currentBmp As B4XBitmap = CurrentRoot.Snapsho";
_currentbmp = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper();
_currentbmp = _currentroot.Snapshot();
 //BA.debugLineNum = 33;BA.debugLine="cnv.DrawBitmap(currentBmp, CreateRect(0, 0, RootW";
_cnv.DrawBitmap((android.graphics.Bitmap)(_currentbmp.getObject()),_createrect(_ba,(float) (0),(float) (0),_rootwidth,_rootheight));
 //BA.debugLineNum = 34;BA.debugLine="cnv.Invalidate";
_cnv.Invalidate();
 //BA.debugLineNum = 37;BA.debugLine="pnl.SetLayoutAnimated(DURATION, -RootWidth, 0, Ro";
_pnl.SetLayoutAnimated(parent._duration,(int) (-_rootwidth),(int) (0),(int) (_rootwidth),(int) (_rootheight));
 //BA.debugLineNum = 38;BA.debugLine="Sleep(DURATION)";
anywheresoftware.b4a.keywords.Common.Sleep((_ba.processBA == null ? _ba : _ba.processBA),this,parent._duration);
this.state = 7;
return;
case 7:
//C
this.state = -1;
;
 //BA.debugLineNum = 41;BA.debugLine="pnl.RemoveViewFromParent";
_pnl.RemoveViewFromParent();
 //BA.debugLineNum = 42;BA.debugLine="Return True";
if (true) {
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,(Object)(anywheresoftware.b4a.keywords.Common.True));return;};
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
}
