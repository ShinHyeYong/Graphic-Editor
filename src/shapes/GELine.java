package shapes; //package 선언

import java.awt.Point; //외부 클래스 import
import java.awt.geom.Line2D;

public class GELine { //GELine 클래스 선언
	private Point startP; //Point 클래스 타입 startP(도형의 시작점)필드 선언
	private Line2D line; //Line2D 클래스 타입 line 필드 선언
	
	public GELine(){ //GELine 생성자 선언
		line = new Line2D.Double(); //Line2D.Double 클래스의 인스턴스 생성
	}	
	public void initDraw(Point startP){ //void 타입 initDraw() 메소드 선언
		this.startP = startP; //파라미터로 넘어온 startP를 startP 필드에 저장
	}	
	public void setCoordinate(Point currentP){ //void 타입 setCoordinate() 메소드 선언
		line.setLine(startP.x, startP.y, currentP.x,  currentP.y); //line 필드(그려지는 직선)의 윤곽선을 대각선으로 하는 박스크기를 설정
	}
	public Line2D getLine() { //Line2D 클래스 타입 getLine() 메소드 선언(getMethod)
		return line; 
	}
}
