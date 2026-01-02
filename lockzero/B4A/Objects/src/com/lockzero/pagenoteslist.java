package com.lockzero;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class pagenoteslist extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.lockzero.pagenoteslist");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.lockzero.pagenoteslist.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbladd = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnback = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _svnotes = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _pnlnotes = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblempty = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblsearch = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlsearchbar = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtsearch = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblclearsearch = null;
public boolean _issearchvisible = false;
public anywheresoftware.b4a.objects.collections.List _allnotes = null;
public anywheresoftware.b4a.objects.collections.List _filterednotes = null;
public String _currentgroupid = "";
public boolean _isnotegroup = false;
public com.lockzero.clsnotegroup _currentgroup = null;
public String _grouppassphrase = "";
public boolean _isnavigating = false;
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
public String  _applytheme() throws Exception{
 //BA.debugLineNum = 543;BA.debugLine="Private Sub ApplyTheme";
 //BA.debugLineNum = 544;BA.debugLine="Root.Color = ModTheme.HomeBg";
_root.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 547;BA.debugLine="btnBack.Color = Colors.Transparent";
_btnback.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 548;BA.debugLine="btnBack.TextColor = Colors.White";
_btnback.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 550;BA.debugLine="lblEmpty.TextColor = Colors.ARGB(150, 255, 255, 2";
_lblempty.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 551;BA.debugLine="End Sub";
return "";
}
public void  _b4xpage_appear() throws Exception{
ResumableSub_B4XPage_Appear rsub = new ResumableSub_B4XPage_Appear(this);
rsub.resume(ba, null);
}
public static class ResumableSub_B4XPage_Appear extends BA.ResumableSub {
public ResumableSub_B4XPage_Appear(com.lockzero.pagenoteslist parent) {
this.parent = parent;
}
com.lockzero.pagenoteslist parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 48;BA.debugLine="Log(\"PageNotesList.B4XPage_Appear - IsNavigating=";
parent.__c.LogImpl("832768002","PageNotesList.B4XPage_Appear - IsNavigating="+BA.ObjectToString(parent._isnavigating),0);
 //BA.debugLineNum = 51;BA.debugLine="If IsNoteGroup And CurrentGroup <> Null Then";
if (true) break;

case 1:
//if
this.state = 6;
if (parent._isnotegroup && parent._currentgroup!= null) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 //BA.debugLineNum = 52;BA.debugLine="lblTitle.Text = ModLang.T(\"notes\") & \" → \" & Cur";
parent._lbltitle.setText(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"notes")+" → "+parent._currentgroup._name /*String*/ ));
 //BA.debugLineNum = 53;BA.debugLine="CallSub2(Main, \"SetPageTitle\", CurrentGroup.Name";
parent.__c.CallSubNew2(ba,(Object)(parent._main.getObject()),"SetPageTitle",(Object)(parent._currentgroup._name /*String*/ ));
 if (true) break;

case 5:
//C
this.state = 6;
 //BA.debugLineNum = 55;BA.debugLine="lblTitle.Text = ModLang.T(\"notes\")";
parent._lbltitle.setText(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"notes")));
 //BA.debugLineNum = 56;BA.debugLine="CallSub2(Main, \"SetPageTitle\", ModLang.T(\"notes\"";
parent.__c.CallSubNew2(ba,(Object)(parent._main.getObject()),"SetPageTitle",(Object)(parent._modlang._t /*String*/ (ba,"notes")));
 if (true) break;
;
 //BA.debugLineNum = 60;BA.debugLine="If IsNoteGroup And CurrentGroup <> Null And Curre";

case 6:
//if
this.state = 9;
if (parent._isnotegroup && parent._currentgroup!= null && parent._currentgroup._issecure /*boolean*/ ) { 
this.state = 8;
}if (true) break;

case 8:
//C
this.state = 9;
 //BA.debugLineNum = 61;BA.debugLine="ModSession.Touch";
parent._modsession._touch /*String*/ (ba);
 if (true) break;

case 9:
//C
this.state = -1;
;
 //BA.debugLineNum = 64;BA.debugLine="LoadNotes";
parent._loadnotes();
 //BA.debugLineNum = 67;BA.debugLine="Sleep(100)";
parent.__c.Sleep(ba,this,(int) (100));
this.state = 10;
return;
case 10:
//C
this.state = -1;
;
 //BA.debugLineNum = 68;BA.debugLine="IsNavigating = False";
parent._isnavigating = parent.__c.False;
 //BA.debugLineNum = 69;BA.debugLine="Log(\"PageNotesList - IsNavigating resetado para F";
parent.__c.LogImpl("832768023","PageNotesList - IsNavigating resetado para False",0);
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
 //BA.debugLineNum = 40;BA.debugLine="Private Sub B4XPage_Created(Root1 As B4XView)";
 //BA.debugLineNum = 41;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 42;BA.debugLine="CreateUI";
_createui();
 //BA.debugLineNum = 43;BA.debugLine="ApplyTheme";
_applytheme();
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return "";
}
public String  _btnback_click() throws Exception{
 //BA.debugLineNum = 463;BA.debugLine="Private Sub btnBack_Click";
 //BA.debugLineNum = 464;BA.debugLine="B4XPages.ClosePage(Me)";
_b4xpages._closepage /*String*/ (ba,this);
 //BA.debugLineNum = 465;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 4;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Public Root As B4XView  'Public para transicoes";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 6;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 9;BA.debugLine="Private lblAdd As Label";
_lbladd = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 10;BA.debugLine="Private btnBack As Button";
_btnback = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 12;BA.debugLine="Private svNotes As ScrollView";
_svnotes = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Private pnlNotes As B4XView";
_pnlnotes = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Private lblEmpty As Label";
_lblempty = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private lblSearch As Label         'Icone de lupa";
_lblsearch = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private pnlSearchBar As Panel      'Barra de busc";
_pnlsearchbar = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private edtSearch As EditText      'Campo de busc";
_edtsearch = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private lblClearSearch As Label    'Botao X para";
_lblclearsearch = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private IsSearchVisible As Boolean = False  'Cont";
_issearchvisible = __c.False;
 //BA.debugLineNum = 24;BA.debugLine="Private AllNotes As List           'Lista complet";
_allnotes = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 25;BA.debugLine="Private FilteredNotes As List      'Lista filtrad";
_filterednotes = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 28;BA.debugLine="Private CurrentGroupId As String = \"\"";
_currentgroupid = "";
 //BA.debugLineNum = 29;BA.debugLine="Private IsNoteGroup As Boolean = False  'True = N";
_isnotegroup = __c.False;
 //BA.debugLineNum = 30;BA.debugLine="Private CurrentGroup As clsNoteGroup    'Referenc";
_currentgroup = new com.lockzero.clsnotegroup();
 //BA.debugLineNum = 31;BA.debugLine="Private GroupPassphrase As String = \"\"  'Passphra";
_grouppassphrase = "";
 //BA.debugLineNum = 32;BA.debugLine="Private IsNavigating As Boolean = False  'Flag pa";
_isnavigating = __c.False;
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.PanelWrapper  _createnotecard(com.lockzero.clsnoteentry _note,int _cardwidth) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xv = null;
boolean _needsdecrypt = false;
String _passphrase = "";
anywheresoftware.b4a.objects.LabelWrapper _lbltypeicon = null;
String _title = "";
anywheresoftware.b4a.objects.LabelWrapper _lblnotetitle = null;
String _preview = "";
int _total = 0;
int _checked = 0;
anywheresoftware.b4a.objects.LabelWrapper _lblpreview = null;
anywheresoftware.b4a.objects.LabelWrapper _lblstar = null;
 //BA.debugLineNum = 321;BA.debugLine="Private Sub CreateNoteCard(note As clsNoteEntry, c";
 //BA.debugLineNum = 322;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 323;BA.debugLine="pnl.Initialize(\"pnlNote\")";
_pnl.Initialize(ba,"pnlNote");
 //BA.debugLineNum = 326;BA.debugLine="Dim xv As B4XView = pnl";
_xv = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xv = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnl.getObject()));
 //BA.debugLineNum = 327;BA.debugLine="xv.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModT";
_xv.SetColorAndBorder(_modtheme._homeiconbg /*int*/ (ba),(int) (0),_modtheme._homeiconbg /*int*/ (ba),__c.DipToCurrent((int) (12)));
 //BA.debugLineNum = 330;BA.debugLine="Dim needsDecrypt As Boolean = True";
_needsdecrypt = __c.True;
 //BA.debugLineNum = 331;BA.debugLine="Dim passphrase As String = \"\"";
_passphrase = "";
 //BA.debugLineNum = 333;BA.debugLine="If IsNoteGroup And CurrentGroup <> Null Then";
if (_isnotegroup && _currentgroup!= null) { 
 //BA.debugLineNum = 334;BA.debugLine="If CurrentGroup.IsSecure = False Then";
if (_currentgroup._issecure /*boolean*/ ==__c.False) { 
 //BA.debugLineNum = 336;BA.debugLine="needsDecrypt = False";
_needsdecrypt = __c.False;
 }else {
 //BA.debugLineNum = 339;BA.debugLine="passphrase = GroupPassphrase";
_passphrase = _grouppassphrase;
 //BA.debugLineNum = 340;BA.debugLine="If passphrase = \"\" Then passphrase = ModSession";
if ((_passphrase).equals("")) { 
_passphrase = _modsession._getpassphrase /*String*/ (ba);};
 };
 }else {
 //BA.debugLineNum = 344;BA.debugLine="passphrase = ModSession.GetPassphrase";
_passphrase = _modsession._getpassphrase /*String*/ (ba);
 };
 //BA.debugLineNum = 348;BA.debugLine="Dim lblTypeIcon As Label";
_lbltypeicon = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 349;BA.debugLine="lblTypeIcon.Initialize(\"\")";
_lbltypeicon.Initialize(ba,"");
 //BA.debugLineNum = 350;BA.debugLine="If note.IsListNote Then";
if (_note._islistnote /*boolean*/ ()) { 
 //BA.debugLineNum = 351;BA.debugLine="lblTypeIcon.Text = Chr(0x2611)  'Checkbox marcad";
_lbltypeicon.setText(BA.ObjectToCharSequence(__c.Chr(((int)0x2611))));
 }else {
 //BA.debugLineNum = 353;BA.debugLine="lblTypeIcon.Text = Chr(0xD83D) & Chr(0xDCDD)  'N";
_lbltypeicon.setText(BA.ObjectToCharSequence(BA.ObjectToString(__c.Chr(((int)0xd83d)))+BA.ObjectToString(__c.Chr(((int)0xdcdd)))));
 };
 //BA.debugLineNum = 355;BA.debugLine="lblTypeIcon.TextSize = 20";
_lbltypeicon.setTextSize((float) (20));
 //BA.debugLineNum = 356;BA.debugLine="lblTypeIcon.Gravity = Gravity.CENTER";
_lbltypeicon.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 357;BA.debugLine="pnl.AddView(lblTypeIcon, 8dip, 25dip, 30dip, 30di";
_pnl.AddView((android.view.View)(_lbltypeicon.getObject()),__c.DipToCurrent((int) (8)),__c.DipToCurrent((int) (25)),__c.DipToCurrent((int) (30)),__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 360;BA.debugLine="Dim title As String";
_title = "";
 //BA.debugLineNum = 361;BA.debugLine="If needsDecrypt Then";
if (_needsdecrypt) { 
 //BA.debugLineNum = 362;BA.debugLine="title = note.GetDecryptedTitle(passphrase)";
_title = _note._getdecryptedtitle /*String*/ (_passphrase);
 }else {
 //BA.debugLineNum = 364;BA.debugLine="title = note.Title  'Texto claro para grupos abe";
_title = _note._title /*String*/ ;
 };
 //BA.debugLineNum = 366;BA.debugLine="If title.Length > 25 Then title = title.SubString";
if (_title.length()>25) { 
_title = _title.substring((int) (0),(int) (25))+"...";};
 //BA.debugLineNum = 368;BA.debugLine="Dim lblNoteTitle As Label";
_lblnotetitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 369;BA.debugLine="lblNoteTitle.Initialize(\"\")";
_lblnotetitle.Initialize(ba,"");
 //BA.debugLineNum = 370;BA.debugLine="lblNoteTitle.Text = title";
_lblnotetitle.setText(BA.ObjectToCharSequence(_title));
 //BA.debugLineNum = 371;BA.debugLine="lblNoteTitle.TextSize = Starter.FONT_BODY";
_lblnotetitle.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 372;BA.debugLine="lblNoteTitle.TextColor = Colors.White";
_lblnotetitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 373;BA.debugLine="lblNoteTitle.Typeface = Typeface.CreateNew(Typefa";
_lblnotetitle.setTypeface(__c.Typeface.CreateNew(__c.Typeface.DEFAULT,__c.Typeface.STYLE_BOLD));
 //BA.debugLineNum = 374;BA.debugLine="pnl.AddView(lblNoteTitle, 42dip, 10dip, cardWidth";
_pnl.AddView((android.view.View)(_lblnotetitle.getObject()),__c.DipToCurrent((int) (42)),__c.DipToCurrent((int) (10)),(int) (_cardwidth-__c.DipToCurrent((int) (90))),__c.DipToCurrent((int) (25)));
 //BA.debugLineNum = 377;BA.debugLine="Dim preview As String";
_preview = "";
 //BA.debugLineNum = 378;BA.debugLine="If note.IsListNote Then";
if (_note._islistnote /*boolean*/ ()) { 
 //BA.debugLineNum = 380;BA.debugLine="Dim total As Int = note.GetItemsCount";
_total = _note._getitemscount /*int*/ ();
 //BA.debugLineNum = 381;BA.debugLine="Dim checked As Int = note.GetCheckedCount";
_checked = _note._getcheckedcount /*int*/ ();
 //BA.debugLineNum = 382;BA.debugLine="preview = checked & \" \" & ModLang.T(\"of\") & \" \"";
_preview = BA.NumberToString(_checked)+" "+_modlang._t /*String*/ (ba,"of")+" "+BA.NumberToString(_total)+" "+_modlang._t /*String*/ (ba,"items");
 }else {
 //BA.debugLineNum = 385;BA.debugLine="If needsDecrypt Then";
if (_needsdecrypt) { 
 //BA.debugLineNum = 386;BA.debugLine="preview = note.GetDecryptedContent(passphrase)";
_preview = _note._getdecryptedcontent /*String*/ (_passphrase);
 }else {
 //BA.debugLineNum = 388;BA.debugLine="preview = note.Content";
_preview = _note._content /*String*/ ;
 };
 //BA.debugLineNum = 390;BA.debugLine="If preview.Length > 40 Then preview = preview.Su";
if (_preview.length()>40) { 
_preview = _preview.substring((int) (0),(int) (40))+"...";};
 //BA.debugLineNum = 391;BA.debugLine="preview = preview.Replace(Chr(10), \" \").Replace(";
_preview = _preview.replace(BA.ObjectToString(__c.Chr((int) (10)))," ").replace(BA.ObjectToString(__c.Chr((int) (13)))," ");
 };
 //BA.debugLineNum = 394;BA.debugLine="Dim lblPreview As Label";
_lblpreview = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 395;BA.debugLine="lblPreview.Initialize(\"\")";
_lblpreview.Initialize(ba,"");
 //BA.debugLineNum = 396;BA.debugLine="lblPreview.Text = preview";
_lblpreview.setText(BA.ObjectToCharSequence(_preview));
 //BA.debugLineNum = 397;BA.debugLine="lblPreview.TextSize = Starter.FONT_LABEL";
_lblpreview.setTextSize(_starter._font_label /*float*/ );
 //BA.debugLineNum = 398;BA.debugLine="lblPreview.TextColor = Colors.ARGB(180, 255, 255,";
_lblpreview.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 399;BA.debugLine="pnl.AddView(lblPreview, 42dip, 38dip, cardWidth -";
_pnl.AddView((android.view.View)(_lblpreview.getObject()),__c.DipToCurrent((int) (42)),__c.DipToCurrent((int) (38)),(int) (_cardwidth-__c.DipToCurrent((int) (90))),__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 402;BA.debugLine="If note.IsFavorite Then";
if (_note._isfavorite /*boolean*/ ) { 
 //BA.debugLineNum = 403;BA.debugLine="Dim lblStar As Label";
_lblstar = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 404;BA.debugLine="lblStar.Initialize(\"\")";
_lblstar.Initialize(ba,"");
 //BA.debugLineNum = 405;BA.debugLine="lblStar.Text = Chr(9733) '\"★\"";
_lblstar.setText(BA.ObjectToCharSequence(__c.Chr((int) (9733))));
 //BA.debugLineNum = 406;BA.debugLine="lblStar.TextSize = 20";
_lblstar.setTextSize((float) (20));
 //BA.debugLineNum = 407;BA.debugLine="lblStar.TextColor = Colors.RGB(255, 200, 100) 'A";
_lblstar.setTextColor(__c.Colors.RGB((int) (255),(int) (200),(int) (100)));
 //BA.debugLineNum = 408;BA.debugLine="lblStar.Gravity = Gravity.CENTER";
_lblstar.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 409;BA.debugLine="pnl.AddView(lblStar, cardWidth - 40dip, 25dip, 3";
_pnl.AddView((android.view.View)(_lblstar.getObject()),(int) (_cardwidth-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (25)),__c.DipToCurrent((int) (30)),__c.DipToCurrent((int) (30)));
 };
 //BA.debugLineNum = 412;BA.debugLine="Return pnl";
if (true) return _pnl;
 //BA.debugLineNum = 413;BA.debugLine="End Sub";
return null;
}
public String  _createui() throws Exception{
int _width = 0;
int _height = 0;
int _headerh = 0;
int _searchh = 0;
anywheresoftware.b4a.objects.PanelWrapper _pnlheader = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xvsearch = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xvadd = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlsearchinput = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xvsearchinput = null;
 //BA.debugLineNum = 91;BA.debugLine="Private Sub CreateUI";
 //BA.debugLineNum = 92;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 93;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 94;BA.debugLine="Dim headerH As Int = 56dip";
_headerh = __c.DipToCurrent((int) (56));
 //BA.debugLineNum = 95;BA.debugLine="Dim searchH As Int = 54dip";
_searchh = __c.DipToCurrent((int) (54));
 //BA.debugLineNum = 98;BA.debugLine="Dim pnlHeader As Panel";
_pnlheader = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 99;BA.debugLine="pnlHeader.Initialize(\"\")";
_pnlheader.Initialize(ba,"");
 //BA.debugLineNum = 100;BA.debugLine="pnlHeader.Color = ModTheme.HomeHeaderBg";
_pnlheader.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 101;BA.debugLine="Root.AddView(pnlHeader, 0, 0, width, headerH)";
_root.AddView((android.view.View)(_pnlheader.getObject()),(int) (0),(int) (0),_width,_headerh);
 //BA.debugLineNum = 104;BA.debugLine="btnBack.Initialize(\"btnBack\")";
_btnback.Initialize(ba,"btnBack");
 //BA.debugLineNum = 105;BA.debugLine="btnBack.Text = \"<\"";
_btnback.setText(BA.ObjectToCharSequence("<"));
 //BA.debugLineNum = 106;BA.debugLine="btnBack.TextSize = 20";
_btnback.setTextSize((float) (20));
 //BA.debugLineNum = 107;BA.debugLine="btnBack.TextColor = Colors.White";
_btnback.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 108;BA.debugLine="btnBack.Color = Colors.Transparent";
_btnback.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 109;BA.debugLine="btnBack.Gravity = Gravity.CENTER";
_btnback.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 110;BA.debugLine="pnlHeader.AddView(btnBack, 0, 0, 48dip, headerH)";
_pnlheader.AddView((android.view.View)(_btnback.getObject()),(int) (0),(int) (0),__c.DipToCurrent((int) (48)),_headerh);
 //BA.debugLineNum = 113;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 114;BA.debugLine="lblTitle.Text = ModLang.T(\"notes\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"notes")));
 //BA.debugLineNum = 115;BA.debugLine="lblTitle.TextSize = Starter.FONT_BODY";
_lbltitle.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 116;BA.debugLine="lblTitle.TextColor = Colors.ARGB(200, 255, 255, 2";
_lbltitle.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 117;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 118;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_VERTICAL";
_lbltitle.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 119;BA.debugLine="pnlHeader.AddView(lblTitle, 48dip, 0, width - 150";
_pnlheader.AddView((android.view.View)(_lbltitle.getObject()),__c.DipToCurrent((int) (48)),(int) (0),(int) (_width-__c.DipToCurrent((int) (150))),_headerh);
 //BA.debugLineNum = 122;BA.debugLine="lblSearch.Initialize(\"lblSearch\")";
_lblsearch.Initialize(ba,"lblSearch");
 //BA.debugLineNum = 123;BA.debugLine="lblSearch.Text = Chr(0xD83D) & Chr(0xDD0D)  '🔍 (";
_lblsearch.setText(BA.ObjectToCharSequence(BA.ObjectToString(__c.Chr(((int)0xd83d)))+BA.ObjectToString(__c.Chr(((int)0xdd0d)))));
 //BA.debugLineNum = 124;BA.debugLine="lblSearch.TextSize = 18";
_lblsearch.setTextSize((float) (18));
 //BA.debugLineNum = 125;BA.debugLine="lblSearch.TextColor = Colors.White";
_lblsearch.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 126;BA.debugLine="lblSearch.Gravity = Gravity.CENTER";
_lblsearch.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 127;BA.debugLine="pnlHeader.AddView(lblSearch, width - 90dip, 8dip,";
_pnlheader.AddView((android.view.View)(_lblsearch.getObject()),(int) (_width-__c.DipToCurrent((int) (90))),__c.DipToCurrent((int) (8)),__c.DipToCurrent((int) (40)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 130;BA.debugLine="Dim xvSearch As B4XView = lblSearch";
_xvsearch = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvsearch = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lblsearch.getObject()));
 //BA.debugLineNum = 131;BA.debugLine="xvSearch.SetColorAndBorder(Colors.ARGB(60, 255, 2";
_xvsearch.SetColorAndBorder(__c.Colors.ARGB((int) (60),(int) (255),(int) (255),(int) (255)),(int) (0),__c.Colors.Transparent,__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 134;BA.debugLine="lblAdd.Initialize(\"lblAdd\")";
_lbladd.Initialize(ba,"lblAdd");
 //BA.debugLineNum = 135;BA.debugLine="lblAdd.Text = \"+\"";
_lbladd.setText(BA.ObjectToCharSequence("+"));
 //BA.debugLineNum = 136;BA.debugLine="lblAdd.TextSize = 26";
_lbladd.setTextSize((float) (26));
 //BA.debugLineNum = 137;BA.debugLine="lblAdd.Typeface = Typeface.DEFAULT_BOLD";
_lbladd.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 138;BA.debugLine="lblAdd.Gravity = Gravity.CENTER";
_lbladd.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 139;BA.debugLine="lblAdd.TextColor = Colors.White";
_lbladd.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 140;BA.debugLine="pnlHeader.AddView(lblAdd, width - 50dip, 8dip, 40";
_pnlheader.AddView((android.view.View)(_lbladd.getObject()),(int) (_width-__c.DipToCurrent((int) (50))),__c.DipToCurrent((int) (8)),__c.DipToCurrent((int) (40)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 143;BA.debugLine="Dim xvAdd As B4XView = lblAdd";
_xvadd = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvadd = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbladd.getObject()));
 //BA.debugLineNum = 144;BA.debugLine="xvAdd.SetColorAndBorder(ModTheme.HomeIconBg, 0, M";
_xvadd.SetColorAndBorder(_modtheme._homeiconbg /*int*/ (ba),(int) (0),_modtheme._homeiconbg /*int*/ (ba),__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 147;BA.debugLine="pnlSearchBar.Initialize(\"\")";
_pnlsearchbar.Initialize(ba,"");
 //BA.debugLineNum = 148;BA.debugLine="pnlSearchBar.Color = ModTheme.HomeBg";
_pnlsearchbar.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 149;BA.debugLine="pnlSearchBar.Visible = False";
_pnlsearchbar.setVisible(__c.False);
 //BA.debugLineNum = 150;BA.debugLine="Root.AddView(pnlSearchBar, 0, headerH, width, sea";
_root.AddView((android.view.View)(_pnlsearchbar.getObject()),(int) (0),_headerh,_width,_searchh);
 //BA.debugLineNum = 153;BA.debugLine="Dim pnlSearchInput As Panel";
_pnlsearchinput = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 154;BA.debugLine="pnlSearchInput.Initialize(\"\")";
_pnlsearchinput.Initialize(ba,"");
 //BA.debugLineNum = 155;BA.debugLine="pnlSearchInput.Color = ModTheme.HomeIconBg";
_pnlsearchinput.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 156;BA.debugLine="pnlSearchBar.AddView(pnlSearchInput, 16dip, 5dip,";
_pnlsearchbar.AddView((android.view.View)(_pnlsearchinput.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (5)),(int) (_width-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 158;BA.debugLine="Dim xvSearchInput As B4XView = pnlSearchInput";
_xvsearchinput = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvsearchinput = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnlsearchinput.getObject()));
 //BA.debugLineNum = 159;BA.debugLine="xvSearchInput.SetColorAndBorder(ModTheme.HomeIcon";
_xvsearchinput.SetColorAndBorder(_modtheme._homeiconbg /*int*/ (ba),(int) (0),_modtheme._homeiconbg /*int*/ (ba),__c.DipToCurrent((int) (8)));
 //BA.debugLineNum = 161;BA.debugLine="edtSearch.Initialize(\"edtSearch\")";
_edtsearch.Initialize(ba,"edtSearch");
 //BA.debugLineNum = 162;BA.debugLine="edtSearch.Hint = ModLang.T(\"search\") & \"...\"";
_edtsearch.setHint(_modlang._t /*String*/ (ba,"search")+"...");
 //BA.debugLineNum = 163;BA.debugLine="edtSearch.SingleLine = True";
_edtsearch.setSingleLine(__c.True);
 //BA.debugLineNum = 164;BA.debugLine="edtSearch.Text = \"\"";
_edtsearch.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 165;BA.debugLine="edtSearch.TextSize = Starter.FONT_BODY";
_edtsearch.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 166;BA.debugLine="edtSearch.TextColor = Colors.White";
_edtsearch.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 167;BA.debugLine="edtSearch.HintColor = Colors.ARGB(120, 255, 255,";
_edtsearch.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 168;BA.debugLine="pnlSearchInput.AddView(edtSearch, 12dip, 0, width";
_pnlsearchinput.AddView((android.view.View)(_edtsearch.getObject()),__c.DipToCurrent((int) (12)),(int) (0),(int) (_width-__c.DipToCurrent((int) (100))),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 171;BA.debugLine="lblClearSearch.Initialize(\"lblClearSearch\")";
_lblclearsearch.Initialize(ba,"lblClearSearch");
 //BA.debugLineNum = 172;BA.debugLine="lblClearSearch.Text = \"X\"";
_lblclearsearch.setText(BA.ObjectToCharSequence("X"));
 //BA.debugLineNum = 173;BA.debugLine="lblClearSearch.TextSize = 16";
_lblclearsearch.setTextSize((float) (16));
 //BA.debugLineNum = 174;BA.debugLine="lblClearSearch.TextColor = Colors.ARGB(180, 255,";
_lblclearsearch.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 175;BA.debugLine="lblClearSearch.Gravity = Gravity.CENTER";
_lblclearsearch.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 176;BA.debugLine="lblClearSearch.Visible = False";
_lblclearsearch.setVisible(__c.False);
 //BA.debugLineNum = 177;BA.debugLine="pnlSearchInput.AddView(lblClearSearch, width - 80";
_pnlsearchinput.AddView((android.view.View)(_lblclearsearch.getObject()),(int) (_width-__c.DipToCurrent((int) (80))),__c.DipToCurrent((int) (2)),__c.DipToCurrent((int) (40)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 180;BA.debugLine="svNotes.Initialize(0)";
_svnotes.Initialize(ba,(int) (0));
 //BA.debugLineNum = 181;BA.debugLine="svNotes.Color = ModTheme.HomeBg";
_svnotes.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 182;BA.debugLine="Root.AddView(svNotes, 0, headerH, width, height -";
_root.AddView((android.view.View)(_svnotes.getObject()),(int) (0),_headerh,_width,(int) (_height-_headerh));
 //BA.debugLineNum = 184;BA.debugLine="pnlNotes = svNotes.Panel";
_pnlnotes = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_svnotes.getPanel().getObject()));
 //BA.debugLineNum = 185;BA.debugLine="pnlNotes.Color = ModTheme.HomeBg";
_pnlnotes.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 188;BA.debugLine="lblEmpty.Initialize(\"\")";
_lblempty.Initialize(ba,"");
 //BA.debugLineNum = 189;BA.debugLine="lblEmpty.Text = ModLang.T(\"empty\")";
_lblempty.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"empty")));
 //BA.debugLineNum = 190;BA.debugLine="lblEmpty.TextSize = Starter.FONT_BODY";
_lblempty.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 191;BA.debugLine="lblEmpty.Gravity = Gravity.CENTER";
_lblempty.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 192;BA.debugLine="lblEmpty.Visible = False";
_lblempty.setVisible(__c.False);
 //BA.debugLineNum = 193;BA.debugLine="Root.AddView(lblEmpty, 0, height / 2 - 20dip, wid";
_root.AddView((android.view.View)(_lblempty.getObject()),(int) (0),(int) (_height/(double)2-__c.DipToCurrent((int) (20))),_width,__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 194;BA.debugLine="End Sub";
return "";
}
public String  _displaynotes() throws Exception{
int _width = 0;
int _y = 0;
int _cardheight = 0;
int _margin = 0;
int _i = 0;
com.lockzero.clsnoteentry _note = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlcard = null;
 //BA.debugLineNum = 273;BA.debugLine="Private Sub DisplayNotes";
 //BA.debugLineNum = 274;BA.debugLine="pnlNotes.RemoveAllViews";
_pnlnotes.RemoveAllViews();
 //BA.debugLineNum = 276;BA.debugLine="If FilteredNotes.Size = 0 Then";
if (_filterednotes.getSize()==0) { 
 //BA.debugLineNum = 277;BA.debugLine="lblEmpty.Visible = True";
_lblempty.setVisible(__c.True);
 //BA.debugLineNum = 278;BA.debugLine="pnlNotes.Height = 0";
_pnlnotes.setHeight((int) (0));
 //BA.debugLineNum = 279;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 282;BA.debugLine="lblEmpty.Visible = False";
_lblempty.setVisible(__c.False);
 //BA.debugLineNum = 284;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 285;BA.debugLine="Dim y As Int = 10dip";
_y = __c.DipToCurrent((int) (10));
 //BA.debugLineNum = 286;BA.debugLine="Dim cardHeight As Int = 80dip";
_cardheight = __c.DipToCurrent((int) (80));
 //BA.debugLineNum = 287;BA.debugLine="Dim margin As Int = 16dip";
_margin = __c.DipToCurrent((int) (16));
 //BA.debugLineNum = 289;BA.debugLine="For i = 0 To FilteredNotes.Size - 1";
{
final int step12 = 1;
final int limit12 = (int) (_filterednotes.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit12 ;_i = _i + step12 ) {
 //BA.debugLineNum = 290;BA.debugLine="Dim note As clsNoteEntry = FilteredNotes.Get(i)";
_note = (com.lockzero.clsnoteentry)(_filterednotes.Get(_i));
 //BA.debugLineNum = 291;BA.debugLine="Dim pnlCard As Panel = CreateNoteCard(note, widt";
_pnlcard = new anywheresoftware.b4a.objects.PanelWrapper();
_pnlcard = _createnotecard(_note,(int) (_width-(_margin*2)));
 //BA.debugLineNum = 292;BA.debugLine="pnlCard.Tag = note.Id";
_pnlcard.setTag((Object)(_note._id /*String*/ ));
 //BA.debugLineNum = 293;BA.debugLine="pnlNotes.AddView(pnlCard, margin, y, width - (ma";
_pnlnotes.AddView((android.view.View)(_pnlcard.getObject()),_margin,_y,(int) (_width-(_margin*2)),_cardheight);
 //BA.debugLineNum = 294;BA.debugLine="y = y + cardHeight + 10dip";
_y = (int) (_y+_cardheight+__c.DipToCurrent((int) (10)));
 }
};
 //BA.debugLineNum = 297;BA.debugLine="pnlNotes.Height = y + 20dip";
_pnlnotes.setHeight((int) (_y+__c.DipToCurrent((int) (20))));
 //BA.debugLineNum = 298;BA.debugLine="End Sub";
return "";
}
public String  _edtsearch_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 480;BA.debugLine="Private Sub edtSearch_TextChanged(Old As String, N";
 //BA.debugLineNum = 482;BA.debugLine="If IsNoteGroup And CurrentGroup <> Null And Curre";
if (_isnotegroup && _currentgroup!= null && _currentgroup._issecure /*boolean*/ ) { 
 //BA.debugLineNum = 483;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 };
 //BA.debugLineNum = 485;BA.debugLine="FilterNotes(New)";
_filternotes(_new);
 //BA.debugLineNum = 487;BA.debugLine="lblClearSearch.Visible = (New.Length > 0)";
_lblclearsearch.setVisible((_new.length()>0));
 //BA.debugLineNum = 488;BA.debugLine="End Sub";
return "";
}
public String  _filternotes(String _query) throws Exception{
String _q = "";
com.lockzero.clsnoteentry _n = null;
String _passphrase = "";
boolean _found = false;
String _title = "";
String _content = "";
String _itemsjson = "";
 //BA.debugLineNum = 219;BA.debugLine="Private Sub FilterNotes(query As String)";
 //BA.debugLineNum = 220;BA.debugLine="FilteredNotes.Initialize";
_filterednotes.Initialize();
 //BA.debugLineNum = 221;BA.debugLine="Dim q As String = query.ToLowerCase.Trim";
_q = _query.toLowerCase().trim();
 //BA.debugLineNum = 223;BA.debugLine="If q.Length = 0 Then";
if (_q.length()==0) { 
 //BA.debugLineNum = 225;BA.debugLine="For Each n As clsNoteEntry In AllNotes";
{
final anywheresoftware.b4a.BA.IterableList group4 = _allnotes;
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_n = (com.lockzero.clsnoteentry)(group4.Get(index4));
 //BA.debugLineNum = 226;BA.debugLine="FilteredNotes.Add(n)";
_filterednotes.Add((Object)(_n));
 }
};
 }else {
 //BA.debugLineNum = 230;BA.debugLine="Dim passphrase As String = \"\"";
_passphrase = "";
 //BA.debugLineNum = 231;BA.debugLine="If IsNoteGroup And CurrentGroup <> Null And Curr";
if (_isnotegroup && _currentgroup!= null && _currentgroup._issecure /*boolean*/ ) { 
 //BA.debugLineNum = 232;BA.debugLine="passphrase = GroupPassphrase";
_passphrase = _grouppassphrase;
 //BA.debugLineNum = 233;BA.debugLine="If passphrase = \"\" Then passphrase = ModSession";
if ((_passphrase).equals("")) { 
_passphrase = _modsession._getpassphrase /*String*/ (ba);};
 };
 //BA.debugLineNum = 237;BA.debugLine="For Each n As clsNoteEntry In AllNotes";
{
final anywheresoftware.b4a.BA.IterableList group13 = _allnotes;
final int groupLen13 = group13.getSize()
;int index13 = 0;
;
for (; index13 < groupLen13;index13++){
_n = (com.lockzero.clsnoteentry)(group13.Get(index13));
 //BA.debugLineNum = 238;BA.debugLine="Dim found As Boolean = False";
_found = __c.False;
 //BA.debugLineNum = 240;BA.debugLine="Try";
try { //BA.debugLineNum = 242;BA.debugLine="Dim title As String = n.GetDecryptedTitle(pass";
_title = _n._getdecryptedtitle /*String*/ (_passphrase).toLowerCase();
 //BA.debugLineNum = 243;BA.debugLine="If title.Contains(q) Then";
if (_title.contains(_q)) { 
 //BA.debugLineNum = 244;BA.debugLine="found = True";
_found = __c.True;
 };
 //BA.debugLineNum = 248;BA.debugLine="If found = False Then";
if (_found==__c.False) { 
 //BA.debugLineNum = 249;BA.debugLine="Dim content As String = n.GetDecryptedContent";
_content = _n._getdecryptedcontent /*String*/ (_passphrase).toLowerCase();
 //BA.debugLineNum = 250;BA.debugLine="If content.Contains(q) Then found = True";
if (_content.contains(_q)) { 
_found = __c.True;};
 };
 //BA.debugLineNum = 254;BA.debugLine="If found = False And n.IsListNote Then";
if (_found==__c.False && _n._islistnote /*boolean*/ ()) { 
 //BA.debugLineNum = 255;BA.debugLine="Dim itemsJson As String = n.GetDecryptedItems";
_itemsjson = _n._getdecrypteditems /*String*/ (_passphrase).toLowerCase();
 //BA.debugLineNum = 256;BA.debugLine="If itemsJson.Contains(q) Then found = True";
if (_itemsjson.contains(_q)) { 
_found = __c.True;};
 };
 } 
       catch (Exception e29) {
			ba.setLastException(e29); //BA.debugLineNum = 260;BA.debugLine="If n.Title.ToLowerCase.Contains(q) Then found";
if (_n._title /*String*/ .toLowerCase().contains(_q)) { 
_found = __c.True;};
 //BA.debugLineNum = 261;BA.debugLine="If found = False And n.Content.ToLowerCase.Con";
if (_found==__c.False && _n._content /*String*/ .toLowerCase().contains(_q)) { 
_found = __c.True;};
 //BA.debugLineNum = 262;BA.debugLine="If found = False And n.Items.ToLowerCase.Conta";
if (_found==__c.False && _n._items /*String*/ .toLowerCase().contains(_q)) { 
_found = __c.True;};
 };
 //BA.debugLineNum = 265;BA.debugLine="If found Then FilteredNotes.Add(n)";
if (_found) { 
_filterednotes.Add((Object)(_n));};
 }
};
 };
 //BA.debugLineNum = 269;BA.debugLine="DisplayNotes";
_displaynotes();
 //BA.debugLineNum = 270;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 35;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 36;BA.debugLine="AllNotes.Initialize";
_allnotes.Initialize();
 //BA.debugLineNum = 37;BA.debugLine="FilteredNotes.Initialize";
_filterednotes.Initialize();
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public void  _lbladd_click() throws Exception{
ResumableSub_lblAdd_Click rsub = new ResumableSub_lblAdd_Click(this);
rsub.resume(ba, null);
}
public static class ResumableSub_lblAdd_Click extends BA.ResumableSub {
public ResumableSub_lblAdd_Click(com.lockzero.pagenoteslist parent) {
this.parent = parent;
}
com.lockzero.pagenoteslist parent;
int _result = 0;
String _notetype = "";
anywheresoftware.b4a.objects.collections.Map _params = null;
com.lockzero.pagenoteedit _pg = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 498;BA.debugLine="Log(\"lblAdd_Click - IsNavigating=\" & IsNavigating";
parent.__c.LogImpl("833292289","lblAdd_Click - IsNavigating="+BA.ObjectToString(parent._isnavigating),0);
 //BA.debugLineNum = 500;BA.debugLine="If IsNavigating Then Return";
if (true) break;

case 1:
//if
this.state = 6;
if (parent._isnavigating) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
if (true) return ;
if (true) break;

case 6:
//C
this.state = 7;
;
 //BA.debugLineNum = 503;BA.debugLine="If IsNoteGroup And CurrentGroup <> Null And Curre";
if (true) break;

case 7:
//if
this.state = 10;
if (parent._isnotegroup && parent._currentgroup!= null && parent._currentgroup._issecure /*boolean*/ ) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 504;BA.debugLine="ModSession.Touch";
parent._modsession._touch /*String*/ (ba);
 if (true) break;

case 10:
//C
this.state = 11;
;
 //BA.debugLineNum = 508;BA.debugLine="Wait For (xui.Msgbox2Async(ModLang.T(\"note_type_c";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"note_type_choose")),BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"new_note")),parent._modlang._t /*String*/ (ba,"note_type_text"),parent._modlang._t /*String*/ (ba,"cancel"),parent._modlang._t /*String*/ (ba,"note_type_list"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 23;
return;
case 23:
//C
this.state = 11;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 510;BA.debugLine="Dim noteType As String = \"\"";
_notetype = "";
 //BA.debugLineNum = 511;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
if (true) break;

case 11:
//if
this.state = 18;
if (_result==parent._xui.DialogResponse_Positive) { 
this.state = 13;
}else if(_result==parent._xui.DialogResponse_Negative) { 
this.state = 15;
}else {
this.state = 17;
}if (true) break;

case 13:
//C
this.state = 18;
 //BA.debugLineNum = 512;BA.debugLine="noteType = \"text\"";
_notetype = "text";
 if (true) break;

case 15:
//C
this.state = 18;
 //BA.debugLineNum = 514;BA.debugLine="noteType = \"list\"";
_notetype = "list";
 if (true) break;

case 17:
//C
this.state = 18;
 //BA.debugLineNum = 516;BA.debugLine="Return  'Cancelou";
if (true) return ;
 if (true) break;

case 18:
//C
this.state = 19;
;
 //BA.debugLineNum = 519;BA.debugLine="IsNavigating = True";
parent._isnavigating = parent.__c.True;
 //BA.debugLineNum = 521;BA.debugLine="Dim params As Map";
_params = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 522;BA.debugLine="params.Initialize";
_params.Initialize();
 //BA.debugLineNum = 523;BA.debugLine="params.Put(\"noteId\", \"\")";
_params.Put((Object)("noteId"),(Object)(""));
 //BA.debugLineNum = 524;BA.debugLine="params.Put(\"groupId\", CurrentGroupId)";
_params.Put((Object)("groupId"),(Object)(parent._currentgroupid));
 //BA.debugLineNum = 525;BA.debugLine="params.Put(\"isNoteGroup\", IsNoteGroup)";
_params.Put((Object)("isNoteGroup"),(Object)(parent._isnotegroup));
 //BA.debugLineNum = 526;BA.debugLine="params.Put(\"noteType\", noteType)";
_params.Put((Object)("noteType"),(Object)(_notetype));
 //BA.debugLineNum = 527;BA.debugLine="If IsNoteGroup And CurrentGroup <> Null Then";
if (true) break;

case 19:
//if
this.state = 22;
if (parent._isnotegroup && parent._currentgroup!= null) { 
this.state = 21;
}if (true) break;

case 21:
//C
this.state = 22;
 //BA.debugLineNum = 528;BA.debugLine="params.Put(\"isSecure\", CurrentGroup.IsSecure)";
_params.Put((Object)("isSecure"),(Object)(parent._currentgroup._issecure /*boolean*/ ));
 //BA.debugLineNum = 529;BA.debugLine="params.Put(\"passphrase\", GroupPassphrase)";
_params.Put((Object)("passphrase"),(Object)(parent._grouppassphrase));
 //BA.debugLineNum = 530;BA.debugLine="params.Put(\"groupName\", CurrentGroup.Name)";
_params.Put((Object)("groupName"),(Object)(parent._currentgroup._name /*String*/ ));
 if (true) break;

case 22:
//C
this.state = -1;
;
 //BA.debugLineNum = 533;BA.debugLine="Dim pg As PageNoteEdit = B4XPages.GetPage(\"PageNo";
_pg = (com.lockzero.pagenoteedit)(parent._b4xpages._getpage /*Object*/ (ba,"PageNoteEdit"));
 //BA.debugLineNum = 534;BA.debugLine="pg.SetParams(params)";
_pg._setparams /*String*/ (_params);
 //BA.debugLineNum = 535;BA.debugLine="ModTransition.SlideToLeft(Root, pg.Root)";
parent._modtransition._slidetoleft /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (ba,parent._root,_pg._root /*anywheresoftware.b4a.objects.B4XViewWrapper*/ );
 //BA.debugLineNum = 536;BA.debugLine="B4XPages.ShowPage(\"PageNoteEdit\")";
parent._b4xpages._showpage /*String*/ (ba,"PageNoteEdit");
 //BA.debugLineNum = 537;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _msgbox_result(int _result) throws Exception{
}
public String  _lblclearsearch_click() throws Exception{
 //BA.debugLineNum = 491;BA.debugLine="Private Sub lblClearSearch_Click";
 //BA.debugLineNum = 492;BA.debugLine="edtSearch.Text = \"\"";
_edtsearch.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 493;BA.debugLine="lblClearSearch.Visible = False";
_lblclearsearch.setVisible(__c.False);
 //BA.debugLineNum = 494;BA.debugLine="FilterNotes(\"\")";
_filternotes("");
 //BA.debugLineNum = 495;BA.debugLine="End Sub";
return "";
}
public String  _lblsearch_click() throws Exception{
 //BA.debugLineNum = 468;BA.debugLine="Private Sub lblSearch_Click";
 //BA.debugLineNum = 469;BA.debugLine="IsSearchVisible = Not(IsSearchVisible)";
_issearchvisible = __c.Not(_issearchvisible);
 //BA.debugLineNum = 470;BA.debugLine="UpdateSearchVisibility";
_updatesearchvisibility();
 //BA.debugLineNum = 472;BA.debugLine="If IsSearchVisible = False Then";
if (_issearchvisible==__c.False) { 
 //BA.debugLineNum = 474;BA.debugLine="edtSearch.Text = \"\"";
_edtsearch.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 475;BA.debugLine="FilterNotes(\"\")";
_filternotes("");
 };
 //BA.debugLineNum = 477;BA.debugLine="End Sub";
return "";
}
public String  _loadnotes() throws Exception{
com.lockzero.clsnoteentry _n = null;
 //BA.debugLineNum = 200;BA.debugLine="Private Sub LoadNotes";
 //BA.debugLineNum = 202;BA.debugLine="AllNotes = ModNotes.GetNotesByGroup(CurrentGroupI";
_allnotes = _modnotes._getnotesbygroup /*anywheresoftware.b4a.objects.collections.List*/ (ba,_currentgroupid);
 //BA.debugLineNum = 205;BA.debugLine="edtSearch.Text = \"\"";
_edtsearch.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 206;BA.debugLine="FilteredNotes.Initialize";
_filterednotes.Initialize();
 //BA.debugLineNum = 207;BA.debugLine="For Each n As clsNoteEntry In AllNotes";
{
final anywheresoftware.b4a.BA.IterableList group4 = _allnotes;
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_n = (com.lockzero.clsnoteentry)(group4.Get(index4));
 //BA.debugLineNum = 208;BA.debugLine="FilteredNotes.Add(n)";
_filterednotes.Add((Object)(_n));
 }
};
 //BA.debugLineNum = 212;BA.debugLine="IsSearchVisible = False";
_issearchvisible = __c.False;
 //BA.debugLineNum = 213;BA.debugLine="UpdateSearchVisibility";
_updatesearchvisibility();
 //BA.debugLineNum = 215;BA.debugLine="DisplayNotes";
_displaynotes();
 //BA.debugLineNum = 216;BA.debugLine="End Sub";
return "";
}
public String  _opennote(String _noteid) throws Exception{
com.lockzero.clsnoteentry _note = null;
anywheresoftware.b4a.objects.collections.Map _params = null;
com.lockzero.pagenoteedit _pg = null;
 //BA.debugLineNum = 422;BA.debugLine="Private Sub OpenNote(noteId As String)";
 //BA.debugLineNum = 424;BA.debugLine="If IsNavigating Then Return";
if (_isnavigating) { 
if (true) return "";};
 //BA.debugLineNum = 425;BA.debugLine="IsNavigating = True";
_isnavigating = __c.True;
 //BA.debugLineNum = 428;BA.debugLine="If IsNoteGroup And CurrentGroup <> Null And Curre";
if (_isnotegroup && _currentgroup!= null && _currentgroup._issecure /*boolean*/ ) { 
 //BA.debugLineNum = 429;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 };
 //BA.debugLineNum = 432;BA.debugLine="Dim note As clsNoteEntry = ModNotes.GetNoteById(n";
_note = _modnotes._getnotebyid /*com.lockzero.clsnoteentry*/ (ba,_noteid);
 //BA.debugLineNum = 433;BA.debugLine="If note = Null Then";
if (_note== null) { 
 //BA.debugLineNum = 434;BA.debugLine="IsNavigating = False";
_isnavigating = __c.False;
 //BA.debugLineNum = 435;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 438;BA.debugLine="Dim params As Map";
_params = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 439;BA.debugLine="params.Initialize";
_params.Initialize();
 //BA.debugLineNum = 440;BA.debugLine="params.Put(\"noteId\", noteId)";
_params.Put((Object)("noteId"),(Object)(_noteid));
 //BA.debugLineNum = 441;BA.debugLine="params.Put(\"groupId\", CurrentGroupId)";
_params.Put((Object)("groupId"),(Object)(_currentgroupid));
 //BA.debugLineNum = 442;BA.debugLine="params.Put(\"isNoteGroup\", IsNoteGroup)";
_params.Put((Object)("isNoteGroup"),(Object)(_isnotegroup));
 //BA.debugLineNum = 443;BA.debugLine="If IsNoteGroup And CurrentGroup <> Null Then";
if (_isnotegroup && _currentgroup!= null) { 
 //BA.debugLineNum = 444;BA.debugLine="params.Put(\"isSecure\", CurrentGroup.IsSecure)";
_params.Put((Object)("isSecure"),(Object)(_currentgroup._issecure /*boolean*/ ));
 //BA.debugLineNum = 445;BA.debugLine="params.Put(\"passphrase\", GroupPassphrase)";
_params.Put((Object)("passphrase"),(Object)(_grouppassphrase));
 //BA.debugLineNum = 446;BA.debugLine="params.Put(\"groupName\", CurrentGroup.Name)";
_params.Put((Object)("groupName"),(Object)(_currentgroup._name /*String*/ ));
 };
 //BA.debugLineNum = 449;BA.debugLine="If edtSearch.Text.Trim.Length > 0 Then";
if (_edtsearch.getText().trim().length()>0) { 
 //BA.debugLineNum = 450;BA.debugLine="params.Put(\"searchQuery\", edtSearch.Text.Trim)";
_params.Put((Object)("searchQuery"),(Object)(_edtsearch.getText().trim()));
 };
 //BA.debugLineNum = 453;BA.debugLine="Dim pg As PageNoteEdit = B4XPages.GetPage(\"PageNo";
_pg = (com.lockzero.pagenoteedit)(_b4xpages._getpage /*Object*/ (ba,"PageNoteEdit"));
 //BA.debugLineNum = 454;BA.debugLine="pg.SetParams(params)";
_pg._setparams /*String*/ (_params);
 //BA.debugLineNum = 455;BA.debugLine="ModTransition.SlideToLeft(Root, pg.Root)";
_modtransition._slidetoleft /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (ba,_root,_pg._root /*anywheresoftware.b4a.objects.B4XViewWrapper*/ );
 //BA.debugLineNum = 456;BA.debugLine="B4XPages.ShowPage(\"PageNoteEdit\")";
_b4xpages._showpage /*String*/ (ba,"PageNoteEdit");
 //BA.debugLineNum = 457;BA.debugLine="End Sub";
return "";
}
public String  _pnlnote_click() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
String _noteid = "";
 //BA.debugLineNum = 415;BA.debugLine="Private Sub pnlNote_Click";
 //BA.debugLineNum = 416;BA.debugLine="Log(\"pnlNote_Click - IsNavigating=\" & IsNavigatin";
__c.LogImpl("833095681","pnlNote_Click - IsNavigating="+BA.ObjectToString(_isnavigating),0);
 //BA.debugLineNum = 417;BA.debugLine="Dim pnl As Panel = Sender";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
_pnl = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(__c.Sender(ba)));
 //BA.debugLineNum = 418;BA.debugLine="Dim noteId As String = pnl.Tag";
_noteid = BA.ObjectToString(_pnl.getTag());
 //BA.debugLineNum = 419;BA.debugLine="OpenNote(noteId)";
_opennote(_noteid);
 //BA.debugLineNum = 420;BA.debugLine="End Sub";
return "";
}
public String  _setparams(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
 //BA.debugLineNum = 73;BA.debugLine="Public Sub SetParams(params As Map)";
 //BA.debugLineNum = 74;BA.debugLine="If params = Null Then Return";
if (_params== null) { 
if (true) return "";};
 //BA.debugLineNum = 75;BA.debugLine="CurrentGroupId = params.GetDefault(\"groupId\", \"\")";
_currentgroupid = BA.ObjectToString(_params.GetDefault((Object)("groupId"),(Object)("")));
 //BA.debugLineNum = 76;BA.debugLine="IsNoteGroup = params.GetDefault(\"isNoteGroup\", Fa";
_isnotegroup = BA.ObjectToBoolean(_params.GetDefault((Object)("isNoteGroup"),(Object)(__c.False)));
 //BA.debugLineNum = 77;BA.debugLine="GroupPassphrase = params.GetDefault(\"passphrase\",";
_grouppassphrase = BA.ObjectToString(_params.GetDefault((Object)("passphrase"),(Object)("")));
 //BA.debugLineNum = 80;BA.debugLine="If IsNoteGroup Then";
if (_isnotegroup) { 
 //BA.debugLineNum = 81;BA.debugLine="CurrentGroup = ModNotes.GetNoteGroupById(Current";
_currentgroup = _modnotes._getnotegroupbyid /*com.lockzero.clsnotegroup*/ (ba,_currentgroupid);
 }else {
 //BA.debugLineNum = 83;BA.debugLine="CurrentGroup = Null";
_currentgroup = (com.lockzero.clsnotegroup)(__c.Null);
 };
 //BA.debugLineNum = 85;BA.debugLine="End Sub";
return "";
}
public String  _updatesearchvisibility() throws Exception{
int _headerh = 0;
int _searchh = 0;
anywheresoftware.b4a.objects.IME _ime = null;
 //BA.debugLineNum = 301;BA.debugLine="Private Sub UpdateSearchVisibility";
 //BA.debugLineNum = 302;BA.debugLine="Dim headerH As Int = 56dip";
_headerh = __c.DipToCurrent((int) (56));
 //BA.debugLineNum = 303;BA.debugLine="Dim searchH As Int = 54dip";
_searchh = __c.DipToCurrent((int) (54));
 //BA.debugLineNum = 305;BA.debugLine="pnlSearchBar.Visible = IsSearchVisible";
_pnlsearchbar.setVisible(_issearchvisible);
 //BA.debugLineNum = 307;BA.debugLine="If IsSearchVisible Then";
if (_issearchvisible) { 
 //BA.debugLineNum = 308;BA.debugLine="svNotes.Top = headerH + searchH";
_svnotes.setTop((int) (_headerh+_searchh));
 //BA.debugLineNum = 309;BA.debugLine="svNotes.Height = Root.Height - headerH - searchH";
_svnotes.setHeight((int) (_root.getHeight()-_headerh-_searchh));
 //BA.debugLineNum = 310;BA.debugLine="edtSearch.RequestFocus";
_edtsearch.RequestFocus();
 }else {
 //BA.debugLineNum = 312;BA.debugLine="svNotes.Top = headerH";
_svnotes.setTop(_headerh);
 //BA.debugLineNum = 313;BA.debugLine="svNotes.Height = Root.Height - headerH";
_svnotes.setHeight((int) (_root.getHeight()-_headerh));
 //BA.debugLineNum = 315;BA.debugLine="Dim ime As IME";
_ime = new anywheresoftware.b4a.objects.IME();
 //BA.debugLineNum = 316;BA.debugLine="ime.Initialize(\"\")";
_ime.Initialize("");
 //BA.debugLineNum = 317;BA.debugLine="ime.HideKeyboard";
_ime.HideKeyboard(ba);
 };
 //BA.debugLineNum = 319;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
