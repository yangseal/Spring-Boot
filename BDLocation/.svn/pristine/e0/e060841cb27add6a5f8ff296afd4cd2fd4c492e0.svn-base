package com.cnten.bdlocation.clients.clientInfo.service;

import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.bdlocation.constants.CorsAccountConsts;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.util.EncryptUtils;
import com.cnten.platform.util.StringUtil;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.Attachment;
import com.cnten.po.Company;
import com.cnten.po.CorsBusiApprove;
import com.cnten.po.User;

@Service
public class ClientBaseInfoService {
	private static final Logger log4j = LoggerFactory.getLogger(ClientBaseInfoService.class);
	@Autowired
	CommonDAO commonDAO;
	
	public Company getCompany(String companyId){
		return commonDAO.load(Company.class, companyId);
	}
	
	 public Company getCompany(){
		 Company company = commonDAO.get(Company.class, ContextUtil.getCurrentUser().getCompany().getCompanyId());
		 return company;
	 }
	
	 public User getUser(String userId){
		 return commonDAO.get(User.class, userId);
	 }
	 
	 public User getUser(){
		 User user = ContextUtil.getCurrentUser();
		 return user;
	 }
	 public void saveCompany(Company company,Company oldCompany){
		 if(StringUtil.isNotEmpty(company.getCompanyCode())) oldCompany.setCompanyCode(company.getCompanyCode());
		 if(StringUtil.isNotEmpty(company.getAddress())) oldCompany.setAddress(company.getAddress());
		 if(StringUtil.isNotEmpty(company.getPhone())){
			 oldCompany.setPhone(company.getPhone());
		 }
		 if(StringUtil.isNotEmpty(company.getContacts())) oldCompany.setContacts(company.getContacts());
		 if(StringUtil.isNotEmpty(company.getTel())) oldCompany.setTel(company.getTel());
		 if(StringUtil.isNotEmpty(company.getEmail())) oldCompany.setEmail(company.getEmail());
		 if(StringUtil.isNotEmpty(company.getCorporate())) oldCompany.setCorporate(company.getCorporate());
		 if(StringUtil.isNotEmpty(company.getBusinessLicense())) oldCompany.setBusinessLicense(company.getBusinessLicense());
		 oldCompany.setCompanyMaterialState(CorsAccountConsts.ACCOUNT_STATE_EXAMINE_SAVE);
		 commonDAO.update(oldCompany);
		 
	 }
	 
	 public void saveQuickUser(User user){
		 User oldUser = null;
		 if(user.getUserId() != null){
			 oldUser = commonDAO.load(User.class, user.getUserId());//ContextUtil.getCurrentUser();
		 }else{
			 oldUser = ContextUtil.getCurrentUser();
		 }
		 
		 if(oldUser.getPhone() != null && StringUtils.isNotBlank(user.getPhone())){
			 oldUser.setPhone(user.getPhone());
		 }
		 if(oldUser.getEmail() != null && StringUtils.isNotBlank(user.getEmail())){
			 oldUser.setEmail(user.getEmail());	 
		 }
		 commonDAO.update(oldUser);
	 }
	 
	 public Attachment getPicture(String entityId){ 
		 String hql = "from Attachment a where a.entityId = :entityId and a.isDelete is null";
		 HashMap<String, Object> params = new HashMap<String,Object>();
		 params.put("entityId", entityId);
		 Attachment attachment = commonDAO.get(hql, params);
		 return attachment;
	 }
	 
	 public SuccessOrFailure ifConfirm(){
		 User user = ContextUtil.getCurrentUser();
		 Company  company = user.getCompany();
		 if(CorsAccountConsts.ACCOUNT_STATE_EXAMINE_PASS.equals(company.getCompanyMaterialStateValue())){
			 return null;
		 }else if(CorsAccountConsts.ACCOUNT_STATE_EXAMINE_PROCEED.equals(company.getCompanyMaterialStateValue())){
			 return SuccessOrFailure.SUCCESS("审核中");
		 }else{
			 return SuccessOrFailure.SUCCESS;
		 }
	 }
	 
	 public SuccessOrFailure saveMaterialApply(Company company){
		 try{
			 User user = ContextUtil.getCurrentUser();
			 if(CorsAccountConsts.ACCOUNT_STATE_EXAMINE_PROCEED.equals(company.getCompanyMaterialStateValue()) || CorsAccountConsts.ACCOUNT_STATE_EXAMINE_PASS.equals(company.getCompanyMaterialStateValue()))
				 return SuccessOrFailure.FAILURE("资料申请已经提交,无需重复提交");
			 if(CorsAccountConsts.ACCOUNT_STATE_EXAMINE_NOTE.equals(company.getCompanyMaterialStateValue()))
				 return SuccessOrFailure.FAILURE("资料申请未保存,请保存后提交");
			 CorsBusiApprove busiApprove = new CorsBusiApprove();
			 busiApprove.setApproveState(CorsAccountConsts.ACCOUNT_STATE_EXAMINE_PROCEED);  //未处理
			 busiApprove.setOrderBussinkey(company.getCompanyId());
			 busiApprove.setBusiApproveType(CorsAccountConsts.BUSI_APPROVE_MATERIAL);  //公司资料审批
			 busiApprove.setBusiSubmitUser(user.getUserId());
			 busiApprove.setBusiSubmitTime(new Date());
			 commonDAO.save(busiApprove);
			 company.setCompanyMaterialState(CorsAccountConsts.ACCOUNT_STATE_EXAMINE_PROCEED);
			 commonDAO.update(company);
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		return SuccessOrFailure.SUCCESS("资料提交成功!");
	 }
	 public SuccessOrFailure ifPwd(String pwd){
		 try{
			 User user = ContextUtil.getCurrentUser();
			 String newPwd = EncryptUtils.encrypt(user.getUserCode()+pwd),
					newPwd2 = EncryptUtils.encrypt(pwd);
			 if(newPwd.equals(user.getPassword()) || newPwd2.equals(user.getPassword())){
				 return SuccessOrFailure.SUCCESS;
			 }else{
				 return SuccessOrFailure.FAILURE("密码与原密码不一致！");
			 }
		 }catch(Exception e){
			 log4j.info(e.getMessage());
		 }
		 return SuccessOrFailure.SUCCESS;
	 }
	 
	 public SuccessOrFailure updatePwd(String userId, String pwd){
		 User user = null;
		 if(userId != null && StringUtils.isNotEmpty(userId)){
			 user = commonDAO.load(User.class, userId);
		 }else{
			 user = ContextUtil.getCurrentUser();
		 }
		 String newPwd = EncryptUtils.encrypt(user.getUserCode()+pwd),
				newPwd2 = EncryptUtils.encrypt(pwd);
		 if(newPwd.equals(user.getPassword()) || newPwd2.equals(user.getPassword())){
			 return SuccessOrFailure.SUCCESS("密码与原密码一致,无须更改!");
		 }else{
			 user.setPassword(newPwd);
			 commonDAO.update(user);
			 return SuccessOrFailure.SUCCESS;
		 }
	 }
}
