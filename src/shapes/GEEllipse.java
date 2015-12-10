package shapes; //package ����

import java.awt.Point; //�ܺ� Ŭ���� import
import java.awt.geom.Ellipse2D;

public class GEEllipse { //GEEllipse Ŭ���� ����
	private Point startP; //Point Ŭ���� Ÿ�� startP(������ ������)�ʵ� ����
	private Ellipse2D ellipse; //Ellipse2D Ŭ���� Ÿ�� ellipse �ʵ� ����
	public GEEllipse(){ //GEEllipse ������ ����
		ellipse = new Ellipse2D.Double(); //Ellipse2D.Double Ŭ������ �ν��Ͻ� ����
	}
	public void initDraw(Point startP){ //void Ÿ�� initDraw() �޼ҵ� ���� (Ÿ���� Point Ŭ���� Ÿ��, ������ ������(startP)�� �Ķ���ͷ� ����)
		this.startP = startP; //�Ķ���ͷ� �Ѿ�� startP�� startP �ʵ忡 ����
	}
	public void setCoordinate(Point currentP){ //void Ÿ�� setCoordinate() �޼ҵ� ���� (Ÿ���� Point Ŭ���� Ÿ��, ���콺�� ������ ������ ���� ��(currentP)�� �Ķ���ͷ� ����)
		ellipse.setFrame(startP.x, startP.y, currentP.x-startP.x,currentP.y-startP.y); //ellipse �ʵ�(�׷����� Ÿ��)�� �������� ������ �ڽ�ũ�⸦ ����
	}
	public Ellipse2D getEllipse(){ //Ellipse2D Ŭ���� Ÿ�� getEllipse() �޼ҵ� ����(getMethod) (ellipse �ʵ��� ���� ��ȯ)
		return ellipse;
	}
}
