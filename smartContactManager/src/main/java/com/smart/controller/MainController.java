package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.dao.UserRepo;
import com.smart.entity.Contact;
import com.smart.entity.User;

@Controller
public class MainController {

	@Autowired
	private UserRepo userRepo;

	@GetMapping("/test")
	@ResponseBody
	public String test() {

		User user = new User();
		user.setName("Ram ji");
		user.setEmail("ramji@ayodhya.com");

		Contact contact = new Contact();
//		contact.setName("sita ji");
//		contact.setEmail("sitaji@ayodhya.com");

		user.getContact().add(contact);

		this.userRepo.save(user);

		return "test";
	}
}
