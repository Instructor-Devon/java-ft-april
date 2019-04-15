package com.devon.app.models;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserForm {
	private Long userId;
	
	@Pattern(regexp="^[A-Za-z]+$")
	@Size(min=2, max=30, message="Names must be between 2 and 30 characters")
	private String firstName;
	@Size(min=2, max=30, message="Names must be between 2 and 30 characters")
	private String lastName;
	@Size(min=2)
	private String street;
	@Pattern(regexp="^(([a-zA-Z\\s])+$|([a-zA-Z\\s]+,)[a-zA-Z\\s]+){1,2}$",message="Tags must be separated by commas, max 3")
	private String city;
	private String state;
	private Integer zipCode;
	public UserForm() {
		
	}
	public UserForm(User user) {
		this.userId = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();

		Address userAddress = user.getAddress();
		if(userAddress != null) {
			this.street = userAddress.getStreet();
			this.city = userAddress.getCity();
			this.state = userAddress.getState();
			this.zipCode = userAddress.getZipCode();
		}
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	
}
