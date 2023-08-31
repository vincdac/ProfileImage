package com.blinkx.ProfileImage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandle {
	
	
	@ExceptionHandler(ResourseNotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public ExceptionResponse handleException(ResourseNotFoundException exception) {
		ExceptionResponse exceptionResponse=new ExceptionResponse();
		exceptionResponse.setMsgkey("Error_profile");
		exceptionResponse.setMsg(exception.getMessage());
		return exceptionResponse;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public ExceptionResponse handleException(Exception exception) {
		ExceptionResponse exceptionResponse=new ExceptionResponse();
		exceptionResponse.setMsgkey("Error_server");
		exceptionResponse.setMsg(exception.getMessage());
		return exceptionResponse;
	}
	
	

}
