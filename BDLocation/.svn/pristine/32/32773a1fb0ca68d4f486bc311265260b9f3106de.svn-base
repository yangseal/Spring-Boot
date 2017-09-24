package com.cnten.platform.system.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.po.Menu;
import com.cnten.po.Role;
import com.cnten.po.RoleMenu;

@Service
public class RoleMenuService {

	@Autowired
	CommonDAO commonDAO;
	
	public List<RoleMenu> getRoleMenus(List<Role> roles) {
		if(roles == null || roles.size() == 0) return new ArrayList<RoleMenu>();
		String hql = "from RoleMenu where isDelete is null and role.roleId in(:roleId)";
		HashMap<String,Object> params = new HashMap<String,Object>();
		String[] roleIds = new String[roles.size()];
		for (int i=0; i<roles.size(); i++) {
			roleIds[i] = roles.get(i).getRoleId();
		}
		params.put("roleId", roleIds);
		return commonDAO.queryList(hql, params);
	}
	
	public List<RoleMenu> getRoleMenus(RoleMenu roleMenu) {
		String hql = "from RoleMenu where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(!StringUtils.isEmpty(roleMenu.getRoleId())) {
			hql += " and role.roleId = :roleId";
			params.put("roleId", roleMenu.getRoleId());
		} else {
			return new ArrayList<RoleMenu>();
		}
		if(!StringUtils.isEmpty(roleMenu.getMenuId())) {
			hql += " and menu.menuId = :menuId";
			params.put("menuId", roleMenu.getMenuId());
		}
		List<RoleMenu> list = commonDAO.queryList(hql, params);
		return list;
	}

	public void saveRoleMenu(String roleId, String[] menusIds) {
		if(null == menusIds) {
			return;
		}
		Role role = null;
		RoleMenu roleMenu = null;
		if(!StringUtils.isEmpty(roleId)){
			role = new Role(roleId);
		}
		for(int i=0; i<menusIds.length; i++) {
			if(StringUtils.isEmpty(menusIds[i]) || menusIds[i].equals("0")) {
				continue;
			}
			roleMenu = new RoleMenu();
			roleMenu.setRole(role);
			roleMenu.setMenu(new Menu(menusIds[i]));
			commonDAO.save(roleMenu);
		}	
	}

	public void deleteRoleMenu(String roleId, String[] menusIds) {
		if(null == roleId || roleId == "" ||null == menusIds) {
			return;
		}
		for(String menuId : menusIds){
			if(StringUtils.isEmpty(roleId)) {
				continue;
			}
			RoleMenu roleMenu = new RoleMenu();
			roleMenu.setRoleId(roleId);
			roleMenu.setMenuId(menuId);
			RoleMenu oldRoleMenu =	getRoleMenus(roleMenu).get(0);
			oldRoleMenu.setIsDelete("Y");
			commonDAO.update(oldRoleMenu);
		}
	}

}
