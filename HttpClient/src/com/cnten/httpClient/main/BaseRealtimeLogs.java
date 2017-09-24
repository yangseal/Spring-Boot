package com.cnten.httpClient.main;

import java.util.Date;

public class BaseRealtimeLogs {
	private String baseRealtimeLogsId;
	private String stationNo;
	private String joinPointer;
	private Date joinTime;
	private Integer connectNums;
	private String stationState;
	private Integer broadcastData;
	
	public String getBaseRealtimeLogsId() {
		return baseRealtimeLogsId;
	}
	public void setBaseRealtimeLogsId(String baseRealtimeLogsId) {
		this.baseRealtimeLogsId = baseRealtimeLogsId;
	}
	public String getStationNo() {
		return stationNo;
	}
	public void setStationNo(String stationNo) {
		this.stationNo = stationNo;
	}
	public String getJoinPointer() {
		return joinPointer;
	}
	public void setJoinPointer(String joinPointer) {
		this.joinPointer = joinPointer;
	}
	public Integer getConnectNums() {
		return connectNums;
	}
	public void setConnectNums(Integer connectNums) {
		this.connectNums = connectNums;
	}
	public String getStationState() {
		return stationState;
	}
	public void setStationState(String stationState) {
		this.stationState = stationState;
	}
	public Integer getBroadcastData() {
		return broadcastData;
	}
	public void setBroadcastData(Integer broadcastData) {
		this.broadcastData = broadcastData;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
}
