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

	/*
	 * This controller is for that how to fetch data from controller side to view
	 * side (same as JSTL)
	 */

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Model m) {

		System.out.println("Going to find about page...");

		m.addAttribute("name", "Satyam Mishra");
		m.addAttribute("currentDate", new Date().toLocaleString());

		return "about";
	}

//--------------------------------------------------------------------------------------//	

	/* This controller is for that how to iterate list */

	@GetMapping("/iterate")
	public String iterate(Model m) {
		List<String> namesLst = List.of("Ram", "Sita", "Lakghman", "Hanuman");
		m.addAttribute("names", namesLst);
		return "iterate";
	}

//--------------------------------------------------------------------------------------//	

	/*
	 * This controller is for types of conditions ((condition) ? true : false /
	 * if-unless / switch-case)
	 */

	@GetMapping("/conditions")
	public String conditions(Model m) {

		List<String> namesLst = List.of("Ram", "Sita", "Lakghman", "Hanuman");

		m.addAttribute("flag", true);
		m.addAttribute("gender", "F");
		m.addAttribute("names", namesLst);

		return "conditions";
	}

//--------------------------------------------------------------------------------------//

	/*
	 * This controller is for types of fragments (th:fragment / th:replace /
	 * th:include / th:insert)
	 */

	@GetMapping("/service")
	public String fragmentService(Model m) {

		// These lines of code work only when you want to sent dynamic data to view
		m.addAttribute("title", "This title is from controller page --> Satyam");
		m.addAttribute("subtitle", "This date is from controller page --> " + new Date().toLocaleString());

		return "service";
	}

//--------------------------------------------------------------------------------------//

	/*
	 * This controller is to call the base templete with other templates.
	 */

	@GetMapping("/aboutnew")
	public String aboutnew() {
		return "aboutnew";
	}

	@GetMapping("/contactnew")
	public String contactnew() {
		return "contactnew";
	}

//--------------------------------------------------------------------------------------//	

}
