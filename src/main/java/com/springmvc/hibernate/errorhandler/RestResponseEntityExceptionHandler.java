package com.springmvc.hibernate.errorhandler;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	 @ExceptionHandler(value  = { ArithmeticException.class, IllegalStateException.class })
		    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		 		Map<String, Object> mapError = new HashMap <String,Object>();
		 		mapError.put("Error", " there is something wrong");
		     
		        return handleExceptionInternal(ex, mapError, new HttpHeaders(), HttpStatus.CONFLICT, request);
		    }
	@ExceptionHandler(value = {JSONException.class})
	protected ResponseEntity<Object> handleJsonException(RuntimeException ex, WebRequest request) {
 		Map<String, Object> mapError = new HashMap <String,Object>();
 		mapError.put("Error", "the Input Json is wrong");
        
        return handleExceptionInternal(ex, mapError, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
