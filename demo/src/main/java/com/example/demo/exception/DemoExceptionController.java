package com.example.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DemoExceptionController {

	private Log logger = LogFactory.getLog(DemoExceptionController.class);
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> localExceptionHandler(HttpServletRequest request, Exception e) {
		logger.error("Request " +request.getRequestURL() + "Threw an Exception" +e);
		return new ResponseEntity<>("Data Error : " +e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
