package com.cnten.bdlocation.oamaccount.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
import com.cnten.bdlocation.oamaccount.service.OamAccountService;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.OamAccount;

@Controller
@RequestMapping(value = "/oamAccount")
public class OamAccountController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	private OamAccountService oamAccountService;
	
	@RequestMapping(value = "/showOamAccounts")
	public void showOamAccounts() {
	}
	
	@RequestMapping(value = "/showOamAccount")
	public void showOamAccount(String oamAccountId, Model model) {
		OamAccount oamAccount = oamAccountService.getOamAccount(oamAccountId);
		model.addAttribute("oamAccount", oamAccount);
	}
	
	@RequestMapping(value = "/queryOamAccounts")
	public void queryOamAccounts(OamAccount oamAccount, Integer pageIndex, Integer pageSize, Model model) {
		Page page = oamAccountService.getOamAccountsPage(oamAccount, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "/selectOamAccount")
	public void selectOamAccount() {
	}
	
	@RequestMapping(value = "/selectOamAccounts")
	public void selectOamAccounts(OamAccount oamAccount, Integer pageIndex, Integer pageSize, Model model) {
		Page page = oamAccountService.getOamAccountsPage(oamAccount, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOamAccount")
	public SuccessOrFailure saveOamAccount(OamAccount oamAccount){
		try {
			oamAccountService.saveOamAccount(oamAccount);
			return SuccessOrFailure.SUCCESS(oamAccount.getOamAccountId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteOamAccount")
	public SuccessOrFailure deleteOamAccount(String oamAccountIds){
		try {
			oamAccountService.deleteOamAccount(oamAccountIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/exportOamAccounts")
	public void exportOamAccounts(OamAccount oamAccount, HttpServletResponse response) {
		try {
			oamAccountService.exportOamAccounts(oamAccount, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/getOamAccountsMobile")
	public Map<String, Object> getOamAccounts(String areaId){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("oamAccounts", oamAccountService.getOamAccounts(areaId));
		return result;
	}
}