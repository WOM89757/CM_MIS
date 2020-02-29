package com.WM.iframe.basicinfo;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.WM.dao.DAO;
import com.WM.dao.goodsDAO;
import com.WM.dao.serviceItemsDAO;
import com.WM.dao.Model.Item;
import com.WM.dao.Model.serviceItemsinfo;

public class serviceitemAlterPanel extends JPanel {
	  /**
	   ��Ʒ�޸����
	    */
	   private JComboBox gysQuanCheng;
	   
	   /**
	   ����Ӧ��ȫ�ơ������б�
	    */
	   private JTextField price;
	   

	   private JTextField goodClassic;
	   

	   private JTextField jianCheng;
	   
	   /**
	   ����ơ��ı���
	    */
	   private JTextField goodname;
	   private JTextField goodid;
	   /**
	   ����Ʒ���ơ��ı���
	    */
	   private JButton modifyButton;
	   
	   /**
	   ���޸ġ���ť
	    */
	   private JButton delButton;
	   
	   /**
	   ��ɾ������ť
	    */
	   private JComboBox sp;
	   
	   /**
	   ��ѡ����Ʒ�������б�
	   @roseuid 5D0B97BC0117
	    */
	   public serviceitemAlterPanel() 
	   {// ��Ʒ�޸����
			setLayout(new GridBagLayout());// ������Ʒ�޸����Ĳ���Ϊ���񲼾�
			setBounds(10, 10, 550, 400);// ������Ʒ�޸�����λ������

			setupComponet(new JLabel("������Ŀ��ţ�"), 0, 0, 1, 1, false);// ���á���λ����ǩ��λ�ò���ӵ�������
			goodid= new JTextField();// ����λ���ı���
			setupComponet(goodid, 1, 0, 1, 130, true);// ���á���λ���ı����λ�ò���ӵ�������
			
			setupComponet(new JLabel("������Ŀ���ƣ�"), 0, 1, 1, 1, false);// ���á���Ʒ���ơ���ǩ��λ�ò���ӵ�������
			goodname = new JTextField();// ����Ʒ���ơ��ı���
			goodname.setEditable(false);// ���á���Ʒ���ơ��ı��򲻿ɱ༭
			setupComponet(goodname, 1, 1, 3, 1, true);// ���á���Ʒ���ơ��ı����λ�ò���ӵ�������

		setupComponet(new JLabel("������Ŀ���"), 0, 2, 1, 1, false);// ���á���λ����ǩ��λ�ò���ӵ�������
			goodClassic = new JTextField();// ����λ���ı���
			setupComponet(goodClassic, 1, 2, 1, 130, true);// ���á���λ���ı����λ�ò���ӵ�������

			
			setupComponet(new JLabel("�۸�"), 0, 3, 1, 1, false);// ���á���ע����ǩ��λ�ò���ӵ�������
			price = new JTextField();// ����ע���ı���
			setupComponet(price, 1, 3, 3, 1, true);// ���á���ע���ı����λ�ò���ӵ�������

			setupComponet(new JLabel("ѡ�������Ŀ"), 0, 4, 1, 0, false);// ���á�ѡ����Ʒ����ǩ��λ�ò���ӵ�������
			sp = new JComboBox();// ��ѡ����Ʒ�������б�
			sp.setPreferredSize(new Dimension(230, 21));// ���á�ѡ����Ʒ�������б�Ŀ��
			sp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					doSpSelectAction();// ��ѡ����Ʒ�������б����¼��ļ���
				}
			});
			setupComponet(sp, 1, 4, 2, 0, true);// ���á�ѡ����Ʒ�������б��λ�ò���ӵ�������
			modifyButton = new JButton("�޸�");// ���޸ġ���ť
			delButton = new JButton("ɾ��");// ��ɾ������ť
			JPanel panel = new JPanel();// ��ť���
			panel.add(modifyButton);// �ѡ��޸ġ���ť�ŵ���ť�����
			panel.add(delButton);// �ѡ�ɾ������ť�ŵ���ť�����
			setupComponet(panel, 3, 4, 1, 0, false);// ���ð�ť����λ�ò���ӵ�������

			delButton.addActionListener(new ActionListener() {// ��ɾ������ť�����¼��ļ���
				public void actionPerformed(ActionEvent e) {
					Item item = (Item) sp.getSelectedItem();// ������ݱ��������
					if (item == null || !(item instanceof Item))// ���ݱ��������Ϊ�ջ����ݱ�������������ݱ������ʵ��
						return;// �˳�����
					int confirm = JOptionPane.showConfirmDialog(serviceitemAlterPanel.this, "ȷ��ɾ��������Ŀ��Ϣ��");// ������ȷ��ɾ����Ʒ��Ϣ�𣿡���ʾ��
					if (confirm == JOptionPane.YES_OPTION) {// �����ȷ�ϡ���
						int rs = DAO.delete("delete serviceItemsinfo where serviceitemId='" + item.getId() + "'");// ���ɾ����Ʒ��Ϣ������
						if (rs > 0) {// ɾ����Ʒ��Ϣ����������0
							JOptionPane.showMessageDialog(serviceitemAlterPanel.this, "������Ŀ��" + item.getName() + "��ɾ���ɹ�");// ������ʾ��
							sp.removeItem(item);// �Ƴ���ѡ����Ʒ�������б�����ƥ������ݱ��������
						}
					}
				}
			});

			modifyButton.addActionListener(new ActionListener() {// ���޸ġ���ť�����¼��ļ���
				public void actionPerformed(ActionEvent e) {
					Item item = (Item) sp.getSelectedItem();// ������ݱ��������
					serviceItemsinfo spInfo = new serviceItemsinfo();// ��Ʒ��Ϣ
					spInfo.setServiceitemId(Integer.valueOf(item.getId()));// ������Ʒ���

					spInfo.setServiceitemClassic(goodClassic.getText().trim());

				
		
					spInfo.setSellingprice(Float.valueOf(price.getText()));

					spInfo.setServiceName(goodname.getText().trim());// ������Ʒ����
					if (DAO.updateSp(spInfo) == 1)// ������Ʒ��Ϣ����������1
						JOptionPane.showMessageDialog(serviceitemAlterPanel.this, "�޸����");// ������ʾ��
					else// ������Ʒ��Ϣ������������1
						JOptionPane.showMessageDialog(serviceitemAlterPanel.this, "�޸�ʧ��");// ������ʾ��
				}
			});    
	   }
	   
	   /**
	   @roseuid 5D0B97BC0125
	    */
	   public void initComboBox() 
	   {// ��ʼ����Ʒ����ѡ���
			List khInfo = DAO.getserviceItemsinfoInfos();// ��ȡ��Ʒ��Ϣ
			List<Item> items = new ArrayList<Item>();// �������ݹ�����ļ���
			sp.removeAllItems();// �Ƴ������б������е���Ʒ����
			for (Iterator iter = khInfo.iterator(); iter.hasNext();) {// ����list����
				List element = (List) iter.next();// ��ü�������һ��Ԫ��
				Item item = new Item();// �������ݱ��������
				item.setId(element.get(0).toString().trim());// ���ñ������
				item.setName(element.get(2).toString().trim());// ����������Ϣ
				if (items.contains(item))// �����а������ݱ��������
					continue;// ��������ѭ��
				items.add(item);// �����в��������ݱ���������򼯺���������ݱ��������
				sp.addItem(item);// �������б���������ݱ��������
			}
			doSpSelectAction();// ��ѡ����Ʒ�������б����¼��ļ���  
	   }
	   
	 
	   /**
	   @param component
	   @param gridx
	   @param gridy
	   @param gridwidth
	   @param ipadx
	   @param fill
	   @roseuid 5D0B97BC0137
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
	   
	   /**
	   @roseuid 5D0B97BC0165
	    */
	   private void doSpSelectAction() 
	   {// ��ѡ����Ʒ�������б����¼��ļ���
			Item selectedItem;// ��ѡ����Ʒ�������б��е�ѡ��
			if (!(sp.getSelectedItem() instanceof Item)) {// ��ѡ����Ʒ�������б��е�ѡ������ݹ������һ��ʵ��
				return;// �˳�Ӧ�ó���
			}
			selectedItem = (Item) sp.getSelectedItem();// ��á�ѡ����Ʒ�������б��е�ѡ��
			serviceItemsinfo spInfo = serviceItemsDAO.getserviceItems(selectedItem);// ��Ʒ��Ϣ
			if (!String.valueOf(spInfo.getServiceitemId()).isEmpty()) {// ��Ʒ��Ų�Ϊ��
				goodname.setText(spInfo.getServiceName());// ���á���Ʒ���ơ��ı����е��ı�����

				goodClassic.setText(spInfo.getServiceitemClassic());// ���á���λ���ı����е��ı�����
		

				price.setText(String.valueOf(spInfo.getSellingprice()));// ���á���ע���ı����е��ı�����
				goodid.setText(String.valueOf(spInfo.getServiceitemId()));
				
		
			}  
	   }

}
