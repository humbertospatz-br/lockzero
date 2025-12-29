package com.lockzero;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class clsnoteentry extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.lockzero.clsnoteentry");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.lockzero.clsnoteentry.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _id = "";
public String _title = "";
public String _content = "";
public String _groupid = "";
public boolean _isfavorite = false;
public int _color = 0;
public long _createdat = 0L;
public long _updatedat = 0L;
public b4a.example.dateutils _dateutils = null;
public com.lockzero.main _main = null;
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
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 4;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Public Id As String";
_id = "";
 //BA.debugLineNum = 6;BA.debugLine="Public Title As String         'Titulo da nota (c";
_title = "";
 //BA.debugLineNum = 7;BA.debugLine="Public Content As String       'Conteudo da nota";
_content = "";
 //BA.debugLineNum = 8;BA.debugLine="Public GroupId As String       'Grupo ao qual per";
_groupid = "";
 //BA.debugLineNum = 9;BA.debugLine="Public IsFavorite As Boolean   'Marcado como favo";
_isfavorite = false;
 //BA.debugLineNum = 10;BA.debugLine="Public Color As Int            'Cor da nota (opci";
_color = 0;
 //BA.debugLineNum = 11;BA.debugLine="Public CreatedAt As Long";
_createdat = 0L;
 //BA.debugLineNum = 12;BA.debugLine="Public UpdatedAt As Long";
_updatedat = 0L;
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return "";
}
public String  _encryptcontent(String _passphrase,String _plaincontent) throws Exception{
 //BA.debugLineNum = 76;BA.debugLine="Public Sub EncryptContent(passPhrase As String, pl";
 //BA.debugLineNum = 77;BA.debugLine="Content = ModSecurity.Encrypt(passPhrase, plainCo";
_content = _modsecurity._encrypt /*String*/ (getActivityBA(),_passphrase,_plaincontent);
 //BA.debugLineNum = 78;BA.debugLine="UpdatedAt = DateTime.Now";
_updatedat = __c.DateTime.getNow();
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
return "";
}
public String  _encrypttitle(String _passphrase,String _plaintitle) throws Exception{
 //BA.debugLineNum = 70;BA.debugLine="Public Sub EncryptTitle(passPhrase As String, plai";
 //BA.debugLineNum = 71;BA.debugLine="Title = ModSecurity.Encrypt(passPhrase, plainTitl";
_title = _modsecurity._encrypt /*String*/ (getActivityBA(),_passphrase,_plaintitle);
 //BA.debugLineNum = 72;BA.debugLine="UpdatedAt = DateTime.Now";
_updatedat = __c.DateTime.getNow();
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return "";
}
public String  _frommap(anywheresoftware.b4a.objects.collections.Map _m) throws Exception{
 //BA.debugLineNum = 42;BA.debugLine="Public Sub FromMap(m As Map)";
 //BA.debugLineNum = 43;BA.debugLine="Id = m.GetDefault(\"id\", \"\")";
_id = BA.ObjectToString(_m.GetDefault((Object)("id"),(Object)("")));
 //BA.debugLineNum = 44;BA.debugLine="Title = m.GetDefault(\"title\", \"\")";
_title = BA.ObjectToString(_m.GetDefault((Object)("title"),(Object)("")));
 //BA.debugLineNum = 45;BA.debugLine="Content = m.GetDefault(\"content\", \"\")";
_content = BA.ObjectToString(_m.GetDefault((Object)("content"),(Object)("")));
 //BA.debugLineNum = 46;BA.debugLine="GroupId = m.GetDefault(\"groupId\", \"\")";
_groupid = BA.ObjectToString(_m.GetDefault((Object)("groupId"),(Object)("")));
 //BA.debugLineNum = 47;BA.debugLine="IsFavorite = m.GetDefault(\"isFavorite\", False)";
_isfavorite = BA.ObjectToBoolean(_m.GetDefault((Object)("isFavorite"),(Object)(__c.False)));
 //BA.debugLineNum = 48;BA.debugLine="Color = m.GetDefault(\"color\", 0)";
_color = (int)(BA.ObjectToNumber(_m.GetDefault((Object)("color"),(Object)(0))));
 //BA.debugLineNum = 49;BA.debugLine="CreatedAt = m.GetDefault(\"createdAt\", DateTime.No";
_createdat = BA.ObjectToLongNumber(_m.GetDefault((Object)("createdAt"),(Object)(__c.DateTime.getNow())));
 //BA.debugLineNum = 50;BA.debugLine="UpdatedAt = m.GetDefault(\"updatedAt\", DateTime.No";
_updatedat = BA.ObjectToLongNumber(_m.GetDefault((Object)("updatedAt"),(Object)(__c.DateTime.getNow())));
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return "";
}
public String  _getdecryptedcontent(String _passphrase) throws Exception{
 //BA.debugLineNum = 62;BA.debugLine="Public Sub GetDecryptedContent(passPhrase As Strin";
 //BA.debugLineNum = 63;BA.debugLine="If ModSecurity.IsEncrypted(Content) Then";
if (_modsecurity._isencrypted /*boolean*/ (getActivityBA(),_content)) { 
 //BA.debugLineNum = 64;BA.debugLine="Return ModSecurity.Decrypt(passPhrase, Content)";
if (true) return _modsecurity._decrypt /*String*/ (getActivityBA(),_passphrase,_content);
 };
 //BA.debugLineNum = 66;BA.debugLine="Return Content";
if (true) return _content;
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public String  _getdecryptedtitle(String _passphrase) throws Exception{
 //BA.debugLineNum = 54;BA.debugLine="Public Sub GetDecryptedTitle(passPhrase As String)";
 //BA.debugLineNum = 55;BA.debugLine="If ModSecurity.IsEncrypted(Title) Then";
if (_modsecurity._isencrypted /*boolean*/ (getActivityBA(),_title)) { 
 //BA.debugLineNum = 56;BA.debugLine="Return ModSecurity.Decrypt(passPhrase, Title)";
if (true) return _modsecurity._decrypt /*String*/ (getActivityBA(),_passphrase,_title);
 };
 //BA.debugLineNum = 58;BA.debugLine="Return Title";
if (true) return _title;
 //BA.debugLineNum = 59;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 15;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 16;BA.debugLine="Id = \"\"";
_id = "";
 //BA.debugLineNum = 17;BA.debugLine="Title = \"\"";
_title = "";
 //BA.debugLineNum = 18;BA.debugLine="Content = \"\"";
_content = "";
 //BA.debugLineNum = 19;BA.debugLine="GroupId = \"\"";
_groupid = "";
 //BA.debugLineNum = 20;BA.debugLine="IsFavorite = False";
_isfavorite = __c.False;
 //BA.debugLineNum = 21;BA.debugLine="Color = 0";
_color = (int) (0);
 //BA.debugLineNum = 22;BA.debugLine="CreatedAt = DateTime.Now";
_createdat = __c.DateTime.getNow();
 //BA.debugLineNum = 23;BA.debugLine="UpdatedAt = DateTime.Now";
_updatedat = __c.DateTime.getNow();
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.collections.Map  _tomap() throws Exception{
anywheresoftware.b4a.objects.collections.Map _m = null;
 //BA.debugLineNum = 27;BA.debugLine="Public Sub ToMap As Map";
 //BA.debugLineNum = 28;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 29;BA.debugLine="m.Initialize";
_m.Initialize();
 //BA.debugLineNum = 30;BA.debugLine="m.Put(\"id\", Id)";
_m.Put((Object)("id"),(Object)(_id));
 //BA.debugLineNum = 31;BA.debugLine="m.Put(\"title\", Title)";
_m.Put((Object)("title"),(Object)(_title));
 //BA.debugLineNum = 32;BA.debugLine="m.Put(\"content\", Content)";
_m.Put((Object)("content"),(Object)(_content));
 //BA.debugLineNum = 33;BA.debugLine="m.Put(\"groupId\", GroupId)";
_m.Put((Object)("groupId"),(Object)(_groupid));
 //BA.debugLineNum = 34;BA.debugLine="m.Put(\"isFavorite\", IsFavorite)";
_m.Put((Object)("isFavorite"),(Object)(_isfavorite));
 //BA.debugLineNum = 35;BA.debugLine="m.Put(\"color\", Color)";
_m.Put((Object)("color"),(Object)(_color));
 //BA.debugLineNum = 36;BA.debugLine="m.Put(\"createdAt\", CreatedAt)";
_m.Put((Object)("createdAt"),(Object)(_createdat));
 //BA.debugLineNum = 37;BA.debugLine="m.Put(\"updatedAt\", UpdatedAt)";
_m.Put((Object)("updatedAt"),(Object)(_updatedat));
 //BA.debugLineNum = 38;BA.debugLine="Return m";
if (true) return _m;
 //BA.debugLineNum = 39;BA.debugLine="End Sub";
return null;
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
