package com.chickenapp.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chickenapp.database.Program;
import com.chickenapp.database.Stage;
import com.chickenapp.databaseDao.ProgramDao;
import com.chickenapp.databaseDao.StageDao;

/**
 * Servlet implementation class StageServlet
 */
@WebServlet("/StageServlet")
public class StageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StageServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String stageName= request.getParameter("stageName");
		int startTime=Integer.parseInt(request.getParameter("startTime"));
		int endTime = Integer.parseInt(request.getParameter("endTime"));
		
		
//		int programId = (int)request.getSession().getAttribute("latest");
		
       
//		int programId = Integer.parseInt(p);
		//System.out.println(programId);
		
		StageDao stagedao= new StageDao();
		
		Program program=new Program();
		ProgramDao programdao=new ProgramDao();
		
		int programId=program.getProgramId();
		String programIds=Integer.toString(programId);
		HttpSession session=request.getSession();
		
		session.setAttribute("programIds",programId);
		System.out.println(programId);
		
		
		
		
		try {
			
		
			Stage stage= new Stage(stageName,startTime,endTime,programId);
			
            stagedao.saveStage(stage);
            
            System.out.println("nice it worked");
				response.sendRedirect("AdminMainIndex.jsp");
			
           
      } catch (Exception ex) {
    	  System.out.println("Cant add a stage in StageServlet");
          ex.printStackTrace();
      }
		
	}

}
