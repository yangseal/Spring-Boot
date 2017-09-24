package com.cnten.bdlocation.statistic.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cnten.bdlocation.statistic.service.CorsAndStationUseSituationService;

@Controller
public class CorsAndStationUseSituationController {
	
	@Autowired
	private CorsAndStationUseSituationService corsAndStationUseSituationService;

	@RequestMapping(value="statistic/cors/showCorsSituation")
	public void showCorsUseSituation(){
	}
	
	@RequestMapping(value="statistic/station/showStationSituation")
	public void showStationSituation(){
	}
	
	@ResponseBody
	@RequestMapping(value="statistic/station/getCorsUseSituation")
	public Map<String,Object> getCorsUseSituation(String daystr){
		Map<String,Object> rlt = new HashMap<String,Object>();
		List<Map<String,Object>> corsDaySituation = corsAndStationUseSituationService.getCorsDayUseSituation(daystr);
		rlt.put("corsDaySituation", corsDaySituation);
		List<Map<String,Object>> corsMonthSituation = corsAndStationUseSituationService.getCorsMonthUseSituation(daystr);
		rlt.put("corsMonthSituation", corsMonthSituation);
		return rlt;
	}
	
	@ResponseBody
	@RequestMapping(value="statistic/station/getStationUseStation")
	public Map<String,Object> getStationUseStation(String daystr){
		Map<String,Object> rlt = new HashMap<String,Object>();
		List<Map<String,Object>> stationDaySituation = corsAndStationUseSituationService.getStationDayUseSituation(daystr);
		rlt.put("stationDaySituation", stationDaySituation);
		List<Map<String,Object>> stationMonthSituation = corsAndStationUseSituationService.getStationMonthUseSituation(daystr);
		rlt.put("stationMonthSituation", stationMonthSituation);
		return rlt;
	}
	
	
}
