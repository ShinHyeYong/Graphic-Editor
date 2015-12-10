package shapes; //package ����

import java.awt.Graphics2D; //�ܺ� Ŭ���� import
import java.awt.Point;
import java.awt.Shape;

public abstract class GEShape{ //GEShape �߻�Ŭ���� ����
	protected Shape myShape; //Shape Ŭ���� Ÿ�� myShape �ʵ� ���� (���ü��� protected)
	protected Point startP; //Point Ŭ���� Ÿ�� startP(������ ������)�ʵ� ���� (���ü��� protected)
	
	public GEShape(Shape shape){ //GEShape ������ ���� (Shape Ŭ���� Ÿ�� shape ��ü�� �Ķ���ͷ� ����)
		this.myShape = shape; //�Ķ���ͷ� ���� shape ��ü�� myShape �ʵ忡 ����
	}
	
	public void draw(Graphics2D g2D){ //void Ÿ�� draw() �޼ҵ� ���� (Graphics2D Ŭ���� Ÿ�� g2D ��ü�� �Ķ���ͷ� ����)
		g2D.draw(myShape); //Graphics2D Ŭ������ draw() �޼ҵ带 ȣ��
	}
	
	abstract public void initDraw(Point startP); //void Ÿ�� initDraw() �߻�޼ҵ� ���� (Ÿ���� Point Ŭ���� Ÿ��, ������ ������(startP)�� �Ķ���ͷ� ����
	abstract public void setCoordinate(Point currentP); // void Ÿ�� setCoordinate() �߻�޼ҵ� ���� (Ÿ���� Point Ŭ���� Ÿ��, ���콺�� ������ ������ ���� ��(currentP)�� �Ķ���ͷ� ����)
	abstract public GEShape clone(); //GEShape Ŭ���� Ÿ�� clone() �߻�޼ҵ� ����
}
