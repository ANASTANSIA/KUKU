package com.chickenapp.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		String programName=request.getParameter("programName");
		String programDescription=request.getParameter("programDescription");
		
		//System.out.println(programName);
        //System.out.println(programDescription);
		
		ProgramDao programdao=new ProgramDao();
		Program program= new Program(programName, programDescription);
		
		 try {
	              programdao.saveProgram(program);

	      	
	              System.out.println("nice it worked");
					response.sendRedirect("viewPrograms.jsp");
				
	             
	        } catch (Exception ex) {
	        	//System.out.println("Program Sservlet not working");
	            ex.printStackTrace();
	        }
		
	
	}
}

	
//	private void addToDb(HttpServletRequest request, HttpServletResponse response) {
//		String programName=request.getParameter("programName");
//		String programDescription=request.getParameter("programDescription");
//		
//		//System.out.println(programName);
//        //System.out.println(programDescription);
//		
//		ProgramDao programdao=new ProgramDao();
//		Program program= new Program(programName, programDescription);
//		
//		 try {
//	              programdao.saveProgram(program);
//
//	      	
//	              System.out.println("nice it worked");
//					response.sendRedirect("advertisedProducts.html");
//				
//	             
//	        } catch (Exception ex) {
//	        	System.out.println("Program Sservlet not working");
//	            ex.printStackTrace();
//	        }
//		
	
//	private List<Program> retrieveFromDb(HttpServletRequest request, HttpServletResponse response) {
//		ProgramDao programdao=new ProgramDao();
//		List<Program> programList=programdao.getAllPrograms();
//		//Program program= new Program(programName, programDescription);
//		
//		try {
//	   
//		HttpSession session= request.getSession();
//		 session.setAttribute("programList", programList);
//			response.sendRedirect("AdminMainIndex.jsp");
//			
//			
//		}catch(Exception ex) {
//			ex.printStackTrace();
//			System.out.println("Cannot retrieve the programs from database");
//			
//		}
//		return programList;
//		
//	}


