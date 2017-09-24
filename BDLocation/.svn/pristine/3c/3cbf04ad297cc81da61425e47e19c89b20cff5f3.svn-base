package com.cnten.bdlocation.oamprovider.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.cnten.bdlocation.oamprovider.service.OamProviderService;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.OamProvider;

@Controller
@RequestMapping(value = "/oamProvider")
public class OamProviderController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	private OamProviderService oamProviderService;
	
	@RequestMapping(value = "/showOamProviders")
	public void showOamProviders() {
	}
	
	@RequestMapping(value = "/showOamProvider")
	public void showOamProvider(String oamProviderId, Model model) {
		OamProvider oamProvider = oamProviderService.getOamProvider(oamProviderId);
		model.addAttribute("oamProvider", oamProvider);
	}
	
	@RequestMapping(value = "/queryOamProviders")
	public void queryOamProviders(OamProvider oamProvider, Integer pageIndex, Integer pageSize, Model model) {
		Page page = oamProviderService.getOamProvidersPage(oamProvider, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "/selectOamProvider")
	public void selectOamProvider() {
	}
	
	@RequestMapping(value = "/selectOamProviders")
	public void selectOamProviders(OamProvider oamProvider, Integer pageIndex, Integer pageSize, Model model) {
		Page page = oamProviderService.getOamProvidersPage(oamProvider, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOamProvider")
	public SuccessOrFailure saveOamProvider(OamProvider oamProvider){
		try {
			oamProviderService.saveOamProvider(oamProvider);
			return SuccessOrFailure.SUCCESS(oamProvider.getOamProviderId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteOamProvider")
	public SuccessOrFailure deleteOamProvider(String oamProviderIds){
		try {
			oamProviderService.deleteOamProvider(oamProviderIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/exportOamProviders")
	public void exportOamProviders(OamProvider oamProvider, HttpServletResponse response) {
		try {
			oamProviderService.exportOamProviders(oamProvider, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
