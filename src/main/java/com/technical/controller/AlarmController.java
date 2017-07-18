package com.technical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technical.service.AlarmBO;
import com.technical.service.impl.AlarmBOImpl;
import com.technical.utils.AlarmState;

@RestController
public class AlarmController {

	@Autowired
	AlarmBO alarmBO = new AlarmBOImpl();

	@RequestMapping("/executeAlarm")
	@CrossOrigin("*")
	public synchronized Long executeAlarm(@PathVariable("state") String state, @PathVariable("alarm") String alarm) {
		Long result = 0L;

		if (AlarmState.ON.getState().equals(state)) {
			alarmBO.turnUpAlarm(alarm);
		} else if (AlarmState.OFF.getState().equals(state)) {
			result = alarmBO.turnOffAlarm(alarm);
		}

		return result;
	}

}
