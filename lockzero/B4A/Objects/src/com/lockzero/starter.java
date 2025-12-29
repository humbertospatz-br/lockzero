package com.lockzero;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class starter extends android.app.Service{
	public static class starter_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (starter) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, starter.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, true, BA.class);
		}

	}
    static starter mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return starter.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new BA(this, null, null, "com.lockzero", "com.lockzero.starter");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "com.lockzero.starter", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!true && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (starter) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (true) {
			if (ServiceHelper.StarterHelper.runWaitForLayouts() == false) {
                BA.LogInfo("stopping spontaneous created service");
                stopSelf();
            }
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() {
            public void run() {
                handleStart(intent);
            }}))
			;
		else {
			ServiceHelper.StarterHelper.addWaitForLayout (new Runnable() {
				public void run() {
                    processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (starter) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
                    ServiceHelper.StarterHelper.removeWaitForLayout();
				}
			});
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    public void onTaskRemoved(android.content.Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if (true)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (starter) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = ServiceHelper.StarterHelper.handleStartIntent(intent, _service, processBA);
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }

	public void onTimeout(int startId) {
        BA.LogInfo("** Service (starter) Timeout **");
        anywheresoftware.b4a.objects.collections.Map params = new anywheresoftware.b4a.objects.collections.Map();
        params.Initialize();
        params.Put("StartId", startId);
        processBA.raiseEvent(null, "service_timeout", params);
            
    }
	@Override
	public void onDestroy() {
        super.onDestroy();
        if (true) {
            BA.LogInfo("** Service (starter) Destroy (ignored)**");
        }
        else {
            BA.LogInfo("** Service (starter) Destroy **");
		    processBA.raiseEvent(null, "service_destroy");
            processBA.service = null;
		    mostCurrent = null;
		    processBA.setActivityPaused(true);
            processBA.runHook("ondestroy", this, null);
        }
	}

@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}public anywheresoftware.b4a.keywords.Common __c = null;
public static String _app_name = "";
public static String _app_version = "";
public static String _app_tagline = "";
public static float _font_title = 0f;
public static float _font_subtitle = 0f;
public static float _font_body = 0f;
public static float _font_label = 0f;
public static float _font_caption = 0f;
public static float _font_button = 0f;
public static float _font_input = 0f;
public static int _height_header = 0;
public static int _height_button = 0;
public static int _height_input = 0;
public static int _height_item = 0;
public static int _height_item_large = 0;
public static int _margin_page = 0;
public static int _margin_item = 0;
public static int _padding_card = 0;
public static String _icon_eye_open = "";
public static String _icon_eye_closed = "";
public static String _icon_back = "";
public static String _icon_add = "";
public static String _icon_lock = "";
public static String _icon_unlock = "";
public static String _icon_star = "";
public static String _icon_settings = "";
public static String _icon_copy = "";
public static String _icon_edit = "";
public static String _icon_delete = "";
public static boolean _isinitialized = false;
public static com.lockzero.fileprovider _provider = null;
public b4a.example.dateutils _dateutils = null;
public com.lockzero.main _main = null;
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
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
 //BA.debugLineNum = 71;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
 //BA.debugLineNum = 72;BA.debugLine="Log(\"=== ERRO CRITICO ===\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7589825","=== ERRO CRITICO ===",0);
 //BA.debugLineNum = 73;BA.debugLine="Log(\"Erro: \" & Error.Message)";
anywheresoftware.b4a.keywords.Common.LogImpl("7589826","Erro: "+_error.getMessage(),0);
 //BA.debugLineNum = 74;BA.debugLine="Log(\"Stack: \" & StackTrace)";
anywheresoftware.b4a.keywords.Common.LogImpl("7589827","Stack: "+_stacktrace,0);
 //BA.debugLineNum = 75;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 76;BA.debugLine="End Sub";
return false;
}
public static String  _getversionstring() throws Exception{
 //BA.debugLineNum = 118;BA.debugLine="Public Sub GetVersionString As String";
 //BA.debugLineNum = 119;BA.debugLine="Return APP_NAME & \" v\" & APP_VERSION";
if (true) return _app_name+" v"+_app_version;
 //BA.debugLineNum = 120;BA.debugLine="End Sub";
return "";
}
public static String  _initializeapp() throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="Private Sub InitializeApp";
 //BA.debugLineNum = 88;BA.debugLine="If IsInitialized Then Return";
if (_isinitialized) { 
if (true) return "";};
 //BA.debugLineNum = 90;BA.debugLine="Log(\"=== LockZero \" & APP_VERSION & \" ===\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7720899","=== LockZero "+_app_version+" ===",0);
 //BA.debugLineNum = 91;BA.debugLine="Log(\"Inicializando...\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7720900","Inicializando...",0);
 //BA.debugLineNum = 94;BA.debugLine="ModLang.Init";
mostCurrent._modlang._init /*String*/ (processBA);
 //BA.debugLineNum = 95;BA.debugLine="Log(\"ModLang OK - Idioma: \" & ModLang.GetCurrentL";
anywheresoftware.b4a.keywords.Common.LogImpl("7720904","ModLang OK - Idioma: "+mostCurrent._modlang._getcurrentlanguage /*String*/ (processBA),0);
 //BA.debugLineNum = 98;BA.debugLine="ModTheme.Init";
mostCurrent._modtheme._init /*String*/ (processBA);
 //BA.debugLineNum = 99;BA.debugLine="Log(\"ModTheme OK - Dark: \" & ModTheme.IsDarkTheme";
anywheresoftware.b4a.keywords.Common.LogImpl("7720908","ModTheme OK - Dark: "+BA.ObjectToString(mostCurrent._modtheme._isdarktheme /*boolean*/ ),0);
 //BA.debugLineNum = 102;BA.debugLine="Provider.Initialize";
_provider._initialize /*String*/ (processBA);
 //BA.debugLineNum = 103;BA.debugLine="Log(\"FileProvider OK - SharedFolder: \" & Provider";
anywheresoftware.b4a.keywords.Common.LogImpl("7720912","FileProvider OK - SharedFolder: "+_provider._sharedfolder /*String*/ ,0);
 //BA.debugLineNum = 106;BA.debugLine="ModSession.EndSession";
mostCurrent._modsession._endsession /*String*/ (processBA);
 //BA.debugLineNum = 107;BA.debugLine="Log(\"ModSession OK - Bloqueado\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7720916","ModSession OK - Bloqueado",0);
 //BA.debugLineNum = 109;BA.debugLine="IsInitialized = True";
_isinitialized = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 110;BA.debugLine="Log(\"=== Inicializacao completa ===\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7720919","=== Inicializacao completa ===",0);
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 9;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 11;BA.debugLine="Public Const APP_NAME As String = \"LockZero\"";
_app_name = "LockZero";
 //BA.debugLineNum = 12;BA.debugLine="Public Const APP_VERSION As String = \"0.1.0\"";
_app_version = "0.1.0";
 //BA.debugLineNum = 13;BA.debugLine="Public Const APP_TAGLINE As String = \"Lock and ZE";
_app_tagline = "Lock and ZERO worries";
 //BA.debugLineNum = 16;BA.debugLine="Public Const FONT_TITLE As Float = 22       'Titu";
_font_title = (float) (22);
 //BA.debugLineNum = 17;BA.debugLine="Public Const FONT_SUBTITLE As Float = 18    'Subt";
_font_subtitle = (float) (18);
 //BA.debugLineNum = 18;BA.debugLine="Public Const FONT_BODY As Float = 15        'Text";
_font_body = (float) (15);
 //BA.debugLineNum = 19;BA.debugLine="Public Const FONT_LABEL As Float = 13       'Labe";
_font_label = (float) (13);
 //BA.debugLineNum = 20;BA.debugLine="Public Const FONT_CAPTION As Float = 12     'Text";
_font_caption = (float) (12);
 //BA.debugLineNum = 21;BA.debugLine="Public Const FONT_BUTTON As Float = 14      'Text";
_font_button = (float) (14);
 //BA.debugLineNum = 22;BA.debugLine="Public Const FONT_INPUT As Float = 15       'Text";
_font_input = (float) (15);
 //BA.debugLineNum = 25;BA.debugLine="Public Const HEIGHT_HEADER As Int = 56      'Altu";
_height_header = (int) (56);
 //BA.debugLineNum = 26;BA.debugLine="Public Const HEIGHT_BUTTON As Int = 48      'Altu";
_height_button = (int) (48);
 //BA.debugLineNum = 27;BA.debugLine="Public Const HEIGHT_INPUT As Int = 48       'Altu";
_height_input = (int) (48);
 //BA.debugLineNum = 28;BA.debugLine="Public Const HEIGHT_ITEM As Int = 72        'Altu";
_height_item = (int) (72);
 //BA.debugLineNum = 29;BA.debugLine="Public Const HEIGHT_ITEM_LARGE As Int = 88  'Item";
_height_item_large = (int) (88);
 //BA.debugLineNum = 32;BA.debugLine="Public Const MARGIN_PAGE As Int = 16        'Marg";
_margin_page = (int) (16);
 //BA.debugLineNum = 33;BA.debugLine="Public Const MARGIN_ITEM As Int = 12        'Espa";
_margin_item = (int) (12);
 //BA.debugLineNum = 34;BA.debugLine="Public Const PADDING_CARD As Int = 16       'Padd";
_padding_card = (int) (16);
 //BA.debugLineNum = 37;BA.debugLine="Public Const ICON_EYE_OPEN As String = Chr(0x25C9";
_icon_eye_open = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0x25c9)));
 //BA.debugLineNum = 38;BA.debugLine="Public Const ICON_EYE_CLOSED As String = Chr(0x20";
_icon_eye_closed = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0x2022)))+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0x2022)))+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0x2022)));
 //BA.debugLineNum = 39;BA.debugLine="Public Const ICON_BACK As String = Chr(0x25C0)";
_icon_back = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0x25c0)));
 //BA.debugLineNum = 40;BA.debugLine="Public Const ICON_ADD As String = \"+\"";
_icon_add = "+";
 //BA.debugLineNum = 41;BA.debugLine="Public Const ICON_LOCK As String = Chr(0x25C6)";
_icon_lock = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0x25c6)));
 //BA.debugLineNum = 42;BA.debugLine="Public Const ICON_UNLOCK As String = Chr(0x25C7)";
_icon_unlock = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0x25c7)));
 //BA.debugLineNum = 43;BA.debugLine="Public Const ICON_STAR As String = Chr(0x2605)";
_icon_star = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0x2605)));
 //BA.debugLineNum = 44;BA.debugLine="Public Const ICON_SETTINGS As String = Chr(0x2699";
_icon_settings = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0x2699)));
 //BA.debugLineNum = 45;BA.debugLine="Public Const ICON_COPY As String = Chr(0x25A1)";
_icon_copy = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0x25a1)));
 //BA.debugLineNum = 46;BA.debugLine="Public Const ICON_EDIT As String = Chr(0x270E)";
_icon_edit = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0x270e)));
 //BA.debugLineNum = 47;BA.debugLine="Public Const ICON_DELETE As String = Chr(0x2716)";
_icon_delete = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0x2716)));
 //BA.debugLineNum = 50;BA.debugLine="Private IsInitialized As Boolean = False";
_isinitialized = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 53;BA.debugLine="Public Provider As FileProvider";
_provider = new com.lockzero.fileprovider();
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
 //BA.debugLineNum = 56;BA.debugLine="Sub Service_Create";
 //BA.debugLineNum = 59;BA.debugLine="InitializeApp";
_initializeapp();
 //BA.debugLineNum = 60;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
 //BA.debugLineNum = 78;BA.debugLine="Sub Service_Destroy";
 //BA.debugLineNum = 80;BA.debugLine="ModSession.EndSession";
mostCurrent._modsession._endsession /*String*/ (processBA);
 //BA.debugLineNum = 81;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
 //BA.debugLineNum = 62;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
 //BA.debugLineNum = 63;BA.debugLine="Service.StopAutomaticForeground";
mostCurrent._service.StopAutomaticForeground();
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return "";
}
public static String  _service_taskremoved() throws Exception{
 //BA.debugLineNum = 66;BA.debugLine="Sub Service_TaskRemoved";
 //BA.debugLineNum = 68;BA.debugLine="ModSession.EndSession";
mostCurrent._modsession._endsession /*String*/ (processBA);
 //BA.debugLineNum = 69;BA.debugLine="End Sub";
return "";
}
}
