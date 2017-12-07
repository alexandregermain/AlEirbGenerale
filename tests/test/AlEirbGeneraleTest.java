package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static fr.inria.phoenix.diasuite.framework.mocks.Mock.shutdown;
import static fr.inria.phoenix.diasuite.framework.mocks.Mock.underTest;

import fr.inria.phoenix.diasuite.framework.datatype.date.Date;
import fr.inria.phoenix.diasuite.framework.datatype.interaction.Interaction;
import fr.inria.phoenix.diasuite.framework.datatype.interactiontype.InteractionType;
import fr.inria.phoenix.diasuite.framework.datatype.noncriticalnotification.NonCriticalNotification;
import fr.inria.phoenix.diasuite.framework.datatype.passwordupdating.PasswordUpdating;
import fr.inria.phoenix.diasuite.framework.datatype.updatingstep.UpdatingStep;
import fr.inria.phoenix.diasuite.framework.mocks.ContactSensorMock;
import fr.inria.phoenix.diasuite.framework.mocks.InactivitySensorMock;
import fr.inria.phoenix.diasuite.framework.mocks.LightMock;
import fr.inria.phoenix.diasuite.framework.mocks.Mock;
import fr.inria.phoenix.diasuite.framework.mocks.NotifierMock;
import fr.inria.phoenix.diasuite.framework.mocks.TimerMock;
import fr.inria.phoenix.scenario.aleirbgenerale.context.PasswordListener;
import fr.inria.phoenix.scenario.aleirbgenerale.context.UpdatePassword;
import fr.inria.phoenix.scenario.aleirbgenerale.controller.HandleTimer;
import fr.inria.phoenix.scenario.aleirbgenerale.impl.ComponentBinder;
import fr.inria.phoenix.scenario.aleirbgenerale.impl.Configuration;


public class AlEirbGeneraleTest {
		
	private InactivitySensorMock inactivitySensor;
	private TimerMock timerAlarm;
	private ContactSensorMock contactSensorRealisation, contactSensorA, contactSensorB;
	private NotifierMock notifier;
	private LightMock light;
	private String timerId = Configuration.delayBeforeAlert;
	private String sensorId = Configuration.inactivitySensor;
	private String notifierId = Configuration.notifier;
	private String location = "Maison";
	private String user = "Propriétaire";
	
	@Before
	public void setUp() throws Exception {
		Mock.TIMEOUT = 2000;
		underTest(ComponentBinder.class);
		
		timerAlarm = Mock.mockTimer(timerId);
		inactivitySensor = Mock.mockInactivitySensor(sensorId);
		
		Interaction Interaction = new Interaction(InteractionType.CLOSURE, sensorId, new Date(2017,10,27,12,0,0));
		inactivitySensor.setLastInteraction(Interaction);
		
		contactSensorRealisation = Mock.mockContactSensor("realisation", location, user);
		contactSensorA = Mock.mockContactSensor("A", location, user);
		contactSensorB = Mock.mockContactSensor("B", location, user);
		light = Mock.mockLight("LightAlarm", location, user);
		
		notifier = Mock.mockNotifier(notifierId);
	}

	@After
	public void tearDown() throws Exception {
		shutdown();
	}

	@Test
	public void testArmerAlarm() {
		System.out.println("TEST ----------- Armement de l'alarme ---------------");
		inactivitySensor.inactivityLevel((float) 0);
		
		assertTrue(timerAlarm.expectSchedule(timerId));
		assertTrue(HandleTimer.armed);
		
		System.out.println("TEST - Désarmement de l'alarme");
		inactivitySensor.inactivityLevel((float) 1);
		assertTrue(timerAlarm.expectCancel(timerId));
		assertFalse(HandleTimer.armed);
		
		System.out.println("TEST ----------------- Complet -------------------");

	}
	
	@Test
	public void testActivationAlarm() throws InterruptedException{
		System.out.println("TEST ------------ Activation de l'alarme ----------");
		
		inactivitySensor.setLastInteraction(new Interaction(InteractionType.CLOSURE, sensorId, new Date()));
		inactivitySensor.inactivityLevel((float) 0);
		timerAlarm.timerTriggered(Integer.toString(Configuration.timeDelay + 1000), Configuration.delayBeforeAlert);
		Thread.sleep(20);
		System.out.println("TEST - Notification Alarme");
		assertTrue(timerAlarm.expectSchedule(timerId));
		assertTrue(HandleTimer.armed);
		assertTrue(notifier.expectSendNonCriticalNotification());
	}
	@Test
	public void testDesactivationAlarm() throws InterruptedException{
		System.out.println("TEST - Desactivation de l'alarme");
		inactivitySensor.setLastInteraction(new Interaction(InteractionType.CLOSURE, sensorId, new Date()));
		inactivitySensor.inactivityLevel((float) 0);
		assertTrue(timerAlarm.expectSchedule(timerId));
		assertTrue(HandleTimer.armed);
		
		timerAlarm.timerTriggered("1000", Configuration.delayBeforeAlert);
		Thread.sleep(40);
		
		List<String> password = new ArrayList<String>();
		password.add("a");
		password.add("A");
		UpdatingStep step = UpdatingStep.INIT_UPDATING;
		UpdatePassword.passwordData = new PasswordUpdating(step , password);
		PasswordListener.passwordIter = password.listIterator();
		LightMock light = Mock.mockLight("a", "Maison", "user");

		
		Thread.sleep(20);
		light.on(true);
		Thread.sleep(20);
		contactSensorA.contact(true);
		Thread.sleep(40);
		assertTrue(timerAlarm.expectCancel());
		assertFalse(HandleTimer.armed);
		
		//assertFalse(notifier.expectSendNonCriticalNotification());
		System.out.println("TEST ----------------- Complet -------------------");
	}
	
	@Test
	public void testChangementMdpCorrect() throws InterruptedException {
		System.out.println("TEST - Changement de MDP => Success");
		//Mdp de changement de mdp
		contactSensorRealisation.contact(false);
		Thread.sleep(20);
		contactSensorRealisation.contact(true);
		Thread.sleep(20);
		contactSensorRealisation.contact(false);
		Thread.sleep(20);
		contactSensorRealisation.contact(true);
		Thread.sleep(20);
		contactSensorRealisation.contact(false);
		Thread.sleep(20);
		
		//MDP1
		//contactSensorA.contact(false);
		light.on(true);
		Thread.sleep(20);
		contactSensorA.contact(true);
		Thread.sleep(20);
		contactSensorB.contact(false);
		Thread.sleep(20);
		contactSensorB.contact(true);
		Thread.sleep(20);
		//Validation
		contactSensorRealisation.contact(true);
		Thread.sleep(20);
		contactSensorRealisation.contact(false);
		Thread.sleep(20);
		
		//MDP2
		light.on(true);
//		contactSensorA.contact(false);
		Thread.sleep(20);
		contactSensorA.contact(true);
		Thread.sleep(20);
		contactSensorB.contact(false);
		Thread.sleep(20);
		contactSensorB.contact(true);
		Thread.sleep(20);

		//Validation2
		contactSensorRealisation.contact(true);
		Thread.sleep(20);
		NonCriticalNotification notification = new NonCriticalNotification("MDPChanged", "MDP Changed", "MDP CHANGED Successfully", null, false);
		assertTrue(notifier.expectSendNonCriticalNotification(notification));
		//assertTrue(UpdatePassword.passwordData.getStep().equals(UpdatingStep.END_UPDATING) );
		System.out.println("TEST - Complet");
	}
	
	@Test
	public void testChangementMdp2Incorrect() throws InterruptedException {
		System.out.println("TEST - FAILURE - MDP2 incorrecte");
		//Mdp de changement de mdp
		contactSensorRealisation.contact(false);
		Thread.sleep(20);
		contactSensorRealisation.contact(true);
		Thread.sleep(20);
		contactSensorRealisation.contact(false);
		Thread.sleep(20);
		contactSensorRealisation.contact(true);
		Thread.sleep(20);
		contactSensorRealisation.contact(false);
		Thread.sleep(20);
		
		//MDP1
		contactSensorA.contact(false);
		Thread.sleep(20);
		contactSensorA.contact(true);
		Thread.sleep(20);
		contactSensorB.contact(false);
		Thread.sleep(20);
		contactSensorB.contact(true);
		Thread.sleep(20);
		//Validation
		contactSensorRealisation.contact(true);
		Thread.sleep(20);
		contactSensorRealisation.contact(false);
		Thread.sleep(20);
		
		//MDP2
		contactSensorA.contact(false);
		Thread.sleep(20);
		contactSensorB.contact(false);
		Thread.sleep(20);
		
		assertTrue(UpdatePassword.passwordData.getStep().equals(UpdatingStep.WRONG_PASSWORD) );
		System.out.println("TEST - Complet");
	}
	@Test
	public void testChangementValidationMdp1Incorrect() throws InterruptedException {
		System.out.println("TEST - Changement de MDP Oublie de rouvrir le tiroir pour PWD2 => CANCEL");
		//Mdp de changement de mdp
		contactSensorRealisation.contact(false);Thread.sleep(20);contactSensorRealisation.contact(true);Thread.sleep(20);contactSensorRealisation.contact(false);Thread.sleep(20);contactSensorRealisation.contact(true);Thread.sleep(20);contactSensorRealisation.contact(false);Thread.sleep(20);
		//MDP1
		contactSensorA.contact(false);
		Thread.sleep(20);
		contactSensorA.contact(true);
		Thread.sleep(20);
		//Validation PW1 incorecte
		contactSensorRealisation.contact(true);
		Thread.sleep(20);
		//MDP2
		contactSensorA.contact(false);
		Thread.sleep(20);
		assertTrue(UpdatePassword.passwordData.getStep().equals(UpdatingStep.CANCEL_UPDATING) );
		System.out.println("TEST - Complet");
	}
		@Test
		public void testMDPValidationIncorrect() throws InterruptedException {
		System.out.println("TEST - Mot de passe validation incorrect trop court");
		//Mdp de changement de mdp
		contactSensorRealisation.contact(false);
		Thread.sleep(20);
		contactSensorRealisation.contact(true);
		Thread.sleep(20);
		contactSensorRealisation.contact(false);
		Thread.sleep(20);
		contactSensorRealisation.contact(true);
		Thread.sleep(20);
		
		//MDP1
		contactSensorA.contact(false);
		Thread.sleep(20);
		
		assertTrue(UpdatePassword.passwordData.getStep().equals(UpdatingStep.CANCEL_UPDATING) );
		System.out.println("TEST - Complet");
		
		System.out.println("TEST - Mot de passe validation incorrect trop long");
		//Mdp de changement de mdp
		contactSensorRealisation.contact(false);
		Thread.sleep(20);
		contactSensorRealisation.contact(true);
		Thread.sleep(20);
		contactSensorRealisation.contact(false);
		Thread.sleep(20);
		contactSensorRealisation.contact(true);
		Thread.sleep(20);
		contactSensorRealisation.contact(false);
		Thread.sleep(20);
		contactSensorRealisation.contact(true);
		Thread.sleep(20);
		
		assertTrue(UpdatePassword.passwordData.getStep().equals(UpdatingStep.WRONG_PASSWORD) );
		System.out.println("TEST - Complet");
	}
		
}
