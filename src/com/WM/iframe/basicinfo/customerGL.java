//Source file: C:\\Users\\ï\\Desktop\\����\\������Ϣϵͳ\\MIS\\CMMIS\\src\\com\\WM\\iframe\\basicinfo\\customerGL.java

package com.WM.iframe.basicinfo;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class customerGL extends JInternalFrame 
{
   
   /**
   �ͻ������ڲ�����
    */
   private static final long serialVersionUID = 1L;
   
   /**
   @roseuid 5D0B97BA021D
    */
   public customerGL() 
   {// �ͻ������ڲ�����Ĺ��췽��
		setIconifiable(true);// ����ͼ�껯
		setClosable(true);// ���Թر�
		setTitle("��Ա��Ϣ����");// ���ÿͻ������ڲ�����ı���
		JTabbedPane tabPane = new JTabbedPane();// ����ѡ����
		final customerAlterPanel khxgPanel = new customerAlterPanel();// �ͻ��޸����
		final customerAddPanel khtjPanel = new customerAddPanel();// �ͻ�������
		tabPane.addTab("��Ա��Ϣ���", null, khtjPanel, "��Ա���");// �ѿͻ���������ӵ�ѡ������
		tabPane.addTab("��Ա��Ϣ�޸���ɾ��", null, khxgPanel, "�޸���ɾ��");// �ѿͻ��޸������ӵ�ѡ������
		getContentPane().add(tabPane);// ��ѡ������ӵ��ͻ������ڲ���������������
		tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				khxgPanel.initComboBox();// ��ʼ���ͻ��޸�����еġ�ѡ��ͻ��������б�
			}
		});
		pack();// �ͻ������ڲ������е����������ѡ��С���в���
		setVisible(true);// ʹ�ͻ������ڲ�����ɼ�    
   }
}
