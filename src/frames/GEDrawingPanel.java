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

public class GEDrawingPanel extends JPanel { //GEDrawingPanel 클래스 선언
	
	private MouseDrawingHandler drawingHandler;	//MouseDrawingHandler 클래스 타입 drawingHandler 필드 선언	
	private GERectangle rectangle; //GERectangle 클래스 타입 rectangle 필드 선언
	private GELine line; //GELine 클래스 타입 line 필드 선언
	private GEEllipse ellipse; //GEEllipse 클래스 타입 ellipse 필드 선언
	private EToolBarButtons selectShape; //EToolBarButtons 클래스 타입 selectShape 필드 선언
	
	public GEDrawingPanel(){ //GEDrawingPanel 생성자 선언
		super(); //수퍼 클래스(JPanel) 생성자 호출
		drawingHandler = new MouseDrawingHandler();	//MouseDrawingHandler 클래스의 인스턴스 생성
		addMouseListener(drawingHandler); //MouseListner 포함 (MouseDrawingHandler 인스턴스를 파라미터로 받음)
		addMouseMotionListener(drawingHandler); //MouseMotionListner 포함 (MouseDrawingHandler 인스턴스를 파라미터로 받음)
		this.setForeground(GEConstants.FOREGROUND_COLOR); //GEDrawingPanel 도형윤곽색 설정 (도형윤곽색 상수를 파라미터로 받음)
		this.setBackground(GEConstants.BACKGROUND_COLOR); //GEDrawingPanel 배경색 설정 (배경색 상수를 파라미터로 받음)
	}
	public void setRectangle(GERectangle rectangle){ //void 타입 setRectangle() 메소드 선언 (GERectangle 타입의 객체를 파라미터로 받음)
		this.rectangle = rectangle; //파라미터로 받은 rectangle 객체를 rectangle 필드에 저장
	}
	public void setEllipse(GEEllipse ellipse){ //void 타입 setEllipse() 메소드 선언 (GEEllipse 타입의 객체를 파라미터로 받음)		
		this.ellipse = ellipse; //파라미터로 받은 ellipse 객체를 ellipse 필드에 저장	
	}							
	public void setLine(GELine line){ //void 타입 setLine() 메소드 선언 (GELine 타입의 객체를 파라미터로 받음)			
		this.line = line; //파라미터로 받은 line 객체를 line 필드에 저장				
	}							
	public void setSelectShape(EToolBarButtons selectShape){ //void 타입 setSelectShape() 메소드 선언 (EToolBarButtons 타입의 객체를 파라미터로 받음)	
		this.selectShape = selectShape; //파라미터로 받은 selectShape 객체를 selectShape 필드에 저장
	}	
	private void initDraw(Point startP){ //void 타입 initDraw() 메소드 선언 (Point 타입, 도형의 시작점인 startP를 파라미터로 받음)			
		if(selectShape == EToolBarButtons.Rectangle){ //ToolBar의 Rectangle버튼을 선택했을 경우 조건문을 실행
			rectangle = new GERectangle(); //GERectangle 클래스의 인스턴스 생성
			rectangle.initDraw(startP); //GERectangle의 initDraw() 메소드 호출 (파라미터로 받은 startP 객체를 파라미터로 받음)
		}else if(selectShape == EToolBarButtons.Ellipse){ 
			ellipse = new GEEllipse();			
			ellipse.initDraw(startP);			
		}else if(selectShape == EToolBarButtons.Line){	
			line = new GELine();			
			line.initDraw(startP);			
		}

	}
	private void animateDraw(Point currentP){ //void 타입 animateDraw() 메소드 선언 (Point 타입, 도형의 현재점인 currentP를 파라미터로 받음)
		Graphics2D g2D = (Graphics2D)getGraphics();	//Graphics2D 타입 g2D 필드 선언 및 할당	
		g2D.setXORMode(g2D.getBackground()); //Graphics2D의 setXORMode() 메소드 호출(Graphics2D의 getBackground() 메소드를 호출하여 반환된 값을 파라미터로 받음)
		if(selectShape == EToolBarButtons.Rectangle){ //ToolBar 클래스의 Rectangle 버튼을 선택했을 경우 조건문을 실행
			g2D.draw(rectangle.getRectangle());	//Graphics2D 클래스의 draw() 메소드 호출 (GERectangle 클래스의 getRectangle() 메소드를 호출하여 반환된 값을 파라미터로 받음)
			rectangle.setCoordinate(currentP); //GERectangle 클래스의 setCoordibate() 메소드를 호출 (currentP를 파라미터로 받음)	
			g2D.draw(rectangle.getRectangle());	//Graphics2D 클래스의 draw() 메소드 호출 (GERectangle 클래스의 getRectangle() 메소드를 호출하여 반환된 값을 파라미터로 받음)
		}else if(selectShape == EToolBarButtons.Ellipse){	
			g2D.draw(ellipse.getEllipse());		
			ellipse.setCoordinate(currentP);		
			g2D.draw(ellipse. getEllipse ());		
		}else if(selectShape == EToolBarButtons.Line){	
			g2D.draw(line.getLine());		
			line.setCoordinate(currentP);		
			g2D.draw(line. getLine());		
		}
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
