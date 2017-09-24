package com.cnten.platform.system.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.platform.system.service.MenuService;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.Company;
import com.cnten.po.Menu;

@Controller
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "/menu/showMenus")
	public void showMenus(Model model) {
		List<Menu> menus = menuService.getMenus();
		model.addAttribute("menus", menus);
	}
	
	@RequestMapping(value = "/menu/showMenu")
	public void showMenu(String menuId,Model model) {
		Menu menu = menuService.getMenu(menuId);
		model.addAttribute("menu", menu);
	}
	
	@ResponseBody
	@RequestMapping(value = "/menu/saveMenu")
	public SuccessOrFailure saveMenu(Menu menu) {
		try {
			String menuId = menuService.saveMenu(menu);
			if(menuId == null){
				return SuccessOrFailure.SUCCESS;
			}else{
				return SuccessOrFailure.SUCCESS(menuId);
			}
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/menu/deleteMenu")
	public SuccessOrFailure deleteMenu(String menuId) {
		try {
			menuService.deleteMenu(menuId);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/menu/getMenus")
	public List<Menu> getMenus() {
		Company company = ContextUtil.getCurrentUser().getCompany();
		List<Menu> menus = null;
		if("SYS".equals(company.getCompanyCode()) || "CNTEN".equals(company.getCompanyCode())){
			menus = menuService.getMenus();
		}else{
			menus = menuService.getMenus(company);
		}
		for(Menu menu : menus){
			if(StringUtils.isEmpty(menu.getParentId())){
				menu.setParentId("0");
			}
		}
		Menu menuRoot = new Menu("0");
		menuRoot.setMenuName("菜单");
		menus.add(menuRoot);
		return menus;
	} 
}
