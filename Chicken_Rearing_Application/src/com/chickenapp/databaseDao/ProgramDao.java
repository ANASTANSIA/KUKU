package com.chickenapp.databaseDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chickenapp.database.DatabaseConnection;
import com.chickenapp.database.Program;

public class ProgramDao implements DatabaseConnection{
	private String insertQuery="insert into program (programName,description) values (?,?)";
	private String UpdateQuery="update program set programName=?,description=? where programId=?"; 
	private String deleteAllQuery="delete * from program";
	private String deleteByIdQuery="delete from product where programId=?";
	private String selectByIdQuery="select * from program where programId=?";
	private String selectAllQuery="select * from program ";
	
	ResultSet rs;
	PreparedStatement ps;
	Dao dao= new Dao();
	
	

	public ProgramDao() {
		
	}
		
    public Program saveProgram(Program program){  
        ps=dao.insertToDb(insertQuery);  
        try{  
            
            ps.setString(1,program.getProgramName());  
            ps.setString(2,program.getDescription());  
            
            ps.executeUpdate();  
              
             
        }catch(Exception ex){ex.printStackTrace();}  
          
        return program;  
    } 
    
    public Program updateProgram(Program program){  
    	ps=dao.insertToDb(UpdateQuery);
          
        try{  

            ps.setString(1,program.getProgramName());
            ps.setString(2,program.getDescription());  
            ps.executeUpdate();  
              
              
        }catch(Exception ex){ex.printStackTrace();}  
          
        return program;  
    }  
    public boolean delete(int id){  
    	boolean deleteRow=false;
        ps=dao.insertToDb(deleteByIdQuery);  
        
        try{  
            
            ps.setInt(1,id);  
           deleteRow= ps.executeUpdate()>0;  
              
             
        }catch(Exception e){e.printStackTrace();}  
          
        return deleteRow;  
    
    }
    
    
	public Program getProgramById(int id){  
        Program program=new Program();  
          rs=dao.readfromDb(selectByIdQuery);
        try{  
             
            ps.setInt(1,id);  
            rs=ps.executeQuery();  
            if(rs.next()){  
            	program.setProgramName(rs.getString(1));
            	program.setDescription(rs.getString(2));
            	  
               
            }  
            
        }catch(Exception ex){ex.printStackTrace();}  
          
        return program;  
    }  
    public  List<Program> getAllPrograms(){  
        List<Program> programList=new ArrayList<>(); 
        rs=dao.readfromDb(selectAllQuery);
          
        try{  
             
           rs=ps.executeQuery();  
            while(rs.next()){  
                Program program=new Program(); 
                program.setProgramName(rs.getString(1));
                program.setDescription(rs.getString(2));
                programList.add(program);  
            }  
              
        }catch(Exception c){c.printStackTrace();}  
          
        return programList;  
    }  
	

}
