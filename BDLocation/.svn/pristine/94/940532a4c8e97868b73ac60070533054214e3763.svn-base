package com.cnten.platform.export;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

public class PoiExporter {

	public static HSSFWorkbook exportExcel(String title, String[] headers, 
			List<Map<String, Object>> datas, String[] keys) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet(title);
		sheet.setDefaultColumnWidth(20);
		fillSheet(sheet,headers,datas,keys);
		return workbook;
	}
	
	public static void fillSheet(HSSFSheet sheet, String[] headers,	
			List<Map<String, Object>> datas, String[] keys) {
		HSSFRow row = sheet.createRow(0);
		fillHeader(row,headers);
		int keysCount = keys.length;
		for(int i = 0; i < datas.size(); i++){
			row = sheet.createRow(i+1);
			for(int j = 0; j < keysCount; j++){
				HSSFCell cell = row.createCell(j);
				Object cellValue = datas.get(i).get(keys[j]);
				if(cellValue != null){
					cell.setCellValue(cellValue.toString());
				}
			}
		}
	}
	
	public static void fillHeader(HSSFRow row, String[] headers){
		HSSFCellStyle style = row.getSheet().getWorkbook().createCellStyle();
		HSSFFont f  = row.getSheet().getWorkbook().createFont();    //字体
		f.setFontHeightInPoints((short) 11);//字号        
		f.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示       
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setFont(f);       
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框  
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框  
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框  
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框  
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中  
		for (int i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style);
			cell.setCellValue(headers[i]);
		}
	}
	
	public static HSSFWorkbook exportExcel(File template, Map<String, Object> params) {
		return null;
	}
}
