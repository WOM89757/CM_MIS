//Source file: C:\\Users\\茂\\Desktop\\课设\\管理信息系统\\MIS\\CMMIS\\src\\com\\WM\\dao\\billDAO.java

//Source file: C:\\Users\\茂\\Desktop\\课设\\管理信息系统\\cl\\代码\\com\\WM\\dao\\billDAO.java

package com.WM.dao;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

import com.WM.dao.Model.Item;
import com.WM.dao.Model.bill_Detail;
import com.WM.dao.Model.billinfo;
import com.WM.dao.Model.goodsinfo;

public class billDAO extends DAO 
{
   
   /**
   @roseuid 5D0B97B20182
    */
   public billDAO() 
   {
    
   }

   public static boolean insertSellInfo(billinfo sellMain) 
   {
		try {
			boolean autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			// 添加销售主表记录
			insert("insert into billinfo values('" + sellMain.getBillId()
					+ "','" + sellMain.getDate()
					+ "','" + sellMain.getPrice()
					+ "','" +sellMain.getUserName()+ "','admin');");
			Set<bill_Detail> rkDetails = sellMain.getbillDetails();
			for (Iterator<bill_Detail> iter = rkDetails.iterator(); iter
					.hasNext();) {
				bill_Detail details = iter.next();
				// 添加销售详细表记录
				insert("insert into bill_Detail values('"
						+ sellMain.getBillId() + "','" + details.getSpid()
						+ "','"+details.getSpname()+"'," + details.getDj() + "," + details.getSl()+","+details.getDiscount()+","+details.getSprice() +");");
			
				// 修改库存表记录
				Item item = new Item();
				item.setId(details.getSpid());
				goodsinfo spInfo = goodsDAO.getgoods(item);
				if(spInfo!=null) {
					
					if (String.valueOf(spInfo.getGoodsId()) != null ) {
						
						
							int sl = (int) (spInfo.getStock()- details.getSl());
							//System.out.println(sl);
							update("update goodsinfo set Stock=" + sl + " where goodsId='"
									+ spInfo.getGoodsId() + "';");
						
					}
				}
			}
			conn.commit();
			conn.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		return true;    
   }
   public static boolean DeletegdInfo(billinfo sellMain) 
   {
		try {
			boolean autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			// 添加销售主表记录
			insert("insert into billinfo values('" + sellMain.getBillId()
					+ "','" + sellMain.getDate()
					+ "','" + sellMain.getPrice()
					+ "','" +sellMain.getUserName()+ "','admin');");
			Set<bill_Detail> rkDetails = sellMain.getbillDetails();
			for (Iterator<bill_Detail> iter = rkDetails.iterator(); iter
					.hasNext();) {
				bill_Detail details = iter.next();
				// 添加销售详细表记录
				insert("insert into bill_Detail values('"
						+ sellMain.getBillId() + "','" + details.getSpid()
						+ "','"+details.getSpname()+"'," + details.getDj() + "," + details.getSl()+","+details.getDiscount()+","+details.getSprice() +");");
			
				// 修改库存表记录
				Item item = new Item();
				item.setId(details.getSpid());
				goodsinfo spInfo = goodsDAO.getgoods(item);
				if(spInfo!=null) {
					
					if (String.valueOf(spInfo.getGoodsId()) != null ) {
						
						
							int sl = (int) (spInfo.getStock()- details.getSl());
							//System.out.println(sl);
							update("update goodsinfo set Stock=" + sl + " where goodsId='"
									+ spInfo.getGoodsId() + "';");
						
					}
				}
			}
			conn.commit();
			conn.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		return true;    
   }
    
  
}
