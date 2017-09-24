package com.cnten.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class BaseProviderUser {
	
	@Id
	@GenericGenerator(name = "generator",strategy = "uuid.hex")
	@GeneratedValue(generator = "generator")
	@Column(unique = true,nullable = false,length = 32)
	private String baseProviderUserId;
	@Column(length = 40)
	private String proUserName;
	@Column(length = 50)
	private String proUserDept;
	@Column(length = 40)
	private String proUserPost;
	@Column(length = 30)
	private String proUserTel;
	@Column(length = 30)
	private String proUserPhone;
	@Column(length = 50)
	private String proUserEmail;
	@Column(length = 50)
	private String proUserFax;
	@Column(length = 500)
	private String proUserRemark;
	@ManyToOne
	@JoinColumn(name = "base_provider_id")
	private BaseProvider baseProvider;
	@Column(length = 1)
	private String isDelete;
	private Date proUserCreateDate = new Date();
	@Column(length = 32)
	private String proUserCreateUser;
	private Date proUserUpdateDate;
	@Column(length = 32)
	private String proUserUpdateUser;

	public String getBaseProviderUserId() {
		return baseProviderUserId;
	}

	public void setBaseProviderUserId(String baseProviderUserId) {
		this.baseProviderUserId = baseProviderUserId;
	}

	public String getProUserName() {
		return proUserName;
	}

	public void setProUserName(String proUserName) {
		this.proUserName = proUserName;
	}

	public String getProUserDept() {
		return proUserDept;
	}

	public void setProUserDept(String proUserDept) {
		this.proUserDept = proUserDept;
	}

	public String getProUserPost() {
		return proUserPost;
	}

	public void setProUserPost(String proUserPost) {
		this.proUserPost = proUserPost;
	}

	public String getProUserTel() {
		return proUserTel;
	}

	public void setProUserTel(String proUserTel) {
		this.proUserTel = proUserTel;
	}

	public String getProUserPhone() {
		return proUserPhone;
	}

	public void setProUserPhone(String proUserPhone) {
		this.proUserPhone = proUserPhone;
	}

	public String getProUserEmail() {
		return proUserEmail;
	}

	public void setProUserEmail(String proUserEmail) {
		this.proUserEmail = proUserEmail;
	}

	public String getProUserFax() {
		return proUserFax;
	}

	public void setProUserFax(String proUserFax) {
		this.proUserFax = proUserFax;
	}

	public String getProUserRemark() {
		return proUserRemark;
	}

	public void setProUserRemark(String proUserRemark) {
		this.proUserRemark = proUserRemark;
	}

	public BaseProvider getBaseProvider() {
		return baseProvider;
	}

	public void setBaseProvider(BaseProvider baseProvider) {
		this.baseProvider = baseProvider;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public Date getProUserCreateDate() {
		return proUserCreateDate;
	}

	public void setProUserCreateDate(Date proUserCreateDate) {
		this.proUserCreateDate = proUserCreateDate;
	}

	public String getProUserCreateUser() {
		return proUserCreateUser;
	}

	public void setProUserCreateUser(String proUserCreateUser) {
		this.proUserCreateUser = proUserCreateUser;
	}

	public Date getProUserUpdateDate() {
		return proUserUpdateDate;
	}

	public void setProUserUpdateDate(Date proUserUpdateDate) {
		this.proUserUpdateDate = proUserUpdateDate;
	}

	public String getProUserUpdateUser() {
		return proUserUpdateUser;
	}

	public void setProUserUpdateUser(String proUserUpdateUser) {
		this.proUserUpdateUser = proUserUpdateUser;
	}

}
