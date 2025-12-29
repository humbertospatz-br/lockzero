package xx.b4x.sharefrominternal;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,36);
if (RapidSub.canDelegate("activity_create")) { return xx.b4x.sharefrominternal.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
int _i = 0;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 36;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8);
 BA.debugLineNum = 38;BA.debugLine="Activity.LoadLayout(\"MainLO\")";
Debug.ShouldStop(32);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("MainLO")),main.mostCurrent.activityBA);
 BA.debugLineNum = 40;BA.debugLine="SharedFolder=File.DirInternal & \"/shared\"";
Debug.ShouldStop(128);
main.mostCurrent._sharedfolder = RemoteObject.concat(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal"),RemoteObject.createImmutable("/shared"));
 BA.debugLineNum = 42;BA.debugLine="If File.Exists(SharedFolder,\"\") = False Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent._sharedfolder),(Object)(RemoteObject.createImmutable(""))),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 43;BA.debugLine="File.MakeDir(SharedFolder,\"\")";
Debug.ShouldStop(1024);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("MakeDir",(Object)(main.mostCurrent._sharedfolder),(Object)(RemoteObject.createImmutable("")));
 };
 BA.debugLineNum = 46;BA.debugLine="For i=1 To 4";
Debug.ShouldStop(8192);
{
final int step6 = 1;
final int limit6 = 4;
_i = 1 ;
for (;(step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6) ;_i = ((int)(0 + _i + step6))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 47;BA.debugLine="File.WriteString(SharedFolder,i & \".txt\",\"This i";
Debug.ShouldStop(16384);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent._sharedfolder),(Object)(RemoteObject.concat(RemoteObject.createImmutable(_i),RemoteObject.createImmutable(".txt"))),(Object)(RemoteObject.concat(RemoteObject.createImmutable("This is file "),RemoteObject.createImmutable(_i))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 51;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,130);
if (RapidSub.canDelegate("activity_pause")) { return xx.b4x.sharefrominternal.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 130;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(2);
 BA.debugLineNum = 132;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,122);
if (RapidSub.canDelegate("activity_resume")) { return xx.b4x.sharefrominternal.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 122;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 126;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getfileuri(RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("GetFileUri (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,103);
if (RapidSub.canDelegate("getfileuri")) { return xx.b4x.sharefrominternal.main.remoteMe.runUserSub(false, "main","getfileuri", _filename);}
RemoteObject _f = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _fp = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _context = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 103;BA.debugLine="Public Sub GetFileUri (FileName As String) As Obje";
Debug.ShouldStop(64);
 BA.debugLineNum = 105;BA.debugLine="Dim f As JavaObject";
Debug.ShouldStop(256);
_f = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("f", _f);
 BA.debugLineNum = 106;BA.debugLine="f.InitializeNewInstance(\"java.io.File\", Array(Sh";
Debug.ShouldStop(512);
_f.runVoidMethod ("InitializeNewInstance",(Object)(BA.ObjectToString("java.io.File")),(Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(main.mostCurrent._sharedfolder),(_filename)})));
 BA.debugLineNum = 107;BA.debugLine="Dim fp As JavaObject";
Debug.ShouldStop(1024);
_fp = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("fp", _fp);
 BA.debugLineNum = 108;BA.debugLine="Dim context As JavaObject";
Debug.ShouldStop(2048);
_context = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("context", _context);
 BA.debugLineNum = 109;BA.debugLine="context.InitializeContext";
Debug.ShouldStop(4096);
_context.runVoidMethod ("InitializeContext",main.processBA);
 BA.debugLineNum = 110;BA.debugLine="fp.InitializeStatic(\"android.support.v4.content.";
Debug.ShouldStop(8192);
_fp.runVoidMethod ("InitializeStatic",(Object)(RemoteObject.createImmutable("androidx.core.content.FileProvider")));
 BA.debugLineNum = 111;BA.debugLine="Return fp.RunMethod(\"getUriForFile\", Array(conte";
Debug.ShouldStop(16384);
if (true) return _fp.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getUriForFile")),(Object)(RemoteObject.createNewArray("Object",new int[] {3},new Object[] {(_context.getObject()),(RemoteObject.concat(main.mostCurrent.__c.getField(false,"Application").runMethod(true,"getPackageName"),RemoteObject.createImmutable(".provider"))),(_f.getObject())})));
 BA.debugLineNum = 112;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 24;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 29;BA.debugLine="Dim SharedFolder As String";
main.mostCurrent._sharedfolder = RemoteObject.createImmutable("");
 //BA.debugLineNum = 31;BA.debugLine="Private ShareSingleBTN As Button";
main.mostCurrent._sharesinglebtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private ShowFileBTN As Button";
main.mostCurrent._showfilebtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private ShareMultipleFilesBTN As Button";
main.mostCurrent._sharemultiplefilesbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("xx.b4x.sharefrominternal.main");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 20;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _setfileuriasintentdata(RemoteObject _intent,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("SetFileUriAsIntentData (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,116);
if (RapidSub.canDelegate("setfileuriasintentdata")) { return xx.b4x.sharefrominternal.main.remoteMe.runUserSub(false, "main","setfileuriasintentdata", _intent, _filename);}
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("Intent", _intent);
Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 116;BA.debugLine="Public Sub SetFileUriAsIntentData (Intent As Inten";
Debug.ShouldStop(524288);
 BA.debugLineNum = 117;BA.debugLine="Dim jo As JavaObject = Intent";
Debug.ShouldStop(1048576);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), _intent.getObject());Debug.locals.put("jo", _jo);Debug.locals.put("jo", _jo);
 BA.debugLineNum = 118;BA.debugLine="jo.RunMethod(\"setData\", Array(GetFileUri(FileName";
Debug.ShouldStop(2097152);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setData")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {_getfileuri(_filename)})));
 BA.debugLineNum = 119;BA.debugLine="Intent.Flags = Bit.Or(Intent.Flags, 1) 'FLAG_GRAN";
Debug.ShouldStop(4194304);
_intent.runMethod(true,"setFlags",main.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(_intent.runMethod(true,"getFlags")),(Object)(BA.numberCast(int.class, 1))));
 BA.debugLineNum = 120;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sharefile(RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("ShareFile (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,93);
if (RapidSub.canDelegate("sharefile")) { return xx.b4x.sharefrominternal.main.remoteMe.runUserSub(false, "main","sharefile", _filename);}
RemoteObject _in = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 93;BA.debugLine="Sub ShareFile(FileName As String)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 94;BA.debugLine="Dim in As Intent";
Debug.ShouldStop(536870912);
_in = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("in", _in);
 BA.debugLineNum = 95;BA.debugLine="in.Initialize(in.ACTION_SEND, \"\")";
Debug.ShouldStop(1073741824);
_in.runVoidMethod ("Initialize",(Object)(_in.getField(true,"ACTION_SEND")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 97;BA.debugLine="in.SetType(\"text/plain\")";
Debug.ShouldStop(1);
_in.runVoidMethod ("SetType",(Object)(RemoteObject.createImmutable("text/plain")));
 BA.debugLineNum = 98;BA.debugLine="in.PutExtra(\"android.intent.extra.STREAM\", GetFil";
Debug.ShouldStop(2);
_in.runVoidMethod ("PutExtra",(Object)(BA.ObjectToString("android.intent.extra.STREAM")),(Object)(_getfileuri(_filename)));
 BA.debugLineNum = 99;BA.debugLine="in.Flags = 1 'FLAG_GRANT_READ_URI_PERMISSION";
Debug.ShouldStop(4);
_in.runMethod(true,"setFlags",BA.numberCast(int.class, 1));
 BA.debugLineNum = 100;BA.debugLine="StartActivity(in)";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_in.getObject())));
 BA.debugLineNum = 101;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sharemultiplefiles() throws Exception{
try {
		Debug.PushSubsStack("ShareMultipleFiles (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,54);
if (RapidSub.canDelegate("sharemultiplefiles")) { return xx.b4x.sharefrominternal.main.remoteMe.runUserSub(false, "main","sharemultiplefiles");}
RemoteObject _i = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _uris = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _files = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _pdffile = RemoteObject.createImmutable("");
RemoteObject _u = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
 BA.debugLineNum = 54;BA.debugLine="Sub ShareMultipleFiles";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 56;BA.debugLine="Dim i As Intent";
Debug.ShouldStop(8388608);
_i = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("i", _i);
 BA.debugLineNum = 57;BA.debugLine="i.Initialize(\"android.intent.action.SEND_MULTIPLE";
Debug.ShouldStop(16777216);
_i.runVoidMethod ("Initialize",(Object)(BA.ObjectToString("android.intent.action.SEND_MULTIPLE")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 58;BA.debugLine="i.SetType(\"text/plain\")";
Debug.ShouldStop(33554432);
_i.runVoidMethod ("SetType",(Object)(RemoteObject.createImmutable("text/plain")));
 BA.debugLineNum = 60;BA.debugLine="Dim Uris As List";
Debug.ShouldStop(134217728);
_uris = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("Uris", _uris);
 BA.debugLineNum = 61;BA.debugLine="Uris.Initialize";
Debug.ShouldStop(268435456);
_uris.runVoidMethod ("Initialize");
 BA.debugLineNum = 63;BA.debugLine="Dim Files As List=File.ListFiles(SharedFolder)";
Debug.ShouldStop(1073741824);
_files = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_files = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ListFiles",(Object)(main.mostCurrent._sharedfolder));Debug.locals.put("Files", _files);Debug.locals.put("Files", _files);
 BA.debugLineNum = 64;BA.debugLine="For Each pdffile As String In Files";
Debug.ShouldStop(-2147483648);
{
final RemoteObject group7 = _files;
final int groupLen7 = group7.runMethod(true,"getSize").<Integer>get()
;int index7 = 0;
;
for (; index7 < groupLen7;index7++){
_pdffile = BA.ObjectToString(group7.runMethod(false,"Get",index7));Debug.locals.put("pdffile", _pdffile);
Debug.locals.put("pdffile", _pdffile);
 BA.debugLineNum = 65;BA.debugLine="Dim u As Uri = GetFileUri(pdffile)";
Debug.ShouldStop(1);
_u = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");
_u = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper"), _getfileuri(_pdffile));Debug.locals.put("u", _u);Debug.locals.put("u", _u);
 BA.debugLineNum = 66;BA.debugLine="Uris.Add(u)";
Debug.ShouldStop(2);
_uris.runVoidMethod ("Add",(Object)((_u.getObject())));
 }
}Debug.locals.put("pdffile", _pdffile);
;
 BA.debugLineNum = 69;BA.debugLine="Dim jo As JavaObject = i";
Debug.ShouldStop(16);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), _i.getObject());Debug.locals.put("jo", _jo);Debug.locals.put("jo", _jo);
 BA.debugLineNum = 70;BA.debugLine="jo.RunMethod(\"putParcelableArrayListExtra\", Array";
Debug.ShouldStop(32);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("putParcelableArrayListExtra")),(Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {RemoteObject.createImmutable(("android.intent.extra.STREAM")),(_uris.getObject())})));
 BA.debugLineNum = 71;BA.debugLine="i.Flags = 1";
Debug.ShouldStop(64);
_i.runMethod(true,"setFlags",BA.numberCast(int.class, 1));
 BA.debugLineNum = 73;BA.debugLine="StartActivity(i)";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_i.getObject())));
 BA.debugLineNum = 75;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sharemultiplefilesbtn_click() throws Exception{
try {
		Debug.PushSubsStack("ShareMultipleFilesBTN_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,146);
if (RapidSub.canDelegate("sharemultiplefilesbtn_click")) { return xx.b4x.sharefrominternal.main.remoteMe.runUserSub(false, "main","sharemultiplefilesbtn_click");}
 BA.debugLineNum = 146;BA.debugLine="Private Sub ShareMultipleFilesBTN_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 147;BA.debugLine="ShareMultipleFiles 'all in the shared folder";
Debug.ShouldStop(262144);
_sharemultiplefiles();
 BA.debugLineNum = 148;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sharesinglebtn_click() throws Exception{
try {
		Debug.PushSubsStack("ShareSingleBTN_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,138);
if (RapidSub.canDelegate("sharesinglebtn_click")) { return xx.b4x.sharefrominternal.main.remoteMe.runUserSub(false, "main","sharesinglebtn_click");}
 BA.debugLineNum = 138;BA.debugLine="Private Sub ShareSingleBTN_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 139;BA.debugLine="ShareFile(\"1.txt\")";
Debug.ShouldStop(1024);
_sharefile(RemoteObject.createImmutable("1.txt"));
 BA.debugLineNum = 140;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _showfile(RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("ShowFile (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,77);
if (RapidSub.canDelegate("showfile")) { return xx.b4x.sharefrominternal.main.remoteMe.runUserSub(false, "main","showfile", _filename);}
RemoteObject _myintent = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 77;BA.debugLine="Sub ShowFile (FileName As String) 'always under th";
Debug.ShouldStop(4096);
 BA.debugLineNum = 78;BA.debugLine="Dim MyIntent As Intent";
Debug.ShouldStop(8192);
_myintent = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("MyIntent", _myintent);
 BA.debugLineNum = 79;BA.debugLine="MyIntent.Initialize(MyIntent.ACTION_VIEW, GetFile";
Debug.ShouldStop(16384);
_myintent.runVoidMethod ("Initialize",(Object)(_myintent.getField(true,"ACTION_VIEW")),(Object)(BA.ObjectToString(_getfileuri(_filename))));
 BA.debugLineNum = 81;BA.debugLine="MyIntent.SetType(\"text/plain\")";
Debug.ShouldStop(65536);
_myintent.runVoidMethod ("SetType",(Object)(RemoteObject.createImmutable("text/plain")));
 BA.debugLineNum = 83;BA.debugLine="MyIntent.Flags = 1";
Debug.ShouldStop(262144);
_myintent.runMethod(true,"setFlags",BA.numberCast(int.class, 1));
 BA.debugLineNum = 85;BA.debugLine="Try";
Debug.ShouldStop(1048576);
try { BA.debugLineNum = 86;BA.debugLine="StartActivity(MyIntent)";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_myintent.getObject())));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e8.toString()); BA.debugLineNum = 88;BA.debugLine="MsgboxAsync(\"Sorry. No App available which suppo";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Sorry. No App available which supports the file type...")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))),main.processBA);
 };
 BA.debugLineNum = 91;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _showfilebtn_click() throws Exception{
try {
		Debug.PushSubsStack("ShowFileBTN_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,142);
if (RapidSub.canDelegate("showfilebtn_click")) { return xx.b4x.sharefrominternal.main.remoteMe.runUserSub(false, "main","showfilebtn_click");}
 BA.debugLineNum = 142;BA.debugLine="Private Sub ShowFileBTN_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 143;BA.debugLine="ShowFile(\"1.txt\")";
Debug.ShouldStop(16384);
_showfile(RemoteObject.createImmutable("1.txt"));
 BA.debugLineNum = 144;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}