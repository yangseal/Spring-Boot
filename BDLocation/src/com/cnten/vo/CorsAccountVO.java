package com.cnten.vo;

public class CorsAccountVO {
	private String corsAccountId;
	private String corsAccountCode;
	public CorsAccountVO(String corsAccountId, String corsAccountCode) {
		super();
		this.corsAccountId = corsAccountId;
		this.corsAccountCode = corsAccountCode;
	}
	public String getCorsAccountId() {
		return corsAccountId;
	}
	public void setCorsAccountId(String corsAccountId) {
		this.corsAccountId = corsAccountId;
	}
	public String getCorsAccountCode() {
		return corsAccountCode;
	}
	public void setCorsAccountCode(String corsAccountCode) {
		this.corsAccountCode = corsAccountCode;
	}
}
