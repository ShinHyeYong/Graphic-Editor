package shapes; //package 선언

import java.awt.Point; //외부 클래스 import
import java.awt.Rectangle;
import java.awt.Shape;

public class GERectangle { //GERectangle 클래스 선언
		
	private Point startP; //Point 클래스 타입 startP(도형의 시작점)필드 선언
	private Rectangle rectangle; //Rectangle 클래스 타입 rectangle 필드 선언 	
	
	public GERectangle(){ //GERectangle 생성자 선언
		rectangle = new Rectangle(); //GERectangle 생성자 선언
		}
	
	public void initDraw(Point startP) { //void 타입 initDraw() method 선언 (타입은 Point 클래스 타입, 도형의 시작점을 파라미터로 받음)
		this.startP = startP; //파라미터로 넘어온 startP를 startP 필드에 저장
	}

	public Rectangle getRectangle() { //Rectangle 클래스 타입 getRectangle() 메소드 선언(getMethod) (리턴값으로 rectangle 필드의 값을 넘겨준다.)
		return rectangle;
	}

	public void setCoordinate(Point currentP) { //void 타입 setCoordinate() 메소드 선언 (타입은 Point 클래스 타입, 마우스가 눌러진 상태의 현재 점을 파라미터로 받음)
		rectangle.setFrame(startP.x, startP.y,currentP.x-startP.x,currentP.y-startP.y); //rectangle 필드(그려지는 사각형)의 윤곽선을 설정 (파라미터로 맨 처음 도형을 그리기 시작한 startP의 x,y 좌표와 마지막 좌표(currentP)와 처음시작점(StartP)의 x,y좌표의 차(x의차:width, y의차:height)를 받음)
	}
}
