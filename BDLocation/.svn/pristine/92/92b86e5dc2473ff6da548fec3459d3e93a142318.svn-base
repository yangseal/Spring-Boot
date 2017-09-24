package com.cnten.bdlocation.oamproject.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.cnten.bdlocation.oamproject.service.OamProjectService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.OamCustomer;
import com.cnten.po.OamProject;

@Controller
@RequestMapping(value = "/oamProject")
public class OamProjectController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	private OamProjectService oamProjectService;
	
	@RequestMapping(value = "/showOamProjects")
	public void showOamProjects() {
	}
	
	@RequestMapping(value = "/showOamProject")
	public void showOamProject(String oamProjectId, Model model) {
		OamProject oamProject = oamProjectService.getOamProject(oamProjectId);
		model.addAttribute("oamProject", oamProject);
	}
	
	@RequestMapping(value = "/queryOamProjects")
	public void queryOamProjects(String oamProjectName,OamCustomer oamCustomer, Integer pageIndex, Integer pageSize, Model model) {
		OamProject oamProject = new OamProject();
		oamProject.setOamProjectName(oamProjectName);
		oamProject.setOamCustomer(oamCustomer);
		Page page = oamProjectService.getOamProjectsPage(oamProject, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@RequestMapping(value = "/selectOamProject")
	public void selectOamProject() {
	}
	
	@RequestMapping(value = "/selectOamProjects")
	public void selectOamProjects(String oamProjectName,String oamProjectCode,OamCustomer oamCustomer, Integer pageIndex, Integer pageSize, Model model) {
		OamProject oamProject = new OamProject();
		oamProject.setOamProjectName(oamProjectName);
		oamProject.setOamProjectCode(oamProjectCode);
		oamProject.setOamProjectName(oamProjectName);
		oamProject.setOamCustomer(oamCustomer);
		Page page = oamProjectService.getOamProjectsPage(oamProject, pageIndex, pageSize);
		model.addAttribute(page);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOamProject")
	public SuccessOrFailure saveOamProject(OamProject oamProject, String customerId){
		try {
			if(!StringUtils.isEmpty(customerId)) {
				oamProject.setOamCustomer(new OamCustomer(customerId));
			}
			oamProjectService.saveOamProject(oamProject);
			return SuccessOrFailure.SUCCESS(oamProject.getOamProjectId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteOamProject")
	public SuccessOrFailure deleteOamProject(String oamProjectIds){
		try {
			oamProjectService.deleteOamProject(oamProjectIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/exportOamProjects")
	public void exportOamProjects(OamProject oamProject, HttpServletResponse response) {
		try {
			oamProjectService.exportOamProjects(oamProject, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
