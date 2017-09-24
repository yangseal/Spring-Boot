package com.cnten.bdlocation.oamcontacts.controller;

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
import com.cnten.bdlocation.oamcontacts.service.OamContactsService;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.OamContacts;

@Controller
@RequestMapping(value = "/oamContacts")
public class OamContactsController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	private OamContactsService oamContactsService;
	
	@RequestMapping(value = "/showOamContactss")
	public void showOamContactss() {
	}
	
	@RequestMapping(value = "/showOamContacts")
	public void showOamContacts(String oamContactsId, Model model) {
		OamContacts oamContacts = oamContactsService.getOamContacts(oamContactsId);
		model.addAttribute("oamContacts", oamContacts);
	}
	
	@RequestMapping(value = "/queryOamContactss")
	public void queryOamContactss(OamContacts oamContacts, Integer pageIndex, Integer pageSize, Model model) {
		Page page = oamContactsService.getOamContactssPage(oamContacts, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "/selectOamContacts")
	public void selectOamContacts() {
	}
	
	@RequestMapping(value = "/selectOamContactss")
	public void selectOamContactss(OamContacts oamContacts, Integer pageIndex, Integer pageSize, Model model) {
		Page page = oamContactsService.getOamContactssPage(oamContacts, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOamContacts")
	public SuccessOrFailure saveOamContacts(OamContacts oamContacts){
		try {
			oamContactsService.saveOamContacts(oamContacts);
			return SuccessOrFailure.SUCCESS(oamContacts.getOamContactsId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteOamContacts")
	public SuccessOrFailure deleteOamContacts(String oamContactsIds){
		try {
			oamContactsService.deleteOamContacts(oamContactsIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/exportOamContactss")
	public void exportOamContactss(OamContacts oamContacts, HttpServletResponse response) {
		try {
			oamContactsService.exportOamContactss(oamContacts, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
