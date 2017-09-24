package com.cnten.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class CorsRealtimeLogs {
	@Id
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@GeneratedValue(generator = "generator")
	@Column(unique = true, nullable = false, length = 32)
	private String corsRealtimeLogsId;				//cors日志id
	@Column(length = 25)
	private String accountCode;						//账号
	@Column(length = 25)
	private String deviceSn;						//设备机型
	@Column(length = 32)
	private String access;							//接入点
	@Column(length = 25)
	private String resolveType;						//解类型
	public static String dicResolveType = "1:单点解,2:差分解,3:浮点解,4:固定解";
	@Column(length = 25)
	private String fixRate;							//固定率
	@Column(length = 8)
	private Integer sendCounts;						//发计数
	@Column(length = 8)
	private Integer receiveCounts;					//接计数
	@Column(length = 25)
	private Integer receiveData;					//接受数据
	@Column(length = 25)
	private Integer sendData;						//发送数据
	@Column(length = 32)
	private String rangeMgt;						//区域管理
	@Column(length = 32)
	private String onlineTime;						//在线时长
	private Date accessTime;						//接入时间
	
	public String getCorsRealtimeLogsId() {
		return corsRealtimeLogsId;
	}
	public void setCorsRealtimeLogsId(String corsRealtimeLogsId) {
		this.corsRealtimeLogsId = corsRealtimeLogsId;
	}
	public String getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	public String getDeviceSn() {
		return deviceSn;
	}
	public void setDeviceSn(String deviceSn) {
		this.deviceSn = deviceSn;
	}
	public String getAccess() {
		return access;
	}
	public void setAccess(String access) {
		this.access = access;
	}
	public String getResolveType() {
		return resolveType;
	}
	public void setResolveType(String resolveType) {
		this.resolveType = resolveType;
	}
	public String getFixRate() {
		return fixRate;
	}
	public void setFixRate(String fixRate) {
		this.fixRate = fixRate;
	}
	public Integer getSendCounts() {
		return sendCounts;
	}
	public void setSendCounts(Integer sendCounts) {
		this.sendCounts = sendCounts;
	}
	public Integer getReceiveCounts() {
		return receiveCounts;
	}
	public void setReceiveCounts(Integer receiveCounts) {
		this.receiveCounts = receiveCounts;
	}
	public Integer getReceiveData() {
		return receiveData;
	}
	public void setReceiveData(Integer receiveData) {
		this.receiveData = receiveData;
	}
	public Integer getSendData() {
		return sendData;
	}
	public void setSendData(Integer sendData) {
		this.sendData = sendData;
	}
	public String getRangeMgt() {
		return rangeMgt;
	}
	public void setRangeMgt(String rangeMgt) {
		this.rangeMgt = rangeMgt;
	}
	public String getOnlineTime() {
		return onlineTime;
	}
	public void setOnlineTime(String onlineTime) {
		this.onlineTime = onlineTime;
	}
	public Date getAccessTime() {
		return accessTime;
	}
	public void setAccessTime(Date accessTime) {
		this.accessTime = accessTime;
	}
}
