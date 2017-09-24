package com.cnten.bdlocation.corsContract.controller;

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

import com.cnten.bdlocation.corsContract.service.CorsContractService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.BaseCustomer;
import com.cnten.po.CorsContract;

@Controller
@RequestMapping(value="/corsContract")
public class CorsContractController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	@Autowired
	private CorsContractService corsContractService;
	
	@RequestMapping(value="/addCorsContract")
	public void  addCorsContract(String corsContractId,Model model){
		if(StringUtils.isNotEmpty(corsContractId)){
			CorsContract corsContract = corsContractService.showEidtCorsContract(corsContractId);
			model.addAttribute("corsContract", corsContract);
		}
	}
	 
	
	@RequestMapping(value= "/showCorsContract")
	public void showCorsContract(){}
	
	@ResponseBody
	@RequestMapping(value="/saveCorsConstract")
	public SuccessOrFailure saveCorsConstract(CorsContract corsContract)
	{
		try {
			corsContractService.saveCorsConstract(corsContract);
			return SuccessOrFailure.SUCCESS(corsContract.getCorsContractId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value="/queryCorsContract")
	public void queryCorsContract(CorsContract corContract,Integer pageIndex,Integer pageSize,Model model){
		Page page = corsContractService.getCorsContractPage(corContract,pageIndex,pageSize);
		System.out.println("page:"+page);
		model.addAttribute(page);
	}
	
	
	@ResponseBody
	@RequestMapping(value="/deleteCorsContract")
	public SuccessOrFailure deleteCorsContract(String corsContractIds)
	{
		try {
			corsContractService.deleteCorsContract(corsContractIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
}
