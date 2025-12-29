package com.lockzero;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class modbackup {
private static modbackup mostCurrent = new modbackup();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public static int _backup_version = 0;
public static String _backup_extension = "";
public static String _lastbackuppath = "";
public static long _lastbackuptime = 0L;
public static String _sharedfolder = "";
public b4a.example.dateutils _dateutils = null;
public com.lockzero.main _main = null;
public com.lockzero.starter _starter = null;
public com.lockzero.modlang _modlang = null;
public com.lockzero.modnotes _modnotes = null;
public com.lockzero.modpasswords _modpasswords = null;
public com.lockzero.modsecurity _modsecurity = null;
public com.lockzero.modsession _modsession = null;
public com.lockzero.modtheme _modtheme = null;
public com.lockzero.b4xpages _b4xpages = null;
public com.lockzero.b4xcollections _b4xcollections = null;
public com.lockzero.xuiviewsutils _xuiviewsutils = null;
public static String  _bytestohex(anywheresoftware.b4a.BA _ba,byte[] _bytes) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
byte _b = (byte)0;
String _hex = "";
 //BA.debugLineNum = 356;BA.debugLine="Private Sub BytesToHex(bytes() As Byte) As String";
 //BA.debugLineNum = 357;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 358;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 359;BA.debugLine="For Each b As Byte In bytes";
{
final byte[] group3 = _bytes;
final int groupLen3 = group3.length
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_b = group3[index3];
 //BA.debugLineNum = 360;BA.debugLine="Dim hex As String = Bit.ToHexString(Bit.And(b, 0";
_hex = anywheresoftware.b4a.keywords.Common.Bit.ToHexString(anywheresoftware.b4a.keywords.Common.Bit.And((int) (_b),((int)0xff)));
 //BA.debugLineNum = 361;BA.debugLine="If hex.Length = 1 Then sb.Append(\"0\")";
if (_hex.length()==1) { 
_sb.Append("0");};
 //BA.debugLineNum = 362;BA.debugLine="sb.Append(hex)";
_sb.Append(_hex);
 }
};
 //BA.debugLineNum = 364;BA.debugLine="Return sb.ToString.ToLowerCase";
if (true) return _sb.ToString().toLowerCase();
 //BA.debugLineNum = 365;BA.debugLine="End Sub";
return "";
}
public static String  _calculatechecksum(anywheresoftware.b4a.BA _ba,String _data) throws Exception{
anywheresoftware.b4a.agraham.encryption.CipherWrapper.MessageDigestWrapper _md = null;
byte[] _bytes = null;
 //BA.debugLineNum = 350;BA.debugLine="Private Sub CalculateChecksum(data As String) As S";
 //BA.debugLineNum = 351;BA.debugLine="Dim md As MessageDigest";
_md = new anywheresoftware.b4a.agraham.encryption.CipherWrapper.MessageDigestWrapper();
 //BA.debugLineNum = 352;BA.debugLine="Dim bytes() As Byte = md.GetMessageDigest(data.Ge";
_bytes = _md.GetMessageDigest(_data.getBytes("UTF8"),"SHA-256");
 //BA.debugLineNum = 353;BA.debugLine="Return BytesToHex(bytes)";
if (true) return _bytestohex(_ba,_bytes);
 //BA.debugLineNum = 354;BA.debugLine="End Sub";
return "";
}
public static String  _clearalldata(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 384;BA.debugLine="Public Sub ClearAllData";
 //BA.debugLineNum = 386;BA.debugLine="If File.Exists(File.DirInternal, \"lockzero_passwo";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"lockzero_passwords.json")) { 
 //BA.debugLineNum = 387;BA.debugLine="File.Delete(File.DirInternal, \"lockzero_password";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"lockzero_passwords.json");
 };
 //BA.debugLineNum = 392;BA.debugLine="Log(\"ModBackup: todos os dados foram limpos\")";
anywheresoftware.b4a.keywords.Common.LogImpl("76225928","ModBackup: todos os dados foram limpos",0);
 //BA.debugLineNum = 393;BA.debugLine="End Sub";
return "";
}
public static String  _exportbackup(anywheresoftware.b4a.BA _ba,String _backupphrase,String _destfolder) throws Exception{
anywheresoftware.b4a.objects.collections.Map _backup = null;
anywheresoftware.b4a.objects.collections.List _groups = null;
anywheresoftware.b4a.objects.collections.List _groupslist = null;
com.lockzero.clspasswordgroup _g = null;
anywheresoftware.b4a.objects.collections.List _entries = null;
anywheresoftware.b4a.objects.collections.List _entrieslist = null;
com.lockzero.clspasswordentry _e = null;
anywheresoftware.b4a.objects.collections.List _notes = null;
anywheresoftware.b4a.objects.collections.Map _stats = null;
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _gen = null;
String _jsondata = "";
String _checksum = "";
anywheresoftware.b4a.objects.collections.Map _finaldata = null;
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _genfinal = null;
String _plaintext = "";
String _encrypted = "";
String _filename = "";
String _fullpath = "";
 //BA.debugLineNum = 39;BA.debugLine="Public Sub ExportBackup(backupPhrase As String, de";
 //BA.debugLineNum = 40;BA.debugLine="If backupPhrase.Length < 6 Then";
if (_backupphrase.length()<6) { 
 //BA.debugLineNum = 41;BA.debugLine="Log(\"ModBackup: frase muito curta\")";
anywheresoftware.b4a.keywords.Common.LogImpl("75373954","ModBackup: frase muito curta",0);
 //BA.debugLineNum = 42;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 45;BA.debugLine="Try";
try { //BA.debugLineNum = 47;BA.debugLine="Dim backup As Map";
_backup = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 48;BA.debugLine="backup.Initialize";
_backup.Initialize();
 //BA.debugLineNum = 51;BA.debugLine="backup.Put(\"version\", BACKUP_VERSION)";
_backup.Put((Object)("version"),(Object)(_backup_version));
 //BA.debugLineNum = 52;BA.debugLine="backup.Put(\"appVersion\", Starter.APP_VERSION)";
_backup.Put((Object)("appVersion"),(Object)(mostCurrent._starter._app_version /*String*/ ));
 //BA.debugLineNum = 53;BA.debugLine="backup.Put(\"createdAt\", DateTime.Now)";
_backup.Put((Object)("createdAt"),(Object)(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
 //BA.debugLineNum = 54;BA.debugLine="backup.Put(\"deviceModel\", GetDeviceInfo)";
_backup.Put((Object)("deviceModel"),(Object)(_getdeviceinfo(_ba)));
 //BA.debugLineNum = 57;BA.debugLine="Dim groups As List = ModPasswords.GetAllGroups";
_groups = new anywheresoftware.b4a.objects.collections.List();
_groups = mostCurrent._modpasswords._getallgroups /*anywheresoftware.b4a.objects.collections.List*/ (_ba);
 //BA.debugLineNum = 58;BA.debugLine="Dim groupsList As List";
_groupslist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 59;BA.debugLine="groupsList.Initialize";
_groupslist.Initialize();
 //BA.debugLineNum = 60;BA.debugLine="For Each g As clsPasswordGroup In groups";
{
final anywheresoftware.b4a.BA.IterableList group15 = _groups;
final int groupLen15 = group15.getSize()
;int index15 = 0;
;
for (; index15 < groupLen15;index15++){
_g = (com.lockzero.clspasswordgroup)(group15.Get(index15));
 //BA.debugLineNum = 61;BA.debugLine="groupsList.Add(g.ToMap)";
_groupslist.Add((Object)(_g._tomap /*anywheresoftware.b4a.objects.collections.Map*/ ().getObject()));
 }
};
 //BA.debugLineNum = 63;BA.debugLine="backup.Put(\"groups\", groupsList)";
_backup.Put((Object)("groups"),(Object)(_groupslist.getObject()));
 //BA.debugLineNum = 66;BA.debugLine="Dim entries As List = ModPasswords.GetAllEntries";
_entries = new anywheresoftware.b4a.objects.collections.List();
_entries = mostCurrent._modpasswords._getallentries /*anywheresoftware.b4a.objects.collections.List*/ (_ba);
 //BA.debugLineNum = 67;BA.debugLine="Dim entriesList As List";
_entrieslist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 68;BA.debugLine="entriesList.Initialize";
_entrieslist.Initialize();
 //BA.debugLineNum = 69;BA.debugLine="For Each e As clsPasswordEntry In entries";
{
final anywheresoftware.b4a.BA.IterableList group22 = _entries;
final int groupLen22 = group22.getSize()
;int index22 = 0;
;
for (; index22 < groupLen22;index22++){
_e = (com.lockzero.clspasswordentry)(group22.Get(index22));
 //BA.debugLineNum = 70;BA.debugLine="entriesList.Add(e.ToMap)";
_entrieslist.Add((Object)(_e._tomap /*anywheresoftware.b4a.objects.collections.Map*/ ().getObject()));
 }
};
 //BA.debugLineNum = 72;BA.debugLine="backup.Put(\"entries\", entriesList)";
_backup.Put((Object)("entries"),(Object)(_entrieslist.getObject()));
 //BA.debugLineNum = 75;BA.debugLine="Dim notes As List = ModNotes.ExportAll";
_notes = new anywheresoftware.b4a.objects.collections.List();
_notes = mostCurrent._modnotes._exportall /*anywheresoftware.b4a.objects.collections.List*/ (_ba);
 //BA.debugLineNum = 76;BA.debugLine="backup.Put(\"notes\", notes)";
_backup.Put((Object)("notes"),(Object)(_notes.getObject()));
 //BA.debugLineNum = 79;BA.debugLine="Dim stats As Map";
_stats = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 80;BA.debugLine="stats.Initialize";
_stats.Initialize();
 //BA.debugLineNum = 81;BA.debugLine="stats.Put(\"totalGroups\", groups.Size)";
_stats.Put((Object)("totalGroups"),(Object)(_groups.getSize()));
 //BA.debugLineNum = 82;BA.debugLine="stats.Put(\"totalEntries\", entries.Size)";
_stats.Put((Object)("totalEntries"),(Object)(_entries.getSize()));
 //BA.debugLineNum = 83;BA.debugLine="stats.Put(\"totalNotes\", notes.Size)";
_stats.Put((Object)("totalNotes"),(Object)(_notes.getSize()));
 //BA.debugLineNum = 84;BA.debugLine="backup.Put(\"stats\", stats)";
_backup.Put((Object)("stats"),(Object)(_stats.getObject()));
 //BA.debugLineNum = 87;BA.debugLine="Dim gen As JSONGenerator";
_gen = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 88;BA.debugLine="gen.Initialize(backup)";
_gen.Initialize(_backup);
 //BA.debugLineNum = 89;BA.debugLine="Dim jsonData As String = gen.ToString";
_jsondata = _gen.ToString();
 //BA.debugLineNum = 92;BA.debugLine="Dim checksum As String = CalculateChecksum(jsonD";
_checksum = _calculatechecksum(_ba,_jsondata);
 //BA.debugLineNum = 95;BA.debugLine="Dim finalData As Map";
_finaldata = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 96;BA.debugLine="finalData.Initialize";
_finaldata.Initialize();
 //BA.debugLineNum = 97;BA.debugLine="finalData.Put(\"checksum\", checksum)";
_finaldata.Put((Object)("checksum"),(Object)(_checksum));
 //BA.debugLineNum = 98;BA.debugLine="finalData.Put(\"data\", jsonData)";
_finaldata.Put((Object)("data"),(Object)(_jsondata));
 //BA.debugLineNum = 100;BA.debugLine="Dim genFinal As JSONGenerator";
_genfinal = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 101;BA.debugLine="genFinal.Initialize(finalData)";
_genfinal.Initialize(_finaldata);
 //BA.debugLineNum = 102;BA.debugLine="Dim plainText As String = genFinal.ToString";
_plaintext = _genfinal.ToString();
 //BA.debugLineNum = 105;BA.debugLine="Dim encrypted As String = ModSecurity.Encrypt(ba";
_encrypted = mostCurrent._modsecurity._encrypt /*String*/ (_ba,_backupphrase,_plaintext);
 //BA.debugLineNum = 107;BA.debugLine="If encrypted = \"\" Then";
if ((_encrypted).equals("")) { 
 //BA.debugLineNum = 108;BA.debugLine="Log(\"ModBackup: erro ao criptografar\")";
anywheresoftware.b4a.keywords.Common.LogImpl("75374021","ModBackup: erro ao criptografar",0);
 //BA.debugLineNum = 109;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 113;BA.debugLine="Dim fileName As String = GenerateBackupFileName";
_filename = _generatebackupfilename(_ba);
 //BA.debugLineNum = 116;BA.debugLine="File.WriteString(destFolder, fileName, encrypted";
anywheresoftware.b4a.keywords.Common.File.WriteString(_destfolder,_filename,_encrypted);
 //BA.debugLineNum = 118;BA.debugLine="Dim fullPath As String = File.Combine(destFolder";
_fullpath = anywheresoftware.b4a.keywords.Common.File.Combine(_destfolder,_filename);
 //BA.debugLineNum = 121;BA.debugLine="LastBackupPath = fullPath";
_lastbackuppath = _fullpath;
 //BA.debugLineNum = 122;BA.debugLine="LastBackupTime = DateTime.Now";
_lastbackuptime = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 //BA.debugLineNum = 123;BA.debugLine="SaveBackupInfo";
_savebackupinfo(_ba);
 //BA.debugLineNum = 125;BA.debugLine="Log(\"ModBackup: backup criado em \" & fullPath)";
anywheresoftware.b4a.keywords.Common.LogImpl("75374038","ModBackup: backup criado em "+_fullpath,0);
 //BA.debugLineNum = 126;BA.debugLine="Return fullPath";
if (true) return _fullpath;
 } 
       catch (Exception e59) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e59); //BA.debugLineNum = 129;BA.debugLine="Log(\"ModBackup.ExportBackup erro: \" & LastExcept";
anywheresoftware.b4a.keywords.Common.LogImpl("75374042","ModBackup.ExportBackup erro: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 //BA.debugLineNum = 130;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 132;BA.debugLine="End Sub";
return "";
}
public static String  _exporttoshared(anywheresoftware.b4a.BA _ba,String _backupphrase) throws Exception{
String _fullpath = "";
String _filename = "";
 //BA.debugLineNum = 462;BA.debugLine="Public Sub ExportToShared(backupPhrase As String)";
 //BA.debugLineNum = 463;BA.debugLine="InitSharedFolder";
_initsharedfolder(_ba);
 //BA.debugLineNum = 464;BA.debugLine="Dim fullPath As String = ExportBackup(backupPhras";
_fullpath = _exportbackup(_ba,_backupphrase,_sharedfolder);
 //BA.debugLineNum = 465;BA.debugLine="If fullPath <> \"\" Then";
if ((_fullpath).equals("") == false) { 
 //BA.debugLineNum = 467;BA.debugLine="Dim fileName As String = fullPath.SubString(full";
_filename = _fullpath.substring((int) (_fullpath.lastIndexOf("/")+1));
 //BA.debugLineNum = 468;BA.debugLine="Return fileName";
if (true) return _filename;
 };
 //BA.debugLineNum = 470;BA.debugLine="Return \"\"";
if (true) return "";
 //BA.debugLineNum = 471;BA.debugLine="End Sub";
return "";
}
public static String  _generatebackupfilename(anywheresoftware.b4a.BA _ba) throws Exception{
String _timestamp = "";
 //BA.debugLineNum = 344;BA.debugLine="Private Sub GenerateBackupFileName As String";
 //BA.debugLineNum = 345;BA.debugLine="DateTime.DateFormat = \"yyyyMMdd_HHmmss\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("yyyyMMdd_HHmmss");
 //BA.debugLineNum = 346;BA.debugLine="Dim timestamp As String = DateTime.Date(DateTime.";
_timestamp = anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
 //BA.debugLineNum = 347;BA.debugLine="Return \"lockzero_backup_\" & timestamp & BACKUP_EX";
if (true) return "lockzero_backup_"+_timestamp+_backup_extension;
 //BA.debugLineNum = 348;BA.debugLine="End Sub";
return "";
}
public static String  _getdeviceinfo(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 367;BA.debugLine="Private Sub GetDeviceInfo As String";
 //BA.debugLineNum = 368;BA.debugLine="Try";
try { //BA.debugLineNum = 369;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 370;BA.debugLine="jo.InitializeStatic(\"android.os.Build\")";
_jo.InitializeStatic("android.os.Build");
 //BA.debugLineNum = 371;BA.debugLine="Return jo.GetField(\"MODEL\")";
if (true) return BA.ObjectToString(_jo.GetField("MODEL"));
 } 
       catch (Exception e6) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e6); //BA.debugLineNum = 373;BA.debugLine="Log(\"ModBackup.GetDeviceInfo erro: \" & LastExcep";
anywheresoftware.b4a.keywords.Common.LogImpl("76160390","ModBackup.GetDeviceInfo erro: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 //BA.debugLineNum = 374;BA.debugLine="Return \"Unknown\"";
if (true) return "Unknown";
 };
 //BA.debugLineNum = 376;BA.debugLine="End Sub";
return "";
}
public static Object  _getfileuri(anywheresoftware.b4a.BA _ba,String _filename) throws Exception{
String _folder = "";
anywheresoftware.b4j.object.JavaObject _f = null;
anywheresoftware.b4j.object.JavaObject _fp = null;
anywheresoftware.b4j.object.JavaObject _context = null;
 //BA.debugLineNum = 429;BA.debugLine="Public Sub GetFileUri(fileName As String) As Objec";
 //BA.debugLineNum = 430;BA.debugLine="Dim folder As String = GetSharedFolder";
_folder = _getsharedfolder(_ba);
 //BA.debugLineNum = 431;BA.debugLine="Dim f As JavaObject";
_f = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 432;BA.debugLine="f.InitializeNewInstance(\"java.io.File\", Array(fol";
_f.InitializeNewInstance("java.io.File",new Object[]{(Object)(_folder),(Object)(_filename)});
 //BA.debugLineNum = 433;BA.debugLine="Dim fp As JavaObject";
_fp = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 434;BA.debugLine="Dim context As JavaObject";
_context = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 435;BA.debugLine="context.InitializeContext";
_context.InitializeContext((_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 437;BA.debugLine="fp.InitializeStatic(\"androidx.core.content.FilePr";
_fp.InitializeStatic("androidx.core.content.FileProvider");
 //BA.debugLineNum = 438;BA.debugLine="Return fp.RunMethod(\"getUriForFile\", Array(contex";
if (true) return _fp.RunMethod("getUriForFile",new Object[]{(Object)(_context.getObject()),(Object)(anywheresoftware.b4a.keywords.Common.Application.getPackageName()+".provider"),(Object)(_f.getObject())});
 //BA.debugLineNum = 439;BA.debugLine="End Sub";
return null;
}
public static String  _getlastbackuppath(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 305;BA.debugLine="Public Sub GetLastBackupPath As String";
 //BA.debugLineNum = 306;BA.debugLine="LoadBackupInfo";
_loadbackupinfo(_ba);
 //BA.debugLineNum = 307;BA.debugLine="Return LastBackupPath";
if (true) return _lastbackuppath;
 //BA.debugLineNum = 308;BA.debugLine="End Sub";
return "";
}
public static long  _getlastbackuptime(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 310;BA.debugLine="Public Sub GetLastBackupTime As Long";
 //BA.debugLineNum = 311;BA.debugLine="LoadBackupInfo";
_loadbackupinfo(_ba);
 //BA.debugLineNum = 312;BA.debugLine="Return LastBackupTime";
if (true) return _lastbackuptime;
 //BA.debugLineNum = 313;BA.debugLine="End Sub";
return 0L;
}
public static String  _getlastbackuptimeformatted(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 315;BA.debugLine="Public Sub GetLastBackupTimeFormatted As String";
 //BA.debugLineNum = 316;BA.debugLine="LoadBackupInfo";
_loadbackupinfo(_ba);
 //BA.debugLineNum = 317;BA.debugLine="If LastBackupTime = 0 Then Return \"Nunca\"";
if (_lastbackuptime==0) { 
if (true) return "Nunca";};
 //BA.debugLineNum = 318;BA.debugLine="DateTime.DateFormat = \"dd/MM/yyyy HH:mm\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("dd/MM/yyyy HH:mm");
 //BA.debugLineNum = 319;BA.debugLine="Return DateTime.Date(LastBackupTime)";
if (true) return anywheresoftware.b4a.keywords.Common.DateTime.Date(_lastbackuptime);
 //BA.debugLineNum = 320;BA.debugLine="End Sub";
return "";
}
public static String  _getsharedfolder(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 26;BA.debugLine="Public Sub GetSharedFolder As String";
 //BA.debugLineNum = 27;BA.debugLine="If SharedFolder = \"\" Then InitSharedFolder";
if ((_sharedfolder).equals("")) { 
_initsharedfolder(_ba);};
 //BA.debugLineNum = 28;BA.debugLine="Return SharedFolder";
if (true) return _sharedfolder;
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return "";
}
public static boolean  _hasbackup(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 322;BA.debugLine="Public Sub HasBackup As Boolean";
 //BA.debugLineNum = 323;BA.debugLine="LoadBackupInfo";
_loadbackupinfo(_ba);
 //BA.debugLineNum = 324;BA.debugLine="Return LastBackupTime > 0";
if (true) return _lastbackuptime>0;
 //BA.debugLineNum = 325;BA.debugLine="End Sub";
return false;
}
public static anywheresoftware.b4a.objects.collections.Map  _importbackup(anywheresoftware.b4a.BA _ba,String _backupphrase,String _sourcefolder,String _filename) throws Exception{
anywheresoftware.b4a.objects.collections.Map _result = null;
String _encrypted = "";
String _plaintext = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _finaldata = null;
String _savedchecksum = "";
String _jsondata = "";
String _calculatedchecksum = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser2 = null;
anywheresoftware.b4a.objects.collections.Map _backup = null;
int _version = 0;
int _groupsimported = 0;
anywheresoftware.b4a.objects.collections.List _groupslist = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
com.lockzero.clspasswordgroup _g = null;
int _entriesimported = 0;
anywheresoftware.b4a.objects.collections.List _entrieslist = null;
com.lockzero.clspasswordentry _e = null;
int _notesimported = 0;
anywheresoftware.b4a.objects.collections.List _noteslist = null;
anywheresoftware.b4a.objects.collections.Map _stats = null;
 //BA.debugLineNum = 142;BA.debugLine="Public Sub ImportBackup(backupPhrase As String, so";
 //BA.debugLineNum = 143;BA.debugLine="Dim result As Map";
_result = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 144;BA.debugLine="result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 145;BA.debugLine="result.Put(\"success\", False)";
_result.Put((Object)("success"),(Object)(anywheresoftware.b4a.keywords.Common.False));
 //BA.debugLineNum = 146;BA.debugLine="result.Put(\"message\", \"\")";
_result.Put((Object)("message"),(Object)(""));
 //BA.debugLineNum = 147;BA.debugLine="result.Put(\"stats\", Null)";
_result.Put((Object)("stats"),anywheresoftware.b4a.keywords.Common.Null);
 //BA.debugLineNum = 149;BA.debugLine="Try";
try { //BA.debugLineNum = 151;BA.debugLine="If File.Exists(sourceFolder, fileName) = False T";
if (anywheresoftware.b4a.keywords.Common.File.Exists(_sourcefolder,_filename)==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 152;BA.debugLine="result.Put(\"message\", \"Arquivo nao encontrado\")";
_result.Put((Object)("message"),(Object)("Arquivo nao encontrado"));
 //BA.debugLineNum = 153;BA.debugLine="Return result";
if (true) return _result;
 };
 //BA.debugLineNum = 157;BA.debugLine="Dim encrypted As String = File.ReadString(source";
_encrypted = anywheresoftware.b4a.keywords.Common.File.ReadString(_sourcefolder,_filename);
 //BA.debugLineNum = 159;BA.debugLine="If encrypted.Length < 10 Then";
if (_encrypted.length()<10) { 
 //BA.debugLineNum = 160;BA.debugLine="result.Put(\"message\", \"Arquivo vazio ou corromp";
_result.Put((Object)("message"),(Object)("Arquivo vazio ou corrompido"));
 //BA.debugLineNum = 161;BA.debugLine="Return result";
if (true) return _result;
 };
 //BA.debugLineNum = 165;BA.debugLine="Dim plainText As String = ModSecurity.Decrypt(ba";
_plaintext = mostCurrent._modsecurity._decrypt /*String*/ (_ba,_backupphrase,_encrypted);
 //BA.debugLineNum = 167;BA.debugLine="If plainText = \"\" Then";
if ((_plaintext).equals("")) { 
 //BA.debugLineNum = 168;BA.debugLine="result.Put(\"message\", ModLang.T(\"backup_wrong_p";
_result.Put((Object)("message"),(Object)(mostCurrent._modlang._t /*String*/ (_ba,"backup_wrong_phrase")));
 //BA.debugLineNum = 169;BA.debugLine="Return result";
if (true) return _result;
 };
 //BA.debugLineNum = 173;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 174;BA.debugLine="parser.Initialize(plainText)";
_parser.Initialize(_plaintext);
 //BA.debugLineNum = 175;BA.debugLine="Dim finalData As Map = parser.NextObject";
_finaldata = new anywheresoftware.b4a.objects.collections.Map();
_finaldata = _parser.NextObject();
 //BA.debugLineNum = 177;BA.debugLine="Dim savedChecksum As String = finalData.Get(\"che";
_savedchecksum = BA.ObjectToString(_finaldata.Get((Object)("checksum")));
 //BA.debugLineNum = 178;BA.debugLine="Dim jsonData As String = finalData.Get(\"data\")";
_jsondata = BA.ObjectToString(_finaldata.Get((Object)("data")));
 //BA.debugLineNum = 181;BA.debugLine="Dim calculatedChecksum As String = CalculateChec";
_calculatedchecksum = _calculatechecksum(_ba,_jsondata);
 //BA.debugLineNum = 182;BA.debugLine="If savedChecksum <> calculatedChecksum Then";
if ((_savedchecksum).equals(_calculatedchecksum) == false) { 
 //BA.debugLineNum = 183;BA.debugLine="result.Put(\"message\", \"Checksum invalido - arqu";
_result.Put((Object)("message"),(Object)("Checksum invalido - arquivo corrompido"));
 //BA.debugLineNum = 184;BA.debugLine="Return result";
if (true) return _result;
 };
 //BA.debugLineNum = 188;BA.debugLine="Dim parser2 As JSONParser";
_parser2 = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 189;BA.debugLine="parser2.Initialize(jsonData)";
_parser2.Initialize(_jsondata);
 //BA.debugLineNum = 190;BA.debugLine="Dim backup As Map = parser2.NextObject";
_backup = new anywheresoftware.b4a.objects.collections.Map();
_backup = _parser2.NextObject();
 //BA.debugLineNum = 193;BA.debugLine="Dim version As Int = backup.Get(\"version\")";
_version = (int)(BA.ObjectToNumber(_backup.Get((Object)("version"))));
 //BA.debugLineNum = 194;BA.debugLine="If version > BACKUP_VERSION Then";
if (_version>_backup_version) { 
 //BA.debugLineNum = 195;BA.debugLine="result.Put(\"message\", \"Versao do backup mais no";
_result.Put((Object)("message"),(Object)("Versao do backup mais nova que o app"));
 //BA.debugLineNum = 196;BA.debugLine="Return result";
if (true) return _result;
 };
 //BA.debugLineNum = 200;BA.debugLine="Dim groupsImported As Int = 0";
_groupsimported = (int) (0);
 //BA.debugLineNum = 201;BA.debugLine="If backup.ContainsKey(\"groups\") Then";
if (_backup.ContainsKey((Object)("groups"))) { 
 //BA.debugLineNum = 202;BA.debugLine="Dim groupsList As List = backup.Get(\"groups\")";
_groupslist = new anywheresoftware.b4a.objects.collections.List();
_groupslist = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_backup.Get((Object)("groups"))));
 //BA.debugLineNum = 203;BA.debugLine="For Each m As Map In groupsList";
_m = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group42 = _groupslist;
final int groupLen42 = group42.getSize()
;int index42 = 0;
;
for (; index42 < groupLen42;index42++){
_m = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group42.Get(index42)));
 //BA.debugLineNum = 204;BA.debugLine="Dim g As clsPasswordGroup";
_g = new com.lockzero.clspasswordgroup();
 //BA.debugLineNum = 205;BA.debugLine="g.Initialize";
_g._initialize /*String*/ ((_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 206;BA.debugLine="g.FromMap(m)";
_g._frommap /*String*/ (_m);
 //BA.debugLineNum = 207;BA.debugLine="ModPasswords.SaveGroup(g)";
mostCurrent._modpasswords._savegroup /*String*/ (_ba,_g);
 //BA.debugLineNum = 208;BA.debugLine="groupsImported = groupsImported + 1";
_groupsimported = (int) (_groupsimported+1);
 }
};
 };
 //BA.debugLineNum = 213;BA.debugLine="Dim entriesImported As Int = 0";
_entriesimported = (int) (0);
 //BA.debugLineNum = 214;BA.debugLine="If backup.ContainsKey(\"entries\") Then";
if (_backup.ContainsKey((Object)("entries"))) { 
 //BA.debugLineNum = 215;BA.debugLine="Dim entriesList As List = backup.Get(\"entries\")";
_entrieslist = new anywheresoftware.b4a.objects.collections.List();
_entrieslist = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_backup.Get((Object)("entries"))));
 //BA.debugLineNum = 216;BA.debugLine="For Each m As Map In entriesList";
_m = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group53 = _entrieslist;
final int groupLen53 = group53.getSize()
;int index53 = 0;
;
for (; index53 < groupLen53;index53++){
_m = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group53.Get(index53)));
 //BA.debugLineNum = 217;BA.debugLine="Dim e As clsPasswordEntry";
_e = new com.lockzero.clspasswordentry();
 //BA.debugLineNum = 218;BA.debugLine="e.Initialize";
_e._initialize /*String*/ ((_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 219;BA.debugLine="e.FromMap(m)";
_e._frommap /*String*/ (_m);
 //BA.debugLineNum = 220;BA.debugLine="ModPasswords.SaveEntry(e)";
mostCurrent._modpasswords._saveentry /*String*/ (_ba,_e);
 //BA.debugLineNum = 221;BA.debugLine="entriesImported = entriesImported + 1";
_entriesimported = (int) (_entriesimported+1);
 }
};
 };
 //BA.debugLineNum = 226;BA.debugLine="Dim notesImported As Int = 0";
_notesimported = (int) (0);
 //BA.debugLineNum = 227;BA.debugLine="If backup.ContainsKey(\"notes\") Then";
if (_backup.ContainsKey((Object)("notes"))) { 
 //BA.debugLineNum = 228;BA.debugLine="Dim notesList As List = backup.Get(\"notes\")";
_noteslist = new anywheresoftware.b4a.objects.collections.List();
_noteslist = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_backup.Get((Object)("notes"))));
 //BA.debugLineNum = 229;BA.debugLine="ModNotes.ImportAll(notesList)";
mostCurrent._modnotes._importall /*String*/ (_ba,_noteslist);
 //BA.debugLineNum = 230;BA.debugLine="notesImported = notesList.Size";
_notesimported = _noteslist.getSize();
 };
 //BA.debugLineNum = 234;BA.debugLine="Dim stats As Map";
_stats = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 235;BA.debugLine="stats.Initialize";
_stats.Initialize();
 //BA.debugLineNum = 236;BA.debugLine="stats.Put(\"groupsImported\", groupsImported)";
_stats.Put((Object)("groupsImported"),(Object)(_groupsimported));
 //BA.debugLineNum = 237;BA.debugLine="stats.Put(\"entriesImported\", entriesImported)";
_stats.Put((Object)("entriesImported"),(Object)(_entriesimported));
 //BA.debugLineNum = 238;BA.debugLine="stats.Put(\"notesImported\", notesImported)";
_stats.Put((Object)("notesImported"),(Object)(_notesimported));
 //BA.debugLineNum = 240;BA.debugLine="result.Put(\"success\", True)";
_result.Put((Object)("success"),(Object)(anywheresoftware.b4a.keywords.Common.True));
 //BA.debugLineNum = 241;BA.debugLine="result.Put(\"message\", \"Backup restaurado com suc";
_result.Put((Object)("message"),(Object)("Backup restaurado com sucesso"));
 //BA.debugLineNum = 242;BA.debugLine="result.Put(\"stats\", stats)";
_result.Put((Object)("stats"),(Object)(_stats.getObject()));
 //BA.debugLineNum = 244;BA.debugLine="Log(\"ModBackup: importado \" & groupsImported & \"";
anywheresoftware.b4a.keywords.Common.LogImpl("75439590","ModBackup: importado "+BA.NumberToString(_groupsimported)+" grupos, "+BA.NumberToString(_entriesimported)+" senhas, "+BA.NumberToString(_notesimported)+" notas",0);
 //BA.debugLineNum = 245;BA.debugLine="Return result";
if (true) return _result;
 } 
       catch (Exception e78) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e78); //BA.debugLineNum = 248;BA.debugLine="Log(\"ModBackup.ImportBackup erro: \" & LastExcept";
anywheresoftware.b4a.keywords.Common.LogImpl("75439594","ModBackup.ImportBackup erro: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 //BA.debugLineNum = 249;BA.debugLine="result.Put(\"message\", \"Erro ao importar: \" & Las";
_result.Put((Object)("message"),(Object)("Erro ao importar: "+anywheresoftware.b4a.keywords.Common.LastException(_ba).getMessage()));
 //BA.debugLineNum = 250;BA.debugLine="Return result";
if (true) return _result;
 };
 //BA.debugLineNum = 252;BA.debugLine="End Sub";
return null;
}
public static String  _initsharedfolder(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 18;BA.debugLine="Public Sub InitSharedFolder";
 //BA.debugLineNum = 19;BA.debugLine="SharedFolder = File.DirInternal & \"/shared\"";
_sharedfolder = anywheresoftware.b4a.keywords.Common.File.getDirInternal()+"/shared";
 //BA.debugLineNum = 20;BA.debugLine="If File.Exists(SharedFolder, \"\") = False Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(_sharedfolder,"")==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 21;BA.debugLine="File.MakeDir(SharedFolder, \"\")";
anywheresoftware.b4a.keywords.Common.File.MakeDir(_sharedfolder,"");
 };
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _listbackups(anywheresoftware.b4a.BA _ba,String _folder) throws Exception{
anywheresoftware.b4a.objects.collections.List _backups = null;
anywheresoftware.b4a.objects.collections.List _files = null;
String _f = "";
anywheresoftware.b4a.objects.collections.Map _info = null;
 //BA.debugLineNum = 400;BA.debugLine="Public Sub ListBackups(folder As String) As List";
 //BA.debugLineNum = 401;BA.debugLine="Dim backups As List";
_backups = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 402;BA.debugLine="backups.Initialize";
_backups.Initialize();
 //BA.debugLineNum = 404;BA.debugLine="Try";
try { //BA.debugLineNum = 405;BA.debugLine="Dim files As List = File.ListFiles(folder)";
_files = new anywheresoftware.b4a.objects.collections.List();
_files = anywheresoftware.b4a.keywords.Common.File.ListFiles(_folder);
 //BA.debugLineNum = 406;BA.debugLine="For Each f As String In files";
{
final anywheresoftware.b4a.BA.IterableList group5 = _files;
final int groupLen5 = group5.getSize()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_f = BA.ObjectToString(group5.Get(index5));
 //BA.debugLineNum = 407;BA.debugLine="If f.EndsWith(BACKUP_EXTENSION) Then";
if (_f.endsWith(_backup_extension)) { 
 //BA.debugLineNum = 408;BA.debugLine="Dim info As Map";
_info = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 409;BA.debugLine="info.Initialize";
_info.Initialize();
 //BA.debugLineNum = 410;BA.debugLine="info.Put(\"fileName\", f)";
_info.Put((Object)("fileName"),(Object)(_f));
 //BA.debugLineNum = 411;BA.debugLine="info.Put(\"fullPath\", File.Combine(folder, f))";
_info.Put((Object)("fullPath"),(Object)(anywheresoftware.b4a.keywords.Common.File.Combine(_folder,_f)));
 //BA.debugLineNum = 412;BA.debugLine="info.Put(\"size\", File.Size(folder, f))";
_info.Put((Object)("size"),(Object)(anywheresoftware.b4a.keywords.Common.File.Size(_folder,_f)));
 //BA.debugLineNum = 413;BA.debugLine="info.Put(\"lastModified\", File.LastModified(fol";
_info.Put((Object)("lastModified"),(Object)(anywheresoftware.b4a.keywords.Common.File.LastModified(_folder,_f)));
 //BA.debugLineNum = 414;BA.debugLine="backups.Add(info)";
_backups.Add((Object)(_info.getObject()));
 };
 }
};
 } 
       catch (Exception e17) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e17); //BA.debugLineNum = 418;BA.debugLine="Log(\"ModBackup.ListBackups erro: \" & LastExcepti";
anywheresoftware.b4a.keywords.Common.LogImpl("76291474","ModBackup.ListBackups erro: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 421;BA.debugLine="Return backups";
if (true) return _backups;
 //BA.debugLineNum = 422;BA.debugLine="End Sub";
return null;
}
public static String  _loadbackupinfo(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.Map _settings = null;
 //BA.debugLineNum = 334;BA.debugLine="Private Sub LoadBackupInfo";
 //BA.debugLineNum = 335;BA.debugLine="Dim settings As Map = ModSecurity.LoadSettings";
_settings = new anywheresoftware.b4a.objects.collections.Map();
_settings = mostCurrent._modsecurity._loadsettings /*anywheresoftware.b4a.objects.collections.Map*/ (_ba);
 //BA.debugLineNum = 336;BA.debugLine="LastBackupPath = settings.GetDefault(\"lastBackupP";
_lastbackuppath = BA.ObjectToString(_settings.GetDefault((Object)("lastBackupPath"),(Object)("")));
 //BA.debugLineNum = 337;BA.debugLine="LastBackupTime = settings.GetDefault(\"lastBackupT";
_lastbackuptime = BA.ObjectToLongNumber(_settings.GetDefault((Object)("lastBackupTime"),(Object)(0)));
 //BA.debugLineNum = 338;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 5;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Public Const BACKUP_VERSION As Int = 1";
_backup_version = (int) (1);
 //BA.debugLineNum = 7;BA.debugLine="Public Const BACKUP_EXTENSION As String = \".lockz";
_backup_extension = ".lockzero";
 //BA.debugLineNum = 10;BA.debugLine="Private LastBackupPath As String";
_lastbackuppath = "";
 //BA.debugLineNum = 11;BA.debugLine="Private LastBackupTime As Long";
_lastbackuptime = 0L;
 //BA.debugLineNum = 14;BA.debugLine="Private SharedFolder As String";
_sharedfolder = "";
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return "";
}
public static String  _savebackupinfo(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.Map _settings = null;
 //BA.debugLineNum = 327;BA.debugLine="Private Sub SaveBackupInfo";
 //BA.debugLineNum = 328;BA.debugLine="Dim settings As Map = ModSecurity.LoadSettings";
_settings = new anywheresoftware.b4a.objects.collections.Map();
_settings = mostCurrent._modsecurity._loadsettings /*anywheresoftware.b4a.objects.collections.Map*/ (_ba);
 //BA.debugLineNum = 329;BA.debugLine="settings.Put(\"lastBackupPath\", LastBackupPath)";
_settings.Put((Object)("lastBackupPath"),(Object)(_lastbackuppath));
 //BA.debugLineNum = 330;BA.debugLine="settings.Put(\"lastBackupTime\", LastBackupTime)";
_settings.Put((Object)("lastBackupTime"),(Object)(_lastbackuptime));
 //BA.debugLineNum = 331;BA.debugLine="ModSecurity.SaveSettings(settings)";
mostCurrent._modsecurity._savesettings /*String*/ (_ba,_settings);
 //BA.debugLineNum = 332;BA.debugLine="End Sub";
return "";
}
public static String  _sharebackupfile(anywheresoftware.b4a.BA _ba,String _filename) throws Exception{
Object _uri = null;
anywheresoftware.b4a.objects.IntentWrapper _shareintent = null;
 //BA.debugLineNum = 442;BA.debugLine="Public Sub ShareBackupFile(fileName As String)";
 //BA.debugLineNum = 443;BA.debugLine="Log(\"ShareBackupFile: \" & fileName)";
anywheresoftware.b4a.keywords.Common.LogImpl("763569921","ShareBackupFile: "+_filename,0);
 //BA.debugLineNum = 444;BA.debugLine="Try";
try { //BA.debugLineNum = 445;BA.debugLine="Dim uri As Object = GetFileUri(fileName)";
_uri = _getfileuri(_ba,_filename);
 //BA.debugLineNum = 446;BA.debugLine="Log(\"ShareBackupFile: URI obtido = \" & uri)";
anywheresoftware.b4a.keywords.Common.LogImpl("763569924","ShareBackupFile: URI obtido = "+BA.ObjectToString(_uri),0);
 //BA.debugLineNum = 448;BA.debugLine="Dim shareIntent As Intent";
_shareintent = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 449;BA.debugLine="shareIntent.Initialize(shareIntent.ACTION_SEND,";
_shareintent.Initialize(_shareintent.ACTION_SEND,"");
 //BA.debugLineNum = 450;BA.debugLine="shareIntent.SetType(\"application/octet-stream\")";
_shareintent.SetType("application/octet-stream");
 //BA.debugLineNum = 451;BA.debugLine="shareIntent.PutExtra(\"android.intent.extra.SUBJE";
_shareintent.PutExtra("android.intent.extra.SUBJECT",(Object)("LockZero Backup"));
 //BA.debugLineNum = 452;BA.debugLine="shareIntent.PutExtra(\"android.intent.extra.STREA";
_shareintent.PutExtra("android.intent.extra.STREAM",_uri);
 //BA.debugLineNum = 453;BA.debugLine="shareIntent.Flags = 1 'FLAG_GRANT_READ_URI_PERMI";
_shareintent.setFlags((int) (1));
 //BA.debugLineNum = 454;BA.debugLine="Log(\"ShareBackupFile: iniciando share...\")";
anywheresoftware.b4a.keywords.Common.LogImpl("763569932","ShareBackupFile: iniciando share...",0);
 //BA.debugLineNum = 455;BA.debugLine="StartActivity(shareIntent)";
anywheresoftware.b4a.keywords.Common.StartActivity((_ba.processBA == null ? _ba : _ba.processBA),(Object)(_shareintent.getObject()));
 } 
       catch (Exception e14) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e14); //BA.debugLineNum = 457;BA.debugLine="Log(\"ShareBackupFile ERRO: \" & LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("763569935","ShareBackupFile ERRO: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 459;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.Map  _validatebackup(anywheresoftware.b4a.BA _ba,String _backupphrase,String _sourcefolder,String _filename) throws Exception{
anywheresoftware.b4a.objects.collections.Map _result = null;
String _encrypted = "";
String _plaintext = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _finaldata = null;
String _jsondata = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser2 = null;
anywheresoftware.b4a.objects.collections.Map _backup = null;
 //BA.debugLineNum = 260;BA.debugLine="Public Sub ValidateBackup(backupPhrase As String,";
 //BA.debugLineNum = 261;BA.debugLine="Dim result As Map";
_result = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 262;BA.debugLine="result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 263;BA.debugLine="result.Put(\"valid\", False)";
_result.Put((Object)("valid"),(Object)(anywheresoftware.b4a.keywords.Common.False));
 //BA.debugLineNum = 264;BA.debugLine="result.Put(\"version\", 0)";
_result.Put((Object)("version"),(Object)(0));
 //BA.debugLineNum = 265;BA.debugLine="result.Put(\"stats\", Null)";
_result.Put((Object)("stats"),anywheresoftware.b4a.keywords.Common.Null);
 //BA.debugLineNum = 266;BA.debugLine="result.Put(\"createdAt\", 0)";
_result.Put((Object)("createdAt"),(Object)(0));
 //BA.debugLineNum = 268;BA.debugLine="Try";
try { //BA.debugLineNum = 269;BA.debugLine="If File.Exists(sourceFolder, fileName) = False T";
if (anywheresoftware.b4a.keywords.Common.File.Exists(_sourcefolder,_filename)==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 270;BA.debugLine="Return result";
if (true) return _result;
 };
 //BA.debugLineNum = 273;BA.debugLine="Dim encrypted As String = File.ReadString(source";
_encrypted = anywheresoftware.b4a.keywords.Common.File.ReadString(_sourcefolder,_filename);
 //BA.debugLineNum = 274;BA.debugLine="Dim plainText As String = ModSecurity.Decrypt(ba";
_plaintext = mostCurrent._modsecurity._decrypt /*String*/ (_ba,_backupphrase,_encrypted);
 //BA.debugLineNum = 276;BA.debugLine="If plainText = \"\" Then Return result";
if ((_plaintext).equals("")) { 
if (true) return _result;};
 //BA.debugLineNum = 279;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 280;BA.debugLine="parser.Initialize(plainText)";
_parser.Initialize(_plaintext);
 //BA.debugLineNum = 281;BA.debugLine="Dim finalData As Map = parser.NextObject";
_finaldata = new anywheresoftware.b4a.objects.collections.Map();
_finaldata = _parser.NextObject();
 //BA.debugLineNum = 283;BA.debugLine="Dim jsonData As String = finalData.Get(\"data\")";
_jsondata = BA.ObjectToString(_finaldata.Get((Object)("data")));
 //BA.debugLineNum = 285;BA.debugLine="Dim parser2 As JSONParser";
_parser2 = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 286;BA.debugLine="parser2.Initialize(jsonData)";
_parser2.Initialize(_jsondata);
 //BA.debugLineNum = 287;BA.debugLine="Dim backup As Map = parser2.NextObject";
_backup = new anywheresoftware.b4a.objects.collections.Map();
_backup = _parser2.NextObject();
 //BA.debugLineNum = 289;BA.debugLine="result.Put(\"valid\", True)";
_result.Put((Object)("valid"),(Object)(anywheresoftware.b4a.keywords.Common.True));
 //BA.debugLineNum = 290;BA.debugLine="result.Put(\"version\", backup.GetDefault(\"version";
_result.Put((Object)("version"),_backup.GetDefault((Object)("version"),(Object)(0)));
 //BA.debugLineNum = 291;BA.debugLine="result.Put(\"createdAt\", backup.GetDefault(\"creat";
_result.Put((Object)("createdAt"),_backup.GetDefault((Object)("createdAt"),(Object)(0)));
 //BA.debugLineNum = 292;BA.debugLine="result.Put(\"stats\", backup.GetDefault(\"stats\", N";
_result.Put((Object)("stats"),_backup.GetDefault((Object)("stats"),anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 294;BA.debugLine="Return result";
if (true) return _result;
 } 
       catch (Exception e27) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e27); //BA.debugLineNum = 297;BA.debugLine="Return result";
if (true) return _result;
 };
 //BA.debugLineNum = 299;BA.debugLine="End Sub";
return null;
}
}
