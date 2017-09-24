package com.cnten.bdlocation.corsInit.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.bdlocation.constants.CorsAccountConsts;
import com.cnten.po.CorsAccount;
import com.cnten.po.CorsApply;
import com.cnten.po.CorsApplyDetail;

@Service
public class CorsInitService {
	@Autowired
	CommonDAO commonDAO;
	
	
	public Page getPageApply(CorsApply corsApply,Integer pageIndex,	Integer pageSize){
		
		String hql="from CorsApply a where a.applyStatus = "+CorsAccountConsts.BUSI_APPROVE_STATE_PASS+"";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(corsApply.getCompany() != null){
			if(StringUtils.isNotBlank(corsApply.getCompany().getCompanyName())){
				hql += " and a.company.companyName like :companyName";
				params.put("companyName", "%"+corsApply.getCompany().getCompanyName()+"%");
			}
		}
		if(StringUtils.isNotBlank(corsApply.getAccountCreateState())){
			hql += " and a.accountCreateState like :accountCreateState";
			params.put("accountCreateState", "%"+corsApply.getAccountCreateState()+"%");
		}
		hql += " order by a.applyDate desc";
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}
	public CorsApply getCorsInit(String initId){
		CorsApply corsApply = commonDAO.get(CorsApply.class, initId);
		return corsApply;
	}
	public void updateAccount(String bussinessId){
		CorsApply corsApply = getCorsInit(bussinessId);
		String accountPrefix = "";
		if(CorsAccountConsts.ACCOUNT_TYPE_NORMAL.equals(corsApply.getAccountType())){
			accountPrefix = corsApply.getCompany().getCompanyCode();
		} else {
			accountPrefix = corsApply.getCompany().getCompanyCode()+"_"+"T";
		}
		String sql = "SELECT IFNULL(max(cors_account_order),0)as maxOrder FROM cors_account a where a.company_id = :companyId and a.cors_account_type = :corsAccountType";
		HashMap<String,Object> _params = new HashMap<String,Object>();
		_params.put("companyId",corsApply.getCompany().getCompanyId());
		_params.put("corsAccountType", corsApply.getAccountType());
		Map<String,Object> orderMap = commonDAO.sqlGet(sql, _params);
		int nextOrder = ((BigInteger)orderMap.get("maxOrder")).intValue()+1;
		if(nextOrder == 1 && CorsAccountConsts.ACCOUNT_TYPE_NORMAL.equals(corsApply.getAccountType())){
			//生成前20个账号
			nextOrder = initAccount(accountPrefix,corsApply,nextOrder);
		}
		for (CorsApplyDetail applyDetail : corsApply.getApplyDetailList()) {
			for(int i = 0 ; i< applyDetail.getApplyCount();i++){
				CorsAccount account = new CorsAccount();
				account.setCorsAccountCode(accountPrefix+String.format("%04d", nextOrder+i));
				account.setCorsAccountPwd((int)((Math.random()*9+1)*100000)+"");
				account.setBdDeviceAccuracy(applyDetail.getBdDeviceAccuracy());
				account.setCorsAccountType(applyDetail.getAccountType());
				account.setCorsApply(corsApply);
				account.setCorsAccountPeriod(applyDetail.getAccountUsePeriod());
				account.setCompany(corsApply.getCompany());
				account.setCorsAccountState(CorsAccountConsts.ACCOUNT_STATE_UNACTIVE);
				account.setCorsAccountStage(CorsAccountConsts.ACCOUNT_STAGE_UNACTIVE);
				account.setCorsFeature(CorsAccountConsts.CORS_FEATURE_REALCORS);
				Date nowDate = new Date();  
				account.setCorsCreateDate(nowDate);
				account.setCorsAccountOrder(nextOrder+i);
				commonDAO.save(account);
			}
			nextOrder+=applyDetail.getApplyCount();
		}
		String updateSql = "update cors_apply a set a.account_create_state = :account_create_state where a.cors_apply_id = :cors_apply_id";
		HashMap<String, Object> params = new HashMap<String,Object>();
		params.put("account_create_state", CorsAccountConsts.APPLY_ACCOUNT_CREATE_STATE_1);
		params.put("cors_apply_id", bussinessId);
		commonDAO.updateBySQLQuery(updateSql, params);
	}
	//生成前5个非真实cors账号
	public Integer initAccount(String accountPrefix,CorsApply corsApply,int nextOrder){
		if(nextOrder  == 1){
			for(int i = 0 ; i< CorsAccountConsts.ACCOUNT_UNREAL_NUM;i++){
				CorsAccount account = new CorsAccount();
				account.setCorsAccountCode(accountPrefix+String.format("%04d", nextOrder+i));
				account.setCorsAccountPwd(accountPrefix+CorsAccountConsts.CORS_DEFAULT_PWD);
				account.setCorsApply(corsApply);
				account.setCompany(corsApply.getCompany());
				account.setCorsFeature(CorsAccountConsts.CORS_FEATURE_CORSADMIN);
				Date nowDate = new Date();  
				account.setCorsCreateDate(nowDate);
				account.setCorsAccountOrder(nextOrder+i);
				commonDAO.save(account);
			}
		}
		return nextOrder+CorsAccountConsts.ACCOUNT_UNREAL_NUM;
	}
	
	
	public List<CorsAccount> getCorsAccounts(String bussinessId){
		String hql = "from CorsAccount a  where a.corsApply.corsApplyId = :corsApplyId and a.corsFeature = :corsFeature";
		HashMap<String, Object> params = new HashMap<String , Object>();
		params.put("corsApplyId", bussinessId);
		params.put("corsFeature", CorsAccountConsts.CORS_FEATURE_REALCORS);
		return commonDAO.queryList(hql, params);
	}
	public List<CorsApply> getCorsApplys(String corsApplyId){
		String[] corsApplyIds = corsApplyId.split(",");
		String sql = "from CorsApply a where a.corsApplyId in(:corsApplyIds)";
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("corsApplyIds", corsApplyIds);
		List<CorsApply> applyList = commonDAO.queryList(sql, params);
		for (CorsApply corsApply : applyList) {
			String hql = " from CorsAccount a where a.corsApply = :corsApply and a.corsFeature = :corsFeature";
			params.put("corsApply", corsApply);
			params.put("corsFeature", "2");   // 代表真实cors账号，在server端存在对应关系
			List<CorsAccount> accountList = commonDAO.queryList(hql, params);
			corsApply.setCorsList(accountList);
		}
		
		return commonDAO.queryList(sql, params);
	}
}
