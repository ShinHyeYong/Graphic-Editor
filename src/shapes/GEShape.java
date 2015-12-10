package shapes; //package 선언

import java.awt.Graphics2D; //외부 클래스 import
import java.awt.Point;
import java.awt.Shape;

public abstract class GEShape{ //GEShape 추상클래스 선언
	protected Shape myShape; //Shape 클래스 타입 myShape 필드 선언 (가시성은 protected)
	protected Point startP; //Point 클래스 타입 startP(도형의 시작점)필드 선언 (가시성은 protected)
	
	public GEShape(Shape shape){ //GEShape 생성자 선언 (Shape 클래스 타입 shape 객체를 파라미터로 받음)
		this.myShape = shape; //파라미터로 받은 shape 객체를 myShape 필드에 저장
	}
	
	public void draw(Graphics2D g2D){ //void 타입 draw() 메소드 선언 (Graphics2D 클래스 타입 g2D 객체를 파라미터로 받음)
		g2D.draw(myShape); //Graphics2D 클래스의 draw() 메소드를 호출
	}
	
	abstract public void initDraw(Point startP); //void 타입 initDraw() 추상메소드 선언 (타입은 Point 클래스 타입, 도형의 시작점(startP)를 파라미터로 받음
	abstract public void setCoordinate(Point currentP); // void 타입 setCoordinate() 추상메소드 선언 (타입은 Point 클래스 타입, 마우스가 눌러진 상태의 현재 점(currentP)을 파라미터로 받음)
	abstract public GEShape clone(); //GEShape 클래스 타입 clone() 추상메소드 선언
}
