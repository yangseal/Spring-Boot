package com.cnten.bdlocation.oamaccount.service;

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

import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.export.PoiExporter;
import com.cnten.po.OamAccount;
import com.cnten.po.OamCustomer;

@Service
public class OamAccountService {

	@Autowired
	CommonDAO commonDAO;
	
	public Page getOamAccountsPage(OamAccount oamAccount, Integer pageIndex, Integer pageSize) {
		String hql = "from OamAccount where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(oamAccount.getOamAccountName())){
			hql += " and oamAccountName like :oamAccountName";
			params.put("oamAccountName", "%"+oamAccount.getOamAccountName()+"%");
		}
		if(oamAccount.getOamCustomer() != null && StringUtils.isNotBlank(oamAccount.getOamCustomer().getOamCustomerId())){
			hql += " and oamCustomer.oamCustomerId = :oamCustomerId";
			params.put("oamCustomerId", oamAccount.getOamCustomer().getOamCustomerId());
		}
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}

	public OamAccount getOamAccount(String oamAccountId) {
		return commonDAO.get(OamAccount.class, oamAccountId);
	}

	public void saveOamAccount(OamAccount oamAccount) {
		if(oamAccount.getOamCustomer() != null && StringUtils.isBlank(oamAccount.getOamCustomer().getOamCustomerId())){
			oamAccount.setOamCustomer(null);
		}
		String oamAccountId = oamAccount.getOamAccountId();
		if(StringUtils.isEmpty(oamAccountId)){
			commonDAO.save(oamAccount);
		}else{
			OamAccount oldOamAccount = commonDAO.load(OamAccount.class, oamAccountId);
			oldOamAccount.setOamAccountName(oamAccount.getOamAccountName());
			oldOamAccount.setPwd(oamAccount.getPwd());
			oldOamAccount.setOamCustomer(oamAccount.getOamCustomer());
			oldOamAccount.setLoginNum(oamAccount.getLoginNum());
			oldOamAccount.setAccountStatus(oamAccount.getAccountStatus());
			commonDAO.update(oldOamAccount);
		}
	}

	public void deleteOamAccount(String oamAccountIds){
		String[] oamAccountIdArray = oamAccountIds.split(",");
		for(String oamAccountId : oamAccountIdArray){
			OamAccount oldOamAccount = commonDAO.load(OamAccount.class, oamAccountId);
			oldOamAccount.setIsDelete("Y");
			commonDAO.update(oldOamAccount);
		}
	}
	
	public void exportOamAccounts(OamAccount oamAccount, HttpServletResponse response) throws Exception{
		String hql = "from OamAccount where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(oamAccount.getOamAccountName())){
			hql += " and oamAccountName like :oamAccountName";
			params.put("oamAccountName", "%"+oamAccount.getOamAccountName()+"%");
		}
		if(oamAccount.getOamCustomer() != null && StringUtils.isNotBlank(oamAccount.getOamCustomer().getOamCustomerId())){
			hql += " and oamCustomer.oamCustomerId = :oamCustomerId";
			params.put("oamCustomerId", oamAccount.getOamCustomer().getOamCustomerId());
		}
		List<OamAccount> oamAccounts = commonDAO.queryList(hql, params);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("账号信息");
		sheet.setDefaultColumnWidth(20);
		HSSFRow row = sheet.createRow(0);
		String[] headers = {"账号名称","账号密码","所属客户","登录次数","是否在线"};
		PoiExporter.fillHeader(row, headers);
		int i = 1;
		HSSFCell cell;
		for(OamAccount oamAccountData : oamAccounts){
			row = sheet.createRow(i);
			cell = row.createCell(0);
			if(oamAccountData.getOamAccountName() != null){
				cell.setCellValue(oamAccountData.getOamAccountName());
			}
			cell = row.createCell(1);
			if(oamAccountData.getPwd() != null){
				cell.setCellValue(oamAccountData.getPwd());
			}
			cell = row.createCell(2);
			if(oamAccountData.getOamCustomer() != null){
				cell.setCellValue(oamAccountData.getOamCustomer().getOamCustomerName());
			}
			cell = row.createCell(3);
			if(oamAccountData.getLoginNum() != null){
				cell.setCellValue(oamAccountData.getLoginNum());
			}
			cell = row.createCell(4);
			if(oamAccountData.getAccountStatus() != null){
				cell.setCellValue(oamAccountData.getAccountStatusName());
			}
			i++;
		}
		response.setHeader("Content-Disposition", "attachment; filename=" 
				+ java.net.URLEncoder.encode("账号信息.xls", "UTF-8"));
		OutputStream os = response.getOutputStream();
		workbook.write(os);
		os.close();
	}
	
	public List<OamAccount> getOamAccounts(String oamAreaId) {
		if(StringUtils.isEmpty(oamAreaId))
			oamAreaId = "0";
		String hql = "from OamCustomer where isDelete is null and oamArea.oamAreaId=?";
		List<OamCustomer> customers = commonDAO.queryListByVariableParam(hql, oamAreaId);
		
		List<OamAccount> oamAccounts = new ArrayList<OamAccount>();
		hql = "from OamAccount where isDelete is null and oamCustomer=?";
		for (OamCustomer oamCustomer : customers) {
			List<OamAccount> list = commonDAO.queryListByVariableParam(hql,oamCustomer);
			for (OamAccount oamAccount : list) {
				oamAccounts.add(oamAccount);
			}
		}
		return oamAccounts;
	}
}