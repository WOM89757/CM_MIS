//Source file: C:\\Users\\茂\\Desktop\\课设\\管理信息系统\\MIS\\CMMIS\\src\\com\\WM\\dao\\goodsDAO.java

//Source file: C:\\Users\\茂\\Desktop\\课设\\管理信息系统\\cl\\代码\\com\\WM\\dao\\goodsDAO.java

package com.WM.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.WM.dao.Model.Item;
import com.WM.dao.Model.goodsinfo;
import com.WM.dao.Model.serviceItemsinfo;

public class goodsDAO extends DAO 
{
   
   /**
   @roseuid 5D0B97B400DB
    */
   public goodsDAO() 
   {
    
   }
   

   public static goodsinfo getgoods(Item item) 
   {
		String where =null;
		
		if (item.getName() != null)
			where = "goodsName='" + item.getName() + "'";
		if (item.getId() != null)
			where = "goodsId='" + item.getId() + "'";

		if(where!=null) {
		ResultSet rs = findForResultSet("select * from goodsinfo where "
				+ where);
		goodsinfo spInfo =null;
		try {
			if (rs.next()) {
				spInfo = new goodsinfo();
				spInfo.setGoodsId(rs.getInt("goodsId"));
				spInfo.setGoodsClassic(rs.getString("goodsClassic").trim());
				spInfo.setGoodsName(rs.getString("goodsName").trim());
				spInfo.setStock(rs.getInt("Stock"));
				spInfo.setSafeStock(rs.getInt("safeStock"));
				spInfo.setSellingprice(rs.getFloat("sellingprice"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return spInfo;
		}
		return null;    
   }
 
	public static List getgoodsinfo() {
		List list = findForList("select * from goodsinfo");
		return list;
	}
   
}
