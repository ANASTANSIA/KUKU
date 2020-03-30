package com.chickenapp.database;



public class Product {
	public int productId;
	public  String description;
	public int productQuantity;
	public float productPrice;
	public String productType;
	public String imagePath;
	public int userId;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public Product(int productId, String description, int productQuantity, float productPrice, String productType,
			String imagePath) {
		super();
		this.productId = productId;
		this.description = description;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
		this.productType=productType;
		this.imagePath=imagePath;
	}




	public Product(String productType, String description, int productQuantity, float productPrice,String imagePath) {
		super();
		this.productType = productType;
		this.description = description;
		this.productQuantity =productQuantity;
		this.productPrice = productPrice;
		this.imagePath= imagePath;
		
	}
	
	
	


	public Product(String productType, String description, int quantity, Float price, String fileName, int userId) {
		// TODO Auto-generated constructor stub
	}




	public int getProductId() {
		return productId;
	}




	public void setProductId(int id) {
		this.productId = productId;
	}



//
//	public void setProductImagepath(String imagePath) {
//		this.imagePath = imagePath;
//	}




	public int getUserId() {
		return userId;
	}




	public void setUserId(int userId) {
		this.userId = userId;
	}




	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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
