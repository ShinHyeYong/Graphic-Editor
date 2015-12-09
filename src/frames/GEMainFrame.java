package frames; //package ����

import javax.swing.JFrame; //�ܺ� Ŭ���� import
import javax.swing.WindowConstants;

import constants.GEConstants;
import menus.GEMenuBar;

public class GEMainFrame extends JFrame{ //GEMainFrame Ŭ���� ����
	
	private static GEMainFrame uniqueMainFrame
				= new GEMainFrame(GEConstants.TITLE_MAINFRAME); //GEMainFrame Ŭ���� Ÿ�� uniqueMainFrame ���� �ʵ� ���� �� �ν��Ͻ� ����
	private GEDrawingPanel drawingPanel; // GEDrawingPanel Ŭ���� Ÿ�� drawingPanel �ʵ� ����
	private GEMenuBar menuBar; //GEMenuBar Ŭ���� Ÿ�� menuBar �ʵ� ����
	
	//GEMainFrame ������ ����(�Ķ���ʹ� Ÿ��Ʋ���� ���ڿ�)
	private GEMainFrame(String title){ //���� Ŭ����(JFrame) ������ ȣ��
		super(title);
		
		 //GEDrawingPanel Ŭ������ �ν��Ͻ� ����
		drawingPanel = new GEDrawingPanel(); //GEDrawingPanel Ŭ������ �ν��Ͻ� ����
		add(drawingPanel); 
		
		//GEMenuBar Ŭ������ �ν��Ͻ� ����
		menuBar = new GEMenuBar(); //GEMenuBar Ŭ������ �ν��Ͻ� ����(Frame�� MenuBar �߰�)
		setJMenuBar(menuBar);
		}
	
	//getInstance() ���� �޼ҵ� ����
	public static GEMainFrame getInstance(){ 
		return uniqueMainFrame;
	}
	
	//init �޼ҵ� ����
	public void init(){ //���� ������ ���� �ɼ� ����
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //���� ������ ũ�� ����(�Ķ���ʹ� GEConstants Ŭ������ ���ǵ� ����� ����)
		setSize(GEConstants.WIDTH_MAINFRAME, GEConstants.HEIGTH_MAINFRAME); //���� ������ ����ȭ
		setVisible(true);
		
	}
}
