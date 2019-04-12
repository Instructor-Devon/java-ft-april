package com.devon.app.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devon.app.models.Idea;
import com.devon.app.services.IdeaService;

@Controller
@RequestMapping("/ideas")
public class IdeaController {
	@Autowired
	private IdeaService iService;
	@RequestMapping("") 
	public String Ideas(Model model){
		model.addAttribute("ideas", this.iService.getIdeasFilteredByCreator("d"));
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
}
