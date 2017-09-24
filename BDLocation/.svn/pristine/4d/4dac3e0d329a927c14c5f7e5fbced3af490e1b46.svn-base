package com.cnten.po;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import org.hibernate.annotations.GenericGenerator;
import com.cnten.platform.util.StringUtil;

@Entity
public class Company {
	
	@Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String companyId;
    @Column(length = 100)
    private String companyName;
    @Column(length = 50)
    private String companyCode;
    @Column(length = 50)
    private String password;
    @Column(length = 100)
    private String address;
    @Column(length = 20)
    private String tel;
    @Column(length = 20)
    private String contacts;
    @Column(length = 20)
    private String post;
    @Column(length = 20)
    private String phone;
    @Column(length = 32)
    private String email;
    @Column(length = 1)
    private String isDelete;
    @Column(length = 255)
    private String corporate;
    @Column(length = 500)
    private String businessLicense;
    @Transient
    private String companyMaterialStateName;
    @Column(length = 20)
    private String companyMaterialState; 
    public static final String stateDictStatementDictStatement = "0,未认证;1,审核中;2,已认证;3,认证未通过;4,未认证";
    
    /*  
    @ManyToOne
    @JoinColumn(name="order_bussinkey")
    private CorsBusiApprove corsBusiApprove;
    */
    @Transient
	private String busiCompanyId;
    
    @Transient
	private String busiApproveId;
    

    @Transient
	private String userId;
    
    private Date createDate = new Date();
    public Company() {
    }
    
    public Company(String companyId) {
    	this.companyId = companyId;
    }
    
    public String getCompanyId() {
    	return companyId;
    }
    public void setCompanyId(String companyId) {
    	this.companyId = companyId;
    }
    public String getCompanyName() {
    	return companyName;
    }
    public void setCompanyName(String companyName) {
    	this.companyName = companyName;
    }
    public String getCompanyCode() {
    	return companyCode;
    }
    public void setCompanyCode(String companyCode) {
    	this.companyCode = companyCode;
    }
    public String getPassword() {
    	return password;
    }
    public void setPassword(String password) {
    	this.password = password;
    }
    public String getAddress() {
    	return address;
    }
    public void setAddress(String address) {
    	this.address = address;
    }
    public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getPhone() {
    	return phone;
    }
    public void setPhone(String phone) {
    	this.phone = phone;
    }
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIsDelete() {
    	return isDelete;
    }
    public void setIsDelete(String isDelete) {
    	this.isDelete = isDelete;
    }

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCorporate() {
		return corporate;
	}

	public void setCorporate(String corporate) {
		this.corporate = corporate;
	}

	public String getBusinessLicense() {
		return businessLicense;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}
	
	public String getCompanyMaterialStateName() {
		return StringUtil.getDictName(companyMaterialState,stateDictStatementDictStatement);
	}
	 /**
     * 资料审批状态
     * <br/>
     * 字典语句( 0/null：未提交  1：已提交  2：审批通过  3：审批未通过)
     * @param companyMaterialState
     */
	public String getCompanyMaterialState() {
		return companyMaterialState;
	}

	public void setCompanyMaterialState(String companyMaterialState) {
		this.companyMaterialState = companyMaterialState;
	}

	public String getCompanyMaterialStateValue() {
		return companyMaterialState;
	}

	public String getBusiCompanyId() {
		return busiCompanyId;
	}

	public void setBusiCompanyId(String busiCompanyId) {
		this.busiCompanyId = busiCompanyId;
	}

	public String getBusiApproveId() {
		return busiApproveId;
	}

	public void setBusiApproveId(String busiApproveId) {
		this.busiApproveId = busiApproveId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName="
				+ companyName + ", companyCode=" + companyCode + ", password="
				+ password + ", address=" + address + ", tel=" + tel
				+ ", contacts=" + contacts + ", post=" + post + ", phone="
				+ phone + ", email=" + email + ", isDelete=" + isDelete
				+ ", corporate=" + corporate + ", businessLicense="
				+ businessLicense + ", companyMaterialStateName="
				+ companyMaterialStateName + ", companyMaterialState="
				+ companyMaterialState + ", busiCompanyId=" + busiCompanyId
				+ ", busiApproveId=" + busiApproveId + ", userId=" + userId
				+ ", createDate=" + createDate + "]";
	}
	
} 		