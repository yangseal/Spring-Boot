package com.cnten.bdlocation.measureproject.controller;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.measureproject.service.MeasureProjectService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.system.service.AttachmentService;
import com.cnten.platform.system.service.CompanyService;
import com.cnten.platform.util.StringUtil;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.Attachment;
import com.cnten.po.Company;
import com.cnten.po.MeasurePoint;
import com.cnten.po.MeasureProject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Controller
public class MeasureProjectController {
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	private MeasureProjectService measureProjectService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private AttachmentService attachmentService;
	

	
	@RequestMapping(value = "/measureProject/showMeasureProjects")
	public void showMeasureProjects() {
	}
	
	@RequestMapping(value = "/measureProject/showMeasureProject")
	public void showMeasureProject(String measureProjectId, Model model) {
		MeasureProject measureProject = measureProjectService.getMeasureProject(measureProjectId);
		model.addAttribute("measureProject", measureProject);
	}
	
	@RequestMapping(value = "/measureProject/queryMeasureProjects")
	public void queryMeasureProjects(MeasureProject measureProject, Integer pageIndex, Integer pageSize, Model model) {
		Page page = measureProjectService.getMeasureProjectsPage(measureProject, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "/measureProject/selectMeasureProject")
	public void selectMeasureProject() {
	}
	
	@RequestMapping(value = "/measureProject/selectMeasureProjects")
	public void selectMeasureProjects(MeasureProject measureProject, Integer pageIndex, Integer pageSize, Model model) {
		Page page = measureProjectService.getMeasureProjectsPage(measureProject, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@ResponseBody
	@RequestMapping(value = "/measureProject/saveMeasureProject")
	public SuccessOrFailure saveMeasureProject(MeasureProject measureProject){
		try {
			measureProjectService.saveMeasureProject(measureProject);
			return SuccessOrFailure.SUCCESS(measureProject.getMeasureProjectId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/measureProject/deleteMeasureProject")
	public SuccessOrFailure deleteMeasureProject(String measureProjectIds){
		try {
			measureProjectService.deleteMeasureProject(measureProjectIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/measureProject/saveloft")
	public SuccessOrFailure saveloft(String measureProjectIds){
		try {
			measureProjectService.saveloft(measureProjectIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/measureProject/exportMeasureProjects")
	public void exportMeasureProjects(MeasureProject measureProject, HttpServletResponse response) {
		try {
			measureProjectService.exportMeasureProjects(measureProject, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/measureProject/exportMeasureProject")
	public void exportMeasureProject(String measureProjectId, HttpServletResponse response) {
		try {
			measureProjectService.exportMeasureProject(measureProjectId, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/measureProject/exportRar")
	public void exportRar(Company company,String createDate,HttpServletResponse response) {
		try {
			String companyId = companyService.checkPassword(company);
			if(StringUtils.isEmpty(companyId)) {
				response.setContentType("text/html;charset=UTF-8"); 
				response.getWriter().write("用户名或密码错误");
				return;
			}
			//在内存中创建zip文件
			ByteArrayOutputStream bos = new ByteArrayOutputStream();  
			ZipOutputStream zos = new ZipOutputStream(bos);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(zos, "UTF-8"));
			//向zip中添加文件
			List<MeasureProject> measureProjectList = measureProjectService.exportRAR(companyId, createDate);
			if(null == measureProjectList || measureProjectList.size() == 0) {
				response.setContentType("text/html;charset=UTF-8"); 
				response.getWriter().write("未找到可下载的数据");
				return;
			}
			for(int i = 0; i < measureProjectList.size(); i++) {
				MeasureProject measureProject = measureProjectList.get(i);	//当前任务
				String projectId = measureProject.getMeasureProjectId();	//任务ID
				String foldName = "project_" + projectId;	//目录名称
				try {
					addTaskFile(measureProject, foldName, zos); //添加附件
				} catch (Exception e) {
					e.printStackTrace();
				}	
				
				zos.putNextEntry(new ZipEntry(foldName + "/project_" + projectId + ".txt"));
				ObjectMapper mapper = new ObjectMapper();
				mapper.configure(SerializationFeature.INDENT_OUTPUT, Boolean.TRUE);
				String data = mapper.writeValueAsString(measureProject);
			
				bw.write(data);
				bw.flush();
				
				zos.closeEntry(); //关闭压缩流
			}
			bw.close();
			zos.close();
			//下载文件
			response.setContentType("application/x-msdownload;charset=GBK");
			response.setHeader("Content-Disposition", "attachment; filename=" +  
							StringUtil.enCode("精准定位数据包.zip", "ISO-8859-1"));
			OutputStream out = response.getOutputStream();
			out.write(bos.toByteArray());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * 将测量工程和测量点内的所有图片添加到压缩包内
	 * @param task
	 * @param foldName
	 * @param zos
	 * @throws Exception 
	 */
	private void addTaskFile(MeasureProject measureProject, String foldName, ZipOutputStream zos) throws Exception{
		Attachment attachment = new Attachment();
		attachment.setEntityName("measureProject");
		attachment.setEntityId(measureProject.getMeasureProjectId());
		attachment.setFieldName("attachments");
		String pointNames = measureProject.getMeasureProjectName();
		this.writeFile(zos, foldName,attachment,measureProject,pointNames);
		List<MeasurePoint> pointList = measureProject.getMeasurePointList();
		if(null != pointList && !pointList.isEmpty()){
			for(int i = 0; i < pointList.size(); i++){
				MeasurePoint measurePoint = pointList.get(i);
				pointNames = measurePoint.getMeasurePointName();
				Attachment attachmentPoint = new Attachment();
				attachmentPoint.setEntityName("measurePoint");
				attachmentPoint.setFieldName("attachments");
				attachmentPoint.setEntityId(measurePoint.getMeasurePointId());
				this.writeFile(zos, foldName, attachmentPoint, measurePoint,pointNames);
			}
		}
	}
	
	/**
	 * 将附件写入文件
	 * @param zos
	 * @param foldName
	 * @param attachmentParam
	 * @param task
	 * @throws Exception
	 */
	private void writeFile(ZipOutputStream zos, String foldName, Attachment attachmentParam, Object task,String pointName) throws Exception{
		List<Attachment> attachmentList = attachmentService.getAttachments(attachmentParam);
		String taskFileNames = "";
		String pointNames;
		int num = 0;
		for(Attachment attachment : attachmentList) {
			
			try{	
				File file = attachmentService.getFile(attachment,false);
				pointNames = pointName + "-" +(num+=1);
				zos.putNextEntry(new ZipEntry(foldName + "/" + pointNames + ".jpg"));//图片名称
				//zos.putNextEntry(new ZipEntry(foldName + "/" + attachment.getFileName()));//图片名称
				taskFileNames += attachment.getFileName()+",";
				InputStream in = new FileInputStream(file);
				int len = 0;  
				while ((len = in.read()) != -1)  
				    zos.write(len);  
				in.close(); 
			}catch(Exception e){
				throw new Exception(e.getMessage());
			}
		}
		if(!StringUtils.isEmpty(taskFileNames)){
			String attachmentName = taskFileNames.substring(0, taskFileNames.length() -1);
			if(task instanceof MeasureProject) {
				((MeasureProject) task).setAttachmentName(attachmentName);
			}
			if(task instanceof MeasurePoint) {
				((MeasurePoint) task).setAttachmentName(attachmentName);
			}
		}
	}
	
	@RequestMapping(value="/measureProject/editProjectInfo")
	public void exprojectInfo(String measureProjectId,HttpServletResponse response) {
		try {
		//在内存中创建zip文件
		ByteArrayOutputStream bos = new ByteArrayOutputStream();  
		ZipOutputStream zos = new ZipOutputStream(bos);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(zos, "UTF-8"));
		List<MeasureProject> measureProjectList = measureProjectService.exportProjectInfo(measureProjectId);
		if(null == measureProjectList || measureProjectList.size() == 0) {
			response.setContentType("text/html;charset=UTF-8"); 
			response.getWriter().write("未找到可下载的数据");
			return;
		}
		for(int i = 0; i < measureProjectList.size(); i++) {
			MeasureProject measureProject = measureProjectList.get(i);	//当前任务
			String projectId = measureProject.getMeasureProjectId();	//任务ID
			String projectName = measureProject.getMeasureProjectName();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");//格式化时间类型
			String creatDate = sdf.format(measureProject.getCreateDate())+"";
			String foldName = projectName + creatDate;	//目录名称
			// 添加附件图片
			try {
				addTaskFile(measureProject, foldName, zos);   
			} catch (Exception e) {
				e.printStackTrace();
			}	
			String excelName = "/" + projectName + ".xls";
			//添加生成excel
			try {
				measureProjectService.exportMeasureProjectZip(projectId,response,foldName,excelName,zos);
			} catch (Exception e) {
				e.printStackTrace();
			}	
			bw.flush();
			zos.closeEntry(); //关闭压缩流
		}
		bw.close();
		zos.close();
		//下载文件
		response.setContentType("application/x-msdownload;charset=GBK");
		response.setHeader("Content-Disposition", "attachment; filename=" +  
						StringUtil.enCode("测量工程数据包.zip", "ISO-8859-1"));
		OutputStream out = response.getOutputStream();
		out.write(bos.toByteArray());
		out.flush();
		out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
