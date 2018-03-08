package net.sanjeev.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sanjeev.shoppingbackend.dao.IProductDAO;
import net.sanjeev.shoppingbackend.dto.Product;

@Controller
@RequestMapping(value = "/json/data")
public class JsonDataController {
	
	@Autowired
	private IProductDAO iProductDAO;
	
	@RequestMapping(value = "/all/products")
	@ResponseBody
	public List<Product> listAllProducts(){
		return iProductDAO.listActiveProducts();
	}
	
	@RequestMapping(value = "/category/{id}/products")
	@ResponseBody
	public List<Product> listAllProductsByCategory(@PathVariable("id") int id){
		return iProductDAO.listActiveProductsByCategory(id);
	}
}
