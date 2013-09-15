package com.unnatii.in;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ErrorController {

	@RequestMapping(value="/404")
	public String error404(){
		return "404";
	}
	
	@RequestMapping(value="/500")
	public String error500(){
		return "500";
	}
	
	@RequestMapping(value="/under")
	public String underConstruction(){
		return "error/underConstruction";
	}

}
