package com.cts.grizzlywebstore.dao;

import java.util.List;

import com.cts.grizzlywebstore.bean.Product;



public interface ProductDao {
	
	public String addProduct(Product product);
	public List<Product> getAllProducts();
	public Product findProduct(String id);
	public void deleteProduct(String PId);
	public List<Product> filterProducts(String query);
	public String updateProduct(Product product);

}
