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
public class BaseCustomerContract {
	@Id
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@GeneratedValue(generator = "generator")
	@Column(unique = true, nullable = false, length = 32)
	private String baseCustomerContractId;
	@Column(length = 11)
	private String custContractNo;
	@Column
	private String custContractName;
	private Date custContractDate;
	@Column
	private String custContractPartya;
	@Column
	private String custContractPartyb;
	@Column
	private String custContractAddress;
	@Column
	private String custContractRemark;
	@Column
	private String isDelete;
	@Column
	private String custContractType;
	@Column(length=32)
	private String baseProjectId;
	@Column(length = 255)
	private String createUser;
	
	@Column(length = 255)
	private String updateUser;
	
	private Date createTime = new Date();
	private Date updateTime ;
	@ManyToOne
	@JoinColumn(name="base_customer_id")
	private BaseCustomer baseCustomer;
	
	public String getBaseCustomerContractId() {
		return baseCustomerContractId;
	}
	public void setBaseCustomerContractId(String baseCustomerContractId) {
		this.baseCustomerContractId = baseCustomerContractId;
	}
	public String getCustContractNo() {
		return custContractNo;
	}
	public void setCustContractNo(String custContractNo) {
		this.custContractNo = custContractNo;
	}
	public String getCustContractName() {
		return custContractName;
	}
	public void setCustContractName(String custContractName) {
		this.custContractName = custContractName;
	}
	public Date getCustContractDate() {
		return custContractDate;
	}
	public void setCustContractDate(Date custContractDate) {
		this.custContractDate = custContractDate;
	}
	public String getCustContractPartya() {
		return custContractPartya;
	}
	public void setCustContractPartya(String custContractPartya) {
		this.custContractPartya = custContractPartya;
	}
	public String getCustContractPartyb() {
		return custContractPartyb;
	}
	public void setCustContractPartyb(String custContractPartyb) {
		this.custContractPartyb = custContractPartyb;
	}
	public String getCustContractAddress() {
		return custContractAddress;
	}
	public void setCustContractAddress(String custContractAddress) {
		this.custContractAddress = custContractAddress;
	}
	public String getCustContractRemark() {
		return custContractRemark;
	}
	public void setCustContractRemark(String custContractRemark) {
		this.custContractRemark = custContractRemark;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public String getCustContractType() {
		return custContractType;
	}
	public void setCustContractType(String custContractType) {
		this.custContractType = custContractType;
	}
	public String getBaseProjectId() {
		return baseProjectId;
	}
	public void setBaseProjectId(String baseProjectId) {
		this.baseProjectId = baseProjectId;
	}
	public BaseCustomer getBaseCustomer() {
		return baseCustomer;
	}
	public void setBaseCustomer(BaseCustomer baseCustomer) {
		this.baseCustomer = baseCustomer;
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
	
}
