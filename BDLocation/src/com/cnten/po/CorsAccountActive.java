package com.cnten.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.cnten.platform.util.StringUtil;

@Entity
public class CorsAccountActive implements Serializable{
	private static final long serialVersionUID = -6875360236515338850L;
	
	@Id
	@GenericGenerator(name="generator", strategy="uuid.hex")
	@GeneratedValue(generator="generator")
	@Column(unique=true, nullable=false, length=32)
	private String accountActiveId;
	@OneToOne
	@JoinColumn(name="company_id")
	private Company company;
	@Column(length=5)
	private Integer accountActiveNum;
	@Transient
	private String corsAccountTypeName;
	@Column(length=15)
	private String corsAccountType;
    public static final String corsAccountTypeDictStatement = "test,试用;formal,正式";
	@Column(length=15)
	private String accountNetPrecision;
	@Column(length=15)
	private Integer accountActivePeriod;
	@Column(length=15)
	private String accountActiveType;
	@Transient
	private String accountActiveTypeName;
	private static final String accountActiveTypeDictStatement = "ACTIVE,激活申请;REPAY,续费申请";
	@Transient
	private String accountActiveStateName;
	@Column(length=15)
	private String accountActiveState;
	private static final String accountActiveStateDictStatement = "0,未完成;1,已完成";
	private Date accountActiveTime = new Date();
	@OneToMany
    @JoinColumn(name="account_active_id")
	private List<CorsActiveRel> activeRelList = new ArrayList<CorsActiveRel>();
	
	
	public String getAccountActiveId() {
		return accountActiveId;
	}
	public void setAccountActiveId(String accountActiveId) {
		this.accountActiveId = accountActiveId;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Integer getAccountActiveNum() {
		return accountActiveNum;
	}
	public void setAccountActiveNum(Integer accountActiveNum) {
		this.accountActiveNum = accountActiveNum;
	}
	public String getCorsAccountTypeName() {
		return StringUtil.getDictName(corsAccountType, corsAccountTypeDictStatement);
	}
	public String getCorsAccountType() {
		return corsAccountType;
	}
	public void setCorsAccountType(String corsAccountType) {
		this.corsAccountType = corsAccountType;
	}
	public String getAccountNetPrecision() {
		return accountNetPrecision;
	}
	public void setAccountNetPrecision(String accountNetPrecision) {
		this.accountNetPrecision = accountNetPrecision;
	}
	public Integer getAccountActivePeriod() {
		return accountActivePeriod;
	}
	public void setAccountActivePeriod(Integer accountActivePeriod) {
		this.accountActivePeriod = accountActivePeriod;
	}
	
	public String getAccountActiveTypeName() {
		return StringUtil.getDictName(accountActiveType, accountActiveTypeDictStatement);
	}
	public String getAccountActiveType() {
		return accountActiveType;
	}
	
	public void setAccountActiveType(String accountActiveType) {
		this.accountActiveType = accountActiveType;
	}
	public String getAccountActiveStateName() {
		return StringUtil.getDictName(accountActiveState, accountActiveStateDictStatement);
	}
	public String getAccountActiveState() {
		return accountActiveState;
	}
	public void setAccountActiveState(String accountActiveState) {
		this.accountActiveState = accountActiveState;
	}
	public Date getAccountActiveTime() {
		return accountActiveTime;
	}
	public void setAccountActiveTime(Date accountActiveTime) {
		this.accountActiveTime = accountActiveTime;
	}
	public List<CorsActiveRel> getActiveRelList() {
		return activeRelList;
	}
	public void setActiveRelList(List<CorsActiveRel> activeRelList) {
		this.activeRelList = activeRelList;
	}
}
