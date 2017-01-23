package com.mikenhill.lambda.personList;

public enum Country {

	UK ("United Kingdom", "GBP"),
	SP ("Spain", "EUR");
	
	private String name;
	private String currency;
	
	private Country (String name, String currency) {
		this.name = name;
		this.currency = currency;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
	
}
