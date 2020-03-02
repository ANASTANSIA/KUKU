package com.chickenapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.chickenapp.database.User;
import com.chickenapp.databaseDao.UserDao;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet( description = "A sign In servlet", urlPatterns = { "/SignUpServlet" })
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SignUpServlet() {
       
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String password= request.getParameter("password");
		String confirmPassword=request.getParameter("confirmPassword");
		
		

		if(username.length()==0||username==""||(password.length()==0 && password != confirmPassword)||password=="") {
			//response.sendRedirect("");
			response.sendRedirect("SignUp.jsp");
			System.out.println("please enter username and password");
		}else {
			
			User user=new User(username,email,password);
			
			UserDao accessor=new UserDao();
			
			try {
				accessor.saveUser(user);
				System.out.println("nice it worked");
				response.sendRedirect("productlanding.jsp");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		//User user= new User(username,email,password,role);
//		
//		//PrintWriter out = response.getWriter();
//		//out.print(username+email);
//		System.out.println(email);
//		
//		User user=new User();
//		user.setUsername(username);
//		user.setEmail(email);
//		user.setPassword(password);
		

	
		
//		try {
//			//UserDao.saveUser(user);
//			 int saveStatus=UserDao.saveUser(user);
//			
//			//check whether the operation is successful and redirect to page.
//			
//			if(saveStatus>0) {
//				    System.out.println("Successful Registration");
//		            response.sendRedirect("/Productlanding.jsp");
//			}else {
//				System.out.println("Unable to Sign up");
//				
//				
//			}
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

}
