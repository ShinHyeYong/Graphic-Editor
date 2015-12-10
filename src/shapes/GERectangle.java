package shapes; //package 선언

import java.awt.Point; //외부 클래스 import
import java.awt.Rectangle;

public class GERectangle extends GEShape{ //GERectangle 클래스 선언 (GEShape 클래스를 상속)
	public GERectangle(){ //GERectangle 생성자 선언
		super(new Rectangle()); //수퍼 클래스(GEShape) 생성자 호출 (Rectangle 클래스의 인스턴스를 생성하여 생성된 인스턴스를 파라미터로 받음)
	}
	public void initDraw(Point startP){ //void 타입 initDraw() 메소드 선언  (Point 클래스 타입, 도형의 시작점(startP)을 파라미터로 받음)
		this.startP = startP; //파라미터로 넘어온 startP를 startP 필드에 저장
	}
	public void setCoordinate(Point currentP){ //void 타입 setCoordinate() 메소드 선언
		Rectangle tempRectangle = (Rectangle)myShape; //myShape 필드를 Rectangle 클래스 타입으로 캐스팅 후 Rectangle 클래스 타입 tempRectangle 변수에 저장		
		tempRectangle.setFrameFromDiagonal(startP.x, startP.y, currentP.x, currentP.y); //Rectangle 클래스의 setFrameFromDiagonal() 메소드 호출. tempRectangle 도형의 윤곽선에 인접하는 박스크기를 설정
	}
	public GERectangle clone(){ //GERectangle 클래스 타입의 clone() 메소드 선언
		return new GERectangle(); //GERectangle 클래스의 인스턴스를 생성하여 리턴
	}
}
