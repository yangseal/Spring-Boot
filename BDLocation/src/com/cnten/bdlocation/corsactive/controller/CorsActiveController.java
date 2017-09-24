package com.cnten.bdlocation.corsactive.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.corsactive.service.CorsActiveService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.CorsAccountActive;

@Controller
@RequestMapping(value="/corsActive")
public class CorsActiveController {
	@Autowired
	private CorsActiveService corsActiveService;
	
	@RequestMapping(value="/showActives")
	public void showActives(){
	}
	
	@RequestMapping(value="/queryActives")
	public void queryActives(CorsAccountActive corsActive, Integer pageIndex, Integer pageSize, Model model){
		Page page = corsActiveService.getActiveByPage(corsActive,pageIndex,pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value="/showAccounts")
	public void queryAccounts(String corsActiveId,String corsActiveType,Integer pageIndex, Integer pageSize, Model model) {
		Page page = corsActiveService.getCorsAccountActive(corsActiveId,pageIndex,pageSize);
		HashMap<String,Object> _m = new HashMap<String,Object>();
		_m.put("corsActiveId",corsActiveId);
		_m.put("corsActiveType",corsActiveType);
		model.addAllAttributes(_m);
		model.addAttribute(page);
	}
	
	@ResponseBody
	@RequestMapping(value="/activeAccounts")
	public SuccessOrFailure accountActive(String corsActiveId,String corsAccountIds,String corsActiveType){
		SuccessOrFailure rlt = corsActiveService.updateAccountActive(corsActiveId,corsAccountIds,corsActiveType);
		if(rlt != null) return rlt;
		return SuccessOrFailure.FAILURE("操作失败");
	}
}
