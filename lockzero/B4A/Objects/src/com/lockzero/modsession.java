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
public static String _normalizedphrasecache = "";
public static long _sessionstarttime = 0L;
public static long _lastactivitytime = 0L;
public static boolean _isunlocked = false;
public static String _sessioncategory = "";
public b4a.example.dateutils _dateutils = null;
public com.lockzero.main _main = null;
public com.lockzero.starter _starter = null;
public com.lockzero.modbackup _modbackup = null;
public com.lockzero.modlang _modlang = null;
public com.lockzero.modpasswords _modpasswords = null;
public com.lockzero.modsecurity _modsecurity = null;
public com.lockzero.modnotes _modnotes = null;
public com.lockzero.modtheme _modtheme = null;
public com.lockzero.modtransition _modtransition = null;
public com.lockzero.b4xpages _b4xpages = null;
public com.lockzero.b4xcollections _b4xcollections = null;
public com.lockzero.xuiviewsutils _xuiviewsutils = null;
public static String  _decrypt(anywheresoftware.b4a.BA _ba,String _enctext) throws Exception{
 //BA.debugLineNum = 236;BA.debugLine="Public Sub Decrypt(encText As String) As String";
 //BA.debugLineNum = 237;BA.debugLine="If IsSessionActive = False Then Return \"\"";
if (_issessionactive(_ba)==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 239;BA.debugLine="Return ModSecurity.DecryptWithNormalized(Normaliz";
if (true) return mostCurrent._modsecurity._decryptwithnormalized /*String*/ (_ba,_normalizedphrasecache,_enctext);
 //BA.debugLineNum = 240;BA.debugLine="End Sub";
return "";
}
public static String  _encrypt(anywheresoftware.b4a.BA _ba,String _plaintext) throws Exception{
 //BA.debugLineNum = 229;BA.debugLine="Public Sub Encrypt(plainText As String) As String";
 //BA.debugLineNum = 230;BA.debugLine="If IsSessionActive = False Then Return \"\"";
if (_issessionactive(_ba)==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 232;BA.debugLine="Return ModSecurity.EncryptWithNormalized(Normaliz";
if (true) return mostCurrent._modsecurity._encryptwithnormalized /*String*/ (_ba,_normalizedphrasecache,_plaintext);
 //BA.debugLineNum = 233;BA.debugLine="End Sub";
return "";
}
public static String  _endsession(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 116;BA.debugLine="Public Sub EndSession";
 //BA.debugLineNum = 117;BA.debugLine="PhraseObfuscated = \"\"";
_phraseobfuscated = "";
 //BA.debugLineNum = 118;BA.debugLine="SessionSalt = \"\"";
_sessionsalt = "";
 //BA.debugLineNum = 119;BA.debugLine="NormalizedPhraseCache = \"\"";
_normalizedphrasecache = "";
 //BA.debugLineNum = 120;BA.debugLine="SessionStartTime = 0";
_sessionstarttime = (long) (0);
 //BA.debugLineNum = 121;BA.debugLine="LastActivityTime = 0";
_lastactivitytime = (long) (0);
 //BA.debugLineNum = 122;BA.debugLine="IsUnlocked = False";
_isunlocked = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 123;BA.debugLine="SessionCategory = \"\"";
_sessioncategory = "";
 //BA.debugLineNum = 124;BA.debugLine="Log(\"ModSession: Sessao encerrada\")";
anywheresoftware.b4a.keywords.Common.LogImpl("626279944","ModSession: Sessao encerrada",0);
 //BA.debugLineNum = 125;BA.debugLine="End Sub";
return "";
}
public static int  _getinactivetime(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 163;BA.debugLine="Public Sub GetInactiveTime As Int";
 //BA.debugLineNum = 164;BA.debugLine="If IsUnlocked = False Then Return 0";
if (_isunlocked==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return (int) (0);};
 //BA.debugLineNum = 165;BA.debugLine="Return (DateTime.Now - LastActivityTime) / 1000";
if (true) return (int) ((anywheresoftware.b4a.keywords.Common.DateTime.getNow()-_lastactivitytime)/(double)1000);
 //BA.debugLineNum = 166;BA.debugLine="End Sub";
return 0;
}
public static String  _getnormalizedpassphrase(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 101;BA.debugLine="Public Sub GetNormalizedPassphrase As String";
 //BA.debugLineNum = 102;BA.debugLine="If IsSessionActive Then";
if (_issessionactive(_ba)) { 
 //BA.debugLineNum = 103;BA.debugLine="Return NormalizedPhraseCache";
if (true) return _normalizedphrasecache;
 };
 //BA.debugLineNum = 105;BA.debugLine="Return \"\"";
if (true) return "";
 //BA.debugLineNum = 106;BA.debugLine="End Sub";
return "";
}
public static String  _getpassphrase(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 93;BA.debugLine="Public Sub GetPassphrase As String";
 //BA.debugLineNum = 94;BA.debugLine="If IsSessionActive Then";
if (_issessionactive(_ba)) { 
 //BA.debugLineNum = 95;BA.debugLine="Return Obfuscate(PhraseObfuscated, SessionSalt)";
if (true) return _obfuscate(_ba,_phraseobfuscated,_sessionsalt);
 };
 //BA.debugLineNum = 97;BA.debugLine="Return \"\"";
if (true) return "";
 //BA.debugLineNum = 98;BA.debugLine="End Sub";
return "";
}
public static String  _getremainingformatted(anywheresoftware.b4a.BA _ba) throws Exception{
int _secs = 0;
int _mins = 0;
int _secsrest = 0;
 //BA.debugLineNum = 149;BA.debugLine="Public Sub GetRemainingFormatted As String";
 //BA.debugLineNum = 150;BA.debugLine="Dim secs As Int = GetRemainingSeconds";
_secs = _getremainingseconds(_ba);
 //BA.debugLineNum = 151;BA.debugLine="Dim mins As Int = secs / 60";
_mins = (int) (_secs/(double)60);
 //BA.debugLineNum = 152;BA.debugLine="Dim secsRest As Int = secs Mod 60";
_secsrest = (int) (_secs%60);
 //BA.debugLineNum = 153;BA.debugLine="Return NumberFormat(mins, 1, 0) & \":\" & NumberFor";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_mins,(int) (1),(int) (0))+":"+anywheresoftware.b4a.keywords.Common.NumberFormat(_secsrest,(int) (2),(int) (0));
 //BA.debugLineNum = 154;BA.debugLine="End Sub";
return "";
}
public static int  _getremainingseconds(anywheresoftware.b4a.BA _ba) throws Exception{
int _timeoutseconds = 0;
long _elapsed = 0L;
int _remaining = 0;
 //BA.debugLineNum = 137;BA.debugLine="Public Sub GetRemainingSeconds As Int";
 //BA.debugLineNum = 138;BA.debugLine="If IsSessionActive = False Then Return 0";
if (_issessionactive(_ba)==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return (int) (0);};
 //BA.debugLineNum = 140;BA.debugLine="Dim timeoutSeconds As Int = ModSecurity.GetSessio";
_timeoutseconds = mostCurrent._modsecurity._getsessiontimeout /*int*/ (_ba);
 //BA.debugLineNum = 141;BA.debugLine="Dim elapsed As Long = (DateTime.Now - LastActivit";
_elapsed = (long) ((anywheresoftware.b4a.keywords.Common.DateTime.getNow()-_lastactivitytime)/(double)1000);
 //BA.debugLineNum = 142;BA.debugLine="Dim remaining As Int = timeoutSeconds - elapsed";
_remaining = (int) (_timeoutseconds-_elapsed);
 //BA.debugLineNum = 144;BA.debugLine="If remaining < 0 Then Return 0";
if (_remaining<0) { 
if (true) return (int) (0);};
 //BA.debugLineNum = 145;BA.debugLine="Return remaining";
if (true) return _remaining;
 //BA.debugLineNum = 146;BA.debugLine="End Sub";
return 0;
}
public static String  _getsessioncategory(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 174;BA.debugLine="Public Sub GetSessionCategory As String";
 //BA.debugLineNum = 175;BA.debugLine="If IsSessionActive = False Then Return \"\"";
if (_issessionactive(_ba)==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 176;BA.debugLine="Return SessionCategory";
if (true) return _sessioncategory;
 //BA.debugLineNum = 177;BA.debugLine="End Sub";
return "";
}
public static String  _getsessioncategoryname(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 180;BA.debugLine="Public Sub GetSessionCategoryName As String";
 //BA.debugLineNum = 181;BA.debugLine="If IsSessionActive = False Then Return \"\"";
if (_issessionactive(_ba)==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 182;BA.debugLine="If SessionCategory = \"\" Then Return \"\"";
if ((_sessioncategory).equals("")) { 
if (true) return "";};
 //BA.debugLineNum = 184;BA.debugLine="Select SessionCategory";
switch (BA.switchObjectToInt(_sessioncategory,"passwords","cards","documents","notes","wifi")) {
case 0: {
 //BA.debugLineNum = 185;BA.debugLine="Case \"passwords\": Return ModLang.T(\"passwords\")";
if (true) return mostCurrent._modlang._t /*String*/ (_ba,"passwords");
 break; }
case 1: {
 //BA.debugLineNum = 186;BA.debugLine="Case \"cards\": Return ModLang.T(\"cards\")";
if (true) return mostCurrent._modlang._t /*String*/ (_ba,"cards");
 break; }
case 2: {
 //BA.debugLineNum = 187;BA.debugLine="Case \"documents\": Return ModLang.T(\"documents\")";
if (true) return mostCurrent._modlang._t /*String*/ (_ba,"documents");
 break; }
case 3: {
 //BA.debugLineNum = 188;BA.debugLine="Case \"notes\": Return ModLang.T(\"notes\")";
if (true) return mostCurrent._modlang._t /*String*/ (_ba,"notes");
 break; }
case 4: {
 //BA.debugLineNum = 189;BA.debugLine="Case \"wifi\": Return ModLang.T(\"wifi\")";
if (true) return mostCurrent._modlang._t /*String*/ (_ba,"wifi");
 break; }
default: {
 //BA.debugLineNum = 190;BA.debugLine="Case Else: Return SessionCategory";
if (true) return _sessioncategory;
 break; }
}
;
 //BA.debugLineNum = 192;BA.debugLine="End Sub";
return "";
}
public static int  _getsessionduration(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 157;BA.debugLine="Public Sub GetSessionDuration As Int";
 //BA.debugLineNum = 158;BA.debugLine="If IsUnlocked = False Then Return 0";
if (_isunlocked==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return (int) (0);};
 //BA.debugLineNum = 159;BA.debugLine="Return (DateTime.Now - SessionStartTime) / 1000";
if (true) return (int) ((anywheresoftware.b4a.keywords.Common.DateTime.getNow()-_sessionstarttime)/(double)1000);
 //BA.debugLineNum = 160;BA.debugLine="End Sub";
return 0;
}
public static boolean  _islocked(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 169;BA.debugLine="Public Sub IsLocked As Boolean";
 //BA.debugLineNum = 170;BA.debugLine="Return Not(IsSessionActive)";
if (true) return anywheresoftware.b4a.keywords.Common.Not(_issessionactive(_ba));
 //BA.debugLineNum = 171;BA.debugLine="End Sub";
return false;
}
public static boolean  _issessionactive(anywheresoftware.b4a.BA _ba) throws Exception{
int _timeoutseconds = 0;
long _elapsed = 0L;
 //BA.debugLineNum = 75;BA.debugLine="Public Sub IsSessionActive As Boolean";
 //BA.debugLineNum = 76;BA.debugLine="If IsUnlocked = False Then Return False";
if (_isunlocked==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 77;BA.debugLine="If PhraseObfuscated = \"\" Then Return False";
if ((_phraseobfuscated).equals("")) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 80;BA.debugLine="Dim timeoutSeconds As Int = ModSecurity.GetSessio";
_timeoutseconds = mostCurrent._modsecurity._getsessiontimeout /*int*/ (_ba);
 //BA.debugLineNum = 81;BA.debugLine="Dim elapsed As Long = (DateTime.Now - LastActivit";
_elapsed = (long) ((anywheresoftware.b4a.keywords.Common.DateTime.getNow()-_lastactivitytime)/(double)1000);
 //BA.debugLineNum = 83;BA.debugLine="If elapsed > timeoutSeconds Then";
if (_elapsed>_timeoutseconds) { 
 //BA.debugLineNum = 84;BA.debugLine="Log(\"ModSession: Timeout (\" & elapsed & \"s > \" &";
anywheresoftware.b4a.keywords.Common.LogImpl("626017801","ModSession: Timeout ("+BA.NumberToString(_elapsed)+"s > "+BA.NumberToString(_timeoutseconds)+"s)",0);
 //BA.debugLineNum = 85;BA.debugLine="EndSession";
_endsession(_ba);
 //BA.debugLineNum = 86;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 89;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 90;BA.debugLine="End Sub";
return false;
}
public static boolean  _issessionvalidforcategory(anywheresoftware.b4a.BA _ba,String _category) throws Exception{
 //BA.debugLineNum = 197;BA.debugLine="Public Sub IsSessionValidForCategory(category As S";
 //BA.debugLineNum = 198;BA.debugLine="If IsSessionActive = False Then Return False";
if (_issessionactive(_ba)==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 201;BA.debugLine="If ModSecurity.GetUseSinglePassphrase Then Return";
if (mostCurrent._modsecurity._getusesinglepassphrase /*boolean*/ (_ba)) { 
if (true) return anywheresoftware.b4a.keywords.Common.True;};
 //BA.debugLineNum = 204;BA.debugLine="Return SessionCategory = category Or SessionCateg";
if (true) return (_sessioncategory).equals(_category) || (_sessioncategory).equals("");
 //BA.debugLineNum = 205;BA.debugLine="End Sub";
return false;
}
public static String  _lock(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 128;BA.debugLine="Public Sub Lock";
 //BA.debugLineNum = 129;BA.debugLine="EndSession";
_endsession(_ba);
 //BA.debugLineNum = 130;BA.debugLine="End Sub";
return "";
}
public static boolean  _needspassphraseforcategory(anywheresoftware.b4a.BA _ba,String _category) throws Exception{
 //BA.debugLineNum = 209;BA.debugLine="Public Sub NeedsPassphraseForCategory(category As";
 //BA.debugLineNum = 211;BA.debugLine="If IsSessionActive = False Then Return True";
if (_issessionactive(_ba)==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return anywheresoftware.b4a.keywords.Common.True;};
 //BA.debugLineNum = 214;BA.debugLine="If ModSecurity.GetUseSinglePassphrase Then Return";
if (mostCurrent._modsecurity._getusesinglepassphrase /*boolean*/ (_ba)) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 217;BA.debugLine="If SessionCategory = category Then Return False";
if ((_sessioncategory).equals(_category)) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 220;BA.debugLine="EndSession";
_endsession(_ba);
 //BA.debugLineNum = 221;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 222;BA.debugLine="End Sub";
return false;
}
public static String  _obfuscate(anywheresoftware.b4a.BA _ba,String _text,String _salt) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _result = null;
int _i = 0;
int _t = 0;
int _s = 0;
int _x = 0;
 //BA.debugLineNum = 61;BA.debugLine="Private Sub Obfuscate(text As String, salt As Stri";
 //BA.debugLineNum = 62;BA.debugLine="If text = \"\" Or salt = \"\" Then Return \"\"";
if ((_text).equals("") || (_salt).equals("")) { 
if (true) return "";};
 //BA.debugLineNum = 63;BA.debugLine="Dim result As StringBuilder";
_result = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 64;BA.debugLine="result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 65;BA.debugLine="For i = 0 To text.Length - 1";
{
final int step4 = 1;
final int limit4 = (int) (_text.length()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 66;BA.debugLine="Dim t As Int = Asc(text.CharAt(i))";
_t = anywheresoftware.b4a.keywords.Common.Asc(_text.charAt(_i));
 //BA.debugLineNum = 67;BA.debugLine="Dim s As Int = Asc(salt.CharAt(i Mod salt.Length";
_s = anywheresoftware.b4a.keywords.Common.Asc(_salt.charAt((int) (_i%_salt.length())));
 //BA.debugLineNum = 68;BA.debugLine="Dim x As Int = Bit.Xor(t, s)";
_x = anywheresoftware.b4a.keywords.Common.Bit.Xor(_t,_s);
 //BA.debugLineNum = 69;BA.debugLine="result.Append(Chr(x))";
_result.Append(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(_x)));
 }
};
 //BA.debugLineNum = 71;BA.debugLine="Return result.ToString";
if (true) return _result.ToString();
 //BA.debugLineNum = 72;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 5;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Private PhraseObfuscated As String";
_phraseobfuscated = "";
 //BA.debugLineNum = 9;BA.debugLine="Private SessionSalt As String";
_sessionsalt = "";
 //BA.debugLineNum = 12;BA.debugLine="Private NormalizedPhraseCache As String";
_normalizedphrasecache = "";
 //BA.debugLineNum = 15;BA.debugLine="Private SessionStartTime As Long";
_sessionstarttime = 0L;
 //BA.debugLineNum = 16;BA.debugLine="Private LastActivityTime As Long";
_lastactivitytime = 0L;
 //BA.debugLineNum = 19;BA.debugLine="Private IsUnlocked As Boolean = False";
_isunlocked = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 23;BA.debugLine="Private SessionCategory As String = \"\"";
_sessioncategory = "";
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return "";
}
public static String  _startsession(anywheresoftware.b4a.BA _ba,String _phrase) throws Exception{
 //BA.debugLineNum = 32;BA.debugLine="Public Sub StartSession(phrase As String)";
 //BA.debugLineNum = 33;BA.debugLine="StartSessionWithCategory(phrase, \"\")";
_startsessionwithcategory(_ba,_phrase,"");
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return "";
}
public static String  _startsessionwithcategory(anywheresoftware.b4a.BA _ba,String _phrase,String _category) throws Exception{
 //BA.debugLineNum = 38;BA.debugLine="Public Sub StartSessionWithCategory(phrase As Stri";
 //BA.debugLineNum = 40;BA.debugLine="SessionSalt = ModSecurity.GenerateRandomSalt";
_sessionsalt = mostCurrent._modsecurity._generaterandomsalt /*String*/ (_ba);
 //BA.debugLineNum = 43;BA.debugLine="PhraseObfuscated = Obfuscate(phrase, SessionSalt)";
_phraseobfuscated = _obfuscate(_ba,_phrase,_sessionsalt);
 //BA.debugLineNum = 46;BA.debugLine="NormalizedPhraseCache = ModSecurity.NormalizePass";
_normalizedphrasecache = mostCurrent._modsecurity._normalizepassphrase /*String*/ (_ba,_phrase);
 //BA.debugLineNum = 48;BA.debugLine="SessionStartTime = DateTime.Now";
_sessionstarttime = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 //BA.debugLineNum = 49;BA.debugLine="LastActivityTime = DateTime.Now";
_lastactivitytime = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 //BA.debugLineNum = 50;BA.debugLine="IsUnlocked = True";
_isunlocked = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 51;BA.debugLine="SessionCategory = category";
_sessioncategory = _category;
 //BA.debugLineNum = 53;BA.debugLine="If category <> \"\" Then";
if ((_category).equals("") == false) { 
 //BA.debugLineNum = 54;BA.debugLine="Log(\"ModSession: Sessao iniciada para categoria:";
anywheresoftware.b4a.keywords.Common.LogImpl("625886736","ModSession: Sessao iniciada para categoria: "+_category,0);
 }else {
 //BA.debugLineNum = 56;BA.debugLine="Log(\"ModSession: Sessao iniciada (global)\")";
anywheresoftware.b4a.keywords.Common.LogImpl("625886738","ModSession: Sessao iniciada (global)",0);
 };
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public static String  _touch(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 109;BA.debugLine="Public Sub Touch";
 //BA.debugLineNum = 110;BA.debugLine="If IsUnlocked Then";
if (_isunlocked) { 
 //BA.debugLineNum = 111;BA.debugLine="LastActivityTime = DateTime.Now";
_lastactivitytime = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 };
 //BA.debugLineNum = 113;BA.debugLine="End Sub";
return "";
}
public static boolean  _validatepassphrase(anywheresoftware.b4a.BA _ba,String _phrase,String _testencrypted,String _testexpected) throws Exception{
String _decrypted = "";
 //BA.debugLineNum = 243;BA.debugLine="Public Sub ValidatePassphrase(phrase As String, te";
 //BA.debugLineNum = 244;BA.debugLine="If testEncrypted = \"\" Or testExpected = \"\" Then R";
if ((_testencrypted).equals("") || (_testexpected).equals("")) { 
if (true) return anywheresoftware.b4a.keywords.Common.True;};
 //BA.debugLineNum = 246;BA.debugLine="Dim decrypted As String = ModSecurity.Decrypt(phr";
_decrypted = mostCurrent._modsecurity._decrypt /*String*/ (_ba,_phrase,_testencrypted);
 //BA.debugLineNum = 247;BA.debugLine="Return decrypted = testExpected";
if (true) return (_decrypted).equals(_testexpected);
 //BA.debugLineNum = 248;BA.debugLine="End Sub";
return false;
}
}
