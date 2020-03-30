package com.chickenapp.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chickenapp.database.Stage;
import com.chickenapp.databaseDao.StageDao;

/**
 * Servlet implementation class DisplayEvents
 */
@WebServlet("/DisplayEvents")
public class DisplayEvents extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("programId"));
		PrintWriter out = response.getWriter();
		//out.print(id);
		int stageId=0;
		StageDao dao = new StageDao();
		List<Stage> show = dao.getAllStages(id);
		for (Stage stage : show) {
			
			 stageId=stage.getStageId();
			 
			//out.print(stageId);
		}
		 
		int rowspan=show.size();
		HttpSession session1=request.getSession();
		session1.setAttribute("stageId", stageId);
		
		
		out.print(show );
		HttpSession session = request.getSession();
		session.setAttribute("show", show);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DisplayStage");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
