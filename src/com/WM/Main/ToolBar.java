//Source file: C:\\Users\\ï\\Desktop\\����\\������Ϣϵͳ\\MIS\\CMMIS\\src\\com\\WM\\Main\\ToolBar.java

package com.WM.Main;

import javax.swing.*;
import com.WM.dao.*;
import java.awt.Dimension;
import javax.swing.border.EtchedBorder;

public class ToolBar extends JToolBar 
{
   
   /**
   ������
    */
   private MenuBar menuBar;
   
   /**
   �������캯��
   @param frameMenuBar
   @roseuid 5D0B97CD01CF
    */
   public ToolBar(MenuBar frameMenuBar) 
   {
		super();// ���ø���JToolBar�Ĺ�����
		this.menuBar = frameMenuBar;
		initialize();// �����ʼ������    
   }
   
   /**
   �˵���
   ȱʡ���캯��
   @roseuid 5D0B97CD01C3
    */
   private ToolBar() 
   {
    
   }
   
   /**
   �����ʼ������
   @roseuid 5D0B97CD01E4
    */
   private void initialize() 
   {
		setSize(new Dimension(600, 24));// ���ù������Ŀ��
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));// ���ù������ı߿�
		
		add(createToolButton(menuBar.getShouyincentre_Item()));// �򹤾�����������۵�
		add(createToolButton(menuBar.getGuadandaijie_Item()));// �򹤾�������ӹҵ�����
		add(createToolButton(menuBar.getXiaoshou_chaxunItem()));// �򹤾�������ӽ�����
		add(createToolButton(menuBar.getKucun_pandianItem()));// �򹤾�������ӿ���̵�
	
		add(createToolButton(menuBar.getShangpin_chaxunItem()));// �򹤾����������Ʒ��ѯ
		add(createToolButton(menuBar.getShangpin_guanliItem()));// �򹤾����������Ʒ���Ϲ���
		add(createToolButton(menuBar.getKehu_guanliItem()));// �򹤾�������ӿͻ����Ϲ���
		add(createToolButton(menuBar.getGys_guanliItem()));// �򹤾�������ӹ�Ӧ�����Ϲ���
		add(createToolButton(menuBar.getExitItem()));// �򹤾���������˳�ϵͳ    
   }
   
   /**
   ������������ť�ķ���
   @param item
   @return javax.swing.JButton
   @roseuid 5D0B97CD01F1
    */
   private JButton createToolButton(final JMenuItem item) 
   {
		JButton button = new JButton();// ��������ť
		button.setText(item.getText());// ���ù�������ť���ı�����
		button.setToolTipText(item.getText());// ���ù�������ť������Ч��
		button.setIcon(item.getIcon());// ���ù�������ť��ͼ��
		button.setFocusable(false);// �ù�������ťʧȥ����
		button.addActionListener(new java.awt.event.ActionListener() {// Ϊ��������ť��Ӷ����¼��ļ���
			public void actionPerformed(java.awt.event.ActionEvent e) {
				item.doClick();// �˵���ĵ���¼�
			}
		});
		return button;    
   }
   
   /**
   @param menuBar
   @roseuid 5D0B97CD0215
    */
   public void setMenuBar(MenuBar menuBar) 
   {// ���ò˵���
		this.menuBar = menuBar;    
   }
}
