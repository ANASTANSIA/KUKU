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

import com.chickenapp.database.Event;
import com.chickenapp.database.Program;
import com.chickenapp.databaseDao.EventDao;

/**
 * Servlet implementation class DisplayStage
 */
@WebServlet("/DisplayStage")
public class DisplayStage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		//out.print(id);
		
		EventDao dao = new EventDao();
		//List<Event> records = dao.getAllEvents(stageId);
		
		HttpSession  session=request.getSession();
		int stageId=(int) session.getAttribute("stageId");
		//out.print(stageId);
	
		List<Event> eventList = dao.getAllEvents(stageId);
		//out.print(eventList);

		HttpSession session1 = request.getSession();
		session.setAttribute("eventList", eventList);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewPrograms.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
