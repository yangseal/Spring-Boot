package com.hj.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) res;
		//获取session中的用户名
		HttpSession session=request.getSession();
        String userLoginName=(String) session.getAttribute("userLoginNames");
        //
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
        
        if(!request.getRequestURI().equals("/login.jsp")){ //判断是否为登陆页面， 排除过滤登陆页面
        	if(userLoginName ==null || "".equals(userLoginName)){
            	
            	response.sendRedirect(basePath+"/login.jsp");
            }else{
            	//不过滤
            	chain.doFilter(req, res);
            }
        }else{
        	//不过滤
        	chain.doFilter(req, res);
        }
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
