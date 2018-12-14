package com.practice.springbootpractice;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practice.springbootpractice.configproperties.MyConfigurationProperties;
import com.practice.springbootpractice.externalConfig.ReadExtConfig_Properties;
import com.practice.springbootpractice.model.TradeAmount;

@Controller
public class MainController {

	@Autowired
	private ReadExtConfig_Properties readProperty;

	@Autowired
	private MyConfigurationProperties configProperty;
	
	@RequestMapping(value="/")
	public String server_jsp(Model model){
		model.addAttribute("msg", "Model Attribute");
		return "sample";
	}
	
	//Uses InitBinder during binding
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
	
	@GetMapping(value="/prop")
	public String dspProperty(Model model){
		model.addAttribute("gav", readProperty.getGav_info());
		return "Useful_Info";
	}
	
	@ModelAttribute
	public void addConfigProperties(Model model){
		model.addAttribute("configProp", configProperty);
	}
	
	//Error Scenarios - will point to 4xx.jsp
		@RequestMapping("/notfound")
		public void CustomException() throws UserNotPresentException{
			throw new UserNotPresentException("User not found");
		}
	
	
}
