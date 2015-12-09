package menus; //package ����

import javax.swing.JMenu; //�ܺ� Ŭ���� import
import javax.swing.JMenuItem;

import constants.GEConstants.EColorMenuItems;

public class GEMenuColor extends JMenu { //GEMenuColor Ŭ���� ����
	
	//GEMenuColor ������ ���� (�Ķ���ʹ� ColorMenu�� ���̺� �̸�)
	public GEMenuColor(String label){ //���� Ŭ����(JMenu) ������ ȣ��
		super(label);
		
		for(EColorMenuItems btn : EColorMenuItems.values()){ //JMenuItem ������ ���� Ȯ�� for�� ����(EColorMenuItems ����ŭ �ݺ�)
			JMenuItem menuItem = new JMenuItem(btn.toString()); //JMenuItem Ŭ������ �ν��Ͻ� ����
			this.add(menuItem); //JMenuItem Ŭ������ �ν��Ͻ� ����
		}
	}
}
