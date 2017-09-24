package com.cnten.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ChatLog {
	@Id
	@GenericGenerator(name="generator",strategy="uuid.hex")
	@GeneratedValue(generator="generator")
	@Column(unique = true, nullable = false, length = 32)
	private String chatLogId;
	@Column
	private String chatSender;
	@Column
	private String chatRecipient;
	@Temporal(TemporalType.TIMESTAMP)    
	private Date chatTime = new Date();
	@Column
	private String chatContent;
	@Column
	private String chatAccountType;
	@Column
	private String chatStatus;
	
	public String getChatLogId() {
		return chatLogId;
	}
	public void setChatLogId(String chatLogId) {
		this.chatLogId = chatLogId;
	}
	public String getChatSender() {
		return chatSender;
	}
	public void setChatSender(String chatSender) {
		this.chatSender = chatSender;
	}
	public String getChatRecipient() {
		return chatRecipient;
	}
	public void setChatRecipient(String chatRecipient) {
		this.chatRecipient = chatRecipient;
	}
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getChatTime() {
		return chatTime;
	}
	public void setChatTime(Date chatTime) {
		this.chatTime = chatTime;
	}
	public String getChatContent() {
		return chatContent;
	}
	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}
	public String getChatAccountType() {
		return chatAccountType;
	}
	public void setChatAccountType(String chatAccountType) {
		this.chatAccountType = chatAccountType;
	}
	public String getChatStatus() {
		return chatStatus;
	}
	public void setChatStatus(String chatStatus) {
		this.chatStatus = chatStatus;
	}
	
	

}
