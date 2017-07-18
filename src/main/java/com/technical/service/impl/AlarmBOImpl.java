package com.technical.service.impl;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import com.technical.model.Alarms;
import com.technical.service.AlarmBO;

@Service
public class AlarmBOImpl implements AlarmBO,Serializable {

	private static final long serialVersionUID = 1L;

	Alarms alarms = Alarms.getSingletonInstance();
	
	@Override
	public Boolean turnUpAlarm(String alarm) {
		return alarms.turnUpAlarm(alarm);
	}

	@Override
	public Long turnOffAlarm(String alarm) {
		return alarms.turnOffAlarm(alarm);
	}
	
	
}
