package com.chickenapp.databaseDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chickenapp.database.DatabaseConnection;
import com.chickenapp.database.Event;
import com.chickenapp.database.Program;
import com.chickenapp.database.Stage;
import com.chickenapp.database.User;

public class EventDao  {

	public EventDao() {
		
	}
	private ResultSet rs;
	private static PreparedStatement ps;
	Dao dao = new Dao();
	User user = new User();
	String sql = "insert into event(description) values (?)";
	String updateQuery="update event set description=? where id=?";
	String deleteQuery="delete from event where eventId=?";
	String getEventQuery=  "select * from event where eventId=?";
	String allEventsQuery="select * from event where stageId=?";
	
    public  Event saveEvent(Event event){  
    	Dao dao = new Dao();
        Connection con = dao.connect();
        
        try{  
           ps=con.prepareStatement(sql);
            ps.setString(1, event.getEventDescription());
            ps.executeUpdate();  
              
             
        }catch(Exception ex){ex.printStackTrace();}  
          
        return event;  
    } 
    
    public Event  update(Event event){  
    	
    	Dao dao = new Dao();
        Connection con = dao.connect();
        
       
        try{ 
        	ps = con.prepareStatement(updateQuery);
            ps.setString(1,event.getEventDescription());
          
            ps.executeUpdate();  
           
        }catch(Exception ex){ex.printStackTrace();}  
          
        return event;  
    }  
    public Event delete(int id){  
    	Event event=null;
    	Dao dao = new Dao();
        Connection con = dao.connect();
        
    	
        //ps=dao.insertToDb(deleteQuery);
        try{ 
        	ps=con.prepareStatement(deleteQuery);
            ps.setInt(1,id);  
           ps.executeUpdate();  
              
        
        }catch(Exception e){e.printStackTrace();}  
          
        
		return event;  
    
    }
    
    
	public  Event getEventById(int id){  
		Event event= new Event(); 

        Dao dao = new Dao();
        Connection con = dao.connect();
		
        try{   
        	ps = con.prepareStatement(getEventQuery);
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){ 
            	event.setEventDescription(rs.getString(1));
            }  
             
        }catch(Exception ex){ex.printStackTrace();
        System.out.println("Cant get the event");
        }  
          
        return event;  
    }  
   
    public  List<Event> getAllEvents(int stageId){  
        List<Event> eventList=new ArrayList<>();  
        
        Dao dao = new Dao();
        Connection con = dao.connect();
          //rs=dao.readfromDb(selectAllQuery);
        
          
        try{  
        	ps = con.prepareStatement(allEventsQuery);
        	ps.setInt(1,stageId);  
            rs=ps.executeQuery();  
            //System.out.println(programId);
            while(rs.next()){  
                Event event = new Event(); 
                event.setEventDescription(rs.getString("eventDescription"));
                eventList.add(event);
            }  
              
        }catch(Exception c){
        	//System.out.println("Error");
        	c.printStackTrace();
        	}  
          
        return eventList;  
    }  
	


}
