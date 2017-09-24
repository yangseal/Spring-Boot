package com.cnten.bdlocation.corsaccount.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.corsaccount.service.CorsAccountService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.CorsAccount;
import com.cnten.po.OamArea;

@Controller
public class CorsAccountController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	private CorsAccountService corsAccountService;
	
	@RequestMapping(value = "/corsAccount/showCorsAccounts")
	public void showCorsAccounts() {
	}
	
	@RequestMapping(value = "/client/mgtCenter/corsAccounts/showAccounts")
	public void showAccounts(){
	}
	@RequestMapping(value="/client/mgtCenter/corsAccounts/detailAccount")
	public void detailAccount(String corsAccountId,Model model){
		CorsAccount corsAccount = corsAccountService.getCorsAccount(corsAccountId);
		model.addAttribute("corsAccount", corsAccount);
	}
	
	@RequestMapping(value = "/corsAccount/showCorsAccount")
	public void showCorsAccount(String corsAccountId, Model model) {
		CorsAccount corsAccount = corsAccountService.getCorsAccount(corsAccountId);
		model.addAttribute("corsAccount", corsAccount);
	}
	
	@RequestMapping(value = "/corsAccount/queryCorsAccounts")
	public void queryCorsAccounts(CorsAccount corsAccount, Integer pageIndex, Integer pageSize, Model model) {
		Page page = corsAccountService.getCorsAccountsPage(corsAccount, pageIndex, pageSize);
		model.addAttribute(page);
	}
	@RequestMapping(value = "/corsAccount/selectCorsAccount")
	public void selectCorsAccount() {
	}
	
	@RequestMapping(value = "/corsAccount/selectCorsAccounts")
	public void selectCorsAccounts(CorsAccount corsAccount, Integer pageIndex, Integer pageSize, Model model) {
		Page page = corsAccountService.getCorsAccountsPage(corsAccount, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@ResponseBody
	@RequestMapping(value = "/corsAccount/saveCorsAccount")
	public SuccessOrFailure saveCorsAccount(CorsAccount corsAccount){
		try {
			corsAccountService.saveCorsAccount(corsAccount);
			return SuccessOrFailure.SUCCESS(corsAccount.getCorsAccountId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/corsAccount/deleteCorsAccount")
	public SuccessOrFailure deleteCorsAccount(String corsAccountIds){
		try {
			corsAccountService.deleteCorsAccount(corsAccountIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/corsAccount/exportCorsAccounts")
	public void exportCorsAccounts(CorsAccount corsAccount, HttpServletResponse response) {
		try {
			corsAccountService.exportCorsAccounts(corsAccount, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/corsAccount/showAllCorsQuerys")
	public void showAnCorsQuerys(){
	}
	
	@RequestMapping(value = "/corsAccount/queryAllCorsAccount")
	public void queryAllCorsAccount(CorsAccount corsAccount, Integer pageIndex, Integer pageSize, Model model) {
		Page page = corsAccountService.getCorsAllAccountsPage(corsAccount, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value="/corsAccount/showCorsAccountUse")
	public void showCorsAccountUse(String corsAccountIds, Model model){
		if(StringUtils.isNotBlank(corsAccountIds))
			model.addAttribute("corsAccountIds", corsAccountIds);
	}
	
	@ResponseBody
	@RequestMapping(value="/corsAccount/saveCorsAccountUse")
	public SuccessOrFailure saveCorsAccountUse(String corsAccountIds,String corsUse){
		try {
			corsAccountService.updateCorsAccountUse(corsAccountIds,corsUse);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
}
