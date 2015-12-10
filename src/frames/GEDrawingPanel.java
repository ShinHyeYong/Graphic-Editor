package frames; //package ����

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel; //�ܺ� Ŭ���� import
import javax.swing.event.MouseInputAdapter;

import constants.GEConstants;
import shapes.GEShape;

public class GEDrawingPanel extends JPanel { //GEDrawingPanel Ŭ���� ����
	
	private MouseDrawingHandler drawingHandler;	//MouseDrawingHandler Ŭ���� Ÿ�� drawingHandler �ʵ� ����	
	private GEShape currentShape; //GEShape Ŭ���� Ÿ�� currentShape �ʵ� ����
	private ArrayList<GEShape> shapeList;//ArrayList Ŭ���� Ÿ�� (arrayitem Ÿ���� GEShape) shapeList ����
	
	public GEDrawingPanel(){ //GEDrawingPanel ������ ����
		super(); //���� Ŭ����(JPanel) ������ ȣ��
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
	public void finishDraw(GEShape shape){ //void Ÿ�� finishDraw() �޼ҵ� ���� (GEShape Ŭ���� Ÿ�� ��ü�� �Ķ���ͷ� ����)
		shapeList.add(shape); //ArrayList Ŭ������ add() �޼ҵ� ȣ�� (�Ķ���ͷ� ���� ��ü�� shapeList �ʵ忡 ����)
	}
	private class MouseDrawingHandler extends MouseInputAdapter{ //MouseDrawingHandler ���� Ŭ���� ���� (implements MouseInputAdapter interface)
		public void mousePressed(MouseEvent e){	//void Ÿ��, mousePressed() �޼ҵ� ���� (MouseInputAdapter interface�� mousePressed() �޼ҵ� �������̵�. MouseEvent Ÿ���� ��ü�� �Ķ���ͷ� ����)
			initDraw(e.getPoint()); //initDraw() �޼ҵ� ȣ�� (MouseEvent�� getPoint() �޼ҵ带 ȣ���Ͽ� ��ȯ�� ��(���콺�� ������ �� ���콺 Ŀ���� ��ǥ)�� �Ķ���ͷ� ����)
		}							
		public void mouseDragged(MouseEvent e){	// void Ÿ��, mouseDragged() �޼ҵ� ����(MouseInputAdapter interface�� mouseDragged() �޼ҵ� �������̵�. MouseEvent Ÿ���� ��ü�� �Ķ���ͷ� ����)
			animateDraw(e.getPoint()); //animateDraw() �޼ҵ� ȣ��(MouseEvent�� getPoint() �޼ҵ带 ȣ���Ͽ� ��ȯ�� ��(���콺�� �巡�� �� �� ���콺 Ŀ���� ��ǥ�� �Ķ���ͷ� ����)
		}
		public void mouseReleased(MouseEvent e){ //void Ÿ�� mouseReleased() �޼ҵ� ȣ��
			finishDraw(currentShape); //finishDraw() �޼ҵ� ȣ�� (currentSahep �ʵ带 �Ķ���ͷ� ����)
		}
	}
}
