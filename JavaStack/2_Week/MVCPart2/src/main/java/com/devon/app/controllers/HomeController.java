package com.devon.app.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.devon.app.Person;

@Controller
public class HomeController {
	// show collection of people
	// localhost:8080/ GET
	@RequestMapping("/")
	public String Index(Model model, HttpSession session) {
		// send data to index.jsp
		// i can do this with a view model
		
		// is there a "times" is session?
		Object sessionTimes = session.getAttribute("times");
		if(sessionTimes == null) {
			// if not we set to 0
			session.setAttribute("times", 0);
		}
		model.addAttribute("people", Person.GetSomePeople());
		return "index.jsp";
	}
	// localhost:8080/ POST
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String Create(@RequestParam(value="username") String username, 
			@RequestParam(value="id") String id, Model model, HttpSession session, RedirectAttributes redirectAttrs) {
		
		Integer intId;
		try {
			intId = Integer.parseInt(id);
		} catch(NumberFormatException e) {
			redirectAttrs.addFlashAttribute("error", "Invalid Id (must be number)");
			return "redirect:/";
		}
		
		// get times out of session
		Integer sessionTimes = (Integer)session.getAttribute("times");
		// increment it
		sessionTimes++;
		// last, but certainly not least, put it back in session
		session.setAttribute("times", sessionTimes);
		
		
		Person newPerson = new Person(intId, username);
		model.addAttribute("person", newPerson);
		model.addAttribute("times", sessionTimes);
		return "show.jsp";
	}
	
	// show one person
	@RequestMapping("/{id}")
	public String Show(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("person", Person.GetOne());
		return "show.jsp";
	}
	
}
