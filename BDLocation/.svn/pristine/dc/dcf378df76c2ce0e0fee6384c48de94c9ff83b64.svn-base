package com.cnten.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class BaseProject {
	@Id
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@GeneratedValue(generator = "generator")
	@Column(unique = true, nullable = false, length = 32)
	private String baseProjectId;
	@Column(length = 30)
	private String projectNo;
	@Column(length = 100)
	private String projectName;
	@Column(length = 30)
	private Integer planNumber;
	@Column(length = 30)
	private Integer completeNumber;
	private Date startDate;
	private Date endDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;
	@Column
	private String createUser;
	@Column
	private String updateUser;
	@OneToOne
	@JoinColumn(name="base_customer_contract_id")
	private BaseCustomerContract baseCustomerContract;
	@ManyToOne
	@JoinColumn(name="base_customer_id")
	private BaseCustomer baseCustomer;
	@Column(length = 500)
	private String projectRemark;
	@Column
	private String isDelete;
	public String getBaseProjectId() {
		return baseProjectId;
	}

	public void setBaseProjectId(String baseProjectId) {
		this.baseProjectId = baseProjectId;
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getPlanNumber() {
		return planNumber;
	}

	public void setPlanNumber(Integer planNumber) {
		this.planNumber = planNumber;
	}

	public Integer getCompleteNumber() {
		return completeNumber;
	}

	public void setCompleteNumber(Integer completeNumber) {
		this.completeNumber = completeNumber;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public BaseCustomerContract getBaseCustomerContract() {
		return baseCustomerContract;
	}

	public void setBaseCustomerContract(
			BaseCustomerContract baseCustomerContract) {
		this.baseCustomerContract = baseCustomerContract;
	}

	public String getProjectRemark() {
		return projectRemark;
	}

	public void setProjectRemark(String projectRemark) {
		this.projectRemark = projectRemark;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public BaseCustomer getBaseCustomer() {
		return baseCustomer;
	}

	public void setBaseCustomer(BaseCustomer baseCustomer) {
		this.baseCustomer = baseCustomer;
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
