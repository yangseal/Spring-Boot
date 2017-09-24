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
public class OamStationAddress {

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String oamStationAddressId;
    @ManyToOne
    @JoinColumn(name="oam_project_id")
    private OamProject oamProject;
    @ManyToOne
    @JoinColumn(name="oam_base_station_id")
    private OamBaseStation oamBaseStation;
    @Column(length = 200)
    private String address;
    @Column(length = 100)
    private String contacts;
    @Column(length = 100)
    private String contact;
    @Column(length = 500)
    private String shelterInfo;
    @Column(length = 500)
    private String interferenceInfo;
    @Column(length = 1)
    private String electrification220;
    public static final String electrification220DictStatement = "1,是;0,否";
    @Column(length = 1)
    private String electrification;
    public static final String electrificationDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String wAN;
    public static final String wANDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String out2M;
    public static final String out2MDictStatement = "1,是;0,否";
    @Column(length = 200)
    private String ipInfo;
    @Column(length = 1)
    private String aDSL;
    public static final String aDSLDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String opticalFiber;
    public static final String opticalFiberDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String interchanger;
    public static final String interchangerDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String router;
    public static final String routerDictStatement = "1,是;0,否";
    @Column(length = 200)
    private String otherNetwork;
    @Column(length = 1)
    private String lightningShielding;
    public static final String lightningShieldingDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String lightningArrester;
    public static final String lightningArresterDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String lightningNetWork;
    public static final String lightningNetWorkDictStatement = "1,是;0,否";
    @Column(length = 200)
    private String otherArrester;
    @Column(length = 1)
    private String smoothRoof;
    public static final String smoothRoofDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String nickelcladRoof;
    public static final String nickelcladRoofDictStatement = "1,是;0,否";
    @Column(length = 200)
    private String otherRoof;
    @Column(length = 1)
    private String usedWaterproofer;
    public static final String usedWaterprooferDictStatement = "1,是;0,否";
    @Column(length = 200)
    private String waterprooferInfo;
    @Column(length = 1)
    private String usedPapers;
    public static final String usedPapersDictStatement = "1,是;0,否";
    @Column(length = 200)
    private String papersInfo;
    @Column(length = 500)
    private String remark;
    @Column(length = 1)
    private String isDelete;
    
    public String getOamStationAddressId() {
    	return oamStationAddressId;
    }
    public void setOamStationAddressId(String oamStationAddressId) {
    	this.oamStationAddressId = oamStationAddressId;
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
     * 获得地址
     * @return address
     */
    public String getAddress() {
    	return address;
    }
    /**
     * 设置地址
     * @param address
     */
    public void setAddress(String address) {
    	this.address = address;
    }
    /**
     * 获得联系人
     * @return contacts
     */
    public String getContacts() {
    	return contacts;
    }
    /**
     * 设置联系人
     * @param contacts
     */
    public void setContacts(String contacts) {
    	this.contacts = contacts;
    }
    /**
     * 获得联系方式
     * @return contact
     */
    public String getContact() {
    	return contact;
    }
    /**
     * 设置联系方式
     * @param contact
     */
    public void setContact(String contact) {
    	this.contact = contact;
    }
    /**
     * 获得遮挡物及程度
     * @return shelterInfo
     */
    public String getShelterInfo() {
    	return shelterInfo;
    }
    /**
     * 设置遮挡物及程度
     * @param shelterInfo
     */
    public void setShelterInfo(String shelterInfo) {
    	this.shelterInfo = shelterInfo;
    }
    /**
     * 获得干扰源及程度
     * @return interferenceInfo
     */
    public String getInterferenceInfo() {
    	return interferenceInfo;
    }
    /**
     * 设置干扰源及程度
     * @param interferenceInfo
     */
    public void setInterferenceInfo(String interferenceInfo) {
    	this.interferenceInfo = interferenceInfo;
    }
    /**
     * 获得不间断供电220V
     * <br/>
     * 字典语句(1,是;0,否)
     * @return electrification220
     */
    public String getElectrification220() {
    	return electrification220;
    }
    /**
     * 获得不间断供电220V名称
     * @return electrification220Name
     */
    public String getElectrification220Name() {
    	return StringUtil.getDictName(electrification220,electrification220DictStatement);
    }
    /**
     * 设置不间断供电220V
     * <br/>
     * 字典语句(1,是;0,否)
     * @param electrification220
     */
    public void setElectrification220(String electrification220) {
    	this.electrification220 = electrification220;
    }
    /**
     * 获得不间断网络
     * <br/>
     * 字典语句(1,是;0,否)
     * @return electrification
     */
    public String getElectrification() {
    	return electrification;
    }
    /**
     * 获得不间断网络名称
     * @return electrificationName
     */
    public String getElectrificationName() {
    	return StringUtil.getDictName(electrification,electrificationDictStatement);
    }
    /**
     * 设置不间断网络
     * <br/>
     * 字典语句(1,是;0,否)
     * @param electrification
     */
    public void setElectrification(String electrification) {
    	this.electrification = electrification;
    }
    /**
     * 获得外网
     * <br/>
     * 字典语句(1,是;0,否)
     * @return wAN
     */
    public String getWAN() {
    	return wAN;
    }
    /**
     * 获得外网名称
     * @return wANName
     */
    public String getWANName() {
    	return StringUtil.getDictName(wAN,wANDictStatement);
    }
    /**
     * 设置外网
     * <br/>
     * 字典语句(1,是;0,否)
     * @param wAN
     */
    public void setWAN(String wAN) {
    	this.wAN = wAN;
    }
    /**
     * 获得独占带宽大于2M
     * <br/>
     * 字典语句(1,是;0,否)
     * @return out2M
     */
    public String getOut2M() {
    	return out2M;
    }
    /**
     * 获得独占带宽大于2M名称
     * @return out2MName
     */
    public String getOut2MName() {
    	return StringUtil.getDictName(out2M,out2MDictStatement);
    }
    /**
     * 设置独占带宽大于2M
     * <br/>
     * 字典语句(1,是;0,否)
     * @param out2M
     */
    public void setOut2M(String out2M) {
    	this.out2M = out2M;
    }
    /**
     * 获得固定IP情况及说明
     * @return ipInfo
     */
    public String getIpInfo() {
    	return ipInfo;
    }
    /**
     * 设置固定IP情况及说明
     * @param ipInfo
     */
    public void setIpInfo(String ipInfo) {
    	this.ipInfo = ipInfo;
    }
    /**
     * 获得ADSL
     * <br/>
     * 字典语句(1,是;0,否)
     * @return aDSL
     */
    public String getADSL() {
    	return aDSL;
    }
    /**
     * 获得ADSL名称
     * @return aDSLName
     */
    public String getADSLName() {
    	return StringUtil.getDictName(aDSL,aDSLDictStatement);
    }
    /**
     * 设置ADSL
     * <br/>
     * 字典语句(1,是;0,否)
     * @param aDSL
     */
    public void setADSL(String aDSL) {
    	this.aDSL = aDSL;
    }
    /**
     * 获得光纤
     * <br/>
     * 字典语句(1,是;0,否)
     * @return opticalFiber
     */
    public String getOpticalFiber() {
    	return opticalFiber;
    }
    /**
     * 获得光纤名称
     * @return opticalFiberName
     */
    public String getOpticalFiberName() {
    	return StringUtil.getDictName(opticalFiber,opticalFiberDictStatement);
    }
    /**
     * 设置光纤
     * <br/>
     * 字典语句(1,是;0,否)
     * @param opticalFiber
     */
    public void setOpticalFiber(String opticalFiber) {
    	this.opticalFiber = opticalFiber;
    }
    /**
     * 获得交换机
     * <br/>
     * 字典语句(1,是;0,否)
     * @return interchanger
     */
    public String getInterchanger() {
    	return interchanger;
    }
    /**
     * 获得交换机名称
     * @return interchangerName
     */
    public String getInterchangerName() {
    	return StringUtil.getDictName(interchanger,interchangerDictStatement);
    }
    /**
     * 设置交换机
     * <br/>
     * 字典语句(1,是;0,否)
     * @param interchanger
     */
    public void setInterchanger(String interchanger) {
    	this.interchanger = interchanger;
    }
    /**
     * 获得路由器
     * <br/>
     * 字典语句(1,是;0,否)
     * @return router
     */
    public String getRouter() {
    	return router;
    }
    /**
     * 获得路由器名称
     * @return routerName
     */
    public String getRouterName() {
    	return StringUtil.getDictName(router,routerDictStatement);
    }
    /**
     * 设置路由器
     * <br/>
     * 字典语句(1,是;0,否)
     * @param router
     */
    public void setRouter(String router) {
    	this.router = router;
    }
    /**
     * 获得其它网络类别
     * @return otherNetwork
     */
    public String getOtherNetwork() {
    	return otherNetwork;
    }
    /**
     * 设置其它网络类别
     * @param otherNetwork
     */
    public void setOtherNetwork(String otherNetwork) {
    	this.otherNetwork = otherNetwork;
    }
    /**
     * 获得公共避雷
     * <br/>
     * 字典语句(1,是;0,否)
     * @return lightningShielding
     */
    public String getLightningShielding() {
    	return lightningShielding;
    }
    /**
     * 获得公共避雷名称
     * @return lightningShieldingName
     */
    public String getLightningShieldingName() {
    	return StringUtil.getDictName(lightningShielding,lightningShieldingDictStatement);
    }
    /**
     * 设置公共避雷
     * <br/>
     * 字典语句(1,是;0,否)
     * @param lightningShielding
     */
    public void setLightningShielding(String lightningShielding) {
    	this.lightningShielding = lightningShielding;
    }
    /**
     * 获得避雷针
     * <br/>
     * 字典语句(1,是;0,否)
     * @return lightningArrester
     */
    public String getLightningArrester() {
    	return lightningArrester;
    }
    /**
     * 获得避雷针名称
     * @return lightningArresterName
     */
    public String getLightningArresterName() {
    	return StringUtil.getDictName(lightningArrester,lightningArresterDictStatement);
    }
    /**
     * 设置避雷针
     * <br/>
     * 字典语句(1,是;0,否)
     * @param lightningArrester
     */
    public void setLightningArrester(String lightningArrester) {
    	this.lightningArrester = lightningArrester;
    }
    /**
     * 获得避雷网
     * <br/>
     * 字典语句(1,是;0,否)
     * @return lightningNetWork
     */
    public String getLightningNetWork() {
    	return lightningNetWork;
    }
    /**
     * 获得避雷网名称
     * @return lightningNetWorkName
     */
    public String getLightningNetWorkName() {
    	return StringUtil.getDictName(lightningNetWork,lightningNetWorkDictStatement);
    }
    /**
     * 设置避雷网
     * <br/>
     * 字典语句(1,是;0,否)
     * @param lightningNetWork
     */
    public void setLightningNetWork(String lightningNetWork) {
    	this.lightningNetWork = lightningNetWork;
    }
    /**
     * 获得其它避雷设施
     * @return otherArrester
     */
    public String getOtherArrester() {
    	return otherArrester;
    }
    /**
     * 设置其它避雷设施
     * @param otherArrester
     */
    public void setOtherArrester(String otherArrester) {
    	this.otherArrester = otherArrester;
    }
    /**
     * 获得平整天台
     * <br/>
     * 字典语句(1,是;0,否)
     * @return smoothRoof
     */
    public String getSmoothRoof() {
    	return smoothRoof;
    }
    /**
     * 获得平整天台名称
     * @return smoothRoofName
     */
    public String getSmoothRoofName() {
    	return StringUtil.getDictName(smoothRoof,smoothRoofDictStatement);
    }
    /**
     * 设置平整天台
     * <br/>
     * 字典语句(1,是;0,否)
     * @param smoothRoof
     */
    public void setSmoothRoof(String smoothRoof) {
    	this.smoothRoof = smoothRoof;
    }
    /**
     * 获得斜面钢板屋顶
     * <br/>
     * 字典语句(1,是;0,否)
     * @return nickelcladRoof
     */
    public String getNickelcladRoof() {
    	return nickelcladRoof;
    }
    /**
     * 获得斜面钢板屋顶名称
     * @return nickelcladRoofName
     */
    public String getNickelcladRoofName() {
    	return StringUtil.getDictName(nickelcladRoof,nickelcladRoofDictStatement);
    }
    /**
     * 设置斜面钢板屋顶
     * <br/>
     * 字典语句(1,是;0,否)
     * @param nickelcladRoof
     */
    public void setNickelcladRoof(String nickelcladRoof) {
    	this.nickelcladRoof = nickelcladRoof;
    }
    /**
     * 获得其它天台情况
     * @return otherRoof
     */
    public String getOtherRoof() {
    	return otherRoof;
    }
    /**
     * 设置其它天台情况
     * @param otherRoof
     */
    public void setOtherRoof(String otherRoof) {
    	this.otherRoof = otherRoof;
    }
    /**
     * 获得是否有防水层
     * <br/>
     * 字典语句(1,是;0,否)
     * @return usedWaterproofer
     */
    public String getUsedWaterproofer() {
    	return usedWaterproofer;
    }
    /**
     * 获得是否有防水层名称
     * @return usedWaterprooferName
     */
    public String getUsedWaterprooferName() {
    	return StringUtil.getDictName(usedWaterproofer,usedWaterprooferDictStatement);
    }
    /**
     * 设置是否有防水层
     * <br/>
     * 字典语句(1,是;0,否)
     * @param usedWaterproofer
     */
    public void setUsedWaterproofer(String usedWaterproofer) {
    	this.usedWaterproofer = usedWaterproofer;
    }
    /**
     * 获得防水层描述
     * @return waterprooferInfo
     */
    public String getWaterprooferInfo() {
    	return waterprooferInfo;
    }
    /**
     * 设置防水层描述
     * @param waterprooferInfo
     */
    public void setWaterprooferInfo(String waterprooferInfo) {
    	this.waterprooferInfo = waterprooferInfo;
    }
    /**
     * 获得是否需要特殊证件
     * <br/>
     * 字典语句(1,是;0,否)
     * @return usedPapers
     */
    public String getUsedPapers() {
    	return usedPapers;
    }
    /**
     * 获得是否需要特殊证件名称
     * @return usedPapersName
     */
    public String getUsedPapersName() {
    	return StringUtil.getDictName(usedPapers,usedPapersDictStatement);
    }
    /**
     * 设置是否需要特殊证件
     * <br/>
     * 字典语句(1,是;0,否)
     * @param usedPapers
     */
    public void setUsedPapers(String usedPapers) {
    	this.usedPapers = usedPapers;
    }
    /**
     * 获得特殊证件描述
     * <br/>
     * 字典语句(1,是;0,否)
     * @return papersInfo
     */
    public String getPapersInfo() {
    	return papersInfo;
    }
    
    /**
     * 设置特殊证件描述
     * <br/>
     * 字典语句(1,是;0,否)
     * @param papersInfo
     */
    public void setPapersInfo(String papersInfo) {
    	this.papersInfo = papersInfo;
    }
    /**
     * 获得备注
     * @return remark
     */
    public String getRemark() {
    	return remark;
    }
    /**
     * 设置备注
     * @param remark
     */
    public void setRemark(String remark) {
    	this.remark = remark;
    }
    public String getIsDelete() {
    	return isDelete;
    }
    public void setIsDelete(String isDelete) {
    	this.isDelete = isDelete;
    }
} 		