package constants; //package ����

public class GEConstants { //GEConstants Ŭ���� ����
	//GEMainFrame
	public static final int WIDTH_MAINFRAME = 400; //MainFrame ���α���(width) ��� ���� �� �Ҵ�
	public static final int HEIGTH_MAINFRAME = 600; //MainFrame ���α���(height) ��� ���� �� �Ҵ�
	public static final String TITLE_MAINFRAME = "Graphic Editor"; //MainFrame frame Ÿ��Ʋ�� �̸� ��� ���� �� �Ҵ�
	
	//GEMenu
	public static final String TITLE_FILEMENU = "File"; //GEMenu FileMenu �̸� ��� ���� �� �Ҵ�
	public static final String TITLE_EDITMENU = "Edit"; //GEMenu EditMenu �̸� ��� ���� �� �Ҵ�
	public static final String TITLE_COLORMENU = "Color"; //GEMenu ColorMenu �̸� ��� ���� �� �Ҵ�
	
	//GEMenuItems
	public static enum EFileMenuItems{New, Open, Save_as, Exit}; //FileMenuItems enum type ���ϸ޴� �޴������� �̸� ������� �� �Ҵ�
	public static enum EEditMenuItems{Undo, Redo, Delete, �߶󳻱�, Copy, ���̱�}; //EditMenuItems enum type �����޴� �޴������� �̸� ������� �� �Ҵ�
	public static enum EColorMenuItems{SetLineColor, ClearLinColor, SetFillColor, ClearFillColor}; //ColorMenuItem enum type �÷��޴� �޴������� �̸� ������� �� �Ҵ�
}
