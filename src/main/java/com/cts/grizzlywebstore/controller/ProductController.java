package com.cts.grizzlywebstore.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.grizzlywebstore.bean.Product;
import com.cts.grizzlywebstore.service.ProductService;


@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
     
	@RequestMapping(value="AddProduct.html")
	public String getaddProduct()
	{
		
		return "AddProduct";
	}
	
	@RequestMapping(value="AddProduct.html", method=RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute Product product, HttpSession httpSession)
	{
		ModelAndView modelAndView=new ModelAndView();
		if("success".equals(productService.addProduct(product)))
		{
			//System.out.println("Product Added");
			//modelAndView.setViewName("Admin-ListProduct");
//			List<Product> products=productService.getAllProducts();
//			httpSession.setAttribute("product", products);
//			modelAndView.setViewName("Admin-ListProduct");
			
		}
		return modelAndView;
	}
	
	@RequestMapping(value="Admin-ListProducts.html", method=RequestMethod.GET)
	public ModelAndView ListProduct(@ModelAttribute Product product, HttpSession httpSession)
	{
		ModelAndView modelAndView = new ModelAndView();
		
		List<Product> products = productService.getAllProducts();
		modelAndView.setViewName("Admin-ListProducts");
		httpSession.setAttribute("product",products);
		return modelAndView;
		
	}
	
	@RequestMapping(value="viewProduct.html", method=RequestMethod.GET)
	public ModelAndView getViewPage(@RequestParam("id") String id)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Admin-ViewProduct");
		Product products = productService.findProduct(id);
		modelAndView.addObject("product",products);
		return modelAndView;
	}
	
	@RequestMapping(value="deleteProduct.html",method=RequestMethod.GET)
	public ModelAndView deleteProduct(String PId)
	{
	   ModelAndView modelAndView=new ModelAndView();
	   modelAndView.setViewName("Admin-ListProduct");
	   productService.deleteProduct(PId);
	   
	   List<Product> products=productService.getAllProducts();
	   modelAndView.addObject("product",products);
		return modelAndView;
	   
	}
	
	
	
	
}
