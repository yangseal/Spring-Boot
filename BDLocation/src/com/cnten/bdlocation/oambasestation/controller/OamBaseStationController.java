package com.cnten.bdlocation.oambasestation.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.cnten.bdlocation.oambasestation.service.OamBaseStationService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.OamBaseStation;
import com.cnten.po.OamProject;
import com.cnten.vo.OamBaseStationVO;

@Controller
@RequestMapping(value = "/oamBaseStation")
public class OamBaseStationController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	private OamBaseStationService oamBaseStationService;
	
	@RequestMapping(value = "/showOamBaseStations")
	public void showOamBaseStations() {
	}
	
	@RequestMapping(value = "/showOamBaseStation")
	public void showOamBaseStation(String oamBaseStationId, Model model) {
		OamBaseStation oamBaseStation = oamBaseStationService.getOamBaseStation(oamBaseStationId);
		model.addAttribute("oamBaseStation", oamBaseStation);
	}
	
	@RequestMapping(value = "/queryOamBaseStations")
	public void queryOamBaseStations(OamBaseStation oamBaseStation, Integer pageIndex, Integer pageSize, Model model) {
		Page page = oamBaseStationService.getOamBaseStationsPage(oamBaseStation, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "/selectOamBaseStation")
	public void selectOamBaseStation() {
	}
	
	@RequestMapping(value = "/selectOamBaseStations")
	public void selectOamBaseStations(String oamAreaId,OamBaseStation oamBaseStation, Integer pageIndex, Integer pageSize, Model model) {
		oamBaseStation.getOamArea().setOamAreaId(oamAreaId);
		Page page = oamBaseStationService.getOamBaseStationsPage(oamBaseStation, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOamBaseStation")
	public SuccessOrFailure saveOamBaseStation(OamBaseStation oamBaseStation){
		try {
			oamBaseStationService.saveOamBaseStation(oamBaseStation);
			return SuccessOrFailure.SUCCESS(oamBaseStation.getOamBaseStationId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteOamBaseStation")
	public SuccessOrFailure deleteOamBaseStation(String oamBaseStationIds){
		try {
			oamBaseStationService.deleteOamBaseStation(oamBaseStationIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/exportOamBaseStations")
	public void exportOamBaseStations(OamBaseStation oamBaseStation, HttpServletResponse response) {
		try {
			oamBaseStationService.exportOamBaseStations(oamBaseStation, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value = "/getStationsMobile")
	public @ResponseBody Map<String, Object> getStations(String oamAreaId){
		if(null == oamAreaId)
			return null;
		Map<String, Object> result = new HashMap<String, Object>();
		List<OamBaseStation> list = oamBaseStationService.getOamBaseStations(oamAreaId);
		result.put("stations",list);
		return result;
	}
	
	
	@RequestMapping(value = "/getMonitorStationsMobile")
	public @ResponseBody Map<String, Object> getMonitorStations(String oamAreaId){
		if(null == oamAreaId)
			return null;
		Map<String, Object> result = new HashMap<String, Object>();
		List<OamBaseStation> list = oamBaseStationService.getMonitorStations(oamAreaId);
		for(OamBaseStation oamBaseStation : list) {
			if(null == oamBaseStation.getOamProject()) {
				oamBaseStation.setOamProject(new OamProject());
			}
		}
		result.put("stations", list);

		return result;
	}
	
	
	@RequestMapping(value = "/getStationVOMobile")
	public @ResponseBody OamBaseStationVO getStationVO(String oamBaseStationId){
		if(null == oamBaseStationId)
			return null;
		return oamBaseStationService.getOamBaseStationVO(oamBaseStationId);
	}
	
	
	/**
	 * 保存基站信息
	 * @param stationVO
	 * @return
	 */
	@RequestMapping(value = "/saveStationVOMobile")
	public @ResponseBody SuccessOrFailure saveStationVO(OamBaseStationVO stationVO) {
		try {
			oamBaseStationService.saveStationVO(stationVO);
			return SuccessOrFailure.SUCCESS(stationVO.getOamBaseStationId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
}
