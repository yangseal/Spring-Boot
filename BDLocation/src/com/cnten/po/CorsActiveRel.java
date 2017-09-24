package com.cnten.po;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class CorsActiveRel {
	@Id
	@GenericGenerator(name="generator",strategy="uuid.hex")
	@GeneratedValue(generator="generator")
	@Column(unique=true, nullable=false, length=32)
	private String corsActiveRelId;
	@OneToOne
	@JoinColumn(name="cors_account_id")
	private CorsAccount corsAccount;
	@ManyToOne
	@JoinColumn(name="account_active_id")
	private CorsAccountActive corsActive;
	public String getCorsActiveRelId() {
		return corsActiveRelId;
	}
	public void setCorsActiveRelId(String corsActiveRelId) {
		this.corsActiveRelId = corsActiveRelId;
	}
	public CorsAccount getCorsAccount() {
		return corsAccount;
	}
	public void setCorsAccount(CorsAccount corsAccount) {
		this.corsAccount = corsAccount;
	}
	public CorsAccountActive getCorsActive() {
		return corsActive;
	}
	public void setCorsActive(CorsAccountActive corsActive) {
		this.corsActive = corsActive;
	}
}
