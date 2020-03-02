package com.chickenapp.database;

public class ProgramSubscriptionReminder {
	int currentStageDay;
	boolean active;
	
	public ProgramSubscriptionReminder() {
		super();
		
	}

	public ProgramSubscriptionReminder(int currentStageDay, boolean active) {
		super();
		this.currentStageDay = currentStageDay;
		this.active = active;
	}

	public int getCurrentStageDay() {
		return currentStageDay;
	}

	public void setCurrentStageDay(int currentStageDay) {
		this.currentStageDay = currentStageDay;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
	
 
}
