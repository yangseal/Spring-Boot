package com.cnten.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ConversionParam {

	@Id
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@GeneratedValue(generator = "generator")
	@Column(unique = true, nullable = false, length = 32)
	private String conversionParamId;
	@Column(length = 32)
	private String parentId;
	@Column(length = 100)
	private String conversionParamName;
	@Column(length = 50)
	private String conversionParamCode;
	private Integer ellipoidSys;
	private Integer ellipoidSys2;
	private Double north;
	private Double south;
	private Double west;
	private Double east;
	private Double northLat;
	private Double southLat;
	private Double westLng;
	private Double eastLng;
	private Double x;
	private Double reverseX;
	private Double y;
	private Double reverseY;
	private Double z;
	private Double reverseZ;
	private Double k;
	private Double reverseK;
	private Double xt;
	private Double reverseXt;
	private Double yt;
	private Double reverseYt;
	private Double zt;
	private Double reverseZt;
	private Integer conversionType;
	private Double pt1B;
	private Double pt1L;
	private Double pt1H;
	private Double pt1X;
	private Double pt1Y;
	private Double pt1Z;
	private Double pt2B;
	private Double pt2L;
	private Double pt2H;
	private Double pt2X;
	private Double pt2Y;
	private Double pt2Z;
	private Double pt3B;
	private Double pt3L;
	private Double pt3H;
	private Double pt3X;
	private Double pt3Y;
	private Double pt3Z;
	@Column(length = 500)
	private String info;
	@ManyToOne
	@JoinColumn(name = "conversion_projection_id")
	private ConversionProjection conversionProjection;
	@Column(length = 1)
	private String isDelete;

	public ConversionParam() {
	}

	public ConversionParam(String conversionParamId) {
		this.conversionParamId = conversionParamId;
	}

	public String getConversionParamId() {
		return conversionParamId;
	}

	public void setConversionParamId(String conversionParamId) {
		this.conversionParamId = conversionParamId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * 获得转换参数名称
	 * 
	 * @return conversionParamName
	 */
	public String getConversionParamName() {
		return conversionParamName;
	}

	/**
	 * 设置转换参数名称
	 * 
	 * @param conversionParamName
	 */
	public void setConversionParamName(String conversionParamName) {
		this.conversionParamName = conversionParamName;
	}

	/**
	 * 获得转换参数编码
	 * 
	 * @return conversionParamCode
	 */
	public String getConversionParamCode() {
		return conversionParamCode;
	}

	/**
	 * 设置转换参数编码
	 * 
	 * @param conversionParamCode
	 */
	public void setConversionParamCode(String conversionParamCode) {
		this.conversionParamCode = conversionParamCode;
	}

	/**
	 * 获得源椭球体系
	 * 
	 * @return ellipoidSys
	 */
	public Integer getEllipoidSys() {
		return ellipoidSys;
	}

	/**
	 * 设置源椭球体系
	 * 
	 * @param ellipoidSys
	 */
	public void setEllipoidSys(Integer ellipoidSys) {
		this.ellipoidSys = ellipoidSys;
	}

	/**
	 * 获得目标椭球体系
	 * 
	 * @return ellipoidSys2
	 */
	public Integer getEllipoidSys2() {
		return ellipoidSys2;
	}

	/**
	 * 设置目标椭球体系
	 * 
	 * @param ellipoidSys2
	 */
	public void setEllipoidSys2(Integer ellipoidSys2) {
		this.ellipoidSys2 = ellipoidSys2;
	}

	/**
	 * 获得北边界
	 * 
	 * @return north
	 */
	public Double getNorth() {
		return north;
	}

	/**
	 * 设置北边界
	 * 
	 * @param north
	 */
	public void setNorth(Double north) {
		this.north = north;
	}

	/**
	 * 获得南边界
	 * 
	 * @return south
	 */
	public Double getSouth() {
		return south;
	}

	/**
	 * 设置南边界
	 * 
	 * @param south
	 */
	public void setSouth(Double south) {
		this.south = south;
	}

	/**
	 * 获得西边界
	 * 
	 * @return west
	 */
	public Double getWest() {
		return west;
	}

	/**
	 * 设置西边界
	 * 
	 * @param west
	 */
	public void setWest(Double west) {
		this.west = west;
	}

	/**
	 * 获得东边界
	 * 
	 * @return east
	 */
	public Double getEast() {
		return east;
	}

	/**
	 * 设置东边界
	 * 
	 * @param east
	 */
	public void setEast(Double east) {
		this.east = east;
	}

	/**
	 * 获得北边纬度
	 * 
	 * @return northLat
	 */
	public Double getNorthLat() {
		return northLat;
	}

	/**
	 * 设置北边纬度
	 * 
	 * @param northLat
	 */
	public void setNorthLat(Double northLat) {
		this.northLat = northLat;
	}

	/**
	 * 获得南边纬度
	 * 
	 * @return southLat
	 */
	public Double getSouthLat() {
		return southLat;
	}

	/**
	 * 设置南边纬度
	 * 
	 * @param southLat
	 */
	public void setSouthLat(Double southLat) {
		this.southLat = southLat;
	}

	/**
	 * 获得西边经度
	 * 
	 * @return westLng
	 */
	public Double getWestLng() {
		return westLng;
	}

	/**
	 * 设置西边经度
	 * 
	 * @param westLng
	 */
	public void setWestLng(Double westLng) {
		this.westLng = westLng;
	}

	/**
	 * 获得东边经度
	 * 
	 * @return eastLng
	 */
	public Double getEastLng() {
		return eastLng;
	}

	/**
	 * 设置东边经度
	 * 
	 * @param eastLng
	 */
	public void setEastLng(Double eastLng) {
		this.eastLng = eastLng;
	}

	/**
	 * 获得X平移
	 * 
	 * @return x
	 */
	public Double getX() {
		return x;
	}

	/**
	 * 设置X平移
	 * 
	 * @param x
	 */
	public void setX(Double x) {
		this.x = x;
	}

	/**
	 * 获得y平移
	 * 
	 * @return y
	 */
	public Double getY() {
		return y;
	}

	/**
	 * 设置y平移
	 * 
	 * @param y
	 */
	public void setY(Double y) {
		this.y = y;
	}

	/**
	 * 获得z平移
	 * 
	 * @return z
	 */
	public Double getZ() {
		return z;
	}

	/**
	 * 设置z平移
	 * 
	 * @param z
	 */
	public void setZ(Double z) {
		this.z = z;
	}

	/**
	 * 获得比例因子
	 * 
	 * @return k
	 */
	public Double getK() {
		return k;
	}

	/**
	 * 设置比例因子
	 * 
	 * @param k
	 */
	public void setK(Double k) {
		this.k = k;
	}

	/**
	 * 获得X轴旋转
	 * 
	 * @return xt
	 */
	public Double getXt() {
		return xt;
	}

	/**
	 * 设置X轴旋转
	 * 
	 * @param xt
	 */
	public void setXt(Double xt) {
		this.xt = xt;
	}

	/**
	 * 获得Y轴旋转
	 * 
	 * @return yt
	 */
	public Double getYt() {
		return yt;
	}

	/**
	 * 设置Y轴旋转
	 * 
	 * @param yt
	 */
	public void setYt(Double yt) {
		this.yt = yt;
	}

	/**
	 * 获得Z轴旋转
	 * 
	 * @return zt
	 */
	public Double getZt() {
		return zt;
	}

	/**
	 * 设置Z轴旋转
	 * 
	 * @param zt
	 */
	public void setZt(Double zt) {
		this.zt = zt;
	}

	/**
	 * 获得转换类型
	 * 
	 * @return conversionType
	 */
	public Integer getConversionType() {
		return conversionType;
	}

	/**
	 * 设置转换类型
	 * 
	 * @param conversionType
	 */
	public void setConversionType(Integer conversionType) {
		this.conversionType = conversionType;
	}

	/**
	 * 获得参照点1纬度
	 * 
	 * @return pt1B
	 */
	public Double getPt1B() {
		return pt1B;
	}

	/**
	 * 设置参照点1纬度
	 * 
	 * @param pt1B
	 */
	public void setPt1B(Double pt1B) {
		this.pt1B = pt1B;
	}

	/**
	 * 获得参照点1经度
	 * 
	 * @return pt1L
	 */
	public Double getPt1L() {
		return pt1L;
	}

	/**
	 * 设置参照点1经度
	 * 
	 * @param pt1L
	 */
	public void setPt1L(Double pt1L) {
		this.pt1L = pt1L;
	}

	/**
	 * 获得参照点1高程
	 * 
	 * @return pt1H
	 */
	public Double getPt1H() {
		return pt1H;
	}

	/**
	 * 设置参照点1高程
	 * 
	 * @param pt1H
	 */
	public void setPt1H(Double pt1H) {
		this.pt1H = pt1H;
	}

	/**
	 * 获得参照点1X坐标
	 * 
	 * @return pt1X
	 */
	public Double getPt1X() {
		return pt1X;
	}

	/**
	 * 设置参照点1X坐标
	 * 
	 * @param pt1X
	 */
	public void setPt1X(Double pt1X) {
		this.pt1X = pt1X;
	}

	/**
	 * 获得参照点1Y坐标
	 * 
	 * @return pt1Y
	 */
	public Double getPt1Y() {
		return pt1Y;
	}

	/**
	 * 设置参照点1Y坐标
	 * 
	 * @param pt1Y
	 */
	public void setPt1Y(Double pt1Y) {
		this.pt1Y = pt1Y;
	}

	/**
	 * 获得参照点1Z坐标
	 * 
	 * @return pt1Z
	 */
	public Double getPt1Z() {
		return pt1Z;
	}

	/**
	 * 设置参照点1Z坐标
	 * 
	 * @param pt1Z
	 */
	public void setPt1Z(Double pt1Z) {
		this.pt1Z = pt1Z;
	}

	/**
	 * 获得参照点2纬度
	 * 
	 * @return pt2B
	 */
	public Double getPt2B() {
		return pt2B;
	}

	/**
	 * 设置参照点2纬度
	 * 
	 * @param pt2B
	 */
	public void setPt2B(Double pt2B) {
		this.pt2B = pt2B;
	}

	/**
	 * 获得参照点2经度
	 * 
	 * @return pt2L
	 */
	public Double getPt2L() {
		return pt2L;
	}

	/**
	 * 设置参照点2经度
	 * 
	 * @param pt2L
	 */
	public void setPt2L(Double pt2L) {
		this.pt2L = pt2L;
	}

	/**
	 * 获得参照点2高程
	 * 
	 * @return pt2H
	 */
	public Double getPt2H() {
		return pt2H;
	}

	/**
	 * 设置参照点2高程
	 * 
	 * @param pt2H
	 */
	public void setPt2H(Double pt2H) {
		this.pt2H = pt2H;
	}

	/**
	 * 获得参照点2X坐标
	 * 
	 * @return pt2X
	 */
	public Double getPt2X() {
		return pt2X;
	}

	/**
	 * 设置参照点2X坐标
	 * 
	 * @param pt2X
	 */
	public void setPt2X(Double pt2X) {
		this.pt2X = pt2X;
	}

	/**
	 * 获得参照点2Y坐标
	 * 
	 * @return pt2Y
	 */
	public Double getPt2Y() {
		return pt2Y;
	}

	/**
	 * 设置参照点2Y坐标
	 * 
	 * @param pt2Y
	 */
	public void setPt2Y(Double pt2Y) {
		this.pt2Y = pt2Y;
	}

	/**
	 * 获得参照点2Z坐标
	 * 
	 * @return pt2Z
	 */
	public Double getPt2Z() {
		return pt2Z;
	}

	/**
	 * 设置参照点2Z坐标
	 * 
	 * @param pt2Z
	 */
	public void setPt2Z(Double pt2Z) {
		this.pt2Z = pt2Z;
	}

	/**
	 * 获得参照点3纬度
	 * 
	 * @return pt3B
	 */
	public Double getPt3B() {
		return pt3B;
	}

	/**
	 * 设置参照点3纬度
	 * 
	 * @param pt3B
	 */
	public void setPt3B(Double pt3B) {
		this.pt3B = pt3B;
	}

	/**
	 * 获得参照点3经度
	 * 
	 * @return pt3L
	 */
	public Double getPt3L() {
		return pt3L;
	}

	/**
	 * 设置参照点3经度
	 * 
	 * @param pt3L
	 */
	public void setPt3L(Double pt3L) {
		this.pt3L = pt3L;
	}

	/**
	 * 获得参照点3高程
	 * 
	 * @return pt3H
	 */
	public Double getPt3H() {
		return pt3H;
	}

	/**
	 * 设置参照点3高程
	 * 
	 * @param pt3H
	 */
	public void setPt3H(Double pt3H) {
		this.pt3H = pt3H;
	}

	/**
	 * 获得参照点3X坐标
	 * 
	 * @return pt3X
	 */
	public Double getPt3X() {
		return pt3X;
	}

	/**
	 * 设置参照点3X坐标
	 * 
	 * @param pt3X
	 */
	public void setPt3X(Double pt3X) {
		this.pt3X = pt3X;
	}

	/**
	 * 获得参照点3Y坐标
	 * 
	 * @return pt3Y
	 */
	public Double getPt3Y() {
		return pt3Y;
	}

	/**
	 * 设置参照点3Y坐标
	 * 
	 * @param pt3Y
	 */
	public void setPt3Y(Double pt3Y) {
		this.pt3Y = pt3Y;
	}

	/**
	 * 获得参照点3Z坐标
	 * 
	 * @return pt3Z
	 */
	public Double getPt3Z() {
		return pt3Z;
	}

	/**
	 * 设置参照点3Z坐标
	 * 
	 * @param pt3Z
	 */
	public void setPt3Z(Double pt3Z) {
		this.pt3Z = pt3Z;
	}

	/**
	 * 获得备注
	 * 
	 * @return info
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * 设置备注
	 * 
	 * @param info
	 */
	public void setInfo(String info) {
		this.info = info;
	}

	/**
	 * 获得对应转换投影
	 * 
	 * @return conversionProjection
	 */
	public ConversionProjection getConversionProjection() {
		return conversionProjection;
	}

	/**
	 * 设置对应转换投影
	 * 
	 * @param conversionProjection
	 */
	public void setConversionProjection(
			ConversionProjection conversionProjection) {
		this.conversionProjection = conversionProjection;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	/**
	 * 获得反转x平移
	 * 
	 * @return
	 */
	public Double getReverseX() {
		return reverseX;
	}

	/**
	 * 设置反转x平移
	 * 
	 * @param reverseX
	 */
	public void setReverseX(Double reverseX) {
		this.reverseX = reverseX;
	}

	/**
	 * 获取反转Y平移
	 * 
	 * @return
	 */
	public Double getReverseY() {
		return reverseY;
	}

	/**
	 * 设置反转Y平移
	 * 
	 * @param reverseY
	 */
	public void setReverseY(Double reverseY) {
		this.reverseY = reverseY;
	}

	/**
	 * 获取反转比例因子K
	 * 
	 * @return
	 */
	public Double getReverseK() {
		return reverseK;
	}

	/**
	 * 设置反转比例因子K
	 * 
	 * @param reverseK
	 */
	public void setReverseK(Double reverseK) {
		this.reverseK = reverseK;
	}

	/**
	 * 获取反转x轴旋转
	 * 
	 * @return
	 */
	public Double getReverseXt() {
		return reverseXt;
	}

	/**
	 * 获取反转x轴旋转
	 * 
	 * @param reverseXt
	 */
	public void setReverseXt(Double reverseXt) {
		this.reverseXt = reverseXt;
	}

	/**
	 * 获取反转z平移
	 * 
	 * @return
	 */
	public Double getReverseZ() {
		return reverseZ;
	}

	/**
	 * 设置反转z平移
	 * 
	 * @param reverseZ
	 */
	public void setReverseZ(Double reverseZ) {
		this.reverseZ = reverseZ;
	}

	/**
	 * 获取反转y轴旋转
	 * 
	 * @return
	 */
	public Double getReverseYt() {
		return reverseYt;
	}

	/**
	 * 设置反转y轴旋转
	 * 
	 * @param reverseYt
	 */
	public void setReverseYt(Double reverseYt) {
		this.reverseYt = reverseYt;
	}

	/**
	 * 获取反转z轴旋转
	 * 
	 * @return
	 */
	public Double getReverseZt() {
		return reverseZt;
	}

	/**
	 * 设置反转z轴旋转
	 * 
	 * @param reverseZt
	 */
	public void setReverseZt(Double reverseZt) {
		this.reverseZt = reverseZt;
	}
}