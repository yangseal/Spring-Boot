package com.cnten.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Maplayer {

	@Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String maplayerId;
    @Column(length = 200)
    private String name;
    @Column(length = 1)
    private String layerType;
    @Column(length = 100)
    private String address;
    @Column(length = 100)
    private String arcgisUser;
    @Column(length = 100)
    private String arcgisPassword;
    @Column(length = 100)
    private String arcgisToken;
    @Column(length = 200)
    private String description;
    @Column(length = 100)
    private String resource;
    @Column(length = 1)
    private String isDelete;
    @JsonIgnore
    @ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;
	@Transient
	private String companyId;
	@Transient
	private String loginInfo;
    public static final String layerTypeDictStatement = "1,管线图层;2,卫星图层";
	public String getMaplayerId() {
		return maplayerId;
	}
	public void setMaplayerId(String maplayerId) {
		this.maplayerId = maplayerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLayerType() {
		return layerType;
	}
	public void setLayerType(String layerType) {
		this.layerType = layerType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getArcgisUser() {
		return arcgisUser;
	}
	public void setArcgisUser(String arcgisUser) {
		this.arcgisUser = arcgisUser;
	}
	public String getArcgisPassword() {
		return arcgisPassword;
	}
	public void setArcgisPassword(String arcgisPassword) {
		this.arcgisPassword = arcgisPassword;
	}
	public String getArcgisToken() {
		return arcgisToken;
	}
	public void setArcgisToken(String arcgisToken) {
		this.arcgisToken = arcgisToken;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getLoginInfo() {
		return loginInfo;
	}
	public void setLoginInfo(String loginInfo) {
		this.loginInfo = loginInfo;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
}
