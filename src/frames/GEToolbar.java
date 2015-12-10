package frames; //package ����

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JToolBar; //�ܺ� Ŭ���� import

import constants.GEConstants;
import constants.GEConstants.EToolBarButtons;
import shapes.GEEllipse;
import shapes.GELine;
import shapes.GERectangle;

public class GEToolbar extends JToolBar { //GEToolbar Ŭ���� ����

	private ButtonGroup buttonGroup; //ButtonGroup Ŭ���� Ÿ�� buttonGroup ����
	private GEDrawingPanel drawingPanel; //GEDrawingPanel Ŭ���� Ÿ�� drawingPanel �ʵ� ����
	private GEToolBarHandler shapeToolBarHandler; //GEToolBarHandler Ŭ���� Ÿ�� shapeToolBarHandler �ʵ� ����
	
	public GEToolbar(String label) { //GEToolBar ������ ���� (�Ķ���ʹ� ToolBar�� �̸�)
		super(label); //���� Ŭ����(JToolBar) ������ ȣ��
		buttonGroup = new ButtonGroup(); //ButtonGroup �ν��Ͻ� ����
		JRadioButton rButton = null; //JRadioButton Ŭ���� Ÿ�� rButton �ʵ� ���� �� null �� �Ҵ�
		
		shapeToolBarHandler = new GEToolBarHandler(); //GEToolBarHandler Ŭ������ �ν��Ͻ� ����
		for (EToolBarButtons btn : EToolBarButtons.values()) { //JRadioButton �ν��Ͻ� ���� �� ImageIcon ������ ���� Ȯ�� for�� ���� (EToolBarButtons�� ����ŭ �ݺ�)
			rButton = new JRadioButton(); //JRadioButton Ŭ������ �ν��Ͻ� ����
			rButton.setIcon(new ImageIcon(GEConstants.IMG_URL+ btn.toString()+
									GEConstants.SUFFIX_TOOLBAR_BTN)); //JRadioButton Ŭ���� �ν��Ͻ��� ImageIcon ���� �� ���� (�Ķ���ʹ� �̹����� URL, ��ư�̸�, �̹��� Ȯ����)
			rButton.setSelectedIcon(new ImageIcon(GEConstants.IMG_URL + 
	                    btn.toString() + GEConstants.SUFFIX_TOOLBAR_BTN_SLT)); //JRadioButton �ν��Ͻ��� ���õǾ��� ���� ImageIcon ���� �� ����(�Ķ���ʹ� �̹����� URL, ��ư�̸�, �̹��� Ȯ����)
			rButton.addActionListener(shapeToolBarHandler); //JRadioButton �ν��Ͻ��� addActionListner() �޼ҵ带 ȣ��
			rButton.setActionCommand(btn.toString()); //JRadioButton �ν��Ͻ��� setActionCommand() �޼ҵ带 ȣ��
			this.add(rButton); //JRadioButton Ŭ������ �ν��Ͻ� ����
			buttonGroup.add(rButton); //������ JRadioButton Ŭ������ �ν��Ͻ��� ButtonGroup�� ����
		}

	}
	public void init(GEDrawingPanel dp){ //void Ÿ�� init() �޼ҵ� ���� (GEDrawingPanel�� ��ü�� �Ķ���ͷ� ����)
		drawingPanel = dp; //�Ķ���ͷ� ���� GEDrawingPanel ��ü�� drawingPanel �ʵ忡 ���� (association)
		setSize(GEConstants.WIDTH_SHAPETOOLBAR, GEConstants.HEIGHT_SHAPETOOLBAR); //setSize() �޼ҵ� ȣ�� (ToolBar�� �ʺ�, ���� ����� �Ķ���ͷ� ����)
		clickDefaultButton(); //clickDefalutButton() �޼ҵ� ȣ��
	}
	private void clickDefaultButton(){ //void Ÿ�� clickDefaultButton() �޼ҵ� ����
		JRadioButton rButton = (JRadioButton)this.getComponent(EToolBarButtons.Rectangle.ordinal()); //JRadioButton Ŭ���� Ÿ�� rButton ���� ���� �� �Ҵ�
		rButton.doClick(); //JRadioButton Ŭ������ doClick() �޼ҵ� ȣ��
	}
	private class GEToolBarHandler implements ActionListener{ //GEToolBarHandler ���� Ŭ���� ���� (ActionListner interface implements)
		public void actionPerformed(ActionEvent e){ //void Ÿ�� actionPerformed �޼ҵ� ���� (ActionListner interface�� �޼ҵ带 �������̵���. ActionEvent�� ��ü�� �Ķ���ͷ� ����)
			JRadioButton button = (JRadioButton)e.getSource(); //JRadioButton Ŭ���� Ÿ�� rButton ���� ���� �� �Ҵ�
			if(button.getActionCommand().equals(EToolBarButtons.Rectangle.name())){ //button�� ������ ���� �̺�Ʈ ���� EToolBarButton�� Rectangle���� ��ġ�ϸ� ���ǹ� ����
				drawingPanel.setCurrentShape(new GERectangle()); //GEDrawingPanel�� setCurrentShape() �޼ҵ� ȣ�� (GERectangle �ν��Ͻ��� �����Ͽ� �Ķ���ͷ� ����)
			}else if(button.getActionCommand().equals(EToolBarButtons.Ellipse.name())){
				drawingPanel.setCurrentShape(new GEEllipse());
			}else if(button.getActionCommand().equals(EToolBarButtons.Line.name())){
				drawingPanel.setCurrentShape(new GELine());
			}
		}
	}
}
