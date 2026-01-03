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
public boolean _iscardtemplate = false;
public anywheresoftware.b4a.objects.ImageViewWrapper _iviconattach = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlattachments = null;
public anywheresoftware.b4a.objects.collections.List _attachmentslist = null;
public anywheresoftware.b4a.phone.Phone.ContentChooser _contentchooser1 = null;
public String _pendingattachuri = "";
public anywheresoftware.b4a.objects.EditTextWrapper _edtattachname = null;
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
 //BA.debugLineNum = 1805;BA.debugLine="Private Sub ApplyTheme";
 //BA.debugLineNum = 1806;BA.debugLine="Root.Color = ModTheme.HomeBg";
_root.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 1807;BA.debugLine="svContent.Color = ModTheme.HomeBg";
_svcontent.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 1808;BA.debugLine="pnlContent.Color = ModTheme.HomeBg";
_pnlcontent.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 1811;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 1812;BA.debugLine="cd.Initialize2(ModTheme.HomeHeaderBg, 8dip, 1dip,";
_cd.Initialize2(_modtheme._homeheaderbg /*int*/ (ba),__c.DipToCurrent((int) (8)),__c.DipToCurrent((int) (1)),__c.Colors.ARGB((int) (80),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 1814;BA.debugLine="edtTitle.Background = cd";
_edttitle.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 //BA.debugLineNum = 1815;BA.debugLine="edtTitle.TextColor = Colors.White";
_edttitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 1816;BA.debugLine="edtTitle.HintColor = Colors.ARGB(120, 255, 255, 2";
_edttitle.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 1818;BA.debugLine="edtContent.Background = cd";
_edtcontent.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 //BA.debugLineNum = 1819;BA.debugLine="edtContent.TextColor = Colors.White";
_edtcontent.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 1820;BA.debugLine="edtContent.HintColor = Colors.ARGB(120, 255, 255,";
_edtcontent.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 1822;BA.debugLine="chkFavorite.TextColor = Colors.White";
_chkfavorite.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 1823;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_appear() throws Exception{
String _lastpart = "";
com.lockzero.clsnotegroup _group = null;
String _breadcrumb = "";
 //BA.debugLineNum = 88;BA.debugLine="Private Sub B4XPage_Appear";
 //BA.debugLineNum = 90;BA.debugLine="Dim lastPart As String";
_lastpart = "";
 //BA.debugLineNum = 91;BA.debugLine="If IsNewNote Then";
if (_isnewnote) { 
 //BA.debugLineNum = 93;BA.debugLine="Dim group As clsNoteGroup = ModNotes.GetNoteGrou";
_group = _modnotes._getnotegroupbyid /*com.lockzero.clsnotegroup*/ (ba,_currentgroupid);
 //BA.debugLineNum = 94;BA.debugLine="If group <> Null And group.TemplateType = \"card\"";
if (_group!= null && (_group._templatetype /*String*/ ).equals("card")) { 
 //BA.debugLineNum = 95;BA.debugLine="lastPart = ModLang.T(\"new_card\")";
_lastpart = _modlang._t /*String*/ (ba,"new_card");
 }else if((_notetype).equals("list")) { 
 //BA.debugLineNum = 97;BA.debugLine="lastPart = ModLang.T(\"new_list\")";
_lastpart = _modlang._t /*String*/ (ba,"new_list");
 }else {
 //BA.debugLineNum = 99;BA.debugLine="lastPart = ModLang.T(\"new_text\")";
_lastpart = _modlang._t /*String*/ (ba,"new_text");
 };
 }else {
 //BA.debugLineNum = 103;BA.debugLine="lastPart = CurrentNoteTitle";
_lastpart = _currentnotetitle;
 //BA.debugLineNum = 104;BA.debugLine="If lastPart.Length > 15 Then lastPart = lastPart";
if (_lastpart.length()>15) { 
_lastpart = _lastpart.substring((int) (0),(int) (15))+"...";};
 };
 //BA.debugLineNum = 108;BA.debugLine="Dim breadcrumb As String = ModLang.T(\"notes\") & \"";
_breadcrumb = _modlang._t /*String*/ (ba,"notes")+" → "+_currentgroupname+" → "+_lastpart;
 //BA.debugLineNum = 109;BA.debugLine="lblHeaderTitle.Text = breadcrumb";
_lblheadertitle.setText(BA.ObjectToCharSequence(_breadcrumb));
 //BA.debugLineNum = 110;BA.debugLine="CallSub2(Main, \"SetPageTitle\", lastPart)";
__c.CallSubNew2(ba,(Object)(_main.getObject()),"SetPageTitle",(Object)(_lastpart));
 //BA.debugLineNum = 113;BA.debugLine="If IsSecure Then ModSession.Touch";
if (_issecure) { 
_modsession._touch /*String*/ (ba);};
 //BA.debugLineNum = 114;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
 //BA.debugLineNum = 82;BA.debugLine="Private Sub B4XPage_Created(Root1 As B4XView)";
 //BA.debugLineNum = 83;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 84;BA.debugLine="CreateUI";
_createui();
 //BA.debugLineNum = 85;BA.debugLine="ApplyTheme";
_applytheme();
 //BA.debugLineNum = 86;BA.debugLine="End Sub";
return "";
}
public void  _btnback_click() throws Exception{
ResumableSub_btnBack_Click rsub = new ResumableSub_btnBack_Click(this);
rsub.resume(ba, null);
}
public static class ResumableSub_btnBack_Click extends BA.ResumableSub {
public ResumableSub_btnBack_Click(com.lockzero.pagenoteedit parent) {
this.parent = parent;
}
com.lockzero.pagenoteedit parent;
boolean _hasdata = false;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _item = null;
String _text = "";
int _colonpos = 0;
String _value = "";
int _result = 0;
int step3;
int limit3;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 1352;BA.debugLine="If IsCardTemplate And IsNewNote Then";
if (true) break;

case 1:
//if
this.state = 25;
if (parent._iscardtemplate && parent._isnewnote) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 1354;BA.debugLine="Dim hasData As Boolean = False";
_hasdata = parent.__c.False;
 //BA.debugLineNum = 1355;BA.debugLine="For i = 0 To ItemsList.Size - 1";
if (true) break;

case 4:
//for
this.state = 15;
step3 = 1;
limit3 = (int) (parent._itemslist.getSize()-1);
_i = (int) (0) ;
this.state = 26;
if (true) break;

case 26:
//C
this.state = 15;
if ((step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3)) this.state = 6;
if (true) break;

case 27:
//C
this.state = 26;
_i = ((int)(0 + _i + step3)) ;
if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 1356;BA.debugLine="Dim item As Map = ItemsList.Get(i)";
_item = new anywheresoftware.b4a.objects.collections.Map();
_item = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(parent._itemslist.Get(_i)));
 //BA.debugLineNum = 1357;BA.debugLine="Dim text As String = item.GetDefault(\"text\", \"\"";
_text = BA.ObjectToString(_item.GetDefault((Object)("text"),(Object)("")));
 //BA.debugLineNum = 1358;BA.debugLine="Dim colonPos As Int = text.IndexOf(\":\")";
_colonpos = _text.indexOf(":");
 //BA.debugLineNum = 1359;BA.debugLine="If colonPos > 0 Then";
if (true) break;

case 7:
//if
this.state = 14;
if (_colonpos>0) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 1360;BA.debugLine="Dim value As String = text.SubString(colonPos";
_value = _text.substring((int) (_colonpos+1)).trim();
 //BA.debugLineNum = 1361;BA.debugLine="If value.Length > 0 Then";
if (true) break;

case 10:
//if
this.state = 13;
if (_value.length()>0) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
 //BA.debugLineNum = 1362;BA.debugLine="hasData = True";
_hasdata = parent.__c.True;
 //BA.debugLineNum = 1363;BA.debugLine="Exit";
this.state = 15;
if (true) break;
 if (true) break;

case 13:
//C
this.state = 14;
;
 if (true) break;

case 14:
//C
this.state = 27;
;
 if (true) break;
if (true) break;
;
 //BA.debugLineNum = 1368;BA.debugLine="If hasData Then";

case 15:
//if
this.state = 24;
if (_hasdata) { 
this.state = 17;
}if (true) break;

case 17:
//C
this.state = 18;
 //BA.debugLineNum = 1369;BA.debugLine="Wait For (xui.Msgbox2Async(ModLang.T(\"discard_c";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"discard_changes")),BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"confirm")),parent._modlang._t /*String*/ (ba,"discard"),"",parent._modlang._t /*String*/ (ba,"cancel"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 28;
return;
case 28:
//C
this.state = 18;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 1370;BA.debugLine="If Result <> xui.DialogResponse_Positive Then R";
if (true) break;

case 18:
//if
this.state = 23;
if (_result!=parent._xui.DialogResponse_Positive) { 
this.state = 20;
;}if (true) break;

case 20:
//C
this.state = 23;
if (true) return ;
if (true) break;

case 23:
//C
this.state = 24;
;
 if (true) break;

case 24:
//C
this.state = 25;
;
 if (true) break;

case 25:
//C
this.state = -1;
;
 //BA.debugLineNum = 1374;BA.debugLine="B4XPages.ClosePage(Me)";
parent._b4xpages._closepage /*String*/ (ba,parent);
 //BA.debugLineNum = 1375;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _msgbox_result(int _result) throws Exception{
}
public String  _btninputaddmore_click() throws Exception{
String _text = "";
anywheresoftware.b4a.objects.collections.Map _newitem = null;
anywheresoftware.b4a.objects.collections.Map _item = null;
 //BA.debugLineNum = 559;BA.debugLine="Private Sub btnInputAddMore_Click";
 //BA.debugLineNum = 560;BA.debugLine="Dim text As String = edtItemText.Text.Trim";
_text = _edtitemtext.getText().trim();
 //BA.debugLineNum = 561;BA.debugLine="If text.Length = 0 Then";
if (_text.length()==0) { 
 //BA.debugLineNum = 562;BA.debugLine="ToastMessageShow(ModLang.T(\"error_empty_field\"),";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error_empty_field")),__c.True);
 //BA.debugLineNum = 563;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 566;BA.debugLine="If EditingItemIndex = -1 Then";
if (_editingitemindex==-1) { 
 //BA.debugLineNum = 568;BA.debugLine="Dim newItem As Map";
_newitem = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 569;BA.debugLine="newItem.Initialize";
_newitem.Initialize();
 //BA.debugLineNum = 570;BA.debugLine="newItem.Put(\"text\", text)";
_newitem.Put((Object)("text"),(Object)(_text));
 //BA.debugLineNum = 571;BA.debugLine="newItem.Put(\"checked\", False)";
_newitem.Put((Object)("checked"),(Object)(__c.False));
 //BA.debugLineNum = 572;BA.debugLine="ItemsList.Add(newItem)";
_itemslist.Add((Object)(_newitem.getObject()));
 }else {
 //BA.debugLineNum = 575;BA.debugLine="If EditingItemIndex >= 0 And EditingItemIndex <";
if (_editingitemindex>=0 && _editingitemindex<_itemslist.getSize()) { 
 //BA.debugLineNum = 576;BA.debugLine="Dim item As Map = ItemsList.Get(EditingItemInde";
_item = new anywheresoftware.b4a.objects.collections.Map();
_item = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_itemslist.Get(_editingitemindex)));
 //BA.debugLineNum = 577;BA.debugLine="item.Put(\"text\", text)";
_item.Put((Object)("text"),(Object)(_text));
 };
 };
 //BA.debugLineNum = 581;BA.debugLine="RebuildItemsUI";
_rebuilditemsui();
 //BA.debugLineNum = 584;BA.debugLine="edtItemText.Text = \"\"";
_edtitemtext.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 585;BA.debugLine="EditingItemIndex = -1  'Proximo sera novo item";
_editingitemindex = (int) (-1);
 //BA.debugLineNum = 586;BA.debugLine="edtItemText.RequestFocus";
_edtitemtext.RequestFocus();
 //BA.debugLineNum = 587;BA.debugLine="End Sub";
return "";
}
public String  _btninputcancel_click() throws Exception{
 //BA.debugLineNum = 554;BA.debugLine="Private Sub btnInputCancel_Click";
 //BA.debugLineNum = 555;BA.debugLine="HideInputDialog";
_hideinputdialog();
 //BA.debugLineNum = 556;BA.debugLine="End Sub";
return "";
}
public String  _btninputsaveexit_click() throws Exception{
String _text = "";
anywheresoftware.b4a.objects.collections.Map _newitem = null;
anywheresoftware.b4a.objects.collections.Map _item = null;
 //BA.debugLineNum = 590;BA.debugLine="Private Sub btnInputSaveExit_Click";
 //BA.debugLineNum = 591;BA.debugLine="Dim text As String = edtItemText.Text.Trim";
_text = _edtitemtext.getText().trim();
 //BA.debugLineNum = 592;BA.debugLine="If text.Length = 0 Then";
if (_text.length()==0) { 
 //BA.debugLineNum = 593;BA.debugLine="ToastMessageShow(ModLang.T(\"error_empty_field\"),";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error_empty_field")),__c.True);
 //BA.debugLineNum = 594;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 597;BA.debugLine="If EditingItemIndex = -1 Then";
if (_editingitemindex==-1) { 
 //BA.debugLineNum = 599;BA.debugLine="Dim newItem As Map";
_newitem = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 600;BA.debugLine="newItem.Initialize";
_newitem.Initialize();
 //BA.debugLineNum = 601;BA.debugLine="newItem.Put(\"text\", text)";
_newitem.Put((Object)("text"),(Object)(_text));
 //BA.debugLineNum = 602;BA.debugLine="newItem.Put(\"checked\", False)";
_newitem.Put((Object)("checked"),(Object)(__c.False));
 //BA.debugLineNum = 603;BA.debugLine="ItemsList.Add(newItem)";
_itemslist.Add((Object)(_newitem.getObject()));
 }else {
 //BA.debugLineNum = 606;BA.debugLine="If EditingItemIndex >= 0 And EditingItemIndex <";
if (_editingitemindex>=0 && _editingitemindex<_itemslist.getSize()) { 
 //BA.debugLineNum = 607;BA.debugLine="Dim item As Map = ItemsList.Get(EditingItemInde";
_item = new anywheresoftware.b4a.objects.collections.Map();
_item = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_itemslist.Get(_editingitemindex)));
 //BA.debugLineNum = 608;BA.debugLine="item.Put(\"text\", text)";
_item.Put((Object)("text"),(Object)(_text));
 };
 };
 //BA.debugLineNum = 612;BA.debugLine="HideInputDialog";
_hideinputdialog();
 //BA.debugLineNum = 613;BA.debugLine="RebuildItemsUI";
_rebuilditemsui();
 //BA.debugLineNum = 614;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 1044;BA.debugLine="If IsRebuildingUI Then Return";
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
 //BA.debugLineNum = 1046;BA.debugLine="Dim chk As CheckBox = Sender";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
_chk = (anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper(), (android.widget.CheckBox)(parent.__c.Sender(ba)));
 //BA.debugLineNum = 1047;BA.debugLine="Dim index As Int = chk.Tag";
_index = (int)(BA.ObjectToNumber(_chk.getTag()));
 //BA.debugLineNum = 1049;BA.debugLine="If index >= 0 And index < ItemsList.Size Then";
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
 //BA.debugLineNum = 1050;BA.debugLine="Dim item As Map = ItemsList.Get(index)";
_item = new anywheresoftware.b4a.objects.collections.Map();
_item = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(parent._itemslist.Get(_index)));
 //BA.debugLineNum = 1051;BA.debugLine="item.Put(\"checked\", Checked)";
_item.Put((Object)("checked"),(Object)(_checked));
 //BA.debugLineNum = 1054;BA.debugLine="Sleep(300)";
parent.__c.Sleep(ba,this,(int) (300));
this.state = 11;
return;
case 11:
//C
this.state = 10;
;
 //BA.debugLineNum = 1055;BA.debugLine="SortItemsCheckedFirst";
parent._sortitemscheckedfirst();
 //BA.debugLineNum = 1056;BA.debugLine="RebuildItemsUI";
parent._rebuilditemsui();
 if (true) break;

case 10:
//C
this.state = -1;
;
 //BA.debugLineNum = 1058;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 65;BA.debugLine="Private IsCardTemplate As Boolean = False";
_iscardtemplate = __c.False;
 //BA.debugLineNum = 68;BA.debugLine="Private ivIconAttach As ImageView  'Icone de anex";
_iviconattach = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 69;BA.debugLine="Private pnlAttachments As Panel    'Container par";
_pnlattachments = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 70;BA.debugLine="Private AttachmentsList As List    'Lista de cami";
_attachmentslist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 71;BA.debugLine="Private ContentChooser1 As ContentChooser  'Para";
_contentchooser1 = new anywheresoftware.b4a.phone.Phone.ContentChooser();
 //BA.debugLineNum = 72;BA.debugLine="Private PendingAttachUri As String  'URI temporar";
_pendingattachuri = "";
 //BA.debugLineNum = 73;BA.debugLine="Private edtAttachName As EditText  'Campo para no";
_edtattachname = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 74;BA.debugLine="End Sub";
return "";
}
public void  _contentchooser1_result(boolean _success,String _dir,String _filename) throws Exception{
ResumableSub_ContentChooser1_Result rsub = new ResumableSub_ContentChooser1_Result(this,_success,_dir,_filename);
rsub.resume(ba, null);
}
public static class ResumableSub_ContentChooser1_Result extends BA.ResumableSub {
public ResumableSub_ContentChooser1_Result(com.lockzero.pagenoteedit parent,boolean _success,String _dir,String _filename) {
this.parent = parent;
this._success = _success;
this._dir = _dir;
this._filename = _filename;
}
com.lockzero.pagenoteedit parent;
boolean _success;
String _dir;
String _filename;
String _suggestedname = "";
anywheresoftware.b4a.objects.B4XViewWrapper _pnldialog = null;
com.lockzero.b4xdialog _dlg = null;
int _dialogresult = 0;
String _attachname = "";
int _i = 0;
Object _item = null;
String _existingname = "";
anywheresoftware.b4a.objects.collections.Map _existing = null;
anywheresoftware.b4a.objects.collections.Map _attachment = null;
int step40;
int limit40;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 1497;BA.debugLine="If Success = False Then Return";
if (true) break;

case 1:
//if
this.state = 6;
if (_success==parent.__c.False) { 
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
 //BA.debugLineNum = 1500;BA.debugLine="If Dir.StartsWith(\"content\") Then";
if (true) break;

case 7:
//if
this.state = 14;
if (_dir.startsWith("content")) { 
this.state = 9;
}else if(_filename.startsWith("content")) { 
this.state = 11;
}else {
this.state = 13;
}if (true) break;

case 9:
//C
this.state = 14;
 //BA.debugLineNum = 1501;BA.debugLine="PendingAttachUri = Dir";
parent._pendingattachuri = _dir;
 if (true) break;

case 11:
//C
this.state = 14;
 //BA.debugLineNum = 1503;BA.debugLine="PendingAttachUri = FileName";
parent._pendingattachuri = _filename;
 if (true) break;

case 13:
//C
this.state = 14;
 //BA.debugLineNum = 1505;BA.debugLine="PendingAttachUri = File.Combine(Dir, FileName)";
parent._pendingattachuri = parent.__c.File.Combine(_dir,_filename);
 if (true) break;

case 14:
//C
this.state = 15;
;
 //BA.debugLineNum = 1509;BA.debugLine="Dim suggestedName As String = \"\"";
_suggestedname = "";
 //BA.debugLineNum = 1510;BA.debugLine="If FileName.Contains(\"/\") Then";
if (true) break;

case 15:
//if
this.state = 20;
if (_filename.contains("/")) { 
this.state = 17;
}else if(_filename.contains("%2F")) { 
this.state = 19;
}if (true) break;

case 17:
//C
this.state = 20;
 //BA.debugLineNum = 1511;BA.debugLine="suggestedName = FileName.SubString(FileName.Last";
_suggestedname = _filename.substring((int) (_filename.lastIndexOf("/")+1));
 if (true) break;

case 19:
//C
this.state = 20;
 //BA.debugLineNum = 1513;BA.debugLine="suggestedName = FileName.SubString(FileName.Last";
_suggestedname = _filename.substring((int) (_filename.lastIndexOf("%2F")+3));
 if (true) break;
;
 //BA.debugLineNum = 1517;BA.debugLine="If suggestedName.Contains(\"?\") Then";

case 20:
//if
this.state = 23;
if (_suggestedname.contains("?")) { 
this.state = 22;
}if (true) break;

case 22:
//C
this.state = 23;
 //BA.debugLineNum = 1518;BA.debugLine="suggestedName = suggestedName.SubString2(0, sugg";
_suggestedname = _suggestedname.substring((int) (0),_suggestedname.indexOf("?"));
 if (true) break;
;
 //BA.debugLineNum = 1522;BA.debugLine="If suggestedName = \"\" Or suggestedName.StartsWith";

case 23:
//if
this.state = 26;
if ((_suggestedname).equals("") || _suggestedname.startsWith("content")) { 
this.state = 25;
}if (true) break;

case 25:
//C
this.state = 26;
 //BA.debugLineNum = 1523;BA.debugLine="suggestedName = \"arquivo\"";
_suggestedname = "arquivo";
 if (true) break;

case 26:
//C
this.state = 27;
;
 //BA.debugLineNum = 1527;BA.debugLine="Dim pnlDialog As B4XView = xui.CreatePanel(\"\")";
_pnldialog = new anywheresoftware.b4a.objects.B4XViewWrapper();
_pnldialog = parent._xui.CreatePanel(ba,"");
 //BA.debugLineNum = 1528;BA.debugLine="pnlDialog.SetLayoutAnimated(0, 0, 0, 280dip, 60di";
_pnldialog.SetLayoutAnimated((int) (0),(int) (0),(int) (0),parent.__c.DipToCurrent((int) (280)),parent.__c.DipToCurrent((int) (60)));
 //BA.debugLineNum = 1529;BA.debugLine="pnlDialog.Color = ModTheme.HomeHeaderBg";
_pnldialog.setColor(parent._modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 1531;BA.debugLine="edtAttachName.Initialize(\"\")";
parent._edtattachname.Initialize(ba,"");
 //BA.debugLineNum = 1532;BA.debugLine="edtAttachName.Text = suggestedName";
parent._edtattachname.setText(BA.ObjectToCharSequence(_suggestedname));
 //BA.debugLineNum = 1533;BA.debugLine="edtAttachName.Hint = ModLang.T(\"attachment_name\")";
parent._edtattachname.setHint(parent._modlang._t /*String*/ (ba,"attachment_name"));
 //BA.debugLineNum = 1534;BA.debugLine="edtAttachName.SingleLine = True";
parent._edtattachname.setSingleLine(parent.__c.True);
 //BA.debugLineNum = 1535;BA.debugLine="edtAttachName.TextSize = Starter.FONT_INPUT";
parent._edtattachname.setTextSize(parent._starter._font_input /*float*/ );
 //BA.debugLineNum = 1536;BA.debugLine="edtAttachName.TextColor = Colors.White";
parent._edtattachname.setTextColor(parent.__c.Colors.White);
 //BA.debugLineNum = 1537;BA.debugLine="edtAttachName.HintColor = Colors.ARGB(120, 255, 2";
parent._edtattachname.setHintColor(parent.__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 1538;BA.debugLine="pnlDialog.AddView(edtAttachName, 10dip, 10dip, 26";
_pnldialog.AddView((android.view.View)(parent._edtattachname.getObject()),parent.__c.DipToCurrent((int) (10)),parent.__c.DipToCurrent((int) (10)),parent.__c.DipToCurrent((int) (260)),parent.__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 1541;BA.debugLine="Dim dlg As B4XDialog";
_dlg = new com.lockzero.b4xdialog();
 //BA.debugLineNum = 1542;BA.debugLine="dlg.Initialize(Root)";
_dlg._initialize /*String*/ (ba,parent._root);
 //BA.debugLineNum = 1543;BA.debugLine="dlg.Title = ModLang.T(\"attachment_name\")";
_dlg._title /*Object*/  = (Object)(parent._modlang._t /*String*/ (ba,"attachment_name"));
 //BA.debugLineNum = 1546;BA.debugLine="CallSubDelayed(Me, \"FocusAttachInput\")";
parent.__c.CallSubDelayed(ba,parent,"FocusAttachInput");
 //BA.debugLineNum = 1548;BA.debugLine="Wait For (dlg.ShowCustom(pnlDialog, \"OK\", \"\", Mod";
parent.__c.WaitFor("complete", ba, this, _dlg._showcustom /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (_pnldialog,(Object)("OK"),(Object)(""),(Object)(parent._modlang._t /*String*/ (ba,"cancel"))));
this.state = 48;
return;
case 48:
//C
this.state = 27;
_dialogresult = (Integer) result[0];
;
 //BA.debugLineNum = 1550;BA.debugLine="If dialogResult = xui.DialogResponse_Positive The";
if (true) break;

case 27:
//if
this.state = 47;
if (_dialogresult==parent._xui.DialogResponse_Positive) { 
this.state = 29;
}if (true) break;

case 29:
//C
this.state = 30;
 //BA.debugLineNum = 1551;BA.debugLine="Dim attachName As String = edtAttachName.Text.Tr";
_attachname = parent._edtattachname.getText().trim();
 //BA.debugLineNum = 1552;BA.debugLine="If attachName = \"\" Then attachName = suggestedNa";
if (true) break;

case 30:
//if
this.state = 35;
if ((_attachname).equals("")) { 
this.state = 32;
;}if (true) break;

case 32:
//C
this.state = 35;
_attachname = _suggestedname;
if (true) break;

case 35:
//C
this.state = 36;
;
 //BA.debugLineNum = 1555;BA.debugLine="For i = 0 To AttachmentsList.Size - 1";
if (true) break;

case 36:
//for
this.state = 46;
step40 = 1;
limit40 = (int) (parent._attachmentslist.getSize()-1);
_i = (int) (0) ;
this.state = 49;
if (true) break;

case 49:
//C
this.state = 46;
if ((step40 > 0 && _i <= limit40) || (step40 < 0 && _i >= limit40)) this.state = 38;
if (true) break;

case 50:
//C
this.state = 49;
_i = ((int)(0 + _i + step40)) ;
if (true) break;

case 38:
//C
this.state = 39;
 //BA.debugLineNum = 1556;BA.debugLine="Dim item As Object = AttachmentsList.Get(i)";
_item = parent._attachmentslist.Get(_i);
 //BA.debugLineNum = 1557;BA.debugLine="Dim existingName As String = \"\"";
_existingname = "";
 //BA.debugLineNum = 1558;BA.debugLine="If item Is Map Then";
if (true) break;

case 39:
//if
this.state = 42;
if (_item instanceof java.util.Map) { 
this.state = 41;
}if (true) break;

case 41:
//C
this.state = 42;
 //BA.debugLineNum = 1559;BA.debugLine="Dim existing As Map = item";
_existing = new anywheresoftware.b4a.objects.collections.Map();
_existing = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_item));
 //BA.debugLineNum = 1560;BA.debugLine="existingName = existing.GetDefault(\"name\", \"\")";
_existingname = BA.ObjectToString(_existing.GetDefault((Object)("name"),(Object)("")));
 if (true) break;
;
 //BA.debugLineNum = 1562;BA.debugLine="If existingName = attachName Then";

case 42:
//if
this.state = 45;
if ((_existingname).equals(_attachname)) { 
this.state = 44;
}if (true) break;

case 44:
//C
this.state = 45;
 //BA.debugLineNum = 1563;BA.debugLine="ToastMessageShow(ModLang.T(\"file_exists\"), Fal";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"file_exists")),parent.__c.False);
 //BA.debugLineNum = 1564;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 45:
//C
this.state = 50;
;
 if (true) break;
if (true) break;

case 46:
//C
this.state = 47;
;
 //BA.debugLineNum = 1569;BA.debugLine="Dim attachment As Map";
_attachment = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 1570;BA.debugLine="attachment.Initialize";
_attachment.Initialize();
 //BA.debugLineNum = 1571;BA.debugLine="attachment.Put(\"uri\", PendingAttachUri)";
_attachment.Put((Object)("uri"),(Object)(parent._pendingattachuri));
 //BA.debugLineNum = 1572;BA.debugLine="attachment.Put(\"name\", attachName)";
_attachment.Put((Object)("name"),(Object)(_attachname));
 //BA.debugLineNum = 1573;BA.debugLine="AttachmentsList.Add(attachment)";
parent._attachmentslist.Add((Object)(_attachment.getObject()));
 //BA.debugLineNum = 1574;BA.debugLine="RebuildAttachmentsUI";
parent._rebuildattachmentsui();
 //BA.debugLineNum = 1575;BA.debugLine="ToastMessageShow(ModLang.T(\"attachment_added\"),";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"attachment_added")),parent.__c.False);
 if (true) break;

case 47:
//C
this.state = -1;
;
 //BA.debugLineNum = 1577;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _complete(int _dialogresult) throws Exception{
}
public anywheresoftware.b4a.objects.PanelWrapper  _createattachmentpanel(int _index,String _filename,int _panelwidth) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xv = null;
String _displayname = "";
anywheresoftware.b4a.objects.LabelWrapper _lblicon = null;
anywheresoftware.b4a.objects.LabelWrapper _lblfilename = null;
anywheresoftware.b4a.objects.LabelWrapper _lblremove = null;
 //BA.debugLineNum = 1649;BA.debugLine="Private Sub CreateAttachmentPanel(index As Int, fi";
 //BA.debugLineNum = 1650;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 1651;BA.debugLine="pnl.Initialize(\"pnlAttachment\")";
_pnl.Initialize(ba,"pnlAttachment");
 //BA.debugLineNum = 1652;BA.debugLine="pnl.Tag = index";
_pnl.setTag((Object)(_index));
 //BA.debugLineNum = 1654;BA.debugLine="Dim xv As B4XView = pnl";
_xv = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xv = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnl.getObject()));
 //BA.debugLineNum = 1655;BA.debugLine="xv.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModT";
_xv.SetColorAndBorder(_modtheme._homeiconbg /*int*/ (ba),(int) (0),_modtheme._homeiconbg /*int*/ (ba),__c.DipToCurrent((int) (8)));
 //BA.debugLineNum = 1658;BA.debugLine="Dim displayName As String = fileName";
_displayname = _filename;
 //BA.debugLineNum = 1659;BA.debugLine="If displayName.Length > 30 Then displayName = dis";
if (_displayname.length()>30) { 
_displayname = _displayname.substring((int) (0),(int) (27))+"...";};
 //BA.debugLineNum = 1662;BA.debugLine="Dim lblIcon As Label";
_lblicon = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 1663;BA.debugLine="lblIcon.Initialize(\"\")";
_lblicon.Initialize(ba,"");
 //BA.debugLineNum = 1664;BA.debugLine="lblIcon.Text = Chr(0x1F4CE)  'Paperclip emoji";
_lblicon.setText(BA.ObjectToCharSequence(__c.Chr(((int)0x1f4ce))));
 //BA.debugLineNum = 1665;BA.debugLine="lblIcon.TextSize = 18";
_lblicon.setTextSize((float) (18));
 //BA.debugLineNum = 1666;BA.debugLine="lblIcon.Gravity = Gravity.CENTER";
_lblicon.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 1667;BA.debugLine="pnl.AddView(lblIcon, 8dip, 0, 30dip, 44dip)";
_pnl.AddView((android.view.View)(_lblicon.getObject()),__c.DipToCurrent((int) (8)),(int) (0),__c.DipToCurrent((int) (30)),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 1670;BA.debugLine="Dim lblFileName As Label";
_lblfilename = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 1671;BA.debugLine="lblFileName.Initialize(\"lblAttachOpen\")";
_lblfilename.Initialize(ba,"lblAttachOpen");
 //BA.debugLineNum = 1672;BA.debugLine="lblFileName.Tag = index";
_lblfilename.setTag((Object)(_index));
 //BA.debugLineNum = 1673;BA.debugLine="lblFileName.Text = displayName";
_lblfilename.setText(BA.ObjectToCharSequence(_displayname));
 //BA.debugLineNum = 1674;BA.debugLine="lblFileName.TextSize = Starter.FONT_BODY";
_lblfilename.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 1675;BA.debugLine="lblFileName.TextColor = Colors.RGB(100, 180, 255)";
_lblfilename.setTextColor(__c.Colors.RGB((int) (100),(int) (180),(int) (255)));
 //BA.debugLineNum = 1676;BA.debugLine="lblFileName.Gravity = Gravity.CENTER_VERTICAL";
_lblfilename.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 1677;BA.debugLine="pnl.AddView(lblFileName, 42dip, 0, panelWidth - 1";
_pnl.AddView((android.view.View)(_lblfilename.getObject()),__c.DipToCurrent((int) (42)),(int) (0),(int) (_panelwidth-__c.DipToCurrent((int) (100))),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 1680;BA.debugLine="Dim lblRemove As Label";
_lblremove = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 1681;BA.debugLine="lblRemove.Initialize(\"lblAttachRemove\")";
_lblremove.Initialize(ba,"lblAttachRemove");
 //BA.debugLineNum = 1682;BA.debugLine="lblRemove.Tag = index";
_lblremove.setTag((Object)(_index));
 //BA.debugLineNum = 1683;BA.debugLine="lblRemove.Text = \"X\"";
_lblremove.setText(BA.ObjectToCharSequence("X"));
 //BA.debugLineNum = 1684;BA.debugLine="lblRemove.TextSize = 16";
_lblremove.setTextSize((float) (16));
 //BA.debugLineNum = 1685;BA.debugLine="lblRemove.TextColor = Colors.RGB(255, 100, 100)";
_lblremove.setTextColor(__c.Colors.RGB((int) (255),(int) (100),(int) (100)));
 //BA.debugLineNum = 1686;BA.debugLine="lblRemove.Gravity = Gravity.CENTER";
_lblremove.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 1687;BA.debugLine="pnl.AddView(lblRemove, panelWidth - 44dip, 0, 40d";
_pnl.AddView((android.view.View)(_lblremove.getObject()),(int) (_panelwidth-__c.DipToCurrent((int) (44))),(int) (0),__c.DipToCurrent((int) (40)),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 1689;BA.debugLine="Return pnl";
if (true) return _pnl;
 //BA.debugLineNum = 1690;BA.debugLine="End Sub";
return null;
}
public String  _createattachmentsui() throws Exception{
int _width = 0;
int _margin = 0;
int _fieldwidth = 0;
 //BA.debugLineNum = 375;BA.debugLine="Private Sub CreateAttachmentsUI";
 //BA.debugLineNum = 376;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 377;BA.debugLine="Dim margin As Int = 16dip";
_margin = __c.DipToCurrent((int) (16));
 //BA.debugLineNum = 378;BA.debugLine="Dim fieldWidth As Int = width - (margin * 2)";
_fieldwidth = (int) (_width-(_margin*2));
 //BA.debugLineNum = 381;BA.debugLine="pnlAttachments.Initialize(\"\")";
_pnlattachments.Initialize(ba,"");
 //BA.debugLineNum = 382;BA.debugLine="pnlAttachments.Color = Colors.Transparent";
_pnlattachments.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 384;BA.debugLine="pnlContent.AddView(pnlAttachments, margin, 420dip";
_pnlcontent.AddView((android.view.View)(_pnlattachments.getObject()),_margin,__c.DipToCurrent((int) (420)),_fieldwidth,__c.DipToCurrent((int) (200)));
 //BA.debugLineNum = 387;BA.debugLine="ContentChooser1.Initialize(\"ContentChooser1\")";
_contentchooser1.Initialize("ContentChooser1");
 //BA.debugLineNum = 388;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.PanelWrapper  _createcarditempanel(int _index,anywheresoftware.b4a.objects.collections.Map _item,int _panelwidth) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xv = null;
String _text = "";
int _colonpos = 0;
String _labeltext = "";
String _valuetext = "";
anywheresoftware.b4a.objects.LabelWrapper _lblcardlabel = null;
anywheresoftware.b4a.objects.EditTextWrapper _edtcardvalue = null;
 //BA.debugLineNum = 679;BA.debugLine="Private Sub CreateCardItemPanel(index As Int, item";
 //BA.debugLineNum = 680;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 681;BA.debugLine="pnl.Initialize(\"pnlCardItem\")";
_pnl.Initialize(ba,"pnlCardItem");
 //BA.debugLineNum = 682;BA.debugLine="pnl.Tag = index";
_pnl.setTag((Object)(_index));
 //BA.debugLineNum = 684;BA.debugLine="Dim xv As B4XView = pnl";
_xv = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xv = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnl.getObject()));
 //BA.debugLineNum = 685;BA.debugLine="xv.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModT";
_xv.SetColorAndBorder(_modtheme._homeiconbg /*int*/ (ba),(int) (0),_modtheme._homeiconbg /*int*/ (ba),__c.DipToCurrent((int) (8)));
 //BA.debugLineNum = 687;BA.debugLine="Dim text As String = item.GetDefault(\"text\", \"\")";
_text = BA.ObjectToString(_item.GetDefault((Object)("text"),(Object)("")));
 //BA.debugLineNum = 690;BA.debugLine="Dim colonPos As Int = text.IndexOf(\":\")";
_colonpos = _text.indexOf(":");
 //BA.debugLineNum = 691;BA.debugLine="Dim labelText As String = \"\"";
_labeltext = "";
 //BA.debugLineNum = 692;BA.debugLine="Dim valueText As String = \"\"";
_valuetext = "";
 //BA.debugLineNum = 693;BA.debugLine="If colonPos > 0 Then";
if (_colonpos>0) { 
 //BA.debugLineNum = 694;BA.debugLine="labelText = text.SubString2(0, colonPos + 1)  'I";
_labeltext = _text.substring((int) (0),(int) (_colonpos+1));
 //BA.debugLineNum = 695;BA.debugLine="valueText = text.SubString(colonPos + 1).Trim";
_valuetext = _text.substring((int) (_colonpos+1)).trim();
 }else {
 //BA.debugLineNum = 697;BA.debugLine="labelText = text";
_labeltext = _text;
 //BA.debugLineNum = 698;BA.debugLine="valueText = \"\"";
_valuetext = "";
 };
 //BA.debugLineNum = 702;BA.debugLine="Dim lblCardLabel As Label";
_lblcardlabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 703;BA.debugLine="lblCardLabel.Initialize(\"\")";
_lblcardlabel.Initialize(ba,"");
 //BA.debugLineNum = 704;BA.debugLine="lblCardLabel.Text = labelText";
_lblcardlabel.setText(BA.ObjectToCharSequence(_labeltext));
 //BA.debugLineNum = 705;BA.debugLine="lblCardLabel.TextSize = Starter.FONT_LABEL";
_lblcardlabel.setTextSize(_starter._font_label /*float*/ );
 //BA.debugLineNum = 706;BA.debugLine="lblCardLabel.TextColor = Colors.ARGB(180, 255, 25";
_lblcardlabel.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 707;BA.debugLine="lblCardLabel.Gravity = Gravity.CENTER_VERTICAL";
_lblcardlabel.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 708;BA.debugLine="pnl.AddView(lblCardLabel, 12dip, 0, 100dip, 50dip";
_pnl.AddView((android.view.View)(_lblcardlabel.getObject()),__c.DipToCurrent((int) (12)),(int) (0),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 711;BA.debugLine="Dim edtCardValue As EditText";
_edtcardvalue = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 715;BA.debugLine="Select index";
switch (_index) {
case 2: {
 //BA.debugLineNum = 717;BA.debugLine="edtCardValue.Initialize(\"edtCardNumber\")";
_edtcardvalue.Initialize(ba,"edtCardNumber");
 //BA.debugLineNum = 718;BA.debugLine="edtCardValue.InputType = 2  'TYPE_CLASS_NUMBER";
_edtcardvalue.setInputType((int) (2));
 //BA.debugLineNum = 719;BA.debugLine="edtCardValue.Hint = \"0000 0000 0000 0000\"";
_edtcardvalue.setHint("0000 0000 0000 0000");
 break; }
case 3: {
 //BA.debugLineNum = 721;BA.debugLine="edtCardValue.Initialize(\"edtCardExpiry\")";
_edtcardvalue.Initialize(ba,"edtCardExpiry");
 //BA.debugLineNum = 722;BA.debugLine="edtCardValue.InputType = 2  'TYPE_CLASS_NUMBER";
_edtcardvalue.setInputType((int) (2));
 //BA.debugLineNum = 723;BA.debugLine="edtCardValue.Hint = \"MM/AA\"";
_edtcardvalue.setHint("MM/AA");
 break; }
case 4: {
 //BA.debugLineNum = 725;BA.debugLine="edtCardValue.Initialize(\"edtCardCVV\")";
_edtcardvalue.Initialize(ba,"edtCardCVV");
 //BA.debugLineNum = 726;BA.debugLine="edtCardValue.InputType = 2  'TYPE_CLASS_NUMBER";
_edtcardvalue.setInputType((int) (2));
 //BA.debugLineNum = 727;BA.debugLine="edtCardValue.Hint = \"000\"";
_edtcardvalue.setHint("000");
 break; }
case 5: {
 //BA.debugLineNum = 729;BA.debugLine="edtCardValue.Initialize(\"edtCardValue\")";
_edtcardvalue.Initialize(ba,"edtCardValue");
 //BA.debugLineNum = 730;BA.debugLine="edtCardValue.InputType = Bit.Or(1, 524288)  'TE";
_edtcardvalue.setInputType(__c.Bit.Or((int) (1),(int) (524288)));
 break; }
case 7: {
 //BA.debugLineNum = 732;BA.debugLine="edtCardValue.Initialize(\"edtCardValue\")";
_edtcardvalue.Initialize(ba,"edtCardValue");
 //BA.debugLineNum = 733;BA.debugLine="edtCardValue.InputType = 2  'TYPE_CLASS_NUMBER";
_edtcardvalue.setInputType((int) (2));
 break; }
default: {
 //BA.debugLineNum = 735;BA.debugLine="edtCardValue.Initialize(\"edtCardValue\")";
_edtcardvalue.Initialize(ba,"edtCardValue");
 //BA.debugLineNum = 736;BA.debugLine="edtCardValue.InputType = Bit.Or(1, 8192)  'TEXT";
_edtcardvalue.setInputType(__c.Bit.Or((int) (1),(int) (8192)));
 break; }
}
;
 //BA.debugLineNum = 739;BA.debugLine="edtCardValue.Tag = index";
_edtcardvalue.setTag((Object)(_index));
 //BA.debugLineNum = 740;BA.debugLine="edtCardValue.Text = valueText";
_edtcardvalue.setText(BA.ObjectToCharSequence(_valuetext));
 //BA.debugLineNum = 741;BA.debugLine="edtCardValue.TextSize = Starter.FONT_BODY";
_edtcardvalue.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 742;BA.debugLine="edtCardValue.TextColor = Colors.White";
_edtcardvalue.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 743;BA.debugLine="edtCardValue.HintColor = Colors.ARGB(80, 255, 255";
_edtcardvalue.setHintColor(__c.Colors.ARGB((int) (80),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 744;BA.debugLine="edtCardValue.SingleLine = True";
_edtcardvalue.setSingleLine(__c.True);
 //BA.debugLineNum = 747;BA.debugLine="edtCardValue.Background = Null";
_edtcardvalue.setBackground((android.graphics.drawable.Drawable)(__c.Null));
 //BA.debugLineNum = 749;BA.debugLine="pnl.AddView(edtCardValue, 115dip, 5dip, panelWidt";
_pnl.AddView((android.view.View)(_edtcardvalue.getObject()),__c.DipToCurrent((int) (115)),__c.DipToCurrent((int) (5)),(int) (_panelwidth-__c.DipToCurrent((int) (130))),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 751;BA.debugLine="Return pnl";
if (true) return _pnl;
 //BA.debugLineNum = 752;BA.debugLine="End Sub";
return null;
}
public String  _createcommonfields() throws Exception{
int _width = 0;
int _margin = 0;
int _fieldwidth = 0;
int _y = 0;
 //BA.debugLineNum = 263;BA.debugLine="Private Sub CreateCommonFields";
 //BA.debugLineNum = 264;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 265;BA.debugLine="Dim margin As Int = 16dip";
_margin = __c.DipToCurrent((int) (16));
 //BA.debugLineNum = 266;BA.debugLine="Dim fieldWidth As Int = width - (margin * 2)";
_fieldwidth = (int) (_width-(_margin*2));
 //BA.debugLineNum = 267;BA.debugLine="Dim y As Int = 10dip";
_y = __c.DipToCurrent((int) (10));
 //BA.debugLineNum = 270;BA.debugLine="edtTitle.Initialize(\"edtTitle\")";
_edttitle.Initialize(ba,"edtTitle");
 //BA.debugLineNum = 271;BA.debugLine="edtTitle.Hint = ModLang.T(\"title_hint\")";
_edttitle.setHint(_modlang._t /*String*/ (ba,"title_hint"));
 //BA.debugLineNum = 272;BA.debugLine="edtTitle.SingleLine = True";
_edttitle.setSingleLine(__c.True);
 //BA.debugLineNum = 273;BA.debugLine="edtTitle.TextSize = Starter.FONT_BODY";
_edttitle.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 274;BA.debugLine="edtTitle.InputType = Bit.Or(1, 8192)";
_edttitle.setInputType(__c.Bit.Or((int) (1),(int) (8192)));
 //BA.debugLineNum = 275;BA.debugLine="pnlContent.AddView(edtTitle, margin, y, fieldWidt";
_pnlcontent.AddView((android.view.View)(_edttitle.getObject()),_margin,_y,(int) (_fieldwidth-__c.DipToCurrent((int) (60))),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 278;BA.debugLine="chkFavorite.Initialize(\"chkFavorite\")";
_chkfavorite.Initialize(ba,"chkFavorite");
 //BA.debugLineNum = 279;BA.debugLine="chkFavorite.Text = Chr(9734)  'Estrela vazia ☆";
_chkfavorite.setText(BA.ObjectToCharSequence(__c.Chr((int) (9734))));
 //BA.debugLineNum = 280;BA.debugLine="chkFavorite.TextSize = 24";
_chkfavorite.setTextSize((float) (24));
 //BA.debugLineNum = 281;BA.debugLine="chkFavorite.TextColor = Colors.ARGB(180, 255, 255";
_chkfavorite.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 282;BA.debugLine="pnlContent.AddView(chkFavorite, fieldWidth - 30di";
_pnlcontent.AddView((android.view.View)(_chkfavorite.getObject()),(int) (_fieldwidth-__c.DipToCurrent((int) (30))),(int) (_y+__c.DipToCurrent((int) (10))),__c.DipToCurrent((int) (50)),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 283;BA.debugLine="y = y + 55dip";
_y = (int) (_y+__c.DipToCurrent((int) (55)));
 //BA.debugLineNum = 284;BA.debugLine="End Sub";
return "";
}
public String  _createiconbar(anywheresoftware.b4a.objects.PanelWrapper _pnliconbar,int _width) throws Exception{
int _iconsize = 0;
int _spacing = 0;
int _startx = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _xvadd = null;
 //BA.debugLineNum = 220;BA.debugLine="Private Sub CreateIconBar(pnlIconBar As Panel, wid";
 //BA.debugLineNum = 221;BA.debugLine="Dim iconSize As Int = 44dip";
_iconsize = __c.DipToCurrent((int) (44));
 //BA.debugLineNum = 222;BA.debugLine="Dim spacing As Int = 8dip";
_spacing = __c.DipToCurrent((int) (8));
 //BA.debugLineNum = 223;BA.debugLine="Dim startX As Int = width - (iconSize * 5) - (spa";
_startx = (int) (_width-(_iconsize*5)-(_spacing*4)-__c.DipToCurrent((int) (16)));
 //BA.debugLineNum = 226;BA.debugLine="lblIconAdd.Initialize(\"lblIconAdd\")";
_lbliconadd.Initialize(ba,"lblIconAdd");
 //BA.debugLineNum = 227;BA.debugLine="lblIconAdd.Text = \"+\"";
_lbliconadd.setText(BA.ObjectToCharSequence("+"));
 //BA.debugLineNum = 228;BA.debugLine="lblIconAdd.TextSize = 24";
_lbliconadd.setTextSize((float) (24));
 //BA.debugLineNum = 229;BA.debugLine="lblIconAdd.TextColor = Colors.White";
_lbliconadd.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 230;BA.debugLine="lblIconAdd.Gravity = Gravity.CENTER";
_lbliconadd.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 231;BA.debugLine="pnlIconBar.AddView(lblIconAdd, startX, 3dip, icon";
_pnliconbar.AddView((android.view.View)(_lbliconadd.getObject()),_startx,__c.DipToCurrent((int) (3)),_iconsize,_iconsize);
 //BA.debugLineNum = 232;BA.debugLine="Dim xvAdd As B4XView = lblIconAdd";
_xvadd = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvadd = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbliconadd.getObject()));
 //BA.debugLineNum = 233;BA.debugLine="xvAdd.SetColorAndBorder(ModTheme.HomeIconBg, 0, M";
_xvadd.SetColorAndBorder(_modtheme._homeiconbg /*int*/ (ba),(int) (0),_modtheme._homeiconbg /*int*/ (ba),__c.DipToCurrent((int) (22)));
 //BA.debugLineNum = 236;BA.debugLine="ivIconAttach.Initialize(\"ivIconAttach\")";
_iviconattach.Initialize(ba,"ivIconAttach");
 //BA.debugLineNum = 237;BA.debugLine="ivIconAttach.Gravity = Gravity.CENTER";
_iviconattach.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 238;BA.debugLine="pnlIconBar.AddView(ivIconAttach, startX + iconSiz";
_pnliconbar.AddView((android.view.View)(_iviconattach.getObject()),(int) (_startx+_iconsize+_spacing),__c.DipToCurrent((int) (3)),_iconsize,_iconsize);
 //BA.debugLineNum = 239;BA.debugLine="SetAndroidIcon(ivIconAttach, \"ic_menu_attachment\"";
_setandroidicon(_iviconattach,"ic_menu_attachment");
 //BA.debugLineNum = 242;BA.debugLine="ivIconDelete.Initialize(\"ivIconDelete\")";
_ivicondelete.Initialize(ba,"ivIconDelete");
 //BA.debugLineNum = 243;BA.debugLine="ivIconDelete.Gravity = Gravity.CENTER";
_ivicondelete.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 244;BA.debugLine="ivIconDelete.Visible = False  'So aparece ao edit";
_ivicondelete.setVisible(__c.False);
 //BA.debugLineNum = 245;BA.debugLine="pnlIconBar.AddView(ivIconDelete, startX + (iconSi";
_pnliconbar.AddView((android.view.View)(_ivicondelete.getObject()),(int) (_startx+(_iconsize+_spacing)*2),__c.DipToCurrent((int) (3)),_iconsize,_iconsize);
 //BA.debugLineNum = 246;BA.debugLine="SetAndroidIcon(ivIconDelete, \"ic_menu_delete\")";
_setandroidicon(_ivicondelete,"ic_menu_delete");
 //BA.debugLineNum = 249;BA.debugLine="ivIconShare.Initialize(\"ivIconShare\")";
_iviconshare.Initialize(ba,"ivIconShare");
 //BA.debugLineNum = 250;BA.debugLine="ivIconShare.Gravity = Gravity.CENTER";
_iviconshare.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 251;BA.debugLine="pnlIconBar.AddView(ivIconShare, startX + (iconSiz";
_pnliconbar.AddView((android.view.View)(_iviconshare.getObject()),(int) (_startx+(_iconsize+_spacing)*3),__c.DipToCurrent((int) (3)),_iconsize,_iconsize);
 //BA.debugLineNum = 252;BA.debugLine="SetAndroidIcon(ivIconShare, \"ic_menu_share\")";
_setandroidicon(_iviconshare,"ic_menu_share");
 //BA.debugLineNum = 255;BA.debugLine="lblIconSave.Initialize(\"lblIconSave\")";
_lbliconsave.Initialize(ba,"lblIconSave");
 //BA.debugLineNum = 256;BA.debugLine="lblIconSave.Text = Chr(0x2713)  'Check ✓";
_lbliconsave.setText(BA.ObjectToCharSequence(__c.Chr(((int)0x2713))));
 //BA.debugLineNum = 257;BA.debugLine="lblIconSave.TextSize = 22";
_lbliconsave.setTextSize((float) (22));
 //BA.debugLineNum = 258;BA.debugLine="lblIconSave.TextColor = Colors.RGB(100, 200, 100)";
_lbliconsave.setTextColor(__c.Colors.RGB((int) (100),(int) (200),(int) (100)));
 //BA.debugLineNum = 259;BA.debugLine="lblIconSave.Gravity = Gravity.CENTER";
_lbliconsave.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 260;BA.debugLine="pnlIconBar.AddView(lblIconSave, startX + (iconSiz";
_pnliconbar.AddView((android.view.View)(_lbliconsave.getObject()),(int) (_startx+(_iconsize+_spacing)*4),__c.DipToCurrent((int) (3)),_iconsize,_iconsize);
 //BA.debugLineNum = 261;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 438;BA.debugLine="Private Sub CreateInputDialog";
 //BA.debugLineNum = 439;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 440;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 443;BA.debugLine="pnlInputOverlay.Initialize(\"pnlInputOverlay\")";
_pnlinputoverlay.Initialize(ba,"pnlInputOverlay");
 //BA.debugLineNum = 444;BA.debugLine="pnlInputOverlay.Color = Colors.ARGB(180, 0, 0, 0)";
_pnlinputoverlay.setColor(__c.Colors.ARGB((int) (180),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 445;BA.debugLine="pnlInputOverlay.Visible = False";
_pnlinputoverlay.setVisible(__c.False);
 //BA.debugLineNum = 446;BA.debugLine="Root.AddView(pnlInputOverlay, 0, 0, width, height";
_root.AddView((android.view.View)(_pnlinputoverlay.getObject()),(int) (0),(int) (0),_width,_height);
 //BA.debugLineNum = 449;BA.debugLine="Dim dialogW As Int = width - 40dip";
_dialogw = (int) (_width-__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 450;BA.debugLine="Dim dialogH As Int = 180dip";
_dialogh = __c.DipToCurrent((int) (180));
 //BA.debugLineNum = 452;BA.debugLine="pnlInputDialog.Initialize(\"\")";
_pnlinputdialog.Initialize(ba,"");
 //BA.debugLineNum = 453;BA.debugLine="pnlInputDialog.Color = ModTheme.HomeHeaderBg";
_pnlinputdialog.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 454;BA.debugLine="pnlInputOverlay.AddView(pnlInputDialog, 20dip, 80";
_pnlinputoverlay.AddView((android.view.View)(_pnlinputdialog.getObject()),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (80)),_dialogw,_dialogh);
 //BA.debugLineNum = 457;BA.debugLine="Dim xvDialog As B4XView = pnlInputDialog";
_xvdialog = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvdialog = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnlinputdialog.getObject()));
 //BA.debugLineNum = 458;BA.debugLine="xvDialog.SetColorAndBorder(ModTheme.HomeHeaderBg,";
_xvdialog.SetColorAndBorder(_modtheme._homeheaderbg /*int*/ (ba),(int) (0),_modtheme._homeheaderbg /*int*/ (ba),__c.DipToCurrent((int) (12)));
 //BA.debugLineNum = 461;BA.debugLine="Dim lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 462;BA.debugLine="lblTitle.Initialize(\"lblInputTitle\")";
_lbltitle.Initialize(ba,"lblInputTitle");
 //BA.debugLineNum = 463;BA.debugLine="lblTitle.Text = ModLang.T(\"note_add_item\")";
_lbltitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"note_add_item")));
 //BA.debugLineNum = 464;BA.debugLine="lblTitle.TextSize = Starter.FONT_BODY";
_lbltitle.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 465;BA.debugLine="lblTitle.TextColor = Colors.White";
_lbltitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 466;BA.debugLine="lblTitle.Typeface = Typeface.DEFAULT_BOLD";
_lbltitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 467;BA.debugLine="lblTitle.Gravity = Gravity.CENTER_HORIZONTAL";
_lbltitle.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 468;BA.debugLine="pnlInputDialog.AddView(lblTitle, 0, 12dip, dialog";
_pnlinputdialog.AddView((android.view.View)(_lbltitle.getObject()),(int) (0),__c.DipToCurrent((int) (12)),_dialogw,__c.DipToCurrent((int) (24)));
 //BA.debugLineNum = 471;BA.debugLine="edtItemText.Initialize(\"edtItemText\")";
_edtitemtext.Initialize(ba,"edtItemText");
 //BA.debugLineNum = 472;BA.debugLine="edtItemText.Hint = ModLang.T(\"item_hint\")  'Hint";
_edtitemtext.setHint(_modlang._t /*String*/ (ba,"item_hint"));
 //BA.debugLineNum = 473;BA.debugLine="edtItemText.SingleLine = True";
_edtitemtext.setSingleLine(__c.True);
 //BA.debugLineNum = 474;BA.debugLine="edtItemText.InputType = Bit.Or(1, 8192)  'TEXT +";
_edtitemtext.setInputType(__c.Bit.Or((int) (1),(int) (8192)));
 //BA.debugLineNum = 475;BA.debugLine="edtItemText.TextSize = Starter.FONT_BODY";
_edtitemtext.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 476;BA.debugLine="edtItemText.TextColor = Colors.White";
_edtitemtext.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 477;BA.debugLine="edtItemText.HintColor = Colors.ARGB(120, 255, 255";
_edtitemtext.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 479;BA.debugLine="Dim pnlInput As Panel";
_pnlinput = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 480;BA.debugLine="pnlInput.Initialize(\"\")";
_pnlinput.Initialize(ba,"");
 //BA.debugLineNum = 481;BA.debugLine="pnlInput.Color = ModTheme.HomeBg";
_pnlinput.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 482;BA.debugLine="pnlInputDialog.AddView(pnlInput, 16dip, 45dip, di";
_pnlinputdialog.AddView((android.view.View)(_pnlinput.getObject()),__c.DipToCurrent((int) (16)),__c.DipToCurrent((int) (45)),(int) (_dialogw-__c.DipToCurrent((int) (32))),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 483;BA.debugLine="pnlInput.AddView(edtItemText, 8dip, 5dip, dialogW";
_pnlinput.AddView((android.view.View)(_edtitemtext.getObject()),__c.DipToCurrent((int) (8)),__c.DipToCurrent((int) (5)),(int) (_dialogw-__c.DipToCurrent((int) (48))),__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 486;BA.debugLine="Dim btnSize As Int = 50dip";
_btnsize = __c.DipToCurrent((int) (50));
 //BA.debugLineNum = 487;BA.debugLine="Dim btnSpacing As Int = 20dip";
_btnspacing = __c.DipToCurrent((int) (20));
 //BA.debugLineNum = 488;BA.debugLine="Dim totalBtnsWidth As Int = (btnSize * 3) + (btnS";
_totalbtnswidth = (int) ((_btnsize*3)+(_btnspacing*2));
 //BA.debugLineNum = 489;BA.debugLine="Dim startX As Int = (dialogW - totalBtnsWidth) /";
_startx = (int) ((_dialogw-_totalbtnswidth)/(double)2);
 //BA.debugLineNum = 492;BA.debugLine="Dim btnInputCancel As Label";
_btninputcancel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 493;BA.debugLine="btnInputCancel.Initialize(\"btnInputCancel\")";
_btninputcancel.Initialize(ba,"btnInputCancel");
 //BA.debugLineNum = 494;BA.debugLine="btnInputCancel.Text = \"X\"";
_btninputcancel.setText(BA.ObjectToCharSequence("X"));
 //BA.debugLineNum = 495;BA.debugLine="btnInputCancel.TextSize = 22";
_btninputcancel.setTextSize((float) (22));
 //BA.debugLineNum = 496;BA.debugLine="btnInputCancel.TextColor = Colors.RGB(255, 100, 1";
_btninputcancel.setTextColor(__c.Colors.RGB((int) (255),(int) (100),(int) (100)));
 //BA.debugLineNum = 497;BA.debugLine="btnInputCancel.Gravity = Gravity.CENTER";
_btninputcancel.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 498;BA.debugLine="pnlInputDialog.AddView(btnInputCancel, startX, 11";
_pnlinputdialog.AddView((android.view.View)(_btninputcancel.getObject()),_startx,__c.DipToCurrent((int) (115)),_btnsize,_btnsize);
 //BA.debugLineNum = 499;BA.debugLine="Dim xvCancel As B4XView = btnInputCancel";
_xvcancel = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvcancel = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_btninputcancel.getObject()));
 //BA.debugLineNum = 500;BA.debugLine="xvCancel.SetColorAndBorder(ModTheme.HomeBg, 1dip,";
_xvcancel.SetColorAndBorder(_modtheme._homebg /*int*/ (ba),__c.DipToCurrent((int) (1)),__c.Colors.RGB((int) (255),(int) (100),(int) (100)),__c.DipToCurrent((int) (25)));
 //BA.debugLineNum = 503;BA.debugLine="Dim btnInputAddMore As Label";
_btninputaddmore = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 504;BA.debugLine="btnInputAddMore.Initialize(\"btnInputAddMore\")";
_btninputaddmore.Initialize(ba,"btnInputAddMore");
 //BA.debugLineNum = 505;BA.debugLine="btnInputAddMore.Text = \"+\"";
_btninputaddmore.setText(BA.ObjectToCharSequence("+"));
 //BA.debugLineNum = 506;BA.debugLine="btnInputAddMore.TextSize = 26";
_btninputaddmore.setTextSize((float) (26));
 //BA.debugLineNum = 507;BA.debugLine="btnInputAddMore.TextColor = Colors.RGB(255, 200,";
_btninputaddmore.setTextColor(__c.Colors.RGB((int) (255),(int) (200),(int) (100)));
 //BA.debugLineNum = 508;BA.debugLine="btnInputAddMore.Gravity = Gravity.CENTER";
_btninputaddmore.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 509;BA.debugLine="pnlInputDialog.AddView(btnInputAddMore, startX +";
_pnlinputdialog.AddView((android.view.View)(_btninputaddmore.getObject()),(int) (_startx+_btnsize+_btnspacing),__c.DipToCurrent((int) (115)),_btnsize,_btnsize);
 //BA.debugLineNum = 510;BA.debugLine="Dim xvAddMore As B4XView = btnInputAddMore";
_xvaddmore = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvaddmore = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_btninputaddmore.getObject()));
 //BA.debugLineNum = 511;BA.debugLine="xvAddMore.SetColorAndBorder(ModTheme.HomeBg, 1dip";
_xvaddmore.SetColorAndBorder(_modtheme._homebg /*int*/ (ba),__c.DipToCurrent((int) (1)),__c.Colors.RGB((int) (255),(int) (200),(int) (100)),__c.DipToCurrent((int) (25)));
 //BA.debugLineNum = 514;BA.debugLine="Dim btnInputSaveExit As Label";
_btninputsaveexit = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 515;BA.debugLine="btnInputSaveExit.Initialize(\"btnInputSaveExit\")";
_btninputsaveexit.Initialize(ba,"btnInputSaveExit");
 //BA.debugLineNum = 516;BA.debugLine="btnInputSaveExit.Text = Chr(0x2713)  '✓";
_btninputsaveexit.setText(BA.ObjectToCharSequence(__c.Chr(((int)0x2713))));
 //BA.debugLineNum = 517;BA.debugLine="btnInputSaveExit.TextSize = 22";
_btninputsaveexit.setTextSize((float) (22));
 //BA.debugLineNum = 518;BA.debugLine="btnInputSaveExit.TextColor = Colors.RGB(100, 200,";
_btninputsaveexit.setTextColor(__c.Colors.RGB((int) (100),(int) (200),(int) (100)));
 //BA.debugLineNum = 519;BA.debugLine="btnInputSaveExit.Gravity = Gravity.CENTER";
_btninputsaveexit.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 520;BA.debugLine="pnlInputDialog.AddView(btnInputSaveExit, startX +";
_pnlinputdialog.AddView((android.view.View)(_btninputsaveexit.getObject()),(int) (_startx+(_btnsize+_btnspacing)*2),__c.DipToCurrent((int) (115)),_btnsize,_btnsize);
 //BA.debugLineNum = 521;BA.debugLine="Dim xvSaveExit As B4XView = btnInputSaveExit";
_xvsaveexit = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvsaveexit = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_btninputsaveexit.getObject()));
 //BA.debugLineNum = 522;BA.debugLine="xvSaveExit.SetColorAndBorder(ModTheme.HomeBg, 1di";
_xvsaveexit.SetColorAndBorder(_modtheme._homebg /*int*/ (ba),__c.DipToCurrent((int) (1)),__c.Colors.RGB((int) (100),(int) (200),(int) (100)),__c.DipToCurrent((int) (25)));
 //BA.debugLineNum = 523;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.PanelWrapper  _createitempanel(int _index,anywheresoftware.b4a.objects.collections.Map _item,int _panelwidth) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xv = null;
String _text = "";
boolean _checked = false;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chk = null;
 //BA.debugLineNum = 754;BA.debugLine="Private Sub CreateItemPanel(index As Int, item As";
 //BA.debugLineNum = 755;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 756;BA.debugLine="pnl.Initialize(\"pnlItem\")";
_pnl.Initialize(ba,"pnlItem");
 //BA.debugLineNum = 757;BA.debugLine="pnl.Tag = index";
_pnl.setTag((Object)(_index));
 //BA.debugLineNum = 759;BA.debugLine="Dim xv As B4XView = pnl";
_xv = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xv = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_pnl.getObject()));
 //BA.debugLineNum = 760;BA.debugLine="xv.SetColorAndBorder(ModTheme.HomeIconBg, 0, ModT";
_xv.SetColorAndBorder(_modtheme._homeiconbg /*int*/ (ba),(int) (0),_modtheme._homeiconbg /*int*/ (ba),__c.DipToCurrent((int) (8)));
 //BA.debugLineNum = 762;BA.debugLine="Dim text As String = item.GetDefault(\"text\", \"\")";
_text = BA.ObjectToString(_item.GetDefault((Object)("text"),(Object)("")));
 //BA.debugLineNum = 763;BA.debugLine="Dim checked As Boolean = item.GetDefault(\"checked";
_checked = BA.ObjectToBoolean(_item.GetDefault((Object)("checked"),(Object)(__c.False)));
 //BA.debugLineNum = 766;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 767;BA.debugLine="lbl.Initialize(\"lblItem\")";
_lbl.Initialize(ba,"lblItem");
 //BA.debugLineNum = 768;BA.debugLine="lbl.Tag = index";
_lbl.setTag((Object)(_index));
 //BA.debugLineNum = 769;BA.debugLine="lbl.Text = text";
_lbl.setText(BA.ObjectToCharSequence(_text));
 //BA.debugLineNum = 770;BA.debugLine="lbl.TextSize = Starter.FONT_BODY";
_lbl.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 771;BA.debugLine="lbl.Gravity = Gravity.CENTER_VERTICAL";
_lbl.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 772;BA.debugLine="lbl.TextColor = Colors.White";
_lbl.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 773;BA.debugLine="pnl.AddView(lbl, 12dip, 0, panelWidth - 60dip, 50";
_pnl.AddView((android.view.View)(_lbl.getObject()),__c.DipToCurrent((int) (12)),(int) (0),(int) (_panelwidth-__c.DipToCurrent((int) (60))),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 776;BA.debugLine="Dim chk As CheckBox";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 777;BA.debugLine="chk.Initialize(\"chkItem\")";
_chk.Initialize(ba,"chkItem");
 //BA.debugLineNum = 778;BA.debugLine="chk.Tag = index";
_chk.setTag((Object)(_index));
 //BA.debugLineNum = 779;BA.debugLine="chk.Text = \"\"";
_chk.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 780;BA.debugLine="chk.Checked = checked";
_chk.setChecked(_checked);
 //BA.debugLineNum = 781;BA.debugLine="pnl.AddView(chk, panelWidth - 48dip, 10dip, 40dip";
_pnl.AddView((android.view.View)(_chk.getObject()),(int) (_panelwidth-__c.DipToCurrent((int) (48))),__c.DipToCurrent((int) (10)),__c.DipToCurrent((int) (40)),__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 783;BA.debugLine="Return pnl";
if (true) return _pnl;
 //BA.debugLineNum = 784;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 312;BA.debugLine="Private Sub CreateListModeUI";
 //BA.debugLineNum = 313;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 314;BA.debugLine="Dim margin As Int = 16dip";
_margin = __c.DipToCurrent((int) (16));
 //BA.debugLineNum = 315;BA.debugLine="Dim fieldWidth As Int = width - (margin * 2)";
_fieldwidth = (int) (_width-(_margin*2));
 //BA.debugLineNum = 317;BA.debugLine="pnlListMode.Initialize(\"\")";
_pnllistmode.Initialize(ba,"");
 //BA.debugLineNum = 318;BA.debugLine="pnlListMode.Color = Colors.Transparent";
_pnllistmode.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 319;BA.debugLine="pnlContent.AddView(pnlListMode, 0, 70dip, width,";
_pnlcontent.AddView((android.view.View)(_pnllistmode.getObject()),(int) (0),__c.DipToCurrent((int) (70)),_width,__c.DipToCurrent((int) (450)));
 //BA.debugLineNum = 322;BA.debugLine="Dim filterWidth As Int = fieldWidth - 44dip";
_filterwidth = (int) (_fieldwidth-__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 323;BA.debugLine="edtFilter.Initialize(\"edtFilter\")";
_edtfilter.Initialize(ba,"edtFilter");
 //BA.debugLineNum = 324;BA.debugLine="edtFilter.Hint = ModLang.T(\"filter_items\")";
_edtfilter.setHint(_modlang._t /*String*/ (ba,"filter_items"));
 //BA.debugLineNum = 325;BA.debugLine="edtFilter.SingleLine = True";
_edtfilter.setSingleLine(__c.True);
 //BA.debugLineNum = 326;BA.debugLine="edtFilter.TextSize = Starter.FONT_BODY";
_edtfilter.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 327;BA.debugLine="edtFilter.TextColor = Colors.White";
_edtfilter.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 328;BA.debugLine="edtFilter.HintColor = Colors.ARGB(120, 255, 255,";
_edtfilter.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 329;BA.debugLine="Dim cdFilter As ColorDrawable";
_cdfilter = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 330;BA.debugLine="cdFilter.Initialize2(ModTheme.HomeHeaderBg, 8dip,";
_cdfilter.Initialize2(_modtheme._homeheaderbg /*int*/ (ba),__c.DipToCurrent((int) (8)),__c.DipToCurrent((int) (1)),__c.Colors.ARGB((int) (80),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 331;BA.debugLine="edtFilter.Background = cdFilter";
_edtfilter.setBackground((android.graphics.drawable.Drawable)(_cdfilter.getObject()));
 //BA.debugLineNum = 332;BA.debugLine="pnlListMode.AddView(edtFilter, margin, 0, filterW";
_pnllistmode.AddView((android.view.View)(_edtfilter.getObject()),_margin,(int) (0),_filterwidth,__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 335;BA.debugLine="lblClearFilter.Initialize(\"lblClearFilter\")";
_lblclearfilter.Initialize(ba,"lblClearFilter");
 //BA.debugLineNum = 336;BA.debugLine="lblClearFilter.Text = \"X\"";
_lblclearfilter.setText(BA.ObjectToCharSequence("X"));
 //BA.debugLineNum = 337;BA.debugLine="lblClearFilter.TextSize = 18";
_lblclearfilter.setTextSize((float) (18));
 //BA.debugLineNum = 338;BA.debugLine="lblClearFilter.TextColor = Colors.ARGB(180, 255,";
_lblclearfilter.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 339;BA.debugLine="lblClearFilter.Gravity = Gravity.CENTER";
_lblclearfilter.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 340;BA.debugLine="pnlListMode.AddView(lblClearFilter, margin + filt";
_pnllistmode.AddView((android.view.View)(_lblclearfilter.getObject()),(int) (_margin+_filterwidth+__c.DipToCurrent((int) (4))),(int) (0),__c.DipToCurrent((int) (40)),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 343;BA.debugLine="pnlItems.Initialize(\"\")";
_pnlitems.Initialize(ba,"");
 //BA.debugLineNum = 344;BA.debugLine="pnlItems.Color = Colors.Transparent";
_pnlitems.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 345;BA.debugLine="pnlListMode.AddView(pnlItems, margin, 52dip, fiel";
_pnllistmode.AddView((android.view.View)(_pnlitems.getObject()),_margin,__c.DipToCurrent((int) (52)),_fieldwidth,__c.DipToCurrent((int) (300)));
 //BA.debugLineNum = 348;BA.debugLine="pnlAddRow.Initialize(\"\")";
_pnladdrow.Initialize(ba,"");
 //BA.debugLineNum = 349;BA.debugLine="pnlAddRow.Color = Colors.Transparent";
_pnladdrow.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 350;BA.debugLine="pnlListMode.AddView(pnlAddRow, margin, 360dip, fi";
_pnllistmode.AddView((android.view.View)(_pnladdrow.getObject()),_margin,__c.DipToCurrent((int) (360)),_fieldwidth,__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 353;BA.debugLine="lblAddItem.Initialize(\"lblAddItem\")";
_lbladditem.Initialize(ba,"lblAddItem");
 //BA.debugLineNum = 354;BA.debugLine="lblAddItem.Text = \"+\"";
_lbladditem.setText(BA.ObjectToCharSequence("+"));
 //BA.debugLineNum = 355;BA.debugLine="lblAddItem.TextSize = 26";
_lbladditem.setTextSize((float) (26));
 //BA.debugLineNum = 356;BA.debugLine="lblAddItem.Typeface = Typeface.DEFAULT_BOLD";
_lbladditem.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 357;BA.debugLine="lblAddItem.Gravity = Gravity.CENTER";
_lbladditem.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 358;BA.debugLine="lblAddItem.TextColor = Colors.White";
_lbladditem.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 359;BA.debugLine="pnlAddRow.AddView(lblAddItem, 0, 3dip, 44dip, 44d";
_pnladdrow.AddView((android.view.View)(_lbladditem.getObject()),(int) (0),__c.DipToCurrent((int) (3)),__c.DipToCurrent((int) (44)),__c.DipToCurrent((int) (44)));
 //BA.debugLineNum = 362;BA.debugLine="Dim xvAddItem As B4XView = lblAddItem";
_xvadditem = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xvadditem = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbladditem.getObject()));
 //BA.debugLineNum = 363;BA.debugLine="xvAddItem.SetColorAndBorder(ModTheme.HomeIconBg,";
_xvadditem.SetColorAndBorder(_modtheme._homeiconbg /*int*/ (ba),(int) (0),_modtheme._homeiconbg /*int*/ (ba),__c.DipToCurrent((int) (22)));
 //BA.debugLineNum = 366;BA.debugLine="Dim lblAddItemText As Label";
_lbladditemtext = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 367;BA.debugLine="lblAddItemText.Initialize(\"lblAddItem\")  'Mesmo e";
_lbladditemtext.Initialize(ba,"lblAddItem");
 //BA.debugLineNum = 368;BA.debugLine="lblAddItemText.Text = \"(\" & ModLang.T(\"add_item\")";
_lbladditemtext.setText(BA.ObjectToCharSequence("("+_modlang._t /*String*/ (ba,"add_item")+")"));
 //BA.debugLineNum = 369;BA.debugLine="lblAddItemText.TextSize = Starter.FONT_BODY";
_lbladditemtext.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 370;BA.debugLine="lblAddItemText.TextColor = Colors.ARGB(180, 255,";
_lbladditemtext.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 371;BA.debugLine="lblAddItemText.Gravity = Gravity.CENTER_VERTICAL";
_lbladditemtext.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 372;BA.debugLine="pnlAddRow.AddView(lblAddItemText, 52dip, 0, field";
_pnladdrow.AddView((android.view.View)(_lbladditemtext.getObject()),__c.DipToCurrent((int) (52)),(int) (0),(int) (_fieldwidth-__c.DipToCurrent((int) (60))),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 373;BA.debugLine="End Sub";
return "";
}
public String  _createtextmodeui() throws Exception{
int _width = 0;
int _margin = 0;
int _fieldwidth = 0;
anywheresoftware.b4a.objects.LabelWrapper _lblcontentfield = null;
 //BA.debugLineNum = 286;BA.debugLine="Private Sub CreateTextModeUI";
 //BA.debugLineNum = 287;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 288;BA.debugLine="Dim margin As Int = 16dip";
_margin = __c.DipToCurrent((int) (16));
 //BA.debugLineNum = 289;BA.debugLine="Dim fieldWidth As Int = width - (margin * 2)";
_fieldwidth = (int) (_width-(_margin*2));
 //BA.debugLineNum = 291;BA.debugLine="pnlTextMode.Initialize(\"\")";
_pnltextmode.Initialize(ba,"");
 //BA.debugLineNum = 292;BA.debugLine="pnlTextMode.Color = Colors.Transparent";
_pnltextmode.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 293;BA.debugLine="pnlContent.AddView(pnlTextMode, 0, 70dip, width,";
_pnlcontent.AddView((android.view.View)(_pnltextmode.getObject()),(int) (0),__c.DipToCurrent((int) (70)),_width,__c.DipToCurrent((int) (350)));
 //BA.debugLineNum = 296;BA.debugLine="Dim lblContentField As Label";
_lblcontentfield = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 297;BA.debugLine="lblContentField.Initialize(\"\")";
_lblcontentfield.Initialize(ba,"");
 //BA.debugLineNum = 298;BA.debugLine="lblContentField.Text = ModLang.T(\"content\")";
_lblcontentfield.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"content")));
 //BA.debugLineNum = 299;BA.debugLine="lblContentField.TextSize = Starter.FONT_LABEL";
_lblcontentfield.setTextSize(_starter._font_label /*float*/ );
 //BA.debugLineNum = 300;BA.debugLine="lblContentField.TextColor = Colors.ARGB(180, 255,";
_lblcontentfield.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 301;BA.debugLine="pnlTextMode.AddView(lblContentField, margin, 0, f";
_pnltextmode.AddView((android.view.View)(_lblcontentfield.getObject()),_margin,(int) (0),_fieldwidth,__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 304;BA.debugLine="edtContent.Initialize(\"edtContent\")";
_edtcontent.Initialize(ba,"edtContent");
 //BA.debugLineNum = 305;BA.debugLine="edtContent.Hint = ModLang.T(\"content_hint\")";
_edtcontent.setHint(_modlang._t /*String*/ (ba,"content_hint"));
 //BA.debugLineNum = 306;BA.debugLine="edtContent.SingleLine = False";
_edtcontent.setSingleLine(__c.False);
 //BA.debugLineNum = 307;BA.debugLine="edtContent.TextSize = Starter.FONT_BODY";
_edtcontent.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 308;BA.debugLine="edtContent.Gravity = Gravity.TOP";
_edtcontent.setGravity(__c.Gravity.TOP);
 //BA.debugLineNum = 309;BA.debugLine="pnlTextMode.AddView(edtContent, margin, 22dip, fi";
_pnltextmode.AddView((android.view.View)(_edtcontent.getObject()),_margin,__c.DipToCurrent((int) (22)),_fieldwidth,__c.DipToCurrent((int) (300)));
 //BA.debugLineNum = 310;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 167;BA.debugLine="Private Sub CreateUI";
 //BA.debugLineNum = 168;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 169;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 170;BA.debugLine="Dim headerH As Int = 56dip";
_headerh = __c.DipToCurrent((int) (56));
 //BA.debugLineNum = 171;BA.debugLine="Dim iconBarH As Int = 50dip";
_iconbarh = __c.DipToCurrent((int) (50));
 //BA.debugLineNum = 174;BA.debugLine="Dim pnlHeader As Panel";
_pnlheader = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 175;BA.debugLine="pnlHeader.Initialize(\"\")";
_pnlheader.Initialize(ba,"");
 //BA.debugLineNum = 176;BA.debugLine="pnlHeader.Color = ModTheme.HomeHeaderBg";
_pnlheader.setColor(_modtheme._homeheaderbg /*int*/ (ba));
 //BA.debugLineNum = 177;BA.debugLine="Root.AddView(pnlHeader, 0, 0, width, headerH)";
_root.AddView((android.view.View)(_pnlheader.getObject()),(int) (0),(int) (0),_width,_headerh);
 //BA.debugLineNum = 180;BA.debugLine="btnBack.Initialize(\"btnBack\")";
_btnback.Initialize(ba,"btnBack");
 //BA.debugLineNum = 181;BA.debugLine="btnBack.Text = \"<\"";
_btnback.setText(BA.ObjectToCharSequence("<"));
 //BA.debugLineNum = 182;BA.debugLine="btnBack.TextSize = 20";
_btnback.setTextSize((float) (20));
 //BA.debugLineNum = 183;BA.debugLine="btnBack.Color = Colors.Transparent";
_btnback.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 184;BA.debugLine="btnBack.TextColor = Colors.White";
_btnback.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 185;BA.debugLine="btnBack.Gravity = Gravity.CENTER";
_btnback.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 186;BA.debugLine="pnlHeader.AddView(btnBack, 0, 0, 50dip, headerH)";
_pnlheader.AddView((android.view.View)(_btnback.getObject()),(int) (0),(int) (0),__c.DipToCurrent((int) (50)),_headerh);
 //BA.debugLineNum = 189;BA.debugLine="lblHeaderTitle.Initialize(\"\")";
_lblheadertitle.Initialize(ba,"");
 //BA.debugLineNum = 190;BA.debugLine="lblHeaderTitle.Text = ModLang.T(\"new_note\")";
_lblheadertitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"new_note")));
 //BA.debugLineNum = 191;BA.debugLine="lblHeaderTitle.TextSize = Starter.FONT_BODY";
_lblheadertitle.setTextSize(_starter._font_body /*float*/ );
 //BA.debugLineNum = 192;BA.debugLine="lblHeaderTitle.TextColor = Colors.White";
_lblheadertitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 193;BA.debugLine="lblHeaderTitle.Typeface = Typeface.DEFAULT_BOLD";
_lblheadertitle.setTypeface(__c.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 194;BA.debugLine="lblHeaderTitle.Gravity = Gravity.CENTER_VERTICAL";
_lblheadertitle.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 195;BA.debugLine="pnlHeader.AddView(lblHeaderTitle, 50dip, 0, width";
_pnlheader.AddView((android.view.View)(_lblheadertitle.getObject()),__c.DipToCurrent((int) (50)),(int) (0),(int) (_width-__c.DipToCurrent((int) (60))),_headerh);
 //BA.debugLineNum = 198;BA.debugLine="Dim pnlIconBar As Panel";
_pnliconbar = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 199;BA.debugLine="pnlIconBar.Initialize(\"\")";
_pnliconbar.Initialize(ba,"");
 //BA.debugLineNum = 200;BA.debugLine="pnlIconBar.Color = ModTheme.HomeBg";
_pnliconbar.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 201;BA.debugLine="Root.AddView(pnlIconBar, 0, headerH, width, iconB";
_root.AddView((android.view.View)(_pnliconbar.getObject()),(int) (0),_headerh,_width,_iconbarh);
 //BA.debugLineNum = 202;BA.debugLine="CreateIconBar(pnlIconBar, width)";
_createiconbar(_pnliconbar,_width);
 //BA.debugLineNum = 205;BA.debugLine="Dim contentTop As Int = headerH + iconBarH";
_contenttop = (int) (_headerh+_iconbarh);
 //BA.debugLineNum = 206;BA.debugLine="svContent.Initialize(0)";
_svcontent.Initialize(ba,(int) (0));
 //BA.debugLineNum = 207;BA.debugLine="svContent.Color = ModTheme.HomeBg";
_svcontent.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 208;BA.debugLine="Root.AddView(svContent, 0, contentTop, width, hei";
_root.AddView((android.view.View)(_svcontent.getObject()),(int) (0),_contenttop,_width,(int) (_height-_contenttop));
 //BA.debugLineNum = 210;BA.debugLine="pnlContent = svContent.Panel";
_pnlcontent = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_svcontent.getPanel().getObject()));
 //BA.debugLineNum = 211;BA.debugLine="pnlContent.Color = ModTheme.HomeBg";
_pnlcontent.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 213;BA.debugLine="CreateCommonFields";
_createcommonfields();
 //BA.debugLineNum = 214;BA.debugLine="CreateTextModeUI";
_createtextmodeui();
 //BA.debugLineNum = 215;BA.debugLine="CreateListModeUI";
_createlistmodeui();
 //BA.debugLineNum = 216;BA.debugLine="CreateAttachmentsUI";
_createattachmentsui();
 //BA.debugLineNum = 217;BA.debugLine="CreateInputDialog";
_createinputdialog();
 //BA.debugLineNum = 218;BA.debugLine="End Sub";
return "";
}
public String  _edititem(int _index) throws Exception{
anywheresoftware.b4a.objects.collections.Map _item = null;
String _currenttext = "";
 //BA.debugLineNum = 1100;BA.debugLine="Private Sub EditItem(index As Int)";
 //BA.debugLineNum = 1101;BA.debugLine="If index < 0 Or index >= ItemsList.Size Then Retu";
if (_index<0 || _index>=_itemslist.getSize()) { 
if (true) return "";};
 //BA.debugLineNum = 1102;BA.debugLine="If IsSecure Then ModSession.Touch";
if (_issecure) { 
_modsession._touch /*String*/ (ba);};
 //BA.debugLineNum = 1104;BA.debugLine="Dim item As Map = ItemsList.Get(index)";
_item = new anywheresoftware.b4a.objects.collections.Map();
_item = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_itemslist.Get(_index)));
 //BA.debugLineNum = 1105;BA.debugLine="Dim currentText As String = item.GetDefault(\"text";
_currenttext = BA.ObjectToString(_item.GetDefault((Object)("text"),(Object)("")));
 //BA.debugLineNum = 1106;BA.debugLine="ShowInputDialog(ModLang.T(\"edit_item\"), currentTe";
_showinputdialog(_modlang._t /*String*/ (ba,"edit_item"),_currenttext,_index);
 //BA.debugLineNum = 1107;BA.debugLine="End Sub";
return "";
}
public String  _edtcardcvv_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 1011;BA.debugLine="Private Sub edtCardCVV_FocusChanged(HasFocus As Bo";
 //BA.debugLineNum = 1012;BA.debugLine="If HasFocus Then ScrollToCardField(Sender)";
if (_hasfocus) { 
_scrolltocardfield(__c.Sender(ba));};
 //BA.debugLineNum = 1013;BA.debugLine="End Sub";
return "";
}
public String  _edtcardcvv_textchanged(String _old,String _new) throws Exception{
anywheresoftware.b4a.objects.EditTextWrapper _edt = null;
int _index = 0;
String _digits = "";
int _i = 0;
int _charcode = 0;
anywheresoftware.b4a.objects.collections.Map _item = null;
String _text = "";
int _colonpos = 0;
 //BA.debugLineNum = 938;BA.debugLine="Private Sub edtCardCVV_TextChanged(Old As String,";
 //BA.debugLineNum = 939;BA.debugLine="If IsRebuildingUI Then Return";
if (_isrebuildingui) { 
if (true) return "";};
 //BA.debugLineNum = 941;BA.debugLine="Dim edt As EditText = Sender";
_edt = new anywheresoftware.b4a.objects.EditTextWrapper();
_edt = (anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(__c.Sender(ba)));
 //BA.debugLineNum = 942;BA.debugLine="Dim index As Int = edt.Tag";
_index = (int)(BA.ObjectToNumber(_edt.getTag()));
 //BA.debugLineNum = 945;BA.debugLine="Dim digits As String = \"\"";
_digits = "";
 //BA.debugLineNum = 946;BA.debugLine="For i = 0 To New.Length - 1";
{
final int step5 = 1;
final int limit5 = (int) (_new.length()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 947;BA.debugLine="Dim charCode As Int = Asc(New.CharAt(i))";
_charcode = __c.Asc(_new.charAt(_i));
 //BA.debugLineNum = 948;BA.debugLine="If charCode >= 48 And charCode <= 57 Then  '0-9";
if (_charcode>=48 && _charcode<=57) { 
 //BA.debugLineNum = 949;BA.debugLine="digits = digits & Chr(charCode)";
_digits = _digits+BA.ObjectToString(__c.Chr(_charcode));
 };
 }
};
 //BA.debugLineNum = 954;BA.debugLine="If digits.Length > 3 Then digits = digits.SubStri";
if (_digits.length()>3) { 
_digits = _digits.substring((int) (0),(int) (3));};
 //BA.debugLineNum = 957;BA.debugLine="If digits <> New Then";
if ((_digits).equals(_new) == false) { 
 //BA.debugLineNum = 958;BA.debugLine="edt.Text = digits";
_edt.setText(BA.ObjectToCharSequence(_digits));
 //BA.debugLineNum = 959;BA.debugLine="edt.SelectionStart = digits.Length";
_edt.setSelectionStart(_digits.length());
 };
 //BA.debugLineNum = 963;BA.debugLine="If index >= 0 And index < ItemsList.Size Then";
if (_index>=0 && _index<_itemslist.getSize()) { 
 //BA.debugLineNum = 964;BA.debugLine="Dim item As Map = ItemsList.Get(index)";
_item = new anywheresoftware.b4a.objects.collections.Map();
_item = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_itemslist.Get(_index)));
 //BA.debugLineNum = 965;BA.debugLine="Dim text As String = item.GetDefault(\"text\", \"\")";
_text = BA.ObjectToString(_item.GetDefault((Object)("text"),(Object)("")));
 //BA.debugLineNum = 966;BA.debugLine="Dim colonPos As Int = text.IndexOf(\":\")";
_colonpos = _text.indexOf(":");
 //BA.debugLineNum = 967;BA.debugLine="If colonPos > 0 Then";
if (_colonpos>0) { 
 //BA.debugLineNum = 968;BA.debugLine="item.Put(\"text\", text.SubString2(0, colonPos +";
_item.Put((Object)("text"),(Object)(_text.substring((int) (0),(int) (_colonpos+1))+" "+_digits));
 };
 };
 //BA.debugLineNum = 971;BA.debugLine="End Sub";
return "";
}
public String  _edtcardexpiry_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 1007;BA.debugLine="Private Sub edtCardExpiry_FocusChanged(HasFocus As";
 //BA.debugLineNum = 1008;BA.debugLine="If HasFocus Then ScrollToCardField(Sender)";
if (_hasfocus) { 
_scrolltocardfield(__c.Sender(ba));};
 //BA.debugLineNum = 1009;BA.debugLine="End Sub";
return "";
}
public String  _edtcardexpiry_textchanged(String _old,String _new) throws Exception{
anywheresoftware.b4a.objects.EditTextWrapper _edt = null;
int _index = 0;
String _digits = "";
int _i = 0;
int _charcode = 0;
String _formatted = "";
int _firstdigit = 0;
int _month = 0;
anywheresoftware.b4a.objects.collections.Map _item = null;
String _text = "";
int _colonpos = 0;
 //BA.debugLineNum = 871;BA.debugLine="Private Sub edtCardExpiry_TextChanged(Old As Strin";
 //BA.debugLineNum = 872;BA.debugLine="If IsRebuildingUI Then Return";
if (_isrebuildingui) { 
if (true) return "";};
 //BA.debugLineNum = 874;BA.debugLine="Dim edt As EditText = Sender";
_edt = new anywheresoftware.b4a.objects.EditTextWrapper();
_edt = (anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(__c.Sender(ba)));
 //BA.debugLineNum = 875;BA.debugLine="Dim index As Int = edt.Tag";
_index = (int)(BA.ObjectToNumber(_edt.getTag()));
 //BA.debugLineNum = 878;BA.debugLine="Dim digits As String = \"\"";
_digits = "";
 //BA.debugLineNum = 879;BA.debugLine="For i = 0 To New.Length - 1";
{
final int step5 = 1;
final int limit5 = (int) (_new.length()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 880;BA.debugLine="Dim charCode As Int = Asc(New.CharAt(i))";
_charcode = __c.Asc(_new.charAt(_i));
 //BA.debugLineNum = 881;BA.debugLine="If charCode >= 48 And charCode <= 57 Then  '0-9";
if (_charcode>=48 && _charcode<=57) { 
 //BA.debugLineNum = 882;BA.debugLine="digits = digits & Chr(charCode)";
_digits = _digits+BA.ObjectToString(__c.Chr(_charcode));
 };
 }
};
 //BA.debugLineNum = 887;BA.debugLine="If digits.Length > 4 Then digits = digits.SubStri";
if (_digits.length()>4) { 
_digits = _digits.substring((int) (0),(int) (4));};
 //BA.debugLineNum = 890;BA.debugLine="Dim formatted As String = \"\"";
_formatted = "";
 //BA.debugLineNum = 891;BA.debugLine="If digits.Length >= 1 Then";
if (_digits.length()>=1) { 
 //BA.debugLineNum = 893;BA.debugLine="Dim firstDigit As Int = Asc(digits.CharAt(0)) -";
_firstdigit = (int) (__c.Asc(_digits.charAt((int) (0)))-48);
 //BA.debugLineNum = 894;BA.debugLine="If firstDigit > 1 Then";
if (_firstdigit>1) { 
 //BA.debugLineNum = 895;BA.debugLine="formatted = \"0\" & digits.SubString2(0, 1) & \"/\"";
_formatted = "0"+_digits.substring((int) (0),(int) (1))+"/";
 //BA.debugLineNum = 896;BA.debugLine="digits = digits.SubString(1)";
_digits = _digits.substring((int) (1));
 }else if(_digits.length()>=2) { 
 //BA.debugLineNum = 898;BA.debugLine="Dim month As Int = (Asc(digits.CharAt(0)) - 48)";
_month = (int) ((__c.Asc(_digits.charAt((int) (0)))-48)*10+(__c.Asc(_digits.charAt((int) (1)))-48));
 //BA.debugLineNum = 899;BA.debugLine="If month >= 1 And month <= 12 Then";
if (_month>=1 && _month<=12) { 
 //BA.debugLineNum = 900;BA.debugLine="formatted = digits.SubString2(0, 2) & \"/\"";
_formatted = _digits.substring((int) (0),(int) (2))+"/";
 //BA.debugLineNum = 901;BA.debugLine="digits = digits.SubString(2)";
_digits = _digits.substring((int) (2));
 }else if(_month>12) { 
 //BA.debugLineNum = 903;BA.debugLine="formatted = \"12/\"";
_formatted = "12/";
 //BA.debugLineNum = 904;BA.debugLine="digits = digits.SubString(2)";
_digits = _digits.substring((int) (2));
 }else {
 //BA.debugLineNum = 906;BA.debugLine="formatted = digits.SubString2(0, 2)";
_formatted = _digits.substring((int) (0),(int) (2));
 //BA.debugLineNum = 907;BA.debugLine="digits = \"\"";
_digits = "";
 };
 }else {
 //BA.debugLineNum = 910;BA.debugLine="formatted = digits";
_formatted = _digits;
 //BA.debugLineNum = 911;BA.debugLine="digits = \"\"";
_digits = "";
 };
 };
 //BA.debugLineNum = 916;BA.debugLine="If digits.Length > 0 Then";
if (_digits.length()>0) { 
 //BA.debugLineNum = 917;BA.debugLine="formatted = formatted & digits";
_formatted = _formatted+_digits;
 };
 //BA.debugLineNum = 921;BA.debugLine="If formatted <> New Then";
if ((_formatted).equals(_new) == false) { 
 //BA.debugLineNum = 922;BA.debugLine="edt.Text = formatted";
_edt.setText(BA.ObjectToCharSequence(_formatted));
 //BA.debugLineNum = 923;BA.debugLine="edt.SelectionStart = formatted.Length";
_edt.setSelectionStart(_formatted.length());
 };
 //BA.debugLineNum = 927;BA.debugLine="If index >= 0 And index < ItemsList.Size Then";
if (_index>=0 && _index<_itemslist.getSize()) { 
 //BA.debugLineNum = 928;BA.debugLine="Dim item As Map = ItemsList.Get(index)";
_item = new anywheresoftware.b4a.objects.collections.Map();
_item = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_itemslist.Get(_index)));
 //BA.debugLineNum = 929;BA.debugLine="Dim text As String = item.GetDefault(\"text\", \"\")";
_text = BA.ObjectToString(_item.GetDefault((Object)("text"),(Object)("")));
 //BA.debugLineNum = 930;BA.debugLine="Dim colonPos As Int = text.IndexOf(\":\")";
_colonpos = _text.indexOf(":");
 //BA.debugLineNum = 931;BA.debugLine="If colonPos > 0 Then";
if (_colonpos>0) { 
 //BA.debugLineNum = 932;BA.debugLine="item.Put(\"text\", text.SubString2(0, colonPos +";
_item.Put((Object)("text"),(Object)(_text.substring((int) (0),(int) (_colonpos+1))+" "+_formatted));
 };
 };
 //BA.debugLineNum = 935;BA.debugLine="End Sub";
return "";
}
public String  _edtcardnumber_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 1003;BA.debugLine="Private Sub edtCardNumber_FocusChanged(HasFocus As";
 //BA.debugLineNum = 1004;BA.debugLine="If HasFocus Then ScrollToCardField(Sender)";
if (_hasfocus) { 
_scrolltocardfield(__c.Sender(ba));};
 //BA.debugLineNum = 1005;BA.debugLine="End Sub";
return "";
}
public String  _edtcardnumber_textchanged(String _old,String _new) throws Exception{
anywheresoftware.b4a.objects.EditTextWrapper _edt = null;
int _index = 0;
String _digits = "";
int _i = 0;
int _charcode = 0;
String _formatted = "";
anywheresoftware.b4a.objects.collections.Map _item = null;
String _text = "";
int _colonpos = 0;
 //BA.debugLineNum = 828;BA.debugLine="Private Sub edtCardNumber_TextChanged(Old As Strin";
 //BA.debugLineNum = 829;BA.debugLine="If IsRebuildingUI Then Return";
if (_isrebuildingui) { 
if (true) return "";};
 //BA.debugLineNum = 831;BA.debugLine="Dim edt As EditText = Sender";
_edt = new anywheresoftware.b4a.objects.EditTextWrapper();
_edt = (anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(__c.Sender(ba)));
 //BA.debugLineNum = 832;BA.debugLine="Dim index As Int = edt.Tag";
_index = (int)(BA.ObjectToNumber(_edt.getTag()));
 //BA.debugLineNum = 835;BA.debugLine="Dim digits As String = \"\"";
_digits = "";
 //BA.debugLineNum = 836;BA.debugLine="For i = 0 To New.Length - 1";
{
final int step5 = 1;
final int limit5 = (int) (_new.length()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 837;BA.debugLine="Dim charCode As Int = Asc(New.CharAt(i))";
_charcode = __c.Asc(_new.charAt(_i));
 //BA.debugLineNum = 838;BA.debugLine="If charCode >= 48 And charCode <= 57 Then  '0-9";
if (_charcode>=48 && _charcode<=57) { 
 //BA.debugLineNum = 839;BA.debugLine="digits = digits & Chr(charCode)";
_digits = _digits+BA.ObjectToString(__c.Chr(_charcode));
 };
 }
};
 //BA.debugLineNum = 844;BA.debugLine="If digits.Length > 16 Then digits = digits.SubStr";
if (_digits.length()>16) { 
_digits = _digits.substring((int) (0),(int) (16));};
 //BA.debugLineNum = 847;BA.debugLine="Dim formatted As String = \"\"";
_formatted = "";
 //BA.debugLineNum = 848;BA.debugLine="For i = 0 To digits.Length - 1";
{
final int step13 = 1;
final int limit13 = (int) (_digits.length()-1);
_i = (int) (0) ;
for (;_i <= limit13 ;_i = _i + step13 ) {
 //BA.debugLineNum = 849;BA.debugLine="If i > 0 And i Mod 4 = 0 Then formatted = format";
if (_i>0 && _i%4==0) { 
_formatted = _formatted+" ";};
 //BA.debugLineNum = 850;BA.debugLine="formatted = formatted & digits.SubString2(i, i +";
_formatted = _formatted+_digits.substring(_i,(int) (_i+1));
 }
};
 //BA.debugLineNum = 854;BA.debugLine="If formatted <> New Then";
if ((_formatted).equals(_new) == false) { 
 //BA.debugLineNum = 855;BA.debugLine="edt.Text = formatted";
_edt.setText(BA.ObjectToCharSequence(_formatted));
 //BA.debugLineNum = 856;BA.debugLine="edt.SelectionStart = formatted.Length";
_edt.setSelectionStart(_formatted.length());
 };
 //BA.debugLineNum = 860;BA.debugLine="If index >= 0 And index < ItemsList.Size Then";
if (_index>=0 && _index<_itemslist.getSize()) { 
 //BA.debugLineNum = 861;BA.debugLine="Dim item As Map = ItemsList.Get(index)";
_item = new anywheresoftware.b4a.objects.collections.Map();
_item = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_itemslist.Get(_index)));
 //BA.debugLineNum = 862;BA.debugLine="Dim text As String = item.GetDefault(\"text\", \"\")";
_text = BA.ObjectToString(_item.GetDefault((Object)("text"),(Object)("")));
 //BA.debugLineNum = 863;BA.debugLine="Dim colonPos As Int = text.IndexOf(\":\")";
_colonpos = _text.indexOf(":");
 //BA.debugLineNum = 864;BA.debugLine="If colonPos > 0 Then";
if (_colonpos>0) { 
 //BA.debugLineNum = 865;BA.debugLine="item.Put(\"text\", text.SubString2(0, colonPos +";
_item.Put((Object)("text"),(Object)(_text.substring((int) (0),(int) (_colonpos+1))+" "+_formatted));
 };
 };
 //BA.debugLineNum = 868;BA.debugLine="End Sub";
return "";
}
public String  _edtcardvalue_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 999;BA.debugLine="Private Sub edtCardValue_FocusChanged(HasFocus As";
 //BA.debugLineNum = 1000;BA.debugLine="If HasFocus Then ScrollToCardField(Sender)";
if (_hasfocus) { 
_scrolltocardfield(__c.Sender(ba));};
 //BA.debugLineNum = 1001;BA.debugLine="End Sub";
return "";
}
public String  _edtcardvalue_textchanged(String _old,String _new) throws Exception{
anywheresoftware.b4a.objects.EditTextWrapper _edt = null;
int _index = 0;
anywheresoftware.b4a.objects.collections.Map _item = null;
String _text = "";
int _colonpos = 0;
String _labelpart = "";
 //BA.debugLineNum = 791;BA.debugLine="Private Sub edtCardValue_TextChanged(Old As String";
 //BA.debugLineNum = 792;BA.debugLine="If IsRebuildingUI Then Return";
if (_isrebuildingui) { 
if (true) return "";};
 //BA.debugLineNum = 794;BA.debugLine="Dim edt As EditText = Sender";
_edt = new anywheresoftware.b4a.objects.EditTextWrapper();
_edt = (anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(__c.Sender(ba)));
 //BA.debugLineNum = 795;BA.debugLine="Dim index As Int = edt.Tag";
_index = (int)(BA.ObjectToNumber(_edt.getTag()));
 //BA.debugLineNum = 797;BA.debugLine="If index >= 0 And index < ItemsList.Size Then";
if (_index>=0 && _index<_itemslist.getSize()) { 
 //BA.debugLineNum = 798;BA.debugLine="Dim item As Map = ItemsList.Get(index)";
_item = new anywheresoftware.b4a.objects.collections.Map();
_item = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_itemslist.Get(_index)));
 //BA.debugLineNum = 799;BA.debugLine="Dim text As String = item.GetDefault(\"text\", \"\")";
_text = BA.ObjectToString(_item.GetDefault((Object)("text"),(Object)("")));
 //BA.debugLineNum = 802;BA.debugLine="Dim colonPos As Int = text.IndexOf(\":\")";
_colonpos = _text.indexOf(":");
 //BA.debugLineNum = 803;BA.debugLine="If colonPos > 0 Then";
if (_colonpos>0) { 
 //BA.debugLineNum = 804;BA.debugLine="Dim labelPart As String = text.SubString2(0, co";
_labelpart = _text.substring((int) (0),(int) (_colonpos+1));
 //BA.debugLineNum = 805;BA.debugLine="item.Put(\"text\", labelPart & \" \" & New.Trim)";
_item.Put((Object)("text"),(Object)(_labelpart+" "+_new.trim()));
 }else {
 //BA.debugLineNum = 807;BA.debugLine="item.Put(\"text\", text & \": \" & New.Trim)";
_item.Put((Object)("text"),(Object)(_text+": "+_new.trim()));
 };
 };
 //BA.debugLineNum = 810;BA.debugLine="End Sub";
return "";
}
public String  _edtcontent_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 1797;BA.debugLine="Private Sub edtContent_FocusChanged(HasFocus As Bo";
 //BA.debugLineNum = 1798;BA.debugLine="If HasFocus Then svContent.ScrollPosition = edtCo";
if (_hasfocus) { 
_svcontent.setScrollPosition((int) (_edtcontent.getTop()-__c.DipToCurrent((int) (30))));};
 //BA.debugLineNum = 1799;BA.debugLine="End Sub";
return "";
}
public String  _edtfilter_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 1068;BA.debugLine="Private Sub edtFilter_TextChanged(Old As String, N";
 //BA.debugLineNum = 1069;BA.debugLine="CurrentFilter = New.Trim.ToLowerCase";
_currentfilter = _new.trim().toLowerCase();
 //BA.debugLineNum = 1070;BA.debugLine="RebuildItemsUI";
_rebuilditemsui();
 //BA.debugLineNum = 1071;BA.debugLine="End Sub";
return "";
}
public String  _edttitle_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 1793;BA.debugLine="Private Sub edtTitle_FocusChanged(HasFocus As Bool";
 //BA.debugLineNum = 1794;BA.debugLine="If HasFocus Then svContent.ScrollPosition = 0";
if (_hasfocus) { 
_svcontent.setScrollPosition((int) (0));};
 //BA.debugLineNum = 1795;BA.debugLine="End Sub";
return "";
}
public void  _focusattachinput() throws Exception{
ResumableSub_FocusAttachInput rsub = new ResumableSub_FocusAttachInput(this);
rsub.resume(ba, null);
}
public static class ResumableSub_FocusAttachInput extends BA.ResumableSub {
public ResumableSub_FocusAttachInput(com.lockzero.pagenoteedit parent) {
this.parent = parent;
}
com.lockzero.pagenoteedit parent;
anywheresoftware.b4j.object.JavaObject _imm = null;
anywheresoftware.b4j.object.JavaObject _ctxt = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 1581;BA.debugLine="Sleep(150)  'Aguarda dialog aparecer";
parent.__c.Sleep(ba,this,(int) (150));
this.state = 5;
return;
case 5:
//C
this.state = 1;
;
 //BA.debugLineNum = 1582;BA.debugLine="If edtAttachName.IsInitialized Then";
if (true) break;

case 1:
//if
this.state = 4;
if (parent._edtattachname.IsInitialized()) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 1583;BA.debugLine="edtAttachName.RequestFocus";
parent._edtattachname.RequestFocus();
 //BA.debugLineNum = 1584;BA.debugLine="edtAttachName.SelectAll";
parent._edtattachname.SelectAll();
 //BA.debugLineNum = 1586;BA.debugLine="Dim imm As JavaObject";
_imm = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 1587;BA.debugLine="Dim ctxt As JavaObject";
_ctxt = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 1588;BA.debugLine="ctxt.InitializeContext";
_ctxt.InitializeContext(ba);
 //BA.debugLineNum = 1589;BA.debugLine="imm = ctxt.RunMethod(\"getSystemService\", Array(\"";
_imm = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_ctxt.RunMethod("getSystemService",new Object[]{(Object)("input_method")})));
 //BA.debugLineNum = 1590;BA.debugLine="imm.RunMethod(\"showSoftInput\", Array(edtAttachNa";
_imm.RunMethod("showSoftInput",new Object[]{(Object)(parent._edtattachname.getObject()),(Object)(0)});
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 1592;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _getcardtitle() throws Exception{
anywheresoftware.b4a.objects.collections.Map _firstitem = null;
String _text = "";
int _colonpos = 0;
 //BA.debugLineNum = 813;BA.debugLine="Private Sub GetCardTitle As String";
 //BA.debugLineNum = 814;BA.debugLine="If ItemsList.IsInitialized = False Or ItemsList.S";
if (_itemslist.IsInitialized()==__c.False || _itemslist.getSize()==0) { 
if (true) return "";};
 //BA.debugLineNum = 816;BA.debugLine="Dim firstItem As Map = ItemsList.Get(0)";
_firstitem = new anywheresoftware.b4a.objects.collections.Map();
_firstitem = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_itemslist.Get((int) (0))));
 //BA.debugLineNum = 817;BA.debugLine="Dim text As String = firstItem.GetDefault(\"text\",";
_text = BA.ObjectToString(_firstitem.GetDefault((Object)("text"),(Object)("")));
 //BA.debugLineNum = 820;BA.debugLine="Dim colonPos As Int = text.IndexOf(\":\")";
_colonpos = _text.indexOf(":");
 //BA.debugLineNum = 821;BA.debugLine="If colonPos > 0 Then";
if (_colonpos>0) { 
 //BA.debugLineNum = 822;BA.debugLine="Return text.SubString(colonPos + 1).Trim";
if (true) return _text.substring((int) (_colonpos+1)).trim();
 };
 //BA.debugLineNum = 824;BA.debugLine="Return text.Trim";
if (true) return _text.trim();
 //BA.debugLineNum = 825;BA.debugLine="End Sub";
return "";
}
public String  _hideinputdialog() throws Exception{
anywheresoftware.b4a.objects.IME _ime = null;
 //BA.debugLineNum = 541;BA.debugLine="Private Sub HideInputDialog";
 //BA.debugLineNum = 542;BA.debugLine="pnlInputOverlay.Visible = False";
_pnlinputoverlay.setVisible(__c.False);
 //BA.debugLineNum = 543;BA.debugLine="EditingItemIndex = -1";
_editingitemindex = (int) (-1);
 //BA.debugLineNum = 544;BA.debugLine="Dim ime As IME";
_ime = new anywheresoftware.b4a.objects.IME();
 //BA.debugLineNum = 545;BA.debugLine="ime.Initialize(\"\")";
_ime.Initialize("");
 //BA.debugLineNum = 546;BA.debugLine="ime.HideKeyboard";
_ime.HideKeyboard(ba);
 //BA.debugLineNum = 547;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 76;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 77;BA.debugLine="ItemsList.Initialize";
_itemslist.Initialize();
 //BA.debugLineNum = 78;BA.debugLine="ItemPanels.Initialize";
_itempanels.Initialize();
 //BA.debugLineNum = 79;BA.debugLine="AttachmentsList.Initialize";
_attachmentslist.Initialize();
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return "";
}
public boolean  _itemmatchesfilter(String _itemtext) throws Exception{
String _normalizeditem = "";
String _normalizedfilter = "";
 //BA.debugLineNum = 1093;BA.debugLine="Private Sub ItemMatchesFilter(itemText As String)";
 //BA.debugLineNum = 1094;BA.debugLine="If CurrentFilter.Length = 0 Then Return True";
if (_currentfilter.length()==0) { 
if (true) return __c.True;};
 //BA.debugLineNum = 1095;BA.debugLine="Dim normalizedItem As String = RemoveAccents(item";
_normalizeditem = _removeaccents(_itemtext);
 //BA.debugLineNum = 1096;BA.debugLine="Dim normalizedFilter As String = RemoveAccents(Cu";
_normalizedfilter = _removeaccents(_currentfilter);
 //BA.debugLineNum = 1097;BA.debugLine="Return normalizedItem.Contains(normalizedFilter)";
if (true) return _normalizeditem.contains(_normalizedfilter);
 //BA.debugLineNum = 1098;BA.debugLine="End Sub";
return false;
}
public String  _iviconattach_click() throws Exception{
 //BA.debugLineNum = 1490;BA.debugLine="Private Sub ivIconAttach_Click";
 //BA.debugLineNum = 1491;BA.debugLine="If IsSecure Then ModSession.Touch";
if (_issecure) { 
_modsession._touch /*String*/ (ba);};
 //BA.debugLineNum = 1492;BA.debugLine="ContentChooser1.Show(\"*/*\", ModLang.T(\"select_fil";
_contentchooser1.Show(ba,"*/*",_modlang._t /*String*/ (ba,"select_file"));
 //BA.debugLineNum = 1493;BA.debugLine="End Sub";
return "";
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
 //BA.debugLineNum = 1385;BA.debugLine="If IsSecure Then ModSession.Touch";
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
 //BA.debugLineNum = 1387;BA.debugLine="Wait For (xui.Msgbox2Async(ModLang.T(\"confirm_del";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"confirm_delete")),BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"delete")),parent._modlang._t /*String*/ (ba,"yes"),"",parent._modlang._t /*String*/ (ba,"cancel"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 11;
return;
case 11:
//C
this.state = 7;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 1389;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
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
 //BA.debugLineNum = 1390;BA.debugLine="ModNotes.DeleteNote(CurrentNoteId)";
parent._modnotes._deletenote /*String*/ (ba,parent._currentnoteid);
 //BA.debugLineNum = 1391;BA.debugLine="ToastMessageShow(ModLang.T(\"success\"), False)";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"success")),parent.__c.False);
 //BA.debugLineNum = 1392;BA.debugLine="B4XPages.ClosePage(Me)";
parent._b4xpages._closepage /*String*/ (ba,parent);
 if (true) break;

case 10:
//C
this.state = -1;
;
 //BA.debugLineNum = 1394;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
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
 //BA.debugLineNum = 1398;BA.debugLine="If ItemsList.Size = 0 Then";
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
 //BA.debugLineNum = 1399;BA.debugLine="ToastMessageShow(ModLang.T(\"empty\"), True)";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"empty")),parent.__c.True);
 //BA.debugLineNum = 1400;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
 //BA.debugLineNum = 1404;BA.debugLine="If IsCardTemplate Then";

case 4:
//if
this.state = 7;
if (parent._iscardtemplate) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 1405;BA.debugLine="ShareCard";
parent._sharecard();
 //BA.debugLineNum = 1406;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 7:
//C
this.state = 8;
;
 //BA.debugLineNum = 1410;BA.debugLine="Wait For (xui.Msgbox2Async(ModLang.T(\"share_which";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"share_which")),BA.ObjectToCharSequence(parent._modlang._t /*String*/ (ba,"share")),parent._modlang._t /*String*/ (ba,"share_all"),parent._modlang._t /*String*/ (ba,"cancel"),parent._modlang._t /*String*/ (ba,"share_checked"),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 14;
return;
case 14:
//C
this.state = 8;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 1412;BA.debugLine="If Result = xui.DialogResponse_Negative Then";
if (true) break;

case 8:
//if
this.state = 13;
if (_result==parent._xui.DialogResponse_Negative) { 
this.state = 10;
}else if(_result==parent._xui.DialogResponse_Positive) { 
this.state = 12;
}if (true) break;

case 10:
//C
this.state = 13;
 //BA.debugLineNum = 1414;BA.debugLine="ShareItems(True)";
parent._shareitems(parent.__c.True);
 if (true) break;

case 12:
//C
this.state = 13;
 //BA.debugLineNum = 1417;BA.debugLine="ShareItems(False)";
parent._shareitems(parent.__c.False);
 if (true) break;

case 13:
//C
this.state = -1;
;
 //BA.debugLineNum = 1419;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _lbladditem_click() throws Exception{
 //BA.debugLineNum = 1036;BA.debugLine="Private Sub lblAddItem_Click";
 //BA.debugLineNum = 1037;BA.debugLine="If IsSecure Then ModSession.Touch";
if (_issecure) { 
_modsession._touch /*String*/ (ba);};
 //BA.debugLineNum = 1038;BA.debugLine="ShowInputDialog(ModLang.T(\"note_add_item\"), \"\", -";
_showinputdialog(_modlang._t /*String*/ (ba,"note_add_item"),"",(int) (-1));
 //BA.debugLineNum = 1039;BA.debugLine="End Sub";
return "";
}
public String  _lblattachopen_click() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
int _index = 0;
Object _item = null;
String _uri = "";
String _filename = "";
anywheresoftware.b4a.objects.collections.Map _attachment = null;
 //BA.debugLineNum = 1693;BA.debugLine="Private Sub lblAttachOpen_Click";
 //BA.debugLineNum = 1694;BA.debugLine="Dim lbl As Label = Sender";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
_lbl = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(__c.Sender(ba)));
 //BA.debugLineNum = 1695;BA.debugLine="Dim index As Int = lbl.Tag";
_index = (int)(BA.ObjectToNumber(_lbl.getTag()));
 //BA.debugLineNum = 1697;BA.debugLine="If index < 0 Or index >= AttachmentsList.Size The";
if (_index<0 || _index>=_attachmentslist.getSize()) { 
if (true) return "";};
 //BA.debugLineNum = 1699;BA.debugLine="Dim item As Object = AttachmentsList.Get(index)";
_item = _attachmentslist.Get(_index);
 //BA.debugLineNum = 1700;BA.debugLine="Dim uri As String = \"\"";
_uri = "";
 //BA.debugLineNum = 1701;BA.debugLine="Dim fileName As String = \"\"";
_filename = "";
 //BA.debugLineNum = 1703;BA.debugLine="If item Is Map Then";
if (_item instanceof java.util.Map) { 
 //BA.debugLineNum = 1704;BA.debugLine="Dim attachment As Map = item";
_attachment = new anywheresoftware.b4a.objects.collections.Map();
_attachment = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_item));
 //BA.debugLineNum = 1706;BA.debugLine="uri = attachment.GetDefault(\"uri\", \"\")";
_uri = BA.ObjectToString(_attachment.GetDefault((Object)("uri"),(Object)("")));
 //BA.debugLineNum = 1707;BA.debugLine="If uri = \"\" Then uri = attachment.GetDefault(\"di";
if ((_uri).equals("")) { 
_uri = BA.ObjectToString(_attachment.GetDefault((Object)("dir"),(Object)("")));};
 //BA.debugLineNum = 1708;BA.debugLine="fileName = attachment.GetDefault(\"name\", \"\")";
_filename = BA.ObjectToString(_attachment.GetDefault((Object)("name"),(Object)("")));
 };
 //BA.debugLineNum = 1711;BA.debugLine="If uri <> \"\" Then";
if ((_uri).equals("") == false) { 
 //BA.debugLineNum = 1712;BA.debugLine="OpenFileWithUri(uri, fileName)";
_openfilewithuri(_uri,_filename);
 }else {
 //BA.debugLineNum = 1714;BA.debugLine="ToastMessageShow(ModLang.T(\"file_not_found\"), Tr";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"file_not_found")),__c.True);
 };
 //BA.debugLineNum = 1716;BA.debugLine="End Sub";
return "";
}
public String  _lblattachremove_click() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
int _index = 0;
 //BA.debugLineNum = 1778;BA.debugLine="Private Sub lblAttachRemove_Click";
 //BA.debugLineNum = 1779;BA.debugLine="Dim lbl As Label = Sender";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
_lbl = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(__c.Sender(ba)));
 //BA.debugLineNum = 1780;BA.debugLine="Dim index As Int = lbl.Tag";
_index = (int)(BA.ObjectToNumber(_lbl.getTag()));
 //BA.debugLineNum = 1782;BA.debugLine="If index >= 0 And index < AttachmentsList.Size Th";
if (_index>=0 && _index<_attachmentslist.getSize()) { 
 //BA.debugLineNum = 1783;BA.debugLine="AttachmentsList.RemoveAt(index)";
_attachmentslist.RemoveAt(_index);
 //BA.debugLineNum = 1784;BA.debugLine="RebuildAttachmentsUI";
_rebuildattachmentsui();
 };
 //BA.debugLineNum = 1786;BA.debugLine="End Sub";
return "";
}
public String  _lblclearfilter_click() throws Exception{
 //BA.debugLineNum = 1074;BA.debugLine="Private Sub lblClearFilter_Click";
 //BA.debugLineNum = 1075;BA.debugLine="edtFilter.Text = \"\"";
_edtfilter.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1076;BA.debugLine="CurrentFilter = \"\"";
_currentfilter = "";
 //BA.debugLineNum = 1077;BA.debugLine="RebuildItemsUI";
_rebuilditemsui();
 //BA.debugLineNum = 1078;BA.debugLine="End Sub";
return "";
}
public String  _lbliconadd_click() throws Exception{
 //BA.debugLineNum = 1378;BA.debugLine="Private Sub lblIconAdd_Click";
 //BA.debugLineNum = 1379;BA.debugLine="If IsSecure Then ModSession.Touch";
if (_issecure) { 
_modsession._touch /*String*/ (ba);};
 //BA.debugLineNum = 1380;BA.debugLine="ShowInputDialog(ModLang.T(\"note_add_item\"), \"\", -";
_showinputdialog(_modlang._t /*String*/ (ba,"note_add_item"),"",(int) (-1));
 //BA.debugLineNum = 1381;BA.debugLine="End Sub";
return "";
}
public String  _lbliconsave_click() throws Exception{
 //BA.debugLineNum = 1789;BA.debugLine="Private Sub lblIconSave_Click";
 //BA.debugLineNum = 1790;BA.debugLine="SaveNote(True)";
_savenote(__c.True);
 //BA.debugLineNum = 1791;BA.debugLine="End Sub";
return "";
}
public String  _lblitem_click() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
int _index = 0;
 //BA.debugLineNum = 1061;BA.debugLine="Private Sub lblItem_Click";
 //BA.debugLineNum = 1062;BA.debugLine="Dim lbl As Label = Sender";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
_lbl = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(__c.Sender(ba)));
 //BA.debugLineNum = 1063;BA.debugLine="Dim index As Int = lbl.Tag";
_index = (int)(BA.ObjectToNumber(_lbl.getTag()));
 //BA.debugLineNum = 1064;BA.debugLine="EditItem(index)";
_edititem(_index);
 //BA.debugLineNum = 1065;BA.debugLine="End Sub";
return "";
}
public String  _loadnote() throws Exception{
com.lockzero.clsnoteentry _note = null;
String _decrypteditems = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
String _attachjson = "";
anywheresoftware.b4a.objects.collections.JSONParser _parseratt = null;
 //BA.debugLineNum = 1134;BA.debugLine="Private Sub LoadNote";
 //BA.debugLineNum = 1135;BA.debugLine="Dim note As clsNoteEntry = ModNotes.GetNoteById(C";
_note = _modnotes._getnotebyid /*com.lockzero.clsnoteentry*/ (ba,_currentnoteid);
 //BA.debugLineNum = 1136;BA.debugLine="If note = Null Then";
if (_note== null) { 
 //BA.debugLineNum = 1137;BA.debugLine="ToastMessageShow(ModLang.T(\"error_not_found\"), T";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error_not_found")),__c.True);
 //BA.debugLineNum = 1138;BA.debugLine="B4XPages.ClosePage(Me)";
_b4xpages._closepage /*String*/ (ba,this);
 //BA.debugLineNum = 1139;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 1143;BA.debugLine="NoteType = note.NoteType";
_notetype = _note._notetype /*String*/ ;
 //BA.debugLineNum = 1144;BA.debugLine="SetupModeUI";
_setupmodeui();
 //BA.debugLineNum = 1147;BA.debugLine="If IsSecure Then";
if (_issecure) { 
 //BA.debugLineNum = 1148;BA.debugLine="edtTitle.Text = note.GetDecryptedTitle(Passphras";
_edttitle.setText(BA.ObjectToCharSequence(_note._getdecryptedtitle /*String*/ (_passphrase)));
 }else {
 //BA.debugLineNum = 1150;BA.debugLine="edtTitle.Text = note.Title";
_edttitle.setText(BA.ObjectToCharSequence(_note._title /*String*/ ));
 };
 //BA.debugLineNum = 1152;BA.debugLine="CurrentNoteTitle = edtTitle.Text  'Guarda para br";
_currentnotetitle = _edttitle.getText();
 //BA.debugLineNum = 1154;BA.debugLine="chkFavorite.Checked = note.IsFavorite";
_chkfavorite.setChecked(_note._isfavorite /*boolean*/ );
 //BA.debugLineNum = 1156;BA.debugLine="If NoteType = \"list\" Then";
if ((_notetype).equals("list")) { 
 //BA.debugLineNum = 1158;BA.debugLine="If IsSecure Then";
if (_issecure) { 
 //BA.debugLineNum = 1159;BA.debugLine="Dim decryptedItems As String = note.GetDecrypte";
_decrypteditems = _note._getdecrypteditems /*String*/ (_passphrase);
 //BA.debugLineNum = 1160;BA.debugLine="If decryptedItems <> \"\" And decryptedItems <> \"";
if ((_decrypteditems).equals("") == false && (_decrypteditems).equals("[]") == false) { 
 //BA.debugLineNum = 1161;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 1162;BA.debugLine="parser.Initialize(decryptedItems)";
_parser.Initialize(_decrypteditems);
 //BA.debugLineNum = 1163;BA.debugLine="ItemsList = parser.NextArray";
_itemslist = _parser.NextArray();
 };
 }else {
 //BA.debugLineNum = 1166;BA.debugLine="ItemsList = note.GetItemsList";
_itemslist = _note._getitemslist /*anywheresoftware.b4a.objects.collections.List*/ ();
 };
 //BA.debugLineNum = 1168;BA.debugLine="RebuildItemsUI";
_rebuilditemsui();
 }else {
 //BA.debugLineNum = 1171;BA.debugLine="If IsSecure Then";
if (_issecure) { 
 //BA.debugLineNum = 1172;BA.debugLine="edtContent.Text = note.GetDecryptedContent(Pass";
_edtcontent.setText(BA.ObjectToCharSequence(_note._getdecryptedcontent /*String*/ (_passphrase)));
 }else {
 //BA.debugLineNum = 1174;BA.debugLine="edtContent.Text = note.Content";
_edtcontent.setText(BA.ObjectToCharSequence(_note._content /*String*/ ));
 };
 };
 //BA.debugLineNum = 1179;BA.debugLine="If IsCardTemplate = False Then";
if (_iscardtemplate==__c.False) { 
 //BA.debugLineNum = 1180;BA.debugLine="AttachmentsList.Initialize";
_attachmentslist.Initialize();
 //BA.debugLineNum = 1181;BA.debugLine="Dim attachJson As String";
_attachjson = "";
 //BA.debugLineNum = 1182;BA.debugLine="If IsSecure Then";
if (_issecure) { 
 //BA.debugLineNum = 1183;BA.debugLine="attachJson = note.GetDecryptedAttachments(Passp";
_attachjson = _note._getdecryptedattachments /*String*/ (_passphrase);
 }else {
 //BA.debugLineNum = 1185;BA.debugLine="attachJson = note.Attachments";
_attachjson = _note._attachments /*String*/ ;
 };
 //BA.debugLineNum = 1187;BA.debugLine="If attachJson <> \"\" And attachJson <> \"[]\" Then";
if ((_attachjson).equals("") == false && (_attachjson).equals("[]") == false) { 
 //BA.debugLineNum = 1188;BA.debugLine="Try";
try { //BA.debugLineNum = 1189;BA.debugLine="Dim parserAtt As JSONParser";
_parseratt = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 1190;BA.debugLine="parserAtt.Initialize(attachJson)";
_parseratt.Initialize(_attachjson);
 //BA.debugLineNum = 1191;BA.debugLine="AttachmentsList = parserAtt.NextArray";
_attachmentslist = _parseratt.NextArray();
 } 
       catch (Exception e49) {
			ba.setLastException(e49); //BA.debugLineNum = 1193;BA.debugLine="Log(\"LoadNote: erro ao parsear anexos\")";
__c.LogImpl("621889083","LoadNote: erro ao parsear anexos",0);
 };
 };
 //BA.debugLineNum = 1196;BA.debugLine="RebuildAttachmentsUI";
_rebuildattachmentsui();
 };
 //BA.debugLineNum = 1198;BA.debugLine="End Sub";
return "";
}
public String  _openfilewithuri(String _uri,String _displayname) throws Exception{
String _mimetype = "";
String _lowername = "";
anywheresoftware.b4j.object.JavaObject _uriparser = null;
Object _parseduri = null;
anywheresoftware.b4a.objects.IntentWrapper _openintent = null;
anywheresoftware.b4j.object.JavaObject _intentjo = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 1719;BA.debugLine="Private Sub OpenFileWithUri(uri As String, display";
 //BA.debugLineNum = 1720;BA.debugLine="Try";
try { //BA.debugLineNum = 1721;BA.debugLine="Log(\"OpenFileWithUri: uri=\" & uri & \", name=\" &";
__c.LogImpl("622740994","OpenFileWithUri: uri="+_uri+", name="+_displayname,0);
 //BA.debugLineNum = 1724;BA.debugLine="Dim mimeType As String = \"*/*\"";
_mimetype = "*/*";
 //BA.debugLineNum = 1725;BA.debugLine="Dim lowerName As String = displayName.ToLowerCas";
_lowername = _displayname.toLowerCase();
 //BA.debugLineNum = 1726;BA.debugLine="If lowerName.EndsWith(\".pdf\") Then mimeType = \"a";
if (_lowername.endsWith(".pdf")) { 
_mimetype = "application/pdf";};
 //BA.debugLineNum = 1727;BA.debugLine="If lowerName.EndsWith(\".jpg\") Or lowerName.EndsW";
if (_lowername.endsWith(".jpg") || _lowername.endsWith(".jpeg")) { 
_mimetype = "image/jpeg";};
 //BA.debugLineNum = 1728;BA.debugLine="If lowerName.EndsWith(\".png\") Then mimeType = \"i";
if (_lowername.endsWith(".png")) { 
_mimetype = "image/png";};
 //BA.debugLineNum = 1729;BA.debugLine="If lowerName.EndsWith(\".gif\") Then mimeType = \"i";
if (_lowername.endsWith(".gif")) { 
_mimetype = "image/gif";};
 //BA.debugLineNum = 1730;BA.debugLine="If lowerName.EndsWith(\".webp\") Then mimeType = \"";
if (_lowername.endsWith(".webp")) { 
_mimetype = "image/webp";};
 //BA.debugLineNum = 1731;BA.debugLine="If lowerName.EndsWith(\".bmp\") Then mimeType = \"i";
if (_lowername.endsWith(".bmp")) { 
_mimetype = "image/bmp";};
 //BA.debugLineNum = 1732;BA.debugLine="If lowerName.EndsWith(\".doc\") Then mimeType = \"a";
if (_lowername.endsWith(".doc")) { 
_mimetype = "application/msword";};
 //BA.debugLineNum = 1733;BA.debugLine="If lowerName.EndsWith(\".docx\") Then mimeType = \"";
if (_lowername.endsWith(".docx")) { 
_mimetype = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";};
 //BA.debugLineNum = 1734;BA.debugLine="If lowerName.EndsWith(\".xls\") Then mimeType = \"a";
if (_lowername.endsWith(".xls")) { 
_mimetype = "application/vnd.ms-excel";};
 //BA.debugLineNum = 1735;BA.debugLine="If lowerName.EndsWith(\".xlsx\") Then mimeType = \"";
if (_lowername.endsWith(".xlsx")) { 
_mimetype = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";};
 //BA.debugLineNum = 1736;BA.debugLine="If lowerName.EndsWith(\".txt\") Then mimeType = \"t";
if (_lowername.endsWith(".txt")) { 
_mimetype = "text/plain";};
 //BA.debugLineNum = 1737;BA.debugLine="If lowerName.EndsWith(\".mp4\") Then mimeType = \"v";
if (_lowername.endsWith(".mp4")) { 
_mimetype = "video/mp4";};
 //BA.debugLineNum = 1738;BA.debugLine="If lowerName.EndsWith(\".mp3\") Then mimeType = \"a";
if (_lowername.endsWith(".mp3")) { 
_mimetype = "audio/mpeg";};
 //BA.debugLineNum = 1739;BA.debugLine="If lowerName.EndsWith(\".wav\") Then mimeType = \"a";
if (_lowername.endsWith(".wav")) { 
_mimetype = "audio/wav";};
 //BA.debugLineNum = 1740;BA.debugLine="If lowerName.EndsWith(\".zip\") Then mimeType = \"a";
if (_lowername.endsWith(".zip")) { 
_mimetype = "application/zip";};
 //BA.debugLineNum = 1743;BA.debugLine="If mimeType = \"*/*\" Then";
if ((_mimetype).equals("*/*")) { 
 //BA.debugLineNum = 1745;BA.debugLine="If uri.Contains(\"image\") Or uri.Contains(\"photo";
if (_uri.contains("image") || _uri.contains("photo") || _uri.contains("camera")) { 
 //BA.debugLineNum = 1746;BA.debugLine="mimeType = \"image/*\"";
_mimetype = "image/*";
 }else if(_uri.contains("video")) { 
 //BA.debugLineNum = 1748;BA.debugLine="mimeType = \"video/*\"";
_mimetype = "video/*";
 }else if(_uri.contains("audio")) { 
 //BA.debugLineNum = 1750;BA.debugLine="mimeType = \"audio/*\"";
_mimetype = "audio/*";
 };
 };
 //BA.debugLineNum = 1754;BA.debugLine="Log(\"OpenFileWithUri: mimeType=\" & mimeType)";
__c.LogImpl("622741027","OpenFileWithUri: mimeType="+_mimetype,0);
 //BA.debugLineNum = 1757;BA.debugLine="Dim uriParser As JavaObject";
_uriparser = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 1758;BA.debugLine="uriParser.InitializeStatic(\"android.net.Uri\")";
_uriparser.InitializeStatic("android.net.Uri");
 //BA.debugLineNum = 1759;BA.debugLine="Dim parsedUri As Object = uriParser.RunMethod(\"p";
_parseduri = _uriparser.RunMethod("parse",new Object[]{(Object)(_uri)});
 //BA.debugLineNum = 1762;BA.debugLine="Dim openIntent As Intent";
_openintent = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 1763;BA.debugLine="openIntent.Initialize(openIntent.ACTION_VIEW, \"\"";
_openintent.Initialize(_openintent.ACTION_VIEW,"");
 //BA.debugLineNum = 1764;BA.debugLine="Dim intentJO As JavaObject = openIntent";
_intentjo = new anywheresoftware.b4j.object.JavaObject();
_intentjo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_openintent.getObject()));
 //BA.debugLineNum = 1765;BA.debugLine="intentJO.RunMethod(\"setDataAndType\", Array(parse";
_intentjo.RunMethod("setDataAndType",new Object[]{_parseduri,(Object)(_mimetype)});
 //BA.debugLineNum = 1766;BA.debugLine="intentJO.RunMethod(\"addFlags\", Array(1))  'FLAG_";
_intentjo.RunMethod("addFlags",new Object[]{(Object)(1)});
 //BA.debugLineNum = 1768;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 1769;BA.debugLine="jo.InitializeStatic(\"android.content.Intent\")";
_jo.InitializeStatic("android.content.Intent");
 //BA.debugLineNum = 1770;BA.debugLine="StartActivity(jo.RunMethod(\"createChooser\", Arra";
__c.StartActivity(ba,_jo.RunMethod("createChooser",new Object[]{(Object)(_openintent.getObject()),(Object)(_modlang._t /*String*/ (ba,"open_file"))}));
 } 
       catch (Exception e42) {
			ba.setLastException(e42); //BA.debugLineNum = 1772;BA.debugLine="Log(\"OpenFileWithUri error: \" & LastException.Me";
__c.LogImpl("622741045","OpenFileWithUri error: "+__c.LastException(ba).getMessage(),0);
 //BA.debugLineNum = 1773;BA.debugLine="ToastMessageShow(ModLang.T(\"file_not_found\"), Tr";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"file_not_found")),__c.True);
 };
 //BA.debugLineNum = 1775;BA.debugLine="End Sub";
return "";
}
public String  _pnlinputoverlay_click() throws Exception{
 //BA.debugLineNum = 549;BA.debugLine="Private Sub pnlInputOverlay_Click";
 //BA.debugLineNum = 550;BA.debugLine="HideInputDialog";
_hideinputdialog();
 //BA.debugLineNum = 551;BA.debugLine="End Sub";
return "";
}
public String  _rebuildattachmentsui() throws Exception{
int _width = 0;
int _y = 0;
int _itemheight = 0;
anywheresoftware.b4a.objects.LabelWrapper _lblattachtitle = null;
int _i = 0;
Object _item = null;
String _filename = "";
anywheresoftware.b4a.objects.collections.Map _attachment = null;
anywheresoftware.b4a.objects.PanelWrapper _pnlitem = null;
 //BA.debugLineNum = 1595;BA.debugLine="Private Sub RebuildAttachmentsUI";
 //BA.debugLineNum = 1596;BA.debugLine="pnlAttachments.RemoveAllViews";
_pnlattachments.RemoveAllViews();
 //BA.debugLineNum = 1598;BA.debugLine="Dim width As Int = pnlAttachments.Width";
_width = _pnlattachments.getWidth();
 //BA.debugLineNum = 1599;BA.debugLine="Dim y As Int = 0";
_y = (int) (0);
 //BA.debugLineNum = 1600;BA.debugLine="Dim itemHeight As Int = 44dip";
_itemheight = __c.DipToCurrent((int) (44));
 //BA.debugLineNum = 1603;BA.debugLine="If AttachmentsList.Size > 0 Then";
if (_attachmentslist.getSize()>0) { 
 //BA.debugLineNum = 1604;BA.debugLine="Dim lblAttachTitle As Label";
_lblattachtitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 1605;BA.debugLine="lblAttachTitle.Initialize(\"\")";
_lblattachtitle.Initialize(ba,"");
 //BA.debugLineNum = 1606;BA.debugLine="lblAttachTitle.Text = ModLang.T(\"attachments\") &";
_lblattachtitle.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"attachments")+" ("+BA.NumberToString(_attachmentslist.getSize())+")"));
 //BA.debugLineNum = 1607;BA.debugLine="lblAttachTitle.TextSize = Starter.FONT_LABEL";
_lblattachtitle.setTextSize(_starter._font_label /*float*/ );
 //BA.debugLineNum = 1608;BA.debugLine="lblAttachTitle.TextColor = Colors.ARGB(180, 255,";
_lblattachtitle.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 1609;BA.debugLine="lblAttachTitle.Gravity = Gravity.CENTER_VERTICAL";
_lblattachtitle.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 1610;BA.debugLine="pnlAttachments.AddView(lblAttachTitle, 0, y, wid";
_pnlattachments.AddView((android.view.View)(_lblattachtitle.getObject()),(int) (0),_y,_width,__c.DipToCurrent((int) (24)));
 //BA.debugLineNum = 1611;BA.debugLine="y = y + 28dip";
_y = (int) (_y+__c.DipToCurrent((int) (28)));
 };
 //BA.debugLineNum = 1615;BA.debugLine="For i = 0 To AttachmentsList.Size - 1";
{
final int step15 = 1;
final int limit15 = (int) (_attachmentslist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit15 ;_i = _i + step15 ) {
 //BA.debugLineNum = 1616;BA.debugLine="Dim item As Object = AttachmentsList.Get(i)";
_item = _attachmentslist.Get(_i);
 //BA.debugLineNum = 1617;BA.debugLine="Dim fileName As String = \"\"";
_filename = "";
 //BA.debugLineNum = 1620;BA.debugLine="If item Is Map Then";
if (_item instanceof java.util.Map) { 
 //BA.debugLineNum = 1621;BA.debugLine="Dim attachment As Map = item";
_attachment = new anywheresoftware.b4a.objects.collections.Map();
_attachment = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_item));
 //BA.debugLineNum = 1622;BA.debugLine="fileName = attachment.GetDefault(\"name\", \"\")";
_filename = BA.ObjectToString(_attachment.GetDefault((Object)("name"),(Object)("")));
 }else if(_item instanceof String) { 
 //BA.debugLineNum = 1625;BA.debugLine="fileName = item";
_filename = BA.ObjectToString(_item);
 };
 //BA.debugLineNum = 1628;BA.debugLine="If fileName <> \"\" Then";
if ((_filename).equals("") == false) { 
 //BA.debugLineNum = 1629;BA.debugLine="Dim pnlItem As Panel = CreateAttachmentPanel(i,";
_pnlitem = new anywheresoftware.b4a.objects.PanelWrapper();
_pnlitem = _createattachmentpanel(_i,_filename,_width);
 //BA.debugLineNum = 1630;BA.debugLine="pnlAttachments.AddView(pnlItem, 0, y, width, it";
_pnlattachments.AddView((android.view.View)(_pnlitem.getObject()),(int) (0),_y,_width,_itemheight);
 //BA.debugLineNum = 1631;BA.debugLine="y = y + itemHeight + 6dip";
_y = (int) (_y+_itemheight+__c.DipToCurrent((int) (6)));
 };
 }
};
 //BA.debugLineNum = 1636;BA.debugLine="pnlAttachments.Height = Max(y, 10dip)";
_pnlattachments.setHeight((int) (__c.Max(_y,__c.DipToCurrent((int) (10)))));
 //BA.debugLineNum = 1639;BA.debugLine="If NoteType = \"text\" Then";
if ((_notetype).equals("text")) { 
 //BA.debugLineNum = 1640;BA.debugLine="pnlAttachments.Top = pnlTextMode.Top + pnlTextMo";
_pnlattachments.setTop((int) (_pnltextmode.getTop()+_pnltextmode.getHeight()+__c.DipToCurrent((int) (10))));
 //BA.debugLineNum = 1641;BA.debugLine="pnlContent.Height = pnlAttachments.Top + pnlAtta";
_pnlcontent.setHeight((int) (_pnlattachments.getTop()+_pnlattachments.getHeight()+__c.DipToCurrent((int) (50))));
 }else if(_iscardtemplate==__c.False) { 
 //BA.debugLineNum = 1643;BA.debugLine="pnlAttachments.Top = pnlListMode.Top + pnlListMo";
_pnlattachments.setTop((int) (_pnllistmode.getTop()+_pnllistmode.getHeight()+__c.DipToCurrent((int) (10))));
 //BA.debugLineNum = 1644;BA.debugLine="pnlContent.Height = Max(pnlContent.Height, pnlAt";
_pnlcontent.setHeight((int) (__c.Max(_pnlcontent.getHeight(),_pnlattachments.getTop()+_pnlattachments.getHeight()+__c.DipToCurrent((int) (50)))));
 };
 //BA.debugLineNum = 1646;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 620;BA.debugLine="Private Sub RebuildItemsUI";
 //BA.debugLineNum = 621;BA.debugLine="IsRebuildingUI = True  'Bloqueia eventos de check";
_isrebuildingui = __c.True;
 //BA.debugLineNum = 623;BA.debugLine="pnlItems.RemoveAllViews";
_pnlitems.RemoveAllViews();
 //BA.debugLineNum = 624;BA.debugLine="ItemPanels.Initialize";
_itempanels.Initialize();
 //BA.debugLineNum = 626;BA.debugLine="Dim width As Int = pnlItems.Width";
_width = _pnlitems.getWidth();
 //BA.debugLineNum = 627;BA.debugLine="Dim itemHeight As Int = 50dip";
_itemheight = __c.DipToCurrent((int) (50));
 //BA.debugLineNum = 628;BA.debugLine="Dim y As Int = 0";
_y = (int) (0);
 //BA.debugLineNum = 631;BA.debugLine="If IsCardTemplate Then";
if (_iscardtemplate) { 
 //BA.debugLineNum = 632;BA.debugLine="pnlItems.Top = 0";
_pnlitems.setTop((int) (0));
 }else {
 //BA.debugLineNum = 634;BA.debugLine="pnlItems.Top = 52dip";
_pnlitems.setTop(__c.DipToCurrent((int) (52)));
 };
 //BA.debugLineNum = 637;BA.debugLine="For i = 0 To ItemsList.Size - 1";
{
final int step12 = 1;
final int limit12 = (int) (_itemslist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit12 ;_i = _i + step12 ) {
 //BA.debugLineNum = 638;BA.debugLine="Dim item As Map = ItemsList.Get(i)";
_item = new anywheresoftware.b4a.objects.collections.Map();
_item = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_itemslist.Get(_i)));
 //BA.debugLineNum = 639;BA.debugLine="Dim itemText As String = item.GetDefault(\"text\",";
_itemtext = BA.ObjectToString(_item.GetDefault((Object)("text"),(Object)("")));
 //BA.debugLineNum = 642;BA.debugLine="If IsCardTemplate = False And ItemMatchesFilter(";
if (_iscardtemplate==__c.False && _itemmatchesfilter(_itemtext)==__c.False) { 
if (true) continue;};
 //BA.debugLineNum = 645;BA.debugLine="Dim pnlItem As Panel";
_pnlitem = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 646;BA.debugLine="If IsCardTemplate Then";
if (_iscardtemplate) { 
 //BA.debugLineNum = 647;BA.debugLine="pnlItem = CreateCardItemPanel(i, item, width)";
_pnlitem = _createcarditempanel(_i,_item,_width);
 }else {
 //BA.debugLineNum = 649;BA.debugLine="pnlItem = CreateItemPanel(i, item, width)";
_pnlitem = _createitempanel(_i,_item,_width);
 };
 //BA.debugLineNum = 651;BA.debugLine="pnlItems.AddView(pnlItem, 0, y, width, itemHeigh";
_pnlitems.AddView((android.view.View)(_pnlitem.getObject()),(int) (0),_y,_width,_itemheight);
 //BA.debugLineNum = 652;BA.debugLine="ItemPanels.Add(pnlItem)";
_itempanels.Add((Object)(_pnlitem.getObject()));
 //BA.debugLineNum = 653;BA.debugLine="y = y + itemHeight + 8dip";
_y = (int) (_y+_itemheight+__c.DipToCurrent((int) (8)));
 }
};
 //BA.debugLineNum = 657;BA.debugLine="pnlItems.Height = Max(y, 50dip)";
_pnlitems.setHeight((int) (__c.Max(_y,__c.DipToCurrent((int) (50)))));
 //BA.debugLineNum = 660;BA.debugLine="If IsCardTemplate = False Then";
if (_iscardtemplate==__c.False) { 
 //BA.debugLineNum = 662;BA.debugLine="Dim addRowTop As Int = 52dip + pnlItems.Height +";
_addrowtop = (int) (__c.DipToCurrent((int) (52))+_pnlitems.getHeight()+__c.DipToCurrent((int) (10)));
 //BA.debugLineNum = 663;BA.debugLine="pnlAddRow.Top = addRowTop";
_pnladdrow.setTop(_addrowtop);
 //BA.debugLineNum = 665;BA.debugLine="pnlListMode.Height = addRowTop + 60dip";
_pnllistmode.setHeight((int) (_addrowtop+__c.DipToCurrent((int) (60))));
 }else {
 //BA.debugLineNum = 668;BA.debugLine="pnlListMode.Height = pnlItems.Height + 300dip  '";
_pnllistmode.setHeight((int) (_pnlitems.getHeight()+__c.DipToCurrent((int) (300))));
 };
 //BA.debugLineNum = 672;BA.debugLine="Dim totalHeight As Int = 70dip + pnlListMode.Heig";
_totalheight = (int) (__c.DipToCurrent((int) (70))+_pnllistmode.getHeight()+__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 673;BA.debugLine="pnlContent.Height = Max(totalHeight, 300dip)";
_pnlcontent.setHeight((int) (__c.Max(_totalheight,__c.DipToCurrent((int) (300)))));
 //BA.debugLineNum = 675;BA.debugLine="IsRebuildingUI = False  'Libera eventos de checkb";
_isrebuildingui = __c.False;
 //BA.debugLineNum = 676;BA.debugLine="End Sub";
return "";
}
public String  _removeaccents(String _text) throws Exception{
String _result = "";
 //BA.debugLineNum = 1081;BA.debugLine="Private Sub RemoveAccents(text As String) As Strin";
 //BA.debugLineNum = 1082;BA.debugLine="Dim result As String = text.ToLowerCase";
_result = _text.toLowerCase();
 //BA.debugLineNum = 1083;BA.debugLine="result = result.Replace(\"á\", \"a\").Replace(\"à\", \"a";
_result = _result.replace("á","a").replace("à","a").replace("ã","a").replace("â","a").replace("ä","a");
 //BA.debugLineNum = 1084;BA.debugLine="result = result.Replace(\"é\", \"e\").Replace(\"è\", \"e";
_result = _result.replace("é","e").replace("è","e").replace("ê","e").replace("ë","e");
 //BA.debugLineNum = 1085;BA.debugLine="result = result.Replace(\"í\", \"i\").Replace(\"ì\", \"i";
_result = _result.replace("í","i").replace("ì","i").replace("î","i").replace("ï","i");
 //BA.debugLineNum = 1086;BA.debugLine="result = result.Replace(\"ó\", \"o\").Replace(\"ò\", \"o";
_result = _result.replace("ó","o").replace("ò","o").replace("õ","o").replace("ô","o").replace("ö","o");
 //BA.debugLineNum = 1087;BA.debugLine="result = result.Replace(\"ú\", \"u\").Replace(\"ù\", \"u";
_result = _result.replace("ú","u").replace("ù","u").replace("û","u").replace("ü","u");
 //BA.debugLineNum = 1088;BA.debugLine="result = result.Replace(\"ç\", \"c\").Replace(\"ñ\", \"n";
_result = _result.replace("ç","c").replace("ñ","n");
 //BA.debugLineNum = 1089;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 1090;BA.debugLine="End Sub";
return "";
}
public boolean  _savenote(boolean _closeafter) throws Exception{
String _title = "";
anywheresoftware.b4a.objects.collections.Map _cardnumitem = null;
String _cardnumtext = "";
int _colonpos = 0;
String _cardnumber = "";
com.lockzero.clsnoteentry _note = null;
anywheresoftware.b4a.objects.collections.List _existingnotes = null;
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _gen = null;
String _jsonitems = "";
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _genatt = null;
String _jsonattach = "";
 //BA.debugLineNum = 1207;BA.debugLine="Private Sub SaveNote(closeAfter As Boolean) As Boo";
 //BA.debugLineNum = 1208;BA.debugLine="Log(\"SaveNote: NoteType=\" & NoteType & \", IsSecur";
__c.LogImpl("621954561","SaveNote: NoteType="+_notetype+", IsSecure="+BA.ObjectToString(_issecure)+", closeAfter="+BA.ObjectToString(_closeafter),0);
 //BA.debugLineNum = 1210;BA.debugLine="If IsSecure Then ModSession.Touch";
if (_issecure) { 
_modsession._touch /*String*/ (ba);};
 //BA.debugLineNum = 1212;BA.debugLine="Dim title As String";
_title = "";
 //BA.debugLineNum = 1215;BA.debugLine="If IsCardTemplate Then";
if (_iscardtemplate) { 
 //BA.debugLineNum = 1216;BA.debugLine="title = GetCardTitle";
_title = _getcardtitle();
 //BA.debugLineNum = 1217;BA.debugLine="If title.Length < 1 Then";
if (_title.length()<1) { 
 //BA.debugLineNum = 1218;BA.debugLine="ToastMessageShow(ModLang.T(\"error_empty_field\")";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error_empty_field")),__c.True);
 //BA.debugLineNum = 1219;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 1223;BA.debugLine="If ItemsList.Size > 2 Then";
if (_itemslist.getSize()>2) { 
 //BA.debugLineNum = 1224;BA.debugLine="Dim cardNumItem As Map = ItemsList.Get(2)";
_cardnumitem = new anywheresoftware.b4a.objects.collections.Map();
_cardnumitem = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_itemslist.Get((int) (2))));
 //BA.debugLineNum = 1225;BA.debugLine="Dim cardNumText As String = cardNumItem.GetDefa";
_cardnumtext = BA.ObjectToString(_cardnumitem.GetDefault((Object)("text"),(Object)("")));
 //BA.debugLineNum = 1226;BA.debugLine="Dim colonPos As Int = cardNumText.IndexOf(\":\")";
_colonpos = _cardnumtext.indexOf(":");
 //BA.debugLineNum = 1227;BA.debugLine="If colonPos > 0 Then";
if (_colonpos>0) { 
 //BA.debugLineNum = 1228;BA.debugLine="Dim cardNumber As String = cardNumText.SubStri";
_cardnumber = _cardnumtext.substring((int) (_colonpos+1)).trim();
 //BA.debugLineNum = 1229;BA.debugLine="If cardNumber.Length > 0 And ValidateCardNumbe";
if (_cardnumber.length()>0 && _validatecardnumber(_cardnumber)==__c.False) { 
 //BA.debugLineNum = 1230;BA.debugLine="ToastMessageShow(ModLang.T(\"invalid_card_numb";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"invalid_card_number")),__c.True);
 //BA.debugLineNum = 1231;BA.debugLine="Return False";
if (true) return __c.False;
 };
 };
 };
 }else {
 //BA.debugLineNum = 1236;BA.debugLine="title = edtTitle.Text.Trim";
_title = _edttitle.getText().trim();
 //BA.debugLineNum = 1238;BA.debugLine="If title.Length < 1 Then";
if (_title.length()<1) { 
 //BA.debugLineNum = 1239;BA.debugLine="ToastMessageShow(ModLang.T(\"error_empty_field\")";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error_empty_field")),__c.True);
 //BA.debugLineNum = 1240;BA.debugLine="Return False";
if (true) return __c.False;
 };
 };
 //BA.debugLineNum = 1245;BA.debugLine="If IsSecure And Passphrase.Length = 0 Then";
if (_issecure && _passphrase.length()==0) { 
 //BA.debugLineNum = 1246;BA.debugLine="Log(\"ERRO: Passphrase vazia para grupo seguro!\")";
__c.LogImpl("621954599","ERRO: Passphrase vazia para grupo seguro!",0);
 //BA.debugLineNum = 1247;BA.debugLine="ToastMessageShow(ModLang.T(\"error\"), True)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error")),__c.True);
 //BA.debugLineNum = 1248;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 1251;BA.debugLine="Dim note As clsNoteEntry";
_note = new com.lockzero.clsnoteentry();
 //BA.debugLineNum = 1252;BA.debugLine="If IsNewNote Then";
if (_isnewnote) { 
 //BA.debugLineNum = 1253;BA.debugLine="note.Initialize";
_note._initialize /*String*/ (ba);
 //BA.debugLineNum = 1254;BA.debugLine="note.GroupId = CurrentGroupId";
_note._groupid /*String*/  = _currentgroupid;
 //BA.debugLineNum = 1255;BA.debugLine="note.NoteType = NoteType";
_note._notetype /*String*/  = _notetype;
 //BA.debugLineNum = 1257;BA.debugLine="Dim existingNotes As List = ModNotes.GetNotesByG";
_existingnotes = new anywheresoftware.b4a.objects.collections.List();
_existingnotes = _modnotes._getnotesbygroup /*anywheresoftware.b4a.objects.collections.List*/ (ba,_currentgroupid);
 //BA.debugLineNum = 1258;BA.debugLine="note.SortOrder = existingNotes.Size";
_note._sortorder /*int*/  = _existingnotes.getSize();
 }else {
 //BA.debugLineNum = 1260;BA.debugLine="note = ModNotes.GetNoteById(CurrentNoteId)";
_note = _modnotes._getnotebyid /*com.lockzero.clsnoteentry*/ (ba,_currentnoteid);
 //BA.debugLineNum = 1261;BA.debugLine="If note = Null Then";
if (_note== null) { 
 //BA.debugLineNum = 1262;BA.debugLine="ToastMessageShow(ModLang.T(\"error\"), True)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"error")),__c.True);
 //BA.debugLineNum = 1263;BA.debugLine="Return False";
if (true) return __c.False;
 };
 };
 //BA.debugLineNum = 1268;BA.debugLine="If ItemsList.IsInitialized = False Then";
if (_itemslist.IsInitialized()==__c.False) { 
 //BA.debugLineNum = 1269;BA.debugLine="ItemsList.Initialize";
_itemslist.Initialize();
 //BA.debugLineNum = 1270;BA.debugLine="Log(\"ItemsList foi inicializado agora\")";
__c.LogImpl("621954623","ItemsList foi inicializado agora",0);
 };
 //BA.debugLineNum = 1272;BA.debugLine="Log(\"ItemsList.Size=\" & ItemsList.Size)";
__c.LogImpl("621954625","ItemsList.Size="+BA.NumberToString(_itemslist.getSize()),0);
 //BA.debugLineNum = 1275;BA.debugLine="If IsSecure Then";
if (_issecure) { 
 //BA.debugLineNum = 1276;BA.debugLine="Log(\"Modo SEGURO - criptografando...\")";
__c.LogImpl("621954629","Modo SEGURO - criptografando...",0);
 //BA.debugLineNum = 1278;BA.debugLine="note.EncryptTitle(Passphrase, title)";
_note._encrypttitle /*String*/ (_passphrase,_title);
 //BA.debugLineNum = 1279;BA.debugLine="Log(\"Titulo criptografado OK\")";
__c.LogImpl("621954632","Titulo criptografado OK",0);
 //BA.debugLineNum = 1281;BA.debugLine="If NoteType = \"list\" Then";
if ((_notetype).equals("list")) { 
 //BA.debugLineNum = 1282;BA.debugLine="Log(\"Salvando lista segura...\")";
__c.LogImpl("621954635","Salvando lista segura...",0);
 //BA.debugLineNum = 1284;BA.debugLine="Dim gen As JSONGenerator";
_gen = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 1285;BA.debugLine="gen.Initialize2(ItemsList)  'Initialize2 para L";
_gen.Initialize2(_itemslist);
 //BA.debugLineNum = 1286;BA.debugLine="Dim jsonItems As String = gen.ToString";
_jsonitems = _gen.ToString();
 //BA.debugLineNum = 1287;BA.debugLine="Log(\"JSON gerado: \" & jsonItems)";
__c.LogImpl("621954640","JSON gerado: "+_jsonitems,0);
 //BA.debugLineNum = 1288;BA.debugLine="note.EncryptItems(Passphrase, jsonItems)";
_note._encryptitems /*String*/ (_passphrase,_jsonitems);
 //BA.debugLineNum = 1289;BA.debugLine="note.Content = \"\"";
_note._content /*String*/  = "";
 //BA.debugLineNum = 1290;BA.debugLine="Log(\"Items criptografados OK\")";
__c.LogImpl("621954643","Items criptografados OK",0);
 }else {
 //BA.debugLineNum = 1292;BA.debugLine="note.EncryptContent(Passphrase, edtContent.Text";
_note._encryptcontent /*String*/ (_passphrase,_edtcontent.getText().trim());
 //BA.debugLineNum = 1293;BA.debugLine="note.Items = \"[]\"";
_note._items /*String*/  = "[]";
 };
 }else {
 //BA.debugLineNum = 1296;BA.debugLine="Log(\"Modo ABERTO - texto claro...\")";
__c.LogImpl("621954649","Modo ABERTO - texto claro...",0);
 //BA.debugLineNum = 1298;BA.debugLine="note.Title = title";
_note._title /*String*/  = _title;
 //BA.debugLineNum = 1300;BA.debugLine="If NoteType = \"list\" Then";
if ((_notetype).equals("list")) { 
 //BA.debugLineNum = 1301;BA.debugLine="Log(\"Salvando lista aberta, ItemsList.Size=\" &";
__c.LogImpl("621954654","Salvando lista aberta, ItemsList.Size="+BA.NumberToString(_itemslist.getSize()),0);
 //BA.debugLineNum = 1302;BA.debugLine="note.SetItemsList(ItemsList)";
_note._setitemslist /*String*/ (_itemslist);
 //BA.debugLineNum = 1303;BA.debugLine="note.Content = \"\"";
_note._content /*String*/  = "";
 //BA.debugLineNum = 1304;BA.debugLine="Log(\"SetItemsList OK\")";
__c.LogImpl("621954657","SetItemsList OK",0);
 }else {
 //BA.debugLineNum = 1306;BA.debugLine="note.Content = edtContent.Text.Trim";
_note._content /*String*/  = _edtcontent.getText().trim();
 //BA.debugLineNum = 1307;BA.debugLine="note.Items = \"[]\"";
_note._items /*String*/  = "[]";
 };
 };
 //BA.debugLineNum = 1312;BA.debugLine="If IsCardTemplate = False And AttachmentsList.IsI";
if (_iscardtemplate==__c.False && _attachmentslist.IsInitialized() && _attachmentslist.getSize()>0) { 
 //BA.debugLineNum = 1313;BA.debugLine="Dim genAtt As JSONGenerator";
_genatt = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 1314;BA.debugLine="genAtt.Initialize2(AttachmentsList)";
_genatt.Initialize2(_attachmentslist);
 //BA.debugLineNum = 1315;BA.debugLine="Dim jsonAttach As String = genAtt.ToString";
_jsonattach = _genatt.ToString();
 //BA.debugLineNum = 1316;BA.debugLine="If IsSecure Then";
if (_issecure) { 
 //BA.debugLineNum = 1317;BA.debugLine="note.EncryptAttachments(Passphrase, jsonAttach)";
_note._encryptattachments /*String*/ (_passphrase,_jsonattach);
 }else {
 //BA.debugLineNum = 1319;BA.debugLine="note.Attachments = jsonAttach";
_note._attachments /*String*/  = _jsonattach;
 };
 }else {
 //BA.debugLineNum = 1322;BA.debugLine="note.Attachments = \"[]\"";
_note._attachments /*String*/  = "[]";
 };
 //BA.debugLineNum = 1325;BA.debugLine="note.IsFavorite = chkFavorite.Checked";
_note._isfavorite /*boolean*/  = _chkfavorite.getChecked();
 //BA.debugLineNum = 1326;BA.debugLine="Log(\"Chamando ModNotes.SaveNote...\")";
__c.LogImpl("621954679","Chamando ModNotes.SaveNote...",0);
 //BA.debugLineNum = 1327;BA.debugLine="ModNotes.SaveNote(note)";
_modnotes._savenote /*String*/ (ba,_note);
 //BA.debugLineNum = 1328;BA.debugLine="Log(\"SaveNote OK\")";
__c.LogImpl("621954681","SaveNote OK",0);
 //BA.debugLineNum = 1331;BA.debugLine="If IsNewNote Then";
if (_isnewnote) { 
 //BA.debugLineNum = 1332;BA.debugLine="CurrentNoteId = note.Id";
_currentnoteid = _note._id /*String*/ ;
 //BA.debugLineNum = 1333;BA.debugLine="IsNewNote = False";
_isnewnote = __c.False;
 };
 //BA.debugLineNum = 1336;BA.debugLine="ToastMessageShow(ModLang.T(\"success\"), False)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"success")),__c.False);
 //BA.debugLineNum = 1338;BA.debugLine="If closeAfter Then";
if (_closeafter) { 
 //BA.debugLineNum = 1339;BA.debugLine="Log(\"Fechando pagina...\")";
__c.LogImpl("621954692","Fechando pagina...",0);
 //BA.debugLineNum = 1340;BA.debugLine="B4XPages.ClosePage(Me)";
_b4xpages._closepage /*String*/ (ba,this);
 };
 //BA.debugLineNum = 1343;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 1344;BA.debugLine="End Sub";
return false;
}
public void  _scrolltocardfield(Object _field) throws Exception{
ResumableSub_ScrollToCardField rsub = new ResumableSub_ScrollToCardField(this,_field);
rsub.resume(ba, null);
}
public static class ResumableSub_ScrollToCardField extends BA.ResumableSub {
public ResumableSub_ScrollToCardField(com.lockzero.pagenoteedit parent,Object _field) {
this.parent = parent;
this._field = _field;
}
com.lockzero.pagenoteedit parent;
Object _field;
anywheresoftware.b4a.objects.EditTextWrapper _edt = null;
int _index = 0;
int _fieldtop = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 1017;BA.debugLine="Dim edt As EditText = field";
_edt = new anywheresoftware.b4a.objects.EditTextWrapper();
_edt = (anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(_field));
 //BA.debugLineNum = 1018;BA.debugLine="Dim index As Int = edt.Tag";
_index = (int)(BA.ObjectToNumber(_edt.getTag()));
 //BA.debugLineNum = 1021;BA.debugLine="Sleep(150)";
parent.__c.Sleep(ba,this,(int) (150));
this.state = 7;
return;
case 7:
//C
this.state = 1;
;
 //BA.debugLineNum = 1024;BA.debugLine="Dim fieldTop As Int = index * 58dip";
_fieldtop = (int) (_index*parent.__c.DipToCurrent((int) (58)));
 //BA.debugLineNum = 1027;BA.debugLine="If index >= 5 Then";
if (true) break;

case 1:
//if
this.state = 6;
if (_index>=5) { 
this.state = 3;
}else if(_index>=3) { 
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 //BA.debugLineNum = 1029;BA.debugLine="svContent.ScrollPosition = fieldTop - 30dip";
parent._svcontent.setScrollPosition((int) (_fieldtop-parent.__c.DipToCurrent((int) (30))));
 if (true) break;

case 5:
//C
this.state = 6;
 //BA.debugLineNum = 1032;BA.debugLine="svContent.ScrollPosition = Max(0, fieldTop - 80d";
parent._svcontent.setScrollPosition((int) (parent.__c.Max(0,_fieldtop-parent.__c.DipToCurrent((int) (80)))));
 if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 1034;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _setandroidicon(anywheresoftware.b4a.objects.ImageViewWrapper _iv,String _iconname) throws Exception{
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
Object _resources = null;
int _id = 0;
Object _drawable = null;
anywheresoftware.b4j.object.JavaObject _ivjo = null;
 //BA.debugLineNum = 1830;BA.debugLine="Private Sub SetAndroidIcon(iv As ImageView, iconNa";
 //BA.debugLineNum = 1831;BA.debugLine="Try";
try { //BA.debugLineNum = 1832;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
 //BA.debugLineNum = 1833;BA.debugLine="r.Target = r.GetContext";
_r.Target = (Object)(_r.GetContext(ba));
 //BA.debugLineNum = 1834;BA.debugLine="Dim resources As Object = r.RunMethod(\"getResour";
_resources = _r.RunMethod("getResources");
 //BA.debugLineNum = 1835;BA.debugLine="r.Target = resources";
_r.Target = _resources;
 //BA.debugLineNum = 1836;BA.debugLine="Dim id As Int = r.RunMethod4(\"getIdentifier\", Ar";
_id = (int)(BA.ObjectToNumber(_r.RunMethod4("getIdentifier",new Object[]{(Object)(_iconname),(Object)("drawable"),(Object)("android")},new String[]{"java.lang.String","java.lang.String","java.lang.String"})));
 //BA.debugLineNum = 1837;BA.debugLine="If id > 0 Then";
if (_id>0) { 
 //BA.debugLineNum = 1838;BA.debugLine="Dim drawable As Object = r.RunMethod2(\"getDrawa";
_drawable = _r.RunMethod2("getDrawable",BA.NumberToString(_id),"java.lang.int");
 //BA.debugLineNum = 1839;BA.debugLine="Dim ivJO As JavaObject = iv";
_ivjo = new anywheresoftware.b4j.object.JavaObject();
_ivjo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_iv.getObject()));
 //BA.debugLineNum = 1840;BA.debugLine="ivJO.RunMethod(\"setImageDrawable\", Array(drawab";
_ivjo.RunMethod("setImageDrawable",new Object[]{_drawable});
 //BA.debugLineNum = 1842;BA.debugLine="ivJO.RunMethodJO(\"setColorFilter\", Array(Colors";
_ivjo.RunMethodJO("setColorFilter",new Object[]{(Object)(__c.Colors.White)});
 };
 } 
       catch (Exception e14) {
			ba.setLastException(e14); //BA.debugLineNum = 1845;BA.debugLine="Log(\"SetAndroidIcon erro: \" & LastException.Mess";
__c.LogImpl("623134223","SetAndroidIcon erro: "+__c.LastException(ba).getMessage(),0);
 };
 //BA.debugLineNum = 1847;BA.debugLine="End Sub";
return "";
}
public String  _setparams(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
com.lockzero.clsnotegroup _grp = null;
com.lockzero.clsnotegroup _group = null;
 //BA.debugLineNum = 116;BA.debugLine="Public Sub SetParams(params As Map)";
 //BA.debugLineNum = 117;BA.debugLine="If params = Null Then Return";
if (_params== null) { 
if (true) return "";};
 //BA.debugLineNum = 119;BA.debugLine="CurrentNoteId = params.GetDefault(\"noteId\", \"\")";
_currentnoteid = BA.ObjectToString(_params.GetDefault((Object)("noteId"),(Object)("")));
 //BA.debugLineNum = 120;BA.debugLine="CurrentGroupId = params.GetDefault(\"groupId\", \"\")";
_currentgroupid = BA.ObjectToString(_params.GetDefault((Object)("groupId"),(Object)("")));
 //BA.debugLineNum = 121;BA.debugLine="CurrentGroupName = params.GetDefault(\"groupName\",";
_currentgroupname = BA.ObjectToString(_params.GetDefault((Object)("groupName"),(Object)("")));
 //BA.debugLineNum = 122;BA.debugLine="NoteType = params.GetDefault(\"noteType\", \"text\")";
_notetype = BA.ObjectToString(_params.GetDefault((Object)("noteType"),(Object)("text")));
 //BA.debugLineNum = 123;BA.debugLine="IsSecure = params.GetDefault(\"isSecure\", True)";
_issecure = BA.ObjectToBoolean(_params.GetDefault((Object)("isSecure"),(Object)(__c.True)));
 //BA.debugLineNum = 124;BA.debugLine="Passphrase = params.GetDefault(\"passphrase\", \"\")";
_passphrase = BA.ObjectToString(_params.GetDefault((Object)("passphrase"),(Object)("")));
 //BA.debugLineNum = 127;BA.debugLine="If Passphrase = \"\" And IsSecure Then";
if ((_passphrase).equals("") && _issecure) { 
 //BA.debugLineNum = 128;BA.debugLine="Passphrase = ModSession.GetPassphrase";
_passphrase = _modsession._getpassphrase /*String*/ (ba);
 };
 //BA.debugLineNum = 131;BA.debugLine="IsNewNote = (CurrentNoteId.Length = 0)";
_isnewnote = (_currentnoteid.length()==0);
 //BA.debugLineNum = 132;BA.debugLine="ItemsList.Initialize";
_itemslist.Initialize();
 //BA.debugLineNum = 133;BA.debugLine="ItemPanels.Initialize";
_itempanels.Initialize();
 //BA.debugLineNum = 134;BA.debugLine="AttachmentsList.Initialize";
_attachmentslist.Initialize();
 //BA.debugLineNum = 135;BA.debugLine="CurrentFilter = \"\"  'Limpa filtro ao abrir";
_currentfilter = "";
 //BA.debugLineNum = 138;BA.debugLine="Dim grp As clsNoteGroup = ModNotes.GetNoteGroupBy";
_grp = _modnotes._getnotegroupbyid /*com.lockzero.clsnotegroup*/ (ba,_currentgroupid);
 //BA.debugLineNum = 139;BA.debugLine="IsCardTemplate = (grp <> Null And grp.TemplateTyp";
_iscardtemplate = (_grp!= null && (_grp._templatetype /*String*/ ).equals("card"));
 //BA.debugLineNum = 142;BA.debugLine="SetupModeUI";
_setupmodeui();
 //BA.debugLineNum = 144;BA.debugLine="If IsNewNote Then";
if (_isnewnote) { 
 //BA.debugLineNum = 145;BA.debugLine="edtTitle.Text = \"\"";
_edttitle.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 146;BA.debugLine="If NoteType = \"text\" Then";
if ((_notetype).equals("text")) { 
 //BA.debugLineNum = 147;BA.debugLine="edtContent.Text = \"\"";
_edtcontent.setText(BA.ObjectToCharSequence(""));
 }else if((_notetype).equals("list")) { 
 //BA.debugLineNum = 150;BA.debugLine="Dim group As clsNoteGroup = ModNotes.GetNoteGro";
_group = _modnotes._getnotegroupbyid /*com.lockzero.clsnotegroup*/ (ba,_currentgroupid);
 //BA.debugLineNum = 151;BA.debugLine="If group <> Null And group.TemplateType = \"card";
if (_group!= null && (_group._templatetype /*String*/ ).equals("card")) { 
 //BA.debugLineNum = 153;BA.debugLine="ItemsList = ModNotes.GetCardTemplate";
_itemslist = _modnotes._getcardtemplate /*anywheresoftware.b4a.objects.collections.List*/ (ba);
 //BA.debugLineNum = 154;BA.debugLine="RebuildItemsUI";
_rebuilditemsui();
 };
 };
 //BA.debugLineNum = 157;BA.debugLine="chkFavorite.Checked = False";
_chkfavorite.setChecked(__c.False);
 }else {
 //BA.debugLineNum = 159;BA.debugLine="LoadNote";
_loadnote();
 };
 //BA.debugLineNum = 161;BA.debugLine="End Sub";
return "";
}
public String  _setupmodeui() throws Exception{
 //BA.debugLineNum = 390;BA.debugLine="Private Sub SetupModeUI";
 //BA.debugLineNum = 391;BA.debugLine="If NoteType = \"list\" Then";
if ((_notetype).equals("list")) { 
 //BA.debugLineNum = 392;BA.debugLine="pnlTextMode.Visible = False";
_pnltextmode.setVisible(__c.False);
 //BA.debugLineNum = 393;BA.debugLine="pnlListMode.Visible = True";
_pnllistmode.setVisible(__c.True);
 //BA.debugLineNum = 396;BA.debugLine="If IsCardTemplate Then";
if (_iscardtemplate) { 
 //BA.debugLineNum = 397;BA.debugLine="lblIconAdd.Visible = False";
_lbliconadd.setVisible(__c.False);
 //BA.debugLineNum = 398;BA.debugLine="ivIconShare.Visible = True  'Compartilhar habil";
_iviconshare.setVisible(__c.True);
 //BA.debugLineNum = 399;BA.debugLine="ivIconAttach.Visible = False  'Sem anexos para";
_iviconattach.setVisible(__c.False);
 //BA.debugLineNum = 400;BA.debugLine="edtFilter.Visible = False";
_edtfilter.setVisible(__c.False);
 //BA.debugLineNum = 401;BA.debugLine="lblClearFilter.Visible = False";
_lblclearfilter.setVisible(__c.False);
 //BA.debugLineNum = 402;BA.debugLine="pnlAddRow.Visible = False";
_pnladdrow.setVisible(__c.False);
 //BA.debugLineNum = 403;BA.debugLine="edtTitle.Visible = False";
_edttitle.setVisible(__c.False);
 //BA.debugLineNum = 404;BA.debugLine="chkFavorite.Visible = False";
_chkfavorite.setVisible(__c.False);
 //BA.debugLineNum = 405;BA.debugLine="pnlAttachments.Visible = False";
_pnlattachments.setVisible(__c.False);
 //BA.debugLineNum = 407;BA.debugLine="pnlListMode.Top = 10dip";
_pnllistmode.setTop(__c.DipToCurrent((int) (10)));
 }else {
 //BA.debugLineNum = 409;BA.debugLine="lblIconAdd.Visible = True";
_lbliconadd.setVisible(__c.True);
 //BA.debugLineNum = 410;BA.debugLine="ivIconShare.Visible = True";
_iviconshare.setVisible(__c.True);
 //BA.debugLineNum = 411;BA.debugLine="ivIconAttach.Visible = True  'Anexos habilitado";
_iviconattach.setVisible(__c.True);
 //BA.debugLineNum = 412;BA.debugLine="edtFilter.Visible = True";
_edtfilter.setVisible(__c.True);
 //BA.debugLineNum = 413;BA.debugLine="lblClearFilter.Visible = True";
_lblclearfilter.setVisible(__c.True);
 //BA.debugLineNum = 414;BA.debugLine="pnlAddRow.Visible = True";
_pnladdrow.setVisible(__c.True);
 //BA.debugLineNum = 415;BA.debugLine="edtTitle.Visible = True";
_edttitle.setVisible(__c.True);
 //BA.debugLineNum = 416;BA.debugLine="chkFavorite.Visible = True";
_chkfavorite.setVisible(__c.True);
 //BA.debugLineNum = 417;BA.debugLine="pnlAttachments.Visible = True";
_pnlattachments.setVisible(__c.True);
 //BA.debugLineNum = 418;BA.debugLine="pnlListMode.Top = 70dip";
_pnllistmode.setTop(__c.DipToCurrent((int) (70)));
 };
 //BA.debugLineNum = 420;BA.debugLine="RebuildItemsUI";
_rebuilditemsui();
 //BA.debugLineNum = 421;BA.debugLine="RebuildAttachmentsUI";
_rebuildattachmentsui();
 }else {
 //BA.debugLineNum = 423;BA.debugLine="pnlTextMode.Visible = True";
_pnltextmode.setVisible(__c.True);
 //BA.debugLineNum = 424;BA.debugLine="pnlListMode.Visible = False";
_pnllistmode.setVisible(__c.False);
 //BA.debugLineNum = 425;BA.debugLine="lblIconAdd.Visible = False  'Nao tem + para text";
_lbliconadd.setVisible(__c.False);
 //BA.debugLineNum = 426;BA.debugLine="ivIconShare.Visible = False  'Nao compartilha te";
_iviconshare.setVisible(__c.False);
 //BA.debugLineNum = 427;BA.debugLine="ivIconAttach.Visible = True  'Anexos habilitados";
_iviconattach.setVisible(__c.True);
 //BA.debugLineNum = 428;BA.debugLine="pnlAttachments.Visible = True";
_pnlattachments.setVisible(__c.True);
 //BA.debugLineNum = 430;BA.debugLine="pnlContent.Height = 92dip + 350dip + 20dip";
_pnlcontent.setHeight((int) (__c.DipToCurrent((int) (92))+__c.DipToCurrent((int) (350))+__c.DipToCurrent((int) (20))));
 //BA.debugLineNum = 431;BA.debugLine="RebuildAttachmentsUI";
_rebuildattachmentsui();
 };
 //BA.debugLineNum = 435;BA.debugLine="ivIconDelete.Visible = Not(IsNewNote)";
_ivicondelete.setVisible(__c.Not(_isnewnote));
 //BA.debugLineNum = 436;BA.debugLine="End Sub";
return "";
}
public String  _sharecard() throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _item = null;
String _text = "";
anywheresoftware.b4a.objects.IntentWrapper _shareintent = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 1422;BA.debugLine="Private Sub ShareCard";
 //BA.debugLineNum = 1423;BA.debugLine="If ItemsList.Size < 4 Then Return";
if (_itemslist.getSize()<4) { 
if (true) return "";};
 //BA.debugLineNum = 1425;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 1426;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 1429;BA.debugLine="For i = 0 To 3";
{
final int step4 = 1;
final int limit4 = (int) (3);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 1430;BA.debugLine="Dim item As Map = ItemsList.Get(i)";
_item = new anywheresoftware.b4a.objects.collections.Map();
_item = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_itemslist.Get(_i)));
 //BA.debugLineNum = 1431;BA.debugLine="Dim text As String = item.GetDefault(\"text\", \"\")";
_text = BA.ObjectToString(_item.GetDefault((Object)("text"),(Object)("")));
 //BA.debugLineNum = 1432;BA.debugLine="sb.Append(text).Append(Chr(10))";
_sb.Append(_text).Append(BA.ObjectToString(__c.Chr((int) (10))));
 }
};
 //BA.debugLineNum = 1436;BA.debugLine="Dim shareIntent As Intent";
_shareintent = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 1437;BA.debugLine="shareIntent.Initialize(shareIntent.ACTION_SEND, \"";
_shareintent.Initialize(_shareintent.ACTION_SEND,"");
 //BA.debugLineNum = 1438;BA.debugLine="shareIntent.SetType(\"text/plain\")";
_shareintent.SetType("text/plain");
 //BA.debugLineNum = 1439;BA.debugLine="shareIntent.PutExtra(\"android.intent.extra.TEXT\",";
_shareintent.PutExtra("android.intent.extra.TEXT",(Object)(_sb.ToString()));
 //BA.debugLineNum = 1441;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 1442;BA.debugLine="jo.InitializeStatic(\"android.content.Intent\")";
_jo.InitializeStatic("android.content.Intent");
 //BA.debugLineNum = 1443;BA.debugLine="StartActivity(jo.RunMethod(\"createChooser\", Array";
__c.StartActivity(ba,_jo.RunMethod("createChooser",new Object[]{(Object)(_shareintent.getObject()),(Object)(_modlang._t /*String*/ (ba,"share"))}));
 //BA.debugLineNum = 1444;BA.debugLine="End Sub";
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
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 1447;BA.debugLine="Private Sub ShareItems(onlyChecked As Boolean)";
 //BA.debugLineNum = 1448;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 1449;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 1450;BA.debugLine="sb.Append(edtTitle.Text.Trim).Append(Chr(10)).App";
_sb.Append(_edttitle.getText().trim()).Append(BA.ObjectToString(__c.Chr((int) (10)))).Append(BA.ObjectToString(__c.Chr((int) (10))));
 //BA.debugLineNum = 1452;BA.debugLine="Dim count As Int = 0";
_count = (int) (0);
 //BA.debugLineNum = 1453;BA.debugLine="For i = 0 To ItemsList.Size - 1";
{
final int step5 = 1;
final int limit5 = (int) (_itemslist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 1454;BA.debugLine="Dim item As Map = ItemsList.Get(i)";
_item = new anywheresoftware.b4a.objects.collections.Map();
_item = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_itemslist.Get(_i)));
 //BA.debugLineNum = 1455;BA.debugLine="Dim checked As Boolean = item.GetDefault(\"checke";
_checked = BA.ObjectToBoolean(_item.GetDefault((Object)("checked"),(Object)(__c.False)));
 //BA.debugLineNum = 1456;BA.debugLine="Dim text As String = item.GetDefault(\"text\", \"\")";
_text = BA.ObjectToString(_item.GetDefault((Object)("text"),(Object)("")));
 //BA.debugLineNum = 1458;BA.debugLine="If onlyChecked And checked = False Then Continue";
if (_onlychecked && _checked==__c.False) { 
if (true) continue;};
 //BA.debugLineNum = 1460;BA.debugLine="If checked Then";
if (_checked) { 
 //BA.debugLineNum = 1461;BA.debugLine="sb.Append(\"✓ \")";
_sb.Append("✓ ");
 }else {
 //BA.debugLineNum = 1463;BA.debugLine="sb.Append(\"☐ \")";
_sb.Append("☐ ");
 };
 //BA.debugLineNum = 1465;BA.debugLine="sb.Append(text).Append(Chr(10))";
_sb.Append(_text).Append(BA.ObjectToString(__c.Chr((int) (10))));
 //BA.debugLineNum = 1466;BA.debugLine="count = count + 1";
_count = (int) (_count+1);
 }
};
 //BA.debugLineNum = 1469;BA.debugLine="If count = 0 Then";
if (_count==0) { 
 //BA.debugLineNum = 1470;BA.debugLine="ToastMessageShow(ModLang.T(\"empty\"), True)";
__c.ToastMessageShow(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"empty")),__c.True);
 //BA.debugLineNum = 1471;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 1475;BA.debugLine="Dim shareIntent As Intent";
_shareintent = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 1476;BA.debugLine="shareIntent.Initialize(shareIntent.ACTION_SEND, \"";
_shareintent.Initialize(_shareintent.ACTION_SEND,"");
 //BA.debugLineNum = 1477;BA.debugLine="shareIntent.SetType(\"text/plain\")";
_shareintent.SetType("text/plain");
 //BA.debugLineNum = 1478;BA.debugLine="shareIntent.PutExtra(\"android.intent.extra.TEXT\",";
_shareintent.PutExtra("android.intent.extra.TEXT",(Object)(_sb.ToString()));
 //BA.debugLineNum = 1480;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 1481;BA.debugLine="jo.InitializeStatic(\"android.content.Intent\")";
_jo.InitializeStatic("android.content.Intent");
 //BA.debugLineNum = 1482;BA.debugLine="StartActivity(jo.RunMethod(\"createChooser\", Array";
__c.StartActivity(ba,_jo.RunMethod("createChooser",new Object[]{(Object)(_shareintent.getObject()),(Object)(_modlang._t /*String*/ (ba,"share"))}));
 //BA.debugLineNum = 1483;BA.debugLine="End Sub";
return "";
}
public String  _showinputdialog(String _title,String _defaulttext,int _editindex) throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
 //BA.debugLineNum = 525;BA.debugLine="Private Sub ShowInputDialog(title As String, defau";
 //BA.debugLineNum = 526;BA.debugLine="EditingItemIndex = editIndex";
_editingitemindex = _editindex;
 //BA.debugLineNum = 529;BA.debugLine="Dim lblTitle As Label = pnlInputDialog.GetView(0)";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
_lbltitle = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_pnlinputdialog.GetView((int) (0)).getObject()));
 //BA.debugLineNum = 530;BA.debugLine="lblTitle.Text = title";
_lbltitle.setText(BA.ObjectToCharSequence(_title));
 //BA.debugLineNum = 533;BA.debugLine="edtItemText.Text = defaultText";
_edtitemtext.setText(BA.ObjectToCharSequence(_defaulttext));
 //BA.debugLineNum = 536;BA.debugLine="pnlInputOverlay.Visible = True";
_pnlinputoverlay.setVisible(__c.True);
 //BA.debugLineNum = 537;BA.debugLine="pnlInputOverlay.BringToFront";
_pnlinputoverlay.BringToFront();
 //BA.debugLineNum = 538;BA.debugLine="edtItemText.RequestFocus";
_edtitemtext.RequestFocus();
 //BA.debugLineNum = 539;BA.debugLine="End Sub";
return "";
}
public String  _sortitemscheckedfirst() throws Exception{
int _i = 0;
int _j = 0;
anywheresoftware.b4a.objects.collections.Map _item1 = null;
anywheresoftware.b4a.objects.collections.Map _item2 = null;
boolean _checked1 = false;
boolean _checked2 = false;
 //BA.debugLineNum = 1110;BA.debugLine="Private Sub SortItemsCheckedFirst";
 //BA.debugLineNum = 1111;BA.debugLine="If ItemsList.Size < 2 Then Return";
if (_itemslist.getSize()<2) { 
if (true) return "";};
 //BA.debugLineNum = 1114;BA.debugLine="For i = 0 To ItemsList.Size - 2";
{
final int step2 = 1;
final int limit2 = (int) (_itemslist.getSize()-2);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 1115;BA.debugLine="For j = 0 To ItemsList.Size - 2 - i";
{
final int step3 = 1;
final int limit3 = (int) (_itemslist.getSize()-2-_i);
_j = (int) (0) ;
for (;_j <= limit3 ;_j = _j + step3 ) {
 //BA.debugLineNum = 1116;BA.debugLine="Dim item1 As Map = ItemsList.Get(j)";
_item1 = new anywheresoftware.b4a.objects.collections.Map();
_item1 = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_itemslist.Get(_j)));
 //BA.debugLineNum = 1117;BA.debugLine="Dim item2 As Map = ItemsList.Get(j + 1)";
_item2 = new anywheresoftware.b4a.objects.collections.Map();
_item2 = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_itemslist.Get((int) (_j+1))));
 //BA.debugLineNum = 1118;BA.debugLine="Dim checked1 As Boolean = item1.GetDefault(\"che";
_checked1 = BA.ObjectToBoolean(_item1.GetDefault((Object)("checked"),(Object)(__c.False)));
 //BA.debugLineNum = 1119;BA.debugLine="Dim checked2 As Boolean = item2.GetDefault(\"che";
_checked2 = BA.ObjectToBoolean(_item2.GetDefault((Object)("checked"),(Object)(__c.False)));
 //BA.debugLineNum = 1122;BA.debugLine="If checked1 = False And checked2 = True Then";
if (_checked1==__c.False && _checked2==__c.True) { 
 //BA.debugLineNum = 1123;BA.debugLine="ItemsList.Set(j, item2)";
_itemslist.Set(_j,(Object)(_item2.getObject()));
 //BA.debugLineNum = 1124;BA.debugLine="ItemsList.Set(j + 1, item1)";
_itemslist.Set((int) (_j+1),(Object)(_item1.getObject()));
 };
 }
};
 }
};
 //BA.debugLineNum = 1128;BA.debugLine="End Sub";
return "";
}
public boolean  _validatecardnumber(String _number) throws Exception{
String _digits = "";
int _sum = 0;
boolean _alternate = false;
int _i = 0;
int _digitvalue = 0;
 //BA.debugLineNum = 974;BA.debugLine="Private Sub ValidateCardNumber(number As String) A";
 //BA.debugLineNum = 976;BA.debugLine="Dim digits As String = number.Replace(\" \", \"\")";
_digits = _number.replace(" ","");
 //BA.debugLineNum = 978;BA.debugLine="If digits.Length < 13 Or digits.Length > 19 Then";
if (_digits.length()<13 || _digits.length()>19) { 
if (true) return __c.False;};
 //BA.debugLineNum = 980;BA.debugLine="Dim sum As Int = 0";
_sum = (int) (0);
 //BA.debugLineNum = 981;BA.debugLine="Dim alternate As Boolean = False";
_alternate = __c.False;
 //BA.debugLineNum = 983;BA.debugLine="For i = digits.Length - 1 To 0 Step -1";
{
final int step5 = -1;
final int limit5 = (int) (0);
_i = (int) (_digits.length()-1) ;
for (;_i >= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 984;BA.debugLine="Dim digitValue As Int = Asc(digits.CharAt(i)) -";
_digitvalue = (int) (__c.Asc(_digits.charAt(_i))-48);
 //BA.debugLineNum = 985;BA.debugLine="If digitValue < 0 Or digitValue > 9 Then Return";
if (_digitvalue<0 || _digitvalue>9) { 
if (true) return __c.False;};
 //BA.debugLineNum = 987;BA.debugLine="If alternate Then";
if (_alternate) { 
 //BA.debugLineNum = 988;BA.debugLine="digitValue = digitValue * 2";
_digitvalue = (int) (_digitvalue*2);
 //BA.debugLineNum = 989;BA.debugLine="If digitValue > 9 Then digitValue = digitValue";
if (_digitvalue>9) { 
_digitvalue = (int) (_digitvalue-9);};
 };
 //BA.debugLineNum = 991;BA.debugLine="sum = sum + digitValue";
_sum = (int) (_sum+_digitvalue);
 //BA.debugLineNum = 992;BA.debugLine="alternate = Not(alternate)";
_alternate = __c.Not(_alternate);
 }
};
 //BA.debugLineNum = 995;BA.debugLine="Return (sum Mod 10 = 0)";
if (true) return (_sum%10==0);
 //BA.debugLineNum = 996;BA.debugLine="End Sub";
return false;
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
