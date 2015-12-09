package menus; //package ����

import javax.swing.JMenu; //�ܺ� Ŭ���� import
import javax.swing.JMenuItem;
import constants.GEConstants.EEditMenuItems;

public class GEMenuEdit extends JMenu { //GEMenuEdit Ŭ���� ����
	
	//GEMenuEdit ������ ���� (�Ķ���ʹ� ColorMenu�� ���̺� �̸�)
	public GEMenuEdit(String label) { //���� Ŭ����(JMenu) ������ ȣ��
		super(label);
		
		for(EEditMenuItems btn : EEditMenuItems.values()){ //JMenuItem ������ ���� Ȯ�� for�� ����(EEditMenuItems ����ŭ �ݺ�)
			JMenuItem menuItem = new JMenuItem(btn.toString()); //JMenuItem Ŭ������ �ν��Ͻ� ����
			this.add(menuItem); //JMenuItem Ŭ������ �ν��Ͻ� ����
		}
	}
}
