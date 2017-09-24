package com.cnten.platform.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cnten.platform.web.Constants;
import com.cnten.po.User;

public class ContextUtil {

	public static HttpServletRequest getRequest() {
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		return sra.getRequest();
	}
	
	public static HttpServletResponse getResponse() {
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		return sra.getResponse();
	}
	
	public static HttpSession getSession(){
		return getRequest().getSession();
	}
	
	public static Object getSessionAttribute(String key){
		HttpSession session = getRequest().getSession();
		if(session != null && StringUtils.isNotEmpty(key)){
				return session.getAttribute(key);
		}
		return null;
	}
	
	public static void setSessionAttribute(String key,Object value){
		HttpSession session = getRequest().getSession();
		if(session != null){
			if(StringUtils.isNotEmpty(key) && value != null){
				session.setAttribute(key, value);
			}
		}
	}
	
	public static User getCurrentUser(){
		User user = (User)getSession().getAttribute(Constants.USER_SESSION_KEY);
		return user;
	}
	
	public static boolean isSystemUser() {
		User currentUser = getCurrentUser();
		if(currentUser == null){
			return false;
		}
		if ("SYS".equals(currentUser.getCompany().getCompanyCode()) || "CNTEN".equals(currentUser.getCompany().getCompanyCode())) {
			return true;
		}
		return false;
	}
	public static String customerCompanyId() {
		User currentUser = getCurrentUser();
		if(currentUser == null){
			return null;
		}
		if (Constants.REGISTER_USER_ROLE_KEY.equals(currentUser.getRole().getRoleId())) {
			return currentUser.getCompany().getCompanyId();
		}
		return null;
	}
}
