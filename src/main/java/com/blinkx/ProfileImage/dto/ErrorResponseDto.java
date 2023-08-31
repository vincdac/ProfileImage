package com.blinkx.ProfileImage.dto;

public class ErrorResponseDto {
	
	private String msgKey;
	
	private String msg;

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

	public ErrorResponseDto(String msgKey, String msg) {
		super();
		this.msgKey = msgKey;
		this.msg = msg;
	}

	public ErrorResponseDto() {

	}
	
	

}
