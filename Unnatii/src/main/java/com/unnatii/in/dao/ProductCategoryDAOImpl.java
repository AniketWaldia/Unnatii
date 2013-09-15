package com.unnatii.in.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unnatii.in.model.ProductCategory;

@Repository
public class ProductCategoryDAOImpl implements ProductCategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addProductCategory(ProductCategory productCategory) {
		
		sessionFactory.getCurrentSession().save(productCategory);
	}

	@SuppressWarnings("unchecked")
	public List<ProductCategory> listProductCategory() {
		return sessionFactory.getCurrentSession().createQuery("from ProductCategory order by ID DESC").list();
	}
	
	 public void updateProductCategory(ProductCategory productCategory) {  
         sessionFactory.getCurrentSession().update(productCategory);        
     }  
	
     @SuppressWarnings("unchecked")
	public List<ProductCategory> listSpecificProductCategory(Integer productCategoryId) {
		Query qry;
		qry=sessionFactory.getCurrentSession().createQuery("from ProductCategory where CategoryId =" + productCategoryId );		
		return qry.list();
		}

	public void removeProductCategory(Integer productCategoryId) {
		ProductCategory productCategory = (ProductCategory) sessionFactory.getCurrentSession().load(
				ProductCategory.class, productCategoryId);
		if (null != productCategory) {
			sessionFactory.getCurrentSession().delete(productCategory);
		}
	}
}
