//Source file: C:\\Users\\ï\\Desktop\\����\\������Ϣϵͳ\\MIS\\CMMIS\\src\\com\\WM\\login\\LoginPanel.java

package com.WM.login;

import java.awt.*;
import javax.swing.*;
import java.net.URL;
import java.awt.Dimension;

public class LoginPanel extends JPanel 
{
   
   /**
   ��¼���
    */
   public int width;
   
   /**
   ��¼���
    */
   public int height;
   
   /**
   ���Ŀ��
    */
   private Image img;
   
   /**
   ��¼���ı���ͼƬ
   @roseuid 5D0B97C7021D
    */
   public LoginPanel() 
   {// ��¼���Ĺ��췽��
		super();// ���ø���JPanel�Ĺ�����
		URL url = getClass().getResource("/res/login.jpg");// ��õ�¼��屳��ͼƬ��·��
		img = new ImageIcon(url).getImage();// ��õ�¼���ı���ͼƬ    
   }
   
   /**
   @param g
   @roseuid 5D0B97C70225
    */
   protected void paintComponent(Graphics g) 
   {// ��д�����������
		super.paintComponent(g);// �������
		g.drawImage(img, 0, 0, this);// ����ͼƬ    
   }
}
