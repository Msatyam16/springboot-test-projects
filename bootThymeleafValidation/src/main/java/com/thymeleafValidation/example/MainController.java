package com.thymeleafValidation.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.thymeleafValidation.example.entity.LoginData;

@Controller
public class MainController {

	@GetMapping("/login")
	public String viewLogin(Model model) {

		System.out.println("Finding login.html page...");
		model.addAttribute("loginData", new LoginData());
		return "login";
	}

}
