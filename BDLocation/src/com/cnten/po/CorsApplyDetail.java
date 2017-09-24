package com.cnten.po;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.cnten.platform.util.StringUtil;

@Entity
public class CorsApplyDetail {
	@Id
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@GeneratedValue(generator = "generator")
	@Column(unique = true, nullable = false, length = 32)
	private String corsApplyDetailId;
	@Transient
	private String bdDeviceAccuracyName;
	@Column(length = 10)
	private String bdDeviceAccuracy;
	public static final String bdDeviceAccuracyDictStatement = "milevel,米级;meter,亚米级;centimeter,厘米级";
	@Column(length = 5)
	private Integer applyCount;
	@Column(length = 5)
	private Integer accountUsePeriod;
	@Transient
	private String accountTypeName;
	@Column(length = 30)
	private String accountType;
	public static final String accountTypeDictStatement = "test,试用;formal,正式";
	@Column(length = 1)
	private Integer isDelete;
	public String getCorsApplyDetailId() {
		return corsApplyDetailId;
	}
	public void setCorsApplyDetailId(String corsApplyDetailId) {
		this.corsApplyDetailId = corsApplyDetailId;
	}
	public String getBdDeviceAccuracy() {
		return bdDeviceAccuracy;
	}
	public void setBdDeviceAccuracy(String bdDeviceAccuracy) {
		this.bdDeviceAccuracy = bdDeviceAccuracy;
	}
	public Integer getApplyCount() {
		return applyCount;
	}
	public void setApplyCount(Integer applyCount) {
		this.applyCount = applyCount;
	}
	public Integer getAccountUsePeriod() {
		return accountUsePeriod;
	}
	public void setAccountUsePeriod(Integer accountUsePeriod) {
		this.accountUsePeriod = accountUsePeriod;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	/**
     * 获得定位设备入网精度
     * @return applyStatusName
     */
    public String getBdDeviceAccuracyName() {
    	return StringUtil.getDictName(bdDeviceAccuracy,bdDeviceAccuracyDictStatement);
    }
	/**
     * 获得账号类型名称
     * @return applyStatusName
     */
    public String getAccountTypeName() {
    	return StringUtil.getDictName(accountType, accountTypeDictStatement);
    }
}
