package com.cts.grizzlywebstore.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.grizzlywebstore.bean.Product;
import com.cts.grizzlywebstore.dao.ProductDao;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
    
	@Autowired
	private ProductDao productDao;
	
	@Transactional(readOnly = true, propagation=Propagation.SUPPORTS)
	@Override
	public String addProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.addProduct(product);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.getAllProducts();
	}

	@Override
	public Product findProduct(String PId) {
		// TODO Auto-generated method stub
		return productDao.findProduct(PId);
	}

	@Override
	public void deleteProduct(String PId) {
		// TODO Auto-generated method stub
		productDao.deleteProduct(PId);
	}

	@Override
	public List<Product> filterProducts(String query) {
		// TODO Auto-generated method stub
		return productDao.filterProducts(query);
	}

	@Override
	public String updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(product);
	}

}
