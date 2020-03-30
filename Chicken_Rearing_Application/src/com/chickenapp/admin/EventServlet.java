package com.chickenapp.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chickenapp.database.Event;
import com.chickenapp.database.Stage;
import com.chickenapp.databaseDao.EventDao;
import com.chickenapp.databaseDao.StageDao;

/**
 * Servlet implementation class EventServlet
 */
@WebServlet("/EventServlet")
public class EventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EventServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String stageName=request.getParameter("stageName");
		int startTime=Integer.parseInt(request.getParameter("startTime"));
		int endTime=Integer.parseInt(request.getParameter("endTime"));
			
		String eventDescription=request.getParameter("eventDescription");
		
		Event newevent = new Event(eventDescription);
		EventDao eventDao= new EventDao();
		StageDao stagedao= new StageDao();
		
		
		try {
			int stageId=stagedao.getStageId(stageName, startTime, endTime);
			
			
			Event event = new Event(eventDescription,stageId);
			
			eventDao.saveEvent(event);
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Cannot add an event in servlet");
		}
		
		
	}

}
