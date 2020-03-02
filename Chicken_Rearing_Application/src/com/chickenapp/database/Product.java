package com.chickenapp.database;



public class Product {
	public int id;
	public  String description;
	public int productQuantity;
	public float productPrice;
	public String productType;
	public String productImagepath;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public Product(int id, String description, int productQuantity, float productPrice, String productType,
			String productImagepath) {
		super();
		this.id = id;
		this.description = description;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
		this.productType = productType;
		this.productImagepath = productImagepath;
	}




	public Product(String productType, String description, int productQuantity, float productPrice,String productImagePath) {
		super();
		this.productType = productType;
		this.description = description;
		this.productQuantity =productQuantity;
		this.productPrice = productPrice;
		this.productImagepath= productImagePath;
		
	}
	
	
	


	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public void setProductImagepath(String productImagepath) {
		this.productImagepath = productImagepath;
	}




	public String getProductImagepath() {
		return productImagepath;
	}


	public void setProductImagePath(String productImagepath) {
		this.productImagepath = productImagepath;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getProductQuantity() {
		return productQuantity;
	}


	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}


	public float getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}


	public String getProductType() {
		return productType;
	}


	public void setProductType(String productType) {
		this.productType = productType;
	}
}
