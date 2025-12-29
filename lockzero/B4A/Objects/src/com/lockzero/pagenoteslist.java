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
public anywheresoftware.b4a.objects.ButtonWrapper _btnadd = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _svnotes = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _pnlnotes = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblempty = null;
public String _currentgroupid = "";
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
public String  _applytheme() throws Exception{
 //BA.debugLineNum = 206;BA.debugLine="Private Sub ApplyTheme";
 //BA.debugLineNum = 207;BA.debugLine="Root.Color = ModTheme.HomeBg";
_root.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 209;BA.debugLine="btnAdd.Color = ModTheme.HomeIconBg";
_btnadd.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 210;BA.debugLine="btnAdd.TextColor = Colors.White";
_btnadd.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 212;BA.debugLine="lblEmpty.TextColor = Colors.ARGB(150, 255, 255, 2";
_lblempty.setTextColor(__c.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 213;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_appear() throws Exception{
 //BA.debugLineNum = 30;BA.debugLine="Private Sub B4XPage_Appear";
 //BA.debugLineNum = 32;BA.debugLine="CallSub2(Main, \"SetPageTitle\", ModLang.T(\"notes\")";
__c.CallSubNew2(ba,(Object)(_main.getObject()),"SetPageTitle",(Object)(_modlang._t /*String*/ (ba,"notes")));
 //BA.debugLineNum = 34;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 35;BA.debugLine="LoadNotes";
_loadnotes();
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
 //BA.debugLineNum = 24;BA.debugLine="Private Sub B4XPage_Created(Root1 As B4XView)";
 //BA.debugLineNum = 25;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 26;BA.debugLine="CreateUI";
_createui();
 //BA.debugLineNum = 27;BA.debugLine="ApplyTheme";
_applytheme();
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return "";
}
public String  _btnadd_click() throws Exception{
com.lockzero.pagenoteedit _pg = null;
 //BA.debugLineNum = 195;BA.debugLine="Private Sub btnAdd_Click";
 //BA.debugLineNum = 196;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 197;BA.debugLine="Dim pg As PageNoteEdit = B4XPages.GetPage(\"PageNo";
_pg = (com.lockzero.pagenoteedit)(_b4xpages._getpage /*Object*/ (ba,"PageNoteEdit"));
 //BA.debugLineNum = 198;BA.debugLine="pg.SetParams(CreateMap(\"noteId\": \"\", \"groupId\": C";
_pg._setparams /*String*/ (__c.createMap(new Object[] {(Object)("noteId"),(Object)(""),(Object)("groupId"),(Object)(_currentgroupid)}));
 //BA.debugLineNum = 199;BA.debugLine="B4XPages.ShowPage(\"PageNoteEdit\")";
_b4xpages._showpage /*String*/ (ba,"PageNoteEdit");
 //BA.debugLineNum = 200;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 4;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Private Root As B4XView";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 6;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 9;BA.debugLine="Private btnAdd As Button";
_btnadd = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 11;BA.debugLine="Private svNotes As ScrollView";
_svnotes = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 12;BA.debugLine="Private pnlNotes As B4XView";
_pnlnotes = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Private lblEmpty As Label";
_lblempty = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private CurrentGroupId As String = \"\"";
_currentgroupid = "";
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.PanelWrapper  _createnotecard(com.lockzero.clsnoteentry _note,int _cardwidth) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xv = null;
String _title = "";
anywheresoftware.b4a.objects.LabelWrapper _lblnotetitle = null;
String _content = "";
anywheresoftware.b4a.objects.LabelWrapper _lblpreview = null;
anywheresoftware.b4a.objects.LabelWrapper _lblstar = null;
 //BA.debugLineNum = 128;BA.debugLine="Private Sub CreateNoteCard(note As clsNoteEntry, c";
 //BA.debugLineNum = 129;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 130;BA.debugLine="pnl.Initialize(\"pnlNote\")";
_pnl.Initialize(ba,"pnlNote");
 //BA.debugLineNum = 133;BA.debugLine="Dim xv As B4XView = pnl";
_xv = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xv = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnl.getObject()));
 //BA.debugLineNum = 134;BA.debugLine="xv.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModT";
_xv.SetColorAndBorder(_modtheme._homeiconbg /*int*/ (ba),(int) (0),_modtheme._homeiconbg /*int*/ (ba),__c.DipToCurrent((int) (12)));
 //BA.debugLineNum = 137;BA.debugLine="Dim title As String = note.GetDecryptedTitle(ModS";
_title = _note._getdecryptedtitle /*String*/ (_modsession._getpassphrase /*String*/ (ba));
 //BA.debugLineNum = 138;BA.debugLine="If title.Length > 30 Then title = title.SubString";
if (_title.length()>30) { 
_title = _title.substring((int) (0),(int) (30))+"...";};
 //BA.debugLineNum = 140;BA.debugLine="Dim lblNoteTitle As Label";
_lblnotetitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 141;BA.debugLine="lblNoteTitle.Initialize(\"\")";
_lblnotetitle.Initialize(ba,"");
 //BA.debugLineNum = 142;BA.debugLine="lblNoteTitle.Text = title";
_lblnotetitle.setText(BA.ObjectToCharSequence(_title));
 //BA.debugLineNum = 143;BA.debugLine="lblNoteTitle.TextSize = 16";
_lblnotetitle.setTextSize((float) (16));
 //BA.debugLineNum = 144;BA.debugLine="lblNoteTitle.TextColor = Colors.White";
_lblnotetitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 145;BA.debugLine="lblNoteTitle.Typeface = Typeface.CreateNew(Typefa";
_lblnotetitle.setTypeface(__c.Typeface.CreateNew(__c.Typeface.DEFAULT,__c.Typeface.STYLE_BOLD));
 //BA.debugLineNum = 146;BA.debugLine="pnl.AddView(lblNoteTitle, 12dip, 10dip, cardWidth";
_pnl.AddView((android.view.View)(_lblnotetitle.getObject()),__c.DipToCurrent((int) (12)),__c.DipToCurrent((int) (10)),(int) (_cardwidth-__c.DipToCurrent((int) (60))),__c.DipToCurrent((int) (25)));
 //BA.debugLineNum = 149;BA.debugLine="Dim content As String = note.GetDecryptedContent(";
_content = _note._getdecryptedcontent /*String*/ (_modsession._getpassphrase /*String*/ (ba));
 //BA.debugLineNum = 150;BA.debugLine="If content.Length > 50 Then content = content.Sub";
if (_content.length()>50) { 
_content = _content.substring((int) (0),(int) (50))+"...";};
 //BA.debugLineNum = 151;BA.debugLine="content = content.Replace(Chr(10), \" \").Replace(C";
_content = _content.replace(BA.ObjectToString(__c.Chr((int) (10)))," ").replace(BA.ObjectToString(__c.Chr((int) (13)))," ");
 //BA.debugLineNum = 153;BA.debugLine="Dim lblPreview As Label";
_lblpreview = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 154;BA.debugLine="lblPreview.Initialize(\"\")";
_lblpreview.Initialize(ba,"");
 //BA.debugLineNum = 155;BA.debugLine="lblPreview.Text = content";
_lblpreview.setText(BA.ObjectToCharSequence(_content));
 //BA.debugLineNum = 156;BA.debugLine="lblPreview.TextSize = 13";
_lblpreview.setTextSize((float) (13));
 //BA.debugLineNum = 157;BA.debugLine="lblPreview.TextColor = Colors.ARGB(180, 255, 255,";
_lblpreview.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 158;BA.debugLine="pnl.AddView(lblPreview, 12dip, 38dip, cardWidth -";
_pnl.AddView((android.view.View)(_lblpreview.getObject()),__c.DipToCurrent((int) (12)),__c.DipToCurrent((int) (38)),(int) (_cardwidth-__c.DipToCurrent((int) (60))),__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 161;BA.debugLine="If note.IsFavorite Then";
if (_note._isfavorite /*boolean*/ ) { 
 //BA.debugLineNum = 162;BA.debugLine="Dim lblStar As Label";
_lblstar = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 163;BA.debugLine="lblStar.Initialize(\"\")";
_lblstar.Initialize(ba,"");
 //BA.debugLineNum = 164;BA.debugLine="lblStar.Text = Chr(9733) '\"★\"";
_lblstar.setText(BA.ObjectToCharSequence(__c.Chr((int) (9733))));
 //BA.debugLineNum = 165;BA.debugLine="lblStar.TextSize = 20";
_lblstar.setTextSize((float) (20));
 //BA.debugLineNum = 166;BA.debugLine="lblStar.TextColor = Colors.RGB(255, 200, 100) 'A";
_lblstar.setTextColor(__c.Colors.RGB((int) (255),(int) (200),(int) (100)));
 //BA.debugLineNum = 167;BA.debugLine="lblStar.Gravity = Gravity.CENTER";
_lblstar.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 168;BA.debugLine="pnl.AddView(lblStar, cardWidth - 40dip, 25dip, 3";
_pnl.AddView((android.view.View)(_lblstar.getObject()),(int) (_cardwidth-__c.DipToCurrent((int) (40))),__c.DipToCurrent((int) (25)),__c.DipToCurrent((int) (30)),__c.DipToCurrent((int) (30)));
 };
 //BA.debugLineNum = 171;BA.debugLine="Return pnl";
if (true) return _pnl;
 //BA.debugLineNum = 172;BA.debugLine="End Sub";
return null;
}
public String  _createui() throws Exception{
int _width = 0;
int _height = 0;
int _headerh = 0;
anywheresoftware.b4a.objects.PanelWrapper _pnlheader = null;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
 //BA.debugLineNum = 48;BA.debugLine="Private Sub CreateUI";
 //BA.debugLineNum = 49;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 50;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 51;BA.debugLine="Dim headerH As Int = 56dip";
_headerh = __c.DipToCurrent((int) (56));
 //BA.debugLineNum = 54;BA.debugLine="Dim pnlHeader As Panel";
_pnlheader = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 55;BA.debugLine="pnlHeader.Initialize(\"\")";
_pnlheader.Initialize(ba,"");
 //BA.debugLineNum = 56;BA.debugLine="pnlHeader.Color = ModTheme.HomeHeaderBg";
_pnlheader.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 57;BA.debugLine="Root.AddView(pnlHeader, 0, 0, width, headerH)";
_root.AddView((android.view.View)(_pnlheader.getObject()),(int) (0),(int) (0),_width,_headerh);
 //BA.debugLineNum = 59;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 60;BA.debugLine="lblTitle.Initialize(\"\")";
_lbltitle.Initialize(ba,"");
 //BA.debugLineNum = 61;BA.debugLine="lblTitle.Text = \"NOTAS\"";
_lbltitle.setText(BA.ObjectToCharSequence("NOTAS"));
 //BA.debugLineNum = 62;BA.debugLine="lblTitle.TextSize = 14";
_lbltitle.setTextSize((float) (14));
 //BA.debugLineNum = 63;BA.debugLine="lblTitle.TextColor = Colors.ARGB(200, 255, 255, 2";
_lbltitle.setTextColor(__c.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 64;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 65;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_VERTICAL";
_lbltitle.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 66;BA.debugLine="pnlHeader.AddView(lblTitle, 16dip, 0, width - 80d";
_pnlheader.AddView((android.view.View)(_lbltitle.getObject()),__c.DipToCurrent((int) (16)),(int) (0),(int) (_width-__c.DipToCurrent((int) (80))),_headerh);
 //BA.debugLineNum = 69;BA.debugLine="btnAdd.Initialize(\"btnAdd\")";
_btnadd.Initialize(ba,"btnAdd");
 //BA.debugLineNum = 70;BA.debugLine="btnAdd.Text = \"+\"";
_btnadd.setText(BA.ObjectToCharSequence("+"));
 //BA.debugLineNum = 71;BA.debugLine="btnAdd.TextSize = 22";
_btnadd.setTextSize((float) (22));
 //BA.debugLineNum = 72;BA.debugLine="btnAdd.Color = ModTheme.HomeIconBg";
_btnadd.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 73;BA.debugLine="btnAdd.TextColor = Colors.White";
_btnadd.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 74;BA.debugLine="btnAdd.Gravity = Gravity.CENTER";
_btnadd.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 75;BA.debugLine="pnlHeader.AddView(btnAdd, width - 54dip, 10dip, 3";
_pnlheader.AddView((android.view.View)(_btnadd.getObject()),(int) (_width-__c.DipToCurrent((int) (54))),__c.DipToCurrent((int) (10)),__c.DipToCurrent((int) (36)),__c.DipToCurrent((int) (36)));
 //BA.debugLineNum = 78;BA.debugLine="svNotes.Initialize(0)";
_svnotes.Initialize(ba,(int) (0));
 //BA.debugLineNum = 79;BA.debugLine="svNotes.Color = ModTheme.HomeBg";
_svnotes.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 80;BA.debugLine="Root.AddView(svNotes, 0, headerH, width, height -";
_root.AddView((android.view.View)(_svnotes.getObject()),(int) (0),_headerh,_width,(int) (_height-_headerh));
 //BA.debugLineNum = 82;BA.debugLine="pnlNotes = svNotes.Panel";
_pnlnotes = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_svnotes.getPanel().getObject()));
 //BA.debugLineNum = 83;BA.debugLine="pnlNotes.Color = ModTheme.HomeBg";
_pnlnotes.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 86;BA.debugLine="lblEmpty.Initialize(\"\")";
_lblempty.Initialize(ba,"");
 //BA.debugLineNum = 87;BA.debugLine="lblEmpty.Text = \"Nenhuma nota neste grupo\"";
_lblempty.setText(BA.ObjectToCharSequence("Nenhuma nota neste grupo"));
 //BA.debugLineNum = 88;BA.debugLine="lblEmpty.TextSize = 16";
_lblempty.setTextSize((float) (16));
 //BA.debugLineNum = 89;BA.debugLine="lblEmpty.Gravity = Gravity.CENTER";
_lblempty.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 90;BA.debugLine="lblEmpty.Visible = False";
_lblempty.setVisible(__c.False);
 //BA.debugLineNum = 91;BA.debugLine="Root.AddView(lblEmpty, 0, height / 2 - 20dip, wid";
_root.AddView((android.view.View)(_lblempty.getObject()),(int) (0),(int) (_height/(double)2-__c.DipToCurrent((int) (20))),_width,__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 92;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 20;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return "";
}
public String  _loadnotes() throws Exception{
anywheresoftware.b4a.objects.collections.List _notes = null;
int _width = 0;
int _y = 0;
int _cardheight = 0;
int _margin = 0;
int _i = 0;
com.lockzero.clsnoteentry _note = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlcard = null;
 //BA.debugLineNum = 98;BA.debugLine="Private Sub LoadNotes";
 //BA.debugLineNum = 100;BA.debugLine="pnlNotes.RemoveAllViews";
_pnlnotes.RemoveAllViews();
 //BA.debugLineNum = 102;BA.debugLine="Dim notes As List = ModNotes.GetNotesByGroup(Curr";
_notes = new anywheresoftware.b4a.objects.collections.List();
_notes = _modnotes._getnotesbygroup /*anywheresoftware.b4a.objects.collections.List*/ (ba,_currentgroupid);
 //BA.debugLineNum = 104;BA.debugLine="If notes.Size = 0 Then";
if (_notes.getSize()==0) { 
 //BA.debugLineNum = 105;BA.debugLine="lblEmpty.Visible = True";
_lblempty.setVisible(__c.True);
 //BA.debugLineNum = 106;BA.debugLine="pnlNotes.Height = 0";
_pnlnotes.setHeight((int) (0));
 //BA.debugLineNum = 107;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 110;BA.debugLine="lblEmpty.Visible = False";
_lblempty.setVisible(__c.False);
 //BA.debugLineNum = 112;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 113;BA.debugLine="Dim y As Int = 10dip";
_y = __c.DipToCurrent((int) (10));
 //BA.debugLineNum = 114;BA.debugLine="Dim cardHeight As Int = 80dip";
_cardheight = __c.DipToCurrent((int) (80));
 //BA.debugLineNum = 115;BA.debugLine="Dim margin As Int = 16dip";
_margin = __c.DipToCurrent((int) (16));
 //BA.debugLineNum = 117;BA.debugLine="For i = 0 To notes.Size - 1";
{
final int step13 = 1;
final int limit13 = (int) (_notes.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit13 ;_i = _i + step13 ) {
 //BA.debugLineNum = 118;BA.debugLine="Dim note As clsNoteEntry = notes.Get(i)";
_note = (com.lockzero.clsnoteentry)(_notes.Get(_i));
 //BA.debugLineNum = 119;BA.debugLine="Dim pnlCard As Panel = CreateNoteCard(note, widt";
_pnlcard = new anywheresoftware.b4a.objects.PanelWrapper();
_pnlcard = _createnotecard(_note,(int) (_width-(_margin*2)));
 //BA.debugLineNum = 120;BA.debugLine="pnlCard.Tag = note.Id";
_pnlcard.setTag((Object)(_note._id /*String*/ ));
 //BA.debugLineNum = 121;BA.debugLine="pnlNotes.AddView(pnlCard, margin, y, width - (ma";
_pnlnotes.AddView((android.view.View)(_pnlcard.getObject()),_margin,_y,(int) (_width-(_margin*2)),_cardheight);
 //BA.debugLineNum = 122;BA.debugLine="y = y + cardHeight + 10dip";
_y = (int) (_y+_cardheight+__c.DipToCurrent((int) (10)));
 }
};
 //BA.debugLineNum = 125;BA.debugLine="pnlNotes.Height = y + 20dip";
_pnlnotes.setHeight((int) (_y+__c.DipToCurrent((int) (20))));
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public String  _opennote(String _noteid) throws Exception{
com.lockzero.clsnoteentry _note = null;
com.lockzero.pagenoteedit _pg = null;
 //BA.debugLineNum = 180;BA.debugLine="Private Sub OpenNote(noteId As String)";
 //BA.debugLineNum = 181;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 183;BA.debugLine="Dim note As clsNoteEntry = ModNotes.GetNoteById(n";
_note = _modnotes._getnotebyid /*com.lockzero.clsnoteentry*/ (ba,_noteid);
 //BA.debugLineNum = 184;BA.debugLine="If note = Null Then Return";
if (_note== null) { 
if (true) return "";};
 //BA.debugLineNum = 186;BA.debugLine="Dim pg As PageNoteEdit = B4XPages.GetPage(\"PageNo";
_pg = (com.lockzero.pagenoteedit)(_b4xpages._getpage /*Object*/ (ba,"PageNoteEdit"));
 //BA.debugLineNum = 187;BA.debugLine="pg.SetParams(CreateMap(\"noteId\": noteId, \"groupId";
_pg._setparams /*String*/ (__c.createMap(new Object[] {(Object)("noteId"),(Object)(_noteid),(Object)("groupId"),(Object)(_currentgroupid)}));
 //BA.debugLineNum = 188;BA.debugLine="B4XPages.ShowPage(\"PageNoteEdit\")";
_b4xpages._showpage /*String*/ (ba,"PageNoteEdit");
 //BA.debugLineNum = 189;BA.debugLine="End Sub";
return "";
}
public String  _pnlnote_click() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
String _noteid = "";
 //BA.debugLineNum = 174;BA.debugLine="Private Sub pnlNote_Click";
 //BA.debugLineNum = 175;BA.debugLine="Dim pnl As Panel = Sender";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
_pnl = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(__c.Sender(ba)));
 //BA.debugLineNum = 176;BA.debugLine="Dim noteId As String = pnl.Tag";
_noteid = BA.ObjectToString(_pnl.getTag());
 //BA.debugLineNum = 177;BA.debugLine="OpenNote(noteId)";
_opennote(_noteid);
 //BA.debugLineNum = 178;BA.debugLine="End Sub";
return "";
}
public String  _setparams(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
 //BA.debugLineNum = 39;BA.debugLine="Public Sub SetParams(params As Map)";
 //BA.debugLineNum = 40;BA.debugLine="If params = Null Then Return";
if (_params== null) { 
if (true) return "";};
 //BA.debugLineNum = 41;BA.debugLine="CurrentGroupId = params.GetDefault(\"groupId\", \"\")";
_currentgroupid = BA.ObjectToString(_params.GetDefault((Object)("groupId"),(Object)("")));
 //BA.debugLineNum = 42;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
