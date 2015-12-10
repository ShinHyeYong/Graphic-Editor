package frames; //package 선언

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel; //외부 클래스 import
import javax.swing.event.MouseInputAdapter;

import constants.GEConstants;
import constants.GEConstants.EState;
import shapes.GEPolygon;
import shapes.GEShape;

public class GEDrawingPanel extends JPanel { //GEDrawingPanel 클래스 선언
	
	private MouseDrawingHandler drawingHandler;	//MouseDrawingHandler 클래스 타입 drawingHandler 필드 선언	
	private GEShape currentShape; //GEShape 클래스 타입 currentShape 필드 선언
	private ArrayList<GEShape> shapeList;//ArrayList 클래스 타입 (arrayitem 타입은 GEShape) shapeList 선언
	private EState currentState; //EState 타입 currentState 필드 선언
	
	public GEDrawingPanel(){ //GEDrawingPanel 생성자 선언
		super(); //수퍼 클래스(JPanel) 생성자 호출
		currentState = EState.Idle; //: currentState필드에 그리기 상태를 Idle로 설정하여 저장
		shapeList = new ArrayList<GEShape>(); //: ArrayList 클래스의 인스턴스 생성
		drawingHandler = new MouseDrawingHandler();	//MouseDrawingHandler 클래스의 인스턴스 생성
		addMouseListener(drawingHandler); //MouseListner 포함 (MouseDrawingHandler 인스턴스를 파라미터로 받음)
		addMouseMotionListener(drawingHandler); //MouseMotionListner 포함 (MouseDrawingHandler 인스턴스를 파라미터로 받음)
		this.setForeground(GEConstants.FOREGROUND_COLOR); //GEDrawingPanel 도형윤곽색 설정 (도형윤곽색 상수를 파라미터로 받음)
		this.setBackground(GEConstants.BACKGROUND_COLOR); //GEDrawingPanel 배경색 설정 (배경색 상수를 파라미터로 받음)
	}
	public void setCurrentShape(GEShape currentShape){ //void 타입 setCurrentShape() 메소드 선언 (현재 선택된 도형인 GEShape 타입 currentShape 객체를 파라미터로 받음)
		this.currentShape = currentShape; //파라미터로 받은 currentShape 객체를 currentShape 필드에 저장
	}	
	public void paintComponent(Graphics g){ //void 타입 paintComponent() 메소드 선언 (Grapchis 클래스 객체를 파라미터로 받음)
		super.paintComponent(g); //수퍼 클래스의 paintComponent()메소드 호출 (받은 Graphics 클래스 객체를 파라미터로 받음)
		Graphics2D g2D = (Graphics2D)g; //Graphics2D 클래스 타입 변수 g2D 선언 및 할당 (파라미터로 받은 Graphics 클래스 객체를 Graphics2D로 downcast하여 할당)
		for(GEShape shape : shapeList){ //shapeList 필드에 저장된 GEShape 클래스 타입 객체들을 drawingPanel에 그려주기 위한 확장for문 선언 (shapeList 필드에 저장된 객체 수만큼 반복)
			shape.draw(g2D); //Graphics2D 클래스의 draw() 메소드 호출
		}
	}
	private void initDraw(Point startP){ //void 타입 initDraw() 메소드 선언 (Point 타입, 도형의 시작점인 startP를 파라미터로 받음)			
		currentShape = currentShape.clone(); //GEShape 클래스의 clone() 메소드를 호출하여 리턴된 값을 currentShape 필드에 저장
		currentShape.initDraw(startP); //GEShape 클래스의 iniDraw() 메소드를 호출 (파라미터로 받은 startP 객체를 파라미터로 받음)
	}
	private void animateDraw(Point currentP){ //void 타입 animateDraw() 메소드 선언 (Point 타입, 도형의 현재점인 currentP를 파라미터로 받음)
		Graphics2D g2D = (Graphics2D)getGraphics();	//Graphics2D 타입 g2D 필드 선언 및 할당	
		g2D.setXORMode(g2D.getBackground()); //Graphics2D의 setXORMode() 메소드 호출(Graphics2D의 getBackground() 메소드를 호출하여 반환된 값을 파라미터로 받음)
		currentShape.draw(g2D); //Graphics2D 클래스의 draw() 메소드 호출
		currentShape.setCoordinate(currentP); //GEShape의 setCoordibate() 메소드를 호출 (currentP를 파라미터로 받음)
		currentShape.draw(g2D); //Graphics2D의 draw() 메소드 호출
	}	
	public void continueDrawing(Point p){ //void 타입 continueDrawing() 메소드 선언 (Point 클래스 타입 객체를 파라미터로 받음)
		((GEPolygon)currentShape).continueDrawing(p); //getCurrentShape() 메소드를 호출하여 반환된 값을 GEPolygon 클래스 타입으로 cast한 뒤  GEPolygon의 continueDrawing() 메소드 호출. (받은 Point 클래스 타입 객체를 파라미터로 받음)
	}
	public void finishDraw(GEShape shape){ //void 타입 finishDraw() 메소드 선언 (GEShape 클래스 타입 객체를 파라미터로 받음)
		shapeList.add(shape); //ArrayList 클래스의 add() 메소드 호출 (파라미터로 받은 객체를 shapeList 필드에 저장)
		currentState = EState.Idle; //setCurrentState() 메소드 호출 (그리기상태를 Idle로 설정)
		repaint(); //repaint() 메소드 호출 (GEDrawingPanel의 모든 도형 컴포넌트들을 다시 그림)
	}
	private class MouseDrawingHandler extends MouseInputAdapter{ //MouseDrawingHandler 내부 클래스 선언 (implements MouseInputAdapter interface)
		public void mousePressed(MouseEvent e){	//void 타입, mousePressed() 메소드 선언 (MouseInputAdapter interface의 mousePressed() 메소드 오버라이드. MouseEvent 타입의 객체를 파라미터로 받음)
			if(currentState  == EState.Idle){ //currentState 필드값이 Estate의 Idle 값과 같다면 조건문 실행
				initDraw(e.getPoint());	//initDraw() 메소드 호출
				if(currentShape instanceof GEPolygon){ //currentShape 필드의 값이 GEPolygon으로 설정되어 있을 경우 조건문 실행
					currentState = EState.NPointsDrawing; //currentState 필드의 값을 ESate의 NPointsDrawing으로 설정
				}else{ //currentShape 필드의 값이 GEPolygon으로 설정되어 있지 않을 경우 조건문 실행
					currentState = EState.TwoPointsDrawing; //currentState 필드의 값을 EState의 TwoPointsDrawing으로 설정
					}
				}
			}
		public void mouseMoved(MouseEvent e){ //void 타입 mouseMoved() 메소드 선언		
			if(currentState == EState.NPointsDrawing){ //currentState 필드의 값이 그리기 상태 상수(EState)의 NPointsDrawing 값과 같다면 조건문 실행		
				animateDraw(e.getPoint()); //animateDraw() 메소드 호출 
			}	
		}
		public void mouseDragged(MouseEvent e){	// void 타입, mouseDragged() 메소드 선언(MouseInputAdapter interface의 mouseDragged() 메소드 오버라이드. MouseEvent 타입의 객체를 파라미터로 받음)
			if (currentState != EState.Idle){ //currentState 필드의 값이 Estate의 Idle 값과 같지 않다면 조건문 실행
				animateDraw(e.getPoint()); //animateDraw() 메소드 호출
				}
			}
		public void mouseReleased(MouseEvent e){ //void 타입 mouseReleased() 메소드 호출
			if(currentState == EState.TwoPointsDrawing){ //currentState 필드의 값이 EState의 TwoPointsDrawing 값과 같다면 조건문 실행
				finishDraw(currentShape); //finishDraw() 메소드 호출 (currentShape 필드를 파라미터로 받음)
				}
			}
		public void mouseClicked(MouseEvent e){ //void 타입 mouseClicked() 메소드 선언
			if(e.getButton() == MouseEvent.BUTTON1){ //: MouseEvent 클래스의 getPoint() 메소드를 호출하여 반환된 값(클릭된 마우스 버튼)이 MouseEvent 클래스의 BUTTON1 상수 값(마우스 왼쪽버튼 클릭)과 같다면 조건문 실행
				if(currentState == EState.NPointsDrawing){ //currentState 필드의 값이 EState의 NPointDrawing 값과 같다면 조건문 실행
					if(e.getClickCount() == 1){ //MouseEvent 클래스의 getClickCount() 메소드를 호출하여 반환된 값(마우스 버튼 클릭 횟수) 이 정수값 1과 같다면(클릭 횟수가 1번) 조건문 실행
						continueDrawing(e.getPoint()); //continueDrawing() 메소드 호출
					}					
					else if(e.getClickCount() == 2){ //MouseEvent 클래스의 getClickCount() 메소드를 호출하여 반환된 값이 정수값 2 (클릭 횟수가2번)와 같다면 조건문 실행
						finishDraw(currentShape); //finishDraw() 메소드 호출 (currentShape 필드 값을 파라미터로 받음)
						currentState = EState.Idle; //currentState 필드의 값을 EState의 Idle로 설정
						repaint(); //repaint() 메소드 호출 (GEDrawingPanel의 모든 도형 컴포넌트들을 다시 그림)
					}
				}						
			}							
		}
	}
}
