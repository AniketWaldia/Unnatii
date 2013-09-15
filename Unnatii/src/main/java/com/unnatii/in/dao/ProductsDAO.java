package com.unnatii.in.dao;
import com.unnatii.in.model.ProductCategory;

import java.util.List;


import com.unnatii.in.model.Product;

public interface ProductsDAO {
	
	public void addProducts(Product product);
	public List<Product> listProduct();
	public void updateProducts(Product product);
	public void removeProduct(Integer id);
	public List<Product> listSpecificProduct(Integer contactId);
	public List<ProductCategory> listcategory();
	public List<Product> categoryWiseProducts(Integer categoryId);
}