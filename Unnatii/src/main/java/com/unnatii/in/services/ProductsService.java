package com.unnatii.in.services;
import com.unnatii.in.model.ProductCategory;

import java.util.List;

import com.unnatii.in.model.Product;

public interface ProductsService {
	
	public void addProduct(Product product);
	public List<Product> listProduct();
	public void updateProducts(Product product); 
	public void removeProduct(Integer id);
	public List<Product> listSpecificProduct(Integer productId);
	public List<ProductCategory> listcategory();
	public List<Product> categoryWiseProducts(Integer categoryId);
	
}
