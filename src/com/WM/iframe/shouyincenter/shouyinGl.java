//Source file: C:\\Users\\茂\\Desktop\\课设\\管理信息系统\\MIS\\CMMIS\\src\\com\\WM\\iframe\\shouyincenter\\shouyinGl.java

//Source file: C:\\Users\\茂\\Desktop\\课设\\管理信息系统\\cl\\代码\\com\\WM\\iframe\\shouyinGl.java

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
   


	private final JTable table;// 表格模型
	private final JTable table1;// 商品表格模型
	private final JTextField billHao = new JTextField();// “销售票号”文本框
	private final JComboBox kehu = new JComboBox();// “客户”下拉列表
	private JComboBox sp;// “商品”下拉列表
	private Date jzDate;// “结账日期”
	private final JTextField billDate = new JTextField();// “结账时间”文本框
	private final JTextField zh = new JTextField("0");// “折后金额”文本框
	private final JTextField zq = new JTextField("0");// “折前”文本框
	private JPopupMenu m_popupMenu;
   /**
   @roseuid 5D0B97C5020B
    */
   public shouyinGl() 
   {
	   // 收银中心内部窗体的构造方法
		super();// 调用父类JInternalFrame的构造器
		setMaximizable(true);// 可以最大化
		setIconifiable(true);// 可以图标化
		setClosable(true);// 可以关闭收银中心内部窗体
		getContentPane().setLayout(new GridBagLayout());// 设置收银中心内部窗体的布局为网格布局
		setTitle("收银中心");// 设置收银中心内部窗体的标题
		setBounds(50, 50, 700, 400);// 设置收银中心内部窗体的位置和宽高

		// “	账单号号”标签和“账单号”文本框
		setupComponet(new JLabel("账单号："), 0, 0, 1, 0, false);
		billHao.setFocusable(false);
		setupComponet(billHao, 1, 0, 1, 140, true);
		
		// “客户”标签和“客户”下拉列表
		setupComponet(new JLabel("客户："), 2, 0, 1, 0, false);
		kehu.setPreferredSize(new Dimension(160, 21));
		kehu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doKhSelectAction();// “客户”下拉列表的选择事件
			}
		});
		setupComponet(kehu, 3, 0, 1, 1, true);
		// “销售时间”标签和“销售时间”文本框
		setupComponet(new JLabel("销售时间："), 2, 1, 1, 0, false);
		billDate.setFocusable(false);
		setupComponet(billDate, 3, 1, 1, 1, true);
		
		// “商品”下拉列表
		sp = new JComboBox();
		sp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String info = (String) sp.getSelectedItem();
				//System.out.println(info);
				if (info != null ) {
					updateTable();// 如果选择有效就更新表格
				}
			}
		});
		
		// 表格模型
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 不自动调整列的宽度，使用滚动条
		initTable();
		
		// 表格模型
		table1 = new JTable();
		//table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 不自动调整列的宽度，使用滚动条
		initTable1();
		JScrollPane scrollPanel1 = new JScrollPane(table1);
		scrollPanel1.setPreferredSize(new Dimension(75, 95));
		setupComponet(scrollPanel1, 0, 2, 2, 0, true);
		
		// 添加事件完成品种数量、货品总数、合计金额的计算
		table.addContainerListener(new computeInfo());
		JScrollPane scrollPanel = new JScrollPane(table);
		scrollPanel.setPreferredSize(new Dimension(300, 200));
		setupComponet(scrollPanel, 2, 2, 4, 0, true);
		
		// “折前金额”标签和“折前金额”文本框
		setupComponet(new JLabel("折前金额："), 0, 3, 1, 0, false);
		zq.setFocusable(false);
		zq.setSelectionColor(getForeground());
		setupComponet(zq, 1, 3, 1, 1, true);
		// “折后应收”标签和“折后应收”文本框
		setupComponet(new JLabel("折后应收："), 2, 3, 1, 0, false);
		zh.setFocusable(false);
		setupComponet(zh, 3, 3, 1, 1, true);
		
		
		// “添加”按钮
		JButton tjButton = new JButton("添加");
		tjButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 初始化账单号
				initBillHao();
				// 结束表格中没有编写的单元
				stopTableCellEditing();
				// 如果表格中还包含空行，就再添加新行
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
		
		// “挂单待结”按钮
		JButton gddjButton = new JButton("挂单待结");
		gddjButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopTableCellEditing();// 结束表格中没有编写的单元
				clearEmptyRow();// 清除空行

				float jeStr = Float.valueOf(zh.getText());// 合计金额



				String rkDate = jzDate.toLocaleString();// 销售时间
	
				
				String kehuName = kehu.getSelectedItem().toString();// 客户名字

				if (table.getRowCount() <= 0) {
					JOptionPane.showMessageDialog(shouyinGl.this, "请填加结账商品");
					return;
				}
				String id = DAO.getgdMainMaxId(new java.sql.Date(System.currentTimeMillis()));
				billinfo sellMain = new billinfo(id,jeStr,kehuName,rkDate);// 销售主表
				Set <bill_Detail> set1 = sellMain.getbillDetails();// 获得销售明细的集合
				int rows = table.getRowCount();
				for (int i = 0; i<rows; i++) {
					String spname = (String) table.getValueAt(i, 0);
					String djStr = (String) table.getValueAt(i, 1);
					String slStr = (String) table.getValueAt(i, 2);
					float discount=Float.valueOf( (String) table.getValueAt(i, 3));
					Double sprice= (Double) table.getValueAt(i, 4);
					Double dj = Double.valueOf(djStr);
					Integer sl = Integer.valueOf(slStr);
					bill_Detail detail = new bill_Detail();// 销售明细
					Item i1=new Item();
					i1.setName(spname);
					detail.setSpname(spname);
					i1.setId(null);
					
					goodsinfo spinfo = null;
					serviceItemsinfo spinfo1=null;
					
					if(goodsDAO.getgoods(i1)!=null  ) {
						spinfo=goodsDAO.getgoods(i1);
						detail.setSpid(String.valueOf(spinfo.getGoodsId()));// 流水号
						detail.setSpname(spinfo.getGoodsName());
						
					
					}
					if(serviceItemsDAO.getserviceItems(i1)!=null){
						 spinfo1=serviceItemsDAO.getserviceItems(i1);
						detail.setSpid(String.valueOf(spinfo1.getServiceitemId()));// 流水号
						detail.setSpname(spinfo1.getServiceName());
						
					}
					
					
					//detail.setSpid(String.valueOf(sellMain.getBillId()));// 销售主表
					detail.setDj(dj);// 销售单价
					detail.setSl(sl);// 销售数量
					detail.setDiscount(discount);
					detail.setSprice(sprice);
					set1.add(detail);// 把销售明细添加到销售明细的集合中
				}
				boolean rs = DAO.insertgdInfo(sellMain);// 添加挂单信息
				if (rs) {
					JOptionPane.showMessageDialog(shouyinGl.this, "该账单已加入挂单列表");
					DefaultTableModel dftm = new DefaultTableModel();
					table.setModel(dftm);
					initTable();
					zq.setText("0");
			
					zh.setText("0");
				}
			}
			
		});
		setupComponet(gddjButton, 4, 4, 1, 1, false);
		
		// “销售”按钮
		JButton sellButton = new JButton("结账");
		sellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopTableCellEditing();// 结束表格中没有编写的单元
				clearEmptyRow();// 清除空行

				float jeStr = Float.valueOf(zh.getText());// 合计金额



				String rkDate = jzDate.toLocaleString();// 销售时间
	
				String id = billHao.getText();// 票号
				String kehuName = kehu.getSelectedItem().toString();// 客户名字

				if (table.getRowCount() <= 0) {
					JOptionPane.showMessageDialog(shouyinGl.this, "请填加结账商品");
					return;
				}
				billinfo sellMain = new billinfo(id,jeStr,kehuName,rkDate);// 销售主表
				Set <bill_Detail> set1 = sellMain.getbillDetails();// 获得销售明细的集合
				int rows = table.getRowCount();
				for (int i = 0; i<rows; i++) {
					String spname = (String) table.getValueAt(i, 0);
					String djStr = (String) table.getValueAt(i, 1);
					String slStr = (String) table.getValueAt(i, 2);
					float discount=Float.valueOf( (String) table.getValueAt(i, 3));
					Double sprice= (Double) table.getValueAt(i, 4);
					Double dj = Double.valueOf(djStr);
					Integer sl = Integer.valueOf(slStr);
					bill_Detail detail = new bill_Detail();// 销售明细
					Item i1=new Item();
					i1.setName(spname);
					detail.setSpname(spname);
					i1.setId(null);
					
					goodsinfo spinfo = null;
					serviceItemsinfo spinfo1=null;
					
					if(goodsDAO.getgoods(i1)!=null  ) {
						spinfo=goodsDAO.getgoods(i1);
						detail.setSpid(String.valueOf(spinfo.getGoodsId()));// 流水号
						detail.setSpname(spinfo.getGoodsName());
						
					
					}
					if(serviceItemsDAO.getserviceItems(i1)!=null){
						 spinfo1=serviceItemsDAO.getserviceItems(i1);
						detail.setSpid(String.valueOf(spinfo1.getServiceitemId()));// 流水号
						detail.setSpname(spinfo1.getServiceName());
						
					}
					
					
					//detail.setSpid(String.valueOf(sellMain.getBillId()));// 销售主表
					detail.setDj(dj);// 销售单价
					detail.setSl(sl);// 销售数量
					detail.setDiscount(discount);
					detail.setSprice(sprice);
					set1.add(detail);// 把销售明细添加到销售明细的集合中
				}
				boolean rs = billDAO.insertSellInfo(sellMain);// 添加销售信息
				if (rs) {
					JOptionPane.showMessageDialog(shouyinGl.this, "结账完成");
					DefaultTableModel dftm = new DefaultTableModel();
					table.setModel(dftm);
					initTable();
					zq.setText("0");
			
					zh.setText("0");
				}
			}
		});
		setupComponet(sellButton, 5, 4, 1, 1, false);
		
		// 添加窗体监听器，完成初始化
		addInternalFrameListener(new initTasks());    
   }
   
   /**
   停止表格单元的编辑
   @roseuid 5D0B97C50214
    */
   private void stopTableCellEditing() 
   {
		TableCellEditor cellEditor = table.getCellEditor();
		if (cellEditor != null)
			cellEditor.stopCellEditing();    
   }
   
   /**
   根据商品下拉列表，更新表格当前行的内容
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
   初始化商品下拉列表
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
				
				// 如果表格中以存在同样商品，商品下拉框中就不再包含该商品
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
   初始化“账单号”
   @roseuid 5D0B97C50239
    */
   private void initBillHao() 
   {
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		String maxId = DAO.getSellMainMaxId(date);
		billHao.setText(maxId);    
   }
   
   /**
   清除空行
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
   初始化表格
   @roseuid 5D0B97C50259
    */
   private void initTable() 
   {
		String[] columnNames = { "名称","单价", "数量", "折扣", "折后额"};
		((DefaultTableModel) table.getModel()).setColumnIdentifiers(columnNames);
		TableColumn column = table.getColumnModel().getColumn(0);
		final DefaultCellEditor editor = new DefaultCellEditor(sp);
		editor.setClickCountToStart(2);
		column.setCellEditor(editor);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
		
		     //判断是否为鼠标的BUTTON3按钮，BUTTON3为鼠标右键
	        if (e.getButton() == java.awt.event.MouseEvent.BUTTON3) {
	            //通过点击位置找到点击为表格中的行
	            int focusedRowIndex = table.rowAtPoint(e.getPoint());
	            if (focusedRowIndex == -1) {
	                return;
	            }

	            //将表格所选项设为当前右键点击的行
	            table.setRowSelectionInterval(focusedRowIndex, focusedRowIndex);
	            //弹出菜单
	            m_popupMenu.show(table, e.getX(), e.getY());

	        }
		  }
			
		});    
   }
   
   /**
   初始化服务项目表格
   @roseuid 5D0B97C50267
    */
   private void initTable1() 
   {
		String[] columnNames = { "服务名称","价格"};
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
   右键删除菜单
   @roseuid 5D0B97C50274
    */
   private void createPopupMenu() 
   {
        m_popupMenu = new JPopupMenu();
        
        JMenuItem delMenItem = new JMenuItem();
        delMenItem.setText("  删除  ");
        delMenItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.removeRow(table.getSelectedRow());
				//System.out.println(evt);
            }
        });

        JMenuItem AddMenItem = new JMenuItem();
        AddMenItem.setText("  添加  ");
        AddMenItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
				// 初始化账单号
				initBillHao();
				// 结束表格中没有编写的单元
				stopTableCellEditing();
				// 如果表格中还包含空行，就再添加新行
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
   供应商选择时更新联系人字段
   @roseuid 5D0B97C50281
    */
   private void doKhSelectAction() 
   {
		/*Item item = (Item) kehu.getSelectedItem();
		customer khInfo = DAO.getKhInfo(item);
		kh.setText(khInfo.getLian());  */
   }
   
   /**
   设置组件位置并添加到容器中
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
   窗体的初始化任务
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
      初始化客户字段
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
      启动结账时间线程
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
   计算品种数量、货品总数、合计金额
    */
   private final class computeInfo implements ContainerListener 
   {
      
      /**
      @param e
      @roseuid 5D0B97C5034C
       */
      public void componentRemoved(ContainerEvent e) 
      {
			// 清除空行
			clearEmptyRow();
			// 计算代码
			int rows = table.getRowCount();
			int count = 0;
			double qmoney = 0,hmoney = 0.0;
			
			// 计算货品总数和金额
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
