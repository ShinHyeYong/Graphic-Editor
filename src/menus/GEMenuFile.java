package menus; //package ����

import javax.swing.JMenu; //�ܺ� Ŭ���� import
import javax.swing.JMenuItem;

import constants.GEConstants.EFileMenuItems;

public class GEMenuFile extends JMenu { //GEMenuFile Ŭ���� ����

	//GEMenuFile ������ ����(�Ķ���ʹ� FileMenu�� ���̺� �̸�)
	public GEMenuFile(String label) { //���� Ŭ���� (JMenu) ������ ȣ��
		super(label);
		
		for(EFileMenuItems btn : EFileMenuItems.values()){ //JMenuItem ������ ���� Ȯ�� for�� ����(EFileMenuItems ����ŭ �ݺ�)
			JMenuItem menuItem = new JMenuItem(btn.toString()); //JMenuItem Ŭ������ �ν��Ͻ� ����
			this.add(menuItem); //JMenuItem Ŭ������ �ν��Ͻ� ����
		}
	}

}
