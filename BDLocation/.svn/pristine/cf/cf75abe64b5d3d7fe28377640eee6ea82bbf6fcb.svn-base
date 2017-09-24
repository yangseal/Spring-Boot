package com.cnten.platform.web;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.po.CorsAccount;

public class UserStatusInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		
		//记录上次请求路径（试用申请提交 、正式服务清单）
		String requestPath = request.getRequestURI().toString();
		request.getSession().setAttribute(Constants.LAST_REQUEST_PATH_KEY,"");
		if(requestPath.indexOf(Constants.REQUEST_PATH_FORMAL_APPLY) != -1 ||
									requestPath.indexOf(Constants.REQUEST_PATH_TEST_APPLY_SUBMIT) != -1) {
			String requestQuery = request.getQueryString();
			if(requestQuery != null && !"".equals(requestQuery))requestPath += "?" +requestQuery;
			request.getSession().setAttribute(Constants.LAST_REQUEST_PATH_KEY,requestPath);
		}
		if(requestPath.indexOf(Constants.REQUEST_PATH_DO_REPLY_POST) != -1 || 
				requestPath.indexOf(Constants.REQUEST_PATH_SHOW_SEND_POST) != -1 || 
				requestPath.indexOf(Constants.REQUEST_PATH_MYFORUMNAV) != -1 || 
				requestPath.indexOf(Constants.FORUM_LOGIN_PATH) != -1){
			request.getSession().setAttribute(Constants.LAST_REQUEST_PATH_KEY,Constants.REQUEST_PATH_FORUM_INDEX);
		}
		
		Object user = request.getSession().getAttribute(Constants.USER_SESSION_KEY);
		if(user != null){
			request.getSession().setAttribute(Constants.LAST_REQUEST_PATH_KEY,"");
			return true;
		}
		String companyId = request.getParameter("companyId");
		String corsAccountId = request.getParameter("corsAccountId");
		if(StringUtils.isNotBlank(companyId) && StringUtils.isNotBlank(corsAccountId)){
			WebApplicationContext ac1 = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
			CommonDAO commonDAO = ac1.getBean(CommonDAO.class);
			String hql = "from CorsAccount where isDelete is null and corsAccountId = ? and company.companyId = ?";
			CorsAccount corsAccount = commonDAO.getByVariableParam(hql, corsAccountId, companyId);
			if(corsAccount != null){
				return true;
			}
		}
		if(request.getHeader("x-requested-with")!= null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){//如果是ajax请求响应头会有x-requested-with 
            	ServletOutputStream out = response.getOutputStream();
                out.print("unlogin");//返回给前端页面的未登陆标识
                out.flush();
                out.close();
                return false;
		}else{
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.addHeader("SESSION_EXPIRED", "true");
			String url = request.getContextPath() + Constants.LOGIN_PATH;
			response.setHeader("Refresh", "0; URL=" + url);
			return false;
		}
	}

//	@Override
//	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,
//						   ModelAndView modelAndView) throws Exception {
//		super.postHandle(request, response, handler, modelAndView);
//		System.out.print("modelAndView:"+modelAndView);
//		modelAndView.addObject("encyptPublicKey", "323232423424zx");
//	}
//
//	@Override
//	public void afterCompletion(HttpServletRequest request,
//			HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//		// TODO Auto-generated method stub
//		super.afterCompletion(request, response, handler, ex);
//		
//		System.out.print("afterCompletion:"+handler);
//	}
	
}
