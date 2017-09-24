package com.cnten.bdlocation.corsaccount.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.bdlocation.constants.CorsAccountConsts;
import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.util.ContextUtil;
import com.cnten.po.Company;
import com.cnten.po.CorsAccount;
import com.cnten.po.CorsApply;
import com.cnten.po.CorsRepayTemp;
import com.cnten.po.OamArea;
import com.cnten.po.User;

@Service
public class CorsAccountService {

	@Autowired
	CommonDAO commonDAO;
	
	public Page getCorsAccountsPage(CorsAccount corsAccount, Integer pageIndex, Integer pageSize) {
		String hql = "from CorsAccount where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(corsAccount.getCompany() != null && StringUtils.isNotBlank(corsAccount.getCompany().getCompanyId())){
			hql += " and company.companyId = :companyId";
			params.put("companyId", corsAccount.getCompany().getCompanyId());
		}
		if(StringUtils.isNotBlank(corsAccount.getCorsAccountCode())){
			hql += " and corsAccountCode like :corsAccountCode";
			params.put("corsAccountCode", "%"+corsAccount.getCorsAccountCode()+"%");
		}
		if(corsAccount.getOamArea() != null && StringUtils.isNotBlank(corsAccount.getOamArea().getOamAreaId())){
			hql += " and oamArea.oamAreaId = :oamAreaId";
			params.put("oamAreaId", corsAccount.getOamArea().getOamAreaId());
		}
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}

	public CorsAccount getCorsAccount(String corsAccountId) {
		return commonDAO.get(CorsAccount.class, corsAccountId);
	}

	public String saveCorsAccount(CorsAccount corsAccount) {
		return null;
//		if(corsAccount.getCompany() != null && StringUtils.isBlank(corsAccount.getCompany().getCompanyId())){
//			corsAccount.setCompany(null);
//		}
//		if(corsAccount.getCorsApply() != null && StringUtils.isBlank(corsAccount.getCorsApply().getCorsApplyId())){
//			corsAccount.setCorsApply(null);
//		}
//		if(corsAccount.getOamArea() != null && StringUtils.isBlank(corsAccount.getOamArea().getOamAreaId())){
//			corsAccount.setOamArea(null);
//		}
//		String corsAccountId = corsAccount.getCorsAccountId();
//		if(StringUtils.isEmpty(corsAccountId)){
//			commonDAO.save(corsAccount);
//			return corsAccountId;
//		}else{
//			CorsAccount oldCorsAccount = commonDAO.load(CorsAccount.class, corsAccountId);
//			oldCorsAccount.setCompany(corsAccount.getCompany());
//			oldCorsAccount.setCorsApply(corsAccount.getCorsApply());
//			oldCorsAccount.setCorsAccountCode(corsAccount.getCorsAccountCode());
//			oldCorsAccount.setCorsAccountPwd(corsAccount.getCorsAccountPwd());
//			oldCorsAccount.setCorsAccountType(corsAccount.getCorsAccountType());
//			oldCorsAccount.setOamArea(corsAccount.getOamArea());
//			oldCorsAccount.setBdDevice(corsAccount.getBdDevice());
//			oldCorsAccount.setBdDeviceSn(corsAccount.getBdDeviceSn());
//			oldCorsAccount.setBdDeviceAccuracy(corsAccount.getBdDeviceAccuracy());
//			oldCorsAccount.setEffectiveDate(corsAccount.getEffectiveDate());
//			oldCorsAccount.setExprieDate(corsAccount.getExprieDate());
//			oldCorsAccount.setRemark(corsAccount.getRemark());
//			commonDAO.update(oldCorsAccount);
//			return null;
//		}
	}

	public void deleteCorsAccount(String corsAccountIds){
		String[] corsAccountIdArray = corsAccountIds.split(",");
		for(String corsAccountId : corsAccountIdArray){
			CorsAccount oldCorsAccount = commonDAO.load(CorsAccount.class, corsAccountId);
			oldCorsAccount.setIsDelete("Y");
			commonDAO.update(oldCorsAccount);
		}
	}
	
	public void exportCorsAccounts(CorsAccount corsAccount, HttpServletResponse response) throws Exception{
//		String hql = "from CorsAccount where isDelete is null";
//		HashMap<String,Object> params = new HashMap<String,Object>();
//		if(corsAccount.getCompany() != null && StringUtils.isNotBlank(corsAccount.getCompany().getCompanyId())){
//			hql += " and company.companyId = :companyId";
//			params.put("companyId", corsAccount.getCompany().getCompanyId());
//		}
//		if(StringUtils.isNotBlank(corsAccount.getCorsAccountCode())){
//			hql += " and corsAccountCode like :corsAccountCode";
//			params.put("corsAccountCode", "%"+corsAccount.getCorsAccountCode()+"%");
//		}
//		if(corsAccount.getOamArea() != null && StringUtils.isNotBlank(corsAccount.getOamArea().getOamAreaId())){
//			hql += " and oamArea.oamAreaId = :oamAreaId";
//			params.put("oamAreaId", corsAccount.getOamArea().getOamAreaId());
//		}
//		List<CorsAccount> corsAccounts = commonDAO.queryList(hql, params);
//		HSSFWorkbook workbook = new HSSFWorkbook();
//		HSSFSheet sheet = workbook.createSheet("CORS账号信息");
//		sheet.setDefaultColumnWidth(20);
//		HSSFRow row = sheet.createRow(0);
//		String[] headers = {"所属企业","申请批次","账号编码","CORS密码","账号类型","应用区域","定位设备型号","定位设备SN号","定位设备入网精度","起始有效期","结束有效期","备注"};
//		PoiExporter.fillHeader(row, headers);
//		int i = 1;
//		HSSFCell cell;
//		for(CorsAccount corsAccountData : corsAccounts){
//			row = sheet.createRow(i);
//			cell = row.createCell(0);
//			if(corsAccountData.getCompany() != null){
//				cell.setCellValue(corsAccountData.getCompany().getCompanyName());
//			}
//			cell = row.createCell(1);
//			if(corsAccountData.getCorsApply() != null){
//				cell.setCellValue(corsAccountData.getCorsApply().getCorsApplyId());
//			}
//			cell = row.createCell(2);
//			if(corsAccountData.getCorsAccountCode() != null){
//				cell.setCellValue(corsAccountData.getCorsAccountCode());
//			}
//			cell = row.createCell(3);
//			if(corsAccountData.getCorsAccountPwd() != null){
//				cell.setCellValue(corsAccountData.getCorsAccountPwd());
//			}
//			cell = row.createCell(4);
//			if(corsAccountData.getCorsAccountType() != null){
//				cell.setCellValue(corsAccountData.getCorsAccountType());
//			}
//			cell = row.createCell(5);
//			if(corsAccountData.getOamArea() != null){
//				cell.setCellValue(corsAccountData.getOamArea().getOamAreaName());
//			}
//			cell = row.createCell(6);
//			if(corsAccountData.getBdDevice() != null){
//				cell.setCellValue(corsAccountData.getBdDevice());
//			}
//			cell = row.createCell(7);
//			if(corsAccountData.getBdDeviceSn() != null){
//				cell.setCellValue(corsAccountData.getBdDeviceSn());
//			}
//			cell = row.createCell(8);
//			if(corsAccountData.getBdDeviceAccuracy() != null){
//				cell.setCellValue(corsAccountData.getBdDeviceAccuracy());
//			}
//			cell = row.createCell(9);
//			if(corsAccountData.getEffectiveDate() != null){
//				cell.setCellValue(StringUtil.formatDateTime(corsAccountData.getEffectiveDate()));
//			}
//			cell = row.createCell(10);
//			if(corsAccountData.getExprieDate() != null){
//				cell.setCellValue(StringUtil.formatDateTime(corsAccountData.getExprieDate()));
//			}
//			cell = row.createCell(11);
//			if(corsAccountData.getRemark() != null){
//				cell.setCellValue(corsAccountData.getRemark());
//			}
//			i++;
//		}
//		response.setHeader("Content-Disposition", "attachment; filename=" 
//				+ java.net.URLEncoder.encode("CORS账号信息.xls", "UTF-8"));
//		OutputStream os = response.getOutputStream();
//		workbook.write(os);
//		os.close();
	}
	
	public void exportCorsAccountsByApplyId(HSSFSheet sheetCorsAccount,CorsApply corsApply) {
		if(null == corsApply || null == corsApply.getCorsApplyId() || "".equals(corsApply.getCorsApplyId())) {
			return;
		}
		String hql = "from CorsAccount where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		hql += " and corsApply.corsApplyId=:corsApplyId";
		params.put("corsApplyId", corsApply.getCorsApplyId());
		List<CorsAccount> corsAccounts = commonDAO.queryList(hql, params);
		HSSFRow row = sheetCorsAccount.getRow(1);
		HSSFCell cell = row.getCell(0);
		cell.setCellValue(cell.getStringCellValue().substring(0,5)+(null==corsApply.getOrderNo()?"":corsApply.getOrderNo()));
		HSSFCellStyle cellStyle = sheetCorsAccount.getWorkbook().createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框    
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框    
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框    
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
		HSSFCellStyle cellStyleDate = sheetCorsAccount.getWorkbook().createCellStyle();
		cellStyleDate.cloneStyleFrom(cellStyle);
		HSSFDataFormat format= sheetCorsAccount.getWorkbook().createDataFormat();  
		cellStyleDate.setDataFormat(format.getFormat("yyyy/m/d"));
		int i = 3;
		int index = 1;
		int number = 1;
		//将模板底部事例及说明下移
		int shiftIndex = 17;
		for(CorsAccount corsAccountData : corsAccounts){
			if(number > 50000) { //超过50000行时进行换页
				int count = sheetCorsAccount.getWorkbook().getNumberOfSheets();
				HSSFSheet sheet = null;
				if(null == (sheet = sheetCorsAccount.getWorkbook().getSheetAt(count-1))) {
					sheetCorsAccount = sheetCorsAccount.getWorkbook().createSheet("账户详单"+count);
				} else {
					sheetCorsAccount = sheet;
					sheetCorsAccount.getWorkbook().setSheetName(count-1, "账户详单"+(count-1));
				}
				
				number = 1;
				i = 0;
			}
			
			if ((i==shiftIndex) && (null != (row = sheetCorsAccount.getRow(i)))) {
				sheetCorsAccount.shiftRows(i, i+10, 10);
				shiftIndex += 10;
			}
			
			row = sheetCorsAccount.createRow(i++);
			exportOneData(sheetCorsAccount, corsAccountData, row, cell
						, cellStyle, cellStyleDate, index);
			number++;
			index++;
		}
	}
	
	/**
	 * 导出一条账号数据到sheet中一行
	 * @param sheetCorsAccount
	 * @param corsAccountData
	 * @param row
	 * @param cell
	 * @param cellStyle
	 * @param cellStyleDate
	 * @param i
	 * @param index
	 */
	private void exportOneData(HSSFSheet sheetCorsAccount,CorsAccount corsAccountData,HSSFRow row
			,HSSFCell cell,HSSFCellStyle cellStyle,HSSFCellStyle cellStyleDate,int index) {
		if(null == sheetCorsAccount) {
			return;
		}
		cell = row.createCell(0);
		cell.setCellValue(index);
		cell.setCellStyle(cellStyle);
		cell = row.createCell(1);
		cell.setCellStyle(cellStyle);
		if(null != corsAccountData.getCorsAccountCode()) {
			cell.setCellValue(corsAccountData.getCorsAccountCode());
		}
		cell = row.createCell(2);
		cell.setCellStyle(cellStyle);
		if(null != corsAccountData.getCorsAccountPwd()) {
			cell.setCellValue(corsAccountData.getCorsAccountPwd());
			cell.setCellStyle(cellStyle);
		}
		cell = row.createCell(3);
		cell.setCellStyle(cellStyle);
		if(null != corsAccountData.getOamArea() && null != corsAccountData.getOamArea().getOamAreaName()) {
			cell.setCellValue(corsAccountData.getOamArea().getOamAreaName());
			cell.setCellStyle(cellStyle);
		}
		cell = row.createCell(4);
		cell.setCellStyle(cellStyle);
		if(null != corsAccountData.getBdDevice()) {
			cell.setCellValue(corsAccountData.getBdDevice());
			cell.setCellStyle(cellStyle);
		}
		cell = row.createCell(5);
		cell.setCellStyle(cellStyle);
		if(null != corsAccountData.getBdDeviceSn()) {
			cell.setCellValue(corsAccountData.getBdDeviceSn());
			cell.setCellStyle(cellStyle);
		}
		cell = row.createCell(6);
		cell.setCellStyle(cellStyle);
		if(null != corsAccountData.getBdDeviceAccuracy()) {
			cell.setCellValue(corsAccountData.getBdDeviceAccuracy());
			cell.setCellStyle(cellStyle);
		}
		cell = row.createCell(7);
		cell.setCellStyle(cellStyle);
		if(null != corsAccountData.getCorsAccountType()) {
			cell.setCellValue(corsAccountData.getCorsAccountType());
			cell.setCellStyle(cellStyle);
		}
		cell = row.createCell(8);
		cell.setCellStyle(cellStyle);
		if(null != corsAccountData.getEffectiveDate()) {
			cell.setCellValue(corsAccountData.getEffectiveDate());
			cell.setCellStyle(cellStyleDate);
		}
		cell = row.createCell(9);
		cell.setCellStyle(cellStyle);
		if(null != corsAccountData.getExprieDate()) {
			cell.setCellValue(corsAccountData.getExprieDate());
			cell.setCellStyle(cellStyleDate);
		}
		cell = row.createCell(10);
		cell.setCellStyle(cellStyle);
		if(null != corsAccountData.getRemark()) {
			cell.setCellValue(corsAccountData.getRemark());
		}
	}
	
	//根据所属分组查看账号信息
	public Page getCorsAccountByGroupId(String corsGroupId){
		String hql = "from CorsAccount as a where a.corsCompanyGroup.companyGroupId=:companyGroupId";
		HashMap<String,Object> params = new HashMap<String, Object>();
		params.put("companyGroupId", corsGroupId);
		return commonDAO.getPage(hql, 1, 10000, params);
	}
	
	//划分账号列表展示（该分组下的账号和没有分组的账号）
	public Page getCorsAccountsNotGroup(Company company){
		String hql = "from CorsAccount a where a.corsCompanyGroup is null and a.company = :company ";
		HashMap<String,Object> params = new HashMap<String, Object>();
		params.put("company", company);
		return commonDAO.getPage(hql, 1, 10000, params);
	}
	
	//划分分组账号
	public void saveDivide(String corsAccountIds,String companyGroupId){
		String[] corsIdArr = corsAccountIds.split(",");
		for (String corsAccountId : corsIdArr) {
			String hql = "update CorsAccount set corsCompanyGroup.companyGroupId = :companyGroupId where corsAccountId = :corsAccountId";
			HashMap<String,Object> params = new HashMap<String, Object>();
			params.put("companyGroupId", companyGroupId);
			params.put("corsAccountId", corsAccountId);
			commonDAO.updateByQuery(hql, params);
		}
	}
	
	//移除某分组下账号
	public void updateAccountGroup(String corsAccountId){
		String hql = "update CorsAccount set corsCompanyGroup.companyGroupId = :companyGroup where corsAccountId = :corsAccountId";
		HashMap<String,Object> params = new HashMap<String, Object>();
		params.put("companyGroup", null);
		params.put("corsAccountId", corsAccountId);
		commonDAO.updateByQuery(hql, params);
	}
	
	//续费清单
	public CorsRepayTemp showRepayList(){
		User user  = ContextUtil.getCurrentUser();
		Company company = user.getCompany();
		String hql = "from CorsAccount a where a.corsAccountStage = :corsAccountStage and a.company = :company";
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("corsAccountStage", CorsAccountConsts.ACCOUNT_STAGE_REPAY_REQUEST);
		params.put("company", company);
		CorsRepayTemp corsRepayTemp = commonDAO.get(hql, params);
		return corsRepayTemp;
	}
	
	public CorsAccount corsLogin(String corsAccountCode, String password){
		CorsAccount corsAccount = null;
		String hql = "from CorsAccount where isDelete is null and corsAccountCode= ? "
				+ " and corsAccountPwd = ?";
		corsAccount = commonDAO.getByVariableParam(hql, corsAccountCode,password);
		return corsAccount;
	}
	public Page getCorsAllAccountsPage(CorsAccount corsAccount, Integer pageIndex, Integer pageSize) {
		String hql = "from CorsAccount where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(corsAccount.getCompany() != null && StringUtils.isNotBlank(corsAccount.getCompany().getCompanyId())){
			hql += " and company.companyId = :companyId";
			params.put("companyId", corsAccount.getCompany().getCompanyId());
		}
		if (corsAccount.getEffectiveDate()!= null) {
			hql += " and effective_date >=:effectiveDate";
			params.put("effectiveDate", corsAccount.getEffectiveDate());
		}

		if (corsAccount.getExprieDate() != null) {
			hql += " and exprie_date <=:exprieDate";
			params.put("exprieDate", corsAccount.getExprieDate());
		}
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}
	 public void updateCorsAccountUse(String corsAccountId,String corsUse) {
		 String[] corsAccountIdArray = corsAccountId.split(",");
		 for (String corsAccount : corsAccountIdArray) {
			 String hql = "update CorsAccount set corsAccountUse= :corsUse where corsAccountId = :corsAccount";
				HashMap<String,Object> params = new HashMap<String, Object>();
				params.put("corsUse", corsUse);
				params.put("corsAccount", corsAccount);
				commonDAO.updateByQuery(hql, params);
		 }
	}
}