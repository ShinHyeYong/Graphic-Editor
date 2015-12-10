package frames; //package ����

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel; //�ܺ� Ŭ���� import
import javax.swing.event.MouseInputAdapter;

import constants.GEConstants;
import constants.GEConstants.EState;
import shapes.GEPolygon;
import shapes.GEShape;

public class GEDrawingPanel extends JPanel { //GEDrawingPanel Ŭ���� ����
	
	private MouseDrawingHandler drawingHandler;	//MouseDrawingHandler Ŭ���� Ÿ�� drawingHandler �ʵ� ����	
	private GEShape currentShape; //GEShape Ŭ���� Ÿ�� currentShape �ʵ� ����
	private ArrayList<GEShape> shapeList;//ArrayList Ŭ���� Ÿ�� (arrayitem Ÿ���� GEShape) shapeList ����
	private EState currentState; //EState Ÿ�� currentState �ʵ� ����
	
	public GEDrawingPanel(){ //GEDrawingPanel ������ ����
		super(); //���� Ŭ����(JPanel) ������ ȣ��
		currentState = EState.Idle; //: currentState�ʵ忡 �׸��� ���¸� Idle�� �����Ͽ� ����
		shapeList = new ArrayList<GEShape>(); //: ArrayList Ŭ������ �ν��Ͻ� ����
		drawingHandler = new MouseDrawingHandler();	//MouseDrawingHandler Ŭ������ �ν��Ͻ� ����
		addMouseListener(drawingHandler); //MouseListner ���� (MouseDrawingHandler �ν��Ͻ��� �Ķ���ͷ� ����)
		addMouseMotionListener(drawingHandler); //MouseMotionListner ���� (MouseDrawingHandler �ν��Ͻ��� �Ķ���ͷ� ����)
		this.setForeground(GEConstants.FOREGROUND_COLOR); //GEDrawingPanel ���������� ���� (���������� ����� �Ķ���ͷ� ����)
		this.setBackground(GEConstants.BACKGROUND_COLOR); //GEDrawingPanel ���� ���� (���� ����� �Ķ���ͷ� ����)
	}
	public void setCurrentShape(GEShape currentShape){ //void Ÿ�� setCurrentShape() �޼ҵ� ���� (���� ���õ� ������ GEShape Ÿ�� currentShape ��ü�� �Ķ���ͷ� ����)
		this.currentShape = currentShape; //�Ķ���ͷ� ���� currentShape ��ü�� currentShape �ʵ忡 ����
	}	
	public void paintComponent(Graphics g){ //void Ÿ�� paintComponent() �޼ҵ� ���� (Grapchis Ŭ���� ��ü�� �Ķ���ͷ� ����)
		super.paintComponent(g); //���� Ŭ������ paintComponent()�޼ҵ� ȣ�� (���� Graphics Ŭ���� ��ü�� �Ķ���ͷ� ����)
		Graphics2D g2D = (Graphics2D)g; //Graphics2D Ŭ���� Ÿ�� ���� g2D ���� �� �Ҵ� (�Ķ���ͷ� ���� Graphics Ŭ���� ��ü�� Graphics2D�� downcast�Ͽ� �Ҵ�)
		for(GEShape shape : shapeList){ //shapeList �ʵ忡 ����� GEShape Ŭ���� Ÿ�� ��ü���� drawingPanel�� �׷��ֱ� ���� Ȯ��for�� ���� (shapeList �ʵ忡 ����� ��ü ����ŭ �ݺ�)
			shape.draw(g2D); //Graphics2D Ŭ������ draw() �޼ҵ� ȣ��
		}
	}
	private void initDraw(Point startP){ //void Ÿ�� initDraw() �޼ҵ� ���� (Point Ÿ��, ������ �������� startP�� �Ķ���ͷ� ����)			
		currentShape = currentShape.clone(); //GEShape Ŭ������ clone() �޼ҵ带 ȣ���Ͽ� ���ϵ� ���� currentShape �ʵ忡 ����
		currentShape.initDraw(startP); //GEShape Ŭ������ iniDraw() �޼ҵ带 ȣ�� (�Ķ���ͷ� ���� startP ��ü�� �Ķ���ͷ� ����)
	}
	private void animateDraw(Point currentP){ //void Ÿ�� animateDraw() �޼ҵ� ���� (Point Ÿ��, ������ �������� currentP�� �Ķ���ͷ� ����)
		Graphics2D g2D = (Graphics2D)getGraphics();	//Graphics2D Ÿ�� g2D �ʵ� ���� �� �Ҵ�	
		g2D.setXORMode(g2D.getBackground()); //Graphics2D�� setXORMode() �޼ҵ� ȣ��(Graphics2D�� getBackground() �޼ҵ带 ȣ���Ͽ� ��ȯ�� ���� �Ķ���ͷ� ����)
		currentShape.draw(g2D); //Graphics2D Ŭ������ draw() �޼ҵ� ȣ��
		currentShape.setCoordinate(currentP); //GEShape�� setCoordibate() �޼ҵ带 ȣ�� (currentP�� �Ķ���ͷ� ����)
		currentShape.draw(g2D); //Graphics2D�� draw() �޼ҵ� ȣ��
	}	
	public void continueDrawing(Point p){ //void Ÿ�� continueDrawing() �޼ҵ� ���� (Point Ŭ���� Ÿ�� ��ü�� �Ķ���ͷ� ����)
		((GEPolygon)currentShape).continueDrawing(p); //getCurrentShape() �޼ҵ带 ȣ���Ͽ� ��ȯ�� ���� GEPolygon Ŭ���� Ÿ������ cast�� ��  GEPolygon�� continueDrawing() �޼ҵ� ȣ��. (���� Point Ŭ���� Ÿ�� ��ü�� �Ķ���ͷ� ����)
	}
	public void finishDraw(GEShape shape){ //void Ÿ�� finishDraw() �޼ҵ� ���� (GEShape Ŭ���� Ÿ�� ��ü�� �Ķ���ͷ� ����)
		shapeList.add(shape); //ArrayList Ŭ������ add() �޼ҵ� ȣ�� (�Ķ���ͷ� ���� ��ü�� shapeList �ʵ忡 ����)
		currentState = EState.Idle; //setCurrentState() �޼ҵ� ȣ�� (�׸�����¸� Idle�� ����)
		repaint(); //repaint() �޼ҵ� ȣ�� (GEDrawingPanel�� ��� ���� ������Ʈ���� �ٽ� �׸�)
	}
	private class MouseDrawingHandler extends MouseInputAdapter{ //MouseDrawingHandler ���� Ŭ���� ���� (implements MouseInputAdapter interface)
		public void mousePressed(MouseEvent e){	//void Ÿ��, mousePressed() �޼ҵ� ���� (MouseInputAdapter interface�� mousePressed() �޼ҵ� �������̵�. MouseEvent Ÿ���� ��ü�� �Ķ���ͷ� ����)
			if(currentState  == EState.Idle){ //currentState �ʵ尪�� Estate�� Idle ���� ���ٸ� ���ǹ� ����
				initDraw(e.getPoint());	//initDraw() �޼ҵ� ȣ��
				if(currentShape instanceof GEPolygon){ //currentShape �ʵ��� ���� GEPolygon���� �����Ǿ� ���� ��� ���ǹ� ����
					currentState = EState.NPointsDrawing; //currentState �ʵ��� ���� ESate�� NPointsDrawing���� ����
				}else{ //currentShape �ʵ��� ���� GEPolygon���� �����Ǿ� ���� ���� ��� ���ǹ� ����
					currentState = EState.TwoPointsDrawing; //currentState �ʵ��� ���� EState�� TwoPointsDrawing���� ����
					}
				}
			}
		public void mouseMoved(MouseEvent e){ //void Ÿ�� mouseMoved() �޼ҵ� ����		
			if(currentState == EState.NPointsDrawing){ //currentState �ʵ��� ���� �׸��� ���� ���(EState)�� NPointsDrawing ���� ���ٸ� ���ǹ� ����		
				animateDraw(e.getPoint()); //animateDraw() �޼ҵ� ȣ�� 
			}	
		}
		public void mouseDragged(MouseEvent e){	// void Ÿ��, mouseDragged() �޼ҵ� ����(MouseInputAdapter interface�� mouseDragged() �޼ҵ� �������̵�. MouseEvent Ÿ���� ��ü�� �Ķ���ͷ� ����)
			if (currentState != EState.Idle){ //currentState �ʵ��� ���� Estate�� Idle ���� ���� �ʴٸ� ���ǹ� ����
				animateDraw(e.getPoint()); //animateDraw() �޼ҵ� ȣ��
				}
			}
		public void mouseReleased(MouseEvent e){ //void Ÿ�� mouseReleased() �޼ҵ� ȣ��
			if(currentState == EState.TwoPointsDrawing){ //currentState �ʵ��� ���� EState�� TwoPointsDrawing ���� ���ٸ� ���ǹ� ����
				finishDraw(currentShape); //finishDraw() �޼ҵ� ȣ�� (currentShape �ʵ带 �Ķ���ͷ� ����)
				}
			}
		public void mouseClicked(MouseEvent e){ //void Ÿ�� mouseClicked() �޼ҵ� ����
			if(e.getButton() == MouseEvent.BUTTON1){ //: MouseEvent Ŭ������ getPoint() �޼ҵ带 ȣ���Ͽ� ��ȯ�� ��(Ŭ���� ���콺 ��ư)�� MouseEvent Ŭ������ BUTTON1 ��� ��(���콺 ���ʹ�ư Ŭ��)�� ���ٸ� ���ǹ� ����
				if(currentState == EState.NPointsDrawing){ //currentState �ʵ��� ���� EState�� NPointDrawing ���� ���ٸ� ���ǹ� ����
					if(e.getClickCount() == 1){ //MouseEvent Ŭ������ getClickCount() �޼ҵ带 ȣ���Ͽ� ��ȯ�� ��(���콺 ��ư Ŭ�� Ƚ��) �� ������ 1�� ���ٸ�(Ŭ�� Ƚ���� 1��) ���ǹ� ����
						continueDrawing(e.getPoint()); //continueDrawing() �޼ҵ� ȣ��
					}					
					else if(e.getClickCount() == 2){ //MouseEvent Ŭ������ getClickCount() �޼ҵ带 ȣ���Ͽ� ��ȯ�� ���� ������ 2 (Ŭ�� Ƚ����2��)�� ���ٸ� ���ǹ� ����
						finishDraw(currentShape); //finishDraw() �޼ҵ� ȣ�� (currentShape �ʵ� ���� �Ķ���ͷ� ����)
						currentState = EState.Idle; //currentState �ʵ��� ���� EState�� Idle�� ����
						repaint(); //repaint() �޼ҵ� ȣ�� (GEDrawingPanel�� ��� ���� ������Ʈ���� �ٽ� �׸�)
					}
				}						
			}							
		}
	}
}
