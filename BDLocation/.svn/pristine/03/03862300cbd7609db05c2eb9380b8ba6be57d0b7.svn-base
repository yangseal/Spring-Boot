package com.cnten.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class BaseProvider {
	@Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String baseProviderId;
	@Column(length = 100)
	private String providerName;
	@ManyToOne
    @JoinColumn(name="oam_area_id")
	private OamArea oamArea;
	@Column(length = 100)
	private String providerAddress;
	@Column(length = 500)
	private String provideRemark;
	private Date providerCreateDate = new Date();
	@Column(length = 32)
	private String providerCreateUser;
	private Date providerUpdateDate;
	@Column(length = 32)
	private String providerUpdateUser;
	@Column(length = 1)
	private String isDelete;

	public String getBaseProviderId() {
		return baseProviderId;
	}

	public void setBaseProviderId(String baseProviderId) {
		this.baseProviderId = baseProviderId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public OamArea getOamArea() {
		return oamArea;
	}

	public void setOamArea(OamArea oamArea) {
		this.oamArea = oamArea;
	}

	public String getProviderAddress() {
		return providerAddress;
	}

	public void setProviderAddress(String providerAddress) {
		this.providerAddress = providerAddress;
	}

	public Date getProviderCreateDate() {
		return providerCreateDate;
	}

	public void setProviderCreateDate(Date providerCreateDate) {
		this.providerCreateDate = providerCreateDate;
	}

	public String getProviderCreateUser() {
		return providerCreateUser;
	}

	public void setProviderCreateUser(String providerCreateUser) {
		this.providerCreateUser = providerCreateUser;
	}

	public Date getProviderUpdateDate() {
		return providerUpdateDate;
	}

	public void setProviderUpdateDate(Date providerUpdateDate) {
		this.providerUpdateDate = providerUpdateDate;
	}

	public String getProviderUpdateUser() {
		return providerUpdateUser;
	}

	public void setProviderUpdateUser(String providerUpdateUser) {
		this.providerUpdateUser = providerUpdateUser;
	}

	public String getProvideRemark() {
		return provideRemark;
	}

	public void setProvideRemark(String provideRemark) {
		this.provideRemark = provideRemark;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
}
