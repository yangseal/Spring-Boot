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
 * 测试资料 实体类
 * @author Administrator
 */
@Entity
public class BaseMaterial {
	@Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
	private String baseMaterialId;
	@OneToOne
	@JoinColumn(name="base_construct_id")
	private BaseConstruct baseConstruct;
	@Temporal(TemporalType.TIMESTAMP)
	private Date buildStartTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date buildEndTime;
	@Column(length=120)
	private String senceCooper;
	@Column(length=15)
	private String senceCooperPhone;
	@Column(length=120)
	private String senceBuildCharger;
	@Column(length=15)
	private String buildChargerPhone;
	@Column(length=120)
	private String senceConstPerson;
	@Column(length=15)
	private String constPersonPhone;
	@Column(length=1024)
	private String materialRemark;
	@Column(length=1)
	private String isDelete;
	public String getBaseMaterialId() {
		return baseMaterialId;
	}
	public void setBaseMaterialId(String baseMaterialId) {
		this.baseMaterialId = baseMaterialId;
	}
	public BaseConstruct getBaseConstruct() {
		return baseConstruct;
	}
	public void setBaseConstruct(BaseConstruct baseConstruct) {
		this.baseConstruct = baseConstruct;
	}
	public Date getBuildStartTime() {
		return buildStartTime;
	}
	public void setBuildStartTime(Date buildStartTime) {
		this.buildStartTime = buildStartTime;
	}
	public Date getBuildEndTime() {
		return buildEndTime;
	}
	public void setBuildEndTime(Date buildEndTime) {
		this.buildEndTime = buildEndTime;
	}
	public String getSenceCooper() {
		return senceCooper;
	}
	public void setSenceCooper(String senceCooper) {
		this.senceCooper = senceCooper;
	}
	public String getSenceCooperPhone() {
		return senceCooperPhone;
	}
	public void setSenceCooperPhone(String senceCooperPhone) {
		this.senceCooperPhone = senceCooperPhone;
	}
	public String getSenceBuildCharger() {
		return senceBuildCharger;
	}
	public void setSenceBuildCharger(String senceBuildCharger) {
		this.senceBuildCharger = senceBuildCharger;
	}
	public String getBuildChargerPhone() {
		return buildChargerPhone;
	}
	public void setBuildChargerPhone(String buildChargerPhone) {
		this.buildChargerPhone = buildChargerPhone;
	}
	public String getSenceConstPerson() {
		return senceConstPerson;
	}
	public void setSenceConstPerson(String senceConstPerson) {
		this.senceConstPerson = senceConstPerson;
	}
	public String getConstPersonPhone() {
		return constPersonPhone;
	}
	public void setConstPersonPhone(String constPersonPhone) {
		this.constPersonPhone = constPersonPhone;
	}
	public String getMaterialRemark() {
		return materialRemark;
	}
	public void setMaterialRemark(String materialRemark) {
		this.materialRemark = materialRemark;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
}
