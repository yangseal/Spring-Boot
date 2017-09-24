package com.cnten.bdlocation.stakeoutpoint.service;

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

import GisUtility.Coordinate.ConvertCalculate.SuperConvert;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.export.PoiExporter;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.util.CoodinateCoverUtil;
import com.cnten.platform.util.StringUtil;
import com.cnten.po.ConversionParam;
import com.cnten.po.PointType;
import com.cnten.po.StakeoutPoint;
import com.cnten.po.StakeoutTask;

@Service
public class StakeoutPointService {

	@Autowired
	CommonDAO commonDAO;

	public Page getStakeoutPointsPage(StakeoutPoint stakeoutPoint, Integer pageIndex, Integer pageSize) {
		String hql = "from StakeoutPoint where isDelete is null";
		HashMap<String, Object> params = new HashMap<String, Object>();
		if (!StringUtils.isEmpty(stakeoutPoint.getAffiliationStakeoutTaskId())) {
			hql += " and affiliationStakeoutTask.stakeoutTaskId = :affiliationStakeoutTaskId";
			params.put("affiliationStakeoutTaskId", stakeoutPoint.getAffiliationStakeoutTaskId());
		}else if(!ContextUtil.isSystemUser()){
			hql += " and affiliationStakeoutTask.affiliationCompany.companyId = :companyId";
			String companyId = ContextUtil.getCurrentUser().getCompany().getCompanyId();
			params.put("companyId", companyId);
		}
		hql += " order by createDate desc";

		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}

	// added by lanj 2016-06-23 根据任务获取放样点对象
	public List<StakeoutPoint> getStakeoutPointByTaskId(String taskId) {
		if (StringUtils.isBlank(taskId)) return new ArrayList<StakeoutPoint>();
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("taskId", taskId);
		String hql = "from StakeoutPoint where isDelete is null and affiliationStakeoutTask.stakeoutTaskId = :taskId";
		return commonDAO.queryList(hql, params);
	}

	public StakeoutPoint getStakeoutPoint(String stakeoutPointId) {
		return commonDAO.get(StakeoutPoint.class, stakeoutPointId);
	}

	public void saveStakeoutPoint(StakeoutPoint stakeoutPoint) throws Exception {
		if (StringUtils.isEmpty(stakeoutPoint.getAffiliationPointTypeId())) {
			stakeoutPoint.setAffiliationPointType(null);
		} else {
			stakeoutPoint.setAffiliationPointType(new PointType(stakeoutPoint.getAffiliationPointTypeId()));
		}
		if (StringUtils.isEmpty(stakeoutPoint.getAffiliationStakeoutTaskId())) {
			stakeoutPoint.setAffiliationStakeoutTask(null);
		} else {
			stakeoutPoint.setAffiliationStakeoutTask(new StakeoutTask(stakeoutPoint.getAffiliationStakeoutTaskId()));
		}
		Double lat = stakeoutPoint.getLatitude();
		Double lng = stakeoutPoint.getLongitude();
		Double x = stakeoutPoint.getCoordinateX();
		Double y = stakeoutPoint.getCoordinateY();
		if(x==null || y==null) {
			StakeoutTask stakeoutTask = commonDAO.load(StakeoutTask.class, stakeoutPoint.getAffiliationStakeoutTaskId());
			ConversionParam param = stakeoutTask.getConversionParam();
			if(param != null){
				SuperConvert cc = CoodinateCoverUtil.getInstance().getCoverOfFourParam(param);
				if(cc.Convert(lat, lng, 0)) {
					stakeoutPoint.setCoordinateX(cc.get_Y());
					stakeoutPoint.setCoordinateY(cc.get_X());
				} else {
					throw new Exception("经纬度信息有误!");
				}
			}
			
		} else if(lat==null || lng==null) {
			StakeoutTask stakeoutTask = commonDAO.load(StakeoutTask.class, stakeoutPoint.getAffiliationStakeoutTaskId());
			ConversionParam param = stakeoutTask.getConversionParam();
			if(param != null) {
				SuperConvert cc = CoodinateCoverUtil.getInstance().getReverseCoverOfFourParam(param);
				if(cc.AntiConvert(y, x, 0)) {
					stakeoutPoint.setLatitude(cc.get_B());
					stakeoutPoint.setLongitude(cc.get_L());
				} else {
					throw new Exception("城建坐标信息有误!");
				}
			}	
		}
		String stakeoutPointId = stakeoutPoint.getStakeoutPointId();
		if (StringUtils.isEmpty(stakeoutPointId)) {
			commonDAO.save(stakeoutPoint);
		} else {
			StakeoutPoint oldStakeoutPoint = commonDAO.load(StakeoutPoint.class, stakeoutPointId);
			oldStakeoutPoint.setStakeoutPointName(stakeoutPoint.getStakeoutPointName());
			oldStakeoutPoint.setAffiliationPointType(stakeoutPoint.getAffiliationPointType());
			oldStakeoutPoint.setAltitude(stakeoutPoint.getAltitude());
			oldStakeoutPoint.setLongitude(stakeoutPoint.getLongitude());
			oldStakeoutPoint.setLatitude(stakeoutPoint.getLatitude());
			oldStakeoutPoint.setCoordinateX(stakeoutPoint.getCoordinateX());
			oldStakeoutPoint.setCoordinateY(stakeoutPoint.getCoordinateY());
			oldStakeoutPoint.setCreateDate(stakeoutPoint.getCreateDate());
			oldStakeoutPoint.setAffiliationStakeoutTask(stakeoutPoint.getAffiliationStakeoutTask());
			commonDAO.update(oldStakeoutPoint);
		}
	}

	public void deleteStakeoutPoint(String stakeoutPointIds) {
		String[] stakeoutPointIdArray = stakeoutPointIds.split(",");
		for (String stakeoutPointId : stakeoutPointIdArray) {
			StakeoutPoint oldStakeoutPoint = commonDAO.load(StakeoutPoint.class, stakeoutPointId);
			oldStakeoutPoint.setIsDelete("Y");
			commonDAO.update(oldStakeoutPoint);
		}
	}

	public void exportStakeoutPoints(StakeoutPoint stakeoutPoint, HttpServletResponse response) throws Exception {
		String hql = "from StakeoutPoint where isDelete is null";
		HashMap<String, Object> params = new HashMap<String, Object>();
		String taskId = stakeoutPoint.getAffiliationStakeoutTaskId();
		if(!StringUtils.isEmpty(taskId)) {
			hql += " and affiliationStakeoutTask.stakeoutTaskId=:taskId";
			params.put("taskId",taskId);
		}
		List<StakeoutPoint> stakeoutPoints = commonDAO.queryList(hql, params);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("放样点信息");
		sheet.setDefaultColumnWidth(20);
		HSSFRow row = sheet.createRow(0);
		String[] headers = { "点名称", "所属点类型", "高程", "纬度", "经度", "城建坐标X", "城建坐标Y", "创建日期", "所属放样任务" };
		PoiExporter.fillHeader(row, headers);
		int i = 1;
		HSSFCell cell;
		for (StakeoutPoint stakeoutPointData : stakeoutPoints) {
			row = sheet.createRow(i);
			cell = row.createCell(0);
			if (stakeoutPointData.getStakeoutPointName() != null) {
				cell.setCellValue(stakeoutPointData.getStakeoutPointName());
			}
			cell = row.createCell(1);
			if (stakeoutPointData.getAffiliationPointType() != null) {
				cell.setCellValue(stakeoutPointData.getAffiliationPointType().getPointTypeName());
			}
			cell = row.createCell(2);
			if (stakeoutPointData.getAltitude() != null) {
				cell.setCellValue(stakeoutPointData.getAltitude());
			}
			cell = row.createCell(3);
			if (stakeoutPointData.getLongitude() != null) {
				cell.setCellValue(stakeoutPointData.getLongitude());
			}
			cell = row.createCell(4);
			if (stakeoutPointData.getLatitude() != null) {
				cell.setCellValue(stakeoutPointData.getLatitude());
			}
			cell = row.createCell(5);
			if (stakeoutPointData.getCoordinateX() != null) {
				cell.setCellValue(stakeoutPointData.getCoordinateX());
			}
			cell = row.createCell(6);
			if (stakeoutPointData.getCoordinateY() != null) {
				cell.setCellValue(stakeoutPointData.getCoordinateY());
			}
			cell = row.createCell(7);
			if (stakeoutPointData.getCreateDate() != null) {
				cell.setCellValue(StringUtil.formatDateTime(stakeoutPointData.getCreateDate()));
			}
			cell = row.createCell(8);
			if (stakeoutPointData.getAffiliationStakeoutTask() != null) {
				cell.setCellValue(stakeoutPointData.getAffiliationStakeoutTask().getStakeoutTaskName());
			}
			i++;
		}
		response.setHeader("Content-Disposition",
				"attachment; filename=" + java.net.URLEncoder.encode("放样点信息.xls", "UTF-8"));
		OutputStream os = response.getOutputStream();
		workbook.write(os);
		os.close();
	}
}