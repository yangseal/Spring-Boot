package com.cnten.bdlocation.oamstationtesting.controller;

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

import com.cnten.bdlocation.oamstationtesting.service.OamStationTestingService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.OamStationTesting;

@Controller
@RequestMapping(value = "/oamStationTesting")
public class OamStationTestingController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	private OamStationTestingService oamStationTestingService;
	
	@RequestMapping(value = "/showOamStationTestings")
	public void showOamStationTestings() {
	}
	
	@RequestMapping(value = "/showOamStationTesting")
	public void showOamStationTesting(String oamStationTestingId, Model model) {
		OamStationTesting oamStationTesting = oamStationTestingService.getOamStationTesting(oamStationTestingId);
		model.addAttribute("oamStationTesting", oamStationTesting);
	}
	
	@RequestMapping(value = "/queryOamStationTestings")
	public void queryOamStationTestings(OamStationTesting oamStationTesting, Integer pageIndex, Integer pageSize, Model model) {
		Page page = oamStationTestingService.getOamStationTestingsPage(oamStationTesting, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "/selectOamStationTesting")
	public void selectOamStationTesting() {
	}
	
	@RequestMapping(value = "/selectOamStationTestings")
	public void selectOamStationTestings(OamStationTesting oamStationTesting, Integer pageIndex, Integer pageSize, Model model) {
		Page page = oamStationTestingService.getOamStationTestingsPage(oamStationTesting, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOamStationTesting")
	public SuccessOrFailure saveOamStationTesting(OamStationTesting oamStationTesting){
		try {
			oamStationTestingService.saveOamStationTesting(oamStationTesting);
			return SuccessOrFailure.SUCCESS(oamStationTesting.getOamStationTestingId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteOamStationTesting")
	public SuccessOrFailure deleteOamStationTesting(String oamStationTestingIds){
		try {
			oamStationTestingService.deleteOamStationTesting(oamStationTestingIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/exportOamStationTestings")
	public void exportOamStationTestings(OamStationTesting oamStationTesting, HttpServletResponse response) {
		try {
			oamStationTestingService.exportOamStationTestings(oamStationTesting, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/getStationTestMobile")
	public OamStationTesting getStationTest(String oamStationTestingId){
		if(null == oamStationTestingId)
			return null;
		return oamStationTestingService.getOamStationTesting(oamStationTestingId);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveStationTestMobile")
	public SuccessOrFailure saveStationTest(OamStationTesting stationTest) {
		try {
			oamStationTestingService.saveStationTest(stationTest);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
}
