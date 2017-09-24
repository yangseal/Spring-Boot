package com.cnten.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class CorsRepayTemp {
	@Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 255)
	private String corsRepayTempId;
	@OneToOne
	@JoinColumn(name = "cors_account_id")
	private CorsAccount corsAccount;
	@Column
	private String isDelete;
	@Column
	private Integer accountRepayPeriod;
	public String getCorsRepayTempId() {
		return corsRepayTempId;
	}
	public void setCorsRepayTempId(String corsRepayTempId) {
		this.corsRepayTempId = corsRepayTempId;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public Integer getAccountRepayPeriod() {
		return accountRepayPeriod;
	}
	public void setAccountRepayPeriod(Integer accountRepayPeriod) {
		this.accountRepayPeriod = accountRepayPeriod;
	}
	public CorsAccount getCorsAccount() {
		return corsAccount;
	}
	public void setCorsAccount(CorsAccount corsAccount) {
		this.corsAccount = corsAccount;
	}
}
