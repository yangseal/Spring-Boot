package com.cnten.bdlocation.clients.testService.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.clients.testService.service.TestService;
import com.cnten.bdlocation.constants.CorsAccountConsts;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.User;
/**
 * 试用服务  控制器
 * @author Administrator
 */
@Controller
@RequestMapping(value="/client")
public class TestServiceController {
	@Autowired
	private TestService testService;
	
	/**
	 * 跳转到  试用申请 提交界面( 必须登录后，方可跳转该页面)
	 */
	@RequestMapping(value="/service/testServiceSubmit")
	public void toApplySubmit(String serviceType,Model model){
		User user = (User) ContextUtil.getCurrentUser();
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(CorsAccountConsts.ACCOUNT_NET_PRECISION_mi.equals(serviceType)){
			params.put("serviceTypeName", "米");
			params.put("serviceType", CorsAccountConsts.ACCOUNT_NET_PRECISION_mi);
		}else if(CorsAccountConsts.ACCOUNT_NET_PRECISION_meter.equals(serviceType)){
			params.put("serviceTypeName", "亚米");
			params.put("serviceType", CorsAccountConsts.ACCOUNT_NET_PRECISION_meter);
		}else if(CorsAccountConsts.ACCOUNT_NET_PRECISION_centimeter.equals(serviceType)){
			params.put("serviceTypeName", "厘米");
			params.put("serviceType", CorsAccountConsts.ACCOUNT_NET_PRECISION_centimeter);
		}
		params.put("user", user);
		model.addAllAttributes(params);
	}
	
	@ResponseBody
	@RequestMapping(value="/service/submitServiceApply")
	public SuccessOrFailure submitServiceApply(String serviceType){
		try {
			return testService.saveApplyByService(serviceType,null);
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
}
