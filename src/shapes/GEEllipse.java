package shapes; //package ����

import java.awt.Point; //�ܺ� Ŭ���� import
import java.awt.geom.Ellipse2D;

public class GEEllipse extends GEShape{ //GEEllipse Ŭ���� ���� (GEShape Ŭ������ ���)	
	public GEEllipse(){ //GEEllipse ������ ����
		super(new Ellipse2D.Double()); //���� Ŭ����(GEShape) ������ ȣ�� (Ellipse2D.Double Ŭ������ �ν��Ͻ��� �����Ͽ� ������ �ν��Ͻ��� �Ķ���ͷ� ����)
	}
	public void initDraw(Point startP){ //void Ÿ�� initDraw() �޼ҵ� ���� (Point Ŭ���� Ÿ��, ������ ������(startP)�� �Ķ���ͷ� ����)
		this.startP = startP; //�Ķ���ͷ� �Ѿ�� startP�� startP �ʵ忡 ����
	}
	public void setCoordinate(Point currentP){ //void Ÿ�� setCoordinate() �޼ҵ� ����
		Ellipse2D tempEllipse = (Ellipse2D)myShape; //myShape �ʵ带 Ellipse2D Ŭ���� Ÿ������ ĳ���� �� Rectangle Ŭ���� Ÿ�� tempRectangle ������ ����
		tempEllipse.setFrameFromDiagonal(startP.x, startP.y, currentP.x,  currentP.y); //Ellipse2D Ŭ������ setFrameFromDiagonal() �޼ҵ� ȣ��. tempRectangle ������ �������� �����ϴ� �ڽ�ũ�⸦ ����
	}
	public GEShape clone(){	//GEShape Ŭ���� Ÿ���� clone() �޼ҵ� ����		
		return new GEEllipse();	//GEEllipse Ŭ������ �ν��Ͻ��� �����Ͽ� ����
	}
}
