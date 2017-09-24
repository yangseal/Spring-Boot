package com.cnten.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.cnten.platform.util.StringUtil;

@Entity
public class CorsAccount implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String corsAccountId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="company_id")
    private Company company;
	@ManyToOne
	@JoinColumn(name="corsApplyId",nullable=true)
    private CorsApply corsApply;
    @Column(length = 20)
    private String corsAccountCode;
    @Column(length = 32)
    private String corsAccountPwd;
    @Transient
    private String corsAccountTypeName;
    @Column(length = 6)
    private String corsAccountType;
    public static final String corsAccountTypeDictStatement = "test,试用;formal,正式";
    @ManyToOne
    @JoinColumn(name="oam_area_id")
    private OamArea oamArea;
    @Column(length = 50)
    private String bdDevice;
    @Column(length = 50)
    private String bdDeviceSn;
    @Transient
    private String bdDeviceAccuracyName;
    @Column(length = 10)
    private String bdDeviceAccuracy;
    public static final String bdDeviceAccuracyDictStatement = "milevel,米级;meter,亚米级;centimeter,厘米级";
    @Temporal(TemporalType.TIMESTAMP)
    private Date effectiveDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date exprieDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date corsCreateDate;
    @Column(length = 100)
    private String remark;
    @Column(length = 1)
    private String isDelete;
    @Column(length = 3)
    private Integer corsAccountPeriod;
    @Column(length = 5)
    private String corsAccountState;
    public static final String corsAccountStateDictStatement = "normal,启用中;expired,过期;unactive,未激活;soon,即将过期";
    @Column(length = 5)
    private Integer corsAccountOrder;
    @Transient
    private String corsAccountStateName;
    @Column(length = 5)
    @Transient
    private String corsAccountStageName;
    private String corsAccountStage;
    public static final String corsAccountStageDictStatement = "UA,---;AQ,激活已申请;A,激活完成;RU,待续费;RR,续费已申请;RA,续费通过;RN,续费未通过;RD,续费完成";
    @ManyToOne
    @JoinColumn(name="company_group_id", nullable = true)
    private CorsCompanyGroup corsCompanyGroup;
    @Column
    private String corsFeature;
    @ManyToOne
    @JoinColumn(name="company_org_id")
    private CompanyOrg companyOrg;
    @Column(length = 5)
    @Transient
    private String corsAccountUseName;
    private String corsAccountUse;
    public static final String corsAccountUseDictStatement = "110,110;120,120;119,119;QJC,清洁车;ZTC,渣土车;XLJC,泄漏检测;ZNXJ,智能巡检;GCCL,工程测量";
    public CorsAccount(){}
	public CorsAccount(String corsAccountId) {
       this.corsAccountId = corsAccountId;
	}
	public String getCorsAccountId() {
    	return corsAccountId;
    }
    public void setCorsAccountId(String corsAccountId) {
    	this.corsAccountId = corsAccountId;
    }
    /**
     * 获得所属企业
     * @return company
     */
    public Company getCompany() {
    	return company;
    }
    /**
     * 设置所属企业
     * @param company
     */
    public void setCompany(Company company) {
    	this.company = company;
    }
    
    public CorsApply getCorsApply() {
		return corsApply;
	}
	public void setCorsApply(CorsApply corsApply) {
		this.corsApply = corsApply;
	}
	/**
     * 获得账号编码
     * @return corsAccountCode
     */
    public String getCorsAccountCode() {
    	return corsAccountCode;
    }
    /**
     * 设置账号编码
     * @param corsAccountCode
     */
    public void setCorsAccountCode(String corsAccountCode) {
    	this.corsAccountCode = corsAccountCode;
    }
    /**
     * 获得CORS密码
     * @return corsAccountPwd
     */
    public String getCorsAccountPwd() {
    	return corsAccountPwd;
    }
    /**
     * 设置CORS密码
     * @param corsAccountPwd
     */
    public void setCorsAccountPwd(String corsAccountPwd) {
    	this.corsAccountPwd = corsAccountPwd;
    }
    
    /**
     * 获得账号类型
     * <br/>
     * 字典语句(test,测试;formal,正式)
     * @return corsAccountType
     */
    public String getCorsAccountTypeName() {
    	return StringUtil.getDictName(corsAccountType,corsAccountTypeDictStatement);
    }
    
    /**
     * 获得账号类型
     * <br/>
     * 字典语句(test,测试;formal,正式)
     * @return corsAccountType
     */
    public String getCorsAccountType() {
    	return corsAccountType;
    }
//    /**
//     * 获得账号类型名称
//     * @return corsAccountTypeName
//     */
//    public String getCorsAccountTypeName() {
//    	return StringUtil.getDictName(corsAccountType,corsAccountTypeDictStatement);
//    }
    /**
     * 设置账号类型
     * <br/>
     * 字典语句(test,测试;formal,正式)
     * @param corsAccountType
     */
    public void setCorsAccountType(String corsAccountType) {
    	this.corsAccountType = corsAccountType;
    }
    /**
     * 获得应用区域
     * @return oamArea
     */
    public OamArea getOamArea() {
    	return oamArea;
    }
    /**
     * 设置应用区域
     * @param oamArea
     */
    public void setOamArea(OamArea oamArea) {
    	this.oamArea = oamArea;
    }
    /**
     * 获得定位设备型号
     * @return bdDevice
     */
    public String getBdDevice() {
    	return bdDevice;
    }
    /**
     * 设置定位设备型号
     * @param bdDevice
     */
    public void setBdDevice(String bdDevice) {
    	this.bdDevice = bdDevice;
    }
    /**
     * 获得定位设备SN号
     * @return bdDeviceSn
     */
    public String getBdDeviceSn() {
    	return bdDeviceSn;
    }
    /**
     * 设置定位设备SN号
     * @param bdDeviceSn
     */
    public void setBdDeviceSn(String bdDeviceSn) {
    	this.bdDeviceSn = bdDeviceSn;
    }
    /**
     * 获得定位设备入网精度
     * <br/>
     * 字典语句(meter,亚米;centimeter,厘米)
     * @return bdDeviceAccuracy
     */
    public String getBdDeviceAccuracy() {
    	return bdDeviceAccuracy;
    }
    /**
     * 获得定位设备入网精度名称
     * @return bdDeviceAccuracyName
     */
    public String getBdDeviceAccuracyName() {
    	return StringUtil.getDictName(bdDeviceAccuracy,bdDeviceAccuracyDictStatement);

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
     * 获得起始有效期
     * @return effectiveDate
     */
    public Date getEffectiveDate() {
    	return effectiveDate;
    }
    /**
     * 设置起始有效期
     * @param effectiveDate
     */
    public void setEffectiveDate(Date effectiveDate) {
    	this.effectiveDate = effectiveDate;
    }
    /**
     * 获得结束有效期
     * @return exprieDate
     */
    public Date getExprieDate() {
    	return exprieDate;
    }
    /**
     * 设置结束有效期
     * @param exprieDate
     */
    public void setExprieDate(Date exprieDate) {
    	this.exprieDate = exprieDate;
    }
    /**
     * 获得生成时间
     */
    public Date getCorsCreateDate() {
		return corsCreateDate;
	}
    /**
     * 设置生成时间
     * 
     */
	public void setCorsCreateDate(Date corsCreateDate) {
		this.corsCreateDate = corsCreateDate;
	}
    /**
     * 获得备注
     * @return remark
     */
    public String getRemark() {
    	return remark;
    }
	/**
     * 设置备注
     * @param remark
     */
    public void setRemark(String remark) {
    	this.remark = remark;
    }
    
    /**
     * 获取账号状态
     * @return
     */
    public String getCorsAccountStateName() {
    	return StringUtil.getDictName(corsAccountState, corsAccountStateDictStatement);
	}
    
    /**
     * 获取账号状态
     * @return
     */
    public String getCorsAccountState() {
		return corsAccountState;
	}
    /**
     * 设置账号状态
     * @param corsAccountState
     */
	public void setCorsAccountState(String corsAccountState) {
		this.corsAccountState = corsAccountState;
	}
	
	/**
	 * 获取账号所处操作阶段
	 * @return
	 */
	public String getCorsAccountStageName() {
		return StringUtil.getDictName(corsAccountStage, corsAccountStageDictStatement);
	}
	/**
	 * 获取账号所处操作阶段
	 * @return
	 */
	public String getCorsAccountStage() {
		return corsAccountStage;
	}
	/**
	 * 设置账号所处操作阶段
	 * @param corsAccountStage
	 */
	public void setCorsAccountStage(String corsAccountStage) {
		this.corsAccountStage = corsAccountStage;
	}
	/**
	 * 获取账号所在分组
	 * @return
	 */
	public CorsCompanyGroup getCorsCompanyGroup() {
		return corsCompanyGroup;
	}
	/**
	 * 设置账号所在分组
	 * @param corsCompanyGroup
	 */
	public void setCorsCompanyGroup(CorsCompanyGroup corsCompanyGroup) {
		this.corsCompanyGroup = corsCompanyGroup;
	}
	/**
     * 设置账号期限
     * @return
     */
    public Integer getCorsAccountPeriod() {
		return corsAccountPeriod;
	}
    /**
     * 获取账号期限
     * @param corsAccountPeriod
     */
	public void setCorsAccountPeriod(Integer corsAccountPeriod) {
		this.corsAccountPeriod = corsAccountPeriod;
	}
    
    public String getIsDelete() {
    	return isDelete;
    }
    public void setIsDelete(String isDelete) {
    	this.isDelete = isDelete;
    }
	public Integer getCorsAccountOrder() {
		return corsAccountOrder;
	}
	public void setCorsAccountOrder(Integer corsAccountOrder) {
		this.corsAccountOrder = corsAccountOrder;
	}
	public String getCorsFeature() {
		return corsFeature;
	}
	public void setCorsFeature(String corsFeature) {
		this.corsFeature = corsFeature;
	}
	public CompanyOrg getCompanyOrg() {
		return companyOrg;
	}
	public void setCompanyOrg(CompanyOrg companyOrg) {
		this.companyOrg = companyOrg;
	}
	public String getCorsAccountUseName() {
		return StringUtil.getDictName(corsAccountUse,corsAccountUseDictStatement);
	}
	public String getCorsAccountUse() {
		return corsAccountUse;
	}
	public void setCorsAccountUse(String corsAccountUse) {
		this.corsAccountUse = corsAccountUse;
	}
	
} 		