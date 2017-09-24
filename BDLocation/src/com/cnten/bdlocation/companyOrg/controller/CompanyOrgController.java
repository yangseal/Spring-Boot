package com.cnten.bdlocation.companyOrg.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.companyOrg.service.CompanyOrgService;
import com.cnten.enums.UserFeature;
import com.cnten.platform.system.service.MenuService;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.util.StringUtil;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.CompanyOrg;
import com.cnten.po.CorsAccount;
import com.cnten.po.Menu;
import com.cnten.po.User;

@Controller
public class CompanyOrgController {
	
	@Autowired
	private MenuService menuService;
	@Autowired
	private CompanyOrgService companyOrgService;
	
	@RequestMapping(value="/companyOrg/orgMgt/showOrgs")
	public void showOrgs(String companyOrgId, Model model){
	}
	
	@RequestMapping(value="/companyOrg/orgMgt/showOrg")
	public void showOrg(CompanyOrg companyOrg, Model model){
		if(StringUtil.isNotEmpty(companyOrg.getCompanyOrgId())){
			CompanyOrg org = companyOrgService.getCompanyOrg(companyOrg.getCompanyOrgId());
			model.addAttribute("companyOrg", org);
		}else{
			model.addAttribute("companyOrg", companyOrg);
		}
		
	}
	
	@RequestMapping(value="/companyOrg/orgMgt/showOrgUser")
	public void showOrgUser(String companyOrgId, Model model){
		model.addAttribute("companyOrgId", companyOrgId);
	}
	
	@ResponseBody
	@RequestMapping(value="/companyOrg/orgMgt/saveOrg")
	public SuccessOrFailure saveOrg(CompanyOrg org, Model model){
		try {
			String orgId = companyOrgService.saveOrg(org);
			if(orgId == null){
				return SuccessOrFailure.SUCCESS;
			}else{
				return SuccessOrFailure.SUCCESS(orgId);
			}
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	/**
	 * 获取公司组织机构  结构树
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/companyOrg/getCompanyOrgs")
	public List<CompanyOrg> getCompanyOrgs() {
		List<CompanyOrg> orgs = companyOrgService.getCompanyOrgs(ContextUtil.getCurrentUser().getCompany());
		return orgs;
	} 
	
	/**
	 * 查询 公司的 管理员账号
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/companyOrg/getAdmin")
	public List<User> getCompanyAdmin(String companyOrgId){
		List<User> corsAdminList = companyOrgService.getCompanyAdmin(companyOrgId,ContextUtil.getCurrentUser().getCompany());
		return corsAdminList;
	}
	
	@ResponseBody
	@RequestMapping(value="/companyOrg/saveOrgAdmin")
	public SuccessOrFailure saveOrgAdmin(User user){
		try {
			String userId = companyOrgService.saveOrgAdmin(user);
			if(userId == null){
				return SuccessOrFailure.SUCCESS;
			}else{
				return SuccessOrFailure.SUCCESS(userId);
			}
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	/**
	 * 删除 分公司管理员账号
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/companyOrg/delOrgAdmin")
	public SuccessOrFailure delOrgAdmin(String userId){
		try {
			companyOrgService.deleteOrgAdmin(userId);
			return SuccessOrFailure.SUCCESS(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
		
		
	}
	
	/**
	 * 删除分子机构
	 * @param companyOrgId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/companyOrg/delCompanyOrg")
	public SuccessOrFailure deleteCompanyOrg(String companyOrgId){
		try{
			return companyOrgService.deleteOrg(companyOrgId);
		}catch(Exception e){
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
		
	}
}
