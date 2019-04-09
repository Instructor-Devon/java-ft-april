package com.devon.app.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devon.app.models.User;
import com.devon.app.services.UserService;

@Controller
public class UserController {
	private final UserService uService;
	public UserController(UserService uService) {
		this.uService = uService;
	}
	// localhost:8080/
	// all users shown in a table
	@RequestMapping("/")
	public String Index(Model model) {
		List<User> allUsers = this.uService.getAllUsers();
		model.addAttribute("users", allUsers);
		return "index.jsp";
	}
	@RequestMapping("/new")
	public String New(@ModelAttribute("user") User user) {
		return "new.jsp";
	}
	//@RequestMapping(value="/", method=RequestMethod.POST)
	@PostMapping("/")
	public String Create(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if(result.hasErrors())
			return "new.jsp";
		this.uService.createUser(user);
		return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String Edit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", this.uService.findUserById(id));
		return "edit.jsp";
	}
	@PutMapping("/{id}")
	public String Update(@Valid @ModelAttribute("user") User user, BindingResult result) {
		// full user entity
		// user.id
		// user.firstName
		// user.ect
		if(result.hasErrors())
			return "edit.jsp";
		this.uService.updateUser(user);
		return "redirect:/";
	}
	
}
