package menus; //package ����

import javax.swing.JMenuBar; //�ܺ� Ŭ���� import

import constants.GEConstants;

public class GEMenuBar extends JMenuBar { //GEMenuBar Ŭ���� ����
	private GEMenuFile fileMenu; //GEMenuFile Ŭ���� Ÿ�� fileMenu �ʵ� ����
	private GEMenuEdit editMenu; //GEMenuEdit Ŭ���� Ÿ�� editMenu �ʵ� ����
	private GEMenuColor colorMenu; //GEMenuColor Ŭ���� Ÿ�� colorMenu �ʵ� ����
	
	public GEMenuBar(){ //GEMenuBar ������ ����
		fileMenu = new GEMenuFile(GEConstants.TITLE_FILEMENU); //GEMenuFile Ŭ������ �ν��Ͻ� ���� (�Ķ���ʹ� FileMenu�� �̸�)
		this.add(fileMenu); //GEMenuFile Ŭ������ �ν��Ͻ� ����
		editMenu = new GEMenuEdit(GEConstants.TITLE_EDITMENU); //GEMenuEdit Ŭ������ �ν��Ͻ� ���� (�Ķ���ʹ� EditMenu�� �̸�)
		this.add(editMenu); //GEMenuEdit Ŭ������ �ν��Ͻ� ����
		colorMenu = new GEMenuColor(GEConstants.TITLE_COLORMENU); //GEMenuColor Ŭ������ �ν��Ͻ� ���� (�Ķ���ʹ� ColorMenu�� �̸�)
		this.add(colorMenu); //GEMenuColor Ŭ������ �ν��Ͻ� ����
	}
}
