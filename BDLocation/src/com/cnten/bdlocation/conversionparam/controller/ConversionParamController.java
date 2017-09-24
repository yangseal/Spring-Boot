package com.cnten.bdlocation.conversionparam.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.conversionparam.service.ConversionParamService;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.ConversionParam;

@Controller
@RequestMapping(value = "/conversionParam")
public class ConversionParamController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@Autowired
	private ConversionParamService conversionParamService;
	
	@RequestMapping(value = "/showConversionParams")
	public void showConversionParams(Model model) {
		List<ConversionParam> conversionParams = conversionParamService.getConversionParams();
		model.addAttribute("conversionParams", conversionParams);
	}
	
	@RequestMapping(value = "/showConversionParam")
	public void showConversionParam(String conversionParamId, Model model) {
		ConversionParam conversionParam = conversionParamService.getConversionParam(conversionParamId);
		model.addAttribute("conversionParam", conversionParam);
	}
	
	@RequestMapping(value = "/selectConversionParam")
	public void selectConversionParam(Model model) {
		List<ConversionParam> conversionParams = new ArrayList<ConversionParam>();
		try {
			conversionParams = conversionParamService.getConversionParams();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("conversionParams", conversionParams);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveConversionParam")
	public SuccessOrFailure saveConversionParam(ConversionParam conversionParam){
		try {
			conversionParamService.saveConversionParam(conversionParam);
			return SuccessOrFailure.SUCCESS(conversionParam.getConversionParamId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteConversionParam")
	public SuccessOrFailure deleteConversionParam(String conversionParamId){
		try {
			conversionParamService.deleteConversionParam(conversionParamId);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value="/getConverArea")
	@ResponseBody
	public SuccessOrFailure getConverArea(){
		try {
			return SuccessOrFailure.SUCCESS(conversionParamService.getGisutilityConversions());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value="/getConversionById")
	@ResponseBody
	public SuccessOrFailure getConversionById(String id){
		try {
			return SuccessOrFailure.SUCCESS(conversionParamService.getGisutilityConversionById(id));
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}	
	}
}
