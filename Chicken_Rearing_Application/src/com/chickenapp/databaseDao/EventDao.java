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
	String allEventsQuery="select * from event";
	
    public  Event saveEvent(Event event){  
        ps= dao.insertToDb(sql); 
        try{  
           
            ps.setString(1, event.getDescription());
            ps.executeUpdate();  
              
             
        }catch(Exception ex){ex.printStackTrace();}  
          
        return event;  
    } 
    
    public Event  update(Event event){  
        ps=dao.insertToDb(updateQuery); 
        try{ 
            ps.setString(1,event.getDescription());
          
            ps.executeUpdate();  
           
        }catch(Exception ex){ex.printStackTrace();}  
          
        return event;  
    }  
    public Event delete(int id){  
    	Event event=null;
         ps=dao.insertToDb(deleteQuery);
        try{   
            ps.setInt(1,id);  
           ps.executeUpdate();  
              
        
        }catch(Exception e){e.printStackTrace();}  
          
        
		return event;  
    
    }
    
    
	public  Event getEventById(int id){  
		Event event= new Event();  
		rs=dao.readfromDb(getEventQuery);
        try{   
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){ 
            	event.setDescription(rs.getString(1));
            }  
             
        }catch(Exception ex){ex.printStackTrace();
        System.out.println("Cant get the event");
        }  
          
        return event;  
    }  
    public  List<Event> getAllEvents(){  
        List<Event> eventList=new ArrayList<>(); 
        rs=dao.readfromDb(allEventsQuery);
          
        try{  
           
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	Event event= new Event();
            	event.setDescription(rs.getString(1));
                 
            }
        }catch(Exception c){
        	c.printStackTrace();
        	System.out.println("cant retrieve all events");
        	} 
          
        return eventList;  
    }  
	


}
