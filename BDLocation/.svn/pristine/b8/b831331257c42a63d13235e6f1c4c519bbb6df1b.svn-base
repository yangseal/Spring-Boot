package com.cnten.bdlocation.oamprojecttesting.service;

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
import com.cnten.po.OamProjectTesting;

@Service
public class OamProjectTestingService {

	@Autowired
	CommonDAO commonDAO;
	
	public Page getOamProjectTestingsPage(OamProjectTesting oamProjectTesting, Integer pageIndex, Integer pageSize) {
		String hql = "from OamProjectTesting where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(oamProjectTesting.getOamProject() != null && StringUtils.isNotBlank(oamProjectTesting.getOamProject().getOamProjectId())){
			hql += " and oamProject.oamProjectId = :oamProjectId";
			params.put("oamProjectId", oamProjectTesting.getOamProject().getOamProjectId());
		}
		if(StringUtils.isNotBlank(oamProjectTesting.getOamProjectTestingName())){
			hql += " and oamProjectTestingName like :oamProjectTestingName";
			params.put("oamProjectTestingName", "%"+oamProjectTesting.getOamProjectTestingName()+"%");
		}
		hql += " order by oamProject";
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}

	public OamProjectTesting getOamProjectTesting(String oamProjectTestingId) {
		return commonDAO.get(OamProjectTesting.class, oamProjectTestingId);
	}

	public void saveOamProjectTesting(OamProjectTesting oamProjectTesting) {
		if(oamProjectTesting.getOamProject() != null && StringUtils.isBlank(oamProjectTesting.getOamProject().getOamProjectId())){
			oamProjectTesting.setOamProject(null);
		}
		String oamProjectTestingId = oamProjectTesting.getOamProjectTestingId();
		if(StringUtils.isEmpty(oamProjectTestingId)){
			commonDAO.save(oamProjectTesting);
		}else{
			OamProjectTesting oldOamProjectTesting = commonDAO.load(OamProjectTesting.class, oamProjectTestingId);
			oldOamProjectTesting.setOamProject(oamProjectTesting.getOamProject());
			oldOamProjectTesting.setOamProjectTestingName(oamProjectTesting.getOamProjectTestingName());
			oldOamProjectTesting.setTestingSchedule(oamProjectTesting.getTestingSchedule());
			oldOamProjectTesting.setPlanSchedule(oamProjectTesting.getPlanSchedule());
			oldOamProjectTesting.setSchedule(oamProjectTesting.getSchedule());
			commonDAO.update(oldOamProjectTesting);
		}
	}

	public void deleteOamProjectTesting(String oamProjectTestingIds){
		String[] oamProjectTestingIdArray = oamProjectTestingIds.split(",");
		for(String oamProjectTestingId : oamProjectTestingIdArray){
			OamProjectTesting oldOamProjectTesting = commonDAO.load(OamProjectTesting.class, oamProjectTestingId);
			oldOamProjectTesting.setIsDelete("Y");
			commonDAO.update(oldOamProjectTesting);
		}
	}
	
	public void exportOamProjectTestings(OamProjectTesting oamProjectTesting, HttpServletResponse response) throws Exception{
		String hql = "from OamProjectTesting where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(oamProjectTesting.getOamProject() != null && StringUtils.isNotBlank(oamProjectTesting.getOamProject().getOamProjectId())){
			hql += " and oamProject.oamProjectId = :oamProjectId";
			params.put("oamProjectId", oamProjectTesting.getOamProject().getOamProjectId());
		}
		if(StringUtils.isNotBlank(oamProjectTesting.getOamProjectTestingName())){
			hql += " and oamProjectTestingName like :oamProjectTestingName";
			params.put("oamProjectTestingName", "%"+oamProjectTesting.getOamProjectTestingName()+"%");
		}
		List<OamProjectTesting> oamProjectTestings = commonDAO.queryList(hql, params);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("项目测试信息");
		sheet.setDefaultColumnWidth(20);
		HSSFRow row = sheet.createRow(0);
		String[] headers = {"所属项目","项目测试名称","测试日程描述","初拟基建日程描述","确定基建日程描述"};
		PoiExporter.fillHeader(row, headers);
		int i = 1;
		HSSFCell cell;
		for(OamProjectTesting oamProjectTestingData : oamProjectTestings){
			row = sheet.createRow(i);
			cell = row.createCell(0);
			if(oamProjectTestingData.getOamProject() != null){
				cell.setCellValue(oamProjectTestingData.getOamProject().getOamProjectName());
			}
			cell = row.createCell(1);
			if(oamProjectTestingData.getOamProjectTestingName() != null){
				cell.setCellValue(oamProjectTestingData.getOamProjectTestingName());
			}
			cell = row.createCell(2);
			if(oamProjectTestingData.getTestingSchedule() != null){
				cell.setCellValue(oamProjectTestingData.getTestingSchedule());
			}
			cell = row.createCell(3);
			if(oamProjectTestingData.getPlanSchedule() != null){
				cell.setCellValue(oamProjectTestingData.getPlanSchedule());
			}
			cell = row.createCell(4);
			if(oamProjectTestingData.getSchedule() != null){
				cell.setCellValue(oamProjectTestingData.getSchedule());
			}
			i++;
		}
		response.setHeader("Content-Disposition", "attachment; filename=" 
				+ java.net.URLEncoder.encode("项目测试信息.xls", "UTF-8"));
		OutputStream os = response.getOutputStream();
		workbook.write(os);
		os.close();
	}
}