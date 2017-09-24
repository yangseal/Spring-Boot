package com.cnten.po;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.cnten.platform.util.StringUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MeasureProject {
	@Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String measureProjectId;
    @Column(length = 20)
    private String measureProjectName;
    @Column(length = 20)
    private String measureUser;
    @Column(length = 20)
    private String collectTpl;
    @Column(length = 20)
    private String coordinate;
    private Date createDate;
    @ManyToOne
    @JoinColumn(name="company_id")
    private Company affiliationCompany;
    @JsonIgnore
    @Transient
    private String affiliationCompanyId;
    @ManyToOne
    @JoinColumn(name="company_org_id")
    private CompanyOrg companyOrg;
    @JsonIgnore
    @Transient
    private String companyOrgId;
    @ManyToOne
    @JoinColumn(name="cors_account_id")
    private CorsAccount corsAccount;
    @Transient
    private String corsAccountId;
    @Column(length = 1)
    private String isDelete;
    @JsonIgnore
    @Transient
    private Date minCreateDate;
    @JsonIgnore
    @Transient
    private Date maxCreateDate;
    @Transient
    private List<MeasurePoint> measurePointList;
    @Transient
    private String attachmentName;
    public static final String collectTplDictStatement = "point,默认点.gdd;pointOrLineOrPlane,默认点线面.gdd";
    public static final String coordinateDictStatement = "WGS84,WGS84.sys;beijing54,beijing54-144.sys";
    
    public MeasureProject() {
    }
    
    public MeasureProject(String measureProjectId) {
    	this.measureProjectId = measureProjectId;
    }
    
    public String getMeasureProjectId() {
    	return measureProjectId;
    }
    public void setMeasureProjectId(String measureProjectId) {
    	this.measureProjectId = measureProjectId;
    }
    /**
     * 获得工程名称
     * @return measureProjectName
     */
    public String getMeasureProjectName() {
    	return measureProjectName;
    }
    /**
     * 设置工程名称
     * @param measureProjectName
     */
    public void setMeasureProjectName(String measureProjectName) {
    	this.measureProjectName = measureProjectName;
    }
    /**
     * 获得作业人员
     * @return measureUser
     */
    public String getMeasureUser() {
    	return measureUser;
    }
    /**
     * 设置作业人员
     * @param measureUser
     */
    public void setMeasureUser(String measureUser) {
    	this.measureUser = measureUser;
    }
    /**
     * 获得数据采集模板
     * <br/>
     * 字典(point,默认点.gdd;pointOrLineOrPlane,默认点线面.gdd)
     * @return collectTpl
     */
    public String getCollectTpl() {
    	return collectTpl;
    }
    /**
     * 获得数据采集模板字典名
     * <br/>
     * 字典(point,默认点.gdd;pointOrLineOrPlane,默认点线面.gdd)
     * @return collectTpl
     */
    public String getCollectTplName() {
    	return StringUtil.getDictName(collectTpl,collectTplDictStatement);
    }
    /**
     * 设置数据采集模板
     * @param collectTpl
     */
    public void setCollectTpl(String collectTpl) {
    	this.collectTpl = collectTpl;
    }
    /**
     * 获得坐标系统
     * <br/>
     * 字典(WGS84,WGS84.sys;beijing54,beijing54-144.sys)
     * @return coordinate
     */
    public String getCoordinate() {
    	return coordinate;
    }
    /**
     * 获得坐标系统字典名
     * <br/>
     * 字典(WGS84,WGS84.sys;beijing54,beijing54-144.sys)
     * @return coordinate
     */
    public String getCoordinateName() {
    	return coordinate;
    }
    /**
     * 设置坐标系统
     * @param coordinate
     */
    public void setCoordinate(String coordinate) {
    	this.coordinate = coordinate;
    }
    /**
     * 获得创建时间
     * @return createDate
     */
    public Date getCreateDate() {
    	return createDate;
    }
    /**
     * 设置创建时间
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
    	this.createDate = createDate;
    }
    /**
     * 获得所属企业
     * @return affiliationCompany
     */
    public Company getAffiliationCompany() {
    	return affiliationCompany;
    }
    /**
     * 设置所属企业
     * @param affiliationCompany
     */
    public void setAffiliationCompany(Company affiliationCompany) {
    	this.affiliationCompany = affiliationCompany;
    }
    /**
     * 获得所属企业Id
     * @return affiliationCompanyId
     */
    public String getAffiliationCompanyId() {
    	return affiliationCompanyId;
    }
    /**
     * 设置所属企业Id
     * @param affiliationCompanyId
     */
    public void setCompanyId(String companyId) {
    	this.affiliationCompanyId = companyId;
    }
    /**
     * 获得所属企业Id
     * @return affiliationCompanyId
     */
    public String getCompanyId() {
    	return affiliationCompanyId;
    }
    /**
     * 设置所属企业Id
     * @param affiliationCompanyId
     */
    public void setAffiliationCompanyId(String affiliationCompanyId) {
    	this.affiliationCompanyId = affiliationCompanyId;
    }
    
    /**
     * 获取cors账号
     * @return
     */
    public CorsAccount getCorsAccount() {
		return corsAccount;
	}

    /**
     * 设置cors账号
     * @param corsAccount
     */
	public void setCorsAccount(CorsAccount corsAccount) {
		this.corsAccount = corsAccount;
	}

	/**
	 * 获取cors账号Id
	 * @return
	 */
	public String getCorsAccountId() {
		return corsAccountId;
	}

	/**
	 * 设置cors账号Id
	 * @param corsAccountId
	 */
	public void setCorsAccountId(String corsAccountId) {
		this.corsAccountId = corsAccountId;
	}

	public String getIsDelete() {
    	return isDelete;
    }
    public void setIsDelete(String isDelete) {
    	this.isDelete = isDelete;
    }

    /**
     * 获得开始时间
     * @return minCreateDate
     */
	public Date getMinCreateDate() {
		return minCreateDate;
	}

	/**
     * 设置开始时间
     * @param minCreateDate
     */
	public void setMinCreateDate(Date minCreateDate) {
		this.minCreateDate = minCreateDate;
	}

	/**
     * 获得结束时间
     * @return minCreateDate
     */
	public Date getMaxCreateDate() {
		return maxCreateDate;
	}

	/**
     * 设置结束时间
     * @param maxCreateDate
     */
	public void setMaxCreateDate(Date maxCreateDate) {
		this.maxCreateDate = maxCreateDate;
	}

	public List<MeasurePoint> getMeasurePointList() {
		return measurePointList;
	}

	public void setMeasurePointList(List<MeasurePoint> measurePointList) {
		this.measurePointList = measurePointList;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public CompanyOrg getCompanyOrg() {
		return companyOrg;
	}

	public void setCompanyOrg(CompanyOrg companyOrg) {
		this.companyOrg = companyOrg;
	}
	
	public void setCompanyOrgId(String companyOrgId) {
		this.companyOrgId = companyOrgId;
	}
	
	public String getCompanyOrgId() {
		return this.companyOrgId;
	}
} 		