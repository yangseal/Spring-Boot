package com.cnten.bdlocation.pointtype.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import com.alibaba.fastjson.JSONObject;
import com.cnten.platform.dao.Page;
import com.cnten.bdlocation.pointtype.service.PointTypeService;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.PointType;

@Controller
public class PointTypeController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	private PointTypeService pointTypeService;
	
	@RequestMapping(value = "/pointType/showPointTypes")
	public void showPointTypes() {
	}
	
	@RequestMapping(value = "/pointType/showPointType")
	public void showPointType(String pointTypeId, Model model) {
		PointType pointType = pointTypeService.getPointType(pointTypeId);
		model.addAttribute("pointType", pointType);
	}
	
	@RequestMapping(value = "/pointType/queryPointTypes")
	public void queryPointTypes(PointType pointType, Integer pageIndex, Integer pageSize, Model model) {
		Page page = pointTypeService.getPointTypesPage(pointType, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "/pointType/selectPointType")
	public void selectPointType() {
	}
	
	@RequestMapping(value = "/pointType/selectPointTypes")
	public void selectPointTypes(PointType pointType, Integer pageIndex, Integer pageSize, Model model) {
		Page page = pointTypeService.getPointTypesPage(pointType, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@ResponseBody
	@RequestMapping(value = "/pointType/savePointType")
	public SuccessOrFailure savePointType(PointType pointType){
		try {
			pointTypeService.savePointType(pointType);
			return SuccessOrFailure.SUCCESS(pointType.getPointTypeId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/pointType/deletePointType")
	public SuccessOrFailure deletePointType(String pointTypeIds){
		try {
			pointTypeService.deletePointType(pointTypeIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/pointType/exportPointTypes")
	public void exportPointTypes(PointType pointType, HttpServletResponse response) {
		try {
			pointTypeService.exportPointTypes(pointType, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/pointType/getPointTypes")
	public List<PointType> getPointTypes() {
		return pointTypeService.getPointTypes();
	}
	
	//added by lanj 通过企业过滤点类型
	@ResponseBody
	@RequestMapping(value="/pointType/getPointTypesByCompanyId")
	public SuccessOrFailure getPointTypesByCompanyId(String companyId) {
		try {
			return SuccessOrFailure.SUCCESS(pointTypeService.getPointTypesByCompanyId(companyId));
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/pointType/showDynamicFields")
	public void showDynamicFields(){
	}
	
	@RequestMapping(value = "/pointType/queryDynamicFields")
	public void queryDynamicFields(String pointTypeId, Integer pageIndex, Integer pageSize, Model model){
		if(pointTypeId.contains("isQuery")) {
			pointTypeId = pointTypeId.substring(25);
		} else {
			pointTypeId = pointTypeId.substring(12);
		}
		Page page = pointTypeService.queryDynamicFields(pointTypeId, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "/pointType/showDynamicField")
	public void showDynamicField(String pointTypeId, String dataCode, Model model){
		JSONObject dynamicField = pointTypeService.getDynamicField(pointTypeId, dataCode);
		model.addAttribute("dynamicField", dynamicField);
		model.addAttribute("pointTypeId", pointTypeId);
	}
	
	@ResponseBody
	@RequestMapping(value = "/pointType/saveDynamicField")
	public SuccessOrFailure saveDynamicField(String dynamicField, String pointTypeId) {
		try {
			return SuccessOrFailure.SUCCESS(pointTypeService.saveDynamicField(dynamicField, pointTypeId));
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/pointType/editDynamicField")
	public SuccessOrFailure saveEditDynamicField(String dynamicField, String pointTypeId) {
		try {
			return SuccessOrFailure.SUCCESS(pointTypeService.saveEditDynamicField(dynamicField, pointTypeId));
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/pointType/deleteDynamicField")
	public SuccessOrFailure deleteDynamicField(String dataCodes, String pointTypeId) {
		try {
			return SuccessOrFailure.SUCCESS(pointTypeService.deleteDynamicField(dataCodes,pointTypeId));
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
}
