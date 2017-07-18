package com.technical.utils;

public enum AlarmState {
	ON("ON"),	OFF("OFF");
	
	
	private String state;
	
	AlarmState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
