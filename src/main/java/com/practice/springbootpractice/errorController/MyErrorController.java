package com.practice.springbootpractice.errorController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// If this controller is present then the static error pages in resources/error folder(default 4xx and 5xx) 
// pages will not be displayed

@Controller
public class MyErrorController implements ErrorController {

	@RequestMapping("/error")
	public @ResponseBody String handleError(HttpServletRequest request){
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
		return String.format("Status code - %s \n Exception - $s", statusCode,exception==null?"N/A":exception.getMessage());
	}
	
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		System.out.println("Error path invoked");
		return "/error";
	}

}
