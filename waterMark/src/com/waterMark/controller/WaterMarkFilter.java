package com.waterMark.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/5/9 0009.
 */
public class WaterMarkFilter implements Filter {

    private String waterMarkFile;
    public void init(FilterConfig config) throws ServletException {
        String file = config.getInitParameter("waterMarkFile");
        waterMarkFile = config.getServletContext().getRealPath(file);
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        chain.doFilter(req, resp);

    }


    public void destroy() {}
}
