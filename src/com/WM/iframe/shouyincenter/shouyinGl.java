//Source file: C:\\Users\\ï\\Desktop\\����\\������Ϣϵͳ\\MIS\\CMMIS\\src\\com\\WM\\iframe\\shouyincenter\\shouyinGl.java

//Source file: C:\\Users\\ï\\Desktop\\����\\������Ϣϵͳ\\cl\\����\\com\\WM\\iframe\\shouyinGl.java

package com.WM.iframe.shouyincenter;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import com.WM.dao.DAO;
import com.WM.dao.billDAO;
import com.WM.dao.goodsDAO;
import com.WM.dao.serviceItemsDAO;
import com.WM.dao.Model.Item;
import com.WM.dao.Model.bill_Detail;
import com.WM.dao.Model.billinfo;
import com.WM.dao.Model.customer;
import com.WM.dao.Model.goodsinfo;
import com.WM.dao.Model.serviceItemsinfo;


public class shouyinGl extends JInternalFrame 
{
   


	private final JTable table;// ���ģ��
	private final JTable table1;// ��Ʒ���ģ��
	private final JTextField billHao = new JTextField();// ������Ʊ�š��ı���
	private final JComboBox kehu = new JComboBox();// ���ͻ��������б�
	private JComboBox sp;// ����Ʒ�������б�
	private Date jzDate;// ���������ڡ�
	private final JTextField billDate = new JTextField();// ������ʱ�䡱�ı���
	private final JTextField zh = new JTextField("0");// ���ۺ���ı���
	private final JTextField zq = new JTextField("0");// ����ǰ���ı���
	private JPopupMenu m_popupMenu;
   /**
   @roseuid 5D0B97C5020B
    */
   public shouyinGl() 
   {
	   // ���������ڲ�����Ĺ��췽��
		super();// ���ø���JInternalFrame�Ĺ�����
		setMaximizable(true);// �������
		setIconifiable(true);// ����ͼ�껯
		setClosable(true);// ���Թر����������ڲ�����
		getContentPane().setLayout(new GridBagLayout());// �������������ڲ�����Ĳ���Ϊ���񲼾�
		setTitle("��������");// �������������ڲ�����ı���
		setBounds(50, 50, 700, 400);// �������������ڲ������λ�úͿ��

		// ��	�˵��źš���ǩ�͡��˵��š��ı���
		setupComponet(new JLabel("�˵��ţ�"), 0, 0, 1, 0, false);
		billHao.setFocusable(false);
		setupComponet(billHao, 1, 0, 1, 140, true);
		
		// ���ͻ�����ǩ�͡��ͻ��������б�
		setupComponet(new JLabel("�ͻ���"), 2, 0, 1, 0, false);
		kehu.setPreferredSize(new Dimension(160, 21));
		kehu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doKhSelectAction();// ���ͻ��������б��ѡ���¼�
			}
		});
		setupComponet(kehu, 3, 0, 1, 1, true);
		// ������ʱ�䡱��ǩ�͡�����ʱ�䡱�ı���
		setupComponet(new JLabel("����ʱ�䣺"), 2, 1, 1, 0, false);
		billDate.setFocusable(false);
		setupComponet(billDate, 3, 1, 1, 1, true);
		
		// ����Ʒ�������б�
		sp = new JComboBox();
		sp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String info = (String) sp.getSelectedItem();
				//System.out.println(info);
				if (info != null ) {
					updateTable();// ���ѡ����Ч�͸��±��
				}
			}
		});
		
		// ���ģ��
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// ���Զ������еĿ�ȣ�ʹ�ù�����
		initTable();
		
		// ���ģ��
		table1 = new JTable();
		//table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// ���Զ������еĿ�ȣ�ʹ�ù�����
		initTable1();
		JScrollPane scrollPanel1 = new JScrollPane(table1);
		scrollPanel1.setPreferredSize(new Dimension(75, 95));
		setupComponet(scrollPanel1, 0, 2, 2, 0, true);
		
		// ����¼����Ʒ����������Ʒ�������ϼƽ��ļ���
		table.addContainerListener(new computeInfo());
		JScrollPane scrollPanel = new JScrollPane(table);
		scrollPanel.setPreferredSize(new Dimension(300, 200));
		setupComponet(scrollPanel, 2, 2, 4, 0, true);
		
		// ����ǰ����ǩ�͡���ǰ���ı���
		setupComponet(new JLabel("��ǰ��"), 0, 3, 1, 0, false);
		zq.setFocusable(false);
		zq.setSelectionColor(getForeground());
		setupComponet(zq, 1, 3, 1, 1, true);
		// ���ۺ�Ӧ�ա���ǩ�͡��ۺ�Ӧ�ա��ı���
		setupComponet(new JLabel("�ۺ�Ӧ�գ�"), 2, 3, 1, 0, false);
		zh.setFocusable(false);
		setupComponet(zh, 3, 3, 1, 1, true);
		
		
		// ����ӡ���ť
		JButton tjButton = new JButton("���");
		tjButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ��ʼ���˵���
				initBillHao();
				// ���������û�б�д�ĵ�Ԫ
				stopTableCellEditing();
				// �������л��������У������������
				for (int i = 0; i < table.getRowCount(); i++) {
					//goodsinfo info = (goodsinfo) table.getValueAt(i, 0);
					if (table.getValueAt(i, 0) == null)
						return;
				}
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Vector());
			}
		});
		setupComponet(tjButton, 3, 4, 1, 1, false);
		
		// ���ҵ����ᡱ��ť
		JButton gddjButton = new JButton("�ҵ�����");
		gddjButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopTableCellEditing();// ���������û�б�д�ĵ�Ԫ
				clearEmptyRow();// �������

				float jeStr = Float.valueOf(zh.getText());// �ϼƽ��



				String rkDate = jzDate.toLocaleString();// ����ʱ��
	
				
				String kehuName = kehu.getSelectedItem().toString();// �ͻ�����

				if (table.getRowCount() <= 0) {
					JOptionPane.showMessageDialog(shouyinGl.this, "����ӽ�����Ʒ");
					return;
				}
				String id = DAO.getgdMainMaxId(new java.sql.Date(System.currentTimeMillis()));
				billinfo sellMain = new billinfo(id,jeStr,kehuName,rkDate);// ��������
				Set <bill_Detail> set1 = sellMain.getbillDetails();// ���������ϸ�ļ���
				int rows = table.getRowCount();
				for (int i = 0; i<rows; i++) {
					String spname = (String) table.getValueAt(i, 0);
					String djStr = (String) table.getValueAt(i, 1);
					String slStr = (String) table.getValueAt(i, 2);
					float discount=Float.valueOf( (String) table.getValueAt(i, 3));
					Double sprice= (Double) table.getValueAt(i, 4);
					Double dj = Double.valueOf(djStr);
					Integer sl = Integer.valueOf(slStr);
					bill_Detail detail = new bill_Detail();// ������ϸ
					Item i1=new Item();
					i1.setName(spname);
					detail.setSpname(spname);
					i1.setId(null);
					
					goodsinfo spinfo = null;
					serviceItemsinfo spinfo1=null;
					
					if(goodsDAO.getgoods(i1)!=null  ) {
						spinfo=goodsDAO.getgoods(i1);
						detail.setSpid(String.valueOf(spinfo.getGoodsId()));// ��ˮ��
						detail.setSpname(spinfo.getGoodsName());
						
					
					}
					if(serviceItemsDAO.getserviceItems(i1)!=null){
						 spinfo1=serviceItemsDAO.getserviceItems(i1);
						detail.setSpid(String.valueOf(spinfo1.getServiceitemId()));// ��ˮ��
						detail.setSpname(spinfo1.getServiceName());
						
					}
					
					
					//detail.setSpid(String.valueOf(sellMain.getBillId()));// ��������
					detail.setDj(dj);// ���۵���
					detail.setSl(sl);// ��������
					detail.setDiscount(discount);
					detail.setSprice(sprice);
					set1.add(detail);// ��������ϸ��ӵ�������ϸ�ļ�����
				}
				boolean rs = DAO.insertgdInfo(sellMain);// ��ӹҵ���Ϣ
				if (rs) {
					JOptionPane.showMessageDialog(shouyinGl.this, "���˵��Ѽ���ҵ��б�");
					DefaultTableModel dftm = new DefaultTableModel();
					table.setModel(dftm);
					initTable();
					zq.setText("0");
			
					zh.setText("0");
				}
			}
			
		});
		setupComponet(gddjButton, 4, 4, 1, 1, false);
		
		// �����ۡ���ť
		JButton sellButton = new JButton("����");
		sellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopTableCellEditing();// ���������û�б�д�ĵ�Ԫ
				clearEmptyRow();// �������

				float jeStr = Float.valueOf(zh.getText());// �ϼƽ��



				String rkDate = jzDate.toLocaleString();// ����ʱ��
	
				String id = billHao.getText();// Ʊ��
				String kehuName = kehu.getSelectedItem().toString();// �ͻ�����

				if (table.getRowCount() <= 0) {
					JOptionPane.showMessageDialog(shouyinGl.this, "����ӽ�����Ʒ");
					return;
				}
				billinfo sellMain = new billinfo(id,jeStr,kehuName,rkDate);// ��������
				Set <bill_Detail> set1 = sellMain.getbillDetails();// ���������ϸ�ļ���
				int rows = table.getRowCount();
				for (int i = 0; i<rows; i++) {
					String spname = (String) table.getValueAt(i, 0);
					String djStr = (String) table.getValueAt(i, 1);
					String slStr = (String) table.getValueAt(i, 2);
					float discount=Float.valueOf( (String) table.getValueAt(i, 3));
					Double sprice= (Double) table.getValueAt(i, 4);
					Double dj = Double.valueOf(djStr);
					Integer sl = Integer.valueOf(slStr);
					bill_Detail detail = new bill_Detail();// ������ϸ
					Item i1=new Item();
					i1.setName(spname);
					detail.setSpname(spname);
					i1.setId(null);
					
					goodsinfo spinfo = null;
					serviceItemsinfo spinfo1=null;
					
					if(goodsDAO.getgoods(i1)!=null  ) {
						spinfo=goodsDAO.getgoods(i1);
						detail.setSpid(String.valueOf(spinfo.getGoodsId()));// ��ˮ��
						detail.setSpname(spinfo.getGoodsName());
						
					
					}
					if(serviceItemsDAO.getserviceItems(i1)!=null){
						 spinfo1=serviceItemsDAO.getserviceItems(i1);
						detail.setSpid(String.valueOf(spinfo1.getServiceitemId()));// ��ˮ��
						detail.setSpname(spinfo1.getServiceName());
						
					}
					
					
					//detail.setSpid(String.valueOf(sellMain.getBillId()));// ��������
					detail.setDj(dj);// ���۵���
					detail.setSl(sl);// ��������
					detail.setDiscount(discount);
					detail.setSprice(sprice);
					set1.add(detail);// ��������ϸ��ӵ�������ϸ�ļ�����
				}
				boolean rs = billDAO.insertSellInfo(sellMain);// ���������Ϣ
				if (rs) {
					JOptionPane.showMessageDialog(shouyinGl.this, "�������");
					DefaultTableModel dftm = new DefaultTableModel();
					table.setModel(dftm);
					initTable();
					zq.setText("0");
			
					zh.setText("0");
				}
			}
		});
		setupComponet(sellButton, 5, 4, 1, 1, false);
		
		// ��Ӵ������������ɳ�ʼ��
		addInternalFrameListener(new initTasks());    
   }
   
   /**
   ֹͣ���Ԫ�ı༭
   @roseuid 5D0B97C50214
    */
   private void stopTableCellEditing() 
   {
		TableCellEditor cellEditor = table.getCellEditor();
		if (cellEditor != null)
			cellEditor.stopCellEditing();    
   }
   
   /**
   ������Ʒ�����б����±��ǰ�е�����
   @roseuid 5D0B97C50221
    */
   private synchronized void updateTable() 
   {
		
		goodsinfo spinfo =  new goodsinfo();
		String spNmae = (String) sp.getSelectedItem();
		
		
		ResultSet set = DAO.query(" select * from goodsinfo" + " where goodsName='"+spNmae+"';");
		try {
			while (set.next()) {
				
				spinfo.setGoodsId(set.getInt("goodsId"));
				spinfo.setGoodsName(set.getString("goodsName").trim());
				spinfo.setSellingprice(set.getFloat("sellingprice"));
				//System.out.println(spinfo);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//double qmoney = 0,hmoney = 0.0;
		int row = table.getSelectedRow();
		if (row >= 0 && spinfo != null) {
			
			table.setValueAt(spinfo.getGoodsName(), row, 0);
			table.setValueAt(String.valueOf(spinfo.getSellingprice()), row, 1);
			table.setValueAt("1", row, 2);
			table.setValueAt("1",row, 3);
			String column4= String.valueOf(spinfo.getSellingprice());
			String column5 = (String) table.getValueAt(row, 2);
			String column6 = (String) table.getValueAt(row, 3);
			int c5 = (column5 == null || column5.isEmpty()) ? 0 : Integer.valueOf(column5);
			Double c4 = (String.valueOf(column4)== null ) ? 0 : Double.valueOf(column4);
			Double c6 = (column6 == null || column6.isEmpty()) ? 1 : Double.valueOf(column6);
			
			table.setValueAt(c5*c4*c6,row, 4);
		//	qmoney += c5 * c4;
		//	hmoney +=c5 * c4*c6;
			
		}

		ContainerEvent e = null;
		new computeInfo().componentRemoved(e);    
   }
   
   /**
   ��ʼ����Ʒ�����б�
   @roseuid 5D0B97C5022D
    */
   private void initSpBox() 
   {
		List list = new ArrayList();
		ResultSet set = DAO.query(" select * from goodsinfo" + " where Stock>0");
		sp.removeAllItems();
		//sp.addItem(new goodsinfo());
		for (int i = 0; table != null && i < table.getRowCount(); i++) {
			goodsinfo tmpInfo = (goodsinfo) table.getValueAt(i, 0);
			if (tmpInfo != null && String.valueOf(tmpInfo.getGoodsId()) != null)
				list.add(tmpInfo.getGoodsId());
		}
		try {
			while (set.next()) {
				goodsinfo spinfo = new goodsinfo();
				spinfo.setGoodsId(set.getInt("goodsId"));
				
				// ���������Դ���ͬ����Ʒ����Ʒ�������оͲ��ٰ�������Ʒ
				if (list.contains(spinfo.getGoodsId()))
					continue;
				spinfo.setGoodsName(set.getString("goodsName").trim());
				spinfo.setSellingprice(set.getFloat("sellingprice"));
				///System.out.println(set.getString("goodsName").trim()+spinfo.getName());

				sp.addItem(spinfo.getGoodsName());
			}
			//System.out.print(sp);
		} catch (SQLException e) {
			e.printStackTrace();
		}    
   }
   
   /**
   ��ʼ�����˵��š�
   @roseuid 5D0B97C50239
    */
   private void initBillHao() 
   {
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		String maxId = DAO.getSellMainMaxId(date);
		billHao.setText(maxId);    
   }
   
   /**
   �������
   @roseuid 5D0B97C5024D
    */
   private synchronized void clearEmptyRow() 
   {
		DefaultTableModel dftm = (DefaultTableModel) table.getModel();
		for (int i = 0; i < table.getRowCount(); i++) {
			String info2 = (String) table.getValueAt(i, 0);
			if (info2 == null ) {
				dftm.removeRow(i);
			}
		}    
   }
   
   /**
   ��ʼ�����
   @roseuid 5D0B97C50259
    */
   private void initTable() 
   {
		String[] columnNames = { "����","����", "����", "�ۿ�", "�ۺ��"};
		((DefaultTableModel) table.getModel()).setColumnIdentifiers(columnNames);
		TableColumn column = table.getColumnModel().getColumn(0);
		final DefaultCellEditor editor = new DefaultCellEditor(sp);
		editor.setClickCountToStart(2);
		column.setCellEditor(editor);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
		
		     //�ж��Ƿ�Ϊ����BUTTON3��ť��BUTTON3Ϊ����Ҽ�
	        if (e.getButton() == java.awt.event.MouseEvent.BUTTON3) {
	            //ͨ�����λ���ҵ����Ϊ����е���
	            int focusedRowIndex = table.rowAtPoint(e.getPoint());
	            if (focusedRowIndex == -1) {
	                return;
	            }

	            //�������ѡ����Ϊ��ǰ�Ҽ��������
	            table.setRowSelectionInterval(focusedRowIndex, focusedRowIndex);
	            //�����˵�
	            m_popupMenu.show(table, e.getX(), e.getY());

	        }
		  }
			
		});    
   }
   
   /**
   ��ʼ��������Ŀ���
   @roseuid 5D0B97C50267
    */
   private void initTable1() 
   {
		String[] columnNames = { "��������","�۸�"};
		((DefaultTableModel) table1.getModel()).setColumnIdentifiers(columnNames);
		
		serviceItemsinfo  fuwuinfo = new serviceItemsinfo();
		table1.setEnabled(false);
		ResultSet set = DAO.query(" select serviceName,sellingprice from serviceItemsinfo;");
		try {
			int row=0;
			while (set.next()) {
				
				fuwuinfo.setServiceName(set.getString("serviceName").trim());

				fuwuinfo.setSellingprice(set.getFloat(2));
				DefaultTableModel model = (DefaultTableModel) table1.getModel();
				model.addRow(new Vector());
				table1.setValueAt(fuwuinfo.getServiceName(), row,0);
				table1.setValueAt(fuwuinfo.getSellingprice(), row,1);
				row++;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		table1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					int row=((JTable)e.getSource()).rowAtPoint(e.getPoint());
					String sname=(String)(table1.getValueAt(row, 0));
					String sprice=String.valueOf(table1.getValueAt(row, 1));

					int cr=table.getRowCount();
					//System.out.println(cr);
					//cr++;
					//System.out.println("+"+cr);
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.addRow(new Vector());
					table.setValueAt(sname, cr, 0);
					table.setValueAt(sprice, cr, 1);
					table.setValueAt("1", cr, 2);
					table.setValueAt("1", cr, 3);
					
					ContainerEvent e1 = null;
					new computeInfo().componentRemoved(e1);
					
				}else
					return;

	
			}
			
		});    
   }
   
   /**
   �Ҽ�ɾ���˵�
   @roseuid 5D0B97C50274
    */
   private void createPopupMenu() 
   {
        m_popupMenu = new JPopupMenu();
        
        JMenuItem delMenItem = new JMenuItem();
        delMenItem.setText("  ɾ��  ");
        delMenItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.removeRow(table.getSelectedRow());
				//System.out.println(evt);
            }
        });

        JMenuItem AddMenItem = new JMenuItem();
        AddMenItem.setText("  ���  ");
        AddMenItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
				// ��ʼ���˵���
				initBillHao();
				// ���������û�б�д�ĵ�Ԫ
				stopTableCellEditing();
				// �������л��������У������������
				for (int i = 0; i < table.getRowCount(); i++) {
					
					if (table.getValueAt(i, 0) == null)
						return;
				}
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Vector());
            }
        });
        m_popupMenu.add(AddMenItem);    
        m_popupMenu.add(delMenItem); 
   }
   
   /**
   ��Ӧ��ѡ��ʱ������ϵ���ֶ�
   @roseuid 5D0B97C50281
    */
   private void doKhSelectAction() 
   {
		/*Item item = (Item) kehu.getSelectedItem();
		customer khInfo = DAO.getKhInfo(item);
		kh.setText(khInfo.getLian());  */
   }
   
   /**
   �������λ�ò���ӵ�������
   @param component
   @param gridx
   @param gridy
   @param gridwidth
   @param ipadx
   @param fill
   @roseuid 5D0B97C5028D
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
   ����ĳ�ʼ������
    */
   private final class initTasks extends InternalFrameAdapter 
   {
      
      /**
      @param e
      @roseuid 5D0B97C502EF
       */
      public void internalFrameActivated(InternalFrameEvent e) 
      {
			super.internalFrameActivated(e);
			initTimeField();
			initKehuField();
			initBillHao();
			initSpBox();
			createPopupMenu();       
      }
      
      /**
      ��ʼ���ͻ��ֶ�
      @roseuid 5D0B97C50304
       */
      private void initKehuField() 
      {
			List customer = DAO.getKhInfos();
			for (Iterator iter = customer.iterator(); iter.hasNext();) {
				List list = (List) iter.next();
				Item item = new Item();
				item.setId(String.valueOf(list.get(0)));
				item.setName(list.get(1).toString().trim());
				kehu.addItem(item);
				
			}
			//doKhSelectAction();       
      }
      
      /**
      ��������ʱ���߳�
      @roseuid 5D0B97C50310
       */
      private void initTimeField() 
      {
			new Thread(new Runnable() {
				public void run() {
					try {
						while (true) {
							jzDate = new Date();
							billDate.setText(jzDate.toLocaleString());
							Thread.sleep(100);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();       
      }
   }
   
   /**
   ����Ʒ����������Ʒ�������ϼƽ��
    */
   private final class computeInfo implements ContainerListener 
   {
      
      /**
      @param e
      @roseuid 5D0B97C5034C
       */
      public void componentRemoved(ContainerEvent e) 
      {
			// �������
			clearEmptyRow();
			// �������
			int rows = table.getRowCount();
			int count = 0;
			double qmoney = 0,hmoney = 0.0;
			
			// �����Ʒ�����ͽ��
			for (int i = 0; i < rows; i++) {
				//System.out.println(table.getValueAt(i, 1).getClass());
				String column4= (String)table.getValueAt(i, 1);
				String column5 = (String) table.getValueAt(i, 2);
				String column6 = (String) table.getValueAt(i, 3);
				int c5 = (column5 == null || column5.isEmpty()) ? 0 : Integer.valueOf(column5);
				Double c4 = (column4 == null  ) ? 0 : Double.valueOf(column4);
				Double c6 = (column6 == null || column6.isEmpty()) ? 1 : Double.valueOf(column6);
				//count += c7;
				qmoney += c5 * c4;
				hmoney +=c5 * c4*c6;

				table.setValueAt(c5*c4*c6,i, 4);
			}
			zq.setText(qmoney + "");
			zh.setText(hmoney + "");       
      }
      
      /**
      @param e
      @roseuid 5D0B97C50363
       */
      public void componentAdded(ContainerEvent e) 
      {
       
      }
   }
}
