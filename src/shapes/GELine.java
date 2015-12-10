package shapes; //package ����

import java.awt.Point; //�ܺ� Ŭ���� import
import java.awt.geom.Line2D;

public class GELine { //GELine Ŭ���� ����
	private Point startP; //Point Ŭ���� Ÿ�� startP(������ ������)�ʵ� ����
	private Line2D line; //Line2D Ŭ���� Ÿ�� line �ʵ� ����
	
	public GELine(){ //GELine ������ ����
		line = new Line2D.Double(); //Line2D.Double Ŭ������ �ν��Ͻ� ����
	}	
	public void initDraw(Point startP){ //void Ÿ�� initDraw() �޼ҵ� ����
		this.startP = startP; //�Ķ���ͷ� �Ѿ�� startP�� startP �ʵ忡 ����
	}	
	public void setCoordinate(Point currentP){ //void Ÿ�� setCoordinate() �޼ҵ� ����
		line.setLine(startP.x, startP.y, currentP.x,  currentP.y); //line �ʵ�(�׷����� ����)�� �������� �밢������ �ϴ� �ڽ�ũ�⸦ ����
	}
	public Line2D getLine() { //Line2D Ŭ���� Ÿ�� getLine() �޼ҵ� ����(getMethod)
		return line; 
	}
}
