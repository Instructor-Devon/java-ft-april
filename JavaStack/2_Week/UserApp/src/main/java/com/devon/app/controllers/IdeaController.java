package com.devon.app.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devon.app.models.Idea;
import com.devon.app.models.User;
import com.devon.app.services.IdeaService;
import com.devon.app.services.UserService;

@Controller
@RequestMapping("/ideas")
public class IdeaController {
	@Autowired
	private IdeaService iService;
	@Autowired
	private UserService uService;
	@RequestMapping("") 
	public String Ideas(Model model, HttpSession session){
		Long userId = (Long)session.getAttribute("userId");
		model.addAttribute("user", this.uService.findUserById(userId));
		model.addAttribute("ideas", this.iService.getAllIdeas());
		return "/ideas/index.jsp";
	}
	@RequestMapping("/new")
	public String NewIdea(@ModelAttribute("idea") Idea idea, Model model, HttpSession session) {
		model.addAttribute("userId", session.getAttribute("userId"));
		return "/ideas/new.jsp";
	}
	@RequestMapping("/filter")
	public String IdeasFiltered(@RequestParam("nameQuery") String nameQuery, Model model) {
		model.addAttribute("ideas", this.iService.getIdeasFilteredByCreator(nameQuery));
		return "/ideas/index.jsp";
	}
	@PostMapping("")
	public String CreateIdea(@Valid @ModelAttribute("idea") Idea idea, BindingResult result) {
		if(result.hasErrors())
			return "/ideas/new.jsp";
		this.iService.createIdea(idea);
		return "redirect:/ideas/";
	}
	@GetMapping("/{id}/like")
	public String LikeIdea(@PathVariable("id") Long id, HttpSession session) {
		// query for user in session
		Long userId = (Long)session.getAttribute("userId");
		User user = this.uService.findUserById(userId);
		// query for idea with id
		Idea idea = this.iService.findIdeaById(id);
		// add idea to user's ideasLiked
		this.uService.likeAnIdea(user, idea);
		return "redirect:/ideas";
	}
	
}
