package com.cnten.platform.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.corsaccount.service.CorsAccountService;
import com.cnten.bdlocation.oamarea.service.OamAreaService;
import com.cnten.enums.UserFeature;
import com.cnten.platform.system.service.MenuService;
import com.cnten.platform.system.service.RoleService;
import com.cnten.platform.system.service.UserService;
import com.cnten.platform.util.CommonUtil;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.web.Constants;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.CorsAccount;
import com.cnten.po.Menu;
import com.cnten.po.Role;
import com.cnten.po.User;

@Controller
public class HomeController {
	private static final Logger log4j = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private OamAreaService oamAreaService;
	@Autowired
	private CorsAccountService corsAccountService;

//	@RequestMapping(value = "/")
//	public String index() {
//		return "redirect:/public/propaganda/index.html";
//	}
	
//	@RequestMapping(value = "/")
//	public String index() {
//		return "/propagandas/index";
//	}
	
	@RequestMapping(value = "/")
	public String index() {
		return "/home/login";
	}
	
	@RequestMapping(value = "/home")
	public String home(Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
		List<Menu> menus = new ArrayList<Menu>();
		if(user != null && user.getCompany() != null 
				&& "SYS".equals(user.getCompany().getCompanyCode())){
			menus = menuService.getHomeMenus();
		} else if(user != null && user.getCompany() != null 
				&&"CNTEN".equals(user.getCompany().getCompanyCode())) {
			menus = menuService.getMenus(user.getRole());
		} else if (user != null && user.getCompany() != null){
			if(UserFeature.Company_Dispach_Admin.getValue().equals(user.getUserFeature())
						|| CommonUtil.isCorsAccount(user.getUserCode())){  					//企业自己分配的管理员、6~9999这些业务
				menus = menuService.getMenus(user.getRole());
			} else {
				menus = menuService.getMenus(user.getCompany());
			}
		}
		model.addAttribute("menus", menus);
		return "/home/index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request,HttpServletResponse response){
		try {
		//检测是否已登录，已登录直接跳转
		if(ContextUtil.getCurrentUser() != null){
			Role _role = ContextUtil.getCurrentUser().getRole();
			if(Constants.REGISTER_USER_ROLE_KEY.equals(_role.getRoleId())) {
				return "redirect:/client/index";
			} else {
				return "redirect:/home";
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/home/login";
	}
	
	/**
	 * 1.讯腾人员登录	(查询user表、进入后台，根据角色划分菜单)
	 * 2.注册账号注册	(查询user表、进入客户前端界面，固定菜单)
	 * 3.cors(1-5)企业管理员登录 	 	(查询cors_account表、进入客户前端界面，固定菜单)(不在CORS SERVER端生成真正账号、仅限正式购买账号)
	 * 4.cors(6-20)进入后台，进行任务下发  	(查询cors_account表,进入后台，根据公司菜单赋予菜单权限)(不在CORS SERVER端生成真正账号、仅限正式购买账号)
	 * 5.cors(21-9999)	cors账号登录查看业务数据 		(查询cors_account表，进入后台，根据公司菜单赋予菜单权限) (在CORS SERVER端生成真正账号)
	 * @param companyCode
	 * @param userCode
	 * @param password
	 * @param checkMard
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public SuccessOrFailure login(String companyCode,String userCode,String password,String checkMard,HttpServletRequest request){
		try{
			//暂时注掉，方便开发测试
			if(StringUtils.isNotBlank(checkMard)){
				String _checkMard = (String) request.getSession().getAttribute("checkmard");
				if(!_checkMard.equalsIgnoreCase(checkMard)){
					return SuccessOrFailure.FAILURE("验证码输入错误");
				}
			}
			
			if(!CommonUtil.isCorsAccount(userCode) && !CommonUtil.isCorsAdmin(userCode)){  //注册用户  与  讯腾工作人员登录
				User user = userService.login("", userCode, password);
				if(user == null){
					return SuccessOrFailure.FAILURE("用户名或密码错误");
				}
				
				Role role = roleService.getRoleByUserId(user.getUserId());
				user.setRole(role);
				
				request.getSession().setAttribute(Constants.USER_SESSION_KEY, user);
				
				String lastRequest = (String) request.getSession().getAttribute(Constants.LAST_REQUEST_PATH_KEY);
				if(StringUtils.isNotBlank(lastRequest))
						user.setRequestPath(lastRequest);
				return SuccessOrFailure.SUCCESS(user);
			}else if(CommonUtil.isCorsAdmin(userCode)){//cors 管理员登录
				User user = corsAccountLogin(userCode, password,true);
				if(user != null){
					Role role = roleService.getRole(Constants.REGISTER_USER_ROLE_KEY);
					user.setRole(role);
				}
				request.getSession().setAttribute(Constants.USER_SESSION_KEY, user);
				return SuccessOrFailure.SUCCESS(user);
			}else{  //cors	账号登录平台(cors业务数据查看)
				User user = corsAccountLogin(userCode, password,false);
				request.getSession().setAttribute(Constants.USER_SESSION_KEY, user);
				return SuccessOrFailure.SUCCESS(user);
			}
			
		}catch(Exception e){
			log4j.info("---------登录异常错误------------:"+e.getMessage());
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
		
	}
	
	/**
	 * 精准应用登录
	 * @param corsAccountCode cors账号
	 * @param password cors密码
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value = "/corsLogin", method = RequestMethod.POST)
	public SuccessOrFailure corsLogin(String corsAccountCode, String password) {
		User user = corsAccountLogin(corsAccountCode, password, false);
		if(user == null){
			return SuccessOrFailure.FAILURE("用户名或密码错误");
		}
		//只返回需要的数据不必返回暴漏更多无关数据
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("corsAccountId", user.getUserId());
		map.put("corsAccountCode", user.getUserCode());
		map.put("companyId", user.getCompany().getCompanyId());
		map.put("companyCode", user.getCompany().getCompanyCode());
		map.put("companyName", user.getCompany().getCompanyName());
		map.put("companyOrgId", user.getCompanyOrg().getCompanyOrgId());
		return SuccessOrFailure.SUCCESS(map);
	}
	
	/**
	 * 描述：cors账号登录平台
	 * @param userCode 登录用户名
	 * @param password 登录密码
	 * @param isAdmin (1 ~ 5 cors 管理员、)
	 * @return
	 */
	private User corsAccountLogin(String userCode,String password,boolean isAdmin){
		User user = new User();
		CorsAccount corsAccount = userService.corsLogin(userCode, password);
		if(isAdmin){
			user = userService.getUserByCompany(corsAccount.getCompany().getCompanyId());
			return user;
		}
		if(corsAccount != null){
			Role role = roleService.getRoleByUserId(corsAccount.getCorsAccountId());
			user.setUserId(corsAccount.getCorsAccountId());
			user.setUserCode(corsAccount.getCorsAccountCode());
			user.setCompany(corsAccount.getCompany());
			user.setRole(role);
			user.setCompanyOrg(corsAccount.getCompanyOrg());
			return user;
		}
		return null;
	}
	
	@RequestMapping(value = "/home/updatePassword", method = RequestMethod.GET)
	public void updatePassword(){
	}
	
	@ResponseBody
	@RequestMapping(value = "/home/updatePassword", method = RequestMethod.POST)
	public SuccessOrFailure updatePassword(String oldPassword,String newPassword,HttpServletRequest request){
		try{
			return userService.updatePassword(oldPassword,newPassword,request);
		}catch(Exception e){
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute(Constants.USER_SESSION_KEY);
		return "redirect:/login";
	}
	
	@ResponseBody
	@RequestMapping(value="/detecteLogin")
	public SuccessOrFailure isLogin(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
		return user != null ? SuccessOrFailure.SUCCESS(user) : SuccessOrFailure.FAILURE("未登录");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model){
		return "/home/register";
	}
	
	@RequestMapping(value = "/contactUs")
	public String contactUs() {
		return "/home/contactUs";
	}
}
