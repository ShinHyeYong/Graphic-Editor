package shapes; //package ����

import java.awt.Point; //�ܺ� Ŭ���� import
import java.awt.Polygon;

public class GEPolygon extends GEShape{ //GEPolygon Ŭ���� ���� (GEShape Ŭ������ ���)
	public GEPolygon(){ //GEPolygon ������ ����
		super(new Polygon()); //���� Ŭ����(GEShape) ������ ȣ��
	}
	public void initDraw(Point p){ //void Ÿ�� initDraw() �޼ҵ� ���� 
		((Polygon) myShape).addPoint(p.x, p.y); //myShape �ʵ带 Polygon Ŭ���� Ÿ������ cast�� �� Polygon Ŭ������ addPoint �޼ҵ� ȣ�� (Point Ŭ���� Ÿ��, ���콺�� Ŭ���� ������ ��(p)�� x,y ��ǥ�� �Ķ���ͷ� ����)
	}
	public void setCoordinate(Point p){ //void Ÿ�� setCoordinate() �޼ҵ� ����(Point Ŭ���� Ÿ���� ��ü�� �Ķ���ͷ� ����)
		//Point Ŭ���� Ÿ��, �Ķ���ͷ� ���� ��ü(p)�� x,y��ǥ�� Polygon���� cast�� myShape�ʵ��� x,y��ǥ �迭�ʵ��� ������ index�� ���� ����
		((Polygon) myShape).xpoints[((Polygon) myShape).npoints-1] = p.x;
		((Polygon) myShape).ypoints[((Polygon) myShape).npoints-1] = p.y;
	}
	public void continueDrawing(Point p){ //continueDrawing() �޼ҵ� ���� (Point Ŭ���� Ÿ���� ��ü�� �Ķ���ͷ� ����)
		((Polygon) myShape).addPoint(p.x, p.y); //MyShape�ʵ带 Polygon Ŭ������ cast�ϰ� Polygon Ŭ������ addPoint() �޼ҵ� ȣ���Ͽ� �Ķ���ͷ� ���� Point Ŭ���� Ÿ���� ��ü(p)�� Polygon ��ü�� �߰���
	}
	public GEShape clone(){ //GEShape Ŭ���� Ÿ�� clone() �޼ҵ� ���� 
		return new GEPolygon(); //GEPolygon �ν��Ͻ��� �����Ͽ� ��ȯ
	}
}