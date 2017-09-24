package com.cnten.platform.websocket.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.websocket.entity.ClientServiceUser;
import com.cnten.platform.websocket.entity.SessionManager;
import com.cnten.platform.websocket.entity.SockedSession;
import com.cnten.po.User;

@Controller
@RequestMapping("/msg")
public class MsgController {

	// 用户登录
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView doLogin(ClientServiceUser user, HttpServletRequest request) {
		user.setId(request.getSession().getId());
		String userType = user.getUserType();
		SockedSession session = SessionManager.getAvailableSession();
		
		if(ClientServiceUser.CLIENT_SERVICE_USER_CUSTOMER.equals(userType)){   //分配    客服人员
			//登录用户直接使用登录信息
			User sysRegisterUser = ContextUtil.getCurrentUser();
			if(sysRegisterUser != null){
				user.setId(sysRegisterUser.getUserId());
				user.setName(sysRegisterUser.getUserName()!=null?sysRegisterUser.getUserName():sysRegisterUser.getUserCode());
			}
			
			if(session != null)
				user.setSendTo(session.getSessionId());
			request.getSession().setAttribute("user", user);
			return new ModelAndView("redirect:customer");
		}
		request.getSession().setAttribute("user", user);
		return new ModelAndView("redirect:cuservice");
	}

	// 跳转到交谈聊天页面
	@RequestMapping(value = "/cuservice", method = RequestMethod.GET)
	public ModelAndView cuservice() {
		return new ModelAndView("cuservice");
	}
	
	// 跳转到交谈聊天页面
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public ModelAndView talk() {
		return new ModelAndView("customer");
	}

	// 跳转到发布广播页面
	@RequestMapping(value = "/broadcast", method = RequestMethod.GET)
	public ModelAndView broadcast() {
		return new ModelAndView("broadcast");
	}
}