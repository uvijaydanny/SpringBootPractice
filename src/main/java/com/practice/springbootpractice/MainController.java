package com.practice.springbootpractice;

import java.util.Date;

import javax.management.RuntimeErrorException;

import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.practice.springbootpractice.model.TradeAmount;

@Controller
public class MainController {


	@RequestMapping(value="/")
	public String server_jsp(Model model){
		model.addAttribute("msg", "Model Attribute");
		return "sample";
	}
	
	@RequestMapping(value="/date")
	@ResponseBody
	public String server_jsp(@RequestParam Date somedate){
		System.out.println(somedate);
		return somedate.toString();
	}
	
	@RequestMapping("/trade")
	public String tradeAmountFormatterTest(@RequestParam TradeAmount ta, Model model){
		model.addAttribute("ta", ta);
		return "sample";
	}
	
	@InitBinder
	public void binderinit(WebDataBinder binder){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf,true));
	}
	
	//Error Scenarios - will point to 5xx.jsp changed
	@RequestMapping("/throw")
	public String tradeAmountFormatterTest(){
		throw new RuntimeException();
		
	}
	
	//Error Scenarios - will point to 4xx.jsp
		@RequestMapping("/notfound")
		public void CustomException() throws UserNotPresentException{
			throw new UserNotPresentException("User not found");
		}
	
	
}
