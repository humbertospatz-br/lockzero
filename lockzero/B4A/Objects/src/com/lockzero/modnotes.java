package com.lockzero;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class modnotes {
private static modnotes mostCurrent = new modnotes();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public static String _notes_file = "";
public static anywheresoftware.b4a.objects.collections.List _notes = null;
public static boolean _minitialized = false;
public b4a.example.dateutils _dateutils = null;
public com.lockzero.main _main = null;
public com.lockzero.starter _starter = null;
public com.lockzero.modbackup _modbackup = null;
public com.lockzero.modlang _modlang = null;
public com.lockzero.modpasswords _modpasswords = null;
public com.lockzero.modsecurity _modsecurity = null;
public com.lockzero.modsession _modsession = null;
public com.lockzero.modtheme _modtheme = null;
public com.lockzero.b4xpages _b4xpages = null;
public com.lockzero.b4xcollections _b4xcollections = null;
public com.lockzero.xuiviewsutils _xuiviewsutils = null;
public static int  _countbygroup(anywheresoftware.b4a.BA _ba,String _groupid) throws Exception{
int _count = 0;
int _i = 0;
com.lockzero.clsnoteentry _note = null;
 //BA.debugLineNum = 167;BA.debugLine="Public Sub CountByGroup(groupId As String) As Int";
 //BA.debugLineNum = 168;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 169;BA.debugLine="Dim count As Int = 0";
_count = (int) (0);
 //BA.debugLineNum = 171;BA.debugLine="For i = 0 To Notes.Size - 1";
{
final int step3 = 1;
final int limit3 = (int) (_notes.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 172;BA.debugLine="Dim note As clsNoteEntry = Notes.Get(i)";
_note = (com.lockzero.clsnoteentry)(_notes.Get(_i));
 //BA.debugLineNum = 173;BA.debugLine="If note.GroupId = groupId Then";
if ((_note._groupid /*String*/ ).equals(_groupid)) { 
 //BA.debugLineNum = 174;BA.debugLine="count = count + 1";
_count = (int) (_count+1);
 };
 }
};
 //BA.debugLineNum = 178;BA.debugLine="Return count";
if (true) return _count;
 //BA.debugLineNum = 179;BA.debugLine="End Sub";
return 0;
}
public static String  _deletenote(anywheresoftware.b4a.BA _ba,String _noteid) throws Exception{
int _i = 0;
com.lockzero.clsnoteentry _note = null;
 //BA.debugLineNum = 135;BA.debugLine="Public Sub DeleteNote(noteId As String)";
 //BA.debugLineNum = 136;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 138;BA.debugLine="For i = Notes.Size - 1 To 0 Step -1";
{
final int step2 = -1;
final int limit2 = (int) (0);
_i = (int) (_notes.getSize()-1) ;
for (;_i >= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 139;BA.debugLine="Dim note As clsNoteEntry = Notes.Get(i)";
_note = (com.lockzero.clsnoteentry)(_notes.Get(_i));
 //BA.debugLineNum = 140;BA.debugLine="If note.Id = noteId Then";
if ((_note._id /*String*/ ).equals(_noteid)) { 
 //BA.debugLineNum = 141;BA.debugLine="Notes.RemoveAt(i)";
_notes.RemoveAt(_i);
 //BA.debugLineNum = 142;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 146;BA.debugLine="SaveNotes";
_savenotes(_ba);
 //BA.debugLineNum = 147;BA.debugLine="End Sub";
return "";
}
public static String  _ensureinit(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 25;BA.debugLine="Private Sub EnsureInit";
 //BA.debugLineNum = 26;BA.debugLine="If mInitialized = False Then Init";
if (_minitialized==anywheresoftware.b4a.keywords.Common.False) { 
_init(_ba);};
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _exportall(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.List _result = null;
int _i = 0;
com.lockzero.clsnoteentry _note = null;
 //BA.debugLineNum = 231;BA.debugLine="Public Sub ExportAll As List";
 //BA.debugLineNum = 232;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 233;BA.debugLine="Dim result As List";
_result = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 234;BA.debugLine="result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 236;BA.debugLine="For i = 0 To Notes.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (_notes.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 237;BA.debugLine="Dim note As clsNoteEntry = Notes.Get(i)";
_note = (com.lockzero.clsnoteentry)(_notes.Get(_i));
 //BA.debugLineNum = 238;BA.debugLine="result.Add(note.ToMap)";
_result.Add((Object)(_note._tomap /*anywheresoftware.b4a.objects.collections.Map*/ ().getObject()));
 }
};
 //BA.debugLineNum = 241;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 242;BA.debugLine="End Sub";
return null;
}
public static String  _forcereload(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 19;BA.debugLine="Public Sub ForceReload";
 //BA.debugLineNum = 20;BA.debugLine="Notes.Initialize";
_notes.Initialize();
 //BA.debugLineNum = 21;BA.debugLine="LoadNotes";
_loadnotes(_ba);
 //BA.debugLineNum = 22;BA.debugLine="mInitialized = True";
_minitialized = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _getallnotes(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 50;BA.debugLine="Public Sub GetAllNotes As List";
 //BA.debugLineNum = 51;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 52;BA.debugLine="Return Notes";
if (true) return _notes;
 //BA.debugLineNum = 53;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _getfavorites(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.List _result = null;
int _i = 0;
com.lockzero.clsnoteentry _note = null;
 //BA.debugLineNum = 56;BA.debugLine="Public Sub GetFavorites As List";
 //BA.debugLineNum = 57;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 58;BA.debugLine="Dim result As List";
_result = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 59;BA.debugLine="result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 61;BA.debugLine="For i = 0 To Notes.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (_notes.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 62;BA.debugLine="Dim note As clsNoteEntry = Notes.Get(i)";
_note = (com.lockzero.clsnoteentry)(_notes.Get(_i));
 //BA.debugLineNum = 63;BA.debugLine="If note.IsFavorite Then";
if (_note._isfavorite /*boolean*/ ) { 
 //BA.debugLineNum = 64;BA.debugLine="result.Add(note)";
_result.Add((Object)(_note));
 };
 }
};
 //BA.debugLineNum = 68;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 69;BA.debugLine="End Sub";
return null;
}
public static com.lockzero.clsnoteentry  _getnotebyid(anywheresoftware.b4a.BA _ba,String _noteid) throws Exception{
int _i = 0;
com.lockzero.clsnoteentry _note = null;
 //BA.debugLineNum = 92;BA.debugLine="Public Sub GetNoteById(noteId As String) As clsNot";
 //BA.debugLineNum = 93;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 95;BA.debugLine="For i = 0 To Notes.Size - 1";
{
final int step2 = 1;
final int limit2 = (int) (_notes.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 96;BA.debugLine="Dim note As clsNoteEntry = Notes.Get(i)";
_note = (com.lockzero.clsnoteentry)(_notes.Get(_i));
 //BA.debugLineNum = 97;BA.debugLine="If note.Id = noteId Then";
if ((_note._id /*String*/ ).equals(_noteid)) { 
 //BA.debugLineNum = 98;BA.debugLine="Return note";
if (true) return _note;
 };
 }
};
 //BA.debugLineNum = 102;BA.debugLine="Return Null";
if (true) return (com.lockzero.clsnoteentry)(anywheresoftware.b4a.keywords.Common.Null);
 //BA.debugLineNum = 103;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _getnotesbygroup(anywheresoftware.b4a.BA _ba,String _groupid) throws Exception{
anywheresoftware.b4a.objects.collections.List _result = null;
int _i = 0;
com.lockzero.clsnoteentry _note = null;
 //BA.debugLineNum = 34;BA.debugLine="Public Sub GetNotesByGroup(groupId As String) As L";
 //BA.debugLineNum = 35;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 36;BA.debugLine="Dim result As List";
_result = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 37;BA.debugLine="result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 39;BA.debugLine="For i = 0 To Notes.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (_notes.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 40;BA.debugLine="Dim note As clsNoteEntry = Notes.Get(i)";
_note = (com.lockzero.clsnoteentry)(_notes.Get(_i));
 //BA.debugLineNum = 41;BA.debugLine="If note.GroupId = groupId Then";
if ((_note._groupid /*String*/ ).equals(_groupid)) { 
 //BA.debugLineNum = 42;BA.debugLine="result.Add(note)";
_result.Add((Object)(_note));
 };
 }
};
 //BA.debugLineNum = 46;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
return null;
}
public static String  _importall(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _noteslist) throws Exception{
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _m = null;
com.lockzero.clsnoteentry _note = null;
boolean _exists = false;
int _j = 0;
com.lockzero.clsnoteentry _existing = null;
 //BA.debugLineNum = 245;BA.debugLine="Public Sub ImportAll(notesList As List)";
 //BA.debugLineNum = 246;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 248;BA.debugLine="For i = 0 To notesList.Size - 1";
{
final int step2 = 1;
final int limit2 = (int) (_noteslist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 249;BA.debugLine="Dim m As Map = notesList.Get(i)";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_noteslist.Get(_i)));
 //BA.debugLineNum = 250;BA.debugLine="Dim note As clsNoteEntry";
_note = new com.lockzero.clsnoteentry();
 //BA.debugLineNum = 251;BA.debugLine="note.Initialize";
_note._initialize /*String*/ ((_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 252;BA.debugLine="note.FromMap(m)";
_note._frommap /*String*/ (_m);
 //BA.debugLineNum = 255;BA.debugLine="Dim exists As Boolean = False";
_exists = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 256;BA.debugLine="For j = 0 To Notes.Size - 1";
{
final int step8 = 1;
final int limit8 = (int) (_notes.getSize()-1);
_j = (int) (0) ;
for (;_j <= limit8 ;_j = _j + step8 ) {
 //BA.debugLineNum = 257;BA.debugLine="Dim existing As clsNoteEntry = Notes.Get(j)";
_existing = (com.lockzero.clsnoteentry)(_notes.Get(_j));
 //BA.debugLineNum = 258;BA.debugLine="If existing.Id = note.Id Then";
if ((_existing._id /*String*/ ).equals(_note._id /*String*/ )) { 
 //BA.debugLineNum = 259;BA.debugLine="exists = True";
_exists = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 260;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 264;BA.debugLine="If Not(exists) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_exists)) { 
 //BA.debugLineNum = 265;BA.debugLine="Notes.Add(note)";
_notes.Add((Object)(_note));
 };
 }
};
 //BA.debugLineNum = 269;BA.debugLine="SaveNotes";
_savenotes(_ba);
 //BA.debugLineNum = 270;BA.debugLine="End Sub";
return "";
}
public static String  _init(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Public Sub Init";
 //BA.debugLineNum = 15;BA.debugLine="If mInitialized Then Return";
if (_minitialized) { 
if (true) return "";};
 //BA.debugLineNum = 16;BA.debugLine="ForceReload";
_forcereload(_ba);
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public static String  _loadnotes(anywheresoftware.b4a.BA _ba) throws Exception{
String _json = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _data = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _m = null;
com.lockzero.clsnoteentry _note = null;
 //BA.debugLineNum = 185;BA.debugLine="Private Sub LoadNotes";
 //BA.debugLineNum = 186;BA.debugLine="Notes.Initialize";
_notes.Initialize();
 //BA.debugLineNum = 188;BA.debugLine="If File.Exists(File.DirInternal, NOTES_FILE) = Fa";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_notes_file)==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 190;BA.debugLine="Try";
try { //BA.debugLineNum = 191;BA.debugLine="Dim json As String = File.ReadString(File.DirInt";
_json = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_notes_file);
 //BA.debugLineNum = 192;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 193;BA.debugLine="parser.Initialize(json)";
_parser.Initialize(_json);
 //BA.debugLineNum = 194;BA.debugLine="Dim data As List = parser.NextArray";
_data = new anywheresoftware.b4a.objects.collections.List();
_data = _parser.NextArray();
 //BA.debugLineNum = 196;BA.debugLine="For i = 0 To data.Size - 1";
{
final int step8 = 1;
final int limit8 = (int) (_data.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit8 ;_i = _i + step8 ) {
 //BA.debugLineNum = 197;BA.debugLine="Dim m As Map = data.Get(i)";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_data.Get(_i)));
 //BA.debugLineNum = 198;BA.debugLine="Dim note As clsNoteEntry";
_note = new com.lockzero.clsnoteentry();
 //BA.debugLineNum = 199;BA.debugLine="note.Initialize";
_note._initialize /*String*/ ((_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 200;BA.debugLine="note.FromMap(m)";
_note._frommap /*String*/ (_m);
 //BA.debugLineNum = 201;BA.debugLine="Notes.Add(note)";
_notes.Add((Object)(_note));
 }
};
 } 
       catch (Exception e16) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e16); //BA.debugLineNum = 204;BA.debugLine="Log(\"ModNotes.LoadNotes erro: \" & LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("77864339","ModNotes.LoadNotes erro: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 206;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 4;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Private Const NOTES_FILE As String = \"lockzero_no";
_notes_file = "lockzero_notes.json";
 //BA.debugLineNum = 6;BA.debugLine="Private Notes As List";
_notes = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 7;BA.debugLine="Private mInitialized As Boolean = False";
_minitialized = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return "";
}
public static String  _savenote(anywheresoftware.b4a.BA _ba,com.lockzero.clsnoteentry _note) throws Exception{
boolean _found = false;
int _i = 0;
com.lockzero.clsnoteentry _existing = null;
 //BA.debugLineNum = 106;BA.debugLine="Public Sub SaveNote(note As clsNoteEntry)";
 //BA.debugLineNum = 107;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 110;BA.debugLine="If note.Id.Length = 0 Then";
if (_note._id /*String*/ .length()==0) { 
 //BA.debugLineNum = 111;BA.debugLine="note.Id = ModSecurity.GenerateUUID";
_note._id /*String*/  = mostCurrent._modsecurity._generateuuid /*String*/ (_ba);
 //BA.debugLineNum = 112;BA.debugLine="note.CreatedAt = DateTime.Now";
_note._createdat /*long*/  = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 };
 //BA.debugLineNum = 114;BA.debugLine="note.UpdatedAt = DateTime.Now";
_note._updatedat /*long*/  = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 //BA.debugLineNum = 117;BA.debugLine="Dim found As Boolean = False";
_found = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 118;BA.debugLine="For i = 0 To Notes.Size - 1";
{
final int step8 = 1;
final int limit8 = (int) (_notes.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit8 ;_i = _i + step8 ) {
 //BA.debugLineNum = 119;BA.debugLine="Dim existing As clsNoteEntry = Notes.Get(i)";
_existing = (com.lockzero.clsnoteentry)(_notes.Get(_i));
 //BA.debugLineNum = 120;BA.debugLine="If existing.Id = note.Id Then";
if ((_existing._id /*String*/ ).equals(_note._id /*String*/ )) { 
 //BA.debugLineNum = 121;BA.debugLine="Notes.Set(i, note)";
_notes.Set(_i,(Object)(_note));
 //BA.debugLineNum = 122;BA.debugLine="found = True";
_found = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 123;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 127;BA.debugLine="If Not(found) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_found)) { 
 //BA.debugLineNum = 128;BA.debugLine="Notes.Add(note)";
_notes.Add((Object)(_note));
 };
 //BA.debugLineNum = 131;BA.debugLine="SaveNotes";
_savenotes(_ba);
 //BA.debugLineNum = 132;BA.debugLine="End Sub";
return "";
}
public static String  _savenotes(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.List _list = null;
int _i = 0;
com.lockzero.clsnoteentry _note = null;
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _gen = null;
 //BA.debugLineNum = 208;BA.debugLine="Private Sub SaveNotes";
 //BA.debugLineNum = 209;BA.debugLine="Try";
try { //BA.debugLineNum = 210;BA.debugLine="Dim list As List";
_list = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 211;BA.debugLine="list.Initialize";
_list.Initialize();
 //BA.debugLineNum = 213;BA.debugLine="For i = 0 To Notes.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (_notes.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 214;BA.debugLine="Dim note As clsNoteEntry = Notes.Get(i)";
_note = (com.lockzero.clsnoteentry)(_notes.Get(_i));
 //BA.debugLineNum = 215;BA.debugLine="list.Add(note.ToMap)";
_list.Add((Object)(_note._tomap /*anywheresoftware.b4a.objects.collections.Map*/ ().getObject()));
 }
};
 //BA.debugLineNum = 218;BA.debugLine="Dim gen As JSONGenerator";
_gen = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 219;BA.debugLine="gen.Initialize2(list)";
_gen.Initialize2(_list);
 //BA.debugLineNum = 220;BA.debugLine="File.WriteString(File.DirInternal, NOTES_FILE, g";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_notes_file,_gen.ToString());
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12); //BA.debugLineNum = 222;BA.debugLine="Log(\"ModNotes.SaveNotes erro: \" & LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("77929870","ModNotes.SaveNotes erro: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 224;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _searchnotes(anywheresoftware.b4a.BA _ba,String _query,String _passphrase) throws Exception{
anywheresoftware.b4a.objects.collections.List _result = null;
String _querylower = "";
int _i = 0;
com.lockzero.clsnoteentry _note = null;
String _title = "";
String _content = "";
 //BA.debugLineNum = 72;BA.debugLine="Public Sub SearchNotes(query As String, passPhrase";
 //BA.debugLineNum = 73;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 74;BA.debugLine="Dim result As List";
_result = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 75;BA.debugLine="result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 76;BA.debugLine="Dim queryLower As String = query.ToLowerCase";
_querylower = _query.toLowerCase();
 //BA.debugLineNum = 78;BA.debugLine="For i = 0 To Notes.Size - 1";
{
final int step5 = 1;
final int limit5 = (int) (_notes.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 79;BA.debugLine="Dim note As clsNoteEntry = Notes.Get(i)";
_note = (com.lockzero.clsnoteentry)(_notes.Get(_i));
 //BA.debugLineNum = 80;BA.debugLine="Dim title As String = note.GetDecryptedTitle(pas";
_title = _note._getdecryptedtitle /*String*/ (_passphrase).toLowerCase();
 //BA.debugLineNum = 81;BA.debugLine="Dim content As String = note.GetDecryptedContent";
_content = _note._getdecryptedcontent /*String*/ (_passphrase).toLowerCase();
 //BA.debugLineNum = 83;BA.debugLine="If title.Contains(queryLower) Or content.Contain";
if (_title.contains(_querylower) || _content.contains(_querylower)) { 
 //BA.debugLineNum = 84;BA.debugLine="result.Add(note)";
_result.Add((Object)(_note));
 };
 }
};
 //BA.debugLineNum = 88;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 89;BA.debugLine="End Sub";
return null;
}
public static String  _togglefavorite(anywheresoftware.b4a.BA _ba,String _noteid) throws Exception{
int _i = 0;
com.lockzero.clsnoteentry _note = null;
 //BA.debugLineNum = 150;BA.debugLine="Public Sub ToggleFavorite(noteId As String)";
 //BA.debugLineNum = 151;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 153;BA.debugLine="For i = 0 To Notes.Size - 1";
{
final int step2 = 1;
final int limit2 = (int) (_notes.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 154;BA.debugLine="Dim note As clsNoteEntry = Notes.Get(i)";
_note = (com.lockzero.clsnoteentry)(_notes.Get(_i));
 //BA.debugLineNum = 155;BA.debugLine="If note.Id = noteId Then";
if ((_note._id /*String*/ ).equals(_noteid)) { 
 //BA.debugLineNum = 156;BA.debugLine="note.IsFavorite = Not(note.IsFavorite)";
_note._isfavorite /*boolean*/  = anywheresoftware.b4a.keywords.Common.Not(_note._isfavorite /*boolean*/ );
 //BA.debugLineNum = 157;BA.debugLine="note.UpdatedAt = DateTime.Now";
_note._updatedat /*long*/  = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 //BA.debugLineNum = 158;BA.debugLine="Notes.Set(i, note)";
_notes.Set(_i,(Object)(_note));
 //BA.debugLineNum = 159;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 163;BA.debugLine="SaveNotes";
_savenotes(_ba);
 //BA.debugLineNum = 164;BA.debugLine="End Sub";
return "";
}
}
