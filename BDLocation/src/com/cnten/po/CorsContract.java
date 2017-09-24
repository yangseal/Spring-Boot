package com.cnten.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class CorsContract {
	@Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
	@Column(unique = true, nullable = false, length = 32)
	private String corsContractId;         //合同id
	
	@Column(length=50)
	private String corsContractCode;        //合同编号
	
	@Column(length = 20)
	private String corsContractName;         //合同编号名称
	
	@Column(length = 20)
	private  String corsContractCusName;     //客户名称
	
	@Column(length = 20)
	private String corsContractNum;          //账号数量
	
	@Column(length = 20)
	private String corsContractMoney;        //账号金额
	
	@Column(length = 20)
	private String corsContractBill;         //发票
	
	@Column(length = 20)
	private Date corsContractDate;            //合同生效日期
	
	@Column(length = 100)
	private String corsContractComment;       //合同备注
	
	@Column(length = 1)
    private String isDelete;

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getCorsContractId() {
		return corsContractId;
	}

	public void setCorsContractId(String corsContractId) {
		this.corsContractId = corsContractId;
	}

	public String getCorsContractCode() {
		return corsContractCode;
	}

	public void setCorsContractCode(String corsContractCode) {
		this.corsContractCode = corsContractCode;
	}

	public String getCorsContractName() {
		return corsContractName;
	}

	public void setCorsContractName(String corsContractName) {
		this.corsContractName = corsContractName;
	}

	public String getCorsContractCusName() {
		return corsContractCusName;
	}

	public void setCorsContractCusName(String corsContractCusName) {
		this.corsContractCusName = corsContractCusName;
	}

	public String getCorsContractNum() {
		return corsContractNum;
	}

	public void setCorsContractNum(String corsContractNum) {
		this.corsContractNum = corsContractNum;
	}

	public String getCorsContractMoney() {
		return corsContractMoney;
	}

	public void setCorsContractMoney(String corsContractMoney) {
		this.corsContractMoney = corsContractMoney;
	}

	public String getCorsContractBill() {
		return corsContractBill;
	}

	public void setCorsContractBill(String corsContractBill) {
		this.corsContractBill = corsContractBill;
	}

	public Date getCorsContractDate() {
		return corsContractDate;
	}

	public void setCorsContractDate(Date corsContractDate) {
		this.corsContractDate = corsContractDate;
	}

	public String getCorsContractComment() {
		return corsContractComment;
	}

	public void setCorsContractComment(String corsContractComment) {
		this.corsContractComment = corsContractComment;
	}

	public  CorsContract(){}
	
	public CorsContract(String corsContractId, String corsContractCode, String corsContractName,
			String corsContractCusName, String corsContractNum, String corsContractMoney, String corsContractBill,
			Date corsContractDate, String corsContractComment, String isDelete) {
		super();
		this.corsContractId = corsContractId;
		this.corsContractCode = corsContractCode;
		this.corsContractName = corsContractName;
		this.corsContractCusName = corsContractCusName;
		this.corsContractNum = corsContractNum;
		this.corsContractMoney = corsContractMoney;
		this.corsContractBill = corsContractBill;
		this.corsContractDate = corsContractDate;
		this.corsContractComment = corsContractComment;
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "CorsContract [corsContractId=" + corsContractId + ", corsContractCode=" + corsContractCode
				+ ", corsContractName=" + corsContractName + ", corsContractCusName=" + corsContractCusName
				+ ", corsContractNum=" + corsContractNum + ", corsContractMoney=" + corsContractMoney
				+ ", corsContractBill=" + corsContractBill + ", corsContractDate=" + corsContractDate
				+ ", corsContractComment=" + corsContractComment + ", isDelete=" + isDelete + "]";
	}
}