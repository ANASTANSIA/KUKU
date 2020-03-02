package com.chickenapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public interface DatabaseConnection {
	
	    static String url="jdbc:mysql://localhost:3306/chicken_rearing_application";
		static String username="anastansia";
		static String password="herod7915";
		static Connection conn=null;
	}
	
	
	


