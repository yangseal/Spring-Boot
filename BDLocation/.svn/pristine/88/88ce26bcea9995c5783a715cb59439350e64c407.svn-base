package com.cnten.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class SendMailRecord {
	@Id
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@GeneratedValue(generator = "generator")
	@Column(unique = true, nullable = false, length = 32)
	private String sendMailRecordId;
	private Date sendTime = new Date();
	@Column(length=120)
	private String receiveMail;
	@OneToOne
	@JoinColumn(name="company_id")
	private Company company;
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	@Column(length=10)
	private String sendRlt;
	@Column(length=1)
	private Integer isDelete;
	public String getSendMailRecordId() {
		return sendMailRecordId;
	}
	public void setSendMailRecordId(String sendMailRecordId) {
		this.sendMailRecordId = sendMailRecordId;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public String getReceiveMail() {
		return receiveMail;
	}
	public void setReceiveMail(String receiveMail) {
		this.receiveMail = receiveMail;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public String getSendRlt() {
		return sendRlt;
	}
	public void setSendRlt(String sendRlt) {
		this.sendRlt = sendRlt;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
}
