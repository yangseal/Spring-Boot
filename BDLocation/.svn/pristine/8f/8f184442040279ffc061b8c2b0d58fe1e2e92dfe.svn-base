package com.cnten.bdlocation.clients.formalService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cnten.bdlocation.clients.formalService.service.FormalService;
import com.cnten.bdlocation.constants.CorsAccountConsts;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.Company;
import com.cnten.po.CorsApply;
import com.cnten.po.CorsApplyTemp;
/**
 * 正式服务  控制器
 * @author Administrator
 */
@Controller
@RequestMapping(value="/client/service")
public class FormalServiceController {
	@Autowired
	private FormalService formalService;
	
	@RequestMapping(value="formalApplyConfig")
	private String formalService(String serviceType, String productType){
		//如果资料尚未完善，跳转主页资料完善页面（直接去缓存中的数据，状态不会更新）
		Company company = formalService.getCompany( ContextUtil.getCurrentUser().getCompany().getCompanyId());
		String materialState = company.getCompanyMaterialState();
		if(!CorsAccountConsts.ACCOUNT_STATE_EXAMINE_PASS.equals(materialState)) 
			return "redirect:/client/index?menuItemCode=" + "clientInfoMgt";
		return null;
	}
	
	@RequestMapping(value="/formalApplyConfirm")
	public void formal(String companyId,Model model){
		List<CorsApply> corsApply = formalService.getCorsApplys(companyId);
		model.addAttribute("corsApply", corsApply);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveCorsApply")
	public SuccessOrFailure saveCorsApply(CorsApplyTemp corsApplyTemp){
		try {
			formalService.saveCorsApply(corsApplyTemp);
			return SuccessOrFailure.SUCCESS(corsApplyTemp.getCorsApplyTempId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	@ResponseBody
	@RequestMapping(value="/confirmCorsApply")
	public SuccessOrFailure confirmCorsApply(String corsApplyTempParams){
		try {
			formalService.saveConfirmList(corsApplyTempParams);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/confirmCorsRepay")
	public SuccessOrFailure confirmCorsRepay(String corsRepayTempParams){
		try {
			formalService.saveRepayConfirmList(corsRepayTempParams);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteCorsApply")
	public SuccessOrFailure deleteCorsApply(String corsApplyId){
		try {
			formalService.deleteCorsApply(corsApplyId);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
}
