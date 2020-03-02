package com.chickenapp.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chickenapp.database.Program;
import com.chickenapp.database.User;
import com.chickenapp.databaseDao.ProgramDao;
import com.chickenapp.databaseDao.UserDao;

/**
 * Servlet implementation class ProgramServlet
 */
@WebServlet("/ProgramServlet")
public class ProgramServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgramServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		String programName=request.getParameter("programName");
		String description=request.getParameter("description");
		
		ProgramDao programdao=new ProgramDao();
		Program program= new Program(programName, description);
		
		 try {
	              programdao.saveProgram(program);
	            String destPage = "login.jsp";
	           
	            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
	            dispatcher.forward(request, response);
	             
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	}

}
