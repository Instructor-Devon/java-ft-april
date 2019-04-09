package com.devon.app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devon.app.models.User;
import com.devon.app.services.UserService;

@RequestMapping("/api")
@RestController
public class UserApiController {
	private final UserService uService;
	public UserApiController(UserService uService) {
		this.uService = uService;
	}
	
	// localhost:8080/api
	// [User, User, User, User]
	@RequestMapping("")
	public List<User> index() {
		return this.uService.getAllUsers();
	}
	@RequestMapping("/user/{lastName}")
	public List<User> lastNameSearch(@PathVariable("lastName") String lastName) {
		return this.uService.getAllUsersByLastName(lastName);
	}
	@RequestMapping("/{id}")
	public User show(@PathVariable("id") Long id) {
		return this.uService.findUserById(id);
	}
	@RequestMapping(value="/", method=RequestMethod.POST)
	public User create(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
		User newUser = new User(firstName, lastName);
		return this.uService.createUser(newUser);
	}
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public User update(@PathVariable("id") Long id, 
			@RequestParam("firstName") String firstName, 
			@RequestParam("lastName") String lastName) {
		return this.uService.updateUser(id, firstName, lastName);
	}
}
