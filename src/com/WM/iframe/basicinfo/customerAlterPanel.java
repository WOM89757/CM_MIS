//Source file: C:\\Users\\茂\\Desktop\\课设\\管理信息系统\\MIS\\CMMIS\\src\\com\\WM\\iframe\\basicinfo\\customerAlterPanel.java

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
   客户修改面板
    */
   private JTextField hyName;
   private JTextField hyid;

   /**
   “客户全称”文本框
    */

   /**
   “联系电话”文本框
    */
   private JTextField lianXiDianHua;
   
  
   private JButton modifyButton;
   
   /**
   “修改”按钮
    */
   private JButton delButton;
   
   /**
   “删除”按钮
    */
   private JComboBox kehu;
   
   /**
   “选择客户”下拉列表
   @roseuid 5D0B97BA008E
    */
   public customerAlterPanel() 
   {// 客户修改面板
		setBounds(10, 10, 460, 300);// 设置客户修改面板的位置与宽高
		setLayout(new GridBagLayout());// 设置客户修改面板的布局为网格布局
		setVisible(true);// 使客户修改面板可见
	
		final JLabel khid = new JLabel();// “客户全称”标签
		khid.setText("会员编号：");// 设置“客户全称”标签的文本内容
		setupComponet(khid, 0, 0, 1, 0, false);// 设置“客户全称”标签的位置并添加到容器中
		hyid = new JTextField();// “客户全称”文本框
		hyid.setEditable(false);// 设置“客户全称”文本框不可编辑
		setupComponet(hyid, 1, 0, 3, 350, true);// 设置“客户全称”文本框的位置并添加到容器中

		
		final JLabel khName = new JLabel();// “客户全称”标签
		khName.setText("会员姓名：");// 设置“客户全称”标签的文本内容
		setupComponet(khName, 0, 1, 1, 0, false);// 设置“客户全称”标签的位置并添加到容器中
		hyName = new JTextField();// “客户全称”文本框
		hyName.setEditable(false);// 设置“客户全称”文本框不可编辑
		setupComponet(hyName, 1, 1, 3, 350, true);// 设置“客户全称”文本框的位置并添加到容器中

		
		setupComponet(new JLabel("联系电话："), 0, 2, 1, 0, false);// 设置“联系电话”标签的位置并添加到容器中
		lianXiDianHua = new JTextField();// “联系电话”文本框
		setupComponet(lianXiDianHua, 1, 2, 1, 100, true);// 设置“联系电话”文本框的位置并添加到容器中
		lianXiDianHua.addKeyListener(new InputKeyListener());// 为“联系电话”文本框添加键盘输入事件的监听

		
		setupComponet(new JLabel("选择客户"), 0, 3, 1, 0, false);// 设置“选择客户”标签的位置并添加到容器中
		kehu = new JComboBox();// “选择客户”下拉列表
		kehu.setPreferredSize(new Dimension(230, 21));// 设置“选择客户”下拉列表宽高
		initComboBox();// 初始化下拉选择框
		kehu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doKeHuSelectAction();// 为“选择客户”下拉列表添加动作事件的监听
			}
		});
		setupComponet(kehu, 1, 3, 2, 0, true);// 设置“选择客户”下拉列表的位置并添加到容器中
		modifyButton = new JButton("修改");// “修改”按钮
		delButton = new JButton("删除");// “删除”按钮
		JPanel panel = new JPanel();// 表格面板
		panel.add(modifyButton);// 向表格面板中添加“修改”按钮
		panel.add(delButton);// 向表格面板中添加“删除”按钮
		setupComponet(panel, 0, 4, 1, 0, false);// 设置表格面板的位置并添加到容器中
		
		delButton.addActionListener(new ActionListener() {// “删除”按钮的动作事件的监听
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) kehu.getSelectedItem();// 获得数据表公共类对象
				if (item == null || !(item instanceof Item))// 数据表公共类对象为空或数据表公共类对象不是数据表公共类的实例
					return;// 退出程序
				int confirm = JOptionPane.showConfirmDialog(customerAlterPanel.this, "确认删除客户信息吗？");// 弹出“确认删除客户信息吗？”提示框
				if (confirm == JOptionPane.YES_OPTION) {// 点击“确认”键
					int rs = DAO.delete("delete customer where cardId=" + Integer.valueOf(item.getId()) + ";");// 获得删除客户信息的数量
					if (rs > 0) {// 删除客户信息的数量大于0
						JOptionPane.showMessageDialog(customerAlterPanel.this, "客户：" + item.getName() + "。删除成功");// 弹出提示框
						kehu.removeItem(item);// 移除“选择客户”下拉列表中相匹配的数据表公共类对象
					}
				}
			}
		});
		
		modifyButton.addActionListener(new ActionListener() {// “修改”按钮的动作事件的监听
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) kehu.getSelectedItem();// 获得数据表公共类对象
				customer khinfo = new customer();// 客户信息
				khinfo.setCardId(Integer.valueOf(item.getId()));// 设置客户编号
			
				khinfo.setUserName(hyName.getText().trim());// 设置客户名称
				
				khinfo.setPhoneNumber(Long.valueOf(lianXiDianHua.getText()));// 设置联系电话
				
				if (DAO.updateKeHu(khinfo) == 1)// 更改客户信息的数量等于1
					JOptionPane.showMessageDialog(customerAlterPanel.this, "修改完成");// 弹出提示框
				else// 更改客户信息的数量不等于1
					JOptionPane.showMessageDialog(customerAlterPanel.this, "修改失败");// 弹出提示框
			}
		});    
   }
   
   /**
   @roseuid 5D0B97BA0097
    */
   public void initComboBox() 
   {// 初始化“选择客户”下拉列表
		List khInfo = DAO.getKhInfos();// 获取客户信息
		List<Item> items = new ArrayList<Item>();// 创建数据公共表的集合
		kehu.removeAllItems();// 移除下拉列表中现有的客户名称
		for (Iterator iter = khInfo.iterator(); iter.hasNext();) {// 遍历list集合
			List element = (List) iter.next();// 获得集合中下一个元素
			Item item = new Item();// 创建数据表公共类对象
			item.setId(element.get(0).toString().trim());// 设置编号属性
			item.setName(element.get(1).toString().trim());// 设置名称信息
			if (items.contains(item))// 集合中包含数据表公共类对象
				continue;// 跳过本次循环
			items.add(item);// 集合中不包含数据表公共类对象，向集合中添加数据表公共类对象
			kehu.addItem(item);// 向下拉列表中添加数据表公共类对象
		}
		doKeHuSelectAction();// “选择客户”下拉列表动作事件的监听    
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
   @roseuid 5D0B97BA00EB
    */
   private void doKeHuSelectAction() 
   {
	   // “选择客户”下拉列表动作事件的监听
		Item selectedItem;// “选择客户”下拉列表中的选项
		if (!(kehu.getSelectedItem() instanceof Item)) {// “选择客户”下拉列表中的选项不是数据公共类的一个实例
			return;// 退出应用程序
		}
		selectedItem = (Item) kehu.getSelectedItem();// 获得“选择客户”下拉列表中的选项
		customer khInfo = DAO.getKhInfo(selectedItem);// 客户信息
		hyName.setText(khInfo.getUserName());// 设置“客户全称”文本框中的文本内容
		hyid.setText(String.valueOf(khInfo.getCardId()));
		lianXiDianHua.setText(String.valueOf(khInfo.getPhoneNumber()));// 设置“联系电话”文本框中的文本内容
		  
   }
}
