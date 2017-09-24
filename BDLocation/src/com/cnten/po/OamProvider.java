package com.cnten.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class OamProvider {

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String oamProviderId;
    @Column(length = 100)
    private String oamProviderName;
    @Column(length = 2000)
    private String products;
    @Column(length = 50)
    private String contact;
    @Column(length = 1)
    private String isDelete;
    
    public String getOamProviderId() {
    	return oamProviderId;
    }
    public void setOamProviderId(String oamProviderId) {
    	this.oamProviderId = oamProviderId;
    }
    /**
     * 获得供应商名称
     * @return oamProviderName
     */
    public String getOamProviderName() {
    	return oamProviderName;
    }
    /**
     * 设置供应商名称
     * @param oamProviderName
     */
    public void setOamProviderName(String oamProviderName) {
    	this.oamProviderName = oamProviderName;
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
     * 获得联系方式
     * @return contact
     */
    public String getContact() {
    	return contact;
    }
    /**
     * 设置联系方式
     * @param contact
     */
    public void setContact(String contact) {
    	this.contact = contact;
    }
    public String getIsDelete() {
    	return isDelete;
    }
    public void setIsDelete(String isDelete) {
    	this.isDelete = isDelete;
    }
} 		