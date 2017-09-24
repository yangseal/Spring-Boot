package com.cnten.bdlocation.conversionprojection.service;

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
import com.cnten.po.ConversionProjection;

@Service
public class ConversionProjectionService {

	@Autowired
	CommonDAO commonDAO;
	
	public Page getConversionProjectionsPage(ConversionProjection conversionProjection, Integer pageIndex, Integer pageSize) {
		String hql = "from ConversionProjection where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(conversionProjection.getConversionProjectionName())){
			hql += " and conversionProjectionName like :conversionProjectionName";
			params.put("conversionProjectionName", "%"+conversionProjection.getConversionProjectionName()+"%");
		}
		if(StringUtils.isNotBlank(conversionProjection.getConversionProjectionCode())){
			hql += " and conversionProjectionCode like :conversionProjectionCode";
			params.put("conversionProjectionCode", "%"+conversionProjection.getConversionProjectionCode()+"%");
		}
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}

	public ConversionProjection getConversionProjection(String conversionProjectionId) {
		return commonDAO.get(ConversionProjection.class, conversionProjectionId);
	}

	public void saveConversionProjection(ConversionProjection conversionProjection) {
		String conversionProjectionId = conversionProjection.getConversionProjectionId();
		if(StringUtils.isEmpty(conversionProjectionId)){
			commonDAO.save(conversionProjection);
		}else{
			ConversionProjection oldConversionProjection = commonDAO.load(ConversionProjection.class, conversionProjectionId);
			oldConversionProjection.setConversionProjectionName(conversionProjection.getConversionProjectionName());
			oldConversionProjection.setConversionProjectionCode(conversionProjection.getConversionProjectionCode());
			oldConversionProjection.setProjectType(conversionProjection.getProjectType());
			oldConversionProjection.setMeridian(conversionProjection.getMeridian());
			oldConversionProjection.setK(conversionProjection.getK());
			oldConversionProjection.setX(conversionProjection.getX());
			oldConversionProjection.setY(conversionProjection.getY());
			oldConversionProjection.setStanderdLat(conversionProjection.getStanderdLat());
			oldConversionProjection.setH(conversionProjection.getH());
			oldConversionProjection.setAverageLat(conversionProjection.getAverageLat());
			commonDAO.update(oldConversionProjection);
		}
	}

	public void deleteConversionProjection(String conversionProjectionIds){
		String[] conversionProjectionIdArray = conversionProjectionIds.split(",");
		for(String conversionProjectionId : conversionProjectionIdArray){
			ConversionProjection oldConversionProjection = commonDAO.load(ConversionProjection.class, conversionProjectionId);
			oldConversionProjection.setIsDelete("Y");
			commonDAO.update(oldConversionProjection);
		}
	}
	
	public void exportConversionProjections(ConversionProjection conversionProjection, HttpServletResponse response) throws Exception{
		String hql = "from ConversionProjection where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(conversionProjection.getConversionProjectionName())){
			hql += " and conversionProjectionName like :conversionProjectionName";
			params.put("conversionProjectionName", "%"+conversionProjection.getConversionProjectionName()+"%");
		}
		if(StringUtils.isNotBlank(conversionProjection.getConversionProjectionCode())){
			hql += " and conversionProjectionCode like :conversionProjectionCode";
			params.put("conversionProjectionCode", "%"+conversionProjection.getConversionProjectionCode()+"%");
		}
		List<ConversionProjection> conversionProjections = commonDAO.queryList(hql, params);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("转换投影信息");
		sheet.setDefaultColumnWidth((short) 20);
		HSSFRow row = sheet.createRow(0);
		String[] headers = {"转换投影名称","转换投影编码","投影类型","中央子午线","尺度","x常数","y常数","基准纬度","投影高程","投影平均纬"};
		PoiExporter.fillHeader(row, headers);
		int i = 1;
		HSSFCell cell;
		for(ConversionProjection conversionProjectionData : conversionProjections){
			row = sheet.createRow(i);
			cell = row.createCell(0);
			if(conversionProjectionData.getConversionProjectionName() != null){
				cell.setCellValue(conversionProjectionData.getConversionProjectionName());
			}
			cell = row.createCell(1);
			if(conversionProjectionData.getConversionProjectionCode() != null){
				cell.setCellValue(conversionProjectionData.getConversionProjectionCode());
			}
			cell = row.createCell(2);
			if(conversionProjectionData.getProjectType() != null){
				cell.setCellValue(conversionProjectionData.getProjectType());
			}
			cell = row.createCell(3);
			if(conversionProjectionData.getMeridian() != null){
				cell.setCellValue(conversionProjectionData.getMeridian());
			}
			cell = row.createCell(4);
			if(conversionProjectionData.getK() != null){
				cell.setCellValue(conversionProjectionData.getK());
			}
			cell = row.createCell(5);
			if(conversionProjectionData.getX() != null){
				cell.setCellValue(conversionProjectionData.getX());
			}
			cell = row.createCell(6);
			if(conversionProjectionData.getY() != null){
				cell.setCellValue(conversionProjectionData.getY());
			}
			cell = row.createCell(7);
			if(conversionProjectionData.getStanderdLat() != null){
				cell.setCellValue(conversionProjectionData.getStanderdLat());
			}
			cell = row.createCell(8);
			if(conversionProjectionData.getH() != null){
				cell.setCellValue(conversionProjectionData.getH());
			}
			cell = row.createCell(9);
			if(conversionProjectionData.getAverageLat() != null){
				cell.setCellValue(conversionProjectionData.getAverageLat());
			}
			i++;
		}
		response.setHeader("Content-Disposition", "attachment; filename=" 
				+ java.net.URLEncoder.encode("转换投影信息.xls", "UTF-8"));
		OutputStream os = response.getOutputStream();
		workbook.write(os);
		os.close();
	}
}