package com.cnten.httpClient.main;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import com.alibaba.fastjson.JSON;
import com.cnten.httpClient.request.HttpRequestUtils;

public class MainTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		//	test1();
		testStationRealTime();
		//testCorsRealTime();
	}
	private static void testStationRealTime(){
		ParamVO params = new ParamVO();
		List<BaseRealtimeLogs> logsList = new ArrayList<BaseRealtimeLogs>();
		for (int i = 0; i < 12; i++) {
			BaseRealtimeLogs baseStationLogs = new BaseRealtimeLogs();
			baseStationLogs.setStationNo("s20171245120");
			baseStationLogs.setBroadcastData(32423423);
			baseStationLogs.setConnectNums(1657);
			baseStationLogs.setJoinPointer("RCM32");
			baseStationLogs.setJoinTime(new Date());
			baseStationLogs.setStationState("0");
			logsList.add(baseStationLogs);
		}
		params.setList(JSON.toJSONString(logsList));
		
		String url = "http://192.168.1.171:8080/BDLocation/bdloc/realtime/stationdata";
		HttpRequestUtils.httpPost(url, params);
	}
	
	private static void testCorsRealTime(){
		ParamVO params = new ParamVO();
		
		List<CorsRealtimeLogs> logsList = new ArrayList<CorsRealtimeLogs>();
		for (int i = 0; i < 12; i++) {
			CorsRealtimeLogs corsLogs = new CorsRealtimeLogs();
			corsLogs.setAccess("1");
			corsLogs.setAccountCode("BJMAC0007");
			corsLogs.setDeviceSn("sn:32324234f");
			corsLogs.setFixRate("1.x33");
			corsLogs.setAccess("127.0.0.1");
			corsLogs.setRangeMgt("大屏");
			corsLogs.setResolveType("1");
			corsLogs.setReceiveData(12340);
			corsLogs.setSendData(2343);
			corsLogs.setReceiveCounts(128);
			corsLogs.setSendCounts(125);
			logsList.add(corsLogs);
		}
		params.setList(JSON.toJSONString(logsList));
		
		String url = "http://192.168.1.171:8080/BDLocation/bdloc/realtime/corsdata";
		HttpRequestUtils.httpPost(url, params);
		System.out.println("==========>>>>");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void test1(){
		CompanyTemp companyTemp = new CompanyTemp();
		companyTemp.setAddress("1253451255");
		companyTemp.setCompanyTempName("中学");
		companyTemp.setContacts("13562536253");
		
		List temp = new ArrayList<CompanyTemp>();
		temp.add(companyTemp);
		temp.add(companyTemp);
		
		ParamVO params = new ParamVO();
		params.setList(JSON.toJSONString(temp));
		
		Map map = new HashMap();
		map.put("test", companyTemp);
		map.put("zx", companyTemp);
		params.setMap(JSON.toJSONString(map));
		String url = "http://192.168.1.171:8080/BDLocation/bdloc/realtime/corsdata";
		HttpRequestUtils.httpPost(url, params);
		System.out.println("==========>>>>");
	}
}
