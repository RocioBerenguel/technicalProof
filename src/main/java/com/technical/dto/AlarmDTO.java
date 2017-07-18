package com.technical.dto;

import java.util.Date;

import com.technical.utils.AlarmState;

public class AlarmDTO {

	private String name;

	private AlarmState state;
	
	private Date dateOn;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AlarmState getState() {
		return state;
	}

	public void setState(AlarmState state) {
		this.state = state;
	}

	public Date getDateOn() {
		return dateOn;
	}

	public void setDateOn(Date dateOn) {
		this.dateOn = dateOn;
	}
	
	

}
