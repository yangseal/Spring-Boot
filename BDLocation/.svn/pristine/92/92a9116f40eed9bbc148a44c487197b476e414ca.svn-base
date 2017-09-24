package com.cnten.platform.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 各种规则生成类
 * @author Administrator
 */
public class OrderNoCreateUtil {
	/**
	 * 订单编号生成(新增、续费)
	 * @return
	 */
	public static String getCorsApplyOrderNo(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmm");
        String str=sdf.format(new Date());
		return str+(int)((Math.random()*9+1)*1000);
	}
}
