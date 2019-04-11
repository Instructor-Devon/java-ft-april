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
import org.springframework.web.bind.annotation.RequestMapping;

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
		model.addAttribute("homeless", this.uService.getAllUsersWithNoAddresses());
		model.addAttribute("homes", this.uService.getAllUsersWithAddresses());
		session.setAttribute("userId", 1);
		
		return "index.jsp";
	}
	@RequestMapping("/ideas") 
	public String Ideas(Model model){
		model.addAttribute("ideas", this.iService.getAllIdeas());
		return "ideas.jsp";
	}
	@RequestMapping("/new")
	public String New(@ModelAttribute("user") User user) {
		return "new.jsp";
	}
	@RequestMapping("/ideas/new")
	public String NewIdea(@ModelAttribute("idea") Idea idea, Model model, HttpSession session) {
		model.addAttribute("userId", session.getAttribute("userId"));
		return "newIdea.jsp";
	}
	@PostMapping("/ideas")
	public String CreateIdea(@Valid @ModelAttribute("idea") Idea idea, BindingResult result) {
		if(result.hasErrors())
			return "newIdea.jsp";
		this.iService.createIdea(idea);
		return "redirect:/ideas/";
	}
	//@RequestMapping(value="/", method=RequestMethod.POST)
	@PostMapping("/")
	public String Create(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if(result.hasErrors())
			return "new.jsp";
		this.uService.createUser(user);
		return "redirect:/";
	}
	@GetMapping("/{id}")
	public String Show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", this.uService.findUserById(id));
		return "show.jsp";
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
