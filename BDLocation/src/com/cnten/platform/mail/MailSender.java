package com.cnten.platform.mail;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.OutputBuffer;

import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.util.PropsUtil;
import com.cnten.platform.web.Constants;
import com.sun.corba.se.impl.orbutil.closure.Constant;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class MailSender {
	
	/**
	 * 发送字符邮件, 邮件类型为 ：text、html、attach (内容均为字符串，无需再做处理)
	 * @param mail mailType, receiver, content, subject, attachment
	 */
	public static void sendMail(final Mail mail){
		MailSendAction.getSendMailAction()
			.send(new MailParams(mail.getMailType(),mail.getReceiver(),mail.getContent(),
					mail.getSubject(),mail.getAttachment()) {
				@Override
				public String getContent() {
					return mail.getContent();
				}
			});
	}
	
	/**
	 * 发送html邮件, 邮件类型为 ：html, 邮件内容为html 文件路径（freemarker文件），
	 * 用例：MailSender.sendHtmlMailOfFreemarker(new Mail(Mail.MAIL_SEND_HTML, "1018801394@qq.com", "materialApprovePass.ftl", "测试邮件",null,data));
	 * @param mail
	 */
	public static void sendHtmlMailOfFreemarker (final Mail mail){
		MailSendAction.getSendMailAction()
			.send(new MailParams(mail.getMailType(),mail.getReceiver(),mail.getContent(),
					mail.getSubject(),mail.getAttachment()) {
				@Override
				public String getContent() {
				        try {
				        	//1.创建配置实例Cofiguration  
					        Configuration cfg = new Configuration();  
					        //2.工程目录下的目录
					        String path = Thread.currentThread().getContextClassLoader().getResource("/").getPath();
					        	   path = "/"+path.substring(1, path.indexOf("classes"));
//				    		String path = PropsUtil.class.getClass().getResource("/").getPath();
//						       path = path.substring(1, path.indexOf("classes"));
							       path = path.replaceAll("//", "/");
							cfg.setDirectoryForTemplateLoading(new File(path+"/ftl/email"));
							cfg.setEncoding(Locale.getDefault(), "UTF-8");
							//获取模板（template）  
					        Template template = cfg.getTemplate(mail.getContent());  
					        StringWriter out = new StringWriter();  
					        //数据与模板合并（数据+模板=输出） 
					        System.out.println("-----------访问路径-： " + Constants.BDLOCATION_SERVERE_ACCESS_PATH);
					        HashMap<String,Object> modelData = null;
					        if(mail.getDataMap() != null){
					        	modelData = mail.getDataMap();
					        }else{
					        	modelData = new HashMap<String,Object>();
					        }
					        
					        modelData.put("ContextPath", Constants.BDLOCATION_SERVERE_ACCESS_PATH);
					        System.out.println("-----modelData----contextPath-： " + modelData.get("ContextPath"));
					        template.process(modelData, out);  
					        out.flush();  
					        return out.toString();
						} catch (IOException e) {
							e.printStackTrace();
						} catch (TemplateException e) {
							e.printStackTrace();
						}
						return null; 
				}
			});
	}
	
}
