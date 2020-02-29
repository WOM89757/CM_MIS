//Source file: C:\\Users\\茂\\Desktop\\课设\\管理信息系统\\MIS\\CMMIS\\src\\com\\WM\\dao\\Model\\goodsinfo.java

package com.WM.dao.Model;

import com.WM.dao.goodsDAO;

public class goodsinfo 
{
   public int goodsId;
   public String goodsClassic;
   public String goodsName;
   public float sellingprice;
   public int Stock;
   public int safeStock;
   
   /**
   @roseuid 5D0CA7190061
    */
   public goodsinfo() 
   {
    
   }
   
   /**
   Access method for the goodsId property.
   
   @return   the current value of the goodsId property
    */
   public int getGoodsId() 
   {
      return goodsId;
   }
   
   /**
   Sets the value of the goodsId property.
   
   @param aGoodsId the new value of the goodsId property
    */
   public void setGoodsId(int aGoodsId) 
   {
      goodsId = aGoodsId;
   }
   
   /**
   Access method for the goodsClassic property.
   
   @return   the current value of the goodsClassic property
    */
   public String getGoodsClassic() 
   {
      return goodsClassic;
   }
   
   /**
   Sets the value of the goodsClassic property.
   
   @param aGoodsClassic the new value of the goodsClassic property
    */
   public void setGoodsClassic(String aGoodsClassic) 
   {
      goodsClassic = aGoodsClassic;
   }
   
   /**
   Access method for the goodsName property.
   
   @return   the current value of the goodsName property
    */
   public String getGoodsName() 
   {
      return goodsName;
   }
   
   /**
   Sets the value of the goodsName property.
   
   @param aGoodsName the new value of the goodsName property
    */
   public void setGoodsName(String aGoodsName) 
   {
      goodsName = aGoodsName;
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
   
   /**
   Access method for the Stock property.
   
   @return   the current value of the Stock property
    */
   public int getStock() 
   {
      return Stock;
   }
   
   /**
   Sets the value of the Stock property.
   
   @param i the new value of the Stock property
    */
   public void setStock(int i) 
   {
      Stock = i;
   }
   
   /**
   Access method for the safeStock property.
   
   @return   the current value of the safeStock property
    */
   public int getSafeStock() 
   {
      return safeStock;
   }
   
   /**
   Sets the value of the safeStock property.
   
   @param i the new value of the safeStock property
    */
   public void setSafeStock(int i) 
   {
      safeStock = i;
   }
}
