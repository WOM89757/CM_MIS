//Source file: C:\\Users\\ï\\Desktop\\����\\������Ϣϵͳ\\MIS\\CMMIS\\src\\com\\WM\\iframe\\basicinfo\\staffGL.java

package com.WM.iframe.basicinfo;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class staffGL extends JInternalFrame 
{
   
   /**
   �����˹����ڲ�����
   @roseuid 5D0B97BD019D
    */
   public staffGL() 
   {// �����˹����ڲ�����Ĺ��췽��
		setIconifiable(true);// ����ͼ�껯
		setClosable(true);// ���Թر�
		setBounds(100, 100, 491, 200);// ���þ����˹����ڲ������λ�úͿ��
		setTitle("Ա������");// ���þ����˹����ڲ�����ı���
		JTabbedPane tabPane = new JTabbedPane();// ����ѡ����
		final staffAddPanel tjPanel = new staffAddPanel();// ��Ӿ��������
		final staffSetPanel setPanel = new staffSetPanel();// ���þ��������
		tabPane.addTab("���Ա��", null, tjPanel, "���Ա��");// ����Ӿ����������ӵ�ѡ������
		tabPane.addTab("����Ա��", null, setPanel, "����Ա��");// �����þ����������ӵ�ѡ������
		getContentPane().add(tabPane);// ��ѡ������ӵ������˹����ڲ���������������
		tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				setPanel.initTable();// ��ʼ�����þ���������еı��ģ��
			}
		});
		pack();// �����˹����ڲ������е����������ѡ��С���в���
		setVisible(true);// ʹ�����˹����ڲ�����ɼ�    
   }
}
