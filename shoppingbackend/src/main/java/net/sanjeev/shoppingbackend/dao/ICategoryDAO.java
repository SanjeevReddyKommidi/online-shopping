package net.sanjeev.shoppingbackend.dao;

import java.util.List;

import net.sanjeev.shoppingbackend.dto.Category;

public interface ICategoryDAO {
	
	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	
	
	
}
