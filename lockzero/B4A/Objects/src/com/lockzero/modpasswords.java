package com.lockzero;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class modpasswords {
private static modpasswords mostCurrent = new modpasswords();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public static String _file_name = "";
public static anywheresoftware.b4a.objects.collections.Map _groups = null;
public static anywheresoftware.b4a.objects.collections.Map _entries = null;
public static boolean _isloaded = false;
public b4a.example.dateutils _dateutils = null;
public com.lockzero.main _main = null;
public com.lockzero.starter _starter = null;
public com.lockzero.modbackup _modbackup = null;
public com.lockzero.modlang _modlang = null;
public com.lockzero.modnotes _modnotes = null;
public com.lockzero.modsecurity _modsecurity = null;
public com.lockzero.modsession _modsession = null;
public com.lockzero.modtheme _modtheme = null;
public com.lockzero.b4xpages _b4xpages = null;
public com.lockzero.b4xcollections _b4xcollections = null;
public com.lockzero.xuiviewsutils _xuiviewsutils = null;
public static String  _decryptvalue(anywheresoftware.b4a.BA _ba,String _enctext) throws Exception{
 //BA.debugLineNum = 302;BA.debugLine="Public Sub DecryptValue(encText As String) As Stri";
 //BA.debugLineNum = 303;BA.debugLine="Return ModSession.Decrypt(encText)";
if (true) return mostCurrent._modsession._decrypt /*String*/ (_ba,_enctext);
 //BA.debugLineNum = 304;BA.debugLine="End Sub";
return "";
}
public static String  _deleteentry(anywheresoftware.b4a.BA _ba,String _id) throws Exception{
 //BA.debugLineNum = 219;BA.debugLine="Public Sub DeleteEntry(id As String)";
 //BA.debugLineNum = 220;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 221;BA.debugLine="If Entries.ContainsKey(id) Then";
if (_entries.ContainsKey((Object)(_id))) { 
 //BA.debugLineNum = 222;BA.debugLine="Entries.Remove(id)";
_entries.Remove((Object)(_id));
 //BA.debugLineNum = 223;BA.debugLine="SaveToDisk";
_savetodisk(_ba);
 };
 //BA.debugLineNum = 225;BA.debugLine="End Sub";
return "";
}
public static String  _deletegroup(anywheresoftware.b4a.BA _ba,String _id) throws Exception{
anywheresoftware.b4a.objects.collections.List _toremove = null;
String _k = "";
com.lockzero.clspasswordentry _e = null;
 //BA.debugLineNum = 145;BA.debugLine="Public Sub DeleteGroup(id As String)";
 //BA.debugLineNum = 146;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 147;BA.debugLine="If Groups.ContainsKey(id) Then";
if (_groups.ContainsKey((Object)(_id))) { 
 //BA.debugLineNum = 148;BA.debugLine="Groups.Remove(id)";
_groups.Remove((Object)(_id));
 //BA.debugLineNum = 151;BA.debugLine="Dim toRemove As List";
_toremove = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 152;BA.debugLine="toRemove.Initialize";
_toremove.Initialize();
 //BA.debugLineNum = 153;BA.debugLine="For Each k As String In Entries.Keys";
{
final anywheresoftware.b4a.BA.IterableList group6 = _entries.Keys();
final int groupLen6 = group6.getSize()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_k = BA.ObjectToString(group6.Get(index6));
 //BA.debugLineNum = 154;BA.debugLine="Dim e As clsPasswordEntry = Entries.Get(k)";
_e = (com.lockzero.clspasswordentry)(_entries.Get((Object)(_k)));
 //BA.debugLineNum = 155;BA.debugLine="If e.GroupId = id Then";
if ((_e._groupid /*String*/ ).equals(_id)) { 
 //BA.debugLineNum = 156;BA.debugLine="toRemove.Add(k)";
_toremove.Add((Object)(_k));
 };
 }
};
 //BA.debugLineNum = 159;BA.debugLine="For Each k As String In toRemove";
{
final anywheresoftware.b4a.BA.IterableList group12 = _toremove;
final int groupLen12 = group12.getSize()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_k = BA.ObjectToString(group12.Get(index12));
 //BA.debugLineNum = 160;BA.debugLine="Entries.Remove(k)";
_entries.Remove((Object)(_k));
 }
};
 //BA.debugLineNum = 163;BA.debugLine="SaveToDisk";
_savetodisk(_ba);
 };
 //BA.debugLineNum = 165;BA.debugLine="End Sub";
return "";
}
public static String  _encryptvalue(anywheresoftware.b4a.BA _ba,String _plaintext) throws Exception{
 //BA.debugLineNum = 297;BA.debugLine="Public Sub EncryptValue(plainText As String) As St";
 //BA.debugLineNum = 298;BA.debugLine="Return ModSession.Encrypt(plainText)";
if (true) return mostCurrent._modsession._encrypt /*String*/ (_ba,_plaintext);
 //BA.debugLineNum = 299;BA.debugLine="End Sub";
return "";
}
public static String  _forcereload(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 20;BA.debugLine="Public Sub ForceReload";
 //BA.debugLineNum = 21;BA.debugLine="Groups.Initialize";
_groups.Initialize();
 //BA.debugLineNum = 22;BA.debugLine="Entries.Initialize";
_entries.Initialize();
 //BA.debugLineNum = 23;BA.debugLine="LoadFromDisk";
_loadfromdisk(_ba);
 //BA.debugLineNum = 24;BA.debugLine="IsLoaded = True";
_isloaded = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 26;BA.debugLine="Log(\"ModPasswords: \" & Groups.Size & \" grupos, \"";
anywheresoftware.b4a.keywords.Common.LogImpl("541680902","ModPasswords: "+BA.NumberToString(_groups.getSize())+" grupos, "+BA.NumberToString(_entries.getSize())+" senhas",0);
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _getallentries(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.List _lst = null;
String _k = "";
 //BA.debugLineNum = 189;BA.debugLine="Public Sub GetAllEntries As List";
 //BA.debugLineNum = 190;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 191;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 192;BA.debugLine="lst.Initialize";
_lst.Initialize();
 //BA.debugLineNum = 193;BA.debugLine="For Each k As String In Entries.Keys";
{
final anywheresoftware.b4a.BA.IterableList group4 = _entries.Keys();
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_k = BA.ObjectToString(group4.Get(index4));
 //BA.debugLineNum = 194;BA.debugLine="lst.Add(Entries.Get(k))";
_lst.Add(_entries.Get((Object)(_k)));
 }
};
 //BA.debugLineNum = 196;BA.debugLine="Return lst";
if (true) return _lst;
 //BA.debugLineNum = 197;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _getallgroups(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.List _lst = null;
String _k = "";
 //BA.debugLineNum = 115;BA.debugLine="Public Sub GetAllGroups As List";
 //BA.debugLineNum = 116;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 117;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 118;BA.debugLine="lst.Initialize";
_lst.Initialize();
 //BA.debugLineNum = 119;BA.debugLine="For Each k As String In Groups.Keys";
{
final anywheresoftware.b4a.BA.IterableList group4 = _groups.Keys();
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_k = BA.ObjectToString(group4.Get(index4));
 //BA.debugLineNum = 120;BA.debugLine="lst.Add(Groups.Get(k))";
_lst.Add(_groups.Get((Object)(_k)));
 }
};
 //BA.debugLineNum = 122;BA.debugLine="Return lst";
if (true) return _lst;
 //BA.debugLineNum = 123;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _getentriesbygroup(anywheresoftware.b4a.BA _ba,String _groupid) throws Exception{
anywheresoftware.b4a.objects.collections.List _lst = null;
String _k = "";
com.lockzero.clspasswordentry _e = null;
 //BA.debugLineNum = 176;BA.debugLine="Public Sub GetEntriesByGroup(groupId As String) As";
 //BA.debugLineNum = 177;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 178;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 179;BA.debugLine="lst.Initialize";
_lst.Initialize();
 //BA.debugLineNum = 180;BA.debugLine="For Each k As String In Entries.Keys";
{
final anywheresoftware.b4a.BA.IterableList group4 = _entries.Keys();
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_k = BA.ObjectToString(group4.Get(index4));
 //BA.debugLineNum = 181;BA.debugLine="Dim e As clsPasswordEntry = Entries.Get(k)";
_e = (com.lockzero.clspasswordentry)(_entries.Get((Object)(_k)));
 //BA.debugLineNum = 182;BA.debugLine="If e.GroupId = groupId Then";
if ((_e._groupid /*String*/ ).equals(_groupid)) { 
 //BA.debugLineNum = 183;BA.debugLine="lst.Add(e)";
_lst.Add((Object)(_e));
 };
 }
};
 //BA.debugLineNum = 186;BA.debugLine="Return lst";
if (true) return _lst;
 //BA.debugLineNum = 187;BA.debugLine="End Sub";
return null;
}
public static com.lockzero.clspasswordentry  _getentrybyid(anywheresoftware.b4a.BA _ba,String _id) throws Exception{
com.lockzero.clspasswordentry _empty = null;
 //BA.debugLineNum = 199;BA.debugLine="Public Sub GetEntryById(id As String) As clsPasswo";
 //BA.debugLineNum = 200;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 201;BA.debugLine="If Entries.ContainsKey(id) Then";
if (_entries.ContainsKey((Object)(_id))) { 
 //BA.debugLineNum = 202;BA.debugLine="Return Entries.Get(id)";
if (true) return (com.lockzero.clspasswordentry)(_entries.Get((Object)(_id)));
 };
 //BA.debugLineNum = 204;BA.debugLine="Dim empty As clsPasswordEntry";
_empty = new com.lockzero.clspasswordentry();
 //BA.debugLineNum = 205;BA.debugLine="Return empty";
if (true) return _empty;
 //BA.debugLineNum = 206;BA.debugLine="End Sub";
return null;
}
public static int  _getentrycountbygroup(anywheresoftware.b4a.BA _ba,String _groupid) throws Exception{
int _count = 0;
String _k = "";
com.lockzero.clspasswordentry _e = null;
 //BA.debugLineNum = 227;BA.debugLine="Public Sub GetEntryCountByGroup(groupId As String)";
 //BA.debugLineNum = 228;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 229;BA.debugLine="Dim count As Int = 0";
_count = (int) (0);
 //BA.debugLineNum = 230;BA.debugLine="For Each k As String In Entries.Keys";
{
final anywheresoftware.b4a.BA.IterableList group3 = _entries.Keys();
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_k = BA.ObjectToString(group3.Get(index3));
 //BA.debugLineNum = 231;BA.debugLine="Dim e As clsPasswordEntry = Entries.Get(k)";
_e = (com.lockzero.clspasswordentry)(_entries.Get((Object)(_k)));
 //BA.debugLineNum = 232;BA.debugLine="If e.GroupId = groupId Then";
if ((_e._groupid /*String*/ ).equals(_groupid)) { 
 //BA.debugLineNum = 233;BA.debugLine="count = count + 1";
_count = (int) (_count+1);
 };
 }
};
 //BA.debugLineNum = 236;BA.debugLine="Return count";
if (true) return _count;
 //BA.debugLineNum = 237;BA.debugLine="End Sub";
return 0;
}
public static anywheresoftware.b4a.objects.collections.List  _getfavorites(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.List _lst = null;
String _k = "";
com.lockzero.clspasswordentry _e = null;
 //BA.debugLineNum = 248;BA.debugLine="Public Sub GetFavorites As List";
 //BA.debugLineNum = 249;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 250;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 251;BA.debugLine="lst.Initialize";
_lst.Initialize();
 //BA.debugLineNum = 252;BA.debugLine="For Each k As String In Entries.Keys";
{
final anywheresoftware.b4a.BA.IterableList group4 = _entries.Keys();
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_k = BA.ObjectToString(group4.Get(index4));
 //BA.debugLineNum = 253;BA.debugLine="Dim e As clsPasswordEntry = Entries.Get(k)";
_e = (com.lockzero.clspasswordentry)(_entries.Get((Object)(_k)));
 //BA.debugLineNum = 254;BA.debugLine="If e.IsFavorite Then";
if (_e._isfavorite /*boolean*/ ) { 
 //BA.debugLineNum = 255;BA.debugLine="lst.Add(e)";
_lst.Add((Object)(_e));
 };
 }
};
 //BA.debugLineNum = 258;BA.debugLine="Return lst";
if (true) return _lst;
 //BA.debugLineNum = 259;BA.debugLine="End Sub";
return null;
}
public static com.lockzero.clspasswordgroup  _getgroupbyid(anywheresoftware.b4a.BA _ba,String _id) throws Exception{
com.lockzero.clspasswordgroup _empty = null;
 //BA.debugLineNum = 125;BA.debugLine="Public Sub GetGroupById(id As String) As clsPasswo";
 //BA.debugLineNum = 126;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 127;BA.debugLine="If Groups.ContainsKey(id) Then";
if (_groups.ContainsKey((Object)(_id))) { 
 //BA.debugLineNum = 128;BA.debugLine="Return Groups.Get(id)";
if (true) return (com.lockzero.clspasswordgroup)(_groups.Get((Object)(_id)));
 };
 //BA.debugLineNum = 130;BA.debugLine="Dim empty As clsPasswordGroup";
_empty = new com.lockzero.clspasswordgroup();
 //BA.debugLineNum = 131;BA.debugLine="Return empty";
if (true) return _empty;
 //BA.debugLineNum = 132;BA.debugLine="End Sub";
return null;
}
public static int  _getgroupcount(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 167;BA.debugLine="Public Sub GetGroupCount As Int";
 //BA.debugLineNum = 168;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 169;BA.debugLine="Return Groups.Size";
if (true) return _groups.getSize();
 //BA.debugLineNum = 170;BA.debugLine="End Sub";
return 0;
}
public static anywheresoftware.b4a.objects.collections.Map  _getstats(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.Map _stats = null;
 //BA.debugLineNum = 310;BA.debugLine="Public Sub GetStats As Map";
 //BA.debugLineNum = 311;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 312;BA.debugLine="Dim stats As Map";
_stats = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 313;BA.debugLine="stats.Initialize";
_stats.Initialize();
 //BA.debugLineNum = 314;BA.debugLine="stats.Put(\"groups\", Groups.Size)";
_stats.Put((Object)("groups"),(Object)(_groups.getSize()));
 //BA.debugLineNum = 315;BA.debugLine="stats.Put(\"entries\", Entries.Size)";
_stats.Put((Object)("entries"),(Object)(_entries.getSize()));
 //BA.debugLineNum = 316;BA.debugLine="stats.Put(\"favorites\", GetFavorites.Size)";
_stats.Put((Object)("favorites"),(Object)(_getfavorites(_ba).getSize()));
 //BA.debugLineNum = 317;BA.debugLine="Return stats";
if (true) return _stats;
 //BA.debugLineNum = 318;BA.debugLine="End Sub";
return null;
}
public static int  _gettotalentrycount(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 239;BA.debugLine="Public Sub GetTotalEntryCount As Int";
 //BA.debugLineNum = 240;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 241;BA.debugLine="Return Entries.Size";
if (true) return _entries.getSize();
 //BA.debugLineNum = 242;BA.debugLine="End Sub";
return 0;
}
public static String  _init(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Public Sub Init";
 //BA.debugLineNum = 16;BA.debugLine="If IsLoaded Then Return";
if (_isloaded) { 
if (true) return "";};
 //BA.debugLineNum = 17;BA.debugLine="ForceReload";
_forcereload(_ba);
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return "";
}
public static String  _loadfromdisk(anywheresoftware.b4a.BA _ba) throws Exception{
String _json = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
anywheresoftware.b4a.objects.collections.List _grplist = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
com.lockzero.clspasswordgroup _g = null;
anywheresoftware.b4a.objects.collections.List _entlist = null;
com.lockzero.clspasswordentry _e = null;
 //BA.debugLineNum = 33;BA.debugLine="Private Sub LoadFromDisk";
 //BA.debugLineNum = 34;BA.debugLine="If File.Exists(File.DirInternal, FILE_NAME) = Fal";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_file_name)==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 35;BA.debugLine="Log(\"ModPasswords: arquivo nao existe, iniciando";
anywheresoftware.b4a.keywords.Common.LogImpl("541746434","ModPasswords: arquivo nao existe, iniciando vazio",0);
 //BA.debugLineNum = 36;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 39;BA.debugLine="Try";
try { //BA.debugLineNum = 40;BA.debugLine="Dim json As String = File.ReadString(File.DirInt";
_json = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_file_name);
 //BA.debugLineNum = 41;BA.debugLine="Log(\"=== DEBUG JSON ===\")";
anywheresoftware.b4a.keywords.Common.LogImpl("541746440","=== DEBUG JSON ===",0);
 //BA.debugLineNum = 42;BA.debugLine="Log(json)";
anywheresoftware.b4a.keywords.Common.LogImpl("541746441",_json,0);
 //BA.debugLineNum = 43;BA.debugLine="Log(\"=== FIM DEBUG ===\")";
anywheresoftware.b4a.keywords.Common.LogImpl("541746442","=== FIM DEBUG ===",0);
 //BA.debugLineNum = 44;BA.debugLine="If json.Length = 0 Then Return";
if (_json.length()==0) { 
if (true) return "";};
 //BA.debugLineNum = 46;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 47;BA.debugLine="parser.Initialize(json)";
_parser.Initialize(_json);
 //BA.debugLineNum = 48;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
 //BA.debugLineNum = 51;BA.debugLine="If root.ContainsKey(\"groups\") Then";
if (_root.ContainsKey((Object)("groups"))) { 
 //BA.debugLineNum = 52;BA.debugLine="Dim grpList As List = root.Get(\"groups\")";
_grplist = new anywheresoftware.b4a.objects.collections.List();
_grplist = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_root.Get((Object)("groups"))));
 //BA.debugLineNum = 53;BA.debugLine="For Each m As Map In grpList";
_m = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group16 = _grplist;
final int groupLen16 = group16.getSize()
;int index16 = 0;
;
for (; index16 < groupLen16;index16++){
_m = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group16.Get(index16)));
 //BA.debugLineNum = 54;BA.debugLine="Dim g As clsPasswordGroup";
_g = new com.lockzero.clspasswordgroup();
 //BA.debugLineNum = 55;BA.debugLine="g.Initialize";
_g._initialize /*String*/ ((_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 56;BA.debugLine="g.FromMap(m)";
_g._frommap /*String*/ (_m);
 //BA.debugLineNum = 57;BA.debugLine="Groups.Put(g.Id, g)";
_groups.Put((Object)(_g._id /*String*/ ),(Object)(_g));
 }
};
 };
 //BA.debugLineNum = 62;BA.debugLine="If root.ContainsKey(\"entries\") Then";
if (_root.ContainsKey((Object)("entries"))) { 
 //BA.debugLineNum = 63;BA.debugLine="Dim entList As List = root.Get(\"entries\")";
_entlist = new anywheresoftware.b4a.objects.collections.List();
_entlist = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_root.Get((Object)("entries"))));
 //BA.debugLineNum = 64;BA.debugLine="For Each m As Map In entList";
_m = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group25 = _entlist;
final int groupLen25 = group25.getSize()
;int index25 = 0;
;
for (; index25 < groupLen25;index25++){
_m = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group25.Get(index25)));
 //BA.debugLineNum = 65;BA.debugLine="Dim e As clsPasswordEntry";
_e = new com.lockzero.clspasswordentry();
 //BA.debugLineNum = 66;BA.debugLine="e.Initialize";
_e._initialize /*String*/ ((_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 67;BA.debugLine="e.FromMap(m)";
_e._frommap /*String*/ (_m);
 //BA.debugLineNum = 68;BA.debugLine="Entries.Put(e.Id, e)";
_entries.Put((Object)(_e._id /*String*/ ),(Object)(_e));
 }
};
 };
 } 
       catch (Exception e33) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e33); //BA.debugLineNum = 73;BA.debugLine="Log(\"ModPasswords.LoadFromDisk erro: \" & LastExc";
anywheresoftware.b4a.keywords.Common.LogImpl("541746472","ModPasswords.LoadFromDisk erro: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 4;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Private Const FILE_NAME As String = \"lockzero_pas";
_file_name = "lockzero_passwords.json";
 //BA.debugLineNum = 6;BA.debugLine="Private Groups As Map            'Map de clsPassw";
_groups = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 7;BA.debugLine="Private Entries As Map           'Map de clsPassw";
_entries = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 8;BA.debugLine="Private IsLoaded As Boolean = False";
_isloaded = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return "";
}
public static String  _saveentry(anywheresoftware.b4a.BA _ba,com.lockzero.clspasswordentry _e) throws Exception{
 //BA.debugLineNum = 208;BA.debugLine="Public Sub SaveEntry(e As clsPasswordEntry)";
 //BA.debugLineNum = 209;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 210;BA.debugLine="If e.Id = \"\" Then";
if ((_e._id /*String*/ ).equals("")) { 
 //BA.debugLineNum = 211;BA.debugLine="e.Id = ModSecurity.GenerateUUID";
_e._id /*String*/  = mostCurrent._modsecurity._generateuuid /*String*/ (_ba);
 //BA.debugLineNum = 212;BA.debugLine="e.CreatedAt = DateTime.Now";
_e._createdat /*long*/  = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 };
 //BA.debugLineNum = 214;BA.debugLine="e.UpdatedAt = DateTime.Now";
_e._updatedat /*long*/  = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 //BA.debugLineNum = 215;BA.debugLine="Entries.Put(e.Id, e)";
_entries.Put((Object)(_e._id /*String*/ ),(Object)(_e));
 //BA.debugLineNum = 216;BA.debugLine="SaveToDisk";
_savetodisk(_ba);
 //BA.debugLineNum = 217;BA.debugLine="End Sub";
return "";
}
public static String  _savegroup(anywheresoftware.b4a.BA _ba,com.lockzero.clspasswordgroup _g) throws Exception{
 //BA.debugLineNum = 134;BA.debugLine="Public Sub SaveGroup(g As clsPasswordGroup)";
 //BA.debugLineNum = 135;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 136;BA.debugLine="If g.Id = \"\" Then";
if ((_g._id /*String*/ ).equals("")) { 
 //BA.debugLineNum = 137;BA.debugLine="g.Id = ModSecurity.GenerateUUID";
_g._id /*String*/  = mostCurrent._modsecurity._generateuuid /*String*/ (_ba);
 //BA.debugLineNum = 138;BA.debugLine="g.CreatedAt = DateTime.Now";
_g._createdat /*long*/  = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 };
 //BA.debugLineNum = 140;BA.debugLine="g.UpdatedAt = DateTime.Now";
_g._updatedat /*long*/  = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 //BA.debugLineNum = 141;BA.debugLine="Groups.Put(g.Id, g)";
_groups.Put((Object)(_g._id /*String*/ ),(Object)(_g));
 //BA.debugLineNum = 142;BA.debugLine="SaveToDisk";
_savetodisk(_ba);
 //BA.debugLineNum = 143;BA.debugLine="End Sub";
return "";
}
public static String  _savetodisk(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.List _grplist = null;
String _k = "";
com.lockzero.clspasswordgroup _g = null;
anywheresoftware.b4a.objects.collections.List _entlist = null;
com.lockzero.clspasswordentry _e = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _gen = null;
 //BA.debugLineNum = 81;BA.debugLine="Public Sub SaveToDisk";
 //BA.debugLineNum = 83;BA.debugLine="Dim grpList As List";
_grplist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 84;BA.debugLine="grpList.Initialize";
_grplist.Initialize();
 //BA.debugLineNum = 85;BA.debugLine="For Each k As String In Groups.Keys";
{
final anywheresoftware.b4a.BA.IterableList group3 = _groups.Keys();
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_k = BA.ObjectToString(group3.Get(index3));
 //BA.debugLineNum = 86;BA.debugLine="Dim g As clsPasswordGroup = Groups.Get(k)";
_g = (com.lockzero.clspasswordgroup)(_groups.Get((Object)(_k)));
 //BA.debugLineNum = 87;BA.debugLine="grpList.Add(g.ToMap)";
_grplist.Add((Object)(_g._tomap /*anywheresoftware.b4a.objects.collections.Map*/ ().getObject()));
 }
};
 //BA.debugLineNum = 91;BA.debugLine="Dim entList As List";
_entlist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 92;BA.debugLine="entList.Initialize";
_entlist.Initialize();
 //BA.debugLineNum = 93;BA.debugLine="For Each k As String In Entries.Keys";
{
final anywheresoftware.b4a.BA.IterableList group9 = _entries.Keys();
final int groupLen9 = group9.getSize()
;int index9 = 0;
;
for (; index9 < groupLen9;index9++){
_k = BA.ObjectToString(group9.Get(index9));
 //BA.debugLineNum = 94;BA.debugLine="Dim e As clsPasswordEntry = Entries.Get(k)";
_e = (com.lockzero.clspasswordentry)(_entries.Get((Object)(_k)));
 //BA.debugLineNum = 95;BA.debugLine="entList.Add(e.ToMap)";
_entlist.Add((Object)(_e._tomap /*anywheresoftware.b4a.objects.collections.Map*/ ().getObject()));
 }
};
 //BA.debugLineNum = 98;BA.debugLine="Dim root As Map";
_root = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 99;BA.debugLine="root.Initialize";
_root.Initialize();
 //BA.debugLineNum = 100;BA.debugLine="root.Put(\"version\", 1)";
_root.Put((Object)("version"),(Object)(1));
 //BA.debugLineNum = 101;BA.debugLine="root.Put(\"groups\", grpList)";
_root.Put((Object)("groups"),(Object)(_grplist.getObject()));
 //BA.debugLineNum = 102;BA.debugLine="root.Put(\"entries\", entList)";
_root.Put((Object)("entries"),(Object)(_entlist.getObject()));
 //BA.debugLineNum = 104;BA.debugLine="Dim gen As JSONGenerator";
_gen = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 105;BA.debugLine="gen.Initialize(root)";
_gen.Initialize(_root);
 //BA.debugLineNum = 106;BA.debugLine="File.WriteString(File.DirInternal, FILE_NAME, gen";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_file_name,_gen.ToString());
 //BA.debugLineNum = 108;BA.debugLine="Log(\"ModPasswords: salvo \" & Groups.Size & \" grup";
anywheresoftware.b4a.keywords.Common.LogImpl("541811995","ModPasswords: salvo "+BA.NumberToString(_groups.getSize())+" grupos, "+BA.NumberToString(_entries.getSize())+" senhas",0);
 //BA.debugLineNum = 109;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _search(anywheresoftware.b4a.BA _ba,String _query) throws Exception{
anywheresoftware.b4a.objects.collections.List _lst = null;
String _q = "";
String _k = "";
com.lockzero.clspasswordentry _e = null;
 //BA.debugLineNum = 275;BA.debugLine="Public Sub Search(query As String) As List";
 //BA.debugLineNum = 276;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 277;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 278;BA.debugLine="lst.Initialize";
_lst.Initialize();
 //BA.debugLineNum = 279;BA.debugLine="Dim q As String = query.ToLowerCase.Trim";
_q = _query.toLowerCase().trim();
 //BA.debugLineNum = 281;BA.debugLine="If q.Length < 1 Then Return lst";
if (_q.length()<1) { 
if (true) return _lst;};
 //BA.debugLineNum = 283;BA.debugLine="For Each k As String In Entries.Keys";
{
final anywheresoftware.b4a.BA.IterableList group6 = _entries.Keys();
final int groupLen6 = group6.getSize()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_k = BA.ObjectToString(group6.Get(index6));
 //BA.debugLineNum = 284;BA.debugLine="Dim e As clsPasswordEntry = Entries.Get(k)";
_e = (com.lockzero.clspasswordentry)(_entries.Get((Object)(_k)));
 //BA.debugLineNum = 285;BA.debugLine="If e.Name.ToLowerCase.Contains(q) Or e.Url.ToLow";
if (_e._name /*String*/ .toLowerCase().contains(_q) || _e._url /*String*/ .toLowerCase().contains(_q)) { 
 //BA.debugLineNum = 286;BA.debugLine="lst.Add(e)";
_lst.Add((Object)(_e));
 };
 }
};
 //BA.debugLineNum = 289;BA.debugLine="Return lst";
if (true) return _lst;
 //BA.debugLineNum = 290;BA.debugLine="End Sub";
return null;
}
public static String  _togglefavorite(anywheresoftware.b4a.BA _ba,String _id) throws Exception{
com.lockzero.clspasswordentry _e = null;
 //BA.debugLineNum = 261;BA.debugLine="Public Sub ToggleFavorite(id As String)";
 //BA.debugLineNum = 262;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 263;BA.debugLine="If Entries.ContainsKey(id) Then";
if (_entries.ContainsKey((Object)(_id))) { 
 //BA.debugLineNum = 264;BA.debugLine="Dim e As clsPasswordEntry = Entries.Get(id)";
_e = (com.lockzero.clspasswordentry)(_entries.Get((Object)(_id)));
 //BA.debugLineNum = 265;BA.debugLine="e.IsFavorite = Not(e.IsFavorite)";
_e._isfavorite /*boolean*/  = anywheresoftware.b4a.keywords.Common.Not(_e._isfavorite /*boolean*/ );
 //BA.debugLineNum = 266;BA.debugLine="e.UpdatedAt = DateTime.Now";
_e._updatedat /*long*/  = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 //BA.debugLineNum = 267;BA.debugLine="SaveToDisk";
_savetodisk(_ba);
 };
 //BA.debugLineNum = 269;BA.debugLine="End Sub";
return "";
}
}
