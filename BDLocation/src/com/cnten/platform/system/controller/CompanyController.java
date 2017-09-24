package com.cnten.platform.system.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.platform.dao.Page;
import com.cnten.platform.system.service.CompanyService;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.Company;

@Controller
public class CompanyController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	private CompanyService companyService;
	
	@RequestMapping(value = "/company/showCompanys")
	public void showCompanys() {
	}
	
	@RequestMapping(value = "/company/showCompany")
	public void showCompany(String companyId, Model model) {
		Company company = companyService.getCompany(companyId);
		model.addAttribute("company", company);
	}
	
	@RequestMapping(value = "/company/queryCompanys")
	public void queryCompanys(Company company, Integer pageIndex, Integer pageSize, Model model) {
		Page page = companyService.getCompanysPage(company, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@ResponseBody
	@RequestMapping(value="/company/getCompanys")
	public List<Company> getCompanys() {
		return companyService.getCompanys();
	}
	
	@RequestMapping(value = "/company/selectCompany")
	public void selectCompany() {
	}
	
	@RequestMapping(value = "/company/selectCompanys")
	public void selectCompanys(Company company, Integer pageIndex, Integer pageSize, Model model) {
		Page page = companyService.getCompanysPage(company, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@ResponseBody
	@RequestMapping(value = "/company/saveCompany")
	public SuccessOrFailure saveCompany(Company company){
		try {
			companyService.saveCompany(company);
			return SuccessOrFailure.SUCCESS(company.getCompanyId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	/**
	 * 企业资料提交
	*/
	@ResponseBody
	@RequestMapping(value = "/company/saveApprove")
	public SuccessOrFailure saveApprove(Company company){
		try {
			companyService.saveApprove(company);
			return SuccessOrFailure.SUCCESS(company.getCompanyId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/company/deleteCompany")
	public SuccessOrFailure deleteCompany(String companyIds){
		try {
			companyService.deleteCompany(companyIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/company/exportCompanys")
	public void exportCompanys(Company company, HttpServletResponse response) {
		try {
			companyService.exportCompanys(company, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
