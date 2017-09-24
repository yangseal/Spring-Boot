package com.cnten.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

/**
 * 基站验收资料 实体类
 * @author Administrator
 */
@Entity
public class BaseCheckMatetial {
	@Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
	private String baseCheckMatetialId;
	@OneToOne
	@JoinColumn(name="base_construct_id")
	private BaseConstruct baseConstruct;
	@Column(length=12)
	private String baseLng;
	@Column(length=12)
	private String baseLat;
	@Column(length=12)
	private String baseElevation;
	@Column(length=12)
	private String stationType;
	@Column(length=15)
	private String receiverIp;
	@Column(length=15)
	private String isDelete;
	public String getBaseCheckMatetialId() {
		return baseCheckMatetialId;
	}
	public void setBaseCheckMatetialId(String baseCheckMatetialId) {
		this.baseCheckMatetialId = baseCheckMatetialId;
	}
	public BaseConstruct getBaseConstruct() {
		return baseConstruct;
	}
	public void setBaseConstruct(BaseConstruct baseConstruct) {
		this.baseConstruct = baseConstruct;
	}
	public String getBaseLng() {
		return baseLng;
	}
	public void setBaseLng(String baseLng) {
		this.baseLng = baseLng;
	}
	public String getBaseLat() {
		return baseLat;
	}
	public void setBaseLat(String baseLat) {
		this.baseLat = baseLat;
	}
	public String getBaseElevation() {
		return baseElevation;
	}
	public void setBaseElevation(String baseElevation) {
		this.baseElevation = baseElevation;
	}
	public String getStationType() {
		return stationType;
	}
	public void setStationType(String stationType) {
		this.stationType = stationType;
	}
	public String getReceiverIp() {
		return receiverIp;
	}
	public void setReceiverIp(String receiverIp) {
		this.receiverIp = receiverIp;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
}
