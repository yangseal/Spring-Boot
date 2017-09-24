package com.cnten.bdlocation.clients.testService.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cnten.platform.dao.CommonDAO;
import com.cnten.bdlocation.constants.CorsAccountConsts;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.util.OrderNoCreateUtil;
import com.cnten.platform.web.ResultCode;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.CorsApply;
import com.cnten.po.CorsApplyDetail;
import com.cnten.po.CorsBusiApprove;
import com.cnten.po.User;

@Service
public class TestService {
	
	@Autowired
	CommonDAO commonDAO;
	
	//提交试用服务申请
	public SuccessOrFailure saveApplyByService(String serviceType, String userId){
		
		User user = ContextUtil.getCurrentUser();
		if(user == null && StringUtils.isNotEmpty(userId)){
			user = commonDAO.get(User.class, userId);
		}
		
		String hql = "from CorsApply where isDelete is null and bdDeviceAccuracy = :serviceType and company = :currCompany and accountType = :accountType";
		HashMap<String, Object> params= new HashMap<String, Object>();
		params.put("serviceType", serviceType);
		params.put("currCompany", user.getCompany());
		params.put("accountType", CorsAccountConsts.ACCOUNT_TYPE_TEST);
		List<CorsApply> corsApplyList = commonDAO.queryList(hql, params);
		if(!corsApplyList.isEmpty()){
			return SuccessOrFailure.SUCCESS(ResultCode.success_0x002.toString(),"该试用服务一个账号只能申请一次!");
		}else{
			
			//申请明细表中添加数据
			CorsApplyDetail corsApplyDetail = new CorsApplyDetail();
			corsApplyDetail.setAccountType(CorsAccountConsts.ACCOUNT_TYPE_TEST);
			corsApplyDetail.setBdDeviceAccuracy(serviceType);
			corsApplyDetail.setApplyCount(CorsAccountConsts.ACCOUNT_TYPE_TEST_NUM);
			corsApplyDetail.setAccountUsePeriod(CorsAccountConsts.ACCOUNT_TYPE_TEST_PERIOD);
			commonDAO.save(corsApplyDetail);
			
			List<CorsApplyDetail> corsDetailList = new ArrayList<CorsApplyDetail>();
			corsDetailList.add(corsApplyDetail);
			
			//申请表中添加数据
			CorsApply corsApply = new CorsApply();
			corsApply.setOrderNo(OrderNoCreateUtil.getCorsApplyOrderNo());
			corsApply.setAccountType(CorsAccountConsts.ACCOUNT_TYPE_TEST);
			corsApply.setAccountUsePeriod(CorsAccountConsts.ACCOUNT_TYPE_TEST_PERIOD);
			corsApply.setApplyCount(CorsAccountConsts.ACCOUNT_TYPE_TEST_NUM);
			corsApply.setApplyStatus(CorsAccountConsts.BUSI_APPROVE_STATE_SUBMIT);
			corsApply.setApplyDate(new Date());
			corsApply.setBdDeviceAccuracy(serviceType);
			corsApply.setUser(user);
			corsApply.setCompany(user.getCompany());
			corsApply.setAccountCreateState(CorsAccountConsts.APPLY_ACCOUNT_CREATE_STATE_0);
			corsApply.setApplyMaterialState(CorsAccountConsts.APPLY_MATERIAL_STATE_WWS);
			corsApply.setOrderType(CorsAccountConsts.CORS_ORDER_TYPE_TRIAL);
			corsApply.setApplyDetailList(corsDetailList);
			commonDAO.save(corsApply);
			
			
			
			//申请流程表中添加数据
			CorsBusiApprove corsBusiApprove = new CorsBusiApprove();
			corsBusiApprove.setOrderBussinkey(corsApply.getCorsApplyId());
			corsBusiApprove.setBusiApproveType(CorsAccountConsts.BUSI_APPROVE_ADD_APPLY);
			corsBusiApprove.setBusiSubmitTime(new Date());
			corsBusiApprove.setBusiSubmitUser(user.getUserId());
			corsBusiApprove.setCompany(user.getCompany());
			corsBusiApprove.setApproveState(CorsAccountConsts.ACCOUNT_APPROVE_UNDEAL);
			commonDAO.save(corsBusiApprove);
		
			return SuccessOrFailure.SUCCESS("提交成功!正在跳转页面中...");
		}
	}

}
