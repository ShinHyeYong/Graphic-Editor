package frames; //package ����

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPanel; //�ܺ� Ŭ���� import
import javax.swing.event.MouseInputAdapter;

import constants.GEConstants;
import shapes.GERectangle;

public class GEDrawingPanel extends JPanel { //GEDrawingPanel Ŭ���� ����
	
	private MouseDrawingHandler drawingHandler;	//MouseDrawingHandler Ŭ���� Ÿ�� drawingHandler �ʵ� ����	
	private GERectangle rectangle; //GERectangle Ŭ���� Ÿ�� rectangle �ʵ� ����
	
	public GEDrawingPanel(){ //GEDrawingPanel ������ ����
		super(); //���� Ŭ����(JPanel) ������ ȣ��
		drawingHandler = new MouseDrawingHandler();	//MouseDrawingHandler Ŭ������ �ν��Ͻ� ����
		addMouseListener(drawingHandler); //MouseListner ���� (MouseDrawingHandler �ν��Ͻ��� �Ķ���ͷ� ����)
		addMouseMotionListener(drawingHandler); //MouseMotionListner ���� (MouseDrawingHandler �ν��Ͻ��� �Ķ���ͷ� ����)
		this.setForeground(GEConstants.FOREGROUND_COLOR); //GEDrawingPanel ���������� ���� (���������� ����� �Ķ���ͷ� ����)
		this.setBackground(GEConstants.BACKGROUND_COLOR); //GEDrawingPanel ���� ���� (���� ����� �Ķ���ͷ� ����)
	}
	private void initDraw(Point originP){ //void Ÿ�� initDraw() �޼ҵ� ���� (Point Ÿ��, ������ �������� originP�� �Ķ���ͷ� ����)			
		rectangle = new GERectangle(); //GERectangle Ŭ������ �ν��Ͻ� ����			
		rectangle.initDraw(originP); //GERectangle�� initDraw() �޼ҵ� ȣ�� (originP�� �Ķ���ͷ� ����)
	}
	private void animateDraw(Point currentP){ //void Ÿ�� animateDraw() �޼ҵ� ���� (Point Ÿ��, ������ �������� currentP�� �Ķ���ͷ� ����)
		Graphics2D g2D = (Graphics2D)getGraphics();		
		g2D.setXORMode(g2D.getBackground()); //Graphics2D�� setXORMode() �޼ҵ� ȣ��(Graphics2D�� getBackground() �޼ҵ带 ȣ���Ͽ� ��ȯ�� ���� �Ķ���ͷ� ����)
		g2D.draw(rectangle.getRectangle());	//Graphics2D�� draw() �޼ҵ� ȣ��(GERectangle�� getRectangle() �޼ҵ带 ȣ���Ͽ� ��ȯ�� ���� �Ķ���ͷ� ����)
		rectangle.setCoordinate(currentP); //GERectangle�� setCoordibate() �޼ҵ带 ȣ��(currentP�� �Ķ���ͷ� ����)	
		g2D.draw(rectangle.getRectangle());	//Graphics2D�� draw() �޼ҵ� ȣ��(GERectangle�� getRectangle() �޼ҵ带 ȣ���Ͽ� ��ȯ�� ���� �Ķ���ͷ� ����)
		
	}	
	private class MouseDrawingHandler extends MouseInputAdapter{ //MouseDrawingHandler ���� Ŭ���� ���� (implements MouseInputAdapter interface)
		public void mousePressed(MouseEvent e){	//void Ÿ��, mousePressed() �޼ҵ� ���� (MouseInputAdapter interface�� mousePressed() �޼ҵ� �������̵�. MouseEvent Ÿ���� ��ü�� �Ķ���ͷ� ����)
			initDraw(e.getPoint()); //initDraw() �޼ҵ� ȣ�� (MouseEvent�� getPoint() �޼ҵ带 ȣ���Ͽ� ��ȯ�� ��(���콺�� ������ �� ���콺 Ŀ���� ��ǥ)�� �Ķ���ͷ� ����)
		}							
		public void mouseDragged(MouseEvent e){	// void Ÿ��, mouseDragged() �޼ҵ� ����(MouseInputAdapter interface�� mouseDragged() �޼ҵ� �������̵�. MouseEvent Ÿ���� ��ü�� �Ķ���ͷ� ����)
			animateDraw(e.getPoint()); //animateDraw() �޼ҵ� ȣ��(MouseEvent�� getPoint() �޼ҵ带 ȣ���Ͽ� ��ȯ�� ��(���콺�� �巡�� �� �� ���콺 Ŀ���� ��ǥ�� �Ķ���ͷ� ����)
		}
	}
}
