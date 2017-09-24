package com.cnten.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CorsRepayRel {
	@Id
	@GenericGenerator(name="generator",strategy="uuid.hex")
	@GeneratedValue(generator="generator")
	@Column(unique = true, nullable = false, length = 32)
	private String corsRepayRelId;
	@OneToOne
	@JoinColumn(name="cors_account_id")
	private CorsAccount corsAccount;
	@Column
	private Integer corsRepayPeriod;
	@ManyToOne
	@JoinColumn(name="account_repay_id")
	@JsonIgnore
	private CorsAccountRepay corsAccountRepay;
	
	public String getCorsRepayRelId() {
		return corsRepayRelId;
	}
	public void setCorsRepayRelId(String corsRepayRelId) {
		this.corsRepayRelId = corsRepayRelId;
	}
	public CorsAccount getCorsAccount() {
		return corsAccount;
	}
	public void setCorsAccount(CorsAccount corsAccount) {
		this.corsAccount = corsAccount;
	}
	public Integer getCorsRepayPeriod() {
		return corsRepayPeriod;
	}
	public void setCorsRepayPeriod(Integer corsRepayPeriod) {
		this.corsRepayPeriod = corsRepayPeriod;
	}
	public CorsAccountRepay getCorsAccountRepay() {
		return corsAccountRepay;
	}
	public void setCorsAccountRepay(CorsAccountRepay corsAccountRepay) {
		this.corsAccountRepay = corsAccountRepay;
	}
}
