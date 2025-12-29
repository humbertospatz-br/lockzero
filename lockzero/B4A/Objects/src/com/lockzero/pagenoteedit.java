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
public anywheresoftware.b4a.objects.ButtonWrapper _btnsave = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncancel = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btndelete = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _svcontent = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _pnlcontent = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edttitle = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtcontent = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chkfavorite = null;
public String _currentnoteid = "";
public String _currentgroupid = "";
public boolean _isnewnote = false;
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
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
 //BA.debugLineNum = 274;BA.debugLine="Private Sub ApplyTheme";
 //BA.debugLineNum = 275;BA.debugLine="Root.Color = ModTheme.HomeBg";
_root.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 276;BA.debugLine="svContent.Color = ModTheme.HomeBg";
_svcontent.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 277;BA.debugLine="pnlContent.Color = ModTheme.HomeBg";
_pnlcontent.setColor(_modtheme._homebg /*int*/ (ba));
 //BA.debugLineNum = 279;BA.debugLine="btnSave.Color = ModTheme.HomeIconBg";
_btnsave.setColor(_modtheme._homeiconbg /*int*/ (ba));
 //BA.debugLineNum = 280;BA.debugLine="btnSave.TextColor = Colors.White";
_btnsave.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 282;BA.debugLine="btnCancel.Color = ModTheme.ButtonSecondary";
_btncancel.setColor(_modtheme._buttonsecondary /*int*/ (ba));
 //BA.debugLineNum = 283;BA.debugLine="btnCancel.TextColor = Colors.White";
_btncancel.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 285;BA.debugLine="btnDelete.Color = Colors.RGB(180, 60, 60) 'Vermel";
_btndelete.setColor(__c.Colors.RGB((int) (180),(int) (60),(int) (60)));
 //BA.debugLineNum = 286;BA.debugLine="btnDelete.TextColor = Colors.White";
_btndelete.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 289;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 290;BA.debugLine="cd.Initialize2(ModTheme.HomeHeaderBg, 8dip, 1dip,";
_cd.Initialize2(_modtheme._homeheaderbg /*int*/ (ba),__c.DipToCurrent((int) (8)),__c.DipToCurrent((int) (1)),__c.Colors.ARGB((int) (80),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 292;BA.debugLine="edtTitle.Background = cd";
_edttitle.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 //BA.debugLineNum = 293;BA.debugLine="edtTitle.TextColor = Colors.White";
_edttitle.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 294;BA.debugLine="edtTitle.HintColor = Colors.ARGB(120, 255, 255, 2";
_edttitle.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 296;BA.debugLine="edtContent.Background = cd";
_edtcontent.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 //BA.debugLineNum = 297;BA.debugLine="edtContent.TextColor = Colors.White";
_edtcontent.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 298;BA.debugLine="edtContent.HintColor = Colors.ARGB(120, 255, 255,";
_edtcontent.setHintColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 300;BA.debugLine="chkFavorite.TextColor = Colors.White";
_chkfavorite.setTextColor(__c.Colors.White);
 //BA.debugLineNum = 301;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_appear() throws Exception{
 //BA.debugLineNum = 36;BA.debugLine="Private Sub B4XPage_Appear";
 //BA.debugLineNum = 38;BA.debugLine="If IsNewNote Then";
if (_isnewnote) { 
 //BA.debugLineNum = 39;BA.debugLine="CallSub2(Main, \"SetPageTitle\", ModLang.T(\"new_no";
__c.CallSubNew2(ba,(Object)(_main.getObject()),"SetPageTitle",(Object)(_modlang._t /*String*/ (ba,"new_note")));
 }else {
 //BA.debugLineNum = 41;BA.debugLine="CallSub2(Main, \"SetPageTitle\", ModLang.T(\"edit\")";
__c.CallSubNew2(ba,(Object)(_main.getObject()),"SetPageTitle",(Object)(_modlang._t /*String*/ (ba,"edit")));
 };
 //BA.debugLineNum = 44;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
 //BA.debugLineNum = 30;BA.debugLine="Private Sub B4XPage_Created(Root1 As B4XView)";
 //BA.debugLineNum = 31;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 32;BA.debugLine="CreateUI";
_createui();
 //BA.debugLineNum = 33;BA.debugLine="ApplyTheme";
_applytheme();
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return "";
}
public String  _btncancel_click() throws Exception{
 //BA.debugLineNum = 225;BA.debugLine="Private Sub btnCancel_Click";
 //BA.debugLineNum = 226;BA.debugLine="B4XPages.ClosePage(Me)";
_b4xpages._closepage /*String*/ (ba,this);
 //BA.debugLineNum = 227;BA.debugLine="End Sub";
return "";
}
public void  _btndelete_click() throws Exception{
ResumableSub_btnDelete_Click rsub = new ResumableSub_btnDelete_Click(this);
rsub.resume(ba, null);
}
public static class ResumableSub_btnDelete_Click extends BA.ResumableSub {
public ResumableSub_btnDelete_Click(com.lockzero.pagenoteedit parent) {
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
 //BA.debugLineNum = 259;BA.debugLine="ModSession.Touch";
parent._modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 261;BA.debugLine="Wait For (xui.Msgbox2Async(\"Deseja excluir esta n";
parent.__c.WaitFor("msgbox_result", ba, this, parent._xui.Msgbox2Async(ba,BA.ObjectToCharSequence("Deseja excluir esta nota?"),BA.ObjectToCharSequence("Confirmar"),"Excluir","","Cancelar",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null))));
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 263;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_result==parent._xui.DialogResponse_Positive) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 264;BA.debugLine="ModNotes.DeleteNote(CurrentNoteId)";
parent._modnotes._deletenote /*String*/ (ba,parent._currentnoteid);
 //BA.debugLineNum = 265;BA.debugLine="ToastMessageShow(\"Nota excluida\", False)";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence("Nota excluida"),parent.__c.False);
 //BA.debugLineNum = 266;BA.debugLine="B4XPages.ClosePage(Me)";
parent._b4xpages._closepage /*String*/ (ba,parent);
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 268;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _msgbox_result(int _result) throws Exception{
}
public String  _btnsave_click() throws Exception{
String _title = "";
String _content = "";
String _passphrase = "";
com.lockzero.clsnoteentry _note = null;
 //BA.debugLineNum = 184;BA.debugLine="Private Sub btnSave_Click";
 //BA.debugLineNum = 185;BA.debugLine="ModSession.Touch";
_modsession._touch /*String*/ (ba);
 //BA.debugLineNum = 187;BA.debugLine="Dim title As String = edtTitle.Text.Trim";
_title = _edttitle.getText().trim();
 //BA.debugLineNum = 188;BA.debugLine="Dim content As String = edtContent.Text.Trim";
_content = _edtcontent.getText().trim();
 //BA.debugLineNum = 191;BA.debugLine="If title.Length < 1 Then";
if (_title.length()<1) { 
 //BA.debugLineNum = 192;BA.debugLine="ToastMessageShow(\"Digite um titulo\", True)";
__c.ToastMessageShow(BA.ObjectToCharSequence("Digite um titulo"),__c.True);
 //BA.debugLineNum = 193;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 196;BA.debugLine="Dim passPhrase As String = ModSession.GetPassphra";
_passphrase = _modsession._getpassphrase /*String*/ (ba);
 //BA.debugLineNum = 198;BA.debugLine="Dim note As clsNoteEntry";
_note = new com.lockzero.clsnoteentry();
 //BA.debugLineNum = 199;BA.debugLine="If IsNewNote Then";
if (_isnewnote) { 
 //BA.debugLineNum = 200;BA.debugLine="note.Initialize";
_note._initialize /*String*/ (ba);
 //BA.debugLineNum = 201;BA.debugLine="note.GroupId = CurrentGroupId";
_note._groupid /*String*/  = _currentgroupid;
 }else {
 //BA.debugLineNum = 203;BA.debugLine="note = ModNotes.GetNoteById(CurrentNoteId)";
_note = _modnotes._getnotebyid /*com.lockzero.clsnoteentry*/ (ba,_currentnoteid);
 //BA.debugLineNum = 204;BA.debugLine="If note = Null Then";
if (_note== null) { 
 //BA.debugLineNum = 205;BA.debugLine="ToastMessageShow(\"Erro ao carregar nota\", True)";
__c.ToastMessageShow(BA.ObjectToCharSequence("Erro ao carregar nota"),__c.True);
 //BA.debugLineNum = 206;BA.debugLine="Return";
if (true) return "";
 };
 };
 //BA.debugLineNum = 211;BA.debugLine="note.EncryptTitle(passPhrase, title)";
_note._encrypttitle /*String*/ (_passphrase,_title);
 //BA.debugLineNum = 212;BA.debugLine="note.EncryptContent(passPhrase, content)";
_note._encryptcontent /*String*/ (_passphrase,_content);
 //BA.debugLineNum = 213;BA.debugLine="note.IsFavorite = chkFavorite.Checked";
_note._isfavorite /*boolean*/  = _chkfavorite.getChecked();
 //BA.debugLineNum = 215;BA.debugLine="ModNotes.SaveNote(note)";
_modnotes._savenote /*String*/ (ba,_note);
 //BA.debugLineNum = 217;BA.debugLine="ToastMessageShow(\"Nota salva\", False)";
__c.ToastMessageShow(BA.ObjectToCharSequence("Nota salva"),__c.False);
 //BA.debugLineNum = 218;BA.debugLine="B4XPages.ClosePage(Me)";
_b4xpages._closepage /*String*/ (ba,this);
 //BA.debugLineNum = 219;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 4;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Private Root As B4XView";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 6;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 9;BA.debugLine="Private btnSave As Button";
_btnsave = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 10;BA.debugLine="Private btnCancel As Button";
_btncancel = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 11;BA.debugLine="Private btnDelete As Button";
_btndelete = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Private svContent As ScrollView";
_svcontent = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Private pnlContent As B4XView";
_pnlcontent = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private edtTitle As EditText";
_edttitle = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private edtContent As EditText";
_edtcontent = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private chkFavorite As CheckBox";
_chkfavorite = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private CurrentNoteId As String = \"\"";
_currentnoteid = "";
 //BA.debugLineNum = 22;BA.debugLine="Private CurrentGroupId As String = \"\"";
_currentgroupid = "";
 //BA.debugLineNum = 23;BA.debugLine="Private IsNewNote As Boolean = True";
_isnewnote = __c.True;
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return "";
}
public String  _createui() throws Exception{
int _width = 0;
int _height = 0;
int _y = 0;
int _margin = 0;
int _fieldwidth = 0;
anywheresoftware.b4a.objects.LabelWrapper _lbltitlefield = null;
anywheresoftware.b4a.objects.LabelWrapper _lblcontentfield = null;
anywheresoftware.b4a.objects.LabelWrapper _lblinfo = null;
 //BA.debugLineNum = 70;BA.debugLine="Private Sub CreateUI";
 //BA.debugLineNum = 71;BA.debugLine="Dim width As Int = Root.Width";
_width = _root.getWidth();
 //BA.debugLineNum = 72;BA.debugLine="Dim height As Int = Root.Height";
_height = _root.getHeight();
 //BA.debugLineNum = 75;BA.debugLine="btnCancel.Initialize(\"btnCancel\")";
_btncancel.Initialize(ba,"btnCancel");
 //BA.debugLineNum = 76;BA.debugLine="btnCancel.Text = ModLang.T(\"cancel\")";
_btncancel.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"cancel")));
 //BA.debugLineNum = 77;BA.debugLine="btnCancel.TextSize = 13";
_btncancel.setTextSize((float) (13));
 //BA.debugLineNum = 78;BA.debugLine="Root.AddView(btnCancel, 10dip, height - 70dip, 90";
_root.AddView((android.view.View)(_btncancel.getObject()),__c.DipToCurrent((int) (10)),(int) (_height-__c.DipToCurrent((int) (70))),__c.DipToCurrent((int) (90)),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 81;BA.debugLine="btnDelete.Initialize(\"btnDelete\")";
_btndelete.Initialize(ba,"btnDelete");
 //BA.debugLineNum = 82;BA.debugLine="btnDelete.Text = \"X\"";
_btndelete.setText(BA.ObjectToCharSequence("X"));
 //BA.debugLineNum = 83;BA.debugLine="btnDelete.Visible = False";
_btndelete.setVisible(__c.False);
 //BA.debugLineNum = 84;BA.debugLine="Root.AddView(btnDelete, width - 160dip, height -";
_root.AddView((android.view.View)(_btndelete.getObject()),(int) (_width-__c.DipToCurrent((int) (160))),(int) (_height-__c.DipToCurrent((int) (70))),__c.DipToCurrent((int) (50)),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 87;BA.debugLine="btnSave.Initialize(\"btnSave\")";
_btnsave.Initialize(ba,"btnSave");
 //BA.debugLineNum = 88;BA.debugLine="btnSave.Text = ModLang.T(\"save\")";
_btnsave.setText(BA.ObjectToCharSequence(_modlang._t /*String*/ (ba,"save")));
 //BA.debugLineNum = 89;BA.debugLine="btnSave.TextSize = 14";
_btnsave.setTextSize((float) (14));
 //BA.debugLineNum = 90;BA.debugLine="Root.AddView(btnSave, width - 100dip, height - 70";
_root.AddView((android.view.View)(_btnsave.getObject()),(int) (_width-__c.DipToCurrent((int) (100))),(int) (_height-__c.DipToCurrent((int) (70))),__c.DipToCurrent((int) (90)),__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 93;BA.debugLine="svContent.Initialize(0)";
_svcontent.Initialize(ba,(int) (0));
 //BA.debugLineNum = 94;BA.debugLine="Root.AddView(svContent, 0, 0, width, height - 80d";
_root.AddView((android.view.View)(_svcontent.getObject()),(int) (0),(int) (0),_width,(int) (_height-__c.DipToCurrent((int) (80))));
 //BA.debugLineNum = 96;BA.debugLine="pnlContent = svContent.Panel";
_pnlcontent = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_svcontent.getPanel().getObject()));
 //BA.debugLineNum = 97;BA.debugLine="pnlContent.Color = Colors.Transparent";
_pnlcontent.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 100;BA.debugLine="btnCancel.BringToFront";
_btncancel.BringToFront();
 //BA.debugLineNum = 101;BA.debugLine="btnDelete.BringToFront";
_btndelete.BringToFront();
 //BA.debugLineNum = 102;BA.debugLine="btnSave.BringToFront";
_btnsave.BringToFront();
 //BA.debugLineNum = 104;BA.debugLine="Dim y As Int = 20dip";
_y = __c.DipToCurrent((int) (20));
 //BA.debugLineNum = 105;BA.debugLine="Dim margin As Int = 16dip";
_margin = __c.DipToCurrent((int) (16));
 //BA.debugLineNum = 106;BA.debugLine="Dim fieldWidth As Int = width - (margin * 2)";
_fieldwidth = (int) (_width-(_margin*2));
 //BA.debugLineNum = 109;BA.debugLine="Dim lblTitleField As Label";
_lbltitlefield = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 110;BA.debugLine="lblTitleField.Initialize(\"\")";
_lbltitlefield.Initialize(ba,"");
 //BA.debugLineNum = 111;BA.debugLine="lblTitleField.Text = \"Titulo\"";
_lbltitlefield.setText(BA.ObjectToCharSequence("Titulo"));
 //BA.debugLineNum = 112;BA.debugLine="lblTitleField.TextSize = 14";
_lbltitlefield.setTextSize((float) (14));
 //BA.debugLineNum = 113;BA.debugLine="lblTitleField.TextColor = Colors.ARGB(180, 255, 2";
_lbltitlefield.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 114;BA.debugLine="pnlContent.AddView(lblTitleField, margin, y, fiel";
_pnlcontent.AddView((android.view.View)(_lbltitlefield.getObject()),_margin,_y,_fieldwidth,__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 115;BA.debugLine="y = y + 22dip";
_y = (int) (_y+__c.DipToCurrent((int) (22)));
 //BA.debugLineNum = 117;BA.debugLine="edtTitle.Initialize(\"edtTitle\")";
_edttitle.Initialize(ba,"edtTitle");
 //BA.debugLineNum = 118;BA.debugLine="edtTitle.Hint = \"Digite o titulo da nota\"";
_edttitle.setHint("Digite o titulo da nota");
 //BA.debugLineNum = 119;BA.debugLine="edtTitle.SingleLine = True";
_edttitle.setSingleLine(__c.True);
 //BA.debugLineNum = 120;BA.debugLine="edtTitle.TextSize = 16";
_edttitle.setTextSize((float) (16));
 //BA.debugLineNum = 121;BA.debugLine="edtTitle.InputType = Bit.Or(1, 8192) 'TEXT + CAP_";
_edttitle.setInputType(__c.Bit.Or((int) (1),(int) (8192)));
 //BA.debugLineNum = 122;BA.debugLine="pnlContent.AddView(edtTitle, margin, y, fieldWidt";
_pnlcontent.AddView((android.view.View)(_edttitle.getObject()),_margin,_y,_fieldwidth,__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 123;BA.debugLine="y = y + 60dip";
_y = (int) (_y+__c.DipToCurrent((int) (60)));
 //BA.debugLineNum = 126;BA.debugLine="Dim lblContentField As Label";
_lblcontentfield = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 127;BA.debugLine="lblContentField.Initialize(\"\")";
_lblcontentfield.Initialize(ba,"");
 //BA.debugLineNum = 128;BA.debugLine="lblContentField.Text = \"Conteudo\"";
_lblcontentfield.setText(BA.ObjectToCharSequence("Conteudo"));
 //BA.debugLineNum = 129;BA.debugLine="lblContentField.TextSize = 14";
_lblcontentfield.setTextSize((float) (14));
 //BA.debugLineNum = 130;BA.debugLine="lblContentField.TextColor = Colors.ARGB(180, 255,";
_lblcontentfield.setTextColor(__c.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 131;BA.debugLine="pnlContent.AddView(lblContentField, margin, y, fi";
_pnlcontent.AddView((android.view.View)(_lblcontentfield.getObject()),_margin,_y,_fieldwidth,__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 132;BA.debugLine="y = y + 22dip";
_y = (int) (_y+__c.DipToCurrent((int) (22)));
 //BA.debugLineNum = 134;BA.debugLine="edtContent.Initialize(\"edtContent\")";
_edtcontent.Initialize(ba,"edtContent");
 //BA.debugLineNum = 135;BA.debugLine="edtContent.Hint = \"Digite o conteudo da nota...\"";
_edtcontent.setHint("Digite o conteudo da nota...");
 //BA.debugLineNum = 136;BA.debugLine="edtContent.SingleLine = False";
_edtcontent.setSingleLine(__c.False);
 //BA.debugLineNum = 137;BA.debugLine="edtContent.TextSize = 15";
_edtcontent.setTextSize((float) (15));
 //BA.debugLineNum = 138;BA.debugLine="edtContent.Gravity = Gravity.TOP";
_edtcontent.setGravity(__c.Gravity.TOP);
 //BA.debugLineNum = 139;BA.debugLine="pnlContent.AddView(edtContent, margin, y, fieldWi";
_pnlcontent.AddView((android.view.View)(_edtcontent.getObject()),_margin,_y,_fieldwidth,__c.DipToCurrent((int) (180)));
 //BA.debugLineNum = 140;BA.debugLine="y = y + 190dip";
_y = (int) (_y+__c.DipToCurrent((int) (190)));
 //BA.debugLineNum = 143;BA.debugLine="chkFavorite.Initialize(\"chkFavorite\")";
_chkfavorite.Initialize(ba,"chkFavorite");
 //BA.debugLineNum = 144;BA.debugLine="chkFavorite.Text = \"Marcar como favorito\"";
_chkfavorite.setText(BA.ObjectToCharSequence("Marcar como favorito"));
 //BA.debugLineNum = 145;BA.debugLine="chkFavorite.TextSize = 15";
_chkfavorite.setTextSize((float) (15));
 //BA.debugLineNum = 146;BA.debugLine="pnlContent.AddView(chkFavorite, margin, y, fieldW";
_pnlcontent.AddView((android.view.View)(_chkfavorite.getObject()),_margin,_y,_fieldwidth,__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 147;BA.debugLine="y = y + 60dip";
_y = (int) (_y+__c.DipToCurrent((int) (60)));
 //BA.debugLineNum = 150;BA.debugLine="Dim lblInfo As Label";
_lblinfo = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 151;BA.debugLine="lblInfo.Initialize(\"\")";
_lblinfo.Initialize(ba,"");
 //BA.debugLineNum = 152;BA.debugLine="lblInfo.Text = \"O conteudo desta nota sera cripto";
_lblinfo.setText(BA.ObjectToCharSequence("O conteudo desta nota sera criptografado com sua frase-senha."));
 //BA.debugLineNum = 153;BA.debugLine="lblInfo.TextSize = 12";
_lblinfo.setTextSize((float) (12));
 //BA.debugLineNum = 154;BA.debugLine="lblInfo.TextColor = Colors.ARGB(120, 255, 255, 25";
_lblinfo.setTextColor(__c.Colors.ARGB((int) (120),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 155;BA.debugLine="lblInfo.Gravity = Gravity.CENTER_HORIZONTAL";
_lblinfo.setGravity(__c.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 156;BA.debugLine="pnlContent.AddView(lblInfo, margin, y, fieldWidth";
_pnlcontent.AddView((android.view.View)(_lblinfo.getObject()),_margin,_y,_fieldwidth,__c.DipToCurrent((int) (40)));
 //BA.debugLineNum = 157;BA.debugLine="y = y + 60dip";
_y = (int) (_y+__c.DipToCurrent((int) (60)));
 //BA.debugLineNum = 159;BA.debugLine="pnlContent.Height = y + 50dip";
_pnlcontent.setHeight((int) (_y+__c.DipToCurrent((int) (50))));
 //BA.debugLineNum = 160;BA.debugLine="End Sub";
return "";
}
public String  _edtcontent_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 237;BA.debugLine="Private Sub edtContent_FocusChanged(HasFocus As Bo";
 //BA.debugLineNum = 238;BA.debugLine="If HasFocus Then ScrollToView(edtContent, True)";
if (_hasfocus) { 
_scrolltoview((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_edtcontent.getObject())),__c.True);};
 //BA.debugLineNum = 239;BA.debugLine="End Sub";
return "";
}
public String  _edttitle_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 233;BA.debugLine="Private Sub edtTitle_FocusChanged(HasFocus As Bool";
 //BA.debugLineNum = 234;BA.debugLine="If HasFocus Then ScrollToView(edtTitle, False)";
if (_hasfocus) { 
_scrolltoview((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_edttitle.getObject())),__c.False);};
 //BA.debugLineNum = 235;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 26;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return "";
}
public String  _loadnote() throws Exception{
com.lockzero.clsnoteentry _note = null;
String _passphrase = "";
 //BA.debugLineNum = 166;BA.debugLine="Private Sub LoadNote";
 //BA.debugLineNum = 167;BA.debugLine="Dim note As clsNoteEntry = ModNotes.GetNoteById(C";
_note = _modnotes._getnotebyid /*com.lockzero.clsnoteentry*/ (ba,_currentnoteid);
 //BA.debugLineNum = 168;BA.debugLine="If note = Null Then";
if (_note== null) { 
 //BA.debugLineNum = 169;BA.debugLine="ToastMessageShow(\"Nota nao encontrada\", True)";
__c.ToastMessageShow(BA.ObjectToCharSequence("Nota nao encontrada"),__c.True);
 //BA.debugLineNum = 170;BA.debugLine="B4XPages.ClosePage(Me)";
_b4xpages._closepage /*String*/ (ba,this);
 //BA.debugLineNum = 171;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 174;BA.debugLine="Dim passPhrase As String = ModSession.GetPassphra";
_passphrase = _modsession._getpassphrase /*String*/ (ba);
 //BA.debugLineNum = 175;BA.debugLine="edtTitle.Text = note.GetDecryptedTitle(passPhrase";
_edttitle.setText(BA.ObjectToCharSequence(_note._getdecryptedtitle /*String*/ (_passphrase)));
 //BA.debugLineNum = 176;BA.debugLine="edtContent.Text = note.GetDecryptedContent(passPh";
_edtcontent.setText(BA.ObjectToCharSequence(_note._getdecryptedcontent /*String*/ (_passphrase)));
 //BA.debugLineNum = 177;BA.debugLine="chkFavorite.Checked = note.IsFavorite";
_chkfavorite.setChecked(_note._isfavorite /*boolean*/ );
 //BA.debugLineNum = 178;BA.debugLine="End Sub";
return "";
}
public String  _scrolltoview(anywheresoftware.b4a.objects.ConcreteViewWrapper _v,boolean _islargefield) throws Exception{
int _targety = 0;
 //BA.debugLineNum = 241;BA.debugLine="Private Sub ScrollToView(v As View, isLargeField A";
 //BA.debugLineNum = 242;BA.debugLine="Dim targetY As Int";
_targety = 0;
 //BA.debugLineNum = 243;BA.debugLine="If isLargeField Then";
if (_islargefield) { 
 //BA.debugLineNum = 246;BA.debugLine="targetY = v.Top - 30dip";
_targety = (int) (_v.getTop()-__c.DipToCurrent((int) (30)));
 }else {
 //BA.debugLineNum = 248;BA.debugLine="targetY = v.Top - 50dip";
_targety = (int) (_v.getTop()-__c.DipToCurrent((int) (50)));
 };
 //BA.debugLineNum = 250;BA.debugLine="If targetY < 0 Then targetY = 0";
if (_targety<0) { 
_targety = (int) (0);};
 //BA.debugLineNum = 251;BA.debugLine="svContent.ScrollPosition = targetY";
_svcontent.setScrollPosition(_targety);
 //BA.debugLineNum = 252;BA.debugLine="End Sub";
return "";
}
public String  _setparams(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
 //BA.debugLineNum = 47;BA.debugLine="Public Sub SetParams(params As Map)";
 //BA.debugLineNum = 48;BA.debugLine="If params = Null Then Return";
if (_params== null) { 
if (true) return "";};
 //BA.debugLineNum = 50;BA.debugLine="CurrentNoteId = params.GetDefault(\"noteId\", \"\")";
_currentnoteid = BA.ObjectToString(_params.GetDefault((Object)("noteId"),(Object)("")));
 //BA.debugLineNum = 51;BA.debugLine="CurrentGroupId = params.GetDefault(\"groupId\", \"\")";
_currentgroupid = BA.ObjectToString(_params.GetDefault((Object)("groupId"),(Object)("")));
 //BA.debugLineNum = 53;BA.debugLine="IsNewNote = (CurrentNoteId.Length = 0)";
_isnewnote = (_currentnoteid.length()==0);
 //BA.debugLineNum = 55;BA.debugLine="If IsNewNote Then";
if (_isnewnote) { 
 //BA.debugLineNum = 56;BA.debugLine="btnDelete.Visible = False";
_btndelete.setVisible(__c.False);
 //BA.debugLineNum = 57;BA.debugLine="edtTitle.Text = \"\"";
_edttitle.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 58;BA.debugLine="edtContent.Text = \"\"";
_edtcontent.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 59;BA.debugLine="chkFavorite.Checked = False";
_chkfavorite.setChecked(__c.False);
 }else {
 //BA.debugLineNum = 61;BA.debugLine="btnDelete.Visible = True";
_btndelete.setVisible(__c.True);
 //BA.debugLineNum = 62;BA.debugLine="LoadNote";
_loadnote();
 };
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
