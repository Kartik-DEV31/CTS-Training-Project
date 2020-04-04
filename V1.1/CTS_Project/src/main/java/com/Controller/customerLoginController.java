package com.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

import com.DAO.customerLoginDao;
import com.DAO.productsCRUDDao;
import com.POJO.adminLoginPojo;
import com.POJO.customerEntryPojo;

@Controller
public class customerLoginController {
	
	String name;
	String password;
	@SuppressWarnings( "rawtypes" )
	@RequestMapping("/customerLogin")
	public String Checker(HttpServletRequest request , HttpServletResponse response,Model model) {
		
		
		customerEntryPojo obj =new customerEntryPojo();
		
		
		
		obj.setCustomer_Name(request.getParameter("customer_Name"));
		obj.setCustomer_Password(request.getParameter("customer_Password"));
		 name = obj.getCustomer_Name();
		 password = obj.getCustomer_Password();
		
		customerLoginDao Dobj = new customerLoginDao();
		
		List list =Dobj.loginQuery(name ,password);
		
		
		
		
		if ((list != null) && (list.size() > 0)) {
			
			
			customerEntryPojo lobj = new customerEntryPojo();
			
			lobj.setFlag(1);
			
			HttpSession session = request.getSession();
			session.setAttribute("sdata", lobj);
			
			
			
			return "redirect:/display2";
		}

		else 
		{
			
			
			boolean error = true;
			 String errorMessge = null;
		      if(error == true)
		      {
		          errorMessge = "Username or Password is incorrect !!";
		      }
			
		      model.addAttribute("errorMessge", errorMessge);
		      
		return "/customerLogin";      
		
		}
		
		
	}
	
	
	@SuppressWarnings({ "rawtypes", "resource" })
	@RequestMapping("/display2")
	public String view(Model m, HttpServletRequest request) {
		ApplicationContext conn = null;
		conn=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		productsCRUDDao Dobj = conn.getBean("dao",productsCRUDDao.class); 
		
		
		
		
		
		System.out.println(name);
		
		request.getSession().setAttribute("customer_Name", name);
		request.getSession().setAttribute("customer_Password", password);
		
		List list = Dobj.displayData();
		if(!list.isEmpty()) {
			

			
			m.addAttribute("Products",list);
			
			
		}
		else
		{
			
			m.addAttribute("message", "no data found.....");
		}
		
		HttpSession session = request.getSession();
		customerEntryPojo cobj = (customerEntryPojo)session.getAttribute("sdata");
		if(cobj.getFlag()==1)
		{
		
		return "shoppingDisplay";
		}
		
		else {
			return "/customerLogin";
		}
	}
	
	
	@RequestMapping("/customerLogout")
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		customerEntryPojo obj = (customerEntryPojo)session.getAttribute("sdata");
		
		obj.setFlag(0);
         
		return "redirect:/display2";  
		
	}
	
	

}
