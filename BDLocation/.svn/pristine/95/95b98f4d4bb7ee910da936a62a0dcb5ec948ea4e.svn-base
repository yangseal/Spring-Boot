package com.cnten.bdlocation.baseStation.distribution.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.baseStation.distribution.service.BaseDistributeOverviewService;

@Controller
public class BaseDistributeOverviewController {
	
	@Autowired
	private BaseDistributeOverviewService baseDistributeOverviewService;
	
	@RequestMapping(value="/baseStation/distribution/showDistributeOverview")
	public void showDistributeOverview(){
	}
	
	@RequestMapping(value="/baseStation/distribution/showProvinceStatistics")
	public void showProvinceStatistics(){
	}
	
	/**
	 * 获取--基站分布数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/baseStation/distribution/getBaseDistributes")
	public Map<String,Object> getBaseDistrubutes(){
		return baseDistributeOverviewService.getDistributes();
	}
	
	
	/**
	 * 获取 -- 省份基站分布
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/baseStation/distribution/getBaseStationProvince")
	public List<Map<String, Object>> getBaseStationProvince(){
		return baseDistributeOverviewService.getBaseStationProvince();
	}
	
	/**
	 * 获取 -- 城市基站个数
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/baseStation/distribution/getBaseStationCitys")
	public List<Map<String, Object>> getBaseStationCitys(){
		return baseDistributeOverviewService.getBaseStationCitys();
	}
}
