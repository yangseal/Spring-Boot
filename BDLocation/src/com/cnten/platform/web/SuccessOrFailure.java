package com.cnten.platform.web;

public class SuccessOrFailure {

	private boolean success;
	private String resultCode;
	private Object message;
	
	private SuccessOrFailure(boolean success,String resultCode ,Object message) {
		this.success = success;
		this.resultCode = resultCode;
		this.message = message;
	}
	
	public static SuccessOrFailure SUCCESS = new SuccessOrFailure(true,ResultCode.success_0x001.toString(), null);
	
	public static SuccessOrFailure SUCCESS(String resultCode, Object message){
		return new SuccessOrFailure(true,resultCode, message);
	}
	
	public static SuccessOrFailure SUCCESS(Object message){
		return new SuccessOrFailure(true,ResultCode.success_0x001.toString(), message);
	}
	
	public static SuccessOrFailure FAILURE(Object message){
		return new SuccessOrFailure(false,ResultCode.fail_0x000.toString(), message);
	}
	
	public static SuccessOrFailure FAILURE(String resultCode, Object message){
		return new SuccessOrFailure(false,resultCode, message);
	}
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	public String getResultCode() {
		return resultCode;
	}

}
