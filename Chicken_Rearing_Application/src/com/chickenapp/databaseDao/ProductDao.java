package com.chickenapp.databaseDao;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chickenapp.database.*;

public class ProductDao  {
	
    private String insertProductQuery="insert into product(productType,description,quantity,price,imagePath)values (?,?,?,?,?)";
    private   String selectByIdQuery = "select productType,description,quantity,price,imagePath from product where id =?";
    private   String selectAllProductsQuery = "select * from product";
    private  String deleteproductQuery = "delete from product where id = ?;";
    private  String updateProductQuery = "update product set productType = ?,description= ?,quantity=?,price=?,imagePath=? where id = ?";
    private String searchQuery="select";
    
    Dao dao= new Dao();
    ResultSet rs;
    PreparedStatement ps;


 public Product saveProduct(Product product){  
         ps=dao.insertToDb(insertProductQuery);
        try{  
       
            ps.setString(1,product.getProductType());  
            ps.setString(2,product.getDescription());  
            ps.setInt(3,product.getProductQuantity());
            ps.setFloat(4,product.getProductPrice());
            ps.setString(5,product.getProductImagepath());
            
            ps.executeUpdate();  
              
              
        }catch(Exception ex){ex.printStackTrace();}  
          
        return product;  
    }
 public Product selectProduct(int id) {
        Product product = null;
        rs=dao.readfromDb(selectByIdQuery);
        try 
        {
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
            	 
                String productType = rs.getString("ProductType");
                String description = rs.getString("decription");
                int quantity =Integer.parseInt(rs.getString("productQuantity"));
                float price=Float.parseFloat(rs.getString("productPrice"));
                String imagePath=rs.getString("productImagePath");
               
                product= new Product( productType,description , quantity,price,imagePath);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
 
  public Product updateProduct(Product product) throws SQLException {
        ps=dao.insertToDb(updateProductQuery);
        try  {
        	ps.setInt(4, product.getId());
        	ps.setString(2, product.getDescription());
            ps.setInt(3, product.getProductQuantity());
            ps.setFloat(5,product.getProductPrice());
            ps.setString(6,product.getProductImagepath());
           

            ps.executeUpdate();
        }catch(Exception e) {
        	e.printStackTrace();
        }
        return product;
    }
 
 //Selecting all products for display
 public  List < Product > selectAllProducts() {

         List < Product > product = new ArrayList < > ();
         rs=dao.readfromDb(selectAllProductsQuery);
        
        try {
        	
            rs = ps.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String productType= rs.getString("productType");
                String description= rs.getString("description");
                int quantity = rs.getInt("productQuantity");
                float price=rs.getFloat("productPrice");
                String imagepath=rs.getString("productImagePath");
                product.add(new Product( productType, description,quantity,price,imagepath));
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return product;
    }
 //Search Implementation
 public List<Product> searchSelect(){
	 List<Product> searchedProduct=new ArrayList<>();
	 rs=dao.readfromDb(searchQuery);
	 //Find the Search Querry
	 
	 try {
		 String productType= rs.getString("productType");
         String description= rs.getString("description");
         int quantity = rs.getInt("productQuantity");
         float price=rs.getFloat("productPrice");
         String imagepath=rs.getString("productImagePath");
         searchedProduct.add(new Product( productType, description,quantity,price,imagepath));
		 
	 }catch(Exception ex) {
		 ex.printStackTrace();
	 }
	return searchedProduct;
 }
 
 //Deleting a product
    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDeleted =false;
        ps=dao.insertToDb(deleteproductQuery);
        try {
        	
            ps.setInt(1, id);
            rowDeleted =ps.executeUpdate() > 0;
        }catch(Exception e) {
        	e.printStackTrace();
        }
        return rowDeleted;
    }
    
}

