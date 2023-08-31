package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.smart.dao.UserRepo;
import com.smart.entity.User;
import com.smart.helper.Message;
import jakarta.validation.Valid;

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
	public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult result,
			@RequestParam(value = "aggrement", defaultValue = "false") boolean aggrement, Model model
//			, HttpSession session
	) {

		try {

			if (!aggrement) {
				System.out.println("You have not checked terms and conditions !! ");
				throw new Exception("You have not checked terms and conditions !! ");
			}

			if (result.hasErrors()) {
				System.out.println("Error - " + result.toString());
				model.addAttribute("user", user);
				return "singup";
			}

			user.setRole("user");
			user.setEnabled("true");
			user.setImageUrl("default.png");
			
			userRepo.save(user);

			model.addAttribute("user", new User());

			/* session is not working, so set in model */
			model.addAttribute("message", new Message("Successfully Registered!! ", "alert-success"));
//			session.setAttribute("message", new Message("Data inserted successfully !! ", "alert-success"));

			return "singup";

		} catch (Exception e) {
			e.printStackTrace();

			model.addAttribute("user", user);

			/* session is not working, so set in model */
			model.addAttribute("message", new Message("Something went wrong !! " + e.getMessage(), "alert-danger"));
//			session.setAttribute("message", new Message("Something went wrong !! " + e.getMessage(), "alert-danger"));

			return "singup";
		}

	}
}
