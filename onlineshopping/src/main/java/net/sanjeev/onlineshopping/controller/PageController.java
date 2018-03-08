package net.sanjeev.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.sanjeev.onlineshopping.exception.ProductNotFoundException;
import net.sanjeev.shoppingbackend.dao.ICategoryDAO;
import net.sanjeev.shoppingbackend.dao.IProductDAO;
import net.sanjeev.shoppingbackend.dto.Category;
import net.sanjeev.shoppingbackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private ICategoryDAO iCategoryDAO;
	
	@Autowired
	private IProductDAO iProductDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index(){
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title", "Home");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
		modelAndView.addObject("userClicksHome", true);
		modelAndView.addObject("categories", iCategoryDAO.list());
		return modelAndView;
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about(){
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title", "About Us");
		modelAndView.addObject("userClicksAbout", true);
		return modelAndView;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact(){
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title", "Contact Us");
		modelAndView.addObject("userClicksContact", true);
		return modelAndView;
	}
	
	/*
	 * Methods to load all the products and based on category
	 * */
	
	@RequestMapping(value = "/show/all/products" )
	public ModelAndView showAllProducts(){
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title", "All Products");
		modelAndView.addObject("userClicksAllProducts", true);
		modelAndView.addObject("categories", iCategoryDAO.list());
		return modelAndView;
	}
	
	@RequestMapping(value = "/show/category/{id}/products" )
	public ModelAndView showCategoryProducts(@PathVariable("id") int id){
		ModelAndView modelAndView = new ModelAndView("page");
		
		//iCategoryDAO to fetch a single category
		Category category = null;
		category = iCategoryDAO.get(id);
		
		modelAndView.addObject("title", category.getName());
		
		//Passing the list of categories
		modelAndView.addObject("categories", iCategoryDAO.list());

		//Passing a single category
		modelAndView.addObject("category", category);
		
		modelAndView.addObject("userClicksCategoryProducts", true);
		return modelAndView;
	}
	
	
	//Viewing a single product
	@RequestMapping(value = "/show/{id}/product" )
	public ModelAndView showSingleProducts(@PathVariable("id") int id) throws ProductNotFoundException{
		
		Product product = iProductDAO.get(id);
		
		if(product == null) throw new ProductNotFoundException();
		
		//Update the view count
		product.setViews(product.getViews() + 1);
		iProductDAO.update(product);
		
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title", product.getName() );
		
		modelAndView.addObject("userClicksShowProduct", true);
		modelAndView.addObject("product", product);
		return modelAndView;
	}
}
