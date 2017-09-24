package com.cnten.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class OamArea implements Serializable{

	private static final long serialVersionUID = 6915646674295780371L;
	@Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String oamAreaId;
    @Column(length = 32)
    private String parentId;
    @Column(length = 50)
    private String oamAreaName;
    @Column(length = 20)
    private String oamAreaCode;
    @Column(length = 3)
    private Integer oamOrder;
    private Double longitude;
    private Double latitude;
    private Date createDate;
    @Column(length = 1)
    private String isDelete;
    
    public OamArea() {
    }
    
    public OamArea(String oamAreaId) {
    	this.oamAreaId = oamAreaId;
    }
    
    public String getOamAreaId() {
    	return oamAreaId;
    }
    public void setOamAreaId(String oamAreaId) {
    	this.oamAreaId = oamAreaId;
    }
    public String getParentId() {
    	return parentId;
    }
    public void setParentId(String parentId) {
    	this.parentId = parentId;
    }
    /**
     * 获得地区名称
     * @return oamAreaName
     */
    public String getOamAreaName() {
    	return oamAreaName;
    }
    /**
     * 设置地区名称
     * @param oamAreaName
     */
    public void setOamAreaName(String oamAreaName) {
    	this.oamAreaName = oamAreaName;
    }
    /**
     * 设置地区排序
     * @return
     */
    public Integer getOamOrder() {
		return oamOrder;
	}

	public void setOamOrder(Integer oamOrder) {
		this.oamOrder = oamOrder;
	}

	/**
     * 获得地区编码
     * @return oamAreaCode
     */
    public String getOamAreaCode() {
    	return oamAreaCode;
    }
    /**
     * 设置地区编码
     * @param oamAreaCode
     */
    public void setOamAreaCode(String oamAreaCode) {
    	this.oamAreaCode = oamAreaCode;
    }
    /**
     * 获得经度
     * @return longitude
     */
    public Double getLongitude() {
    	return longitude;
    }
    /**
     * 设置经度
     * @param longitude
     */
    public void setLongitude(Double longitude) {
    	this.longitude = longitude;
    }
    /**
     * 获得纬度
     * @return latitude
     */
    public Double getLatitude() {
    	return latitude;
    }
    /**
     * 设置纬度
     * @param latitude
     */
    public void setLatitude(Double latitude) {
    	this.latitude = latitude;
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