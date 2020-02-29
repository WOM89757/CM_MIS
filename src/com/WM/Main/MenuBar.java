//Source file: C:\\Users\\茂\\Desktop\\课设\\管理信息系统\\MIS\\CMMIS\\src\\com\\WM\\Main\\MenuBar.java

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
   内部窗体的位置坐标
    */
   private int nextFrameX;
   
   /**
   内部窗体的位置坐标
    */
   private int nextFrameY;
   
   /**
   容纳内部窗体的桌面面板
    */
   private JDesktopPane desktopPanel = null;
   
   /**
   内部窗体的集合
    */
   private Map iFrames = null;
   
   /**
   状态栏的内部窗体提示标签
    */
   private JLabel stateLabel = null;
   
   /**
   （收银中心）菜单
    */
   private JMenu shouyincentre_Menu = null;
   
   /**
   （快速收银）菜单项，位于（收银中心）菜单内
    */
   private JMenuItem shouyincentre_Item = null;
   
   /**
   （挂单待结）菜单项，位于（收银中心）菜单内
    */
   private JMenuItem Guadandaijie_Item = null;
   
   /**
   （信息查询）菜单
    */
   private JMenu xinxi_chaxunMenu = null;
   
   /**
   （销售查询）菜单项，位于（信息查询）菜单内
    */
   private JMenuItem xiaoshou_chaxunItem = null;
   
   /**
   （商品查询）菜单项，位于（信息查询）菜单内
    */
   private JMenuItem shangpin_chaxunItem = null;
   
   /**
   （销售排行）菜单项，位于（信息查询）菜单内
    */
   private JMenuItem xiaoshou_paihangItem = null;
   
   /**
   （库存管理）菜单
    */
   private JMenu kucun_Menu = null;
   
   /**
   （库存盘点）菜单项，位于（库存管理）菜单内
    */
   private JMenuItem kucun_pandianItem = null;
   
   /**
   （价格调整）菜单项，位于（库存管理）菜单内
    */
   private JMenuItem jiage_tiaozhengItem = null;
   
   /**
   （基本资料）菜单
    */
   private JMenu jiben_ziliaoMenu = null;
   
   /**
   （商品管理）菜单项，位于（基本资料）菜单内
    */
   private JMenuItem shangpin_guanliItem = null;
   
   /**
   （客户管理）菜单项，位于（基本资料）菜单内
    */
   private JMenuItem kehu_guanliItem = null;
   
   /**
   （供应商管理）菜单项，位于（基本资料）菜单内
    */
   private JMenuItem gys_guanliItem = null;
   
   /**
   （经手人设置）菜单项，位于（基本资料）菜单内
    */
   private JMenuItem jsr_guanliItem = null;
   
   /**
   （窗口）菜单
    */
   private JMenu chuang_kouMenu = null;
   
   /**
   （窗口平铺）菜单项，位于（窗口）菜单内
    */
   private JMenuItem pingpuItem = null;
   
   /**
   （全部关闭）菜单项，位于（窗口）菜单内
    */
   private JMenuItem closeAllItem = null;
   
   /**
   （全部最小化）菜单项，位于（窗口）菜单内
    */
   private JMenuItem allIconItem = null;
   
   /**
   （全部还原）菜单项，位于（窗口）菜单内
    */
   private JMenuItem allResumeItem = null;
   
   /**
   （帮助）菜单
    */
   private JMenu bang_zhuMenu = null;
   
   /**
   （关于）菜单项，位于（帮助）菜单内
    */
   private JMenuItem guanyu_Item = null;
   
   /**
   （联系技术支持）菜单项，位于（帮助）菜单内
    */
   private JMenuItem bugItem = null;
   
   /**
   （访问技术网站）菜单项，位于（帮助）菜单内
    */
   private JMenuItem fangwen_wangzhanItem = null;
   
   /**
   （退出）菜单项，位于（系统维护）菜单内
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
   默认的构造方法
   @roseuid 5D0B97CC0088
    */
   private MenuBar() 
   {
    
   }
   
   /**
   初始化菜单栏界面的方法
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
   初始化（收银中心）菜单的方法，该方法定义菜单项打开内部窗体，并使窗体处于已选择状
   态。
   @return javax.swing.JMenu
   @roseuid 5D0B97CC00E9
    */
   public JMenu getShouyincentre_Menu() 
   {
		if (shouyincentre_Menu == null) {
			shouyincentre_Menu = new JMenu();
			shouyincentre_Menu.setText("收银中心(X)");
			shouyincentre_Menu.setMnemonic(KeyEvent.VK_X);
			shouyincentre_Menu.add(getShouyincentre_Item());
			shouyincentre_Menu.add(getGuadandaijie_Item());
		}
		return shouyincentre_Menu;    
   }
   
   /**
   初始化（信息查询）菜单的方法
   @return javax.swing.JMenu
   @roseuid 5D0B97CC00FD
    */
   public JMenu getXinxi_chaxunMenu() 
   {
		if (xinxi_chaxunMenu == null) {
			xinxi_chaxunMenu = new JMenu();
			xinxi_chaxunMenu.setText("信息查询(C)");
			xinxi_chaxunMenu.setMnemonic(KeyEvent.VK_C);
			xinxi_chaxunMenu.add(getXiaoshou_chaxunItem());
			xinxi_chaxunMenu.add(getShangpin_chaxunItem());
			xinxi_chaxunMenu.addSeparator();
			xinxi_chaxunMenu.add(getXiaoshou_paihangItem());
		}
		return xinxi_chaxunMenu;    
   }
   
   /**
   初始化（快速收银）菜单项的方法
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC0111
    */
   public JMenuItem getShouyincentre_Item() 
   {
		if (shouyincentre_Item == null) {
			shouyincentre_Item = new JMenuItem();
			shouyincentre_Item.setText("快速收银");
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
   初始化（挂单待结）菜单项的方法
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC0125
    */
   public JMenuItem getGuadandaijie_Item() 
   {
		if (Guadandaijie_Item == null) {
			Guadandaijie_Item = new JMenuItem();
			Guadandaijie_Item.setText("挂单待结");
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
   初始化（销售查询）菜单项的方法
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC013E
    */
   public JMenuItem getXiaoshou_chaxunItem() 
   {
		if (xiaoshou_chaxunItem == null) {
			xiaoshou_chaxunItem = new JMenuItem();
			xiaoshou_chaxunItem.setText("销售查询");
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
   初始化（商品查询）菜单项的方法
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC0152
    */
   public JMenuItem getShangpin_chaxunItem() 
   {
		if (shangpin_chaxunItem == null) {
			shangpin_chaxunItem = new JMenuItem();
			shangpin_chaxunItem.setText("商品查询");
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
   初始化（销售排行）菜单项的方法
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC0167
    */
   public JMenuItem getXiaoshou_paihangItem() 
   {
		if (xiaoshou_paihangItem == null) {
			xiaoshou_paihangItem = new JMenuItem();
			xiaoshou_paihangItem.setText("销售排行");
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
   初始化（基本资料）菜单的方法
   @return javax.swing.JMenu
   @roseuid 5D0B97CC017B
    */
   public JMenu getJiben_ziliaoMenu() 
   {
		if (jiben_ziliaoMenu == null) {
			jiben_ziliaoMenu = new JMenu();
			jiben_ziliaoMenu.setText("基本资料(B)");
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
   初始化（商品管理）菜单项的方法
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC0190
    */
   public JMenuItem getShangpin_guanliItem() 
   {
		if (shangpin_guanliItem == null) {
			shangpin_guanliItem = new JMenuItem();
			shangpin_guanliItem.setText("商品管理");
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
   初始化（会员管理）菜单项的方法
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC01C3
    */
   public JMenuItem getKehu_guanliItem() 
   {
		if (kehu_guanliItem == null) {
			kehu_guanliItem = new JMenuItem();
			kehu_guanliItem.setText("会员管理");
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
   初始化（服务项目管理）菜单项的方法
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC01E0
    */
   public JMenuItem getGys_guanliItem() 
   {
		if (gys_guanliItem == null) {
			gys_guanliItem = new JMenuItem();
			gys_guanliItem.setText("服务项目管理");
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
   初始化（员工管理）菜单项的方法
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC01F7
    */
   public JMenuItem getJsr_guanliItem() 
   {
		if (jsr_guanliItem == null) {
			jsr_guanliItem = new JMenuItem();
			jsr_guanliItem.setText("员工管理");
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
   初始化（库存管理）菜单的方法
   @return javax.swing.JMenu
   @roseuid 5D0B97CC020C
    */
   public JMenu getKucun_Menu() 
   {
		if (kucun_Menu == null) {
			kucun_Menu = new JMenu();
			kucun_Menu.setText("库存管理(K)");
			kucun_Menu.setMnemonic(KeyEvent.VK_K);
			kucun_Menu.add(getKucun_pandianItem());
			//kucun_Menu.add(getJiage_tiaozhengItem());
		}
		return kucun_Menu;    
   }
   
   /**
   初始化（库存盘点）菜单项的方法
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC0233
    */
   public JMenuItem getKucun_pandianItem() 
   {
		if (kucun_pandianItem == null) {
			kucun_pandianItem = new JMenuItem();
			kucun_pandianItem.setText("入库管理");
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
   初始化（价格调整）菜单项的方法
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC024B
    */
   public JMenuItem getJiage_tiaozhengItem() 
   {
		if (jiage_tiaozhengItem == null) {
			jiage_tiaozhengItem = new JMenuItem();
			jiage_tiaozhengItem.setText("价格调整");
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
   初始化窗口菜单的方法
   @return javax.swing.JMenu
   @roseuid 5D0B97CC0264
    */
   public JMenu getChuang_kouMenu() 
   {
		if (chuang_kouMenu == null) {
			chuang_kouMenu = new JMenu();
			chuang_kouMenu.setText("窗口(W)");
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
					// 获取桌面面板中所有内部窗体
					JInternalFrame[] allFrames = desktopPanel.getAllFrames();
					// Foreach遍历内部窗体数组
					for (final JInternalFrame frame : allFrames) {
						String frameTitle = frame.getTitle();
						count++;// 窗体计数器
						final JMenuItem item = new JMenuItem(count + "  " + frameTitle);// 创建窗体菜单项
						chuang_kouMenu.add(item);// 添加菜单项到菜单中
						item.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {// 处理窗体菜单项的单击事件
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
   初始化（窗口平铺）菜单项的方法
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC027E
    */
   public JMenuItem getPingpuItem() 
   {
		if (pingpuItem == null) {
			pingpuItem = new JMenuItem();
			pingpuItem.setText("窗口层叠");
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
   初始化（全部关闭）菜单项的方法
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC02AD
    */
   private JMenuItem getClassAllItem() 
   {
		if (closeAllItem == null) {
			closeAllItem = new JMenuItem();
			closeAllItem.setText("全部关闭");
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
   初始化（全部最小化）菜单项的方法
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC02C3
    */
   private JMenuItem getAllIconItem() 
   {
		if (allIconItem == null) {
			allIconItem = new JMenuItem();
			allIconItem.setText("全部最小化");
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
   初始化（全部还原）菜单项的方法
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC02D9
    */
   private JMenuItem getAllResumeItem() 
   {
		if (allResumeItem == null) {
			allResumeItem = new JMenuItem();
			allResumeItem.setText("全部还原");
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
   初始化（帮助）菜单的方法
   @return javax.swing.JMenu
   @roseuid 5D0B97CC02EF
    */
   public JMenu getBang_zhuMenu() 
   {
		if (bang_zhuMenu == null) {
			bang_zhuMenu = new JMenu();
			bang_zhuMenu.setText("帮助(H)");
			bang_zhuMenu.setMnemonic(KeyEvent.VK_H);
			bang_zhuMenu.add(getGuanyu_Item());
			bang_zhuMenu.add(getBugItem());
			bang_zhuMenu.add(getFangwen_wangzhanItem());
		}
		return bang_zhuMenu;    
   }
   
   /**
   初始化（关于）菜单项的方法
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC0322
    */
   private JMenuItem getGuanyu_Item() 
   {
		if (guanyu_Item == null) {
			guanyu_Item = new JMenuItem();
			guanyu_Item.setText("关于");
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
   初始化（联系技术支持）菜单项的方法
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC033D
    */
   public JMenuItem getBugItem() 
   {
		if (bugItem == null) {
			bugItem = new JMenuItem();
			bugItem.setText("联系技术支持");
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
   初始化（访问技术网站）菜单项的方法
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC0356
    */
   public JMenuItem getFangwen_wangzhanItem() 
   {
		if (fangwen_wangzhanItem == null) {
			fangwen_wangzhanItem = new JMenuItem();
			fangwen_wangzhanItem.setText("访问技术网站");
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
   初始化（退出系统）菜单项的方法
   @return javax.swing.JMenuItem
   @roseuid 5D0B97CC036F
    */
   public JMenuItem getExitItem() 
   {
		if (exitItem == null) {
			exitItem = new JMenuItem();
			exitItem.setText("退出系统");
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
   创建内部窗体的方法，该方法使用反射技术获取内部窗体的构造方法，从而创建内部窗体。
   @param item：激活该内部窗体的菜单项
   @param clazz：内部窗体的Class对象
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
					stateLabel.setText("没有选择窗体");
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return iFrame;    
   }
}
