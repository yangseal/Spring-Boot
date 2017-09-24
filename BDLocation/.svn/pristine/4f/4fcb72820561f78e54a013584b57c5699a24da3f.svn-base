package com.cnten.bdlocation.measureproject.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cnten.bdlocation.companyOrg.service.CompanyOrgService;
import com.cnten.bdlocation.measurepoint.service.MeasurePointService;
import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.dao.Page;
import com.cnten.platform.export.PoiExporter;
import com.cnten.platform.system.service.AttachmentService;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.util.StringUtil;
import com.cnten.po.Attachment;
import com.cnten.po.Company;
import com.cnten.po.CompanyOrg;
import com.cnten.po.CorsAccount;
import com.cnten.po.MeasurePoint;
import com.cnten.po.MeasureProject;
import com.cnten.po.StakeoutPoint;
import com.cnten.po.StakeoutTask;
@Service
public class MeasureProjectService {

	@Value("${uploadDir}")
	private String uploadDir;
	@Autowired
	CommonDAO commonDAO;
	
	@Autowired
	CompanyOrgService companyOrgService;
	
	@Autowired
	private AttachmentService attachmentService;
	@Autowired
	private MeasurePointService measurePointService;
	String[] jtPointCode = {"xuhao","zuobx","zuoby","jd","wd"};
	String [] jtPointName = {"序号","城建坐标X","城建坐标Y","经度","纬度"};
	public Page getMeasureProjectsPage(MeasureProject measureProject, Integer pageIndex, Integer pageSize) {
		String hql = "from MeasureProject where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(measureProject.getAffiliationCompanyId())){
			hql += " and affiliationCompany.companyId = :companyId and companyOrg.companyOrgId in(:orgs)";
			params.put("companyId", measureProject.getAffiliationCompanyId());
			params.put("orgs", companyOrgService.querySelfAndChildOrg());
		}else if(!ContextUtil.isSystemUser()){
			hql += " and affiliationCompany.companyId = :companyId";
			String companyId = ContextUtil.getCurrentUser().getCompany().getCompanyId();
			params.put("companyId", companyId);
		}
		if(!StringUtils.isEmpty(measureProject.getMeasureProjectName())){
			hql += " and measureProjectName like :measureProjectName";
			params.put("measureProjectName", "%"+measureProject.getMeasureProjectName()+"%");
		}
		if(!StringUtils.isEmpty(measureProject.getMeasureUser())){
			hql += " and measureUser like :measureUser";
			params.put("measureUser", "%"+measureProject.getMeasureUser()+"%");
		}
		if(measureProject.getMinCreateDate() != null){
			hql += " and createDate >= :minCreateDate";
			params.put("minCreateDate", measureProject.getMinCreateDate());
		}
		if(measureProject.getMaxCreateDate() != null){
			hql += " and createDate <= :maxCreateDate";
			params.put("maxCreateDate", measureProject.getMaxCreateDate());
		}
		hql += " order by createDate desc";
		return commonDAO.getPage(hql, pageIndex, pageSize, params);
	}

	public MeasureProject getMeasureProject(String measureProjectId) {
		return commonDAO.get(MeasureProject.class, measureProjectId);
	}

	public void saveMeasureProject(MeasureProject measureProject) {
		if(StringUtils.isEmpty(measureProject.getAffiliationCompanyId())){
			measureProject.setAffiliationCompany(null);
		}else{
			measureProject.setAffiliationCompany(new Company(measureProject.getAffiliationCompanyId()));
		}
		if(StringUtils.isEmpty(measureProject.getCompanyOrgId())){
			measureProject.setCompanyOrg(null);
		}else{
			measureProject.setCompanyOrg(new CompanyOrg(measureProject.getCompanyOrgId()));
		}
		if(StringUtils.isEmpty(measureProject.getCorsAccountId())){
			measureProject.setCorsAccount(null);
		}else{
			measureProject.setCorsAccount(new CorsAccount(measureProject.getCorsAccountId()));
		}
		String measureProjectId = measureProject.getMeasureProjectId();
		if(StringUtils.isEmpty(measureProjectId)){
			commonDAO.save(measureProject);
		}else{
			MeasureProject oldMeasureProject = commonDAO.load(MeasureProject.class, measureProjectId);
			oldMeasureProject.setMeasureProjectName(measureProject.getMeasureProjectName());
			oldMeasureProject.setMeasureUser(measureProject.getMeasureUser());
			oldMeasureProject.setCollectTpl(measureProject.getCollectTpl());
			oldMeasureProject.setCoordinate(measureProject.getCoordinate());
			oldMeasureProject.setCreateDate(measureProject.getCreateDate());
			oldMeasureProject.setAffiliationCompany(measureProject.getAffiliationCompany());
			oldMeasureProject.setCompanyOrg(measureProject.getCompanyOrg());
			oldMeasureProject.setCorsAccount(measureProject.getCorsAccount());
			commonDAO.update(oldMeasureProject);
		}
	}

	public void deleteMeasureProject(String measureProjectIds){
		String[] measureProjectIdArray = measureProjectIds.split(",");
		for(String measureProjectId : measureProjectIdArray){
			MeasureProject oldMeasureProject = commonDAO.load(MeasureProject.class, measureProjectId);
			oldMeasureProject.setIsDelete("Y");
			commonDAO.update(oldMeasureProject);
		}
	}
	
	public void saveloft(String measureProjectIds){
		String[] measureProjectIdArray = measureProjectIds.split(",");
		for(String measureProjectId : measureProjectIdArray){
			MeasureProject measureProject = commonDAO.get(MeasureProject.class, measureProjectId);
			StakeoutTask stakeoutTask = new StakeoutTask();
			stakeoutTask.setCreateDate(new Date());
			stakeoutTask.setStakeoutTaskName(measureProject.getMeasureProjectName());
			stakeoutTask.setTaskStatus("newTask");
			stakeoutTask.setTaskType("point");
			stakeoutTask.setAffiliationCompany(measureProject.getAffiliationCompany());
			stakeoutTask.setCorsAccount(measureProject.getCorsAccount());
			commonDAO.save(stakeoutTask);
			
			HashMap<String,Object> params = new HashMap<String,Object>();
			String hql = "from MeasurePoint where isDelete is null and affiliationProject.measureProjectId = :measureProjectId";
			params.put("measureProjectId", measureProject.getMeasureProjectId());
			List<MeasurePoint> measurePointList = commonDAO.queryList(hql, params);
			for(MeasurePoint measurePoint : measurePointList){
				StakeoutPoint StakeoutPoint = new StakeoutPoint();
				StakeoutPoint.setAltitude(measurePoint.getAltitude());
				StakeoutPoint.setCoordinateX(measurePoint.getCoordinateX());;
				StakeoutPoint.setCoordinateY(measurePoint.getCoordinateY());
				StakeoutPoint.setCreateDate(new Date());
				StakeoutPoint.setLatitude(measurePoint.getLatitude());
				StakeoutPoint.setLongitude(measurePoint.getLongitude());
				StakeoutPoint.setStakeoutPointName(measurePoint.getMeasurePointName());
				StakeoutPoint.setAffiliationPointType(measurePoint.getAffiliationPointType());
				StakeoutPoint.setAffiliationStakeoutTask(stakeoutTask);
				commonDAO.save(StakeoutPoint);
			}
		}
	}
	
	public void exportMeasureProjects(MeasureProject measureProject, HttpServletResponse response) throws Exception{
		String hql = "from MeasureProject where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(measureProject.getAffiliationCompanyId())){
			hql += " and affiliationCompany.companyId = :companyId";
			params.put("companyId", measureProject.getAffiliationCompanyId());
		}else if(!ContextUtil.isSystemUser()){
			hql += " and affiliationCompany.companyId = :companyId";
			String companyId = ContextUtil.getCurrentUser().getCompany().getCompanyId();
			params.put("companyId", companyId);
		}
		if(!StringUtils.isEmpty(measureProject.getMeasureProjectName())){
			hql += " and measureProjectName like :measureProjectName";
			params.put("measureProjectName", "%"+measureProject.getMeasureProjectName()+"%");
		}
		if(!StringUtils.isEmpty(measureProject.getMeasureUser())){
			hql += " and measureUser like :measureUser";
			params.put("measureUser", "%"+measureProject.getMeasureUser()+"%");
		}
		if(measureProject.getMinCreateDate() != null){
			hql += " and createDate >= :minCreateDate";
			params.put("minCreateDate", measureProject.getMinCreateDate());
		}
		if(measureProject.getMaxCreateDate() != null){
			hql += " and createDate <= :maxCreateDate";
			params.put("maxCreateDate", measureProject.getMaxCreateDate());
		}
		List<MeasureProject> measureProjects = commonDAO.queryList(hql, params);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("测量工程信息");
		sheet.setDefaultColumnWidth(20);
		HSSFRow row = sheet.createRow(0);
		String[] headers = {"工程名称","作业人员","数据采集模板","坐标系统","创建时间","所属企业","创建用户"};
		PoiExporter.fillHeader(row, headers);
		int i = 1;
		HSSFCell cell;
		for(MeasureProject measureProjectData : measureProjects){
			row = sheet.createRow(i);
			cell = row.createCell(0);
			if(measureProjectData.getMeasureProjectName() != null){
				cell.setCellValue(measureProjectData.getMeasureProjectName());
			}
			cell = row.createCell(1);
			if(measureProjectData.getMeasureUser() != null){
				cell.setCellValue(measureProjectData.getMeasureUser());
			}
			cell = row.createCell(2);
			if(measureProjectData.getCollectTpl() != null){
				cell.setCellValue(measureProjectData.getCollectTplName());
			}
			cell = row.createCell(3);
			if(measureProjectData.getCoordinate() != null){
				cell.setCellValue(measureProjectData.getCoordinateName());
			}
			cell = row.createCell(4);
			if(measureProjectData.getCreateDate() != null){
				cell.setCellValue(StringUtil.formatDateTime(measureProjectData.getCreateDate()));
			}
			cell = row.createCell(5);
			if(measureProjectData.getAffiliationCompany() != null){
				cell.setCellValue(measureProjectData.getAffiliationCompany().getCompanyName());
			}
			cell = row.createCell(6);
			if(measureProjectData.getCorsAccount() != null){
				cell.setCellValue(measureProjectData.getCorsAccount().getCorsAccountCode());
			}
			i++;
		}
		response.setHeader("Content-Disposition", "attachment; filename=" 
				+ java.net.URLEncoder.encode("测量工程信息.xls", "UTF-8"));
		OutputStream os = response.getOutputStream();
		workbook.write(os);
		os.close();
	}
	
	public void exportMeasureProject(String measureProjectId, HttpServletResponse response) throws Exception{
		MeasureProject measureProjects = commonDAO.get(MeasureProject.class, measureProjectId);
		
		String hqlPoint = "from MeasurePoint where isDelete is null";
		HashMap<String,Object> paramsPoint = new HashMap<String,Object>();
		if(!StringUtils.isEmpty(measureProjectId)){
			hqlPoint += " and affiliationProject.measureProjectId = :measureProjectId";
			paramsPoint.put("measureProjectId", measureProjectId);
		}
		List<MeasurePoint> measurePoints = commonDAO.queryList(hqlPoint, paramsPoint);
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("测量工程信息");
		sheet.setDefaultColumnWidth(20);
		HSSFRow row = sheet.createRow(0);
		String[] headers = {"工程名称","作业人员","数据采集模板","坐标系统","创建时间","所属企业","创建用户"};
		PoiExporter.fillHeader(row, headers);
		HSSFCell cell;
		row = sheet.createRow(1);
		cell = row.createCell(0);
		if(measureProjects.getMeasureProjectName() != null){
			cell.setCellValue(measureProjects.getMeasureProjectName());
		}
		cell = row.createCell(1);
		if(measureProjects.getMeasureUser() != null){
			cell.setCellValue(measureProjects.getMeasureUser());
		}
		cell = row.createCell(2);
		if(measureProjects.getCollectTpl() != null){
			cell.setCellValue(measureProjects.getCollectTplName());
		}
		cell = row.createCell(3);
		if(measureProjects.getCoordinate() != null){
			cell.setCellValue(measureProjects.getCoordinateName());
		}
		cell = row.createCell(4);
		if(measureProjects.getCreateDate() != null){
			cell.setCellValue(StringUtil.formatDateTime(measureProjects.getCreateDate()));
		}
		cell = row.createCell(5);
		if(measureProjects.getAffiliationCompany() != null){
			cell.setCellValue(measureProjects.getAffiliationCompany().getCompanyName());
		}
		cell = row.createCell(6);
		if(measureProjects.getCorsAccount() != null){
			cell.setCellValue(measureProjects.getCorsAccount().getCorsAccountCode());
		}
		
		HSSFSheet sheet2 = workbook.createSheet("测量点信息");
		sheet2.setDefaultColumnWidth(20);
		HSSFRow row2 = sheet2.createRow(0);
		String[] headers2 = {"点名称","点编码","所属点类型","描述","解状态","hrms","vrms","纬度","经度","北坐标","东坐标","城建坐标X","城建坐标Y","椭球高","高程","创建时间","所属工程"};
		PoiExporter.fillHeader(row2, headers2);
		int j = 1;
		HSSFCell cell2;
		for(MeasurePoint measurePointData : measurePoints){
			row2 = sheet2.createRow(j);
			cell2 = row2.createCell(0);
			if(measurePointData.getMeasurePointName() != null){
				cell2.setCellValue(measurePointData.getMeasurePointName());
			}
			cell2 = row2.createCell(1);
			if(measurePointData.getMeasurePointCode() != null){
				cell2.setCellValue(measurePointData.getMeasurePointCode());
			}
			cell2 = row2.createCell(2);
			if(measurePointData.getAffiliationPointType() != null){
				cell2.setCellValue(measurePointData.getAffiliationPointType().getPointTypeName());
			}
			cell2 = row2.createCell(3);
			if(measurePointData.getPointDesc() != null){
				cell2.setCellValue(measurePointData.getPointDesc());
			}
			cell2 = row2.createCell(4);
			if(measurePointData.getSolutionState() != null){
				cell2.setCellValue(measurePointData.getSolutionStateName());
			}
			cell2 = row2.createCell(5);
			if(measurePointData.getHrms() != null){
				cell2.setCellValue(measurePointData.getHrms());
			}
			cell2 = row2.createCell(6);
			if(measurePointData.getVrms() != null){
				cell2.setCellValue(measurePointData.getVrms());
			}
			cell2 = row2.createCell(7);
			if(measurePointData.getLongitude() != null){
				cell2.setCellValue(measurePointData.getLongitude());
			}
			cell2 = row2.createCell(8);
			if(measurePointData.getLatitude () != null){
				cell2.setCellValue(measurePointData.getLatitude ());
			}
			cell2 = row2.createCell(9);
			if(measurePointData.getNorth() != null){
				cell2.setCellValue(measurePointData.getNorth());
			}
			cell2 = row2.createCell(10);
			if(measurePointData.getEast() != null){
				cell2.setCellValue(measurePointData.getEast());
			}
			cell2 = row2.createCell(11);
			if(measurePointData.getCoordinateX() != null){
				cell2.setCellValue(measurePointData.getCoordinateX());
			}
			cell2 = row2.createCell(12);
			if(measurePointData.getCoordinateY() != null){
				cell2.setCellValue(measurePointData.getCoordinateY());
			}
			cell2 = row2.createCell(13);
			if(measurePointData.getEllHeight() != null){
				cell2.setCellValue(measurePointData.getEllHeight());
			}
			cell2 = row2.createCell(14);
			if(measurePointData.getAltitude() != null){
				cell2.setCellValue(measurePointData.getAltitude());
			}
			cell2 = row2.createCell(15);
			if(measurePointData.getCreateDate() != null){
				cell2.setCellValue(StringUtil.formatDateTime(measurePointData.getCreateDate()));
			}
			cell2 = row2.createCell(16);
			if(measurePointData.getAffiliationProject() != null){
				cell2.setCellValue(measurePointData.getAffiliationProject().getMeasureProjectName());
			}
			j++;
		}
		
		response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode("测量工程详情.xls", "UTF-8"));
		OutputStream os = response.getOutputStream();
		workbook.write(os);
		os.close();
	}
	
	public List<MeasureProject> getMeasureProjectList(String companyId,String createDate) throws Exception {
		String hql = "from MeasureProject where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isEmpty(companyId)) {
			return null;
		} else {
			hql += " and affiliationCompany= :affiliationCompany";
			params.put("affiliationCompany", new Company(companyId));
		}
		
		if(!StringUtils.isEmpty(createDate)) {
			hql += " and DATE_FORMAT(createDate,'%Y-%m-%d')>= :createDate";
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(createDate);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			params.put("createDate", formatter.format(date));
		}
		
		List<MeasureProject> measureProjectList = commonDAO.queryList(hql, params);
		return measureProjectList;
	}
	
	public List<MeasureProject> exportRAR (String companyId,String createDate) throws Exception {
		if(StringUtils.isEmpty(companyId)) {
			return null;
		}
		List<MeasureProject> measureProjectList = getMeasureProjectList(companyId,createDate);
		for(int i=0; i<measureProjectList.size(); i++) {
			List<MeasurePoint> measurePointList = measurePointService.getMeasurePointList(measureProjectList.get(i));
			measureProjectList.get(i).setMeasurePointList(measurePointList);
		}
		return measureProjectList;
	}
	
	public List<MeasureProject> getMeasureProjectListInfo(String measureProjectId) throws Exception {
		String hql = "from MeasureProject where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		List<MeasureProject> measureProjectList = commonDAO.queryList(hql, params);
		return measureProjectList;
	}
	
	public List<MeasureProject> getMeasureProjectList(String measureProjectId) throws Exception {
		String hql = "from MeasureProject where  measureProjectId in :measureProjectId ";
		HashMap<String,Object> params = new HashMap<String,Object>();
		//measureProjectId =  measureProjectId.replaceAll(",", "','");
		String measureProjectIds[] = measureProjectId.split(",");
		params.put("measureProjectId",measureProjectIds);
		//measureProjectId =  "'"+measureProjectId.replaceAll(",", "','")+"'";
		//params.put("measureProjectId", measureProjectId);
		List<MeasureProject> measureProjectList = commonDAO.queryList(hql, params);
		return measureProjectList;
	}
	
	public List<MeasureProject> exportProjectInfo (String measureProjectId) throws Exception {
		if(StringUtils.isEmpty(measureProjectId)) {
			return null;
		}
		List<MeasureProject> measureProjectList = getMeasureProjectList(measureProjectId);
		for(int i=0; i<measureProjectList.size(); i++) {
			List<MeasurePoint> measurePointList = measurePointService.getMeasurePointList(measureProjectList.get(i));
			measureProjectList.get(i).setMeasurePointList(measurePointList);
		}
		return measureProjectList;
	}
		
	//导出工程测量相关信息
	public void exportMeasureProjectZip(String measureProjectId, HttpServletResponse response,String foldName,String excelName,ZipOutputStream zos) throws Exception{
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFCellStyle cellStyle = workbook.createCellStyle();  
		HSSFFont f  = workbook.createFont();    //字体
		f.setFontHeightInPoints((short) 11);//字号        
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框  
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框  
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框  
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框  
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中  
		//创建主sheet页（测量工程信息）
		CreatProjectSheet(measureProjectId,workbook,cellStyle);
		//测量点sheet页
		CreatMeasureSheet(measureProjectId,workbook,cellStyle);
		//将生成Excel写入压缩文件里
		FileOutputStream out = null; 
		File file = File.createTempFile(excelName, "UTF-8");  
		out = FileUtils.openOutputStream(file);  
		workbook.write(out);//将数据写到指定文件  
		FileInputStream in = new FileInputStream(file); 
		zos.putNextEntry(new ZipEntry(foldName + "/" + excelName));//excel名称
		int len = 0;  
		while ((len = in.read()) != -1)  
		zos.write(len);  
		in.close(); 
	
	}
	
	/*
	 * 创建子sheet页（测量点）信息
	 * 表头信息从枚举类配置中获取，按照需求模板展示。
	 */
	public void CreatMeasureSheet(String measureProjectId,HSSFWorkbook workbook,HSSFCellStyle cellStyle){
		String hqlPoint = "from MeasurePoint where isDelete is null";
		HashMap<String,Object> paramsPoint = new HashMap<String,Object>();
		if(!StringUtils.isEmpty(measureProjectId)){
			hqlPoint += " and affiliationProject.measureProjectId = :measureProjectId group by affiliationPointType" ;
			paramsPoint.put("measureProjectId", measureProjectId);
		}
		//该任务下测量点分组
		List<MeasurePoint> measurePoints = commonDAO.queryList(hqlPoint, paramsPoint);
		HashMap<String,Object> pointTypeMap = new HashMap<String,Object>();
		for(MeasurePoint measurePointData : measurePoints){
			 String pointTypeName = measurePointData.getAffiliationPointType().getPointTypeName().toString();
			 String pointTypeCode = measurePointData.getAffiliationPointType().getPointTypeCode().toString();
			 pointTypeMap.put(pointTypeCode,pointTypeName);
		}
		Iterator entries = pointTypeMap.entrySet().iterator(); 
		while (entries.hasNext()) {  
			Entry entry =  (Entry) entries.next();
			String pointKey = (String) entry.getKey();  
			String pointValue = (String)entry.getValue();
			HSSFSheet sheetno;
			int rownum =1;
			HSSFRow row2;
			//当前类型测量点信息
			String hql = "from MeasurePoint where isDelete is null and affiliationProject.measureProjectId = :measureProjectId  and affiliationPointType.pointTypeCode in (:pointTypeCode)" ;
			HashMap<String,Object> params = new HashMap<String,Object>();
			if(!StringUtils.isEmpty(measureProjectId)){
				params.put("measureProjectId", measureProjectId);
				params.put("pointTypeCode",pointKey);
			}
			List<MeasurePoint> measure = commonDAO.queryList(hql, params);
			sheetno = workbook.createSheet(pointValue);  //sheet页名称
			sheetno.setDefaultColumnWidth(20); 
			row2 = sheetno.createRow(0);
			row2.setHeight((short)450);
			int num = 1;
			HSSFCell cell2=null;
			for(MeasurePoint measurePoint : measure){ 
				List<Map> listPointData = measurePoint.getDynamicList();//当前记录动态字段集合
				HashMap<String,Object> dyParam = new HashMap<String,Object>();
				//枚举类没有配置该类型测量点信息的情况：直接查询 dynamic_field导出
				if(PointEnum.getEnameName(pointKey)==null){
					CreatMeasureSheetBranch( measurePoint,num,rownum,sheetno,row2,cell2,cellStyle);
				}else{
					for(Map listPoint :listPointData){
						dyParam.put((String) listPoint.get("fieldCode"), listPoint.get("fieldValue"));
					}
					//表头部分
					if(num==1){
						PoiExporter.fillHeader(row2, PointEnum.getEnameName(pointKey));
					} 
					String [] PointCode = PointEnum.getEnameCode(pointKey);
					
					for(int k =0;k<PointCode.length;k++){
						if(k==0){//静态数据
							row2 = sheetno.createRow(rownum);
							row2.setHeight((short)1750);
							cell2 = row2.createCell(k);
							cell2.setCellStyle(cellStyle);
							cell2.setCellValue(rownum);
						}else{
							cell2 = row2.createCell(k);
							cell2.setCellStyle(cellStyle);
							cell2.setCellStyle(cellStyle);
							if(dyParam.get(PointCode[k]) != null){
								cell2.setCellValue(dyParam.get(PointCode[k]).toString());
							//静态数据处理
							}else if(PointCode[k].equals("coordinatex") ){ // 城建坐标x
								cell2.setCellValue(measurePoint.getCoordinateX());
							}else if(PointCode[k].equals("coordinatey") ){ //城建坐标Y
								cell2.setCellValue(measurePoint.getCoordinateY());
							}else if(PointCode[k].equals("longitude") ){ // 经度
								cell2.setCellValue(measurePoint.getLongitude());
							}else if(PointCode[k].equals("latitude") ){ // 纬度
								cell2.setCellValue(measurePoint.getLatitude());	
							}else if(PointCode[k].equals("zhaopian1")){//图片处理
								cell2 = row2.createCell(k);
								cell2.setCellStyle(cellStyle);
								cell2.setCellStyle(cellStyle);
								this.PictureReg(1,measurePoint.getMeasurePointId(),cell2,k,rownum,k,rownum);
							}else if(PointCode[k].equals("zhaopian2")){//图片处理
								cell2 = row2.createCell(k);
								cell2.setCellStyle(cellStyle);
								cell2.setCellStyle(cellStyle);
								this.PictureReg(2,measurePoint.getMeasurePointId(),cell2,k,rownum,k,rownum);
							}else{
								cell2 = row2.createCell(k);
								cell2.setCellStyle(cellStyle);
								cell2.setCellStyle(cellStyle);
								cell2.setCellValue("");
							}
						}
						
					}
				}
				num++;
				rownum++;
				
			 }
		}
	}
	
	
	//CreatMeasureSheet内当枚举类没有配置该测量点信息的情况：从dynamic_field 中获取 表头信息
	public void CreatMeasureSheetBranch(MeasurePoint measurePoint, int num,int rownum, HSSFSheet sheetno,HSSFRow row2,HSSFCell cell2,HSSFCellStyle cellStyle){
		List<Map> listPointData = measurePoint.getDynamicList();
		List<String> listPointHead = new ArrayList<String>();  //表头list
		List<String> listPointCode = new ArrayList<String>();  //CODElist
		List<Object> listPointValue = new ArrayList<Object>();  //Valuelist	
		//静态字段
		for(int g=0;g<jtPointCode.length;g++){
			listPointCode.add(jtPointCode[g]);
			listPointHead.add(jtPointName[g]);
		}
		//动态字段 ：将json串里 code及对应value放入map  ，将字段名放入 list
		for(Map pointValue :listPointData){
			//dyParam.put((String) pointValue.get("fieldCode"), pointValue.get("fieldValue"));
			listPointCode.add(pointValue.get("fieldCode").toString());
			listPointHead.add(pointValue.get("fieldName").toString());
			listPointValue.add(null !=pointValue.get("fieldValue") && !"".equals(pointValue.get("fieldValue"))? pointValue.get("fieldValue"):"" );
		}
		listPointHead.add("照片1");
		listPointHead.add("照片2");
		listPointHead.add("备注");
		//表头部分
		if(num==1){
			String[] headers2 = listPointHead.toArray(new String[listPointHead.size()]);
			PoiExporter.fillHeader(row2, headers2);
			
		} 
		for(int k =0;k<listPointCode.size();k++){
			if(k==0){//静态数据
			row2 = sheetno.createRow(rownum);
			row2.setHeight((short)1750);
			cell2 = row2.createCell(k);
			cell2.setCellStyle(cellStyle);
			cell2.setCellValue(rownum);
			}else if(k==1){
				cell2 = row2.createCell(k);
				cell2.setCellStyle(cellStyle);
				cell2.setCellStyle(cellStyle);
				if(measurePoint.getCoordinateX() != null){
					cell2.setCellValue(measurePoint.getCoordinateX());
				}else{
					cell2.setCellValue("");
				}
			}else if(k==2){
				cell2 = row2.createCell(k);
				cell2.setCellStyle(cellStyle);
				cell2.setCellStyle(cellStyle);
				if(measurePoint.getCoordinateY() != null){
					cell2.setCellValue(measurePoint.getCoordinateY());
				}else{
					cell2.setCellValue("");
				}
			}else if(k==3){
				cell2 = row2.createCell(k);
				cell2.setCellStyle(cellStyle);
				cell2.setCellStyle(cellStyle);
				if(measurePoint.getLongitude() != null){
					cell2.setCellValue(measurePoint.getLongitude ());
				}else{
					cell2.setCellValue("");
				}
			}else if(k==4){
				cell2 = row2.createCell(k);
				cell2.setCellStyle(cellStyle);
				cell2.setCellStyle(cellStyle);
				if(measurePoint.getLatitude() != null){
					cell2.setCellValue(measurePoint.getLatitude());
				}else{
					cell2.setCellValue("");
				}
			}else{   //动态数据
				cell2 = row2.createCell(k);
				cell2.setCellStyle(cellStyle);
				cell2.setCellStyle(cellStyle);
				if(listPointValue.get(k-5)  != null){
					cell2.setCellValue(listPointValue.get(k-5).toString());
				}else{
					cell2.setCellValue("");
				}
			}
		}
		//图片及备注
		cell2 = row2.createCell(listPointCode.size());
		cell2.setCellStyle(cellStyle);
		cell2.setCellStyle(cellStyle);
		this.PictureReg(1,measurePoint.getMeasurePointId(),cell2,listPointCode.size(),rownum,listPointCode.size(),rownum);
		cell2 = row2.createCell(listPointCode.size()+1);
		cell2.setCellStyle(cellStyle);
		cell2.setCellStyle(cellStyle);
		this.PictureReg(2,measurePoint.getMeasurePointId(),cell2,listPointCode.size()+1,rownum,listPointCode.size()+1,rownum);
		cell2 = row2.createCell(listPointCode.size()+2);
		cell2.setCellStyle(cellStyle);
		cell2.setCellStyle(cellStyle);
		cell2.setCellValue("");
	}
	
	
	
	
	/*
	 * 
	 * 创建子sheet页（测量点）信息
	 * 导出测量点信息表头顺序为  静态数据+动态数据（动态表头从dynamic_field json串中查出）
	 * 
	 */
	public void CreatMeasureSheet1(String measureProjectId,HSSFWorkbook workbook,HSSFCellStyle cellStyle){
		
		String hqlPoint = "from MeasurePoint where isDelete is null";
		HashMap<String,Object> paramsPoint = new HashMap<String,Object>();
		if(!StringUtils.isEmpty(measureProjectId)){
			hqlPoint += " and affiliationProject.measureProjectId = :measureProjectId group by affiliationPointType" ;
			paramsPoint.put("measureProjectId", measureProjectId);
		}
		//该任务下测量点分组
		List<MeasurePoint> measurePoints = commonDAO.queryList(hqlPoint, paramsPoint);
		List<String> pointTypeList = new ArrayList<String>() ;
		for(MeasurePoint measurePointData : measurePoints){
			 String pointType = measurePointData.getAffiliationPointType().getPointTypeName().toString();
			 pointTypeList.add(pointType);
		}
		for (int i=0;i<pointTypeList.size();i++){
			HSSFSheet sheetno;
			int rownum =1;
			HSSFRow row2;
			String hql = "from MeasurePoint where isDelete is null and affiliationProject.measureProjectId = :measureProjectId  and affiliationPointType.pointTypeName in (:pointTypeName)" ;
			HashMap<String,Object> params = new HashMap<String,Object>();
			if(!StringUtils.isEmpty(measureProjectId)){
				params.put("measureProjectId", measureProjectId);
				params.put("pointTypeName",pointTypeList.get(i));
			}
			List<MeasurePoint> measure = commonDAO.queryList(hql, params);
			sheetno = workbook.createSheet(pointTypeList.get(i));
			sheetno.setDefaultColumnWidth(20); 
			row2 = sheetno.createRow(0);
			row2.setHeight((short)450);
			int num = 1;
			HSSFCell cell2;
			for(MeasurePoint measurePointData : measure){
				List<Map> listPointData = measurePointData.getDynamicList();
				List<String> listPointHead = new ArrayList<String>();  //表头list
				List<String> listPointCode = new ArrayList<String>();  //CODElist
				List<Object> listPointValue = new ArrayList<Object>();  //Valuelist
				//静态字段
				for(int g=0;g<jtPointCode.length;g++){
					listPointCode.add(jtPointCode[g]);
					listPointHead.add(jtPointName[g]);
				}
				//动态字段 ：将json串里 code及对应value放入map  ，将字段名放入 list
				for(Map pointValue :listPointData){
					//dyParam.put((String) pointValue.get("fieldCode"), pointValue.get("fieldValue"));
					listPointCode.add(pointValue.get("fieldCode").toString());
					listPointHead.add(pointValue.get("fieldName").toString());
					listPointValue.add(null !=pointValue.get("fieldValue") && !"".equals(pointValue.get("fieldValue"))? pointValue.get("fieldValue"):"" );
				}
				listPointHead.add("照片1");
				listPointHead.add("照片2");
				listPointHead.add("备注");
				//表头部分
				if(num==1){
					String[] headers2 = listPointHead.toArray(new String[listPointHead.size()]);
					PoiExporter.fillHeader(row2, headers2);
					
				} 
				for(int k =0;k<listPointCode.size();k++){
					if(k==0){//静态数据
					row2 = sheetno.createRow(rownum);
					row2.setHeight((short)750);
					cell2 = row2.createCell(k);
					cell2.setCellStyle(cellStyle);
					cell2.setCellValue(rownum);
					}else if(k==1){
						cell2 = row2.createCell(k);
						cell2.setCellStyle(cellStyle);
						cell2.setCellStyle(cellStyle);
						if(measurePointData.getCoordinateX() != null){
							cell2.setCellValue(measurePointData.getCoordinateX());
						}else{
							cell2.setCellValue("");
						}
					}else if(k==2){
						cell2 = row2.createCell(k);
						cell2.setCellStyle(cellStyle);
						cell2.setCellStyle(cellStyle);
						if(measurePointData.getCoordinateY() != null){
							cell2.setCellValue(measurePointData.getCoordinateY());
						}else{
							cell2.setCellValue("");
						}
					}else if(k==3){
						cell2 = row2.createCell(k);
						cell2.setCellStyle(cellStyle);
						cell2.setCellStyle(cellStyle);
						if(measurePointData.getLongitude() != null){
							cell2.setCellValue(measurePointData.getLongitude ());
						}else{
							cell2.setCellValue("");
						}
					}else if(k==4){
						cell2 = row2.createCell(k);
						cell2.setCellStyle(cellStyle);
						cell2.setCellStyle(cellStyle);
						if(measurePointData.getLatitude() != null){
							cell2.setCellValue(measurePointData.getLatitude());
						}else{
							cell2.setCellValue("");
						}
					}else{   //动态数据
						cell2 = row2.createCell(k);
						cell2.setCellStyle(cellStyle);
						cell2.setCellStyle(cellStyle);
						if(listPointValue.get(k-5)  != null){
							cell2.setCellValue(listPointValue.get(k-5).toString());
						}else{
							cell2.setCellValue("");
						}
					}
				}
				//图片及备注
				cell2 = row2.createCell(listPointCode.size());
				cell2.setCellStyle(cellStyle);
				cell2.setCellStyle(cellStyle);
				this.PictureReg(1,measurePointData.getMeasurePointId(),cell2,listPointCode.size(),rownum,listPointCode.size(),rownum);
				cell2 = row2.createCell(listPointCode.size()+1);
				cell2.setCellStyle(cellStyle);
				cell2.setCellStyle(cellStyle);
				this.PictureReg(2,measurePointData.getMeasurePointId(),cell2,listPointCode.size()+1,rownum,listPointCode.size()+1,rownum);
				cell2 = row2.createCell(listPointCode.size()+2);
				cell2.setCellStyle(cellStyle);
				cell2.setCellStyle(cellStyle);
				cell2.setCellValue("");
				num++;
				rownum++;
			 }
		}
	}	
    //创建主sheet页（测量工程 ）信息
	public void CreatProjectSheet(String measureProjectId,HSSFWorkbook workbook,HSSFCellStyle cellStyle){
		MeasureProject measureProjects = commonDAO.get(MeasureProject.class, measureProjectId);
		HSSFSheet sheet = workbook.createSheet("测量工程信息");
		sheet.setDefaultColumnWidth(20);
		HSSFRow row = sheet.createRow(0);
		row.setHeight((short)450);
		String[] headers = {"工程名称","作业人员","数据采集模板","坐标系统","创建时间","所属企业","创建用户"};
		PoiExporter.fillHeader(row, headers) ;
		HSSFCell cell;
		row = sheet.createRow(1);
		for(int i =0;i<headers.length;i++){
			cell = row.createCell(i);
			cell.setCellStyle(cellStyle);
			if(headers[i].endsWith("工程名称")){
				if(measureProjects.getMeasureProjectName() != null){
					cell.setCellValue(measureProjects.getMeasureProjectName());
				}
			}
			if(headers[i].endsWith("作业人员")){
				if(measureProjects.getMeasureUser() != null){
					cell.setCellValue(measureProjects.getMeasureUser());
				}
			}
		}
		cell = row.createCell(0);
		cell.setCellStyle(cellStyle);
		if(measureProjects.getMeasureProjectName() != null){
			cell.setCellValue(measureProjects.getMeasureProjectName());
		}
		cell = row.createCell(1);
		cell.setCellStyle(cellStyle);
		if(measureProjects.getMeasureUser() != null){
			cell.setCellValue(measureProjects.getMeasureUser());
		}
		cell = row.createCell(2);
		cell.setCellStyle(cellStyle);
		if(measureProjects.getCollectTpl() != null){
			cell.setCellValue(measureProjects.getCollectTplName());
		}
		cell = row.createCell(3);
		cell.setCellStyle(cellStyle);
		if(measureProjects.getCoordinate() != null){
			cell.setCellValue(measureProjects.getCoordinateName());
		}
		cell = row.createCell(4);
		cell.setCellStyle(cellStyle);
		if(measureProjects.getCreateDate() != null){
			cell.setCellValue(StringUtil.formatDateTime(measureProjects.getCreateDate()));
		}
		cell = row.createCell(5);
		cell.setCellStyle(cellStyle);
		if(measureProjects.getAffiliationCompany() != null){
			cell.setCellValue(measureProjects.getAffiliationCompany().getCompanyName());
		}
		cell = row.createCell(6);
		cell.setCellStyle(cellStyle);
		if(measureProjects.getCorsAccount() != null){
			cell.setCellValue(measureProjects.getCorsAccount().getCorsAccountCode());
		}
		row.setHeight((short)450);
	}
	//excel中插入图片
	public void PictureReg(int num,String measureProjectId,HSSFCell cell, int beginlin,int endlin,int beginrow,int endrow ){
		 ByteArrayOutputStream byteArrayOut = null;
	     BufferedImage bufferImg = null;  
	     int j=1;
		try {
			Attachment attachment = new Attachment();
			attachment.setEntityId(measureProjectId);
			attachment.setEntityName("measurePoint");
			attachment.setFieldName("attachments");
			List<Attachment> attachmentList = attachmentService.getAttachments(attachment);
			for(Attachment attachmentlist : attachmentList) {	
				if(num==j){
		   		   String fullname = uploadDir + attachmentlist.getEntityName()
		   				+ File.separatorChar + attachmentlist.getFileName();
		   		   File file = new File(fullname);
		    	   if (file==null || !file.isFile()) {
		    		   throw new RuntimeException("文件不存在");
		    	   }
		           byteArrayOut = new ByteArrayOutputStream();   
		           bufferImg = ImageIO.read(file);   
		           ImageIO.write(bufferImg, "jpg", byteArrayOut);
		           
		           HSSFWorkbook wb = cell.getSheet().getWorkbook();  
		           //画图的顶级管理器，一个sheet只能获取一个（一定要注意这点）
		           HSSFPatriarch patriarch = cell.getSheet().createDrawingPatriarch();   
		           //anchor主要用于设置图片的属性
		           HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 1023, 250,(short) beginlin, endlin, (short) beginrow, endrow);
		           anchor.setAnchorType(3);   
		           //插入图片  
		           patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG)); 
				}
	           j++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}               
	}
}