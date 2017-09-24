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
public class OamProject {

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String oamProjectId;
    @Column(length = 100)
    private String oamProjectName;
    @Column(length = 50)
    private String oamProjectCode;
    @ManyToOne
    @JoinColumn(name="oam_customer_id")
    private OamCustomer oamCustomer;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    private Integer stationNum;
    private Integer programme;
    @Column(length = 200)
    private String installationSite;
    @Column(length = 100)
    private String ipAddress;
    @Column(length = 1)
    private String electrification;
    public static final String electrificationDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String servers;
    public static final String serversDictStatement = "1,是;0,否";
    @Column(length = 100)
    private String serversPort;
    @Column(length = 1)
    private String remote;
    public static final String remoteDictStatement = "1,是;0,否";
    @Column(length = 200)
    private String accendant;
    @Column(length = 500)
    private String localPrincipalInfo;
    @Column(length = 500)
    private String localCooperateInfo;
    @Column(length = 1)
    private String preliminaryMeeting;
    @Column(length = 100)
    private String driver;
    @Column(length = 500)
    private String constructionTeam;
    @Column(length = 200)
    private String instrument;
    @Column(length = 200)
    private String testingDev;
    @Column(length = 1)
    private String mainFrameRegister;
    @Column(length = 1)
    private String nrs;
    @Column(length = 100)
    private String implementation;
    @Column(length = 100)
    private String trainOrFlight;
    @Column(length = 200)
    private String grogshop;
    @Column(length = 1)
    private String isDelete;
    public OamProject() {}
    public OamProject(String oamProjectId) {
    	this.oamProjectId = oamProjectId;
	}
	public String getOamProjectId() {
    	return oamProjectId;
    }
    public void setOamProjectId(String oamProjectId) {
    	this.oamProjectId = oamProjectId;
    }
    /**
     * 获得项目名称
     * @return oamProjectName
     */
    public String getOamProjectName() {
    	return oamProjectName;
    }
    /**
     * 设置项目名称
     * @param oamProjectName
     */
    public void setOamProjectName(String oamProjectName) {
    	this.oamProjectName = oamProjectName;
    }
    /**
     * 获得项目编号
     * @return oamProjectCode
     */
    public String getOamProjectCode() {
    	return oamProjectCode;
    }
    /**
     * 设置项目编号
     * @param oamProjectCode
     */
    public void setOamProjectCode(String oamProjectCode) {
    	this.oamProjectCode = oamProjectCode;
    }
    /**
     * 获得所属客户
     * @return oamCustomer
     */
    public OamCustomer getOamCustomer() {
    	return oamCustomer;
    }
    /**
     * 设置所属客户
     * @param oamCustomer
     */
    public void setOamCustomer(OamCustomer oamCustomer) {
    	this.oamCustomer = oamCustomer;
    }
    /**
     * 获得记录人
     * @return user
     */
    public User getUser() {
    	return user;
    }
    /**
     * 设置记录人
     * @param user
     */
    public void setUser(User user) {
    	this.user = user;
    }
    /**
     * 获得建站数量
     * @return stationNum
     */
    public Integer getStationNum() {
    	return stationNum;
    }
    /**
     * 设置建站数量
     * @param stationNum
     */
    public void setStationNum(Integer stationNum) {
    	this.stationNum = stationNum;
    }
    /**
     * 获得规划数量
     * @return programme
     */
    public Integer getProgramme() {
    	return programme;
    }
    /**
     * 设置规划数量
     * @param programme
     */
    public void setProgramme(Integer programme) {
    	this.programme = programme;
    }
    /**
     * 获得服务器安装位置
     * @return installationSite
     */
    public String getInstallationSite() {
    	return installationSite;
    }
    /**
     * 设置服务器安装位置
     * @param installationSite
     */
    public void setInstallationSite(String installationSite) {
    	this.installationSite = installationSite;
    }
    /**
     * 获得服务器IP
     * @return ipAddress
     */
    public String getIpAddress() {
    	return ipAddress;
    }
    /**
     * 设置服务器IP
     * @param ipAddress
     */
    public void setIpAddress(String ipAddress) {
    	this.ipAddress = ipAddress;
    }
    /**
     * 获得不间断供电
     * <br/>
     * 字典语句(1,是;0,否)
     * @return electrification
     */
    public String getElectrification() {
    	return electrification;
    }
    /**
     * 获得不间断供电名称
     * @return electrificationName
     */
    public String getElectrificationName() {
    	return StringUtil.getDictName(electrification,electrificationDictStatement);
    }
    /**
     * 设置不间断供电
     * <br/>
     * 字典语句(1,是;0,否)
     * @param electrification
     */
    public void setElectrification(String electrification) {
    	this.electrification = electrification;
    }
    /**
     * 获得准备服务器
     * <br/>
     * 字典语句(1,是;0,否)
     * @return servers
     */
    public String getServers() {
    	return servers;
    }
    /**
     * 获得准备服务器名称
     * @return serversName
     */
    public String getServersName() {
    	return StringUtil.getDictName(servers,serversDictStatement);
    }
    /**
     * 设置准备服务器
     * <br/>
     * 字典语句(1,是;0,否)
     * @param servers
     */
    public void setServers(String servers) {
    	this.servers = servers;
    }
    /**
     * 获得开通服务器相应端口
     * @return serversPort
     */
    public String getServersPort() {
    	return serversPort;
    }
    /**
     * 设置开通服务器相应端口
     * @param serversPort
     */
    public void setServersPort(String serversPort) {
    	this.serversPort = serversPort;
    }
    /**
     * 获得开通远程桌面
     * <br/>
     * 字典语句(1,是;0,否)
     * @return remote
     */
    public String getRemote() {
    	return remote;
    }
    /**
     * 获得开通远程桌面名称
     * @return remoteName
     */
    public String getRemoteName() {
    	return StringUtil.getDictName(remote,remoteDictStatement);
    }
    /**
     * 设置开通远程桌面
     * <br/>
     * 字典语句(1,是;0,否)
     * @param remote
     */
    public void setRemote(String remote) {
    	this.remote = remote;
    }
    /**
     * 获得服务器维护方
     * @return accendant
     */
    public String getAccendant() {
    	return accendant;
    }
    /**
     * 设置服务器维护方
     * @param accendant
     */
    public void setAccendant(String accendant) {
    	this.accendant = accendant;
    }
    /**
     * 获得当地负责人员及联系方式
     * @return localPrincipalInfo
     */
    public String getLocalPrincipalInfo() {
    	return localPrincipalInfo;
    }
    /**
     * 设置当地负责人员及联系方式
     * @param localPrincipalInfo
     */
    public void setLocalPrincipalInfo(String localPrincipalInfo) {
    	this.localPrincipalInfo = localPrincipalInfo;
    }
    /**
     * 获得当地配合人员及联系方式
     * @return localCooperateInfo
     */
    public String getLocalCooperateInfo() {
    	return localCooperateInfo;
    }
    /**
     * 设置当地配合人员及联系方式
     * @param localCooperateInfo
     */
    public void setLocalCooperateInfo(String localCooperateInfo) {
    	this.localCooperateInfo = localCooperateInfo;
    }
    /**
     * 获得召开建站筹备会议
     * @return preliminaryMeeting
     */
    public String getPreliminaryMeeting() {
    	return preliminaryMeeting;
    }
    /**
     * 设置召开建站筹备会议
     * @param preliminaryMeeting
     */
    public void setPreliminaryMeeting(String preliminaryMeeting) {
    	this.preliminaryMeeting = preliminaryMeeting;
    }
    /**
     * 获得车辆司机
     * @return driver
     */
    public String getDriver() {
    	return driver;
    }
    /**
     * 设置车辆司机
     * @param driver
     */
    public void setDriver(String driver) {
    	this.driver = driver;
    }
    /**
     * 获得施工队伍及联系方式
     * @return constructionTeam
     */
    public String getConstructionTeam() {
    	return constructionTeam;
    }
    /**
     * 设置施工队伍及联系方式
     * @param constructionTeam
     */
    public void setConstructionTeam(String constructionTeam) {
    	this.constructionTeam = constructionTeam;
    }
    /**
     * 获得建站仪器
     * @return instrument
     */
    public String getInstrument() {
    	return instrument;
    }
    /**
     * 设置建站仪器
     * @param instrument
     */
    public void setInstrument(String instrument) {
    	this.instrument = instrument;
    }
    /**
     * 获得测试设备
     * @return testingDev
     */
    public String getTestingDev() {
    	return testingDev;
    }
    /**
     * 设置测试设备
     * @param testingDev
     */
    public void setTestingDev(String testingDev) {
    	this.testingDev = testingDev;
    }
    /**
     * 获得主机注册
     * @return mainFrameRegister
     */
    public String getMainFrameRegister() {
    	return mainFrameRegister;
    }
    /**
     * 设置主机注册
     * @param mainFrameRegister
     */
    public void setMainFrameRegister(String mainFrameRegister) {
    	this.mainFrameRegister = mainFrameRegister;
    }
    /**
     * 获得NRS软件狗
     * @return nrs
     */
    public String getNrs() {
    	return nrs;
    }
    /**
     * 设置NRS软件狗
     * @param nrs
     */
    public void setNrs(String nrs) {
    	this.nrs = nrs;
    }
    /**
     * 获得实施人员
     * @return implementation
     */
    public String getImplementation() {
    	return implementation;
    }
    /**
     * 设置实施人员
     * @param implementation
     */
    public void setImplementation(String implementation) {
    	this.implementation = implementation;
    }
    /**
     * 获得车次或航班号
     * @return trainOrFlight
     */
    public String getTrainOrFlight() {
    	return trainOrFlight;
    }
    /**
     * 设置车次或航班号
     * @param trainOrFlight
     */
    public void setTrainOrFlight(String trainOrFlight) {
    	this.trainOrFlight = trainOrFlight;
    }
    /**
     * 获得酒店
     * @return grogshop
     */
    public String getGrogshop() {
    	return grogshop;
    }
    /**
     * 设置酒店
     * @param grogshop
     */
    public void setGrogshop(String grogshop) {
    	this.grogshop = grogshop;
    }
    public String getIsDelete() {
    	return isDelete;
    }
    public void setIsDelete(String isDelete) {
    	this.isDelete = isDelete;
    }
} 		