package com.cnten.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class OamContacts {

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false, length = 32)
    private String oamContactsId;
    private String oamContactsName;
    @ManyToOne
    @JoinColumn(name="oam_customer_id")
    private OamCustomer oamCustomer;
    private String position;
    private String tel;
    private String phone;
    private String mail;
    private String other;
    @Column(length = 1)
    private String isDelete;
    
    public String getOamContactsId() {
    	return oamContactsId;
    }
    public void setOamContactsId(String oamContactsId) {
    	this.oamContactsId = oamContactsId;
    }
    /**
     * 获得联系人名称
     * @return oamContactsName
     */
    public String getOamContactsName() {
    	return oamContactsName;
    }
    /**
     * 设置联系人名称
     * @param oamContactsName
     */
    public void setOamContactsName(String oamContactsName) {
    	this.oamContactsName = oamContactsName;
    }
    /**
     * 获得所属客户
     * @return oamCustomer
     */
    public OamCustomer getOamCustomer() {
    	return oamCustomer;
    }
    /**
     * 设置所属客户
     * @param oamCustomer
     */
    public void setOamCustomer(OamCustomer oamCustomer) {
    	this.oamCustomer = oamCustomer;
    }
    /**
     * 获得职务
     * @return position
     */
    public String getPosition() {
    	return position;
    }
    /**
     * 设置职务
     * @param position
     */
    public void setPosition(String position) {
    	this.position = position;
    }
    /**
     * 获得电话
     * @return tel
     */
    public String getTel() {
    	return tel;
    }
    /**
     * 设置电话
     * @param tel
     */
    public void setTel(String tel) {
    	this.tel = tel;
    }
    /**
     * 获得手机
     * @return phone
     */
    public String getPhone() {
    	return phone;
    }
    /**
     * 设置手机
     * @param phone
     */
    public void setPhone(String phone) {
    	this.phone = phone;
    }
    /**
     * 获得邮箱
     * @return mail
     */
    public String getMail() {
    	return mail;
    }
    /**
     * 设置邮箱
     * @param mail
     */
    public void setMail(String mail) {
    	this.mail = mail;
    }
    /**
     * 获得其它
     * @return other
     */
    public String getOther() {
    	return other;
    }
    /**
     * 设置其它
     * @param other
     */
    public void setOther(String other) {
    	this.other = other;
    }
    public String getIsDelete() {
    	return isDelete;
    }
    public void setIsDelete(String isDelete) {
    	this.isDelete = isDelete;
    }
} 		