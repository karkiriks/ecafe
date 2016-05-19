package com.edu.ecafe.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.ecafe.Domain.Person;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
	
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String register(Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerUser(Model model) {
		Person person = new Person();
		model.addAttribute("registrationForm",person);
		return "registration";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		Person person = new Person();
		model.addAttribute("loginForm",person);
		return "login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@ModelAttribute("loginForm") Person user, Model model) {
		System.out.println(user.getUsername() + user.getPassword());
		return "redirect:/customerportal";
	}
}
