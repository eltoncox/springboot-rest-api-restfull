package com.elton.projeto.exception.handler;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//3
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.elton.projeto.exception.ExceptionResponse;
import com.elton.projeto.exception.ResourceNotFoundException;

@ControllerAdvice // annotation para concentrar tratamento em controllers
@RestController
public class CustomizedResponseEntityExceptionHandle extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse>  
				handleAllException(Exception ex, WebRequest request) {
		
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					new Date(), 
					ex.getMessage(), 
					request.getDescription(false));
			
			return new ResponseEntity<> ( exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR );
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ExceptionResponse>  
				handleNotFoundExceptions(Exception ex, WebRequest request) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					new Date(), 
					ex.getMessage(), 
					request.getDescription(false));
			
			return new ResponseEntity<>( exceptionResponse, HttpStatus.NOT_FOUND );
	}

}
