package com.lockzero;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class clspasswordgroup extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.lockzero.clspasswordgroup");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.lockzero.clspasswordgroup.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _id = "";
public String _name = "";
public String _icon = "";
public int _color = 0;
public String _protectiontype = "";
public String _salt = "";
public String _testvalue = "";
public long _createdat = 0L;
public long _updatedat = 0L;
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
public com.lockzero.modtransition _modtransition = null;
public com.lockzero.b4xpages _b4xpages = null;
public com.lockzero.b4xcollections _b4xcollections = null;
public com.lockzero.xuiviewsutils _xuiviewsutils = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 4;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Public Id As String";
_id = "";
 //BA.debugLineNum = 6;BA.debugLine="Public Name As String              'Ex: \"Bancos\",";
_name = "";
 //BA.debugLineNum = 7;BA.debugLine="Public Icon As String              'Emoji ou icon";
_icon = "";
 //BA.debugLineNum = 8;BA.debugLine="Public Color As Int                'Cor do grupo";
_color = 0;
 //BA.debugLineNum = 9;BA.debugLine="Public ProtectionType As String    '\"PHRASE\" ou \"";
_protectiontype = "";
 //BA.debugLineNum = 10;BA.debugLine="Public Salt As String              'Salt aleatori";
_salt = "";
 //BA.debugLineNum = 11;BA.debugLine="Public TestValue As String         '\"LOCKZERO\" cr";
_testvalue = "";
 //BA.debugLineNum = 12;BA.debugLine="Public CreatedAt As Long";
_createdat = 0L;
 //BA.debugLineNum = 13;BA.debugLine="Public UpdatedAt As Long";
_updatedat = 0L;
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return "";
}
public com.lockzero.clspasswordgroup  _clone() throws Exception{
com.lockzero.clspasswordgroup _g = null;
 //BA.debugLineNum = 54;BA.debugLine="Public Sub Clone As clsPasswordGroup";
 //BA.debugLineNum = 55;BA.debugLine="Dim g As clsPasswordGroup";
_g = new com.lockzero.clspasswordgroup();
 //BA.debugLineNum = 56;BA.debugLine="g.Initialize";
_g._initialize /*String*/ (ba);
 //BA.debugLineNum = 57;BA.debugLine="g.Id = Id";
_g._id /*String*/  = _id;
 //BA.debugLineNum = 58;BA.debugLine="g.Name = Name";
_g._name /*String*/  = _name;
 //BA.debugLineNum = 59;BA.debugLine="g.Icon = Icon";
_g._icon /*String*/  = _icon;
 //BA.debugLineNum = 60;BA.debugLine="g.Color = Color";
_g._color /*int*/  = _color;
 //BA.debugLineNum = 61;BA.debugLine="g.CreatedAt = CreatedAt";
_g._createdat /*long*/  = _createdat;
 //BA.debugLineNum = 62;BA.debugLine="g.UpdatedAt = UpdatedAt";
_g._updatedat /*long*/  = _updatedat;
 //BA.debugLineNum = 63;BA.debugLine="Return g";
if (true) return _g;
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return null;
}
public String  _createtestvalue(String _phrase) throws Exception{
String _normalizedphrase = "";
 //BA.debugLineNum = 35;BA.debugLine="Public Sub CreateTestValue(phrase As String)";
 //BA.debugLineNum = 36;BA.debugLine="Dim normalizedPhrase As String = ModSecurity.Norm";
_normalizedphrase = _modsecurity._normalizepassphrase /*String*/ (getActivityBA(),_phrase);
 //BA.debugLineNum = 37;BA.debugLine="TestValue = ModSecurity.EncryptWithSalt(normalize";
_testvalue = _modsecurity._encryptwithsalt /*String*/ (getActivityBA(),_normalizedphrase,_salt,"LOCKZERO");
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public String  _frommap(anywheresoftware.b4a.objects.collections.Map _m) throws Exception{
 //BA.debugLineNum = 83;BA.debugLine="Public Sub FromMap(m As Map)";
 //BA.debugLineNum = 84;BA.debugLine="Id = m.GetDefault(\"id\", \"\")";
_id = BA.ObjectToString(_m.GetDefault((Object)("id"),(Object)("")));
 //BA.debugLineNum = 85;BA.debugLine="Name = m.GetDefault(\"name\", \"\")";
_name = BA.ObjectToString(_m.GetDefault((Object)("name"),(Object)("")));
 //BA.debugLineNum = 86;BA.debugLine="Icon = m.GetDefault(\"icon\", \"key\")";
_icon = BA.ObjectToString(_m.GetDefault((Object)("icon"),(Object)("key")));
 //BA.debugLineNum = 87;BA.debugLine="Color = m.GetDefault(\"color\", 0)";
_color = (int)(BA.ObjectToNumber(_m.GetDefault((Object)("color"),(Object)(0))));
 //BA.debugLineNum = 88;BA.debugLine="ProtectionType = m.GetDefault(\"protectionType\", \"";
_protectiontype = BA.ObjectToString(_m.GetDefault((Object)("protectionType"),(Object)("PHRASE")));
 //BA.debugLineNum = 89;BA.debugLine="Salt = m.GetDefault(\"salt\", \"\")";
_salt = BA.ObjectToString(_m.GetDefault((Object)("salt"),(Object)("")));
 //BA.debugLineNum = 90;BA.debugLine="TestValue = m.GetDefault(\"testValue\", \"\")";
_testvalue = BA.ObjectToString(_m.GetDefault((Object)("testValue"),(Object)("")));
 //BA.debugLineNum = 91;BA.debugLine="CreatedAt = m.GetDefault(\"createdAt\", DateTime.No";
_createdat = BA.ObjectToLongNumber(_m.GetDefault((Object)("createdAt"),(Object)(__c.DateTime.getNow())));
 //BA.debugLineNum = 92;BA.debugLine="UpdatedAt = m.GetDefault(\"updatedAt\", DateTime.No";
_updatedat = BA.ObjectToLongNumber(_m.GetDefault((Object)("updatedAt"),(Object)(__c.DateTime.getNow())));
 //BA.debugLineNum = 93;BA.debugLine="End Sub";
return "";
}
public String  _generatesalt() throws Exception{
 //BA.debugLineNum = 29;BA.debugLine="Public Sub GenerateSalt";
 //BA.debugLineNum = 30;BA.debugLine="Salt = ModSecurity.GenerateRandomSalt";
_salt = _modsecurity._generaterandomsalt /*String*/ (getActivityBA());
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return "";
}
public String  _getprotectiontext() throws Exception{
 //BA.debugLineNum = 106;BA.debugLine="Public Sub GetProtectionText As String";
 //BA.debugLineNum = 107;BA.debugLine="If ProtectionType = \"PIN\" Then";
if ((_protectiontype).equals("PIN")) { 
 //BA.debugLineNum = 108;BA.debugLine="Return \"PIN\"";
if (true) return "PIN";
 }else {
 //BA.debugLineNum = 110;BA.debugLine="Return \"Frase\"";
if (true) return "Frase";
 };
 //BA.debugLineNum = 112;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 16;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 17;BA.debugLine="Id = \"\"";
_id = "";
 //BA.debugLineNum = 18;BA.debugLine="Name = \"\"";
_name = "";
 //BA.debugLineNum = 19;BA.debugLine="Icon = \"key\"  'Padrao";
_icon = "key";
 //BA.debugLineNum = 20;BA.debugLine="Color = 0";
_color = (int) (0);
 //BA.debugLineNum = 21;BA.debugLine="ProtectionType = \"PHRASE\"  'Padrao: frase";
_protectiontype = "PHRASE";
 //BA.debugLineNum = 22;BA.debugLine="Salt = \"\"  'Gerado na criacao";
_salt = "";
 //BA.debugLineNum = 23;BA.debugLine="TestValue = \"\"  'Gerado na criacao com a frase";
_testvalue = "";
 //BA.debugLineNum = 24;BA.debugLine="CreatedAt = DateTime.Now";
_createdat = __c.DateTime.getNow();
 //BA.debugLineNum = 25;BA.debugLine="UpdatedAt = DateTime.Now";
_updatedat = __c.DateTime.getNow();
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return "";
}
public boolean  _isinitialized() throws Exception{
 //BA.debugLineNum = 49;BA.debugLine="Public Sub IsInitialized As Boolean";
 //BA.debugLineNum = 50;BA.debugLine="Return Id <> \"\"";
if (true) return (_id).equals("") == false;
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return false;
}
public anywheresoftware.b4a.objects.collections.Map  _tomap() throws Exception{
anywheresoftware.b4a.objects.collections.Map _m = null;
 //BA.debugLineNum = 67;BA.debugLine="Public Sub ToMap As Map";
 //BA.debugLineNum = 68;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 69;BA.debugLine="m.Initialize";
_m.Initialize();
 //BA.debugLineNum = 70;BA.debugLine="m.Put(\"id\", Id)";
_m.Put((Object)("id"),(Object)(_id));
 //BA.debugLineNum = 71;BA.debugLine="m.Put(\"name\", Name)";
_m.Put((Object)("name"),(Object)(_name));
 //BA.debugLineNum = 72;BA.debugLine="m.Put(\"icon\", Icon)";
_m.Put((Object)("icon"),(Object)(_icon));
 //BA.debugLineNum = 73;BA.debugLine="m.Put(\"color\", Color)";
_m.Put((Object)("color"),(Object)(_color));
 //BA.debugLineNum = 74;BA.debugLine="m.Put(\"protectionType\", ProtectionType)";
_m.Put((Object)("protectionType"),(Object)(_protectiontype));
 //BA.debugLineNum = 75;BA.debugLine="m.Put(\"salt\", Salt)";
_m.Put((Object)("salt"),(Object)(_salt));
 //BA.debugLineNum = 76;BA.debugLine="m.Put(\"testValue\", TestValue)";
_m.Put((Object)("testValue"),(Object)(_testvalue));
 //BA.debugLineNum = 77;BA.debugLine="m.Put(\"createdAt\", CreatedAt)";
_m.Put((Object)("createdAt"),(Object)(_createdat));
 //BA.debugLineNum = 78;BA.debugLine="m.Put(\"updatedAt\", UpdatedAt)";
_m.Put((Object)("updatedAt"),(Object)(_updatedat));
 //BA.debugLineNum = 79;BA.debugLine="Return m";
if (true) return _m;
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return null;
}
public boolean  _usesphrase() throws Exception{
 //BA.debugLineNum = 96;BA.debugLine="Public Sub UsesPhrase As Boolean";
 //BA.debugLineNum = 97;BA.debugLine="Return ProtectionType = \"PHRASE\"";
if (true) return (_protectiontype).equals("PHRASE");
 //BA.debugLineNum = 98;BA.debugLine="End Sub";
return false;
}
public boolean  _usespin() throws Exception{
 //BA.debugLineNum = 101;BA.debugLine="Public Sub UsesPin As Boolean";
 //BA.debugLineNum = 102;BA.debugLine="Return ProtectionType = \"PIN\"";
if (true) return (_protectiontype).equals("PIN");
 //BA.debugLineNum = 103;BA.debugLine="End Sub";
return false;
}
public boolean  _validatephrase(String _phrase) throws Exception{
String _normalizedphrase = "";
String _decrypted = "";
 //BA.debugLineNum = 42;BA.debugLine="Public Sub ValidatePhrase(phrase As String) As Boo";
 //BA.debugLineNum = 43;BA.debugLine="If TestValue = \"\" Or Salt = \"\" Then Return False";
if ((_testvalue).equals("") || (_salt).equals("")) { 
if (true) return __c.False;};
 //BA.debugLineNum = 44;BA.debugLine="Dim normalizedPhrase As String = ModSecurity.Norm";
_normalizedphrase = _modsecurity._normalizepassphrase /*String*/ (getActivityBA(),_phrase);
 //BA.debugLineNum = 45;BA.debugLine="Dim decrypted As String = ModSecurity.DecryptWith";
_decrypted = _modsecurity._decryptwithsalt /*String*/ (getActivityBA(),_normalizedphrase,_salt,_testvalue);
 //BA.debugLineNum = 46;BA.debugLine="Return decrypted = \"LOCKZERO\"";
if (true) return (_decrypted).equals("LOCKZERO");
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
return false;
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
