package com.chickenapp.database;

import java.io.Serializable;

public class Program implements Serializable{
    int programId;
	String programDescription;
	String programName;
	public Program() {
		
	}
	


	public Program(int programId, String programDescription, String programName) {
		super();
		this.programId = programId;
		this.programDescription = programDescription;
		this.programName = programName;
	}



	public Program(String programDescription, String programName) {
		super();
		this.programDescription = programDescription;
		this.programName = programName;
	}
	
	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}
	public String getProgramDescription() {
		return programDescription;
	}
	public void setProgramDescription(String programDescription) {
		this.programDescription =programDescription;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
	
	
}
