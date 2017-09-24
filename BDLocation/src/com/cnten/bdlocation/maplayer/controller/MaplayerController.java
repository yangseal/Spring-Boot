package com.cnten.bdlocation.maplayer.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.maplayer.service.MaplayerService;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.Maplayer;


@Controller
public class MaplayerController {
	@Autowired
	private MaplayerService maplayerService;
	
	@ResponseBody
	@RequestMapping(value="/maplayer/queryMapURLByCompanyID")
	public SuccessOrFailure queryMapURLByCompanyID(Maplayer maplayer) {
		if(maplayer == null 
				|| StringUtils.isBlank(maplayer.getCompanyId())
				|| StringUtils.isBlank(maplayer.getLayerType())) {
			return SuccessOrFailure.FAILURE("参数错误");
		}
		try {
			return SuccessOrFailure.SUCCESS(maplayerService.getMapURLByCompanyID(maplayer));
		} catch(Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
}
