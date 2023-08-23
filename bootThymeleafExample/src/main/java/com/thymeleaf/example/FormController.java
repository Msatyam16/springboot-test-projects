package com.thymeleaf.example;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.thymeleaf.example.entity.LoginData;

@Controller
public class FormController {

	@GetMapping("/login")
	public String login(Model model) {

		System.out.println("Finding log.html page...");
		model.addAttribute("loginData", new LoginData());
		return "login";
	}
	
	@PostMapping("/process")
	public String process(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult result, Model m) {

		System.out.println("Finding success.html page...");
		
		if(result.hasErrors()) {
			return "login";
		}
		
		return "success";
	}
}
