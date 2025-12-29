package b4a.example;

import androidx.biometric.*;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class biometricmanager extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.example.biometricmanager");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.biometricmanager.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4j.object.JavaObject _ctxt = null;
public anywheresoftware.b4j.object.JavaObject _manager = null;
public anywheresoftware.b4j.object.JavaObject _handler = null;
public Object _executor = null;
public Object _mtarget = null;
public String _meventname = "";
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.b4xpages _b4xpages = null;
public b4a.example.b4xcollections _b4xcollections = null;
public String  _auth_complete(boolean _success,int _errorcode,String _errormessage) throws Exception{
 //BA.debugLineNum = 58;BA.debugLine="Private Sub Auth_Complete (Success As Boolean, Err";
 //BA.debugLineNum = 60;BA.debugLine="CallSubDelayed3(mTarget, mEventName & \"_complete\"";
__c.CallSubDelayed3(ba,_mtarget,_meventname+"_complete",(Object)(_success),(Object)(_errormessage));
 //BA.debugLineNum = 61;BA.debugLine="End Sub";
return "";
}
public String  _canauthenticate() throws Exception{
int _v = 0;
 //BA.debugLineNum = 29;BA.debugLine="Public Sub CanAuthenticate As String";
 //BA.debugLineNum = 30;BA.debugLine="Dim v As Int = Manager.RunMethod(\"canAuthenticate";
_v = (int)(BA.ObjectToNumber(_manager.RunMethod("canAuthenticate",(Object[])(__c.Null))));
 //BA.debugLineNum = 31;BA.debugLine="Select v";
switch (_v) {
case 1: {
 //BA.debugLineNum = 33;BA.debugLine="Return \"UNAVAILABLE\"";
if (true) return "UNAVAILABLE";
 break; }
case 11: {
 //BA.debugLineNum = 35;BA.debugLine="Return \"NONE_ENROLLED\"";
if (true) return "NONE_ENROLLED";
 break; }
case 12: {
 //BA.debugLineNum = 37;BA.debugLine="Return \"NO_HARDWARE\"";
if (true) return "NO_HARDWARE";
 break; }
case 0: {
 //BA.debugLineNum = 39;BA.debugLine="Return \"SUCCESS\"";
if (true) return "SUCCESS";
 break; }
default: {
 //BA.debugLineNum = 41;BA.debugLine="Return \"UNKNOWN\"";
if (true) return "UNKNOWN";
 break; }
}
;
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 4;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Private ctxt As JavaObject";
_ctxt = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 6;BA.debugLine="Private Manager As JavaObject";
_manager = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 7;BA.debugLine="Private Handler As JavaObject";
_handler = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 8;BA.debugLine="Private Executor As Object";
_executor = new Object();
 //BA.debugLineNum = 9;BA.debugLine="Private mTarget As Object";
_mtarget = new Object();
 //BA.debugLineNum = 10;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
public Object  _executor_event(String _methodname,Object[] _args) throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Private Sub Executor_Event (MethodName As String,";
 //BA.debugLineNum = 23;BA.debugLine="If MethodName = \"execute\" Then";
if ((_methodname).equals("execute")) { 
 //BA.debugLineNum = 24;BA.debugLine="Handler.RunMethod(\"post\", Array(Args(0)))";
_handler.RunMethod("post",new Object[]{_args[(int) (0)]});
 };
 //BA.debugLineNum = 26;BA.debugLine="Return Null";
if (true) return __c.Null;
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return null;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _target,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 13;BA.debugLine="Public Sub Initialize (Target As Object, EventName";
 //BA.debugLineNum = 14;BA.debugLine="mTarget = Target";
_mtarget = _target;
 //BA.debugLineNum = 15;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 16;BA.debugLine="ctxt.InitializeContext";
_ctxt.InitializeContext(ba);
 //BA.debugLineNum = 17;BA.debugLine="Manager = Manager.InitializeStatic(\"androidx.biom";
_manager = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_manager.InitializeStatic("androidx.biometric.BiometricManager").RunMethod("from",new Object[]{(Object)(_ctxt.getObject())})));
 //BA.debugLineNum = 18;BA.debugLine="Handler.InitializeNewInstance(\"android.os.Handler";
_handler.InitializeNewInstance("android.os.Handler",(Object[])(__c.Null));
 //BA.debugLineNum = 19;BA.debugLine="Executor = Handler.CreateEvent(\"java.util.concurr";
_executor = _handler.CreateEvent(ba,"java.util.concurrent.Executor","Executor",__c.Null);
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return "";
}
public String  _show(String _msg) throws Exception{
anywheresoftware.b4j.object.JavaObject _promptinfobuilder = null;
anywheresoftware.b4j.object.JavaObject _ev = null;
anywheresoftware.b4j.object.JavaObject _prompt = null;
 //BA.debugLineNum = 45;BA.debugLine="Public Sub Show (Msg As String)";
 //BA.debugLineNum = 46;BA.debugLine="Dim PromptInfoBuilder As JavaObject";
_promptinfobuilder = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 47;BA.debugLine="PromptInfoBuilder.InitializeNewInstance(\"androidx";
_promptinfobuilder.InitializeNewInstance("androidx.biometric.BiometricPrompt$PromptInfo$Builder",(Object[])(__c.Null));
 //BA.debugLineNum = 48;BA.debugLine="PromptInfoBuilder.RunMethod(\"setTitle\", Array(Msg";
_promptinfobuilder.RunMethod("setTitle",new Object[]{(Object)(_msg)});
 //BA.debugLineNum = 49;BA.debugLine="PromptInfoBuilder.RunMethod(\"setNegativeButtonTex";
_promptinfobuilder.RunMethod("setNegativeButtonText",new Object[]{(Object)("Cancel")});
 //BA.debugLineNum = 50;BA.debugLine="Dim Ev As JavaObject";
_ev = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 51;BA.debugLine="Ev.InitializeNewInstance(Application.PackageName";
_ev.InitializeNewInstance(__c.Application.getPackageName()+".biometricmanager.BiometricPromptAuthentication",new Object[]{this});
 //BA.debugLineNum = 52;BA.debugLine="Dim Prompt As JavaObject";
_prompt = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 53;BA.debugLine="Prompt.InitializeNewInstance(\"androidx.biometric.";
_prompt.InitializeNewInstance("androidx.biometric.BiometricPrompt",new Object[]{(Object)(_ctxt.getObject()),_executor,(Object)(_ev.getObject())});
 //BA.debugLineNum = 54;BA.debugLine="Prompt.RunMethod(\"authenticate\", Array(PromptInfo";
_prompt.RunMethod("authenticate",new Object[]{_promptinfobuilder.RunMethod("build",(Object[])(__c.Null))});
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}

public static class BiometricPromptAuthentication extends BiometricPrompt.AuthenticationCallback {
	private BA ba;
	public BiometricPromptAuthentication(B4AClass parent) {
		ba = parent.getBA();
	}
	@Override
	public void onAuthenticationError(int errorCode, CharSequence errString) {
		super.onAuthenticationError(errorCode, errString);
		 ba.raiseEventFromUI(this, "auth_complete", false, errorCode, errString);
	}

	@Override
	public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
		super.onAuthenticationSucceeded(result);
		 ba.raiseEventFromUI(this, "auth_complete", true, 0, "");
	}

	@Override
	public void onAuthenticationFailed() {
		super.onAuthenticationFailed();
	}
}
}
