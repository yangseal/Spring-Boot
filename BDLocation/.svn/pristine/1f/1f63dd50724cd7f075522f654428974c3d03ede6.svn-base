package com.cnten.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class PointTypeAuthorize {

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String pointTypeAuthorizeId;
    @ManyToOne
    @JoinColumn(name="point_type_id")
    private PointType affiliationPointType;
    @Transient
    private String affiliationPointTypeId;
    @ManyToOne
    @JoinColumn(name="company_id")
    private Company affiliationCompany;
    @Transient
    private String affiliationCompanyId;
    private Date authorizeDate;
    @Column(length = 1)
    private String isDelete;
    
    public PointTypeAuthorize() {
    }
    
    public PointTypeAuthorize(String pointTypeAuthorizeId) {
    	this.pointTypeAuthorizeId = pointTypeAuthorizeId;
    }
    
    public String getPointTypeAuthorizeId() {
    	return pointTypeAuthorizeId;
    }
    public void setPointTypeAuthorizeId(String pointTypeAuthorizeId) {
    	this.pointTypeAuthorizeId = pointTypeAuthorizeId;
    }
    /**
     * 获得所属点类型
     * @return affiliationPointType
     */
    public PointType getAffiliationPointType() {
    	return affiliationPointType;
    }
    /**
     * 设置所属点类型
     * @param affiliationPointType
     */
    public void setAffiliationPointType(PointType affiliationPointType) {
    	this.affiliationPointType = affiliationPointType;
    }
    /**
     * 获得所属点类型Id
     * @return affiliationPointTypeId
     */
    public String getAffiliationPointTypeId() {
    	return affiliationPointTypeId;
    }
    /**
     * 设置所属点类型Id
     * @param affiliationPointTypeId
     */
    public void setAffiliationPointTypeId(String affiliationPointTypeId) {
    	this.affiliationPointTypeId = affiliationPointTypeId;
    }
    /**
     * 获得所属企业
     * @return affiliationCompany
     */
    public Company getAffiliationCompany() {
    	return affiliationCompany;
    }
    /**
     * 设置所属企业
     * @param affiliationCompany
     */
    public void setAffiliationCompany(Company affiliationCompany) {
    	this.affiliationCompany = affiliationCompany;
    }
    /**
     * 获得所属企业Id
     * @return affiliationCompanyId
     */
    public String getAffiliationCompanyId() {
    	return affiliationCompanyId;
    }
    /**
     * 设置所属企业Id
     * @param affiliationCompanyId
     */
    public void setAffiliationCompanyId(String affiliationCompanyId) {
    	this.affiliationCompanyId = affiliationCompanyId;
    }
    /**
     * 获得授权日期
     * @return authorizeDate
     */
    public Date getAuthorizeDate() {
    	return authorizeDate;
    }
    /**
     * 设置授权日期
     * @param authorizeDate
     */
    public void setAuthorizeDate(Date authorizeDate) {
    	this.authorizeDate = authorizeDate;
    }
    public String getIsDelete() {
    	return isDelete;
    }
    public void setIsDelete(String isDelete) {
    	this.isDelete = isDelete;
    }  
    
} 		