package shapes; //package 선언

import java.awt.Point; //외부 클래스 import
import java.awt.geom.Ellipse2D;

public class GEEllipse extends GEShape{ //GEEllipse 클래스 선언 (GEShape 클래스를 상속)	
	public GEEllipse(){ //GEEllipse 생성자 선언
		super(new Ellipse2D.Double()); //수퍼 클래스(GEShape) 생성자 호출 (Ellipse2D.Double 클래스의 인스턴스를 생성하여 생성된 인스턴스를 파라미터로 받음)
	}
	public void initDraw(Point startP){ //void 타입 initDraw() 메소드 선언 (Point 클래스 타입, 도형의 시작점(startP)을 파라미터로 받음)
		this.startP = startP; //파라미터로 넘어온 startP를 startP 필드에 저장
	}
	public void setCoordinate(Point currentP){ //void 타입 setCoordinate() 메소드 선언
		Ellipse2D tempEllipse = (Ellipse2D)myShape; //myShape 필드를 Ellipse2D 클래스 타입으로 캐스팅 후 Rectangle 클래스 타입 tempRectangle 변수에 저장
		tempEllipse.setFrameFromDiagonal(startP.x, startP.y, currentP.x,  currentP.y); //Ellipse2D 클래스의 setFrameFromDiagonal() 메소드 호출. tempRectangle 도형의 윤곽선에 인접하는 박스크기를 설정
	}
	public GEShape clone(){	//GEShape 클래스 타입의 clone() 메소드 선언		
		return new GEEllipse();	//GEEllipse 클래스의 인스턴스를 생성하여 리턴
	}
}
