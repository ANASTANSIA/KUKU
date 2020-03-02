package com.chickenapp.databaseDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chickenapp.database.*;

public class UserDao {
	
	private ResultSet rs;
	private static PreparedStatement ps;
	Dao dao = new Dao();
	User user = new User();
	String sql = "insert into user(username ,email,password) values(?,?,?)";
	String LogInQuery="SELECT * FROM user WHERE email = ? and password = ?";

	public User saveUser(User user) throws ClassNotFoundException {
		
		ps = dao.insertToDb(sql);

		try {
			
	            ps.setString(1,user.getUsername());  
	            ps.setString(2,user.getEmail());  
	            ps.setString(3,user.getPassword());
	           // ps.setString(4,user.getRole());
	            ps.executeUpdate();  
	              
	            
	        }catch(Exception ex){ex.printStackTrace();}  
	          
			return user; 
			
	    }
	public User checkLogin(String username ,String password) {
		rs=dao.readfromDb(LogInQuery);
		
		try {
			
			ps.setString(1, username);
	        ps.setString(2, password);
	 
	        rs = ps.executeQuery();
	 
	        User user = null;
	 
	        if (rs.next()) {
	            user = new User();
	            user.setUsername(rs.getString(2));
	            user.setPassword(rs.getString(3));
	            
	            
	        }
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Cannot retrieve the email and password");
		}
		
		
		return user;
		
	}
	
	 


}
