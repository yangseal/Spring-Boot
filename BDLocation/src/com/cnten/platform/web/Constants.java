package com.cnten.platform.web;

public interface Constants {
	
	public static final String USER_SESSION_KEY = "CURRENT_USER";
	
	public static final String LOGIN_PATH = "/login";
	
	//加密 公私钥 键值
	public static final String ENCYPT_PUBLIC_KEY_EXPONENT = "publicKeyExponent";
	public static final String ENCYPT_PUBLIC_MODULUS = "publicKeyModulus";
	public static final String ENCYPT_PRIVATE_KEY = "privateKey";
	
	public static final String LAST_REQUEST_PATH_KEY = "LAST_REQUEST_PATH"; //上次请求路径
	
	public static final String REQUEST_PATH_FORMAL_APPLY = "/client/service/formalApplyConfig";
	
	public static final String REQUEST_PATH_TEST_APPLY_SUBMIT = "/client/service/testServiceSubmit";
	
	public static final String COMPANY_MATERIAL_SUBMIT = "/client/mgtCenter/clientInfo/showInfo";
	
    public static final String REQUEST_PATH_DO_REPLY_POST = "/forum/doReplyPost"; //论坛回复贴
    
    public static final String REQUEST_PATH_SHOW_SEND_POST = "/forum/showSendPost"; //发贴
    
    public static final String REQUEST_PATH_MYFORUMNAV = "/forum/myForum/myForumNav"; //我的论坛
    
    public static final String REQUEST_PATH_FORUM_INDEX = "/BDLocation/forum/forumIndex"; //论坛主页
    
    public static final String FORUM_LOGIN_PATH = "/forum/forumLogin";
	
	public static final String USER_MENU_SESSION_KEY = "CURRENT_USER_MENU";
	
	public static final String REGISTER_USER_ROLE_KEY = "402881ea5856f039015856f630fc0006";   //北斗企业管理员角色

	
	//服务器访问地址
	//public static final String BDLOCATION_SERVERE_ACCESS_PATH = "http://127.0.0.1:8080/BDLocation";
	public static final String BDLOCATION_SERVERE_ACCESS_PATH = "http://114.115.223.168:9090/";

}
