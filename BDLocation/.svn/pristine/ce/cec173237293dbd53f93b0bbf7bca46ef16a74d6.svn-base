package com.cnten.vo;

public class OamAreaVO {

	private String oamAreaId;
	private String oamAreaName;
	private Integer stationNumber; //建站数
	private Integer stationNumber2; //已完成建站数
	private Integer plan; //规划建站数
	private Integer areaType;
	private Double longitude;
	private Double latitude;
	
	public String getOamAreaId() {
		return oamAreaId;
	}
	public void setOamAreaId(String oamAreaId) {
		this.oamAreaId = oamAreaId;
	}
	public String getOamAreaName() {
		return oamAreaName;
	}
	public void setOamAreaName(String areaName) {
		this.oamAreaName = areaName;
	}
	public Integer getStationNumber() {
		return stationNumber;
	}
	public void setStationNumber(Integer stationNumber) {
		this.stationNumber = stationNumber;
	}
	public Integer getAreaType() {
		return areaType;
	}
	public void setAreaType(Integer areaType) {
		this.areaType = areaType;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Integer getStationNumber2() {
		return stationNumber2;
	}
	public void setStationNumber2(Integer stationNumber2) {
		this.stationNumber2 = stationNumber2;
	}
	
	public Integer getPlan() {
		return plan;
	}
	public void setPlan(Integer plan) {
		this.plan = plan;
	}
	public OamAreaVO(String oamAreaId,String oamAreaName,Double longitude,Double latitude,Long stationNumber,Long stationNumber2,Long plan){
		this.oamAreaId = oamAreaId;
		this.oamAreaName = oamAreaName;
		this.longitude = longitude;
		this.latitude = latitude;
		this.stationNumber = Integer.valueOf(stationNumber.toString());
		this.stationNumber2 = Integer.valueOf(stationNumber2.toString());
		if(null == plan) {
			this.plan = 0;
		} else {
			this.plan = Integer.valueOf(plan.toString());
		}
		if(stationNumber2 > 0){
			areaType = 2;
		}else{
			areaType = 1;
		}
	}
	
	public OamAreaVO(String oamAreaId,String oamAreaName,Double longitude,Double latitude,Long plan){
		this.oamAreaId = oamAreaId;
		this.oamAreaName = oamAreaName;
		this.longitude = longitude;
		this.latitude = latitude;
		this.plan = Integer.valueOf(plan.toString());
		this.stationNumber2 = 0;
		this.stationNumber = 0;
		areaType = 0;
	}
	
	public OamAreaVO(String oamAreaId,String oamAreaName,Double longitude,Double latitude,Long stationNumber,Long stationNumber2,int type){
		this.oamAreaId = oamAreaId;
		this.oamAreaName = oamAreaName;
		this.longitude = longitude;
		this.latitude = latitude;
		this.stationNumber = Integer.valueOf(stationNumber.toString());
		this.stationNumber2 = Integer.valueOf(stationNumber2.toString());
		if(stationNumber == stationNumber2){
			areaType = 2;
		}else if(stationNumber2 > 0){
			areaType = 1;
		}else{
			areaType = 0;
		}
	}
}
