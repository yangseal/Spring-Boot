package com.cnten.platform.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {
	private static String OLD_CORS_ACCOUNT_RULE = "[A-Z]{2,6}_[A-Z]{2}_[A-Z|\\d]{2,4}_\\w?\\d{3}";
	private static String FORMAL_CORS_ACCOUNT_RULE = "[A-Z]{4,6}\\d{4}";
	private static String TEST_CORS_ACCOUNT_RULE = "[A-Z]{4,6}_T\\d{4}";
	private static String CORS_ACCOUNT_RULE_RGX = "([A-Z]{4,6})(\\d{4})";
	
	/**
	 * 使用正则判断  登录 是否是 cors账号登录
	 * @param corsAccount
	 * @return
	 */
//	public static boolean isCorsAccount(String corsAccount){
//		// 创建 Pattern 对象
//	    Pattern oldPattern = Pattern.compile(OLD_CORS_ACCOUNT_RULE);
//	    Pattern	testPattern = Pattern.compile(TEST_CORS_ACCOUNT_RULE);
//	    Pattern formalPattern = Pattern.compile(FORMAL_CORS_ACCOUNT_RULE);
//	    Pattern newPattern = Pattern.compile(CORS_ACCOUNT_RULE_RGX);		//对应最新的cors规则
//	    
//	    // 现在创建 matcher 对象
//	    Matcher oldMatcher = oldPattern.matcher(corsAccount);
//	    Matcher testMatcher = testPattern.matcher(corsAccount);
//	    Matcher formalMatcher = formalPattern.matcher(corsAccount);
//	    Matcher newMatcher = newPattern.matcher(corsAccount);
//	    
//	    if(oldMatcher.matches() || testMatcher.matches() || formalMatcher.matches()) {
//	    	return true;
//		}
//		return false;
//	}
	
	/**
	 * 判定规则：
	 * 1. 注册的是企业管理员
	 * 2. CORS0001 ~ CORS0005 ： 企业额外具有的5个管理员账号
	 * 仅限使用最新规则生成的账号
	 * @param corsAccount
	 */
	public static boolean isCorsAdmin(String corsAccount){
	    Pattern newPattern = Pattern.compile(CORS_ACCOUNT_RULE_RGX);		//对应最新的cors规则
	    Matcher newMatcher = newPattern.matcher(corsAccount);
	    if(newMatcher.matches()) {
			Integer corsIndex = Integer.parseInt(newMatcher.group(2));
			if(corsIndex <6){
				return true;
			}
		}
	    return false;
	}
	
	/**
	 * 判断规则：
	 * 1. CNTEN0006 ~ CNTEN9999 : 为企业真实账号数据，具有真正的cors基站账号
	 * 	同样登录 位置网平台   (即后台)
	 * @param corsAccount
	 */
	public static boolean isCorsAccount(String corsAccount){
		// 创建 Pattern 对象
	    Pattern oldPattern = Pattern.compile(OLD_CORS_ACCOUNT_RULE);
	    Pattern	testPattern = Pattern.compile(TEST_CORS_ACCOUNT_RULE);
	    Pattern newPattern = Pattern.compile(CORS_ACCOUNT_RULE_RGX);		//对应最新的cors规则
	    
	 // 现在创建 matcher 对象
	    Matcher oldMatcher = oldPattern.matcher(corsAccount);
	    Matcher testMatcher = testPattern.matcher(corsAccount);
	    Matcher newMatcher = newPattern.matcher(corsAccount);
	    
	    if(oldMatcher.matches() || testMatcher.matches()) {
	    	return true;
		}else if(newMatcher.matches()) {
			Integer corsIndex = Integer.parseInt(newMatcher.group(2));
			if(corsIndex >5){
				return true;
			}
		}
	    return false;
	}
}
