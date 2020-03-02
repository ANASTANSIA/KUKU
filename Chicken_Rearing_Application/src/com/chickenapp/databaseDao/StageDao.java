package com.chickenapp.databaseDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chickenapp.database.DatabaseConnection;
import com.chickenapp.database.ProgramSubscriptionReminder;
import com.chickenapp.database.Stage;

public class StageDao{

    private String insertQuerry="insert into stage (stageName,startTime,endTime) values (?,?,?)";
	private String UpdateQuery="update stage set stageName=?, startTime=? ,endTime=? where id=?";
	private String deleteAllQuery="delete * from stage";
	private String deleteByIdQuery="delete from stage where stageId=?";
	private String selectByIdQuery="select * from stage where stageId=?";
	private String selectAllQuery="select * from stage ";
	
	ResultSet rs;
	PreparedStatement ps;
    Dao dao= new Dao();

	public StageDao() {
	}
	
		
	    public Stage saveStage(Stage stage){  
	        ps=dao.insertToDb(insertQuerry);  
	        try{  
	             
	            ps.setString(1,stage.getStageName());  
	            ps.setInt(2,stage.getStartTime());
	            ps.setInt(3,stage.getEndTime());
	            
	            ps.executeUpdate();  
	              
	            
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return stage;  
	    } 
	    
	    public Stage updateStage(Stage stage){  
	       ps=dao.insertToDb(UpdateQuery);  
	        try{  
	          
	            ps.setString(1,stage.getStageName());
	            ps.setInt(2,stage.getStartTime()); 
	            ps.setInt(3,stage.getEndTime());
	            ps.executeUpdate();  
	              
	            
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return stage;  
	    }  
	    public boolean delete(int id){  
	        boolean deleteRow=false;  
	        ps=dao.insertToDb(deleteByIdQuery);
	        try{  
	            
	            ps.setInt(1,id);  
	            deleteRow=ps.executeUpdate() >0;  
	              
	              
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return deleteRow;  
	    
	    }
	    
	    
		public  Stage getStageById(int id){  
			Stage stage= new Stage();
			rs=dao.readfromDb(selectByIdQuery);
	       
	        try{  
	            
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){ 
	            	stage.setStageName(rs.getString(1));
	            	stage.setStartTime(rs.getInt(2));
	            	stage.setEndTime(rs.getInt(3));
	            }  
	              
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return stage;  
	    }  
	    public  List<Stage> getAllStages(){  
	        List<Stage> stageList=new ArrayList<>();  
	          rs=dao.readfromDb(selectAllQuery);
	        try{  
	             
	            rs=ps.executeQuery();  
	            while(rs.next()){  
	                Stage stage=new Stage(); 
	                stage.setStageName(rs.getString(1));
	                stage.setStartTime(rs.getInt(2));
	                stage.setEndTime(rs.getInt(3));
	                stageList.add(stage);
	                
	            }  
	              
	        }catch(Exception c){c.printStackTrace();}  
	          
	        return stageList;  
	    }  
		
	}


