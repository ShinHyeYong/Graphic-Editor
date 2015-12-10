package shapes; //package ����

import java.awt.Point; //�ܺ� Ŭ���� import
import java.awt.Rectangle;

public class GERectangle extends GEShape{ //GERectangle Ŭ���� ���� (GEShape Ŭ������ ���)
	public GERectangle(){ //GERectangle ������ ����
		super(new Rectangle()); //���� Ŭ����(GEShape) ������ ȣ�� (Rectangle Ŭ������ �ν��Ͻ��� �����Ͽ� ������ �ν��Ͻ��� �Ķ���ͷ� ����)
	}
	public void initDraw(Point startP){ //void Ÿ�� initDraw() �޼ҵ� ����  (Point Ŭ���� Ÿ��, ������ ������(startP)�� �Ķ���ͷ� ����)
		this.startP = startP; //�Ķ���ͷ� �Ѿ�� startP�� startP �ʵ忡 ����
	}
	public void setCoordinate(Point currentP){ //void Ÿ�� setCoordinate() �޼ҵ� ����
		Rectangle tempRectangle = (Rectangle)myShape; //myShape �ʵ带 Rectangle Ŭ���� Ÿ������ ĳ���� �� Rectangle Ŭ���� Ÿ�� tempRectangle ������ ����		
		tempRectangle.setFrameFromDiagonal(startP.x, startP.y, currentP.x, currentP.y); //Rectangle Ŭ������ setFrameFromDiagonal() �޼ҵ� ȣ��. tempRectangle ������ �������� �����ϴ� �ڽ�ũ�⸦ ����
	}
	public GERectangle clone(){ //GERectangle Ŭ���� Ÿ���� clone() �޼ҵ� ����
		return new GERectangle(); //GERectangle Ŭ������ �ν��Ͻ��� �����Ͽ� ����
	}
}
