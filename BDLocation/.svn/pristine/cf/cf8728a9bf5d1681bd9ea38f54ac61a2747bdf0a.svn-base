package com.cnten.po;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class BaseRealtimeLogs {
	@Id
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@GeneratedValue(generator = "generator")
	@Column(unique = true, nullable = false, length = 32)
	private String baseRealtimeLogsId;
	@Column(length=12)
	private String stationNo;
	@Column(length=120)
	private String access;
	private Date joinTime;
	@Column(length=8)
	private Integer connectNums;
	@Column(length=2)
	private String stationState;
	public static final String dicStationState = "0:离线,1:在线";
	@Column(length=32)
	private Integer broadcastData;
	private Date createTime = new Date();
	
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
	public String getAccess() {
		return access;
	}
	public void setAccess(String access) {
		this.access = access;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
