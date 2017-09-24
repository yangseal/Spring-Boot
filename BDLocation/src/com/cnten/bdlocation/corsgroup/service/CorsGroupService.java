package com.cnten.bdlocation.corsgroup.service;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.util.ContextUtil;
import com.cnten.po.Company;
import com.cnten.po.CorsCompanyGroup;

@Service
public class CorsGroupService {
	
	@Autowired
	CommonDAO commonDAO;
	
	//分页展示所有分组信息
	public Page getCorsGroupsPage(CorsCompanyGroup corsGroup, Integer pageIndex, Integer pageSize) {
		String sql = "select a.company_group_id AS companyGroupId,a.company_id AS companyId,"
				+ "a.group_create_time AS groupCreateTime,a.group_name AS groupName,"
				+ "a.remark AS remark,(select count(0) from cors_account b "
				+ "where (b.company_group_id = a.company_group_id)) AS corsCount "
				+ "from cors_company_group a where 1=1 and company_id = :companyId ";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(ContextUtil.getCurrentUser() != null){
			params.put("companyId", ContextUtil.getCurrentUser().getCompany().getCompanyId());
		}
		if(corsGroup != null && corsGroup.getCompany() != null){
			params.put("companyId", corsGroup.getCompany().getCompanyId());
		}
		
		if(corsGroup.getGroupName() != null && StringUtils.isNotBlank(corsGroup.getGroupName())){
			sql += " and group_name like :group_name";
			params.put("group_name", "%"+corsGroup.getGroupName()+"%");
		}
		return commonDAO.sqlGetPage(sql, pageIndex, pageSize, params);
    }
	
	//展示单个分组信息
	public CorsCompanyGroup getGroup(String groupId) {
		return commonDAO.get(CorsCompanyGroup.class, groupId);
	}
	
	//保存分组信息
	public String saveGroup(CorsCompanyGroup corsGroup){
		String groupId = corsGroup.getCompanyGroupId();
		if(StringUtils.isEmpty(groupId)){
			if(corsGroup.getCompany() == null){
				corsGroup.setCompany(commonDAO.get(Company.class, ContextUtil.getCurrentUser().getCompany().getCompanyId()));	
			}
			commonDAO.save(corsGroup);
			return corsGroup.getCompanyGroupId();
		}else{
			CorsCompanyGroup oldCorsGroup = commonDAO.load(CorsCompanyGroup.class, groupId);
			oldCorsGroup.setGroupName(corsGroup.getGroupName());
			oldCorsGroup.setRemark(corsGroup.getRemark());
			commonDAO.update(oldCorsGroup);
			return null;
		}
	}
	
	public CorsCompanyGroup saveGroupForApp(CorsCompanyGroup corsGroup){
		String groupId = corsGroup.getCompanyGroupId();
		if(StringUtils.isEmpty(groupId)){
			if(corsGroup.getCompany() == null){
				corsGroup.setCompany(commonDAO.get(Company.class, ContextUtil.getCurrentUser().getCompany().getCompanyId()));	
			}
			commonDAO.save(corsGroup);
			return corsGroup;
		}else{
			CorsCompanyGroup oldCorsGroup = commonDAO.load(CorsCompanyGroup.class, groupId);
			oldCorsGroup.setGroupName(corsGroup.getGroupName());
			oldCorsGroup.setRemark(corsGroup.getRemark());
			commonDAO.update(oldCorsGroup);
			return null;
		}
	}
	
}
