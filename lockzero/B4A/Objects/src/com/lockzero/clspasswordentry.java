package com.lockzero;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class clspasswordentry extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.lockzero.clspasswordentry");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.lockzero.clspasswordentry.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _id = "";
public String _groupid = "";
public String _name = "";
public String _url = "";
public String _username = "";
public String _passwordenc = "";
public String _notes = "";
public boolean _isfavorite = false;
public long _lastused = 0L;
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
 //BA.debugLineNum = 6;BA.debugLine="Public GroupId As String           'ID do grupo a";
_groupid = "";
 //BA.debugLineNum = 7;BA.debugLine="Public Name As String              'Nome amigavel";
_name = "";
 //BA.debugLineNum = 8;BA.debugLine="Public Url As String               'URL do site (";
_url = "";
 //BA.debugLineNum = 9;BA.debugLine="Public Username As String          'Usuario ou em";
_username = "";
 //BA.debugLineNum = 10;BA.debugLine="Public PasswordEnc As String       'Senha (CRIPTO";
_passwordenc = "";
 //BA.debugLineNum = 11;BA.debugLine="Public Notes As String             'Anotacoes opc";
_notes = "";
 //BA.debugLineNum = 12;BA.debugLine="Public IsFavorite As Boolean       'Marcado como";
_isfavorite = false;
 //BA.debugLineNum = 13;BA.debugLine="Public LastUsed As Long            'Ultima vez qu";
_lastused = 0L;
 //BA.debugLineNum = 14;BA.debugLine="Public CreatedAt As Long";
_createdat = 0L;
 //BA.debugLineNum = 15;BA.debugLine="Public UpdatedAt As Long";
_updatedat = 0L;
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return "";
}
public com.lockzero.clspasswordentry  _clone() throws Exception{
com.lockzero.clspasswordentry _e = null;
 //BA.debugLineNum = 37;BA.debugLine="Public Sub Clone As clsPasswordEntry";
 //BA.debugLineNum = 38;BA.debugLine="Dim e As clsPasswordEntry";
_e = new com.lockzero.clspasswordentry();
 //BA.debugLineNum = 39;BA.debugLine="e.Initialize";
_e._initialize /*String*/ (ba);
 //BA.debugLineNum = 40;BA.debugLine="e.Id = Id";
_e._id /*String*/  = _id;
 //BA.debugLineNum = 41;BA.debugLine="e.GroupId = GroupId";
_e._groupid /*String*/  = _groupid;
 //BA.debugLineNum = 42;BA.debugLine="e.Name = Name";
_e._name /*String*/  = _name;
 //BA.debugLineNum = 43;BA.debugLine="e.Url = Url";
_e._url /*String*/  = _url;
 //BA.debugLineNum = 44;BA.debugLine="e.Username = Username";
_e._username /*String*/  = _username;
 //BA.debugLineNum = 45;BA.debugLine="e.PasswordEnc = PasswordEnc";
_e._passwordenc /*String*/  = _passwordenc;
 //BA.debugLineNum = 46;BA.debugLine="e.Notes = Notes";
_e._notes /*String*/  = _notes;
 //BA.debugLineNum = 47;BA.debugLine="e.IsFavorite = IsFavorite";
_e._isfavorite /*boolean*/  = _isfavorite;
 //BA.debugLineNum = 48;BA.debugLine="e.LastUsed = LastUsed";
_e._lastused /*long*/  = _lastused;
 //BA.debugLineNum = 49;BA.debugLine="e.CreatedAt = CreatedAt";
_e._createdat /*long*/  = _createdat;
 //BA.debugLineNum = 50;BA.debugLine="e.UpdatedAt = UpdatedAt";
_e._updatedat /*long*/  = _updatedat;
 //BA.debugLineNum = 51;BA.debugLine="Return e";
if (true) return _e;
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return null;
}
public String  _frommap(anywheresoftware.b4a.objects.collections.Map _m) throws Exception{
 //BA.debugLineNum = 73;BA.debugLine="Public Sub FromMap(m As Map)";
 //BA.debugLineNum = 74;BA.debugLine="Id = m.GetDefault(\"id\", \"\")";
_id = BA.ObjectToString(_m.GetDefault((Object)("id"),(Object)("")));
 //BA.debugLineNum = 75;BA.debugLine="GroupId = m.GetDefault(\"groupId\", \"\")";
_groupid = BA.ObjectToString(_m.GetDefault((Object)("groupId"),(Object)("")));
 //BA.debugLineNum = 76;BA.debugLine="Name = m.GetDefault(\"name\", \"\")";
_name = BA.ObjectToString(_m.GetDefault((Object)("name"),(Object)("")));
 //BA.debugLineNum = 77;BA.debugLine="Url = m.GetDefault(\"url\", \"\")";
_url = BA.ObjectToString(_m.GetDefault((Object)("url"),(Object)("")));
 //BA.debugLineNum = 78;BA.debugLine="Username = m.GetDefault(\"username\", \"\")";
_username = BA.ObjectToString(_m.GetDefault((Object)("username"),(Object)("")));
 //BA.debugLineNum = 79;BA.debugLine="PasswordEnc = m.GetDefault(\"passwordEnc\", \"\")";
_passwordenc = BA.ObjectToString(_m.GetDefault((Object)("passwordEnc"),(Object)("")));
 //BA.debugLineNum = 80;BA.debugLine="Notes = m.GetDefault(\"notes\", \"\")";
_notes = BA.ObjectToString(_m.GetDefault((Object)("notes"),(Object)("")));
 //BA.debugLineNum = 81;BA.debugLine="IsFavorite = m.GetDefault(\"isFavorite\", False)";
_isfavorite = BA.ObjectToBoolean(_m.GetDefault((Object)("isFavorite"),(Object)(__c.False)));
 //BA.debugLineNum = 82;BA.debugLine="LastUsed = m.GetDefault(\"lastUsed\", 0)";
_lastused = BA.ObjectToLongNumber(_m.GetDefault((Object)("lastUsed"),(Object)(0)));
 //BA.debugLineNum = 83;BA.debugLine="CreatedAt = m.GetDefault(\"createdAt\", DateTime.No";
_createdat = BA.ObjectToLongNumber(_m.GetDefault((Object)("createdAt"),(Object)(__c.DateTime.getNow())));
 //BA.debugLineNum = 84;BA.debugLine="UpdatedAt = m.GetDefault(\"updatedAt\", DateTime.No";
_updatedat = BA.ObjectToLongNumber(_m.GetDefault((Object)("updatedAt"),(Object)(__c.DateTime.getNow())));
 //BA.debugLineNum = 85;BA.debugLine="End Sub";
return "";
}
public String  _getdisplayname() throws Exception{
 //BA.debugLineNum = 88;BA.debugLine="Public Sub GetDisplayName As String";
 //BA.debugLineNum = 89;BA.debugLine="If Name <> \"\" Then Return Name";
if ((_name).equals("") == false) { 
if (true) return _name;};
 //BA.debugLineNum = 90;BA.debugLine="If Url <> \"\" Then Return Url";
if ((_url).equals("") == false) { 
if (true) return _url;};
 //BA.debugLineNum = 91;BA.debugLine="Return \"Sem nome\"";
if (true) return "Sem nome";
 //BA.debugLineNum = 92;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 18;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 19;BA.debugLine="Id = \"\"";
_id = "";
 //BA.debugLineNum = 20;BA.debugLine="GroupId = \"\"";
_groupid = "";
 //BA.debugLineNum = 21;BA.debugLine="Name = \"\"";
_name = "";
 //BA.debugLineNum = 22;BA.debugLine="Url = \"\"";
_url = "";
 //BA.debugLineNum = 23;BA.debugLine="Username = \"\"";
_username = "";
 //BA.debugLineNum = 24;BA.debugLine="PasswordEnc = \"\"";
_passwordenc = "";
 //BA.debugLineNum = 25;BA.debugLine="Notes = \"\"";
_notes = "";
 //BA.debugLineNum = 26;BA.debugLine="IsFavorite = False";
_isfavorite = __c.False;
 //BA.debugLineNum = 27;BA.debugLine="LastUsed = 0";
_lastused = (long) (0);
 //BA.debugLineNum = 28;BA.debugLine="CreatedAt = DateTime.Now";
_createdat = __c.DateTime.getNow();
 //BA.debugLineNum = 29;BA.debugLine="UpdatedAt = DateTime.Now";
_updatedat = __c.DateTime.getNow();
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return "";
}
public boolean  _isinitialized() throws Exception{
 //BA.debugLineNum = 32;BA.debugLine="Public Sub IsInitialized As Boolean";
 //BA.debugLineNum = 33;BA.debugLine="Return Id <> \"\"";
if (true) return (_id).equals("") == false;
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return false;
}
public String  _markasused() throws Exception{
 //BA.debugLineNum = 95;BA.debugLine="Public Sub MarkAsUsed";
 //BA.debugLineNum = 96;BA.debugLine="LastUsed = DateTime.Now";
_lastused = __c.DateTime.getNow();
 //BA.debugLineNum = 97;BA.debugLine="UpdatedAt = DateTime.Now";
_updatedat = __c.DateTime.getNow();
 //BA.debugLineNum = 98;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.collections.Map  _tomap() throws Exception{
anywheresoftware.b4a.objects.collections.Map _m = null;
 //BA.debugLineNum = 55;BA.debugLine="Public Sub ToMap As Map";
 //BA.debugLineNum = 56;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 57;BA.debugLine="m.Initialize";
_m.Initialize();
 //BA.debugLineNum = 58;BA.debugLine="m.Put(\"id\", Id)";
_m.Put((Object)("id"),(Object)(_id));
 //BA.debugLineNum = 59;BA.debugLine="m.Put(\"groupId\", GroupId)";
_m.Put((Object)("groupId"),(Object)(_groupid));
 //BA.debugLineNum = 60;BA.debugLine="m.Put(\"name\", Name)";
_m.Put((Object)("name"),(Object)(_name));
 //BA.debugLineNum = 61;BA.debugLine="m.Put(\"url\", Url)";
_m.Put((Object)("url"),(Object)(_url));
 //BA.debugLineNum = 62;BA.debugLine="m.Put(\"username\", Username)";
_m.Put((Object)("username"),(Object)(_username));
 //BA.debugLineNum = 63;BA.debugLine="m.Put(\"passwordEnc\", PasswordEnc)";
_m.Put((Object)("passwordEnc"),(Object)(_passwordenc));
 //BA.debugLineNum = 64;BA.debugLine="m.Put(\"notes\", Notes)";
_m.Put((Object)("notes"),(Object)(_notes));
 //BA.debugLineNum = 65;BA.debugLine="m.Put(\"isFavorite\", IsFavorite)";
_m.Put((Object)("isFavorite"),(Object)(_isfavorite));
 //BA.debugLineNum = 66;BA.debugLine="m.Put(\"lastUsed\", LastUsed)";
_m.Put((Object)("lastUsed"),(Object)(_lastused));
 //BA.debugLineNum = 67;BA.debugLine="m.Put(\"createdAt\", CreatedAt)";
_m.Put((Object)("createdAt"),(Object)(_createdat));
 //BA.debugLineNum = 68;BA.debugLine="m.Put(\"updatedAt\", UpdatedAt)";
_m.Put((Object)("updatedAt"),(Object)(_updatedat));
 //BA.debugLineNum = 69;BA.debugLine="Return m";
if (true) return _m;
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return null;
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
