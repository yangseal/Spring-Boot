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
import javax.persistence.Transient;

import com.cnten.platform.util.StringUtil;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class CorsApplyMaterial {

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String applyMaterialId;
    @Column(length = 120)
    private String applyContractNo;
    @Column(length = 120)
    private String applyInvoiceNo;
    @Column(length = 5)
    private String isIntoAccount;
    @Column(length = 1200)
    private String applyMaterialRemark;
    @Column(length = 225)
    private String materialAttachment;
    @Column(length = 32)
    private String orderBussinkey;
    @Transient
    private String busiApproveType;
    
	public String getApplyMaterialId() {
		return applyMaterialId;
	}
	public void setApplyMaterialId(String applyMaterialId) {
		this.applyMaterialId = applyMaterialId;
	}
	public String getApplyContractNo() {
		return applyContractNo;
	}
	public void setApplyContractNo(String applyContractNo) {
		this.applyContractNo = applyContractNo;
	}
	public String getApplyInvoiceNo() {
		return applyInvoiceNo;
	}
	public void setApplyInvoiceNo(String applyInvoiceNo) {
		this.applyInvoiceNo = applyInvoiceNo;
	}
	public String getIsIntoAccount() {
		return isIntoAccount;
	}
	public void setIsIntoAccount(String isIntoAccount) {
		this.isIntoAccount = isIntoAccount;
	}
	public String getApplyMaterialRemark() {
		return applyMaterialRemark;
	}
	public void setApplyMaterialRemark(String applyMaterialRemark) {
		this.applyMaterialRemark = applyMaterialRemark;
	}
	public String getMaterialAttachment() {
		return materialAttachment;
	}
	public void setMaterialAttachment(String materialAttachment) {
		this.materialAttachment = materialAttachment;
	}
	public String getOrderBussinkey() {
		return orderBussinkey;
	}
	public void setOrderBussinkey(String orderBussinkey) {
		this.orderBussinkey = orderBussinkey;
	}
	public String getBusiApproveType() {
		return busiApproveType;
	}
	public void setBusiApproveType(String busiApproveType) {
		this.busiApproveType = busiApproveType;
	}
} 		