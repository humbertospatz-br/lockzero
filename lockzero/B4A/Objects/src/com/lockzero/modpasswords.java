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
public com.lockzero.modsecurity _modsecurity = null;
public com.lockzero.modnotes _modnotes = null;
public com.lockzero.modsession _modsession = null;
public com.lockzero.modtheme _modtheme = null;
public com.lockzero.modtransition _modtransition = null;
public com.lockzero.b4xpages _b4xpages = null;
public com.lockzero.b4xcollections _b4xcollections = null;
public com.lockzero.xuiviewsutils _xuiviewsutils = null;
public static String  _decryptvalue(anywheresoftware.b4a.BA _ba,String _enctext) throws Exception{
 //BA.debugLineNum = 441;BA.debugLine="Public Sub DecryptValue(encText As String) As Stri";
 //BA.debugLineNum = 442;BA.debugLine="Return ModSession.Decrypt(encText)";
if (true) return mostCurrent._modsession._decrypt /*String*/ (_ba,_enctext);
 //BA.debugLineNum = 443;BA.debugLine="End Sub";
return "";
}
public static String  _deleteentry(anywheresoftware.b4a.BA _ba,String _id) throws Exception{
 //BA.debugLineNum = 309;BA.debugLine="Public Sub DeleteEntry(id As String)";
 //BA.debugLineNum = 310;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 311;BA.debugLine="If Entries.ContainsKey(id) Then";
if (_entries.ContainsKey((Object)(_id))) { 
 //BA.debugLineNum = 312;BA.debugLine="Entries.Remove(id)";
_entries.Remove((Object)(_id));
 //BA.debugLineNum = 313;BA.debugLine="SaveToDisk";
_savetodisk(_ba);
 };
 //BA.debugLineNum = 315;BA.debugLine="End Sub";
return "";
}
public static String  _deletegroup(anywheresoftware.b4a.BA _ba,String _id) throws Exception{
anywheresoftware.b4a.objects.collections.List _toremove = null;
String _k = "";
com.lockzero.clspasswordentry _e = null;
 //BA.debugLineNum = 235;BA.debugLine="Public Sub DeleteGroup(id As String)";
 //BA.debugLineNum = 236;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 237;BA.debugLine="If Groups.ContainsKey(id) Then";
if (_groups.ContainsKey((Object)(_id))) { 
 //BA.debugLineNum = 238;BA.debugLine="Groups.Remove(id)";
_groups.Remove((Object)(_id));
 //BA.debugLineNum = 241;BA.debugLine="Dim toRemove As List";
_toremove = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 242;BA.debugLine="toRemove.Initialize";
_toremove.Initialize();
 //BA.debugLineNum = 243;BA.debugLine="For Each k As String In Entries.Keys";
{
final anywheresoftware.b4a.BA.IterableList group6 = _entries.Keys();
final int groupLen6 = group6.getSize()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_k = BA.ObjectToString(group6.Get(index6));
 //BA.debugLineNum = 244;BA.debugLine="Dim e As clsPasswordEntry = Entries.Get(k)";
_e = (com.lockzero.clspasswordentry)(_entries.Get((Object)(_k)));
 //BA.debugLineNum = 245;BA.debugLine="If e.GroupId = id Then";
if ((_e._groupid /*String*/ ).equals(_id)) { 
 //BA.debugLineNum = 246;BA.debugLine="toRemove.Add(k)";
_toremove.Add((Object)(_k));
 };
 }
};
 //BA.debugLineNum = 249;BA.debugLine="For Each k As String In toRemove";
{
final anywheresoftware.b4a.BA.IterableList group12 = _toremove;
final int groupLen12 = group12.getSize()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_k = BA.ObjectToString(group12.Get(index12));
 //BA.debugLineNum = 250;BA.debugLine="Entries.Remove(k)";
_entries.Remove((Object)(_k));
 }
};
 //BA.debugLineNum = 253;BA.debugLine="SaveToDisk";
_savetodisk(_ba);
 };
 //BA.debugLineNum = 255;BA.debugLine="End Sub";
return "";
}
public static String  _encryptvalue(anywheresoftware.b4a.BA _ba,String _plaintext) throws Exception{
 //BA.debugLineNum = 436;BA.debugLine="Public Sub EncryptValue(plainText As String) As St";
 //BA.debugLineNum = 437;BA.debugLine="Return ModSession.Encrypt(plainText)";
if (true) return mostCurrent._modsession._encrypt /*String*/ (_ba,_plaintext);
 //BA.debugLineNum = 438;BA.debugLine="End Sub";
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
anywheresoftware.b4a.keywords.Common.LogImpl("87798790","ModPasswords: "+BA.NumberToString(_groups.getSize())+" grupos, "+BA.NumberToString(_entries.getSize())+" senhas",0);
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _getallentries(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.List _lst = null;
String _k = "";
 //BA.debugLineNum = 279;BA.debugLine="Public Sub GetAllEntries As List";
 //BA.debugLineNum = 280;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 281;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 282;BA.debugLine="lst.Initialize";
_lst.Initialize();
 //BA.debugLineNum = 283;BA.debugLine="For Each k As String In Entries.Keys";
{
final anywheresoftware.b4a.BA.IterableList group4 = _entries.Keys();
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_k = BA.ObjectToString(group4.Get(index4));
 //BA.debugLineNum = 284;BA.debugLine="lst.Add(Entries.Get(k))";
_lst.Add(_entries.Get((Object)(_k)));
 }
};
 //BA.debugLineNum = 286;BA.debugLine="Return lst";
if (true) return _lst;
 //BA.debugLineNum = 287;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _getallgroups(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.List _lst = null;
String _k = "";
 //BA.debugLineNum = 205;BA.debugLine="Public Sub GetAllGroups As List";
 //BA.debugLineNum = 206;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 207;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 208;BA.debugLine="lst.Initialize";
_lst.Initialize();
 //BA.debugLineNum = 209;BA.debugLine="For Each k As String In Groups.Keys";
{
final anywheresoftware.b4a.BA.IterableList group4 = _groups.Keys();
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_k = BA.ObjectToString(group4.Get(index4));
 //BA.debugLineNum = 210;BA.debugLine="lst.Add(Groups.Get(k))";
_lst.Add(_groups.Get((Object)(_k)));
 }
};
 //BA.debugLineNum = 212;BA.debugLine="Return lst";
if (true) return _lst;
 //BA.debugLineNum = 213;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _getentriesbygroup(anywheresoftware.b4a.BA _ba,String _groupid) throws Exception{
anywheresoftware.b4a.objects.collections.List _lst = null;
String _k = "";
com.lockzero.clspasswordentry _e = null;
 //BA.debugLineNum = 266;BA.debugLine="Public Sub GetEntriesByGroup(groupId As String) As";
 //BA.debugLineNum = 267;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 268;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 269;BA.debugLine="lst.Initialize";
_lst.Initialize();
 //BA.debugLineNum = 270;BA.debugLine="For Each k As String In Entries.Keys";
{
final anywheresoftware.b4a.BA.IterableList group4 = _entries.Keys();
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_k = BA.ObjectToString(group4.Get(index4));
 //BA.debugLineNum = 271;BA.debugLine="Dim e As clsPasswordEntry = Entries.Get(k)";
_e = (com.lockzero.clspasswordentry)(_entries.Get((Object)(_k)));
 //BA.debugLineNum = 272;BA.debugLine="If e.GroupId = groupId Then";
if ((_e._groupid /*String*/ ).equals(_groupid)) { 
 //BA.debugLineNum = 273;BA.debugLine="lst.Add(e)";
_lst.Add((Object)(_e));
 };
 }
};
 //BA.debugLineNum = 276;BA.debugLine="Return lst";
if (true) return _lst;
 //BA.debugLineNum = 277;BA.debugLine="End Sub";
return null;
}
public static com.lockzero.clspasswordentry  _getentrybyid(anywheresoftware.b4a.BA _ba,String _id) throws Exception{
com.lockzero.clspasswordentry _empty = null;
 //BA.debugLineNum = 289;BA.debugLine="Public Sub GetEntryById(id As String) As clsPasswo";
 //BA.debugLineNum = 290;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 291;BA.debugLine="If Entries.ContainsKey(id) Then";
if (_entries.ContainsKey((Object)(_id))) { 
 //BA.debugLineNum = 292;BA.debugLine="Return Entries.Get(id)";
if (true) return (com.lockzero.clspasswordentry)(_entries.Get((Object)(_id)));
 };
 //BA.debugLineNum = 294;BA.debugLine="Dim empty As clsPasswordEntry";
_empty = new com.lockzero.clspasswordentry();
 //BA.debugLineNum = 295;BA.debugLine="Return empty";
if (true) return _empty;
 //BA.debugLineNum = 296;BA.debugLine="End Sub";
return null;
}
public static int  _getentrycountbygroup(anywheresoftware.b4a.BA _ba,String _groupid) throws Exception{
int _count = 0;
String _k = "";
com.lockzero.clspasswordentry _e = null;
 //BA.debugLineNum = 317;BA.debugLine="Public Sub GetEntryCountByGroup(groupId As String)";
 //BA.debugLineNum = 318;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 319;BA.debugLine="Dim count As Int = 0";
_count = (int) (0);
 //BA.debugLineNum = 320;BA.debugLine="For Each k As String In Entries.Keys";
{
final anywheresoftware.b4a.BA.IterableList group3 = _entries.Keys();
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_k = BA.ObjectToString(group3.Get(index3));
 //BA.debugLineNum = 321;BA.debugLine="Dim e As clsPasswordEntry = Entries.Get(k)";
_e = (com.lockzero.clspasswordentry)(_entries.Get((Object)(_k)));
 //BA.debugLineNum = 322;BA.debugLine="If e.GroupId = groupId Then";
if ((_e._groupid /*String*/ ).equals(_groupid)) { 
 //BA.debugLineNum = 323;BA.debugLine="count = count + 1";
_count = (int) (_count+1);
 };
 }
};
 //BA.debugLineNum = 326;BA.debugLine="Return count";
if (true) return _count;
 //BA.debugLineNum = 327;BA.debugLine="End Sub";
return 0;
}
public static anywheresoftware.b4a.objects.collections.List  _getfavorites(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.List _lst = null;
String _k = "";
com.lockzero.clspasswordentry _e = null;
 //BA.debugLineNum = 338;BA.debugLine="Public Sub GetFavorites As List";
 //BA.debugLineNum = 339;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 340;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 341;BA.debugLine="lst.Initialize";
_lst.Initialize();
 //BA.debugLineNum = 342;BA.debugLine="For Each k As String In Entries.Keys";
{
final anywheresoftware.b4a.BA.IterableList group4 = _entries.Keys();
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_k = BA.ObjectToString(group4.Get(index4));
 //BA.debugLineNum = 343;BA.debugLine="Dim e As clsPasswordEntry = Entries.Get(k)";
_e = (com.lockzero.clspasswordentry)(_entries.Get((Object)(_k)));
 //BA.debugLineNum = 344;BA.debugLine="If e.IsFavorite Then";
if (_e._isfavorite /*boolean*/ ) { 
 //BA.debugLineNum = 345;BA.debugLine="lst.Add(e)";
_lst.Add((Object)(_e));
 };
 }
};
 //BA.debugLineNum = 348;BA.debugLine="Return lst";
if (true) return _lst;
 //BA.debugLineNum = 349;BA.debugLine="End Sub";
return null;
}
public static com.lockzero.clspasswordgroup  _getgroupbyid(anywheresoftware.b4a.BA _ba,String _id) throws Exception{
com.lockzero.clspasswordgroup _empty = null;
 //BA.debugLineNum = 215;BA.debugLine="Public Sub GetGroupById(id As String) As clsPasswo";
 //BA.debugLineNum = 216;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 217;BA.debugLine="If Groups.ContainsKey(id) Then";
if (_groups.ContainsKey((Object)(_id))) { 
 //BA.debugLineNum = 218;BA.debugLine="Return Groups.Get(id)";
if (true) return (com.lockzero.clspasswordgroup)(_groups.Get((Object)(_id)));
 };
 //BA.debugLineNum = 220;BA.debugLine="Dim empty As clsPasswordGroup";
_empty = new com.lockzero.clspasswordgroup();
 //BA.debugLineNum = 221;BA.debugLine="Return empty";
if (true) return _empty;
 //BA.debugLineNum = 222;BA.debugLine="End Sub";
return null;
}
public static int  _getgroupcount(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 257;BA.debugLine="Public Sub GetGroupCount As Int";
 //BA.debugLineNum = 258;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 259;BA.debugLine="Return Groups.Size";
if (true) return _groups.getSize();
 //BA.debugLineNum = 260;BA.debugLine="End Sub";
return 0;
}
public static anywheresoftware.b4a.objects.collections.Map  _getstats(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.Map _stats = null;
 //BA.debugLineNum = 449;BA.debugLine="Public Sub GetStats As Map";
 //BA.debugLineNum = 450;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 451;BA.debugLine="Dim stats As Map";
_stats = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 452;BA.debugLine="stats.Initialize";
_stats.Initialize();
 //BA.debugLineNum = 453;BA.debugLine="stats.Put(\"groups\", Groups.Size)";
_stats.Put((Object)("groups"),(Object)(_groups.getSize()));
 //BA.debugLineNum = 454;BA.debugLine="stats.Put(\"entries\", Entries.Size)";
_stats.Put((Object)("entries"),(Object)(_entries.getSize()));
 //BA.debugLineNum = 455;BA.debugLine="stats.Put(\"favorites\", GetFavorites.Size)";
_stats.Put((Object)("favorites"),(Object)(_getfavorites(_ba).getSize()));
 //BA.debugLineNum = 456;BA.debugLine="Return stats";
if (true) return _stats;
 //BA.debugLineNum = 457;BA.debugLine="End Sub";
return null;
}
public static int  _gettotalentrycount(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 329;BA.debugLine="Public Sub GetTotalEntryCount As Int";
 //BA.debugLineNum = 330;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 331;BA.debugLine="Return Entries.Size";
if (true) return _entries.getSize();
 //BA.debugLineNum = 332;BA.debugLine="End Sub";
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
public static String  _loadfilewithfallback(anywheresoftware.b4a.BA _ba,String _folder,String _filename) throws Exception{
String _backupfile = "";
String _content = "";
String _backup = "";
 //BA.debugLineNum = 75;BA.debugLine="Private Sub LoadFileWithFallback(folder As String,";
 //BA.debugLineNum = 76;BA.debugLine="Dim backupFile As String = fileName & \".bak\"";
_backupfile = _filename+".bak";
 //BA.debugLineNum = 79;BA.debugLine="If File.Exists(folder, fileName) Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(_folder,_filename)) { 
 //BA.debugLineNum = 80;BA.debugLine="Try";
try { //BA.debugLineNum = 81;BA.debugLine="Dim content As String = File.ReadString(folder,";
_content = anywheresoftware.b4a.keywords.Common.File.ReadString(_folder,_filename);
 //BA.debugLineNum = 83;BA.debugLine="If content.Length > 0 And (content.StartsWith(\"";
if (_content.length()>0 && (_content.startsWith("{") || _content.startsWith("["))) { 
 //BA.debugLineNum = 84;BA.debugLine="Log(\"LoadFileWithFallback: arquivo principal O";
anywheresoftware.b4a.keywords.Common.LogImpl("87929865","LoadFileWithFallback: arquivo principal OK",0);
 //BA.debugLineNum = 85;BA.debugLine="Return content";
if (true) return _content;
 }else {
 //BA.debugLineNum = 87;BA.debugLine="Log(\"LoadFileWithFallback: arquivo principal i";
anywheresoftware.b4a.keywords.Common.LogImpl("87929868","LoadFileWithFallback: arquivo principal invalido",0);
 };
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12); //BA.debugLineNum = 90;BA.debugLine="Log(\"LoadFileWithFallback: erro ao ler principa";
anywheresoftware.b4a.keywords.Common.LogImpl("87929871","LoadFileWithFallback: erro ao ler principal - "+anywheresoftware.b4a.keywords.Common.LastException(_ba).getMessage(),0);
 };
 };
 //BA.debugLineNum = 95;BA.debugLine="If File.Exists(folder, backupFile) Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(_folder,_backupfile)) { 
 //BA.debugLineNum = 96;BA.debugLine="Try";
try { //BA.debugLineNum = 97;BA.debugLine="Dim backup As String = File.ReadString(folder,";
_backup = anywheresoftware.b4a.keywords.Common.File.ReadString(_folder,_backupfile);
 //BA.debugLineNum = 98;BA.debugLine="If backup.Length > 0 And (backup.StartsWith(\"{\"";
if (_backup.length()>0 && (_backup.startsWith("{") || _backup.startsWith("["))) { 
 //BA.debugLineNum = 99;BA.debugLine="Log(\"LoadFileWithFallback: USANDO BACKUP! Arqu";
anywheresoftware.b4a.keywords.Common.LogImpl("87929880","LoadFileWithFallback: USANDO BACKUP! Arquivo principal estava corrompido.",0);
 //BA.debugLineNum = 101;BA.debugLine="File.Copy(folder, backupFile, folder, fileName";
anywheresoftware.b4a.keywords.Common.File.Copy(_folder,_backupfile,_folder,_filename);
 //BA.debugLineNum = 102;BA.debugLine="Return backup";
if (true) return _backup;
 };
 } 
       catch (Exception e24) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e24); //BA.debugLineNum = 105;BA.debugLine="Log(\"LoadFileWithFallback: backup tambem corrom";
anywheresoftware.b4a.keywords.Common.LogImpl("87929886","LoadFileWithFallback: backup tambem corrompido!",0);
 };
 };
 //BA.debugLineNum = 110;BA.debugLine="Log(\"LoadFileWithFallback: nenhum arquivo valido";
anywheresoftware.b4a.keywords.Common.LogImpl("87929891","LoadFileWithFallback: nenhum arquivo valido encontrado",0);
 //BA.debugLineNum = 111;BA.debugLine="Return \"\"";
if (true) return "";
 //BA.debugLineNum = 112;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 35;BA.debugLine="Dim json As String = LoadFileWithFallback(File.Di";
_json = _loadfilewithfallback(_ba,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_file_name);
 //BA.debugLineNum = 37;BA.debugLine="If json.Length = 0 Then";
if (_json.length()==0) { 
 //BA.debugLineNum = 38;BA.debugLine="Log(\"ModPasswords: nenhum arquivo disponivel, in";
anywheresoftware.b4a.keywords.Common.LogImpl("87864325","ModPasswords: nenhum arquivo disponivel, iniciando vazio",0);
 //BA.debugLineNum = 39;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 42;BA.debugLine="Try";
try { //BA.debugLineNum = 43;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 44;BA.debugLine="parser.Initialize(json)";
_parser.Initialize(_json);
 //BA.debugLineNum = 45;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
 //BA.debugLineNum = 48;BA.debugLine="If root.ContainsKey(\"groups\") Then";
if (_root.ContainsKey((Object)("groups"))) { 
 //BA.debugLineNum = 49;BA.debugLine="Dim grpList As List = root.Get(\"groups\")";
_grplist = new anywheresoftware.b4a.objects.collections.List();
_grplist = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_root.Get((Object)("groups"))));
 //BA.debugLineNum = 50;BA.debugLine="For Each m As Map In grpList";
_m = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group12 = _grplist;
final int groupLen12 = group12.getSize()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_m = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group12.Get(index12)));
 //BA.debugLineNum = 51;BA.debugLine="Dim g As clsPasswordGroup";
_g = new com.lockzero.clspasswordgroup();
 //BA.debugLineNum = 52;BA.debugLine="g.Initialize";
_g._initialize /*String*/ ((_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 53;BA.debugLine="g.FromMap(m)";
_g._frommap /*String*/ (_m);
 //BA.debugLineNum = 54;BA.debugLine="Groups.Put(g.Id, g)";
_groups.Put((Object)(_g._id /*String*/ ),(Object)(_g));
 }
};
 };
 //BA.debugLineNum = 59;BA.debugLine="If root.ContainsKey(\"entries\") Then";
if (_root.ContainsKey((Object)("entries"))) { 
 //BA.debugLineNum = 60;BA.debugLine="Dim entList As List = root.Get(\"entries\")";
_entlist = new anywheresoftware.b4a.objects.collections.List();
_entlist = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_root.Get((Object)("entries"))));
 //BA.debugLineNum = 61;BA.debugLine="For Each m As Map In entList";
_m = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group21 = _entlist;
final int groupLen21 = group21.getSize()
;int index21 = 0;
;
for (; index21 < groupLen21;index21++){
_m = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group21.Get(index21)));
 //BA.debugLineNum = 62;BA.debugLine="Dim e As clsPasswordEntry";
_e = new com.lockzero.clspasswordentry();
 //BA.debugLineNum = 63;BA.debugLine="e.Initialize";
_e._initialize /*String*/ ((_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 64;BA.debugLine="e.FromMap(m)";
_e._frommap /*String*/ (_m);
 //BA.debugLineNum = 65;BA.debugLine="Entries.Put(e.Id, e)";
_entries.Put((Object)(_e._id /*String*/ ),(Object)(_e));
 }
};
 };
 } 
       catch (Exception e29) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e29); //BA.debugLineNum = 70;BA.debugLine="Log(\"ModPasswords.LoadFromDisk erro ao parsear:";
anywheresoftware.b4a.keywords.Common.LogImpl("87864357","ModPasswords.LoadFromDisk erro ao parsear: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 72;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 298;BA.debugLine="Public Sub SaveEntry(e As clsPasswordEntry)";
 //BA.debugLineNum = 299;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 300;BA.debugLine="If e.Id = \"\" Then";
if ((_e._id /*String*/ ).equals("")) { 
 //BA.debugLineNum = 301;BA.debugLine="e.Id = ModSecurity.GenerateUUID";
_e._id /*String*/  = mostCurrent._modsecurity._generateuuid /*String*/ (_ba);
 //BA.debugLineNum = 302;BA.debugLine="e.CreatedAt = DateTime.Now";
_e._createdat /*long*/  = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 };
 //BA.debugLineNum = 304;BA.debugLine="e.UpdatedAt = DateTime.Now";
_e._updatedat /*long*/  = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 //BA.debugLineNum = 305;BA.debugLine="Entries.Put(e.Id, e)";
_entries.Put((Object)(_e._id /*String*/ ),(Object)(_e));
 //BA.debugLineNum = 306;BA.debugLine="SaveToDisk";
_savetodisk(_ba);
 //BA.debugLineNum = 307;BA.debugLine="End Sub";
return "";
}
public static boolean  _savefileatomic(anywheresoftware.b4a.BA _ba,String _folder,String _filename,String _content) throws Exception{
String _tempfile = "";
String _backupfile = "";
String _verify = "";
 //BA.debugLineNum = 158;BA.debugLine="Private Sub SaveFileAtomic(folder As String, fileN";
 //BA.debugLineNum = 159;BA.debugLine="Dim tempFile As String = fileName & \".tmp\"";
_tempfile = _filename+".tmp";
 //BA.debugLineNum = 160;BA.debugLine="Dim backupFile As String = fileName & \".bak\"";
_backupfile = _filename+".bak";
 //BA.debugLineNum = 162;BA.debugLine="Try";
try { //BA.debugLineNum = 164;BA.debugLine="File.WriteString(folder, tempFile, content)";
anywheresoftware.b4a.keywords.Common.File.WriteString(_folder,_tempfile,_content);
 //BA.debugLineNum = 167;BA.debugLine="Dim verify As String = File.ReadString(folder, t";
_verify = anywheresoftware.b4a.keywords.Common.File.ReadString(_folder,_tempfile);
 //BA.debugLineNum = 168;BA.debugLine="If verify <> content Then";
if ((_verify).equals(_content) == false) { 
 //BA.debugLineNum = 169;BA.debugLine="Log(\"SaveFileAtomic: verificacao falhou\")";
anywheresoftware.b4a.keywords.Common.LogImpl("88060939","SaveFileAtomic: verificacao falhou",0);
 //BA.debugLineNum = 170;BA.debugLine="File.Delete(folder, tempFile)";
anywheresoftware.b4a.keywords.Common.File.Delete(_folder,_tempfile);
 //BA.debugLineNum = 171;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 175;BA.debugLine="If File.Exists(folder, fileName) Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(_folder,_filename)) { 
 //BA.debugLineNum = 177;BA.debugLine="If File.Exists(folder, backupFile) Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(_folder,_backupfile)) { 
 //BA.debugLineNum = 178;BA.debugLine="File.Delete(folder, backupFile)";
anywheresoftware.b4a.keywords.Common.File.Delete(_folder,_backupfile);
 };
 //BA.debugLineNum = 181;BA.debugLine="File.Copy(folder, fileName, folder, backupFile)";
anywheresoftware.b4a.keywords.Common.File.Copy(_folder,_filename,_folder,_backupfile);
 };
 //BA.debugLineNum = 185;BA.debugLine="File.Delete(folder, fileName)";
anywheresoftware.b4a.keywords.Common.File.Delete(_folder,_filename);
 //BA.debugLineNum = 186;BA.debugLine="File.Copy(folder, tempFile, folder, fileName)";
anywheresoftware.b4a.keywords.Common.File.Copy(_folder,_tempfile,_folder,_filename);
 //BA.debugLineNum = 187;BA.debugLine="File.Delete(folder, tempFile)";
anywheresoftware.b4a.keywords.Common.File.Delete(_folder,_tempfile);
 //BA.debugLineNum = 189;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 } 
       catch (Exception e22) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e22); //BA.debugLineNum = 192;BA.debugLine="Log(\"SaveFileAtomic ERRO: \" & LastException.Mess";
anywheresoftware.b4a.keywords.Common.LogImpl("88060962","SaveFileAtomic ERRO: "+anywheresoftware.b4a.keywords.Common.LastException(_ba).getMessage(),0);
 //BA.debugLineNum = 194;BA.debugLine="If File.Exists(folder, tempFile) Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(_folder,_tempfile)) { 
 //BA.debugLineNum = 195;BA.debugLine="File.Delete(folder, tempFile)";
anywheresoftware.b4a.keywords.Common.File.Delete(_folder,_tempfile);
 };
 //BA.debugLineNum = 197;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 199;BA.debugLine="End Sub";
return false;
}
public static String  _savegroup(anywheresoftware.b4a.BA _ba,com.lockzero.clspasswordgroup _g) throws Exception{
 //BA.debugLineNum = 224;BA.debugLine="Public Sub SaveGroup(g As clsPasswordGroup)";
 //BA.debugLineNum = 225;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 226;BA.debugLine="If g.Id = \"\" Then";
if ((_g._id /*String*/ ).equals("")) { 
 //BA.debugLineNum = 227;BA.debugLine="g.Id = ModSecurity.GenerateUUID";
_g._id /*String*/  = mostCurrent._modsecurity._generateuuid /*String*/ (_ba);
 //BA.debugLineNum = 228;BA.debugLine="g.CreatedAt = DateTime.Now";
_g._createdat /*long*/  = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 };
 //BA.debugLineNum = 230;BA.debugLine="g.UpdatedAt = DateTime.Now";
_g._updatedat /*long*/  = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 //BA.debugLineNum = 231;BA.debugLine="Groups.Put(g.Id, g)";
_groups.Put((Object)(_g._id /*String*/ ),(Object)(_g));
 //BA.debugLineNum = 232;BA.debugLine="SaveToDisk";
_savetodisk(_ba);
 //BA.debugLineNum = 233;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 118;BA.debugLine="Public Sub SaveToDisk";
 //BA.debugLineNum = 120;BA.debugLine="Dim grpList As List";
_grplist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 121;BA.debugLine="grpList.Initialize";
_grplist.Initialize();
 //BA.debugLineNum = 122;BA.debugLine="For Each k As String In Groups.Keys";
{
final anywheresoftware.b4a.BA.IterableList group3 = _groups.Keys();
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_k = BA.ObjectToString(group3.Get(index3));
 //BA.debugLineNum = 123;BA.debugLine="Dim g As clsPasswordGroup = Groups.Get(k)";
_g = (com.lockzero.clspasswordgroup)(_groups.Get((Object)(_k)));
 //BA.debugLineNum = 124;BA.debugLine="grpList.Add(g.ToMap)";
_grplist.Add((Object)(_g._tomap /*anywheresoftware.b4a.objects.collections.Map*/ ().getObject()));
 }
};
 //BA.debugLineNum = 128;BA.debugLine="Dim entList As List";
_entlist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 129;BA.debugLine="entList.Initialize";
_entlist.Initialize();
 //BA.debugLineNum = 130;BA.debugLine="For Each k As String In Entries.Keys";
{
final anywheresoftware.b4a.BA.IterableList group9 = _entries.Keys();
final int groupLen9 = group9.getSize()
;int index9 = 0;
;
for (; index9 < groupLen9;index9++){
_k = BA.ObjectToString(group9.Get(index9));
 //BA.debugLineNum = 131;BA.debugLine="Dim e As clsPasswordEntry = Entries.Get(k)";
_e = (com.lockzero.clspasswordentry)(_entries.Get((Object)(_k)));
 //BA.debugLineNum = 132;BA.debugLine="entList.Add(e.ToMap)";
_entlist.Add((Object)(_e._tomap /*anywheresoftware.b4a.objects.collections.Map*/ ().getObject()));
 }
};
 //BA.debugLineNum = 135;BA.debugLine="Dim root As Map";
_root = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 136;BA.debugLine="root.Initialize";
_root.Initialize();
 //BA.debugLineNum = 137;BA.debugLine="root.Put(\"version\", 1)";
_root.Put((Object)("version"),(Object)(1));
 //BA.debugLineNum = 138;BA.debugLine="root.Put(\"groups\", grpList)";
_root.Put((Object)("groups"),(Object)(_grplist.getObject()));
 //BA.debugLineNum = 139;BA.debugLine="root.Put(\"entries\", entList)";
_root.Put((Object)("entries"),(Object)(_entlist.getObject()));
 //BA.debugLineNum = 141;BA.debugLine="Dim gen As JSONGenerator";
_gen = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 142;BA.debugLine="gen.Initialize(root)";
_gen.Initialize(_root);
 //BA.debugLineNum = 145;BA.debugLine="If SaveFileAtomic(File.DirInternal, FILE_NAME, ge";
if (_savefileatomic(_ba,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_file_name,_gen.ToString())) { 
 //BA.debugLineNum = 146;BA.debugLine="Log(\"ModPasswords: salvo \" & Groups.Size & \" gru";
anywheresoftware.b4a.keywords.Common.LogImpl("87995420","ModPasswords: salvo "+BA.NumberToString(_groups.getSize())+" grupos, "+BA.NumberToString(_entries.getSize())+" senhas",0);
 }else {
 //BA.debugLineNum = 148;BA.debugLine="Log(\"ModPasswords: ERRO ao salvar!\")";
anywheresoftware.b4a.keywords.Common.LogImpl("87995422","ModPasswords: ERRO ao salvar!",0);
 };
 //BA.debugLineNum = 150;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _search(anywheresoftware.b4a.BA _ba,String _query) throws Exception{
anywheresoftware.b4a.objects.collections.List _lst = null;
String _q = "";
String _k = "";
com.lockzero.clspasswordentry _e = null;
 //BA.debugLineNum = 365;BA.debugLine="Public Sub Search(query As String) As List";
 //BA.debugLineNum = 366;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 367;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 368;BA.debugLine="lst.Initialize";
_lst.Initialize();
 //BA.debugLineNum = 369;BA.debugLine="Dim q As String = query.ToLowerCase.Trim";
_q = _query.toLowerCase().trim();
 //BA.debugLineNum = 371;BA.debugLine="If q.Length < 1 Then Return lst";
if (_q.length()<1) { 
if (true) return _lst;};
 //BA.debugLineNum = 373;BA.debugLine="For Each k As String In Entries.Keys";
{
final anywheresoftware.b4a.BA.IterableList group6 = _entries.Keys();
final int groupLen6 = group6.getSize()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_k = BA.ObjectToString(group6.Get(index6));
 //BA.debugLineNum = 374;BA.debugLine="Dim e As clsPasswordEntry = Entries.Get(k)";
_e = (com.lockzero.clspasswordentry)(_entries.Get((Object)(_k)));
 //BA.debugLineNum = 375;BA.debugLine="If e.Name.ToLowerCase.Contains(q) Or e.Url.ToLow";
if (_e._name /*String*/ .toLowerCase().contains(_q) || _e._url /*String*/ .toLowerCase().contains(_q)) { 
 //BA.debugLineNum = 376;BA.debugLine="lst.Add(e)";
_lst.Add((Object)(_e));
 };
 }
};
 //BA.debugLineNum = 379;BA.debugLine="Return lst";
if (true) return _lst;
 //BA.debugLineNum = 380;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _searchall(anywheresoftware.b4a.BA _ba,String _query,String _passphrase) throws Exception{
anywheresoftware.b4a.objects.collections.List _lst = null;
String _q = "";
String _normalizedphrase = "";
String _k = "";
com.lockzero.clspasswordentry _e = null;
boolean _found = false;
com.lockzero.clspasswordgroup _group = null;
String _decusername = "";
 //BA.debugLineNum = 386;BA.debugLine="Public Sub SearchAll(query As String, passphrase A";
 //BA.debugLineNum = 387;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 388;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 389;BA.debugLine="lst.Initialize";
_lst.Initialize();
 //BA.debugLineNum = 390;BA.debugLine="Dim q As String = query.ToLowerCase.Trim";
_q = _query.toLowerCase().trim();
 //BA.debugLineNum = 392;BA.debugLine="If q.Length < 2 Then Return lst";
if (_q.length()<2) { 
if (true) return _lst;};
 //BA.debugLineNum = 395;BA.debugLine="Dim normalizedPhrase As String = \"\"";
_normalizedphrase = "";
 //BA.debugLineNum = 396;BA.debugLine="If passphrase.Length > 0 Then";
if (_passphrase.length()>0) { 
 //BA.debugLineNum = 397;BA.debugLine="normalizedPhrase = ModSecurity.NormalizePassphra";
_normalizedphrase = mostCurrent._modsecurity._normalizepassphrase /*String*/ (_ba,_passphrase);
 };
 //BA.debugLineNum = 400;BA.debugLine="For Each k As String In Entries.Keys";
{
final anywheresoftware.b4a.BA.IterableList group10 = _entries.Keys();
final int groupLen10 = group10.getSize()
;int index10 = 0;
;
for (; index10 < groupLen10;index10++){
_k = BA.ObjectToString(group10.Get(index10));
 //BA.debugLineNum = 401;BA.debugLine="Dim e As clsPasswordEntry = Entries.Get(k)";
_e = (com.lockzero.clspasswordentry)(_entries.Get((Object)(_k)));
 //BA.debugLineNum = 402;BA.debugLine="Dim found As Boolean = False";
_found = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 405;BA.debugLine="If e.Name.ToLowerCase.Contains(q) Or e.Url.ToLow";
if (_e._name /*String*/ .toLowerCase().contains(_q) || _e._url /*String*/ .toLowerCase().contains(_q)) { 
 //BA.debugLineNum = 406;BA.debugLine="found = True";
_found = anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 410;BA.debugLine="If found = False And normalizedPhrase.Length >=";
if (_found==anywheresoftware.b4a.keywords.Common.False && _normalizedphrase.length()>=10) { 
 //BA.debugLineNum = 411;BA.debugLine="Try";
try { //BA.debugLineNum = 413;BA.debugLine="Dim group As clsPasswordGroup = GetGroupById(e";
_group = _getgroupbyid(_ba,_e._groupid /*String*/ );
 //BA.debugLineNum = 414;BA.debugLine="If group.IsInitialized And group.Salt.Length >";
if (_group._isinitialized /*boolean*/ () && _group._salt /*String*/ .length()>0) { 
 //BA.debugLineNum = 415;BA.debugLine="Dim decUsername As String = ModSecurity.Decry";
_decusername = mostCurrent._modsecurity._decryptwithsalt /*String*/ (_ba,_passphrase,_group._salt /*String*/ ,_e._username /*String*/ );
 //BA.debugLineNum = 416;BA.debugLine="If decUsername.ToLowerCase.Contains(q) Then";
if (_decusername.toLowerCase().contains(_q)) { 
 //BA.debugLineNum = 417;BA.debugLine="found = True";
_found = anywheresoftware.b4a.keywords.Common.True;
 };
 };
 } 
       catch (Exception e26) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e26); //BA.debugLineNum = 422;BA.debugLine="Log(\"SearchAllGroups decrypt error: \" & LastEx";
anywheresoftware.b4a.keywords.Common.LogImpl("877332516","SearchAllGroups decrypt error: "+anywheresoftware.b4a.keywords.Common.LastException(_ba).getMessage(),0);
 };
 };
 //BA.debugLineNum = 426;BA.debugLine="If found Then lst.Add(e)";
if (_found) { 
_lst.Add((Object)(_e));};
 }
};
 //BA.debugLineNum = 428;BA.debugLine="Return lst";
if (true) return _lst;
 //BA.debugLineNum = 429;BA.debugLine="End Sub";
return null;
}
public static String  _togglefavorite(anywheresoftware.b4a.BA _ba,String _id) throws Exception{
com.lockzero.clspasswordentry _e = null;
 //BA.debugLineNum = 351;BA.debugLine="Public Sub ToggleFavorite(id As String)";
 //BA.debugLineNum = 352;BA.debugLine="Init";
_init(_ba);
 //BA.debugLineNum = 353;BA.debugLine="If Entries.ContainsKey(id) Then";
if (_entries.ContainsKey((Object)(_id))) { 
 //BA.debugLineNum = 354;BA.debugLine="Dim e As clsPasswordEntry = Entries.Get(id)";
_e = (com.lockzero.clspasswordentry)(_entries.Get((Object)(_id)));
 //BA.debugLineNum = 355;BA.debugLine="e.IsFavorite = Not(e.IsFavorite)";
_e._isfavorite /*boolean*/  = anywheresoftware.b4a.keywords.Common.Not(_e._isfavorite /*boolean*/ );
 //BA.debugLineNum = 356;BA.debugLine="e.UpdatedAt = DateTime.Now";
_e._updatedat /*long*/  = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 //BA.debugLineNum = 357;BA.debugLine="SaveToDisk";
_savetodisk(_ba);
 };
 //BA.debugLineNum = 359;BA.debugLine="End Sub";
return "";
}
}
