//Source file: C:\\Users\\ï\\Desktop\\����\\������Ϣϵͳ\\MIS\\CMMIS\\src\\com\\WM\\iframe\\basicinfo\\goodsGL.java

package com.WM.iframe.basicinfo;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class goodsGL extends JInternalFrame 
{
   
   /**
   ��Ʒ�����ڲ�����
   @roseuid 5D0B97BC02C3
    */
   public goodsGL() 
   {// ��Ʒ�����ڲ�����Ĺ��췽��
		setIconifiable(true);// ����ͼ�껯
		setClosable(true);// ���Թر�
		setTitle("��Ʒ����");// ������Ʒ�����ڲ�����ı���
		JTabbedPane tabPane = new JTabbedPane();// ����ѡ����
		final goodsAlterPanel spxgPanel = new goodsAlterPanel();// ��Ʒ�޸����
		final goodsAddPanel sptjPanel = new goodsAddPanel();// ��Ʒ������
		tabPane.addTab("��Ʒ��Ϣ���", null, sptjPanel, "��Ʒ���");// ����Ʒ��������ӵ�ѡ������
		tabPane.addTab("��Ʒ��Ϣ�޸���ɾ��", null, spxgPanel, "�޸���ɾ��");// ����Ʒ�޸������ӵ�ѡ������
		getContentPane().add(tabPane);// ��ѡ������ӵ���Ʒ�����ڲ���������������
		tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				spxgPanel.initComboBox();// ��ʼ����Ʒ�޸�����е���Ʒ����ѡ���
				
			}
		});
		addInternalFrameListener(new InternalFrameAdapter(){
			public void internalFrameActivated(InternalFrameEvent e) {
				super.internalFrameActivated(e);
				
			}
		});
		pack();// ��Ʒ�����ڲ������е����������ѡ��С���в���
		setVisible(true);// ʹ��Ʒ�����ڲ�����ɼ�    
   }
}
