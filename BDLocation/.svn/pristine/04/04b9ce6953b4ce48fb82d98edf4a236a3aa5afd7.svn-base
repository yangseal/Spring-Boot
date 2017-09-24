package com.cnten.platform.web;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.util.RSAUtil;


public class IllegalCharacterInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {	
		//过滤非法字符
		Pattern pattern = Pattern.compile("'|<|>");
		for(String[] paramValues : request.getParameterMap().values()){
			for(String paramValue : paramValues){
				if(pattern.matcher(paramValue).find()){
					return false;
				}
			}
		}
		//生成加密 公私钥
		encyptCreatePublicKey();
		return true;
	}
	
	/**
	 * 	ENCYPT_PUBLIC_KEY_EXPONENT = "publicKeyExponent";
	 * 	ENCYPT_PUBLIC_MODULUS = "publicKeyModulus";
	 * 	ENCYPT_PRIVATE_KEY = "privateKey";
	 * @param request
	 * 生成加密 公钥 、私钥
	 */
	private void encyptCreatePublicKey() {
		String publicKeyExponent = (String) ContextUtil.getSessionAttribute(Constants.ENCYPT_PUBLIC_KEY_EXPONENT);
		String publicKeyModulus = (String) ContextUtil.getSessionAttribute(Constants.ENCYPT_PUBLIC_MODULUS); 
		if(StringUtils.isEmpty(publicKeyExponent) && StringUtils.isEmpty(publicKeyModulus)){
			KeyPair keyPair;
			try {
				keyPair = RSAUtil.generateKeypair();
				RSAPublicKey pubk = (RSAPublicKey) keyPair.getPublic();//生成公钥
		        RSAPrivateKey prik= (RSAPrivateKey) keyPair.getPrivate();//生成私钥

				ContextUtil.setSessionAttribute(Constants.ENCYPT_PUBLIC_KEY_EXPONENT, pubk.getPublicExponent().toString(16));
				ContextUtil.setSessionAttribute(Constants.ENCYPT_PUBLIC_MODULUS, pubk.getModulus().toString(16));
				ContextUtil.setSessionAttribute(Constants.ENCYPT_PRIVATE_KEY, prik);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
