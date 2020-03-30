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
	private String selectAllQuery="select * from stage where programId=?";
	private String selectId="select id where stageName=? startTime=?,endtime=?";
	String all = "SELECT stage.stageName, event.eventDescription, stage.startTime, stage.endTime  FROM stage INNER JOIN event ON stage.stageid=?";
	
	ResultSet rs;
	PreparedStatement ps;
    Dao dao= new Dao();

	public StageDao() {
	}
	
		
	    public Stage saveStage(Stage stage){  
	    	Dao dao = new Dao();
	        Connection con = dao.connect();
	        
	       // ps=dao.insertToDb(insertQuerry);  
	        try{  
	             ps= con.prepareStatement(insertQuerry);
	            ps.setString(1,stage.getStageName());  
	            ps.setInt(2,stage.getStartTime());
	            ps.setInt(3,stage.getEndTime());
	           
	            
	            ps.executeUpdate();  
	              
	            
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return stage;  
	    } 
	    
	    public Stage updateStage(Stage stage){  
	    	Dao dao = new Dao();
	        Connection con = dao.connect();
	        
	      // ps=dao.insertToDb(UpdateQuery);  
	        try{  
	            ps= con.prepareStatement(UpdateQuery);
	            ps.setString(1,stage.getStageName());
	            ps.setInt(2,stage.getStartTime()); 
	            ps.setInt(3,stage.getEndTime());
	            ps.executeUpdate();  
	              
	            
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return stage;  
	    }  
	    public boolean delete(int id){  
	    	Dao dao = new Dao();
	        Connection con = dao.connect();
	        
	        boolean deleteRow=false;  
	       // ps=dao.insertToDb(deleteByIdQuery);
	        try{  
	            ps= con.prepareStatement(deleteByIdQuery);
	            
	            ps.setInt(1,id);  
	            deleteRow=ps.executeUpdate() >0;  
	              
	              
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return deleteRow;  
	    
	    }
	    public int getStageId (String stageName, int startTime,int endTime){  
	    	Dao dao = new Dao();
	        Connection con = dao.connect();
	        
			Stage stage= new Stage();
			//rs=dao.readfromDb(selectId);
			int stageId=0;
	       
	        try{  
	            ps=con.prepareStatement(selectId);
	            
	             rs=ps.executeQuery();  
	            if(rs.next()){ 
	            
	            	stageId=stage.setStageId(rs.getInt(1));
	            }  
	              
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return stageId; 
	    }
	    
	    
		public  Stage getStageById(int id){  
			Dao dao = new Dao();
	        Connection con = dao.connect();
	        
			Stage stage= new Stage();
			
	       
	        try{  
	            ps=con.prepareStatement(selectByIdQuery);
	            ps.setInt(1,id); 
	            
	             rs=ps.executeQuery();  
	            if(rs.next()){ 
	            	stage.setStageName(rs.getString(1));
	            	stage.setStartTime(rs.getInt(2));
	            	stage.setEndTime(rs.getInt(3));
	            }  
	              
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return stage;  
	    }  
		public  List<Stage> getAllStages(int programId){  
			
	        List<Stage> stageList=new ArrayList<>();  
	        
	        Dao dao = new Dao();
	        Connection con = dao.connect();
	          //rs=dao.readfromDb(selectAllQuery);
	        
	          
	        try{  
	        	ps = con.prepareStatement(selectAllQuery);
	        	
	        	ps.setInt(1,programId);  
	            rs=ps.executeQuery();  
	            System.out.println(rs);
	            while(rs.next()){  
	            	System.out.println("here");
	                Stage stage=new Stage(); 
	                
	                stage.setStageId(rs.getInt("stageId"));
	                stage.setStageName(rs.getString("stageName"));
	                stage.setStartTime(rs.getInt("startTime"));
	                stage.setEndTime(rs.getInt("endTime"));
	                stageList.add(stage);
	            }  
	              
	        }catch(Exception c){
	        	System.out.println("Error");
	        	//c.printStackTrace();
	        	}  
	          
	        return stageList;  
	    }  
		
	}


