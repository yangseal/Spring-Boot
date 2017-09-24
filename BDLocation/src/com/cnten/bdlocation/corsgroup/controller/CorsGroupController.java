package com.cnten.bdlocation.corsgroup.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.corsaccount.service.CorsAccountService;
import com.cnten.bdlocation.corsgroup.service.CorsGroupService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.CorsCompanyGroup;
import com.cnten.po.User;

@Controller
public class CorsGroupController {
	private static final Logger log4j = LoggerFactory.getLogger(CorsGroupController.class);
	@Autowired
	private CorsGroupService corsGroupService;
	@Autowired
	private CorsAccountService corsAccountService;
	
	@RequestMapping(value = "/corsgroup/showCorsGroup")
	public void showCorsGroups(){
	}
	
	@RequestMapping(value = "/client/mgtCenter/corsGroups/showGroups")
	public void showCorsGroup(){}
	
	@RequestMapping(value = "/corsgroup/queryGroups")
	public void queryGroups(CorsCompanyGroup corsGroup,Integer pageIndex, Integer pageSize, Model model){
		Page page = corsGroupService.getCorsGroupsPage(corsGroup, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@ResponseBody
	@RequestMapping(value = "/corsgroup/queryCorsAccount")
	public Page getCorsAccountByGroupId(String corsGroupId) {
		return corsAccountService.getCorsAccountByGroupId(corsGroupId);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/corsgroup/queryCorsAccountNotGroup")
	public Page getCorsAccountNotGroup() {
		try{
			User user = ContextUtil.getCurrentUser();
			return corsAccountService.getCorsAccountsNotGroup(user.getCompany());
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/corsgroup/showAddGroup")
	public void showGroup(String companyGroupId,Model model){
		CorsCompanyGroup corsGroup = corsGroupService.getGroup(companyGroupId);
		model.addAttribute("group", corsGroup);
	}
	
	@RequestMapping(value = "/client/mgtCenter/corsGroups/showAddGroup")
	public void showAddGroup(String companyGroupId,Model model){
		CorsCompanyGroup corsGroup = corsGroupService.getGroup(companyGroupId);
		model.addAttribute("group", corsGroup);
	}
	
	@ResponseBody
	@RequestMapping(value = "/corsgroup/saveGroup")
	public SuccessOrFailure saveGroup(CorsCompanyGroup corsGroup) {
		try {
			String groupId = corsGroupService.saveGroup(corsGroup);
			if(groupId == null){
				return SuccessOrFailure.SUCCESS;
			}else{
				return SuccessOrFailure.SUCCESS(groupId);
			}
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/client/mgtCenter/corsGroups/saveGroup")
	public SuccessOrFailure saveClientGroup(CorsCompanyGroup corsGroup) {
		try {
			String groupId = corsGroupService.saveGroup(corsGroup);
			if(groupId == null){
				return SuccessOrFailure.SUCCESS;
			}else{
				return SuccessOrFailure.SUCCESS(groupId);
			}
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/corsgroup/confirmDivide")
	public SuccessOrFailure confirmDivide(String corsAccountIds,String companyGroupId){
		try{
			corsAccountService.saveDivide(corsAccountIds, companyGroupId);
			return SuccessOrFailure.SUCCESS;
		}catch(Exception e){
			SuccessOrFailure.FAILURE(e.getMessage());
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/corsgroup/removeCorsAccount")
	public SuccessOrFailure removeCorsAccount(String corsAccountId){
		try {
			corsAccountService.updateAccountGroup(corsAccountId);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			SuccessOrFailure.FAILURE(e.getMessage());
		}
		return null;
	}
}
