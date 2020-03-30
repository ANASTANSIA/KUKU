package com.chickenapp.databaseDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chickenapp.database.DatabaseConnection;
import com.chickenapp.database.Program;

public class ProgramDao {
	private String insertQuery="insert into program (programName,programDescription) values (?,?)";
	private String UpdateQuery="update program set programName=?,programDescription=? where programId=?"; 
	private String deleteAllQuery="delete * from program";
	private String deleteByIdQuery="delete from product where programId=?";
	private String selectByIdQuery="select * from program where programId=?";
	private String selectByIdQuery2="select programId from program where programName=?";
	private String selectAllQuery="select * from program";
	
	
	ResultSet rs;
	PreparedStatement ps;
	Dao dao= new Dao();
	
	

	public ProgramDao() {
		
	}
		
    public Program saveProgram(Program program){  
        ps=dao.insertToDb(insertQuery);  
        try{  
            
            ps.setString(1,program.getProgramName());  
            
            ps.setString(2,program.getProgramDescription()); 
          //  System.out.println(program.getProgramDescription()+" descriptor");
            
             
            
            ps.executeUpdate();  
              
             
        }catch(Exception ex){
        	System.out.println("Cant create a program");
        	ex.printStackTrace();}  
          
        return program;  
    } 
    
    public Program updateProgram(Program program){  
    	ps=dao.insertToDb(UpdateQuery);
          
        try{  

            ps.setString(1,program.getProgramName());
            ps.setString(2,program.getProgramDescription());  
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
    
    
	public int getProgramId(String programName){  
        Program program=new Program();  
        int programId=0;
          rs=dao.readfromDb(selectByIdQuery2);
        try{  
             
            //rs.executeQuery();  
            if(rs.next()){  
            	program.setProgramId(rs.getInt(1));
//            	program.setProgramDescription(rs.getString(2));
            	  
               
            }   }catch(Exception ex){ex.printStackTrace();}  
        
      return programId;  
  }  
	 
            public int getProgramById(){  
                Program program=new Program(); 
                int programId=0;
                  rs=dao.readfromDb(selectByIdQuery2);
                try{  
                     
                    //rs.executeQuery();  
                    if(rs.next()){  
                    	programId = rs.getInt("programId");
//                    	program.setProgramDescription(rs.getString(2));
                    	  
                       
                    }   }catch(Exception ex){ex.printStackTrace();}  
                
                return programId;  
            }  
        	
            
      
	public List<Integer> getprogramId(){
		List<Integer> idList= new ArrayList<>();
		rs=dao.readfromDb(selectAllQuery);
		try{  
            
	           rs=ps.executeQuery();  
	            while(rs.next()){  
	                Program program=new Program(); 
	                program.setProgramName(rs.getString(1));
	                program.setProgramDescription(rs.getString(2));
	                idList.add(rs.getInt(0));  
	            } 
		}catch(Exception ex) {
	            	ex.printStackTrace();
	            }
		
		return idList;
		
	}
    public  List<Program> getAllPrograms(){  
        List<Program> programList=new ArrayList<>(); 
        Dao dao = new Dao();
        Connection con = dao.connect();
        //rs=dao.readfromDb(selectAllQuery);
          //System.out.println(rs);
        try{  
           ps = con.prepareStatement(selectAllQuery);
           //dao.insertToDb(selectAllQuery);
           rs=ps.executeQuery(); 
            while(rs.next()){  
                Program program=new Program(); 
                program.setProgramId(rs.getInt("programId"));
                program.setProgramName(rs.getString("programName"));
                program.setProgramDescription(rs.getString("programDescription"));
                programList.add(program);  
            }  
              
        }catch(Exception c){
        	//System.out.println("Error");
        	c.printStackTrace();
        	}  
          
        return programList;  
    }  
    
	

}
