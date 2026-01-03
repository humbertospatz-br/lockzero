package com.lockzero;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class modsecurity {
private static modsecurity mostCurrent = new modsecurity();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public static String _settings_file = "";
public static String _pin_file = "";
public static String _attempts_file = "";
public static int _pbkdf2_iterations = 0;
public static int _pbkdf2_key_length = 0;
public b4a.example.dateutils _dateutils = null;
public com.lockzero.main _main = null;
public com.lockzero.starter _starter = null;
public com.lockzero.modbackup _modbackup = null;
public com.lockzero.modlang _modlang = null;
public com.lockzero.modpasswords _modpasswords = null;
public com.lockzero.modnotes _modnotes = null;
public com.lockzero.modsession _modsession = null;
public com.lockzero.modtheme _modtheme = null;
public com.lockzero.modtransition _modtransition = null;
public com.lockzero.b4xpages _b4xpages = null;
public com.lockzero.b4xcollections _b4xcollections = null;
public com.lockzero.xuiviewsutils _xuiviewsutils = null;
public static String  _bytestohex(anywheresoftware.b4a.BA _ba,byte[] _bytes) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
byte _b = (byte)0;
String _hex = "";
 //BA.debugLineNum = 982;BA.debugLine="Private Sub BytesToHex(bytes() As Byte) As String";
 //BA.debugLineNum = 983;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 984;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 985;BA.debugLine="For Each b As Byte In bytes";
{
final byte[] group3 = _bytes;
final int groupLen3 = group3.length
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_b = group3[index3];
 //BA.debugLineNum = 986;BA.debugLine="Dim hex As String = Bit.ToHexString(Bit.And(b, 0";
_hex = anywheresoftware.b4a.keywords.Common.Bit.ToHexString(anywheresoftware.b4a.keywords.Common.Bit.And((int) (_b),((int)0xff)));
 //BA.debugLineNum = 987;BA.debugLine="If hex.Length = 1 Then sb.Append(\"0\")";
if (_hex.length()==1) { 
_sb.Append("0");};
 //BA.debugLineNum = 988;BA.debugLine="sb.Append(hex.ToLowerCase)";
_sb.Append(_hex.toLowerCase());
 }
};
 //BA.debugLineNum = 990;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
 //BA.debugLineNum = 991;BA.debugLine="End Sub";
return "";
}
public static int  _calculatedelay(anywheresoftware.b4a.BA _ba,int _count) throws Exception{
int _extra = 0;
 //BA.debugLineNum = 568;BA.debugLine="Private Sub CalculateDelay(count As Int) As Int";
 //BA.debugLineNum = 569;BA.debugLine="If count < 5 Then Return 0  '1-4 tentativas: sem";
if (_count<5) { 
if (true) return (int) (0);};
 //BA.debugLineNum = 570;BA.debugLine="If count = 5 Then Return 60000  '5 tentativas: 1";
if (_count==5) { 
if (true) return (int) (60000);};
 //BA.debugLineNum = 571;BA.debugLine="If count <= 8 Then Return 60000  '6-8 tentativas:";
if (_count<=8) { 
if (true) return (int) (60000);};
 //BA.debugLineNum = 574;BA.debugLine="Dim extra As Int = (count - 8) / 2";
_extra = (int) ((_count-8)/(double)2);
 //BA.debugLineNum = 575;BA.debugLine="Return 300000 + (extra * 300000)  '5 min + extras";
if (true) return (int) (300000+(_extra*300000));
 //BA.debugLineNum = 576;BA.debugLine="End Sub";
return 0;
}
public static byte[]  _calculatehmac(anywheresoftware.b4a.BA _ba,byte[] _keybytes,byte[] _data) throws Exception{
anywheresoftware.b4j.object.JavaObject _keyspec = null;
anywheresoftware.b4j.object.JavaObject _mac = null;
byte[] _result = null;
 //BA.debugLineNum = 479;BA.debugLine="Private Sub CalculateHMAC(keyBytes() As Byte, data";
 //BA.debugLineNum = 481;BA.debugLine="Dim keySpec As JavaObject";
_keyspec = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 482;BA.debugLine="keySpec.InitializeNewInstance(\"javax.crypto.spec.";
_keyspec.InitializeNewInstance("javax.crypto.spec.SecretKeySpec",new Object[]{(Object)(_keybytes),(Object)("HmacSHA256")});
 //BA.debugLineNum = 485;BA.debugLine="Dim mac As JavaObject";
_mac = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 486;BA.debugLine="mac = mac.InitializeStatic(\"javax.crypto.Mac\").Ru";
_mac = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_mac.InitializeStatic("javax.crypto.Mac").RunMethod("getInstance",new Object[]{(Object)("HmacSHA256")})));
 //BA.debugLineNum = 489;BA.debugLine="mac.RunMethod(\"init\", Array(keySpec))";
_mac.RunMethod("init",new Object[]{(Object)(_keyspec.getObject())});
 //BA.debugLineNum = 490;BA.debugLine="Dim result() As Byte = mac.RunMethod(\"doFinal\", A";
_result = (byte[])(_mac.RunMethod("doFinal",new Object[]{(Object)(_data)}));
 //BA.debugLineNum = 492;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 493;BA.debugLine="End Sub";
return null;
}
public static int  _calculatepasswordstrength(anywheresoftware.b4a.BA _ba,String _password) throws Exception{
boolean _haslower = false;
boolean _hasupper = false;
boolean _hasdigit = false;
boolean _hasspecial = false;
int _i = 0;
int _code = 0;
int _typecount = 0;
int _length = 0;
 //BA.debugLineNum = 1057;BA.debugLine="Public Sub CalculatePasswordStrength(password As S";
 //BA.debugLineNum = 1058;BA.debugLine="If password.Length = 0 Then Return 0";
if (_password.length()==0) { 
if (true) return (int) (0);};
 //BA.debugLineNum = 1061;BA.debugLine="Dim hasLower As Boolean = False";
_haslower = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1062;BA.debugLine="Dim hasUpper As Boolean = False";
_hasupper = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1063;BA.debugLine="Dim hasDigit As Boolean = False";
_hasdigit = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1064;BA.debugLine="Dim hasSpecial As Boolean = False";
_hasspecial = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1066;BA.debugLine="For i = 0 To password.Length - 1";
{
final int step6 = 1;
final int limit6 = (int) (_password.length()-1);
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
 //BA.debugLineNum = 1067;BA.debugLine="Dim code As Int = Asc(password.CharAt(i))";
_code = anywheresoftware.b4a.keywords.Common.Asc(_password.charAt(_i));
 //BA.debugLineNum = 1069;BA.debugLine="If code >= 97 And code <= 122 Then       'a-z";
if (_code>=97 && _code<=122) { 
 //BA.debugLineNum = 1070;BA.debugLine="hasLower = True";
_haslower = anywheresoftware.b4a.keywords.Common.True;
 }else if(_code>=65 && _code<=90) { 
 //BA.debugLineNum = 1072;BA.debugLine="hasUpper = True";
_hasupper = anywheresoftware.b4a.keywords.Common.True;
 }else if(_code>=48 && _code<=57) { 
 //BA.debugLineNum = 1074;BA.debugLine="hasDigit = True";
_hasdigit = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 1076;BA.debugLine="hasSpecial = True                     'Qualquer";
_hasspecial = anywheresoftware.b4a.keywords.Common.True;
 };
 }
};
 //BA.debugLineNum = 1081;BA.debugLine="Dim typeCount As Int = 0";
_typecount = (int) (0);
 //BA.debugLineNum = 1082;BA.debugLine="If hasLower Then typeCount = typeCount + 1";
if (_haslower) { 
_typecount = (int) (_typecount+1);};
 //BA.debugLineNum = 1083;BA.debugLine="If hasUpper Then typeCount = typeCount + 1";
if (_hasupper) { 
_typecount = (int) (_typecount+1);};
 //BA.debugLineNum = 1084;BA.debugLine="If hasDigit Then typeCount = typeCount + 1";
if (_hasdigit) { 
_typecount = (int) (_typecount+1);};
 //BA.debugLineNum = 1085;BA.debugLine="If hasSpecial Then typeCount = typeCount + 1";
if (_hasspecial) { 
_typecount = (int) (_typecount+1);};
 //BA.debugLineNum = 1088;BA.debugLine="Dim length As Int = password.Length";
_length = _password.length();
 //BA.debugLineNum = 1091;BA.debugLine="If (length >= 16 And typeCount >= 4) Or (length >";
if ((_length>=16 && _typecount>=4) || (_length>=20 && _typecount>=3)) { 
 //BA.debugLineNum = 1092;BA.debugLine="Return 3  'Muito Forte";
if (true) return (int) (3);
 };
 //BA.debugLineNum = 1096;BA.debugLine="If (length >= 12 And typeCount >= 3) Or (length >";
if ((_length>=12 && _typecount>=3) || (_length>=16 && _typecount>=2)) { 
 //BA.debugLineNum = 1097;BA.debugLine="Return 2  'Forte";
if (true) return (int) (2);
 };
 //BA.debugLineNum = 1101;BA.debugLine="If (length >= 8 And typeCount >= 2) Or length >=";
if ((_length>=8 && _typecount>=2) || _length>=12) { 
 //BA.debugLineNum = 1102;BA.debugLine="Return 1  'Media";
if (true) return (int) (1);
 };
 //BA.debugLineNum = 1106;BA.debugLine="Return 0  'Fraca";
if (true) return (int) (0);
 //BA.debugLineNum = 1107;BA.debugLine="End Sub";
return 0;
}
public static String  _clearclipboard(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4j.object.JavaObject _cm = null;
anywheresoftware.b4j.object.JavaObject _clipdata = null;
 //BA.debugLineNum = 826;BA.debugLine="Public Sub ClearClipboard";
 //BA.debugLineNum = 827;BA.debugLine="Try";
try { //BA.debugLineNum = 828;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 829;BA.debugLine="jo = jo.InitializeContext";
_jo = _jo.InitializeContext((_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 830;BA.debugLine="Dim cm As JavaObject = jo.RunMethod(\"getSystemSe";
_cm = new anywheresoftware.b4j.object.JavaObject();
_cm = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_jo.RunMethod("getSystemService",new Object[]{(Object)("clipboard")})));
 //BA.debugLineNum = 831;BA.debugLine="Dim clipData As JavaObject";
_clipdata = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 832;BA.debugLine="clipData.InitializeNewInstance(\"android.content.";
_clipdata.InitializeNewInstance("android.content.ClipData",new Object[]{(Object)(""),(Object)(new String[]{"text/plain"}),(Object)(_clipdata.InitializeNewInstance("android.content.ClipData.Item",new Object[]{(Object)("")}).getObject())});
 //BA.debugLineNum = 835;BA.debugLine="cm.RunMethod(\"setPrimaryClip\", Array(clipData))";
_cm.RunMethod("setPrimaryClip",new Object[]{(Object)(_clipdata.getObject())});
 } 
       catch (Exception e9) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e9); //BA.debugLineNum = 837;BA.debugLine="Log(\"ClearClipboard error: \" & LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("612713995","ClearClipboard error: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 839;BA.debugLine="End Sub";
return "";
}
public static String  _clearsecurefield(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.EditTextWrapper _edt) throws Exception{
 //BA.debugLineNum = 842;BA.debugLine="Public Sub ClearSecureField(edt As EditText)";
 //BA.debugLineNum = 843;BA.debugLine="edt.Text = \"\"";
_edt.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 845;BA.debugLine="ClearClipboard";
_clearclipboard(_ba);
 //BA.debugLineNum = 846;BA.debugLine="End Sub";
return "";
}
public static String  _clearstring(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 1043;BA.debugLine="Public Sub ClearString As String";
 //BA.debugLineNum = 1044;BA.debugLine="Return \"\"";
if (true) return "";
 //BA.debugLineNum = 1045;BA.debugLine="End Sub";
return "";
}
public static byte[]  _concatbytes(anywheresoftware.b4a.BA _ba,byte[] _a,byte[] _b) throws Exception{
byte[] _result = null;
int _i = 0;
 //BA.debugLineNum = 496;BA.debugLine="Private Sub ConcatBytes(a() As Byte, b() As Byte)";
 //BA.debugLineNum = 497;BA.debugLine="Dim result(a.Length + b.Length) As Byte";
_result = new byte[(int) (_a.length+_b.length)];
;
 //BA.debugLineNum = 499;BA.debugLine="For i = 0 To a.Length - 1";
{
final int step2 = 1;
final int limit2 = (int) (_a.length-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 500;BA.debugLine="result(i) = a(i)";
_result[_i] = _a[_i];
 }
};
 //BA.debugLineNum = 503;BA.debugLine="For i = 0 To b.Length - 1";
{
final int step5 = 1;
final int limit5 = (int) (_b.length-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 504;BA.debugLine="result(a.Length + i) = b(i)";
_result[(int) (_a.length+_i)] = _b[_i];
 }
};
 //BA.debugLineNum = 507;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 508;BA.debugLine="End Sub";
return null;
}
public static String  _decrypt(anywheresoftware.b4a.BA _ba,String _passphrase,String _enctext) throws Exception{
String _normalizedphrase = "";
 //BA.debugLineNum = 203;BA.debugLine="Public Sub Decrypt(passPhrase As String, encText A";
 //BA.debugLineNum = 204;BA.debugLine="If passPhrase.Length < 1 Or encText.Length < 1 Th";
if (_passphrase.length()<1 || _enctext.length()<1) { 
if (true) return "";};
 //BA.debugLineNum = 207;BA.debugLine="Dim normalizedPhrase As String = NormalizePassphr";
_normalizedphrase = _normalizepassphrase(_ba,_passphrase);
 //BA.debugLineNum = 208;BA.debugLine="Return DecryptWithNormalized(normalizedPhrase, en";
if (true) return _decryptwithnormalized(_ba,_normalizedphrase,_enctext);
 //BA.debugLineNum = 209;BA.debugLine="End Sub";
return "";
}
public static String  _decryptwithnormalized(anywheresoftware.b4a.BA _ba,String _normalizedphrase,String _enctext) throws Exception{
byte[] _keybytes = null;
byte[] _ivbytes = null;
byte[] _encrypted = null;
byte[] _decrypted = null;
String _result = "";
String _encdata = "";
anywheresoftware.b4a.agraham.encryption.CipherWrapper.MessageDigestWrapper _md = null;
anywheresoftware.b4a.objects.StringUtils _su = null;
anywheresoftware.b4a.agraham.encryption.CipherWrapper _c = null;
anywheresoftware.b4a.agraham.encryption.CipherWrapper.KeyGeneratorWrapper _kg = null;
 //BA.debugLineNum = 213;BA.debugLine="Public Sub DecryptWithNormalized(normalizedPhrase";
 //BA.debugLineNum = 214;BA.debugLine="If normalizedPhrase.Length < 10 Or encText.Length";
if (_normalizedphrase.length()<10 || _enctext.length()<1) { 
if (true) return "";};
 //BA.debugLineNum = 216;BA.debugLine="Dim keyBytes() As Byte";
_keybytes = new byte[(int) (0)];
;
 //BA.debugLineNum = 217;BA.debugLine="Dim ivBytes() As Byte";
_ivbytes = new byte[(int) (0)];
;
 //BA.debugLineNum = 218;BA.debugLine="Dim encrypted() As Byte";
_encrypted = new byte[(int) (0)];
;
 //BA.debugLineNum = 219;BA.debugLine="Dim decrypted() As Byte";
_decrypted = new byte[(int) (0)];
;
 //BA.debugLineNum = 220;BA.debugLine="Dim result As String = \"\"";
_result = "";
 //BA.debugLineNum = 222;BA.debugLine="Try";
try { //BA.debugLineNum = 224;BA.debugLine="If encText.StartsWith(\"AES:\") = False Then Retur";
if (_enctext.startsWith("AES:")==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 226;BA.debugLine="Dim encData As String = encText.SubString(4)";
_encdata = _enctext.substring((int) (4));
 //BA.debugLineNum = 228;BA.debugLine="Dim md As MessageDigest";
_md = new anywheresoftware.b4a.agraham.encryption.CipherWrapper.MessageDigestWrapper();
 //BA.debugLineNum = 229;BA.debugLine="keyBytes = md.GetMessageDigest(normalizedPhrase.";
_keybytes = _md.GetMessageDigest(_normalizedphrase.getBytes("UTF8"),"SHA-256");
 //BA.debugLineNum = 230;BA.debugLine="ivBytes = md.GetMessageDigest(StrReverse(normali";
_ivbytes = _md.GetMessageDigest(_strreverse(_ba,_normalizedphrase).getBytes("UTF8"),"MD5");
 //BA.debugLineNum = 232;BA.debugLine="Dim su As StringUtils";
_su = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 233;BA.debugLine="encrypted = su.DecodeBase64(encData)";
_encrypted = _su.DecodeBase64(_encdata);
 //BA.debugLineNum = 235;BA.debugLine="Dim c As Cipher";
_c = new anywheresoftware.b4a.agraham.encryption.CipherWrapper();
 //BA.debugLineNum = 236;BA.debugLine="Dim kg As KeyGenerator";
_kg = new anywheresoftware.b4a.agraham.encryption.CipherWrapper.KeyGeneratorWrapper();
 //BA.debugLineNum = 237;BA.debugLine="kg.Initialize(\"AES\")";
_kg.Initialize("AES");
 //BA.debugLineNum = 238;BA.debugLine="kg.KeyFromBytes(keyBytes)";
_kg.KeyFromBytes(_keybytes);
 //BA.debugLineNum = 240;BA.debugLine="c.Initialize(\"AES/CBC/PKCS5Padding\")";
_c.Initialize("AES/CBC/PKCS5Padding");
 //BA.debugLineNum = 241;BA.debugLine="c.InitialisationVector = ivBytes";
_c.setInitialisationVector(_ivbytes);
 //BA.debugLineNum = 243;BA.debugLine="decrypted = c.Decrypt(encrypted, kg.Key, True)";
_decrypted = _c.Decrypt(_encrypted,(java.security.Key)(_kg.getKey()),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 244;BA.debugLine="result = BytesToString(decrypted, 0, decrypted.L";
_result = anywheresoftware.b4a.keywords.Common.BytesToString(_decrypted,(int) (0),_decrypted.length,"UTF8");
 } 
       catch (Exception e24) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e24); //BA.debugLineNum = 247;BA.debugLine="Log(\"ModSecurity.Decrypt erro: \" & LastException";
anywheresoftware.b4a.keywords.Common.LogImpl("610158114","ModSecurity.Decrypt erro: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 251;BA.debugLine="ZeroBytes(keyBytes)";
_zerobytes(_ba,_keybytes);
 //BA.debugLineNum = 252;BA.debugLine="ZeroBytes(ivBytes)";
_zerobytes(_ba,_ivbytes);
 //BA.debugLineNum = 253;BA.debugLine="ZeroBytes(encrypted)";
_zerobytes(_ba,_encrypted);
 //BA.debugLineNum = 254;BA.debugLine="ZeroBytes(decrypted)";
_zerobytes(_ba,_decrypted);
 //BA.debugLineNum = 256;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 257;BA.debugLine="End Sub";
return "";
}
public static String  _decryptwithsalt(anywheresoftware.b4a.BA _ba,String _passphrase,String _salt,String _enctext) throws Exception{
byte[] _keybytes = null;
byte[] _ivbytes = null;
byte[] _encrypted = null;
byte[] _hmacdata = null;
byte[] _expectedhmac = null;
byte[] _decrypted = null;
String _result = "";
String _afterprefix = "";
String[] _parts = null;
anywheresoftware.b4a.objects.StringUtils _su = null;
String _ivhex = "";
String _encdata = "";
String _hmachex = "";
String _expectedhmachex = "";
anywheresoftware.b4a.agraham.encryption.CipherWrapper.MessageDigestWrapper _md = null;
anywheresoftware.b4a.agraham.encryption.CipherWrapper _c = null;
anywheresoftware.b4a.agraham.encryption.CipherWrapper.KeyGeneratorWrapper _kg = null;
 //BA.debugLineNum = 385;BA.debugLine="Public Sub DecryptWithSalt(passPhrase As String, s";
 //BA.debugLineNum = 386;BA.debugLine="If passPhrase.Length < 1 Or encText.Length < 1 Or";
if (_passphrase.length()<1 || _enctext.length()<1 || _salt.length()<1) { 
if (true) return "";};
 //BA.debugLineNum = 388;BA.debugLine="Dim keyBytes() As Byte";
_keybytes = new byte[(int) (0)];
;
 //BA.debugLineNum = 389;BA.debugLine="Dim ivBytes() As Byte";
_ivbytes = new byte[(int) (0)];
;
 //BA.debugLineNum = 390;BA.debugLine="Dim encrypted() As Byte";
_encrypted = new byte[(int) (0)];
;
 //BA.debugLineNum = 391;BA.debugLine="Dim hmacData() As Byte";
_hmacdata = new byte[(int) (0)];
;
 //BA.debugLineNum = 392;BA.debugLine="Dim expectedHmac() As Byte";
_expectedhmac = new byte[(int) (0)];
;
 //BA.debugLineNum = 393;BA.debugLine="Dim decrypted() As Byte";
_decrypted = new byte[(int) (0)];
;
 //BA.debugLineNum = 394;BA.debugLine="Dim result As String = \"\"";
_result = "";
 //BA.debugLineNum = 396;BA.debugLine="Try";
try { //BA.debugLineNum = 397;BA.debugLine="If encText.StartsWith(\"AES:\") = False Then Retur";
if (_enctext.startsWith("AES:")==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 400;BA.debugLine="keyBytes = DeriveKeyPBKDF2(passPhrase, salt)";
_keybytes = _derivekeypbkdf2(_ba,_passphrase,_salt);
 //BA.debugLineNum = 401;BA.debugLine="If keyBytes = Null Then Return \"\"";
if (_keybytes== null) { 
if (true) return "";};
 //BA.debugLineNum = 404;BA.debugLine="Dim afterPrefix As String = encText.SubString(4)";
_afterprefix = _enctext.substring((int) (4));
 //BA.debugLineNum = 405;BA.debugLine="Dim parts() As String = Regex.Split(\":\", afterPr";
_parts = anywheresoftware.b4a.keywords.Common.Regex.Split(":",_afterprefix);
 //BA.debugLineNum = 407;BA.debugLine="Dim su As StringUtils";
_su = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 409;BA.debugLine="If parts.Length = 3 And parts(0).Length = 32 And";
if (_parts.length==3 && _parts[(int) (0)].length()==32 && _parts[(int) (2)].length()==64) { 
 //BA.debugLineNum = 411;BA.debugLine="Dim ivHex As String = parts(0)";
_ivhex = _parts[(int) (0)];
 //BA.debugLineNum = 412;BA.debugLine="Dim encData As String = parts(1)";
_encdata = _parts[(int) (1)];
 //BA.debugLineNum = 413;BA.debugLine="Dim hmacHex As String = parts(2)";
_hmachex = _parts[(int) (2)];
 //BA.debugLineNum = 415;BA.debugLine="ivBytes = HexToBytes(ivHex)";
_ivbytes = _hextobytes(_ba,_ivhex);
 //BA.debugLineNum = 416;BA.debugLine="encrypted = su.DecodeBase64(encData)";
_encrypted = _su.DecodeBase64(_encdata);
 //BA.debugLineNum = 419;BA.debugLine="hmacData = ConcatBytes(ivBytes, encrypted)";
_hmacdata = _concatbytes(_ba,_ivbytes,_encrypted);
 //BA.debugLineNum = 420;BA.debugLine="expectedHmac = CalculateHMAC(keyBytes, hmacData";
_expectedhmac = _calculatehmac(_ba,_keybytes,_hmacdata);
 //BA.debugLineNum = 421;BA.debugLine="Dim expectedHmacHex As String = BytesToHex(expe";
_expectedhmachex = _bytestohex(_ba,_expectedhmac);
 //BA.debugLineNum = 423;BA.debugLine="If SecureCompare(hmacHex, expectedHmacHex) = Fa";
if (_securecompare(_ba,_hmachex,_expectedhmachex)==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 424;BA.debugLine="Log(\"DecryptWithSalt: HMAC invalido - dados po";
anywheresoftware.b4a.keywords.Common.LogImpl("610420263","DecryptWithSalt: HMAC invalido - dados podem ter sido alterados!",0);
 //BA.debugLineNum = 426;BA.debugLine="ZeroBytes(keyBytes)";
_zerobytes(_ba,_keybytes);
 //BA.debugLineNum = 427;BA.debugLine="ZeroBytes(ivBytes)";
_zerobytes(_ba,_ivbytes);
 //BA.debugLineNum = 428;BA.debugLine="ZeroBytes(encrypted)";
_zerobytes(_ba,_encrypted);
 //BA.debugLineNum = 429;BA.debugLine="ZeroBytes(hmacData)";
_zerobytes(_ba,_hmacdata);
 //BA.debugLineNum = 430;BA.debugLine="ZeroBytes(expectedHmac)";
_zerobytes(_ba,_expectedhmac);
 //BA.debugLineNum = 431;BA.debugLine="Return \"\"";
if (true) return "";
 };
 }else if(_parts.length==2 && _parts[(int) (0)].length()==32) { 
 //BA.debugLineNum = 437;BA.debugLine="Dim ivHex As String = parts(0)";
_ivhex = _parts[(int) (0)];
 //BA.debugLineNum = 438;BA.debugLine="Dim encData As String = parts(1)";
_encdata = _parts[(int) (1)];
 //BA.debugLineNum = 440;BA.debugLine="ivBytes = HexToBytes(ivHex)";
_ivbytes = _hextobytes(_ba,_ivhex);
 //BA.debugLineNum = 441;BA.debugLine="encrypted = su.DecodeBase64(encData)";
_encrypted = _su.DecodeBase64(_encdata);
 }else {
 //BA.debugLineNum = 446;BA.debugLine="Dim md As MessageDigest";
_md = new anywheresoftware.b4a.agraham.encryption.CipherWrapper.MessageDigestWrapper();
 //BA.debugLineNum = 447;BA.debugLine="ivBytes = md.GetMessageDigest(salt.GetBytes(\"UT";
_ivbytes = _md.GetMessageDigest(_salt.getBytes("UTF8"),"MD5");
 //BA.debugLineNum = 448;BA.debugLine="encrypted = su.DecodeBase64(afterPrefix)";
_encrypted = _su.DecodeBase64(_afterprefix);
 };
 //BA.debugLineNum = 452;BA.debugLine="Dim c As Cipher";
_c = new anywheresoftware.b4a.agraham.encryption.CipherWrapper();
 //BA.debugLineNum = 453;BA.debugLine="Dim kg As KeyGenerator";
_kg = new anywheresoftware.b4a.agraham.encryption.CipherWrapper.KeyGeneratorWrapper();
 //BA.debugLineNum = 454;BA.debugLine="kg.Initialize(\"AES\")";
_kg.Initialize("AES");
 //BA.debugLineNum = 455;BA.debugLine="kg.KeyFromBytes(keyBytes)";
_kg.KeyFromBytes(_keybytes);
 //BA.debugLineNum = 457;BA.debugLine="c.Initialize(\"AES/CBC/PKCS5Padding\")";
_c.Initialize("AES/CBC/PKCS5Padding");
 //BA.debugLineNum = 458;BA.debugLine="c.InitialisationVector = ivBytes";
_c.setInitialisationVector(_ivbytes);
 //BA.debugLineNum = 460;BA.debugLine="decrypted = c.Decrypt(encrypted, kg.Key, True)";
_decrypted = _c.Decrypt(_encrypted,(java.security.Key)(_kg.getKey()),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 461;BA.debugLine="result = BytesToString(decrypted, 0, decrypted.L";
_result = anywheresoftware.b4a.keywords.Common.BytesToString(_decrypted,(int) (0),_decrypted.length,"UTF8");
 } 
       catch (Exception e53) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e53); //BA.debugLineNum = 464;BA.debugLine="Log(\"ModSecurity.DecryptWithSalt erro: \" & LastE";
anywheresoftware.b4a.keywords.Common.LogImpl("610420303","ModSecurity.DecryptWithSalt erro: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 468;BA.debugLine="ZeroBytes(keyBytes)";
_zerobytes(_ba,_keybytes);
 //BA.debugLineNum = 469;BA.debugLine="ZeroBytes(ivBytes)";
_zerobytes(_ba,_ivbytes);
 //BA.debugLineNum = 470;BA.debugLine="ZeroBytes(encrypted)";
_zerobytes(_ba,_encrypted);
 //BA.debugLineNum = 471;BA.debugLine="ZeroBytes(hmacData)";
_zerobytes(_ba,_hmacdata);
 //BA.debugLineNum = 472;BA.debugLine="ZeroBytes(expectedHmac)";
_zerobytes(_ba,_expectedhmac);
 //BA.debugLineNum = 473;BA.debugLine="ZeroBytes(decrypted)";
_zerobytes(_ba,_decrypted);
 //BA.debugLineNum = 475;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 476;BA.debugLine="End Sub";
return "";
}
public static byte[]  _derivekeypbkdf2(anywheresoftware.b4a.BA _ba,String _passphrase,String _salt) throws Exception{
char[] _passchars = null;
byte[] _saltbytes = null;
anywheresoftware.b4j.object.JavaObject _keyspec = null;
anywheresoftware.b4j.object.JavaObject _jopass = null;
anywheresoftware.b4j.object.JavaObject _factory = null;
anywheresoftware.b4j.object.JavaObject _secretkey = null;
byte[] _keybytes = null;
 //BA.debugLineNum = 270;BA.debugLine="Private Sub DeriveKeyPBKDF2(passPhrase As String,";
 //BA.debugLineNum = 271;BA.debugLine="Dim passChars() As Char";
_passchars = new char[(int) (0)];
;
 //BA.debugLineNum = 272;BA.debugLine="Dim saltBytes() As Byte";
_saltbytes = new byte[(int) (0)];
;
 //BA.debugLineNum = 273;BA.debugLine="Dim keySpec As JavaObject";
_keyspec = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 275;BA.debugLine="Try";
try { //BA.debugLineNum = 277;BA.debugLine="Dim joPass As JavaObject = passPhrase";
_jopass = new anywheresoftware.b4j.object.JavaObject();
_jopass = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_passphrase));
 //BA.debugLineNum = 278;BA.debugLine="passChars = joPass.RunMethod(\"toCharArray\", Null";
_passchars = (char[])(_jopass.RunMethod("toCharArray",(Object[])(anywheresoftware.b4a.keywords.Common.Null)));
 //BA.debugLineNum = 281;BA.debugLine="saltBytes = salt.GetBytes(\"UTF8\")";
_saltbytes = _salt.getBytes("UTF8");
 //BA.debugLineNum = 284;BA.debugLine="keySpec.InitializeNewInstance(\"javax.crypto.spec";
_keyspec.InitializeNewInstance("javax.crypto.spec.PBEKeySpec",new Object[]{(Object)(_passchars),(Object)(_saltbytes),(Object)(_pbkdf2_iterations),(Object)(_pbkdf2_key_length)});
 //BA.debugLineNum = 288;BA.debugLine="Dim factory As JavaObject";
_factory = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 289;BA.debugLine="factory = factory.InitializeStatic(\"javax.crypto";
_factory = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_factory.InitializeStatic("javax.crypto.SecretKeyFactory").RunMethod("getInstance",new Object[]{(Object)("PBKDF2WithHmacSHA256")})));
 //BA.debugLineNum = 293;BA.debugLine="Dim secretKey As JavaObject = factory.RunMethod(";
_secretkey = new anywheresoftware.b4j.object.JavaObject();
_secretkey = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_factory.RunMethod("generateSecret",new Object[]{(Object)(_keyspec.getObject())})));
 //BA.debugLineNum = 294;BA.debugLine="Dim keyBytes() As Byte = secretKey.RunMethod(\"ge";
_keybytes = (byte[])(_secretkey.RunMethod("getEncoded",(Object[])(anywheresoftware.b4a.keywords.Common.Null)));
 //BA.debugLineNum = 297;BA.debugLine="keySpec.RunMethod(\"clearPassword\", Null)";
_keyspec.RunMethod("clearPassword",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 298;BA.debugLine="ZeroChars(passChars)";
_zerochars(_ba,_passchars);
 //BA.debugLineNum = 299;BA.debugLine="ZeroBytes(saltBytes)";
_zerobytes(_ba,_saltbytes);
 //BA.debugLineNum = 301;BA.debugLine="Return keyBytes";
if (true) return _keybytes;
 } 
       catch (Exception e18) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e18); //BA.debugLineNum = 304;BA.debugLine="If keySpec.IsInitialized Then keySpec.RunMethod(";
if (_keyspec.IsInitialized()) { 
_keyspec.RunMethod("clearPassword",(Object[])(anywheresoftware.b4a.keywords.Common.Null));};
 //BA.debugLineNum = 305;BA.debugLine="ZeroChars(passChars)";
_zerochars(_ba,_passchars);
 //BA.debugLineNum = 306;BA.debugLine="ZeroBytes(saltBytes)";
_zerobytes(_ba,_saltbytes);
 //BA.debugLineNum = 307;BA.debugLine="Log(\"DeriveKeyPBKDF2 erro: \" & LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("610289189","DeriveKeyPBKDF2 erro: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 //BA.debugLineNum = 308;BA.debugLine="Return Null";
if (true) return (byte[])(anywheresoftware.b4a.keywords.Common.Null);
 };
 //BA.debugLineNum = 310;BA.debugLine="End Sub";
return null;
}
public static String  _encrypt(anywheresoftware.b4a.BA _ba,String _passphrase,String _plaintext) throws Exception{
String _normalizedphrase = "";
 //BA.debugLineNum = 152;BA.debugLine="Public Sub Encrypt(passPhrase As String, plainText";
 //BA.debugLineNum = 153;BA.debugLine="If passPhrase.Length < 1 Or plainText.Length < 1";
if (_passphrase.length()<1 || _plaintext.length()<1) { 
if (true) return "";};
 //BA.debugLineNum = 156;BA.debugLine="Dim normalizedPhrase As String = NormalizePassphr";
_normalizedphrase = _normalizepassphrase(_ba,_passphrase);
 //BA.debugLineNum = 157;BA.debugLine="Return EncryptWithNormalized(normalizedPhrase, pl";
if (true) return _encryptwithnormalized(_ba,_normalizedphrase,_plaintext);
 //BA.debugLineNum = 158;BA.debugLine="End Sub";
return "";
}
public static String  _encryptwithnormalized(anywheresoftware.b4a.BA _ba,String _normalizedphrase,String _plaintext) throws Exception{
byte[] _keybytes = null;
byte[] _ivbytes = null;
byte[] _databytes = null;
String _result = "";
anywheresoftware.b4a.agraham.encryption.CipherWrapper.MessageDigestWrapper _md = null;
anywheresoftware.b4a.agraham.encryption.CipherWrapper _c = null;
anywheresoftware.b4a.agraham.encryption.CipherWrapper.KeyGeneratorWrapper _kg = null;
byte[] _encrypted = null;
anywheresoftware.b4a.objects.StringUtils _su = null;
 //BA.debugLineNum = 162;BA.debugLine="Public Sub EncryptWithNormalized(normalizedPhrase";
 //BA.debugLineNum = 163;BA.debugLine="If normalizedPhrase.Length < 10 Or plainText.Leng";
if (_normalizedphrase.length()<10 || _plaintext.length()<1) { 
if (true) return "";};
 //BA.debugLineNum = 165;BA.debugLine="Dim keyBytes() As Byte";
_keybytes = new byte[(int) (0)];
;
 //BA.debugLineNum = 166;BA.debugLine="Dim ivBytes() As Byte";
_ivbytes = new byte[(int) (0)];
;
 //BA.debugLineNum = 167;BA.debugLine="Dim dataBytes() As Byte";
_databytes = new byte[(int) (0)];
;
 //BA.debugLineNum = 168;BA.debugLine="Dim result As String = \"\"";
_result = "";
 //BA.debugLineNum = 170;BA.debugLine="Try";
try { //BA.debugLineNum = 171;BA.debugLine="Dim md As MessageDigest";
_md = new anywheresoftware.b4a.agraham.encryption.CipherWrapper.MessageDigestWrapper();
 //BA.debugLineNum = 172;BA.debugLine="keyBytes = md.GetMessageDigest(normalizedPhrase.";
_keybytes = _md.GetMessageDigest(_normalizedphrase.getBytes("UTF8"),"SHA-256");
 //BA.debugLineNum = 173;BA.debugLine="ivBytes = md.GetMessageDigest(StrReverse(normali";
_ivbytes = _md.GetMessageDigest(_strreverse(_ba,_normalizedphrase).getBytes("UTF8"),"MD5");
 //BA.debugLineNum = 175;BA.debugLine="Dim c As Cipher";
_c = new anywheresoftware.b4a.agraham.encryption.CipherWrapper();
 //BA.debugLineNum = 176;BA.debugLine="Dim kg As KeyGenerator";
_kg = new anywheresoftware.b4a.agraham.encryption.CipherWrapper.KeyGeneratorWrapper();
 //BA.debugLineNum = 177;BA.debugLine="kg.Initialize(\"AES\")";
_kg.Initialize("AES");
 //BA.debugLineNum = 178;BA.debugLine="kg.KeyFromBytes(keyBytes)";
_kg.KeyFromBytes(_keybytes);
 //BA.debugLineNum = 180;BA.debugLine="c.Initialize(\"AES/CBC/PKCS5Padding\")";
_c.Initialize("AES/CBC/PKCS5Padding");
 //BA.debugLineNum = 181;BA.debugLine="c.InitialisationVector = ivBytes";
_c.setInitialisationVector(_ivbytes);
 //BA.debugLineNum = 183;BA.debugLine="dataBytes = plainText.GetBytes(\"UTF8\")";
_databytes = _plaintext.getBytes("UTF8");
 //BA.debugLineNum = 184;BA.debugLine="Dim encrypted() As Byte = c.Encrypt(dataBytes, k";
_encrypted = _c.Encrypt(_databytes,(java.security.Key)(_kg.getKey()),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 186;BA.debugLine="Dim su As StringUtils";
_su = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 187;BA.debugLine="result = \"AES:\" & su.EncodeBase64(encrypted)";
_result = "AES:"+_su.EncodeBase64(_encrypted);
 } 
       catch (Exception e21) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e21); //BA.debugLineNum = 190;BA.debugLine="Log(\"ModSecurity.Encrypt erro: \" & LastException";
anywheresoftware.b4a.keywords.Common.LogImpl("610027036","ModSecurity.Encrypt erro: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 194;BA.debugLine="ZeroBytes(keyBytes)";
_zerobytes(_ba,_keybytes);
 //BA.debugLineNum = 195;BA.debugLine="ZeroBytes(ivBytes)";
_zerobytes(_ba,_ivbytes);
 //BA.debugLineNum = 196;BA.debugLine="ZeroBytes(dataBytes)";
_zerobytes(_ba,_databytes);
 //BA.debugLineNum = 198;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 199;BA.debugLine="End Sub";
return "";
}
public static String  _encryptwithsalt(anywheresoftware.b4a.BA _ba,String _passphrase,String _salt,String _plaintext) throws Exception{
byte[] _keybytes = null;
byte[] _ivbytes = null;
byte[] _databytes = null;
byte[] _encrypted = null;
byte[] _hmacdata = null;
byte[] _hmacbytes = null;
String _result = "";
anywheresoftware.b4a.agraham.encryption.CipherWrapper _c = null;
anywheresoftware.b4a.agraham.encryption.CipherWrapper.KeyGeneratorWrapper _kg = null;
anywheresoftware.b4a.objects.StringUtils _su = null;
String _ivhex = "";
String _hmachex = "";
 //BA.debugLineNum = 324;BA.debugLine="Public Sub EncryptWithSalt(passPhrase As String, s";
 //BA.debugLineNum = 325;BA.debugLine="If passPhrase.Length < 1 Or plainText.Length < 1";
if (_passphrase.length()<1 || _plaintext.length()<1 || _salt.length()<1) { 
if (true) return "";};
 //BA.debugLineNum = 327;BA.debugLine="Dim keyBytes() As Byte";
_keybytes = new byte[(int) (0)];
;
 //BA.debugLineNum = 328;BA.debugLine="Dim ivBytes() As Byte";
_ivbytes = new byte[(int) (0)];
;
 //BA.debugLineNum = 329;BA.debugLine="Dim dataBytes() As Byte";
_databytes = new byte[(int) (0)];
;
 //BA.debugLineNum = 330;BA.debugLine="Dim encrypted() As Byte";
_encrypted = new byte[(int) (0)];
;
 //BA.debugLineNum = 331;BA.debugLine="Dim hmacData() As Byte";
_hmacdata = new byte[(int) (0)];
;
 //BA.debugLineNum = 332;BA.debugLine="Dim hmacBytes() As Byte";
_hmacbytes = new byte[(int) (0)];
;
 //BA.debugLineNum = 333;BA.debugLine="Dim result As String = \"\"";
_result = "";
 //BA.debugLineNum = 335;BA.debugLine="Try";
try { //BA.debugLineNum = 337;BA.debugLine="keyBytes = DeriveKeyPBKDF2(passPhrase, salt)";
_keybytes = _derivekeypbkdf2(_ba,_passphrase,_salt);
 //BA.debugLineNum = 338;BA.debugLine="If keyBytes = Null Then Return \"\"";
if (_keybytes== null) { 
if (true) return "";};
 //BA.debugLineNum = 341;BA.debugLine="ivBytes = GenerateRandomIV";
_ivbytes = _generaterandomiv(_ba);
 //BA.debugLineNum = 343;BA.debugLine="Dim c As Cipher";
_c = new anywheresoftware.b4a.agraham.encryption.CipherWrapper();
 //BA.debugLineNum = 344;BA.debugLine="Dim kg As KeyGenerator";
_kg = new anywheresoftware.b4a.agraham.encryption.CipherWrapper.KeyGeneratorWrapper();
 //BA.debugLineNum = 345;BA.debugLine="kg.Initialize(\"AES\")";
_kg.Initialize("AES");
 //BA.debugLineNum = 346;BA.debugLine="kg.KeyFromBytes(keyBytes)";
_kg.KeyFromBytes(_keybytes);
 //BA.debugLineNum = 348;BA.debugLine="c.Initialize(\"AES/CBC/PKCS5Padding\")";
_c.Initialize("AES/CBC/PKCS5Padding");
 //BA.debugLineNum = 349;BA.debugLine="c.InitialisationVector = ivBytes";
_c.setInitialisationVector(_ivbytes);
 //BA.debugLineNum = 351;BA.debugLine="dataBytes = plainText.GetBytes(\"UTF8\")";
_databytes = _plaintext.getBytes("UTF8");
 //BA.debugLineNum = 352;BA.debugLine="encrypted = c.Encrypt(dataBytes, kg.Key, True)";
_encrypted = _c.Encrypt(_databytes,(java.security.Key)(_kg.getKey()),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 355;BA.debugLine="hmacData = ConcatBytes(ivBytes, encrypted)";
_hmacdata = _concatbytes(_ba,_ivbytes,_encrypted);
 //BA.debugLineNum = 356;BA.debugLine="hmacBytes = CalculateHMAC(keyBytes, hmacData)";
_hmacbytes = _calculatehmac(_ba,_keybytes,_hmacdata);
 //BA.debugLineNum = 359;BA.debugLine="Dim su As StringUtils";
_su = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 360;BA.debugLine="Dim ivHex As String = BytesToHex(ivBytes)";
_ivhex = _bytestohex(_ba,_ivbytes);
 //BA.debugLineNum = 361;BA.debugLine="Dim hmacHex As String = BytesToHex(hmacBytes)";
_hmachex = _bytestohex(_ba,_hmacbytes);
 //BA.debugLineNum = 362;BA.debugLine="result = \"AES:\" & ivHex & \":\" & su.EncodeBase64(";
_result = "AES:"+_ivhex+":"+_su.EncodeBase64(_encrypted)+":"+_hmachex;
 } 
       catch (Exception e28) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e28); //BA.debugLineNum = 365;BA.debugLine="Log(\"ModSecurity.EncryptWithSalt erro: \" & LastE";
anywheresoftware.b4a.keywords.Common.LogImpl("610354729","ModSecurity.EncryptWithSalt erro: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 369;BA.debugLine="ZeroBytes(keyBytes)";
_zerobytes(_ba,_keybytes);
 //BA.debugLineNum = 370;BA.debugLine="ZeroBytes(ivBytes)";
_zerobytes(_ba,_ivbytes);
 //BA.debugLineNum = 371;BA.debugLine="ZeroBytes(dataBytes)";
_zerobytes(_ba,_databytes);
 //BA.debugLineNum = 372;BA.debugLine="ZeroBytes(hmacData)";
_zerobytes(_ba,_hmacdata);
 //BA.debugLineNum = 373;BA.debugLine="ZeroBytes(hmacBytes)";
_zerobytes(_ba,_hmacbytes);
 //BA.debugLineNum = 376;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 377;BA.debugLine="End Sub";
return "";
}
public static String  _formatdelay(anywheresoftware.b4a.BA _ba,int _delayms) throws Exception{
int _secs = 0;
int _mins = 0;
int _secsrest = 0;
 //BA.debugLineNum = 643;BA.debugLine="Public Sub FormatDelay(delayMs As Int) As String";
 //BA.debugLineNum = 644;BA.debugLine="Dim secs As Int = delayMs / 1000";
_secs = (int) (_delayms/(double)1000);
 //BA.debugLineNum = 645;BA.debugLine="Dim mins As Int = secs / 60";
_mins = (int) (_secs/(double)60);
 //BA.debugLineNum = 646;BA.debugLine="Dim secsRest As Int = secs Mod 60";
_secsrest = (int) (_secs%60);
 //BA.debugLineNum = 647;BA.debugLine="Return NumberFormat(mins, 1, 0) & \":\" & NumberFor";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_mins,(int) (1),(int) (0))+":"+anywheresoftware.b4a.keywords.Common.NumberFormat(_secsrest,(int) (2),(int) (0));
 //BA.debugLineNum = 648;BA.debugLine="End Sub";
return "";
}
public static byte[]  _generaterandomiv(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4j.object.JavaObject _sr = null;
byte[] _ivbytes = null;
 //BA.debugLineNum = 511;BA.debugLine="Private Sub GenerateRandomIV As Byte()";
 //BA.debugLineNum = 512;BA.debugLine="Dim sr As JavaObject";
_sr = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 513;BA.debugLine="sr.InitializeNewInstance(\"java.security.SecureRan";
_sr.InitializeNewInstance("java.security.SecureRandom",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 515;BA.debugLine="Dim ivBytes(16) As Byte";
_ivbytes = new byte[(int) (16)];
;
 //BA.debugLineNum = 516;BA.debugLine="sr.RunMethod(\"nextBytes\", Array(ivBytes))";
_sr.RunMethod("nextBytes",new Object[]{(Object)(_ivbytes)});
 //BA.debugLineNum = 518;BA.debugLine="Return ivBytes";
if (true) return _ivbytes;
 //BA.debugLineNum = 519;BA.debugLine="End Sub";
return null;
}
public static String  _generaterandomsalt(anywheresoftware.b4a.BA _ba) throws Exception{
String _uuid = "";
 //BA.debugLineNum = 535;BA.debugLine="Public Sub GenerateRandomSalt As String";
 //BA.debugLineNum = 536;BA.debugLine="Dim uuid As String = GenerateUUID";
_uuid = _generateuuid(_ba);
 //BA.debugLineNum = 537;BA.debugLine="Return uuid.Replace(\"-\", \"\").SubString2(0, 32)";
if (true) return _uuid.replace("-","").substring((int) (0),(int) (32));
 //BA.debugLineNum = 538;BA.debugLine="End Sub";
return "";
}
public static String  _generateuuid(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
 //BA.debugLineNum = 1036;BA.debugLine="Public Sub GenerateUUID As String";
 //BA.debugLineNum = 1037;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
 //BA.debugLineNum = 1038;BA.debugLine="r.Target = r.RunStaticMethod(\"java.util.UUID\", \"r";
_r.Target = _r.RunStaticMethod("java.util.UUID","randomUUID",(Object[])(anywheresoftware.b4a.keywords.Common.Null),(String[])(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 1039;BA.debugLine="Return r.RunMethod(\"toString\")";
if (true) return BA.ObjectToString(_r.RunMethod("toString"));
 //BA.debugLineNum = 1040;BA.debugLine="End Sub";
return "";
}
public static int  _getclipboardtimeout(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 791;BA.debugLine="Public Sub GetClipboardTimeout As Int";
 //BA.debugLineNum = 792;BA.debugLine="Return GetSetting(\"clipboardTimeout\", 30)";
if (true) return (int)(BA.ObjectToNumber(_getsetting(_ba,"clipboardTimeout",(Object)(30))));
 //BA.debugLineNum = 793;BA.debugLine="End Sub";
return 0;
}
public static int  _getfailedattempts(anywheresoftware.b4a.BA _ba,String _groupid) throws Exception{
anywheresoftware.b4a.objects.collections.Map _attempts = null;
anywheresoftware.b4a.objects.collections.Map _groupdata = null;
 //BA.debugLineNum = 613;BA.debugLine="Public Sub GetFailedAttempts(groupId As String) As";
 //BA.debugLineNum = 614;BA.debugLine="Dim attempts As Map = LoadAttempts";
_attempts = new anywheresoftware.b4a.objects.collections.Map();
_attempts = _loadattempts(_ba);
 //BA.debugLineNum = 615;BA.debugLine="If attempts.ContainsKey(groupId) = False Then Ret";
if (_attempts.ContainsKey((Object)(_groupid))==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return (int) (0);};
 //BA.debugLineNum = 617;BA.debugLine="Dim groupData As Map = attempts.Get(groupId)";
_groupdata = new anywheresoftware.b4a.objects.collections.Map();
_groupdata = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_attempts.Get((Object)(_groupid))));
 //BA.debugLineNum = 618;BA.debugLine="Return groupData.GetDefault(\"count\", 0)";
if (true) return (int)(BA.ObjectToNumber(_groupdata.GetDefault((Object)("count"),(Object)(0))));
 //BA.debugLineNum = 619;BA.debugLine="End Sub";
return 0;
}
public static String  _getlanguage(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 743;BA.debugLine="Public Sub GetLanguage As String";
 //BA.debugLineNum = 744;BA.debugLine="Return GetSetting(\"language\", \"pt\")";
if (true) return BA.ObjectToString(_getsetting(_ba,"language",(Object)("pt")));
 //BA.debugLineNum = 745;BA.debugLine="End Sub";
return "";
}
public static String  _getpassphraseerror(anywheresoftware.b4a.BA _ba,String _phrase) throws Exception{
String _cleaned = "";
String _unique = "";
 //BA.debugLineNum = 72;BA.debugLine="Public Sub GetPassphraseError(phrase As String) As";
 //BA.debugLineNum = 73;BA.debugLine="If phrase.Length < 8 Then";
if (_phrase.length()<8) { 
 //BA.debugLineNum = 74;BA.debugLine="Return ModLang.T(\"passphrase_too_short\")";
if (true) return mostCurrent._modlang._t /*String*/ (_ba,"passphrase_too_short");
 };
 //BA.debugLineNum = 77;BA.debugLine="Dim cleaned As String = RemoveAccents(phrase.Repl";
_cleaned = _removeaccents(_ba,_phrase.replace(" ","").toLowerCase());
 //BA.debugLineNum = 78;BA.debugLine="Dim unique As String = GetUniqueChars(cleaned, 10";
_unique = _getuniquechars(_ba,_cleaned,(int) (10));
 //BA.debugLineNum = 80;BA.debugLine="If unique.Length < 10 Then";
if (_unique.length()<10) { 
 //BA.debugLineNum = 81;BA.debugLine="Return ModLang.T(\"passphrase_too_short\")";
if (true) return mostCurrent._modlang._t /*String*/ (_ba,"passphrase_too_short");
 };
 //BA.debugLineNum = 84;BA.debugLine="Return \"\" 'OK";
if (true) return "";
 //BA.debugLineNum = 85;BA.debugLine="End Sub";
return "";
}
public static int  _getremainingdelay(anywheresoftware.b4a.BA _ba,String _groupid) throws Exception{
anywheresoftware.b4a.objects.collections.Map _attempts = null;
anywheresoftware.b4a.objects.collections.Map _groupdata = null;
int _count = 0;
long _lastfailed = 0L;
int _requireddelay = 0;
long _elapsed = 0L;
int _remaining = 0;
 //BA.debugLineNum = 622;BA.debugLine="Public Sub GetRemainingDelay(groupId As String) As";
 //BA.debugLineNum = 623;BA.debugLine="Dim attempts As Map = LoadAttempts";
_attempts = new anywheresoftware.b4a.objects.collections.Map();
_attempts = _loadattempts(_ba);
 //BA.debugLineNum = 624;BA.debugLine="If attempts.ContainsKey(groupId) = False Then Ret";
if (_attempts.ContainsKey((Object)(_groupid))==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return (int) (0);};
 //BA.debugLineNum = 626;BA.debugLine="Dim groupData As Map = attempts.Get(groupId)";
_groupdata = new anywheresoftware.b4a.objects.collections.Map();
_groupdata = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_attempts.Get((Object)(_groupid))));
 //BA.debugLineNum = 627;BA.debugLine="Dim count As Int = groupData.GetDefault(\"count\",";
_count = (int)(BA.ObjectToNumber(_groupdata.GetDefault((Object)("count"),(Object)(0))));
 //BA.debugLineNum = 628;BA.debugLine="Dim lastFailed As Long = groupData.GetDefault(\"la";
_lastfailed = BA.ObjectToLongNumber(_groupdata.GetDefault((Object)("lastFailed"),(Object)(0)));
 //BA.debugLineNum = 630;BA.debugLine="If count = 0 Then Return 0";
if (_count==0) { 
if (true) return (int) (0);};
 //BA.debugLineNum = 632;BA.debugLine="Dim requiredDelay As Int = CalculateDelay(count)";
_requireddelay = _calculatedelay(_ba,_count);
 //BA.debugLineNum = 633;BA.debugLine="If requiredDelay = 0 Then Return 0";
if (_requireddelay==0) { 
if (true) return (int) (0);};
 //BA.debugLineNum = 635;BA.debugLine="Dim elapsed As Long = DateTime.Now - lastFailed";
_elapsed = (long) (anywheresoftware.b4a.keywords.Common.DateTime.getNow()-_lastfailed);
 //BA.debugLineNum = 636;BA.debugLine="Dim remaining As Int = requiredDelay - elapsed";
_remaining = (int) (_requireddelay-_elapsed);
 //BA.debugLineNum = 638;BA.debugLine="If remaining < 0 Then Return 0";
if (_remaining<0) { 
if (true) return (int) (0);};
 //BA.debugLineNum = 639;BA.debugLine="Return remaining";
if (true) return _remaining;
 //BA.debugLineNum = 640;BA.debugLine="End Sub";
return 0;
}
public static int  _getsecurepassphraseinputtype(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 814;BA.debugLine="Public Sub GetSecurePassphraseInputType As Int";
 //BA.debugLineNum = 816;BA.debugLine="Return Bit.Or(Bit.Or(1, 128), 524288)";
if (true) return anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Bit.Or((int) (1),(int) (128)),(int) (524288));
 //BA.debugLineNum = 817;BA.debugLine="End Sub";
return 0;
}
public static int  _getsecurevisibleinputtype(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 820;BA.debugLine="Public Sub GetSecureVisibleInputType As Int";
 //BA.debugLineNum = 822;BA.debugLine="Return Bit.Or(1, 524288)";
if (true) return anywheresoftware.b4a.keywords.Common.Bit.Or((int) (1),(int) (524288));
 //BA.debugLineNum = 823;BA.debugLine="End Sub";
return 0;
}
public static int  _getsessiontimeout(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 777;BA.debugLine="Public Sub GetSessionTimeout As Int";
 //BA.debugLineNum = 778;BA.debugLine="Return GetSetting(\"sessionTimeout\", 120) '2 minut";
if (true) return (int)(BA.ObjectToNumber(_getsetting(_ba,"sessionTimeout",(Object)(120))));
 //BA.debugLineNum = 779;BA.debugLine="End Sub";
return 0;
}
public static Object  _getsetting(anywheresoftware.b4a.BA _ba,String _key,Object _defaultvalue) throws Exception{
anywheresoftware.b4a.objects.collections.Map _settings = null;
 //BA.debugLineNum = 712;BA.debugLine="Public Sub GetSetting(key As String, defaultValue";
 //BA.debugLineNum = 713;BA.debugLine="Dim settings As Map = LoadSettings";
_settings = new anywheresoftware.b4a.objects.collections.Map();
_settings = _loadsettings(_ba);
 //BA.debugLineNum = 714;BA.debugLine="Return settings.GetDefault(key, defaultValue)";
if (true) return _settings.GetDefault((Object)(_key),_defaultvalue);
 //BA.debugLineNum = 715;BA.debugLine="End Sub";
return null;
}
public static int  _getstrengthcolor(anywheresoftware.b4a.BA _ba,int _strength) throws Exception{
 //BA.debugLineNum = 1110;BA.debugLine="Public Sub GetStrengthColor(strength As Int) As In";
 //BA.debugLineNum = 1111;BA.debugLine="Select strength";
switch (_strength) {
case 0: {
 //BA.debugLineNum = 1112;BA.debugLine="Case 0: Return Colors.RGB(231, 76, 60)    'Verme";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (231),(int) (76),(int) (60));
 break; }
case 1: {
 //BA.debugLineNum = 1113;BA.debugLine="Case 1: Return Colors.RGB(243, 156, 18)   'Laran";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (243),(int) (156),(int) (18));
 break; }
case 2: {
 //BA.debugLineNum = 1114;BA.debugLine="Case 2: Return Colors.RGB(39, 174, 96)    'Verde";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (39),(int) (174),(int) (96));
 break; }
case 3: {
 //BA.debugLineNum = 1115;BA.debugLine="Case 3: Return Colors.RGB(46, 204, 113)   'Verde";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (46),(int) (204),(int) (113));
 break; }
default: {
 //BA.debugLineNum = 1116;BA.debugLine="Case Else: Return Colors.Gray";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.Gray;
 break; }
}
;
 //BA.debugLineNum = 1118;BA.debugLine="End Sub";
return 0;
}
public static String  _getstrengthtext(anywheresoftware.b4a.BA _ba,int _strength) throws Exception{
 //BA.debugLineNum = 1121;BA.debugLine="Public Sub GetStrengthText(strength As Int) As Str";
 //BA.debugLineNum = 1122;BA.debugLine="Select strength";
switch (_strength) {
case 0: {
 //BA.debugLineNum = 1123;BA.debugLine="Case 0: Return ModLang.T(\"weak\")";
if (true) return mostCurrent._modlang._t /*String*/ (_ba,"weak");
 break; }
case 1: {
 //BA.debugLineNum = 1124;BA.debugLine="Case 1: Return ModLang.T(\"medium\")";
if (true) return mostCurrent._modlang._t /*String*/ (_ba,"medium");
 break; }
case 2: {
 //BA.debugLineNum = 1125;BA.debugLine="Case 2: Return ModLang.T(\"strong\")";
if (true) return mostCurrent._modlang._t /*String*/ (_ba,"strong");
 break; }
case 3: {
 //BA.debugLineNum = 1126;BA.debugLine="Case 3: Return ModLang.T(\"very_strong\")";
if (true) return mostCurrent._modlang._t /*String*/ (_ba,"very_strong");
 break; }
default: {
 //BA.debugLineNum = 1127;BA.debugLine="Case Else: Return \"\"";
if (true) return "";
 break; }
}
;
 //BA.debugLineNum = 1129;BA.debugLine="End Sub";
return "";
}
public static int  _gettheme(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 763;BA.debugLine="Public Sub GetTheme As Int";
 //BA.debugLineNum = 764;BA.debugLine="Return GetSetting(\"theme\", 0)";
if (true) return (int)(BA.ObjectToNumber(_getsetting(_ba,"theme",(Object)(0))));
 //BA.debugLineNum = 765;BA.debugLine="End Sub";
return 0;
}
public static String  _getuniquechars(anywheresoftware.b4a.BA _ba,String _text,int _count) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _result = null;
String _seen = "";
int _i = 0;
String _c = "";
 //BA.debugLineNum = 128;BA.debugLine="Private Sub GetUniqueChars(text As String, count A";
 //BA.debugLineNum = 129;BA.debugLine="Dim result As StringBuilder";
_result = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 130;BA.debugLine="result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 131;BA.debugLine="Dim seen As String = \"\"";
_seen = "";
 //BA.debugLineNum = 133;BA.debugLine="For i = 0 To text.Length - 1";
{
final int step4 = 1;
final int limit4 = (int) (_text.length()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 134;BA.debugLine="If result.Length >= count Then Exit";
if (_result.getLength()>=_count) { 
if (true) break;};
 //BA.debugLineNum = 136;BA.debugLine="Dim c As String = text.CharAt(i)";
_c = BA.ObjectToString(_text.charAt(_i));
 //BA.debugLineNum = 137;BA.debugLine="If seen.Contains(c) = False Then";
if (_seen.contains(_c)==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 138;BA.debugLine="result.Append(c)";
_result.Append(_c);
 //BA.debugLineNum = 139;BA.debugLine="seen = seen & c";
_seen = _seen+_c;
 };
 }
};
 //BA.debugLineNum = 143;BA.debugLine="Return result.ToString";
if (true) return _result.ToString();
 //BA.debugLineNum = 144;BA.debugLine="End Sub";
return "";
}
public static boolean  _getusebiometric(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 731;BA.debugLine="Public Sub GetUseBiometric As Boolean";
 //BA.debugLineNum = 732;BA.debugLine="Return GetSetting(\"useBiometric\", False)";
if (true) return BA.ObjectToBoolean(_getsetting(_ba,"useBiometric",(Object)(anywheresoftware.b4a.keywords.Common.False)));
 //BA.debugLineNum = 733;BA.debugLine="End Sub";
return false;
}
public static boolean  _getusesinglepassphrase(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 858;BA.debugLine="Public Sub GetUseSinglePassphrase As Boolean";
 //BA.debugLineNum = 859;BA.debugLine="Return GetSetting(\"singlePassphrase\", True)  'Pad";
if (true) return BA.ObjectToBoolean(_getsetting(_ba,"singlePassphrase",(Object)(anywheresoftware.b4a.keywords.Common.True)));
 //BA.debugLineNum = 860;BA.debugLine="End Sub";
return false;
}
public static boolean  _haspin(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 875;BA.debugLine="Public Sub HasPIN As Boolean";
 //BA.debugLineNum = 876;BA.debugLine="Return File.Exists(File.DirInternal, PIN_FILE)";
if (true) return anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_pin_file);
 //BA.debugLineNum = 877;BA.debugLine="End Sub";
return false;
}
public static byte[]  _hextobytes(anywheresoftware.b4a.BA _ba,String _hex) throws Exception{
int _length = 0;
byte[] _bytes = null;
int _i = 0;
String _hexbyte = "";
 //BA.debugLineNum = 522;BA.debugLine="Private Sub HexToBytes(hex As String) As Byte()";
 //BA.debugLineNum = 523;BA.debugLine="Dim length As Int = hex.Length / 2";
_length = (int) (_hex.length()/(double)2);
 //BA.debugLineNum = 524;BA.debugLine="Dim bytes(length) As Byte";
_bytes = new byte[_length];
;
 //BA.debugLineNum = 526;BA.debugLine="For i = 0 To length - 1";
{
final int step3 = 1;
final int limit3 = (int) (_length-1);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 527;BA.debugLine="Dim hexByte As String = hex.SubString2(i * 2, i";
_hexbyte = _hex.substring((int) (_i*2),(int) (_i*2+2));
 //BA.debugLineNum = 528;BA.debugLine="bytes(i) = Bit.ParseInt(hexByte, 16)";
_bytes[_i] = (byte) (anywheresoftware.b4a.keywords.Common.Bit.ParseInt(_hexbyte,(int) (16)));
 }
};
 //BA.debugLineNum = 531;BA.debugLine="Return bytes";
if (true) return _bytes;
 //BA.debugLineNum = 532;BA.debugLine="End Sub";
return null;
}
public static boolean  _isencrypted(anywheresoftware.b4a.BA _ba,String _value) throws Exception{
 //BA.debugLineNum = 260;BA.debugLine="Public Sub IsEncrypted(value As String) As Boolean";
 //BA.debugLineNum = 261;BA.debugLine="Return value.StartsWith(\"AES:\")";
if (true) return _value.startsWith("AES:");
 //BA.debugLineNum = 262;BA.debugLine="End Sub";
return false;
}
public static boolean  _islanguagechosen(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 747;BA.debugLine="Public Sub IsLanguageChosen As Boolean";
 //BA.debugLineNum = 748;BA.debugLine="Return GetSetting(\"languageChosen\", False)";
if (true) return BA.ObjectToBoolean(_getsetting(_ba,"languageChosen",(Object)(anywheresoftware.b4a.keywords.Common.False)));
 //BA.debugLineNum = 749;BA.debugLine="End Sub";
return false;
}
public static boolean  _isvalidphrase(anywheresoftware.b4a.BA _ba,String _phrase) throws Exception{
 //BA.debugLineNum = 558;BA.debugLine="Public Sub IsValidPhrase(phrase As String) As Bool";
 //BA.debugLineNum = 559;BA.debugLine="Return phrase.Length >= 8";
if (true) return _phrase.length()>=8;
 //BA.debugLineNum = 560;BA.debugLine="End Sub";
return false;
}
public static boolean  _isvalidpin(anywheresoftware.b4a.BA _ba,String _pin) throws Exception{
int _i = 0;
int _code = 0;
 //BA.debugLineNum = 545;BA.debugLine="Public Sub IsValidPIN(pin As String) As Boolean";
 //BA.debugLineNum = 546;BA.debugLine="If pin.Length < 6 Then Return False";
if (_pin.length()<6) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 549;BA.debugLine="For i = 0 To pin.Length - 1";
{
final int step2 = 1;
final int limit2 = (int) (_pin.length()-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 550;BA.debugLine="Dim code As Int = Asc(pin.CharAt(i))";
_code = anywheresoftware.b4a.keywords.Common.Asc(_pin.charAt(_i));
 //BA.debugLineNum = 551;BA.debugLine="If code < 48 Or code > 57 Then Return False  '48";
if (_code<48 || _code>57) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 }
};
 //BA.debugLineNum = 554;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 555;BA.debugLine="End Sub";
return false;
}
public static anywheresoftware.b4a.objects.collections.Map  _loadattempts(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.Map _attempts = null;
String _json = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
 //BA.debugLineNum = 656;BA.debugLine="Private Sub LoadAttempts As Map";
 //BA.debugLineNum = 657;BA.debugLine="Dim attempts As Map";
_attempts = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 658;BA.debugLine="attempts.Initialize";
_attempts.Initialize();
 //BA.debugLineNum = 660;BA.debugLine="If File.Exists(File.DirInternal, ATTEMPTS_FILE) T";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_attempts_file)) { 
 //BA.debugLineNum = 661;BA.debugLine="Try";
try { //BA.debugLineNum = 662;BA.debugLine="Dim json As String = File.ReadString(File.DirIn";
_json = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_attempts_file);
 //BA.debugLineNum = 663;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 664;BA.debugLine="parser.Initialize(json)";
_parser.Initialize(_json);
 //BA.debugLineNum = 665;BA.debugLine="attempts = parser.NextObject";
_attempts = _parser.NextObject();
 } 
       catch (Exception e10) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e10); //BA.debugLineNum = 667;BA.debugLine="Log(\"ModSecurity.LoadAttempts erro: \" & LastExc";
anywheresoftware.b4a.keywords.Common.LogImpl("611403275","ModSecurity.LoadAttempts erro: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 };
 //BA.debugLineNum = 671;BA.debugLine="Return attempts";
if (true) return _attempts;
 //BA.debugLineNum = 672;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.Map  _loadsettings(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.Map _settings = null;
String _json = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
 //BA.debugLineNum = 688;BA.debugLine="Public Sub LoadSettings As Map";
 //BA.debugLineNum = 689;BA.debugLine="Dim settings As Map";
_settings = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 690;BA.debugLine="settings.Initialize";
_settings.Initialize();
 //BA.debugLineNum = 692;BA.debugLine="If File.Exists(File.DirInternal, SETTINGS_FILE) T";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settings_file)) { 
 //BA.debugLineNum = 693;BA.debugLine="Try";
try { //BA.debugLineNum = 694;BA.debugLine="Dim json As String = File.ReadString(File.DirIn";
_json = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settings_file);
 //BA.debugLineNum = 695;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 696;BA.debugLine="parser.Initialize(json)";
_parser.Initialize(_json);
 //BA.debugLineNum = 697;BA.debugLine="settings = parser.NextObject";
_settings = _parser.NextObject();
 } 
       catch (Exception e10) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e10); //BA.debugLineNum = 699;BA.debugLine="Log(\"ModSecurity.LoadSettings erro: \" & LastExc";
anywheresoftware.b4a.keywords.Common.LogImpl("611534347","ModSecurity.LoadSettings erro: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 };
 //BA.debugLineNum = 703;BA.debugLine="Return settings";
if (true) return _settings;
 //BA.debugLineNum = 704;BA.debugLine="End Sub";
return null;
}
public static String  _migratelegacypin(anywheresoftware.b4a.BA _ba,String _encoded) throws Exception{
anywheresoftware.b4a.objects.StringUtils _su = null;
byte[] _data = null;
 //BA.debugLineNum = 960;BA.debugLine="Private Sub MigrateLegacyPIN(encoded As String) As";
 //BA.debugLineNum = 961;BA.debugLine="Try";
try { //BA.debugLineNum = 962;BA.debugLine="Dim su As StringUtils";
_su = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 963;BA.debugLine="Dim data() As Byte = su.DecodeBase64(encoded)";
_data = _su.DecodeBase64(_encoded);
 //BA.debugLineNum = 964;BA.debugLine="Return BytesToString(data, 0, data.Length, \"UTF8";
if (true) return anywheresoftware.b4a.keywords.Common.BytesToString(_data,(int) (0),_data.length,"UTF8");
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6); //BA.debugLineNum = 966;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 968;BA.debugLine="End Sub";
return "";
}
public static String  _normalizepassphrase(anywheresoftware.b4a.BA _ba,String _phrase) throws Exception{
String _cleaned = "";
String _unique = "";
 //BA.debugLineNum = 51;BA.debugLine="Public Sub NormalizePassphrase(phrase As String) A";
 //BA.debugLineNum = 52;BA.debugLine="If phrase.Length = 0 Then Return \"\"";
if (_phrase.length()==0) { 
if (true) return "";};
 //BA.debugLineNum = 55;BA.debugLine="Dim cleaned As String = RemoveAccents(phrase.Repl";
_cleaned = _removeaccents(_ba,_phrase.replace(" ","").toLowerCase());
 //BA.debugLineNum = 58;BA.debugLine="Dim unique As String = GetUniqueChars(cleaned, 10";
_unique = _getuniquechars(_ba,_cleaned,(int) (10));
 //BA.debugLineNum = 60;BA.debugLine="Return unique";
if (true) return _unique;
 //BA.debugLineNum = 61;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 5;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Private Const SETTINGS_FILE As String = \"lockzero";
_settings_file = "lockzero_settings.dat";
 //BA.debugLineNum = 7;BA.debugLine="Private Const PIN_FILE As String = \"lockzero_pin.";
_pin_file = "lockzero_pin.dat";
 //BA.debugLineNum = 8;BA.debugLine="Private Const ATTEMPTS_FILE As String = \"lockzero";
_attempts_file = "lockzero_attempts.json";
 //BA.debugLineNum = 12;BA.debugLine="Private Const PBKDF2_ITERATIONS As Int = 100000";
_pbkdf2_iterations = (int) (100000);
 //BA.debugLineNum = 13;BA.debugLine="Private Const PBKDF2_KEY_LENGTH As Int = 256  'bi";
_pbkdf2_key_length = (int) (256);
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return "";
}
public static int  _registerfailedattempt(anywheresoftware.b4a.BA _ba,String _groupid) throws Exception{
anywheresoftware.b4a.objects.collections.Map _attempts = null;
anywheresoftware.b4a.objects.collections.Map _groupdata = null;
int _count = 0;
 //BA.debugLineNum = 580;BA.debugLine="Public Sub RegisterFailedAttempt(groupId As String";
 //BA.debugLineNum = 581;BA.debugLine="Dim attempts As Map = LoadAttempts";
_attempts = new anywheresoftware.b4a.objects.collections.Map();
_attempts = _loadattempts(_ba);
 //BA.debugLineNum = 583;BA.debugLine="Dim groupData As Map";
_groupdata = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 584;BA.debugLine="If attempts.ContainsKey(groupId) Then";
if (_attempts.ContainsKey((Object)(_groupid))) { 
 //BA.debugLineNum = 585;BA.debugLine="groupData = attempts.Get(groupId)";
_groupdata = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_attempts.Get((Object)(_groupid))));
 }else {
 //BA.debugLineNum = 587;BA.debugLine="groupData.Initialize";
_groupdata.Initialize();
 //BA.debugLineNum = 588;BA.debugLine="groupData.Put(\"count\", 0)";
_groupdata.Put((Object)("count"),(Object)(0));
 //BA.debugLineNum = 589;BA.debugLine="groupData.Put(\"lastFailed\", 0)";
_groupdata.Put((Object)("lastFailed"),(Object)(0));
 };
 //BA.debugLineNum = 592;BA.debugLine="Dim count As Int = groupData.Get(\"count\") + 1";
_count = (int) ((double)(BA.ObjectToNumber(_groupdata.Get((Object)("count"))))+1);
 //BA.debugLineNum = 593;BA.debugLine="groupData.Put(\"count\", count)";
_groupdata.Put((Object)("count"),(Object)(_count));
 //BA.debugLineNum = 594;BA.debugLine="groupData.Put(\"lastFailed\", DateTime.Now)";
_groupdata.Put((Object)("lastFailed"),(Object)(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
 //BA.debugLineNum = 595;BA.debugLine="attempts.Put(groupId, groupData)";
_attempts.Put((Object)(_groupid),(Object)(_groupdata.getObject()));
 //BA.debugLineNum = 597;BA.debugLine="SaveAttempts(attempts)";
_saveattempts(_ba,_attempts);
 //BA.debugLineNum = 600;BA.debugLine="Return CalculateDelay(count)";
if (true) return _calculatedelay(_ba,_count);
 //BA.debugLineNum = 601;BA.debugLine="End Sub";
return 0;
}
public static String  _removeaccents(anywheresoftware.b4a.BA _ba,String _text) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _result = null;
int _i = 0;
char _c = '\0';
int _code = 0;
 //BA.debugLineNum = 88;BA.debugLine="Private Sub RemoveAccents(text As String) As Strin";
 //BA.debugLineNum = 89;BA.debugLine="Dim result As StringBuilder";
_result = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 90;BA.debugLine="result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 92;BA.debugLine="For i = 0 To text.Length - 1";
{
final int step3 = 1;
final int limit3 = (int) (_text.length()-1);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 93;BA.debugLine="Dim c As Char = text.CharAt(i)";
_c = _text.charAt(_i);
 //BA.debugLineNum = 94;BA.debugLine="Dim code As Int = Asc(c)";
_code = anywheresoftware.b4a.keywords.Common.Asc(_c);
 //BA.debugLineNum = 97;BA.debugLine="Select code";
switch (_code) {
case 192: 
case 193: 
case 194: 
case 195: 
case 196: 
case 197: {
 //BA.debugLineNum = 99;BA.debugLine="Case 192, 193, 194, 195, 196, 197: result.Appen";
_result.Append("A");
 break; }
case 199: {
 //BA.debugLineNum = 100;BA.debugLine="Case 199: result.Append(\"C\") 'Ç";
_result.Append("C");
 break; }
case 200: 
case 201: 
case 202: 
case 203: {
 //BA.debugLineNum = 101;BA.debugLine="Case 200, 201, 202, 203: result.Append(\"E\") 'È";
_result.Append("E");
 break; }
case 204: 
case 205: 
case 206: 
case 207: {
 //BA.debugLineNum = 102;BA.debugLine="Case 204, 205, 206, 207: result.Append(\"I\") 'Ì";
_result.Append("I");
 break; }
case 209: {
 //BA.debugLineNum = 103;BA.debugLine="Case 209: result.Append(\"N\") 'Ñ";
_result.Append("N");
 break; }
case 210: 
case 211: 
case 212: 
case 213: 
case 214: {
 //BA.debugLineNum = 104;BA.debugLine="Case 210, 211, 212, 213, 214: result.Append(\"O\"";
_result.Append("O");
 break; }
case 217: 
case 218: 
case 219: 
case 220: {
 //BA.debugLineNum = 105;BA.debugLine="Case 217, 218, 219, 220: result.Append(\"U\") 'Ù";
_result.Append("U");
 break; }
case 221: {
 //BA.debugLineNum = 106;BA.debugLine="Case 221: result.Append(\"Y\") 'Ý";
_result.Append("Y");
 break; }
case 224: 
case 225: 
case 226: 
case 227: 
case 228: 
case 229: {
 //BA.debugLineNum = 108;BA.debugLine="Case 224, 225, 226, 227, 228, 229: result.Appen";
_result.Append("a");
 break; }
case 231: {
 //BA.debugLineNum = 109;BA.debugLine="Case 231: result.Append(\"c\") 'ç";
_result.Append("c");
 break; }
case 232: 
case 233: 
case 234: 
case 235: {
 //BA.debugLineNum = 110;BA.debugLine="Case 232, 233, 234, 235: result.Append(\"e\") 'è";
_result.Append("e");
 break; }
case 236: 
case 237: 
case 238: 
case 239: {
 //BA.debugLineNum = 111;BA.debugLine="Case 236, 237, 238, 239: result.Append(\"i\") 'ì";
_result.Append("i");
 break; }
case 241: {
 //BA.debugLineNum = 112;BA.debugLine="Case 241: result.Append(\"n\") 'ñ";
_result.Append("n");
 break; }
case 242: 
case 243: 
case 244: 
case 245: 
case 246: {
 //BA.debugLineNum = 113;BA.debugLine="Case 242, 243, 244, 245, 246: result.Append(\"o\"";
_result.Append("o");
 break; }
case 249: 
case 250: 
case 251: 
case 252: {
 //BA.debugLineNum = 114;BA.debugLine="Case 249, 250, 251, 252: result.Append(\"u\") 'ù";
_result.Append("u");
 break; }
case 253: 
case 255: {
 //BA.debugLineNum = 115;BA.debugLine="Case 253, 255: result.Append(\"y\") 'ý ÿ";
_result.Append("y");
 break; }
default: {
 //BA.debugLineNum = 118;BA.debugLine="If code >= 32 And code <= 126 Then";
if (_code>=32 && _code<=126) { 
 //BA.debugLineNum = 119;BA.debugLine="result.Append(c)";
_result.Append(BA.ObjectToString(_c));
 };
 break; }
}
;
 }
};
 //BA.debugLineNum = 124;BA.debugLine="Return result.ToString";
if (true) return _result.ToString();
 //BA.debugLineNum = 125;BA.debugLine="End Sub";
return "";
}
public static String  _removepin(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 994;BA.debugLine="Public Sub RemovePIN";
 //BA.debugLineNum = 995;BA.debugLine="If File.Exists(File.DirInternal, PIN_FILE) Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_pin_file)) { 
 //BA.debugLineNum = 996;BA.debugLine="File.Delete(File.DirInternal, PIN_FILE)";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_pin_file);
 //BA.debugLineNum = 997;BA.debugLine="Log(\"ModSecurity: PIN removido\")";
anywheresoftware.b4a.keywords.Common.LogImpl("613369347","ModSecurity: PIN removido",0);
 };
 //BA.debugLineNum = 999;BA.debugLine="End Sub";
return "";
}
public static String  _resetfailedattempts(anywheresoftware.b4a.BA _ba,String _groupid) throws Exception{
anywheresoftware.b4a.objects.collections.Map _attempts = null;
 //BA.debugLineNum = 604;BA.debugLine="Public Sub ResetFailedAttempts(groupId As String)";
 //BA.debugLineNum = 605;BA.debugLine="Dim attempts As Map = LoadAttempts";
_attempts = new anywheresoftware.b4a.objects.collections.Map();
_attempts = _loadattempts(_ba);
 //BA.debugLineNum = 606;BA.debugLine="If attempts.ContainsKey(groupId) Then";
if (_attempts.ContainsKey((Object)(_groupid))) { 
 //BA.debugLineNum = 607;BA.debugLine="attempts.Remove(groupId)";
_attempts.Remove((Object)(_groupid));
 //BA.debugLineNum = 608;BA.debugLine="SaveAttempts(attempts)";
_saveattempts(_ba,_attempts);
 };
 //BA.debugLineNum = 610;BA.debugLine="End Sub";
return "";
}
public static String  _saveattempts(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.Map _attempts) throws Exception{
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _gen = null;
 //BA.debugLineNum = 674;BA.debugLine="Private Sub SaveAttempts(attempts As Map)";
 //BA.debugLineNum = 675;BA.debugLine="Try";
try { //BA.debugLineNum = 676;BA.debugLine="Dim gen As JSONGenerator";
_gen = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 677;BA.debugLine="gen.Initialize(attempts)";
_gen.Initialize(_attempts);
 //BA.debugLineNum = 678;BA.debugLine="File.WriteString(File.DirInternal, ATTEMPTS_FILE";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_attempts_file,_gen.ToString());
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6); //BA.debugLineNum = 680;BA.debugLine="Log(\"ModSecurity.SaveAttempts erro: \" & LastExce";
anywheresoftware.b4a.keywords.Common.LogImpl("611468806","ModSecurity.SaveAttempts erro: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 682;BA.debugLine="End Sub";
return "";
}
public static String  _saveclipboardtimeout(anywheresoftware.b4a.BA _ba,int _seconds) throws Exception{
 //BA.debugLineNum = 785;BA.debugLine="Public Sub SaveClipboardTimeout(seconds As Int)";
 //BA.debugLineNum = 786;BA.debugLine="If seconds < 10 Then seconds = 10";
if (_seconds<10) { 
_seconds = (int) (10);};
 //BA.debugLineNum = 787;BA.debugLine="If seconds > 120 Then seconds = 120";
if (_seconds>120) { 
_seconds = (int) (120);};
 //BA.debugLineNum = 788;BA.debugLine="SetSetting(\"clipboardTimeout\", seconds)";
_setsetting(_ba,"clipboardTimeout",(Object)(_seconds));
 //BA.debugLineNum = 789;BA.debugLine="End Sub";
return "";
}
public static String  _savelanguage(anywheresoftware.b4a.BA _ba,String _langcode) throws Exception{
 //BA.debugLineNum = 739;BA.debugLine="Public Sub SaveLanguage(langCode As String)";
 //BA.debugLineNum = 740;BA.debugLine="SetSetting(\"language\", langCode)";
_setsetting(_ba,"language",(Object)(_langcode));
 //BA.debugLineNum = 741;BA.debugLine="End Sub";
return "";
}
public static String  _savepin(anywheresoftware.b4a.BA _ba,String _pin) throws Exception{
byte[] _hashbytes = null;
String _salt = "";
String _hashhex = "";
String _data = "";
 //BA.debugLineNum = 880;BA.debugLine="Public Sub SavePIN(pin As String)";
 //BA.debugLineNum = 881;BA.debugLine="If pin.Length < 4 Or pin.Length > 8 Then";
if (_pin.length()<4 || _pin.length()>8) { 
 //BA.debugLineNum = 882;BA.debugLine="Log(\"SavePIN: PIN deve ter 4-8 digitos\")";
anywheresoftware.b4a.keywords.Common.LogImpl("613041666","SavePIN: PIN deve ter 4-8 digitos",0);
 //BA.debugLineNum = 883;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 886;BA.debugLine="Dim hashBytes() As Byte";
_hashbytes = new byte[(int) (0)];
;
 //BA.debugLineNum = 888;BA.debugLine="Try";
try { //BA.debugLineNum = 890;BA.debugLine="Dim salt As String = GenerateRandomSalt";
_salt = _generaterandomsalt(_ba);
 //BA.debugLineNum = 893;BA.debugLine="hashBytes = DeriveKeyPBKDF2(pin, salt)";
_hashbytes = _derivekeypbkdf2(_ba,_pin,_salt);
 //BA.debugLineNum = 894;BA.debugLine="If hashBytes = Null Then Return";
if (_hashbytes== null) { 
if (true) return "";};
 //BA.debugLineNum = 896;BA.debugLine="Dim hashHex As String = BytesToHex(hashBytes)";
_hashhex = _bytestohex(_ba,_hashbytes);
 //BA.debugLineNum = 899;BA.debugLine="Dim data As String = salt & \":\" & hashHex";
_data = _salt+":"+_hashhex;
 //BA.debugLineNum = 900;BA.debugLine="File.WriteString(File.DirInternal, PIN_FILE, dat";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_pin_file,_data);
 //BA.debugLineNum = 901;BA.debugLine="Log(\"ModSecurity: PIN salvo com PBKDF2\")";
anywheresoftware.b4a.keywords.Common.LogImpl("613041685","ModSecurity: PIN salvo com PBKDF2",0);
 } 
       catch (Exception e15) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e15); //BA.debugLineNum = 903;BA.debugLine="Log(\"SavePIN erro: \" & LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("613041687","SavePIN erro: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 907;BA.debugLine="ZeroBytes(hashBytes)";
_zerobytes(_ba,_hashbytes);
 //BA.debugLineNum = 908;BA.debugLine="End Sub";
return "";
}
public static String  _savesessiontimeout(anywheresoftware.b4a.BA _ba,int _seconds) throws Exception{
 //BA.debugLineNum = 771;BA.debugLine="Public Sub SaveSessionTimeout(seconds As Int)";
 //BA.debugLineNum = 772;BA.debugLine="If seconds < 30 Then seconds = 30";
if (_seconds<30) { 
_seconds = (int) (30);};
 //BA.debugLineNum = 773;BA.debugLine="If seconds > 1800 Then seconds = 1800";
if (_seconds>1800) { 
_seconds = (int) (1800);};
 //BA.debugLineNum = 774;BA.debugLine="SetSetting(\"sessionTimeout\", seconds)";
_setsetting(_ba,"sessionTimeout",(Object)(_seconds));
 //BA.debugLineNum = 775;BA.debugLine="End Sub";
return "";
}
public static String  _savesettings(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.Map _settings) throws Exception{
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _gen = null;
 //BA.debugLineNum = 706;BA.debugLine="Public Sub SaveSettings(settings As Map)";
 //BA.debugLineNum = 707;BA.debugLine="Dim gen As JSONGenerator";
_gen = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 708;BA.debugLine="gen.Initialize(settings)";
_gen.Initialize(_settings);
 //BA.debugLineNum = 709;BA.debugLine="File.WriteString(File.DirInternal, SETTINGS_FILE,";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settings_file,_gen.ToString());
 //BA.debugLineNum = 710;BA.debugLine="End Sub";
return "";
}
public static String  _savetheme(anywheresoftware.b4a.BA _ba,int _themeindex) throws Exception{
 //BA.debugLineNum = 759;BA.debugLine="Public Sub SaveTheme(themeIndex As Int)";
 //BA.debugLineNum = 760;BA.debugLine="SetSetting(\"theme\", themeIndex)";
_setsetting(_ba,"theme",(Object)(_themeindex));
 //BA.debugLineNum = 761;BA.debugLine="End Sub";
return "";
}
public static boolean  _securecompare(anywheresoftware.b4a.BA _ba,String _a,String _b) throws Exception{
int _result = 0;
int _i = 0;
 //BA.debugLineNum = 971;BA.debugLine="Private Sub SecureCompare(a As String, b As String";
 //BA.debugLineNum = 972;BA.debugLine="If a.Length <> b.Length Then Return False";
if (_a.length()!=_b.length()) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 974;BA.debugLine="Dim result As Int = 0";
_result = (int) (0);
 //BA.debugLineNum = 975;BA.debugLine="For i = 0 To a.Length - 1";
{
final int step3 = 1;
final int limit3 = (int) (_a.length()-1);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 976;BA.debugLine="result = Bit.Or(result, Bit.Xor(Asc(a.CharAt(i))";
_result = anywheresoftware.b4a.keywords.Common.Bit.Or(_result,anywheresoftware.b4a.keywords.Common.Bit.Xor(anywheresoftware.b4a.keywords.Common.Asc(_a.charAt(_i)),anywheresoftware.b4a.keywords.Common.Asc(_b.charAt(_i))));
 }
};
 //BA.debugLineNum = 978;BA.debugLine="Return result = 0";
if (true) return _result==0;
 //BA.debugLineNum = 979;BA.debugLine="End Sub";
return false;
}
public static String  _setlanguagechosen(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 751;BA.debugLine="Public Sub SetLanguageChosen";
 //BA.debugLineNum = 752;BA.debugLine="SetSetting(\"languageChosen\", True)";
_setsetting(_ba,"languageChosen",(Object)(anywheresoftware.b4a.keywords.Common.True));
 //BA.debugLineNum = 753;BA.debugLine="End Sub";
return "";
}
public static String  _setsetting(anywheresoftware.b4a.BA _ba,String _key,Object _value) throws Exception{
anywheresoftware.b4a.objects.collections.Map _settings = null;
 //BA.debugLineNum = 717;BA.debugLine="Public Sub SetSetting(key As String, value As Obje";
 //BA.debugLineNum = 718;BA.debugLine="Dim settings As Map = LoadSettings";
_settings = new anywheresoftware.b4a.objects.collections.Map();
_settings = _loadsettings(_ba);
 //BA.debugLineNum = 719;BA.debugLine="settings.Put(key, value)";
_settings.Put((Object)(_key),_value);
 //BA.debugLineNum = 720;BA.debugLine="SaveSettings(settings)";
_savesettings(_ba,_settings);
 //BA.debugLineNum = 721;BA.debugLine="End Sub";
return "";
}
public static String  _setusebiometric(anywheresoftware.b4a.BA _ba,boolean _use) throws Exception{
 //BA.debugLineNum = 727;BA.debugLine="Public Sub SetUseBiometric(use As Boolean)";
 //BA.debugLineNum = 728;BA.debugLine="SetSetting(\"useBiometric\", use)";
_setsetting(_ba,"useBiometric",(Object)(_use));
 //BA.debugLineNum = 729;BA.debugLine="End Sub";
return "";
}
public static String  _setusesinglepassphrase(anywheresoftware.b4a.BA _ba,boolean _use) throws Exception{
 //BA.debugLineNum = 854;BA.debugLine="Public Sub SetUseSinglePassphrase(use As Boolean)";
 //BA.debugLineNum = 855;BA.debugLine="SetSetting(\"singlePassphrase\", use)";
_setsetting(_ba,"singlePassphrase",(Object)(_use));
 //BA.debugLineNum = 856;BA.debugLine="End Sub";
return "";
}
public static boolean  _shouldwipegroup(anywheresoftware.b4a.BA _ba,String _groupid,int _maxattempts) throws Exception{
 //BA.debugLineNum = 651;BA.debugLine="Public Sub ShouldWipeGroup(groupId As String, maxA";
 //BA.debugLineNum = 652;BA.debugLine="If maxAttempts <= 0 Then Return False";
if (_maxattempts<=0) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 653;BA.debugLine="Return GetFailedAttempts(groupId) >= maxAttempts";
if (true) return _getfailedattempts(_ba,_groupid)>=_maxattempts;
 //BA.debugLineNum = 654;BA.debugLine="End Sub";
return false;
}
public static String  _strreverse(anywheresoftware.b4a.BA _ba,String _s) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
int _i = 0;
 //BA.debugLineNum = 1026;BA.debugLine="Private Sub StrReverse(s As String) As String";
 //BA.debugLineNum = 1027;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 1028;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 1029;BA.debugLine="For i = s.Length - 1 To 0 Step -1";
{
final int step3 = -1;
final int limit3 = (int) (0);
_i = (int) (_s.length()-1) ;
for (;_i >= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 1030;BA.debugLine="sb.Append(s.CharAt(i))";
_sb.Append(BA.ObjectToString(_s.charAt(_i)));
 }
};
 //BA.debugLineNum = 1032;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
 //BA.debugLineNum = 1033;BA.debugLine="End Sub";
return "";
}
public static boolean  _validatepassphrasestrength(anywheresoftware.b4a.BA _ba,String _phrase) throws Exception{
String _cleaned = "";
String _unique = "";
 //BA.debugLineNum = 64;BA.debugLine="Public Sub ValidatePassphraseStrength(phrase As St";
 //BA.debugLineNum = 65;BA.debugLine="Dim cleaned As String = RemoveAccents(phrase.Repl";
_cleaned = _removeaccents(_ba,_phrase.replace(" ","").toLowerCase());
 //BA.debugLineNum = 66;BA.debugLine="Dim unique As String = GetUniqueChars(cleaned, 10";
_unique = _getuniquechars(_ba,_cleaned,(int) (10));
 //BA.debugLineNum = 67;BA.debugLine="Return unique.Length >= 10";
if (true) return _unique.length()>=10;
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return false;
}
public static boolean  _validatepin(anywheresoftware.b4a.BA _ba,String _inputpin) throws Exception{
byte[] _inputhashbytes = null;
boolean _result = false;
String _data = "";
String _oldpin = "";
String[] _parts = null;
String _salt = "";
String _savedhash = "";
String _inputhash = "";
 //BA.debugLineNum = 911;BA.debugLine="Public Sub ValidatePIN(inputPin As String) As Bool";
 //BA.debugLineNum = 912;BA.debugLine="If HasPIN = False Then Return False";
if (_haspin(_ba)==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 914;BA.debugLine="Dim inputHashBytes() As Byte";
_inputhashbytes = new byte[(int) (0)];
;
 //BA.debugLineNum = 915;BA.debugLine="Dim result As Boolean = False";
_result = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 917;BA.debugLine="Try";
try { //BA.debugLineNum = 918;BA.debugLine="Dim data As String = File.ReadString(File.DirInt";
_data = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_pin_file);
 //BA.debugLineNum = 921;BA.debugLine="If data.Contains(\":\") = False Then";
if (_data.contains(":")==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 923;BA.debugLine="Log(\"ValidatePIN: Migrando PIN do formato antig";
anywheresoftware.b4a.keywords.Common.LogImpl("613107212","ValidatePIN: Migrando PIN do formato antigo para PBKDF2",0);
 //BA.debugLineNum = 924;BA.debugLine="Dim oldPin As String = MigrateLegacyPIN(data)";
_oldpin = _migratelegacypin(_ba,_data);
 //BA.debugLineNum = 925;BA.debugLine="If oldPin.Length > 0 And inputPin = oldPin Then";
if (_oldpin.length()>0 && (_inputpin).equals(_oldpin)) { 
 //BA.debugLineNum = 927;BA.debugLine="SavePIN(inputPin)";
_savepin(_ba,_inputpin);
 //BA.debugLineNum = 928;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 930;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 934;BA.debugLine="Dim parts() As String = Regex.Split(\":\", data)";
_parts = anywheresoftware.b4a.keywords.Common.Regex.Split(":",_data);
 //BA.debugLineNum = 935;BA.debugLine="If parts.Length <> 2 Then Return False";
if (_parts.length!=2) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 937;BA.debugLine="Dim salt As String = parts(0)";
_salt = _parts[(int) (0)];
 //BA.debugLineNum = 938;BA.debugLine="Dim savedHash As String = parts(1)";
_savedhash = _parts[(int) (1)];
 //BA.debugLineNum = 941;BA.debugLine="inputHashBytes = DeriveKeyPBKDF2(inputPin, salt)";
_inputhashbytes = _derivekeypbkdf2(_ba,_inputpin,_salt);
 //BA.debugLineNum = 942;BA.debugLine="If inputHashBytes = Null Then Return False";
if (_inputhashbytes== null) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 944;BA.debugLine="Dim inputHash As String = BytesToHex(inputHashBy";
_inputhash = _bytestohex(_ba,_inputhashbytes);
 //BA.debugLineNum = 947;BA.debugLine="result = SecureCompare(inputHash, savedHash)";
_result = _securecompare(_ba,_inputhash,_savedhash);
 } 
       catch (Exception e24) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e24); //BA.debugLineNum = 950;BA.debugLine="Log(\"ValidatePIN erro: \" & LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("613107239","ValidatePIN erro: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 954;BA.debugLine="ZeroBytes(inputHashBytes)";
_zerobytes(_ba,_inputhashbytes);
 //BA.debugLineNum = 956;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 957;BA.debugLine="End Sub";
return false;
}
public static String  _zerobytes(anywheresoftware.b4a.BA _ba,byte[] _bytes) throws Exception{
int _i = 0;
 //BA.debugLineNum = 1007;BA.debugLine="Private Sub ZeroBytes(bytes() As Byte)";
 //BA.debugLineNum = 1008;BA.debugLine="If bytes = Null Then Return";
if (_bytes== null) { 
if (true) return "";};
 //BA.debugLineNum = 1009;BA.debugLine="For i = 0 To bytes.Length - 1";
{
final int step2 = 1;
final int limit2 = (int) (_bytes.length-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 1010;BA.debugLine="bytes(i) = 0";
_bytes[_i] = (byte) (0);
 }
};
 //BA.debugLineNum = 1012;BA.debugLine="End Sub";
return "";
}
public static String  _zerochars(anywheresoftware.b4a.BA _ba,char[] _chars) throws Exception{
int _i = 0;
 //BA.debugLineNum = 1015;BA.debugLine="Private Sub ZeroChars(chars() As Char)";
 //BA.debugLineNum = 1016;BA.debugLine="If chars = Null Then Return";
if (_chars== null) { 
if (true) return "";};
 //BA.debugLineNum = 1017;BA.debugLine="For i = 0 To chars.Length - 1";
{
final int step2 = 1;
final int limit2 = (int) (_chars.length-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 1018;BA.debugLine="chars(i) = Chr(0)";
_chars[_i] = anywheresoftware.b4a.keywords.Common.Chr((int) (0));
 }
};
 //BA.debugLineNum = 1020;BA.debugLine="End Sub";
return "";
}
}
