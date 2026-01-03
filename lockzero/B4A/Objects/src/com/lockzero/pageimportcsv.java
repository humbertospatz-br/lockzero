package com.lockzero;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class pageimportcsv extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.lockzero.pageimportcsv");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.lockzero.pageimportcsv.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnback = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblheadertitle = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblinfo = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblselected = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btntoggleall = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _sventries = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _pnlentries = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlbottom = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnselectgroup = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnimport = null;
public anywheresoftware.b4a.objects.collections.List _csventries = null;
public anywheresoftware.b4a.objects.collections.List _filteredentries = null;
public anywheresoftware.b4a.objects.collections.List _selectedindexes = null;
public String _selectedgroupid = "";
public String _selectedgroupname = "";
public anywheresoftware.b4a.objects.EditTextWrapper _edtsearch = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblclearsearch = null;
public String _currentfilter = "";
public String _csvfolder = "";
public String _csvfilename = "";
public String _lastparsedfile = "";
public anywheresoftware.b4a.objects.PanelWrapper _pnloverlay = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnldialog = null;
public String _currentdialogmode = "";
public anywheresoftware.b4a.objects.EditTextWrapper _edtgroupname = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtpassphrase = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnshowpass = null;
public boolean _ispassvisible = false;
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
public String  _applyfilter() throws Exception{
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _entry = null;
anywheresoftware.b4a.objects.collections.Map _csventry = null;
String _name = "";
String _url = "";
String _username = "";
 //BA.debugLineNum = 592;BA.debugLine="Private Sub ApplyFilter";
 //BA.debugLineNum = 593;BA.debugLine="FilteredEntries.Initialize";
_filteredentries.Initialize();
 //BA.debugLineNum = 595;BA.debugLine="If CurrentFilter = \"\" Then";
if ((_currentfilter).equals("")) { 
 //BA.debugLineNum = 597;BA.debugLine="For i = 0 To CSVEntries.Size - 1";
{
final int step3 = 1;
final int limit3 = (int) (_csventries.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 598;BA.debugLine="Dim entry As Map";
_entry = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 599;BA.debugLine="entry.Initialize";
_entry.Initialize();
 //BA.debugLineNum = 600;BA.debugLine="entry.Put(\"index\", i)";
_entry.Put((Object)("index"),(Object)(_i));
 //BA.debugLineNum = 601;BA.debugLine="entry.Put(\"data\", CSVEntries.Get(i))";
_entry.Put((Object)("data"),_csventries.Get(_i));
 //BA.debugLineNum = 602;BA.debugLine="FilteredEntries.Add(entry)";
_filteredentries.Add((Object)(_entry.getObject()));
 }
};
 }else {
 //BA.debugLineNum = 606;BA.debugLine="For i = 0 To CSVEntries.Size - 1";
{
final int step11 = 1;
final int limit11 = (int) (_csventries.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit11 ;_i = _i + step11 ) {
 //BA.debugLineNum = 607;BA.debugLine="Dim csvEntry As Map = CSVEntries.Get(i)";
_csventry = new anywheresoftware.b4a.objects.collections.Map();
_csventry = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_csventries.Get(_i)));
 //BA.debugLineNum = 608;BA.debugLine="Dim name As String = csvEntry.Get(\"name\")";
_name = BA.ObjectToString(_csventry.Get((Object)("name")));
 //BA.debugLineNum = 609;BA.debugLine="Dim url As String = csvEntry.Get(\"url\")";
_url = BA.ObjectToString(_csventry.Get((Object)("url")));
 //BA.debugLineNum = 610;BA.debugLine="Dim username As String = csvEntry.Get(\"username";
_username = BA.ObjectToString(_csventry.Get((Object)("username")));
 //BA.debugLineNum = 612;BA.debugLine="If name.ToLowerCase.Contains(CurrentFilter) Or";
if (_name.toLowerCase().contains(_currentfilter) || _url.toLowerCase().contains(_currentfilter) || _username.toLowerCase().contains(_currentfilter)) { 
 //BA.debugLineNum = 616;BA.debugLine="Dim entry As Map";
_entry = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 617;BA.debugLine="entry.Initialize";
_entry.Initialize();
 //BA.debugLineNum = 618;BA.debugLine="entry.Put(\"index\", i)";
_entry.Put((Object)("index"),(Object)(_i));
 //BA.debugLineNum = 619;BA.debugLine="entry.Put(\"data\", csvEntry)";
_entry.Put((Object)("data"),(Object)(_csventry.getObject()));
 //BA.debugLineNum = 620;BA.debugLine="FilteredEntries.Add(entry)";
_filteredentries.Add((Object)(_entry.getObject()));
 };
 }
};
 };
 //BA.debugLineNum = 625;BA.debugLine="LoadEntries";
_loadentries();
 //BA.debugLineNum = 626;BA.debugLine="End Sub";
return "";
}
public String  _applytheme() throws Exception{
 //BA.debugLineNum = 1176;BA.debugLine="Private Sub ApplyTheme";
 //BA.debugLineNum = 1177;BA.debugLine="Root.Color = ModTheme.HomeBg";
_root.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 1178;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_appear() throws Exception{
String _fullpath = "";
 //BA.debugLineNum = 77;BA.debugLine="Private Sub B4XPage_Appear";
 //BA.debugLineNum = 78;BA.debugLine="CallSub2(Main, \"SetPageTitle\", ModLang.T(\"import_";
__c.CallSubNew2(ba,(Object)(_main.getObject()),"SetPageTitle",(Object)(_modlang._t /*String*/ (ba,"import_csv")));
 //BA.debugLineNum = 81;BA.debugLine="If CSVFileName <> \"\" Then";
if ((_csvfilename).equals("") == false) { 
 //BA.debugLineNum = 82;BA.debugLine="Dim fullPath As String = CSVFolder & \"/\" & CSVFi";
_fullpath = _csvfolder+"/"+_csvfilename;
 //BA.debugLineNum = 83;BA.debugLine="If CSVEntries.Size = 0 Or fullPath <> LastParsed";
if (_csventries.getSize()==0 || (_fullpath).equals(_lastparsedfile) == false) { 
 //BA.debugLineNum = 84;BA.debugLine="Log(\"Parseando CSV: \" & CSVFileName)";
__c.LogImpl("631195143","Parseando CSV: "+_csvfilename,0);
 //BA.debugLineNum = 86;BA.debugLine="CSVEntries.Initialize";
_csventries.Initialize();
 //BA.debugLineNum = 87;BA.debugLine="SelectedIndexes.Initialize";
_selectedindexes.Initialize();
 //BA.debugLineNum = 88;BA.debugLine="SelectedGroupId = \"\"";
_selectedgroupid = "";
 //BA.debugLineNum = 89;BA.debugLine="SelectedGroupName = \"\"";
_selectedgroupname = "";
 //BA.debugLineNum = 90;BA.debugLine="CurrentFilter = \"\"";
_currentfilter = "";
 //BA.debugLineNum = 91;BA.debugLine="If edtSearch.IsInitialized Then edtSearch.Text";
if (_edtsearch.IsInitialized()) { 
_edtsearch.setText(BA.ObjectToCharSequence(""));};
 //BA.debugLineNum = 93;BA.debugLine="ParseCSV";
_parsecsv();
 //BA.debugLineNum = 94;BA.debugLine="LastParsedFile = fullPath";
_lastparsedfile = _fullpath;
 //BA.debugLineNum = 95;BA.debugLine="ApplyFilter 'Inicializa filtro e carrega entrad";
_applyfilter();
 };
 };
 //BA.debugLineNum = 99;BA.debugLine="UpdateInfo";
_updateinfo();
 //BA.debugLineNum = 100;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
 //BA.debugLineNum = 71;BA.debugLine="Private Sub B4XPage_Created(Root1 As B4XView)";
 //BA.debugLineNum = 72;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 73;BA.debugLine="CreateUI";
_createui();
 //BA.debugLineNum = 74;BA.debugLine="ApplyTheme";
_applytheme();
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_disappear() throws Exception{
 //BA.debugLineNum = 102;BA.debugLine="Private Sub B4XPage_Disappear";
 //BA.debugLineNum = 105;BA.debugLine="Main.PendingCSVFile = \"\"";
_main._pendingcsvfile /*String*/  = "";
 //BA.debugLineNum = 106;BA.debugLine="Main.PendingCSVFolder = \"\"";
_main._pendingcsvfolder /*String*/  = "";
 //BA.debugLineNum = 107;BA.debugLine="End Sub";
return "";
}
public String  _btnback_click() throws Exception{
 //BA.debugLineNum = 516;BA.debugLine="Private Sub btnBack_Click";
 //BA.debugLineNum = 517;BA.debugLine="B4XPages.ClosePage(Me)";
_b4xpages._closepage /*String*/ (ba,this);
 //BA.debugLineNum = 518;BA.debugLine="End Sub";
return "";
}
public String  _btncreategroup_click() throws Exception{
String _groupname = "";
String _phrase = "";
String _phraseerror = "";
com.lockzero.clspasswordgroup _g = null;
 //BA.debugLineNum = 859;BA.debugLine="Private Sub btnCreateGroup_Click";
 //BA.debugLineNum = 860;BA.debugLine="Dim groupName As String = edtGroupName.Text.Trim";
_groupname = _edtgroupname.getText().trim();
 //BA.debugLineNum = 861;BA.debugLine="Dim phrase As String = edtPassphrase.Text.Trim";
_phrase = _edtpassphrase.getText().trim();
 //BA.debugLineNum = 863;BA.debugLine="If groupName = \"\" Then";
if ((_groupname).equals("")) { 
 //BA.debugLineNum = 864;BA.debugLine="ToastMessageShow(ModLang.T(\"error_empty_field\"),";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error_empty_field")),__c.True);
 //BA.debugLineNum = 865;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 869;BA.debugLine="Dim phraseError As String = ModSecurity.GetPassph";
_phraseerror = _modsecurity._getpassphraseerror /*String*/ (ba,_phrase);
 //BA.debugLineNum = 870;BA.debugLine="If phraseError.Length > 0 Then";
if (_phraseerror.length()>0) { 
 //BA.debugLineNum = 871;BA.debugLine="ToastMessageShow(phraseError, True)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_phraseerror),__c.True);
 //BA.debugLineNum = 872;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 876;BA.debugLine="Dim g As clsPasswordGroup";
_g = new com.lockzero.clspasswordgroup();
 //BA.debugLineNum = 877;BA.debugLine="g.Initialize";
_g._initialize /*String*/ (ba);
 //BA.debugLineNum = 878;BA.debugLine="g.Name = groupName";
_g._name /*String*/  = _groupname;
 //BA.debugLineNum = 879;BA.debugLine="g.GenerateSalt";
_g._generatesalt /*String*/ ();
 //BA.debugLineNum = 880;BA.debugLine="g.CreateTestValue(phrase)";
_g._createtestvalue /*String*/ (_phrase);
 //BA.debugLineNum = 881;BA.debugLine="ModPasswords.SaveGroup(g)";
_modpasswords._savegroup /*String*/ (ba,_g);
 //BA.debugLineNum = 883;BA.debugLine="SelectedGroupId = g.Id";
_selectedgroupid = _g._id /*String*/ ;
 //BA.debugLineNum = 884;BA.debugLine="SelectedGroupName = g.Name";
_selectedgroupname = _g._name /*String*/ ;
 //BA.debugLineNum = 887;BA.debugLine="ModSession.StartSessionWithCategory(phrase, \"pass";
_modsession._startsessionwithcategory /*String*/ (ba,_phrase,"passwords");
 //BA.debugLineNum = 890;BA.debugLine="ModSecurity.ClearSecureField(edtPassphrase)";
_modsecurity._clearsecurefield /*String*/ (ba,_edtpassphrase);
 //BA.debugLineNum = 892;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 893;BA.debugLine="UpdateInfo";
_updateinfo();
 //BA.debugLineNum = 896;BA.debugLine="DoImport";
_doimport();
 //BA.debugLineNum = 897;BA.debugLine="End Sub";
return "";
}
public String  _btndialogcancel_click() throws Exception{
 //BA.debugLineNum = 1028;BA.debugLine="Private Sub btnDialogCancel_Click";
 //BA.debugLineNum = 1029;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 1030;BA.debugLine="End Sub";
return "";
}
public String  _btngroupitem_click() throws Exception{
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
String _tag = "";
int _pipepos = 0;
 //BA.debugLineNum = 735;BA.debugLine="Private Sub btnGroupItem_Click";
 //BA.debugLineNum = 736;BA.debugLine="Dim btn As Button = Sender";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
_btn = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(__c.Sender(ba)));
 //BA.debugLineNum = 737;BA.debugLine="Dim tag As String = btn.Tag";
_tag = BA.ObjectToString(_btn.getTag());
 //BA.debugLineNum = 739;BA.debugLine="Log(\"=== btnGroupItem_Click ===\")";
__c.LogImpl("632505860","=== btnGroupItem_Click ===",0);
 //BA.debugLineNum = 740;BA.debugLine="Log(\"Tag: \" & tag)";
__c.LogImpl("632505861","Tag: "+_tag,0);
 //BA.debugLineNum = 743;BA.debugLine="Dim pipePos As Int = tag.IndexOf(\"|\")";
_pipepos = _tag.indexOf("|");
 //BA.debugLineNum = 744;BA.debugLine="If pipePos > 0 Then";
if (_pipepos>0) { 
 //BA.debugLineNum = 745;BA.debugLine="SelectedGroupId = tag.SubString2(0, pipePos)";
_selectedgroupid = _tag.substring((int) (0),_pipepos);
 //BA.debugLineNum = 746;BA.debugLine="SelectedGroupName = tag.SubString(pipePos + 1)";
_selectedgroupname = _tag.substring((int) (_pipepos+1));
 //BA.debugLineNum = 747;BA.debugLine="Log(\"SelectedGroupId: \" & SelectedGroupId)";
__c.LogImpl("632505868","SelectedGroupId: "+_selectedgroupid,0);
 //BA.debugLineNum = 748;BA.debugLine="Log(\"SelectedGroupName: \" & SelectedGroupName)";
__c.LogImpl("632505869","SelectedGroupName: "+_selectedgroupname,0);
 }else {
 //BA.debugLineNum = 750;BA.debugLine="Log(\"ERRO: Tag invalida - pipe nao encontrado: \"";
__c.LogImpl("632505871","ERRO: Tag invalida - pipe nao encontrado: "+_tag,0);
 };
 //BA.debugLineNum = 753;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 754;BA.debugLine="UpdateInfo";
_updateinfo();
 //BA.debugLineNum = 755;BA.debugLine="End Sub";
return "";
}
public String  _btnimport_click() throws Exception{
 //BA.debugLineNum = 632;BA.debugLine="Private Sub btnImport_Click";
 //BA.debugLineNum = 633;BA.debugLine="If SelectedIndexes.Size = 0 Then";
if (_selectedindexes.getSize()==0) { 
 //BA.debugLineNum = 634;BA.debugLine="ToastMessageShow(ModLang.T(\"csv_select_at_least_";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"csv_select_at_least_one")),__c.True);
 //BA.debugLineNum = 635;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 638;BA.debugLine="If SelectedGroupId = \"\" Then";
if ((_selectedgroupid).equals("")) { 
 //BA.debugLineNum = 639;BA.debugLine="ToastMessageShow(ModLang.T(\"csv_select_group_fir";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"csv_select_group_first")),__c.True);
 //BA.debugLineNum = 640;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 644;BA.debugLine="If ModSession.IsSessionActive Then";
if (_modsession._issessionactive /*boolean*/ (ba)) { 
 //BA.debugLineNum = 645;BA.debugLine="Log(\"Sessao ativa - importando direto\")";
__c.LogImpl("632309261","Sessao ativa - importando direto",0);
 //BA.debugLineNum = 646;BA.debugLine="DoImport";
_doimport();
 }else {
 //BA.debugLineNum = 649;BA.debugLine="ShowPassphraseDialog";
_showpassphrasedialog();
 };
 //BA.debugLineNum = 651;BA.debugLine="End Sub";
return "";
}
public String  _btnnewgroup_click() throws Exception{
 //BA.debugLineNum = 757;BA.debugLine="Private Sub btnNewGroup_Click";
 //BA.debugLineNum = 758;BA.debugLine="ShowNewGroupDialog";
_shownewgroupdialog();
 //BA.debugLineNum = 759;BA.debugLine="End Sub";
return "";
}
public String  _btnselectgroup_click() throws Exception{
 //BA.debugLineNum = 628;BA.debugLine="Private Sub btnSelectGroup_Click";
 //BA.debugLineNum = 629;BA.debugLine="ShowSelectGroupDialog";
_showselectgroupdialog();
 //BA.debugLineNum = 630;BA.debugLine="End Sub";
return "";
}
public String  _btnshowpass_click() throws Exception{
 //BA.debugLineNum = 1016;BA.debugLine="Private Sub btnShowPass_Click";
 //BA.debugLineNum = 1017;BA.debugLine="IsPassVisible = Not(IsPassVisible)";
_ispassvisible = __c.Not(_ispassvisible);
 //BA.debugLineNum = 1018;BA.debugLine="If IsPassVisible Then";
if (_ispassvisible) { 
 //BA.debugLineNum = 1019;BA.debugLine="edtPassphrase.InputType = ModSecurity.GetSecureV";
_edtpassphrase.setInputType(_modsecurity._getsecurevisibleinputtype /*int*/ (ba));
 //BA.debugLineNum = 1020;BA.debugLine="btnShowPass.Text = ModLang.T(\"hide\")";
_btnshowpass.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"hide")));
 }else {
 //BA.debugLineNum = 1022;BA.debugLine="edtPassphrase.InputType = ModSecurity.GetSecureP";
_edtpassphrase.setInputType(_modsecurity._getsecurepassphraseinputtype /*int*/ (ba));
 //BA.debugLineNum = 1023;BA.debugLine="btnShowPass.Text = ModLang.T(\"view\")";
_btnshowpass.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"view")));
 };
 //BA.debugLineNum = 1025;BA.debugLine="edtPassphrase.SelectionStart = edtPassphrase.Text";
_edtpassphrase.setSelectionStart(_edtpassphrase.getText().length());
 //BA.debugLineNum = 1026;BA.debugLine="End Sub";
return "";
}
public String  _btntoggleall_click() throws Exception{
int _filteredselected = 0;
anywheresoftware.b4a.objects.collections.Map _fe = null;
int _idx = 0;
int _pos = 0;
 //BA.debugLineNum = 543;BA.debugLine="Private Sub btnToggleAll_Click";
 //BA.debugLineNum = 545;BA.debugLine="Dim filteredSelected As Int = 0";
_filteredselected = (int) (0);
 //BA.debugLineNum = 546;BA.debugLine="For Each fe As Map In FilteredEntries";
_fe = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group2 = _filteredentries;
final int groupLen2 = group2.getSize()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_fe = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group2.Get(index2)));
 //BA.debugLineNum = 547;BA.debugLine="Dim idx As Int = fe.Get(\"index\")";
_idx = (int)(BA.ObjectToNumber(_fe.Get((Object)("index"))));
 //BA.debugLineNum = 548;BA.debugLine="If SelectedIndexes.IndexOf(idx) >= 0 Then";
if (_selectedindexes.IndexOf((Object)(_idx))>=0) { 
 //BA.debugLineNum = 549;BA.debugLine="filteredSelected = filteredSelected + 1";
_filteredselected = (int) (_filteredselected+1);
 };
 }
};
 //BA.debugLineNum = 553;BA.debugLine="If filteredSelected = FilteredEntries.Size And Fi";
if (_filteredselected==_filteredentries.getSize() && _filteredentries.getSize()>0) { 
 //BA.debugLineNum = 555;BA.debugLine="For Each fe As Map In FilteredEntries";
_fe = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group9 = _filteredentries;
final int groupLen9 = group9.getSize()
;int index9 = 0;
;
for (; index9 < groupLen9;index9++){
_fe = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group9.Get(index9)));
 //BA.debugLineNum = 556;BA.debugLine="Dim idx As Int = fe.Get(\"index\")";
_idx = (int)(BA.ObjectToNumber(_fe.Get((Object)("index"))));
 //BA.debugLineNum = 557;BA.debugLine="Dim pos As Int = SelectedIndexes.IndexOf(idx)";
_pos = _selectedindexes.IndexOf((Object)(_idx));
 //BA.debugLineNum = 558;BA.debugLine="If pos >= 0 Then";
if (_pos>=0) { 
 //BA.debugLineNum = 559;BA.debugLine="SelectedIndexes.RemoveAt(pos)";
_selectedindexes.RemoveAt(_pos);
 };
 }
};
 }else {
 //BA.debugLineNum = 564;BA.debugLine="For Each fe As Map In FilteredEntries";
_fe = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group17 = _filteredentries;
final int groupLen17 = group17.getSize()
;int index17 = 0;
;
for (; index17 < groupLen17;index17++){
_fe = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group17.Get(index17)));
 //BA.debugLineNum = 565;BA.debugLine="Dim idx As Int = fe.Get(\"index\")";
_idx = (int)(BA.ObjectToNumber(_fe.Get((Object)("index"))));
 //BA.debugLineNum = 566;BA.debugLine="If SelectedIndexes.IndexOf(idx) < 0 Then";
if (_selectedindexes.IndexOf((Object)(_idx))<0) { 
 //BA.debugLineNum = 567;BA.debugLine="SelectedIndexes.Add(idx)";
_selectedindexes.Add((Object)(_idx));
 };
 }
};
 };
 //BA.debugLineNum = 571;BA.debugLine="LoadEntries";
_loadentries();
 //BA.debugLineNum = 572;BA.debugLine="UpdateInfo";
_updateinfo();
 //BA.debugLineNum = 573;BA.debugLine="End Sub";
return "";
}
public String  _btnunlockgroup_click() throws Exception{
String _phrase = "";
com.lockzero.clspasswordgroup _g = null;
 //BA.debugLineNum = 977;BA.debugLine="Private Sub btnUnlockGroup_Click";
 //BA.debugLineNum = 978;BA.debugLine="Dim phrase As String = edtPassphrase.Text.Trim";
_phrase = _edtpassphrase.getText().trim();
 //BA.debugLineNum = 980;BA.debugLine="If phrase = \"\" Then";
if ((_phrase).equals("")) { 
 //BA.debugLineNum = 981;BA.debugLine="ToastMessageShow(ModLang.T(\"error_empty_field\"),";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error_empty_field")),__c.True);
 //BA.debugLineNum = 982;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 985;BA.debugLine="Log(\"=== btnUnlockGroup_Click ===\")";
__c.LogImpl("632833544","=== btnUnlockGroup_Click ===",0);
 //BA.debugLineNum = 986;BA.debugLine="Log(\"SelectedGroupId: \" & SelectedGroupId)";
__c.LogImpl("632833545","SelectedGroupId: "+_selectedgroupid,0);
 //BA.debugLineNum = 987;BA.debugLine="Log(\"SelectedGroupName: \" & SelectedGroupName)";
__c.LogImpl("632833546","SelectedGroupName: "+_selectedgroupname,0);
 //BA.debugLineNum = 990;BA.debugLine="Dim g As clsPasswordGroup = ModPasswords.GetGroup";
_g = _modpasswords._getgroupbyid /*com.lockzero.clspasswordgroup*/ (ba,_selectedgroupid);
 //BA.debugLineNum = 991;BA.debugLine="If g.IsInitialized = False Then";
if (_g._isinitialized /*boolean*/ ()==__c.False) { 
 //BA.debugLineNum = 992;BA.debugLine="Log(\"ERRO: Grupo nao encontrado com ID: \" & Sele";
__c.LogImpl("632833551","ERRO: Grupo nao encontrado com ID: "+_selectedgroupid,0);
 //BA.debugLineNum = 993;BA.debugLine="ToastMessageShow(ModLang.T(\"error\") & \" - Grupo";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error")+" - Grupo não encontrado"),__c.True);
 //BA.debugLineNum = 994;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 995;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 998;BA.debugLine="Log(\"Grupo encontrado: \" & g.Name)";
__c.LogImpl("632833557","Grupo encontrado: "+_g._name /*String*/ ,0);
 //BA.debugLineNum = 1000;BA.debugLine="If g.ValidatePhrase(phrase) = False Then";
if (_g._validatephrase /*boolean*/ (_phrase)==__c.False) { 
 //BA.debugLineNum = 1001;BA.debugLine="ToastMessageShow(ModLang.T(\"wrong_passphrase\"),";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"wrong_passphrase")),__c.True);
 //BA.debugLineNum = 1002;BA.debugLine="ModSecurity.ClearSecureField(edtPassphrase)";
_modsecurity._clearsecurefield /*String*/ (ba,_edtpassphrase);
 //BA.debugLineNum = 1003;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 1007;BA.debugLine="ModSession.StartSessionWithCategory(phrase, \"pass";
_modsession._startsessionwithcategory /*String*/ (ba,_phrase,"passwords");
 //BA.debugLineNum = 1010;BA.debugLine="ModSecurity.ClearSecureField(edtPassphrase)";
_modsecurity._clearsecurefield /*String*/ (ba,_edtpassphrase);
 //BA.debugLineNum = 1012;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 1013;BA.debugLine="DoImport";
_doimport();
 //BA.debugLineNum = 1014;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 4;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Public Root As B4XView  'Public para transicoes";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 6;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 9;BA.debugLine="Private btnBack As Button";
_btnback = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 10;BA.debugLine="Private lblHeaderTitle As Label";
_lblheadertitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Private lblInfo As Label";
_lblinfo = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Private lblSelected As Label";
_lblselected = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Private btnToggleAll As Button";
_btntoggleall = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private svEntries As ScrollView";
_sventries = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private pnlEntries As B4XView";
_pnlentries = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private pnlBottom As Panel";
_pnlbottom = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private btnSelectGroup As Button";
_btnselectgroup = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private btnImport As Button";
_btnimport = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private CSVEntries As List 'Lista de Maps com dad";
_csventries = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 28;BA.debugLine="Private FilteredEntries As List 'Lista filtrada p";
_filteredentries = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 29;BA.debugLine="Private SelectedIndexes As List 'Indices selecion";
_selectedindexes = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 30;BA.debugLine="Private SelectedGroupId As String";
_selectedgroupid = "";
 //BA.debugLineNum = 31;BA.debugLine="Private SelectedGroupName As String";
_selectedgroupname = "";
 //BA.debugLineNum = 34;BA.debugLine="Private edtSearch As EditText";
_edtsearch = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private lblClearSearch As Label";
_lblclearsearch = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private CurrentFilter As String = \"\"";
_currentfilter = "";
 //BA.debugLineNum = 39;BA.debugLine="Private CSVFolder As String";
_csvfolder = "";
 //BA.debugLineNum = 40;BA.debugLine="Private CSVFileName As String";
_csvfilename = "";
 //BA.debugLineNum = 41;BA.debugLine="Private LastParsedFile As String 'Para detectar s";
_lastparsedfile = "";
 //BA.debugLineNum = 44;BA.debugLine="Private pnlOverlay As Panel";
_pnloverlay = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private pnlDialog As Panel";
_pnldialog = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private CurrentDialogMode As String 'select_group";
_currentdialogmode = "";
 //BA.debugLineNum = 49;BA.debugLine="Private edtGroupName As EditText";
_edtgroupname = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 50;BA.debugLine="Private edtPassphrase As EditText";
_edtpassphrase = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 51;BA.debugLine="Private btnShowPass As Button";
_btnshowpass = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 52;BA.debugLine="Private IsPassVisible As Boolean = False";
_ispassvisible = __c.False;
 //BA.debugLineNum = 53;BA.debugLine="End Sub";
return "";
}
public String  _createdialogoverlay() throws Exception{
int _width = 0;
int _height = 0;
int _dialogw = 0;
int _dialogh = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _xvdialog = null;
 //BA.debugLineNum = 251;BA.debugLine="Private Sub CreateDialogOverlay";
 //BA.debugLineNum = 252;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 253;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 255;BA.debugLine="pnlOverlay.Initialize(\"pnlOverlay\")";
_pnloverlay.Initialize(ba,"pnlOverlay");
 //BA.debugLineNum = 256;BA.debugLine="pnlOverlay.Color = Colors.ARGB(180, 0, 0, 0)";
_pnloverlay.setColor(__c.Colors.ARGB((int) (180),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 257;BA.debugLine="pnlOverlay.Visible = False";
_pnloverlay.setVisible(__c.False);
 //BA.debugLineNum = 258;BA.debugLine="Root.AddView(pnlOverlay, 0, 0, width, height)";
_root.AddView((android.view.View)(_pnloverlay.getObject()),(int) (0),(int) (0),_width,_height);
 //BA.debugLineNum = 260;BA.debugLine="Dim dialogW As Int = width - 40dip";
_dialogw = (int) (_width-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 261;BA.debugLine="Dim dialogH As Int = 280dip";
_dialogh = __c.DipToCurrent((int) (280));
 //BA.debugLineNum = 263;BA.debugLine="pnlDialog.Initialize(\"\")";
_pnldialog.Initialize(ba,"");
 //BA.debugLineNum = 264;BA.debugLine="pnlDialog.Color = ModTheme.HomeHeaderBg";
_pnldialog.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 265;BA.debugLine="pnlOverlay.AddView(pnlDialog, 20dip, 80dip, dialo";
_pnloverlay.AddView((android.view.View)(_pnldialog.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (80)),_dialogw,_dialogh);
 //BA.debugLineNum = 267;BA.debugLine="Dim xvDialog As B4XView = pnlDialog";
_xvdialog = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvdialog = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnldialog.getObject()));
 //BA.debugLineNum = 268;BA.debugLine="xvDialog.SetColorAndBorder(ModTheme.HomeHeaderBg,";
_xvdialog.SetColorAndBorder(_modtheme._homeheaderbg /*int*/ (ba),(int) (0),_modtheme._homeheaderbg /*int*/ (ba),__c.DipToCurrent((int) (12)));
 //BA.debugLineNum = 269;BA.debugLine="End Sub";
return "";
}
public String  _createui() throws Exception{
int _width = 0;
int _height = 0;
int _headerh = 0;
int _bottomh = 0;
int _infoh = 0;
int _searchh = 0;
anywheresoftware.b4a.objects.PanelWrapper _pnlheader = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlinfo = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlsearch = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlsearchfield = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xvsearchfield = null;
 //BA.debugLineNum = 113;BA.debugLine="Private Sub CreateUI";
 //BA.debugLineNum = 114;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 115;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 116;BA.debugLine="Dim headerH As Int = 56dip";
_headerh = __c.DipToCurrent((int) (56));
 //BA.debugLineNum = 117;BA.debugLine="Dim bottomH As Int = 70dip";
_bottomh = __c.DipToCurrent((int) (70));
 //BA.debugLineNum = 118;BA.debugLine="Dim infoH As Int = 80dip";
_infoh = __c.DipToCurrent((int) (80));
 //BA.debugLineNum = 119;BA.debugLine="Dim searchH As Int = 50dip";
_searchh = __c.DipToCurrent((int) (50));
 //BA.debugLineNum = 124;BA.debugLine="Dim pnlHeader As Panel";
_pnlheader = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 125;BA.debugLine="pnlHeader.Initialize(\"\")";
_pnlheader.Initialize(ba,"");
 //BA.debugLineNum = 126;BA.debugLine="pnlHeader.Color = ModTheme.HomeHeaderBg";
_pnlheader.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 127;BA.debugLine="Root.AddView(pnlHeader, 0, 0, width, headerH)";
_root.AddView((android.view.View)(_pnlheader.getObject()),(int) (0),(int) (0),_width,_headerh);
 //BA.debugLineNum = 130;BA.debugLine="btnBack.Initialize(\"btnBack\")";
_btnback.Initialize(ba,"btnBack");
 //BA.debugLineNum = 131;BA.debugLine="btnBack.Text = \"<\"";
_btnback.setText(BA.ObjectToCharSequence("<"));
 //BA.debugLineNum = 132;BA.debugLine="btnBack.TextSize = 20";
_btnback.setTextSize((float) (20));
 //BA.debugLineNum = 133;BA.debugLine="btnBack.Color = Colors.Transparent";
_btnback.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 134;BA.debugLine="btnBack.TextColor = Colors.White";
_btnback.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 135;BA.debugLine="btnBack.Gravity = Gravity.CENTER";
_btnback.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 136;BA.debugLine="pnlHeader.AddView(btnBack, 0, 0, 50dip, headerH)";
_pnlheader.AddView((android.view.View)(_btnback.getObject()),(int) (0),(int) (0),__c.DipToCurrent((int) (50)),_headerh);
 //BA.debugLineNum = 139;BA.debugLine="lblHeaderTitle.Initialize(\"\")";
_lblheadertitle.Initialize(ba,"");
 //BA.debugLineNum = 140;BA.debugLine="lblHeaderTitle.Text = ModLang.T(\"import_csv\")";
_lblheadertitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"import_csv")));
 //BA.debugLineNum = 141;BA.debugLine="lblHeaderTitle.TextSize = 16";
_lblheadertitle.setTextSize((float) (16));
 //BA.debugLineNum = 142;BA.debugLine="lblHeaderTitle.TextColor = Colors.White";
_lblheadertitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 143;BA.debugLine="lblHeaderTitle.Typeface = Typeface.DEFAULT_BOLD";
_lblheadertitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 144;BA.debugLine="lblHeaderTitle.Gravity = Gravity.CENTER_VERTICAL";
_lblheadertitle.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 145;BA.debugLine="pnlHeader.AddView(lblHeaderTitle, 50dip, 0, width";
_pnlheader.AddView((android.view.View)(_lblheadertitle.getObject()),__c.DipToCurrent((int) (50)),(int) (0),(int) (_width-__c.DipToCurrent((int) (60))),_headerh);
 //BA.debugLineNum = 150;BA.debugLine="Dim pnlInfo As Panel";
_pnlinfo = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 151;BA.debugLine="pnlInfo.Initialize(\"\")";
_pnlinfo.Initialize(ba,"");
 //BA.debugLineNum = 152;BA.debugLine="pnlInfo.Color = ModTheme.HomeBg";
_pnlinfo.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 153;BA.debugLine="Root.AddView(pnlInfo, 0, headerH, width, infoH)";
_root.AddView((android.view.View)(_pnlinfo.getObject()),(int) (0),_headerh,_width,_infoh);
 //BA.debugLineNum = 156;BA.debugLine="lblInfo.Initialize(\"\")";
_lblinfo.Initialize(ba,"");
 //BA.debugLineNum = 157;BA.debugLine="lblInfo.Text = \"0 \" & ModLang.T(\"csv_entries_foun";
_lblinfo.setText(BA.ObjectToCharSequence("0 "+_modlang._t /*String*/ (ba,"csv_entries_found")));
 //BA.debugLineNum = 158;BA.debugLine="lblInfo.TextSize = Starter.FONT_BODY";
_lblinfo.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 159;BA.debugLine="lblInfo.TextColor = Colors.White";
_lblinfo.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 160;BA.debugLine="lblInfo.Gravity = Gravity.CENTER_VERTICAL";
_lblinfo.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 161;BA.debugLine="pnlInfo.AddView(lblInfo, 16dip, 5dip, width - 32d";
_pnlinfo.AddView((android.view.View)(_lblinfo.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (5)),(int) (_width-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 164;BA.debugLine="lblSelected.Initialize(\"\")";
_lblselected.Initialize(ba,"");
 //BA.debugLineNum = 165;BA.debugLine="lblSelected.Text = ModLang.T(\"csv_selected\") & \":";
_lblselected.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"csv_selected")+": 0"));
 //BA.debugLineNum = 166;BA.debugLine="lblSelected.TextSize = Starter.FONT_CAPTION";
_lblselected.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 167;BA.debugLine="lblSelected.TextColor = Colors.ARGB(180, 255, 255";
_lblselected.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 168;BA.debugLine="pnlInfo.AddView(lblSelected, 16dip, 35dip, width";
_pnlinfo.AddView((android.view.View)(_lblselected.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (35)),(int) (_width-__c.DipToCurrent((int) (150))),__c.DipToCurrent((int) (25)));
 //BA.debugLineNum = 171;BA.debugLine="btnToggleAll.Initialize(\"btnToggleAll\")";
_btntoggleall.Initialize(ba,"btnToggleAll");
 //BA.debugLineNum = 172;BA.debugLine="btnToggleAll.Text = ModLang.T(\"csv_select_all\")";
_btntoggleall.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"csv_select_all")));
 //BA.debugLineNum = 173;BA.debugLine="btnToggleAll.TextSize = Starter.FONT_CAPTION";
_btntoggleall.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 174;BA.debugLine="btnToggleAll.Color = ModTheme.HomeIconBg";
_btntoggleall.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 175;BA.debugLine="btnToggleAll.TextColor = Colors.White";
_btntoggleall.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 176;BA.debugLine="pnlInfo.AddView(btnToggleAll, width - 140dip, 30d";
_pnlinfo.AddView((android.view.View)(_btntoggleall.getObject()),(int) (_width-__c.DipToCurrent((int) (140))),__c.DipToCurrent((int) (30)),__c.DipToCurrent((int) (125)),__c.DipToCurrent((int) (35)));
 //BA.debugLineNum = 181;BA.debugLine="Dim pnlSearch As Panel";
_pnlsearch = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 182;BA.debugLine="pnlSearch.Initialize(\"\")";
_pnlsearch.Initialize(ba,"");
 //BA.debugLineNum = 183;BA.debugLine="pnlSearch.Color = ModTheme.HomeBg";
_pnlsearch.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 184;BA.debugLine="Root.AddView(pnlSearch, 0, headerH + infoH, width";
_root.AddView((android.view.View)(_pnlsearch.getObject()),(int) (0),(int) (_headerh+_infoh),_width,_searchh);
 //BA.debugLineNum = 187;BA.debugLine="edtSearch.Initialize(\"edtSearch\")";
_edtsearch.Initialize(ba,"edtSearch");
 //BA.debugLineNum = 188;BA.debugLine="edtSearch.Hint = ModLang.T(\"search_hint\")";
_edtsearch.setHint(_modlang._t /*String*/ (ba,"search_hint"));
 //BA.debugLineNum = 189;BA.debugLine="edtSearch.SingleLine = True";
_edtsearch.setSingleLine(__c.True);
 //BA.debugLineNum = 190;BA.debugLine="edtSearch.InputType = 1 'text";
_edtsearch.setInputType((int) (1));
 //BA.debugLineNum = 191;BA.debugLine="edtSearch.Text = \"\"";
_edtsearch.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 192;BA.debugLine="edtSearch.TextColor = Colors.White";
_edtsearch.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 193;BA.debugLine="edtSearch.HintColor = Colors.ARGB(120, 255, 255,";
_edtsearch.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 195;BA.debugLine="Dim pnlSearchField As Panel";
_pnlsearchfield = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 196;BA.debugLine="pnlSearchField.Initialize(\"\")";
_pnlsearchfield.Initialize(ba,"");
 //BA.debugLineNum = 197;BA.debugLine="pnlSearchField.Color = ModTheme.HomeIconBg";
_pnlsearchfield.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 198;BA.debugLine="Dim xvSearchField As B4XView = pnlSearchField";
_xvsearchfield = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvsearchfield = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnlsearchfield.getObject()));
 //BA.debugLineNum = 199;BA.debugLine="xvSearchField.SetColorAndBorder(ModTheme.HomeIcon";
_xvsearchfield.SetColorAndBorder(_modtheme._homeiconbg /*int*/ (ba),(int) (0),_modtheme._homeiconbg /*int*/ (ba),__c.DipToCurrent((int) (8)));
 //BA.debugLineNum = 200;BA.debugLine="pnlSearch.AddView(pnlSearchField, 12dip, 6dip, wi";
_pnlsearch.AddView((android.view.View)(_pnlsearchfield.getObject()),__c.DipToCurrent((int) (12)),__c.DipToCurrent((int) (6)),(int) (_width-__c.DipToCurrent((int) (60))),__c.DipToCurrent((int) (42)));
 //BA.debugLineNum = 201;BA.debugLine="pnlSearchField.AddView(edtSearch, 10dip, 2dip, wi";
_pnlsearchfield.AddView((android.view.View)(_edtsearch.getObject()),__c.DipToCurrent((int) (10)),__c.DipToCurrent((int) (2)),(int) (_width-__c.DipToCurrent((int) (90))),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 204;BA.debugLine="lblClearSearch.Initialize(\"lblClearSearch\")";
_lblclearsearch.Initialize(ba,"lblClearSearch");
 //BA.debugLineNum = 205;BA.debugLine="lblClearSearch.Text = \"X\"";
_lblclearsearch.setText(BA.ObjectToCharSequence("X"));
 //BA.debugLineNum = 206;BA.debugLine="lblClearSearch.TextSize = 14";
_lblclearsearch.setTextSize((float) (14));
 //BA.debugLineNum = 207;BA.debugLine="lblClearSearch.TextColor = Colors.White";
_lblclearsearch.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 208;BA.debugLine="lblClearSearch.Gravity = Gravity.CENTER";
_lblclearsearch.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 209;BA.debugLine="lblClearSearch.Visible = False 'So aparece quando";
_lblclearsearch.setVisible(__c.False);
 //BA.debugLineNum = 210;BA.debugLine="pnlSearch.AddView(lblClearSearch, width - 45dip,";
_pnlsearch.AddView((android.view.View)(_lblclearsearch.getObject()),(int) (_width-__c.DipToCurrent((int) (45))),__c.DipToCurrent((int) (6)),__c.DipToCurrent((int) (35)),__c.DipToCurrent((int) (42)));
 //BA.debugLineNum = 215;BA.debugLine="svEntries.Initialize(0)";
_sventries.Initialize(ba,(int) (0));
 //BA.debugLineNum = 216;BA.debugLine="svEntries.Color = ModTheme.HomeBg";
_sventries.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 217;BA.debugLine="Root.AddView(svEntries, 0, headerH + infoH + sear";
_root.AddView((android.view.View)(_sventries.getObject()),(int) (0),(int) (_headerh+_infoh+_searchh),_width,(int) (_height-_headerh-_infoh-_searchh-_bottomh));
 //BA.debugLineNum = 219;BA.debugLine="pnlEntries = svEntries.Panel";
_pnlentries = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_sventries.getPanel().getObject()));
 //BA.debugLineNum = 220;BA.debugLine="pnlEntries.Color = ModTheme.HomeBg";
_pnlentries.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 225;BA.debugLine="pnlBottom.Initialize(\"\")";
_pnlbottom.Initialize(ba,"");
 //BA.debugLineNum = 226;BA.debugLine="pnlBottom.Color = ModTheme.HomeHeaderBg";
_pnlbottom.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 227;BA.debugLine="Root.AddView(pnlBottom, 0, height - bottomH, widt";
_root.AddView((android.view.View)(_pnlbottom.getObject()),(int) (0),(int) (_height-_bottomh),_width,_bottomh);
 //BA.debugLineNum = 230;BA.debugLine="btnSelectGroup.Initialize(\"btnSelectGroup\")";
_btnselectgroup.Initialize(ba,"btnSelectGroup");
 //BA.debugLineNum = 231;BA.debugLine="btnSelectGroup.Text = ModLang.T(\"csv_select_group";
_btnselectgroup.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"csv_select_group")));
 //BA.debugLineNum = 232;BA.debugLine="btnSelectGroup.TextSize = Starter.FONT_BUTTON";
_btnselectgroup.setTextSize(_starter._font_button /*float*/ );
 //BA.debugLineNum = 233;BA.debugLine="btnSelectGroup.Color = ModTheme.HomeBg";
_btnselectgroup.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 234;BA.debugLine="btnSelectGroup.TextColor = Colors.White";
_btnselectgroup.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 235;BA.debugLine="pnlBottom.AddView(btnSelectGroup, 10dip, 12dip, (";
_pnlbottom.AddView((android.view.View)(_btnselectgroup.getObject()),__c.DipToCurrent((int) (10)),__c.DipToCurrent((int) (12)),(int) ((_width/(double)2)-__c.DipToCurrent((int) (15))),__c.DipToCurrent((int) (46)));
 //BA.debugLineNum = 238;BA.debugLine="btnImport.Initialize(\"btnImport\")";
_btnimport.Initialize(ba,"btnImport");
 //BA.debugLineNum = 239;BA.debugLine="btnImport.Text = ModLang.T(\"csv_import_btn\") & \"";
_btnimport.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"csv_import_btn")+" (0)"));
 //BA.debugLineNum = 240;BA.debugLine="btnImport.TextSize = Starter.FONT_BUTTON";
_btnimport.setTextSize(_starter._font_button /*float*/ );
 //BA.debugLineNum = 241;BA.debugLine="btnImport.Color = ModTheme.HomeIconBg";
_btnimport.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 242;BA.debugLine="btnImport.TextColor = Colors.White";
_btnimport.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 243;BA.debugLine="pnlBottom.AddView(btnImport, (width / 2) + 5dip,";
_pnlbottom.AddView((android.view.View)(_btnimport.getObject()),(int) ((_width/(double)2)+__c.DipToCurrent((int) (5))),__c.DipToCurrent((int) (12)),(int) ((_width/(double)2)-__c.DipToCurrent((int) (15))),__c.DipToCurrent((int) (46)));
 //BA.debugLineNum = 248;BA.debugLine="CreateDialogOverlay";
_createdialogoverlay();
 //BA.debugLineNum = 249;BA.debugLine="End Sub";
return "";
}
public String  _doimport() throws Exception{
int _imported = 0;
int _updated = 0;
int _idx = 0;
anywheresoftware.b4a.objects.collections.Map _csventry = null;
String _name = "";
String _url = "";
String _username = "";
String _password = "";
String _note = "";
String _encusername = "";
String _encpassword = "";
String _encnote = "";
String _existingid = "";
com.lockzero.clspasswordentry _existing = null;
com.lockzero.clspasswordentry _e = null;
String _msg = "";
boolean _hasfilter = false;
anywheresoftware.b4a.objects.collections.List _toremove = null;
int _i = 0;
 //BA.debugLineNum = 1044;BA.debugLine="Private Sub DoImport";
 //BA.debugLineNum = 1045;BA.debugLine="Dim imported As Int = 0";
_imported = (int) (0);
 //BA.debugLineNum = 1046;BA.debugLine="Dim updated As Int = 0";
_updated = (int) (0);
 //BA.debugLineNum = 1048;BA.debugLine="For Each idx As Int In SelectedIndexes";
{
final anywheresoftware.b4a.BA.IterableList group3 = _selectedindexes;
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_idx = (int)(BA.ObjectToNumber(group3.Get(index3)));
 //BA.debugLineNum = 1049;BA.debugLine="Dim csvEntry As Map = CSVEntries.Get(idx)";
_csventry = new anywheresoftware.b4a.objects.collections.Map();
_csventry = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_csventries.Get(_idx)));
 //BA.debugLineNum = 1051;BA.debugLine="Dim name As String = csvEntry.Get(\"name\")";
_name = BA.ObjectToString(_csventry.Get((Object)("name")));
 //BA.debugLineNum = 1052;BA.debugLine="Dim url As String = csvEntry.Get(\"url\")";
_url = BA.ObjectToString(_csventry.Get((Object)("url")));
 //BA.debugLineNum = 1053;BA.debugLine="Dim username As String = csvEntry.Get(\"username\"";
_username = BA.ObjectToString(_csventry.Get((Object)("username")));
 //BA.debugLineNum = 1054;BA.debugLine="Dim password As String = csvEntry.Get(\"password\"";
_password = BA.ObjectToString(_csventry.Get((Object)("password")));
 //BA.debugLineNum = 1055;BA.debugLine="Dim note As String = csvEntry.Get(\"note\")";
_note = BA.ObjectToString(_csventry.Get((Object)("note")));
 //BA.debugLineNum = 1057;BA.debugLine="If name = \"\" Then name = url";
if ((_name).equals("")) { 
_name = _url;};
 //BA.debugLineNum = 1059;BA.debugLine="Log(\"=== Importando: \" & name & \" ===\")";
__c.LogImpl("633095695","=== Importando: "+_name+" ===",0);
 //BA.debugLineNum = 1060;BA.debugLine="Log(\"Username plain: \" & username)";
__c.LogImpl("633095696","Username plain: "+_username,0);
 //BA.debugLineNum = 1061;BA.debugLine="Log(\"Password plain: \" & password.SubString2(0,";
__c.LogImpl("633095697","Password plain: "+_password.substring((int) (0),(int) (__c.Min(3,_password.length())))+"***",0);
 //BA.debugLineNum = 1062;BA.debugLine="Log(\"Session active: \" & ModSession.IsSessionAct";
__c.LogImpl("633095698","Session active: "+BA.ObjectToString(_modsession._issessionactive /*boolean*/ (ba)),0);
 //BA.debugLineNum = 1065;BA.debugLine="Dim encUsername As String = ModSession.Encrypt(u";
_encusername = _modsession._encrypt /*String*/ (ba,_username);
 //BA.debugLineNum = 1066;BA.debugLine="Dim encPassword As String = ModSession.Encrypt(p";
_encpassword = _modsession._encrypt /*String*/ (ba,_password);
 //BA.debugLineNum = 1067;BA.debugLine="Dim encNote As String = \"\"";
_encnote = "";
 //BA.debugLineNum = 1068;BA.debugLine="If note <> \"\" Then encNote = ModSession.Encrypt(";
if ((_note).equals("") == false) { 
_encnote = _modsession._encrypt /*String*/ (ba,_note);};
 //BA.debugLineNum = 1070;BA.debugLine="Log(\"Username enc: \" & encUsername.SubString2(0,";
__c.LogImpl("633095706","Username enc: "+_encusername.substring((int) (0),(int) (__c.Min(20,_encusername.length())))+"...",0);
 //BA.debugLineNum = 1071;BA.debugLine="Log(\"Password enc: \" & encPassword.SubString2(0,";
__c.LogImpl("633095707","Password enc: "+_encpassword.substring((int) (0),(int) (__c.Min(20,_encpassword.length())))+"...",0);
 //BA.debugLineNum = 1074;BA.debugLine="If encUsername = \"\" Or encPassword = \"\" Then";
if ((_encusername).equals("") || (_encpassword).equals("")) { 
 //BA.debugLineNum = 1075;BA.debugLine="Log(\"ERRO: Criptografia falhou!\")";
__c.LogImpl("633095711","ERRO: Criptografia falhou!",0);
 //BA.debugLineNum = 1076;BA.debugLine="Continue";
if (true) continue;
 };
 //BA.debugLineNum = 1080;BA.debugLine="Dim existingId As String = FindExistingEntry(url";
_existingid = _findexistingentry(_url,_username);
 //BA.debugLineNum = 1082;BA.debugLine="If existingId <> \"\" Then";
if ((_existingid).equals("") == false) { 
 //BA.debugLineNum = 1084;BA.debugLine="Dim existing As clsPasswordEntry = ModPasswords";
_existing = _modpasswords._getentrybyid /*com.lockzero.clspasswordentry*/ (ba,_existingid);
 //BA.debugLineNum = 1085;BA.debugLine="existing.PasswordEnc = encPassword";
_existing._passwordenc /*String*/  = _encpassword;
 //BA.debugLineNum = 1086;BA.debugLine="If encNote <> \"\" Then existing.Notes = encNote";
if ((_encnote).equals("") == false) { 
_existing._notes /*String*/  = _encnote;};
 //BA.debugLineNum = 1087;BA.debugLine="existing.UpdatedAt = DateTime.Now";
_existing._updatedat /*long*/  = __c.DateTime.getNow();
 //BA.debugLineNum = 1088;BA.debugLine="ModPasswords.SaveEntry(existing)";
_modpasswords._saveentry /*String*/ (ba,_existing);
 //BA.debugLineNum = 1089;BA.debugLine="updated = updated + 1";
_updated = (int) (_updated+1);
 }else {
 //BA.debugLineNum = 1092;BA.debugLine="Dim e As clsPasswordEntry";
_e = new com.lockzero.clspasswordentry();
 //BA.debugLineNum = 1093;BA.debugLine="e.Initialize";
_e._initialize /*String*/ (ba);
 //BA.debugLineNum = 1094;BA.debugLine="e.GroupId = SelectedGroupId";
_e._groupid /*String*/  = _selectedgroupid;
 //BA.debugLineNum = 1095;BA.debugLine="e.Name = name";
_e._name /*String*/  = _name;
 //BA.debugLineNum = 1096;BA.debugLine="e.Url = url";
_e._url /*String*/  = _url;
 //BA.debugLineNum = 1097;BA.debugLine="e.Username = encUsername";
_e._username /*String*/  = _encusername;
 //BA.debugLineNum = 1098;BA.debugLine="e.PasswordEnc = encPassword";
_e._passwordenc /*String*/  = _encpassword;
 //BA.debugLineNum = 1099;BA.debugLine="If encNote <> \"\" Then e.Notes = encNote";
if ((_encnote).equals("") == false) { 
_e._notes /*String*/  = _encnote;};
 //BA.debugLineNum = 1100;BA.debugLine="ModPasswords.SaveEntry(e)";
_modpasswords._saveentry /*String*/ (ba,_e);
 //BA.debugLineNum = 1101;BA.debugLine="imported = imported + 1";
_imported = (int) (_imported+1);
 };
 }
};
 //BA.debugLineNum = 1106;BA.debugLine="Dim msg As String = imported & \" \" & ModLang.T(\"c";
_msg = BA.NumberToString(_imported)+" "+_modlang._t /*String*/ (ba,"csv_imported");
 //BA.debugLineNum = 1107;BA.debugLine="If updated > 0 Then";
if (_updated>0) { 
 //BA.debugLineNum = 1108;BA.debugLine="msg = msg & \", \" & updated & \" \" & ModLang.T(\"cs";
_msg = _msg+", "+BA.NumberToString(_updated)+" "+_modlang._t /*String*/ (ba,"csv_updated");
 };
 //BA.debugLineNum = 1110;BA.debugLine="ToastMessageShow(msg, True)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_msg),__c.True);
 //BA.debugLineNum = 1113;BA.debugLine="Dim hasFilter As Boolean = edtSearch.IsInitialize";
_hasfilter = _edtsearch.IsInitialized() && _edtsearch.getText().trim().length()>0;
 //BA.debugLineNum = 1114;BA.debugLine="Log(\"DoImport - hasFilter: \" & hasFilter & \", edt";
__c.LogImpl("633095750","DoImport - hasFilter: "+BA.ObjectToString(_hasfilter)+", edtSearch.Text: "+_edtsearch.getText(),0);
 //BA.debugLineNum = 1116;BA.debugLine="If hasFilter Then";
if (_hasfilter) { 
 //BA.debugLineNum = 1118;BA.debugLine="Dim toRemove As List";
_toremove = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1119;BA.debugLine="toRemove.Initialize";
_toremove.Initialize();
 //BA.debugLineNum = 1120;BA.debugLine="toRemove.AddAll(SelectedIndexes)";
_toremove.AddAll(_selectedindexes);
 //BA.debugLineNum = 1122;BA.debugLine="toRemove.Sort(True)";
_toremove.Sort(__c.True);
 //BA.debugLineNum = 1124;BA.debugLine="For i = toRemove.Size - 1 To 0 Step -1";
{
final int step58 = -1;
final int limit58 = (int) (0);
_i = (int) (_toremove.getSize()-1) ;
for (;_i >= limit58 ;_i = _i + step58 ) {
 //BA.debugLineNum = 1125;BA.debugLine="Dim idx As Int = toRemove.Get(i)";
_idx = (int)(BA.ObjectToNumber(_toremove.Get(_i)));
 //BA.debugLineNum = 1126;BA.debugLine="If idx < CSVEntries.Size Then";
if (_idx<_csventries.getSize()) { 
 //BA.debugLineNum = 1127;BA.debugLine="CSVEntries.RemoveAt(idx)";
_csventries.RemoveAt(_idx);
 };
 }
};
 //BA.debugLineNum = 1131;BA.debugLine="edtSearch.Text = \"\"";
_edtsearch.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1132;BA.debugLine="CurrentFilter = \"\"";
_currentfilter = "";
 //BA.debugLineNum = 1133;BA.debugLine="lblClearSearch.Visible = False";
_lblclearsearch.setVisible(__c.False);
 //BA.debugLineNum = 1134;BA.debugLine="SelectedIndexes.Initialize";
_selectedindexes.Initialize();
 //BA.debugLineNum = 1135;BA.debugLine="ApplyFilter";
_applyfilter();
 //BA.debugLineNum = 1136;BA.debugLine="UpdateInfo";
_updateinfo();
 //BA.debugLineNum = 1137;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 1141;BA.debugLine="Main.PendingCSVFile = \"\"";
_main._pendingcsvfile /*String*/  = "";
 //BA.debugLineNum = 1142;BA.debugLine="Main.PendingCSVFolder = \"\"";
_main._pendingcsvfolder /*String*/  = "";
 //BA.debugLineNum = 1143;BA.debugLine="CSVEntries.Initialize";
_csventries.Initialize();
 //BA.debugLineNum = 1144;BA.debugLine="SelectedIndexes.Initialize";
_selectedindexes.Initialize();
 //BA.debugLineNum = 1145;BA.debugLine="CSVFileName = \"\"";
_csvfilename = "";
 //BA.debugLineNum = 1146;BA.debugLine="CSVFolder = \"\"";
_csvfolder = "";
 //BA.debugLineNum = 1147;BA.debugLine="LastParsedFile = \"\"";
_lastparsedfile = "";
 //BA.debugLineNum = 1148;BA.debugLine="SelectedGroupId = \"\"";
_selectedgroupid = "";
 //BA.debugLineNum = 1149;BA.debugLine="SelectedGroupName = \"\"";
_selectedgroupname = "";
 //BA.debugLineNum = 1152;BA.debugLine="B4XPages.ClosePage(Me)";
_b4xpages._closepage /*String*/ (ba,this);
 //BA.debugLineNum = 1153;BA.debugLine="End Sub";
return "";
}
public String  _edtsearch_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 579;BA.debugLine="Private Sub edtSearch_TextChanged(Old As String, N";
 //BA.debugLineNum = 580;BA.debugLine="CurrentFilter = New.Trim.ToLowerCase";
_currentfilter = _new.trim().toLowerCase();
 //BA.debugLineNum = 581;BA.debugLine="lblClearSearch.Visible = (CurrentFilter.Length >";
_lblclearsearch.setVisible((_currentfilter.length()>0));
 //BA.debugLineNum = 582;BA.debugLine="ApplyFilter";
_applyfilter();
 //BA.debugLineNum = 583;BA.debugLine="End Sub";
return "";
}
public String  _findexistingentry(String _url,String _username) throws Exception{
anywheresoftware.b4a.objects.collections.List _entries = null;
com.lockzero.clspasswordentry _e = null;
String _decrypteduser = "";
 //BA.debugLineNum = 1156;BA.debugLine="Private Sub FindExistingEntry(url As String, usern";
 //BA.debugLineNum = 1157;BA.debugLine="Dim entries As List = ModPasswords.GetEntriesByGr";
_entries = new anywheresoftware.b4a.objects.collections.List();
_entries = _modpasswords._getentriesbygroup /*anywheresoftware.b4a.objects.collections.List*/ (ba,_selectedgroupid);
 //BA.debugLineNum = 1159;BA.debugLine="For Each e As clsPasswordEntry In entries";
{
final anywheresoftware.b4a.BA.IterableList group2 = _entries;
final int groupLen2 = group2.getSize()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_e = (com.lockzero.clspasswordentry)(group2.Get(index2));
 //BA.debugLineNum = 1160;BA.debugLine="If e.Url.ToLowerCase = url.ToLowerCase Then";
if ((_e._url /*String*/ .toLowerCase()).equals(_url.toLowerCase())) { 
 //BA.debugLineNum = 1162;BA.debugLine="Dim decryptedUser As String = ModSession.Decryp";
_decrypteduser = _modsession._decrypt /*String*/ (ba,_e._username /*String*/ );
 //BA.debugLineNum = 1163;BA.debugLine="If decryptedUser.ToLowerCase = username.ToLower";
if ((_decrypteduser.toLowerCase()).equals(_username.toLowerCase())) { 
 //BA.debugLineNum = 1164;BA.debugLine="Return e.Id";
if (true) return _e._id /*String*/ ;
 };
 };
 }
};
 //BA.debugLineNum = 1169;BA.debugLine="Return \"\"";
if (true) return "";
 //BA.debugLineNum = 1170;BA.debugLine="End Sub";
return "";
}
public String  _hidedialog() throws Exception{
anywheresoftware.b4a.objects.IME _ime = null;
 //BA.debugLineNum = 1032;BA.debugLine="Private Sub HideDialog";
 //BA.debugLineNum = 1033;BA.debugLine="pnlOverlay.Visible = False";
_pnloverlay.setVisible(__c.False);
 //BA.debugLineNum = 1034;BA.debugLine="CurrentDialogMode = \"\"";
_currentdialogmode = "";
 //BA.debugLineNum = 1035;BA.debugLine="Dim ime As IME";
_ime = new anywheresoftware.b4a.objects.IME();
 //BA.debugLineNum = 1036;BA.debugLine="ime.Initialize(\"\")";
_ime.Initialize("");
 //BA.debugLineNum = 1037;BA.debugLine="ime.HideKeyboard";
_ime.HideKeyboard(ba);
 //BA.debugLineNum = 1038;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 55;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 56;BA.debugLine="CSVEntries.Initialize";
_csventries.Initialize();
 //BA.debugLineNum = 57;BA.debugLine="FilteredEntries.Initialize";
_filteredentries.Initialize();
 //BA.debugLineNum = 58;BA.debugLine="SelectedIndexes.Initialize";
_selectedindexes.Initialize();
 //BA.debugLineNum = 59;BA.debugLine="SelectedGroupId = \"\"";
_selectedgroupid = "";
 //BA.debugLineNum = 60;BA.debugLine="SelectedGroupName = \"\"";
_selectedgroupname = "";
 //BA.debugLineNum = 61;BA.debugLine="LastParsedFile = \"\"";
_lastparsedfile = "";
 //BA.debugLineNum = 62;BA.debugLine="CurrentFilter = \"\"";
_currentfilter = "";
 //BA.debugLineNum = 63;BA.debugLine="End Sub";
return "";
}
public String  _lblcheck_click() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
int _idx = 0;
 //BA.debugLineNum = 526;BA.debugLine="Private Sub lblCheck_Click";
 //BA.debugLineNum = 527;BA.debugLine="Dim lbl As Label = Sender";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
_lbl = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(__c.Sender(ba)));
 //BA.debugLineNum = 528;BA.debugLine="Dim idx As Int = lbl.Tag";
_idx = (int)(BA.ObjectToNumber(_lbl.getTag()));
 //BA.debugLineNum = 529;BA.debugLine="ToggleSelection(idx)";
_toggleselection(_idx);
 //BA.debugLineNum = 530;BA.debugLine="End Sub";
return "";
}
public String  _lblclearsearch_click() throws Exception{
 //BA.debugLineNum = 585;BA.debugLine="Private Sub lblClearSearch_Click";
 //BA.debugLineNum = 586;BA.debugLine="edtSearch.Text = \"\"";
_edtsearch.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 587;BA.debugLine="CurrentFilter = \"\"";
_currentfilter = "";
 //BA.debugLineNum = 588;BA.debugLine="lblClearSearch.Visible = False";
_lblclearsearch.setVisible(__c.False);
 //BA.debugLineNum = 589;BA.debugLine="ApplyFilter";
_applyfilter();
 //BA.debugLineNum = 590;BA.debugLine="End Sub";
return "";
}
public String  _loadentries() throws Exception{
int _width = 0;
int _itemheight = 0;
int _y = 0;
anywheresoftware.b4a.objects.LabelWrapper _lblempty = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _filteredentry = null;
int _originalindex = 0;
anywheresoftware.b4a.objects.collections.Map _entry = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlitem = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xvitem = null;
boolean _isselected = false;
anywheresoftware.b4a.objects.LabelWrapper _lblcheck = null;
String _name = "";
anywheresoftware.b4a.objects.LabelWrapper _lblname = null;
anywheresoftware.b4a.objects.LabelWrapper _lblurl = null;
anywheresoftware.b4a.objects.LabelWrapper _lbluser = null;
 //BA.debugLineNum = 388;BA.debugLine="Private Sub LoadEntries";
 //BA.debugLineNum = 389;BA.debugLine="pnlEntries.RemoveAllViews";
_pnlentries.RemoveAllViews();
 //BA.debugLineNum = 391;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 392;BA.debugLine="Dim itemHeight As Int = 72dip";
_itemheight = __c.DipToCurrent((int) (72));
 //BA.debugLineNum = 393;BA.debugLine="Dim y As Int = 10dip";
_y = __c.DipToCurrent((int) (10));
 //BA.debugLineNum = 395;BA.debugLine="If FilteredEntries.Size = 0 Then";
if (_filteredentries.getSize()==0) { 
 //BA.debugLineNum = 396;BA.debugLine="Dim lblEmpty As Label";
_lblempty = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 397;BA.debugLine="lblEmpty.Initialize(\"\")";
_lblempty.Initialize(ba,"");
 //BA.debugLineNum = 398;BA.debugLine="If CSVEntries.Size = 0 Then";
if (_csventries.getSize()==0) { 
 //BA.debugLineNum = 399;BA.debugLine="lblEmpty.Text = ModLang.T(\"csv_no_entries\")";
_lblempty.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"csv_no_entries")));
 }else {
 //BA.debugLineNum = 401;BA.debugLine="lblEmpty.Text = ModLang.T(\"search_no_results\")";
_lblempty.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"search_no_results")));
 };
 //BA.debugLineNum = 403;BA.debugLine="lblEmpty.TextSize = Starter.FONT_BODY";
_lblempty.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 404;BA.debugLine="lblEmpty.TextColor = Colors.ARGB(150, 255, 255,";
_lblempty.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 405;BA.debugLine="lblEmpty.Gravity = Gravity.CENTER";
_lblempty.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 406;BA.debugLine="pnlEntries.AddView(lblEmpty, 0, 50dip, width, 40";
_pnlentries.AddView((android.view.View)(_lblempty.getObject()),(int) (0),__c.DipToCurrent((int) (50)),_width,__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 407;BA.debugLine="pnlEntries.Height = 150dip";
_pnlentries.setHeight(__c.DipToCurrent((int) (150)));
 //BA.debugLineNum = 408;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 411;BA.debugLine="For i = 0 To FilteredEntries.Size - 1";
{
final int step20 = 1;
final int limit20 = (int) (_filteredentries.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit20 ;_i = _i + step20 ) {
 //BA.debugLineNum = 412;BA.debugLine="Dim filteredEntry As Map = FilteredEntries.Get(i";
_filteredentry = new anywheresoftware.b4a.objects.collections.Map();
_filteredentry = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_filteredentries.Get(_i)));
 //BA.debugLineNum = 413;BA.debugLine="Dim originalIndex As Int = filteredEntry.Get(\"in";
_originalindex = (int)(BA.ObjectToNumber(_filteredentry.Get((Object)("index"))));
 //BA.debugLineNum = 414;BA.debugLine="Dim entry As Map = filteredEntry.Get(\"data\")";
_entry = new anywheresoftware.b4a.objects.collections.Map();
_entry = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_filteredentry.Get((Object)("data"))));
 //BA.debugLineNum = 416;BA.debugLine="Dim pnlItem As Panel";
_pnlitem = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 417;BA.debugLine="pnlItem.Initialize(\"pnlEntry\")";
_pnlitem.Initialize(ba,"pnlEntry");
 //BA.debugLineNum = 418;BA.debugLine="pnlItem.Tag = originalIndex 'Usa indice original";
_pnlitem.setTag((Object)(_originalindex));
 //BA.debugLineNum = 421;BA.debugLine="Dim xvItem As B4XView = pnlItem";
_xvitem = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvitem = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnlitem.getObject()));
 //BA.debugLineNum = 422;BA.debugLine="xvItem.SetColorAndBorder(ModTheme.HomeIconBg, 0,";
_xvitem.SetColorAndBorder(_modtheme._homeiconbg /*int*/ (ba),(int) (0),_modtheme._homeiconbg /*int*/ (ba),__c.DipToCurrent((int) (8)));
 //BA.debugLineNum = 423;BA.debugLine="pnlEntries.AddView(pnlItem, 12dip, y, width - 24";
_pnlentries.AddView((android.view.View)(_pnlitem.getObject()),__c.DipToCurrent((int) (12)),_y,(int) (_width-__c.DipToCurrent((int) (24))),_itemheight);
 //BA.debugLineNum = 426;BA.debugLine="Dim isSelected As Boolean = SelectedIndexes.Inde";
_isselected = _selectedindexes.IndexOf((Object)(_originalindex))>=0;
 //BA.debugLineNum = 427;BA.debugLine="Dim lblCheck As Label";
_lblcheck = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 428;BA.debugLine="lblCheck.Initialize(\"lblCheck\")";
_lblcheck.Initialize(ba,"lblCheck");
 //BA.debugLineNum = 429;BA.debugLine="lblCheck.Tag = originalIndex";
_lblcheck.setTag((Object)(_originalindex));
 //BA.debugLineNum = 430;BA.debugLine="If isSelected Then";
if (_isselected) { 
 //BA.debugLineNum = 431;BA.debugLine="lblCheck.Text = Chr(9745) 'Checked";
_lblcheck.setText(BA.ObjectToCharSequence(__c.Chr((int) (9745))));
 //BA.debugLineNum = 432;BA.debugLine="lblCheck.TextColor = Colors.RGB(100, 255, 100)";
_lblcheck.setTextColor(__c.Colors.RGB((int) (100),(int) (255),(int) (100)));
 }else {
 //BA.debugLineNum = 434;BA.debugLine="lblCheck.Text = Chr(9744) 'Unchecked";
_lblcheck.setText(BA.ObjectToCharSequence(__c.Chr((int) (9744))));
 //BA.debugLineNum = 435;BA.debugLine="lblCheck.TextColor = Colors.White 'Branco para";
_lblcheck.setTextColor(__c.Colors.White);
 };
 //BA.debugLineNum = 437;BA.debugLine="lblCheck.TextSize = 26";
_lblcheck.setTextSize((float) (26));
 //BA.debugLineNum = 438;BA.debugLine="lblCheck.Gravity = Gravity.CENTER";
_lblcheck.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 439;BA.debugLine="pnlItem.AddView(lblCheck, 5dip, 0, 40dip, itemHe";
_pnlitem.AddView((android.view.View)(_lblcheck.getObject()),__c.DipToCurrent((int) (5)),(int) (0),__c.DipToCurrent((int) (40)),_itemheight);
 //BA.debugLineNum = 442;BA.debugLine="Dim name As String = entry.Get(\"name\")";
_name = BA.ObjectToString(_entry.Get((Object)("name")));
 //BA.debugLineNum = 443;BA.debugLine="If name = \"\" Then name = entry.Get(\"url\")";
if ((_name).equals("")) { 
_name = BA.ObjectToString(_entry.Get((Object)("url")));};
 //BA.debugLineNum = 444;BA.debugLine="Dim lblName As Label";
_lblname = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 445;BA.debugLine="lblName.Initialize(\"\")";
_lblname.Initialize(ba,"");
 //BA.debugLineNum = 446;BA.debugLine="lblName.Text = name";
_lblname.setText(BA.ObjectToCharSequence(_name));
 //BA.debugLineNum = 447;BA.debugLine="lblName.TextSize = Starter.FONT_BODY";
_lblname.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 448;BA.debugLine="lblName.TextColor = Colors.White";
_lblname.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 449;BA.debugLine="lblName.Typeface = Typeface.DEFAULT_BOLD";
_lblname.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 450;BA.debugLine="lblName.Gravity = Gravity.CENTER_VERTICAL";
_lblname.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 451;BA.debugLine="lblName.SingleLine = True";
_lblname.setSingleLine(__c.True);
 //BA.debugLineNum = 452;BA.debugLine="pnlItem.AddView(lblName, 50dip, 5dip, width - 90";
_pnlitem.AddView((android.view.View)(_lblname.getObject()),__c.DipToCurrent((int) (50)),__c.DipToCurrent((int) (5)),(int) (_width-__c.DipToCurrent((int) (90))),__c.DipToCurrent((int) (28)));
 //BA.debugLineNum = 455;BA.debugLine="Dim lblUrl As Label";
_lblurl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 456;BA.debugLine="lblUrl.Initialize(\"\")";
_lblurl.Initialize(ba,"");
 //BA.debugLineNum = 457;BA.debugLine="lblUrl.Text = entry.Get(\"url\")";
_lblurl.setText(BA.ObjectToCharSequence(_entry.Get((Object)("url"))));
 //BA.debugLineNum = 458;BA.debugLine="lblUrl.TextSize = Starter.FONT_CAPTION";
_lblurl.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 459;BA.debugLine="lblUrl.TextColor = Colors.ARGB(150, 255, 255, 25";
_lblurl.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 460;BA.debugLine="lblUrl.SingleLine = True";
_lblurl.setSingleLine(__c.True);
 //BA.debugLineNum = 461;BA.debugLine="pnlItem.AddView(lblUrl, 50dip, 30dip, width - 90";
_pnlitem.AddView((android.view.View)(_lblurl.getObject()),__c.DipToCurrent((int) (50)),__c.DipToCurrent((int) (30)),(int) (_width-__c.DipToCurrent((int) (90))),__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 464;BA.debugLine="Dim lblUser As Label";
_lbluser = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 465;BA.debugLine="lblUser.Initialize(\"\")";
_lbluser.Initialize(ba,"");
 //BA.debugLineNum = 466;BA.debugLine="lblUser.Text = entry.Get(\"username\")";
_lbluser.setText(BA.ObjectToCharSequence(_entry.Get((Object)("username"))));
 //BA.debugLineNum = 467;BA.debugLine="lblUser.TextSize = Starter.FONT_CAPTION";
_lbluser.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 468;BA.debugLine="lblUser.TextColor = Colors.ARGB(180, 255, 255, 2";
_lbluser.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 469;BA.debugLine="lblUser.SingleLine = True";
_lbluser.setSingleLine(__c.True);
 //BA.debugLineNum = 470;BA.debugLine="pnlItem.AddView(lblUser, 50dip, 48dip, width - 9";
_pnlitem.AddView((android.view.View)(_lbluser.getObject()),__c.DipToCurrent((int) (50)),__c.DipToCurrent((int) (48)),(int) (_width-__c.DipToCurrent((int) (90))),__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 472;BA.debugLine="y = y + itemHeight + 8dip";
_y = (int) (_y+_itemheight+__c.DipToCurrent((int) (8)));
 }
};
 //BA.debugLineNum = 475;BA.debugLine="pnlEntries.Height = y + 20dip";
_pnlentries.setHeight((int) (_y+__c.DipToCurrent((int) (20))));
 //BA.debugLineNum = 476;BA.debugLine="End Sub";
return "";
}
public String  _parsecsv() throws Exception{
String _content = "";
String[] _lines = null;
String[] _cols = null;
int _idxname = 0;
int _idxurl = 0;
int _idxusername = 0;
int _idxpassword = 0;
int _idxnote = 0;
int _i = 0;
String _col = "";
String _line = "";
String[] _values = null;
anywheresoftware.b4a.objects.collections.Map _entry = null;
 //BA.debugLineNum = 275;BA.debugLine="Private Sub ParseCSV";
 //BA.debugLineNum = 276;BA.debugLine="CSVEntries.Initialize";
_csventries.Initialize();
 //BA.debugLineNum = 277;BA.debugLine="SelectedIndexes.Initialize";
_selectedindexes.Initialize();
 //BA.debugLineNum = 279;BA.debugLine="If CSVFileName = \"\" Then Return";
if ((_csvfilename).equals("")) { 
if (true) return "";};
 //BA.debugLineNum = 281;BA.debugLine="Try";
try { //BA.debugLineNum = 282;BA.debugLine="Dim content As String = File.ReadString(CSVFolde";
_content = __c.File.ReadString(_csvfolder,_csvfilename);
 //BA.debugLineNum = 283;BA.debugLine="Dim lines() As String = Regex.Split(CRLF, conten";
_lines = __c.Regex.Split(__c.CRLF,_content);
 //BA.debugLineNum = 286;BA.debugLine="If lines.Length <= 1 Then";
if (_lines.length<=1) { 
 //BA.debugLineNum = 287;BA.debugLine="lines = Regex.Split(Chr(10), content)";
_lines = __c.Regex.Split(BA.ObjectToString(__c.Chr((int) (10))),_content);
 };
 //BA.debugLineNum = 291;BA.debugLine="If lines.Length < 2 Then Return";
if (_lines.length<2) { 
if (true) return "";};
 //BA.debugLineNum = 294;BA.debugLine="Dim cols() As String = ParseCSVLine(lines(0))";
_cols = _parsecsvline(_lines[(int) (0)]);
 //BA.debugLineNum = 295;BA.debugLine="Dim idxName As Int = -1";
_idxname = (int) (-1);
 //BA.debugLineNum = 296;BA.debugLine="Dim idxUrl As Int = -1";
_idxurl = (int) (-1);
 //BA.debugLineNum = 297;BA.debugLine="Dim idxUsername As Int = -1";
_idxusername = (int) (-1);
 //BA.debugLineNum = 298;BA.debugLine="Dim idxPassword As Int = -1";
_idxpassword = (int) (-1);
 //BA.debugLineNum = 299;BA.debugLine="Dim idxNote As Int = -1";
_idxnote = (int) (-1);
 //BA.debugLineNum = 301;BA.debugLine="For i = 0 To cols.Length - 1";
{
final int step17 = 1;
final int limit17 = (int) (_cols.length-1);
_i = (int) (0) ;
for (;_i <= limit17 ;_i = _i + step17 ) {
 //BA.debugLineNum = 302;BA.debugLine="Dim col As String = cols(i).ToLowerCase.Trim";
_col = _cols[_i].toLowerCase().trim();
 //BA.debugLineNum = 303;BA.debugLine="If col = \"name\" Then idxName = i";
if ((_col).equals("name")) { 
_idxname = _i;};
 //BA.debugLineNum = 304;BA.debugLine="If col = \"url\" Then idxUrl = i";
if ((_col).equals("url")) { 
_idxurl = _i;};
 //BA.debugLineNum = 305;BA.debugLine="If col = \"username\" Then idxUsername = i";
if ((_col).equals("username")) { 
_idxusername = _i;};
 //BA.debugLineNum = 306;BA.debugLine="If col = \"password\" Then idxPassword = i";
if ((_col).equals("password")) { 
_idxpassword = _i;};
 //BA.debugLineNum = 307;BA.debugLine="If col = \"note\" Or col = \"notes\" Then idxNote =";
if ((_col).equals("note") || (_col).equals("notes")) { 
_idxnote = _i;};
 }
};
 //BA.debugLineNum = 310;BA.debugLine="Log(\"CSV Columns: name=\" & idxName & \" url=\" & i";
__c.LogImpl("631457315","CSV Columns: name="+BA.NumberToString(_idxname)+" url="+BA.NumberToString(_idxurl)+" user="+BA.NumberToString(_idxusername)+" pass="+BA.NumberToString(_idxpassword)+" note="+BA.NumberToString(_idxnote),0);
 //BA.debugLineNum = 313;BA.debugLine="For i = 1 To lines.Length - 1";
{
final int step26 = 1;
final int limit26 = (int) (_lines.length-1);
_i = (int) (1) ;
for (;_i <= limit26 ;_i = _i + step26 ) {
 //BA.debugLineNum = 314;BA.debugLine="Dim line As String = lines(i).Trim";
_line = _lines[_i].trim();
 //BA.debugLineNum = 315;BA.debugLine="If line = \"\" Then Continue";
if ((_line).equals("")) { 
if (true) continue;};
 //BA.debugLineNum = 317;BA.debugLine="Dim values() As String = ParseCSVLine(line)";
_values = _parsecsvline(_line);
 //BA.debugLineNum = 319;BA.debugLine="Dim entry As Map";
_entry = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 320;BA.debugLine="entry.Initialize";
_entry.Initialize();
 //BA.debugLineNum = 322;BA.debugLine="If idxName >= 0 And idxName < values.Length The";
if (_idxname>=0 && _idxname<_values.length) { 
_entry.Put((Object)("name"),(Object)(_values[_idxname].trim()));};
 //BA.debugLineNum = 323;BA.debugLine="If idxUrl >= 0 And idxUrl < values.Length Then";
if (_idxurl>=0 && _idxurl<_values.length) { 
_entry.Put((Object)("url"),(Object)(_values[_idxurl].trim()));};
 //BA.debugLineNum = 324;BA.debugLine="If idxUsername >= 0 And idxUsername < values.Le";
if (_idxusername>=0 && _idxusername<_values.length) { 
_entry.Put((Object)("username"),(Object)(_values[_idxusername].trim()));};
 //BA.debugLineNum = 325;BA.debugLine="If idxPassword >= 0 And idxPassword < values.Le";
if (_idxpassword>=0 && _idxpassword<_values.length) { 
_entry.Put((Object)("password"),(Object)(_values[_idxpassword].trim()));};
 //BA.debugLineNum = 326;BA.debugLine="If idxNote >= 0 And idxNote < values.Length The";
if (_idxnote>=0 && _idxnote<_values.length) { 
_entry.Put((Object)("note"),(Object)(_values[_idxnote].trim()));};
 //BA.debugLineNum = 329;BA.debugLine="If entry.ContainsKey(\"name\") = False Then entry";
if (_entry.ContainsKey((Object)("name"))==__c.False) { 
_entry.Put((Object)("name"),(Object)(""));};
 //BA.debugLineNum = 330;BA.debugLine="If entry.ContainsKey(\"url\") = False Then entry.";
if (_entry.ContainsKey((Object)("url"))==__c.False) { 
_entry.Put((Object)("url"),(Object)(""));};
 //BA.debugLineNum = 331;BA.debugLine="If entry.ContainsKey(\"username\") = False Then e";
if (_entry.ContainsKey((Object)("username"))==__c.False) { 
_entry.Put((Object)("username"),(Object)(""));};
 //BA.debugLineNum = 332;BA.debugLine="If entry.ContainsKey(\"password\") = False Then e";
if (_entry.ContainsKey((Object)("password"))==__c.False) { 
_entry.Put((Object)("password"),(Object)(""));};
 //BA.debugLineNum = 333;BA.debugLine="If entry.ContainsKey(\"note\") = False Then entry";
if (_entry.ContainsKey((Object)("note"))==__c.False) { 
_entry.Put((Object)("note"),(Object)(""));};
 //BA.debugLineNum = 336;BA.debugLine="If entry.Get(\"username\") = \"\" Or entry.Get(\"pas";
if ((_entry.Get((Object)("username"))).equals((Object)("")) || (_entry.Get((Object)("password"))).equals((Object)(""))) { 
 //BA.debugLineNum = 337;BA.debugLine="Log(\"CSV: Ignorando linha \" & i & \" (username";
__c.LogImpl("631457342","CSV: Ignorando linha "+BA.NumberToString(_i)+" (username ou password vazio)",0);
 //BA.debugLineNum = 338;BA.debugLine="Continue";
if (true) continue;
 };
 //BA.debugLineNum = 341;BA.debugLine="CSVEntries.Add(entry)";
_csventries.Add((Object)(_entry.getObject()));
 }
};
 //BA.debugLineNum = 345;BA.debugLine="Log(\"CSV: \" & CSVEntries.Size & \" entradas valid";
__c.LogImpl("631457350","CSV: "+BA.NumberToString(_csventries.getSize())+" entradas validas",0);
 } 
       catch (Exception e50) {
			ba.setLastException(e50); //BA.debugLineNum = 348;BA.debugLine="Log(\"ParseCSV erro: \" & LastException)";
__c.LogImpl("631457353","ParseCSV erro: "+BA.ObjectToString(__c.LastException(ba)),0);
 //BA.debugLineNum = 349;BA.debugLine="ToastMessageShow(ModLang.T(\"csv_error_parse\"), T";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"csv_error_parse")),__c.True);
 };
 //BA.debugLineNum = 351;BA.debugLine="End Sub";
return "";
}
public String[]  _parsecsvline(String _line) throws Exception{
anywheresoftware.b4a.objects.collections.List _result = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _current = null;
boolean _inquotes = false;
int _i = 0;
char _c = '\0';
String[] _arr = null;
 //BA.debugLineNum = 354;BA.debugLine="Private Sub ParseCSVLine(line As String) As String";
 //BA.debugLineNum = 355;BA.debugLine="Dim result As List";
_result = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 356;BA.debugLine="result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 358;BA.debugLine="Dim current As StringBuilder";
_current = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 359;BA.debugLine="current.Initialize";
_current.Initialize();
 //BA.debugLineNum = 360;BA.debugLine="Dim inQuotes As Boolean = False";
_inquotes = __c.False;
 //BA.debugLineNum = 362;BA.debugLine="For i = 0 To line.Length - 1";
{
final int step6 = 1;
final int limit6 = (int) (_line.length()-1);
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
 //BA.debugLineNum = 363;BA.debugLine="Dim c As Char = line.CharAt(i)";
_c = _line.charAt(_i);
 //BA.debugLineNum = 365;BA.debugLine="If c = Chr(34) Then 'Aspas duplas";
if (_c==__c.Chr((int) (34))) { 
 //BA.debugLineNum = 366;BA.debugLine="inQuotes = Not(inQuotes)";
_inquotes = __c.Not(_inquotes);
 }else if(_c==BA.ObjectToChar(",") && _inquotes==__c.False) { 
 //BA.debugLineNum = 368;BA.debugLine="result.Add(current.ToString)";
_result.Add((Object)(_current.ToString()));
 //BA.debugLineNum = 369;BA.debugLine="current.Initialize";
_current.Initialize();
 }else {
 //BA.debugLineNum = 371;BA.debugLine="current.Append(c)";
_current.Append(BA.ObjectToString(_c));
 };
 }
};
 //BA.debugLineNum = 375;BA.debugLine="result.Add(current.ToString)";
_result.Add((Object)(_current.ToString()));
 //BA.debugLineNum = 377;BA.debugLine="Dim arr(result.Size) As String";
_arr = new String[_result.getSize()];
java.util.Arrays.fill(_arr,"");
 //BA.debugLineNum = 378;BA.debugLine="For i = 0 To result.Size - 1";
{
final int step19 = 1;
final int limit19 = (int) (_result.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit19 ;_i = _i + step19 ) {
 //BA.debugLineNum = 379;BA.debugLine="arr(i) = result.Get(i)";
_arr[_i] = BA.ObjectToString(_result.Get(_i));
 }
};
 //BA.debugLineNum = 381;BA.debugLine="Return arr";
if (true) return _arr;
 //BA.debugLineNum = 382;BA.debugLine="End Sub";
return null;
}
public String  _pnlentry_click() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
int _idx = 0;
 //BA.debugLineNum = 520;BA.debugLine="Private Sub pnlEntry_Click";
 //BA.debugLineNum = 521;BA.debugLine="Dim pnl As Panel = Sender";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
_pnl = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(__c.Sender(ba)));
 //BA.debugLineNum = 522;BA.debugLine="Dim idx As Int = pnl.Tag";
_idx = (int)(BA.ObjectToNumber(_pnl.getTag()));
 //BA.debugLineNum = 523;BA.debugLine="ToggleSelection(idx)";
_toggleselection(_idx);
 //BA.debugLineNum = 524;BA.debugLine="End Sub";
return "";
}
public String  _pnloverlay_click() throws Exception{
 //BA.debugLineNum = 653;BA.debugLine="Private Sub pnlOverlay_Click";
 //BA.debugLineNum = 654;BA.debugLine="HideDialog";
_hidedialog();
 //BA.debugLineNum = 655;BA.debugLine="End Sub";
return "";
}
public String  _setcsvfile(String _folder,String _filename) throws Exception{
 //BA.debugLineNum = 66;BA.debugLine="Public Sub SetCSVFile(folder As String, fileName A";
 //BA.debugLineNum = 67;BA.debugLine="CSVFolder = folder";
_csvfolder = _folder;
 //BA.debugLineNum = 68;BA.debugLine="CSVFileName = fileName";
_csvfilename = _filename;
 //BA.debugLineNum = 69;BA.debugLine="End Sub";
return "";
}
public String  _shownewgroupdialog() throws Exception{
int _dialogw = 0;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
anywheresoftware.b4a.objects.LabelWrapper _lblname = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlname = null;
anywheresoftware.b4a.objects.LabelWrapper _lblphrase = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlpass = null;
anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
anywheresoftware.b4a.objects.ButtonWrapper _btncreate = null;
 //BA.debugLineNum = 765;BA.debugLine="Private Sub ShowNewGroupDialog";
 //BA.debugLineNum = 766;BA.debugLine="CurrentDialogMode = \"new_group\"";
_currentdialogmode = "new_group";
 //BA.debugLineNum = 767;BA.debugLine="IsPassVisible = False";
_ispassvisible = __c.False;
 //BA.debugLineNum = 769;BA.debugLine="Dim dialogW As Int = Root.Width - 40dip";
_dialogw = (int) (_root.getWidth()-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 770;BA.debugLine="pnlDialog.RemoveAllViews";
_pnldialog.RemoveAllViews();
 //BA.debugLineNum = 773;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 774;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 775;BA.debugLine="lblTitle.Text = ModLang.T(\"csv_new_group\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"csv_new_group")));
 //BA.debugLineNum = 776;BA.debugLine="lblTitle.TextSize = 16";
_lbltitle.setTextSize((float) (16));
 //BA.debugLineNum = 777;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 778;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 779;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 780;BA.debugLine="pnlDialog.AddView(lblTitle, 0, 12dip, dialogW, 30";
_pnldialog.AddView((android.view.View)(_lbltitle.getObject()),(int) (0),__c.DipToCurrent((int) (12)),_dialogw,__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 783;BA.debugLine="Dim lblName As Label";
_lblname = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 784;BA.debugLine="lblName.Initialize(\"\")";
_lblname.Initialize(ba,"");
 //BA.debugLineNum = 785;BA.debugLine="lblName.Text = ModLang.T(\"group_name_hint\")";
_lblname.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"group_name_hint")));
 //BA.debugLineNum = 786;BA.debugLine="lblName.TextSize = Starter.FONT_CAPTION";
_lblname.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 787;BA.debugLine="lblName.TextColor = Colors.ARGB(180, 255, 255, 25";
_lblname.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 788;BA.debugLine="pnlDialog.AddView(lblName, 16dip, 45dip, dialogW";
_pnldialog.AddView((android.view.View)(_lblname.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (45)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 791;BA.debugLine="edtGroupName.Initialize(\"edtGroupName\")";
_edtgroupname.Initialize(ba,"edtGroupName");
 //BA.debugLineNum = 792;BA.debugLine="edtGroupName.Hint = ModLang.T(\"group_name_hint\")";
_edtgroupname.setHint(_modlang._t /*String*/ (ba,"group_name_hint"));
 //BA.debugLineNum = 793;BA.debugLine="edtGroupName.SingleLine = True";
_edtgroupname.setSingleLine(__c.True);
 //BA.debugLineNum = 794;BA.debugLine="edtGroupName.InputType = Bit.Or(1, 8192)";
_edtgroupname.setInputType(__c.Bit.Or((int) (1),(int) (8192)));
 //BA.debugLineNum = 795;BA.debugLine="edtGroupName.Text = \"Chrome Import\"";
_edtgroupname.setText(BA.ObjectToCharSequence("Chrome Import"));
 //BA.debugLineNum = 796;BA.debugLine="edtGroupName.TextColor = Colors.White";
_edtgroupname.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 797;BA.debugLine="edtGroupName.HintColor = Colors.ARGB(120, 255, 25";
_edtgroupname.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 799;BA.debugLine="Dim pnlName As Panel";
_pnlname = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 800;BA.debugLine="pnlName.Initialize(\"\")";
_pnlname.Initialize(ba,"");
 //BA.debugLineNum = 801;BA.debugLine="pnlName.Color = ModTheme.HomeBg";
_pnlname.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 802;BA.debugLine="pnlDialog.AddView(pnlName, 16dip, 65dip, dialogW";
_pnldialog.AddView((android.view.View)(_pnlname.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (65)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (46)));
 //BA.debugLineNum = 803;BA.debugLine="pnlName.AddView(edtGroupName, 8dip, 0, dialogW -";
_pnlname.AddView((android.view.View)(_edtgroupname.getObject()),__c.DipToCurrent((int) (8)),(int) (0),(int) (_dialogw-__c.DipToCurrent((int) (48))),__c.DipToCurrent((int) (46)));
 //BA.debugLineNum = 806;BA.debugLine="Dim lblPhrase As Label";
_lblphrase = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 807;BA.debugLine="lblPhrase.Initialize(\"\")";
_lblphrase.Initialize(ba,"");
 //BA.debugLineNum = 808;BA.debugLine="lblPhrase.Text = ModLang.T(\"passphrase_hint\")";
_lblphrase.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"passphrase_hint")));
 //BA.debugLineNum = 809;BA.debugLine="lblPhrase.TextSize = Starter.FONT_CAPTION";
_lblphrase.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 810;BA.debugLine="lblPhrase.TextColor = Colors.ARGB(180, 255, 255,";
_lblphrase.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 811;BA.debugLine="pnlDialog.AddView(lblPhrase, 16dip, 120dip, dialo";
_pnldialog.AddView((android.view.View)(_lblphrase.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (120)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 814;BA.debugLine="edtPassphrase.Initialize(\"edtPassphrase\")";
_edtpassphrase.Initialize(ba,"edtPassphrase");
 //BA.debugLineNum = 815;BA.debugLine="edtPassphrase.Hint = ModLang.T(\"passphrase_hint\")";
_edtpassphrase.setHint(_modlang._t /*String*/ (ba,"passphrase_hint"));
 //BA.debugLineNum = 816;BA.debugLine="edtPassphrase.SingleLine = True";
_edtpassphrase.setSingleLine(__c.True);
 //BA.debugLineNum = 817;BA.debugLine="edtPassphrase.InputType = ModSecurity.GetSecurePa";
_edtpassphrase.setInputType(_modsecurity._getsecurepassphraseinputtype /*int*/ (ba));
 //BA.debugLineNum = 818;BA.debugLine="edtPassphrase.Text = \"\"";
_edtpassphrase.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 819;BA.debugLine="edtPassphrase.TextColor = Colors.White";
_edtpassphrase.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 820;BA.debugLine="edtPassphrase.HintColor = Colors.ARGB(120, 255, 2";
_edtpassphrase.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 822;BA.debugLine="Dim pnlPass As Panel";
_pnlpass = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 823;BA.debugLine="pnlPass.Initialize(\"\")";
_pnlpass.Initialize(ba,"");
 //BA.debugLineNum = 824;BA.debugLine="pnlPass.Color = ModTheme.HomeBg";
_pnlpass.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 825;BA.debugLine="pnlDialog.AddView(pnlPass, 16dip, 140dip, dialogW";
_pnldialog.AddView((android.view.View)(_pnlpass.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (140)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (46)));
 //BA.debugLineNum = 826;BA.debugLine="pnlPass.AddView(edtPassphrase, 8dip, 0, dialogW -";
_pnlpass.AddView((android.view.View)(_edtpassphrase.getObject()),__c.DipToCurrent((int) (8)),(int) (0),(int) (_dialogw-__c.DipToCurrent((int) (110))),__c.DipToCurrent((int) (46)));
 //BA.debugLineNum = 829;BA.debugLine="btnShowPass.Initialize(\"btnShowPass\")";
_btnshowpass.Initialize(ba,"btnShowPass");
 //BA.debugLineNum = 830;BA.debugLine="btnShowPass.Text = ModLang.T(\"view\")";
_btnshowpass.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"view")));
 //BA.debugLineNum = 831;BA.debugLine="btnShowPass.TextSize = Starter.FONT_CAPTION";
_btnshowpass.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 832;BA.debugLine="btnShowPass.Color = ModTheme.HomeIconBg";
_btnshowpass.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 833;BA.debugLine="btnShowPass.TextColor = Colors.White";
_btnshowpass.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 834;BA.debugLine="pnlPass.AddView(btnShowPass, dialogW - 95dip, 3di";
_pnlpass.AddView((android.view.View)(_btnshowpass.getObject()),(int) (_dialogw-__c.DipToCurrent((int) (95))),__c.DipToCurrent((int) (3)),__c.DipToCurrent((int) (55)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 837;BA.debugLine="Dim btnCancel As Button";
_btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 838;BA.debugLine="btnCancel.Initialize(\"btnDialogCancel\")";
_btncancel.Initialize(ba,"btnDialogCancel");
 //BA.debugLineNum = 839;BA.debugLine="btnCancel.Text = ModLang.T(\"cancel\")";
_btncancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 840;BA.debugLine="btnCancel.TextSize = Starter.FONT_BUTTON";
_btncancel.setTextSize(_starter._font_button /*float*/ );
 //BA.debugLineNum = 841;BA.debugLine="btnCancel.Color = Colors.Gray";
_btncancel.setColor(__c.Colors.Gray);
 //BA.debugLineNum = 842;BA.debugLine="btnCancel.TextColor = Colors.White";
_btncancel.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 843;BA.debugLine="pnlDialog.AddView(btnCancel, 16dip, 200dip, 100di";
_pnldialog.AddView((android.view.View)(_btncancel.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (200)),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 845;BA.debugLine="Dim btnCreate As Button";
_btncreate = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 846;BA.debugLine="btnCreate.Initialize(\"btnCreateGroup\")";
_btncreate.Initialize(ba,"btnCreateGroup");
 //BA.debugLineNum = 847;BA.debugLine="btnCreate.Text = ModLang.T(\"save\")";
_btncreate.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"save")));
 //BA.debugLineNum = 848;BA.debugLine="btnCreate.TextSize = Starter.FONT_BUTTON";
_btncreate.setTextSize(_starter._font_button /*float*/ );
 //BA.debugLineNum = 849;BA.debugLine="btnCreate.Color = ModTheme.HomeIconBg";
_btncreate.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 850;BA.debugLine="btnCreate.TextColor = Colors.White";
_btncreate.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 851;BA.debugLine="pnlDialog.AddView(btnCreate, dialogW - 116dip, 20";
_pnldialog.AddView((android.view.View)(_btncreate.getObject()),(int) (_dialogw-__c.DipToCurrent((int) (116))),__c.DipToCurrent((int) (200)),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 854;BA.debugLine="pnlDialog.SetLayoutAnimated(0, 20dip, 80dip, dial";
_pnldialog.SetLayoutAnimated((int) (0),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (80)),_dialogw,__c.DipToCurrent((int) (260)));
 //BA.debugLineNum = 856;BA.debugLine="edtGroupName.RequestFocus";
_edtgroupname.RequestFocus();
 //BA.debugLineNum = 857;BA.debugLine="End Sub";
return "";
}
public String  _showpassphrasedialog() throws Exception{
int _dialogw = 0;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
anywheresoftware.b4a.objects.LabelWrapper _lblsub = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlpass = null;
anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
anywheresoftware.b4a.objects.ButtonWrapper _btnok = null;
 //BA.debugLineNum = 903;BA.debugLine="Private Sub ShowPassphraseDialog";
 //BA.debugLineNum = 904;BA.debugLine="CurrentDialogMode = \"passphrase\"";
_currentdialogmode = "passphrase";
 //BA.debugLineNum = 905;BA.debugLine="IsPassVisible = False";
_ispassvisible = __c.False;
 //BA.debugLineNum = 907;BA.debugLine="Dim dialogW As Int = Root.Width - 40dip";
_dialogw = (int) (_root.getWidth()-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 908;BA.debugLine="pnlDialog.RemoveAllViews";
_pnldialog.RemoveAllViews();
 //BA.debugLineNum = 911;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 912;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 913;BA.debugLine="lblTitle.Text = SelectedGroupName";
_lbltitle.setText(BA.ObjectToCharSequence(_selectedgroupname));
 //BA.debugLineNum = 914;BA.debugLine="lblTitle.TextSize = 16";
_lbltitle.setTextSize((float) (16));
 //BA.debugLineNum = 915;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 916;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 917;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 918;BA.debugLine="pnlDialog.AddView(lblTitle, 0, 12dip, dialogW, 30";
_pnldialog.AddView((android.view.View)(_lbltitle.getObject()),(int) (0),__c.DipToCurrent((int) (12)),_dialogw,__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 921;BA.debugLine="Dim lblSub As Label";
_lblsub = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 922;BA.debugLine="lblSub.Initialize(\"\")";
_lblsub.Initialize(ba,"");
 //BA.debugLineNum = 923;BA.debugLine="lblSub.Text = ModLang.T(\"enter_passphrase\")";
_lblsub.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"enter_passphrase")));
 //BA.debugLineNum = 924;BA.debugLine="lblSub.TextSize = Starter.FONT_CAPTION";
_lblsub.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 925;BA.debugLine="lblSub.TextColor = Colors.ARGB(180, 255, 255, 255";
_lblsub.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 926;BA.debugLine="lblSub.Gravity = Gravity.CENTER_HORIZONTAL";
_lblsub.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 927;BA.debugLine="pnlDialog.AddView(lblSub, 0, 40dip, dialogW, 20di";
_pnldialog.AddView((android.view.View)(_lblsub.getObject()),(int) (0),__c.DipToCurrent((int) (40)),_dialogw,__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 930;BA.debugLine="edtPassphrase.Initialize(\"edtPassphrase\")";
_edtpassphrase.Initialize(ba,"edtPassphrase");
 //BA.debugLineNum = 931;BA.debugLine="edtPassphrase.Hint = ModLang.T(\"passphrase_hint\")";
_edtpassphrase.setHint(_modlang._t /*String*/ (ba,"passphrase_hint"));
 //BA.debugLineNum = 932;BA.debugLine="edtPassphrase.SingleLine = True";
_edtpassphrase.setSingleLine(__c.True);
 //BA.debugLineNum = 933;BA.debugLine="edtPassphrase.InputType = ModSecurity.GetSecurePa";
_edtpassphrase.setInputType(_modsecurity._getsecurepassphraseinputtype /*int*/ (ba));
 //BA.debugLineNum = 934;BA.debugLine="edtPassphrase.Text = \"\"";
_edtpassphrase.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 935;BA.debugLine="edtPassphrase.TextColor = Colors.White";
_edtpassphrase.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 936;BA.debugLine="edtPassphrase.HintColor = Colors.ARGB(120, 255, 2";
_edtpassphrase.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 938;BA.debugLine="Dim pnlPass As Panel";
_pnlpass = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 939;BA.debugLine="pnlPass.Initialize(\"\")";
_pnlpass.Initialize(ba,"");
 //BA.debugLineNum = 940;BA.debugLine="pnlPass.Color = ModTheme.HomeBg";
_pnlpass.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 941;BA.debugLine="pnlDialog.AddView(pnlPass, 16dip, 70dip, dialogW";
_pnldialog.AddView((android.view.View)(_pnlpass.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (70)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 942;BA.debugLine="pnlPass.AddView(edtPassphrase, 8dip, 0, dialogW -";
_pnlpass.AddView((android.view.View)(_edtpassphrase.getObject()),__c.DipToCurrent((int) (8)),(int) (0),(int) (_dialogw-__c.DipToCurrent((int) (110))),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 945;BA.debugLine="btnShowPass.Initialize(\"btnShowPass\")";
_btnshowpass.Initialize(ba,"btnShowPass");
 //BA.debugLineNum = 946;BA.debugLine="btnShowPass.Text = ModLang.T(\"view\")";
_btnshowpass.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"view")));
 //BA.debugLineNum = 947;BA.debugLine="btnShowPass.TextSize = Starter.FONT_CAPTION";
_btnshowpass.setTextSize(_starter._font_caption /*float*/ );
 //BA.debugLineNum = 948;BA.debugLine="btnShowPass.Color = ModTheme.HomeIconBg";
_btnshowpass.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 949;BA.debugLine="btnShowPass.TextColor = Colors.White";
_btnshowpass.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 950;BA.debugLine="pnlPass.AddView(btnShowPass, dialogW - 95dip, 5di";
_pnlpass.AddView((android.view.View)(_btnshowpass.getObject()),(int) (_dialogw-__c.DipToCurrent((int) (95))),__c.DipToCurrent((int) (5)),__c.DipToCurrent((int) (55)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 953;BA.debugLine="Dim btnCancel As Button";
_btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 954;BA.debugLine="btnCancel.Initialize(\"btnDialogCancel\")";
_btncancel.Initialize(ba,"btnDialogCancel");
 //BA.debugLineNum = 955;BA.debugLine="btnCancel.Text = ModLang.T(\"cancel\")";
_btncancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 956;BA.debugLine="btnCancel.TextSize = Starter.FONT_BUTTON";
_btncancel.setTextSize(_starter._font_button /*float*/ );
 //BA.debugLineNum = 957;BA.debugLine="btnCancel.Color = Colors.Gray";
_btncancel.setColor(__c.Colors.Gray);
 //BA.debugLineNum = 958;BA.debugLine="btnCancel.TextColor = Colors.White";
_btncancel.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 959;BA.debugLine="pnlDialog.AddView(btnCancel, 16dip, 140dip, 100di";
_pnldialog.AddView((android.view.View)(_btncancel.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (140)),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 961;BA.debugLine="Dim btnOk As Button";
_btnok = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 962;BA.debugLine="btnOk.Initialize(\"btnUnlockGroup\")";
_btnok.Initialize(ba,"btnUnlockGroup");
 //BA.debugLineNum = 963;BA.debugLine="btnOk.Text = ModLang.T(\"unlock\")";
_btnok.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"unlock")));
 //BA.debugLineNum = 964;BA.debugLine="btnOk.TextSize = Starter.FONT_BUTTON";
_btnok.setTextSize(_starter._font_button /*float*/ );
 //BA.debugLineNum = 965;BA.debugLine="btnOk.Color = ModTheme.HomeIconBg";
_btnok.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 966;BA.debugLine="btnOk.TextColor = Colors.White";
_btnok.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 967;BA.debugLine="pnlDialog.AddView(btnOk, dialogW - 116dip, 140dip";
_pnldialog.AddView((android.view.View)(_btnok.getObject()),(int) (_dialogw-__c.DipToCurrent((int) (116))),__c.DipToCurrent((int) (140)),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 970;BA.debugLine="pnlDialog.SetLayoutAnimated(0, 20dip, 100dip, dia";
_pnldialog.SetLayoutAnimated((int) (0),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (100)),_dialogw,__c.DipToCurrent((int) (200)));
 //BA.debugLineNum = 972;BA.debugLine="pnlOverlay.Visible = True";
_pnloverlay.setVisible(__c.True);
 //BA.debugLineNum = 973;BA.debugLine="pnlOverlay.BringToFront";
_pnloverlay.BringToFront();
 //BA.debugLineNum = 974;BA.debugLine="edtPassphrase.RequestFocus";
_edtpassphrase.RequestFocus();
 //BA.debugLineNum = 975;BA.debugLine="End Sub";
return "";
}
public String  _showselectgroupdialog() throws Exception{
int _dialogw = 0;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
anywheresoftware.b4a.objects.collections.List _groups = null;
int _y = 0;
int _i = 0;
com.lockzero.clspasswordgroup _g = null;
anywheresoftware.b4a.objects.ButtonWrapper _btngroup = null;
anywheresoftware.b4a.objects.LabelWrapper _lblnogroups = null;
anywheresoftware.b4a.objects.ButtonWrapper _btnnew = null;
anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
int _dialogh = 0;
 //BA.debugLineNum = 661;BA.debugLine="Private Sub ShowSelectGroupDialog";
 //BA.debugLineNum = 662;BA.debugLine="CurrentDialogMode = \"select_group\"";
_currentdialogmode = "select_group";
 //BA.debugLineNum = 664;BA.debugLine="Dim dialogW As Int = Root.Width - 40dip";
_dialogw = (int) (_root.getWidth()-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 665;BA.debugLine="pnlDialog.RemoveAllViews";
_pnldialog.RemoveAllViews();
 //BA.debugLineNum = 668;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 669;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 670;BA.debugLine="lblTitle.Text = ModLang.T(\"csv_select_group\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"csv_select_group")));
 //BA.debugLineNum = 671;BA.debugLine="lblTitle.TextSize = 16";
_lbltitle.setTextSize((float) (16));
 //BA.debugLineNum = 672;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 673;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 674;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 675;BA.debugLine="pnlDialog.AddView(lblTitle, 0, 12dip, dialogW, 30";
_pnldialog.AddView((android.view.View)(_lbltitle.getObject()),(int) (0),__c.DipToCurrent((int) (12)),_dialogw,__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 678;BA.debugLine="Dim groups As List = ModPasswords.GetAllGroups";
_groups = new anywheresoftware.b4a.objects.collections.List();
_groups = _modpasswords._getallgroups /*anywheresoftware.b4a.objects.collections.List*/ (ba);
 //BA.debugLineNum = 679;BA.debugLine="Dim y As Int = 50dip";
_y = __c.DipToCurrent((int) (50));
 //BA.debugLineNum = 681;BA.debugLine="If groups.Size > 0 Then";
if (_groups.getSize()>0) { 
 //BA.debugLineNum = 682;BA.debugLine="For i = 0 To groups.Size - 1";
{
final int step15 = 1;
final int limit15 = (int) (_groups.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit15 ;_i = _i + step15 ) {
 //BA.debugLineNum = 683;BA.debugLine="Dim g As clsPasswordGroup = groups.Get(i)";
_g = (com.lockzero.clspasswordgroup)(_groups.Get(_i));
 //BA.debugLineNum = 685;BA.debugLine="Dim btnGroup As Button";
_btngroup = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 686;BA.debugLine="btnGroup.Initialize(\"btnGroupItem\")";
_btngroup.Initialize(ba,"btnGroupItem");
 //BA.debugLineNum = 687;BA.debugLine="btnGroup.Text = g.Name";
_btngroup.setText(BA.ObjectToCharSequence(_g._name /*String*/ ));
 //BA.debugLineNum = 688;BA.debugLine="btnGroup.Tag = g.Id & \"|\" & g.Name";
_btngroup.setTag((Object)(_g._id /*String*/ +"|"+_g._name /*String*/ ));
 //BA.debugLineNum = 689;BA.debugLine="btnGroup.TextSize = Starter.FONT_BODY";
_btngroup.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 690;BA.debugLine="btnGroup.Color = ModTheme.HomeBg";
_btngroup.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 691;BA.debugLine="btnGroup.TextColor = Colors.White";
_btngroup.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 692;BA.debugLine="pnlDialog.AddView(btnGroup, 16dip, y, dialogW -";
_pnldialog.AddView((android.view.View)(_btngroup.getObject()),__c.DipToCurrent((int) (16)),_y,(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 694;BA.debugLine="y = y + 50dip";
_y = (int) (_y+__c.DipToCurrent((int) (50)));
 }
};
 }else {
 //BA.debugLineNum = 697;BA.debugLine="Dim lblNoGroups As Label";
_lblnogroups = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 698;BA.debugLine="lblNoGroups.Initialize(\"\")";
_lblnogroups.Initialize(ba,"");
 //BA.debugLineNum = 699;BA.debugLine="lblNoGroups.Text = ModLang.T(\"csv_no_groups\")";
_lblnogroups.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"csv_no_groups")));
 //BA.debugLineNum = 700;BA.debugLine="lblNoGroups.TextSize = Starter.FONT_BODY";
_lblnogroups.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 701;BA.debugLine="lblNoGroups.TextColor = Colors.ARGB(150, 255, 25";
_lblnogroups.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 702;BA.debugLine="lblNoGroups.Gravity = Gravity.CENTER";
_lblnogroups.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 703;BA.debugLine="pnlDialog.AddView(lblNoGroups, 0, y, dialogW, 40";
_pnldialog.AddView((android.view.View)(_lblnogroups.getObject()),(int) (0),_y,_dialogw,__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 704;BA.debugLine="y = y + 50dip";
_y = (int) (_y+__c.DipToCurrent((int) (50)));
 };
 //BA.debugLineNum = 708;BA.debugLine="Dim btnNew As Button";
_btnnew = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 709;BA.debugLine="btnNew.Initialize(\"btnNewGroup\")";
_btnnew.Initialize(ba,"btnNewGroup");
 //BA.debugLineNum = 710;BA.debugLine="btnNew.Text = \"+ \" & ModLang.T(\"csv_new_group\")";
_btnnew.setText(BA.ObjectToCharSequence("+ "+_modlang._t /*String*/ (ba,"csv_new_group")));
 //BA.debugLineNum = 711;BA.debugLine="btnNew.TextSize = Starter.FONT_BODY";
_btnnew.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 712;BA.debugLine="btnNew.Color = ModTheme.HomeIconBg";
_btnnew.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 713;BA.debugLine="btnNew.TextColor = Colors.White";
_btnnew.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 714;BA.debugLine="pnlDialog.AddView(btnNew, 16dip, y, dialogW - 32d";
_pnldialog.AddView((android.view.View)(_btnnew.getObject()),__c.DipToCurrent((int) (16)),_y,(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 715;BA.debugLine="y = y + 55dip";
_y = (int) (_y+__c.DipToCurrent((int) (55)));
 //BA.debugLineNum = 718;BA.debugLine="Dim btnCancel As Button";
_btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 719;BA.debugLine="btnCancel.Initialize(\"btnDialogCancel\")";
_btncancel.Initialize(ba,"btnDialogCancel");
 //BA.debugLineNum = 720;BA.debugLine="btnCancel.Text = ModLang.T(\"cancel\")";
_btncancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 721;BA.debugLine="btnCancel.TextSize = Starter.FONT_BUTTON";
_btncancel.setTextSize(_starter._font_button /*float*/ );
 //BA.debugLineNum = 722;BA.debugLine="btnCancel.Color = Colors.Gray";
_btncancel.setColor(__c.Colors.Gray);
 //BA.debugLineNum = 723;BA.debugLine="btnCancel.TextColor = Colors.White";
_btncancel.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 724;BA.debugLine="pnlDialog.AddView(btnCancel, 16dip, y, 100dip, 40";
_pnldialog.AddView((android.view.View)(_btncancel.getObject()),__c.DipToCurrent((int) (16)),_y,__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 727;BA.debugLine="Dim dialogH As Int = y + 55dip";
_dialogh = (int) (_y+__c.DipToCurrent((int) (55)));
 //BA.debugLineNum = 728;BA.debugLine="If dialogH > Root.Height - 160dip Then dialogH =";
if (_dialogh>_root.getHeight()-__c.DipToCurrent((int) (160))) { 
_dialogh = (int) (_root.getHeight()-__c.DipToCurrent((int) (160)));};
 //BA.debugLineNum = 729;BA.debugLine="pnlDialog.SetLayoutAnimated(0, 20dip, 80dip, dial";
_pnldialog.SetLayoutAnimated((int) (0),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (80)),_dialogw,_dialogh);
 //BA.debugLineNum = 731;BA.debugLine="pnlOverlay.Visible = True";
_pnloverlay.setVisible(__c.True);
 //BA.debugLineNum = 732;BA.debugLine="pnlOverlay.BringToFront";
_pnloverlay.BringToFront();
 //BA.debugLineNum = 733;BA.debugLine="End Sub";
return "";
}
public String  _toggleselection(int _idx) throws Exception{
int _pos = 0;
 //BA.debugLineNum = 532;BA.debugLine="Private Sub ToggleSelection(idx As Int)";
 //BA.debugLineNum = 533;BA.debugLine="Dim pos As Int = SelectedIndexes.IndexOf(idx)";
_pos = _selectedindexes.IndexOf((Object)(_idx));
 //BA.debugLineNum = 534;BA.debugLine="If pos >= 0 Then";
if (_pos>=0) { 
 //BA.debugLineNum = 535;BA.debugLine="SelectedIndexes.RemoveAt(pos)";
_selectedindexes.RemoveAt(_pos);
 }else {
 //BA.debugLineNum = 537;BA.debugLine="SelectedIndexes.Add(idx)";
_selectedindexes.Add((Object)(_idx));
 };
 //BA.debugLineNum = 539;BA.debugLine="LoadEntries";
_loadentries();
 //BA.debugLineNum = 540;BA.debugLine="UpdateInfo";
_updateinfo();
 //BA.debugLineNum = 541;BA.debugLine="End Sub";
return "";
}
public String  _updateinfo() throws Exception{
int _filteredselected = 0;
anywheresoftware.b4a.objects.collections.Map _fe = null;
int _idx = 0;
 //BA.debugLineNum = 478;BA.debugLine="Private Sub UpdateInfo";
 //BA.debugLineNum = 480;BA.debugLine="If CurrentFilter <> \"\" Then";
if ((_currentfilter).equals("") == false) { 
 //BA.debugLineNum = 481;BA.debugLine="lblInfo.Text = FilteredEntries.Size & \"/\" & CSVE";
_lblinfo.setText(BA.ObjectToCharSequence(BA.NumberToString(_filteredentries.getSize())+"/"+BA.NumberToString(_csventries.getSize())+" "+_modlang._t /*String*/ (ba,"csv_entries_found")));
 }else {
 //BA.debugLineNum = 483;BA.debugLine="lblInfo.Text = CSVEntries.Size & \" \" & ModLang.T";
_lblinfo.setText(BA.ObjectToCharSequence(BA.NumberToString(_csventries.getSize())+" "+_modlang._t /*String*/ (ba,"csv_entries_found")));
 };
 //BA.debugLineNum = 486;BA.debugLine="lblSelected.Text = ModLang.T(\"csv_selected\") & \":";
_lblselected.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"csv_selected")+": "+BA.NumberToString(_selectedindexes.getSize())));
 //BA.debugLineNum = 487;BA.debugLine="btnImport.Text = ModLang.T(\"csv_import_btn\") & \"";
_btnimport.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"csv_import_btn")+" ("+BA.NumberToString(_selectedindexes.getSize())+")"));
 //BA.debugLineNum = 490;BA.debugLine="Dim filteredSelected As Int = 0";
_filteredselected = (int) (0);
 //BA.debugLineNum = 491;BA.debugLine="For Each fe As Map In FilteredEntries";
_fe = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group9 = _filteredentries;
final int groupLen9 = group9.getSize()
;int index9 = 0;
;
for (; index9 < groupLen9;index9++){
_fe = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group9.Get(index9)));
 //BA.debugLineNum = 492;BA.debugLine="Dim idx As Int = fe.Get(\"index\")";
_idx = (int)(BA.ObjectToNumber(_fe.Get((Object)("index"))));
 //BA.debugLineNum = 493;BA.debugLine="If SelectedIndexes.IndexOf(idx) >= 0 Then";
if (_selectedindexes.IndexOf((Object)(_idx))>=0) { 
 //BA.debugLineNum = 494;BA.debugLine="filteredSelected = filteredSelected + 1";
_filteredselected = (int) (_filteredselected+1);
 };
 }
};
 //BA.debugLineNum = 499;BA.debugLine="If filteredSelected = FilteredEntries.Size And Fi";
if (_filteredselected==_filteredentries.getSize() && _filteredentries.getSize()>0) { 
 //BA.debugLineNum = 500;BA.debugLine="btnToggleAll.Text = ModLang.T(\"csv_deselect_all\"";
_btntoggleall.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"csv_deselect_all")));
 }else {
 //BA.debugLineNum = 502;BA.debugLine="btnToggleAll.Text = ModLang.T(\"csv_select_all\")";
_btntoggleall.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"csv_select_all")));
 };
 //BA.debugLineNum = 505;BA.debugLine="If SelectedGroupName <> \"\" Then";
if ((_selectedgroupname).equals("") == false) { 
 //BA.debugLineNum = 506;BA.debugLine="btnSelectGroup.Text = SelectedGroupName";
_btnselectgroup.setText(BA.ObjectToCharSequence(_selectedgroupname));
 }else {
 //BA.debugLineNum = 508;BA.debugLine="btnSelectGroup.Text = ModLang.T(\"csv_select_grou";
_btnselectgroup.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"csv_select_group")));
 };
 //BA.debugLineNum = 510;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
