package com.lockzero;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class modtheme {
private static modtheme mostCurrent = new modtheme();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public static boolean _isdarktheme = false;
public b4a.example.dateutils _dateutils = null;
public com.lockzero.main _main = null;
public com.lockzero.starter _starter = null;
public com.lockzero.modbackup _modbackup = null;
public com.lockzero.modlang _modlang = null;
public com.lockzero.modnotes _modnotes = null;
public com.lockzero.modpasswords _modpasswords = null;
public com.lockzero.modsecurity _modsecurity = null;
public com.lockzero.modsession _modsession = null;
public com.lockzero.b4xpages _b4xpages = null;
public com.lockzero.b4xcollections _b4xcollections = null;
public com.lockzero.xuiviewsutils _xuiviewsutils = null;
public static int  _accent(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 58;BA.debugLine="Public Sub Accent As Int";
 //BA.debugLineNum = 59;BA.debugLine="Return Colors.RGB(45, 90, 140) '#2D5A8C Azul acin";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (45),(int) (90),(int) (140));
 //BA.debugLineNum = 60;BA.debugLine="End Sub";
return 0;
}
public static int  _background(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 110;BA.debugLine="Public Sub Background As Int";
 //BA.debugLineNum = 111;BA.debugLine="If IsDarkTheme Then";
if (_isdarktheme) { 
 //BA.debugLineNum = 112;BA.debugLine="Return Colors.RGB(12, 14, 18) '#0C0E12 Preto azu";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (12),(int) (14),(int) (18));
 }else {
 //BA.debugLineNum = 114;BA.debugLine="Return Colors.RGB(245, 247, 250) '#F5F7FA Cinza";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (245),(int) (247),(int) (250));
 };
 //BA.debugLineNum = 116;BA.debugLine="End Sub";
return 0;
}
public static int  _buttondanger(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 214;BA.debugLine="Public Sub ButtonDanger As Int";
 //BA.debugLineNum = 215;BA.debugLine="Return Danger";
if (true) return _danger(_ba);
 //BA.debugLineNum = 216;BA.debugLine="End Sub";
return 0;
}
public static int  _buttondisabled(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 218;BA.debugLine="Public Sub ButtonDisabled As Int";
 //BA.debugLineNum = 219;BA.debugLine="If IsDarkTheme Then";
if (_isdarktheme) { 
 //BA.debugLineNum = 220;BA.debugLine="Return Colors.RGB(40, 48, 60) '#28303C";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (40),(int) (48),(int) (60));
 }else {
 //BA.debugLineNum = 222;BA.debugLine="Return Colors.RGB(220, 225, 230) '#DCE1E6";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (220),(int) (225),(int) (230));
 };
 //BA.debugLineNum = 224;BA.debugLine="End Sub";
return 0;
}
public static int  _buttonprimary(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 202;BA.debugLine="Public Sub ButtonPrimary As Int";
 //BA.debugLineNum = 203;BA.debugLine="Return Primary";
if (true) return _primary(_ba);
 //BA.debugLineNum = 204;BA.debugLine="End Sub";
return 0;
}
public static int  _buttonsecondary(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 206;BA.debugLine="Public Sub ButtonSecondary As Int";
 //BA.debugLineNum = 207;BA.debugLine="If IsDarkTheme Then";
if (_isdarktheme) { 
 //BA.debugLineNum = 208;BA.debugLine="Return Colors.RGB(55, 65, 80) '#374150";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (55),(int) (65),(int) (80));
 }else {
 //BA.debugLineNum = 210;BA.debugLine="Return Colors.RGB(220, 225, 230) '#DCE1E6";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (220),(int) (225),(int) (230));
 };
 //BA.debugLineNum = 212;BA.debugLine="End Sub";
return 0;
}
public static int  _buttontextprimary(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 226;BA.debugLine="Public Sub ButtonTextPrimary As Int";
 //BA.debugLineNum = 227;BA.debugLine="Return Colors.White";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.White;
 //BA.debugLineNum = 228;BA.debugLine="End Sub";
return 0;
}
public static int  _buttontextsecondary(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 230;BA.debugLine="Public Sub ButtonTextSecondary As Int";
 //BA.debugLineNum = 231;BA.debugLine="Return TextPrimary";
if (true) return _textprimary(_ba);
 //BA.debugLineNum = 232;BA.debugLine="End Sub";
return 0;
}
public static int  _cardbackground(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 238;BA.debugLine="Public Sub CardBackground As Int";
 //BA.debugLineNum = 239;BA.debugLine="Return Surface";
if (true) return _surface(_ba);
 //BA.debugLineNum = 240;BA.debugLine="End Sub";
return 0;
}
public static int  _cardborder(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 242;BA.debugLine="Public Sub CardBorder As Int";
 //BA.debugLineNum = 243;BA.debugLine="If IsDarkTheme Then";
if (_isdarktheme) { 
 //BA.debugLineNum = 244;BA.debugLine="Return Colors.RGB(33, 40, 50) '#212832";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (33),(int) (40),(int) (50));
 }else {
 //BA.debugLineNum = 246;BA.debugLine="Return Colors.RGB(220, 225, 230) '#DCE1E6";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (220),(int) (225),(int) (230));
 };
 //BA.debugLineNum = 248;BA.debugLine="End Sub";
return 0;
}
public static int  _categorycard(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 90;BA.debugLine="Public Sub CategoryCard As Int";
 //BA.debugLineNum = 91;BA.debugLine="Return Colors.RGB(50, 60, 75) '#323C4B Cinza azul";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (50),(int) (60),(int) (75));
 //BA.debugLineNum = 92;BA.debugLine="End Sub";
return 0;
}
public static int  _categorydocument(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 94;BA.debugLine="Public Sub CategoryDocument As Int";
 //BA.debugLineNum = 95;BA.debugLine="Return Colors.RGB(38, 48, 60) '#26303C Cinza slat";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (38),(int) (48),(int) (60));
 //BA.debugLineNum = 96;BA.debugLine="End Sub";
return 0;
}
public static int  _categorynote(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 98;BA.debugLine="Public Sub CategoryNote As Int";
 //BA.debugLineNum = 99;BA.debugLine="Return Colors.RGB(45, 55, 70) '#2D3746 Cinza ardo";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (45),(int) (55),(int) (70));
 //BA.debugLineNum = 100;BA.debugLine="End Sub";
return 0;
}
public static int  _categorypassword(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 86;BA.debugLine="Public Sub CategoryPassword As Int";
 //BA.debugLineNum = 87;BA.debugLine="Return Colors.RGB(10, 37, 64) '#0A2540 Navy (prim";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (10),(int) (37),(int) (64));
 //BA.debugLineNum = 88;BA.debugLine="End Sub";
return 0;
}
public static int  _categorywifi(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 102;BA.debugLine="Public Sub CategoryWifi As Int";
 //BA.debugLineNum = 103;BA.debugLine="Return Colors.RGB(55, 65, 80) '#374150 Cinza medi";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (55),(int) (65),(int) (80));
 //BA.debugLineNum = 104;BA.debugLine="End Sub";
return 0;
}
public static int  _danger(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 74;BA.debugLine="Public Sub Danger As Int";
 //BA.debugLineNum = 75;BA.debugLine="Return Colors.RGB(140, 45, 50) '#8C2D32 Vermelho";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (140),(int) (45),(int) (50));
 //BA.debugLineNum = 76;BA.debugLine="End Sub";
return 0;
}
public static int  _elevated(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 134;BA.debugLine="Public Sub Elevated As Int";
 //BA.debugLineNum = 135;BA.debugLine="If IsDarkTheme Then";
if (_isdarktheme) { 
 //BA.debugLineNum = 136;BA.debugLine="Return Colors.RGB(40, 48, 60) '#28303C Cards des";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (40),(int) (48),(int) (60));
 }else {
 //BA.debugLineNum = 138;BA.debugLine="Return Colors.White";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.White;
 };
 //BA.debugLineNum = 140;BA.debugLine="End Sub";
return 0;
}
public static anywheresoftware.b4a.objects.drawable.ColorDrawable  _getbuttonprimarydrawable(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
 //BA.debugLineNum = 298;BA.debugLine="Public Sub GetButtonPrimaryDrawable As ColorDrawab";
 //BA.debugLineNum = 299;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 300;BA.debugLine="cd.Initialize(Primary, 8dip)";
_cd.Initialize(_primary(_ba),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (8)));
 //BA.debugLineNum = 301;BA.debugLine="Return cd";
if (true) return _cd;
 //BA.debugLineNum = 302;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.drawable.ColorDrawable  _getbuttonsecondarydrawable(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
 //BA.debugLineNum = 304;BA.debugLine="Public Sub GetButtonSecondaryDrawable As ColorDraw";
 //BA.debugLineNum = 305;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 306;BA.debugLine="cd.Initialize2(ButtonSecondary, 8dip, 1dip, Input";
_cd.Initialize2(_buttonsecondary(_ba),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (8)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)),_inputborder(_ba));
 //BA.debugLineNum = 307;BA.debugLine="Return cd";
if (true) return _cd;
 //BA.debugLineNum = 308;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.drawable.ColorDrawable  _getcarddrawable(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
 //BA.debugLineNum = 292;BA.debugLine="Public Sub GetCardDrawable As ColorDrawable";
 //BA.debugLineNum = 293;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 294;BA.debugLine="cd.Initialize2(CardBackground, 12dip, 1dip, CardB";
_cd.Initialize2(_cardbackground(_ba),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)),_cardborder(_ba));
 //BA.debugLineNum = 295;BA.debugLine="Return cd";
if (true) return _cd;
 //BA.debugLineNum = 296;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.drawable.ColorDrawable  _getinputdrawable(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
 //BA.debugLineNum = 286;BA.debugLine="Public Sub GetInputDrawable As ColorDrawable";
 //BA.debugLineNum = 287;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 288;BA.debugLine="cd.Initialize2(InputBackground, 8dip, 1dip, Input";
_cd.Initialize2(_inputbackground(_ba),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (8)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)),_inputborder(_ba));
 //BA.debugLineNum = 289;BA.debugLine="Return cd";
if (true) return _cd;
 //BA.debugLineNum = 290;BA.debugLine="End Sub";
return null;
}
public static int  _headerbackground(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 258;BA.debugLine="Public Sub HeaderBackground As Int";
 //BA.debugLineNum = 259;BA.debugLine="Return Primary '#0A2540 Navy";
if (true) return _primary(_ba);
 //BA.debugLineNum = 260;BA.debugLine="End Sub";
return 0;
}
public static int  _headertext(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 262;BA.debugLine="Public Sub HeaderText As Int";
 //BA.debugLineNum = 263;BA.debugLine="Return Colors.White";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.White;
 //BA.debugLineNum = 264;BA.debugLine="End Sub";
return 0;
}
public static int  _homebg(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 26;BA.debugLine="Public Sub HomeBg As Int";
 //BA.debugLineNum = 27;BA.debugLine="Return Colors.RGB(28, 58, 106) '#1C3A6A - Fundo p";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (28),(int) (58),(int) (106));
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return 0;
}
public static int  _homecardbg(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 34;BA.debugLine="Public Sub HomeCardBg As Int";
 //BA.debugLineNum = 35;BA.debugLine="Return Colors.RGB(44, 79, 128) '#2C4F80 - Cards 2";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (44),(int) (79),(int) (128));
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return 0;
}
public static int  _homeheaderbg(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 30;BA.debugLine="Public Sub HomeHeaderBg As Int";
 //BA.debugLineNum = 31;BA.debugLine="Return Colors.RGB(21, 47, 88) '#152F58 - Header (";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (21),(int) (47),(int) (88));
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return 0;
}
public static int  _homeiconbg(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 38;BA.debugLine="Public Sub HomeIconBg As Int";
 //BA.debugLineNum = 39;BA.debugLine="Return Colors.RGB(71, 82, 110) '#47526E - Fundo d";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (71),(int) (82),(int) (110));
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return 0;
}
public static int  _info(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 78;BA.debugLine="Public Sub Info As Int";
 //BA.debugLineNum = 79;BA.debugLine="Return Colors.RGB(45, 90, 140) '#2D5A8C Azul acin";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (45),(int) (90),(int) (140));
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return 0;
}
public static String  _init(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 9;BA.debugLine="Public Sub Init";
 //BA.debugLineNum = 10;BA.debugLine="IsDarkTheme = (ModSecurity.GetTheme = 1)";
_isdarktheme = (mostCurrent._modsecurity._gettheme /*int*/ (_ba)==1);
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
public static int  _inputbackground(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 174;BA.debugLine="Public Sub InputBackground As Int";
 //BA.debugLineNum = 175;BA.debugLine="If IsDarkTheme Then";
if (_isdarktheme) { 
 //BA.debugLineNum = 176;BA.debugLine="Return Colors.RGB(33, 40, 50) '#212832";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (33),(int) (40),(int) (50));
 }else {
 //BA.debugLineNum = 178;BA.debugLine="Return Colors.White";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.White;
 };
 //BA.debugLineNum = 180;BA.debugLine="End Sub";
return 0;
}
public static int  _inputborder(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 182;BA.debugLine="Public Sub InputBorder As Int";
 //BA.debugLineNum = 183;BA.debugLine="If IsDarkTheme Then";
if (_isdarktheme) { 
 //BA.debugLineNum = 184;BA.debugLine="Return Colors.RGB(55, 65, 80) '#374150";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (55),(int) (65),(int) (80));
 }else {
 //BA.debugLineNum = 186;BA.debugLine="Return Colors.RGB(200, 205, 215) '#C8CDD7";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (200),(int) (205),(int) (215));
 };
 //BA.debugLineNum = 188;BA.debugLine="End Sub";
return 0;
}
public static int  _inputhint(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 194;BA.debugLine="Public Sub InputHint As Int";
 //BA.debugLineNum = 195;BA.debugLine="Return TextMuted";
if (true) return _textmuted(_ba);
 //BA.debugLineNum = 196;BA.debugLine="End Sub";
return 0;
}
public static int  _inputtext(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 190;BA.debugLine="Public Sub InputText As Int";
 //BA.debugLineNum = 191;BA.debugLine="Return TextPrimary";
if (true) return _textprimary(_ba);
 //BA.debugLineNum = 192;BA.debugLine="End Sub";
return 0;
}
public static int  _itempressed(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 250;BA.debugLine="Public Sub ItemPressed As Int";
 //BA.debugLineNum = 251;BA.debugLine="Return SurfaceLight";
if (true) return _surfacelight(_ba);
 //BA.debugLineNum = 252;BA.debugLine="End Sub";
return 0;
}
public static int  _navactive(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 274;BA.debugLine="Public Sub NavActive As Int";
 //BA.debugLineNum = 275;BA.debugLine="Return Primary";
if (true) return _primary(_ba);
 //BA.debugLineNum = 276;BA.debugLine="End Sub";
return 0;
}
public static int  _navbackground(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 266;BA.debugLine="Public Sub NavBackground As Int";
 //BA.debugLineNum = 267;BA.debugLine="If IsDarkTheme Then";
if (_isdarktheme) { 
 //BA.debugLineNum = 268;BA.debugLine="Return Colors.RGB(22, 27, 34) '#161B22";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (22),(int) (27),(int) (34));
 }else {
 //BA.debugLineNum = 270;BA.debugLine="Return Colors.White";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.White;
 };
 //BA.debugLineNum = 272;BA.debugLine="End Sub";
return 0;
}
public static int  _navinactive(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 278;BA.debugLine="Public Sub NavInactive As Int";
 //BA.debugLineNum = 279;BA.debugLine="Return TextMuted";
if (true) return _textmuted(_ba);
 //BA.debugLineNum = 280;BA.debugLine="End Sub";
return 0;
}
public static int  _primary(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 46;BA.debugLine="Public Sub Primary As Int";
 //BA.debugLineNum = 47;BA.debugLine="Return Colors.RGB(10, 37, 64) '#0A2540 Navy profu";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (10),(int) (37),(int) (64));
 //BA.debugLineNum = 48;BA.debugLine="End Sub";
return 0;
}
public static int  _primarydark(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 50;BA.debugLine="Public Sub PrimaryDark As Int";
 //BA.debugLineNum = 51;BA.debugLine="Return Colors.RGB(5, 25, 45) '#05192D Navy escure";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (5),(int) (25),(int) (45));
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return 0;
}
public static int  _primarylight(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 54;BA.debugLine="Public Sub PrimaryLight As Int";
 //BA.debugLineNum = 55;BA.debugLine="Return Colors.RGB(20, 55, 90) '#14375A Navy claro";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (20),(int) (55),(int) (90));
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return 0;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 5;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Public IsDarkTheme As Boolean = True 'Padrao: esc";
_isdarktheme = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return "";
}
public static String  _setdarktheme(anywheresoftware.b4a.BA _ba,boolean _dark) throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Public Sub SetDarkTheme(dark As Boolean)";
 //BA.debugLineNum = 14;BA.debugLine="IsDarkTheme = dark";
_isdarktheme = _dark;
 //BA.debugLineNum = 15;BA.debugLine="ModSecurity.SaveTheme(IIf(dark, 1, 0))";
mostCurrent._modsecurity._savetheme /*String*/ (_ba,(int)(BA.ObjectToNumber(((_dark) ? ((Object)(1)) : ((Object)(0))))));
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return "";
}
public static int  _success(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 66;BA.debugLine="Public Sub Success As Int";
 //BA.debugLineNum = 67;BA.debugLine="Return Colors.RGB(45, 90, 140) '#2D5A8C Azul (sem";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (45),(int) (90),(int) (140));
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return 0;
}
public static int  _surface(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 118;BA.debugLine="Public Sub Surface As Int";
 //BA.debugLineNum = 119;BA.debugLine="If IsDarkTheme Then";
if (_isdarktheme) { 
 //BA.debugLineNum = 120;BA.debugLine="Return Colors.RGB(22, 27, 34) '#161B22 Superfici";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (22),(int) (27),(int) (34));
 }else {
 //BA.debugLineNum = 122;BA.debugLine="Return Colors.White";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.White;
 };
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return 0;
}
public static int  _surfacelight(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 126;BA.debugLine="Public Sub SurfaceLight As Int";
 //BA.debugLineNum = 127;BA.debugLine="If IsDarkTheme Then";
if (_isdarktheme) { 
 //BA.debugLineNum = 128;BA.debugLine="Return Colors.RGB(33, 40, 50) '#212832 Superfici";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (33),(int) (40),(int) (50));
 }else {
 //BA.debugLineNum = 130;BA.debugLine="Return Colors.RGB(240, 242, 245) '#F0F2F5";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (240),(int) (242),(int) (245));
 };
 //BA.debugLineNum = 132;BA.debugLine="End Sub";
return 0;
}
public static int  _textmuted(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 162;BA.debugLine="Public Sub TextMuted As Int";
 //BA.debugLineNum = 163;BA.debugLine="If IsDarkTheme Then";
if (_isdarktheme) { 
 //BA.debugLineNum = 164;BA.debugLine="Return Colors.RGB(95, 110, 125) '#5F6E7D";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (95),(int) (110),(int) (125));
 }else {
 //BA.debugLineNum = 166;BA.debugLine="Return Colors.RGB(140, 155, 170) '#8C9BAA";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (140),(int) (155),(int) (170));
 };
 //BA.debugLineNum = 168;BA.debugLine="End Sub";
return 0;
}
public static int  _textprimary(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 146;BA.debugLine="Public Sub TextPrimary As Int";
 //BA.debugLineNum = 147;BA.debugLine="If IsDarkTheme Then";
if (_isdarktheme) { 
 //BA.debugLineNum = 148;BA.debugLine="Return Colors.RGB(230, 235, 240) '#E6EBF0";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (230),(int) (235),(int) (240));
 }else {
 //BA.debugLineNum = 150;BA.debugLine="Return Colors.RGB(20, 25, 30) '#14191E";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (20),(int) (25),(int) (30));
 };
 //BA.debugLineNum = 152;BA.debugLine="End Sub";
return 0;
}
public static int  _textsecondary(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 154;BA.debugLine="Public Sub TextSecondary As Int";
 //BA.debugLineNum = 155;BA.debugLine="If IsDarkTheme Then";
if (_isdarktheme) { 
 //BA.debugLineNum = 156;BA.debugLine="Return Colors.RGB(140, 155, 170) '#8C9BAA";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (140),(int) (155),(int) (170));
 }else {
 //BA.debugLineNum = 158;BA.debugLine="Return Colors.RGB(80, 95, 110) '#505F6E";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (80),(int) (95),(int) (110));
 };
 //BA.debugLineNum = 160;BA.debugLine="End Sub";
return 0;
}
public static String  _toggletheme(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 18;BA.debugLine="Public Sub ToggleTheme";
 //BA.debugLineNum = 19;BA.debugLine="SetDarkTheme(Not(IsDarkTheme))";
_setdarktheme(_ba,anywheresoftware.b4a.keywords.Common.Not(_isdarktheme));
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return "";
}
public static int  _warning(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 70;BA.debugLine="Public Sub Warning As Int";
 //BA.debugLineNum = 71;BA.debugLine="Return Colors.RGB(160, 110, 45) '#A06E2D Amber es";
if (true) return anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (160),(int) (110),(int) (45));
 //BA.debugLineNum = 72;BA.debugLine="End Sub";
return 0;
}
}
