//Source file: C:\\Users\\茂\\Desktop\\课设\\管理信息系统\\MIS\\CMMIS\\src\\com\\WM\\iframe\\basicinfo\\customerGL.java

package com.WM.iframe.basicinfo;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class customerGL extends JInternalFrame 
{
   
   /**
   客户管理内部窗体
    */
   private static final long serialVersionUID = 1L;
   
   /**
   @roseuid 5D0B97BA021D
    */
   public customerGL() 
   {// 客户管理内部窗体的构造方法
		setIconifiable(true);// 可以图标化
		setClosable(true);// 可以关闭
		setTitle("会员信息管理");// 设置客户管理内部窗体的标题
		JTabbedPane tabPane = new JTabbedPane();// 创建选项卡面板
		final customerAlterPanel khxgPanel = new customerAlterPanel();// 客户修改面板
		final customerAddPanel khtjPanel = new customerAddPanel();// 客户添加面板
		tabPane.addTab("会员信息添加", null, khtjPanel, "会员添加");// 把客户添加面板添加到选项卡面板中
		tabPane.addTab("会员信息修改与删除", null, khxgPanel, "修改与删除");// 把客户修改面板添加到选项卡面板中
		getContentPane().add(tabPane);// 把选项卡面板添加到客户管理内部窗体的内容面板中
		tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				khxgPanel.initComboBox();// 初始化客户修改面板中的“选择客户”下拉列表
			}
		});
		pack();// 客户管理内部窗体中的组件按其首选大小进行布局
		setVisible(true);// 使客户管理内部窗体可见    
   }
}
