package com.cnten.platform.system.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.po.Department;

@Service
public class DepartmentService {

	@Autowired
	CommonDAO commonDAO;
	
	public List<Department> getDepartments() {
		String hql = "from Department where isDelete is null";
		List<Department> departments = commonDAO.queryListByVariableParam(hql);
		List<Department> sortedDepartments = new ArrayList<Department>();
		for(Department department : departments){
			if(StringUtils.isEmpty(department.getParentId())){
				sortedDepartments.add(department);
				addChildren(department, departments, sortedDepartments);
			}
		}
		return sortedDepartments;
	}

	private void addChildren(Department department,List<Department> departments,List<Department> sortedDepartments){
		for(Department m : departments){
			if(department.getDepartmentId().equals(m.getParentId())){
				sortedDepartments.add(m);
				addChildren(m, departments, sortedDepartments);
			}
		}
	}

	public Department getDepartment(String departmentId) {
		return commonDAO.get(Department.class, departmentId);
	}

	public void saveDepartment(Department department) {
		String departmentId = department.getDepartmentId();
		if(StringUtils.isEmpty(departmentId)){
			commonDAO.save(department);
		}else{
			Department oldDepartment = commonDAO.load(Department.class, departmentId);
			oldDepartment.setDepartmentName(department.getDepartmentName());
			oldDepartment.setDepartmentCode(department.getDepartmentCode());
			commonDAO.update(oldDepartment);
		}
	}

	public void deleteDepartment(String departmentId){
		Department oldDepartment = commonDAO.load(Department.class, departmentId);
		oldDepartment.setIsDelete("Y");
		commonDAO.update(oldDepartment);
	}
}