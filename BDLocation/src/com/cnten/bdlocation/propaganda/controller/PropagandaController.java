package com.cnten.bdlocation.propaganda.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cnten.bdlocation.constants.CorsAccountConsts;

@Controller
@RequestMapping(value="/propagandas")
public class PropagandaController {
	
	@RequestMapping(value="/testServiceApply")
	public void testServiceApply(String serviceType,String productType,Model model){
		HashMap<String,String> params = new HashMap<String,String>();
		if(productType.equals(CorsAccountConsts.ACCOUNT_NET_PRECISION_mi)){
			params.put("serviceTypeName", "米级服务");
			params.put("serviceType", CorsAccountConsts.ACCOUNT_NET_PRECISION_mi);
		} else if(productType.equals(CorsAccountConsts.ACCOUNT_NET_PRECISION_meter)){
			params.put("serviceTypeName", "亚米级服务");
			params.put("serviceType", CorsAccountConsts.ACCOUNT_NET_PRECISION_meter);
		} else if(productType.equals(CorsAccountConsts.ACCOUNT_NET_PRECISION_centimeter)){
			params.put("serviceTypeName", "厘米级服务");
			params.put("serviceType", CorsAccountConsts.ACCOUNT_NET_PRECISION_centimeter);
		}
		model.addAllAttributes(params);
	}
	
	@RequestMapping(value="/product_serve_DIFF_CM")
	public void product_serve_DIFF_CM(){}
	
	@RequestMapping(value="/product_serve_DIFF_yami")
	public void product_serve_DIFF_yami(){}
	
	@RequestMapping(value="/product_serve_DIFF_meter")
	public void product_serve_DIFF_meter(){}
	
	@RequestMapping(value="/product_serve_RTK")
	public void product_serve_RTK(){}
	
	@RequestMapping(value="/product_serve_differencePhone")
	public void product_serve_differencePhone(){}
	
	@RequestMapping(value="/product_serve_LocationBox")
	public void product_serve_LocationBox(){}
	
	@RequestMapping(value="/case1")
	public void case1(){}
	
	@RequestMapping(value="/case_drain")
	public void case_drain(){}
	
	@RequestMapping(value="/case_antiseptic")
	public void case_antiseptic(){}
	
	@RequestMapping(value="/case_inspection")
	public void case_inspection(){}
	
	@RequestMapping(value="/case_jingzhou")
	public void case_jingzhou(){}
	
	@RequestMapping(value="/case_trailer")
	public void case_trailer(){}
	
	@RequestMapping(value="/product_serve_locationPanel")
	public void product_serve_locationPanel(){}
	
	@RequestMapping(value="/about")
	public void about(){}
	
	@RequestMapping(value="/about_contactUs")
	public void about_contactUs(){}
	
	@RequestMapping(value="/about_maintenanceUnit")
	public void about_maintenanceUnit(){}
	
	@RequestMapping(value="/about_positionAlliance")
	public void about_positionAlliance(){}
	
	@RequestMapping(value="/scheme_cityDrain")
	public void scheme_cityDrain(){}
	
	@RequestMapping(value="/scheme_cityGas")
	public void scheme_cityGas(){}
	
	@RequestMapping(value="/scheme_cityPower")
	public void scheme_cityPower(){}
	
	@RequestMapping(value="/scheme_heatAddition")
	public void scheme_heatAddition(){}
	
	@RequestMapping(value="/service_support")
	public void service_support(){}
	
	@RequestMapping(value="")
	public String propagandas(){
		return "/propagandas/index";
	}
	
}
