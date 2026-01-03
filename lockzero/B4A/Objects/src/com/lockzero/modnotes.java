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
public static int _data_version = 0;
public static anywheresoftware.b4a.objects.collections.List _notegroups = null;
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
public com.lockzero.modtransition _modtransition = null;
public com.lockzero.b4xpages _b4xpages = null;
public com.lockzero.b4xcollections _b4xcollections = null;
public com.lockzero.xuiviewsutils _xuiviewsutils = null;
public static String  _clearsystemgroup(anywheresoftware.b4a.BA _ba,String _groupid) throws Exception{
com.lockzero.clsnotegroup _grp = null;
int _i = 0;
com.lockzero.clsnoteentry _note = null;
 //BA.debugLineNum = 176;BA.debugLine="Public Sub ClearSystemGroup(groupId As String)";
 //BA.debugLineNum = 177;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 180;BA.debugLine="Dim grp As clsNoteGroup = GetNoteGroupById(groupI";
_grp = _getnotegroupbyid(_ba,_groupid);
 //BA.debugLineNum = 181;BA.debugLine="If grp = Null Or grp.IsSystem = False Then Return";
if (_grp== null || _grp._issystem /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 184;BA.debugLine="For i = Notes.Size - 1 To 0 Step -1";
{
final int step4 = -1;
final int limit4 = (int) (0);
_i = (int) (_notes.getSize()-1) ;
for (;_i >= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 185;BA.debugLine="Dim note As clsNoteEntry = Notes.Get(i)";
_note = (com.lockzero.clsnoteentry)(_notes.Get(_i));
 //BA.debugLineNum = 186;BA.debugLine="If note.GroupId = groupId Then";
if ((_note._groupid /*String*/ ).equals(_groupid)) { 
 //BA.debugLineNum = 187;BA.debugLine="Notes.RemoveAt(i)";
_notes.RemoveAt(_i);
 };
 }
};
 //BA.debugLineNum = 191;BA.debugLine="SaveData";
_savedata(_ba);
 //BA.debugLineNum = 192;BA.debugLine="Log(\"ModNotes: Grupo \" & groupId & \" limpo (\" & g";
anywheresoftware.b4a.keywords.Common.LogImpl("617432592","ModNotes: Grupo "+_groupid+" limpo ("+_grp._name /*String*/ +")",0);
 //BA.debugLineNum = 193;BA.debugLine="End Sub";
return "";
}
public static String  _copysecurityfromexistinggroup(anywheresoftware.b4a.BA _ba,com.lockzero.clsnotegroup _targetgroup) throws Exception{
int _i = 0;
com.lockzero.clsnotegroup _grp = null;
 //BA.debugLineNum = 159;BA.debugLine="Private Sub CopySecurityFromExistingGroup(targetGr";
 //BA.debugLineNum = 160;BA.debugLine="For i = 0 To NoteGroups.Size - 1";
{
final int step1 = 1;
final int limit1 = (int) (_notegroups.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit1 ;_i = _i + step1 ) {
 //BA.debugLineNum = 161;BA.debugLine="Dim grp As clsNoteGroup = NoteGroups.Get(i)";
_grp = (com.lockzero.clsnotegroup)(_notegroups.Get(_i));
 //BA.debugLineNum = 163;BA.debugLine="If grp.Id = targetGroup.Id Then Continue";
if ((_grp._id /*String*/ ).equals(_targetgroup._id /*String*/ )) { 
if (true) continue;};
 //BA.debugLineNum = 164;BA.debugLine="If grp.Salt = \"\" Or grp.TestValue = \"\" Then Cont";
if ((_grp._salt /*String*/ ).equals("") || (_grp._testvalue /*String*/ ).equals("")) { 
if (true) continue;};
 //BA.debugLineNum = 167;BA.debugLine="targetGroup.Salt = grp.Salt";
_targetgroup._salt /*String*/  = _grp._salt /*String*/ ;
 //BA.debugLineNum = 168;BA.debugLine="targetGroup.TestValue = grp.TestValue";
_targetgroup._testvalue /*String*/  = _grp._testvalue /*String*/ ;
 //BA.debugLineNum = 169;BA.debugLine="Log(\"ModNotes: Seguranca copiada de \" & grp.Name";
anywheresoftware.b4a.keywords.Common.LogImpl("617367050","ModNotes: Seguranca copiada de "+_grp._name /*String*/ +" para "+_targetgroup._name /*String*/ ,0);
 //BA.debugLineNum = 170;BA.debugLine="Return";
if (true) return "";
 }
};
 //BA.debugLineNum = 172;BA.debugLine="Log(\"ModNotes: Nenhum grupo com frase encontrado";
anywheresoftware.b4a.keywords.Common.LogImpl("617367053","ModNotes: Nenhum grupo com frase encontrado para copiar",0);
 //BA.debugLineNum = 173;BA.debugLine="End Sub";
return "";
}
public static int  _countbygroup(anywheresoftware.b4a.BA _ba,String _groupid) throws Exception{
int _count = 0;
int _i = 0;
com.lockzero.clsnoteentry _note = null;
 //BA.debugLineNum = 477;BA.debugLine="Public Sub CountByGroup(groupId As String) As Int";
 //BA.debugLineNum = 478;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 479;BA.debugLine="Dim count As Int = 0";
_count = (int) (0);
 //BA.debugLineNum = 481;BA.debugLine="For i = 0 To Notes.Size - 1";
{
final int step3 = 1;
final int limit3 = (int) (_notes.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 482;BA.debugLine="Dim note As clsNoteEntry = Notes.Get(i)";
_note = (com.lockzero.clsnoteentry)(_notes.Get(_i));
 //BA.debugLineNum = 483;BA.debugLine="If note.GroupId = groupId Then";
if ((_note._groupid /*String*/ ).equals(_groupid)) { 
 //BA.debugLineNum = 484;BA.debugLine="count = count + 1";
_count = (int) (_count+1);
 };
 }
};
 //BA.debugLineNum = 488;BA.debugLine="Return count";
if (true) return _count;
 //BA.debugLineNum = 489;BA.debugLine="End Sub";
return 0;
}
public static int  _countnotegroups(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 111;BA.debugLine="Public Sub CountNoteGroups As Int";
 //BA.debugLineNum = 112;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 113;BA.debugLine="Return NoteGroups.Size";
if (true) return _notegroups.getSize();
 //BA.debugLineNum = 114;BA.debugLine="End Sub";
return 0;
}
public static anywheresoftware.b4a.objects.collections.Map  _createitem(anywheresoftware.b4a.BA _ba,String _text) throws Exception{
anywheresoftware.b4a.objects.collections.Map _item = null;
 //BA.debugLineNum = 216;BA.debugLine="Private Sub CreateItem(text As String) As Map";
 //BA.debugLineNum = 217;BA.debugLine="Dim item As Map";
_item = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 218;BA.debugLine="item.Initialize";
_item.Initialize();
 //BA.debugLineNum = 219;BA.debugLine="item.Put(\"text\", text)";
_item.Put((Object)("text"),(Object)(_text));
 //BA.debugLineNum = 220;BA.debugLine="item.Put(\"checked\", False)";
_item.Put((Object)("checked"),(Object)(anywheresoftware.b4a.keywords.Common.False));
 //BA.debugLineNum = 221;BA.debugLine="Return item";
if (true) return _item;
 //BA.debugLineNum = 222;BA.debugLine="End Sub";
return null;
}
public static String  _deletenote(anywheresoftware.b4a.BA _ba,String _noteid) throws Exception{
int _i = 0;
com.lockzero.clsnoteentry _note = null;
 //BA.debugLineNum = 445;BA.debugLine="Public Sub DeleteNote(noteId As String)";
 //BA.debugLineNum = 446;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 448;BA.debugLine="For i = Notes.Size - 1 To 0 Step -1";
{
final int step2 = -1;
final int limit2 = (int) (0);
_i = (int) (_notes.getSize()-1) ;
for (;_i >= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 449;BA.debugLine="Dim note As clsNoteEntry = Notes.Get(i)";
_note = (com.lockzero.clsnoteentry)(_notes.Get(_i));
 //BA.debugLineNum = 450;BA.debugLine="If note.Id = noteId Then";
if ((_note._id /*String*/ ).equals(_noteid)) { 
 //BA.debugLineNum = 451;BA.debugLine="Notes.RemoveAt(i)";
_notes.RemoveAt(_i);
 //BA.debugLineNum = 452;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 456;BA.debugLine="SaveData";
_savedata(_ba);
 //BA.debugLineNum = 457;BA.debugLine="End Sub";
return "";
}
public static String  _deletenotegroup(anywheresoftware.b4a.BA _ba,String _groupid) throws Exception{
int _i = 0;
com.lockzero.clsnotegroup _grp = null;
com.lockzero.clsnoteentry _note = null;
 //BA.debugLineNum = 87;BA.debugLine="Public Sub DeleteNoteGroup(groupId As String)";
 //BA.debugLineNum = 88;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 91;BA.debugLine="For i = NoteGroups.Size - 1 To 0 Step -1";
{
final int step2 = -1;
final int limit2 = (int) (0);
_i = (int) (_notegroups.getSize()-1) ;
for (;_i >= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 92;BA.debugLine="Dim grp As clsNoteGroup = NoteGroups.Get(i)";
_grp = (com.lockzero.clsnotegroup)(_notegroups.Get(_i));
 //BA.debugLineNum = 93;BA.debugLine="If grp.Id = groupId Then";
if ((_grp._id /*String*/ ).equals(_groupid)) { 
 //BA.debugLineNum = 94;BA.debugLine="NoteGroups.RemoveAt(i)";
_notegroups.RemoveAt(_i);
 //BA.debugLineNum = 95;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 100;BA.debugLine="For i = Notes.Size - 1 To 0 Step -1";
{
final int step9 = -1;
final int limit9 = (int) (0);
_i = (int) (_notes.getSize()-1) ;
for (;_i >= limit9 ;_i = _i + step9 ) {
 //BA.debugLineNum = 101;BA.debugLine="Dim note As clsNoteEntry = Notes.Get(i)";
_note = (com.lockzero.clsnoteentry)(_notes.Get(_i));
 //BA.debugLineNum = 102;BA.debugLine="If note.GroupId = groupId Then";
if ((_note._groupid /*String*/ ).equals(_groupid)) { 
 //BA.debugLineNum = 103;BA.debugLine="Notes.RemoveAt(i)";
_notes.RemoveAt(_i);
 };
 }
};
 //BA.debugLineNum = 107;BA.debugLine="SaveData";
_savedata(_ba);
 //BA.debugLineNum = 108;BA.debugLine="End Sub";
return "";
}
public static String  _ensureinit(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 29;BA.debugLine="Private Sub EnsureInit";
 //BA.debugLineNum = 30;BA.debugLine="If mInitialized = False Then Init";
if (_minitialized==anywheresoftware.b4a.keywords.Common.False) { 
_init(_ba);};
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return "";
}
public static String  _ensuresystemgroups(anywheresoftware.b4a.BA _ba) throws Exception{
com.lockzero.clsnotegroup _cardsgroup = null;
com.lockzero.clsnotegroup _grp = null;
 //BA.debugLineNum = 127;BA.debugLine="Public Sub EnsureSystemGroups";
 //BA.debugLineNum = 129;BA.debugLine="Dim cardsGroup As clsNoteGroup = GetNoteGroupById";
_cardsgroup = _getnotegroupbyid(_ba,_getcardsgroupid(_ba));
 //BA.debugLineNum = 131;BA.debugLine="If cardsGroup = Null Then";
if (_cardsgroup== null) { 
 //BA.debugLineNum = 133;BA.debugLine="Dim grp As clsNoteGroup";
_grp = new com.lockzero.clsnotegroup();
 //BA.debugLineNum = 134;BA.debugLine="grp.Initialize";
_grp._initialize /*String*/ ((_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 135;BA.debugLine="grp.Id = GetCardsGroupId";
_grp._id /*String*/  = _getcardsgroupid(_ba);
 //BA.debugLineNum = 136;BA.debugLine="grp.Name = ModLang.T(\"cards\")";
_grp._name /*String*/  = mostCurrent._modlang._t /*String*/ (_ba,"cards");
 //BA.debugLineNum = 137;BA.debugLine="grp.Icon = Chr(0xD83D) & Chr(0xDCB3)  '💳 cartao";
_grp._icon /*String*/  = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xd83d)))+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xdcb3)));
 //BA.debugLineNum = 138;BA.debugLine="grp.IsSecure = True     'Sempre seguro";
_grp._issecure /*boolean*/  = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 139;BA.debugLine="grp.IsSystem = True     'Grupo de sistema";
_grp._issystem /*boolean*/  = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 140;BA.debugLine="grp.TemplateType = \"card\"";
_grp._templatetype /*String*/  = "card";
 //BA.debugLineNum = 143;BA.debugLine="CopySecurityFromExistingGroup(grp)";
_copysecurityfromexistinggroup(_ba,_grp);
 //BA.debugLineNum = 145;BA.debugLine="NoteGroups.Add(grp)";
_notegroups.Add((Object)(_grp));
 //BA.debugLineNum = 146;BA.debugLine="SaveData";
_savedata(_ba);
 //BA.debugLineNum = 147;BA.debugLine="Log(\"ModNotes: Grupo Cartoes criado (sistema)\")";
anywheresoftware.b4a.keywords.Common.LogImpl("617301524","ModNotes: Grupo Cartoes criado (sistema)",0);
 }else {
 //BA.debugLineNum = 150;BA.debugLine="If cardsGroup.Salt = \"\" Or cardsGroup.TestValue";
if ((_cardsgroup._salt /*String*/ ).equals("") || (_cardsgroup._testvalue /*String*/ ).equals("")) { 
 //BA.debugLineNum = 151;BA.debugLine="CopySecurityFromExistingGroup(cardsGroup)";
_copysecurityfromexistinggroup(_ba,_cardsgroup);
 //BA.debugLineNum = 152;BA.debugLine="SaveNoteGroup(cardsGroup)";
_savenotegroup(_ba,_cardsgroup);
 };
 };
 //BA.debugLineNum = 155;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _exportall(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.List _result = null;
int _i = 0;
com.lockzero.clsnoteentry _note = null;
 //BA.debugLineNum = 808;BA.debugLine="Public Sub ExportAll As List";
 //BA.debugLineNum = 809;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 810;BA.debugLine="Dim result As List";
_result = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 811;BA.debugLine="result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 813;BA.debugLine="For i = 0 To Notes.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (_notes.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 814;BA.debugLine="Dim note As clsNoteEntry = Notes.Get(i)";
_note = (com.lockzero.clsnoteentry)(_notes.Get(_i));
 //BA.debugLineNum = 815;BA.debugLine="result.Add(note.ToMap)";
_result.Add((Object)(_note._tomap /*anywheresoftware.b4a.objects.collections.Map*/ ().getObject()));
 }
};
 //BA.debugLineNum = 818;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 819;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.Map  _exportalldata(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.List _groupslist = null;
int _i = 0;
com.lockzero.clsnotegroup _grp = null;
anywheresoftware.b4a.objects.collections.List _noteslist = null;
com.lockzero.clsnoteentry _note = null;
anywheresoftware.b4a.objects.collections.Map _result = null;
 //BA.debugLineNum = 726;BA.debugLine="Public Sub ExportAllData As Map";
 //BA.debugLineNum = 727;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 729;BA.debugLine="Dim groupsList As List";
_groupslist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 730;BA.debugLine="groupsList.Initialize";
_groupslist.Initialize();
 //BA.debugLineNum = 731;BA.debugLine="For i = 0 To NoteGroups.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (_notegroups.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 732;BA.debugLine="Dim grp As clsNoteGroup = NoteGroups.Get(i)";
_grp = (com.lockzero.clsnotegroup)(_notegroups.Get(_i));
 //BA.debugLineNum = 733;BA.debugLine="groupsList.Add(grp.ToMap)";
_groupslist.Add((Object)(_grp._tomap /*anywheresoftware.b4a.objects.collections.Map*/ ().getObject()));
 }
};
 //BA.debugLineNum = 736;BA.debugLine="Dim notesList As List";
_noteslist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 737;BA.debugLine="notesList.Initialize";
_noteslist.Initialize();
 //BA.debugLineNum = 738;BA.debugLine="For i = 0 To Notes.Size - 1";
{
final int step10 = 1;
final int limit10 = (int) (_notes.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit10 ;_i = _i + step10 ) {
 //BA.debugLineNum = 739;BA.debugLine="Dim note As clsNoteEntry = Notes.Get(i)";
_note = (com.lockzero.clsnoteentry)(_notes.Get(_i));
 //BA.debugLineNum = 740;BA.debugLine="notesList.Add(note.ToMap)";
_noteslist.Add((Object)(_note._tomap /*anywheresoftware.b4a.objects.collections.Map*/ ().getObject()));
 }
};
 //BA.debugLineNum = 743;BA.debugLine="Dim result As Map";
_result = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 744;BA.debugLine="result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 745;BA.debugLine="result.Put(\"noteGroups\", groupsList)";
_result.Put((Object)("noteGroups"),(Object)(_groupslist.getObject()));
 //BA.debugLineNum = 746;BA.debugLine="result.Put(\"notes\", notesList)";
_result.Put((Object)("notes"),(Object)(_noteslist.getObject()));
 //BA.debugLineNum = 747;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 748;BA.debugLine="End Sub";
return null;
}
public static String  _forcereload(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Public Sub ForceReload";
 //BA.debugLineNum = 23;BA.debugLine="NoteGroups.Initialize";
_notegroups.Initialize();
 //BA.debugLineNum = 24;BA.debugLine="Notes.Initialize";
_notes.Initialize();
 //BA.debugLineNum = 25;BA.debugLine="LoadData";
_loaddata(_ba);
 //BA.debugLineNum = 26;BA.debugLine="mInitialized = True";
_minitialized = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _getallnotegroups(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 38;BA.debugLine="Public Sub GetAllNoteGroups As List";
 //BA.debugLineNum = 39;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 40;BA.debugLine="Return NoteGroups";
if (true) return _notegroups;
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _getallnotes(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 308;BA.debugLine="Public Sub GetAllNotes As List";
 //BA.debugLineNum = 309;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 310;BA.debugLine="Return Notes";
if (true) return _notes;
 //BA.debugLineNum = 311;BA.debugLine="End Sub";
return null;
}
public static String  _getcardsgroupid(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 121;BA.debugLine="Public Sub GetCardsGroupId As String";
 //BA.debugLineNum = 122;BA.debugLine="Return \"system_cards\"";
if (true) return "system_cards";
 //BA.debugLineNum = 123;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _getcardtemplate(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.List _items = null;
 //BA.debugLineNum = 197;BA.debugLine="Public Sub GetCardTemplate As List";
 //BA.debugLineNum = 198;BA.debugLine="Dim items As List";
_items = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 199;BA.debugLine="items.Initialize";
_items.Initialize();
 //BA.debugLineNum = 202;BA.debugLine="items.Add(CreateItem(ModLang.T(\"card_name\") & \":";
_items.Add((Object)(_createitem(_ba,mostCurrent._modlang._t /*String*/ (_ba,"card_name")+": ").getObject()));
 //BA.debugLineNum = 203;BA.debugLine="items.Add(CreateItem(ModLang.T(\"card_brand\") & \":";
_items.Add((Object)(_createitem(_ba,mostCurrent._modlang._t /*String*/ (_ba,"card_brand")+": ").getObject()));
 //BA.debugLineNum = 204;BA.debugLine="items.Add(CreateItem(ModLang.T(\"card_number\") & \"";
_items.Add((Object)(_createitem(_ba,mostCurrent._modlang._t /*String*/ (_ba,"card_number")+": ").getObject()));
 //BA.debugLineNum = 205;BA.debugLine="items.Add(CreateItem(ModLang.T(\"card_expiry\") & \"";
_items.Add((Object)(_createitem(_ba,mostCurrent._modlang._t /*String*/ (_ba,"card_expiry")+": ").getObject()));
 //BA.debugLineNum = 206;BA.debugLine="items.Add(CreateItem(ModLang.T(\"card_cvv\") & \": \"";
_items.Add((Object)(_createitem(_ba,mostCurrent._modlang._t /*String*/ (_ba,"card_cvv")+": ").getObject()));
 //BA.debugLineNum = 207;BA.debugLine="items.Add(CreateItem(ModLang.T(\"card_password\") &";
_items.Add((Object)(_createitem(_ba,mostCurrent._modlang._t /*String*/ (_ba,"card_password")+": ").getObject()));
 //BA.debugLineNum = 208;BA.debugLine="items.Add(CreateItem(ModLang.T(\"card_holder\") & \"";
_items.Add((Object)(_createitem(_ba,mostCurrent._modlang._t /*String*/ (_ba,"card_holder")+": ").getObject()));
 //BA.debugLineNum = 209;BA.debugLine="items.Add(CreateItem(ModLang.T(\"card_limit\") & \":";
_items.Add((Object)(_createitem(_ba,mostCurrent._modlang._t /*String*/ (_ba,"card_limit")+": ").getObject()));
 //BA.debugLineNum = 210;BA.debugLine="items.Add(CreateItem(ModLang.T(\"notes\") & \": \"))";
_items.Add((Object)(_createitem(_ba,mostCurrent._modlang._t /*String*/ (_ba,"notes")+": ").getObject()));
 //BA.debugLineNum = 212;BA.debugLine="Return items";
if (true) return _items;
 //BA.debugLineNum = 213;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _getfavorites(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.List _result = null;
int _i = 0;
com.lockzero.clsnoteentry _note = null;
 //BA.debugLineNum = 314;BA.debugLine="Public Sub GetFavorites As List";
 //BA.debugLineNum = 315;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 316;BA.debugLine="Dim result As List";
_result = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 317;BA.debugLine="result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 319;BA.debugLine="For i = 0 To Notes.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (_notes.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 320;BA.debugLine="Dim note As clsNoteEntry = Notes.Get(i)";
_note = (com.lockzero.clsnoteentry)(_notes.Get(_i));
 //BA.debugLineNum = 321;BA.debugLine="If note.IsFavorite Then";
if (_note._isfavorite /*boolean*/ ) { 
 //BA.debugLineNum = 322;BA.debugLine="result.Add(note)";
_result.Add((Object)(_note));
 };
 }
};
 //BA.debugLineNum = 326;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 327;BA.debugLine="End Sub";
return null;
}
public static com.lockzero.clsnoteentry  _getnotebyid(anywheresoftware.b4a.BA _ba,String _noteid) throws Exception{
int _i = 0;
com.lockzero.clsnoteentry _note = null;
 //BA.debugLineNum = 402;BA.debugLine="Public Sub GetNoteById(noteId As String) As clsNot";
 //BA.debugLineNum = 403;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 405;BA.debugLine="For i = 0 To Notes.Size - 1";
{
final int step2 = 1;
final int limit2 = (int) (_notes.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 406;BA.debugLine="Dim note As clsNoteEntry = Notes.Get(i)";
_note = (com.lockzero.clsnoteentry)(_notes.Get(_i));
 //BA.debugLineNum = 407;BA.debugLine="If note.Id = noteId Then";
if ((_note._id /*String*/ ).equals(_noteid)) { 
 //BA.debugLineNum = 408;BA.debugLine="Return note";
if (true) return _note;
 };
 }
};
 //BA.debugLineNum = 412;BA.debugLine="Return Null";
if (true) return (com.lockzero.clsnoteentry)(anywheresoftware.b4a.keywords.Common.Null);
 //BA.debugLineNum = 413;BA.debugLine="End Sub";
return null;
}
public static com.lockzero.clsnotegroup  _getnotegroupbyid(anywheresoftware.b4a.BA _ba,String _groupid) throws Exception{
int _i = 0;
com.lockzero.clsnotegroup _grp = null;
 //BA.debugLineNum = 44;BA.debugLine="Public Sub GetNoteGroupById(groupId As String) As";
 //BA.debugLineNum = 45;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 47;BA.debugLine="For i = 0 To NoteGroups.Size - 1";
{
final int step2 = 1;
final int limit2 = (int) (_notegroups.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 48;BA.debugLine="Dim grp As clsNoteGroup = NoteGroups.Get(i)";
_grp = (com.lockzero.clsnotegroup)(_notegroups.Get(_i));
 //BA.debugLineNum = 49;BA.debugLine="If grp.Id = groupId Then";
if ((_grp._id /*String*/ ).equals(_groupid)) { 
 //BA.debugLineNum = 50;BA.debugLine="Return grp";
if (true) return _grp;
 };
 }
};
 //BA.debugLineNum = 54;BA.debugLine="Return Null";
if (true) return (com.lockzero.clsnotegroup)(anywheresoftware.b4a.keywords.Common.Null);
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _getnotesbygroup(anywheresoftware.b4a.BA _ba,String _groupid) throws Exception{
anywheresoftware.b4a.objects.collections.List _result = null;
int _i = 0;
com.lockzero.clsnoteentry _note = null;
 //BA.debugLineNum = 236;BA.debugLine="Public Sub GetNotesByGroup(groupId As String) As L";
 //BA.debugLineNum = 237;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 238;BA.debugLine="Dim result As List";
_result = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 239;BA.debugLine="result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 241;BA.debugLine="For i = 0 To Notes.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (_notes.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 242;BA.debugLine="Dim note As clsNoteEntry = Notes.Get(i)";
_note = (com.lockzero.clsnoteentry)(_notes.Get(_i));
 //BA.debugLineNum = 243;BA.debugLine="If note.GroupId = groupId Then";
if ((_note._groupid /*String*/ ).equals(_groupid)) { 
 //BA.debugLineNum = 244;BA.debugLine="result.Add(note)";
_result.Add((Object)(_note));
 };
 }
};
 //BA.debugLineNum = 249;BA.debugLine="SortNotesBySortOrder(result)";
_sortnotesbysortorder(_ba,_result);
 //BA.debugLineNum = 251;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 252;BA.debugLine="End Sub";
return null;
}
public static String  _importall(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _noteslist) throws Exception{
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _m = null;
com.lockzero.clsnoteentry _note = null;
boolean _exists = false;
int _j = 0;
com.lockzero.clsnoteentry _existing = null;
 //BA.debugLineNum = 822;BA.debugLine="Public Sub ImportAll(notesList As List)";
 //BA.debugLineNum = 823;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 825;BA.debugLine="For i = 0 To notesList.Size - 1";
{
final int step2 = 1;
final int limit2 = (int) (_noteslist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 826;BA.debugLine="Dim m As Map = notesList.Get(i)";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_noteslist.Get(_i)));
 //BA.debugLineNum = 827;BA.debugLine="Dim note As clsNoteEntry";
_note = new com.lockzero.clsnoteentry();
 //BA.debugLineNum = 828;BA.debugLine="note.Initialize";
_note._initialize /*String*/ ((_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 829;BA.debugLine="note.FromMap(m)";
_note._frommap /*String*/ (_m);
 //BA.debugLineNum = 832;BA.debugLine="Dim exists As Boolean = False";
_exists = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 833;BA.debugLine="For j = 0 To Notes.Size - 1";
{
final int step8 = 1;
final int limit8 = (int) (_notes.getSize()-1);
_j = (int) (0) ;
for (;_j <= limit8 ;_j = _j + step8 ) {
 //BA.debugLineNum = 834;BA.debugLine="Dim existing As clsNoteEntry = Notes.Get(j)";
_existing = (com.lockzero.clsnoteentry)(_notes.Get(_j));
 //BA.debugLineNum = 835;BA.debugLine="If existing.Id = note.Id Then";
if ((_existing._id /*String*/ ).equals(_note._id /*String*/ )) { 
 //BA.debugLineNum = 836;BA.debugLine="exists = True";
_exists = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 837;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 841;BA.debugLine="If Not(exists) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_exists)) { 
 //BA.debugLineNum = 842;BA.debugLine="Notes.Add(note)";
_notes.Add((Object)(_note));
 };
 }
};
 //BA.debugLineNum = 846;BA.debugLine="SaveData";
_savedata(_ba);
 //BA.debugLineNum = 847;BA.debugLine="End Sub";
return "";
}
public static String  _importalldata(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.Map _data) throws Exception{
anywheresoftware.b4a.objects.collections.List _groupslist = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _m = null;
com.lockzero.clsnotegroup _grp = null;
boolean _exists = false;
int _j = 0;
com.lockzero.clsnotegroup _existing = null;
anywheresoftware.b4a.objects.collections.List _noteslist = null;
com.lockzero.clsnoteentry _note = null;
boolean _noteexists = false;
com.lockzero.clsnoteentry _existingnote = null;
 //BA.debugLineNum = 751;BA.debugLine="Public Sub ImportAllData(data As Map)";
 //BA.debugLineNum = 752;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 755;BA.debugLine="If data.ContainsKey(\"noteGroups\") Then";
if (_data.ContainsKey((Object)("noteGroups"))) { 
 //BA.debugLineNum = 756;BA.debugLine="Dim groupsList As List = data.Get(\"noteGroups\")";
_groupslist = new anywheresoftware.b4a.objects.collections.List();
_groupslist = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_data.Get((Object)("noteGroups"))));
 //BA.debugLineNum = 757;BA.debugLine="For i = 0 To groupsList.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (_groupslist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 758;BA.debugLine="Dim m As Map = groupsList.Get(i)";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_groupslist.Get(_i)));
 //BA.debugLineNum = 759;BA.debugLine="Dim grp As clsNoteGroup";
_grp = new com.lockzero.clsnotegroup();
 //BA.debugLineNum = 760;BA.debugLine="grp.Initialize";
_grp._initialize /*String*/ ((_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 761;BA.debugLine="grp.FromMap(m)";
_grp._frommap /*String*/ (_m);
 //BA.debugLineNum = 764;BA.debugLine="Dim exists As Boolean = False";
_exists = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 765;BA.debugLine="For j = 0 To NoteGroups.Size - 1";
{
final int step10 = 1;
final int limit10 = (int) (_notegroups.getSize()-1);
_j = (int) (0) ;
for (;_j <= limit10 ;_j = _j + step10 ) {
 //BA.debugLineNum = 766;BA.debugLine="Dim existing As clsNoteGroup = NoteGroups.Get(";
_existing = (com.lockzero.clsnotegroup)(_notegroups.Get(_j));
 //BA.debugLineNum = 767;BA.debugLine="If existing.Id = grp.Id Then";
if ((_existing._id /*String*/ ).equals(_grp._id /*String*/ )) { 
 //BA.debugLineNum = 768;BA.debugLine="exists = True";
_exists = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 769;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 773;BA.debugLine="If Not(exists) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_exists)) { 
 //BA.debugLineNum = 774;BA.debugLine="NoteGroups.Add(grp)";
_notegroups.Add((Object)(_grp));
 };
 }
};
 };
 //BA.debugLineNum = 780;BA.debugLine="If data.ContainsKey(\"notes\") Then";
if (_data.ContainsKey((Object)("notes"))) { 
 //BA.debugLineNum = 781;BA.debugLine="Dim notesList As List = data.Get(\"notes\")";
_noteslist = new anywheresoftware.b4a.objects.collections.List();
_noteslist = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_data.Get((Object)("notes"))));
 //BA.debugLineNum = 782;BA.debugLine="For i = 0 To notesList.Size - 1";
{
final int step24 = 1;
final int limit24 = (int) (_noteslist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit24 ;_i = _i + step24 ) {
 //BA.debugLineNum = 783;BA.debugLine="Dim m As Map = notesList.Get(i)";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_noteslist.Get(_i)));
 //BA.debugLineNum = 784;BA.debugLine="Dim note As clsNoteEntry";
_note = new com.lockzero.clsnoteentry();
 //BA.debugLineNum = 785;BA.debugLine="note.Initialize";
_note._initialize /*String*/ ((_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 786;BA.debugLine="note.FromMap(m)";
_note._frommap /*String*/ (_m);
 //BA.debugLineNum = 789;BA.debugLine="Dim noteExists As Boolean = False";
_noteexists = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 790;BA.debugLine="For j = 0 To Notes.Size - 1";
{
final int step30 = 1;
final int limit30 = (int) (_notes.getSize()-1);
_j = (int) (0) ;
for (;_j <= limit30 ;_j = _j + step30 ) {
 //BA.debugLineNum = 791;BA.debugLine="Dim existingNote As clsNoteEntry = Notes.Get(j";
_existingnote = (com.lockzero.clsnoteentry)(_notes.Get(_j));
 //BA.debugLineNum = 792;BA.debugLine="If existingNote.Id = note.Id Then";
if ((_existingnote._id /*String*/ ).equals(_note._id /*String*/ )) { 
 //BA.debugLineNum = 793;BA.debugLine="noteExists = True";
_noteexists = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 794;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 798;BA.debugLine="If Not(noteExists) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_noteexists)) { 
 //BA.debugLineNum = 799;BA.debugLine="Notes.Add(note)";
_notes.Add((Object)(_note));
 };
 }
};
 };
 //BA.debugLineNum = 804;BA.debugLine="SaveData";
_savedata(_ba);
 //BA.debugLineNum = 805;BA.debugLine="End Sub";
return "";
}
public static String  _init(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Public Sub Init";
 //BA.debugLineNum = 17;BA.debugLine="If mInitialized Then Return";
if (_minitialized) { 
if (true) return "";};
 //BA.debugLineNum = 18;BA.debugLine="ForceReload";
_forcereload(_ba);
 //BA.debugLineNum = 19;BA.debugLine="EnsureSystemGroups";
_ensuresystemgroups(_ba);
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return "";
}
public static boolean  _issystemgroup(anywheresoftware.b4a.BA _ba,String _groupid) throws Exception{
com.lockzero.clsnotegroup _grp = null;
 //BA.debugLineNum = 225;BA.debugLine="Public Sub IsSystemGroup(groupId As String) As Boo";
 //BA.debugLineNum = 226;BA.debugLine="Dim grp As clsNoteGroup = GetNoteGroupById(groupI";
_grp = _getnotegroupbyid(_ba,_groupid);
 //BA.debugLineNum = 227;BA.debugLine="If grp = Null Then Return False";
if (_grp== null) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 228;BA.debugLine="Return grp.IsSystem";
if (true) return _grp._issystem /*boolean*/ ;
 //BA.debugLineNum = 229;BA.debugLine="End Sub";
return false;
}
public static String  _loaddata(anywheresoftware.b4a.BA _ba) throws Exception{
String _json = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
String _firstchar = "";
anywheresoftware.b4a.objects.collections.Map _rootmap = null;
anywheresoftware.b4a.objects.collections.List _groupslist = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _m = null;
com.lockzero.clsnotegroup _grp = null;
anywheresoftware.b4a.objects.collections.List _noteslist = null;
com.lockzero.clsnoteentry _note = null;
anywheresoftware.b4a.objects.collections.List _oldnotes = null;
 //BA.debugLineNum = 495;BA.debugLine="Private Sub LoadData";
 //BA.debugLineNum = 496;BA.debugLine="NoteGroups.Initialize";
_notegroups.Initialize();
 //BA.debugLineNum = 497;BA.debugLine="Notes.Initialize";
_notes.Initialize();
 //BA.debugLineNum = 500;BA.debugLine="Dim json As String = LoadFileWithFallback(File.Di";
_json = _loadfilewithfallback(_ba,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_notes_file);
 //BA.debugLineNum = 502;BA.debugLine="If json.Length = 0 Then";
if (_json.length()==0) { 
 //BA.debugLineNum = 503;BA.debugLine="Log(\"ModNotes.LoadData: nenhum arquivo disponive";
anywheresoftware.b4a.keywords.Common.LogImpl("618546696","ModNotes.LoadData: nenhum arquivo disponivel, iniciando vazio",0);
 //BA.debugLineNum = 504;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 507;BA.debugLine="Try";
try { //BA.debugLineNum = 508;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 509;BA.debugLine="parser.Initialize(json)";
_parser.Initialize(_json);
 //BA.debugLineNum = 513;BA.debugLine="Dim firstChar As String = json.Trim.SubString2(0";
_firstchar = _json.trim().substring((int) (0),(int) (1));
 //BA.debugLineNum = 514;BA.debugLine="If firstChar = \"{\" Then";
if ((_firstchar).equals("{")) { 
 //BA.debugLineNum = 516;BA.debugLine="Dim rootMap As Map = parser.NextObject";
_rootmap = new anywheresoftware.b4a.objects.collections.Map();
_rootmap = _parser.NextObject();
 //BA.debugLineNum = 518;BA.debugLine="If rootMap.ContainsKey(\"groups\") Then";
if (_rootmap.ContainsKey((Object)("groups"))) { 
 //BA.debugLineNum = 519;BA.debugLine="Dim groupsList As List = rootMap.Get(\"groups\")";
_groupslist = new anywheresoftware.b4a.objects.collections.List();
_groupslist = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_rootmap.Get((Object)("groups"))));
 //BA.debugLineNum = 520;BA.debugLine="For i = 0 To groupsList.Size - 1";
{
final int step16 = 1;
final int limit16 = (int) (_groupslist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit16 ;_i = _i + step16 ) {
 //BA.debugLineNum = 521;BA.debugLine="Dim m As Map = groupsList.Get(i)";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_groupslist.Get(_i)));
 //BA.debugLineNum = 522;BA.debugLine="Dim grp As clsNoteGroup";
_grp = new com.lockzero.clsnotegroup();
 //BA.debugLineNum = 523;BA.debugLine="grp.Initialize";
_grp._initialize /*String*/ ((_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 524;BA.debugLine="grp.FromMap(m)";
_grp._frommap /*String*/ (_m);
 //BA.debugLineNum = 525;BA.debugLine="NoteGroups.Add(grp)";
_notegroups.Add((Object)(_grp));
 }
};
 };
 //BA.debugLineNum = 529;BA.debugLine="If rootMap.ContainsKey(\"notes\") Then";
if (_rootmap.ContainsKey((Object)("notes"))) { 
 //BA.debugLineNum = 530;BA.debugLine="Dim notesList As List = rootMap.Get(\"notes\")";
_noteslist = new anywheresoftware.b4a.objects.collections.List();
_noteslist = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_rootmap.Get((Object)("notes"))));
 //BA.debugLineNum = 531;BA.debugLine="For i = 0 To notesList.Size - 1";
{
final int step26 = 1;
final int limit26 = (int) (_noteslist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit26 ;_i = _i + step26 ) {
 //BA.debugLineNum = 532;BA.debugLine="Dim m As Map = notesList.Get(i)";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_noteslist.Get(_i)));
 //BA.debugLineNum = 533;BA.debugLine="Dim note As clsNoteEntry";
_note = new com.lockzero.clsnoteentry();
 //BA.debugLineNum = 534;BA.debugLine="note.Initialize";
_note._initialize /*String*/ ((_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 535;BA.debugLine="note.FromMap(m)";
_note._frommap /*String*/ (_m);
 //BA.debugLineNum = 536;BA.debugLine="Notes.Add(note)";
_notes.Add((Object)(_note));
 }
};
 };
 //BA.debugLineNum = 539;BA.debugLine="Log(\"ModNotes.LoadData: Carregado \" & NoteGroup";
anywheresoftware.b4a.keywords.Common.LogImpl("618546732","ModNotes.LoadData: Carregado "+BA.NumberToString(_notegroups.getSize())+" grupos, "+BA.NumberToString(_notes.getSize())+" notas",0);
 }else if((_firstchar).equals("[")) { 
 //BA.debugLineNum = 543;BA.debugLine="Dim oldNotes As List = parser.NextArray";
_oldnotes = new anywheresoftware.b4a.objects.collections.List();
_oldnotes = _parser.NextArray();
 //BA.debugLineNum = 544;BA.debugLine="If oldNotes.Size > 0 Then";
if (_oldnotes.getSize()>0) { 
 //BA.debugLineNum = 545;BA.debugLine="MigrateFromVersion1(oldNotes)";
_migratefromversion1(_ba,_oldnotes);
 };
 };
 } 
       catch (Exception e42) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e42); //BA.debugLineNum = 549;BA.debugLine="Log(\"ModNotes.LoadData erro ao parsear: \" & Last";
anywheresoftware.b4a.keywords.Common.LogImpl("618546742","ModNotes.LoadData erro ao parsear: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 //BA.debugLineNum = 550;BA.debugLine="NoteGroups.Initialize";
_notegroups.Initialize();
 //BA.debugLineNum = 551;BA.debugLine="Notes.Initialize";
_notes.Initialize();
 };
 //BA.debugLineNum = 553;BA.debugLine="End Sub";
return "";
}
public static String  _loadfilewithfallback(anywheresoftware.b4a.BA _ba,String _folder,String _filename) throws Exception{
String _backupfile = "";
String _content = "";
String _backup = "";
 //BA.debugLineNum = 556;BA.debugLine="Private Sub LoadFileWithFallback(folder As String,";
 //BA.debugLineNum = 557;BA.debugLine="Dim backupFile As String = fileName & \".bak\"";
_backupfile = _filename+".bak";
 //BA.debugLineNum = 560;BA.debugLine="If File.Exists(folder, fileName) Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(_folder,_filename)) { 
 //BA.debugLineNum = 561;BA.debugLine="Try";
try { //BA.debugLineNum = 562;BA.debugLine="Dim content As String = File.ReadString(folder,";
_content = anywheresoftware.b4a.keywords.Common.File.ReadString(_folder,_filename);
 //BA.debugLineNum = 564;BA.debugLine="If content.Length > 0 And (content.StartsWith(\"";
if (_content.length()>0 && (_content.startsWith("{") || _content.startsWith("["))) { 
 //BA.debugLineNum = 565;BA.debugLine="Log(\"LoadFileWithFallback: arquivo principal O";
anywheresoftware.b4a.keywords.Common.LogImpl("618612233","LoadFileWithFallback: arquivo principal OK",0);
 //BA.debugLineNum = 566;BA.debugLine="Return content";
if (true) return _content;
 }else {
 //BA.debugLineNum = 568;BA.debugLine="Log(\"LoadFileWithFallback: arquivo principal i";
anywheresoftware.b4a.keywords.Common.LogImpl("618612236","LoadFileWithFallback: arquivo principal invalido",0);
 };
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12); //BA.debugLineNum = 571;BA.debugLine="Log(\"LoadFileWithFallback: erro ao ler principa";
anywheresoftware.b4a.keywords.Common.LogImpl("618612239","LoadFileWithFallback: erro ao ler principal - "+anywheresoftware.b4a.keywords.Common.LastException(_ba).getMessage(),0);
 };
 };
 //BA.debugLineNum = 576;BA.debugLine="If File.Exists(folder, backupFile) Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(_folder,_backupfile)) { 
 //BA.debugLineNum = 577;BA.debugLine="Try";
try { //BA.debugLineNum = 578;BA.debugLine="Dim backup As String = File.ReadString(folder,";
_backup = anywheresoftware.b4a.keywords.Common.File.ReadString(_folder,_backupfile);
 //BA.debugLineNum = 579;BA.debugLine="If backup.Length > 0 And (backup.StartsWith(\"{\"";
if (_backup.length()>0 && (_backup.startsWith("{") || _backup.startsWith("["))) { 
 //BA.debugLineNum = 580;BA.debugLine="Log(\"LoadFileWithFallback: USANDO BACKUP! Arqu";
anywheresoftware.b4a.keywords.Common.LogImpl("618612248","LoadFileWithFallback: USANDO BACKUP! Arquivo principal estava corrompido.",0);
 //BA.debugLineNum = 582;BA.debugLine="File.Copy(folder, backupFile, folder, fileName";
anywheresoftware.b4a.keywords.Common.File.Copy(_folder,_backupfile,_folder,_filename);
 //BA.debugLineNum = 583;BA.debugLine="Return backup";
if (true) return _backup;
 };
 } 
       catch (Exception e24) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e24); //BA.debugLineNum = 586;BA.debugLine="Log(\"LoadFileWithFallback: backup tambem corrom";
anywheresoftware.b4a.keywords.Common.LogImpl("618612254","LoadFileWithFallback: backup tambem corrompido!",0);
 };
 };
 //BA.debugLineNum = 591;BA.debugLine="Log(\"LoadFileWithFallback: nenhum arquivo valido";
anywheresoftware.b4a.keywords.Common.LogImpl("618612259","LoadFileWithFallback: nenhum arquivo valido encontrado",0);
 //BA.debugLineNum = 592;BA.debugLine="Return \"\"";
if (true) return "";
 //BA.debugLineNum = 593;BA.debugLine="End Sub";
return "";
}
public static String  _migratefromversion1(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _oldnotes) throws Exception{
anywheresoftware.b4a.objects.collections.Map _groupids = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _m = null;
com.lockzero.clsnoteentry _note = null;
String _oldgroupid = "";
com.lockzero.clsnotegroup _grp = null;
 //BA.debugLineNum = 596;BA.debugLine="Private Sub MigrateFromVersion1(oldNotes As List)";
 //BA.debugLineNum = 597;BA.debugLine="Log(\"Migrando notas do formato v1 para v2...\")";
anywheresoftware.b4a.keywords.Common.LogImpl("618677761","Migrando notas do formato v1 para v2...",0);
 //BA.debugLineNum = 600;BA.debugLine="Dim groupIds As Map";
_groupids = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 601;BA.debugLine="groupIds.Initialize";
_groupids.Initialize();
 //BA.debugLineNum = 603;BA.debugLine="For i = 0 To oldNotes.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (_oldnotes.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 604;BA.debugLine="Dim m As Map = oldNotes.Get(i)";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_oldnotes.Get(_i)));
 //BA.debugLineNum = 605;BA.debugLine="Dim note As clsNoteEntry";
_note = new com.lockzero.clsnoteentry();
 //BA.debugLineNum = 606;BA.debugLine="note.Initialize";
_note._initialize /*String*/ ((_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 607;BA.debugLine="note.FromMap(m)";
_note._frommap /*String*/ (_m);
 //BA.debugLineNum = 609;BA.debugLine="Dim oldGroupId As String = note.GroupId";
_oldgroupid = _note._groupid /*String*/ ;
 //BA.debugLineNum = 610;BA.debugLine="If oldGroupId <> \"\" Then";
if ((_oldgroupid).equals("") == false) { 
 //BA.debugLineNum = 611;BA.debugLine="If groupIds.ContainsKey(oldGroupId) = False The";
if (_groupids.ContainsKey((Object)(_oldgroupid))==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 612;BA.debugLine="groupIds.Put(oldGroupId, oldGroupId)";
_groupids.Put((Object)(_oldgroupid),(Object)(_oldgroupid));
 };
 };
 //BA.debugLineNum = 616;BA.debugLine="Notes.Add(note)";
_notes.Add((Object)(_note));
 }
};
 //BA.debugLineNum = 620;BA.debugLine="For Each oldGroupId As String In groupIds.Keys";
{
final anywheresoftware.b4a.BA.IterableList group17 = _groupids.Keys();
final int groupLen17 = group17.getSize()
;int index17 = 0;
;
for (; index17 < groupLen17;index17++){
_oldgroupid = BA.ObjectToString(group17.Get(index17));
 //BA.debugLineNum = 621;BA.debugLine="Dim grp As clsNoteGroup";
_grp = new com.lockzero.clsnotegroup();
 //BA.debugLineNum = 622;BA.debugLine="grp.Initialize";
_grp._initialize /*String*/ ((_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 623;BA.debugLine="grp.Id = oldGroupId  'Mantém o mesmo ID para ass";
_grp._id /*String*/  = _oldgroupid;
 //BA.debugLineNum = 624;BA.debugLine="grp.Name = \"Migrado\"";
_grp._name /*String*/  = "Migrado";
 //BA.debugLineNum = 625;BA.debugLine="grp.Icon = \"note\"";
_grp._icon /*String*/  = "note";
 //BA.debugLineNum = 626;BA.debugLine="grp.IsSecure = True  'Assume seguro por compatib";
_grp._issecure /*boolean*/  = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 628;BA.debugLine="NoteGroups.Add(grp)";
_notegroups.Add((Object)(_grp));
 }
};
 //BA.debugLineNum = 632;BA.debugLine="SaveData";
_savedata(_ba);
 //BA.debugLineNum = 633;BA.debugLine="Log(\"Migracao concluida: \" & Notes.Size & \" notas";
anywheresoftware.b4a.keywords.Common.LogImpl("618677797","Migracao concluida: "+BA.NumberToString(_notes.getSize())+" notas, "+BA.NumberToString(_notegroups.getSize())+" grupos",0);
 //BA.debugLineNum = 634;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 4;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Private Const NOTES_FILE As String = \"lockzero_no";
_notes_file = "lockzero_notes.json";
 //BA.debugLineNum = 6;BA.debugLine="Private Const DATA_VERSION As Int = 2  'Versao 2";
_data_version = (int) (2);
 //BA.debugLineNum = 7;BA.debugLine="Private NoteGroups As List  'Lista de clsNoteGrou";
_notegroups = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 8;BA.debugLine="Private Notes As List       'Lista de clsNoteEntr";
_notes = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 9;BA.debugLine="Private mInitialized As Boolean = False";
_minitialized = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _reordernotes(anywheresoftware.b4a.BA _ba,String _groupid,anywheresoftware.b4a.objects.collections.List _orderedids) throws Exception{
int _i = 0;
String _noteid = "";
int _j = 0;
com.lockzero.clsnoteentry _note = null;
 //BA.debugLineNum = 288;BA.debugLine="Public Sub ReorderNotes(groupId As String, ordered";
 //BA.debugLineNum = 289;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 291;BA.debugLine="For i = 0 To orderedIds.Size - 1";
{
final int step2 = 1;
final int limit2 = (int) (_orderedids.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 292;BA.debugLine="Dim noteId As String = orderedIds.Get(i)";
_noteid = BA.ObjectToString(_orderedids.Get(_i));
 //BA.debugLineNum = 293;BA.debugLine="For j = 0 To Notes.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (_notes.getSize()-1);
_j = (int) (0) ;
for (;_j <= limit4 ;_j = _j + step4 ) {
 //BA.debugLineNum = 294;BA.debugLine="Dim note As clsNoteEntry = Notes.Get(j)";
_note = (com.lockzero.clsnoteentry)(_notes.Get(_j));
 //BA.debugLineNum = 295;BA.debugLine="If note.Id = noteId And note.GroupId = groupId";
if ((_note._id /*String*/ ).equals(_noteid) && (_note._groupid /*String*/ ).equals(_groupid)) { 
 //BA.debugLineNum = 296;BA.debugLine="note.SortOrder = i";
_note._sortorder /*int*/  = _i;
 //BA.debugLineNum = 297;BA.debugLine="note.UpdatedAt = DateTime.Now";
_note._updatedat /*long*/  = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 //BA.debugLineNum = 298;BA.debugLine="Notes.Set(j, note)";
_notes.Set(_j,(Object)(_note));
 //BA.debugLineNum = 299;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 }
};
 //BA.debugLineNum = 304;BA.debugLine="SaveData";
_savedata(_ba);
 //BA.debugLineNum = 305;BA.debugLine="End Sub";
return "";
}
public static String  _savedata(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.collections.List _groupslist = null;
int _i = 0;
com.lockzero.clsnotegroup _grp = null;
anywheresoftware.b4a.objects.collections.List _noteslist = null;
com.lockzero.clsnoteentry _note = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _gen = null;
String _jsondata = "";
 //BA.debugLineNum = 636;BA.debugLine="Private Sub SaveData";
 //BA.debugLineNum = 638;BA.debugLine="Dim groupsList As List";
_groupslist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 639;BA.debugLine="groupsList.Initialize";
_groupslist.Initialize();
 //BA.debugLineNum = 640;BA.debugLine="For i = 0 To NoteGroups.Size - 1";
{
final int step3 = 1;
final int limit3 = (int) (_notegroups.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 641;BA.debugLine="Dim grp As clsNoteGroup = NoteGroups.Get(i)";
_grp = (com.lockzero.clsnotegroup)(_notegroups.Get(_i));
 //BA.debugLineNum = 642;BA.debugLine="groupsList.Add(grp.ToMap)";
_groupslist.Add((Object)(_grp._tomap /*anywheresoftware.b4a.objects.collections.Map*/ ().getObject()));
 }
};
 //BA.debugLineNum = 646;BA.debugLine="Dim notesList As List";
_noteslist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 647;BA.debugLine="notesList.Initialize";
_noteslist.Initialize();
 //BA.debugLineNum = 648;BA.debugLine="For i = 0 To Notes.Size - 1";
{
final int step9 = 1;
final int limit9 = (int) (_notes.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit9 ;_i = _i + step9 ) {
 //BA.debugLineNum = 649;BA.debugLine="Dim note As clsNoteEntry = Notes.Get(i)";
_note = (com.lockzero.clsnoteentry)(_notes.Get(_i));
 //BA.debugLineNum = 650;BA.debugLine="notesList.Add(note.ToMap)";
_noteslist.Add((Object)(_note._tomap /*anywheresoftware.b4a.objects.collections.Map*/ ().getObject()));
 }
};
 //BA.debugLineNum = 654;BA.debugLine="Dim root As Map";
_root = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 655;BA.debugLine="root.Initialize";
_root.Initialize();
 //BA.debugLineNum = 656;BA.debugLine="root.Put(\"version\", DATA_VERSION)";
_root.Put((Object)("version"),(Object)(_data_version));
 //BA.debugLineNum = 657;BA.debugLine="root.Put(\"groups\", groupsList)";
_root.Put((Object)("groups"),(Object)(_groupslist.getObject()));
 //BA.debugLineNum = 658;BA.debugLine="root.Put(\"notes\", notesList)";
_root.Put((Object)("notes"),(Object)(_noteslist.getObject()));
 //BA.debugLineNum = 660;BA.debugLine="Dim gen As JSONGenerator";
_gen = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 661;BA.debugLine="gen.Initialize(root)";
_gen.Initialize(_root);
 //BA.debugLineNum = 662;BA.debugLine="Dim jsonData As String = gen.ToPrettyString(2)";
_jsondata = _gen.ToPrettyString((int) (2));
 //BA.debugLineNum = 665;BA.debugLine="If SaveFileAtomic(File.DirInternal, NOTES_FILE, j";
if (_savefileatomic(_ba,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_notes_file,_jsondata)) { 
 //BA.debugLineNum = 666;BA.debugLine="Log(\"ModNotes.SaveData: Salvo \" & NoteGroups.Siz";
anywheresoftware.b4a.keywords.Common.LogImpl("618743326","ModNotes.SaveData: Salvo "+BA.NumberToString(_notegroups.getSize())+" grupos, "+BA.NumberToString(_notes.getSize())+" notas ("+BA.NumberToString(_jsondata.length())+" bytes)",0);
 }else {
 //BA.debugLineNum = 668;BA.debugLine="Log(\"ModNotes.SaveData: ERRO ao salvar!\")";
anywheresoftware.b4a.keywords.Common.LogImpl("618743328","ModNotes.SaveData: ERRO ao salvar!",0);
 };
 //BA.debugLineNum = 670;BA.debugLine="End Sub";
return "";
}
public static boolean  _savefileatomic(anywheresoftware.b4a.BA _ba,String _folder,String _filename,String _content) throws Exception{
String _tempfile = "";
String _backupfile = "";
String _verify = "";
 //BA.debugLineNum = 678;BA.debugLine="Private Sub SaveFileAtomic(folder As String, fileN";
 //BA.debugLineNum = 679;BA.debugLine="Dim tempFile As String = fileName & \".tmp\"";
_tempfile = _filename+".tmp";
 //BA.debugLineNum = 680;BA.debugLine="Dim backupFile As String = fileName & \".bak\"";
_backupfile = _filename+".bak";
 //BA.debugLineNum = 682;BA.debugLine="Try";
try { //BA.debugLineNum = 684;BA.debugLine="File.WriteString(folder, tempFile, content)";
anywheresoftware.b4a.keywords.Common.File.WriteString(_folder,_tempfile,_content);
 //BA.debugLineNum = 687;BA.debugLine="Dim verify As String = File.ReadString(folder, t";
_verify = anywheresoftware.b4a.keywords.Common.File.ReadString(_folder,_tempfile);
 //BA.debugLineNum = 688;BA.debugLine="If verify <> content Then";
if ((_verify).equals(_content) == false) { 
 //BA.debugLineNum = 689;BA.debugLine="Log(\"SaveFileAtomic: verificacao falhou\")";
anywheresoftware.b4a.keywords.Common.LogImpl("618808843","SaveFileAtomic: verificacao falhou",0);
 //BA.debugLineNum = 690;BA.debugLine="File.Delete(folder, tempFile)";
anywheresoftware.b4a.keywords.Common.File.Delete(_folder,_tempfile);
 //BA.debugLineNum = 691;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 695;BA.debugLine="If File.Exists(folder, fileName) Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(_folder,_filename)) { 
 //BA.debugLineNum = 697;BA.debugLine="If File.Exists(folder, backupFile) Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(_folder,_backupfile)) { 
 //BA.debugLineNum = 698;BA.debugLine="File.Delete(folder, backupFile)";
anywheresoftware.b4a.keywords.Common.File.Delete(_folder,_backupfile);
 };
 //BA.debugLineNum = 701;BA.debugLine="File.Copy(folder, fileName, folder, backupFile)";
anywheresoftware.b4a.keywords.Common.File.Copy(_folder,_filename,_folder,_backupfile);
 };
 //BA.debugLineNum = 705;BA.debugLine="File.Delete(folder, fileName)";
anywheresoftware.b4a.keywords.Common.File.Delete(_folder,_filename);
 //BA.debugLineNum = 706;BA.debugLine="File.Copy(folder, tempFile, folder, fileName)";
anywheresoftware.b4a.keywords.Common.File.Copy(_folder,_tempfile,_folder,_filename);
 //BA.debugLineNum = 707;BA.debugLine="File.Delete(folder, tempFile)";
anywheresoftware.b4a.keywords.Common.File.Delete(_folder,_tempfile);
 //BA.debugLineNum = 709;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 } 
       catch (Exception e22) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e22); //BA.debugLineNum = 712;BA.debugLine="Log(\"SaveFileAtomic ERRO: \" & LastException.Mess";
anywheresoftware.b4a.keywords.Common.LogImpl("618808866","SaveFileAtomic ERRO: "+anywheresoftware.b4a.keywords.Common.LastException(_ba).getMessage(),0);
 //BA.debugLineNum = 714;BA.debugLine="If File.Exists(folder, tempFile) Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(_folder,_tempfile)) { 
 //BA.debugLineNum = 715;BA.debugLine="File.Delete(folder, tempFile)";
anywheresoftware.b4a.keywords.Common.File.Delete(_folder,_tempfile);
 };
 //BA.debugLineNum = 717;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 719;BA.debugLine="End Sub";
return false;
}
public static String  _savenote(anywheresoftware.b4a.BA _ba,com.lockzero.clsnoteentry _note) throws Exception{
boolean _found = false;
int _i = 0;
com.lockzero.clsnoteentry _existing = null;
 //BA.debugLineNum = 416;BA.debugLine="Public Sub SaveNote(note As clsNoteEntry)";
 //BA.debugLineNum = 417;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 420;BA.debugLine="If note.Id.Length = 0 Then";
if (_note._id /*String*/ .length()==0) { 
 //BA.debugLineNum = 421;BA.debugLine="note.Id = ModSecurity.GenerateUUID";
_note._id /*String*/  = mostCurrent._modsecurity._generateuuid /*String*/ (_ba);
 //BA.debugLineNum = 422;BA.debugLine="note.CreatedAt = DateTime.Now";
_note._createdat /*long*/  = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 };
 //BA.debugLineNum = 424;BA.debugLine="note.UpdatedAt = DateTime.Now";
_note._updatedat /*long*/  = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 //BA.debugLineNum = 427;BA.debugLine="Dim found As Boolean = False";
_found = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 428;BA.debugLine="For i = 0 To Notes.Size - 1";
{
final int step8 = 1;
final int limit8 = (int) (_notes.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit8 ;_i = _i + step8 ) {
 //BA.debugLineNum = 429;BA.debugLine="Dim existing As clsNoteEntry = Notes.Get(i)";
_existing = (com.lockzero.clsnoteentry)(_notes.Get(_i));
 //BA.debugLineNum = 430;BA.debugLine="If existing.Id = note.Id Then";
if ((_existing._id /*String*/ ).equals(_note._id /*String*/ )) { 
 //BA.debugLineNum = 431;BA.debugLine="Notes.Set(i, note)";
_notes.Set(_i,(Object)(_note));
 //BA.debugLineNum = 432;BA.debugLine="found = True";
_found = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 433;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 437;BA.debugLine="If Not(found) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_found)) { 
 //BA.debugLineNum = 438;BA.debugLine="Notes.Add(note)";
_notes.Add((Object)(_note));
 };
 //BA.debugLineNum = 441;BA.debugLine="SaveData";
_savedata(_ba);
 //BA.debugLineNum = 442;BA.debugLine="End Sub";
return "";
}
public static String  _savenotegroup(anywheresoftware.b4a.BA _ba,com.lockzero.clsnotegroup _grp) throws Exception{
boolean _found = false;
int _i = 0;
com.lockzero.clsnotegroup _existing = null;
 //BA.debugLineNum = 58;BA.debugLine="Public Sub SaveNoteGroup(grp As clsNoteGroup)";
 //BA.debugLineNum = 59;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 62;BA.debugLine="If grp.Id.Length = 0 Then";
if (_grp._id /*String*/ .length()==0) { 
 //BA.debugLineNum = 63;BA.debugLine="grp.Id = ModSecurity.GenerateUUID";
_grp._id /*String*/  = mostCurrent._modsecurity._generateuuid /*String*/ (_ba);
 //BA.debugLineNum = 64;BA.debugLine="grp.CreatedAt = DateTime.Now";
_grp._createdat /*long*/  = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 };
 //BA.debugLineNum = 66;BA.debugLine="grp.UpdatedAt = DateTime.Now";
_grp._updatedat /*long*/  = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 //BA.debugLineNum = 69;BA.debugLine="Dim found As Boolean = False";
_found = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 70;BA.debugLine="For i = 0 To NoteGroups.Size - 1";
{
final int step8 = 1;
final int limit8 = (int) (_notegroups.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit8 ;_i = _i + step8 ) {
 //BA.debugLineNum = 71;BA.debugLine="Dim existing As clsNoteGroup = NoteGroups.Get(i)";
_existing = (com.lockzero.clsnotegroup)(_notegroups.Get(_i));
 //BA.debugLineNum = 72;BA.debugLine="If existing.Id = grp.Id Then";
if ((_existing._id /*String*/ ).equals(_grp._id /*String*/ )) { 
 //BA.debugLineNum = 73;BA.debugLine="NoteGroups.Set(i, grp)";
_notegroups.Set(_i,(Object)(_grp));
 //BA.debugLineNum = 74;BA.debugLine="found = True";
_found = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 75;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 79;BA.debugLine="If Not(found) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_found)) { 
 //BA.debugLineNum = 80;BA.debugLine="NoteGroups.Add(grp)";
_notegroups.Add((Object)(_grp));
 };
 //BA.debugLineNum = 83;BA.debugLine="SaveData";
_savedata(_ba);
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _searchall(anywheresoftware.b4a.BA _ba,String _query,String _passphrase) throws Exception{
anywheresoftware.b4a.objects.collections.List _result = null;
String _q = "";
int _i = 0;
com.lockzero.clsnoteentry _note = null;
boolean _found = false;
com.lockzero.clsnotegroup _group = null;
String _title = "";
String _content = "";
 //BA.debugLineNum = 353;BA.debugLine="Public Sub SearchAll(query As String, passphrase A";
 //BA.debugLineNum = 354;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 355;BA.debugLine="Dim result As List";
_result = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 356;BA.debugLine="result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 357;BA.debugLine="Dim q As String = query.ToLowerCase.Trim";
_q = _query.toLowerCase().trim();
 //BA.debugLineNum = 359;BA.debugLine="If q.Length < 2 Then Return result";
if (_q.length()<2) { 
if (true) return _result;};
 //BA.debugLineNum = 361;BA.debugLine="For i = 0 To Notes.Size - 1";
{
final int step6 = 1;
final int limit6 = (int) (_notes.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
 //BA.debugLineNum = 362;BA.debugLine="Dim note As clsNoteEntry = Notes.Get(i)";
_note = (com.lockzero.clsnoteentry)(_notes.Get(_i));
 //BA.debugLineNum = 363;BA.debugLine="Dim found As Boolean = False";
_found = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 366;BA.debugLine="Dim group As clsNoteGroup = GetNoteGroupById(not";
_group = _getnotegroupbyid(_ba,_note._groupid /*String*/ );
 //BA.debugLineNum = 368;BA.debugLine="If group = Null Or group.IsSecure = False Then";
if (_group== null || _group._issecure /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 370;BA.debugLine="If note.Title.ToLowerCase.Contains(q) Then";
if (_note._title /*String*/ .toLowerCase().contains(_q)) { 
 //BA.debugLineNum = 371;BA.debugLine="found = True";
_found = anywheresoftware.b4a.keywords.Common.True;
 }else if(_note._content /*String*/ .toLowerCase().contains(_q)) { 
 //BA.debugLineNum = 373;BA.debugLine="found = True";
_found = anywheresoftware.b4a.keywords.Common.True;
 };
 }else {
 //BA.debugLineNum = 377;BA.debugLine="If passphrase.Length > 0 Then";
if (_passphrase.length()>0) { 
 //BA.debugLineNum = 378;BA.debugLine="Try";
try { //BA.debugLineNum = 379;BA.debugLine="Dim title As String = note.GetDecryptedTitle(";
_title = _note._getdecryptedtitle /*String*/ (_passphrase).toLowerCase();
 //BA.debugLineNum = 380;BA.debugLine="If title.Contains(q) Then";
if (_title.contains(_q)) { 
 //BA.debugLineNum = 381;BA.debugLine="found = True";
_found = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 383;BA.debugLine="Dim content As String = note.GetDecryptedCon";
_content = _note._getdecryptedcontent /*String*/ (_passphrase).toLowerCase();
 //BA.debugLineNum = 384;BA.debugLine="If content.Contains(q) Then";
if (_content.contains(_q)) { 
 //BA.debugLineNum = 385;BA.debugLine="found = True";
_found = anywheresoftware.b4a.keywords.Common.True;
 };
 };
 } 
       catch (Exception e29) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e29); //BA.debugLineNum = 390;BA.debugLine="Log(\"SearchAllGroups decrypt error: \" & LastE";
anywheresoftware.b4a.keywords.Common.LogImpl("618153509","SearchAllGroups decrypt error: "+anywheresoftware.b4a.keywords.Common.LastException(_ba).getMessage(),0);
 };
 };
 };
 //BA.debugLineNum = 395;BA.debugLine="If found Then result.Add(note)";
if (_found) { 
_result.Add((Object)(_note));};
 }
};
 //BA.debugLineNum = 398;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 399;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _searchnotes(anywheresoftware.b4a.BA _ba,String _query,String _passphrase) throws Exception{
anywheresoftware.b4a.objects.collections.List _result = null;
String _querylower = "";
int _i = 0;
com.lockzero.clsnoteentry _note = null;
String _title = "";
String _content = "";
 //BA.debugLineNum = 330;BA.debugLine="Public Sub SearchNotes(query As String, passPhrase";
 //BA.debugLineNum = 331;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 332;BA.debugLine="Dim result As List";
_result = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 333;BA.debugLine="result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 334;BA.debugLine="Dim queryLower As String = query.ToLowerCase";
_querylower = _query.toLowerCase();
 //BA.debugLineNum = 336;BA.debugLine="For i = 0 To Notes.Size - 1";
{
final int step5 = 1;
final int limit5 = (int) (_notes.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 337;BA.debugLine="Dim note As clsNoteEntry = Notes.Get(i)";
_note = (com.lockzero.clsnoteentry)(_notes.Get(_i));
 //BA.debugLineNum = 338;BA.debugLine="Dim title As String = note.GetDecryptedTitle(pas";
_title = _note._getdecryptedtitle /*String*/ (_passphrase).toLowerCase();
 //BA.debugLineNum = 339;BA.debugLine="Dim content As String = note.GetDecryptedContent";
_content = _note._getdecryptedcontent /*String*/ (_passphrase).toLowerCase();
 //BA.debugLineNum = 341;BA.debugLine="If title.Contains(queryLower) Or content.Contain";
if (_title.contains(_querylower) || _content.contains(_querylower)) { 
 //BA.debugLineNum = 342;BA.debugLine="result.Add(note)";
_result.Add((Object)(_note));
 };
 }
};
 //BA.debugLineNum = 346;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 347;BA.debugLine="End Sub";
return null;
}
public static String  _sortnotesbysortorder(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _notelist) throws Exception{
int _i = 0;
int _j = 0;
com.lockzero.clsnoteentry _n1 = null;
com.lockzero.clsnoteentry _n2 = null;
 //BA.debugLineNum = 255;BA.debugLine="Private Sub SortNotesBySortOrder(noteList As List)";
 //BA.debugLineNum = 256;BA.debugLine="If noteList.Size < 2 Then Return";
if (_notelist.getSize()<2) { 
if (true) return "";};
 //BA.debugLineNum = 258;BA.debugLine="For i = 0 To noteList.Size - 2";
{
final int step2 = 1;
final int limit2 = (int) (_notelist.getSize()-2);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 259;BA.debugLine="For j = 0 To noteList.Size - 2 - i";
{
final int step3 = 1;
final int limit3 = (int) (_notelist.getSize()-2-_i);
_j = (int) (0) ;
for (;_j <= limit3 ;_j = _j + step3 ) {
 //BA.debugLineNum = 260;BA.debugLine="Dim n1 As clsNoteEntry = noteList.Get(j)";
_n1 = (com.lockzero.clsnoteentry)(_notelist.Get(_j));
 //BA.debugLineNum = 261;BA.debugLine="Dim n2 As clsNoteEntry = noteList.Get(j + 1)";
_n2 = (com.lockzero.clsnoteentry)(_notelist.Get((int) (_j+1)));
 //BA.debugLineNum = 262;BA.debugLine="If n1.SortOrder > n2.SortOrder Then";
if (_n1._sortorder /*int*/ >_n2._sortorder /*int*/ ) { 
 //BA.debugLineNum = 263;BA.debugLine="noteList.Set(j, n2)";
_notelist.Set(_j,(Object)(_n2));
 //BA.debugLineNum = 264;BA.debugLine="noteList.Set(j + 1, n1)";
_notelist.Set((int) (_j+1),(Object)(_n1));
 };
 }
};
 }
};
 //BA.debugLineNum = 268;BA.debugLine="End Sub";
return "";
}
public static String  _togglefavorite(anywheresoftware.b4a.BA _ba,String _noteid) throws Exception{
int _i = 0;
com.lockzero.clsnoteentry _note = null;
 //BA.debugLineNum = 460;BA.debugLine="Public Sub ToggleFavorite(noteId As String)";
 //BA.debugLineNum = 461;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 463;BA.debugLine="For i = 0 To Notes.Size - 1";
{
final int step2 = 1;
final int limit2 = (int) (_notes.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 464;BA.debugLine="Dim note As clsNoteEntry = Notes.Get(i)";
_note = (com.lockzero.clsnoteentry)(_notes.Get(_i));
 //BA.debugLineNum = 465;BA.debugLine="If note.Id = noteId Then";
if ((_note._id /*String*/ ).equals(_noteid)) { 
 //BA.debugLineNum = 466;BA.debugLine="note.IsFavorite = Not(note.IsFavorite)";
_note._isfavorite /*boolean*/  = anywheresoftware.b4a.keywords.Common.Not(_note._isfavorite /*boolean*/ );
 //BA.debugLineNum = 467;BA.debugLine="note.UpdatedAt = DateTime.Now";
_note._updatedat /*long*/  = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 //BA.debugLineNum = 468;BA.debugLine="Notes.Set(i, note)";
_notes.Set(_i,(Object)(_note));
 //BA.debugLineNum = 469;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 473;BA.debugLine="SaveData";
_savedata(_ba);
 //BA.debugLineNum = 474;BA.debugLine="End Sub";
return "";
}
public static String  _updatenotesortorder(anywheresoftware.b4a.BA _ba,String _noteid,int _neworder) throws Exception{
int _i = 0;
com.lockzero.clsnoteentry _note = null;
 //BA.debugLineNum = 271;BA.debugLine="Public Sub UpdateNoteSortOrder(noteId As String, n";
 //BA.debugLineNum = 272;BA.debugLine="EnsureInit";
_ensureinit(_ba);
 //BA.debugLineNum = 274;BA.debugLine="For i = 0 To Notes.Size - 1";
{
final int step2 = 1;
final int limit2 = (int) (_notes.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 275;BA.debugLine="Dim note As clsNoteEntry = Notes.Get(i)";
_note = (com.lockzero.clsnoteentry)(_notes.Get(_i));
 //BA.debugLineNum = 276;BA.debugLine="If note.Id = noteId Then";
if ((_note._id /*String*/ ).equals(_noteid)) { 
 //BA.debugLineNum = 277;BA.debugLine="note.SortOrder = newOrder";
_note._sortorder /*int*/  = _neworder;
 //BA.debugLineNum = 278;BA.debugLine="note.UpdatedAt = DateTime.Now";
_note._updatedat /*long*/  = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 //BA.debugLineNum = 279;BA.debugLine="Notes.Set(i, note)";
_notes.Set(_i,(Object)(_note));
 //BA.debugLineNum = 280;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 284;BA.debugLine="SaveData";
_savedata(_ba);
 //BA.debugLineNum = 285;BA.debugLine="End Sub";
return "";
}
}
