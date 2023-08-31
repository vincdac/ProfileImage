package com.blinkx.ProfileImage.exception;

import java.io.Serializable;

public class ResourseNotFoundException extends RuntimeException implements Serializable{

	
	private static final long serialVersionUID = 1L;

	public ResourseNotFoundException(String msg) {
		super(msg);
	}

}
