package shapes; //package 선언

import java.awt.Point; //외부 클래스 import
import java.awt.geom.Ellipse2D;

public class GEEllipse { //GEEllipse 클래스 선언
	private Point startP; //Point 클래스 타입 startP(도형의 시작점)필드 선언
	private Ellipse2D ellipse; //Ellipse2D 클래스 타입 ellipse 필드 선언
	public GEEllipse(){ //GEEllipse 생성자 선언
		ellipse = new Ellipse2D.Double(); //Ellipse2D.Double 클래스의 인스턴스 생성
	}
	public void initDraw(Point startP){ //void 타입 initDraw() 메소드 선언 (타입은 Point 클래스 타입, 도형의 시작점(startP)을 파라미터로 받음)
		this.startP = startP; //파라미터로 넘어온 startP를 startP 필드에 저장
	}
	public void setCoordinate(Point currentP){ //void 타입 setCoordinate() 메소드 선언 (타입은 Point 클래스 타입, 마우스가 눌러진 상태의 현재 점(currentP)을 파라미터로 받음)
		ellipse.setFrame(startP.x, startP.y, currentP.x-startP.x,currentP.y-startP.y); //ellipse 필드(그려지는 타원)의 윤곽선이 인접한 박스크기를 설정
	}
	public Ellipse2D getEllipse(){ //Ellipse2D 클래스 타입 getEllipse() 메소드 선언(getMethod) (ellipse 필드의 값을 반환)
		return ellipse;
	}
}
