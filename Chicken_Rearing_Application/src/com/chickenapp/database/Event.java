package com.chickenapp.database;

public class Event {

	public String eventDescription;
	public int stageId;

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(String eventDescription) {
		super();
		this.eventDescription = eventDescription;
	}
	

	public int getStageId() {
		return stageId;
	}

	public void setStageId(int stageId) {
		this.stageId = stageId;
	}

	public Event(String eventDescription, int stageId) {
		// TODO Auto-generated constructor stub
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	
}
