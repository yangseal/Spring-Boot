package com.cnten.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.cnten.platform.util.StringUtil;

@Entity
public class CorsBusiApprove {

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String busiApproveId;
    @Column(length = 15)
    private String busiApproveType;
    public static final String busiApproveTypeDictStatement = "material,企业资质审批;open,cors新增审批;repay,cors续费审批";
    @Column(length = 32)
    private String orderBussinkey;
    @Column(length = 45)
    private String busiSubmitUser;
    @Temporal(TemporalType.TIMESTAMP)
    private Date busiSubmitTime;
    @Column(length = 5)
    private String busiApproveRlt;
    public static final String busiApproveRltStatement = "YES,通过;NO,未通过";
    @Column(length = 500)
    private String busiApproveOpinion;
    @Column(length = 45)
    private String busiApproveUser;
    @Column(length = 12)
    private String approveState;
    public static final String approveStateDictStatement = "1,已处理;0,未处理";
    @OneToOne
    @JoinColumn(name="company_id")
    private Company company;
    @Temporal(TemporalType.TIMESTAMP)
    private Date busiApproveTime;
     
	public String getBusiApproveId() {
		return busiApproveId;
	}

	public void setBusiApproveId(String busiApproveId) {
		this.busiApproveId = busiApproveId;
	}

	/**
     * 设置所属企业
     * @param companyId
     */
	 /**
     * 获取业务类型
     * @param busiApproveType
     */
	public String getBusiApproveType() {
		return busiApproveType;
	}

	public void setBusiApproveType(String busiApproveType) {
		this.busiApproveType = busiApproveType;
	}
	
	public String getBusiApproveTypeName() {
		return StringUtil.getDictName(busiApproveType,busiApproveTypeDictStatement);
	}
	 /**
     * 业务唯一id
     * @param orderBussinkey
     */
	public String getOrderBussinkey() {
		return orderBussinkey;
	}

	public void setOrderBussinkey(String orderBussinkey) {
		this.orderBussinkey = orderBussinkey;
	}
	 /**
     * 获取提交人
     * @param busiSubmitUser
     */
	public String getBusiSubmitUser() {
		return busiSubmitUser;
	}

	public void setBusiSubmitUser(String busiSubmitUser) {
		this.busiSubmitUser = busiSubmitUser;
	}
	 /**
     * 获取提交时间
     * @param busiSubmitTime
     */
	public Date getBusiSubmitTime() {
		return busiSubmitTime;
	}

	public void setBusiSubmitTime(Date busiSubmitTime) {
		this.busiSubmitTime = busiSubmitTime;
	}
	 /**
     * 审批结果
     * @param busiApproveRlt
     */

	public String getBusiApproveRltName() {
		return StringUtil.getDictName(busiApproveRlt,busiApproveRltStatement);
	}
	
	public String getBusiApproveRlt() {
		return busiApproveRlt;
	}

	public void setBusiApproveRlt(String busiApproveRlt) {
		this.busiApproveRlt = busiApproveRlt;
	}
	 /**
     * 审批意见
     * @param busiApproveOpinion
     */
	public String getBusiApproveOpinion() {
		return busiApproveOpinion;
	}

	public void setBusiApproveOpinion(String busiApproveOpinion) {
		this.busiApproveOpinion = busiApproveOpinion;
	}
	 /**
     * 审批人
     * @param busiApproveUser
     */
	public String getBusiApproveUser() {
		return busiApproveUser;
	}

	public void setBusiApproveUser(String busiApproveUser) {
		this.busiApproveUser = busiApproveUser;
	}
	 /**
     * 审批时间
     * @param busiApproveTime
     */
	public Date getBusiApproveTime() {
		return busiApproveTime;
	}

	public void setBusiApproveTime(Date busiApproveTime) {
		this.busiApproveTime = busiApproveTime;
	}

	public String getApproveState() {
		return approveState;
	}

	public void setApproveState(String approveState) {
		this.approveState = approveState;
	}
	public String getApproveStateName() {
		return StringUtil.getDictName(approveState,approveStateDictStatement);
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
} 		