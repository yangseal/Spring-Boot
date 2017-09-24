package com.cnten.platform.system.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.po.Menu;
import com.cnten.po.Company;
import com.cnten.po.CompanyMenu;

@Service
public class CompanyMenuService {
	@Autowired
	CommonDAO commonDAO;
	
	public List<CompanyMenu> getCompanyMenus(List<Company> companys) {
		if(companys == null || companys.size() == 0) return new ArrayList<CompanyMenu>();
		String hql = "from CompanyMenu where isDelete is null and company.companyId in(:companyId)";
		HashMap<String,Object> params = new HashMap<String,Object>();
		String[] companyIds = new String[companys.size()];
		for (int i=0; i<companys.size(); i++) {
			companyIds[i] = companys.get(i).getCompanyId();
		}
		params.put("companyId", companyIds);
		return commonDAO.queryList(hql, params);
	}
	
	public List<CompanyMenu> getCompanyMenus(CompanyMenu companyMenu) {
		String hql = "from CompanyMenu where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(!StringUtils.isEmpty(companyMenu.getCompanyId())) {
			hql += " and company.companyId = :companyId";
			params.put("companyId", companyMenu.getCompanyId());
		} else {
			return new ArrayList<CompanyMenu>();
		}
		if(!StringUtils.isEmpty(companyMenu.getMenuId())) {
			hql += " and menu.menuId = :menuId";
			params.put("menuId", companyMenu.getMenuId());
		}
		List<CompanyMenu> list = commonDAO.queryList(hql, params);
		return list;
	}

	public void saveCompanyMenu(String companyId, String[] menusIds) {
		if(null == menusIds) {
			return;
		}
		Company company = null;
		CompanyMenu companyMenu = null;
		if(!StringUtils.isEmpty(companyId)){
			company = new Company(companyId);
		}
		for(int i=0; i<menusIds.length; i++) {
			if(StringUtils.isEmpty(menusIds[i]) || menusIds[i].equals("0")) {
				continue;
			}
			companyMenu = new CompanyMenu();
			companyMenu.setCompany(company);
			companyMenu.setMenu(new Menu(menusIds[i]));
			commonDAO.save(companyMenu);
		}	
	}

	public void deleteCompanyMenu(String companyId, String[] menusIds) {
		if(null == companyId || companyId == "" ||null == menusIds) {
			return;
		}
		for(String menuId : menusIds){
			if(StringUtils.isEmpty(companyId)) {
				continue;
			}
			CompanyMenu companyMenu = new CompanyMenu();
			companyMenu.setCompanyId(companyId);
			companyMenu.setMenuId(menuId);
			CompanyMenu oldCompanyMenu =	getCompanyMenus(companyMenu).get(0);
			oldCompanyMenu.setIsDelete("Y");
			commonDAO.update(oldCompanyMenu);
		}
	}
}