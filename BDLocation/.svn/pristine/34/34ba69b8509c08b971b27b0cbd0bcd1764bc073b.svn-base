package com.cnten.bdlocation.baseStation.customer.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.baseStation.construction.service.BaseConstructService;
import com.cnten.bdlocation.baseStation.customer.service.BaseProjectService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.BaseConstruct;
import com.cnten.po.BaseProject;

@Controller
@RequestMapping(value="baseStation/customer")
public class BaseProjectController {
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@Autowired
	private BaseProjectService baseProjectService;
	@Autowired
	private BaseConstructService baseConstructService;

	//基站项目管理
	@RequestMapping(value="/showProjects")
	public void showProjects(String baseCustomerId,Model model){
		model.addAttribute("baseCustomerId", baseCustomerId);
	}
	@RequestMapping(value="/queryProjects")
	public void queryProjects(BaseProject baseProject,Integer pageIndex,Integer pageSize,Model model){
		Page page = baseProjectService.getBaseProjectsPage(baseProject,pageIndex,pageSize);
		model.addAttribute(page);
	}
	@RequestMapping(value="/showProject")
	public void showProject(String baseCustomerId,String projectId,Model model){
		BaseProject project = baseProjectService.getProject(projectId);
		model.addAttribute("baseCustomerId",baseCustomerId);
		model.addAttribute("project", project);
	}
	@ResponseBody
	@RequestMapping(value="/saveProject")
	public SuccessOrFailure saveProject(BaseProject baseProject){
		try{
			baseProjectService.saveProject(baseProject);
			return SuccessOrFailure.SUCCESS(baseProject.getBaseProjectId());
		}catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	@RequestMapping(value="/showBSConstructs")
	public void showBSConstructs(String projectId,Model model){
		model.addAttribute("baseProjectId", projectId);
	}
	@RequestMapping(value="/queryBSConstructs")
	public void queryContructs(BaseConstruct baseConstruct, Integer pageIndex, Integer pageSize, Model model){
		Page page = baseConstructService.getConstructByPage(baseConstruct, pageIndex, pageSize);
		model.addAttribute(page);
	}
}
