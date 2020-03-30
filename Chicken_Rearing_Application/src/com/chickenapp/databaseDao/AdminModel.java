package com.chickenapp.databaseDao;

public class AdminModel {
	
	private  int programId;
    private String programDescription;
	private	String programName;
	
	private  String stageId;
	private  String stageName;
	private  int startTime;
	private  int endTime;
	
	private int eventId;
	private  String eventDescription;
	
	

	public AdminModel() {
		
	}
	



	public AdminModel(int programId, String programDescription, String programName, String stageId, String stageName,
			int startTime, int endTime, int eventId, String eventDescription) {
		super();
		this.programId = programId;
		this.programDescription = programDescription;
		this.programName = programName;
		this.stageId = stageId;
		this.stageName = stageName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.eventId = eventId;
		this.eventDescription = eventDescription;
	}
	




	public AdminModel(String programName, String stageId, String stageName, int startTime, int endTime, int eventId,
			String eventDescription) {
		super();
		this.programName = programName;
		this.stageId = stageId;
		this.stageName = stageName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.eventId = eventId;
		this.eventDescription = eventDescription;
	}
	




	public AdminModel(String programDescription, String programName, String stageName, int startTime, int endTime,
			String eventDescription) {
		super();
		this.programDescription = programDescription;
		this.programName = programName;
		this.stageName = stageName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.eventDescription = eventDescription;
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
		this.programDescription = programDescription;
	}



	public String getProgramName() {
		return programName;
	}



	public void setProgramName(String programName) {
		this.programName = programName;
	}



	public String getStageId() {
		return stageId;
	}



	public void setStageId(String stageId) {
		this.stageId = stageId;
	}



	public String getStageName() {
		return stageName;
	}



	public void setStageName(String stageName) {
		this.stageName = stageName;
	}



	public int getStartTime() {
		return startTime;
	}



	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}



	public int getEndTime() {
		return endTime;
	}



	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}



	public int getEventId() {
		return eventId;
	}



	public void setEventId(int eventId) {
		this.eventId = eventId;
	}



	public String getEventDescription() {
		return eventDescription;
	}



	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	
	
	

}
