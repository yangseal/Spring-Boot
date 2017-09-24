package com.cnten.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.cnten.platform.util.StringUtil;

@Entity
public class StakeoutTask {

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String stakeoutTaskId;
    @Column(length = 20)
    private String stakeoutTaskName;
    @Column(length = 20)
    private String taskType;
    @Column(length = 20)
    private String taskStatus;
    private Date createDate;
    //added by lanj 时间段查询条件
    @Transient
    private Date createDateBegin;
    @Transient
    private Date createDateEnd;
    @Transient
    private String corsAccountCode;
    
    @ManyToOne
    @JoinColumn(name="cors_account_id")
    private CorsAccount corsAccount;
    @Transient
    private String corsAccountId;
    @ManyToOne
    @JoinColumn(name="company_id")
    private Company affiliationCompany;
    @Transient
    private String affiliationCompanyId;
    @ManyToOne
    @JoinColumn(name="conversion_param_id")
    private ConversionParam conversionParam;
    @Transient
    private String conversionParamId;
    @Column(length = 1)
    private String isDelete;
    @ManyToOne
    @JoinColumn(name="company_org_id")
    private CompanyOrg companyOrg;
    
    public static final String taskTypeDictStatement = "point,点;line,线";
    public static final String taskStatusDictStatement = "newTask,新任务;issued,已下发";
    
    public StakeoutTask() {
    }
    
    public StakeoutTask(String stakeoutTaskId) {
    	this.stakeoutTaskId = stakeoutTaskId;
    }
    
    public String getStakeoutTaskId() {
    	return stakeoutTaskId;
    }
    public void setStakeoutTaskId(String stakeoutTaskId) {
    	this.stakeoutTaskId = stakeoutTaskId;
    }
    /**
     * 获得任务名称
     * @return stakeoutTaskName
     */
    public String getStakeoutTaskName() {
    	return stakeoutTaskName;
    }
    /**
     * 设置任务名称
     * @param stakeoutTaskName
     */
    public void setStakeoutTaskName(String stakeoutTaskName) {
    	this.stakeoutTaskName = stakeoutTaskName;
    }
    /**
     * 获得任务类型
     * <br/>
     * 字典(point,点;line,线)
     * @return taskType
     */
    public String getTaskType() {
    	return taskType;
    }
    /**
     * 获得任务类型字典名
     * <br/>
     * 字典(point,点;line,线)
     * @return taskTypeName
     */
    public String getTaskTypeName() {
    	return StringUtil.getDictName(taskType,taskTypeDictStatement);
    }
    /**
     * 设置任务类型
     * @param taskType
     */
    public void setTaskType(String taskType) {
    	this.taskType = taskType;
    }
    /**
     * 获得任务状态
     * <br/>
     * 字典(newTask,新任务;issued,已下发)
     * @return taskStatus
     */
    public String getTaskStatus() {
    	return taskStatus;
    }
    /**
     * 获得任务状态字典名
     * <br/>
     * 字典(newTask,新任务;issued,已下发)
     * @return taskStatusName
     */
    public String getTaskStatusName() {
    	return StringUtil.getDictName(taskStatus,taskStatusDictStatement);
    }
    /**
     * 设置任务状态
     * @param taskStatus
     */
    public void setTaskStatus(String taskStatus) {
    	this.taskStatus = taskStatus;
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
     * 获得创建时间(用于时间段查询条件)
     * @return createDateEnd
     */
    public Date getCreateDateEnd() {
    	return createDateEnd;
    }
    /**
     * 设置创建时间(用于时间段查询条件)
     * @param createDateEnd
     */
    public void setCreateDateEnd(Date createDateEnd) {
    	this.createDateEnd = createDateEnd;
    }
    /**
     * 获得创建时间(用于时间段查询条件)
     * @return createDateEnd
     */
    public Date getCreateDateBegin() {
    	return createDateBegin;
    }
    /**
     * 设置创建时间(用于时间段查询条件)
     * @param createDateEnd
     */
    public void setCreateDateBegin(Date createDateBegin) {
    	this.createDateBegin = createDateBegin;
    }

    public String getCorsAccountCode() {
		return corsAccountCode;
	}

	public void setCorsAccountCode(String corsAccountCode) {
		this.corsAccountCode = corsAccountCode;
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
    public String getCompanyId() {
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
    public String getAffiliationCompanyId() {
    	return affiliationCompanyId;
    }
    /**
     * 设置所属企业Id
     * @param affiliationCompanyId
     */
    public void setAffiliationCompanyId(String affiliationCompanyId) {
    	this.affiliationCompanyId = affiliationCompanyId;
    }
    
    public ConversionParam getConversionParam() {
		return conversionParam;
	}

	public void setConversionParam(ConversionParam converArea) {
		this.conversionParam = converArea;
	}

	public String getConversionParamId() {
		return conversionParamId;
	}

	public void setConversionParamId(String conversionParamId) {
		this.conversionParamId = conversionParamId;
	}

	public String getIsDelete() {
    	return isDelete;
    }
    public void setIsDelete(String isDelete) {
    	this.isDelete = isDelete;
    }

	public CompanyOrg getCompanyOrg() {
		return companyOrg;
	}

	public void setCompanyOrg(CompanyOrg companyOrg) {
		this.companyOrg = companyOrg;
	}
    
} 		