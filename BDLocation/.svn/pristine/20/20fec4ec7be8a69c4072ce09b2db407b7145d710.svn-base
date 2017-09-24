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
public class CorsCompanyGroup {
	
	@Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String companyGroupId;
	@ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
	@Column(length = 255)
	private String groupName;
    private Date groupCreateTime = new Date();
    @Column(length = 32)
    private String userId;
	@Column(length = 5)
	private String groupState;
	@Column(length = 500)
	private String remark;
	
	public String getCompanyGroupId() {
		return companyGroupId;
	}
	
	public void setCompanyGroupId(String companyGroupId) {
		this.companyGroupId = companyGroupId;
	}
	/**
	 * 获得所属公司
	 * @return company
	 */
	public Company getCompany() {
		return company;
	}
	/**
	 * 设置所属公司
	 * @param company
	 */
	public void setCompany(Company company) {
		this.company = company;
	}
	/**
	 * 获得分组名称
	 * @return groupName
	 */
	public String getGroupName() {
		return groupName;
	}
	/**
	 * 设置分组名称
	 * @param groupName
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	/**
	 * 获得该分组创建的时间
	 * @return groupCreateTime
	 */
	public Date getGroupCreateTime() {
		return groupCreateTime;
	}
	/**
	 * 设置该分组创建时间
	 * @param groupCreateTime
	 */
	public void setGroupCreateTime(Date groupCreateTime) {
		this.groupCreateTime = groupCreateTime;
	}
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 获得分组状态
	 * @return groupState
	 */
	public String getGroupState() {
		return groupState;
	}
	/**
	 * 设置分组状态
	 * @param groupState
	 */
	public void setGroupState(String groupState) {
		this.groupState = groupState;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
