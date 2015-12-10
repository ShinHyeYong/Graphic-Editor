package shapes; //package 선언

import java.awt.Point; //외부 클래스 import
import java.awt.geom.Line2D;

public class GELine extends GEShape{ //GELine 클래스 선언 (GEShape 클래스를 상속)	
	public GELine(){ //GELine 생성자 선언
		super(new Line2D.Double());	//수퍼 클래스(GEShape) 생성자 호출
	}
	public void initDraw(Point startP){ //void 타입 initDraw() 메소드 선언
		this.startP = startP; //파라미터로 넘어온 startP를 startP 필드에 저장
	}
	public void setCoordinate(Point currentP){ //void 타입 setCoordinate() 메소드 선언
		Line2D tempLine = (Line2D)myShape; //myShape 필드를 Line2D 클래스 타입으로 캐스팅 후 Line2D 클래스 타입 tempLine 변수에 저장
		tempLine.setLine(startP.x, startP.y, currentP.x,  currentP.y); //Line2D 클래스의 setLine() 메소드 호출. tempLine 도형의 윤곽선을 대각선으로 하는 박스크기를 설정
	}
}
