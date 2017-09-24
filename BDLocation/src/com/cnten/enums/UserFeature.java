package com.cnten.enums;

public enum UserFeature {
	Cnten_User("1","讯腾人员"),						//讯腾内部添加
	Company_Register("2","注册 用户"),				//集团公司注册
	Company_Dispach_Admin("3","分公司管理员");		//有集团公司新建的
	 // 成员变量  
   private String value;  
   private String Name; 
	 // 构造方法  
   private UserFeature(String value, String Name){
       this.value = value;   
       this.Name = Name;   
   }
	public String getValue() {
		return value;
	}
	public String getName() {
		return Name;
	} 
   
}
