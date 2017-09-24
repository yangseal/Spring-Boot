package com.cnten.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.cnten.platform.util.StringUtil;

/**
 * 基站建设 实体类
 * @author Administrator
 */
@Entity
public class BaseConstruct {
	@Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
	private String baseConstructId;
	@ManyToOne
	@JoinColumn(name="base_project_id")
	private BaseProject baseProject;
	@Column(length=255)
	private String stationName;
	@Column(length=32)
	private String stationNo;
	@Column(length=60)
	private String stationShortName;
	@Column(length=32)
	private String stationMapNo;
	@OneToOne
	@JoinColumn(name="base_customer_id")
	private BaseCustomer baseCustomer;
	@Column(length=255)
	private String oweCompany;
	@OneToOne
	@JoinColumn(name="oam_area_Id")
	private OamArea oamArea;
	@Column(length=255)
	private String mainStationAddress;
	@Column(length=255)
	private String otherStationAddress;
	@Column(length=45)
	private String mainLinkUser;
	@Column(length=14)
	private String mainUserPhone;
	@Column(length=45)
	private String otherLinkUser;
	@Column(length=15)
	private String otherUserPhone;
	@Column(length=120)
	private String serverPositoin;
	@Column(length=15)
	private String serverFixIp;
	@Column(length=8)
	private String netServerPort;
	@Column(length=1024)
	private String constructRemark;
	@Transient
	private String sendDownStateName;
	@Column(length=12)
	private String sendDownState;
	public static final String sendDownStateDictStatement = "unsenddown,未下发;senddowned,已下发";
	@Transient
	private String constructStageName;
	@Column(length=12)
	private String constructStage;
	public static final String constructStageDictStatement = "JSZ,建设中;TJYS,已提交验收申请;YYS,已验收;YBA,已备案;YBH,已驳回";
	@Column(length=45)
	private String recordNo;
	@Transient
	private String checkStateName;
	@Column(length=8)
	private String checkState;
	public static final String checkStateDictStatement = "WYS,未验收;YYS,已验收;YBH,已驳回;TJYS,已提交验收申请;";
	@Transient
	private String recordStateName;
	@Column(length=8)
	private String recordState;
	public static final String recordStateDictStatement = "WBA,未备案;YBA,已备案";
	@Column(length=255)
	private String checkOpinion;
	@Column(length=1)
	private String isDelete;
	@Column(length=255)
	private String ownIndustry;
	private Date createTime = new Date();;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;
	@Column
	private String createUser;
	@Column
	private String updateUser;
	public String getBaseConstructId() {
		return baseConstructId;
	}
	public void setBaseConstructId(String baseConstructId) {
		this.baseConstructId = baseConstructId;
	}
	public BaseProject getBaseProject() {
		return baseProject;
	}
	public void setBaseProject(BaseProject baseProject) {
		this.baseProject = baseProject;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getStationNo() {
		return stationNo;
	}
	public void setStationNo(String stationNo) {
		this.stationNo = stationNo;
	}
	public String getStationShortName() {
		return stationShortName;
	}
	public void setStationShortName(String stationShortName) {
		this.stationShortName = stationShortName;
	}
	public String getStationMapNo() {
		return stationMapNo;
	}
	public void setStationMapNo(String stationMapNo) {
		this.stationMapNo = stationMapNo;
	}
	public BaseCustomer getBaseCustomer() {
		return baseCustomer;
	}
	public void setBaseCustomer(BaseCustomer baseCustomer) {
		this.baseCustomer = baseCustomer;
	}
	public OamArea getOamArea() {
		return oamArea;
	}
	public void setOamArea(OamArea oamArea) {
		this.oamArea = oamArea;
	}
	public String getMainStationAddress() {
		return mainStationAddress;
	}
	public void setMainStationAddress(String mainStationAddress) {
		this.mainStationAddress = mainStationAddress;
	}
	public String getOtherStationAddress() {
		return otherStationAddress;
	}
	public void setOtherStationAddress(String otherStationAddress) {
		this.otherStationAddress = otherStationAddress;
	}
	public String getMainLinkUser() {
		return mainLinkUser;
	}
	public void setMainLinkUser(String mainLinkUser) {
		this.mainLinkUser = mainLinkUser;
	}
	public String getMainUserPhone() {
		return mainUserPhone;
	}
	public void setMainUserPhone(String mainUserPhone) {
		this.mainUserPhone = mainUserPhone;
	}
	public String getOtherLinkUser() {
		return otherLinkUser;
	}
	public void setOtherLinkUser(String otherLinkUser) {
		this.otherLinkUser = otherLinkUser;
	}
	public String getOtherUserPhone() {
		return otherUserPhone;
	}
	public void setOtherUserPhone(String otherUserPhone) {
		this.otherUserPhone = otherUserPhone;
	}
	public String getServerPositoin() {
		return serverPositoin;
	}
	public void setServerPositoin(String serverPositoin) {
		this.serverPositoin = serverPositoin;
	}
	public String getServerFixIp() {
		return serverFixIp;
	}
	public void setServerFixIp(String serverFixIp) {
		this.serverFixIp = serverFixIp;
	}
	public String getNetServerPort() {
		return netServerPort;
	}
	public void setNetServerPort(String netServerPort) {
		this.netServerPort = netServerPort;
	}
	public String getConstructRemark() {
		return constructRemark;
	}
	public void setConstructRemark(String constructRemark) {
		this.constructRemark = constructRemark;
	}
	public String getSendDownStateName() {
		return StringUtil.getDictName(sendDownState, sendDownStateDictStatement) ;
	}
	public String getSendDownState() {
		return sendDownState;
	}
	public void setSendDownState(String sendDownState) {
		this.sendDownState = sendDownState;
	}
	public String getConstructStageName() {
		return StringUtil.getDictName(constructStage, constructStageDictStatement) ;
	}
	public String getConstructStage() {
		return constructStage;
	}
	public void setConstructStage(String constructStage) {
		this.constructStage = constructStage;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public String getOweCompany() {
		return oweCompany;
	}
	public void setOweCompany(String oweCompany) {
		this.oweCompany = oweCompany;
	}
	public String getRecordNo() {
		return recordNo;
	}
	public void setRecordNo(String recordNo) {
		this.recordNo = recordNo;
	}
	public String getCheckStateName() {
		return StringUtil.getDictName(checkState, checkStateDictStatement) ;
	}
	public String getCheckState() {
		return checkState;
	}
	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}
	public String getRecordStateName() {
		return StringUtil.getDictName(recordState, recordStateDictStatement) ;
	}
	public String getRecordState() {
		return recordState;
	}
	public void setRecordState(String recordState) {
		this.recordState = recordState;
	}
	public String getCheckOpinion() {
		return checkOpinion;
	}
	public void setCheckOpinion(String checkOpinion) {
		this.checkOpinion = checkOpinion;
	}
	
	public String getOwnIndustry() {
		return ownIndustry;
	}
	public void setOwnIndustry(String ownIndustry) {
		this.ownIndustry = ownIndustry;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	
}
