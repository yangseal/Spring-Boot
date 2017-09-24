package com.cnten.bdlocation.oamprovider.service;

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
import com.cnten.po.OamProvider;

@Service
public class OamProviderService {

	@Autowired
	CommonDAO commonDAO;
	
	public Page getOamProvidersPage(OamProvider oamProvider, Integer pageIndex, Integer pageSize) {
		String hql = "from OamProvider where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(oamProvider.getOamProviderName())){
			hql += " and oamProviderName like :oamProviderName";
			params.put("oamProviderName", "%"+oamProvider.getOamProviderName()+"%");
		}
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}

	public OamProvider getOamProvider(String oamProviderId) {
		return commonDAO.get(OamProvider.class, oamProviderId);
	}

	public void saveOamProvider(OamProvider oamProvider) {
		String oamProviderId = oamProvider.getOamProviderId();
		if(StringUtils.isEmpty(oamProviderId)){
			commonDAO.save(oamProvider);
		}else{
			OamProvider oldOamProvider = commonDAO.load(OamProvider.class, oamProviderId);
			oldOamProvider.setOamProviderName(oamProvider.getOamProviderName());
			oldOamProvider.setProducts(oamProvider.getProducts());
			oldOamProvider.setContact(oamProvider.getContact());
			commonDAO.update(oldOamProvider);
		}
	}

	public void deleteOamProvider(String oamProviderIds){
		String[] oamProviderIdArray = oamProviderIds.split(",");
		for(String oamProviderId : oamProviderIdArray){
			OamProvider oldOamProvider = commonDAO.load(OamProvider.class, oamProviderId);
			oldOamProvider.setIsDelete("Y");
			commonDAO.update(oldOamProvider);
		}
	}
	
	public void exportOamProviders(OamProvider oamProvider, HttpServletResponse response) throws Exception{
		String hql = "from OamProvider where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(oamProvider.getOamProviderName())){
			hql += " and oamProviderName like :oamProviderName";
			params.put("oamProviderName", "%"+oamProvider.getOamProviderName()+"%");
		}
		List<OamProvider> oamProviders = commonDAO.queryList(hql, params);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("供应商信息");
		sheet.setDefaultColumnWidth(20);
		HSSFRow row = sheet.createRow(0);
		String[] headers = {"供应商名称","主营业务","联系方式"};
		PoiExporter.fillHeader(row, headers);
		int i = 1;
		HSSFCell cell;
		for(OamProvider oamProviderData : oamProviders){
			row = sheet.createRow(i);
			cell = row.createCell(0);
			if(oamProviderData.getOamProviderName() != null){
				cell.setCellValue(oamProviderData.getOamProviderName());
			}
			cell = row.createCell(1);
			if(oamProviderData.getProducts() != null){
				cell.setCellValue(oamProviderData.getProducts());
			}
			cell = row.createCell(2);
			if(oamProviderData.getContact() != null){
				cell.setCellValue(oamProviderData.getContact());
			}
			i++;
		}
		response.setHeader("Content-Disposition", "attachment; filename=" 
				+ java.net.URLEncoder.encode("供应商信息.xls", "UTF-8"));
		OutputStream os = response.getOutputStream();
		workbook.write(os);
		os.close();
	}
}