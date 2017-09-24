package com.cnten.bdlocation.corsRepay.service;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.bdlocation.constants.CorsAccountConsts;
import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.CorsAccount;
import com.cnten.po.CorsAccountRepay;
import com.cnten.po.CorsRepayRel;

@Service
public class CorsAccountRepayService {
	
	@Autowired
	CommonDAO commonDAO;
	
	public Page getRepaysByPage(CorsAccountRepay accountRepay, Integer pageIndex, Integer pageSize){
		String hql = " from CorsAccountRepay a where 1=1 and a.accountRepayState = :accountRepayState";
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("accountRepayState", CorsAccountConsts.BUSI_APPROVE_STATE_PASS);
		if(accountRepay.getCompany() != null && StringUtils.isNotBlank(accountRepay.getCompany().getCompanyId())){
			hql += " and a.company.companyName like :companyName";
			params.put("companyName", "%" + accountRepay.getCompany().getCompanyName() + "%");
		}
		if(StringUtils.isNotBlank(accountRepay.getRepayActiveState())){
			hql += " and a.repayActiveState = :repayActiveState";
			params.put("repayActiveState", accountRepay.getRepayActiveState());
		}
		hql += " order by accountRepayTime desc";
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}
	
	/**
	 * 账号续费操作
	 * 		正式账号：
	 * 		    1.账号 正常(即将过期)		取当前时间  + 续费期限 = 失效时间、账号操作阶段
	 * 		    2.账号过期				生效时间、取当前时间 + 续费期限 = 失效时间、 账号状态、账号操作阶段
	 * 
	 * 		试用账号：
	 * 			1.账号 正常(即将过期)		取当前时间  + 续费期限 = 失效时间、账号操作阶段
	 * 			2.账号过期				生效时间、取当前时间 + 续费期限 = 失效时间、 账号状态、账号操作阶段
	 * @param corsActiveId
	 */
	public SuccessOrFailure updateRepayActive(String corsRepayId){
		try {
			CorsAccountRepay corsAccountRepay = commonDAO.get(CorsAccountRepay.class, corsRepayId);
			List<CorsRepayRel> busiRelList = corsAccountRepay.getCorsRepayList();
			for (CorsRepayRel listItem : busiRelList) {
				CorsAccount corsAccount = listItem.getCorsAccount();
				String corsAccountState = corsAccount.getCorsAccountState();
				Date nowDate = new Date();  
				Calendar resultDate = Calendar.getInstance();  
				if(CorsAccountConsts.ACCOUNT_STATE_INVALID.equals(corsAccountState)) { //已过期
					resultDate.setTime(nowDate);
					resultDate.add(Calendar.YEAR,listItem.getCorsRepayPeriod());
					corsAccount.setEffectiveDate(nowDate);
					corsAccount.setExprieDate(resultDate.getTime());
					corsAccount.setCorsAccountState(CorsAccountConsts.ACCOUNT_STATE_NORMAL);
				} else { //正常、未过期
					resultDate.setTime(corsAccount.getExprieDate());
					resultDate.add(Calendar.YEAR, listItem.getCorsRepayPeriod());
					corsAccount.setExprieDate(resultDate.getTime());
					corsAccount.setCorsAccountStage(CorsAccountConsts.BUSI_APPROVE_STATE_PASS);
				}
				if(!CorsAccountConsts.ACCOUNT_STAGE_REPAY_DEALED.equals(corsAccount.getCorsAccountStage())){  //只有续费未完成的，才需要进行续费操作
					corsAccount.setCorsAccountStage(CorsAccountConsts.ACCOUNT_STAGE_REPAY_DEALED);
					corsAccount.setCorsAccountType(CorsAccountConsts.ACCOUNT_TYPE_NORMAL);
					commonDAO.update(corsAccount);
					corsAccountRepay.setRepayActiveState(CorsAccountConsts.ACCOUNT_ACTIVE_DEAL_STATE_1);
					commonDAO.update(corsAccountRepay);
				}
			}
			return SuccessOrFailure.SUCCESS("续费操作成功!");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
