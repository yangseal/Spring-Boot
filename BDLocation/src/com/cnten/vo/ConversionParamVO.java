package com.cnten.vo;

import com.cnten.po.ConversionProjection;

public class ConversionParamVO {
	private String id;
	private String projectionId;
	private Double x;
	private Double y;
	private Double z;
	private Double k;
	private Double xt;
	private Double yt;
	private Double zt;
	private Integer ellipoidSys;
	private Double reverseX;
	private Double reverseY;
	private Double reverseZ;
	private Double reverseK;
	private Double reverseXt;
	private Double reverseYt;
	private Double reverseZt;
	private ConversionProjection conversionProjection;

	public ConversionParamVO(String id, String projectionId, Double x,
			Double y, Double z, Double k, Double xt, Double yt, Double zt,
			Integer ellipoidSys, Double reverseX, Double reverseY,Double reverseZ,
			Double reverseK, Double reverseXt,Double reverseYt,Double reverseZt) {
		super();
		this.id = id;
		this.projectionId = projectionId;
		this.x = x;
		this.y = y;
		this.z = z;
		this.k = k;
		this.xt = xt;
		this.yt = yt;
		this.zt = zt;
		this.reverseX = reverseX;
		this.reverseY = reverseY;
		this.reverseZ = reverseZ;
		this.reverseK = reverseK;
		this.reverseXt = reverseXt;
		this.reverseYt = reverseYt;
		this.reverseZt = reverseZt;
		this.ellipoidSys = ellipoidSys;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjectionId() {
		return projectionId;
	}

	public void setProjectionId(String projectionId) {
		this.projectionId = projectionId;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Double getZ() {
		return z;
	}

	public void setZ(Double z) {
		this.z = z;
	}

	public Double getK() {
		return k;
	}

	public void setK(Double k) {
		this.k = k;
	}

	public Double getXt() {
		return xt;
	}

	public void setXt(Double xt) {
		this.xt = xt;
	}

	public Double getYt() {
		return yt;
	}

	public void setYt(Double yt) {
		this.yt = yt;
	}

	public Double getZt() {
		return zt;
	}

	public void setZt(Double zt) {
		this.zt = zt;
	}

	public Integer getEllipoidSys() {
		return ellipoidSys;
	}

	public void setEllipoidSys(Integer ellipoidSys) {
		this.ellipoidSys = ellipoidSys;
	}

	public ConversionProjection getProjectionParam() {
		return conversionProjection;
	}

	public void setProjectionParam(ConversionProjection conversionProjection) {
		this.conversionProjection = conversionProjection;
	}

	public Double getReverseX() {
		return reverseX;
	}

	public void setReverseX(Double reverseX) {
		this.reverseX = reverseX;
	}

	public Double getReverseY() {
		return reverseY;
	}

	public void setReverseY(Double reverseY) {
		this.reverseY = reverseY;
	}

	public Double getReverseK() {
		return reverseK;
	}

	public void setReverseK(Double reverseK) {
		this.reverseK = reverseK;
	}

	public Double getReverseZ() {
		return reverseZ;
	}

	public void setReverseZ(Double reverseZ) {
		this.reverseZ = reverseZ;
	}

	public Double getReverseYt() {
		return reverseYt;
	}

	public void setReverseYt(Double reverseYt) {
		this.reverseYt = reverseYt;
	}

	public Double getReverseZt() {
		return reverseZt;
	}

	public void setReverseZt(Double reverseZt) {
		this.reverseZt = reverseZt;
	}

	public Double getReverseXt() {
		return reverseXt;
	}

	public void setReverseXt(Double reverseXt) {
		this.reverseXt = reverseXt;
	}

}
