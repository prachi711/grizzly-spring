package com.cts.grizzlywebstore.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.grizzlywebstore.bean.Login;
import com.cts.grizzlywebstore.bean.Product;
import com.cts.grizzlywebstore.service.LoginService;
import com.cts.grizzlywebstore.service.ProductService;


@Controller
public class LoginController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("login.html")
	public String getLoginPage()
	{
		System.out.println("!");
		return "login";
	}
    
	@Autowired
	@Qualifier("loginService")
	LoginService loginService; //reference
	
	@RequestMapping(value="login.html",method=RequestMethod.POST)
	
	public ModelAndView validateUser( @ModelAttribute Login login, HttpSession httpSession) {
		ModelAndView modelAndView=new ModelAndView();
		//HttpSession session;
		if("success".equals(loginService.validateUser(login)))
		{
			List<Product> product = productService.getAllProducts();
			
			httpSession.setAttribute("user", login);
			
			modelAndView.addObject("product",product);
			modelAndView.setViewName("Admin-ListProduct");
		}
		
		else
		{	
		    modelAndView.setViewName("login");
		}
		
		return modelAndView;
	}
	
}
