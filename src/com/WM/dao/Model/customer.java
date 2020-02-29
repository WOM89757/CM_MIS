//Source file: C:\\Users\\茂\\Desktop\\课设\\管理信息系统\\cl\\代码\\com\\WM\\dao\\Model\\customer.java

package com.WM.dao.Model;

import java.sql.Date;

public class customer implements java.io.Serializable
{
   public int cardId;
   public String userName;
   public long phoneNumber;
   public double money;
   public int integral;
   public String password;
   
   /**
   @roseuid 5D0CA7180211
    */
   public customer() 
   {
    
   }
	public customer(int cardid) {// 最小构造函数(主键)
		this.cardId = cardid;
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
   Access method for the phoneNumber property.
   
   @return   the current value of the phoneNumber property
    */
   public long getPhoneNumber() 
   {
      return phoneNumber;    
   }
   
   /**
   Sets the value of the phoneNumber property.
   
   @param aPhoneNumber the new value of the phoneNumber property
    */
   public void setPhoneNumber(long aPhoneNumber) 
   {
      phoneNumber = aPhoneNumber;    
   }
   
   /**
   Access method for the money property.
   
   @return   the current value of the money property
    */
   public double getMoney() 
   {
      return money;    
   }
   
   /**
   Sets the value of the money property.
   
   @param aMoney the new value of the money property
    */
   public void setMoney(double aMoney) 
   {
      money = aMoney;    
   }
   
   /**
   Access method for the integral property.
   
   @return   the current value of the integral property
    */
   public int getIntegral() 
   {
      return integral;    
   }
   
   /**
   Sets the value of the integral property.
   
   @param aIntegral the new value of the integral property
    */
   public void setIntegral(int aIntegral) 
   {
      integral = aIntegral;    
   }
   
   /**
   Access method for the password property.
   
   @return   the current value of the password property
    */
   public String getPassword() 
   {
      return password;    
   }
   
   /**
   Sets the value of the password property.
   
   @param aPassword the new value of the password property
    */
   public void setPassword(String aPassword) 
   {
      password = aPassword;    
   }
}
/**






void customer.setIntegral(){
    
   }
void customer.getUsername(){
    
   }
void customer.getJoindate(){
    
   }
void customer.setmoney(){
    
   }
void customer.setUsername(){
    
   }
void customer.setjoinDate(){
    
   }
void customer.setPhonenumber(){
    
   }
void customer.getmoney(){
    
   }
void customer.getPhonenumber(){
    
   }
void customer.getpassword(){
    
   }
void customer.getCardid(){
    
   }
void customer.setpassword(){
    
   }
void customer.setCardid(){
    
   }
 
 
 
 
 
 
 */
