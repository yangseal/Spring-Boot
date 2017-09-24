package com.cnten.bdlocation.baseStation.customer.service;

import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.util.ContextUtil;
import com.cnten.po.BaseCustomerContract;
import com.cnten.po.BaseProject;
/**
 * 暂无查询功能
 * @author Administrator
 *
 */
@Service
public class BaseProjectService {
	@Autowired
	CommonDAO commonDAO;
	
	//基站项目管理
	public Page getBaseProjectsPage(BaseProject baseProject,
			Integer pageIndex, Integer pageSize) {
		String hql = "from BaseProject where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(baseProject.getBaseCustomer().getBaseCustomerId())){
			hql += " and baseCustomer = :baseCustomer";
			params.put("baseCustomer", baseProject.getBaseCustomer());
		}
		if(StringUtils.isNotBlank(baseProject.getProjectName())){
			hql += " and projectName like :projectName";
			params.put("projectName", "%"+baseProject.getProjectName()+"%");
		}
		if(StringUtils.isNotBlank(baseProject.getProjectNo())){
			hql += " and projectNo like :projectNo";
			params.put("projectNo", "%"+baseProject.getProjectNo()+"%");
		}
		if(baseProject.getBaseCustomer() != null && StringUtils.isNotBlank(baseProject.getBaseCustomer().getBaseCustomerId())){
			hql += " and baseCustomer.baseCustomerId = :baseCustomerId";
			params.put("baseCustomerId", baseProject.getBaseCustomer().getBaseCustomerId());
		}
		hql += " order by createTime desc";
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}
	
	public BaseProject getProject(String projectId){
		BaseProject baseProject = commonDAO.get(BaseProject.class, projectId);
		return baseProject;
	}
	
	public void saveProject(BaseProject baseProject){
		if(StringUtils.isEmpty(baseProject.getBaseProjectId())){
			baseProject.setCreateTime(new Date());
			baseProject.setCreateUser(ContextUtil.getCurrentUser().getUserId());
			commonDAO.save(baseProject);
		}else{
			baseProject.setUpdateTime(new Date());
			baseProject.setUpdateUser(ContextUtil.getCurrentUser().getUserId());
			commonDAO.update(baseProject);
		}
	}
}
