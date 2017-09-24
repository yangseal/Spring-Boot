package com.cnten.bdlocation.customercare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.customercare.service.CustomerCareService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.CustomerCare;

@Controller
@RequestMapping(value="/customerCare")
public class CustomerCareController {
	@Autowired
	private CustomerCareService customerCareService;
	
	@RequestMapping(value="/showCustomerCares")
	public void showCustomerCares(){
				
		
	}
	
	@RequestMapping(value="/queryCustomerCares")
	public void queryCustomerCares(CustomerCare customerCare,Integer pageIndex,Integer pageSize,Model model){
				
		Page page = customerCareService.getCustomerCares(customerCare,pageIndex,pageSize);
		
		model.addAttribute("page",page);
	}
	
	@RequestMapping(value="/showCustomerCare")
	public void showCustomerCare(String customerCareId,Model model){
		CustomerCare customerCare = customerCareService.getCustomerCare(customerCareId);
		model.addAttribute("customerCare", customerCare);
	}
	@ResponseBody
	@RequestMapping(value="/saveCustomerCare")
	public SuccessOrFailure saveCustomerCare(CustomerCare customerCare){
		customerCareService.saveCustomerCare(customerCare);
		return SuccessOrFailure.SUCCESS(customerCare.getBdCustomerCareId());
	}
	@ResponseBody
	@RequestMapping(value="/deleteCustomerCare")
	public SuccessOrFailure deleteCustomerCare(String customerCareIds){
		
		customerCareService.deleteCustomerCare(customerCareIds);
		return SuccessOrFailure.SUCCESS;
	}
}
