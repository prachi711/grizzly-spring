package com.cts.grizzlywebstore.service;

import java.util.List; 

import com.cts.grizzlywebstore.bean.Product;

public interface ProductService {
	
	public String addProduct(Product product);
	public List<Product> getAllProducts();
	public Product findProduct(String PId);
	public void deleteProduct(String PId);
	public List<Product> filterProducts(String query);
	public String updateProduct(Product product);

}
