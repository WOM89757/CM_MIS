//Source file: C:\\Users\\茂\\Desktop\\课设\\管理信息系统\\MIS\\CMMIS\\src\\com\\WM\\dao\\Model\\bill_Detail.java

package com.WM.dao.Model;


public class bill_Detail 
{
	public String billId;
	public String spid;
   public String spname;
   public double dj;
   public double sl;
   public float discount;
   public double sprice;
   
   /**
   @roseuid 5D0CA71703C6
    */
   public bill_Detail() 
   {
    
   }
   
   /**
   Access method for the spid property.
   
   @return   the current value of the spid property
    */
   public String getSpid() 
   {
      return spid;
   }
   public String getBillId() 
   {
      return billId;
   }
   public void setBillId(String aBillId) 
   {
      billId = aBillId;
   }
   
   /**
   Sets the value of the spid property.
   
   @param aSpid the new value of the spid property
    */
   public void setSpid(String aSpid) 
   {
      spid = aSpid;
   }
   
   /**
   Access method for the spname property.
   
   @return   the current value of the spname property
    */
   public String getSpname() 
   {
      return spname;
   }
   
   /**
   Sets the value of the spname property.
   
   @param aSpname the new value of the spname property
    */
   public void setSpname(String aSpname) 
   {
      spname = aSpname;
   }
   
   /**
   Access method for the dj property.
   
   @return   the current value of the dj property
    */
   public double getDj() 
   {
      return dj;
   }
   
   /**
   Sets the value of the dj property.
   
   @param aDj the new value of the dj property
    */
   public void setDj(double aDj) 
   {
      dj = aDj;
   }
   
   /**
   Access method for the sl property.
   
   @return   the current value of the sl property
    */
   public double getSl() 
   {
      return sl;
   }
   
   /**
   Sets the value of the sl property.
   
   @param aSl the new value of the sl property
    */
   public void setSl(double aSl) 
   {
      sl = aSl;
   }
   
   /**
   Access method for the discount property.
   
   @return   the current value of the discount property
    */
   public float getDiscount() 
   {
      return discount;
   }
   
   /**
   Sets the value of the discount property.
   
   @param aDiscount the new value of the discount property
    */
   public void setDiscount(float aDiscount) 
   {
      discount = aDiscount;
   }
   
   /**
   Access method for the sprice property.
   
   @return   the current value of the sprice property
    */
   public double getSprice() 
   {
      return sprice;
   }
   
   /**
   Sets the value of the sprice property.
   
   @param aSprice the new value of the sprice property
    */
   public void setSprice(double aSprice) 
   {
      sprice = aSprice;
   }
}
