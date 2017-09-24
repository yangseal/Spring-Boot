package com.cnten.platform.system.controller;

import java.util.List;
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

import com.cnten.platform.system.service.DepartmentService;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.Department;

@Controller
public class DepartmentController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value = "/department/showDepartments")
	public void showDepartments(Model model) {
		List<Department> departments = departmentService.getDepartments();
		model.addAttribute("departments", departments);
	}
	
	@RequestMapping(value = "/department/showDepartment")
	public void showDepartment(String departmentId, Model model) {
		Department department = departmentService.getDepartment(departmentId);
		model.addAttribute("department", department);
	}
	
	@RequestMapping(value = "/department/selectDepartment")
	public void selectDepartment(Model model) {
		List<Department> departments = departmentService.getDepartments();
		model.addAttribute("departments", departments);
	}
	
	@ResponseBody
	@RequestMapping(value = "/department/saveDepartment")
	public SuccessOrFailure saveDepartment(Department department){
		try {
			departmentService.saveDepartment(department);
			return SuccessOrFailure.SUCCESS(department.getDepartmentId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/department/deleteDepartment")
	public SuccessOrFailure deleteDepartment(String departmentId){
		try {
			departmentService.deleteDepartment(departmentId);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
}
