package com.lockzero;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class modsession {
private static modsession mostCurrent = new modsession();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public static String _phraseobfuscated = "";
public static String _sessionsalt = "";
public static long _sessionstarttime = 0L;
public static long _lastactivitytime = 0L;
public static boolean _isunlocked = false;
public static String _sessioncategory = "";
public b4a.example.dateutils _dateutils = null;
public com.lockzero.main _main = null;
public com.lockzero.starter _starter = null;
public com.lockzero.modbackup _modbackup = null;
public com.lockzero.modlang _modlang = null;
public com.lockzero.modnotes _modnotes = null;
public com.lockzero.modpasswords _modpasswords = null;
public com.lockzero.modsecurity _modsecurity = null;
public com.lockzero.modtheme _modtheme = null;
public com.lockzero.b4xpages _b4xpages = null;
public com.lockzero.b4xcollections _b4xcollections = null;
public com.lockzero.xuiviewsutils _xuiviewsutils = null;
public static String  _decrypt(anywheresoftware.b4a.BA _ba,String _enctext) throws Exception{
 //BA.debugLineNum = 220;BA.debugLine="Public Sub Decrypt(encText As String) As String";
 //BA.debugLineNum = 221;BA.debugLine="If IsSessionActive = False Then Return \"\"";
if (_issessionactive(_ba)==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 222;BA.debugLine="Return ModSecurity.Decrypt(GetPassphrase, encText";
if (true) return mostCurrent._modsecurity._decrypt /*String*/ (_ba,_getpassphrase(_ba),_enctext);
 //BA.debugLineNum = 223;BA.debugLine="End Sub";
return "";
}
public static String  _encrypt(anywheresoftware.b4a.BA _ba,String _plaintext) throws Exception{
 //BA.debugLineNum = 214;BA.debugLine="Public Sub Encrypt(plainText As String) As String";
 //BA.debugLineNum = 215;BA.debugLine="If IsSessionActive = False Then Return \"\"";
if (_issessionactive(_ba)==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 216;BA.debugLine="Return ModSecurity.Encrypt(GetPassphrase, plainTe";
if (true) return mostCurrent._modsecurity._encrypt /*String*/ (_ba,_getpassphrase(_ba),_plaintext);
 //BA.debugLineNum = 217;BA.debugLine="End Sub";
return "";
}
public static String  _endsession(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 102;BA.debugLine="Public Sub EndSession";
 //BA.debugLineNum = 103;BA.debugLine="PhraseObfuscated = \"\"";
_phraseobfuscated = "";
 //BA.debugLineNum = 104;BA.debugLine="SessionSalt = \"\"";
_sessionsalt = "";
 //BA.debugLineNum = 105;BA.debugLine="SessionStartTime = 0";
_sessionstarttime = (long) (0);
 //BA.debugLineNum = 106;BA.debugLine="LastActivityTime = 0";
_lastactivitytime = (long) (0);
 //BA.debugLineNum = 107;BA.debugLine="IsUnlocked = False";
_isunlocked = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 108;BA.debugLine="SessionCategory = \"\"";
_sessioncategory = "";
 //BA.debugLineNum = 109;BA.debugLine="Log(\"ModSession: Sessao encerrada\")";
anywheresoftware.b4a.keywords.Common.LogImpl("546727175","ModSession: Sessao encerrada",0);
 //BA.debugLineNum = 110;BA.debugLine="End Sub";
return "";
}
public static int  _getinactivetime(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 148;BA.debugLine="Public Sub GetInactiveTime As Int";
 //BA.debugLineNum = 149;BA.debugLine="If IsUnlocked = False Then Return 0";
if (_isunlocked==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return (int) (0);};
 //BA.debugLineNum = 150;BA.debugLine="Return (DateTime.Now - LastActivityTime) / 1000";
if (true) return (int) ((anywheresoftware.b4a.keywords.Common.DateTime.getNow()-_lastactivitytime)/(double)1000);
 //BA.debugLineNum = 151;BA.debugLine="End Sub";
return 0;
}
public static String  _getpassphrase(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="Public Sub GetPassphrase As String";
 //BA.debugLineNum = 88;BA.debugLine="If IsSessionActive Then";
if (_issessionactive(_ba)) { 
 //BA.debugLineNum = 89;BA.debugLine="Return Obfuscate(PhraseObfuscated, SessionSalt)";
if (true) return _obfuscate(_ba,_phraseobfuscated,_sessionsalt);
 };
 //BA.debugLineNum = 91;BA.debugLine="Return \"\"";
if (true) return "";
 //BA.debugLineNum = 92;BA.debugLine="End Sub";
return "";
}
public static String  _getremainingformatted(anywheresoftware.b4a.BA _ba) throws Exception{
int _secs = 0;
int _mins = 0;
int _secsrest = 0;
 //BA.debugLineNum = 134;BA.debugLine="Public Sub GetRemainingFormatted As String";
 //BA.debugLineNum = 135;BA.debugLine="Dim secs As Int = GetRemainingSeconds";
_secs = _getremainingseconds(_ba);
 //BA.debugLineNum = 136;BA.debugLine="Dim mins As Int = secs / 60";
_mins = (int) (_secs/(double)60);
 //BA.debugLineNum = 137;BA.debugLine="Dim secsRest As Int = secs Mod 60";
_secsrest = (int) (_secs%60);
 //BA.debugLineNum = 138;BA.debugLine="Return NumberFormat(mins, 1, 0) & \":\" & NumberFor";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_mins,(int) (1),(int) (0))+":"+anywheresoftware.b4a.keywords.Common.NumberFormat(_secsrest,(int) (2),(int) (0));
 //BA.debugLineNum = 139;BA.debugLine="End Sub";
return "";
}
public static int  _getremainingseconds(anywheresoftware.b4a.BA _ba) throws Exception{
int _timeoutseconds = 0;
long _elapsed = 0L;
int _remaining = 0;
 //BA.debugLineNum = 122;BA.debugLine="Public Sub GetRemainingSeconds As Int";
 //BA.debugLineNum = 123;BA.debugLine="If IsSessionActive = False Then Return 0";
if (_issessionactive(_ba)==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return (int) (0);};
 //BA.debugLineNum = 125;BA.debugLine="Dim timeoutSeconds As Int = ModSecurity.GetSessio";
_timeoutseconds = mostCurrent._modsecurity._getsessiontimeout /*int*/ (_ba);
 //BA.debugLineNum = 126;BA.debugLine="Dim elapsed As Long = (DateTime.Now - LastActivit";
_elapsed = (long) ((anywheresoftware.b4a.keywords.Common.DateTime.getNow()-_lastactivitytime)/(double)1000);
 //BA.debugLineNum = 127;BA.debugLine="Dim remaining As Int = timeoutSeconds - elapsed";
_remaining = (int) (_timeoutseconds-_elapsed);
 //BA.debugLineNum = 129;BA.debugLine="If remaining < 0 Then Return 0";
if (_remaining<0) { 
if (true) return (int) (0);};
 //BA.debugLineNum = 130;BA.debugLine="Return remaining";
if (true) return _remaining;
 //BA.debugLineNum = 131;BA.debugLine="End Sub";
return 0;
}
public static String  _getsessioncategory(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 159;BA.debugLine="Public Sub GetSessionCategory As String";
 //BA.debugLineNum = 160;BA.debugLine="If IsSessionActive = False Then Return \"\"";
if (_issessionactive(_ba)==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 161;BA.debugLine="Return SessionCategory";
if (true) return _sessioncategory;
 //BA.debugLineNum = 162;BA.debugLine="End Sub";
return "";
}
public static String  _getsessioncategoryname(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 165;BA.debugLine="Public Sub GetSessionCategoryName As String";
 //BA.debugLineNum = 166;BA.debugLine="If IsSessionActive = False Then Return \"\"";
if (_issessionactive(_ba)==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 167;BA.debugLine="If SessionCategory = \"\" Then Return \"\"";
if ((_sessioncategory).equals("")) { 
if (true) return "";};
 //BA.debugLineNum = 169;BA.debugLine="Select SessionCategory";
switch (BA.switchObjectToInt(_sessioncategory,"passwords","cards","documents","notes","wifi")) {
case 0: {
 //BA.debugLineNum = 170;BA.debugLine="Case \"passwords\": Return ModLang.T(\"passwords\")";
if (true) return mostCurrent._modlang._t /*String*/ (_ba,"passwords");
 break; }
case 1: {
 //BA.debugLineNum = 171;BA.debugLine="Case \"cards\": Return ModLang.T(\"cards\")";
if (true) return mostCurrent._modlang._t /*String*/ (_ba,"cards");
 break; }
case 2: {
 //BA.debugLineNum = 172;BA.debugLine="Case \"documents\": Return ModLang.T(\"documents\")";
if (true) return mostCurrent._modlang._t /*String*/ (_ba,"documents");
 break; }
case 3: {
 //BA.debugLineNum = 173;BA.debugLine="Case \"notes\": Return ModLang.T(\"notes\")";
if (true) return mostCurrent._modlang._t /*String*/ (_ba,"notes");
 break; }
case 4: {
 //BA.debugLineNum = 174;BA.debugLine="Case \"wifi\": Return ModLang.T(\"wifi\")";
if (true) return mostCurrent._modlang._t /*String*/ (_ba,"wifi");
 break; }
default: {
 //BA.debugLineNum = 175;BA.debugLine="Case Else: Return SessionCategory";
if (true) return _sessioncategory;
 break; }
}
;
 //BA.debugLineNum = 177;BA.debugLine="End Sub";
return "";
}
public static int  _getsessionduration(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 142;BA.debugLine="Public Sub GetSessionDuration As Int";
 //BA.debugLineNum = 143;BA.debugLine="If IsUnlocked = False Then Return 0";
if (_isunlocked==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return (int) (0);};
 //BA.debugLineNum = 144;BA.debugLine="Return (DateTime.Now - SessionStartTime) / 1000";
if (true) return (int) ((anywheresoftware.b4a.keywords.Common.DateTime.getNow()-_sessionstarttime)/(double)1000);
 //BA.debugLineNum = 145;BA.debugLine="End Sub";
return 0;
}
public static boolean  _islocked(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 154;BA.debugLine="Public Sub IsLocked As Boolean";
 //BA.debugLineNum = 155;BA.debugLine="Return Not(IsSessionActive)";
if (true) return anywheresoftware.b4a.keywords.Common.Not(_issessionactive(_ba));
 //BA.debugLineNum = 156;BA.debugLine="End Sub";
return false;
}
public static boolean  _issessionactive(anywheresoftware.b4a.BA _ba) throws Exception{
int _timeoutseconds = 0;
long _elapsed = 0L;
 //BA.debugLineNum = 69;BA.debugLine="Public Sub IsSessionActive As Boolean";
 //BA.debugLineNum = 70;BA.debugLine="If IsUnlocked = False Then Return False";
if (_isunlocked==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 71;BA.debugLine="If PhraseObfuscated = \"\" Then Return False";
if ((_phraseobfuscated).equals("")) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 74;BA.debugLine="Dim timeoutSeconds As Int = ModSecurity.GetSessio";
_timeoutseconds = mostCurrent._modsecurity._getsessiontimeout /*int*/ (_ba);
 //BA.debugLineNum = 75;BA.debugLine="Dim elapsed As Long = (DateTime.Now - LastActivit";
_elapsed = (long) ((anywheresoftware.b4a.keywords.Common.DateTime.getNow()-_lastactivitytime)/(double)1000);
 //BA.debugLineNum = 77;BA.debugLine="If elapsed > timeoutSeconds Then";
if (_elapsed>_timeoutseconds) { 
 //BA.debugLineNum = 78;BA.debugLine="Log(\"ModSession: Timeout (\" & elapsed & \"s > \" &";
anywheresoftware.b4a.keywords.Common.LogImpl("546530569","ModSession: Timeout ("+BA.NumberToString(_elapsed)+"s > "+BA.NumberToString(_timeoutseconds)+"s)",0);
 //BA.debugLineNum = 79;BA.debugLine="EndSession";
_endsession(_ba);
 //BA.debugLineNum = 80;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 83;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
return false;
}
public static boolean  _issessionvalidforcategory(anywheresoftware.b4a.BA _ba,String _category) throws Exception{
 //BA.debugLineNum = 182;BA.debugLine="Public Sub IsSessionValidForCategory(category As S";
 //BA.debugLineNum = 183;BA.debugLine="If IsSessionActive = False Then Return False";
if (_issessionactive(_ba)==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 186;BA.debugLine="If ModSecurity.GetUseSinglePassphrase Then Return";
if (mostCurrent._modsecurity._getusesinglepassphrase /*boolean*/ (_ba)) { 
if (true) return anywheresoftware.b4a.keywords.Common.True;};
 //BA.debugLineNum = 189;BA.debugLine="Return SessionCategory = category Or SessionCateg";
if (true) return (_sessioncategory).equals(_category) || (_sessioncategory).equals("");
 //BA.debugLineNum = 190;BA.debugLine="End Sub";
return false;
}
public static String  _lock(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 113;BA.debugLine="Public Sub Lock";
 //BA.debugLineNum = 114;BA.debugLine="EndSession";
_endsession(_ba);
 //BA.debugLineNum = 115;BA.debugLine="End Sub";
return "";
}
public static boolean  _needspassphraseforcategory(anywheresoftware.b4a.BA _ba,String _category) throws Exception{
 //BA.debugLineNum = 194;BA.debugLine="Public Sub NeedsPassphraseForCategory(category As";
 //BA.debugLineNum = 196;BA.debugLine="If IsSessionActive = False Then Return True";
if (_issessionactive(_ba)==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return anywheresoftware.b4a.keywords.Common.True;};
 //BA.debugLineNum = 199;BA.debugLine="If ModSecurity.GetUseSinglePassphrase Then Return";
if (mostCurrent._modsecurity._getusesinglepassphrase /*boolean*/ (_ba)) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 202;BA.debugLine="If SessionCategory = category Then Return False";
if ((_sessioncategory).equals(_category)) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 205;BA.debugLine="EndSession";
_endsession(_ba);
 //BA.debugLineNum = 206;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 207;BA.debugLine="End Sub";
return false;
}
public static String  _obfuscate(anywheresoftware.b4a.BA _ba,String _text,String _salt) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _result = null;
int _i = 0;
int _t = 0;
int _s = 0;
int _x = 0;
 //BA.debugLineNum = 55;BA.debugLine="Private Sub Obfuscate(text As String, salt As Stri";
 //BA.debugLineNum = 56;BA.debugLine="If text = \"\" Or salt = \"\" Then Return \"\"";
if ((_text).equals("") || (_salt).equals("")) { 
if (true) return "";};
 //BA.debugLineNum = 57;BA.debugLine="Dim result As StringBuilder";
_result = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 58;BA.debugLine="result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 59;BA.debugLine="For i = 0 To text.Length - 1";
{
final int step4 = 1;
final int limit4 = (int) (_text.length()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 60;BA.debugLine="Dim t As Int = Asc(text.CharAt(i))";
_t = anywheresoftware.b4a.keywords.Common.Asc(_text.charAt(_i));
 //BA.debugLineNum = 61;BA.debugLine="Dim s As Int = Asc(salt.CharAt(i Mod salt.Length";
_s = anywheresoftware.b4a.keywords.Common.Asc(_salt.charAt((int) (_i%_salt.length())));
 //BA.debugLineNum = 62;BA.debugLine="Dim x As Int = Bit.Xor(t, s)";
_x = anywheresoftware.b4a.keywords.Common.Bit.Xor(_t,_s);
 //BA.debugLineNum = 63;BA.debugLine="result.Append(Chr(x))";
_result.Append(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(_x)));
 }
};
 //BA.debugLineNum = 65;BA.debugLine="Return result.ToString";
if (true) return _result.ToString();
 //BA.debugLineNum = 66;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 5;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Private PhraseObfuscated As String";
_phraseobfuscated = "";
 //BA.debugLineNum = 9;BA.debugLine="Private SessionSalt As String";
_sessionsalt = "";
 //BA.debugLineNum = 12;BA.debugLine="Private SessionStartTime As Long";
_sessionstarttime = 0L;
 //BA.debugLineNum = 13;BA.debugLine="Private LastActivityTime As Long";
_lastactivitytime = 0L;
 //BA.debugLineNum = 16;BA.debugLine="Private IsUnlocked As Boolean = False";
_isunlocked = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 20;BA.debugLine="Private SessionCategory As String = \"\"";
_sessioncategory = "";
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
public static String  _startsession(anywheresoftware.b4a.BA _ba,String _phrase) throws Exception{
 //BA.debugLineNum = 29;BA.debugLine="Public Sub StartSession(phrase As String)";
 //BA.debugLineNum = 30;BA.debugLine="StartSessionWithCategory(phrase, \"\")";
_startsessionwithcategory(_ba,_phrase,"");
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return "";
}
public static String  _startsessionwithcategory(anywheresoftware.b4a.BA _ba,String _phrase,String _category) throws Exception{
 //BA.debugLineNum = 35;BA.debugLine="Public Sub StartSessionWithCategory(phrase As Stri";
 //BA.debugLineNum = 37;BA.debugLine="SessionSalt = ModSecurity.GenerateRandomSalt";
_sessionsalt = mostCurrent._modsecurity._generaterandomsalt /*String*/ (_ba);
 //BA.debugLineNum = 40;BA.debugLine="PhraseObfuscated = Obfuscate(phrase, SessionSalt)";
_phraseobfuscated = _obfuscate(_ba,_phrase,_sessionsalt);
 //BA.debugLineNum = 42;BA.debugLine="SessionStartTime = DateTime.Now";
_sessionstarttime = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 //BA.debugLineNum = 43;BA.debugLine="LastActivityTime = DateTime.Now";
_lastactivitytime = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 //BA.debugLineNum = 44;BA.debugLine="IsUnlocked = True";
_isunlocked = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 45;BA.debugLine="SessionCategory = category";
_sessioncategory = _category;
 //BA.debugLineNum = 47;BA.debugLine="If category <> \"\" Then";
if ((_category).equals("") == false) { 
 //BA.debugLineNum = 48;BA.debugLine="Log(\"ModSession: Sessao iniciada para categoria:";
anywheresoftware.b4a.keywords.Common.LogImpl("546399501","ModSession: Sessao iniciada para categoria: "+_category,0);
 }else {
 //BA.debugLineNum = 50;BA.debugLine="Log(\"ModSession: Sessao iniciada (global)\")";
anywheresoftware.b4a.keywords.Common.LogImpl("546399503","ModSession: Sessao iniciada (global)",0);
 };
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public static String  _touch(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 95;BA.debugLine="Public Sub Touch";
 //BA.debugLineNum = 96;BA.debugLine="If IsUnlocked Then";
if (_isunlocked) { 
 //BA.debugLineNum = 97;BA.debugLine="LastActivityTime = DateTime.Now";
_lastactivitytime = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 };
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return "";
}
public static boolean  _validatepassphrase(anywheresoftware.b4a.BA _ba,String _phrase,String _testencrypted,String _testexpected) throws Exception{
String _decrypted = "";
 //BA.debugLineNum = 226;BA.debugLine="Public Sub ValidatePassphrase(phrase As String, te";
 //BA.debugLineNum = 227;BA.debugLine="If testEncrypted = \"\" Or testExpected = \"\" Then R";
if ((_testencrypted).equals("") || (_testexpected).equals("")) { 
if (true) return anywheresoftware.b4a.keywords.Common.True;};
 //BA.debugLineNum = 229;BA.debugLine="Dim decrypted As String = ModSecurity.Decrypt(phr";
_decrypted = mostCurrent._modsecurity._decrypt /*String*/ (_ba,_phrase,_testencrypted);
 //BA.debugLineNum = 230;BA.debugLine="Return decrypted = testExpected";
if (true) return (_decrypted).equals(_testexpected);
 //BA.debugLineNum = 231;BA.debugLine="End Sub";
return false;
}
}
