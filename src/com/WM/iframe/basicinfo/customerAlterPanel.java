//Source file: C:\\Users\\ï\\Desktop\\����\\������Ϣϵͳ\\MIS\\CMMIS\\src\\com\\WM\\iframe\\basicinfo\\customerAlterPanel.java

package com.WM.iframe.basicinfo;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import com.WM.dao.DAO;
import com.WM.dao.Model.Item;
import com.WM.dao.Model.customer;

import keyListener.InputKeyListener;

import java.util.List;

public class customerAlterPanel extends JPanel 
{
   
   /**
   �ͻ��޸����
    */
   private JTextField hyName;
   private JTextField hyid;

   /**
   ���ͻ�ȫ�ơ��ı���
    */

   /**
   ����ϵ�绰���ı���
    */
   private JTextField lianXiDianHua;
   
  
   private JButton modifyButton;
   
   /**
   ���޸ġ���ť
    */
   private JButton delButton;
   
   /**
   ��ɾ������ť
    */
   private JComboBox kehu;
   
   /**
   ��ѡ��ͻ��������б�
   @roseuid 5D0B97BA008E
    */
   public customerAlterPanel() 
   {// �ͻ��޸����
		setBounds(10, 10, 460, 300);// ���ÿͻ��޸�����λ������
		setLayout(new GridBagLayout());// ���ÿͻ��޸����Ĳ���Ϊ���񲼾�
		setVisible(true);// ʹ�ͻ��޸����ɼ�
	
		final JLabel khid = new JLabel();// ���ͻ�ȫ�ơ���ǩ
		khid.setText("��Ա��ţ�");// ���á��ͻ�ȫ�ơ���ǩ���ı�����
		setupComponet(khid, 0, 0, 1, 0, false);// ���á��ͻ�ȫ�ơ���ǩ��λ�ò���ӵ�������
		hyid = new JTextField();// ���ͻ�ȫ�ơ��ı���
		hyid.setEditable(false);// ���á��ͻ�ȫ�ơ��ı��򲻿ɱ༭
		setupComponet(hyid, 1, 0, 3, 350, true);// ���á��ͻ�ȫ�ơ��ı����λ�ò���ӵ�������

		
		final JLabel khName = new JLabel();// ���ͻ�ȫ�ơ���ǩ
		khName.setText("��Ա������");// ���á��ͻ�ȫ�ơ���ǩ���ı�����
		setupComponet(khName, 0, 1, 1, 0, false);// ���á��ͻ�ȫ�ơ���ǩ��λ�ò���ӵ�������
		hyName = new JTextField();// ���ͻ�ȫ�ơ��ı���
		hyName.setEditable(false);// ���á��ͻ�ȫ�ơ��ı��򲻿ɱ༭
		setupComponet(hyName, 1, 1, 3, 350, true);// ���á��ͻ�ȫ�ơ��ı����λ�ò���ӵ�������

		
		setupComponet(new JLabel("��ϵ�绰��"), 0, 2, 1, 0, false);// ���á���ϵ�绰����ǩ��λ�ò���ӵ�������
		lianXiDianHua = new JTextField();// ����ϵ�绰���ı���
		setupComponet(lianXiDianHua, 1, 2, 1, 100, true);// ���á���ϵ�绰���ı����λ�ò���ӵ�������
		lianXiDianHua.addKeyListener(new InputKeyListener());// Ϊ����ϵ�绰���ı�����Ӽ��������¼��ļ���

		
		setupComponet(new JLabel("ѡ��ͻ�"), 0, 3, 1, 0, false);// ���á�ѡ��ͻ�����ǩ��λ�ò���ӵ�������
		kehu = new JComboBox();// ��ѡ��ͻ��������б�
		kehu.setPreferredSize(new Dimension(230, 21));// ���á�ѡ��ͻ��������б���
		initComboBox();// ��ʼ������ѡ���
		kehu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doKeHuSelectAction();// Ϊ��ѡ��ͻ��������б���Ӷ����¼��ļ���
			}
		});
		setupComponet(kehu, 1, 3, 2, 0, true);// ���á�ѡ��ͻ��������б��λ�ò���ӵ�������
		modifyButton = new JButton("�޸�");// ���޸ġ���ť
		delButton = new JButton("ɾ��");// ��ɾ������ť
		JPanel panel = new JPanel();// ������
		panel.add(modifyButton);// �����������ӡ��޸ġ���ť
		panel.add(delButton);// �����������ӡ�ɾ������ť
		setupComponet(panel, 0, 4, 1, 0, false);// ���ñ������λ�ò���ӵ�������
		
		delButton.addActionListener(new ActionListener() {// ��ɾ������ť�Ķ����¼��ļ���
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) kehu.getSelectedItem();// ������ݱ��������
				if (item == null || !(item instanceof Item))// ���ݱ��������Ϊ�ջ����ݱ�������������ݱ������ʵ��
					return;// �˳�����
				int confirm = JOptionPane.showConfirmDialog(customerAlterPanel.this, "ȷ��ɾ���ͻ���Ϣ��");// ������ȷ��ɾ���ͻ���Ϣ�𣿡���ʾ��
				if (confirm == JOptionPane.YES_OPTION) {// �����ȷ�ϡ���
					int rs = DAO.delete("delete customer where cardId=" + Integer.valueOf(item.getId()) + ";");// ���ɾ���ͻ���Ϣ������
					if (rs > 0) {// ɾ���ͻ���Ϣ����������0
						JOptionPane.showMessageDialog(customerAlterPanel.this, "�ͻ���" + item.getName() + "��ɾ���ɹ�");// ������ʾ��
						kehu.removeItem(item);// �Ƴ���ѡ��ͻ��������б�����ƥ������ݱ��������
					}
				}
			}
		});
		
		modifyButton.addActionListener(new ActionListener() {// ���޸ġ���ť�Ķ����¼��ļ���
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) kehu.getSelectedItem();// ������ݱ��������
				customer khinfo = new customer();// �ͻ���Ϣ
				khinfo.setCardId(Integer.valueOf(item.getId()));// ���ÿͻ����
			
				khinfo.setUserName(hyName.getText().trim());// ���ÿͻ�����
				
				khinfo.setPhoneNumber(Long.valueOf(lianXiDianHua.getText()));// ������ϵ�绰
				
				if (DAO.updateKeHu(khinfo) == 1)// ���Ŀͻ���Ϣ����������1
					JOptionPane.showMessageDialog(customerAlterPanel.this, "�޸����");// ������ʾ��
				else// ���Ŀͻ���Ϣ������������1
					JOptionPane.showMessageDialog(customerAlterPanel.this, "�޸�ʧ��");// ������ʾ��
			}
		});    
   }
   
   /**
   @roseuid 5D0B97BA0097
    */
   public void initComboBox() 
   {// ��ʼ����ѡ��ͻ��������б�
		List khInfo = DAO.getKhInfos();// ��ȡ�ͻ���Ϣ
		List<Item> items = new ArrayList<Item>();// �������ݹ�����ļ���
		kehu.removeAllItems();// �Ƴ������б������еĿͻ�����
		for (Iterator iter = khInfo.iterator(); iter.hasNext();) {// ����list����
			List element = (List) iter.next();// ��ü�������һ��Ԫ��
			Item item = new Item();// �������ݱ��������
			item.setId(element.get(0).toString().trim());// ���ñ������
			item.setName(element.get(1).toString().trim());// ����������Ϣ
			if (items.contains(item))// �����а������ݱ��������
				continue;// ��������ѭ��
			items.add(item);// �����в��������ݱ���������򼯺���������ݱ��������
			kehu.addItem(item);// �������б���������ݱ��������
		}
		doKeHuSelectAction();// ��ѡ��ͻ��������б����¼��ļ���    
   }
   
   /**
   @param component
   @param gridx
   @param gridy
   @param gridwidth
   @param ipadx
   @param fill
   @roseuid 5D0B97BA00A0
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
   @roseuid 5D0B97BA00EB
    */
   private void doKeHuSelectAction() 
   {
	   // ��ѡ��ͻ��������б����¼��ļ���
		Item selectedItem;// ��ѡ��ͻ��������б��е�ѡ��
		if (!(kehu.getSelectedItem() instanceof Item)) {// ��ѡ��ͻ��������б��е�ѡ������ݹ������һ��ʵ��
			return;// �˳�Ӧ�ó���
		}
		selectedItem = (Item) kehu.getSelectedItem();// ��á�ѡ��ͻ��������б��е�ѡ��
		customer khInfo = DAO.getKhInfo(selectedItem);// �ͻ���Ϣ
		hyName.setText(khInfo.getUserName());// ���á��ͻ�ȫ�ơ��ı����е��ı�����
		hyid.setText(String.valueOf(khInfo.getCardId()));
		lianXiDianHua.setText(String.valueOf(khInfo.getPhoneNumber()));// ���á���ϵ�绰���ı����е��ı�����
		  
   }
}
