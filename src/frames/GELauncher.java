package frames; //package 선언

public class GELauncher { //GELauncher 클래스 선언

	public static void main(String[] args) { //Main()메소드 선언
		GEMainFrame frame = GEMainFrame.getInstance(); //GEMainFrame 클래스의 getInstance()메소드 호출
		frame.init();
	}

}
