package com.cnten.bdlocation.oamarea.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.oamarea.service.OamAreaService;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.OamArea;

@Controller
@RequestMapping(value = "/oamArea")
public class OamAreaController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@Autowired
	private OamAreaService oamAreaService;
	
	@RequestMapping(value = "/showOamAreas")
	public void showOamAreas(Model model) {
		List<OamArea> oamAreas = oamAreaService.getOamAreas();
		model.addAttribute("oamAreas", oamAreas);
	}
	
	@RequestMapping(value = "/showOamArea")
	public void showOamArea(String oamAreaId, Model model) {
		OamArea oamArea = oamAreaService.getOamArea(oamAreaId);
		model.addAttribute("oamArea", oamArea);
	}
	
	@ResponseBody
	@RequestMapping(value = "/client/definedOamArea")
	public List<String> selectOamAreaDefined() {
		return oamAreaService.getOamAreasVK();
	}
	
	@RequestMapping(value = "/selectOamArea")
	public void selectOamArea(Model model) {
		List<OamArea> oamAreas = oamAreaService.getOamAreas();
		model.addAttribute("oamAreas", oamAreas);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOamArea")
	public SuccessOrFailure saveOamArea(OamArea oamArea){
		try {
			oamAreaService.saveOamArea(oamArea);
			return SuccessOrFailure.SUCCESS(oamArea.getOamAreaId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteOamArea")
	public SuccessOrFailure deleteOamArea(String oamAreaId){
		try {
			oamAreaService.deleteOamArea(oamAreaId);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/getAreasMobile")
	public Map<String, Object> getAreas(){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("areas", oamAreaService.getOamAreas());
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getAreaVOsMobile")
	public Map<String, Object> getAreaVOs(){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("areaVOs", oamAreaService.getOamAreaVOs());
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getMonitorAreaVOsMobile")
	public Map<String, Object> getMonitorAreaVOs(){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("areaVOs", oamAreaService.getMonitorOamAreaVOs());
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getPCity")
	public Map<String, Object> getPCity(){
		return oamAreaService.getPCity();
	}
	
	@ResponseBody
	@RequestMapping(value = "/getAreaByPid")
	public List<Map<String, Object>> getAreaByPid(String pId){
		return oamAreaService.getAreaByPid(pId);
	}
}
