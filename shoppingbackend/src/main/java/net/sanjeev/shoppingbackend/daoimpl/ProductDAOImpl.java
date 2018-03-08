package net.sanjeev.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.sanjeev.shoppingbackend.dao.IProductDAO;
import net.sanjeev.shoppingbackend.dto.Product;

@Repository(value = "iProductDAO")
@Transactional
public class ProductDAOImpl implements IProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	// Get single Product by productId
	@Override
	public Product get(int productId) {
		return sessionFactory
				.getCurrentSession()
					.get(Product.class, Integer.valueOf(productId));
	}

	//Get list of products 
	@Override
	public List<Product> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product",Product.class)
						.getResultList();
	}

	
	//Add a single product
	@Override
	public boolean add(Product product) {
		
		try{
			sessionFactory
			  .getCurrentSession()
				 .persist(product);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		
	}

	
	//Update a product
	@Override
	public boolean update(Product product) {
		
		try{
			sessionFactory
			  .getCurrentSession()
				 .update(product);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return false;
	}

	//Deactivate or delete a product softly
	@Override
	public boolean delete(Product product) {
		product.setActive(false);
		return this.update(product);
	}

	
	//Business methods 
	
	/*
	 * Method to get all the active products
	 * (non-Javadoc)
	 * @see net.sanjeev.shoppingbackend.dao.IProductDAO#listActiveProducts()
	 */
	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE active = :active";
		
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProducts, Product.class)
						.setParameter("active", true)
							.getResultList();
	}

	
	/*
	 * To get list of active products by category
	 * (non-Javadoc)
	 * @see net.sanjeev.shoppingbackend.dao.IProductDAO#listActiveProductsByCategory(int)
	 */
	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProductsByCategory, Product.class)
						.setParameter("active", true)
						.setParameter("categoryId", Integer.valueOf(categoryId))
							.getResultList();
	}

	/* To get latest active products
	 * (non-Javadoc)
	 * @see net.sanjeev.shoppingbackend.dao.IProductDAO#getLatestActiveProducts(int)
	 */
	@Override
	public List<Product> getLatestActiveProducts(int count) {
		
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product WHERE active = :active ORDER BY id", Product.class)
						.setParameter("active", true)
							.setFirstResult(0)
							.setMaxResults(count)
								.getResultList();
	}

}
