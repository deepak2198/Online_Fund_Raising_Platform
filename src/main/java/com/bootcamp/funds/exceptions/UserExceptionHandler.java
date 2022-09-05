package com.bootcamp.funds.exceptions;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<Object> userNotFoundExceptionHandler(UserNotFoundException ex){
		return new ResponseEntity<Object>("user not found...", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value=PostNotFoundException.class)
	public ResponseEntity<Object> postNotFoundExceptionHandler(PostNotFoundException ex){
		return new ResponseEntity<Object>("post not found...", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value=CommentNotFoundException.class)
	public ResponseEntity<Object> commentNotFoundExceptionHandler(CommentNotFoundException ex){
		return new ResponseEntity<Object>("comments not found...", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value=DonationNotFoundException.class)
	public ResponseEntity<Object> donationNotFoundExceptionHandler(DonationNotFoundException ex){
		return new ResponseEntity<Object>("donation not found...", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value=AdminNotFoundException.class)
	public ResponseEntity<Object> adminNotFoundExceptionHandler(AdminNotFoundException ex){
		return new ResponseEntity<Object>("Admin not found...", HttpStatus.BAD_REQUEST);
	}

}
