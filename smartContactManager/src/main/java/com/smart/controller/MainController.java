package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.smart.dao.UserRepo;
import com.smart.entity.User;
import jakarta.servlet.http.HttpSession;

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
		model.addAttribute("user", new User());
		return "singup";
	}

	@PostMapping("/do_register")
	public String doRegister(@ModelAttribute("user") User user,
			@RequestParam(value = "aggrement", defaultValue = "false") boolean aggrement, Model model,
			HttpSession session) {

		user.setRole("user");
		user.setEnabled("true");

		model.addAttribute("user", user);

		System.out.println(user);
		System.out.println("aggrement " + aggrement);

		return "singup";
	}
}
