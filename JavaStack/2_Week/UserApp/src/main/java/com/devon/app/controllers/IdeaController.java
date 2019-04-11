package com.devon.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devon.app.models.Idea;

@Controller
@RequestMapping("/ideas")
// localhost:8080/ideas +
public class IdeaController {
//	@RequestMapping(value="", method=RequestMethod.POST)
	// localhost:8080/ideas
	@PostMapping("")
	public String create(Idea idea) {
		return "";
	}
}
