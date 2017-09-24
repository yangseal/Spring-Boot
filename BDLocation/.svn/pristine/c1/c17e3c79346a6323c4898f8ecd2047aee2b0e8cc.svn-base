package com.cnten.bdlocation.oamprojecttesting.controller;

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
import com.cnten.bdlocation.oamprojecttesting.service.OamProjectTestingService;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.OamProjectTesting;

@Controller
@RequestMapping(value = "/oamProjectTesting")
public class OamProjectTestingController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	private OamProjectTestingService oamProjectTestingService;
	
	@RequestMapping(value = "/showOamProjectTestings")
	public void showOamProjectTestings() {
	}
	
	@RequestMapping(value = "/showOamProjectTesting")
	public void showOamProjectTesting(String oamProjectTestingId, Model model) {
		OamProjectTesting oamProjectTesting = oamProjectTestingService.getOamProjectTesting(oamProjectTestingId);
		model.addAttribute("oamProjectTesting", oamProjectTesting);
	}
	
	@RequestMapping(value = "/queryOamProjectTestings")
	public void queryOamProjectTestings(OamProjectTesting oamProjectTesting, Integer pageIndex, Integer pageSize, Model model) {
		Page page = oamProjectTestingService.getOamProjectTestingsPage(oamProjectTesting, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "/selectOamProjectTesting")
	public void selectOamProjectTesting() {
	}
	
	@RequestMapping(value = "/selectOamProjectTestings")
	public void selectOamProjectTestings(OamProjectTesting oamProjectTesting, Integer pageIndex, Integer pageSize, Model model) {
		Page page = oamProjectTestingService.getOamProjectTestingsPage(oamProjectTesting, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOamProjectTesting")
	public SuccessOrFailure saveOamProjectTesting(OamProjectTesting oamProjectTesting){
		try {
			oamProjectTestingService.saveOamProjectTesting(oamProjectTesting);
			return SuccessOrFailure.SUCCESS(oamProjectTesting.getOamProjectTestingId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteOamProjectTesting")
	public SuccessOrFailure deleteOamProjectTesting(String oamProjectTestingIds){
		try {
			oamProjectTestingService.deleteOamProjectTesting(oamProjectTestingIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/exportOamProjectTestings")
	public void exportOamProjectTestings(OamProjectTesting oamProjectTesting, HttpServletResponse response) {
		try {
			oamProjectTestingService.exportOamProjectTestings(oamProjectTesting, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
