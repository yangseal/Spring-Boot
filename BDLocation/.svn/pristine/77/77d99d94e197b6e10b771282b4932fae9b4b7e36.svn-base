package com.cnten.bdlocation.baseStation.customer.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.bdlocation.oamarea.service.OamAreaService;
import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.util.ContextUtil;
import com.cnten.po.BaseCustomer;
import com.cnten.po.OamArea;
/**
 * 暂无查询功能
 * @author Administrator
 *
 */
@Service
public class BaseCustomerService {
	@Autowired
	CommonDAO commonDAO;
	
	@Autowired
	private OamAreaService oamAreaService;
	
	//基站客户管理
	public Page getBaseCustomersPage(BaseCustomer baseCustomer,
			Integer pageIndex, Integer pageSize){
		String hql = "from BaseCustomer where isDelete is null"; 
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(baseCustomer.getCustomerName())){
			hql += " and customerName like :customerName";
			params.put("customerName", "%"+baseCustomer.getCustomerName()+"%");
		}
		if(baseCustomer.getOamArea() != null && StringUtils.isNotBlank(baseCustomer.getOamArea().getOamAreaId())){
			OamArea oamArea = baseCustomer.getOamArea();
			List<OamArea> oamAreas = oamAreaService.getOamAreas();
			List<String> ids = new ArrayList<>();
			ids.add(oamArea.getOamAreaId());
			addChildren(oamArea, oamAreas, ids);
			hql += " and oamArea.oamAreaId in(:ids)";
			params.put("ids", ids.toArray());
		}
		hql += " order by createTime desc";
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}
	
	private void addChildren(OamArea oamArea,List<OamArea> oamAreas,List<String> ids){
		for(OamArea m : oamAreas){
			if(oamArea.getOamAreaId().equals(m.getParentId())){
				ids.add(m.getOamAreaId());
				addChildren(m, oamAreas, ids);
			}
		}
	}
	
	public BaseCustomer getBaseCustomer(String baseCustomerId){
		if(StringUtils.isNotEmpty(baseCustomerId)){
			BaseCustomer baseCustomer = commonDAO.load(BaseCustomer.class, baseCustomerId);
			return baseCustomer;
		}else{
			return null;
		}
	}
	
	
	public void saveBaseCustomer(BaseCustomer baseCustomer){
		if(StringUtils.isEmpty(baseCustomer.getBaseCustomerId())){
			
			baseCustomer.setCreateTime(new Date());
			baseCustomer.setCreateUser(ContextUtil.getCurrentUser().getUserId());
			commonDAO.save(baseCustomer);
		}else{
			baseCustomer.setUpdateTime(new Date());
			baseCustomer.setUpdateUser(ContextUtil.getCurrentUser().getUserId());
			commonDAO.update(baseCustomer);
		}
	}
}
