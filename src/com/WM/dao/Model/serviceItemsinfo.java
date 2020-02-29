//Source file: C:\\Users\\茂\\Desktop\\课设\\管理信息系统\\MIS\\CMMIS\\src\\com\\WM\\dao\\Model\\serviceItemsinfo.java

package com.WM.dao.Model;

import com.WM.dao.goodsDAO;

public class serviceItemsinfo 
{
   public int serviceitemId;
   public String serviceitemClassic;
   public String serviceName;
   public float sellingprice;
   public bill_Detail theBill_Detail[];
   
   /**
   @roseuid 5D0CD55B02F6
    */
   public serviceItemsinfo() 
   {
    
   }
   
   /**
   Access method for the serviceitemId property.
   
   @return   the current value of the serviceitemId property
    */
   public int getServiceitemId() 
   {
      return serviceitemId;
   }

   
   /**
   Sets the value of the serviceitemId property.
   
   @param aServiceitemId the new value of the serviceitemId property
    */
   public void setServiceitemId(int aServiceitemId) 
   {
      serviceitemId = aServiceitemId;
   }
   
   /**
   Access method for the serviceitemClassic property.
   
   @return   the current value of the serviceitemClassic property
    */
   public String getServiceitemClassic() 
   {
      return serviceitemClassic;
   }
   
   /**
   Sets the value of the serviceitemClassic property.
   
   @param aServiceitemClassic the new value of the serviceitemClassic property
    */
   public void setServiceitemClassic(String aServiceitemClassic) 
   {
      serviceitemClassic = aServiceitemClassic;
   }
   
   /**
   Access method for the serviceName property.
   
   @return   the current value of the serviceName property
    */
   public String getServiceName() 
   {
      return serviceName;
   }
   
   /**
   Sets the value of the serviceName property.
   
   @param aServiceName the new value of the serviceName property
    */
   public void setServiceName(String aServiceName) 
   {
      serviceName = aServiceName;
   }
   
   /**
   Access method for the sellingprice property.
   
   @return   the current value of the sellingprice property
    */
   public float getSellingprice() 
   {
      return sellingprice;
   }
   
   /**
   Sets the value of the sellingprice property.
   
   @param aSellingprice the new value of the sellingprice property
    */
   public void setSellingprice(float aSellingprice) 
   {
      sellingprice = aSellingprice;
   }
}
