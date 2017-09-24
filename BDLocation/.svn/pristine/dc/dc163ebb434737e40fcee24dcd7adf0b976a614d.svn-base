package com.cnten.bdlocation.clients.index.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cnten.platform.system.service.MenuService;
import com.cnten.platform.util.ContextUtil;
import com.cnten.po.Menu;
import com.cnten.po.Role;
import com.cnten.po.User;

@Controller
public class ClientCenterController {
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value="/client/index")
	public void clientIndex(Model model){
		
	}
	
	@RequestMapping(value="/client/header")
	public void indexHeader(Model model){
		Role role = ContextUtil.getCurrentUser().getRole();
		List<Menu> menuList = menuService.getMenus(role); 
		model.addAttribute("menus", menuList);
		
	}
	
	@RequestMapping(value="/client/indexSide")
	public void indexSide(String pageCode, Model model){
		User user = ContextUtil.getCurrentUser();
		Role role = user.getRole();
		Menu menu = menuService.getMenusOfRoleAndParentMenu(pageCode,role);
		model.addAttribute("menus", menu.getChildren());
	}
	
}
