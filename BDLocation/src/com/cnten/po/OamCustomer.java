package com.cnten.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class OamCustomer {

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String oamCustomerId;
    @Column(length = 200)
    private String oamCustomerName;
    @ManyToOne
    @JoinColumn(name="oam_area_id")
    private OamArea oamArea;
    @Column(length = 50)
    private String postcode;
    @Column(length = 200)
    private String address;
    @Column(length = 200)
    private String products;
    private Double longitude;
    private Double latitude;
    @Column(length = 1)
    private String isDelete;
    
    public OamCustomer(){}
    public OamCustomer(String customerId) {
		this.oamCustomerId = customerId;
	}
	public String getOamCustomerId() {
    	return oamCustomerId;
    }
    public void setOamCustomerId(String oamCustomerId) {
    	this.oamCustomerId = oamCustomerId;
    }
    /**
     * 获得客户名称
     * @return oamCustomerName
     */
    public String getOamCustomerName() {
    	return oamCustomerName;
    }
    /**
     * 设置客户名称
     * @param oamCustomerName
     */
    public void setOamCustomerName(String oamCustomerName) {
    	this.oamCustomerName = oamCustomerName;
    }
    /**
     * 获得所属省市
     * @return oamArea
     */
    public OamArea getOamArea() {
    	return oamArea;
    }
    /**
     * 设置所属省市
     * @param oamArea
     */
    public void setOamArea(OamArea oamArea) {
    	this.oamArea = oamArea;
    }
    /**
     * 获得邮编
     * @return postcode
     */
    public String getPostcode() {
    	return postcode;
    }
    /**
     * 设置邮编
     * @param postcode
     */
    public void setPostcode(String postcode) {
    	this.postcode = postcode;
    }
    /**
     * 获得地址
     * @return address
     */
    public String getAddress() {
    	return address;
    }
    /**
     * 设置地址
     * @param address
     */
    public void setAddress(String address) {
    	this.address = address;
    }
    /**
     * 获得主营业务
     * @return products
     */
    public String getProducts() {
    	return products;
    }
    /**
     * 设置主营业务
     * @param products
     */
    public void setProducts(String products) {
    	this.products = products;
    }
    /**
     * 获得经度
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
    public String getIsDelete() {
    	return isDelete;
    }
    public void setIsDelete(String isDelete) {
    	this.isDelete = isDelete;
    }
} 		