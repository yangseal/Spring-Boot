package com.cnten.platform.websocket.entity;

public class ClientServiceUser {

	public static final String CLIENT_SERVICE_USER_CUSTOMER = "customer";   		//客户
	public static final String CLIENT_SERVICE_USER_CUSERVICE = "cuservice";			//客服人员
	
	private String id;

	private String name;

	private String password;
	
	private String userType;
	
	private String sendTo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		if(name == null)
			name = "游客" + (int)((Math.random()*9+1)*100000);
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
}
