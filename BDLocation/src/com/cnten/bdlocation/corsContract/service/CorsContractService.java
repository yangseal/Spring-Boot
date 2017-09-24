package com.cnten.bdlocation.corsContract.service;

import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.po.BaseCustomer;
import com.cnten.po.CorsContract;
import com.cnten.po.StakeoutTask;

@Service
public class CorsContractService {
	
	@Autowired CommonDAO commonDAO;
	
	public CorsContract showEidtCorsContract(String corsContractId)
	{
		if(StringUtils.isNotEmpty(corsContractId)){
			CorsContract corsContract = commonDAO.load(CorsContract.class, corsContractId);
			return corsContract;
		}else{
			return null;
		}
	}
	
	public void  saveCorsConstract(CorsContract corsContract)
	{
		if(StringUtils.isEmpty(corsContract.getCorsContractId())){
			commonDAO.save(corsContract);
		}else{
			commonDAO.update(corsContract);
		}
	}
	
	public Page getCorsContractPage(CorsContract corsContract,Integer pageIndex,Integer pageSize){
		HashMap<String,Object> params = new HashMap<String,Object>();
		String hql = "from CorsContract where 1 = 1";
		if(StringUtils.isNotBlank(corsContract.getCorsContractCusName())){
			hql += " and corsContractCusName like :corsContractCusName";
			params.put("corsContractCusName", "%"+corsContract.getCorsContractCusName()+"%");
		}
		hql += " order by corsContractDate desc";
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}
	
	public void deleteCorsContract(String corsContractIds){
		String[] corsContractIdsArray = corsContractIds.split(",");
		for (String corsContractId : corsContractIdsArray) {
			CorsContract corsContract = commonDAO.load(CorsContract.class, corsContractId);
			corsContract.setIsDelete("Y");
			commonDAO.update(corsContract);
		}
	}
}