package com.cnten.bdlocation.measurepoint.service;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.bdlocation.companyOrg.service.CompanyOrgService;
import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.export.PoiExporter;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.util.StringUtil;
import com.cnten.po.Attachment;
import com.cnten.po.MeasurePoint;
import com.cnten.po.MeasureProject;
import com.cnten.po.PointType;

@Service
public class MeasurePointService {

	@Autowired
	CommonDAO commonDAO;
	
	@Autowired
	CompanyOrgService companyOrgService;
	
	public Page getMeasurePointsPage(MeasurePoint measurePoint, Integer pageIndex, Integer pageSize) {
		String hql = "from MeasurePoint where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(!StringUtils.isEmpty(measurePoint.getAffiliationProjectId())){
			hql += " and affiliationProject.measureProjectId = :measureProjectId";
			params.put("measureProjectId", measurePoint.getAffiliationProjectId());
		}else if(!ContextUtil.isSystemUser()){
			hql += " and affiliationProject.affiliationCompany.companyId = :companyId"
				+ " and affiliationProject.companyOrg.companyOrgId in (:orgs) ";
			String companyId = ContextUtil.getCurrentUser().getCompany().getCompanyId();
			params.put("companyId", companyId);
			params.put("orgs", companyOrgService.querySelfAndChildOrg());
		}
		if(measurePoint.getAffiliationPointType() != null 
				&& StringUtils.isNotBlank(measurePoint.getAffiliationPointType().getPointTypeCode())){
			hql += " and affiliationPointType.pointTypeCode in (:pointTypeCode)";
			String[] pointTypeCode = measurePoint.getAffiliationPointType().getPointTypeCode().split(",");
			params.put("pointTypeCode",pointTypeCode);
		} 
		hql += " order by createDate desc";
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}

	public MeasurePoint getMeasurePoint(String measurePointId) {
		return commonDAO.get(MeasurePoint.class, measurePointId);
	}
	
	public List<MeasurePoint> getMeasurePointList(MeasureProject affiliationProject) {
		String hql = "from MeasurePoint where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(null == affiliationProject || StringUtils.isEmpty(affiliationProject.getMeasureProjectId())) {
			return null;
		} else {
			hql += " and affiliationProject.measureProjectId= :measureProjectId";
			params.put("measureProjectId", affiliationProject.getMeasureProjectId());
		}
		
		return commonDAO.queryList(hql, params);
	}

	public void saveMeasurePoint(MeasurePoint measurePoint) throws Exception {
		if(StringUtils.isEmpty(measurePoint.getAffiliationPointTypeId())){
			measurePoint.setAffiliationPointType(null);
		}else{
			measurePoint.setAffiliationPointType(new PointType(measurePoint.getAffiliationPointTypeId()));
		}
		if(StringUtils.isEmpty(measurePoint.getAffiliationProjectId())){
			measurePoint.setAffiliationProject(null);
		}else{
			measurePoint.setAffiliationProject(new MeasureProject(measurePoint.getAffiliationProjectId()));
		}
		
		/*if(measurePoint.getCoordinateX() == null || measurePoint.getCoordinateY() == null) {
			Double b,l;
			CoodinateCover cc = new CoodinateCover(3, enumEllipseSys.WGS84, enumLocalCoordinateSys.BeiJingCJ);
			if((b=measurePoint.getLatitude()) != null && (l=measurePoint.getLongitude()) != null) {
				if(cc.FunCover(b, l)) {
					measurePoint.setCoordinateX(cc.get_Y());
					measurePoint.setCoordinateY(cc.get_X());
				} else {
					throw new Exception(cc.get_ErrMsg());
				}
			}
		}*/
		
		String measurePointId = measurePoint.getMeasurePointId();
		if(StringUtils.isEmpty(measurePointId)){
			commonDAO.save(measurePoint);
		}else{
			MeasurePoint oldMeasurePoint = commonDAO.load(MeasurePoint.class, measurePointId);
			oldMeasurePoint.setMeasurePointName(measurePoint.getMeasurePointName());
			oldMeasurePoint.setMeasurePointCode(measurePoint.getMeasurePointCode());
			oldMeasurePoint.setAffiliationPointType(measurePoint.getAffiliationPointType());
			oldMeasurePoint.setPointDesc(measurePoint.getPointDesc());
			oldMeasurePoint.setSolutionState(measurePoint.getSolutionState());
			oldMeasurePoint.setHrms(measurePoint.getHrms());
			oldMeasurePoint.setVrms(measurePoint.getVrms());
			oldMeasurePoint.setLongitude(measurePoint.getLongitude());
			oldMeasurePoint.setLatitude (measurePoint.getLatitude ());
			oldMeasurePoint.setNorth(measurePoint.getNorth());
			oldMeasurePoint.setEast(measurePoint.getEast());
			oldMeasurePoint.setCoordinateX(measurePoint.getCoordinateX());
			oldMeasurePoint.setCoordinateY(measurePoint.getCoordinateY());
			oldMeasurePoint.setEllHeight(measurePoint.getEllHeight());
			oldMeasurePoint.setAltitude(measurePoint.getAltitude());
			oldMeasurePoint.setCreateDate(measurePoint.getCreateDate());
			oldMeasurePoint.setAffiliationProject(measurePoint.getAffiliationProject());
			commonDAO.update(oldMeasurePoint);
		}
	}

	public void deleteMeasurePoint(String measurePointIds){
		String[] measurePointIdArray = measurePointIds.split(",");
		for(String measurePointId : measurePointIdArray){
			MeasurePoint oldMeasurePoint = commonDAO.load(MeasurePoint.class, measurePointId);
			oldMeasurePoint.setIsDelete("Y");
			commonDAO.update(oldMeasurePoint);
		}
	}
	
	public void exportMeasurePoints(MeasurePoint measurePoint, HttpServletResponse response) throws Exception{
		String hql = "from MeasurePoint where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		List<MeasurePoint> measurePoints = commonDAO.queryList(hql, params);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("测量点信息");
		sheet.setDefaultColumnWidth(20);
		HSSFRow row = sheet.createRow(0);
		String[] headers = {"点名称","点编码","所属点类型","描述","解状态","hrms","vrms","纬度","经度","北坐标","东坐标","城建坐标X","城建坐标Y","椭球高","高程","创建时间","所属工程"};
		PoiExporter.fillHeader(row, headers);
		int i = 1;
		HSSFCell cell;
		for(MeasurePoint measurePointData : measurePoints){
			row = sheet.createRow(i);
			cell = row.createCell(0);
			if(measurePointData.getMeasurePointName() != null){
				cell.setCellValue(measurePointData.getMeasurePointName());
			}
			cell = row.createCell(1);
			if(measurePointData.getMeasurePointCode() != null){
				cell.setCellValue(measurePointData.getMeasurePointCode());
			}
			cell = row.createCell(2);
			if(measurePointData.getAffiliationPointType() != null){
				cell.setCellValue(measurePointData.getAffiliationPointType().getPointTypeName());
			}
			cell = row.createCell(3);
			if(measurePointData.getPointDesc() != null){
				cell.setCellValue(measurePointData.getPointDesc());
			}
			cell = row.createCell(4);
			if(measurePointData.getSolutionState() != null){
				cell.setCellValue(measurePointData.getSolutionStateName());
			}
			cell = row.createCell(5);
			if(measurePointData.getHrms() != null){
				cell.setCellValue(measurePointData.getHrms());
			}
			cell = row.createCell(6);
			if(measurePointData.getVrms() != null){
				cell.setCellValue(measurePointData.getVrms());
			}
			cell = row.createCell(7);
			if(measurePointData.getLongitude() != null){
				cell.setCellValue(measurePointData.getLongitude());
			}
			cell = row.createCell(8);
			if(measurePointData.getLatitude () != null){
				cell.setCellValue(measurePointData.getLatitude ());
			}
			cell = row.createCell(9);
			if(measurePointData.getNorth() != null){
				cell.setCellValue(measurePointData.getNorth());
			}
			cell = row.createCell(10);
			if(measurePointData.getEast() != null){
				cell.setCellValue(measurePointData.getEast());
			}
			cell = row.createCell(11);
			if(measurePointData.getCoordinateX() != null){
				cell.setCellValue(measurePointData.getCoordinateX());
			}
			cell = row.createCell(12);
			if(measurePointData.getCoordinateY() != null){
				cell.setCellValue(measurePointData.getCoordinateY());
			}
			cell = row.createCell(13);
			if(measurePointData.getEllHeight() != null){
				cell.setCellValue(measurePointData.getEllHeight());
			}
			cell = row.createCell(14);
			if(measurePointData.getAltitude() != null){
				cell.setCellValue(measurePointData.getAltitude());
			}
			cell = row.createCell(15);
			if(measurePointData.getCreateDate() != null){
				cell.setCellValue(StringUtil.formatDateTime(measurePointData.getCreateDate()));
			}
			cell = row.createCell(16);
			if(measurePointData.getAffiliationProject() != null){
				cell.setCellValue(measurePointData.getAffiliationProject().getMeasureProjectName());
			}
			i++;
		}
		response.setHeader("Content-Disposition", "attachment; filename=" 
				+ java.net.URLEncoder.encode("测量点信息.xls", "UTF-8"));
		OutputStream os = response.getOutputStream();
		workbook.write(os);
		os.close();
	}

	public List<MeasurePoint> getLngLatByIds(String selectPoints) {
		String ids[] = selectPoints.split(",");
		String pointTypeIds = "";
		String hql = "from MeasurePoint where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(!StringUtils.isEmpty(selectPoints) && ids.length>0){
			hql += " and measurePointId in (:ids)";
			params.put("ids", ids);
		}
		List<MeasurePoint> measurePointList = commonDAO.queryList(hql, params);
		
		for (MeasurePoint measurePoint : measurePointList) {
			pointTypeIds += measurePoint.getAffiliationPointType().getPointTypeId()+",";
		}
		pointTypeIds = pointTypeIds.substring(0,pointTypeIds.length()-1);
		
		String hql2 = "from Attachment where isDelete is null";
		HashMap<String,Object> params2 = new HashMap<String,Object>();
		if(!StringUtils.isEmpty(selectPoints) && ids.length>0){
			hql2 += " and entityName = :entityName and fieldName = :fieldName and entityId in (:ids)";
			params2.put("entityName", "pointType");
			params2.put("fieldName", "attachments");
			params2.put("ids", pointTypeIds);
		}
		List<Attachment> attachmentList = commonDAO.queryList(hql2, params2);
		
		for(int i=0; i<attachmentList.size(); i++){
			String attachmentid = attachmentList.get(i).getAttachmentId();
			String entityid = attachmentList.get(i).getEntityId();
			for(int j=0; j<measurePointList.size(); j++){
				String measurepointid = measurePointList.get(j).getAffiliationPointType().getPointTypeId();
				if(measurepointid.equals(entityid)){
					measurePointList.get(j).setAttachmentId(attachmentid);
				}
			}
		}
		
		return measurePointList;
	}
	
}