package com.cnten.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ConversionProjection {

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String conversionProjectionId;
    @Column(length = 100)
    private String conversionProjectionName;
    @Column(length = 100)
    private String conversionProjectionCode;
    private Integer projectType;
    private Integer meridian;
    private Double k;
    private Double x;
    private Double y;
    private Double standerdLat;
    private Double h;
    private Double averageLat;
    @Column(length = 1)
    private String isDelete;
    
    public ConversionProjection() {
    }
    
    public ConversionProjection(String conversionProjectionId) {
    	this.conversionProjectionId = conversionProjectionId;
    }
    
    public String getConversionProjectionId() {
    	return conversionProjectionId;
    }
    public void setConversionProjectionId(String conversionProjectionId) {
    	this.conversionProjectionId = conversionProjectionId;
    }
    /**
     * 获得转换投影名称
     * @return conversionProjectionName
     */
    public String getConversionProjectionName() {
    	return conversionProjectionName;
    }
    /**
     * 设置转换投影名称
     * @param conversionProjectionName
     */
    public void setConversionProjectionName(String conversionProjectionName) {
    	this.conversionProjectionName = conversionProjectionName;
    }
    /**
     * 获得转换投影编码
     * @return conversionProjectionCode
     */
    public String getConversionProjectionCode() {
    	return conversionProjectionCode;
    }
    /**
     * 设置转换投影编码
     * @param conversionProjectionCode
     */
    public void setConversionProjectionCode(String conversionProjectionCode) {
    	this.conversionProjectionCode = conversionProjectionCode;
    }
    /**
     * 获得投影类型
     * @return projectType
     */
    public Integer getProjectType() {
    	return projectType;
    }
    /**
     * 设置投影类型
     * @param projectType
     */
    public void setProjectType(Integer projectType) {
    	this.projectType = projectType;
    }
    /**
     * 获得中央子午线
     * @return meridian
     */
    public Integer getMeridian() {
    	return meridian;
    }
    /**
     * 设置中央子午线
     * @param meridian
     */
    public void setMeridian(Integer meridian) {
    	this.meridian = meridian;
    }
    /**
     * 获得尺度
     * @return k
     */
    public Double getK() {
    	return k;
    }
    /**
     * 设置尺度
     * @param k
     */
    public void setK(Double k) {
    	this.k = k;
    }
    /**
     * 获得x常数
     * @return x
     */
    public Double getX() {
    	return x;
    }
    /**
     * 设置x常数
     * @param x
     */
    public void setX(Double x) {
    	this.x = x;
    }
    /**
     * 获得y常数
     * @return y
     */
    public Double getY() {
    	return y;
    }
    /**
     * 设置y常数
     * @param y
     */
    public void setY(Double y) {
    	this.y = y;
    }
    /**
     * 获得基准纬度
     * @return standerdLat
     */
    public Double getStanderdLat() {
    	return standerdLat;
    }
    /**
     * 设置基准纬度
     * @param standerdLat
     */
    public void setStanderdLat(Double standerdLat) {
    	this.standerdLat = standerdLat;
    }
    /**
     * 获得投影高程
     * @return h
     */
    public Double getH() {
    	return h;
    }
    /**
     * 设置投影高程
     * @param h
     */
    public void setH(Double h) {
    	this.h = h;
    }
    /**
     * 获得投影平均纬
     * @return averageLat
     */
    public Double getAverageLat() {
    	return averageLat;
    }
    /**
     * 设置投影平均纬
     * @param averageLat
     */
    public void setAverageLat(Double averageLat) {
    	this.averageLat = averageLat;
    }
    public String getIsDelete() {
    	return isDelete;
    }
    public void setIsDelete(String isDelete) {
    	this.isDelete = isDelete;
    }
} 		