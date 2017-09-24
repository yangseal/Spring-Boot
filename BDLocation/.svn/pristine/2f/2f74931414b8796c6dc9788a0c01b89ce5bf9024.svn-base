package com.cnten.bdlocation.oamprojectconstruction.service;

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
import com.cnten.po.OamProjectConstruction;

@Service
public class OamProjectConstructionService {

	@Autowired
	CommonDAO commonDAO;
	
	public Page getOamProjectConstructionsPage(OamProjectConstruction oamProjectConstruction, Integer pageIndex, Integer pageSize) {
		String hql = "from OamProjectConstruction where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(oamProjectConstruction.getOamProject() != null && StringUtils.isNotBlank(oamProjectConstruction.getOamProject().getOamProjectId())){
			hql += " and oamProject.oamProjectId = :oamProjectId";
			params.put("oamProjectId", oamProjectConstruction.getOamProject().getOamProjectId());
		}
		if(StringUtils.isNotBlank(oamProjectConstruction.getOamProjectConstructionName())){
			hql += " and oamProjectConstructionName like :oamProjectConstructionName";
			params.put("oamProjectConstructionName", "%"+oamProjectConstruction.getOamProjectConstructionName()+"%");
		}
		hql += " order by oamProject";
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}

	public OamProjectConstruction getOamProjectConstruction(String oamProjectConstructionId) {
		return commonDAO.get(OamProjectConstruction.class, oamProjectConstructionId);
	}

	public void saveOamProjectConstruction(OamProjectConstruction oamProjectConstruction) {
		if(oamProjectConstruction.getOamProject() != null && StringUtils.isBlank(oamProjectConstruction.getOamProject().getOamProjectId())){
			oamProjectConstruction.setOamProject(null);
		}
		String oamProjectConstructionId = oamProjectConstruction.getOamProjectConstructionId();
		if(StringUtils.isEmpty(oamProjectConstructionId)){
			commonDAO.save(oamProjectConstruction);
		}else{
			OamProjectConstruction oldOamProjectConstruction = commonDAO.load(OamProjectConstruction.class, oamProjectConstructionId);
			oldOamProjectConstruction.setOamProject(oamProjectConstruction.getOamProject());
			oldOamProjectConstruction.setOamProjectConstructionName(oamProjectConstruction.getOamProjectConstructionName());
			oldOamProjectConstruction.setServices(oamProjectConstruction.getServices());
			oldOamProjectConstruction.setNrs(oamProjectConstruction.getNrs());
			oldOamProjectConstruction.setSoftware(oamProjectConstruction.getSoftware());
			oldOamProjectConstruction.setNet(oamProjectConstruction.getNet());
			oldOamProjectConstruction.setServer(oamProjectConstruction.getServer());
			oldOamProjectConstruction.setNrsConfig(oamProjectConstruction.getNrsConfig());
			oldOamProjectConstruction.setValidTesting(oamProjectConstruction.getValidTesting());
			oldOamProjectConstruction.setPrecisionTesting(oamProjectConstruction.getPrecisionTesting());
			oldOamProjectConstruction.setWgs84(oamProjectConstruction.getWgs84());
			oldOamProjectConstruction.setLocalCoordinate(oamProjectConstruction.getLocalCoordinate());
			oldOamProjectConstruction.setIsUsedPoint(oamProjectConstruction.getIsUsedPoint());
			oldOamProjectConstruction.setOtherSystem(oamProjectConstruction.getOtherSystem());
			oldOamProjectConstruction.setPlanOfTesting(oamProjectConstruction.getPlanOfTesting());
			oldOamProjectConstruction.setTestingInfo(oamProjectConstruction.getTestingInfo());
			oldOamProjectConstruction.setResultData(oamProjectConstruction.getResultData());
			oldOamProjectConstruction.setResultReport(oamProjectConstruction.getResultReport());
			oldOamProjectConstruction.setIsMeeting(oamProjectConstruction.getIsMeeting());
			commonDAO.update(oldOamProjectConstruction);
		}
	}

	public void deleteOamProjectConstruction(String oamProjectConstructionIds){
		String[] oamProjectConstructionIdArray = oamProjectConstructionIds.split(",");
		for(String oamProjectConstructionId : oamProjectConstructionIdArray){
			OamProjectConstruction oldOamProjectConstruction = commonDAO.load(OamProjectConstruction.class, oamProjectConstructionId);
			oldOamProjectConstruction.setIsDelete("Y");
			commonDAO.update(oldOamProjectConstruction);
		}
	}
	
	public void exportOamProjectConstructions(OamProjectConstruction oamProjectConstruction, HttpServletResponse response) throws Exception{
		String hql = "from OamProjectConstruction where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(oamProjectConstruction.getOamProject() != null && StringUtils.isNotBlank(oamProjectConstruction.getOamProject().getOamProjectId())){
			hql += " and oamProject.oamProjectId = :oamProjectId";
			params.put("oamProjectId", oamProjectConstruction.getOamProject().getOamProjectId());
		}
		if(StringUtils.isNotBlank(oamProjectConstruction.getOamProjectConstructionName())){
			hql += " and oamProjectConstructionName like :oamProjectConstructionName";
			params.put("oamProjectConstructionName", "%"+oamProjectConstruction.getOamProjectConstructionName()+"%");
		}
		List<OamProjectConstruction> oamProjectConstructions = commonDAO.queryList(hql, params);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("项目建设信息");
		sheet.setDefaultColumnWidth(20);
		HSSFRow row = sheet.createRow(0);
		String[] headers = {"所属项目","项目建设名称","服务器1.2","安装NRS","安装软件狗","注册NET","注册SERVER","配置NRS","可行性验证测试","精度测试","WGS84","地方坐标","是否有已知点","其它位置系统","拟定测试计划","测试描述","解算数据","出具报告","是否需要召开验收会"};
		PoiExporter.fillHeader(row, headers);
		int i = 1;
		HSSFCell cell;
		for(OamProjectConstruction oamProjectConstructionData : oamProjectConstructions){
			row = sheet.createRow(i);
			cell = row.createCell(0);
			if(oamProjectConstructionData.getOamProject() != null){
				cell.setCellValue(oamProjectConstructionData.getOamProject().getOamProjectName());
			}
			cell = row.createCell(1);
			if(oamProjectConstructionData.getOamProjectConstructionName() != null){
				cell.setCellValue(oamProjectConstructionData.getOamProjectConstructionName());
			}
			cell = row.createCell(2);
			if(oamProjectConstructionData.getServices() != null){
				cell.setCellValue(oamProjectConstructionData.getServicesName());
			}
			cell = row.createCell(3);
			if(oamProjectConstructionData.getNrs() != null){
				cell.setCellValue(oamProjectConstructionData.getNrsName());
			}
			cell = row.createCell(4);
			if(oamProjectConstructionData.getSoftware() != null){
				cell.setCellValue(oamProjectConstructionData.getSoftwareName());
			}
			cell = row.createCell(5);
			if(oamProjectConstructionData.getNet() != null){
				cell.setCellValue(oamProjectConstructionData.getNetName());
			}
			cell = row.createCell(6);
			if(oamProjectConstructionData.getServer() != null){
				cell.setCellValue(oamProjectConstructionData.getServerName());
			}
			cell = row.createCell(7);
			if(oamProjectConstructionData.getNrsConfig() != null){
				cell.setCellValue(oamProjectConstructionData.getNrsConfigName());
			}
			cell = row.createCell(8);
			if(oamProjectConstructionData.getValidTesting() != null){
				cell.setCellValue(oamProjectConstructionData.getValidTestingName());
			}
			cell = row.createCell(9);
			if(oamProjectConstructionData.getPrecisionTesting() != null){
				cell.setCellValue(oamProjectConstructionData.getPrecisionTestingName());
			}
			cell = row.createCell(10);
			if(oamProjectConstructionData.getWgs84() != null){
				cell.setCellValue(oamProjectConstructionData.getWgs84Name());
			}
			cell = row.createCell(11);
			if(oamProjectConstructionData.getLocalCoordinate() != null){
				cell.setCellValue(oamProjectConstructionData.getLocalCoordinateName());
			}
			cell = row.createCell(12);
			if(oamProjectConstructionData.getIsUsedPoint() != null){
				cell.setCellValue(oamProjectConstructionData.getIsUsedPointName());
			}
			cell = row.createCell(13);
			if(oamProjectConstructionData.getOtherSystem() != null){
				cell.setCellValue(oamProjectConstructionData.getOtherSystemName());
			}
			cell = row.createCell(14);
			if(oamProjectConstructionData.getPlanOfTesting() != null){
				cell.setCellValue(oamProjectConstructionData.getPlanOfTestingName());
			}
			cell = row.createCell(15);
			if(oamProjectConstructionData.getTestingInfo() != null){
				cell.setCellValue(oamProjectConstructionData.getTestingInfo());
			}
			cell = row.createCell(16);
			if(oamProjectConstructionData.getResultData() != null){
				cell.setCellValue(oamProjectConstructionData.getResultDataName());
			}
			cell = row.createCell(17);
			if(oamProjectConstructionData.getResultReport() != null){
				cell.setCellValue(oamProjectConstructionData.getResultReportName());
			}
			cell = row.createCell(18);
			if(oamProjectConstructionData.getIsMeeting() != null){
				cell.setCellValue(oamProjectConstructionData.getIsMeetingName());
			}
			i++;
		}
		response.setHeader("Content-Disposition", "attachment; filename=" 
				+ java.net.URLEncoder.encode("项目建设信息.xls", "UTF-8"));
		OutputStream os = response.getOutputStream();
		workbook.write(os);
		os.close();
	}
}