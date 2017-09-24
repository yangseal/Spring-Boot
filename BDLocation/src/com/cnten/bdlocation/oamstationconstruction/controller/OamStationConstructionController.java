package com.cnten.bdlocation.oamstationconstruction.controller;

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

import com.cnten.bdlocation.oamstationconstruction.service.OamStationConstructionService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.OamStationConstruction;

@Controller
@RequestMapping(value = "/oamStationConstruction")
public class OamStationConstructionController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	private OamStationConstructionService oamStationConstructionService;
	
	@RequestMapping(value = "/showOamStationConstructions")
	public void showOamStationConstructions() {
	}
	
	@RequestMapping(value = "/showOamStationConstruction")
	public void showOamStationConstruction(String oamStationConstructionId, Model model) {
		OamStationConstruction oamStationConstruction = oamStationConstructionService.getOamStationConstruction(oamStationConstructionId);
		model.addAttribute("oamStationConstruction", oamStationConstruction);
	}
	
	@RequestMapping(value = "/queryOamStationConstructions")
	public void queryOamStationConstructions(OamStationConstruction oamStationConstruction, Integer pageIndex, Integer pageSize, Model model) {
		Page page = oamStationConstructionService.getOamStationConstructionsPage(oamStationConstruction, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "/selectOamStationConstruction")
	public void selectOamStationConstruction() {
	}
	
	@RequestMapping(value = "/selectOamStationConstructions")
	public void selectOamStationConstructions(OamStationConstruction oamStationConstruction, Integer pageIndex, Integer pageSize, Model model) {
		Page page = oamStationConstructionService.getOamStationConstructionsPage(oamStationConstruction, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOamStationConstruction")
	public SuccessOrFailure saveOamStationConstruction(OamStationConstruction oamStationConstruction){
		try {
			oamStationConstructionService.saveOamStationConstruction(oamStationConstruction);
			return SuccessOrFailure.SUCCESS(oamStationConstruction.getOamStationConstructionId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteOamStationConstruction")
	public SuccessOrFailure deleteOamStationConstruction(String oamStationConstructionIds){
		try {
			oamStationConstructionService.deleteOamStationConstruction(oamStationConstructionIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/exportOamStationConstructions")
	public void exportOamStationConstructions(OamStationConstruction oamStationConstruction, HttpServletResponse response) {
		try {
			oamStationConstructionService.exportOamStationConstructions(oamStationConstruction, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/getStationConstructionMobile")
	public OamStationConstruction getStationConstruction(String oamBaseStationId){
		return oamStationConstructionService.getOamStationConstruction(oamBaseStationId);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveStationConstructionMobile")
	public SuccessOrFailure saveStationTest(OamStationConstruction oamStationConstruction) {
		try {
			oamStationConstructionService.saveOamStationConstruction(oamStationConstruction);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
}
