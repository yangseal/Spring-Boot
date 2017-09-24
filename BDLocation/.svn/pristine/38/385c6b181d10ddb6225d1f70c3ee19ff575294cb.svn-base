package com.cnten.platform.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.platform.system.service.CompanyMenuService;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.CompanyMenu;

@Controller
public class CompanyMenuController {
	@Autowired
	private CompanyMenuService companyMenuService;
	
	@RequestMapping(value="/companyMenu/showCompanyMenus")
	public void showCompanyMenus(){
	}
	
	@ResponseBody
	@RequestMapping(value = "/companyMenu/queryCompanyMenus")
	public List<CompanyMenu> queryRoleUsers(CompanyMenu companyMenu) {
		return companyMenuService.getCompanyMenus(companyMenu);
	}
		
	@ResponseBody
	@RequestMapping(value = "/companyMenu/saveCompanyMenu")
	public SuccessOrFailure saveCompanyMenu(String companyId,@RequestParam(value = "addNodeList[]",required=false) String[] addNodeList,@RequestParam(value = "delNodeList[]",required=false) String[] delNodeList){
		try {
			if(null != addNodeList) {
				companyMenuService.saveCompanyMenu(companyId,addNodeList);
			}
			if(null != delNodeList) {
				companyMenuService.deleteCompanyMenu(companyId, delNodeList);
			}
			return SuccessOrFailure.SUCCESS(companyId);
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
}