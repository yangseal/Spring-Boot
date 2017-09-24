package com.cnten.bdlocation.baseStation.provider.service;

import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.util.ContextUtil;
import com.cnten.po.BaseProContract;
import com.cnten.po.BaseProvider;

@Service
public class ProContractService {
	
	@Autowired
	CommonDAO commonDao;
	
	public Page getProContracts(BaseProContract proContract,Integer pageIndex, Integer pageSize){
		String hql = "from BaseProContract a where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(proContract.getProContractNo())){
			hql += " and a.proContractNo like :proContractNo";
			params.put("proContractNo", "%" + proContract.getProContractNo() + "%");
		}
		if(proContract.getBaseProject() != null && StringUtils.isNotBlank(proContract.getBaseProject().getProjectName())){
			hql += " and a.baseProject.projectName like :projectName";
			params.put("projectName", "%" + proContract.getBaseProject().getProjectName()+ "%");
		}
		if(proContract.getBaseProvider() != null && StringUtils.isNotBlank(proContract.getBaseProvider().getBaseProviderId())){
			hql += " and a.baseProvider = :baseProvider";
			params.put("baseProvider", proContract.getBaseProvider());
		}
		hql += " order by proContractCreateDate desc";
		return commonDao.getPage(hql, pageIndex, pageSize, params);
	}
	
	public BaseProContract getProContractById(String proContractId){
		return commonDao.get(BaseProContract.class, proContractId);
	}
	
	public void saveProContract(BaseProContract proContract,String baseProviderId){
		String proContractId = proContract.getBaseProContractId();
		if(StringUtils.isEmpty(proContractId)){
			BaseProvider baseProvider = commonDao.get(BaseProvider.class,baseProviderId);
			proContract.setBaseProvider(baseProvider);
			proContract.setProContractCreateUser(ContextUtil.getCurrentUser().getUserId());
			commonDao.save(proContract);
		}else{
			BaseProContract oldBaseProContract = commonDao.get(BaseProContract.class, proContractId);
			oldBaseProContract.setBaseProject(proContract.getBaseProject());
			oldBaseProContract.setContractRemark(proContract.getContractRemark());
			oldBaseProContract.setProContractAddress(proContract.getProContractAddress());
			oldBaseProContract.setProContractDate(proContract.getProContractDate());
			oldBaseProContract.setProContractName(proContract.getProContractName());
			oldBaseProContract.setProContractNo(proContract.getProContractNo());
			oldBaseProContract.setProContractPartya(proContract.getProContractPartya());
			oldBaseProContract.setProContractPartyb(proContract.getProContractPartyb());
			oldBaseProContract.setProContractType(proContract.getProContractType());
			oldBaseProContract.setProContractUpdateDate(new Date());
			oldBaseProContract.setProContractUpdateUser(ContextUtil.getCurrentUser().getUserId());
			commonDao.update(oldBaseProContract);
		}
	}

}
