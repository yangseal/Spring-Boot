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
public class OamBaseStation {

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String oamBaseStationId;
    @ManyToOne
    @JoinColumn(name="oam_area_id")
    private OamArea oamArea;
    @ManyToOne
    @JoinColumn(name="oam_project_id")
    private OamProject oamProject;
    @Column(length = 100)
    private String oamBaseStationName;
    @Column(length = 50)
    private String shortName;
    @Column(length = 100)
    private String oamBaseStationCode;
    @Column(length = 100)
    private String nfCode;
    @Column(length = 1)
    private String buildStage;
    public static final String buildStageDictStatement = "1,已完成;0,建设中";
    @Column(length = 1)
    private String isEffectivity;
    public static final String isEffectivityDictStatement = "1,是;0,否";
    private Double longitude;
    private Double latitude;
    @Column(length = 1)
    private String state;
    public static final String stateDictStatement = "1,是;0,否";
    @Column(length = 1)
    private String isDelete;
    public OamBaseStation(){}
    public OamBaseStation(String oamBaseStaionId) {
    	this.oamBaseStationId = oamBaseStaionId;
    }
    
    public String getOamBaseStationId() {
    	return oamBaseStationId;
    }
    public void setOamBaseStationId(String oamBaseStationId) {
    	this.oamBaseStationId = oamBaseStationId;
    }
    /**
     * 获得所属地区
     * @return oamArea
     */
    public OamArea getOamArea() {
    	return oamArea;
    }
    /**
     * 设置所属地区
     * @param oamArea
     */
    public void setOamArea(OamArea oamArea) {
    	this.oamArea = oamArea;
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
     * 获得基站名称
     * @return oamBaseStationName
     */
    public String getOamBaseStationName() {
    	return oamBaseStationName;
    }
    /**
     * 设置基站名称
     * @param oamBaseStationName
     */
    public void setOamBaseStationName(String oamBaseStationName) {
    	this.oamBaseStationName = oamBaseStationName;
    }
    /**
     * 获得基站简称
     * @return shortName
     */
    public String getShortName() {
    	return shortName;
    }
    /**
     * 设置基站简称
     * @param shortName
     */
    public void setShortName(String shortName) {
    	this.shortName = shortName;
    }
    /**
     * 获得基站编号
     * @return oamBaseStationCode
     */
    public String getOamBaseStationCode() {
    	return oamBaseStationCode;
    }
    /**
     * 设置基站编号
     * @param oamBaseStationCode
     */
    public void setOamBaseStationCode(String oamBaseStationCode) {
    	this.oamBaseStationCode = oamBaseStationCode;
    }
    /**
     * 获得南方测绘编号
     * @return nfCode
     */
    public String getNfCode() {
    	return nfCode;
    }
    /**
     * 设置南方测绘编号
     * @param nfCode
     */
    public void setNfCode(String nfCode) {
    	this.nfCode = nfCode;
    }
    /**
     * 获得建设阶段
     * <br/>
     * 字典语句(1,已完成;0,建设中)
     * @return buildStage
     */
    public String getBuildStage() {
    	return buildStage;
    }
    /**
     * 获得建设阶段名称
     * @return buildStageName
     */
    public String getBuildStageName() {
    	return StringUtil.getDictName(buildStage,buildStageDictStatement);
    }
    /**
     * 设置建设阶段
     * <br/>
     * 字典语句(1,已完成;0,建设中)
     * @param buildStage
     */
    public void setBuildStage(String buildStage) {
    	this.buildStage = buildStage;
    }
    /**
     * 获得是否有效
     * <br/>
     * 字典语句(1,是;0,否)
     * @return isEffectivity
     */
    public String getIsEffectivity() {
    	return isEffectivity;
    }
    /**
     * 获得是否有效名称
     * @return isEffectivityName
     */
    public String getIsEffectivityName() {
    	return StringUtil.getDictName(isEffectivity,isEffectivityDictStatement);
    }
    /**
     * 设置是否有效
     * <br/>
     * 字典语句(1,是;0,否)
     * @param isEffectivity
     */
    public void setIsEffectivity(String isEffectivity) {
    	this.isEffectivity = isEffectivity;
    }
    /**
     * 获得经度
     * @return longitude
     */
    public Double getLongitude() {
    	return longitude;
    }
    /**
     * 设置经度
     * @param longitude
     */
    public void setLongitude(Double longitude) {
    	this.longitude = longitude;
    }
    /**
     * 获得纬度
     * @return latitude
     */
    public Double getLatitude() {
    	return latitude;
    }
    /**
     * 设置纬度
     * @param latitude
     */
    public void setLatitude(Double latitude) {
    	this.latitude = latitude;
    }
    /**
     * 获得状态
     * <br/>
     * 字典语句(1,是;0,否)
     * @return state
     */
    public String getState() {
    	return state;
    }
    /**
     * 获得状态名称
     * @return stateName
     */
    public String getStateName() {
    	return StringUtil.getDictName(state,stateDictStatement);
    }
    /**
     * 设置状态
     * <br/>
     * 字典语句(1,是;0,否)
     * @param state
     */
    public void setState(String state) {
    	this.state = state;
    }
    public String getIsDelete() {
    	return isDelete;
    }
    public void setIsDelete(String isDelete) {
    	this.isDelete = isDelete;
    }
    public String getProjectCode() {
    	return null==oamProject? "":oamProject.getOamProjectCode();
    }
} 		