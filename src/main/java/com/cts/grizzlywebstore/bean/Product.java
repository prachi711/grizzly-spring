package com.cts.grizzlywebstore.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product {
    
	@Id
	@Column
	private String pId;
	@Column
	private String category;
	@Column
	private String productName;
	@Column
	private String pDescription;
	@Column
	private String price;
	@Column
	private String brand;
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getpDescription() {
		return pDescription;
	}
	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Product(String pId, String category, String productName, String pDescription, String price, String brand) {
		super();
		this.pId = pId;
		this.category = category;
		this.productName = productName;
		this.pDescription = pDescription;
		this.price = price;
		this.brand = brand;
	}
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [pId=" + pId + ", category=" + category + ", productName=" + productName + ", pDescription="
				+ pDescription + ", price=" + price + ", brand=" + brand + "]";
	}
	
	
	
	
	
}
