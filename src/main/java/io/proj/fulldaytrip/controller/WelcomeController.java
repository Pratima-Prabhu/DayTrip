package io.proj.fulldaytrip.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String showWelcomPage() {
		return "welcome";
	}
	
//	@RequestMapping(value="/",method=RequestMethod.GET)
//	public String getlistpage(Model model) {
//		return "list-places";
//	}
	

}
