package com.cnten.platform.web;

import java.io.IOException;
import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.util.RSAUtil;
import com.cnten.platform.util.StringUtil;

public class EncyptFormDataFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// 解密数据
		Map<String, String[]> params = new HashMap<String, String[]>();
		try {
			String parms = request.getParameter("data");
			RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) ContextUtil.getSessionAttribute(Constants.ENCYPT_PRIVATE_KEY);
			if (parms != null && StringUtil.isNotEmpty(parms)
					&& rsaPrivateKey != null) {
				JSONObject jsonParams = JSON.parseObject(RSAUtil.decryptByPrivateKey(parms, rsaPrivateKey));
				Set<String> iterator = jsonParams.keySet();
				for (String item : iterator) {
					params.put(item,new String[] { jsonParams.getString(item) });
				}
			}
			if (params.size() == 0) {
				params = request.getParameterMap();
			}
			ParameterRequestWrapper modifyWrapper = new ParameterRequestWrapper(
					(HttpServletRequest) request, params);
			chain.doFilter(modifyWrapper, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 继承HttpServletRequestWrapper，创建装饰类，以达到修改HttpServletRequest参数的目的
	 */
	private class ParameterRequestWrapper extends HttpServletRequestWrapper {

		private Map<String, String[]> params;

		public ParameterRequestWrapper(HttpServletRequest request,
				Map<String, String[]> newParams) {
			super(request);

			this.params = newParams;
		}

		@Override
		public String getParameter(String name) {
			String result = "";

			Object v = params.get(name);
			if (v == null) {
				result = null;
			} else if (v instanceof String[]) {
				String[] strArr = (String[]) v;
				if (strArr.length > 0) {
					result = strArr[0];
				} else {
					result = null;
				}
			} else if (v instanceof String) {
				result = (String) v;
			} else {
				result = v.toString();
			}

			return result;
		}

		@Override
		public Map getParameterMap() {
			return params;
		}

		@Override
		public Enumeration getParameterNames() {
			return new Vector(params.keySet()).elements();
		}

		@Override
		public String[] getParameterValues(String name) {
			String[] result = null;

			Object v = params.get(name);
			if (v == null) {
				result = null;
			} else if (v instanceof String[]) {
				result = (String[]) v;
			} else if (v instanceof String) {
				result = new String[] { (String) v };
			} else {
				result = new String[] { v.toString() };
			}

			return result;
		}

	}
}