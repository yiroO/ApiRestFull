package com.api.restfull.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class MessageErrors extends Exception {

	private static final long serialVersionUID = 1L;
	
	public MessageErrors(String message) {
		super(message);
	}
	
	
}
