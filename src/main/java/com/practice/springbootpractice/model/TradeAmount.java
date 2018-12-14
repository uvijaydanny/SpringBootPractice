package com.practice.springbootpractice.model;

import java.math.BigDecimal;
import java.util.Currency;

public class TradeAmount {

	public Currency currency;
	public BigDecimal amount;
	
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
}
