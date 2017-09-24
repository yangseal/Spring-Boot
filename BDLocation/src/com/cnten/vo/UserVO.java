package com.cnten.vo;

public class UserVO {
	private String userId;
	private String userCode;
	private String userName;
	private String password;
	private String companyOrgId;
	public UserVO(String userId, String userCode, String userName, String password,String companyOrgId) {
		super();
		this.userId = userId;
		this.userCode = userCode;
		this.userName = userName;
		this.password = password;
		this.companyOrgId = companyOrgId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCompanyOrgId() {
		return companyOrgId;
	}
	public void setCompanyOrgId(String companyOrgId) {
		this.companyOrgId = companyOrgId;
	}
}
