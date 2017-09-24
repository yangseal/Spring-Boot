package com.cnten.platform.system.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.platform.dao.Page;
import com.cnten.platform.system.service.RoleService;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.Role;

@Controller
public class RoleController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "/role/showRoles")
	public void showRoles() {
	}
	
	@RequestMapping(value = "/role/selectRole")
	public void selectRole() {
	}
	
	@RequestMapping(value = "/role/showRole")
	public void showRole(String roleId, Model model) {
		Role role = roleService.getRole(roleId);
		model.addAttribute("role", role);
	}
	
	@RequestMapping(value = "/role/queryRoles")
	public void queryRoles(String roleName, Integer pageIndex, Integer pageSize, Model model) {
		Page page = roleService.getRolesPage(roleName, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "/role/selectRoles")
	public void selectRoles(String roleName, Integer pageIndex, Integer pageSize, Model model) {
		Page page = roleService.getRolesPage(roleName, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@ResponseBody
	@RequestMapping(value = "/role/saveRole")
	public SuccessOrFailure saveRole(Role role){
		try {
			roleService.saveRole(role);
			return SuccessOrFailure.SUCCESS(role.getRoleId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/role/deleteRole")
	public SuccessOrFailure deleteRole(String roleIds){
		try {
			roleService.deleteRole(roleIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/role/getRoles")
	public List<Role> getRoles() {
		return roleService.getRoles();
	} 
}
