package com.practice.springbootpractice.configproperties;

import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Profile("dev")
//Since the property we are reading is profile specific we dont need the below propertysource. It is req if @Profile is not mentioned
//@PropertySource(value="application-dev.properties") - 
@ConfigurationProperties(prefix="app")
@Validated
public class MyConfigurationProperties {

	@NotBlank(message="Enter valid name")
	@NotNull(message="Should not be null")
	public String name;
	
	public String[] email;
	public Map<String, String> company;
	@Valid
	public Technologies tech;
	public String uuid;
	
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Technologies getTech() {
		return tech;
	}
	public void setTech(Technologies tech) {
		this.tech = tech;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getEmail() {
		return email;
	}
	public void setEmail(String[] email) {
		this.email = email;
	}
	public Map<String, String> getCompany() {
		return company;
	}
	public void setCompany(Map<String, String> company) {
		this.company = company;
	}
	
	
}
