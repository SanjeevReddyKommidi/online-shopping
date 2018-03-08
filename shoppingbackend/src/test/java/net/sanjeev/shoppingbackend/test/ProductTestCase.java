package net.sanjeev.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.sanjeev.shoppingbackend.dao.IProductDAO;
import net.sanjeev.shoppingbackend.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static IProductDAO iProductDAO;
	
	private Product product;
	
	@BeforeClass
	public static void test(){
		context = new AnnotationConfigApplicationContext();
		context.scan("net.sanjeev.shoppingbackend");
		context.refresh();
		
		iProductDAO = (IProductDAO)context.getBean("iProductDAO");
		
	}
	
	
	/*@Test
	public void testCRUDProduct(){

		//Adding a new product
		product = new Product();
		product.setName("Oppo Selfie S54");
		product.setBrand("Oppo");
		product.setDescription("This is the description for Oppo mobile phones!");
		product.setUnitPrice(250000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		assertEquals("Something went wrong while inserting a new product!", true, iProductDAO.add(product));
		
		
		//Reading and updating a product
		product = iProductDAO.get(2);
		product.setName("Samsung Galaxy s7");
		assertEquals("Something went wrong while updating a new product!", true, iProductDAO.update(product));
		
		//Deleting a product
		product = iProductDAO.get(2);
		product.setActive(false);
		assertEquals("Something went wrong while deleting a product!", true, iProductDAO.update(product));
		
		//Get a single product
		product = iProductDAO.get(3);
		assertEquals("Something went wrong while getting a product!", "Google Pixel", product.getName());
	}*/
	
	@Test
	public void testListActiveProducts(){
		assertEquals("Something went wrong while getting active list products!",5, iProductDAO.listActiveProducts().size());
	}
	
	@Test
	public void testListActiveProductsByCategory(){
		assertEquals("Something went wrong while getting active list products by category!",3, iProductDAO.listActiveProductsByCategory(3).size());
	}
	
	@Test
	public void testLatestActiveProducts(){
		assertEquals("Something went wrong while getting active list products!",3, iProductDAO.getLatestActiveProducts(3).size());
	}
	
	
}
