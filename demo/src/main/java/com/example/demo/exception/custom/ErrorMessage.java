package com.example.demo.exception.custom;

public class ErrorMessage  {

	private String erroeMsg;
	private String errorDetails;
	
	public ErrorMessage(String erroeMsg, String errorDetails) {
		super();
		this.erroeMsg = erroeMsg;
		this.errorDetails = errorDetails;
	}

	public ErrorMessage() {
		super();
	}


	public String getErroeMsg() {
		return erroeMsg;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErroeMsg(String erroeMsg) {
		this.erroeMsg = erroeMsg;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	
}
