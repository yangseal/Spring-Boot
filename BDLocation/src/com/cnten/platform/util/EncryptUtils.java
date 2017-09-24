package com.cnten.platform.util;

import java.security.MessageDigest;

/**
 * 加密工具类，仅实现MD5,可扩展别的加密算法
 * @author zyt
 *
 */
public class EncryptUtils {
	
	public enum EncType {
		MD5
	}
	
	/**
	 * 按照加密类型加密字串
	 * @param key 密钥
	 * @param orgStr 密码
	 * @return 加密后的字串，如果没有匹配的加密方式，则返回自定义MD5加密
	 */
    public static String encrypt(String orgStr) {
    	return encrypt(orgStr, EncType.MD5);
    }

    /**
     * 按照加密类型加密字串
     * @param orgString 要加密的字串
     * @param encType 加密类型
     * @return 加密后的字串，如果没有匹配的加密方式，则返回原字串 */
    public static String encrypt(String orgStr, EncType encType) {
    	try {
           if (EncType.MD5 == encType) {
               MessageDigest alga = MessageDigest.getInstance("MD5");
               alga.update(orgStr.getBytes());
               byte[] digesta = alga.digest();
               String encodePass = byte2str(digesta);
               return encodePass;
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
    	return orgStr;
    }


    /**
     * the following code is copied form other system example
     * @param b byte info
     * @return string info */
    private static String byte2str(byte[] b) {
        String output = new String("");
        String stmp = "";

        try {
            for (int i = 0; i < b.length; i++) {
                stmp = Integer.toString(b[i] & 0XFF, 16);

                if (stmp.length() == 1) {
                    output += ("0" + stmp);
                } else {
                    output += stmp;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }
}
