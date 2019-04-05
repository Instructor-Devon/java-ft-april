package com.codingdojo.fun;

public class Gorilla {
	private String firstName;
	private String lastName;
	private String hairColor;
	public Gorilla(String firstName, String lastName, String hairColor) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.hairColor = hairColor;
	}
	public String greeting() {
		return String.format("Hey everyone, It's %s %s here", this.firstName, this.lastName);
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getHairColor() {
		return hairColor;
	}
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	
	
	
}
