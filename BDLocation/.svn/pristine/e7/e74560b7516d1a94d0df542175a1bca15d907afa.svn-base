package com.cnten.bdlocation.oambasestation.service;

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

import com.cnten.bdlocation.oamarea.service.OamAreaService;
import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.export.PoiExporter;
import com.cnten.po.OamArea;
import com.cnten.po.OamBaseStation;
import com.cnten.po.OamProject;
import com.cnten.po.OamStationAddress;
import com.cnten.vo.OamBaseStationVO;

@Service
public class OamBaseStationService {

	@Autowired
	CommonDAO commonDAO;
	@Autowired
	private OamAreaService oamAreaService;
	public Page getOamBaseStationsPage(OamBaseStation oamBaseStation, Integer pageIndex, Integer pageSize) {
		String hql = "from OamBaseStation where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
	
		if(oamBaseStation.getOamArea() != null && StringUtils.isNotBlank(oamBaseStation.getOamArea().getOamAreaId())){
			OamArea oamArea = oamBaseStation.getOamArea();
			List<OamArea> oamAreas = oamAreaService.getOamAreas();
			List<String> ids = new ArrayList<>();
			ids.add(oamArea.getOamAreaId());
			addChildren(oamArea, oamAreas, ids);
			hql += " and oamArea.oamAreaId in(:ids)";
			params.put("ids", ids.toArray());
		}
		
		hql += " order by oamArea,oamBaseStationCode";
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}
	
	private void addChildren(OamArea oamArea,List<OamArea> oamAreas,List<String> ids){
		for(OamArea m : oamAreas){
			if(oamArea.getOamAreaId().equals(m.getParentId())){
				ids.add(m.getOamAreaId());
				addChildren(m, oamAreas, ids);
			}
		}
	}

	public OamBaseStation getOamBaseStation(String oamBaseStationId) {
		return commonDAO.get(OamBaseStation.class, oamBaseStationId);
	}
	
	public List<OamBaseStation> getOamBaseStations(String oamAreaId) {
 		String hql = "from OamBaseStation where isDelete is null and isEffectivity=1 and oamArea.oamAreaId = ? order by oamProject";
 		return commonDAO.queryListByVariableParam(hql, oamAreaId);
 	}

	public void saveOamBaseStation(OamBaseStation oamBaseStation) {
		if(oamBaseStation.getOamArea() != null && StringUtils.isBlank(oamBaseStation.getOamArea().getOamAreaId())){
			oamBaseStation.setOamArea(null);
		}
		if(oamBaseStation.getOamProject() != null && StringUtils.isBlank(oamBaseStation.getOamProject().getOamProjectId())){
			oamBaseStation.setOamProject(null);
		}
		String oamBaseStationId = oamBaseStation.getOamBaseStationId();
		if(StringUtils.isEmpty(oamBaseStationId)){
			commonDAO.save(oamBaseStation);
		}else{
			OamBaseStation oldOamBaseStation = commonDAO.load(OamBaseStation.class, oamBaseStationId);
			oldOamBaseStation.setOamArea(oamBaseStation.getOamArea());
			oldOamBaseStation.setOamProject(oamBaseStation.getOamProject());
			oldOamBaseStation.setOamBaseStationName(oamBaseStation.getOamBaseStationName());
			oldOamBaseStation.setShortName(oamBaseStation.getShortName());
			oldOamBaseStation.setOamBaseStationCode(oamBaseStation.getOamBaseStationCode());
			oldOamBaseStation.setNfCode(oamBaseStation.getNfCode());
			oldOamBaseStation.setBuildStage(oamBaseStation.getBuildStage());
			oldOamBaseStation.setIsEffectivity(oamBaseStation.getIsEffectivity());
			oldOamBaseStation.setLongitude(oamBaseStation.getLongitude());
			oldOamBaseStation.setLatitude(oamBaseStation.getLatitude());
			oldOamBaseStation.setState(oamBaseStation.getState());
			commonDAO.update(oldOamBaseStation);
		}
	}

	public void deleteOamBaseStation(String oamBaseStationIds){
		String[] oamBaseStationIdArray = oamBaseStationIds.split(",");
		for(String oamBaseStationId : oamBaseStationIdArray){
			OamBaseStation oldOamBaseStation = commonDAO.load(OamBaseStation.class, oamBaseStationId);
			oldOamBaseStation.setIsDelete("Y");
			commonDAO.update(oldOamBaseStation);
		}
	}
	
	public void exportOamBaseStations(OamBaseStation oamBaseStation, HttpServletResponse response) throws Exception{
		String hql = "from OamBaseStation where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(oamBaseStation.getOamArea() != null && StringUtils.isNotBlank(oamBaseStation.getOamArea().getOamAreaId())){
			hql += " and oamArea.oamAreaId = :oamAreaId";
			params.put("oamAreaId", oamBaseStation.getOamArea().getOamAreaId());
		}
		List<OamBaseStation> oamBaseStations = commonDAO.queryList(hql, params);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("基站信息");
		sheet.setDefaultColumnWidth(20);
		HSSFRow row = sheet.createRow(0);
		String[] headers = {"所属地区","所属项目","基站名称","基站简称","基站编号","南方测绘编号","建设阶段","是否有效","经度","纬度","状态"};
		PoiExporter.fillHeader(row, headers);
		int i = 1;
		HSSFCell cell;
		for(OamBaseStation oamBaseStationData : oamBaseStations){
			row = sheet.createRow(i);
			cell = row.createCell(0);
			if(oamBaseStationData.getOamArea() != null){
				cell.setCellValue(oamBaseStationData.getOamArea().getOamAreaName());
			}
			cell = row.createCell(1);
			if(oamBaseStationData.getOamProject() != null){
				cell.setCellValue(oamBaseStationData.getOamProject().getOamProjectName());
			}
			cell = row.createCell(2);
			if(oamBaseStationData.getOamBaseStationName() != null){
				cell.setCellValue(oamBaseStationData.getOamBaseStationName());
			}
			cell = row.createCell(3);
			if(oamBaseStationData.getShortName() != null){
				cell.setCellValue(oamBaseStationData.getShortName());
			}
			cell = row.createCell(4);
			if(oamBaseStationData.getOamBaseStationCode() != null){
				cell.setCellValue(oamBaseStationData.getOamBaseStationCode());
			}
			cell = row.createCell(5);
			if(oamBaseStationData.getNfCode() != null){
				cell.setCellValue(oamBaseStationData.getNfCode());
			}
			cell = row.createCell(6);
			if(oamBaseStationData.getBuildStage() != null){
				cell.setCellValue(oamBaseStationData.getBuildStageName());
			}
			cell = row.createCell(7);
			if(oamBaseStationData.getIsEffectivity() != null){
				cell.setCellValue(oamBaseStationData.getIsEffectivityName());
			}
			cell = row.createCell(8);
			if(oamBaseStationData.getLongitude() != null){
				cell.setCellValue(oamBaseStationData.getLongitude());
			}
			cell = row.createCell(9);
			if(oamBaseStationData.getLatitude() != null){
				cell.setCellValue(oamBaseStationData.getLatitude());
			}
			cell = row.createCell(10);
			if(oamBaseStationData.getState() != null){
				cell.setCellValue(oamBaseStationData.getStateName());
			}
			i++;
		}
		response.setHeader("Content-Disposition", "attachment; filename=" 
				+ java.net.URLEncoder.encode("基站信息.xls", "UTF-8"));
		OutputStream os = response.getOutputStream();
		workbook.write(os);
		os.close();
	}
	
	public List<OamBaseStation> getMonitorStations(String oamAreaId) {
 		String hql = "from OamBaseStation where isDelete is null and isEffectivity='1' and buildStage='1' and oamArea.oamAreaId = ? order by oamProject";
 		return commonDAO.queryListByVariableParam(hql, oamAreaId);
 	}
	
	public OamBaseStationVO getOamBaseStationVO(String oamBaseStationId) {
		OamBaseStation station = commonDAO.get(OamBaseStation.class, oamBaseStationId);
 		OamBaseStationVO stationVO = new OamBaseStationVO();
 		stationVO.setOamBaseStationId(oamBaseStationId);
 		stationVO.setOamBaseStationName(station.getOamBaseStationName());
 		String oamProjectCode = station.getOamProject() == null ? null:station.getOamProject().getOamProjectCode();
 		String oamProjectName = station.getOamProject() == null ? null:station.getOamProject().getOamProjectName();
 		String oamCustomerName = (station.getOamProject() == null || station.getOamProject().getOamCustomer() == null) ? "":station.getOamProject().getOamCustomer().getOamCustomerName();
 		stationVO.setProjectCode(oamProjectCode);
 		stationVO.setProjectName(oamProjectName);
 		stationVO.setCustomerName(oamCustomerName);
 		stationVO.setStationCode(station.getOamBaseStationCode());
 		stationVO.setNfCode(station.getNfCode());
 		stationVO.setBuildStage(station.getBuildStage());
 		stationVO.setIsEffectivity(station.getIsEffectivity());
 		String hql = "from OamStationAddress where isDelete is null and oamBaseStation.oamBaseStationId = ?";
 		OamStationAddress stationAddress = commonDAO.getByVariableParam(hql, oamBaseStationId);
 		if(stationAddress != null){
 			stationVO.setAddress(stationAddress.getAddress());
 			stationVO.setContacts(stationAddress.getContacts());
 			stationVO.setContact(stationAddress.getContact());
 			stationVO.setShelterInfo(stationAddress.getShelterInfo());
 			stationVO.setInterferenceInfo(stationAddress.getInterferenceInfo());
 			stationVO.setElectrification220(stationAddress.getElectrification220());
 			stationVO.setElectrification(stationAddress.getElectrification());
 			stationVO.setwAN(stationAddress.getWAN());
 			stationVO.setOut2M(stationAddress.getOut2M());
 			stationVO.setiPInfo(stationAddress.getIpInfo());
 			stationVO.setaDSL(stationAddress.getADSL());
 			stationVO.setOpticalFiber(stationAddress.getOpticalFiber());
 			stationVO.setInterchanger(stationAddress.getInterchanger());
 			stationVO.setRouter(stationAddress.getRouter());
 			stationVO.setOtherNetwork(stationAddress.getOtherNetwork());
 			stationVO.setLightningShielding(stationAddress.getLightningShielding());
 			stationVO.setLightningArrester(stationAddress.getLightningArrester());
 			stationVO.setLightningNetWork(stationAddress.getLightningNetWork());
 			stationVO.setOtherArrester(stationAddress.getOtherArrester());
 			stationVO.setSmoothRoof(stationAddress.getSmoothRoof());
 			stationVO.setNickelcladRoof(stationAddress.getNickelcladRoof());
 			stationVO.setOtherRoof(stationAddress.getOtherRoof());
 			stationVO.setUsedWaterproofer(stationAddress.getUsedWaterproofer());
 			stationVO.setWaterprooferInfo(stationAddress.getWaterprooferInfo());
 			stationVO.setUsedPapers(stationAddress.getUsedPapers());
 			stationVO.setPapersInfo(stationAddress.getPapersInfo());
 			stationVO.setComment(stationAddress.getRemark());
 		}
 		return stationVO;
 	}
	
	public void saveStationVO(OamBaseStationVO stationVO) {
		OamBaseStation station = commonDAO.get(OamBaseStation.class, stationVO.getOamBaseStationId());
		if(station == null){
 			station = new OamBaseStation();
 			station.setOamArea(commonDAO.get(OamArea.class, stationVO.getOamAreaId()));
 			station.setLongitude(stationVO.getLongitude());
 			station.setLatitude(stationVO.getLatitude());
 		}
		String hql = "from OamProject where isDelete is null and oamProjectCode = ?";
		OamProject project = commonDAO.getByVariableParam(hql, stationVO.getProjectCode());
		if(null == project) {
			project = new OamProject();
			project.setOamProjectCode(stationVO.getProjectCode());
			commonDAO.save(project);
		}
 		station.setOamBaseStationName(stationVO.getOamBaseStationName());
 		station.setOamProject(project);
 		station.setOamBaseStationCode(stationVO.getStationCode());
 		station.setNfCode(stationVO.getNfCode());
 		station.setBuildStage(stationVO.getBuildStage());
 		station.setIsEffectivity(stationVO.getIsEffectivity());
 		if(station.getOamBaseStationId() == null){
 			commonDAO.save(station);
 		}else{
 			commonDAO.update(station);
 		}
 		hql = "from OamStationAddress where isDelete is null and oamBaseStation.oamBaseStationId = ?";
 		OamStationAddress stationAddress = commonDAO.getByVariableParam(hql, station.getOamBaseStationId());
 		if(stationAddress == null){
 			stationAddress = new OamStationAddress();
 			stationAddress.setOamBaseStation(station);
 			if(project != null){
 				stationAddress.setOamProject(project);
 			}
 		}
 		stationAddress.setAddress(stationVO.getAddress());
 		stationAddress.setContacts(stationVO.getContacts());
 		stationAddress.setContact(stationVO.getContact());
 		stationAddress.setShelterInfo(stationVO.getShelterInfo());
 		stationAddress.setInterferenceInfo(stationVO.getInterferenceInfo());
 		stationAddress.setElectrification220(stationVO.getElectrification220());
 		stationAddress.setElectrification(stationVO.getElectrification());
 		stationAddress.setWAN(stationVO.getwAN());
 		stationAddress.setOut2M(stationVO.getOut2M());
 		stationAddress.setIpInfo(stationVO.getiPInfo());
 		stationAddress.setADSL(stationVO.getaDSL());
 		stationAddress.setOpticalFiber(stationVO.getOpticalFiber());
 		stationAddress.setInterchanger(stationVO.getInterchanger());
 		stationAddress.setRouter(stationVO.getRouter());
 		stationAddress.setOtherNetwork(stationVO.getOtherNetwork());
 		stationAddress.setLightningShielding(stationVO.getLightningShielding());
 		stationAddress.setLightningArrester(stationVO.getLightningArrester());
 		stationAddress.setLightningNetWork(stationVO.getLightningNetWork());
 		stationAddress.setOtherArrester(stationVO.getOtherArrester());
 		stationAddress.setSmoothRoof(stationVO.getSmoothRoof());
 		stationAddress.setNickelcladRoof(stationVO.getNickelcladRoof());
 		stationAddress.setOtherRoof(stationVO.getOtherRoof());
 		stationAddress.setUsedWaterproofer(stationVO.getUsedWaterproofer());
 		stationAddress.setWaterprooferInfo(stationVO.getWaterprooferInfo());
 		stationAddress.setUsedPapers(stationVO.getUsedPapers());
 		stationAddress.setPapersInfo(stationVO.getPapersInfo());
 		stationAddress.setRemark(stationVO.getComment());
 		if(stationAddress.getOamStationAddressId() == null){
 			commonDAO.save(stationAddress);
 		}else{
 			commonDAO.update(stationAddress);
 		}
 		stationVO.setOamBaseStationId(station.getOamBaseStationId());
 	}
}