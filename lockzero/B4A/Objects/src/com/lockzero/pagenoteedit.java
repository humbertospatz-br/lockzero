package com.lockzero;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class pagenoteedit extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.lockzero.pagenoteedit");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.lockzero.pagenoteedit.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnback = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblheadertitle = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbliconadd = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _ivicondelete = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _iviconshare = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbliconsave = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _svcontent = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _pnlcontent = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edttitle = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chkfavorite = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtcontent = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnltextmode = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnllistmode = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlitems = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnladdrow = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbladditem = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtfilter = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblclearfilter = null;
public String _currentfilter = "";
public anywheresoftware.b4a.objects.PanelWrapper _pnlinputoverlay = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlinputdialog = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtitemtext = null;
public int _editingitemindex = 0;
public boolean _isrebuildingui = false;
public String _currentnoteid = "";
public String _currentgroupid = "";
public String _currentgroupname = "";
public String _currentnotetitle = "";
public String _notetype = "";
public boolean _isnewnote = false;
public boolean _issecure = false;
public String _passphrase = "";
public anywheresoftware.b4a.objects.collections.List _itemslist = null;
public anywheresoftware.b4a.objects.collections.List _itempanels = null;
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
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
 //BA.debugLineNum = 969;BA.debugLine="Private Sub ApplyTheme";
 //BA.debugLineNum = 970;BA.debugLine="Root.Color = ModTheme.HomeBg";
_root.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 971;BA.debugLine="svContent.Color = ModTheme.HomeBg";
_svcontent.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 972;BA.debugLine="pnlContent.Color = ModTheme.HomeBg";
_pnlcontent.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 975;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 976;BA.debugLine="cd.Initialize2(ModTheme.HomeHeaderBg, 8dip, 1dip,";
_cd.Initialize2(_modtheme._homeheaderbg /*int*/ (ba),__c.DipToCurrent((int) (8)),__c.DipToCurrent((int) (1)),__c.Colors.ARGB((int) (80),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 978;BA.debugLine="edtTitle.Background = cd";
_edttitle.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 //BA.debugLineNum = 979;BA.debugLine="edtTitle.TextColor = Colors.White";
_edttitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 980;BA.debugLine="edtTitle.HintColor = Colors.ARGB(120, 255, 255, 2";
_edttitle.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 982;BA.debugLine="edtContent.Background = cd";
_edtcontent.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 //BA.debugLineNum = 983;BA.debugLine="edtContent.TextColor = Colors.White";
_edtcontent.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 984;BA.debugLine="edtContent.HintColor = Colors.ARGB(120, 255, 255,";
_edtcontent.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 986;BA.debugLine="chkFavorite.TextColor = Colors.White";
_chkfavorite.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 987;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_appear() throws Exception{
String _lastpart = "";
String _breadcrumb = "";
 //BA.debugLineNum = 76;BA.debugLine="Private Sub B4XPage_Appear";
 //BA.debugLineNum = 78;BA.debugLine="Dim lastPart As String";
_lastpart = "";
 //BA.debugLineNum = 79;BA.debugLine="If IsNewNote Then";
if (_isnewnote) { 
 //BA.debugLineNum = 80;BA.debugLine="If NoteType = \"list\" Then";
if ((_notetype).equals("list")) { 
 //BA.debugLineNum = 81;BA.debugLine="lastPart = ModLang.T(\"new_list\")";
_lastpart = _modlang._t /*String*/ (ba,"new_list");
 }else {
 //BA.debugLineNum = 83;BA.debugLine="lastPart = ModLang.T(\"new_text\")";
_lastpart = _modlang._t /*String*/ (ba,"new_text");
 };
 }else {
 //BA.debugLineNum = 87;BA.debugLine="lastPart = CurrentNoteTitle";
_lastpart = _currentnotetitle;
 //BA.debugLineNum = 88;BA.debugLine="If lastPart.Length > 15 Then lastPart = lastPart";
if (_lastpart.length()>15) { 
_lastpart = _lastpart.substring((int) (0),(int) (15))+"...";};
 };
 //BA.debugLineNum = 92;BA.debugLine="Dim breadcrumb As String = ModLang.T(\"notes\") & \"";
_breadcrumb = _modlang._t /*String*/ (ba,"notes")+" → "+_currentgroupname+" → "+_lastpart;
 //BA.debugLineNum = 93;BA.debugLine="lblHeaderTitle.Text = breadcrumb";
_lblheadertitle.setText(BA.ObjectToCharSequence(_breadcrumb));
 //BA.debugLineNum = 94;BA.debugLine="CallSub2(Main, \"SetPageTitle\", lastPart)";
__c.CallSubNew2(ba,(Object)(_main.getObject()),"SetPageTitle",(Object)(_lastpart));
 //BA.debugLineNum = 97;BA.debugLine="If IsSecure Then ModSession.Touch";
if (_issecure) { 
_modsession._touch /*String*/ (ba);};
 //BA.debugLineNum = 98;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
 //BA.debugLineNum = 70;BA.debugLine="Private Sub B4XPage_Created(Root1 As B4XView)";
 //BA.debugLineNum = 71;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 72;BA.debugLine="CreateUI";
_createui();
 //BA.debugLineNum = 73;BA.debugLine="ApplyTheme";
_applytheme();
 //BA.debugLineNum = 74;BA.debugLine="End Sub";
return "";
}
public String  _btnback_click() throws Exception{
 //BA.debugLineNum = 874;BA.debugLine="Private Sub btnBack_Click";
 //BA.debugLineNum = 875;BA.debugLine="B4XPages.ClosePage(Me)";
_b4xpages._closepage /*String*/ (ba,this);
 //BA.debugLineNum = 876;BA.debugLine="End Sub";
return "";
}
public String  _btninputaddmore_click() throws Exception{
String _text = "";
anywheresoftware.b4a.objects.collections.Map _newitem = null;
anywheresoftware.b4a.objects.collections.Map _item = null;
 //BA.debugLineNum = 480;BA.debugLine="Private Sub btnInputAddMore_Click";
 //BA.debugLineNum = 481;BA.debugLine="Dim text As String = edtItemText.Text.Trim";
_text = _edtitemtext.getText().trim();
 //BA.debugLineNum = 482;BA.debugLine="If text.Length = 0 Then";
if (_text.length()==0) { 
 //BA.debugLineNum = 483;BA.debugLine="ToastMessageShow(ModLang.T(\"error_empty_field\"),";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error_empty_field")),__c.True);
 //BA.debugLineNum = 484;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 487;BA.debugLine="If EditingItemIndex = -1 Then";
if (_editingitemindex==-1) { 
 //BA.debugLineNum = 489;BA.debugLine="Dim newItem As Map";
_newitem = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 490;BA.debugLine="newItem.Initialize";
_newitem.Initialize();
 //BA.debugLineNum = 491;BA.debugLine="newItem.Put(\"text\", text)";
_newitem.Put((Object)("text"),(Object)(_text));
 //BA.debugLineNum = 492;BA.debugLine="newItem.Put(\"checked\", False)";
_newitem.Put((Object)("checked"),(Object)(__c.False));
 //BA.debugLineNum = 493;BA.debugLine="ItemsList.Add(newItem)";
_itemslist.Add((Object)(_newitem.getObject()));
 }else {
 //BA.debugLineNum = 496;BA.debugLine="If EditingItemIndex >= 0 And EditingItemIndex <";
if (_editingitemindex>=0 && _editingitemindex<_itemslist.getSize()) { 
 //BA.debugLineNum = 497;BA.debugLine="Dim item As Map = ItemsList.Get(EditingItemInde";
_item = new anywheresoftware.b4a.objects.collections.Map();
_item = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_itemslist.Get(_editingitemindex)));
 //BA.debugLineNum = 498;BA.debugLine="item.Put(\"text\", text)";
_item.Put((Object)("text"),(Object)(_text));
 };
 };
 //BA.debugLineNum = 502;BA.debugLine="RebuildItemsUI";
_rebuilditemsui();
 //BA.debugLineNum = 505;BA.debugLine="edtItemText.Text = \"\"";
_edtitemtext.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 506;BA.debugLine="EditingItemIndex = -1  'Proximo sera novo item";
_editingitemindex = (int) (-1);
 //BA.debugLineNum = 507;BA.debugLine="edtItemText.RequestFocus";
_edtitemtext.RequestFocus();
 //BA.debugLineNum = 508;BA.debugLine="End Sub";
return "";
}
public String  _btninputcancel_click() throws Exception{
 //BA.debugLineNum = 475;BA.debugLine="Private Sub btnInputCancel_Click";
 //BA.debugLineNum = 476;BA.debugLine="HideInputDialog";
_hideinputdialog();
 //BA.debugLineNum = 477;BA.debugLine="End Sub";
return "";
}
public String  _btninputsaveexit_click() throws Exception{
String _text = "";
anywheresoftware.b4a.objects.collections.Map _newitem = null;
anywheresoftware.b4a.objects.collections.Map _item = null;
 //BA.debugLineNum = 511;BA.debugLine="Private Sub btnInputSaveExit_Click";
 //BA.debugLineNum = 512;BA.debugLine="Dim text As String = edtItemText.Text.Trim";
_text = _edtitemtext.getText().trim();
 //BA.debugLineNum = 513;BA.debugLine="If text.Length = 0 Then";
if (_text.length()==0) { 
 //BA.debugLineNum = 514;BA.debugLine="ToastMessageShow(ModLang.T(\"error_empty_field\"),";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error_empty_field")),__c.True);
 //BA.debugLineNum = 515;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 518;BA.debugLine="If EditingItemIndex = -1 Then";
if (_editingitemindex==-1) { 
 //BA.debugLineNum = 520;BA.debugLine="Dim newItem As Map";
_newitem = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 521;BA.debugLine="newItem.Initialize";
_newitem.Initialize();
 //BA.debugLineNum = 522;BA.debugLine="newItem.Put(\"text\", text)";
_newitem.Put((Object)("text"),(Object)(_text));
 //BA.debugLineNum = 523;BA.debugLine="newItem.Put(\"checked\", False)";
_newitem.Put((Object)("checked"),(Object)(__c.False));
 //BA.debugLineNum = 524;BA.debugLine="ItemsList.Add(newItem)";
_itemslist.Add((Object)(_newitem.getObject()));
 }else {
 //BA.debugLineNum = 527;BA.debugLine="If EditingItemIndex >= 0 And EditingItemIndex <";
if (_editingitemindex>=0 && _editingitemindex<_itemslist.getSize()) { 
 //BA.debugLineNum = 528;BA.debugLine="Dim item As Map = ItemsList.Get(EditingItemInde";
_item = new anywheresoftware.b4a.objects.collections.Map();
_item = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_itemslist.Get(_editingitemindex)));
 //BA.debugLineNum = 529;BA.debugLine="item.Put(\"text\", text)";
_item.Put((Object)("text"),(Object)(_text));
 };
 };
 //BA.debugLineNum = 533;BA.debugLine="HideInputDialog";
_hideinputdialog();
 //BA.debugLineNum = 534;BA.debugLine="RebuildItemsUI";
_rebuilditemsui();
 //BA.debugLineNum = 535;BA.debugLine="End Sub";
return "";
}
public void  _chkitem_checkedchange(boolean _checked) throws Exception{
ResumableSub_chkItem_CheckedChange rsub = new ResumableSub_chkItem_CheckedChange(this,_checked);
rsub.resume(ba, null);
}
public static class ResumableSub_chkItem_CheckedChange extends BA.ResumableSub {
public ResumableSub_chkItem_CheckedChange(com.lockzero.pagenoteedit parent,boolean _checked) {
this.parent = parent;
this._checked = _checked;
}
com.lockzero.pagenoteedit parent;
boolean _checked;
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chk = null;
int _index = 0;
anywheresoftware.b4a.objects.collections.Map _item = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 627;BA.debugLine="If IsRebuildingUI Then Return";
if (true) break;

case 1:
//if
this.state = 6;
if (parent._isrebuildingui) { 
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
 //BA.debugLineNum = 629;BA.debugLine="Dim chk As CheckBox = Sender";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
_chk = (anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper(), (android.widget.CheckBox)(parent.__c.Sender(ba)));
 //BA.debugLineNum = 630;BA.debugLine="Dim index As Int = chk.Tag";
_index = (int)(BA.ObjectToNumber(_chk.getTag()));
 //BA.debugLineNum = 632;BA.debugLine="If index >= 0 And index < ItemsList.Size Then";
if (true) break;

case 7:
//if
this.state = 10;
if (_index>=0 && _index<parent._itemslist.getSize()) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 633;BA.debugLine="Dim item As Map = ItemsList.Get(index)";
_item = new anywheresoftware.b4a.objects.collections.Map();
_item = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(parent._itemslist.Get(_index)));
 //BA.debugLineNum = 634;BA.debugLine="item.Put(\"checked\", Checked)";
_item.Put((Object)("checked"),(Object)(_checked));
 //BA.debugLineNum = 637;BA.debugLine="Sleep(300)";
parent.__c.Sleep(ba,this,(int) (300));
this.state = 11;
return;
case 11:
//C
this.state = 10;
;
 //BA.debugLineNum = 638;BA.debugLine="SortItemsCheckedFirst";
parent._sortitemscheckedfirst();
 //BA.debugLineNum = 639;BA.debugLine="RebuildItemsUI";
parent._rebuilditemsui();
 if (true) break;

case 10:
//C
this.state = -1;
;
 //BA.debugLineNum = 641;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 8;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Public Root As B4XView  'Public para transicoes";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 10;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 13;BA.debugLine="Private btnBack As Button";
_btnback = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Private lblHeaderTitle As Label";
_lblheadertitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private lblIconAdd As Label     '+ Adicionar item";
_lbliconadd = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private ivIconDelete As ImageView  'Lixeira - exc";
_ivicondelete = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private ivIconShare As ImageView   'Compartilhar";
_iviconshare = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private lblIconSave As Label    'Salvar";
_lbliconsave = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private svContent As ScrollView";
_svcontent = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private pnlContent As B4XView";
_pnlcontent = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private edtTitle As EditText";
_edttitle = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private chkFavorite As CheckBox";
_chkfavorite = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private edtContent As EditText";
_edtcontent = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Private pnlTextMode As Panel";
_pnltextmode = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private pnlListMode As Panel";
_pnllistmode = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private pnlItems As Panel";
_pnlitems = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private pnlAddRow As Panel  'Container do botao +";
_pnladdrow = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private lblAddItem As Label";
_lbladditem = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Private edtFilter As EditText  'Campo de filtro";
_edtfilter = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private lblClearFilter As Label  'Botao X para li";
_lblclearfilter = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Private CurrentFilter As String = \"\"  'Texto atua";
_currentfilter = "";
 //BA.debugLineNum = 44;BA.debugLine="Private pnlInputOverlay As Panel";
_pnlinputoverlay = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private pnlInputDialog As Panel";
_pnlinputdialog = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private edtItemText As EditText";
_edtitemtext = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Private EditingItemIndex As Int = -1  '-1 = novo";
_editingitemindex = (int) (-1);
 //BA.debugLineNum = 48;BA.debugLine="Private IsRebuildingUI As Boolean = False  'Flag";
_isrebuildingui = __c.False;
 //BA.debugLineNum = 51;BA.debugLine="Private CurrentNoteId As String = \"\"";
_currentnoteid = "";
 //BA.debugLineNum = 52;BA.debugLine="Private CurrentGroupId As String = \"\"";
_currentgroupid = "";
 //BA.debugLineNum = 53;BA.debugLine="Private CurrentGroupName As String = \"\"  'Nome do";
_currentgroupname = "";
 //BA.debugLineNum = 54;BA.debugLine="Private CurrentNoteTitle As String = \"\"  'Titulo";
_currentnotetitle = "";
 //BA.debugLineNum = 55;BA.debugLine="Private NoteType As String = \"text\"";
_notetype = "text";
 //BA.debugLineNum = 56;BA.debugLine="Private IsNewNote As Boolean = True";
_isnewnote = __c.True;
 //BA.debugLineNum = 57;BA.debugLine="Private IsSecure As Boolean = True";
_issecure = __c.True;
 //BA.debugLineNum = 58;BA.debugLine="Private Passphrase As String = \"\"";
_passphrase = "";
 //BA.debugLineNum = 61;BA.debugLine="Private ItemsList As List";
_itemslist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 62;BA.debugLine="Private ItemPanels As List  'Paineis dos itens na";
_itempanels = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 63;BA.debugLine="End Sub";
return "";
}
public String  _createcommonfields() throws Exception{
int _width = 0;
int _margin = 0;
int _fieldwidth = 0;
int _y = 0;
 //BA.debugLineNum = 227;BA.debugLine="Private Sub CreateCommonFields";
 //BA.debugLineNum = 228;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 229;BA.debugLine="Dim margin As Int = 16dip";
_margin = __c.DipToCurrent((int) (16));
 //BA.debugLineNum = 230;BA.debugLine="Dim fieldWidth As Int = width - (margin * 2)";
_fieldwidth = (int) (_width-(_margin*2));
 //BA.debugLineNum = 231;BA.debugLine="Dim y As Int = 10dip";
_y = __c.DipToCurrent((int) (10));
 //BA.debugLineNum = 234;BA.debugLine="edtTitle.Initialize(\"edtTitle\")";
_edttitle.Initialize(ba,"edtTitle");
 //BA.debugLineNum = 235;BA.debugLine="edtTitle.Hint = ModLang.T(\"title_hint\")";
_edttitle.setHint(_modlang._t /*String*/ (ba,"title_hint"));
 //BA.debugLineNum = 236;BA.debugLine="edtTitle.SingleLine = True";
_edttitle.setSingleLine(__c.True);
 //BA.debugLineNum = 237;BA.debugLine="edtTitle.TextSize = Starter.FONT_BODY";
_edttitle.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 238;BA.debugLine="edtTitle.InputType = Bit.Or(1, 8192)";
_edttitle.setInputType(__c.Bit.Or((int) (1),(int) (8192)));
 //BA.debugLineNum = 239;BA.debugLine="pnlContent.AddView(edtTitle, margin, y, fieldWidt";
_pnlcontent.AddView((android.view.View)(_edttitle.getObject()),_margin,_y,(int) (_fieldwidth-__c.DipToCurrent((int) (60))),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 242;BA.debugLine="chkFavorite.Initialize(\"chkFavorite\")";
_chkfavorite.Initialize(ba,"chkFavorite");
 //BA.debugLineNum = 243;BA.debugLine="chkFavorite.Text = Chr(9734)  'Estrela vazia ☆";
_chkfavorite.setText(BA.ObjectToCharSequence(__c.Chr((int) (9734))));
 //BA.debugLineNum = 244;BA.debugLine="chkFavorite.TextSize = 24";
_chkfavorite.setTextSize((float) (24));
 //BA.debugLineNum = 245;BA.debugLine="chkFavorite.TextColor = Colors.ARGB(180, 255, 255";
_chkfavorite.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 246;BA.debugLine="pnlContent.AddView(chkFavorite, fieldWidth - 30di";
_pnlcontent.AddView((android.view.View)(_chkfavorite.getObject()),(int) (_fieldwidth-__c.DipToCurrent((int) (30))),(int) (_y+__c.DipToCurrent((int) (10))),__c.DipToCurrent((int) (50)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 247;BA.debugLine="y = y + 55dip";
_y = (int) (_y+__c.DipToCurrent((int) (55)));
 //BA.debugLineNum = 248;BA.debugLine="End Sub";
return "";
}
public String  _createiconbar(anywheresoftware.b4a.objects.PanelWrapper _pnliconbar,int _width) throws Exception{
int _iconsize = 0;
int _spacing = 0;
int _startx = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _xvadd = null;
 //BA.debugLineNum = 190;BA.debugLine="Private Sub CreateIconBar(pnlIconBar As Panel, wid";
 //BA.debugLineNum = 191;BA.debugLine="Dim iconSize As Int = 44dip";
_iconsize = __c.DipToCurrent((int) (44));
 //BA.debugLineNum = 192;BA.debugLine="Dim spacing As Int = 8dip";
_spacing = __c.DipToCurrent((int) (8));
 //BA.debugLineNum = 193;BA.debugLine="Dim startX As Int = width - (iconSize * 4) - (spa";
_startx = (int) (_width-(_iconsize*4)-(_spacing*3)-__c.DipToCurrent((int) (16)));
 //BA.debugLineNum = 196;BA.debugLine="lblIconAdd.Initialize(\"lblIconAdd\")";
_lbliconadd.Initialize(ba,"lblIconAdd");
 //BA.debugLineNum = 197;BA.debugLine="lblIconAdd.Text = \"+\"";
_lbliconadd.setText(BA.ObjectToCharSequence("+"));
 //BA.debugLineNum = 198;BA.debugLine="lblIconAdd.TextSize = 24";
_lbliconadd.setTextSize((float) (24));
 //BA.debugLineNum = 199;BA.debugLine="lblIconAdd.TextColor = Colors.White";
_lbliconadd.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 200;BA.debugLine="lblIconAdd.Gravity = Gravity.CENTER";
_lbliconadd.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 201;BA.debugLine="pnlIconBar.AddView(lblIconAdd, startX, 3dip, icon";
_pnliconbar.AddView((android.view.View)(_lbliconadd.getObject()),_startx,__c.DipToCurrent((int) (3)),_iconsize,_iconsize);
 //BA.debugLineNum = 202;BA.debugLine="Dim xvAdd As B4XView = lblIconAdd";
_xvadd = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvadd = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbliconadd.getObject()));
 //BA.debugLineNum = 203;BA.debugLine="xvAdd.SetColorAndBorder(ModTheme.HomeIconBg, 0, M";
_xvadd.SetColorAndBorder(_modtheme._homeiconbg /*int*/ (ba),(int) (0),_modtheme._homeiconbg /*int*/ (ba),__c.DipToCurrent((int) (22)));
 //BA.debugLineNum = 206;BA.debugLine="ivIconDelete.Initialize(\"ivIconDelete\")";
_ivicondelete.Initialize(ba,"ivIconDelete");
 //BA.debugLineNum = 207;BA.debugLine="ivIconDelete.Gravity = Gravity.CENTER";
_ivicondelete.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 208;BA.debugLine="ivIconDelete.Visible = False  'So aparece ao edit";
_ivicondelete.setVisible(__c.False);
 //BA.debugLineNum = 209;BA.debugLine="pnlIconBar.AddView(ivIconDelete, startX + iconSiz";
_pnliconbar.AddView((android.view.View)(_ivicondelete.getObject()),(int) (_startx+_iconsize+_spacing),__c.DipToCurrent((int) (3)),_iconsize,_iconsize);
 //BA.debugLineNum = 210;BA.debugLine="SetAndroidIcon(ivIconDelete, \"ic_menu_delete\")";
_setandroidicon(_ivicondelete,"ic_menu_delete");
 //BA.debugLineNum = 213;BA.debugLine="ivIconShare.Initialize(\"ivIconShare\")";
_iviconshare.Initialize(ba,"ivIconShare");
 //BA.debugLineNum = 214;BA.debugLine="ivIconShare.Gravity = Gravity.CENTER";
_iviconshare.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 215;BA.debugLine="pnlIconBar.AddView(ivIconShare, startX + (iconSiz";
_pnliconbar.AddView((android.view.View)(_iviconshare.getObject()),(int) (_startx+(_iconsize+_spacing)*2),__c.DipToCurrent((int) (3)),_iconsize,_iconsize);
 //BA.debugLineNum = 216;BA.debugLine="SetAndroidIcon(ivIconShare, \"ic_menu_share\")";
_setandroidicon(_iviconshare,"ic_menu_share");
 //BA.debugLineNum = 219;BA.debugLine="lblIconSave.Initialize(\"lblIconSave\")";
_lbliconsave.Initialize(ba,"lblIconSave");
 //BA.debugLineNum = 220;BA.debugLine="lblIconSave.Text = Chr(0x2713)  'Check ✓";
_lbliconsave.setText(BA.ObjectToCharSequence(__c.Chr(((int)0x2713))));
 //BA.debugLineNum = 221;BA.debugLine="lblIconSave.TextSize = 22";
_lbliconsave.setTextSize((float) (22));
 //BA.debugLineNum = 222;BA.debugLine="lblIconSave.TextColor = Colors.RGB(100, 200, 100)";
_lbliconsave.setTextColor(__c.Colors.RGB((int) (100),(int) (200),(int) (100)));
 //BA.debugLineNum = 223;BA.debugLine="lblIconSave.Gravity = Gravity.CENTER";
_lbliconsave.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 224;BA.debugLine="pnlIconBar.AddView(lblIconSave, startX + (iconSiz";
_pnliconbar.AddView((android.view.View)(_lbliconsave.getObject()),(int) (_startx+(_iconsize+_spacing)*3),__c.DipToCurrent((int) (3)),_iconsize,_iconsize);
 //BA.debugLineNum = 225;BA.debugLine="End Sub";
return "";
}
public String  _createinputdialog() throws Exception{
int _width = 0;
int _height = 0;
int _dialogw = 0;
int _dialogh = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _xvdialog = null;
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlinput = null;
int _btnsize = 0;
int _btnspacing = 0;
int _totalbtnswidth = 0;
int _startx = 0;
anywheresoftware.b4a.objects.LabelWrapper _btninputcancel = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xvcancel = null;
anywheresoftware.b4a.objects.LabelWrapper _btninputaddmore = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xvaddmore = null;
anywheresoftware.b4a.objects.LabelWrapper _btninputsaveexit = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xvsaveexit = null;
 //BA.debugLineNum = 359;BA.debugLine="Private Sub CreateInputDialog";
 //BA.debugLineNum = 360;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 361;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 364;BA.debugLine="pnlInputOverlay.Initialize(\"pnlInputOverlay\")";
_pnlinputoverlay.Initialize(ba,"pnlInputOverlay");
 //BA.debugLineNum = 365;BA.debugLine="pnlInputOverlay.Color = Colors.ARGB(180, 0, 0, 0)";
_pnlinputoverlay.setColor(__c.Colors.ARGB((int) (180),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 366;BA.debugLine="pnlInputOverlay.Visible = False";
_pnlinputoverlay.setVisible(__c.False);
 //BA.debugLineNum = 367;BA.debugLine="Root.AddView(pnlInputOverlay, 0, 0, width, height";
_root.AddView((android.view.View)(_pnlinputoverlay.getObject()),(int) (0),(int) (0),_width,_height);
 //BA.debugLineNum = 370;BA.debugLine="Dim dialogW As Int = width - 40dip";
_dialogw = (int) (_width-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 371;BA.debugLine="Dim dialogH As Int = 180dip";
_dialogh = __c.DipToCurrent((int) (180));
 //BA.debugLineNum = 373;BA.debugLine="pnlInputDialog.Initialize(\"\")";
_pnlinputdialog.Initialize(ba,"");
 //BA.debugLineNum = 374;BA.debugLine="pnlInputDialog.Color = ModTheme.HomeHeaderBg";
_pnlinputdialog.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 375;BA.debugLine="pnlInputOverlay.AddView(pnlInputDialog, 20dip, 80";
_pnlinputoverlay.AddView((android.view.View)(_pnlinputdialog.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (80)),_dialogw,_dialogh);
 //BA.debugLineNum = 378;BA.debugLine="Dim xvDialog As B4XView = pnlInputDialog";
_xvdialog = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvdialog = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnlinputdialog.getObject()));
 //BA.debugLineNum = 379;BA.debugLine="xvDialog.SetColorAndBorder(ModTheme.HomeHeaderBg,";
_xvdialog.SetColorAndBorder(_modtheme._homeheaderbg /*int*/ (ba),(int) (0),_modtheme._homeheaderbg /*int*/ (ba),__c.DipToCurrent((int) (12)));
 //BA.debugLineNum = 382;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 383;BA.debugLine="lblTitle.Initialize(\"lblInputTitle\")";
_lbltitle.Initialize(ba,"lblInputTitle");
 //BA.debugLineNum = 384;BA.debugLine="lblTitle.Text = ModLang.T(\"note_add_item\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"note_add_item")));
 //BA.debugLineNum = 385;BA.debugLine="lblTitle.TextSize = Starter.FONT_BODY";
_lbltitle.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 386;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 387;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 388;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 389;BA.debugLine="pnlInputDialog.AddView(lblTitle, 0, 12dip, dialog";
_pnlinputdialog.AddView((android.view.View)(_lbltitle.getObject()),(int) (0),__c.DipToCurrent((int) (12)),_dialogw,__c.DipToCurrent((int) (24)));
 //BA.debugLineNum = 392;BA.debugLine="edtItemText.Initialize(\"edtItemText\")";
_edtitemtext.Initialize(ba,"edtItemText");
 //BA.debugLineNum = 393;BA.debugLine="edtItemText.Hint = ModLang.T(\"item_hint\")  'Hint";
_edtitemtext.setHint(_modlang._t /*String*/ (ba,"item_hint"));
 //BA.debugLineNum = 394;BA.debugLine="edtItemText.SingleLine = True";
_edtitemtext.setSingleLine(__c.True);
 //BA.debugLineNum = 395;BA.debugLine="edtItemText.InputType = Bit.Or(1, 8192)  'TEXT +";
_edtitemtext.setInputType(__c.Bit.Or((int) (1),(int) (8192)));
 //BA.debugLineNum = 396;BA.debugLine="edtItemText.TextSize = Starter.FONT_BODY";
_edtitemtext.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 397;BA.debugLine="edtItemText.TextColor = Colors.White";
_edtitemtext.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 398;BA.debugLine="edtItemText.HintColor = Colors.ARGB(120, 255, 255";
_edtitemtext.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 400;BA.debugLine="Dim pnlInput As Panel";
_pnlinput = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 401;BA.debugLine="pnlInput.Initialize(\"\")";
_pnlinput.Initialize(ba,"");
 //BA.debugLineNum = 402;BA.debugLine="pnlInput.Color = ModTheme.HomeBg";
_pnlinput.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 403;BA.debugLine="pnlInputDialog.AddView(pnlInput, 16dip, 45dip, di";
_pnlinputdialog.AddView((android.view.View)(_pnlinput.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (45)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 404;BA.debugLine="pnlInput.AddView(edtItemText, 8dip, 5dip, dialogW";
_pnlinput.AddView((android.view.View)(_edtitemtext.getObject()),__c.DipToCurrent((int) (8)),__c.DipToCurrent((int) (5)),(int) (_dialogw-__c.DipToCurrent((int) (48))),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 407;BA.debugLine="Dim btnSize As Int = 50dip";
_btnsize = __c.DipToCurrent((int) (50));
 //BA.debugLineNum = 408;BA.debugLine="Dim btnSpacing As Int = 20dip";
_btnspacing = __c.DipToCurrent((int) (20));
 //BA.debugLineNum = 409;BA.debugLine="Dim totalBtnsWidth As Int = (btnSize * 3) + (btnS";
_totalbtnswidth = (int) ((_btnsize*3)+(_btnspacing*2));
 //BA.debugLineNum = 410;BA.debugLine="Dim startX As Int = (dialogW - totalBtnsWidth) /";
_startx = (int) ((_dialogw-_totalbtnswidth)/(double)2);
 //BA.debugLineNum = 413;BA.debugLine="Dim btnInputCancel As Label";
_btninputcancel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 414;BA.debugLine="btnInputCancel.Initialize(\"btnInputCancel\")";
_btninputcancel.Initialize(ba,"btnInputCancel");
 //BA.debugLineNum = 415;BA.debugLine="btnInputCancel.Text = \"X\"";
_btninputcancel.setText(BA.ObjectToCharSequence("X"));
 //BA.debugLineNum = 416;BA.debugLine="btnInputCancel.TextSize = 22";
_btninputcancel.setTextSize((float) (22));
 //BA.debugLineNum = 417;BA.debugLine="btnInputCancel.TextColor = Colors.RGB(255, 100, 1";
_btninputcancel.setTextColor(__c.Colors.RGB((int) (255),(int) (100),(int) (100)));
 //BA.debugLineNum = 418;BA.debugLine="btnInputCancel.Gravity = Gravity.CENTER";
_btninputcancel.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 419;BA.debugLine="pnlInputDialog.AddView(btnInputCancel, startX, 11";
_pnlinputdialog.AddView((android.view.View)(_btninputcancel.getObject()),_startx,__c.DipToCurrent((int) (115)),_btnsize,_btnsize);
 //BA.debugLineNum = 420;BA.debugLine="Dim xvCancel As B4XView = btnInputCancel";
_xvcancel = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvcancel = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_btninputcancel.getObject()));
 //BA.debugLineNum = 421;BA.debugLine="xvCancel.SetColorAndBorder(ModTheme.HomeBg, 1dip,";
_xvcancel.SetColorAndBorder(_modtheme._homebg /*int*/ (ba),__c.DipToCurrent((int) (1)),__c.Colors.RGB((int) (255),(int) (100),(int) (100)),__c.DipToCurrent((int) (25)));
 //BA.debugLineNum = 424;BA.debugLine="Dim btnInputAddMore As Label";
_btninputaddmore = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 425;BA.debugLine="btnInputAddMore.Initialize(\"btnInputAddMore\")";
_btninputaddmore.Initialize(ba,"btnInputAddMore");
 //BA.debugLineNum = 426;BA.debugLine="btnInputAddMore.Text = \"+\"";
_btninputaddmore.setText(BA.ObjectToCharSequence("+"));
 //BA.debugLineNum = 427;BA.debugLine="btnInputAddMore.TextSize = 26";
_btninputaddmore.setTextSize((float) (26));
 //BA.debugLineNum = 428;BA.debugLine="btnInputAddMore.TextColor = Colors.RGB(255, 200,";
_btninputaddmore.setTextColor(__c.Colors.RGB((int) (255),(int) (200),(int) (100)));
 //BA.debugLineNum = 429;BA.debugLine="btnInputAddMore.Gravity = Gravity.CENTER";
_btninputaddmore.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 430;BA.debugLine="pnlInputDialog.AddView(btnInputAddMore, startX +";
_pnlinputdialog.AddView((android.view.View)(_btninputaddmore.getObject()),(int) (_startx+_btnsize+_btnspacing),__c.DipToCurrent((int) (115)),_btnsize,_btnsize);
 //BA.debugLineNum = 431;BA.debugLine="Dim xvAddMore As B4XView = btnInputAddMore";
_xvaddmore = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvaddmore = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_btninputaddmore.getObject()));
 //BA.debugLineNum = 432;BA.debugLine="xvAddMore.SetColorAndBorder(ModTheme.HomeBg, 1dip";
_xvaddmore.SetColorAndBorder(_modtheme._homebg /*int*/ (ba),__c.DipToCurrent((int) (1)),__c.Colors.RGB((int) (255),(int) (200),(int) (100)),__c.DipToCurrent((int) (25)));
 //BA.debugLineNum = 435;BA.debugLine="Dim btnInputSaveExit As Label";
_btninputsaveexit = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 436;BA.debugLine="btnInputSaveExit.Initialize(\"btnInputSaveExit\")";
_btninputsaveexit.Initialize(ba,"btnInputSaveExit");
 //BA.debugLineNum = 437;BA.debugLine="btnInputSaveExit.Text = Chr(0x2713)  '✓";
_btninputsaveexit.setText(BA.ObjectToCharSequence(__c.Chr(((int)0x2713))));
 //BA.debugLineNum = 438;BA.debugLine="btnInputSaveExit.TextSize = 22";
_btninputsaveexit.setTextSize((float) (22));
 //BA.debugLineNum = 439;BA.debugLine="btnInputSaveExit.TextColor = Colors.RGB(100, 200,";
_btninputsaveexit.setTextColor(__c.Colors.RGB((int) (100),(int) (200),(int) (100)));
 //BA.debugLineNum = 440;BA.debugLine="btnInputSaveExit.Gravity = Gravity.CENTER";
_btninputsaveexit.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 441;BA.debugLine="pnlInputDialog.AddView(btnInputSaveExit, startX +";
_pnlinputdialog.AddView((android.view.View)(_btninputsaveexit.getObject()),(int) (_startx+(_btnsize+_btnspacing)*2),__c.DipToCurrent((int) (115)),_btnsize,_btnsize);
 //BA.debugLineNum = 442;BA.debugLine="Dim xvSaveExit As B4XView = btnInputSaveExit";
_xvsaveexit = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvsaveexit = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_btninputsaveexit.getObject()));
 //BA.debugLineNum = 443;BA.debugLine="xvSaveExit.SetColorAndBorder(ModTheme.HomeBg, 1di";
_xvsaveexit.SetColorAndBorder(_modtheme._homebg /*int*/ (ba),__c.DipToCurrent((int) (1)),__c.Colors.RGB((int) (100),(int) (200),(int) (100)),__c.DipToCurrent((int) (25)));
 //BA.debugLineNum = 444;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.PanelWrapper  _createitempanel(int _index,anywheresoftware.b4a.objects.collections.Map _item,int _panelwidth) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xv = null;
String _text = "";
boolean _checked = false;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chk = null;
 //BA.debugLineNum = 583;BA.debugLine="Private Sub CreateItemPanel(index As Int, item As";
 //BA.debugLineNum = 584;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 585;BA.debugLine="pnl.Initialize(\"pnlItem\")";
_pnl.Initialize(ba,"pnlItem");
 //BA.debugLineNum = 586;BA.debugLine="pnl.Tag = index";
_pnl.setTag((Object)(_index));
 //BA.debugLineNum = 588;BA.debugLine="Dim xv As B4XView = pnl";
_xv = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xv = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnl.getObject()));
 //BA.debugLineNum = 589;BA.debugLine="xv.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModT";
_xv.SetColorAndBorder(_modtheme._homeiconbg /*int*/ (ba),(int) (0),_modtheme._homeiconbg /*int*/ (ba),__c.DipToCurrent((int) (8)));
 //BA.debugLineNum = 591;BA.debugLine="Dim text As String = item.GetDefault(\"text\", \"\")";
_text = BA.ObjectToString(_item.GetDefault((Object)("text"),(Object)("")));
 //BA.debugLineNum = 592;BA.debugLine="Dim checked As Boolean = item.GetDefault(\"checked";
_checked = BA.ObjectToBoolean(_item.GetDefault((Object)("checked"),(Object)(__c.False)));
 //BA.debugLineNum = 595;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 596;BA.debugLine="lbl.Initialize(\"lblItem\")";
_lbl.Initialize(ba,"lblItem");
 //BA.debugLineNum = 597;BA.debugLine="lbl.Tag = index";
_lbl.setTag((Object)(_index));
 //BA.debugLineNum = 598;BA.debugLine="lbl.Text = text";
_lbl.setText(BA.ObjectToCharSequence(_text));
 //BA.debugLineNum = 599;BA.debugLine="lbl.TextSize = Starter.FONT_BODY";
_lbl.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 600;BA.debugLine="lbl.Gravity = Gravity.CENTER_VERTICAL";
_lbl.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 601;BA.debugLine="lbl.TextColor = Colors.White";
_lbl.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 602;BA.debugLine="pnl.AddView(lbl, 12dip, 0, panelWidth - 60dip, 50";
_pnl.AddView((android.view.View)(_lbl.getObject()),__c.DipToCurrent((int) (12)),(int) (0),(int) (_panelwidth-__c.DipToCurrent((int) (60))),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 605;BA.debugLine="Dim chk As CheckBox";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 606;BA.debugLine="chk.Initialize(\"chkItem\")";
_chk.Initialize(ba,"chkItem");
 //BA.debugLineNum = 607;BA.debugLine="chk.Tag = index";
_chk.setTag((Object)(_index));
 //BA.debugLineNum = 608;BA.debugLine="chk.Text = \"\"";
_chk.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 609;BA.debugLine="chk.Checked = checked";
_chk.setChecked(_checked);
 //BA.debugLineNum = 610;BA.debugLine="pnl.AddView(chk, panelWidth - 48dip, 10dip, 40dip";
_pnl.AddView((android.view.View)(_chk.getObject()),(int) (_panelwidth-__c.DipToCurrent((int) (48))),__c.DipToCurrent((int) (10)),__c.DipToCurrent((int) (40)),__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 612;BA.debugLine="Return pnl";
if (true) return _pnl;
 //BA.debugLineNum = 613;BA.debugLine="End Sub";
return null;
}
public String  _createlistmodeui() throws Exception{
int _width = 0;
int _margin = 0;
int _fieldwidth = 0;
int _filterwidth = 0;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cdfilter = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xvadditem = null;
anywheresoftware.b4a.objects.LabelWrapper _lbladditemtext = null;
 //BA.debugLineNum = 276;BA.debugLine="Private Sub CreateListModeUI";
 //BA.debugLineNum = 277;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 278;BA.debugLine="Dim margin As Int = 16dip";
_margin = __c.DipToCurrent((int) (16));
 //BA.debugLineNum = 279;BA.debugLine="Dim fieldWidth As Int = width - (margin * 2)";
_fieldwidth = (int) (_width-(_margin*2));
 //BA.debugLineNum = 281;BA.debugLine="pnlListMode.Initialize(\"\")";
_pnllistmode.Initialize(ba,"");
 //BA.debugLineNum = 282;BA.debugLine="pnlListMode.Color = Colors.Transparent";
_pnllistmode.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 283;BA.debugLine="pnlContent.AddView(pnlListMode, 0, 70dip, width,";
_pnlcontent.AddView((android.view.View)(_pnllistmode.getObject()),(int) (0),__c.DipToCurrent((int) (70)),_width,__c.DipToCurrent((int) (450)));
 //BA.debugLineNum = 286;BA.debugLine="Dim filterWidth As Int = fieldWidth - 44dip";
_filterwidth = (int) (_fieldwidth-__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 287;BA.debugLine="edtFilter.Initialize(\"edtFilter\")";
_edtfilter.Initialize(ba,"edtFilter");
 //BA.debugLineNum = 288;BA.debugLine="edtFilter.Hint = ModLang.T(\"filter_items\")";
_edtfilter.setHint(_modlang._t /*String*/ (ba,"filter_items"));
 //BA.debugLineNum = 289;BA.debugLine="edtFilter.SingleLine = True";
_edtfilter.setSingleLine(__c.True);
 //BA.debugLineNum = 290;BA.debugLine="edtFilter.TextSize = Starter.FONT_BODY";
_edtfilter.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 291;BA.debugLine="edtFilter.TextColor = Colors.White";
_edtfilter.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 292;BA.debugLine="edtFilter.HintColor = Colors.ARGB(120, 255, 255,";
_edtfilter.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 293;BA.debugLine="Dim cdFilter As ColorDrawable";
_cdfilter = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 294;BA.debugLine="cdFilter.Initialize2(ModTheme.HomeHeaderBg, 8dip,";
_cdfilter.Initialize2(_modtheme._homeheaderbg /*int*/ (ba),__c.DipToCurrent((int) (8)),__c.DipToCurrent((int) (1)),__c.Colors.ARGB((int) (80),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 295;BA.debugLine="edtFilter.Background = cdFilter";
_edtfilter.setBackground((android.graphics.drawable.Drawable)(_cdfilter.getObject()));
 //BA.debugLineNum = 296;BA.debugLine="pnlListMode.AddView(edtFilter, margin, 0, filterW";
_pnllistmode.AddView((android.view.View)(_edtfilter.getObject()),_margin,(int) (0),_filterwidth,__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 299;BA.debugLine="lblClearFilter.Initialize(\"lblClearFilter\")";
_lblclearfilter.Initialize(ba,"lblClearFilter");
 //BA.debugLineNum = 300;BA.debugLine="lblClearFilter.Text = \"X\"";
_lblclearfilter.setText(BA.ObjectToCharSequence("X"));
 //BA.debugLineNum = 301;BA.debugLine="lblClearFilter.TextSize = 18";
_lblclearfilter.setTextSize((float) (18));
 //BA.debugLineNum = 302;BA.debugLine="lblClearFilter.TextColor = Colors.ARGB(180, 255,";
_lblclearfilter.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 303;BA.debugLine="lblClearFilter.Gravity = Gravity.CENTER";
_lblclearfilter.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 304;BA.debugLine="pnlListMode.AddView(lblClearFilter, margin + filt";
_pnllistmode.AddView((android.view.View)(_lblclearfilter.getObject()),(int) (_margin+_filterwidth+__c.DipToCurrent((int) (4))),(int) (0),__c.DipToCurrent((int) (40)),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 307;BA.debugLine="pnlItems.Initialize(\"\")";
_pnlitems.Initialize(ba,"");
 //BA.debugLineNum = 308;BA.debugLine="pnlItems.Color = Colors.Transparent";
_pnlitems.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 309;BA.debugLine="pnlListMode.AddView(pnlItems, margin, 52dip, fiel";
_pnllistmode.AddView((android.view.View)(_pnlitems.getObject()),_margin,__c.DipToCurrent((int) (52)),_fieldwidth,__c.DipToCurrent((int) (300)));
 //BA.debugLineNum = 312;BA.debugLine="pnlAddRow.Initialize(\"\")";
_pnladdrow.Initialize(ba,"");
 //BA.debugLineNum = 313;BA.debugLine="pnlAddRow.Color = Colors.Transparent";
_pnladdrow.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 314;BA.debugLine="pnlListMode.AddView(pnlAddRow, margin, 360dip, fi";
_pnllistmode.AddView((android.view.View)(_pnladdrow.getObject()),_margin,__c.DipToCurrent((int) (360)),_fieldwidth,__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 317;BA.debugLine="lblAddItem.Initialize(\"lblAddItem\")";
_lbladditem.Initialize(ba,"lblAddItem");
 //BA.debugLineNum = 318;BA.debugLine="lblAddItem.Text = \"+\"";
_lbladditem.setText(BA.ObjectToCharSequence("+"));
 //BA.debugLineNum = 319;BA.debugLine="lblAddItem.TextSize = 26";
_lbladditem.setTextSize((float) (26));
 //BA.debugLineNum = 320;BA.debugLine="lblAddItem.Typeface = Typeface.DEFAULT_BOLD";
_lbladditem.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 321;BA.debugLine="lblAddItem.Gravity = Gravity.CENTER";
_lbladditem.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 322;BA.debugLine="lblAddItem.TextColor = Colors.White";
_lbladditem.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 323;BA.debugLine="pnlAddRow.AddView(lblAddItem, 0, 3dip, 44dip, 44d";
_pnladdrow.AddView((android.view.View)(_lbladditem.getObject()),(int) (0),__c.DipToCurrent((int) (3)),__c.DipToCurrent((int) (44)),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 326;BA.debugLine="Dim xvAddItem As B4XView = lblAddItem";
_xvadditem = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvadditem = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbladditem.getObject()));
 //BA.debugLineNum = 327;BA.debugLine="xvAddItem.SetColorAndBorder(ModTheme.HomeIconBg,";
_xvadditem.SetColorAndBorder(_modtheme._homeiconbg /*int*/ (ba),(int) (0),_modtheme._homeiconbg /*int*/ (ba),__c.DipToCurrent((int) (22)));
 //BA.debugLineNum = 330;BA.debugLine="Dim lblAddItemText As Label";
_lbladditemtext = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 331;BA.debugLine="lblAddItemText.Initialize(\"lblAddItem\")  'Mesmo e";
_lbladditemtext.Initialize(ba,"lblAddItem");
 //BA.debugLineNum = 332;BA.debugLine="lblAddItemText.Text = \"(\" & ModLang.T(\"add_item\")";
_lbladditemtext.setText(BA.ObjectToCharSequence("("+_modlang._t /*String*/ (ba,"add_item")+")"));
 //BA.debugLineNum = 333;BA.debugLine="lblAddItemText.TextSize = Starter.FONT_BODY";
_lbladditemtext.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 334;BA.debugLine="lblAddItemText.TextColor = Colors.ARGB(180, 255,";
_lbladditemtext.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 335;BA.debugLine="lblAddItemText.Gravity = Gravity.CENTER_VERTICAL";
_lbladditemtext.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 336;BA.debugLine="pnlAddRow.AddView(lblAddItemText, 52dip, 0, field";
_pnladdrow.AddView((android.view.View)(_lbladditemtext.getObject()),__c.DipToCurrent((int) (52)),(int) (0),(int) (_fieldwidth-__c.DipToCurrent((int) (60))),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 337;BA.debugLine="End Sub";
return "";
}
public String  _createtextmodeui() throws Exception{
int _width = 0;
int _margin = 0;
int _fieldwidth = 0;
anywheresoftware.b4a.objects.LabelWrapper _lblcontentfield = null;
 //BA.debugLineNum = 250;BA.debugLine="Private Sub CreateTextModeUI";
 //BA.debugLineNum = 251;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 252;BA.debugLine="Dim margin As Int = 16dip";
_margin = __c.DipToCurrent((int) (16));
 //BA.debugLineNum = 253;BA.debugLine="Dim fieldWidth As Int = width - (margin * 2)";
_fieldwidth = (int) (_width-(_margin*2));
 //BA.debugLineNum = 255;BA.debugLine="pnlTextMode.Initialize(\"\")";
_pnltextmode.Initialize(ba,"");
 //BA.debugLineNum = 256;BA.debugLine="pnlTextMode.Color = Colors.Transparent";
_pnltextmode.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 257;BA.debugLine="pnlContent.AddView(pnlTextMode, 0, 70dip, width,";
_pnlcontent.AddView((android.view.View)(_pnltextmode.getObject()),(int) (0),__c.DipToCurrent((int) (70)),_width,__c.DipToCurrent((int) (350)));
 //BA.debugLineNum = 260;BA.debugLine="Dim lblContentField As Label";
_lblcontentfield = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 261;BA.debugLine="lblContentField.Initialize(\"\")";
_lblcontentfield.Initialize(ba,"");
 //BA.debugLineNum = 262;BA.debugLine="lblContentField.Text = ModLang.T(\"content\")";
_lblcontentfield.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"content")));
 //BA.debugLineNum = 263;BA.debugLine="lblContentField.TextSize = Starter.FONT_LABEL";
_lblcontentfield.setTextSize(_starter._font_label /*float*/ );
 //BA.debugLineNum = 264;BA.debugLine="lblContentField.TextColor = Colors.ARGB(180, 255,";
_lblcontentfield.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 265;BA.debugLine="pnlTextMode.AddView(lblContentField, margin, 0, f";
_pnltextmode.AddView((android.view.View)(_lblcontentfield.getObject()),_margin,(int) (0),_fieldwidth,__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 268;BA.debugLine="edtContent.Initialize(\"edtContent\")";
_edtcontent.Initialize(ba,"edtContent");
 //BA.debugLineNum = 269;BA.debugLine="edtContent.Hint = ModLang.T(\"content_hint\")";
_edtcontent.setHint(_modlang._t /*String*/ (ba,"content_hint"));
 //BA.debugLineNum = 270;BA.debugLine="edtContent.SingleLine = False";
_edtcontent.setSingleLine(__c.False);
 //BA.debugLineNum = 271;BA.debugLine="edtContent.TextSize = Starter.FONT_BODY";
_edtcontent.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 272;BA.debugLine="edtContent.Gravity = Gravity.TOP";
_edtcontent.setGravity(__c.Gravity.TOP);
 //BA.debugLineNum = 273;BA.debugLine="pnlTextMode.AddView(edtContent, margin, 22dip, fi";
_pnltextmode.AddView((android.view.View)(_edtcontent.getObject()),_margin,__c.DipToCurrent((int) (22)),_fieldwidth,__c.DipToCurrent((int) (300)));
 //BA.debugLineNum = 274;BA.debugLine="End Sub";
return "";
}
public String  _createui() throws Exception{
int _width = 0;
int _height = 0;
int _headerh = 0;
int _iconbarh = 0;
anywheresoftware.b4a.objects.PanelWrapper _pnlheader = null;
anywheresoftware.b4a.objects.PanelWrapper _pnliconbar = null;
int _contenttop = 0;
 //BA.debugLineNum = 138;BA.debugLine="Private Sub CreateUI";
 //BA.debugLineNum = 139;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 140;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 141;BA.debugLine="Dim headerH As Int = 56dip";
_headerh = __c.DipToCurrent((int) (56));
 //BA.debugLineNum = 142;BA.debugLine="Dim iconBarH As Int = 50dip";
_iconbarh = __c.DipToCurrent((int) (50));
 //BA.debugLineNum = 145;BA.debugLine="Dim pnlHeader As Panel";
_pnlheader = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 146;BA.debugLine="pnlHeader.Initialize(\"\")";
_pnlheader.Initialize(ba,"");
 //BA.debugLineNum = 147;BA.debugLine="pnlHeader.Color = ModTheme.HomeHeaderBg";
_pnlheader.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 148;BA.debugLine="Root.AddView(pnlHeader, 0, 0, width, headerH)";
_root.AddView((android.view.View)(_pnlheader.getObject()),(int) (0),(int) (0),_width,_headerh);
 //BA.debugLineNum = 151;BA.debugLine="btnBack.Initialize(\"btnBack\")";
_btnback.Initialize(ba,"btnBack");
 //BA.debugLineNum = 152;BA.debugLine="btnBack.Text = \"<\"";
_btnback.setText(BA.ObjectToCharSequence("<"));
 //BA.debugLineNum = 153;BA.debugLine="btnBack.TextSize = 20";
_btnback.setTextSize((float) (20));
 //BA.debugLineNum = 154;BA.debugLine="btnBack.Color = Colors.Transparent";
_btnback.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 155;BA.debugLine="btnBack.TextColor = Colors.White";
_btnback.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 156;BA.debugLine="btnBack.Gravity = Gravity.CENTER";
_btnback.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 157;BA.debugLine="pnlHeader.AddView(btnBack, 0, 0, 50dip, headerH)";
_pnlheader.AddView((android.view.View)(_btnback.getObject()),(int) (0),(int) (0),__c.DipToCurrent((int) (50)),_headerh);
 //BA.debugLineNum = 160;BA.debugLine="lblHeaderTitle.Initialize(\"\")";
_lblheadertitle.Initialize(ba,"");
 //BA.debugLineNum = 161;BA.debugLine="lblHeaderTitle.Text = ModLang.T(\"new_note\")";
_lblheadertitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"new_note")));
 //BA.debugLineNum = 162;BA.debugLine="lblHeaderTitle.TextSize = Starter.FONT_BODY";
_lblheadertitle.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 163;BA.debugLine="lblHeaderTitle.TextColor = Colors.White";
_lblheadertitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 164;BA.debugLine="lblHeaderTitle.Typeface = Typeface.DEFAULT_BOLD";
_lblheadertitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 165;BA.debugLine="lblHeaderTitle.Gravity = Gravity.CENTER_VERTICAL";
_lblheadertitle.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 166;BA.debugLine="pnlHeader.AddView(lblHeaderTitle, 50dip, 0, width";
_pnlheader.AddView((android.view.View)(_lblheadertitle.getObject()),__c.DipToCurrent((int) (50)),(int) (0),(int) (_width-__c.DipToCurrent((int) (60))),_headerh);
 //BA.debugLineNum = 169;BA.debugLine="Dim pnlIconBar As Panel";
_pnliconbar = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 170;BA.debugLine="pnlIconBar.Initialize(\"\")";
_pnliconbar.Initialize(ba,"");
 //BA.debugLineNum = 171;BA.debugLine="pnlIconBar.Color = ModTheme.HomeBg";
_pnliconbar.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 172;BA.debugLine="Root.AddView(pnlIconBar, 0, headerH, width, iconB";
_root.AddView((android.view.View)(_pnliconbar.getObject()),(int) (0),_headerh,_width,_iconbarh);
 //BA.debugLineNum = 173;BA.debugLine="CreateIconBar(pnlIconBar, width)";
_createiconbar(_pnliconbar,_width);
 //BA.debugLineNum = 176;BA.debugLine="Dim contentTop As Int = headerH + iconBarH";
_contenttop = (int) (_headerh+_iconbarh);
 //BA.debugLineNum = 177;BA.debugLine="svContent.Initialize(0)";
_svcontent.Initialize(ba,(int) (0));
 //BA.debugLineNum = 178;BA.debugLine="svContent.Color = ModTheme.HomeBg";
_svcontent.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 179;BA.debugLine="Root.AddView(svContent, 0, contentTop, width, hei";
_root.AddView((android.view.View)(_svcontent.getObject()),(int) (0),_contenttop,_width,(int) (_height-_contenttop));
 //BA.debugLineNum = 181;BA.debugLine="pnlContent = svContent.Panel";
_pnlcontent = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_svcontent.getPanel().getObject()));
 //BA.debugLineNum = 182;BA.debugLine="pnlContent.Color = ModTheme.HomeBg";
_pnlcontent.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 184;BA.debugLine="CreateCommonFields";
_createcommonfields();
 //BA.debugLineNum = 185;BA.debugLine="CreateTextModeUI";
_createtextmodeui();
 //BA.debugLineNum = 186;BA.debugLine="CreateListModeUI";
_createlistmodeui();
 //BA.debugLineNum = 187;BA.debugLine="CreateInputDialog";
_createinputdialog();
 //BA.debugLineNum = 188;BA.debugLine="End Sub";
return "";
}
public String  _edititem(int _index) throws Exception{
anywheresoftware.b4a.objects.collections.Map _item = null;
String _currenttext = "";
 //BA.debugLineNum = 683;BA.debugLine="Private Sub EditItem(index As Int)";
 //BA.debugLineNum = 684;BA.debugLine="If index < 0 Or index >= ItemsList.Size Then Retu";
if (_index<0 || _index>=_itemslist.getSize()) { 
if (true) return "";};
 //BA.debugLineNum = 685;BA.debugLine="If IsSecure Then ModSession.Touch";
if (_issecure) { 
_modsession._touch /*String*/ (ba);};
 //BA.debugLineNum = 687;BA.debugLine="Dim item As Map = ItemsList.Get(index)";
_item = new anywheresoftware.b4a.objects.collections.Map();
_item = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_itemslist.Get(_index)));
 //BA.debugLineNum = 688;BA.debugLine="Dim currentText As String = item.GetDefault(\"text";
_currenttext = BA.ObjectToString(_item.GetDefault((Object)("text"),(Object)("")));
 //BA.debugLineNum = 689;BA.debugLine="ShowInputDialog(ModLang.T(\"edit_item\"), currentTe";
_showinputdialog(_modlang._t /*String*/ (ba,"edit_item"),_currenttext,_index);
 //BA.debugLineNum = 690;BA.debugLine="End Sub";
return "";
}
public String  _edtcontent_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 961;BA.debugLine="Private Sub edtContent_FocusChanged(HasFocus As Bo";
 //BA.debugLineNum = 962;BA.debugLine="If HasFocus Then svContent.ScrollPosition = edtCo";
if (_hasfocus) { 
_svcontent.setScrollPosition((int) (_edtcontent.getTop()-__c.DipToCurrent((int) (30))));};
 //BA.debugLineNum = 963;BA.debugLine="End Sub";
return "";
}
public String  _edtfilter_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 651;BA.debugLine="Private Sub edtFilter_TextChanged(Old As String, N";
 //BA.debugLineNum = 652;BA.debugLine="CurrentFilter = New.Trim.ToLowerCase";
_currentfilter = _new.trim().toLowerCase();
 //BA.debugLineNum = 653;BA.debugLine="RebuildItemsUI";
_rebuilditemsui();
 //BA.debugLineNum = 654;BA.debugLine="End Sub";
return "";
}
public String  _edttitle_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 957;BA.debugLine="Private Sub edtTitle_FocusChanged(HasFocus As Bool";
 //BA.debugLineNum = 958;BA.debugLine="If HasFocus Then svContent.ScrollPosition = 0";
if (_hasfocus) { 
_svcontent.setScrollPosition((int) (0));};
 //BA.debugLineNum = 959;BA.debugLine="End Sub";
return "";
}
public String  _hideinputdialog() throws Exception{
anywheresoftware.b4a.objects.IME _ime = null;
 //BA.debugLineNum = 462;BA.debugLine="Private Sub HideInputDialog";
 //BA.debugLineNum = 463;BA.debugLine="pnlInputOverlay.Visible = False";
_pnlinputoverlay.setVisible(__c.False);
 //BA.debugLineNum = 464;BA.debugLine="EditingItemIndex = -1";
_editingitemindex = (int) (-1);
 //BA.debugLineNum = 465;BA.debugLine="Dim ime As IME";
_ime = new anywheresoftware.b4a.objects.IME();
 //BA.debugLineNum = 466;BA.debugLine="ime.Initialize(\"\")";
_ime.Initialize("");
 //BA.debugLineNum = 467;BA.debugLine="ime.HideKeyboard";
_ime.HideKeyboard(ba);
 //BA.debugLineNum = 468;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 65;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 66;BA.debugLine="ItemsList.Initialize";
_itemslist.Initialize();
 //BA.debugLineNum = 67;BA.debugLine="ItemPanels.Initialize";
_itempanels.Initialize();
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return "";
}
public boolean  _itemmatchesfilter(String _itemtext) throws Exception{
String _normalizeditem = "";
String _normalizedfilter = "";
 //BA.debugLineNum = 676;BA.debugLine="Private Sub ItemMatchesFilter(itemText As String)";
 //BA.debugLineNum = 677;BA.debugLine="If CurrentFilter.Length = 0 Then Return True";
if (_currentfilter.length()==0) { 
if (true) return __c.True;};
 //BA.debugLineNum = 678;BA.debugLine="Dim normalizedItem As String = RemoveAccents(item";
_normalizeditem = _removeaccents(_itemtext);
 //BA.debugLineNum = 679;BA.debugLine="Dim normalizedFilter As String = RemoveAccents(Cu";
_normalizedfilter = _removeaccents(_currentfilter);
 //BA.debugLineNum = 680;BA.debugLine="Return normalizedItem.Contains(normalizedFilter)";
if (true) return _normalizeditem.contains(_normalizedfilter);
 //BA.debugLineNum = 681;BA.debugLine="End Sub";
return false;
}
public void  _ivicondelete_click() throws Exception{
ResumableSub_ivIconDelete_Click rsub = new ResumableSub_ivIconDelete_Click(this);
rsub.resume(ba, null);
}
public static class ResumableSub_ivIconDelete_Click extends BA.ResumableSub {
public ResumableSub_ivIconDelete_Click(com.lockzero.pagenoteedit parent) {
this.parent = parent;
}
com.lockzero.pagenoteedit parent;
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 886;BA.debugLine="If IsSecure Then ModSession.Touch";
if (true) break;

case 1:
//if
this.state = 6;
if (parent._issecure) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
parent._modsession._touch /*String*/ (ba);
if (true) break;

case 6:
//C
this.state = 7;
;
 //BA.debugLineNum = 888;BA.debugLine="Wait For (xui.Msgbox2Async(ModLang.T(\"confirm_del";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"confirm_delete")),BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"delete")),parent._modlang._t /*String*/ (ba,"yes"),"",parent._modlang._t /*String*/ (ba,"cancel"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 11;
return;
case 11:
//C
this.state = 7;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 890;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
if (true) break;

case 7:
//if
this.state = 10;
if (_result==parent._xui.DialogResponse_Positive) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 891;BA.debugLine="ModNotes.DeleteNote(CurrentNoteId)";
parent._modnotes._deletenote /*String*/ (ba,parent._currentnoteid);
 //BA.debugLineNum = 892;BA.debugLine="ToastMessageShow(ModLang.T(\"success\"), False)";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"success")),parent.__c.False);
 //BA.debugLineNum = 893;BA.debugLine="B4XPages.ClosePage(Me)";
parent._b4xpages._closepage /*String*/ (ba,parent);
 if (true) break;

case 10:
//C
this.state = -1;
;
 //BA.debugLineNum = 895;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _msgbox_result(int _result) throws Exception{
}
public void  _iviconshare_click() throws Exception{
ResumableSub_ivIconShare_Click rsub = new ResumableSub_ivIconShare_Click(this);
rsub.resume(ba, null);
}
public static class ResumableSub_ivIconShare_Click extends BA.ResumableSub {
public ResumableSub_ivIconShare_Click(com.lockzero.pagenoteedit parent) {
this.parent = parent;
}
com.lockzero.pagenoteedit parent;
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 899;BA.debugLine="If ItemsList.Size = 0 Then";
if (true) break;

case 1:
//if
this.state = 4;
if (parent._itemslist.getSize()==0) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 900;BA.debugLine="ToastMessageShow(ModLang.T(\"empty\"), True)";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"empty")),parent.__c.True);
 //BA.debugLineNum = 901;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 4:
//C
this.state = 5;
;
 //BA.debugLineNum = 905;BA.debugLine="Wait For (xui.Msgbox2Async(ModLang.T(\"share_which";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"share_which")),BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"share")),parent._modlang._t /*String*/ (ba,"share_all"),parent._modlang._t /*String*/ (ba,"cancel"),parent._modlang._t /*String*/ (ba,"share_checked"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 11;
return;
case 11:
//C
this.state = 5;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 907;BA.debugLine="If Result = xui.DialogResponse_Negative Then";
if (true) break;

case 5:
//if
this.state = 10;
if (_result==parent._xui.DialogResponse_Negative) { 
this.state = 7;
}else if(_result==parent._xui.DialogResponse_Positive) { 
this.state = 9;
}if (true) break;

case 7:
//C
this.state = 10;
 //BA.debugLineNum = 909;BA.debugLine="ShareItems(True)";
parent._shareitems(parent.__c.True);
 if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 912;BA.debugLine="ShareItems(False)";
parent._shareitems(parent.__c.False);
 if (true) break;

case 10:
//C
this.state = -1;
;
 //BA.debugLineNum = 914;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _lbladditem_click() throws Exception{
 //BA.debugLineNum = 619;BA.debugLine="Private Sub lblAddItem_Click";
 //BA.debugLineNum = 620;BA.debugLine="If IsSecure Then ModSession.Touch";
if (_issecure) { 
_modsession._touch /*String*/ (ba);};
 //BA.debugLineNum = 621;BA.debugLine="ShowInputDialog(ModLang.T(\"note_add_item\"), \"\", -";
_showinputdialog(_modlang._t /*String*/ (ba,"note_add_item"),"",(int) (-1));
 //BA.debugLineNum = 622;BA.debugLine="End Sub";
return "";
}
public String  _lblclearfilter_click() throws Exception{
 //BA.debugLineNum = 657;BA.debugLine="Private Sub lblClearFilter_Click";
 //BA.debugLineNum = 658;BA.debugLine="edtFilter.Text = \"\"";
_edtfilter.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 659;BA.debugLine="CurrentFilter = \"\"";
_currentfilter = "";
 //BA.debugLineNum = 660;BA.debugLine="RebuildItemsUI";
_rebuilditemsui();
 //BA.debugLineNum = 661;BA.debugLine="End Sub";
return "";
}
public String  _lbliconadd_click() throws Exception{
 //BA.debugLineNum = 879;BA.debugLine="Private Sub lblIconAdd_Click";
 //BA.debugLineNum = 880;BA.debugLine="If IsSecure Then ModSession.Touch";
if (_issecure) { 
_modsession._touch /*String*/ (ba);};
 //BA.debugLineNum = 881;BA.debugLine="ShowInputDialog(ModLang.T(\"note_add_item\"), \"\", -";
_showinputdialog(_modlang._t /*String*/ (ba,"note_add_item"),"",(int) (-1));
 //BA.debugLineNum = 882;BA.debugLine="End Sub";
return "";
}
public String  _lbliconsave_click() throws Exception{
 //BA.debugLineNum = 953;BA.debugLine="Private Sub lblIconSave_Click";
 //BA.debugLineNum = 954;BA.debugLine="SaveNote(True)";
_savenote(__c.True);
 //BA.debugLineNum = 955;BA.debugLine="End Sub";
return "";
}
public String  _lblitem_click() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
int _index = 0;
 //BA.debugLineNum = 644;BA.debugLine="Private Sub lblItem_Click";
 //BA.debugLineNum = 645;BA.debugLine="Dim lbl As Label = Sender";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
_lbl = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(__c.Sender(ba)));
 //BA.debugLineNum = 646;BA.debugLine="Dim index As Int = lbl.Tag";
_index = (int)(BA.ObjectToNumber(_lbl.getTag()));
 //BA.debugLineNum = 647;BA.debugLine="EditItem(index)";
_edititem(_index);
 //BA.debugLineNum = 648;BA.debugLine="End Sub";
return "";
}
public String  _loadnote() throws Exception{
com.lockzero.clsnoteentry _note = null;
String _decrypteditems = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
 //BA.debugLineNum = 717;BA.debugLine="Private Sub LoadNote";
 //BA.debugLineNum = 718;BA.debugLine="Dim note As clsNoteEntry = ModNotes.GetNoteById(C";
_note = _modnotes._getnotebyid /*com.lockzero.clsnoteentry*/ (ba,_currentnoteid);
 //BA.debugLineNum = 719;BA.debugLine="If note = Null Then";
if (_note== null) { 
 //BA.debugLineNum = 720;BA.debugLine="ToastMessageShow(ModLang.T(\"error_not_found\"), T";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error_not_found")),__c.True);
 //BA.debugLineNum = 721;BA.debugLine="B4XPages.ClosePage(Me)";
_b4xpages._closepage /*String*/ (ba,this);
 //BA.debugLineNum = 722;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 726;BA.debugLine="NoteType = note.NoteType";
_notetype = _note._notetype /*String*/ ;
 //BA.debugLineNum = 727;BA.debugLine="SetupModeUI";
_setupmodeui();
 //BA.debugLineNum = 730;BA.debugLine="If IsSecure Then";
if (_issecure) { 
 //BA.debugLineNum = 731;BA.debugLine="edtTitle.Text = note.GetDecryptedTitle(Passphras";
_edttitle.setText(BA.ObjectToCharSequence(_note._getdecryptedtitle /*String*/ (_passphrase)));
 }else {
 //BA.debugLineNum = 733;BA.debugLine="edtTitle.Text = note.Title";
_edttitle.setText(BA.ObjectToCharSequence(_note._title /*String*/ ));
 };
 //BA.debugLineNum = 735;BA.debugLine="CurrentNoteTitle = edtTitle.Text  'Guarda para br";
_currentnotetitle = _edttitle.getText();
 //BA.debugLineNum = 737;BA.debugLine="chkFavorite.Checked = note.IsFavorite";
_chkfavorite.setChecked(_note._isfavorite /*boolean*/ );
 //BA.debugLineNum = 739;BA.debugLine="If NoteType = \"list\" Then";
if ((_notetype).equals("list")) { 
 //BA.debugLineNum = 741;BA.debugLine="If IsSecure Then";
if (_issecure) { 
 //BA.debugLineNum = 742;BA.debugLine="Dim decryptedItems As String = note.GetDecrypte";
_decrypteditems = _note._getdecrypteditems /*String*/ (_passphrase);
 //BA.debugLineNum = 743;BA.debugLine="If decryptedItems <> \"\" And decryptedItems <> \"";
if ((_decrypteditems).equals("") == false && (_decrypteditems).equals("[]") == false) { 
 //BA.debugLineNum = 744;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 745;BA.debugLine="parser.Initialize(decryptedItems)";
_parser.Initialize(_decrypteditems);
 //BA.debugLineNum = 746;BA.debugLine="ItemsList = parser.NextArray";
_itemslist = _parser.NextArray();
 };
 }else {
 //BA.debugLineNum = 749;BA.debugLine="ItemsList = note.GetItemsList";
_itemslist = _note._getitemslist /*anywheresoftware.b4a.objects.collections.List*/ ();
 };
 //BA.debugLineNum = 751;BA.debugLine="RebuildItemsUI";
_rebuilditemsui();
 }else {
 //BA.debugLineNum = 754;BA.debugLine="If IsSecure Then";
if (_issecure) { 
 //BA.debugLineNum = 755;BA.debugLine="edtContent.Text = note.GetDecryptedContent(Pass";
_edtcontent.setText(BA.ObjectToCharSequence(_note._getdecryptedcontent /*String*/ (_passphrase)));
 }else {
 //BA.debugLineNum = 757;BA.debugLine="edtContent.Text = note.Content";
_edtcontent.setText(BA.ObjectToCharSequence(_note._content /*String*/ ));
 };
 };
 //BA.debugLineNum = 760;BA.debugLine="End Sub";
return "";
}
public String  _pnlinputoverlay_click() throws Exception{
 //BA.debugLineNum = 470;BA.debugLine="Private Sub pnlInputOverlay_Click";
 //BA.debugLineNum = 471;BA.debugLine="HideInputDialog";
_hideinputdialog();
 //BA.debugLineNum = 472;BA.debugLine="End Sub";
return "";
}
public String  _rebuilditemsui() throws Exception{
int _width = 0;
int _itemheight = 0;
int _y = 0;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _item = null;
String _itemtext = "";
anywheresoftware.b4a.objects.PanelWrapper _pnlitem = null;
int _addrowtop = 0;
int _totalheight = 0;
 //BA.debugLineNum = 541;BA.debugLine="Private Sub RebuildItemsUI";
 //BA.debugLineNum = 542;BA.debugLine="IsRebuildingUI = True  'Bloqueia eventos de check";
_isrebuildingui = __c.True;
 //BA.debugLineNum = 544;BA.debugLine="pnlItems.RemoveAllViews";
_pnlitems.RemoveAllViews();
 //BA.debugLineNum = 545;BA.debugLine="ItemPanels.Initialize";
_itempanels.Initialize();
 //BA.debugLineNum = 547;BA.debugLine="Dim width As Int = pnlItems.Width";
_width = _pnlitems.getWidth();
 //BA.debugLineNum = 548;BA.debugLine="Dim itemHeight As Int = 50dip";
_itemheight = __c.DipToCurrent((int) (50));
 //BA.debugLineNum = 549;BA.debugLine="Dim y As Int = 0";
_y = (int) (0);
 //BA.debugLineNum = 551;BA.debugLine="For i = 0 To ItemsList.Size - 1";
{
final int step7 = 1;
final int limit7 = (int) (_itemslist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
 //BA.debugLineNum = 552;BA.debugLine="Dim item As Map = ItemsList.Get(i)";
_item = new anywheresoftware.b4a.objects.collections.Map();
_item = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_itemslist.Get(_i)));
 //BA.debugLineNum = 553;BA.debugLine="Dim itemText As String = item.GetDefault(\"text\",";
_itemtext = BA.ObjectToString(_item.GetDefault((Object)("text"),(Object)("")));
 //BA.debugLineNum = 556;BA.debugLine="If ItemMatchesFilter(itemText) = False Then Cont";
if (_itemmatchesfilter(_itemtext)==__c.False) { 
if (true) continue;};
 //BA.debugLineNum = 558;BA.debugLine="Dim pnlItem As Panel = CreateItemPanel(i, item,";
_pnlitem = new anywheresoftware.b4a.objects.PanelWrapper();
_pnlitem = _createitempanel(_i,_item,_width);
 //BA.debugLineNum = 559;BA.debugLine="pnlItems.AddView(pnlItem, 0, y, width, itemHeigh";
_pnlitems.AddView((android.view.View)(_pnlitem.getObject()),(int) (0),_y,_width,_itemheight);
 //BA.debugLineNum = 560;BA.debugLine="ItemPanels.Add(pnlItem)";
_itempanels.Add((Object)(_pnlitem.getObject()));
 //BA.debugLineNum = 561;BA.debugLine="y = y + itemHeight + 8dip";
_y = (int) (_y+_itemheight+__c.DipToCurrent((int) (8)));
 }
};
 //BA.debugLineNum = 565;BA.debugLine="pnlItems.Height = Max(y, 50dip)";
_pnlitems.setHeight((int) (__c.Max(_y,__c.DipToCurrent((int) (50)))));
 //BA.debugLineNum = 569;BA.debugLine="Dim addRowTop As Int = 52dip + pnlItems.Height +";
_addrowtop = (int) (__c.DipToCurrent((int) (52))+_pnlitems.getHeight()+__c.DipToCurrent((int) (10)));
 //BA.debugLineNum = 570;BA.debugLine="pnlAddRow.Top = addRowTop";
_pnladdrow.setTop(_addrowtop);
 //BA.debugLineNum = 574;BA.debugLine="pnlListMode.Height = addRowTop + 60dip";
_pnllistmode.setHeight((int) (_addrowtop+__c.DipToCurrent((int) (60))));
 //BA.debugLineNum = 577;BA.debugLine="Dim totalHeight As Int = 70dip + pnlListMode.Heig";
_totalheight = (int) (__c.DipToCurrent((int) (70))+_pnllistmode.getHeight()+__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 578;BA.debugLine="pnlContent.Height = Max(totalHeight, 300dip)";
_pnlcontent.setHeight((int) (__c.Max(_totalheight,__c.DipToCurrent((int) (300)))));
 //BA.debugLineNum = 580;BA.debugLine="IsRebuildingUI = False  'Libera eventos de checkb";
_isrebuildingui = __c.False;
 //BA.debugLineNum = 581;BA.debugLine="End Sub";
return "";
}
public String  _removeaccents(String _text) throws Exception{
String _result = "";
 //BA.debugLineNum = 664;BA.debugLine="Private Sub RemoveAccents(text As String) As Strin";
 //BA.debugLineNum = 665;BA.debugLine="Dim result As String = text.ToLowerCase";
_result = _text.toLowerCase();
 //BA.debugLineNum = 666;BA.debugLine="result = result.Replace(\"á\", \"a\").Replace(\"à\", \"a";
_result = _result.replace("á","a").replace("à","a").replace("ã","a").replace("â","a").replace("ä","a");
 //BA.debugLineNum = 667;BA.debugLine="result = result.Replace(\"é\", \"e\").Replace(\"è\", \"e";
_result = _result.replace("é","e").replace("è","e").replace("ê","e").replace("ë","e");
 //BA.debugLineNum = 668;BA.debugLine="result = result.Replace(\"í\", \"i\").Replace(\"ì\", \"i";
_result = _result.replace("í","i").replace("ì","i").replace("î","i").replace("ï","i");
 //BA.debugLineNum = 669;BA.debugLine="result = result.Replace(\"ó\", \"o\").Replace(\"ò\", \"o";
_result = _result.replace("ó","o").replace("ò","o").replace("õ","o").replace("ô","o").replace("ö","o");
 //BA.debugLineNum = 670;BA.debugLine="result = result.Replace(\"ú\", \"u\").Replace(\"ù\", \"u";
_result = _result.replace("ú","u").replace("ù","u").replace("û","u").replace("ü","u");
 //BA.debugLineNum = 671;BA.debugLine="result = result.Replace(\"ç\", \"c\").Replace(\"ñ\", \"n";
_result = _result.replace("ç","c").replace("ñ","n");
 //BA.debugLineNum = 672;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 673;BA.debugLine="End Sub";
return "";
}
public boolean  _savenote(boolean _closeafter) throws Exception{
String _title = "";
com.lockzero.clsnoteentry _note = null;
anywheresoftware.b4a.objects.collections.List _existingnotes = null;
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _gen = null;
String _jsonitems = "";
 //BA.debugLineNum = 769;BA.debugLine="Private Sub SaveNote(closeAfter As Boolean) As Boo";
 //BA.debugLineNum = 770;BA.debugLine="Log(\"SaveNote: NoteType=\" & NoteType & \", IsSecur";
__c.LogImpl("817498113","SaveNote: NoteType="+_notetype+", IsSecure="+BA.ObjectToString(_issecure)+", closeAfter="+BA.ObjectToString(_closeafter),0);
 //BA.debugLineNum = 772;BA.debugLine="If IsSecure Then ModSession.Touch";
if (_issecure) { 
_modsession._touch /*String*/ (ba);};
 //BA.debugLineNum = 774;BA.debugLine="Dim title As String = edtTitle.Text.Trim";
_title = _edttitle.getText().trim();
 //BA.debugLineNum = 777;BA.debugLine="If title.Length < 1 Then";
if (_title.length()<1) { 
 //BA.debugLineNum = 778;BA.debugLine="ToastMessageShow(ModLang.T(\"error_empty_field\"),";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error_empty_field")),__c.True);
 //BA.debugLineNum = 779;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 783;BA.debugLine="If IsSecure And Passphrase.Length = 0 Then";
if (_issecure && _passphrase.length()==0) { 
 //BA.debugLineNum = 784;BA.debugLine="Log(\"ERRO: Passphrase vazia para grupo seguro!\")";
__c.LogImpl("817498127","ERRO: Passphrase vazia para grupo seguro!",0);
 //BA.debugLineNum = 785;BA.debugLine="ToastMessageShow(ModLang.T(\"error\"), True)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error")),__c.True);
 //BA.debugLineNum = 786;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 789;BA.debugLine="Dim note As clsNoteEntry";
_note = new com.lockzero.clsnoteentry();
 //BA.debugLineNum = 790;BA.debugLine="If IsNewNote Then";
if (_isnewnote) { 
 //BA.debugLineNum = 791;BA.debugLine="note.Initialize";
_note._initialize /*String*/ (ba);
 //BA.debugLineNum = 792;BA.debugLine="note.GroupId = CurrentGroupId";
_note._groupid /*String*/  = _currentgroupid;
 //BA.debugLineNum = 793;BA.debugLine="note.NoteType = NoteType";
_note._notetype /*String*/  = _notetype;
 //BA.debugLineNum = 795;BA.debugLine="Dim existingNotes As List = ModNotes.GetNotesByG";
_existingnotes = new anywheresoftware.b4a.objects.collections.List();
_existingnotes = _modnotes._getnotesbygroup /*anywheresoftware.b4a.objects.collections.List*/ (ba,_currentgroupid);
 //BA.debugLineNum = 796;BA.debugLine="note.SortOrder = existingNotes.Size";
_note._sortorder /*int*/  = _existingnotes.getSize();
 }else {
 //BA.debugLineNum = 798;BA.debugLine="note = ModNotes.GetNoteById(CurrentNoteId)";
_note = _modnotes._getnotebyid /*com.lockzero.clsnoteentry*/ (ba,_currentnoteid);
 //BA.debugLineNum = 799;BA.debugLine="If note = Null Then";
if (_note== null) { 
 //BA.debugLineNum = 800;BA.debugLine="ToastMessageShow(ModLang.T(\"error\"), True)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error")),__c.True);
 //BA.debugLineNum = 801;BA.debugLine="Return False";
if (true) return __c.False;
 };
 };
 //BA.debugLineNum = 806;BA.debugLine="If ItemsList.IsInitialized = False Then";
if (_itemslist.IsInitialized()==__c.False) { 
 //BA.debugLineNum = 807;BA.debugLine="ItemsList.Initialize";
_itemslist.Initialize();
 //BA.debugLineNum = 808;BA.debugLine="Log(\"ItemsList foi inicializado agora\")";
__c.LogImpl("817498151","ItemsList foi inicializado agora",0);
 };
 //BA.debugLineNum = 810;BA.debugLine="Log(\"ItemsList.Size=\" & ItemsList.Size)";
__c.LogImpl("817498153","ItemsList.Size="+BA.NumberToString(_itemslist.getSize()),0);
 //BA.debugLineNum = 813;BA.debugLine="If IsSecure Then";
if (_issecure) { 
 //BA.debugLineNum = 814;BA.debugLine="Log(\"Modo SEGURO - criptografando...\")";
__c.LogImpl("817498157","Modo SEGURO - criptografando...",0);
 //BA.debugLineNum = 816;BA.debugLine="note.EncryptTitle(Passphrase, title)";
_note._encrypttitle /*String*/ (_passphrase,_title);
 //BA.debugLineNum = 817;BA.debugLine="Log(\"Titulo criptografado OK\")";
__c.LogImpl("817498160","Titulo criptografado OK",0);
 //BA.debugLineNum = 819;BA.debugLine="If NoteType = \"list\" Then";
if ((_notetype).equals("list")) { 
 //BA.debugLineNum = 820;BA.debugLine="Log(\"Salvando lista segura...\")";
__c.LogImpl("817498163","Salvando lista segura...",0);
 //BA.debugLineNum = 822;BA.debugLine="Dim gen As JSONGenerator";
_gen = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 823;BA.debugLine="gen.Initialize2(ItemsList)  'Initialize2 para L";
_gen.Initialize2(_itemslist);
 //BA.debugLineNum = 824;BA.debugLine="Dim jsonItems As String = gen.ToString";
_jsonitems = _gen.ToString();
 //BA.debugLineNum = 825;BA.debugLine="Log(\"JSON gerado: \" & jsonItems)";
__c.LogImpl("817498168","JSON gerado: "+_jsonitems,0);
 //BA.debugLineNum = 826;BA.debugLine="note.EncryptItems(Passphrase, jsonItems)";
_note._encryptitems /*String*/ (_passphrase,_jsonitems);
 //BA.debugLineNum = 827;BA.debugLine="note.Content = \"\"";
_note._content /*String*/  = "";
 //BA.debugLineNum = 828;BA.debugLine="Log(\"Items criptografados OK\")";
__c.LogImpl("817498171","Items criptografados OK",0);
 }else {
 //BA.debugLineNum = 830;BA.debugLine="note.EncryptContent(Passphrase, edtContent.Text";
_note._encryptcontent /*String*/ (_passphrase,_edtcontent.getText().trim());
 //BA.debugLineNum = 831;BA.debugLine="note.Items = \"[]\"";
_note._items /*String*/  = "[]";
 };
 }else {
 //BA.debugLineNum = 834;BA.debugLine="Log(\"Modo ABERTO - texto claro...\")";
__c.LogImpl("817498177","Modo ABERTO - texto claro...",0);
 //BA.debugLineNum = 836;BA.debugLine="note.Title = title";
_note._title /*String*/  = _title;
 //BA.debugLineNum = 838;BA.debugLine="If NoteType = \"list\" Then";
if ((_notetype).equals("list")) { 
 //BA.debugLineNum = 839;BA.debugLine="Log(\"Salvando lista aberta, ItemsList.Size=\" &";
__c.LogImpl("817498182","Salvando lista aberta, ItemsList.Size="+BA.NumberToString(_itemslist.getSize()),0);
 //BA.debugLineNum = 840;BA.debugLine="note.SetItemsList(ItemsList)";
_note._setitemslist /*String*/ (_itemslist);
 //BA.debugLineNum = 841;BA.debugLine="note.Content = \"\"";
_note._content /*String*/  = "";
 //BA.debugLineNum = 842;BA.debugLine="Log(\"SetItemsList OK\")";
__c.LogImpl("817498185","SetItemsList OK",0);
 }else {
 //BA.debugLineNum = 844;BA.debugLine="note.Content = edtContent.Text.Trim";
_note._content /*String*/  = _edtcontent.getText().trim();
 //BA.debugLineNum = 845;BA.debugLine="note.Items = \"[]\"";
_note._items /*String*/  = "[]";
 };
 };
 //BA.debugLineNum = 849;BA.debugLine="note.IsFavorite = chkFavorite.Checked";
_note._isfavorite /*boolean*/  = _chkfavorite.getChecked();
 //BA.debugLineNum = 850;BA.debugLine="Log(\"Chamando ModNotes.SaveNote...\")";
__c.LogImpl("817498193","Chamando ModNotes.SaveNote...",0);
 //BA.debugLineNum = 851;BA.debugLine="ModNotes.SaveNote(note)";
_modnotes._savenote /*String*/ (ba,_note);
 //BA.debugLineNum = 852;BA.debugLine="Log(\"SaveNote OK\")";
__c.LogImpl("817498195","SaveNote OK",0);
 //BA.debugLineNum = 855;BA.debugLine="If IsNewNote Then";
if (_isnewnote) { 
 //BA.debugLineNum = 856;BA.debugLine="CurrentNoteId = note.Id";
_currentnoteid = _note._id /*String*/ ;
 //BA.debugLineNum = 857;BA.debugLine="IsNewNote = False";
_isnewnote = __c.False;
 };
 //BA.debugLineNum = 860;BA.debugLine="ToastMessageShow(ModLang.T(\"success\"), False)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"success")),__c.False);
 //BA.debugLineNum = 862;BA.debugLine="If closeAfter Then";
if (_closeafter) { 
 //BA.debugLineNum = 863;BA.debugLine="Log(\"Fechando pagina...\")";
__c.LogImpl("817498206","Fechando pagina...",0);
 //BA.debugLineNum = 864;BA.debugLine="B4XPages.ClosePage(Me)";
_b4xpages._closepage /*String*/ (ba,this);
 };
 //BA.debugLineNum = 867;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 868;BA.debugLine="End Sub";
return false;
}
public String  _setandroidicon(anywheresoftware.b4a.objects.ImageViewWrapper _iv,String _iconname) throws Exception{
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
Object _resources = null;
int _id = 0;
Object _drawable = null;
anywheresoftware.b4j.object.JavaObject _ivjo = null;
 //BA.debugLineNum = 994;BA.debugLine="Private Sub SetAndroidIcon(iv As ImageView, iconNa";
 //BA.debugLineNum = 995;BA.debugLine="Try";
try { //BA.debugLineNum = 996;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
 //BA.debugLineNum = 997;BA.debugLine="r.Target = r.GetContext";
_r.Target = (Object)(_r.GetContext(ba));
 //BA.debugLineNum = 998;BA.debugLine="Dim resources As Object = r.RunMethod(\"getResour";
_resources = _r.RunMethod("getResources");
 //BA.debugLineNum = 999;BA.debugLine="r.Target = resources";
_r.Target = _resources;
 //BA.debugLineNum = 1000;BA.debugLine="Dim id As Int = r.RunMethod4(\"getIdentifier\", Ar";
_id = (int)(BA.ObjectToNumber(_r.RunMethod4("getIdentifier",new Object[]{(Object)(_iconname),(Object)("drawable"),(Object)("android")},new String[]{"java.lang.String","java.lang.String","java.lang.String"})));
 //BA.debugLineNum = 1001;BA.debugLine="If id > 0 Then";
if (_id>0) { 
 //BA.debugLineNum = 1002;BA.debugLine="Dim drawable As Object = r.RunMethod2(\"getDrawa";
_drawable = _r.RunMethod2("getDrawable",BA.NumberToString(_id),"java.lang.int");
 //BA.debugLineNum = 1003;BA.debugLine="Dim ivJO As JavaObject = iv";
_ivjo = new anywheresoftware.b4j.object.JavaObject();
_ivjo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_iv.getObject()));
 //BA.debugLineNum = 1004;BA.debugLine="ivJO.RunMethod(\"setImageDrawable\", Array(drawab";
_ivjo.RunMethod("setImageDrawable",new Object[]{_drawable});
 //BA.debugLineNum = 1006;BA.debugLine="ivJO.RunMethodJO(\"setColorFilter\", Array(Colors";
_ivjo.RunMethodJO("setColorFilter",new Object[]{(Object)(__c.Colors.White)});
 };
 } 
       catch (Exception e14) {
			ba.setLastException(e14); //BA.debugLineNum = 1009;BA.debugLine="Log(\"SetAndroidIcon erro: \" & LastException.Mess";
__c.LogImpl("818153487","SetAndroidIcon erro: "+__c.LastException(ba).getMessage(),0);
 };
 //BA.debugLineNum = 1011;BA.debugLine="End Sub";
return "";
}
public String  _setparams(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
 //BA.debugLineNum = 100;BA.debugLine="Public Sub SetParams(params As Map)";
 //BA.debugLineNum = 101;BA.debugLine="If params = Null Then Return";
if (_params== null) { 
if (true) return "";};
 //BA.debugLineNum = 103;BA.debugLine="CurrentNoteId = params.GetDefault(\"noteId\", \"\")";
_currentnoteid = BA.ObjectToString(_params.GetDefault((Object)("noteId"),(Object)("")));
 //BA.debugLineNum = 104;BA.debugLine="CurrentGroupId = params.GetDefault(\"groupId\", \"\")";
_currentgroupid = BA.ObjectToString(_params.GetDefault((Object)("groupId"),(Object)("")));
 //BA.debugLineNum = 105;BA.debugLine="CurrentGroupName = params.GetDefault(\"groupName\",";
_currentgroupname = BA.ObjectToString(_params.GetDefault((Object)("groupName"),(Object)("")));
 //BA.debugLineNum = 106;BA.debugLine="NoteType = params.GetDefault(\"noteType\", \"text\")";
_notetype = BA.ObjectToString(_params.GetDefault((Object)("noteType"),(Object)("text")));
 //BA.debugLineNum = 107;BA.debugLine="IsSecure = params.GetDefault(\"isSecure\", True)";
_issecure = BA.ObjectToBoolean(_params.GetDefault((Object)("isSecure"),(Object)(__c.True)));
 //BA.debugLineNum = 108;BA.debugLine="Passphrase = params.GetDefault(\"passphrase\", \"\")";
_passphrase = BA.ObjectToString(_params.GetDefault((Object)("passphrase"),(Object)("")));
 //BA.debugLineNum = 111;BA.debugLine="If Passphrase = \"\" And IsSecure Then";
if ((_passphrase).equals("") && _issecure) { 
 //BA.debugLineNum = 112;BA.debugLine="Passphrase = ModSession.GetPassphrase";
_passphrase = _modsession._getpassphrase /*String*/ (ba);
 };
 //BA.debugLineNum = 115;BA.debugLine="IsNewNote = (CurrentNoteId.Length = 0)";
_isnewnote = (_currentnoteid.length()==0);
 //BA.debugLineNum = 116;BA.debugLine="ItemsList.Initialize";
_itemslist.Initialize();
 //BA.debugLineNum = 117;BA.debugLine="ItemPanels.Initialize";
_itempanels.Initialize();
 //BA.debugLineNum = 118;BA.debugLine="CurrentFilter = \"\"  'Limpa filtro ao abrir";
_currentfilter = "";
 //BA.debugLineNum = 121;BA.debugLine="SetupModeUI";
_setupmodeui();
 //BA.debugLineNum = 123;BA.debugLine="If IsNewNote Then";
if (_isnewnote) { 
 //BA.debugLineNum = 124;BA.debugLine="edtTitle.Text = \"\"";
_edttitle.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 125;BA.debugLine="If NoteType = \"text\" Then";
if ((_notetype).equals("text")) { 
 //BA.debugLineNum = 126;BA.debugLine="edtContent.Text = \"\"";
_edtcontent.setText(BA.ObjectToCharSequence(""));
 };
 //BA.debugLineNum = 128;BA.debugLine="chkFavorite.Checked = False";
_chkfavorite.setChecked(__c.False);
 }else {
 //BA.debugLineNum = 130;BA.debugLine="LoadNote";
_loadnote();
 };
 //BA.debugLineNum = 132;BA.debugLine="End Sub";
return "";
}
public String  _setupmodeui() throws Exception{
 //BA.debugLineNum = 339;BA.debugLine="Private Sub SetupModeUI";
 //BA.debugLineNum = 340;BA.debugLine="If NoteType = \"list\" Then";
if ((_notetype).equals("list")) { 
 //BA.debugLineNum = 341;BA.debugLine="pnlTextMode.Visible = False";
_pnltextmode.setVisible(__c.False);
 //BA.debugLineNum = 342;BA.debugLine="pnlListMode.Visible = True";
_pnllistmode.setVisible(__c.True);
 //BA.debugLineNum = 343;BA.debugLine="lblIconAdd.Visible = True";
_lbliconadd.setVisible(__c.True);
 //BA.debugLineNum = 344;BA.debugLine="ivIconShare.Visible = True";
_iviconshare.setVisible(__c.True);
 //BA.debugLineNum = 345;BA.debugLine="RebuildItemsUI";
_rebuilditemsui();
 }else {
 //BA.debugLineNum = 347;BA.debugLine="pnlTextMode.Visible = True";
_pnltextmode.setVisible(__c.True);
 //BA.debugLineNum = 348;BA.debugLine="pnlListMode.Visible = False";
_pnllistmode.setVisible(__c.False);
 //BA.debugLineNum = 349;BA.debugLine="lblIconAdd.Visible = False  'Nao tem + para text";
_lbliconadd.setVisible(__c.False);
 //BA.debugLineNum = 350;BA.debugLine="ivIconShare.Visible = False  'Nao compartilha te";
_iviconshare.setVisible(__c.False);
 //BA.debugLineNum = 352;BA.debugLine="pnlContent.Height = 92dip + 350dip + 20dip";
_pnlcontent.setHeight((int) (__c.DipToCurrent((int) (92))+__c.DipToCurrent((int) (350))+__c.DipToCurrent((int) (20))));
 };
 //BA.debugLineNum = 356;BA.debugLine="ivIconDelete.Visible = Not(IsNewNote)";
_ivicondelete.setVisible(__c.Not(_isnewnote));
 //BA.debugLineNum = 357;BA.debugLine="End Sub";
return "";
}
public String  _shareitems(boolean _onlychecked) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
int _count = 0;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _item = null;
boolean _checked = false;
String _text = "";
anywheresoftware.b4a.objects.IntentWrapper _shareintent = null;
 //BA.debugLineNum = 917;BA.debugLine="Private Sub ShareItems(onlyChecked As Boolean)";
 //BA.debugLineNum = 918;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 919;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 920;BA.debugLine="sb.Append(edtTitle.Text.Trim).Append(Chr(10)).App";
_sb.Append(_edttitle.getText().trim()).Append(BA.ObjectToString(__c.Chr((int) (10)))).Append(BA.ObjectToString(__c.Chr((int) (10))));
 //BA.debugLineNum = 922;BA.debugLine="Dim count As Int = 0";
_count = (int) (0);
 //BA.debugLineNum = 923;BA.debugLine="For i = 0 To ItemsList.Size - 1";
{
final int step5 = 1;
final int limit5 = (int) (_itemslist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 924;BA.debugLine="Dim item As Map = ItemsList.Get(i)";
_item = new anywheresoftware.b4a.objects.collections.Map();
_item = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_itemslist.Get(_i)));
 //BA.debugLineNum = 925;BA.debugLine="Dim checked As Boolean = item.GetDefault(\"checke";
_checked = BA.ObjectToBoolean(_item.GetDefault((Object)("checked"),(Object)(__c.False)));
 //BA.debugLineNum = 926;BA.debugLine="Dim text As String = item.GetDefault(\"text\", \"\")";
_text = BA.ObjectToString(_item.GetDefault((Object)("text"),(Object)("")));
 //BA.debugLineNum = 928;BA.debugLine="If onlyChecked And checked = False Then Continue";
if (_onlychecked && _checked==__c.False) { 
if (true) continue;};
 //BA.debugLineNum = 930;BA.debugLine="If checked Then";
if (_checked) { 
 //BA.debugLineNum = 931;BA.debugLine="sb.Append(\"✓ \")";
_sb.Append("✓ ");
 }else {
 //BA.debugLineNum = 933;BA.debugLine="sb.Append(\"☐ \")";
_sb.Append("☐ ");
 };
 //BA.debugLineNum = 935;BA.debugLine="sb.Append(text).Append(Chr(10))";
_sb.Append(_text).Append(BA.ObjectToString(__c.Chr((int) (10))));
 //BA.debugLineNum = 936;BA.debugLine="count = count + 1";
_count = (int) (_count+1);
 }
};
 //BA.debugLineNum = 939;BA.debugLine="If count = 0 Then";
if (_count==0) { 
 //BA.debugLineNum = 940;BA.debugLine="ToastMessageShow(ModLang.T(\"empty\"), True)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"empty")),__c.True);
 //BA.debugLineNum = 941;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 945;BA.debugLine="Dim shareIntent As Intent";
_shareintent = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 946;BA.debugLine="shareIntent.Initialize(shareIntent.ACTION_SEND, \"";
_shareintent.Initialize(_shareintent.ACTION_SEND,"");
 //BA.debugLineNum = 947;BA.debugLine="shareIntent.SetType(\"text/plain\")";
_shareintent.SetType("text/plain");
 //BA.debugLineNum = 948;BA.debugLine="shareIntent.PutExtra(\"android.intent.extra.TEXT\",";
_shareintent.PutExtra("android.intent.extra.TEXT",(Object)(_sb.ToString()));
 //BA.debugLineNum = 949;BA.debugLine="StartActivity(shareIntent)";
__c.StartActivity(ba,(Object)(_shareintent.getObject()));
 //BA.debugLineNum = 950;BA.debugLine="End Sub";
return "";
}
public String  _showinputdialog(String _title,String _defaulttext,int _editindex) throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
 //BA.debugLineNum = 446;BA.debugLine="Private Sub ShowInputDialog(title As String, defau";
 //BA.debugLineNum = 447;BA.debugLine="EditingItemIndex = editIndex";
_editingitemindex = _editindex;
 //BA.debugLineNum = 450;BA.debugLine="Dim lblTitle As Label = pnlInputDialog.GetView(0)";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
_lbltitle = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_pnlinputdialog.GetView((int) (0)).getObject()));
 //BA.debugLineNum = 451;BA.debugLine="lblTitle.Text = title";
_lbltitle.setText(BA.ObjectToCharSequence(_title));
 //BA.debugLineNum = 454;BA.debugLine="edtItemText.Text = defaultText";
_edtitemtext.setText(BA.ObjectToCharSequence(_defaulttext));
 //BA.debugLineNum = 457;BA.debugLine="pnlInputOverlay.Visible = True";
_pnlinputoverlay.setVisible(__c.True);
 //BA.debugLineNum = 458;BA.debugLine="pnlInputOverlay.BringToFront";
_pnlinputoverlay.BringToFront();
 //BA.debugLineNum = 459;BA.debugLine="edtItemText.RequestFocus";
_edtitemtext.RequestFocus();
 //BA.debugLineNum = 460;BA.debugLine="End Sub";
return "";
}
public String  _sortitemscheckedfirst() throws Exception{
int _i = 0;
int _j = 0;
anywheresoftware.b4a.objects.collections.Map _item1 = null;
anywheresoftware.b4a.objects.collections.Map _item2 = null;
boolean _checked1 = false;
boolean _checked2 = false;
 //BA.debugLineNum = 693;BA.debugLine="Private Sub SortItemsCheckedFirst";
 //BA.debugLineNum = 694;BA.debugLine="If ItemsList.Size < 2 Then Return";
if (_itemslist.getSize()<2) { 
if (true) return "";};
 //BA.debugLineNum = 697;BA.debugLine="For i = 0 To ItemsList.Size - 2";
{
final int step2 = 1;
final int limit2 = (int) (_itemslist.getSize()-2);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 698;BA.debugLine="For j = 0 To ItemsList.Size - 2 - i";
{
final int step3 = 1;
final int limit3 = (int) (_itemslist.getSize()-2-_i);
_j = (int) (0) ;
for (;_j <= limit3 ;_j = _j + step3 ) {
 //BA.debugLineNum = 699;BA.debugLine="Dim item1 As Map = ItemsList.Get(j)";
_item1 = new anywheresoftware.b4a.objects.collections.Map();
_item1 = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_itemslist.Get(_j)));
 //BA.debugLineNum = 700;BA.debugLine="Dim item2 As Map = ItemsList.Get(j + 1)";
_item2 = new anywheresoftware.b4a.objects.collections.Map();
_item2 = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_itemslist.Get((int) (_j+1))));
 //BA.debugLineNum = 701;BA.debugLine="Dim checked1 As Boolean = item1.GetDefault(\"che";
_checked1 = BA.ObjectToBoolean(_item1.GetDefault((Object)("checked"),(Object)(__c.False)));
 //BA.debugLineNum = 702;BA.debugLine="Dim checked2 As Boolean = item2.GetDefault(\"che";
_checked2 = BA.ObjectToBoolean(_item2.GetDefault((Object)("checked"),(Object)(__c.False)));
 //BA.debugLineNum = 705;BA.debugLine="If checked1 = False And checked2 = True Then";
if (_checked1==__c.False && _checked2==__c.True) { 
 //BA.debugLineNum = 706;BA.debugLine="ItemsList.Set(j, item2)";
_itemslist.Set(_j,(Object)(_item2.getObject()));
 //BA.debugLineNum = 707;BA.debugLine="ItemsList.Set(j + 1, item1)";
_itemslist.Set((int) (_j+1),(Object)(_item1.getObject()));
 };
 }
};
 }
};
 //BA.debugLineNum = 711;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
