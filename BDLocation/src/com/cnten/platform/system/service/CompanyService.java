package com.cnten.platform.system.service;

import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.cnten.platform.export.PoiExporter;
import com.cnten.bdlocation.constants.CorsAccountConsts;
import com.cnten.platform.util.EncryptUtils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.po.Company;
import com.cnten.po.CorsBusiApprove;

@Service
public class CompanyService {

	@Autowired
	CommonDAO commonDAO;
	
	/*@Autowired
	CorsBusiApprove oldComrsBusiApprove;*/
	
	public Page getCompanysPage(Company company, Integer pageIndex, Integer pageSize) {
		String hql = "from Company where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(company.getCompanyName())){
			hql += " and companyName like :companyName";
			params.put("companyName", "%" + company.getCompanyName() + "%");
		}
		if(StringUtils.isNotBlank(company.getCompanyMaterialState())){
			if(company.getCompanyMaterialState().endsWith("null")){
				hql += " and companyMaterialState is null";
			}else{
			hql += " and companyMaterialState like :companyMaterialState";
			params.put("companyMaterialState",company.getCompanyMaterialState());
			}			
		}
		hql += " order by createDate desc";
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}
	
	public String getCompanyId(Company company) {
		if(company == null) {
			return null;
		}
		String hql = "from Company where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNoneBlank(company.getCompanyCode())){
			hql += " and companyCode = :companyCode";
			params.put("companyCode", company.getCompanyCode());
		}
		Company result = commonDAO.get(hql, params);
		return result == null ? null : result.getCompanyId();
	}
	
	public String checkPassword(Company company) {
		String hql = "from Company where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isEmpty(company.getCompanyCode()) || StringUtils.isEmpty(company.getPassword())) {
			return null;
		} else {
			hql += " and companyCode= :companyCode and password= :password";
			params.put("companyCode", company.getCompanyCode());
			params.put("password", EncryptUtils.encrypt(company.getPassword()));
		}
		
		Company companyResult = commonDAO.get(hql, params);
		if(null != companyResult) {
			return companyResult.getCompanyId();
		}
		return null;
	}
	

	public Company getCompany(String companyId) {
		return commonDAO.get(Company.class, companyId);
	}

	public void saveCompany(Company company) {
		String companyId = company.getCompanyId();
		String password = EncryptUtils.encrypt(company.getPassword());
		if(StringUtils.isEmpty(companyId)){
			company.setPassword(password);
			commonDAO.save(company);
		}else{
			Company oldCompany = commonDAO.load(Company.class, companyId);
			oldCompany.setCompanyName(company.getCompanyName());
			oldCompany.setCompanyCode(company.getCompanyCode());
			if(oldCompany.getPassword()==null || !oldCompany.getPassword().equalsIgnoreCase(company.getPassword())) {
				oldCompany.setPassword(password);
			}
			oldCompany.setAddress(company.getAddress());
			oldCompany.setTel(company.getTel());
			oldCompany.setContacts(company.getContacts());
			oldCompany.setPost(company.getPost());
			oldCompany.setPhone(company.getPhone());
			commonDAO.update(oldCompany);
		}
	}

	// 企业资料提交
	public void saveApprove(Company company) {
		String companyId = company.getCompanyId();
		String userId = company.getUserId();
		Date subTime = new Date();
		//Company oldCompany = commonDAO.load(Company.class, companyId);
		company.setCompanyMaterialState(CorsAccountConsts.ACCOUNT_STATE_EXAMINE_PROCEED);
		commonDAO.update(company);
		CorsBusiApprove oldComrsBusiApprove = new CorsBusiApprove ();
		oldComrsBusiApprove.setOrderBussinkey(companyId);
		oldComrsBusiApprove.setBusiApproveType("material");
		oldComrsBusiApprove.setBusiSubmitUser(userId);
		oldComrsBusiApprove.setApproveState(CorsAccountConsts.ACCOUNT_APPROVE_UNDEAL);  
		oldComrsBusiApprove.setBusiSubmitTime(subTime);
		commonDAO.save(oldComrsBusiApprove);
		
	}

	
	public void deleteCompany(String companyIds){
		String[] companyIdArray = companyIds.split(",");
		for(String companyId : companyIdArray){
			Company oldCompany = commonDAO.load(Company.class, companyId);
			oldCompany.setIsDelete("Y");
			commonDAO.update(oldCompany);
		}
	}
	
	public void exportCompanys(Company company, HttpServletResponse response) throws Exception{
		String hql = "from Company where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		List<Company> companys = commonDAO.queryList(hql, params);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("企业信息");
		sheet.setDefaultColumnWidth(20);
		HSSFRow row = sheet.createRow(0);
		String[] headers = {"企业名称","企业编号","企业密码","企业地址","企业电话","联系人名称","联系人职务","联系人电话"};
		PoiExporter.fillHeader(row, headers);
		int i = 1;
		HSSFCell cell;
		for(Company companyData : companys){
			row = sheet.createRow(i);
			cell = row.createCell(0);
			if(companyData.getCompanyName() != null){
				cell.setCellValue(companyData.getCompanyName());
			}
			cell = row.createCell(1);
			if(companyData.getCompanyCode() != null){
				cell.setCellValue(companyData.getCompanyCode());
			}
			cell = row.createCell(2);
			if(companyData.getPassword() != null){
				cell.setCellValue(companyData.getPassword());
			}
			cell = row.createCell(3);
			if(companyData.getAddress() != null){
				cell.setCellValue(companyData.getAddress());
			}
			cell = row.createCell(4);
			if(companyData.getTel() != null){
				cell.setCellValue(companyData.getTel());
			}
			cell = row.createCell(5);
			if(companyData.getContacts() != null){
				cell.setCellValue(companyData.getContacts());
			}
			cell = row.createCell(6);
			if(companyData.getPost() != null){
				cell.setCellValue(companyData.getPost());
			}
			cell = row.createCell(7);
			if(companyData.getPhone() != null){
				cell.setCellValue(companyData.getPhone());
			}
			i++;
		}
		response.setHeader("Content-Disposition", "attachment; filename=" 
				+ java.net.URLEncoder.encode("企业信息.xls", "UTF-8"));
		OutputStream os = response.getOutputStream();
		workbook.write(os);
		os.close();
	}
	
	public List<Company> getCompanys() {
		String hql = "from Company where isDelete is null order by companyName";
		HashMap<String,Object> params = new HashMap<String,Object>();
		List<Company> companys = commonDAO.queryList(hql, params);
		return companys;
	}
	
}