package com.cnten.platform.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.platform.system.service.RoleMenuService;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.RoleMenu;

@Controller
public class RoleMenuController {
	@Autowired
	private RoleMenuService roleMenuService;
	
	@RequestMapping(value="/roleMenu/showRoleMenus")
	public void showRoleMenus(){
	}
	
	@ResponseBody
	@RequestMapping(value = "/roleMenu/queryRoleMenus")
	public List<RoleMenu> queryRoleUsers(RoleMenu roleMenu) {
		return roleMenuService.getRoleMenus(roleMenu);
	}
		
	@ResponseBody
	@RequestMapping(value = "/roleMenu/saveRoleMenu")
	public SuccessOrFailure saveRoleMenu(String roleId,@RequestParam(value = "addNodeList[]",required=false) String[] addNodeList,@RequestParam(value = "delNodeList[]",required=false) String[] delNodeList){
		try {
			if(null != addNodeList) {
				roleMenuService.saveRoleMenu(roleId,addNodeList);
			}
			if(null != delNodeList) {
				roleMenuService.deleteRoleMenu(roleId, delNodeList);
			}
			return SuccessOrFailure.SUCCESS(roleId);
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
}
