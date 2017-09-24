package com.cnten.bdlocation.bdlocManager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.clients.clientInfo.service.ClientBaseInfoService;
import com.cnten.bdlocation.clients.mgtcenter.MgtCenterService;
import com.cnten.bdlocation.companytemp.service.CompanyTempService;
import com.cnten.platform.system.service.RoleService;
import com.cnten.platform.system.service.UserService;
import com.cnten.platform.web.Constants;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.CompanyTemp;
import com.cnten.po.Role;
import com.cnten.po.User;

@Controller
public class BDLMgtLoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private CompanyTempService companyTempService;
	@Autowired
	private MgtCenterService mgtCenterService;
	@Autowired
	private ClientBaseInfoService clientBaseInfoService;
	
	
	/**
	 * 
	 * @param userCode		登录账号
	 * @param password		登录密码
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/bdloc/login", method = RequestMethod.POST)
	public SuccessOrFailure login(String userCode, String password, String operateType){
		return doLogin(userCode, password);
	}
	
	private SuccessOrFailure doLogin(String userCode, String password){
		User user = userService.login("", userCode, password);
		if(user == null){
			return SuccessOrFailure.FAILURE("用户名或密码错误");
		}
		Role role = roleService.getRoleByUserId(user.getUserId());
		if(!Constants.REGISTER_USER_ROLE_KEY.equals(role.getRoleId())){
			return SuccessOrFailure.FAILURE("对不起,您没有登录权限!");
		}
		
		Map<String,Object> staticData = mgtCenterService.getCorsStatisticOfAll(user.getCompany());
		
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("user", user);
		result.put("staticData", staticData);
	
		return SuccessOrFailure.SUCCESS(result);
	}
	
	@ResponseBody
	@RequestMapping(value="/bdloc/register", method = RequestMethod.POST)
	public SuccessOrFailure mobileRegister(CompanyTemp companyTemp){
		boolean result = companyTempService.saveApproveCompanyTemp(companyTemp);
		if(result){
			return doLogin(companyTemp.getUserCode(), companyTemp.getPassword());
		}else{
			return SuccessOrFailure.FAILURE("注册失败!");
		}
	}
	
	//快速保存
	@ResponseBody
	@RequestMapping(value="/bdloc/saveQuickInfo")
	public SuccessOrFailure saveQuickInfo(User user){
		clientBaseInfoService.saveQuickUser(user);
		return SuccessOrFailure.SUCCESS("保存成功！");
	}
	
	//更新密码
	@ResponseBody
	@RequestMapping(value="/bdloc/updatePwd")
	public SuccessOrFailure updatePwd(String userId,String pwd){
		return clientBaseInfoService.updatePwd(userId,pwd);
	}
}
