package net.sanjeev.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.sanjeev.shoppingbackend.dao.ICategoryDAO;
import net.sanjeev.shoppingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static ICategoryDAO iCategoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("net.sanjeev.shoppingbackend");
		context.refresh();
		
		iCategoryDAO = (ICategoryDAO) context.getBean("iCategoryDAO");
	}
	
	/*@Test
	public void testAddCategory(){
		category = new Category();
		
		category.setName("Television");
		category.setDescription("This is the description for the Television");
		category.setImageURL("CAT_1.jpg");
		
		assertEquals("Successfully added a category inside the table!", true, iCategoryDAO.add(category));
	}*/
	
	/*@Test
	public void testGetCategory(){
		category = iCategoryDAO.get(1);
		
		assertEquals("Successfully fecthed a single category from the table!", "Television", category.getName());
	}*/
	
	
	/*@Test
	public void testUpdateCategory(){
		category = iCategoryDAO.get(2);
		
		category.setName("TV");
		
		assertEquals("Successfully added a category inside the table!", true, iCategoryDAO.update(category));
	}*/

	/*@Test
	public void testDeleteCategory(){
		category = iCategoryDAO.get(2);
		
		
		assertEquals("Successfully delete a category from the table!", true, iCategoryDAO.delete(category));
	}*/
	
	
	/*@Test
	public void testListCategory(){
		category = iCategoryDAO.get(2);
		
		
		assertEquals("Successfully delete a category from the table!", 2, iCategoryDAO.list().size());
	}*/
	
	@Test
	public void testCRUDCategory(){
		
		//add a category
		category = new Category();
		category.setName("Television");
		category.setDescription("This is the description for the Television");
		category.setImageURL("CAT_1.jpg");
		assertEquals("Successfully added a category inside the table!", true, iCategoryDAO.add(category));
		
		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is the description for the Laptop");
		category.setImageURL("CAT_2.jpg");
		assertEquals("Successfully added a category inside the table!", true, iCategoryDAO.add(category));
		
		//Update a category
		category = iCategoryDAO.get(2);
		category.setName("TV");
		assertEquals("Successfully added a category inside the table!", true, iCategoryDAO.update(category));
		
		//Delete a category
		category = iCategoryDAO.get(2);
		assertEquals("Successfully delete a category from the table!", true, iCategoryDAO.delete(category));
		
		category = iCategoryDAO.get(1);
		assertEquals("Successfully delete a category from the table!", 1, iCategoryDAO.list().size());
	}
}
