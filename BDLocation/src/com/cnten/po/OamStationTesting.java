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
public class OamStationTesting {

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String oamStationTestingId;
    @ManyToOne
    @JoinColumn(name="oam_project_testing_id")
    private OamProjectTesting oamProjectTesting;
    @ManyToOne
    @JoinColumn(name="oam_base_station_id")
    private OamBaseStation oamBaseStation;
    @Column(length = 1)
    private String entrance;
    public static final String entranceDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String summit;
    public static final String summitDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String wiring;
    public static final String wiringDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String power;
    public static final String powerDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String netWork;
    public static final String netWorkDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String devSave;
    public static final String devSaveDictStatement = "1,是;0,否";
    @Column(length = 100)
    private String otherGT;
    @Column(length = 1)
    private String shelterEffectivity;
    public static final String shelterEffectivityDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String electromagneticEffectivity;
    public static final String electromagneticEffectivityDictStatement = "1,是;0,否";
    private Date observationStartTime;
    @Column(length = 1)
    private String connectBJ;
    public static final String connectBJDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String observationServices;
    public static final String observationServicesDictStatement = "1,是;0,否";
    private Date observationEndTime;
    @Column(length = 1)
    private String observationSize;
    public static final String observationSizeDictStatement = "1,是;0,否";
    @Column(length = 100)
    private String devTrustee;
    @Column(length = 100)
    private String contactsTrustee;
    @Column(length = 1)
    private String dataReportValid;
    public static final String dataReportValidDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String networkValid;
    public static final String networkValidDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String powerValid;
    public static final String powerValidDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String isDelete;
    
    public String getOamStationTestingId() {
    	return oamStationTestingId;
    }
    public void setOamStationTestingId(String oamStationTestingId) {
    	this.oamStationTestingId = oamStationTestingId;
    }
    /**
     * 获得所属项目测试
     * @return oamProjectTesting
     */
    public OamProjectTesting getOamProjectTesting() {
    	return oamProjectTesting;
    }
    /**
     * 设置所属项目测试
     * @param oamProjectTesting
     */
    public void setOamProjectTesting(OamProjectTesting oamProjectTesting) {
    	this.oamProjectTesting = oamProjectTesting;
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
     * 获得进场
     * <br/>
     * 字典语句(1,是;0,否)
     * @return entrance
     */
    public String getEntrance() {
    	return entrance;
    }
    /**
     * 获得进场名称
     * @return entranceName
     */
    public String getEntranceName() {
    	return StringUtil.getDictName(entrance,entranceDictStatement);
    }
    /**
     * 设置进场
     * <br/>
     * 字典语句(1,是;0,否)
     * @param entrance
     */
    public void setEntrance(String entrance) {
    	this.entrance = entrance;
    }
    /**
     * 获得登顶
     * <br/>
     * 字典语句(1,是;0,否)
     * @return summit
     */
    public String getSummit() {
    	return summit;
    }
    /**
     * 获得登顶名称
     * @return summitName
     */
    public String getSummitName() {
    	return StringUtil.getDictName(summit,summitDictStatement);
    }
    /**
     * 设置登顶
     * <br/>
     * 字典语句(1,是;0,否)
     * @param summit
     */
    public void setSummit(String summit) {
    	this.summit = summit;
    }
    /**
     * 获得布线
     * <br/>
     * 字典语句(1,是;0,否)
     * @return wiring
     */
    public String getWiring() {
    	return wiring;
    }
    /**
     * 获得布线名称
     * @return wiringName
     */
    public String getWiringName() {
    	return StringUtil.getDictName(wiring,wiringDictStatement);
    }
    /**
     * 设置布线
     * <br/>
     * 字典语句(1,是;0,否)
     * @param wiring
     */
    public void setWiring(String wiring) {
    	this.wiring = wiring;
    }
    /**
     * 获得电源
     * <br/>
     * 字典语句(1,是;0,否)
     * @return power
     */
    public String getPower() {
    	return power;
    }
    /**
     * 获得电源名称
     * @return powerName
     */
    public String getPowerName() {
    	return StringUtil.getDictName(power,powerDictStatement);
    }
    /**
     * 设置电源
     * <br/>
     * 字典语句(1,是;0,否)
     * @param power
     */
    public void setPower(String power) {
    	this.power = power;
    }
    /**
     * 获得网络
     * <br/>
     * 字典语句(1,是;0,否)
     * @return netWork
     */
    public String getNetWork() {
    	return netWork;
    }
    /**
     * 获得网络名称
     * @return netWorkName
     */
    public String getNetWorkName() {
    	return StringUtil.getDictName(netWork,netWorkDictStatement);
    }
    /**
     * 设置网络
     * <br/>
     * 字典语句(1,是;0,否)
     * @param netWork
     */
    public void setNetWork(String netWork) {
    	this.netWork = netWork;
    }
    /**
     * 获得设备保存
     * <br/>
     * 字典语句(1,是;0,否)
     * @return devSave
     */
    public String getDevSave() {
    	return devSave;
    }
    /**
     * 获得设备保存名称
     * @return devSaveName
     */
    public String getDevSaveName() {
    	return StringUtil.getDictName(devSave,devSaveDictStatement);
    }
    /**
     * 设置设备保存
     * <br/>
     * 字典语句(1,是;0,否)
     * @param devSave
     */
    public void setDevSave(String devSave) {
    	this.devSave = devSave;
    }
    /**
     * 获得其他沟通项目
     * @return otherGT
     */
    public String getOtherGT() {
    	return otherGT;
    }
    /**
     * 设置其他沟通项目
     * @param otherGT
     */
    public void setOtherGT(String otherGT) {
    	this.otherGT = otherGT;
    }
    /**
     * 获得遮挡环境是否达标
     * <br/>
     * 字典语句(1,是;0,否)
     * @return shelterEffectivity
     */
    public String getShelterEffectivity() {
    	return shelterEffectivity;
    }
    /**
     * 获得遮挡环境是否达标名称
     * @return shelterEffectivityName
     */
    public String getShelterEffectivityName() {
    	return StringUtil.getDictName(shelterEffectivity,shelterEffectivityDictStatement);
    }
    /**
     * 设置遮挡环境是否达标
     * <br/>
     * 字典语句(1,是;0,否)
     * @param shelterEffectivity
     */
    public void setShelterEffectivity(String shelterEffectivity) {
    	this.shelterEffectivity = shelterEffectivity;
    }
    /**
     * 获得电磁环境是否达标
     * <br/>
     * 字典语句(1,是;0,否)
     * @return electromagneticEffectivity
     */
    public String getElectromagneticEffectivity() {
    	return electromagneticEffectivity;
    }
    /**
     * 获得电磁环境是否达标名称
     * @return electromagneticEffectivityName
     */
    public String getElectromagneticEffectivityName() {
    	return StringUtil.getDictName(electromagneticEffectivity,electromagneticEffectivityDictStatement);
    }
    /**
     * 设置电磁环境是否达标
     * <br/>
     * 字典语句(1,是;0,否)
     * @param electromagneticEffectivity
     */
    public void setElectromagneticEffectivity(String electromagneticEffectivity) {
    	this.electromagneticEffectivity = electromagneticEffectivity;
    }
    /**
     * 获得连续观测开始时间
     * @return observationStartTime
     */
    public Date getObservationStartTime() {
    	return observationStartTime;
    }
    /**
     * 设置连续观测开始时间
     * @param observationStartTime
     */
    public void setObservationStartTime(Date observationStartTime) {
    	this.observationStartTime = observationStartTime;
    }
    /**
     * 获得连接北京服务器是否成功
     * <br/>
     * 字典语句(1,是;0,否)
     * @return connectBJ
     */
    public String getConnectBJ() {
    	return connectBJ;
    }
    /**
     * 获得连接北京服务器是否成功名称
     * @return connectBJName
     */
    public String getConnectBJName() {
    	return StringUtil.getDictName(connectBJ,connectBJDictStatement);
    }
    /**
     * 设置连接北京服务器是否成功
     * <br/>
     * 字典语句(1,是;0,否)
     * @param connectBJ
     */
    public void setConnectBJ(String connectBJ) {
    	this.connectBJ = connectBJ;
    }
    /**
     * 获得主机安放位置是否考察
     * <br/>
     * 字典语句(1,是;0,否)
     * @return observationServices
     */
    public String getObservationServices() {
    	return observationServices;
    }
    /**
     * 获得主机安放位置是否考察名称
     * @return observationServicesName
     */
    public String getObservationServicesName() {
    	return StringUtil.getDictName(observationServices,observationServicesDictStatement);
    }
    /**
     * 设置主机安放位置是否考察
     * <br/>
     * 字典语句(1,是;0,否)
     * @param observationServices
     */
    public void setObservationServices(String observationServices) {
    	this.observationServices = observationServices;
    }
    /**
     * 获得连续观测结束时间
     * @return observationEndTime
     */
    public Date getObservationEndTime() {
    	return observationEndTime;
    }
    /**
     * 设置连续观测结束时间
     * @param observationEndTime
     */
    public void setObservationEndTime(Date observationEndTime) {
    	this.observationEndTime = observationEndTime;
    }
    /**
     * 获得建站尺寸测量是否完成
     * <br/>
     * 字典语句(1,是;0,否)
     * @return observationSize
     */
    public String getObservationSize() {
    	return observationSize;
    }
    /**
     * 获得建站尺寸测量是否完成名称
     * @return observationSizeName
     */
    public String getObservationSizeName() {
    	return StringUtil.getDictName(observationSize,observationSizeDictStatement);
    }
    /**
     * 设置建站尺寸测量是否完成
     * <br/>
     * 字典语句(1,是;0,否)
     * @param observationSize
     */
    public void setObservationSize(String observationSize) {
    	this.observationSize = observationSize;
    }
    /**
     * 获得收取仪器托管人
     * @return devTrustee
     */
    public String getDevTrustee() {
    	return devTrustee;
    }
    /**
     * 设置收取仪器托管人
     * @param devTrustee
     */
    public void setDevTrustee(String devTrustee) {
    	this.devTrustee = devTrustee;
    }
    /**
     * 获得托管人联系方式
     * @return contactsTrustee
     */
    public String getContactsTrustee() {
    	return contactsTrustee;
    }
    /**
     * 设置托管人联系方式
     * @param contactsTrustee
     */
    public void setContactsTrustee(String contactsTrustee) {
    	this.contactsTrustee = contactsTrustee;
    }
    /**
     * 获得数据报告是否合格
     * <br/>
     * 字典语句(1,是;0,否)
     * @return dataReportValid
     */
    public String getDataReportValid() {
    	return dataReportValid;
    }
    /**
     * 获得数据报告是否合格名称
     * @return dataReportValidName
     */
    public String getDataReportValidName() {
    	return StringUtil.getDictName(dataReportValid,dataReportValidDictStatement);
    }
    /**
     * 设置数据报告是否合格
     * <br/>
     * 字典语句(1,是;0,否)
     * @param dataReportValid
     */
    public void setDataReportValid(String dataReportValid) {
    	this.dataReportValid = dataReportValid;
    }
    /**
     * 获得网络情况是否合格
     * <br/>
     * 字典语句(1,是;0,否)
     * @return networkValid
     */
    public String getNetworkValid() {
    	return networkValid;
    }
    /**
     * 获得网络情况是否合格名称
     * @return networkValidName
     */
    public String getNetworkValidName() {
    	return StringUtil.getDictName(networkValid,networkValidDictStatement);
    }
    /**
     * 设置网络情况是否合格
     * <br/>
     * 字典语句(1,是;0,否)
     * @param networkValid
     */
    public void setNetworkValid(String networkValid) {
    	this.networkValid = networkValid;
    }
    /**
     * 获得电力情况是否合格
     * <br/>
     * 字典语句(1,是;0,否)
     * @return powerValid
     */
    public String getPowerValid() {
    	return powerValid;
    }
    /**
     * 获得电力情况是否合格名称
     * @return powerValidName
     */
    public String getPowerValidName() {
    	return StringUtil.getDictName(powerValid,powerValidDictStatement);
    }
    /**
     * 设置电力情况是否合格
     * <br/>
     * 字典语句(1,是;0,否)
     * @param powerValid
     */
    public void setPowerValid(String powerValid) {
    	this.powerValid = powerValid;
    }
    public String getIsDelete() {
    	return isDelete;
    }
    public void setIsDelete(String isDelete) {
    	this.isDelete = isDelete;
    }
} 		