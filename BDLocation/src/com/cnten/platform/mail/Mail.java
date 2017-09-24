package com.cnten.platform.mail;

import java.util.HashMap;


public class Mail extends MailParams {
	public static final String MAIL_SEND_TEXT = "text";				//发送文本邮件
	public static final String MAIL_SEND_HTML = "html";				//发送html邮件
	public static final String MAIL_SEND_ATTACH = "attachment";			//发送附件邮件
	
	private String SMTPHost; 				//SMTP服务器
	private String from; 				    //登录SMTP服务器的帐号
	private String password; 			    //登录SMTP服务器的密码
	private String receiver;			    //收件人邮箱
	private String content;				    //邮件内容
	private String subject;				    //邮件主题
	private String mailType;				//邮件类型(text,html,attach)
	private String attachment;				//附件
	private HashMap<String,Object> dataMap;  //模板中替换数据
	
	public Mail(String mailType, String receiver, String content, String subject,
			 String attachment,HashMap<String,Object> dataMap) {
		super(mailType, receiver, content, subject, attachment);
		this.receiver = receiver;
		this.content = content;
		this.subject = subject;
		this.mailType = mailType;
		this.attachment = attachment;
		this.dataMap = dataMap;
	}
	@Override
	public String getReceiver() {
		return receiver;
	}
	@Override
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	@Override
	public String getContent() {
		return content;
	}
	@Override
	public void setContent(String content) {
		try{			
			//解决内容的中文问题
			content = new String(content.getBytes("ISO8859-1"),"gb2312");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		this.content = content;
	}
	@Override
	public String getSubject() {
		return subject;
	}
	@Override
	public void setSubject(String subject) {
		try{			
			//解决标题的中文问题
			subject = new String(subject.getBytes("ISO8859-1"),"gb2312");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		this.subject = subject;
	}
	@Override
	public String getSMTPHost() {
		return SMTPHost;
	}
	@Override
	public void setSMTPHost(String sMTPHost) {
		SMTPHost = sMTPHost;
	}
	@Override
	public String getFrom() {
		return from;
	}
	@Override
	public void setFrom(String from) {
		this.from = from;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String getMailType() {
		return mailType;
	}
	@Override
	public void setMailType(String mailType) {
		this.mailType = mailType;
	}
	@Override
	public String getAttachment() {
		return attachment;
	}
	@Override
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	@Override
	public HashMap<String, Object> getDataMap() {
		return dataMap;
	}
	@Override
	public void setDataMap(HashMap<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
}
