package com.cnten.bdlocation.constants;

/**
 * 系统用到的常量类
 * @author Administrator
 */
public class CorsAccountConsts {
	
	//客户 公司营业执照附件  entityName
	public static final String COMPANY_LICENSE_ENTITY_NAME = "companyLicense";  //单独生成  缩略图
	
	//是否删除
	public static final String IS_DELETE = "Y";
	//前台展示的列表数据条数
	public static final Integer FRONT_DISPLAY_PAGER_SIZE = 10; 				//(固定)数据条数
	
	//业务审批类型
	public static final String BUSI_APPROVE_MATERIAL = "material";   				//企业资质审批
	public static final String BUSI_APPROVE_ADD_APPLY = "open";					//Cores新增审批
	public static final String BUSI_APPROVE_REPAY_APPLY = "repay";				//cors续费审批
	
	
	//账号入网精度
	public static final String ACCOUNT_NET_PRECISION_centimeter = "centimeter";				//厘米级
	public static final String ACCOUNT_NET_PRECISION_meter = "meter";				//亚米级
	public static final String ACCOUNT_NET_PRECISION_mi = "milevel";				//米级
	public static final String ACCOUNT_NET_PRECISION_centimeter_name = "厘米级";				//厘米级
	public static final String ACCOUNT_NET_PRECISION_meter_name = "亚米级";				//亚米级
	public static final String ACCOUNT_NET_PRECISION_mi_name = "米级";				//米级
	
	//账号类型
	public static final String ACCOUNT_TYPE_NORMAL = "formal";						//正式账号
	public static final String ACCOUNT_TYPE_TEST = "test";							//试用账号
	
	//临时账号前缀
	public static final String TEST_ACCOUNT_PREFIX = "TEST_";				//临时账号前缀
	
	//Cores账号状态		
	public static final String ACCOUNT_STATE_UNACTIVE = "unactive";					//未激活
	public static final String ACCOUNT_STATE_NORMAL = "normal";					//启用中
	public static final String ACCOUNT_STATE_JUST_EXPIRE = "soon";				//即将过期
	public static final String ACCOUNT_STATE_INVALID = "expired";					//已过期
	
	public static final String ACCOUNT_DEVICE_UNBIND = "unbind";				//未绑定
	public static final String ACCOUNT_DEVICE_BINDED = "binded";				//已绑定
	public static final String ACCOUNT_ACTIVE_SUM = "actived";					//已激活
	public static final String ACCOUNT_OF_SUM = "sumAccount";					//总配额

	//账号操作环节
	public static final String ACCOUNT_STAGE_UNACTIVE = "UA";				//未激活
	public static final String ACCOUNT_STAGE_ACTIVE_REQUEST = "AQ";			//激活已申请
	public static final String ACCOUNT_STAGE_ACTIVED = "A";					//激活完成
	public static final String ACCOUNT_STAGE_REPAY_UNREQUEST = "RU";        //续费待申请
	public static final String ACCOUNT_STAGE_REPAY_REQUEST = "RR";				//续费已申请
	public static final String ACCOUNT_STAGE_REPAY_APPROVED = "RA";			//续费通过
	public static final String ACCOUNT_STAGE_REPAY_UNAPPROVED = "RN";			//续费未通过
	public static final String ACCOUNT_STAGE_REPAY_DEALED = "RD";				//续费完成

	
	//企业资料审批
	public static final String ACCOUNT_STATE_EXAMINE_NOTE = "0";			//未审核(未认证)
	public static final String ACCOUNT_STATE_EXAMINE_PROCEED = "1";			//审核中(未认证)
	public static final String ACCOUNT_STATE_EXAMINE_PASS = "2";		//已通过(已认证)
	public static final String ACCOUNT_STATE_EXAMINE_REFUSE = "3";		//已拒绝(认证未通过)
	public static final String ACCOUNT_STATE_EXAMINE_SAVE = "4";			//已保存(未认证)
	//客户企业资料状态展示
	public static final String ACCOUNT_STATE_NAME_APPROVING = "未认证";
	public static final String ACCOUNT_STATE_NAME_APPROVED = "已认证";
	public static final String ACCOUNT_STATE_NAME_UNAPPROVED = "认证未通过";
	
	
	//cors账号申请 续费申请 审批状态
	public static final String BUSI_APPROVE_STATE_SUBMIT = "4";		   	//已提交(未审批)
	public static final String BUSI_APPROVE_STATE_PASS = "5";          	//已通过(已完成)
	public static final String BUSI_APPROVE_STATE_REJECT = "6";       	//已拒绝(已取消)
	public static final String BUSI_APPROVE_STATE_SAVE = "7";			//未提交
	
	
	//审批表审批结果
	public static final String APPROVE_RESULT_YES = "YES";				//通过
	public static final String APPROVE_RESULT_NO = "NO";				//未通过

	//CORS_BUSI_APPROVE 是否处理 状态
	public static final String  ACCOUNT_APPROVE_UNDEAL = "0" ;	//未处理
	public static final String  ACCOUNT_APPROVE_DEAL = "1" ;	//已处理
	
	//账号激活类型 
	public static final String ACCOUNT_ACTIVE_TYPE_ACTIVE = "ACTIVE";  //账号激活
	public static final String ACCOUNT_ACTIVE_TYPE_REPAY = "REPAY";    //账号续费
	
	//申请材料状态
	public static final String APPLY_MATERIAL_STATE_WWS = "WWS";			//未完善
	public static final String APPLY_MATERIAL_STATE_YWS = "YWS";        //已完善
	
	//账号激活（续费）处理状态
	public static final String ACCOUNT_ACTIVE_DEAL_STATE_0 = "0";   			//激活未处理（续费未处理）
	public static final String ACCOUNT_ACTIVE_DEAL_STATE_1 = "1";			//激活已处理（续费已处理）
	
	//账号生成状态
	public static final String APPLY_ACCOUNT_CREATE_STATE_0 = "NO";			//未生成
	public static final String APPLY_ACCOUNT_CREATE_STATE_1 = "YES";   		//已生成
	
	//cors 试用账号配置常量
	public static final Integer ACCOUNT_TYPE_TEST_NUM =	3; 			//账号数量
	public static final Integer ACCOUNT_TYPE_TEST_PERIOD = 1;		 //试用期限（月）
	
	//是否到账
	public static final String IS_INTO_ACCOUNT_YES = "YES";		//已到账
	public static final String IS_INTO_ACCOUNT_NO = "NO";		//未到账

	//订单类型
	public static final String CORS_ORDER_TYPE_TRIAL = "torder";		//test-order 试用订单
	public static final String CORS_ORDER_TYPE_BUY = "forder";			//formal-order 购买订单
	public static final String CORS_ORDER_TYPE_RENEW = "rorder";		//renew-order续费订单、
	
	
	//邮件发送主题
	public static final String COMPANY_MATERIAL_APPROVE_SUBJECT = "北斗精准位置网申请公司资质审核";
	public static final String CORSACCOUNT_ORDER_APPROVE_SUBJECT = "北斗精准位置CORS账号订单审核邮件";
	public static final String CORSACCOUNT_EXPIRE_REMIND_SUBJECT = "cors入网账号续费提醒";
	
	//邮件发送结果
	public static final String MAIL_SEND_SUCCESS = "success";		//发送成功
	public static final String MAIL_SEND_FAIL = "fail";				//发送失败
	
	//账号属性
	public static final Integer ACCOUNT_UNREAL_NUM = 5;	                //20个非真实cors账号
	public static final Integer ACCOUNT_FOR_ADMIN_NUM = 5;					//注册公司 默认分配 5 管理员账号
	public static final String CORS_FEATURE_CORSADMIN = "1";				//admin
	public static final String CORS_FEATURE_REALCORS = "2";					//real cors
	public static final String CORS_DEFAULT_PWD = "123456";
	
	//账号用途
	public static final String ACCOUNT_USE_0="110";
	public static final String ACCOUNT_USE_1="120";
	public static final String ACCOUNT_USE_2="119";
	public static final String ACCOUNT_USE_3="QJC";                     //清洁车
	public static final String ACCOUNT_USE_4="ZTC";                     //渣土车
	public static final String ACCOUNT_USE_5="XLJC";                     //泄漏检测
	public static final String ACCOUNT_USE_6="ZNXJ";                     //智能巡检
	public static final String ACCOUNT_USE_7="GCCL";                     //工程测量
}
