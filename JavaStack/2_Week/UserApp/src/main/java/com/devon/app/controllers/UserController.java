package com.devon.app.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devon.app.models.Idea;
import com.devon.app.models.User;
import com.devon.app.services.IdeaService;
import com.devon.app.services.UserService;

@Controller
public class UserController {
	private final UserService uService;
	private final IdeaService iService;
	public UserController(UserService uService, IdeaService iService) {
		this.uService = uService;
		this.iService = iService;
	}
	// localhost:8080/
	// all users shown in a table
	@RequestMapping("/")
	public String Index(Model model, HttpSession session) {
		
		model.addAttribute("users", this.uService.getUsersOrdered());
		Long userSessionId = (Long)session.getAttribute("userId");
		if(userSessionId == null) {
			session.setAttribute("userId", 1L);
			userSessionId = (Long)session.getAttribute("userId");
		}
		model.addAttribute("currentUser", this.uService.findUserById(userSessionId));
		
		return "/users/index.jsp";
	}
	@RequestMapping("/new")
	public String New(@ModelAttribute("user") User user) {
		return "/users/new.jsp";
	}
	//@RequestMapping(value="/", method=RequestMethod.POST)
	@PostMapping("/")
	public String Create(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if(result.hasErrors())
			return "/users/new.jsp";
		this.uService.createUser(user);
		return "redirect:/";
	}
	@GetMapping("/login/{id}")
	public String Login(@PathVariable("id") Long id, HttpSession session) {
		session.setAttribute("userId", id);
		return "redirect:/";
	}
	@GetMapping("/{id}")
	public String Show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", this.uService.findUserById(id));
		return "/users/show.jsp";
	}
	@GetMapping("/edit/{id}")
	public String Edit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", this.uService.findUserById(id));
		return "/users/edit.jsp";
	}
	@PutMapping("/{id}")
	public String Update(@Valid @ModelAttribute("user") User user, BindingResult result) {
		// full user entity
		// user.id
		// user.firstName
		// user.ect
		if(result.hasErrors())
			return "/users/edit.jsp";
		this.uService.updateUser(user);
		return "redirect:/";
	}
	
}
