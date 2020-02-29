//Source file: C:\\Users\\ï\\Desktop\\����\\������Ϣϵͳ\\MIS\\CMMIS\\src\\com\\WM\\iframe\\infoQuery\\sellsortQuery.java

package com.WM.iframe.infoQuery;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import com.WM.dao.DAO;

public class sellsortQuery extends JInternalFrame 
{
   
   /**
   ����ģ�͵�ʵ������
    */
   private Calendar date = Calendar.getInstance();
   
   /**
   ���������ڲ�����
    */
   private JButton okButton;
   
   /**
   ��ȷ������ť
    */
   private JComboBox month;
   
   /**
   ���¡������б�
    */
   private JComboBox year;
   
   /**
   ���ꡱ�����б�
    */
   private JTable table;
   
   /**
   ����ģ��
    */
   private JComboBox operation;
   
   /**
   ���������㡱�����б�
    */
   private JComboBox condition;
   
   /**
   ���������ݡ������б�
   private TbJsr user;// ��������Ϣ
    */
   private DefaultTableModel dftm;
   
   /**
   �����ڡ�����
   @roseuid 5D0B97C003DC
    */
   public sellsortQuery() 
   {// ���������ڲ�����Ĺ��췽��
		setIconifiable(true);// ����ͼ�껯
		setClosable(true);// ���Թرմ���
		setTitle("��������");// �������������ڲ�����ı���
		getContentPane().setLayout(new GridBagLayout());// �������������ڲ�����Ĳ���Ϊ���񲼾�
		setBounds(100, 100, 700, 375);// �������������ڲ������λ�úͿ���
		// ���ԡ���ǩ
		final JLabel label_1 = new JLabel();
		label_1.setText("��");
		final GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();
		gridBagConstraints_8.anchor = GridBagConstraints.EAST;
		gridBagConstraints_8.gridy = 0;
		gridBagConstraints_8.gridx = 0;
		getContentPane().add(label_1, gridBagConstraints_8);
		// ���ꡱ�����б�
		year = new JComboBox();
		for (int i = 1981, j = 0; i <= date.get(Calendar.YEAR) + 1; i++, j++) {
			year.addItem(i);
			if (i == date.get(Calendar.YEAR))
				year.setSelectedIndex(j);
		}
		year.setPreferredSize(new Dimension(100, 21));
		setupComponet(year, 1, 0, 1, 90, true);
		// ���ꡱ��ǩ
		setupComponet(new JLabel("��"), 2, 0, 1, 1, false);
		// ���¡������б�
		month = new JComboBox();
		for (int i = 1; i <= 12; i++) {
			month.addItem(String.format("%02d", i));
			if (date.get(Calendar.MONTH) == i)
				month.setSelectedIndex(i - 1);
		}
		month.setPreferredSize(new Dimension(100, 21));
		setupComponet(month, 3, 0, 1, 30, true);
		// ���·ݵ�������Ϣ��������ǩ
		setupComponet(new JLabel(" �·ݵ�������Ϣ����"), 4, 0, 1, 1, false);
		condition = new JComboBox();
		condition.setModel(new DefaultComboBoxModel(new String[]{"���", "����"}));
		setupComponet(condition, 5, 0, 1, 30, true);
		// �����С���ǩ
		setupComponet(new JLabel(" ����"), 6, 0, 1, 1, false);
		// ���������㡱�����б�
		operation = new JComboBox();
		operation.setModel(new DefaultComboBoxModel(
				new String[]{"��������", "��������"}));
		setupComponet(operation, 7, 0, 1, 30, true);
		// ��ȷ������ť
		okButton = new JButton();
		okButton.addActionListener(new OkAction());
		setupComponet(okButton, 8, 0, 1, 1, false);
		okButton.setText("ȷ��");
		// �������
		final JScrollPane scrollPane = new JScrollPane();
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.weighty = 1.0;
		gridBagConstraints_6.anchor = GridBagConstraints.NORTH;
		gridBagConstraints_6.insets = new Insets(0, 10, 5, 10);
		gridBagConstraints_6.fill = GridBagConstraints.BOTH;
		gridBagConstraints_6.gridwidth = 9;
		gridBagConstraints_6.gridy = 1;
		gridBagConstraints_6.gridx = 0;
		getContentPane().add(scrollPane, gridBagConstraints_6);
		// ����ģ��
		table = new JTable();
		table.setEnabled(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);// ���Զ������еĿ��ȣ�ʹ�ù�����
		dftm = (DefaultTableModel) table.getModel();
		String[] tableHeads = new String[]{ "��Ʒ����", "���۽��", "��������",
				 };
		dftm.setColumnIdentifiers(tableHeads);
		scrollPane.setViewportView(table);    
   }
   
   /**
   ���ı�������
   @param iterator
   @roseuid 5D0B97C1001A
    */
   private void updateTable(Iterator iterator) 
   {
	   int rowCount = dftm.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			dftm.removeRow(0);
		}
		while (iterator.hasNext()) {
			Vector vector = new Vector();
			List view = (List) iterator.next();
			Vector row=new Vector(view);
			int rowSize = row.size();
			for(int i=rowSize-2;i<rowSize;i++){
				Object colValue = row.get(i);
				row.remove(i);
				row.insertElementAt(colValue, 2);
			}
			vector.addAll(row);
			dftm.addRow(vector);
		}
    
   }
   
   /**
   �������λ�ò����ӵ�������
   @param component
   @param gridx
   @param gridy
   @param gridwidth
   @param ipadx
   @param fill
   @roseuid 5D0B97C10032
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
   �����ȷ������ť�󣬷������¼�
    */
   private final class OkAction implements ActionListener 
   {
      
      /**
      @param e
      @roseuid 5D0B97C1008C
       */
      public void actionPerformed(final ActionEvent e) 
      {
			List list = null;
			String strMonth = (String) month.getSelectedItem();
			String date = year.getSelectedItem() + strMonth;
			String con = condition.getSelectedIndex() == 0 ? "sumje " : "sl ";
			int oper = operation.getSelectedIndex();
			String opstr = oper == 0 ? " asc" : " desc";
			String sql1 = "select spname,sum(sl)as sl,sum(sl*dj) as sumje from"
					+ " v_billsort where substring(convert(varchar(30)"
					+ ",date,112),0,7)='" + date + "' group by spname order by "+ con + opstr;
			
			list = DAO.findForList(sql1);
			Iterator iterator = list.iterator();
			updateTable(iterator);    
      }
   }
}
//void sellsortQuery.updateTable(java.util.TreeMap.Iterator){
//		int rowCount = dftm.getRowCount();
//		for (int i = 0; i < rowCount; i++) {
//			dftm.removeRow(0);
//		}
//		while (iterator.hasNext()) {
//			Vector vector = new Vector();
//			List view = (List) iterator.next();
//			Vector row=new Vector(view);
//			int rowSize = row.size();
//			for(int i=rowSize-2;i<rowSize;i++){
//				Object colValue = row.get(i);
//				row.remove(i);
//				row.insertElementAt(colValue, 2);
//			}
//			vector.addAll(row);
//			dftm.addRow(vector);
//		}
//	}