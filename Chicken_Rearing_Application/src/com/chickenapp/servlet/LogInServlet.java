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
	
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			UserDao userdao=new UserDao();
			
			 try {
		            User user = userdao.checkLogin(username, password);
		            String destPage = "login.jsp";
		             
		            if (user != null) {
		                HttpSession session = request.getSession();
		                session.setAttribute("user", user);
		                destPage = "productlanding.jsp";
		            } else {
		                String message = "Invalid email/password";
		                request.setAttribute("message", message);
		            }
		             
		            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
		            dispatcher.forward(request, response);
		             
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		}
	
	
	

}
