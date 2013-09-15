package com.unnatii.in.dao;
import com.unnatii.in.model.ProductCategory;

import java.util.List;

import com.unnatii.in.model.Product;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductsDAOImpl implements ProductsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addProducts(Product product) {
		sessionFactory.getCurrentSession().save(product);
		//sessionFactory.getCurrentSession().getTransaction().commit();
	}
	
     public List<Product> listProduct() {		
		Query qry;
		qry=sessionFactory.getCurrentSession().createQuery("from Product ORDER BY ID DESC");
				return qry.list();
		
	}

     public void updateProducts(Product product) {  
         sessionFactory.getCurrentSession().update(product);        
     }  
	

public List<Product> listSpecificProduct(Integer productId) {
		
		Query qry;
		qry=sessionFactory.getCurrentSession().createQuery("from Product where ID =" + productId );
		
		return qry.list();
		
	}
	
	public void removeProduct(Integer id) {
		Product contact = (Product) sessionFactory.getCurrentSession().load(
				Product.class, id);
		if (null != contact) {
			sessionFactory.getCurrentSession().delete(contact);
		}

	}
	
	 public List<ProductCategory> listcategory(){
    	 Query qry;
 		qry=sessionFactory.getCurrentSession().createQuery("from ProductCategory");
 				return qry.list();
     }

	 public List<Product> categoryWiseProducts(Integer categoryId) {
			
			Query qry;
			qry=sessionFactory.getCurrentSession().createQuery("from Product where Category=" + categoryId );
			
			return qry.list();
			
		}
}
