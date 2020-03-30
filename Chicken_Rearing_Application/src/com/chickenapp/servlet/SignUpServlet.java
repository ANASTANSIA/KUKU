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
			//response.sendRedirect("SignUp.jsp");
			System.out.println("please enter username and password");
		}else {
			
			User user=new User(username,email,password);
			
			UserDao accessor=new UserDao();
			
			try {
				accessor.saveUser(user);
				System.out.println("nice it worked");
				//response.sendRedirect("manageChicken.html");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
		
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

}
