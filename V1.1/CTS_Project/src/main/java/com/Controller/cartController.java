package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
class cartController {

	@RequestMapping("/addCart")
	public String cart() {
	
		return "success";
		
	}
	
}
