package com.cnten.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class CompanyTemp {

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String companyTempId;
    @Column(length = 100)
    private String companyTempName;
    @Column(length = 100)
    private String address;
	@Column(length = 100)
    private String tel;
    @Column(length = 100)
    private String contacts;
    @Column(length = 100)
    private String post;
    @Column(length = 100)
    private String phone;
    @Column(length = 32)
    private String email;
    @Column(length = 1)
    private String is_delete;
    @Column(length = 20)
    private String status;
    @OneToOne(optional=false)
    @JoinColumn(name="company_province_id")
    private OamArea province;
    @OneToOne(optional=false)
    @JoinColumn(name="company_city_id")
    private OamArea city;
    private Date createDate = new Date();
    
    @Transient
    private String companyCode;
    @Transient
    private String userCode;
    @Transient
    private String password;
    @Transient
    private String isCompanyAdmin;
    
    public String getCompanyTempId() {
    	return companyTempId;
    }
    public void setCompanyTempId(String companyTempId) {
    	this.companyTempId = companyTempId;
    }
    /**
     * 获得企业名称
     * @return companyTempName
     */
    public String getCompanyTempName() {
    	return companyTempName;
    }
    /**
     * 设置企业名称
     * @param companyTempName
     */
    public void setCompanyTempName(String companyTempName) {
    	this.companyTempName = companyTempName;
    }
    /**
     * 获得企业地址
     * @return address
     */
    public String getAddress() {
    	return address;
    }
    /**
     * 设置企业地址
     * @param address
     */
    public void setAddress(String address) {
    	this.address = address;
    }
    /**
     * 获得企业电话
     * @return tel
     */
    public String getTel() {
    	return tel;
    }
    /**
     * 设置企业电话
     * @param tel
     */
    public void setTel(String tel) {
    	this.tel = tel;
    }
    /**
     * 获得联系人姓名
     * @return contacts
     */
    public String getContacts() {
    	return contacts;
    }
    /**
     * 设置联系人姓名
     * @param contacts
     */
    public void setContacts(String contacts) {
    	this.contacts = contacts;
    }
    /**
     * 获得联系人职务
     * @return
     */
    public String getPost() {
		return post;
	}
    /**
     * 设置联系人职务
     * @param post
     */
	public void setPost(String post) {
		this.post = post;
	}
	/**
     * 获得联系人电话
     * @return phone
     */
    public String getPhone() {
    	return phone;
    }
    /**
     * 设置联系人电话
     * @param phone
     */
    public void setPhone(String phone) {
    	this.phone = phone;
    }
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getIs_delete() {
		return is_delete;
	}
	public void setIs_delete(String is_delete) {
		this.is_delete = is_delete;
	}
	
	public OamArea getProvince() {
		return province;
	}
	public void setProvince(OamArea province) {
		this.province = province;
	}
	public OamArea getCity() {
		return city;
	}
	public void setCity(OamArea city) {
		this.city = city;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIsCompanyAdmin() {
		return isCompanyAdmin;
	}
	public void setIsCompanyAdmin(String isCompanyAdmin) {
		this.isCompanyAdmin = isCompanyAdmin;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = new Date();
	}
	@Override
	public String toString() {
		return "CompanyTemp [companyTempId=" + companyTempId
				+ ", companyTempName=" + companyTempName + ", address="
				+ address + ", tel=" + tel + ", contacts=" + contacts
				+ ", post=" + post + ", phone=" + phone + ", email=" + email
				+ ", is_delete=" + is_delete + ", status=" + status
				+ ", province=" + province + ", city=" + city + ", createDate="
				+ createDate + ", companyCode=" + companyCode + ", userCode="
				+ userCode + ", password=" + password + ", isCompanyAdmin="
				+ isCompanyAdmin + "]";
	}
	
	
	
} 		