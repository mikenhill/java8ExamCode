package com.mikenhill.lambda.personList;

public class Person {

	private String name;
	private String hobby;
	private String language;
	private String country;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHobby() {
		return hobby;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
	
}
