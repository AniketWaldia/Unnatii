package com.unnatii.in.dao;

import java.util.List;

import com.unnatii.in.model.ProductCategory;

public interface ProductCategoryDAO {
	
	public void addProductCategory(ProductCategory productCategory);
	public List<ProductCategory> listProductCategory();
	public void removeProductCategory(Integer productCategoryId);
	public void updateProductCategory(ProductCategory productCategory);
	public List<ProductCategory> listSpecificProductCategory(Integer productCategoryId);
	
}