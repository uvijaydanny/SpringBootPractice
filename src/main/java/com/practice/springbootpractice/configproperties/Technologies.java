package com.practice.springbootpractice.configproperties;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;

public class Technologies {

	public String javaExp;
	public String iSeriesExp;
	@PastOrPresent
	private LocalDate careerStartDate;
	
	public LocalDate getCareerStartDate() {
		return careerStartDate;
	}
	public void setCareerStartDate(LocalDate careerStartDate) {
		this.careerStartDate = careerStartDate;
	}
	public String getJavaExp() {
		return javaExp;
	}
	public void setJavaExp(String javaExp) {
		this.javaExp = javaExp;
	}
	public String getiSeriesExp() {
		return iSeriesExp;
	}
	public void setiSeriesExp(String iSeriesExp) {
		this.iSeriesExp = iSeriesExp;
	}
	
	
	
}
