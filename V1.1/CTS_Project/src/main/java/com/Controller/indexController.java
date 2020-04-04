package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class indexController {

	@RequestMapping(value = "/adminLoginPage" , method = RequestMethod.GET )
	public String adminlogin() {
		
		return "adminLogin";
		
	}
	
	@RequestMapping(value = "/customerLoginPage" , method = RequestMethod.GET )
	public String customerlogin() {
		
		return "customerLogin";
		
	}
	
	
	@RequestMapping(value = "/AboutUS" , method = RequestMethod.GET )
	public String aboutus() {
		
		return "AboutUS";
		
	}
	
	
}
