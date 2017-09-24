package com.cnten.platform.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.platform.system.service.RoleUserService;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.RoleUser;

@Controller
public class RoleUserController {
	
	@Autowired
	private RoleUserService roleUserService;
	
	@RequestMapping(value = "/roleUser/showRoleUsers")
	public void showPointTypeAuthorize() {
	}
	
	@ResponseBody
	@RequestMapping(value = "/roleUser/queryRoleUsers")
	public List<RoleUser> queryRoleUsers(RoleUser roleUser) {
		return roleUserService.getRoleUsers(roleUser);
	}
		
	@ResponseBody
	@RequestMapping(value = "/roleUser/saveRoleUser")
	public SuccessOrFailure saveRoleUser(String roleId,@RequestParam(value = "addNodeList[]",required=false) String[] addNodeList,@RequestParam(value = "delNodeList[]",required=false) String[] delNodeList){
		try {
			if(null != addNodeList) {
				roleUserService.saveRoleUser(roleId,addNodeList);
			}
			if(null != delNodeList) {
				roleUserService.deleteRoleUser(roleId, delNodeList);
			}
			return SuccessOrFailure.SUCCESS(roleId);
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
}
