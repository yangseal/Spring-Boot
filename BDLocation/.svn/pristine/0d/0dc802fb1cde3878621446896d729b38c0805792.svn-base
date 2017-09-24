package com.cnten.bdlocation.oamcustomer.controller;

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
import com.cnten.bdlocation.oamcustomer.service.OamCustomerService;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.OamArea;
import com.cnten.po.OamCustomer;

@Controller
@RequestMapping(value = "/oamCustomer")
public class OamCustomerController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	private OamCustomerService oamCustomerService;
	
	@RequestMapping(value = "/showOamCustomers")
	public void showOamCustomers() {
	}
	
	@RequestMapping(value = "/showOamCustomer")
	public void showOamCustomer(String oamCustomerId, Model model) {
		OamCustomer oamCustomer = oamCustomerService.getOamCustomer(oamCustomerId);
		model.addAttribute("oamCustomer", oamCustomer);
	}
	
	@RequestMapping(value = "/queryOamCustomers")
	public void queryOamCustomers(OamCustomer oamCustomer, Integer pageIndex, Integer pageSize, Model model) {
		Page page = oamCustomerService.getOamCustomersPage(oamCustomer, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "/selectOamCustomer")
	public void selectOamCustomer() {
	}
	
	@RequestMapping(value = "/selectOamCustomers")
	public void selectOamCustomers(String areaId,OamCustomer oamCustomer, Integer pageIndex, Integer pageSize, Model model) {
		if(null == oamCustomer.getOamArea()) {
			OamArea oamArea = new OamArea(areaId);
			oamCustomer.setOamArea(oamArea);
		} else {
			oamCustomer.getOamArea().setOamAreaId(areaId);
		}
		Page page = oamCustomerService.getOamCustomersPage(oamCustomer, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOamCustomer")
	public SuccessOrFailure saveOamCustomer(OamCustomer oamCustomer){
		try {
			oamCustomerService.saveOamCustomer(oamCustomer);
			return SuccessOrFailure.SUCCESS(oamCustomer.getOamCustomerId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteOamCustomer")
	public SuccessOrFailure deleteOamCustomer(String oamCustomerIds){
		try {
			oamCustomerService.deleteOamCustomer(oamCustomerIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/exportOamCustomers")
	public void exportOamCustomers(OamCustomer oamCustomer, HttpServletResponse response) {
		try {
			oamCustomerService.exportOamCustomers(oamCustomer, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/getOamCustomersMobile")
	public Map<String, Object> getOamCustomers(String oamAreaId){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("customers", oamCustomerService.getCustomers(oamAreaId));
		return result;
	}
}
