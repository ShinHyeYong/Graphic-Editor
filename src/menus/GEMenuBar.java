package menus; //package 선언

import javax.swing.JMenuBar; //외부 클래스 import

import constants.GEConstants;

public class GEMenuBar extends JMenuBar { //GEMenuBar 클래스 선언
	private GEMenuFile fileMenu; //GEMenuFile 클래스 타입 fileMenu 필드 선언
	private GEMenuEdit editMenu; //GEMenuEdit 클래스 타입 editMenu 필드 선언
	private GEMenuColor colorMenu; //GEMenuColor 클래스 타입 colorMenu 필드 선언
	
	public GEMenuBar(){ //GEMenuBar 생성자 선언
		fileMenu = new GEMenuFile(GEConstants.TITLE_FILEMENU); //GEMenuFile 클래스의 인스턴스 생성 (파라미터는 FileMenu의 이름)
		this.add(fileMenu); //GEMenuFile 클래스의 인스턴스 포함
		editMenu = new GEMenuEdit(GEConstants.TITLE_EDITMENU); //GEMenuEdit 클래스의 인스턴스 생성 (파라미터는 EditMenu의 이름)
		this.add(editMenu); //GEMenuEdit 클래스의 인스턴스 포함
		colorMenu = new GEMenuColor(GEConstants.TITLE_COLORMENU); //GEMenuColor 클래스의 인스턴스 생성 (파라미터는 ColorMenu의 이름)
		this.add(colorMenu); //GEMenuColor 클래스의 인스턴스 포함
	}
}
