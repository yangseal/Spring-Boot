package com.cnten.bdlocation.pointtype.service;

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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.dao.PageBean;
import com.cnten.platform.export.PoiExporter;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.util.StringUtil;
import com.cnten.po.PointType;

@Service
public class PointTypeService {

	@Autowired
	CommonDAO commonDAO;
	
	public Page getPointTypesPage(PointType pointType, Integer pageIndex, Integer pageSize) {
		String hql = "from PointType pt where pt.isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(pointType.getCompanyId())){
			hql += " and exists(from PointTypeAuthorize pta where pta.isDelete is null and pta.affiliationPointType.pointTypeId=pt.pointTypeId and pta.affiliationCompany.companyId=:companyId)";
			params.put("companyId", pointType.getCompanyId());
		}else if(!ContextUtil.isSystemUser()){
			hql += " and exists(from PointTypeAuthorize pta where pta.isDelete is null and pta.affiliationPointType.pointTypeId=pt.pointTypeId and pta.affiliationCompany.companyId=:companyId)";
			String companyId = ContextUtil.getCurrentUser().getCompany().getCompanyId();
			params.put("companyId", companyId);
		}
		if(!StringUtils.isEmpty(pointType.getPointTypeCode())){
			hql += " and pointTypeCode like :pointTypeCode";
			params.put("pointTypeCode", "%"+pointType.getPointTypeCode()+"%");
		}
		if(!StringUtils.isEmpty(pointType.getPointTypeName())){
			hql += " and pointTypeName like :pointTypeName";
			params.put("pointTypeName", "%"+pointType.getPointTypeName()+"%");
		}
		hql += " order by pointTypeCode";
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}

	
	public PointType getPointType(String pointTypeId) {
		return commonDAO.get(PointType.class, pointTypeId);
	}

	public void savePointType(PointType pointType) {
		String pointTypeId = pointType.getPointTypeId();
		if(StringUtils.isEmpty(pointTypeId)){
			commonDAO.save(pointType);
		}else{
			PointType oldPointType = commonDAO.load(PointType.class, pointTypeId);
			oldPointType.setPointTypeCode(pointType.getPointTypeCode());
			oldPointType.setPointTypeName(pointType.getPointTypeName());
			oldPointType.setCreateDate(pointType.getCreateDate());
			oldPointType.setTypeState(pointType.getTypeState());
			oldPointType.setTypeDesc(pointType.getTypeDesc());
			oldPointType.setDynamicField(pointType.getDynamicField());
			commonDAO.update(oldPointType);
		}
	}

	public void deletePointType(String pointTypeIds){
		String[] pointTypeIdArray = pointTypeIds.split(",");
		for(String pointTypeId : pointTypeIdArray){
			PointType oldPointType = commonDAO.load(PointType.class, pointTypeId);
			oldPointType.setIsDelete("Y");
			commonDAO.update(oldPointType);
		}
	}
	
	public void exportPointTypes(PointType pointType, HttpServletResponse response) throws Exception{
		String hql = "from PointType pt where pt.isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(pointType.getCompanyId())){
			hql += " and exists(from PointTypeAuthorize pta where pta.isDelete is null and pta.affiliationPointType.pointTypeId=pt.pointTypeId and pta.affiliationCompany.companyId=:companyId)";
			params.put("companyId", pointType.getCompanyId());
		}else if(!ContextUtil.isSystemUser()){
			hql += " and exists(from PointTypeAuthorize pta where pta.isDelete is null and pta.affiliationPointType.pointTypeId=pt.pointTypeId and pta.affiliationCompany.companyId=:companyId)";
			String companyId = ContextUtil.getCurrentUser().getCompany().getCompanyId();
			params.put("companyId", companyId);
		}
		if(!StringUtils.isEmpty(pointType.getPointTypeCode())){
			hql += " and pointTypeCode like :pointTypeCode";
			params.put("pointTypeCode", "%"+pointType.getPointTypeCode()+"%");
		}
		if(!StringUtils.isEmpty(pointType.getPointTypeName())){
			hql += " and pointTypeName like :pointTypeName";
			params.put("pointTypeName", "%"+pointType.getPointTypeName()+"%");
		}
		List<PointType> pointTypes = commonDAO.queryList(hql, params);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("点类型信息");
		sheet.setDefaultColumnWidth(20);
		HSSFRow row = sheet.createRow(0);
		String[] headers = {"编码","名称","创建日期","是否可用","描述","动态字段"};
		PoiExporter.fillHeader(row, headers);
		int i = 1;
		HSSFCell cell;
		for(PointType pointTypeData : pointTypes){
			row = sheet.createRow(i);
			cell = row.createCell(0);
			if(pointTypeData.getPointTypeCode() != null){
				cell.setCellValue(pointTypeData.getPointTypeCode());
			}
			cell = row.createCell(1);
			if(pointTypeData.getPointTypeName() != null){
				cell.setCellValue(pointTypeData.getPointTypeName());
			}
			cell = row.createCell(2);
			if(pointTypeData.getCreateDate() != null){
				cell.setCellValue(StringUtil.formatDateTime(pointTypeData.getCreateDate()));
			}
			cell = row.createCell(3);
			if(pointTypeData.getTypeState() != null){
				cell.setCellValue(pointTypeData.getTypeStateName());
			}
			cell = row.createCell(4);
			if(pointTypeData.getTypeDesc() != null){
				cell.setCellValue(pointTypeData.getTypeDesc());
			}
			cell = row.createCell(5);
			if(pointTypeData.getDynamicField() != null) {
				cell.setCellValue(pointTypeData.getDynamicField());
			}
			i++;
		}
		response.setHeader("Content-Disposition", "attachment; filename=" 
				+ java.net.URLEncoder.encode("点类型信息.xls", "UTF-8"));
		OutputStream os = response.getOutputStream();
		workbook.write(os);
		os.close();
	}
	
	public List<PointType> getPointTypes() {
		String hql = "from PointType where isDelete is null order by pointTypeCode";
		HashMap<String,Object> params = new HashMap<String,Object>();
		List<PointType> pointTypes = commonDAO.queryList(hql, params);
		return pointTypes;
	}
	
	/**
	 * 根据企业过滤点类型 
	 * @author lanj
	 * @param companyId
	 * @return
	 */
	public List<PointType> getPointTypesByCompanyId(String companyId) {
		String hql = "select pta.affiliationPointType from PointTypeAuthorize pta  where pta.isDelete is null and pta.affiliationPointType.isDelete is null";
		HashMap<String, Object> params = new HashMap<String, Object>();
		if (companyId != null) {
			hql += " and pta.affiliationCompany.companyId = :companyId";
			params.put("companyId", companyId);
		}

		List<PointType> pointTypes = commonDAO.queryList(hql, params);
		return pointTypes;
	}
	
	public Page queryDynamicFields(String pointTypeId, Integer pageIndex, Integer pageSize) {
		PageBean pageBean = new PageBean(pageIndex, pageSize);
		Page page = new Page(new ArrayList<Object>(), pageBean);
		if(StringUtils.isEmpty(pointTypeId)) {
			return page;
		}
		String hql = "select dynamicField from PointType pt where pt.isDelete is null and pt.pointTypeId = ?";
		String dynamicFields = commonDAO.getByVariableParam(hql, pointTypeId);
		if(StringUtils.isEmpty(dynamicFields)) {
			return page;
		}
		JSONArray array = JSONArray.parseArray(dynamicFields);
		int allCount = array.size();
		pageBean.setCount(allCount);
		if (pageBean.getCount() == 0) {
			return new Page(new ArrayList<Object>(), pageBean);
		}
		int pages = pageBean.getPages();
		if (pages * pageBean.getPageSize() < pageBean.getCount()) {
			pages = pages + 1;
		}
		if (pageBean.getPageIndex() > pages) {
			pageBean.setPageIndex(pages);
		}
		
		List<JSONObject> lstResult = new ArrayList<JSONObject>();
		int start = (pageBean.getPageIndex()-1) * pageBean.getPageSize();
	    int end = pageBean.getPageIndex() * pageBean.getPageSize();
	    if(end >= allCount){
	     end = allCount;
	    }
	    for(int i = start; i < end; i ++){
	    	lstResult.add(array.getJSONObject(i));
	    }
	    page.setPageBean(pageBean);
	    page.setResult(lstResult);
		return page;
	}
	
	public JSONObject getDynamicField(String pointTypeId, String dataCode) {
		String hql = "select dynamicField from PointType pt where pt.isDelete is null and pt.pointTypeId = ?";
		String dynamicFields = commonDAO.getByVariableParam(hql, pointTypeId);
		JSONArray array = JSONArray.parseArray(dynamicFields);
		if(null == array) {
			return null;
		}
		for (int i=0; i<array.size(); i++) {
			if(array.getJSONObject(i).getString("dataCode").equals(dataCode)) {
				return array.getJSONObject(i);
			}
		}
		return null;
	}
	
	public String saveDynamicField(String dynamicField, String pointTypeId) throws Exception {
		PointType oldPointType = commonDAO.load(PointType.class, pointTypeId);
		String dynamicFieldArray = oldPointType.getDynamicField();
		JSONArray array = JSONArray.parseArray(dynamicFieldArray);
		JSONObject obj = JSONObject.parseObject(dynamicField);
		if(null != array) {
			for (int i=0; i<array.size(); i++) {
				if(array.getJSONObject(i).get("dataCode").equals(obj.get("dataCode"))) {
					throw new Exception("已存在字段编码为"+obj.get("dataCode")+"的字段");
				}
			}
			array.add(obj);
			dynamicFieldArray = array.toJSONString();
		} else {
			dynamicFieldArray = "["+obj.toJSONString()+"]";
		}
		oldPointType.setDynamicField(dynamicFieldArray);
		commonDAO.update(oldPointType);
		return dynamicFieldArray;
	}
	
	public String saveEditDynamicField(String dynamicField, String pointTypeId) throws Exception {
		PointType oldPointType = commonDAO.load(PointType.class, pointTypeId);
		String dynamicFieldArray = oldPointType.getDynamicField();
		JSONArray array = JSONArray.parseArray(dynamicFieldArray);
		JSONObject obj = JSONObject.parseObject(dynamicField);
		if(null != array) {
			for (int i=0; i<array.size(); i++) {
				if(array.getJSONObject(i).get("dataCode").equals(obj.get("dataCode"))) {
					array.set(i, obj);
					break;
				}
			}
			dynamicFieldArray = array.toJSONString();
		} else {
			throw new Exception("不存在字段编码为"+obj.get("dataCode")+"的字段");
		}
		oldPointType.setDynamicField(dynamicFieldArray);
		commonDAO.update(oldPointType);
		return dynamicFieldArray;
	}
	
	public String deleteDynamicField(String dataCodes, String pointTypeId) {
		PointType oldPointType = commonDAO.load(PointType.class, pointTypeId);
		String dynamicFields = oldPointType.getDynamicField();
		JSONArray array = JSONArray.parseArray(dynamicFields);
		
		String[] dataCodeArray = dataCodes.split(",");
		for (int i=0; i<array.size(); i++) {
			for(String dataCode : dataCodeArray){
				if(array.getJSONObject(i).containsValue(dataCode)) {
					array.remove(i);
				}
			}
		}
		String newDynamicField = "";
		if(array.size() != 0) {
			newDynamicField = array.toJSONString();
		}
		oldPointType.setDynamicField(newDynamicField);
		commonDAO.update(oldPointType);
		return newDynamicField;
	}
}