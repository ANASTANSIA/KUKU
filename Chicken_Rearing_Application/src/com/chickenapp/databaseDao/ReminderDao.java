package com.chickenapp.databaseDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chickenapp.database.DatabaseConnection;
import com.chickenapp.database.Event;
import com.chickenapp.database.ProgramSubscriptionReminder;

public class ReminderDao  {

    private String insertQuerry="insert into programsubscriptionReminder(currentStageDay,active) values (?,?)";
	private String UpdateQuery="update programsubscriptionReminder setcurrentStageDay=?,active=? where subscriptionId=?"; 
	private String deleteAllQuery="delete * from programsubscriptionReminder";
	private String deleteByIdQuery="delete from programsubscriptionReminder where subscriptionId=?";
	private String selectByIdQuery="select * from programsubscriptionReminder where subscriptionId=?";
	private String selectAllQuery="select * from programsubscriptionReminder ";
	
	ResultSet rs;
	PreparedStatement ps;
    ProgramSubscriptionReminder reminder= new ProgramSubscriptionReminder();
    Dao dao= new Dao();

	public ReminderDao() {
		
	}
	
	
    public  ProgramSubscriptionReminder saveReminder(ProgramSubscriptionReminder reminder){
        ps = dao.insertToDb(insertQuerry);  
         
        try{  
            ps.setInt(1, reminder.getCurrentStageDay());
            ps.setBoolean(1, reminder.isActive());
            ps.executeUpdate();  
              
             
        }catch(Exception ex){ex.printStackTrace();}  
          
        return reminder;  
    } 
    
    public ProgramSubscriptionReminder updateSubscription(ProgramSubscriptionReminder  reminder){  
         ps=dao.insertToDb(UpdateQuery);
        try{  
             
            ps.setInt(1,reminder.getCurrentStageDay());
            ps.setBoolean(2, reminder.isActive());
          
            ps.executeUpdate();  
              
            
        }catch(Exception ex){ex.printStackTrace();}  
          
        return reminder;  
    }  
    //Delete
    public boolean  delete(int id){  
       
        boolean deleteRow=false;
        try{  
              
            ps.setInt(1,id);  
            deleteRow=ps.executeUpdate()>0;  
              
              
        }catch(Exception e){e.printStackTrace();}  
          
        return deleteRow;  
    
    }
    
    //Retrieve By Id
	public ProgramSubscriptionReminder getReminderById(int id){  
		ProgramSubscriptionReminder reminder= new ProgramSubscriptionReminder(); 
		rs=dao.readfromDb(selectByIdQuery);
        try{  
            
            ps.setInt(1,id);  
            rs=ps.executeQuery();  
            if(rs.next()){ 
            	reminder.setCurrentStageDay(rs.getInt(1));
            	reminder.setActive(rs.getBoolean(2));
            }  
            
        }catch(Exception ex){ex.printStackTrace();}  
          
        return reminder;  
    } 

	
	//Retrieve all
    public  List<ProgramSubscriptionReminder> getAllEvents(){  
        List<ProgramSubscriptionReminder> reminderList=new ArrayList<>();
        rs=dao.readfromDb(selectAllQuery);
          
        try{  
              
            rs=ps.executeQuery();  
            while(rs.next()){  
            	ProgramSubscriptionReminder reminder = new ProgramSubscriptionReminder();
            	reminder.setCurrentStageDay(rs.getInt(1));
            	reminder.setActive(rs.getBoolean(2));
            	
                
            }
        }catch(Exception c){
        	c.printStackTrace();
        	} 
          
        return reminderList;  
    }  
    
	//Delete by id
	public boolean deleteReminder(int id) {
		boolean deleteRow=false;
		ps=dao.insertToDb(deleteByIdQuery);
		try {
		    
            ps.setInt(1,id);  
           deleteRow= ps.executeUpdate()>0;  
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	    
		return deleteRow;
		
	}
	

	
	

}
