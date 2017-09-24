package com.cnten.bdlocation.oamstationconstruction.service;

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

import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.export.PoiExporter;
import com.cnten.platform.util.StringUtil;
import com.cnten.po.OamProject;
import com.cnten.po.OamProjectConstruction;
import com.cnten.po.OamStationConstruction;

@Service
public class OamStationConstructionService {

	@Autowired
	CommonDAO commonDAO;
	
	public Page getOamStationConstructionsPage(OamStationConstruction oamStationConstruction, Integer pageIndex, Integer pageSize) {
		String hql = "from OamStationConstruction where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(oamStationConstruction.getOamBaseStation() != null && StringUtils.isNotBlank(oamStationConstruction.getOamBaseStation().getOamBaseStationId())){
			hql += " and oamBaseStation.oamBaseStationId = :oamBaseStationId";
			params.put("oamBaseStationId", oamStationConstruction.getOamBaseStation().getOamBaseStationId());
		}
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}

	public OamStationConstruction getOamStationConstruction(String oamStationConstructionId) {
		return commonDAO.get(OamStationConstruction.class, oamStationConstructionId);
	}

	public void saveOamStationConstruction(OamStationConstruction oamStationConstruction) {
		if(oamStationConstruction.getOamProjectConstruction() != null && StringUtils.isBlank(oamStationConstruction.getOamProjectConstruction().getOamProjectConstructionId())){
			oamStationConstruction.setOamProjectConstruction(null);
		}
		if(oamStationConstruction.getOamBaseStation() != null && StringUtils.isBlank(oamStationConstruction.getOamBaseStation().getOamBaseStationId())){
			oamStationConstruction.setOamBaseStation(null);
		}
		String oamStationConstructionId = oamStationConstruction.getOamStationConstructionId();
		if(StringUtils.isEmpty(oamStationConstructionId)){
			commonDAO.save(oamStationConstruction);
		}else{
			OamStationConstruction oldOamStationConstruction = commonDAO.load(OamStationConstruction.class, oamStationConstructionId);
			oldOamStationConstruction.setOamProjectConstruction(oamStationConstruction.getOamProjectConstruction());
			oldOamStationConstruction.setOamBaseStation(oamStationConstruction.getOamBaseStation());
			oldOamStationConstruction.setInstallAntenna(oamStationConstruction.getInstallAntenna());
			oldOamStationConstruction.setInstallwiring(oamStationConstruction.getInstallwiring());
			oldOamStationConstruction.setMainframeRoom(oamStationConstruction.getMainframeRoom());
			oldOamStationConstruction.setInstallMainframe(oamStationConstruction.getInstallMainframe());
			oldOamStationConstruction.setUpdateData(oamStationConstruction.getUpdateData());
			oldOamStationConstruction.setUpdatePosition(oamStationConstruction.getUpdatePosition());
			oldOamStationConstruction.setMainframeRegiter(oamStationConstruction.getMainframeRegiter());
			oldOamStationConstruction.setObservationStartTime(oamStationConstruction.getObservationStartTime());
			oldOamStationConstruction.setObservationEndTime(oamStationConstruction.getObservationEndTime());
			commonDAO.update(oldOamStationConstruction);
		}
	}

	public void deleteOamStationConstruction(String oamStationConstructionIds){
		String[] oamStationConstructionIdArray = oamStationConstructionIds.split(",");
		for(String oamStationConstructionId : oamStationConstructionIdArray){
			OamStationConstruction oldOamStationConstruction = commonDAO.load(OamStationConstruction.class, oamStationConstructionId);
			oldOamStationConstruction.setIsDelete("Y");
			commonDAO.update(oldOamStationConstruction);
		}
	}
	
	public void exportOamStationConstructions(OamStationConstruction oamStationConstruction, HttpServletResponse response) throws Exception{
		String hql = "from OamStationConstruction where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(oamStationConstruction.getOamBaseStation() != null && StringUtils.isNotBlank(oamStationConstruction.getOamBaseStation().getOamBaseStationId())){
			hql += " and oamBaseStation.oamBaseStationId = :oamBaseStationId";
			params.put("oamBaseStationId", oamStationConstruction.getOamBaseStation().getOamBaseStationId());
		}
		List<OamStationConstruction> oamStationConstructions = commonDAO.queryList(hql, params);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("基站建设信息");
		sheet.setDefaultColumnWidth(20);
		HSSFRow row = sheet.createRow(0);
		String[] headers = {"项目建设","基站","安装天线","布设线缆","布置机房","安装主机","数据上发","位置上发","主机注册","观测开始时间","观测结束时间"};
		PoiExporter.fillHeader(row, headers);
		int i = 1;
		HSSFCell cell;
		for(OamStationConstruction oamStationConstructionData : oamStationConstructions){
			row = sheet.createRow(i);
			cell = row.createCell(0);
			if(oamStationConstructionData.getOamProjectConstruction() != null){
				cell.setCellValue(oamStationConstructionData.getOamProjectConstruction().getOamProjectConstructionName());
			}
			cell = row.createCell(1);
			if(oamStationConstructionData.getOamBaseStation() != null){
				cell.setCellValue(oamStationConstructionData.getOamBaseStation().getOamBaseStationName());
			}
			cell = row.createCell(2);
			if(oamStationConstructionData.getInstallAntenna() != null){
				cell.setCellValue(oamStationConstructionData.getInstallAntennaName());
			}
			cell = row.createCell(3);
			if(oamStationConstructionData.getInstallwiring() != null){
				cell.setCellValue(oamStationConstructionData.getInstallwiringName());
			}
			cell = row.createCell(4);
			if(oamStationConstructionData.getMainframeRoom() != null){
				cell.setCellValue(oamStationConstructionData.getMainframeRoomName());
			}
			cell = row.createCell(5);
			if(oamStationConstructionData.getInstallMainframe() != null){
				cell.setCellValue(oamStationConstructionData.getInstallMainframeName());
			}
			cell = row.createCell(6);
			if(oamStationConstructionData.getUpdateData() != null){
				cell.setCellValue(oamStationConstructionData.getUpdateDataName());
			}
			cell = row.createCell(7);
			if(oamStationConstructionData.getUpdatePosition() != null){
				cell.setCellValue(oamStationConstructionData.getUpdatePositionName());
			}
			cell = row.createCell(8);
			if(oamStationConstructionData.getMainframeRegiter() != null){
				cell.setCellValue(oamStationConstructionData.getMainframeRegiterName());
			}
			cell = row.createCell(9);
			if(oamStationConstructionData.getObservationStartTime() != null){
				cell.setCellValue(StringUtil.formatDateTime(oamStationConstructionData.getObservationStartTime()));
			}
			cell = row.createCell(10);
			if(oamStationConstructionData.getObservationEndTime() != null){
				cell.setCellValue(StringUtil.formatDateTime(oamStationConstructionData.getObservationEndTime()));
			}
			i++;
		}
		response.setHeader("Content-Disposition", "attachment; filename=" 
				+ java.net.URLEncoder.encode("基站建设信息.xls", "UTF-8"));
		OutputStream os = response.getOutputStream();
		workbook.write(os);
		os.close();
	}
	
	public void saveOamStationConstructionMobile(OamStationConstruction oamStationConstruction) {
		String hql = "from OamStationConstruction where oamBaseStation.oamBaseStationId = ?";
		String oamBaseStationId = oamStationConstruction.getOamBaseStation() == null ? null : oamStationConstruction.getOamBaseStation().getOamBaseStationId();
		OamStationConstruction oldOamStationConstruction = commonDAO.getByVariableParam(hql,oamBaseStationId);
		if(oldOamStationConstruction != null){
			oldOamStationConstruction.setInstallAntenna(oamStationConstruction.getInstallAntenna());
			oldOamStationConstruction.setInstallMainframe(oamStationConstruction.getInstallMainframe());
			oldOamStationConstruction.setInstallwiring(oamStationConstruction.getInstallwiring());
			oldOamStationConstruction.setMainframeRegiter(oamStationConstruction.getMainframeRegiter());
			oldOamStationConstruction.setMainframeRoom(oamStationConstruction.getMainframeRoom());
			oldOamStationConstruction.setObservationEndTime(oamStationConstruction.getObservationEndTime());
			oldOamStationConstruction.setObservationStartTime(oamStationConstruction.getObservationStartTime());
			oldOamStationConstruction.setUpdateData(oamStationConstruction.getUpdateData());
			oldOamStationConstruction.setUpdatePosition(oamStationConstruction.getUpdatePosition());
			commonDAO.update(oldOamStationConstruction);
		}else{
			hql = "select p from OamProject p,OamBaseStation s"
					+ " where p.oamProjectCode=s.oamProject.oamProjectCode and s.oamBaseStationId=?";
			OamProject oamProject = commonDAO.getByVariableParam(hql, oamBaseStationId);
			if(oamProject != null){
				hql = "from OamProjectConstruction where oamProject.oamProjectId = ?";
				OamProjectConstruction oamProjectConstruction = commonDAO.getByVariableParam(hql, oamProject.getOamProjectId());
				if(oamProjectConstruction == null){
					oamProjectConstruction = new OamProjectConstruction();
					oamProjectConstruction.setOamProject(oamProject);
					commonDAO.save(oamProjectConstruction);
				}
				oamStationConstruction.setOamProjectConstruction(oamProjectConstruction);;
			}
			commonDAO.save(oamStationConstruction);
		}
	}
}