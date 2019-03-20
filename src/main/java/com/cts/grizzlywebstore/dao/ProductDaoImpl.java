package com.cts.grizzlywebstore.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.grizzlywebstore.bean.Login;
import com.cts.grizzlywebstore.bean.Product;
import com.mysql.cj.api.Session;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	 SessionFactory sessionFactory;

	@Override
	public String addProduct(Product product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(product);
		return "success";
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		TypedQuery<Product> query = sessionFactory.getCurrentSession().createQuery("from Product");
		return query.getResultList();
	}

	@Override
	public Product findProduct(String id) {
		// TODO Auto-generated method stub
		
		org.hibernate.Session session=sessionFactory.getCurrentSession();
		String Squery="from Product where pId=?";
		org.hibernate.query.Query<Product>query=null;
		
		query=session.createQuery(Squery);
		query.setParameter(0, id);
		Product pro = query.getSingleResult();
		return pro;
		
		
	}

	@Override
	public void deleteProduct(String PId) {
		// TODO Auto-generated method stub
		
		Product product = sessionFactory.getCurrentSession().load(Product.class, PId);
		sessionFactory.getCurrentSession().delete(product);
		
	}

	@Override
	public List<Product> filterProducts(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
