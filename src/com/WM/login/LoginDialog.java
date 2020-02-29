//Source file: C:\\Users\\ï\\Desktop\\����\\������Ϣϵͳ\\MIS\\CMMIS\\src\\com\\WM\\login\\LoginDialog.java

package com.WM.login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.WM.*;
import com.WM.Main.MainFrame;
import com.WM.dao.DAO;

public class LoginDialog extends JFrame 
{
   
   /**
   ��¼����
    */
   private static final long serialVersionUID = 1L;
   
   /**
   ���˳�����ť
    */
   private static String userStr;
   private LoginPanel loginPanel = null;
   
   /**
   ��¼���
    */
   private JLabel jLabel = null;
   
   /**
   ���û�������ǩ
    */
   private JTextField userField = null;
   
   /**
   ���û������ı���
    */
   private JLabel jLabel1 = null;
   
   /**
   �����롱��ǩ
    */
   private JPasswordField passwordField = null;
   
   /**
   �����롱�ı���
    */
   private JButton loginButton = null;
   
   /**
   ����¼����ť
    */
   private JButton exitButton = null;
   
   /**
   ���û������ı����е�����
    */
   private MainFrame mainFrame;
   
   /**
   ������
   @roseuid 5D0B97C70024
    */
   public LoginDialog() 
   {// ��¼����Ĺ��췽��
		try {
			// ���õ�¼����ķ��
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mainFrame = new MainFrame();// ʵ����������
			initialize();// ��ʼ����¼����
		} catch (Exception e) {
			e.printStackTrace();
		}    
   }
   
   /**
   @return com.WM.login.LoginPanel
   @roseuid 5D0B97C7002C
    */
   private LoginPanel getLoginPanel() 
   {// ��ʼ��loginPanel��¼���ķ���
		if (loginPanel == null) {// ��¼�����û�����ʱ
			jLabel1 = new JLabel();// �����롱��ǩ
			jLabel1.setBounds(new Rectangle(86, 71, 55, 18));// ���á����롱��ǩ��λ������
			jLabel1.setText("�ܡ��룺");// ���á����롱��ǩ���ı�����
			jLabel = new JLabel();// ���û�������ǩ
			jLabel.setText("�û�����");// ���á��û�������ǩ���ı�����
			jLabel.setBounds(new Rectangle(85, 41, 56, 18));// ���á��û�������ǩ��λ������
			loginPanel = new LoginPanel();// ��¼���
			loginPanel.setLayout(null);// ���õ�¼���Ĳ���Ϊ���Բ���
			loginPanel.setBackground(new Color(0xD8DDC7));// ���õ�¼���ı���ɫ
			loginPanel.add(jLabel, null);// �ѡ��û�������ǩ���ڵ�¼�����
			loginPanel.add(getUserField(), null);// �ѡ��û������ı������ڵ�¼�����
			loginPanel.add(jLabel1, null);// �ѡ����롱��ǩ���ڵ�¼�����
			loginPanel.add(getPasswordField(), null);// �ѡ����롱�ı������ڵ�¼�����
			loginPanel.add(getLoginButton(), null);// �ѡ���¼����ť���ڵ�¼�����
			loginPanel.add(getExitButton(), null);// �ѡ��˳�����ť���ڵ�¼�����
		}
		return loginPanel;// ���ص�¼���    
   }
   
   /**
   @return javax.swing.JTextField
   @roseuid 5D0B97C70043
    */
   private JTextField getUserField() 
   {// ��ʼ�����û������ı���
		if (userField == null) {// ���û������ı������Ϊ��ʱ
			userField = new JTextField();// ʵ�������û������ı���
			userField.setBounds(new Rectangle(142, 39, 127, 22));// ���á��û������ı����λ�úͿ��
		}
		return userField;// ���ء��û������ı���    
   }
   
   /**
   @return javax.swing.AccessibleJPasswordField.JPasswordField
   @roseuid 5D0B97C7005A
    */
   private  JPasswordField getPasswordField() 
   {// ��ʼ�������롱�ı���
		if (passwordField == null) {// �����롱�ı������Ϊ��ʱ
			passwordField = new JPasswordField();// ʵ���������롱�ı���
			passwordField.setBounds(new Rectangle(143, 69, 125, 22));// ���á����롱�ı����λ�úͿ��
			passwordField.addKeyListener(new KeyAdapter() {// Ϊ�����롱�ı�����Ӽ���ʱ��ļ���
				public void keyTyped(KeyEvent e) {
					if (e.getKeyChar() == '\n')// ���µİ����ǻس�ʱ
						loginButton.doClick();// ����¼����ťִ�е���¼�
				}
			});
		}
		return passwordField;// ���ء����롱�ı���    
   }
   
   /**
   @return javax.swing.AccessibleJButton.JButton
   @roseuid 5D0B97C700A1
    */
   private JButton getLoginButton() 
   {// ��ʼ������¼����ť
		if (loginButton == null) {// ����¼����ť����Ϊ��ʱ
			loginButton = new JButton();// ʵ��������¼����ť
			loginButton.setBounds(new Rectangle(109, 114, 48, 20));// ���á���¼����ť��λ�úͿ��
			loginButton.setIcon(new ImageIcon(getClass().getResource("/res/loginButton.jpg")));// ���á���¼����ť��ͼ��
			loginButton.addActionListener(new ActionListener() {// Ϊ����¼����ť��Ӷ����¼��ļ���
				public void actionPerformed(ActionEvent e) {
					try {
						userStr = userField.getText();// ��á��û������ı����е�����
						String passStr = new String(passwordField.getPassword());// ��á����롱�ı����е�����
						
//						  if (!DAO.checkLogin(userStr, passStr)) 
//						  {// ��֤�û���������ʧ��
//							  JOptionPane.showMessageDialog(LoginDialog.this, "�û����������޷���¼", "��¼ʧ��",
//									  JOptionPane.ERROR_MESSAGE);// ��������¼ʧ�ܡ��Ի��� //
//							  //return; 
//						  }
						 
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);// ����������Ĺرշ�ʽ
					mainFrame.setVisible(true);// ʹ������ɼ�
					MainFrame.getCzyStateLabel().setText(userStr);// �����������в���Ա��ǩ��������
					setVisible(false);// ʹ��¼���岻�ɼ�
				}
			});
		}
		return loginButton;// ���ء���¼����ť    
   }
   
   /**
   @return javax.swing.AccessibleJButton.JButton
   @roseuid 5D0B97C700BA
    */
   private JButton getExitButton() 
   {// ��ʼ�����˳�����ť
		if (exitButton == null) {// ���˳�����ť����Ϊ��ʱ
			exitButton = new JButton();// ʵ�������˳�����ť
			exitButton.setBounds(new Rectangle(181, 114, 48, 20));// ���á��˳�����ť��λ�úͿ��
			exitButton.setIcon(new ImageIcon(getClass().getResource("/res/exitButton.jpg")));// ���á��˳�����ť��ͼ��
			exitButton.addActionListener(new ActionListener() {// Ϊ���˳�����ť��Ӷ����¼��ļ���
				public void actionPerformed(ActionEvent e) {
					System.exit(0);// �˳���ǰ��Ӧ�ó���
				}
			});
		}
		return exitButton;// ���ء��˳�����ť    
   }
   
   /**
   @roseuid 5D0B97C700D2
    */
   private void initialize() 
   {// ��ʼ����¼����
		Dimension size = getToolkit().getScreenSize();// �����Ļ�ߴ�
		setLocation((size.width - 296) / 2, (size.height - 188) / 2);// ���õ�¼����
		setSize(296, 188);// ���õ�¼����Ŀ��
		this.setTitle("ϵͳ��¼");// ���õ�¼����ı���
		setContentPane(getLoginPanel());// ����¼������ڵ�¼������    
   }
   
   /**
   @return java.lang.String
   @roseuid 5D0B97C700DD
    */
   public String getUserStr() 
   {// ��á��û������ı����е�����
		return userStr;// ���ء��û������ı����е�����    
   }
}
