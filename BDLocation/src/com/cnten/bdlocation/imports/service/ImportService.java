package com.cnten.bdlocation.imports.service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.po.Company;
import com.cnten.po.CorsAccount;
import com.cnten.po.PointType;
import com.cnten.po.StakeoutPoint;
import com.cnten.po.StakeoutTask;

@Service
public class ImportService {
	
	@Autowired
	CommonDAO commonDAO;
	
	public void saveImportStakeoutTask(String path) throws Exception {
        InputStream is = new FileInputStream(path);
        HSSFWorkbook workbook = new HSSFWorkbook(is);
        Sheet sheet = workbook.getSheetAt(0);
        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
            Row row = sheet.getRow(rowNum);
            if (row != null) {
                Cell stakeoutTaskName_Cell = row.getCell(0);	//任务名称
                Cell taskType_Cell = row.getCell(1);			//任务类型
                Cell taskStatus_Cell = row.getCell(2);			//任务状态
                Cell corsAccountId_Cell = row.getCell(3);		//创建人
                Cell affiliationCompanyId_Cell = row.getCell(4);//所属企业

                String stakeoutTaskName = getValue(stakeoutTaskName_Cell);
                
                String taskType;
                if(getValue(taskType_Cell).equals("点")){
                	taskType = "point";
                }else if(getValue(taskType_Cell).equals("线")){
                	taskType = "line";
                }else{
                	taskType = "";
                }
                
                String taskStatus;
                if(getValue(taskStatus_Cell).equals("新任务")){
                	taskStatus = "newTask";
                }else if(getValue(taskStatus_Cell).equals("已下发")){
                	taskStatus = "issued";
                }else{
                	taskStatus = "";
                }
                
                Date createDate = new Date();
                
                CorsAccount corsAccount = getCorsByCode(getValue(corsAccountId_Cell), getValue(affiliationCompanyId_Cell));
                Company company = getCompanyByCode(getValue(affiliationCompanyId_Cell));
                
                String id;
                if(getStakeoutTaskByName(getValue(stakeoutTaskName_Cell), getValue(affiliationCompanyId_Cell)) == null){
                	id = "";
                }else{
                	id = getStakeoutTaskByName(getValue(stakeoutTaskName_Cell), getValue(affiliationCompanyId_Cell)).getStakeoutTaskId();
                }
                
                if(StringUtils.isEmpty(id)){
                	StakeoutTask stakeoutTask = new StakeoutTask();
                	stakeoutTask.setStakeoutTaskName(stakeoutTaskName);
                	stakeoutTask.setTaskType(taskType);
                	stakeoutTask.setTaskStatus(taskStatus);
                	stakeoutTask.setCreateDate(createDate);
                	stakeoutTask.setCorsAccount(corsAccount);
                	stakeoutTask.setAffiliationCompany(company);
                	commonDAO.save(stakeoutTask);
                }else{
                	StakeoutTask oldStakeoutTask = commonDAO.load(StakeoutTask.class, id);
                	oldStakeoutTask.setStakeoutTaskName(stakeoutTaskName);
                	oldStakeoutTask.setTaskType(taskType);
                	oldStakeoutTask.setTaskStatus(taskStatus);
                	oldStakeoutTask.setCreateDate(createDate);
                	oldStakeoutTask.setCorsAccount(corsAccount);
                	oldStakeoutTask.setAffiliationCompany(company);
                	commonDAO.update(oldStakeoutTask);
                }
            }
        }
	}

	public void saveImportStakeoutPoint(String path) throws Exception {
        InputStream is = new FileInputStream(path);
        HSSFWorkbook workbook = new HSSFWorkbook(is);
        Sheet sheet = workbook.getSheetAt(1);
        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
            Row row = sheet.getRow(rowNum);
            if (row != null) {
                Cell companyCode_Cell = row.getCell(0);					//所属企业
                Cell affiliationStakeoutTaskId_Cell = row.getCell(1);	//所属放样任务
                Cell stakeoutPointName_Cell = row.getCell(2);			//点名称
                Cell affiliationPointTypeId_Cell = row.getCell(3);		//所属点类型
                Cell altitude_Cell = row.getCell(4);					//高程
                Cell longitude_Cell = row.getCell(5);					//经度
                Cell latitude_Cell = row.getCell(6);					//纬度
                Cell coordinateX_Cell = row.getCell(7);					//城建坐标X
                Cell coordinateY_Cell = row.getCell(8);					//城建坐标Y

                StakeoutTask stakeoutTask = getStakeoutTaskByName(getValue(affiliationStakeoutTaskId_Cell), getValue(companyCode_Cell));
                String stakeoutPointName = getValue(stakeoutPointName_Cell);
                PointType pointType = getPointTypeByName(getValue(affiliationPointTypeId_Cell));
                Double altitude;
                if(StringUtils.isEmpty(getValue(altitude_Cell)) || !isNum(getValue(altitude_Cell))){
                	altitude = 0.0;
                }else{
                	altitude = Double.parseDouble(getValue(altitude_Cell));
                }
                
                Double longitude;
                if(StringUtils.isEmpty(getValue(longitude_Cell)) || !isNum(getValue(longitude_Cell))){
                	longitude = 0.0;
                }else{
                	longitude = Double.parseDouble(getValue(longitude_Cell));
                }
                
                Double latitude;
                if(StringUtils.isEmpty(getValue(latitude_Cell)) || !isNum(getValue(latitude_Cell))){
                	latitude = 0.0;
                }else{
                	latitude = Double.parseDouble(getValue(latitude_Cell));
                }
                
                Double coordinateX;
                if(StringUtils.isEmpty(getValue(coordinateX_Cell)) || !isNum(getValue(coordinateX_Cell))){
                	coordinateX = 0.0;
                }else{
                	coordinateX = Double.parseDouble(getValue(coordinateX_Cell));
                }
                
                Double coordinateY;
                if(StringUtils.isEmpty(getValue(coordinateY_Cell)) || !isNum(getValue(coordinateY_Cell))){
                	coordinateY = 0.0;
                }else{
                	coordinateY = Double.parseDouble(getValue(coordinateY_Cell));
                }
                Date createDate = new Date();
                
                String id;
                if(stakeoutTask == null){
                	id = "";
                }else{
                	id = stakeoutTask.getStakeoutTaskId();
                }
                
                StakeoutPoint sp = getStakeoutPointByNameAndId(stakeoutPointName, id);
                if(sp == null){
                	StakeoutPoint stakeoutPoint = new StakeoutPoint();
                	stakeoutPoint.setAffiliationStakeoutTask(stakeoutTask);
                	stakeoutPoint.setStakeoutPointName(stakeoutPointName);
                	stakeoutPoint.setAffiliationPointType(pointType);
                	if(altitude != 0.0){
                		stakeoutPoint.setAltitude(altitude);
                	}
                	if(longitude != 0.0){
                		stakeoutPoint.setLongitude(longitude);
                	}
                	if(latitude != 0.0){
                		stakeoutPoint.setLatitude(latitude);
                	}
                	if(coordinateX != 0.0){
                		stakeoutPoint.setCoordinateX(coordinateX);
                	}
                	if(coordinateY != 0.0){
                		stakeoutPoint.setCoordinateY(coordinateY);
                	}
                	stakeoutPoint.setCreateDate(createDate);
                	commonDAO.save(stakeoutPoint);
                }else{
                	StakeoutPoint oldStakeoutPoint = commonDAO.load(StakeoutPoint.class, sp.getStakeoutPointId());
                	oldStakeoutPoint.setAffiliationStakeoutTask(stakeoutTask);
                	oldStakeoutPoint.setStakeoutPointName(stakeoutPointName);
                	oldStakeoutPoint.setAffiliationPointType(pointType);
                	if(altitude != 0.0){
                		oldStakeoutPoint.setAltitude(altitude);
                	}
                	if(longitude != 0.0){
                		oldStakeoutPoint.setLongitude(longitude);
                	}
                	if(latitude != 0.0){
                		oldStakeoutPoint.setLatitude(latitude);
                	}
                	if(coordinateX != 0.0){
                		oldStakeoutPoint.setCoordinateX(coordinateX);
                	}
                	if(coordinateY != 0.0){
                		oldStakeoutPoint.setCoordinateY(coordinateY);
                	}
                	oldStakeoutPoint.setCreateDate(createDate);
                	commonDAO.update(oldStakeoutPoint);
                }
            }
        }
	}
	
	@SuppressWarnings("static-access")
	private static String getValue(Cell row){
		if(row != null){
			if(row.getCellType() == Cell.CELL_TYPE_BOOLEAN){
				return String.valueOf(row.getBooleanCellValue());
			}else if(row.getCellType() == Cell.CELL_TYPE_NUMERIC){
				return String.valueOf(row.getNumericCellValue());
			}else if(row.getCellType() == Cell.CELL_TYPE_STRING){
				return String.valueOf(row.getStringCellValue());
			}else if(row.getCellType() == Cell.CELL_TYPE_BLANK){
				return "";
			}else{
				return "";
			}
		}
		return "";
    }
	
	public CorsAccount getCorsByCode(String corsAccountCode, String companyCode){
		String hql = "from CorsAccount where isDelete is null";
		HashMap<String, Object> params = new HashMap<String, Object>();
		if (!StringUtils.isEmpty(corsAccountCode)) {
			hql += " and corsAccountCode =:corsAccountCode and company.companyCode =:companyCode";
			params.put("corsAccountCode", corsAccountCode);
			params.put("companyCode", companyCode);
		}
		CorsAccount corsAccount = commonDAO.get(hql, params);
		return corsAccount;
	}
	
	public Company getCompanyByCode(String companyCode){
		String hql = "from Company where isDelete is null";
		HashMap<String, Object> params = new HashMap<String, Object>();
		if (!StringUtils.isEmpty(companyCode)) {
			hql += " and companyCode =:companyCode";
			params.put("companyCode", companyCode);
		}
		Company company = commonDAO.get(hql, params);
		return company;
	}
	
	public PointType getPointTypeByName(String pointTypeName){
		String hql = "from PointType where isDelete is null";
		HashMap<String, Object> params = new HashMap<String, Object>();
		if (!StringUtils.isEmpty(pointTypeName)) {
			hql += " and pointTypeName =:pointTypeName";
			params.put("pointTypeName", pointTypeName);
		}
		PointType pointType = commonDAO.get(hql, params);
		return pointType;
	}
	
	public StakeoutTask getStakeoutTaskByName(String stakeoutTaskName, String companyCode){
		String hql = "from StakeoutTask where isDelete is null";
		HashMap<String, Object> params = new HashMap<String, Object>();
		if (!StringUtils.isEmpty(stakeoutTaskName)) {
			hql += " and stakeoutTaskName =:stakeoutTaskName and affiliationCompany.companyCode =:companyCode";
			params.put("stakeoutTaskName", stakeoutTaskName);
			params.put("companyCode", companyCode);
		}
		StakeoutTask stakeoutTask = commonDAO.get(hql, params);
		return stakeoutTask;
	}
	
	public StakeoutPoint getStakeoutPointByNameAndId(String stakeoutPointName, String affiliationStakeoutTaskId){
		String hql = "from StakeoutPoint where isDelete is null";
		HashMap<String, Object> params = new HashMap<String, Object>();
		if (!StringUtils.isEmpty(stakeoutPointName)) {
			hql += " and stakeoutPointName =:stakeoutPointName and affiliationStakeoutTask.stakeoutTaskId =:affiliationStakeoutTaskId";
			params.put("stakeoutPointName", stakeoutPointName);
			params.put("affiliationStakeoutTaskId", affiliationStakeoutTaskId);
		}
		StakeoutPoint stakeoutPoint = commonDAO.get(hql, params);
		return stakeoutPoint;
	}
	
	public boolean isNum(String str){
		try { 
			 Double.valueOf(str);	//把字符串强制转换为数字 
			 return true;	//如果是数字，返回True 
		} catch (Exception e) { 
			 return false;	//如果抛出异常，返回False 
		} 

	}
}
