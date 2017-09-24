package com.cnten.bdlocation.baseStation.provider.service;

import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.util.ContextUtil;
import com.cnten.po.BaseProvider;

@Service
public class BaseProviderService {
	
	@Autowired
	CommonDAO commonDao;
	
	public Page getBaseProvider(BaseProvider baseProivder,Integer pageIndex, Integer pageSize){
		String hql = "from BaseProvider where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(baseProivder.getProviderName())){
			hql += " and providerName like :providerName";
			params.put("providerName", "%"+baseProivder.getProviderName()+"%");
		}
		hql += " order by providerCreateDate desc";
		return commonDao.getPage(hql, pageIndex, pageSize, params);
	}
	
	public BaseProvider getBaseProviderById(String baseProviderId){
		return commonDao.get(BaseProvider.class, baseProviderId);
	}
	
	public void saveBaseProvide(BaseProvider baseProvider){
		String providerId = baseProvider.getBaseProviderId();
		if(!StringUtils.isEmpty(providerId)){
			BaseProvider oldBaseProvider = commonDao.get(BaseProvider.class, providerId);
			oldBaseProvider.setProviderName(baseProvider.getProviderName());
			oldBaseProvider.setOamArea(baseProvider.getOamArea());
			oldBaseProvider.setProviderAddress(baseProvider.getProviderAddress());
			oldBaseProvider.setProvideRemark(baseProvider.getProvideRemark());
			oldBaseProvider.setProviderUpdateDate(new Date());
			oldBaseProvider.setProviderUpdateUser(ContextUtil.getCurrentUser().getUserId());
			commonDao.update(oldBaseProvider);
		}else{
			baseProvider.setProviderCreateUser(ContextUtil.getCurrentUser().getUserId());
			commonDao.save(baseProvider);
		}
	}

}
