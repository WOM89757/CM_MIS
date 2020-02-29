//Source file: C:\\Users\\茂\\Desktop\\课设\\管理信息系统\\MIS\\CMMIS\\src\\com\\WM\\dao\\serviceItemsDAO.java

//Source file: C:\\Users\\茂\\Desktop\\课设\\管理信息系统\\cl\\代码\\com\\WM\\dao\\serviceItemsDAO.java

package com.WM.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.WM.dao.Model.Item;
import com.WM.dao.Model.goodsinfo;
import com.WM.dao.Model.serviceItemsinfo;


public class serviceItemsDAO extends DAO 
{
   
   /**
   @roseuid 5D0B97B40165
    */
   public serviceItemsDAO() 
   {
    
   }

   public static serviceItemsinfo getserviceItems(Item item) 
   {
		String where =null;
		
		if (item.getName() != null)
			where = "serviceName='" + item.getName() + "'";
		if (item.getId() != null)
			where = "serviceitemId='" + item.getId() + "'";

		if(where!=null) {
		ResultSet rs = findForResultSet("select * from serviceItemsinfo where "
				+ where);
		serviceItemsinfo spInfo=null ;
		try {
			if (rs.next()) {
				spInfo = new serviceItemsinfo();
				spInfo.setServiceitemId(rs.getInt("serviceitemId"));
				spInfo.setServiceitemClassic(rs.getString("serviceitemClassic").trim());
				spInfo.setServiceName(rs.getString("serviceName").trim());
				spInfo.setSellingprice(rs.getFloat("sellingprice"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return spInfo;
		}
		return null;    
   }
   
}
