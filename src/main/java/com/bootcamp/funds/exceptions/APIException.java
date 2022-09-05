package com.bootcamp.funds.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class APIException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private HttpStatus status;
    private String message;

    public APIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }


}
