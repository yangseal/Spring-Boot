package com.cnten.platform.dao;

public abstract class CustomerContextHolder {

	public final static String DATA_SOURCE_ORACLE = "oracleDataSource";
    public final static String DATA_SOURCE_MYSQL = "mySqlDataSource";
    
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();  
    
    public static void setCustomerType(String customerType) {  
        contextHolder.set(customerType);  
    }  
      
    public static String getCustomerType() {  
        return contextHolder.get();  
    }  
      
    public static void clearCustomerType() {  
        contextHolder.remove();  
    }  
}
