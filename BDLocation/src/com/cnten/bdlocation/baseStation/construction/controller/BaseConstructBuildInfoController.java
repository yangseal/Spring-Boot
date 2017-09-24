package com.cnten.bdlocation.baseStation.construction.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.baseStation.construction.service.BaseConstructService;
import com.cnten.bdlocation.constants.BaseStationConsts;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.BaseAddress;
import com.cnten.po.BaseCheckMatetial;
import com.cnten.po.BaseConstruct;
import com.cnten.po.BaseMaterial;
import com.cnten.po.BaseStationTest;

@Controller
@RequestMapping(value="/baseStation/construction")
public class BaseConstructBuildInfoController {
	@Autowired
	private BaseConstructService baseConstructService;
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(value="/showEditConstructs")
	public void showEditConstructs(){
	}
	
	@RequestMapping(value="/queryEditConstructs")
	public void queryEditContructs(BaseConstruct baseConstruct, Integer pageIndex, Integer pageSize, Model model){
		baseConstruct.setSendDownState(BaseStationConsts.BASE_STATION_TASK_SENDDOWNED);
		Page page = baseConstructService.getConstructByPage(baseConstruct, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value="/showConstructBuildInfo")
	public void showConstructBuildInfo(String baseConstructId, Model model){
		BaseConstruct baseConstruct = baseConstructService.getConstruct(baseConstructId);
		model.addAttribute("baseConstruct", baseConstruct);
	}
	
	@RequestMapping(value="/showBaseStationDetail")
	public void showBaseStationDetail(String baseConstructId, Model model){
		Map<String, Object> baseStationDetail = baseConstructService.getBaseStationDetail(baseConstructId);
		model.addAttribute("baseConstruct", baseStationDetail);
	}
	
	@RequestMapping(value="/showAddressInput")
	public void showAddressInput(String baseConstructId, Model model){
		BaseAddress baseAddress = baseConstructService.getBaseAddress(baseConstructId);
		model.addAttribute("baseAddress", baseAddress);
	}
	
	@RequestMapping(value="/showBuildInfoInput")
	public void showBuildInfoInput(String baseConstructId, Model model){
		BaseMaterial baseMaterial = baseConstructService.getBaseMaterial(baseConstructId);
		model.addAttribute("baseMaterial", baseMaterial);
	}
	
	@RequestMapping(value="/showTestInfoInput")
	public void showTestInfoInput(String baseConstructId, Model model){
		BaseStationTest baseStationTest = baseConstructService.getBaseStationTest(baseConstructId);
		model.addAttribute("baseStationTest", baseStationTest);
	}
	
	@RequestMapping(value="/showValidateInfoInput")
	public void showValidateInfoInput(String baseConstructId, Model model){
		BaseCheckMatetial baseCheckMatetial = baseConstructService.getBaseCheckMatetial(baseConstructId);
		model.addAttribute("baseCheckMatetial", baseCheckMatetial);
	}

	@ResponseBody
	@RequestMapping(value="/saveBuildInfo")
	public SuccessOrFailure saveBuildInfo(BaseMaterial baseMaterial){
		try {
			baseConstructService.saveBuildInfo(baseMaterial);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/saveBaseCheckMaterial")
	public SuccessOrFailure saveBaseCheckMaterial(BaseCheckMatetial baseCheckMatetial){
		try {
			baseConstructService.saveBaseCheckMaterial(baseCheckMatetial);
			return SuccessOrFailure.SUCCESS;
			
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/saveBaseAddress")
	public SuccessOrFailure saveBaseAddress(BaseAddress baseAddress){
		try {
			baseConstructService.saveBaseAddress(baseAddress);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	//保存测试资料
	@ResponseBody
	@RequestMapping(value="/saveBaseStationTest")
	public SuccessOrFailure saveBaseStationTest(BaseStationTest baseStationTest){
		try {
			baseConstructService.saveBaseStationTest(baseStationTest);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
}
