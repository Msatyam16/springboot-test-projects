package com.sts.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/homepage")
	public String homeMethod() {
		return "home";
	}

	@RequestMapping("/contactpage")
	public String contactMethod() {
		return "contact";
	}
}
