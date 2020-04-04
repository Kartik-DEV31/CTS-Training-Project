package com.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.DAO.adminLoginDao;
import com.DAO.productsCRUDDao;
import com.POJO.adminLoginPojo;
import com.mysql.cj.Session;


@Controller
public class adminLoginController {
	
	
	@SuppressWarnings({ "rawtypes", "unused" })
	@RequestMapping(value = "/adminLogin",method = RequestMethod.POST)
	public String AdminChecker(HttpServletRequest request , HttpServletResponse response,Model model) {
	
		
		adminLoginPojo obj =new adminLoginPojo();
		
	
		
		obj.setEmail_ID(request.getParameter("email_ID"));
		obj.setPassword(request.getParameter("password"));
		String email = obj.getEmail_ID();
		String password = obj.getPassword();
		
		adminLoginDao Dobj = new adminLoginDao();
	
		List list = Dobj.loginQuery(email, password);

		if ((list != null) && (list.size() > 0)) {
			
			adminLoginPojo e11 = new adminLoginPojo();
			
			e11.setFlag(1);
			
			HttpSession session = request.getSession();
			session.setAttribute("sdata", e11);
		
			
			
			return "redirect:/display";
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
		      return "adminLogin";    

		}
			
		  
		
		
		
	}
	
	
	@SuppressWarnings({ "rawtypes", "resource" })
	@RequestMapping("/display")
	public String view(Model m , HttpServletRequest request) {
		ApplicationContext conn = null;
		conn=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		productsCRUDDao Dobj = conn.getBean("dao",productsCRUDDao.class); 
		List list = Dobj.displayData();
		if(!list.isEmpty()) {
			
			m.addAttribute("Products",list);
			
		}
		else
		{
			
			m.addAttribute("message", "no data found.....");
		}
		
		HttpSession session = request.getSession();
		adminLoginPojo use = (adminLoginPojo)session.getAttribute("sdata");
		
		if(use.getFlag()==1)
		{
			return "productsDataBaseDisplay";
		}
		return "adminLogin";
	}
	
	@RequestMapping("/adminLogout")
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		adminLoginPojo obj = (adminLoginPojo)session.getAttribute("sdata");
		
		obj.setFlag(0);
         
		return "redirect:/display";  
		
	}
	
	
}
