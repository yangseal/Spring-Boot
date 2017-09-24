package com.cnten.bdlocation.stakeouttask.service;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.bdlocation.companyOrg.service.CompanyOrgService;
import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.export.PoiExporter;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.util.StringUtil;
import com.cnten.po.Company;
import com.cnten.po.CompanyOrg;
import com.cnten.po.ConversionParam;
import com.cnten.po.CorsAccount;
import com.cnten.po.StakeoutTask;

@Service
public class StakeoutTaskService {

	@Autowired
	CommonDAO commonDAO;
	
	@Autowired
	CompanyOrgService companyOrgService;

	public Page getStakeoutTasksPage(StakeoutTask stakeoutTask, Integer pageIndex, Integer pageSize) {
		try {
			String hql = "from StakeoutTask where isDelete is null";
			HashMap<String, Object> params = new HashMap<String, Object>();
			if (StringUtils.isNotBlank(stakeoutTask.getAffiliationCompanyId())) {
				hql += " and affiliationCompany.companyId = :companyId";
				params.put("companyId", stakeoutTask.getAffiliationCompanyId());
			} else if (!ContextUtil.isSystemUser()) {
				hql += " and affiliationCompany.companyId = :companyId";
				String companyId = ContextUtil.getCurrentUser().getCompany().getCompanyId();
				params.put("companyId", companyId);
				
				hql += " and companyOrg.companyOrgId in(:orgs) order by createDate desc";
				params.put("orgs", companyOrgService.querySelfAndChildOrg());
			}
			if (!StringUtils.isEmpty(stakeoutTask.getStakeoutTaskName())) {

				hql += " and stakeoutTaskName like :stakeoutTaskName";
				params.put("stakeoutTaskName", "%" + stakeoutTask.getStakeoutTaskName() + "%");
			}

			if (!StringUtils.isEmpty(stakeoutTask.getCorsAccountCode())) {
				hql += " and corsAccount.corsAccountCode = :corsAccountCode";
				params.put("corsAccountCode", stakeoutTask.getCorsAccountCode());
			}
			
			if(!StringUtils.isEmpty(stakeoutTask.getTaskStatus())) {
				hql += " and taskStatus = :taskStatus";
				params.put("taskStatus", stakeoutTask.getTaskStatus());
			}

			if (stakeoutTask.getCreateDateBegin() != null) {
				hql += " and createDate >=:createDateBegin";
				params.put("createDateBegin", stakeoutTask.getCreateDateBegin());
			}

			if (stakeoutTask.getCreateDateEnd() != null) {
				hql += " and createDate <=:createDateEnd";
				params.put("createDateEnd", stakeoutTask.getCreateDateEnd());
			}
			
			return commonDAO.getPage(hql, pageIndex, pageSize, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// added by lanj 2016-06-23 根据任务获取任务
	public List<StakeoutTask> getStakeoutTasksByTask(StakeoutTask stakeoutTask) {

		String hql = "from StakeoutTask where isDelete is null and taskStatus != 'newTask'";
		HashMap<String, Object> params = new HashMap<String, Object>();

		if (!StringUtils.isEmpty(stakeoutTask.getStakeoutTaskId())) {
			hql += " and stakeoutTaskId =:stakeoutTaskId";
			params.put("stakeoutTaskId", stakeoutTask.getStakeoutTaskId());
		}

		if (!StringUtils.isEmpty(stakeoutTask.getStakeoutTaskName())) {

			hql += " and stakeoutTaskName like :stakeoutTaskName";
			params.put("stakeoutTaskName", "%" + stakeoutTask.getStakeoutTaskName() + "%");
		}

		if (!StringUtils.isEmpty(stakeoutTask.getTaskType())) {
			hql += " and taskType =:taskType";
			params.put("taskType", stakeoutTask.getTaskType());
		}

		if (!StringUtils.isEmpty(stakeoutTask.getTaskStatus())) {
				hql += " and taskStatus =:taskStatus";
				params.put("taskStatus", stakeoutTask.getTaskStatus());
		}

		if (stakeoutTask.getCreateDate() != null) {
			hql += " and createDate =:createDate";
			params.put("createDate", stakeoutTask.getCreateDate());
		}

		if (!StringUtils.isEmpty(stakeoutTask.getCorsAccountId())) {
			hql += " and corsAccount.corsAccountId =:corsAccountId";
			params.put("corsAccountId", stakeoutTask.getCorsAccountId());
		}

		if (StringUtils.isNotBlank(stakeoutTask.getAffiliationCompanyId())) {
			hql += " and affiliationCompany.companyId = :companyId";
			params.put("companyId", stakeoutTask.getAffiliationCompanyId());
		} else if (!ContextUtil.isSystemUser()) {
			hql += " and affiliationCompany.companyId = :companyId";
			String companyId = ContextUtil.getCurrentUser().getCompany().getCompanyId();
			params.put("companyId", companyId);
		}

		if (!StringUtils.isEmpty(stakeoutTask.getCorsAccountCode())) {
			hql += " and corsAccount.corsAccountCode = :corsAccountCode";
			params.put("corsAccountCode", stakeoutTask.getCorsAccountCode());
		}

		if (stakeoutTask.getCreateDateBegin() != null) {
			hql += " and createDate >=:createDateBegin";
			params.put("createDateBegin", stakeoutTask.getCreateDateBegin());
		}

		if (stakeoutTask.getCreateDateEnd() != null) {
			hql += " and createDate <=:createDateEnd";
			params.put("createDateEnd", stakeoutTask.getCreateDateEnd());
		}

		return commonDAO.queryList(hql, params);
	}

	public StakeoutTask getStakeoutTask(String stakeoutTaskId) {
		return commonDAO.get(StakeoutTask.class, stakeoutTaskId);
	}

	public void saveStakeoutTask(StakeoutTask stakeoutTask) {
		if (StringUtils.isEmpty(stakeoutTask.getCorsAccountId())) {
			stakeoutTask.setCorsAccount(null);
		} else {
			stakeoutTask.setCorsAccount(new CorsAccount(stakeoutTask.getCorsAccountId()));
		}
		if (StringUtils.isEmpty(stakeoutTask.getAffiliationCompanyId())) {
			stakeoutTask.setAffiliationCompany(null);
		} else {
			stakeoutTask.setAffiliationCompany(new Company(stakeoutTask.getAffiliationCompanyId()));
		}
		if(StringUtils.isEmpty(stakeoutTask.getConversionParamId())){
			stakeoutTask.setConversionParam(null);
		} else {
			stakeoutTask.setConversionParam(new ConversionParam(stakeoutTask.getConversionParamId()));
		}
		String stakeoutTaskId = stakeoutTask.getStakeoutTaskId();
		if (StringUtils.isEmpty(stakeoutTaskId)) {
			CompanyOrg companyOrg = ContextUtil.getCurrentUser().getCompanyOrg();
			stakeoutTask.setCompanyOrg(companyOrg);
			commonDAO.save(stakeoutTask);
		} else {
			StakeoutTask oldStakeoutTask = commonDAO.load(StakeoutTask.class, stakeoutTaskId);
			oldStakeoutTask.setStakeoutTaskName(stakeoutTask.getStakeoutTaskName());
			oldStakeoutTask.setTaskType(stakeoutTask.getTaskType());
			oldStakeoutTask.setTaskStatus(stakeoutTask.getTaskStatus());
			oldStakeoutTask.setCreateDate(stakeoutTask.getCreateDate());
			oldStakeoutTask.setCorsAccount(stakeoutTask.getCorsAccount());
			oldStakeoutTask.setAffiliationCompany(stakeoutTask.getAffiliationCompany());
			oldStakeoutTask.setConversionParam(stakeoutTask.getConversionParam());
			commonDAO.update(oldStakeoutTask);
		}
	}

	public void deleteStakeoutTask(String stakeoutTaskIds) {
		String[] stakeoutTaskIdArray = stakeoutTaskIds.split(",");
		for (String stakeoutTaskId : stakeoutTaskIdArray) {
			StakeoutTask oldStakeoutTask = commonDAO.load(StakeoutTask.class, stakeoutTaskId);
			oldStakeoutTask.setIsDelete("Y");
			commonDAO.update(oldStakeoutTask);
		}
	}

	public void updateStakeoutTaskState(String stakeoutTaskIds) {
		String[] stakeoutTaskIdArray = stakeoutTaskIds.split(",");
		for (String stakeoutTaskId : stakeoutTaskIdArray) {
			StakeoutTask oldStakeoutTask = commonDAO.load(StakeoutTask.class, stakeoutTaskId);
			oldStakeoutTask.setTaskStatus("issued");
			commonDAO.update(oldStakeoutTask);
		}
	}

	public void exportStakeoutTasks(StakeoutTask stakeoutTask, HttpServletResponse response) throws Exception {
		String hql = "from StakeoutTask where isDelete is null and stakeoutTaskId = " + stakeoutTask.getStakeoutTaskId();
		HashMap<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(stakeoutTask.getAffiliationCompanyId())) {
			hql += " and affiliationCompany.companyId = :companyId";
			params.put("companyId", stakeoutTask.getAffiliationCompanyId());
		} else if (!ContextUtil.isSystemUser()) {
			hql += " and affiliationCompany.companyId = :companyId";
			String companyId = ContextUtil.getCurrentUser().getCompany().getCompanyId();
			params.put("companyId", companyId);
		}
		List<StakeoutTask> stakeoutTasks = commonDAO.queryList(hql, params);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("点放样任务信息");
		sheet.setDefaultColumnWidth(20);
		HSSFRow row = sheet.createRow(0);
		String[] headers = { "任务名称", "任务类型", "任务状态", "创建时间", "创建人", "所属企业","转换地区" };
		PoiExporter.fillHeader(row, headers);
		int i = 1;
		HSSFCell cell;
		for (StakeoutTask stakeoutTaskData : stakeoutTasks) {
			row = sheet.createRow(i);
			cell = row.createCell(0);
			if (stakeoutTaskData.getStakeoutTaskName() != null) {
				cell.setCellValue(stakeoutTaskData.getStakeoutTaskName());
			}
			cell = row.createCell(1);
			if (stakeoutTaskData.getTaskType() != null) {
				cell.setCellValue(stakeoutTaskData.getTaskTypeName());
			}
			cell = row.createCell(2);
			if (stakeoutTaskData.getTaskStatus() != null) {
				cell.setCellValue(stakeoutTaskData.getTaskStatusName());
			}
			cell = row.createCell(3);
			if (stakeoutTaskData.getCreateDate() != null) {
				cell.setCellValue(StringUtil.formatDateTime(stakeoutTaskData.getCreateDate()));
			}
			cell = row.createCell(4);
			if (stakeoutTaskData.getCorsAccount() != null) {
				cell.setCellValue(stakeoutTaskData.getCorsAccount().getCorsAccountCode());
			}
			cell = row.createCell(5);
			if (stakeoutTaskData.getAffiliationCompany() != null) {
				cell.setCellValue(stakeoutTaskData.getAffiliationCompany().getCompanyName());
			}
			cell = row.createCell(6);
			if (stakeoutTaskData.getConversionParam() != null) {
				cell.setCellValue(stakeoutTaskData.getConversionParam().getConversionParamName());
			}
			i++;
		}
		response.setHeader("Content-Disposition",
				"attachment; filename=" + java.net.URLEncoder.encode("点放样任务信息.xls", "UTF-8"));
		OutputStream os = response.getOutputStream();
		workbook.write(os);
		os.close();
	}
}