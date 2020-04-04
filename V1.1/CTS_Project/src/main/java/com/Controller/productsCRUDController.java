package com.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.DAO.productsCRUDDao;
import com.POJO.adminLoginPojo;
import com.POJO.productsCRUDPojo;


@Controller
public class productsCRUDController {
	
	
	@RequestMapping("/addProduct")
	public String productEntry(HttpServletRequest request , HttpServletResponse response) {
		
	
	
		productsCRUDPojo obj =new productsCRUDPojo();
	
	obj.setProduct_ID(0);
	obj.setProduct_Name(request.getParameter("product_Name"));
	obj.setProduct_Cost(request.getParameter("product_Cost"));
	obj.setProduct_Picture(request.getParameter("product_Picture"));
	
	
	
	String name = obj.getProduct_Name();
	String cost = obj.getProduct_Cost();
	String picture=obj.getProduct_Picture();
	int id = obj.getProduct_ID();
	
	productsCRUDDao Dobj = new productsCRUDDao();
	HttpSession session = request.getSession();
	adminLoginPojo use = (adminLoginPojo)session.getAttribute("sdata");
	if(use.getFlag()==1) {
	Dobj.insertData(name,cost,picture,id);
	return "redirect:/display";
	}
	else {
		return "redirect:/display";
	}

}
	@RequestMapping(value="deleteProduct/{product_ID}")
	public String productDelete(@PathVariable("product_ID") int product_ID,HttpServletRequest request) {
		
	
	
		productsCRUDPojo obj =new productsCRUDPojo();
	
	obj.setProduct_ID(product_ID);
	
	int id = obj.getProduct_ID();
	
	productsCRUDDao Dobj = new productsCRUDDao();
	HttpSession session = request.getSession();
	adminLoginPojo use = (adminLoginPojo)session.getAttribute("sdata");
	if(use.getFlag()==1) {
	Dobj.DeleteData(id);
	return "redirect:/display";
	}
	else {
		return "redirect:/display";
	}
}
	
	
	@RequestMapping(value="updateProduct/{product_Name}" ,method = RequestMethod.POST)
	public String productUpdate(HttpServletRequest request , HttpServletResponse response
			,productsCRUDPojo employeeBean,@PathVariable("product_Name") String product_Name) {
		
		
		
		productsCRUDPojo obj =new productsCRUDPojo();
		
		obj.setProduct_Name(product_Name);
		obj.setProduct_Cost(request.getParameter("PriceUpdate"));
		
		String cost = obj.getProduct_Cost();
		String name = obj.getProduct_Name();
		
		productsCRUDDao Dobj = new productsCRUDDao();
		HttpSession session = request.getSession();
		adminLoginPojo use = (adminLoginPojo)session.getAttribute("sdata");
		if(use.getFlag()==1) {
		Dobj.updateProduct(cost, name);
		return "redirect:/display";
		}
		
		else return "redirect:/display";
	
	


}
	
	
	
	
	
	
	
	
	

}
