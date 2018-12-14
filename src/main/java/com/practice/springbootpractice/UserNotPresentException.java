package com.practice.springbootpractice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotPresentException extends Exception {

	public UserNotPresentException(String msg){
		super(msg);
	}
}
