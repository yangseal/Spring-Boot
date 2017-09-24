package com.cnten.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Department {

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String departmentId;
    @Column(length = 32)
    private String parentId;
    @Column(length = 50)
    private String departmentName;
    @Column(length = 50)
    private String departmentCode;
    @Column(length = 1)
    private String isDelete;
    
    public Department() {
    }
    
    public Department(String departmentId) {
    	this.departmentId = departmentId;
    }
    
    public String getDepartmentId() {
    	return departmentId;
    }
    public void setDepartmentId(String departmentId) {
    	this.departmentId = departmentId;
    }
    public String getParentId() {
    	return parentId;
    }
    public void setParentId(String parentId) {
    	this.parentId = parentId;
    }
    public String getDepartmentName() {
    	return departmentName;
    }
    public void setDepartmentName(String departmentName) {
    	this.departmentName = departmentName;
    }
    public String getDepartmentCode() {
    	return departmentCode;
    }
    public void setDepartmentCode(String departmentCode) {
    	this.departmentCode = departmentCode;
    }
    public String getIsDelete() {
    	return isDelete;
    }
    public void setIsDelete(String isDelete) {
    	this.isDelete = isDelete;
    }
} 		