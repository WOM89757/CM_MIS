package com.WM.iframe.basicinfo;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class serviceitemGL extends JInternalFrame{
	 public serviceitemGL() 
	   {// ��Ʒ�����ڲ�����Ĺ��췽��
			setIconifiable(true);// ����ͼ�껯
			setClosable(true);// ���Թر�
			setTitle("������Ŀ����");// ������Ʒ�����ڲ�����ı���
			JTabbedPane tabPane = new JTabbedPane();// ����ѡ����
			final serviceitemAlterPanel spxgPanel = new serviceitemAlterPanel();// ��Ʒ�޸����
			final serviceitemAddPanel  sptjPanel = new serviceitemAddPanel ();// ��Ʒ������
			tabPane.addTab("������Ŀ��Ϣ���", null, sptjPanel, "������Ŀ���");// ����Ʒ��������ӵ�ѡ������
			tabPane.addTab("������Ŀ��Ϣ�޸���ɾ��", null, spxgPanel, "�޸���ɾ��");// ����Ʒ�޸������ӵ�ѡ������
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
