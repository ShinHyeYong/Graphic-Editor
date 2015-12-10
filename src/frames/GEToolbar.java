package frames; //package 선언

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JToolBar; //외부 클래스 import

import constants.GEConstants;
import constants.GEConstants.EToolBarButtons;
import shapes.GEEllipse;
import shapes.GELine;
import shapes.GERectangle;

public class GEToolbar extends JToolBar { //GEToolbar 클래스 선언

	private ButtonGroup buttonGroup; //ButtonGroup 클래스 타입 buttonGroup 선언
	private GEDrawingPanel drawingPanel; //GEDrawingPanel 클래스 타입 drawingPanel 필드 선언
	private GEToolBarHandler shapeToolBarHandler; //GEToolBarHandler 클래스 타입 shapeToolBarHandler 필드 선언
	
	public GEToolbar(String label) { //GEToolBar 생성자 선언 (파라미터는 ToolBar의 이름)
		super(label); //수퍼 클래스(JToolBar) 생성자 호출
		buttonGroup = new ButtonGroup(); //ButtonGroup 인스턴스 생성
		JRadioButton rButton = null; //JRadioButton 클래스 타입 rButton 필드 선언 및 null 값 할당
		
		shapeToolBarHandler = new GEToolBarHandler(); //GEToolBarHandler 클래스의 인스턴스 생성
		for (EToolBarButtons btn : EToolBarButtons.values()) { //JRadioButton 인스턴스 생성 및 ImageIcon 생성을 위한 확장 for문 선언 (EToolBarButtons의 수만큼 반복)
			rButton = new JRadioButton(); //JRadioButton 클래스의 인스턴스 생성
			rButton.setIcon(new ImageIcon(GEConstants.IMG_URL+ btn.toString()+
									GEConstants.SUFFIX_TOOLBAR_BTN)); //JRadioButton 클래스 인스턴스의 ImageIcon 생성 및 포함 (파라미터는 이미지의 URL, 버튼이름, 이미지 확장자)
			rButton.setSelectedIcon(new ImageIcon(GEConstants.IMG_URL + 
	                    btn.toString() + GEConstants.SUFFIX_TOOLBAR_BTN_SLT)); //JRadioButton 인스턴스의 선택되었을 때의 ImageIcon 생성 및 포함(파라미터는 이미지의 URL, 버튼이름, 이미지 확장자)
			rButton.addActionListener(shapeToolBarHandler); //JRadioButton 인스턴스의 addActionListner() 메소드를 호출
			rButton.setActionCommand(btn.toString()); //JRadioButton 인스턴스의 setActionCommand() 메소드를 호출
			this.add(rButton); //JRadioButton 클래스의 인스턴스 포함
			buttonGroup.add(rButton); //생성된 JRadioButton 클래스의 인스턴스를 ButtonGroup에 포함
		}

	}
	public void init(GEDrawingPanel dp){ //void 타입 init() 메소드 선언 (GEDrawingPanel의 객체를 파라미터로 받음)
		drawingPanel = dp; //파라미터로 받은 GEDrawingPanel 객체를 drawingPanel 필드에 저장 (association)
		setSize(GEConstants.WIDTH_SHAPETOOLBAR, GEConstants.HEIGHT_SHAPETOOLBAR); //setSize() 메소드 호출 (ToolBar의 너비, 높이 상수를 파라미터로 받음)
		clickDefaultButton(); //clickDefalutButton() 메소드 호출
	}
	private void clickDefaultButton(){ //void 타입 clickDefaultButton() 메소드 선언
		JRadioButton rButton = (JRadioButton)this.getComponent(EToolBarButtons.Rectangle.ordinal()); //JRadioButton 클래스 타입 rButton 변수 선언 및 할당
		rButton.doClick(); //JRadioButton 클래스의 doClick() 메소드 호출
	}
	private class GEToolBarHandler implements ActionListener{ //GEToolBarHandler 내부 클래스 선언 (ActionListner interface implements)
		public void actionPerformed(ActionEvent e){ //void 타입 actionPerformed 메소드 선언 (ActionListner interface의 메소드를 오버라이드함. ActionEvent의 객체를 파라미터로 받음)
			JRadioButton button = (JRadioButton)e.getSource(); //JRadioButton 클래스 타입 rButton 변수 선언 및 할당
			if(button.getActionCommand().equals(EToolBarButtons.Rectangle.name())){ //button을 눌렀을 때의 이벤트 값이 EToolBarButton의 Rectangle값과 일치하면 조건문 실행
				drawingPanel.setCurrentShape(new GERectangle()); //GEDrawingPanel의 setCurrentShape() 메소드 호출 (GERectangle 인스턴스를 생성하여 파라미터로 받음)
			}else if(button.getActionCommand().equals(EToolBarButtons.Ellipse.name())){
				drawingPanel.setCurrentShape(new GEEllipse());
			}else if(button.getActionCommand().equals(EToolBarButtons.Line.name())){
				drawingPanel.setCurrentShape(new GELine());
			}
		}
	}
}
