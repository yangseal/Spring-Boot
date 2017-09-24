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

import org.hibernate.annotations.GenericGenerator;

/**
 * 选址资料 实体类
 * @author Administrator
 */
@Entity
public class BaseAddress {
	@Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
	private String baseAddressId;
	@OneToOne
	@JoinColumn(name="base_construct_id")
	private BaseConstruct baseConstruct;
	@Column(length=255)
	private String finalAddress;
	@Temporal(TemporalType.TIMESTAMP)
	private Date addrStartTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date addrEndTime;
	@Column(length=45)
	private String senceCharger;
	@Column(length=15)
	private String senceChargerPhone;
	@Column(length=255)
	private String shelterOverview;
	@Column(length=255)
	private String trafficOverview;
	@Column(length=255)
	private String interOverview;
	@Column(length=255)
	private String lightningOverview;
	@Column(length=255)
	private String waterOverview;
	@Column(length=255)
	private String roofOverview;
	@Column(length=1024)
	private String envRemark;
	@Column(length=255)
	private String netCondition;
	@Column(length=255)
	private String netType;
	@Column(length=255)
	private String netConfig;
	@Column(length=1024)
	private String netRemark;
	@Column(length=255)
	private String powerCondition;
	@Column(length=1024)
	private String powerRemark;
	@Column(length=1024)
	private String addressRemark;
	@Column(length=1)
	private String isDelete;
	public String getBaseAddressId() {
		return baseAddressId;
	}
	public void setBaseAddressId(String baseAddressId) {
		this.baseAddressId = baseAddressId;
	}
	public BaseConstruct getBaseConstruct() {
		return baseConstruct;
	}
	public void setBaseConstruct(BaseConstruct baseConstruct) {
		this.baseConstruct = baseConstruct;
	}
	public String getFinalAddress() {
		return finalAddress;
	}
	public void setFinalAddress(String finalAddress) {
		this.finalAddress = finalAddress;
	}
	public Date getAddrStartTime() {
		return addrStartTime;
	}
	public void setAddrStartTime(Date addrStartTime) {
		this.addrStartTime = addrStartTime;
	}
	public Date getAddrEndTime() {
		return addrEndTime;
	}
	public void setAddrEndTime(Date addrEndTime) {
		this.addrEndTime = addrEndTime;
	}
	public String getSenceCharger() {
		return senceCharger;
	}
	public void setSenceCharger(String senceCharger) {
		this.senceCharger = senceCharger;
	}
	public String getSenceChargerPhone() {
		return senceChargerPhone;
	}
	public void setSenceChargerPhone(String senceChargerPhone) {
		this.senceChargerPhone = senceChargerPhone;
	}
	public String getShelterOverview() {
		return shelterOverview;
	}
	public void setShelterOverview(String shelterOverview) {
		this.shelterOverview = shelterOverview;
	}
	public String getTrafficOverview() {
		return trafficOverview;
	}
	public void setTrafficOverview(String trafficOverview) {
		this.trafficOverview = trafficOverview;
	}
	public String getInterOverview() {
		return interOverview;
	}
	public void setInterOverview(String interOverview) {
		this.interOverview = interOverview;
	}
	public String getLightningOverview() {
		return lightningOverview;
	}
	public void setLightningOverview(String lightningOverview) {
		this.lightningOverview = lightningOverview;
	}
	public String getWaterOverview() {
		return waterOverview;
	}
	public void setWaterOverview(String waterOverview) {
		this.waterOverview = waterOverview;
	}
	public String getRoofOverview() {
		return roofOverview;
	}
	public void setRoofOverview(String roofOverview) {
		this.roofOverview = roofOverview;
	}
	public String getEnvRemark() {
		return envRemark;
	}
	public void setEnvRemark(String envRemark) {
		this.envRemark = envRemark;
	}
	public String getNetCondition() {
		return netCondition;
	}
	public void setNetCondition(String netCondition) {
		this.netCondition = netCondition;
	}
	public String getNetType() {
		return netType;
	}
	public void setNetType(String netType) {
		this.netType = netType;
	}
	public String getNetConfig() {
		return netConfig;
	}
	public void setNetConfig(String netConfig) {
		this.netConfig = netConfig;
	}
	public String getNetRemark() {
		return netRemark;
	}
	public void setNetRemark(String netRemark) {
		this.netRemark = netRemark;
	}
	public String getPowerCondition() {
		return powerCondition;
	}
	public void setPowerCondition(String powerCondition) {
		this.powerCondition = powerCondition;
	}
	public String getPowerRemark() {
		return powerRemark;
	}
	public void setPowerRemark(String powerRemark) {
		this.powerRemark = powerRemark;
	}
	public String getAddressRemark() {
		return addressRemark;
	}
	public void setAddressRemark(String addressRemark) {
		this.addressRemark = addressRemark;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
}
