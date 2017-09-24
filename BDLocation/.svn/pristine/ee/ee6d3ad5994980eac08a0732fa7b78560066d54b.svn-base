package com.cnten.bdlocation.baseStation.customer.service;

import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.BaseCustomerUser;
import com.cnten.po.OamProject;
/**
 * 暂无查询功能
 * @author Administrator
 *
 */
@Service
public class BaseCustomerUserService {
	@Autowired
	CommonDAO commonDAO;
	
	//联系人管理
	public Page getCustomerUsersPage(BaseCustomerUser baseCustomerUser,
			Integer pageIndex, Integer pageSize) {
		String hql = "from BaseCustomerUser a where a.isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(baseCustomerUser.getBaseCustomer().getBaseCustomerId())){
			hql += " and a.baseCustomer = :baseCustomer";
			params.put("baseCustomer", baseCustomerUser.getBaseCustomer());
		}
		if(StringUtils.isNotBlank(baseCustomerUser.getCustUserName())){
			hql += " and custUserName like :custUserName";
			params.put("custUserName", "%"+baseCustomerUser.getCustUserName()+"%");
		}
		hql += " order by createTime desc";
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}
	
	public BaseCustomerUser getCustomer(String customerId){
		BaseCustomerUser baseCustomerUser = commonDAO.get(BaseCustomerUser.class, customerId);
		return	baseCustomerUser;
	}
	
	public void saveCustomer(BaseCustomerUser baseCustomerUser){
		String baseCustomerUserId = baseCustomerUser.getBaseCustomerUserId();
		if(StringUtils.isEmpty(baseCustomerUserId)){
			baseCustomerUser.setCreateTime(new Date());
			baseCustomerUser.setCreateUser(ContextUtil.getCurrentUser().getUserId());
			commonDAO.save(baseCustomerUser);
		}else{
			baseCustomerUser.setUpdateTime(new Date());
			baseCustomerUser.setUpdateUser(ContextUtil.getCurrentUser().getUserId());
			commonDAO.update(baseCustomerUser);
		}
		
	}
	
	public void deleteCustomer(String customerIds){
		String[] customerIdArray = customerIds.split(",");
		for(String customerId : customerIdArray){
			BaseCustomerUser baseCustomerUser = commonDAO.load(BaseCustomerUser.class, customerId);
			baseCustomerUser.setIsDelete("Y");
			commonDAO.update(baseCustomerUser);
		}
	}
	
}
