//Source file: C:\\Users\\ï\\Desktop\\����\\������Ϣϵͳ\\MIS\\CMMIS\\src\\com\\WM\\iframe\\infoQuery\\goodsQuery.java

package com.WM.iframe.infoQuery;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import com.WM.dao.DAO;
import com.WM.dao.goodsDAO;
import com.WM.dao.Model.Item;
import com.WM.dao.Model.goodsinfo;


public class goodsQuery extends JInternalFrame 
{
   
   /**
   ��Ʒ��ѯ�ڲ�����
    */
   private JTable table;
   
   /**
   ���ģ��
    */
   private JTextField conditionContent;
   
   /**
   ���������ݡ��ı���
    */
   private JComboBox conditionOperation;
   
   /**
   ���������㡱�����б�
    */
   private JComboBox conditionName;
   
   /**
   ���������ơ������б�
   @roseuid 5D0B97BF00BA
    */
   public goodsQuery() 
   {// ��Ʒ��ѯ�ڲ�����Ĺ��췽��
		super();// ���ø���JInternalFrame�Ĺ��췽��
		setIconifiable(true);// ����ͼ�껯
		setClosable(true);// ���Թر�
		setTitle("��Ʒ��Ϣ��ѯ");// ������Ʒ��ѯ�ڲ�����ı���
		getContentPane().setLayout(new GridBagLayout());// ������Ʒ��ѯ�ڲ�����Ĳ���Ϊ���񲼾�
		setBounds(100, 100, 650, 375);// ������Ʒ��ѯ�ڲ������λ�úͿ��
		// ���ģ��
		table = new JTable();
		table.setEnabled(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);// ���Զ������еĿ�ȣ�ʹ�ù�����
		final DefaultTableModel dftm = (DefaultTableModel) table.getModel();
		String[] tableHeads = new String[]{"��Ʒ���","��Ʒ���","��Ʒ����", "����",
				 "����"};
		dftm.setColumnIdentifiers(tableHeads);
		// �������
		final JScrollPane scrollPane = new JScrollPane(table);
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.weighty = 1.0;
		gridBagConstraints_6.anchor = GridBagConstraints.NORTH;
		gridBagConstraints_6.insets = new Insets(0, 10, 0, 10);
		gridBagConstraints_6.fill = GridBagConstraints.BOTH;
		gridBagConstraints_6.gridwidth = 6;
		gridBagConstraints_6.gridy = 1;
		gridBagConstraints_6.gridx = 0;
		getContentPane().add(scrollPane, gridBagConstraints_6);
		// ��ѡ���ѯ��������ǩ�͡��������ơ������б�
		setupComponet(new JLabel(" ѡ���ѯ������"), 0, 0, 1, 1, false);
		conditionName = new JComboBox();
		conditionName.setModel(new DefaultComboBoxModel(new String[]{"��Ʒ����", "��Ʒ���"}));
		setupComponet(conditionName, 1, 0, 1, 30, true);
		// ���������㡱�����б�
		conditionOperation = new JComboBox();
		conditionOperation.setModel(new DefaultComboBoxModel(new String[]{"����", "����"}));
		setupComponet(conditionOperation, 2, 0, 1, 30, true);
		// ���������ݡ��ı���
		conditionContent = new JTextField();
		setupComponet(conditionContent, 3, 0, 1, 140, true);
		// ����ѯ����ť
		final JButton queryButton = new JButton();
		queryButton.addActionListener(new QueryAction(dftm));
		setupComponet(queryButton, 4, 0, 1, 1, false);
		queryButton.setText("��ѯ");
		// ����ʾȫ�����ݡ���ť
		final JButton showAllButton = new JButton();
		showAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				conditionContent.setText("");
				List list = goodsDAO.getgoodsinfo();
				updateTable(list, dftm);
			}
		});
		setupComponet(showAllButton, 5, 0, 1, 1, false);
		showAllButton.setText("��ʾȫ������");    
   }
   
   /**
   �������ʾȫ�����ݡ���ť�󣬸��±������
   @param list
   @param dftm
   @roseuid 5D0B97BF00C5
    */
   private void updateTable(List list, final DefaultTableModel dftm) 
   {
		int num = dftm.getRowCount();
		for (int i = 0; i < num; i++)
			dftm.removeRow(0);
		Iterator iterator = list.iterator();
		goodsinfo spInfo;// ��Ʒ��Ϣ
		while (iterator.hasNext()) {
			List info = (List) iterator.next();
			Item item = new Item();
			item.setId((String) info.get(0));
			item.setName((String) info.get(1));
			spInfo = goodsDAO.getgoods(item);
			Vector rowData = new Vector();
			rowData.add(spInfo.getGoodsId());// ��Ʒ���
			rowData.add(spInfo.getGoodsClassic());// ��Ʒ���
			rowData.add(spInfo.getGoodsName().trim());// ��Ʒ����
			
			
			rowData.add(spInfo.getSellingprice());//����
			rowData.add(spInfo.getStock());// ����
			

			dftm.addRow(rowData);// ���������������ݣ���Ʒ��Ϣ��
		}    
   }
   
   /**
   �������λ�ò���ӵ�������
   @param component
   @param gridx
   @param gridy
   @param gridwidth
   @param ipadx
   @param fill
   @roseuid 5D0B97BF00F6
    */
   private void setupComponet(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) 
   {
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();
		gridBagConstrains.gridx = gridx;
		gridBagConstrains.gridy = gridy;
		if (gridwidth > 1)
			gridBagConstrains.gridwidth = gridwidth;
		if (ipadx > 0)
			gridBagConstrains.ipadx = ipadx;
		gridBagConstrains.insets = new Insets(5, 1, 3, 1);
		if (fill)
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(component, gridBagConstrains);    
   }
   
   /**
   ������ѯ
    */
   private final class QueryAction implements ActionListener 
   {
      private final DefaultTableModel dftm;
      
      /**
      @param dftm
      @roseuid 5D0B97BF0176
       */
      private QueryAction(DefaultTableModel dftm) 
      {
			this.dftm = dftm;       
      }
      
      /**
      @param e
      @roseuid 5D0B97BF018D
       */
      public void actionPerformed(final ActionEvent e) 
      {
			String conName, conOperation, content;
			conName = conditionName.getSelectedItem().toString().trim();
			conOperation = conditionOperation.getSelectedItem().toString();
			content = conditionContent.getText().trim();
			List list = null;
			list = searchInfo(conName, conOperation, content, list);
			updateTable(list, dftm);       
      }
      
      /**
      ƴ��SQL��䣬�����ִ��SQL������Ӧ�Ľ����
      @param conName
      @param conOperation
      @param content
      @param list
      @return java.awt.AccessibleAWTList.AccessibleAWTListChild.List
      @roseuid 5D0B97BF01A3
       */
      private List searchInfo(String conName, String conOperation, String content, List list) 
      {
			String sql = "select * from goodsinfo where ";
			if (conOperation.equals("����")) {
				if (conName.equals("��Ʒ����"))
					list = DAO.findForList(sql + "goodsName='" + content + "'");
				if (conName.equals("��Ʒ���"))
					list = DAO.findForList(sql + "goodsClassic='" + content + "'");
				
			} else {
				if (conName.equals("��Ʒ����"))
					list = DAO.findForList(sql + "goodsName like '%" + content
							+ "%'");
				if (conName.equals("��Ʒ���"))
					list = DAO.findForList(sql + "goodsClassic like '%" + content
							+ "%'");
				
			}
			return list;       
      }
   }
}
