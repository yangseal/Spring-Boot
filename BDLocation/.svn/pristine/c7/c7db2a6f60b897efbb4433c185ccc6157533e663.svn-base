package com.cnten.bdlocation.feedback.service;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.cnten.platform.export.PoiExporter;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.util.StringUtil;
import com.cnten.po.Feedback;

@Service
public class FeedbackService {

	@Autowired
	CommonDAO commonDAO;
	
	public Page getFeedbacksPage(Feedback feedback, Integer pageIndex, Integer pageSize) {
		String hql = "from Feedback where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(feedback.getType())){
			hql += " and type = :type";
			params.put("type", feedback.getType());
		}
		if(StringUtils.isNotBlank(feedback.getFeedbackStatus())){
			hql += " and feedbackStatus = :feedbackStatus";
			params.put("feedbackStatus", feedback.getFeedbackStatus());
		}
		if (feedback.getCompany() != null && StringUtils.isNotBlank(feedback.getCompany().getCompanyId())) {
			hql += " and company.companyId = :companyId";
			params.put("companyId", feedback.getCompany().getCompanyId());
		} else if (!ContextUtil.isSystemUser() && !"CNTEN".equalsIgnoreCase(ContextUtil.getCurrentUser().getCompany().getCompanyCode())) {
			hql += " and company.companyId = :companyId";
			String companyId = ContextUtil.getCurrentUser().getCompany().getCompanyId();
			params.put("companyId", companyId);
		}
		hql += " order by createDate desc";
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}

	public Feedback getFeedback(String feedbackId) {
		return commonDAO.get(Feedback.class, feedbackId);
	}

	public void saveFeedback(Feedback feedback) {
		if(feedback.getCompany() != null && StringUtils.isBlank(feedback.getCompany().getCompanyId())){
			feedback.setCompany(null);
		}
		if(feedback.getUser() != null && StringUtils.isBlank(feedback.getUser().getUserId())){
			feedback.setUser(null);
		}
		String feedbackId = feedback.getFeedbackId();
		if(StringUtils.isEmpty(feedbackId)){
			commonDAO.save(feedback);
		}else{
			Feedback oldFeedback = commonDAO.load(Feedback.class, feedbackId);
			oldFeedback.setCompany(feedback.getCompany());
			oldFeedback.setUser(feedback.getUser());
			oldFeedback.setType(feedback.getType());
			oldFeedback.setFeedbackStatus(feedback.getFeedbackStatus());
			oldFeedback.setInformation(feedback.getInformation());
			oldFeedback.setCreateDate(feedback.getCreateDate());
			commonDAO.update(oldFeedback);
		}
	}

	public void deleteFeedback(String feedbackIds){
		String[] feedbackIdArray = feedbackIds.split(",");
		for(String feedbackId : feedbackIdArray){
			Feedback oldFeedback = commonDAO.load(Feedback.class, feedbackId);
			oldFeedback.setIsDelete("Y");
			commonDAO.update(oldFeedback);
		}
	}
	
	public void exportFeedbacks(Feedback feedback, HttpServletResponse response) throws Exception{
		String hql = "from Feedback where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(feedback.getCompany() != null && StringUtils.isNotBlank(feedback.getCompany().getCompanyId())){
			hql += " and company.companyId = :companyId";
			params.put("companyId", feedback.getCompany().getCompanyId());
		}
		if(StringUtils.isNotBlank(feedback.getType())){
			hql += " and type = :type";
			params.put("type", feedback.getType());
		}
		if(StringUtils.isNotBlank(feedback.getFeedbackStatus())){
			hql += " and feedbackStatus = :feedbackStatus";
			params.put("feedbackStatus", feedback.getFeedbackStatus());
		}
		List<Feedback> feedbacks = commonDAO.queryList(hql, params);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("信息反馈信息");
		sheet.setDefaultColumnWidth(20);
		HSSFRow row = sheet.createRow(0);
		String[] headers = {"反馈企业","反馈人员","信息分类","处理状态","反馈信息","反馈日期"};
		PoiExporter.fillHeader(row, headers);
		int i = 1;
		HSSFCell cell;
		for(Feedback feedbackData : feedbacks){
			row = sheet.createRow(i);
			cell = row.createCell(0);
			if(feedbackData.getCompany() != null){
				cell.setCellValue(feedbackData.getCompany().getCompanyName());
			}
			cell = row.createCell(1);
			if(feedbackData.getUser() != null){
				cell.setCellValue(feedbackData.getUser().getUserName());
			}
			cell = row.createCell(2);
			if(feedbackData.getType() != null){
				cell.setCellValue(feedbackData.getTypeName());
			}
			cell = row.createCell(3);
			if(feedbackData.getFeedbackStatus() != null){
				cell.setCellValue(feedbackData.getFeedbackStatusName());
			}
			cell = row.createCell(4);
			if(feedbackData.getInformation() != null){
				cell.setCellValue(feedbackData.getInformation());
			}
			cell = row.createCell(5);
			if(feedbackData.getCreateDate() != null){
				cell.setCellValue(StringUtil.formatDateTime(feedbackData.getCreateDate()));
			}
			i++;
		}
		response.setHeader("Content-Disposition", "attachment; filename=" 
				+ java.net.URLEncoder.encode("信息反馈信息.xls", "UTF-8"));
		OutputStream os = response.getOutputStream();
		workbook.write(os);
		os.close();
	}
}