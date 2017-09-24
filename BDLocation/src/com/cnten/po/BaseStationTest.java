package com.cnten.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * 测试资料实体类
 * @author Administrator
 */
@Entity
public class BaseStationTest {
	@Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
	private String baseStationTestId;
	@Temporal(TemporalType.TIMESTAMP)
	private Date coorStartTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date coorEndTime;
	@Column(length=45)
	private String coorCharger;
	@OneToOne
	@JoinColumn(name="base_construct_id")
	private BaseConstruct baseConstruct;
	@Column(length=15)
	private String coorChargerPhone;
	@Column(length=255)
	private String coorStandard;
	@Column(length=255)
	private String dataAdjustSoft;
	@Column(length=1024)
	private String coorRemark;
	@Temporal(TemporalType.TIMESTAMP)
	private Date sysStartTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date sysEndTime;
	@Column(length=45)
	private String sysCharger;
	@Column(length=15)
	private String sysChargerPhone;
	@Column(length=255)
	private String sysContent;
	@Column(length=1024)
	private String sysRemark;
	@OneToMany
	@JoinColumn(name="base_station_test_Id")
	private List<BaseLinkPoint> baseLinkPoint = new ArrayList<BaseLinkPoint>();
	@Column(length=1)
	private String isDelete;
	public String getBaseStationTestId() {
		return baseStationTestId;
	}
	public void setBaseStationTestId(String baseStationTestId) {
		this.baseStationTestId = baseStationTestId;
	}
	public Date getCoorStartTime() {
		return coorStartTime;
	}
	public void setCoorStartTime(Date coorStartTime) {
		this.coorStartTime = coorStartTime;
	}
	public Date getCoorEndTime() {
		return coorEndTime;
	}
	public void setCoorEndTime(Date coorEndTime) {
		this.coorEndTime = coorEndTime;
	}
	public String getCoorCharger() {
		return coorCharger;
	}
	public void setCoorCharger(String coorCharger) {
		this.coorCharger = coorCharger;
	}
	public String getCoorChargerPhone() {
		return coorChargerPhone;
	}
	public void setCoorChargerPhone(String coorChargerPhone) {
		this.coorChargerPhone = coorChargerPhone;
	}
	public String getCoorStandard() {
		return coorStandard;
	}
	public void setCoorStandard(String coorStandard) {
		this.coorStandard = coorStandard;
	}
	public String getDataAdjustSoft() {
		return dataAdjustSoft;
	}
	public void setDataAdjustSoft(String dataAdjustSoft) {
		this.dataAdjustSoft = dataAdjustSoft;
	}
	public String getCoorRemark() {
		return coorRemark;
	}
	public void setCoorRemark(String coorRemark) {
		this.coorRemark = coorRemark;
	}
	public Date getSysStartTime() {
		return sysStartTime;
	}
	public void setSysStartTime(Date sysStartTime) {
		this.sysStartTime = sysStartTime;
	}
	public Date getSysEndTime() {
		return sysEndTime;
	}
	public void setSysEndTime(Date sysEndTime) {
		this.sysEndTime = sysEndTime;
	}
	public String getSysCharger() {
		return sysCharger;
	}
	public void setSysCharger(String sysCharger) {
		this.sysCharger = sysCharger;
	}
	public String getSysChargerPhone() {
		return sysChargerPhone;
	}
	public void setSysChargerPhone(String sysChargerPhone) {
		this.sysChargerPhone = sysChargerPhone;
	}
	public String getSysContent() {
		return sysContent;
	}
	public void setSysContent(String sysContent) {
		this.sysContent = sysContent;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public BaseConstruct getBaseConstruct() {
		return baseConstruct;
	}
	public void setBaseConstruct(BaseConstruct baseConstruct) {
		this.baseConstruct = baseConstruct;
	}
	public List<BaseLinkPoint> getBaseLinkPoint() {
		return baseLinkPoint;
	}
	public void setBaseLinkPoint(List<BaseLinkPoint> baseLinkPoint) {
		this.baseLinkPoint = baseLinkPoint;
	}
	public String getSysRemark() {
		return sysRemark;
	}
	public void setSysRemark(String sysRemark) {
		this.sysRemark = sysRemark;
	}
	
}
