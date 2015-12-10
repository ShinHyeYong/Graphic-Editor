package shapes; //package ����

import java.awt.Point; //�ܺ� Ŭ���� import
import java.awt.geom.Line2D;

public class GELine extends GEShape{ //GELine Ŭ���� ���� (GEShape Ŭ������ ���)	
	public GELine(){ //GELine ������ ����
		super(new Line2D.Double());	//���� Ŭ����(GEShape) ������ ȣ��
	}
	public void initDraw(Point startP){ //void Ÿ�� initDraw() �޼ҵ� ����
		this.startP = startP; //�Ķ���ͷ� �Ѿ�� startP�� startP �ʵ忡 ����
	}
	public void setCoordinate(Point currentP){ //void Ÿ�� setCoordinate() �޼ҵ� ����
		Line2D tempLine = (Line2D)myShape; //myShape �ʵ带 Line2D Ŭ���� Ÿ������ ĳ���� �� Line2D Ŭ���� Ÿ�� tempLine ������ ����
		tempLine.setLine(startP.x, startP.y, currentP.x,  currentP.y); //Line2D Ŭ������ setLine() �޼ҵ� ȣ��. tempLine ������ �������� �밢������ �ϴ� �ڽ�ũ�⸦ ����
	}
}
