package com.chickenapp.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBTest implements DatabaseConnection {
	
	public static Connection getConnection(){  
        Connection conn=null;  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            
            conn=DriverManager.getConnection(url, username, password); 
            //System.out.println("Connection Successful");
        }catch(Exception e){System.out.println("DB connection failed " + e);}  
        return conn;
    }  
	 public static void main(String args[]){
		 DBTest.getConnection();
    }
	

	

//public static Connection createConnection(){
//        
//     String url="jdbc:mysql://localhost:3306/chicken_rearing_application";
//	 String username="anastansia";
//	 String password="herod7915";
//	 Connection con=null;
//        
//        try {
//            
//            try {
//                Class.forName("com.mysql.cj.jdbc.Driver");
//               
//            } catch (Exception e) {
//                System.out.println("error");
//            }
//            con = DriverManager.getConnection(url,username,password);
//        } catch (Exception e) {
//        }
//        return con;
//    }
//    public static void main(String args[]){
//    	DBTest.createConnection();
//    }

}
