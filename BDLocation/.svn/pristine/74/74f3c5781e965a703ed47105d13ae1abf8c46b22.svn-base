package com.cnten.bdlocation.clients.formalService.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.StringUtils;

import com.cnten.bdlocation.constants.CorsAccountConsts;
import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.util.OrderNoCreateUtil;
import com.cnten.platform.util.StringUtil;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.Company;
import com.cnten.po.CorsAccount;
import com.cnten.po.CorsAccountRepay;
import com.cnten.po.CorsApply;
import com.cnten.po.CorsApplyDetail;
import com.cnten.po.CorsApplyTemp;
import com.cnten.po.CorsBusiApprove;
import com.cnten.po.CorsRepayRel;
import com.cnten.po.CorsRepayTemp;
import com.cnten.po.User;

@Service
public class FormalService {
	@Autowired
	CommonDAO commonDAO;
	
	/**
	 * 更新  加入购入车的临时账号数量
	 * @throws Exception
	 */
	public void updateCorsApplyTemp(CorsApplyTemp corsApplyTemp) throws Exception{
		if(corsApplyTemp.getApplyCount()>0){  //大于零的时候更新数量
			CorsApplyTemp _corsApplayTemp = commonDAO.get(CorsApplyTemp.class, corsApplyTemp.getCorsApplyTempId());
			_corsApplayTemp.setApplyCount(corsApplyTemp.getApplyCount());
			commonDAO.save(_corsApplayTemp);
		}
	}

	public void saveCorsApply(CorsApplyTemp corsApplyTemp) throws Exception {
		String hql = " from CorsApplyTemp a where a.bdDeviceAccuracy = :bdDeviceAccuracy "
				+ " and a.accountUsePeriod = :accountUsePeriod"
				+ " and a.company= :company";
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("bdDeviceAccuracy", corsApplyTemp.getBdDeviceAccuracy());
		params.put("accountUsePeriod", corsApplyTemp.getAccountUsePeriod());
		
		if (ContextUtil.getCurrentUser() != null && ContextUtil.getCurrentUser().getCompany() != null) {
			params.put("company", ContextUtil.getCurrentUser().getCompany());
		} else {
			params.put("company", corsApplyTemp.getCompany());
		}
		
		CorsApplyTemp temp = commonDAO.get(hql, params);
		if (temp != null) {
			temp.setApplyCount(temp.getApplyCount()
					+ corsApplyTemp.getApplyCount());
			commonDAO.save(temp);
		} else {
			commonDAO.save(corsApplyTemp);
		}
	}

	public List<CorsApply> getCorsApplys(String companyId) {
		String hql = "from CorsApplyTemp a  where a.company.companyId = :companyId and a.isDelete is NULL";
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("companyId", companyId);
		return commonDAO.queryList(hql, params);
	}

	public void saveConfirmList(String corsApplyTempParams) {
		try {
			Company company = null;
			User user = null;
			String[] corsApplyTempParamsArray = corsApplyTempParams.split(",");
			List<CorsApplyDetail> corsDetialList = new ArrayList<CorsApplyDetail>();
			for (String corsApplyTemp : corsApplyTempParamsArray) {
				String[] corsApplyTempArray = corsApplyTemp.split("&");
				CorsApplyTemp applyTemp = commonDAO.get(CorsApplyTemp.class,
						corsApplyTempArray[0]);
				if (company == null) {
					company = applyTemp.getCompany();
					user = applyTemp.getUser();
				}
				CorsApplyDetail corsApplyDetail = new CorsApplyDetail();
				corsApplyDetail
						.setAccountType(CorsAccountConsts.ACCOUNT_TYPE_NORMAL);
				corsApplyDetail
						.setAccountUsePeriod(applyTemp.getAccountUsePeriod());
				corsApplyDetail.setBdDeviceAccuracy(corsApplyTempArray[2]);
				corsApplyDetail.setApplyCount(Integer
						.parseInt(corsApplyTempArray[1]));
				commonDAO.save(corsApplyDetail);
				commonDAO.delete(CorsApplyTemp.class, corsApplyTempArray[0]);
				corsDetialList.add(corsApplyDetail);
			}

			CorsApply apply = new CorsApply();
			apply.setOrderNo(OrderNoCreateUtil.getCorsApplyOrderNo());
			apply.setCompany(company);
			apply.setUser(user);
			apply.setApplyMaterialState(CorsAccountConsts.APPLY_MATERIAL_STATE_WWS);
			apply.setApplyStatus(CorsAccountConsts.BUSI_APPROVE_STATE_SUBMIT);
			apply.setAccountType(CorsAccountConsts.ACCOUNT_TYPE_NORMAL);
			apply.setAccountCreateState(CorsAccountConsts.APPLY_ACCOUNT_CREATE_STATE_0);
			apply.setOrderType(CorsAccountConsts.CORS_ORDER_TYPE_BUY);
			apply.setApplyDetailList(corsDetialList);
			commonDAO.save(apply);

			CorsBusiApprove approve = new CorsBusiApprove();
			approve.setOrderBussinkey(apply.getCorsApplyId());
			approve.setBusiSubmitTime(new Date());
			approve.setCompany(company);
			approve.setBusiSubmitUser(user.getUserId());
			approve.setApproveState(CorsAccountConsts.ACCOUNT_APPROVE_UNDEAL);
			approve.setBusiApproveType(CorsAccountConsts.BUSI_APPROVE_ADD_APPLY);
			commonDAO.save(approve);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 确认续费清单
	 * 
	 * @param corsApplyId
	 */
	public SuccessOrFailure saveRepayConfirmList(String corsRepayTempParams) {
		try {
			String[] corsRepayTempParamsArray = corsRepayTempParams.split(",");
			
			CorsAccountRepay accountRepay = new CorsAccountRepay();
			accountRepay.setCompany(ContextUtil.getCurrentUser().getCompany());
			accountRepay.setAccountRepayNum(1);
			accountRepay.setAccountRepayState(CorsAccountConsts.BUSI_APPROVE_STATE_SUBMIT);
			accountRepay.setApplyMaterialState(CorsAccountConsts.APPLY_MATERIAL_STATE_WWS);
			accountRepay.setOrderNo(OrderNoCreateUtil.getCorsApplyOrderNo());
			accountRepay.setOrderType(CorsAccountConsts.CORS_ORDER_TYPE_RENEW);
			accountRepay.setRepayActiveState(CorsAccountConsts.ACCOUNT_ACTIVE_DEAL_STATE_0);
			commonDAO.save(accountRepay);
			
			List<CorsRepayRel> repayRelList = new ArrayList<CorsRepayRel>();
			for (String corsRepayTemps : corsRepayTempParamsArray) {
				String[] corsRepayTempArray = corsRepayTemps.split("&");
				CorsAccount oldCorsAccount = commonDAO.get(CorsAccount.class,
						corsRepayTempArray[0]);
				CorsRepayRel corsRepayRel = new CorsRepayRel();
				corsRepayRel.setCorsAccount(oldCorsAccount);
				corsRepayRel.setCorsRepayPeriod(Integer.parseInt(corsRepayTempArray[1]));
				corsRepayRel.setCorsAccountRepay(accountRepay);
				commonDAO.save(corsRepayRel); 
				repayRelList.add(corsRepayRel);
				// 修改续费临时表状态
				CorsRepayTemp corsRepayTemp = commonDAO.get(
						CorsRepayTemp.class, corsRepayTempArray[2]);
				corsRepayTemp.setIsDelete("Y");
				commonDAO.update(corsRepayTemp);
				// 修改账号操作阶段
				oldCorsAccount.setCorsAccountStage(CorsAccountConsts.ACCOUNT_STAGE_REPAY_REQUEST);
				commonDAO.update(oldCorsAccount);
			}
			
			// 审批流程表中插入数据
			CorsBusiApprove corsBusiApprove = new CorsBusiApprove();
			corsBusiApprove.setApproveState(CorsAccountConsts.ACCOUNT_APPROVE_UNDEAL);
			corsBusiApprove.setOrderBussinkey(accountRepay.getAccountRepayId());
			corsBusiApprove.setCompany(ContextUtil.getCurrentUser().getCompany());
			corsBusiApprove.setBusiSubmitTime(new Date());
			corsBusiApprove.setBusiSubmitUser(ContextUtil.getCurrentUser().getUserId());
			corsBusiApprove.setBusiApproveType(CorsAccountConsts.BUSI_APPROVE_REPAY_APPLY);
			commonDAO.save(corsBusiApprove);
			return SuccessOrFailure.SUCCESS("续费成功");
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE("续费失败");
		}
	}

	public void deleteCorsApply(String corsApplyId) {
		commonDAO.delete(CorsApplyTemp.class, corsApplyId);
	}
	
	public Company getCompany(String companyId){
		return commonDAO.get(Company.class, companyId);
	}
}
