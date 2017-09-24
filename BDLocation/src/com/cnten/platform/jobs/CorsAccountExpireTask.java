package com.cnten.platform.jobs;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cnten.bdlocation.constants.CorsAccountConsts;
import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.mail.Mail;
import com.cnten.platform.mail.MailSender;
import com.cnten.platform.util.StringUtil;
import com.cnten.po.Company;
import com.cnten.po.CorsAccount;
import com.cnten.po.SendMailRecord;
import com.cnten.po.User;

@Component
public class CorsAccountExpireTask{
	@Autowired
	private CommonDAO commonDAO;
	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public CorsAccountExpireTask(){
	}
	
	//@Scheduled(cron = "0/30 * *  * * ? ")    //每隔30秒隔行一次【测试使用】
    @Scheduled(cron = "0 0 2 * * ?")         //每天凌晨2点运行一次【正式使用】
    public void job1() {  
    	 System.out.println("执行当前时间------："+formatter.format(Calendar.getInstance().getTime()));
    	 //updateExpireAccountState();
    	 sendEmailOfJustExpire();
    }
	
	
	/**
     * 更新过期账号的状态 
     */
    public void updateExpireAccountState(){
    	try{
    		String hql = " from CorsAccount a where a.isDelete is null";
        	List<CorsAccount> corsList = commonDAO.queryList(hql, null);
        	Date nowDate = new Date();
        	for (CorsAccount corsAccount : corsList) {
				Date expireDate = corsAccount.getExprieDate();
				if(expireDate != null && expireDate.before(nowDate)){ //失效时间小于等于当前时间,更新账号状态为【已过期】
					corsAccount.setCorsAccountState(CorsAccountConsts.ACCOUNT_STATE_INVALID);
					commonDAO.update(corsAccount);
				}
			}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    /**
     * 对即将过期的账号发送邮件  （距离过期之前15天之前判定为即将过期）
     * 发送规则：
     * 		1. 过期日期 <=15、 <=7 均发送一次邮件
     * 		2.一周内只能发送一次邮件（针对一个用户）
     * 判定过期标准：距离失效时间小于15天  (发送邮件、更新状态(即将过期))
     */
    public void sendEmailOfJustExpire(){
    	try{
    		String hql = " from CorsAccount a where a.isDelete is null";
        	List<CorsAccount> corsList = commonDAO.queryList(hql, null);
        	for (CorsAccount corsAccount : corsList) {
        		
				Date expireDate = corsAccount.getExprieDate();
				Date date7 = getSpecialDate(-7);  				//7天之前的日期
				Date date15 = getSpecialDate(-15);				//15天之前的日期
				
				if(expireDate != null && expireDate.before(date7) && expireDate.after(date15)){ //距离失效时间   <= 15天    > 7天
					//TODO 发送即将过期邮件		更改账号状态为即将过期
					corsAccount.setCorsAccountState(CorsAccountConsts.ACCOUNT_STATE_JUST_EXPIRE);
					commonDAO.update(corsAccount);
				}
				
				if(expireDate != null && expireDate.after(date15) && expireDate.before(date7)){ //距离失效时间   <= 15天    > 7天
					sendEmailToUser(corsAccount);
				}
			}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    /**
     * 检测该用户在最近7天内是否收到过邮件，收到则不发送,否则发送一封过期提醒邮件
     * 检测用户邮箱是否为null
     * 发送完成，插入发送记录
     * @param corsAccount
     * SELECT cors_account_id FROM cors_account where exprie_date = (
	select MAX(exprie_date) from cors_account
)
     */
    private void sendEmailToUser(CorsAccount corsAccount){
    	String hql = " from SendMailRecord a where a.company = :company and a.sendTime = "
    			+ "( select MAX(sendTime) from SendMailRecord b where b.company = :company )";
    	HashMap<String,Object> params = new HashMap<String,Object>();
    	params.put("company", corsAccount.getCompany());
    	SendMailRecord mailRecord = commonDAO.get(hql, params);
    	Date data7 = getSpecialDate(-7);
    	
    	if(mailRecord == null || (mailRecord != null && mailRecord.getSendTime().before(data7))){
    		User user = getRegisterEmail(corsAccount.getCompany());
    		if(user != null) {
    			String registEmail = user.getEmail();
    			if(StringUtil.isNotEmpty(registEmail)){
    				System.out.println("----过期账号id---: " + corsAccount.getCorsAccountId() + "  ;-----过期发送邮箱:" + registEmail);
    				try {
    					MailSender.sendHtmlMailOfFreemarker(new Mail(Mail.MAIL_SEND_HTML, registEmail, "corsAccountExpire.ftl", CorsAccountConsts.CORSACCOUNT_EXPIRE_REMIND_SUBJECT, null, null));
    					insertSendRecord(CorsAccountConsts.MAIL_SEND_SUCCESS,user);
    				}catch(Exception e){
    					insertSendRecord(CorsAccountConsts.MAIL_SEND_FAIL,user);
    				}
    			}
    		}
    	}
    }
    
    private void insertSendRecord(String rlt, User user){
    	SendMailRecord record = new SendMailRecord();
    	if(CorsAccountConsts.MAIL_SEND_SUCCESS.equals(rlt)){
    		record.setSendRlt(CorsAccountConsts.MAIL_SEND_SUCCESS);
    	} else {
    		record.setSendRlt(CorsAccountConsts.MAIL_SEND_FAIL);
    	}
    	record.setUser(user);
    	record.setReceiveMail(user.getEmail());
    	record.setCompany(user.getCompany());
    	commonDAO.save(record);
    }
    
    
    private static Date getSpecialDate(int period){
		Date nowDate = new Date();  
		Calendar resultDate = Calendar.getInstance();  
		resultDate.setTime(nowDate);
		resultDate.add(Calendar.DAY_OF_YEAR,period);
		return resultDate.getTime();
    }
    
    private User getRegisterEmail(Company company){
    	String hql = " from User a where a.company = :company";
    	HashMap<String,Object> params = new HashMap<String,Object>();
    	params.put("company", company);
    	User user = commonDAO.get(hql, params);
    	if(user != null){
    		return user;
    	}
    	
		return null;
    }
}