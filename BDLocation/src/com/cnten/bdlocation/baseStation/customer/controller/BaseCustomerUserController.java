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

import com.cnten.bdlocation.baseStation.customer.service.BaseCustomerUserService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.BaseCustomerUser;

@Controller
@RequestMapping(value="baseStation/customer")
public class BaseCustomerUserController {
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	@Autowired
	private BaseCustomerUserService baseCustomerUserService;

	//联系人管理
	@RequestMapping(value="/showCustomers")
	public void showCustomers(String baseCustomerId, Model model){
		model.addAttribute("baseCustomerId", baseCustomerId);
	}
	@RequestMapping(value="/queryCustomers")
	public void queryCustomers(BaseCustomerUser baseCustomerUser,Integer pageIndex,Integer pageSize,Model model){
		Page page = baseCustomerUserService.getCustomerUsersPage(baseCustomerUser,pageIndex,pageSize);
		model.addAttribute(page);
	}
	@RequestMapping(value="/showCustomer")
	public void showCustomer(String baseCustomerId,String customerId,Model model){
		BaseCustomerUser customer = baseCustomerUserService.getCustomer(customerId);
		model.addAttribute("customer", customer);
		model.addAttribute("baseCustomerId",baseCustomerId);
	}
	@ResponseBody
	@RequestMapping(value="/saveCustomer")
	public SuccessOrFailure saveCustomer(BaseCustomerUser baseCustomerUser){
		try{
			baseCustomerUserService.saveCustomer(baseCustomerUser);
			return SuccessOrFailure.SUCCESS(baseCustomerUser.getBaseCustomerUserId());
		}catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	@ResponseBody
	@RequestMapping(value="/deleteCustomer")
	public SuccessOrFailure deleteCustomer(String customerIds){
		try {
			baseCustomerUserService.deleteCustomer(customerIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
		
		
	}
	
}
