//Source file: C:\\Users\\茂\\Desktop\\课设\\管理信息系统\\MIS\\CMMIS\\src\\com\\WM\\dao\\Model\\Item.java

package com.WM.dao.Model;


public class Item 
{
   
   /**
   数据表公共类
    */
   private String id;
   
   /**
   编号属性
    */
   private String name;
   
   /**
   @param id
   @param name
   @roseuid 5D0B97B60241
    */
   public Item(String id, String name) 
   {// 完整构造函数
		this.id = id;
		this.name = name;    
   }
   
   /**
   名称信息
   @roseuid 5D0B97B60239
    */
   public Item() 
   {// 缺省构造函数    
   }
   
   /**
   Access method for the id property.
   
   @return   the current value of the id property
    */
   public String getId() 
   {
		return id;    
   }
   
   /**
   Sets the value of the id property.
   
   @param aId the new value of the id property
    */
   public void setId(String aId) 
   {
		this.id = aId;    
   }
   
   /**
   Access method for the name property.
   
   @return   the current value of the name property
    */
   public String getName() 
   {
		return name;    
   }
   
   /**
   Sets the value of the name property.
   
   @param aName the new value of the name property
    */
   public void setName(String aName) 
   {
		this.name = aName;    
   }
   
   /**
   重写toString()方法，只输出名称信息
   @return java.lang.String
   @roseuid 5D0B97B6029B
    */
   public String toString() 
   {
		return getName();    
   }
}
