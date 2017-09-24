package com.cnten.platform.system.service;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.util.ContextUtil;
import com.cnten.po.Company;
import com.cnten.po.Role;

@Service
public class RoleService {

	@Autowired
	CommonDAO commonDAO;
	
	public Role getRoleByUserId(String userId) {
		if(StringUtils.isBlank(userId)) return null;
		String hql = "from Role where isDelete is null and roleId in(select role.roleId from RoleUser where isDelete is null and user.userId = :userId)";
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("userId", userId);
		return commonDAO.get(hql, params);
	}
	
	public Page getRolesPage(String roleName, Integer pageIndex, Integer pageSize) {
		String hql = "from Role where isDelete is null and roleName like ?";
		roleName = "%" + roleName + "%";
		Company c = ContextUtil.getCurrentUser().getCompany();
		if(!"SYS".equals(c.getCompanyCode()) && !"CNTEN".equals(c.getCompanyCode()) ){
			hql += " and company = ? ";
			return commonDAO.getPageByVariableParam(hql, pageIndex, pageSize, roleName,c);
		}
		hql += " and company is null";
		return commonDAO.getPageByVariableParam(hql, pageIndex, pageSize, roleName);
	}

	public Role getRole(String roleId) {
		return commonDAO.get(Role.class, roleId);
	}

	public void saveRole(Role role) {
		String roleId = role.getRoleId();
		if(StringUtils.isEmpty(roleId)){
			commonDAO.save(role);
		}else{
			Role oldRole = commonDAO.load(Role.class, roleId);
			oldRole.setRoleName(role.getRoleName());
			commonDAO.update(oldRole);
		}
	}

	public void deleteRole(String roleIds){
		String[] roleIdArray = roleIds.split(",");
		for(String roleId : roleIdArray){
			Role oldRole = commonDAO.load(Role.class, roleId);
			oldRole.setIsDelete("Y");
			commonDAO.update(oldRole);
		}
	}
	
	public List<Role> getRoles() {
		String hql = "from Role where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		Company c = ContextUtil.getCurrentUser().getCompany();
		if(!"SYS".equals(c.getCompanyCode()) && !"CNTEN".equals(c.getCompanyCode()) ){
			hql += " and company = :company ";
			params.put("company", ContextUtil.getCurrentUser().getCompany());
		}else{
			hql += " and company is null ";
		}
		hql += " order by roleName ";
		List<Role> roles = commonDAO.queryList(hql, params);
		return roles;
	}
}
