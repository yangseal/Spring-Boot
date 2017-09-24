package com.cnten.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.cnten.platform.util.StringUtil;

@Entity
public class OamAccount {

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String oamAccountId;
    @Column(length = 100)
    private String oamAccountName;
    @Column(length = 50)
    private String pwd;
    @ManyToOne
    @JoinColumn(name="oam_customer_id")
    private OamCustomer oamCustomer;
    private Integer loginNum;
    @Column(length = 1)
    private String accountStatus;
    public static final String accountStatusDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String isDelete;
    
    public String getOamAccountId() {
    	return oamAccountId;
    }
    public void setOamAccountId(String oamAccountId) {
    	this.oamAccountId = oamAccountId;
    }
    /**
     * 获得账号名称
     * @return oamAccountName
     */
    public String getOamAccountName() {
    	return oamAccountName;
    }
    /**
     * 设置账号名称
     * @param oamAccountName
     */
    public void setOamAccountName(String oamAccountName) {
    	this.oamAccountName = oamAccountName;
    }
    /**
     * 获得账号密码
     * @return pwd
     */
    public String getPwd() {
    	return pwd;
    }
    /**
     * 设置账号密码
     * @param pwd
     */
    public void setPwd(String pwd) {
    	this.pwd = pwd;
    }
    /**
     * 获得所属客户
     * @return oamCustomer
     */
    public OamCustomer getOamCustomer() {
    	return oamCustomer;
    }
    /**
     * 设置所属客户
     * @param oamCustomer
     */
    public void setOamCustomer(OamCustomer oamCustomer) {
    	this.oamCustomer = oamCustomer;
    }
    /**
     * 获得登录次数
     * @return loginNum
     */
    public Integer getLoginNum() {
    	return loginNum;
    }
    /**
     * 设置登录次数
     * @param loginNum
     */
    public void setLoginNum(Integer loginNum) {
    	this.loginNum = loginNum;
    }
    /**
     * 获得是否在线
     * <br/>
     * 字典语句(1,是;0,否)
     * @return accountStatus
     */
    public String getAccountStatus() {
    	return accountStatus;
    }
    /**
     * 获得是否在线名称
     * @return accountStatusName
     */
    public String getAccountStatusName() {
    	return StringUtil.getDictName(accountStatus,accountStatusDictStatement);
    }
    /**
     * 设置是否在线
     * <br/>
     * 字典语句(1,是;0,否)
     * @param accountStatus
     */
    public void setAccountStatus(String accountStatus) {
    	this.accountStatus = accountStatus;
    }
    public String getIsDelete() {
    	return isDelete;
    }
    public void setIsDelete(String isDelete) {
    	this.isDelete = isDelete;
    }
    /**
     * 获取客户名称
     * @return
     */
    public String getCustomerName() {
    	return oamCustomer.getOamCustomerName();
    }
} 		