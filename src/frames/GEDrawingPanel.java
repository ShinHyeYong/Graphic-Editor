package frames; //package 선언

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPanel; //외부 클래스 import
import javax.swing.event.MouseInputAdapter;

import constants.GEConstants;
import constants.GEConstants.EToolBarButtons;
import shapes.GEEllipse;
import shapes.GELine;
import shapes.GERectangle;
import shapes.GEShape;

public class GEDrawingPanel extends JPanel { //GEDrawingPanel 클래스 선언
	
	private MouseDrawingHandler drawingHandler;	//MouseDrawingHandler 클래스 타입 drawingHandler 필드 선언	
	private GEShape currentShape; //GEShape 클래스 타입 currentShape 필드 선언
	
	public GEDrawingPanel(){ //GEDrawingPanel 생성자 선언
		super(); //수퍼 클래스(JPanel) 생성자 호출
		drawingHandler = new MouseDrawingHandler();	//MouseDrawingHandler 클래스의 인스턴스 생성
		addMouseListener(drawingHandler); //MouseListner 포함 (MouseDrawingHandler 인스턴스를 파라미터로 받음)
		addMouseMotionListener(drawingHandler); //MouseMotionListner 포함 (MouseDrawingHandler 인스턴스를 파라미터로 받음)
		this.setForeground(GEConstants.FOREGROUND_COLOR); //GEDrawingPanel 도형윤곽색 설정 (도형윤곽색 상수를 파라미터로 받음)
		this.setBackground(GEConstants.BACKGROUND_COLOR); //GEDrawingPanel 배경색 설정 (배경색 상수를 파라미터로 받음)
	}
	public void setCurrentShape(GEShape currentShape){ //void 타입 setCurrentShape() 메소드 선언 (현재 선택된 도형인 GEShape 타입 currentShape 객체를 파라미터로 받음)
		this.currentShape = currentShape; //파라미터로 받은 currentShape 객체를 currentShape 필드에 저장
	}	
	private void initDraw(Point startP){ //void 타입 initDraw() 메소드 선언 (Point 타입, 도형의 시작점인 startP를 파라미터로 받음)			
		currentShape.initDraw(startP); //GEShape 클래스의 iniDraw() 메소드를 호출 (파라미터로 받은 startP 객체를 파라미터로 받음)
	}
	private void animateDraw(Point currentP){ //void 타입 animateDraw() 메소드 선언 (Point 타입, 도형의 현재점인 currentP를 파라미터로 받음)
		Graphics2D g2D = (Graphics2D)getGraphics();	//Graphics2D 타입 g2D 필드 선언 및 할당	
		g2D.setXORMode(g2D.getBackground()); //Graphics2D의 setXORMode() 메소드 호출(Graphics2D의 getBackground() 메소드를 호출하여 반환된 값을 파라미터로 받음)
		currentShape.draw(g2D); //Graphics2D 클래스의 draw() 메소드 호출
		currentShape.setCoordinate(currentP); //GEShape의 setCoordibate() 메소드를 호출 (currentP를 파라미터로 받음)
		currentShape.draw(g2D); //Graphics2D의 draw() 메소드 호출
	}	
	private class MouseDrawingHandler extends MouseInputAdapter{ //MouseDrawingHandler 내부 클래스 선언 (implements MouseInputAdapter interface)
		public void mousePressed(MouseEvent e){	//void 타입, mousePressed() 메소드 선언 (MouseInputAdapter interface의 mousePressed() 메소드 오버라이드. MouseEvent 타입의 객체를 파라미터로 받음)
			initDraw(e.getPoint()); //initDraw() 메소드 호출 (MouseEvent의 getPoint() 메소드를 호출하여 반환된 값(마우스를 눌렀을 때 마우스 커서의 좌표)을 파라미터로 받음)
		}							
		public void mouseDragged(MouseEvent e){	// void 타입, mouseDragged() 메소드 선언(MouseInputAdapter interface의 mouseDragged() 메소드 오버라이드. MouseEvent 타입의 객체를 파라미터로 받음)
			animateDraw(e.getPoint()); //animateDraw() 메소드 호출(MouseEvent의 getPoint() 메소드를 호출하여 반환된 값(마우스를 드래그 할 때 마우스 커서의 좌표를 파라미터로 받음)
		}
	}
}
