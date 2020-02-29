//Source file: C:\\Users\\ï\\Desktop\\����\\������Ϣϵͳ\\MIS\\CMMIS\\src\\com\\WM\\iframe\\basicinfo\\customerAddPanel.java

package com.WM.iframe.basicinfo;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import com.WM.dao.DAO;
import com.WM.dao.Model.customer;

import keyListener.InputKeyListener;

public class customerAddPanel extends JPanel 
{
   
   /**
   �ͻ�������
    */
   private JTextField hyid;
   private JTextField hyname;
   
  
   private JTextField lianXiDianHua;
   
   /**
   ����ϵ�绰���ı���
    */
  
   private JButton resetButton;
   
   /**
   �����á���ť�ı���
   @roseuid 5D0B97B90059
    */
   public customerAddPanel() 
   {// �ͻ�������
		super();// ���ø���JPanel�Ĺ�����
		setBounds(10, 10, 460, 300);// ���ÿͻ��������λ������
		setLayout(new GridBagLayout());// ���ÿͻ�������Ĳ���Ϊ���񲼾�
		setVisible(true);// ʹ�ͻ�������ɼ�
		
		final JLabel khid = new JLabel();// ���ͻ�ȫ�ơ���ǩ
		khid.setText("��Ա��ţ�");// ���á��ͻ�ȫ�ơ���ǩ���ı�����
		setupComponet(khid, 0, 0, 1, 0, false);// ���á��ͻ�ȫ�ơ���ǩ��λ�ò���ӵ�������
		hyid = new JTextField();// ���ͻ�ȫ�ơ��ı���
		setupComponet(hyid, 1, 0, 3, 350, true);// ���á��ͻ�ȫ�ơ��ı����λ�ò���ӵ�������
		
		final JLabel khName = new JLabel();// ���ͻ�ȫ�ơ���ǩ
		khName.setText("��Ա������");// ���á��ͻ�ȫ�ơ���ǩ���ı�����
		setupComponet(khName, 0, 1, 1, 0, false);// ���á��ͻ�ȫ�ơ���ǩ��λ�ò���ӵ�������
		hyname = new JTextField();// ���ͻ�ȫ�ơ��ı���
		setupComponet(hyname, 1, 1, 3, 350, true);// ���á��ͻ�ȫ�ơ��ı����λ�ò���ӵ�������
		
		
		
		
		setupComponet(new JLabel("��ϵ�绰��"), 0, 2, 1, 0, false);// ���á���ϵ�绰����ǩ��λ�ò���ӵ�������
		lianXiDianHua = new JTextField();// ����ϵ�绰���ı���
		setupComponet(lianXiDianHua, 1, 2, 1, 100, true);// ���á���ϵ�绰���ı����λ�ò���ӵ�������
		lianXiDianHua.addKeyListener(new InputKeyListener());// Ϊ����ϵ�绰���ı�����Ӽ��������¼��ļ���
		
		
		
		final JButton saveButton = new JButton("����");// �����桱��ť
		setupComponet(saveButton, 0, 3, 1, 0, false);// ���á����桱��ť��λ�ò���ӵ�������
		saveButton.addActionListener(new SaveButtonActionListener());// Ϊ�����桱��ť��Ӷ����¼��ļ���
		
		resetButton = new JButton("����");// �����á���ť
		setupComponet(resetButton, 1, 3, 1, 0, false);// ���á����á���ť��λ�ò���ӵ�������
		resetButton.addActionListener(new ChongZheButtonActionListener());// Ϊ�����á���ť��Ӷ����¼��ļ���    
   }
   
   /**
   @param component
   @param gridx
   @param gridy
   @param gridwidth
   @param ipadx
   @param fill
   @roseuid 5D0B97B90061
    */
   private void setupComponet(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) 
   {// �������λ�ò���ӵ�������
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();// �����������ƶ���
		gridBagConstrains.gridx = gridx;// �������λ������ĺ�������Ϊgridx
		gridBagConstrains.gridy = gridy;// �������λ���������������Ϊgridy
		gridBagConstrains.insets = new Insets(5, 1, 3, 1);// ����˴˵ļ��
		if (gridwidth > 1)// ����������������1
			gridBagConstrains.gridwidth = gridwidth;// ����������������Ϊgridwidth
		if (ipadx > 0)// ����������Ĵ�С����0
			gridBagConstrains.ipadx = ipadx;// ��������������Ĵ�С
		if (fill)// ���ռ�ݿհ�����
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
		add(component, gridBagConstrains);// ������    
   }
   
   private final class SaveButtonActionListener implements ActionListener 
   {
      
      /**
      �����桱��ť�����¼��ļ���
      @param e
      @roseuid 5D0B97B900DD
       */
      public void actionPerformed(final ActionEvent e) 
      {
			// �ı���Ϊ��ʱ��������ʾ��
			if (hyid.getText().equals("") || lianXiDianHua.getText().equals("") || hyname.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "����дȫ����Ϣ");
				return;// �˳�Ӧ�ó���
			}
			// ִ��SQL��ѯ����õĽ����
			ResultSet haveUser = DAO.query("select * from customer where cardId=" + Integer.valueOf(hyid.getText()) + "");
			try {
				if (haveUser.next()) {// �����haveUser���г���һ���ļ�¼
					System.out.println("error");// ����̨���error
					JOptionPane.showMessageDialog(customerAddPanel.this, "��Ա��Ϣ���ʧ�ܣ�����ͬ����Ա", "��Ա�����Ϣ",
							JOptionPane.INFORMATION_MESSAGE);// ������ʾ��
					return;
				}
			} catch (Exception er) {
				er.printStackTrace();
			}
			ResultSet set = DAO.query("select max(cardId) from customer");// ִ��SQL��ѯ����õĽ����
			String id = null;// �����ͻ����
			try {
				if (set != null && set.next()) {// �����set��Ϊ���ҽ����set���г���һ���ļ�¼
					String sid = String.valueOf(set.getInt(1));// ��ý����set�еĵ�һ������ֵ
					if (sid == null)// ��һ������ֵΪ��
						id = "10001";// Ϊ��Ʒ��Ÿ�ֵ
					else {
						String str = sid;
						id = "" + (Integer.parseInt(str) + 1);// ����ƴ���ַ�����ò�Ʒ���
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			customer khinfo = new customer();// �ͻ���Ϣ
			khinfo.setCardId(Integer.valueOf(id));// ������Ʒ���
			
			khinfo.setUserName(hyname.getText().trim());// ���ÿͻ�����
			
			khinfo.setPhoneNumber(Long.valueOf(lianXiDianHua.getText()));// ������ϵ�绰

			DAO.addKeHu(khinfo);// ��ӿͻ���Ϣ
			JOptionPane.showMessageDialog(customerAddPanel.this, "�ѳɹ���ӻ�Ա", "��ӻ�Ա��Ϣ", JOptionPane.INFORMATION_MESSAGE);// ������ʾ��
			resetButton.doClick();// �����á���ťִ�е���¼�    
      }
   }
   
   private class ChongZheButtonActionListener implements ActionListener 
   {
      
      /**
      �����á���ť�����¼��ļ���
      @param e
      @roseuid 5D0B97B90133
       */
      public void actionPerformed(final ActionEvent e) 
      {
			// �����ı��������Ϊ��
			hyid.setText("");
	
			lianXiDianHua.setText("");
			hyname.setText("");
			
      }
   }
}
