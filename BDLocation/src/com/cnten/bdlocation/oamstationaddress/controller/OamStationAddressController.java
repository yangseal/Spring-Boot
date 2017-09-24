package com.cnten.bdlocation.oamstationaddress.controller;

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

import com.cnten.bdlocation.oamstationaddress.service.OamStationAddressService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.OamStationAddress;

@Controller
@RequestMapping(value = "/oamStationAddress")
public class OamStationAddressController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	private OamStationAddressService oamStationAddressService;
	
	@RequestMapping(value = "/showOamStationAddresss")
	public void showOamStationAddresss() {
	}
	
	@RequestMapping(value = "/showOamStationAddress")
	public void showOamStationAddress(String oamStationAddressId, Model model) {
		OamStationAddress oamStationAddress = oamStationAddressService.getOamStationAddress(oamStationAddressId);
		model.addAttribute("oamStationAddress", oamStationAddress);
	}
	
	@RequestMapping(value = "/queryOamStationAddresss")
	public void queryOamStationAddresss(OamStationAddress oamStationAddress, Integer pageIndex, Integer pageSize, Model model) {
		Page page = oamStationAddressService.getOamStationAddresssPage(oamStationAddress, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "/selectOamStationAddress")
	public void selectOamStationAddress() {
	}
	
	@RequestMapping(value = "/selectOamStationAddresss")
	public void selectOamStationAddresss(OamStationAddress oamStationAddress, Integer pageIndex, Integer pageSize, Model model) {
		Page page = oamStationAddressService.getOamStationAddresssPage(oamStationAddress, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOamStationAddress")
	public SuccessOrFailure saveOamStationAddress(OamStationAddress oamStationAddress){
		try {
			oamStationAddressService.saveOamStationAddress(oamStationAddress);
			return SuccessOrFailure.SUCCESS(oamStationAddress.getOamStationAddressId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteOamStationAddress")
	public SuccessOrFailure deleteOamStationAddress(String oamStationAddressIds){
		try {
			oamStationAddressService.deleteOamStationAddress(oamStationAddressIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/exportOamStationAddresss")
	public void exportOamStationAddresss(OamStationAddress oamStationAddress, HttpServletResponse response) {
		try {
			oamStationAddressService.exportOamStationAddresss(oamStationAddress, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
