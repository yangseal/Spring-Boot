package com.cnten.platform.system.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.po.Company;
import com.cnten.po.Menu;
import com.cnten.po.Role;

@Service
public class MenuService {

	@Autowired
	private CommonDAO commonDAO;
	
	public Menu getMenusOfRoleAndParentMenu(String menuCode, Role role) {
		List<Menu> menus = getMenus(role);
		for (Menu menu : menus) {
			if(menuCode.equals(menu.getMenuCode())) {
				return menu;
			}
		}
		return null;
	}
	
	public List<Menu> getMenus(Role role) {
		if(role == null) return new ArrayList<Menu>();
		String hql = "from Menu where isDelete is null and menuId in(select menu.menuId from RoleMenu where isDelete is null and role.roleId=:roleId) order by menuOrder asc";
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("roleId", role.getRoleId());
		List<Menu> menus = commonDAO.queryList(hql, params);
		List<Menu> sortedMenus = new ArrayList<Menu>();
		for(Menu menu : menus){
			if(StringUtils.isEmpty(menu.getParentId())  || fatherNotFount(menu, menus)){
				addChildren(menu, menus);
				sortedMenus.add(menu);
			}
		}
		return sortedMenus;
	}
	
	public List<Menu> getMenus(Company company) {
		if(company == null) return new ArrayList<Menu>();
		String hql = "from Menu where isDelete is null and menuId in(select menu.menuId from CompanyMenu where isDelete is null and company.companyId=:companyId) order by menuOrder asc";
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("companyId", company.getCompanyId());
		List<Menu> menus = commonDAO.queryList(hql, params);
		List<Menu> sortedMenus = new ArrayList<Menu>();
		for(Menu menu : menus){
			if(StringUtils.isEmpty(menu.getParentId()) || fatherNotFount(menu, menus)){
				addChildren(menu, menus);
				sortedMenus.add(menu);
			}
		}
		return sortedMenus;
	}
	
	private boolean fatherNotFount(Menu menu,List<Menu> menus) {
		for(Menu m : menus){
			if(m.getMenuId().equals(menu.getParentId())){
				return false;
			}
		}
		return true;	
	}
	
	public List<Menu> getHomeMenus() {
		String hql = "from Menu where isDelete is null order by menuOrder asc";
		List<Menu> menus = commonDAO.queryListByVariableParam(hql);
		List<Menu> sortedMenus = new ArrayList<Menu>();
		for(Menu menu : menus){
			if(StringUtils.isEmpty(menu.getParentId())){
				addChildren(menu, menus);
				sortedMenus.add(menu);
			}
		}
		return sortedMenus;
	}
	
	public List<Menu> getMenus() {
		String hql = "from Menu where isDelete is null order by menuOrder asc";
		List<Menu> menus = commonDAO.queryListByVariableParam(hql);
		List<Menu> sortedMenus = new ArrayList<Menu>();
		for(Menu menu : menus){
			if(StringUtils.isEmpty(menu.getParentId())){
				sortedMenus.add(menu);
				addChildren(menu, menus, sortedMenus);
			}
		}
		return sortedMenus;
	}

	private void addChildren(Menu menu,List<Menu> menus,List<Menu> sortedMenus){
		for(Menu m : menus){
			if(menu.getMenuId().equals(m.getParentId())){
				sortedMenus.add(m);
				addChildren(m, menus, sortedMenus);
			}
		}
	}
	
	private void addChildren(Menu menu,List<Menu> menus) {
		List<Menu> children = new ArrayList<Menu>();
		for(Menu m : menus){
			if(menu.getMenuId().equals(m.getParentId())){
				addChildren(m, menus);
				children.add(m);
			}
		}
		menu.setChildren(children);
	}

	public Menu getMenu(String menuId) {
		return commonDAO.get(Menu.class, menuId);
	}

	public String saveMenu(Menu menu) {
		String menuId = menu.getMenuId();
		if(StringUtils.isEmpty(menuId)){
			commonDAO.save(menu);
			return menu.getMenuId();
		}else{
			Menu oldMenu = commonDAO.load(Menu.class, menuId);
			oldMenu.setMenuName(menu.getMenuName());
			oldMenu.setMenuCode(menu.getMenuCode());
			oldMenu.setAction(menu.getAction());
			oldMenu.setMenuOrder(menu.getMenuOrder());
			commonDAO.update(oldMenu);
			return null;
		}
	}
	
	public void deleteMenu(String menuId){
		Menu oldMenu = commonDAO.load(Menu.class, menuId);
		oldMenu.setIsDelete("Y");
		commonDAO.update(oldMenu);
	}
}
