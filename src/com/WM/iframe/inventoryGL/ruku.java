package com.WM.iframe.inventoryGL;

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
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.WM.dao.DAO;
import com.WM.dao.goodsDAO;
import com.WM.dao.Model.Item;
import com.WM.dao.Model.goodsinfo;


public class ruku extends JInternalFrame  {
	  private JTextField price;
	   
	  private JTextField numb;
	  private JTextField cnumb;
	   private JTextField goodClassic;

	   private JTextField goodname;
	   private JTextField goodid;

	   private JButton modifyButton;
	   

	   private JButton delButton;

	   private JComboBox sp;
	   
	   /**
	   “选择商品”下拉列表
	   @roseuid 5D0B97BC0117
	    */
	   public ruku() 
	   {
		   
			super();// 调用父类JInternalFrame的构造器
			setMaximizable(true);// 可以最大化
			setIconifiable(true);// 可以图标化
			setClosable(true);// 可以关闭
			getContentPane().setLayout(new GridBagLayout());// 设置库存盘点内部窗体的布局为网格布局
			setTitle("商品入库");// 设置库存盘点内部窗体的标题
			setBounds(50, 50, 750, 400);// 设置设置库存盘点内部窗体的位置和宽高
			
			setLayout(new GridBagLayout());// 设置商品修改面板的布局为网格布局
			setBounds(10, 10, 550, 400);// 设置商品修改面板的位置与宽高

			setupComponet(new JLabel("商品编号："), 0, 0, 1, 1, false);// 设置“单位”标签的位置并添加到容器中
			goodid= new JTextField();// “单位”文本框
			setupComponet(goodid, 1, 0, 1, 130, true);// 设置“单位”文本框的位置并添加到容器中
			goodid.setEditable(false);
			
			setupComponet(new JLabel("商品名称："), 0, 1, 1, 1, false);// 设置“商品名称”标签的位置并添加到容器中
			goodname = new JTextField();// “商品名称”文本框
			goodname.setEditable(false);// 设置“商品名称”文本框不可编辑
			setupComponet(goodname, 1, 1, 3, 1, true);// 设置“商品名称”文本框的位置并添加到容器中

		setupComponet(new JLabel("商品类别："), 0, 2, 1, 1, false);// 设置“单位”标签的位置并添加到容器中
			goodClassic = new JTextField();// “单位”文本框
			setupComponet(goodClassic, 1, 2, 1, 130, true);// 设置“单位”文本框的位置并添加到容器中
			goodClassic.setEditable(false);
			
			setupComponet(new JLabel("价格："), 0, 3, 1, 1, false);// 设置“备注”标签的位置并添加到容器中
			price = new JTextField();// “备注”文本框
			setupComponet(price, 1, 3, 3, 1, true);// 设置“备注”文本框的位置并添加到容器中
			price.setEditable(false);
			
			setupComponet(new JLabel("当前库存量："), 0, 4, 1, 1, false);// 设置“备注”标签的位置并添加到容器中
			cnumb = new JTextField();// “备注”文本框
			setupComponet(cnumb, 1, 4, 3, 1, true);// 设置“备注”文本框的位置并添加到容器中
			cnumb.setEditable(false);
			
			setupComponet(new JLabel("入库数量："), 0, 5, 1, 1, false);// 设置“备注”标签的位置并添加到容器中
			numb = new JTextField();// “备注”文本框
			setupComponet(numb, 1, 5, 3, 1, true);// 设置“备注”文本框的位置并添加到容器中
			
			
			setupComponet(new JLabel("选择商品"), 0, 6, 1, 0, false);// 设置“选择商品”标签的位置并添加到容器中
			sp = new JComboBox();// “选择商品”下拉列表
			sp.setPreferredSize(new Dimension(230, 21));// 设置“选择商品”下拉列表的宽高
			sp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					doSpSelectAction();// “选择商品”下拉列表动作事件的监听
				}
			});
			initComboBox();
			setupComponet(sp, 1, 6, 2, 0, true);// 设置“选择商品”下拉列表的位置并添加到容器中
			modifyButton = new JButton("入库");// “修改”按钮

			JPanel panel = new JPanel();// 按钮面板
			panel.add(modifyButton);// 把“修改”按钮放到按钮面板中
	
			setupComponet(panel, 1, 7, 1, 0, false);// 设置按钮面板的位置并添加到容器中



			modifyButton.addActionListener(new ActionListener() {// “修改”按钮动作事件的监听
				public void actionPerformed(ActionEvent e) {
					Item item = (Item) sp.getSelectedItem();// 获得数据表公共类对象
					goodsinfo spInfo = new goodsinfo();// 商品信息
					spInfo.setGoodsId(Integer.valueOf(item.getId()));// 设置商品编号

					spInfo.setGoodsClassic(goodClassic.getText().trim());

				
		
					spInfo.setSellingprice(Float.valueOf(price.getText()));
					spInfo.setStock(Integer.valueOf(cnumb.getText())+Integer.valueOf(numb.getText()));
					spInfo.setGoodsName(goodname.getText().trim());// 设置商品名称
					if (DAO.updaterkSp(spInfo) == 1) {// 更改商品信息的数量等于1
						JOptionPane.showMessageDialog(ruku.this, "入库完成");// 弹出提示框
						numb.setText("");
						}
					else// 更改商品信息的数量不等于1
						JOptionPane.showMessageDialog(ruku.this, "入库失败");// 弹出提示框
					
					
				}
			});    
	   }
	   
	   /**
	   @roseuid 5D0B97BC0125
	    */
	   public void initComboBox() 
	   {// 初始化商品下拉选择框
			List khInfo = DAO.getSpInfos();// 获取商品信息
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
			goodsinfo spInfo = goodsDAO.getgoods(selectedItem);// 商品信息
			if (!String.valueOf(spInfo.getGoodsId()).isEmpty()) {// 商品编号不为空
				goodname.setText(spInfo.getGoodsName());// 设置“商品名称”文本框中的文本内容

				goodClassic.setText(spInfo.getGoodsClassic());// 设置“单位”文本框中的文本内容
		
				cnumb.setText(String.valueOf(spInfo.getStock()));
				price.setText(String.valueOf(spInfo.getSellingprice()));// 设置“备注”文本框中的文本内容
				goodid.setText(String.valueOf(spInfo.getGoodsId()));
				
		
			}  
	   }

}
