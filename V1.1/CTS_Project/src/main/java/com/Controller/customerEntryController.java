package com.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DAO.customerEntryDao;
import com.POJO.customerEntryPojo;

@Controller

public class customerEntryController {
	
	@SuppressWarnings("unused")
	@RequestMapping("/saveCustomer")
		public String dataEntry(HttpServletRequest request , HttpServletResponse response , Model model ) {
			
		
		
		customerEntryPojo obj =new customerEntryPojo();
		
		obj.setCustomer_ID(0);
		obj.setCustomer_Name(request.getParameter("customer_Name"));
		obj.setCustomer_Phone(request.getParameter("customer_Phone"));
		obj.setCustomer_Password(request.getParameter("customer_Password"));
		obj.setCustomer_Address(request.getParameter("customer_Address"));
		
		
		String name = obj.getCustomer_Name();
		String password = obj.getCustomer_Password();
		String phone=obj.getCustomer_Phone();
		String Address = obj.getCustomer_Address();
		
		customerEntryDao Dobj = new customerEntryDao();
	Boolean entered	=Dobj.customerEntryDao1(name, password, phone, Address);
		
		if(entered==true)
	return "customerLogin";
		else 
		{
			
			 String errorMessge = null;
		    
		          errorMessge = "Customer Already Registered";
		      
			
		      model.addAttribute("errorMessge", errorMessge);
		      return "customerLogin";    
			
		}
		
	}
	
	
	
	
	
}
