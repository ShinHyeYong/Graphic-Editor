package menus; //package 선언

import javax.swing.JMenu; //외부 클래스 import
import javax.swing.JMenuItem;

import constants.GEConstants.EColorMenuItems;

public class GEMenuColor extends JMenu { //GEMenuColor 클래스 선언
	
	//GEMenuColor 생성자 선언 (파라미터는 ColorMenu의 레이블 이름)
	public GEMenuColor(String label){ //수퍼 클래스(JMenu) 생성자 호출
		super(label);
		
		for(EColorMenuItems btn : EColorMenuItems.values()){ //JMenuItem 생성을 위한 확장 for문 선언(EColorMenuItems 수만큼 반복)
			JMenuItem menuItem = new JMenuItem(btn.toString()); //JMenuItem 클래스의 인스턴스 생성
			this.add(menuItem); //JMenuItem 클래스의 인스턴스 포함
		}
	}
}
