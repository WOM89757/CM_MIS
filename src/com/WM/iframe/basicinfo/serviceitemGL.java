package com.WM.iframe.basicinfo;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class serviceitemGL extends JInternalFrame{
	 public serviceitemGL() 
	   {// 商品管理内部窗体的构造方法
			setIconifiable(true);// 可以图标化
			setClosable(true);// 可以关闭
			setTitle("服务项目管理");// 设置商品管理内部窗体的标题
			JTabbedPane tabPane = new JTabbedPane();// 创建选项卡面板
			final serviceitemAlterPanel spxgPanel = new serviceitemAlterPanel();// 商品修改面板
			final serviceitemAddPanel  sptjPanel = new serviceitemAddPanel ();// 商品添加面板
			tabPane.addTab("服务项目信息添加", null, sptjPanel, "服务项目添加");// 把商品添加面板添加到选项卡面板中
			tabPane.addTab("服务项目信息修改与删除", null, spxgPanel, "修改与删除");// 把商品修改面板添加到选项卡面板中
			getContentPane().add(tabPane);// 把选项卡面板添加到商品管理内部窗体的内容面板中
			tabPane.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					spxgPanel.initComboBox();// 初始化商品修改面板中的商品下拉选择框
					
				}
			});
			addInternalFrameListener(new InternalFrameAdapter(){
				public void internalFrameActivated(InternalFrameEvent e) {
					super.internalFrameActivated(e);
					
				}
			});
			pack();// 商品管理内部窗体中的组件按其首选大小进行布局
			setVisible(true);// 使商品管理内部窗体可见    
	   }

}
