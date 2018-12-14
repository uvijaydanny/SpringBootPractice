package com.practice.springbootpractice;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.practice.springbootpractice.model.TradeAmount;

public class Formatter implements org.springframework.format.Formatter<TradeAmount> {

	public static Pattern matching = Pattern.compile("(\\d+)(\\w+)");
	
	@Override
	public String print(TradeAmount arg0, Locale arg1) {
		// TODO Auto-generated method stub
		return "something";
	}

	@Override
	public TradeAmount parse(String text, Locale arg1) throws ParseException {
		Matcher matcher = matching.matcher(text);
		if(matcher.find()){
			TradeAmount ta = new TradeAmount();
			ta.setCurrency(Currency.getInstance(matcher.group(2)));
			ta.setAmount(new BigDecimal(Integer.parseInt(matcher.group(1))));
			return ta;
		}
		return new TradeAmount();
	}

	
}
