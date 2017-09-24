package com.cnten.bdlocation.oamproject.service;

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
import com.cnten.po.OamProject;

@Service
public class OamProjectService {

	@Autowired
	CommonDAO commonDAO;
	
	public Page getOamProjectsPage(OamProject oamProject, Integer pageIndex, Integer pageSize) {
		String hql = "from OamProject where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(oamProject.getOamProjectName())){
			hql += " and oamProjectName like :oamProjectName";
			params.put("oamProjectName", "%"+oamProject.getOamProjectName()+"%");
		}
		if(StringUtils.isNotBlank(oamProject.getOamProjectCode())){
			hql += " and oamProjectCode like :oamProjectCode";
			params.put("oamProjectCode", "%"+oamProject.getOamProjectCode()+"%");
		}
		if(oamProject.getOamCustomer() != null && StringUtils.isNotBlank(oamProject.getOamCustomer().getOamCustomerId())){
			hql += " and oamCustomer.oamCustomerId = :oamCustomerId";
			params.put("oamCustomerId", oamProject.getOamCustomer().getOamCustomerId());
		}
		hql += " order by oamProjectCode";
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}

	public OamProject getOamProject(String oamProjectId) {
		return commonDAO.get(OamProject.class, oamProjectId);
	}

	public void saveOamProject(OamProject oamProject) {
		if(oamProject.getOamCustomer() != null && StringUtils.isBlank(oamProject.getOamCustomer().getOamCustomerId())){
			oamProject.setOamCustomer(null);
		}
		if(oamProject.getUser() != null && StringUtils.isBlank(oamProject.getUser().getUserId())){
			oamProject.setUser(null);
		}
		String oamProjectId = oamProject.getOamProjectId();
		if(StringUtils.isEmpty(oamProjectId)){
			commonDAO.save(oamProject);
		}else{
			OamProject oldOamProject = commonDAO.load(OamProject.class, oamProjectId);
			oldOamProject.setOamProjectName(oamProject.getOamProjectName());
			oldOamProject.setOamProjectCode(oamProject.getOamProjectCode());
			oldOamProject.setOamCustomer(oamProject.getOamCustomer());
			oldOamProject.setUser(oamProject.getUser());
			oldOamProject.setStationNum(oamProject.getStationNum());
			oldOamProject.setProgramme(oamProject.getProgramme());
			oldOamProject.setInstallationSite(oamProject.getInstallationSite());
			oldOamProject.setIpAddress(oamProject.getIpAddress());
			oldOamProject.setElectrification(oamProject.getElectrification());
			oldOamProject.setServers(oamProject.getServers());
			oldOamProject.setServersPort(oamProject.getServersPort());
			oldOamProject.setRemote(oamProject.getRemote());
			oldOamProject.setAccendant(oamProject.getAccendant());
			oldOamProject.setLocalPrincipalInfo(oamProject.getLocalPrincipalInfo());
			oldOamProject.setLocalCooperateInfo(oamProject.getLocalCooperateInfo());
			oldOamProject.setPreliminaryMeeting(oamProject.getPreliminaryMeeting());
			oldOamProject.setDriver(oamProject.getDriver());
			oldOamProject.setConstructionTeam(oamProject.getConstructionTeam());
			oldOamProject.setInstrument(oamProject.getInstrument());
			oldOamProject.setTestingDev(oamProject.getTestingDev());
			oldOamProject.setMainFrameRegister(oamProject.getMainFrameRegister());
			oldOamProject.setNrs(oamProject.getNrs());
			oldOamProject.setImplementation(oamProject.getImplementation());
			oldOamProject.setTrainOrFlight(oamProject.getTrainOrFlight());
			oldOamProject.setGrogshop(oamProject.getGrogshop());
			commonDAO.update(oldOamProject);
		}
	}

	public void deleteOamProject(String oamProjectIds){
		String[] oamProjectIdArray = oamProjectIds.split(",");
		for(String oamProjectId : oamProjectIdArray){
			OamProject oldOamProject = commonDAO.load(OamProject.class, oamProjectId);
			oldOamProject.setIsDelete("Y");
			commonDAO.update(oldOamProject);
		}
	}
	
	public void exportOamProjects(OamProject oamProject, HttpServletResponse response) throws Exception{
		String hql = "from OamProject where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(oamProject.getOamProjectName())){
			hql += " and oamProjectName like :oamProjectName";
			params.put("oamProjectName", "%"+oamProject.getOamProjectName()+"%");
		}
		if(StringUtils.isNotBlank(oamProject.getOamProjectCode())){
			hql += " and oamProjectCode like :oamProjectCode";
			params.put("oamProjectCode", "%"+oamProject.getOamProjectCode()+"%");
		}
		if(oamProject.getOamCustomer() != null && StringUtils.isNotBlank(oamProject.getOamCustomer().getOamCustomerId())){
			hql += " and oamCustomer.oamCustomerId = :oamCustomerId";
			params.put("oamCustomerId", oamProject.getOamCustomer().getOamCustomerId());
		}
		List<OamProject> oamProjects = commonDAO.queryList(hql, params);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("项目信息");
		sheet.setDefaultColumnWidth(20);
		HSSFRow row = sheet.createRow(0);
		String[] headers = {"项目名称","项目编号","所属客户","记录人","建站数量","规划数量","服务器安装位置","服务器IP","不间断供电","准备服务器","开通服务器相应端口","开通远程桌面","服务器维护方","当地负责人员及联系方式","当地配合人员及联系方式","召开建站筹备会议","车辆司机","施工队伍及联系方式","建站仪器","测试设备","主机注册","NRS软件狗","实施人员","车次或航班号","酒店"};
		PoiExporter.fillHeader(row, headers);
		int i = 1;
		HSSFCell cell;
		for(OamProject oamProjectData : oamProjects){
			row = sheet.createRow(i);
			cell = row.createCell(0);
			if(oamProjectData.getOamProjectName() != null){
				cell.setCellValue(oamProjectData.getOamProjectName());
			}
			cell = row.createCell(1);
			if(oamProjectData.getOamProjectCode() != null){
				cell.setCellValue(oamProjectData.getOamProjectCode());
			}
			cell = row.createCell(2);
			if(oamProjectData.getOamCustomer() != null){
				cell.setCellValue(oamProjectData.getOamCustomer().getOamCustomerName());
			}
			cell = row.createCell(3);
			if(oamProjectData.getUser() != null){
				cell.setCellValue(oamProjectData.getUser().getUserName());
			}
			cell = row.createCell(4);
			if(oamProjectData.getStationNum() != null){
				cell.setCellValue(oamProjectData.getStationNum());
			}
			cell = row.createCell(5);
			if(oamProjectData.getProgramme() != null){
				cell.setCellValue(oamProjectData.getProgramme());
			}
			cell = row.createCell(6);
			if(oamProjectData.getInstallationSite() != null){
				cell.setCellValue(oamProjectData.getInstallationSite());
			}
			cell = row.createCell(7);
			if(oamProjectData.getIpAddress() != null){
				cell.setCellValue(oamProjectData.getIpAddress());
			}
			cell = row.createCell(8);
			if(oamProjectData.getElectrification() != null){
				cell.setCellValue(oamProjectData.getElectrificationName());
			}
			cell = row.createCell(9);
			if(oamProjectData.getServers() != null){
				cell.setCellValue(oamProjectData.getServersName());
			}
			cell = row.createCell(10);
			if(oamProjectData.getServersPort() != null){
				cell.setCellValue(oamProjectData.getServersPort());
			}
			cell = row.createCell(11);
			if(oamProjectData.getRemote() != null){
				cell.setCellValue(oamProjectData.getRemoteName());
			}
			cell = row.createCell(12);
			if(oamProjectData.getAccendant() != null){
				cell.setCellValue(oamProjectData.getAccendant());
			}
			cell = row.createCell(13);
			if(oamProjectData.getLocalPrincipalInfo() != null){
				cell.setCellValue(oamProjectData.getLocalPrincipalInfo());
			}
			cell = row.createCell(14);
			if(oamProjectData.getLocalCooperateInfo() != null){
				cell.setCellValue(oamProjectData.getLocalCooperateInfo());
			}
			cell = row.createCell(15);
			if(oamProjectData.getPreliminaryMeeting() != null){
				cell.setCellValue(oamProjectData.getPreliminaryMeeting());
			}
			cell = row.createCell(16);
			if(oamProjectData.getDriver() != null){
				cell.setCellValue(oamProjectData.getDriver());
			}
			cell = row.createCell(17);
			if(oamProjectData.getConstructionTeam() != null){
				cell.setCellValue(oamProjectData.getConstructionTeam());
			}
			cell = row.createCell(18);
			if(oamProjectData.getInstrument() != null){
				cell.setCellValue(oamProjectData.getInstrument());
			}
			cell = row.createCell(19);
			if(oamProjectData.getTestingDev() != null){
				cell.setCellValue(oamProjectData.getTestingDev());
			}
			cell = row.createCell(20);
			if(oamProjectData.getMainFrameRegister() != null){
				cell.setCellValue(oamProjectData.getMainFrameRegister());
			}
			cell = row.createCell(21);
			if(oamProjectData.getNrs() != null){
				cell.setCellValue(oamProjectData.getNrs());
			}
			cell = row.createCell(22);
			if(oamProjectData.getImplementation() != null){
				cell.setCellValue(oamProjectData.getImplementation());
			}
			cell = row.createCell(23);
			if(oamProjectData.getTrainOrFlight() != null){
				cell.setCellValue(oamProjectData.getTrainOrFlight());
			}
			cell = row.createCell(24);
			if(oamProjectData.getGrogshop() != null){
				cell.setCellValue(oamProjectData.getGrogshop());
			}
			i++;
		}
		response.setHeader("Content-Disposition", "attachment; filename=" 
				+ java.net.URLEncoder.encode("项目信息.xls", "UTF-8"));
		OutputStream os = response.getOutputStream();
		workbook.write(os);
		os.close();
	}
}