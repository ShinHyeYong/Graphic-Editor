package shapes; //package 선언

import java.awt.Point; //외부 클래스 import
import java.awt.Polygon;

public class GEPolygon extends GEShape{ //GEPolygon 클래스 선언 (GEShape 클래스를 상속)
	public GEPolygon(){ //GEPolygon 생성자 선언
		super(new Polygon()); //수퍼 클래스(GEShape) 생성자 호출
	}
	public void initDraw(Point p){ //void 타입 initDraw() 메소드 선언 
		((Polygon) myShape).addPoint(p.x, p.y); //myShape 필드를 Polygon 클래스 타입으로 cast한 뒤 Polygon 클래스의 addPoint 메소드 호출 (Point 클래스 타입, 마우스가 클릭된 시점의 점(p)의 x,y 좌표를 파라미터로 받음)
	}
	public void setCoordinate(Point p){ //void 타입 setCoordinate() 메소드 선언(Point 클래스 타입의 객체를 파라미터로 받음)
		//Point 클래스 타입, 파라미터로 받은 객체(p)의 x,y좌표를 Polygon으로 cast된 myShape필드의 x,y좌표 배열필드의 마지막 index에 각각 저장
		((Polygon) myShape).xpoints[((Polygon) myShape).npoints-1] = p.x;
		((Polygon) myShape).ypoints[((Polygon) myShape).npoints-1] = p.y;
	}
	public void continueDrawing(Point p){ //continueDrawing() 메소드 선언 (Point 클래스 타입의 객체를 파라미터로 받음)
		((Polygon) myShape).addPoint(p.x, p.y); //MyShape필드를 Polygon 클래스로 cast하고 Polygon 클래스의 addPoint() 메소드 호출하여 파라미터로 받은 Point 클래스 타입의 객체(p)를 Polygon 객체에 추가함
	}
	public GEShape clone(){ //GEShape 클래스 타입 clone() 메소드 선언 
		return new GEPolygon(); //GEPolygon 인스턴스를 생성하여 반환
	}
}