package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static fr.inria.phoenix.diasuite.framework.mocks.Mock.shutdown;
import static fr.inria.phoenix.diasuite.framework.mocks.Mock.underTest;

import fr.inria.phoenix.diasuite.framework.datatype.date.Date;
import fr.inria.phoenix.diasuite.framework.datatype.interaction.Interaction;
import fr.inria.phoenix.diasuite.framework.datatype.interactiontype.InteractionType;
import fr.inria.phoenix.diasuite.framework.mocks.InactivitySensorMock;
import fr.inria.phoenix.diasuite.framework.mocks.Mock;
import fr.inria.phoenix.diasuite.framework.mocks.TimerMock;
import fr.inria.phoenix.scenario.aleirbgenerale.controller.HandleTimer;
import fr.inria.phoenix.scenario.aleirbgenerale.impl.ComponentBinder;
import fr.inria.phoenix.scenario.aleirbgenerale.impl.Configuration;


public class AlEirbGeneraleTest {
		
	private InactivitySensorMock inactivitySensor;
	private TimerMock timerAlarm;
	private String timerId = Configuration.timerActiveAlarm;
	private String sensorId = Configuration.inactivitySensor;
	
	@Before
	public void setUp() throws Exception {
		underTest(ComponentBinder.class);
		
		timerAlarm = Mock.mockTimer(timerId);
		inactivitySensor = Mock.mockInactivitySensor(sensorId);
		
		Interaction Interaction = new Interaction(InteractionType.CLOSURE, sensorId, new Date(2017,10,27,12,0,0));
		inactivitySensor.setLastInteraction(Interaction);
	}

	@After
	public void tearDown() throws Exception {
		shutdown();
	}

	@Test
	public void testActivationAlarm() {
		System.out.println("TEST - Activation de l'alarm");
		inactivitySensor.inactivityLevel((float) 1);
		
		assertTrue(timerAlarm.expectPeriodicSchedule(timerId));
		assertTrue(HandleTimer.armed);
		
		//inactivitySensor.inactivityLevel((float) 0);
		//assertTrue(timerAlarm.expectCancel(timerId));
		//assertFalse(HandleTimer.armed);
		
		System.out.println("TEST - Complet");

	}
	
	/*
	@Test
	public void testElapsedTimer(){
		TimerMock timer2;
		timer2 = Mock.mockTimer(Configuration.timerActiveAlarm);
		timer2.timerTriggered("1000", "timer2");
		
		timer2.timerTriggered("3000", "timer2");
	}
	*/
}
