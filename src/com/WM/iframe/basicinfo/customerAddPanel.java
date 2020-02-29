//Source file: C:\\Users\\茂\\Desktop\\课设\\管理信息系统\\MIS\\CMMIS\\src\\com\\WM\\iframe\\basicinfo\\customerAddPanel.java

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
   客户添加面板
    */
   private JTextField hyid;
   private JTextField hyname;
   
  
   private JTextField lianXiDianHua;
   
   /**
   “联系电话”文本框
    */
  
   private JButton resetButton;
   
   /**
   “重置”按钮文本框
   @roseuid 5D0B97B90059
    */
   public customerAddPanel() 
   {// 客户添加面板
		super();// 调用父类JPanel的构造器
		setBounds(10, 10, 460, 300);// 设置客户添加面板的位置与宽高
		setLayout(new GridBagLayout());// 设置客户添加面板的布局为网格布局
		setVisible(true);// 使客户添加面板可见
		
		final JLabel khid = new JLabel();// “客户全称”标签
		khid.setText("会员编号：");// 设置“客户全称”标签的文本内容
		setupComponet(khid, 0, 0, 1, 0, false);// 设置“客户全称”标签的位置并添加到容器中
		hyid = new JTextField();// “客户全称”文本框
		setupComponet(hyid, 1, 0, 3, 350, true);// 设置“客户全称”文本框的位置并添加到容器中
		
		final JLabel khName = new JLabel();// “客户全称”标签
		khName.setText("会员姓名：");// 设置“客户全称”标签的文本内容
		setupComponet(khName, 0, 1, 1, 0, false);// 设置“客户全称”标签的位置并添加到容器中
		hyname = new JTextField();// “客户全称”文本框
		setupComponet(hyname, 1, 1, 3, 350, true);// 设置“客户全称”文本框的位置并添加到容器中
		
		
		
		
		setupComponet(new JLabel("联系电话："), 0, 2, 1, 0, false);// 设置“联系电话”标签的位置并添加到容器中
		lianXiDianHua = new JTextField();// “联系电话”文本框
		setupComponet(lianXiDianHua, 1, 2, 1, 100, true);// 设置“联系电话”文本框的位置并添加到容器中
		lianXiDianHua.addKeyListener(new InputKeyListener());// 为“联系电话”文本框添加键盘输入事件的监听
		
		
		
		final JButton saveButton = new JButton("保存");// “保存”按钮
		setupComponet(saveButton, 0, 3, 1, 0, false);// 设置“保存”按钮的位置并添加到容器中
		saveButton.addActionListener(new SaveButtonActionListener());// 为“保存”按钮添加动作事件的监听
		
		resetButton = new JButton("重置");// “重置”按钮
		setupComponet(resetButton, 1, 3, 1, 0, false);// 设置“重置”按钮的位置并添加到容器中
		resetButton.addActionListener(new ChongZheButtonActionListener());// 为“重置”按钮添加动作事件的监听    
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
   {// 设置组件位置并添加到容器中
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();// 创建网格限制对象
		gridBagConstrains.gridx = gridx;// 设置组件位于网格的横向索引为gridx
		gridBagConstrains.gridy = gridy;// 设置组件位于网格的纵向索引为gridy
		gridBagConstrains.insets = new Insets(5, 1, 3, 1);// 组件彼此的间距
		if (gridwidth > 1)// 组件横跨网格数大于1
			gridBagConstrains.gridwidth = gridwidth;// 设置组件横跨网格数为gridwidth
		if (ipadx > 0)// 组件横向填充的大小大于0
			gridBagConstrains.ipadx = ipadx;// 设置组件横向填充的大小
		if (fill)// 组件占据空白区域
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;// 组件水平扩大以占据空白区域
		add(component, gridBagConstrains);// 添加组件    
   }
   
   private final class SaveButtonActionListener implements ActionListener 
   {
      
      /**
      “保存”按钮动作事件的监听
      @param e
      @roseuid 5D0B97B900DD
       */
      public void actionPerformed(final ActionEvent e) 
      {
			// 文本框为空时，弹出提示框
			if (hyid.getText().equals("") || lianXiDianHua.getText().equals("") || hyname.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "请填写全部信息");
				return;// 退出应用程序
			}
			// 执行SQL查询语句获得的结果集
			ResultSet haveUser = DAO.query("select * from customer where cardId=" + Integer.valueOf(hyid.getText()) + "");
			try {
				if (haveUser.next()) {// 结果集haveUser中有超过一条的记录
					System.out.println("error");// 控制台输出error
					JOptionPane.showMessageDialog(customerAddPanel.this, "会员信息添加失败，存在同名会员", "会员添加信息",
							JOptionPane.INFORMATION_MESSAGE);// 弹出提示框
					return;
				}
			} catch (Exception er) {
				er.printStackTrace();
			}
			ResultSet set = DAO.query("select max(cardId) from customer");// 执行SQL查询语句获得的结果集
			String id = null;// 声明客户编号
			try {
				if (set != null && set.next()) {// 结果集set不为空且结果集set中有超过一条的记录
					String sid = String.valueOf(set.getInt(1));// 获得结果集set中的第一列数据值
					if (sid == null)// 第一列数据值为空
						id = "10001";// 为产品编号赋值
					else {
						String str = sid;
						id = "" + (Integer.parseInt(str) + 1);// 重新拼接字符串获得产品编号
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			customer khinfo = new customer();// 客户信息
			khinfo.setCardId(Integer.valueOf(id));// 设置商品编号
			
			khinfo.setUserName(hyname.getText().trim());// 设置客户名称
			
			khinfo.setPhoneNumber(Long.valueOf(lianXiDianHua.getText()));// 设置联系电话

			DAO.addKeHu(khinfo);// 添加客户信息
			JOptionPane.showMessageDialog(customerAddPanel.this, "已成功添加会员", "添加会员信息", JOptionPane.INFORMATION_MESSAGE);// 弹出提示框
			resetButton.doClick();// “重置”按钮执行点击事件    
      }
   }
   
   private class ChongZheButtonActionListener implements ActionListener 
   {
      
      /**
      “重置”按钮动作事件的监听
      @param e
      @roseuid 5D0B97B90133
       */
      public void actionPerformed(final ActionEvent e) 
      {
			// 设置文本框的内容为空
			hyid.setText("");
	
			lianXiDianHua.setText("");
			hyname.setText("");
			
      }
   }
}
