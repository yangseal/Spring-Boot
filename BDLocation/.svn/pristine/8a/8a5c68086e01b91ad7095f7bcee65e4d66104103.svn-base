package com.cnten.bdlocation.corsapply.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.bdlocation.constants.CorsAccountConsts;
import com.cnten.bdlocation.corsaccount.service.CorsAccountService;
import com.cnten.enums.UserFeature;
import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.util.OrderNoCreateUtil;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.Company;
import com.cnten.po.CorsAccountRepay;
import com.cnten.po.CorsApply;
import com.cnten.po.CorsApplyDetail;
import com.cnten.po.CorsBusiApprove;
import com.cnten.po.User;

@Service
public class CorsApplyService {

	@Autowired
	CommonDAO commonDAO;

	@Autowired
	CorsAccountService corsAccountService;
	
//	public Page getCorsApplysPage(CorsApply corsApply, Integer pageIndex,
//			Integer pageSize) {
//		String hql = "from CorsApply where isDelete is null";
//		HashMap<String, Object> params = new HashMap<String, Object>();
//		if (corsApply.getCompany() != null
//				&& StringUtils
//						.isNotBlank(corsApply.getCompany().getCompanyId())) {
//			hql += " and company.companyId = :companyId";
//			params.put("companyId", corsApply.getCompany().getCompanyId());
//		} else if (!ContextUtil.isSystemUser()
//				&& !"CNTEN".equalsIgnoreCase(ContextUtil.getCurrentUser()
//						.getCompany().getCompanyCode())) {
//			hql += " and company.companyId = :companyId";
//			String companyId = ContextUtil.getCurrentUser().getCompany()
//					.getCompanyId();
//			params.put("companyId", companyId);
//		}
//		if (corsApply.getApplyStatusName() != null
//				&& !"".equals(corsApply.getApplyStatusName())) {
//			hql += " and applyStatus = :applyStatus";
//			params.put("applyStatus", corsApply.getApplyStatusName());
//		}
//		if (corsApply.getBdDeviceAccuracy() != null
//				&& !"".equals(corsApply.getBdDeviceAccuracy())) {
//			hql += " and bdDeviceAccuracy = :bdDeviceAccuracy";
//			params.put("bdDeviceAccuracy", corsApply.getBdDeviceAccuracy());
//		}	
//		hql += " order by applyDate desc";
//		return commonDAO.getPage(hql, pageIndex, pageSize, params);
//	}

//	public Page getApplysPage(CorsApply corsApply, Integer pageIndex,
//			Integer pageSize) {
//		String hql = "from CorsApply where isDelete is null";
//		HashMap<String, Object> params = new HashMap<String, Object>();
//		String roleName = "null";
//		if (ContextUtil.getCurrentUser().getRole() != null)
//			roleName = ContextUtil.getCurrentUser().getRole().getRoleName();
//		if ("业务管理员".equals(roleName)) {
//			hql += " and (applyStatus is null or applyStatus='0')";
//		} else if ("财务管理员".equals(roleName)) {
//			hql += " and applyStatus='1'";
//		} else if ("账号管理员".equals(roleName)) {
//			hql += " and applyStatus='2'";
//		} else {
//			hql += " and applyStatus!='-1'";
//		}
//		if (corsApply.getCompany() != null
//				&& StringUtils
//						.isNotBlank(corsApply.getCompany().getCompanyId())) {
//			hql += " and company.companyId = :companyId";
//			params.put("companyId", corsApply.getCompany().getCompanyId());
//		} else if (!ContextUtil.isSystemUser()
//				&& !"CNTEN".equalsIgnoreCase(ContextUtil.getCurrentUser()
//						.getCompany().getCompanyCode())) {
//			hql += " and company.companyId = :companyId";
//			String companyId = ContextUtil.getCurrentUser().getCompany()
//					.getCompanyId();
//			params.put("companyId", companyId);
//		}
//		hql += " order by applyDate desc";
//		return commonDAO.getPage(hql, pageIndex, pageSize, params);
//	}
	
	public CorsApply getCorsApply(String corsApplyId) {
		return commonDAO.get(CorsApply.class, corsApplyId);
	}

	public CorsAccountRepay getCorsRepayApply(String corsApplyId) {
		return commonDAO.get(CorsAccountRepay.class, corsApplyId);
	}
	
	/**
	 * centimeter,formal,1,5# ---> 服务类型(bdDeviceAccuracy),账号类型(accountType),服务时长(accountPeriod),申请数量(applyCount)#
	 * @param applyData
	 * @param companyId
	 * @return
	 */
	public SuccessOrFailure saveFastCorsApply(String applyData,String companyId){
		Company company = commonDAO.load(Company.class, companyId);
		String hql = " from User a where a.isDelete is null and a.company = ? and a.userFeature = ?";
		User user = commonDAO.getByVariableParam(hql, company, UserFeature.Company_Register.getValue());
		String[] corsApplyTempParamsArray = applyData.split("#");
		String corsAccountType = null;  //账号类型：试用 、正式
		try {
			List<CorsApplyDetail> corsDetialList = new ArrayList<CorsApplyDetail>();
			for (String corsApplyTemp : corsApplyTempParamsArray) {
				String[] corsPrams = corsApplyTemp.split(",");
				if(corsAccountType == null){
					corsAccountType = corsPrams[1];
				}
				
				CorsApplyDetail corsApplyDetail = new CorsApplyDetail();
				corsApplyDetail.setAccountType(corsPrams[1]);
				if(CorsAccountConsts.ACCOUNT_TYPE_TEST.equals(corsAccountType)){
					corsApplyDetail.setAccountUsePeriod(CorsAccountConsts.ACCOUNT_TYPE_TEST_PERIOD);   //后台默认给定一个月
				}else{
					corsApplyDetail.setAccountUsePeriod(Integer.valueOf(corsPrams[2]));   //正式账号，取真实期限
				}
		
				corsApplyDetail.setBdDeviceAccuracy(corsPrams[0]);
				corsApplyDetail.setApplyCount(Integer.parseInt(corsPrams[3]));
				commonDAO.save(corsApplyDetail);
				
				corsDetialList.add(corsApplyDetail);
			}
			
			CorsApply apply = new CorsApply();
			apply.setOrderNo(OrderNoCreateUtil.getCorsApplyOrderNo());
			apply.setCompany(company);
			apply.setUser(user);
			apply.setApplyMaterialState(CorsAccountConsts.APPLY_MATERIAL_STATE_WWS);
			apply.setApplyStatus(CorsAccountConsts.BUSI_APPROVE_STATE_SUBMIT);
			apply.setAccountType(corsAccountType);
			apply.setAccountCreateState(CorsAccountConsts.APPLY_ACCOUNT_CREATE_STATE_0);
			if(CorsAccountConsts.ACCOUNT_TYPE_TEST.equals(corsAccountType)){
				apply.setOrderType(CorsAccountConsts.CORS_ORDER_TYPE_TRIAL);
			}else{
				apply.setOrderType(CorsAccountConsts.CORS_ORDER_TYPE_BUY);
			}
			apply.setApplyDetailList(corsDetialList);
			commonDAO.save(apply);
			
			CorsBusiApprove approve = new CorsBusiApprove();
			approve.setOrderBussinkey(apply.getCorsApplyId());
			approve.setBusiSubmitTime(new Date());
			approve.setCompany(company);
			approve.setBusiSubmitUser(user.getUserId());
			approve.setApproveState(CorsAccountConsts.ACCOUNT_APPROVE_UNDEAL);
			approve.setBusiApproveType(CorsAccountConsts.BUSI_APPROVE_ADD_APPLY);
			commonDAO.save(approve);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Page getCorsRepayApplyPage(String corsApplyId, Integer pageSize, Integer pageIndex) {
		String hql = " from CorsRepayRel a where a.corsAccountRepay.accountRepayId = :accountRepayId";
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("accountRepayId", corsApplyId);
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}

//	public void saveCorsApply(CorsApply corsApply) throws Exception {
//		if (corsApply.getCompany() != null
//				&& StringUtils.isBlank(corsApply.getCompany().getCompanyId())) {
//			corsApply.setCompany(null);
//		}
//		if (corsApply.getUser() != null
//				&& StringUtils.isBlank(corsApply.getUser().getUserId())) {
//			corsApply.setUser(null);
//		}
//		if (corsApply.getOamArea() != null
//				&& StringUtils.isBlank(corsApply.getOamArea().getOamAreaId())) {
//			corsApply.setOamArea(null);
//		}
//		String corsApplyId = corsApply.getCorsApplyId();
//		corsApply.setApplyStatus("0");
//		if (StringUtils.isEmpty(corsApplyId)) {
//			commonDAO.save(corsApply);
//		} else {
//			CorsApply oldCorsApply = commonDAO.load(CorsApply.class,
//					corsApplyId);
//			if (null != oldCorsApply.getApplyStatus()
//					&& !oldCorsApply.getApplyStatus().equals("0")) {
//				throw new Exception("该申请正在审核,不能更改");
//			}
//			oldCorsApply.setCompany(corsApply.getCompany());
//			oldCorsApply.setUser(corsApply.getUser());
//			oldCorsApply.setApplyCount(corsApply.getApplyCount());
//			oldCorsApply.setPurposeDesc(corsApply.getPurposeDesc());
//			oldCorsApply.setApplyStatus(corsApply.getApplyStatus());
//			oldCorsApply.setApplyComment(corsApply.getApplyComment());
//			oldCorsApply.setApplyDate(corsApply.getApplyDate());
//			oldCorsApply.setOamArea(corsApply.getOamArea());
//			oldCorsApply.setBdDeviceAccuracy(corsApply.getBdDeviceAccuracy());
//			oldCorsApply.setAccountType(corsApply.getAccountType());
//			commonDAO.update(oldCorsApply);
//		}
//	}

//	public void deleteCorsApply(String corsApplyIds) {
//		String[] corsApplyIdArray = corsApplyIds.split(",");
//		for (String corsApplyId : corsApplyIdArray) {
//			CorsApply oldCorsApply = commonDAO.load(CorsApply.class,
//					corsApplyId);
//			oldCorsApply.setIsDelete("Y");
//			commonDAO.update(oldCorsApply);
//		}
//	}

//	public void exportCorsApplys(CorsApply corsApply,
//			HttpServletResponse response) throws Exception {
//		String hql = "from CorsApply where isDelete is null";
//		HashMap<String, Object> params = new HashMap<String, Object>();
//		if (corsApply.getCompany() != null
//				&& StringUtils
//						.isNotBlank(corsApply.getCompany().getCompanyId())) {
//			hql += " and company.companyId = :companyId";
//			params.put("companyId", corsApply.getCompany().getCompanyId());
//		}
//		List<CorsApply> corsApplys = commonDAO.queryList(hql, params);
//		HSSFWorkbook workbook = new HSSFWorkbook();
//		HSSFSheet sheet = workbook.createSheet("CORS账号申请信息");
//		sheet.setDefaultColumnWidth(20);
//		HSSFRow row = sheet.createRow(0);
//		String[] headers = { "申请企业", "申请人员", "申请数量", "申请目的", "审批状态", "审批意见",
//				"申请日期" };
//		PoiExporter.fillHeader(row, headers);
//		int i = 1;
//		HSSFCell cell;
//		for (CorsApply corsApplyData : corsApplys) {
//			row = sheet.createRow(i);
//			cell = row.createCell(0);
//			if (corsApplyData.getCompany() != null) {
//				cell.setCellValue(corsApplyData.getCompany().getCompanyName());
//			}
//			cell = row.createCell(1);
//			if (corsApplyData.getUser() != null) {
//				cell.setCellValue(corsApplyData.getUser().getUserName());
//			}
//			cell = row.createCell(2);
//			if (corsApplyData.getApplyCount() != null) {
//				cell.setCellValue(corsApplyData.getApplyCount());
//			}
//			cell = row.createCell(3);
//			if (corsApplyData.getPurposeDesc() != null) {
//				cell.setCellValue(corsApplyData.getPurposeDesc());
//			}
//			cell = row.createCell(4);
//			if (corsApplyData.getApplyStatus() != null) {
//				cell.setCellValue(corsApplyData.getApplyStatusName());
//			}
//			cell = row.createCell(5);
//			if (corsApplyData.getApplyComment() != null) {
//				cell.setCellValue(corsApplyData.getApplyComment());
//			}
//			cell = row.createCell(6);
//			if (corsApplyData.getApplyDate() != null) {
//				cell.setCellValue(StringUtil.formatDateTime(corsApplyData
//						.getApplyDate()));
//			}
//			i++;
//		}
//		response.setHeader("Content-Disposition", "attachment; filename="
//				+ java.net.URLEncoder.encode("CORS账号申请信息.xls", "UTF-8"));
//		OutputStream os = response.getOutputStream();
//		workbook.write(os);
//		os.close();
//	}

//	public void saveApproval(CorsApply suggestion, String status)
//			throws Exception {
//		if (suggestion != null
//				&& StringUtils.isNotBlank(suggestion.getCorsApplyId())
//				&& StringUtils.isNotBlank(status)) {
//			CorsApply corsApply = commonDAO.load(CorsApply.class,
//					suggestion.getCorsApplyId());
//			String applyComment = corsApply.getApplyComment();
//			if (StringUtils.isNotBlank(applyComment)) {
//				applyComment += "\n" + suggestion.getApplyComment();
//			} else {
//				applyComment = suggestion.getApplyComment();
//			}
//
//			String roleName = "";
//			String orderPrefix = "";
//			if (ContextUtil.getCurrentUser().getRole() != null)
//				roleName = ContextUtil.getCurrentUser().getRole().getRoleName();
//			if (!"财务管理员".equals(roleName) && "2".equals(status)
//					|| Integer.parseInt(status) > 3) {
//				return;
//			}
//			if ("财务管理员".equals(roleName)) {
//				corsApply.setApplyPayment(suggestion.getApplyPayment());
//				corsApply.setContractNo(suggestion.getContractNo());
//				corsApply.setInvoiceNo(suggestion.getInvoiceNo());
//				/*corsApply.setFinancialHandler(ContextUtil.getCurrentUser());*/
//				corsApply.setAccountPrefix(suggestion.getAccountPrefix());
//				corsApply.setEffectiveDate(suggestion.getEffectiveDate());
//				corsApply.setExprieDate(suggestion.getExprieDate());
//				String hql = "from CorsApply where orderNo is not null";
//				long count = commonDAO.getCountByVariableParam(hql);
//				corsApply.setOrderNo(String.format("%s_%05d", orderPrefix,
//						count));
//			}
//			corsApply.setApplyComment(applyComment);
//			corsApply.setApplyStatus(status);
//
//			if ("2".equals(status)) {
//				corsApply.setApplyComment(suggestion.getApplyComment());
//				createCorsAccount(corsApply);
//			}
//			commonDAO.update(corsApply);
//		}
//	}

//	private void createCorsAccount(CorsApply corsApply) {
//		if (corsApply.getApplyCount() == null && corsApply.getApplyCount() == 0)
//			return;
//
//		CorsAccount corsAccount = null;
//		String hql = "from CorsAccount where company.companyId=?";
//		long count = commonDAO.getCountByVariableParam(hql, corsApply
//				.getCompany().getCompanyId());
//		for (int i = 1; i <= corsApply.getApplyCount(); i++) {
//			corsAccount = new CorsAccount();
//			corsAccount.setCorsAccountPwd("123456");
//			corsAccount.setOamArea(corsApply.getOamArea());
//			corsAccount.setBdDeviceAccuracy(corsApply.getBdDeviceAccuracy());
//			corsAccount.setCorsAccountType(corsApply.getAccountType());
//			corsAccount.setEffectiveDate(corsApply.getEffectiveDate());
//			corsAccount.setExprieDate(corsApply.getExprieDate());
//			// corsAccount.setCorsApply(corsApply);
//			corsAccount.setCorsAccountCode(String.format("%s_%05d",
//					corsApply.getAccountPrefix(), (count + i)));
//			commonDAO.save(corsAccount);
//		}
//	}

//	public void exportCorsApply(CorsApply corsApply,
//			HttpServletResponse response, HttpServletRequest request)
//			throws Exception, IOException {
//		String path = request.getSession().getServletContext()
//				.getRealPath("/WEB-INF");
//		File fi = new File(path + "/template/账户详单.xls");
//		POIFSFileSystem fs = null;
//		try {
//			fs = new POIFSFileSystem(new FileInputStream(fi));
//		} catch (FileNotFoundException fex) {
//			fex.printStackTrace();
//			response.sendError(404, "未找到模板文件");
//			return;
//		}
//		// 读取excel模板
//		HSSFWorkbook workbook = new HSSFWorkbook(fs);
//		// 读取了模板内sheet0内容
//		HSSFSheet sheet = workbook.getSheetAt(0);
//		HSSFRow row = sheet.getRow(1);
//		row.getCell(0).setCellValue(
//				row.getCell(0).getStringCellValue().substring(0, 5)
//						+ (null == corsApply.getOrderNo() ? "" : corsApply
//								.getOrderNo()));
//		row = sheet.getRow(2);
//		row.getCell(1).setCellValue(corsApply.getCompany().getCompanyName());
//		row = sheet.getRow(3);
//		row.getCell(1).setCellValue(corsApply.getCompany().getAddress());
//		row = sheet.getRow(4);
//		row.getCell(1).setCellValue(corsApply.getUser().getUserName());
//		row.getCell(3).setCellValue(corsApply.getUser().getPhone());
//		row = sheet.getRow(5);
//		row.getCell(1).setCellValue(corsApply.getUser().getEmail());
//		row = sheet.getRow(6);
//		row.getCell(1).setCellValue(corsApply.getPurposeDesc());
//		row = sheet.getRow(7);
//		row.getCell(1).setCellValue(corsApply.getApplyCount());
//		row.getCell(3).setCellValue(corsApply.getApplyPayment());
//		row = sheet.getRow(8);
//		row.getCell(1).setCellValue(corsApply.getContractNo());
//		row.getCell(3).setCellValue(corsApply.getInvoiceNo());
//		row = sheet.getRow(9);
//		if (null != corsApply.getApplyStatus()) {
//			if (corsApply.getApplyStatus().equals("2")) {
//				row.getCell(1).setCellValue("通过");
//			} else if (corsApply.getApplyStatus().equals("-1")) {
//				row.getCell(1).setCellValue("拒绝");
//			}
//		}
//		/*if (null != corsApply.getFinancialHandler()) {
//			row.getCell(3).setCellValue(
//					corsApply.getFinancialHandler().getUserName());
//		}*/
//		row = sheet.getRow(11);
//		row.getCell(1).setCellValue(corsApply.getApplyComment());
//		HSSFSheet sheetCorsAccount = workbook.getSheetAt(1);
//		corsAccountService.exportCorsAccountsByApplyId(sheetCorsAccount,
//				corsApply);
//		response.setHeader("Content-Disposition", "attachment; filename="
//				+ new String("账户详单".getBytes(), "iso8859-1") + ".xls");
//		OutputStream os = response.getOutputStream();
//		workbook.write(os);
//		os.close();
//	}

//	public void saveApply(String corsApplyId) {
//		CorsApply corsApply = commonDAO.load(CorsApply.class, corsApplyId);
//		CorsBusiApprove corsBusiApprove = new CorsBusiApprove();
//		corsBusiApprove
//				.setApproveState(CorsAccountConsts.ACCOUNT_APPROVE_UNDEAL);
//		corsBusiApprove
//				.setBusiApproveType(CorsAccountConsts.BUSI_APPROVE_ADD_APPLY);
//		corsBusiApprove.setBusiApproveUser(corsApply.getUser().getUserId());
//		corsBusiApprove.setOrderBussinkey(corsApplyId);
//		corsBusiApprove.setCompany(corsApply.getCompany());
//		commonDAO.save(corsBusiApprove);
//	}
}