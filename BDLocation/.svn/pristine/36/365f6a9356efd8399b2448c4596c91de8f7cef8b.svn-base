package com.cnten.bdlocation.busiapprove.service;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.bdlocation.constants.CorsAccountConsts;
import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.mail.Mail;
import com.cnten.platform.mail.MailSender;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.util.StringUtil;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.Company;
import com.cnten.po.CompanyOrg;
import com.cnten.po.CorsAccount;
import com.cnten.po.CorsAccountRepay;
import com.cnten.po.CorsApply;
import com.cnten.po.CorsBusiApprove;
import com.cnten.po.CorsRepayRel;
import com.cnten.po.Role;
import com.cnten.po.User;
import com.cnten.vo.BusiApproveVO;

@Service
public class BusinApproveService {
	@Autowired
	CommonDAO commonDAO;
	
	private static final String BUSIN_APPROVE_SQL = " select d.orderBussinkey,d.companyId,d.busiApproveTime,d.applyCount,d.accountType,d.accountUsePeriod,d.busiApproveType, "+
			" d.applyStatus,d.busiSubmitTime,d.bdDeviceAccuracy,d.busiApproveOpinion,d.applyComment,d.approveState,case d.applyMaterialState when 'WWS' then '未完善' when 'YWS' then '已完善' end as applyMaterialState,e.company_name as companyName,e.contacts, "+
			" case d.applyStatus when '4' then '已提交' when '5' then '已完成' when '6' then '已取消' else '未提交' end as applyStatusName, "+
			" case d.accountType when 'test' then '试用' else '正式' end as accountTypeName, "+
			" case d.bdDeviceAccuracy when 'centimeter' then '厘米级' when 'meter' then '亚米级' else '米级' end as bdDeviceAccuracyName, "+
			" orderNo,orderType,orderTypeName,applyDate,finshDate "+
			" from	(SELECT "+
			" a.order_bussinkey AS orderBussinkey, "+
			" a.company_id AS companyId, a.busi_submit_time as busiSubmitTime,"+
			" c.account_repay_num AS applyCount,a.busi_approve_time as busiApproveTime, "+
			" c.account_repay_type AS accountType, "+
			" c.account_repay_period AS accountUsePeriod, "+
			" a.busi_approve_type AS busiApproveType, "+
			" c.account_repay_state AS applyStatus, "+
			" c.account_accuracy AS bdDeviceAccuracy, "+
			" a.busi_approve_opinion AS busiApproveOpinion, "+
			" NULL AS applyComment, "+
			" a.approve_state AS approveState,c.order_no AS orderNo,c.order_type as orderType, "+
			" case c.order_type when 'rorder' then '续费订单' end as orderTypeName, "+
			" c.account_repay_time AS applyDate, "+
			" c.apply_material_state as applyMaterialState, " +
			" c.repay_finsh_date as finshDate " +
			" FROM "+
			" cors_busi_approve a ,cors_account_repay c  "+
			" where a.order_bussinkey = c.account_repay_id "+
			" union all "+
			" SELECT "+
			" a.order_bussinkey AS orderBussinkey, "+
			" a.company_id AS companyId,a.busi_submit_time as busiSubmitTime, "+
			" c.apply_count AS applyCount,a.busi_approve_time as busiApproveTime, "+
			" c.account_type AS accountType, "+
			" c.account_use_period AS accountUsePeriod, "+
			" a.busi_approve_type AS busiApproveType, "+
			" c.apply_status AS applyStatus, "+
			" c.bd_device_accuracy AS bdDeviceAccuracy, "+
			" a.busi_approve_opinion AS busiApproveOpinion, "+
			" c.apply_comment AS applyComment, "+
			" a.approve_state AS approveState,c.order_no AS orderNo, c.order_type as orderType,"+
			" case c.order_type when 'torder' then '试用订单' when 'forder' then '购买订单' end AS orderTypeName, "+
			" c.apply_date AS applyDate, "+
			" c.apply_material_state as applyMaterialState, " +
			" c.finsh_date as finshDate " +
			" FROM "+
			" cors_busi_approve a,cors_apply c  "+
			" where a.order_bussinkey = c.cors_apply_id "+
			" )	d "+
			" left join company e on d.companyId = e.company_id";
	
	
	private static final String COMPANY_MATERIAL_APPROVE_SQL = 
			" select c.busiApproveId,c.busiApproveType,c.orderBussinkey,c.busiSubmitTime, "+
			" c.busiApproveRlt,c.busiApproveOpinion,c.approveState,c.companyId,c.address,c.companyName,c.password,c.phone,c.contacts, "+
			" c.companyCode,c.post,c.tel,c.email,c.createDate,c.businessLicense,c.companyMaterialState,c.companyMaterialStateName "+
			" from (" + 
			"select " +
			" a.busi_approve_id AS busiApproveId, "+
			" a.busi_approve_type AS busiApproveType, "+
			" a.order_bussinkey AS orderBussinkey, "+
			" a.busi_submit_time AS busiSubmitTime, "+
			" a.busi_approve_rlt AS busiApproveRlt, "+
			" a.busi_approve_opinion AS busiApproveOpinion, "+
			" a.approve_state AS approveState, "+
			" b.company_id AS companyId, "+
			" b.address AS address, "+
			" b.company_name AS companyName, "+
			" b.password AS password, "+
			" b.phone AS phone, "+
			" b.contacts AS contacts, "+
			" b.company_code AS companyCode, "+
			" b.post AS post, "+
			" b.tel AS tel, "+
			" b.email AS email,b.create_date as createDate, "+
			" b.business_license AS businessLicense, "+
			" b.company_material_state AS companyMaterialState, "+
			" case b.company_material_state when '1' then '审核中' when '2' then '已通过' when '3' then '已拒绝' end as companyMaterialStateName "+
			" FROM "+
			" cors_busi_approve a "+
			" LEFT JOIN company b ON a.order_bussinkey = b.company_id "+
			" WHERE "+
			" b.is_delete is null and  "+
			" a.busi_approve_type = '" + CorsAccountConsts.BUSI_APPROVE_MATERIAL + "') c";
	
	public Page getApprovesPage(BusiApproveVO busiApproveVO,Integer pageIndex,
			Integer pageSize) {
		String sql = BUSIN_APPROVE_SQL + " where 1=1 ";
		HashMap<String, Object> params = new HashMap<String,Object>();
		if(busiApproveVO.getCompanyName() != null && StringUtils.isNotBlank(busiApproveVO.getCompanyName())){
			sql += " and company_name like :companyName";
			params.put("companyName", "%" + busiApproveVO.getCompanyName() + "%");
		}
		if(ContextUtil.customerCompanyId() != null) {
			sql += " and companyId = :companyId";
			params.put("companyId", ContextUtil.customerCompanyId());
		}
		if(busiApproveVO != null && StringUtils.isNotEmpty(busiApproveVO.getCompanyId())){
			sql += " and companyId = :companyId";
			params.put("companyId", busiApproveVO.getCompanyId());
		}
			
		if(StringUtils.isNotEmpty(busiApproveVO.getApplyStatus())) {
			sql += " and applyStatus = :applyStatus";
			params.put("applyStatus", busiApproveVO.getApplyStatus());
		}
		if(StringUtils.isNotEmpty(busiApproveVO.getAccountType())) {
			sql += " and accountType = :accountType";
			params.put("accountType", busiApproveVO.getAccountType());
		}
		if(StringUtils.isNotEmpty(busiApproveVO.getBdDeviceAccuracy())) {
			sql += " and bdDeviceAccuracy = :bdDeviceAccuracy";
			params.put("bdDeviceAccuracy", busiApproveVO.getBdDeviceAccuracy());
		}
		if(StringUtils.isNotEmpty(busiApproveVO.getApplyMaterialOrderType())){
			sql += " and  orderType != :materialOrderType";
			params.put("materialOrderType", busiApproveVO.getApplyMaterialOrderType());
		}
		if (StringUtils.isNotEmpty(busiApproveVO.getOrderNo())) {
			sql += " and orderNo like :orderNo";
			params.put("orderNo", "%" + busiApproveVO.getOrderNo()+"%");
		}
		if (StringUtils.isNotEmpty(busiApproveVO.getOrderType())) {
			sql += " and orderType = :orderType";
			params.put("orderType", busiApproveVO.getOrderType());
		}
		if(StringUtils.isNotEmpty(busiApproveVO.getCompanyMaterialState())){
			sql += " and applyMaterialState = :applyMaterialState";
			params.put("applyMaterialState", busiApproveVO.getCompanyMaterialState());
		}
		params.put("nowDate", StringUtil.formatDate(new Date()));
		sql += " order by busiSubmitTime desc";
		return commonDAO.sqlGetPage(sql, pageIndex, pageSize, params);
	}

	public Map<String, Object> getApprove(String approveId) {
		String sql = BUSIN_APPROVE_SQL + " where orderBussinkey = :approveId";
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("approveId", approveId);
		params.put("nowDate", StringUtil.formatDate(new Date()));
		Map<String,Object> busiMap = commonDAO.sqlGet(sql, params);
		return busiMap;
	}
	
	public CorsBusiApprove getCorsBusiApprove(String corsApplyId) {
		String hql = "from CorsBusiApprove a where a.orderBussinkey = :orderBussinkey";
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("orderBussinkey", corsApplyId);
		return commonDAO.get(hql, params);
	}

	/**
	 * @param orderBussinkey 指 续费申请Id
	 * @return
	 */
	public List<CorsRepayRel> getAccount(String orderBussinkey) {
		String hql = " from CorsRepayRel a where a.orderBussinkey = :orderBussinkey";
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("orderBussinkey", orderBussinkey);
		
		List<CorsRepayRel> account = commonDAO.queryList(hql, params);
		return account;
	}
	
	private SuccessOrFailure validateIsDeal(String approveState){
		if(approveState != null && 
				StringUtils.isNotBlank(approveState) &&
				CorsAccountConsts.ACCOUNT_APPROVE_DEAL.equals(approveState)){
			return SuccessOrFailure.SUCCESS("该任务已经审批过了!");
		}
		return null;
	}
	
	//审批通过(发邮件)
	public SuccessOrFailure updatePassAccount(BusiApproveVO busiApproveVO) {
		String hql = "from CorsBusiApprove a where a.orderBussinkey = :orderBussinkey";
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("orderBussinkey",busiApproveVO.getOrderBussinkey());
		CorsBusiApprove corsBusiApprove = commonDAO.get(hql, params);
		
		if(validateIsDeal(corsBusiApprove.getApproveState()) != null){
			return SuccessOrFailure.SUCCESS("该任务已经审批过了!");
		}
		
		corsBusiApprove.setApproveState(CorsAccountConsts.ACCOUNT_APPROVE_DEAL);
		corsBusiApprove.setBusiApproveRlt(CorsAccountConsts.APPROVE_RESULT_YES);
		corsBusiApprove.setBusiApproveUser(ContextUtil.getCurrentUser().getUserId());
		corsBusiApprove.setBusiApproveTime(new Date());
		commonDAO.update(corsBusiApprove);
		
		if(CorsAccountConsts.BUSI_APPROVE_ADD_APPLY.equals(busiApproveVO.getBusiApproveType())){  // 开通申请
			CorsApply corsApply = commonDAO.load(CorsApply.class, busiApproveVO.getOrderBussinkey());
			corsApply.setApplyStatus(CorsAccountConsts.BUSI_APPROVE_STATE_PASS);
			corsApply.setFinshDate(new Date());
			corsApply.setAccountCreateState(CorsAccountConsts.APPLY_ACCOUNT_CREATE_STATE_0);
			commonDAO.update(corsApply);

		}else { //续费申请
			CorsAccountRepay accountRepay = commonDAO.load(CorsAccountRepay.class,busiApproveVO.getOrderBussinkey());
			accountRepay.setAccountRepayState(CorsAccountConsts.BUSI_APPROVE_STATE_PASS);
			accountRepay.setRepayFinshDate(new Date());
			commonDAO.update(accountRepay);
			
		}
		
		//通过审批后，发送邮件通知客户
		Company company = corsBusiApprove.getCompany();
		User user = getCompanyRegisterUser(company.getCompanyId());
		HashMap<String,Object> busOrder = (HashMap<String, Object>) getApprove(busiApproveVO.getOrderBussinkey());
		if( user != null && StringUtil.isNotEmpty(user.getEmail())){
			HashMap<String,Object> data = new HashMap<String,Object>();
			data.put("approveRlt",CorsAccountConsts.APPROVE_RESULT_YES);
			data.put("orderType", busOrder.get("orderType"));
			data.put("orderApplyTime", busOrder.get("applyDate"));
			data.put("orderNo", busOrder.get("orderNo"));
			MailSender.sendHtmlMailOfFreemarker(
					new Mail(Mail.MAIL_SEND_HTML, user.getEmail(), "corsOrderApprove.ftl", CorsAccountConsts.CORSACCOUNT_ORDER_APPROVE_SUBJECT,null,data));
		}
		
		return SuccessOrFailure.SUCCESS("审批成功!");
	}
	
	
	public SuccessOrFailure updateRejectAccount(BusiApproveVO busiApproveVO) {

		String hql = "from CorsBusiApprove a where a.orderBussinkey = :orderBussinkey";
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("orderBussinkey",busiApproveVO.getOrderBussinkey());
		CorsBusiApprove corsBusiApprove = commonDAO.get(hql, params);
		if(validateIsDeal(corsBusiApprove.getApproveState()) != null){
			return SuccessOrFailure.SUCCESS("该任务已经审批过了!");
		}
		corsBusiApprove.setApproveState(CorsAccountConsts.ACCOUNT_APPROVE_DEAL);
		corsBusiApprove.setBusiApproveOpinion(busiApproveVO.getBusiApproveOpinion());
		corsBusiApprove.setBusiApproveRlt(CorsAccountConsts.APPROVE_RESULT_NO);
		corsBusiApprove.setBusiApproveUser(ContextUtil.getCurrentUser().getUserId());
		corsBusiApprove.setBusiApproveTime(new Date());
		commonDAO.update(corsBusiApprove);
		
		if(CorsAccountConsts.BUSI_APPROVE_ADD_APPLY.equals(busiApproveVO.getBusiApproveType())){
			CorsApply corsApply = commonDAO.load(CorsApply.class,busiApproveVO.getOrderBussinkey());
			corsApply.setApplyStatus(CorsAccountConsts.BUSI_APPROVE_STATE_REJECT);
			corsApply.setFinshDate(new Date());
			commonDAO.update(corsApply);

		} else {
			 CorsAccountRepay corsRepay = commonDAO.load(CorsAccountRepay.class, busiApproveVO.getOrderBussinkey());
			 corsRepay.setRepayFinshDate(new Date());
			 corsRepay.setAccountRepayState(CorsAccountConsts.BUSI_APPROVE_STATE_REJECT);
			 commonDAO.update(corsRepay);
			 
			List<CorsRepayRel> repayRelList = corsRepay.getCorsRepayList();
			for (CorsRepayRel corsRepayRel : repayRelList) {
				CorsAccount account = corsRepayRel.getCorsAccount();
				account.setCorsAccountStage(CorsAccountConsts.ACCOUNT_STAGE_ACTIVED);
				commonDAO.update(account);
			}
		}
		
		//通过审批后，发送邮件通知客户
		Company company = corsBusiApprove.getCompany();
		User user = getCompanyRegisterUser(company.getCompanyId());
		HashMap<String,Object> busOrder = (HashMap<String, Object>) getApprove(busiApproveVO.getOrderBussinkey());
		
		if(user !=null && StringUtil.isNotEmpty(user.getEmail())){
			HashMap<String,Object> data = new HashMap<String,Object>();
			data.put("approveRlt",CorsAccountConsts.APPROVE_RESULT_NO);
			data.put("orderType", busOrder.get("orderType"));
			data.put("orderApplyTime", busOrder.get("applyDate"));
			data.put("orderNo", busOrder.get("orderNo"));
			data.put("approveOpinion",busiApproveVO.getBusiApproveOpinion());
			MailSender.sendHtmlMailOfFreemarker(
					new Mail(Mail.MAIL_SEND_HTML, user.getEmail(), "corsOrderApprove.ftl", CorsAccountConsts.CORSACCOUNT_ORDER_APPROVE_SUBJECT,null,data));
		}
		
		return SuccessOrFailure.SUCCESS("审批成功!");
	}
	
	public Page getCompanyDataExaminePage(BusiApproveVO busiApproveVO, Integer pageIndex, Integer pageSize) {
		String sql = COMPANY_MATERIAL_APPROVE_SQL + " where 1=1 ";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(busiApproveVO.getCompanyName() != null && StringUtils.isNotBlank(busiApproveVO.getCompanyName())){
			sql += " and companyName like :companyName";
			params.put("companyName", "%"+busiApproveVO.getCompanyName()+"%");
		}
		if(busiApproveVO.getCompanyMaterialState() != null && StringUtils.isNotBlank(busiApproveVO.getCompanyMaterialState())){
			sql += " and companyMaterialState = :companyMaterialState";
			params.put("companyMaterialState",busiApproveVO.getCompanyMaterialState());
		}
		if(busiApproveVO.getApproveState() != null && StringUtils.isNotBlank(busiApproveVO.getApproveState())){
			sql += " and approveState = :approveState";
			params.put("approveState",busiApproveVO.getApproveState());
		}
		
		sql += " order by busiSubmitTime desc";
		return commonDAO.sqlGetPage(sql, pageIndex, pageSize, params);
	}
	
	public Map<String,Object> getBusicompayExamine(String busiApproveId) {
		String sql = COMPANY_MATERIAL_APPROVE_SQL + " where busiApproveId = :busiApproveId";
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("busiApproveId", busiApproveId);
		return commonDAO.sqlGet(sql, params);
	}
	/*
	 * 企业资料审批通过
	 * 
	 */
	public void saveApproveQueryExamine(BusiApproveVO busiApproveVO) {	
		try{
			String conpanyId = busiApproveVO.getOrderBussinkey();
			Date busiTime = new Date();
			Company company = commonDAO.load(Company.class, conpanyId);
			company.setCompanyMaterialState(CorsAccountConsts.ACCOUNT_STATE_EXAMINE_PASS); 
			commonDAO.update(company);
			CorsBusiApprove corsBusiApprove = commonDAO.load(CorsBusiApprove.class, busiApproveVO.getBusiApproveId());
			corsBusiApprove.setBusiApproveTime(busiTime);
			corsBusiApprove.setBusiApproveOpinion(busiApproveVO.getBusiApproveOpinion());
			corsBusiApprove.setBusiApproveUser(ContextUtil.getCurrentUser().getUserId());
			corsBusiApprove.setApproveState(CorsAccountConsts.ACCOUNT_STATE_EXAMINE_PASS);
			corsBusiApprove.setBusiApproveRlt(CorsAccountConsts.APPROVE_RESULT_YES);
			commonDAO.update(corsBusiApprove);
			
			User user = getCompanyRegisterUser(company.getCompanyId());
			//审批通过，发送邮件
			if(user != null && StringUtil.isNotEmpty(user.getEmail())){
				HashMap<String,Object> data = new HashMap<String,Object>();
				data.put("companyName",company.getCompanyName());
				data.put("approveRlt",CorsAccountConsts.APPROVE_RESULT_YES);
				MailSender.sendHtmlMailOfFreemarker(
						new Mail(Mail.MAIL_SEND_HTML, user.getEmail(), "companyCertifPass.ftl", CorsAccountConsts.COMPANY_MATERIAL_APPROVE_SUBJECT,null,data));
			}
			createDefaultTwoRoleForRegister(company);
			//创建该企业的组织结构根节点
			createCompanyOrgRootNode(company);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	private void createDefaultTwoRoleForRegister(Company company){
		String adminRoleCode = company.getCompanyCode()+"admin";
		String busiRoleCode = company.getCompanyCode()+"busi";
		String hql = " from Role a where a.isDelete is null and ( a.roleCode = ? or a.roleCode = ?)";
		Long countNum = commonDAO.getCountByVariableParam(hql, adminRoleCode, busiRoleCode);
		if(countNum == 0){
			Role adminRole = new Role();
			adminRole.setRoleName("管理员 ("+company.getCompanyCode()+")");
			adminRole.setRoleCode(adminRoleCode);
			adminRole.setCompany(company);
			Role busiRole = new Role();
			busiRole.setRoleName("业务员 ("+company.getCompanyCode()+")");
			busiRole.setRoleCode(busiRoleCode);
			busiRole.setCompany(company);
			commonDAO.save(adminRole);
			commonDAO.save(busiRole);
		}
	}
	
	private void createCompanyOrgRootNode(Company company){
		String hql = " from CompanyOrg a where a.isDelete is null and a.company = ?";
		CompanyOrg oCompanyOrg = commonDAO.getByVariableParam(hql, company);
		if(oCompanyOrg == null){
			//添加组织 root 节点
			CompanyOrg companyOrg = new CompanyOrg();
			companyOrg.setOrgLevel(1);
			companyOrg.setOrgName(company.getCompanyName());
			companyOrg.setCompany(company);
			commonDAO.save(companyOrg);
		}
	}

	/*
	 * 企业资料审批拒绝
	 * 
	 **/ 
	public void saveRejectExamine(BusiApproveVO busiApproveVO) {	
		
		String conpanyId = busiApproveVO.getOrderBussinkey();
		Company company = commonDAO.load(Company.class, conpanyId);
		company.setCompanyMaterialState(CorsAccountConsts.ACCOUNT_STATE_EXAMINE_REFUSE);
		commonDAO.update(company);
		CorsBusiApprove corsBusiApprove = commonDAO.load(CorsBusiApprove.class, busiApproveVO.getBusiApproveId());
		corsBusiApprove.setBusiApproveTime(new Date());
		corsBusiApprove.setBusiApproveOpinion(busiApproveVO.getBusiApproveOpinion());
		corsBusiApprove.setBusiApproveUser(ContextUtil.getCurrentUser().getUserId());
		corsBusiApprove.setBusiApproveRlt(CorsAccountConsts.APPROVE_RESULT_NO);
		corsBusiApprove.setApproveState(CorsAccountConsts.ACCOUNT_STATE_EXAMINE_REFUSE);
		commonDAO.update(corsBusiApprove);
		
		User user = getCompanyRegisterUser(company.getCompanyId());
		//审批驳回，发送邮件
		if(user != null && StringUtil.isNotEmpty(user.getEmail())){
			HashMap<String,Object> data = new HashMap<String,Object>();
			data.put("companyName",company.getCompanyName());
			data.put("approveRlt",CorsAccountConsts.APPROVE_RESULT_NO);
			data.put("approveOpinion",busiApproveVO.getBusiApproveOpinion());
			MailSender.sendHtmlMailOfFreemarker(
					new Mail(Mail.MAIL_SEND_HTML, user.getEmail(), "companyCertifPass.ftl", CorsAccountConsts.COMPANY_MATERIAL_APPROVE_SUBJECT,null,data));
		}
		
	}
	/**
	 * 获取企业注册人邮箱
	 * @param companyId
	 * @return
	 */
	private User getCompanyRegisterUser(String companyId){
		String hql = "from User  where isDelete is null and company.companyId = :companyId";
		HashMap<String, Object> params = new HashMap<String,Object>();
		params.put("companyId", companyId);
		User user = commonDAO.get(hql, params);
		if(user != null) return user;		
		return null;
	}

}
