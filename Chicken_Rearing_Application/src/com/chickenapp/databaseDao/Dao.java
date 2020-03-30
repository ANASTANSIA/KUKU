package com.chickenapp.databaseDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dao {

	private String url="jdbc:mysql://localhost:3306/chicken_rearing_application";
	private String Username="anastansia";
	private String password="herod7915";
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	private Statement st;
	
	public Connection connect() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,Username,password);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public PreparedStatement insertToDb(String sql) {
		con=connect();
		try {
			
			stmt=con.prepareStatement(sql);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return stmt;
	}
	
	public ResultSet readfromDb(String sql) {
		
		con=connect();
		
		try {
			
			st=con.createStatement();
//			rs=st.executeQuery(sql);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return rs;
		
	}
}
