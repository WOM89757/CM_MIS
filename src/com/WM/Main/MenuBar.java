//Source file: C:\\Users\\ï\\Desktop\\����\\������Ϣϵͳ\\MIS\\CMMIS\\src\\com\\WM\\Main\\MenuBar.java

package com.WM.Main;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.lang.reflect.Constructor;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import com.WM.iframe.basicinfo.staffGL;
import com.WM.Main.DesktopPanel;
import com.WM.iframe.basicinfo.customerGL;
import com.WM.iframe.basicinfo.goodsGL;
import com.WM.iframe.basicinfo.serviceitemGL;
import com.WM.iframe.infoQuery.sellsortQuery;
import com.WM.iframe.infoQuery.goodsQuery;
import com.WM.iframe.infoQuery.sellQuery;
import com.WM.iframe.inventoryGL.priceAlter;
import com.WM.iframe.inventoryGL.ruku;
import com.WM.iframe.inventoryGL.stockTaking;
import com.WM.iframe.shouyincenter.guadandaijie;
import com.WM.iframe.shouyincenter.shouyinGl;

public class MenuBar extends JMenuBar 
{
   
   /**
   �ڲ������λ������
    */
   private int nextFrameX;
   
   /**
   �ڲ������λ������
    */
   private int nextFrameY;
   
   /**
   �����ڲ�������������
    */
   private JDesktopPane desktopPanel = null;
   
   /**
   �ڲ�����ļ���
    */
   private Map iFrames = null;
   
   /**
   ״̬�����ڲ�������ʾ��ǩ
    */
   private JLabel stateLabel = null;
   
   /**
   ���������ģ��˵�
    */
   private JMenu shouyincentre_Menu = null;
   
   /**
   �������������˵��λ�ڣ��������ģ��˵���
    */
   private JMenuItem shouyincentre_Item = null;
   
   /**
   ���ҵ����ᣩ�˵��λ�ڣ��������ģ��˵���
    */
   private JMenuItem Guadandaijie_Item = null;
   
   /**
   ����Ϣ��ѯ���˵�
    */
   private JMenu xinxi_chaxunMenu = null;
   
   /**
   �����۲�ѯ���˵��λ�ڣ���Ϣ��ѯ���˵���
    */
   private JMenuItem xiaoshou_chaxunItem = null;
   
   /**
   ����Ʒ��ѯ���˵��λ�ڣ���Ϣ��ѯ���˵���
    */
   private JMenuItem shangpin_chaxunItem = null;
   
   /**
   ���������У��˵��λ�ڣ���Ϣ��ѯ���˵���
    */
   private JMenuItem xiaoshou_paihangItem = null;
   
   /**
   �����������˵�
    */
   private JMenu kucun_Menu = null;
   
   /**
   ������̵㣩�˵��λ�ڣ����������˵���
    */
   private JMenuItem kucun_pandianItem = null;
   
   /**
   ���۸�������˵��λ�ڣ����������˵���
    */
   private JMenuItem jiage_tiaozhengItem = null;
   
   /**
   ���������ϣ��˵�
    */
   private JMenu jiben_ziliaoMenu = null;
   
   /**
   ����Ʒ�������˵��λ�ڣ��������ϣ��˵���
    */
   private JMenuItem shangpin_guanliItem = null;
   
   /**
   ���ͻ��������˵��λ�ڣ��������ϣ��˵���
    */
   private JMenuItem kehu_guanliItem = null;
   
   /**
   ����Ӧ�̹������˵��λ�ڣ��������ϣ��˵���
    */
   private JMenuItem gys_guanliItem = null;
   
   /**
   �����������ã��˵��λ�ڣ��������ϣ��˵���
    */
   private JMenuItem jsr_guanliItem = null;
   
   /**
   �����ڣ��˵�
    */
   private JMenu chuang_kouMenu = null;
   
   /**
   ������ƽ�̣��˵��λ�ڣ����ڣ��˵���
    */
   private JMenuItem pingpuItem = null;
   
   /**
   ��ȫ���رգ��˵��λ�ڣ����ڣ��˵���
    */
   private JMenuItem closeAllItem = null;
   
   /**
   ��ȫ����С�����˵��λ�ڣ����ڣ��˵���
    */
   private JMenuItem allIconItem = null;
   
   /**
   ��ȫ����ԭ���˵��λ�ڣ����ڣ��˵���
    */
   private JMenuItem allResumeItem = null;
   
   /**
   ���������˵�
    */
   private JMenu bang_zhuMenu = null;
   
   /**
   �����ڣ��˵��λ�ڣ��������˵���
    */
   private JMenuItem guanyu_Item = null;
   
   /**
   ����ϵ����֧�֣��˵��λ�ڣ��������˵���
    */
   private JMenuItem bugItem = null;
   
   /**
   �����ʼ�����վ���˵��λ�ڣ��������˵���
    */
   private JMenuItem fangwen_wangzhanItem = null;
   
   /**
   ���˳����˵��λ�ڣ�ϵͳά�����˵���
    */
   private JMenuItem exitItem = null;
   
   /**
   @param desktopPanel
   @param label
   @roseuid 5D0B97CC0095
    */
   public MenuBar(JDesktopPane desktopPanel, JLabel label) 
   {
		super();
		iFrames = new HashMap<JMenuItem, JInternalFrame>();
		this.desktopPanel = desktopPanel;
		this.stateLabel = label;
		
		initialize();    
   }
   
   /**
   Ĭ�ϵĹ��췽��
   @roseuid 5D0B97CC0088
    */
   private MenuBar() 
   {
    
   }
   
   /**
   ��ʼ���˵�������ķ���
   @roseuid 5D0B97CC00DD
    */
   private void initialize() 
   {
		this.setSize(new Dimension(600, 24));
		
		add(getShouyincentre_Menu());
		
		
		add(getXinxi_chaxunMenu());
		add(getJiben_ziliaoMenu());
		/*add(getJinhuo_Menu());
		 *  
		 *  add(getXitong_weihuMenu());
		 */
		add(getKucun_Menu());
		add(getChuang_kouMenu());
		add(getBang_zhuMenu());    
   }
   
   /**
   ��ʼ�����������ģ��˵��ķ������÷�������˵�����ڲ����壬��ʹ���崦����ѡ��״
   ̬��
   @return javax.swing.JMenu
   @roseuid 5D0B97CC00E9
    */
   public JMenu getShouyincentre_Menu() 
   {
		if (shouyincentre_Menu == null) {
			shouyincentre_Menu = new JMenu();
			shouyincentre_Menu.setText("��������(X)");
			shouyincentre_Menu.setMnemonic(KeyEvent.VK_X);
			shouyincentre_Menu.add(getShouyincentre_Item());
			shouyincentre_Menu.add(getGuadandaijie_Item());
		}
		return shouyincentre_Menu;    
   }
   
   /**
   ��ʼ������Ϣ��ѯ���˵��ķ���
   @return javax.swing.JMenu
   @roseuid 5D0B97CC00FD
    */
   public JMenu getXinxi_chaxunMenu() 
   {
		if (xinxi_chaxunMenu == null) {
			xinxi_chaxunMenu = new JMenu();
			xinxi_chaxunMenu.setText("��Ϣ��ѯ(C)");
			xinxi_chaxunMenu.setMnemonic(KeyEvent.VK_C);
			xinxi_chaxunMenu.add(getXiaoshou_chaxunItem());
			xinxi_chaxunMenu.add(getShangpin_chaxunItem());
			xinxi_chaxunMenu.addSeparator();
			xinxi_chaxunMenu.add(getXiaoshou_paihangItem());
		}
		return xinxi_chaxunMenu;    
   }
   
   /**
   ��ʼ���������������˵���ķ���
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC0111
    */
   public JMenuItem getShouyincentre_Item() 
   {
		if (shouyincentre_Item == null) {
			shouyincentre_Item = new JMenuItem();
			shouyincentre_Item.setText("��������");
			shouyincentre_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/xiaoshoudan.png")));
			shouyincentre_Item.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					createIFrame(shouyincentre_Item, shouyinGl.class);
				}
			});
		}
		return shouyincentre_Item;    
   }
   
   /**
   ��ʼ�����ҵ����ᣩ�˵���ķ���
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC0125
    */
   public JMenuItem getGuadandaijie_Item() 
   {
		if (Guadandaijie_Item == null) {
			Guadandaijie_Item = new JMenuItem();
			Guadandaijie_Item.setText("�ҵ�����");
			Guadandaijie_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/xiaoshou_tuihuo.png")));
			Guadandaijie_Item.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					createIFrame(Guadandaijie_Item, guadandaijie.class);
				}
			});
		}
		return Guadandaijie_Item;    
   }
   
   /**
   ��ʼ�������۲�ѯ���˵���ķ���
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC013E
    */
   public JMenuItem getXiaoshou_chaxunItem() 
   {
		if (xiaoshou_chaxunItem == null) {
			xiaoshou_chaxunItem = new JMenuItem();
			xiaoshou_chaxunItem.setText("���۲�ѯ");
			xiaoshou_chaxunItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/xiaoshou_chaxun.png")));
			xiaoshou_chaxunItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					createIFrame(xiaoshou_chaxunItem, sellQuery.class);
				}
			});
		}
		return xiaoshou_chaxunItem;    
   }
   
   /**
   ��ʼ������Ʒ��ѯ���˵���ķ���
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC0152
    */
   public JMenuItem getShangpin_chaxunItem() 
   {
		if (shangpin_chaxunItem == null) {
			shangpin_chaxunItem = new JMenuItem();
			shangpin_chaxunItem.setText("��Ʒ��ѯ");
			shangpin_chaxunItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/shangpin_chaxun.png")));
			shangpin_chaxunItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					createIFrame(shangpin_chaxunItem, goodsQuery.class);
				}
			});
		}
		return shangpin_chaxunItem;    
   }
   
   /**
   ��ʼ�����������У��˵���ķ���
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC0167
    */
   public JMenuItem getXiaoshou_paihangItem() 
   {
		if (xiaoshou_paihangItem == null) {
			xiaoshou_paihangItem = new JMenuItem();
			xiaoshou_paihangItem.setText("��������");
			xiaoshou_paihangItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/xiaoshou_paihang.png")));
			xiaoshou_paihangItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					createIFrame(xiaoshou_paihangItem, sellsortQuery.class);
				}
			});
		}
		return xiaoshou_paihangItem;    
   }
   
   /**
   ��ʼ�����������ϣ��˵��ķ���
   @return javax.swing.JMenu
   @roseuid 5D0B97CC017B
    */
   public JMenu getJiben_ziliaoMenu() 
   {
		if (jiben_ziliaoMenu == null) {
			jiben_ziliaoMenu = new JMenu();
			jiben_ziliaoMenu.setText("��������(B)");
			jiben_ziliaoMenu.setMnemonic(KeyEvent.VK_B);
			jiben_ziliaoMenu.add(getShangpin_guanliItem());
			jiben_ziliaoMenu.add(getKehu_guanliItem());
			jiben_ziliaoMenu.add(getGys_guanliItem());
			jiben_ziliaoMenu.addSeparator();
			//jiben_ziliaoMenu.add(getJsr_guanliItem());
		}
		return jiben_ziliaoMenu;    
   }
   
   /**
   ��ʼ������Ʒ�������˵���ķ���
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC0190
    */
   public JMenuItem getShangpin_guanliItem() 
   {
		if (shangpin_guanliItem == null) {
			shangpin_guanliItem = new JMenuItem();
			shangpin_guanliItem.setText("��Ʒ����");
			shangpin_guanliItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/shangpin_guanli.png")));
			shangpin_guanliItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					createIFrame(shangpin_guanliItem, goodsGL.class);
				}
			});
		}
		return shangpin_guanliItem;    
   }
   
   /**
   ��ʼ������Ա�������˵���ķ���
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC01C3
    */
   public JMenuItem getKehu_guanliItem() 
   {
		if (kehu_guanliItem == null) {
			kehu_guanliItem = new JMenuItem();
			kehu_guanliItem.setText("��Ա����");
			kehu_guanliItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/kehu_guanli.png")));
			kehu_guanliItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					createIFrame(kehu_guanliItem, customerGL.class);
				}
			});
		}
		return kehu_guanliItem;    
   }
   
   /**
   ��ʼ����������Ŀ�������˵���ķ���
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC01E0
    */
   public JMenuItem getGys_guanliItem() 
   {
		if (gys_guanliItem == null) {
			gys_guanliItem = new JMenuItem();
			gys_guanliItem.setText("������Ŀ����");
			gys_guanliItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/gys_guanli.png")));
			gys_guanliItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					createIFrame(gys_guanliItem, serviceitemGL.class);
				}
			});
		}
		return gys_guanliItem;    
   }
   
   /**
   ��ʼ����Ա���������˵���ķ���
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC01F7
    */
   public JMenuItem getJsr_guanliItem() 
   {
		if (jsr_guanliItem == null) {
			jsr_guanliItem = new JMenuItem();
			jsr_guanliItem.setText("Ա������");
			jsr_guanliItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/jsr_shezhi.png")));
			jsr_guanliItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//createIFrame(jsr_guanliItem, staffGL.class);
				}
			});
		}
		return jsr_guanliItem;    
   }
   
   /**
   ��ʼ�������������˵��ķ���
   @return javax.swing.JMenu
   @roseuid 5D0B97CC020C
    */
   public JMenu getKucun_Menu() 
   {
		if (kucun_Menu == null) {
			kucun_Menu = new JMenu();
			kucun_Menu.setText("������(K)");
			kucun_Menu.setMnemonic(KeyEvent.VK_K);
			kucun_Menu.add(getKucun_pandianItem());
			//kucun_Menu.add(getJiage_tiaozhengItem());
		}
		return kucun_Menu;    
   }
   
   /**
   ��ʼ��������̵㣩�˵���ķ���
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC0233
    */
   public JMenuItem getKucun_pandianItem() 
   {
		if (kucun_pandianItem == null) {
			kucun_pandianItem = new JMenuItem();
			kucun_pandianItem.setText("������");
			kucun_pandianItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/kucun_pandian.png")));
			kucun_pandianItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					createIFrame(kucun_pandianItem, ruku.class);
				}
			});
		}
		return kucun_pandianItem;    
   }
   
   /**
   ��ʼ�����۸�������˵���ķ���
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC024B
    */
   public JMenuItem getJiage_tiaozhengItem() 
   {
		if (jiage_tiaozhengItem == null) {
			jiage_tiaozhengItem = new JMenuItem();
			jiage_tiaozhengItem.setText("�۸����");
			jiage_tiaozhengItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/jiage_tiaozheng.png")));
			jiage_tiaozhengItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					createIFrame(jiage_tiaozhengItem, priceAlter.class);
				}
			});
		}
		return jiage_tiaozhengItem;    
   }
   
   /**
   ��ʼ�����ڲ˵��ķ���
   @return javax.swing.JMenu
   @roseuid 5D0B97CC0264
    */
   public JMenu getChuang_kouMenu() 
   {
		if (chuang_kouMenu == null) {
			chuang_kouMenu = new JMenu();
			chuang_kouMenu.setText("����(W)");
			chuang_kouMenu.setMnemonic(KeyEvent.VK_W);
			chuang_kouMenu.addMenuListener(new MenuListener() {
				public void menuSelected(MenuEvent e) {
					chuang_kouMenu.removeAll();
					chuang_kouMenu.add(getPingpuItem());
					chuang_kouMenu.add(getClassAllItem());
					chuang_kouMenu.add(getAllIconItem());
					chuang_kouMenu.add(getAllResumeItem());
					chuang_kouMenu.addSeparator();
					int count = 0;
					// ��ȡ��������������ڲ�����
					JInternalFrame[] allFrames = desktopPanel.getAllFrames();
					// Foreach�����ڲ���������
					for (final JInternalFrame frame : allFrames) {
						String frameTitle = frame.getTitle();
						count++;// ���������
						final JMenuItem item = new JMenuItem(count + "  " + frameTitle);// ��������˵���
						chuang_kouMenu.add(item);// ���Ӳ˵���˵���
						item.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {// ��������˵���ĵ����¼�
									frame.setIcon(false);
									frame.setSelected(true);
								} catch (PropertyVetoException e1) {
									e1.printStackTrace();
								}
							}
						});
					}
				}

				public void menuDeselected(javax.swing.event.MenuEvent e) {
				}

				public void menuCanceled(javax.swing.event.MenuEvent e) {
				}
			});
		}
		return chuang_kouMenu;    
   }
   
   /**
   ��ʼ��������ƽ�̣��˵���ķ���
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC027E
    */
   public JMenuItem getPingpuItem() 
   {
		if (pingpuItem == null) {
			pingpuItem = new JMenuItem();
			pingpuItem.setText("���ڲ��");
			pingpuItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/chuangkou_pingpu.png")));
			pingpuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JInternalFrame[] allFrames = desktopPanel.getAllFrames();
					int x = 0, y = 0;
					for (JInternalFrame iFrame : allFrames) {
						iFrame.setLocation(x, y);
						try {
							iFrame.setSelected(true);
						} catch (PropertyVetoException e1) {
							e1.printStackTrace();
						}
						int frameH = iFrame.getPreferredSize().height;
						int panelH = iFrame.getContentPane().getPreferredSize().height;
						int fSpacing = frameH - panelH;
						x += fSpacing;
						y += fSpacing;
						if (x + getWidth() / 2 > desktopPanel.getWidth())
							x = 0;
						if (y + getHeight() / 2 > desktopPanel.getHeight())
							y = 0;
					}
				}
			});
		}
		return pingpuItem;    
   }
   
   /**
   ��ʼ����ȫ���رգ��˵���ķ���
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC02AD
    */
   private JMenuItem getClassAllItem() 
   {
		if (closeAllItem == null) {
			closeAllItem = new JMenuItem();
			closeAllItem.setText("ȫ���ر�");
			closeAllItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/quanbu_guanbi.png")));
			closeAllItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JInternalFrame[] allFrames = desktopPanel.getAllFrames();
					for (JInternalFrame frame : allFrames) {
						frame.doDefaultCloseAction();
					}
				}
			});
		}
		return closeAllItem;    
   }
   
   /**
   ��ʼ����ȫ����С�����˵���ķ���
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC02C3
    */
   private JMenuItem getAllIconItem() 
   {
		if (allIconItem == null) {
			allIconItem = new JMenuItem();
			allIconItem.setText("ȫ����С��");
			allIconItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/quanbu_zuixiaohua.png")));
			allIconItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JInternalFrame[] allFrames = desktopPanel.getAllFrames();
					for (JInternalFrame frame : allFrames) {
						try {
							frame.setIcon(true);
						} catch (PropertyVetoException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
		}
		return allIconItem;    
   }
   
   /**
   ��ʼ����ȫ����ԭ���˵���ķ���
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC02D9
    */
   private JMenuItem getAllResumeItem() 
   {
		if (allResumeItem == null) {
			allResumeItem = new JMenuItem();
			allResumeItem.setText("ȫ����ԭ");
			allResumeItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/quanbu_huanyuan.png")));
			allResumeItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JInternalFrame[] allFrames = desktopPanel.getAllFrames();
					for (JInternalFrame frame : allFrames) {
						try {
							frame.setIcon(false);
						} catch (PropertyVetoException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
		}
		return allResumeItem;    
   }
   
   /**
   ��ʼ�����������˵��ķ���
   @return javax.swing.JMenu
   @roseuid 5D0B97CC02EF
    */
   public JMenu getBang_zhuMenu() 
   {
		if (bang_zhuMenu == null) {
			bang_zhuMenu = new JMenu();
			bang_zhuMenu.setText("����(H)");
			bang_zhuMenu.setMnemonic(KeyEvent.VK_H);
			bang_zhuMenu.add(getGuanyu_Item());
			bang_zhuMenu.add(getBugItem());
			bang_zhuMenu.add(getFangwen_wangzhanItem());
		}
		return bang_zhuMenu;    
   }
   
   /**
   ��ʼ�������ڣ��˵���ķ���
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC0322
    */
   private JMenuItem getGuanyu_Item() 
   {
		if (guanyu_Item == null) {
			guanyu_Item = new JMenuItem();
			guanyu_Item.setText("����");
			guanyu_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/guanyu.png")));
			URL url = DesktopPanel.class.getResource("/res/about.jpg");
			ImageIcon aboutImage = new ImageIcon(url);
			final JLabel imgLabel = new JLabel(aboutImage);
			imgLabel.setVisible(false);
			desktopPanel.add(imgLabel);
			desktopPanel.setLayer(imgLabel, Integer.MAX_VALUE);
			guanyu_Item.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int dw = desktopPanel.getWidth();
					int dh = desktopPanel.getHeight();
					imgLabel.setBounds((dw - 500) / 2, (dh - 350) / 2, 500, 350);
					imgLabel.setVisible(true);
				}
			});
			imgLabel.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					imgLabel.setVisible(false);
				}
			});
		}
		return guanyu_Item;    
   }
   
   /**
   ��ʼ������ϵ����֧�֣��˵���ķ���
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC033D
    */
   public JMenuItem getBugItem() 
   {
		if (bugItem == null) {
			bugItem = new JMenuItem();
			bugItem.setText("��ϵ����֧��");
			bugItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/jishu_zhichi.png")));
			bugItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (Desktop.isDesktopSupported()) {
						Desktop desktop = Desktop.getDesktop();
						try {
							URI uri = new URI("mailto:971716804@qq.com");
							desktop.mail(uri);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
			});
		}
		return bugItem;    
   }
   
   /**
   ��ʼ�������ʼ�����վ���˵���ķ���
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC0356
    */
   public JMenuItem getFangwen_wangzhanItem() 
   {
		if (fangwen_wangzhanItem == null) {
			fangwen_wangzhanItem = new JMenuItem();
			fangwen_wangzhanItem.setText("���ʼ�����վ");
			fangwen_wangzhanItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/jishu_wangzhan.png")));
			fangwen_wangzhanItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (Desktop.isDesktopSupported()) {
						Desktop desktop = Desktop.getDesktop();
						try {
							URL url = new URL("http://www.51cto.com/");
							desktop.browse(url.toURI());
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
			});
		}
		return fangwen_wangzhanItem;    
   }
   
   /**
   ��ʼ�����˳�ϵͳ���˵���ķ���
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC036F
    */
   public JMenuItem getExitItem() 
   {
		if (exitItem == null) {
			exitItem = new JMenuItem();
			exitItem.setText("�˳�ϵͳ");
			exitItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/tuichu_xitong.png")));
			exitItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return exitItem;    
   }
   
   /**
   �����ڲ�����ķ������÷���ʹ�÷��似����ȡ�ڲ�����Ĺ��췽�����Ӷ������ڲ����塣
   @param item��������ڲ�����Ĳ˵���
   @param clazz���ڲ������Class����
   @param item
   @param clazz
   @return javax.swing.JInternalFrame
   @roseuid 5D0B97CC038D
    */
   private JInternalFrame createIFrame(JMenuItem item, Class clazz) 
   {
		Constructor constructor = clazz.getConstructors()[0];
		JInternalFrame iFrame = (JInternalFrame) iFrames.get(item);
		try {
			if (iFrame == null || iFrame.isClosed()) {
				iFrame = (JInternalFrame) constructor.newInstance(new Object[] {});
				iFrames.put(item, iFrame);
				iFrame.setFrameIcon(item.getIcon());
				iFrame.setLocation(nextFrameX, nextFrameY);
				int frameH = iFrame.getPreferredSize().height;
				int panelH = iFrame.getContentPane().getPreferredSize().height;
				int fSpacing = frameH - panelH;
				nextFrameX += fSpacing;
				nextFrameY += fSpacing;
				if (nextFrameX + iFrame.getWidth() > desktopPanel.getWidth())
					nextFrameX = 0;
				if (nextFrameY + iFrame.getHeight() > desktopPanel.getHeight())
					nextFrameY = 0;
				desktopPanel.add(iFrame);
				iFrame.setResizable(false);
				iFrame.setMaximizable(false);
				iFrame.setVisible(true);
			}
			iFrame.setSelected(true);
			stateLabel.setText(iFrame.getTitle());
			iFrame.addInternalFrameListener(new InternalFrameAdapter() {
				public void internalFrameActivated(InternalFrameEvent e) {
					super.internalFrameActivated(e);
					JInternalFrame frame = e.getInternalFrame();
					stateLabel.setText(frame.getTitle());
				}

				public void internalFrameDeactivated(InternalFrameEvent e) {
					stateLabel.setText("û��ѡ����");
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return iFrame;    
   }
}