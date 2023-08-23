package com.devtool.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DevtoolController {

	@RequestMapping("/test")
	@ResponseBody
	public String testDevTool() {
		int a = 12;
		int b = 12;
		int c = 11;
		int d = 2011;
		return "This is the devtool example, sum is = " + (a + b + c + d);
	}

}
