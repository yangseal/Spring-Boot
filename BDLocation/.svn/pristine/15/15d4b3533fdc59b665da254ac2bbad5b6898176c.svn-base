package com.cnten.bdlocation.baseStation.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.baseStation.provider.service.BaseProviderService;
import com.cnten.bdlocation.baseStation.provider.service.ProviderUserService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.BaseProvider;
import com.cnten.po.BaseProviderUser;

@Controller
@RequestMapping(value="/baseStation/provider")
public class ProviderUserController {
	
	@Autowired
	private ProviderUserService providerUserService;
	@Autowired
	private BaseProviderService baseProviderService;
	
	@RequestMapping(value="/showProviderUsers")
	public void showProviderUser(String baseProviderId, Model model){
		model.addAttribute("baseProviderId", baseProviderId);
	}
	
	@RequestMapping(value="/queryProviderUsers")
	public void queryProUsers(BaseProviderUser proUser,Integer pageIndex, Integer pageSize, Model model){
		Page page = providerUserService.getProviderUsers(proUser, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value="/openProUser")
	public void openProUser(String providerUserId, String baseProviderId, Model model){
		BaseProviderUser proUser = providerUserService.getProUserById(providerUserId);
		BaseProvider baseProvider = baseProviderService.getBaseProviderById(baseProviderId);
		model.addAttribute("providerUser", proUser);
		model.addAttribute("baseProvider", baseProvider);
	}
	
	@ResponseBody
	@RequestMapping(value="/saveProUser")
	public SuccessOrFailure saveProUser(BaseProviderUser providerUser,String baseProviderId){
		try {
			providerUserService.saveProUser(providerUser,baseProviderId);
			return SuccessOrFailure.SUCCESS(providerUser.getBaseProviderUserId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteProUser")
	public SuccessOrFailure deleProUser(String providerUserIds){
		try {
			providerUserService.deleteProUser(providerUserIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}

}
