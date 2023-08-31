package com.blinkx.ProfileImage.exception;

public class ExceptionResponse {
	
	private String msg;
	
	private String msgkey;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsgkey() {
		return msgkey;
	}

	public void setMsgkey(String msgkey) {
		this.msgkey = msgkey;
	}

	public ExceptionResponse(String msg, String msgkey) {
		super();
		this.msg = msg;
		this.msgkey = msgkey;
	}

	public ExceptionResponse() {
		super();
	}
	
	

}
