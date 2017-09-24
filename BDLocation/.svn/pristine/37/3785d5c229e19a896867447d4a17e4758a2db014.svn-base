package com.cnten.po;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.cnten.platform.util.StringUtil;

@Entity
public class PointType {

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String pointTypeId;
    @Column(length = 20)
    private String pointTypeCode;
    @Column(length = 20)
    private String pointTypeName;
    private Date createDate;
    @Column(length = 1)
    private String typeState;
    @Column(length = 100)
    private String typeDesc;
    @Column(length = 1)
    private String isDelete;
    @Column(columnDefinition="TEXT")
    @Lob 
	@Basic(fetch = FetchType.LAZY)
    private String dynamicField;
    @Transient
    private String companyId;
    
    @Transient
    private String pointTypeTreeName;
    
    public static final String typeStateDictStatement = "Y,是;N,否";
    
    public PointType() {
    }
    
    public PointType(String pointTypeId) {
    	this.pointTypeId = pointTypeId;
    }
    
    public String getPointTypeId() {
    	return pointTypeId;
    }
    public void setPointTypeId(String pointTypeId) {
    	this.pointTypeId = pointTypeId;
    }
    /**
     * 获得编码
     * @return pointTypeCode
     */
    public String getPointTypeCode() {
    	return pointTypeCode;
    }
    /**
     * 设置编码
     * @param pointTypeCode
     */
    public void setPointTypeCode(String pointTypeCode) {
    	this.pointTypeCode = pointTypeCode;
    }
    /**
     * 获得名称
     * @return pointTypeName
     */
    public String getPointTypeName() {
    	return pointTypeName;
    }
    /**
     * 设置名称
     * @param pointTypeName
     */
    public void setPointTypeName(String pointTypeName) {
    	this.pointTypeName = pointTypeName;
    }
    /**
     * 获得创建日期
     * @return createDate
     */
    public Date getCreateDate() {
    	return createDate;
    }
    /**
     * 设置创建日期
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
    	this.createDate = createDate;
    }
    /**
     * 获得是否可用
     * <br/>
     * 字典(Y,是;N,否)
     * @return typeState
     */
    public String getTypeState() {
    	return typeState;
    }
    /**
     * 获得是否可用字典名
     * <br/>
     * 字典(Y,是;N,否)
     * @return typeStateName
     */
    public String getTypeStateName(){
    	return StringUtil.getDictName(typeState,typeStateDictStatement);
    }
    /**
     * 设置是否可用
     * @param typeState
     */
    public void setTypeState(String typeState) {
    	this.typeState = typeState;
    }
    /**
     * 获得描述
     * @return typeDesc
     */
    public String getTypeDesc() {
    	return typeDesc;
    }
    /**
     * 设置描述
     * @param typeDesc
     */
    public void setTypeDesc(String typeDesc) {
    	this.typeDesc = typeDesc;
    }
    public String getIsDelete() {
    	return isDelete;
    }
    
    /**
     * 获取动态字段
     * @return
     */
    public String getDynamicField() {
		return dynamicField;
	}

    /**
     * 设置动态字段
     * @param dynamicField
     */
	public void setDynamicField(String dynamicField) {
		this.dynamicField = dynamicField;
	}

	public void setIsDelete(String isDelete) {
    	this.isDelete = isDelete;
    }
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getPointTypeTreeName() {
		return pointTypeName+"("+pointTypeCode+")";
	}

	public void setPointTypeTreeName(String pointTypeTreeName) {
		this.pointTypeTreeName = pointTypeTreeName;
	}
	
} 		