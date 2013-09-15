package com.unnatii.in.services;

import java.util.List;

import com.unnatii.in.model.ProductCategory;

public interface ProductCategoryService {
	
	public void addProductCategory(ProductCategory productCategory);
	public List<ProductCategory> listProductCategory();
	public void updateProductCategory(ProductCategory productCategory); 
	public void removeProductCategory(Integer productCategoryId);
	public List<ProductCategory> listSpecificProductCategory(Integer productCategoryId);
	
}
