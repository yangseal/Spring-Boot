package com.cnten.bdlocation.baseStation.construction.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.bdlocation.constants.BaseStationConsts;
import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.mail.Mail;
import com.cnten.platform.mail.MailSender;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.util.StringUtil;
import com.cnten.po.BaseAddress;
import com.cnten.po.BaseCheckMatetial;
import com.cnten.po.BaseConstruct;
import com.cnten.po.BaseLinkPoint;
import com.cnten.po.BaseMaterial;
import com.cnten.po.BaseStationTest;

@Service
public class BaseConstructService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	public Page getConstructByPage(BaseConstruct baseConstruct, Integer pageIndex, Integer pageSize){
		String hql = " from BaseConstruct a where 1=1";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(baseConstruct.getSendDownState()!= null && StringUtils.isNotBlank(baseConstruct.getSendDownState())){
			hql += " and a.sendDownState = :sendDownState";
			params.put("sendDownState", baseConstruct.getSendDownState());
		}
		if(baseConstruct.getBaseCustomer() != null && StringUtils.isNotBlank(baseConstruct.getBaseCustomer().getCustomerName())){
			hql += " and a.baseCustomer.customerName like :customerName";
			params.put("customerName", "%" +baseConstruct.getBaseCustomer().getCustomerName()+"%");
		}
		if(StringUtils.isNotBlank(baseConstruct.getStationName())){
			hql += " and a.stationName like :stationName";
			params.put("stationName", "%" + baseConstruct.getStationName() + "%");
		}
		if(StringUtils.isNotBlank(baseConstruct.getStationNo())){
			hql += " and a.stationNo like :stationNo";
			params.put("stationNo", "%" + baseConstruct.getStationNo() + "%");
		}
		if(baseConstruct.getBaseProject() != null && StringUtils.isNotBlank(baseConstruct.getBaseProject().getBaseProjectId())){
			hql += " and a.baseProject.baseProjectId = :baseProjectId";
			params.put("baseProjectId", baseConstruct.getBaseProject().getBaseProjectId());
		}
		if(baseConstruct.getConstructStage() != null && StringUtils.isNotBlank(baseConstruct.getConstructStage())){
			hql += " and a.constructStage = :constructStage";
			params.put("constructStage", baseConstruct.getConstructStage());
		}
		hql += " order by createTime desc";
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}
	
	public BaseConstruct getConstruct(String baseConstructId){
		return commonDAO.get(BaseConstruct.class, baseConstructId);
	}
	
	public void saveConstruct(BaseConstruct baseConstruct){
		String baseConstructId = baseConstruct.getBaseConstructId();
		
		if(StringUtil.isEmpty(baseConstructId)){
			baseConstruct.setSendDownState(BaseStationConsts.BASE_STATION_TASK_UNSENDDOWN);
			baseConstruct.setConstructStage(BaseStationConsts.BASE_STATION_BUILD_STAGE_1);
			baseConstruct.setCheckState(BaseStationConsts.BASE_STATION_CHECK_STATE_0);
			baseConstruct.setRecordState(BaseStationConsts.BASE_STATION_RECORD_STATE_0);
			baseConstruct.setCreateUser(ContextUtil.getCurrentUser().getUserId());
			commonDAO.save(baseConstruct);
		} else {
			BaseConstruct oldBaseConstruct = commonDAO.get(BaseConstruct.class, baseConstructId);
			if(baseConstruct.getBaseProject() != null) oldBaseConstruct.setBaseProject(baseConstruct.getBaseProject());
			if(StringUtils.isNotBlank(baseConstruct.getStationName())) oldBaseConstruct.setStationName(baseConstruct.getStationName());
			if(StringUtils.isNotBlank(baseConstruct.getStationShortName())) oldBaseConstruct.setStationShortName(baseConstruct.getStationShortName());
			if(StringUtils.isNotBlank(baseConstruct.getStationNo())) oldBaseConstruct.setStationNo(baseConstruct.getStationNo());
			if(StringUtils.isNotBlank(baseConstruct.getStationMapNo())) oldBaseConstruct.setStationMapNo(baseConstruct.getStationMapNo());
			if(baseConstruct.getBaseCustomer() != null) oldBaseConstruct.setBaseCustomer(baseConstruct.getBaseCustomer());
			if(baseConstruct.getOamArea() != null) oldBaseConstruct.setOamArea(baseConstruct.getOamArea());
			if(StringUtils.isNotBlank(baseConstruct.getOweCompany())) oldBaseConstruct.setOweCompany(baseConstruct.getOweCompany());
			if(StringUtils.isNotBlank(baseConstruct.getMainStationAddress())) oldBaseConstruct.setMainStationAddress(baseConstruct.getMainStationAddress());
			if(StringUtils.isNotBlank(baseConstruct.getMainLinkUser())) oldBaseConstruct.setMainLinkUser(baseConstruct.getMainLinkUser());
			if(StringUtils.isNotBlank(baseConstruct.getMainUserPhone())) oldBaseConstruct.setMainUserPhone(baseConstruct.getMainUserPhone());
			if(StringUtils.isNotBlank(baseConstruct.getOtherStationAddress())) oldBaseConstruct.setOtherStationAddress(baseConstruct.getOtherStationAddress());
			if(StringUtils.isNotBlank(baseConstruct.getOtherLinkUser())) oldBaseConstruct.setOtherLinkUser(baseConstruct.getOtherLinkUser());
			if(StringUtils.isNotBlank(baseConstruct.getOtherUserPhone())) oldBaseConstruct.setOtherUserPhone(baseConstruct.getOtherUserPhone());
			if(StringUtils.isNotBlank(baseConstruct.getServerPositoin())) oldBaseConstruct.setServerPositoin(baseConstruct.getServerPositoin());
			if(StringUtils.isNotBlank(baseConstruct.getServerFixIp())) oldBaseConstruct.setServerFixIp(baseConstruct.getServerFixIp());
			if(StringUtils.isNotBlank(baseConstruct.getNetServerPort())) oldBaseConstruct.setNetServerPort(baseConstruct.getNetServerPort());
			if(StringUtils.isNotBlank(baseConstruct.getConstructRemark())) oldBaseConstruct.setConstructRemark(baseConstruct.getConstructRemark());
			if(StringUtils.isNotBlank(baseConstruct.getOwnIndustry())) oldBaseConstruct.setOwnIndustry(baseConstruct.getOwnIndustry());
			oldBaseConstruct.setUpdateUser(ContextUtil.getCurrentUser().getUserId());
			oldBaseConstruct.setUpdateTime(new Date());
			commonDAO.update(oldBaseConstruct);
		}
	}
	
	public void updateConstructState(String ids){
		if(StringUtils.isNotBlank(ids)){
			String[] constructIds = ids.split(",");
			for (String itemId : constructIds) {
				BaseConstruct baseConstruct = commonDAO.load(BaseConstruct.class, itemId);
				baseConstruct.setSendDownState(BaseStationConsts.BASE_STATION_TASK_SENDDOWNED);
				commonDAO.update(baseConstruct);
			}
		}	
	}
	
	public BaseAddress getBaseAddress(String baseConstructId){
		String hql = "from BaseAddress a where a.baseConstruct.baseConstructId = :baseConstructId";
		HashMap<String, Object> params = new HashMap<String,Object>();
		params.put("baseConstructId", baseConstructId);
		return commonDAO.get(hql, params);
	}
	
	public void saveBaseAddress(BaseAddress baseAddress){
		String baseAddressId = baseAddress.getBaseAddressId();
		if(StringUtil.isEmpty(baseAddressId)){
			commonDAO.save(baseAddress);
		} else {
			commonDAO.update(baseAddress);
		}
	}
	
	public BaseMaterial getBaseMaterial(String baseConstructId){
		String hql = "from BaseMaterial a where a.baseConstruct.baseConstructId = :baseConstructId";
		HashMap<String, Object> params = new HashMap<String,Object>();
		params.put("baseConstructId", baseConstructId);
		return commonDAO.get(hql, params);
	}
	
	public BaseStationTest getBaseStationTest(String baseConstructId){
		String hql = " from BaseStationTest a where a.baseConstruct.baseConstructId = :baseConstructId";
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("baseConstructId", baseConstructId);
		return commonDAO.get(hql, params);
	}
	
	public BaseCheckMatetial getBaseCheckMatetial(String baseConstructId){
		String hql = " from BaseCheckMatetial a where a.baseConstruct.baseConstructId = :baseConstructId";
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("baseConstructId", baseConstructId);
		return commonDAO.get(hql, params);
	}
	
	public void saveBaseCheckMaterial(BaseCheckMatetial baseCheckMatetial){
		String baseCheckMaterialId = baseCheckMatetial.getBaseCheckMatetialId();
		if(StringUtils.isNotBlank(baseCheckMaterialId)){
			commonDAO.update(baseCheckMatetial);
		} else {
			commonDAO.save(baseCheckMatetial);
		}
	}
	
	public void saveBuildInfo(BaseMaterial baseMaterial){
		String baseMaterialId = baseMaterial.getBaseMaterialId();
		if(StringUtils.isEmpty(baseMaterialId)){
			commonDAO.save(baseMaterial);
		}else{
			commonDAO.update(baseMaterial);
		}
	}
	
	public void updateConstructStage(String baseConstructId){
		BaseConstruct baseConstruct = commonDAO.load(BaseConstruct.class, baseConstructId);
		String constructStage = baseConstruct.getConstructStage();
		if(BaseStationConsts.BASE_STATION_BUILD_STAGE_1.equals(constructStage) ||
				BaseStationConsts.BASE_STATION_BUILD_STAGE_5.equals(constructStage)){
			baseConstruct.setConstructStage(BaseStationConsts.BASE_STATION_BUILD_STAGE_2);
			baseConstruct.setCheckState(BaseStationConsts.BASE_STATION_CHECK_STATE_3);
			commonDAO.update(baseConstruct);
		}
	}
	
	public void updateConstructCheckApprove(BaseConstruct baseConstruct, String approveRlt){
		BaseConstruct oldBaseConstruct = commonDAO.load(BaseConstruct.class, baseConstruct.getBaseConstructId());
		String checkState = oldBaseConstruct.getCheckState();
		if(StringUtils.isNotBlank(checkState) && !BaseStationConsts.BASE_STATION_CHECK_STATE_1.equals(checkState)){
			oldBaseConstruct.setCheckOpinion(baseConstruct.getCheckOpinion());
			oldBaseConstruct.setCheckState(BaseStationConsts.BASE_STATION_CHECK_STATE_2);
			oldBaseConstruct.setConstructStage(BaseStationConsts.BASE_STATION_BUILD_STAGE_5);
			if(BaseStationConsts.BASE_STATION_CHECK_RLT_1.equals(approveRlt)){
				oldBaseConstruct.setCheckState(BaseStationConsts.BASE_STATION_CHECK_STATE_1);
				oldBaseConstruct.setConstructStage(BaseStationConsts.BASE_STATION_BUILD_STAGE_3);
			}
			commonDAO.update(oldBaseConstruct);
		}
		String mailContent = "您提交的验收资料 未通过 讯腾公司的审核;";
		if(StringUtils.isNotBlank(baseConstruct.getCheckOpinion())) {
			mailContent += "具体意见如下:" + baseConstruct.getCheckOpinion();
		}
		if(BaseStationConsts.BASE_STATION_CHECK_RLT_1.equals(approveRlt)){
			mailContent = "您提交的验收资料 已通过 讯腾公司的审核";
		}
		
		if(ContextUtil.getCurrentUser() != null &&
				StringUtils.isNotBlank(ContextUtil.getCurrentUser().getEmail())){
			//完成后发送邮件
			MailSender.sendMail(new Mail(Mail.MAIL_SEND_TEXT, 
							ContextUtil.getCurrentUser().getEmail(), 
							mailContent, "基站建设项目验收审批通知", null, null));
		}
		
	}
	
	public void saveConstructRecord(BaseConstruct baseConstruct){
		BaseConstruct oldBaseConstruct = commonDAO.load(BaseConstruct.class, baseConstruct.getBaseConstructId());
		oldBaseConstruct.setRecordNo(baseConstruct.getRecordNo());
		oldBaseConstruct.setRecordState(BaseStationConsts.BASE_STATION_RECORD_STATE_1);
		oldBaseConstruct.setConstructStage(BaseStationConsts.BASE_STATION_RECORD_STATE_1);
		commonDAO.update(oldBaseConstruct);
	}
	
	public Map<String, Object> getBaseStationDetail(String baseContractId){
		String sql = " SELECT a.base_construct_id AS baseConstructId,a.station_name AS stationName, "+
				" a.station_short_name AS stationShortName,a.station_no AS stationNo, "+
				" a.oam_area_Id AS oamAreaId,a.main_station_address AS mainStationAddress, "+
				" a.base_customer_id AS baseCustomerId,a.base_project_id AS baseProjectId, "+
				" a.main_link_user AS mainLinkUser,a.main_user_phone AS mainUserPhone, "+
				" a.station_map_no AS stationMapNo,a.server_positoin AS serverPositoin, "+
				" a.server_fix_ip AS serverFixIp,a.net_server_port AS netServerPort, "+
				" a.own_industry AS ownIndustry,a.check_state AS checkState, "+
				" (case a.check_state  "+
				" when 'WYS' then '未验收' "+
				" when 'TJYS' then '已提交验收申请'  "+
				" when 'YYS' then '已验收'  "+
				" when 'YBH' then '已验收'  "+
				" else '未验收' end) as checkStateName, "+
				" a.record_state AS recordState, "+
				" (case a.record_state  "+
				" when 'WBA' then '未备案' "+
				" when 'YBA' then '已备案'  "+
				" else '未备案' end) as recordStateName, "+
				" a.record_no as recordNo,"+
				" a.check_opinion as checkOpinion,"+
				" b.base_lng AS baseLng,b.base_lat AS baseLat, "+
				" b.base_elevation AS baseElevation,b.station_type AS stationType, "+
				" b.receiver_ip AS receiverIp,c.power_condition AS powerCondition, "+
				" c.net_condition AS netCondition,c.net_type AS netType, "+
				" c.net_config AS netConfig,d.project_no AS projectNo, "+
				" d.project_name AS projectName,e.oam_area_name AS oamAreaName,f.customer_name AS customerName "+
				" FROM "+
				" base_construct a "+
				" left JOIN base_check_matetial b ON a.base_construct_id = b.base_construct_id "+
				" left JOIN base_address c ON a.base_construct_id = c.base_construct_id "+
				" left JOIN base_project d ON a.base_project_id = d.base_project_id "+
				" left JOIN oam_area e ON a.oam_area_Id = e.oam_area_Id "+
				" left JOIN base_customer f ON a.base_customer_id = f.base_customer_id "+
				" WHERE "+
				" a.base_construct_id = :baseConstructId" ;
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("baseConstructId", baseContractId);
		Map<String, Object> baseStationDetail = commonDAO.sqlGet(sql, params);
		return baseStationDetail;
	}
	
	//保存测试资料
	public void saveBaseStationTest(BaseStationTest baseStationTest){
		String baseStationTestId = baseStationTest.getBaseStationTestId();
		if(StringUtils.isEmpty(baseStationTestId)){
			commonDAO.save(baseStationTest);
		}else{
			commonDAO.update(baseStationTest);
		}
		
		//删除base_link_point中关联数据
		String sql = "delete from base_link_point  where base_station_test_id = :baseStationTestId";
		HashMap<String, Object> params = new HashMap<String,Object>();
		params.put("baseStationTestId", baseStationTest.getBaseStationTestId());
		commonDAO.updateBySQLQuery(sql,params);
		List<BaseLinkPoint> linkPointList = baseStationTest.getBaseLinkPoint();
		if(linkPointList != null && linkPointList.size()>0){
			for (BaseLinkPoint baseLinkPoint : linkPointList) {
				baseLinkPoint.setBaseStationTest(baseStationTest);
				commonDAO.save(baseLinkPoint);
			}
		}
	}
}
