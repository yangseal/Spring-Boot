package com.cnten.bdlocation.baseStation.provider.controller;

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

import com.cnten.bdlocation.baseStation.provider.service.BaseProviderService;
import com.cnten.bdlocation.baseStation.provider.service.ProContractService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.BaseProContract;
import com.cnten.po.BaseProvider;

@Controller
@RequestMapping(value="/baseStation/provider")
public class ProContractController {

	@Autowired
	private ProContractService proContractService;
	@Autowired
	private BaseProviderService baseProviderService;
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(value="/showProContract")
	public void showProContract(String baseProviderId, Model model){
		model.addAttribute("baseProviderId",baseProviderId);
	}
	
	@RequestMapping(value="/queryProContract")
	public void queryProContract(BaseProContract proContract,Integer pageIndex, Integer pageSize, Model model){
		Page page = proContractService.getProContracts(proContract, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value="/openProContract")
	public void openProContract(String proContractId, String baseProviderId, Model model){
		BaseProContract proContract = proContractService.getProContractById(proContractId);
		BaseProvider baseProvider = baseProviderService.getBaseProviderById(baseProviderId);
		model.addAttribute("proContract", proContract);
		model.addAttribute("baseProvider", baseProvider);
	}
	
	@ResponseBody
	@RequestMapping(value="/saveProContract")
	public SuccessOrFailure saveProContract(BaseProContract proContract,String baseProviderId){
		try {
			proContractService.saveProContract(proContract,baseProviderId);
			return SuccessOrFailure.SUCCESS(proContract.getBaseProContractId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}

}
