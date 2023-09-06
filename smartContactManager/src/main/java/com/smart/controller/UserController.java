package com.smart.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.dao.UserRepo;
import com.smart.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepo userRepo;

	@RequestMapping("/index")
	public String dashboard(Model model, Principal principle) {

		User user = this.userRepo.getUserByUserName(principle.getName());
		model.addAttribute("user", user);
		
		System.out.println(user);

		return "normal/user_dashboard";
	}

}
