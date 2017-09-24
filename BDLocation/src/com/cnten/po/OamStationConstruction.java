package com.cnten.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.cnten.platform.util.StringUtil;

@Entity
public class OamStationConstruction {

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String oamStationConstructionId;
    @ManyToOne
    @JoinColumn(name="oam_project_construction_id")
    private OamProjectConstruction oamProjectConstruction;
    @ManyToOne
    @JoinColumn(name="oam_base_station_id")
    private OamBaseStation oamBaseStation;
    @Column(length = 1)
    private String installAntenna;
    public static final String installAntennaDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String installwiring;
    public static final String installwiringDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String mainframeRoom;
    public static final String mainframeRoomDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String installMainframe;
    public static final String installMainframeDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String updateData;
    public static final String updateDataDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String updatePosition;
    public static final String updatePositionDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String mainframeRegiter;
    public static final String mainframeRegiterDictStatement = "1,是;0,否";
    private Date observationStartTime;
    private Date observationEndTime;
    @Column(length = 1)
    private String isDelete;
    
    public String getOamStationConstructionId() {
    	return oamStationConstructionId;
    }
    public void setOamStationConstructionId(String oamStationConstructionId) {
    	this.oamStationConstructionId = oamStationConstructionId;
    }
    /**
     * 获得项目建设
     * @return oamProjectConstruction
     */
    public OamProjectConstruction getOamProjectConstruction() {
    	return oamProjectConstruction;
    }
    /**
     * 设置项目建设
     * @param oamProjectConstruction
     */
    public void setOamProjectConstruction(OamProjectConstruction oamProjectConstruction) {
    	this.oamProjectConstruction = oamProjectConstruction;
    }
    /**
     * 获得基站
     * @return oamBaseStation
     */
    public OamBaseStation getOamBaseStation() {
    	return oamBaseStation;
    }
    /**
     * 设置基站
     * @param oamBaseStation
     */
    public void setOamBaseStation(OamBaseStation oamBaseStation) {
    	this.oamBaseStation = oamBaseStation;
    }
    /**
     * 获得安装天线
     * <br/>
     * 字典语句(1,是;0,否)
     * @return installAntenna
     */
    public String getInstallAntenna() {
    	return installAntenna;
    }
    /**
     * 获得安装天线名称
     * @return installAntennaName
     */
    public String getInstallAntennaName() {
    	return StringUtil.getDictName(installAntenna,installAntennaDictStatement);
    }
    /**
     * 设置安装天线
     * <br/>
     * 字典语句(1,是;0,否)
     * @param installAntenna
     */
    public void setInstallAntenna(String installAntenna) {
    	this.installAntenna = installAntenna;
    }
    /**
     * 获得布设线缆
     * <br/>
     * 字典语句(1,是;0,否)
     * @return installwiring
     */
    public String getInstallwiring() {
    	return installwiring;
    }
    /**
     * 获得布设线缆名称
     * @return installwiringName
     */
    public String getInstallwiringName() {
    	return StringUtil.getDictName(installwiring,installwiringDictStatement);
    }
    /**
     * 设置布设线缆
     * <br/>
     * 字典语句(1,是;0,否)
     * @param installwiring
     */
    public void setInstallwiring(String installwiring) {
    	this.installwiring = installwiring;
    }
    /**
     * 获得布置机房
     * <br/>
     * 字典语句(1,是;0,否)
     * @return mainframeRoom
     */
    public String getMainframeRoom() {
    	return mainframeRoom;
    }
    /**
     * 获得布置机房名称
     * @return mainframeRoomName
     */
    public String getMainframeRoomName() {
    	return StringUtil.getDictName(mainframeRoom,mainframeRoomDictStatement);
    }
    /**
     * 设置布置机房
     * <br/>
     * 字典语句(1,是;0,否)
     * @param mainframeRoom
     */
    public void setMainframeRoom(String mainframeRoom) {
    	this.mainframeRoom = mainframeRoom;
    }
    /**
     * 获得安装主机
     * <br/>
     * 字典语句(1,是;0,否)
     * @return installMainframe
     */
    public String getInstallMainframe() {
    	return installMainframe;
    }
    /**
     * 获得安装主机名称
     * @return installMainframeName
     */
    public String getInstallMainframeName() {
    	return StringUtil.getDictName(installMainframe,installMainframeDictStatement);
    }
    /**
     * 设置安装主机
     * <br/>
     * 字典语句(1,是;0,否)
     * @param installMainframe
     */
    public void setInstallMainframe(String installMainframe) {
    	this.installMainframe = installMainframe;
    }
    /**
     * 获得数据上发
     * <br/>
     * 字典语句(1,是;0,否)
     * @return updateData
     */
    public String getUpdateData() {
    	return updateData;
    }
    /**
     * 获得数据上发名称
     * @return updateDataName
     */
    public String getUpdateDataName() {
    	return StringUtil.getDictName(updateData,updateDataDictStatement);
    }
    /**
     * 设置数据上发
     * <br/>
     * 字典语句(1,是;0,否)
     * @param updateData
     */
    public void setUpdateData(String updateData) {
    	this.updateData = updateData;
    }
    /**
     * 获得位置上发
     * <br/>
     * 字典语句(1,是;0,否)
     * @return updatePosition
     */
    public String getUpdatePosition() {
    	return updatePosition;
    }
    /**
     * 获得位置上发名称
     * @return updatePositionName
     */
    public String getUpdatePositionName() {
    	return StringUtil.getDictName(updatePosition,updatePositionDictStatement);
    }
    /**
     * 设置位置上发
     * <br/>
     * 字典语句(1,是;0,否)
     * @param updatePosition
     */
    public void setUpdatePosition(String updatePosition) {
    	this.updatePosition = updatePosition;
    }
    /**
     * 获得主机注册
     * <br/>
     * 字典语句(1,是;0,否)
     * @return mainframeRegiter
     */
    public String getMainframeRegiter() {
    	return mainframeRegiter;
    }
    /**
     * 获得主机注册名称
     * @return mainframeRegiterName
     */
    public String getMainframeRegiterName() {
    	return StringUtil.getDictName(mainframeRegiter,mainframeRegiterDictStatement);
    }
    /**
     * 设置主机注册
     * <br/>
     * 字典语句(1,是;0,否)
     * @param mainframeRegiter
     */
    public void setMainframeRegiter(String mainframeRegiter) {
    	this.mainframeRegiter = mainframeRegiter;
    }
    /**
     * 获得观测开始时间
     * @return observationStartTime
     */
    public Date getObservationStartTime() {
    	return observationStartTime;
    }
    /**
     * 设置观测开始时间
     * @param observationStartTime
     */
    public void setObservationStartTime(Date observationStartTime) {
    	this.observationStartTime = observationStartTime;
    }
    /**
     * 获得观测结束时间
     * @return observationEndTime
     */
    public Date getObservationEndTime() {
    	return observationEndTime;
    }
    /**
     * 设置观测结束时间
     * @param observationEndTime
     */
    public void setObservationEndTime(Date observationEndTime) {
    	this.observationEndTime = observationEndTime;
    }
    public String getIsDelete() {
    	return isDelete;
    }
    public void setIsDelete(String isDelete) {
    	this.isDelete = isDelete;
    }
} 		