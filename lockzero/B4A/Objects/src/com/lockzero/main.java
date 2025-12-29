package com.lockzero;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "com.lockzero", "com.lockzero.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "com.lockzero", "com.lockzero.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.lockzero.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public static boolean _actionbarhomeclicked = false;
public static String _pendingbackupfile = "";
public com.lockzero.pagepasswords _pgpasswords = null;
public com.lockzero.pagepasswordlist _pgpasswordlist = null;
public com.lockzero.pagepasswordedit _pgpasswordedit = null;
public com.lockzero.pagebackup _pgbackup = null;
public com.lockzero.pageonboarding _pgonboarding = null;
public com.lockzero.pagenoteslist _pgnoteslist = null;
public com.lockzero.pagenoteedit _pgnoteedit = null;
public com.lockzero.pagesettings _pgsettings = null;
public b4a.example.dateutils _dateutils = null;
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

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}
public static String  _activity_actionbarhomeclick() throws Exception{
 //BA.debugLineNum = 148;BA.debugLine="Sub Activity_ActionBarHomeClick";
 //BA.debugLineNum = 149;BA.debugLine="ActionBarHomeClicked = True";
_actionbarhomeclicked = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 150;BA.debugLine="B4XPages.Delegate.Activity_ActionBarHomeClick";
mostCurrent._b4xpages._delegate /*com.lockzero.b4xpagesdelegator*/ ._activity_actionbarhomeclick /*String*/ ();
 //BA.debugLineNum = 151;BA.debugLine="ActionBarHomeClicked = False";
_actionbarhomeclicked = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 152;BA.debugLine="End Sub";
return "";
}
public static String  _activity_create(boolean _firsttime) throws Exception{
com.lockzero.b4xpagesmanager _pm = null;
String _onboardingcomplete = "";
 //BA.debugLineNum = 34;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 35;BA.debugLine="Dim pm As B4XPagesManager";
_pm = new com.lockzero.b4xpagesmanager();
 //BA.debugLineNum = 36;BA.debugLine="pm.Initialize(Activity)";
_pm._initialize /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
 //BA.debugLineNum = 38;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
 //BA.debugLineNum = 40;BA.debugLine="ModPasswords.Init";
mostCurrent._modpasswords._init /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 41;BA.debugLine="ModNotes.Init";
mostCurrent._modnotes._init /*String*/ (mostCurrent.activityBA);
 };
 //BA.debugLineNum = 45;BA.debugLine="pgPasswords.Initialize";
mostCurrent._pgpasswords._initialize /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 46;BA.debugLine="pgPasswordList.Initialize";
mostCurrent._pgpasswordlist._initialize /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 47;BA.debugLine="pgPasswordEdit.Initialize";
mostCurrent._pgpasswordedit._initialize /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 48;BA.debugLine="pgBackup.Initialize";
mostCurrent._pgbackup._initialize /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 49;BA.debugLine="pgOnboarding.Initialize";
mostCurrent._pgonboarding._initialize /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 50;BA.debugLine="pgNotesList.Initialize";
mostCurrent._pgnoteslist._initialize /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 51;BA.debugLine="pgNoteEdit.Initialize";
mostCurrent._pgnoteedit._initialize /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 52;BA.debugLine="pgSettings.Initialize";
mostCurrent._pgsettings._initialize /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 54;BA.debugLine="B4XPages.AddPageAndCreate(\"PagePasswords\", pgPass";
mostCurrent._b4xpages._addpageandcreate /*String*/ (mostCurrent.activityBA,"PagePasswords",(Object)(mostCurrent._pgpasswords));
 //BA.debugLineNum = 55;BA.debugLine="B4XPages.AddPageAndCreate(\"PagePasswordList\", pgP";
mostCurrent._b4xpages._addpageandcreate /*String*/ (mostCurrent.activityBA,"PagePasswordList",(Object)(mostCurrent._pgpasswordlist));
 //BA.debugLineNum = 56;BA.debugLine="B4XPages.AddPageAndCreate(\"PagePasswordEdit\", pgP";
mostCurrent._b4xpages._addpageandcreate /*String*/ (mostCurrent.activityBA,"PagePasswordEdit",(Object)(mostCurrent._pgpasswordedit));
 //BA.debugLineNum = 57;BA.debugLine="B4XPages.AddPageAndCreate(\"PageBackup\", pgBackup)";
mostCurrent._b4xpages._addpageandcreate /*String*/ (mostCurrent.activityBA,"PageBackup",(Object)(mostCurrent._pgbackup));
 //BA.debugLineNum = 58;BA.debugLine="B4XPages.AddPageAndCreate(\"PageOnboarding\", pgOnb";
mostCurrent._b4xpages._addpageandcreate /*String*/ (mostCurrent.activityBA,"PageOnboarding",(Object)(mostCurrent._pgonboarding));
 //BA.debugLineNum = 59;BA.debugLine="B4XPages.AddPageAndCreate(\"PageNotesList\", pgNote";
mostCurrent._b4xpages._addpageandcreate /*String*/ (mostCurrent.activityBA,"PageNotesList",(Object)(mostCurrent._pgnoteslist));
 //BA.debugLineNum = 60;BA.debugLine="B4XPages.AddPageAndCreate(\"PageNoteEdit\", pgNoteE";
mostCurrent._b4xpages._addpageandcreate /*String*/ (mostCurrent.activityBA,"PageNoteEdit",(Object)(mostCurrent._pgnoteedit));
 //BA.debugLineNum = 61;BA.debugLine="B4XPages.AddPageAndCreate(\"PageSettings\", pgSetti";
mostCurrent._b4xpages._addpageandcreate /*String*/ (mostCurrent.activityBA,"PageSettings",(Object)(mostCurrent._pgsettings));
 //BA.debugLineNum = 63;BA.debugLine="B4XPages.GetManager.LogEvents = True";
mostCurrent._b4xpages._getmanager /*com.lockzero.b4xpagesmanager*/ (mostCurrent.activityBA)._logevents /*boolean*/  = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 65;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
 //BA.debugLineNum = 67;BA.debugLine="Dim onboardingComplete As String = ModSecurity.G";
_onboardingcomplete = BA.ObjectToString(mostCurrent._modsecurity._getsetting /*Object*/ (mostCurrent.activityBA,"onboarding_complete",(Object)("false")));
 //BA.debugLineNum = 68;BA.debugLine="If onboardingComplete <> \"true\" Then";
if ((_onboardingcomplete).equals("true") == false) { 
 //BA.debugLineNum = 69;BA.debugLine="B4XPages.ShowPageAndRemovePreviousPages(\"PageOn";
mostCurrent._b4xpages._showpageandremovepreviouspages /*String*/ (mostCurrent.activityBA,"PageOnboarding");
 };
 };
 //BA.debugLineNum = 74;BA.debugLine="CheckIncomingIntent";
_checkincomingintent();
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 154;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 155;BA.debugLine="Return B4XPages.Delegate.Activity_KeyPress(KeyCod";
if (true) return mostCurrent._b4xpages._delegate /*com.lockzero.b4xpagesdelegator*/ ._activity_keypress /*boolean*/ (_keycode);
 //BA.debugLineNum = 156;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 164;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 165;BA.debugLine="B4XPages.Delegate.Activity_Pause";
mostCurrent._b4xpages._delegate /*com.lockzero.b4xpagesdelegator*/ ._activity_pause /*String*/ ();
 //BA.debugLineNum = 166;BA.debugLine="End Sub";
return "";
}
public static String  _activity_permissionresult(String _permission,boolean _result) throws Exception{
 //BA.debugLineNum = 168;BA.debugLine="Sub Activity_PermissionResult (Permission As Strin";
 //BA.debugLineNum = 169;BA.debugLine="B4XPages.Delegate.Activity_PermissionResult(Permi";
mostCurrent._b4xpages._delegate /*com.lockzero.b4xpagesdelegator*/ ._activity_permissionresult /*String*/ (_permission,_result);
 //BA.debugLineNum = 170;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 158;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 160;BA.debugLine="CheckIncomingIntent";
_checkincomingintent();
 //BA.debugLineNum = 161;BA.debugLine="B4XPages.Delegate.Activity_Resume";
mostCurrent._b4xpages._delegate /*com.lockzero.b4xpagesdelegator*/ ._activity_resume /*String*/ ();
 //BA.debugLineNum = 162;BA.debugLine="End Sub";
return "";
}
public static String  _checkincomingintent() throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _intent = null;
Object _uri = null;
String _filename = "";
String _destfolder = "";
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _in = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
long _filesize = 0L;
String _content = "";
 //BA.debugLineNum = 78;BA.debugLine="Private Sub CheckIncomingIntent";
 //BA.debugLineNum = 80;BA.debugLine="If PendingBackupFile <> \"\" Then Return";
if ((_pendingbackupfile).equals("") == false) { 
if (true) return "";};
 //BA.debugLineNum = 82;BA.debugLine="Dim Intent As Intent = Activity.GetStartingIntent";
_intent = new anywheresoftware.b4a.objects.IntentWrapper();
_intent = mostCurrent._activity.GetStartingIntent();
 //BA.debugLineNum = 84;BA.debugLine="If Intent.IsInitialized = False Then Return";
if (_intent.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 85;BA.debugLine="If Intent.Action <> Intent.ACTION_VIEW Then Retur";
if ((_intent.getAction()).equals(_intent.ACTION_VIEW) == false) { 
if (true) return "";};
 //BA.debugLineNum = 87;BA.debugLine="Try";
try { //BA.debugLineNum = 88;BA.debugLine="Dim uri As Object = Intent.GetData";
_uri = (Object)(_intent.GetData());
 //BA.debugLineNum = 89;BA.debugLine="If uri = Null Then Return";
if (_uri== null) { 
if (true) return "";};
 //BA.debugLineNum = 91;BA.debugLine="Log(\"=== Arquivo .lockzero recebido ===\")";
anywheresoftware.b4a.keywords.Common.LogImpl("564094221","=== Arquivo .lockzero recebido ===",0);
 //BA.debugLineNum = 92;BA.debugLine="Log(\"URI: \" & uri)";
anywheresoftware.b4a.keywords.Common.LogImpl("564094222","URI: "+BA.ObjectToString(_uri),0);
 //BA.debugLineNum = 95;BA.debugLine="Dim fileName As String = \"imported_\" & DateTime.";
_filename = "imported_"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.getNow())+".lockzero";
 //BA.debugLineNum = 96;BA.debugLine="Dim destFolder As String = Starter.Provider.Shar";
_destfolder = mostCurrent._starter._provider /*com.lockzero.fileprovider*/ ._sharedfolder /*String*/ ;
 //BA.debugLineNum = 99;BA.debugLine="Dim In As InputStream = ContentResolver_OpenInpu";
_in = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
_in = _contentresolver_openinputstream(_uri);
 //BA.debugLineNum = 100;BA.debugLine="Dim Out As OutputStream = File.OpenOutput(destFo";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(_destfolder,_filename,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 101;BA.debugLine="File.Copy2(In, Out)";
anywheresoftware.b4a.keywords.Common.File.Copy2((java.io.InputStream)(_in.getObject()),(java.io.OutputStream)(_out.getObject()));
 //BA.debugLineNum = 102;BA.debugLine="In.Close";
_in.Close();
 //BA.debugLineNum = 103;BA.debugLine="Out.Close";
_out.Close();
 //BA.debugLineNum = 105;BA.debugLine="Log(\"Arquivo copiado para: \" & destFolder & \"/\"";
anywheresoftware.b4a.keywords.Common.LogImpl("564094235","Arquivo copiado para: "+_destfolder+"/"+_filename,0);
 //BA.debugLineNum = 108;BA.debugLine="Dim fileSize As Long = File.Size(destFolder, fil";
_filesize = anywheresoftware.b4a.keywords.Common.File.Size(_destfolder,_filename);
 //BA.debugLineNum = 109;BA.debugLine="Log(\"Tamanho do arquivo: \" & fileSize & \" bytes\"";
anywheresoftware.b4a.keywords.Common.LogImpl("564094239","Tamanho do arquivo: "+BA.NumberToString(_filesize)+" bytes",0);
 //BA.debugLineNum = 110;BA.debugLine="If fileSize > 0 Then";
if (_filesize>0) { 
 //BA.debugLineNum = 111;BA.debugLine="Dim content As String = File.ReadString(destFol";
_content = anywheresoftware.b4a.keywords.Common.File.ReadString(_destfolder,_filename);
 //BA.debugLineNum = 112;BA.debugLine="Log(\"Primeiros 100 chars: \" & content.SubString";
anywheresoftware.b4a.keywords.Common.LogImpl("564094242","Primeiros 100 chars: "+_content.substring((int) (0),(int) (anywheresoftware.b4a.keywords.Common.Min(100,_content.length()))),0);
 };
 //BA.debugLineNum = 116;BA.debugLine="PendingBackupFile = fileName";
_pendingbackupfile = _filename;
 //BA.debugLineNum = 119;BA.debugLine="B4XPages.ShowPage(\"PageBackup\")";
mostCurrent._b4xpages._showpage /*String*/ (mostCurrent.activityBA,"PageBackup");
 } 
       catch (Exception e27) {
			processBA.setLastException(e27); //BA.debugLineNum = 122;BA.debugLine="Log(\"CheckIncomingIntent erro: \" & LastException";
anywheresoftware.b4a.keywords.Common.LogImpl("564094252","CheckIncomingIntent erro: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.streams.File.InputStreamWrapper  _contentresolver_openinputstream(Object _uri) throws Exception{
String _uristring = "";
anywheresoftware.b4j.object.JavaObject _androiduri = null;
anywheresoftware.b4j.object.JavaObject _parseduri = null;
anywheresoftware.b4j.object.JavaObject _ctxt = null;
anywheresoftware.b4j.object.JavaObject _cr = null;
 //BA.debugLineNum = 127;BA.debugLine="Private Sub ContentResolver_OpenInputStream(uri As";
 //BA.debugLineNum = 129;BA.debugLine="Dim uriString As String = uri";
_uristring = BA.ObjectToString(_uri);
 //BA.debugLineNum = 132;BA.debugLine="Dim androidUri As JavaObject";
_androiduri = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 133;BA.debugLine="androidUri.InitializeStatic(\"android.net.Uri\")";
_androiduri.InitializeStatic("android.net.Uri");
 //BA.debugLineNum = 134;BA.debugLine="Dim parsedUri As JavaObject = androidUri.RunMetho";
_parseduri = new anywheresoftware.b4j.object.JavaObject();
_parseduri = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_androiduri.RunMethod("parse",new Object[]{(Object)(_uristring)})));
 //BA.debugLineNum = 137;BA.debugLine="Dim ctxt As JavaObject";
_ctxt = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 138;BA.debugLine="ctxt.InitializeContext";
_ctxt.InitializeContext(processBA);
 //BA.debugLineNum = 139;BA.debugLine="Dim cr As JavaObject = ctxt.RunMethod(\"getContent";
_cr = new anywheresoftware.b4j.object.JavaObject();
_cr = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_ctxt.RunMethod("getContentResolver",(Object[])(anywheresoftware.b4a.keywords.Common.Null))));
 //BA.debugLineNum = 142;BA.debugLine="Return cr.RunMethod(\"openInputStream\", Array(pars";
if (true) return (anywheresoftware.b4a.objects.streams.File.InputStreamWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper(), (java.io.InputStream)(_cr.RunMethod("openInputStream",new Object[]{(Object)(_parseduri.getObject())})));
 //BA.debugLineNum = 143;BA.debugLine="End Sub";
return null;
}
public static String  _create_menu(Object _menu) throws Exception{
 //BA.debugLineNum = 172;BA.debugLine="Sub Create_Menu (Menu As Object)";
 //BA.debugLineNum = 173;BA.debugLine="B4XPages.Delegate.Create_Menu(Menu)";
mostCurrent._b4xpages._delegate /*com.lockzero.b4xpagesdelegator*/ ._create_menu /*String*/ (_menu);
 //BA.debugLineNum = 174;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 24;BA.debugLine="Private pgPasswords As PagePasswords";
mostCurrent._pgpasswords = new com.lockzero.pagepasswords();
 //BA.debugLineNum = 25;BA.debugLine="Private pgPasswordList As PagePasswordList";
mostCurrent._pgpasswordlist = new com.lockzero.pagepasswordlist();
 //BA.debugLineNum = 26;BA.debugLine="Private pgPasswordEdit As PagePasswordEdit";
mostCurrent._pgpasswordedit = new com.lockzero.pagepasswordedit();
 //BA.debugLineNum = 27;BA.debugLine="Private pgBackup As PageBackup";
mostCurrent._pgbackup = new com.lockzero.pagebackup();
 //BA.debugLineNum = 28;BA.debugLine="Private pgOnboarding As PageOnboarding";
mostCurrent._pgonboarding = new com.lockzero.pageonboarding();
 //BA.debugLineNum = 29;BA.debugLine="Private pgNotesList As PageNotesList";
mostCurrent._pgnoteslist = new com.lockzero.pagenoteslist();
 //BA.debugLineNum = 30;BA.debugLine="Private pgNoteEdit As PageNoteEdit";
mostCurrent._pgnoteedit = new com.lockzero.pagenoteedit();
 //BA.debugLineNum = 31;BA.debugLine="Private pgSettings As PageSettings";
mostCurrent._pgsettings = new com.lockzero.pagesettings();
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        b4a.example.dateutils._process_globals();
main._process_globals();
starter._process_globals();
modbackup._process_globals();
modlang._process_globals();
modnotes._process_globals();
modpasswords._process_globals();
modsecurity._process_globals();
modsession._process_globals();
modtheme._process_globals();
b4xpages._process_globals();
b4xcollections._process_globals();
xuiviewsutils._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Public ActionBarHomeClicked As Boolean";
_actionbarhomeclicked = false;
 //BA.debugLineNum = 19;BA.debugLine="Public PendingBackupFile As String 'Arquivo .lock";
_pendingbackupfile = "";
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return "";
}
public static String  _setpagetitle(String _title) throws Exception{
 //BA.debugLineNum = 188;BA.debugLine="Public Sub SetPageTitle(title As String)";
 //BA.debugLineNum = 189;BA.debugLine="Activity.Title = title";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence(_title));
 //BA.debugLineNum = 190;BA.debugLine="End Sub";
return "";
}
public boolean _onCreateOptionsMenu(android.view.Menu menu) {
	 processBA.raiseEvent(null, "create_menu", menu);
	 return true;
	
}
}
