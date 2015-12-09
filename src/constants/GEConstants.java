package constants; //package 선언

public class GEConstants { //GEConstants 클래스 선언
	//GEMainFrame
	public static final int WIDTH_MAINFRAME = 400; //MainFrame 가로길이(width) 상수 선언 및 할당
	public static final int HEIGTH_MAINFRAME = 600; //MainFrame 세로길이(height) 상수 선언 및 할당
	public static final String TITLE_MAINFRAME = "Graphic Editor"; //MainFrame frame 타이틀바 이름 상수 선언 및 할당
	
	//GEMenu
	public static final String TITLE_FILEMENU = "File"; //GEMenu FileMenu 이름 상수 선언 및 할당
	public static final String TITLE_EDITMENU = "Edit"; //GEMenu EditMenu 이름 상수 선언 및 할당
	public static final String TITLE_COLORMENU = "Color"; //GEMenu ColorMenu 이름 상수 선언 및 할당
	
	//GEMenuItems
	public static enum EFileMenuItems{New, Open, Save_as, Exit}; //FileMenuItems enum type 파일메뉴 메뉴아이템 이름 상수선언 및 할당
	public static enum EEditMenuItems{Undo, Redo, Delete, 잘라내기, Copy, 붙이기, Group, unGroup}; //EditMenuItems enum type 편집메뉴 메뉴아이템 이름 상수선언 및 할당
	public static enum EColorMenuItems{SetLineColor, ClearLinColor, SetFillColor, ClearFillColor}; //ColorMenuItem enum type 컬러메뉴 메뉴아이템 이름 상수선언 및 할당

	//GEToolbarShape
	public static final String TITLE_SHAPETOOLBAR = "Shape Tools"; //ToolBar 버튼 이미지 확장자 상수 선언 및 할당
	public static int WIDTH_SHAPETOOLBAR = 30; //ToolBar 선택된 버튼 이미지 확장자 상수 선언 및 할당
	public static int HEIGHT_SHAPETOOLBAR = 200;
	public static enum EToolBarButtons{Select, Rectangle, Line, Ellipse, Polygon};
	public static final String IMG_URL = "images/";
	public static final String SUFFIX_TOOLBAR_BTN = ".gif";
	public static final String SUFFIX_TOOLBAR_BTN_SLT = "SLT.gif";
}
