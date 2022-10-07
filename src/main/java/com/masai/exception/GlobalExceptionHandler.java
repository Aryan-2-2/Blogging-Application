package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	

	@ExceptionHandler(PostNotFoundException.class)
    ResponseEntity<MyErrorDetails>postNotFoundExceptionHandler(PostNotFoundException pnf, WebRequest wr){
	
	MyErrorDetails err = new MyErrorDetails();
	
	err.setDateTime(LocalDateTime.now());
	err.setMessage(pnf.getMessage());
	err.setDetails(wr.getDescription(false));

	return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	
	}

	@ExceptionHandler(PostAlreadyPresentException.class)
    ResponseEntity<MyErrorDetails>postAlreadyPresentExceptionHandler(PostAlreadyPresentException pae, WebRequest wr){
	
	MyErrorDetails err = new MyErrorDetails();
	
	err.setDateTime(LocalDateTime.now());
	err.setMessage(pae.getMessage());
	err.setDetails(wr.getDescription(false));

	return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	
	}
	
	@ExceptionHandler(CommentNotFound.class)
    ResponseEntity<MyErrorDetails>commentNotFoundExceptionHandler(CommentNotFound cnf, WebRequest wr){
	
	MyErrorDetails err = new MyErrorDetails();
	
	err.setDateTime(LocalDateTime.now());
	err.setMessage(cnf.getMessage());
	err.setDetails(wr.getDescription(false));

	return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	
	}

	@ExceptionHandler(NoHandlerFoundException.class)
    ResponseEntity<MyErrorDetails>noHandlerFoundException(NoHandlerFoundException nfe, WebRequest wr){
	
	MyErrorDetails err = new MyErrorDetails();
	
	err.setDateTime(LocalDateTime.now());
	err.setMessage(nfe.getMessage());
	err.setDetails(wr.getDescription(false));

	return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_GATEWAY);
	
	}
	
	    @ExceptionHandler(Exception.class)
	    ResponseEntity<MyErrorDetails>exceptionHandler(Exception ie, WebRequest wr){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setDateTime(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(wr.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
}

	