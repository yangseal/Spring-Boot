package com.cnten.bdlocation.oamcustomer.service;

import java.io.OutputStream;
import java.util.ArrayList;
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

import com.cnten.bdlocation.oamarea.service.OamAreaService;
import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.export.PoiExporter;
import com.cnten.po.BaseCustomer;
import com.cnten.po.OamArea;
import com.cnten.po.OamCustomer;

@Service
public class OamCustomerService {

	@Autowired
	CommonDAO commonDAO;
	@Autowired
	private OamAreaService oamAreaService;
	
	public Page getOamCustomersPage(OamCustomer oamCustomer, Integer pageIndex, Integer pageSize) {
		String hql = "from OamCustomer where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(oamCustomer.getOamCustomerName())){
			hql += " and oamCustomerName like :oamCustomerName";
			params.put("oamCustomerName", "%"+oamCustomer.getOamCustomerName()+"%");
		}
		if(oamCustomer.getOamArea() != null && StringUtils.isNotBlank(oamCustomer.getOamArea().getOamAreaId())){
			OamArea oamArea = oamCustomer.getOamArea();
			List<OamArea> oamAreas = oamAreaService.getOamAreas();
			List<String> ids = new ArrayList<>();
			ids.add(oamArea.getOamAreaId());
			addChildren(oamArea, oamAreas, ids);
			hql += " and oamArea.oamAreaId in(:ids)";
			params.put("ids", ids.toArray());
		}
		hql += " order by oamCustomerName";
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}
	
	private void addChildren(OamArea oamArea,List<OamArea> oamAreas,List<String> ids){
		for(OamArea m : oamAreas){
			if(oamArea.getOamAreaId().equals(m.getParentId())){
				ids.add(m.getOamAreaId());
				addChildren(m, oamAreas, ids);
			}
		}
	}

	public OamCustomer getOamCustomer(String oamCustomerId) {
		return commonDAO.get(OamCustomer.class, oamCustomerId);
	}

	public void saveOamCustomer(OamCustomer oamCustomer) {
		if(oamCustomer.getOamArea() != null && StringUtils.isBlank(oamCustomer.getOamArea().getOamAreaId())){
			oamCustomer.setOamArea(null);
		}
		String oamCustomerId = oamCustomer.getOamCustomerId();
		if(StringUtils.isEmpty(oamCustomerId)){
			commonDAO.save(oamCustomer);
		}else{
			OamCustomer oldOamCustomer = commonDAO.load(OamCustomer.class, oamCustomerId);
			oldOamCustomer.setOamCustomerName(oamCustomer.getOamCustomerName());
			oldOamCustomer.setOamArea(oamCustomer.getOamArea());
			oldOamCustomer.setPostcode(oamCustomer.getPostcode());
			oldOamCustomer.setAddress(oamCustomer.getAddress());
			oldOamCustomer.setProducts(oamCustomer.getProducts());
			oldOamCustomer.setLongitude(oamCustomer.getLongitude());
			oldOamCustomer.setLatitude(oamCustomer.getLatitude());
			commonDAO.update(oldOamCustomer);
		}
	}

	public void deleteOamCustomer(String oamCustomerIds){
		String[] oamCustomerIdArray = oamCustomerIds.split(",");
		for(String oamCustomerId : oamCustomerIdArray){
			OamCustomer oldOamCustomer = commonDAO.load(OamCustomer.class, oamCustomerId);
			oldOamCustomer.setIsDelete("Y");
			commonDAO.update(oldOamCustomer);
		}
	}
	
	public void exportOamCustomers(OamCustomer oamCustomer, HttpServletResponse response) throws Exception{
		String hql = "from OamCustomer where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(oamCustomer.getOamCustomerName())){
			hql += " and oamCustomerName like :oamCustomerName";
			params.put("oamCustomerName", "%"+oamCustomer.getOamCustomerName()+"%");
		}
		if(oamCustomer.getOamArea() != null && StringUtils.isNotBlank(oamCustomer.getOamArea().getOamAreaId())){
			hql += " and oamArea.oamAreaId = :oamAreaId";
			params.put("oamAreaId", oamCustomer.getOamArea().getOamAreaId());
		}
		List<OamCustomer> oamCustomers = commonDAO.queryList(hql, params);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("客户信息");
		sheet.setDefaultColumnWidth(20);
		HSSFRow row = sheet.createRow(0);
		String[] headers = {"客户名称","所属省市","邮编","地址","主营业务","经度","纬度"};
		PoiExporter.fillHeader(row, headers);
		int i = 1;
		HSSFCell cell;
		for(OamCustomer oamCustomerData : oamCustomers){
			row = sheet.createRow(i);
			cell = row.createCell(0);
			if(oamCustomerData.getOamCustomerName() != null){
				cell.setCellValue(oamCustomerData.getOamCustomerName());
			}
			cell = row.createCell(1);
			if(oamCustomerData.getOamArea() != null){
				cell.setCellValue(oamCustomerData.getOamArea().getOamAreaName());
			}
			cell = row.createCell(2);
			if(oamCustomerData.getPostcode() != null){
				cell.setCellValue(oamCustomerData.getPostcode());
			}
			cell = row.createCell(3);
			if(oamCustomerData.getAddress() != null){
				cell.setCellValue(oamCustomerData.getAddress());
			}
			cell = row.createCell(4);
			if(oamCustomerData.getProducts() != null){
				cell.setCellValue(oamCustomerData.getProducts());
			}
			cell = row.createCell(5);
			if(oamCustomerData.getLongitude() != null){
				cell.setCellValue(oamCustomerData.getLongitude());
			}
			cell = row.createCell(6);
			if(oamCustomerData.getLatitude() != null){
				cell.setCellValue(oamCustomerData.getLatitude());
			}
			i++;
		}
		response.setHeader("Content-Disposition", "attachment; filename=" 
				+ java.net.URLEncoder.encode("客户信息.xls", "UTF-8"));
		OutputStream os = response.getOutputStream();
		workbook.write(os);
		os.close();
	}
	
	public Object getCustomers(String oamAreaId) {
		List<OamCustomer> result = new ArrayList<OamCustomer>();
		addChildren(oamAreaId, result);
		return result;
	}
	
	private void addChildren(String parentId,List<OamCustomer> customers){
		String hql = "from OamArea where isDelete is null and parentId = ?";
		List<OamArea> areas = commonDAO.queryListByVariableParam(hql, parentId);
		if(areas.size() == 0){
			hql = "from Customer where oamAreaId = ?";
			List<OamCustomer> result = commonDAO.queryListByVariableParam(hql, parentId);
			for(OamCustomer customer : result){
				customers.add(customer);
			}
		}else{
			for(OamArea area : areas){
				addChildren(area.getOamAreaId(), customers);
			}
		}
	}
}