package com.chickenapp.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chickenapp.database.Program;
import com.chickenapp.databaseDao.ProgramDao;



/**
 * Servlet implementation class DisplayProgramServlet
 */
@WebServlet("/DisplayProgramServlet")
public class DisplayProgramServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayProgramServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProgramDao programdao=new ProgramDao();
		List<Program> programList=programdao.getAllPrograms();
		
		PrintWriter out = response.getWriter();
		//Program program= new Program(programName, programDescription);
		
		try {
	   
		HttpSession session= request.getSession();
		 session.setAttribute("programList", programList);
		 
		 for (Program program : programList) {
			 
			 System.out.println(program.getProgramName());
			
		}
			response.sendRedirect("viewPrograms.jsp");
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Cannot retrieve the programs from database");
			
		}
	}

}
