package com.cnten.platform.system.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.po.Role;
import com.cnten.po.RoleUser;
import com.cnten.po.User;

@Service
public class RoleUserService {
	
	@Autowired
	CommonDAO commonDAO;
	
	public List<RoleUser> getRoleUsers(RoleUser roleUser) {
		String hql = "from RoleUser where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(!StringUtils.isEmpty(roleUser.getRoleId())) {
			hql += " and role.roleId = :roleId";
			params.put("roleId", roleUser.getRoleId());
		} else {
			return new ArrayList<RoleUser>();
		}
		if(!StringUtils.isEmpty(roleUser.getUserId())) {
			hql += " and user.userId = :userId";
			params.put("userId", roleUser.getUserId());
		} 
		List<RoleUser> list = commonDAO.queryList(hql, params);
		return list;
	}

	/*public RoleUser getRoleUser(String roleUserId) {
		return commonDAO.get(RoleUser.class, roleUserId);
	}*/

	public void saveRoleUser(String roleId,String[] userIds) {
		if(null == userIds) {
			return;
		}
		Role role = null;
		RoleUser roleUser = null;
		if(!StringUtils.isEmpty(roleId)){
			role = new Role(roleId);
		}
		for(int i=0; i<userIds.length; i++) {
			if(StringUtils.isEmpty(userIds[i])) {
				continue;
			}
			roleUser = new RoleUser();
			roleUser.setRole(role);
			roleUser.setUser(new User(userIds[i]));
			commonDAO.save(roleUser);
		}	
	}

	public void deleteRoleUser(String roleId,String[] userIds){
		if(null == roleId || roleId == "" ||null == userIds) {
			return;
		}
		for(String userId : userIds){
			if(StringUtils.isEmpty(roleId)) {
				continue;
			}
			RoleUser roleUser = new RoleUser();
			roleUser.setRoleId(roleId);
			roleUser.setUserId(userId);
			RoleUser oldRoleUser =	getRoleUsers(roleUser).get(0);
			oldRoleUser.setIsDelete("Y");
			commonDAO.update(oldRoleUser);
		}
	}
}
