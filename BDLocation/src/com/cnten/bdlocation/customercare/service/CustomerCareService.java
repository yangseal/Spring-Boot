package com.cnten.bdlocation.customercare.service;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.po.CustomerCare;
@Service
public class CustomerCareService {
    @Autowired
	private CommonDAO commonDAO;
	
	
	
	public Page getCustomerCares(CustomerCare customerCare,Integer pageIndex,Integer pageSize){
		String hql = "from CustomerCare a where a.isDelete is null";
		HashMap<String, Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(customerCare.getCustomerCareName())){
			hql += " and customerCareName like :customerCareName";
			params.put("customerCareName", "%"+customerCare.getCustomerCareName()+"%");
		}
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
		
	}
	
	
	public CustomerCare getCustomerCare(String customerCareId){
		
		return commonDAO.get(CustomerCare.class, customerCareId);
		
	}
	
	
	public void saveCustomerCare(CustomerCare customerCare){
			if(StringUtils.isEmpty(customerCare.getBdCustomerCareId())){
				commonDAO.save(customerCare);
			}else{
				CustomerCare oldCustomerCare = commonDAO.get(CustomerCare.class, customerCare.getBdCustomerCareId());
				oldCustomerCare.setCustomerCareName(customerCare.getCustomerCareName());
				oldCustomerCare.setCustomerCareNo(customerCare.getCustomerCareNo());
				commonDAO.update(oldCustomerCare);
			}
		
	}
	
	public void deleteCustomerCare(String customerCareIds){
		String[] customerCareIdArray = customerCareIds.split(",");
		for(String customerCareId : customerCareIdArray){
			CustomerCare oldCustomerCare = commonDAO.load(CustomerCare.class, customerCareId);
			oldCustomerCare.setIsDelete("Y");
			commonDAO.update(oldCustomerCare);
		}			
	}
	
	
}
