package com.cnten.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.cnten.platform.util.StringUtil;

@Entity
public class OamProjectConstruction {

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String oamProjectConstructionId;
    @ManyToOne
    @JoinColumn(name="oam_project_id")
    private OamProject oamProject;
    @Column(length = 200)
    private String oamProjectConstructionName;
    @Column(length = 1)
    private String services;
    public static final String servicesDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String nrs;
    public static final String nrsDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String software;
    public static final String softwareDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String net;
    public static final String netDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String server;
    public static final String serverDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String nrsConfig;
    public static final String nrsConfigDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String validTesting;
    public static final String validTestingDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String precisionTesting;
    public static final String precisionTestingDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String wgs84;
    public static final String wgs84DictStatement = "1,是;0,否";
    @Column(length = 1)
    private String localCoordinate;
    public static final String localCoordinateDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String isUsedPoint;
    public static final String isUsedPointDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String otherSystem;
    public static final String otherSystemDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String planOfTesting;
    public static final String planOfTestingDictStatement = "1,是;0,否";
    @Column(length = 500)
    private String testingInfo;
    @Column(length = 1)
    private String resultData;
    public static final String resultDataDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String resultReport;
    public static final String resultReportDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String isMeeting;
    public static final String isMeetingDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String isDelete;
    
    public String getOamProjectConstructionId() {
    	return oamProjectConstructionId;
    }
    public void setOamProjectConstructionId(String oamProjectConstructionId) {
    	this.oamProjectConstructionId = oamProjectConstructionId;
    }
    /**
     * 获得所属项目
     * @return oamProject
     */
    public OamProject getOamProject() {
    	return oamProject;
    }
    /**
     * 设置所属项目
     * @param oamProject
     */
    public void setOamProject(OamProject oamProject) {
    	this.oamProject = oamProject;
    }
    /**
     * 获得项目建设名称
     * @return oamProjectConstructionName
     */
    public String getOamProjectConstructionName() {
    	return oamProjectConstructionName;
    }
    /**
     * 设置项目建设名称
     * @param oamProjectConstructionName
     */
    public void setOamProjectConstructionName(String oamProjectConstructionName) {
    	this.oamProjectConstructionName = oamProjectConstructionName;
    }
    /**
     * 获得服务器1.2
     * <br/>
     * 字典语句(1,是;0,否)
     * @return services
     */
    public String getServices() {
    	return services;
    }
    /**
     * 获得服务器1.2名称
     * @return servicesName
     */
    public String getServicesName() {
    	return StringUtil.getDictName(services,servicesDictStatement);
    }
    /**
     * 设置服务器1.2
     * <br/>
     * 字典语句(1,是;0,否)
     * @param services
     */
    public void setServices(String services) {
    	this.services = services;
    }
    /**
     * 获得安装NRS
     * <br/>
     * 字典语句(1,是;0,否)
     * @return nrs
     */
    public String getNrs() {
    	return nrs;
    }
    /**
     * 获得安装NRS名称
     * @return nrsName
     */
    public String getNrsName() {
    	return StringUtil.getDictName(nrs,nrsDictStatement);
    }
    /**
     * 设置安装NRS
     * <br/>
     * 字典语句(1,是;0,否)
     * @param nrs
     */
    public void setNrs(String nrs) {
    	this.nrs = nrs;
    }
    /**
     * 获得安装软件狗
     * <br/>
     * 字典语句(1,是;0,否)
     * @return software
     */
    public String getSoftware() {
    	return software;
    }
    /**
     * 获得安装软件狗名称
     * @return softwareName
     */
    public String getSoftwareName() {
    	return StringUtil.getDictName(software,softwareDictStatement);
    }
    /**
     * 设置安装软件狗
     * <br/>
     * 字典语句(1,是;0,否)
     * @param software
     */
    public void setSoftware(String software) {
    	this.software = software;
    }
    /**
     * 获得注册NET
     * <br/>
     * 字典语句(1,是;0,否)
     * @return net
     */
    public String getNet() {
    	return net;
    }
    /**
     * 获得注册NET名称
     * @return netName
     */
    public String getNetName() {
    	return StringUtil.getDictName(net,netDictStatement);
    }
    /**
     * 设置注册NET
     * <br/>
     * 字典语句(1,是;0,否)
     * @param net
     */
    public void setNet(String net) {
    	this.net = net;
    }
    /**
     * 获得注册SERVER
     * <br/>
     * 字典语句(1,是;0,否)
     * @return server
     */
    public String getServer() {
    	return server;
    }
    /**
     * 获得注册SERVER名称
     * @return serverName
     */
    public String getServerName() {
    	return StringUtil.getDictName(server,serverDictStatement);
    }
    /**
     * 设置注册SERVER
     * <br/>
     * 字典语句(1,是;0,否)
     * @param server
     */
    public void setServer(String server) {
    	this.server = server;
    }
    /**
     * 获得配置NRS
     * <br/>
     * 字典语句(1,是;0,否)
     * @return nrsConfig
     */
    public String getNrsConfig() {
    	return nrsConfig;
    }
    /**
     * 获得配置NRS名称
     * @return nrsConfigName
     */
    public String getNrsConfigName() {
    	return StringUtil.getDictName(nrsConfig,nrsConfigDictStatement);
    }
    /**
     * 设置配置NRS
     * <br/>
     * 字典语句(1,是;0,否)
     * @param nrsConfig
     */
    public void setNrsConfig(String nrsConfig) {
    	this.nrsConfig = nrsConfig;
    }
    /**
     * 获得可行性验证测试
     * <br/>
     * 字典语句(1,是;0,否)
     * @return validTesting
     */
    public String getValidTesting() {
    	return validTesting;
    }
    /**
     * 获得可行性验证测试名称
     * @return validTestingName
     */
    public String getValidTestingName() {
    	return StringUtil.getDictName(validTesting,validTestingDictStatement);
    }
    /**
     * 设置可行性验证测试
     * <br/>
     * 字典语句(1,是;0,否)
     * @param validTesting
     */
    public void setValidTesting(String validTesting) {
    	this.validTesting = validTesting;
    }
    /**
     * 获得精度测试
     * <br/>
     * 字典语句(1,是;0,否)
     * @return precisionTesting
     */
    public String getPrecisionTesting() {
    	return precisionTesting;
    }
    /**
     * 获得精度测试名称
     * @return precisionTestingName
     */
    public String getPrecisionTestingName() {
    	return StringUtil.getDictName(precisionTesting,precisionTestingDictStatement);
    }
    /**
     * 设置精度测试
     * <br/>
     * 字典语句(1,是;0,否)
     * @param precisionTesting
     */
    public void setPrecisionTesting(String precisionTesting) {
    	this.precisionTesting = precisionTesting;
    }
    /**
     * 获得WGS84
     * <br/>
     * 字典语句(1,是;0,否)
     * @return wgs84
     */
    public String getWgs84() {
    	return wgs84;
    }
    /**
     * 获得WGS84名称
     * @return wgs84Name
     */
    public String getWgs84Name() {
    	return StringUtil.getDictName(wgs84,wgs84DictStatement);
    }
    /**
     * 设置WGS84
     * <br/>
     * 字典语句(1,是;0,否)
     * @param wgs84
     */
    public void setWgs84(String wgs84) {
    	this.wgs84 = wgs84;
    }
    /**
     * 获得地方坐标
     * <br/>
     * 字典语句(1,是;0,否)
     * @return localCoordinate
     */
    public String getLocalCoordinate() {
    	return localCoordinate;
    }
    /**
     * 获得地方坐标名称
     * @return localCoordinateName
     */
    public String getLocalCoordinateName() {
    	return StringUtil.getDictName(localCoordinate,localCoordinateDictStatement);
    }
    /**
     * 设置地方坐标
     * <br/>
     * 字典语句(1,是;0,否)
     * @param localCoordinate
     */
    public void setLocalCoordinate(String localCoordinate) {
    	this.localCoordinate = localCoordinate;
    }
    /**
     * 获得是否有已知点
     * <br/>
     * 字典语句(1,是;0,否)
     * @return isUsedPoint
     */
    public String getIsUsedPoint() {
    	return isUsedPoint;
    }
    /**
     * 获得是否有已知点名称
     * @return isUsedPointName
     */
    public String getIsUsedPointName() {
    	return StringUtil.getDictName(isUsedPoint,isUsedPointDictStatement);
    }
    /**
     * 设置是否有已知点
     * <br/>
     * 字典语句(1,是;0,否)
     * @param isUsedPoint
     */
    public void setIsUsedPoint(String isUsedPoint) {
    	this.isUsedPoint = isUsedPoint;
    }
    /**
     * 获得其它位置系统
     * <br/>
     * 字典语句(1,是;0,否)
     * @return otherSystem
     */
    public String getOtherSystem() {
    	return otherSystem;
    }
    /**
     * 获得其它位置系统名称
     * @return otherSystemName
     */
    public String getOtherSystemName() {
    	return StringUtil.getDictName(otherSystem,otherSystemDictStatement);
    }
    /**
     * 设置其它位置系统
     * <br/>
     * 字典语句(1,是;0,否)
     * @param otherSystem
     */
    public void setOtherSystem(String otherSystem) {
    	this.otherSystem = otherSystem;
    }
    /**
     * 获得拟定测试计划
     * <br/>
     * 字典语句(1,是;0,否)
     * @return planOfTesting
     */
    public String getPlanOfTesting() {
    	return planOfTesting;
    }
    /**
     * 获得拟定测试计划名称
     * @return planOfTestingName
     */
    public String getPlanOfTestingName() {
    	return StringUtil.getDictName(planOfTesting,planOfTestingDictStatement);
    }
    /**
     * 设置拟定测试计划
     * <br/>
     * 字典语句(1,是;0,否)
     * @param planOfTesting
     */
    public void setPlanOfTesting(String planOfTesting) {
    	this.planOfTesting = planOfTesting;
    }
    /**
     * 获得测试描述
     * @return testingInfo
     */
    public String getTestingInfo() {
    	return testingInfo;
    }
    /**
     * 设置测试描述
     * @param testingInfo
     */
    public void setTestingInfo(String testingInfo) {
    	this.testingInfo = testingInfo;
    }
    /**
     * 获得解算数据
     * <br/>
     * 字典语句(1,是;0,否)
     * @return resultData
     */
    public String getResultData() {
    	return resultData;
    }
    /**
     * 获得解算数据名称
     * @return resultDataName
     */
    public String getResultDataName() {
    	return StringUtil.getDictName(resultData,resultDataDictStatement);
    }
    /**
     * 设置解算数据
     * <br/>
     * 字典语句(1,是;0,否)
     * @param resultData
     */
    public void setResultData(String resultData) {
    	this.resultData = resultData;
    }
    /**
     * 获得出具报告
     * <br/>
     * 字典语句(1,是;0,否)
     * @return resultReport
     */
    public String getResultReport() {
    	return resultReport;
    }
    /**
     * 获得出具报告名称
     * @return resultReportName
     */
    public String getResultReportName() {
    	return StringUtil.getDictName(resultReport,resultReportDictStatement);
    }
    /**
     * 设置出具报告
     * <br/>
     * 字典语句(1,是;0,否)
     * @param resultReport
     */
    public void setResultReport(String resultReport) {
    	this.resultReport = resultReport;
    }
    /**
     * 获得是否需要召开验收会
     * <br/>
     * 字典语句(1,是;0,否)
     * @return isMeeting
     */
    public String getIsMeeting() {
    	return isMeeting;
    }
    /**
     * 获得是否需要召开验收会名称
     * @return isMeetingName
     */
    public String getIsMeetingName() {
    	return StringUtil.getDictName(isMeeting,isMeetingDictStatement);
    }
    /**
     * 设置是否需要召开验收会
     * <br/>
     * 字典语句(1,是;0,否)
     * @param isMeeting
     */
    public void setIsMeeting(String isMeeting) {
    	this.isMeeting = isMeeting;
    }
    public String getIsDelete() {
    	return isDelete;
    }
    public void setIsDelete(String isDelete) {
    	this.isDelete = isDelete;
    }
} 		