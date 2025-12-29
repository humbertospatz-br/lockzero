package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class b4xmainpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.example.b4xmainpage");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.b4xmainpage.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public b4a.example.biometricmanager _biometric = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _label1 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _btnauth = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.b4xpages _b4xpages = null;
public b4a.example.b4xcollections _b4xcollections = null;
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
String _res = "";
 //BA.debugLineNum = 21;BA.debugLine="Private Sub B4XPage_Created (Root1 As B4XView)";
 //BA.debugLineNum = 22;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 23;BA.debugLine="Root.LoadLayout(\"1\")";
_root.LoadLayout("1",ba);
 //BA.debugLineNum = 24;BA.debugLine="Biometric.Initialize(Me, \"Authenticate\")";
_biometric._initialize /*String*/ (ba,this,"Authenticate");
 //BA.debugLineNum = 25;BA.debugLine="Dim res As String = Biometric.CanAuthenticate";
_res = _biometric._canauthenticate /*String*/ ();
 //BA.debugLineNum = 26;BA.debugLine="If res = \"SUCCESS\" Then";
if ((_res).equals("SUCCESS")) { 
 //BA.debugLineNum = 27;BA.debugLine="btnAuth.Enabled = True";
_btnauth.setEnabled(__c.True);
 }else {
 //BA.debugLineNum = 29;BA.debugLine="btnAuth.Enabled = False";
_btnauth.setEnabled(__c.False);
 //BA.debugLineNum = 30;BA.debugLine="Label1.Text = \"Can't authenticate: \" & res";
_label1.setText(BA.ObjectToCharSequence("Can't authenticate: "+_res));
 };
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
public void  _btnauth_click() throws Exception{
ResumableSub_btnAuth_Click rsub = new ResumableSub_btnAuth_Click(this);
rsub.resume(ba, null);
}
public static class ResumableSub_btnAuth_Click extends BA.ResumableSub {
public ResumableSub_btnAuth_Click(b4a.example.b4xmainpage parent) {
this.parent = parent;
}
b4a.example.b4xmainpage parent;
boolean _success = false;
String _errormessage = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 //BA.debugLineNum = 35;BA.debugLine="Biometric.Show(\"Please authenticate\")";
parent._biometric._show /*String*/ ("Please authenticate");
 //BA.debugLineNum = 36;BA.debugLine="Wait For Authenticate_Complete (Success As Boolea";
parent.__c.WaitFor("authenticate_complete", ba, this, null);
this.state = 1;
return;
case 1:
//C
this.state = -1;
_success = (Boolean) result[0];
_errormessage = (String) result[1];
;
 //BA.debugLineNum = 37;BA.debugLine="Label1.text = $\"Success: ${Success} ErrorMessage:";
parent._label1.setText(BA.ObjectToCharSequence(("Success: "+parent.__c.SmartStringFormatter("",(Object)(_success))+"\n"+"ErrorMessage: "+parent.__c.SmartStringFormatter("",(Object)(_errormessage))+"")));
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _authenticate_complete(boolean _success,String _errormessage) throws Exception{
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 8;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private Root As B4XView";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 10;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 11;BA.debugLine="Private Biometric As BiometricManager";
_biometric = new b4a.example.biometricmanager();
 //BA.debugLineNum = 12;BA.debugLine="Private Label1 As B4XView";
_label1 = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Private btnAuth As B4XView";
_btnauth = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 16;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
