package com.cnten.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class OamProjectTesting {

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String oamProjectTestingId;
    @ManyToOne
    @JoinColumn(name="oam_project_id")
    private OamProject oamProject;
    @Column(length = 200)
    private String oamProjectTestingName;
    @Column(length = 200)
    private String testingSchedule;
    @Column(length = 200)
    private String planSchedule;
    @Column(length = 200)
    private String schedule;
    @Column(length = 1)
    private String isDelete;
    
    public String getOamProjectTestingId() {
    	return oamProjectTestingId;
    }
    public void setOamProjectTestingId(String oamProjectTestingId) {
    	this.oamProjectTestingId = oamProjectTestingId;
    }
    /**
     * 获得所属项目
     * @return oamProject
     */
    public OamProject getOamProject() {
    	return oamProject;
    }
    /**
     * 设置所属项目
     * @param oamProject
     */
    public void setOamProject(OamProject oamProject) {
    	this.oamProject = oamProject;
    }
    /**
     * 获得项目测试名称
     * @return oamProjectTestingName
     */
    public String getOamProjectTestingName() {
    	return oamProjectTestingName;
    }
    /**
     * 设置项目测试名称
     * @param oamProjectTestingName
     */
    public void setOamProjectTestingName(String oamProjectTestingName) {
    	this.oamProjectTestingName = oamProjectTestingName;
    }
    /**
     * 获得测试日程描述
     * @return testingSchedule
     */
    public String getTestingSchedule() {
    	return testingSchedule;
    }
    /**
     * 设置测试日程描述
     * @param testingSchedule
     */
    public void setTestingSchedule(String testingSchedule) {
    	this.testingSchedule = testingSchedule;
    }
    /**
     * 获得初拟基建日程描述
     * @return planSchedule
     */
    public String getPlanSchedule() {
    	return planSchedule;
    }
    /**
     * 设置初拟基建日程描述
     * @param planSchedule
     */
    public void setPlanSchedule(String planSchedule) {
    	this.planSchedule = planSchedule;
    }
    /**
     * 获得确定基建日程描述
     * @return schedule
     */
    public String getSchedule() {
    	return schedule;
    }
    /**
     * 设置确定基建日程描述
     * @param schedule
     */
    public void setSchedule(String schedule) {
    	this.schedule = schedule;
    }
    public String getIsDelete() {
    	return isDelete;
    }
    public void setIsDelete(String isDelete) {
    	this.isDelete = isDelete;
    }
} 		