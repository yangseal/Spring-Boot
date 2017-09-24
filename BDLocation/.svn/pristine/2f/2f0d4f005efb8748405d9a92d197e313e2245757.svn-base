package com.cnten.bdlocation.measurepoint.controller;

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

import com.cnten.bdlocation.measurepoint.service.MeasurePointService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.MeasurePoint;

@Controller
public class MeasurePointController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	private MeasurePointService measurePointService;
	
	@RequestMapping(value = "/measurePoint/showMeasurePoints")
	public void showMeasurePoints() {
	}
	
	@RequestMapping(value = "/measurePoint/showMeasurePoint")
	public void showMeasurePoint(String measurePointId, Model model) {
		MeasurePoint measurePoint = measurePointService.getMeasurePoint(measurePointId);
		model.addAttribute("measurePoint", measurePoint);
	}
	
	@RequestMapping(value = "/measurePoint/queryMeasurePoints")
	public void queryMeasurePoints(MeasurePoint measurePoint,Integer pageIndex, Integer pageSize, Model model) {
		Page page = measurePointService.getMeasurePointsPage(measurePoint, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "/measurePoint/selectMeasurePoint")
	public void selectMeasurePoint() {
	}
	
	@RequestMapping(value = "/measurePoint/selectMeasurePoints")
	public void selectMeasurePoints(MeasurePoint measurePoint, Integer pageIndex, Integer pageSize, Model model) {
		Page page = measurePointService.getMeasurePointsPage(measurePoint, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/measurePoint/saveMeasurePoint")
	public SuccessOrFailure saveMeasurePoint(MeasurePoint measurePoint){
		try {
			measurePointService.saveMeasurePoint(measurePoint);
			return SuccessOrFailure.SUCCESS(measurePoint.getMeasurePointId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/measurePoint/deleteMeasurePoint")
	public SuccessOrFailure deleteMeasurePoint(String measurePointIds){
		try {
			measurePointService.deleteMeasurePoint(measurePointIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/measurePoint/exportMeasurePoints")
	public void exportMeasurePoints(MeasurePoint measurePoint, HttpServletResponse response) {
		try {
			measurePointService.exportMeasurePoints(measurePoint, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/measurePoint/measurePointMap")
	public void measurePointMap() {
		
	}
	
	@ResponseBody
	@RequestMapping(value="/accuratePosition/getLngLatByIds")
	public List<MeasurePoint> getLngLatByIds(String selectPoints,MeasurePoint point){
		return measurePointService.getLngLatByIds(selectPoints);
	}
	
}
