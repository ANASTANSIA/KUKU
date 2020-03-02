package com.chickenapp.database;

public class Stage {
	public String stageId;
	public String stageName;
	public int startTime;
	public int endTime;
	
	public Stage() {
		super();
		
	}

	public Stage(String stageName, int startTime, int endTime) {
		super();
		this.stageName = stageName;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Stage(String stageId, String stageName, int startTime, int endTime) {
		super();
		this.stageId = stageId;
		this.stageName = stageName;
		this.startTime = startTime;
		this.endTime = endTime;
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
	
	
	

}
