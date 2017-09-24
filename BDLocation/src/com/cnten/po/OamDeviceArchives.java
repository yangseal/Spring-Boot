package com.cnten.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class OamDeviceArchives {

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String oamDeviceArchivesId;
    @Column(length = 50)
    private String oamDeviceArchivesCode;
    @Column(length = 100)
    private String oamDeviceArchivesName;
    @Column(length = 100)
    private String bindCorsAccount;
    private Date createDate;
    @Column(length = 1)
    private String isDelete;
    
    public String getOamDeviceArchivesId() {
    	return oamDeviceArchivesId;
    }
    public void setOamDeviceArchivesId(String oamDeviceArchivesId) {
    	this.oamDeviceArchivesId = oamDeviceArchivesId;
    }
    /**
     * 获得设备档案标识号
     * @return oamDeviceArchivesCode
     */
    public String getOamDeviceArchivesCode() {
    	return oamDeviceArchivesCode;
    }
    /**
     * 设置设备档案标识号
     * @param oamDeviceArchivesCode
     */
    public void setOamDeviceArchivesCode(String oamDeviceArchivesCode) {
    	this.oamDeviceArchivesCode = oamDeviceArchivesCode;
    }
    /**
     * 获得设备档案名称
     * @return oamDeviceArchivesName
     */
    public String getOamDeviceArchivesName() {
    	return oamDeviceArchivesName;
    }
    /**
     * 设置设备档案名称
     * @param oamDeviceArchivesName
     */
    public void setOamDeviceArchivesName(String oamDeviceArchivesName) {
    	this.oamDeviceArchivesName = oamDeviceArchivesName;
    }
    /**
     * 获得绑定的基站账号
     * @return bindCorsAccount
     */
    public String getBindCorsAccount() {
    	return bindCorsAccount;
    }
    /**
     * 设置绑定的基站账号
     * @param bindCorsAccount
     */
    public void setBindCorsAccount(String bindCorsAccount) {
    	this.bindCorsAccount = bindCorsAccount;
    }
    /**
     * 获得创建日期
     * @return createDate
     */
    public Date getCreateDate() {
    	return createDate;
    }
    /**
     * 设置创建日期
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