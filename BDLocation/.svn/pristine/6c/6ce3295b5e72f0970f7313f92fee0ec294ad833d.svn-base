package com.cnten.bdlocation.synserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.cnten.bdlocation.synserver.service.SyncDataBdserverService;
import com.cnten.platform.dwr.DwrPushMessager;
import com.cnten.vo.ParamVO;

@Controller
public class SyncDataBdserverController {
	
	@Autowired
	private SyncDataBdserverService syncDataBdserverService;
	
	public static JSONArray corsList = null;
	public static JSONArray stationList = null;
	
	
	/**
	 * 接收 cors 实时接入　数据
	 * @param paramVo
	 */
	@RequestMapping(value="/bdloc/realtime/corsdata")
	public void receiveCorsRealTimeData(ParamVO paramVo){
		System.out.println("==receiveCorsRealTimeData=====corslist:" + paramVo.getList());
		try {
			corsList = syncDataBdserverService.getCorsRealLogsAfterDeal(paramVo.getListJson());
			DwrPushMessager.invokeJavascriptFunction("showCorsRealMessage",corsList);
		} catch (Exception e) {}
	}
	
	/**
	 * 接收 station(基站)实时运行数据
	 * @param paramVo
	 */
	@RequestMapping(value="/bdloc/realtime/stationdata")
	public void receiveBdStationRealTimeData(ParamVO paramVo){
		//stationList = paramVo.getListJson();
		System.out.println("==receiveBdStationRealTimeData=====station:" + paramVo.getMap());
		stationList = syncDataBdserverService.getStationRealLogsAfterDeal(paramVo.getMapJson());
		try {
			DwrPushMessager.invokeJavascriptFunction("showStationRealMessage",stationList);
		} catch (Exception e) {}
	}

}
