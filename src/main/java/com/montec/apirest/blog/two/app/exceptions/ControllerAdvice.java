package com.montec.apirest.blog.two.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.montec.apirest.blog.two.app.dto.ErrorDTO;

@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<ErrorDTO> runtimeExceptionHandler(RuntimeException ex){
			ErrorDTO error = new ErrorDTO(ex.getMessage());
			return new ResponseEntity<ErrorDTO>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = RequestException.class)
	public ResponseEntity<ErrorDTO> requestExceptionHandler(RequestException ex){
		ErrorDTO error = new ErrorDTO(ex.getMessage());
		return new ResponseEntity<ErrorDTO>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = GlobalException.class)
	public ResponseEntity<ErrorDTO>globalExceptionHandler(RuntimeException ex){
		ErrorDTO error = new ErrorDTO(ex.getMessage());
		return new ResponseEntity<ErrorDTO>(error,HttpStatus.CONFLICT);
	}
}
