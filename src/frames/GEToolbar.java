package frames; //package ����

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JToolBar; //�ܺ� Ŭ���� import

import constants.GEConstants;
import constants.GEConstants.EToolBarButtons;

public class GEToolbar extends JToolBar { //GEToolbar Ŭ���� ����

	private ButtonGroup buttonGroup; //ButtonGroup Ŭ���� Ÿ�� buttonGroup ����
	
	public GEToolbar(String label) { //GEToolBar ������ ���� (�Ķ���ʹ� ToolBar�� �̸�)
		super(label); //���� Ŭ����(JToolBar) ������ ȣ��
		buttonGroup = new ButtonGroup(); //ButtonGroup �ν��Ͻ� ����
		JRadioButton rButton = null; //JRadioButton Ŭ���� Ÿ�� rButton �ʵ� ���� �� null �� �Ҵ�
		
		for (EToolBarButtons btn : EToolBarButtons.values()) { //JRadioButton �ν��Ͻ� ���� �� ImageIcon ������ ���� Ȯ�� for�� ���� (EToolBarButtons�� ����ŭ �ݺ�)
			rButton = new JRadioButton(); //JRadioButton Ŭ������ �ν��Ͻ� ����
			rButton.setIcon(new ImageIcon(GEConstants.IMG_URL+ btn.toString()+
									GEConstants.SUFFIX_TOOLBAR_BTN)); //JRadioButton Ŭ���� �ν��Ͻ��� ImageIcon ���� �� ���� (�Ķ���ʹ� �̹����� URL, ��ư�̸�, �̹��� Ȯ����)
			rButton.setSelectedIcon(new ImageIcon(GEConstants.IMG_URL + 
	                    btn.toString() + GEConstants.SUFFIX_TOOLBAR_BTN_SLT)); //JRadioButton �ν��Ͻ��� ���õǾ��� ���� ImageIcon ���� �� ����(�Ķ���ʹ� �̹����� URL, ��ư�̸�, �̹��� Ȯ����)
			this.add(rButton); //JRadioButton Ŭ������ �ν��Ͻ� ����
			buttonGroup.add(rButton); //������ JRadioButton Ŭ������ �ν��Ͻ��� ButtonGroup�� ����
		}

	}

}
