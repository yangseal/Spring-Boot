package com.cnten.platform.mail;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.cnten.platform.util.PropsUtil;
import com.sun.mail.util.MailSSLSocketFactory;

public class MailSendAction {
	private String SMTPHost;
	private String from;
	private String password;
	
	private static MailSendAction sendMailAction = null;
	
	private MailSendAction() {
		Properties props = PropsUtil.loadProps();
		this.SMTPHost = props.getProperty("mail.smtp.host");
		this.from = props.getProperty("mail.from");
		this.password = props.getProperty("mail.password");
	}
	
	public static final MailSendAction getSendMailAction(){
		if(sendMailAction == null){
			sendMailAction = new MailSendAction();
		}
		return sendMailAction;
	}
	
	public void send(MailParams mailParam){
		try{
			//创建一个属性对象
			Properties props = new Properties();
			//指定SMTP服务器
			props.put("mail.smtp.host", this.SMTPHost);
			//指定是否需要SMTP验证		
			props.put("mail.smtp.auth", true);
			MailSSLSocketFactory sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			props.put("mail.smtp.ssl.enable", true);
			props.put("mail.smtp.ssl.socketFactory", sf);
			
			//创建一个授权验证对象
			SmtpAuth auth = new SmtpAuth();
			auth.setAccount(this.from, this.password);
			
			//创建一个Session对象
			Session mailSession = Session.getDefaultInstance(props,auth);
			mailSession.setDebug(true);
			
			//创建一个Message对象
			Message message=new MimeMessage(mailSession);

			//指定发件人邮箱
			message.setFrom(new InternetAddress(this.from));
			//指定收件人邮箱
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(mailParam.getReceiver()));
			//指定邮件主题
			message.setSubject(mailParam.getSubject());
			//指定邮件内容
			setMessageContent(message,mailParam);
			//指定邮件发送日期
			message.setSentDate(new Date());
			//指定邮件优先级 1：紧急 3：普通 5：缓慢
			message.setHeader("X-Priority","1");
			message.saveChanges();
						
			//创建一个Transport对象
			Transport transport = mailSession.getTransport("smtp");
			//连接SMTP服务器
			transport.connect(this.SMTPHost, this.from, this.password);
			//发送邮件
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void setMessageContent(Message message, MailParams mailParam){
		try {
			if(Mail.MAIL_SEND_TEXT.equals(mailParam.getMailType())){
				message.setText(mailParam.getContent());
			} else if(Mail.MAIL_SEND_HTML.equals(mailParam.getMailType())){
				message.setContent(mailParam.getContent(), "text/html;charset=utf-8");
			} else {
				//新建一个MimeMultipart对象用来存放多个BodyPart对象
				Multipart container=new MimeMultipart();
				//新建一个存放信件内容的BodyPart对象
				BodyPart textBodyPart=new MimeBodyPart();
				//给BodyPart对象设置内容和格式/编码方式
				textBodyPart.setContent(mailParam.getContent(),"text/html;charset=utf-8");
				//将含有信件内容的BodyPart加入到MimeMultipart对象中
				container.addBodyPart(textBodyPart);
				
				//新建一个存放信件附件的BodyPart对象
				BodyPart fileBodyPart=new MimeBodyPart();
				//将本地文件作为附件
				FileDataSource fds=new FileDataSource(mailParam.getAttachment());
				fileBodyPart.setDataHandler(new DataHandler(fds));
				//处理邮件中附件文件名的中文问题
				String attachName = fds.getName();
				attachName = new String(attachName.getBytes("gb2312"),"utf-8");
				//设定附件文件名
				fileBodyPart.setFileName(attachName);
				//将附件的BodyPart对象加入到container中
				container.addBodyPart(fileBodyPart);
				
				//将container作为消息对象的内容
				message.setContent(container);
			}
			
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	
	 static class SmtpAuth extends Authenticator {
		 String user, password;
		 //设置账号信息
		 void setAccount(String user, String password){
			 this.user = user;
			 this.password = password;
		 }
		 //取得PasswordAuthentication对象
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return super.getPasswordAuthentication();
		}
	 }

}
