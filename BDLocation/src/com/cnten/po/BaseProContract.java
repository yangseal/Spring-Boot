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
public class BaseProContract {
	@Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
	private String baseProContractId;
	@Column(length=100)
	private String proContractNo;
	@Column(length=100)
	private String proContractName;
	private Date proContractDate;
	@Column(length=100)
	private String proContractPartya;
	@Column(length=100)
	private String proContractPartyb;
	@Column(length=100)
	private String proContractAddress;
	@ManyToOne
	@JoinColumn(name="base_project_id")
	private BaseProject baseProject;
	@ManyToOne
	@JoinColumn(name="base_provider_id")
	private BaseProvider baseProvider;
	@Column(length=100)
	private String contractRemark;
	@Column(length=1)
	private String isDelete;
	@Column(length=50)
	private String proContractType;
	private Date proContractCreateDate = new Date();
	@Column(length = 32)
	private String proContractCreateUser;
	private Date proContractUpdateDate;
	@Column(length = 32)
	private String proContractUpdateUser;
	
	public String getBaseProContractId() {
		return baseProContractId;
	}
	public void setBaseProContractId(String baseProContractId) {
		this.baseProContractId = baseProContractId;
	}
	public String getProContractNo() {
		return proContractNo;
	}
	public void setProContractNo(String proContractNo) {
		this.proContractNo = proContractNo;
	}
	public String getProContractName() {
		return proContractName;
	}
	public void setProContractName(String proContractName) {
		this.proContractName = proContractName;
	}
	public Date getProContractDate() {
		return proContractDate;
	}
	public void setProContractDate(Date proContractDate) {
		this.proContractDate = proContractDate;
	}
	public String getProContractPartya() {
		return proContractPartya;
	}
	public void setProContractPartya(String proContractPartya) {
		this.proContractPartya = proContractPartya;
	}
	public String getProContractPartyb() {
		return proContractPartyb;
	}
	public void setProContractPartyb(String proContractPartyb) {
		this.proContractPartyb = proContractPartyb;
	}
	public String getProContractAddress() {
		return proContractAddress;
	}
	public void setProContractAddress(String proContractAddress) {
		this.proContractAddress = proContractAddress;
	}
	public BaseProject getBaseProject() {
		return baseProject;
	}
	public void setBaseProject(BaseProject baseProject) {
		this.baseProject = baseProject;
	}
	public BaseProvider getBaseProvider() {
		return baseProvider;
	}
	public void setBaseProvider(BaseProvider baseProvider) {
		this.baseProvider = baseProvider;
	}
	public String getContractRemark() {
		return contractRemark;
	}
	public void setContractRemark(String contractRemark) {
		this.contractRemark = contractRemark;
	}
	public String getProContractType() {
		return proContractType;
	}
	public void setProContractType(String proContractType) {
		this.proContractType = proContractType;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public Date getProContractCreateDate() {
		return proContractCreateDate;
	}
	public void setProContractCreateDate(Date proContractCreateDate) {
		this.proContractCreateDate = proContractCreateDate;
	}
	public String getProContractCreateUser() {
		return proContractCreateUser;
	}
	public void setProContractCreateUser(String proContractCreateUser) {
		this.proContractCreateUser = proContractCreateUser;
	}
	public Date getProContractUpdateDate() {
		return proContractUpdateDate;
	}
	public void setProContractUpdateDate(Date proContractUpdateDate) {
		this.proContractUpdateDate = proContractUpdateDate;
	}
	public String getProContractUpdateUser() {
		return proContractUpdateUser;
	}
	public void setProContractUpdateUser(String proContractUpdateUser) {
		this.proContractUpdateUser = proContractUpdateUser;
	}

}
