//Source file: C:\\Users\\ï\\Desktop\\����\\������Ϣϵͳ\\MIS\\CMMIS\\src\\com\\WM\\iframe\\basicinfo\\goodsAddPanel.java

package com.WM.iframe.basicinfo;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.util.List;
import com.WM.dao.DAO;
import com.WM.dao.Model.Item;
import com.WM.dao.Model.goodsinfo;

public class goodsAddPanel extends JPanel 
{
   


   private JTextField price;
   

   private JTextField goodsname;
   

   private JTextField goodsid;
   
   private JTextField Classic;

   private JButton resetButton;
   
   /**
   �����á���ť
   @roseuid 5D0B97BB018D
    */
   public goodsAddPanel() 
   {// ��Ʒ������
		setLayout(new GridBagLayout());// ������Ʒ������Ĳ���Ϊ���񲼾�
		setBounds(10, 10, 550, 400);// ������Ʒ�������λ������
		setupComponent(new JLabel("��Ʒ��ţ�"), 0, 0, 1, 1, false);// ���á���Ʒ���ơ���ǩ��λ�ò���ӵ�������
		goodsid = new JTextField();// ����Ʒ���ơ��ı���
		setupComponent(goodsid, 1, 0, 3, 1, true);// ���á���Ʒ���ơ��ı����λ�ò���ӵ�������
		
		setupComponent(new JLabel("��Ʒ���"), 0, 1, 1, 1, false);// ���á���Ʒ���ơ���ǩ��λ�ò���ӵ�������
		Classic = new JTextField();// ����Ʒ���ơ��ı���
		setupComponent(Classic, 1, 1, 3, 1, true);// ���á���Ʒ���ơ��ı����λ�ò���ӵ�������
		
	setupComponent(new JLabel("��Ʒ���ƣ�"), 0, 2, 1, 1, false);// ���á���λ����ǩ��λ�ò���ӵ�������
		goodsname = new JTextField();// ����λ���ı���
		setupComponent(goodsname, 1, 2, 1, 130, true);// ���á���λ���ı����λ�ò���ӵ�������
		setupComponent(new JLabel("�۸�"), 0, 3, 1, 1, false);// ���á���ע����ǩ��λ�ò���ӵ�������
		price = new JTextField();// ����ע���ı���
		setupComponent(price, 1, 3, 3, 1, true);// ���á���ע���ı����λ�ò���ӵ�������
		final JButton tjButton = new JButton();// ����ӡ���ť
		tjButton.addActionListener(new ActionListener() {// Ϊ����ӡ���ť��Ӷ����¼��ļ���
			public void actionPerformed(final ActionEvent e) {
				// �ı���Ϊ��ʱ��������ʾ��
				if ( goodsname.getText().equals("")
						 || goodsid.getText().equals("")|| Classic.getText().equals("")||price.getText().equals("")) {
					JOptionPane.showMessageDialog(goodsAddPanel.this, "�����δ��д����Ϣ��", "��Ʒ���",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				// ִ��SQL��ѯ����õĽ����
				ResultSet haveUser = DAO.query("select * from goodsinfo where goodsName='" + goodsname.getText().trim() + "'");
				try {
					if (haveUser.next()) {// �����haveUser���г���һ���ļ�¼
						System.out.println("error");// ����̨���error
						JOptionPane.showMessageDialog(goodsAddPanel.this, "��Ʒ��Ϣ���ʧ�ܣ�����ͬ����Ʒ", "�����Ϣ",
								JOptionPane.INFORMATION_MESSAGE);// ������ʾ��
						return;
					}
				} catch (Exception er) {
					er.printStackTrace();
				}
				ResultSet set = DAO.query("select max(goodsId) from goodsinfo");// ִ��SQL��ѯ����õĽ����
				String id = null;// ������Ʒ���
				try {
					if (set != null && set.next()) {// �����set��Ϊ���ҽ����set���г���һ���ļ�¼
						String sid = String.valueOf(set.getInt(1));// ��ý����set�еĵ�һ������ֵ
						if (sid == null)// ��һ������ֵΪ��
							id = "1001";// Ϊ��Ʒ��Ÿ�ֵ
						else {
							String str = sid;// ������Ϊ2����ʼ��ȡ�ַ���
							id = "" + (Integer.parseInt(str) + 1);// ����ƴ���ַ�����ò�Ʒ���
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				goodsinfo spInfo = new goodsinfo();// ��Ʒ��Ϣ
				spInfo.setGoodsId(Integer.valueOf(id));// ������Ʒ���

				spInfo.setGoodsName(goodsname.getText().trim());// ������Ʒ������λ

				spInfo.setSellingprice(Float.valueOf(price.getText()));// ���ñ�ע

				spInfo.setGoodsId(Integer.valueOf(goodsid.getText()));// ������Ʒ����
				DAO.addSp(spInfo);// �����Ʒ��Ϣ*/
				JOptionPane.showMessageDialog(goodsAddPanel.this, "��Ʒ��Ϣ�Ѿ��ɹ����", "��Ʒ���",
						JOptionPane.INFORMATION_MESSAGE);// ������ʾ��
				resetButton.doClick();// �����á���ťִ�е���¼�
			}
		});
		tjButton.setText("���");// ����ӡ���ť
		setupComponent(tjButton, 1, 8, 1, 1, false);// ���á���ӡ���ť��λ�ò���ӵ�������
		final GridBagConstraints gridBagConstraints_20 = new GridBagConstraints();// �����������ƶ���
		gridBagConstraints_20.weighty = 1.0;// ����ӡ���ť���������Ȩ����1.0
		gridBagConstraints_20.insets = new Insets(0, 65, 0, 15);// ����ӡ���ť����������˴˵ļ��
		gridBagConstraints_20.gridy = 8;// ����ӡ���ťλ���������������Ϊ8
		gridBagConstraints_20.gridx = 1;// ����ӡ���ťλ������ĺ�������Ϊ1
		resetButton = new JButton();// �����á���ť
		setupComponent(resetButton, 3, 8, 1, 1, false);// ���á����á���ť��λ�ò���ӵ�������
		resetButton.addActionListener(new ActionListener() {// �����á���ť�����¼��ļ���
			public void actionPerformed(final ActionEvent e) {
				// �����ı��������Ϊ��
				Classic.setText("");
				goodsname.setText("");

				price.setText("");
				goodsid.setText("");
			}
		});
		resetButton.setText("����");// ���á����á���ť�е��ı�����    
   }
   
   /**
   @param component
   @param gridx
   @param gridy
   @param gridwidth
   @param ipadx
   @param fill
   @roseuid 5D0B97BB0196
    */
   private void setupComponent(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) 
   {// ���������λ�ò���ӵ�������
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
   

}
