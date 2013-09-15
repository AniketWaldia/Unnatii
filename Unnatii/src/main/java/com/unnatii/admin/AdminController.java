package com.unnatii.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	
	@RequestMapping(value="/admin/dashboard",method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Spring Security Hello World");
		return "/admin/dashboard";		
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "/admin/login";
	}
 
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "/admin/login";
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "/admin/login";
	}
}