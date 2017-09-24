package com.cnten.bdlocation.oamstationtesting.service;

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
import com.cnten.platform.util.StringUtil;
import com.cnten.po.OamProject;
import com.cnten.po.OamProjectTesting;
import com.cnten.po.OamStationTesting;

@Service
public class OamStationTestingService {

	@Autowired
	CommonDAO commonDAO;
	
	public Page getOamStationTestingsPage(OamStationTesting oamStationTesting, Integer pageIndex, Integer pageSize) {
		String hql = "from OamStationTesting where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(oamStationTesting.getOamProjectTesting() != null && StringUtils.isNotBlank(oamStationTesting.getOamProjectTesting().getOamProjectTestingId())){
			hql += " and oamProjectTesting.oamProjectTestingId = :oamProjectTestingId";
			params.put("oamProjectTestingId", oamStationTesting.getOamProjectTesting().getOamProjectTestingId());
		}
		if(oamStationTesting.getOamBaseStation() != null && StringUtils.isNotBlank(oamStationTesting.getOamBaseStation().getOamBaseStationId())){
			hql += " and oamBaseStation.oamBaseStationId = :oamBaseStationId";
			params.put("oamBaseStationId", oamStationTesting.getOamBaseStation().getOamBaseStationId());
		}
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}

	public OamStationTesting getOamStationTesting(String oamStationTestingId) {
		return commonDAO.get(OamStationTesting.class, oamStationTestingId);
	}

	public void saveOamStationTesting(OamStationTesting oamStationTesting) {
		if(oamStationTesting.getOamProjectTesting() != null && StringUtils.isBlank(oamStationTesting.getOamProjectTesting().getOamProjectTestingId())){
			oamStationTesting.setOamProjectTesting(null);
		}
		if(oamStationTesting.getOamBaseStation() != null && StringUtils.isBlank(oamStationTesting.getOamBaseStation().getOamBaseStationId())){
			oamStationTesting.setOamBaseStation(null);
		}
		String oamStationTestingId = oamStationTesting.getOamStationTestingId();
		if(StringUtils.isEmpty(oamStationTestingId)){
			commonDAO.save(oamStationTesting);
		}else{
			OamStationTesting oldOamStationTesting = commonDAO.load(OamStationTesting.class, oamStationTestingId);
			oldOamStationTesting.setOamProjectTesting(oamStationTesting.getOamProjectTesting());
			oldOamStationTesting.setOamBaseStation(oamStationTesting.getOamBaseStation());
			oldOamStationTesting.setEntrance(oamStationTesting.getEntrance());
			oldOamStationTesting.setSummit(oamStationTesting.getSummit());
			oldOamStationTesting.setWiring(oamStationTesting.getWiring());
			oldOamStationTesting.setPower(oamStationTesting.getPower());
			oldOamStationTesting.setNetWork(oamStationTesting.getNetWork());
			oldOamStationTesting.setDevSave(oamStationTesting.getDevSave());
			oldOamStationTesting.setOtherGT(oamStationTesting.getOtherGT());
			oldOamStationTesting.setShelterEffectivity(oamStationTesting.getShelterEffectivity());
			oldOamStationTesting.setElectromagneticEffectivity(oamStationTesting.getElectromagneticEffectivity());
			oldOamStationTesting.setObservationStartTime(oamStationTesting.getObservationStartTime());
			oldOamStationTesting.setConnectBJ(oamStationTesting.getConnectBJ());
			oldOamStationTesting.setObservationServices(oamStationTesting.getObservationServices());
			oldOamStationTesting.setObservationEndTime(oamStationTesting.getObservationEndTime());
			oldOamStationTesting.setObservationSize(oamStationTesting.getObservationSize());
			oldOamStationTesting.setDevTrustee(oamStationTesting.getDevTrustee());
			oldOamStationTesting.setContactsTrustee(oamStationTesting.getContactsTrustee());
			oldOamStationTesting.setDataReportValid(oamStationTesting.getDataReportValid());
			oldOamStationTesting.setNetworkValid(oamStationTesting.getNetworkValid());
			oldOamStationTesting.setPowerValid(oamStationTesting.getPowerValid());
			commonDAO.update(oldOamStationTesting);
		}
	}

	public void deleteOamStationTesting(String oamStationTestingIds){
		String[] oamStationTestingIdArray = oamStationTestingIds.split(",");
		for(String oamStationTestingId : oamStationTestingIdArray){
			OamStationTesting oldOamStationTesting = commonDAO.load(OamStationTesting.class, oamStationTestingId);
			oldOamStationTesting.setIsDelete("Y");
			commonDAO.update(oldOamStationTesting);
		}
	}
	
	public void exportOamStationTestings(OamStationTesting oamStationTesting, HttpServletResponse response) throws Exception{
		String hql = "from OamStationTesting where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(oamStationTesting.getOamProjectTesting() != null && StringUtils.isNotBlank(oamStationTesting.getOamProjectTesting().getOamProjectTestingId())){
			hql += " and oamProjectTesting.oamProjectTestingId = :oamProjectTestingId";
			params.put("oamProjectTestingId", oamStationTesting.getOamProjectTesting().getOamProjectTestingId());
		}
		if(oamStationTesting.getOamBaseStation() != null && StringUtils.isNotBlank(oamStationTesting.getOamBaseStation().getOamBaseStationId())){
			hql += " and oamBaseStation.oamBaseStationId = :oamBaseStationId";
			params.put("oamBaseStationId", oamStationTesting.getOamBaseStation().getOamBaseStationId());
		}
		List<OamStationTesting> oamStationTestings = commonDAO.queryList(hql, params);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("基站测试信息");
		sheet.setDefaultColumnWidth(20);
		HSSFRow row = sheet.createRow(0);
		String[] headers = {"所属项目测试","基站","进场","登顶","布线","电源","网络","设备保存","其他沟通项目","遮挡环境是否达标","电磁环境是否达标","连续观测开始时间","连接北京服务器是否成功","主机安放位置是否考察","连续观测结束时间","建站尺寸测量是否完成","收取仪器托管人","托管人联系方式","数据报告是否合格","网络情况是否合格","电力情况是否合格"};
		PoiExporter.fillHeader(row, headers);
		int i = 1;
		HSSFCell cell;
		for(OamStationTesting oamStationTestingData : oamStationTestings){
			row = sheet.createRow(i);
			cell = row.createCell(0);
			if(oamStationTestingData.getOamProjectTesting() != null){
				cell.setCellValue(oamStationTestingData.getOamProjectTesting().getOamProjectTestingName());
			}
			cell = row.createCell(1);
			if(oamStationTestingData.getOamBaseStation() != null){
				cell.setCellValue(oamStationTestingData.getOamBaseStation().getOamBaseStationName());
			}
			cell = row.createCell(2);
			if(oamStationTestingData.getEntrance() != null){
				cell.setCellValue(oamStationTestingData.getEntranceName());
			}
			cell = row.createCell(3);
			if(oamStationTestingData.getSummit() != null){
				cell.setCellValue(oamStationTestingData.getSummitName());
			}
			cell = row.createCell(4);
			if(oamStationTestingData.getWiring() != null){
				cell.setCellValue(oamStationTestingData.getWiringName());
			}
			cell = row.createCell(5);
			if(oamStationTestingData.getPower() != null){
				cell.setCellValue(oamStationTestingData.getPowerName());
			}
			cell = row.createCell(6);
			if(oamStationTestingData.getNetWork() != null){
				cell.setCellValue(oamStationTestingData.getNetWorkName());
			}
			cell = row.createCell(7);
			if(oamStationTestingData.getDevSave() != null){
				cell.setCellValue(oamStationTestingData.getDevSaveName());
			}
			cell = row.createCell(8);
			if(oamStationTestingData.getOtherGT() != null){
				cell.setCellValue(oamStationTestingData.getOtherGT());
			}
			cell = row.createCell(9);
			if(oamStationTestingData.getShelterEffectivity() != null){
				cell.setCellValue(oamStationTestingData.getShelterEffectivityName());
			}
			cell = row.createCell(10);
			if(oamStationTestingData.getElectromagneticEffectivity() != null){
				cell.setCellValue(oamStationTestingData.getElectromagneticEffectivityName());
			}
			cell = row.createCell(11);
			if(oamStationTestingData.getObservationStartTime() != null){
				cell.setCellValue(StringUtil.formatDateTime(oamStationTestingData.getObservationStartTime()));
			}
			cell = row.createCell(12);
			if(oamStationTestingData.getConnectBJ() != null){
				cell.setCellValue(oamStationTestingData.getConnectBJName());
			}
			cell = row.createCell(13);
			if(oamStationTestingData.getObservationServices() != null){
				cell.setCellValue(oamStationTestingData.getObservationServicesName());
			}
			cell = row.createCell(14);
			if(oamStationTestingData.getObservationEndTime() != null){
				cell.setCellValue(StringUtil.formatDateTime(oamStationTestingData.getObservationEndTime()));
			}
			cell = row.createCell(15);
			if(oamStationTestingData.getObservationSize() != null){
				cell.setCellValue(oamStationTestingData.getObservationSizeName());
			}
			cell = row.createCell(16);
			if(oamStationTestingData.getDevTrustee() != null){
				cell.setCellValue(oamStationTestingData.getDevTrustee());
			}
			cell = row.createCell(17);
			if(oamStationTestingData.getContactsTrustee() != null){
				cell.setCellValue(oamStationTestingData.getContactsTrustee());
			}
			cell = row.createCell(18);
			if(oamStationTestingData.getDataReportValid() != null){
				cell.setCellValue(oamStationTestingData.getDataReportValidName());
			}
			cell = row.createCell(19);
			if(oamStationTestingData.getNetworkValid() != null){
				cell.setCellValue(oamStationTestingData.getNetworkValidName());
			}
			cell = row.createCell(20);
			if(oamStationTestingData.getPowerValid() != null){
				cell.setCellValue(oamStationTestingData.getPowerValidName());
			}
			i++;
		}
		response.setHeader("Content-Disposition", "attachment; filename=" 
				+ java.net.URLEncoder.encode("基站测试信息.xls", "UTF-8"));
		OutputStream os = response.getOutputStream();
		workbook.write(os);
		os.close();
	}
	
	public void saveStationTest(OamStationTesting oamStationTesting) {
		String hql = "from OamStationTesting where oamStationTestingId = ?";
		OamStationTesting oldStationTest = commonDAO.getByVariableParam(hql, oamStationTesting.getOamStationTestingId());
		if(oldStationTest != null){
			oldStationTest.setConnectBJ(oamStationTesting.getConnectBJ());
			oldStationTest.setContactsTrustee(oamStationTesting.getContactsTrustee());
			oldStationTest.setDataReportValid(oamStationTesting.getDataReportValid());
			oldStationTest.setDevSave(oamStationTesting.getDevSave());
			oldStationTest.setDevTrustee(oamStationTesting.getDevTrustee());
			oldStationTest.setElectromagneticEffectivity(oamStationTesting.getElectromagneticEffectivity());
			oldStationTest.setEntrance(oamStationTesting.getEntrance());
			oldStationTest.setNetWork(oamStationTesting.getNetWork());
			oldStationTest.setNetworkValid(oamStationTesting.getNetworkValid());
			oldStationTest.setObservationEndTime(oamStationTesting.getObservationEndTime());
			oldStationTest.setObservationServices(oamStationTesting.getObservationServices());
			oldStationTest.setObservationSize(oamStationTesting.getObservationSize());
			oldStationTest.setObservationStartTime(oamStationTesting.getObservationStartTime());
			oldStationTest.setOtherGT(oamStationTesting.getOtherGT());
			oldStationTest.setPower(oamStationTesting.getPower());
			oldStationTest.setPowerValid(oamStationTesting.getPowerValid());
			oldStationTest.setShelterEffectivity(oamStationTesting.getShelterEffectivity());
			oldStationTest.setSummit(oamStationTesting.getSummit());
			oldStationTest.setWiring(oamStationTesting.getWiring());
			commonDAO.update(oldStationTest);
		}else{
			hql = "select p from OamProject p,OamBaseStation s"
					+ " where p.oamProjectCode=s.oamProject.oamProjectCode and s.oamBaseStationId=?";
			OamProject oamProject = commonDAO.getByVariableParam(hql, oamStationTesting.getOamBaseStation().getOamBaseStationId());
			if(oamProject != null){
				hql = "from ProjectTest where projectId = ?";
				OamProjectTesting projectTest = commonDAO.getByVariableParam(hql, oamProject.getOamProjectId());
				if(projectTest == null){
					projectTest = new OamProjectTesting();
					projectTest.setOamProject(oamProject);
					commonDAO.save(projectTest);
				}
				oamStationTesting.setOamStationTestingId(projectTest.getOamProjectTestingId());
			}
			commonDAO.save(oamStationTesting);
		}
	}
}