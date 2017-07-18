package com.eltiempo.rest.eltiempospring;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.technical.controller.AlarmController;

public class AlarmControllerTest {

	AlarmController alarmController = new AlarmController();

	@Test
	public void correctPerformanceInitial() throws InterruptedException {
		assertTrue(alarmController.executeAlarm("ON", "Device1") == 0L);
		assertTrue(alarmController.executeAlarm("ON", "Device2") == 0L);
		assertTrue(alarmController.executeAlarm("OFF", "Device1") > 0L);
		assertTrue(alarmController.executeAlarm("OFF", "Device2") > 0L);
	}

	@Test
	public void correctPerformanceExtend() {
		assertTrue(alarmController.executeAlarm("ON", "Device1") == 0L);
		assertTrue(alarmController.executeAlarm("ON", "Device2") == 0L);
		assertTrue(alarmController.executeAlarm("OFF", "Device1") > 0L);
		assertTrue(alarmController.executeAlarm("OFF", "Device1") == 0L);
		assertTrue(alarmController.executeAlarm("ON", "Device1") == 0L);
		assertTrue(alarmController.executeAlarm("OFF", "Device1") > 0L);
		assertTrue(alarmController.executeAlarm("OFF", "Device2") > 0L);
	}

}
