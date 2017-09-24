package com.cnten.bdlocation.baseStation.customer.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.baseStation.customer.service.BaseContractService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.BaseCustomer;
import com.cnten.po.BaseCustomerContract;

@Controller
@RequestMapping(value="baseStation/customer")
public class BaseContractController {
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@Autowired
	private BaseContractService baseContractService;
	//服务合同管理
	@RequestMapping(value="/showContracts")
	public void showContracts(String baseCustomerId,Model model){
		model.addAttribute("baseCustomerId", baseCustomerId);
	}
	@RequestMapping(value="/queryContracts")
	public void queryContracts(BaseCustomerContract baseCustomerContract,Integer pageIndex,Integer pageSize,Model model){
		Page page = baseContractService.getContractsPage(baseCustomerContract,pageIndex,pageSize);
		model.addAttribute(page);
	}
	@RequestMapping(value="/showContract")
	public void addContract(String baseCustomerId,String contractId,Model model){
		BaseCustomerContract contract = baseContractService.getContract(contractId);
		BaseCustomer baseCustomer = baseContractService.getBaseCustomer(baseCustomerId);
		model.addAttribute("contract", contract);
		model.addAttribute("baseCustomer",baseCustomer);
	}
	@ResponseBody
	@RequestMapping(value="/saveContract")
	public SuccessOrFailure saveContract(BaseCustomerContract baseCustomerContract){
		try {
			baseContractService.saveContract(baseCustomerContract);
			return SuccessOrFailure.SUCCESS(baseCustomerContract.getBaseCustomerContractId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
		
	} 
}
