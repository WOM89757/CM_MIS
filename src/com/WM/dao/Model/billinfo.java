//Source file: C:\\Users\\茂\\Desktop\\课设\\管理信息系统\\MIS\\CMMIS\\src\\com\\WM\\dao\\Model\\billinfo.java

package com.WM.dao.Model;

import java.util.HashSet;
import java.util.Set;





public class billinfo 
{
   public String billId;
   public String date;
   public float price;
   public String userName;
   public String staffName;
   private Set billDetails = new HashSet (0);
   
   
   /**
   @roseuid 5D0CA71800FF
    */
   public billinfo() 
   {
    
   }
   public billinfo(String billid, float je, String khname, String xsdate) 
   {// 完整构造函数
		this.billId = billid;

		this.price = je;

		this.userName = khname;
		this.date = xsdate;


		this.billDetails = billDetails;    
   }
   public Set getbillDetails() 
   {
		return this.billDetails;    
   }
   public void setbillDetails(Set billDetails) 
   {
		this.billDetails = billDetails;    
   }
   /**
   Access method for the billId property.
   
   @return   the current value of the billId property
    */
   public String getBillId() 
   {
      return billId;
   }
   
   /**
   Sets the value of the billId property.
   
   @param aBillId the new value of the billId property
    */
   public void setBillId(String aBillId) 
   {
      billId = aBillId;
   }
   
   /**
   Access method for the date property.
   
   @return   the current value of the date property
    */
   public String getDate() 
   {
      return date;
   }
   
   /**
   Sets the value of the date property.
   
   @param aDate the new value of the date property
    */
   public void setDate(String aDate) 
   {
      date = aDate;
   }
   
   /**
   Access method for the price property.
   
   @return   the current value of the price property
    */
   public float getPrice() 
   {
      return price;
   }
   
   /**
   Sets the value of the price property.
   
   @param aPrice the new value of the price property
    */
   public void setPrice(float aPrice) 
   {
      price = aPrice;
   }
   
   /**
   Access method for the userName property.
   
   @return   the current value of the userName property
    */
   public String getUserName() 
   {
      return userName;
   }
   
   /**
   Sets the value of the userName property.
   
   @param aUserName the new value of the userName property
    */
   public void setUserName(String aUserName) 
   {
      userName = aUserName;
   }
   
   /**
   Access method for the staffName property.
   
   @return   the current value of the staffName property
    */
   public String getStaffName() 
   {
      return staffName;
   }
   
   /**
   Sets the value of the staffName property.
   
   @param aStaffName the new value of the staffName property
    */
   public void setStaffName(String aStaffName) 
   {
      staffName = aStaffName;
   }


}
