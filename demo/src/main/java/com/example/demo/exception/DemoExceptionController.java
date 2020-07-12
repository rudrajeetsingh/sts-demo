package com.example.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.exception.custom.ErrorMessage;

//@ControllerAdvice
public class DemoExceptionController extends ResponseEntityExceptionHandler {

	private Log logger = LogFactory.getLog(DemoExceptionController.class);
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorMessage> localExceptionHandler(HttpServletRequest request, Exception e) {
//		logger.error("Request " +request.getRequestURL() + "Threw an Exception" +e);
//		return new ResponseEntity<>("Data Error : " +e.getMessage(), HttpStatus.NOT_FOUND);
		ErrorMessage message = new ErrorMessage(e.getMessage(), "DemoController : ");
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
	}
}
