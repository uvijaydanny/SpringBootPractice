package com.practice.springbootpractice.configproperties;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class CustomConverter implements Converter<String, LocalDate> {

	@Override
	public LocalDate convert(String string_date) {
		// TODO Auto-generated method stub
		if(string_date == null){
			return null;
		}
		return LocalDate.parse(string_date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}

}
