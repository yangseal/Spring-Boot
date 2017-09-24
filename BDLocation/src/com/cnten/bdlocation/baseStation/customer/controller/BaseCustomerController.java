package com.cnten.bdlocation.baseStation.customer.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.baseStation.customer.service.BaseCustomerService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.BaseCustomer;

@Controller
@RequestMapping(value="baseStation/customer")
public class BaseCustomerController {
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@Autowired
	private BaseCustomerService baseCustomerService;

	//基站客户管理
	@RequestMapping(value="/showBaseCustomers")
	public void showBaseCustomers(){
		
	}
	@RequestMapping(value="/queryBaseCustomers")
	public void queryProjects(BaseCustomer baseCustomer,Integer pageIndex,Integer pageSize,Model model){
		Page page = baseCustomerService.getBaseCustomersPage(baseCustomer,pageIndex,pageSize);
		model.addAttribute(page);
	}
	@RequestMapping(value="/showBaseCustomer")
	public void showBaseCustomer(String baseCustomerId,Model model){
		if(StringUtils.isNotEmpty(baseCustomerId)){
			BaseCustomer baseCustomer = baseCustomerService.getBaseCustomer(baseCustomerId);
			model.addAttribute("baseCustomer", baseCustomer);
		}
	}
	@ResponseBody
	@RequestMapping(value="/saveBaseCustomer")
	public SuccessOrFailure saveBaseCustomer(BaseCustomer baseCustomer){
		try {
			baseCustomerService.saveBaseCustomer(baseCustomer);
			return SuccessOrFailure.SUCCESS(baseCustomer.getBaseCustomerId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
}
