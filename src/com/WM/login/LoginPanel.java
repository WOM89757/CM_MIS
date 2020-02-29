//Source file: C:\\Users\\茂\\Desktop\\课设\\管理信息系统\\MIS\\CMMIS\\src\\com\\WM\\login\\LoginPanel.java

package com.WM.login;

import java.awt.*;
import javax.swing.*;
import java.net.URL;
import java.awt.Dimension;

public class LoginPanel extends JPanel 
{
   
   /**
   登录面板
    */
   public int width;
   
   /**
   登录面板
    */
   public int height;
   
   /**
   面板的宽高
    */
   private Image img;
   
   /**
   登录面板的背景图片
   @roseuid 5D0B97C7021D
    */
   public LoginPanel() 
   {// 登录面板的构造方法
		super();// 调用父类JPanel的构造器
		URL url = getClass().getResource("/res/login.jpg");// 获得登录面板背景图片的路径
		img = new ImageIcon(url).getImage();// 获得登录面板的背景图片    
   }
   
   /**
   @param g
   @roseuid 5D0B97C70225
    */
   protected void paintComponent(Graphics g) 
   {// 重写绘制组件方法
		super.paintComponent(g);// 绘制组件
		g.drawImage(img, 0, 0, this);// 绘制图片    
   }
}
