package com.cnten.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

/**
 * 坐标联测点 实体类
 * @author Administrator
 */
@Entity
public class BaseLinkPoint {
	@Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
	private String baseLinkPointId;
	@ManyToOne
	@JoinColumn(name="base_station_test_Id")
	private BaseStationTest baseStationTest;
	@Column(length=255)
	private String pointName;
	@Column(length=255)
	private String pointPosition;
	@Column(length=32)
	private String uniteNo;
	@Column(length=32)
	private String isDelete;
	public String getBaseLinkPointId() {
		return baseLinkPointId;
	}
	public void setBaseLinkPointId(String baseLinkPointId) {
		this.baseLinkPointId = baseLinkPointId;
	}
	public BaseStationTest getBaseStationTest() {
		return baseStationTest;
	}
	public void setBaseStationTest(BaseStationTest baseStationTest) {
		this.baseStationTest = baseStationTest;
	}
	public String getPointName() {
		return pointName;
	}
	public void setPointName(String pointName) {
		this.pointName = pointName;
	}
	public String getPointPosition() {
		return pointPosition;
	}
	public void setPointPosition(String pointPosition) {
		this.pointPosition = pointPosition;
	}
	public String getUniteNo() {
		return uniteNo;
	}
	public void setUniteNo(String uniteNo) {
		this.uniteNo = uniteNo;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	
}
