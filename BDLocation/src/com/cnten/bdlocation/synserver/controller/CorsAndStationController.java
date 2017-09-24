package com.cnten.bdlocation.synserver.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.cnten.bdlocation.synserver.service.CorsAndStationService;

/**
 * cors 、station 实时数据展示、 分析数据展示
 * @author Administrator
 */
@Controller
public class CorsAndStationController {
	
	@Autowired
	private CorsAndStationService corsAndStationService;

	@RequestMapping(value="statistic/realtime/showCorsReal")
	public void corsRealTimeDisplay(Model model){
		if(SyncDataBdserverController.corsList != null)
			model.addAttribute("corsRealList", SyncDataBdserverController.corsList);
		//System.out.println("==corsRealTimeDisplay=====corslist:" + SyncDataBdserverController.corsList);
	}
	
	@RequestMapping(value="statistic/realtime/showStationReal")
	public void stationRealTimeDispaly(Model model){
		if(SyncDataBdserverController.stationList != null){
			model.addAttribute("stationRealList", SyncDataBdserverController.stationList);
		}
	}
	
	
	@RequestMapping(value="statistic/realtime/showStationRunState")
	public void showStationRunState(){
	}
	
	/**
	 * 获取基站  位置  及状态
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value="statistic/getStationRunState")
	public List<Map<String, Object>> getBaseStationWithState(){
		return corsAndStationService.getStationOfChecked();
	}
}
