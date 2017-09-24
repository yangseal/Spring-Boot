package com.cnten.bdlocation.constants;
/**
 * 基站管理常量类
 * @author Administrator
 *
 */
public class BaseStationConsts {
	
	//基站任务下发状态
	public static final String BASE_STATION_TASK_UNSENDDOWN = "unsenddown";  //未下发
	public static final String BASE_STATION_TASK_SENDDOWNED = "senddowned";  //已下发
	
	//基站建设阶段
	public static final String BASE_STATION_BUILD_STAGE_1 = "JSZ";      //建设中
	public static final String BASE_STATION_BUILD_STAGE_2 = "TJYS";      //已提交验收申请
	public static final String BASE_STATION_BUILD_STAGE_3 = "YYS";      //已验收
	public static final String BASE_STATION_BUILD_STAGE_4 = "YBA";      //已备案
	public static final String BASE_STATION_BUILD_STAGE_5 = "YBH";      //已驳回
	
	//基站建设验收状态
	public static final String BASE_STATION_CHECK_STATE_0 = "WYS";		 //未验收
	public static final String BASE_STATION_CHECK_STATE_1 = "YYS";       //已验收
	public static final String BASE_STATION_CHECK_STATE_2 = "YBH";       //已驳回
	public static final String BASE_STATION_CHECK_STATE_3 = "TJYS";      //已提交验收申请
	
	//基站建设备案状态
	public static final String BASE_STATION_RECORD_STATE_0 = "WBA";		//未备案
	public static final String BASE_STATION_RECORD_STATE_1 = "YBA";		//已备案
	
	//基站建设 验收
	public static final String BASE_STATION_CHECK_RLT_0 = "NO";         //驳回
	public static final String BASE_STATION_CHECK_RLT_1 = "YES";		//通过
    
	//基站建站类型
	public static final String BASE_STATION_CHECK_TYPE_0 ="ZJ";         //自建
	public static final String BASE_STATION_CHECK_TYPE_1 ="HZJZ";       //合作建站
	public static final String BASE_STATION_CHECK_TYPE_2 ="TG";         //托管
}
