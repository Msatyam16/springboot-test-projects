package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.smart.dao.UserRepo;
import com.smart.entity.Contact;
import com.smart.entity.User;

@Controller
public class MainController {

	@Autowired
	private UserRepo userRepo;

	@RequestMapping("/")
//	@ResponseBody
	public String home(Model model) {

		model.addAttribute("title", "Home - smart contact manager");
		return "home";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "About - smart contact manager");
		return "about";
	}
	
	@RequestMapping("/singup")
	public String singup(Model model) {
		model.addAttribute("title", "singup - smart contact manager");
		return "singup";
	}
}
