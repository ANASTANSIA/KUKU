package com.chickenapp.database;

public class Program {
    int programId;
	String description;
	String programName;
	public Program() {
		super();

	}
	


	public Program(int programId, String description, String programName) {
		super();
		this.programId = programId;
		this.description = description;
		this.programName = programName;
	}



	public Program(String description, String programName) {
		super();
		this.description = description;
		this.programName = programName;
	}
	
	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description =description;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
	
	
}
