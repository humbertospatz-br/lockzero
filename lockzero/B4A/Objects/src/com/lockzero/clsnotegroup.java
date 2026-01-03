package com.lockzero;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class clsnotegroup extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.lockzero.clsnotegroup");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.lockzero.clsnotegroup.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _id = "";
public String _name = "";
public String _icon = "";
public boolean _issecure = false;
public boolean _issystem = false;
public String _templatetype = "";
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
 //BA.debugLineNum = 5;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Public Id As String";
_id = "";
 //BA.debugLineNum = 7;BA.debugLine="Public Name As String              'Ex: \"Compras\"";
_name = "";
 //BA.debugLineNum = 8;BA.debugLine="Public Icon As String              'Emoji escolhi";
_icon = "";
 //BA.debugLineNum = 9;BA.debugLine="Public IsSecure As Boolean         'True = seguro";
_issecure = false;
 //BA.debugLineNum = 10;BA.debugLine="Public IsSystem As Boolean         'True = grupo";
_issystem = false;
 //BA.debugLineNum = 11;BA.debugLine="Public TemplateType As String      '\"\" = normal,";
_templatetype = "";
 //BA.debugLineNum = 12;BA.debugLine="Public Salt As String              'Salt aleatori";
_salt = "";
 //BA.debugLineNum = 13;BA.debugLine="Public TestValue As String         '\"LOCKZERO\" cr";
_testvalue = "";
 //BA.debugLineNum = 14;BA.debugLine="Public CreatedAt As Long";
_createdat = 0L;
 //BA.debugLineNum = 15;BA.debugLine="Public UpdatedAt As Long";
_updatedat = 0L;
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return "";
}
public com.lockzero.clsnotegroup  _clone() throws Exception{
com.lockzero.clsnotegroup _g = null;
 //BA.debugLineNum = 79;BA.debugLine="Public Sub Clone As clsNoteGroup";
 //BA.debugLineNum = 80;BA.debugLine="Dim g As clsNoteGroup";
_g = new com.lockzero.clsnotegroup();
 //BA.debugLineNum = 81;BA.debugLine="g.Initialize";
_g._initialize /*String*/ (ba);
 //BA.debugLineNum = 82;BA.debugLine="g.Id = Id";
_g._id /*String*/  = _id;
 //BA.debugLineNum = 83;BA.debugLine="g.Name = Name";
_g._name /*String*/  = _name;
 //BA.debugLineNum = 84;BA.debugLine="g.Icon = Icon";
_g._icon /*String*/  = _icon;
 //BA.debugLineNum = 85;BA.debugLine="g.IsSecure = IsSecure";
_g._issecure /*boolean*/  = _issecure;
 //BA.debugLineNum = 86;BA.debugLine="g.IsSystem = IsSystem";
_g._issystem /*boolean*/  = _issystem;
 //BA.debugLineNum = 87;BA.debugLine="g.TemplateType = TemplateType";
_g._templatetype /*String*/  = _templatetype;
 //BA.debugLineNum = 88;BA.debugLine="g.Salt = Salt";
_g._salt /*String*/  = _salt;
 //BA.debugLineNum = 89;BA.debugLine="g.TestValue = TestValue";
_g._testvalue /*String*/  = _testvalue;
 //BA.debugLineNum = 90;BA.debugLine="g.CreatedAt = CreatedAt";
_g._createdat /*long*/  = _createdat;
 //BA.debugLineNum = 91;BA.debugLine="g.UpdatedAt = UpdatedAt";
_g._updatedat /*long*/  = _updatedat;
 //BA.debugLineNum = 92;BA.debugLine="Return g";
if (true) return _g;
 //BA.debugLineNum = 93;BA.debugLine="End Sub";
return null;
}
public String  _createtestvalue(String _phrase) throws Exception{
String _normalizedphrase = "";
 //BA.debugLineNum = 40;BA.debugLine="Public Sub CreateTestValue(phrase As String)";
 //BA.debugLineNum = 41;BA.debugLine="If IsSecure = False Then Return";
if (_issecure==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 42;BA.debugLine="Dim normalizedPhrase As String = ModSecurity.Norm";
_normalizedphrase = _modsecurity._normalizepassphrase /*String*/ (getActivityBA(),_phrase);
 //BA.debugLineNum = 43;BA.debugLine="TestValue = ModSecurity.EncryptWithSalt(normalize";
_testvalue = _modsecurity._encryptwithsalt /*String*/ (getActivityBA(),_normalizedphrase,_salt,"LOCKZERO");
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return "";
}
public String  _frommap(anywheresoftware.b4a.objects.collections.Map _m) throws Exception{
 //BA.debugLineNum = 113;BA.debugLine="Public Sub FromMap(m As Map)";
 //BA.debugLineNum = 114;BA.debugLine="Id = m.GetDefault(\"id\", \"\")";
_id = BA.ObjectToString(_m.GetDefault((Object)("id"),(Object)("")));
 //BA.debugLineNum = 115;BA.debugLine="Name = m.GetDefault(\"name\", \"\")";
_name = BA.ObjectToString(_m.GetDefault((Object)("name"),(Object)("")));
 //BA.debugLineNum = 116;BA.debugLine="Icon = m.GetDefault(\"icon\", Chr(0xD83D) & Chr(0xD";
_icon = BA.ObjectToString(_m.GetDefault((Object)("icon"),(Object)(BA.ObjectToString(__c.Chr(((int)0xd83d)))+BA.ObjectToString(__c.Chr(((int)0xdcdd))))));
 //BA.debugLineNum = 118;BA.debugLine="If Icon = \"note\" Or Icon = \"\" Then Icon = Chr(0xD";
if ((_icon).equals("note") || (_icon).equals("")) { 
_icon = BA.ObjectToString(__c.Chr(((int)0xd83d)))+BA.ObjectToString(__c.Chr(((int)0xdcdd)));};
 //BA.debugLineNum = 119;BA.debugLine="IsSecure = m.GetDefault(\"isSecure\", True)";
_issecure = BA.ObjectToBoolean(_m.GetDefault((Object)("isSecure"),(Object)(__c.True)));
 //BA.debugLineNum = 120;BA.debugLine="IsSystem = m.GetDefault(\"isSystem\", False)";
_issystem = BA.ObjectToBoolean(_m.GetDefault((Object)("isSystem"),(Object)(__c.False)));
 //BA.debugLineNum = 121;BA.debugLine="TemplateType = m.GetDefault(\"templateType\", \"\")";
_templatetype = BA.ObjectToString(_m.GetDefault((Object)("templateType"),(Object)("")));
 //BA.debugLineNum = 122;BA.debugLine="Salt = m.GetDefault(\"salt\", \"\")";
_salt = BA.ObjectToString(_m.GetDefault((Object)("salt"),(Object)("")));
 //BA.debugLineNum = 123;BA.debugLine="TestValue = m.GetDefault(\"testValue\", \"\")";
_testvalue = BA.ObjectToString(_m.GetDefault((Object)("testValue"),(Object)("")));
 //BA.debugLineNum = 124;BA.debugLine="CreatedAt = m.GetDefault(\"createdAt\", DateTime.No";
_createdat = BA.ObjectToLongNumber(_m.GetDefault((Object)("createdAt"),(Object)(__c.DateTime.getNow())));
 //BA.debugLineNum = 125;BA.debugLine="UpdatedAt = m.GetDefault(\"updatedAt\", DateTime.No";
_updatedat = BA.ObjectToLongNumber(_m.GetDefault((Object)("updatedAt"),(Object)(__c.DateTime.getNow())));
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public String  _generatesalt() throws Exception{
 //BA.debugLineNum = 32;BA.debugLine="Public Sub GenerateSalt";
 //BA.debugLineNum = 33;BA.debugLine="If IsSecure Then";
if (_issecure) { 
 //BA.debugLineNum = 34;BA.debugLine="Salt = ModSecurity.GenerateRandomSalt";
_salt = _modsecurity._generaterandomsalt /*String*/ (getActivityBA());
 };
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return "";
}
public String  _getlockicon() throws Exception{
 //BA.debugLineNum = 129;BA.debugLine="Public Sub GetLockIcon As String";
 //BA.debugLineNum = 130;BA.debugLine="If IsSecure Then";
if (_issecure) { 
 //BA.debugLineNum = 131;BA.debugLine="Return Chr(0xD83D) & Chr(0xDD12)  'Cadeado fecha";
if (true) return BA.ObjectToString(__c.Chr(((int)0xd83d)))+BA.ObjectToString(__c.Chr(((int)0xdd12)));
 }else {
 //BA.debugLineNum = 133;BA.debugLine="Return \"\"  'Sem cadeado";
if (true) return "";
 };
 //BA.debugLineNum = 135;BA.debugLine="End Sub";
return "";
}
public String  _getprotectiontext() throws Exception{
 //BA.debugLineNum = 138;BA.debugLine="Public Sub GetProtectionText As String";
 //BA.debugLineNum = 139;BA.debugLine="If IsSecure Then";
if (_issecure) { 
 //BA.debugLineNum = 140;BA.debugLine="Return ModLang.T(\"note_group_secure\")";
if (true) return _modlang._t /*String*/ (getActivityBA(),"note_group_secure");
 }else {
 //BA.debugLineNum = 142;BA.debugLine="Return ModLang.T(\"note_group_open\")";
if (true) return _modlang._t /*String*/ (getActivityBA(),"note_group_open");
 };
 //BA.debugLineNum = 144;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 18;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 19;BA.debugLine="Id = \"\"";
_id = "";
 //BA.debugLineNum = 20;BA.debugLine="Name = \"\"";
_name = "";
 //BA.debugLineNum = 21;BA.debugLine="Icon = Chr(0xD83D) & Chr(0xDCDD)  'Padrao: emoji";
_icon = BA.ObjectToString(__c.Chr(((int)0xd83d)))+BA.ObjectToString(__c.Chr(((int)0xdcdd)));
 //BA.debugLineNum = 22;BA.debugLine="IsSecure = True  'Default: grupo seguro";
_issecure = __c.True;
 //BA.debugLineNum = 23;BA.debugLine="IsSystem = False 'Default: grupo normal (pode ser";
_issystem = __c.False;
 //BA.debugLineNum = 24;BA.debugLine="TemplateType = \"\" 'Default: sem template";
_templatetype = "";
 //BA.debugLineNum = 25;BA.debugLine="Salt = \"\"";
_salt = "";
 //BA.debugLineNum = 26;BA.debugLine="TestValue = \"\"";
_testvalue = "";
 //BA.debugLineNum = 27;BA.debugLine="CreatedAt = DateTime.Now";
_createdat = __c.DateTime.getNow();
 //BA.debugLineNum = 28;BA.debugLine="UpdatedAt = DateTime.Now";
_updatedat = __c.DateTime.getNow();
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return "";
}
public boolean  _isinitialized() throws Exception{
 //BA.debugLineNum = 74;BA.debugLine="Public Sub IsInitialized As Boolean";
 //BA.debugLineNum = 75;BA.debugLine="Return Id <> \"\"";
if (true) return (_id).equals("") == false;
 //BA.debugLineNum = 76;BA.debugLine="End Sub";
return false;
}
public boolean  _requiresauth() throws Exception{
 //BA.debugLineNum = 70;BA.debugLine="Public Sub RequiresAuth As Boolean";
 //BA.debugLineNum = 71;BA.debugLine="Return IsSecure";
if (true) return _issecure;
 //BA.debugLineNum = 72;BA.debugLine="End Sub";
return false;
}
public String  _setupsecurity(String _phrase) throws Exception{
 //BA.debugLineNum = 48;BA.debugLine="Public Sub SetupSecurity(phrase As String)";
 //BA.debugLineNum = 49;BA.debugLine="If IsSecure = False Then";
if (_issecure==__c.False) { 
 //BA.debugLineNum = 50;BA.debugLine="Salt = \"\"";
_salt = "";
 //BA.debugLineNum = 51;BA.debugLine="TestValue = \"\"";
_testvalue = "";
 //BA.debugLineNum = 52;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 54;BA.debugLine="GenerateSalt";
_generatesalt();
 //BA.debugLineNum = 55;BA.debugLine="CreateTestValue(phrase)";
_createtestvalue(_phrase);
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.collections.Map  _tomap() throws Exception{
anywheresoftware.b4a.objects.collections.Map _m = null;
 //BA.debugLineNum = 96;BA.debugLine="Public Sub ToMap As Map";
 //BA.debugLineNum = 97;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 98;BA.debugLine="m.Initialize";
_m.Initialize();
 //BA.debugLineNum = 99;BA.debugLine="m.Put(\"id\", Id)";
_m.Put((Object)("id"),(Object)(_id));
 //BA.debugLineNum = 100;BA.debugLine="m.Put(\"name\", Name)";
_m.Put((Object)("name"),(Object)(_name));
 //BA.debugLineNum = 101;BA.debugLine="m.Put(\"icon\", Icon)";
_m.Put((Object)("icon"),(Object)(_icon));
 //BA.debugLineNum = 102;BA.debugLine="m.Put(\"isSecure\", IsSecure)";
_m.Put((Object)("isSecure"),(Object)(_issecure));
 //BA.debugLineNum = 103;BA.debugLine="m.Put(\"isSystem\", IsSystem)";
_m.Put((Object)("isSystem"),(Object)(_issystem));
 //BA.debugLineNum = 104;BA.debugLine="m.Put(\"templateType\", TemplateType)";
_m.Put((Object)("templateType"),(Object)(_templatetype));
 //BA.debugLineNum = 105;BA.debugLine="m.Put(\"salt\", Salt)";
_m.Put((Object)("salt"),(Object)(_salt));
 //BA.debugLineNum = 106;BA.debugLine="m.Put(\"testValue\", TestValue)";
_m.Put((Object)("testValue"),(Object)(_testvalue));
 //BA.debugLineNum = 107;BA.debugLine="m.Put(\"createdAt\", CreatedAt)";
_m.Put((Object)("createdAt"),(Object)(_createdat));
 //BA.debugLineNum = 108;BA.debugLine="m.Put(\"updatedAt\", UpdatedAt)";
_m.Put((Object)("updatedAt"),(Object)(_updatedat));
 //BA.debugLineNum = 109;BA.debugLine="Return m";
if (true) return _m;
 //BA.debugLineNum = 110;BA.debugLine="End Sub";
return null;
}
public boolean  _validatephrase(String _phrase) throws Exception{
String _normalizedphrase = "";
String _decrypted = "";
 //BA.debugLineNum = 61;BA.debugLine="Public Sub ValidatePhrase(phrase As String) As Boo";
 //BA.debugLineNum = 62;BA.debugLine="If IsSecure = False Then Return True  'Grupos abe";
if (_issecure==__c.False) { 
if (true) return __c.True;};
 //BA.debugLineNum = 63;BA.debugLine="If TestValue = \"\" Or Salt = \"\" Then Return False";
if ((_testvalue).equals("") || (_salt).equals("")) { 
if (true) return __c.False;};
 //BA.debugLineNum = 64;BA.debugLine="Dim normalizedPhrase As String = ModSecurity.Norm";
_normalizedphrase = _modsecurity._normalizepassphrase /*String*/ (getActivityBA(),_phrase);
 //BA.debugLineNum = 65;BA.debugLine="Dim decrypted As String = ModSecurity.DecryptWith";
_decrypted = _modsecurity._decryptwithsalt /*String*/ (getActivityBA(),_normalizedphrase,_salt,_testvalue);
 //BA.debugLineNum = 66;BA.debugLine="Return decrypted = \"LOCKZERO\"";
if (true) return (_decrypted).equals("LOCKZERO");
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return false;
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
