package com.cnten.bdlocation.baseStation.customer.service;

import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.util.StringUtil;
import com.cnten.po.BaseCustomer;
import com.cnten.po.BaseCustomerContract;
/**
 * 暂无查询功能
 * @author Administrator
 *
 */
@Service
public class BaseContractService {
	@Autowired
	CommonDAO commonDAO;
	//服务合同管理
	public Page getContractsPage(BaseCustomerContract baseCustomerContract,
			Integer pageIndex, Integer pageSize) {
		String hql = "from BaseCustomerContract where isDelete is null";
		HashMap<String, Object> params = new HashMap<String, Object>();

		if(baseCustomerContract.getBaseCustomer()!=null && StringUtils.isNotEmpty(baseCustomerContract.getBaseCustomer().getBaseCustomerId())){
			hql += " and  baseCustomer = :baseCustomer";
			params.put("baseCustomer", baseCustomerContract.getBaseCustomer());
		}
		if(StringUtil.isNotEmpty(baseCustomerContract.getCustContractName())){
			hql += " and custContractName like :custContractName";
			params.put("custContractName", "%"+baseCustomerContract.getCustContractName()+"%");
		}
		if(StringUtil.isNotEmpty(baseCustomerContract.getCustContractNo())){
			hql += " and custContractNo like :custContractNo";
			params.put("custContractNo", "%"+baseCustomerContract.getCustContractNo()+"%");
		}
		
		hql += " order by createTime desc";
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}
	
	public BaseCustomerContract getContract(String contractId){
		BaseCustomerContract baseCustomerContract = commonDAO.get(BaseCustomerContract.class, contractId);
		return	baseCustomerContract;
	}
	
	public void saveContract(BaseCustomerContract baseCustomerContract){
		if(StringUtils.isEmpty(baseCustomerContract.getBaseCustomerContractId())){
			baseCustomerContract.setCreateUser(ContextUtil.getCurrentUser().getUserId());
			baseCustomerContract.setCreateTime(new Date());
			commonDAO.save(baseCustomerContract);
		}else{
			baseCustomerContract.setUpdateUser(ContextUtil.getCurrentUser().getUserId());
			baseCustomerContract.setUpdateTime(new Date());
			commonDAO.update(baseCustomerContract);
		}
		
	}
	
	public BaseCustomer getBaseCustomer(String baseCustomerId){
		BaseCustomer baseCustomer = commonDAO.get(BaseCustomer.class, baseCustomerId);
		return baseCustomer;
	}
}
