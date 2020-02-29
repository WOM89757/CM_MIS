//Source file: C:\\Users\\茂\\Desktop\\课设\\管理信息系统\\MIS\\CMMIS\\src\\com\\WM\\iframe\\basicinfo\\goodsAddPanel.java

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
   “重置”按钮
   @roseuid 5D0B97BB018D
    */
   public goodsAddPanel() 
   {// 商品添加面板
		setLayout(new GridBagLayout());// 设置商品添加面板的布局为网格布局
		setBounds(10, 10, 550, 400);// 设置商品添加面板的位置与宽高
		setupComponent(new JLabel("商品编号："), 0, 0, 1, 1, false);// 设置“商品名称”标签的位置并添加到容器中
		goodsid = new JTextField();// “商品名称”文本框
		setupComponent(goodsid, 1, 0, 3, 1, true);// 设置“商品名称”文本框的位置并添加到容器中
		
		setupComponent(new JLabel("商品类别："), 0, 1, 1, 1, false);// 设置“商品名称”标签的位置并添加到容器中
		Classic = new JTextField();// “商品名称”文本框
		setupComponent(Classic, 1, 1, 3, 1, true);// 设置“商品名称”文本框的位置并添加到容器中
		
	setupComponent(new JLabel("商品名称："), 0, 2, 1, 1, false);// 设置“单位”标签的位置并添加到容器中
		goodsname = new JTextField();// “单位”文本框
		setupComponent(goodsname, 1, 2, 1, 130, true);// 设置“单位”文本框的位置并添加到容器中
		setupComponent(new JLabel("价格："), 0, 3, 1, 1, false);// 设置“备注”标签的位置并添加到容器中
		price = new JTextField();// “备注”文本框
		setupComponent(price, 1, 3, 3, 1, true);// 设置“备注”文本框的位置并添加到容器中
		final JButton tjButton = new JButton();// “添加”按钮
		tjButton.addActionListener(new ActionListener() {// 为“添加”按钮添加动作事件的监听
			public void actionPerformed(final ActionEvent e) {
				// 文本框为空时，弹出提示框
				if ( goodsname.getText().equals("")
						 || goodsid.getText().equals("")|| Classic.getText().equals("")||price.getText().equals("")) {
					JOptionPane.showMessageDialog(goodsAddPanel.this, "请完成未填写的信息。", "商品添加",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				// 执行SQL查询语句获得的结果集
				ResultSet haveUser = DAO.query("select * from goodsinfo where goodsName='" + goodsname.getText().trim() + "'");
				try {
					if (haveUser.next()) {// 结果集haveUser中有超过一条的记录
						System.out.println("error");// 控制台输出error
						JOptionPane.showMessageDialog(goodsAddPanel.this, "商品信息添加失败，存在同名商品", "添加信息",
								JOptionPane.INFORMATION_MESSAGE);// 弹出提示框
						return;
					}
				} catch (Exception er) {
					er.printStackTrace();
				}
				ResultSet set = DAO.query("select max(goodsId) from goodsinfo");// 执行SQL查询语句获得的结果集
				String id = null;// 声明产品编号
				try {
					if (set != null && set.next()) {// 结果集set不为空且结果集set中有超过一条的记录
						String sid = String.valueOf(set.getInt(1));// 获得结果集set中的第一列数据值
						if (sid == null)// 第一列数据值为空
							id = "1001";// 为产品编号赋值
						else {
							String str = sid;// 从索引为2处开始截取字符串
							id = "" + (Integer.parseInt(str) + 1);// 重新拼接字符串获得产品编号
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				goodsinfo spInfo = new goodsinfo();// 商品信息
				spInfo.setGoodsId(Integer.valueOf(id));// 设置商品编号

				spInfo.setGoodsName(goodsname.getText().trim());// 设置商品计量单位

				spInfo.setSellingprice(Float.valueOf(price.getText()));// 设置备注

				spInfo.setGoodsId(Integer.valueOf(goodsid.getText()));// 设置商品名称
				DAO.addSp(spInfo);// 添加商品信息*/
				JOptionPane.showMessageDialog(goodsAddPanel.this, "商品信息已经成功添加", "商品添加",
						JOptionPane.INFORMATION_MESSAGE);// 弹出提示框
				resetButton.doClick();// “重置”按钮执行点击事件
			}
		});
		tjButton.setText("添加");// “添加”按钮
		setupComponent(tjButton, 1, 8, 1, 1, false);// 设置“添加”按钮的位置并添加到容器中
		final GridBagConstraints gridBagConstraints_20 = new GridBagConstraints();// 创建网格限制对象
		gridBagConstraints_20.weighty = 1.0;// “添加”按钮纵向扩大的权重是1.0
		gridBagConstraints_20.insets = new Insets(0, 65, 0, 15);// “添加”按钮与其他组件彼此的间距
		gridBagConstraints_20.gridy = 8;// “添加”按钮位于网格的纵向索引为8
		gridBagConstraints_20.gridx = 1;// “添加”按钮位于网格的横向索引为1
		resetButton = new JButton();// “重置”按钮
		setupComponent(resetButton, 3, 8, 1, 1, false);// 设置“重置”按钮的位置并添加到容器中
		resetButton.addActionListener(new ActionListener() {// “重置”按钮动作事件的监听
			public void actionPerformed(final ActionEvent e) {
				// 设置文本框的内容为空
				Classic.setText("");
				goodsname.setText("");

				price.setText("");
				goodsid.setText("");
			}
		});
		resetButton.setText("重置");// 设置“重置”按钮中的文本内容    
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
   {// 设置组件的位置并添加到容器中
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
   

}
