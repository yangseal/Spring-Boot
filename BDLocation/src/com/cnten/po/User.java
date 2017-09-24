package com.cnten.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.cnten.platform.util.StringUtil;

@Entity
public class User {
	@Id
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@GeneratedValue(generator = "generator")
	@Column(unique = true, nullable = false, length = 32)
	private String userId;
	@Column(length = 40)
	private String userName;
	@Column(length = 40)
	private String userCode;
	@Column(length = 32)
	private String password;
	@Column(length = 32)
	private String plainPwd;
	@Column(length = 20)
	private String phone;
	@Column(length = 20)
	private String email;
	private Date createDate;
	public static final String approvalStatusDictStatement = "0,已提交;1,业务员确认;2,财务确认;3,已通过;4,已拒绝";
	private String approvalStatus;
	@Column(length = 1)
	private String isDelete;

	@ManyToOne
	@JoinColumn(name="company_org_id")
	private CompanyOrg companyOrg;
	@Column(length = 2)
	private String userFeature;		//账号所属
	
	// added by lanj 增加是否企业管理员
	@Column(length = 1)
	private String isCompanyAdmin;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "company_id")
	private Company company;
	@Transient
	private String companyId;
	
	@Transient
	private Role role;
	
	@Transient
	private String requestPath;  //用于将上一次请求路径返回给前端

	public User() {

	}

	public User(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getApprovalStatus() {
		return this.approvalStatus;
	}

	public String getApprovalStatusName() {
		String status = StringUtil.getDictName(approvalStatus,approvalStatusDictStatement);  
		return (status==null?"已提交":status);
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
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

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * 获得是否为企业管理员 <br/>
	 * 字典(Y,是;N,否)
	 * 
	 * @return typeState
	 */
	public String getIsCompanyAdmin() {
		return isCompanyAdmin;
	}

	/**
	 * 设置是否为企业管理员
	 * 
	 * @param typeState
	 */
	public void setIsCompanyAdmin(String isCompanyAdmin) {
		this.isCompanyAdmin = isCompanyAdmin;
	}
	
	/**
	 * 获得当前角色
	 * @return
	 */
	public Role getRole() {
		return role;
	}
	
	/**
	 * 设置当前角色
	 * @param role
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	public String getRequestPath() {
		return requestPath;
	}

	public void setRequestPath(String requestPath) {
		this.requestPath = requestPath;
	}
	
	public CompanyOrg getCompanyOrg() {
		return companyOrg;
	}

	public void setCompanyOrg(CompanyOrg companyOrg) {
		this.companyOrg = companyOrg;
	}

	public String getPlainPwd() {
		return plainPwd;
	}

	public void setPlainPwd(String plainPwd) {
		this.plainPwd = plainPwd;
	}

	public String getUserFeature() {
		return userFeature;
	}

	public void setUserFeature(String userFeature) {
		this.userFeature = userFeature;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", userCode=" + userCode + ", password=" + password
				+ ", phone=" + phone + ", email=" + email + ", createDate="
				+ createDate + ", approvalStatus=" + approvalStatus
				+ ", isDelete=" + isDelete + ", isCompanyAdmin="
				+ isCompanyAdmin + ", company=" + company + ", companyId="
				+ companyId + ", role=" + role + ", requestPath=" + requestPath
				+ "]";
	}
}
