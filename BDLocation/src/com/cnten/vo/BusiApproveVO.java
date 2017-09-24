package com.cnten.vo;

import java.util.Date;

public class BusiApproveVO {
	private String busiApproveId;
	private String orderBussinkey;
	private String companyId;
	private String companyName;
	private String contacts;
	private Integer applyCount;
	private String accountType; 
	private Integer accountUsePeriod;
	private String busiApproveType; //业务类型：申请、续费
	private String applyStatus;		//申请状态
	private String bdDeviceAccuracy;
	private String busiApproveOpinion;
	private String busiApproveRlt;	//审批结果
	private String applyComment;
	private String approveState;   //审批：已处理、未处理
	private String companyMaterialState;   //公司资料状态
	private String applyMaterialOrderType;			//续费订单类型（专用于cors资料完善，过滤数据）
	private Date finshDate = new Date();
	private Date applyDate = new Date();
	private String orderType;
	private String orderNo;
	
	public String getBusiApproveId() {
		return busiApproveId;
	}
	public void setBusiApproveId(String busiApproveId) {
		this.busiApproveId = busiApproveId;
	}
	public String getOrderBussinkey() {
		return orderBussinkey;
	}
	public void setOrderBussinkey(String orderBussinkey) {
		this.orderBussinkey = orderBussinkey;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public Integer getApplyCount() {
		return applyCount;
	}
	public void setApplyCount(Integer applyCount) {
		this.applyCount = applyCount;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Integer getAccountUsePeriod() {
		return accountUsePeriod;
	}
	public void setAccountUsePeriod(Integer accountUsePeriod) {
		this.accountUsePeriod = accountUsePeriod;
	}
	public String getBusiApproveType() {
		return busiApproveType;
	}
	public void setBusiApproveType(String busiApproveType) {
		this.busiApproveType = busiApproveType;
	}
	public String getApplyStatus() {
		return applyStatus;
	}
	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}
	public String getBdDeviceAccuracy() {
		return bdDeviceAccuracy;
	}
	public void setBdDeviceAccuracy(String bdDeviceAccuracy) {
		this.bdDeviceAccuracy = bdDeviceAccuracy;
	}
	public String getBusiApproveOpinion() {
		return busiApproveOpinion;
	}
	public void setBusiApproveOpinion(String busiApproveOpinion) {
		this.busiApproveOpinion = busiApproveOpinion;
	}
	public String getApplyComment() {
		return applyComment;
	}
	public void setApplyComment(String applyComment) {
		this.applyComment = applyComment;
	}
	public String getApproveState() {
		return approveState;
	}
	public void setApproveState(String approveState) {
		this.approveState = approveState;
	}
	public String getCompanyMaterialState() {
		return companyMaterialState;
	}
	public void setCompanyMaterialState(String companyMaterialState) {
		this.companyMaterialState = companyMaterialState;
	}
	public Date getFinshDate() {
		return finshDate;
	}
	public void setFinshDate(Date finshDate) {
		this.finshDate = finshDate;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getApplyMaterialOrderType() {
		return applyMaterialOrderType;
	}
	public void setApplyMaterialOrderType(String applyMaterialOrderType) {
		this.applyMaterialOrderType = applyMaterialOrderType;
	}
	public String getBusiApproveRlt() {
		return busiApproveRlt;
	}
	public void setBusiApproveRlt(String busiApproveRlt) {
		this.busiApproveRlt = busiApproveRlt;
	}
}
