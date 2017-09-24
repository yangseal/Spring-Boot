package com.cnten.bdlocation.companyOrg.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.companyOrg.service.CompanyOrgCorsService;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.web.SuccessOrFailure;

@Controller
public class CompanyOrgCorsController {

	@Autowired
	private CompanyOrgCorsService orgCorsService;
	
	@RequestMapping(value="/companyOrg/orgCors/showOrgCors")
	public void showOrgCors(Model model){
		//默认加载当前公司   未分配的账号
		model.addAttribute("blankCorsList", orgCorsService.getCompanyCorsOfNoDevide(ContextUtil.getCurrentUser().getCompany()));
	}
	
	/**
	 * 查询 当前机构已持有账号 、当前公司待分配账号
	 * @param companyOrgId
	 */
	@ResponseBody
	@RequestMapping(value="/companyOrg/orgCorsAndBlankCors")
	public HashMap<String,Object> getOrgCorsAndBlankCors(String companyOrgId){
		return orgCorsService.getOrgCorsAndBlankCors(companyOrgId);
	}
	
	/**
	 * 保存 当前选择机构  新配置的账号
	 * @param oldCors
	 * @param newCors
	 * @param companyOrgId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/companyOrg/saveNewSelectOrgCors")
	public SuccessOrFailure saveNewSelectOrgCors(String oldCors, String newCors, String companyOrgId){
		return orgCorsService.updateCorsCompanyOrg(oldCors, newCors, companyOrgId);
	}
	
}
