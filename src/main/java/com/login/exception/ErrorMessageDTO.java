package com.login.exception;

public class ErrorMessageDTO {
	
	 private int errorCode;
	 private String errorMessage;
	 
	 
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	
	public ErrorMessageDTO(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	
	public ErrorMessageDTO() {
		super();
	}
	
	@Override
	public String toString() {
		return "ErrorMessageDTO [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}	
}
