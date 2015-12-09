package shapes; //package ����

import java.awt.Point; //�ܺ� Ŭ���� import
import java.awt.Rectangle;
import java.awt.Shape;

public class GERectangle { //GERectangle Ŭ���� ����
		
	private Point startP; //Point Ŭ���� Ÿ�� startP(������ ������)�ʵ� ����
	private Rectangle rectangle; //Rectangle Ŭ���� Ÿ�� rectangle �ʵ� ���� 	
	
	public GERectangle(){ //GERectangle ������ ����
		rectangle = new Rectangle(); //GERectangle ������ ����
		}
	
	public void initDraw(Point startP) { //void Ÿ�� initDraw() method ���� (Ÿ���� Point Ŭ���� Ÿ��, ������ �������� �Ķ���ͷ� ����)
		this.startP = startP; //�Ķ���ͷ� �Ѿ�� startP�� startP �ʵ忡 ����
	}

	public Rectangle getRectangle() { //Rectangle Ŭ���� Ÿ�� getRectangle() �޼ҵ� ����(getMethod) (���ϰ����� rectangle �ʵ��� ���� �Ѱ��ش�.)
		return rectangle;
	}

	public void setCoordinate(Point currentP) { //void Ÿ�� setCoordinate() �޼ҵ� ���� (Ÿ���� Point Ŭ���� Ÿ��, ���콺�� ������ ������ ���� ���� �Ķ���ͷ� ����)
		rectangle.setFrame(startP.x, startP.y,currentP.x-startP.x,currentP.y-startP.y); //rectangle �ʵ�(�׷����� �簢��)�� �������� ���� (�Ķ���ͷ� �� ó�� ������ �׸��� ������ startP�� x,y ��ǥ�� ������ ��ǥ(currentP)�� ó��������(StartP)�� x,y��ǥ�� ��(x����:width, y����:height)�� ����)
	}
}
