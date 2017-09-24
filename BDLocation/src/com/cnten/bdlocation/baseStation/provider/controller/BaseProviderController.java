package com.cnten.bdlocation.baseStation.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.baseStation.provider.service.BaseProviderService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.BaseProvider;

@Controller
@RequestMapping(value = "/baseStation/provider")
public class BaseProviderController {
	
	@Autowired
	private BaseProviderService baseProviderService;
	
	@RequestMapping(value = "/showBaseProviders")
	public void showBaseProvider(){
		
	}
	
	@RequestMapping(value = "/queryBaseProvider")
	public void queryBaseProvider(BaseProvider baseProivder,Integer pageIndex, Integer pageSize, Model model){
		Page page = baseProviderService.getBaseProvider(baseProivder, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value="/openBaseProvider")
	public void openBaseProvider(String baseProviderId,Model model){
		BaseProvider baseProvider = baseProviderService.getBaseProviderById(baseProviderId);
		model.addAttribute("baseProvider", baseProvider);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveBaseProvider")
	public SuccessOrFailure saveBaseProvider(BaseProvider baseProvider){
		try {
			baseProviderService.saveBaseProvide(baseProvider);
			return SuccessOrFailure.SUCCESS(baseProvider.getBaseProviderId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
}
