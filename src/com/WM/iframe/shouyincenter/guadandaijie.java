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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
import com.WM.dao.Model.goodsinfo;
import com.WM.dao.Model.serviceItemsinfo;





public class guadandaijie extends JInternalFrame {
	
	private final JTable table;// 表格模型
	private final JTable table1;// 商品表格模型
	private JPopupMenu m_popupMenu;
	
	private final JTextField billHao = new JTextField();// “销售票号”文本框
	private final JTextField kehu = new JTextField();// “销售票号”文本框
	
	private JComboBox sp;// “商品”下拉列表
	private Date jzDate;// “结账日期”
	private final JTextField billDate = new JTextField();// “结账时间”文本框
	private final JTextField zh = new JTextField("0");// “折后金额”文本框
	private final JTextField zq = new JTextField("0");// “折前”文本框

	
	public guadandaijie() 
	   {
		   // 挂单待结内部窗体的构造方法
			super();// 调用父类JInternalFrame的构造器
			setMaximizable(true);// 可以最大化
			setIconifiable(true);// 可以图标化
			setClosable(true);// 可以关闭挂单待结内部窗体
			getContentPane().setLayout(new GridBagLayout());// 设置挂单待结内部窗体的布局为网格布局
			setTitle("挂单待结");// 设置挂单待结内部窗体的标题
			setBounds(50, 50, 750, 460);// 设置挂单待结内部窗体的位置和宽高
			
			// “	挂单列表”标签
			setupComponet(new JLabel("挂单列表："), 0, 0, 1, 0, false);
			// 表格模型
			table = new JTable();
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);// 不自动调整列的宽度，使用滚动条
			initTable();
			JScrollPane scrollPanel = new JScrollPane(table);
			scrollPanel.setPreferredSize(new Dimension(378, 100));
			setupComponet(scrollPanel, 0, 1, 6, 0, true);
			
			// “	账单号号”标签和“账单号”文本框
			setupComponet(new JLabel("账单号："), 0, 2, 1, 0, false);
			billHao.setFocusable(false);
			setupComponet(billHao, 1, 2, 1, 140, true);
			
			// “客户”标签和“客户”下拉列表
			setupComponet(new JLabel("客户："), 2, 2, 1, 0, false);
			kehu.setFocusable(false);
			setupComponet(kehu, 3, 2, 3, 1, true);
			// “销售时间”标签和“销售时间”文本框
			setupComponet(new JLabel("销售时间："), 2, 3, 1, 0, false);
			billDate.setFocusable(false);
			setupComponet(billDate, 3, 3, 3, 1, true);
			
			// “折前金额”标签和“折前金额”文本框
			setupComponet(new JLabel("折前金额："), 0, 5, 1, 0, false);
			zq.setFocusable(false);
			zq.setSelectionColor(getForeground());
			setupComponet(zq, 1, 5, 1, 1, true);
			// “折后应收”标签和“折后应收”文本框
			setupComponet(new JLabel("折后应收："), 2, 5, 1, 0, false);
			zh.setFocusable(false);
			setupComponet(zh, 3, 5, 2, 1, true);
			
			// “	挂单详情”标签
			setupComponet(new JLabel("挂单详情："), 0, 3, 1, 0, false);
			// 表格模型
			table1 = new JTable();
			
	
			JScrollPane scrollPanel1 = new JScrollPane(table1);
			table1.addContainerListener(new computeInfo());
			scrollPanel1.setPreferredSize(new Dimension(430, 150));
			setupComponet(scrollPanel1, 0, 4, 6, 0, true);
			// “销售”按钮
			JButton sellButton = new JButton("结账");
			sellButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					stopTableCellEditing();// 结束表格中没有编写的单元
					clearEmptyRow();// 清除空行

					float jeStr = Float.valueOf(zh.getText());// 合计金额



					String rkDate = jzDate.toLocaleString();// 销售时间
		
					String id = billHao.getText();// 票号
					String kehuName = kehu.getText();// 客户名字

					if (table.getRowCount() <= 0) {
						JOptionPane.showMessageDialog(guadandaijie.this, "请填加结账商品");
						return;
					}
					billinfo sellMain = new billinfo(id,jeStr,kehuName,rkDate);// 销售主表
					Set <bill_Detail> set1 = sellMain.getbillDetails();// 获得销售明细的集合
					int rows = table1.getRowCount();
					for (int i = 0; i<rows; i++) {
						String spname = (String) table1.getValueAt(i, 1);
						String djStr = (String) table1.getValueAt(i, 2);
						String slStr = (String) table1.getValueAt(i, 3);
						float discount=Float.valueOf( (String) table1.getValueAt(i, 4));
						Double sprice= (Double) table1.getValueAt(i, 5);
						Double dj = Double.valueOf(djStr);
						Double sl =Double.valueOf(slStr);
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
					int i=DAO.delete("delete gdinfo where billId='"+table1.getValueAt(0, 0)+"';");
					 i+=DAO.delete("delete gd_Detail where billId='"+table1.getValueAt(0, 0)+"';");
					
					if (rs) {
						JOptionPane.showMessageDialog(guadandaijie.this, "结账完成");
						DefaultTableModel dftm = new DefaultTableModel();
						table.setModel(dftm);
						initTable();
						DefaultTableModel dftm1 = new DefaultTableModel();
						table1.setModel(dftm1);
						
						zq.setText("0");
						kehu.setText("");
						zh.setText("0");
						billHao.setText("");
						billDate.setText("");
						
						

					}
				}
			});
			setupComponet(sellButton, 3, 6, 1, 1, false);
			
			// 添加窗体监听器，完成初始化
			addInternalFrameListener(new initTasks());    
	   }
	   private void initBillHao() 
	   {
			java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
			String maxId = DAO.getSellMainMaxId(date);
			billHao.setText(maxId);    
	   }
	

	   private void stopTableCellEditing() 
	   {
			TableCellEditor cellEditor = table.getCellEditor();
			if (cellEditor != null)
				cellEditor.stopCellEditing();    
	   }
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
	   private void initTable() 
	   {
			String[] columnNames = { "挂单号","挂单时间", "价格", "客户", "职工"};
			((DefaultTableModel) table.getModel()).setColumnIdentifiers(columnNames);
			billinfo  guadaninfo = new billinfo();
			table.setEnabled(false);
			ResultSet set = DAO.query(" select * from gdinfo ;");
			try {
				int row=0;
				while (set.next()) {
					
					guadaninfo.setBillId(set.getString("billid").trim());
					guadaninfo.setDate(set.getString("date").trim());
					guadaninfo.setPrice(set.getFloat(3));
					guadaninfo.setUserName(set.getString("userName").trim());
					guadaninfo.setStaffName(set.getString("staffName").trim());
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.addRow(new Vector());
					table.setValueAt(guadaninfo.getBillId(), row,0);
					table.setValueAt(guadaninfo.getDate(), row,1);
					table.setValueAt(guadaninfo.getPrice(), row,2);
					table.setValueAt(guadaninfo.getUserName(), row,3);
					table.setValueAt(guadaninfo.getStaffName(), row,4);
					
					row++;
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(e.getClickCount()==2) {
						initBillHao();
						DefaultTableModel dftm = new DefaultTableModel();
						table1.setModel(dftm);
						initTable();
						zq.setText("0");
						zh.setText("0");
						int row=((JTable)e.getSource()).rowAtPoint(e.getPoint());
						String billid=(String)(table.getValueAt(row, 0));
						billHao.setText((String)table.getValueAt(row, 0));
						kehu.setText((String)table.getValueAt(row, 3));

						initTable1(billid) ;
						
						
						
					}else
						return;
				     //判断是否为鼠标的BUTTON3按钮，BUTTON3为鼠标右键
			        if (e.getButton() ==MouseEvent.BUTTON3) {
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

	   private void initTable1(String billId) 
	   {
			String[] columnNames = { "账单号","商品名称", "单价", "数量", "折扣","金额"};
			((DefaultTableModel) table1.getModel()).setColumnIdentifiers(columnNames);
			bill_Detail guadaninfo = new bill_Detail();
			table1.setEnabled(true);
			ResultSet set = DAO.query(" select * from gd_Detail where billId='"+billId+"';");
			
			try {
				int row=0;
				while (set.next()) {

					guadaninfo.setBillId(set.getString("billid").trim());
					guadaninfo.setSpname(set.getString("spname").trim());
					guadaninfo.setDj(set.getFloat(4));
					guadaninfo.setSl(set.getFloat(5));
					guadaninfo.setDiscount(set.getFloat(6));
					guadaninfo.setSprice(set.getFloat(7));
		

					DefaultTableModel model = (DefaultTableModel) table1.getModel();
					model.addRow(new Vector());
					table1.setValueAt(guadaninfo.getBillId(), row,0);
					table1.setValueAt(guadaninfo.getSpname(), row,1);
					table1.setValueAt(String.valueOf(guadaninfo.getDj()), row,2);
					table1.setValueAt(String.valueOf(guadaninfo.getSl()), row,3);
					table1.setValueAt(String.valueOf(guadaninfo.getDiscount()), row,4);
					table1.setValueAt(String.valueOf(guadaninfo.getSprice()), row,5);
					
					row++;
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			ContainerEvent e1 = null;
			new computeInfo().componentRemoved(e1);

	   }
	   private void createPopupMenu() 
	   {
	        m_popupMenu = new JPopupMenu();
	        
	        JMenuItem delMenItem = new JMenuItem();
	        delMenItem.setText("  删除  ");
	        delMenItem.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
					DefaultTableModel model = (DefaultTableModel) table1.getModel();
					model.removeRow(table1.getSelectedRow());
					//System.out.println(evt);
	            }
	        });

	        JMenuItem AddMenItem = new JMenuItem();
	        AddMenItem.setText("  添加  ");
	        AddMenItem.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
					// 初始化账单号
					//initBillHao();
					// 结束表格中没有编写的单元
				//	stopTableCellEditing();
					// 如果表格中还包含空行，就再添加新行
					for (int i = 0; i < table1.getRowCount(); i++) {
						
						if (table1.getValueAt(i, 0) == null)
							return;
					}
					DefaultTableModel model = (DefaultTableModel) table1.getModel();
					model.addRow(new Vector());
	            }
	        });
	        m_popupMenu.add(AddMenItem);    
	        m_popupMenu.add(delMenItem); 
	   }
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
					int rows = table1.getRowCount();
					int count = 0;
					double qmoney = 0,hmoney = 0.0;
					
					// 计算货品总数和金额
					for (int i = 0; i < rows; i++) {
						//System.out.println(table.getValueAt(i, 1).getClass());
						String column4= String.valueOf(table1.getValueAt(i, 2));
						String column5 = String.valueOf (table1.getValueAt(i, 3));
						String column6 = String.valueOf(table1.getValueAt(i, 4));
						double c5 = (column5 == null || column5.isEmpty()) ? 0 : Double.valueOf(column5);
						Double c4 = (column4 == null  ) ? 0 : Double.valueOf(column4);
						Double c6 = (column6 == null || column6.isEmpty()) ? 1 : Double.valueOf(column6);
						//count += c7;
						qmoney += c5 * c4;
						hmoney +=c5 * c4*c6;

						table1.setValueAt(c5*c4*c6,i, 5);
					}
					zq.setText(qmoney + "");
					zh.setText(hmoney + "");       
		      }

			@Override
			public void componentAdded(ContainerEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		   }
	   private final class initTasks extends InternalFrameAdapter 
	   {
	      
	      /**
	      @param e
	      @roseuid 5D0B97C502EF
	       */
	      public void internalFrameActivated(InternalFrameEvent e) 
	      {
				super.internalFrameActivated(e);
				createPopupMenu(); 
				initTimeField();
				initTimegd();
     
	      }
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
	      private void initTimegd() 
	      {
				new Thread(new Runnable() {
					public void run() {
						try {
							while (true) {
								DefaultTableModel dftm = new DefaultTableModel();
								table.setModel(dftm);
								initTable();
								initBillHao();
								Thread.sleep(3000);
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}).start();       
	      }
	   }
	   
	   

}

