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
import com.cnten.po.BaseProviderUser;

@Service
public class ProviderUserService {
	
	@Autowired
	CommonDAO commonDao;
	
	public Page getProviderUsers(BaseProviderUser providerUser,Integer pageIndex, Integer pageSize){
		String hql = "from BaseProviderUser where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(providerUser.getProUserName())){
			hql += " and proUserName like :proUserName";
			params.put("proUserName", "%" + providerUser.getProUserName() + "%");
		}
		if(providerUser.getBaseProvider() != null && StringUtils.isNotBlank(providerUser.getBaseProvider().getBaseProviderId())){
			hql += " and baseProvider = :baseProvider";
			params.put("baseProvider", providerUser.getBaseProvider());
		}
		hql += " order by proUserCreateDate desc";
		return commonDao.getPage(hql, pageIndex, pageSize, params);
	}
	
	public BaseProviderUser getProUserById(String providerUserId){
		return commonDao.get(BaseProviderUser.class, providerUserId);
	}
	
	public void saveProUser(BaseProviderUser providerUser,String baseProviderId){
		String proUserId = providerUser.getBaseProviderUserId();
		if(StringUtils.isEmpty(proUserId)){
			BaseProvider baseProvider = commonDao.get(BaseProvider.class,baseProviderId);
			providerUser.setBaseProvider(baseProvider);
			providerUser.setProUserCreateUser(ContextUtil.getCurrentUser().getUserId());
			commonDao.save(providerUser);
		}else{
			BaseProviderUser oldBaseProviderUser = commonDao.get(BaseProviderUser.class, proUserId);
			oldBaseProviderUser.setProUserDept(providerUser.getProUserDept());
			oldBaseProviderUser.setProUserEmail(providerUser.getProUserEmail());
			oldBaseProviderUser.setProUserFax(providerUser.getProUserFax());
			oldBaseProviderUser.setProUserName(providerUser.getProUserName());
			oldBaseProviderUser.setProUserPhone(providerUser.getProUserPhone());
			oldBaseProviderUser.setProUserPost(providerUser.getProUserPost());
			oldBaseProviderUser.setProUserRemark(providerUser.getProUserRemark());
			oldBaseProviderUser.setProUserTel(providerUser.getProUserTel());
			oldBaseProviderUser.setProUserUpdateDate(new Date());
			oldBaseProviderUser.setProUserUpdateUser(ContextUtil.getCurrentUser().getUserId());
			commonDao.update(oldBaseProviderUser);
		}
	}
	
	public void deleteProUser(String proUserIds){
		String[] proUserIdArray = proUserIds.split(",");
		for (String proUserId : proUserIdArray) {
			BaseProviderUser oldProUser = commonDao.load(BaseProviderUser.class, proUserId);
			oldProUser.setIsDelete("Y");
			commonDao.update(oldProUser);
		}
	}

}
