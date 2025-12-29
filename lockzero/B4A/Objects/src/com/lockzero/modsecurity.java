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
public com.lockzero.modnotes _modnotes = null;
public com.lockzero.modpasswords _modpasswords = null;
public com.lockzero.modsession _modsession = null;
public com.lockzero.modtheme _modtheme = null;
public com.lockzero.b4xpages _b4xpages = null;
public com.lockzero.b4xcollections _b4xcollections = null;
public com.lockzero.xuiviewsutils _xuiviewsutils = null;
public static int  _calculatedelay(anywheresoftware.b4a.BA _ba,int _count) throws Exception{
int _extra = 0;
 //BA.debugLineNum = 375;BA.debugLine="Private Sub CalculateDelay(count As Int) As Int";
 //BA.debugLineNum = 376;BA.debugLine="If count < 5 Then Return 0  '1-4 tentativas: sem";
if (_count<5) { 
if (true) return (int) (0);};
 //BA.debugLineNum = 377;BA.debugLine="If count = 5 Then Return 60000  '5 tentativas: 1";
if (_count==5) { 
if (true) return (int) (60000);};
 //BA.debugLineNum = 378;BA.debugLine="If count <= 8 Then Return 60000  '6-8 tentativas:";
if (_count<=8) { 
if (true) return (int) (60000);};
 //BA.debugLineNum = 381;BA.debugLine="Dim extra As Int = (count - 8) / 2";
_extra = (int) ((_count-8)/(double)2);
 //BA.debugLineNum = 382;BA.debugLine="Return 300000 + (extra * 300000)  '5 min + extras";
if (true) return (int) (300000+(_extra*300000));
 //BA.debugLineNum = 383;BA.debugLine="End Sub";
return 0;
}
public static String  _clearstring(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 672;BA.debugLine="Public Sub ClearString As String";
 //BA.debugLineNum = 673;BA.debugLine="Return \"\"";
if (true) return "";
 //BA.debugLineNum = 674;BA.debugLine="End Sub";
return "";
}
public static String  _decrypt(anywheresoftware.b4a.BA _ba,String _passphrase,String _enctext) throws Exception{
String _normalizedphrase = "";
String _encdata = "";
anywheresoftware.b4a.agraham.encryption.CipherWrapper.MessageDigestWrapper _md = null;
byte[] _keybytes = null;
byte[] _ivbytes = null;
anywheresoftware.b4a.objects.StringUtils _su = null;
byte[] _encrypted = null;
anywheresoftware.b4a.agraham.encryption.CipherWrapper _c = null;
anywheresoftware.b4a.agraham.encryption.CipherWrapper.KeyGeneratorWrapper _kg = null;
byte[] _decrypted = null;
 //BA.debugLineNum = 190;BA.debugLine="Public Sub Decrypt(passPhrase As String, encText A";
 //BA.debugLineNum = 191;BA.debugLine="If passPhrase.Length < 1 Or encText.Length < 1 Th";
if (_passphrase.length()<1 || _enctext.length()<1) { 
if (true) return "";};
 //BA.debugLineNum = 194;BA.debugLine="Dim normalizedPhrase As String = NormalizePassphr";
_normalizedphrase = _normalizepassphrase(_ba,_passphrase);
 //BA.debugLineNum = 195;BA.debugLine="If normalizedPhrase.Length < 10 Then";
if (_normalizedphrase.length()<10) { 
 //BA.debugLineNum = 196;BA.debugLine="Log(\"Decrypt: Frase muito fraca!\")";
anywheresoftware.b4a.keywords.Common.LogImpl("543515910","Decrypt: Frase muito fraca!",0);
 //BA.debugLineNum = 197;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 200;BA.debugLine="Try";
try { //BA.debugLineNum = 202;BA.debugLine="If encText.StartsWith(\"AES:\") = False Then Retur";
if (_enctext.startsWith("AES:")==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 204;BA.debugLine="Dim encData As String = encText.SubString(4)";
_encdata = _enctext.substring((int) (4));
 //BA.debugLineNum = 206;BA.debugLine="Dim md As MessageDigest";
_md = new anywheresoftware.b4a.agraham.encryption.CipherWrapper.MessageDigestWrapper();
 //BA.debugLineNum = 207;BA.debugLine="Dim keyBytes() As Byte = md.GetMessageDigest(nor";
_keybytes = _md.GetMessageDigest(_normalizedphrase.getBytes("UTF8"),"SHA-256");
 //BA.debugLineNum = 208;BA.debugLine="Dim ivBytes() As Byte = md.GetMessageDigest(StrR";
_ivbytes = _md.GetMessageDigest(_strreverse(_ba,_normalizedphrase).getBytes("UTF8"),"MD5");
 //BA.debugLineNum = 210;BA.debugLine="Dim su As StringUtils";
_su = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 211;BA.debugLine="Dim encrypted() As Byte = su.DecodeBase64(encDat";
_encrypted = _su.DecodeBase64(_encdata);
 //BA.debugLineNum = 213;BA.debugLine="Dim c As Cipher";
_c = new anywheresoftware.b4a.agraham.encryption.CipherWrapper();
 //BA.debugLineNum = 214;BA.debugLine="Dim kg As KeyGenerator";
_kg = new anywheresoftware.b4a.agraham.encryption.CipherWrapper.KeyGeneratorWrapper();
 //BA.debugLineNum = 215;BA.debugLine="kg.Initialize(\"AES\")";
_kg.Initialize("AES");
 //BA.debugLineNum = 216;BA.debugLine="kg.KeyFromBytes(keyBytes)";
_kg.KeyFromBytes(_keybytes);
 //BA.debugLineNum = 218;BA.debugLine="c.Initialize(\"AES/CBC/PKCS5Padding\")";
_c.Initialize("AES/CBC/PKCS5Padding");
 //BA.debugLineNum = 219;BA.debugLine="c.InitialisationVector = ivBytes";
_c.setInitialisationVector(_ivbytes);
 //BA.debugLineNum = 221;BA.debugLine="Dim decrypted() As Byte = c.Decrypt(encrypted, k";
_decrypted = _c.Decrypt(_encrypted,(java.security.Key)(_kg.getKey()),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 223;BA.debugLine="Return BytesToString(decrypted, 0, decrypted.Len";
if (true) return anywheresoftware.b4a.keywords.Common.BytesToString(_decrypted,(int) (0),_decrypted.length,"UTF8");
 } 
       catch (Exception e24) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e24); //BA.debugLineNum = 226;BA.debugLine="Log(\"ModSecurity.Decrypt erro: \" & LastException";
anywheresoftware.b4a.keywords.Common.LogImpl("543515940","ModSecurity.Decrypt erro: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 //BA.debugLineNum = 227;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 229;BA.debugLine="End Sub";
return "";
}
public static String  _decryptwithsalt(anywheresoftware.b4a.BA _ba,String _passphrase,String _salt,String _enctext) throws Exception{
String _encdata = "";
byte[] _keybytes = null;
anywheresoftware.b4a.agraham.encryption.CipherWrapper.MessageDigestWrapper _md = null;
byte[] _ivbytes = null;
anywheresoftware.b4a.objects.StringUtils _su = null;
byte[] _encrypted = null;
anywheresoftware.b4a.agraham.encryption.CipherWrapper _c = null;
anywheresoftware.b4a.agraham.encryption.CipherWrapper.KeyGeneratorWrapper _kg = null;
byte[] _decrypted = null;
 //BA.debugLineNum = 306;BA.debugLine="Public Sub DecryptWithSalt(passPhrase As String, s";
 //BA.debugLineNum = 307;BA.debugLine="If passPhrase.Length < 1 Or encText.Length < 1 Or";
if (_passphrase.length()<1 || _enctext.length()<1 || _salt.length()<1) { 
if (true) return "";};
 //BA.debugLineNum = 309;BA.debugLine="Try";
try { //BA.debugLineNum = 310;BA.debugLine="If encText.StartsWith(\"AES:\") = False Then Retur";
if (_enctext.startsWith("AES:")==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 311;BA.debugLine="Dim encData As String = encText.SubString(4)";
_encdata = _enctext.substring((int) (4));
 //BA.debugLineNum = 314;BA.debugLine="Dim keyBytes() As Byte = DeriveKeyPBKDF2(passPhr";
_keybytes = _derivekeypbkdf2(_ba,_passphrase,_salt);
 //BA.debugLineNum = 317;BA.debugLine="Dim md As MessageDigest";
_md = new anywheresoftware.b4a.agraham.encryption.CipherWrapper.MessageDigestWrapper();
 //BA.debugLineNum = 318;BA.debugLine="Dim ivBytes() As Byte = md.GetMessageDigest(salt";
_ivbytes = _md.GetMessageDigest(_salt.getBytes("UTF8"),"MD5");
 //BA.debugLineNum = 320;BA.debugLine="Dim su As StringUtils";
_su = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 321;BA.debugLine="Dim encrypted() As Byte = su.DecodeBase64(encDat";
_encrypted = _su.DecodeBase64(_encdata);
 //BA.debugLineNum = 323;BA.debugLine="Dim c As Cipher";
_c = new anywheresoftware.b4a.agraham.encryption.CipherWrapper();
 //BA.debugLineNum = 324;BA.debugLine="Dim kg As KeyGenerator";
_kg = new anywheresoftware.b4a.agraham.encryption.CipherWrapper.KeyGeneratorWrapper();
 //BA.debugLineNum = 325;BA.debugLine="kg.Initialize(\"AES\")";
_kg.Initialize("AES");
 //BA.debugLineNum = 326;BA.debugLine="kg.KeyFromBytes(keyBytes)";
_kg.KeyFromBytes(_keybytes);
 //BA.debugLineNum = 328;BA.debugLine="c.Initialize(\"AES/CBC/PKCS5Padding\")";
_c.Initialize("AES/CBC/PKCS5Padding");
 //BA.debugLineNum = 329;BA.debugLine="c.InitialisationVector = ivBytes";
_c.setInitialisationVector(_ivbytes);
 //BA.debugLineNum = 331;BA.debugLine="Dim decrypted() As Byte = c.Decrypt(encrypted, k";
_decrypted = _c.Decrypt(_encrypted,(java.security.Key)(_kg.getKey()),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 333;BA.debugLine="Return BytesToString(decrypted, 0, decrypted.Len";
if (true) return anywheresoftware.b4a.keywords.Common.BytesToString(_decrypted,(int) (0),_decrypted.length,"UTF8");
 } 
       catch (Exception e19) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e19); //BA.debugLineNum = 336;BA.debugLine="Log(\"ModSecurity.DecryptWithSalt erro: \" & LastE";
anywheresoftware.b4a.keywords.Common.LogImpl("543778078","ModSecurity.DecryptWithSalt erro: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 //BA.debugLineNum = 337;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 339;BA.debugLine="End Sub";
return "";
}
public static byte[]  _derivekeypbkdf2(anywheresoftware.b4a.BA _ba,String _passphrase,String _salt) throws Exception{
anywheresoftware.b4j.object.JavaObject _jopass = null;
char[] _passchars = null;
byte[] _saltbytes = null;
anywheresoftware.b4j.object.JavaObject _keyspec = null;
anywheresoftware.b4j.object.JavaObject _factory = null;
anywheresoftware.b4j.object.JavaObject _secretkey = null;
byte[] _keybytes = null;
 //BA.debugLineNum = 242;BA.debugLine="Private Sub DeriveKeyPBKDF2(passPhrase As String,";
 //BA.debugLineNum = 244;BA.debugLine="Dim joPass As JavaObject = passPhrase";
_jopass = new anywheresoftware.b4j.object.JavaObject();
_jopass = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_passphrase));
 //BA.debugLineNum = 245;BA.debugLine="Dim passChars() As Char = joPass.RunMethod(\"toCha";
_passchars = (char[])(_jopass.RunMethod("toCharArray",(Object[])(anywheresoftware.b4a.keywords.Common.Null)));
 //BA.debugLineNum = 248;BA.debugLine="Dim saltBytes() As Byte = salt.GetBytes(\"UTF8\")";
_saltbytes = _salt.getBytes("UTF8");
 //BA.debugLineNum = 251;BA.debugLine="Dim keySpec As JavaObject";
_keyspec = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 252;BA.debugLine="keySpec.InitializeNewInstance(\"javax.crypto.spec.";
_keyspec.InitializeNewInstance("javax.crypto.spec.PBEKeySpec",new Object[]{(Object)(_passchars),(Object)(_saltbytes),(Object)(_pbkdf2_iterations),(Object)(_pbkdf2_key_length)});
 //BA.debugLineNum = 256;BA.debugLine="Dim factory As JavaObject";
_factory = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 257;BA.debugLine="factory = factory.InitializeStatic(\"javax.crypto.";
_factory = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_factory.InitializeStatic("javax.crypto.SecretKeyFactory").RunMethod("getInstance",new Object[]{(Object)("PBKDF2WithHmacSHA256")})));
 //BA.debugLineNum = 261;BA.debugLine="Dim secretKey As JavaObject = factory.RunMethod(\"";
_secretkey = new anywheresoftware.b4j.object.JavaObject();
_secretkey = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_factory.RunMethod("generateSecret",new Object[]{(Object)(_keyspec.getObject())})));
 //BA.debugLineNum = 262;BA.debugLine="Dim keyBytes() As Byte = secretKey.RunMethod(\"get";
_keybytes = (byte[])(_secretkey.RunMethod("getEncoded",(Object[])(anywheresoftware.b4a.keywords.Common.Null)));
 //BA.debugLineNum = 265;BA.debugLine="keySpec.RunMethod(\"clearPassword\", Null)";
_keyspec.RunMethod("clearPassword",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 267;BA.debugLine="Return keyBytes";
if (true) return _keybytes;
 //BA.debugLineNum = 268;BA.debugLine="End Sub";
return null;
}
public static String  _encrypt(anywheresoftware.b4a.BA _ba,String _passphrase,String _plaintext) throws Exception{
String _normalizedphrase = "";
anywheresoftware.b4a.agraham.encryption.CipherWrapper.MessageDigestWrapper _md = null;
byte[] _keybytes = null;
byte[] _ivbytes = null;
anywheresoftware.b4a.agraham.encryption.CipherWrapper _c = null;
anywheresoftware.b4a.agraham.encryption.CipherWrapper.KeyGeneratorWrapper _kg = null;
byte[] _databytes = null;
byte[] _encrypted = null;
anywheresoftware.b4a.objects.StringUtils _su = null;
 //BA.debugLineNum = 153;BA.debugLine="Public Sub Encrypt(passPhrase As String, plainText";
 //BA.debugLineNum = 154;BA.debugLine="If passPhrase.Length < 1 Or plainText.Length < 1";
if (_passphrase.length()<1 || _plaintext.length()<1) { 
if (true) return "";};
 //BA.debugLineNum = 157;BA.debugLine="Dim normalizedPhrase As String = NormalizePassphr";
_normalizedphrase = _normalizepassphrase(_ba,_passphrase);
 //BA.debugLineNum = 158;BA.debugLine="If normalizedPhrase.Length < 10 Then";
if (_normalizedphrase.length()<10) { 
 //BA.debugLineNum = 159;BA.debugLine="Log(\"Encrypt: Frase muito fraca!\")";
anywheresoftware.b4a.keywords.Common.LogImpl("543450374","Encrypt: Frase muito fraca!",0);
 //BA.debugLineNum = 160;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 163;BA.debugLine="Try";
try { //BA.debugLineNum = 164;BA.debugLine="Dim md As MessageDigest";
_md = new anywheresoftware.b4a.agraham.encryption.CipherWrapper.MessageDigestWrapper();
 //BA.debugLineNum = 165;BA.debugLine="Dim keyBytes() As Byte = md.GetMessageDigest(nor";
_keybytes = _md.GetMessageDigest(_normalizedphrase.getBytes("UTF8"),"SHA-256");
 //BA.debugLineNum = 166;BA.debugLine="Dim ivBytes() As Byte = md.GetMessageDigest(StrR";
_ivbytes = _md.GetMessageDigest(_strreverse(_ba,_normalizedphrase).getBytes("UTF8"),"MD5");
 //BA.debugLineNum = 168;BA.debugLine="Dim c As Cipher";
_c = new anywheresoftware.b4a.agraham.encryption.CipherWrapper();
 //BA.debugLineNum = 169;BA.debugLine="Dim kg As KeyGenerator";
_kg = new anywheresoftware.b4a.agraham.encryption.CipherWrapper.KeyGeneratorWrapper();
 //BA.debugLineNum = 170;BA.debugLine="kg.Initialize(\"AES\")";
_kg.Initialize("AES");
 //BA.debugLineNum = 171;BA.debugLine="kg.KeyFromBytes(keyBytes)";
_kg.KeyFromBytes(_keybytes);
 //BA.debugLineNum = 173;BA.debugLine="c.Initialize(\"AES/CBC/PKCS5Padding\")";
_c.Initialize("AES/CBC/PKCS5Padding");
 //BA.debugLineNum = 174;BA.debugLine="c.InitialisationVector = ivBytes";
_c.setInitialisationVector(_ivbytes);
 //BA.debugLineNum = 176;BA.debugLine="Dim dataBytes() As Byte = plainText.GetBytes(\"UT";
_databytes = _plaintext.getBytes("UTF8");
 //BA.debugLineNum = 177;BA.debugLine="Dim encrypted() As Byte = c.Encrypt(dataBytes, k";
_encrypted = _c.Encrypt(_databytes,(java.security.Key)(_kg.getKey()),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 179;BA.debugLine="Dim su As StringUtils";
_su = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 180;BA.debugLine="Return \"AES:\" & su.EncodeBase64(encrypted)";
if (true) return "AES:"+_su.EncodeBase64(_encrypted);
 } 
       catch (Exception e22) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e22); //BA.debugLineNum = 183;BA.debugLine="Log(\"ModSecurity.Encrypt erro: \" & LastException";
anywheresoftware.b4a.keywords.Common.LogImpl("543450398","ModSecurity.Encrypt erro: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 //BA.debugLineNum = 184;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 186;BA.debugLine="End Sub";
return "";
}
public static String  _encryptwithsalt(anywheresoftware.b4a.BA _ba,String _passphrase,String _salt,String _plaintext) throws Exception{
byte[] _keybytes = null;
anywheresoftware.b4a.agraham.encryption.CipherWrapper.MessageDigestWrapper _md = null;
byte[] _ivbytes = null;
anywheresoftware.b4a.agraham.encryption.CipherWrapper _c = null;
anywheresoftware.b4a.agraham.encryption.CipherWrapper.KeyGeneratorWrapper _kg = null;
byte[] _databytes = null;
byte[] _encrypted = null;
anywheresoftware.b4a.objects.StringUtils _su = null;
 //BA.debugLineNum = 274;BA.debugLine="Public Sub EncryptWithSalt(passPhrase As String, s";
 //BA.debugLineNum = 275;BA.debugLine="If passPhrase.Length < 1 Or plainText.Length < 1";
if (_passphrase.length()<1 || _plaintext.length()<1 || _salt.length()<1) { 
if (true) return "";};
 //BA.debugLineNum = 277;BA.debugLine="Try";
try { //BA.debugLineNum = 279;BA.debugLine="Dim keyBytes() As Byte = DeriveKeyPBKDF2(passPhr";
_keybytes = _derivekeypbkdf2(_ba,_passphrase,_salt);
 //BA.debugLineNum = 282;BA.debugLine="Dim md As MessageDigest";
_md = new anywheresoftware.b4a.agraham.encryption.CipherWrapper.MessageDigestWrapper();
 //BA.debugLineNum = 283;BA.debugLine="Dim ivBytes() As Byte = md.GetMessageDigest(salt";
_ivbytes = _md.GetMessageDigest(_salt.getBytes("UTF8"),"MD5");
 //BA.debugLineNum = 285;BA.debugLine="Dim c As Cipher";
_c = new anywheresoftware.b4a.agraham.encryption.CipherWrapper();
 //BA.debugLineNum = 286;BA.debugLine="Dim kg As KeyGenerator";
_kg = new anywheresoftware.b4a.agraham.encryption.CipherWrapper.KeyGeneratorWrapper();
 //BA.debugLineNum = 287;BA.debugLine="kg.Initialize(\"AES\")";
_kg.Initialize("AES");
 //BA.debugLineNum = 288;BA.debugLine="kg.KeyFromBytes(keyBytes)";
_kg.KeyFromBytes(_keybytes);
 //BA.debugLineNum = 290;BA.debugLine="c.Initialize(\"AES/CBC/PKCS5Padding\")";
_c.Initialize("AES/CBC/PKCS5Padding");
 //BA.debugLineNum = 291;BA.debugLine="c.InitialisationVector = ivBytes";
_c.setInitialisationVector(_ivbytes);
 //BA.debugLineNum = 293;BA.debugLine="Dim dataBytes() As Byte = plainText.GetBytes(\"UT";
_databytes = _plaintext.getBytes("UTF8");
 //BA.debugLineNum = 294;BA.debugLine="Dim encrypted() As Byte = c.Encrypt(dataBytes, k";
_encrypted = _c.Encrypt(_databytes,(java.security.Key)(_kg.getKey()),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 296;BA.debugLine="Dim su As StringUtils";
_su = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 297;BA.debugLine="Return \"AES:\" & su.EncodeBase64(encrypted)";
if (true) return "AES:"+_su.EncodeBase64(_encrypted);
 } 
       catch (Exception e17) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e17); //BA.debugLineNum = 300;BA.debugLine="Log(\"ModSecurity.EncryptWithSalt erro: \" & LastE";
anywheresoftware.b4a.keywords.Common.LogImpl("543712538","ModSecurity.EncryptWithSalt erro: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 //BA.debugLineNum = 301;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 303;BA.debugLine="End Sub";
return "";
}
public static String  _formatdelay(anywheresoftware.b4a.BA _ba,int _delayms) throws Exception{
int _secs = 0;
int _mins = 0;
int _secsrest = 0;
 //BA.debugLineNum = 450;BA.debugLine="Public Sub FormatDelay(delayMs As Int) As String";
 //BA.debugLineNum = 451;BA.debugLine="Dim secs As Int = delayMs / 1000";
_secs = (int) (_delayms/(double)1000);
 //BA.debugLineNum = 452;BA.debugLine="Dim mins As Int = secs / 60";
_mins = (int) (_secs/(double)60);
 //BA.debugLineNum = 453;BA.debugLine="Dim secsRest As Int = secs Mod 60";
_secsrest = (int) (_secs%60);
 //BA.debugLineNum = 454;BA.debugLine="Return NumberFormat(mins, 1, 0) & \":\" & NumberFor";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_mins,(int) (1),(int) (0))+":"+anywheresoftware.b4a.keywords.Common.NumberFormat(_secsrest,(int) (2),(int) (0));
 //BA.debugLineNum = 455;BA.debugLine="End Sub";
return "";
}
public static String  _generaterandomsalt(anywheresoftware.b4a.BA _ba) throws Exception{
String _uuid = "";
 //BA.debugLineNum = 342;BA.debugLine="Public Sub GenerateRandomSalt As String";
 //BA.debugLineNum = 343;BA.debugLine="Dim uuid As String = GenerateUUID";
_uuid = _generateuuid(_ba);
 //BA.debugLineNum = 344;BA.debugLine="Return uuid.Replace(\"-\", \"\").SubString2(0, 32)";
if (true) return _uuid.replace("-","").substring((int) (0),(int) (32));
 //BA.debugLineNum = 345;BA.debugLine="End Sub";
return "";
}
public static String  _generateuuid(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
 //BA.debugLineNum = 665;BA.debugLine="Public Sub GenerateUUID As String";
 //BA.debugLineNum = 666;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
 //BA.debugLineNum = 667;BA.debugLine="r.Target = r.RunStaticMethod(\"java.util.UUID\", \"r";
_r.Target = _r.RunStaticMethod("java.util.UUID","randomUUID",(Object[])(anywheresoftware.b4a.keywords.Common.Null),(String[])(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 668;BA.debugLine="Return r.RunMethod(\"toString\")";
if (true) return BA.ObjectToString(_r.RunMethod("toString"));
 //BA.debugLineNum = 669;BA.debugLine="End Sub";
return "";
}
public static int  _getclipboardtimeout(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 633;BA.debugLine="Public Sub GetClipboardTimeout As Int";
 //BA.debugLineNum = 634;BA.debugLine="Return GetSetting(\"clipboardTimeout\", 30)";
if (true) return (int)(BA.ObjectToNumber(_getsetting(_ba,"clipboardTimeout",(Object)(30))));
 //BA.debugLineNum = 635;BA.debugLine="End Sub";
return 0;
}
public static int  _getfailedattempts(anywheresoftware.b4a.BA _ba,String _groupid) throws Exception{
anywheresoftware.b4a.objects.collections.Map _attempts = null;
anywheresoftware.b4a.objects.collections.Map _groupdata = null;
 //BA.debugLineNum = 420;BA.debugLine="Public Sub GetFailedAttempts(groupId As String) As";
 //BA.debugLineNum = 421;BA.debugLine="Dim attempts As Map = LoadAttempts";
_attempts = new anywheresoftware.b4a.objects.collections.Map();
_attempts = _loadattempts(_ba);
 //BA.debugLineNum = 422;BA.debugLine="If attempts.ContainsKey(groupId) = False Then Ret";
if (_attempts.ContainsKey((Object)(_groupid))==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return (int) (0);};
 //BA.debugLineNum = 424;BA.debugLine="Dim groupData As Map = attempts.Get(groupId)";
_groupdata = new anywheresoftware.b4a.objects.collections.Map();
_groupdata = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_attempts.Get((Object)(_groupid))));
 //BA.debugLineNum = 425;BA.debugLine="Return groupData.GetDefault(\"count\", 0)";
if (true) return (int)(BA.ObjectToNumber(_groupdata.GetDefault((Object)("count"),(Object)(0))));
 //BA.debugLineNum = 426;BA.debugLine="End Sub";
return 0;
}
public static String  _getlanguage(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 585;BA.debugLine="Public Sub GetLanguage As String";
 //BA.debugLineNum = 586;BA.debugLine="Return GetSetting(\"language\", \"pt\")";
if (true) return BA.ObjectToString(_getsetting(_ba,"language",(Object)("pt")));
 //BA.debugLineNum = 587;BA.debugLine="End Sub";
return "";
}
public static String  _getpassphraseerror(anywheresoftware.b4a.BA _ba,String _phrase) throws Exception{
String _cleaned = "";
String _unique = "";
 //BA.debugLineNum = 73;BA.debugLine="Public Sub GetPassphraseError(phrase As String) As";
 //BA.debugLineNum = 74;BA.debugLine="If phrase.Length < 8 Then";
if (_phrase.length()<8) { 
 //BA.debugLineNum = 75;BA.debugLine="Return ModLang.T(\"passphrase_too_short\")";
if (true) return mostCurrent._modlang._t /*String*/ (_ba,"passphrase_too_short");
 };
 //BA.debugLineNum = 78;BA.debugLine="Dim cleaned As String = RemoveAccents(phrase.Repl";
_cleaned = _removeaccents(_ba,_phrase.replace(" ","").toLowerCase());
 //BA.debugLineNum = 79;BA.debugLine="Dim unique As String = GetUniqueChars(cleaned, 10";
_unique = _getuniquechars(_ba,_cleaned,(int) (10));
 //BA.debugLineNum = 81;BA.debugLine="If unique.Length < 10 Then";
if (_unique.length()<10) { 
 //BA.debugLineNum = 82;BA.debugLine="Return ModLang.T(\"passphrase_too_short\")";
if (true) return mostCurrent._modlang._t /*String*/ (_ba,"passphrase_too_short");
 };
 //BA.debugLineNum = 85;BA.debugLine="Return \"\" 'OK";
if (true) return "";
 //BA.debugLineNum = 86;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 429;BA.debugLine="Public Sub GetRemainingDelay(groupId As String) As";
 //BA.debugLineNum = 430;BA.debugLine="Dim attempts As Map = LoadAttempts";
_attempts = new anywheresoftware.b4a.objects.collections.Map();
_attempts = _loadattempts(_ba);
 //BA.debugLineNum = 431;BA.debugLine="If attempts.ContainsKey(groupId) = False Then Ret";
if (_attempts.ContainsKey((Object)(_groupid))==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return (int) (0);};
 //BA.debugLineNum = 433;BA.debugLine="Dim groupData As Map = attempts.Get(groupId)";
_groupdata = new anywheresoftware.b4a.objects.collections.Map();
_groupdata = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_attempts.Get((Object)(_groupid))));
 //BA.debugLineNum = 434;BA.debugLine="Dim count As Int = groupData.GetDefault(\"count\",";
_count = (int)(BA.ObjectToNumber(_groupdata.GetDefault((Object)("count"),(Object)(0))));
 //BA.debugLineNum = 435;BA.debugLine="Dim lastFailed As Long = groupData.GetDefault(\"la";
_lastfailed = BA.ObjectToLongNumber(_groupdata.GetDefault((Object)("lastFailed"),(Object)(0)));
 //BA.debugLineNum = 437;BA.debugLine="If count = 0 Then Return 0";
if (_count==0) { 
if (true) return (int) (0);};
 //BA.debugLineNum = 439;BA.debugLine="Dim requiredDelay As Int = CalculateDelay(count)";
_requireddelay = _calculatedelay(_ba,_count);
 //BA.debugLineNum = 440;BA.debugLine="If requiredDelay = 0 Then Return 0";
if (_requireddelay==0) { 
if (true) return (int) (0);};
 //BA.debugLineNum = 442;BA.debugLine="Dim elapsed As Long = DateTime.Now - lastFailed";
_elapsed = (long) (anywheresoftware.b4a.keywords.Common.DateTime.getNow()-_lastfailed);
 //BA.debugLineNum = 443;BA.debugLine="Dim remaining As Int = requiredDelay - elapsed";
_remaining = (int) (_requireddelay-_elapsed);
 //BA.debugLineNum = 445;BA.debugLine="If remaining < 0 Then Return 0";
if (_remaining<0) { 
if (true) return (int) (0);};
 //BA.debugLineNum = 446;BA.debugLine="Return remaining";
if (true) return _remaining;
 //BA.debugLineNum = 447;BA.debugLine="End Sub";
return 0;
}
public static int  _getsessiontimeout(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 619;BA.debugLine="Public Sub GetSessionTimeout As Int";
 //BA.debugLineNum = 620;BA.debugLine="Return GetSetting(\"sessionTimeout\", 120) '2 minut";
if (true) return (int)(BA.ObjectToNumber(_getsetting(_ba,"sessionTimeout",(Object)(120))));
 //BA.debugLineNum = 621;BA.debugLine="End Sub";
return 0;
}
public static Object  _getsetting(anywheresoftware.b4a.BA _ba,String _key,Object _defaultvalue) throws Exception{
anywheresoftware.b4a.objects.collections.Map _settings = null;
 //BA.debugLineNum = 554;BA.debugLine="Public Sub GetSetting(key As String, defaultValue";
 //BA.debugLineNum = 555;BA.debugLine="Dim settings As Map = LoadSettings";
_settings = new anywheresoftware.b4a.objects.collections.Map();
_settings = _loadsettings(_ba);
 //BA.debugLineNum = 556;BA.debugLine="Return settings.GetDefault(key, defaultValue)";
if (true) return _settings.GetDefault((Object)(_key),_defaultvalue);
 //BA.debugLineNum = 557;BA.debugLine="End Sub";
return null;
}
public static int  _gettheme(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 605;BA.debugLine="Public Sub GetTheme As Int";
 //BA.debugLineNum = 606;BA.debugLine="Return GetSetting(\"theme\", 0)";
if (true) return (int)(BA.ObjectToNumber(_getsetting(_ba,"theme",(Object)(0))));
 //BA.debugLineNum = 607;BA.debugLine="End Sub";
return 0;
}
public static String  _getuniquechars(anywheresoftware.b4a.BA _ba,String _text,int _count) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _result = null;
String _seen = "";
int _i = 0;
String _c = "";
 //BA.debugLineNum = 129;BA.debugLine="Private Sub GetUniqueChars(text As String, count A";
 //BA.debugLineNum = 130;BA.debugLine="Dim result As StringBuilder";
_result = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 131;BA.debugLine="result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 132;BA.debugLine="Dim seen As String = \"\"";
_seen = "";
 //BA.debugLineNum = 134;BA.debugLine="For i = 0 To text.Length - 1";
{
final int step4 = 1;
final int limit4 = (int) (_text.length()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 135;BA.debugLine="If result.Length >= count Then Exit";
if (_result.getLength()>=_count) { 
if (true) break;};
 //BA.debugLineNum = 137;BA.debugLine="Dim c As String = text.CharAt(i)";
_c = BA.ObjectToString(_text.charAt(_i));
 //BA.debugLineNum = 138;BA.debugLine="If seen.Contains(c) = False Then";
if (_seen.contains(_c)==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 139;BA.debugLine="result.Append(c)";
_result.Append(_c);
 //BA.debugLineNum = 140;BA.debugLine="seen = seen & c";
_seen = _seen+_c;
 };
 }
};
 //BA.debugLineNum = 144;BA.debugLine="Return result.ToString";
if (true) return _result.ToString();
 //BA.debugLineNum = 145;BA.debugLine="End Sub";
return "";
}
public static boolean  _getusebiometric(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 573;BA.debugLine="Public Sub GetUseBiometric As Boolean";
 //BA.debugLineNum = 574;BA.debugLine="Return GetSetting(\"useBiometric\", False)";
if (true) return BA.ObjectToBoolean(_getsetting(_ba,"useBiometric",(Object)(anywheresoftware.b4a.keywords.Common.False)));
 //BA.debugLineNum = 575;BA.debugLine="End Sub";
return false;
}
public static boolean  _getusesinglepassphrase(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 647;BA.debugLine="Public Sub GetUseSinglePassphrase As Boolean";
 //BA.debugLineNum = 648;BA.debugLine="Return GetSetting(\"singlePassphrase\", True)  'Pad";
if (true) return BA.ObjectToBoolean(_getsetting(_ba,"singlePassphrase",(Object)(anywheresoftware.b4a.keywords.Common.True)));
 //BA.debugLineNum = 649;BA.debugLine="End Sub";
return false;
}
public static boolean  _haspin(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 495;BA.debugLine="Public Sub HasPIN As Boolean";
 //BA.debugLineNum = 496;BA.debugLine="Return File.Exists(File.DirInternal, PIN_FILE)";
if (true) return anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_pin_file);
 //BA.debugLineNum = 497;BA.debugLine="End Sub";
return false;
}
public static boolean  _isencrypted(anywheresoftware.b4a.BA _ba,String _value) throws Exception{
 //BA.debugLineNum = 232;BA.debugLine="Public Sub IsEncrypted(value As String) As Boolean";
 //BA.debugLineNum = 233;BA.debugLine="Return value.StartsWith(\"AES:\")";
if (true) return _value.startsWith("AES:");
 //BA.debugLineNum = 234;BA.debugLine="End Sub";
return false;
}
public static boolean  _islanguagechosen(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 589;BA.debugLine="Public Sub IsLanguageChosen As Boolean";
 //BA.debugLineNum = 590;BA.debugLine="Return GetSetting(\"languageChosen\", False)";
if (true) return BA.ObjectToBoolean(_getsetting(_ba,"languageChosen",(Object)(anywheresoftware.b4a.keywords.Common.False)));
 //BA.debugLineNum = 591;BA.debugLine="End Sub";
return false;
}
public static boolean  _isvalidphrase(anywheresoftware.b4a.BA _ba,String _phrase) throws Exception{
 //BA.debugLineNum = 365;BA.debugLine="Public Sub IsValidPhrase(phrase As String) As Bool";
 //BA.debugLineNum = 366;BA.debugLine="Return phrase.Length >= 8";
if (true) return _phrase.length()>=8;
 //BA.debugLineNum = 367;BA.debugLine="End Sub";
return false;
}
public static boolean  _isvalidpin(anywheresoftware.b4a.BA _ba,String _pin) throws Exception{
int _i = 0;
int _code = 0;
 //BA.debugLineNum = 352;BA.debugLine="Public Sub IsValidPIN(pin As String) As Boolean";
 //BA.debugLineNum = 353;BA.debugLine="If pin.Length < 6 Then Return False";
if (_pin.length()<6) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 356;BA.debugLine="For i = 0 To pin.Length - 1";
{
final int step2 = 1;
final int limit2 = (int) (_pin.length()-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 357;BA.debugLine="Dim code As Int = Asc(pin.CharAt(i))";
_code = anywheresoftware.b4a.keywords.Common.Asc(_pin.charAt(_i));
 //BA.debugLineNum = 358;BA.debugLine="If code < 48 Or code > 57 Then Return False  '48";
if (_code<48 || _code>57) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 }
};
 //BA.debugLineNum = 361;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 362;BA.debugLine="End Sub";
return false;
}
public static anywheresoftware.b4a.objects.collections.Map  _loadattempts(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.Map _attempts = null;
String _json = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
 //BA.debugLineNum = 463;BA.debugLine="Private Sub LoadAttempts As Map";
 //BA.debugLineNum = 464;BA.debugLine="Dim attempts As Map";
_attempts = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 465;BA.debugLine="attempts.Initialize";
_attempts.Initialize();
 //BA.debugLineNum = 467;BA.debugLine="If File.Exists(File.DirInternal, ATTEMPTS_FILE) T";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_attempts_file)) { 
 //BA.debugLineNum = 468;BA.debugLine="Try";
try { //BA.debugLineNum = 469;BA.debugLine="Dim json As String = File.ReadString(File.DirIn";
_json = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_attempts_file);
 //BA.debugLineNum = 470;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 471;BA.debugLine="parser.Initialize(json)";
_parser.Initialize(_json);
 //BA.debugLineNum = 472;BA.debugLine="attempts = parser.NextObject";
_attempts = _parser.NextObject();
 } 
       catch (Exception e10) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e10); //BA.debugLineNum = 474;BA.debugLine="Log(\"ModSecurity.LoadAttempts erro: \" & LastExc";
anywheresoftware.b4a.keywords.Common.LogImpl("544498955","ModSecurity.LoadAttempts erro: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 };
 //BA.debugLineNum = 478;BA.debugLine="Return attempts";
if (true) return _attempts;
 //BA.debugLineNum = 479;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.Map  _loadsettings(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.Map _settings = null;
String _json = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
 //BA.debugLineNum = 530;BA.debugLine="Public Sub LoadSettings As Map";
 //BA.debugLineNum = 531;BA.debugLine="Dim settings As Map";
_settings = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 532;BA.debugLine="settings.Initialize";
_settings.Initialize();
 //BA.debugLineNum = 534;BA.debugLine="If File.Exists(File.DirInternal, SETTINGS_FILE) T";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settings_file)) { 
 //BA.debugLineNum = 535;BA.debugLine="Try";
try { //BA.debugLineNum = 536;BA.debugLine="Dim json As String = File.ReadString(File.DirIn";
_json = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settings_file);
 //BA.debugLineNum = 537;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 538;BA.debugLine="parser.Initialize(json)";
_parser.Initialize(_json);
 //BA.debugLineNum = 539;BA.debugLine="settings = parser.NextObject";
_settings = _parser.NextObject();
 } 
       catch (Exception e10) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e10); //BA.debugLineNum = 541;BA.debugLine="Log(\"ModSecurity.LoadSettings erro: \" & LastExc";
anywheresoftware.b4a.keywords.Common.LogImpl("544892171","ModSecurity.LoadSettings erro: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 };
 //BA.debugLineNum = 545;BA.debugLine="Return settings";
if (true) return _settings;
 //BA.debugLineNum = 546;BA.debugLine="End Sub";
return null;
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
 //BA.debugLineNum = 60;BA.debugLine="Log(\"NormalizePassphrase: '\" & phrase & \"' → '\" &";
anywheresoftware.b4a.keywords.Common.LogImpl("543122697","NormalizePassphrase: '"+_phrase+"' → '"+_unique+"'",0);
 //BA.debugLineNum = 61;BA.debugLine="Return unique";
if (true) return _unique;
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 387;BA.debugLine="Public Sub RegisterFailedAttempt(groupId As String";
 //BA.debugLineNum = 388;BA.debugLine="Dim attempts As Map = LoadAttempts";
_attempts = new anywheresoftware.b4a.objects.collections.Map();
_attempts = _loadattempts(_ba);
 //BA.debugLineNum = 390;BA.debugLine="Dim groupData As Map";
_groupdata = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 391;BA.debugLine="If attempts.ContainsKey(groupId) Then";
if (_attempts.ContainsKey((Object)(_groupid))) { 
 //BA.debugLineNum = 392;BA.debugLine="groupData = attempts.Get(groupId)";
_groupdata = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_attempts.Get((Object)(_groupid))));
 }else {
 //BA.debugLineNum = 394;BA.debugLine="groupData.Initialize";
_groupdata.Initialize();
 //BA.debugLineNum = 395;BA.debugLine="groupData.Put(\"count\", 0)";
_groupdata.Put((Object)("count"),(Object)(0));
 //BA.debugLineNum = 396;BA.debugLine="groupData.Put(\"lastFailed\", 0)";
_groupdata.Put((Object)("lastFailed"),(Object)(0));
 };
 //BA.debugLineNum = 399;BA.debugLine="Dim count As Int = groupData.Get(\"count\") + 1";
_count = (int) ((double)(BA.ObjectToNumber(_groupdata.Get((Object)("count"))))+1);
 //BA.debugLineNum = 400;BA.debugLine="groupData.Put(\"count\", count)";
_groupdata.Put((Object)("count"),(Object)(_count));
 //BA.debugLineNum = 401;BA.debugLine="groupData.Put(\"lastFailed\", DateTime.Now)";
_groupdata.Put((Object)("lastFailed"),(Object)(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
 //BA.debugLineNum = 402;BA.debugLine="attempts.Put(groupId, groupData)";
_attempts.Put((Object)(_groupid),(Object)(_groupdata.getObject()));
 //BA.debugLineNum = 404;BA.debugLine="SaveAttempts(attempts)";
_saveattempts(_ba,_attempts);
 //BA.debugLineNum = 407;BA.debugLine="Return CalculateDelay(count)";
if (true) return _calculatedelay(_ba,_count);
 //BA.debugLineNum = 408;BA.debugLine="End Sub";
return 0;
}
public static String  _removeaccents(anywheresoftware.b4a.BA _ba,String _text) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _result = null;
int _i = 0;
char _c = '\0';
int _code = 0;
 //BA.debugLineNum = 89;BA.debugLine="Private Sub RemoveAccents(text As String) As Strin";
 //BA.debugLineNum = 90;BA.debugLine="Dim result As StringBuilder";
_result = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 91;BA.debugLine="result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 93;BA.debugLine="For i = 0 To text.Length - 1";
{
final int step3 = 1;
final int limit3 = (int) (_text.length()-1);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 94;BA.debugLine="Dim c As Char = text.CharAt(i)";
_c = _text.charAt(_i);
 //BA.debugLineNum = 95;BA.debugLine="Dim code As Int = Asc(c)";
_code = anywheresoftware.b4a.keywords.Common.Asc(_c);
 //BA.debugLineNum = 98;BA.debugLine="Select code";
switch (_code) {
case 192: 
case 193: 
case 194: 
case 195: 
case 196: 
case 197: {
 //BA.debugLineNum = 100;BA.debugLine="Case 192, 193, 194, 195, 196, 197: result.Appen";
_result.Append("A");
 break; }
case 199: {
 //BA.debugLineNum = 101;BA.debugLine="Case 199: result.Append(\"C\") 'Ç";
_result.Append("C");
 break; }
case 200: 
case 201: 
case 202: 
case 203: {
 //BA.debugLineNum = 102;BA.debugLine="Case 200, 201, 202, 203: result.Append(\"E\") 'È";
_result.Append("E");
 break; }
case 204: 
case 205: 
case 206: 
case 207: {
 //BA.debugLineNum = 103;BA.debugLine="Case 204, 205, 206, 207: result.Append(\"I\") 'Ì";
_result.Append("I");
 break; }
case 209: {
 //BA.debugLineNum = 104;BA.debugLine="Case 209: result.Append(\"N\") 'Ñ";
_result.Append("N");
 break; }
case 210: 
case 211: 
case 212: 
case 213: 
case 214: {
 //BA.debugLineNum = 105;BA.debugLine="Case 210, 211, 212, 213, 214: result.Append(\"O\"";
_result.Append("O");
 break; }
case 217: 
case 218: 
case 219: 
case 220: {
 //BA.debugLineNum = 106;BA.debugLine="Case 217, 218, 219, 220: result.Append(\"U\") 'Ù";
_result.Append("U");
 break; }
case 221: {
 //BA.debugLineNum = 107;BA.debugLine="Case 221: result.Append(\"Y\") 'Ý";
_result.Append("Y");
 break; }
case 224: 
case 225: 
case 226: 
case 227: 
case 228: 
case 229: {
 //BA.debugLineNum = 109;BA.debugLine="Case 224, 225, 226, 227, 228, 229: result.Appen";
_result.Append("a");
 break; }
case 231: {
 //BA.debugLineNum = 110;BA.debugLine="Case 231: result.Append(\"c\") 'ç";
_result.Append("c");
 break; }
case 232: 
case 233: 
case 234: 
case 235: {
 //BA.debugLineNum = 111;BA.debugLine="Case 232, 233, 234, 235: result.Append(\"e\") 'è";
_result.Append("e");
 break; }
case 236: 
case 237: 
case 238: 
case 239: {
 //BA.debugLineNum = 112;BA.debugLine="Case 236, 237, 238, 239: result.Append(\"i\") 'ì";
_result.Append("i");
 break; }
case 241: {
 //BA.debugLineNum = 113;BA.debugLine="Case 241: result.Append(\"n\") 'ñ";
_result.Append("n");
 break; }
case 242: 
case 243: 
case 244: 
case 245: 
case 246: {
 //BA.debugLineNum = 114;BA.debugLine="Case 242, 243, 244, 245, 246: result.Append(\"o\"";
_result.Append("o");
 break; }
case 249: 
case 250: 
case 251: 
case 252: {
 //BA.debugLineNum = 115;BA.debugLine="Case 249, 250, 251, 252: result.Append(\"u\") 'ù";
_result.Append("u");
 break; }
case 253: 
case 255: {
 //BA.debugLineNum = 116;BA.debugLine="Case 253, 255: result.Append(\"y\") 'ý ÿ";
_result.Append("y");
 break; }
default: {
 //BA.debugLineNum = 119;BA.debugLine="If code >= 32 And code <= 126 Then";
if (_code>=32 && _code<=126) { 
 //BA.debugLineNum = 120;BA.debugLine="result.Append(c)";
_result.Append(BA.ObjectToString(_c));
 };
 break; }
}
;
 }
};
 //BA.debugLineNum = 125;BA.debugLine="Return result.ToString";
if (true) return _result.ToString();
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public static String  _removepin(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 520;BA.debugLine="Public Sub RemovePIN";
 //BA.debugLineNum = 521;BA.debugLine="If File.Exists(File.DirInternal, PIN_FILE) Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_pin_file)) { 
 //BA.debugLineNum = 522;BA.debugLine="File.Delete(File.DirInternal, PIN_FILE)";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_pin_file);
 };
 //BA.debugLineNum = 524;BA.debugLine="End Sub";
return "";
}
public static String  _resetfailedattempts(anywheresoftware.b4a.BA _ba,String _groupid) throws Exception{
anywheresoftware.b4a.objects.collections.Map _attempts = null;
 //BA.debugLineNum = 411;BA.debugLine="Public Sub ResetFailedAttempts(groupId As String)";
 //BA.debugLineNum = 412;BA.debugLine="Dim attempts As Map = LoadAttempts";
_attempts = new anywheresoftware.b4a.objects.collections.Map();
_attempts = _loadattempts(_ba);
 //BA.debugLineNum = 413;BA.debugLine="If attempts.ContainsKey(groupId) Then";
if (_attempts.ContainsKey((Object)(_groupid))) { 
 //BA.debugLineNum = 414;BA.debugLine="attempts.Remove(groupId)";
_attempts.Remove((Object)(_groupid));
 //BA.debugLineNum = 415;BA.debugLine="SaveAttempts(attempts)";
_saveattempts(_ba,_attempts);
 };
 //BA.debugLineNum = 417;BA.debugLine="End Sub";
return "";
}
public static String  _saveattempts(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.Map _attempts) throws Exception{
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _gen = null;
 //BA.debugLineNum = 481;BA.debugLine="Private Sub SaveAttempts(attempts As Map)";
 //BA.debugLineNum = 482;BA.debugLine="Try";
try { //BA.debugLineNum = 483;BA.debugLine="Dim gen As JSONGenerator";
_gen = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 484;BA.debugLine="gen.Initialize(attempts)";
_gen.Initialize(_attempts);
 //BA.debugLineNum = 485;BA.debugLine="File.WriteString(File.DirInternal, ATTEMPTS_FILE";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_attempts_file,_gen.ToString());
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6); //BA.debugLineNum = 487;BA.debugLine="Log(\"ModSecurity.SaveAttempts erro: \" & LastExce";
anywheresoftware.b4a.keywords.Common.LogImpl("544564486","ModSecurity.SaveAttempts erro: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 489;BA.debugLine="End Sub";
return "";
}
public static String  _saveclipboardtimeout(anywheresoftware.b4a.BA _ba,int _seconds) throws Exception{
 //BA.debugLineNum = 627;BA.debugLine="Public Sub SaveClipboardTimeout(seconds As Int)";
 //BA.debugLineNum = 628;BA.debugLine="If seconds < 10 Then seconds = 10";
if (_seconds<10) { 
_seconds = (int) (10);};
 //BA.debugLineNum = 629;BA.debugLine="If seconds > 120 Then seconds = 120";
if (_seconds>120) { 
_seconds = (int) (120);};
 //BA.debugLineNum = 630;BA.debugLine="SetSetting(\"clipboardTimeout\", seconds)";
_setsetting(_ba,"clipboardTimeout",(Object)(_seconds));
 //BA.debugLineNum = 631;BA.debugLine="End Sub";
return "";
}
public static String  _savelanguage(anywheresoftware.b4a.BA _ba,String _langcode) throws Exception{
 //BA.debugLineNum = 581;BA.debugLine="Public Sub SaveLanguage(langCode As String)";
 //BA.debugLineNum = 582;BA.debugLine="SetSetting(\"language\", langCode)";
_setsetting(_ba,"language",(Object)(_langcode));
 //BA.debugLineNum = 583;BA.debugLine="End Sub";
return "";
}
public static String  _savepin(anywheresoftware.b4a.BA _ba,String _pin) throws Exception{
anywheresoftware.b4a.objects.StringUtils _su = null;
byte[] _data = null;
String _encoded = "";
 //BA.debugLineNum = 499;BA.debugLine="Public Sub SavePIN(pin As String)";
 //BA.debugLineNum = 500;BA.debugLine="Dim su As StringUtils";
_su = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 501;BA.debugLine="Dim data() As Byte = pin.GetBytes(\"UTF8\")";
_data = _pin.getBytes("UTF8");
 //BA.debugLineNum = 502;BA.debugLine="Dim encoded As String = su.EncodeBase64(data)";
_encoded = _su.EncodeBase64(_data);
 //BA.debugLineNum = 503;BA.debugLine="File.WriteString(File.DirInternal, PIN_FILE, enco";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_pin_file,_encoded);
 //BA.debugLineNum = 504;BA.debugLine="End Sub";
return "";
}
public static String  _savesessiontimeout(anywheresoftware.b4a.BA _ba,int _seconds) throws Exception{
 //BA.debugLineNum = 613;BA.debugLine="Public Sub SaveSessionTimeout(seconds As Int)";
 //BA.debugLineNum = 614;BA.debugLine="If seconds < 30 Then seconds = 30";
if (_seconds<30) { 
_seconds = (int) (30);};
 //BA.debugLineNum = 615;BA.debugLine="If seconds > 1800 Then seconds = 1800";
if (_seconds>1800) { 
_seconds = (int) (1800);};
 //BA.debugLineNum = 616;BA.debugLine="SetSetting(\"sessionTimeout\", seconds)";
_setsetting(_ba,"sessionTimeout",(Object)(_seconds));
 //BA.debugLineNum = 617;BA.debugLine="End Sub";
return "";
}
public static String  _savesettings(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.Map _settings) throws Exception{
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _gen = null;
 //BA.debugLineNum = 548;BA.debugLine="Public Sub SaveSettings(settings As Map)";
 //BA.debugLineNum = 549;BA.debugLine="Dim gen As JSONGenerator";
_gen = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 550;BA.debugLine="gen.Initialize(settings)";
_gen.Initialize(_settings);
 //BA.debugLineNum = 551;BA.debugLine="File.WriteString(File.DirInternal, SETTINGS_FILE,";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settings_file,_gen.ToString());
 //BA.debugLineNum = 552;BA.debugLine="End Sub";
return "";
}
public static String  _savetheme(anywheresoftware.b4a.BA _ba,int _themeindex) throws Exception{
 //BA.debugLineNum = 601;BA.debugLine="Public Sub SaveTheme(themeIndex As Int)";
 //BA.debugLineNum = 602;BA.debugLine="SetSetting(\"theme\", themeIndex)";
_setsetting(_ba,"theme",(Object)(_themeindex));
 //BA.debugLineNum = 603;BA.debugLine="End Sub";
return "";
}
public static String  _setlanguagechosen(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 593;BA.debugLine="Public Sub SetLanguageChosen";
 //BA.debugLineNum = 594;BA.debugLine="SetSetting(\"languageChosen\", True)";
_setsetting(_ba,"languageChosen",(Object)(anywheresoftware.b4a.keywords.Common.True));
 //BA.debugLineNum = 595;BA.debugLine="End Sub";
return "";
}
public static String  _setsetting(anywheresoftware.b4a.BA _ba,String _key,Object _value) throws Exception{
anywheresoftware.b4a.objects.collections.Map _settings = null;
 //BA.debugLineNum = 559;BA.debugLine="Public Sub SetSetting(key As String, value As Obje";
 //BA.debugLineNum = 560;BA.debugLine="Dim settings As Map = LoadSettings";
_settings = new anywheresoftware.b4a.objects.collections.Map();
_settings = _loadsettings(_ba);
 //BA.debugLineNum = 561;BA.debugLine="settings.Put(key, value)";
_settings.Put((Object)(_key),_value);
 //BA.debugLineNum = 562;BA.debugLine="SaveSettings(settings)";
_savesettings(_ba,_settings);
 //BA.debugLineNum = 563;BA.debugLine="End Sub";
return "";
}
public static String  _setusebiometric(anywheresoftware.b4a.BA _ba,boolean _use) throws Exception{
 //BA.debugLineNum = 569;BA.debugLine="Public Sub SetUseBiometric(use As Boolean)";
 //BA.debugLineNum = 570;BA.debugLine="SetSetting(\"useBiometric\", use)";
_setsetting(_ba,"useBiometric",(Object)(_use));
 //BA.debugLineNum = 571;BA.debugLine="End Sub";
return "";
}
public static String  _setusesinglepassphrase(anywheresoftware.b4a.BA _ba,boolean _use) throws Exception{
 //BA.debugLineNum = 643;BA.debugLine="Public Sub SetUseSinglePassphrase(use As Boolean)";
 //BA.debugLineNum = 644;BA.debugLine="SetSetting(\"singlePassphrase\", use)";
_setsetting(_ba,"singlePassphrase",(Object)(_use));
 //BA.debugLineNum = 645;BA.debugLine="End Sub";
return "";
}
public static boolean  _shouldwipegroup(anywheresoftware.b4a.BA _ba,String _groupid,int _maxattempts) throws Exception{
 //BA.debugLineNum = 458;BA.debugLine="Public Sub ShouldWipeGroup(groupId As String, maxA";
 //BA.debugLineNum = 459;BA.debugLine="If maxAttempts <= 0 Then Return False";
if (_maxattempts<=0) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 460;BA.debugLine="Return GetFailedAttempts(groupId) >= maxAttempts";
if (true) return _getfailedattempts(_ba,_groupid)>=_maxattempts;
 //BA.debugLineNum = 461;BA.debugLine="End Sub";
return false;
}
public static String  _strreverse(anywheresoftware.b4a.BA _ba,String _s) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
int _i = 0;
 //BA.debugLineNum = 655;BA.debugLine="Private Sub StrReverse(s As String) As String";
 //BA.debugLineNum = 656;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 657;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 658;BA.debugLine="For i = s.Length - 1 To 0 Step -1";
{
final int step3 = -1;
final int limit3 = (int) (0);
_i = (int) (_s.length()-1) ;
for (;_i >= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 659;BA.debugLine="sb.Append(s.CharAt(i))";
_sb.Append(BA.ObjectToString(_s.charAt(_i)));
 }
};
 //BA.debugLineNum = 661;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
 //BA.debugLineNum = 662;BA.debugLine="End Sub";
return "";
}
public static boolean  _validatepassphrasestrength(anywheresoftware.b4a.BA _ba,String _phrase) throws Exception{
String _cleaned = "";
String _unique = "";
 //BA.debugLineNum = 65;BA.debugLine="Public Sub ValidatePassphraseStrength(phrase As St";
 //BA.debugLineNum = 66;BA.debugLine="Dim cleaned As String = RemoveAccents(phrase.Repl";
_cleaned = _removeaccents(_ba,_phrase.replace(" ","").toLowerCase());
 //BA.debugLineNum = 67;BA.debugLine="Dim unique As String = GetUniqueChars(cleaned, 10";
_unique = _getuniquechars(_ba,_cleaned,(int) (10));
 //BA.debugLineNum = 68;BA.debugLine="Return unique.Length >= 10";
if (true) return _unique.length()>=10;
 //BA.debugLineNum = 69;BA.debugLine="End Sub";
return false;
}
public static boolean  _validatepin(anywheresoftware.b4a.BA _ba,String _inputpin) throws Exception{
String _encoded = "";
anywheresoftware.b4a.objects.StringUtils _su = null;
byte[] _data = null;
String _savedpin = "";
 //BA.debugLineNum = 506;BA.debugLine="Public Sub ValidatePIN(inputPin As String) As Bool";
 //BA.debugLineNum = 507;BA.debugLine="If HasPIN = False Then Return False";
if (_haspin(_ba)==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 509;BA.debugLine="Try";
try { //BA.debugLineNum = 510;BA.debugLine="Dim encoded As String = File.ReadString(File.Dir";
_encoded = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_pin_file);
 //BA.debugLineNum = 511;BA.debugLine="Dim su As StringUtils";
_su = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 512;BA.debugLine="Dim data() As Byte = su.DecodeBase64(encoded)";
_data = _su.DecodeBase64(_encoded);
 //BA.debugLineNum = 513;BA.debugLine="Dim savedPin As String = BytesToString(data, 0,";
_savedpin = anywheresoftware.b4a.keywords.Common.BytesToString(_data,(int) (0),_data.length,"UTF8");
 //BA.debugLineNum = 514;BA.debugLine="Return inputPin = savedPin";
if (true) return (_inputpin).equals(_savedpin);
 } 
       catch (Exception e9) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e9); //BA.debugLineNum = 516;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 518;BA.debugLine="End Sub";
return false;
}
}
