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
	String LogInQuery="SELECT * FROM user WHERE username=? and password=?";
	String CountUsers="Select COUNT(*) from user";
	
//Count number of Users
	public void countUsers() {
		//int totalSignUps=0;
		rs=dao.readfromDb(CountUsers);
		
		
	}

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
	public boolean checkLoginO(String username ,String password) {
		//rs=dao.readfromDb(LogInQuery);
		
		//System.out.println(username+password);
		Dao dao = new Dao();
        Connection con = dao.connect();
		try {
			ps = con.prepareStatement(LogInQuery);
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
	        if(rs.next()) {
	        	return true;
	        }else {
	        	return false;
	        }
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Cannot retrieve the email and password");
		}
		
		
		return true;
		
	}
	public String checkLogin(String username ,String password) {
		//rs=dao.readfromDb(LogInQuery);

		String userNameDB = "";
		String passwordDB = "";
		
		Dao dao = new Dao();
        Connection con = dao.connect();
		try {
			ps = con.prepareStatement(LogInQuery);
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			while(rs.next()) {
			
			userNameDB = rs.getString("username");
			passwordDB =rs.getString("password");
			//roleDB = resultSet.getString("role");
			if(username.equals("Herod") && password.equals("herodEncrypted12345")) {
				return "admin";
			}
			if(username.equals(userNameDB)&& password.equals(passwordDB)) {
				return "User";
			}
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Invalid User Credential";
	}
	 
	 


}
