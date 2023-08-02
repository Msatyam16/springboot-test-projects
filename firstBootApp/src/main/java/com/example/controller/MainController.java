package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/homepage")
	public String homeMethod() {
		return "home";
	}

	@RequestMapping("/profilepage")
	public String profileMethod() {
		return "profile";
	}
}
