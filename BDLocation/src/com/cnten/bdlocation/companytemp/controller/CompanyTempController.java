package com.cnten.bdlocation.companytemp.controller;

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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cnten.platform.dao.Page;
import com.cnten.bdlocation.companytemp.service.CompanyTempService;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.CompanyTemp;
import com.cnten.vo.ParamVO;

@Controller
public class CompanyTempController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	private CompanyTempService companyTempService;
	
	@RequestMapping(value = "/companyTemp/showCompanyTemps")
	public void showCompanyTemps() {
	}
	
	@RequestMapping(value = "/companyTemp/showCompanyTemp")
	public void showCompanyTemp(String companyTempId, Model model) {
		CompanyTemp companyTemp = companyTempService.getCompanyTemp(companyTempId);
		model.addAttribute("companyTemp", companyTemp);
	}
	
	@RequestMapping(value = "/companyTemp/queryCompanyTemps")
	public void queryCompanyTemps(CompanyTemp companyTemp, Integer pageIndex, Integer pageSize, Model model) {
		Page page = companyTempService.getCompanyTempsPage(companyTemp, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "/companyTemp/selectCompanyTemp")
	public void selectCompanyTemp() {
	}
	
	@RequestMapping(value = "/companyTemp/selectCompanyTemps")
	public void selectCompanyTemps(CompanyTemp companyTemp, Integer pageIndex, Integer pageSize, Model model) {
		Page page = companyTempService.getCompanyTempsPage(companyTemp, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@ResponseBody
	@RequestMapping(value = "/companyTemp/saveCompanyTemp")
	public SuccessOrFailure saveCompanyTemp(CompanyTemp companyTemp){
		try {
			companyTempService.saveCompanyTemp(companyTemp);
			return SuccessOrFailure.SUCCESS(companyTemp.getCompanyTempId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/companyTemp/deleteCompanyTemp")
	public SuccessOrFailure deleteCompanyTemp(String companyTempIds){
		try {
			companyTempService.deleteCompanyTemp(companyTempIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/companyTemp/exportCompanyTemps")
	public void exportCompanyTemps(CompanyTemp companyTemp, HttpServletResponse response) {
		try {
			companyTempService.exportCompanyTemps(companyTemp, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/companyTemp/saveCompanyTempByPage")
	public SuccessOrFailure saveCompanyTempByPage(CompanyTemp companyTemp){
		try {
				companyTempService.saveApproveCompanyTemp(companyTemp);
				return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	public long getCompanyTempByName(String name){
		return companyTempService.getCompanyTempByName(name);
	}
	
	@ResponseBody
	@RequestMapping(value = "/companyTemp/saveApproveCompanyTemp")
	public SuccessOrFailure saveApproveCompanyTemp(CompanyTemp companyTemp){
		try {
			companyTempService.saveApproveCompanyTemp(companyTemp);
			return SuccessOrFailure.SUCCESS(companyTemp.getCompanyTempId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/companyTemp/saveRejectCompanyTemp")
	public SuccessOrFailure saveRejectCompanyTemp(CompanyTemp companyTemp){
		try {
			companyTempService.saveRejectCompanyTemp(companyTemp);
			return SuccessOrFailure.SUCCESS(companyTemp.getCompanyTempId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/companyTemp/verifyUserCode")
	public SuccessOrFailure verifyUserCode(String userCode){
		return companyTempService.getUserCode(userCode);
	}
	
	@ResponseBody
	@RequestMapping(value="/companyTemp/verifyCompanyCode")
	public SuccessOrFailure verifyCompanyCode(String companyCode){
		return companyTempService.validateCompanyCode(companyCode);
	}
}
