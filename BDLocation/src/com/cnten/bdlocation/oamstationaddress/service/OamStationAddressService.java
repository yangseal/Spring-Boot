package com.cnten.bdlocation.oamstationaddress.service;

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
import com.cnten.po.OamStationAddress;

@Service
public class OamStationAddressService {

	@Autowired
	CommonDAO commonDAO;
	
	public Page getOamStationAddresssPage(OamStationAddress oamStationAddress, Integer pageIndex, Integer pageSize) {
		String hql = "from OamStationAddress where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(oamStationAddress.getOamProject() != null && StringUtils.isNotBlank(oamStationAddress.getOamProject().getOamProjectId())){
			hql += " and oamProject.oamProjectId = :oamProjectId";
			params.put("oamProjectId", oamStationAddress.getOamProject().getOamProjectId());
		}
		if(oamStationAddress.getOamBaseStation() != null && StringUtils.isNotBlank(oamStationAddress.getOamBaseStation().getOamBaseStationId())){
			hql += " and oamBaseStation.oamBaseStationId = :oamBaseStationId";
			params.put("oamBaseStationId", oamStationAddress.getOamBaseStation().getOamBaseStationId());
		}
		hql += " order by oamProject,oamBaseStation";
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}

	public OamStationAddress getOamStationAddress(String oamStationAddressId) {
		return commonDAO.get(OamStationAddress.class, oamStationAddressId);
	}
	
	public OamStationAddress getAddressByStationId(String oamBaseStationId) {
		String hql = "from OamStationAddress where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		hql += " and oamBaseStation.oamBaseStationId = :oamBaseStationId";
		params.put("oamBaseStationId", oamBaseStationId);
		return commonDAO.get(hql, params);
	}

	public void saveOamStationAddress(OamStationAddress oamStationAddress) {
		if(oamStationAddress.getOamProject() != null && StringUtils.isBlank(oamStationAddress.getOamProject().getOamProjectId())){
			oamStationAddress.setOamProject(null);
		}
		if(oamStationAddress.getOamBaseStation() != null && StringUtils.isBlank(oamStationAddress.getOamBaseStation().getOamBaseStationId())){
			oamStationAddress.setOamBaseStation(null);
		}
		String oamStationAddressId = oamStationAddress.getOamStationAddressId();
		if(StringUtils.isEmpty(oamStationAddressId)){
			commonDAO.save(oamStationAddress);
		}else{
			OamStationAddress oldOamStationAddress = commonDAO.load(OamStationAddress.class, oamStationAddressId);
			oldOamStationAddress.setOamProject(oamStationAddress.getOamProject());
			oldOamStationAddress.setOamBaseStation(oamStationAddress.getOamBaseStation());
			oldOamStationAddress.setAddress(oamStationAddress.getAddress());
			oldOamStationAddress.setContacts(oamStationAddress.getContacts());
			oldOamStationAddress.setContact(oamStationAddress.getContact());
			oldOamStationAddress.setShelterInfo(oamStationAddress.getShelterInfo());
			oldOamStationAddress.setInterferenceInfo(oamStationAddress.getInterferenceInfo());
			oldOamStationAddress.setElectrification220(oamStationAddress.getElectrification220());
			oldOamStationAddress.setElectrification(oamStationAddress.getElectrification());
			oldOamStationAddress.setWAN(oamStationAddress.getWAN());
			oldOamStationAddress.setOut2M(oamStationAddress.getOut2M());
			oldOamStationAddress.setIpInfo(oamStationAddress.getIpInfo());
			oldOamStationAddress.setADSL(oamStationAddress.getADSL());
			oldOamStationAddress.setOpticalFiber(oamStationAddress.getOpticalFiber());
			oldOamStationAddress.setInterchanger(oamStationAddress.getInterchanger());
			oldOamStationAddress.setRouter(oamStationAddress.getRouter());
			oldOamStationAddress.setOtherNetwork(oamStationAddress.getOtherNetwork());
			oldOamStationAddress.setLightningShielding(oamStationAddress.getLightningShielding());
			oldOamStationAddress.setLightningArrester(oamStationAddress.getLightningArrester());
			oldOamStationAddress.setLightningNetWork(oamStationAddress.getLightningNetWork());
			oldOamStationAddress.setOtherArrester(oamStationAddress.getOtherArrester());
			oldOamStationAddress.setSmoothRoof(oamStationAddress.getSmoothRoof());
			oldOamStationAddress.setNickelcladRoof(oamStationAddress.getNickelcladRoof());
			oldOamStationAddress.setOtherRoof(oamStationAddress.getOtherRoof());
			oldOamStationAddress.setUsedWaterproofer(oamStationAddress.getUsedWaterproofer());
			oldOamStationAddress.setWaterprooferInfo(oamStationAddress.getWaterprooferInfo());
			oldOamStationAddress.setUsedPapers(oamStationAddress.getUsedPapers());
			oldOamStationAddress.setPapersInfo(oamStationAddress.getPapersInfo());
			oldOamStationAddress.setRemark(oamStationAddress.getRemark());
			commonDAO.update(oldOamStationAddress);
		}
	}

	public void deleteOamStationAddress(String oamStationAddressIds){
		String[] oamStationAddressIdArray = oamStationAddressIds.split(",");
		for(String oamStationAddressId : oamStationAddressIdArray){
			OamStationAddress oldOamStationAddress = commonDAO.load(OamStationAddress.class, oamStationAddressId);
			oldOamStationAddress.setIsDelete("Y");
			commonDAO.update(oldOamStationAddress);
		}
	}
	
	public void exportOamStationAddresss(OamStationAddress oamStationAddress, HttpServletResponse response) throws Exception{
		String hql = "from OamStationAddress where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(oamStationAddress.getOamProject() != null && StringUtils.isNotBlank(oamStationAddress.getOamProject().getOamProjectId())){
			hql += " and oamProject.oamProjectId = :oamProjectId";
			params.put("oamProjectId", oamStationAddress.getOamProject().getOamProjectId());
		}
		if(oamStationAddress.getOamBaseStation() != null && StringUtils.isNotBlank(oamStationAddress.getOamBaseStation().getOamBaseStationId())){
			hql += " and oamBaseStation.oamBaseStationId = :oamBaseStationId";
			params.put("oamBaseStationId", oamStationAddress.getOamBaseStation().getOamBaseStationId());
		}
		List<OamStationAddress> oamStationAddresss = commonDAO.queryList(hql, params);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("基站选址信息");
		sheet.setDefaultColumnWidth(20);
		HSSFRow row = sheet.createRow(0);
		String[] headers = {"所属项目","基站","地址","联系人","联系方式","遮挡物及程度","干扰源及程度","不间断供电220V","不间断网络","外网","独占带宽大于2M","固定IP情况及说明","ADSL","光纤","交换机","路由器","其它网络类别","公共避雷","避雷针","避雷网","其它避雷设施","平整天台","斜面钢板屋顶","其它天台情况","是否有防水层","防水层描述","是否需要特殊证件","特殊证件描述","备注"};
		PoiExporter.fillHeader(row, headers);
		int i = 1;
		HSSFCell cell;
		for(OamStationAddress oamStationAddressData : oamStationAddresss){
			row = sheet.createRow(i);
			cell = row.createCell(0);
			if(oamStationAddressData.getOamProject() != null){
				cell.setCellValue(oamStationAddressData.getOamProject().getOamProjectName());
			}
			cell = row.createCell(1);
			if(oamStationAddressData.getOamBaseStation() != null){
				cell.setCellValue(oamStationAddressData.getOamBaseStation().getOamBaseStationName());
			}
			cell = row.createCell(2);
			if(oamStationAddressData.getAddress() != null){
				cell.setCellValue(oamStationAddressData.getAddress());
			}
			cell = row.createCell(3);
			if(oamStationAddressData.getContacts() != null){
				cell.setCellValue(oamStationAddressData.getContacts());
			}
			cell = row.createCell(4);
			if(oamStationAddressData.getContact() != null){
				cell.setCellValue(oamStationAddressData.getContact());
			}
			cell = row.createCell(5);
			if(oamStationAddressData.getShelterInfo() != null){
				cell.setCellValue(oamStationAddressData.getShelterInfo());
			}
			cell = row.createCell(6);
			if(oamStationAddressData.getInterferenceInfo() != null){
				cell.setCellValue(oamStationAddressData.getInterferenceInfo());
			}
			cell = row.createCell(7);
			if(oamStationAddressData.getElectrification220() != null){
				cell.setCellValue(oamStationAddressData.getElectrification220Name());
			}
			cell = row.createCell(8);
			if(oamStationAddressData.getElectrification() != null){
				cell.setCellValue(oamStationAddressData.getElectrificationName());
			}
			cell = row.createCell(9);
			if(oamStationAddressData.getWAN() != null){
				cell.setCellValue(oamStationAddressData.getWANName());
			}
			cell = row.createCell(10);
			if(oamStationAddressData.getOut2M() != null){
				cell.setCellValue(oamStationAddressData.getOut2MName());
			}
			cell = row.createCell(11);
			if(oamStationAddressData.getIpInfo() != null){
				cell.setCellValue(oamStationAddressData.getIpInfo());
			}
			cell = row.createCell(12);
			if(oamStationAddressData.getADSL() != null){
				cell.setCellValue(oamStationAddressData.getADSLName());
			}
			cell = row.createCell(13);
			if(oamStationAddressData.getOpticalFiber() != null){
				cell.setCellValue(oamStationAddressData.getOpticalFiberName());
			}
			cell = row.createCell(14);
			if(oamStationAddressData.getInterchanger() != null){
				cell.setCellValue(oamStationAddressData.getInterchangerName());
			}
			cell = row.createCell(15);
			if(oamStationAddressData.getRouter() != null){
				cell.setCellValue(oamStationAddressData.getRouterName());
			}
			cell = row.createCell(16);
			if(oamStationAddressData.getOtherNetwork() != null){
				cell.setCellValue(oamStationAddressData.getOtherNetwork());
			}
			cell = row.createCell(17);
			if(oamStationAddressData.getLightningShielding() != null){
				cell.setCellValue(oamStationAddressData.getLightningShieldingName());
			}
			cell = row.createCell(18);
			if(oamStationAddressData.getLightningArrester() != null){
				cell.setCellValue(oamStationAddressData.getLightningArresterName());
			}
			cell = row.createCell(19);
			if(oamStationAddressData.getLightningNetWork() != null){
				cell.setCellValue(oamStationAddressData.getLightningNetWorkName());
			}
			cell = row.createCell(20);
			if(oamStationAddressData.getOtherArrester() != null){
				cell.setCellValue(oamStationAddressData.getOtherArrester());
			}
			cell = row.createCell(21);
			if(oamStationAddressData.getSmoothRoof() != null){
				cell.setCellValue(oamStationAddressData.getSmoothRoofName());
			}
			cell = row.createCell(22);
			if(oamStationAddressData.getNickelcladRoof() != null){
				cell.setCellValue(oamStationAddressData.getNickelcladRoofName());
			}
			cell = row.createCell(23);
			if(oamStationAddressData.getOtherRoof() != null){
				cell.setCellValue(oamStationAddressData.getOtherRoof());
			}
			cell = row.createCell(24);
			if(oamStationAddressData.getUsedWaterproofer() != null){
				cell.setCellValue(oamStationAddressData.getUsedWaterprooferName());
			}
			cell = row.createCell(25);
			if(oamStationAddressData.getWaterprooferInfo() != null){
				cell.setCellValue(oamStationAddressData.getWaterprooferInfo());
			}
			cell = row.createCell(26);
			if(oamStationAddressData.getUsedPapers() != null){
				cell.setCellValue(oamStationAddressData.getUsedPapersName());
			}
			cell = row.createCell(27);
			if(oamStationAddressData.getPapersInfo() != null){
				cell.setCellValue(oamStationAddressData.getPapersInfo());
			}
			cell = row.createCell(28);
			if(oamStationAddressData.getRemark() != null){
				cell.setCellValue(oamStationAddressData.getRemark());
			}
			i++;
		}
		response.setHeader("Content-Disposition", "attachment; filename=" 
				+ java.net.URLEncoder.encode("基站选址信息.xls", "UTF-8"));
		OutputStream os = response.getOutputStream();
		workbook.write(os);
		os.close();
	}
}