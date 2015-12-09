package menus; //package 선언

import javax.swing.JMenu; //외부 클래스 import
import javax.swing.JMenuItem;
import constants.GEConstants.EEditMenuItems;

public class GEMenuEdit extends JMenu { //GEMenuEdit 클래스 선언
	
	//GEMenuEdit 생성자 선언 (파라미터는 ColorMenu의 레이블 이름)
	public GEMenuEdit(String label) { //수퍼 클래스(JMenu) 생성자 호출
		super(label);
		
		for(EEditMenuItems btn : EEditMenuItems.values()){ //JMenuItem 생성을 위한 확장 for문 선언(EEditMenuItems 수만큼 반복)
			JMenuItem menuItem = new JMenuItem(btn.toString()); //JMenuItem 클래스의 인스턴스 생성
			this.add(menuItem); //JMenuItem 클래스의 인스턴스 포함
		}
	}
}
