package com.devon.app.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.devon.app.models.Question;
import com.devon.app.models.service.QuestionService;

@Controller
public class QuestionController {
	private final QuestionService qService;
	public QuestionController(QuestionService qService) {
		this.qService = qService;
	}
	
	@GetMapping("/")
	public String Index(Model model) {
		
		// get all questions
		model.addAttribute("questions", this.qService.getAllQuestions());
		return "/questions/index.jsp";
	}
	@GetMapping("/new")
	public String New(@ModelAttribute("newQ") Question newQ) {
		return "/questions/new.jsp";
	}
	@PostMapping("/")
	public String Create(@Valid @ModelAttribute("newQ") Question newQ, BindingResult result) {
		if(result.hasErrors())
			return "/questions/new.jsp";
		this.qService.createQuestion(newQ);
		return "redirect:/";
	}
}
