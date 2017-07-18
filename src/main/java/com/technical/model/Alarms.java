package com.technical.model;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.technical.dto.AlarmDTO;
import com.technical.utils.AlarmState;

public class Alarms {

	private static Alarms alarms;

	private Map<String, AlarmDTO> alarmMap;

	private Alarms() {
		alarmMap = Collections.synchronizedMap(new HashMap<String, AlarmDTO>());
	}

	public static Alarms getSingletonInstance() {
		if (alarms == null) {
			alarms = new Alarms();
		}
		return alarms;
	}

	@Override
	public Alarms clone() {
		try {
			throw new CloneNotSupportedException();
		} catch (CloneNotSupportedException ex) {
			System.out.println("It is not possible to clone an Alarms object");
		}
		return null;
	}

	public synchronized Boolean turnUpAlarm(String alarm) {
			AlarmDTO alarmDto = alarmMap.get(alarm);

			if (alarmDto == null || AlarmState.OFF.equals(alarmDto.getState())) {
				alarmDto = new AlarmDTO();
				alarmDto.setDateOn(new Date());
				alarmDto.setName(alarm);
				alarmDto.setState(AlarmState.ON);
				alarmMap.put(alarm, alarmDto);
			}

		return true;
	}

	public synchronized Long turnOffAlarm(String alarm) {
		Long timeResult = 0L;
			AlarmDTO alarmDto = alarmMap.get(alarm);

			if (alarmDto.getName().equals(alarm) && alarmDto.getState().equals(AlarmState.ON)) {
				Date actualDate = new Date();
				timeResult = actualDate.getTime()+1 - alarmDto.getDateOn().getTime();

				alarmDto.setState(AlarmState.OFF);
				alarmDto.setDateOn(null);
				alarmMap.put(alarm, alarmDto);
			}

		return timeResult;
	}
}
