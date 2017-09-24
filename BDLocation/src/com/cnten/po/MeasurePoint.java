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
import com.cnten.platform.util.StringUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 测量点即为位置对象
 * @author wudong
 *
 */
@Entity
public class MeasurePoint {

	@Id
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@GeneratedValue(generator = "generator")
	@Column(unique = true, nullable = false, length = 32)
	private String measurePointId;
	@Column(length = 20)
	private String measurePointName;
	@Column(length = 20)
	private String measurePointCode;
	@ManyToOne
	@JoinColumn(name = "point_type_id")
	private PointType affiliationPointType;
	@Transient
	private String affiliationPointTypeId;
	@Column(length = 100)
	private String pointDesc;
	@Column(length = 20)
	private String solutionState;
	private String hrms;
	private String vrms;
	private Double longitude;
	private Double latitude;
	private Double north;
	private Double east;
	private Double coordinateX;
	private Double coordinateY;
	private Double ellHeight;
	private Double altitude;
	private Date createDate;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "measure_project_id")
	private MeasureProject affiliationProject;
	@Transient
	private String affiliationProjectId;
	@Column(length = 1)
	private String isDelete;
	@Column(columnDefinition="TEXT")
	@Lob 
	@Basic(fetch = FetchType.LAZY)
	private String dynamicField;
	@SuppressWarnings("rawtypes")
	@Transient
	private List<Map> dynamicList;
	@Transient
	private String attachmentId;
	@Transient
	private String attachmentName;
	public static final String solutionStateDictStatement = "ST_INVALID_FIX,未定位;ST_GPS_FIX,单点解;ST_DGPS_FIX,差分解;ST_FRTK_FIX,浮点解;ST_RTK_FIX,固定解";
	
	/**
	 * 创建位置对象
	 */
	public MeasurePoint() {
	}

	public MeasurePoint(String measurePointId) {
		this.measurePointId = measurePointId;
	}

	public String getMeasurePointId() {
		return measurePointId;
	}

	public void setMeasurePointId(String measurePointId) {
		this.measurePointId = measurePointId;
	}

	/**
	 * 获得点名称
	 * 
	 * @return measurePointName
	 */
	public String getMeasurePointName() {
		return measurePointName;
	}

	/**
	 * 设置点名称
	 * 
	 * @param measurePointName
	 */
	public void setMeasurePointName(String measurePointName) {
		this.measurePointName = measurePointName;
	}

	/**
	 * 获得点编码
	 * 
	 * @return measurePointCode
	 */
	public String getMeasurePointCode() {
		return measurePointCode;
	}

	/**
	 * 设置点编码
	 * 
	 * @param measurePointCode
	 */
	public void setMeasurePointCode(String measurePointCode) {
		this.measurePointCode = measurePointCode;
	}

	/**
	 * 获得所属点类型
	 * 
	 * @return affiliationPointType
	 */
	public PointType getAffiliationPointType() {
		return affiliationPointType;
	}

	/**
	 * 设置所属点类型
	 * 
	 * @param affiliationPointType
	 */
	public void setAffiliationPointType(PointType affiliationPointType) {
		this.affiliationPointType = affiliationPointType;
	}

	/**
	 * 获得所属点类型Id
	 * 
	 * @return affiliationPointTypeId
	 */
	public String getAffiliationPointTypeId() {
		return affiliationPointTypeId;
	}

	/**
	 * 设置所属点类型Id
	 * 
	 * @param affiliationPointTypeId
	 */
	public void setAffiliationPointTypeId(String affiliationPointTypeId) {
		this.affiliationPointTypeId = affiliationPointTypeId;
	}

	/**
	 * 获得描述
	 * 
	 * @return pointDesc
	 */
	public String getPointDesc() {
		return pointDesc;
	}

	/**
	 * 设置描述
	 * 
	 * @param pointDesc
	 */
	public void setPointDesc(String pointDesc) {
		this.pointDesc = pointDesc;
	}

	/**
	 * 获得解状态 <br/>
	 * 字典(ST_INVALID_FIX,未定位;ST_GPS_FIX,单点解;ST_DGPS_FIX,差分解;ST_FRTK_FIX,浮点解;
	 * ST_RTK_FIX,固定解)
	 * 
	 * @return solutionState
	 */
	public String getSolutionState() {
		return solutionState;
	}

	/**
	 * 获得解状态字典名 <br/>
	 * 字典(ST_INVALID_FIX,未定位;ST_GPS_FIX,单点解;ST_DGPS_FIX,差分解;ST_FRTK_FIX,浮点解;
	 * ST_RTK_FIX,固定解)
	 * 
	 * @return solutionStateName
	 */
	public String getSolutionStateName() {
		return StringUtil
				.getDictName(solutionState, solutionStateDictStatement);
	}

	/**
	 * 设置解状态
	 * 
	 * @param solutionState
	 */
	public void setSolutionState(String solutionState) {
		this.solutionState = solutionState;
	}

	/**
	 * 获得hrms
	 * 
	 * @return hrms
	 */
	public String getHrms() {
		return hrms;
	}

	/**
	 * 设置hrms
	 * 
	 * @param hrms
	 */
	public void setHrms(String hrms) {
		this.hrms = hrms;
	}

	/**
	 * 获得vrms
	 * 
	 * @return vrms
	 */
	public String getVrms() {
		return vrms;
	}

	/**
	 * 设置vrms
	 * 
	 * @param vrms
	 */
	public void setVrms(String vrms) {
		this.vrms = vrms;
	}

	/**
	 * 获得经度
	 * 
	 * @return longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * 设置经度
	 * 
	 * @param longitude
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * 获得纬度
	 * 
	 * @return latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * 设置纬度
	 * 
	 * @param latitude
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * 获得北坐标
	 * 
	 * @return north
	 */
	public Double getNorth() {
		return north;
	}

	/**
	 * 设置北坐标
	 * 
	 * @param north
	 */
	public void setNorth(Double north) {
		this.north = north;
	}

	/**
	 * 获得东坐标
	 * 
	 * @return east
	 */
	public Double getEast() {
		return east;
	}

	/**
	 * 设置东坐标
	 * 
	 * @param east
	 */
	public void setEast(Double east) {
		this.east = east;
	}

	/**
	 * 获得城建坐标X
	 * 
	 * @return coordinateX
	 */
	public Double getCoordinateX() {
		return coordinateX;
	}

	/**
	 * 设置城建坐标X
	 * 
	 * @param coordinateX
	 */
	public void setCoordinateX(Double coordinateX) {
		this.coordinateX = coordinateX;
	}

	/**
	 * 获得城建坐标Y
	 * 
	 * @return coordinateY
	 */
	public Double getCoordinateY() {
		return coordinateY;
	}

	/**
	 * 设置城建坐标Y
	 * 
	 * @param coordinateY
	 */
	public void setCoordinateY(Double coordinateY) {
		this.coordinateY = coordinateY;
	}

	/**
	 * 获得椭球高
	 * 
	 * @return ellHeight
	 */
	public Double getEllHeight() {
		return ellHeight;
	}

	/**
	 * 设置椭球高
	 * 
	 * @param ellHeight
	 */
	public void setEllHeight(Double ellHeight) {
		this.ellHeight = ellHeight;
	}

	/**
	 * 获得高程
	 * 
	 * @return altitude
	 */
	public Double getAltitude() {
		return altitude;
	}

	/**
	 * 设置高程
	 * 
	 * @param altitude
	 */
	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}

	/**
	 * 获得创建时间
	 * 
	 * @return createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 设置创建时间
	 * 
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 获得所属工程
	 * 
	 * @return affiliationProject
	 */
	public MeasureProject getAffiliationProject() {
		return affiliationProject;
	}

	/**
	 * 设置所属工程
	 * 
	 * @param affiliationProject
	 */
	public void setAffiliationProject(MeasureProject affiliationProject) {
		this.affiliationProject = affiliationProject;
	}

	/**
	 * 获得所属工程Id
	 * 
	 * @return affiliationProjectId
	 */
	public String getMeasureProjectId() {
		return affiliationProjectId;
	}

	/**
	 * 设置所属工程Id
	 * 
	 * @param affiliationProjectId
	 */
	public void setMeasureProjectId(String measureProjectId) {
		this.affiliationProjectId = measureProjectId;
	}

	/**
	 * 获得所属工程Id
	 * 
	 * @return affiliationProjectId
	 */
	public String getAffiliationProjectId() {
		return affiliationProjectId;
	}

	/**
	 * 设置所属工程Id
	 * 
	 * @param affiliationProjectId
	 */
	public void setAffiliationProjectId(String affiliationProjectId) {
		this.affiliationProjectId = affiliationProjectId;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	/**
	 * 获取动态字段
	 * 
	 * @return
	 */
	public String getDynamicField() {
		return dynamicField;
	}

	/**
	 * 设置动态字段
	 * 
	 * @param dynamicField
	 */
	public void setDynamicField(String dynamicField) {
		this.dynamicField = dynamicField;
	}

	public String getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
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

}