package com.cnten.httpClient.main;
public class CorsRealtimeLogs {
	private String corsRealtimeLogsId;				//cors日志id
	private String accountCode;						//账号
	private String deviceSn;						//设备机型
	private String access;							//接入点
	private String resolveType;						//解类型
	private String fixRate;							//固定率
	private Integer sendCounts;						//发计数
	private Integer receiveCounts;					//接计数
	private Integer receiveData;					//接受数据
	private Integer sendData;						//发送数据
	private String rangeMgt;						//区域管理
	
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
}
