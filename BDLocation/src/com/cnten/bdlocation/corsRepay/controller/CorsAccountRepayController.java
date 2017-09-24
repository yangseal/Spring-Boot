package com.cnten.bdlocation.corsRepay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.corsRepay.service.CorsAccountRepayService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.CorsAccountRepay;

@Controller
@RequestMapping(value = "/corsRepay")
public class CorsAccountRepayController {
	
	@Autowired
	private CorsAccountRepayService corsAccountRepayService;
	
	@RequestMapping(value = "/showRepays")
	public void showRepays(){
		
	}
	
	@RequestMapping(value = "/queryRepays")
	public void queryCorsRepays(CorsAccountRepay corsAccountRepay, Integer pageIndex, Integer pageSize, Model model){
		Page page = corsAccountRepayService.getRepaysByPage(corsAccountRepay, pageIndex, pageSize);
		model.addAttribute(page);
	}

	@ResponseBody
	@RequestMapping(value = "/corsRepayActive")
	public SuccessOrFailure corsRepayActive(String corsRepayId){
		try {
			corsAccountRepayService.updateRepayActive(corsRepayId);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
}
