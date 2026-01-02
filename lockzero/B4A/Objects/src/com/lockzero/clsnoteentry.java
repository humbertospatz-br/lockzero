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
public String _notetype = "";
public String _items = "";
public String _groupid = "";
public int _sortorder = 0;
public boolean _isfavorite = false;
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
public String  _additem(String _text) throws Exception{
anywheresoftware.b4a.objects.collections.List _itemslist = null;
anywheresoftware.b4a.objects.collections.Map _newitem = null;
 //BA.debugLineNum = 183;BA.debugLine="Public Sub AddItem(text As String)";
 //BA.debugLineNum = 184;BA.debugLine="Dim itemsList As List = GetItemsList";
_itemslist = new anywheresoftware.b4a.objects.collections.List();
_itemslist = _getitemslist();
 //BA.debugLineNum = 185;BA.debugLine="Dim newItem As Map";
_newitem = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 186;BA.debugLine="newItem.Initialize";
_newitem.Initialize();
 //BA.debugLineNum = 187;BA.debugLine="newItem.Put(\"text\", text)";
_newitem.Put((Object)("text"),(Object)(_text));
 //BA.debugLineNum = 188;BA.debugLine="newItem.Put(\"checked\", False)";
_newitem.Put((Object)("checked"),(Object)(__c.False));
 //BA.debugLineNum = 189;BA.debugLine="itemsList.Add(newItem)";
_itemslist.Add((Object)(_newitem.getObject()));
 //BA.debugLineNum = 190;BA.debugLine="SetItemsList(itemsList)";
_setitemslist(_itemslist);
 //BA.debugLineNum = 191;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 8;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Public Id As String";
_id = "";
 //BA.debugLineNum = 10;BA.debugLine="Public Title As String         'Titulo da nota (c";
_title = "";
 //BA.debugLineNum = 11;BA.debugLine="Public Content As String       'Conteudo texto li";
_content = "";
 //BA.debugLineNum = 12;BA.debugLine="Public NoteType As String      '\"text\" ou \"list\"";
_notetype = "";
 //BA.debugLineNum = 13;BA.debugLine="Public Items As String         'JSON array de ite";
_items = "";
 //BA.debugLineNum = 14;BA.debugLine="Public GroupId As String       'Grupo ao qual per";
_groupid = "";
 //BA.debugLineNum = 15;BA.debugLine="Public SortOrder As Int        'Ordem manual (dra";
_sortorder = 0;
 //BA.debugLineNum = 16;BA.debugLine="Public IsFavorite As Boolean   'Marcado como favo";
_isfavorite = false;
 //BA.debugLineNum = 17;BA.debugLine="Public CreatedAt As Long";
_createdat = 0L;
 //BA.debugLineNum = 18;BA.debugLine="Public UpdatedAt As Long";
_updatedat = 0L;
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public String  _encryptcontent(String _passphrase,String _plaincontent) throws Exception{
 //BA.debugLineNum = 104;BA.debugLine="Public Sub EncryptContent(passPhrase As String, pl";
 //BA.debugLineNum = 105;BA.debugLine="Content = ModSecurity.Encrypt(passPhrase, plainCo";
_content = _modsecurity._encrypt /*String*/ (getActivityBA(),_passphrase,_plaincontent);
 //BA.debugLineNum = 106;BA.debugLine="UpdatedAt = DateTime.Now";
_updatedat = __c.DateTime.getNow();
 //BA.debugLineNum = 107;BA.debugLine="End Sub";
return "";
}
public String  _encryptitems(String _passphrase,String _plainitems) throws Exception{
 //BA.debugLineNum = 255;BA.debugLine="Public Sub EncryptItems(passPhrase As String, plai";
 //BA.debugLineNum = 256;BA.debugLine="Items = ModSecurity.Encrypt(passPhrase, plainItem";
_items = _modsecurity._encrypt /*String*/ (getActivityBA(),_passphrase,_plainitems);
 //BA.debugLineNum = 257;BA.debugLine="UpdatedAt = DateTime.Now";
_updatedat = __c.DateTime.getNow();
 //BA.debugLineNum = 258;BA.debugLine="End Sub";
return "";
}
public String  _encrypttitle(String _passphrase,String _plaintitle) throws Exception{
 //BA.debugLineNum = 98;BA.debugLine="Public Sub EncryptTitle(passPhrase As String, plai";
 //BA.debugLineNum = 99;BA.debugLine="Title = ModSecurity.Encrypt(passPhrase, plainTitl";
_title = _modsecurity._encrypt /*String*/ (getActivityBA(),_passphrase,_plaintitle);
 //BA.debugLineNum = 100;BA.debugLine="UpdatedAt = DateTime.Now";
_updatedat = __c.DateTime.getNow();
 //BA.debugLineNum = 101;BA.debugLine="End Sub";
return "";
}
public String  _frommap(anywheresoftware.b4a.objects.collections.Map _m) throws Exception{
Object _itemsvalue = null;
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _gen = null;
 //BA.debugLineNum = 52;BA.debugLine="Public Sub FromMap(m As Map)";
 //BA.debugLineNum = 53;BA.debugLine="Id = m.GetDefault(\"id\", \"\")";
_id = BA.ObjectToString(_m.GetDefault((Object)("id"),(Object)("")));
 //BA.debugLineNum = 54;BA.debugLine="Title = m.GetDefault(\"title\", \"\")";
_title = BA.ObjectToString(_m.GetDefault((Object)("title"),(Object)("")));
 //BA.debugLineNum = 55;BA.debugLine="Content = m.GetDefault(\"content\", \"\")";
_content = BA.ObjectToString(_m.GetDefault((Object)("content"),(Object)("")));
 //BA.debugLineNum = 56;BA.debugLine="NoteType = m.GetDefault(\"noteType\", \"text\")";
_notetype = BA.ObjectToString(_m.GetDefault((Object)("noteType"),(Object)("text")));
 //BA.debugLineNum = 57;BA.debugLine="GroupId = m.GetDefault(\"groupId\", \"\")";
_groupid = BA.ObjectToString(_m.GetDefault((Object)("groupId"),(Object)("")));
 //BA.debugLineNum = 58;BA.debugLine="SortOrder = m.GetDefault(\"sortOrder\", 0)";
_sortorder = (int)(BA.ObjectToNumber(_m.GetDefault((Object)("sortOrder"),(Object)(0))));
 //BA.debugLineNum = 59;BA.debugLine="IsFavorite = m.GetDefault(\"isFavorite\", False)";
_isfavorite = BA.ObjectToBoolean(_m.GetDefault((Object)("isFavorite"),(Object)(__c.False)));
 //BA.debugLineNum = 60;BA.debugLine="CreatedAt = m.GetDefault(\"createdAt\", DateTime.No";
_createdat = BA.ObjectToLongNumber(_m.GetDefault((Object)("createdAt"),(Object)(__c.DateTime.getNow())));
 //BA.debugLineNum = 61;BA.debugLine="UpdatedAt = m.GetDefault(\"updatedAt\", DateTime.No";
_updatedat = BA.ObjectToLongNumber(_m.GetDefault((Object)("updatedAt"),(Object)(__c.DateTime.getNow())));
 //BA.debugLineNum = 64;BA.debugLine="If m.ContainsKey(\"items\") Then";
if (_m.ContainsKey((Object)("items"))) { 
 //BA.debugLineNum = 65;BA.debugLine="Dim itemsValue As Object = m.Get(\"items\")";
_itemsvalue = _m.Get((Object)("items"));
 //BA.debugLineNum = 66;BA.debugLine="If itemsValue Is String Then";
if (_itemsvalue instanceof String) { 
 //BA.debugLineNum = 67;BA.debugLine="Items = itemsValue";
_items = BA.ObjectToString(_itemsvalue);
 }else if(_itemsvalue instanceof java.util.List) { 
 //BA.debugLineNum = 70;BA.debugLine="Dim gen As JSONGenerator";
_gen = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 71;BA.debugLine="gen.Initialize(itemsValue)";
_gen.Initialize((anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_itemsvalue)));
 //BA.debugLineNum = 72;BA.debugLine="Items = gen.ToString";
_items = _gen.ToString();
 }else {
 //BA.debugLineNum = 74;BA.debugLine="Items = \"[]\"";
_items = "[]";
 };
 }else {
 //BA.debugLineNum = 77;BA.debugLine="Items = \"[]\"";
_items = "[]";
 };
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
return "";
}
public int  _getcheckedcount() throws Exception{
anywheresoftware.b4a.objects.collections.List _itemslist = null;
int _count = 0;
anywheresoftware.b4a.objects.collections.Map _item = null;
 //BA.debugLineNum = 171;BA.debugLine="Public Sub GetCheckedCount As Int";
 //BA.debugLineNum = 172;BA.debugLine="Dim itemsList As List = GetItemsList";
_itemslist = new anywheresoftware.b4a.objects.collections.List();
_itemslist = _getitemslist();
 //BA.debugLineNum = 173;BA.debugLine="Dim count As Int = 0";
_count = (int) (0);
 //BA.debugLineNum = 174;BA.debugLine="For Each item As Map In itemsList";
_item = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group3 = _itemslist;
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_item = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group3.Get(index3)));
 //BA.debugLineNum = 175;BA.debugLine="If item.GetDefault(\"checked\", False) = True Then";
if ((_item.GetDefault((Object)("checked"),(Object)(__c.False))).equals((Object)(__c.True))) { 
 //BA.debugLineNum = 176;BA.debugLine="count = count + 1";
_count = (int) (_count+1);
 };
 }
};
 //BA.debugLineNum = 179;BA.debugLine="Return count";
if (true) return _count;
 //BA.debugLineNum = 180;BA.debugLine="End Sub";
return 0;
}
public String  _getdecryptedcontent(String _passphrase) throws Exception{
 //BA.debugLineNum = 90;BA.debugLine="Public Sub GetDecryptedContent(passPhrase As Strin";
 //BA.debugLineNum = 91;BA.debugLine="If ModSecurity.IsEncrypted(Content) Then";
if (_modsecurity._isencrypted /*boolean*/ (getActivityBA(),_content)) { 
 //BA.debugLineNum = 92;BA.debugLine="Return ModSecurity.Decrypt(passPhrase, Content)";
if (true) return _modsecurity._decrypt /*String*/ (getActivityBA(),_passphrase,_content);
 };
 //BA.debugLineNum = 94;BA.debugLine="Return Content";
if (true) return _content;
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
return "";
}
public String  _getdecrypteditems(String _passphrase) throws Exception{
 //BA.debugLineNum = 261;BA.debugLine="Public Sub GetDecryptedItems(passPhrase As String)";
 //BA.debugLineNum = 262;BA.debugLine="If ModSecurity.IsEncrypted(Items) Then";
if (_modsecurity._isencrypted /*boolean*/ (getActivityBA(),_items)) { 
 //BA.debugLineNum = 263;BA.debugLine="Return ModSecurity.Decrypt(passPhrase, Items)";
if (true) return _modsecurity._decrypt /*String*/ (getActivityBA(),_passphrase,_items);
 };
 //BA.debugLineNum = 265;BA.debugLine="Return Items";
if (true) return _items;
 //BA.debugLineNum = 266;BA.debugLine="End Sub";
return "";
}
public String  _getdecryptedtitle(String _passphrase) throws Exception{
 //BA.debugLineNum = 82;BA.debugLine="Public Sub GetDecryptedTitle(passPhrase As String)";
 //BA.debugLineNum = 83;BA.debugLine="If ModSecurity.IsEncrypted(Title) Then";
if (_modsecurity._isencrypted /*boolean*/ (getActivityBA(),_title)) { 
 //BA.debugLineNum = 84;BA.debugLine="Return ModSecurity.Decrypt(passPhrase, Title)";
if (true) return _modsecurity._decrypt /*String*/ (getActivityBA(),_passphrase,_title);
 };
 //BA.debugLineNum = 86;BA.debugLine="Return Title";
if (true) return _title;
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public int  _getitemscount() throws Exception{
anywheresoftware.b4a.objects.collections.List _itemslist = null;
 //BA.debugLineNum = 165;BA.debugLine="Public Sub GetItemsCount As Int";
 //BA.debugLineNum = 166;BA.debugLine="Dim itemsList As List = GetItemsList";
_itemslist = new anywheresoftware.b4a.objects.collections.List();
_itemslist = _getitemslist();
 //BA.debugLineNum = 167;BA.debugLine="Return itemsList.Size";
if (true) return _itemslist.getSize();
 //BA.debugLineNum = 168;BA.debugLine="End Sub";
return 0;
}
public anywheresoftware.b4a.objects.collections.List  _getitemslist() throws Exception{
anywheresoftware.b4a.objects.collections.List _itemslist = null;
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
 //BA.debugLineNum = 128;BA.debugLine="Public Sub GetItemsList As List";
 //BA.debugLineNum = 129;BA.debugLine="Dim itemsList As List";
_itemslist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 130;BA.debugLine="itemsList.Initialize";
_itemslist.Initialize();
 //BA.debugLineNum = 131;BA.debugLine="Try";
try { //BA.debugLineNum = 132;BA.debugLine="If Items = \"\" Or Items = \"[]\" Then Return itemsL";
if ((_items).equals("") || (_items).equals("[]")) { 
if (true) return _itemslist;};
 //BA.debugLineNum = 133;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 134;BA.debugLine="parser.Initialize(Items)";
_parser.Initialize(_items);
 //BA.debugLineNum = 135;BA.debugLine="itemsList = parser.NextArray";
_itemslist = _parser.NextArray();
 } 
       catch (Exception e9) {
			ba.setLastException(e9); //BA.debugLineNum = 137;BA.debugLine="Log(\"clsNoteEntry.GetItemsList error: \" & LastEx";
__c.LogImpl("813893641","clsNoteEntry.GetItemsList error: "+__c.LastException(getActivityBA()).getMessage(),0);
 };
 //BA.debugLineNum = 139;BA.debugLine="Return itemsList";
if (true) return _itemslist;
 //BA.debugLineNum = 140;BA.debugLine="End Sub";
return null;
}
public String  _getpreview(String _passphrase,boolean _issecure) throws Exception{
int _total = 0;
int _checked = 0;
String _preview = "";
 //BA.debugLineNum = 230;BA.debugLine="Public Sub GetPreview(passPhrase As String, isSecu";
 //BA.debugLineNum = 231;BA.debugLine="If NoteType = \"list\" Then";
if ((_notetype).equals("list")) { 
 //BA.debugLineNum = 232;BA.debugLine="Dim total As Int = GetItemsCount";
_total = _getitemscount();
 //BA.debugLineNum = 233;BA.debugLine="Dim checked As Int = GetCheckedCount";
_checked = _getcheckedcount();
 //BA.debugLineNum = 234;BA.debugLine="Return checked & \" de \" & total & \" itens\"";
if (true) return BA.NumberToString(_checked)+" de "+BA.NumberToString(_total)+" itens";
 }else {
 //BA.debugLineNum = 237;BA.debugLine="Dim preview As String = \"\"";
_preview = "";
 //BA.debugLineNum = 238;BA.debugLine="If isSecure And passPhrase <> \"\" Then";
if (_issecure && (_passphrase).equals("") == false) { 
 //BA.debugLineNum = 239;BA.debugLine="preview = GetDecryptedContent(passPhrase)";
_preview = _getdecryptedcontent(_passphrase);
 }else if(__c.Not(_issecure)) { 
 //BA.debugLineNum = 241;BA.debugLine="preview = Content";
_preview = _content;
 };
 //BA.debugLineNum = 243;BA.debugLine="If preview.Length > 50 Then";
if (_preview.length()>50) { 
 //BA.debugLineNum = 244;BA.debugLine="preview = preview.SubString2(0, 50) & \"...\"";
_preview = _preview.substring((int) (0),(int) (50))+"...";
 };
 //BA.debugLineNum = 246;BA.debugLine="Return preview";
if (true) return _preview;
 };
 //BA.debugLineNum = 248;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 21;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 22;BA.debugLine="Id = \"\"";
_id = "";
 //BA.debugLineNum = 23;BA.debugLine="Title = \"\"";
_title = "";
 //BA.debugLineNum = 24;BA.debugLine="Content = \"\"";
_content = "";
 //BA.debugLineNum = 25;BA.debugLine="NoteType = \"text\"  'Padrao: nota de texto";
_notetype = "text";
 //BA.debugLineNum = 26;BA.debugLine="Items = \"[]\"       'Array vazio";
_items = "[]";
 //BA.debugLineNum = 27;BA.debugLine="GroupId = \"\"";
_groupid = "";
 //BA.debugLineNum = 28;BA.debugLine="SortOrder = 0";
_sortorder = (int) (0);
 //BA.debugLineNum = 29;BA.debugLine="IsFavorite = False";
_isfavorite = __c.False;
 //BA.debugLineNum = 30;BA.debugLine="CreatedAt = DateTime.Now";
_createdat = __c.DateTime.getNow();
 //BA.debugLineNum = 31;BA.debugLine="UpdatedAt = DateTime.Now";
_updatedat = __c.DateTime.getNow();
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
public boolean  _islistnote() throws Exception{
 //BA.debugLineNum = 119;BA.debugLine="Public Sub IsListNote As Boolean";
 //BA.debugLineNum = 120;BA.debugLine="Return NoteType = \"list\"";
if (true) return (_notetype).equals("list");
 //BA.debugLineNum = 121;BA.debugLine="End Sub";
return false;
}
public boolean  _istextnote() throws Exception{
 //BA.debugLineNum = 114;BA.debugLine="Public Sub IsTextNote As Boolean";
 //BA.debugLineNum = 115;BA.debugLine="Return NoteType = \"text\"";
if (true) return (_notetype).equals("text");
 //BA.debugLineNum = 116;BA.debugLine="End Sub";
return false;
}
public String  _removeitem(int _index) throws Exception{
anywheresoftware.b4a.objects.collections.List _itemslist = null;
 //BA.debugLineNum = 205;BA.debugLine="Public Sub RemoveItem(index As Int)";
 //BA.debugLineNum = 206;BA.debugLine="Dim itemsList As List = GetItemsList";
_itemslist = new anywheresoftware.b4a.objects.collections.List();
_itemslist = _getitemslist();
 //BA.debugLineNum = 207;BA.debugLine="If index >= 0 And index < itemsList.Size Then";
if (_index>=0 && _index<_itemslist.getSize()) { 
 //BA.debugLineNum = 208;BA.debugLine="itemsList.RemoveAt(index)";
_itemslist.RemoveAt(_index);
 //BA.debugLineNum = 209;BA.debugLine="SetItemsList(itemsList)";
_setitemslist(_itemslist);
 };
 //BA.debugLineNum = 211;BA.debugLine="End Sub";
return "";
}
public String  _setitemslist(anywheresoftware.b4a.objects.collections.List _itemslist) throws Exception{
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _gen = null;
 //BA.debugLineNum = 143;BA.debugLine="Public Sub SetItemsList(itemsList As List)";
 //BA.debugLineNum = 145;BA.debugLine="If itemsList = Null Or itemsList.IsInitialized =";
if (_itemslist== null || _itemslist.IsInitialized()==__c.False) { 
 //BA.debugLineNum = 146;BA.debugLine="Items = \"[]\"";
_items = "[]";
 //BA.debugLineNum = 147;BA.debugLine="UpdatedAt = DateTime.Now";
_updatedat = __c.DateTime.getNow();
 //BA.debugLineNum = 148;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 151;BA.debugLine="If itemsList.Size = 0 Then";
if (_itemslist.getSize()==0) { 
 //BA.debugLineNum = 152;BA.debugLine="Items = \"[]\"";
_items = "[]";
 //BA.debugLineNum = 153;BA.debugLine="UpdatedAt = DateTime.Now";
_updatedat = __c.DateTime.getNow();
 //BA.debugLineNum = 154;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 158;BA.debugLine="Dim gen As JSONGenerator";
_gen = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 159;BA.debugLine="gen.Initialize2(itemsList)  'Initialize2 para Lis";
_gen.Initialize2(_itemslist);
 //BA.debugLineNum = 160;BA.debugLine="Items = gen.ToString";
_items = _gen.ToString();
 //BA.debugLineNum = 161;BA.debugLine="UpdatedAt = DateTime.Now";
_updatedat = __c.DateTime.getNow();
 //BA.debugLineNum = 162;BA.debugLine="End Sub";
return "";
}
public String  _toggleitem(int _index) throws Exception{
anywheresoftware.b4a.objects.collections.List _itemslist = null;
anywheresoftware.b4a.objects.collections.Map _item = null;
boolean _currentstate = false;
 //BA.debugLineNum = 194;BA.debugLine="Public Sub ToggleItem(index As Int)";
 //BA.debugLineNum = 195;BA.debugLine="Dim itemsList As List = GetItemsList";
_itemslist = new anywheresoftware.b4a.objects.collections.List();
_itemslist = _getitemslist();
 //BA.debugLineNum = 196;BA.debugLine="If index >= 0 And index < itemsList.Size Then";
if (_index>=0 && _index<_itemslist.getSize()) { 
 //BA.debugLineNum = 197;BA.debugLine="Dim item As Map = itemsList.Get(index)";
_item = new anywheresoftware.b4a.objects.collections.Map();
_item = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_itemslist.Get(_index)));
 //BA.debugLineNum = 198;BA.debugLine="Dim currentState As Boolean = item.GetDefault(\"c";
_currentstate = BA.ObjectToBoolean(_item.GetDefault((Object)("checked"),(Object)(__c.False)));
 //BA.debugLineNum = 199;BA.debugLine="item.Put(\"checked\", Not(currentState))";
_item.Put((Object)("checked"),(Object)(__c.Not(_currentstate)));
 //BA.debugLineNum = 200;BA.debugLine="SetItemsList(itemsList)";
_setitemslist(_itemslist);
 };
 //BA.debugLineNum = 202;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.collections.Map  _tomap() throws Exception{
anywheresoftware.b4a.objects.collections.Map _m = null;
 //BA.debugLineNum = 35;BA.debugLine="Public Sub ToMap As Map";
 //BA.debugLineNum = 36;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 37;BA.debugLine="m.Initialize";
_m.Initialize();
 //BA.debugLineNum = 38;BA.debugLine="m.Put(\"id\", Id)";
_m.Put((Object)("id"),(Object)(_id));
 //BA.debugLineNum = 39;BA.debugLine="m.Put(\"title\", Title)";
_m.Put((Object)("title"),(Object)(_title));
 //BA.debugLineNum = 40;BA.debugLine="m.Put(\"content\", Content)";
_m.Put((Object)("content"),(Object)(_content));
 //BA.debugLineNum = 41;BA.debugLine="m.Put(\"noteType\", NoteType)";
_m.Put((Object)("noteType"),(Object)(_notetype));
 //BA.debugLineNum = 42;BA.debugLine="m.Put(\"items\", Items)";
_m.Put((Object)("items"),(Object)(_items));
 //BA.debugLineNum = 43;BA.debugLine="m.Put(\"groupId\", GroupId)";
_m.Put((Object)("groupId"),(Object)(_groupid));
 //BA.debugLineNum = 44;BA.debugLine="m.Put(\"sortOrder\", SortOrder)";
_m.Put((Object)("sortOrder"),(Object)(_sortorder));
 //BA.debugLineNum = 45;BA.debugLine="m.Put(\"isFavorite\", IsFavorite)";
_m.Put((Object)("isFavorite"),(Object)(_isfavorite));
 //BA.debugLineNum = 46;BA.debugLine="m.Put(\"createdAt\", CreatedAt)";
_m.Put((Object)("createdAt"),(Object)(_createdat));
 //BA.debugLineNum = 47;BA.debugLine="m.Put(\"updatedAt\", UpdatedAt)";
_m.Put((Object)("updatedAt"),(Object)(_updatedat));
 //BA.debugLineNum = 48;BA.debugLine="Return m";
if (true) return _m;
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
return null;
}
public String  _updateitemtext(int _index,String _newtext) throws Exception{
anywheresoftware.b4a.objects.collections.List _itemslist = null;
anywheresoftware.b4a.objects.collections.Map _item = null;
 //BA.debugLineNum = 214;BA.debugLine="Public Sub UpdateItemText(index As Int, newText As";
 //BA.debugLineNum = 215;BA.debugLine="Dim itemsList As List = GetItemsList";
_itemslist = new anywheresoftware.b4a.objects.collections.List();
_itemslist = _getitemslist();
 //BA.debugLineNum = 216;BA.debugLine="If index >= 0 And index < itemsList.Size Then";
if (_index>=0 && _index<_itemslist.getSize()) { 
 //BA.debugLineNum = 217;BA.debugLine="Dim item As Map = itemsList.Get(index)";
_item = new anywheresoftware.b4a.objects.collections.Map();
_item = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_itemslist.Get(_index)));
 //BA.debugLineNum = 218;BA.debugLine="item.Put(\"text\", newText)";
_item.Put((Object)("text"),(Object)(_newtext));
 //BA.debugLineNum = 219;BA.debugLine="SetItemsList(itemsList)";
_setitemslist(_itemslist);
 };
 //BA.debugLineNum = 221;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
