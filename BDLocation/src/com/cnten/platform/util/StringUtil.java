package com.cnten.platform.util;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {
	
	public static String formatDate(Date date){
		if(date == null){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
		return sdf.format(date);
	}
	
	public static String formatDateTime(Date date){
		if(date == null){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		return sdf.format(date);
	}
	
	public static String getDictName(String dictValue,String dictStatement){
		if(StringUtils.isBlank(dictValue) || StringUtils.isBlank(dictStatement)){
			return null;
		}
		for(String valueAndName : dictStatement.split(";")){
			String[] arr = valueAndName.split(",");
			if(dictValue.equals(arr[0])){
				return arr[1];
			}
		}
		return null;
	}
	
	public static String enCode(String path, String enCode) {
		try {
			return new String(path.getBytes(), enCode);
		} catch (UnsupportedEncodingException e) {
		}
		return path;
	}
	
	/**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str) {
        if(str != null) {
            str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串是否非空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
