package com.cnten.platform.mail;

import java.util.HashMap;

public abstract class MailParams{
	private String SMTPHost; 				//SMTP服务器
	private String from; 				    //登录SMTP服务器的帐号
	private String password; 			    //登录SMTP服务器的密码
	private String receiver;			    //收件人邮箱
	private String content;				    //邮件内容
	private String subject;				    //邮件主题
	private String mailType;				//邮件类型(text,html,attach)
	private String attachment;				//附件
	private HashMap<String,Object> dataMap;  //模板中替换数据
	
	public MailParams(String mailType, String receiver, String content, String subject,
			 String attachment) {
		this.receiver = receiver;
		this.content = content;
		this.subject = subject;
		this.mailType = mailType;
		this.attachment = attachment;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public abstract String getContent();
	public void setContent(String content) {
		try{			
			//解决内容的中文问题
			content = new String(content.getBytes("ISO8859-1"),"utf-8");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		this.content = content;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		try{			
			//解决标题的中文问题
			subject = new String(subject.getBytes("ISO8859-1"),"utf-8");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		this.subject = subject;
	}
	public String getSMTPHost() {
		return SMTPHost;
	}
	public void setSMTPHost(String sMTPHost) {
		SMTPHost = sMTPHost;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMailType() {
		return mailType;
	}
	public void setMailType(String mailType) {
		this.mailType = mailType;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public HashMap<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(HashMap<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
}
