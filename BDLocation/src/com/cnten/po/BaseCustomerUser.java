package com.cnten.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class BaseCustomerUser {
	@Id
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@GeneratedValue(generator = "generator")
	@Column(unique = true, nullable = false, length = 32)
	private String baseCustomerUserId;
	@Column
	private String custUserName;
	@Column
	private String custUserPost;
	@Column
	private String custUserTel;
	@Column
	private String custUserPhone;
	@Column
	private String custUserEmail;
	@Column
	private String custUserFax;
	@Column
	private String custUserDep;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;
	@Column
	private String createUser;
	@Column
	private String updateUser;
	@ManyToOne
	@JoinColumn(name="base_customer_id")
	private BaseCustomer baseCustomer; 
	@Column
	private String custUserRemark;
	@Column
	private String isDelete;
	public String getBaseCustomerUserId() {
		return baseCustomerUserId;
	}
	public void setBaseCustomerUserId(String baseCustomerUserId) {
		this.baseCustomerUserId = baseCustomerUserId;
	}
	public String getCustUserName() {
		return custUserName;
	}
	public void setCustUserName(String custUserName) {
		this.custUserName = custUserName;
	}
	public String getCustUserPost() {
		return custUserPost;
	}
	public void setCustUserPost(String custUserPost) {
		this.custUserPost = custUserPost;
	}
	public String getCustUserTel() {
		return custUserTel;
	}
	public void setCustUserTel(String custUserTel) {
		this.custUserTel = custUserTel;
	}
	public String getCustUserPhone() {
		return custUserPhone;
	}
	public void setCustUserPhone(String custUserPhone) {
		this.custUserPhone = custUserPhone;
	}
	public String getCustUserEmail() {
		return custUserEmail;
	}
	public void setCustUserEmail(String custUserEmail) {
		this.custUserEmail = custUserEmail;
	}
	public String getCustUserFax() {
		return custUserFax;
	}
	public void setCustUserFax(String custUserFax) {
		this.custUserFax = custUserFax;
	}
	public String getCustUserDep() {
		return custUserDep;
	}
	public void setCustUserDep(String custUserDep) {
		this.custUserDep = custUserDep;
	}
	public BaseCustomer getBaseCustomer() {
		return baseCustomer;
	}
	public void setBaseCustomer(BaseCustomer baseCustomer) {
		this.baseCustomer = baseCustomer;
	}
	public String getCustUserRemark() {
		return custUserRemark;
	}
	public void setCustUserRemark(String custUserRemark) {
		this.custUserRemark = custUserRemark;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	
}
