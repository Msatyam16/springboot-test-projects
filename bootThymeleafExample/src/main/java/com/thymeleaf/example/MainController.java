package com.thymeleaf.example;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Model m) {

		System.out.println("Going to find about page...");

		m.addAttribute("name", "Satyam Mishra");
		m.addAttribute("currentDate", new Date().toLocaleString());

		return "about";
	}

	@GetMapping("/iterate")
	public String iterate(Model m) {

		List<String> namesLst = List.of("Ram", "Sita", "Lakghman", "Hanuman");

		m.addAttribute("names", namesLst);

		return "iterate";
	}

	@GetMapping("/conditions")
	public String conditions(Model m) {

		List<String> namesLst = List.of("Ram", "Sita", "Lakghman", "Hanuman");

		m.addAttribute("flag", true);
		m.addAttribute("gender", "F");
		m.addAttribute("names", namesLst);

		return "conditions";
	}

}
