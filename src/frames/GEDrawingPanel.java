package frames; //package ����

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPanel; //�ܺ� Ŭ���� import
import javax.swing.event.MouseInputAdapter;

import constants.GEConstants;
import constants.GEConstants.EToolBarButtons;
import shapes.GEEllipse;
import shapes.GELine;
import shapes.GERectangle;

public class GEDrawingPanel extends JPanel { //GEDrawingPanel Ŭ���� ����
	
	private MouseDrawingHandler drawingHandler;	//MouseDrawingHandler Ŭ���� Ÿ�� drawingHandler �ʵ� ����	
	private GERectangle rectangle; //GERectangle Ŭ���� Ÿ�� rectangle �ʵ� ����
	private GELine line; //GELine Ŭ���� Ÿ�� line �ʵ� ����
	private GEEllipse ellipse; //GEEllipse Ŭ���� Ÿ�� ellipse �ʵ� ����
	private EToolBarButtons selectShape; //EToolBarButtons Ŭ���� Ÿ�� selectShape �ʵ� ����
	
	public GEDrawingPanel(){ //GEDrawingPanel ������ ����
		super(); //���� Ŭ����(JPanel) ������ ȣ��
		drawingHandler = new MouseDrawingHandler();	//MouseDrawingHandler Ŭ������ �ν��Ͻ� ����
		addMouseListener(drawingHandler); //MouseListner ���� (MouseDrawingHandler �ν��Ͻ��� �Ķ���ͷ� ����)
		addMouseMotionListener(drawingHandler); //MouseMotionListner ���� (MouseDrawingHandler �ν��Ͻ��� �Ķ���ͷ� ����)
		this.setForeground(GEConstants.FOREGROUND_COLOR); //GEDrawingPanel ���������� ���� (���������� ����� �Ķ���ͷ� ����)
		this.setBackground(GEConstants.BACKGROUND_COLOR); //GEDrawingPanel ���� ���� (���� ����� �Ķ���ͷ� ����)
	}
	public void setRectangle(GERectangle rectangle){ //void Ÿ�� setRectangle() �޼ҵ� ���� (GERectangle Ÿ���� ��ü�� �Ķ���ͷ� ����)
		this.rectangle = rectangle; //�Ķ���ͷ� ���� rectangle ��ü�� rectangle �ʵ忡 ����
	}
	public void setEllipse(GEEllipse ellipse){ //void Ÿ�� setEllipse() �޼ҵ� ���� (GEEllipse Ÿ���� ��ü�� �Ķ���ͷ� ����)		
		this.ellipse = ellipse; //�Ķ���ͷ� ���� ellipse ��ü�� ellipse �ʵ忡 ����	
	}							
	public void setLine(GELine line){ //void Ÿ�� setLine() �޼ҵ� ���� (GELine Ÿ���� ��ü�� �Ķ���ͷ� ����)			
		this.line = line; //�Ķ���ͷ� ���� line ��ü�� line �ʵ忡 ����				
	}							
	public void setSelectShape(EToolBarButtons selectShape){ //void Ÿ�� setSelectShape() �޼ҵ� ���� (EToolBarButtons Ÿ���� ��ü�� �Ķ���ͷ� ����)	
		this.selectShape = selectShape; //�Ķ���ͷ� ���� selectShape ��ü�� selectShape �ʵ忡 ����
	}	
	private void initDraw(Point startP){ //void Ÿ�� initDraw() �޼ҵ� ���� (Point Ÿ��, ������ �������� startP�� �Ķ���ͷ� ����)			
		if(selectShape == EToolBarButtons.Rectangle){ //ToolBar�� Rectangle��ư�� �������� ��� ���ǹ��� ����
			rectangle = new GERectangle(); //GERectangle Ŭ������ �ν��Ͻ� ����
			rectangle.initDraw(startP); //GERectangle�� initDraw() �޼ҵ� ȣ�� (�Ķ���ͷ� ���� startP ��ü�� �Ķ���ͷ� ����)
		}else if(selectShape == EToolBarButtons.Ellipse){ 
			ellipse = new GEEllipse();			
			ellipse.initDraw(startP);			
		}else if(selectShape == EToolBarButtons.Line){	
			line = new GELine();			
			line.initDraw(startP);			
		}

	}
	private void animateDraw(Point currentP){ //void Ÿ�� animateDraw() �޼ҵ� ���� (Point Ÿ��, ������ �������� currentP�� �Ķ���ͷ� ����)
		Graphics2D g2D = (Graphics2D)getGraphics();	//Graphics2D Ÿ�� g2D �ʵ� ���� �� �Ҵ�	
		g2D.setXORMode(g2D.getBackground()); //Graphics2D�� setXORMode() �޼ҵ� ȣ��(Graphics2D�� getBackground() �޼ҵ带 ȣ���Ͽ� ��ȯ�� ���� �Ķ���ͷ� ����)
		if(selectShape == EToolBarButtons.Rectangle){ //ToolBar Ŭ������ Rectangle ��ư�� �������� ��� ���ǹ��� ����
			g2D.draw(rectangle.getRectangle());	//Graphics2D Ŭ������ draw() �޼ҵ� ȣ�� (GERectangle Ŭ������ getRectangle() �޼ҵ带 ȣ���Ͽ� ��ȯ�� ���� �Ķ���ͷ� ����)
			rectangle.setCoordinate(currentP); //GERectangle Ŭ������ setCoordibate() �޼ҵ带 ȣ�� (currentP�� �Ķ���ͷ� ����)	
			g2D.draw(rectangle.getRectangle());	//Graphics2D Ŭ������ draw() �޼ҵ� ȣ�� (GERectangle Ŭ������ getRectangle() �޼ҵ带 ȣ���Ͽ� ��ȯ�� ���� �Ķ���ͷ� ����)
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
	private class MouseDrawingHandler extends MouseInputAdapter{ //MouseDrawingHandler ���� Ŭ���� ���� (implements MouseInputAdapter interface)
		public void mousePressed(MouseEvent e){	//void Ÿ��, mousePressed() �޼ҵ� ���� (MouseInputAdapter interface�� mousePressed() �޼ҵ� �������̵�. MouseEvent Ÿ���� ��ü�� �Ķ���ͷ� ����)
			initDraw(e.getPoint()); //initDraw() �޼ҵ� ȣ�� (MouseEvent�� getPoint() �޼ҵ带 ȣ���Ͽ� ��ȯ�� ��(���콺�� ������ �� ���콺 Ŀ���� ��ǥ)�� �Ķ���ͷ� ����)
		}							
		public void mouseDragged(MouseEvent e){	// void Ÿ��, mouseDragged() �޼ҵ� ����(MouseInputAdapter interface�� mouseDragged() �޼ҵ� �������̵�. MouseEvent Ÿ���� ��ü�� �Ķ���ͷ� ����)
			animateDraw(e.getPoint()); //animateDraw() �޼ҵ� ȣ��(MouseEvent�� getPoint() �޼ҵ带 ȣ���Ͽ� ��ȯ�� ��(���콺�� �巡�� �� �� ���콺 Ŀ���� ��ǥ�� �Ķ���ͷ� ����)
		}
	}
}
