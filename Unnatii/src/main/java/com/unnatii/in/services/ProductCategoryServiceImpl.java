package com.unnatii.in.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unnatii.in.dao.ProductCategoryDAO;
import com.unnatii.in.model.ProductCategory;

@Service
@Transactional
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryDAO productCategoryDAO;
	
	@Required
	public void addProductCategory(ProductCategory productCategory) {
		productCategoryDAO.addProductCategory(productCategory);
	}

	@Required
	public List<ProductCategory> listProductCategory() {

		return productCategoryDAO.listProductCategory();
	}

	@Required
	public void updateProductCategory(ProductCategory productCategory) {  
		productCategoryDAO.updateProductCategory(productCategory);        
    }  
	
	@Required
	public void removeProductCategory(Integer productCategoryId) {
		productCategoryDAO.removeProductCategory(productCategoryId);
	}
	
	@Required
	public List<ProductCategory> listSpecificProductCategory(Integer productCategoryId) {

		return productCategoryDAO.listSpecificProductCategory(productCategoryId);
	}
}
