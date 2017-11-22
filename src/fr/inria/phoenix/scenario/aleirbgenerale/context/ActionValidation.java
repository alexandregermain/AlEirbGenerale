package fr.inria.phoenix.scenario.aleirbgenerale.context;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.phoenix.diasuite.framework.context.actionvalidation.AbstractActionValidation;
import fr.inria.phoenix.diasuite.framework.device.contactsensor.ContactFromContactSensor;
import fr.inria.phoenix.diasuite.framework.device.timer.TimerTriggeredFromTimer;

public class ActionValidation extends AbstractActionValidation {

	public ActionValidation(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ActionValidationValuePublishable onTimerTriggeredFromTimer(
			TimerTriggeredFromTimer timerTriggeredFromTimer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ActionValidationValuePublishable onContactFromContactSensor(
			ContactFromContactSensor contactFromContactSensor, DiscoverForContactFromContactSensor discover) {
		// TODO Auto-generated method stub
		return null;
	}

}
