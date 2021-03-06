package frames; //package 선언

import java.awt.BorderLayout;

import javax.swing.JFrame; //외부 클래스 import
import javax.swing.WindowConstants;

import constants.GEConstants;
import menus.GEMenuBar;

public class GEMainFrame extends JFrame{ //GEMainFrame 클래스 선언
	
	private static GEMainFrame uniqueMainFrame
				= new GEMainFrame(GEConstants.TITLE_MAINFRAME); //GEMainFrame 클래스 타입 uniqueMainFrame 정적 필드 선언 및 인스턴스 생성
	private GEDrawingPanel drawingPanel; // GEDrawingPanel 클래스 타입 drawingPanel 필드 선언
	private GEMenuBar menuBar; //GEMenuBar 클래스 타입 menuBar 필드 선언
	private GEToolbar shapeToolbar; //GEToolBar 클래스 타입 shapeToolbar 필드 선언
	
	//GEMainFrame 생성자 선언(파라미터는 타이틀바의 문자열)
	private GEMainFrame(String title){ //수퍼 클래스(JFrame) 생성자 호출
		super(title);
		
		 //GEDrawingPanel 클래스의 인스턴스 생성
		drawingPanel = new GEDrawingPanel(); //GEDrawingPanel 클래스의 인스턴스 포함
		add(drawingPanel); 
		
		//GEMenuBar 클래스의 인스턴스 생성
		menuBar = new GEMenuBar(); //GEMenuBar 클래스의 인스턴스 포함(Frame에 MenuBar 추가)
		setJMenuBar(menuBar);
		
		//GEToolBar 클래스의 인스턴스 포함 (LayoutManager는 BorderLayout, Frame의 상단(North)에 생성)
		shapeToolbar = new GEToolbar(GEConstants.TITLE_SHAPETOOLBAR);
		add(BorderLayout.NORTH,shapeToolbar);
		}
	
	//getInstance() 정적 메소드 선언
	public static GEMainFrame getInstance(){ 
		return uniqueMainFrame;
	}
	
	//init 메소드 선언
	public void init(){ //메인 프레임 종료 옵션 설정
		shapeToolbar.init(drawingPanel); //GEToolBar 클래스의 init 메소드 호출
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //메인 프레임 크기 설정(파라미터는 GEConstants 클래스에 정의된 상수로 지정)
		setSize(GEConstants.WIDTH_MAINFRAME, GEConstants.HEIGTH_MAINFRAME); //메인 프레임 가시화
		setVisible(true);
		
	}
}
