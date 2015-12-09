package frames; //package 선언

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JToolBar; //외부 클래스 import

import constants.GEConstants;
import constants.GEConstants.EToolBarButtons;

public class GEToolbar extends JToolBar { //GEToolbar 클래스 선언

	private ButtonGroup buttonGroup; //ButtonGroup 클래스 타입 buttonGroup 선언
	
	public GEToolbar(String label) { //GEToolBar 생성자 선언 (파라미터는 ToolBar의 이름)
		super(label); //수퍼 클래스(JToolBar) 생성자 호출
		buttonGroup = new ButtonGroup(); //ButtonGroup 인스턴스 생성
		JRadioButton rButton = null; //JRadioButton 클래스 타입 rButton 필드 선언 및 null 값 할당
		
		for (EToolBarButtons btn : EToolBarButtons.values()) { //JRadioButton 인스턴스 생성 및 ImageIcon 생성을 위한 확장 for문 선언 (EToolBarButtons의 수만큼 반복)
			rButton = new JRadioButton(); //JRadioButton 클래스의 인스턴스 생성
			rButton.setIcon(new ImageIcon(GEConstants.IMG_URL+ btn.toString()+
									GEConstants.SUFFIX_TOOLBAR_BTN)); //JRadioButton 클래스 인스턴스의 ImageIcon 생성 및 포함 (파라미터는 이미지의 URL, 버튼이름, 이미지 확장자)
			rButton.setSelectedIcon(new ImageIcon(GEConstants.IMG_URL + 
	                    btn.toString() + GEConstants.SUFFIX_TOOLBAR_BTN_SLT)); //JRadioButton 인스턴스의 선택되었을 때의 ImageIcon 생성 및 포함(파라미터는 이미지의 URL, 버튼이름, 이미지 확장자)
			this.add(rButton); //JRadioButton 클래스의 인스턴스 포함
			buttonGroup.add(rButton); //생성된 JRadioButton 클래스의 인스턴스를 ButtonGroup에 포함
		}

	}

}
