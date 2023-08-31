package com.blinkx.ProfileImage.dto;

public class SuccessResponseDto {
	
	private String msgKey;
	
	private String msg;
	
	private Object object;

	public String getMsgKey() {
		return msgKey;
	}

	public void setMsgKey(String msgKey) {
		this.msgKey = msgKey;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public SuccessResponseDto(String msgKey, String msg, Object object) {
		super();
		this.msgKey = msgKey;
		this.msg = msg;
		this.object = object;
	}

	public SuccessResponseDto(String msgKey, String msg) {
		super();
		this.msgKey = msgKey;
		this.msg = msg;
	}

	public SuccessResponseDto() {

	}
	
	

}
