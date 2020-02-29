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
	   商品修改面板
	    */
	   private JComboBox gysQuanCheng;
	   
	   /**
	   “供应商全称”下拉列表
	    */
	   private JTextField price;
	   

	   private JTextField goodClassic;
	   

	   private JTextField jianCheng;
	   
	   /**
	   “简称”文本框
	    */
	   private JTextField goodname;
	   private JTextField goodid;
	   /**
	   “商品名称”文本框
	    */
	   private JButton modifyButton;
	   
	   /**
	   “修改”按钮
	    */
	   private JButton delButton;
	   
	   /**
	   “删除”按钮
	    */
	   private JComboBox sp;
	   
	   /**
	   “选择商品”下拉列表
	   @roseuid 5D0B97BC0117
	    */
	   public serviceitemAlterPanel() 
	   {// 商品修改面板
			setLayout(new GridBagLayout());// 设置商品修改面板的布局为网格布局
			setBounds(10, 10, 550, 400);// 设置商品修改面板的位置与宽高

			setupComponet(new JLabel("服务项目编号："), 0, 0, 1, 1, false);// 设置“单位”标签的位置并添加到容器中
			goodid= new JTextField();// “单位”文本框
			setupComponet(goodid, 1, 0, 1, 130, true);// 设置“单位”文本框的位置并添加到容器中
			
			setupComponet(new JLabel("服务项目名称："), 0, 1, 1, 1, false);// 设置“商品名称”标签的位置并添加到容器中
			goodname = new JTextField();// “商品名称”文本框
			goodname.setEditable(false);// 设置“商品名称”文本框不可编辑
			setupComponet(goodname, 1, 1, 3, 1, true);// 设置“商品名称”文本框的位置并添加到容器中

		setupComponet(new JLabel("服务项目类别："), 0, 2, 1, 1, false);// 设置“单位”标签的位置并添加到容器中
			goodClassic = new JTextField();// “单位”文本框
			setupComponet(goodClassic, 1, 2, 1, 130, true);// 设置“单位”文本框的位置并添加到容器中

			
			setupComponet(new JLabel("价格："), 0, 3, 1, 1, false);// 设置“备注”标签的位置并添加到容器中
			price = new JTextField();// “备注”文本框
			setupComponet(price, 1, 3, 3, 1, true);// 设置“备注”文本框的位置并添加到容器中

			setupComponet(new JLabel("选择服务项目"), 0, 4, 1, 0, false);// 设置“选择商品”标签的位置并添加到容器中
			sp = new JComboBox();// “选择商品”下拉列表
			sp.setPreferredSize(new Dimension(230, 21));// 设置“选择商品”下拉列表的宽高
			sp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					doSpSelectAction();// “选择商品”下拉列表动作事件的监听
				}
			});
			setupComponet(sp, 1, 4, 2, 0, true);// 设置“选择商品”下拉列表的位置并添加到容器中
			modifyButton = new JButton("修改");// “修改”按钮
			delButton = new JButton("删除");// “删除”按钮
			JPanel panel = new JPanel();// 按钮面板
			panel.add(modifyButton);// 把“修改”按钮放到按钮面板中
			panel.add(delButton);// 把“删除”按钮放到按钮面板中
			setupComponet(panel, 3, 4, 1, 0, false);// 设置按钮面板的位置并添加到容器中

			delButton.addActionListener(new ActionListener() {// “删除”按钮动作事件的监听
				public void actionPerformed(ActionEvent e) {
					Item item = (Item) sp.getSelectedItem();// 获得数据表公共类对象
					if (item == null || !(item instanceof Item))// 数据表公共类对象为空或数据表公共类对象不是数据表公共类的实例
						return;// 退出程序
					int confirm = JOptionPane.showConfirmDialog(serviceitemAlterPanel.this, "确认删除服务项目信息吗？");// 弹出“确认删除商品信息吗？”提示框
					if (confirm == JOptionPane.YES_OPTION) {// 点击“确认”键
						int rs = DAO.delete("delete serviceItemsinfo where serviceitemId='" + item.getId() + "'");// 获得删除商品信息的数量
						if (rs > 0) {// 删除商品信息的数量大于0
							JOptionPane.showMessageDialog(serviceitemAlterPanel.this, "服务项目：" + item.getName() + "。删除成功");// 弹出提示框
							sp.removeItem(item);// 移除“选择商品”下拉列表中相匹配的数据表公共类对象
						}
					}
				}
			});

			modifyButton.addActionListener(new ActionListener() {// “修改”按钮动作事件的监听
				public void actionPerformed(ActionEvent e) {
					Item item = (Item) sp.getSelectedItem();// 获得数据表公共类对象
					serviceItemsinfo spInfo = new serviceItemsinfo();// 商品信息
					spInfo.setServiceitemId(Integer.valueOf(item.getId()));// 设置商品编号

					spInfo.setServiceitemClassic(goodClassic.getText().trim());

				
		
					spInfo.setSellingprice(Float.valueOf(price.getText()));

					spInfo.setServiceName(goodname.getText().trim());// 设置商品名称
					if (DAO.updateSp(spInfo) == 1)// 更改商品信息的数量等于1
						JOptionPane.showMessageDialog(serviceitemAlterPanel.this, "修改完成");// 弹出提示框
					else// 更改商品信息的数量不等于1
						JOptionPane.showMessageDialog(serviceitemAlterPanel.this, "修改失败");// 弹出提示框
				}
			});    
	   }
	   
	   /**
	   @roseuid 5D0B97BC0125
	    */
	   public void initComboBox() 
	   {// 初始化商品下拉选择框
			List khInfo = DAO.getserviceItemsinfoInfos();// 获取商品信息
			List<Item> items = new ArrayList<Item>();// 创建数据公共表的集合
			sp.removeAllItems();// 移除下拉列表中现有的商品名称
			for (Iterator iter = khInfo.iterator(); iter.hasNext();) {// 遍历list集合
				List element = (List) iter.next();// 获得集合中下一个元素
				Item item = new Item();// 创建数据表公共类对象
				item.setId(element.get(0).toString().trim());// 设置编号属性
				item.setName(element.get(2).toString().trim());// 设置名称信息
				if (items.contains(item))// 集合中包含数据表公共类对象
					continue;// 跳过本次循环
				items.add(item);// 集合中不包含数据表公共类对象，向集合中添加数据表公共类对象
				sp.addItem(item);// 向下拉列表中添加数据表公共类对象
			}
			doSpSelectAction();// “选择商品”下拉列表动作事件的监听  
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
	   
	   /**
	   @roseuid 5D0B97BC0165
	    */
	   private void doSpSelectAction() 
	   {// “选择商品”下拉列表动作事件的监听
			Item selectedItem;// “选择商品”下拉列表中的选项
			if (!(sp.getSelectedItem() instanceof Item)) {// “选择商品”下拉列表中的选项不是数据公共类的一个实例
				return;// 退出应用程序
			}
			selectedItem = (Item) sp.getSelectedItem();// 获得“选择商品”下拉列表中的选项
			serviceItemsinfo spInfo = serviceItemsDAO.getserviceItems(selectedItem);// 商品信息
			if (!String.valueOf(spInfo.getServiceitemId()).isEmpty()) {// 商品编号不为空
				goodname.setText(spInfo.getServiceName());// 设置“商品名称”文本框中的文本内容

				goodClassic.setText(spInfo.getServiceitemClassic());// 设置“单位”文本框中的文本内容
		

				price.setText(String.valueOf(spInfo.getSellingprice()));// 设置“备注”文本框中的文本内容
				goodid.setText(String.valueOf(spInfo.getServiceitemId()));
				
		
			}  
	   }

}
