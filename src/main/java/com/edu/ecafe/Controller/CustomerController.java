package com.edu.ecafe.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edu.ecafe.Domain.Person;
import com.edu.ecafe.Service.PersonService;

@Controller
public class CustomerController {

	@Autowired
	PersonService personService;

	@RequestMapping(value = "/customerportal", method = RequestMethod.GET)
	public String customer(Model model) {
		return "customerportal";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("registrationForm") Person person, Model model,
			RedirectAttributes redirectAttributes) {
		personService.savePerson(person);
		System.out.println(person.getFirstName());
		redirectAttributes.addFlashAttribute("message",
				"Congratulations User:" + person.getUsername() + " has been created successfully");
		return "redirect:/home";
	}

}
