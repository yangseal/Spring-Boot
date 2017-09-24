package com.cnten.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

/**
 * 公司组织机构 实体类
 * @author Administrator
 */
@Entity
public class CompanyOrg {
	@Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
	private String companyOrgId;
	@Column(length=255)
	private String orgName;
	@Column(length=3)
	private Integer orgLevel;
	@Column(length=32)
	private String parentOrgId;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="company_id")
	private Company company;
	@Column(length=25)
	private String adminCode;
	@Column(length=25)
	private String adminPwd;
	
	@Column(length=1)
	private String isDelete;
	
	public CompanyOrg() {
		super();
	}
	
	public CompanyOrg(String companyOrgId) {
		super();
		this.companyOrgId = companyOrgId;
	}
	
	public String getCompanyOrgId() {
		return companyOrgId;
	}
	public void setCompanyOrgId(String companyOrgId) {
		this.companyOrgId = companyOrgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public Integer getOrgLevel() {
		return orgLevel;
	}
	public void setOrgLevel(Integer orgLevel) {
		this.orgLevel = orgLevel;
	}
	public String getParentOrgId() {
		return parentOrgId;
	}
	public void setParentOrgId(String parentOrgId) {
		this.parentOrgId = parentOrgId;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public String getAdminCode() {
		return adminCode;
	}
	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
}
