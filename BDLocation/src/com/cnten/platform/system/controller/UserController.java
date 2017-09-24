package com.cnten.platform.system.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.platform.dao.Page;
import com.cnten.platform.system.service.UserService;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.User;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/showUsers")
	public void showUsers() {
	}
	
	@RequestMapping(value = "/user/showRoleUsers")
	public void showRoleUsers() {
	}
	
	@RequestMapping(value = "/user/showApprovalUsers")
	public void showApprovalUsers() {
	}

	@RequestMapping(value = "/user/selectUser")
	public void selectUser() {
	}

	@RequestMapping(value = "/user/showUser")
	public void showUser(String userId, Model model) {
		User user = userService.getUser(userId);
		model.addAttribute("user", user);
	}

	@RequestMapping(value = "/user/queryUsers")
	public void queryUsers(User user, Integer pageIndex, Integer pageSize, Model model) {
		Page page = null;
		if(user != null && user.getRole() != null){
			page = userService.getRoleUsersPage(user, pageIndex, pageSize);
		}else{
			page = userService.getUsersPage(user, pageIndex, pageSize);
		}
		 
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "/user/queryRoleUsers")
	public void queryRoleUsers(User user, Integer pageIndex, Integer pageSize, Model model){
		Page page = userService.getRoleUsersPage(user, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "/user/queryApprovalUsers")
	public void queryApprovalUsers(User user, Integer pageIndex, Integer pageSize, Model model) {
		Page page = userService.getApprovalUsersPage(user, pageIndex, pageSize);
		model.addAttribute(page);
	}

	@RequestMapping(value = "/user/selectUsers")
	public void selectUsers(User user, Integer pageIndex, Integer pageSize, Model model) {
		Page page = userService.getUsersPage(user, pageIndex, pageSize);
		model.addAttribute(page);
	}

	@ResponseBody
	@RequestMapping(value = "/user/saveUser")
	public SuccessOrFailure saveUser(User user) {
		try {
			if (userService.isDuplicateUser(user)) {
				return SuccessOrFailure.FAILURE("该用户已存在");
			}
			userService.saveUser(user);
			return SuccessOrFailure.SUCCESS(user.getUserId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}

	@ResponseBody
	@RequestMapping(value = "/user/deleteUser")
	public SuccessOrFailure deleteUser(String userIds) {
		try {
			userService.deleteUser(userIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}

	// added by lanj 2016-06-27 重置密码
	@ResponseBody
	@RequestMapping(value = "/user/updatePassword")
	public SuccessOrFailure updatePassword(String userIds) {
		try {
			userService.updatePassword(userIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/user/getUsers")
	public List<User> getUsers() {
		return userService.getUsers();
	} 
	
	@ResponseBody
	@RequestMapping(value = "/user/approval")
	public SuccessOrFailure approval(String recordId) {
		User user = userService.getUser(recordId);
		if(user == null) return SuccessOrFailure.FAILURE("未找到用户！");
		int approval = 0;
		if(user.getApprovalStatus()!=null && user.getApprovalStatus().trim().length()>0) {
			approval = Integer.parseInt(user.getApprovalStatus());
		}
		userService.saveApproval(recordId, Integer.toString(++approval));
		return SuccessOrFailure.SUCCESS;
	}
	
	@ResponseBody
	@RequestMapping(value = "/user/reject")
	public SuccessOrFailure reject(String recordId) {
		User user = userService.getUser(recordId);
		if(user == null) return SuccessOrFailure.FAILURE("未找到用户");
		if("3".equals(user.getApprovalStatus()) || "4".equals(user.getApprovalStatus())) return SuccessOrFailure.FAILURE("审批已完成无法操作");
		userService.saveApproval(recordId, "4");
		return SuccessOrFailure.SUCCESS;
	}
}
