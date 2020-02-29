package com.WM.iframe.basicinfo;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.WM.dao.DAO;
import com.WM.dao.Model.goodsinfo;
import com.WM.dao.Model.serviceItemsinfo;

public class serviceitemAddPanel  extends JPanel {
	   private JTextField price;
	   

	   private JTextField goodsname;
	   

	   private JTextField serviceitemid;
	   
	   private JTextField Classic;

	   private JButton resetButton;
	   
	   /**
	   �����á���ť
	   @roseuid 5D0B97BB018D
	    */
	   public serviceitemAddPanel() 
	   {// ��Ʒ������
			setLayout(new GridBagLayout());// ������Ʒ������Ĳ���Ϊ���񲼾�
			setBounds(10, 10, 550, 400);// ������Ʒ�������λ������
			setupComponent(new JLabel("������Ŀ��ţ�"), 0, 0, 1, 1, false);// ���á���Ʒ���ơ���ǩ��λ�ò���ӵ�������
			serviceitemid = new JTextField();// ����Ʒ���ơ��ı���
			setupComponent(serviceitemid, 1, 0, 3, 1, true);// ���á���Ʒ���ơ��ı����λ�ò���ӵ�������
			
			setupComponent(new JLabel("������Ŀ���"), 0, 1, 1, 1, false);// ���á���Ʒ���ơ���ǩ��λ�ò���ӵ�������
			Classic = new JTextField();// ����Ʒ���ơ��ı���
			setupComponent(Classic, 1, 1, 3, 1, true);// ���á���Ʒ���ơ��ı����λ�ò���ӵ�������
			
		setupComponent(new JLabel("������Ŀ���ƣ�"), 0, 2, 1, 1, false);// ���á���λ����ǩ��λ�ò���ӵ�������
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
							 || serviceitemid.getText().equals("")|| Classic.getText().equals("")||price.getText().equals("")) {
						JOptionPane.showMessageDialog(serviceitemAddPanel.this, "�����δ��д����Ϣ��", "������Ŀ���",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					// ִ��SQL��ѯ����õĽ����
					ResultSet haveUser = DAO.query("select * from serviceItemsinfo where serviceName='" + goodsname.getText().trim() + "'");
					try {
						if (haveUser.next()) {// �����haveUser���г���һ���ļ�¼
							System.out.println("error");// ����̨���error
							JOptionPane.showMessageDialog(serviceitemAddPanel.this, "������Ŀ���ʧ�ܣ�����ͬ��������Ŀ", "��ӷ�����Ŀ��Ϣ",
									JOptionPane.INFORMATION_MESSAGE);// ������ʾ��
							return;
						}
					} catch (Exception er) {
						er.printStackTrace();
					}
					ResultSet set = DAO.query("select max(serviceitemId) from serviceItemsinfo");// ִ��SQL��ѯ����õĽ����
					String id = null;// ������Ʒ���
					try {
						if (set != null && set.next()) {// �����set��Ϊ���ҽ����set���г���һ���ļ�¼
							String sid = String.valueOf(set.getInt(1));// ��ý����set�еĵ�һ������ֵ
							if (sid == null)// ��һ������ֵΪ��
								id = "1";// Ϊ��Ʒ��Ÿ�ֵ
							else {
								String str = sid;// ������Ϊ2����ʼ��ȡ�ַ���
								id = "" + (Integer.parseInt(str) + 1);// ����ƴ���ַ�����ò�Ʒ���
							}
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					serviceItemsinfo spInfo = new serviceItemsinfo();// ��Ʒ��Ϣ
					spInfo.setServiceitemId(Integer.valueOf(id));// ������Ʒ���

					spInfo.setServiceName(goodsname.getText().trim());// 

					spInfo.setSellingprice(Float.valueOf(price.getText()));// 

					spInfo.setServiceitemClassic(Classic.getText());// ������Ʒ����
					DAO.addSp(spInfo);// �����Ʒ��Ϣ*/
					JOptionPane.showMessageDialog(serviceitemAddPanel.this, "������Ŀ�Ѿ��ɹ����", "������Ŀ���",
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
					serviceitemid.setText("");
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
