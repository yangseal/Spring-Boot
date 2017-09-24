package com.cnten.bdlocation.maplayer.service;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cnten.bdlocation.accountView.service.AccountViewService;
import com.cnten.bdlocation.maplayer.util.PublicKeyReader;
import com.cnten.platform.dao.CommonDAO;
import com.cnten.po.Maplayer;

@Service
public class MaplayerService {
	private static final Logger log4j = LoggerFactory.getLogger(AccountViewService.class);

	@Autowired
	private CommonDAO commonDAO;

	public Maplayer getMapURLByCompanyID(Maplayer maplayer) {
		String hql = "from Maplayer where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(maplayer.getCompanyId())) {
			hql += " and company.companyId = :companyId";
			params.put("companyId", maplayer.getCompanyId());
		} else {
			return null;
		}
		if(StringUtils.isNotBlank(maplayer.getLayerType())) {
			hql += " and layerType = :layerType";
			params.put("layerType", maplayer.getLayerType());
		} else {
			return null;
		}
		maplayer =  commonDAO.get(hql, params);
		
		JSONObject json = new JSONObject();
		json.put("user", maplayer.getArcgisUser());
		json.put("password", maplayer.getArcgisPassword());
		json.put("arcgisKey", maplayer.getArcgisToken());
		
		String loginInfo = null;
		try {
			loginInfo = PublicKeyReader.getInstance().encrypt(json.toString().getBytes());
		} catch (Exception e) {
			log4j.error(e.getMessage(),e);
			throw new RuntimeException("查询arcgis信息出错");
		}
		maplayer.setLoginInfo(loginInfo);
		return maplayer;
	}
}
