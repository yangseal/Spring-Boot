package com.cnten.bdlocation.oamcontacts.service;

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
import com.cnten.po.OamContacts;

@Service
public class OamContactsService {

	@Autowired
	CommonDAO commonDAO;
	
	public Page getOamContactssPage(OamContacts oamContacts, Integer pageIndex, Integer pageSize) {
		String hql = "from OamContacts where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(oamContacts.getOamContactsName())){
			hql += " and oamContactsName = :oamContactsName";
			params.put("oamContactsName", oamContacts.getOamContactsName());
		}
		if(oamContacts.getOamCustomer() != null && StringUtils.isNotBlank(oamContacts.getOamCustomer().getOamCustomerId())){
			hql += " and oamCustomer.oamCustomerId = :oamCustomerId";
			params.put("oamCustomerId", oamContacts.getOamCustomer().getOamCustomerId());
		}
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}

	public OamContacts getOamContacts(String oamContactsId) {
		return commonDAO.get(OamContacts.class, oamContactsId);
	}

	public void saveOamContacts(OamContacts oamContacts) {
		if(oamContacts.getOamCustomer() != null && StringUtils.isBlank(oamContacts.getOamCustomer().getOamCustomerId())){
			oamContacts.setOamCustomer(null);
		}
		String oamContactsId = oamContacts.getOamContactsId();
		if(StringUtils.isEmpty(oamContactsId)){
			commonDAO.save(oamContacts);
		}else{
			OamContacts oldOamContacts = commonDAO.load(OamContacts.class, oamContactsId);
			oldOamContacts.setOamContactsName(oamContacts.getOamContactsName());
			oldOamContacts.setOamCustomer(oamContacts.getOamCustomer());
			oldOamContacts.setPosition(oamContacts.getPosition());
			oldOamContacts.setTel(oamContacts.getTel());
			oldOamContacts.setPhone(oamContacts.getPhone());
			oldOamContacts.setMail(oamContacts.getMail());
			oldOamContacts.setOther(oamContacts.getOther());
			commonDAO.update(oldOamContacts);
		}
	}

	public void deleteOamContacts(String oamContactsIds){
		String[] oamContactsIdArray = oamContactsIds.split(",");
		for(String oamContactsId : oamContactsIdArray){
			OamContacts oldOamContacts = commonDAO.load(OamContacts.class, oamContactsId);
			oldOamContacts.setIsDelete("Y");
			commonDAO.update(oldOamContacts);
		}
	}
	
	public void exportOamContactss(OamContacts oamContacts, HttpServletResponse response) throws Exception{
		String hql = "from OamContacts where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(oamContacts.getOamContactsName())){
			hql += " and oamContactsName = :oamContactsName";
			params.put("oamContactsName", oamContacts.getOamContactsName());
		}
		if(oamContacts.getOamCustomer() != null && StringUtils.isNotBlank(oamContacts.getOamCustomer().getOamCustomerId())){
			hql += " and oamCustomer.oamCustomerId = :oamCustomerId";
			params.put("oamCustomerId", oamContacts.getOamCustomer().getOamCustomerId());
		}
		List<OamContacts> oamContactss = commonDAO.queryList(hql, params);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("联系人信息");
		sheet.setDefaultColumnWidth(20);
		HSSFRow row = sheet.createRow(0);
		String[] headers = {"联系人名称","所属客户","职务","电话","手机","邮箱","其它"};
		PoiExporter.fillHeader(row, headers);
		int i = 1;
		HSSFCell cell;
		for(OamContacts oamContactsData : oamContactss){
			row = sheet.createRow(i);
			cell = row.createCell(0);
			if(oamContactsData.getOamContactsName() != null){
				cell.setCellValue(oamContactsData.getOamContactsName());
			}
			cell = row.createCell(1);
			if(oamContactsData.getOamCustomer() != null){
				cell.setCellValue(oamContactsData.getOamCustomer().getOamCustomerName());
			}
			cell = row.createCell(2);
			if(oamContactsData.getPosition() != null){
				cell.setCellValue(oamContactsData.getPosition());
			}
			cell = row.createCell(3);
			if(oamContactsData.getTel() != null){
				cell.setCellValue(oamContactsData.getTel());
			}
			cell = row.createCell(4);
			if(oamContactsData.getPhone() != null){
				cell.setCellValue(oamContactsData.getPhone());
			}
			cell = row.createCell(5);
			if(oamContactsData.getMail() != null){
				cell.setCellValue(oamContactsData.getMail());
			}
			cell = row.createCell(6);
			if(oamContactsData.getOther() != null){
				cell.setCellValue(oamContactsData.getOther());
			}
			i++;
		}
		response.setHeader("Content-Disposition", "attachment; filename=" 
				+ java.net.URLEncoder.encode("联系人信息.xls", "UTF-8"));
		OutputStream os = response.getOutputStream();
		workbook.write(os);
		os.close();
	}
}