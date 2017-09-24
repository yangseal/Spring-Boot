package com.cnten.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.cnten.platform.util.StringUtil;

@Entity
public class CorsAccountRepay {
	@Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
	private	String accountRepayId;
	@Column(length = 4)
	private Integer accountRepayNum;
	@OneToOne
	@JoinColumn(name="company_id")
	private Company company;
	@Column(length = 4)
	private Integer accountRepayPeriod;
	@Column(length = 10)
	private String accountRepayState;
	@Transient
	private String accountRepayStateName;
	public static final String accountRepayStateDict = "4,已提交;5,已完成;6,已取消;7,未提交";
	@Column(length = 10)
	private String repayActiveState;
	@Transient
	private String repayActiveStateName;
	public static final String repayActiveStateDict = "0,未处理;1,已处理";
	@Column(length = 255)
	private String accountRepayType;
	@Column(length = 10)
	private String accountAccuracy;
	@Column(length = 255)
	private String opinion;
	@Column(length = 10)
	private String applyMaterialState;
	@Transient
	private String applyMaterialStateName;
	public static final String applyMaterialStateDict = "WWS,未完善;YWS,已完善";
	@Column(length = 25)
	private String orderNo;
	@Column(length = 30)
	private String orderType;
	@Transient
	private String orderTypeName;
	public static final String corsOrderDictType = "torder,试用订单;forder,购买订单;rorder,续费订单";
	private Date repayFinshDate;
	private Date accountRepayTime = new Date();
	@OneToMany(mappedBy="corsAccountRepay")
	private List<CorsRepayRel> corsRepayList = new ArrayList<CorsRepayRel>();
	
	public String getAccountRepayId() {
		return accountRepayId;
	}
	public void setAccountRepayId(String accountRepayId) {
		this.accountRepayId = accountRepayId;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Integer getAccountRepayNum() {
		return accountRepayNum;
	}
	public void setAccountRepayNum(Integer accountRepayNum) {
		this.accountRepayNum = accountRepayNum;
	}
	public Integer getAccountRepayPeriod() {
		return accountRepayPeriod;
	}
	public void setAccountRepayPeriod(Integer accountRepayPeriod) {
		this.accountRepayPeriod = accountRepayPeriod;
	}
	public String getAccountRepayState() {
		return accountRepayState;
	}
	public void setAccountRepayState(String accountRepayState) {
		this.accountRepayState = accountRepayState;
	}
	public String getAccountRepayStateName() {
		return StringUtil.getDictName(accountRepayState, accountRepayStateDict);
	}
	public String getAccountRepayType() {
		return accountRepayType;
	}
	public void setAccountRepayType(String accountRepayType) {
		this.accountRepayType = accountRepayType;
	}
	public Date getAccountRepayTime() {
		return accountRepayTime;
	}
	public void setAccountRepayTime(Date accountRepayTime) {
		this.accountRepayTime = accountRepayTime;
	}
	public String getAccountAccuracy() {
		return accountAccuracy;
	}
	public void setAccountAccuracy(String accountAccuracy) {
		this.accountAccuracy = accountAccuracy;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	public String getApplyMaterialState() {
		return applyMaterialState;
	}
	public void setApplyMaterialState(String applyMaterialState) {
		this.applyMaterialState = applyMaterialState;
	}
	public String getApplyMaterialStateName() {
		return StringUtil.getDictName(applyMaterialState, applyMaterialStateDict);
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getOrderTypeName() {
		return StringUtil.getDictName(orderType, corsOrderDictType);
	}
	public String getRepayActiveState() {
		return repayActiveState;
	}
	public void setRepayActiveState(String repayActiveState) {
		this.repayActiveState = repayActiveState;
	}
	public String getRepayActiveStateName() {
		return StringUtil.getDictName(repayActiveState, repayActiveStateDict);
	}
	public Date getRepayFinshDate() {
		return repayFinshDate;
	}
	public void setRepayFinshDate(Date repayFinshDate) {
		this.repayFinshDate = repayFinshDate;
	}
	public List<CorsRepayRel> getCorsRepayList() {
		return corsRepayList;
	}
	public void setCorsRepayList(List<CorsRepayRel> corsRepayList) {
		this.corsRepayList = corsRepayList;
	}
}
