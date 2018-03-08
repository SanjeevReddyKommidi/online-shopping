package net.sanjeev.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.sanjeev.shoppingbackend.dao.ICategoryDAO;
import net.sanjeev.shoppingbackend.dto.Category;

@Repository(value = "iCategoryDAO")
@Transactional
public class CategoryDAOImpl implements ICategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// Getting a single category
	public Category get(int id) {
		
		return sessionFactory
				.getCurrentSession()
					.get(Category.class, Integer.valueOf(id));
	}

	// To get list of categories
	public List<Category> list() {
		
		String selectActiveCategory = "FROM Category WHERE active = :active";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveCategory, Category.class)
						.setParameter("active", true)
							.getResultList();
	}

	//To add a new category to the database
	 // To avail transaction capability to add category
	public boolean add(Category category) {
		try {
			sessionFactory
				.getCurrentSession()
					.persist(category);
			
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();

			return false;
		}
	}

	public boolean update(Category category) {
		try {
			sessionFactory
				.getCurrentSession()
					.update(category);
			
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();

			return false;
		}
	}

	public boolean delete(Category category) {
		category.setActive(false);
		
		try {
			sessionFactory
				.getCurrentSession()
					.update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();

			return false;
		}
	}
}
