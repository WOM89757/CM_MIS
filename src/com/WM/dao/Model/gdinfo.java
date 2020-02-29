//Source file: C:\\Users\\茂\\Desktop\\课设\\管理信息系统\\MIS\\CMMIS\\src\\com\\WM\\dao\\Model\\gdinfo.java

package com.WM.dao.Model;

import com.WM.dao.serviceItemsDAO;
import java.util.Date;

public class gdinfo 
{
	private String billId;
   public int cardId;
   public String staffId;
   public Date date;
   public float price;
   public String userName;
   public String staffName;
   
   /**
   @roseuid 5D0CA7180374
    */
   public gdinfo() 
   {
    
   }
   public void setbillId(String billid) {
	   billId=billid;
   }
   
   /**
   Access method for the cardId property.
   
   @return   the current value of the cardId property
    */
   public int getCardId() 
   {
      return cardId;
   }
   
   /**
   Sets the value of the cardId property.
   
   @param aCardId the new value of the cardId property
    */
   public void setCardId(int aCardId) 
   {
      cardId = aCardId;
   }
   
   /**
   Access method for the staffId property.
   
   @return   the current value of the staffId property
    */
   public String getStaffId() 
   {
      return staffId;
   }
   
   /**
   Sets the value of the staffId property.
   
   @param aStaffId the new value of the staffId property
    */
   public void setStaffId(String aStaffId) 
   {
      staffId = aStaffId;
   }
   
   /**
   Access method for the date property.
   
   @return   the current value of the date property
    */
   public Date getDate() 
   {
      return date;
   }
   
   /**
   Sets the value of the date property.
   
   @param aDate the new value of the date property
    */
   public void setDate(Date aDate) 
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

public String getBillId() {
	// TODO Auto-generated method stub
	return billId;
}
}
