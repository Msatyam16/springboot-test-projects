package com.validation.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.validation.example.entity.LoginData;

@Controller
public class MainController {

	@GetMapping("/form")
	public String about(Model model) {

		System.out.println("Opening form page.");
		model.addAttribute("loginData", new LoginData());

		return "form";
	}

}
