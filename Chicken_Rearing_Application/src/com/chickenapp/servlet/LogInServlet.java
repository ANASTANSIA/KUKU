package com.chickenapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chickenapp.database.User;
import com.chickenapp.databaseDao.UserDao;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LogInServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
			String username1=request.getParameter("username");
			String password1=request.getParameter("password");
			String role1=request.getParameter("role");
			String password="";
			String username="";
			System.out.println(role1);
			
			User user= new User();
			user.setUsername(username1);
			user.setPassword(password1);
			
			UserDao userdao=new UserDao();
			try {
				String userValidate=userdao.checkLogin(username, password);
				if(userValidate.equals("admin")){
					HttpSession session = request.getSession(); //Creating a session
					session.setAttribute("Admin", username1); //setting session attribute
					request.setAttribute("username", username1);

					request.getRequestDispatcher("AdminMainIndex.jsp").forward(request, response);
				}else if(userValidate.equals("User"))
				{
					System.out.println("User's Home");

					HttpSession session = request.getSession();
					session.setAttribute("user", username);
					request.setAttribute("username", username);

				
				request.getRequestDispatcher("manageChicken.jsp").forward(request, response);
				}
				else
				{
					System.out.println("Error message = "+userValidate);
					request.setAttribute("errMessage", userValidate);

					request.getRequestDispatcher("index.html").forward(request, response);
				}
					
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Cannot LogIn");
			}
//			
//			 try {
//		            Boolean user = userdao.checkLogin(username1, password1);
//		            String destPage = "index.html";
//		             
//		            if (user!=null && username1.equals("Herod") && password1.equals("herodEncrypted12345") && role1.equals("admin")){
//		                HttpSession session = request.getSession();
//		                session.setAttribute("user", user);
//		                destPage = "AdminMainIndex.jsp";
//		            } else if(role1=="User"){
//		            	
//		            	HttpSession session = request.getSession();
//		                session.setAttribute("user", user);
//		                destPage = "productPage.jsp";
//		            }else {
//		                String message = "Invalid email/password";
//		                request.setAttribute("message", message);
//		            }
//		             
//		            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
//		            dispatcher.forward(request, response);
//		             
//		        } catch (Exception ex) {
//		            ex.printStackTrace();
//		        }
		
	
	
	}

}
