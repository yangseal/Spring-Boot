package com.cnten.bdlocation.oamprojectconstruction.controller;

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
import com.cnten.bdlocation.oamprojectconstruction.service.OamProjectConstructionService;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.OamProjectConstruction;

@Controller
@RequestMapping(value = "/oamProjectConstruction")
public class OamProjectConstructionController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	private OamProjectConstructionService oamProjectConstructionService;
	
	@RequestMapping(value = "/showOamProjectConstructions")
	public void showOamProjectConstructions() {
	}
	
	@RequestMapping(value = "/showOamProjectConstruction")
	public void showOamProjectConstruction(String oamProjectConstructionId, Model model) {
		OamProjectConstruction oamProjectConstruction = oamProjectConstructionService.getOamProjectConstruction(oamProjectConstructionId);
		model.addAttribute("oamProjectConstruction", oamProjectConstruction);
	}
	
	@RequestMapping(value = "/queryOamProjectConstructions")
	public void queryOamProjectConstructions(OamProjectConstruction oamProjectConstruction, Integer pageIndex, Integer pageSize, Model model) {
		Page page = oamProjectConstructionService.getOamProjectConstructionsPage(oamProjectConstruction, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "/selectOamProjectConstruction")
	public void selectOamProjectConstruction() {
	}
	
	@RequestMapping(value = "/selectOamProjectConstructions")
	public void selectOamProjectConstructions(OamProjectConstruction oamProjectConstruction, Integer pageIndex, Integer pageSize, Model model) {
		Page page = oamProjectConstructionService.getOamProjectConstructionsPage(oamProjectConstruction, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOamProjectConstruction")
	public SuccessOrFailure saveOamProjectConstruction(OamProjectConstruction oamProjectConstruction){
		try {
			oamProjectConstructionService.saveOamProjectConstruction(oamProjectConstruction);
			return SuccessOrFailure.SUCCESS(oamProjectConstruction.getOamProjectConstructionId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteOamProjectConstruction")
	public SuccessOrFailure deleteOamProjectConstruction(String oamProjectConstructionIds){
		try {
			oamProjectConstructionService.deleteOamProjectConstruction(oamProjectConstructionIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/exportOamProjectConstructions")
	public void exportOamProjectConstructions(OamProjectConstruction oamProjectConstruction, HttpServletResponse response) {
		try {
			oamProjectConstructionService.exportOamProjectConstructions(oamProjectConstruction, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
