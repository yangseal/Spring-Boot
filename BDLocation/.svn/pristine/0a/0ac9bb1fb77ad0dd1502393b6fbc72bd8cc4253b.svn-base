package com.cnten.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.cnten.platform.util.StringUtil;

@Entity
public class CorsApplyTemp {

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String corsApplyTempId;
    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    private Integer applyCount;
    @Column(length = 500)
    private String purposeDesc;
    @Column(length = 2)
    private String applyStatus;
    public static final String applyStatusDictStatement = "-1,已拒绝;0,已提交;1,业务员已确认;2,财务已确认;3,已通过";
    @Column(length = 500)
    private String applyComment;
    @Column(length = 6)
    private String applyPayment;
    public static final String applyPaymentDictStatement = "paid,已付款;unpaid,未付款";
    @Column(length = 30)
    private String contractNo;
    @Column(length = 30)
    private String invoiceNo;
    @Column(length = 30)
    private String orderNo;
    @ManyToOne
    @JoinColumn(name="financial_handler", nullable = true)
    private User financialHandler;
    @Column(length = 30)
    private String accountPrefix;
    @ManyToOne
    @JoinColumn(name="oam_area_id")
    private OamArea oamArea;
    @Transient
    private String bdDeviceAccuracyName;
    @Column(length = 10)
    private String bdDeviceAccuracy;
    public static final String bdDeviceAccuracyDictStatement = "milevel,米级;meter,亚米级;centimeter,厘米级";
    @Column(length = 30)
    private String accountType;
    public static final String accountTypeDictStatement = "test,测试;formal,正式";
    @Column(length = 100)
    private String accountCreateState;
    @Column(length = 100)
    private Integer accountUsePeriod;
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate = new Date();
    @Temporal(TemporalType.TIMESTAMP)
    private Date effectiveDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date exprieDate;
    @Transient
    private Date minApplyDate;
    @Transient
    private Date maxApplyDate;
    @Column(length = 1)
    private String isDelete;
    @Column(length = 10)
    private String applyMaterialState;
    @Transient
    @OneToMany
    @JoinColumn(name="cors_apply_id")
    private List<CorsAccount> corsList = new ArrayList<CorsAccount>();
    
    public String getCorsApplyTempId() {
		return corsApplyTempId;
	}
	public void setCorsApplyTempId(String corsApplyTempId) {
		this.corsApplyTempId = corsApplyTempId;
	}
    /**
     * 获得申请企业
     * @return company
     */
    public Company getCompany() {
    	return company;
    }
    /**
     * 设置申请企业
     * @param company
     */
    public void setCompany(Company company) {
    	this.company = company;
    }

	/**
     * 获得申请人员
     * @return user
     */
    public User getUser() {
    	return user;
    }
    /**
     * 设置申请人员
     * @param user
     */
    public void setUser(User user) {
    	this.user = user;
    }
    /**
     * 获得申请数量(默认为0)
     * @return applyCount
     */
    public Integer getApplyCount() {
    	return (applyCount == null) ? 0 : applyCount;
    }
    /**
     * 设置申请数量
     * @param applyCount
     */
    public void setApplyCount(Integer applyCount) {
    	this.applyCount = applyCount;
    }
    /**
     * 获得申请目的
     * @return purposeDesc
     */
    public String getPurposeDesc() {
    	return purposeDesc;
    }
    /**
     * 设置申请目的
     * @param purposeDesc
     */
    public void setPurposeDesc(String purposeDesc) {
    	this.purposeDesc = purposeDesc;
    }
    /**
     * 获得账号应用区域
     * @return
     */
	public OamArea getOamArea() {
		return oamArea;
	}
	/**
	 * 设置账号应用区域
	 * @param oamArea
	 */
	public void setOamArea(OamArea oamArea) {
		this.oamArea = oamArea;
	}
	/**
	 * 获得定位设备入网精度
     * <br/>
     * 字典语句(meter,亚米;centimeter,厘米)
	 * @return
	 */
	public String getBdDeviceAccuracy() {
		return bdDeviceAccuracy;
	}
	/**
     * 获得定位设备入网精度
     * @return applyStatusName
     */
    public String getBdDeviceAccuracyName() {
    	return StringUtil.getDictName(bdDeviceAccuracy, bdDeviceAccuracyDictStatement);
    }
	/**
	 * 设置定位设备入网精度
     * <br/>
     * 字典语句(meter,亚米;centimeter,厘米)
	 * @param bdDeviceAccuracy
	 */
	public void setBdDeviceAccuracy(String bdDeviceAccuracy) {
		this.bdDeviceAccuracy = bdDeviceAccuracy;
	}
	/**
	 * 获得账号类型
     * <br/>
     * 字典语句(test,测试;formal,正式)
	 * @return
	 */
	public String getAccountType() {
		return accountType;
	}
	/**
     * 获得账号类型名称
     * @return applyStatusName
     */
    public String getAccountTypeName() {
    	return StringUtil.getDictName(accountType, accountTypeDictStatement);
    }
	/**
	 * 设置账号类型
     * <br/>
     * 字典语句(test,测试;formal,正式)
	 * @param accountType
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
    /**
     * 获得审批状态
     * <br/>
     * 字典语句(-1,已拒绝;0,已提交;1,业务员已确认;2,财务已确认;3,已通过)
     * @return applyStatus
     */
    public String getApplyStatus() {
    	return applyStatus;
    }
    /**
     * 获得审批状态名称
     * @return applyStatusName
     */
    public String getApplyStatusName() {
    	return StringUtil.getDictName(applyStatus, applyStatusDictStatement);
    }
    /**
     * 设置审批状态
     * <br/>
     * 字典语句(-1,已拒绝;0,已提交;1,业务员已确认;2,财务已确认;3,已通过)
     * @param applyStatus
     */
    public void setApplyStatus(String applyStatus) {
    	this.applyStatus = applyStatus;
    }
    /**
     * 获得审批意见
     * @return applyComment
     */
    public String getApplyComment() {
    	return applyComment;
    }
    /**
     * 设置审批意见
     * @param applyComment
     */
    public void setApplyComment(String applyComment) {
    	this.applyComment = applyComment;
    }
    /**
     * 获得付款状态
     * <br/>
     * 字典语句(paid,已付款;unpaid,未付款)
     * @return
     */
    public String getApplyPayment() {
		return applyPayment;
	}
    /**
     * 获得付款状态名称
     * @return applyPayment
     */
    public String getApplyPaymentName() {
    	return StringUtil.getDictName(applyPayment, applyPaymentDictStatement);
    }
    /**
     * 设置付款状态
     * <br/>
     * 字典语句(paid,已付款;unpaid,未付款)
     * @param applyPayment
     */
	public void setApplyPayment(String applyPayment) {
		this.applyPayment = applyPayment;
	}
	/**
	 * 获取销售合同编号
	 * @return
	 */
	public String getContractNo() {
		return contractNo;
	}
	/**
	 * 设置销售合同编号
	 * @param salesContract
	 */
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	/**
	 * 获得发票编号
	 * @return
	 */
	public String getInvoiceNo() {
		return invoiceNo;
	}
	/**
	 * 设置发票编号
	 * @param invoiceNo
	 */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	/**
	 * 获得订单编号
	 * @return
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * 设置订单编号
	 * @param orderNo
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获得财务经办人
	 * @return
	 */
	public User getFinancialHandler() {
		return financialHandler;
	}
	/**
	 * 设置财务经办人
	 * @param handler
	 */
	public void setFinancialHandler(User handler) {
		this.financialHandler = handler;
	}
	/**
	 * 获取账号前缀(默认为空字符串)
	 * @return
	 */
	public String getAccountPrefix() {
		return (accountPrefix == null) ? "" : accountPrefix;
	}
	/**
	 * 设置账号前缀
	 * @param prefix
	 */
	public void setAccountPrefix(String prefix) {
		this.accountPrefix = prefix;
	}
	/**
     * 获得申请日期
     * @return applyDate
     */
    public Date getApplyDate() {
    	return applyDate;
    }
    /**
     * 设置申请日期
     * @param applyDate
     */
    public void setApplyDate(Date applyDate) {
    	this.applyDate = applyDate;
    }
    /**
     * 获得起效日期
     * @return
     */
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	/**
	 * 设置起效日期
	 * @param effectiveDate
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	/**
	 * 获得失效日期
	 * @return
	 */
	public Date getExprieDate() {
		return exprieDate;
	}
	/**
	 * 设置失效日期
	 * @param exprieDate
	 */
	public void setExprieDate(Date exprieDate) {
		this.exprieDate = exprieDate;
	}
	public Date getMinApplyDate() {
		return minApplyDate;
	}
	public void setMinApplyDate(Date minApplyDate) {
		this.minApplyDate = minApplyDate;
	}
	public Date getMaxApplyDate() {
		return maxApplyDate;
	}
	public void setMaxApplyDate(Date maxApplyDate) {
		this.maxApplyDate = maxApplyDate;
	}
    public String getIsDelete() {
    	return isDelete;
    }
    public void setIsDelete(String isDelete) {
    	this.isDelete = isDelete;
    }
	public String getApplyMaterialState() {
		return applyMaterialState;
	}
	public void setApplyMaterialState(String applyMaterialState) {
		this.applyMaterialState = applyMaterialState;
	}
	public String getAccountCreateState() {
		return accountCreateState;
	}
	public void setAccountCreateState(String accountCreateState) {
		this.accountCreateState = accountCreateState;
	}
	public Integer getAccountUsePeriod() {
		return accountUsePeriod;
	}
	public void setAccountUsePeriod(int accountUsePeriod) {
		this.accountUsePeriod = accountUsePeriod;
	}
    
} 		