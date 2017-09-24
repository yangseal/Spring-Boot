package com.cnten.bdlocation.conversionprojection.controller;

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
import com.cnten.bdlocation.conversionprojection.service.ConversionProjectionService;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.ConversionProjection;

@Controller
@RequestMapping(value = "/conversionProjection")
public class ConversionProjectionController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	private ConversionProjectionService conversionProjectionService;
	
	@RequestMapping(value = "/showConversionProjections")
	public void showConversionProjections() {
	}
	
	@RequestMapping(value = "/showConversionProjection")
	public void showConversionProjection(String conversionProjectionId, Model model) {
		ConversionProjection conversionProjection = conversionProjectionService.getConversionProjection(conversionProjectionId);
		model.addAttribute("conversionProjection", conversionProjection);
	}
	
	@RequestMapping(value = "/queryConversionProjections")
	public void queryConversionProjections(ConversionProjection conversionProjection, Integer pageIndex, Integer pageSize, Model model) {
		Page page = conversionProjectionService.getConversionProjectionsPage(conversionProjection, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "/selectConversionProjection")
	public void selectConversionProjection() {
	}
	
	@RequestMapping(value = "/selectConversionProjections")
	public void selectConversionProjections(ConversionProjection conversionProjection, Integer pageIndex, Integer pageSize, Model model) {
		Page page = conversionProjectionService.getConversionProjectionsPage(conversionProjection, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveConversionProjection")
	public SuccessOrFailure saveConversionProjection(ConversionProjection conversionProjection){
		try {
			conversionProjectionService.saveConversionProjection(conversionProjection);
			return SuccessOrFailure.SUCCESS(conversionProjection.getConversionProjectionId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteConversionProjection")
	public SuccessOrFailure deleteConversionProjection(String conversionProjectionIds){
		try {
			conversionProjectionService.deleteConversionProjection(conversionProjectionIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/exportConversionProjections")
	public void exportConversionProjections(ConversionProjection conversionProjection, HttpServletResponse response) {
		try {
			conversionProjectionService.exportConversionProjections(conversionProjection, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
