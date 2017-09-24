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

import org.hibernate.annotations.GenericGenerator;

import com.cnten.platform.util.StringUtil;

@Entity
public class Feedback {

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String feedbackId;
    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @Column(length = 20)
    private String type;
    public static final String typeDictStatement = "forStation,CORS基站问题;forDevice,北斗设备问题;forAccount,CORS账户问题;forCustom,其他反馈";
    @Column(length = 20)
    private String feedbackStatus;
    public static final String feedbackStatusDictStatement = "untreated,未解决;treated,已解决";
    @Column(length = 1000)
    private String information;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(length = 1)
    private String isDelete;
    
    public String getFeedbackId() {
    	return feedbackId;
    }
    public void setFeedbackId(String feedbackId) {
    	this.feedbackId = feedbackId;
    }
    /**
     * 获得反馈企业
     * @return company
     */
    public Company getCompany() {
    	return company;
    }
    /**
     * 设置反馈企业
     * @param company
     */
    public void setCompany(Company company) {
    	this.company = company;
    }
    /**
     * 获得反馈人员
     * @return user
     */
    public User getUser() {
    	return user;
    }
    /**
     * 设置反馈人员
     * @param user
     */
    public void setUser(User user) {
    	this.user = user;
    }
    /**
     * 获得信息分类
     * <br/>
     * 字典语句(forStation,CORS基站问题;forDevice,北斗设备问题;forAccount,CORS账户问题;forCustom,其他反馈)
     * @return type
     */
    public String getType() {
    	return type;
    }
    /**
     * 获得信息分类名称
     * @return typeName
     */
    public String getTypeName() {
    	return StringUtil.getDictName(type,typeDictStatement);
    }
    /**
     * 设置信息分类
     * <br/>
     * 字典语句(forStation,CORS基站问题;forDevice,北斗设备问题;forAccount,CORS账户问题;forCustom,其他反馈)
     * @param type
     */
    public void setType(String type) {
    	this.type = type;
    }
    /**
     * 获得处理状态
     * <br/>
     * 字典语句(untreated,未解决;treated,已解决)
     * @return feedbackStatus
     */
    public String getFeedbackStatus() {
    	return feedbackStatus;
    }
    /**
     * 获得处理状态名称
     * @return feedbackStatusName
     */
    public String getFeedbackStatusName() {
    	return StringUtil.getDictName(feedbackStatus,feedbackStatusDictStatement);
    }
    /**
     * 设置处理状态
     * <br/>
     * 字典语句(untreated,未解决;treated,已解决)
     * @param feedbackStatus
     */
    public void setFeedbackStatus(String feedbackStatus) {
    	this.feedbackStatus = feedbackStatus;
    }
    /**
     * 获得反馈信息
     * @return information
     */
    public String getInformation() {
    	return information;
    }
    /**
     * 设置反馈信息
     * @param information
     */
    public void setInformation(String information) {
    	this.information = information;
    }
    /**
     * 获得反馈日期
     * @return createDate
     */
    public Date getCreateDate() {
    	return createDate;
    }
    /**
     * 设置反馈日期
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
    	this.createDate = createDate;
    }
    public String getIsDelete() {
    	return isDelete;
    }
    public void setIsDelete(String isDelete) {
    	this.isDelete = isDelete;
    }
} 		