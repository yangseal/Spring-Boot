package com.cnten.bdlocation.oamdevicearchives.service;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import com.cnten.platform.export.PoiExporter;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.util.StringUtil;
import com.cnten.po.OamDeviceArchives;

@Service
public class OamDeviceArchivesService {

	@Autowired
	CommonDAO commonDAO;
	
	public Page getOamDeviceArchivessPage(OamDeviceArchives oamDeviceArchives, Integer pageIndex, Integer pageSize) {
		String hql = "from OamDeviceArchives where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(oamDeviceArchives.getOamDeviceArchivesCode())){
			hql += " and oamDeviceArchivesCode like :oamDeviceArchivesCode";
			params.put("oamDeviceArchivesCode", "%"+oamDeviceArchives.getOamDeviceArchivesCode()+"%");
		}
		if(StringUtils.isNotBlank(oamDeviceArchives.getOamDeviceArchivesName())){
			hql += " and oamDeviceArchivesName like :oamDeviceArchivesName";
			params.put("oamDeviceArchivesName", "%"+oamDeviceArchives.getOamDeviceArchivesName()+"%");
		}
		hql += " order by oamDeviceArchivesCode";
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}

	public OamDeviceArchives getOamDeviceArchives(String oamDeviceArchivesId) {
		return commonDAO.get(OamDeviceArchives.class, oamDeviceArchivesId);
	}

	public void saveOamDeviceArchives(OamDeviceArchives oamDeviceArchives) {
		String oamDeviceArchivesId = oamDeviceArchives.getOamDeviceArchivesId();
		if(StringUtils.isEmpty(oamDeviceArchivesId)){
			commonDAO.save(oamDeviceArchives);
		}else{
			OamDeviceArchives oldOamDeviceArchives = commonDAO.load(OamDeviceArchives.class, oamDeviceArchivesId);
			oldOamDeviceArchives.setOamDeviceArchivesCode(oamDeviceArchives.getOamDeviceArchivesCode());
			oldOamDeviceArchives.setOamDeviceArchivesName(oamDeviceArchives.getOamDeviceArchivesName());
			oldOamDeviceArchives.setBindCorsAccount(oamDeviceArchives.getBindCorsAccount());
			oldOamDeviceArchives.setCreateDate(oamDeviceArchives.getCreateDate());
			commonDAO.update(oldOamDeviceArchives);
		}
	}

	public void deleteOamDeviceArchives(String oamDeviceArchivesIds){
		String[] oamDeviceArchivesIdArray = oamDeviceArchivesIds.split(",");
		for(String oamDeviceArchivesId : oamDeviceArchivesIdArray){
			OamDeviceArchives oldOamDeviceArchives = commonDAO.load(OamDeviceArchives.class, oamDeviceArchivesId);
			oldOamDeviceArchives.setIsDelete("Y");
			commonDAO.update(oldOamDeviceArchives);
		}
	}
	
	public void exportOamDeviceArchivess(OamDeviceArchives oamDeviceArchives, HttpServletResponse response) throws Exception{
		String hql = "from OamDeviceArchives where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(oamDeviceArchives.getOamDeviceArchivesCode())){
			hql += " and oamDeviceArchivesCode like :oamDeviceArchivesCode";
			params.put("oamDeviceArchivesCode", "%"+oamDeviceArchives.getOamDeviceArchivesCode()+"%");
		}
		if(StringUtils.isNotBlank(oamDeviceArchives.getOamDeviceArchivesName())){
			hql += " and oamDeviceArchivesName like :oamDeviceArchivesName";
			params.put("oamDeviceArchivesName", "%"+oamDeviceArchives.getOamDeviceArchivesName()+"%");
		}
		List<OamDeviceArchives> oamDeviceArchivess = commonDAO.queryList(hql, params);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("北斗设备档案信息");
		sheet.setDefaultColumnWidth(20);
		HSSFRow row = sheet.createRow(0);
		String[] headers = {"设备档案标识号","设备档案名称","绑定的基站账号","创建日期"};
		PoiExporter.fillHeader(row, headers);
		int i = 1;
		HSSFCell cell;
		for(OamDeviceArchives oamDeviceArchivesData : oamDeviceArchivess){
			row = sheet.createRow(i);
			cell = row.createCell(0);
			if(oamDeviceArchivesData.getOamDeviceArchivesCode() != null){
				cell.setCellValue(oamDeviceArchivesData.getOamDeviceArchivesCode());
			}
			cell = row.createCell(1);
			if(oamDeviceArchivesData.getOamDeviceArchivesName() != null){
				cell.setCellValue(oamDeviceArchivesData.getOamDeviceArchivesName());
			}
			cell = row.createCell(2);
			if(oamDeviceArchivesData.getBindCorsAccount() != null){
				cell.setCellValue(oamDeviceArchivesData.getBindCorsAccount());
			}
			cell = row.createCell(3);
			if(oamDeviceArchivesData.getCreateDate() != null){
				cell.setCellValue(StringUtil.formatDateTime(oamDeviceArchivesData.getCreateDate()));
			}
			i++;
		}
		response.setHeader("Content-Disposition", "attachment; filename=" 
				+ java.net.URLEncoder.encode("北斗设备档案信息.xls", "UTF-8"));
		OutputStream os = response.getOutputStream();
		workbook.write(os);
		os.close();
	}
}