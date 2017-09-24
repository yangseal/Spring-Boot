package com.cnten.po;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.GenericGenerator;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Entity
public class StakeoutPoint {

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String stakeoutPointId;
    @Column(length = 20)
    private String stakeoutPointName;
    @ManyToOne
    @JoinColumn(name="point_type_id")
    private PointType affiliationPointType;
    @Transient
    private String affiliationPointTypeId;
    private Double altitude;
    private Double longitude;
    private Double latitude;
    private Double coordinateX;
    private Double coordinateY;
    private Date createDate;
    @ManyToOne
    @JoinColumn(name="stakeout_task_id")
    private StakeoutTask affiliationStakeoutTask;
    @Transient
    private String affiliationStakeoutTaskId;
    @Column(columnDefinition="TEXT")
	@Lob 
	@Basic(fetch = FetchType.LAZY)
	private String dynamicField;
	@SuppressWarnings("rawtypes")
	@Transient
	private List<Map> dynamicList;
    @Column(length = 1)
    private String isDelete;
    
    public StakeoutPoint() {
    }
    
    public StakeoutPoint(String stakeoutPointId) {
    	this.stakeoutPointId = stakeoutPointId;
    }
    
    public String getStakeoutPointId() {
    	return stakeoutPointId;
    }
    public void setStakeoutPointId(String stakeoutPointId) {
    	this.stakeoutPointId = stakeoutPointId;
    }
    /**
     * 获得点名称
     * @return stakeoutPointName
     */
    public String getStakeoutPointName() {
    	return stakeoutPointName;
    }
    /**
     * 设置点名称
     * @param stakeoutPointName
     */
    public void setStakeoutPointName(String stakeoutPointName) {
    	this.stakeoutPointName = stakeoutPointName;
    }
    /**
     * 获得所属点类型
     * @return affiliationPointType
     */
    public PointType getAffiliationPointType() {
    	return affiliationPointType;
    }
    /**
     * 设置所属点类型
     * @param affiliationPointType
     */
    public void setAffiliationPointType(PointType affiliationPointType) {
    	this.affiliationPointType = affiliationPointType;
    }
    /**
     * 获得所属点类型Id
     * @return affiliationPointTypeId
     */
    public String getAffiliationPointTypeId() {
    	return affiliationPointTypeId;
    }
    /**
     * 设置所属点类型Id
     * @param affiliationPointTypeId
     */
    public void setAffiliationPointTypeId(String affiliationPointTypeId) {
    	this.affiliationPointTypeId = affiliationPointTypeId;
    }
    /**
     * 获得高程
     * @return altitude
     */
    public Double getAltitude() {
    	return altitude;
    }
    /**
     * 设置高程
     * @param altitude
     */
    public void setAltitude(Double altitude) {
    	this.altitude = altitude;
    }
    /**
     * 获得纬度
     * @return longitude
     */
    public Double getLongitude() {
    	return longitude;
    }
    /**
     * 设置经度
     * @param longitude
     */
    public void setLongitude(Double longitude) {
    	this.longitude = longitude;
    }
    /**
     * 获得纬度
     * @return latitude
     */
    public Double getLatitude() {
    	return latitude;
    }
    /**
     * 设置纬度
     * @param latitude
     */
    public void setLatitude(Double latitude) {
    	this.latitude = latitude;
    }
    /**
     * 获得城建坐标X
     * @return coordinateX
     */
    public Double getCoordinateX() {
    	return coordinateX;
    }
    /**
     * 设置城建坐标X
     * @param coordinateX
     */
    public void setCoordinateX(Double coordinateX) {
    	this.coordinateX = coordinateX;
    }
    /**
     * 获得城建坐标Y
     * @return coordinateY
     */
    public Double getCoordinateY() {
    	return coordinateY;
    }
    /**
     * 设置城建坐标Y
     * @param coordinateY
     */
    public void setCoordinateY(Double coordinateY) {
    	this.coordinateY = coordinateY;
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
     * 获得所属放样任务
     * @return affiliationStakeoutTask
     */
    public StakeoutTask getAffiliationStakeoutTask() {
    	return affiliationStakeoutTask;
    }
    /**
     * 设置所属放样任务
     * @param affiliationStakeoutTask
     */
    public void setAffiliationStakeoutTask(StakeoutTask affiliationStakeoutTask) {
    	this.affiliationStakeoutTask = affiliationStakeoutTask;
    }
    /**
     * 获得所属放样任务Id
     * @return affiliationStakeoutTaskId
     */
    public String getAffiliationStakeoutTaskId() {
    	return affiliationStakeoutTaskId;
    }
    /**
     * 设置所属放样任务Id
     * @param affiliationStakeoutTaskId
     */
    public void setAffiliationStakeoutTaskId(String affiliationStakeoutTaskId) {
    	this.affiliationStakeoutTaskId = affiliationStakeoutTaskId;
    }
	/**
	 * 获取动态字段
	 * @return dynamicField
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
	@SuppressWarnings("rawtypes")
	public List<Map> getDynamicList() {
		if (StringUtils.isNotBlank(this.dynamicField)) {
			dynamicList = JSONArray.parseArray(dynamicField, Map.class);
			transformDictValues();
		}
		return dynamicList;
	}
	@SuppressWarnings("unchecked")
	private void transformDictValues() {
		if (StringUtils.isBlank(this.affiliationPointType.getDynamicField())) {
			return;
		}
		JSONArray array = JSONArray.parseArray(this.affiliationPointType.getDynamicField());
		for (int i = 0; i < array.size(); i++) {
			JSONObject obj = array.getJSONObject(i);
			if (obj.getString("viewType").equals("RadioGroup")
					|| obj.getString("viewType").equals("CheckBoxGroup")
					|| obj.getString("viewType").equals("DropDownList")
					|| obj.getString("viewType").equals("ToggleButton")) {
				for(Map<String,String> dynamic : dynamicList) {
					transformDictValue(dynamic, obj);
				}
			}

		}
	}
	private void transformDictValue(Map<String,String> dynamic,JSONObject obj) {
		String dataCode = (String) dynamic.get("fieldCode");
		if(dataCode == null) {
			return;
		}
		if (obj.getString("dataCode").equals(dataCode)) {
			String fieldValue = (String) dynamic.get("fieldValue");
			String[] fieldItem = fieldValue.split(",");
			Arrays.asList(fieldValue);
			String dictionary = obj.getString("dictionary");
			String[] itemsArray = dictionary.split(";");
			String result = "";
			for(String item : fieldItem) {
				for (String itemString : itemsArray) {
					String[] itemArray = itemString.split(",");
					if (itemArray[0].equals(item)) {
						result += itemArray[1]+",";
					}
				}
			}
			if(result.length() != 0) {
				dynamic.put("fieldValue", result.substring(0, result.length()-1));
			}
		}
	}
    public String getIsDelete() {
    	return isDelete;
    }
    public void setIsDelete(String isDelete) {
    	this.isDelete = isDelete;
    }
} 		