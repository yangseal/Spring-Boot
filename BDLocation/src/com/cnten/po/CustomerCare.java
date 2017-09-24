package com.cnten.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class CustomerCare {
	@Id
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@GeneratedValue(generator = "generator")
	@Column(unique = true, nullable = false, length = 32)
	private String bdCustomerCareId;
	@Column(length=32)
	private String customerCareNo;
	@Column(length=255)
	private String customerCareName;
	@Column(length=1)
	private String isDelete;
	@Column(length=1)
	private String isOnline;
	public String getBdCustomerCareId() {
		return bdCustomerCareId;
	}
	public void setBdCustomerCareId(String bdCustomerCareId) {
		this.bdCustomerCareId = bdCustomerCareId;
	}
	public String getCustomerCareNo() {
		return customerCareNo;
	}
	public void setCustomerCareNo(String customerCareNo) {
		this.customerCareNo = customerCareNo;
	}
	public String getCustomerCareName() {
		return customerCareName;
	}
	public void setCustomerCareName(String customerCareName) {
		this.customerCareName = customerCareName;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public String getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}

}
