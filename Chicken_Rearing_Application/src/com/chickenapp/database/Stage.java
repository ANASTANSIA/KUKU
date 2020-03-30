package com.chickenapp.database;

import java.io.Serializable;

public class Stage implements Serializable{
	public int stageId;
	public String stageName;
	public int startTime;
	public int endTime;
	private int programId;
	
	public Stage() {
		super();
		
	}

	public Stage(String stageName, int startTime, int endTime) {
		super();
		this.stageName = stageName;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Stage(int stageId, String stageName, int startTime, int endTime) {
		super();
		this.stageId = stageId;
		this.stageName = stageName;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Stage(String stageName, int startTime,int endTime, int programId) {
		super();
		this.stageName = stageName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.programId=programId;
		
	}

	public int getStageId() {
		return stageId;
	}

	public int setStageId(int stageId) {
		return this.stageId = stageId;
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
