//Source file: C:\\Users\\ï\\Desktop\\����\\������Ϣϵͳ\\MIS\\CMMIS\\src\\com\\WM\\dao\\Model\\Item.java

package com.WM.dao.Model;


public class Item 
{
   
   /**
   ���ݱ�����
    */
   private String id;
   
   /**
   �������
    */
   private String name;
   
   /**
   @param id
   @param name
   @roseuid 5D0B97B60241
    */
   public Item(String id, String name) 
   {// �������캯��
		this.id = id;
		this.name = name;    
   }
   
   /**
   ������Ϣ
   @roseuid 5D0B97B60239
    */
   public Item() 
   {// ȱʡ���캯��    
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
   ��дtoString()������ֻ���������Ϣ
   @return java.lang.String
   @roseuid 5D0B97B6029B
    */
   public String toString() 
   {
		return getName();    
   }
}
